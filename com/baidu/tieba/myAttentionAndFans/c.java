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
    private View.OnClickListener elC;
    boolean fYQ;
    private PersonListActivity hxg;
    private View.OnClickListener hxh;
    private int mSex;

    public c(PersonListActivity personListActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.hxg = null;
        this.fYQ = true;
        this.mSex = 0;
        this.hxh = null;
        this.elC = null;
        this.hxg = personListActivity;
        this.fYQ = z;
        this.mSex = i;
        this.hxh = onClickListener2;
        this.elC = onClickListener;
        this.aIn = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(as asVar) {
        if (asVar != null && asVar.adu() != null) {
            Iterator<UserData> it = asVar.adu().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null) {
                    next.setIsLike(next.getHave_attention() > 0);
                }
            }
            ArrayList arrayList = new ArrayList();
            if (this.aIn == null) {
                this.aIn = new ArrayList<>();
            }
            arrayList.addAll(asVar.adu());
            if (!v.aa(this.aIn) && this.aIn.get(this.aIn.size() - 1) != null && this.aIn.get(this.aIn.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                this.aIn.get(this.aIn.size() - 1).isLastNewFan = true;
            } else {
                for (int i = 0; i < arrayList.size() - 1; i++) {
                    UserData userData = (UserData) arrayList.get(i);
                    UserData userData2 = (UserData) arrayList.get(i + 1);
                    if (userData != null && userData2 != null && userData.isNewFan && !userData2.isNewFan) {
                        userData.isLastNewFan = true;
                    }
                }
            }
            if (v.aa(this.aIn) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                UserData userData3 = new UserData();
                userData3.mAttentionType = 0;
                arrayList.add(0, userData3);
            }
            this.aIn.addAll(arrayList);
        }
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean ee(long j) {
        if (j == 0 || this.aIn == null || this.aIn.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.aIn.iterator();
        while (it.hasNext()) {
            UserData next = it.next();
            if (next != null && next.getUserIdLong() == j) {
                this.aIn.remove(next);
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hxf) {
            return 1;
        }
        int i = 0;
        if (this.aIn != null) {
            i = this.aIn.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aIn == null || i >= this.aIn.size()) {
            return null;
        }
        return this.aIn.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.aIn == null || i >= this.aIn.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.aIn != null) {
            int itemViewType = getItemViewType(i);
            if (view == null || !(view.getTag() instanceof a)) {
                aVar = new a();
                if (itemViewType == 0) {
                    View inflate = LayoutInflater.from(this.hxg.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar.dzp = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar.dzp.setOnClickListener(this.elC);
                    aVar.dzs = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar.dzs.setRadius(l.g(this.hxg.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar.dzs.setAutoChangeStyle(true);
                    aVar.dzs.setClickable(false);
                    ((LinearLayout.LayoutParams) aVar.dzs.getLayoutParams()).setMargins(l.g(this.hxg, R.dimen.ds34), 0, 0, 0);
                    aVar.dzu = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar.cal = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar.hxj = com.baidu.tbadk.ala.b.aak().n(this.hxg.getPageContext().getPageActivity(), 5);
                    if (aVar.hxj != null) {
                        aVar.hxj.setVisibility(8);
                        aVar.cal.addView(aVar.hxj, 1);
                    }
                    aVar.hxm = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar.dzt = (TextView) inflate.findViewById(R.id.intro);
                    aVar.hxk = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar.hxk.setContext(this.hxg.getPageContext());
                    ((LinearLayout.LayoutParams) aVar.hxk.getLayoutParams()).setMargins(0, 0, l.g(this.hxg, R.dimen.ds34), 0);
                    aVar.eBX = new com.baidu.tbadk.core.view.userLike.c(this.hxg.getPageContext(), aVar.hxk);
                    aVar.eBX.a((com.baidu.tbadk.core.view.userLike.a) v.c(this.aIn, i));
                    aVar.eBX.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.c.1
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void ew(boolean z) {
                            if (z) {
                                l.showToast(c.this.hxg, (int) R.string.attention_success);
                            } else {
                                l.showToast(c.this.hxg, (int) R.string.unfollow_success);
                            }
                        }
                    });
                    aVar.mProgress = null;
                    aVar.mTitle = null;
                    aVar.hxl = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    view2 = inflate;
                } else if (itemViewType == 2) {
                    View inflate2 = LayoutInflater.from(this.hxg.getPageContext().getPageActivity()).inflate(R.layout.my_fan_list_title, (ViewGroup) null);
                    aVar.mTitle = (TextView) inflate2.findViewById(R.id.my_new_fan_title);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.hxg.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.hxh);
                    aVar.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar.mTitle = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar);
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.hxk != null) {
                aVar.hxk.setTag(Integer.valueOf(i));
            }
            if (itemViewType == 0) {
                if (this.hxf) {
                    aVar.dzu.setVisibility(8);
                    aVar.hxm.setVisibility(0);
                    if (this.fYQ) {
                        aVar.hxm.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.hxm.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.hxm.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.hxm.setText(R.string.no_fan_other);
                    }
                } else {
                    aVar.dzp.setTag(Integer.valueOf(i));
                    UserData userData = (UserData) v.c(this.aIn, i);
                    if (userData != null) {
                        aVar.hxm.setVisibility(8);
                        aVar.dzs.setIsGod(userData.isBigV());
                        aVar.dzs.startLoad(userData.getPortrait(), 12, false);
                        aVar.mName.setText(userData.getName_show());
                        if (aVar.hxj != null && userData.getAlaUserData() != null) {
                            if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                                aVar.hxj.setVisibility(8);
                            } else {
                                aVar.hxj.setVisibility(0);
                                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                                aVar2.bAN = userData.getAlaUserData();
                                aVar2.type = 5;
                                aVar.hxj.setTag(aVar2);
                            }
                        }
                        if (aq.isEmpty(userData.getIntro())) {
                            aVar.dzt.setVisibility(8);
                        } else {
                            aVar.dzt.setVisibility(0);
                            aVar.dzt.setText(userData.getIntro());
                        }
                        String userId = userData.getUserId();
                        userData.setIsLike(userData.getHave_attention() > 0);
                        aVar.eBX.a(userData);
                        if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            aVar.hxk.setVisibility(8);
                        } else {
                            aVar.hxk.setStatsParams(2, userId);
                            aVar.eBX.setFromType("9");
                            aVar.hxk.setVisibility(0);
                        }
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.hxl.getLayoutParams();
                if (v.c(this.aIn, i) != null && ((UserData) v.c(this.aIn, i)).isLastNewFan) {
                    layoutParams.height = l.g(this.hxg, R.dimen.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                } else {
                    layoutParams.height = l.g(this.hxg, R.dimen.ds1);
                    layoutParams.setMargins(l.g(this.hxg, R.dimen.ds34), 0, l.g(this.hxg, R.dimen.ds34), 0);
                }
                aVar.hxl.setLayoutParams(layoutParams);
                aVar.mProgress = null;
            } else if (itemViewType == 2) {
                aVar.mTitle.setText(R.string.new_fans);
                aVar.mTitle.setVisibility(0);
            } else {
                aVar.mName.setText(this.hxg.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.hxg.getLayoutMode().setNightMode(skinType == 1);
        this.hxg.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.mTitle != null) {
                am.j(aVar.mTitle, R.color.cp_cont_d);
                am.l(aVar.mTitle, R.color.cp_bg_line_d);
            }
            if (aVar.hxl != null) {
                am.c(aVar.hxl, (int) R.color.cp_bg_line_c);
            }
            if (aVar.hxk != null) {
                aVar.hxk.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.hxf) {
            return 0;
        }
        if (this.aIn == null || i >= this.aIn.size()) {
            return 1;
        }
        return this.aIn.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.hxf) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a {
        LinearLayout cal;
        ViewGroup dzp;
        ClickableHeaderImageView dzs;
        TextView dzt;
        LinearLayout dzu;
        com.baidu.tbadk.core.view.userLike.c eBX;
        View hxj;
        MyFansUserLikeButton hxk;
        ImageView hxl;
        TextView hxm;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
