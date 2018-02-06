package com.baidu.tieba.myAttentionAndFans;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class d extends b {
    private View.OnClickListener cKZ;
    boolean cra;
    boolean ecK;
    private View.OnClickListener fxP;
    private PersonListActivity fxp;
    private View.OnClickListener fxq;
    private int mSex;
    boolean fxo = false;
    private HashSet<Long> fxO = new HashSet<>();

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.fxp = null;
        this.cra = false;
        this.ecK = true;
        this.mSex = 0;
        this.fxP = null;
        this.fxq = null;
        this.cKZ = null;
        this.fxp = personListActivity;
        this.cra = z;
        this.ecK = z2;
        this.mSex = i;
        this.fxP = onClickListener2;
        this.fxq = onClickListener3;
        this.cKZ = onClickListener;
        this.aSi = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(aq aqVar) {
        ArrayList arrayList = new ArrayList();
        if (this.aSi.isEmpty() && !v.E(aqVar.yC())) {
            Iterator<UserData> it = aqVar.yC().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.fxO.add(Long.valueOf(com.baidu.adp.lib.g.b.c(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(aqVar.yC());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(af(aqVar.yB()));
        this.aSi.addAll(arrayList);
    }

    private ArrayList<UserData> af(ArrayList<UserData> arrayList) {
        if (!v.E(arrayList) && !this.fxO.isEmpty()) {
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.fxO.contains(Long.valueOf(com.baidu.adp.lib.g.b.c(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fxo) {
            return 1;
        }
        int i = 0;
        if (this.aSi != null) {
            i = this.aSi.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aSi == null || i >= this.aSi.size()) {
            return null;
        }
        return this.aSi.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.aSi == null || i >= this.aSi.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (this.aSi != null) {
            if (view == null || !(view.getTag() instanceof a)) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.fxp.getPageContext().getPageActivity()).inflate(d.h.person_list_item, (ViewGroup) null);
                    aVar2.cif = (ViewGroup) inflate.findViewById(d.g.item_view);
                    aVar2.cif.setOnClickListener(this.cKZ);
                    aVar2.cii = (ClickableHeaderImageView) inflate.findViewById(d.g.photo);
                    aVar2.cii.setRadius(l.t(this.fxp.getPageContext().getPageActivity(), d.e.ds90));
                    aVar2.cii.setAutoChangeStyle(true);
                    aVar2.cii.setClickable(false);
                    aVar2.cik = (LinearLayout) inflate.findViewById(d.g.info);
                    aVar2.bcD = (LinearLayout) inflate.findViewById(d.g.tail_container);
                    aVar2.mName = (TextView) inflate.findViewById(d.g.name);
                    aVar2.fxs = com.baidu.tbadk.ala.b.vL().u(this.fxp.getPageContext().getPageActivity(), 5);
                    if (aVar2.fxs != null) {
                        aVar2.fxs.setVisibility(8);
                        aVar2.bcD.addView(aVar2.fxs, 1);
                    }
                    aVar2.fxv = (TextView) inflate.findViewById(d.g.at_list_nodata);
                    aVar2.cij = (TextView) inflate.findViewById(d.g.intro);
                    aVar2.fxR = (TextView) inflate.findViewById(d.g.chat);
                    aVar2.fxR.setOnClickListener(this.fxP);
                    aVar2.fxt = (MyFansUserLikeButton) inflate.findViewById(d.g.attention_btn);
                    aVar2.fxt.setContext(this.fxp.getPageContext());
                    aVar2.cWj = new com.baidu.tbadk.core.view.userLike.c(this.fxp.getPageContext(), aVar2.fxt);
                    aVar2.mProgress = null;
                    aVar2.mTitle = null;
                    aVar2.fxS = null;
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    View inflate2 = LayoutInflater.from(this.fxp.getPageContext().getPageActivity()).inflate(d.h.person_list_newheader, (ViewGroup) null);
                    aVar2.mTitle = (TextView) inflate2.findViewById(d.g.person_list_title);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.mTitle.getLayoutParams();
                    layoutParams.height = l.t(TbadkCoreApplication.getInst(), d.e.ds16);
                    aVar2.mTitle.setLayoutParams(layoutParams);
                    aVar2.fxS = (LinearLayout) inflate2.findViewById(d.g.newheader_root);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.fxp.getPageContext().getPageActivity()).inflate(d.h.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate3.findViewById(d.g.pb_more_text);
                    inflate3.setOnClickListener(this.fxq);
                    aVar2.mProgress = (ProgressBar) inflate3.findViewById(d.g.progress);
                    aVar2.mTitle = null;
                    aVar2.fxS = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.fxt != null) {
                aVar.fxt.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.fxo) {
                    aVar.cik.setVisibility(8);
                    aVar.fxR.setVisibility(8);
                    aVar.fxv.setVisibility(0);
                    if (this.cra) {
                        if (this.ecK) {
                            aVar.fxv.setText(d.j.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.fxv.setText(d.j.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.fxv.setText(d.j.him_no_attention_other);
                        } else {
                            aVar.fxv.setText(d.j.no_attention_other);
                        }
                    } else if (this.ecK) {
                        aVar.fxv.setText(d.j.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.fxv.setText(d.j.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.fxv.setText(d.j.him_no_fan_other);
                    } else {
                        aVar.fxv.setText(d.j.no_fan_other);
                    }
                } else {
                    UserData userData = (UserData) v.f(this.aSi, i);
                    if (userData == null) {
                        return null;
                    }
                    aVar.cif.setTag(Integer.valueOf(i));
                    aVar.fxR.setVisibility(0);
                    aVar.fxv.setVisibility(8);
                    aVar.cii.setShowV(userData.isBigV());
                    aVar.cii.startLoad(userData.getPortrait(), 12, false);
                    aVar.mName.setText(userData.getName_show());
                    if (aVar.fxs != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            aVar.fxs.setVisibility(8);
                        } else {
                            aVar.fxs.setVisibility(0);
                            com.baidu.tbadk.ala.a aVar3 = new com.baidu.tbadk.ala.a();
                            aVar3.aHe = userData.getAlaUserData();
                            aVar3.type = 5;
                            aVar.fxs.setTag(aVar3);
                        }
                    }
                    if (am.isEmpty(userData.getIntro())) {
                        aVar.cij.setVisibility(8);
                    } else {
                        aVar.cij.setVisibility(0);
                        aVar.cij.setText(userData.getIntro());
                    }
                    aVar.fxR.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    aVar.fxt.Y(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    aVar.cWj.a(userData);
                    aVar.cWj.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.d.1
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void bA(boolean z) {
                            if (z) {
                                l.showToast(d.this.fxp, d.j.attention_success);
                            } else {
                                l.showToast(d.this.fxp, d.j.unfollow_success);
                            }
                        }
                    });
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        aVar.fxt.setVisibility(8);
                        aVar.fxR.setVisibility(8);
                    } else {
                        aVar.fxR.setVisibility(8);
                        aVar.fxt.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else if (getItemViewType(i) != 2) {
                aVar.mName.setText(this.fxp.getPageContext().getString(d.j.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
            return view;
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.fxp.getLayoutMode().aQ(skinType == 1);
        this.fxp.getLayoutMode().aM(view);
        if (aVar != null) {
            if (aVar.fxR != null) {
                aj.e(aVar.fxR, d.C0140d.btn_forum_focus_color, 1);
                aj.s(aVar.fxR, d.f.btn_focus_border_bg);
                aVar.fxR.setEnabled(true);
            }
            if (aVar.fxS != null && aVar.mTitle != null) {
                aj.t(aVar.fxS, d.C0140d.cp_bg_line_e);
                aj.r(aVar.mTitle, d.C0140d.cp_cont_e);
            }
            if (aVar.fxt != null) {
                aVar.fxt.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fxo) {
            return 0;
        }
        if (this.aSi == null || i >= this.aSi.size()) {
            return 1;
        }
        return this.aSi.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fxo) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        LinearLayout bcD;
        com.baidu.tbadk.core.view.userLike.c cWj;
        ViewGroup cif;
        ClickableHeaderImageView cii;
        TextView cij;
        LinearLayout cik;
        TextView fxR;
        LinearLayout fxS;
        View fxs;
        MyFansUserLikeButton fxt;
        TextView fxv;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
