package com.baidu.tieba.signall;

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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class o extends BaseAdapter implements AbsListView.OnScrollListener, ag {
    private boolean aIN;
    private b bQN;
    private SignAllForumActivity bRd;
    private ArrayList<d> Yr = new ArrayList<>();
    private HashMap<String, af> bRe = new HashMap<>();
    private boolean ayy = true;

    public o(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.bRd = signAllForumActivity;
    }

    public void b(b bVar) {
        if (bVar != null) {
            this.bQN = bVar;
            this.Yr = bVar.adz();
            if (this.Yr.size() == 0) {
                this.ayy = false;
            } else {
                this.ayy = true;
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
        if (this.ayy) {
            return this.Yr.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.Yr.size() > i) {
            return this.Yr.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View hG(int i) {
        if (i == 0) {
            View inflate = com.baidu.adp.lib.g.b.ei().inflate(this.bRd.getPageContext().getPageActivity(), com.baidu.tieba.x.signallforum_item, null);
            r rVar = new r(this);
            rVar.bRk = (BarImageView) inflate.findViewById(com.baidu.tieba.w.signallforum_item_avatar);
            rVar.bRk.setIsRound(false);
            rVar.bRk.setGifIconSupport(false);
            rVar.bRk.setSupportNoImage(false);
            rVar.bRm = (TextView) inflate.findViewById(com.baidu.tieba.w.signallforum_item_name);
            rVar.bRn = (TextView) inflate.findViewById(com.baidu.tieba.w.signallforum_item_level);
            rVar.bRo = (TextView) inflate.findViewById(com.baidu.tieba.w.signallforum_item_exp);
            rVar.bRp = (FrameLayout) inflate.findViewById(com.baidu.tieba.w.signallforum_item_res_container);
            rVar.bRq = (TextView) inflate.findViewById(com.baidu.tieba.w.signallforum_item_days);
            rVar.bRr = (RelativeLayout) inflate.findViewById(com.baidu.tieba.w.signallforum_item_resign_container);
            rVar.bRs = (ImageView) inflate.findViewById(com.baidu.tieba.w.signallforum_item_resign_icon);
            rVar.bRt = (ProgressBar) inflate.findViewById(com.baidu.tieba.w.signallforum_item_resign_progress);
            rVar.bRu = (TextView) inflate.findViewById(com.baidu.tieba.w.signallforum_item_resign_text);
            rVar.bRv = (TextView) inflate.findViewById(com.baidu.tieba.w.signallforum_item_error);
            rVar.bRl = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.signallforum_item_level_container);
            rVar.bRw = (TextView) inflate.findViewById(com.baidu.tieba.w.signallforum_item_increaseexp);
            inflate.setTag(rVar);
            return inflate;
        }
        View inflate2 = com.baidu.adp.lib.g.b.ei().inflate(this.bRd.getPageContext().getPageActivity(), com.baidu.tieba.x.signallforum_header, null);
        q qVar = new q(this);
        qVar.bRi = (TextView) inflate2.findViewById(com.baidu.tieba.w.signallforum_head_title);
        qVar.bRj = (TextView) inflate2.findViewById(com.baidu.tieba.w.signallforum_head_res);
        inflate2.setTag(qVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.bRd.getLayoutMode().ab(TbadkCoreApplication.m255getInst().getSkinType() == 1);
        this.bRd.getLayoutMode().h(view);
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
            rVar.bRm.setText(str);
            rVar.bRn.setText(new StringBuilder(String.valueOf(dVar.adM())).toString());
            bc.i((View) rVar.bRn, com.baidu.tbadk.core.util.d.bP(dVar.adM()));
            rVar.bRo.setText(String.valueOf(dVar.adN()) + "/" + dVar.adO());
            rVar.bRw.clearAnimation();
            if (dVar.adP()) {
                rVar.bRl.setVisibility(0);
                rVar.bRv.setVisibility(8);
                rVar.bRq.setVisibility(0);
                rVar.bRr.setVisibility(8);
                rVar.bRq.setText(String.format(this.bRd.getPageContext().getString(com.baidu.tieba.z.signallforum_days), Integer.valueOf(dVar.adL())));
                if (dVar.adT()) {
                    rVar.bRo.setText(this.bRd.getPageContext().getString(com.baidu.tieba.z.signallforum_uplevel));
                    rVar.bRw.setVisibility(8);
                } else {
                    rVar.bRo.setText(String.valueOf(dVar.adN()) + "/" + dVar.adO());
                    rVar.bRw.setVisibility(0);
                }
                int adS = dVar.adS();
                if (adS > 0) {
                    rVar.bRw.setVisibility(0);
                    rVar.bRw.setText("+" + adS);
                } else {
                    rVar.bRw.setVisibility(8);
                }
            } else if (dVar.adQ()) {
                String errorMsg = dVar.getErrorMsg();
                if (!TextUtils.isEmpty(errorMsg)) {
                    rVar.bRl.setVisibility(8);
                    rVar.bRv.setVisibility(0);
                    rVar.bRw.setVisibility(8);
                    rVar.bRv.setText(errorMsg);
                } else {
                    rVar.bRl.setVisibility(0);
                    rVar.bRv.setVisibility(8);
                    rVar.bRw.setVisibility(8);
                }
                rVar.bRq.setVisibility(8);
                rVar.bRr.setVisibility(0);
                if (dVar.adR()) {
                    rVar.bRs.setVisibility(4);
                    rVar.bRt.setVisibility(0);
                    rVar.bRu.setText(com.baidu.tieba.z.signallforum_resigning);
                } else {
                    rVar.bRs.setVisibility(0);
                    rVar.bRt.setVisibility(4);
                    rVar.bRu.setText(com.baidu.tieba.z.signallforum_resign);
                }
                rVar.bRr.setOnClickListener(new p(this, dVar, rVar));
            } else {
                rVar.bRq.setVisibility(8);
                rVar.bRr.setVisibility(8);
                rVar.bRw.setVisibility(8);
                rVar.bRl.setVisibility(0);
                rVar.bRv.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            rVar.bRk.setTag(avatar);
            rVar.bRk.d(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        q qVar;
        if (!this.ayy) {
            return Et();
        }
        int itemViewType = getItemViewType(i);
        View hG = view == null ? hG(itemViewType) : view;
        if (itemViewType == 1) {
            if (hG.getTag() != null && (hG.getTag() instanceof q)) {
                view2 = hG;
                qVar = (q) hG.getTag();
            } else {
                View hG2 = hG(itemViewType);
                view2 = hG2;
                qVar = (q) hG2.getTag();
            }
            this.bRd.getLayoutMode().ab(TbadkCoreApplication.m255getInst().getSkinType() == 1);
            this.bRd.getLayoutMode().h(view2.findViewById(com.baidu.tieba.w.sign_all_forum_tip));
            qVar.bRi.setText(((a) getItem(i)).getTitle());
            q(qVar.bRj, i);
            return view2;
        }
        if (hG.getTag() == null || !(hG.getTag() instanceof r)) {
            hG = hG(itemViewType);
        }
        a(hG, viewGroup, i);
        return hG;
    }

    private void q(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.bQN == null ? 7 : this.bQN.getLevel();
        if (this.Yr == null || this.Yr.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.Yr.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.adM() >= level) {
                        if (next.adP()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.adP()) {
                        i3++;
                    } else {
                        i2++;
                    }
                }
            }
        }
        if (i == 0 && i5 + i4 > 0) {
            format = String.format(this.bRd.getPageContext().getString(com.baidu.tieba.z.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.bRd.getPageContext().getString(com.baidu.tieba.z.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View Et() {
        View inflate = com.baidu.adp.lib.g.b.ei().inflate(this.bRd.getPageContext().getPageActivity(), com.baidu.tieba.x.sign_all_forum_nodata_item, null);
        com.baidu.tbadk.core.view.x a = NoDataViewFactory.a(this.bRd.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(com.baidu.tieba.w.sign_all_forum_no_data_view), com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.SINGALL, 0), com.baidu.tbadk.core.view.ab.t(com.baidu.tieba.z.sign_all_forum_nodata_tip, com.baidu.tieba.z.sign_all_forum_nodata_guide), null);
        int skinType = TbadkCoreApplication.m255getInst().getSkinType();
        this.bRd.getLayoutMode().ab(skinType == 1);
        this.bRd.getLayoutMode().h(inflate);
        a.onChangeSkinType(this.bRd.getPageContext(), skinType);
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

    @Override // com.baidu.tieba.signall.ag
    public void c(SignData signData) {
        String forumId = signData.getForumId();
        synchronized (this) {
            this.bRe.remove(forumId);
        }
        a(forumId, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.ag
    public void aP(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.adp.lib.util.l.showToast(this.bRd.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.bRe.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.Yr.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.Yr.get(i);
            if (new StringBuilder(String.valueOf(dVar.getForumId())).toString().equals(str)) {
                dVar.er(z);
                dVar.es(!z);
                dVar.et(false);
                if (z) {
                    dVar.hD(signData.getCountSignNum());
                    dVar.hF(signData.getBonusPoint());
                    dVar.hC(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.getBonusPoint(), -1);
                    ArrayList<d> adC = this.bQN.adC();
                    if (adC.contains(dVar)) {
                        adC.remove(dVar);
                        this.bQN.adB().add(dVar);
                    }
                } else {
                    dVar.setErrorMsg(str2);
                }
                if (!this.aIN) {
                    notifyDataSetChanged();
                    return;
                }
                return;
            }
        }
    }

    public void adX() {
        this.aIN = true;
        synchronized (this) {
            for (Map.Entry<String, af> entry : this.bRe.entrySet()) {
                entry.getValue().aeo();
            }
            this.bRe.clear();
        }
    }
}
