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
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class c extends b {
    private View.OnClickListener dWx;
    boolean fCT;
    private PersonListActivity gZy;
    private View.OnClickListener gZz;
    private int mSex;

    public c(PersonListActivity personListActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.gZy = null;
        this.fCT = true;
        this.mSex = 0;
        this.gZz = null;
        this.dWx = null;
        this.gZy = personListActivity;
        this.fCT = z;
        this.mSex = i;
        this.gZz = onClickListener2;
        this.dWx = onClickListener;
        this.aFL = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(as asVar) {
        if (asVar != null && asVar.XK() != null) {
            Iterator<UserData> it = asVar.XK().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null) {
                    next.setIsLike(next.getHave_attention() > 0);
                }
            }
            ArrayList arrayList = new ArrayList();
            if (this.aFL == null) {
                this.aFL = new ArrayList<>();
            }
            arrayList.addAll(asVar.XK());
            if (!v.T(this.aFL) && this.aFL.get(this.aFL.size() - 1) != null && this.aFL.get(this.aFL.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                this.aFL.get(this.aFL.size() - 1).isLastNewFan = true;
            } else {
                for (int i = 0; i < arrayList.size() - 1; i++) {
                    UserData userData = (UserData) arrayList.get(i);
                    UserData userData2 = (UserData) arrayList.get(i + 1);
                    if (userData != null && userData2 != null && userData.isNewFan && !userData2.isNewFan) {
                        userData.isLastNewFan = true;
                    }
                }
            }
            if (v.T(this.aFL) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                UserData userData3 = new UserData();
                userData3.mAttentionType = 0;
                arrayList.add(0, userData3);
            }
            this.aFL.addAll(arrayList);
        }
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean dx(long j) {
        if (j == 0 || this.aFL == null || this.aFL.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.aFL.iterator();
        while (it.hasNext()) {
            UserData next = it.next();
            if (next != null && next.getUserIdLong() == j) {
                this.aFL.remove(next);
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gZx) {
            return 1;
        }
        int i = 0;
        if (this.aFL != null) {
            i = this.aFL.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aFL == null || i >= this.aFL.size()) {
            return null;
        }
        return this.aFL.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.aFL == null || i >= this.aFL.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.aFL != null) {
            int itemViewType = getItemViewType(i);
            if (view == null || !(view.getTag() instanceof a)) {
                aVar = new a();
                if (itemViewType == 0) {
                    View inflate = LayoutInflater.from(this.gZy.getPageContext().getPageActivity()).inflate(d.h.person_list_item, (ViewGroup) null);
                    aVar.dlI = (ViewGroup) inflate.findViewById(d.g.item_view);
                    aVar.dlI.setOnClickListener(this.dWx);
                    aVar.dlL = (ClickableHeaderImageView) inflate.findViewById(d.g.photo);
                    aVar.dlL.setRadius(l.h(this.gZy.getPageContext().getPageActivity(), d.e.ds90));
                    aVar.dlL.setAutoChangeStyle(true);
                    aVar.dlL.setClickable(false);
                    ((LinearLayout.LayoutParams) aVar.dlL.getLayoutParams()).setMargins(l.h(this.gZy, d.e.ds34), 0, 0, 0);
                    aVar.dlN = (LinearLayout) inflate.findViewById(d.g.info);
                    aVar.bRq = (LinearLayout) inflate.findViewById(d.g.tail_container);
                    aVar.mName = (TextView) inflate.findViewById(d.g.name);
                    aVar.gZB = com.baidu.tbadk.ala.b.UH().n(this.gZy.getPageContext().getPageActivity(), 5);
                    if (aVar.gZB != null) {
                        aVar.gZB.setVisibility(8);
                        aVar.bRq.addView(aVar.gZB, 1);
                    }
                    aVar.gZE = (TextView) inflate.findViewById(d.g.at_list_nodata);
                    aVar.dlM = (TextView) inflate.findViewById(d.g.intro);
                    aVar.gZC = (MyFansUserLikeButton) inflate.findViewById(d.g.attention_btn);
                    aVar.gZC.setContext(this.gZy.getPageContext());
                    ((LinearLayout.LayoutParams) aVar.gZC.getLayoutParams()).setMargins(0, 0, l.h(this.gZy, d.e.ds34), 0);
                    aVar.ehj = new com.baidu.tbadk.core.view.userLike.c(this.gZy.getPageContext(), aVar.gZC);
                    aVar.ehj.a((com.baidu.tbadk.core.view.userLike.a) v.c(this.aFL, i));
                    aVar.ehj.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.c.1
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void dV(boolean z) {
                            if (z) {
                                l.showToast(c.this.gZy, d.j.attention_success);
                            } else {
                                l.showToast(c.this.gZy, d.j.unfollow_success);
                            }
                        }
                    });
                    aVar.mProgress = null;
                    aVar.mTitle = null;
                    aVar.gZD = (ImageView) inflate.findViewById(d.g.diver_buttom_px);
                    view2 = inflate;
                } else if (itemViewType == 2) {
                    View inflate2 = LayoutInflater.from(this.gZy.getPageContext().getPageActivity()).inflate(d.h.my_fan_list_title, (ViewGroup) null);
                    aVar.mTitle = (TextView) inflate2.findViewById(d.g.my_new_fan_title);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.gZy.getPageContext().getPageActivity()).inflate(d.h.new_pb_list_more, (ViewGroup) null);
                    aVar.mName = (TextView) inflate3.findViewById(d.g.pb_more_text);
                    inflate3.setOnClickListener(this.gZz);
                    aVar.mProgress = (ProgressBar) inflate3.findViewById(d.g.progress);
                    aVar.mTitle = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar);
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.gZC != null) {
                aVar.gZC.setTag(Integer.valueOf(i));
            }
            if (itemViewType == 0) {
                if (this.gZx) {
                    aVar.dlN.setVisibility(8);
                    aVar.gZE.setVisibility(0);
                    if (this.fCT) {
                        aVar.gZE.setText(d.j.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.gZE.setText(d.j.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.gZE.setText(d.j.him_no_fan_other);
                    } else {
                        aVar.gZE.setText(d.j.no_fan_other);
                    }
                } else {
                    aVar.dlI.setTag(Integer.valueOf(i));
                    UserData userData = (UserData) v.c(this.aFL, i);
                    if (userData != null) {
                        aVar.gZE.setVisibility(8);
                        aVar.dlL.setIsGod(userData.isBigV());
                        aVar.dlL.startLoad(userData.getPortrait(), 12, false);
                        aVar.mName.setText(userData.getName_show());
                        if (aVar.gZB != null && userData.getAlaUserData() != null) {
                            if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                                aVar.gZB.setVisibility(8);
                            } else {
                                aVar.gZB.setVisibility(0);
                                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                                aVar2.bsM = userData.getAlaUserData();
                                aVar2.type = 5;
                                aVar.gZB.setTag(aVar2);
                            }
                        }
                        if (ap.isEmpty(userData.getIntro())) {
                            aVar.dlM.setVisibility(8);
                        } else {
                            aVar.dlM.setVisibility(0);
                            aVar.dlM.setText(userData.getIntro());
                        }
                        String userId = userData.getUserId();
                        userData.setIsLike(userData.getHave_attention() > 0);
                        aVar.ehj.a(userData);
                        if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            aVar.gZC.setVisibility(8);
                        } else {
                            aVar.gZC.setStatsParams(2, userId);
                            aVar.ehj.setFromType("9");
                            aVar.gZC.setVisibility(0);
                        }
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.gZD.getLayoutParams();
                if (v.c(this.aFL, i) != null && ((UserData) v.c(this.aFL, i)).isLastNewFan) {
                    layoutParams.height = l.h(this.gZy, d.e.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                } else {
                    layoutParams.height = l.h(this.gZy, d.e.ds1);
                    layoutParams.setMargins(l.h(this.gZy, d.e.ds34), 0, l.h(this.gZy, d.e.ds34), 0);
                }
                aVar.gZD.setLayoutParams(layoutParams);
                aVar.mProgress = null;
            } else if (itemViewType == 2) {
                aVar.mTitle.setText(d.j.new_fans);
                aVar.mTitle.setVisibility(0);
            } else {
                aVar.mName.setText(this.gZy.getPageContext().getString(d.j.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.gZy.getLayoutMode().setNightMode(skinType == 1);
        this.gZy.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.mTitle != null) {
                al.j(aVar.mTitle, d.C0277d.cp_cont_d);
                al.l(aVar.mTitle, d.C0277d.cp_bg_line_d);
            }
            if (aVar.gZD != null) {
                al.c(aVar.gZD, d.C0277d.cp_bg_line_c);
            }
            if (aVar.gZC != null) {
                aVar.gZC.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.gZx) {
            return 0;
        }
        if (this.aFL == null || i >= this.aFL.size()) {
            return 1;
        }
        return this.aFL.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.gZx) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a {
        LinearLayout bRq;
        ViewGroup dlI;
        ClickableHeaderImageView dlL;
        TextView dlM;
        LinearLayout dlN;
        com.baidu.tbadk.core.view.userLike.c ehj;
        View gZB;
        MyFansUserLikeButton gZC;
        ImageView gZD;
        TextView gZE;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
