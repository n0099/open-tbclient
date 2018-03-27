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
    private View.OnClickListener cKQ;
    boolean ecO;
    private PersonListActivity fxt;
    private View.OnClickListener fxu;
    private int mSex;

    public c(PersonListActivity personListActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.fxt = null;
        this.ecO = true;
        this.mSex = 0;
        this.fxu = null;
        this.cKQ = null;
        this.fxt = personListActivity;
        this.ecO = z;
        this.mSex = i;
        this.fxu = onClickListener2;
        this.cKQ = onClickListener;
        this.aRZ = new ArrayList<>();
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
            if (this.aRZ == null) {
                this.aRZ = new ArrayList<>();
            }
            arrayList.addAll(aqVar.yB());
            if (!v.E(this.aRZ) && this.aRZ.get(this.aRZ.size() - 1) != null && this.aRZ.get(this.aRZ.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                this.aRZ.get(this.aRZ.size() - 1).isLastNewFan = true;
            } else {
                for (int i = 0; i < arrayList.size() - 1; i++) {
                    UserData userData = (UserData) arrayList.get(i);
                    UserData userData2 = (UserData) arrayList.get(i + 1);
                    if (userData != null && userData2 != null && userData.isNewFan && !userData2.isNewFan) {
                        userData.isLastNewFan = true;
                    }
                }
            }
            if (v.E(this.aRZ) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                UserData userData3 = new UserData();
                userData3.mAttentionType = 0;
                arrayList.add(0, userData3);
            }
            this.aRZ.addAll(arrayList);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fxs) {
            return 1;
        }
        int i = 0;
        if (this.aRZ != null) {
            i = this.aRZ.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aRZ == null || i >= this.aRZ.size()) {
            return null;
        }
        return this.aRZ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.aRZ == null || i >= this.aRZ.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.aRZ != null) {
            int itemViewType = getItemViewType(i);
            if (view == null || !(view.getTag() instanceof a)) {
                aVar = new a();
                if (itemViewType == 0) {
                    View inflate = LayoutInflater.from(this.fxt.getPageContext().getPageActivity()).inflate(d.h.person_list_item, (ViewGroup) null);
                    aVar.chV = (ViewGroup) inflate.findViewById(d.g.item_view);
                    aVar.chV.setOnClickListener(this.cKQ);
                    aVar.chY = (ClickableHeaderImageView) inflate.findViewById(d.g.photo);
                    aVar.chY.setRadius(l.t(this.fxt.getPageContext().getPageActivity(), d.e.ds90));
                    aVar.chY.setAutoChangeStyle(true);
                    aVar.chY.setClickable(false);
                    ((LinearLayout.LayoutParams) aVar.chY.getLayoutParams()).setMargins(l.t(this.fxt, d.e.ds34), 0, 0, 0);
                    aVar.cia = (LinearLayout) inflate.findViewById(d.g.info);
                    aVar.bct = (LinearLayout) inflate.findViewById(d.g.tail_container);
                    aVar.mName = (TextView) inflate.findViewById(d.g.name);
                    aVar.fxw = com.baidu.tbadk.ala.b.vL().u(this.fxt.getPageContext().getPageActivity(), 5);
                    if (aVar.fxw != null) {
                        aVar.fxw.setVisibility(8);
                        aVar.bct.addView(aVar.fxw, 1);
                    }
                    aVar.fxz = (TextView) inflate.findViewById(d.g.at_list_nodata);
                    aVar.chZ = (TextView) inflate.findViewById(d.g.intro);
                    aVar.fxx = (MyFansUserLikeButton) inflate.findViewById(d.g.attention_btn);
                    aVar.fxx.setContext(this.fxt.getPageContext());
                    ((LinearLayout.LayoutParams) aVar.fxx.getLayoutParams()).setMargins(0, 0, l.t(this.fxt, d.e.ds34), 0);
                    aVar.cWa = new com.baidu.tbadk.core.view.userLike.c(this.fxt.getPageContext(), aVar.fxx);
                    aVar.cWa.a(this.aRZ.get(i));
                    aVar.cWa.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.c.1
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void bA(boolean z) {
                            if (z) {
                                l.showToast(c.this.fxt, d.j.attention_success);
                            } else {
                                l.showToast(c.this.fxt, d.j.unfollow_success);
                            }
                        }
                    });
                    aVar.mProgress = null;
                    aVar.mTitle = null;
                    aVar.fxy = (ImageView) inflate.findViewById(d.g.diver_buttom_px);
                    view2 = inflate;
                } else if (itemViewType == 2) {
                    View inflate2 = LayoutInflater.from(this.fxt.getPageContext().getPageActivity()).inflate(d.h.my_fan_list_title, (ViewGroup) null);
                    aVar.mTitle = (TextView) inflate2.findViewById(d.g.my_new_fan_title);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.fxt.getPageContext().getPageActivity()).inflate(d.h.new_pb_list_more, (ViewGroup) null);
                    aVar.mName = (TextView) inflate3.findViewById(d.g.pb_more_text);
                    inflate3.setOnClickListener(this.fxu);
                    aVar.mProgress = (ProgressBar) inflate3.findViewById(d.g.progress);
                    aVar.mTitle = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar);
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.fxx != null) {
                aVar.fxx.setTag(Integer.valueOf(i));
            }
            if (itemViewType == 0) {
                if (this.fxs) {
                    aVar.cia.setVisibility(8);
                    aVar.fxz.setVisibility(0);
                    if (this.ecO) {
                        aVar.fxz.setText(d.j.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.fxz.setText(d.j.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.fxz.setText(d.j.him_no_fan_other);
                    } else {
                        aVar.fxz.setText(d.j.no_fan_other);
                    }
                } else {
                    aVar.chV.setTag(Integer.valueOf(i));
                    UserData userData = (UserData) v.f(this.aRZ, i);
                    if (userData != null) {
                        aVar.fxz.setVisibility(8);
                        aVar.chY.setIsGod(userData.isBigV());
                        aVar.chY.startLoad(userData.getPortrait(), 12, false);
                        aVar.mName.setText(userData.getName_show());
                        if (aVar.fxw != null && userData.getAlaUserData() != null) {
                            if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                                aVar.fxw.setVisibility(8);
                            } else {
                                aVar.fxw.setVisibility(0);
                                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                                aVar2.aGU = userData.getAlaUserData();
                                aVar2.type = 5;
                                aVar.fxw.setTag(aVar2);
                            }
                        }
                        if (am.isEmpty(userData.getIntro())) {
                            aVar.chZ.setVisibility(8);
                        } else {
                            aVar.chZ.setVisibility(0);
                            aVar.chZ.setText(userData.getIntro());
                        }
                        String userId = userData.getUserId();
                        userData.setIsLike(userData.getHave_attention() > 0);
                        aVar.cWa.a(userData);
                        if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            aVar.fxx.setVisibility(8);
                        } else {
                            aVar.fxx.Y(2, userId);
                            aVar.cWa.setFromType("9");
                            aVar.fxx.setVisibility(0);
                        }
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.fxy.getLayoutParams();
                if (this.aRZ.get(i).isLastNewFan) {
                    layoutParams.height = l.t(this.fxt, d.e.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                } else {
                    layoutParams.height = l.t(this.fxt, d.e.ds1);
                    layoutParams.setMargins(l.t(this.fxt, d.e.ds34), 0, l.t(this.fxt, d.e.ds34), 0);
                }
                aVar.fxy.setLayoutParams(layoutParams);
                aVar.mProgress = null;
            } else if (itemViewType == 2) {
                aVar.mTitle.setText(d.j.new_fans);
                aVar.mTitle.setVisibility(0);
            } else {
                aVar.mName.setText(this.fxt.getPageContext().getString(d.j.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.fxt.getLayoutMode().aQ(skinType == 1);
        this.fxt.getLayoutMode().aM(view);
        if (aVar != null) {
            if (aVar.mTitle != null) {
                aj.r(aVar.mTitle, d.C0141d.cp_cont_d);
                aj.t(aVar.mTitle, d.C0141d.cp_bg_line_d);
            }
            if (aVar.fxy != null) {
                aj.c(aVar.fxy, d.C0141d.cp_bg_line_c);
            }
            if (aVar.fxx != null) {
                aVar.fxx.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fxs) {
            return 0;
        }
        if (this.aRZ == null || i >= this.aRZ.size()) {
            return 1;
        }
        return this.aRZ.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fxs) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        LinearLayout bct;
        com.baidu.tbadk.core.view.userLike.c cWa;
        ViewGroup chV;
        ClickableHeaderImageView chY;
        TextView chZ;
        LinearLayout cia;
        View fxw;
        MyFansUserLikeButton fxx;
        ImageView fxy;
        TextView fxz;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
