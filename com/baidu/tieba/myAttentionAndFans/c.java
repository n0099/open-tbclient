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
    boolean eLE;
    private View.OnClickListener eMF;
    private PersonListActivity iro;
    private View.OnClickListener irp;
    private int mSex;

    public c(PersonListActivity personListActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.iro = null;
        this.eLE = true;
        this.mSex = 0;
        this.irp = null;
        this.eMF = null;
        this.iro = personListActivity;
        this.eLE = z;
        this.mSex = i;
        this.irp = onClickListener2;
        this.eMF = onClickListener;
        this.cVQ = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(av avVar) {
        if (avVar != null && avVar.aBl() != null) {
            Iterator<UserData> it = avVar.aBl().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null) {
                    next.setIsLike(next.getHave_attention() > 0);
                }
            }
            ArrayList arrayList = new ArrayList();
            if (this.cVQ == null) {
                this.cVQ = new ArrayList<>();
            }
            arrayList.addAll(avVar.aBl());
            if (!v.isEmpty(this.cVQ) && this.cVQ.get(this.cVQ.size() - 1) != null && this.cVQ.get(this.cVQ.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                this.cVQ.get(this.cVQ.size() - 1).isLastNewFan = true;
            } else {
                for (int i = 0; i < arrayList.size() - 1; i++) {
                    UserData userData = (UserData) arrayList.get(i);
                    UserData userData2 = (UserData) arrayList.get(i + 1);
                    if (userData != null && userData2 != null && userData.isNewFan && !userData2.isNewFan) {
                        userData.isLastNewFan = true;
                    }
                }
            }
            if (v.isEmpty(this.cVQ) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                UserData userData3 = new UserData();
                userData3.mAttentionType = 0;
                arrayList.add(0, userData3);
            }
            this.cVQ.addAll(arrayList);
        }
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean em(long j) {
        if (j == 0 || this.cVQ == null || this.cVQ.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.cVQ.iterator();
        while (it.hasNext()) {
            UserData next = it.next();
            if (next != null && next.getUserIdLong() == j) {
                this.cVQ.remove(next);
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eLC) {
            return 1;
        }
        int i = 0;
        if (this.cVQ != null) {
            i = this.cVQ.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cVQ == null || i >= this.cVQ.size()) {
            return null;
        }
        return this.cVQ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.cVQ == null || i >= this.cVQ.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final a aVar;
        View view2;
        if (this.cVQ != null) {
            int itemViewType = getItemViewType(i);
            if (view == null || !(view.getTag() instanceof a)) {
                aVar = new a();
                if (itemViewType == 0) {
                    View inflate = LayoutInflater.from(this.iro.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar.exh = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar.exh.setOnClickListener(this.eMF);
                    aVar.irs = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar.irs.setRadius(l.getDimens(this.iro.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar.irs.setAutoChangeStyle(true);
                    aVar.irs.setClickable(false);
                    ((LinearLayout.LayoutParams) aVar.irs.getLayoutParams()).setMargins(l.getDimens(this.iro, R.dimen.ds34), 0, 0, 0);
                    aVar.eMI = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar.mName.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.myAttentionAndFans.c.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            Layout layout = aVar.mName.getLayout();
                            if (layout != null) {
                                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                                    aVar.mName.setCompoundDrawablePadding(l.getDimens(c.this.iro, R.dimen.tbds10));
                                } else {
                                    aVar.mName.setCompoundDrawablePadding(0);
                                }
                            }
                        }
                    });
                    aVar.irt = com.baidu.tbadk.ala.b.ayz().u(this.iro.getPageContext().getPageActivity(), 5);
                    if (aVar.irt != null) {
                        aVar.irt.setVisibility(8);
                        aVar.mContainer.addView(aVar.irt, 1);
                    }
                    aVar.eLG = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar.exl = (TextView) inflate.findViewById(R.id.intro);
                    aVar.iru = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar.iru.setContext(this.iro.getPageContext());
                    ((LinearLayout.LayoutParams) aVar.iru.getLayoutParams()).setMargins(0, 0, l.getDimens(this.iro, R.dimen.ds34), 0);
                    aVar.NB = new com.baidu.tbadk.core.view.userLike.c(this.iro.getPageContext(), aVar.iru);
                    aVar.NB.a((com.baidu.tbadk.core.view.userLike.a) v.getItem(this.cVQ, i));
                    aVar.NB.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.c.2
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void fV(boolean z) {
                            if (z) {
                                l.showToast(c.this.iro, (int) R.string.attention_success);
                            } else {
                                l.showToast(c.this.iro, (int) R.string.unfollow_success);
                            }
                        }
                    });
                    aVar.mProgress = null;
                    aVar.mTitle = null;
                    aVar.irv = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    view2 = inflate;
                } else if (itemViewType == 2) {
                    View inflate2 = LayoutInflater.from(this.iro.getPageContext().getPageActivity()).inflate(R.layout.my_fan_list_title, (ViewGroup) null);
                    aVar.mTitle = (TextView) inflate2.findViewById(R.id.my_new_fan_title);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.iro.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.irp);
                    aVar.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar.mTitle = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar);
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.iru != null) {
                aVar.iru.setTag(Integer.valueOf(i));
            }
            if (itemViewType == 0) {
                if (this.eLC) {
                    aVar.eMI.setVisibility(8);
                    aVar.eLG.setVisibility(0);
                    if (this.eLE) {
                        aVar.eLG.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.eLG.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.eLG.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.eLG.setText(R.string.no_fan_other);
                    }
                } else {
                    aVar.exh.setTag(Integer.valueOf(i));
                    UserData userData = (UserData) v.getItem(this.cVQ, i);
                    if (userData != null) {
                        aVar.eLG.setVisibility(8);
                        UtilHelper.showHeadImageViewBigV(aVar.irs, userData, 0);
                        aVar.mName.setText(UtilHelper.getUserName(userData));
                        aVar.irs.setPlaceHolder(1);
                        aVar.irs.startLoad(userData.getAvater(), 12, false);
                        if (aVar.irt != null && userData.getAlaUserData() != null) {
                            if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                                aVar.irt.setVisibility(8);
                            } else {
                                aVar.irt.setVisibility(0);
                                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                                aVar2.cJQ = userData.getAlaUserData();
                                aVar2.type = 5;
                                aVar.irt.setTag(aVar2);
                            }
                        }
                        if (aq.isEmpty(userData.getIntro())) {
                            aVar.exl.setVisibility(8);
                        } else {
                            aVar.exl.setVisibility(0);
                            aVar.exl.setText(userData.getIntro());
                        }
                        String userId = userData.getUserId();
                        userData.setIsLike(userData.getHave_attention() > 0);
                        aVar.NB.a(userData);
                        if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            aVar.iru.setVisibility(8);
                        } else {
                            aVar.iru.setStatsParams(2, userId);
                            aVar.NB.sE("9");
                            aVar.iru.setVisibility(0);
                        }
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.irv.getLayoutParams();
                if (v.getItem(this.cVQ, i) != null && ((UserData) v.getItem(this.cVQ, i)).isLastNewFan) {
                    layoutParams.height = l.getDimens(this.iro, R.dimen.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                    aVar.irv.setVisibility(0);
                } else {
                    aVar.irv.setVisibility(8);
                    layoutParams.height = l.getDimens(this.iro, R.dimen.ds1);
                    layoutParams.setMargins(l.getDimens(this.iro, R.dimen.ds34), 0, l.getDimens(this.iro, R.dimen.ds34), 0);
                }
                aVar.irv.setLayoutParams(layoutParams);
                aVar.mProgress = null;
            } else if (itemViewType == 2) {
                aVar.mTitle.setText(R.string.new_fans);
                aVar.mTitle.setVisibility(0);
            } else {
                aVar.mName.setText(this.iro.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.iro.getLayoutMode().setNightMode(skinType == 1);
        this.iro.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.mTitle != null) {
                am.setViewTextColor(aVar.mTitle, (int) R.color.cp_cont_d);
                am.setBackgroundColor(aVar.mTitle, R.color.cp_bg_line_e);
            }
            if (aVar.irv != null) {
                am.setImageResource(aVar.irv, R.color.cp_bg_line_c);
            }
            if (aVar.iru != null) {
                aVar.iru.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.eLC) {
            return 0;
        }
        if (this.cVQ == null || i >= this.cVQ.size()) {
            return 1;
        }
        return this.cVQ.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.eLC) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c NB;
        TextView eLG;
        LinearLayout eMI;
        ViewGroup exh;
        TextView exl;
        ClickableHeaderImageView irs;
        View irt;
        MyFansUserLikeButton iru;
        ImageView irv;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
