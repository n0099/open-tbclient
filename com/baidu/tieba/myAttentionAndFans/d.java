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
    boolean aJg;
    boolean fqG;
    private View.OnClickListener frJ;
    private View.OnClickListener jdO;
    private PersonListActivity jdh;
    private View.OnClickListener jdi;
    private int mSex;
    boolean fqE = false;
    private HashSet<Long> jdN = new HashSet<>();

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.jdh = null;
        this.aJg = false;
        this.fqG = true;
        this.mSex = 0;
        this.jdO = null;
        this.jdi = null;
        this.frJ = null;
        this.jdh = personListActivity;
        this.aJg = z;
        this.fqG = z2;
        this.mSex = i;
        this.jdO = onClickListener2;
        this.jdi = onClickListener3;
        this.frJ = onClickListener;
        this.dvq = new ArrayList<>();
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public void a(av avVar) {
        ArrayList arrayList = new ArrayList();
        if (this.dvq.isEmpty() && !v.isEmpty(avVar.aJE())) {
            Iterator<UserData> it = avVar.aJE().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.jdN.add(Long.valueOf(com.baidu.adp.lib.f.b.toLong(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(avVar.aJE());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(aG(avVar.aJD()));
        this.dvq.addAll(arrayList);
    }

    @Override // com.baidu.tieba.myAttentionAndFans.b
    public boolean eX(long j) {
        if (j == 0 || this.dvq == null || this.dvq.size() == 0) {
            return false;
        }
        Iterator<UserData> it = this.dvq.iterator();
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
        if (!v.isEmpty(arrayList) && !this.jdN.isEmpty()) {
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.jdN.contains(Long.valueOf(com.baidu.adp.lib.f.b.toLong(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fqE) {
            return 1;
        }
        int i = 0;
        if (this.dvq != null) {
            i = this.dvq.size();
        }
        if (isHasMore()) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dvq == null || i >= this.dvq.size()) {
            return null;
        }
        return this.dvq.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.dvq == null || i >= this.dvq.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (this.dvq != null) {
            if (view == null || !(view.getTag() instanceof a)) {
                final a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.jdh.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    aVar2.fbZ = (ViewGroup) inflate.findViewById(R.id.item_view);
                    aVar2.fbZ.setOnClickListener(this.frJ);
                    aVar2.jdl = (ClickableHeaderImageView) inflate.findViewById(R.id.photo);
                    aVar2.jdl.setRadius(l.getDimens(this.jdh.getPageContext().getPageActivity(), R.dimen.ds90));
                    aVar2.jdl.setAutoChangeStyle(true);
                    aVar2.jdl.setClickable(false);
                    aVar2.frM = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mContainer = (LinearLayout) inflate.findViewById(R.id.tail_container);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.mName.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.myAttentionAndFans.d.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            Layout layout = aVar2.mName.getLayout();
                            if (layout != null) {
                                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                                    aVar2.mName.setCompoundDrawablePadding(l.getDimens(d.this.jdh, R.dimen.tbds10));
                                } else {
                                    aVar2.mName.setCompoundDrawablePadding(0);
                                }
                            }
                        }
                    });
                    aVar2.jdm = com.baidu.tbadk.ala.b.aGP().p(this.jdh.getPageContext().getPageActivity(), 5);
                    if (aVar2.jdm != null) {
                        aVar2.jdm.setVisibility(8);
                        aVar2.mContainer.addView(aVar2.jdm, 1);
                    }
                    aVar2.fqI = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.fcd = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.jdR = (TextView) inflate.findViewById(R.id.chat);
                    aVar2.jdR.setOnClickListener(this.jdO);
                    aVar2.jdn = (MyFansUserLikeButton) inflate.findViewById(R.id.attention_btn);
                    aVar2.jdn.setContext(this.jdh.getPageContext());
                    aVar2.agm = new com.baidu.tbadk.core.view.userLike.c(this.jdh.getPageContext(), aVar2.jdn);
                    aVar2.mProgress = null;
                    aVar2.mTitle = null;
                    aVar2.jdS = null;
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    View inflate2 = LayoutInflater.from(this.jdh.getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
                    aVar2.mTitle = (TextView) inflate2.findViewById(R.id.person_list_title);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.mTitle.getLayoutParams();
                    layoutParams.height = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds16);
                    aVar2.mTitle.setLayoutParams(layoutParams);
                    aVar2.jdS = (LinearLayout) inflate2.findViewById(R.id.newheader_root);
                    view2 = inflate2;
                } else {
                    View inflate3 = LayoutInflater.from(this.jdh.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate3.findViewById(R.id.pb_more_text);
                    inflate3.setOnClickListener(this.jdi);
                    aVar2.mProgress = (ProgressBar) inflate3.findViewById(R.id.progress);
                    aVar2.mTitle = null;
                    aVar2.jdS = null;
                    view2 = inflate3;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar.jdn != null) {
                aVar.jdn.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.fqE) {
                    aVar.frM.setVisibility(8);
                    aVar.jdR.setVisibility(8);
                    aVar.fqI.setVisibility(0);
                    if (this.aJg) {
                        if (this.fqG) {
                            aVar.fqI.setText(R.string.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.fqI.setText(R.string.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.fqI.setText(R.string.him_no_attention_other);
                        } else {
                            aVar.fqI.setText(R.string.no_attention_other);
                        }
                    } else if (this.fqG) {
                        aVar.fqI.setText(R.string.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.fqI.setText(R.string.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.fqI.setText(R.string.him_no_fan_other);
                    } else {
                        aVar.fqI.setText(R.string.no_fan_other);
                    }
                } else {
                    UserData userData = (UserData) v.getItem(this.dvq, i);
                    if (userData == null) {
                        return null;
                    }
                    aVar.fbZ.setTag(Integer.valueOf(i));
                    aVar.jdR.setVisibility(0);
                    aVar.fqI.setVisibility(8);
                    UtilHelper.showHeadImageViewBigV(aVar.jdl, userData, 0);
                    aVar.mName.setText(UtilHelper.getUserName(userData));
                    aVar.jdl.setPlaceHolder(1);
                    aVar.jdl.startLoad(userData.getAvater(), 12, false);
                    if (aVar.jdm != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            aVar.jdm.setVisibility(8);
                        } else {
                            aVar.jdm.setVisibility(0);
                            com.baidu.tbadk.ala.a aVar3 = new com.baidu.tbadk.ala.a();
                            aVar3.djj = userData.getAlaUserData();
                            aVar3.type = 5;
                            aVar.jdm.setTag(aVar3);
                        }
                    }
                    if (aq.isEmpty(userData.getIntro())) {
                        aVar.fcd.setVisibility(8);
                    } else {
                        aVar.fcd.setVisibility(0);
                        aVar.fcd.setText(userData.getIntro());
                    }
                    aVar.jdR.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    aVar.jdn.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    aVar.agm.a(userData);
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        aVar.jdn.setVisibility(8);
                        aVar.jdR.setVisibility(8);
                    } else {
                        aVar.jdR.setVisibility(8);
                        aVar.jdn.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else if (getItemViewType(i) != 2) {
                aVar.mName.setText(this.jdh.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            a(view, aVar);
            return view;
        }
        return view;
    }

    private void a(View view, a aVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.jdh.getLayoutMode().setNightMode(skinType == 1);
        this.jdh.getLayoutMode().onModeChanged(view);
        if (aVar != null) {
            if (aVar.jdR != null) {
                am.setViewTextColor(aVar.jdR, R.color.btn_forum_focus_color, 1);
                am.setBackgroundResource(aVar.jdR, R.drawable.btn_focus_border_bg);
                aVar.jdR.setEnabled(true);
            }
            if (aVar.jdS != null && aVar.mTitle != null) {
                am.setBackgroundColor(aVar.jdS, R.color.cp_bg_line_e);
                am.setViewTextColor(aVar.mTitle, (int) R.color.cp_cont_e);
            }
            if (aVar.jdn != null) {
                aVar.jdn.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fqE) {
            return 0;
        }
        if (this.dvq == null || i >= this.dvq.size()) {
            return 1;
        }
        return this.dvq.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fqE) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c agm;
        ViewGroup fbZ;
        TextView fcd;
        TextView fqI;
        LinearLayout frM;
        TextView jdR;
        LinearLayout jdS;
        ClickableHeaderImageView jdl;
        View jdm;
        MyFansUserLikeButton jdn;
        LinearLayout mContainer;
        TextView mName;
        ProgressBar mProgress;
        TextView mTitle;

        private a() {
        }
    }
}
