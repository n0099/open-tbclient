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
    private boolean aIK;
    private b bQM;
    private SignAllForumActivity bRc;
    private ArrayList<d> Yo = new ArrayList<>();
    private HashMap<String, af> bRd = new HashMap<>();
    private boolean ayv = true;

    public o(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.bRc = signAllForumActivity;
    }

    public void b(b bVar) {
        if (bVar != null) {
            this.bQM = bVar;
            this.Yo = bVar.adu();
            if (this.Yo.size() == 0) {
                this.ayv = false;
            } else {
                this.ayv = true;
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
        if (this.ayv) {
            return this.Yo.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.Yo.size() > i) {
            return this.Yo.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View hG(int i) {
        if (i == 0) {
            View inflate = com.baidu.adp.lib.g.b.ei().inflate(this.bRc.getPageContext().getPageActivity(), com.baidu.tieba.x.signallforum_item, null);
            r rVar = new r(this);
            rVar.bRj = (BarImageView) inflate.findViewById(com.baidu.tieba.w.signallforum_item_avatar);
            rVar.bRj.setIsRound(false);
            rVar.bRj.setGifIconSupport(false);
            rVar.bRj.setSupportNoImage(false);
            rVar.bRl = (TextView) inflate.findViewById(com.baidu.tieba.w.signallforum_item_name);
            rVar.bRm = (TextView) inflate.findViewById(com.baidu.tieba.w.signallforum_item_level);
            rVar.bRn = (TextView) inflate.findViewById(com.baidu.tieba.w.signallforum_item_exp);
            rVar.bRo = (FrameLayout) inflate.findViewById(com.baidu.tieba.w.signallforum_item_res_container);
            rVar.bRp = (TextView) inflate.findViewById(com.baidu.tieba.w.signallforum_item_days);
            rVar.bRq = (RelativeLayout) inflate.findViewById(com.baidu.tieba.w.signallforum_item_resign_container);
            rVar.bRr = (ImageView) inflate.findViewById(com.baidu.tieba.w.signallforum_item_resign_icon);
            rVar.bRs = (ProgressBar) inflate.findViewById(com.baidu.tieba.w.signallforum_item_resign_progress);
            rVar.bRt = (TextView) inflate.findViewById(com.baidu.tieba.w.signallforum_item_resign_text);
            rVar.bRu = (TextView) inflate.findViewById(com.baidu.tieba.w.signallforum_item_error);
            rVar.bRk = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.signallforum_item_level_container);
            rVar.bRv = (TextView) inflate.findViewById(com.baidu.tieba.w.signallforum_item_increaseexp);
            inflate.setTag(rVar);
            return inflate;
        }
        View inflate2 = com.baidu.adp.lib.g.b.ei().inflate(this.bRc.getPageContext().getPageActivity(), com.baidu.tieba.x.signallforum_header, null);
        q qVar = new q(this);
        qVar.bRh = (TextView) inflate2.findViewById(com.baidu.tieba.w.signallforum_head_title);
        qVar.bRi = (TextView) inflate2.findViewById(com.baidu.tieba.w.signallforum_head_res);
        inflate2.setTag(qVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.bRc.getLayoutMode().ab(TbadkCoreApplication.m255getInst().getSkinType() == 1);
        this.bRc.getLayoutMode().h(view);
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
            rVar.bRl.setText(str);
            rVar.bRm.setText(new StringBuilder(String.valueOf(dVar.adH())).toString());
            bc.i((View) rVar.bRm, com.baidu.tbadk.core.util.d.bP(dVar.adH()));
            rVar.bRn.setText(String.valueOf(dVar.adI()) + "/" + dVar.adJ());
            rVar.bRv.clearAnimation();
            if (dVar.adK()) {
                rVar.bRk.setVisibility(0);
                rVar.bRu.setVisibility(8);
                rVar.bRp.setVisibility(0);
                rVar.bRq.setVisibility(8);
                rVar.bRp.setText(String.format(this.bRc.getPageContext().getString(com.baidu.tieba.z.signallforum_days), Integer.valueOf(dVar.adG())));
                if (dVar.adO()) {
                    rVar.bRn.setText(this.bRc.getPageContext().getString(com.baidu.tieba.z.signallforum_uplevel));
                    rVar.bRv.setVisibility(8);
                } else {
                    rVar.bRn.setText(String.valueOf(dVar.adI()) + "/" + dVar.adJ());
                    rVar.bRv.setVisibility(0);
                }
                int adN = dVar.adN();
                if (adN > 0) {
                    rVar.bRv.setVisibility(0);
                    rVar.bRv.setText("+" + adN);
                } else {
                    rVar.bRv.setVisibility(8);
                }
            } else if (dVar.adL()) {
                String errorMsg = dVar.getErrorMsg();
                if (!TextUtils.isEmpty(errorMsg)) {
                    rVar.bRk.setVisibility(8);
                    rVar.bRu.setVisibility(0);
                    rVar.bRv.setVisibility(8);
                    rVar.bRu.setText(errorMsg);
                } else {
                    rVar.bRk.setVisibility(0);
                    rVar.bRu.setVisibility(8);
                    rVar.bRv.setVisibility(8);
                }
                rVar.bRp.setVisibility(8);
                rVar.bRq.setVisibility(0);
                if (dVar.adM()) {
                    rVar.bRr.setVisibility(4);
                    rVar.bRs.setVisibility(0);
                    rVar.bRt.setText(com.baidu.tieba.z.signallforum_resigning);
                } else {
                    rVar.bRr.setVisibility(0);
                    rVar.bRs.setVisibility(4);
                    rVar.bRt.setText(com.baidu.tieba.z.signallforum_resign);
                }
                rVar.bRq.setOnClickListener(new p(this, dVar, rVar));
            } else {
                rVar.bRp.setVisibility(8);
                rVar.bRq.setVisibility(8);
                rVar.bRv.setVisibility(8);
                rVar.bRk.setVisibility(0);
                rVar.bRu.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            rVar.bRj.setTag(avatar);
            rVar.bRj.d(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        q qVar;
        if (!this.ayv) {
            return En();
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
            this.bRc.getLayoutMode().ab(TbadkCoreApplication.m255getInst().getSkinType() == 1);
            this.bRc.getLayoutMode().h(view2.findViewById(com.baidu.tieba.w.sign_all_forum_tip));
            qVar.bRh.setText(((a) getItem(i)).getTitle());
            q(qVar.bRi, i);
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
        int level = this.bQM == null ? 7 : this.bQM.getLevel();
        if (this.Yo == null || this.Yo.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.Yo.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.adH() >= level) {
                        if (next.adK()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.adK()) {
                        i3++;
                    } else {
                        i2++;
                    }
                }
            }
        }
        if (i == 0 && i5 + i4 > 0) {
            format = String.format(this.bRc.getPageContext().getString(com.baidu.tieba.z.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.bRc.getPageContext().getString(com.baidu.tieba.z.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View En() {
        View inflate = com.baidu.adp.lib.g.b.ei().inflate(this.bRc.getPageContext().getPageActivity(), com.baidu.tieba.x.sign_all_forum_nodata_item, null);
        com.baidu.tbadk.core.view.x a = NoDataViewFactory.a(this.bRc.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(com.baidu.tieba.w.sign_all_forum_no_data_view), com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.SINGALL, 0), com.baidu.tbadk.core.view.ab.t(com.baidu.tieba.z.sign_all_forum_nodata_tip, com.baidu.tieba.z.sign_all_forum_nodata_guide), null);
        int skinType = TbadkCoreApplication.m255getInst().getSkinType();
        this.bRc.getLayoutMode().ab(skinType == 1);
        this.bRc.getLayoutMode().h(inflate);
        a.onChangeSkinType(this.bRc.getPageContext(), skinType);
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
            this.bRd.remove(forumId);
        }
        a(forumId, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.ag
    public void aP(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.adp.lib.util.l.showToast(this.bRc.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.bRd.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.Yo.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.Yo.get(i);
            if (new StringBuilder(String.valueOf(dVar.getForumId())).toString().equals(str)) {
                dVar.er(z);
                dVar.es(!z);
                dVar.et(false);
                if (z) {
                    dVar.hD(signData.getCountSignNum());
                    dVar.hF(signData.getBonusPoint());
                    dVar.hC(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.getBonusPoint(), -1);
                    ArrayList<d> adx = this.bQM.adx();
                    if (adx.contains(dVar)) {
                        adx.remove(dVar);
                        this.bQM.adw().add(dVar);
                    }
                } else {
                    dVar.setErrorMsg(str2);
                }
                if (!this.aIK) {
                    notifyDataSetChanged();
                    return;
                }
                return;
            }
        }
    }

    public void adS() {
        this.aIK = true;
        synchronized (this) {
            for (Map.Entry<String, af> entry : this.bRd.entrySet()) {
                entry.getValue().aej();
            }
            this.bRd.clear();
        }
    }
}
