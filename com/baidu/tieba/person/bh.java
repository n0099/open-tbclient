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
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bh extends BaseAdapter {
    private View.OnClickListener cbj;
    private boolean chd;
    private View.OnClickListener dGt;
    private PersonFriendActivity efj;
    private int mPageType;
    private ArrayList<UserData> SV = null;
    private boolean mHasMore = false;
    private boolean dGq = false;
    private boolean dGr = false;
    private ArrayList<ProgressBar> efk = new ArrayList<>();

    public void aCt() {
        if (this.efk != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.efk.size()) {
                    try {
                        this.efk.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.efk.clear();
                    return;
                }
            }
        }
    }

    public void aBX() {
        this.dGr = false;
        if (this.SV != null && this.SV.size() == 0) {
            this.dGr = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void gM(boolean z) {
        this.dGq = z;
    }

    public bh(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.efj = null;
        this.chd = true;
        this.mPageType = 0;
        this.dGt = null;
        this.cbj = null;
        this.efj = personFriendActivity;
        this.chd = z;
        this.mPageType = i;
        this.dGt = onClickListener;
        this.cbj = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.SV = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dGr) {
            return 1;
        }
        int i = 0;
        if (this.SV != null) {
            i = this.SV.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.SV == null || i >= this.SV.size()) {
            return null;
        }
        return this.SV.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.SV == null || i >= this.SV.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.SV != null) {
            if (view == null) {
                a aVar2 = new a(this, null);
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.efj.getPageContext().getPageActivity()).inflate(u.h.person_list_item_friend, (ViewGroup) null);
                    aVar2.bBS = (HeadImageView) inflate.findViewById(u.g.photo);
                    aVar2.bBS.setIsRound(false);
                    aVar2.bBS.setAutoChangeStyle(true);
                    aVar2.dGz = (LinearLayout) inflate.findViewById(u.g.info);
                    aVar2.cFy = (TextView) inflate.findViewById(u.g.name);
                    aVar2.dGA = (TextView) inflate.findViewById(u.g.at_list_nodata);
                    aVar2.byo = (TextView) inflate.findViewById(u.g.intro);
                    aVar2.dGx = (ImageView) inflate.findViewById(u.g.chat);
                    aVar2.cUF = (ImageView) inflate.findViewById(u.g.diver_buttom_px);
                    aVar2.dGx.setOnClickListener(this.dGt);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.efj.getPageContext().getPageActivity()).inflate(u.h.new_pb_list_more, (ViewGroup) null);
                    aVar2.cFy = (TextView) inflate2.findViewById(u.g.pb_more_text);
                    inflate2.setOnClickListener(this.cbj);
                    aVar2.cbl = (ProgressBar) inflate2.findViewById(u.g.progress);
                    this.efk.add(aVar2.cbl);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.dGr) {
                    aVar.dGz.setVisibility(8);
                    aVar.dGx.setVisibility(8);
                    aVar.dGA.setVisibility(8);
                    aVar.cUF.setVisibility(8);
                } else {
                    if (!this.chd && this.mPageType == 0) {
                        aVar.dGx.setVisibility(8);
                    } else {
                        aVar.dGx.setVisibility(0);
                    }
                    aVar.dGz.setVisibility(0);
                    aVar.dGz.setTag(Integer.valueOf(i));
                    aVar.cUF.setVisibility(0);
                    aVar.dGA.setVisibility(8);
                    String portrait = this.SV.get(i).getPortrait();
                    aVar.bBS.setImageDrawable(null);
                    aVar.bBS.c(portrait, 12, false);
                    aVar.cFy.setText(this.SV.get(i).getName_show());
                    aVar.byo.setText(this.SV.get(i).getIntro());
                    aVar.dGx.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.cFy.setText(this.efj.getPageContext().getString(u.j.loading));
                aVar.cbl.setVisibility(0);
            }
            u(view);
        }
        return view;
    }

    private void u(View view) {
        this.efj.getLayoutMode().ad(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.efj.getLayoutMode().w(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.dGr) {
            return 0;
        }
        return (this.SV == null || i >= this.SV.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.dGr) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes.dex */
    private class a {
        HeadImageView bBS;
        TextView byo;
        TextView cFy;
        ImageView cUF;
        ProgressBar cbl;
        TextView dGA;
        ImageView dGx;
        LinearLayout dGz;

        private a() {
        }

        /* synthetic */ a(bh bhVar, a aVar) {
            this();
        }
    }
}
