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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes8.dex */
public class d extends b {
    boolean hkR;
    private View.OnClickListener hlQ;
    boolean isFollowed;
    private PersonListActivity lvx;
    private View.OnClickListener lvy;
    private View.OnClickListener lwf;
    private int mSex;
    boolean hkP = false;
    private HashSet<Long> lwe = new HashSet<>();

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.lvx = null;
        this.isFollowed = false;
        this.hkR = true;
        this.mSex = 0;
        this.lwf = null;
        this.lvy = null;
        this.hlQ = null;
        this.lvx = personListActivity;
        this.isFollowed = z;
        this.hkR = z2;
        this.mSex = i;
        this.lwf = onClickListener2;
        this.lvy = onClickListener3;
        this.hlQ = onClickListener;
        this.eVV = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(bg bgVar) {
        ArrayList arrayList = new ArrayList();
        if (this.eVV.isEmpty() && !y.isEmpty(bgVar.bmJ())) {
            Iterator<UserData> it = bgVar.bmJ().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.lwe.add(Long.valueOf(com.baidu.adp.lib.f.b.toLong(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(bgVar.bmJ());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(aQ(bgVar.bmI()));
        this.eVV.addAll(arrayList);
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean hm(long j) {
        if (j == 0 || this.eVV == null || this.eVV.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.eVV.iterator();
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
        if (!y.isEmpty(arrayList) && !this.lwe.isEmpty()) {
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.lwe.contains(Long.valueOf(com.baidu.adp.lib.f.b.toLong(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hkP) {
            return 1;
        }
        int i = 0;
        if (this.eVV != null) {
            i = this.eVV.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eVV == null || i >= this.eVV.size()) {
            return null;
        }
        return this.eVV.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.eVV == null || i >= this.eVV.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (this.eVV != null) {
            if (view == null || !(view.getTag() instanceof a)) {
                final a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.lvx.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar2.gPi = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar2.gPi.setOnClickListener(this.hlQ);
                    aVar2.lvB = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar2.lvB.setRadius(l.getDimens(this.lvx.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar2.lvB.setAutoChangeStyle(true);
                    aVar2.lvB.setClickable(false);
                    aVar2.hlT = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.mName.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.myAttentionAndFans.d.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            Layout layout = aVar2.mName.getLayout();
                            if (layout != null) {
                                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                                    aVar2.mName.setCompoundDrawablePadding(l.getDimens(d.this.lvx, R.dimen.tbds10));
                                } else {
                                    aVar2.mName.setCompoundDrawablePadding(0);
                                }
                            }
                        }
                    });
                    aVar2.lvC = com.baidu.tbadk.ala.b.bjQ().A(this.lvx.getPageContext().getPageActivity(), 5);
                    if (aVar2.lvC != null) {
                        aVar2.lvC.setVisibility(8);
                        aVar2.mContainer.addView(aVar2.lvC, 1);
                    }
                    aVar2.hkT = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.gPm = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.lwi = (TextView) inflate.findViewById(R.id.chat);
                    aVar2.lwi.setOnClickListener(this.lwf);
                    aVar2.lvD = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar2.lvD.setContext(this.lvx.getPageContext());
                    aVar2.akz = new com.baidu.tbadk.core.view.userLike.c(this.lvx.getPageContext(), aVar2.lvD);
                    aVar2.mProgress = null;
                    aVar2.mTitle = null;
                    aVar2.lwj = null;
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    View inflate2 = LayoutInflater.from(this.lvx.getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
                    aVar2.mTitle = (TextView) inflate2.findViewById(R.id.person_list_title);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.mTitle.getLayoutParams();
                    layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds16);
                    aVar2.mTitle.setLayoutParams(layoutParams);
                    aVar2.lwj = (LinearLayout) inflate2.findViewById(R.id.newheader_root);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.lvx.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.lvy);
                    aVar2.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar2.mTitle = null;
                    aVar2.lwj = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.lvD != null) {
                aVar.lvD.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.hkP) {
                    aVar.hlT.setVisibility(8);
                    aVar.lwi.setVisibility(8);
                    aVar.hkT.setVisibility(0);
                    if (this.isFollowed) {
                        if (this.hkR) {
                            aVar.hkT.setText(R.string.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.hkT.setText(R.string.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.hkT.setText(R.string.him_no_attention_other);
                        } else {
                            aVar.hkT.setText(R.string.no_attention_other);
                        }
                    } else if (this.hkR) {
                        aVar.hkT.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.hkT.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.hkT.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.hkT.setText(R.string.no_fan_other);
                    }
                } else {
                    UserData userData = (UserData) y.getItem(this.eVV, i);
                    if (userData == null) {
                        return null;
                    }
                    aVar.gPi.setTag(Integer.valueOf(i));
                    aVar.lwi.setVisibility(0);
                    aVar.hkT.setVisibility(8);
                    UtilHelper.showHeadImageViewBigV(aVar.lvB, userData, 0);
                    aVar.mName.setText(UtilHelper.getUserName(userData));
                    aVar.lvB.setPlaceHolder(1);
                    aVar.lvB.startLoad(userData.getAvater(), 12, false);
                    if (aVar.lvC != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            aVar.lvC.setVisibility(8);
                        } else {
                            aVar.lvC.setVisibility(0);
                            com.baidu.tbadk.ala.a aVar3 = new com.baidu.tbadk.ala.a();
                            aVar3.eGA = userData.getAlaUserData();
                            aVar3.type = 5;
                            aVar.lvC.setTag(aVar3);
                        }
                    }
                    if (au.isEmpty(userData.getIntro())) {
                        aVar.gPm.setVisibility(8);
                    } else {
                        aVar.gPm.setVisibility(0);
                        aVar.gPm.setText(userData.getIntro());
                    }
                    aVar.lwi.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    aVar.lvD.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    aVar.akz.a(userData);
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        aVar.lvD.setVisibility(8);
                        aVar.lwi.setVisibility(8);
                    } else {
                        aVar.lwi.setVisibility(8);
                        aVar.lvD.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else if (getItemViewType(i) != 2) {
                aVar.mName.setText(this.lvx.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
            return view;
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.lvx.getLayoutMode().setNightMode(skinType == 1);
        this.lvx.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.lwi != null) {
                ap.setViewTextColor(aVar.lwi, R.color.btn_forum_focus_color, 1);
                ap.setBackgroundResource(aVar.lwi, R.drawable.btn_focus_border_bg);
                aVar.lwi.setEnabled(true);
            }
            if (aVar.lwj != null && aVar.mTitle != null) {
                ap.setBackgroundColor(aVar.lwj, R.color.CAM_X0205);
                ap.setViewTextColor(aVar.mTitle, R.color.CAM_X0110);
            }
            if (aVar.lvD != null) {
                aVar.lvD.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.hkP) {
            return 0;
        }
        if (this.eVV == null || i >= this.eVV.size()) {
            return 1;
        }
        return this.eVV.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.hkP) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c akz;
        ViewGroup gPi;
        TextView gPm;
        TextView hkT;
        LinearLayout hlT;
        ClickableHeaderImageView lvB;
        View lvC;
        MyFansUserLikeButton lvD;
        TextView lwi;
        LinearLayout lwj;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
