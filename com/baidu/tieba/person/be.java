package com.baidu.tieba.person;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class be extends BaseAdapter {
    private View.OnClickListener bjF;
    private boolean bnO;
    private int cqF;
    private PersonFriendActivity crN;
    private View.OnClickListener crP;
    private ArrayList<UserData> Xk = null;
    private boolean mHasMore = false;
    private boolean crO = false;
    private boolean cck = false;
    private ArrayList<ProgressBar> cds = new ArrayList<>();

    public void adN() {
        if (this.cds != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.cds.size()) {
                    try {
                        this.cds.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.cds.clear();
                    return;
                }
            }
        }
    }

    public void adO() {
        this.cck = false;
        if (this.Xk != null && this.Xk.size() == 0) {
            this.cck = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void eZ(boolean z) {
        this.crO = z;
    }

    public be(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.crN = null;
        this.bnO = true;
        this.cqF = 0;
        this.crP = null;
        this.bjF = null;
        this.crN = personFriendActivity;
        this.bnO = z;
        this.cqF = i;
        this.crP = onClickListener;
        this.bjF = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.Xk = arrayList;
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
                    View inflate = LayoutInflater.from(this.crN.getPageContext().getPageActivity()).inflate(i.g.person_list_item_friend, (ViewGroup) null);
                    aVar2.aTr = (HeadImageView) inflate.findViewById(i.f.photo);
                    aVar2.aTr.setIsRound(false);
                    aVar2.aTr.setAutoChangeStyle(true);
                    aVar2.crR = (LinearLayout) inflate.findViewById(i.f.info);
                    aVar2.bsQ = (TextView) inflate.findViewById(i.f.name);
                    aVar2.crS = (TextView) inflate.findViewById(i.f.at_list_nodata);
                    aVar2.aQB = (TextView) inflate.findViewById(i.f.intro);
                    aVar2.crQ = (ImageView) inflate.findViewById(i.f.chat);
                    aVar2.bGz = (ImageView) inflate.findViewById(i.f.diver_buttom_px);
                    aVar2.crQ.setOnClickListener(this.crP);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.crN.getPageContext().getPageActivity()).inflate(i.g.new_pb_list_more, (ViewGroup) null);
                    aVar2.bsQ = (TextView) inflate2.findViewById(i.f.pb_more_text);
                    inflate2.setOnClickListener(this.bjF);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(i.f.progress);
                    this.cds.add(aVar2.mProgress);
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
                    aVar.crS.setVisibility(8);
                    aVar.bGz.setVisibility(8);
                } else {
                    if (!this.bnO && this.cqF == 0) {
                        aVar.crQ.setVisibility(8);
                    } else {
                        aVar.crQ.setVisibility(0);
                    }
                    aVar.crR.setVisibility(0);
                    aVar.crR.setTag(Integer.valueOf(i));
                    aVar.bGz.setVisibility(0);
                    aVar.crS.setVisibility(8);
                    String portrait = this.Xk.get(i).getPortrait();
                    aVar.aTr.setImageDrawable(null);
                    aVar.aTr.d(portrait, 12, false);
                    aVar.bsQ.setText(this.Xk.get(i).getName_show());
                    aVar.aQB.setText(this.Xk.get(i).getIntro());
                    aVar.crQ.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.bsQ.setText(this.crN.getPageContext().getString(i.h.loading));
                aVar.mProgress.setVisibility(0);
            }
            applyNightMode(view);
        }
        return view;
    }

    private void applyNightMode(View view) {
        this.crN.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.crN.getLayoutMode().k(view);
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
        ImageView bGz;
        TextView bsQ;
        ImageView crQ;
        LinearLayout crR;
        TextView crS;
        ProgressBar mProgress;

        private a() {
        }

        /* synthetic */ a(be beVar, a aVar) {
            this();
        }
    }
}
