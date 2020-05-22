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
    boolean aOV;
    boolean fEF;
    private View.OnClickListener fFG;
    private View.OnClickListener jsV;
    private PersonListActivity jso;
    private View.OnClickListener jsp;
    private int mSex;
    boolean fED = false;
    private HashSet<Long> jsU = new HashSet<>();

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.jso = null;
        this.aOV = false;
        this.fEF = true;
        this.mSex = 0;
        this.jsV = null;
        this.jsp = null;
        this.fFG = null;
        this.jso = personListActivity;
        this.aOV = z;
        this.fEF = z2;
        this.mSex = i;
        this.jsV = onClickListener2;
        this.jsp = onClickListener3;
        this.fFG = onClickListener;
        this.dJp = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(av avVar) {
        ArrayList arrayList = new ArrayList();
        if (this.dJp.isEmpty() && !v.isEmpty(avVar.aPx())) {
            Iterator<UserData> it = avVar.aPx().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.jsU.add(Long.valueOf(com.baidu.adp.lib.f.b.toLong(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(avVar.aPx());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(aG(avVar.aPw()));
        this.dJp.addAll(arrayList);
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean eY(long j) {
        if (j == 0 || this.dJp == null || this.dJp.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.dJp.iterator();
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
        if (!v.isEmpty(arrayList) && !this.jsU.isEmpty()) {
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.jsU.contains(Long.valueOf(com.baidu.adp.lib.f.b.toLong(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fED) {
            return 1;
        }
        int i = 0;
        if (this.dJp != null) {
            i = this.dJp.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dJp == null || i >= this.dJp.size()) {
            return null;
        }
        return this.dJp.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.dJp == null || i >= this.dJp.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (this.dJp != null) {
            if (view == null || !(view.getTag() instanceof a)) {
                final a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.jso.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar2.fpH = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar2.fpH.setOnClickListener(this.fFG);
                    aVar2.jss = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar2.jss.setRadius(l.getDimens(this.jso.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar2.jss.setAutoChangeStyle(true);
                    aVar2.jss.setClickable(false);
                    aVar2.fFJ = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.mName.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.myAttentionAndFans.d.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            Layout layout = aVar2.mName.getLayout();
                            if (layout != null) {
                                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                                    aVar2.mName.setCompoundDrawablePadding(l.getDimens(d.this.jso, R.dimen.tbds10));
                                } else {
                                    aVar2.mName.setCompoundDrawablePadding(0);
                                }
                            }
                        }
                    });
                    aVar2.jst = com.baidu.tbadk.ala.b.aMC().p(this.jso.getPageContext().getPageActivity(), 5);
                    if (aVar2.jst != null) {
                        aVar2.jst.setVisibility(8);
                        aVar2.mContainer.addView(aVar2.jst, 1);
                    }
                    aVar2.fEH = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.fpL = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.jsY = (TextView) inflate.findViewById(R.id.chat);
                    aVar2.jsY.setOnClickListener(this.jsV);
                    aVar2.jsu = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar2.jsu.setContext(this.jso.getPageContext());
                    aVar2.agS = new com.baidu.tbadk.core.view.userLike.c(this.jso.getPageContext(), aVar2.jsu);
                    aVar2.mProgress = null;
                    aVar2.mTitle = null;
                    aVar2.jsZ = null;
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    View inflate2 = LayoutInflater.from(this.jso.getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
                    aVar2.mTitle = (TextView) inflate2.findViewById(R.id.person_list_title);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.mTitle.getLayoutParams();
                    layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds16);
                    aVar2.mTitle.setLayoutParams(layoutParams);
                    aVar2.jsZ = (LinearLayout) inflate2.findViewById(R.id.newheader_root);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.jso.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.jsp);
                    aVar2.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar2.mTitle = null;
                    aVar2.jsZ = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.jsu != null) {
                aVar.jsu.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.fED) {
                    aVar.fFJ.setVisibility(8);
                    aVar.jsY.setVisibility(8);
                    aVar.fEH.setVisibility(0);
                    if (this.aOV) {
                        if (this.fEF) {
                            aVar.fEH.setText(R.string.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.fEH.setText(R.string.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.fEH.setText(R.string.him_no_attention_other);
                        } else {
                            aVar.fEH.setText(R.string.no_attention_other);
                        }
                    } else if (this.fEF) {
                        aVar.fEH.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.fEH.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.fEH.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.fEH.setText(R.string.no_fan_other);
                    }
                } else {
                    UserData userData = (UserData) v.getItem(this.dJp, i);
                    if (userData == null) {
                        return null;
                    }
                    aVar.fpH.setTag(Integer.valueOf(i));
                    aVar.jsY.setVisibility(0);
                    aVar.fEH.setVisibility(8);
                    UtilHelper.showHeadImageViewBigV(aVar.jss, userData, 0);
                    aVar.mName.setText(UtilHelper.getUserName(userData));
                    aVar.jss.setPlaceHolder(1);
                    aVar.jss.startLoad(userData.getAvater(), 12, false);
                    if (aVar.jst != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            aVar.jst.setVisibility(8);
                        } else {
                            aVar.jst.setVisibility(0);
                            com.baidu.tbadk.ala.a aVar3 = new com.baidu.tbadk.ala.a();
                            aVar3.dxn = userData.getAlaUserData();
                            aVar3.type = 5;
                            aVar.jst.setTag(aVar3);
                        }
                    }
                    if (aq.isEmpty(userData.getIntro())) {
                        aVar.fpL.setVisibility(8);
                    } else {
                        aVar.fpL.setVisibility(0);
                        aVar.fpL.setText(userData.getIntro());
                    }
                    aVar.jsY.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    aVar.jsu.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    aVar.agS.a(userData);
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        aVar.jsu.setVisibility(8);
                        aVar.jsY.setVisibility(8);
                    } else {
                        aVar.jsY.setVisibility(8);
                        aVar.jsu.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else if (getItemViewType(i) != 2) {
                aVar.mName.setText(this.jso.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
            return view;
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.jso.getLayoutMode().setNightMode(skinType == 1);
        this.jso.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.jsY != null) {
                am.setViewTextColor(aVar.jsY, R.color.btn_forum_focus_color, 1);
                am.setBackgroundResource(aVar.jsY, R.drawable.btn_focus_border_bg);
                aVar.jsY.setEnabled(true);
            }
            if (aVar.jsZ != null && aVar.mTitle != null) {
                am.setBackgroundColor(aVar.jsZ, R.color.cp_bg_line_e);
                am.setViewTextColor(aVar.mTitle, (int) R.color.cp_cont_e);
            }
            if (aVar.jsu != null) {
                aVar.jsu.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fED) {
            return 0;
        }
        if (this.dJp == null || i >= this.dJp.size()) {
            return 1;
        }
        return this.dJp.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fED) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c agS;
        TextView fEH;
        LinearLayout fFJ;
        ViewGroup fpH;
        TextView fpL;
        TextView jsY;
        LinearLayout jsZ;
        ClickableHeaderImageView jss;
        View jst;
        MyFansUserLikeButton jsu;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
