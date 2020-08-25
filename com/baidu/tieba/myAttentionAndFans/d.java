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
/* loaded from: classes17.dex */
public class d extends b {
    boolean aYi;
    boolean ghr;
    private View.OnClickListener git;
    private PersonListActivity kiH;
    private View.OnClickListener kiI;
    private View.OnClickListener kjo;
    private int mSex;
    boolean ghp = false;
    private HashSet<Long> kjn = new HashSet<>();

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.kiH = null;
        this.aYi = false;
        this.ghr = true;
        this.mSex = 0;
        this.kjo = null;
        this.kiI = null;
        this.git = null;
        this.kiH = personListActivity;
        this.aYi = z;
        this.ghr = z2;
        this.mSex = i;
        this.kjo = onClickListener2;
        this.kiI = onClickListener3;
        this.git = onClickListener;
        this.efX = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(bc bcVar) {
        ArrayList arrayList = new ArrayList();
        if (this.efX.isEmpty() && !y.isEmpty(bcVar.bdy())) {
            Iterator<UserData> it = bcVar.bdy().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.kjn.add(Long.valueOf(com.baidu.adp.lib.f.b.toLong(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(bcVar.bdy());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(aO(bcVar.bdx()));
        this.efX.addAll(arrayList);
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean fB(long j) {
        if (j == 0 || this.efX == null || this.efX.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.efX.iterator();
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

    private ArrayList<UserData> aO(ArrayList<UserData> arrayList) {
        if (!y.isEmpty(arrayList) && !this.kjn.isEmpty()) {
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.kjn.contains(Long.valueOf(com.baidu.adp.lib.f.b.toLong(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ghp) {
            return 1;
        }
        int i = 0;
        if (this.efX != null) {
            i = this.efX.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.efX == null || i >= this.efX.size()) {
            return null;
        }
        return this.efX.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.efX == null || i >= this.efX.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (this.efX != null) {
            if (view == null || !(view.getTag() instanceof a)) {
                final a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.kiH.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar2.fRE = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar2.fRE.setOnClickListener(this.git);
                    aVar2.kiL = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar2.kiL.setRadius(l.getDimens(this.kiH.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar2.kiL.setAutoChangeStyle(true);
                    aVar2.kiL.setClickable(false);
                    aVar2.giw = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.mName.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.myAttentionAndFans.d.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            Layout layout = aVar2.mName.getLayout();
                            if (layout != null) {
                                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                                    aVar2.mName.setCompoundDrawablePadding(l.getDimens(d.this.kiH, R.dimen.tbds10));
                                } else {
                                    aVar2.mName.setCompoundDrawablePadding(0);
                                }
                            }
                        }
                    });
                    aVar2.kiM = com.baidu.tbadk.ala.b.bar().q(this.kiH.getPageContext().getPageActivity(), 5);
                    if (aVar2.kiM != null) {
                        aVar2.kiM.setVisibility(8);
                        aVar2.mContainer.addView(aVar2.kiM, 1);
                    }
                    aVar2.ght = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.fRI = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.kjr = (TextView) inflate.findViewById(R.id.chat);
                    aVar2.kjr.setOnClickListener(this.kjo);
                    aVar2.kiN = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar2.kiN.setContext(this.kiH.getPageContext());
                    aVar2.ajc = new com.baidu.tbadk.core.view.userLike.c(this.kiH.getPageContext(), aVar2.kiN);
                    aVar2.mProgress = null;
                    aVar2.mTitle = null;
                    aVar2.kjs = null;
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    View inflate2 = LayoutInflater.from(this.kiH.getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
                    aVar2.mTitle = (TextView) inflate2.findViewById(R.id.person_list_title);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.mTitle.getLayoutParams();
                    layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds16);
                    aVar2.mTitle.setLayoutParams(layoutParams);
                    aVar2.kjs = (LinearLayout) inflate2.findViewById(R.id.newheader_root);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.kiH.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.kiI);
                    aVar2.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar2.mTitle = null;
                    aVar2.kjs = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.kiN != null) {
                aVar.kiN.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.ghp) {
                    aVar.giw.setVisibility(8);
                    aVar.kjr.setVisibility(8);
                    aVar.ght.setVisibility(0);
                    if (this.aYi) {
                        if (this.ghr) {
                            aVar.ght.setText(R.string.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.ght.setText(R.string.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.ght.setText(R.string.him_no_attention_other);
                        } else {
                            aVar.ght.setText(R.string.no_attention_other);
                        }
                    } else if (this.ghr) {
                        aVar.ght.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.ght.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.ght.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.ght.setText(R.string.no_fan_other);
                    }
                } else {
                    UserData userData = (UserData) y.getItem(this.efX, i);
                    if (userData == null) {
                        return null;
                    }
                    aVar.fRE.setTag(Integer.valueOf(i));
                    aVar.kjr.setVisibility(0);
                    aVar.ght.setVisibility(8);
                    UtilHelper.showHeadImageViewBigV(aVar.kiL, userData, 0);
                    aVar.mName.setText(UtilHelper.getUserName(userData));
                    aVar.kiL.setPlaceHolder(1);
                    aVar.kiL.startLoad(userData.getAvater(), 12, false);
                    if (aVar.kiM != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            aVar.kiM.setVisibility(8);
                        } else {
                            aVar.kiM.setVisibility(0);
                            com.baidu.tbadk.ala.a aVar3 = new com.baidu.tbadk.ala.a();
                            aVar3.dRx = userData.getAlaUserData();
                            aVar3.type = 5;
                            aVar.kiM.setTag(aVar3);
                        }
                    }
                    if (at.isEmpty(userData.getIntro())) {
                        aVar.fRI.setVisibility(8);
                    } else {
                        aVar.fRI.setVisibility(0);
                        aVar.fRI.setText(userData.getIntro());
                    }
                    aVar.kjr.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    aVar.kiN.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    aVar.ajc.a(userData);
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        aVar.kiN.setVisibility(8);
                        aVar.kjr.setVisibility(8);
                    } else {
                        aVar.kjr.setVisibility(8);
                        aVar.kiN.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else if (getItemViewType(i) != 2) {
                aVar.mName.setText(this.kiH.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
            return view;
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.kiH.getLayoutMode().setNightMode(skinType == 1);
        this.kiH.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.kjr != null) {
                ap.setViewTextColor(aVar.kjr, R.color.btn_forum_focus_color, 1);
                ap.setBackgroundResource(aVar.kjr, R.drawable.btn_focus_border_bg);
                aVar.kjr.setEnabled(true);
            }
            if (aVar.kjs != null && aVar.mTitle != null) {
                ap.setBackgroundColor(aVar.kjs, R.color.cp_bg_line_e);
                ap.setViewTextColor(aVar.mTitle, R.color.cp_cont_e);
            }
            if (aVar.kiN != null) {
                aVar.kiN.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.ghp) {
            return 0;
        }
        if (this.efX == null || i >= this.efX.size()) {
            return 1;
        }
        return this.efX.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.ghp) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c ajc;
        ViewGroup fRE;
        TextView fRI;
        TextView ght;
        LinearLayout giw;
        ClickableHeaderImageView kiL;
        View kiM;
        MyFansUserLikeButton kiN;
        TextView kjr;
        LinearLayout kjs;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
