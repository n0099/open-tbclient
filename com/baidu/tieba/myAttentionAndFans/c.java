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
    boolean eLF;
    private View.OnClickListener eMG;
    private PersonListActivity irq;
    private View.OnClickListener irr;
    private int mSex;

    public c(PersonListActivity personListActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.irq = null;
        this.eLF = true;
        this.mSex = 0;
        this.irr = null;
        this.eMG = null;
        this.irq = personListActivity;
        this.eLF = z;
        this.mSex = i;
        this.irr = onClickListener2;
        this.eMG = onClickListener;
        this.cVR = new ArrayList<>();
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
            if (this.cVR == null) {
                this.cVR = new ArrayList<>();
            }
            arrayList.addAll(avVar.aBn());
            if (!v.isEmpty(this.cVR) && this.cVR.get(this.cVR.size() - 1) != null && this.cVR.get(this.cVR.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                this.cVR.get(this.cVR.size() - 1).isLastNewFan = true;
            } else {
                for (int i = 0; i < arrayList.size() - 1; i++) {
                    UserData userData = (UserData) arrayList.get(i);
                    UserData userData2 = (UserData) arrayList.get(i + 1);
                    if (userData != null && userData2 != null && userData.isNewFan && !userData2.isNewFan) {
                        userData.isLastNewFan = true;
                    }
                }
            }
            if (v.isEmpty(this.cVR) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                UserData userData3 = new UserData();
                userData3.mAttentionType = 0;
                arrayList.add(0, userData3);
            }
            this.cVR.addAll(arrayList);
        }
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean em(long j) {
        if (j == 0 || this.cVR == null || this.cVR.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.cVR.iterator();
        while (it.hasNext()) {
            UserData next = it.next();
            if (next != null && next.getUserIdLong() == j) {
                this.cVR.remove(next);
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eLD) {
            return 1;
        }
        int i = 0;
        if (this.cVR != null) {
            i = this.cVR.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cVR == null || i >= this.cVR.size()) {
            return null;
        }
        return this.cVR.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.cVR == null || i >= this.cVR.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final a aVar;
        View view2;
        if (this.cVR != null) {
            int itemViewType = getItemViewType(i);
            if (view == null || !(view.getTag() instanceof a)) {
                aVar = new a();
                if (itemViewType == 0) {
                    View inflate = LayoutInflater.from(this.irq.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar.exi = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar.exi.setOnClickListener(this.eMG);
                    aVar.iru = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar.iru.setRadius(l.getDimens(this.irq.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar.iru.setAutoChangeStyle(true);
                    aVar.iru.setClickable(false);
                    ((LinearLayout.LayoutParams) aVar.iru.getLayoutParams()).setMargins(l.getDimens(this.irq, R.dimen.ds34), 0, 0, 0);
                    aVar.eMJ = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar.mName.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.myAttentionAndFans.c.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            Layout layout = aVar.mName.getLayout();
                            if (layout != null) {
                                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                                    aVar.mName.setCompoundDrawablePadding(l.getDimens(c.this.irq, R.dimen.tbds10));
                                } else {
                                    aVar.mName.setCompoundDrawablePadding(0);
                                }
                            }
                        }
                    });
                    aVar.irv = com.baidu.tbadk.ala.b.ayB().u(this.irq.getPageContext().getPageActivity(), 5);
                    if (aVar.irv != null) {
                        aVar.irv.setVisibility(8);
                        aVar.mContainer.addView(aVar.irv, 1);
                    }
                    aVar.eLH = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar.exm = (TextView) inflate.findViewById(R.id.intro);
                    aVar.irw = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar.irw.setContext(this.irq.getPageContext());
                    ((LinearLayout.LayoutParams) aVar.irw.getLayoutParams()).setMargins(0, 0, l.getDimens(this.irq, R.dimen.ds34), 0);
                    aVar.NB = new com.baidu.tbadk.core.view.userLike.c(this.irq.getPageContext(), aVar.irw);
                    aVar.NB.a((com.baidu.tbadk.core.view.userLike.a) v.getItem(this.cVR, i));
                    aVar.NB.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.c.2
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void fV(boolean z) {
                            if (z) {
                                l.showToast(c.this.irq, (int) R.string.attention_success);
                            } else {
                                l.showToast(c.this.irq, (int) R.string.unfollow_success);
                            }
                        }
                    });
                    aVar.mProgress = null;
                    aVar.mTitle = null;
                    aVar.irx = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    view2 = inflate;
                } else if (itemViewType == 2) {
                    View inflate2 = LayoutInflater.from(this.irq.getPageContext().getPageActivity()).inflate(R.layout.my_fan_list_title, (ViewGroup) null);
                    aVar.mTitle = (TextView) inflate2.findViewById(R.id.my_new_fan_title);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.irq.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.irr);
                    aVar.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar.mTitle = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar);
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.irw != null) {
                aVar.irw.setTag(Integer.valueOf(i));
            }
            if (itemViewType == 0) {
                if (this.eLD) {
                    aVar.eMJ.setVisibility(8);
                    aVar.eLH.setVisibility(0);
                    if (this.eLF) {
                        aVar.eLH.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.eLH.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.eLH.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.eLH.setText(R.string.no_fan_other);
                    }
                } else {
                    aVar.exi.setTag(Integer.valueOf(i));
                    UserData userData = (UserData) v.getItem(this.cVR, i);
                    if (userData != null) {
                        aVar.eLH.setVisibility(8);
                        UtilHelper.showHeadImageViewBigV(aVar.iru, userData, 0);
                        aVar.mName.setText(UtilHelper.getUserName(userData));
                        aVar.iru.setPlaceHolder(1);
                        aVar.iru.startLoad(userData.getAvater(), 12, false);
                        if (aVar.irv != null && userData.getAlaUserData() != null) {
                            if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                                aVar.irv.setVisibility(8);
                            } else {
                                aVar.irv.setVisibility(0);
                                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                                aVar2.cJR = userData.getAlaUserData();
                                aVar2.type = 5;
                                aVar.irv.setTag(aVar2);
                            }
                        }
                        if (aq.isEmpty(userData.getIntro())) {
                            aVar.exm.setVisibility(8);
                        } else {
                            aVar.exm.setVisibility(0);
                            aVar.exm.setText(userData.getIntro());
                        }
                        String userId = userData.getUserId();
                        userData.setIsLike(userData.getHave_attention() > 0);
                        aVar.NB.a(userData);
                        if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            aVar.irw.setVisibility(8);
                        } else {
                            aVar.irw.setStatsParams(2, userId);
                            aVar.NB.sE("9");
                            aVar.irw.setVisibility(0);
                        }
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.irx.getLayoutParams();
                if (v.getItem(this.cVR, i) != null && ((UserData) v.getItem(this.cVR, i)).isLastNewFan) {
                    layoutParams.height = l.getDimens(this.irq, R.dimen.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                    aVar.irx.setVisibility(0);
                } else {
                    aVar.irx.setVisibility(8);
                    layoutParams.height = l.getDimens(this.irq, R.dimen.ds1);
                    layoutParams.setMargins(l.getDimens(this.irq, R.dimen.ds34), 0, l.getDimens(this.irq, R.dimen.ds34), 0);
                }
                aVar.irx.setLayoutParams(layoutParams);
                aVar.mProgress = null;
            } else if (itemViewType == 2) {
                aVar.mTitle.setText(R.string.new_fans);
                aVar.mTitle.setVisibility(0);
            } else {
                aVar.mName.setText(this.irq.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.irq.getLayoutMode().setNightMode(skinType == 1);
        this.irq.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.mTitle != null) {
                am.setViewTextColor(aVar.mTitle, (int) R.color.cp_cont_d);
                am.setBackgroundColor(aVar.mTitle, R.color.cp_bg_line_e);
            }
            if (aVar.irx != null) {
                am.setImageResource(aVar.irx, R.color.cp_bg_line_c);
            }
            if (aVar.irw != null) {
                aVar.irw.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.eLD) {
            return 0;
        }
        if (this.cVR == null || i >= this.cVR.size()) {
            return 1;
        }
        return this.cVR.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.eLD) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c NB;
        TextView eLH;
        LinearLayout eMJ;
        ViewGroup exi;
        TextView exm;
        ClickableHeaderImageView iru;
        View irv;
        MyFansUserLikeButton irw;
        ImageView irx;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
