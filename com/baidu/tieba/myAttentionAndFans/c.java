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
    boolean eMo;
    private View.OnClickListener eNp;
    private PersonListActivity itc;
    private View.OnClickListener itd;
    private int mSex;

    public c(PersonListActivity personListActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.itc = null;
        this.eMo = true;
        this.mSex = 0;
        this.itd = null;
        this.eNp = null;
        this.itc = personListActivity;
        this.eMo = z;
        this.mSex = i;
        this.itd = onClickListener2;
        this.eNp = onClickListener;
        this.cWf = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(av avVar) {
        if (avVar != null && avVar.aBq() != null) {
            Iterator<UserData> it = avVar.aBq().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null) {
                    next.setIsLike(next.getHave_attention() > 0);
                }
            }
            ArrayList arrayList = new ArrayList();
            if (this.cWf == null) {
                this.cWf = new ArrayList<>();
            }
            arrayList.addAll(avVar.aBq());
            if (!v.isEmpty(this.cWf) && this.cWf.get(this.cWf.size() - 1) != null && this.cWf.get(this.cWf.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                this.cWf.get(this.cWf.size() - 1).isLastNewFan = true;
            } else {
                for (int i = 0; i < arrayList.size() - 1; i++) {
                    UserData userData = (UserData) arrayList.get(i);
                    UserData userData2 = (UserData) arrayList.get(i + 1);
                    if (userData != null && userData2 != null && userData.isNewFan && !userData2.isNewFan) {
                        userData.isLastNewFan = true;
                    }
                }
            }
            if (v.isEmpty(this.cWf) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                UserData userData3 = new UserData();
                userData3.mAttentionType = 0;
                arrayList.add(0, userData3);
            }
            this.cWf.addAll(arrayList);
        }
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean en(long j) {
        if (j == 0 || this.cWf == null || this.cWf.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.cWf.iterator();
        while (it.hasNext()) {
            UserData next = it.next();
            if (next != null && next.getUserIdLong() == j) {
                this.cWf.remove(next);
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eMm) {
            return 1;
        }
        int i = 0;
        if (this.cWf != null) {
            i = this.cWf.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cWf == null || i >= this.cWf.size()) {
            return null;
        }
        return this.cWf.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.cWf == null || i >= this.cWf.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final a aVar;
        View view2;
        if (this.cWf != null) {
            int itemViewType = getItemViewType(i);
            if (view == null || !(view.getTag() instanceof a)) {
                aVar = new a();
                if (itemViewType == 0) {
                    View inflate = LayoutInflater.from(this.itc.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar.exS = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar.exS.setOnClickListener(this.eNp);
                    aVar.itg = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar.itg.setRadius(l.getDimens(this.itc.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar.itg.setAutoChangeStyle(true);
                    aVar.itg.setClickable(false);
                    ((LinearLayout.LayoutParams) aVar.itg.getLayoutParams()).setMargins(l.getDimens(this.itc, R.dimen.ds34), 0, 0, 0);
                    aVar.eNs = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar.mName.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.myAttentionAndFans.c.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            Layout layout = aVar.mName.getLayout();
                            if (layout != null) {
                                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                                    aVar.mName.setCompoundDrawablePadding(l.getDimens(c.this.itc, R.dimen.tbds10));
                                } else {
                                    aVar.mName.setCompoundDrawablePadding(0);
                                }
                            }
                        }
                    });
                    aVar.ith = com.baidu.tbadk.ala.b.ayE().u(this.itc.getPageContext().getPageActivity(), 5);
                    if (aVar.ith != null) {
                        aVar.ith.setVisibility(8);
                        aVar.mContainer.addView(aVar.ith, 1);
                    }
                    aVar.eMq = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar.exW = (TextView) inflate.findViewById(R.id.intro);
                    aVar.iti = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar.iti.setContext(this.itc.getPageContext());
                    ((LinearLayout.LayoutParams) aVar.iti.getLayoutParams()).setMargins(0, 0, l.getDimens(this.itc, R.dimen.ds34), 0);
                    aVar.NC = new com.baidu.tbadk.core.view.userLike.c(this.itc.getPageContext(), aVar.iti);
                    aVar.NC.a((com.baidu.tbadk.core.view.userLike.a) v.getItem(this.cWf, i));
                    aVar.NC.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.c.2
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void fW(boolean z) {
                            if (z) {
                                l.showToast(c.this.itc, (int) R.string.attention_success);
                            } else {
                                l.showToast(c.this.itc, (int) R.string.unfollow_success);
                            }
                        }
                    });
                    aVar.mProgress = null;
                    aVar.mTitle = null;
                    aVar.itj = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    view2 = inflate;
                } else if (itemViewType == 2) {
                    View inflate2 = LayoutInflater.from(this.itc.getPageContext().getPageActivity()).inflate(R.layout.my_fan_list_title, (ViewGroup) null);
                    aVar.mTitle = (TextView) inflate2.findViewById(R.id.my_new_fan_title);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.itc.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.itd);
                    aVar.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar.mTitle = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar);
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.iti != null) {
                aVar.iti.setTag(Integer.valueOf(i));
            }
            if (itemViewType == 0) {
                if (this.eMm) {
                    aVar.eNs.setVisibility(8);
                    aVar.eMq.setVisibility(0);
                    if (this.eMo) {
                        aVar.eMq.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.eMq.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.eMq.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.eMq.setText(R.string.no_fan_other);
                    }
                } else {
                    aVar.exS.setTag(Integer.valueOf(i));
                    UserData userData = (UserData) v.getItem(this.cWf, i);
                    if (userData != null) {
                        aVar.eMq.setVisibility(8);
                        UtilHelper.showHeadImageViewBigV(aVar.itg, userData, 0);
                        aVar.mName.setText(UtilHelper.getUserName(userData));
                        aVar.itg.setPlaceHolder(1);
                        aVar.itg.startLoad(userData.getAvater(), 12, false);
                        if (aVar.ith != null && userData.getAlaUserData() != null) {
                            if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                                aVar.ith.setVisibility(8);
                            } else {
                                aVar.ith.setVisibility(0);
                                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                                aVar2.cKd = userData.getAlaUserData();
                                aVar2.type = 5;
                                aVar.ith.setTag(aVar2);
                            }
                        }
                        if (aq.isEmpty(userData.getIntro())) {
                            aVar.exW.setVisibility(8);
                        } else {
                            aVar.exW.setVisibility(0);
                            aVar.exW.setText(userData.getIntro());
                        }
                        String userId = userData.getUserId();
                        userData.setIsLike(userData.getHave_attention() > 0);
                        aVar.NC.a(userData);
                        if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            aVar.iti.setVisibility(8);
                        } else {
                            aVar.iti.setStatsParams(2, userId);
                            aVar.NC.sE("9");
                            aVar.iti.setVisibility(0);
                        }
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.itj.getLayoutParams();
                if (v.getItem(this.cWf, i) != null && ((UserData) v.getItem(this.cWf, i)).isLastNewFan) {
                    layoutParams.height = l.getDimens(this.itc, R.dimen.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                    aVar.itj.setVisibility(0);
                } else {
                    aVar.itj.setVisibility(8);
                    layoutParams.height = l.getDimens(this.itc, R.dimen.ds1);
                    layoutParams.setMargins(l.getDimens(this.itc, R.dimen.ds34), 0, l.getDimens(this.itc, R.dimen.ds34), 0);
                }
                aVar.itj.setLayoutParams(layoutParams);
                aVar.mProgress = null;
            } else if (itemViewType == 2) {
                aVar.mTitle.setText(R.string.new_fans);
                aVar.mTitle.setVisibility(0);
            } else {
                aVar.mName.setText(this.itc.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.itc.getLayoutMode().setNightMode(skinType == 1);
        this.itc.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.mTitle != null) {
                am.setViewTextColor(aVar.mTitle, (int) R.color.cp_cont_d);
                am.setBackgroundColor(aVar.mTitle, R.color.cp_bg_line_e);
            }
            if (aVar.itj != null) {
                am.setImageResource(aVar.itj, R.color.cp_bg_line_c);
            }
            if (aVar.iti != null) {
                aVar.iti.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.eMm) {
            return 0;
        }
        if (this.cWf == null || i >= this.cWf.size()) {
            return 1;
        }
        return this.cWf.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.eMm) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c NC;
        TextView eMq;
        LinearLayout eNs;
        ViewGroup exS;
        TextView exW;
        ClickableHeaderImageView itg;
        View ith;
        MyFansUserLikeButton iti;
        ImageView itj;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
