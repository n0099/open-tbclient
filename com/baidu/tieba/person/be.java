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
    private View.OnClickListener bja;
    private boolean bnk;
    private int cpj;
    private PersonFriendActivity cqr;
    private View.OnClickListener cqt;
    private ArrayList<UserData> Xh = null;
    private boolean mHasMore = false;
    private boolean cqs = false;
    private boolean cbJ = false;
    private ArrayList<ProgressBar> ccR = new ArrayList<>();

    public void ads() {
        if (this.ccR != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.ccR.size()) {
                    try {
                        this.ccR.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.ccR.clear();
                    return;
                }
            }
        }
    }

    public void adt() {
        this.cbJ = false;
        if (this.Xh != null && this.Xh.size() == 0) {
            this.cbJ = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void eW(boolean z) {
        this.cqs = z;
    }

    public be(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.cqr = null;
        this.bnk = true;
        this.cpj = 0;
        this.cqt = null;
        this.bja = null;
        this.cqr = personFriendActivity;
        this.bnk = z;
        this.cpj = i;
        this.cqt = onClickListener;
        this.bja = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.Xh = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cbJ) {
            return 1;
        }
        int i = 0;
        if (this.Xh != null) {
            i = this.Xh.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.Xh == null || i >= this.Xh.size()) {
            return null;
        }
        return this.Xh.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.Xh == null || i >= this.Xh.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.Xh != null) {
            if (view == null) {
                a aVar2 = new a(this, null);
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.cqr.getPageContext().getPageActivity()).inflate(i.g.person_list_item_friend, (ViewGroup) null);
                    aVar2.aTj = (HeadImageView) inflate.findViewById(i.f.photo);
                    aVar2.aTj.setIsRound(false);
                    aVar2.aTj.setAutoChangeStyle(true);
                    aVar2.cqv = (LinearLayout) inflate.findViewById(i.f.info);
                    aVar2.bsm = (TextView) inflate.findViewById(i.f.name);
                    aVar2.cqw = (TextView) inflate.findViewById(i.f.at_list_nodata);
                    aVar2.aQt = (TextView) inflate.findViewById(i.f.intro);
                    aVar2.cqu = (ImageView) inflate.findViewById(i.f.chat);
                    aVar2.bGe = (ImageView) inflate.findViewById(i.f.diver_buttom_px);
                    aVar2.cqu.setOnClickListener(this.cqt);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.cqr.getPageContext().getPageActivity()).inflate(i.g.new_pb_list_more, (ViewGroup) null);
                    aVar2.bsm = (TextView) inflate2.findViewById(i.f.pb_more_text);
                    inflate2.setOnClickListener(this.bja);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(i.f.progress);
                    this.ccR.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.cbJ) {
                    aVar.cqv.setVisibility(8);
                    aVar.cqu.setVisibility(8);
                    aVar.cqw.setVisibility(8);
                    aVar.bGe.setVisibility(8);
                } else {
                    if (!this.bnk && this.cpj == 0) {
                        aVar.cqu.setVisibility(8);
                    } else {
                        aVar.cqu.setVisibility(0);
                    }
                    aVar.cqv.setVisibility(0);
                    aVar.cqv.setTag(Integer.valueOf(i));
                    aVar.bGe.setVisibility(0);
                    aVar.cqw.setVisibility(8);
                    String portrait = this.Xh.get(i).getPortrait();
                    aVar.aTj.setImageDrawable(null);
                    aVar.aTj.d(portrait, 12, false);
                    aVar.bsm.setText(this.Xh.get(i).getName_show());
                    aVar.aQt.setText(this.Xh.get(i).getIntro());
                    aVar.cqu.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.bsm.setText(this.cqr.getPageContext().getString(i.h.loading));
                aVar.mProgress.setVisibility(0);
            }
            applyNightMode(view);
        }
        return view;
    }

    private void applyNightMode(View view) {
        this.cqr.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.cqr.getLayoutMode().k(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.cbJ) {
            return 0;
        }
        return (this.Xh == null || i >= this.Xh.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.cbJ) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView aQt;
        HeadImageView aTj;
        ImageView bGe;
        TextView bsm;
        ImageView cqu;
        LinearLayout cqv;
        TextView cqw;
        ProgressBar mProgress;

        private a() {
        }

        /* synthetic */ a(be beVar, a aVar) {
            this();
        }
    }
}
