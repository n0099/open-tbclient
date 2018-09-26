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
    boolean bZj;
    private View.OnClickListener cue;
    boolean dXb;
    private PersonListActivity fpU;
    private View.OnClickListener fpV;
    private View.OnClickListener fqy;
    private int mSex;
    boolean fpT = false;
    private HashSet<Long> fqx = new HashSet<>();

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.fpU = null;
        this.bZj = false;
        this.dXb = true;
        this.mSex = 0;
        this.fqy = null;
        this.fpV = null;
        this.cue = null;
        this.fpU = personListActivity;
        this.bZj = z;
        this.dXb = z2;
        this.mSex = i;
        this.fqy = onClickListener2;
        this.fpV = onClickListener3;
        this.cue = onClickListener;
        this.anX = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(aq aqVar) {
        ArrayList arrayList = new ArrayList();
        if (this.anX.isEmpty() && !v.z(aqVar.vA())) {
            Iterator<UserData> it = aqVar.vA().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.fqx.add(Long.valueOf(com.baidu.adp.lib.g.b.d(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(aqVar.vA());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(ai(aqVar.vz()));
        this.anX.addAll(arrayList);
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean cE(long j) {
        if (j == 0 || this.anX == null || this.anX.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.anX.iterator();
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
        if (!v.z(arrayList) && !this.fqx.isEmpty()) {
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.fqx.contains(Long.valueOf(com.baidu.adp.lib.g.b.d(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fpT) {
            return 1;
        }
        int i = 0;
        if (this.anX != null) {
            i = this.anX.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.anX == null || i >= this.anX.size()) {
            return null;
        }
        return this.anX.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.anX == null || i >= this.anX.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (this.anX != null) {
            if (view == null || !(view.getTag() instanceof a)) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.fpU.getPageContext().getPageActivity()).inflate(e.h.person_list_item, (ViewGroup) null);
                    aVar2.bIN = (ViewGroup) inflate.findViewById(e.g.item_view);
                    aVar2.bIN.setOnClickListener(this.cue);
                    aVar2.bIQ = (ClickableHeaderImageView) inflate.findViewById(e.g.photo);
                    aVar2.bIQ.setRadius(l.h(this.fpU.getPageContext().getPageActivity(), e.C0141e.ds90));
                    aVar2.bIQ.setAutoChangeStyle(true);
                    aVar2.bIQ.setClickable(false);
                    aVar2.bIS = (LinearLayout) inflate.findViewById(e.g.info);
                    aVar2.azr = (LinearLayout) inflate.findViewById(e.g.tail_container);
                    aVar2.mName = (TextView) inflate.findViewById(e.g.name);
                    aVar2.fpX = com.baidu.tbadk.ala.b.sB().i(this.fpU.getPageContext().getPageActivity(), 5);
                    if (aVar2.fpX != null) {
                        aVar2.fpX.setVisibility(8);
                        aVar2.azr.addView(aVar2.fpX, 1);
                    }
                    aVar2.fqa = (TextView) inflate.findViewById(e.g.at_list_nodata);
                    aVar2.bIR = (TextView) inflate.findViewById(e.g.intro);
                    aVar2.fqA = (TextView) inflate.findViewById(e.g.chat);
                    aVar2.fqA.setOnClickListener(this.fqy);
                    aVar2.fpY = (MyFansUserLikeButton) inflate.findViewById(e.g.attention_btn);
                    aVar2.fpY.setContext(this.fpU.getPageContext());
                    aVar2.cEg = new com.baidu.tbadk.core.view.userLike.c(this.fpU.getPageContext(), aVar2.fpY);
                    aVar2.mProgress = null;
                    aVar2.mTitle = null;
                    aVar2.fqB = null;
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    View inflate2 = LayoutInflater.from(this.fpU.getPageContext().getPageActivity()).inflate(e.h.person_list_newheader, (ViewGroup) null);
                    aVar2.mTitle = (TextView) inflate2.findViewById(e.g.person_list_title);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.mTitle.getLayoutParams();
                    layoutParams.height = l.h(TbadkCoreApplication.getInst(), e.C0141e.ds16);
                    aVar2.mTitle.setLayoutParams(layoutParams);
                    aVar2.fqB = (LinearLayout) inflate2.findViewById(e.g.newheader_root);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.fpU.getPageContext().getPageActivity()).inflate(e.h.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate3.findViewById(e.g.pb_more_text);
                    inflate3.setOnClickListener(this.fpV);
                    aVar2.mProgress = (ProgressBar) inflate3.findViewById(e.g.progress);
                    aVar2.mTitle = null;
                    aVar2.fqB = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.fpY != null) {
                aVar.fpY.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.fpT) {
                    aVar.bIS.setVisibility(8);
                    aVar.fqA.setVisibility(8);
                    aVar.fqa.setVisibility(0);
                    if (this.bZj) {
                        if (this.dXb) {
                            aVar.fqa.setText(e.j.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.fqa.setText(e.j.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.fqa.setText(e.j.him_no_attention_other);
                        } else {
                            aVar.fqa.setText(e.j.no_attention_other);
                        }
                    } else if (this.dXb) {
                        aVar.fqa.setText(e.j.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.fqa.setText(e.j.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.fqa.setText(e.j.him_no_fan_other);
                    } else {
                        aVar.fqa.setText(e.j.no_fan_other);
                    }
                } else {
                    UserData userData = (UserData) v.d(this.anX, i);
                    if (userData == null) {
                        return null;
                    }
                    aVar.bIN.setTag(Integer.valueOf(i));
                    aVar.fqA.setVisibility(0);
                    aVar.fqa.setVisibility(8);
                    aVar.bIQ.setShowV(userData.isBigV());
                    aVar.bIQ.startLoad(userData.getPortrait(), 12, false);
                    aVar.mName.setText(userData.getName_show());
                    if (aVar.fpX != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            aVar.fpX.setVisibility(8);
                        } else {
                            aVar.fpX.setVisibility(0);
                            com.baidu.tbadk.ala.a aVar3 = new com.baidu.tbadk.ala.a();
                            aVar3.acu = userData.getAlaUserData();
                            aVar3.type = 5;
                            aVar.fpX.setTag(aVar3);
                        }
                    }
                    if (ao.isEmpty(userData.getIntro())) {
                        aVar.bIR.setVisibility(8);
                    } else {
                        aVar.bIR.setVisibility(0);
                        aVar.bIR.setText(userData.getIntro());
                    }
                    aVar.fqA.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    aVar.fpY.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    aVar.cEg.a(userData);
                    aVar.cEg.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.d.1
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void bj(boolean z) {
                            if (z) {
                                l.showToast(d.this.fpU, e.j.attention_success);
                            } else {
                                l.showToast(d.this.fpU, e.j.unfollow_success);
                            }
                        }
                    });
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        aVar.fpY.setVisibility(8);
                        aVar.fqA.setVisibility(8);
                    } else {
                        aVar.fqA.setVisibility(8);
                        aVar.fpY.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else if (getItemViewType(i) != 2) {
                aVar.mName.setText(this.fpU.getPageContext().getString(e.j.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
            return view;
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.fpU.getLayoutMode().setNightMode(skinType == 1);
        this.fpU.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.fqA != null) {
                al.c(aVar.fqA, e.d.btn_forum_focus_color, 1);
                al.i(aVar.fqA, e.f.btn_focus_border_bg);
                aVar.fqA.setEnabled(true);
            }
            if (aVar.fqB != null && aVar.mTitle != null) {
                al.j(aVar.fqB, e.d.cp_bg_line_e);
                al.h(aVar.mTitle, e.d.cp_cont_e);
            }
            if (aVar.fpY != null) {
                aVar.fpY.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fpT) {
            return 0;
        }
        if (this.anX == null || i >= this.anX.size()) {
            return 1;
        }
        return this.anX.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fpT) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        LinearLayout azr;
        ViewGroup bIN;
        ClickableHeaderImageView bIQ;
        TextView bIR;
        LinearLayout bIS;
        com.baidu.tbadk.core.view.userLike.c cEg;
        View fpX;
        MyFansUserLikeButton fpY;
        TextView fqA;
        LinearLayout fqB;
        TextView fqa;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
