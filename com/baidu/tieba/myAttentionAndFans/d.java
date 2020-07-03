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
import com.baidu.tbadk.core.data.ba;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes10.dex */
public class d extends b {
    boolean aRB;
    boolean fPZ;
    private View.OnClickListener fRa;
    private PersonListActivity jKL;
    private View.OnClickListener jKM;
    private View.OnClickListener jLs;
    private int mSex;
    boolean fPX = false;
    private HashSet<Long> jLr = new HashSet<>();

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.jKL = null;
        this.aRB = false;
        this.fPZ = true;
        this.mSex = 0;
        this.jLs = null;
        this.jKM = null;
        this.fRa = null;
        this.jKL = personListActivity;
        this.aRB = z;
        this.fPZ = z2;
        this.mSex = i;
        this.jLs = onClickListener2;
        this.jKM = onClickListener3;
        this.fRa = onClickListener;
        this.dQf = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(ba baVar) {
        ArrayList arrayList = new ArrayList();
        if (this.dQf.isEmpty() && !w.isEmpty(baVar.aRj())) {
            Iterator<UserData> it = baVar.aRj().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.jLr.add(Long.valueOf(com.baidu.adp.lib.f.b.toLong(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(baVar.aRj());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(aH(baVar.aRi()));
        this.dQf.addAll(arrayList);
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean fb(long j) {
        if (j == 0 || this.dQf == null || this.dQf.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.dQf.iterator();
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

    private ArrayList<UserData> aH(ArrayList<UserData> arrayList) {
        if (!w.isEmpty(arrayList) && !this.jLr.isEmpty()) {
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.jLr.contains(Long.valueOf(com.baidu.adp.lib.f.b.toLong(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fPX) {
            return 1;
        }
        int i = 0;
        if (this.dQf != null) {
            i = this.dQf.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dQf == null || i >= this.dQf.size()) {
            return null;
        }
        return this.dQf.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.dQf == null || i >= this.dQf.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (this.dQf != null) {
            if (view == null || !(view.getTag() instanceof a)) {
                final a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.jKL.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar2.fBd = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar2.fBd.setOnClickListener(this.fRa);
                    aVar2.jKP = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar2.jKP.setRadius(l.getDimens(this.jKL.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar2.jKP.setAutoChangeStyle(true);
                    aVar2.jKP.setClickable(false);
                    aVar2.fRd = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.mName.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.myAttentionAndFans.d.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            Layout layout = aVar2.mName.getLayout();
                            if (layout != null) {
                                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                                    aVar2.mName.setCompoundDrawablePadding(l.getDimens(d.this.jKL, R.dimen.tbds10));
                                } else {
                                    aVar2.mName.setCompoundDrawablePadding(0);
                                }
                            }
                        }
                    });
                    aVar2.jKQ = com.baidu.tbadk.ala.b.aOf().p(this.jKL.getPageContext().getPageActivity(), 5);
                    if (aVar2.jKQ != null) {
                        aVar2.jKQ.setVisibility(8);
                        aVar2.mContainer.addView(aVar2.jKQ, 1);
                    }
                    aVar2.fQb = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.fBh = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.jLv = (TextView) inflate.findViewById(R.id.chat);
                    aVar2.jLv.setOnClickListener(this.jLs);
                    aVar2.jKR = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar2.jKR.setContext(this.jKL.getPageContext());
                    aVar2.ahX = new com.baidu.tbadk.core.view.userLike.c(this.jKL.getPageContext(), aVar2.jKR);
                    aVar2.mProgress = null;
                    aVar2.mTitle = null;
                    aVar2.jLw = null;
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    View inflate2 = LayoutInflater.from(this.jKL.getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
                    aVar2.mTitle = (TextView) inflate2.findViewById(R.id.person_list_title);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.mTitle.getLayoutParams();
                    layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds16);
                    aVar2.mTitle.setLayoutParams(layoutParams);
                    aVar2.jLw = (LinearLayout) inflate2.findViewById(R.id.newheader_root);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.jKL.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.jKM);
                    aVar2.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar2.mTitle = null;
                    aVar2.jLw = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.jKR != null) {
                aVar.jKR.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.fPX) {
                    aVar.fRd.setVisibility(8);
                    aVar.jLv.setVisibility(8);
                    aVar.fQb.setVisibility(0);
                    if (this.aRB) {
                        if (this.fPZ) {
                            aVar.fQb.setText(R.string.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.fQb.setText(R.string.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.fQb.setText(R.string.him_no_attention_other);
                        } else {
                            aVar.fQb.setText(R.string.no_attention_other);
                        }
                    } else if (this.fPZ) {
                        aVar.fQb.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.fQb.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.fQb.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.fQb.setText(R.string.no_fan_other);
                    }
                } else {
                    UserData userData = (UserData) w.getItem(this.dQf, i);
                    if (userData == null) {
                        return null;
                    }
                    aVar.fBd.setTag(Integer.valueOf(i));
                    aVar.jLv.setVisibility(0);
                    aVar.fQb.setVisibility(8);
                    UtilHelper.showHeadImageViewBigV(aVar.jKP, userData, 0);
                    aVar.mName.setText(UtilHelper.getUserName(userData));
                    aVar.jKP.setPlaceHolder(1);
                    aVar.jKP.startLoad(userData.getAvater(), 12, false);
                    if (aVar.jKQ != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            aVar.jKQ.setVisibility(8);
                        } else {
                            aVar.jKQ.setVisibility(0);
                            com.baidu.tbadk.ala.a aVar3 = new com.baidu.tbadk.ala.a();
                            aVar3.dCt = userData.getAlaUserData();
                            aVar3.type = 5;
                            aVar.jKQ.setTag(aVar3);
                        }
                    }
                    if (ar.isEmpty(userData.getIntro())) {
                        aVar.fBh.setVisibility(8);
                    } else {
                        aVar.fBh.setVisibility(0);
                        aVar.fBh.setText(userData.getIntro());
                    }
                    aVar.jLv.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    aVar.jKR.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    aVar.ahX.a(userData);
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        aVar.jKR.setVisibility(8);
                        aVar.jLv.setVisibility(8);
                    } else {
                        aVar.jLv.setVisibility(8);
                        aVar.jKR.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else if (getItemViewType(i) != 2) {
                aVar.mName.setText(this.jKL.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
            return view;
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.jKL.getLayoutMode().setNightMode(skinType == 1);
        this.jKL.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.jLv != null) {
                an.setViewTextColor(aVar.jLv, R.color.btn_forum_focus_color, 1);
                an.setBackgroundResource(aVar.jLv, R.drawable.btn_focus_border_bg);
                aVar.jLv.setEnabled(true);
            }
            if (aVar.jLw != null && aVar.mTitle != null) {
                an.setBackgroundColor(aVar.jLw, R.color.cp_bg_line_e);
                an.setViewTextColor(aVar.mTitle, (int) R.color.cp_cont_e);
            }
            if (aVar.jKR != null) {
                aVar.jKR.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fPX) {
            return 0;
        }
        if (this.dQf == null || i >= this.dQf.size()) {
            return 1;
        }
        return this.dQf.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fPX) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c ahX;
        ViewGroup fBd;
        TextView fBh;
        TextView fQb;
        LinearLayout fRd;
        ClickableHeaderImageView jKP;
        View jKQ;
        MyFansUserLikeButton jKR;
        TextView jLv;
        LinearLayout jLw;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
