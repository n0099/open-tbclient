package com.baidu.tieba.myAttentionAndFans;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class d extends b {
    boolean dHB;
    boolean dRK;
    private View.OnClickListener dSL;
    private PersonListActivity hyH;
    private View.OnClickListener hyI;
    private View.OnClickListener hzk;
    private int mSex;
    boolean dRI = false;
    private HashSet<Long> hzj = new HashSet<>();

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.hyH = null;
        this.dHB = false;
        this.dRK = true;
        this.mSex = 0;
        this.hzk = null;
        this.hyI = null;
        this.dSL = null;
        this.hyH = personListActivity;
        this.dHB = z;
        this.dRK = z2;
        this.mSex = i;
        this.hzk = onClickListener2;
        this.hyI = onClickListener3;
        this.dSL = onClickListener;
        this.bbZ = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(as asVar) {
        ArrayList arrayList = new ArrayList();
        if (this.bbZ.isEmpty() && !v.isEmpty(asVar.ahE())) {
            Iterator<UserData> it = asVar.ahE().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.hzj.add(Long.valueOf(com.baidu.adp.lib.g.b.toLong(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(asVar.ahE());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(at(asVar.ahD()));
        this.bbZ.addAll(arrayList);
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean dC(long j) {
        if (j == 0 || this.bbZ == null || this.bbZ.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.bbZ.iterator();
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

    private ArrayList<UserData> at(ArrayList<UserData> arrayList) {
        if (!v.isEmpty(arrayList) && !this.hzj.isEmpty()) {
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.hzj.contains(Long.valueOf(com.baidu.adp.lib.g.b.toLong(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dRI) {
            return 1;
        }
        int i = 0;
        if (this.bbZ != null) {
            i = this.bbZ.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bbZ == null || i >= this.bbZ.size()) {
            return null;
        }
        return this.bbZ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.bbZ == null || i >= this.bbZ.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (this.bbZ != null) {
            if (view == null || !(view.getTag() instanceof a)) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.hyH.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar2.dGA = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar2.dGA.setOnClickListener(this.dSL);
                    aVar2.hyK = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar2.hyK.setRadius(l.getDimens(this.hyH.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar2.hyK.setAutoChangeStyle(true);
                    aVar2.hyK.setClickable(false);
                    aVar2.dSO = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.hyL = com.baidu.tbadk.ala.b.afc().l(this.hyH.getPageContext().getPageActivity(), 5);
                    if (aVar2.hyL != null) {
                        aVar2.hyL.setVisibility(8);
                        aVar2.mContainer.addView(aVar2.hyL, 1);
                    }
                    aVar2.dRM = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.dGE = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.hzm = (TextView) inflate.findViewById(R.id.chat);
                    aVar2.hzm.setOnClickListener(this.hzk);
                    aVar2.hyM = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar2.hyM.setContext(this.hyH.getPageContext());
                    aVar2.eMu = new com.baidu.tbadk.core.view.userLike.c(this.hyH.getPageContext(), aVar2.hyM);
                    aVar2.mProgress = null;
                    aVar2.mTitle = null;
                    aVar2.hzn = null;
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    View inflate2 = LayoutInflater.from(this.hyH.getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
                    aVar2.mTitle = (TextView) inflate2.findViewById(R.id.person_list_title);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.mTitle.getLayoutParams();
                    layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds16);
                    aVar2.mTitle.setLayoutParams(layoutParams);
                    aVar2.hzn = (LinearLayout) inflate2.findViewById(R.id.newheader_root);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.hyH.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.hyI);
                    aVar2.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar2.mTitle = null;
                    aVar2.hzn = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.hyM != null) {
                aVar.hyM.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.dRI) {
                    aVar.dSO.setVisibility(8);
                    aVar.hzm.setVisibility(8);
                    aVar.dRM.setVisibility(0);
                    if (this.dHB) {
                        if (this.dRK) {
                            aVar.dRM.setText(R.string.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.dRM.setText(R.string.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.dRM.setText(R.string.him_no_attention_other);
                        } else {
                            aVar.dRM.setText(R.string.no_attention_other);
                        }
                    } else if (this.dRK) {
                        aVar.dRM.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.dRM.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.dRM.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.dRM.setText(R.string.no_fan_other);
                    }
                } else {
                    UserData userData = (UserData) v.getItem(this.bbZ, i);
                    if (userData == null) {
                        return null;
                    }
                    aVar.dGA.setTag(Integer.valueOf(i));
                    aVar.hzm.setVisibility(0);
                    aVar.dRM.setVisibility(8);
                    aVar.hyK.setShowV(userData.isBigV());
                    aVar.hyK.startLoad(userData.getPortrait(), 12, false);
                    aVar.mName.setText(userData.getName_show());
                    if (aVar.hyL != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            aVar.hyL.setVisibility(8);
                        } else {
                            aVar.hyL.setVisibility(0);
                            com.baidu.tbadk.ala.a aVar3 = new com.baidu.tbadk.ala.a();
                            aVar3.bTT = userData.getAlaUserData();
                            aVar3.type = 5;
                            aVar.hyL.setTag(aVar3);
                        }
                    }
                    if (aq.isEmpty(userData.getIntro())) {
                        aVar.dGE.setVisibility(8);
                    } else {
                        aVar.dGE.setVisibility(0);
                        aVar.dGE.setText(userData.getIntro());
                    }
                    aVar.hzm.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    aVar.hyM.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    aVar.eMu.a(userData);
                    aVar.eMu.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.d.1
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void ex(boolean z) {
                            if (z) {
                                l.showToast(d.this.hyH, (int) R.string.attention_success);
                            } else {
                                l.showToast(d.this.hyH, (int) R.string.unfollow_success);
                            }
                        }
                    });
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        aVar.hyM.setVisibility(8);
                        aVar.hzm.setVisibility(8);
                    } else {
                        aVar.hzm.setVisibility(8);
                        aVar.hyM.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else if (getItemViewType(i) != 2) {
                aVar.mName.setText(this.hyH.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
            return view;
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.hyH.getLayoutMode().setNightMode(skinType == 1);
        this.hyH.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.hzm != null) {
                am.setViewTextColor(aVar.hzm, R.color.btn_forum_focus_color, 1);
                am.setBackgroundResource(aVar.hzm, R.drawable.btn_focus_border_bg);
                aVar.hzm.setEnabled(true);
            }
            if (aVar.hzn != null && aVar.mTitle != null) {
                am.setBackgroundColor(aVar.hzn, R.color.cp_bg_line_e);
                am.setViewTextColor(aVar.mTitle, (int) R.color.cp_cont_e);
            }
            if (aVar.hyM != null) {
                aVar.hyM.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.dRI) {
            return 0;
        }
        if (this.bbZ == null || i >= this.bbZ.size()) {
            return 1;
        }
        return this.bbZ.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.dRI) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a {
        ViewGroup dGA;
        TextView dGE;
        TextView dRM;
        LinearLayout dSO;
        com.baidu.tbadk.core.view.userLike.c eMu;
        ClickableHeaderImageView hyK;
        View hyL;
        MyFansUserLikeButton hyM;
        TextView hzm;
        LinearLayout hzn;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
