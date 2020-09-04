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
    boolean aYk;
    boolean ghv;
    private View.OnClickListener gix;
    private PersonListActivity kiO;
    private View.OnClickListener kiP;
    private View.OnClickListener kjv;
    private int mSex;
    boolean ght = false;
    private HashSet<Long> kju = new HashSet<>();

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.kiO = null;
        this.aYk = false;
        this.ghv = true;
        this.mSex = 0;
        this.kjv = null;
        this.kiP = null;
        this.gix = null;
        this.kiO = personListActivity;
        this.aYk = z;
        this.ghv = z2;
        this.mSex = i;
        this.kjv = onClickListener2;
        this.kiP = onClickListener3;
        this.gix = onClickListener;
        this.egb = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(bc bcVar) {
        ArrayList arrayList = new ArrayList();
        if (this.egb.isEmpty() && !y.isEmpty(bcVar.bdy())) {
            Iterator<UserData> it = bcVar.bdy().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.kju.add(Long.valueOf(com.baidu.adp.lib.f.b.toLong(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(bcVar.bdy());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(aO(bcVar.bdx()));
        this.egb.addAll(arrayList);
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean fB(long j) {
        if (j == 0 || this.egb == null || this.egb.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.egb.iterator();
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
        if (!y.isEmpty(arrayList) && !this.kju.isEmpty()) {
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.kju.contains(Long.valueOf(com.baidu.adp.lib.f.b.toLong(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ght) {
            return 1;
        }
        int i = 0;
        if (this.egb != null) {
            i = this.egb.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.egb == null || i >= this.egb.size()) {
            return null;
        }
        return this.egb.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.egb == null || i >= this.egb.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (this.egb != null) {
            if (view == null || !(view.getTag() instanceof a)) {
                final a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.kiO.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar2.fRI = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar2.fRI.setOnClickListener(this.gix);
                    aVar2.kiS = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar2.kiS.setRadius(l.getDimens(this.kiO.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar2.kiS.setAutoChangeStyle(true);
                    aVar2.kiS.setClickable(false);
                    aVar2.giA = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.mName.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.myAttentionAndFans.d.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            Layout layout = aVar2.mName.getLayout();
                            if (layout != null) {
                                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                                    aVar2.mName.setCompoundDrawablePadding(l.getDimens(d.this.kiO, R.dimen.tbds10));
                                } else {
                                    aVar2.mName.setCompoundDrawablePadding(0);
                                }
                            }
                        }
                    });
                    aVar2.kiT = com.baidu.tbadk.ala.b.bar().q(this.kiO.getPageContext().getPageActivity(), 5);
                    if (aVar2.kiT != null) {
                        aVar2.kiT.setVisibility(8);
                        aVar2.mContainer.addView(aVar2.kiT, 1);
                    }
                    aVar2.ghx = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.fRM = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.kjy = (TextView) inflate.findViewById(R.id.chat);
                    aVar2.kjy.setOnClickListener(this.kjv);
                    aVar2.kiU = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar2.kiU.setContext(this.kiO.getPageContext());
                    aVar2.aje = new com.baidu.tbadk.core.view.userLike.c(this.kiO.getPageContext(), aVar2.kiU);
                    aVar2.mProgress = null;
                    aVar2.mTitle = null;
                    aVar2.kjz = null;
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    View inflate2 = LayoutInflater.from(this.kiO.getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
                    aVar2.mTitle = (TextView) inflate2.findViewById(R.id.person_list_title);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.mTitle.getLayoutParams();
                    layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds16);
                    aVar2.mTitle.setLayoutParams(layoutParams);
                    aVar2.kjz = (LinearLayout) inflate2.findViewById(R.id.newheader_root);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.kiO.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.kiP);
                    aVar2.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar2.mTitle = null;
                    aVar2.kjz = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.kiU != null) {
                aVar.kiU.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.ght) {
                    aVar.giA.setVisibility(8);
                    aVar.kjy.setVisibility(8);
                    aVar.ghx.setVisibility(0);
                    if (this.aYk) {
                        if (this.ghv) {
                            aVar.ghx.setText(R.string.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.ghx.setText(R.string.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.ghx.setText(R.string.him_no_attention_other);
                        } else {
                            aVar.ghx.setText(R.string.no_attention_other);
                        }
                    } else if (this.ghv) {
                        aVar.ghx.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.ghx.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.ghx.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.ghx.setText(R.string.no_fan_other);
                    }
                } else {
                    UserData userData = (UserData) y.getItem(this.egb, i);
                    if (userData == null) {
                        return null;
                    }
                    aVar.fRI.setTag(Integer.valueOf(i));
                    aVar.kjy.setVisibility(0);
                    aVar.ghx.setVisibility(8);
                    UtilHelper.showHeadImageViewBigV(aVar.kiS, userData, 0);
                    aVar.mName.setText(UtilHelper.getUserName(userData));
                    aVar.kiS.setPlaceHolder(1);
                    aVar.kiS.startLoad(userData.getAvater(), 12, false);
                    if (aVar.kiT != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            aVar.kiT.setVisibility(8);
                        } else {
                            aVar.kiT.setVisibility(0);
                            com.baidu.tbadk.ala.a aVar3 = new com.baidu.tbadk.ala.a();
                            aVar3.dRB = userData.getAlaUserData();
                            aVar3.type = 5;
                            aVar.kiT.setTag(aVar3);
                        }
                    }
                    if (at.isEmpty(userData.getIntro())) {
                        aVar.fRM.setVisibility(8);
                    } else {
                        aVar.fRM.setVisibility(0);
                        aVar.fRM.setText(userData.getIntro());
                    }
                    aVar.kjy.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    aVar.kiU.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    aVar.aje.a(userData);
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        aVar.kiU.setVisibility(8);
                        aVar.kjy.setVisibility(8);
                    } else {
                        aVar.kjy.setVisibility(8);
                        aVar.kiU.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else if (getItemViewType(i) != 2) {
                aVar.mName.setText(this.kiO.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
            return view;
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.kiO.getLayoutMode().setNightMode(skinType == 1);
        this.kiO.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.kjy != null) {
                ap.setViewTextColor(aVar.kjy, R.color.btn_forum_focus_color, 1);
                ap.setBackgroundResource(aVar.kjy, R.drawable.btn_focus_border_bg);
                aVar.kjy.setEnabled(true);
            }
            if (aVar.kjz != null && aVar.mTitle != null) {
                ap.setBackgroundColor(aVar.kjz, R.color.cp_bg_line_e);
                ap.setViewTextColor(aVar.mTitle, R.color.cp_cont_e);
            }
            if (aVar.kiU != null) {
                aVar.kiU.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.ght) {
            return 0;
        }
        if (this.egb == null || i >= this.egb.size()) {
            return 1;
        }
        return this.egb.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.ght) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c aje;
        ViewGroup fRI;
        TextView fRM;
        TextView ghx;
        LinearLayout giA;
        ClickableHeaderImageView kiS;
        View kiT;
        MyFansUserLikeButton kiU;
        TextView kjy;
        LinearLayout kjz;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
