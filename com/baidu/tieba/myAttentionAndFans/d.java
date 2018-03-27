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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class d extends b {
    private View.OnClickListener cKQ;
    boolean cqR;
    boolean ecO;
    private View.OnClickListener fxT;
    private PersonListActivity fxt;
    private View.OnClickListener fxu;
    private int mSex;
    boolean fxs = false;
    private HashSet<Long> fxS = new HashSet<>();

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.fxt = null;
        this.cqR = false;
        this.ecO = true;
        this.mSex = 0;
        this.fxT = null;
        this.fxu = null;
        this.cKQ = null;
        this.fxt = personListActivity;
        this.cqR = z;
        this.ecO = z2;
        this.mSex = i;
        this.fxT = onClickListener2;
        this.fxu = onClickListener3;
        this.cKQ = onClickListener;
        this.aRZ = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(aq aqVar) {
        ArrayList arrayList = new ArrayList();
        if (this.aRZ.isEmpty() && !v.E(aqVar.yC())) {
            Iterator<UserData> it = aqVar.yC().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.fxS.add(Long.valueOf(com.baidu.adp.lib.g.b.c(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(aqVar.yC());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(af(aqVar.yB()));
        this.aRZ.addAll(arrayList);
    }

    private ArrayList<UserData> af(ArrayList<UserData> arrayList) {
        if (!v.E(arrayList) && !this.fxS.isEmpty()) {
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.fxS.contains(Long.valueOf(com.baidu.adp.lib.g.b.c(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fxs) {
            return 1;
        }
        int i = 0;
        if (this.aRZ != null) {
            i = this.aRZ.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aRZ == null || i >= this.aRZ.size()) {
            return null;
        }
        return this.aRZ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.aRZ == null || i >= this.aRZ.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (this.aRZ != null) {
            if (view == null || !(view.getTag() instanceof a)) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.fxt.getPageContext().getPageActivity()).inflate(d.h.person_list_item, (ViewGroup) null);
                    aVar2.chV = (ViewGroup) inflate.findViewById(d.g.item_view);
                    aVar2.chV.setOnClickListener(this.cKQ);
                    aVar2.chY = (ClickableHeaderImageView) inflate.findViewById(d.g.photo);
                    aVar2.chY.setRadius(l.t(this.fxt.getPageContext().getPageActivity(), d.e.ds90));
                    aVar2.chY.setAutoChangeStyle(true);
                    aVar2.chY.setClickable(false);
                    aVar2.cia = (LinearLayout) inflate.findViewById(d.g.info);
                    aVar2.bct = (LinearLayout) inflate.findViewById(d.g.tail_container);
                    aVar2.mName = (TextView) inflate.findViewById(d.g.name);
                    aVar2.fxw = com.baidu.tbadk.ala.b.vL().u(this.fxt.getPageContext().getPageActivity(), 5);
                    if (aVar2.fxw != null) {
                        aVar2.fxw.setVisibility(8);
                        aVar2.bct.addView(aVar2.fxw, 1);
                    }
                    aVar2.fxz = (TextView) inflate.findViewById(d.g.at_list_nodata);
                    aVar2.chZ = (TextView) inflate.findViewById(d.g.intro);
                    aVar2.fxV = (TextView) inflate.findViewById(d.g.chat);
                    aVar2.fxV.setOnClickListener(this.fxT);
                    aVar2.fxx = (MyFansUserLikeButton) inflate.findViewById(d.g.attention_btn);
                    aVar2.fxx.setContext(this.fxt.getPageContext());
                    aVar2.cWa = new com.baidu.tbadk.core.view.userLike.c(this.fxt.getPageContext(), aVar2.fxx);
                    aVar2.mProgress = null;
                    aVar2.mTitle = null;
                    aVar2.fxW = null;
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    View inflate2 = LayoutInflater.from(this.fxt.getPageContext().getPageActivity()).inflate(d.h.person_list_newheader, (ViewGroup) null);
                    aVar2.mTitle = (TextView) inflate2.findViewById(d.g.person_list_title);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.mTitle.getLayoutParams();
                    layoutParams.height = l.t(TbadkCoreApplication.getInst(), d.e.ds16);
                    aVar2.mTitle.setLayoutParams(layoutParams);
                    aVar2.fxW = (LinearLayout) inflate2.findViewById(d.g.newheader_root);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.fxt.getPageContext().getPageActivity()).inflate(d.h.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate3.findViewById(d.g.pb_more_text);
                    inflate3.setOnClickListener(this.fxu);
                    aVar2.mProgress = (ProgressBar) inflate3.findViewById(d.g.progress);
                    aVar2.mTitle = null;
                    aVar2.fxW = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.fxx != null) {
                aVar.fxx.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.fxs) {
                    aVar.cia.setVisibility(8);
                    aVar.fxV.setVisibility(8);
                    aVar.fxz.setVisibility(0);
                    if (this.cqR) {
                        if (this.ecO) {
                            aVar.fxz.setText(d.j.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.fxz.setText(d.j.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.fxz.setText(d.j.him_no_attention_other);
                        } else {
                            aVar.fxz.setText(d.j.no_attention_other);
                        }
                    } else if (this.ecO) {
                        aVar.fxz.setText(d.j.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.fxz.setText(d.j.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.fxz.setText(d.j.him_no_fan_other);
                    } else {
                        aVar.fxz.setText(d.j.no_fan_other);
                    }
                } else {
                    UserData userData = (UserData) v.f(this.aRZ, i);
                    if (userData == null) {
                        return null;
                    }
                    aVar.chV.setTag(Integer.valueOf(i));
                    aVar.fxV.setVisibility(0);
                    aVar.fxz.setVisibility(8);
                    aVar.chY.setShowV(userData.isBigV());
                    aVar.chY.startLoad(userData.getPortrait(), 12, false);
                    aVar.mName.setText(userData.getName_show());
                    if (aVar.fxw != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            aVar.fxw.setVisibility(8);
                        } else {
                            aVar.fxw.setVisibility(0);
                            com.baidu.tbadk.ala.a aVar3 = new com.baidu.tbadk.ala.a();
                            aVar3.aGU = userData.getAlaUserData();
                            aVar3.type = 5;
                            aVar.fxw.setTag(aVar3);
                        }
                    }
                    if (am.isEmpty(userData.getIntro())) {
                        aVar.chZ.setVisibility(8);
                    } else {
                        aVar.chZ.setVisibility(0);
                        aVar.chZ.setText(userData.getIntro());
                    }
                    aVar.fxV.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    aVar.fxx.Y(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    aVar.cWa.a(userData);
                    aVar.cWa.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.d.1
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void bA(boolean z) {
                            if (z) {
                                l.showToast(d.this.fxt, d.j.attention_success);
                            } else {
                                l.showToast(d.this.fxt, d.j.unfollow_success);
                            }
                        }
                    });
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        aVar.fxx.setVisibility(8);
                        aVar.fxV.setVisibility(8);
                    } else {
                        aVar.fxV.setVisibility(8);
                        aVar.fxx.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else if (getItemViewType(i) != 2) {
                aVar.mName.setText(this.fxt.getPageContext().getString(d.j.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
            return view;
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.fxt.getLayoutMode().aQ(skinType == 1);
        this.fxt.getLayoutMode().aM(view);
        if (aVar != null) {
            if (aVar.fxV != null) {
                aj.e(aVar.fxV, d.C0141d.btn_forum_focus_color, 1);
                aj.s(aVar.fxV, d.f.btn_focus_border_bg);
                aVar.fxV.setEnabled(true);
            }
            if (aVar.fxW != null && aVar.mTitle != null) {
                aj.t(aVar.fxW, d.C0141d.cp_bg_line_e);
                aj.r(aVar.mTitle, d.C0141d.cp_cont_e);
            }
            if (aVar.fxx != null) {
                aVar.fxx.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fxs) {
            return 0;
        }
        if (this.aRZ == null || i >= this.aRZ.size()) {
            return 1;
        }
        return this.aRZ.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fxs) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        LinearLayout bct;
        com.baidu.tbadk.core.view.userLike.c cWa;
        ViewGroup chV;
        ClickableHeaderImageView chY;
        TextView chZ;
        LinearLayout cia;
        TextView fxV;
        LinearLayout fxW;
        View fxw;
        MyFansUserLikeButton fxx;
        TextView fxz;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
