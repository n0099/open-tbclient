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
import com.baidu.tbadk.core.data.bg;
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
/* loaded from: classes7.dex */
public class c extends b {
    boolean hmO;
    private View.OnClickListener hnN;
    private PersonListActivity lxN;
    private View.OnClickListener lxO;
    private int mSex;

    public c(PersonListActivity personListActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.lxN = null;
        this.hmO = true;
        this.mSex = 0;
        this.lxO = null;
        this.hnN = null;
        this.lxN = personListActivity;
        this.hmO = z;
        this.mSex = i;
        this.lxO = onClickListener2;
        this.hnN = onClickListener;
        this.eXu = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(bg bgVar) {
        if (bgVar != null && bgVar.bmK() != null) {
            Iterator<UserData> it = bgVar.bmK().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null) {
                    next.setIsLike(next.getHave_attention() > 0);
                }
            }
            ArrayList arrayList = new ArrayList();
            if (this.eXu == null) {
                this.eXu = new ArrayList<>();
            }
            arrayList.addAll(bgVar.bmK());
            if (!y.isEmpty(this.eXu) && this.eXu.get(this.eXu.size() - 1) != null && this.eXu.get(this.eXu.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                this.eXu.get(this.eXu.size() - 1).isLastNewFan = true;
            } else {
                for (int i = 0; i < arrayList.size() - 1; i++) {
                    UserData userData = (UserData) arrayList.get(i);
                    UserData userData2 = (UserData) arrayList.get(i + 1);
                    if (userData != null && userData2 != null && userData.isNewFan && !userData2.isNewFan) {
                        userData.isLastNewFan = true;
                    }
                }
            }
            if (y.isEmpty(this.eXu) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                UserData userData3 = new UserData();
                userData3.mAttentionType = 0;
                arrayList.add(0, userData3);
            }
            this.eXu.addAll(arrayList);
        }
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean hm(long j) {
        if (j == 0 || this.eXu == null || this.eXu.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.eXu.iterator();
        while (it.hasNext()) {
            UserData next = it.next();
            if (next != null && next.getUserIdLong() == j) {
                this.eXu.remove(next);
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hmM) {
            return 1;
        }
        int i = 0;
        if (this.eXu != null) {
            i = this.eXu.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eXu == null || i >= this.eXu.size()) {
            return null;
        }
        return this.eXu.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.eXu == null || i >= this.eXu.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final a aVar;
        View view2;
        if (this.eXu != null) {
            int itemViewType = getItemViewType(i);
            if (view == null || !(view.getTag() instanceof a)) {
                aVar = new a();
                if (itemViewType == 0) {
                    View inflate = LayoutInflater.from(this.lxN.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar.gRf = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar.gRf.setOnClickListener(this.hnN);
                    aVar.lxR = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar.lxR.setRadius(l.getDimens(this.lxN.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar.lxR.setAutoChangeStyle(true);
                    aVar.lxR.setClickable(false);
                    ((LinearLayout.LayoutParams) aVar.lxR.getLayoutParams()).setMargins(l.getDimens(this.lxN, R.dimen.ds34), 0, 0, 0);
                    aVar.hnQ = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar.mName.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.myAttentionAndFans.c.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            Layout layout = aVar.mName.getLayout();
                            if (layout != null) {
                                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                                    aVar.mName.setCompoundDrawablePadding(l.getDimens(c.this.lxN, R.dimen.tbds10));
                                } else {
                                    aVar.mName.setCompoundDrawablePadding(0);
                                }
                            }
                        }
                    });
                    aVar.lxS = com.baidu.tbadk.ala.b.bjS().A(this.lxN.getPageContext().getPageActivity(), 5);
                    if (aVar.lxS != null) {
                        aVar.lxS.setVisibility(8);
                        aVar.mContainer.addView(aVar.lxS, 1);
                    }
                    aVar.hmQ = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar.gRj = (TextView) inflate.findViewById(R.id.intro);
                    aVar.lxT = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar.lxT.setContext(this.lxN.getPageContext());
                    ((LinearLayout.LayoutParams) aVar.lxT.getLayoutParams()).setMargins(0, 0, l.getDimens(this.lxN, R.dimen.ds34), 0);
                    aVar.alS = new com.baidu.tbadk.core.view.userLike.c(this.lxN.getPageContext(), aVar.lxT);
                    aVar.alS.a((com.baidu.tbadk.core.view.userLike.a) y.getItem(this.eXu, i));
                    aVar.alS.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.c.2
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void kh(boolean z) {
                            if (z) {
                                l.showToast(c.this.lxN, R.string.attention_success);
                            } else {
                                l.showToast(c.this.lxN, R.string.unfollow_success);
                            }
                        }
                    });
                    aVar.mProgress = null;
                    aVar.mTitle = null;
                    aVar.lxU = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    view2 = inflate;
                } else if (itemViewType == 2) {
                    View inflate2 = LayoutInflater.from(this.lxN.getPageContext().getPageActivity()).inflate(R.layout.my_fan_list_title, (ViewGroup) null);
                    aVar.mTitle = (TextView) inflate2.findViewById(R.id.my_new_fan_title);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.lxN.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.lxO);
                    aVar.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar.mTitle = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar);
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.lxT != null) {
                aVar.lxT.setTag(Integer.valueOf(i));
            }
            if (itemViewType == 0) {
                if (this.hmM) {
                    aVar.hnQ.setVisibility(8);
                    aVar.hmQ.setVisibility(0);
                    if (this.hmO) {
                        aVar.hmQ.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.hmQ.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.hmQ.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.hmQ.setText(R.string.no_fan_other);
                    }
                } else {
                    aVar.gRf.setTag(Integer.valueOf(i));
                    UserData userData = (UserData) y.getItem(this.eXu, i);
                    if (userData != null) {
                        aVar.hmQ.setVisibility(8);
                        UtilHelper.showHeadImageViewBigV(aVar.lxR, userData, 0);
                        aVar.mName.setText(UtilHelper.getUserName(userData));
                        aVar.lxR.setPlaceHolder(1);
                        aVar.lxR.startLoad(userData.getAvater(), 12, false);
                        if (aVar.lxS != null && userData.getAlaUserData() != null) {
                            if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                                aVar.lxS.setVisibility(8);
                            } else {
                                aVar.lxS.setVisibility(0);
                                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                                aVar2.eIb = userData.getAlaUserData();
                                aVar2.type = 5;
                                aVar.lxS.setTag(aVar2);
                            }
                        }
                        if (au.isEmpty(userData.getIntro())) {
                            aVar.gRj.setVisibility(8);
                        } else {
                            aVar.gRj.setVisibility(0);
                            aVar.gRj.setText(userData.getIntro());
                        }
                        String userId = userData.getUserId();
                        userData.setIsLike(userData.getHave_attention() > 0);
                        aVar.alS.a(userData);
                        if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            aVar.lxT.setVisibility(8);
                        } else {
                            aVar.lxT.setStatsParams(2, userId);
                            aVar.alS.An("9");
                            aVar.lxT.setVisibility(0);
                        }
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.lxU.getLayoutParams();
                if (y.getItem(this.eXu, i) != null && ((UserData) y.getItem(this.eXu, i)).isLastNewFan) {
                    layoutParams.height = l.getDimens(this.lxN, R.dimen.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                    aVar.lxU.setVisibility(0);
                } else {
                    aVar.lxU.setVisibility(8);
                    layoutParams.height = l.getDimens(this.lxN, R.dimen.ds1);
                    layoutParams.setMargins(l.getDimens(this.lxN, R.dimen.ds34), 0, l.getDimens(this.lxN, R.dimen.ds34), 0);
                }
                aVar.lxU.setLayoutParams(layoutParams);
                aVar.mProgress = null;
            } else if (itemViewType == 2) {
                aVar.mTitle.setText(R.string.new_fans);
                aVar.mTitle.setVisibility(0);
            } else {
                aVar.mName.setText(this.lxN.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.lxN.getLayoutMode().setNightMode(skinType == 1);
        this.lxN.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.mTitle != null) {
                ap.setViewTextColor(aVar.mTitle, R.color.CAM_X0109);
                ap.setBackgroundColor(aVar.mTitle, R.color.CAM_X0205);
            }
            if (aVar.lxU != null) {
                ap.setImageResource(aVar.lxU, R.color.CAM_X0204);
            }
            if (aVar.lxT != null) {
                aVar.lxT.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.hmM) {
            return 0;
        }
        if (this.eXu == null || i >= this.eXu.size()) {
            return 1;
        }
        return this.eXu.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.hmM) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c alS;
        ViewGroup gRf;
        TextView gRj;
        TextView hmQ;
        LinearLayout hnQ;
        ClickableHeaderImageView lxR;
        View lxS;
        MyFansUserLikeButton lxT;
        ImageView lxU;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
