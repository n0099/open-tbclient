package com.baidu.tieba.myAttentionAndFans;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
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
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class c extends b {
    private View.OnClickListener cJz;
    boolean eqF;
    private View.OnClickListener fJA;
    private PersonListActivity fJz;
    private int mSex;

    public c(PersonListActivity personListActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.fJz = null;
        this.eqF = true;
        this.mSex = 0;
        this.fJA = null;
        this.cJz = null;
        this.fJz = personListActivity;
        this.eqF = z;
        this.mSex = i;
        this.fJA = onClickListener2;
        this.cJz = onClickListener;
        this.mData = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(aq aqVar) {
        if (aqVar != null && aqVar.zg() != null) {
            Iterator<UserData> it = aqVar.zg().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null) {
                    next.setIsLike(next.getHave_attention() > 0);
                }
            }
            ArrayList arrayList = new ArrayList();
            if (this.mData == null) {
                this.mData = new ArrayList<>();
            }
            arrayList.addAll(aqVar.zg());
            if (!v.I(this.mData) && this.mData.get(this.mData.size() - 1) != null && this.mData.get(this.mData.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                this.mData.get(this.mData.size() - 1).isLastNewFan = true;
            } else {
                for (int i = 0; i < arrayList.size() - 1; i++) {
                    UserData userData = (UserData) arrayList.get(i);
                    UserData userData2 = (UserData) arrayList.get(i + 1);
                    if (userData != null && userData2 != null && userData.isNewFan && !userData2.isNewFan) {
                        userData.isLastNewFan = true;
                    }
                }
            }
            if (v.I(this.mData) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                UserData userData3 = new UserData();
                userData3.mAttentionType = 0;
                arrayList.add(0, userData3);
            }
            this.mData.addAll(arrayList);
        }
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
                this.mData.remove(next);
                return true;
            }
        }
        return false;
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
        a aVar;
        View view2;
        if (this.mData != null) {
            int itemViewType = getItemViewType(i);
            if (view == null || !(view.getTag() instanceof a)) {
                aVar = new a();
                if (itemViewType == 0) {
                    View inflate = LayoutInflater.from(this.fJz.getPageContext().getPageActivity()).inflate(e.h.person_list_item, (ViewGroup) null);
                    aVar.bWH = (ViewGroup) inflate.findViewById(e.g.item_view);
                    aVar.bWH.setOnClickListener(this.cJz);
                    aVar.bWK = (ClickableHeaderImageView) inflate.findViewById(e.g.photo);
                    aVar.bWK.setRadius(l.h(this.fJz.getPageContext().getPageActivity(), e.C0210e.ds90));
                    aVar.bWK.setAutoChangeStyle(true);
                    aVar.bWK.setClickable(false);
                    ((LinearLayout.LayoutParams) aVar.bWK.getLayoutParams()).setMargins(l.h(this.fJz, e.C0210e.ds34), 0, 0, 0);
                    aVar.bWM = (LinearLayout) inflate.findViewById(e.g.info);
                    aVar.aIS = (LinearLayout) inflate.findViewById(e.g.tail_container);
                    aVar.mName = (TextView) inflate.findViewById(e.g.name);
                    aVar.fJC = com.baidu.tbadk.ala.b.wg().j(this.fJz.getPageContext().getPageActivity(), 5);
                    if (aVar.fJC != null) {
                        aVar.fJC.setVisibility(8);
                        aVar.aIS.addView(aVar.fJC, 1);
                    }
                    aVar.fJF = (TextView) inflate.findViewById(e.g.at_list_nodata);
                    aVar.bWL = (TextView) inflate.findViewById(e.g.intro);
                    aVar.fJD = (MyFansUserLikeButton) inflate.findViewById(e.g.attention_btn);
                    aVar.fJD.setContext(this.fJz.getPageContext());
                    ((LinearLayout.LayoutParams) aVar.fJD.getLayoutParams()).setMargins(0, 0, l.h(this.fJz, e.C0210e.ds34), 0);
                    aVar.cXO = new com.baidu.tbadk.core.view.userLike.c(this.fJz.getPageContext(), aVar.fJD);
                    aVar.cXO.a((com.baidu.tbadk.core.view.userLike.a) v.d(this.mData, i));
                    aVar.cXO.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.c.1
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void bM(boolean z) {
                            if (z) {
                                l.showToast(c.this.fJz, e.j.attention_success);
                            } else {
                                l.showToast(c.this.fJz, e.j.unfollow_success);
                            }
                        }
                    });
                    aVar.mProgress = null;
                    aVar.mTitle = null;
                    aVar.fJE = (ImageView) inflate.findViewById(e.g.diver_buttom_px);
                    view2 = inflate;
                } else if (itemViewType == 2) {
                    View inflate2 = LayoutInflater.from(this.fJz.getPageContext().getPageActivity()).inflate(e.h.my_fan_list_title, (ViewGroup) null);
                    aVar.mTitle = (TextView) inflate2.findViewById(e.g.my_new_fan_title);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.fJz.getPageContext().getPageActivity()).inflate(e.h.new_pb_list_more, (ViewGroup) null);
                    aVar.mName = (TextView) inflate3.findViewById(e.g.pb_more_text);
                    inflate3.setOnClickListener(this.fJA);
                    aVar.mProgress = (ProgressBar) inflate3.findViewById(e.g.progress);
                    aVar.mTitle = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar);
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.fJD != null) {
                aVar.fJD.setTag(Integer.valueOf(i));
            }
            if (itemViewType == 0) {
                if (this.fJy) {
                    aVar.bWM.setVisibility(8);
                    aVar.fJF.setVisibility(0);
                    if (this.eqF) {
                        aVar.fJF.setText(e.j.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.fJF.setText(e.j.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.fJF.setText(e.j.him_no_fan_other);
                    } else {
                        aVar.fJF.setText(e.j.no_fan_other);
                    }
                } else {
                    aVar.bWH.setTag(Integer.valueOf(i));
                    UserData userData = (UserData) v.d(this.mData, i);
                    if (userData != null) {
                        aVar.fJF.setVisibility(8);
                        aVar.bWK.setIsGod(userData.isBigV());
                        aVar.bWK.startLoad(userData.getPortrait(), 12, false);
                        aVar.mName.setText(userData.getName_show());
                        if (aVar.fJC != null && userData.getAlaUserData() != null) {
                            if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                                aVar.fJC.setVisibility(8);
                            } else {
                                aVar.fJC.setVisibility(0);
                                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                                aVar2.amc = userData.getAlaUserData();
                                aVar2.type = 5;
                                aVar.fJC.setTag(aVar2);
                            }
                        }
                        if (ao.isEmpty(userData.getIntro())) {
                            aVar.bWL.setVisibility(8);
                        } else {
                            aVar.bWL.setVisibility(0);
                            aVar.bWL.setText(userData.getIntro());
                        }
                        String userId = userData.getUserId();
                        userData.setIsLike(userData.getHave_attention() > 0);
                        aVar.cXO.a(userData);
                        if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            aVar.fJD.setVisibility(8);
                        } else {
                            aVar.fJD.setStatsParams(2, userId);
                            aVar.cXO.setFromType("9");
                            aVar.fJD.setVisibility(0);
                        }
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.fJE.getLayoutParams();
                if (v.d(this.mData, i) != null && ((UserData) v.d(this.mData, i)).isLastNewFan) {
                    layoutParams.height = l.h(this.fJz, e.C0210e.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                } else {
                    layoutParams.height = l.h(this.fJz, e.C0210e.ds1);
                    layoutParams.setMargins(l.h(this.fJz, e.C0210e.ds34), 0, l.h(this.fJz, e.C0210e.ds34), 0);
                }
                aVar.fJE.setLayoutParams(layoutParams);
                aVar.mProgress = null;
            } else if (itemViewType == 2) {
                aVar.mTitle.setText(e.j.new_fans);
                aVar.mTitle.setVisibility(0);
            } else {
                aVar.mName.setText(this.fJz.getPageContext().getString(e.j.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.fJz.getLayoutMode().setNightMode(skinType == 1);
        this.fJz.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.mTitle != null) {
                al.h(aVar.mTitle, e.d.cp_cont_d);
                al.j(aVar.mTitle, e.d.cp_bg_line_d);
            }
            if (aVar.fJE != null) {
                al.c(aVar.fJE, e.d.cp_bg_line_c);
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
        ImageView fJE;
        TextView fJF;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
