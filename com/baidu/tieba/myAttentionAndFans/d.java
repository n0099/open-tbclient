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
/* loaded from: classes8.dex */
public class d extends b {
    boolean hli;
    private View.OnClickListener hmh;
    boolean isFollowed;
    private View.OnClickListener lsI;
    private PersonListActivity lsa;
    private View.OnClickListener lsb;
    private int mSex;
    boolean hlg = false;
    private HashSet<Long> lsH = new HashSet<>();

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.lsa = null;
        this.isFollowed = false;
        this.hli = true;
        this.mSex = 0;
        this.lsI = null;
        this.lsb = null;
        this.hmh = null;
        this.lsa = personListActivity;
        this.isFollowed = z;
        this.hli = z2;
        this.mSex = i;
        this.lsI = onClickListener2;
        this.lsb = onClickListener3;
        this.hmh = onClickListener;
        this.eYq = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(be beVar) {
        ArrayList arrayList = new ArrayList();
        if (this.eYq.isEmpty() && !x.isEmpty(beVar.bqk())) {
            Iterator<UserData> it = beVar.bqk().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.lsH.add(Long.valueOf(com.baidu.adp.lib.f.b.toLong(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(beVar.bqk());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(aW(beVar.bqj()));
        this.eYq.addAll(arrayList);
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean hh(long j) {
        if (j == 0 || this.eYq == null || this.eYq.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.eYq.iterator();
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
        if (!x.isEmpty(arrayList) && !this.lsH.isEmpty()) {
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.lsH.contains(Long.valueOf(com.baidu.adp.lib.f.b.toLong(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hlg) {
            return 1;
        }
        int i = 0;
        if (this.eYq != null) {
            i = this.eYq.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eYq == null || i >= this.eYq.size()) {
            return null;
        }
        return this.eYq.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.eYq == null || i >= this.eYq.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (this.eYq != null) {
            if (view == null || !(view.getTag() instanceof a)) {
                final a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.lsa.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar2.gRi = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar2.gRi.setOnClickListener(this.hmh);
                    aVar2.lse = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar2.lse.setRadius(l.getDimens(this.lsa.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar2.lse.setAutoChangeStyle(true);
                    aVar2.lse.setClickable(false);
                    aVar2.hmk = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.mName.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.myAttentionAndFans.d.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            Layout layout = aVar2.mName.getLayout();
                            if (layout != null) {
                                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                                    aVar2.mName.setCompoundDrawablePadding(l.getDimens(d.this.lsa, R.dimen.tbds10));
                                } else {
                                    aVar2.mName.setCompoundDrawablePadding(0);
                                }
                            }
                        }
                    });
                    aVar2.lsf = com.baidu.tbadk.ala.b.bnp().A(this.lsa.getPageContext().getPageActivity(), 5);
                    if (aVar2.lsf != null) {
                        aVar2.lsf.setVisibility(8);
                        aVar2.mContainer.addView(aVar2.lsf, 1);
                    }
                    aVar2.hlk = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.gRm = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.lsL = (TextView) inflate.findViewById(R.id.chat);
                    aVar2.lsL.setOnClickListener(this.lsI);
                    aVar2.lsg = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar2.lsg.setContext(this.lsa.getPageContext());
                    aVar2.alC = new com.baidu.tbadk.core.view.userLike.c(this.lsa.getPageContext(), aVar2.lsg);
                    aVar2.mProgress = null;
                    aVar2.mTitle = null;
                    aVar2.lsM = null;
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    View inflate2 = LayoutInflater.from(this.lsa.getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
                    aVar2.mTitle = (TextView) inflate2.findViewById(R.id.person_list_title);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.mTitle.getLayoutParams();
                    layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds16);
                    aVar2.mTitle.setLayoutParams(layoutParams);
                    aVar2.lsM = (LinearLayout) inflate2.findViewById(R.id.newheader_root);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.lsa.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.lsb);
                    aVar2.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar2.mTitle = null;
                    aVar2.lsM = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.lsg != null) {
                aVar.lsg.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.hlg) {
                    aVar.hmk.setVisibility(8);
                    aVar.lsL.setVisibility(8);
                    aVar.hlk.setVisibility(0);
                    if (this.isFollowed) {
                        if (this.hli) {
                            aVar.hlk.setText(R.string.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.hlk.setText(R.string.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.hlk.setText(R.string.him_no_attention_other);
                        } else {
                            aVar.hlk.setText(R.string.no_attention_other);
                        }
                    } else if (this.hli) {
                        aVar.hlk.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.hlk.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.hlk.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.hlk.setText(R.string.no_fan_other);
                    }
                } else {
                    UserData userData = (UserData) x.getItem(this.eYq, i);
                    if (userData == null) {
                        return null;
                    }
                    aVar.gRi.setTag(Integer.valueOf(i));
                    aVar.lsL.setVisibility(0);
                    aVar.hlk.setVisibility(8);
                    UtilHelper.showHeadImageViewBigV(aVar.lse, userData, 0);
                    aVar.mName.setText(UtilHelper.getUserName(userData));
                    aVar.lse.setPlaceHolder(1);
                    aVar.lse.startLoad(userData.getAvater(), 12, false);
                    if (aVar.lsf != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            aVar.lsf.setVisibility(8);
                        } else {
                            aVar.lsf.setVisibility(0);
                            com.baidu.tbadk.ala.a aVar3 = new com.baidu.tbadk.ala.a();
                            aVar3.eJe = userData.getAlaUserData();
                            aVar3.type = 5;
                            aVar.lsf.setTag(aVar3);
                        }
                    }
                    if (at.isEmpty(userData.getIntro())) {
                        aVar.gRm.setVisibility(8);
                    } else {
                        aVar.gRm.setVisibility(0);
                        aVar.gRm.setText(userData.getIntro());
                    }
                    aVar.lsL.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    aVar.lsg.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    aVar.alC.a(userData);
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        aVar.lsg.setVisibility(8);
                        aVar.lsL.setVisibility(8);
                    } else {
                        aVar.lsL.setVisibility(8);
                        aVar.lsg.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else if (getItemViewType(i) != 2) {
                aVar.mName.setText(this.lsa.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
            return view;
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.lsa.getLayoutMode().setNightMode(skinType == 1);
        this.lsa.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.lsL != null) {
                ao.setViewTextColor(aVar.lsL, R.color.btn_forum_focus_color, 1);
                ao.setBackgroundResource(aVar.lsL, R.drawable.btn_focus_border_bg);
                aVar.lsL.setEnabled(true);
            }
            if (aVar.lsM != null && aVar.mTitle != null) {
                ao.setBackgroundColor(aVar.lsM, R.color.CAM_X0205);
                ao.setViewTextColor(aVar.mTitle, R.color.CAM_X0110);
            }
            if (aVar.lsg != null) {
                aVar.lsg.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.hlg) {
            return 0;
        }
        if (this.eYq == null || i >= this.eYq.size()) {
            return 1;
        }
        return this.eYq.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.hlg) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c alC;
        ViewGroup gRi;
        TextView gRm;
        TextView hlk;
        LinearLayout hmk;
        TextView lsL;
        LinearLayout lsM;
        ClickableHeaderImageView lse;
        View lsf;
        MyFansUserLikeButton lsg;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
