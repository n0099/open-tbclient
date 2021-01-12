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
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes7.dex */
public class c extends b {
    boolean hgB;
    private View.OnClickListener hhA;
    private PersonListActivity lnr;
    private View.OnClickListener lns;
    private int mSex;

    public c(PersonListActivity personListActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.lnr = null;
        this.hgB = true;
        this.mSex = 0;
        this.lns = null;
        this.hhA = null;
        this.lnr = personListActivity;
        this.hgB = z;
        this.mSex = i;
        this.lns = onClickListener2;
        this.hhA = onClickListener;
        this.eTF = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(be beVar) {
        if (beVar != null && beVar.bmp() != null) {
            Iterator<UserData> it = beVar.bmp().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null) {
                    next.setIsLike(next.getHave_attention() > 0);
                }
            }
            ArrayList arrayList = new ArrayList();
            if (this.eTF == null) {
                this.eTF = new ArrayList<>();
            }
            arrayList.addAll(beVar.bmp());
            if (!x.isEmpty(this.eTF) && this.eTF.get(this.eTF.size() - 1) != null && this.eTF.get(this.eTF.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                this.eTF.get(this.eTF.size() - 1).isLastNewFan = true;
            } else {
                for (int i = 0; i < arrayList.size() - 1; i++) {
                    UserData userData = (UserData) arrayList.get(i);
                    UserData userData2 = (UserData) arrayList.get(i + 1);
                    if (userData != null && userData2 != null && userData.isNewFan && !userData2.isNewFan) {
                        userData.isLastNewFan = true;
                    }
                }
            }
            if (x.isEmpty(this.eTF) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                UserData userData3 = new UserData();
                userData3.mAttentionType = 0;
                arrayList.add(0, userData3);
            }
            this.eTF.addAll(arrayList);
        }
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean hh(long j) {
        if (j == 0 || this.eTF == null || this.eTF.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.eTF.iterator();
        while (it.hasNext()) {
            UserData next = it.next();
            if (next != null && next.getUserIdLong() == j) {
                this.eTF.remove(next);
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hgz) {
            return 1;
        }
        int i = 0;
        if (this.eTF != null) {
            i = this.eTF.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eTF == null || i >= this.eTF.size()) {
            return null;
        }
        return this.eTF.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.eTF == null || i >= this.eTF.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final a aVar;
        View view2;
        if (this.eTF != null) {
            int itemViewType = getItemViewType(i);
            if (view == null || !(view.getTag() instanceof a)) {
                aVar = new a();
                if (itemViewType == 0) {
                    View inflate = LayoutInflater.from(this.lnr.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar.gMC = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar.gMC.setOnClickListener(this.hhA);
                    aVar.lnv = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar.lnv.setRadius(l.getDimens(this.lnr.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar.lnv.setAutoChangeStyle(true);
                    aVar.lnv.setClickable(false);
                    ((LinearLayout.LayoutParams) aVar.lnv.getLayoutParams()).setMargins(l.getDimens(this.lnr, R.dimen.ds34), 0, 0, 0);
                    aVar.hhD = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar.mName.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.myAttentionAndFans.c.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            Layout layout = aVar.mName.getLayout();
                            if (layout != null) {
                                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                                    aVar.mName.setCompoundDrawablePadding(l.getDimens(c.this.lnr, R.dimen.tbds10));
                                } else {
                                    aVar.mName.setCompoundDrawablePadding(0);
                                }
                            }
                        }
                    });
                    aVar.lnw = com.baidu.tbadk.ala.b.bjv().A(this.lnr.getPageContext().getPageActivity(), 5);
                    if (aVar.lnw != null) {
                        aVar.lnw.setVisibility(8);
                        aVar.mContainer.addView(aVar.lnw, 1);
                    }
                    aVar.hgD = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar.gMG = (TextView) inflate.findViewById(R.id.intro);
                    aVar.lnx = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar.lnx.setContext(this.lnr.getPageContext());
                    ((LinearLayout.LayoutParams) aVar.lnx.getLayoutParams()).setMargins(0, 0, l.getDimens(this.lnr, R.dimen.ds34), 0);
                    aVar.akK = new com.baidu.tbadk.core.view.userLike.c(this.lnr.getPageContext(), aVar.lnx);
                    aVar.akK.a((com.baidu.tbadk.core.view.userLike.a) x.getItem(this.eTF, i));
                    aVar.akK.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.c.2
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void ke(boolean z) {
                            if (z) {
                                l.showToast(c.this.lnr, R.string.attention_success);
                            } else {
                                l.showToast(c.this.lnr, R.string.unfollow_success);
                            }
                        }
                    });
                    aVar.mProgress = null;
                    aVar.mTitle = null;
                    aVar.lny = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    view2 = inflate;
                } else if (itemViewType == 2) {
                    View inflate2 = LayoutInflater.from(this.lnr.getPageContext().getPageActivity()).inflate(R.layout.my_fan_list_title, (ViewGroup) null);
                    aVar.mTitle = (TextView) inflate2.findViewById(R.id.my_new_fan_title);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.lnr.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.lns);
                    aVar.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar.mTitle = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar);
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.lnx != null) {
                aVar.lnx.setTag(Integer.valueOf(i));
            }
            if (itemViewType == 0) {
                if (this.hgz) {
                    aVar.hhD.setVisibility(8);
                    aVar.hgD.setVisibility(0);
                    if (this.hgB) {
                        aVar.hgD.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.hgD.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.hgD.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.hgD.setText(R.string.no_fan_other);
                    }
                } else {
                    aVar.gMC.setTag(Integer.valueOf(i));
                    UserData userData = (UserData) x.getItem(this.eTF, i);
                    if (userData != null) {
                        aVar.hgD.setVisibility(8);
                        UtilHelper.showHeadImageViewBigV(aVar.lnv, userData, 0);
                        aVar.mName.setText(UtilHelper.getUserName(userData));
                        aVar.lnv.setPlaceHolder(1);
                        aVar.lnv.startLoad(userData.getAvater(), 12, false);
                        if (aVar.lnw != null && userData.getAlaUserData() != null) {
                            if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                                aVar.lnw.setVisibility(8);
                            } else {
                                aVar.lnw.setVisibility(0);
                                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                                aVar2.eEt = userData.getAlaUserData();
                                aVar2.type = 5;
                                aVar.lnw.setTag(aVar2);
                            }
                        }
                        if (at.isEmpty(userData.getIntro())) {
                            aVar.gMG.setVisibility(8);
                        } else {
                            aVar.gMG.setVisibility(0);
                            aVar.gMG.setText(userData.getIntro());
                        }
                        String userId = userData.getUserId();
                        userData.setIsLike(userData.getHave_attention() > 0);
                        aVar.akK.a(userData);
                        if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            aVar.lnx.setVisibility(8);
                        } else {
                            aVar.lnx.setStatsParams(2, userId);
                            aVar.akK.zP("9");
                            aVar.lnx.setVisibility(0);
                        }
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.lny.getLayoutParams();
                if (x.getItem(this.eTF, i) != null && ((UserData) x.getItem(this.eTF, i)).isLastNewFan) {
                    layoutParams.height = l.getDimens(this.lnr, R.dimen.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                    aVar.lny.setVisibility(0);
                } else {
                    aVar.lny.setVisibility(8);
                    layoutParams.height = l.getDimens(this.lnr, R.dimen.ds1);
                    layoutParams.setMargins(l.getDimens(this.lnr, R.dimen.ds34), 0, l.getDimens(this.lnr, R.dimen.ds34), 0);
                }
                aVar.lny.setLayoutParams(layoutParams);
                aVar.mProgress = null;
            } else if (itemViewType == 2) {
                aVar.mTitle.setText(R.string.new_fans);
                aVar.mTitle.setVisibility(0);
            } else {
                aVar.mName.setText(this.lnr.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.lnr.getLayoutMode().setNightMode(skinType == 1);
        this.lnr.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.mTitle != null) {
                ao.setViewTextColor(aVar.mTitle, R.color.CAM_X0109);
                ao.setBackgroundColor(aVar.mTitle, R.color.CAM_X0205);
            }
            if (aVar.lny != null) {
                ao.setImageResource(aVar.lny, R.color.CAM_X0204);
            }
            if (aVar.lnx != null) {
                aVar.lnx.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.hgz) {
            return 0;
        }
        if (this.eTF == null || i >= this.eTF.size()) {
            return 1;
        }
        return this.eTF.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.hgz) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c akK;
        ViewGroup gMC;
        TextView gMG;
        TextView hgD;
        LinearLayout hhD;
        ClickableHeaderImageView lnv;
        View lnw;
        MyFansUserLikeButton lnx;
        ImageView lny;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
