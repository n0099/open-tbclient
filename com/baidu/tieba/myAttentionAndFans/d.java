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
    boolean dPa;
    private View.OnClickListener elC;
    boolean fYQ;
    private View.OnClickListener hxK;
    private PersonListActivity hxg;
    private View.OnClickListener hxh;
    private int mSex;
    boolean hxf = false;
    private HashSet<Long> hxJ = new HashSet<>();

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.hxg = null;
        this.dPa = false;
        this.fYQ = true;
        this.mSex = 0;
        this.hxK = null;
        this.hxh = null;
        this.elC = null;
        this.hxg = personListActivity;
        this.dPa = z;
        this.fYQ = z2;
        this.mSex = i;
        this.hxK = onClickListener2;
        this.hxh = onClickListener3;
        this.elC = onClickListener;
        this.aIn = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(as asVar) {
        ArrayList arrayList = new ArrayList();
        if (this.aIn.isEmpty() && !v.aa(asVar.adv())) {
            Iterator<UserData> it = asVar.adv().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.hxJ.add(Long.valueOf(com.baidu.adp.lib.g.b.c(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(asVar.adv());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(ap(asVar.adu()));
        this.aIn.addAll(arrayList);
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean ee(long j) {
        if (j == 0 || this.aIn == null || this.aIn.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.aIn.iterator();
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
        if (!v.aa(arrayList) && !this.hxJ.isEmpty()) {
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.hxJ.contains(Long.valueOf(com.baidu.adp.lib.g.b.c(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hxf) {
            return 1;
        }
        int i = 0;
        if (this.aIn != null) {
            i = this.aIn.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aIn == null || i >= this.aIn.size()) {
            return null;
        }
        return this.aIn.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.aIn == null || i >= this.aIn.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (this.aIn != null) {
            if (view == null || !(view.getTag() instanceof a)) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.hxg.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar2.dzp = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar2.dzp.setOnClickListener(this.elC);
                    aVar2.dzs = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar2.dzs.setRadius(l.g(this.hxg.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar2.dzs.setAutoChangeStyle(true);
                    aVar2.dzs.setClickable(false);
                    aVar2.dzu = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.cal = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.hxj = com.baidu.tbadk.ala.b.aak().n(this.hxg.getPageContext().getPageActivity(), 5);
                    if (aVar2.hxj != null) {
                        aVar2.hxj.setVisibility(8);
                        aVar2.cal.addView(aVar2.hxj, 1);
                    }
                    aVar2.hxm = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.dzt = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.hxM = (TextView) inflate.findViewById(R.id.chat);
                    aVar2.hxM.setOnClickListener(this.hxK);
                    aVar2.hxk = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar2.hxk.setContext(this.hxg.getPageContext());
                    aVar2.eBX = new com.baidu.tbadk.core.view.userLike.c(this.hxg.getPageContext(), aVar2.hxk);
                    aVar2.mProgress = null;
                    aVar2.mTitle = null;
                    aVar2.hxN = null;
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    View inflate2 = LayoutInflater.from(this.hxg.getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
                    aVar2.mTitle = (TextView) inflate2.findViewById(R.id.person_list_title);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.mTitle.getLayoutParams();
                    layoutParams.height = l.g(TbadkCoreApplication.getInst(), R.dimen.ds16);
                    aVar2.mTitle.setLayoutParams(layoutParams);
                    aVar2.hxN = (LinearLayout) inflate2.findViewById(R.id.newheader_root);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.hxg.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.hxh);
                    aVar2.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar2.mTitle = null;
                    aVar2.hxN = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.hxk != null) {
                aVar.hxk.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.hxf) {
                    aVar.dzu.setVisibility(8);
                    aVar.hxM.setVisibility(8);
                    aVar.hxm.setVisibility(0);
                    if (this.dPa) {
                        if (this.fYQ) {
                            aVar.hxm.setText(R.string.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.hxm.setText(R.string.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.hxm.setText(R.string.him_no_attention_other);
                        } else {
                            aVar.hxm.setText(R.string.no_attention_other);
                        }
                    } else if (this.fYQ) {
                        aVar.hxm.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.hxm.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.hxm.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.hxm.setText(R.string.no_fan_other);
                    }
                } else {
                    UserData userData = (UserData) v.c(this.aIn, i);
                    if (userData == null) {
                        return null;
                    }
                    aVar.dzp.setTag(Integer.valueOf(i));
                    aVar.hxM.setVisibility(0);
                    aVar.hxm.setVisibility(8);
                    aVar.dzs.setShowV(userData.isBigV());
                    aVar.dzs.startLoad(userData.getPortrait(), 12, false);
                    aVar.mName.setText(userData.getName_show());
                    if (aVar.hxj != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            aVar.hxj.setVisibility(8);
                        } else {
                            aVar.hxj.setVisibility(0);
                            com.baidu.tbadk.ala.a aVar3 = new com.baidu.tbadk.ala.a();
                            aVar3.bAN = userData.getAlaUserData();
                            aVar3.type = 5;
                            aVar.hxj.setTag(aVar3);
                        }
                    }
                    if (aq.isEmpty(userData.getIntro())) {
                        aVar.dzt.setVisibility(8);
                    } else {
                        aVar.dzt.setVisibility(0);
                        aVar.dzt.setText(userData.getIntro());
                    }
                    aVar.hxM.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    aVar.hxk.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    aVar.eBX.a(userData);
                    aVar.eBX.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.d.1
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void ew(boolean z) {
                            if (z) {
                                l.showToast(d.this.hxg, (int) R.string.attention_success);
                            } else {
                                l.showToast(d.this.hxg, (int) R.string.unfollow_success);
                            }
                        }
                    });
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        aVar.hxk.setVisibility(8);
                        aVar.hxM.setVisibility(8);
                    } else {
                        aVar.hxM.setVisibility(8);
                        aVar.hxk.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else if (getItemViewType(i) != 2) {
                aVar.mName.setText(this.hxg.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
            return view;
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.hxg.getLayoutMode().setNightMode(skinType == 1);
        this.hxg.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.hxM != null) {
                am.f(aVar.hxM, R.color.btn_forum_focus_color, 1);
                am.k(aVar.hxM, R.drawable.btn_focus_border_bg);
                aVar.hxM.setEnabled(true);
            }
            if (aVar.hxN != null && aVar.mTitle != null) {
                am.l(aVar.hxN, R.color.cp_bg_line_e);
                am.j(aVar.mTitle, R.color.cp_cont_e);
            }
            if (aVar.hxk != null) {
                aVar.hxk.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.hxf) {
            return 0;
        }
        if (this.aIn == null || i >= this.aIn.size()) {
            return 1;
        }
        return this.aIn.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.hxf) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a {
        LinearLayout cal;
        ViewGroup dzp;
        ClickableHeaderImageView dzs;
        TextView dzt;
        LinearLayout dzu;
        com.baidu.tbadk.core.view.userLike.c eBX;
        TextView hxM;
        LinearLayout hxN;
        View hxj;
        MyFansUserLikeButton hxk;
        TextView hxm;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
