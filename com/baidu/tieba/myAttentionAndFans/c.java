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
import com.baidu.searchbox.ugc.model.PublishType;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.be;
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
/* loaded from: classes23.dex */
public class c extends b {
    boolean gZr;
    private View.OnClickListener har;
    private PersonListActivity lmG;
    private View.OnClickListener lmH;
    private int mSex;

    public c(PersonListActivity personListActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.lmG = null;
        this.gZr = true;
        this.mSex = 0;
        this.lmH = null;
        this.har = null;
        this.lmG = personListActivity;
        this.gZr = z;
        this.mSex = i;
        this.lmH = onClickListener2;
        this.har = onClickListener;
        this.eOt = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(be beVar) {
        if (beVar != null && beVar.bnI() != null) {
            Iterator<UserData> it = beVar.bnI().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null) {
                    next.setIsLike(next.getHave_attention() > 0);
                }
            }
            ArrayList arrayList = new ArrayList();
            if (this.eOt == null) {
                this.eOt = new ArrayList<>();
            }
            arrayList.addAll(beVar.bnI());
            if (!y.isEmpty(this.eOt) && this.eOt.get(this.eOt.size() - 1) != null && this.eOt.get(this.eOt.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                this.eOt.get(this.eOt.size() - 1).isLastNewFan = true;
            } else {
                for (int i = 0; i < arrayList.size() - 1; i++) {
                    UserData userData = (UserData) arrayList.get(i);
                    UserData userData2 = (UserData) arrayList.get(i + 1);
                    if (userData != null && userData2 != null && userData.isNewFan && !userData2.isNewFan) {
                        userData.isLastNewFan = true;
                    }
                }
            }
            if (y.isEmpty(this.eOt) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                UserData userData3 = new UserData();
                userData3.mAttentionType = 0;
                arrayList.add(0, userData3);
            }
            this.eOt.addAll(arrayList);
        }
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean hm(long j) {
        if (j == 0 || this.eOt == null || this.eOt.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.eOt.iterator();
        while (it.hasNext()) {
            UserData next = it.next();
            if (next != null && next.getUserIdLong() == j) {
                this.eOt.remove(next);
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gZp) {
            return 1;
        }
        int i = 0;
        if (this.eOt != null) {
            i = this.eOt.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eOt == null || i >= this.eOt.size()) {
            return null;
        }
        return this.eOt.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.eOt == null || i >= this.eOt.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final a aVar;
        View view2;
        if (this.eOt != null) {
            int itemViewType = getItemViewType(i);
            if (view == null || !(view.getTag() instanceof a)) {
                aVar = new a();
                if (itemViewType == 0) {
                    View inflate = LayoutInflater.from(this.lmG.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar.gFv = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar.gFv.setOnClickListener(this.har);
                    aVar.lmK = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar.lmK.setRadius(l.getDimens(this.lmG.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar.lmK.setAutoChangeStyle(true);
                    aVar.lmK.setClickable(false);
                    ((LinearLayout.LayoutParams) aVar.lmK.getLayoutParams()).setMargins(l.getDimens(this.lmG, R.dimen.ds34), 0, 0, 0);
                    aVar.hau = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar.mName.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.myAttentionAndFans.c.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            Layout layout = aVar.mName.getLayout();
                            if (layout != null) {
                                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                                    aVar.mName.setCompoundDrawablePadding(l.getDimens(c.this.lmG, R.dimen.tbds10));
                                } else {
                                    aVar.mName.setCompoundDrawablePadding(0);
                                }
                            }
                        }
                    });
                    aVar.lmL = com.baidu.tbadk.ala.b.bkP().z(this.lmG.getPageContext().getPageActivity(), 5);
                    if (aVar.lmL != null) {
                        aVar.lmL.setVisibility(8);
                        aVar.mContainer.addView(aVar.lmL, 1);
                    }
                    aVar.gZt = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar.gFz = (TextView) inflate.findViewById(R.id.intro);
                    aVar.lmM = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar.lmM.setContext(this.lmG.getPageContext());
                    ((LinearLayout.LayoutParams) aVar.lmM.getLayoutParams()).setMargins(0, 0, l.getDimens(this.lmG, R.dimen.ds34), 0);
                    aVar.akZ = new com.baidu.tbadk.core.view.userLike.c(this.lmG.getPageContext(), aVar.lmM);
                    aVar.akZ.a((com.baidu.tbadk.core.view.userLike.a) y.getItem(this.eOt, i));
                    aVar.akZ.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.c.2
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void jM(boolean z) {
                            if (z) {
                                l.showToast(c.this.lmG, R.string.attention_success);
                            } else {
                                l.showToast(c.this.lmG, R.string.unfollow_success);
                            }
                        }
                    });
                    aVar.mProgress = null;
                    aVar.mTitle = null;
                    aVar.lmN = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    view2 = inflate;
                } else if (itemViewType == 2) {
                    View inflate2 = LayoutInflater.from(this.lmG.getPageContext().getPageActivity()).inflate(R.layout.my_fan_list_title, (ViewGroup) null);
                    aVar.mTitle = (TextView) inflate2.findViewById(R.id.my_new_fan_title);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.lmG.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.lmH);
                    aVar.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar.mTitle = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar);
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.lmM != null) {
                aVar.lmM.setTag(Integer.valueOf(i));
            }
            if (itemViewType == 0) {
                if (this.gZp) {
                    aVar.hau.setVisibility(8);
                    aVar.gZt.setVisibility(0);
                    if (this.gZr) {
                        aVar.gZt.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.gZt.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.gZt.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.gZt.setText(R.string.no_fan_other);
                    }
                } else {
                    aVar.gFv.setTag(Integer.valueOf(i));
                    UserData userData = (UserData) y.getItem(this.eOt, i);
                    if (userData != null) {
                        aVar.gZt.setVisibility(8);
                        UtilHelper.showHeadImageViewBigV(aVar.lmK, userData, 0);
                        aVar.mName.setText(UtilHelper.getUserName(userData));
                        aVar.lmK.setPlaceHolder(1);
                        aVar.lmK.startLoad(userData.getAvater(), 12, false);
                        if (aVar.lmL != null && userData.getAlaUserData() != null) {
                            if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                                aVar.lmL.setVisibility(8);
                            } else {
                                aVar.lmL.setVisibility(0);
                                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                                aVar2.ezB = userData.getAlaUserData();
                                aVar2.type = 5;
                                aVar.lmL.setTag(aVar2);
                            }
                        }
                        if (au.isEmpty(userData.getIntro())) {
                            aVar.gFz.setVisibility(8);
                        } else {
                            aVar.gFz.setVisibility(0);
                            aVar.gFz.setText(userData.getIntro());
                        }
                        String userId = userData.getUserId();
                        userData.setIsLike(userData.getHave_attention() > 0);
                        aVar.akZ.a(userData);
                        if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            aVar.lmM.setVisibility(8);
                        } else {
                            aVar.lmM.setStatsParams(2, userId);
                            aVar.akZ.Bc(PublishType.TYPE_VIDEO_SHARE);
                            aVar.lmM.setVisibility(0);
                        }
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.lmN.getLayoutParams();
                if (y.getItem(this.eOt, i) != null && ((UserData) y.getItem(this.eOt, i)).isLastNewFan) {
                    layoutParams.height = l.getDimens(this.lmG, R.dimen.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                    aVar.lmN.setVisibility(0);
                } else {
                    aVar.lmN.setVisibility(8);
                    layoutParams.height = l.getDimens(this.lmG, R.dimen.ds1);
                    layoutParams.setMargins(l.getDimens(this.lmG, R.dimen.ds34), 0, l.getDimens(this.lmG, R.dimen.ds34), 0);
                }
                aVar.lmN.setLayoutParams(layoutParams);
                aVar.mProgress = null;
            } else if (itemViewType == 2) {
                aVar.mTitle.setText(R.string.new_fans);
                aVar.mTitle.setVisibility(0);
            } else {
                aVar.mName.setText(this.lmG.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.lmG.getLayoutMode().setNightMode(skinType == 1);
        this.lmG.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.mTitle != null) {
                ap.setViewTextColor(aVar.mTitle, R.color.CAM_X0109);
                ap.setBackgroundColor(aVar.mTitle, R.color.CAM_X0205);
            }
            if (aVar.lmN != null) {
                ap.setImageResource(aVar.lmN, R.color.CAM_X0204);
            }
            if (aVar.lmM != null) {
                aVar.lmM.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.gZp) {
            return 0;
        }
        if (this.eOt == null || i >= this.eOt.size()) {
            return 1;
        }
        return this.eOt.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.gZp) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c akZ;
        ViewGroup gFv;
        TextView gFz;
        TextView gZt;
        LinearLayout hau;
        ClickableHeaderImageView lmK;
        View lmL;
        MyFansUserLikeButton lmM;
        ImageView lmN;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
