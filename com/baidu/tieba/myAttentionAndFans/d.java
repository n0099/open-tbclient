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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
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
    boolean dLs;
    private View.OnClickListener egY;
    boolean fTR;
    private PersonListActivity hqT;
    private View.OnClickListener hqU;
    private View.OnClickListener hrx;
    private int mSex;
    boolean hqS = false;
    private HashSet<Long> hrw = new HashSet<>();

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.hqT = null;
        this.dLs = false;
        this.fTR = true;
        this.mSex = 0;
        this.hrx = null;
        this.hqU = null;
        this.egY = null;
        this.hqT = personListActivity;
        this.dLs = z;
        this.fTR = z2;
        this.mSex = i;
        this.hrx = onClickListener2;
        this.hqU = onClickListener3;
        this.egY = onClickListener;
        this.aHF = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(as asVar) {
        ArrayList arrayList = new ArrayList();
        if (this.aHF.isEmpty() && !v.aa(asVar.act())) {
            Iterator<UserData> it = asVar.act().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.hrw.add(Long.valueOf(com.baidu.adp.lib.g.b.c(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(asVar.act());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(ap(asVar.acs()));
        this.aHF.addAll(arrayList);
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean dU(long j) {
        if (j == 0 || this.aHF == null || this.aHF.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.aHF.iterator();
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

    private ArrayList<UserData> ap(ArrayList<UserData> arrayList) {
        if (!v.aa(arrayList) && !this.hrw.isEmpty()) {
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.hrw.contains(Long.valueOf(com.baidu.adp.lib.g.b.c(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hqS) {
            return 1;
        }
        int i = 0;
        if (this.aHF != null) {
            i = this.aHF.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aHF == null || i >= this.aHF.size()) {
            return null;
        }
        return this.aHF.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.aHF == null || i >= this.aHF.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (this.aHF != null) {
            if (view == null || !(view.getTag() instanceof a)) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.hqT.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar2.dwr = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar2.dwr.setOnClickListener(this.egY);
                    aVar2.dwu = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar2.dwu.setRadius(l.g(this.hqT.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar2.dwu.setAutoChangeStyle(true);
                    aVar2.dwu.setClickable(false);
                    aVar2.dww = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.bZi = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.hqW = com.baidu.tbadk.ala.b.Zl().n(this.hqT.getPageContext().getPageActivity(), 5);
                    if (aVar2.hqW != null) {
                        aVar2.hqW.setVisibility(8);
                        aVar2.bZi.addView(aVar2.hqW, 1);
                    }
                    aVar2.hqZ = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.dwv = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.hrz = (TextView) inflate.findViewById(R.id.chat);
                    aVar2.hrz.setOnClickListener(this.hrx);
                    aVar2.hqX = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar2.hqX.setContext(this.hqT.getPageContext());
                    aVar2.ewY = new com.baidu.tbadk.core.view.userLike.c(this.hqT.getPageContext(), aVar2.hqX);
                    aVar2.mProgress = null;
                    aVar2.mTitle = null;
                    aVar2.hrA = null;
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    View inflate2 = LayoutInflater.from(this.hqT.getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
                    aVar2.mTitle = (TextView) inflate2.findViewById(R.id.person_list_title);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.mTitle.getLayoutParams();
                    layoutParams.height = l.g(TbadkCoreApplication.getInst(), R.dimen.ds16);
                    aVar2.mTitle.setLayoutParams(layoutParams);
                    aVar2.hrA = (LinearLayout) inflate2.findViewById(R.id.newheader_root);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.hqT.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.hqU);
                    aVar2.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar2.mTitle = null;
                    aVar2.hrA = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.hqX != null) {
                aVar.hqX.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.hqS) {
                    aVar.dww.setVisibility(8);
                    aVar.hrz.setVisibility(8);
                    aVar.hqZ.setVisibility(0);
                    if (this.dLs) {
                        if (this.fTR) {
                            aVar.hqZ.setText(R.string.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.hqZ.setText(R.string.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.hqZ.setText(R.string.him_no_attention_other);
                        } else {
                            aVar.hqZ.setText(R.string.no_attention_other);
                        }
                    } else if (this.fTR) {
                        aVar.hqZ.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.hqZ.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.hqZ.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.hqZ.setText(R.string.no_fan_other);
                    }
                } else {
                    UserData userData = (UserData) v.c(this.aHF, i);
                    if (userData == null) {
                        return null;
                    }
                    aVar.dwr.setTag(Integer.valueOf(i));
                    aVar.hrz.setVisibility(0);
                    aVar.hqZ.setVisibility(8);
                    aVar.dwu.setShowV(userData.isBigV());
                    aVar.dwu.startLoad(userData.getPortrait(), 12, false);
                    aVar.mName.setText(userData.getName_show());
                    if (aVar.hqW != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            aVar.hqW.setVisibility(8);
                        } else {
                            aVar.hqW.setVisibility(0);
                            com.baidu.tbadk.ala.a aVar3 = new com.baidu.tbadk.ala.a();
                            aVar3.bzQ = userData.getAlaUserData();
                            aVar3.type = 5;
                            aVar.hqW.setTag(aVar3);
                        }
                    }
                    if (ap.isEmpty(userData.getIntro())) {
                        aVar.dwv.setVisibility(8);
                    } else {
                        aVar.dwv.setVisibility(0);
                        aVar.dwv.setText(userData.getIntro());
                    }
                    aVar.hrz.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    aVar.hqX.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    aVar.ewY.a(userData);
                    aVar.ewY.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.d.1
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void es(boolean z) {
                            if (z) {
                                l.showToast(d.this.hqT, (int) R.string.attention_success);
                            } else {
                                l.showToast(d.this.hqT, (int) R.string.unfollow_success);
                            }
                        }
                    });
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        aVar.hqX.setVisibility(8);
                        aVar.hrz.setVisibility(8);
                    } else {
                        aVar.hrz.setVisibility(8);
                        aVar.hqX.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else if (getItemViewType(i) != 2) {
                aVar.mName.setText(this.hqT.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
            return view;
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.hqT.getLayoutMode().setNightMode(skinType == 1);
        this.hqT.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.hrz != null) {
                al.f(aVar.hrz, R.color.btn_forum_focus_color, 1);
                al.k(aVar.hrz, R.drawable.btn_focus_border_bg);
                aVar.hrz.setEnabled(true);
            }
            if (aVar.hrA != null && aVar.mTitle != null) {
                al.l(aVar.hrA, R.color.cp_bg_line_e);
                al.j(aVar.mTitle, R.color.cp_cont_e);
            }
            if (aVar.hqX != null) {
                aVar.hqX.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.hqS) {
            return 0;
        }
        if (this.aHF == null || i >= this.aHF.size()) {
            return 1;
        }
        return this.aHF.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.hqS) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a {
        LinearLayout bZi;
        ViewGroup dwr;
        ClickableHeaderImageView dwu;
        TextView dwv;
        LinearLayout dww;
        com.baidu.tbadk.core.view.userLike.c ewY;
        View hqW;
        MyFansUserLikeButton hqX;
        TextView hqZ;
        LinearLayout hrA;
        TextView hrz;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
