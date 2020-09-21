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
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes22.dex */
public class d extends b {
    boolean gkE;
    private View.OnClickListener glE;
    boolean isFollowed;
    private View.OnClickListener krU;
    private PersonListActivity krn;
    private View.OnClickListener kro;
    private int mSex;
    boolean gkC = false;
    private HashSet<Long> krT = new HashSet<>();

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.krn = null;
        this.isFollowed = false;
        this.gkE = true;
        this.mSex = 0;
        this.krU = null;
        this.kro = null;
        this.glE = null;
        this.krn = personListActivity;
        this.isFollowed = z;
        this.gkE = z2;
        this.mSex = i;
        this.krU = onClickListener2;
        this.kro = onClickListener3;
        this.glE = onClickListener;
        this.eiq = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(bc bcVar) {
        ArrayList arrayList = new ArrayList();
        if (this.eiq.isEmpty() && !y.isEmpty(bcVar.bes())) {
            Iterator<UserData> it = bcVar.bes().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.krT.add(Long.valueOf(com.baidu.adp.lib.f.b.toLong(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(bcVar.bes());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(aQ(bcVar.ber()));
        this.eiq.addAll(arrayList);
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean fP(long j) {
        if (j == 0 || this.eiq == null || this.eiq.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.eiq.iterator();
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

    private ArrayList<UserData> aQ(ArrayList<UserData> arrayList) {
        if (!y.isEmpty(arrayList) && !this.krT.isEmpty()) {
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.krT.contains(Long.valueOf(com.baidu.adp.lib.f.b.toLong(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gkC) {
            return 1;
        }
        int i = 0;
        if (this.eiq != null) {
            i = this.eiq.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eiq == null || i >= this.eiq.size()) {
            return null;
        }
        return this.eiq.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.eiq == null || i >= this.eiq.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (this.eiq != null) {
            if (view == null || !(view.getTag() instanceof a)) {
                final a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.krn.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar2.fUT = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar2.fUT.setOnClickListener(this.glE);
                    aVar2.krr = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar2.krr.setRadius(l.getDimens(this.krn.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar2.krr.setAutoChangeStyle(true);
                    aVar2.krr.setClickable(false);
                    aVar2.glH = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.mName.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.myAttentionAndFans.d.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            Layout layout = aVar2.mName.getLayout();
                            if (layout != null) {
                                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                                    aVar2.mName.setCompoundDrawablePadding(l.getDimens(d.this.krn, R.dimen.tbds10));
                                } else {
                                    aVar2.mName.setCompoundDrawablePadding(0);
                                }
                            }
                        }
                    });
                    aVar2.krs = com.baidu.tbadk.ala.b.bbl().q(this.krn.getPageContext().getPageActivity(), 5);
                    if (aVar2.krs != null) {
                        aVar2.krs.setVisibility(8);
                        aVar2.mContainer.addView(aVar2.krs, 1);
                    }
                    aVar2.gkG = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.fUX = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.krX = (TextView) inflate.findViewById(R.id.chat);
                    aVar2.krX.setOnClickListener(this.krU);
                    aVar2.krt = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar2.krt.setContext(this.krn.getPageContext());
                    aVar2.ajD = new com.baidu.tbadk.core.view.userLike.c(this.krn.getPageContext(), aVar2.krt);
                    aVar2.mProgress = null;
                    aVar2.mTitle = null;
                    aVar2.krY = null;
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    View inflate2 = LayoutInflater.from(this.krn.getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
                    aVar2.mTitle = (TextView) inflate2.findViewById(R.id.person_list_title);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.mTitle.getLayoutParams();
                    layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds16);
                    aVar2.mTitle.setLayoutParams(layoutParams);
                    aVar2.krY = (LinearLayout) inflate2.findViewById(R.id.newheader_root);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.krn.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.kro);
                    aVar2.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar2.mTitle = null;
                    aVar2.krY = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.krt != null) {
                aVar.krt.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.gkC) {
                    aVar.glH.setVisibility(8);
                    aVar.krX.setVisibility(8);
                    aVar.gkG.setVisibility(0);
                    if (this.isFollowed) {
                        if (this.gkE) {
                            aVar.gkG.setText(R.string.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.gkG.setText(R.string.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.gkG.setText(R.string.him_no_attention_other);
                        } else {
                            aVar.gkG.setText(R.string.no_attention_other);
                        }
                    } else if (this.gkE) {
                        aVar.gkG.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.gkG.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.gkG.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.gkG.setText(R.string.no_fan_other);
                    }
                } else {
                    UserData userData = (UserData) y.getItem(this.eiq, i);
                    if (userData == null) {
                        return null;
                    }
                    aVar.fUT.setTag(Integer.valueOf(i));
                    aVar.krX.setVisibility(0);
                    aVar.gkG.setVisibility(8);
                    UtilHelper.showHeadImageViewBigV(aVar.krr, userData, 0);
                    aVar.mName.setText(UtilHelper.getUserName(userData));
                    aVar.krr.setPlaceHolder(1);
                    aVar.krr.startLoad(userData.getAvater(), 12, false);
                    if (aVar.krs != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            aVar.krs.setVisibility(8);
                        } else {
                            aVar.krs.setVisibility(0);
                            com.baidu.tbadk.ala.a aVar3 = new com.baidu.tbadk.ala.a();
                            aVar3.dTL = userData.getAlaUserData();
                            aVar3.type = 5;
                            aVar.krs.setTag(aVar3);
                        }
                    }
                    if (at.isEmpty(userData.getIntro())) {
                        aVar.fUX.setVisibility(8);
                    } else {
                        aVar.fUX.setVisibility(0);
                        aVar.fUX.setText(userData.getIntro());
                    }
                    aVar.krX.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    aVar.krt.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    aVar.ajD.a(userData);
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        aVar.krt.setVisibility(8);
                        aVar.krX.setVisibility(8);
                    } else {
                        aVar.krX.setVisibility(8);
                        aVar.krt.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else if (getItemViewType(i) != 2) {
                aVar.mName.setText(this.krn.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
            return view;
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.krn.getLayoutMode().setNightMode(skinType == 1);
        this.krn.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.krX != null) {
                ap.setViewTextColor(aVar.krX, R.color.btn_forum_focus_color, 1);
                ap.setBackgroundResource(aVar.krX, R.drawable.btn_focus_border_bg);
                aVar.krX.setEnabled(true);
            }
            if (aVar.krY != null && aVar.mTitle != null) {
                ap.setBackgroundColor(aVar.krY, R.color.cp_bg_line_e);
                ap.setViewTextColor(aVar.mTitle, R.color.cp_cont_e);
            }
            if (aVar.krt != null) {
                aVar.krt.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.gkC) {
            return 0;
        }
        if (this.eiq == null || i >= this.eiq.size()) {
            return 1;
        }
        return this.eiq.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.gkC) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c ajD;
        ViewGroup fUT;
        TextView fUX;
        TextView gkG;
        LinearLayout glH;
        TextView krX;
        LinearLayout krY;
        ClickableHeaderImageView krr;
        View krs;
        MyFansUserLikeButton krt;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
