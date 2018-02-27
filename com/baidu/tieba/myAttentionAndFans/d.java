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
    private View.OnClickListener cKN;
    boolean cqO;
    boolean ecy;
    private View.OnClickListener fxD;
    private PersonListActivity fxd;
    private View.OnClickListener fxe;
    private int mSex;
    boolean fxc = false;
    private HashSet<Long> fxC = new HashSet<>();

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.fxd = null;
        this.cqO = false;
        this.ecy = true;
        this.mSex = 0;
        this.fxD = null;
        this.fxe = null;
        this.cKN = null;
        this.fxd = personListActivity;
        this.cqO = z;
        this.ecy = z2;
        this.mSex = i;
        this.fxD = onClickListener2;
        this.fxe = onClickListener3;
        this.cKN = onClickListener;
        this.aRX = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(aq aqVar) {
        ArrayList arrayList = new ArrayList();
        if (this.aRX.isEmpty() && !v.E(aqVar.yC())) {
            Iterator<UserData> it = aqVar.yC().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.fxC.add(Long.valueOf(com.baidu.adp.lib.g.b.c(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(aqVar.yC());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(af(aqVar.yB()));
        this.aRX.addAll(arrayList);
    }

    private ArrayList<UserData> af(ArrayList<UserData> arrayList) {
        if (!v.E(arrayList) && !this.fxC.isEmpty()) {
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.fxC.contains(Long.valueOf(com.baidu.adp.lib.g.b.c(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fxc) {
            return 1;
        }
        int i = 0;
        if (this.aRX != null) {
            i = this.aRX.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aRX == null || i >= this.aRX.size()) {
            return null;
        }
        return this.aRX.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.aRX == null || i >= this.aRX.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (this.aRX != null) {
            if (view == null || !(view.getTag() instanceof a)) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.fxd.getPageContext().getPageActivity()).inflate(d.h.person_list_item, (ViewGroup) null);
                    aVar2.chS = (ViewGroup) inflate.findViewById(d.g.item_view);
                    aVar2.chS.setOnClickListener(this.cKN);
                    aVar2.chV = (ClickableHeaderImageView) inflate.findViewById(d.g.photo);
                    aVar2.chV.setRadius(l.t(this.fxd.getPageContext().getPageActivity(), d.e.ds90));
                    aVar2.chV.setAutoChangeStyle(true);
                    aVar2.chV.setClickable(false);
                    aVar2.chX = (LinearLayout) inflate.findViewById(d.g.info);
                    aVar2.bcr = (LinearLayout) inflate.findViewById(d.g.tail_container);
                    aVar2.mName = (TextView) inflate.findViewById(d.g.name);
                    aVar2.fxg = com.baidu.tbadk.ala.b.vL().u(this.fxd.getPageContext().getPageActivity(), 5);
                    if (aVar2.fxg != null) {
                        aVar2.fxg.setVisibility(8);
                        aVar2.bcr.addView(aVar2.fxg, 1);
                    }
                    aVar2.fxj = (TextView) inflate.findViewById(d.g.at_list_nodata);
                    aVar2.chW = (TextView) inflate.findViewById(d.g.intro);
                    aVar2.fxF = (TextView) inflate.findViewById(d.g.chat);
                    aVar2.fxF.setOnClickListener(this.fxD);
                    aVar2.fxh = (MyFansUserLikeButton) inflate.findViewById(d.g.attention_btn);
                    aVar2.fxh.setContext(this.fxd.getPageContext());
                    aVar2.cVX = new com.baidu.tbadk.core.view.userLike.c(this.fxd.getPageContext(), aVar2.fxh);
                    aVar2.mProgress = null;
                    aVar2.mTitle = null;
                    aVar2.fxG = null;
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    View inflate2 = LayoutInflater.from(this.fxd.getPageContext().getPageActivity()).inflate(d.h.person_list_newheader, (ViewGroup) null);
                    aVar2.mTitle = (TextView) inflate2.findViewById(d.g.person_list_title);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.mTitle.getLayoutParams();
                    layoutParams.height = l.t(TbadkCoreApplication.getInst(), d.e.ds16);
                    aVar2.mTitle.setLayoutParams(layoutParams);
                    aVar2.fxG = (LinearLayout) inflate2.findViewById(d.g.newheader_root);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.fxd.getPageContext().getPageActivity()).inflate(d.h.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate3.findViewById(d.g.pb_more_text);
                    inflate3.setOnClickListener(this.fxe);
                    aVar2.mProgress = (ProgressBar) inflate3.findViewById(d.g.progress);
                    aVar2.mTitle = null;
                    aVar2.fxG = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.fxh != null) {
                aVar.fxh.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.fxc) {
                    aVar.chX.setVisibility(8);
                    aVar.fxF.setVisibility(8);
                    aVar.fxj.setVisibility(0);
                    if (this.cqO) {
                        if (this.ecy) {
                            aVar.fxj.setText(d.j.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.fxj.setText(d.j.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.fxj.setText(d.j.him_no_attention_other);
                        } else {
                            aVar.fxj.setText(d.j.no_attention_other);
                        }
                    } else if (this.ecy) {
                        aVar.fxj.setText(d.j.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.fxj.setText(d.j.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.fxj.setText(d.j.him_no_fan_other);
                    } else {
                        aVar.fxj.setText(d.j.no_fan_other);
                    }
                } else {
                    UserData userData = (UserData) v.f(this.aRX, i);
                    if (userData == null) {
                        return null;
                    }
                    aVar.chS.setTag(Integer.valueOf(i));
                    aVar.fxF.setVisibility(0);
                    aVar.fxj.setVisibility(8);
                    aVar.chV.setShowV(userData.isBigV());
                    aVar.chV.startLoad(userData.getPortrait(), 12, false);
                    aVar.mName.setText(userData.getName_show());
                    if (aVar.fxg != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            aVar.fxg.setVisibility(8);
                        } else {
                            aVar.fxg.setVisibility(0);
                            com.baidu.tbadk.ala.a aVar3 = new com.baidu.tbadk.ala.a();
                            aVar3.aGT = userData.getAlaUserData();
                            aVar3.type = 5;
                            aVar.fxg.setTag(aVar3);
                        }
                    }
                    if (am.isEmpty(userData.getIntro())) {
                        aVar.chW.setVisibility(8);
                    } else {
                        aVar.chW.setVisibility(0);
                        aVar.chW.setText(userData.getIntro());
                    }
                    aVar.fxF.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    aVar.fxh.Y(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    aVar.cVX.a(userData);
                    aVar.cVX.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.d.1
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void bA(boolean z) {
                            if (z) {
                                l.showToast(d.this.fxd, d.j.attention_success);
                            } else {
                                l.showToast(d.this.fxd, d.j.unfollow_success);
                            }
                        }
                    });
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        aVar.fxh.setVisibility(8);
                        aVar.fxF.setVisibility(8);
                    } else {
                        aVar.fxF.setVisibility(8);
                        aVar.fxh.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else if (getItemViewType(i) != 2) {
                aVar.mName.setText(this.fxd.getPageContext().getString(d.j.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
            return view;
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.fxd.getLayoutMode().aQ(skinType == 1);
        this.fxd.getLayoutMode().aM(view);
        if (aVar != null) {
            if (aVar.fxF != null) {
                aj.e(aVar.fxF, d.C0141d.btn_forum_focus_color, 1);
                aj.s(aVar.fxF, d.f.btn_focus_border_bg);
                aVar.fxF.setEnabled(true);
            }
            if (aVar.fxG != null && aVar.mTitle != null) {
                aj.t(aVar.fxG, d.C0141d.cp_bg_line_e);
                aj.r(aVar.mTitle, d.C0141d.cp_cont_e);
            }
            if (aVar.fxh != null) {
                aVar.fxh.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fxc) {
            return 0;
        }
        if (this.aRX == null || i >= this.aRX.size()) {
            return 1;
        }
        return this.aRX.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fxc) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        LinearLayout bcr;
        com.baidu.tbadk.core.view.userLike.c cVX;
        ViewGroup chS;
        ClickableHeaderImageView chV;
        TextView chW;
        LinearLayout chX;
        TextView fxF;
        LinearLayout fxG;
        View fxg;
        MyFansUserLikeButton fxh;
        TextView fxj;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
