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
import com.baidu.tbadk.core.data.be;
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
/* loaded from: classes23.dex */
public class d extends b {
    boolean gZt;
    private View.OnClickListener hat;
    boolean isFollowed;
    private PersonListActivity lmI;
    private View.OnClickListener lmJ;
    private View.OnClickListener lnr;
    private int mSex;
    boolean gZr = false;
    private HashSet<Long> lnq = new HashSet<>();

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.lmI = null;
        this.isFollowed = false;
        this.gZt = true;
        this.mSex = 0;
        this.lnr = null;
        this.lmJ = null;
        this.hat = null;
        this.lmI = personListActivity;
        this.isFollowed = z;
        this.gZt = z2;
        this.mSex = i;
        this.lnr = onClickListener2;
        this.lmJ = onClickListener3;
        this.hat = onClickListener;
        this.eOt = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(be beVar) {
        ArrayList arrayList = new ArrayList();
        if (this.eOt.isEmpty() && !y.isEmpty(beVar.bnJ())) {
            Iterator<UserData> it = beVar.bnJ().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.lnq.add(Long.valueOf(com.baidu.adp.lib.f.b.toLong(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(beVar.bnJ());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(aW(beVar.bnI()));
        this.eOt.addAll(arrayList);
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean hm(long j) {
        if (j == 0 || this.eOt == null || this.eOt.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.eOt.iterator();
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

    private ArrayList<UserData> aW(ArrayList<UserData> arrayList) {
        if (!y.isEmpty(arrayList) && !this.lnq.isEmpty()) {
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.lnq.contains(Long.valueOf(com.baidu.adp.lib.f.b.toLong(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gZr) {
            return 1;
        }
        int i = 0;
        if (this.eOt != null) {
            i = this.eOt.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eOt == null || i >= this.eOt.size()) {
            return null;
        }
        return this.eOt.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.eOt == null || i >= this.eOt.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (this.eOt != null) {
            if (view == null || !(view.getTag() instanceof a)) {
                final a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.lmI.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar2.gFx = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar2.gFx.setOnClickListener(this.hat);
                    aVar2.lmM = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar2.lmM.setRadius(l.getDimens(this.lmI.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar2.lmM.setAutoChangeStyle(true);
                    aVar2.lmM.setClickable(false);
                    aVar2.haw = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.mName.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.myAttentionAndFans.d.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            Layout layout = aVar2.mName.getLayout();
                            if (layout != null) {
                                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                                    aVar2.mName.setCompoundDrawablePadding(l.getDimens(d.this.lmI, R.dimen.tbds10));
                                } else {
                                    aVar2.mName.setCompoundDrawablePadding(0);
                                }
                            }
                        }
                    });
                    aVar2.lmN = com.baidu.tbadk.ala.b.bkP().z(this.lmI.getPageContext().getPageActivity(), 5);
                    if (aVar2.lmN != null) {
                        aVar2.lmN.setVisibility(8);
                        aVar2.mContainer.addView(aVar2.lmN, 1);
                    }
                    aVar2.gZv = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.gFB = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.lnu = (TextView) inflate.findViewById(R.id.chat);
                    aVar2.lnu.setOnClickListener(this.lnr);
                    aVar2.lmO = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar2.lmO.setContext(this.lmI.getPageContext());
                    aVar2.akZ = new com.baidu.tbadk.core.view.userLike.c(this.lmI.getPageContext(), aVar2.lmO);
                    aVar2.mProgress = null;
                    aVar2.mTitle = null;
                    aVar2.lnv = null;
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    View inflate2 = LayoutInflater.from(this.lmI.getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
                    aVar2.mTitle = (TextView) inflate2.findViewById(R.id.person_list_title);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.mTitle.getLayoutParams();
                    layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds16);
                    aVar2.mTitle.setLayoutParams(layoutParams);
                    aVar2.lnv = (LinearLayout) inflate2.findViewById(R.id.newheader_root);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.lmI.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.lmJ);
                    aVar2.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar2.mTitle = null;
                    aVar2.lnv = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.lmO != null) {
                aVar.lmO.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.gZr) {
                    aVar.haw.setVisibility(8);
                    aVar.lnu.setVisibility(8);
                    aVar.gZv.setVisibility(0);
                    if (this.isFollowed) {
                        if (this.gZt) {
                            aVar.gZv.setText(R.string.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.gZv.setText(R.string.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.gZv.setText(R.string.him_no_attention_other);
                        } else {
                            aVar.gZv.setText(R.string.no_attention_other);
                        }
                    } else if (this.gZt) {
                        aVar.gZv.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.gZv.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.gZv.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.gZv.setText(R.string.no_fan_other);
                    }
                } else {
                    UserData userData = (UserData) y.getItem(this.eOt, i);
                    if (userData == null) {
                        return null;
                    }
                    aVar.gFx.setTag(Integer.valueOf(i));
                    aVar.lnu.setVisibility(0);
                    aVar.gZv.setVisibility(8);
                    UtilHelper.showHeadImageViewBigV(aVar.lmM, userData, 0);
                    aVar.mName.setText(UtilHelper.getUserName(userData));
                    aVar.lmM.setPlaceHolder(1);
                    aVar.lmM.startLoad(userData.getAvater(), 12, false);
                    if (aVar.lmN != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            aVar.lmN.setVisibility(8);
                        } else {
                            aVar.lmN.setVisibility(0);
                            com.baidu.tbadk.ala.a aVar3 = new com.baidu.tbadk.ala.a();
                            aVar3.ezB = userData.getAlaUserData();
                            aVar3.type = 5;
                            aVar.lmN.setTag(aVar3);
                        }
                    }
                    if (au.isEmpty(userData.getIntro())) {
                        aVar.gFB.setVisibility(8);
                    } else {
                        aVar.gFB.setVisibility(0);
                        aVar.gFB.setText(userData.getIntro());
                    }
                    aVar.lnu.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    aVar.lmO.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    aVar.akZ.a(userData);
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        aVar.lmO.setVisibility(8);
                        aVar.lnu.setVisibility(8);
                    } else {
                        aVar.lnu.setVisibility(8);
                        aVar.lmO.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else if (getItemViewType(i) != 2) {
                aVar.mName.setText(this.lmI.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
            return view;
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.lmI.getLayoutMode().setNightMode(skinType == 1);
        this.lmI.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.lnu != null) {
                ap.setViewTextColor(aVar.lnu, R.color.btn_forum_focus_color, 1);
                ap.setBackgroundResource(aVar.lnu, R.drawable.btn_focus_border_bg);
                aVar.lnu.setEnabled(true);
            }
            if (aVar.lnv != null && aVar.mTitle != null) {
                ap.setBackgroundColor(aVar.lnv, R.color.CAM_X0205);
                ap.setViewTextColor(aVar.mTitle, R.color.CAM_X0110);
            }
            if (aVar.lmO != null) {
                aVar.lmO.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.gZr) {
            return 0;
        }
        if (this.eOt == null || i >= this.eOt.size()) {
            return 1;
        }
        return this.eOt.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.gZr) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c akZ;
        TextView gFB;
        ViewGroup gFx;
        TextView gZv;
        LinearLayout haw;
        ClickableHeaderImageView lmM;
        View lmN;
        MyFansUserLikeButton lmO;
        TextView lnu;
        LinearLayout lnv;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
