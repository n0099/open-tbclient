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
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes10.dex */
public class d extends b {
    boolean aJm;
    boolean fqL;
    private View.OnClickListener frO;
    private View.OnClickListener jdS;
    private PersonListActivity jdl;
    private View.OnClickListener jdm;
    private int mSex;
    boolean fqJ = false;
    private HashSet<Long> jdR = new HashSet<>();

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.jdl = null;
        this.aJm = false;
        this.fqL = true;
        this.mSex = 0;
        this.jdS = null;
        this.jdm = null;
        this.frO = null;
        this.jdl = personListActivity;
        this.aJm = z;
        this.fqL = z2;
        this.mSex = i;
        this.jdS = onClickListener2;
        this.jdm = onClickListener3;
        this.frO = onClickListener;
        this.dvu = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(av avVar) {
        ArrayList arrayList = new ArrayList();
        if (this.dvu.isEmpty() && !v.isEmpty(avVar.aJC())) {
            Iterator<UserData> it = avVar.aJC().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.jdR.add(Long.valueOf(com.baidu.adp.lib.f.b.toLong(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(avVar.aJC());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(aG(avVar.aJB()));
        this.dvu.addAll(arrayList);
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean eX(long j) {
        if (j == 0 || this.dvu == null || this.dvu.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.dvu.iterator();
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

    private ArrayList<UserData> aG(ArrayList<UserData> arrayList) {
        if (!v.isEmpty(arrayList) && !this.jdR.isEmpty()) {
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.jdR.contains(Long.valueOf(com.baidu.adp.lib.f.b.toLong(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fqJ) {
            return 1;
        }
        int i = 0;
        if (this.dvu != null) {
            i = this.dvu.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dvu == null || i >= this.dvu.size()) {
            return null;
        }
        return this.dvu.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.dvu == null || i >= this.dvu.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (this.dvu != null) {
            if (view == null || !(view.getTag() instanceof a)) {
                final a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.jdl.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar2.fce = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar2.fce.setOnClickListener(this.frO);
                    aVar2.jdp = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar2.jdp.setRadius(l.getDimens(this.jdl.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar2.jdp.setAutoChangeStyle(true);
                    aVar2.jdp.setClickable(false);
                    aVar2.frR = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.mName.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.myAttentionAndFans.d.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            Layout layout = aVar2.mName.getLayout();
                            if (layout != null) {
                                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                                    aVar2.mName.setCompoundDrawablePadding(l.getDimens(d.this.jdl, R.dimen.tbds10));
                                } else {
                                    aVar2.mName.setCompoundDrawablePadding(0);
                                }
                            }
                        }
                    });
                    aVar2.jdq = com.baidu.tbadk.ala.b.aGN().p(this.jdl.getPageContext().getPageActivity(), 5);
                    if (aVar2.jdq != null) {
                        aVar2.jdq.setVisibility(8);
                        aVar2.mContainer.addView(aVar2.jdq, 1);
                    }
                    aVar2.fqN = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.fci = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.jdV = (TextView) inflate.findViewById(R.id.chat);
                    aVar2.jdV.setOnClickListener(this.jdS);
                    aVar2.jdr = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar2.jdr.setContext(this.jdl.getPageContext());
                    aVar2.agp = new com.baidu.tbadk.core.view.userLike.c(this.jdl.getPageContext(), aVar2.jdr);
                    aVar2.mProgress = null;
                    aVar2.mTitle = null;
                    aVar2.jdW = null;
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    View inflate2 = LayoutInflater.from(this.jdl.getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
                    aVar2.mTitle = (TextView) inflate2.findViewById(R.id.person_list_title);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.mTitle.getLayoutParams();
                    layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds16);
                    aVar2.mTitle.setLayoutParams(layoutParams);
                    aVar2.jdW = (LinearLayout) inflate2.findViewById(R.id.newheader_root);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.jdl.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.jdm);
                    aVar2.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar2.mTitle = null;
                    aVar2.jdW = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.jdr != null) {
                aVar.jdr.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.fqJ) {
                    aVar.frR.setVisibility(8);
                    aVar.jdV.setVisibility(8);
                    aVar.fqN.setVisibility(0);
                    if (this.aJm) {
                        if (this.fqL) {
                            aVar.fqN.setText(R.string.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.fqN.setText(R.string.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.fqN.setText(R.string.him_no_attention_other);
                        } else {
                            aVar.fqN.setText(R.string.no_attention_other);
                        }
                    } else if (this.fqL) {
                        aVar.fqN.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.fqN.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.fqN.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.fqN.setText(R.string.no_fan_other);
                    }
                } else {
                    UserData userData = (UserData) v.getItem(this.dvu, i);
                    if (userData == null) {
                        return null;
                    }
                    aVar.fce.setTag(Integer.valueOf(i));
                    aVar.jdV.setVisibility(0);
                    aVar.fqN.setVisibility(8);
                    UtilHelper.showHeadImageViewBigV(aVar.jdp, userData, 0);
                    aVar.mName.setText(UtilHelper.getUserName(userData));
                    aVar.jdp.setPlaceHolder(1);
                    aVar.jdp.startLoad(userData.getAvater(), 12, false);
                    if (aVar.jdq != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            aVar.jdq.setVisibility(8);
                        } else {
                            aVar.jdq.setVisibility(0);
                            com.baidu.tbadk.ala.a aVar3 = new com.baidu.tbadk.ala.a();
                            aVar3.djn = userData.getAlaUserData();
                            aVar3.type = 5;
                            aVar.jdq.setTag(aVar3);
                        }
                    }
                    if (aq.isEmpty(userData.getIntro())) {
                        aVar.fci.setVisibility(8);
                    } else {
                        aVar.fci.setVisibility(0);
                        aVar.fci.setText(userData.getIntro());
                    }
                    aVar.jdV.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    aVar.jdr.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    aVar.agp.a(userData);
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        aVar.jdr.setVisibility(8);
                        aVar.jdV.setVisibility(8);
                    } else {
                        aVar.jdV.setVisibility(8);
                        aVar.jdr.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else if (getItemViewType(i) != 2) {
                aVar.mName.setText(this.jdl.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
            return view;
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.jdl.getLayoutMode().setNightMode(skinType == 1);
        this.jdl.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.jdV != null) {
                am.setViewTextColor(aVar.jdV, R.color.btn_forum_focus_color, 1);
                am.setBackgroundResource(aVar.jdV, R.drawable.btn_focus_border_bg);
                aVar.jdV.setEnabled(true);
            }
            if (aVar.jdW != null && aVar.mTitle != null) {
                am.setBackgroundColor(aVar.jdW, R.color.cp_bg_line_e);
                am.setViewTextColor(aVar.mTitle, (int) R.color.cp_cont_e);
            }
            if (aVar.jdr != null) {
                aVar.jdr.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fqJ) {
            return 0;
        }
        if (this.dvu == null || i >= this.dvu.size()) {
            return 1;
        }
        return this.dvu.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fqJ) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c agp;
        ViewGroup fce;
        TextView fci;
        TextView fqN;
        LinearLayout frR;
        TextView jdV;
        LinearLayout jdW;
        ClickableHeaderImageView jdp;
        View jdq;
        MyFansUserLikeButton jdr;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
