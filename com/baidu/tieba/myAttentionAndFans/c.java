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
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes10.dex */
public class c extends b {
    boolean eLS;
    private View.OnClickListener eMT;
    private PersonListActivity irC;
    private View.OnClickListener irD;
    private int mSex;

    public c(PersonListActivity personListActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.irC = null;
        this.eLS = true;
        this.mSex = 0;
        this.irD = null;
        this.eMT = null;
        this.irC = personListActivity;
        this.eLS = z;
        this.mSex = i;
        this.irD = onClickListener2;
        this.eMT = onClickListener;
        this.cVS = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(av avVar) {
        if (avVar != null && avVar.aBn() != null) {
            Iterator<UserData> it = avVar.aBn().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null) {
                    next.setIsLike(next.getHave_attention() > 0);
                }
            }
            ArrayList arrayList = new ArrayList();
            if (this.cVS == null) {
                this.cVS = new ArrayList<>();
            }
            arrayList.addAll(avVar.aBn());
            if (!v.isEmpty(this.cVS) && this.cVS.get(this.cVS.size() - 1) != null && this.cVS.get(this.cVS.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                this.cVS.get(this.cVS.size() - 1).isLastNewFan = true;
            } else {
                for (int i = 0; i < arrayList.size() - 1; i++) {
                    UserData userData = (UserData) arrayList.get(i);
                    UserData userData2 = (UserData) arrayList.get(i + 1);
                    if (userData != null && userData2 != null && userData.isNewFan && !userData2.isNewFan) {
                        userData.isLastNewFan = true;
                    }
                }
            }
            if (v.isEmpty(this.cVS) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                UserData userData3 = new UserData();
                userData3.mAttentionType = 0;
                arrayList.add(0, userData3);
            }
            this.cVS.addAll(arrayList);
        }
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean em(long j) {
        if (j == 0 || this.cVS == null || this.cVS.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.cVS.iterator();
        while (it.hasNext()) {
            UserData next = it.next();
            if (next != null && next.getUserIdLong() == j) {
                this.cVS.remove(next);
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eLQ) {
            return 1;
        }
        int i = 0;
        if (this.cVS != null) {
            i = this.cVS.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cVS == null || i >= this.cVS.size()) {
            return null;
        }
        return this.cVS.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.cVS == null || i >= this.cVS.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final a aVar;
        View view2;
        if (this.cVS != null) {
            int itemViewType = getItemViewType(i);
            if (view == null || !(view.getTag() instanceof a)) {
                aVar = new a();
                if (itemViewType == 0) {
                    View inflate = LayoutInflater.from(this.irC.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar.exw = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar.exw.setOnClickListener(this.eMT);
                    aVar.irG = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar.irG.setRadius(l.getDimens(this.irC.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar.irG.setAutoChangeStyle(true);
                    aVar.irG.setClickable(false);
                    ((LinearLayout.LayoutParams) aVar.irG.getLayoutParams()).setMargins(l.getDimens(this.irC, R.dimen.ds34), 0, 0, 0);
                    aVar.eMW = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar.mName.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.myAttentionAndFans.c.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            Layout layout = aVar.mName.getLayout();
                            if (layout != null) {
                                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                                    aVar.mName.setCompoundDrawablePadding(l.getDimens(c.this.irC, R.dimen.tbds10));
                                } else {
                                    aVar.mName.setCompoundDrawablePadding(0);
                                }
                            }
                        }
                    });
                    aVar.irH = com.baidu.tbadk.ala.b.ayB().u(this.irC.getPageContext().getPageActivity(), 5);
                    if (aVar.irH != null) {
                        aVar.irH.setVisibility(8);
                        aVar.mContainer.addView(aVar.irH, 1);
                    }
                    aVar.eLU = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar.exA = (TextView) inflate.findViewById(R.id.intro);
                    aVar.irI = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar.irI.setContext(this.irC.getPageContext());
                    ((LinearLayout.LayoutParams) aVar.irI.getLayoutParams()).setMargins(0, 0, l.getDimens(this.irC, R.dimen.ds34), 0);
                    aVar.NB = new com.baidu.tbadk.core.view.userLike.c(this.irC.getPageContext(), aVar.irI);
                    aVar.NB.a((com.baidu.tbadk.core.view.userLike.a) v.getItem(this.cVS, i));
                    aVar.NB.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.c.2
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void fV(boolean z) {
                            if (z) {
                                l.showToast(c.this.irC, (int) R.string.attention_success);
                            } else {
                                l.showToast(c.this.irC, (int) R.string.unfollow_success);
                            }
                        }
                    });
                    aVar.mProgress = null;
                    aVar.mTitle = null;
                    aVar.irJ = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    view2 = inflate;
                } else if (itemViewType == 2) {
                    View inflate2 = LayoutInflater.from(this.irC.getPageContext().getPageActivity()).inflate(R.layout.my_fan_list_title, (ViewGroup) null);
                    aVar.mTitle = (TextView) inflate2.findViewById(R.id.my_new_fan_title);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.irC.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.irD);
                    aVar.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar.mTitle = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar);
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.irI != null) {
                aVar.irI.setTag(Integer.valueOf(i));
            }
            if (itemViewType == 0) {
                if (this.eLQ) {
                    aVar.eMW.setVisibility(8);
                    aVar.eLU.setVisibility(0);
                    if (this.eLS) {
                        aVar.eLU.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.eLU.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.eLU.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.eLU.setText(R.string.no_fan_other);
                    }
                } else {
                    aVar.exw.setTag(Integer.valueOf(i));
                    UserData userData = (UserData) v.getItem(this.cVS, i);
                    if (userData != null) {
                        aVar.eLU.setVisibility(8);
                        UtilHelper.showHeadImageViewBigV(aVar.irG, userData, 0);
                        aVar.mName.setText(UtilHelper.getUserName(userData));
                        aVar.irG.setPlaceHolder(1);
                        aVar.irG.startLoad(userData.getAvater(), 12, false);
                        if (aVar.irH != null && userData.getAlaUserData() != null) {
                            if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                                aVar.irH.setVisibility(8);
                            } else {
                                aVar.irH.setVisibility(0);
                                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                                aVar2.cJS = userData.getAlaUserData();
                                aVar2.type = 5;
                                aVar.irH.setTag(aVar2);
                            }
                        }
                        if (aq.isEmpty(userData.getIntro())) {
                            aVar.exA.setVisibility(8);
                        } else {
                            aVar.exA.setVisibility(0);
                            aVar.exA.setText(userData.getIntro());
                        }
                        String userId = userData.getUserId();
                        userData.setIsLike(userData.getHave_attention() > 0);
                        aVar.NB.a(userData);
                        if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            aVar.irI.setVisibility(8);
                        } else {
                            aVar.irI.setStatsParams(2, userId);
                            aVar.NB.sE("9");
                            aVar.irI.setVisibility(0);
                        }
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.irJ.getLayoutParams();
                if (v.getItem(this.cVS, i) != null && ((UserData) v.getItem(this.cVS, i)).isLastNewFan) {
                    layoutParams.height = l.getDimens(this.irC, R.dimen.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                    aVar.irJ.setVisibility(0);
                } else {
                    aVar.irJ.setVisibility(8);
                    layoutParams.height = l.getDimens(this.irC, R.dimen.ds1);
                    layoutParams.setMargins(l.getDimens(this.irC, R.dimen.ds34), 0, l.getDimens(this.irC, R.dimen.ds34), 0);
                }
                aVar.irJ.setLayoutParams(layoutParams);
                aVar.mProgress = null;
            } else if (itemViewType == 2) {
                aVar.mTitle.setText(R.string.new_fans);
                aVar.mTitle.setVisibility(0);
            } else {
                aVar.mName.setText(this.irC.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.irC.getLayoutMode().setNightMode(skinType == 1);
        this.irC.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.mTitle != null) {
                am.setViewTextColor(aVar.mTitle, (int) R.color.cp_cont_d);
                am.setBackgroundColor(aVar.mTitle, R.color.cp_bg_line_e);
            }
            if (aVar.irJ != null) {
                am.setImageResource(aVar.irJ, R.color.cp_bg_line_c);
            }
            if (aVar.irI != null) {
                aVar.irI.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.eLQ) {
            return 0;
        }
        if (this.cVS == null || i >= this.cVS.size()) {
            return 1;
        }
        return this.cVS.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.eLQ) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c NB;
        TextView eLU;
        LinearLayout eMW;
        TextView exA;
        ViewGroup exw;
        ClickableHeaderImageView irG;
        View irH;
        MyFansUserLikeButton irI;
        ImageView irJ;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
