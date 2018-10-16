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
    private View.OnClickListener cCH;
    boolean chJ;
    boolean eeU;
    private View.OnClickListener fxA;
    private PersonListActivity fxz;
    private View.OnClickListener fyd;
    private int mSex;
    boolean fxy = false;
    private HashSet<Long> fyc = new HashSet<>();

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.fxz = null;
        this.chJ = false;
        this.eeU = true;
        this.mSex = 0;
        this.fyd = null;
        this.fxA = null;
        this.cCH = null;
        this.fxz = personListActivity;
        this.chJ = z;
        this.eeU = z2;
        this.mSex = i;
        this.fyd = onClickListener2;
        this.fxA = onClickListener3;
        this.cCH = onClickListener;
        this.mData = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(aq aqVar) {
        ArrayList arrayList = new ArrayList();
        if (this.mData.isEmpty() && !v.J(aqVar.xJ())) {
            Iterator<UserData> it = aqVar.xJ().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.fyc.add(Long.valueOf(com.baidu.adp.lib.g.b.d(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(aqVar.xJ());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(ai(aqVar.xI()));
        this.mData.addAll(arrayList);
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean cL(long j) {
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

    private ArrayList<UserData> ai(ArrayList<UserData> arrayList) {
        if (!v.J(arrayList) && !this.fyc.isEmpty()) {
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.fyc.contains(Long.valueOf(com.baidu.adp.lib.g.b.d(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fxy) {
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
                    View inflate = LayoutInflater.from(this.fxz.getPageContext().getPageActivity()).inflate(e.h.person_list_item, (ViewGroup) null);
                    aVar2.bRq = (ViewGroup) inflate.findViewById(e.g.item_view);
                    aVar2.bRq.setOnClickListener(this.cCH);
                    aVar2.bRt = (ClickableHeaderImageView) inflate.findViewById(e.g.photo);
                    aVar2.bRt.setRadius(l.h(this.fxz.getPageContext().getPageActivity(), e.C0175e.ds90));
                    aVar2.bRt.setAutoChangeStyle(true);
                    aVar2.bRt.setClickable(false);
                    aVar2.bRv = (LinearLayout) inflate.findViewById(e.g.info);
                    aVar2.aDZ = (LinearLayout) inflate.findViewById(e.g.tail_container);
                    aVar2.mName = (TextView) inflate.findViewById(e.g.name);
                    aVar2.fxC = com.baidu.tbadk.ala.b.uL().j(this.fxz.getPageContext().getPageActivity(), 5);
                    if (aVar2.fxC != null) {
                        aVar2.fxC.setVisibility(8);
                        aVar2.aDZ.addView(aVar2.fxC, 1);
                    }
                    aVar2.fxF = (TextView) inflate.findViewById(e.g.at_list_nodata);
                    aVar2.bRu = (TextView) inflate.findViewById(e.g.intro);
                    aVar2.fyf = (TextView) inflate.findViewById(e.g.chat);
                    aVar2.fyf.setOnClickListener(this.fyd);
                    aVar2.fxD = (MyFansUserLikeButton) inflate.findViewById(e.g.attention_btn);
                    aVar2.fxD.setContext(this.fxz.getPageContext());
                    aVar2.cMA = new com.baidu.tbadk.core.view.userLike.c(this.fxz.getPageContext(), aVar2.fxD);
                    aVar2.mProgress = null;
                    aVar2.mTitle = null;
                    aVar2.fyg = null;
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    View inflate2 = LayoutInflater.from(this.fxz.getPageContext().getPageActivity()).inflate(e.h.person_list_newheader, (ViewGroup) null);
                    aVar2.mTitle = (TextView) inflate2.findViewById(e.g.person_list_title);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.mTitle.getLayoutParams();
                    layoutParams.height = l.h(TbadkCoreApplication.getInst(), e.C0175e.ds16);
                    aVar2.mTitle.setLayoutParams(layoutParams);
                    aVar2.fyg = (LinearLayout) inflate2.findViewById(e.g.newheader_root);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.fxz.getPageContext().getPageActivity()).inflate(e.h.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate3.findViewById(e.g.pb_more_text);
                    inflate3.setOnClickListener(this.fxA);
                    aVar2.mProgress = (ProgressBar) inflate3.findViewById(e.g.progress);
                    aVar2.mTitle = null;
                    aVar2.fyg = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.fxD != null) {
                aVar.fxD.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.fxy) {
                    aVar.bRv.setVisibility(8);
                    aVar.fyf.setVisibility(8);
                    aVar.fxF.setVisibility(0);
                    if (this.chJ) {
                        if (this.eeU) {
                            aVar.fxF.setText(e.j.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.fxF.setText(e.j.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.fxF.setText(e.j.him_no_attention_other);
                        } else {
                            aVar.fxF.setText(e.j.no_attention_other);
                        }
                    } else if (this.eeU) {
                        aVar.fxF.setText(e.j.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.fxF.setText(e.j.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.fxF.setText(e.j.him_no_fan_other);
                    } else {
                        aVar.fxF.setText(e.j.no_fan_other);
                    }
                } else {
                    UserData userData = (UserData) v.d(this.mData, i);
                    if (userData == null) {
                        return null;
                    }
                    aVar.bRq.setTag(Integer.valueOf(i));
                    aVar.fyf.setVisibility(0);
                    aVar.fxF.setVisibility(8);
                    aVar.bRt.setShowV(userData.isBigV());
                    aVar.bRt.startLoad(userData.getPortrait(), 12, false);
                    aVar.mName.setText(userData.getName_show());
                    if (aVar.fxC != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            aVar.fxC.setVisibility(8);
                        } else {
                            aVar.fxC.setVisibility(0);
                            com.baidu.tbadk.ala.a aVar3 = new com.baidu.tbadk.ala.a();
                            aVar3.aht = userData.getAlaUserData();
                            aVar3.type = 5;
                            aVar.fxC.setTag(aVar3);
                        }
                    }
                    if (ao.isEmpty(userData.getIntro())) {
                        aVar.bRu.setVisibility(8);
                    } else {
                        aVar.bRu.setVisibility(0);
                        aVar.bRu.setText(userData.getIntro());
                    }
                    aVar.fyf.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    aVar.fxD.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    aVar.cMA.a(userData);
                    aVar.cMA.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.d.1
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void bt(boolean z) {
                            if (z) {
                                l.showToast(d.this.fxz, e.j.attention_success);
                            } else {
                                l.showToast(d.this.fxz, e.j.unfollow_success);
                            }
                        }
                    });
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        aVar.fxD.setVisibility(8);
                        aVar.fyf.setVisibility(8);
                    } else {
                        aVar.fyf.setVisibility(8);
                        aVar.fxD.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else if (getItemViewType(i) != 2) {
                aVar.mName.setText(this.fxz.getPageContext().getString(e.j.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
            return view;
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.fxz.getLayoutMode().setNightMode(skinType == 1);
        this.fxz.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.fyf != null) {
                al.c(aVar.fyf, e.d.btn_forum_focus_color, 1);
                al.i(aVar.fyf, e.f.btn_focus_border_bg);
                aVar.fyf.setEnabled(true);
            }
            if (aVar.fyg != null && aVar.mTitle != null) {
                al.j(aVar.fyg, e.d.cp_bg_line_e);
                al.h(aVar.mTitle, e.d.cp_cont_e);
            }
            if (aVar.fxD != null) {
                aVar.fxD.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fxy) {
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
        if (this.fxy) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        LinearLayout aDZ;
        ViewGroup bRq;
        ClickableHeaderImageView bRt;
        TextView bRu;
        LinearLayout bRv;
        com.baidu.tbadk.core.view.userLike.c cMA;
        View fxC;
        MyFansUserLikeButton fxD;
        TextView fxF;
        TextView fyf;
        LinearLayout fyg;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
