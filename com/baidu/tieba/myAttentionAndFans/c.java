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
    private View.OnClickListener cmC;
    boolean dNa;
    private PersonListActivity fir;
    private View.OnClickListener fis;
    private int mSex;

    public c(PersonListActivity personListActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.fir = null;
        this.dNa = true;
        this.mSex = 0;
        this.fis = null;
        this.cmC = null;
        this.fir = personListActivity;
        this.dNa = z;
        this.mSex = i;
        this.fis = onClickListener2;
        this.cmC = onClickListener;
        this.alT = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(ar arVar) {
        if (arVar != null && arVar.uK() != null) {
            Iterator<UserData> it = arVar.uK().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null) {
                    next.setIsLike(next.getHave_attention() > 0);
                }
            }
            ArrayList arrayList = new ArrayList();
            if (this.alT == null) {
                this.alT = new ArrayList<>();
            }
            arrayList.addAll(arVar.uK());
            if (!w.A(this.alT) && this.alT.get(this.alT.size() - 1) != null && this.alT.get(this.alT.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                this.alT.get(this.alT.size() - 1).isLastNewFan = true;
            } else {
                for (int i = 0; i < arrayList.size() - 1; i++) {
                    UserData userData = (UserData) arrayList.get(i);
                    UserData userData2 = (UserData) arrayList.get(i + 1);
                    if (userData != null && userData2 != null && userData.isNewFan && !userData2.isNewFan) {
                        userData.isLastNewFan = true;
                    }
                }
            }
            if (w.A(this.alT) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                UserData userData3 = new UserData();
                userData3.mAttentionType = 0;
                arrayList.add(0, userData3);
            }
            this.alT.addAll(arrayList);
        }
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean cE(long j) {
        if (j == 0 || this.alT == null || this.alT.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.alT.iterator();
        while (it.hasNext()) {
            UserData next = it.next();
            if (next != null && next.getUserIdLong() == j) {
                this.alT.remove(next);
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fiq) {
            return 1;
        }
        int i = 0;
        if (this.alT != null) {
            i = this.alT.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.alT == null || i >= this.alT.size()) {
            return null;
        }
        return this.alT.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.alT == null || i >= this.alT.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.alT != null) {
            int itemViewType = getItemViewType(i);
            if (view == null || !(view.getTag() instanceof a)) {
                aVar = new a();
                if (itemViewType == 0) {
                    View inflate = LayoutInflater.from(this.fir.getPageContext().getPageActivity()).inflate(d.i.person_list_item, (ViewGroup) null);
                    aVar.bCq = (ViewGroup) inflate.findViewById(d.g.item_view);
                    aVar.bCq.setOnClickListener(this.cmC);
                    aVar.bCt = (ClickableHeaderImageView) inflate.findViewById(d.g.photo);
                    aVar.bCt.setRadius(l.e(this.fir.getPageContext().getPageActivity(), d.e.ds90));
                    aVar.bCt.setAutoChangeStyle(true);
                    aVar.bCt.setClickable(false);
                    ((LinearLayout.LayoutParams) aVar.bCt.getLayoutParams()).setMargins(l.e(this.fir, d.e.ds34), 0, 0, 0);
                    aVar.bCv = (LinearLayout) inflate.findViewById(d.g.info);
                    aVar.awD = (LinearLayout) inflate.findViewById(d.g.tail_container);
                    aVar.mName = (TextView) inflate.findViewById(d.g.name);
                    aVar.fiu = com.baidu.tbadk.ala.b.rM().f(this.fir.getPageContext().getPageActivity(), 5);
                    if (aVar.fiu != null) {
                        aVar.fiu.setVisibility(8);
                        aVar.awD.addView(aVar.fiu, 1);
                    }
                    aVar.fiy = (TextView) inflate.findViewById(d.g.at_list_nodata);
                    aVar.bCu = (TextView) inflate.findViewById(d.g.intro);
                    aVar.fiv = (MyFansUserLikeButton) inflate.findViewById(d.g.attention_btn);
                    aVar.fiv.setContext(this.fir.getPageContext());
                    ((LinearLayout.LayoutParams) aVar.fiv.getLayoutParams()).setMargins(0, 0, l.e(this.fir, d.e.ds34), 0);
                    aVar.cvR = new com.baidu.tbadk.core.view.userLike.c(this.fir.getPageContext(), aVar.fiv);
                    aVar.cvR.a((com.baidu.tbadk.core.view.userLike.a) w.d(this.alT, i));
                    aVar.cvR.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.c.1
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void aY(boolean z) {
                            if (z) {
                                l.showToast(c.this.fir, d.k.attention_success);
                            } else {
                                l.showToast(c.this.fir, d.k.unfollow_success);
                            }
                        }
                    });
                    aVar.mProgress = null;
                    aVar.mTitle = null;
                    aVar.fiw = (ImageView) inflate.findViewById(d.g.diver_buttom_px);
                    view2 = inflate;
                } else if (itemViewType == 2) {
                    View inflate2 = LayoutInflater.from(this.fir.getPageContext().getPageActivity()).inflate(d.i.my_fan_list_title, (ViewGroup) null);
                    aVar.mTitle = (TextView) inflate2.findViewById(d.g.my_new_fan_title);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.fir.getPageContext().getPageActivity()).inflate(d.i.new_pb_list_more, (ViewGroup) null);
                    aVar.mName = (TextView) inflate3.findViewById(d.g.pb_more_text);
                    inflate3.setOnClickListener(this.fis);
                    aVar.mProgress = (ProgressBar) inflate3.findViewById(d.g.progress);
                    aVar.mTitle = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar);
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.fiv != null) {
                aVar.fiv.setTag(Integer.valueOf(i));
            }
            if (itemViewType == 0) {
                if (this.fiq) {
                    aVar.bCv.setVisibility(8);
                    aVar.fiy.setVisibility(0);
                    if (this.dNa) {
                        aVar.fiy.setText(d.k.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.fiy.setText(d.k.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.fiy.setText(d.k.him_no_fan_other);
                    } else {
                        aVar.fiy.setText(d.k.no_fan_other);
                    }
                } else {
                    aVar.bCq.setTag(Integer.valueOf(i));
                    UserData userData = (UserData) w.d(this.alT, i);
                    if (userData != null) {
                        aVar.fiy.setVisibility(8);
                        aVar.bCt.setIsGod(userData.isBigV());
                        aVar.bCt.startLoad(userData.getPortrait(), 12, false);
                        aVar.mName.setText(userData.getName_show());
                        if (aVar.fiu != null && userData.getAlaUserData() != null) {
                            if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                                aVar.fiu.setVisibility(8);
                            } else {
                                aVar.fiu.setVisibility(0);
                                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                                aVar2.aan = userData.getAlaUserData();
                                aVar2.type = 5;
                                aVar.fiu.setTag(aVar2);
                            }
                        }
                        if (ap.isEmpty(userData.getIntro())) {
                            aVar.bCu.setVisibility(8);
                        } else {
                            aVar.bCu.setVisibility(0);
                            aVar.bCu.setText(userData.getIntro());
                        }
                        String userId = userData.getUserId();
                        userData.setIsLike(userData.getHave_attention() > 0);
                        aVar.cvR.a(userData);
                        if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            aVar.fiv.setVisibility(8);
                        } else {
                            aVar.fiv.setStatsParams(2, userId);
                            aVar.cvR.setFromType("9");
                            aVar.fiv.setVisibility(0);
                        }
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.fiw.getLayoutParams();
                if (w.d(this.alT, i) != null && ((UserData) w.d(this.alT, i)).isLastNewFan) {
                    layoutParams.height = l.e(this.fir, d.e.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                } else {
                    layoutParams.height = l.e(this.fir, d.e.ds1);
                    layoutParams.setMargins(l.e(this.fir, d.e.ds34), 0, l.e(this.fir, d.e.ds34), 0);
                }
                aVar.fiw.setLayoutParams(layoutParams);
                aVar.mProgress = null;
            } else if (itemViewType == 2) {
                aVar.mTitle.setText(d.k.new_fans);
                aVar.mTitle.setVisibility(0);
            } else {
                aVar.mName.setText(this.fir.getPageContext().getString(d.k.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.fir.getLayoutMode().setNightMode(skinType == 1);
        this.fir.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.mTitle != null) {
                am.h(aVar.mTitle, d.C0142d.cp_cont_d);
                am.j(aVar.mTitle, d.C0142d.cp_bg_line_d);
            }
            if (aVar.fiw != null) {
                am.c(aVar.fiw, d.C0142d.cp_bg_line_c);
            }
            if (aVar.fiv != null) {
                aVar.fiv.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fiq) {
            return 0;
        }
        if (this.alT == null || i >= this.alT.size()) {
            return 1;
        }
        return this.alT.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fiq) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        LinearLayout awD;
        ViewGroup bCq;
        ClickableHeaderImageView bCt;
        TextView bCu;
        LinearLayout bCv;
        com.baidu.tbadk.core.view.userLike.c cvR;
        View fiu;
        MyFansUserLikeButton fiv;
        ImageView fiw;
        TextView fiy;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
