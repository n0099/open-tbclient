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
    private View.OnClickListener cKN;
    boolean ecy;
    private PersonListActivity fxd;
    private View.OnClickListener fxe;
    private int mSex;

    public c(PersonListActivity personListActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.fxd = null;
        this.ecy = true;
        this.mSex = 0;
        this.fxe = null;
        this.cKN = null;
        this.fxd = personListActivity;
        this.ecy = z;
        this.mSex = i;
        this.fxe = onClickListener2;
        this.cKN = onClickListener;
        this.aRX = new ArrayList<>();
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
            if (this.aRX == null) {
                this.aRX = new ArrayList<>();
            }
            arrayList.addAll(aqVar.yB());
            if (!v.E(this.aRX) && this.aRX.get(this.aRX.size() - 1) != null && this.aRX.get(this.aRX.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                this.aRX.get(this.aRX.size() - 1).isLastNewFan = true;
            } else {
                for (int i = 0; i < arrayList.size() - 1; i++) {
                    UserData userData = (UserData) arrayList.get(i);
                    UserData userData2 = (UserData) arrayList.get(i + 1);
                    if (userData != null && userData2 != null && userData.isNewFan && !userData2.isNewFan) {
                        userData.isLastNewFan = true;
                    }
                }
            }
            if (v.E(this.aRX) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                UserData userData3 = new UserData();
                userData3.mAttentionType = 0;
                arrayList.add(0, userData3);
            }
            this.aRX.addAll(arrayList);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fxc) {
            return 1;
        }
        int i = 0;
        if (this.aRX != null) {
            i = this.aRX.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aRX == null || i >= this.aRX.size()) {
            return null;
        }
        return this.aRX.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.aRX == null || i >= this.aRX.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.aRX != null) {
            int itemViewType = getItemViewType(i);
            if (view == null || !(view.getTag() instanceof a)) {
                aVar = new a();
                if (itemViewType == 0) {
                    View inflate = LayoutInflater.from(this.fxd.getPageContext().getPageActivity()).inflate(d.h.person_list_item, (ViewGroup) null);
                    aVar.chS = (ViewGroup) inflate.findViewById(d.g.item_view);
                    aVar.chS.setOnClickListener(this.cKN);
                    aVar.chV = (ClickableHeaderImageView) inflate.findViewById(d.g.photo);
                    aVar.chV.setRadius(l.t(this.fxd.getPageContext().getPageActivity(), d.e.ds90));
                    aVar.chV.setAutoChangeStyle(true);
                    aVar.chV.setClickable(false);
                    ((LinearLayout.LayoutParams) aVar.chV.getLayoutParams()).setMargins(l.t(this.fxd, d.e.ds34), 0, 0, 0);
                    aVar.chX = (LinearLayout) inflate.findViewById(d.g.info);
                    aVar.bcr = (LinearLayout) inflate.findViewById(d.g.tail_container);
                    aVar.mName = (TextView) inflate.findViewById(d.g.name);
                    aVar.fxg = com.baidu.tbadk.ala.b.vL().u(this.fxd.getPageContext().getPageActivity(), 5);
                    if (aVar.fxg != null) {
                        aVar.fxg.setVisibility(8);
                        aVar.bcr.addView(aVar.fxg, 1);
                    }
                    aVar.fxj = (TextView) inflate.findViewById(d.g.at_list_nodata);
                    aVar.chW = (TextView) inflate.findViewById(d.g.intro);
                    aVar.fxh = (MyFansUserLikeButton) inflate.findViewById(d.g.attention_btn);
                    aVar.fxh.setContext(this.fxd.getPageContext());
                    ((LinearLayout.LayoutParams) aVar.fxh.getLayoutParams()).setMargins(0, 0, l.t(this.fxd, d.e.ds34), 0);
                    aVar.cVX = new com.baidu.tbadk.core.view.userLike.c(this.fxd.getPageContext(), aVar.fxh);
                    aVar.cVX.a(this.aRX.get(i));
                    aVar.cVX.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.c.1
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void bA(boolean z) {
                            if (z) {
                                l.showToast(c.this.fxd, d.j.attention_success);
                            } else {
                                l.showToast(c.this.fxd, d.j.unfollow_success);
                            }
                        }
                    });
                    aVar.mProgress = null;
                    aVar.mTitle = null;
                    aVar.fxi = (ImageView) inflate.findViewById(d.g.diver_buttom_px);
                    view2 = inflate;
                } else if (itemViewType == 2) {
                    View inflate2 = LayoutInflater.from(this.fxd.getPageContext().getPageActivity()).inflate(d.h.my_fan_list_title, (ViewGroup) null);
                    aVar.mTitle = (TextView) inflate2.findViewById(d.g.my_new_fan_title);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.fxd.getPageContext().getPageActivity()).inflate(d.h.new_pb_list_more, (ViewGroup) null);
                    aVar.mName = (TextView) inflate3.findViewById(d.g.pb_more_text);
                    inflate3.setOnClickListener(this.fxe);
                    aVar.mProgress = (ProgressBar) inflate3.findViewById(d.g.progress);
                    aVar.mTitle = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar);
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.fxh != null) {
                aVar.fxh.setTag(Integer.valueOf(i));
            }
            if (itemViewType == 0) {
                if (this.fxc) {
                    aVar.chX.setVisibility(8);
                    aVar.fxj.setVisibility(0);
                    if (this.ecy) {
                        aVar.fxj.setText(d.j.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.fxj.setText(d.j.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.fxj.setText(d.j.him_no_fan_other);
                    } else {
                        aVar.fxj.setText(d.j.no_fan_other);
                    }
                } else {
                    aVar.chS.setTag(Integer.valueOf(i));
                    UserData userData = (UserData) v.f(this.aRX, i);
                    if (userData != null) {
                        aVar.fxj.setVisibility(8);
                        aVar.chV.setIsGod(userData.isBigV());
                        aVar.chV.startLoad(userData.getPortrait(), 12, false);
                        aVar.mName.setText(userData.getName_show());
                        if (aVar.fxg != null && userData.getAlaUserData() != null) {
                            if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                                aVar.fxg.setVisibility(8);
                            } else {
                                aVar.fxg.setVisibility(0);
                                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                                aVar2.aGT = userData.getAlaUserData();
                                aVar2.type = 5;
                                aVar.fxg.setTag(aVar2);
                            }
                        }
                        if (am.isEmpty(userData.getIntro())) {
                            aVar.chW.setVisibility(8);
                        } else {
                            aVar.chW.setVisibility(0);
                            aVar.chW.setText(userData.getIntro());
                        }
                        String userId = userData.getUserId();
                        userData.setIsLike(userData.getHave_attention() > 0);
                        aVar.cVX.a(userData);
                        if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            aVar.fxh.setVisibility(8);
                        } else {
                            aVar.fxh.Y(2, userId);
                            aVar.cVX.setFromType("9");
                            aVar.fxh.setVisibility(0);
                        }
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.fxi.getLayoutParams();
                if (this.aRX.get(i).isLastNewFan) {
                    layoutParams.height = l.t(this.fxd, d.e.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                } else {
                    layoutParams.height = l.t(this.fxd, d.e.ds1);
                    layoutParams.setMargins(l.t(this.fxd, d.e.ds34), 0, l.t(this.fxd, d.e.ds34), 0);
                }
                aVar.fxi.setLayoutParams(layoutParams);
                aVar.mProgress = null;
            } else if (itemViewType == 2) {
                aVar.mTitle.setText(d.j.new_fans);
                aVar.mTitle.setVisibility(0);
            } else {
                aVar.mName.setText(this.fxd.getPageContext().getString(d.j.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.fxd.getLayoutMode().aQ(skinType == 1);
        this.fxd.getLayoutMode().aM(view);
        if (aVar != null) {
            if (aVar.mTitle != null) {
                aj.r(aVar.mTitle, d.C0141d.cp_cont_d);
                aj.t(aVar.mTitle, d.C0141d.cp_bg_line_d);
            }
            if (aVar.fxi != null) {
                aj.c(aVar.fxi, d.C0141d.cp_bg_line_c);
            }
            if (aVar.fxh != null) {
                aVar.fxh.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fxc) {
            return 0;
        }
        if (this.aRX == null || i >= this.aRX.size()) {
            return 1;
        }
        return this.aRX.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fxc) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        LinearLayout bcr;
        com.baidu.tbadk.core.view.userLike.c cVX;
        ViewGroup chS;
        ClickableHeaderImageView chV;
        TextView chW;
        LinearLayout chX;
        View fxg;
        MyFansUserLikeButton fxh;
        ImageView fxi;
        TextView fxj;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
