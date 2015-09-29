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
    private View.OnClickListener biP;
    private boolean bmZ;
    private int coY;
    private PersonFriendActivity cqg;
    private View.OnClickListener cqi;
    private ArrayList<UserData> Xf = null;
    private boolean mHasMore = false;
    private boolean cqh = false;
    private boolean cby = false;
    private ArrayList<ProgressBar> ccG = new ArrayList<>();

    public void adw() {
        if (this.ccG != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.ccG.size()) {
                    try {
                        this.ccG.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.ccG.clear();
                    return;
                }
            }
        }
    }

    public void adx() {
        this.cby = false;
        if (this.Xf != null && this.Xf.size() == 0) {
            this.cby = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void eW(boolean z) {
        this.cqh = z;
    }

    public be(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.cqg = null;
        this.bmZ = true;
        this.coY = 0;
        this.cqi = null;
        this.biP = null;
        this.cqg = personFriendActivity;
        this.bmZ = z;
        this.coY = i;
        this.cqi = onClickListener;
        this.biP = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.Xf = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cby) {
            return 1;
        }
        int i = 0;
        if (this.Xf != null) {
            i = this.Xf.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.Xf == null || i >= this.Xf.size()) {
            return null;
        }
        return this.Xf.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.Xf == null || i >= this.Xf.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.Xf != null) {
            if (view == null) {
                a aVar2 = new a(this, null);
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.cqg.getPageContext().getPageActivity()).inflate(i.g.person_list_item_friend, (ViewGroup) null);
                    aVar2.aSY = (HeadImageView) inflate.findViewById(i.f.photo);
                    aVar2.aSY.setIsRound(false);
                    aVar2.aSY.setAutoChangeStyle(true);
                    aVar2.cqk = (LinearLayout) inflate.findViewById(i.f.info);
                    aVar2.bsb = (TextView) inflate.findViewById(i.f.name);
                    aVar2.cql = (TextView) inflate.findViewById(i.f.at_list_nodata);
                    aVar2.aQi = (TextView) inflate.findViewById(i.f.intro);
                    aVar2.cqj = (ImageView) inflate.findViewById(i.f.chat);
                    aVar2.bFT = (ImageView) inflate.findViewById(i.f.diver_buttom_px);
                    aVar2.cqj.setOnClickListener(this.cqi);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.cqg.getPageContext().getPageActivity()).inflate(i.g.new_pb_list_more, (ViewGroup) null);
                    aVar2.bsb = (TextView) inflate2.findViewById(i.f.pb_more_text);
                    inflate2.setOnClickListener(this.biP);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(i.f.progress);
                    this.ccG.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.cby) {
                    aVar.cqk.setVisibility(8);
                    aVar.cqj.setVisibility(8);
                    aVar.cql.setVisibility(8);
                    aVar.bFT.setVisibility(8);
                } else {
                    if (!this.bmZ && this.coY == 0) {
                        aVar.cqj.setVisibility(8);
                    } else {
                        aVar.cqj.setVisibility(0);
                    }
                    aVar.cqk.setVisibility(0);
                    aVar.cqk.setTag(Integer.valueOf(i));
                    aVar.bFT.setVisibility(0);
                    aVar.cql.setVisibility(8);
                    String portrait = this.Xf.get(i).getPortrait();
                    aVar.aSY.setImageDrawable(null);
                    aVar.aSY.d(portrait, 12, false);
                    aVar.bsb.setText(this.Xf.get(i).getName_show());
                    aVar.aQi.setText(this.Xf.get(i).getIntro());
                    aVar.cqj.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.bsb.setText(this.cqg.getPageContext().getString(i.h.loading));
                aVar.mProgress.setVisibility(0);
            }
            applyNightMode(view);
        }
        return view;
    }

    private void applyNightMode(View view) {
        this.cqg.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.cqg.getLayoutMode().k(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.cby) {
            return 0;
        }
        return (this.Xf == null || i >= this.Xf.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.cby) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView aQi;
        HeadImageView aSY;
        ImageView bFT;
        TextView bsb;
        ImageView cqj;
        LinearLayout cqk;
        TextView cql;
        ProgressBar mProgress;

        private a() {
        }

        /* synthetic */ a(be beVar, a aVar) {
            this();
        }
    }
}
