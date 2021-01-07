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
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes8.dex */
public class c extends b {
    boolean hli;
    private View.OnClickListener hmh;
    private PersonListActivity lsa;
    private View.OnClickListener lsb;
    private int mSex;

    public c(PersonListActivity personListActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.lsa = null;
        this.hli = true;
        this.mSex = 0;
        this.lsb = null;
        this.hmh = null;
        this.lsa = personListActivity;
        this.hli = z;
        this.mSex = i;
        this.lsb = onClickListener2;
        this.hmh = onClickListener;
        this.eYq = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(be beVar) {
        if (beVar != null && beVar.bqj() != null) {
            Iterator<UserData> it = beVar.bqj().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null) {
                    next.setIsLike(next.getHave_attention() > 0);
                }
            }
            ArrayList arrayList = new ArrayList();
            if (this.eYq == null) {
                this.eYq = new ArrayList<>();
            }
            arrayList.addAll(beVar.bqj());
            if (!x.isEmpty(this.eYq) && this.eYq.get(this.eYq.size() - 1) != null && this.eYq.get(this.eYq.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                this.eYq.get(this.eYq.size() - 1).isLastNewFan = true;
            } else {
                for (int i = 0; i < arrayList.size() - 1; i++) {
                    UserData userData = (UserData) arrayList.get(i);
                    UserData userData2 = (UserData) arrayList.get(i + 1);
                    if (userData != null && userData2 != null && userData.isNewFan && !userData2.isNewFan) {
                        userData.isLastNewFan = true;
                    }
                }
            }
            if (x.isEmpty(this.eYq) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                UserData userData3 = new UserData();
                userData3.mAttentionType = 0;
                arrayList.add(0, userData3);
            }
            this.eYq.addAll(arrayList);
        }
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean hh(long j) {
        if (j == 0 || this.eYq == null || this.eYq.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.eYq.iterator();
        while (it.hasNext()) {
            UserData next = it.next();
            if (next != null && next.getUserIdLong() == j) {
                this.eYq.remove(next);
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hlg) {
            return 1;
        }
        int i = 0;
        if (this.eYq != null) {
            i = this.eYq.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eYq == null || i >= this.eYq.size()) {
            return null;
        }
        return this.eYq.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.eYq == null || i >= this.eYq.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final a aVar;
        View view2;
        if (this.eYq != null) {
            int itemViewType = getItemViewType(i);
            if (view == null || !(view.getTag() instanceof a)) {
                aVar = new a();
                if (itemViewType == 0) {
                    View inflate = LayoutInflater.from(this.lsa.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar.gRi = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar.gRi.setOnClickListener(this.hmh);
                    aVar.lse = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar.lse.setRadius(l.getDimens(this.lsa.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar.lse.setAutoChangeStyle(true);
                    aVar.lse.setClickable(false);
                    ((LinearLayout.LayoutParams) aVar.lse.getLayoutParams()).setMargins(l.getDimens(this.lsa, R.dimen.ds34), 0, 0, 0);
                    aVar.hmk = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar.mName.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.myAttentionAndFans.c.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            Layout layout = aVar.mName.getLayout();
                            if (layout != null) {
                                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                                    aVar.mName.setCompoundDrawablePadding(l.getDimens(c.this.lsa, R.dimen.tbds10));
                                } else {
                                    aVar.mName.setCompoundDrawablePadding(0);
                                }
                            }
                        }
                    });
                    aVar.lsf = com.baidu.tbadk.ala.b.bnp().A(this.lsa.getPageContext().getPageActivity(), 5);
                    if (aVar.lsf != null) {
                        aVar.lsf.setVisibility(8);
                        aVar.mContainer.addView(aVar.lsf, 1);
                    }
                    aVar.hlk = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar.gRm = (TextView) inflate.findViewById(R.id.intro);
                    aVar.lsg = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar.lsg.setContext(this.lsa.getPageContext());
                    ((LinearLayout.LayoutParams) aVar.lsg.getLayoutParams()).setMargins(0, 0, l.getDimens(this.lsa, R.dimen.ds34), 0);
                    aVar.alC = new com.baidu.tbadk.core.view.userLike.c(this.lsa.getPageContext(), aVar.lsg);
                    aVar.alC.a((com.baidu.tbadk.core.view.userLike.a) x.getItem(this.eYq, i));
                    aVar.alC.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.c.2
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void ki(boolean z) {
                            if (z) {
                                l.showToast(c.this.lsa, R.string.attention_success);
                            } else {
                                l.showToast(c.this.lsa, R.string.unfollow_success);
                            }
                        }
                    });
                    aVar.mProgress = null;
                    aVar.mTitle = null;
                    aVar.lsh = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    view2 = inflate;
                } else if (itemViewType == 2) {
                    View inflate2 = LayoutInflater.from(this.lsa.getPageContext().getPageActivity()).inflate(R.layout.my_fan_list_title, (ViewGroup) null);
                    aVar.mTitle = (TextView) inflate2.findViewById(R.id.my_new_fan_title);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.lsa.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.lsb);
                    aVar.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar.mTitle = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar);
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.lsg != null) {
                aVar.lsg.setTag(Integer.valueOf(i));
            }
            if (itemViewType == 0) {
                if (this.hlg) {
                    aVar.hmk.setVisibility(8);
                    aVar.hlk.setVisibility(0);
                    if (this.hli) {
                        aVar.hlk.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.hlk.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.hlk.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.hlk.setText(R.string.no_fan_other);
                    }
                } else {
                    aVar.gRi.setTag(Integer.valueOf(i));
                    UserData userData = (UserData) x.getItem(this.eYq, i);
                    if (userData != null) {
                        aVar.hlk.setVisibility(8);
                        UtilHelper.showHeadImageViewBigV(aVar.lse, userData, 0);
                        aVar.mName.setText(UtilHelper.getUserName(userData));
                        aVar.lse.setPlaceHolder(1);
                        aVar.lse.startLoad(userData.getAvater(), 12, false);
                        if (aVar.lsf != null && userData.getAlaUserData() != null) {
                            if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                                aVar.lsf.setVisibility(8);
                            } else {
                                aVar.lsf.setVisibility(0);
                                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                                aVar2.eJe = userData.getAlaUserData();
                                aVar2.type = 5;
                                aVar.lsf.setTag(aVar2);
                            }
                        }
                        if (at.isEmpty(userData.getIntro())) {
                            aVar.gRm.setVisibility(8);
                        } else {
                            aVar.gRm.setVisibility(0);
                            aVar.gRm.setText(userData.getIntro());
                        }
                        String userId = userData.getUserId();
                        userData.setIsLike(userData.getHave_attention() > 0);
                        aVar.alC.a(userData);
                        if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            aVar.lsg.setVisibility(8);
                        } else {
                            aVar.lsg.setStatsParams(2, userId);
                            aVar.alC.Ba("9");
                            aVar.lsg.setVisibility(0);
                        }
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.lsh.getLayoutParams();
                if (x.getItem(this.eYq, i) != null && ((UserData) x.getItem(this.eYq, i)).isLastNewFan) {
                    layoutParams.height = l.getDimens(this.lsa, R.dimen.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                    aVar.lsh.setVisibility(0);
                } else {
                    aVar.lsh.setVisibility(8);
                    layoutParams.height = l.getDimens(this.lsa, R.dimen.ds1);
                    layoutParams.setMargins(l.getDimens(this.lsa, R.dimen.ds34), 0, l.getDimens(this.lsa, R.dimen.ds34), 0);
                }
                aVar.lsh.setLayoutParams(layoutParams);
                aVar.mProgress = null;
            } else if (itemViewType == 2) {
                aVar.mTitle.setText(R.string.new_fans);
                aVar.mTitle.setVisibility(0);
            } else {
                aVar.mName.setText(this.lsa.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.lsa.getLayoutMode().setNightMode(skinType == 1);
        this.lsa.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.mTitle != null) {
                ao.setViewTextColor(aVar.mTitle, R.color.CAM_X0109);
                ao.setBackgroundColor(aVar.mTitle, R.color.CAM_X0205);
            }
            if (aVar.lsh != null) {
                ao.setImageResource(aVar.lsh, R.color.CAM_X0204);
            }
            if (aVar.lsg != null) {
                aVar.lsg.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.hlg) {
            return 0;
        }
        if (this.eYq == null || i >= this.eYq.size()) {
            return 1;
        }
        return this.eYq.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.hlg) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c alC;
        ViewGroup gRi;
        TextView gRm;
        TextView hlk;
        LinearLayout hmk;
        ClickableHeaderImageView lse;
        View lsf;
        MyFansUserLikeButton lsg;
        ImageView lsh;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
