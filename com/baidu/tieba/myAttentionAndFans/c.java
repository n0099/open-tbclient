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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class c extends b {
    private View.OnClickListener coq;
    boolean dPN;
    private PersonListActivity fiE;
    private View.OnClickListener fiF;
    private int mSex;

    public c(PersonListActivity personListActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.fiE = null;
        this.dPN = true;
        this.mSex = 0;
        this.fiF = null;
        this.coq = null;
        this.fiE = personListActivity;
        this.dPN = z;
        this.mSex = i;
        this.fiF = onClickListener2;
        this.coq = onClickListener;
        this.alt = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(aq aqVar) {
        if (aqVar != null && aqVar.ux() != null) {
            Iterator<UserData> it = aqVar.ux().iterator();
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
            arrayList.addAll(aqVar.ux());
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
    public boolean cA(long j) {
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
        if (this.fiD) {
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
                    View inflate = LayoutInflater.from(this.fiE.getPageContext().getPageActivity()).inflate(d.h.person_list_item, (ViewGroup) null);
                    aVar.bCX = (ViewGroup) inflate.findViewById(d.g.item_view);
                    aVar.bCX.setOnClickListener(this.coq);
                    aVar.bDa = (ClickableHeaderImageView) inflate.findViewById(d.g.photo);
                    aVar.bDa.setRadius(l.f(this.fiE.getPageContext().getPageActivity(), d.e.ds90));
                    aVar.bDa.setAutoChangeStyle(true);
                    aVar.bDa.setClickable(false);
                    ((LinearLayout.LayoutParams) aVar.bDa.getLayoutParams()).setMargins(l.f(this.fiE, d.e.ds34), 0, 0, 0);
                    aVar.bDc = (LinearLayout) inflate.findViewById(d.g.info);
                    aVar.awj = (LinearLayout) inflate.findViewById(d.g.tail_container);
                    aVar.mName = (TextView) inflate.findViewById(d.g.name);
                    aVar.fiH = com.baidu.tbadk.ala.b.rx().g(this.fiE.getPageContext().getPageActivity(), 5);
                    if (aVar.fiH != null) {
                        aVar.fiH.setVisibility(8);
                        aVar.awj.addView(aVar.fiH, 1);
                    }
                    aVar.fiK = (TextView) inflate.findViewById(d.g.at_list_nodata);
                    aVar.bDb = (TextView) inflate.findViewById(d.g.intro);
                    aVar.fiI = (MyFansUserLikeButton) inflate.findViewById(d.g.attention_btn);
                    aVar.fiI.setContext(this.fiE.getPageContext());
                    ((LinearLayout.LayoutParams) aVar.fiI.getLayoutParams()).setMargins(0, 0, l.f(this.fiE, d.e.ds34), 0);
                    aVar.cyt = new com.baidu.tbadk.core.view.userLike.c(this.fiE.getPageContext(), aVar.fiI);
                    aVar.cyt.a((com.baidu.tbadk.core.view.userLike.a) w.d(this.alt, i));
                    aVar.cyt.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.c.1
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void aW(boolean z) {
                            if (z) {
                                l.showToast(c.this.fiE, d.j.attention_success);
                            } else {
                                l.showToast(c.this.fiE, d.j.unfollow_success);
                            }
                        }
                    });
                    aVar.mProgress = null;
                    aVar.mTitle = null;
                    aVar.fiJ = (ImageView) inflate.findViewById(d.g.diver_buttom_px);
                    view2 = inflate;
                } else if (itemViewType == 2) {
                    View inflate2 = LayoutInflater.from(this.fiE.getPageContext().getPageActivity()).inflate(d.h.my_fan_list_title, (ViewGroup) null);
                    aVar.mTitle = (TextView) inflate2.findViewById(d.g.my_new_fan_title);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.fiE.getPageContext().getPageActivity()).inflate(d.h.new_pb_list_more, (ViewGroup) null);
                    aVar.mName = (TextView) inflate3.findViewById(d.g.pb_more_text);
                    inflate3.setOnClickListener(this.fiF);
                    aVar.mProgress = (ProgressBar) inflate3.findViewById(d.g.progress);
                    aVar.mTitle = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar);
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.fiI != null) {
                aVar.fiI.setTag(Integer.valueOf(i));
            }
            if (itemViewType == 0) {
                if (this.fiD) {
                    aVar.bDc.setVisibility(8);
                    aVar.fiK.setVisibility(0);
                    if (this.dPN) {
                        aVar.fiK.setText(d.j.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.fiK.setText(d.j.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.fiK.setText(d.j.him_no_fan_other);
                    } else {
                        aVar.fiK.setText(d.j.no_fan_other);
                    }
                } else {
                    aVar.bCX.setTag(Integer.valueOf(i));
                    UserData userData = (UserData) w.d(this.alt, i);
                    if (userData != null) {
                        aVar.fiK.setVisibility(8);
                        aVar.bDa.setIsGod(userData.isBigV());
                        aVar.bDa.startLoad(userData.getPortrait(), 12, false);
                        aVar.mName.setText(userData.getName_show());
                        if (aVar.fiH != null && userData.getAlaUserData() != null) {
                            if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                                aVar.fiH.setVisibility(8);
                            } else {
                                aVar.fiH.setVisibility(0);
                                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                                aVar2.ZR = userData.getAlaUserData();
                                aVar2.type = 5;
                                aVar.fiH.setTag(aVar2);
                            }
                        }
                        if (ap.isEmpty(userData.getIntro())) {
                            aVar.bDb.setVisibility(8);
                        } else {
                            aVar.bDb.setVisibility(0);
                            aVar.bDb.setText(userData.getIntro());
                        }
                        String userId = userData.getUserId();
                        userData.setIsLike(userData.getHave_attention() > 0);
                        aVar.cyt.a(userData);
                        if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            aVar.fiI.setVisibility(8);
                        } else {
                            aVar.fiI.setStatsParams(2, userId);
                            aVar.cyt.setFromType("9");
                            aVar.fiI.setVisibility(0);
                        }
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.fiJ.getLayoutParams();
                if (w.d(this.alt, i) != null && ((UserData) w.d(this.alt, i)).isLastNewFan) {
                    layoutParams.height = l.f(this.fiE, d.e.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                } else {
                    layoutParams.height = l.f(this.fiE, d.e.ds1);
                    layoutParams.setMargins(l.f(this.fiE, d.e.ds34), 0, l.f(this.fiE, d.e.ds34), 0);
                }
                aVar.fiJ.setLayoutParams(layoutParams);
                aVar.mProgress = null;
            } else if (itemViewType == 2) {
                aVar.mTitle.setText(d.j.new_fans);
                aVar.mTitle.setVisibility(0);
            } else {
                aVar.mName.setText(this.fiE.getPageContext().getString(d.j.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.fiE.getLayoutMode().setNightMode(skinType == 1);
        this.fiE.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.mTitle != null) {
                am.h(aVar.mTitle, d.C0140d.cp_cont_d);
                am.j(aVar.mTitle, d.C0140d.cp_bg_line_d);
            }
            if (aVar.fiJ != null) {
                am.c(aVar.fiJ, d.C0140d.cp_bg_line_c);
            }
            if (aVar.fiI != null) {
                aVar.fiI.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fiD) {
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
        if (this.fiD) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        LinearLayout awj;
        ViewGroup bCX;
        ClickableHeaderImageView bDa;
        TextView bDb;
        LinearLayout bDc;
        com.baidu.tbadk.core.view.userLike.c cyt;
        View fiH;
        MyFansUserLikeButton fiI;
        ImageView fiJ;
        TextView fiK;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
