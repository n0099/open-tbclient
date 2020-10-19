package com.baidu.tieba.myAttentionAndFans;

import android.annotation.SuppressLint;
import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes23.dex */
public class c extends b {
    boolean gyX;
    private View.OnClickListener gzX;
    private View.OnClickListener kGA;
    private PersonListActivity kGz;
    private int mSex;

    public c(PersonListActivity personListActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.kGz = null;
        this.gyX = true;
        this.mSex = 0;
        this.kGA = null;
        this.gzX = null;
        this.kGz = personListActivity;
        this.gyX = z;
        this.mSex = i;
        this.kGA = onClickListener2;
        this.gzX = onClickListener;
        this.euy = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(bc bcVar) {
        if (bcVar != null && bcVar.bha() != null) {
            Iterator<UserData> it = bcVar.bha().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null) {
                    next.setIsLike(next.getHave_attention() > 0);
                }
            }
            ArrayList arrayList = new ArrayList();
            if (this.euy == null) {
                this.euy = new ArrayList<>();
            }
            arrayList.addAll(bcVar.bha());
            if (!y.isEmpty(this.euy) && this.euy.get(this.euy.size() - 1) != null && this.euy.get(this.euy.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                this.euy.get(this.euy.size() - 1).isLastNewFan = true;
            } else {
                for (int i = 0; i < arrayList.size() - 1; i++) {
                    UserData userData = (UserData) arrayList.get(i);
                    UserData userData2 = (UserData) arrayList.get(i + 1);
                    if (userData != null && userData2 != null && userData.isNewFan && !userData2.isNewFan) {
                        userData.isLastNewFan = true;
                    }
                }
            }
            if (y.isEmpty(this.euy) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                UserData userData3 = new UserData();
                userData3.mAttentionType = 0;
                arrayList.add(0, userData3);
            }
            this.euy.addAll(arrayList);
        }
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean gh(long j) {
        if (j == 0 || this.euy == null || this.euy.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.euy.iterator();
        while (it.hasNext()) {
            UserData next = it.next();
            if (next != null && next.getUserIdLong() == j) {
                this.euy.remove(next);
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gyV) {
            return 1;
        }
        int i = 0;
        if (this.euy != null) {
            i = this.euy.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.euy == null || i >= this.euy.size()) {
            return null;
        }
        return this.euy.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.euy == null || i >= this.euy.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final a aVar;
        View view2;
        if (this.euy != null) {
            int itemViewType = getItemViewType(i);
            if (view == null || !(view.getTag() instanceof a)) {
                aVar = new a();
                if (itemViewType == 0) {
                    View inflate = LayoutInflater.from(this.kGz.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar.ghm = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar.ghm.setOnClickListener(this.gzX);
                    aVar.kGD = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar.kGD.setRadius(l.getDimens(this.kGz.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar.kGD.setAutoChangeStyle(true);
                    aVar.kGD.setClickable(false);
                    ((LinearLayout.LayoutParams) aVar.kGD.getLayoutParams()).setMargins(l.getDimens(this.kGz, R.dimen.ds34), 0, 0, 0);
                    aVar.gAa = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar.mName.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.myAttentionAndFans.c.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            Layout layout = aVar.mName.getLayout();
                            if (layout != null) {
                                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                                    aVar.mName.setCompoundDrawablePadding(l.getDimens(c.this.kGz, R.dimen.tbds10));
                                } else {
                                    aVar.mName.setCompoundDrawablePadding(0);
                                }
                            }
                        }
                    });
                    aVar.kGE = com.baidu.tbadk.ala.b.bdT().q(this.kGz.getPageContext().getPageActivity(), 5);
                    if (aVar.kGE != null) {
                        aVar.kGE.setVisibility(8);
                        aVar.mContainer.addView(aVar.kGE, 1);
                    }
                    aVar.gyZ = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar.ghq = (TextView) inflate.findViewById(R.id.intro);
                    aVar.kGF = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar.kGF.setContext(this.kGz.getPageContext());
                    ((LinearLayout.LayoutParams) aVar.kGF.getLayoutParams()).setMargins(0, 0, l.getDimens(this.kGz, R.dimen.ds34), 0);
                    aVar.ajV = new com.baidu.tbadk.core.view.userLike.c(this.kGz.getPageContext(), aVar.kGF);
                    aVar.ajV.a((com.baidu.tbadk.core.view.userLike.a) y.getItem(this.euy, i));
                    aVar.ajV.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.c.2
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void iZ(boolean z) {
                            if (z) {
                                l.showToast(c.this.kGz, R.string.attention_success);
                            } else {
                                l.showToast(c.this.kGz, R.string.unfollow_success);
                            }
                        }
                    });
                    aVar.mProgress = null;
                    aVar.mTitle = null;
                    aVar.kGG = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    view2 = inflate;
                } else if (itemViewType == 2) {
                    View inflate2 = LayoutInflater.from(this.kGz.getPageContext().getPageActivity()).inflate(R.layout.my_fan_list_title, (ViewGroup) null);
                    aVar.mTitle = (TextView) inflate2.findViewById(R.id.my_new_fan_title);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.kGz.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.kGA);
                    aVar.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar.mTitle = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar);
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.kGF != null) {
                aVar.kGF.setTag(Integer.valueOf(i));
            }
            if (itemViewType == 0) {
                if (this.gyV) {
                    aVar.gAa.setVisibility(8);
                    aVar.gyZ.setVisibility(0);
                    if (this.gyX) {
                        aVar.gyZ.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.gyZ.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.gyZ.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.gyZ.setText(R.string.no_fan_other);
                    }
                } else {
                    aVar.ghm.setTag(Integer.valueOf(i));
                    UserData userData = (UserData) y.getItem(this.euy, i);
                    if (userData != null) {
                        aVar.gyZ.setVisibility(8);
                        UtilHelper.showHeadImageViewBigV(aVar.kGD, userData, 0);
                        aVar.mName.setText(UtilHelper.getUserName(userData));
                        aVar.kGD.setPlaceHolder(1);
                        aVar.kGD.startLoad(userData.getAvater(), 12, false);
                        if (aVar.kGE != null && userData.getAlaUserData() != null) {
                            if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                                aVar.kGE.setVisibility(8);
                            } else {
                                aVar.kGE.setVisibility(0);
                                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                                aVar2.efM = userData.getAlaUserData();
                                aVar2.type = 5;
                                aVar.kGE.setTag(aVar2);
                            }
                        }
                        if (at.isEmpty(userData.getIntro())) {
                            aVar.ghq.setVisibility(8);
                        } else {
                            aVar.ghq.setVisibility(0);
                            aVar.ghq.setText(userData.getIntro());
                        }
                        String userId = userData.getUserId();
                        userData.setIsLike(userData.getHave_attention() > 0);
                        aVar.ajV.a(userData);
                        if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            aVar.kGF.setVisibility(8);
                        } else {
                            aVar.kGF.setStatsParams(2, userId);
                            aVar.ajV.At("9");
                            aVar.kGF.setVisibility(0);
                        }
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.kGG.getLayoutParams();
                if (y.getItem(this.euy, i) != null && ((UserData) y.getItem(this.euy, i)).isLastNewFan) {
                    layoutParams.height = l.getDimens(this.kGz, R.dimen.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                    aVar.kGG.setVisibility(0);
                } else {
                    aVar.kGG.setVisibility(8);
                    layoutParams.height = l.getDimens(this.kGz, R.dimen.ds1);
                    layoutParams.setMargins(l.getDimens(this.kGz, R.dimen.ds34), 0, l.getDimens(this.kGz, R.dimen.ds34), 0);
                }
                aVar.kGG.setLayoutParams(layoutParams);
                aVar.mProgress = null;
            } else if (itemViewType == 2) {
                aVar.mTitle.setText(R.string.new_fans);
                aVar.mTitle.setVisibility(0);
            } else {
                aVar.mName.setText(this.kGz.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.kGz.getLayoutMode().setNightMode(skinType == 1);
        this.kGz.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.mTitle != null) {
                ap.setViewTextColor(aVar.mTitle, R.color.cp_cont_d);
                ap.setBackgroundColor(aVar.mTitle, R.color.cp_bg_line_e);
            }
            if (aVar.kGG != null) {
                ap.setImageResource(aVar.kGG, R.color.cp_bg_line_c);
            }
            if (aVar.kGF != null) {
                aVar.kGF.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.gyV) {
            return 0;
        }
        if (this.euy == null || i >= this.euy.size()) {
            return 1;
        }
        return this.euy.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.gyV) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c ajV;
        LinearLayout gAa;
        ViewGroup ghm;
        TextView ghq;
        TextView gyZ;
        ClickableHeaderImageView kGD;
        View kGE;
        MyFansUserLikeButton kGF;
        ImageView kGG;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
