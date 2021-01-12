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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes7.dex */
public class d extends b {
    boolean hgB;
    private View.OnClickListener hhA;
    boolean isFollowed;
    private View.OnClickListener lnZ;
    private PersonListActivity lnr;
    private View.OnClickListener lns;
    private int mSex;
    boolean hgz = false;
    private HashSet<Long> lnY = new HashSet<>();

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.lnr = null;
        this.isFollowed = false;
        this.hgB = true;
        this.mSex = 0;
        this.lnZ = null;
        this.lns = null;
        this.hhA = null;
        this.lnr = personListActivity;
        this.isFollowed = z;
        this.hgB = z2;
        this.mSex = i;
        this.lnZ = onClickListener2;
        this.lns = onClickListener3;
        this.hhA = onClickListener;
        this.eTF = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(be beVar) {
        ArrayList arrayList = new ArrayList();
        if (this.eTF.isEmpty() && !x.isEmpty(beVar.bmq())) {
            Iterator<UserData> it = beVar.bmq().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.lnY.add(Long.valueOf(com.baidu.adp.lib.f.b.toLong(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(beVar.bmq());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(aR(beVar.bmp()));
        this.eTF.addAll(arrayList);
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean hh(long j) {
        if (j == 0 || this.eTF == null || this.eTF.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.eTF.iterator();
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

    private ArrayList<UserData> aR(ArrayList<UserData> arrayList) {
        if (!x.isEmpty(arrayList) && !this.lnY.isEmpty()) {
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.lnY.contains(Long.valueOf(com.baidu.adp.lib.f.b.toLong(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hgz) {
            return 1;
        }
        int i = 0;
        if (this.eTF != null) {
            i = this.eTF.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eTF == null || i >= this.eTF.size()) {
            return null;
        }
        return this.eTF.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.eTF == null || i >= this.eTF.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (this.eTF != null) {
            if (view == null || !(view.getTag() instanceof a)) {
                final a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.lnr.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar2.gMC = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar2.gMC.setOnClickListener(this.hhA);
                    aVar2.lnv = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar2.lnv.setRadius(l.getDimens(this.lnr.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar2.lnv.setAutoChangeStyle(true);
                    aVar2.lnv.setClickable(false);
                    aVar2.hhD = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.mName.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.myAttentionAndFans.d.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            Layout layout = aVar2.mName.getLayout();
                            if (layout != null) {
                                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                                    aVar2.mName.setCompoundDrawablePadding(l.getDimens(d.this.lnr, R.dimen.tbds10));
                                } else {
                                    aVar2.mName.setCompoundDrawablePadding(0);
                                }
                            }
                        }
                    });
                    aVar2.lnw = com.baidu.tbadk.ala.b.bjv().A(this.lnr.getPageContext().getPageActivity(), 5);
                    if (aVar2.lnw != null) {
                        aVar2.lnw.setVisibility(8);
                        aVar2.mContainer.addView(aVar2.lnw, 1);
                    }
                    aVar2.hgD = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.gMG = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.lod = (TextView) inflate.findViewById(R.id.chat);
                    aVar2.lod.setOnClickListener(this.lnZ);
                    aVar2.lnx = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar2.lnx.setContext(this.lnr.getPageContext());
                    aVar2.akK = new com.baidu.tbadk.core.view.userLike.c(this.lnr.getPageContext(), aVar2.lnx);
                    aVar2.mProgress = null;
                    aVar2.mTitle = null;
                    aVar2.loe = null;
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    View inflate2 = LayoutInflater.from(this.lnr.getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
                    aVar2.mTitle = (TextView) inflate2.findViewById(R.id.person_list_title);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.mTitle.getLayoutParams();
                    layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds16);
                    aVar2.mTitle.setLayoutParams(layoutParams);
                    aVar2.loe = (LinearLayout) inflate2.findViewById(R.id.newheader_root);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.lnr.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.lns);
                    aVar2.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar2.mTitle = null;
                    aVar2.loe = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.lnx != null) {
                aVar.lnx.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.hgz) {
                    aVar.hhD.setVisibility(8);
                    aVar.lod.setVisibility(8);
                    aVar.hgD.setVisibility(0);
                    if (this.isFollowed) {
                        if (this.hgB) {
                            aVar.hgD.setText(R.string.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.hgD.setText(R.string.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.hgD.setText(R.string.him_no_attention_other);
                        } else {
                            aVar.hgD.setText(R.string.no_attention_other);
                        }
                    } else if (this.hgB) {
                        aVar.hgD.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.hgD.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.hgD.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.hgD.setText(R.string.no_fan_other);
                    }
                } else {
                    UserData userData = (UserData) x.getItem(this.eTF, i);
                    if (userData == null) {
                        return null;
                    }
                    aVar.gMC.setTag(Integer.valueOf(i));
                    aVar.lod.setVisibility(0);
                    aVar.hgD.setVisibility(8);
                    UtilHelper.showHeadImageViewBigV(aVar.lnv, userData, 0);
                    aVar.mName.setText(UtilHelper.getUserName(userData));
                    aVar.lnv.setPlaceHolder(1);
                    aVar.lnv.startLoad(userData.getAvater(), 12, false);
                    if (aVar.lnw != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            aVar.lnw.setVisibility(8);
                        } else {
                            aVar.lnw.setVisibility(0);
                            com.baidu.tbadk.ala.a aVar3 = new com.baidu.tbadk.ala.a();
                            aVar3.eEt = userData.getAlaUserData();
                            aVar3.type = 5;
                            aVar.lnw.setTag(aVar3);
                        }
                    }
                    if (at.isEmpty(userData.getIntro())) {
                        aVar.gMG.setVisibility(8);
                    } else {
                        aVar.gMG.setVisibility(0);
                        aVar.gMG.setText(userData.getIntro());
                    }
                    aVar.lod.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    aVar.lnx.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    aVar.akK.a(userData);
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        aVar.lnx.setVisibility(8);
                        aVar.lod.setVisibility(8);
                    } else {
                        aVar.lod.setVisibility(8);
                        aVar.lnx.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else if (getItemViewType(i) != 2) {
                aVar.mName.setText(this.lnr.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
            return view;
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.lnr.getLayoutMode().setNightMode(skinType == 1);
        this.lnr.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.lod != null) {
                ao.setViewTextColor(aVar.lod, R.color.btn_forum_focus_color, 1);
                ao.setBackgroundResource(aVar.lod, R.drawable.btn_focus_border_bg);
                aVar.lod.setEnabled(true);
            }
            if (aVar.loe != null && aVar.mTitle != null) {
                ao.setBackgroundColor(aVar.loe, R.color.CAM_X0205);
                ao.setViewTextColor(aVar.mTitle, R.color.CAM_X0110);
            }
            if (aVar.lnx != null) {
                aVar.lnx.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.hgz) {
            return 0;
        }
        if (this.eTF == null || i >= this.eTF.size()) {
            return 1;
        }
        return this.eTF.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.hgz) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c akK;
        ViewGroup gMC;
        TextView gMG;
        TextView hgD;
        LinearLayout hhD;
        ClickableHeaderImageView lnv;
        View lnw;
        MyFansUserLikeButton lnx;
        TextView lod;
        LinearLayout loe;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
