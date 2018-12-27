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
    private View.OnClickListener cIO;
    boolean clS;
    boolean epZ;
    private PersonListActivity fIF;
    private View.OnClickListener fIG;
    private View.OnClickListener fJj;
    private int mSex;
    boolean fIE = false;
    private HashSet<Long> fJi = new HashSet<>();

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.fIF = null;
        this.clS = false;
        this.epZ = true;
        this.mSex = 0;
        this.fJj = null;
        this.fIG = null;
        this.cIO = null;
        this.fIF = personListActivity;
        this.clS = z;
        this.epZ = z2;
        this.mSex = i;
        this.fJj = onClickListener2;
        this.fIG = onClickListener3;
        this.cIO = onClickListener;
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
                    this.fJi.add(Long.valueOf(com.baidu.adp.lib.g.b.d(next.getUserId(), 0L)));
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
    public boolean cS(long j) {
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
        if (!v.I(arrayList) && !this.fJi.isEmpty()) {
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.fJi.contains(Long.valueOf(com.baidu.adp.lib.g.b.d(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fIE) {
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
                    View inflate = LayoutInflater.from(this.fIF.getPageContext().getPageActivity()).inflate(e.h.person_list_item, (ViewGroup) null);
                    aVar2.bVW = (ViewGroup) inflate.findViewById(e.g.item_view);
                    aVar2.bVW.setOnClickListener(this.cIO);
                    aVar2.bVZ = (ClickableHeaderImageView) inflate.findViewById(e.g.photo);
                    aVar2.bVZ.setRadius(l.h(this.fIF.getPageContext().getPageActivity(), e.C0210e.ds90));
                    aVar2.bVZ.setAutoChangeStyle(true);
                    aVar2.bVZ.setClickable(false);
                    aVar2.bWb = (LinearLayout) inflate.findViewById(e.g.info);
                    aVar2.aIq = (LinearLayout) inflate.findViewById(e.g.tail_container);
                    aVar2.mName = (TextView) inflate.findViewById(e.g.name);
                    aVar2.fII = com.baidu.tbadk.ala.b.vZ().j(this.fIF.getPageContext().getPageActivity(), 5);
                    if (aVar2.fII != null) {
                        aVar2.fII.setVisibility(8);
                        aVar2.aIq.addView(aVar2.fII, 1);
                    }
                    aVar2.fIL = (TextView) inflate.findViewById(e.g.at_list_nodata);
                    aVar2.bWa = (TextView) inflate.findViewById(e.g.intro);
                    aVar2.fJl = (TextView) inflate.findViewById(e.g.chat);
                    aVar2.fJl.setOnClickListener(this.fJj);
                    aVar2.fIJ = (MyFansUserLikeButton) inflate.findViewById(e.g.attention_btn);
                    aVar2.fIJ.setContext(this.fIF.getPageContext());
                    aVar2.cXd = new com.baidu.tbadk.core.view.userLike.c(this.fIF.getPageContext(), aVar2.fIJ);
                    aVar2.mProgress = null;
                    aVar2.mTitle = null;
                    aVar2.fJm = null;
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    View inflate2 = LayoutInflater.from(this.fIF.getPageContext().getPageActivity()).inflate(e.h.person_list_newheader, (ViewGroup) null);
                    aVar2.mTitle = (TextView) inflate2.findViewById(e.g.person_list_title);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.mTitle.getLayoutParams();
                    layoutParams.height = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds16);
                    aVar2.mTitle.setLayoutParams(layoutParams);
                    aVar2.fJm = (LinearLayout) inflate2.findViewById(e.g.newheader_root);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.fIF.getPageContext().getPageActivity()).inflate(e.h.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate3.findViewById(e.g.pb_more_text);
                    inflate3.setOnClickListener(this.fIG);
                    aVar2.mProgress = (ProgressBar) inflate3.findViewById(e.g.progress);
                    aVar2.mTitle = null;
                    aVar2.fJm = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.fIJ != null) {
                aVar.fIJ.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.fIE) {
                    aVar.bWb.setVisibility(8);
                    aVar.fJl.setVisibility(8);
                    aVar.fIL.setVisibility(0);
                    if (this.clS) {
                        if (this.epZ) {
                            aVar.fIL.setText(e.j.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.fIL.setText(e.j.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.fIL.setText(e.j.him_no_attention_other);
                        } else {
                            aVar.fIL.setText(e.j.no_attention_other);
                        }
                    } else if (this.epZ) {
                        aVar.fIL.setText(e.j.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.fIL.setText(e.j.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.fIL.setText(e.j.him_no_fan_other);
                    } else {
                        aVar.fIL.setText(e.j.no_fan_other);
                    }
                } else {
                    UserData userData = (UserData) v.d(this.mData, i);
                    if (userData == null) {
                        return null;
                    }
                    aVar.bVW.setTag(Integer.valueOf(i));
                    aVar.fJl.setVisibility(0);
                    aVar.fIL.setVisibility(8);
                    aVar.bVZ.setShowV(userData.isBigV());
                    aVar.bVZ.startLoad(userData.getPortrait(), 12, false);
                    aVar.mName.setText(userData.getName_show());
                    if (aVar.fII != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            aVar.fII.setVisibility(8);
                        } else {
                            aVar.fII.setVisibility(0);
                            com.baidu.tbadk.ala.a aVar3 = new com.baidu.tbadk.ala.a();
                            aVar3.alI = userData.getAlaUserData();
                            aVar3.type = 5;
                            aVar.fII.setTag(aVar3);
                        }
                    }
                    if (ao.isEmpty(userData.getIntro())) {
                        aVar.bWa.setVisibility(8);
                    } else {
                        aVar.bWa.setVisibility(0);
                        aVar.bWa.setText(userData.getIntro());
                    }
                    aVar.fJl.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    aVar.fIJ.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    aVar.cXd.a(userData);
                    aVar.cXd.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.d.1
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void bL(boolean z) {
                            if (z) {
                                l.showToast(d.this.fIF, e.j.attention_success);
                            } else {
                                l.showToast(d.this.fIF, e.j.unfollow_success);
                            }
                        }
                    });
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        aVar.fIJ.setVisibility(8);
                        aVar.fJl.setVisibility(8);
                    } else {
                        aVar.fJl.setVisibility(8);
                        aVar.fIJ.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else if (getItemViewType(i) != 2) {
                aVar.mName.setText(this.fIF.getPageContext().getString(e.j.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
            return view;
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.fIF.getLayoutMode().setNightMode(skinType == 1);
        this.fIF.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.fJl != null) {
                al.c(aVar.fJl, e.d.btn_forum_focus_color, 1);
                al.i(aVar.fJl, e.f.btn_focus_border_bg);
                aVar.fJl.setEnabled(true);
            }
            if (aVar.fJm != null && aVar.mTitle != null) {
                al.j(aVar.fJm, e.d.cp_bg_line_e);
                al.h(aVar.mTitle, e.d.cp_cont_e);
            }
            if (aVar.fIJ != null) {
                aVar.fIJ.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fIE) {
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
        if (this.fIE) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        LinearLayout aIq;
        ViewGroup bVW;
        ClickableHeaderImageView bVZ;
        TextView bWa;
        LinearLayout bWb;
        com.baidu.tbadk.core.view.userLike.c cXd;
        View fII;
        MyFansUserLikeButton fIJ;
        TextView fIL;
        TextView fJl;
        LinearLayout fJm;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
