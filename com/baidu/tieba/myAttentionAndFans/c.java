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
/* loaded from: classes22.dex */
public class c extends b {
    boolean gkE;
    private View.OnClickListener glE;
    private PersonListActivity krn;
    private View.OnClickListener kro;
    private int mSex;

    public c(PersonListActivity personListActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.krn = null;
        this.gkE = true;
        this.mSex = 0;
        this.kro = null;
        this.glE = null;
        this.krn = personListActivity;
        this.gkE = z;
        this.mSex = i;
        this.kro = onClickListener2;
        this.glE = onClickListener;
        this.eiq = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(bc bcVar) {
        if (bcVar != null && bcVar.ber() != null) {
            Iterator<UserData> it = bcVar.ber().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null) {
                    next.setIsLike(next.getHave_attention() > 0);
                }
            }
            ArrayList arrayList = new ArrayList();
            if (this.eiq == null) {
                this.eiq = new ArrayList<>();
            }
            arrayList.addAll(bcVar.ber());
            if (!y.isEmpty(this.eiq) && this.eiq.get(this.eiq.size() - 1) != null && this.eiq.get(this.eiq.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                this.eiq.get(this.eiq.size() - 1).isLastNewFan = true;
            } else {
                for (int i = 0; i < arrayList.size() - 1; i++) {
                    UserData userData = (UserData) arrayList.get(i);
                    UserData userData2 = (UserData) arrayList.get(i + 1);
                    if (userData != null && userData2 != null && userData.isNewFan && !userData2.isNewFan) {
                        userData.isLastNewFan = true;
                    }
                }
            }
            if (y.isEmpty(this.eiq) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                UserData userData3 = new UserData();
                userData3.mAttentionType = 0;
                arrayList.add(0, userData3);
            }
            this.eiq.addAll(arrayList);
        }
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean fP(long j) {
        if (j == 0 || this.eiq == null || this.eiq.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.eiq.iterator();
        while (it.hasNext()) {
            UserData next = it.next();
            if (next != null && next.getUserIdLong() == j) {
                this.eiq.remove(next);
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gkC) {
            return 1;
        }
        int i = 0;
        if (this.eiq != null) {
            i = this.eiq.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eiq == null || i >= this.eiq.size()) {
            return null;
        }
        return this.eiq.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.eiq == null || i >= this.eiq.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final a aVar;
        View view2;
        if (this.eiq != null) {
            int itemViewType = getItemViewType(i);
            if (view == null || !(view.getTag() instanceof a)) {
                aVar = new a();
                if (itemViewType == 0) {
                    View inflate = LayoutInflater.from(this.krn.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar.fUT = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar.fUT.setOnClickListener(this.glE);
                    aVar.krr = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar.krr.setRadius(l.getDimens(this.krn.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar.krr.setAutoChangeStyle(true);
                    aVar.krr.setClickable(false);
                    ((LinearLayout.LayoutParams) aVar.krr.getLayoutParams()).setMargins(l.getDimens(this.krn, R.dimen.ds34), 0, 0, 0);
                    aVar.glH = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar.mName.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.myAttentionAndFans.c.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            Layout layout = aVar.mName.getLayout();
                            if (layout != null) {
                                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                                    aVar.mName.setCompoundDrawablePadding(l.getDimens(c.this.krn, R.dimen.tbds10));
                                } else {
                                    aVar.mName.setCompoundDrawablePadding(0);
                                }
                            }
                        }
                    });
                    aVar.krs = com.baidu.tbadk.ala.b.bbl().q(this.krn.getPageContext().getPageActivity(), 5);
                    if (aVar.krs != null) {
                        aVar.krs.setVisibility(8);
                        aVar.mContainer.addView(aVar.krs, 1);
                    }
                    aVar.gkG = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar.fUX = (TextView) inflate.findViewById(R.id.intro);
                    aVar.krt = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar.krt.setContext(this.krn.getPageContext());
                    ((LinearLayout.LayoutParams) aVar.krt.getLayoutParams()).setMargins(0, 0, l.getDimens(this.krn, R.dimen.ds34), 0);
                    aVar.ajD = new com.baidu.tbadk.core.view.userLike.c(this.krn.getPageContext(), aVar.krt);
                    aVar.ajD.a((com.baidu.tbadk.core.view.userLike.a) y.getItem(this.eiq, i));
                    aVar.ajD.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.c.2
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void iB(boolean z) {
                            if (z) {
                                l.showToast(c.this.krn, R.string.attention_success);
                            } else {
                                l.showToast(c.this.krn, R.string.unfollow_success);
                            }
                        }
                    });
                    aVar.mProgress = null;
                    aVar.mTitle = null;
                    aVar.kru = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    view2 = inflate;
                } else if (itemViewType == 2) {
                    View inflate2 = LayoutInflater.from(this.krn.getPageContext().getPageActivity()).inflate(R.layout.my_fan_list_title, (ViewGroup) null);
                    aVar.mTitle = (TextView) inflate2.findViewById(R.id.my_new_fan_title);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.krn.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.kro);
                    aVar.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar.mTitle = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar);
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.krt != null) {
                aVar.krt.setTag(Integer.valueOf(i));
            }
            if (itemViewType == 0) {
                if (this.gkC) {
                    aVar.glH.setVisibility(8);
                    aVar.gkG.setVisibility(0);
                    if (this.gkE) {
                        aVar.gkG.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.gkG.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.gkG.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.gkG.setText(R.string.no_fan_other);
                    }
                } else {
                    aVar.fUT.setTag(Integer.valueOf(i));
                    UserData userData = (UserData) y.getItem(this.eiq, i);
                    if (userData != null) {
                        aVar.gkG.setVisibility(8);
                        UtilHelper.showHeadImageViewBigV(aVar.krr, userData, 0);
                        aVar.mName.setText(UtilHelper.getUserName(userData));
                        aVar.krr.setPlaceHolder(1);
                        aVar.krr.startLoad(userData.getAvater(), 12, false);
                        if (aVar.krs != null && userData.getAlaUserData() != null) {
                            if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                                aVar.krs.setVisibility(8);
                            } else {
                                aVar.krs.setVisibility(0);
                                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                                aVar2.dTL = userData.getAlaUserData();
                                aVar2.type = 5;
                                aVar.krs.setTag(aVar2);
                            }
                        }
                        if (at.isEmpty(userData.getIntro())) {
                            aVar.fUX.setVisibility(8);
                        } else {
                            aVar.fUX.setVisibility(0);
                            aVar.fUX.setText(userData.getIntro());
                        }
                        String userId = userData.getUserId();
                        userData.setIsLike(userData.getHave_attention() > 0);
                        aVar.ajD.a(userData);
                        if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            aVar.krt.setVisibility(8);
                        } else {
                            aVar.krt.setStatsParams(2, userId);
                            aVar.ajD.zH("9");
                            aVar.krt.setVisibility(0);
                        }
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.kru.getLayoutParams();
                if (y.getItem(this.eiq, i) != null && ((UserData) y.getItem(this.eiq, i)).isLastNewFan) {
                    layoutParams.height = l.getDimens(this.krn, R.dimen.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                    aVar.kru.setVisibility(0);
                } else {
                    aVar.kru.setVisibility(8);
                    layoutParams.height = l.getDimens(this.krn, R.dimen.ds1);
                    layoutParams.setMargins(l.getDimens(this.krn, R.dimen.ds34), 0, l.getDimens(this.krn, R.dimen.ds34), 0);
                }
                aVar.kru.setLayoutParams(layoutParams);
                aVar.mProgress = null;
            } else if (itemViewType == 2) {
                aVar.mTitle.setText(R.string.new_fans);
                aVar.mTitle.setVisibility(0);
            } else {
                aVar.mName.setText(this.krn.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.krn.getLayoutMode().setNightMode(skinType == 1);
        this.krn.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.mTitle != null) {
                ap.setViewTextColor(aVar.mTitle, R.color.cp_cont_d);
                ap.setBackgroundColor(aVar.mTitle, R.color.cp_bg_line_e);
            }
            if (aVar.kru != null) {
                ap.setImageResource(aVar.kru, R.color.cp_bg_line_c);
            }
            if (aVar.krt != null) {
                aVar.krt.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.gkC) {
            return 0;
        }
        if (this.eiq == null || i >= this.eiq.size()) {
            return 1;
        }
        return this.eiq.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.gkC) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c ajD;
        ViewGroup fUT;
        TextView fUX;
        TextView gkG;
        LinearLayout glH;
        ClickableHeaderImageView krr;
        View krs;
        MyFansUserLikeButton krt;
        ImageView kru;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
