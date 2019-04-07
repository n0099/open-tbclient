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
    boolean dAR;
    private View.OnClickListener dWx;
    boolean fCT;
    private PersonListActivity gZy;
    private View.OnClickListener gZz;
    private View.OnClickListener hac;
    private int mSex;
    boolean gZx = false;
    private HashSet<Long> hab = new HashSet<>();

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.gZy = null;
        this.dAR = false;
        this.fCT = true;
        this.mSex = 0;
        this.hac = null;
        this.gZz = null;
        this.dWx = null;
        this.gZy = personListActivity;
        this.dAR = z;
        this.fCT = z2;
        this.mSex = i;
        this.hac = onClickListener2;
        this.gZz = onClickListener3;
        this.dWx = onClickListener;
        this.aFL = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(as asVar) {
        ArrayList arrayList = new ArrayList();
        if (this.aFL.isEmpty() && !v.T(asVar.XL())) {
            Iterator<UserData> it = asVar.XL().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.hab.add(Long.valueOf(com.baidu.adp.lib.g.b.d(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(asVar.XL());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(al(asVar.XK()));
        this.aFL.addAll(arrayList);
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean dx(long j) {
        if (j == 0 || this.aFL == null || this.aFL.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.aFL.iterator();
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
        if (!v.T(arrayList) && !this.hab.isEmpty()) {
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.hab.contains(Long.valueOf(com.baidu.adp.lib.g.b.d(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gZx) {
            return 1;
        }
        int i = 0;
        if (this.aFL != null) {
            i = this.aFL.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aFL == null || i >= this.aFL.size()) {
            return null;
        }
        return this.aFL.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.aFL == null || i >= this.aFL.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (this.aFL != null) {
            if (view == null || !(view.getTag() instanceof a)) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.gZy.getPageContext().getPageActivity()).inflate(d.h.person_list_item, (ViewGroup) null);
                    aVar2.dlI = (ViewGroup) inflate.findViewById(d.g.item_view);
                    aVar2.dlI.setOnClickListener(this.dWx);
                    aVar2.dlL = (ClickableHeaderImageView) inflate.findViewById(d.g.photo);
                    aVar2.dlL.setRadius(l.h(this.gZy.getPageContext().getPageActivity(), d.e.ds90));
                    aVar2.dlL.setAutoChangeStyle(true);
                    aVar2.dlL.setClickable(false);
                    aVar2.dlN = (LinearLayout) inflate.findViewById(d.g.info);
                    aVar2.bRq = (LinearLayout) inflate.findViewById(d.g.tail_container);
                    aVar2.mName = (TextView) inflate.findViewById(d.g.name);
                    aVar2.gZB = com.baidu.tbadk.ala.b.UH().n(this.gZy.getPageContext().getPageActivity(), 5);
                    if (aVar2.gZB != null) {
                        aVar2.gZB.setVisibility(8);
                        aVar2.bRq.addView(aVar2.gZB, 1);
                    }
                    aVar2.gZE = (TextView) inflate.findViewById(d.g.at_list_nodata);
                    aVar2.dlM = (TextView) inflate.findViewById(d.g.intro);
                    aVar2.hae = (TextView) inflate.findViewById(d.g.chat);
                    aVar2.hae.setOnClickListener(this.hac);
                    aVar2.gZC = (MyFansUserLikeButton) inflate.findViewById(d.g.attention_btn);
                    aVar2.gZC.setContext(this.gZy.getPageContext());
                    aVar2.ehj = new com.baidu.tbadk.core.view.userLike.c(this.gZy.getPageContext(), aVar2.gZC);
                    aVar2.mProgress = null;
                    aVar2.mTitle = null;
                    aVar2.haf = null;
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    View inflate2 = LayoutInflater.from(this.gZy.getPageContext().getPageActivity()).inflate(d.h.person_list_newheader, (ViewGroup) null);
                    aVar2.mTitle = (TextView) inflate2.findViewById(d.g.person_list_title);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.mTitle.getLayoutParams();
                    layoutParams.height = l.h(TbadkCoreApplication.getInst(), d.e.ds16);
                    aVar2.mTitle.setLayoutParams(layoutParams);
                    aVar2.haf = (LinearLayout) inflate2.findViewById(d.g.newheader_root);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.gZy.getPageContext().getPageActivity()).inflate(d.h.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate3.findViewById(d.g.pb_more_text);
                    inflate3.setOnClickListener(this.gZz);
                    aVar2.mProgress = (ProgressBar) inflate3.findViewById(d.g.progress);
                    aVar2.mTitle = null;
                    aVar2.haf = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.gZC != null) {
                aVar.gZC.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.gZx) {
                    aVar.dlN.setVisibility(8);
                    aVar.hae.setVisibility(8);
                    aVar.gZE.setVisibility(0);
                    if (this.dAR) {
                        if (this.fCT) {
                            aVar.gZE.setText(d.j.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.gZE.setText(d.j.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.gZE.setText(d.j.him_no_attention_other);
                        } else {
                            aVar.gZE.setText(d.j.no_attention_other);
                        }
                    } else if (this.fCT) {
                        aVar.gZE.setText(d.j.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.gZE.setText(d.j.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.gZE.setText(d.j.him_no_fan_other);
                    } else {
                        aVar.gZE.setText(d.j.no_fan_other);
                    }
                } else {
                    UserData userData = (UserData) v.c(this.aFL, i);
                    if (userData == null) {
                        return null;
                    }
                    aVar.dlI.setTag(Integer.valueOf(i));
                    aVar.hae.setVisibility(0);
                    aVar.gZE.setVisibility(8);
                    aVar.dlL.setShowV(userData.isBigV());
                    aVar.dlL.startLoad(userData.getPortrait(), 12, false);
                    aVar.mName.setText(userData.getName_show());
                    if (aVar.gZB != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            aVar.gZB.setVisibility(8);
                        } else {
                            aVar.gZB.setVisibility(0);
                            com.baidu.tbadk.ala.a aVar3 = new com.baidu.tbadk.ala.a();
                            aVar3.bsM = userData.getAlaUserData();
                            aVar3.type = 5;
                            aVar.gZB.setTag(aVar3);
                        }
                    }
                    if (ap.isEmpty(userData.getIntro())) {
                        aVar.dlM.setVisibility(8);
                    } else {
                        aVar.dlM.setVisibility(0);
                        aVar.dlM.setText(userData.getIntro());
                    }
                    aVar.hae.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    aVar.gZC.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    aVar.ehj.a(userData);
                    aVar.ehj.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.d.1
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void dV(boolean z) {
                            if (z) {
                                l.showToast(d.this.gZy, d.j.attention_success);
                            } else {
                                l.showToast(d.this.gZy, d.j.unfollow_success);
                            }
                        }
                    });
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        aVar.gZC.setVisibility(8);
                        aVar.hae.setVisibility(8);
                    } else {
                        aVar.hae.setVisibility(8);
                        aVar.gZC.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else if (getItemViewType(i) != 2) {
                aVar.mName.setText(this.gZy.getPageContext().getString(d.j.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
            return view;
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.gZy.getLayoutMode().setNightMode(skinType == 1);
        this.gZy.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.hae != null) {
                al.d(aVar.hae, d.C0277d.btn_forum_focus_color, 1);
                al.k(aVar.hae, d.f.btn_focus_border_bg);
                aVar.hae.setEnabled(true);
            }
            if (aVar.haf != null && aVar.mTitle != null) {
                al.l(aVar.haf, d.C0277d.cp_bg_line_e);
                al.j(aVar.mTitle, d.C0277d.cp_cont_e);
            }
            if (aVar.gZC != null) {
                aVar.gZC.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.gZx) {
            return 0;
        }
        if (this.aFL == null || i >= this.aFL.size()) {
            return 1;
        }
        return this.aFL.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.gZx) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a {
        LinearLayout bRq;
        ViewGroup dlI;
        ClickableHeaderImageView dlL;
        TextView dlM;
        LinearLayout dlN;
        com.baidu.tbadk.core.view.userLike.c ehj;
        View gZB;
        MyFansUserLikeButton gZC;
        TextView gZE;
        TextView hae;
        LinearLayout haf;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
