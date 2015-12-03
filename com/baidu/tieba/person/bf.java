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
    private View.OnClickListener brh;
    private boolean bwJ;
    private PersonFriendActivity cLh;
    private View.OnClickListener cLj;
    private int mPageType;
    private ArrayList<UserData> XX = null;
    private boolean mHasMore = false;
    private boolean cLi = false;
    private boolean cuk = false;
    private ArrayList<ProgressBar> cvu = new ArrayList<>();

    public void aib() {
        if (this.cvu != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.cvu.size()) {
                    try {
                        this.cvu.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.cvu.clear();
                    return;
                }
            }
        }
    }

    public void aic() {
        this.cuk = false;
        if (this.XX != null && this.XX.size() == 0) {
            this.cuk = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void fE(boolean z) {
        this.cLi = z;
    }

    public bf(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.cLh = null;
        this.bwJ = true;
        this.mPageType = 0;
        this.cLj = null;
        this.brh = null;
        this.cLh = personFriendActivity;
        this.bwJ = z;
        this.mPageType = i;
        this.cLj = onClickListener;
        this.brh = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.XX = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cuk) {
            return 1;
        }
        int i = 0;
        if (this.XX != null) {
            i = this.XX.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.XX == null || i >= this.XX.size()) {
            return null;
        }
        return this.XX.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.XX == null || i >= this.XX.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.XX != null) {
            if (view == null) {
                a aVar2 = new a(this, null);
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.cLh.getPageContext().getPageActivity()).inflate(n.g.person_list_item_friend, (ViewGroup) null);
                    aVar2.aYF = (HeadImageView) inflate.findViewById(n.f.photo);
                    aVar2.aYF.setIsRound(false);
                    aVar2.aYF.setAutoChangeStyle(true);
                    aVar2.cLl = (LinearLayout) inflate.findViewById(n.f.info);
                    aVar2.bHW = (TextView) inflate.findViewById(n.f.name);
                    aVar2.cLm = (TextView) inflate.findViewById(n.f.at_list_nodata);
                    aVar2.aVE = (TextView) inflate.findViewById(n.f.intro);
                    aVar2.cLk = (ImageView) inflate.findViewById(n.f.chat);
                    aVar2.bVG = (ImageView) inflate.findViewById(n.f.diver_buttom_px);
                    aVar2.cLk.setOnClickListener(this.cLj);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.cLh.getPageContext().getPageActivity()).inflate(n.g.new_pb_list_more, (ViewGroup) null);
                    aVar2.bHW = (TextView) inflate2.findViewById(n.f.pb_more_text);
                    inflate2.setOnClickListener(this.brh);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(n.f.progress);
                    this.cvu.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.cuk) {
                    aVar.cLl.setVisibility(8);
                    aVar.cLk.setVisibility(8);
                    aVar.cLm.setVisibility(8);
                    aVar.bVG.setVisibility(8);
                } else {
                    if (!this.bwJ && this.mPageType == 0) {
                        aVar.cLk.setVisibility(8);
                    } else {
                        aVar.cLk.setVisibility(0);
                    }
                    aVar.cLl.setVisibility(0);
                    aVar.cLl.setTag(Integer.valueOf(i));
                    aVar.bVG.setVisibility(0);
                    aVar.cLm.setVisibility(8);
                    String portrait = this.XX.get(i).getPortrait();
                    aVar.aYF.setImageDrawable(null);
                    aVar.aYF.d(portrait, 12, false);
                    aVar.bHW.setText(this.XX.get(i).getName_show());
                    aVar.aVE.setText(this.XX.get(i).getIntro());
                    aVar.cLk.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.bHW.setText(this.cLh.getPageContext().getString(n.i.loading));
                aVar.mProgress.setVisibility(0);
            }
            applyNightMode(view);
        }
        return view;
    }

    private void applyNightMode(View view) {
        this.cLh.getLayoutMode().af(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.cLh.getLayoutMode().k(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.cuk) {
            return 0;
        }
        return (this.XX == null || i >= this.XX.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.cuk) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView aVE;
        HeadImageView aYF;
        TextView bHW;
        ImageView bVG;
        ImageView cLk;
        LinearLayout cLl;
        TextView cLm;
        ProgressBar mProgress;

        private a() {
        }

        /* synthetic */ a(bf bfVar, a aVar) {
            this();
        }
    }
}
