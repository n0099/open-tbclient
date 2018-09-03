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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class d extends b {
    boolean bTu;
    private View.OnClickListener con;
    boolean dPJ;
    private PersonListActivity fiy;
    private View.OnClickListener fiz;
    private View.OnClickListener fjc;
    private int mSex;
    boolean fiw = false;
    private HashSet<Long> fjb = new HashSet<>();

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.fiy = null;
        this.bTu = false;
        this.dPJ = true;
        this.mSex = 0;
        this.fjc = null;
        this.fiz = null;
        this.con = null;
        this.fiy = personListActivity;
        this.bTu = z;
        this.dPJ = z2;
        this.mSex = i;
        this.fjc = onClickListener2;
        this.fiz = onClickListener3;
        this.con = onClickListener;
        this.als = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(aq aqVar) {
        ArrayList arrayList = new ArrayList();
        if (this.als.isEmpty() && !w.z(aqVar.ux())) {
            Iterator<UserData> it = aqVar.ux().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.fjb.add(Long.valueOf(com.baidu.adp.lib.g.b.c(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(aqVar.ux());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(ai(aqVar.uw()));
        this.als.addAll(arrayList);
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean cA(long j) {
        if (j == 0 || this.als == null || this.als.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.als.iterator();
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
        if (!w.z(arrayList) && !this.fjb.isEmpty()) {
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.fjb.contains(Long.valueOf(com.baidu.adp.lib.g.b.c(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fiw) {
            return 1;
        }
        int i = 0;
        if (this.als != null) {
            i = this.als.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.als == null || i >= this.als.size()) {
            return null;
        }
        return this.als.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.als == null || i >= this.als.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (this.als != null) {
            if (view == null || !(view.getTag() instanceof a)) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.fiy.getPageContext().getPageActivity()).inflate(f.h.person_list_item, (ViewGroup) null);
                    aVar2.bCY = (ViewGroup) inflate.findViewById(f.g.item_view);
                    aVar2.bCY.setOnClickListener(this.con);
                    aVar2.bDb = (ClickableHeaderImageView) inflate.findViewById(f.g.photo);
                    aVar2.bDb.setRadius(l.f(this.fiy.getPageContext().getPageActivity(), f.e.ds90));
                    aVar2.bDb.setAutoChangeStyle(true);
                    aVar2.bDb.setClickable(false);
                    aVar2.bDd = (LinearLayout) inflate.findViewById(f.g.info);
                    aVar2.awg = (LinearLayout) inflate.findViewById(f.g.tail_container);
                    aVar2.mName = (TextView) inflate.findViewById(f.g.name);
                    aVar2.fiB = com.baidu.tbadk.ala.b.rv().g(this.fiy.getPageContext().getPageActivity(), 5);
                    if (aVar2.fiB != null) {
                        aVar2.fiB.setVisibility(8);
                        aVar2.awg.addView(aVar2.fiB, 1);
                    }
                    aVar2.fiE = (TextView) inflate.findViewById(f.g.at_list_nodata);
                    aVar2.bDc = (TextView) inflate.findViewById(f.g.intro);
                    aVar2.fje = (TextView) inflate.findViewById(f.g.chat);
                    aVar2.fje.setOnClickListener(this.fjc);
                    aVar2.fiC = (MyFansUserLikeButton) inflate.findViewById(f.g.attention_btn);
                    aVar2.fiC.setContext(this.fiy.getPageContext());
                    aVar2.cyq = new com.baidu.tbadk.core.view.userLike.c(this.fiy.getPageContext(), aVar2.fiC);
                    aVar2.mProgress = null;
                    aVar2.mTitle = null;
                    aVar2.fjf = null;
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    View inflate2 = LayoutInflater.from(this.fiy.getPageContext().getPageActivity()).inflate(f.h.person_list_newheader, (ViewGroup) null);
                    aVar2.mTitle = (TextView) inflate2.findViewById(f.g.person_list_title);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.mTitle.getLayoutParams();
                    layoutParams.height = l.f(TbadkCoreApplication.getInst(), f.e.ds16);
                    aVar2.mTitle.setLayoutParams(layoutParams);
                    aVar2.fjf = (LinearLayout) inflate2.findViewById(f.g.newheader_root);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.fiy.getPageContext().getPageActivity()).inflate(f.h.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate3.findViewById(f.g.pb_more_text);
                    inflate3.setOnClickListener(this.fiz);
                    aVar2.mProgress = (ProgressBar) inflate3.findViewById(f.g.progress);
                    aVar2.mTitle = null;
                    aVar2.fjf = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.fiC != null) {
                aVar.fiC.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.fiw) {
                    aVar.bDd.setVisibility(8);
                    aVar.fje.setVisibility(8);
                    aVar.fiE.setVisibility(0);
                    if (this.bTu) {
                        if (this.dPJ) {
                            aVar.fiE.setText(f.j.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.fiE.setText(f.j.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.fiE.setText(f.j.him_no_attention_other);
                        } else {
                            aVar.fiE.setText(f.j.no_attention_other);
                        }
                    } else if (this.dPJ) {
                        aVar.fiE.setText(f.j.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.fiE.setText(f.j.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.fiE.setText(f.j.him_no_fan_other);
                    } else {
                        aVar.fiE.setText(f.j.no_fan_other);
                    }
                } else {
                    UserData userData = (UserData) w.d(this.als, i);
                    if (userData == null) {
                        return null;
                    }
                    aVar.bCY.setTag(Integer.valueOf(i));
                    aVar.fje.setVisibility(0);
                    aVar.fiE.setVisibility(8);
                    aVar.bDb.setShowV(userData.isBigV());
                    aVar.bDb.startLoad(userData.getPortrait(), 12, false);
                    aVar.mName.setText(userData.getName_show());
                    if (aVar.fiB != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            aVar.fiB.setVisibility(8);
                        } else {
                            aVar.fiB.setVisibility(0);
                            com.baidu.tbadk.ala.a aVar3 = new com.baidu.tbadk.ala.a();
                            aVar3.ZS = userData.getAlaUserData();
                            aVar3.type = 5;
                            aVar.fiB.setTag(aVar3);
                        }
                    }
                    if (ap.isEmpty(userData.getIntro())) {
                        aVar.bDc.setVisibility(8);
                    } else {
                        aVar.bDc.setVisibility(0);
                        aVar.bDc.setText(userData.getIntro());
                    }
                    aVar.fje.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    aVar.fiC.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    aVar.cyq.a(userData);
                    aVar.cyq.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.d.1
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void aX(boolean z) {
                            if (z) {
                                l.showToast(d.this.fiy, f.j.attention_success);
                            } else {
                                l.showToast(d.this.fiy, f.j.unfollow_success);
                            }
                        }
                    });
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        aVar.fiC.setVisibility(8);
                        aVar.fje.setVisibility(8);
                    } else {
                        aVar.fje.setVisibility(8);
                        aVar.fiC.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else if (getItemViewType(i) != 2) {
                aVar.mName.setText(this.fiy.getPageContext().getString(f.j.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
            return view;
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.fiy.getLayoutMode().setNightMode(skinType == 1);
        this.fiy.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.fje != null) {
                am.c(aVar.fje, f.d.btn_forum_focus_color, 1);
                am.i(aVar.fje, f.C0146f.btn_focus_border_bg);
                aVar.fje.setEnabled(true);
            }
            if (aVar.fjf != null && aVar.mTitle != null) {
                am.j(aVar.fjf, f.d.cp_bg_line_e);
                am.h(aVar.mTitle, f.d.cp_cont_e);
            }
            if (aVar.fiC != null) {
                aVar.fiC.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fiw) {
            return 0;
        }
        if (this.als == null || i >= this.als.size()) {
            return 1;
        }
        return this.als.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fiw) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        LinearLayout awg;
        ViewGroup bCY;
        ClickableHeaderImageView bDb;
        TextView bDc;
        LinearLayout bDd;
        com.baidu.tbadk.core.view.userLike.c cyq;
        View fiB;
        MyFansUserLikeButton fiC;
        TextView fiE;
        TextView fje;
        LinearLayout fjf;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
