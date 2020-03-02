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
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.util.UtilHelper;
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
/* loaded from: classes10.dex */
public class d extends b {
    boolean aqm;
    boolean eLF;
    private View.OnClickListener eMG;
    private View.OnClickListener irX;
    private PersonListActivity irq;
    private View.OnClickListener irr;
    private int mSex;
    boolean eLD = false;
    private HashSet<Long> irW = new HashSet<>();

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.irq = null;
        this.aqm = false;
        this.eLF = true;
        this.mSex = 0;
        this.irX = null;
        this.irr = null;
        this.eMG = null;
        this.irq = personListActivity;
        this.aqm = z;
        this.eLF = z2;
        this.mSex = i;
        this.irX = onClickListener2;
        this.irr = onClickListener3;
        this.eMG = onClickListener;
        this.cVR = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(av avVar) {
        ArrayList arrayList = new ArrayList();
        if (this.cVR.isEmpty() && !v.isEmpty(avVar.aBo())) {
            Iterator<UserData> it = avVar.aBo().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.irW.add(Long.valueOf(com.baidu.adp.lib.f.b.toLong(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(avVar.aBo());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(aE(avVar.aBn()));
        this.cVR.addAll(arrayList);
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean em(long j) {
        if (j == 0 || this.cVR == null || this.cVR.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.cVR.iterator();
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

    private ArrayList<UserData> aE(ArrayList<UserData> arrayList) {
        if (!v.isEmpty(arrayList) && !this.irW.isEmpty()) {
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.irW.contains(Long.valueOf(com.baidu.adp.lib.f.b.toLong(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eLD) {
            return 1;
        }
        int i = 0;
        if (this.cVR != null) {
            i = this.cVR.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cVR == null || i >= this.cVR.size()) {
            return null;
        }
        return this.cVR.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.cVR == null || i >= this.cVR.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (this.cVR != null) {
            if (view == null || !(view.getTag() instanceof a)) {
                final a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.irq.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar2.exi = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar2.exi.setOnClickListener(this.eMG);
                    aVar2.iru = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar2.iru.setRadius(l.getDimens(this.irq.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar2.iru.setAutoChangeStyle(true);
                    aVar2.iru.setClickable(false);
                    aVar2.eMJ = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.mName.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.myAttentionAndFans.d.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            Layout layout = aVar2.mName.getLayout();
                            if (layout != null) {
                                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                                    aVar2.mName.setCompoundDrawablePadding(l.getDimens(d.this.irq, R.dimen.tbds10));
                                } else {
                                    aVar2.mName.setCompoundDrawablePadding(0);
                                }
                            }
                        }
                    });
                    aVar2.irv = com.baidu.tbadk.ala.b.ayB().u(this.irq.getPageContext().getPageActivity(), 5);
                    if (aVar2.irv != null) {
                        aVar2.irv.setVisibility(8);
                        aVar2.mContainer.addView(aVar2.irv, 1);
                    }
                    aVar2.eLH = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.exm = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.isa = (TextView) inflate.findViewById(R.id.chat);
                    aVar2.isa.setOnClickListener(this.irX);
                    aVar2.irw = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar2.irw.setContext(this.irq.getPageContext());
                    aVar2.NB = new com.baidu.tbadk.core.view.userLike.c(this.irq.getPageContext(), aVar2.irw);
                    aVar2.mProgress = null;
                    aVar2.mTitle = null;
                    aVar2.isb = null;
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    View inflate2 = LayoutInflater.from(this.irq.getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
                    aVar2.mTitle = (TextView) inflate2.findViewById(R.id.person_list_title);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.mTitle.getLayoutParams();
                    layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds16);
                    aVar2.mTitle.setLayoutParams(layoutParams);
                    aVar2.isb = (LinearLayout) inflate2.findViewById(R.id.newheader_root);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.irq.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.irr);
                    aVar2.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar2.mTitle = null;
                    aVar2.isb = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.irw != null) {
                aVar.irw.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.eLD) {
                    aVar.eMJ.setVisibility(8);
                    aVar.isa.setVisibility(8);
                    aVar.eLH.setVisibility(0);
                    if (this.aqm) {
                        if (this.eLF) {
                            aVar.eLH.setText(R.string.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.eLH.setText(R.string.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.eLH.setText(R.string.him_no_attention_other);
                        } else {
                            aVar.eLH.setText(R.string.no_attention_other);
                        }
                    } else if (this.eLF) {
                        aVar.eLH.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.eLH.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.eLH.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.eLH.setText(R.string.no_fan_other);
                    }
                } else {
                    UserData userData = (UserData) v.getItem(this.cVR, i);
                    if (userData == null) {
                        return null;
                    }
                    aVar.exi.setTag(Integer.valueOf(i));
                    aVar.isa.setVisibility(0);
                    aVar.eLH.setVisibility(8);
                    UtilHelper.showHeadImageViewBigV(aVar.iru, userData, 0);
                    aVar.mName.setText(UtilHelper.getUserName(userData));
                    aVar.iru.setPlaceHolder(1);
                    aVar.iru.startLoad(userData.getAvater(), 12, false);
                    if (aVar.irv != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            aVar.irv.setVisibility(8);
                        } else {
                            aVar.irv.setVisibility(0);
                            com.baidu.tbadk.ala.a aVar3 = new com.baidu.tbadk.ala.a();
                            aVar3.cJR = userData.getAlaUserData();
                            aVar3.type = 5;
                            aVar.irv.setTag(aVar3);
                        }
                    }
                    if (aq.isEmpty(userData.getIntro())) {
                        aVar.exm.setVisibility(8);
                    } else {
                        aVar.exm.setVisibility(0);
                        aVar.exm.setText(userData.getIntro());
                    }
                    aVar.isa.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    aVar.irw.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    aVar.NB.a(userData);
                    aVar.NB.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.d.2
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void fV(boolean z) {
                            if (z) {
                                l.showToast(d.this.irq, (int) R.string.attention_success);
                            } else {
                                l.showToast(d.this.irq, (int) R.string.unfollow_success);
                            }
                        }
                    });
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        aVar.irw.setVisibility(8);
                        aVar.isa.setVisibility(8);
                    } else {
                        aVar.isa.setVisibility(8);
                        aVar.irw.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else if (getItemViewType(i) != 2) {
                aVar.mName.setText(this.irq.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
            return view;
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.irq.getLayoutMode().setNightMode(skinType == 1);
        this.irq.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.isa != null) {
                am.setViewTextColor(aVar.isa, R.color.btn_forum_focus_color, 1);
                am.setBackgroundResource(aVar.isa, R.drawable.btn_focus_border_bg);
                aVar.isa.setEnabled(true);
            }
            if (aVar.isb != null && aVar.mTitle != null) {
                am.setBackgroundColor(aVar.isb, R.color.cp_bg_line_e);
                am.setViewTextColor(aVar.mTitle, (int) R.color.cp_cont_e);
            }
            if (aVar.irw != null) {
                aVar.irw.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.eLD) {
            return 0;
        }
        if (this.cVR == null || i >= this.cVR.size()) {
            return 1;
        }
        return this.cVR.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.eLD) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c NB;
        TextView eLH;
        LinearLayout eMJ;
        ViewGroup exi;
        TextView exm;
        ClickableHeaderImageView iru;
        View irv;
        MyFansUserLikeButton irw;
        TextView isa;
        LinearLayout isb;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
