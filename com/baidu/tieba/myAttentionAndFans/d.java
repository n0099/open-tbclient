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
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class d extends b {
    boolean dBB;
    private View.OnClickListener dWZ;
    boolean fDf;
    private PersonListActivity gZL;
    private View.OnClickListener gZM;
    private View.OnClickListener hap;
    private int mSex;
    boolean gZK = false;
    private HashSet<Long> hao = new HashSet<>();

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.gZL = null;
        this.dBB = false;
        this.fDf = true;
        this.mSex = 0;
        this.hap = null;
        this.gZM = null;
        this.dWZ = null;
        this.gZL = personListActivity;
        this.dBB = z;
        this.fDf = z2;
        this.mSex = i;
        this.hap = onClickListener2;
        this.gZM = onClickListener3;
        this.dWZ = onClickListener;
        this.aFI = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(as asVar) {
        ArrayList arrayList = new ArrayList();
        if (this.aFI.isEmpty() && !v.T(asVar.XO())) {
            Iterator<UserData> it = asVar.XO().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.hao.add(Long.valueOf(com.baidu.adp.lib.g.b.d(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(asVar.XO());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(al(asVar.XN()));
        this.aFI.addAll(arrayList);
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean dx(long j) {
        if (j == 0 || this.aFI == null || this.aFI.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.aFI.iterator();
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

    private ArrayList<UserData> al(ArrayList<UserData> arrayList) {
        if (!v.T(arrayList) && !this.hao.isEmpty()) {
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.hao.contains(Long.valueOf(com.baidu.adp.lib.g.b.d(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gZK) {
            return 1;
        }
        int i = 0;
        if (this.aFI != null) {
            i = this.aFI.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aFI == null || i >= this.aFI.size()) {
            return null;
        }
        return this.aFI.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.aFI == null || i >= this.aFI.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (this.aFI != null) {
            if (view == null || !(view.getTag() instanceof a)) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.gZL.getPageContext().getPageActivity()).inflate(d.h.person_list_item, (ViewGroup) null);
                    aVar2.dlF = (ViewGroup) inflate.findViewById(d.g.item_view);
                    aVar2.dlF.setOnClickListener(this.dWZ);
                    aVar2.dlI = (ClickableHeaderImageView) inflate.findViewById(d.g.photo);
                    aVar2.dlI.setRadius(l.h(this.gZL.getPageContext().getPageActivity(), d.e.ds90));
                    aVar2.dlI.setAutoChangeStyle(true);
                    aVar2.dlI.setClickable(false);
                    aVar2.dlK = (LinearLayout) inflate.findViewById(d.g.info);
                    aVar2.bRo = (LinearLayout) inflate.findViewById(d.g.tail_container);
                    aVar2.mName = (TextView) inflate.findViewById(d.g.name);
                    aVar2.gZO = com.baidu.tbadk.ala.b.UK().n(this.gZL.getPageContext().getPageActivity(), 5);
                    if (aVar2.gZO != null) {
                        aVar2.gZO.setVisibility(8);
                        aVar2.bRo.addView(aVar2.gZO, 1);
                    }
                    aVar2.gZR = (TextView) inflate.findViewById(d.g.at_list_nodata);
                    aVar2.dlJ = (TextView) inflate.findViewById(d.g.intro);
                    aVar2.har = (TextView) inflate.findViewById(d.g.chat);
                    aVar2.har.setOnClickListener(this.hap);
                    aVar2.gZP = (MyFansUserLikeButton) inflate.findViewById(d.g.attention_btn);
                    aVar2.gZP.setContext(this.gZL.getPageContext());
                    aVar2.ehx = new com.baidu.tbadk.core.view.userLike.c(this.gZL.getPageContext(), aVar2.gZP);
                    aVar2.mProgress = null;
                    aVar2.mTitle = null;
                    aVar2.has = null;
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    View inflate2 = LayoutInflater.from(this.gZL.getPageContext().getPageActivity()).inflate(d.h.person_list_newheader, (ViewGroup) null);
                    aVar2.mTitle = (TextView) inflate2.findViewById(d.g.person_list_title);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.mTitle.getLayoutParams();
                    layoutParams.height = l.h(TbadkCoreApplication.getInst(), d.e.ds16);
                    aVar2.mTitle.setLayoutParams(layoutParams);
                    aVar2.has = (LinearLayout) inflate2.findViewById(d.g.newheader_root);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.gZL.getPageContext().getPageActivity()).inflate(d.h.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate3.findViewById(d.g.pb_more_text);
                    inflate3.setOnClickListener(this.gZM);
                    aVar2.mProgress = (ProgressBar) inflate3.findViewById(d.g.progress);
                    aVar2.mTitle = null;
                    aVar2.has = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.gZP != null) {
                aVar.gZP.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.gZK) {
                    aVar.dlK.setVisibility(8);
                    aVar.har.setVisibility(8);
                    aVar.gZR.setVisibility(0);
                    if (this.dBB) {
                        if (this.fDf) {
                            aVar.gZR.setText(d.j.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.gZR.setText(d.j.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.gZR.setText(d.j.him_no_attention_other);
                        } else {
                            aVar.gZR.setText(d.j.no_attention_other);
                        }
                    } else if (this.fDf) {
                        aVar.gZR.setText(d.j.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.gZR.setText(d.j.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.gZR.setText(d.j.him_no_fan_other);
                    } else {
                        aVar.gZR.setText(d.j.no_fan_other);
                    }
                } else {
                    UserData userData = (UserData) v.c(this.aFI, i);
                    if (userData == null) {
                        return null;
                    }
                    aVar.dlF.setTag(Integer.valueOf(i));
                    aVar.har.setVisibility(0);
                    aVar.gZR.setVisibility(8);
                    aVar.dlI.setShowV(userData.isBigV());
                    aVar.dlI.startLoad(userData.getPortrait(), 12, false);
                    aVar.mName.setText(userData.getName_show());
                    if (aVar.gZO != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            aVar.gZO.setVisibility(8);
                        } else {
                            aVar.gZO.setVisibility(0);
                            com.baidu.tbadk.ala.a aVar3 = new com.baidu.tbadk.ala.a();
                            aVar3.bsJ = userData.getAlaUserData();
                            aVar3.type = 5;
                            aVar.gZO.setTag(aVar3);
                        }
                    }
                    if (ap.isEmpty(userData.getIntro())) {
                        aVar.dlJ.setVisibility(8);
                    } else {
                        aVar.dlJ.setVisibility(0);
                        aVar.dlJ.setText(userData.getIntro());
                    }
                    aVar.har.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    aVar.gZP.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    aVar.ehx.a(userData);
                    aVar.ehx.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.d.1
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void dV(boolean z) {
                            if (z) {
                                l.showToast(d.this.gZL, d.j.attention_success);
                            } else {
                                l.showToast(d.this.gZL, d.j.unfollow_success);
                            }
                        }
                    });
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        aVar.gZP.setVisibility(8);
                        aVar.har.setVisibility(8);
                    } else {
                        aVar.har.setVisibility(8);
                        aVar.gZP.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else if (getItemViewType(i) != 2) {
                aVar.mName.setText(this.gZL.getPageContext().getString(d.j.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
            return view;
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.gZL.getLayoutMode().setNightMode(skinType == 1);
        this.gZL.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.har != null) {
                al.d(aVar.har, d.C0277d.btn_forum_focus_color, 1);
                al.k(aVar.har, d.f.btn_focus_border_bg);
                aVar.har.setEnabled(true);
            }
            if (aVar.has != null && aVar.mTitle != null) {
                al.l(aVar.has, d.C0277d.cp_bg_line_e);
                al.j(aVar.mTitle, d.C0277d.cp_cont_e);
            }
            if (aVar.gZP != null) {
                aVar.gZP.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.gZK) {
            return 0;
        }
        if (this.aFI == null || i >= this.aFI.size()) {
            return 1;
        }
        return this.aFI.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.gZK) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a {
        LinearLayout bRo;
        ViewGroup dlF;
        ClickableHeaderImageView dlI;
        TextView dlJ;
        LinearLayout dlK;
        com.baidu.tbadk.core.view.userLike.c ehx;
        View gZO;
        MyFansUserLikeButton gZP;
        TextView gZR;
        TextView har;
        LinearLayout has;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
