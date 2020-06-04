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
    boolean fEQ;
    private View.OnClickListener fFR;
    private PersonListActivity jtu;
    private View.OnClickListener jtv;
    private View.OnClickListener jub;
    private int mSex;
    boolean fEO = false;
    private HashSet<Long> jua = new HashSet<>();

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.jtu = null;
        this.aOV = false;
        this.fEQ = true;
        this.mSex = 0;
        this.jub = null;
        this.jtv = null;
        this.fFR = null;
        this.jtu = personListActivity;
        this.aOV = z;
        this.fEQ = z2;
        this.mSex = i;
        this.jub = onClickListener2;
        this.jtv = onClickListener3;
        this.fFR = onClickListener;
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
                    this.jua.add(Long.valueOf(com.baidu.adp.lib.f.b.toLong(next.getUserId(), 0L)));
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
        if (!v.isEmpty(arrayList) && !this.jua.isEmpty()) {
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.jua.contains(Long.valueOf(com.baidu.adp.lib.f.b.toLong(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fEO) {
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
                    View inflate = LayoutInflater.from(this.jtu.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar2.fpS = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar2.fpS.setOnClickListener(this.fFR);
                    aVar2.jty = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar2.jty.setRadius(l.getDimens(this.jtu.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar2.jty.setAutoChangeStyle(true);
                    aVar2.jty.setClickable(false);
                    aVar2.fFU = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.mName.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.myAttentionAndFans.d.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            Layout layout = aVar2.mName.getLayout();
                            if (layout != null) {
                                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                                    aVar2.mName.setCompoundDrawablePadding(l.getDimens(d.this.jtu, R.dimen.tbds10));
                                } else {
                                    aVar2.mName.setCompoundDrawablePadding(0);
                                }
                            }
                        }
                    });
                    aVar2.jtz = com.baidu.tbadk.ala.b.aMC().p(this.jtu.getPageContext().getPageActivity(), 5);
                    if (aVar2.jtz != null) {
                        aVar2.jtz.setVisibility(8);
                        aVar2.mContainer.addView(aVar2.jtz, 1);
                    }
                    aVar2.fES = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.fpW = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.jue = (TextView) inflate.findViewById(R.id.chat);
                    aVar2.jue.setOnClickListener(this.jub);
                    aVar2.jtA = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar2.jtA.setContext(this.jtu.getPageContext());
                    aVar2.agS = new com.baidu.tbadk.core.view.userLike.c(this.jtu.getPageContext(), aVar2.jtA);
                    aVar2.mProgress = null;
                    aVar2.mTitle = null;
                    aVar2.juf = null;
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    View inflate2 = LayoutInflater.from(this.jtu.getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
                    aVar2.mTitle = (TextView) inflate2.findViewById(R.id.person_list_title);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.mTitle.getLayoutParams();
                    layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds16);
                    aVar2.mTitle.setLayoutParams(layoutParams);
                    aVar2.juf = (LinearLayout) inflate2.findViewById(R.id.newheader_root);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.jtu.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.jtv);
                    aVar2.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar2.mTitle = null;
                    aVar2.juf = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.jtA != null) {
                aVar.jtA.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.fEO) {
                    aVar.fFU.setVisibility(8);
                    aVar.jue.setVisibility(8);
                    aVar.fES.setVisibility(0);
                    if (this.aOV) {
                        if (this.fEQ) {
                            aVar.fES.setText(R.string.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.fES.setText(R.string.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.fES.setText(R.string.him_no_attention_other);
                        } else {
                            aVar.fES.setText(R.string.no_attention_other);
                        }
                    } else if (this.fEQ) {
                        aVar.fES.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.fES.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.fES.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.fES.setText(R.string.no_fan_other);
                    }
                } else {
                    UserData userData = (UserData) v.getItem(this.dJp, i);
                    if (userData == null) {
                        return null;
                    }
                    aVar.fpS.setTag(Integer.valueOf(i));
                    aVar.jue.setVisibility(0);
                    aVar.fES.setVisibility(8);
                    UtilHelper.showHeadImageViewBigV(aVar.jty, userData, 0);
                    aVar.mName.setText(UtilHelper.getUserName(userData));
                    aVar.jty.setPlaceHolder(1);
                    aVar.jty.startLoad(userData.getAvater(), 12, false);
                    if (aVar.jtz != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            aVar.jtz.setVisibility(8);
                        } else {
                            aVar.jtz.setVisibility(0);
                            com.baidu.tbadk.ala.a aVar3 = new com.baidu.tbadk.ala.a();
                            aVar3.dxn = userData.getAlaUserData();
                            aVar3.type = 5;
                            aVar.jtz.setTag(aVar3);
                        }
                    }
                    if (aq.isEmpty(userData.getIntro())) {
                        aVar.fpW.setVisibility(8);
                    } else {
                        aVar.fpW.setVisibility(0);
                        aVar.fpW.setText(userData.getIntro());
                    }
                    aVar.jue.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    aVar.jtA.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    aVar.agS.a(userData);
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        aVar.jtA.setVisibility(8);
                        aVar.jue.setVisibility(8);
                    } else {
                        aVar.jue.setVisibility(8);
                        aVar.jtA.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else if (getItemViewType(i) != 2) {
                aVar.mName.setText(this.jtu.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
            return view;
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.jtu.getLayoutMode().setNightMode(skinType == 1);
        this.jtu.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.jue != null) {
                am.setViewTextColor(aVar.jue, R.color.btn_forum_focus_color, 1);
                am.setBackgroundResource(aVar.jue, R.drawable.btn_focus_border_bg);
                aVar.jue.setEnabled(true);
            }
            if (aVar.juf != null && aVar.mTitle != null) {
                am.setBackgroundColor(aVar.juf, R.color.cp_bg_line_e);
                am.setViewTextColor(aVar.mTitle, (int) R.color.cp_cont_e);
            }
            if (aVar.jtA != null) {
                aVar.jtA.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fEO) {
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
        if (this.fEO) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c agS;
        TextView fES;
        LinearLayout fFU;
        ViewGroup fpS;
        TextView fpW;
        MyFansUserLikeButton jtA;
        ClickableHeaderImageView jty;
        View jtz;
        TextView jue;
        LinearLayout juf;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
