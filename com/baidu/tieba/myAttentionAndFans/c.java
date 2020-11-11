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
    boolean gQx;
    private View.OnClickListener gRx;
    private PersonListActivity kYS;
    private View.OnClickListener kYT;
    private int mSex;

    public c(PersonListActivity personListActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.kYS = null;
        this.gQx = true;
        this.mSex = 0;
        this.kYT = null;
        this.gRx = null;
        this.kYS = personListActivity;
        this.gQx = z;
        this.mSex = i;
        this.kYT = onClickListener2;
        this.gRx = onClickListener;
        this.eIM = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(bc bcVar) {
        if (bcVar != null && bcVar.blt() != null) {
            Iterator<UserData> it = bcVar.blt().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null) {
                    next.setIsLike(next.getHave_attention() > 0);
                }
            }
            ArrayList arrayList = new ArrayList();
            if (this.eIM == null) {
                this.eIM = new ArrayList<>();
            }
            arrayList.addAll(bcVar.blt());
            if (!y.isEmpty(this.eIM) && this.eIM.get(this.eIM.size() - 1) != null && this.eIM.get(this.eIM.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                this.eIM.get(this.eIM.size() - 1).isLastNewFan = true;
            } else {
                for (int i = 0; i < arrayList.size() - 1; i++) {
                    UserData userData = (UserData) arrayList.get(i);
                    UserData userData2 = (UserData) arrayList.get(i + 1);
                    if (userData != null && userData2 != null && userData.isNewFan && !userData2.isNewFan) {
                        userData.isLastNewFan = true;
                    }
                }
            }
            if (y.isEmpty(this.eIM) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                UserData userData3 = new UserData();
                userData3.mAttentionType = 0;
                arrayList.add(0, userData3);
            }
            this.eIM.addAll(arrayList);
        }
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean gE(long j) {
        if (j == 0 || this.eIM == null || this.eIM.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.eIM.iterator();
        while (it.hasNext()) {
            UserData next = it.next();
            if (next != null && next.getUserIdLong() == j) {
                this.eIM.remove(next);
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gQv) {
            return 1;
        }
        int i = 0;
        if (this.eIM != null) {
            i = this.eIM.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eIM == null || i >= this.eIM.size()) {
            return null;
        }
        return this.eIM.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.eIM == null || i >= this.eIM.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final a aVar;
        View view2;
        if (this.eIM != null) {
            int itemViewType = getItemViewType(i);
            if (view == null || !(view.getTag() instanceof a)) {
                aVar = new a();
                if (itemViewType == 0) {
                    View inflate = LayoutInflater.from(this.kYS.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar.gxd = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar.gxd.setOnClickListener(this.gRx);
                    aVar.kYW = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar.kYW.setRadius(l.getDimens(this.kYS.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar.kYW.setAutoChangeStyle(true);
                    aVar.kYW.setClickable(false);
                    ((LinearLayout.LayoutParams) aVar.kYW.getLayoutParams()).setMargins(l.getDimens(this.kYS, R.dimen.ds34), 0, 0, 0);
                    aVar.gRA = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar.mName.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.myAttentionAndFans.c.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            Layout layout = aVar.mName.getLayout();
                            if (layout != null) {
                                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                                    aVar.mName.setCompoundDrawablePadding(l.getDimens(c.this.kYS, R.dimen.tbds10));
                                } else {
                                    aVar.mName.setCompoundDrawablePadding(0);
                                }
                            }
                        }
                    });
                    aVar.kYX = com.baidu.tbadk.ala.b.bim().q(this.kYS.getPageContext().getPageActivity(), 5);
                    if (aVar.kYX != null) {
                        aVar.kYX.setVisibility(8);
                        aVar.mContainer.addView(aVar.kYX, 1);
                    }
                    aVar.gQz = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar.gxh = (TextView) inflate.findViewById(R.id.intro);
                    aVar.kYY = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar.kYY.setContext(this.kYS.getPageContext());
                    ((LinearLayout.LayoutParams) aVar.kYY.getLayoutParams()).setMargins(0, 0, l.getDimens(this.kYS, R.dimen.ds34), 0);
                    aVar.ajW = new com.baidu.tbadk.core.view.userLike.c(this.kYS.getPageContext(), aVar.kYY);
                    aVar.ajW.a((com.baidu.tbadk.core.view.userLike.a) y.getItem(this.eIM, i));
                    aVar.ajW.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.c.2
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void jv(boolean z) {
                            if (z) {
                                l.showToast(c.this.kYS, R.string.attention_success);
                            } else {
                                l.showToast(c.this.kYS, R.string.unfollow_success);
                            }
                        }
                    });
                    aVar.mProgress = null;
                    aVar.mTitle = null;
                    aVar.kYZ = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    view2 = inflate;
                } else if (itemViewType == 2) {
                    View inflate2 = LayoutInflater.from(this.kYS.getPageContext().getPageActivity()).inflate(R.layout.my_fan_list_title, (ViewGroup) null);
                    aVar.mTitle = (TextView) inflate2.findViewById(R.id.my_new_fan_title);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.kYS.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.kYT);
                    aVar.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar.mTitle = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar);
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.kYY != null) {
                aVar.kYY.setTag(Integer.valueOf(i));
            }
            if (itemViewType == 0) {
                if (this.gQv) {
                    aVar.gRA.setVisibility(8);
                    aVar.gQz.setVisibility(0);
                    if (this.gQx) {
                        aVar.gQz.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.gQz.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.gQz.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.gQz.setText(R.string.no_fan_other);
                    }
                } else {
                    aVar.gxd.setTag(Integer.valueOf(i));
                    UserData userData = (UserData) y.getItem(this.eIM, i);
                    if (userData != null) {
                        aVar.gQz.setVisibility(8);
                        UtilHelper.showHeadImageViewBigV(aVar.kYW, userData, 0);
                        aVar.mName.setText(UtilHelper.getUserName(userData));
                        aVar.kYW.setPlaceHolder(1);
                        aVar.kYW.startLoad(userData.getAvater(), 12, false);
                        if (aVar.kYX != null && userData.getAlaUserData() != null) {
                            if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                                aVar.kYX.setVisibility(8);
                            } else {
                                aVar.kYX.setVisibility(0);
                                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                                aVar2.eue = userData.getAlaUserData();
                                aVar2.type = 5;
                                aVar.kYX.setTag(aVar2);
                            }
                        }
                        if (at.isEmpty(userData.getIntro())) {
                            aVar.gxh.setVisibility(8);
                        } else {
                            aVar.gxh.setVisibility(0);
                            aVar.gxh.setText(userData.getIntro());
                        }
                        String userId = userData.getUserId();
                        userData.setIsLike(userData.getHave_attention() > 0);
                        aVar.ajW.a(userData);
                        if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            aVar.kYY.setVisibility(8);
                        } else {
                            aVar.kYY.setStatsParams(2, userId);
                            aVar.ajW.Ba("9");
                            aVar.kYY.setVisibility(0);
                        }
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.kYZ.getLayoutParams();
                if (y.getItem(this.eIM, i) != null && ((UserData) y.getItem(this.eIM, i)).isLastNewFan) {
                    layoutParams.height = l.getDimens(this.kYS, R.dimen.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                    aVar.kYZ.setVisibility(0);
                } else {
                    aVar.kYZ.setVisibility(8);
                    layoutParams.height = l.getDimens(this.kYS, R.dimen.ds1);
                    layoutParams.setMargins(l.getDimens(this.kYS, R.dimen.ds34), 0, l.getDimens(this.kYS, R.dimen.ds34), 0);
                }
                aVar.kYZ.setLayoutParams(layoutParams);
                aVar.mProgress = null;
            } else if (itemViewType == 2) {
                aVar.mTitle.setText(R.string.new_fans);
                aVar.mTitle.setVisibility(0);
            } else {
                aVar.mName.setText(this.kYS.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.kYS.getLayoutMode().setNightMode(skinType == 1);
        this.kYS.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.mTitle != null) {
                ap.setViewTextColor(aVar.mTitle, R.color.cp_cont_d);
                ap.setBackgroundColor(aVar.mTitle, R.color.cp_bg_line_e);
            }
            if (aVar.kYZ != null) {
                ap.setImageResource(aVar.kYZ, R.color.cp_bg_line_c);
            }
            if (aVar.kYY != null) {
                aVar.kYY.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.gQv) {
            return 0;
        }
        if (this.eIM == null || i >= this.eIM.size()) {
            return 1;
        }
        return this.eIM.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.gQv) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c ajW;
        TextView gQz;
        LinearLayout gRA;
        ViewGroup gxd;
        TextView gxh;
        ClickableHeaderImageView kYW;
        View kYX;
        MyFansUserLikeButton kYY;
        ImageView kYZ;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
