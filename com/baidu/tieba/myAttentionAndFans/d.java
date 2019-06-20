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
    boolean fTT;
    private PersonListActivity hqU;
    private View.OnClickListener hqV;
    private View.OnClickListener hry;
    private int mSex;
    boolean hqT = false;
    private HashSet<Long> hrx = new HashSet<>();

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.hqU = null;
        this.dLs = false;
        this.fTT = true;
        this.mSex = 0;
        this.hry = null;
        this.hqV = null;
        this.egY = null;
        this.hqU = personListActivity;
        this.dLs = z;
        this.fTT = z2;
        this.mSex = i;
        this.hry = onClickListener2;
        this.hqV = onClickListener3;
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
                    this.hrx.add(Long.valueOf(com.baidu.adp.lib.g.b.c(next.getUserId(), 0L)));
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
        if (!v.aa(arrayList) && !this.hrx.isEmpty()) {
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.hrx.contains(Long.valueOf(com.baidu.adp.lib.g.b.c(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hqT) {
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
                    View inflate = LayoutInflater.from(this.hqU.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar2.dwr = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar2.dwr.setOnClickListener(this.egY);
                    aVar2.dwu = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar2.dwu.setRadius(l.g(this.hqU.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar2.dwu.setAutoChangeStyle(true);
                    aVar2.dwu.setClickable(false);
                    aVar2.dww = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.bZj = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.hqX = com.baidu.tbadk.ala.b.Zl().n(this.hqU.getPageContext().getPageActivity(), 5);
                    if (aVar2.hqX != null) {
                        aVar2.hqX.setVisibility(8);
                        aVar2.bZj.addView(aVar2.hqX, 1);
                    }
                    aVar2.hra = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.dwv = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.hrA = (TextView) inflate.findViewById(R.id.chat);
                    aVar2.hrA.setOnClickListener(this.hry);
                    aVar2.hqY = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar2.hqY.setContext(this.hqU.getPageContext());
                    aVar2.ewY = new com.baidu.tbadk.core.view.userLike.c(this.hqU.getPageContext(), aVar2.hqY);
                    aVar2.mProgress = null;
                    aVar2.mTitle = null;
                    aVar2.hrB = null;
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    View inflate2 = LayoutInflater.from(this.hqU.getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
                    aVar2.mTitle = (TextView) inflate2.findViewById(R.id.person_list_title);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.mTitle.getLayoutParams();
                    layoutParams.height = l.g(TbadkCoreApplication.getInst(), R.dimen.ds16);
                    aVar2.mTitle.setLayoutParams(layoutParams);
                    aVar2.hrB = (LinearLayout) inflate2.findViewById(R.id.newheader_root);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.hqU.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.hqV);
                    aVar2.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar2.mTitle = null;
                    aVar2.hrB = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.hqY != null) {
                aVar.hqY.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.hqT) {
                    aVar.dww.setVisibility(8);
                    aVar.hrA.setVisibility(8);
                    aVar.hra.setVisibility(0);
                    if (this.dLs) {
                        if (this.fTT) {
                            aVar.hra.setText(R.string.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.hra.setText(R.string.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.hra.setText(R.string.him_no_attention_other);
                        } else {
                            aVar.hra.setText(R.string.no_attention_other);
                        }
                    } else if (this.fTT) {
                        aVar.hra.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.hra.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.hra.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.hra.setText(R.string.no_fan_other);
                    }
                } else {
                    UserData userData = (UserData) v.c(this.aHF, i);
                    if (userData == null) {
                        return null;
                    }
                    aVar.dwr.setTag(Integer.valueOf(i));
                    aVar.hrA.setVisibility(0);
                    aVar.hra.setVisibility(8);
                    aVar.dwu.setShowV(userData.isBigV());
                    aVar.dwu.startLoad(userData.getPortrait(), 12, false);
                    aVar.mName.setText(userData.getName_show());
                    if (aVar.hqX != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            aVar.hqX.setVisibility(8);
                        } else {
                            aVar.hqX.setVisibility(0);
                            com.baidu.tbadk.ala.a aVar3 = new com.baidu.tbadk.ala.a();
                            aVar3.bzQ = userData.getAlaUserData();
                            aVar3.type = 5;
                            aVar.hqX.setTag(aVar3);
                        }
                    }
                    if (ap.isEmpty(userData.getIntro())) {
                        aVar.dwv.setVisibility(8);
                    } else {
                        aVar.dwv.setVisibility(0);
                        aVar.dwv.setText(userData.getIntro());
                    }
                    aVar.hrA.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    aVar.hqY.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    aVar.ewY.a(userData);
                    aVar.ewY.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.d.1
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void es(boolean z) {
                            if (z) {
                                l.showToast(d.this.hqU, (int) R.string.attention_success);
                            } else {
                                l.showToast(d.this.hqU, (int) R.string.unfollow_success);
                            }
                        }
                    });
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        aVar.hqY.setVisibility(8);
                        aVar.hrA.setVisibility(8);
                    } else {
                        aVar.hrA.setVisibility(8);
                        aVar.hqY.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else if (getItemViewType(i) != 2) {
                aVar.mName.setText(this.hqU.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
            return view;
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.hqU.getLayoutMode().setNightMode(skinType == 1);
        this.hqU.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.hrA != null) {
                al.f(aVar.hrA, R.color.btn_forum_focus_color, 1);
                al.k(aVar.hrA, R.drawable.btn_focus_border_bg);
                aVar.hrA.setEnabled(true);
            }
            if (aVar.hrB != null && aVar.mTitle != null) {
                al.l(aVar.hrB, R.color.cp_bg_line_e);
                al.j(aVar.mTitle, R.color.cp_cont_e);
            }
            if (aVar.hqY != null) {
                aVar.hqY.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.hqT) {
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
        if (this.hqT) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a {
        LinearLayout bZj;
        ViewGroup dwr;
        ClickableHeaderImageView dwu;
        TextView dwv;
        LinearLayout dww;
        com.baidu.tbadk.core.view.userLike.c ewY;
        View hqX;
        MyFansUserLikeButton hqY;
        TextView hrA;
        LinearLayout hrB;
        TextView hra;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
