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
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class c extends b {
    private View.OnClickListener dWZ;
    boolean fDf;
    private PersonListActivity gZL;
    private View.OnClickListener gZM;
    private int mSex;

    public c(PersonListActivity personListActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.gZL = null;
        this.fDf = true;
        this.mSex = 0;
        this.gZM = null;
        this.dWZ = null;
        this.gZL = personListActivity;
        this.fDf = z;
        this.mSex = i;
        this.gZM = onClickListener2;
        this.dWZ = onClickListener;
        this.aFI = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(as asVar) {
        if (asVar != null && asVar.XN() != null) {
            Iterator<UserData> it = asVar.XN().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null) {
                    next.setIsLike(next.getHave_attention() > 0);
                }
            }
            ArrayList arrayList = new ArrayList();
            if (this.aFI == null) {
                this.aFI = new ArrayList<>();
            }
            arrayList.addAll(asVar.XN());
            if (!v.T(this.aFI) && this.aFI.get(this.aFI.size() - 1) != null && this.aFI.get(this.aFI.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                this.aFI.get(this.aFI.size() - 1).isLastNewFan = true;
            } else {
                for (int i = 0; i < arrayList.size() - 1; i++) {
                    UserData userData = (UserData) arrayList.get(i);
                    UserData userData2 = (UserData) arrayList.get(i + 1);
                    if (userData != null && userData2 != null && userData.isNewFan && !userData2.isNewFan) {
                        userData.isLastNewFan = true;
                    }
                }
            }
            if (v.T(this.aFI) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                UserData userData3 = new UserData();
                userData3.mAttentionType = 0;
                arrayList.add(0, userData3);
            }
            this.aFI.addAll(arrayList);
        }
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
                this.aFI.remove(next);
                return true;
            }
        }
        return false;
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
        a aVar;
        View view2;
        if (this.aFI != null) {
            int itemViewType = getItemViewType(i);
            if (view == null || !(view.getTag() instanceof a)) {
                aVar = new a();
                if (itemViewType == 0) {
                    View inflate = LayoutInflater.from(this.gZL.getPageContext().getPageActivity()).inflate(d.h.person_list_item, (ViewGroup) null);
                    aVar.dlF = (ViewGroup) inflate.findViewById(d.g.item_view);
                    aVar.dlF.setOnClickListener(this.dWZ);
                    aVar.dlI = (ClickableHeaderImageView) inflate.findViewById(d.g.photo);
                    aVar.dlI.setRadius(l.h(this.gZL.getPageContext().getPageActivity(), d.e.ds90));
                    aVar.dlI.setAutoChangeStyle(true);
                    aVar.dlI.setClickable(false);
                    ((LinearLayout.LayoutParams) aVar.dlI.getLayoutParams()).setMargins(l.h(this.gZL, d.e.ds34), 0, 0, 0);
                    aVar.dlK = (LinearLayout) inflate.findViewById(d.g.info);
                    aVar.bRo = (LinearLayout) inflate.findViewById(d.g.tail_container);
                    aVar.mName = (TextView) inflate.findViewById(d.g.name);
                    aVar.gZO = com.baidu.tbadk.ala.b.UK().n(this.gZL.getPageContext().getPageActivity(), 5);
                    if (aVar.gZO != null) {
                        aVar.gZO.setVisibility(8);
                        aVar.bRo.addView(aVar.gZO, 1);
                    }
                    aVar.gZR = (TextView) inflate.findViewById(d.g.at_list_nodata);
                    aVar.dlJ = (TextView) inflate.findViewById(d.g.intro);
                    aVar.gZP = (MyFansUserLikeButton) inflate.findViewById(d.g.attention_btn);
                    aVar.gZP.setContext(this.gZL.getPageContext());
                    ((LinearLayout.LayoutParams) aVar.gZP.getLayoutParams()).setMargins(0, 0, l.h(this.gZL, d.e.ds34), 0);
                    aVar.ehx = new com.baidu.tbadk.core.view.userLike.c(this.gZL.getPageContext(), aVar.gZP);
                    aVar.ehx.a((com.baidu.tbadk.core.view.userLike.a) v.c(this.aFI, i));
                    aVar.ehx.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.c.1
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void dV(boolean z) {
                            if (z) {
                                l.showToast(c.this.gZL, d.j.attention_success);
                            } else {
                                l.showToast(c.this.gZL, d.j.unfollow_success);
                            }
                        }
                    });
                    aVar.mProgress = null;
                    aVar.mTitle = null;
                    aVar.gZQ = (ImageView) inflate.findViewById(d.g.diver_buttom_px);
                    view2 = inflate;
                } else if (itemViewType == 2) {
                    View inflate2 = LayoutInflater.from(this.gZL.getPageContext().getPageActivity()).inflate(d.h.my_fan_list_title, (ViewGroup) null);
                    aVar.mTitle = (TextView) inflate2.findViewById(d.g.my_new_fan_title);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.gZL.getPageContext().getPageActivity()).inflate(d.h.new_pb_list_more, (ViewGroup) null);
                    aVar.mName = (TextView) inflate3.findViewById(d.g.pb_more_text);
                    inflate3.setOnClickListener(this.gZM);
                    aVar.mProgress = (ProgressBar) inflate3.findViewById(d.g.progress);
                    aVar.mTitle = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar);
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.gZP != null) {
                aVar.gZP.setTag(Integer.valueOf(i));
            }
            if (itemViewType == 0) {
                if (this.gZK) {
                    aVar.dlK.setVisibility(8);
                    aVar.gZR.setVisibility(0);
                    if (this.fDf) {
                        aVar.gZR.setText(d.j.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.gZR.setText(d.j.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.gZR.setText(d.j.him_no_fan_other);
                    } else {
                        aVar.gZR.setText(d.j.no_fan_other);
                    }
                } else {
                    aVar.dlF.setTag(Integer.valueOf(i));
                    UserData userData = (UserData) v.c(this.aFI, i);
                    if (userData != null) {
                        aVar.gZR.setVisibility(8);
                        aVar.dlI.setIsGod(userData.isBigV());
                        aVar.dlI.startLoad(userData.getPortrait(), 12, false);
                        aVar.mName.setText(userData.getName_show());
                        if (aVar.gZO != null && userData.getAlaUserData() != null) {
                            if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                                aVar.gZO.setVisibility(8);
                            } else {
                                aVar.gZO.setVisibility(0);
                                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                                aVar2.bsJ = userData.getAlaUserData();
                                aVar2.type = 5;
                                aVar.gZO.setTag(aVar2);
                            }
                        }
                        if (ap.isEmpty(userData.getIntro())) {
                            aVar.dlJ.setVisibility(8);
                        } else {
                            aVar.dlJ.setVisibility(0);
                            aVar.dlJ.setText(userData.getIntro());
                        }
                        String userId = userData.getUserId();
                        userData.setIsLike(userData.getHave_attention() > 0);
                        aVar.ehx.a(userData);
                        if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            aVar.gZP.setVisibility(8);
                        } else {
                            aVar.gZP.setStatsParams(2, userId);
                            aVar.ehx.setFromType("9");
                            aVar.gZP.setVisibility(0);
                        }
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.gZQ.getLayoutParams();
                if (v.c(this.aFI, i) != null && ((UserData) v.c(this.aFI, i)).isLastNewFan) {
                    layoutParams.height = l.h(this.gZL, d.e.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                } else {
                    layoutParams.height = l.h(this.gZL, d.e.ds1);
                    layoutParams.setMargins(l.h(this.gZL, d.e.ds34), 0, l.h(this.gZL, d.e.ds34), 0);
                }
                aVar.gZQ.setLayoutParams(layoutParams);
                aVar.mProgress = null;
            } else if (itemViewType == 2) {
                aVar.mTitle.setText(d.j.new_fans);
                aVar.mTitle.setVisibility(0);
            } else {
                aVar.mName.setText(this.gZL.getPageContext().getString(d.j.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.gZL.getLayoutMode().setNightMode(skinType == 1);
        this.gZL.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.mTitle != null) {
                al.j(aVar.mTitle, d.C0277d.cp_cont_d);
                al.l(aVar.mTitle, d.C0277d.cp_bg_line_d);
            }
            if (aVar.gZQ != null) {
                al.c(aVar.gZQ, d.C0277d.cp_bg_line_c);
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
        ImageView gZQ;
        TextView gZR;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
