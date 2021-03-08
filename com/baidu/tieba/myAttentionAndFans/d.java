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
/* loaded from: classes7.dex */
public class d extends b {
    boolean hmO;
    private View.OnClickListener hnN;
    boolean isFollowed;
    private PersonListActivity lxN;
    private View.OnClickListener lxO;
    private View.OnClickListener lyw;
    private int mSex;
    boolean hmM = false;
    private HashSet<Long> lyv = new HashSet<>();

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.lxN = null;
        this.isFollowed = false;
        this.hmO = true;
        this.mSex = 0;
        this.lyw = null;
        this.lxO = null;
        this.hnN = null;
        this.lxN = personListActivity;
        this.isFollowed = z;
        this.hmO = z2;
        this.mSex = i;
        this.lyw = onClickListener2;
        this.lxO = onClickListener3;
        this.hnN = onClickListener;
        this.eXu = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(bg bgVar) {
        ArrayList arrayList = new ArrayList();
        if (this.eXu.isEmpty() && !y.isEmpty(bgVar.bmL())) {
            Iterator<UserData> it = bgVar.bmL().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.lyv.add(Long.valueOf(com.baidu.adp.lib.f.b.toLong(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(bgVar.bmL());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(aQ(bgVar.bmK()));
        this.eXu.addAll(arrayList);
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean hm(long j) {
        if (j == 0 || this.eXu == null || this.eXu.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.eXu.iterator();
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
        if (!y.isEmpty(arrayList) && !this.lyv.isEmpty()) {
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.lyv.contains(Long.valueOf(com.baidu.adp.lib.f.b.toLong(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hmM) {
            return 1;
        }
        int i = 0;
        if (this.eXu != null) {
            i = this.eXu.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eXu == null || i >= this.eXu.size()) {
            return null;
        }
        return this.eXu.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.eXu == null || i >= this.eXu.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (this.eXu != null) {
            if (view == null || !(view.getTag() instanceof a)) {
                final a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.lxN.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar2.gRf = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar2.gRf.setOnClickListener(this.hnN);
                    aVar2.lxR = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar2.lxR.setRadius(l.getDimens(this.lxN.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar2.lxR.setAutoChangeStyle(true);
                    aVar2.lxR.setClickable(false);
                    aVar2.hnQ = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.mName.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.myAttentionAndFans.d.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            Layout layout = aVar2.mName.getLayout();
                            if (layout != null) {
                                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                                    aVar2.mName.setCompoundDrawablePadding(l.getDimens(d.this.lxN, R.dimen.tbds10));
                                } else {
                                    aVar2.mName.setCompoundDrawablePadding(0);
                                }
                            }
                        }
                    });
                    aVar2.lxS = com.baidu.tbadk.ala.b.bjS().A(this.lxN.getPageContext().getPageActivity(), 5);
                    if (aVar2.lxS != null) {
                        aVar2.lxS.setVisibility(8);
                        aVar2.mContainer.addView(aVar2.lxS, 1);
                    }
                    aVar2.hmQ = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.gRj = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.lyz = (TextView) inflate.findViewById(R.id.chat);
                    aVar2.lyz.setOnClickListener(this.lyw);
                    aVar2.lxT = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar2.lxT.setContext(this.lxN.getPageContext());
                    aVar2.alS = new com.baidu.tbadk.core.view.userLike.c(this.lxN.getPageContext(), aVar2.lxT);
                    aVar2.mProgress = null;
                    aVar2.mTitle = null;
                    aVar2.lyA = null;
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    View inflate2 = LayoutInflater.from(this.lxN.getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
                    aVar2.mTitle = (TextView) inflate2.findViewById(R.id.person_list_title);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.mTitle.getLayoutParams();
                    layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds16);
                    aVar2.mTitle.setLayoutParams(layoutParams);
                    aVar2.lyA = (LinearLayout) inflate2.findViewById(R.id.newheader_root);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.lxN.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.lxO);
                    aVar2.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar2.mTitle = null;
                    aVar2.lyA = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.lxT != null) {
                aVar.lxT.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.hmM) {
                    aVar.hnQ.setVisibility(8);
                    aVar.lyz.setVisibility(8);
                    aVar.hmQ.setVisibility(0);
                    if (this.isFollowed) {
                        if (this.hmO) {
                            aVar.hmQ.setText(R.string.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.hmQ.setText(R.string.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.hmQ.setText(R.string.him_no_attention_other);
                        } else {
                            aVar.hmQ.setText(R.string.no_attention_other);
                        }
                    } else if (this.hmO) {
                        aVar.hmQ.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.hmQ.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.hmQ.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.hmQ.setText(R.string.no_fan_other);
                    }
                } else {
                    UserData userData = (UserData) y.getItem(this.eXu, i);
                    if (userData == null) {
                        return null;
                    }
                    aVar.gRf.setTag(Integer.valueOf(i));
                    aVar.lyz.setVisibility(0);
                    aVar.hmQ.setVisibility(8);
                    UtilHelper.showHeadImageViewBigV(aVar.lxR, userData, 0);
                    aVar.mName.setText(UtilHelper.getUserName(userData));
                    aVar.lxR.setPlaceHolder(1);
                    aVar.lxR.startLoad(userData.getAvater(), 12, false);
                    if (aVar.lxS != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            aVar.lxS.setVisibility(8);
                        } else {
                            aVar.lxS.setVisibility(0);
                            com.baidu.tbadk.ala.a aVar3 = new com.baidu.tbadk.ala.a();
                            aVar3.eIb = userData.getAlaUserData();
                            aVar3.type = 5;
                            aVar.lxS.setTag(aVar3);
                        }
                    }
                    if (au.isEmpty(userData.getIntro())) {
                        aVar.gRj.setVisibility(8);
                    } else {
                        aVar.gRj.setVisibility(0);
                        aVar.gRj.setText(userData.getIntro());
                    }
                    aVar.lyz.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    aVar.lxT.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    aVar.alS.a(userData);
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        aVar.lxT.setVisibility(8);
                        aVar.lyz.setVisibility(8);
                    } else {
                        aVar.lyz.setVisibility(8);
                        aVar.lxT.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else if (getItemViewType(i) != 2) {
                aVar.mName.setText(this.lxN.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
            return view;
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.lxN.getLayoutMode().setNightMode(skinType == 1);
        this.lxN.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.lyz != null) {
                ap.setViewTextColor(aVar.lyz, R.color.btn_forum_focus_color, 1);
                ap.setBackgroundResource(aVar.lyz, R.drawable.btn_focus_border_bg);
                aVar.lyz.setEnabled(true);
            }
            if (aVar.lyA != null && aVar.mTitle != null) {
                ap.setBackgroundColor(aVar.lyA, R.color.CAM_X0205);
                ap.setViewTextColor(aVar.mTitle, R.color.CAM_X0110);
            }
            if (aVar.lxT != null) {
                aVar.lxT.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.hmM) {
            return 0;
        }
        if (this.eXu == null || i >= this.eXu.size()) {
            return 1;
        }
        return this.eXu.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.hmM) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c alS;
        ViewGroup gRf;
        TextView gRj;
        TextView hmQ;
        LinearLayout hnQ;
        ClickableHeaderImageView lxR;
        View lxS;
        MyFansUserLikeButton lxT;
        LinearLayout lyA;
        TextView lyz;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
