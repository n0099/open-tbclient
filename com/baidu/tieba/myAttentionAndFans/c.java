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
import com.baidu.searchbox.ugc.model.PublishType;
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
/* loaded from: classes7.dex */
public class c extends b {
    boolean eGA;
    private View.OnClickListener eHB;
    private PersonListActivity ilN;
    private View.OnClickListener ilO;
    private int mSex;

    public c(PersonListActivity personListActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.ilN = null;
        this.eGA = true;
        this.mSex = 0;
        this.ilO = null;
        this.eHB = null;
        this.ilN = personListActivity;
        this.eGA = z;
        this.mSex = i;
        this.ilO = onClickListener2;
        this.eHB = onClickListener;
        this.cRE = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(av avVar) {
        if (avVar != null && avVar.ayB() != null) {
            Iterator<UserData> it = avVar.ayB().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null) {
                    next.setIsLike(next.getHave_attention() > 0);
                }
            }
            ArrayList arrayList = new ArrayList();
            if (this.cRE == null) {
                this.cRE = new ArrayList<>();
            }
            arrayList.addAll(avVar.ayB());
            if (!v.isEmpty(this.cRE) && this.cRE.get(this.cRE.size() - 1) != null && this.cRE.get(this.cRE.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                this.cRE.get(this.cRE.size() - 1).isLastNewFan = true;
            } else {
                for (int i = 0; i < arrayList.size() - 1; i++) {
                    UserData userData = (UserData) arrayList.get(i);
                    UserData userData2 = (UserData) arrayList.get(i + 1);
                    if (userData != null && userData2 != null && userData.isNewFan && !userData2.isNewFan) {
                        userData.isLastNewFan = true;
                    }
                }
            }
            if (v.isEmpty(this.cRE) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                UserData userData3 = new UserData();
                userData3.mAttentionType = 0;
                arrayList.add(0, userData3);
            }
            this.cRE.addAll(arrayList);
        }
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean eh(long j) {
        if (j == 0 || this.cRE == null || this.cRE.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.cRE.iterator();
        while (it.hasNext()) {
            UserData next = it.next();
            if (next != null && next.getUserIdLong() == j) {
                this.cRE.remove(next);
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eGy) {
            return 1;
        }
        int i = 0;
        if (this.cRE != null) {
            i = this.cRE.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cRE == null || i >= this.cRE.size()) {
            return null;
        }
        return this.cRE.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.cRE == null || i >= this.cRE.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final a aVar;
        View view2;
        if (this.cRE != null) {
            int itemViewType = getItemViewType(i);
            if (view == null || !(view.getTag() instanceof a)) {
                aVar = new a();
                if (itemViewType == 0) {
                    View inflate = LayoutInflater.from(this.ilN.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar.erM = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar.erM.setOnClickListener(this.eHB);
                    aVar.ilR = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar.ilR.setRadius(l.getDimens(this.ilN.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar.ilR.setAutoChangeStyle(true);
                    aVar.ilR.setClickable(false);
                    ((LinearLayout.LayoutParams) aVar.ilR.getLayoutParams()).setMargins(l.getDimens(this.ilN, R.dimen.ds34), 0, 0, 0);
                    aVar.eHE = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar.mName.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.myAttentionAndFans.c.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            Layout layout = aVar.mName.getLayout();
                            if (layout != null) {
                                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                                    aVar.mName.setCompoundDrawablePadding(l.getDimens(c.this.ilN, R.dimen.tbds10));
                                } else {
                                    aVar.mName.setCompoundDrawablePadding(0);
                                }
                            }
                        }
                    });
                    aVar.ilS = com.baidu.tbadk.ala.b.avT().u(this.ilN.getPageContext().getPageActivity(), 5);
                    if (aVar.ilS != null) {
                        aVar.ilS.setVisibility(8);
                        aVar.mContainer.addView(aVar.ilS, 1);
                    }
                    aVar.eGC = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar.erQ = (TextView) inflate.findViewById(R.id.intro);
                    aVar.ilT = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar.ilT.setContext(this.ilN.getPageContext());
                    ((LinearLayout.LayoutParams) aVar.ilT.getLayoutParams()).setMargins(0, 0, l.getDimens(this.ilN, R.dimen.ds34), 0);
                    aVar.MX = new com.baidu.tbadk.core.view.userLike.c(this.ilN.getPageContext(), aVar.ilT);
                    aVar.MX.a((com.baidu.tbadk.core.view.userLike.a) v.getItem(this.cRE, i));
                    aVar.MX.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.c.2
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void fJ(boolean z) {
                            if (z) {
                                l.showToast(c.this.ilN, (int) R.string.attention_success);
                            } else {
                                l.showToast(c.this.ilN, (int) R.string.unfollow_success);
                            }
                        }
                    });
                    aVar.mProgress = null;
                    aVar.mTitle = null;
                    aVar.ilU = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    view2 = inflate;
                } else if (itemViewType == 2) {
                    View inflate2 = LayoutInflater.from(this.ilN.getPageContext().getPageActivity()).inflate(R.layout.my_fan_list_title, (ViewGroup) null);
                    aVar.mTitle = (TextView) inflate2.findViewById(R.id.my_new_fan_title);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.ilN.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.ilO);
                    aVar.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar.mTitle = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar);
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.ilT != null) {
                aVar.ilT.setTag(Integer.valueOf(i));
            }
            if (itemViewType == 0) {
                if (this.eGy) {
                    aVar.eHE.setVisibility(8);
                    aVar.eGC.setVisibility(0);
                    if (this.eGA) {
                        aVar.eGC.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.eGC.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.eGC.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.eGC.setText(R.string.no_fan_other);
                    }
                } else {
                    aVar.erM.setTag(Integer.valueOf(i));
                    UserData userData = (UserData) v.getItem(this.cRE, i);
                    if (userData != null) {
                        aVar.eGC.setVisibility(8);
                        UtilHelper.showHeadImageViewBigV(aVar.ilR, userData, 0);
                        aVar.mName.setText(UtilHelper.getUserName(userData));
                        aVar.ilR.setPlaceHolder(1);
                        aVar.ilR.startLoad(userData.getAvater(), 12, false);
                        if (aVar.ilS != null && userData.getAlaUserData() != null) {
                            if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                                aVar.ilS.setVisibility(8);
                            } else {
                                aVar.ilS.setVisibility(0);
                                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                                aVar2.cFA = userData.getAlaUserData();
                                aVar2.type = 5;
                                aVar.ilS.setTag(aVar2);
                            }
                        }
                        if (aq.isEmpty(userData.getIntro())) {
                            aVar.erQ.setVisibility(8);
                        } else {
                            aVar.erQ.setVisibility(0);
                            aVar.erQ.setText(userData.getIntro());
                        }
                        String userId = userData.getUserId();
                        userData.setIsLike(userData.getHave_attention() > 0);
                        aVar.MX.a(userData);
                        if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            aVar.ilT.setVisibility(8);
                        } else {
                            aVar.ilT.setStatsParams(2, userId);
                            aVar.MX.sk(PublishType.TYPE_VIDEO_SHARE);
                            aVar.ilT.setVisibility(0);
                        }
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.ilU.getLayoutParams();
                if (v.getItem(this.cRE, i) != null && ((UserData) v.getItem(this.cRE, i)).isLastNewFan) {
                    layoutParams.height = l.getDimens(this.ilN, R.dimen.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                    aVar.ilU.setVisibility(0);
                } else {
                    aVar.ilU.setVisibility(8);
                    layoutParams.height = l.getDimens(this.ilN, R.dimen.ds1);
                    layoutParams.setMargins(l.getDimens(this.ilN, R.dimen.ds34), 0, l.getDimens(this.ilN, R.dimen.ds34), 0);
                }
                aVar.ilU.setLayoutParams(layoutParams);
                aVar.mProgress = null;
            } else if (itemViewType == 2) {
                aVar.mTitle.setText(R.string.new_fans);
                aVar.mTitle.setVisibility(0);
            } else {
                aVar.mName.setText(this.ilN.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.ilN.getLayoutMode().setNightMode(skinType == 1);
        this.ilN.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.mTitle != null) {
                am.setViewTextColor(aVar.mTitle, (int) R.color.cp_cont_d);
                am.setBackgroundColor(aVar.mTitle, R.color.cp_bg_line_e);
            }
            if (aVar.ilU != null) {
                am.setImageResource(aVar.ilU, R.color.cp_bg_line_c);
            }
            if (aVar.ilT != null) {
                aVar.ilT.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.eGy) {
            return 0;
        }
        if (this.cRE == null || i >= this.cRE.size()) {
            return 1;
        }
        return this.cRE.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.eGy) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c MX;
        TextView eGC;
        LinearLayout eHE;
        ViewGroup erM;
        TextView erQ;
        ClickableHeaderImageView ilR;
        View ilS;
        MyFansUserLikeButton ilT;
        ImageView ilU;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
