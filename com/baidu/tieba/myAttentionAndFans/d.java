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
    boolean hlf;
    private View.OnClickListener hme;
    boolean isFollowed;
    private PersonListActivity lvL;
    private View.OnClickListener lvM;
    private View.OnClickListener lwt;
    private int mSex;
    boolean hld = false;
    private HashSet<Long> lws = new HashSet<>();

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.lvL = null;
        this.isFollowed = false;
        this.hlf = true;
        this.mSex = 0;
        this.lwt = null;
        this.lvM = null;
        this.hme = null;
        this.lvL = personListActivity;
        this.isFollowed = z;
        this.hlf = z2;
        this.mSex = i;
        this.lwt = onClickListener2;
        this.lvM = onClickListener3;
        this.hme = onClickListener;
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
                    this.lws.add(Long.valueOf(com.baidu.adp.lib.f.b.toLong(next.getUserId(), 0L)));
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
        if (!y.isEmpty(arrayList) && !this.lws.isEmpty()) {
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.lws.contains(Long.valueOf(com.baidu.adp.lib.f.b.toLong(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hld) {
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
                    View inflate = LayoutInflater.from(this.lvL.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar2.gPw = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar2.gPw.setOnClickListener(this.hme);
                    aVar2.lvP = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar2.lvP.setRadius(l.getDimens(this.lvL.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar2.lvP.setAutoChangeStyle(true);
                    aVar2.lvP.setClickable(false);
                    aVar2.hmh = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.mName.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.myAttentionAndFans.d.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            Layout layout = aVar2.mName.getLayout();
                            if (layout != null) {
                                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                                    aVar2.mName.setCompoundDrawablePadding(l.getDimens(d.this.lvL, R.dimen.tbds10));
                                } else {
                                    aVar2.mName.setCompoundDrawablePadding(0);
                                }
                            }
                        }
                    });
                    aVar2.lvQ = com.baidu.tbadk.ala.b.bjQ().A(this.lvL.getPageContext().getPageActivity(), 5);
                    if (aVar2.lvQ != null) {
                        aVar2.lvQ.setVisibility(8);
                        aVar2.mContainer.addView(aVar2.lvQ, 1);
                    }
                    aVar2.hlh = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.gPA = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.lww = (TextView) inflate.findViewById(R.id.chat);
                    aVar2.lww.setOnClickListener(this.lwt);
                    aVar2.lvR = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar2.lvR.setContext(this.lvL.getPageContext());
                    aVar2.akz = new com.baidu.tbadk.core.view.userLike.c(this.lvL.getPageContext(), aVar2.lvR);
                    aVar2.mProgress = null;
                    aVar2.mTitle = null;
                    aVar2.lwx = null;
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    View inflate2 = LayoutInflater.from(this.lvL.getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
                    aVar2.mTitle = (TextView) inflate2.findViewById(R.id.person_list_title);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.mTitle.getLayoutParams();
                    layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds16);
                    aVar2.mTitle.setLayoutParams(layoutParams);
                    aVar2.lwx = (LinearLayout) inflate2.findViewById(R.id.newheader_root);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.lvL.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.lvM);
                    aVar2.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar2.mTitle = null;
                    aVar2.lwx = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.lvR != null) {
                aVar.lvR.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.hld) {
                    aVar.hmh.setVisibility(8);
                    aVar.lww.setVisibility(8);
                    aVar.hlh.setVisibility(0);
                    if (this.isFollowed) {
                        if (this.hlf) {
                            aVar.hlh.setText(R.string.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.hlh.setText(R.string.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.hlh.setText(R.string.him_no_attention_other);
                        } else {
                            aVar.hlh.setText(R.string.no_attention_other);
                        }
                    } else if (this.hlf) {
                        aVar.hlh.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.hlh.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.hlh.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.hlh.setText(R.string.no_fan_other);
                    }
                } else {
                    UserData userData = (UserData) y.getItem(this.eVV, i);
                    if (userData == null) {
                        return null;
                    }
                    aVar.gPw.setTag(Integer.valueOf(i));
                    aVar.lww.setVisibility(0);
                    aVar.hlh.setVisibility(8);
                    UtilHelper.showHeadImageViewBigV(aVar.lvP, userData, 0);
                    aVar.mName.setText(UtilHelper.getUserName(userData));
                    aVar.lvP.setPlaceHolder(1);
                    aVar.lvP.startLoad(userData.getAvater(), 12, false);
                    if (aVar.lvQ != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            aVar.lvQ.setVisibility(8);
                        } else {
                            aVar.lvQ.setVisibility(0);
                            com.baidu.tbadk.ala.a aVar3 = new com.baidu.tbadk.ala.a();
                            aVar3.eGA = userData.getAlaUserData();
                            aVar3.type = 5;
                            aVar.lvQ.setTag(aVar3);
                        }
                    }
                    if (au.isEmpty(userData.getIntro())) {
                        aVar.gPA.setVisibility(8);
                    } else {
                        aVar.gPA.setVisibility(0);
                        aVar.gPA.setText(userData.getIntro());
                    }
                    aVar.lww.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    aVar.lvR.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    aVar.akz.a(userData);
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        aVar.lvR.setVisibility(8);
                        aVar.lww.setVisibility(8);
                    } else {
                        aVar.lww.setVisibility(8);
                        aVar.lvR.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else if (getItemViewType(i) != 2) {
                aVar.mName.setText(this.lvL.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
            return view;
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.lvL.getLayoutMode().setNightMode(skinType == 1);
        this.lvL.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.lww != null) {
                ap.setViewTextColor(aVar.lww, R.color.btn_forum_focus_color, 1);
                ap.setBackgroundResource(aVar.lww, R.drawable.btn_focus_border_bg);
                aVar.lww.setEnabled(true);
            }
            if (aVar.lwx != null && aVar.mTitle != null) {
                ap.setBackgroundColor(aVar.lwx, R.color.CAM_X0205);
                ap.setViewTextColor(aVar.mTitle, R.color.CAM_X0110);
            }
            if (aVar.lvR != null) {
                aVar.lvR.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.hld) {
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
        if (this.hld) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c akz;
        TextView gPA;
        ViewGroup gPw;
        TextView hlh;
        LinearLayout hmh;
        ClickableHeaderImageView lvP;
        View lvQ;
        MyFansUserLikeButton lvR;
        TextView lww;
        LinearLayout lwx;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
