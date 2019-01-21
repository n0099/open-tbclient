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
    private View.OnClickListener cJA;
    boolean cmF;
    boolean eqG;
    private PersonListActivity fJA;
    private View.OnClickListener fJB;
    boolean fJz = false;
    private HashSet<Long> fKd = new HashSet<>();
    private View.OnClickListener fKe;
    private int mSex;

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.fJA = null;
        this.cmF = false;
        this.eqG = true;
        this.mSex = 0;
        this.fKe = null;
        this.fJB = null;
        this.cJA = null;
        this.fJA = personListActivity;
        this.cmF = z;
        this.eqG = z2;
        this.mSex = i;
        this.fKe = onClickListener2;
        this.fJB = onClickListener3;
        this.cJA = onClickListener;
        this.mData = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(aq aqVar) {
        ArrayList arrayList = new ArrayList();
        if (this.mData.isEmpty() && !v.I(aqVar.zh())) {
            Iterator<UserData> it = aqVar.zh().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.fKd.add(Long.valueOf(com.baidu.adp.lib.g.b.d(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(aqVar.zh());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(ah(aqVar.zg()));
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
        if (!v.I(arrayList) && !this.fKd.isEmpty()) {
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.fKd.contains(Long.valueOf(com.baidu.adp.lib.g.b.d(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fJz) {
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
                    View inflate = LayoutInflater.from(this.fJA.getPageContext().getPageActivity()).inflate(e.h.person_list_item, (ViewGroup) null);
                    aVar2.bWI = (ViewGroup) inflate.findViewById(e.g.item_view);
                    aVar2.bWI.setOnClickListener(this.cJA);
                    aVar2.bWL = (ClickableHeaderImageView) inflate.findViewById(e.g.photo);
                    aVar2.bWL.setRadius(l.h(this.fJA.getPageContext().getPageActivity(), e.C0210e.ds90));
                    aVar2.bWL.setAutoChangeStyle(true);
                    aVar2.bWL.setClickable(false);
                    aVar2.bWN = (LinearLayout) inflate.findViewById(e.g.info);
                    aVar2.aIT = (LinearLayout) inflate.findViewById(e.g.tail_container);
                    aVar2.mName = (TextView) inflate.findViewById(e.g.name);
                    aVar2.fJD = com.baidu.tbadk.ala.b.wg().j(this.fJA.getPageContext().getPageActivity(), 5);
                    if (aVar2.fJD != null) {
                        aVar2.fJD.setVisibility(8);
                        aVar2.aIT.addView(aVar2.fJD, 1);
                    }
                    aVar2.fJG = (TextView) inflate.findViewById(e.g.at_list_nodata);
                    aVar2.bWM = (TextView) inflate.findViewById(e.g.intro);
                    aVar2.fKg = (TextView) inflate.findViewById(e.g.chat);
                    aVar2.fKg.setOnClickListener(this.fKe);
                    aVar2.fJE = (MyFansUserLikeButton) inflate.findViewById(e.g.attention_btn);
                    aVar2.fJE.setContext(this.fJA.getPageContext());
                    aVar2.cXP = new com.baidu.tbadk.core.view.userLike.c(this.fJA.getPageContext(), aVar2.fJE);
                    aVar2.mProgress = null;
                    aVar2.mTitle = null;
                    aVar2.fKh = null;
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    View inflate2 = LayoutInflater.from(this.fJA.getPageContext().getPageActivity()).inflate(e.h.person_list_newheader, (ViewGroup) null);
                    aVar2.mTitle = (TextView) inflate2.findViewById(e.g.person_list_title);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.mTitle.getLayoutParams();
                    layoutParams.height = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds16);
                    aVar2.mTitle.setLayoutParams(layoutParams);
                    aVar2.fKh = (LinearLayout) inflate2.findViewById(e.g.newheader_root);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.fJA.getPageContext().getPageActivity()).inflate(e.h.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate3.findViewById(e.g.pb_more_text);
                    inflate3.setOnClickListener(this.fJB);
                    aVar2.mProgress = (ProgressBar) inflate3.findViewById(e.g.progress);
                    aVar2.mTitle = null;
                    aVar2.fKh = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.fJE != null) {
                aVar.fJE.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.fJz) {
                    aVar.bWN.setVisibility(8);
                    aVar.fKg.setVisibility(8);
                    aVar.fJG.setVisibility(0);
                    if (this.cmF) {
                        if (this.eqG) {
                            aVar.fJG.setText(e.j.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.fJG.setText(e.j.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.fJG.setText(e.j.him_no_attention_other);
                        } else {
                            aVar.fJG.setText(e.j.no_attention_other);
                        }
                    } else if (this.eqG) {
                        aVar.fJG.setText(e.j.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.fJG.setText(e.j.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.fJG.setText(e.j.him_no_fan_other);
                    } else {
                        aVar.fJG.setText(e.j.no_fan_other);
                    }
                } else {
                    UserData userData = (UserData) v.d(this.mData, i);
                    if (userData == null) {
                        return null;
                    }
                    aVar.bWI.setTag(Integer.valueOf(i));
                    aVar.fKg.setVisibility(0);
                    aVar.fJG.setVisibility(8);
                    aVar.bWL.setShowV(userData.isBigV());
                    aVar.bWL.startLoad(userData.getPortrait(), 12, false);
                    aVar.mName.setText(userData.getName_show());
                    if (aVar.fJD != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            aVar.fJD.setVisibility(8);
                        } else {
                            aVar.fJD.setVisibility(0);
                            com.baidu.tbadk.ala.a aVar3 = new com.baidu.tbadk.ala.a();
                            aVar3.amc = userData.getAlaUserData();
                            aVar3.type = 5;
                            aVar.fJD.setTag(aVar3);
                        }
                    }
                    if (ao.isEmpty(userData.getIntro())) {
                        aVar.bWM.setVisibility(8);
                    } else {
                        aVar.bWM.setVisibility(0);
                        aVar.bWM.setText(userData.getIntro());
                    }
                    aVar.fKg.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    aVar.fJE.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    aVar.cXP.a(userData);
                    aVar.cXP.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.d.1
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void bM(boolean z) {
                            if (z) {
                                l.showToast(d.this.fJA, e.j.attention_success);
                            } else {
                                l.showToast(d.this.fJA, e.j.unfollow_success);
                            }
                        }
                    });
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        aVar.fJE.setVisibility(8);
                        aVar.fKg.setVisibility(8);
                    } else {
                        aVar.fKg.setVisibility(8);
                        aVar.fJE.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else if (getItemViewType(i) != 2) {
                aVar.mName.setText(this.fJA.getPageContext().getString(e.j.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
            return view;
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.fJA.getLayoutMode().setNightMode(skinType == 1);
        this.fJA.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.fKg != null) {
                al.c(aVar.fKg, e.d.btn_forum_focus_color, 1);
                al.i(aVar.fKg, e.f.btn_focus_border_bg);
                aVar.fKg.setEnabled(true);
            }
            if (aVar.fKh != null && aVar.mTitle != null) {
                al.j(aVar.fKh, e.d.cp_bg_line_e);
                al.h(aVar.mTitle, e.d.cp_cont_e);
            }
            if (aVar.fJE != null) {
                aVar.fJE.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fJz) {
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
        if (this.fJz) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        LinearLayout aIT;
        ViewGroup bWI;
        ClickableHeaderImageView bWL;
        TextView bWM;
        LinearLayout bWN;
        com.baidu.tbadk.core.view.userLike.c cXP;
        View fJD;
        MyFansUserLikeButton fJE;
        TextView fJG;
        TextView fKg;
        LinearLayout fKh;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
