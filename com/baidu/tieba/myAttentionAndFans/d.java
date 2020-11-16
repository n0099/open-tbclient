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
import com.baidu.tbadk.core.data.bd;
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
/* loaded from: classes22.dex */
public class d extends b {
    boolean gQe;
    private View.OnClickListener gRe;
    boolean isFollowed;
    private View.OnClickListener kZS;
    private PersonListActivity kZk;
    private View.OnClickListener kZl;
    private int mSex;
    boolean gQc = false;
    private HashSet<Long> kZR = new HashSet<>();

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.kZk = null;
        this.isFollowed = false;
        this.gQe = true;
        this.mSex = 0;
        this.kZS = null;
        this.kZl = null;
        this.gRe = null;
        this.kZk = personListActivity;
        this.isFollowed = z;
        this.gQe = z2;
        this.mSex = i;
        this.kZS = onClickListener2;
        this.kZl = onClickListener3;
        this.gRe = onClickListener;
        this.eHj = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(bd bdVar) {
        ArrayList arrayList = new ArrayList();
        if (this.eHj.isEmpty() && !y.isEmpty(bdVar.bkw())) {
            Iterator<UserData> it = bdVar.bkw().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.kZR.add(Long.valueOf(com.baidu.adp.lib.f.b.toLong(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(bdVar.bkw());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(aU(bdVar.bkv()));
        this.eHj.addAll(arrayList);
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean gH(long j) {
        if (j == 0 || this.eHj == null || this.eHj.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.eHj.iterator();
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

    private ArrayList<UserData> aU(ArrayList<UserData> arrayList) {
        if (!y.isEmpty(arrayList) && !this.kZR.isEmpty()) {
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.kZR.contains(Long.valueOf(com.baidu.adp.lib.f.b.toLong(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gQc) {
            return 1;
        }
        int i = 0;
        if (this.eHj != null) {
            i = this.eHj.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eHj == null || i >= this.eHj.size()) {
            return null;
        }
        return this.eHj.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.eHj == null || i >= this.eHj.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (this.eHj != null) {
            if (view == null || !(view.getTag() instanceof a)) {
                final a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.kZk.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar2.gwK = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar2.gwK.setOnClickListener(this.gRe);
                    aVar2.kZo = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar2.kZo.setRadius(l.getDimens(this.kZk.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar2.kZo.setAutoChangeStyle(true);
                    aVar2.kZo.setClickable(false);
                    aVar2.gRh = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.mName.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.myAttentionAndFans.d.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            Layout layout = aVar2.mName.getLayout();
                            if (layout != null) {
                                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                                    aVar2.mName.setCompoundDrawablePadding(l.getDimens(d.this.kZk, R.dimen.tbds10));
                                } else {
                                    aVar2.mName.setCompoundDrawablePadding(0);
                                }
                            }
                        }
                    });
                    aVar2.kZp = com.baidu.tbadk.ala.b.bhG().q(this.kZk.getPageContext().getPageActivity(), 5);
                    if (aVar2.kZp != null) {
                        aVar2.kZp.setVisibility(8);
                        aVar2.mContainer.addView(aVar2.kZp, 1);
                    }
                    aVar2.gQg = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.gwO = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.kZV = (TextView) inflate.findViewById(R.id.chat);
                    aVar2.kZV.setOnClickListener(this.kZS);
                    aVar2.kZq = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar2.kZq.setContext(this.kZk.getPageContext());
                    aVar2.ajZ = new com.baidu.tbadk.core.view.userLike.c(this.kZk.getPageContext(), aVar2.kZq);
                    aVar2.mProgress = null;
                    aVar2.mTitle = null;
                    aVar2.kZW = null;
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    View inflate2 = LayoutInflater.from(this.kZk.getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
                    aVar2.mTitle = (TextView) inflate2.findViewById(R.id.person_list_title);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.mTitle.getLayoutParams();
                    layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds16);
                    aVar2.mTitle.setLayoutParams(layoutParams);
                    aVar2.kZW = (LinearLayout) inflate2.findViewById(R.id.newheader_root);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.kZk.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.kZl);
                    aVar2.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar2.mTitle = null;
                    aVar2.kZW = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.kZq != null) {
                aVar.kZq.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.gQc) {
                    aVar.gRh.setVisibility(8);
                    aVar.kZV.setVisibility(8);
                    aVar.gQg.setVisibility(0);
                    if (this.isFollowed) {
                        if (this.gQe) {
                            aVar.gQg.setText(R.string.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.gQg.setText(R.string.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.gQg.setText(R.string.him_no_attention_other);
                        } else {
                            aVar.gQg.setText(R.string.no_attention_other);
                        }
                    } else if (this.gQe) {
                        aVar.gQg.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.gQg.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.gQg.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.gQg.setText(R.string.no_fan_other);
                    }
                } else {
                    UserData userData = (UserData) y.getItem(this.eHj, i);
                    if (userData == null) {
                        return null;
                    }
                    aVar.gwK.setTag(Integer.valueOf(i));
                    aVar.kZV.setVisibility(0);
                    aVar.gQg.setVisibility(8);
                    UtilHelper.showHeadImageViewBigV(aVar.kZo, userData, 0);
                    aVar.mName.setText(UtilHelper.getUserName(userData));
                    aVar.kZo.setPlaceHolder(1);
                    aVar.kZo.startLoad(userData.getAvater(), 12, false);
                    if (aVar.kZp != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            aVar.kZp.setVisibility(8);
                        } else {
                            aVar.kZp.setVisibility(0);
                            com.baidu.tbadk.ala.a aVar3 = new com.baidu.tbadk.ala.a();
                            aVar3.esy = userData.getAlaUserData();
                            aVar3.type = 5;
                            aVar.kZp.setTag(aVar3);
                        }
                    }
                    if (au.isEmpty(userData.getIntro())) {
                        aVar.gwO.setVisibility(8);
                    } else {
                        aVar.gwO.setVisibility(0);
                        aVar.gwO.setText(userData.getIntro());
                    }
                    aVar.kZV.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    aVar.kZq.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    aVar.ajZ.a(userData);
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        aVar.kZq.setVisibility(8);
                        aVar.kZV.setVisibility(8);
                    } else {
                        aVar.kZV.setVisibility(8);
                        aVar.kZq.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else if (getItemViewType(i) != 2) {
                aVar.mName.setText(this.kZk.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
            return view;
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.kZk.getLayoutMode().setNightMode(skinType == 1);
        this.kZk.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.kZV != null) {
                ap.setViewTextColor(aVar.kZV, R.color.btn_forum_focus_color, 1);
                ap.setBackgroundResource(aVar.kZV, R.drawable.btn_focus_border_bg);
                aVar.kZV.setEnabled(true);
            }
            if (aVar.kZW != null && aVar.mTitle != null) {
                ap.setBackgroundColor(aVar.kZW, R.color.CAM_X0205);
                ap.setViewTextColor(aVar.mTitle, R.color.CAM_X0110);
            }
            if (aVar.kZq != null) {
                aVar.kZq.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.gQc) {
            return 0;
        }
        if (this.eHj == null || i >= this.eHj.size()) {
            return 1;
        }
        return this.eHj.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.gQc) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c ajZ;
        TextView gQg;
        LinearLayout gRh;
        ViewGroup gwK;
        TextView gwO;
        TextView kZV;
        LinearLayout kZW;
        ClickableHeaderImageView kZo;
        View kZp;
        MyFansUserLikeButton kZq;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
