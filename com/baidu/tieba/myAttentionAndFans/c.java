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
    boolean fEF;
    private View.OnClickListener fFG;
    private PersonListActivity jso;
    private View.OnClickListener jsp;
    private int mSex;

    public c(PersonListActivity personListActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.jso = null;
        this.fEF = true;
        this.mSex = 0;
        this.jsp = null;
        this.fFG = null;
        this.jso = personListActivity;
        this.fEF = z;
        this.mSex = i;
        this.jsp = onClickListener2;
        this.fFG = onClickListener;
        this.dJp = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(av avVar) {
        if (avVar != null && avVar.aPw() != null) {
            Iterator<UserData> it = avVar.aPw().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null) {
                    next.setIsLike(next.getHave_attention() > 0);
                }
            }
            ArrayList arrayList = new ArrayList();
            if (this.dJp == null) {
                this.dJp = new ArrayList<>();
            }
            arrayList.addAll(avVar.aPw());
            if (!v.isEmpty(this.dJp) && this.dJp.get(this.dJp.size() - 1) != null && this.dJp.get(this.dJp.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                this.dJp.get(this.dJp.size() - 1).isLastNewFan = true;
            } else {
                for (int i = 0; i < arrayList.size() - 1; i++) {
                    UserData userData = (UserData) arrayList.get(i);
                    UserData userData2 = (UserData) arrayList.get(i + 1);
                    if (userData != null && userData2 != null && userData.isNewFan && !userData2.isNewFan) {
                        userData.isLastNewFan = true;
                    }
                }
            }
            if (v.isEmpty(this.dJp) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                UserData userData3 = new UserData();
                userData3.mAttentionType = 0;
                arrayList.add(0, userData3);
            }
            this.dJp.addAll(arrayList);
        }
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean eY(long j) {
        if (j == 0 || this.dJp == null || this.dJp.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.dJp.iterator();
        while (it.hasNext()) {
            UserData next = it.next();
            if (next != null && next.getUserIdLong() == j) {
                this.dJp.remove(next);
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fED) {
            return 1;
        }
        int i = 0;
        if (this.dJp != null) {
            i = this.dJp.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dJp == null || i >= this.dJp.size()) {
            return null;
        }
        return this.dJp.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.dJp == null || i >= this.dJp.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final a aVar;
        View view2;
        if (this.dJp != null) {
            int itemViewType = getItemViewType(i);
            if (view == null || !(view.getTag() instanceof a)) {
                aVar = new a();
                if (itemViewType == 0) {
                    View inflate = LayoutInflater.from(this.jso.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar.fpH = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar.fpH.setOnClickListener(this.fFG);
                    aVar.jss = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar.jss.setRadius(l.getDimens(this.jso.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar.jss.setAutoChangeStyle(true);
                    aVar.jss.setClickable(false);
                    ((LinearLayout.LayoutParams) aVar.jss.getLayoutParams()).setMargins(l.getDimens(this.jso, R.dimen.ds34), 0, 0, 0);
                    aVar.fFJ = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar.mName.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.myAttentionAndFans.c.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            Layout layout = aVar.mName.getLayout();
                            if (layout != null) {
                                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                                    aVar.mName.setCompoundDrawablePadding(l.getDimens(c.this.jso, R.dimen.tbds10));
                                } else {
                                    aVar.mName.setCompoundDrawablePadding(0);
                                }
                            }
                        }
                    });
                    aVar.jst = com.baidu.tbadk.ala.b.aMC().p(this.jso.getPageContext().getPageActivity(), 5);
                    if (aVar.jst != null) {
                        aVar.jst.setVisibility(8);
                        aVar.mContainer.addView(aVar.jst, 1);
                    }
                    aVar.fEH = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar.fpL = (TextView) inflate.findViewById(R.id.intro);
                    aVar.jsu = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar.jsu.setContext(this.jso.getPageContext());
                    ((LinearLayout.LayoutParams) aVar.jsu.getLayoutParams()).setMargins(0, 0, l.getDimens(this.jso, R.dimen.ds34), 0);
                    aVar.agS = new com.baidu.tbadk.core.view.userLike.c(this.jso.getPageContext(), aVar.jsu);
                    aVar.agS.a((com.baidu.tbadk.core.view.userLike.a) v.getItem(this.dJp, i));
                    aVar.agS.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.c.2
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void hs(boolean z) {
                            if (z) {
                                l.showToast(c.this.jso, (int) R.string.attention_success);
                            } else {
                                l.showToast(c.this.jso, (int) R.string.unfollow_success);
                            }
                        }
                    });
                    aVar.mProgress = null;
                    aVar.mTitle = null;
                    aVar.jsv = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    view2 = inflate;
                } else if (itemViewType == 2) {
                    View inflate2 = LayoutInflater.from(this.jso.getPageContext().getPageActivity()).inflate(R.layout.my_fan_list_title, (ViewGroup) null);
                    aVar.mTitle = (TextView) inflate2.findViewById(R.id.my_new_fan_title);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.jso.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.jsp);
                    aVar.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar.mTitle = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar);
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.jsu != null) {
                aVar.jsu.setTag(Integer.valueOf(i));
            }
            if (itemViewType == 0) {
                if (this.fED) {
                    aVar.fFJ.setVisibility(8);
                    aVar.fEH.setVisibility(0);
                    if (this.fEF) {
                        aVar.fEH.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.fEH.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.fEH.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.fEH.setText(R.string.no_fan_other);
                    }
                } else {
                    aVar.fpH.setTag(Integer.valueOf(i));
                    UserData userData = (UserData) v.getItem(this.dJp, i);
                    if (userData != null) {
                        aVar.fEH.setVisibility(8);
                        UtilHelper.showHeadImageViewBigV(aVar.jss, userData, 0);
                        aVar.mName.setText(UtilHelper.getUserName(userData));
                        aVar.jss.setPlaceHolder(1);
                        aVar.jss.startLoad(userData.getAvater(), 12, false);
                        if (aVar.jst != null && userData.getAlaUserData() != null) {
                            if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                                aVar.jst.setVisibility(8);
                            } else {
                                aVar.jst.setVisibility(0);
                                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                                aVar2.dxn = userData.getAlaUserData();
                                aVar2.type = 5;
                                aVar.jst.setTag(aVar2);
                            }
                        }
                        if (aq.isEmpty(userData.getIntro())) {
                            aVar.fpL.setVisibility(8);
                        } else {
                            aVar.fpL.setVisibility(0);
                            aVar.fpL.setText(userData.getIntro());
                        }
                        String userId = userData.getUserId();
                        userData.setIsLike(userData.getHave_attention() > 0);
                        aVar.agS.a(userData);
                        if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            aVar.jsu.setVisibility(8);
                        } else {
                            aVar.jsu.setStatsParams(2, userId);
                            aVar.agS.vA("9");
                            aVar.jsu.setVisibility(0);
                        }
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.jsv.getLayoutParams();
                if (v.getItem(this.dJp, i) != null && ((UserData) v.getItem(this.dJp, i)).isLastNewFan) {
                    layoutParams.height = l.getDimens(this.jso, R.dimen.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                    aVar.jsv.setVisibility(0);
                } else {
                    aVar.jsv.setVisibility(8);
                    layoutParams.height = l.getDimens(this.jso, R.dimen.ds1);
                    layoutParams.setMargins(l.getDimens(this.jso, R.dimen.ds34), 0, l.getDimens(this.jso, R.dimen.ds34), 0);
                }
                aVar.jsv.setLayoutParams(layoutParams);
                aVar.mProgress = null;
            } else if (itemViewType == 2) {
                aVar.mTitle.setText(R.string.new_fans);
                aVar.mTitle.setVisibility(0);
            } else {
                aVar.mName.setText(this.jso.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.jso.getLayoutMode().setNightMode(skinType == 1);
        this.jso.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.mTitle != null) {
                am.setViewTextColor(aVar.mTitle, (int) R.color.cp_cont_d);
                am.setBackgroundColor(aVar.mTitle, R.color.cp_bg_line_e);
            }
            if (aVar.jsv != null) {
                am.setImageResource(aVar.jsv, R.color.cp_bg_line_c);
            }
            if (aVar.jsu != null) {
                aVar.jsu.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fED) {
            return 0;
        }
        if (this.dJp == null || i >= this.dJp.size()) {
            return 1;
        }
        return this.dJp.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fED) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c agS;
        TextView fEH;
        LinearLayout fFJ;
        ViewGroup fpH;
        TextView fpL;
        ClickableHeaderImageView jss;
        View jst;
        MyFansUserLikeButton jsu;
        ImageView jsv;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
