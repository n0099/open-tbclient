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
/* loaded from: classes8.dex */
public class c extends b {
    boolean hkR;
    private View.OnClickListener hlQ;
    private PersonListActivity lvx;
    private View.OnClickListener lvy;
    private int mSex;

    public c(PersonListActivity personListActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.lvx = null;
        this.hkR = true;
        this.mSex = 0;
        this.lvy = null;
        this.hlQ = null;
        this.lvx = personListActivity;
        this.hkR = z;
        this.mSex = i;
        this.lvy = onClickListener2;
        this.hlQ = onClickListener;
        this.eVV = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(bg bgVar) {
        if (bgVar != null && bgVar.bmI() != null) {
            Iterator<UserData> it = bgVar.bmI().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null) {
                    next.setIsLike(next.getHave_attention() > 0);
                }
            }
            ArrayList arrayList = new ArrayList();
            if (this.eVV == null) {
                this.eVV = new ArrayList<>();
            }
            arrayList.addAll(bgVar.bmI());
            if (!y.isEmpty(this.eVV) && this.eVV.get(this.eVV.size() - 1) != null && this.eVV.get(this.eVV.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                this.eVV.get(this.eVV.size() - 1).isLastNewFan = true;
            } else {
                for (int i = 0; i < arrayList.size() - 1; i++) {
                    UserData userData = (UserData) arrayList.get(i);
                    UserData userData2 = (UserData) arrayList.get(i + 1);
                    if (userData != null && userData2 != null && userData.isNewFan && !userData2.isNewFan) {
                        userData.isLastNewFan = true;
                    }
                }
            }
            if (y.isEmpty(this.eVV) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                UserData userData3 = new UserData();
                userData3.mAttentionType = 0;
                arrayList.add(0, userData3);
            }
            this.eVV.addAll(arrayList);
        }
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean hm(long j) {
        if (j == 0 || this.eVV == null || this.eVV.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.eVV.iterator();
        while (it.hasNext()) {
            UserData next = it.next();
            if (next != null && next.getUserIdLong() == j) {
                this.eVV.remove(next);
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hkP) {
            return 1;
        }
        int i = 0;
        if (this.eVV != null) {
            i = this.eVV.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eVV == null || i >= this.eVV.size()) {
            return null;
        }
        return this.eVV.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.eVV == null || i >= this.eVV.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final a aVar;
        View view2;
        if (this.eVV != null) {
            int itemViewType = getItemViewType(i);
            if (view == null || !(view.getTag() instanceof a)) {
                aVar = new a();
                if (itemViewType == 0) {
                    View inflate = LayoutInflater.from(this.lvx.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar.gPi = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar.gPi.setOnClickListener(this.hlQ);
                    aVar.lvB = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar.lvB.setRadius(l.getDimens(this.lvx.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar.lvB.setAutoChangeStyle(true);
                    aVar.lvB.setClickable(false);
                    ((LinearLayout.LayoutParams) aVar.lvB.getLayoutParams()).setMargins(l.getDimens(this.lvx, R.dimen.ds34), 0, 0, 0);
                    aVar.hlT = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar.mName.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.myAttentionAndFans.c.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            Layout layout = aVar.mName.getLayout();
                            if (layout != null) {
                                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                                    aVar.mName.setCompoundDrawablePadding(l.getDimens(c.this.lvx, R.dimen.tbds10));
                                } else {
                                    aVar.mName.setCompoundDrawablePadding(0);
                                }
                            }
                        }
                    });
                    aVar.lvC = com.baidu.tbadk.ala.b.bjQ().A(this.lvx.getPageContext().getPageActivity(), 5);
                    if (aVar.lvC != null) {
                        aVar.lvC.setVisibility(8);
                        aVar.mContainer.addView(aVar.lvC, 1);
                    }
                    aVar.hkT = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar.gPm = (TextView) inflate.findViewById(R.id.intro);
                    aVar.lvD = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar.lvD.setContext(this.lvx.getPageContext());
                    ((LinearLayout.LayoutParams) aVar.lvD.getLayoutParams()).setMargins(0, 0, l.getDimens(this.lvx, R.dimen.ds34), 0);
                    aVar.akz = new com.baidu.tbadk.core.view.userLike.c(this.lvx.getPageContext(), aVar.lvD);
                    aVar.akz.a((com.baidu.tbadk.core.view.userLike.a) y.getItem(this.eVV, i));
                    aVar.akz.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.c.2
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void kh(boolean z) {
                            if (z) {
                                l.showToast(c.this.lvx, R.string.attention_success);
                            } else {
                                l.showToast(c.this.lvx, R.string.unfollow_success);
                            }
                        }
                    });
                    aVar.mProgress = null;
                    aVar.mTitle = null;
                    aVar.lvE = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    view2 = inflate;
                } else if (itemViewType == 2) {
                    View inflate2 = LayoutInflater.from(this.lvx.getPageContext().getPageActivity()).inflate(R.layout.my_fan_list_title, (ViewGroup) null);
                    aVar.mTitle = (TextView) inflate2.findViewById(R.id.my_new_fan_title);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.lvx.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.lvy);
                    aVar.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar.mTitle = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar);
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.lvD != null) {
                aVar.lvD.setTag(Integer.valueOf(i));
            }
            if (itemViewType == 0) {
                if (this.hkP) {
                    aVar.hlT.setVisibility(8);
                    aVar.hkT.setVisibility(0);
                    if (this.hkR) {
                        aVar.hkT.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.hkT.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.hkT.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.hkT.setText(R.string.no_fan_other);
                    }
                } else {
                    aVar.gPi.setTag(Integer.valueOf(i));
                    UserData userData = (UserData) y.getItem(this.eVV, i);
                    if (userData != null) {
                        aVar.hkT.setVisibility(8);
                        UtilHelper.showHeadImageViewBigV(aVar.lvB, userData, 0);
                        aVar.mName.setText(UtilHelper.getUserName(userData));
                        aVar.lvB.setPlaceHolder(1);
                        aVar.lvB.startLoad(userData.getAvater(), 12, false);
                        if (aVar.lvC != null && userData.getAlaUserData() != null) {
                            if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                                aVar.lvC.setVisibility(8);
                            } else {
                                aVar.lvC.setVisibility(0);
                                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                                aVar2.eGA = userData.getAlaUserData();
                                aVar2.type = 5;
                                aVar.lvC.setTag(aVar2);
                            }
                        }
                        if (au.isEmpty(userData.getIntro())) {
                            aVar.gPm.setVisibility(8);
                        } else {
                            aVar.gPm.setVisibility(0);
                            aVar.gPm.setText(userData.getIntro());
                        }
                        String userId = userData.getUserId();
                        userData.setIsLike(userData.getHave_attention() > 0);
                        aVar.akz.a(userData);
                        if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            aVar.lvD.setVisibility(8);
                        } else {
                            aVar.lvD.setStatsParams(2, userId);
                            aVar.akz.Ag("9");
                            aVar.lvD.setVisibility(0);
                        }
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.lvE.getLayoutParams();
                if (y.getItem(this.eVV, i) != null && ((UserData) y.getItem(this.eVV, i)).isLastNewFan) {
                    layoutParams.height = l.getDimens(this.lvx, R.dimen.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                    aVar.lvE.setVisibility(0);
                } else {
                    aVar.lvE.setVisibility(8);
                    layoutParams.height = l.getDimens(this.lvx, R.dimen.ds1);
                    layoutParams.setMargins(l.getDimens(this.lvx, R.dimen.ds34), 0, l.getDimens(this.lvx, R.dimen.ds34), 0);
                }
                aVar.lvE.setLayoutParams(layoutParams);
                aVar.mProgress = null;
            } else if (itemViewType == 2) {
                aVar.mTitle.setText(R.string.new_fans);
                aVar.mTitle.setVisibility(0);
            } else {
                aVar.mName.setText(this.lvx.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.lvx.getLayoutMode().setNightMode(skinType == 1);
        this.lvx.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.mTitle != null) {
                ap.setViewTextColor(aVar.mTitle, R.color.CAM_X0109);
                ap.setBackgroundColor(aVar.mTitle, R.color.CAM_X0205);
            }
            if (aVar.lvE != null) {
                ap.setImageResource(aVar.lvE, R.color.CAM_X0204);
            }
            if (aVar.lvD != null) {
                aVar.lvD.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.hkP) {
            return 0;
        }
        if (this.eVV == null || i >= this.eVV.size()) {
            return 1;
        }
        return this.eVV.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.hkP) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c akz;
        ViewGroup gPi;
        TextView gPm;
        TextView hkT;
        LinearLayout hlT;
        ClickableHeaderImageView lvB;
        View lvC;
        MyFansUserLikeButton lvD;
        ImageView lvE;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
