package com.baidu.tieba.myAttentionAndFans;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class c extends b {
    boolean dRK;
    private View.OnClickListener dSL;
    private PersonListActivity hyH;
    private View.OnClickListener hyI;
    private int mSex;

    public c(PersonListActivity personListActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.hyH = null;
        this.dRK = true;
        this.mSex = 0;
        this.hyI = null;
        this.dSL = null;
        this.hyH = personListActivity;
        this.dRK = z;
        this.mSex = i;
        this.hyI = onClickListener2;
        this.dSL = onClickListener;
        this.bbZ = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(as asVar) {
        if (asVar != null && asVar.ahD() != null) {
            Iterator<UserData> it = asVar.ahD().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null) {
                    next.setIsLike(next.getHave_attention() > 0);
                }
            }
            ArrayList arrayList = new ArrayList();
            if (this.bbZ == null) {
                this.bbZ = new ArrayList<>();
            }
            arrayList.addAll(asVar.ahD());
            if (!v.isEmpty(this.bbZ) && this.bbZ.get(this.bbZ.size() - 1) != null && this.bbZ.get(this.bbZ.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                this.bbZ.get(this.bbZ.size() - 1).isLastNewFan = true;
            } else {
                for (int i = 0; i < arrayList.size() - 1; i++) {
                    UserData userData = (UserData) arrayList.get(i);
                    UserData userData2 = (UserData) arrayList.get(i + 1);
                    if (userData != null && userData2 != null && userData.isNewFan && !userData2.isNewFan) {
                        userData.isLastNewFan = true;
                    }
                }
            }
            if (v.isEmpty(this.bbZ) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                UserData userData3 = new UserData();
                userData3.mAttentionType = 0;
                arrayList.add(0, userData3);
            }
            this.bbZ.addAll(arrayList);
        }
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean dC(long j) {
        if (j == 0 || this.bbZ == null || this.bbZ.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.bbZ.iterator();
        while (it.hasNext()) {
            UserData next = it.next();
            if (next != null && next.getUserIdLong() == j) {
                this.bbZ.remove(next);
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dRI) {
            return 1;
        }
        int i = 0;
        if (this.bbZ != null) {
            i = this.bbZ.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bbZ == null || i >= this.bbZ.size()) {
            return null;
        }
        return this.bbZ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.bbZ == null || i >= this.bbZ.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.bbZ != null) {
            int itemViewType = getItemViewType(i);
            if (view == null || !(view.getTag() instanceof a)) {
                aVar = new a();
                if (itemViewType == 0) {
                    View inflate = LayoutInflater.from(this.hyH.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar.dGA = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar.dGA.setOnClickListener(this.dSL);
                    aVar.hyK = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar.hyK.setRadius(l.getDimens(this.hyH.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar.hyK.setAutoChangeStyle(true);
                    aVar.hyK.setClickable(false);
                    ((LinearLayout.LayoutParams) aVar.hyK.getLayoutParams()).setMargins(l.getDimens(this.hyH, R.dimen.ds34), 0, 0, 0);
                    aVar.dSO = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar.hyL = com.baidu.tbadk.ala.b.afc().l(this.hyH.getPageContext().getPageActivity(), 5);
                    if (aVar.hyL != null) {
                        aVar.hyL.setVisibility(8);
                        aVar.mContainer.addView(aVar.hyL, 1);
                    }
                    aVar.dRM = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar.dGE = (TextView) inflate.findViewById(R.id.intro);
                    aVar.hyM = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar.hyM.setContext(this.hyH.getPageContext());
                    ((LinearLayout.LayoutParams) aVar.hyM.getLayoutParams()).setMargins(0, 0, l.getDimens(this.hyH, R.dimen.ds34), 0);
                    aVar.eMu = new com.baidu.tbadk.core.view.userLike.c(this.hyH.getPageContext(), aVar.hyM);
                    aVar.eMu.a((com.baidu.tbadk.core.view.userLike.a) v.getItem(this.bbZ, i));
                    aVar.eMu.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.c.1
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void ex(boolean z) {
                            if (z) {
                                l.showToast(c.this.hyH, (int) R.string.attention_success);
                            } else {
                                l.showToast(c.this.hyH, (int) R.string.unfollow_success);
                            }
                        }
                    });
                    aVar.mProgress = null;
                    aVar.mTitle = null;
                    aVar.hyN = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    view2 = inflate;
                } else if (itemViewType == 2) {
                    View inflate2 = LayoutInflater.from(this.hyH.getPageContext().getPageActivity()).inflate(R.layout.my_fan_list_title, (ViewGroup) null);
                    aVar.mTitle = (TextView) inflate2.findViewById(R.id.my_new_fan_title);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.hyH.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.hyI);
                    aVar.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar.mTitle = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar);
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.hyM != null) {
                aVar.hyM.setTag(Integer.valueOf(i));
            }
            if (itemViewType == 0) {
                if (this.dRI) {
                    aVar.dSO.setVisibility(8);
                    aVar.dRM.setVisibility(0);
                    if (this.dRK) {
                        aVar.dRM.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.dRM.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.dRM.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.dRM.setText(R.string.no_fan_other);
                    }
                } else {
                    aVar.dGA.setTag(Integer.valueOf(i));
                    UserData userData = (UserData) v.getItem(this.bbZ, i);
                    if (userData != null) {
                        aVar.dRM.setVisibility(8);
                        aVar.hyK.setIsGod(userData.isBigV());
                        aVar.hyK.startLoad(userData.getPortrait(), 12, false);
                        aVar.mName.setText(userData.getName_show());
                        if (aVar.hyL != null && userData.getAlaUserData() != null) {
                            if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                                aVar.hyL.setVisibility(8);
                            } else {
                                aVar.hyL.setVisibility(0);
                                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                                aVar2.bTT = userData.getAlaUserData();
                                aVar2.type = 5;
                                aVar.hyL.setTag(aVar2);
                            }
                        }
                        if (aq.isEmpty(userData.getIntro())) {
                            aVar.dGE.setVisibility(8);
                        } else {
                            aVar.dGE.setVisibility(0);
                            aVar.dGE.setText(userData.getIntro());
                        }
                        String userId = userData.getUserId();
                        userData.setIsLike(userData.getHave_attention() > 0);
                        aVar.eMu.a(userData);
                        if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            aVar.hyM.setVisibility(8);
                        } else {
                            aVar.hyM.setStatsParams(2, userId);
                            aVar.eMu.mX("9");
                            aVar.hyM.setVisibility(0);
                        }
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.hyN.getLayoutParams();
                if (v.getItem(this.bbZ, i) != null && ((UserData) v.getItem(this.bbZ, i)).isLastNewFan) {
                    layoutParams.height = l.getDimens(this.hyH, R.dimen.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                    aVar.hyN.setVisibility(0);
                } else {
                    aVar.hyN.setVisibility(8);
                    layoutParams.height = l.getDimens(this.hyH, R.dimen.ds1);
                    layoutParams.setMargins(l.getDimens(this.hyH, R.dimen.ds34), 0, l.getDimens(this.hyH, R.dimen.ds34), 0);
                }
                aVar.hyN.setLayoutParams(layoutParams);
                aVar.mProgress = null;
            } else if (itemViewType == 2) {
                aVar.mTitle.setText(R.string.new_fans);
                aVar.mTitle.setVisibility(0);
            } else {
                aVar.mName.setText(this.hyH.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.hyH.getLayoutMode().setNightMode(skinType == 1);
        this.hyH.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.mTitle != null) {
                am.setViewTextColor(aVar.mTitle, (int) R.color.cp_cont_d);
                am.setBackgroundColor(aVar.mTitle, R.color.cp_bg_line_e);
            }
            if (aVar.hyN != null) {
                am.setImageResource(aVar.hyN, R.color.cp_bg_line_c);
            }
            if (aVar.hyM != null) {
                aVar.hyM.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.dRI) {
            return 0;
        }
        if (this.bbZ == null || i >= this.bbZ.size()) {
            return 1;
        }
        return this.bbZ.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.dRI) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a {
        ViewGroup dGA;
        TextView dGE;
        TextView dRM;
        LinearLayout dSO;
        com.baidu.tbadk.core.view.userLike.c eMu;
        ClickableHeaderImageView hyK;
        View hyL;
        MyFansUserLikeButton hyM;
        ImageView hyN;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
