package com.baidu.tieba.signall;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.aj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class o extends BaseAdapter implements AbsListView.OnScrollListener, ae {
    private boolean aFO;
    private b bKy;
    private Context mContext;
    private ArrayList<d> RL = new ArrayList<>();
    private HashMap<String, ad> bKO = new HashMap<>();
    private boolean auf = true;

    public o(Context context, TextView textView) {
        this.mContext = context;
    }

    public void b(b bVar) {
        if (bVar != null) {
            this.bKy = bVar;
            this.RL = bVar.acx();
            if (this.RL.size() == 0) {
                this.auf = false;
            } else {
                this.auf = true;
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i) instanceof a ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.auf) {
            return this.RL.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.RL.size() > i) {
            return this.RL.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View hn(int i) {
        if (i == 0) {
            View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.signallforum_item, null);
            r rVar = new r(this);
            rVar.bKU = (BarImageView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_avatar);
            rVar.bKU.setIsRound(false);
            rVar.bKU.setGifIconSupport(false);
            rVar.bKW = (TextView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_name);
            rVar.bKX = (TextView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_level);
            rVar.bKY = (TextView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_exp);
            rVar.bKZ = (FrameLayout) inflate.findViewById(com.baidu.tieba.v.signallforum_item_res_container);
            rVar.bLa = (TextView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_days);
            rVar.bLb = (RelativeLayout) inflate.findViewById(com.baidu.tieba.v.signallforum_item_resign_container);
            rVar.bLc = (ImageView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_resign_icon);
            rVar.bLd = (ProgressBar) inflate.findViewById(com.baidu.tieba.v.signallforum_item_resign_progress);
            rVar.bLe = (TextView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_resign_text);
            rVar.bLf = (TextView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_error);
            rVar.bKV = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.signallforum_item_level_container);
            rVar.bLg = (TextView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_increaseexp);
            inflate.setTag(rVar);
            return inflate;
        }
        View inflate2 = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.signallforum_header, null);
        q qVar = new q(this);
        qVar.bKS = (TextView) inflate2.findViewById(com.baidu.tieba.v.signallforum_head_title);
        qVar.bKT = (TextView) inflate2.findViewById(com.baidu.tieba.v.signallforum_head_res);
        inflate2.setTag(qVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        BaseActivity baseActivity = (BaseActivity) this.mContext;
        baseActivity.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
        baseActivity.getLayoutMode().h(view);
        r rVar = (r) view.getTag();
        d dVar = (d) getItem(i);
        if (dVar != null) {
            String forumName = dVar.getForumName();
            if (forumName != null && forumName.length() > 8) {
                char[] charArray = forumName.toCharArray();
                int i2 = 0;
                for (int i3 = 0; i3 < charArray.length; i3++) {
                    if (StringUtils.isChinese(charArray[i3])) {
                        i2 += 2;
                    } else {
                        i2++;
                    }
                    if (i2 > 16) {
                        str = String.valueOf(forumName.substring(0, i3)) + "...";
                        break;
                    }
                }
            }
            str = forumName;
            rVar.bKW.setText(str);
            rVar.bKX.setText(new StringBuilder(String.valueOf(dVar.zz())).toString());
            aw.h((View) rVar.bKX, com.baidu.tbadk.core.util.d.bn(dVar.zz()));
            rVar.bKY.setText(String.valueOf(dVar.acK()) + "/" + dVar.acL());
            rVar.bLg.clearAnimation();
            if (dVar.acM()) {
                rVar.bKV.setVisibility(0);
                rVar.bLf.setVisibility(8);
                rVar.bLa.setVisibility(0);
                rVar.bLb.setVisibility(8);
                rVar.bLa.setText(String.format(this.mContext.getString(com.baidu.tieba.y.signallforum_days), Integer.valueOf(dVar.acJ())));
                if (dVar.acQ()) {
                    rVar.bKY.setText(this.mContext.getString(com.baidu.tieba.y.signallforum_uplevel));
                    rVar.bLg.setVisibility(8);
                } else {
                    rVar.bKY.setText(String.valueOf(dVar.acK()) + "/" + dVar.acL());
                    rVar.bLg.setVisibility(0);
                }
                int acP = dVar.acP();
                if (acP > 0) {
                    rVar.bLg.setVisibility(0);
                    rVar.bLg.setText("+" + acP);
                } else {
                    rVar.bLg.setVisibility(8);
                }
            } else if (dVar.acN()) {
                String errorMsg = dVar.getErrorMsg();
                if (!TextUtils.isEmpty(errorMsg)) {
                    rVar.bKV.setVisibility(8);
                    rVar.bLf.setVisibility(0);
                    rVar.bLg.setVisibility(8);
                    rVar.bLf.setText(errorMsg);
                } else {
                    rVar.bKV.setVisibility(0);
                    rVar.bLf.setVisibility(8);
                    rVar.bLg.setVisibility(8);
                }
                rVar.bLa.setVisibility(8);
                rVar.bLb.setVisibility(0);
                if (dVar.acO()) {
                    rVar.bLc.setVisibility(4);
                    rVar.bLd.setVisibility(0);
                    rVar.bLe.setText(com.baidu.tieba.y.signallforum_resigning);
                } else {
                    rVar.bLc.setVisibility(0);
                    rVar.bLd.setVisibility(4);
                    rVar.bLe.setText(com.baidu.tieba.y.signallforum_resign);
                }
                rVar.bLb.setOnClickListener(new p(this, dVar, rVar));
            } else {
                rVar.bLa.setVisibility(8);
                rVar.bLb.setVisibility(8);
                rVar.bLg.setVisibility(8);
                rVar.bKV.setVisibility(0);
                rVar.bLf.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            rVar.bKU.setTag(avatar);
            rVar.bKU.c(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        q qVar;
        if (!this.auf) {
            return Dt();
        }
        int itemViewType = getItemViewType(i);
        View hn = view == null ? hn(itemViewType) : view;
        if (itemViewType == 1) {
            if (hn.getTag() != null && (hn.getTag() instanceof q)) {
                view2 = hn;
                qVar = (q) hn.getTag();
            } else {
                View hn2 = hn(itemViewType);
                view2 = hn2;
                qVar = (q) hn2.getTag();
            }
            int skinType = TbadkApplication.m251getInst().getSkinType();
            BaseActivity baseActivity = (BaseActivity) this.mContext;
            baseActivity.getLayoutMode().L(skinType == 1);
            baseActivity.getLayoutMode().h(view2.findViewById(com.baidu.tieba.v.sign_all_forum_tip));
            qVar.bKS.setText(((a) getItem(i)).getTitle());
            s(qVar.bKT, i);
            return view2;
        }
        if (hn.getTag() == null || !(hn.getTag() instanceof r)) {
            hn = hn(itemViewType);
        }
        a(hn, viewGroup, i);
        return hn;
    }

    private void s(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.bKy == null ? 7 : this.bKy.getLevel();
        if (this.RL == null || this.RL.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.RL.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.zz() >= level) {
                        if (next.acM()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.acM()) {
                        i3++;
                    } else {
                        i2++;
                    }
                }
            }
        }
        if (i == 0 && i5 + i4 > 0) {
            format = String.format(this.mContext.getString(com.baidu.tieba.y.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.mContext.getString(com.baidu.tieba.y.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View Dt() {
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.sign_all_forum_nodata_item, null);
        com.baidu.tbadk.core.view.o a = NoDataViewFactory.a(this.mContext, (LinearLayout) inflate.findViewById(com.baidu.tieba.v.sign_all_forum_no_data_view), com.baidu.tbadk.core.view.r.a(NoDataViewFactory.ImgType.SINGALL, 0), com.baidu.tbadk.core.view.s.q(com.baidu.tieba.y.sign_all_forum_nodata_tip, com.baidu.tieba.y.sign_all_forum_nodata_guide), null);
        BaseActivity baseActivity = (BaseActivity) this.mContext;
        int skinType = TbadkApplication.m251getInst().getSkinType();
        baseActivity.getLayoutMode().L(skinType == 1);
        baseActivity.getLayoutMode().h(inflate);
        a.onChangeSkinType(skinType);
        a.setVisibility(0);
        return inflate;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // com.baidu.tieba.signall.ae
    public void d(SignData signData) {
        String forumId = signData.getForumId();
        synchronized (this) {
            this.bKO.remove(forumId);
        }
        a(forumId, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.ae
    public void aC(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.adp.lib.util.m.showToast(this.mContext, str2);
        }
        synchronized (this) {
            this.bKO.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.RL.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.RL.get(i);
            if (new StringBuilder(String.valueOf(dVar.getForumId())).toString().equals(str)) {
                dVar.eD(z);
                dVar.eE(!z);
                dVar.eF(false);
                if (z) {
                    dVar.hl(signData.getCountSignNum());
                    dVar.hm(signData.getBonusPoint());
                    dVar.hk(1);
                    aj.wk().f(dVar.getForumName(), signData.getBonusPoint(), -1);
                    ArrayList<d> acA = this.bKy.acA();
                    if (acA.contains(dVar)) {
                        acA.remove(dVar);
                        this.bKy.acz().add(dVar);
                    }
                } else {
                    dVar.setErrorMsg(str2);
                }
                if (!this.aFO) {
                    notifyDataSetChanged();
                    return;
                }
                return;
            }
        }
    }

    public void acU() {
        this.aFO = true;
        synchronized (this) {
            for (Map.Entry<String, ad> entry : this.bKO.entrySet()) {
                entry.getValue().adj();
            }
            this.bKO.clear();
        }
    }
}
