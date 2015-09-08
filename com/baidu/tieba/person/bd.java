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
public class bd extends BaseAdapter {
    private View.OnClickListener biB;
    private boolean bmy;
    private int cjv;
    private PersonFriendActivity ckC;
    private View.OnClickListener ckE;
    private ArrayList<UserData> Xn = null;
    private boolean mHasMore = false;
    private boolean ckD = false;
    private boolean bXM = false;
    private ArrayList<ProgressBar> bYU = new ArrayList<>();

    public void ace() {
        if (this.bYU != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.bYU.size()) {
                    try {
                        this.bYU.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.bYU.clear();
                    return;
                }
            }
        }
    }

    public void acf() {
        this.bXM = false;
        if (this.Xn != null && this.Xn.size() == 0) {
            this.bXM = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void eQ(boolean z) {
        this.ckD = z;
    }

    public bd(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.ckC = null;
        this.bmy = true;
        this.cjv = 0;
        this.ckE = null;
        this.biB = null;
        this.ckC = personFriendActivity;
        this.bmy = z;
        this.cjv = i;
        this.ckE = onClickListener;
        this.biB = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.Xn = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bXM) {
            return 1;
        }
        int i = 0;
        if (this.Xn != null) {
            i = this.Xn.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.Xn == null || i >= this.Xn.size()) {
            return null;
        }
        return this.Xn.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.Xn == null || i >= this.Xn.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.Xn != null) {
            if (view == null) {
                a aVar2 = new a(this, null);
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.ckC.getPageContext().getPageActivity()).inflate(i.g.person_list_item_friend, (ViewGroup) null);
                    aVar2.aUc = (HeadImageView) inflate.findViewById(i.f.photo);
                    aVar2.aUc.setIsRound(false);
                    aVar2.aUc.setAutoChangeStyle(true);
                    aVar2.ckG = (LinearLayout) inflate.findViewById(i.f.info);
                    aVar2.bpb = (TextView) inflate.findViewById(i.f.name);
                    aVar2.ckH = (TextView) inflate.findViewById(i.f.at_list_nodata);
                    aVar2.aRm = (TextView) inflate.findViewById(i.f.intro);
                    aVar2.ckF = (ImageView) inflate.findViewById(i.f.chat);
                    aVar2.bCQ = (ImageView) inflate.findViewById(i.f.diver_buttom_px);
                    aVar2.ckF.setOnClickListener(this.ckE);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.ckC.getPageContext().getPageActivity()).inflate(i.g.new_pb_list_more, (ViewGroup) null);
                    aVar2.bpb = (TextView) inflate2.findViewById(i.f.pb_more_text);
                    inflate2.setOnClickListener(this.biB);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(i.f.progress);
                    this.bYU.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.bXM) {
                    aVar.ckG.setVisibility(8);
                    aVar.ckF.setVisibility(8);
                    aVar.ckH.setVisibility(8);
                    aVar.bCQ.setVisibility(8);
                } else {
                    if (!this.bmy && this.cjv == 0) {
                        aVar.ckF.setVisibility(8);
                    } else {
                        aVar.ckF.setVisibility(0);
                    }
                    aVar.ckG.setVisibility(0);
                    aVar.ckG.setTag(Integer.valueOf(i));
                    aVar.bCQ.setVisibility(0);
                    aVar.ckH.setVisibility(8);
                    String portrait = this.Xn.get(i).getPortrait();
                    aVar.aUc.setImageDrawable(null);
                    aVar.aUc.d(portrait, 12, false);
                    aVar.bpb.setText(this.Xn.get(i).getName_show());
                    aVar.aRm.setText(this.Xn.get(i).getIntro());
                    aVar.ckF.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.bpb.setText(this.ckC.getPageContext().getString(i.h.loading));
                aVar.mProgress.setVisibility(0);
            }
            applyNightMode(view);
        }
        return view;
    }

    private void applyNightMode(View view) {
        this.ckC.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.ckC.getLayoutMode().k(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.bXM) {
            return 0;
        }
        return (this.Xn == null || i >= this.Xn.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.bXM) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView aRm;
        HeadImageView aUc;
        ImageView bCQ;
        TextView bpb;
        ImageView ckF;
        LinearLayout ckG;
        TextView ckH;
        ProgressBar mProgress;

        private a() {
        }

        /* synthetic */ a(bd bdVar, a aVar) {
            this();
        }
    }
}
