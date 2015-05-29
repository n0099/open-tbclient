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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class o extends BaseAdapter implements AbsListView.OnScrollListener, ah {
    private c cia;
    private boolean cin;
    private SignAllForumActivity cis;
    private ArrayList<e> mDatas = new ArrayList<>();
    private HashMap<String, ag> cit = new HashMap<>();
    private boolean aIY = true;

    public o(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.cis = signAllForumActivity;
    }

    public void b(c cVar) {
        if (cVar != null) {
            this.cia = cVar;
            this.mDatas = cVar.akl();
            if (this.mDatas.size() == 0) {
                this.aIY = false;
            } else {
                this.aIY = true;
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i) instanceof b ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aIY) {
            return this.mDatas.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mDatas.size() > i) {
            return this.mDatas.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View iB(int i) {
        if (i == 0) {
            View inflate = com.baidu.adp.lib.g.b.hr().inflate(this.cis.getPageContext().getPageActivity(), com.baidu.tieba.r.signallforum_item, null);
            r rVar = new r(this);
            rVar.ciz = (BarImageView) inflate.findViewById(com.baidu.tieba.q.signallforum_item_avatar);
            rVar.ciz.setIsRound(false);
            rVar.ciz.setGifIconSupport(false);
            rVar.ciB = (TextView) inflate.findViewById(com.baidu.tieba.q.signallforum_item_name);
            rVar.ciC = (ImageView) inflate.findViewById(com.baidu.tieba.q.signallforum_item_level);
            rVar.ciD = (TextView) inflate.findViewById(com.baidu.tieba.q.signallforum_item_exp);
            rVar.ciE = (FrameLayout) inflate.findViewById(com.baidu.tieba.q.signallforum_item_res_container);
            rVar.ciF = (TextView) inflate.findViewById(com.baidu.tieba.q.signallforum_item_days);
            rVar.ciG = (RelativeLayout) inflate.findViewById(com.baidu.tieba.q.signallforum_item_resign_container);
            rVar.ciH = (ImageView) inflate.findViewById(com.baidu.tieba.q.signallforum_item_resign_icon);
            rVar.ciI = (ProgressBar) inflate.findViewById(com.baidu.tieba.q.signallforum_item_resign_progress);
            rVar.ciJ = (TextView) inflate.findViewById(com.baidu.tieba.q.signallforum_item_resign_text);
            rVar.ciK = (TextView) inflate.findViewById(com.baidu.tieba.q.signallforum_item_error);
            rVar.ciA = (LinearLayout) inflate.findViewById(com.baidu.tieba.q.signallforum_item_level_container);
            rVar.ciL = (TextView) inflate.findViewById(com.baidu.tieba.q.signallforum_item_increaseexp);
            inflate.setTag(rVar);
            return inflate;
        }
        View inflate2 = com.baidu.adp.lib.g.b.hr().inflate(this.cis.getPageContext().getPageActivity(), com.baidu.tieba.r.signallforum_header, null);
        q qVar = new q(this);
        qVar.cix = (TextView) inflate2.findViewById(com.baidu.tieba.q.signallforum_head_title);
        qVar.ciy = (TextView) inflate2.findViewById(com.baidu.tieba.q.signallforum_head_res);
        inflate2.setTag(qVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.cis.getLayoutMode().ab(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.cis.getLayoutMode().j(view);
        r rVar = (r) view.getTag();
        e eVar = (e) getItem(i);
        if (eVar != null) {
            String forumName = eVar.getForumName();
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
            rVar.ciB.setText(str);
            ay.c(rVar.ciC, com.baidu.tbadk.core.util.c.bU(eVar.aky()));
            rVar.ciD.setText(String.valueOf(eVar.akz()) + "/" + eVar.akA());
            rVar.ciL.clearAnimation();
            if (eVar.akB()) {
                rVar.ciA.setVisibility(0);
                rVar.ciK.setVisibility(8);
                rVar.ciF.setVisibility(0);
                rVar.ciG.setVisibility(8);
                rVar.ciF.setText(String.format(this.cis.getPageContext().getString(com.baidu.tieba.t.signallforum_days), Integer.valueOf(eVar.akx())));
                if (eVar.akF()) {
                    rVar.ciD.setText(this.cis.getPageContext().getString(com.baidu.tieba.t.signallforum_uplevel));
                    rVar.ciL.setVisibility(8);
                } else {
                    rVar.ciD.setText(String.valueOf(eVar.akz()) + "/" + eVar.akA());
                    rVar.ciL.setVisibility(0);
                }
                int akE = eVar.akE();
                if (akE > 0) {
                    rVar.ciL.setVisibility(0);
                    rVar.ciL.setText("+" + akE);
                } else {
                    rVar.ciL.setVisibility(8);
                }
            } else if (eVar.akC()) {
                String errorMsg = eVar.getErrorMsg();
                if (!TextUtils.isEmpty(errorMsg)) {
                    rVar.ciA.setVisibility(8);
                    rVar.ciK.setVisibility(0);
                    rVar.ciL.setVisibility(8);
                    rVar.ciK.setText(errorMsg);
                } else {
                    rVar.ciA.setVisibility(0);
                    rVar.ciK.setVisibility(8);
                    rVar.ciL.setVisibility(8);
                }
                rVar.ciF.setVisibility(8);
                rVar.ciG.setVisibility(0);
                if (eVar.akD()) {
                    rVar.ciH.setVisibility(4);
                    rVar.ciI.setVisibility(0);
                    rVar.ciJ.setText(com.baidu.tieba.t.signallforum_resigning);
                } else {
                    rVar.ciH.setVisibility(0);
                    rVar.ciI.setVisibility(4);
                    rVar.ciJ.setText(com.baidu.tieba.t.signallforum_resign);
                }
                rVar.ciG.setOnClickListener(new p(this, eVar, rVar));
            } else {
                rVar.ciF.setVisibility(8);
                rVar.ciG.setVisibility(8);
                rVar.ciL.setVisibility(8);
                rVar.ciA.setVisibility(0);
                rVar.ciK.setVisibility(8);
            }
            String avatar = eVar.getAvatar();
            rVar.ciz.setTag(avatar);
            rVar.ciz.c(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        q qVar;
        if (!this.aIY) {
            return Jz();
        }
        int itemViewType = getItemViewType(i);
        View iB = view == null ? iB(itemViewType) : view;
        if (itemViewType == 1) {
            if (iB.getTag() != null && (iB.getTag() instanceof q)) {
                view2 = iB;
                qVar = (q) iB.getTag();
            } else {
                View iB2 = iB(itemViewType);
                view2 = iB2;
                qVar = (q) iB2.getTag();
            }
            this.cis.getLayoutMode().ab(TbadkCoreApplication.m411getInst().getSkinType() == 1);
            this.cis.getLayoutMode().j(view2.findViewById(com.baidu.tieba.q.sign_all_forum_tip));
            qVar.cix.setText(((b) getItem(i)).getTitle());
            q(qVar.ciy, i);
            return view2;
        }
        if (iB.getTag() == null || !(iB.getTag() instanceof r)) {
            iB = iB(itemViewType);
        }
        a(iB, viewGroup, i);
        return iB;
    }

    private void q(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.cia == null ? 7 : this.cia.getLevel();
        if (this.mDatas == null || this.mDatas.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<e> it = this.mDatas.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                e next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.aky() >= level) {
                        if (next.akB()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.akB()) {
                        i3++;
                    } else {
                        i2++;
                    }
                }
            }
        }
        if (i == 0 && i5 + i4 > 0) {
            format = String.format(this.cis.getPageContext().getString(com.baidu.tieba.t.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.cis.getPageContext().getString(com.baidu.tieba.t.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View Jz() {
        View inflate = com.baidu.adp.lib.g.b.hr().inflate(this.cis.getPageContext().getPageActivity(), com.baidu.tieba.r.sign_all_forum_nodata_item, null);
        com.baidu.tbadk.core.view.x a = NoDataViewFactory.a(this.cis.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(com.baidu.tieba.q.sign_all_forum_no_data_view), com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.SINGALL, 0), com.baidu.tbadk.core.view.ab.s(com.baidu.tieba.t.sign_all_forum_nodata_tip, com.baidu.tieba.t.sign_all_forum_nodata_guide), null);
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.cis.getLayoutMode().ab(skinType == 1);
        this.cis.getLayoutMode().j(inflate);
        a.onChangeSkinType(this.cis.getPageContext(), skinType);
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

    @Override // com.baidu.tieba.signall.ah
    public void c(SignData signData) {
        String forumId = signData.getForumId();
        synchronized (this) {
            this.cit.remove(forumId);
        }
        a(forumId, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.ah
    public void aZ(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.adp.lib.util.n.showToast(this.cis.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.cit.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.mDatas.size();
        for (int i = 0; i < size; i++) {
            e eVar = this.mDatas.get(i);
            if (new StringBuilder(String.valueOf(eVar.getForumId())).toString().equals(str)) {
                eVar.eR(z);
                eVar.eS(!z);
                eVar.eT(false);
                if (z) {
                    eVar.iy(signData.getCountSignNum());
                    eVar.iA(signData.getBonusPoint());
                    eVar.ix(1);
                    TbadkApplication.getInst().addSignedForum(eVar.getForumName(), signData.getBonusPoint(), -1);
                    ArrayList<e> ako = this.cia.ako();
                    if (ako.contains(eVar)) {
                        ako.remove(eVar);
                        this.cia.akn().add(eVar);
                    }
                } else {
                    eVar.setErrorMsg(str2);
                }
                if (!this.cin) {
                    notifyDataSetChanged();
                    return;
                }
                return;
            }
        }
    }

    public void akI() {
        this.cin = true;
        synchronized (this) {
            for (Map.Entry<String, ag> entry : this.cit.entrySet()) {
                entry.getValue().akZ();
            }
            this.cit.clear();
        }
    }
}
