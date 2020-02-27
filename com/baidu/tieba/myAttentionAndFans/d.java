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
    boolean eLE;
    private View.OnClickListener eMF;
    private View.OnClickListener irV;
    private PersonListActivity iro;
    private View.OnClickListener irp;
    private int mSex;
    boolean eLC = false;
    private HashSet<Long> irU = new HashSet<>();

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.iro = null;
        this.aqm = false;
        this.eLE = true;
        this.mSex = 0;
        this.irV = null;
        this.irp = null;
        this.eMF = null;
        this.iro = personListActivity;
        this.aqm = z;
        this.eLE = z2;
        this.mSex = i;
        this.irV = onClickListener2;
        this.irp = onClickListener3;
        this.eMF = onClickListener;
        this.cVQ = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(av avVar) {
        ArrayList arrayList = new ArrayList();
        if (this.cVQ.isEmpty() && !v.isEmpty(avVar.aBm())) {
            Iterator<UserData> it = avVar.aBm().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.irU.add(Long.valueOf(com.baidu.adp.lib.f.b.toLong(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(avVar.aBm());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(aE(avVar.aBl()));
        this.cVQ.addAll(arrayList);
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean em(long j) {
        if (j == 0 || this.cVQ == null || this.cVQ.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.cVQ.iterator();
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
        if (!v.isEmpty(arrayList) && !this.irU.isEmpty()) {
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.irU.contains(Long.valueOf(com.baidu.adp.lib.f.b.toLong(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eLC) {
            return 1;
        }
        int i = 0;
        if (this.cVQ != null) {
            i = this.cVQ.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cVQ == null || i >= this.cVQ.size()) {
            return null;
        }
        return this.cVQ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.cVQ == null || i >= this.cVQ.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (this.cVQ != null) {
            if (view == null || !(view.getTag() instanceof a)) {
                final a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.iro.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar2.exh = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar2.exh.setOnClickListener(this.eMF);
                    aVar2.irs = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar2.irs.setRadius(l.getDimens(this.iro.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar2.irs.setAutoChangeStyle(true);
                    aVar2.irs.setClickable(false);
                    aVar2.eMI = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.mName.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.myAttentionAndFans.d.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            Layout layout = aVar2.mName.getLayout();
                            if (layout != null) {
                                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                                    aVar2.mName.setCompoundDrawablePadding(l.getDimens(d.this.iro, R.dimen.tbds10));
                                } else {
                                    aVar2.mName.setCompoundDrawablePadding(0);
                                }
                            }
                        }
                    });
                    aVar2.irt = com.baidu.tbadk.ala.b.ayz().u(this.iro.getPageContext().getPageActivity(), 5);
                    if (aVar2.irt != null) {
                        aVar2.irt.setVisibility(8);
                        aVar2.mContainer.addView(aVar2.irt, 1);
                    }
                    aVar2.eLG = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.exl = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.irY = (TextView) inflate.findViewById(R.id.chat);
                    aVar2.irY.setOnClickListener(this.irV);
                    aVar2.iru = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar2.iru.setContext(this.iro.getPageContext());
                    aVar2.NB = new com.baidu.tbadk.core.view.userLike.c(this.iro.getPageContext(), aVar2.iru);
                    aVar2.mProgress = null;
                    aVar2.mTitle = null;
                    aVar2.irZ = null;
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    View inflate2 = LayoutInflater.from(this.iro.getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
                    aVar2.mTitle = (TextView) inflate2.findViewById(R.id.person_list_title);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.mTitle.getLayoutParams();
                    layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds16);
                    aVar2.mTitle.setLayoutParams(layoutParams);
                    aVar2.irZ = (LinearLayout) inflate2.findViewById(R.id.newheader_root);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.iro.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.irp);
                    aVar2.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar2.mTitle = null;
                    aVar2.irZ = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.iru != null) {
                aVar.iru.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.eLC) {
                    aVar.eMI.setVisibility(8);
                    aVar.irY.setVisibility(8);
                    aVar.eLG.setVisibility(0);
                    if (this.aqm) {
                        if (this.eLE) {
                            aVar.eLG.setText(R.string.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.eLG.setText(R.string.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.eLG.setText(R.string.him_no_attention_other);
                        } else {
                            aVar.eLG.setText(R.string.no_attention_other);
                        }
                    } else if (this.eLE) {
                        aVar.eLG.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.eLG.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.eLG.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.eLG.setText(R.string.no_fan_other);
                    }
                } else {
                    UserData userData = (UserData) v.getItem(this.cVQ, i);
                    if (userData == null) {
                        return null;
                    }
                    aVar.exh.setTag(Integer.valueOf(i));
                    aVar.irY.setVisibility(0);
                    aVar.eLG.setVisibility(8);
                    UtilHelper.showHeadImageViewBigV(aVar.irs, userData, 0);
                    aVar.mName.setText(UtilHelper.getUserName(userData));
                    aVar.irs.setPlaceHolder(1);
                    aVar.irs.startLoad(userData.getAvater(), 12, false);
                    if (aVar.irt != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            aVar.irt.setVisibility(8);
                        } else {
                            aVar.irt.setVisibility(0);
                            com.baidu.tbadk.ala.a aVar3 = new com.baidu.tbadk.ala.a();
                            aVar3.cJQ = userData.getAlaUserData();
                            aVar3.type = 5;
                            aVar.irt.setTag(aVar3);
                        }
                    }
                    if (aq.isEmpty(userData.getIntro())) {
                        aVar.exl.setVisibility(8);
                    } else {
                        aVar.exl.setVisibility(0);
                        aVar.exl.setText(userData.getIntro());
                    }
                    aVar.irY.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    aVar.iru.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    aVar.NB.a(userData);
                    aVar.NB.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.d.2
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void fV(boolean z) {
                            if (z) {
                                l.showToast(d.this.iro, (int) R.string.attention_success);
                            } else {
                                l.showToast(d.this.iro, (int) R.string.unfollow_success);
                            }
                        }
                    });
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        aVar.iru.setVisibility(8);
                        aVar.irY.setVisibility(8);
                    } else {
                        aVar.irY.setVisibility(8);
                        aVar.iru.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else if (getItemViewType(i) != 2) {
                aVar.mName.setText(this.iro.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
            return view;
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.iro.getLayoutMode().setNightMode(skinType == 1);
        this.iro.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.irY != null) {
                am.setViewTextColor(aVar.irY, R.color.btn_forum_focus_color, 1);
                am.setBackgroundResource(aVar.irY, R.drawable.btn_focus_border_bg);
                aVar.irY.setEnabled(true);
            }
            if (aVar.irZ != null && aVar.mTitle != null) {
                am.setBackgroundColor(aVar.irZ, R.color.cp_bg_line_e);
                am.setViewTextColor(aVar.mTitle, (int) R.color.cp_cont_e);
            }
            if (aVar.iru != null) {
                aVar.iru.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.eLC) {
            return 0;
        }
        if (this.cVQ == null || i >= this.cVQ.size()) {
            return 1;
        }
        return this.cVQ.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.eLC) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c NB;
        TextView eLG;
        LinearLayout eMI;
        ViewGroup exh;
        TextView exl;
        TextView irY;
        LinearLayout irZ;
        ClickableHeaderImageView irs;
        View irt;
        MyFansUserLikeButton iru;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
