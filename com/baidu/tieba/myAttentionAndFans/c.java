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
    boolean gZt;
    private View.OnClickListener hat;
    private PersonListActivity lmI;
    private View.OnClickListener lmJ;
    private int mSex;

    public c(PersonListActivity personListActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.lmI = null;
        this.gZt = true;
        this.mSex = 0;
        this.lmJ = null;
        this.hat = null;
        this.lmI = personListActivity;
        this.gZt = z;
        this.mSex = i;
        this.lmJ = onClickListener2;
        this.hat = onClickListener;
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
        if (this.gZr) {
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
                    View inflate = LayoutInflater.from(this.lmI.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar.gFx = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar.gFx.setOnClickListener(this.hat);
                    aVar.lmM = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar.lmM.setRadius(l.getDimens(this.lmI.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar.lmM.setAutoChangeStyle(true);
                    aVar.lmM.setClickable(false);
                    ((LinearLayout.LayoutParams) aVar.lmM.getLayoutParams()).setMargins(l.getDimens(this.lmI, R.dimen.ds34), 0, 0, 0);
                    aVar.haw = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar.mName.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.myAttentionAndFans.c.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            Layout layout = aVar.mName.getLayout();
                            if (layout != null) {
                                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                                    aVar.mName.setCompoundDrawablePadding(l.getDimens(c.this.lmI, R.dimen.tbds10));
                                } else {
                                    aVar.mName.setCompoundDrawablePadding(0);
                                }
                            }
                        }
                    });
                    aVar.lmN = com.baidu.tbadk.ala.b.bkP().z(this.lmI.getPageContext().getPageActivity(), 5);
                    if (aVar.lmN != null) {
                        aVar.lmN.setVisibility(8);
                        aVar.mContainer.addView(aVar.lmN, 1);
                    }
                    aVar.gZv = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar.gFB = (TextView) inflate.findViewById(R.id.intro);
                    aVar.lmO = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar.lmO.setContext(this.lmI.getPageContext());
                    ((LinearLayout.LayoutParams) aVar.lmO.getLayoutParams()).setMargins(0, 0, l.getDimens(this.lmI, R.dimen.ds34), 0);
                    aVar.akZ = new com.baidu.tbadk.core.view.userLike.c(this.lmI.getPageContext(), aVar.lmO);
                    aVar.akZ.a((com.baidu.tbadk.core.view.userLike.a) y.getItem(this.eOt, i));
                    aVar.akZ.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.c.2
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void jM(boolean z) {
                            if (z) {
                                l.showToast(c.this.lmI, R.string.attention_success);
                            } else {
                                l.showToast(c.this.lmI, R.string.unfollow_success);
                            }
                        }
                    });
                    aVar.mProgress = null;
                    aVar.mTitle = null;
                    aVar.lmP = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    view2 = inflate;
                } else if (itemViewType == 2) {
                    View inflate2 = LayoutInflater.from(this.lmI.getPageContext().getPageActivity()).inflate(R.layout.my_fan_list_title, (ViewGroup) null);
                    aVar.mTitle = (TextView) inflate2.findViewById(R.id.my_new_fan_title);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.lmI.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.lmJ);
                    aVar.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar.mTitle = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar);
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.lmO != null) {
                aVar.lmO.setTag(Integer.valueOf(i));
            }
            if (itemViewType == 0) {
                if (this.gZr) {
                    aVar.haw.setVisibility(8);
                    aVar.gZv.setVisibility(0);
                    if (this.gZt) {
                        aVar.gZv.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.gZv.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.gZv.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.gZv.setText(R.string.no_fan_other);
                    }
                } else {
                    aVar.gFx.setTag(Integer.valueOf(i));
                    UserData userData = (UserData) y.getItem(this.eOt, i);
                    if (userData != null) {
                        aVar.gZv.setVisibility(8);
                        UtilHelper.showHeadImageViewBigV(aVar.lmM, userData, 0);
                        aVar.mName.setText(UtilHelper.getUserName(userData));
                        aVar.lmM.setPlaceHolder(1);
                        aVar.lmM.startLoad(userData.getAvater(), 12, false);
                        if (aVar.lmN != null && userData.getAlaUserData() != null) {
                            if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                                aVar.lmN.setVisibility(8);
                            } else {
                                aVar.lmN.setVisibility(0);
                                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                                aVar2.ezB = userData.getAlaUserData();
                                aVar2.type = 5;
                                aVar.lmN.setTag(aVar2);
                            }
                        }
                        if (au.isEmpty(userData.getIntro())) {
                            aVar.gFB.setVisibility(8);
                        } else {
                            aVar.gFB.setVisibility(0);
                            aVar.gFB.setText(userData.getIntro());
                        }
                        String userId = userData.getUserId();
                        userData.setIsLike(userData.getHave_attention() > 0);
                        aVar.akZ.a(userData);
                        if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            aVar.lmO.setVisibility(8);
                        } else {
                            aVar.lmO.setStatsParams(2, userId);
                            aVar.akZ.Bc(PublishType.TYPE_VIDEO_SHARE);
                            aVar.lmO.setVisibility(0);
                        }
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.lmP.getLayoutParams();
                if (y.getItem(this.eOt, i) != null && ((UserData) y.getItem(this.eOt, i)).isLastNewFan) {
                    layoutParams.height = l.getDimens(this.lmI, R.dimen.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                    aVar.lmP.setVisibility(0);
                } else {
                    aVar.lmP.setVisibility(8);
                    layoutParams.height = l.getDimens(this.lmI, R.dimen.ds1);
                    layoutParams.setMargins(l.getDimens(this.lmI, R.dimen.ds34), 0, l.getDimens(this.lmI, R.dimen.ds34), 0);
                }
                aVar.lmP.setLayoutParams(layoutParams);
                aVar.mProgress = null;
            } else if (itemViewType == 2) {
                aVar.mTitle.setText(R.string.new_fans);
                aVar.mTitle.setVisibility(0);
            } else {
                aVar.mName.setText(this.lmI.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.lmI.getLayoutMode().setNightMode(skinType == 1);
        this.lmI.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.mTitle != null) {
                ap.setViewTextColor(aVar.mTitle, R.color.CAM_X0109);
                ap.setBackgroundColor(aVar.mTitle, R.color.CAM_X0205);
            }
            if (aVar.lmP != null) {
                ap.setImageResource(aVar.lmP, R.color.CAM_X0204);
            }
            if (aVar.lmO != null) {
                aVar.lmO.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.gZr) {
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
        if (this.gZr) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c akZ;
        TextView gFB;
        ViewGroup gFx;
        TextView gZv;
        LinearLayout haw;
        ClickableHeaderImageView lmM;
        View lmN;
        MyFansUserLikeButton lmO;
        ImageView lmP;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
