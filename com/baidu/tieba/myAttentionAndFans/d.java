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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
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
    boolean bSA;
    private View.OnClickListener cmC;
    boolean dNa;
    private View.OnClickListener fiW;
    private PersonListActivity fir;
    private View.OnClickListener fis;
    private int mSex;
    boolean fiq = false;
    private HashSet<Long> fiV = new HashSet<>();

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.fir = null;
        this.bSA = false;
        this.dNa = true;
        this.mSex = 0;
        this.fiW = null;
        this.fis = null;
        this.cmC = null;
        this.fir = personListActivity;
        this.bSA = z;
        this.dNa = z2;
        this.mSex = i;
        this.fiW = onClickListener2;
        this.fis = onClickListener3;
        this.cmC = onClickListener;
        this.alT = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(ar arVar) {
        ArrayList arrayList = new ArrayList();
        if (this.alT.isEmpty() && !w.A(arVar.uL())) {
            Iterator<UserData> it = arVar.uL().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.fiV.add(Long.valueOf(com.baidu.adp.lib.g.b.c(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(arVar.uL());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(ak(arVar.uK()));
        this.alT.addAll(arrayList);
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean cE(long j) {
        if (j == 0 || this.alT == null || this.alT.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.alT.iterator();
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

    private ArrayList<UserData> ak(ArrayList<UserData> arrayList) {
        if (!w.A(arrayList) && !this.fiV.isEmpty()) {
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.fiV.contains(Long.valueOf(com.baidu.adp.lib.g.b.c(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fiq) {
            return 1;
        }
        int i = 0;
        if (this.alT != null) {
            i = this.alT.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.alT == null || i >= this.alT.size()) {
            return null;
        }
        return this.alT.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.alT == null || i >= this.alT.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (this.alT != null) {
            if (view == null || !(view.getTag() instanceof a)) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.fir.getPageContext().getPageActivity()).inflate(d.i.person_list_item, (ViewGroup) null);
                    aVar2.bCq = (ViewGroup) inflate.findViewById(d.g.item_view);
                    aVar2.bCq.setOnClickListener(this.cmC);
                    aVar2.bCt = (ClickableHeaderImageView) inflate.findViewById(d.g.photo);
                    aVar2.bCt.setRadius(l.e(this.fir.getPageContext().getPageActivity(), d.e.ds90));
                    aVar2.bCt.setAutoChangeStyle(true);
                    aVar2.bCt.setClickable(false);
                    aVar2.bCv = (LinearLayout) inflate.findViewById(d.g.info);
                    aVar2.awD = (LinearLayout) inflate.findViewById(d.g.tail_container);
                    aVar2.mName = (TextView) inflate.findViewById(d.g.name);
                    aVar2.fiu = com.baidu.tbadk.ala.b.rM().f(this.fir.getPageContext().getPageActivity(), 5);
                    if (aVar2.fiu != null) {
                        aVar2.fiu.setVisibility(8);
                        aVar2.awD.addView(aVar2.fiu, 1);
                    }
                    aVar2.fiy = (TextView) inflate.findViewById(d.g.at_list_nodata);
                    aVar2.bCu = (TextView) inflate.findViewById(d.g.intro);
                    aVar2.fiY = (TextView) inflate.findViewById(d.g.chat);
                    aVar2.fiY.setOnClickListener(this.fiW);
                    aVar2.fiv = (MyFansUserLikeButton) inflate.findViewById(d.g.attention_btn);
                    aVar2.fiv.setContext(this.fir.getPageContext());
                    aVar2.cvR = new com.baidu.tbadk.core.view.userLike.c(this.fir.getPageContext(), aVar2.fiv);
                    aVar2.mProgress = null;
                    aVar2.mTitle = null;
                    aVar2.fiZ = null;
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    View inflate2 = LayoutInflater.from(this.fir.getPageContext().getPageActivity()).inflate(d.i.person_list_newheader, (ViewGroup) null);
                    aVar2.mTitle = (TextView) inflate2.findViewById(d.g.person_list_title);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.mTitle.getLayoutParams();
                    layoutParams.height = l.e(TbadkCoreApplication.getInst(), d.e.ds16);
                    aVar2.mTitle.setLayoutParams(layoutParams);
                    aVar2.fiZ = (LinearLayout) inflate2.findViewById(d.g.newheader_root);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.fir.getPageContext().getPageActivity()).inflate(d.i.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate3.findViewById(d.g.pb_more_text);
                    inflate3.setOnClickListener(this.fis);
                    aVar2.mProgress = (ProgressBar) inflate3.findViewById(d.g.progress);
                    aVar2.mTitle = null;
                    aVar2.fiZ = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.fiv != null) {
                aVar.fiv.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.fiq) {
                    aVar.bCv.setVisibility(8);
                    aVar.fiY.setVisibility(8);
                    aVar.fiy.setVisibility(0);
                    if (this.bSA) {
                        if (this.dNa) {
                            aVar.fiy.setText(d.k.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.fiy.setText(d.k.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.fiy.setText(d.k.him_no_attention_other);
                        } else {
                            aVar.fiy.setText(d.k.no_attention_other);
                        }
                    } else if (this.dNa) {
                        aVar.fiy.setText(d.k.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.fiy.setText(d.k.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.fiy.setText(d.k.him_no_fan_other);
                    } else {
                        aVar.fiy.setText(d.k.no_fan_other);
                    }
                } else {
                    UserData userData = (UserData) w.d(this.alT, i);
                    if (userData == null) {
                        return null;
                    }
                    aVar.bCq.setTag(Integer.valueOf(i));
                    aVar.fiY.setVisibility(0);
                    aVar.fiy.setVisibility(8);
                    aVar.bCt.setShowV(userData.isBigV());
                    aVar.bCt.startLoad(userData.getPortrait(), 12, false);
                    aVar.mName.setText(userData.getName_show());
                    if (aVar.fiu != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            aVar.fiu.setVisibility(8);
                        } else {
                            aVar.fiu.setVisibility(0);
                            com.baidu.tbadk.ala.a aVar3 = new com.baidu.tbadk.ala.a();
                            aVar3.aan = userData.getAlaUserData();
                            aVar3.type = 5;
                            aVar.fiu.setTag(aVar3);
                        }
                    }
                    if (ap.isEmpty(userData.getIntro())) {
                        aVar.bCu.setVisibility(8);
                    } else {
                        aVar.bCu.setVisibility(0);
                        aVar.bCu.setText(userData.getIntro());
                    }
                    aVar.fiY.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    aVar.fiv.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    aVar.cvR.a(userData);
                    aVar.cvR.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.d.1
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void aY(boolean z) {
                            if (z) {
                                l.showToast(d.this.fir, d.k.attention_success);
                            } else {
                                l.showToast(d.this.fir, d.k.unfollow_success);
                            }
                        }
                    });
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        aVar.fiv.setVisibility(8);
                        aVar.fiY.setVisibility(8);
                    } else {
                        aVar.fiY.setVisibility(8);
                        aVar.fiv.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else if (getItemViewType(i) != 2) {
                aVar.mName.setText(this.fir.getPageContext().getString(d.k.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
            return view;
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.fir.getLayoutMode().setNightMode(skinType == 1);
        this.fir.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.fiY != null) {
                am.c(aVar.fiY, d.C0142d.btn_forum_focus_color, 1);
                am.i(aVar.fiY, d.f.btn_focus_border_bg);
                aVar.fiY.setEnabled(true);
            }
            if (aVar.fiZ != null && aVar.mTitle != null) {
                am.j(aVar.fiZ, d.C0142d.cp_bg_line_e);
                am.h(aVar.mTitle, d.C0142d.cp_cont_e);
            }
            if (aVar.fiv != null) {
                aVar.fiv.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fiq) {
            return 0;
        }
        if (this.alT == null || i >= this.alT.size()) {
            return 1;
        }
        return this.alT.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fiq) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        LinearLayout awD;
        ViewGroup bCq;
        ClickableHeaderImageView bCt;
        TextView bCu;
        LinearLayout bCv;
        com.baidu.tbadk.core.view.userLike.c cvR;
        TextView fiY;
        LinearLayout fiZ;
        View fiu;
        MyFansUserLikeButton fiv;
        TextView fiy;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
