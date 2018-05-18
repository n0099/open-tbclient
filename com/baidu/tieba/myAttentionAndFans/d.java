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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
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
    boolean bIp;
    private View.OnClickListener cbT;
    boolean dyy;
    private View.OnClickListener eTI;
    private PersonListActivity eTh;
    private View.OnClickListener eTi;
    private int mSex;
    boolean eTg = false;
    private HashSet<Long> eTH = new HashSet<>();

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.eTh = null;
        this.bIp = false;
        this.dyy = true;
        this.mSex = 0;
        this.eTI = null;
        this.eTi = null;
        this.cbT = null;
        this.eTh = personListActivity;
        this.bIp = z;
        this.dyy = z2;
        this.mSex = i;
        this.eTI = onClickListener2;
        this.eTi = onClickListener3;
        this.cbT = onClickListener;
        this.adv = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(ar arVar) {
        ArrayList arrayList = new ArrayList();
        if (this.adv.isEmpty() && !v.w(arVar.rh())) {
            Iterator<UserData> it = arVar.rh().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.eTH.add(Long.valueOf(com.baidu.adp.lib.g.b.c(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(arVar.rh());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(ag(arVar.rg()));
        this.adv.addAll(arrayList);
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean cC(long j) {
        if (j == 0 || this.adv == null || this.adv.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.adv.iterator();
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
        if (!v.w(arrayList) && !this.eTH.isEmpty()) {
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.eTH.contains(Long.valueOf(com.baidu.adp.lib.g.b.c(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eTg) {
            return 1;
        }
        int i = 0;
        if (this.adv != null) {
            i = this.adv.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.adv == null || i >= this.adv.size()) {
            return null;
        }
        return this.adv.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.adv == null || i >= this.adv.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        View view3;
        a aVar;
        if (this.adv != null) {
            if (view2 == null || !(view2.getTag() instanceof a)) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.eTh.getPageContext().getPageActivity()).inflate(d.i.person_list_item, (ViewGroup) null);
                    aVar2.bso = (ViewGroup) inflate.findViewById(d.g.item_view);
                    aVar2.bso.setOnClickListener(this.cbT);
                    aVar2.bsr = (ClickableHeaderImageView) inflate.findViewById(d.g.photo);
                    aVar2.bsr.setRadius(l.e(this.eTh.getPageContext().getPageActivity(), d.e.ds90));
                    aVar2.bsr.setAutoChangeStyle(true);
                    aVar2.bsr.setClickable(false);
                    aVar2.bst = (LinearLayout) inflate.findViewById(d.g.info);
                    aVar2.anM = (LinearLayout) inflate.findViewById(d.g.tail_container);
                    aVar2.mName = (TextView) inflate.findViewById(d.g.name);
                    aVar2.eTk = com.baidu.tbadk.ala.b.or().f(this.eTh.getPageContext().getPageActivity(), 5);
                    if (aVar2.eTk != null) {
                        aVar2.eTk.setVisibility(8);
                        aVar2.anM.addView(aVar2.eTk, 1);
                    }
                    aVar2.eTn = (TextView) inflate.findViewById(d.g.at_list_nodata);
                    aVar2.bss = (TextView) inflate.findViewById(d.g.intro);
                    aVar2.eTK = (TextView) inflate.findViewById(d.g.chat);
                    aVar2.eTK.setOnClickListener(this.eTI);
                    aVar2.eTl = (MyFansUserLikeButton) inflate.findViewById(d.g.attention_btn);
                    aVar2.eTl.setContext(this.eTh.getPageContext());
                    aVar2.cpg = new com.baidu.tbadk.core.view.userLike.c(this.eTh.getPageContext(), aVar2.eTl);
                    aVar2.mProgress = null;
                    aVar2.mTitle = null;
                    aVar2.eTL = null;
                    view3 = inflate;
                } else if (getItemViewType(i) == 2) {
                    View inflate2 = LayoutInflater.from(this.eTh.getPageContext().getPageActivity()).inflate(d.i.person_list_newheader, (ViewGroup) null);
                    aVar2.mTitle = (TextView) inflate2.findViewById(d.g.person_list_title);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.mTitle.getLayoutParams();
                    layoutParams.height = l.e(TbadkCoreApplication.getInst(), d.e.ds16);
                    aVar2.mTitle.setLayoutParams(layoutParams);
                    aVar2.eTL = (LinearLayout) inflate2.findViewById(d.g.newheader_root);
                    view3 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.eTh.getPageContext().getPageActivity()).inflate(d.i.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate3.findViewById(d.g.pb_more_text);
                    inflate3.setOnClickListener(this.eTi);
                    aVar2.mProgress = (ProgressBar) inflate3.findViewById(d.g.progress);
                    aVar2.mTitle = null;
                    aVar2.eTL = null;
                    view3 = inflate3;
                }
                view3.setTag(aVar2);
                aVar = aVar2;
                view2 = view3;
            } else {
                aVar = (a) view2.getTag();
            }
            if (aVar.eTl != null) {
                aVar.eTl.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.eTg) {
                    aVar.bst.setVisibility(8);
                    aVar.eTK.setVisibility(8);
                    aVar.eTn.setVisibility(0);
                    if (this.bIp) {
                        if (this.dyy) {
                            aVar.eTn.setText(d.k.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.eTn.setText(d.k.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.eTn.setText(d.k.him_no_attention_other);
                        } else {
                            aVar.eTn.setText(d.k.no_attention_other);
                        }
                    } else if (this.dyy) {
                        aVar.eTn.setText(d.k.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.eTn.setText(d.k.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.eTn.setText(d.k.him_no_fan_other);
                    } else {
                        aVar.eTn.setText(d.k.no_fan_other);
                    }
                } else {
                    UserData userData = (UserData) v.c(this.adv, i);
                    if (userData == null) {
                        return null;
                    }
                    aVar.bso.setTag(Integer.valueOf(i));
                    aVar.eTK.setVisibility(0);
                    aVar.eTn.setVisibility(8);
                    aVar.bsr.setShowV(userData.isBigV());
                    aVar.bsr.startLoad(userData.getPortrait(), 12, false);
                    aVar.mName.setText(userData.getName_show());
                    if (aVar.eTk != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            aVar.eTk.setVisibility(8);
                        } else {
                            aVar.eTk.setVisibility(0);
                            com.baidu.tbadk.ala.a aVar3 = new com.baidu.tbadk.ala.a();
                            aVar3.Sa = userData.getAlaUserData();
                            aVar3.type = 5;
                            aVar.eTk.setTag(aVar3);
                        }
                    }
                    if (an.isEmpty(userData.getIntro())) {
                        aVar.bss.setVisibility(8);
                    } else {
                        aVar.bss.setVisibility(0);
                        aVar.bss.setText(userData.getIntro());
                    }
                    aVar.eTK.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    aVar.eTl.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    aVar.cpg.a(userData);
                    aVar.cpg.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.d.1
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void aR(boolean z) {
                            if (z) {
                                l.showToast(d.this.eTh, d.k.attention_success);
                            } else {
                                l.showToast(d.this.eTh, d.k.unfollow_success);
                            }
                        }
                    });
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        aVar.eTl.setVisibility(8);
                        aVar.eTK.setVisibility(8);
                    } else {
                        aVar.eTK.setVisibility(8);
                        aVar.eTl.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else if (getItemViewType(i) != 2) {
                aVar.mName.setText(this.eTh.getPageContext().getString(d.k.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view2, aVar);
            return view2;
        }
        return view2;
    }

    private void a(View view2, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.eTh.getLayoutMode().setNightMode(skinType == 1);
        this.eTh.getLayoutMode().u(view2);
        if (aVar != null) {
            if (aVar.eTK != null) {
                ak.c(aVar.eTK, d.C0126d.btn_forum_focus_color, 1);
                ak.i(aVar.eTK, d.f.btn_focus_border_bg);
                aVar.eTK.setEnabled(true);
            }
            if (aVar.eTL != null && aVar.mTitle != null) {
                ak.j(aVar.eTL, d.C0126d.cp_bg_line_e);
                ak.h(aVar.mTitle, d.C0126d.cp_cont_e);
            }
            if (aVar.eTl != null) {
                aVar.eTl.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.eTg) {
            return 0;
        }
        if (this.adv == null || i >= this.adv.size()) {
            return 1;
        }
        return this.adv.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.eTg) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        LinearLayout anM;
        ViewGroup bso;
        ClickableHeaderImageView bsr;
        TextView bss;
        LinearLayout bst;
        com.baidu.tbadk.core.view.userLike.c cpg;
        TextView eTK;
        LinearLayout eTL;
        View eTk;
        MyFansUserLikeButton eTl;
        TextView eTn;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
