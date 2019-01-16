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
    private View.OnClickListener cJz;
    boolean cmE;
    boolean eqF;
    private View.OnClickListener fJA;
    private PersonListActivity fJz;
    private View.OnClickListener fKd;
    private int mSex;
    boolean fJy = false;
    private HashSet<Long> fKc = new HashSet<>();

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.fJz = null;
        this.cmE = false;
        this.eqF = true;
        this.mSex = 0;
        this.fKd = null;
        this.fJA = null;
        this.cJz = null;
        this.fJz = personListActivity;
        this.cmE = z;
        this.eqF = z2;
        this.mSex = i;
        this.fKd = onClickListener2;
        this.fJA = onClickListener3;
        this.cJz = onClickListener;
        this.mData = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(aq aqVar) {
        ArrayList arrayList = new ArrayList();
        if (this.mData.isEmpty() && !v.I(aqVar.zh())) {
            Iterator<UserData> it = aqVar.zh().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.fKc.add(Long.valueOf(com.baidu.adp.lib.g.b.d(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(aqVar.zh());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(ah(aqVar.zg()));
        this.mData.addAll(arrayList);
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean cS(long j) {
        if (j == 0 || this.mData == null || this.mData.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.mData.iterator();
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

    private ArrayList<UserData> ah(ArrayList<UserData> arrayList) {
        if (!v.I(arrayList) && !this.fKc.isEmpty()) {
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.fKc.contains(Long.valueOf(com.baidu.adp.lib.g.b.d(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fJy) {
            return 1;
        }
        int i = 0;
        if (this.mData != null) {
            i = this.mData.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mData == null || i >= this.mData.size()) {
            return null;
        }
        return this.mData.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.mData == null || i >= this.mData.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (this.mData != null) {
            if (view == null || !(view.getTag() instanceof a)) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.fJz.getPageContext().getPageActivity()).inflate(e.h.person_list_item, (ViewGroup) null);
                    aVar2.bWH = (ViewGroup) inflate.findViewById(e.g.item_view);
                    aVar2.bWH.setOnClickListener(this.cJz);
                    aVar2.bWK = (ClickableHeaderImageView) inflate.findViewById(e.g.photo);
                    aVar2.bWK.setRadius(l.h(this.fJz.getPageContext().getPageActivity(), e.C0210e.ds90));
                    aVar2.bWK.setAutoChangeStyle(true);
                    aVar2.bWK.setClickable(false);
                    aVar2.bWM = (LinearLayout) inflate.findViewById(e.g.info);
                    aVar2.aIS = (LinearLayout) inflate.findViewById(e.g.tail_container);
                    aVar2.mName = (TextView) inflate.findViewById(e.g.name);
                    aVar2.fJC = com.baidu.tbadk.ala.b.wg().j(this.fJz.getPageContext().getPageActivity(), 5);
                    if (aVar2.fJC != null) {
                        aVar2.fJC.setVisibility(8);
                        aVar2.aIS.addView(aVar2.fJC, 1);
                    }
                    aVar2.fJF = (TextView) inflate.findViewById(e.g.at_list_nodata);
                    aVar2.bWL = (TextView) inflate.findViewById(e.g.intro);
                    aVar2.fKf = (TextView) inflate.findViewById(e.g.chat);
                    aVar2.fKf.setOnClickListener(this.fKd);
                    aVar2.fJD = (MyFansUserLikeButton) inflate.findViewById(e.g.attention_btn);
                    aVar2.fJD.setContext(this.fJz.getPageContext());
                    aVar2.cXO = new com.baidu.tbadk.core.view.userLike.c(this.fJz.getPageContext(), aVar2.fJD);
                    aVar2.mProgress = null;
                    aVar2.mTitle = null;
                    aVar2.fKg = null;
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    View inflate2 = LayoutInflater.from(this.fJz.getPageContext().getPageActivity()).inflate(e.h.person_list_newheader, (ViewGroup) null);
                    aVar2.mTitle = (TextView) inflate2.findViewById(e.g.person_list_title);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.mTitle.getLayoutParams();
                    layoutParams.height = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds16);
                    aVar2.mTitle.setLayoutParams(layoutParams);
                    aVar2.fKg = (LinearLayout) inflate2.findViewById(e.g.newheader_root);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.fJz.getPageContext().getPageActivity()).inflate(e.h.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate3.findViewById(e.g.pb_more_text);
                    inflate3.setOnClickListener(this.fJA);
                    aVar2.mProgress = (ProgressBar) inflate3.findViewById(e.g.progress);
                    aVar2.mTitle = null;
                    aVar2.fKg = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.fJD != null) {
                aVar.fJD.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.fJy) {
                    aVar.bWM.setVisibility(8);
                    aVar.fKf.setVisibility(8);
                    aVar.fJF.setVisibility(0);
                    if (this.cmE) {
                        if (this.eqF) {
                            aVar.fJF.setText(e.j.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.fJF.setText(e.j.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.fJF.setText(e.j.him_no_attention_other);
                        } else {
                            aVar.fJF.setText(e.j.no_attention_other);
                        }
                    } else if (this.eqF) {
                        aVar.fJF.setText(e.j.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.fJF.setText(e.j.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.fJF.setText(e.j.him_no_fan_other);
                    } else {
                        aVar.fJF.setText(e.j.no_fan_other);
                    }
                } else {
                    UserData userData = (UserData) v.d(this.mData, i);
                    if (userData == null) {
                        return null;
                    }
                    aVar.bWH.setTag(Integer.valueOf(i));
                    aVar.fKf.setVisibility(0);
                    aVar.fJF.setVisibility(8);
                    aVar.bWK.setShowV(userData.isBigV());
                    aVar.bWK.startLoad(userData.getPortrait(), 12, false);
                    aVar.mName.setText(userData.getName_show());
                    if (aVar.fJC != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            aVar.fJC.setVisibility(8);
                        } else {
                            aVar.fJC.setVisibility(0);
                            com.baidu.tbadk.ala.a aVar3 = new com.baidu.tbadk.ala.a();
                            aVar3.amc = userData.getAlaUserData();
                            aVar3.type = 5;
                            aVar.fJC.setTag(aVar3);
                        }
                    }
                    if (ao.isEmpty(userData.getIntro())) {
                        aVar.bWL.setVisibility(8);
                    } else {
                        aVar.bWL.setVisibility(0);
                        aVar.bWL.setText(userData.getIntro());
                    }
                    aVar.fKf.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    aVar.fJD.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    aVar.cXO.a(userData);
                    aVar.cXO.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.d.1
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void bM(boolean z) {
                            if (z) {
                                l.showToast(d.this.fJz, e.j.attention_success);
                            } else {
                                l.showToast(d.this.fJz, e.j.unfollow_success);
                            }
                        }
                    });
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        aVar.fJD.setVisibility(8);
                        aVar.fKf.setVisibility(8);
                    } else {
                        aVar.fKf.setVisibility(8);
                        aVar.fJD.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else if (getItemViewType(i) != 2) {
                aVar.mName.setText(this.fJz.getPageContext().getString(e.j.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
            return view;
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.fJz.getLayoutMode().setNightMode(skinType == 1);
        this.fJz.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.fKf != null) {
                al.c(aVar.fKf, e.d.btn_forum_focus_color, 1);
                al.i(aVar.fKf, e.f.btn_focus_border_bg);
                aVar.fKf.setEnabled(true);
            }
            if (aVar.fKg != null && aVar.mTitle != null) {
                al.j(aVar.fKg, e.d.cp_bg_line_e);
                al.h(aVar.mTitle, e.d.cp_cont_e);
            }
            if (aVar.fJD != null) {
                aVar.fJD.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fJy) {
            return 0;
        }
        if (this.mData == null || i >= this.mData.size()) {
            return 1;
        }
        return this.mData.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fJy) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        LinearLayout aIS;
        ViewGroup bWH;
        ClickableHeaderImageView bWK;
        TextView bWL;
        LinearLayout bWM;
        com.baidu.tbadk.core.view.userLike.c cXO;
        View fJC;
        MyFansUserLikeButton fJD;
        TextView fJF;
        TextView fKf;
        LinearLayout fKg;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
