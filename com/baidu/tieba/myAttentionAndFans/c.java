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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class c extends b {
    private View.OnClickListener cbT;
    boolean dyy;
    private PersonListActivity eTh;
    private View.OnClickListener eTi;
    private int mSex;

    public c(PersonListActivity personListActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.eTh = null;
        this.dyy = true;
        this.mSex = 0;
        this.eTi = null;
        this.cbT = null;
        this.eTh = personListActivity;
        this.dyy = z;
        this.mSex = i;
        this.eTi = onClickListener2;
        this.cbT = onClickListener;
        this.adv = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(ar arVar) {
        if (arVar != null && arVar.rg() != null) {
            Iterator<UserData> it = arVar.rg().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null) {
                    next.setIsLike(next.getHave_attention() > 0);
                }
            }
            ArrayList arrayList = new ArrayList();
            if (this.adv == null) {
                this.adv = new ArrayList<>();
            }
            arrayList.addAll(arVar.rg());
            if (!v.w(this.adv) && this.adv.get(this.adv.size() - 1) != null && this.adv.get(this.adv.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                this.adv.get(this.adv.size() - 1).isLastNewFan = true;
            } else {
                for (int i = 0; i < arrayList.size() - 1; i++) {
                    UserData userData = (UserData) arrayList.get(i);
                    UserData userData2 = (UserData) arrayList.get(i + 1);
                    if (userData != null && userData2 != null && userData.isNewFan && !userData2.isNewFan) {
                        userData.isLastNewFan = true;
                    }
                }
            }
            if (v.w(this.adv) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                UserData userData3 = new UserData();
                userData3.mAttentionType = 0;
                arrayList.add(0, userData3);
            }
            this.adv.addAll(arrayList);
        }
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean cC(long j) {
        if (j == 0 || this.adv == null || this.adv.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.adv.iterator();
        while (it.hasNext()) {
            UserData next = it.next();
            if (next != null && next.getUserIdLong() == j) {
                this.adv.remove(next);
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eTg) {
            return 1;
        }
        int i = 0;
        if (this.adv != null) {
            i = this.adv.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.adv == null || i >= this.adv.size()) {
            return null;
        }
        return this.adv.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.adv == null || i >= this.adv.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        a aVar;
        View view3;
        if (this.adv != null) {
            int itemViewType = getItemViewType(i);
            if (view2 == null || !(view2.getTag() instanceof a)) {
                aVar = new a();
                if (itemViewType == 0) {
                    View inflate = LayoutInflater.from(this.eTh.getPageContext().getPageActivity()).inflate(d.i.person_list_item, (ViewGroup) null);
                    aVar.bso = (ViewGroup) inflate.findViewById(d.g.item_view);
                    aVar.bso.setOnClickListener(this.cbT);
                    aVar.bsr = (ClickableHeaderImageView) inflate.findViewById(d.g.photo);
                    aVar.bsr.setRadius(l.e(this.eTh.getPageContext().getPageActivity(), d.e.ds90));
                    aVar.bsr.setAutoChangeStyle(true);
                    aVar.bsr.setClickable(false);
                    ((LinearLayout.LayoutParams) aVar.bsr.getLayoutParams()).setMargins(l.e(this.eTh, d.e.ds34), 0, 0, 0);
                    aVar.bst = (LinearLayout) inflate.findViewById(d.g.info);
                    aVar.anM = (LinearLayout) inflate.findViewById(d.g.tail_container);
                    aVar.mName = (TextView) inflate.findViewById(d.g.name);
                    aVar.eTk = com.baidu.tbadk.ala.b.or().f(this.eTh.getPageContext().getPageActivity(), 5);
                    if (aVar.eTk != null) {
                        aVar.eTk.setVisibility(8);
                        aVar.anM.addView(aVar.eTk, 1);
                    }
                    aVar.eTn = (TextView) inflate.findViewById(d.g.at_list_nodata);
                    aVar.bss = (TextView) inflate.findViewById(d.g.intro);
                    aVar.eTl = (MyFansUserLikeButton) inflate.findViewById(d.g.attention_btn);
                    aVar.eTl.setContext(this.eTh.getPageContext());
                    ((LinearLayout.LayoutParams) aVar.eTl.getLayoutParams()).setMargins(0, 0, l.e(this.eTh, d.e.ds34), 0);
                    aVar.cpg = new com.baidu.tbadk.core.view.userLike.c(this.eTh.getPageContext(), aVar.eTl);
                    aVar.cpg.a(this.adv.get(i));
                    aVar.cpg.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.c.1
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void aR(boolean z) {
                            if (z) {
                                l.showToast(c.this.eTh, d.k.attention_success);
                            } else {
                                l.showToast(c.this.eTh, d.k.unfollow_success);
                            }
                        }
                    });
                    aVar.mProgress = null;
                    aVar.mTitle = null;
                    aVar.eTm = (ImageView) inflate.findViewById(d.g.diver_buttom_px);
                    view3 = inflate;
                } else if (itemViewType == 2) {
                    View inflate2 = LayoutInflater.from(this.eTh.getPageContext().getPageActivity()).inflate(d.i.my_fan_list_title, (ViewGroup) null);
                    aVar.mTitle = (TextView) inflate2.findViewById(d.g.my_new_fan_title);
                    view3 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.eTh.getPageContext().getPageActivity()).inflate(d.i.new_pb_list_more, (ViewGroup) null);
                    aVar.mName = (TextView) inflate3.findViewById(d.g.pb_more_text);
                    inflate3.setOnClickListener(this.eTi);
                    aVar.mProgress = (ProgressBar) inflate3.findViewById(d.g.progress);
                    aVar.mTitle = null;
                    view3 = inflate3;
                }
                view3.setTag(aVar);
                view2 = view3;
            } else {
                aVar = (a) view2.getTag();
            }
            if (aVar.eTl != null) {
                aVar.eTl.setTag(Integer.valueOf(i));
            }
            if (itemViewType == 0) {
                if (this.eTg) {
                    aVar.bst.setVisibility(8);
                    aVar.eTn.setVisibility(0);
                    if (this.dyy) {
                        aVar.eTn.setText(d.k.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.eTn.setText(d.k.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.eTn.setText(d.k.him_no_fan_other);
                    } else {
                        aVar.eTn.setText(d.k.no_fan_other);
                    }
                } else {
                    aVar.bso.setTag(Integer.valueOf(i));
                    UserData userData = (UserData) v.c(this.adv, i);
                    if (userData != null) {
                        aVar.eTn.setVisibility(8);
                        aVar.bsr.setIsGod(userData.isBigV());
                        aVar.bsr.startLoad(userData.getPortrait(), 12, false);
                        aVar.mName.setText(userData.getName_show());
                        if (aVar.eTk != null && userData.getAlaUserData() != null) {
                            if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                                aVar.eTk.setVisibility(8);
                            } else {
                                aVar.eTk.setVisibility(0);
                                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                                aVar2.Sa = userData.getAlaUserData();
                                aVar2.type = 5;
                                aVar.eTk.setTag(aVar2);
                            }
                        }
                        if (an.isEmpty(userData.getIntro())) {
                            aVar.bss.setVisibility(8);
                        } else {
                            aVar.bss.setVisibility(0);
                            aVar.bss.setText(userData.getIntro());
                        }
                        String userId = userData.getUserId();
                        userData.setIsLike(userData.getHave_attention() > 0);
                        aVar.cpg.a(userData);
                        if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            aVar.eTl.setVisibility(8);
                        } else {
                            aVar.eTl.setStatsParams(2, userId);
                            aVar.cpg.setFromType("9");
                            aVar.eTl.setVisibility(0);
                        }
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.eTm.getLayoutParams();
                if (this.adv.get(i).isLastNewFan) {
                    layoutParams.height = l.e(this.eTh, d.e.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                } else {
                    layoutParams.height = l.e(this.eTh, d.e.ds1);
                    layoutParams.setMargins(l.e(this.eTh, d.e.ds34), 0, l.e(this.eTh, d.e.ds34), 0);
                }
                aVar.eTm.setLayoutParams(layoutParams);
                aVar.mProgress = null;
            } else if (itemViewType == 2) {
                aVar.mTitle.setText(d.k.new_fans);
                aVar.mTitle.setVisibility(0);
            } else {
                aVar.mName.setText(this.eTh.getPageContext().getString(d.k.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view2, aVar);
        }
        return view2;
    }

    private void a(View view2, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.eTh.getLayoutMode().setNightMode(skinType == 1);
        this.eTh.getLayoutMode().u(view2);
        if (aVar != null) {
            if (aVar.mTitle != null) {
                ak.h(aVar.mTitle, d.C0126d.cp_cont_d);
                ak.j(aVar.mTitle, d.C0126d.cp_bg_line_d);
            }
            if (aVar.eTm != null) {
                ak.c(aVar.eTm, d.C0126d.cp_bg_line_c);
            }
            if (aVar.eTl != null) {
                aVar.eTl.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.eTg) {
            return 0;
        }
        if (this.adv == null || i >= this.adv.size()) {
            return 1;
        }
        return this.adv.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.eTg) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        LinearLayout anM;
        ViewGroup bso;
        ClickableHeaderImageView bsr;
        TextView bss;
        LinearLayout bst;
        com.baidu.tbadk.core.view.userLike.c cpg;
        View eTk;
        MyFansUserLikeButton eTl;
        ImageView eTm;
        TextView eTn;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
