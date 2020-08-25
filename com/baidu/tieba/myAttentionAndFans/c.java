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
    boolean ghr;
    private View.OnClickListener git;
    private PersonListActivity kiH;
    private View.OnClickListener kiI;
    private int mSex;

    public c(PersonListActivity personListActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.kiH = null;
        this.ghr = true;
        this.mSex = 0;
        this.kiI = null;
        this.git = null;
        this.kiH = personListActivity;
        this.ghr = z;
        this.mSex = i;
        this.kiI = onClickListener2;
        this.git = onClickListener;
        this.efX = new ArrayList<>();
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
            if (this.efX == null) {
                this.efX = new ArrayList<>();
            }
            arrayList.addAll(bcVar.bdx());
            if (!y.isEmpty(this.efX) && this.efX.get(this.efX.size() - 1) != null && this.efX.get(this.efX.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                this.efX.get(this.efX.size() - 1).isLastNewFan = true;
            } else {
                for (int i = 0; i < arrayList.size() - 1; i++) {
                    UserData userData = (UserData) arrayList.get(i);
                    UserData userData2 = (UserData) arrayList.get(i + 1);
                    if (userData != null && userData2 != null && userData.isNewFan && !userData2.isNewFan) {
                        userData.isLastNewFan = true;
                    }
                }
            }
            if (y.isEmpty(this.efX) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                UserData userData3 = new UserData();
                userData3.mAttentionType = 0;
                arrayList.add(0, userData3);
            }
            this.efX.addAll(arrayList);
        }
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean fB(long j) {
        if (j == 0 || this.efX == null || this.efX.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.efX.iterator();
        while (it.hasNext()) {
            UserData next = it.next();
            if (next != null && next.getUserIdLong() == j) {
                this.efX.remove(next);
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ghp) {
            return 1;
        }
        int i = 0;
        if (this.efX != null) {
            i = this.efX.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.efX == null || i >= this.efX.size()) {
            return null;
        }
        return this.efX.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.efX == null || i >= this.efX.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final a aVar;
        View view2;
        if (this.efX != null) {
            int itemViewType = getItemViewType(i);
            if (view == null || !(view.getTag() instanceof a)) {
                aVar = new a();
                if (itemViewType == 0) {
                    View inflate = LayoutInflater.from(this.kiH.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar.fRE = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar.fRE.setOnClickListener(this.git);
                    aVar.kiL = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar.kiL.setRadius(l.getDimens(this.kiH.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar.kiL.setAutoChangeStyle(true);
                    aVar.kiL.setClickable(false);
                    ((LinearLayout.LayoutParams) aVar.kiL.getLayoutParams()).setMargins(l.getDimens(this.kiH, R.dimen.ds34), 0, 0, 0);
                    aVar.giw = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar.mName.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.myAttentionAndFans.c.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            Layout layout = aVar.mName.getLayout();
                            if (layout != null) {
                                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                                    aVar.mName.setCompoundDrawablePadding(l.getDimens(c.this.kiH, R.dimen.tbds10));
                                } else {
                                    aVar.mName.setCompoundDrawablePadding(0);
                                }
                            }
                        }
                    });
                    aVar.kiM = com.baidu.tbadk.ala.b.bar().q(this.kiH.getPageContext().getPageActivity(), 5);
                    if (aVar.kiM != null) {
                        aVar.kiM.setVisibility(8);
                        aVar.mContainer.addView(aVar.kiM, 1);
                    }
                    aVar.ght = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar.fRI = (TextView) inflate.findViewById(R.id.intro);
                    aVar.kiN = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar.kiN.setContext(this.kiH.getPageContext());
                    ((LinearLayout.LayoutParams) aVar.kiN.getLayoutParams()).setMargins(0, 0, l.getDimens(this.kiH, R.dimen.ds34), 0);
                    aVar.ajc = new com.baidu.tbadk.core.view.userLike.c(this.kiH.getPageContext(), aVar.kiN);
                    aVar.ajc.a((com.baidu.tbadk.core.view.userLike.a) y.getItem(this.efX, i));
                    aVar.ajc.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.c.2
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void iD(boolean z) {
                            if (z) {
                                l.showToast(c.this.kiH, R.string.attention_success);
                            } else {
                                l.showToast(c.this.kiH, R.string.unfollow_success);
                            }
                        }
                    });
                    aVar.mProgress = null;
                    aVar.mTitle = null;
                    aVar.kiO = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    view2 = inflate;
                } else if (itemViewType == 2) {
                    View inflate2 = LayoutInflater.from(this.kiH.getPageContext().getPageActivity()).inflate(R.layout.my_fan_list_title, (ViewGroup) null);
                    aVar.mTitle = (TextView) inflate2.findViewById(R.id.my_new_fan_title);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.kiH.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.kiI);
                    aVar.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar.mTitle = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar);
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.kiN != null) {
                aVar.kiN.setTag(Integer.valueOf(i));
            }
            if (itemViewType == 0) {
                if (this.ghp) {
                    aVar.giw.setVisibility(8);
                    aVar.ght.setVisibility(0);
                    if (this.ghr) {
                        aVar.ght.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.ght.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.ght.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.ght.setText(R.string.no_fan_other);
                    }
                } else {
                    aVar.fRE.setTag(Integer.valueOf(i));
                    UserData userData = (UserData) y.getItem(this.efX, i);
                    if (userData != null) {
                        aVar.ght.setVisibility(8);
                        UtilHelper.showHeadImageViewBigV(aVar.kiL, userData, 0);
                        aVar.mName.setText(UtilHelper.getUserName(userData));
                        aVar.kiL.setPlaceHolder(1);
                        aVar.kiL.startLoad(userData.getAvater(), 12, false);
                        if (aVar.kiM != null && userData.getAlaUserData() != null) {
                            if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                                aVar.kiM.setVisibility(8);
                            } else {
                                aVar.kiM.setVisibility(0);
                                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                                aVar2.dRx = userData.getAlaUserData();
                                aVar2.type = 5;
                                aVar.kiM.setTag(aVar2);
                            }
                        }
                        if (at.isEmpty(userData.getIntro())) {
                            aVar.fRI.setVisibility(8);
                        } else {
                            aVar.fRI.setVisibility(0);
                            aVar.fRI.setText(userData.getIntro());
                        }
                        String userId = userData.getUserId();
                        userData.setIsLike(userData.getHave_attention() > 0);
                        aVar.ajc.a(userData);
                        if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            aVar.kiN.setVisibility(8);
                        } else {
                            aVar.kiN.setStatsParams(2, userId);
                            aVar.ajc.zl("9");
                            aVar.kiN.setVisibility(0);
                        }
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.kiO.getLayoutParams();
                if (y.getItem(this.efX, i) != null && ((UserData) y.getItem(this.efX, i)).isLastNewFan) {
                    layoutParams.height = l.getDimens(this.kiH, R.dimen.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                    aVar.kiO.setVisibility(0);
                } else {
                    aVar.kiO.setVisibility(8);
                    layoutParams.height = l.getDimens(this.kiH, R.dimen.ds1);
                    layoutParams.setMargins(l.getDimens(this.kiH, R.dimen.ds34), 0, l.getDimens(this.kiH, R.dimen.ds34), 0);
                }
                aVar.kiO.setLayoutParams(layoutParams);
                aVar.mProgress = null;
            } else if (itemViewType == 2) {
                aVar.mTitle.setText(R.string.new_fans);
                aVar.mTitle.setVisibility(0);
            } else {
                aVar.mName.setText(this.kiH.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.kiH.getLayoutMode().setNightMode(skinType == 1);
        this.kiH.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.mTitle != null) {
                ap.setViewTextColor(aVar.mTitle, R.color.cp_cont_d);
                ap.setBackgroundColor(aVar.mTitle, R.color.cp_bg_line_e);
            }
            if (aVar.kiO != null) {
                ap.setImageResource(aVar.kiO, R.color.cp_bg_line_c);
            }
            if (aVar.kiN != null) {
                aVar.kiN.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.ghp) {
            return 0;
        }
        if (this.efX == null || i >= this.efX.size()) {
            return 1;
        }
        return this.efX.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.ghp) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c ajc;
        ViewGroup fRE;
        TextView fRI;
        TextView ght;
        LinearLayout giw;
        ClickableHeaderImageView kiL;
        View kiM;
        MyFansUserLikeButton kiN;
        ImageView kiO;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
