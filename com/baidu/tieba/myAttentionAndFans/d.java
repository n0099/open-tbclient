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
    private View.OnClickListener cHO;
    boolean clL;
    boolean eni;
    private PersonListActivity fFN;
    private View.OnClickListener fFO;
    private View.OnClickListener fGr;
    private int mSex;
    boolean fFM = false;
    private HashSet<Long> fGq = new HashSet<>();

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.fFN = null;
        this.clL = false;
        this.eni = true;
        this.mSex = 0;
        this.fGr = null;
        this.fFO = null;
        this.cHO = null;
        this.fFN = personListActivity;
        this.clL = z;
        this.eni = z2;
        this.mSex = i;
        this.fGr = onClickListener2;
        this.fFO = onClickListener3;
        this.cHO = onClickListener;
        this.mData = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(aq aqVar) {
        ArrayList arrayList = new ArrayList();
        if (this.mData.isEmpty() && !v.I(aqVar.yU())) {
            Iterator<UserData> it = aqVar.yU().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.fGq.add(Long.valueOf(com.baidu.adp.lib.g.b.d(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(aqVar.yU());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(ah(aqVar.yT()));
        this.mData.addAll(arrayList);
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean cN(long j) {
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
        if (!v.I(arrayList) && !this.fGq.isEmpty()) {
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.fGq.contains(Long.valueOf(com.baidu.adp.lib.g.b.d(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fFM) {
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
                    View inflate = LayoutInflater.from(this.fFN.getPageContext().getPageActivity()).inflate(e.h.person_list_item, (ViewGroup) null);
                    aVar2.bVT = (ViewGroup) inflate.findViewById(e.g.item_view);
                    aVar2.bVT.setOnClickListener(this.cHO);
                    aVar2.bVW = (ClickableHeaderImageView) inflate.findViewById(e.g.photo);
                    aVar2.bVW.setRadius(l.h(this.fFN.getPageContext().getPageActivity(), e.C0210e.ds90));
                    aVar2.bVW.setAutoChangeStyle(true);
                    aVar2.bVW.setClickable(false);
                    aVar2.bVY = (LinearLayout) inflate.findViewById(e.g.info);
                    aVar2.aIp = (LinearLayout) inflate.findViewById(e.g.tail_container);
                    aVar2.mName = (TextView) inflate.findViewById(e.g.name);
                    aVar2.fFQ = com.baidu.tbadk.ala.b.vZ().j(this.fFN.getPageContext().getPageActivity(), 5);
                    if (aVar2.fFQ != null) {
                        aVar2.fFQ.setVisibility(8);
                        aVar2.aIp.addView(aVar2.fFQ, 1);
                    }
                    aVar2.fFT = (TextView) inflate.findViewById(e.g.at_list_nodata);
                    aVar2.bVX = (TextView) inflate.findViewById(e.g.intro);
                    aVar2.fGt = (TextView) inflate.findViewById(e.g.chat);
                    aVar2.fGt.setOnClickListener(this.fGr);
                    aVar2.fFR = (MyFansUserLikeButton) inflate.findViewById(e.g.attention_btn);
                    aVar2.fFR.setContext(this.fFN.getPageContext());
                    aVar2.cUn = new com.baidu.tbadk.core.view.userLike.c(this.fFN.getPageContext(), aVar2.fFR);
                    aVar2.mProgress = null;
                    aVar2.mTitle = null;
                    aVar2.fGu = null;
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    View inflate2 = LayoutInflater.from(this.fFN.getPageContext().getPageActivity()).inflate(e.h.person_list_newheader, (ViewGroup) null);
                    aVar2.mTitle = (TextView) inflate2.findViewById(e.g.person_list_title);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.mTitle.getLayoutParams();
                    layoutParams.height = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds16);
                    aVar2.mTitle.setLayoutParams(layoutParams);
                    aVar2.fGu = (LinearLayout) inflate2.findViewById(e.g.newheader_root);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.fFN.getPageContext().getPageActivity()).inflate(e.h.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate3.findViewById(e.g.pb_more_text);
                    inflate3.setOnClickListener(this.fFO);
                    aVar2.mProgress = (ProgressBar) inflate3.findViewById(e.g.progress);
                    aVar2.mTitle = null;
                    aVar2.fGu = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.fFR != null) {
                aVar.fFR.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.fFM) {
                    aVar.bVY.setVisibility(8);
                    aVar.fGt.setVisibility(8);
                    aVar.fFT.setVisibility(0);
                    if (this.clL) {
                        if (this.eni) {
                            aVar.fFT.setText(e.j.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.fFT.setText(e.j.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.fFT.setText(e.j.him_no_attention_other);
                        } else {
                            aVar.fFT.setText(e.j.no_attention_other);
                        }
                    } else if (this.eni) {
                        aVar.fFT.setText(e.j.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.fFT.setText(e.j.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.fFT.setText(e.j.him_no_fan_other);
                    } else {
                        aVar.fFT.setText(e.j.no_fan_other);
                    }
                } else {
                    UserData userData = (UserData) v.d(this.mData, i);
                    if (userData == null) {
                        return null;
                    }
                    aVar.bVT.setTag(Integer.valueOf(i));
                    aVar.fGt.setVisibility(0);
                    aVar.fFT.setVisibility(8);
                    aVar.bVW.setShowV(userData.isBigV());
                    aVar.bVW.startLoad(userData.getPortrait(), 12, false);
                    aVar.mName.setText(userData.getName_show());
                    if (aVar.fFQ != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            aVar.fFQ.setVisibility(8);
                        } else {
                            aVar.fFQ.setVisibility(0);
                            com.baidu.tbadk.ala.a aVar3 = new com.baidu.tbadk.ala.a();
                            aVar3.alI = userData.getAlaUserData();
                            aVar3.type = 5;
                            aVar.fFQ.setTag(aVar3);
                        }
                    }
                    if (ao.isEmpty(userData.getIntro())) {
                        aVar.bVX.setVisibility(8);
                    } else {
                        aVar.bVX.setVisibility(0);
                        aVar.bVX.setText(userData.getIntro());
                    }
                    aVar.fGt.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    aVar.fFR.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    aVar.cUn.a(userData);
                    aVar.cUn.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.d.1
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void bL(boolean z) {
                            if (z) {
                                l.showToast(d.this.fFN, e.j.attention_success);
                            } else {
                                l.showToast(d.this.fFN, e.j.unfollow_success);
                            }
                        }
                    });
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        aVar.fFR.setVisibility(8);
                        aVar.fGt.setVisibility(8);
                    } else {
                        aVar.fGt.setVisibility(8);
                        aVar.fFR.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else if (getItemViewType(i) != 2) {
                aVar.mName.setText(this.fFN.getPageContext().getString(e.j.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
            return view;
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.fFN.getLayoutMode().setNightMode(skinType == 1);
        this.fFN.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.fGt != null) {
                al.c(aVar.fGt, e.d.btn_forum_focus_color, 1);
                al.i(aVar.fGt, e.f.btn_focus_border_bg);
                aVar.fGt.setEnabled(true);
            }
            if (aVar.fGu != null && aVar.mTitle != null) {
                al.j(aVar.fGu, e.d.cp_bg_line_e);
                al.h(aVar.mTitle, e.d.cp_cont_e);
            }
            if (aVar.fFR != null) {
                aVar.fFR.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fFM) {
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
        if (this.fFM) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        LinearLayout aIp;
        ViewGroup bVT;
        ClickableHeaderImageView bVW;
        TextView bVX;
        LinearLayout bVY;
        com.baidu.tbadk.core.view.userLike.c cUn;
        View fFQ;
        MyFansUserLikeButton fFR;
        TextView fFT;
        TextView fGt;
        LinearLayout fGu;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
