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
/* loaded from: classes8.dex */
public class c extends b {
    boolean eHK;
    private View.OnClickListener eIL;
    private PersonListActivity ipt;
    private View.OnClickListener ipu;
    private int mSex;

    public c(PersonListActivity personListActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.ipt = null;
        this.eHK = true;
        this.mSex = 0;
        this.ipu = null;
        this.eIL = null;
        this.ipt = personListActivity;
        this.eHK = z;
        this.mSex = i;
        this.ipu = onClickListener2;
        this.eIL = onClickListener;
        this.cRO = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(av avVar) {
        if (avVar != null && avVar.ayU() != null) {
            Iterator<UserData> it = avVar.ayU().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null) {
                    next.setIsLike(next.getHave_attention() > 0);
                }
            }
            ArrayList arrayList = new ArrayList();
            if (this.cRO == null) {
                this.cRO = new ArrayList<>();
            }
            arrayList.addAll(avVar.ayU());
            if (!v.isEmpty(this.cRO) && this.cRO.get(this.cRO.size() - 1) != null && this.cRO.get(this.cRO.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                this.cRO.get(this.cRO.size() - 1).isLastNewFan = true;
            } else {
                for (int i = 0; i < arrayList.size() - 1; i++) {
                    UserData userData = (UserData) arrayList.get(i);
                    UserData userData2 = (UserData) arrayList.get(i + 1);
                    if (userData != null && userData2 != null && userData.isNewFan && !userData2.isNewFan) {
                        userData.isLastNewFan = true;
                    }
                }
            }
            if (v.isEmpty(this.cRO) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                UserData userData3 = new UserData();
                userData3.mAttentionType = 0;
                arrayList.add(0, userData3);
            }
            this.cRO.addAll(arrayList);
        }
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean em(long j) {
        if (j == 0 || this.cRO == null || this.cRO.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.cRO.iterator();
        while (it.hasNext()) {
            UserData next = it.next();
            if (next != null && next.getUserIdLong() == j) {
                this.cRO.remove(next);
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eHI) {
            return 1;
        }
        int i = 0;
        if (this.cRO != null) {
            i = this.cRO.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cRO == null || i >= this.cRO.size()) {
            return null;
        }
        return this.cRO.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.cRO == null || i >= this.cRO.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final a aVar;
        View view2;
        if (this.cRO != null) {
            int itemViewType = getItemViewType(i);
            if (view == null || !(view.getTag() instanceof a)) {
                aVar = new a();
                if (itemViewType == 0) {
                    View inflate = LayoutInflater.from(this.ipt.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar.esX = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar.esX.setOnClickListener(this.eIL);
                    aVar.ipx = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar.ipx.setRadius(l.getDimens(this.ipt.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar.ipx.setAutoChangeStyle(true);
                    aVar.ipx.setClickable(false);
                    ((LinearLayout.LayoutParams) aVar.ipx.getLayoutParams()).setMargins(l.getDimens(this.ipt, R.dimen.ds34), 0, 0, 0);
                    aVar.eIO = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar.mName.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.myAttentionAndFans.c.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            Layout layout = aVar.mName.getLayout();
                            if (layout != null) {
                                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                                    aVar.mName.setCompoundDrawablePadding(l.getDimens(c.this.ipt, R.dimen.tbds10));
                                } else {
                                    aVar.mName.setCompoundDrawablePadding(0);
                                }
                            }
                        }
                    });
                    aVar.ipy = com.baidu.tbadk.ala.b.awm().u(this.ipt.getPageContext().getPageActivity(), 5);
                    if (aVar.ipy != null) {
                        aVar.ipy.setVisibility(8);
                        aVar.mContainer.addView(aVar.ipy, 1);
                    }
                    aVar.eHM = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar.etb = (TextView) inflate.findViewById(R.id.intro);
                    aVar.ipz = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar.ipz.setContext(this.ipt.getPageContext());
                    ((LinearLayout.LayoutParams) aVar.ipz.getLayoutParams()).setMargins(0, 0, l.getDimens(this.ipt, R.dimen.ds34), 0);
                    aVar.Nb = new com.baidu.tbadk.core.view.userLike.c(this.ipt.getPageContext(), aVar.ipz);
                    aVar.Nb.a((com.baidu.tbadk.core.view.userLike.a) v.getItem(this.cRO, i));
                    aVar.Nb.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.c.2
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void fO(boolean z) {
                            if (z) {
                                l.showToast(c.this.ipt, (int) R.string.attention_success);
                            } else {
                                l.showToast(c.this.ipt, (int) R.string.unfollow_success);
                            }
                        }
                    });
                    aVar.mProgress = null;
                    aVar.mTitle = null;
                    aVar.ipA = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    view2 = inflate;
                } else if (itemViewType == 2) {
                    View inflate2 = LayoutInflater.from(this.ipt.getPageContext().getPageActivity()).inflate(R.layout.my_fan_list_title, (ViewGroup) null);
                    aVar.mTitle = (TextView) inflate2.findViewById(R.id.my_new_fan_title);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.ipt.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.ipu);
                    aVar.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar.mTitle = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar);
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.ipz != null) {
                aVar.ipz.setTag(Integer.valueOf(i));
            }
            if (itemViewType == 0) {
                if (this.eHI) {
                    aVar.eIO.setVisibility(8);
                    aVar.eHM.setVisibility(0);
                    if (this.eHK) {
                        aVar.eHM.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.eHM.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.eHM.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.eHM.setText(R.string.no_fan_other);
                    }
                } else {
                    aVar.esX.setTag(Integer.valueOf(i));
                    UserData userData = (UserData) v.getItem(this.cRO, i);
                    if (userData != null) {
                        aVar.eHM.setVisibility(8);
                        UtilHelper.showHeadImageViewBigV(aVar.ipx, userData, 0);
                        aVar.mName.setText(UtilHelper.getUserName(userData));
                        aVar.ipx.setPlaceHolder(1);
                        aVar.ipx.startLoad(userData.getAvater(), 12, false);
                        if (aVar.ipy != null && userData.getAlaUserData() != null) {
                            if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                                aVar.ipy.setVisibility(8);
                            } else {
                                aVar.ipy.setVisibility(0);
                                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                                aVar2.cFM = userData.getAlaUserData();
                                aVar2.type = 5;
                                aVar.ipy.setTag(aVar2);
                            }
                        }
                        if (aq.isEmpty(userData.getIntro())) {
                            aVar.etb.setVisibility(8);
                        } else {
                            aVar.etb.setVisibility(0);
                            aVar.etb.setText(userData.getIntro());
                        }
                        String userId = userData.getUserId();
                        userData.setIsLike(userData.getHave_attention() > 0);
                        aVar.Nb.a(userData);
                        if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            aVar.ipz.setVisibility(8);
                        } else {
                            aVar.ipz.setStatsParams(2, userId);
                            aVar.Nb.sn("9");
                            aVar.ipz.setVisibility(0);
                        }
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.ipA.getLayoutParams();
                if (v.getItem(this.cRO, i) != null && ((UserData) v.getItem(this.cRO, i)).isLastNewFan) {
                    layoutParams.height = l.getDimens(this.ipt, R.dimen.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                    aVar.ipA.setVisibility(0);
                } else {
                    aVar.ipA.setVisibility(8);
                    layoutParams.height = l.getDimens(this.ipt, R.dimen.ds1);
                    layoutParams.setMargins(l.getDimens(this.ipt, R.dimen.ds34), 0, l.getDimens(this.ipt, R.dimen.ds34), 0);
                }
                aVar.ipA.setLayoutParams(layoutParams);
                aVar.mProgress = null;
            } else if (itemViewType == 2) {
                aVar.mTitle.setText(R.string.new_fans);
                aVar.mTitle.setVisibility(0);
            } else {
                aVar.mName.setText(this.ipt.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.ipt.getLayoutMode().setNightMode(skinType == 1);
        this.ipt.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.mTitle != null) {
                am.setViewTextColor(aVar.mTitle, (int) R.color.cp_cont_d);
                am.setBackgroundColor(aVar.mTitle, R.color.cp_bg_line_e);
            }
            if (aVar.ipA != null) {
                am.setImageResource(aVar.ipA, R.color.cp_bg_line_c);
            }
            if (aVar.ipz != null) {
                aVar.ipz.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.eHI) {
            return 0;
        }
        if (this.cRO == null || i >= this.cRO.size()) {
            return 1;
        }
        return this.cRO.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.eHI) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c Nb;
        TextView eHM;
        LinearLayout eIO;
        ViewGroup esX;
        TextView etb;
        ImageView ipA;
        ClickableHeaderImageView ipx;
        View ipy;
        MyFansUserLikeButton ipz;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
