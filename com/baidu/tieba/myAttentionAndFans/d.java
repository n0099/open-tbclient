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
    boolean dLr;
    private View.OnClickListener egX;
    boolean fTQ;
    private PersonListActivity hqQ;
    private View.OnClickListener hqR;
    private View.OnClickListener hru;
    private int mSex;
    boolean hqP = false;
    private HashSet<Long> hrt = new HashSet<>();

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.hqQ = null;
        this.dLr = false;
        this.fTQ = true;
        this.mSex = 0;
        this.hru = null;
        this.hqR = null;
        this.egX = null;
        this.hqQ = personListActivity;
        this.dLr = z;
        this.fTQ = z2;
        this.mSex = i;
        this.hru = onClickListener2;
        this.hqR = onClickListener3;
        this.egX = onClickListener;
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
                    this.hrt.add(Long.valueOf(com.baidu.adp.lib.g.b.c(next.getUserId(), 0L)));
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
        if (!v.aa(arrayList) && !this.hrt.isEmpty()) {
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.hrt.contains(Long.valueOf(com.baidu.adp.lib.g.b.c(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hqP) {
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
                    View inflate = LayoutInflater.from(this.hqQ.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar2.dwq = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar2.dwq.setOnClickListener(this.egX);
                    aVar2.dwt = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar2.dwt.setRadius(l.g(this.hqQ.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar2.dwt.setAutoChangeStyle(true);
                    aVar2.dwt.setClickable(false);
                    aVar2.dwv = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.bZi = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.hqT = com.baidu.tbadk.ala.b.Zl().n(this.hqQ.getPageContext().getPageActivity(), 5);
                    if (aVar2.hqT != null) {
                        aVar2.hqT.setVisibility(8);
                        aVar2.bZi.addView(aVar2.hqT, 1);
                    }
                    aVar2.hqW = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.dwu = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.hrw = (TextView) inflate.findViewById(R.id.chat);
                    aVar2.hrw.setOnClickListener(this.hru);
                    aVar2.hqU = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar2.hqU.setContext(this.hqQ.getPageContext());
                    aVar2.ewX = new com.baidu.tbadk.core.view.userLike.c(this.hqQ.getPageContext(), aVar2.hqU);
                    aVar2.mProgress = null;
                    aVar2.mTitle = null;
                    aVar2.hrx = null;
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    View inflate2 = LayoutInflater.from(this.hqQ.getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
                    aVar2.mTitle = (TextView) inflate2.findViewById(R.id.person_list_title);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.mTitle.getLayoutParams();
                    layoutParams.height = l.g(TbadkCoreApplication.getInst(), R.dimen.ds16);
                    aVar2.mTitle.setLayoutParams(layoutParams);
                    aVar2.hrx = (LinearLayout) inflate2.findViewById(R.id.newheader_root);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.hqQ.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.hqR);
                    aVar2.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar2.mTitle = null;
                    aVar2.hrx = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.hqU != null) {
                aVar.hqU.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.hqP) {
                    aVar.dwv.setVisibility(8);
                    aVar.hrw.setVisibility(8);
                    aVar.hqW.setVisibility(0);
                    if (this.dLr) {
                        if (this.fTQ) {
                            aVar.hqW.setText(R.string.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.hqW.setText(R.string.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.hqW.setText(R.string.him_no_attention_other);
                        } else {
                            aVar.hqW.setText(R.string.no_attention_other);
                        }
                    } else if (this.fTQ) {
                        aVar.hqW.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.hqW.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.hqW.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.hqW.setText(R.string.no_fan_other);
                    }
                } else {
                    UserData userData = (UserData) v.c(this.aHF, i);
                    if (userData == null) {
                        return null;
                    }
                    aVar.dwq.setTag(Integer.valueOf(i));
                    aVar.hrw.setVisibility(0);
                    aVar.hqW.setVisibility(8);
                    aVar.dwt.setShowV(userData.isBigV());
                    aVar.dwt.startLoad(userData.getPortrait(), 12, false);
                    aVar.mName.setText(userData.getName_show());
                    if (aVar.hqT != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            aVar.hqT.setVisibility(8);
                        } else {
                            aVar.hqT.setVisibility(0);
                            com.baidu.tbadk.ala.a aVar3 = new com.baidu.tbadk.ala.a();
                            aVar3.bzQ = userData.getAlaUserData();
                            aVar3.type = 5;
                            aVar.hqT.setTag(aVar3);
                        }
                    }
                    if (ap.isEmpty(userData.getIntro())) {
                        aVar.dwu.setVisibility(8);
                    } else {
                        aVar.dwu.setVisibility(0);
                        aVar.dwu.setText(userData.getIntro());
                    }
                    aVar.hrw.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    aVar.hqU.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    aVar.ewX.a(userData);
                    aVar.ewX.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.d.1
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void es(boolean z) {
                            if (z) {
                                l.showToast(d.this.hqQ, (int) R.string.attention_success);
                            } else {
                                l.showToast(d.this.hqQ, (int) R.string.unfollow_success);
                            }
                        }
                    });
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        aVar.hqU.setVisibility(8);
                        aVar.hrw.setVisibility(8);
                    } else {
                        aVar.hrw.setVisibility(8);
                        aVar.hqU.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else if (getItemViewType(i) != 2) {
                aVar.mName.setText(this.hqQ.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
            return view;
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.hqQ.getLayoutMode().setNightMode(skinType == 1);
        this.hqQ.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.hrw != null) {
                al.f(aVar.hrw, R.color.btn_forum_focus_color, 1);
                al.k(aVar.hrw, R.drawable.btn_focus_border_bg);
                aVar.hrw.setEnabled(true);
            }
            if (aVar.hrx != null && aVar.mTitle != null) {
                al.l(aVar.hrx, R.color.cp_bg_line_e);
                al.j(aVar.mTitle, R.color.cp_cont_e);
            }
            if (aVar.hqU != null) {
                aVar.hqU.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.hqP) {
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
        if (this.hqP) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a {
        LinearLayout bZi;
        ViewGroup dwq;
        ClickableHeaderImageView dwt;
        TextView dwu;
        LinearLayout dwv;
        com.baidu.tbadk.core.view.userLike.c ewX;
        View hqT;
        MyFansUserLikeButton hqU;
        TextView hqW;
        TextView hrw;
        LinearLayout hrx;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
