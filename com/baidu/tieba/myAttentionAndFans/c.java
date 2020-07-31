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
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes17.dex */
public class c extends b {
    boolean fVs;
    private View.OnClickListener fWt;
    private PersonListActivity jTj;
    private View.OnClickListener jTk;
    private int mSex;

    public c(PersonListActivity personListActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.jTj = null;
        this.fVs = true;
        this.mSex = 0;
        this.jTk = null;
        this.fWt = null;
        this.jTj = personListActivity;
        this.fVs = z;
        this.mSex = i;
        this.jTk = onClickListener2;
        this.fWt = onClickListener;
        this.dWx = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(bb bbVar) {
        if (bbVar != null && bbVar.aVe() != null) {
            Iterator<UserData> it = bbVar.aVe().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null) {
                    next.setIsLike(next.getHave_attention() > 0);
                }
            }
            ArrayList arrayList = new ArrayList();
            if (this.dWx == null) {
                this.dWx = new ArrayList<>();
            }
            arrayList.addAll(bbVar.aVe());
            if (!x.isEmpty(this.dWx) && this.dWx.get(this.dWx.size() - 1) != null && this.dWx.get(this.dWx.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                this.dWx.get(this.dWx.size() - 1).isLastNewFan = true;
            } else {
                for (int i = 0; i < arrayList.size() - 1; i++) {
                    UserData userData = (UserData) arrayList.get(i);
                    UserData userData2 = (UserData) arrayList.get(i + 1);
                    if (userData != null && userData2 != null && userData.isNewFan && !userData2.isNewFan) {
                        userData.isLastNewFan = true;
                    }
                }
            }
            if (x.isEmpty(this.dWx) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                UserData userData3 = new UserData();
                userData3.mAttentionType = 0;
                arrayList.add(0, userData3);
            }
            this.dWx.addAll(arrayList);
        }
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean fp(long j) {
        if (j == 0 || this.dWx == null || this.dWx.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.dWx.iterator();
        while (it.hasNext()) {
            UserData next = it.next();
            if (next != null && next.getUserIdLong() == j) {
                this.dWx.remove(next);
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fVq) {
            return 1;
        }
        int i = 0;
        if (this.dWx != null) {
            i = this.dWx.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dWx == null || i >= this.dWx.size()) {
            return null;
        }
        return this.dWx.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.dWx == null || i >= this.dWx.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final a aVar;
        View view2;
        if (this.dWx != null) {
            int itemViewType = getItemViewType(i);
            if (view == null || !(view.getTag() instanceof a)) {
                aVar = new a();
                if (itemViewType == 0) {
                    View inflate = LayoutInflater.from(this.jTj.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar.fGn = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar.fGn.setOnClickListener(this.fWt);
                    aVar.jTn = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar.jTn.setRadius(l.getDimens(this.jTj.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar.jTn.setAutoChangeStyle(true);
                    aVar.jTn.setClickable(false);
                    ((LinearLayout.LayoutParams) aVar.jTn.getLayoutParams()).setMargins(l.getDimens(this.jTj, R.dimen.ds34), 0, 0, 0);
                    aVar.fWw = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar.mName.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.myAttentionAndFans.c.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            Layout layout = aVar.mName.getLayout();
                            if (layout != null) {
                                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                                    aVar.mName.setCompoundDrawablePadding(l.getDimens(c.this.jTj, R.dimen.tbds10));
                                } else {
                                    aVar.mName.setCompoundDrawablePadding(0);
                                }
                            }
                        }
                    });
                    aVar.jTo = com.baidu.tbadk.ala.b.aSa().p(this.jTj.getPageContext().getPageActivity(), 5);
                    if (aVar.jTo != null) {
                        aVar.jTo.setVisibility(8);
                        aVar.mContainer.addView(aVar.jTo, 1);
                    }
                    aVar.fVu = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar.fGr = (TextView) inflate.findViewById(R.id.intro);
                    aVar.jTp = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar.jTp.setContext(this.jTj.getPageContext());
                    ((LinearLayout.LayoutParams) aVar.jTp.getLayoutParams()).setMargins(0, 0, l.getDimens(this.jTj, R.dimen.ds34), 0);
                    aVar.ahO = new com.baidu.tbadk.core.view.userLike.c(this.jTj.getPageContext(), aVar.jTp);
                    aVar.ahO.a((com.baidu.tbadk.core.view.userLike.a) x.getItem(this.dWx, i));
                    aVar.ahO.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.c.2
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        /* renamed from: if */
                        public void mo32if(boolean z) {
                            if (z) {
                                l.showToast(c.this.jTj, R.string.attention_success);
                            } else {
                                l.showToast(c.this.jTj, R.string.unfollow_success);
                            }
                        }
                    });
                    aVar.mProgress = null;
                    aVar.mTitle = null;
                    aVar.jTq = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    view2 = inflate;
                } else if (itemViewType == 2) {
                    View inflate2 = LayoutInflater.from(this.jTj.getPageContext().getPageActivity()).inflate(R.layout.my_fan_list_title, (ViewGroup) null);
                    aVar.mTitle = (TextView) inflate2.findViewById(R.id.my_new_fan_title);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.jTj.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.jTk);
                    aVar.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar.mTitle = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar);
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.jTp != null) {
                aVar.jTp.setTag(Integer.valueOf(i));
            }
            if (itemViewType == 0) {
                if (this.fVq) {
                    aVar.fWw.setVisibility(8);
                    aVar.fVu.setVisibility(0);
                    if (this.fVs) {
                        aVar.fVu.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.fVu.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.fVu.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.fVu.setText(R.string.no_fan_other);
                    }
                } else {
                    aVar.fGn.setTag(Integer.valueOf(i));
                    UserData userData = (UserData) x.getItem(this.dWx, i);
                    if (userData != null) {
                        aVar.fVu.setVisibility(8);
                        UtilHelper.showHeadImageViewBigV(aVar.jTn, userData, 0);
                        aVar.mName.setText(UtilHelper.getUserName(userData));
                        aVar.jTn.setPlaceHolder(1);
                        aVar.jTn.startLoad(userData.getAvater(), 12, false);
                        if (aVar.jTo != null && userData.getAlaUserData() != null) {
                            if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                                aVar.jTo.setVisibility(8);
                            } else {
                                aVar.jTo.setVisibility(0);
                                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                                aVar2.dIq = userData.getAlaUserData();
                                aVar2.type = 5;
                                aVar.jTo.setTag(aVar2);
                            }
                        }
                        if (as.isEmpty(userData.getIntro())) {
                            aVar.fGr.setVisibility(8);
                        } else {
                            aVar.fGr.setVisibility(0);
                            aVar.fGr.setText(userData.getIntro());
                        }
                        String userId = userData.getUserId();
                        userData.setIsLike(userData.getHave_attention() > 0);
                        aVar.ahO.a(userData);
                        if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            aVar.jTp.setVisibility(8);
                        } else {
                            aVar.jTp.setStatsParams(2, userId);
                            aVar.ahO.wX("9");
                            aVar.jTp.setVisibility(0);
                        }
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.jTq.getLayoutParams();
                if (x.getItem(this.dWx, i) != null && ((UserData) x.getItem(this.dWx, i)).isLastNewFan) {
                    layoutParams.height = l.getDimens(this.jTj, R.dimen.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                    aVar.jTq.setVisibility(0);
                } else {
                    aVar.jTq.setVisibility(8);
                    layoutParams.height = l.getDimens(this.jTj, R.dimen.ds1);
                    layoutParams.setMargins(l.getDimens(this.jTj, R.dimen.ds34), 0, l.getDimens(this.jTj, R.dimen.ds34), 0);
                }
                aVar.jTq.setLayoutParams(layoutParams);
                aVar.mProgress = null;
            } else if (itemViewType == 2) {
                aVar.mTitle.setText(R.string.new_fans);
                aVar.mTitle.setVisibility(0);
            } else {
                aVar.mName.setText(this.jTj.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.jTj.getLayoutMode().setNightMode(skinType == 1);
        this.jTj.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.mTitle != null) {
                ao.setViewTextColor(aVar.mTitle, R.color.cp_cont_d);
                ao.setBackgroundColor(aVar.mTitle, R.color.cp_bg_line_e);
            }
            if (aVar.jTq != null) {
                ao.setImageResource(aVar.jTq, R.color.cp_bg_line_c);
            }
            if (aVar.jTp != null) {
                aVar.jTp.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fVq) {
            return 0;
        }
        if (this.dWx == null || i >= this.dWx.size()) {
            return 1;
        }
        return this.dWx.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fVq) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c ahO;
        ViewGroup fGn;
        TextView fGr;
        TextView fVu;
        LinearLayout fWw;
        ClickableHeaderImageView jTn;
        View jTo;
        MyFansUserLikeButton jTp;
        ImageView jTq;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
