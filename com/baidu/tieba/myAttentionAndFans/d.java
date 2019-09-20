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
    boolean dQS;
    private View.OnClickListener enu;
    boolean gbx;
    private View.OnClickListener hAy;
    private PersonListActivity hzU;
    private View.OnClickListener hzV;
    private int mSex;
    boolean hzT = false;
    private HashSet<Long> hAx = new HashSet<>();

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.hzU = null;
        this.dQS = false;
        this.gbx = true;
        this.mSex = 0;
        this.hAy = null;
        this.hzV = null;
        this.enu = null;
        this.hzU = personListActivity;
        this.dQS = z;
        this.gbx = z2;
        this.mSex = i;
        this.hAy = onClickListener2;
        this.hzV = onClickListener3;
        this.enu = onClickListener;
        this.aIL = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(as asVar) {
        ArrayList arrayList = new ArrayList();
        if (this.aIL.isEmpty() && !v.aa(asVar.adA())) {
            Iterator<UserData> it = asVar.adA().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.hAx.add(Long.valueOf(com.baidu.adp.lib.g.b.e(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(asVar.adA());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(ap(asVar.adz()));
        this.aIL.addAll(arrayList);
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean eh(long j) {
        if (j == 0 || this.aIL == null || this.aIL.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.aIL.iterator();
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
        if (!v.aa(arrayList) && !this.hAx.isEmpty()) {
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.hAx.contains(Long.valueOf(com.baidu.adp.lib.g.b.e(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hzT) {
            return 1;
        }
        int i = 0;
        if (this.aIL != null) {
            i = this.aIL.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aIL == null || i >= this.aIL.size()) {
            return null;
        }
        return this.aIL.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.aIL == null || i >= this.aIL.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (this.aIL != null) {
            if (view == null || !(view.getTag() instanceof a)) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.hzU.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar2.dBh = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar2.dBh.setOnClickListener(this.enu);
                    aVar2.dBk = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar2.dBk.setRadius(l.g(this.hzU.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar2.dBk.setAutoChangeStyle(true);
                    aVar2.dBk.setClickable(false);
                    aVar2.dBm = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.cbk = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.hzX = com.baidu.tbadk.ala.b.aao().n(this.hzU.getPageContext().getPageActivity(), 5);
                    if (aVar2.hzX != null) {
                        aVar2.hzX.setVisibility(8);
                        aVar2.cbk.addView(aVar2.hzX, 1);
                    }
                    aVar2.hAa = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.dBl = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.hAA = (TextView) inflate.findViewById(R.id.chat);
                    aVar2.hAA.setOnClickListener(this.hAy);
                    aVar2.hzY = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar2.hzY.setContext(this.hzU.getPageContext());
                    aVar2.eDN = new com.baidu.tbadk.core.view.userLike.c(this.hzU.getPageContext(), aVar2.hzY);
                    aVar2.mProgress = null;
                    aVar2.mTitle = null;
                    aVar2.hAB = null;
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    View inflate2 = LayoutInflater.from(this.hzU.getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
                    aVar2.mTitle = (TextView) inflate2.findViewById(R.id.person_list_title);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.mTitle.getLayoutParams();
                    layoutParams.height = l.g(TbadkCoreApplication.getInst(), R.dimen.ds16);
                    aVar2.mTitle.setLayoutParams(layoutParams);
                    aVar2.hAB = (LinearLayout) inflate2.findViewById(R.id.newheader_root);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.hzU.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.hzV);
                    aVar2.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar2.mTitle = null;
                    aVar2.hAB = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.hzY != null) {
                aVar.hzY.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.hzT) {
                    aVar.dBm.setVisibility(8);
                    aVar.hAA.setVisibility(8);
                    aVar.hAa.setVisibility(0);
                    if (this.dQS) {
                        if (this.gbx) {
                            aVar.hAa.setText(R.string.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.hAa.setText(R.string.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.hAa.setText(R.string.him_no_attention_other);
                        } else {
                            aVar.hAa.setText(R.string.no_attention_other);
                        }
                    } else if (this.gbx) {
                        aVar.hAa.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.hAa.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.hAa.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.hAa.setText(R.string.no_fan_other);
                    }
                } else {
                    UserData userData = (UserData) v.c(this.aIL, i);
                    if (userData == null) {
                        return null;
                    }
                    aVar.dBh.setTag(Integer.valueOf(i));
                    aVar.hAA.setVisibility(0);
                    aVar.hAa.setVisibility(8);
                    aVar.dBk.setShowV(userData.isBigV());
                    aVar.dBk.startLoad(userData.getPortrait(), 12, false);
                    aVar.mName.setText(userData.getName_show());
                    if (aVar.hzX != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            aVar.hzX.setVisibility(8);
                        } else {
                            aVar.hzX.setVisibility(0);
                            com.baidu.tbadk.ala.a aVar3 = new com.baidu.tbadk.ala.a();
                            aVar3.bBl = userData.getAlaUserData();
                            aVar3.type = 5;
                            aVar.hzX.setTag(aVar3);
                        }
                    }
                    if (aq.isEmpty(userData.getIntro())) {
                        aVar.dBl.setVisibility(8);
                    } else {
                        aVar.dBl.setVisibility(0);
                        aVar.dBl.setText(userData.getIntro());
                    }
                    aVar.hAA.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    aVar.hzY.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    aVar.eDN.a(userData);
                    aVar.eDN.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.d.1
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void ez(boolean z) {
                            if (z) {
                                l.showToast(d.this.hzU, (int) R.string.attention_success);
                            } else {
                                l.showToast(d.this.hzU, (int) R.string.unfollow_success);
                            }
                        }
                    });
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        aVar.hzY.setVisibility(8);
                        aVar.hAA.setVisibility(8);
                    } else {
                        aVar.hAA.setVisibility(8);
                        aVar.hzY.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else if (getItemViewType(i) != 2) {
                aVar.mName.setText(this.hzU.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
            return view;
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.hzU.getLayoutMode().setNightMode(skinType == 1);
        this.hzU.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.hAA != null) {
                am.f(aVar.hAA, R.color.btn_forum_focus_color, 1);
                am.k(aVar.hAA, R.drawable.btn_focus_border_bg);
                aVar.hAA.setEnabled(true);
            }
            if (aVar.hAB != null && aVar.mTitle != null) {
                am.l(aVar.hAB, R.color.cp_bg_line_e);
                am.j(aVar.mTitle, R.color.cp_cont_e);
            }
            if (aVar.hzY != null) {
                aVar.hzY.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.hzT) {
            return 0;
        }
        if (this.aIL == null || i >= this.aIL.size()) {
            return 1;
        }
        return this.aIL.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.hzT) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a {
        LinearLayout cbk;
        ViewGroup dBh;
        ClickableHeaderImageView dBk;
        TextView dBl;
        LinearLayout dBm;
        com.baidu.tbadk.core.view.userLike.c eDN;
        TextView hAA;
        LinearLayout hAB;
        TextView hAa;
        View hzX;
        MyFansUserLikeButton hzY;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
