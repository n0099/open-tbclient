package com.baidu.tieba.myAttentionAndFans;

import android.annotation.SuppressLint;
import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
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
import java.util.HashSet;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes7.dex */
public class d extends b {
    boolean eGA;
    private View.OnClickListener eHB;
    boolean etS;
    private PersonListActivity ilN;
    private View.OnClickListener ilO;
    private View.OnClickListener imv;
    private int mSex;
    boolean eGy = false;
    private HashSet<Long> imu = new HashSet<>();

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.ilN = null;
        this.etS = false;
        this.eGA = true;
        this.mSex = 0;
        this.imv = null;
        this.ilO = null;
        this.eHB = null;
        this.ilN = personListActivity;
        this.etS = z;
        this.eGA = z2;
        this.mSex = i;
        this.imv = onClickListener2;
        this.ilO = onClickListener3;
        this.eHB = onClickListener;
        this.cRE = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(av avVar) {
        ArrayList arrayList = new ArrayList();
        if (this.cRE.isEmpty() && !v.isEmpty(avVar.ayC())) {
            Iterator<UserData> it = avVar.ayC().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.imu.add(Long.valueOf(com.baidu.adp.lib.f.b.toLong(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(avVar.ayC());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(aE(avVar.ayB()));
        this.cRE.addAll(arrayList);
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
                if (next.getLikeStatus() == 2) {
                    next.setLikeStatus(1);
                }
                return true;
            }
        }
        return false;
    }

    private ArrayList<UserData> aE(ArrayList<UserData> arrayList) {
        if (!v.isEmpty(arrayList) && !this.imu.isEmpty()) {
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.imu.contains(Long.valueOf(com.baidu.adp.lib.f.b.toLong(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return arrayList;
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
        View view2;
        a aVar;
        if (this.cRE != null) {
            if (view == null || !(view.getTag() instanceof a)) {
                final a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.ilN.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar2.erM = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar2.erM.setOnClickListener(this.eHB);
                    aVar2.ilR = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar2.ilR.setRadius(l.getDimens(this.ilN.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar2.ilR.setAutoChangeStyle(true);
                    aVar2.ilR.setClickable(false);
                    aVar2.eHE = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.mName.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.myAttentionAndFans.d.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            Layout layout = aVar2.mName.getLayout();
                            if (layout != null) {
                                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                                    aVar2.mName.setCompoundDrawablePadding(l.getDimens(d.this.ilN, R.dimen.tbds10));
                                } else {
                                    aVar2.mName.setCompoundDrawablePadding(0);
                                }
                            }
                        }
                    });
                    aVar2.ilS = com.baidu.tbadk.ala.b.avT().u(this.ilN.getPageContext().getPageActivity(), 5);
                    if (aVar2.ilS != null) {
                        aVar2.ilS.setVisibility(8);
                        aVar2.mContainer.addView(aVar2.ilS, 1);
                    }
                    aVar2.eGC = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.erQ = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.imy = (TextView) inflate.findViewById(R.id.chat);
                    aVar2.imy.setOnClickListener(this.imv);
                    aVar2.ilT = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar2.ilT.setContext(this.ilN.getPageContext());
                    aVar2.MX = new com.baidu.tbadk.core.view.userLike.c(this.ilN.getPageContext(), aVar2.ilT);
                    aVar2.mProgress = null;
                    aVar2.mTitle = null;
                    aVar2.imz = null;
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    View inflate2 = LayoutInflater.from(this.ilN.getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
                    aVar2.mTitle = (TextView) inflate2.findViewById(R.id.person_list_title);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.mTitle.getLayoutParams();
                    layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds16);
                    aVar2.mTitle.setLayoutParams(layoutParams);
                    aVar2.imz = (LinearLayout) inflate2.findViewById(R.id.newheader_root);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.ilN.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.ilO);
                    aVar2.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar2.mTitle = null;
                    aVar2.imz = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.ilT != null) {
                aVar.ilT.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.eGy) {
                    aVar.eHE.setVisibility(8);
                    aVar.imy.setVisibility(8);
                    aVar.eGC.setVisibility(0);
                    if (this.etS) {
                        if (this.eGA) {
                            aVar.eGC.setText(R.string.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.eGC.setText(R.string.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.eGC.setText(R.string.him_no_attention_other);
                        } else {
                            aVar.eGC.setText(R.string.no_attention_other);
                        }
                    } else if (this.eGA) {
                        aVar.eGC.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.eGC.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.eGC.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.eGC.setText(R.string.no_fan_other);
                    }
                } else {
                    UserData userData = (UserData) v.getItem(this.cRE, i);
                    if (userData == null) {
                        return null;
                    }
                    aVar.erM.setTag(Integer.valueOf(i));
                    aVar.imy.setVisibility(0);
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
                            com.baidu.tbadk.ala.a aVar3 = new com.baidu.tbadk.ala.a();
                            aVar3.cFA = userData.getAlaUserData();
                            aVar3.type = 5;
                            aVar.ilS.setTag(aVar3);
                        }
                    }
                    if (aq.isEmpty(userData.getIntro())) {
                        aVar.erQ.setVisibility(8);
                    } else {
                        aVar.erQ.setVisibility(0);
                        aVar.erQ.setText(userData.getIntro());
                    }
                    aVar.imy.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    aVar.ilT.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    aVar.MX.a(userData);
                    aVar.MX.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.d.2
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void fJ(boolean z) {
                            if (z) {
                                l.showToast(d.this.ilN, (int) R.string.attention_success);
                            } else {
                                l.showToast(d.this.ilN, (int) R.string.unfollow_success);
                            }
                        }
                    });
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        aVar.ilT.setVisibility(8);
                        aVar.imy.setVisibility(8);
                    } else {
                        aVar.imy.setVisibility(8);
                        aVar.ilT.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else if (getItemViewType(i) != 2) {
                aVar.mName.setText(this.ilN.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
            return view;
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.ilN.getLayoutMode().setNightMode(skinType == 1);
        this.ilN.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.imy != null) {
                am.setViewTextColor(aVar.imy, R.color.btn_forum_focus_color, 1);
                am.setBackgroundResource(aVar.imy, R.drawable.btn_focus_border_bg);
                aVar.imy.setEnabled(true);
            }
            if (aVar.imz != null && aVar.mTitle != null) {
                am.setBackgroundColor(aVar.imz, R.color.cp_bg_line_e);
                am.setViewTextColor(aVar.mTitle, (int) R.color.cp_cont_e);
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
        TextView imy;
        LinearLayout imz;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
