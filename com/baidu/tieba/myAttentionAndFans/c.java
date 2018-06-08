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
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class c extends b {
    private View.OnClickListener cjX;
    boolean dJI;
    private View.OnClickListener feA;
    private PersonListActivity fez;
    private int mSex;

    public c(PersonListActivity personListActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.fez = null;
        this.dJI = true;
        this.mSex = 0;
        this.feA = null;
        this.cjX = null;
        this.fez = personListActivity;
        this.dJI = z;
        this.mSex = i;
        this.feA = onClickListener2;
        this.cjX = onClickListener;
        this.alt = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(ar arVar) {
        if (arVar != null && arVar.uC() != null) {
            Iterator<UserData> it = arVar.uC().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null) {
                    next.setIsLike(next.getHave_attention() > 0);
                }
            }
            ArrayList arrayList = new ArrayList();
            if (this.alt == null) {
                this.alt = new ArrayList<>();
            }
            arrayList.addAll(arVar.uC());
            if (!w.z(this.alt) && this.alt.get(this.alt.size() - 1) != null && this.alt.get(this.alt.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                this.alt.get(this.alt.size() - 1).isLastNewFan = true;
            } else {
                for (int i = 0; i < arrayList.size() - 1; i++) {
                    UserData userData = (UserData) arrayList.get(i);
                    UserData userData2 = (UserData) arrayList.get(i + 1);
                    if (userData != null && userData2 != null && userData.isNewFan && !userData2.isNewFan) {
                        userData.isLastNewFan = true;
                    }
                }
            }
            if (w.z(this.alt) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                UserData userData3 = new UserData();
                userData3.mAttentionType = 0;
                arrayList.add(0, userData3);
            }
            this.alt.addAll(arrayList);
        }
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean cI(long j) {
        if (j == 0 || this.alt == null || this.alt.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.alt.iterator();
        while (it.hasNext()) {
            UserData next = it.next();
            if (next != null && next.getUserIdLong() == j) {
                this.alt.remove(next);
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fey) {
            return 1;
        }
        int i = 0;
        if (this.alt != null) {
            i = this.alt.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.alt == null || i >= this.alt.size()) {
            return null;
        }
        return this.alt.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.alt == null || i >= this.alt.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.alt != null) {
            int itemViewType = getItemViewType(i);
            if (view == null || !(view.getTag() instanceof a)) {
                aVar = new a();
                if (itemViewType == 0) {
                    View inflate = LayoutInflater.from(this.fez.getPageContext().getPageActivity()).inflate(d.i.person_list_item, (ViewGroup) null);
                    aVar.bAt = (ViewGroup) inflate.findViewById(d.g.item_view);
                    aVar.bAt.setOnClickListener(this.cjX);
                    aVar.bAw = (ClickableHeaderImageView) inflate.findViewById(d.g.photo);
                    aVar.bAw.setRadius(l.e(this.fez.getPageContext().getPageActivity(), d.e.ds90));
                    aVar.bAw.setAutoChangeStyle(true);
                    aVar.bAw.setClickable(false);
                    ((LinearLayout.LayoutParams) aVar.bAw.getLayoutParams()).setMargins(l.e(this.fez, d.e.ds34), 0, 0, 0);
                    aVar.bAy = (LinearLayout) inflate.findViewById(d.g.info);
                    aVar.avU = (LinearLayout) inflate.findViewById(d.g.tail_container);
                    aVar.mName = (TextView) inflate.findViewById(d.g.name);
                    aVar.feC = com.baidu.tbadk.ala.b.rM().f(this.fez.getPageContext().getPageActivity(), 5);
                    if (aVar.feC != null) {
                        aVar.feC.setVisibility(8);
                        aVar.avU.addView(aVar.feC, 1);
                    }
                    aVar.feF = (TextView) inflate.findViewById(d.g.at_list_nodata);
                    aVar.bAx = (TextView) inflate.findViewById(d.g.intro);
                    aVar.feD = (MyFansUserLikeButton) inflate.findViewById(d.g.attention_btn);
                    aVar.feD.setContext(this.fez.getPageContext());
                    ((LinearLayout.LayoutParams) aVar.feD.getLayoutParams()).setMargins(0, 0, l.e(this.fez, d.e.ds34), 0);
                    aVar.cxK = new com.baidu.tbadk.core.view.userLike.c(this.fez.getPageContext(), aVar.feD);
                    aVar.cxK.a(this.alt.get(i));
                    aVar.cxK.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.c.1
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void aV(boolean z) {
                            if (z) {
                                l.showToast(c.this.fez, d.k.attention_success);
                            } else {
                                l.showToast(c.this.fez, d.k.unfollow_success);
                            }
                        }
                    });
                    aVar.mProgress = null;
                    aVar.mTitle = null;
                    aVar.feE = (ImageView) inflate.findViewById(d.g.diver_buttom_px);
                    view2 = inflate;
                } else if (itemViewType == 2) {
                    View inflate2 = LayoutInflater.from(this.fez.getPageContext().getPageActivity()).inflate(d.i.my_fan_list_title, (ViewGroup) null);
                    aVar.mTitle = (TextView) inflate2.findViewById(d.g.my_new_fan_title);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.fez.getPageContext().getPageActivity()).inflate(d.i.new_pb_list_more, (ViewGroup) null);
                    aVar.mName = (TextView) inflate3.findViewById(d.g.pb_more_text);
                    inflate3.setOnClickListener(this.feA);
                    aVar.mProgress = (ProgressBar) inflate3.findViewById(d.g.progress);
                    aVar.mTitle = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar);
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.feD != null) {
                aVar.feD.setTag(Integer.valueOf(i));
            }
            if (itemViewType == 0) {
                if (this.fey) {
                    aVar.bAy.setVisibility(8);
                    aVar.feF.setVisibility(0);
                    if (this.dJI) {
                        aVar.feF.setText(d.k.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.feF.setText(d.k.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.feF.setText(d.k.him_no_fan_other);
                    } else {
                        aVar.feF.setText(d.k.no_fan_other);
                    }
                } else {
                    aVar.bAt.setTag(Integer.valueOf(i));
                    UserData userData = (UserData) w.c(this.alt, i);
                    if (userData != null) {
                        aVar.feF.setVisibility(8);
                        aVar.bAw.setIsGod(userData.isBigV());
                        aVar.bAw.startLoad(userData.getPortrait(), 12, false);
                        aVar.mName.setText(userData.getName_show());
                        if (aVar.feC != null && userData.getAlaUserData() != null) {
                            if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                                aVar.feC.setVisibility(8);
                            } else {
                                aVar.feC.setVisibility(0);
                                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                                aVar2.aak = userData.getAlaUserData();
                                aVar2.type = 5;
                                aVar.feC.setTag(aVar2);
                            }
                        }
                        if (ao.isEmpty(userData.getIntro())) {
                            aVar.bAx.setVisibility(8);
                        } else {
                            aVar.bAx.setVisibility(0);
                            aVar.bAx.setText(userData.getIntro());
                        }
                        String userId = userData.getUserId();
                        userData.setIsLike(userData.getHave_attention() > 0);
                        aVar.cxK.a(userData);
                        if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            aVar.feD.setVisibility(8);
                        } else {
                            aVar.feD.setStatsParams(2, userId);
                            aVar.cxK.setFromType("9");
                            aVar.feD.setVisibility(0);
                        }
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.feE.getLayoutParams();
                if (this.alt.get(i).isLastNewFan) {
                    layoutParams.height = l.e(this.fez, d.e.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                } else {
                    layoutParams.height = l.e(this.fez, d.e.ds1);
                    layoutParams.setMargins(l.e(this.fez, d.e.ds34), 0, l.e(this.fez, d.e.ds34), 0);
                }
                aVar.feE.setLayoutParams(layoutParams);
                aVar.mProgress = null;
            } else if (itemViewType == 2) {
                aVar.mTitle.setText(d.k.new_fans);
                aVar.mTitle.setVisibility(0);
            } else {
                aVar.mName.setText(this.fez.getPageContext().getString(d.k.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.fez.getLayoutMode().setNightMode(skinType == 1);
        this.fez.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.mTitle != null) {
                al.h(aVar.mTitle, d.C0141d.cp_cont_d);
                al.j(aVar.mTitle, d.C0141d.cp_bg_line_d);
            }
            if (aVar.feE != null) {
                al.c(aVar.feE, d.C0141d.cp_bg_line_c);
            }
            if (aVar.feD != null) {
                aVar.feD.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fey) {
            return 0;
        }
        if (this.alt == null || i >= this.alt.size()) {
            return 1;
        }
        return this.alt.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fey) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        LinearLayout avU;
        ViewGroup bAt;
        ClickableHeaderImageView bAw;
        TextView bAx;
        LinearLayout bAy;
        com.baidu.tbadk.core.view.userLike.c cxK;
        View feC;
        MyFansUserLikeButton feD;
        ImageView feE;
        TextView feF;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
