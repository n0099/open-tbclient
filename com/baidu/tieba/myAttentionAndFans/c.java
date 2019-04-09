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
    private View.OnClickListener dWy;
    boolean fCT;
    private View.OnClickListener gZA;
    private PersonListActivity gZz;
    private int mSex;

    public c(PersonListActivity personListActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.gZz = null;
        this.fCT = true;
        this.mSex = 0;
        this.gZA = null;
        this.dWy = null;
        this.gZz = personListActivity;
        this.fCT = z;
        this.mSex = i;
        this.gZA = onClickListener2;
        this.dWy = onClickListener;
        this.aFM = new ArrayList<>();
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
            if (this.aFM == null) {
                this.aFM = new ArrayList<>();
            }
            arrayList.addAll(asVar.XK());
            if (!v.T(this.aFM) && this.aFM.get(this.aFM.size() - 1) != null && this.aFM.get(this.aFM.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                this.aFM.get(this.aFM.size() - 1).isLastNewFan = true;
            } else {
                for (int i = 0; i < arrayList.size() - 1; i++) {
                    UserData userData = (UserData) arrayList.get(i);
                    UserData userData2 = (UserData) arrayList.get(i + 1);
                    if (userData != null && userData2 != null && userData.isNewFan && !userData2.isNewFan) {
                        userData.isLastNewFan = true;
                    }
                }
            }
            if (v.T(this.aFM) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                UserData userData3 = new UserData();
                userData3.mAttentionType = 0;
                arrayList.add(0, userData3);
            }
            this.aFM.addAll(arrayList);
        }
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean dx(long j) {
        if (j == 0 || this.aFM == null || this.aFM.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.aFM.iterator();
        while (it.hasNext()) {
            UserData next = it.next();
            if (next != null && next.getUserIdLong() == j) {
                this.aFM.remove(next);
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gZy) {
            return 1;
        }
        int i = 0;
        if (this.aFM != null) {
            i = this.aFM.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aFM == null || i >= this.aFM.size()) {
            return null;
        }
        return this.aFM.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.aFM == null || i >= this.aFM.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.aFM != null) {
            int itemViewType = getItemViewType(i);
            if (view == null || !(view.getTag() instanceof a)) {
                aVar = new a();
                if (itemViewType == 0) {
                    View inflate = LayoutInflater.from(this.gZz.getPageContext().getPageActivity()).inflate(d.h.person_list_item, (ViewGroup) null);
                    aVar.dlJ = (ViewGroup) inflate.findViewById(d.g.item_view);
                    aVar.dlJ.setOnClickListener(this.dWy);
                    aVar.dlM = (ClickableHeaderImageView) inflate.findViewById(d.g.photo);
                    aVar.dlM.setRadius(l.h(this.gZz.getPageContext().getPageActivity(), d.e.ds90));
                    aVar.dlM.setAutoChangeStyle(true);
                    aVar.dlM.setClickable(false);
                    ((LinearLayout.LayoutParams) aVar.dlM.getLayoutParams()).setMargins(l.h(this.gZz, d.e.ds34), 0, 0, 0);
                    aVar.dlO = (LinearLayout) inflate.findViewById(d.g.info);
                    aVar.bRr = (LinearLayout) inflate.findViewById(d.g.tail_container);
                    aVar.mName = (TextView) inflate.findViewById(d.g.name);
                    aVar.gZC = com.baidu.tbadk.ala.b.UH().n(this.gZz.getPageContext().getPageActivity(), 5);
                    if (aVar.gZC != null) {
                        aVar.gZC.setVisibility(8);
                        aVar.bRr.addView(aVar.gZC, 1);
                    }
                    aVar.gZF = (TextView) inflate.findViewById(d.g.at_list_nodata);
                    aVar.dlN = (TextView) inflate.findViewById(d.g.intro);
                    aVar.gZD = (MyFansUserLikeButton) inflate.findViewById(d.g.attention_btn);
                    aVar.gZD.setContext(this.gZz.getPageContext());
                    ((LinearLayout.LayoutParams) aVar.gZD.getLayoutParams()).setMargins(0, 0, l.h(this.gZz, d.e.ds34), 0);
                    aVar.ehk = new com.baidu.tbadk.core.view.userLike.c(this.gZz.getPageContext(), aVar.gZD);
                    aVar.ehk.a((com.baidu.tbadk.core.view.userLike.a) v.c(this.aFM, i));
                    aVar.ehk.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.c.1
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void dV(boolean z) {
                            if (z) {
                                l.showToast(c.this.gZz, d.j.attention_success);
                            } else {
                                l.showToast(c.this.gZz, d.j.unfollow_success);
                            }
                        }
                    });
                    aVar.mProgress = null;
                    aVar.mTitle = null;
                    aVar.gZE = (ImageView) inflate.findViewById(d.g.diver_buttom_px);
                    view2 = inflate;
                } else if (itemViewType == 2) {
                    View inflate2 = LayoutInflater.from(this.gZz.getPageContext().getPageActivity()).inflate(d.h.my_fan_list_title, (ViewGroup) null);
                    aVar.mTitle = (TextView) inflate2.findViewById(d.g.my_new_fan_title);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.gZz.getPageContext().getPageActivity()).inflate(d.h.new_pb_list_more, (ViewGroup) null);
                    aVar.mName = (TextView) inflate3.findViewById(d.g.pb_more_text);
                    inflate3.setOnClickListener(this.gZA);
                    aVar.mProgress = (ProgressBar) inflate3.findViewById(d.g.progress);
                    aVar.mTitle = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar);
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.gZD != null) {
                aVar.gZD.setTag(Integer.valueOf(i));
            }
            if (itemViewType == 0) {
                if (this.gZy) {
                    aVar.dlO.setVisibility(8);
                    aVar.gZF.setVisibility(0);
                    if (this.fCT) {
                        aVar.gZF.setText(d.j.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.gZF.setText(d.j.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.gZF.setText(d.j.him_no_fan_other);
                    } else {
                        aVar.gZF.setText(d.j.no_fan_other);
                    }
                } else {
                    aVar.dlJ.setTag(Integer.valueOf(i));
                    UserData userData = (UserData) v.c(this.aFM, i);
                    if (userData != null) {
                        aVar.gZF.setVisibility(8);
                        aVar.dlM.setIsGod(userData.isBigV());
                        aVar.dlM.startLoad(userData.getPortrait(), 12, false);
                        aVar.mName.setText(userData.getName_show());
                        if (aVar.gZC != null && userData.getAlaUserData() != null) {
                            if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                                aVar.gZC.setVisibility(8);
                            } else {
                                aVar.gZC.setVisibility(0);
                                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                                aVar2.bsN = userData.getAlaUserData();
                                aVar2.type = 5;
                                aVar.gZC.setTag(aVar2);
                            }
                        }
                        if (ap.isEmpty(userData.getIntro())) {
                            aVar.dlN.setVisibility(8);
                        } else {
                            aVar.dlN.setVisibility(0);
                            aVar.dlN.setText(userData.getIntro());
                        }
                        String userId = userData.getUserId();
                        userData.setIsLike(userData.getHave_attention() > 0);
                        aVar.ehk.a(userData);
                        if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            aVar.gZD.setVisibility(8);
                        } else {
                            aVar.gZD.setStatsParams(2, userId);
                            aVar.ehk.setFromType("9");
                            aVar.gZD.setVisibility(0);
                        }
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.gZE.getLayoutParams();
                if (v.c(this.aFM, i) != null && ((UserData) v.c(this.aFM, i)).isLastNewFan) {
                    layoutParams.height = l.h(this.gZz, d.e.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                } else {
                    layoutParams.height = l.h(this.gZz, d.e.ds1);
                    layoutParams.setMargins(l.h(this.gZz, d.e.ds34), 0, l.h(this.gZz, d.e.ds34), 0);
                }
                aVar.gZE.setLayoutParams(layoutParams);
                aVar.mProgress = null;
            } else if (itemViewType == 2) {
                aVar.mTitle.setText(d.j.new_fans);
                aVar.mTitle.setVisibility(0);
            } else {
                aVar.mName.setText(this.gZz.getPageContext().getString(d.j.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.gZz.getLayoutMode().setNightMode(skinType == 1);
        this.gZz.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.mTitle != null) {
                al.j(aVar.mTitle, d.C0277d.cp_cont_d);
                al.l(aVar.mTitle, d.C0277d.cp_bg_line_d);
            }
            if (aVar.gZE != null) {
                al.c(aVar.gZE, d.C0277d.cp_bg_line_c);
            }
            if (aVar.gZD != null) {
                aVar.gZD.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.gZy) {
            return 0;
        }
        if (this.aFM == null || i >= this.aFM.size()) {
            return 1;
        }
        return this.aFM.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.gZy) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a {
        LinearLayout bRr;
        ViewGroup dlJ;
        ClickableHeaderImageView dlM;
        TextView dlN;
        LinearLayout dlO;
        com.baidu.tbadk.core.view.userLike.c ehk;
        View gZC;
        MyFansUserLikeButton gZD;
        ImageView gZE;
        TextView gZF;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
