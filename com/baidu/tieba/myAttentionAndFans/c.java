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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class c extends b {
    private View.OnClickListener egY;
    boolean fTR;
    private PersonListActivity hqT;
    private View.OnClickListener hqU;
    private int mSex;

    public c(PersonListActivity personListActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.hqT = null;
        this.fTR = true;
        this.mSex = 0;
        this.hqU = null;
        this.egY = null;
        this.hqT = personListActivity;
        this.fTR = z;
        this.mSex = i;
        this.hqU = onClickListener2;
        this.egY = onClickListener;
        this.aHF = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(as asVar) {
        if (asVar != null && asVar.acs() != null) {
            Iterator<UserData> it = asVar.acs().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null) {
                    next.setIsLike(next.getHave_attention() > 0);
                }
            }
            ArrayList arrayList = new ArrayList();
            if (this.aHF == null) {
                this.aHF = new ArrayList<>();
            }
            arrayList.addAll(asVar.acs());
            if (!v.aa(this.aHF) && this.aHF.get(this.aHF.size() - 1) != null && this.aHF.get(this.aHF.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                this.aHF.get(this.aHF.size() - 1).isLastNewFan = true;
            } else {
                for (int i = 0; i < arrayList.size() - 1; i++) {
                    UserData userData = (UserData) arrayList.get(i);
                    UserData userData2 = (UserData) arrayList.get(i + 1);
                    if (userData != null && userData2 != null && userData.isNewFan && !userData2.isNewFan) {
                        userData.isLastNewFan = true;
                    }
                }
            }
            if (v.aa(this.aHF) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                UserData userData3 = new UserData();
                userData3.mAttentionType = 0;
                arrayList.add(0, userData3);
            }
            this.aHF.addAll(arrayList);
        }
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean dU(long j) {
        if (j == 0 || this.aHF == null || this.aHF.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.aHF.iterator();
        while (it.hasNext()) {
            UserData next = it.next();
            if (next != null && next.getUserIdLong() == j) {
                this.aHF.remove(next);
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hqS) {
            return 1;
        }
        int i = 0;
        if (this.aHF != null) {
            i = this.aHF.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aHF == null || i >= this.aHF.size()) {
            return null;
        }
        return this.aHF.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.aHF == null || i >= this.aHF.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.aHF != null) {
            int itemViewType = getItemViewType(i);
            if (view == null || !(view.getTag() instanceof a)) {
                aVar = new a();
                if (itemViewType == 0) {
                    View inflate = LayoutInflater.from(this.hqT.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar.dwr = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar.dwr.setOnClickListener(this.egY);
                    aVar.dwu = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar.dwu.setRadius(l.g(this.hqT.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar.dwu.setAutoChangeStyle(true);
                    aVar.dwu.setClickable(false);
                    ((LinearLayout.LayoutParams) aVar.dwu.getLayoutParams()).setMargins(l.g(this.hqT, R.dimen.ds34), 0, 0, 0);
                    aVar.dww = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar.bZi = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar.hqW = com.baidu.tbadk.ala.b.Zl().n(this.hqT.getPageContext().getPageActivity(), 5);
                    if (aVar.hqW != null) {
                        aVar.hqW.setVisibility(8);
                        aVar.bZi.addView(aVar.hqW, 1);
                    }
                    aVar.hqZ = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar.dwv = (TextView) inflate.findViewById(R.id.intro);
                    aVar.hqX = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar.hqX.setContext(this.hqT.getPageContext());
                    ((LinearLayout.LayoutParams) aVar.hqX.getLayoutParams()).setMargins(0, 0, l.g(this.hqT, R.dimen.ds34), 0);
                    aVar.ewY = new com.baidu.tbadk.core.view.userLike.c(this.hqT.getPageContext(), aVar.hqX);
                    aVar.ewY.a((com.baidu.tbadk.core.view.userLike.a) v.c(this.aHF, i));
                    aVar.ewY.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.c.1
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void es(boolean z) {
                            if (z) {
                                l.showToast(c.this.hqT, (int) R.string.attention_success);
                            } else {
                                l.showToast(c.this.hqT, (int) R.string.unfollow_success);
                            }
                        }
                    });
                    aVar.mProgress = null;
                    aVar.mTitle = null;
                    aVar.hqY = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    view2 = inflate;
                } else if (itemViewType == 2) {
                    View inflate2 = LayoutInflater.from(this.hqT.getPageContext().getPageActivity()).inflate(R.layout.my_fan_list_title, (ViewGroup) null);
                    aVar.mTitle = (TextView) inflate2.findViewById(R.id.my_new_fan_title);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.hqT.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.hqU);
                    aVar.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar.mTitle = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar);
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.hqX != null) {
                aVar.hqX.setTag(Integer.valueOf(i));
            }
            if (itemViewType == 0) {
                if (this.hqS) {
                    aVar.dww.setVisibility(8);
                    aVar.hqZ.setVisibility(0);
                    if (this.fTR) {
                        aVar.hqZ.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.hqZ.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.hqZ.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.hqZ.setText(R.string.no_fan_other);
                    }
                } else {
                    aVar.dwr.setTag(Integer.valueOf(i));
                    UserData userData = (UserData) v.c(this.aHF, i);
                    if (userData != null) {
                        aVar.hqZ.setVisibility(8);
                        aVar.dwu.setIsGod(userData.isBigV());
                        aVar.dwu.startLoad(userData.getPortrait(), 12, false);
                        aVar.mName.setText(userData.getName_show());
                        if (aVar.hqW != null && userData.getAlaUserData() != null) {
                            if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                                aVar.hqW.setVisibility(8);
                            } else {
                                aVar.hqW.setVisibility(0);
                                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                                aVar2.bzQ = userData.getAlaUserData();
                                aVar2.type = 5;
                                aVar.hqW.setTag(aVar2);
                            }
                        }
                        if (ap.isEmpty(userData.getIntro())) {
                            aVar.dwv.setVisibility(8);
                        } else {
                            aVar.dwv.setVisibility(0);
                            aVar.dwv.setText(userData.getIntro());
                        }
                        String userId = userData.getUserId();
                        userData.setIsLike(userData.getHave_attention() > 0);
                        aVar.ewY.a(userData);
                        if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            aVar.hqX.setVisibility(8);
                        } else {
                            aVar.hqX.setStatsParams(2, userId);
                            aVar.ewY.setFromType("9");
                            aVar.hqX.setVisibility(0);
                        }
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.hqY.getLayoutParams();
                if (v.c(this.aHF, i) != null && ((UserData) v.c(this.aHF, i)).isLastNewFan) {
                    layoutParams.height = l.g(this.hqT, R.dimen.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                } else {
                    layoutParams.height = l.g(this.hqT, R.dimen.ds1);
                    layoutParams.setMargins(l.g(this.hqT, R.dimen.ds34), 0, l.g(this.hqT, R.dimen.ds34), 0);
                }
                aVar.hqY.setLayoutParams(layoutParams);
                aVar.mProgress = null;
            } else if (itemViewType == 2) {
                aVar.mTitle.setText(R.string.new_fans);
                aVar.mTitle.setVisibility(0);
            } else {
                aVar.mName.setText(this.hqT.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.hqT.getLayoutMode().setNightMode(skinType == 1);
        this.hqT.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.mTitle != null) {
                al.j(aVar.mTitle, R.color.cp_cont_d);
                al.l(aVar.mTitle, R.color.cp_bg_line_d);
            }
            if (aVar.hqY != null) {
                al.c(aVar.hqY, (int) R.color.cp_bg_line_c);
            }
            if (aVar.hqX != null) {
                aVar.hqX.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.hqS) {
            return 0;
        }
        if (this.aHF == null || i >= this.aHF.size()) {
            return 1;
        }
        return this.aHF.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.hqS) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a {
        LinearLayout bZi;
        ViewGroup dwr;
        ClickableHeaderImageView dwu;
        TextView dwv;
        LinearLayout dww;
        com.baidu.tbadk.core.view.userLike.c ewY;
        View hqW;
        MyFansUserLikeButton hqX;
        ImageView hqY;
        TextView hqZ;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
