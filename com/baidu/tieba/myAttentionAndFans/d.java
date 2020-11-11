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
    boolean gQx;
    private View.OnClickListener gRx;
    boolean isFollowed;
    private PersonListActivity kYS;
    private View.OnClickListener kYT;
    private View.OnClickListener kZz;
    private int mSex;
    boolean gQv = false;
    private HashSet<Long> kZy = new HashSet<>();

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.kYS = null;
        this.isFollowed = false;
        this.gQx = true;
        this.mSex = 0;
        this.kZz = null;
        this.kYT = null;
        this.gRx = null;
        this.kYS = personListActivity;
        this.isFollowed = z;
        this.gQx = z2;
        this.mSex = i;
        this.kZz = onClickListener2;
        this.kYT = onClickListener3;
        this.gRx = onClickListener;
        this.eIM = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(bc bcVar) {
        ArrayList arrayList = new ArrayList();
        if (this.eIM.isEmpty() && !y.isEmpty(bcVar.blu())) {
            Iterator<UserData> it = bcVar.blu().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.kZy.add(Long.valueOf(com.baidu.adp.lib.f.b.toLong(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(bcVar.blu());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(aT(bcVar.blt()));
        this.eIM.addAll(arrayList);
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean gE(long j) {
        if (j == 0 || this.eIM == null || this.eIM.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.eIM.iterator();
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
        if (!y.isEmpty(arrayList) && !this.kZy.isEmpty()) {
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.kZy.contains(Long.valueOf(com.baidu.adp.lib.f.b.toLong(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gQv) {
            return 1;
        }
        int i = 0;
        if (this.eIM != null) {
            i = this.eIM.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eIM == null || i >= this.eIM.size()) {
            return null;
        }
        return this.eIM.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.eIM == null || i >= this.eIM.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (this.eIM != null) {
            if (view == null || !(view.getTag() instanceof a)) {
                final a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.kYS.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar2.gxd = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar2.gxd.setOnClickListener(this.gRx);
                    aVar2.kYW = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar2.kYW.setRadius(l.getDimens(this.kYS.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar2.kYW.setAutoChangeStyle(true);
                    aVar2.kYW.setClickable(false);
                    aVar2.gRA = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.mName.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.myAttentionAndFans.d.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            Layout layout = aVar2.mName.getLayout();
                            if (layout != null) {
                                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                                    aVar2.mName.setCompoundDrawablePadding(l.getDimens(d.this.kYS, R.dimen.tbds10));
                                } else {
                                    aVar2.mName.setCompoundDrawablePadding(0);
                                }
                            }
                        }
                    });
                    aVar2.kYX = com.baidu.tbadk.ala.b.bim().q(this.kYS.getPageContext().getPageActivity(), 5);
                    if (aVar2.kYX != null) {
                        aVar2.kYX.setVisibility(8);
                        aVar2.mContainer.addView(aVar2.kYX, 1);
                    }
                    aVar2.gQz = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.gxh = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.kZC = (TextView) inflate.findViewById(R.id.chat);
                    aVar2.kZC.setOnClickListener(this.kZz);
                    aVar2.kYY = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar2.kYY.setContext(this.kYS.getPageContext());
                    aVar2.ajW = new com.baidu.tbadk.core.view.userLike.c(this.kYS.getPageContext(), aVar2.kYY);
                    aVar2.mProgress = null;
                    aVar2.mTitle = null;
                    aVar2.kZD = null;
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    View inflate2 = LayoutInflater.from(this.kYS.getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
                    aVar2.mTitle = (TextView) inflate2.findViewById(R.id.person_list_title);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.mTitle.getLayoutParams();
                    layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds16);
                    aVar2.mTitle.setLayoutParams(layoutParams);
                    aVar2.kZD = (LinearLayout) inflate2.findViewById(R.id.newheader_root);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.kYS.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.kYT);
                    aVar2.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar2.mTitle = null;
                    aVar2.kZD = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.kYY != null) {
                aVar.kYY.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.gQv) {
                    aVar.gRA.setVisibility(8);
                    aVar.kZC.setVisibility(8);
                    aVar.gQz.setVisibility(0);
                    if (this.isFollowed) {
                        if (this.gQx) {
                            aVar.gQz.setText(R.string.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.gQz.setText(R.string.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.gQz.setText(R.string.him_no_attention_other);
                        } else {
                            aVar.gQz.setText(R.string.no_attention_other);
                        }
                    } else if (this.gQx) {
                        aVar.gQz.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.gQz.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.gQz.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.gQz.setText(R.string.no_fan_other);
                    }
                } else {
                    UserData userData = (UserData) y.getItem(this.eIM, i);
                    if (userData == null) {
                        return null;
                    }
                    aVar.gxd.setTag(Integer.valueOf(i));
                    aVar.kZC.setVisibility(0);
                    aVar.gQz.setVisibility(8);
                    UtilHelper.showHeadImageViewBigV(aVar.kYW, userData, 0);
                    aVar.mName.setText(UtilHelper.getUserName(userData));
                    aVar.kYW.setPlaceHolder(1);
                    aVar.kYW.startLoad(userData.getAvater(), 12, false);
                    if (aVar.kYX != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            aVar.kYX.setVisibility(8);
                        } else {
                            aVar.kYX.setVisibility(0);
                            com.baidu.tbadk.ala.a aVar3 = new com.baidu.tbadk.ala.a();
                            aVar3.eue = userData.getAlaUserData();
                            aVar3.type = 5;
                            aVar.kYX.setTag(aVar3);
                        }
                    }
                    if (at.isEmpty(userData.getIntro())) {
                        aVar.gxh.setVisibility(8);
                    } else {
                        aVar.gxh.setVisibility(0);
                        aVar.gxh.setText(userData.getIntro());
                    }
                    aVar.kZC.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    aVar.kYY.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    aVar.ajW.a(userData);
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        aVar.kYY.setVisibility(8);
                        aVar.kZC.setVisibility(8);
                    } else {
                        aVar.kZC.setVisibility(8);
                        aVar.kYY.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else if (getItemViewType(i) != 2) {
                aVar.mName.setText(this.kYS.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
            return view;
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.kYS.getLayoutMode().setNightMode(skinType == 1);
        this.kYS.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.kZC != null) {
                ap.setViewTextColor(aVar.kZC, R.color.btn_forum_focus_color, 1);
                ap.setBackgroundResource(aVar.kZC, R.drawable.btn_focus_border_bg);
                aVar.kZC.setEnabled(true);
            }
            if (aVar.kZD != null && aVar.mTitle != null) {
                ap.setBackgroundColor(aVar.kZD, R.color.cp_bg_line_e);
                ap.setViewTextColor(aVar.mTitle, R.color.cp_cont_e);
            }
            if (aVar.kYY != null) {
                aVar.kYY.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.gQv) {
            return 0;
        }
        if (this.eIM == null || i >= this.eIM.size()) {
            return 1;
        }
        return this.eIM.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.gQv) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c ajW;
        TextView gQz;
        LinearLayout gRA;
        ViewGroup gxd;
        TextView gxh;
        ClickableHeaderImageView kYW;
        View kYX;
        MyFansUserLikeButton kYY;
        TextView kZC;
        LinearLayout kZD;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
