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
    boolean gyX;
    private View.OnClickListener gzX;
    boolean isFollowed;
    private View.OnClickListener kGA;
    private PersonListActivity kGz;
    private View.OnClickListener kHg;
    private int mSex;
    boolean gyV = false;
    private HashSet<Long> kHf = new HashSet<>();

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.kGz = null;
        this.isFollowed = false;
        this.gyX = true;
        this.mSex = 0;
        this.kHg = null;
        this.kGA = null;
        this.gzX = null;
        this.kGz = personListActivity;
        this.isFollowed = z;
        this.gyX = z2;
        this.mSex = i;
        this.kHg = onClickListener2;
        this.kGA = onClickListener3;
        this.gzX = onClickListener;
        this.euy = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(bc bcVar) {
        ArrayList arrayList = new ArrayList();
        if (this.euy.isEmpty() && !y.isEmpty(bcVar.bhb())) {
            Iterator<UserData> it = bcVar.bhb().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.kHf.add(Long.valueOf(com.baidu.adp.lib.f.b.toLong(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(bcVar.bhb());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(aQ(bcVar.bha()));
        this.euy.addAll(arrayList);
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean gh(long j) {
        if (j == 0 || this.euy == null || this.euy.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.euy.iterator();
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

    private ArrayList<UserData> aQ(ArrayList<UserData> arrayList) {
        if (!y.isEmpty(arrayList) && !this.kHf.isEmpty()) {
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.kHf.contains(Long.valueOf(com.baidu.adp.lib.f.b.toLong(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gyV) {
            return 1;
        }
        int i = 0;
        if (this.euy != null) {
            i = this.euy.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.euy == null || i >= this.euy.size()) {
            return null;
        }
        return this.euy.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.euy == null || i >= this.euy.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (this.euy != null) {
            if (view == null || !(view.getTag() instanceof a)) {
                final a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.kGz.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar2.ghm = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar2.ghm.setOnClickListener(this.gzX);
                    aVar2.kGD = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar2.kGD.setRadius(l.getDimens(this.kGz.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar2.kGD.setAutoChangeStyle(true);
                    aVar2.kGD.setClickable(false);
                    aVar2.gAa = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.mName.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.myAttentionAndFans.d.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            Layout layout = aVar2.mName.getLayout();
                            if (layout != null) {
                                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                                    aVar2.mName.setCompoundDrawablePadding(l.getDimens(d.this.kGz, R.dimen.tbds10));
                                } else {
                                    aVar2.mName.setCompoundDrawablePadding(0);
                                }
                            }
                        }
                    });
                    aVar2.kGE = com.baidu.tbadk.ala.b.bdT().q(this.kGz.getPageContext().getPageActivity(), 5);
                    if (aVar2.kGE != null) {
                        aVar2.kGE.setVisibility(8);
                        aVar2.mContainer.addView(aVar2.kGE, 1);
                    }
                    aVar2.gyZ = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.ghq = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.kHj = (TextView) inflate.findViewById(R.id.chat);
                    aVar2.kHj.setOnClickListener(this.kHg);
                    aVar2.kGF = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar2.kGF.setContext(this.kGz.getPageContext());
                    aVar2.ajV = new com.baidu.tbadk.core.view.userLike.c(this.kGz.getPageContext(), aVar2.kGF);
                    aVar2.mProgress = null;
                    aVar2.mTitle = null;
                    aVar2.kHk = null;
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    View inflate2 = LayoutInflater.from(this.kGz.getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
                    aVar2.mTitle = (TextView) inflate2.findViewById(R.id.person_list_title);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.mTitle.getLayoutParams();
                    layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds16);
                    aVar2.mTitle.setLayoutParams(layoutParams);
                    aVar2.kHk = (LinearLayout) inflate2.findViewById(R.id.newheader_root);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.kGz.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.kGA);
                    aVar2.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar2.mTitle = null;
                    aVar2.kHk = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.kGF != null) {
                aVar.kGF.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.gyV) {
                    aVar.gAa.setVisibility(8);
                    aVar.kHj.setVisibility(8);
                    aVar.gyZ.setVisibility(0);
                    if (this.isFollowed) {
                        if (this.gyX) {
                            aVar.gyZ.setText(R.string.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.gyZ.setText(R.string.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.gyZ.setText(R.string.him_no_attention_other);
                        } else {
                            aVar.gyZ.setText(R.string.no_attention_other);
                        }
                    } else if (this.gyX) {
                        aVar.gyZ.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.gyZ.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.gyZ.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.gyZ.setText(R.string.no_fan_other);
                    }
                } else {
                    UserData userData = (UserData) y.getItem(this.euy, i);
                    if (userData == null) {
                        return null;
                    }
                    aVar.ghm.setTag(Integer.valueOf(i));
                    aVar.kHj.setVisibility(0);
                    aVar.gyZ.setVisibility(8);
                    UtilHelper.showHeadImageViewBigV(aVar.kGD, userData, 0);
                    aVar.mName.setText(UtilHelper.getUserName(userData));
                    aVar.kGD.setPlaceHolder(1);
                    aVar.kGD.startLoad(userData.getAvater(), 12, false);
                    if (aVar.kGE != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            aVar.kGE.setVisibility(8);
                        } else {
                            aVar.kGE.setVisibility(0);
                            com.baidu.tbadk.ala.a aVar3 = new com.baidu.tbadk.ala.a();
                            aVar3.efM = userData.getAlaUserData();
                            aVar3.type = 5;
                            aVar.kGE.setTag(aVar3);
                        }
                    }
                    if (at.isEmpty(userData.getIntro())) {
                        aVar.ghq.setVisibility(8);
                    } else {
                        aVar.ghq.setVisibility(0);
                        aVar.ghq.setText(userData.getIntro());
                    }
                    aVar.kHj.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    aVar.kGF.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    aVar.ajV.a(userData);
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        aVar.kGF.setVisibility(8);
                        aVar.kHj.setVisibility(8);
                    } else {
                        aVar.kHj.setVisibility(8);
                        aVar.kGF.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else if (getItemViewType(i) != 2) {
                aVar.mName.setText(this.kGz.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
            return view;
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.kGz.getLayoutMode().setNightMode(skinType == 1);
        this.kGz.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.kHj != null) {
                ap.setViewTextColor(aVar.kHj, R.color.btn_forum_focus_color, 1);
                ap.setBackgroundResource(aVar.kHj, R.drawable.btn_focus_border_bg);
                aVar.kHj.setEnabled(true);
            }
            if (aVar.kHk != null && aVar.mTitle != null) {
                ap.setBackgroundColor(aVar.kHk, R.color.cp_bg_line_e);
                ap.setViewTextColor(aVar.mTitle, R.color.cp_cont_e);
            }
            if (aVar.kGF != null) {
                aVar.kGF.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.gyV) {
            return 0;
        }
        if (this.euy == null || i >= this.euy.size()) {
            return 1;
        }
        return this.euy.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.gyV) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c ajV;
        LinearLayout gAa;
        ViewGroup ghm;
        TextView ghq;
        TextView gyZ;
        ClickableHeaderImageView kGD;
        View kGE;
        MyFansUserLikeButton kGF;
        TextView kHj;
        LinearLayout kHk;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
