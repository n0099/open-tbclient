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
    boolean gKL;
    private View.OnClickListener gLL;
    private PersonListActivity kSW;
    private View.OnClickListener kSX;
    private int mSex;

    public c(PersonListActivity personListActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.kSW = null;
        this.gKL = true;
        this.mSex = 0;
        this.kSX = null;
        this.gLL = null;
        this.kSW = personListActivity;
        this.gKL = z;
        this.mSex = i;
        this.kSX = onClickListener2;
        this.gLL = onClickListener;
        this.eCX = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(bc bcVar) {
        if (bcVar != null && bcVar.biT() != null) {
            Iterator<UserData> it = bcVar.biT().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null) {
                    next.setIsLike(next.getHave_attention() > 0);
                }
            }
            ArrayList arrayList = new ArrayList();
            if (this.eCX == null) {
                this.eCX = new ArrayList<>();
            }
            arrayList.addAll(bcVar.biT());
            if (!y.isEmpty(this.eCX) && this.eCX.get(this.eCX.size() - 1) != null && this.eCX.get(this.eCX.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                this.eCX.get(this.eCX.size() - 1).isLastNewFan = true;
            } else {
                for (int i = 0; i < arrayList.size() - 1; i++) {
                    UserData userData = (UserData) arrayList.get(i);
                    UserData userData2 = (UserData) arrayList.get(i + 1);
                    if (userData != null && userData2 != null && userData.isNewFan && !userData2.isNewFan) {
                        userData.isLastNewFan = true;
                    }
                }
            }
            if (y.isEmpty(this.eCX) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                UserData userData3 = new UserData();
                userData3.mAttentionType = 0;
                arrayList.add(0, userData3);
            }
            this.eCX.addAll(arrayList);
        }
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean gi(long j) {
        if (j == 0 || this.eCX == null || this.eCX.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.eCX.iterator();
        while (it.hasNext()) {
            UserData next = it.next();
            if (next != null && next.getUserIdLong() == j) {
                this.eCX.remove(next);
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gKJ) {
            return 1;
        }
        int i = 0;
        if (this.eCX != null) {
            i = this.eCX.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eCX == null || i >= this.eCX.size()) {
            return null;
        }
        return this.eCX.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.eCX == null || i >= this.eCX.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final a aVar;
        View view2;
        if (this.eCX != null) {
            int itemViewType = getItemViewType(i);
            if (view == null || !(view.getTag() instanceof a)) {
                aVar = new a();
                if (itemViewType == 0) {
                    View inflate = LayoutInflater.from(this.kSW.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar.grp = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar.grp.setOnClickListener(this.gLL);
                    aVar.kTa = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar.kTa.setRadius(l.getDimens(this.kSW.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar.kTa.setAutoChangeStyle(true);
                    aVar.kTa.setClickable(false);
                    ((LinearLayout.LayoutParams) aVar.kTa.getLayoutParams()).setMargins(l.getDimens(this.kSW, R.dimen.ds34), 0, 0, 0);
                    aVar.gLO = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar.mName.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.myAttentionAndFans.c.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            Layout layout = aVar.mName.getLayout();
                            if (layout != null) {
                                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                                    aVar.mName.setCompoundDrawablePadding(l.getDimens(c.this.kSW, R.dimen.tbds10));
                                } else {
                                    aVar.mName.setCompoundDrawablePadding(0);
                                }
                            }
                        }
                    });
                    aVar.kTb = com.baidu.tbadk.ala.b.bfM().q(this.kSW.getPageContext().getPageActivity(), 5);
                    if (aVar.kTb != null) {
                        aVar.kTb.setVisibility(8);
                        aVar.mContainer.addView(aVar.kTb, 1);
                    }
                    aVar.gKN = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar.grt = (TextView) inflate.findViewById(R.id.intro);
                    aVar.kTc = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar.kTc.setContext(this.kSW.getPageContext());
                    ((LinearLayout.LayoutParams) aVar.kTc.getLayoutParams()).setMargins(0, 0, l.getDimens(this.kSW, R.dimen.ds34), 0);
                    aVar.ajW = new com.baidu.tbadk.core.view.userLike.c(this.kSW.getPageContext(), aVar.kTc);
                    aVar.ajW.a((com.baidu.tbadk.core.view.userLike.a) y.getItem(this.eCX, i));
                    aVar.ajW.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.c.2
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void jm(boolean z) {
                            if (z) {
                                l.showToast(c.this.kSW, R.string.attention_success);
                            } else {
                                l.showToast(c.this.kSW, R.string.unfollow_success);
                            }
                        }
                    });
                    aVar.mProgress = null;
                    aVar.mTitle = null;
                    aVar.kTd = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    view2 = inflate;
                } else if (itemViewType == 2) {
                    View inflate2 = LayoutInflater.from(this.kSW.getPageContext().getPageActivity()).inflate(R.layout.my_fan_list_title, (ViewGroup) null);
                    aVar.mTitle = (TextView) inflate2.findViewById(R.id.my_new_fan_title);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.kSW.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.kSX);
                    aVar.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar.mTitle = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar);
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.kTc != null) {
                aVar.kTc.setTag(Integer.valueOf(i));
            }
            if (itemViewType == 0) {
                if (this.gKJ) {
                    aVar.gLO.setVisibility(8);
                    aVar.gKN.setVisibility(0);
                    if (this.gKL) {
                        aVar.gKN.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.gKN.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.gKN.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.gKN.setText(R.string.no_fan_other);
                    }
                } else {
                    aVar.grp.setTag(Integer.valueOf(i));
                    UserData userData = (UserData) y.getItem(this.eCX, i);
                    if (userData != null) {
                        aVar.gKN.setVisibility(8);
                        UtilHelper.showHeadImageViewBigV(aVar.kTa, userData, 0);
                        aVar.mName.setText(UtilHelper.getUserName(userData));
                        aVar.kTa.setPlaceHolder(1);
                        aVar.kTa.startLoad(userData.getAvater(), 12, false);
                        if (aVar.kTb != null && userData.getAlaUserData() != null) {
                            if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                                aVar.kTb.setVisibility(8);
                            } else {
                                aVar.kTb.setVisibility(0);
                                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                                aVar2.eol = userData.getAlaUserData();
                                aVar2.type = 5;
                                aVar.kTb.setTag(aVar2);
                            }
                        }
                        if (at.isEmpty(userData.getIntro())) {
                            aVar.grt.setVisibility(8);
                        } else {
                            aVar.grt.setVisibility(0);
                            aVar.grt.setText(userData.getIntro());
                        }
                        String userId = userData.getUserId();
                        userData.setIsLike(userData.getHave_attention() > 0);
                        aVar.ajW.a(userData);
                        if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            aVar.kTc.setVisibility(8);
                        } else {
                            aVar.kTc.setStatsParams(2, userId);
                            aVar.ajW.AM("9");
                            aVar.kTc.setVisibility(0);
                        }
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.kTd.getLayoutParams();
                if (y.getItem(this.eCX, i) != null && ((UserData) y.getItem(this.eCX, i)).isLastNewFan) {
                    layoutParams.height = l.getDimens(this.kSW, R.dimen.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                    aVar.kTd.setVisibility(0);
                } else {
                    aVar.kTd.setVisibility(8);
                    layoutParams.height = l.getDimens(this.kSW, R.dimen.ds1);
                    layoutParams.setMargins(l.getDimens(this.kSW, R.dimen.ds34), 0, l.getDimens(this.kSW, R.dimen.ds34), 0);
                }
                aVar.kTd.setLayoutParams(layoutParams);
                aVar.mProgress = null;
            } else if (itemViewType == 2) {
                aVar.mTitle.setText(R.string.new_fans);
                aVar.mTitle.setVisibility(0);
            } else {
                aVar.mName.setText(this.kSW.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.kSW.getLayoutMode().setNightMode(skinType == 1);
        this.kSW.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.mTitle != null) {
                ap.setViewTextColor(aVar.mTitle, R.color.cp_cont_d);
                ap.setBackgroundColor(aVar.mTitle, R.color.cp_bg_line_e);
            }
            if (aVar.kTd != null) {
                ap.setImageResource(aVar.kTd, R.color.cp_bg_line_c);
            }
            if (aVar.kTc != null) {
                aVar.kTc.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.gKJ) {
            return 0;
        }
        if (this.eCX == null || i >= this.eCX.size()) {
            return 1;
        }
        return this.eCX.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.gKJ) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c ajW;
        TextView gKN;
        LinearLayout gLO;
        ViewGroup grp;
        TextView grt;
        ClickableHeaderImageView kTa;
        View kTb;
        MyFansUserLikeButton kTc;
        ImageView kTd;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
