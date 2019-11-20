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
    boolean dQT;
    private View.OnClickListener dRU;
    private PersonListActivity hxQ;
    private View.OnClickListener hxR;
    private int mSex;

    public c(PersonListActivity personListActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.hxQ = null;
        this.dQT = true;
        this.mSex = 0;
        this.hxR = null;
        this.dRU = null;
        this.hxQ = personListActivity;
        this.dQT = z;
        this.mSex = i;
        this.hxR = onClickListener2;
        this.dRU = onClickListener;
        this.bbH = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(as asVar) {
        if (asVar != null && asVar.ahB() != null) {
            Iterator<UserData> it = asVar.ahB().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null) {
                    next.setIsLike(next.getHave_attention() > 0);
                }
            }
            ArrayList arrayList = new ArrayList();
            if (this.bbH == null) {
                this.bbH = new ArrayList<>();
            }
            arrayList.addAll(asVar.ahB());
            if (!v.isEmpty(this.bbH) && this.bbH.get(this.bbH.size() - 1) != null && this.bbH.get(this.bbH.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                this.bbH.get(this.bbH.size() - 1).isLastNewFan = true;
            } else {
                for (int i = 0; i < arrayList.size() - 1; i++) {
                    UserData userData = (UserData) arrayList.get(i);
                    UserData userData2 = (UserData) arrayList.get(i + 1);
                    if (userData != null && userData2 != null && userData.isNewFan && !userData2.isNewFan) {
                        userData.isLastNewFan = true;
                    }
                }
            }
            if (v.isEmpty(this.bbH) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                UserData userData3 = new UserData();
                userData3.mAttentionType = 0;
                arrayList.add(0, userData3);
            }
            this.bbH.addAll(arrayList);
        }
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean dB(long j) {
        if (j == 0 || this.bbH == null || this.bbH.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.bbH.iterator();
        while (it.hasNext()) {
            UserData next = it.next();
            if (next != null && next.getUserIdLong() == j) {
                this.bbH.remove(next);
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dQR) {
            return 1;
        }
        int i = 0;
        if (this.bbH != null) {
            i = this.bbH.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bbH == null || i >= this.bbH.size()) {
            return null;
        }
        return this.bbH.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.bbH == null || i >= this.bbH.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.bbH != null) {
            int itemViewType = getItemViewType(i);
            if (view == null || !(view.getTag() instanceof a)) {
                aVar = new a();
                if (itemViewType == 0) {
                    View inflate = LayoutInflater.from(this.hxQ.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar.dFJ = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar.dFJ.setOnClickListener(this.dRU);
                    aVar.hxT = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar.hxT.setRadius(l.getDimens(this.hxQ.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar.hxT.setAutoChangeStyle(true);
                    aVar.hxT.setClickable(false);
                    ((LinearLayout.LayoutParams) aVar.hxT.getLayoutParams()).setMargins(l.getDimens(this.hxQ, R.dimen.ds34), 0, 0, 0);
                    aVar.dRX = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar.hxU = com.baidu.tbadk.ala.b.afa().l(this.hxQ.getPageContext().getPageActivity(), 5);
                    if (aVar.hxU != null) {
                        aVar.hxU.setVisibility(8);
                        aVar.mContainer.addView(aVar.hxU, 1);
                    }
                    aVar.dQV = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar.dFN = (TextView) inflate.findViewById(R.id.intro);
                    aVar.hxV = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar.hxV.setContext(this.hxQ.getPageContext());
                    ((LinearLayout.LayoutParams) aVar.hxV.getLayoutParams()).setMargins(0, 0, l.getDimens(this.hxQ, R.dimen.ds34), 0);
                    aVar.eLD = new com.baidu.tbadk.core.view.userLike.c(this.hxQ.getPageContext(), aVar.hxV);
                    aVar.eLD.a((com.baidu.tbadk.core.view.userLike.a) v.getItem(this.bbH, i));
                    aVar.eLD.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.c.1
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void ex(boolean z) {
                            if (z) {
                                l.showToast(c.this.hxQ, (int) R.string.attention_success);
                            } else {
                                l.showToast(c.this.hxQ, (int) R.string.unfollow_success);
                            }
                        }
                    });
                    aVar.mProgress = null;
                    aVar.mTitle = null;
                    aVar.hxW = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    view2 = inflate;
                } else if (itemViewType == 2) {
                    View inflate2 = LayoutInflater.from(this.hxQ.getPageContext().getPageActivity()).inflate(R.layout.my_fan_list_title, (ViewGroup) null);
                    aVar.mTitle = (TextView) inflate2.findViewById(R.id.my_new_fan_title);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.hxQ.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.hxR);
                    aVar.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar.mTitle = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar);
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.hxV != null) {
                aVar.hxV.setTag(Integer.valueOf(i));
            }
            if (itemViewType == 0) {
                if (this.dQR) {
                    aVar.dRX.setVisibility(8);
                    aVar.dQV.setVisibility(0);
                    if (this.dQT) {
                        aVar.dQV.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.dQV.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.dQV.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.dQV.setText(R.string.no_fan_other);
                    }
                } else {
                    aVar.dFJ.setTag(Integer.valueOf(i));
                    UserData userData = (UserData) v.getItem(this.bbH, i);
                    if (userData != null) {
                        aVar.dQV.setVisibility(8);
                        aVar.hxT.setIsGod(userData.isBigV());
                        aVar.hxT.startLoad(userData.getPortrait(), 12, false);
                        aVar.mName.setText(userData.getName_show());
                        if (aVar.hxU != null && userData.getAlaUserData() != null) {
                            if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                                aVar.hxU.setVisibility(8);
                            } else {
                                aVar.hxU.setVisibility(0);
                                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                                aVar2.bTc = userData.getAlaUserData();
                                aVar2.type = 5;
                                aVar.hxU.setTag(aVar2);
                            }
                        }
                        if (aq.isEmpty(userData.getIntro())) {
                            aVar.dFN.setVisibility(8);
                        } else {
                            aVar.dFN.setVisibility(0);
                            aVar.dFN.setText(userData.getIntro());
                        }
                        String userId = userData.getUserId();
                        userData.setIsLike(userData.getHave_attention() > 0);
                        aVar.eLD.a(userData);
                        if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            aVar.hxV.setVisibility(8);
                        } else {
                            aVar.hxV.setStatsParams(2, userId);
                            aVar.eLD.mX("9");
                            aVar.hxV.setVisibility(0);
                        }
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.hxW.getLayoutParams();
                if (v.getItem(this.bbH, i) != null && ((UserData) v.getItem(this.bbH, i)).isLastNewFan) {
                    layoutParams.height = l.getDimens(this.hxQ, R.dimen.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                    aVar.hxW.setVisibility(0);
                } else {
                    aVar.hxW.setVisibility(8);
                    layoutParams.height = l.getDimens(this.hxQ, R.dimen.ds1);
                    layoutParams.setMargins(l.getDimens(this.hxQ, R.dimen.ds34), 0, l.getDimens(this.hxQ, R.dimen.ds34), 0);
                }
                aVar.hxW.setLayoutParams(layoutParams);
                aVar.mProgress = null;
            } else if (itemViewType == 2) {
                aVar.mTitle.setText(R.string.new_fans);
                aVar.mTitle.setVisibility(0);
            } else {
                aVar.mName.setText(this.hxQ.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.hxQ.getLayoutMode().setNightMode(skinType == 1);
        this.hxQ.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.mTitle != null) {
                am.setViewTextColor(aVar.mTitle, (int) R.color.cp_cont_d);
                am.setBackgroundColor(aVar.mTitle, R.color.cp_bg_line_e);
            }
            if (aVar.hxW != null) {
                am.setImageResource(aVar.hxW, R.color.cp_bg_line_c);
            }
            if (aVar.hxV != null) {
                aVar.hxV.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.dQR) {
            return 0;
        }
        if (this.bbH == null || i >= this.bbH.size()) {
            return 1;
        }
        return this.bbH.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.dQR) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a {
        ViewGroup dFJ;
        TextView dFN;
        TextView dQV;
        LinearLayout dRX;
        com.baidu.tbadk.core.view.userLike.c eLD;
        ClickableHeaderImageView hxT;
        View hxU;
        MyFansUserLikeButton hxV;
        ImageView hxW;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
