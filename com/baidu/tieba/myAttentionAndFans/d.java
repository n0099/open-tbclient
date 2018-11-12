package com.baidu.tieba.myAttentionAndFans;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
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
import java.util.HashSet;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class d extends b {
    private View.OnClickListener cDP;
    boolean chT;
    boolean egp;
    private PersonListActivity fyX;
    private View.OnClickListener fyY;
    private View.OnClickListener fzB;
    private int mSex;
    boolean fyW = false;
    private HashSet<Long> fzA = new HashSet<>();

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.fyX = null;
        this.chT = false;
        this.egp = true;
        this.mSex = 0;
        this.fzB = null;
        this.fyY = null;
        this.cDP = null;
        this.fyX = personListActivity;
        this.chT = z;
        this.egp = z2;
        this.mSex = i;
        this.fzB = onClickListener2;
        this.fyY = onClickListener3;
        this.cDP = onClickListener;
        this.mData = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(aq aqVar) {
        ArrayList arrayList = new ArrayList();
        if (this.mData.isEmpty() && !v.I(aqVar.xQ())) {
            Iterator<UserData> it = aqVar.xQ().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.fzA.add(Long.valueOf(com.baidu.adp.lib.g.b.d(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(aqVar.xQ());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(ah(aqVar.xP()));
        this.mData.addAll(arrayList);
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean cG(long j) {
        if (j == 0 || this.mData == null || this.mData.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.mData.iterator();
        while (it.hasNext()) {
            UserData next = it.next();
            if (next != null && next.getUserIdLong() == j) {
                if (next.getLikeStatus() == 2) {
                    next.setLikeStatus(1);
                }
                return true;
            }
        }
        return false;
    }

    private ArrayList<UserData> ah(ArrayList<UserData> arrayList) {
        if (!v.I(arrayList) && !this.fzA.isEmpty()) {
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.fzA.contains(Long.valueOf(com.baidu.adp.lib.g.b.d(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fyW) {
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
        View view2;
        a aVar;
        if (this.mData != null) {
            if (view == null || !(view.getTag() instanceof a)) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.fyX.getPageContext().getPageActivity()).inflate(e.h.person_list_item, (ViewGroup) null);
                    aVar2.bSc = (ViewGroup) inflate.findViewById(e.g.item_view);
                    aVar2.bSc.setOnClickListener(this.cDP);
                    aVar2.bSf = (ClickableHeaderImageView) inflate.findViewById(e.g.photo);
                    aVar2.bSf.setRadius(l.h(this.fyX.getPageContext().getPageActivity(), e.C0200e.ds90));
                    aVar2.bSf.setAutoChangeStyle(true);
                    aVar2.bSf.setClickable(false);
                    aVar2.bSh = (LinearLayout) inflate.findViewById(e.g.info);
                    aVar2.aEP = (LinearLayout) inflate.findViewById(e.g.tail_container);
                    aVar2.mName = (TextView) inflate.findViewById(e.g.name);
                    aVar2.fza = com.baidu.tbadk.ala.b.uV().j(this.fyX.getPageContext().getPageActivity(), 5);
                    if (aVar2.fza != null) {
                        aVar2.fza.setVisibility(8);
                        aVar2.aEP.addView(aVar2.fza, 1);
                    }
                    aVar2.fzd = (TextView) inflate.findViewById(e.g.at_list_nodata);
                    aVar2.bSg = (TextView) inflate.findViewById(e.g.intro);
                    aVar2.fzD = (TextView) inflate.findViewById(e.g.chat);
                    aVar2.fzD.setOnClickListener(this.fzB);
                    aVar2.fzb = (MyFansUserLikeButton) inflate.findViewById(e.g.attention_btn);
                    aVar2.fzb.setContext(this.fyX.getPageContext());
                    aVar2.cNG = new com.baidu.tbadk.core.view.userLike.c(this.fyX.getPageContext(), aVar2.fzb);
                    aVar2.mProgress = null;
                    aVar2.mTitle = null;
                    aVar2.fzE = null;
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    View inflate2 = LayoutInflater.from(this.fyX.getPageContext().getPageActivity()).inflate(e.h.person_list_newheader, (ViewGroup) null);
                    aVar2.mTitle = (TextView) inflate2.findViewById(e.g.person_list_title);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.mTitle.getLayoutParams();
                    layoutParams.height = l.h(TbadkCoreApplication.getInst(), e.C0200e.ds16);
                    aVar2.mTitle.setLayoutParams(layoutParams);
                    aVar2.fzE = (LinearLayout) inflate2.findViewById(e.g.newheader_root);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.fyX.getPageContext().getPageActivity()).inflate(e.h.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate3.findViewById(e.g.pb_more_text);
                    inflate3.setOnClickListener(this.fyY);
                    aVar2.mProgress = (ProgressBar) inflate3.findViewById(e.g.progress);
                    aVar2.mTitle = null;
                    aVar2.fzE = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.fzb != null) {
                aVar.fzb.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.fyW) {
                    aVar.bSh.setVisibility(8);
                    aVar.fzD.setVisibility(8);
                    aVar.fzd.setVisibility(0);
                    if (this.chT) {
                        if (this.egp) {
                            aVar.fzd.setText(e.j.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.fzd.setText(e.j.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.fzd.setText(e.j.him_no_attention_other);
                        } else {
                            aVar.fzd.setText(e.j.no_attention_other);
                        }
                    } else if (this.egp) {
                        aVar.fzd.setText(e.j.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.fzd.setText(e.j.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.fzd.setText(e.j.him_no_fan_other);
                    } else {
                        aVar.fzd.setText(e.j.no_fan_other);
                    }
                } else {
                    UserData userData = (UserData) v.d(this.mData, i);
                    if (userData == null) {
                        return null;
                    }
                    aVar.bSc.setTag(Integer.valueOf(i));
                    aVar.fzD.setVisibility(0);
                    aVar.fzd.setVisibility(8);
                    aVar.bSf.setShowV(userData.isBigV());
                    aVar.bSf.startLoad(userData.getPortrait(), 12, false);
                    aVar.mName.setText(userData.getName_show());
                    if (aVar.fza != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            aVar.fza.setVisibility(8);
                        } else {
                            aVar.fza.setVisibility(0);
                            com.baidu.tbadk.ala.a aVar3 = new com.baidu.tbadk.ala.a();
                            aVar3.aig = userData.getAlaUserData();
                            aVar3.type = 5;
                            aVar.fza.setTag(aVar3);
                        }
                    }
                    if (ao.isEmpty(userData.getIntro())) {
                        aVar.bSg.setVisibility(8);
                    } else {
                        aVar.bSg.setVisibility(0);
                        aVar.bSg.setText(userData.getIntro());
                    }
                    aVar.fzD.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    aVar.fzb.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    aVar.cNG.a(userData);
                    aVar.cNG.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.d.1
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void bK(boolean z) {
                            if (z) {
                                l.showToast(d.this.fyX, e.j.attention_success);
                            } else {
                                l.showToast(d.this.fyX, e.j.unfollow_success);
                            }
                        }
                    });
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        aVar.fzb.setVisibility(8);
                        aVar.fzD.setVisibility(8);
                    } else {
                        aVar.fzD.setVisibility(8);
                        aVar.fzb.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else if (getItemViewType(i) != 2) {
                aVar.mName.setText(this.fyX.getPageContext().getString(e.j.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
            return view;
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.fyX.getLayoutMode().setNightMode(skinType == 1);
        this.fyX.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.fzD != null) {
                al.c(aVar.fzD, e.d.btn_forum_focus_color, 1);
                al.i(aVar.fzD, e.f.btn_focus_border_bg);
                aVar.fzD.setEnabled(true);
            }
            if (aVar.fzE != null && aVar.mTitle != null) {
                al.j(aVar.fzE, e.d.cp_bg_line_e);
                al.h(aVar.mTitle, e.d.cp_cont_e);
            }
            if (aVar.fzb != null) {
                aVar.fzb.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fyW) {
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
        if (this.fyW) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        LinearLayout aEP;
        ViewGroup bSc;
        ClickableHeaderImageView bSf;
        TextView bSg;
        LinearLayout bSh;
        com.baidu.tbadk.core.view.userLike.c cNG;
        TextView fzD;
        LinearLayout fzE;
        View fza;
        MyFansUserLikeButton fzb;
        TextView fzd;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
