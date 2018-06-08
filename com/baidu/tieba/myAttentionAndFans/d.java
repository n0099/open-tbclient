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
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
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
    boolean bQr;
    private View.OnClickListener cjX;
    boolean dJI;
    private View.OnClickListener feA;
    private PersonListActivity fez;
    private View.OnClickListener ffa;
    private int mSex;
    boolean fey = false;
    private HashSet<Long> feZ = new HashSet<>();

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.fez = null;
        this.bQr = false;
        this.dJI = true;
        this.mSex = 0;
        this.ffa = null;
        this.feA = null;
        this.cjX = null;
        this.fez = personListActivity;
        this.bQr = z;
        this.dJI = z2;
        this.mSex = i;
        this.ffa = onClickListener2;
        this.feA = onClickListener3;
        this.cjX = onClickListener;
        this.alt = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(ar arVar) {
        ArrayList arrayList = new ArrayList();
        if (this.alt.isEmpty() && !w.z(arVar.uD())) {
            Iterator<UserData> it = arVar.uD().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.feZ.add(Long.valueOf(com.baidu.adp.lib.g.b.c(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(arVar.uD());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(ag(arVar.uC()));
        this.alt.addAll(arrayList);
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean cI(long j) {
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

    private ArrayList<UserData> ag(ArrayList<UserData> arrayList) {
        if (!w.z(arrayList) && !this.feZ.isEmpty()) {
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.feZ.contains(Long.valueOf(com.baidu.adp.lib.g.b.c(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fey) {
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
                    View inflate = LayoutInflater.from(this.fez.getPageContext().getPageActivity()).inflate(d.i.person_list_item, (ViewGroup) null);
                    aVar2.bAt = (ViewGroup) inflate.findViewById(d.g.item_view);
                    aVar2.bAt.setOnClickListener(this.cjX);
                    aVar2.bAw = (ClickableHeaderImageView) inflate.findViewById(d.g.photo);
                    aVar2.bAw.setRadius(l.e(this.fez.getPageContext().getPageActivity(), d.e.ds90));
                    aVar2.bAw.setAutoChangeStyle(true);
                    aVar2.bAw.setClickable(false);
                    aVar2.bAy = (LinearLayout) inflate.findViewById(d.g.info);
                    aVar2.avU = (LinearLayout) inflate.findViewById(d.g.tail_container);
                    aVar2.mName = (TextView) inflate.findViewById(d.g.name);
                    aVar2.feC = com.baidu.tbadk.ala.b.rM().f(this.fez.getPageContext().getPageActivity(), 5);
                    if (aVar2.feC != null) {
                        aVar2.feC.setVisibility(8);
                        aVar2.avU.addView(aVar2.feC, 1);
                    }
                    aVar2.feF = (TextView) inflate.findViewById(d.g.at_list_nodata);
                    aVar2.bAx = (TextView) inflate.findViewById(d.g.intro);
                    aVar2.ffc = (TextView) inflate.findViewById(d.g.chat);
                    aVar2.ffc.setOnClickListener(this.ffa);
                    aVar2.feD = (MyFansUserLikeButton) inflate.findViewById(d.g.attention_btn);
                    aVar2.feD.setContext(this.fez.getPageContext());
                    aVar2.cxK = new com.baidu.tbadk.core.view.userLike.c(this.fez.getPageContext(), aVar2.feD);
                    aVar2.mProgress = null;
                    aVar2.mTitle = null;
                    aVar2.ffd = null;
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    View inflate2 = LayoutInflater.from(this.fez.getPageContext().getPageActivity()).inflate(d.i.person_list_newheader, (ViewGroup) null);
                    aVar2.mTitle = (TextView) inflate2.findViewById(d.g.person_list_title);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.mTitle.getLayoutParams();
                    layoutParams.height = l.e(TbadkCoreApplication.getInst(), d.e.ds16);
                    aVar2.mTitle.setLayoutParams(layoutParams);
                    aVar2.ffd = (LinearLayout) inflate2.findViewById(d.g.newheader_root);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.fez.getPageContext().getPageActivity()).inflate(d.i.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate3.findViewById(d.g.pb_more_text);
                    inflate3.setOnClickListener(this.feA);
                    aVar2.mProgress = (ProgressBar) inflate3.findViewById(d.g.progress);
                    aVar2.mTitle = null;
                    aVar2.ffd = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.feD != null) {
                aVar.feD.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.fey) {
                    aVar.bAy.setVisibility(8);
                    aVar.ffc.setVisibility(8);
                    aVar.feF.setVisibility(0);
                    if (this.bQr) {
                        if (this.dJI) {
                            aVar.feF.setText(d.k.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.feF.setText(d.k.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.feF.setText(d.k.him_no_attention_other);
                        } else {
                            aVar.feF.setText(d.k.no_attention_other);
                        }
                    } else if (this.dJI) {
                        aVar.feF.setText(d.k.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.feF.setText(d.k.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.feF.setText(d.k.him_no_fan_other);
                    } else {
                        aVar.feF.setText(d.k.no_fan_other);
                    }
                } else {
                    UserData userData = (UserData) w.c(this.alt, i);
                    if (userData == null) {
                        return null;
                    }
                    aVar.bAt.setTag(Integer.valueOf(i));
                    aVar.ffc.setVisibility(0);
                    aVar.feF.setVisibility(8);
                    aVar.bAw.setShowV(userData.isBigV());
                    aVar.bAw.startLoad(userData.getPortrait(), 12, false);
                    aVar.mName.setText(userData.getName_show());
                    if (aVar.feC != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            aVar.feC.setVisibility(8);
                        } else {
                            aVar.feC.setVisibility(0);
                            com.baidu.tbadk.ala.a aVar3 = new com.baidu.tbadk.ala.a();
                            aVar3.aak = userData.getAlaUserData();
                            aVar3.type = 5;
                            aVar.feC.setTag(aVar3);
                        }
                    }
                    if (ao.isEmpty(userData.getIntro())) {
                        aVar.bAx.setVisibility(8);
                    } else {
                        aVar.bAx.setVisibility(0);
                        aVar.bAx.setText(userData.getIntro());
                    }
                    aVar.ffc.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    aVar.feD.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    aVar.cxK.a(userData);
                    aVar.cxK.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.d.1
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void aV(boolean z) {
                            if (z) {
                                l.showToast(d.this.fez, d.k.attention_success);
                            } else {
                                l.showToast(d.this.fez, d.k.unfollow_success);
                            }
                        }
                    });
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        aVar.feD.setVisibility(8);
                        aVar.ffc.setVisibility(8);
                    } else {
                        aVar.ffc.setVisibility(8);
                        aVar.feD.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else if (getItemViewType(i) != 2) {
                aVar.mName.setText(this.fez.getPageContext().getString(d.k.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
            return view;
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.fez.getLayoutMode().setNightMode(skinType == 1);
        this.fez.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.ffc != null) {
                al.c(aVar.ffc, d.C0141d.btn_forum_focus_color, 1);
                al.i(aVar.ffc, d.f.btn_focus_border_bg);
                aVar.ffc.setEnabled(true);
            }
            if (aVar.ffd != null && aVar.mTitle != null) {
                al.j(aVar.ffd, d.C0141d.cp_bg_line_e);
                al.h(aVar.mTitle, d.C0141d.cp_cont_e);
            }
            if (aVar.feD != null) {
                aVar.feD.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fey) {
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
        if (this.fey) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        LinearLayout avU;
        ViewGroup bAt;
        ClickableHeaderImageView bAw;
        TextView bAx;
        LinearLayout bAy;
        com.baidu.tbadk.core.view.userLike.c cxK;
        View feC;
        MyFansUserLikeButton feD;
        TextView feF;
        TextView ffc;
        LinearLayout ffd;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
