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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class c extends b {
    private View.OnClickListener cCH;
    boolean eeV;
    private PersonListActivity fxA;
    private View.OnClickListener fxB;
    private int mSex;

    public c(PersonListActivity personListActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.fxA = null;
        this.eeV = true;
        this.mSex = 0;
        this.fxB = null;
        this.cCH = null;
        this.fxA = personListActivity;
        this.eeV = z;
        this.mSex = i;
        this.fxB = onClickListener2;
        this.cCH = onClickListener;
        this.mData = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(aq aqVar) {
        if (aqVar != null && aqVar.xI() != null) {
            Iterator<UserData> it = aqVar.xI().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null) {
                    next.setIsLike(next.getHave_attention() > 0);
                }
            }
            ArrayList arrayList = new ArrayList();
            if (this.mData == null) {
                this.mData = new ArrayList<>();
            }
            arrayList.addAll(aqVar.xI());
            if (!v.J(this.mData) && this.mData.get(this.mData.size() - 1) != null && this.mData.get(this.mData.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                this.mData.get(this.mData.size() - 1).isLastNewFan = true;
            } else {
                for (int i = 0; i < arrayList.size() - 1; i++) {
                    UserData userData = (UserData) arrayList.get(i);
                    UserData userData2 = (UserData) arrayList.get(i + 1);
                    if (userData != null && userData2 != null && userData.isNewFan && !userData2.isNewFan) {
                        userData.isLastNewFan = true;
                    }
                }
            }
            if (v.J(this.mData) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                UserData userData3 = new UserData();
                userData3.mAttentionType = 0;
                arrayList.add(0, userData3);
            }
            this.mData.addAll(arrayList);
        }
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean cL(long j) {
        if (j == 0 || this.mData == null || this.mData.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.mData.iterator();
        while (it.hasNext()) {
            UserData next = it.next();
            if (next != null && next.getUserIdLong() == j) {
                this.mData.remove(next);
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fxz) {
            return 1;
        }
        int i = 0;
        if (this.mData != null) {
            i = this.mData.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mData == null || i >= this.mData.size()) {
            return null;
        }
        return this.mData.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.mData == null || i >= this.mData.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.mData != null) {
            int itemViewType = getItemViewType(i);
            if (view == null || !(view.getTag() instanceof a)) {
                aVar = new a();
                if (itemViewType == 0) {
                    View inflate = LayoutInflater.from(this.fxA.getPageContext().getPageActivity()).inflate(e.h.person_list_item, (ViewGroup) null);
                    aVar.bRq = (ViewGroup) inflate.findViewById(e.g.item_view);
                    aVar.bRq.setOnClickListener(this.cCH);
                    aVar.bRt = (ClickableHeaderImageView) inflate.findViewById(e.g.photo);
                    aVar.bRt.setRadius(l.h(this.fxA.getPageContext().getPageActivity(), e.C0175e.ds90));
                    aVar.bRt.setAutoChangeStyle(true);
                    aVar.bRt.setClickable(false);
                    ((LinearLayout.LayoutParams) aVar.bRt.getLayoutParams()).setMargins(l.h(this.fxA, e.C0175e.ds34), 0, 0, 0);
                    aVar.bRv = (LinearLayout) inflate.findViewById(e.g.info);
                    aVar.aDZ = (LinearLayout) inflate.findViewById(e.g.tail_container);
                    aVar.mName = (TextView) inflate.findViewById(e.g.name);
                    aVar.fxD = com.baidu.tbadk.ala.b.uL().j(this.fxA.getPageContext().getPageActivity(), 5);
                    if (aVar.fxD != null) {
                        aVar.fxD.setVisibility(8);
                        aVar.aDZ.addView(aVar.fxD, 1);
                    }
                    aVar.fxG = (TextView) inflate.findViewById(e.g.at_list_nodata);
                    aVar.bRu = (TextView) inflate.findViewById(e.g.intro);
                    aVar.fxE = (MyFansUserLikeButton) inflate.findViewById(e.g.attention_btn);
                    aVar.fxE.setContext(this.fxA.getPageContext());
                    ((LinearLayout.LayoutParams) aVar.fxE.getLayoutParams()).setMargins(0, 0, l.h(this.fxA, e.C0175e.ds34), 0);
                    aVar.cMA = new com.baidu.tbadk.core.view.userLike.c(this.fxA.getPageContext(), aVar.fxE);
                    aVar.cMA.a((com.baidu.tbadk.core.view.userLike.a) v.d(this.mData, i));
                    aVar.cMA.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.c.1
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void bt(boolean z) {
                            if (z) {
                                l.showToast(c.this.fxA, e.j.attention_success);
                            } else {
                                l.showToast(c.this.fxA, e.j.unfollow_success);
                            }
                        }
                    });
                    aVar.mProgress = null;
                    aVar.mTitle = null;
                    aVar.fxF = (ImageView) inflate.findViewById(e.g.diver_buttom_px);
                    view2 = inflate;
                } else if (itemViewType == 2) {
                    View inflate2 = LayoutInflater.from(this.fxA.getPageContext().getPageActivity()).inflate(e.h.my_fan_list_title, (ViewGroup) null);
                    aVar.mTitle = (TextView) inflate2.findViewById(e.g.my_new_fan_title);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.fxA.getPageContext().getPageActivity()).inflate(e.h.new_pb_list_more, (ViewGroup) null);
                    aVar.mName = (TextView) inflate3.findViewById(e.g.pb_more_text);
                    inflate3.setOnClickListener(this.fxB);
                    aVar.mProgress = (ProgressBar) inflate3.findViewById(e.g.progress);
                    aVar.mTitle = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar);
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.fxE != null) {
                aVar.fxE.setTag(Integer.valueOf(i));
            }
            if (itemViewType == 0) {
                if (this.fxz) {
                    aVar.bRv.setVisibility(8);
                    aVar.fxG.setVisibility(0);
                    if (this.eeV) {
                        aVar.fxG.setText(e.j.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.fxG.setText(e.j.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.fxG.setText(e.j.him_no_fan_other);
                    } else {
                        aVar.fxG.setText(e.j.no_fan_other);
                    }
                } else {
                    aVar.bRq.setTag(Integer.valueOf(i));
                    UserData userData = (UserData) v.d(this.mData, i);
                    if (userData != null) {
                        aVar.fxG.setVisibility(8);
                        aVar.bRt.setIsGod(userData.isBigV());
                        aVar.bRt.startLoad(userData.getPortrait(), 12, false);
                        aVar.mName.setText(userData.getName_show());
                        if (aVar.fxD != null && userData.getAlaUserData() != null) {
                            if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                                aVar.fxD.setVisibility(8);
                            } else {
                                aVar.fxD.setVisibility(0);
                                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                                aVar2.aht = userData.getAlaUserData();
                                aVar2.type = 5;
                                aVar.fxD.setTag(aVar2);
                            }
                        }
                        if (ao.isEmpty(userData.getIntro())) {
                            aVar.bRu.setVisibility(8);
                        } else {
                            aVar.bRu.setVisibility(0);
                            aVar.bRu.setText(userData.getIntro());
                        }
                        String userId = userData.getUserId();
                        userData.setIsLike(userData.getHave_attention() > 0);
                        aVar.cMA.a(userData);
                        if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            aVar.fxE.setVisibility(8);
                        } else {
                            aVar.fxE.setStatsParams(2, userId);
                            aVar.cMA.setFromType("9");
                            aVar.fxE.setVisibility(0);
                        }
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.fxF.getLayoutParams();
                if (v.d(this.mData, i) != null && ((UserData) v.d(this.mData, i)).isLastNewFan) {
                    layoutParams.height = l.h(this.fxA, e.C0175e.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                } else {
                    layoutParams.height = l.h(this.fxA, e.C0175e.ds1);
                    layoutParams.setMargins(l.h(this.fxA, e.C0175e.ds34), 0, l.h(this.fxA, e.C0175e.ds34), 0);
                }
                aVar.fxF.setLayoutParams(layoutParams);
                aVar.mProgress = null;
            } else if (itemViewType == 2) {
                aVar.mTitle.setText(e.j.new_fans);
                aVar.mTitle.setVisibility(0);
            } else {
                aVar.mName.setText(this.fxA.getPageContext().getString(e.j.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.fxA.getLayoutMode().setNightMode(skinType == 1);
        this.fxA.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.mTitle != null) {
                al.h(aVar.mTitle, e.d.cp_cont_d);
                al.j(aVar.mTitle, e.d.cp_bg_line_d);
            }
            if (aVar.fxF != null) {
                al.c(aVar.fxF, e.d.cp_bg_line_c);
            }
            if (aVar.fxE != null) {
                aVar.fxE.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fxz) {
            return 0;
        }
        if (this.mData == null || i >= this.mData.size()) {
            return 1;
        }
        return this.mData.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fxz) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        LinearLayout aDZ;
        ViewGroup bRq;
        ClickableHeaderImageView bRt;
        TextView bRu;
        LinearLayout bRv;
        com.baidu.tbadk.core.view.userLike.c cMA;
        View fxD;
        MyFansUserLikeButton fxE;
        ImageView fxF;
        TextView fxG;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
