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
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes23.dex */
public class d extends b {
    boolean gKL;
    private View.OnClickListener gLL;
    boolean isFollowed;
    private PersonListActivity kSW;
    private View.OnClickListener kSX;
    private View.OnClickListener kTD;
    private int mSex;
    boolean gKJ = false;
    private HashSet<Long> kTC = new HashSet<>();

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.kSW = null;
        this.isFollowed = false;
        this.gKL = true;
        this.mSex = 0;
        this.kTD = null;
        this.kSX = null;
        this.gLL = null;
        this.kSW = personListActivity;
        this.isFollowed = z;
        this.gKL = z2;
        this.mSex = i;
        this.kTD = onClickListener2;
        this.kSX = onClickListener3;
        this.gLL = onClickListener;
        this.eCX = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(bc bcVar) {
        ArrayList arrayList = new ArrayList();
        if (this.eCX.isEmpty() && !y.isEmpty(bcVar.biU())) {
            Iterator<UserData> it = bcVar.biU().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.kTC.add(Long.valueOf(com.baidu.adp.lib.f.b.toLong(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(bcVar.biU());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(aT(bcVar.biT()));
        this.eCX.addAll(arrayList);
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean gi(long j) {
        if (j == 0 || this.eCX == null || this.eCX.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.eCX.iterator();
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

    private ArrayList<UserData> aT(ArrayList<UserData> arrayList) {
        if (!y.isEmpty(arrayList) && !this.kTC.isEmpty()) {
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.kTC.contains(Long.valueOf(com.baidu.adp.lib.f.b.toLong(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gKJ) {
            return 1;
        }
        int i = 0;
        if (this.eCX != null) {
            i = this.eCX.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eCX == null || i >= this.eCX.size()) {
            return null;
        }
        return this.eCX.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.eCX == null || i >= this.eCX.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (this.eCX != null) {
            if (view == null || !(view.getTag() instanceof a)) {
                final a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.kSW.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar2.grp = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar2.grp.setOnClickListener(this.gLL);
                    aVar2.kTa = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar2.kTa.setRadius(l.getDimens(this.kSW.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar2.kTa.setAutoChangeStyle(true);
                    aVar2.kTa.setClickable(false);
                    aVar2.gLO = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.mName.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.myAttentionAndFans.d.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            Layout layout = aVar2.mName.getLayout();
                            if (layout != null) {
                                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                                    aVar2.mName.setCompoundDrawablePadding(l.getDimens(d.this.kSW, R.dimen.tbds10));
                                } else {
                                    aVar2.mName.setCompoundDrawablePadding(0);
                                }
                            }
                        }
                    });
                    aVar2.kTb = com.baidu.tbadk.ala.b.bfM().q(this.kSW.getPageContext().getPageActivity(), 5);
                    if (aVar2.kTb != null) {
                        aVar2.kTb.setVisibility(8);
                        aVar2.mContainer.addView(aVar2.kTb, 1);
                    }
                    aVar2.gKN = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.grt = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.kTG = (TextView) inflate.findViewById(R.id.chat);
                    aVar2.kTG.setOnClickListener(this.kTD);
                    aVar2.kTc = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar2.kTc.setContext(this.kSW.getPageContext());
                    aVar2.ajW = new com.baidu.tbadk.core.view.userLike.c(this.kSW.getPageContext(), aVar2.kTc);
                    aVar2.mProgress = null;
                    aVar2.mTitle = null;
                    aVar2.kTH = null;
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    View inflate2 = LayoutInflater.from(this.kSW.getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
                    aVar2.mTitle = (TextView) inflate2.findViewById(R.id.person_list_title);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.mTitle.getLayoutParams();
                    layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds16);
                    aVar2.mTitle.setLayoutParams(layoutParams);
                    aVar2.kTH = (LinearLayout) inflate2.findViewById(R.id.newheader_root);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.kSW.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.kSX);
                    aVar2.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar2.mTitle = null;
                    aVar2.kTH = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.kTc != null) {
                aVar.kTc.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.gKJ) {
                    aVar.gLO.setVisibility(8);
                    aVar.kTG.setVisibility(8);
                    aVar.gKN.setVisibility(0);
                    if (this.isFollowed) {
                        if (this.gKL) {
                            aVar.gKN.setText(R.string.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.gKN.setText(R.string.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.gKN.setText(R.string.him_no_attention_other);
                        } else {
                            aVar.gKN.setText(R.string.no_attention_other);
                        }
                    } else if (this.gKL) {
                        aVar.gKN.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.gKN.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.gKN.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.gKN.setText(R.string.no_fan_other);
                    }
                } else {
                    UserData userData = (UserData) y.getItem(this.eCX, i);
                    if (userData == null) {
                        return null;
                    }
                    aVar.grp.setTag(Integer.valueOf(i));
                    aVar.kTG.setVisibility(0);
                    aVar.gKN.setVisibility(8);
                    UtilHelper.showHeadImageViewBigV(aVar.kTa, userData, 0);
                    aVar.mName.setText(UtilHelper.getUserName(userData));
                    aVar.kTa.setPlaceHolder(1);
                    aVar.kTa.startLoad(userData.getAvater(), 12, false);
                    if (aVar.kTb != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            aVar.kTb.setVisibility(8);
                        } else {
                            aVar.kTb.setVisibility(0);
                            com.baidu.tbadk.ala.a aVar3 = new com.baidu.tbadk.ala.a();
                            aVar3.eol = userData.getAlaUserData();
                            aVar3.type = 5;
                            aVar.kTb.setTag(aVar3);
                        }
                    }
                    if (at.isEmpty(userData.getIntro())) {
                        aVar.grt.setVisibility(8);
                    } else {
                        aVar.grt.setVisibility(0);
                        aVar.grt.setText(userData.getIntro());
                    }
                    aVar.kTG.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    aVar.kTc.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    aVar.ajW.a(userData);
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        aVar.kTc.setVisibility(8);
                        aVar.kTG.setVisibility(8);
                    } else {
                        aVar.kTG.setVisibility(8);
                        aVar.kTc.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else if (getItemViewType(i) != 2) {
                aVar.mName.setText(this.kSW.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
            return view;
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.kSW.getLayoutMode().setNightMode(skinType == 1);
        this.kSW.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.kTG != null) {
                ap.setViewTextColor(aVar.kTG, R.color.btn_forum_focus_color, 1);
                ap.setBackgroundResource(aVar.kTG, R.drawable.btn_focus_border_bg);
                aVar.kTG.setEnabled(true);
            }
            if (aVar.kTH != null && aVar.mTitle != null) {
                ap.setBackgroundColor(aVar.kTH, R.color.cp_bg_line_e);
                ap.setViewTextColor(aVar.mTitle, R.color.cp_cont_e);
            }
            if (aVar.kTc != null) {
                aVar.kTc.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.gKJ) {
            return 0;
        }
        if (this.eCX == null || i >= this.eCX.size()) {
            return 1;
        }
        return this.eCX.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.gKJ) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c ajW;
        TextView gKN;
        LinearLayout gLO;
        ViewGroup grp;
        TextView grt;
        TextView kTG;
        LinearLayout kTH;
        ClickableHeaderImageView kTa;
        View kTb;
        MyFansUserLikeButton kTc;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
