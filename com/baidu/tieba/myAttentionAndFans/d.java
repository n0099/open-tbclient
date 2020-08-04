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
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes17.dex */
public class d extends b {
    boolean aSU;
    boolean fVs;
    private View.OnClickListener fWt;
    private View.OnClickListener jTS;
    private PersonListActivity jTl;
    private View.OnClickListener jTm;
    private int mSex;
    boolean fVq = false;
    private HashSet<Long> jTR = new HashSet<>();

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.jTl = null;
        this.aSU = false;
        this.fVs = true;
        this.mSex = 0;
        this.jTS = null;
        this.jTm = null;
        this.fWt = null;
        this.jTl = personListActivity;
        this.aSU = z;
        this.fVs = z2;
        this.mSex = i;
        this.jTS = onClickListener2;
        this.jTm = onClickListener3;
        this.fWt = onClickListener;
        this.dWx = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(bb bbVar) {
        ArrayList arrayList = new ArrayList();
        if (this.dWx.isEmpty() && !x.isEmpty(bbVar.aVf())) {
            Iterator<UserData> it = bbVar.aVf().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.jTR.add(Long.valueOf(com.baidu.adp.lib.f.b.toLong(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(bbVar.aVf());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(aI(bbVar.aVe()));
        this.dWx.addAll(arrayList);
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean fp(long j) {
        if (j == 0 || this.dWx == null || this.dWx.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.dWx.iterator();
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

    private ArrayList<UserData> aI(ArrayList<UserData> arrayList) {
        if (!x.isEmpty(arrayList) && !this.jTR.isEmpty()) {
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.jTR.contains(Long.valueOf(com.baidu.adp.lib.f.b.toLong(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fVq) {
            return 1;
        }
        int i = 0;
        if (this.dWx != null) {
            i = this.dWx.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dWx == null || i >= this.dWx.size()) {
            return null;
        }
        return this.dWx.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.dWx == null || i >= this.dWx.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (this.dWx != null) {
            if (view == null || !(view.getTag() instanceof a)) {
                final a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.jTl.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar2.fGn = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar2.fGn.setOnClickListener(this.fWt);
                    aVar2.jTp = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar2.jTp.setRadius(l.getDimens(this.jTl.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar2.jTp.setAutoChangeStyle(true);
                    aVar2.jTp.setClickable(false);
                    aVar2.fWw = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.mName.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.myAttentionAndFans.d.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            Layout layout = aVar2.mName.getLayout();
                            if (layout != null) {
                                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                                    aVar2.mName.setCompoundDrawablePadding(l.getDimens(d.this.jTl, R.dimen.tbds10));
                                } else {
                                    aVar2.mName.setCompoundDrawablePadding(0);
                                }
                            }
                        }
                    });
                    aVar2.jTq = com.baidu.tbadk.ala.b.aSa().p(this.jTl.getPageContext().getPageActivity(), 5);
                    if (aVar2.jTq != null) {
                        aVar2.jTq.setVisibility(8);
                        aVar2.mContainer.addView(aVar2.jTq, 1);
                    }
                    aVar2.fVu = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.fGr = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.jTV = (TextView) inflate.findViewById(R.id.chat);
                    aVar2.jTV.setOnClickListener(this.jTS);
                    aVar2.jTr = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar2.jTr.setContext(this.jTl.getPageContext());
                    aVar2.ahO = new com.baidu.tbadk.core.view.userLike.c(this.jTl.getPageContext(), aVar2.jTr);
                    aVar2.mProgress = null;
                    aVar2.mTitle = null;
                    aVar2.jTW = null;
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    View inflate2 = LayoutInflater.from(this.jTl.getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
                    aVar2.mTitle = (TextView) inflate2.findViewById(R.id.person_list_title);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.mTitle.getLayoutParams();
                    layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds16);
                    aVar2.mTitle.setLayoutParams(layoutParams);
                    aVar2.jTW = (LinearLayout) inflate2.findViewById(R.id.newheader_root);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.jTl.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.jTm);
                    aVar2.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar2.mTitle = null;
                    aVar2.jTW = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.jTr != null) {
                aVar.jTr.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.fVq) {
                    aVar.fWw.setVisibility(8);
                    aVar.jTV.setVisibility(8);
                    aVar.fVu.setVisibility(0);
                    if (this.aSU) {
                        if (this.fVs) {
                            aVar.fVu.setText(R.string.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.fVu.setText(R.string.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.fVu.setText(R.string.him_no_attention_other);
                        } else {
                            aVar.fVu.setText(R.string.no_attention_other);
                        }
                    } else if (this.fVs) {
                        aVar.fVu.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.fVu.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.fVu.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.fVu.setText(R.string.no_fan_other);
                    }
                } else {
                    UserData userData = (UserData) x.getItem(this.dWx, i);
                    if (userData == null) {
                        return null;
                    }
                    aVar.fGn.setTag(Integer.valueOf(i));
                    aVar.jTV.setVisibility(0);
                    aVar.fVu.setVisibility(8);
                    UtilHelper.showHeadImageViewBigV(aVar.jTp, userData, 0);
                    aVar.mName.setText(UtilHelper.getUserName(userData));
                    aVar.jTp.setPlaceHolder(1);
                    aVar.jTp.startLoad(userData.getAvater(), 12, false);
                    if (aVar.jTq != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            aVar.jTq.setVisibility(8);
                        } else {
                            aVar.jTq.setVisibility(0);
                            com.baidu.tbadk.ala.a aVar3 = new com.baidu.tbadk.ala.a();
                            aVar3.dIq = userData.getAlaUserData();
                            aVar3.type = 5;
                            aVar.jTq.setTag(aVar3);
                        }
                    }
                    if (as.isEmpty(userData.getIntro())) {
                        aVar.fGr.setVisibility(8);
                    } else {
                        aVar.fGr.setVisibility(0);
                        aVar.fGr.setText(userData.getIntro());
                    }
                    aVar.jTV.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    aVar.jTr.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    aVar.ahO.a(userData);
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        aVar.jTr.setVisibility(8);
                        aVar.jTV.setVisibility(8);
                    } else {
                        aVar.jTV.setVisibility(8);
                        aVar.jTr.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else if (getItemViewType(i) != 2) {
                aVar.mName.setText(this.jTl.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
            return view;
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.jTl.getLayoutMode().setNightMode(skinType == 1);
        this.jTl.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.jTV != null) {
                ao.setViewTextColor(aVar.jTV, R.color.btn_forum_focus_color, 1);
                ao.setBackgroundResource(aVar.jTV, R.drawable.btn_focus_border_bg);
                aVar.jTV.setEnabled(true);
            }
            if (aVar.jTW != null && aVar.mTitle != null) {
                ao.setBackgroundColor(aVar.jTW, R.color.cp_bg_line_e);
                ao.setViewTextColor(aVar.mTitle, R.color.cp_cont_e);
            }
            if (aVar.jTr != null) {
                aVar.jTr.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fVq) {
            return 0;
        }
        if (this.dWx == null || i >= this.dWx.size()) {
            return 1;
        }
        return this.dWx.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fVq) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c ahO;
        ViewGroup fGn;
        TextView fGr;
        TextView fVu;
        LinearLayout fWw;
        TextView jTV;
        LinearLayout jTW;
        ClickableHeaderImageView jTp;
        View jTq;
        MyFansUserLikeButton jTr;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
