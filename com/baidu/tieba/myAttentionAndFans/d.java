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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class d extends b {
    boolean bTv;
    private View.OnClickListener coq;
    boolean dPN;
    private PersonListActivity fiE;
    private View.OnClickListener fiF;
    private View.OnClickListener fji;
    private int mSex;
    boolean fiD = false;
    private HashSet<Long> fjh = new HashSet<>();

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.fiE = null;
        this.bTv = false;
        this.dPN = true;
        this.mSex = 0;
        this.fji = null;
        this.fiF = null;
        this.coq = null;
        this.fiE = personListActivity;
        this.bTv = z;
        this.dPN = z2;
        this.mSex = i;
        this.fji = onClickListener2;
        this.fiF = onClickListener3;
        this.coq = onClickListener;
        this.alt = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(aq aqVar) {
        ArrayList arrayList = new ArrayList();
        if (this.alt.isEmpty() && !w.z(aqVar.uy())) {
            Iterator<UserData> it = aqVar.uy().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.fjh.add(Long.valueOf(com.baidu.adp.lib.g.b.c(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(aqVar.uy());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(ai(aqVar.ux()));
        this.alt.addAll(arrayList);
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
                if (next.getLikeStatus() == 2) {
                    next.setLikeStatus(1);
                }
                return true;
            }
        }
        return false;
    }

    private ArrayList<UserData> ai(ArrayList<UserData> arrayList) {
        if (!w.z(arrayList) && !this.fjh.isEmpty()) {
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.fjh.contains(Long.valueOf(com.baidu.adp.lib.g.b.c(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return arrayList;
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
        View view2;
        a aVar;
        if (this.alt != null) {
            if (view == null || !(view.getTag() instanceof a)) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.fiE.getPageContext().getPageActivity()).inflate(d.h.person_list_item, (ViewGroup) null);
                    aVar2.bCX = (ViewGroup) inflate.findViewById(d.g.item_view);
                    aVar2.bCX.setOnClickListener(this.coq);
                    aVar2.bDa = (ClickableHeaderImageView) inflate.findViewById(d.g.photo);
                    aVar2.bDa.setRadius(l.f(this.fiE.getPageContext().getPageActivity(), d.e.ds90));
                    aVar2.bDa.setAutoChangeStyle(true);
                    aVar2.bDa.setClickable(false);
                    aVar2.bDc = (LinearLayout) inflate.findViewById(d.g.info);
                    aVar2.awj = (LinearLayout) inflate.findViewById(d.g.tail_container);
                    aVar2.mName = (TextView) inflate.findViewById(d.g.name);
                    aVar2.fiH = com.baidu.tbadk.ala.b.rx().g(this.fiE.getPageContext().getPageActivity(), 5);
                    if (aVar2.fiH != null) {
                        aVar2.fiH.setVisibility(8);
                        aVar2.awj.addView(aVar2.fiH, 1);
                    }
                    aVar2.fiK = (TextView) inflate.findViewById(d.g.at_list_nodata);
                    aVar2.bDb = (TextView) inflate.findViewById(d.g.intro);
                    aVar2.fjk = (TextView) inflate.findViewById(d.g.chat);
                    aVar2.fjk.setOnClickListener(this.fji);
                    aVar2.fiI = (MyFansUserLikeButton) inflate.findViewById(d.g.attention_btn);
                    aVar2.fiI.setContext(this.fiE.getPageContext());
                    aVar2.cyt = new com.baidu.tbadk.core.view.userLike.c(this.fiE.getPageContext(), aVar2.fiI);
                    aVar2.mProgress = null;
                    aVar2.mTitle = null;
                    aVar2.fjl = null;
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    View inflate2 = LayoutInflater.from(this.fiE.getPageContext().getPageActivity()).inflate(d.h.person_list_newheader, (ViewGroup) null);
                    aVar2.mTitle = (TextView) inflate2.findViewById(d.g.person_list_title);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.mTitle.getLayoutParams();
                    layoutParams.height = l.f(TbadkCoreApplication.getInst(), d.e.ds16);
                    aVar2.mTitle.setLayoutParams(layoutParams);
                    aVar2.fjl = (LinearLayout) inflate2.findViewById(d.g.newheader_root);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.fiE.getPageContext().getPageActivity()).inflate(d.h.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate3.findViewById(d.g.pb_more_text);
                    inflate3.setOnClickListener(this.fiF);
                    aVar2.mProgress = (ProgressBar) inflate3.findViewById(d.g.progress);
                    aVar2.mTitle = null;
                    aVar2.fjl = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.fiI != null) {
                aVar.fiI.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.fiD) {
                    aVar.bDc.setVisibility(8);
                    aVar.fjk.setVisibility(8);
                    aVar.fiK.setVisibility(0);
                    if (this.bTv) {
                        if (this.dPN) {
                            aVar.fiK.setText(d.j.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.fiK.setText(d.j.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.fiK.setText(d.j.him_no_attention_other);
                        } else {
                            aVar.fiK.setText(d.j.no_attention_other);
                        }
                    } else if (this.dPN) {
                        aVar.fiK.setText(d.j.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.fiK.setText(d.j.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.fiK.setText(d.j.him_no_fan_other);
                    } else {
                        aVar.fiK.setText(d.j.no_fan_other);
                    }
                } else {
                    UserData userData = (UserData) w.d(this.alt, i);
                    if (userData == null) {
                        return null;
                    }
                    aVar.bCX.setTag(Integer.valueOf(i));
                    aVar.fjk.setVisibility(0);
                    aVar.fiK.setVisibility(8);
                    aVar.bDa.setShowV(userData.isBigV());
                    aVar.bDa.startLoad(userData.getPortrait(), 12, false);
                    aVar.mName.setText(userData.getName_show());
                    if (aVar.fiH != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            aVar.fiH.setVisibility(8);
                        } else {
                            aVar.fiH.setVisibility(0);
                            com.baidu.tbadk.ala.a aVar3 = new com.baidu.tbadk.ala.a();
                            aVar3.ZR = userData.getAlaUserData();
                            aVar3.type = 5;
                            aVar.fiH.setTag(aVar3);
                        }
                    }
                    if (ap.isEmpty(userData.getIntro())) {
                        aVar.bDb.setVisibility(8);
                    } else {
                        aVar.bDb.setVisibility(0);
                        aVar.bDb.setText(userData.getIntro());
                    }
                    aVar.fjk.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    aVar.fiI.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    aVar.cyt.a(userData);
                    aVar.cyt.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.d.1
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void aW(boolean z) {
                            if (z) {
                                l.showToast(d.this.fiE, d.j.attention_success);
                            } else {
                                l.showToast(d.this.fiE, d.j.unfollow_success);
                            }
                        }
                    });
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        aVar.fiI.setVisibility(8);
                        aVar.fjk.setVisibility(8);
                    } else {
                        aVar.fjk.setVisibility(8);
                        aVar.fiI.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else if (getItemViewType(i) != 2) {
                aVar.mName.setText(this.fiE.getPageContext().getString(d.j.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
            return view;
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.fiE.getLayoutMode().setNightMode(skinType == 1);
        this.fiE.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.fjk != null) {
                am.c(aVar.fjk, d.C0140d.btn_forum_focus_color, 1);
                am.i(aVar.fjk, d.f.btn_focus_border_bg);
                aVar.fjk.setEnabled(true);
            }
            if (aVar.fjl != null && aVar.mTitle != null) {
                am.j(aVar.fjl, d.C0140d.cp_bg_line_e);
                am.h(aVar.mTitle, d.C0140d.cp_cont_e);
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
        TextView fiK;
        TextView fjk;
        LinearLayout fjl;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
