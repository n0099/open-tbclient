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
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bf extends BaseAdapter {
    private View.OnClickListener bDC;
    private boolean bJj;
    private PersonFriendActivity dtw;
    private View.OnClickListener dtz;
    private int mPageType;
    private ArrayList<UserData> Xq = null;
    private boolean mHasMore = false;
    private boolean dtx = false;
    private boolean cYk = false;
    private ArrayList<ProgressBar> dty = new ArrayList<>();

    public void auf() {
        if (this.dty != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.dty.size()) {
                    try {
                        this.dty.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.dty.clear();
                    return;
                }
            }
        }
    }

    public void aug() {
        this.cYk = false;
        if (this.Xq != null && this.Xq.size() == 0) {
            this.cYk = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void gF(boolean z) {
        this.dtx = z;
    }

    public bf(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.dtw = null;
        this.bJj = true;
        this.mPageType = 0;
        this.dtz = null;
        this.bDC = null;
        this.dtw = personFriendActivity;
        this.bJj = z;
        this.mPageType = i;
        this.dtz = onClickListener;
        this.bDC = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.Xq = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cYk) {
            return 1;
        }
        int i = 0;
        if (this.Xq != null) {
            i = this.Xq.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.Xq == null || i >= this.Xq.size()) {
            return null;
        }
        return this.Xq.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.Xq == null || i >= this.Xq.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.Xq != null) {
            if (view == null) {
                a aVar2 = new a(this, null);
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.dtw.getPageContext().getPageActivity()).inflate(t.h.person_list_item_friend, (ViewGroup) null);
                    aVar2.bjG = (HeadImageView) inflate.findViewById(t.g.photo);
                    aVar2.bjG.setIsRound(false);
                    aVar2.bjG.setAutoChangeStyle(true);
                    aVar2.dtB = (LinearLayout) inflate.findViewById(t.g.info);
                    aVar2.bZJ = (TextView) inflate.findViewById(t.g.name);
                    aVar2.dtC = (TextView) inflate.findViewById(t.g.at_list_nodata);
                    aVar2.bgE = (TextView) inflate.findViewById(t.g.intro);
                    aVar2.dtA = (ImageView) inflate.findViewById(t.g.chat);
                    aVar2.cos = (ImageView) inflate.findViewById(t.g.diver_buttom_px);
                    aVar2.dtA.setOnClickListener(this.dtz);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.dtw.getPageContext().getPageActivity()).inflate(t.h.new_pb_list_more, (ViewGroup) null);
                    aVar2.bZJ = (TextView) inflate2.findViewById(t.g.pb_more_text);
                    inflate2.setOnClickListener(this.bDC);
                    aVar2.aQj = (ProgressBar) inflate2.findViewById(t.g.progress);
                    this.dty.add(aVar2.aQj);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.cYk) {
                    aVar.dtB.setVisibility(8);
                    aVar.dtA.setVisibility(8);
                    aVar.dtC.setVisibility(8);
                    aVar.cos.setVisibility(8);
                } else {
                    if (!this.bJj && this.mPageType == 0) {
                        aVar.dtA.setVisibility(8);
                    } else {
                        aVar.dtA.setVisibility(0);
                    }
                    aVar.dtB.setVisibility(0);
                    aVar.dtB.setTag(Integer.valueOf(i));
                    aVar.cos.setVisibility(0);
                    aVar.dtC.setVisibility(8);
                    String portrait = this.Xq.get(i).getPortrait();
                    aVar.bjG.setImageDrawable(null);
                    aVar.bjG.c(portrait, 12, false);
                    aVar.bZJ.setText(this.Xq.get(i).getName_show());
                    aVar.bgE.setText(this.Xq.get(i).getIntro());
                    aVar.dtA.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.bZJ.setText(this.dtw.getPageContext().getString(t.j.loading));
                aVar.aQj.setVisibility(0);
            }
            u(view);
        }
        return view;
    }

    private void u(View view) {
        this.dtw.getLayoutMode().ab(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.dtw.getLayoutMode().x(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.cYk) {
            return 0;
        }
        return (this.Xq == null || i >= this.Xq.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.cYk) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes.dex */
    private class a {
        ProgressBar aQj;
        TextView bZJ;
        TextView bgE;
        HeadImageView bjG;
        ImageView cos;
        ImageView dtA;
        LinearLayout dtB;
        TextView dtC;

        private a() {
        }

        /* synthetic */ a(bf bfVar, a aVar) {
            this();
        }
    }
}
