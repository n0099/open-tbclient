package com.baidu.tieba.myAttentionAndFans;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
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
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class c extends b {
    private View.OnClickListener cKZ;
    boolean ecK;
    private PersonListActivity fxp;
    private View.OnClickListener fxq;
    private int mSex;

    public c(PersonListActivity personListActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.fxp = null;
        this.ecK = true;
        this.mSex = 0;
        this.fxq = null;
        this.cKZ = null;
        this.fxp = personListActivity;
        this.ecK = z;
        this.mSex = i;
        this.fxq = onClickListener2;
        this.cKZ = onClickListener;
        this.aSi = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(aq aqVar) {
        if (aqVar != null && aqVar.yB() != null) {
            Iterator<UserData> it = aqVar.yB().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null) {
                    next.setIsLike(next.getHave_attention() > 0);
                }
            }
            ArrayList arrayList = new ArrayList();
            if (this.aSi == null) {
                this.aSi = new ArrayList<>();
            }
            arrayList.addAll(aqVar.yB());
            if (!v.E(this.aSi) && this.aSi.get(this.aSi.size() - 1) != null && this.aSi.get(this.aSi.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                this.aSi.get(this.aSi.size() - 1).isLastNewFan = true;
            } else {
                for (int i = 0; i < arrayList.size() - 1; i++) {
                    UserData userData = (UserData) arrayList.get(i);
                    UserData userData2 = (UserData) arrayList.get(i + 1);
                    if (userData != null && userData2 != null && userData.isNewFan && !userData2.isNewFan) {
                        userData.isLastNewFan = true;
                    }
                }
            }
            if (v.E(this.aSi) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                UserData userData3 = new UserData();
                userData3.mAttentionType = 0;
                arrayList.add(0, userData3);
            }
            this.aSi.addAll(arrayList);
        }
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
        a aVar;
        View view2;
        if (this.aSi != null) {
            int itemViewType = getItemViewType(i);
            if (view == null || !(view.getTag() instanceof a)) {
                aVar = new a();
                if (itemViewType == 0) {
                    View inflate = LayoutInflater.from(this.fxp.getPageContext().getPageActivity()).inflate(d.h.person_list_item, (ViewGroup) null);
                    aVar.cif = (ViewGroup) inflate.findViewById(d.g.item_view);
                    aVar.cif.setOnClickListener(this.cKZ);
                    aVar.cii = (ClickableHeaderImageView) inflate.findViewById(d.g.photo);
                    aVar.cii.setRadius(l.t(this.fxp.getPageContext().getPageActivity(), d.e.ds90));
                    aVar.cii.setAutoChangeStyle(true);
                    aVar.cii.setClickable(false);
                    ((LinearLayout.LayoutParams) aVar.cii.getLayoutParams()).setMargins(l.t(this.fxp, d.e.ds34), 0, 0, 0);
                    aVar.cik = (LinearLayout) inflate.findViewById(d.g.info);
                    aVar.bcD = (LinearLayout) inflate.findViewById(d.g.tail_container);
                    aVar.mName = (TextView) inflate.findViewById(d.g.name);
                    aVar.fxs = com.baidu.tbadk.ala.b.vL().u(this.fxp.getPageContext().getPageActivity(), 5);
                    if (aVar.fxs != null) {
                        aVar.fxs.setVisibility(8);
                        aVar.bcD.addView(aVar.fxs, 1);
                    }
                    aVar.fxv = (TextView) inflate.findViewById(d.g.at_list_nodata);
                    aVar.cij = (TextView) inflate.findViewById(d.g.intro);
                    aVar.fxt = (MyFansUserLikeButton) inflate.findViewById(d.g.attention_btn);
                    aVar.fxt.setContext(this.fxp.getPageContext());
                    ((LinearLayout.LayoutParams) aVar.fxt.getLayoutParams()).setMargins(0, 0, l.t(this.fxp, d.e.ds34), 0);
                    aVar.cWj = new com.baidu.tbadk.core.view.userLike.c(this.fxp.getPageContext(), aVar.fxt);
                    aVar.cWj.a(this.aSi.get(i));
                    aVar.cWj.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.c.1
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void bA(boolean z) {
                            if (z) {
                                l.showToast(c.this.fxp, d.j.attention_success);
                            } else {
                                l.showToast(c.this.fxp, d.j.unfollow_success);
                            }
                        }
                    });
                    aVar.mProgress = null;
                    aVar.mTitle = null;
                    aVar.fxu = (ImageView) inflate.findViewById(d.g.diver_buttom_px);
                    view2 = inflate;
                } else if (itemViewType == 2) {
                    View inflate2 = LayoutInflater.from(this.fxp.getPageContext().getPageActivity()).inflate(d.h.my_fan_list_title, (ViewGroup) null);
                    aVar.mTitle = (TextView) inflate2.findViewById(d.g.my_new_fan_title);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.fxp.getPageContext().getPageActivity()).inflate(d.h.new_pb_list_more, (ViewGroup) null);
                    aVar.mName = (TextView) inflate3.findViewById(d.g.pb_more_text);
                    inflate3.setOnClickListener(this.fxq);
                    aVar.mProgress = (ProgressBar) inflate3.findViewById(d.g.progress);
                    aVar.mTitle = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar);
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.fxt != null) {
                aVar.fxt.setTag(Integer.valueOf(i));
            }
            if (itemViewType == 0) {
                if (this.fxo) {
                    aVar.cik.setVisibility(8);
                    aVar.fxv.setVisibility(0);
                    if (this.ecK) {
                        aVar.fxv.setText(d.j.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.fxv.setText(d.j.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.fxv.setText(d.j.him_no_fan_other);
                    } else {
                        aVar.fxv.setText(d.j.no_fan_other);
                    }
                } else {
                    aVar.cif.setTag(Integer.valueOf(i));
                    UserData userData = (UserData) v.f(this.aSi, i);
                    if (userData != null) {
                        aVar.fxv.setVisibility(8);
                        aVar.cii.setIsGod(userData.isBigV());
                        aVar.cii.startLoad(userData.getPortrait(), 12, false);
                        aVar.mName.setText(userData.getName_show());
                        if (aVar.fxs != null && userData.getAlaUserData() != null) {
                            if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                                aVar.fxs.setVisibility(8);
                            } else {
                                aVar.fxs.setVisibility(0);
                                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                                aVar2.aHe = userData.getAlaUserData();
                                aVar2.type = 5;
                                aVar.fxs.setTag(aVar2);
                            }
                        }
                        if (am.isEmpty(userData.getIntro())) {
                            aVar.cij.setVisibility(8);
                        } else {
                            aVar.cij.setVisibility(0);
                            aVar.cij.setText(userData.getIntro());
                        }
                        String userId = userData.getUserId();
                        userData.setIsLike(userData.getHave_attention() > 0);
                        aVar.cWj.a(userData);
                        if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            aVar.fxt.setVisibility(8);
                        } else {
                            aVar.fxt.Y(2, userId);
                            aVar.cWj.setFromType("9");
                            aVar.fxt.setVisibility(0);
                        }
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.fxu.getLayoutParams();
                if (this.aSi.get(i).isLastNewFan) {
                    layoutParams.height = l.t(this.fxp, d.e.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                } else {
                    layoutParams.height = l.t(this.fxp, d.e.ds1);
                    layoutParams.setMargins(l.t(this.fxp, d.e.ds34), 0, l.t(this.fxp, d.e.ds34), 0);
                }
                aVar.fxu.setLayoutParams(layoutParams);
                aVar.mProgress = null;
            } else if (itemViewType == 2) {
                aVar.mTitle.setText(d.j.new_fans);
                aVar.mTitle.setVisibility(0);
            } else {
                aVar.mName.setText(this.fxp.getPageContext().getString(d.j.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.fxp.getLayoutMode().aQ(skinType == 1);
        this.fxp.getLayoutMode().aM(view);
        if (aVar != null) {
            if (aVar.mTitle != null) {
                aj.r(aVar.mTitle, d.C0140d.cp_cont_d);
                aj.t(aVar.mTitle, d.C0140d.cp_bg_line_d);
            }
            if (aVar.fxu != null) {
                aj.c(aVar.fxu, d.C0140d.cp_bg_line_c);
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
        View fxs;
        MyFansUserLikeButton fxt;
        ImageView fxu;
        TextView fxv;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
