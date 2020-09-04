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
/* loaded from: classes17.dex */
public class c extends b {
    boolean ghv;
    private View.OnClickListener gix;
    private PersonListActivity kiO;
    private View.OnClickListener kiP;
    private int mSex;

    public c(PersonListActivity personListActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.kiO = null;
        this.ghv = true;
        this.mSex = 0;
        this.kiP = null;
        this.gix = null;
        this.kiO = personListActivity;
        this.ghv = z;
        this.mSex = i;
        this.kiP = onClickListener2;
        this.gix = onClickListener;
        this.egb = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(bc bcVar) {
        if (bcVar != null && bcVar.bdx() != null) {
            Iterator<UserData> it = bcVar.bdx().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null) {
                    next.setIsLike(next.getHave_attention() > 0);
                }
            }
            ArrayList arrayList = new ArrayList();
            if (this.egb == null) {
                this.egb = new ArrayList<>();
            }
            arrayList.addAll(bcVar.bdx());
            if (!y.isEmpty(this.egb) && this.egb.get(this.egb.size() - 1) != null && this.egb.get(this.egb.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                this.egb.get(this.egb.size() - 1).isLastNewFan = true;
            } else {
                for (int i = 0; i < arrayList.size() - 1; i++) {
                    UserData userData = (UserData) arrayList.get(i);
                    UserData userData2 = (UserData) arrayList.get(i + 1);
                    if (userData != null && userData2 != null && userData.isNewFan && !userData2.isNewFan) {
                        userData.isLastNewFan = true;
                    }
                }
            }
            if (y.isEmpty(this.egb) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                UserData userData3 = new UserData();
                userData3.mAttentionType = 0;
                arrayList.add(0, userData3);
            }
            this.egb.addAll(arrayList);
        }
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean fB(long j) {
        if (j == 0 || this.egb == null || this.egb.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.egb.iterator();
        while (it.hasNext()) {
            UserData next = it.next();
            if (next != null && next.getUserIdLong() == j) {
                this.egb.remove(next);
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ght) {
            return 1;
        }
        int i = 0;
        if (this.egb != null) {
            i = this.egb.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.egb == null || i >= this.egb.size()) {
            return null;
        }
        return this.egb.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.egb == null || i >= this.egb.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final a aVar;
        View view2;
        if (this.egb != null) {
            int itemViewType = getItemViewType(i);
            if (view == null || !(view.getTag() instanceof a)) {
                aVar = new a();
                if (itemViewType == 0) {
                    View inflate = LayoutInflater.from(this.kiO.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar.fRI = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar.fRI.setOnClickListener(this.gix);
                    aVar.kiS = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar.kiS.setRadius(l.getDimens(this.kiO.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar.kiS.setAutoChangeStyle(true);
                    aVar.kiS.setClickable(false);
                    ((LinearLayout.LayoutParams) aVar.kiS.getLayoutParams()).setMargins(l.getDimens(this.kiO, R.dimen.ds34), 0, 0, 0);
                    aVar.giA = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar.mName.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.myAttentionAndFans.c.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            Layout layout = aVar.mName.getLayout();
                            if (layout != null) {
                                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                                    aVar.mName.setCompoundDrawablePadding(l.getDimens(c.this.kiO, R.dimen.tbds10));
                                } else {
                                    aVar.mName.setCompoundDrawablePadding(0);
                                }
                            }
                        }
                    });
                    aVar.kiT = com.baidu.tbadk.ala.b.bar().q(this.kiO.getPageContext().getPageActivity(), 5);
                    if (aVar.kiT != null) {
                        aVar.kiT.setVisibility(8);
                        aVar.mContainer.addView(aVar.kiT, 1);
                    }
                    aVar.ghx = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar.fRM = (TextView) inflate.findViewById(R.id.intro);
                    aVar.kiU = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar.kiU.setContext(this.kiO.getPageContext());
                    ((LinearLayout.LayoutParams) aVar.kiU.getLayoutParams()).setMargins(0, 0, l.getDimens(this.kiO, R.dimen.ds34), 0);
                    aVar.aje = new com.baidu.tbadk.core.view.userLike.c(this.kiO.getPageContext(), aVar.kiU);
                    aVar.aje.a((com.baidu.tbadk.core.view.userLike.a) y.getItem(this.egb, i));
                    aVar.aje.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.c.2
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void iE(boolean z) {
                            if (z) {
                                l.showToast(c.this.kiO, R.string.attention_success);
                            } else {
                                l.showToast(c.this.kiO, R.string.unfollow_success);
                            }
                        }
                    });
                    aVar.mProgress = null;
                    aVar.mTitle = null;
                    aVar.kiV = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    view2 = inflate;
                } else if (itemViewType == 2) {
                    View inflate2 = LayoutInflater.from(this.kiO.getPageContext().getPageActivity()).inflate(R.layout.my_fan_list_title, (ViewGroup) null);
                    aVar.mTitle = (TextView) inflate2.findViewById(R.id.my_new_fan_title);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.kiO.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.kiP);
                    aVar.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar.mTitle = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar);
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.kiU != null) {
                aVar.kiU.setTag(Integer.valueOf(i));
            }
            if (itemViewType == 0) {
                if (this.ght) {
                    aVar.giA.setVisibility(8);
                    aVar.ghx.setVisibility(0);
                    if (this.ghv) {
                        aVar.ghx.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.ghx.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.ghx.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.ghx.setText(R.string.no_fan_other);
                    }
                } else {
                    aVar.fRI.setTag(Integer.valueOf(i));
                    UserData userData = (UserData) y.getItem(this.egb, i);
                    if (userData != null) {
                        aVar.ghx.setVisibility(8);
                        UtilHelper.showHeadImageViewBigV(aVar.kiS, userData, 0);
                        aVar.mName.setText(UtilHelper.getUserName(userData));
                        aVar.kiS.setPlaceHolder(1);
                        aVar.kiS.startLoad(userData.getAvater(), 12, false);
                        if (aVar.kiT != null && userData.getAlaUserData() != null) {
                            if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                                aVar.kiT.setVisibility(8);
                            } else {
                                aVar.kiT.setVisibility(0);
                                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                                aVar2.dRB = userData.getAlaUserData();
                                aVar2.type = 5;
                                aVar.kiT.setTag(aVar2);
                            }
                        }
                        if (at.isEmpty(userData.getIntro())) {
                            aVar.fRM.setVisibility(8);
                        } else {
                            aVar.fRM.setVisibility(0);
                            aVar.fRM.setText(userData.getIntro());
                        }
                        String userId = userData.getUserId();
                        userData.setIsLike(userData.getHave_attention() > 0);
                        aVar.aje.a(userData);
                        if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            aVar.kiU.setVisibility(8);
                        } else {
                            aVar.kiU.setStatsParams(2, userId);
                            aVar.aje.zm("9");
                            aVar.kiU.setVisibility(0);
                        }
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.kiV.getLayoutParams();
                if (y.getItem(this.egb, i) != null && ((UserData) y.getItem(this.egb, i)).isLastNewFan) {
                    layoutParams.height = l.getDimens(this.kiO, R.dimen.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                    aVar.kiV.setVisibility(0);
                } else {
                    aVar.kiV.setVisibility(8);
                    layoutParams.height = l.getDimens(this.kiO, R.dimen.ds1);
                    layoutParams.setMargins(l.getDimens(this.kiO, R.dimen.ds34), 0, l.getDimens(this.kiO, R.dimen.ds34), 0);
                }
                aVar.kiV.setLayoutParams(layoutParams);
                aVar.mProgress = null;
            } else if (itemViewType == 2) {
                aVar.mTitle.setText(R.string.new_fans);
                aVar.mTitle.setVisibility(0);
            } else {
                aVar.mName.setText(this.kiO.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.kiO.getLayoutMode().setNightMode(skinType == 1);
        this.kiO.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.mTitle != null) {
                ap.setViewTextColor(aVar.mTitle, R.color.cp_cont_d);
                ap.setBackgroundColor(aVar.mTitle, R.color.cp_bg_line_e);
            }
            if (aVar.kiV != null) {
                ap.setImageResource(aVar.kiV, R.color.cp_bg_line_c);
            }
            if (aVar.kiU != null) {
                aVar.kiU.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.ght) {
            return 0;
        }
        if (this.egb == null || i >= this.egb.size()) {
            return 1;
        }
        return this.egb.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.ght) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c aje;
        ViewGroup fRI;
        TextView fRM;
        TextView ghx;
        LinearLayout giA;
        ClickableHeaderImageView kiS;
        View kiT;
        MyFansUserLikeButton kiU;
        ImageView kiV;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
