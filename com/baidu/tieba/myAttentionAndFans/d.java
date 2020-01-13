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
/* loaded from: classes8.dex */
public class d extends b {
    boolean eHK;
    private View.OnClickListener eIL;
    boolean evd;
    private PersonListActivity ipt;
    private View.OnClickListener ipu;
    private View.OnClickListener iqa;
    private int mSex;
    boolean eHI = false;
    private HashSet<Long> ipZ = new HashSet<>();

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.ipt = null;
        this.evd = false;
        this.eHK = true;
        this.mSex = 0;
        this.iqa = null;
        this.ipu = null;
        this.eIL = null;
        this.ipt = personListActivity;
        this.evd = z;
        this.eHK = z2;
        this.mSex = i;
        this.iqa = onClickListener2;
        this.ipu = onClickListener3;
        this.eIL = onClickListener;
        this.cRO = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(av avVar) {
        ArrayList arrayList = new ArrayList();
        if (this.cRO.isEmpty() && !v.isEmpty(avVar.ayV())) {
            Iterator<UserData> it = avVar.ayV().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.ipZ.add(Long.valueOf(com.baidu.adp.lib.f.b.toLong(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(avVar.ayV());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(aE(avVar.ayU()));
        this.cRO.addAll(arrayList);
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean em(long j) {
        if (j == 0 || this.cRO == null || this.cRO.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.cRO.iterator();
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
        if (!v.isEmpty(arrayList) && !this.ipZ.isEmpty()) {
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.ipZ.contains(Long.valueOf(com.baidu.adp.lib.f.b.toLong(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eHI) {
            return 1;
        }
        int i = 0;
        if (this.cRO != null) {
            i = this.cRO.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cRO == null || i >= this.cRO.size()) {
            return null;
        }
        return this.cRO.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.cRO == null || i >= this.cRO.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (this.cRO != null) {
            if (view == null || !(view.getTag() instanceof a)) {
                final a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.ipt.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar2.esX = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar2.esX.setOnClickListener(this.eIL);
                    aVar2.ipx = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar2.ipx.setRadius(l.getDimens(this.ipt.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar2.ipx.setAutoChangeStyle(true);
                    aVar2.ipx.setClickable(false);
                    aVar2.eIO = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.mName.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.myAttentionAndFans.d.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            Layout layout = aVar2.mName.getLayout();
                            if (layout != null) {
                                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                                    aVar2.mName.setCompoundDrawablePadding(l.getDimens(d.this.ipt, R.dimen.tbds10));
                                } else {
                                    aVar2.mName.setCompoundDrawablePadding(0);
                                }
                            }
                        }
                    });
                    aVar2.ipy = com.baidu.tbadk.ala.b.awm().u(this.ipt.getPageContext().getPageActivity(), 5);
                    if (aVar2.ipy != null) {
                        aVar2.ipy.setVisibility(8);
                        aVar2.mContainer.addView(aVar2.ipy, 1);
                    }
                    aVar2.eHM = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.etb = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.iqd = (TextView) inflate.findViewById(R.id.chat);
                    aVar2.iqd.setOnClickListener(this.iqa);
                    aVar2.ipz = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar2.ipz.setContext(this.ipt.getPageContext());
                    aVar2.Nb = new com.baidu.tbadk.core.view.userLike.c(this.ipt.getPageContext(), aVar2.ipz);
                    aVar2.mProgress = null;
                    aVar2.mTitle = null;
                    aVar2.iqe = null;
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    View inflate2 = LayoutInflater.from(this.ipt.getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
                    aVar2.mTitle = (TextView) inflate2.findViewById(R.id.person_list_title);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.mTitle.getLayoutParams();
                    layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds16);
                    aVar2.mTitle.setLayoutParams(layoutParams);
                    aVar2.iqe = (LinearLayout) inflate2.findViewById(R.id.newheader_root);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.ipt.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.ipu);
                    aVar2.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar2.mTitle = null;
                    aVar2.iqe = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.ipz != null) {
                aVar.ipz.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.eHI) {
                    aVar.eIO.setVisibility(8);
                    aVar.iqd.setVisibility(8);
                    aVar.eHM.setVisibility(0);
                    if (this.evd) {
                        if (this.eHK) {
                            aVar.eHM.setText(R.string.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.eHM.setText(R.string.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.eHM.setText(R.string.him_no_attention_other);
                        } else {
                            aVar.eHM.setText(R.string.no_attention_other);
                        }
                    } else if (this.eHK) {
                        aVar.eHM.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.eHM.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.eHM.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.eHM.setText(R.string.no_fan_other);
                    }
                } else {
                    UserData userData = (UserData) v.getItem(this.cRO, i);
                    if (userData == null) {
                        return null;
                    }
                    aVar.esX.setTag(Integer.valueOf(i));
                    aVar.iqd.setVisibility(0);
                    aVar.eHM.setVisibility(8);
                    UtilHelper.showHeadImageViewBigV(aVar.ipx, userData, 0);
                    aVar.mName.setText(UtilHelper.getUserName(userData));
                    aVar.ipx.setPlaceHolder(1);
                    aVar.ipx.startLoad(userData.getAvater(), 12, false);
                    if (aVar.ipy != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            aVar.ipy.setVisibility(8);
                        } else {
                            aVar.ipy.setVisibility(0);
                            com.baidu.tbadk.ala.a aVar3 = new com.baidu.tbadk.ala.a();
                            aVar3.cFM = userData.getAlaUserData();
                            aVar3.type = 5;
                            aVar.ipy.setTag(aVar3);
                        }
                    }
                    if (aq.isEmpty(userData.getIntro())) {
                        aVar.etb.setVisibility(8);
                    } else {
                        aVar.etb.setVisibility(0);
                        aVar.etb.setText(userData.getIntro());
                    }
                    aVar.iqd.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    aVar.ipz.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    aVar.Nb.a(userData);
                    aVar.Nb.a(new c.a() { // from class: com.baidu.tieba.myAttentionAndFans.d.2
                        @Override // com.baidu.tbadk.core.view.userLike.c.a
                        public void fO(boolean z) {
                            if (z) {
                                l.showToast(d.this.ipt, (int) R.string.attention_success);
                            } else {
                                l.showToast(d.this.ipt, (int) R.string.unfollow_success);
                            }
                        }
                    });
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        aVar.ipz.setVisibility(8);
                        aVar.iqd.setVisibility(8);
                    } else {
                        aVar.iqd.setVisibility(8);
                        aVar.ipz.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else if (getItemViewType(i) != 2) {
                aVar.mName.setText(this.ipt.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
            return view;
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.ipt.getLayoutMode().setNightMode(skinType == 1);
        this.ipt.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.iqd != null) {
                am.setViewTextColor(aVar.iqd, R.color.btn_forum_focus_color, 1);
                am.setBackgroundResource(aVar.iqd, R.drawable.btn_focus_border_bg);
                aVar.iqd.setEnabled(true);
            }
            if (aVar.iqe != null && aVar.mTitle != null) {
                am.setBackgroundColor(aVar.iqe, R.color.cp_bg_line_e);
                am.setViewTextColor(aVar.mTitle, (int) R.color.cp_cont_e);
            }
            if (aVar.ipz != null) {
                aVar.ipz.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.eHI) {
            return 0;
        }
        if (this.cRO == null || i >= this.cRO.size()) {
            return 1;
        }
        return this.cRO.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.eHI) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c Nb;
        TextView eHM;
        LinearLayout eIO;
        ViewGroup esX;
        TextView etb;
        ClickableHeaderImageView ipx;
        View ipy;
        MyFansUserLikeButton ipz;
        TextView iqd;
        LinearLayout iqe;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
