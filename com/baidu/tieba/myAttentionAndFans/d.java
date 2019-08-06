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
    boolean dPh;
    private View.OnClickListener elJ;
    boolean fZG;
    private PersonListActivity hxY;
    private View.OnClickListener hxZ;
    private View.OnClickListener hyC;
    private int mSex;
    boolean hxX = false;
    private HashSet<Long> hyB = new HashSet<>();

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.hxY = null;
        this.dPh = false;
        this.fZG = true;
        this.mSex = 0;
        this.hyC = null;
        this.hxZ = null;
        this.elJ = null;
        this.hxY = personListActivity;
        this.dPh = z;
        this.fZG = z2;
        this.mSex = i;
        this.hyC = onClickListener2;
        this.hxZ = onClickListener3;
        this.elJ = onClickListener;
        this.aIn = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(as asVar) {
        ArrayList arrayList = new ArrayList();
        if (this.aIn.isEmpty() && !v.aa(asVar.adw())) {
            Iterator<UserData> it = asVar.adw().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.hyB.add(Long.valueOf(com.baidu.adp.lib.g.b.c(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(asVar.adw());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(ap(asVar.adv()));
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
        if (!v.aa(arrayList) && !this.hyB.isEmpty()) {
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.hyB.contains(Long.valueOf(com.baidu.adp.lib.g.b.c(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hxX) {
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
                    View inflate = LayoutInflater.from(this.hxY.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar2.dzw = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar2.dzw.setOnClickListener(this.elJ);
                    aVar2.dzz = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar2.dzz.setRadius(l.g(this.hxY.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar2.dzz.setAutoChangeStyle(true);
                    aVar2.dzz.setClickable(false);
                    aVar2.dzB = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.car = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.hyb = com.baidu.tbadk.ala.b.aak().n(this.hxY.getPageContext().getPageActivity(), 5);
                    if (aVar2.hyb != null) {
                        aVar2.hyb.setVisibility(8);
                        aVar2.car.addView(aVar2.hyb, 1);
                    }
                    aVar2.hye = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.dzA = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.hyE = (TextView) inflate.findViewById(R.id.chat);
                    aVar2.hyE.setOnClickListener(this.hyC);
                    aVar2.hyc = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar2.hyc.setContext(this.hxY.getPageContext());
                    aVar2.eCe = new com.baidu.tbadk.core.view.userLike.c(this.hxY.getPageContext(), aVar2.hyc);
                    aVar2.mProgress = null;
                    aVar2.mTitle = null;
                    aVar2.hyF = null;
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    View inflate2 = LayoutInflater.from(this.hxY.getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
                    aVar2.mTitle = (TextView) inflate2.findViewById(R.id.person_list_title);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.mTitle.getLayoutParams();
                    layoutParams.height = l.g(TbadkCoreApplication.getInst(), R.dimen.ds16);
                    aVar2.mTitle.setLayoutParams(layoutParams);
                    aVar2.hyF = (LinearLayout) inflate2.findViewById(R.id.newheader_root);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.hxY.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.hxZ);
                    aVar2.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar2.mTitle = null;
                    aVar2.hyF = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.hyc != null) {
                aVar.hyc.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.hxX) {
                    aVar.dzB.setVisibility(8);
                    aVar.hyE.setVisibility(8);
                    aVar.hye.setVisibility(0);
                    if (this.dPh) {
                        if (this.fZG) {
                            aVar.hye.setText(R.string.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.hye.setText(R.string.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.hye.setText(R.string.him_no_attention_other);
                        } else {
                            aVar.hye.setText(R.string.no_attention_other);
                        }
                    } else if (this.fZG) {
                        aVar.hye.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.hye.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.hye.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.hye.setText(R.string.no_fan_other);
                    }
                } else {
                    UserData userData = (UserData) v.c(this.aIn, i);
                    if (userData == null) {
                        return null;
                    }
                    aVar.dzw.setTag(Integer.valueOf(i));
                    aVar.hyE.setVisibility(0);
                    aVar.hye.setVisibility(8);
                    aVar.dzz.setShowV(userData.isBigV());
                    aVar.dzz.startLoad(userData.getPortrait(), 12, false);
                    aVar.mName.setText(userData.getName_show());
                    if (aVar.hyb != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            aVar.hyb.setVisibility(8);
                        } else {
                            aVar.hyb.setVisibility(0);
                            com.baidu.tbadk.ala.a aVar3 = new com.baidu.tbadk.ala.a();
                            aVar3.bAN = userData.getAlaUserData();
                            aVar3.type = 5;
                            aVar.hyb.setTag(aVar3);
                        }
                    }
                    if (aq.isEmpty(userData.getIntro())) {
                        aVar.dzA.setVisibility(8);
                    } else {
                        aVar.dzA.setVisibility(0);
                        aVar.dzA.setText(userData.getIntro());
                    }
                    aVar.hyE.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    aVar.hyc.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    aVar.eCe.a(userData);
                    aVar.eCe.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.d.1
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void ew(boolean z) {
                            if (z) {
                                l.showToast(d.this.hxY, (int) R.string.attention_success);
                            } else {
                                l.showToast(d.this.hxY, (int) R.string.unfollow_success);
                            }
                        }
                    });
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        aVar.hyc.setVisibility(8);
                        aVar.hyE.setVisibility(8);
                    } else {
                        aVar.hyE.setVisibility(8);
                        aVar.hyc.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else if (getItemViewType(i) != 2) {
                aVar.mName.setText(this.hxY.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
            return view;
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.hxY.getLayoutMode().setNightMode(skinType == 1);
        this.hxY.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.hyE != null) {
                am.f(aVar.hyE, R.color.btn_forum_focus_color, 1);
                am.k(aVar.hyE, R.drawable.btn_focus_border_bg);
                aVar.hyE.setEnabled(true);
            }
            if (aVar.hyF != null && aVar.mTitle != null) {
                am.l(aVar.hyF, R.color.cp_bg_line_e);
                am.j(aVar.mTitle, R.color.cp_cont_e);
            }
            if (aVar.hyc != null) {
                aVar.hyc.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.hxX) {
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
        if (this.hxX) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a {
        LinearLayout car;
        TextView dzA;
        LinearLayout dzB;
        ViewGroup dzw;
        ClickableHeaderImageView dzz;
        com.baidu.tbadk.core.view.userLike.c eCe;
        TextView hyE;
        LinearLayout hyF;
        View hyb;
        MyFansUserLikeButton hyc;
        TextView hye;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
