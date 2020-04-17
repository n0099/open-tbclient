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
    boolean fqG;
    private View.OnClickListener frJ;
    private PersonListActivity jdh;
    private View.OnClickListener jdi;
    private int mSex;

    public c(PersonListActivity personListActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.jdh = null;
        this.fqG = true;
        this.mSex = 0;
        this.jdi = null;
        this.frJ = null;
        this.jdh = personListActivity;
        this.fqG = z;
        this.mSex = i;
        this.jdi = onClickListener2;
        this.frJ = onClickListener;
        this.dvq = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(av avVar) {
        if (avVar != null && avVar.aJD() != null) {
            Iterator<UserData> it = avVar.aJD().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null) {
                    next.setIsLike(next.getHave_attention() > 0);
                }
            }
            ArrayList arrayList = new ArrayList();
            if (this.dvq == null) {
                this.dvq = new ArrayList<>();
            }
            arrayList.addAll(avVar.aJD());
            if (!v.isEmpty(this.dvq) && this.dvq.get(this.dvq.size() - 1) != null && this.dvq.get(this.dvq.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                this.dvq.get(this.dvq.size() - 1).isLastNewFan = true;
            } else {
                for (int i = 0; i < arrayList.size() - 1; i++) {
                    UserData userData = (UserData) arrayList.get(i);
                    UserData userData2 = (UserData) arrayList.get(i + 1);
                    if (userData != null && userData2 != null && userData.isNewFan && !userData2.isNewFan) {
                        userData.isLastNewFan = true;
                    }
                }
            }
            if (v.isEmpty(this.dvq) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                UserData userData3 = new UserData();
                userData3.mAttentionType = 0;
                arrayList.add(0, userData3);
            }
            this.dvq.addAll(arrayList);
        }
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean eX(long j) {
        if (j == 0 || this.dvq == null || this.dvq.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.dvq.iterator();
        while (it.hasNext()) {
            UserData next = it.next();
            if (next != null && next.getUserIdLong() == j) {
                this.dvq.remove(next);
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fqE) {
            return 1;
        }
        int i = 0;
        if (this.dvq != null) {
            i = this.dvq.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dvq == null || i >= this.dvq.size()) {
            return null;
        }
        return this.dvq.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.dvq == null || i >= this.dvq.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final a aVar;
        View view2;
        if (this.dvq != null) {
            int itemViewType = getItemViewType(i);
            if (view == null || !(view.getTag() instanceof a)) {
                aVar = new a();
                if (itemViewType == 0) {
                    View inflate = LayoutInflater.from(this.jdh.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar.fbZ = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar.fbZ.setOnClickListener(this.frJ);
                    aVar.jdl = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar.jdl.setRadius(l.getDimens(this.jdh.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar.jdl.setAutoChangeStyle(true);
                    aVar.jdl.setClickable(false);
                    ((LinearLayout.LayoutParams) aVar.jdl.getLayoutParams()).setMargins(l.getDimens(this.jdh, R.dimen.ds34), 0, 0, 0);
                    aVar.frM = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar.mName.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.myAttentionAndFans.c.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            Layout layout = aVar.mName.getLayout();
                            if (layout != null) {
                                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                                    aVar.mName.setCompoundDrawablePadding(l.getDimens(c.this.jdh, R.dimen.tbds10));
                                } else {
                                    aVar.mName.setCompoundDrawablePadding(0);
                                }
                            }
                        }
                    });
                    aVar.jdm = com.baidu.tbadk.ala.b.aGP().p(this.jdh.getPageContext().getPageActivity(), 5);
                    if (aVar.jdm != null) {
                        aVar.jdm.setVisibility(8);
                        aVar.mContainer.addView(aVar.jdm, 1);
                    }
                    aVar.fqI = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar.fcd = (TextView) inflate.findViewById(R.id.intro);
                    aVar.jdn = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar.jdn.setContext(this.jdh.getPageContext());
                    ((LinearLayout.LayoutParams) aVar.jdn.getLayoutParams()).setMargins(0, 0, l.getDimens(this.jdh, R.dimen.ds34), 0);
                    aVar.agm = new com.baidu.tbadk.core.view.userLike.c(this.jdh.getPageContext(), aVar.jdn);
                    aVar.agm.a((com.baidu.tbadk.core.view.userLike.a) v.getItem(this.dvq, i));
                    aVar.agm.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.c.2
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void gU(boolean z) {
                            if (z) {
                                l.showToast(c.this.jdh, (int) R.string.attention_success);
                            } else {
                                l.showToast(c.this.jdh, (int) R.string.unfollow_success);
                            }
                        }
                    });
                    aVar.mProgress = null;
                    aVar.mTitle = null;
                    aVar.jdo = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    view2 = inflate;
                } else if (itemViewType == 2) {
                    View inflate2 = LayoutInflater.from(this.jdh.getPageContext().getPageActivity()).inflate(R.layout.my_fan_list_title, (ViewGroup) null);
                    aVar.mTitle = (TextView) inflate2.findViewById(R.id.my_new_fan_title);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.jdh.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.jdi);
                    aVar.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar.mTitle = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar);
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.jdn != null) {
                aVar.jdn.setTag(Integer.valueOf(i));
            }
            if (itemViewType == 0) {
                if (this.fqE) {
                    aVar.frM.setVisibility(8);
                    aVar.fqI.setVisibility(0);
                    if (this.fqG) {
                        aVar.fqI.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.fqI.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.fqI.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.fqI.setText(R.string.no_fan_other);
                    }
                } else {
                    aVar.fbZ.setTag(Integer.valueOf(i));
                    UserData userData = (UserData) v.getItem(this.dvq, i);
                    if (userData != null) {
                        aVar.fqI.setVisibility(8);
                        UtilHelper.showHeadImageViewBigV(aVar.jdl, userData, 0);
                        aVar.mName.setText(UtilHelper.getUserName(userData));
                        aVar.jdl.setPlaceHolder(1);
                        aVar.jdl.startLoad(userData.getAvater(), 12, false);
                        if (aVar.jdm != null && userData.getAlaUserData() != null) {
                            if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                                aVar.jdm.setVisibility(8);
                            } else {
                                aVar.jdm.setVisibility(0);
                                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                                aVar2.djj = userData.getAlaUserData();
                                aVar2.type = 5;
                                aVar.jdm.setTag(aVar2);
                            }
                        }
                        if (aq.isEmpty(userData.getIntro())) {
                            aVar.fcd.setVisibility(8);
                        } else {
                            aVar.fcd.setVisibility(0);
                            aVar.fcd.setText(userData.getIntro());
                        }
                        String userId = userData.getUserId();
                        userData.setIsLike(userData.getHave_attention() > 0);
                        aVar.agm.a(userData);
                        if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            aVar.jdn.setVisibility(8);
                        } else {
                            aVar.jdn.setStatsParams(2, userId);
                            aVar.agm.tR("9");
                            aVar.jdn.setVisibility(0);
                        }
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.jdo.getLayoutParams();
                if (v.getItem(this.dvq, i) != null && ((UserData) v.getItem(this.dvq, i)).isLastNewFan) {
                    layoutParams.height = l.getDimens(this.jdh, R.dimen.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                    aVar.jdo.setVisibility(0);
                } else {
                    aVar.jdo.setVisibility(8);
                    layoutParams.height = l.getDimens(this.jdh, R.dimen.ds1);
                    layoutParams.setMargins(l.getDimens(this.jdh, R.dimen.ds34), 0, l.getDimens(this.jdh, R.dimen.ds34), 0);
                }
                aVar.jdo.setLayoutParams(layoutParams);
                aVar.mProgress = null;
            } else if (itemViewType == 2) {
                aVar.mTitle.setText(R.string.new_fans);
                aVar.mTitle.setVisibility(0);
            } else {
                aVar.mName.setText(this.jdh.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.jdh.getLayoutMode().setNightMode(skinType == 1);
        this.jdh.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.mTitle != null) {
                am.setViewTextColor(aVar.mTitle, (int) R.color.cp_cont_d);
                am.setBackgroundColor(aVar.mTitle, R.color.cp_bg_line_e);
            }
            if (aVar.jdo != null) {
                am.setImageResource(aVar.jdo, R.color.cp_bg_line_c);
            }
            if (aVar.jdn != null) {
                aVar.jdn.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fqE) {
            return 0;
        }
        if (this.dvq == null || i >= this.dvq.size()) {
            return 1;
        }
        return this.dvq.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fqE) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c agm;
        ViewGroup fbZ;
        TextView fcd;
        TextView fqI;
        LinearLayout frM;
        ClickableHeaderImageView jdl;
        View jdm;
        MyFansUserLikeButton jdn;
        ImageView jdo;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
