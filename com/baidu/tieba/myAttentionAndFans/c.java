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
import com.baidu.tbadk.core.data.ba;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes10.dex */
public class c extends b {
    boolean fPZ;
    private View.OnClickListener fRa;
    private PersonListActivity jKL;
    private View.OnClickListener jKM;
    private int mSex;

    public c(PersonListActivity personListActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.jKL = null;
        this.fPZ = true;
        this.mSex = 0;
        this.jKM = null;
        this.fRa = null;
        this.jKL = personListActivity;
        this.fPZ = z;
        this.mSex = i;
        this.jKM = onClickListener2;
        this.fRa = onClickListener;
        this.dQf = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(ba baVar) {
        if (baVar != null && baVar.aRi() != null) {
            Iterator<UserData> it = baVar.aRi().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null) {
                    next.setIsLike(next.getHave_attention() > 0);
                }
            }
            ArrayList arrayList = new ArrayList();
            if (this.dQf == null) {
                this.dQf = new ArrayList<>();
            }
            arrayList.addAll(baVar.aRi());
            if (!w.isEmpty(this.dQf) && this.dQf.get(this.dQf.size() - 1) != null && this.dQf.get(this.dQf.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                this.dQf.get(this.dQf.size() - 1).isLastNewFan = true;
            } else {
                for (int i = 0; i < arrayList.size() - 1; i++) {
                    UserData userData = (UserData) arrayList.get(i);
                    UserData userData2 = (UserData) arrayList.get(i + 1);
                    if (userData != null && userData2 != null && userData.isNewFan && !userData2.isNewFan) {
                        userData.isLastNewFan = true;
                    }
                }
            }
            if (w.isEmpty(this.dQf) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                UserData userData3 = new UserData();
                userData3.mAttentionType = 0;
                arrayList.add(0, userData3);
            }
            this.dQf.addAll(arrayList);
        }
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean fb(long j) {
        if (j == 0 || this.dQf == null || this.dQf.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.dQf.iterator();
        while (it.hasNext()) {
            UserData next = it.next();
            if (next != null && next.getUserIdLong() == j) {
                this.dQf.remove(next);
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fPX) {
            return 1;
        }
        int i = 0;
        if (this.dQf != null) {
            i = this.dQf.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dQf == null || i >= this.dQf.size()) {
            return null;
        }
        return this.dQf.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.dQf == null || i >= this.dQf.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final a aVar;
        View view2;
        if (this.dQf != null) {
            int itemViewType = getItemViewType(i);
            if (view == null || !(view.getTag() instanceof a)) {
                aVar = new a();
                if (itemViewType == 0) {
                    View inflate = LayoutInflater.from(this.jKL.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar.fBd = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar.fBd.setOnClickListener(this.fRa);
                    aVar.jKP = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar.jKP.setRadius(l.getDimens(this.jKL.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar.jKP.setAutoChangeStyle(true);
                    aVar.jKP.setClickable(false);
                    ((LinearLayout.LayoutParams) aVar.jKP.getLayoutParams()).setMargins(l.getDimens(this.jKL, R.dimen.ds34), 0, 0, 0);
                    aVar.fRd = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar.mName.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.myAttentionAndFans.c.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            Layout layout = aVar.mName.getLayout();
                            if (layout != null) {
                                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                                    aVar.mName.setCompoundDrawablePadding(l.getDimens(c.this.jKL, R.dimen.tbds10));
                                } else {
                                    aVar.mName.setCompoundDrawablePadding(0);
                                }
                            }
                        }
                    });
                    aVar.jKQ = com.baidu.tbadk.ala.b.aOf().p(this.jKL.getPageContext().getPageActivity(), 5);
                    if (aVar.jKQ != null) {
                        aVar.jKQ.setVisibility(8);
                        aVar.mContainer.addView(aVar.jKQ, 1);
                    }
                    aVar.fQb = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar.fBh = (TextView) inflate.findViewById(R.id.intro);
                    aVar.jKR = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar.jKR.setContext(this.jKL.getPageContext());
                    ((LinearLayout.LayoutParams) aVar.jKR.getLayoutParams()).setMargins(0, 0, l.getDimens(this.jKL, R.dimen.ds34), 0);
                    aVar.ahX = new com.baidu.tbadk.core.view.userLike.c(this.jKL.getPageContext(), aVar.jKR);
                    aVar.ahX.a((com.baidu.tbadk.core.view.userLike.a) w.getItem(this.dQf, i));
                    aVar.ahX.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.c.2
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void hB(boolean z) {
                            if (z) {
                                l.showToast(c.this.jKL, (int) R.string.attention_success);
                            } else {
                                l.showToast(c.this.jKL, (int) R.string.unfollow_success);
                            }
                        }
                    });
                    aVar.mProgress = null;
                    aVar.mTitle = null;
                    aVar.jKS = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    view2 = inflate;
                } else if (itemViewType == 2) {
                    View inflate2 = LayoutInflater.from(this.jKL.getPageContext().getPageActivity()).inflate(R.layout.my_fan_list_title, (ViewGroup) null);
                    aVar.mTitle = (TextView) inflate2.findViewById(R.id.my_new_fan_title);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.jKL.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.jKM);
                    aVar.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar.mTitle = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar);
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.jKR != null) {
                aVar.jKR.setTag(Integer.valueOf(i));
            }
            if (itemViewType == 0) {
                if (this.fPX) {
                    aVar.fRd.setVisibility(8);
                    aVar.fQb.setVisibility(0);
                    if (this.fPZ) {
                        aVar.fQb.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.fQb.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.fQb.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.fQb.setText(R.string.no_fan_other);
                    }
                } else {
                    aVar.fBd.setTag(Integer.valueOf(i));
                    UserData userData = (UserData) w.getItem(this.dQf, i);
                    if (userData != null) {
                        aVar.fQb.setVisibility(8);
                        UtilHelper.showHeadImageViewBigV(aVar.jKP, userData, 0);
                        aVar.mName.setText(UtilHelper.getUserName(userData));
                        aVar.jKP.setPlaceHolder(1);
                        aVar.jKP.startLoad(userData.getAvater(), 12, false);
                        if (aVar.jKQ != null && userData.getAlaUserData() != null) {
                            if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                                aVar.jKQ.setVisibility(8);
                            } else {
                                aVar.jKQ.setVisibility(0);
                                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                                aVar2.dCt = userData.getAlaUserData();
                                aVar2.type = 5;
                                aVar.jKQ.setTag(aVar2);
                            }
                        }
                        if (ar.isEmpty(userData.getIntro())) {
                            aVar.fBh.setVisibility(8);
                        } else {
                            aVar.fBh.setVisibility(0);
                            aVar.fBh.setText(userData.getIntro());
                        }
                        String userId = userData.getUserId();
                        userData.setIsLike(userData.getHave_attention() > 0);
                        aVar.ahX.a(userData);
                        if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            aVar.jKR.setVisibility(8);
                        } else {
                            aVar.jKR.setStatsParams(2, userId);
                            aVar.ahX.vQ("9");
                            aVar.jKR.setVisibility(0);
                        }
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.jKS.getLayoutParams();
                if (w.getItem(this.dQf, i) != null && ((UserData) w.getItem(this.dQf, i)).isLastNewFan) {
                    layoutParams.height = l.getDimens(this.jKL, R.dimen.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                    aVar.jKS.setVisibility(0);
                } else {
                    aVar.jKS.setVisibility(8);
                    layoutParams.height = l.getDimens(this.jKL, R.dimen.ds1);
                    layoutParams.setMargins(l.getDimens(this.jKL, R.dimen.ds34), 0, l.getDimens(this.jKL, R.dimen.ds34), 0);
                }
                aVar.jKS.setLayoutParams(layoutParams);
                aVar.mProgress = null;
            } else if (itemViewType == 2) {
                aVar.mTitle.setText(R.string.new_fans);
                aVar.mTitle.setVisibility(0);
            } else {
                aVar.mName.setText(this.jKL.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.jKL.getLayoutMode().setNightMode(skinType == 1);
        this.jKL.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.mTitle != null) {
                an.setViewTextColor(aVar.mTitle, (int) R.color.cp_cont_d);
                an.setBackgroundColor(aVar.mTitle, R.color.cp_bg_line_e);
            }
            if (aVar.jKS != null) {
                an.setImageResource(aVar.jKS, R.color.cp_bg_line_c);
            }
            if (aVar.jKR != null) {
                aVar.jKR.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fPX) {
            return 0;
        }
        if (this.dQf == null || i >= this.dQf.size()) {
            return 1;
        }
        return this.dQf.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fPX) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c ahX;
        ViewGroup fBd;
        TextView fBh;
        TextView fQb;
        LinearLayout fRd;
        ClickableHeaderImageView jKP;
        View jKQ;
        MyFansUserLikeButton jKR;
        ImageView jKS;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
