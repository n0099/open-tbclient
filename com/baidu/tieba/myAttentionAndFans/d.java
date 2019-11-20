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
    boolean dGK;
    boolean dQT;
    private View.OnClickListener dRU;
    private PersonListActivity hxQ;
    private View.OnClickListener hxR;
    private View.OnClickListener hyt;
    private int mSex;
    boolean dQR = false;
    private HashSet<Long> hys = new HashSet<>();

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.hxQ = null;
        this.dGK = false;
        this.dQT = true;
        this.mSex = 0;
        this.hyt = null;
        this.hxR = null;
        this.dRU = null;
        this.hxQ = personListActivity;
        this.dGK = z;
        this.dQT = z2;
        this.mSex = i;
        this.hyt = onClickListener2;
        this.hxR = onClickListener3;
        this.dRU = onClickListener;
        this.bbH = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(as asVar) {
        ArrayList arrayList = new ArrayList();
        if (this.bbH.isEmpty() && !v.isEmpty(asVar.ahC())) {
            Iterator<UserData> it = asVar.ahC().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.hys.add(Long.valueOf(com.baidu.adp.lib.g.b.toLong(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(asVar.ahC());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(at(asVar.ahB()));
        this.bbH.addAll(arrayList);
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean dB(long j) {
        if (j == 0 || this.bbH == null || this.bbH.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.bbH.iterator();
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
        if (!v.isEmpty(arrayList) && !this.hys.isEmpty()) {
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.hys.contains(Long.valueOf(com.baidu.adp.lib.g.b.toLong(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dQR) {
            return 1;
        }
        int i = 0;
        if (this.bbH != null) {
            i = this.bbH.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bbH == null || i >= this.bbH.size()) {
            return null;
        }
        return this.bbH.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.bbH == null || i >= this.bbH.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (this.bbH != null) {
            if (view == null || !(view.getTag() instanceof a)) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.hxQ.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar2.dFJ = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar2.dFJ.setOnClickListener(this.dRU);
                    aVar2.hxT = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar2.hxT.setRadius(l.getDimens(this.hxQ.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar2.hxT.setAutoChangeStyle(true);
                    aVar2.hxT.setClickable(false);
                    aVar2.dRX = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.hxU = com.baidu.tbadk.ala.b.afa().l(this.hxQ.getPageContext().getPageActivity(), 5);
                    if (aVar2.hxU != null) {
                        aVar2.hxU.setVisibility(8);
                        aVar2.mContainer.addView(aVar2.hxU, 1);
                    }
                    aVar2.dQV = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.dFN = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.hyv = (TextView) inflate.findViewById(R.id.chat);
                    aVar2.hyv.setOnClickListener(this.hyt);
                    aVar2.hxV = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar2.hxV.setContext(this.hxQ.getPageContext());
                    aVar2.eLD = new com.baidu.tbadk.core.view.userLike.c(this.hxQ.getPageContext(), aVar2.hxV);
                    aVar2.mProgress = null;
                    aVar2.mTitle = null;
                    aVar2.hyw = null;
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    View inflate2 = LayoutInflater.from(this.hxQ.getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
                    aVar2.mTitle = (TextView) inflate2.findViewById(R.id.person_list_title);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.mTitle.getLayoutParams();
                    layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds16);
                    aVar2.mTitle.setLayoutParams(layoutParams);
                    aVar2.hyw = (LinearLayout) inflate2.findViewById(R.id.newheader_root);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.hxQ.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.hxR);
                    aVar2.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar2.mTitle = null;
                    aVar2.hyw = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.hxV != null) {
                aVar.hxV.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.dQR) {
                    aVar.dRX.setVisibility(8);
                    aVar.hyv.setVisibility(8);
                    aVar.dQV.setVisibility(0);
                    if (this.dGK) {
                        if (this.dQT) {
                            aVar.dQV.setText(R.string.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.dQV.setText(R.string.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.dQV.setText(R.string.him_no_attention_other);
                        } else {
                            aVar.dQV.setText(R.string.no_attention_other);
                        }
                    } else if (this.dQT) {
                        aVar.dQV.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.dQV.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.dQV.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.dQV.setText(R.string.no_fan_other);
                    }
                } else {
                    UserData userData = (UserData) v.getItem(this.bbH, i);
                    if (userData == null) {
                        return null;
                    }
                    aVar.dFJ.setTag(Integer.valueOf(i));
                    aVar.hyv.setVisibility(0);
                    aVar.dQV.setVisibility(8);
                    aVar.hxT.setShowV(userData.isBigV());
                    aVar.hxT.startLoad(userData.getPortrait(), 12, false);
                    aVar.mName.setText(userData.getName_show());
                    if (aVar.hxU != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            aVar.hxU.setVisibility(8);
                        } else {
                            aVar.hxU.setVisibility(0);
                            com.baidu.tbadk.ala.a aVar3 = new com.baidu.tbadk.ala.a();
                            aVar3.bTc = userData.getAlaUserData();
                            aVar3.type = 5;
                            aVar.hxU.setTag(aVar3);
                        }
                    }
                    if (aq.isEmpty(userData.getIntro())) {
                        aVar.dFN.setVisibility(8);
                    } else {
                        aVar.dFN.setVisibility(0);
                        aVar.dFN.setText(userData.getIntro());
                    }
                    aVar.hyv.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    aVar.hxV.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    aVar.eLD.a(userData);
                    aVar.eLD.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.d.1
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void ex(boolean z) {
                            if (z) {
                                l.showToast(d.this.hxQ, (int) R.string.attention_success);
                            } else {
                                l.showToast(d.this.hxQ, (int) R.string.unfollow_success);
                            }
                        }
                    });
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        aVar.hxV.setVisibility(8);
                        aVar.hyv.setVisibility(8);
                    } else {
                        aVar.hyv.setVisibility(8);
                        aVar.hxV.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else if (getItemViewType(i) != 2) {
                aVar.mName.setText(this.hxQ.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
            return view;
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.hxQ.getLayoutMode().setNightMode(skinType == 1);
        this.hxQ.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.hyv != null) {
                am.setViewTextColor(aVar.hyv, R.color.btn_forum_focus_color, 1);
                am.setBackgroundResource(aVar.hyv, R.drawable.btn_focus_border_bg);
                aVar.hyv.setEnabled(true);
            }
            if (aVar.hyw != null && aVar.mTitle != null) {
                am.setBackgroundColor(aVar.hyw, R.color.cp_bg_line_e);
                am.setViewTextColor(aVar.mTitle, (int) R.color.cp_cont_e);
            }
            if (aVar.hxV != null) {
                aVar.hxV.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.dQR) {
            return 0;
        }
        if (this.bbH == null || i >= this.bbH.size()) {
            return 1;
        }
        return this.bbH.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.dQR) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a {
        ViewGroup dFJ;
        TextView dFN;
        TextView dQV;
        LinearLayout dRX;
        com.baidu.tbadk.core.view.userLike.c eLD;
        ClickableHeaderImageView hxT;
        View hxU;
        MyFansUserLikeButton hxV;
        TextView hyv;
        LinearLayout hyw;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
