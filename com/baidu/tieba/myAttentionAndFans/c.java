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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes22.dex */
public class c extends b {
    boolean gQe;
    private View.OnClickListener gRe;
    private PersonListActivity kZk;
    private View.OnClickListener kZl;
    private int mSex;

    public c(PersonListActivity personListActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.kZk = null;
        this.gQe = true;
        this.mSex = 0;
        this.kZl = null;
        this.gRe = null;
        this.kZk = personListActivity;
        this.gQe = z;
        this.mSex = i;
        this.kZl = onClickListener2;
        this.gRe = onClickListener;
        this.eHj = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(bd bdVar) {
        if (bdVar != null && bdVar.bkv() != null) {
            Iterator<UserData> it = bdVar.bkv().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null) {
                    next.setIsLike(next.getHave_attention() > 0);
                }
            }
            ArrayList arrayList = new ArrayList();
            if (this.eHj == null) {
                this.eHj = new ArrayList<>();
            }
            arrayList.addAll(bdVar.bkv());
            if (!y.isEmpty(this.eHj) && this.eHj.get(this.eHj.size() - 1) != null && this.eHj.get(this.eHj.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                this.eHj.get(this.eHj.size() - 1).isLastNewFan = true;
            } else {
                for (int i = 0; i < arrayList.size() - 1; i++) {
                    UserData userData = (UserData) arrayList.get(i);
                    UserData userData2 = (UserData) arrayList.get(i + 1);
                    if (userData != null && userData2 != null && userData.isNewFan && !userData2.isNewFan) {
                        userData.isLastNewFan = true;
                    }
                }
            }
            if (y.isEmpty(this.eHj) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                UserData userData3 = new UserData();
                userData3.mAttentionType = 0;
                arrayList.add(0, userData3);
            }
            this.eHj.addAll(arrayList);
        }
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean gH(long j) {
        if (j == 0 || this.eHj == null || this.eHj.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.eHj.iterator();
        while (it.hasNext()) {
            UserData next = it.next();
            if (next != null && next.getUserIdLong() == j) {
                this.eHj.remove(next);
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gQc) {
            return 1;
        }
        int i = 0;
        if (this.eHj != null) {
            i = this.eHj.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eHj == null || i >= this.eHj.size()) {
            return null;
        }
        return this.eHj.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.eHj == null || i >= this.eHj.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final a aVar;
        View view2;
        if (this.eHj != null) {
            int itemViewType = getItemViewType(i);
            if (view == null || !(view.getTag() instanceof a)) {
                aVar = new a();
                if (itemViewType == 0) {
                    View inflate = LayoutInflater.from(this.kZk.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar.gwK = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar.gwK.setOnClickListener(this.gRe);
                    aVar.kZo = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar.kZo.setRadius(l.getDimens(this.kZk.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar.kZo.setAutoChangeStyle(true);
                    aVar.kZo.setClickable(false);
                    ((LinearLayout.LayoutParams) aVar.kZo.getLayoutParams()).setMargins(l.getDimens(this.kZk, R.dimen.ds34), 0, 0, 0);
                    aVar.gRh = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar.mName.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.myAttentionAndFans.c.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            Layout layout = aVar.mName.getLayout();
                            if (layout != null) {
                                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                                    aVar.mName.setCompoundDrawablePadding(l.getDimens(c.this.kZk, R.dimen.tbds10));
                                } else {
                                    aVar.mName.setCompoundDrawablePadding(0);
                                }
                            }
                        }
                    });
                    aVar.kZp = com.baidu.tbadk.ala.b.bhG().q(this.kZk.getPageContext().getPageActivity(), 5);
                    if (aVar.kZp != null) {
                        aVar.kZp.setVisibility(8);
                        aVar.mContainer.addView(aVar.kZp, 1);
                    }
                    aVar.gQg = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar.gwO = (TextView) inflate.findViewById(R.id.intro);
                    aVar.kZq = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar.kZq.setContext(this.kZk.getPageContext());
                    ((LinearLayout.LayoutParams) aVar.kZq.getLayoutParams()).setMargins(0, 0, l.getDimens(this.kZk, R.dimen.ds34), 0);
                    aVar.ajZ = new com.baidu.tbadk.core.view.userLike.c(this.kZk.getPageContext(), aVar.kZq);
                    aVar.ajZ.a((com.baidu.tbadk.core.view.userLike.a) y.getItem(this.eHj, i));
                    aVar.ajZ.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.c.2
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void jw(boolean z) {
                            if (z) {
                                l.showToast(c.this.kZk, R.string.attention_success);
                            } else {
                                l.showToast(c.this.kZk, R.string.unfollow_success);
                            }
                        }
                    });
                    aVar.mProgress = null;
                    aVar.mTitle = null;
                    aVar.kZr = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    view2 = inflate;
                } else if (itemViewType == 2) {
                    View inflate2 = LayoutInflater.from(this.kZk.getPageContext().getPageActivity()).inflate(R.layout.my_fan_list_title, (ViewGroup) null);
                    aVar.mTitle = (TextView) inflate2.findViewById(R.id.my_new_fan_title);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.kZk.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.kZl);
                    aVar.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar.mTitle = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar);
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.kZq != null) {
                aVar.kZq.setTag(Integer.valueOf(i));
            }
            if (itemViewType == 0) {
                if (this.gQc) {
                    aVar.gRh.setVisibility(8);
                    aVar.gQg.setVisibility(0);
                    if (this.gQe) {
                        aVar.gQg.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.gQg.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.gQg.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.gQg.setText(R.string.no_fan_other);
                    }
                } else {
                    aVar.gwK.setTag(Integer.valueOf(i));
                    UserData userData = (UserData) y.getItem(this.eHj, i);
                    if (userData != null) {
                        aVar.gQg.setVisibility(8);
                        UtilHelper.showHeadImageViewBigV(aVar.kZo, userData, 0);
                        aVar.mName.setText(UtilHelper.getUserName(userData));
                        aVar.kZo.setPlaceHolder(1);
                        aVar.kZo.startLoad(userData.getAvater(), 12, false);
                        if (aVar.kZp != null && userData.getAlaUserData() != null) {
                            if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                                aVar.kZp.setVisibility(8);
                            } else {
                                aVar.kZp.setVisibility(0);
                                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                                aVar2.esy = userData.getAlaUserData();
                                aVar2.type = 5;
                                aVar.kZp.setTag(aVar2);
                            }
                        }
                        if (au.isEmpty(userData.getIntro())) {
                            aVar.gwO.setVisibility(8);
                        } else {
                            aVar.gwO.setVisibility(0);
                            aVar.gwO.setText(userData.getIntro());
                        }
                        String userId = userData.getUserId();
                        userData.setIsLike(userData.getHave_attention() > 0);
                        aVar.ajZ.a(userData);
                        if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            aVar.kZq.setVisibility(8);
                        } else {
                            aVar.kZq.setStatsParams(2, userId);
                            aVar.ajZ.Av("9");
                            aVar.kZq.setVisibility(0);
                        }
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.kZr.getLayoutParams();
                if (y.getItem(this.eHj, i) != null && ((UserData) y.getItem(this.eHj, i)).isLastNewFan) {
                    layoutParams.height = l.getDimens(this.kZk, R.dimen.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                    aVar.kZr.setVisibility(0);
                } else {
                    aVar.kZr.setVisibility(8);
                    layoutParams.height = l.getDimens(this.kZk, R.dimen.ds1);
                    layoutParams.setMargins(l.getDimens(this.kZk, R.dimen.ds34), 0, l.getDimens(this.kZk, R.dimen.ds34), 0);
                }
                aVar.kZr.setLayoutParams(layoutParams);
                aVar.mProgress = null;
            } else if (itemViewType == 2) {
                aVar.mTitle.setText(R.string.new_fans);
                aVar.mTitle.setVisibility(0);
            } else {
                aVar.mName.setText(this.kZk.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.kZk.getLayoutMode().setNightMode(skinType == 1);
        this.kZk.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.mTitle != null) {
                ap.setViewTextColor(aVar.mTitle, R.color.CAM_X0109);
                ap.setBackgroundColor(aVar.mTitle, R.color.CAM_X0205);
            }
            if (aVar.kZr != null) {
                ap.setImageResource(aVar.kZr, R.color.CAM_X0204);
            }
            if (aVar.kZq != null) {
                aVar.kZq.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.gQc) {
            return 0;
        }
        if (this.eHj == null || i >= this.eHj.size()) {
            return 1;
        }
        return this.eHj.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.gQc) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c ajZ;
        TextView gQg;
        LinearLayout gRh;
        ViewGroup gwK;
        TextView gwO;
        ClickableHeaderImageView kZo;
        View kZp;
        MyFansUserLikeButton kZq;
        ImageView kZr;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
