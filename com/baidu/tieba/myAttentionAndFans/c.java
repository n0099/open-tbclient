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
    private View.OnClickListener cue;
    boolean dXb;
    private PersonListActivity fpU;
    private View.OnClickListener fpV;
    private int mSex;

    public c(PersonListActivity personListActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.fpU = null;
        this.dXb = true;
        this.mSex = 0;
        this.fpV = null;
        this.cue = null;
        this.fpU = personListActivity;
        this.dXb = z;
        this.mSex = i;
        this.fpV = onClickListener2;
        this.cue = onClickListener;
        this.anX = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(aq aqVar) {
        if (aqVar != null && aqVar.vz() != null) {
            Iterator<UserData> it = aqVar.vz().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null) {
                    next.setIsLike(next.getHave_attention() > 0);
                }
            }
            ArrayList arrayList = new ArrayList();
            if (this.anX == null) {
                this.anX = new ArrayList<>();
            }
            arrayList.addAll(aqVar.vz());
            if (!v.z(this.anX) && this.anX.get(this.anX.size() - 1) != null && this.anX.get(this.anX.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                this.anX.get(this.anX.size() - 1).isLastNewFan = true;
            } else {
                for (int i = 0; i < arrayList.size() - 1; i++) {
                    UserData userData = (UserData) arrayList.get(i);
                    UserData userData2 = (UserData) arrayList.get(i + 1);
                    if (userData != null && userData2 != null && userData.isNewFan && !userData2.isNewFan) {
                        userData.isLastNewFan = true;
                    }
                }
            }
            if (v.z(this.anX) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                UserData userData3 = new UserData();
                userData3.mAttentionType = 0;
                arrayList.add(0, userData3);
            }
            this.anX.addAll(arrayList);
        }
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean cE(long j) {
        if (j == 0 || this.anX == null || this.anX.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.anX.iterator();
        while (it.hasNext()) {
            UserData next = it.next();
            if (next != null && next.getUserIdLong() == j) {
                this.anX.remove(next);
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fpT) {
            return 1;
        }
        int i = 0;
        if (this.anX != null) {
            i = this.anX.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.anX == null || i >= this.anX.size()) {
            return null;
        }
        return this.anX.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.anX == null || i >= this.anX.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.anX != null) {
            int itemViewType = getItemViewType(i);
            if (view == null || !(view.getTag() instanceof a)) {
                aVar = new a();
                if (itemViewType == 0) {
                    View inflate = LayoutInflater.from(this.fpU.getPageContext().getPageActivity()).inflate(e.h.person_list_item, (ViewGroup) null);
                    aVar.bIN = (ViewGroup) inflate.findViewById(e.g.item_view);
                    aVar.bIN.setOnClickListener(this.cue);
                    aVar.bIQ = (ClickableHeaderImageView) inflate.findViewById(e.g.photo);
                    aVar.bIQ.setRadius(l.h(this.fpU.getPageContext().getPageActivity(), e.C0141e.ds90));
                    aVar.bIQ.setAutoChangeStyle(true);
                    aVar.bIQ.setClickable(false);
                    ((LinearLayout.LayoutParams) aVar.bIQ.getLayoutParams()).setMargins(l.h(this.fpU, e.C0141e.ds34), 0, 0, 0);
                    aVar.bIS = (LinearLayout) inflate.findViewById(e.g.info);
                    aVar.azr = (LinearLayout) inflate.findViewById(e.g.tail_container);
                    aVar.mName = (TextView) inflate.findViewById(e.g.name);
                    aVar.fpX = com.baidu.tbadk.ala.b.sB().i(this.fpU.getPageContext().getPageActivity(), 5);
                    if (aVar.fpX != null) {
                        aVar.fpX.setVisibility(8);
                        aVar.azr.addView(aVar.fpX, 1);
                    }
                    aVar.fqa = (TextView) inflate.findViewById(e.g.at_list_nodata);
                    aVar.bIR = (TextView) inflate.findViewById(e.g.intro);
                    aVar.fpY = (MyFansUserLikeButton) inflate.findViewById(e.g.attention_btn);
                    aVar.fpY.setContext(this.fpU.getPageContext());
                    ((LinearLayout.LayoutParams) aVar.fpY.getLayoutParams()).setMargins(0, 0, l.h(this.fpU, e.C0141e.ds34), 0);
                    aVar.cEg = new com.baidu.tbadk.core.view.userLike.c(this.fpU.getPageContext(), aVar.fpY);
                    aVar.cEg.a((com.baidu.tbadk.core.view.userLike.a) v.d(this.anX, i));
                    aVar.cEg.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.c.1
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void bj(boolean z) {
                            if (z) {
                                l.showToast(c.this.fpU, e.j.attention_success);
                            } else {
                                l.showToast(c.this.fpU, e.j.unfollow_success);
                            }
                        }
                    });
                    aVar.mProgress = null;
                    aVar.mTitle = null;
                    aVar.fpZ = (ImageView) inflate.findViewById(e.g.diver_buttom_px);
                    view2 = inflate;
                } else if (itemViewType == 2) {
                    View inflate2 = LayoutInflater.from(this.fpU.getPageContext().getPageActivity()).inflate(e.h.my_fan_list_title, (ViewGroup) null);
                    aVar.mTitle = (TextView) inflate2.findViewById(e.g.my_new_fan_title);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.fpU.getPageContext().getPageActivity()).inflate(e.h.new_pb_list_more, (ViewGroup) null);
                    aVar.mName = (TextView) inflate3.findViewById(e.g.pb_more_text);
                    inflate3.setOnClickListener(this.fpV);
                    aVar.mProgress = (ProgressBar) inflate3.findViewById(e.g.progress);
                    aVar.mTitle = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar);
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.fpY != null) {
                aVar.fpY.setTag(Integer.valueOf(i));
            }
            if (itemViewType == 0) {
                if (this.fpT) {
                    aVar.bIS.setVisibility(8);
                    aVar.fqa.setVisibility(0);
                    if (this.dXb) {
                        aVar.fqa.setText(e.j.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.fqa.setText(e.j.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.fqa.setText(e.j.him_no_fan_other);
                    } else {
                        aVar.fqa.setText(e.j.no_fan_other);
                    }
                } else {
                    aVar.bIN.setTag(Integer.valueOf(i));
                    UserData userData = (UserData) v.d(this.anX, i);
                    if (userData != null) {
                        aVar.fqa.setVisibility(8);
                        aVar.bIQ.setIsGod(userData.isBigV());
                        aVar.bIQ.startLoad(userData.getPortrait(), 12, false);
                        aVar.mName.setText(userData.getName_show());
                        if (aVar.fpX != null && userData.getAlaUserData() != null) {
                            if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                                aVar.fpX.setVisibility(8);
                            } else {
                                aVar.fpX.setVisibility(0);
                                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                                aVar2.acu = userData.getAlaUserData();
                                aVar2.type = 5;
                                aVar.fpX.setTag(aVar2);
                            }
                        }
                        if (ao.isEmpty(userData.getIntro())) {
                            aVar.bIR.setVisibility(8);
                        } else {
                            aVar.bIR.setVisibility(0);
                            aVar.bIR.setText(userData.getIntro());
                        }
                        String userId = userData.getUserId();
                        userData.setIsLike(userData.getHave_attention() > 0);
                        aVar.cEg.a(userData);
                        if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            aVar.fpY.setVisibility(8);
                        } else {
                            aVar.fpY.setStatsParams(2, userId);
                            aVar.cEg.setFromType("9");
                            aVar.fpY.setVisibility(0);
                        }
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.fpZ.getLayoutParams();
                if (v.d(this.anX, i) != null && ((UserData) v.d(this.anX, i)).isLastNewFan) {
                    layoutParams.height = l.h(this.fpU, e.C0141e.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                } else {
                    layoutParams.height = l.h(this.fpU, e.C0141e.ds1);
                    layoutParams.setMargins(l.h(this.fpU, e.C0141e.ds34), 0, l.h(this.fpU, e.C0141e.ds34), 0);
                }
                aVar.fpZ.setLayoutParams(layoutParams);
                aVar.mProgress = null;
            } else if (itemViewType == 2) {
                aVar.mTitle.setText(e.j.new_fans);
                aVar.mTitle.setVisibility(0);
            } else {
                aVar.mName.setText(this.fpU.getPageContext().getString(e.j.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.fpU.getLayoutMode().setNightMode(skinType == 1);
        this.fpU.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.mTitle != null) {
                al.h(aVar.mTitle, e.d.cp_cont_d);
                al.j(aVar.mTitle, e.d.cp_bg_line_d);
            }
            if (aVar.fpZ != null) {
                al.c(aVar.fpZ, e.d.cp_bg_line_c);
            }
            if (aVar.fpY != null) {
                aVar.fpY.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fpT) {
            return 0;
        }
        if (this.anX == null || i >= this.anX.size()) {
            return 1;
        }
        return this.anX.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fpT) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        LinearLayout azr;
        ViewGroup bIN;
        ClickableHeaderImageView bIQ;
        TextView bIR;
        LinearLayout bIS;
        com.baidu.tbadk.core.view.userLike.c cEg;
        View fpX;
        MyFansUserLikeButton fpY;
        ImageView fpZ;
        TextView fqa;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
