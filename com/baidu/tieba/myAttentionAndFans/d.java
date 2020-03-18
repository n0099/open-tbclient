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
/* loaded from: classes10.dex */
public class d extends b {
    boolean aqx;
    boolean eMo;
    private View.OnClickListener eNp;
    private View.OnClickListener itJ;
    private PersonListActivity itc;
    private View.OnClickListener itd;
    private int mSex;
    boolean eMm = false;
    private HashSet<Long> itI = new HashSet<>();

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.itc = null;
        this.aqx = false;
        this.eMo = true;
        this.mSex = 0;
        this.itJ = null;
        this.itd = null;
        this.eNp = null;
        this.itc = personListActivity;
        this.aqx = z;
        this.eMo = z2;
        this.mSex = i;
        this.itJ = onClickListener2;
        this.itd = onClickListener3;
        this.eNp = onClickListener;
        this.cWf = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(av avVar) {
        ArrayList arrayList = new ArrayList();
        if (this.cWf.isEmpty() && !v.isEmpty(avVar.aBr())) {
            Iterator<UserData> it = avVar.aBr().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.itI.add(Long.valueOf(com.baidu.adp.lib.f.b.toLong(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(avVar.aBr());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(aE(avVar.aBq()));
        this.cWf.addAll(arrayList);
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean en(long j) {
        if (j == 0 || this.cWf == null || this.cWf.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.cWf.iterator();
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
        if (!v.isEmpty(arrayList) && !this.itI.isEmpty()) {
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.itI.contains(Long.valueOf(com.baidu.adp.lib.f.b.toLong(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eMm) {
            return 1;
        }
        int i = 0;
        if (this.cWf != null) {
            i = this.cWf.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cWf == null || i >= this.cWf.size()) {
            return null;
        }
        return this.cWf.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.cWf == null || i >= this.cWf.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (this.cWf != null) {
            if (view == null || !(view.getTag() instanceof a)) {
                final a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.itc.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar2.exS = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar2.exS.setOnClickListener(this.eNp);
                    aVar2.itg = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar2.itg.setRadius(l.getDimens(this.itc.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar2.itg.setAutoChangeStyle(true);
                    aVar2.itg.setClickable(false);
                    aVar2.eNs = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.mName.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.myAttentionAndFans.d.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            Layout layout = aVar2.mName.getLayout();
                            if (layout != null) {
                                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                                    aVar2.mName.setCompoundDrawablePadding(l.getDimens(d.this.itc, R.dimen.tbds10));
                                } else {
                                    aVar2.mName.setCompoundDrawablePadding(0);
                                }
                            }
                        }
                    });
                    aVar2.ith = com.baidu.tbadk.ala.b.ayE().u(this.itc.getPageContext().getPageActivity(), 5);
                    if (aVar2.ith != null) {
                        aVar2.ith.setVisibility(8);
                        aVar2.mContainer.addView(aVar2.ith, 1);
                    }
                    aVar2.eMq = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.exW = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.itM = (TextView) inflate.findViewById(R.id.chat);
                    aVar2.itM.setOnClickListener(this.itJ);
                    aVar2.iti = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar2.iti.setContext(this.itc.getPageContext());
                    aVar2.NC = new com.baidu.tbadk.core.view.userLike.c(this.itc.getPageContext(), aVar2.iti);
                    aVar2.mProgress = null;
                    aVar2.mTitle = null;
                    aVar2.itN = null;
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    View inflate2 = LayoutInflater.from(this.itc.getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
                    aVar2.mTitle = (TextView) inflate2.findViewById(R.id.person_list_title);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.mTitle.getLayoutParams();
                    layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds16);
                    aVar2.mTitle.setLayoutParams(layoutParams);
                    aVar2.itN = (LinearLayout) inflate2.findViewById(R.id.newheader_root);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.itc.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.itd);
                    aVar2.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar2.mTitle = null;
                    aVar2.itN = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.iti != null) {
                aVar.iti.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.eMm) {
                    aVar.eNs.setVisibility(8);
                    aVar.itM.setVisibility(8);
                    aVar.eMq.setVisibility(0);
                    if (this.aqx) {
                        if (this.eMo) {
                            aVar.eMq.setText(R.string.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.eMq.setText(R.string.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.eMq.setText(R.string.him_no_attention_other);
                        } else {
                            aVar.eMq.setText(R.string.no_attention_other);
                        }
                    } else if (this.eMo) {
                        aVar.eMq.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.eMq.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.eMq.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.eMq.setText(R.string.no_fan_other);
                    }
                } else {
                    UserData userData = (UserData) v.getItem(this.cWf, i);
                    if (userData == null) {
                        return null;
                    }
                    aVar.exS.setTag(Integer.valueOf(i));
                    aVar.itM.setVisibility(0);
                    aVar.eMq.setVisibility(8);
                    UtilHelper.showHeadImageViewBigV(aVar.itg, userData, 0);
                    aVar.mName.setText(UtilHelper.getUserName(userData));
                    aVar.itg.setPlaceHolder(1);
                    aVar.itg.startLoad(userData.getAvater(), 12, false);
                    if (aVar.ith != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            aVar.ith.setVisibility(8);
                        } else {
                            aVar.ith.setVisibility(0);
                            com.baidu.tbadk.ala.a aVar3 = new com.baidu.tbadk.ala.a();
                            aVar3.cKd = userData.getAlaUserData();
                            aVar3.type = 5;
                            aVar.ith.setTag(aVar3);
                        }
                    }
                    if (aq.isEmpty(userData.getIntro())) {
                        aVar.exW.setVisibility(8);
                    } else {
                        aVar.exW.setVisibility(0);
                        aVar.exW.setText(userData.getIntro());
                    }
                    aVar.itM.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    aVar.iti.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    aVar.NC.a(userData);
                    aVar.NC.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.d.2
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void fW(boolean z) {
                            if (z) {
                                l.showToast(d.this.itc, (int) R.string.attention_success);
                            } else {
                                l.showToast(d.this.itc, (int) R.string.unfollow_success);
                            }
                        }
                    });
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        aVar.iti.setVisibility(8);
                        aVar.itM.setVisibility(8);
                    } else {
                        aVar.itM.setVisibility(8);
                        aVar.iti.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else if (getItemViewType(i) != 2) {
                aVar.mName.setText(this.itc.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
            return view;
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.itc.getLayoutMode().setNightMode(skinType == 1);
        this.itc.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.itM != null) {
                am.setViewTextColor(aVar.itM, R.color.btn_forum_focus_color, 1);
                am.setBackgroundResource(aVar.itM, R.drawable.btn_focus_border_bg);
                aVar.itM.setEnabled(true);
            }
            if (aVar.itN != null && aVar.mTitle != null) {
                am.setBackgroundColor(aVar.itN, R.color.cp_bg_line_e);
                am.setViewTextColor(aVar.mTitle, (int) R.color.cp_cont_e);
            }
            if (aVar.iti != null) {
                aVar.iti.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.eMm) {
            return 0;
        }
        if (this.cWf == null || i >= this.cWf.size()) {
            return 1;
        }
        return this.cWf.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.eMm) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c NC;
        TextView eMq;
        LinearLayout eNs;
        ViewGroup exS;
        TextView exW;
        TextView itM;
        LinearLayout itN;
        ClickableHeaderImageView itg;
        View ith;
        MyFansUserLikeButton iti;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
