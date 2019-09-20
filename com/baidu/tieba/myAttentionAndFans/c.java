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
    private View.OnClickListener enu;
    boolean gbx;
    private PersonListActivity hzU;
    private View.OnClickListener hzV;
    private int mSex;

    public c(PersonListActivity personListActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.hzU = null;
        this.gbx = true;
        this.mSex = 0;
        this.hzV = null;
        this.enu = null;
        this.hzU = personListActivity;
        this.gbx = z;
        this.mSex = i;
        this.hzV = onClickListener2;
        this.enu = onClickListener;
        this.aIL = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(as asVar) {
        if (asVar != null && asVar.adz() != null) {
            Iterator<UserData> it = asVar.adz().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null) {
                    next.setIsLike(next.getHave_attention() > 0);
                }
            }
            ArrayList arrayList = new ArrayList();
            if (this.aIL == null) {
                this.aIL = new ArrayList<>();
            }
            arrayList.addAll(asVar.adz());
            if (!v.aa(this.aIL) && this.aIL.get(this.aIL.size() - 1) != null && this.aIL.get(this.aIL.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                this.aIL.get(this.aIL.size() - 1).isLastNewFan = true;
            } else {
                for (int i = 0; i < arrayList.size() - 1; i++) {
                    UserData userData = (UserData) arrayList.get(i);
                    UserData userData2 = (UserData) arrayList.get(i + 1);
                    if (userData != null && userData2 != null && userData.isNewFan && !userData2.isNewFan) {
                        userData.isLastNewFan = true;
                    }
                }
            }
            if (v.aa(this.aIL) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                UserData userData3 = new UserData();
                userData3.mAttentionType = 0;
                arrayList.add(0, userData3);
            }
            this.aIL.addAll(arrayList);
        }
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean eh(long j) {
        if (j == 0 || this.aIL == null || this.aIL.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.aIL.iterator();
        while (it.hasNext()) {
            UserData next = it.next();
            if (next != null && next.getUserIdLong() == j) {
                this.aIL.remove(next);
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hzT) {
            return 1;
        }
        int i = 0;
        if (this.aIL != null) {
            i = this.aIL.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aIL == null || i >= this.aIL.size()) {
            return null;
        }
        return this.aIL.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.aIL == null || i >= this.aIL.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.aIL != null) {
            int itemViewType = getItemViewType(i);
            if (view == null || !(view.getTag() instanceof a)) {
                aVar = new a();
                if (itemViewType == 0) {
                    View inflate = LayoutInflater.from(this.hzU.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar.dBh = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar.dBh.setOnClickListener(this.enu);
                    aVar.dBk = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar.dBk.setRadius(l.g(this.hzU.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar.dBk.setAutoChangeStyle(true);
                    aVar.dBk.setClickable(false);
                    ((LinearLayout.LayoutParams) aVar.dBk.getLayoutParams()).setMargins(l.g(this.hzU, R.dimen.ds34), 0, 0, 0);
                    aVar.dBm = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar.cbk = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar.hzX = com.baidu.tbadk.ala.b.aao().n(this.hzU.getPageContext().getPageActivity(), 5);
                    if (aVar.hzX != null) {
                        aVar.hzX.setVisibility(8);
                        aVar.cbk.addView(aVar.hzX, 1);
                    }
                    aVar.hAa = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar.dBl = (TextView) inflate.findViewById(R.id.intro);
                    aVar.hzY = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar.hzY.setContext(this.hzU.getPageContext());
                    ((LinearLayout.LayoutParams) aVar.hzY.getLayoutParams()).setMargins(0, 0, l.g(this.hzU, R.dimen.ds34), 0);
                    aVar.eDN = new com.baidu.tbadk.core.view.userLike.c(this.hzU.getPageContext(), aVar.hzY);
                    aVar.eDN.a((com.baidu.tbadk.core.view.userLike.a) v.c(this.aIL, i));
                    aVar.eDN.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.c.1
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void ez(boolean z) {
                            if (z) {
                                l.showToast(c.this.hzU, (int) R.string.attention_success);
                            } else {
                                l.showToast(c.this.hzU, (int) R.string.unfollow_success);
                            }
                        }
                    });
                    aVar.mProgress = null;
                    aVar.mTitle = null;
                    aVar.hzZ = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    view2 = inflate;
                } else if (itemViewType == 2) {
                    View inflate2 = LayoutInflater.from(this.hzU.getPageContext().getPageActivity()).inflate(R.layout.my_fan_list_title, (ViewGroup) null);
                    aVar.mTitle = (TextView) inflate2.findViewById(R.id.my_new_fan_title);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.hzU.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.hzV);
                    aVar.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar.mTitle = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar);
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.hzY != null) {
                aVar.hzY.setTag(Integer.valueOf(i));
            }
            if (itemViewType == 0) {
                if (this.hzT) {
                    aVar.dBm.setVisibility(8);
                    aVar.hAa.setVisibility(0);
                    if (this.gbx) {
                        aVar.hAa.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.hAa.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.hAa.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.hAa.setText(R.string.no_fan_other);
                    }
                } else {
                    aVar.dBh.setTag(Integer.valueOf(i));
                    UserData userData = (UserData) v.c(this.aIL, i);
                    if (userData != null) {
                        aVar.hAa.setVisibility(8);
                        aVar.dBk.setIsGod(userData.isBigV());
                        aVar.dBk.startLoad(userData.getPortrait(), 12, false);
                        aVar.mName.setText(userData.getName_show());
                        if (aVar.hzX != null && userData.getAlaUserData() != null) {
                            if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                                aVar.hzX.setVisibility(8);
                            } else {
                                aVar.hzX.setVisibility(0);
                                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                                aVar2.bBl = userData.getAlaUserData();
                                aVar2.type = 5;
                                aVar.hzX.setTag(aVar2);
                            }
                        }
                        if (aq.isEmpty(userData.getIntro())) {
                            aVar.dBl.setVisibility(8);
                        } else {
                            aVar.dBl.setVisibility(0);
                            aVar.dBl.setText(userData.getIntro());
                        }
                        String userId = userData.getUserId();
                        userData.setIsLike(userData.getHave_attention() > 0);
                        aVar.eDN.a(userData);
                        if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            aVar.hzY.setVisibility(8);
                        } else {
                            aVar.hzY.setStatsParams(2, userId);
                            aVar.eDN.setFromType("9");
                            aVar.hzY.setVisibility(0);
                        }
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.hzZ.getLayoutParams();
                if (v.c(this.aIL, i) != null && ((UserData) v.c(this.aIL, i)).isLastNewFan) {
                    layoutParams.height = l.g(this.hzU, R.dimen.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                    aVar.hzZ.setVisibility(0);
                } else {
                    aVar.hzZ.setVisibility(8);
                    layoutParams.height = l.g(this.hzU, R.dimen.ds1);
                    layoutParams.setMargins(l.g(this.hzU, R.dimen.ds34), 0, l.g(this.hzU, R.dimen.ds34), 0);
                }
                aVar.hzZ.setLayoutParams(layoutParams);
                aVar.mProgress = null;
            } else if (itemViewType == 2) {
                aVar.mTitle.setText(R.string.new_fans);
                aVar.mTitle.setVisibility(0);
            } else {
                aVar.mName.setText(this.hzU.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.hzU.getLayoutMode().setNightMode(skinType == 1);
        this.hzU.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.mTitle != null) {
                am.j(aVar.mTitle, R.color.cp_cont_d);
                am.l(aVar.mTitle, R.color.cp_bg_line_e);
            }
            if (aVar.hzZ != null) {
                am.c(aVar.hzZ, (int) R.color.cp_bg_line_c);
            }
            if (aVar.hzY != null) {
                aVar.hzY.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.hzT) {
            return 0;
        }
        if (this.aIL == null || i >= this.aIL.size()) {
            return 1;
        }
        return this.aIL.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.hzT) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a {
        LinearLayout cbk;
        ViewGroup dBh;
        ClickableHeaderImageView dBk;
        TextView dBl;
        LinearLayout dBm;
        com.baidu.tbadk.core.view.userLike.c eDN;
        TextView hAa;
        View hzX;
        MyFansUserLikeButton hzY;
        ImageView hzZ;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
