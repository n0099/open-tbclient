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
import com.baidu.tieba.f;
import java.util.ArrayList;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class c extends b {
    private View.OnClickListener con;
    boolean dPJ;
    private PersonListActivity fiy;
    private View.OnClickListener fiz;
    private int mSex;

    public c(PersonListActivity personListActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.fiy = null;
        this.dPJ = true;
        this.mSex = 0;
        this.fiz = null;
        this.con = null;
        this.fiy = personListActivity;
        this.dPJ = z;
        this.mSex = i;
        this.fiz = onClickListener2;
        this.con = onClickListener;
        this.als = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(aq aqVar) {
        if (aqVar != null && aqVar.uw() != null) {
            Iterator<UserData> it = aqVar.uw().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null) {
                    next.setIsLike(next.getHave_attention() > 0);
                }
            }
            ArrayList arrayList = new ArrayList();
            if (this.als == null) {
                this.als = new ArrayList<>();
            }
            arrayList.addAll(aqVar.uw());
            if (!w.z(this.als) && this.als.get(this.als.size() - 1) != null && this.als.get(this.als.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                this.als.get(this.als.size() - 1).isLastNewFan = true;
            } else {
                for (int i = 0; i < arrayList.size() - 1; i++) {
                    UserData userData = (UserData) arrayList.get(i);
                    UserData userData2 = (UserData) arrayList.get(i + 1);
                    if (userData != null && userData2 != null && userData.isNewFan && !userData2.isNewFan) {
                        userData.isLastNewFan = true;
                    }
                }
            }
            if (w.z(this.als) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                UserData userData3 = new UserData();
                userData3.mAttentionType = 0;
                arrayList.add(0, userData3);
            }
            this.als.addAll(arrayList);
        }
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean cA(long j) {
        if (j == 0 || this.als == null || this.als.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.als.iterator();
        while (it.hasNext()) {
            UserData next = it.next();
            if (next != null && next.getUserIdLong() == j) {
                this.als.remove(next);
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fiw) {
            return 1;
        }
        int i = 0;
        if (this.als != null) {
            i = this.als.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.als == null || i >= this.als.size()) {
            return null;
        }
        return this.als.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.als == null || i >= this.als.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.als != null) {
            int itemViewType = getItemViewType(i);
            if (view == null || !(view.getTag() instanceof a)) {
                aVar = new a();
                if (itemViewType == 0) {
                    View inflate = LayoutInflater.from(this.fiy.getPageContext().getPageActivity()).inflate(f.h.person_list_item, (ViewGroup) null);
                    aVar.bCY = (ViewGroup) inflate.findViewById(f.g.item_view);
                    aVar.bCY.setOnClickListener(this.con);
                    aVar.bDb = (ClickableHeaderImageView) inflate.findViewById(f.g.photo);
                    aVar.bDb.setRadius(l.f(this.fiy.getPageContext().getPageActivity(), f.e.ds90));
                    aVar.bDb.setAutoChangeStyle(true);
                    aVar.bDb.setClickable(false);
                    ((LinearLayout.LayoutParams) aVar.bDb.getLayoutParams()).setMargins(l.f(this.fiy, f.e.ds34), 0, 0, 0);
                    aVar.bDd = (LinearLayout) inflate.findViewById(f.g.info);
                    aVar.awg = (LinearLayout) inflate.findViewById(f.g.tail_container);
                    aVar.mName = (TextView) inflate.findViewById(f.g.name);
                    aVar.fiB = com.baidu.tbadk.ala.b.rv().g(this.fiy.getPageContext().getPageActivity(), 5);
                    if (aVar.fiB != null) {
                        aVar.fiB.setVisibility(8);
                        aVar.awg.addView(aVar.fiB, 1);
                    }
                    aVar.fiE = (TextView) inflate.findViewById(f.g.at_list_nodata);
                    aVar.bDc = (TextView) inflate.findViewById(f.g.intro);
                    aVar.fiC = (MyFansUserLikeButton) inflate.findViewById(f.g.attention_btn);
                    aVar.fiC.setContext(this.fiy.getPageContext());
                    ((LinearLayout.LayoutParams) aVar.fiC.getLayoutParams()).setMargins(0, 0, l.f(this.fiy, f.e.ds34), 0);
                    aVar.cyq = new com.baidu.tbadk.core.view.userLike.c(this.fiy.getPageContext(), aVar.fiC);
                    aVar.cyq.a((com.baidu.tbadk.core.view.userLike.a) w.d(this.als, i));
                    aVar.cyq.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.c.1
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void aX(boolean z) {
                            if (z) {
                                l.showToast(c.this.fiy, f.j.attention_success);
                            } else {
                                l.showToast(c.this.fiy, f.j.unfollow_success);
                            }
                        }
                    });
                    aVar.mProgress = null;
                    aVar.mTitle = null;
                    aVar.fiD = (ImageView) inflate.findViewById(f.g.diver_buttom_px);
                    view2 = inflate;
                } else if (itemViewType == 2) {
                    View inflate2 = LayoutInflater.from(this.fiy.getPageContext().getPageActivity()).inflate(f.h.my_fan_list_title, (ViewGroup) null);
                    aVar.mTitle = (TextView) inflate2.findViewById(f.g.my_new_fan_title);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.fiy.getPageContext().getPageActivity()).inflate(f.h.new_pb_list_more, (ViewGroup) null);
                    aVar.mName = (TextView) inflate3.findViewById(f.g.pb_more_text);
                    inflate3.setOnClickListener(this.fiz);
                    aVar.mProgress = (ProgressBar) inflate3.findViewById(f.g.progress);
                    aVar.mTitle = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar);
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.fiC != null) {
                aVar.fiC.setTag(Integer.valueOf(i));
            }
            if (itemViewType == 0) {
                if (this.fiw) {
                    aVar.bDd.setVisibility(8);
                    aVar.fiE.setVisibility(0);
                    if (this.dPJ) {
                        aVar.fiE.setText(f.j.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.fiE.setText(f.j.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.fiE.setText(f.j.him_no_fan_other);
                    } else {
                        aVar.fiE.setText(f.j.no_fan_other);
                    }
                } else {
                    aVar.bCY.setTag(Integer.valueOf(i));
                    UserData userData = (UserData) w.d(this.als, i);
                    if (userData != null) {
                        aVar.fiE.setVisibility(8);
                        aVar.bDb.setIsGod(userData.isBigV());
                        aVar.bDb.startLoad(userData.getPortrait(), 12, false);
                        aVar.mName.setText(userData.getName_show());
                        if (aVar.fiB != null && userData.getAlaUserData() != null) {
                            if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                                aVar.fiB.setVisibility(8);
                            } else {
                                aVar.fiB.setVisibility(0);
                                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                                aVar2.ZS = userData.getAlaUserData();
                                aVar2.type = 5;
                                aVar.fiB.setTag(aVar2);
                            }
                        }
                        if (ap.isEmpty(userData.getIntro())) {
                            aVar.bDc.setVisibility(8);
                        } else {
                            aVar.bDc.setVisibility(0);
                            aVar.bDc.setText(userData.getIntro());
                        }
                        String userId = userData.getUserId();
                        userData.setIsLike(userData.getHave_attention() > 0);
                        aVar.cyq.a(userData);
                        if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            aVar.fiC.setVisibility(8);
                        } else {
                            aVar.fiC.setStatsParams(2, userId);
                            aVar.cyq.setFromType("9");
                            aVar.fiC.setVisibility(0);
                        }
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.fiD.getLayoutParams();
                if (w.d(this.als, i) != null && ((UserData) w.d(this.als, i)).isLastNewFan) {
                    layoutParams.height = l.f(this.fiy, f.e.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                } else {
                    layoutParams.height = l.f(this.fiy, f.e.ds1);
                    layoutParams.setMargins(l.f(this.fiy, f.e.ds34), 0, l.f(this.fiy, f.e.ds34), 0);
                }
                aVar.fiD.setLayoutParams(layoutParams);
                aVar.mProgress = null;
            } else if (itemViewType == 2) {
                aVar.mTitle.setText(f.j.new_fans);
                aVar.mTitle.setVisibility(0);
            } else {
                aVar.mName.setText(this.fiy.getPageContext().getString(f.j.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.fiy.getLayoutMode().setNightMode(skinType == 1);
        this.fiy.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.mTitle != null) {
                am.h(aVar.mTitle, f.d.cp_cont_d);
                am.j(aVar.mTitle, f.d.cp_bg_line_d);
            }
            if (aVar.fiD != null) {
                am.c(aVar.fiD, f.d.cp_bg_line_c);
            }
            if (aVar.fiC != null) {
                aVar.fiC.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fiw) {
            return 0;
        }
        if (this.als == null || i >= this.als.size()) {
            return 1;
        }
        return this.als.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fiw) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        LinearLayout awg;
        ViewGroup bCY;
        ClickableHeaderImageView bDb;
        TextView bDc;
        LinearLayout bDd;
        com.baidu.tbadk.core.view.userLike.c cyq;
        View fiB;
        MyFansUserLikeButton fiC;
        ImageView fiD;
        TextView fiE;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
