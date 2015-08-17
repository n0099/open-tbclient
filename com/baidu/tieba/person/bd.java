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
    private View.OnClickListener bif;
    private boolean bmc;
    private int ciB;
    private PersonFriendActivity cjH;
    private View.OnClickListener cjJ;
    private ArrayList<UserData> Xe = null;
    private boolean mHasMore = false;
    private boolean cjI = false;
    private boolean bWV = false;
    private ArrayList<ProgressBar> bYa = new ArrayList<>();

    public void abW() {
        if (this.bYa != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.bYa.size()) {
                    try {
                        this.bYa.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.bYa.clear();
                    return;
                }
            }
        }
    }

    public void abX() {
        this.bWV = false;
        if (this.Xe != null && this.Xe.size() == 0) {
            this.bWV = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void eH(boolean z) {
        this.cjI = z;
    }

    public bd(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.cjH = null;
        this.bmc = true;
        this.ciB = 0;
        this.cjJ = null;
        this.bif = null;
        this.cjH = personFriendActivity;
        this.bmc = z;
        this.ciB = i;
        this.cjJ = onClickListener;
        this.bif = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.Xe = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bWV) {
            return 1;
        }
        int i = 0;
        if (this.Xe != null) {
            i = this.Xe.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.Xe == null || i >= this.Xe.size()) {
            return null;
        }
        return this.Xe.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.Xe == null || i >= this.Xe.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.Xe != null) {
            if (view == null) {
                a aVar2 = new a(this, null);
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.cjH.getPageContext().getPageActivity()).inflate(i.g.person_list_item_friend, (ViewGroup) null);
                    aVar2.aTO = (HeadImageView) inflate.findViewById(i.f.photo);
                    aVar2.aTO.setIsRound(false);
                    aVar2.aTO.setAutoChangeStyle(true);
                    aVar2.cjL = (LinearLayout) inflate.findViewById(i.f.info);
                    aVar2.boD = (TextView) inflate.findViewById(i.f.name);
                    aVar2.cjM = (TextView) inflate.findViewById(i.f.at_list_nodata);
                    aVar2.aQY = (TextView) inflate.findViewById(i.f.intro);
                    aVar2.cjK = (ImageView) inflate.findViewById(i.f.chat);
                    aVar2.bCj = (ImageView) inflate.findViewById(i.f.diver_buttom_px);
                    aVar2.cjK.setOnClickListener(this.cjJ);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.cjH.getPageContext().getPageActivity()).inflate(i.g.new_pb_list_more, (ViewGroup) null);
                    aVar2.boD = (TextView) inflate2.findViewById(i.f.pb_more_text);
                    inflate2.setOnClickListener(this.bif);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(i.f.progress);
                    this.bYa.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.bWV) {
                    aVar.cjL.setVisibility(8);
                    aVar.cjK.setVisibility(8);
                    aVar.cjM.setVisibility(8);
                    aVar.bCj.setVisibility(8);
                } else {
                    if (!this.bmc && this.ciB == 0) {
                        aVar.cjK.setVisibility(8);
                    } else {
                        aVar.cjK.setVisibility(0);
                    }
                    aVar.cjL.setVisibility(0);
                    aVar.cjL.setTag(Integer.valueOf(i));
                    aVar.bCj.setVisibility(0);
                    aVar.cjM.setVisibility(8);
                    String portrait = this.Xe.get(i).getPortrait();
                    aVar.aTO.setImageDrawable(null);
                    aVar.aTO.d(portrait, 12, false);
                    aVar.boD.setText(this.Xe.get(i).getName_show());
                    aVar.aQY.setText(this.Xe.get(i).getIntro());
                    aVar.cjK.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.boD.setText(this.cjH.getPageContext().getString(i.C0057i.loading));
                aVar.mProgress.setVisibility(0);
            }
            applyNightMode(view);
        }
        return view;
    }

    private void applyNightMode(View view) {
        this.cjH.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.cjH.getLayoutMode().k(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.bWV) {
            return 0;
        }
        return (this.Xe == null || i >= this.Xe.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.bWV) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView aQY;
        HeadImageView aTO;
        ImageView bCj;
        TextView boD;
        ImageView cjK;
        LinearLayout cjL;
        TextView cjM;
        ProgressBar mProgress;

        private a() {
        }

        /* synthetic */ a(bd bdVar, a aVar) {
            this();
        }
    }
}
