package com.baidu.tieba.person;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bs extends BaseAdapter {
    private ArrayList<UserData> Xk;
    private View.OnClickListener bjF;
    boolean bnO;
    private View.OnClickListener crP;
    private PersonListActivity csk;
    boolean csl;
    private View.OnClickListener csm;
    private View.OnClickListener csn;
    private int mSex;
    private boolean mHasMore = false;
    private boolean crO = false;
    boolean cck = false;

    public void adO() {
        this.cck = false;
        if (this.Xk != null && this.Xk.size() == 0) {
            this.cck = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void eZ(boolean z) {
        this.crO = z;
    }

    public bs(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4) {
        this.Xk = null;
        this.csk = null;
        this.csl = false;
        this.bnO = true;
        this.mSex = 0;
        this.crP = null;
        this.bjF = null;
        this.csm = null;
        this.csn = null;
        this.csk = personListActivity;
        this.csl = z;
        this.bnO = z2;
        this.mSex = i;
        this.crP = onClickListener2;
        this.bjF = onClickListener3;
        this.csm = onClickListener;
        this.csn = onClickListener4;
        this.Xk = new ArrayList<>();
    }

    public void T(ArrayList<UserData> arrayList) {
        this.Xk.addAll(arrayList);
    }

    public void resetData() {
        this.Xk.clear();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cck) {
            return 1;
        }
        int i = 0;
        if (this.Xk != null) {
            i = this.Xk.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.Xk == null || i >= this.Xk.size()) {
            return null;
        }
        return this.Xk.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.Xk == null || i >= this.Xk.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.Xk != null) {
            if (view == null) {
                a aVar2 = new a(this, null);
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.csk.getPageContext().getPageActivity()).inflate(i.g.person_list_item, (ViewGroup) null);
                    aVar2.cso = (ViewGroup) inflate.findViewById(i.f.item_view);
                    aVar2.cso.setOnClickListener(this.csm);
                    aVar2.aTr = (HeadImageView) inflate.findViewById(i.f.photo);
                    aVar2.aTr.setIsRound(false);
                    aVar2.aTr.setAutoChangeStyle(true);
                    aVar2.crR = (LinearLayout) inflate.findViewById(i.f.info);
                    aVar2.bsQ = (TextView) inflate.findViewById(i.f.name);
                    aVar2.crS = (TextView) inflate.findViewById(i.f.at_list_nodata);
                    aVar2.aQB = (TextView) inflate.findViewById(i.f.intro);
                    aVar2.crQ = (ImageView) inflate.findViewById(i.f.chat);
                    aVar2.csp = (TextView) inflate.findViewById(i.f.add);
                    aVar2.crQ.setOnClickListener(this.crP);
                    aVar2.csp.setOnClickListener(this.csn);
                    aVar2.mProgress = null;
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.csk.getPageContext().getPageActivity()).inflate(i.g.new_pb_list_more, (ViewGroup) null);
                    aVar2.bsQ = (TextView) inflate2.findViewById(i.f.pb_more_text);
                    inflate2.setOnClickListener(this.bjF);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(i.f.progress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.cck) {
                    aVar.crR.setVisibility(8);
                    aVar.crQ.setVisibility(8);
                    aVar.csp.setVisibility(8);
                    aVar.crS.setVisibility(0);
                    if (this.csl) {
                        if (this.bnO) {
                            aVar.crS.setText(i.h.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.crS.setText(i.h.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.crS.setText(i.h.him_no_attention_other);
                        } else {
                            aVar.crS.setText(i.h.no_attention_other);
                        }
                    } else if (this.bnO) {
                        aVar.crS.setText(i.h.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.crS.setText(i.h.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.crS.setText(i.h.him_no_fan_other);
                    } else {
                        aVar.crS.setText(i.h.no_fan_other);
                    }
                } else {
                    aVar.cso.setTag(Integer.valueOf(i));
                    aVar.crQ.setVisibility(0);
                    aVar.csp.setVisibility(0);
                    aVar.crR.setVisibility(0);
                    aVar.crS.setVisibility(8);
                    aVar.aTr.d(this.Xk.get(i).getPortrait(), 12, false);
                    aVar.bsQ.setText(this.Xk.get(i).getName_show());
                    aVar.aQB.setText(this.Xk.get(i).getIntro());
                    aVar.crQ.setTag(Integer.valueOf(i));
                    aVar.csp.setTag(Integer.valueOf(i));
                    String userId = this.Xk.get(i).getUserId();
                    if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        aVar.crQ.setVisibility(8);
                        aVar.csp.setVisibility(8);
                    } else if (this.Xk.get(i).getIsFriend() == 1) {
                        aVar.crQ.setVisibility(0);
                        aVar.csp.setVisibility(8);
                    } else {
                        aVar.crQ.setVisibility(8);
                        aVar.csp.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else {
                aVar.bsQ.setText(this.csk.getPageContext().getString(i.h.loading));
                aVar.mProgress.setVisibility(0);
            }
            applyNightMode(view);
        }
        return view;
    }

    private void applyNightMode(View view) {
        this.csk.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.csk.getLayoutMode().k(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.cck) {
            return 0;
        }
        return (this.Xk == null || i >= this.Xk.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.cck) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView aQB;
        HeadImageView aTr;
        TextView bsQ;
        ImageView crQ;
        LinearLayout crR;
        TextView crS;
        ViewGroup cso;
        TextView csp;
        ProgressBar mProgress;

        private a() {
        }

        /* synthetic */ a(bs bsVar, a aVar) {
            this();
        }
    }
}
