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
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bf extends BaseAdapter {
    private boolean bAA;
    private View.OnClickListener buY;
    private PersonFriendActivity cPx;
    private View.OnClickListener cPz;
    private int mPageType;
    private ArrayList<UserData> YA = null;
    private boolean mHasMore = false;
    private boolean cPy = false;
    private boolean cyl = false;
    private ArrayList<ProgressBar> czu = new ArrayList<>();

    public void ajo() {
        if (this.czu != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.czu.size()) {
                    try {
                        this.czu.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.czu.clear();
                    return;
                }
            }
        }
    }

    public void ajp() {
        this.cyl = false;
        if (this.YA != null && this.YA.size() == 0) {
            this.cyl = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void fD(boolean z) {
        this.cPy = z;
    }

    public bf(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.cPx = null;
        this.bAA = true;
        this.mPageType = 0;
        this.cPz = null;
        this.buY = null;
        this.cPx = personFriendActivity;
        this.bAA = z;
        this.mPageType = i;
        this.cPz = onClickListener;
        this.buY = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.YA = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cyl) {
            return 1;
        }
        int i = 0;
        if (this.YA != null) {
            i = this.YA.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.YA == null || i >= this.YA.size()) {
            return null;
        }
        return this.YA.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.YA == null || i >= this.YA.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.YA != null) {
            if (view == null) {
                a aVar2 = new a(this, null);
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.cPx.getPageContext().getPageActivity()).inflate(n.h.person_list_item_friend, (ViewGroup) null);
                    aVar2.bcC = (HeadImageView) inflate.findViewById(n.g.photo);
                    aVar2.bcC.setIsRound(false);
                    aVar2.bcC.setAutoChangeStyle(true);
                    aVar2.cPB = (LinearLayout) inflate.findViewById(n.g.info);
                    aVar2.bLD = (TextView) inflate.findViewById(n.g.name);
                    aVar2.cPC = (TextView) inflate.findViewById(n.g.at_list_nodata);
                    aVar2.aZE = (TextView) inflate.findViewById(n.g.intro);
                    aVar2.cPA = (ImageView) inflate.findViewById(n.g.chat);
                    aVar2.bZs = (ImageView) inflate.findViewById(n.g.diver_buttom_px);
                    aVar2.cPA.setOnClickListener(this.cPz);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.cPx.getPageContext().getPageActivity()).inflate(n.h.new_pb_list_more, (ViewGroup) null);
                    aVar2.bLD = (TextView) inflate2.findViewById(n.g.pb_more_text);
                    inflate2.setOnClickListener(this.buY);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(n.g.progress);
                    this.czu.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.cyl) {
                    aVar.cPB.setVisibility(8);
                    aVar.cPA.setVisibility(8);
                    aVar.cPC.setVisibility(8);
                    aVar.bZs.setVisibility(8);
                } else {
                    if (!this.bAA && this.mPageType == 0) {
                        aVar.cPA.setVisibility(8);
                    } else {
                        aVar.cPA.setVisibility(0);
                    }
                    aVar.cPB.setVisibility(0);
                    aVar.cPB.setTag(Integer.valueOf(i));
                    aVar.bZs.setVisibility(0);
                    aVar.cPC.setVisibility(8);
                    String portrait = this.YA.get(i).getPortrait();
                    aVar.bcC.setImageDrawable(null);
                    aVar.bcC.d(portrait, 12, false);
                    aVar.bLD.setText(this.YA.get(i).getName_show());
                    aVar.aZE.setText(this.YA.get(i).getIntro());
                    aVar.cPA.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.bLD.setText(this.cPx.getPageContext().getString(n.j.loading));
                aVar.mProgress.setVisibility(0);
            }
            applyNightMode(view);
        }
        return view;
    }

    private void applyNightMode(View view) {
        this.cPx.getLayoutMode().ac(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.cPx.getLayoutMode().k(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.cyl) {
            return 0;
        }
        return (this.YA == null || i >= this.YA.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.cyl) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView aZE;
        TextView bLD;
        ImageView bZs;
        HeadImageView bcC;
        ImageView cPA;
        LinearLayout cPB;
        TextView cPC;
        ProgressBar mProgress;

        private a() {
        }

        /* synthetic */ a(bf bfVar, a aVar) {
            this();
        }
    }
}
