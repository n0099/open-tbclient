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
    boolean dAS;
    private View.OnClickListener dWy;
    boolean fCT;
    private View.OnClickListener gZA;
    private PersonListActivity gZz;
    private View.OnClickListener had;
    private int mSex;
    boolean gZy = false;
    private HashSet<Long> hac = new HashSet<>();

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.gZz = null;
        this.dAS = false;
        this.fCT = true;
        this.mSex = 0;
        this.had = null;
        this.gZA = null;
        this.dWy = null;
        this.gZz = personListActivity;
        this.dAS = z;
        this.fCT = z2;
        this.mSex = i;
        this.had = onClickListener2;
        this.gZA = onClickListener3;
        this.dWy = onClickListener;
        this.aFM = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(as asVar) {
        ArrayList arrayList = new ArrayList();
        if (this.aFM.isEmpty() && !v.T(asVar.XL())) {
            Iterator<UserData> it = asVar.XL().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.hac.add(Long.valueOf(com.baidu.adp.lib.g.b.d(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(asVar.XL());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(al(asVar.XK()));
        this.aFM.addAll(arrayList);
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean dx(long j) {
        if (j == 0 || this.aFM == null || this.aFM.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.aFM.iterator();
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
        if (!v.T(arrayList) && !this.hac.isEmpty()) {
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.hac.contains(Long.valueOf(com.baidu.adp.lib.g.b.d(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gZy) {
            return 1;
        }
        int i = 0;
        if (this.aFM != null) {
            i = this.aFM.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aFM == null || i >= this.aFM.size()) {
            return null;
        }
        return this.aFM.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.aFM == null || i >= this.aFM.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (this.aFM != null) {
            if (view == null || !(view.getTag() instanceof a)) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.gZz.getPageContext().getPageActivity()).inflate(d.h.person_list_item, (ViewGroup) null);
                    aVar2.dlJ = (ViewGroup) inflate.findViewById(d.g.item_view);
                    aVar2.dlJ.setOnClickListener(this.dWy);
                    aVar2.dlM = (ClickableHeaderImageView) inflate.findViewById(d.g.photo);
                    aVar2.dlM.setRadius(l.h(this.gZz.getPageContext().getPageActivity(), d.e.ds90));
                    aVar2.dlM.setAutoChangeStyle(true);
                    aVar2.dlM.setClickable(false);
                    aVar2.dlO = (LinearLayout) inflate.findViewById(d.g.info);
                    aVar2.bRr = (LinearLayout) inflate.findViewById(d.g.tail_container);
                    aVar2.mName = (TextView) inflate.findViewById(d.g.name);
                    aVar2.gZC = com.baidu.tbadk.ala.b.UH().n(this.gZz.getPageContext().getPageActivity(), 5);
                    if (aVar2.gZC != null) {
                        aVar2.gZC.setVisibility(8);
                        aVar2.bRr.addView(aVar2.gZC, 1);
                    }
                    aVar2.gZF = (TextView) inflate.findViewById(d.g.at_list_nodata);
                    aVar2.dlN = (TextView) inflate.findViewById(d.g.intro);
                    aVar2.haf = (TextView) inflate.findViewById(d.g.chat);
                    aVar2.haf.setOnClickListener(this.had);
                    aVar2.gZD = (MyFansUserLikeButton) inflate.findViewById(d.g.attention_btn);
                    aVar2.gZD.setContext(this.gZz.getPageContext());
                    aVar2.ehk = new com.baidu.tbadk.core.view.userLike.c(this.gZz.getPageContext(), aVar2.gZD);
                    aVar2.mProgress = null;
                    aVar2.mTitle = null;
                    aVar2.hag = null;
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    View inflate2 = LayoutInflater.from(this.gZz.getPageContext().getPageActivity()).inflate(d.h.person_list_newheader, (ViewGroup) null);
                    aVar2.mTitle = (TextView) inflate2.findViewById(d.g.person_list_title);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.mTitle.getLayoutParams();
                    layoutParams.height = l.h(TbadkCoreApplication.getInst(), d.e.ds16);
                    aVar2.mTitle.setLayoutParams(layoutParams);
                    aVar2.hag = (LinearLayout) inflate2.findViewById(d.g.newheader_root);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.gZz.getPageContext().getPageActivity()).inflate(d.h.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate3.findViewById(d.g.pb_more_text);
                    inflate3.setOnClickListener(this.gZA);
                    aVar2.mProgress = (ProgressBar) inflate3.findViewById(d.g.progress);
                    aVar2.mTitle = null;
                    aVar2.hag = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.gZD != null) {
                aVar.gZD.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.gZy) {
                    aVar.dlO.setVisibility(8);
                    aVar.haf.setVisibility(8);
                    aVar.gZF.setVisibility(0);
                    if (this.dAS) {
                        if (this.fCT) {
                            aVar.gZF.setText(d.j.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.gZF.setText(d.j.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.gZF.setText(d.j.him_no_attention_other);
                        } else {
                            aVar.gZF.setText(d.j.no_attention_other);
                        }
                    } else if (this.fCT) {
                        aVar.gZF.setText(d.j.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.gZF.setText(d.j.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.gZF.setText(d.j.him_no_fan_other);
                    } else {
                        aVar.gZF.setText(d.j.no_fan_other);
                    }
                } else {
                    UserData userData = (UserData) v.c(this.aFM, i);
                    if (userData == null) {
                        return null;
                    }
                    aVar.dlJ.setTag(Integer.valueOf(i));
                    aVar.haf.setVisibility(0);
                    aVar.gZF.setVisibility(8);
                    aVar.dlM.setShowV(userData.isBigV());
                    aVar.dlM.startLoad(userData.getPortrait(), 12, false);
                    aVar.mName.setText(userData.getName_show());
                    if (aVar.gZC != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            aVar.gZC.setVisibility(8);
                        } else {
                            aVar.gZC.setVisibility(0);
                            com.baidu.tbadk.ala.a aVar3 = new com.baidu.tbadk.ala.a();
                            aVar3.bsN = userData.getAlaUserData();
                            aVar3.type = 5;
                            aVar.gZC.setTag(aVar3);
                        }
                    }
                    if (ap.isEmpty(userData.getIntro())) {
                        aVar.dlN.setVisibility(8);
                    } else {
                        aVar.dlN.setVisibility(0);
                        aVar.dlN.setText(userData.getIntro());
                    }
                    aVar.haf.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    aVar.gZD.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    aVar.ehk.a(userData);
                    aVar.ehk.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.d.1
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void dV(boolean z) {
                            if (z) {
                                l.showToast(d.this.gZz, d.j.attention_success);
                            } else {
                                l.showToast(d.this.gZz, d.j.unfollow_success);
                            }
                        }
                    });
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        aVar.gZD.setVisibility(8);
                        aVar.haf.setVisibility(8);
                    } else {
                        aVar.haf.setVisibility(8);
                        aVar.gZD.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else if (getItemViewType(i) != 2) {
                aVar.mName.setText(this.gZz.getPageContext().getString(d.j.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
            return view;
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.gZz.getLayoutMode().setNightMode(skinType == 1);
        this.gZz.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.haf != null) {
                al.d(aVar.haf, d.C0277d.btn_forum_focus_color, 1);
                al.k(aVar.haf, d.f.btn_focus_border_bg);
                aVar.haf.setEnabled(true);
            }
            if (aVar.hag != null && aVar.mTitle != null) {
                al.l(aVar.hag, d.C0277d.cp_bg_line_e);
                al.j(aVar.mTitle, d.C0277d.cp_cont_e);
            }
            if (aVar.gZD != null) {
                aVar.gZD.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.gZy) {
            return 0;
        }
        if (this.aFM == null || i >= this.aFM.size()) {
            return 1;
        }
        return this.aFM.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.gZy) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a {
        LinearLayout bRr;
        ViewGroup dlJ;
        ClickableHeaderImageView dlM;
        TextView dlN;
        LinearLayout dlO;
        com.baidu.tbadk.core.view.userLike.c ehk;
        View gZC;
        MyFansUserLikeButton gZD;
        TextView gZF;
        TextView haf;
        LinearLayout hag;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
