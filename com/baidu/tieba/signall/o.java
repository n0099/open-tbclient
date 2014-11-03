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
    private boolean aFY;
    private b bKN;
    private Context mContext;
    private ArrayList<d> RP = new ArrayList<>();
    private HashMap<String, ad> bLd = new HashMap<>();
    private boolean auo = true;

    public o(Context context, TextView textView) {
        this.mContext = context;
    }

    public void b(b bVar) {
        if (bVar != null) {
            this.bKN = bVar;
            this.RP = bVar.acA();
            if (this.RP.size() == 0) {
                this.auo = false;
            } else {
                this.auo = true;
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
        if (this.auo) {
            return this.RP.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.RP.size() > i) {
            return this.RP.get(i);
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
            rVar.bLj = (BarImageView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_avatar);
            rVar.bLj.setIsRound(false);
            rVar.bLj.setGifIconSupport(false);
            rVar.bLl = (TextView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_name);
            rVar.bLm = (TextView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_level);
            rVar.bLn = (TextView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_exp);
            rVar.bLo = (FrameLayout) inflate.findViewById(com.baidu.tieba.v.signallforum_item_res_container);
            rVar.bLp = (TextView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_days);
            rVar.bLq = (RelativeLayout) inflate.findViewById(com.baidu.tieba.v.signallforum_item_resign_container);
            rVar.bLr = (ImageView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_resign_icon);
            rVar.bLs = (ProgressBar) inflate.findViewById(com.baidu.tieba.v.signallforum_item_resign_progress);
            rVar.bLt = (TextView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_resign_text);
            rVar.bLu = (TextView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_error);
            rVar.bLk = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.signallforum_item_level_container);
            rVar.bLv = (TextView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_increaseexp);
            inflate.setTag(rVar);
            return inflate;
        }
        View inflate2 = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.signallforum_header, null);
        q qVar = new q(this);
        qVar.bLh = (TextView) inflate2.findViewById(com.baidu.tieba.v.signallforum_head_title);
        qVar.bLi = (TextView) inflate2.findViewById(com.baidu.tieba.v.signallforum_head_res);
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
            rVar.bLl.setText(str);
            rVar.bLm.setText(new StringBuilder(String.valueOf(dVar.zB())).toString());
            aw.h((View) rVar.bLm, com.baidu.tbadk.core.util.d.bn(dVar.zB()));
            rVar.bLn.setText(String.valueOf(dVar.acN()) + "/" + dVar.acO());
            rVar.bLv.clearAnimation();
            if (dVar.acP()) {
                rVar.bLk.setVisibility(0);
                rVar.bLu.setVisibility(8);
                rVar.bLp.setVisibility(0);
                rVar.bLq.setVisibility(8);
                rVar.bLp.setText(String.format(this.mContext.getString(com.baidu.tieba.y.signallforum_days), Integer.valueOf(dVar.acM())));
                if (dVar.acT()) {
                    rVar.bLn.setText(this.mContext.getString(com.baidu.tieba.y.signallforum_uplevel));
                    rVar.bLv.setVisibility(8);
                } else {
                    rVar.bLn.setText(String.valueOf(dVar.acN()) + "/" + dVar.acO());
                    rVar.bLv.setVisibility(0);
                }
                int acS = dVar.acS();
                if (acS > 0) {
                    rVar.bLv.setVisibility(0);
                    rVar.bLv.setText("+" + acS);
                } else {
                    rVar.bLv.setVisibility(8);
                }
            } else if (dVar.acQ()) {
                String errorMsg = dVar.getErrorMsg();
                if (!TextUtils.isEmpty(errorMsg)) {
                    rVar.bLk.setVisibility(8);
                    rVar.bLu.setVisibility(0);
                    rVar.bLv.setVisibility(8);
                    rVar.bLu.setText(errorMsg);
                } else {
                    rVar.bLk.setVisibility(0);
                    rVar.bLu.setVisibility(8);
                    rVar.bLv.setVisibility(8);
                }
                rVar.bLp.setVisibility(8);
                rVar.bLq.setVisibility(0);
                if (dVar.acR()) {
                    rVar.bLr.setVisibility(4);
                    rVar.bLs.setVisibility(0);
                    rVar.bLt.setText(com.baidu.tieba.y.signallforum_resigning);
                } else {
                    rVar.bLr.setVisibility(0);
                    rVar.bLs.setVisibility(4);
                    rVar.bLt.setText(com.baidu.tieba.y.signallforum_resign);
                }
                rVar.bLq.setOnClickListener(new p(this, dVar, rVar));
            } else {
                rVar.bLp.setVisibility(8);
                rVar.bLq.setVisibility(8);
                rVar.bLv.setVisibility(8);
                rVar.bLk.setVisibility(0);
                rVar.bLu.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            rVar.bLj.setTag(avatar);
            rVar.bLj.c(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        q qVar;
        if (!this.auo) {
            return Dv();
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
            qVar.bLh.setText(((a) getItem(i)).getTitle());
            s(qVar.bLi, i);
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
        int level = this.bKN == null ? 7 : this.bKN.getLevel();
        if (this.RP == null || this.RP.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.RP.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.zB() >= level) {
                        if (next.acP()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.acP()) {
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

    private View Dv() {
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
            this.bLd.remove(forumId);
        }
        a(forumId, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.ae
    public void aC(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.adp.lib.util.m.showToast(this.mContext, str2);
        }
        synchronized (this) {
            this.bLd.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.RP.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.RP.get(i);
            if (new StringBuilder(String.valueOf(dVar.getForumId())).toString().equals(str)) {
                dVar.eD(z);
                dVar.eE(!z);
                dVar.eF(false);
                if (z) {
                    dVar.hl(signData.getCountSignNum());
                    dVar.hm(signData.getBonusPoint());
                    dVar.hk(1);
                    aj.wm().f(dVar.getForumName(), signData.getBonusPoint(), -1);
                    ArrayList<d> acD = this.bKN.acD();
                    if (acD.contains(dVar)) {
                        acD.remove(dVar);
                        this.bKN.acC().add(dVar);
                    }
                } else {
                    dVar.setErrorMsg(str2);
                }
                if (!this.aFY) {
                    notifyDataSetChanged();
                    return;
                }
                return;
            }
        }
    }

    public void acX() {
        this.aFY = true;
        synchronized (this) {
            for (Map.Entry<String, ad> entry : this.bLd.entrySet()) {
                entry.getValue().adm();
            }
            this.bLd.clear();
        }
    }
}
