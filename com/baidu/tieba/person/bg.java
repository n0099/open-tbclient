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
public class bg extends BaseAdapter {
    private View.OnClickListener bDG;
    private boolean bJq;
    private View.OnClickListener cZL;
    private PersonFriendActivity dwR;
    private int mPageType;
    private ArrayList<UserData> SE = null;
    private boolean mHasMore = false;
    private boolean cZI = false;
    private boolean cZJ = false;
    private ArrayList<ProgressBar> dwS = new ArrayList<>();

    public void aul() {
        if (this.dwS != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.dwS.size()) {
                    try {
                        this.dwS.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.dwS.clear();
                    return;
                }
            }
        }
    }

    public void atP() {
        this.cZJ = false;
        if (this.SE != null && this.SE.size() == 0) {
            this.cZJ = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void fW(boolean z) {
        this.cZI = z;
    }

    public bg(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.dwR = null;
        this.bJq = true;
        this.mPageType = 0;
        this.cZL = null;
        this.bDG = null;
        this.dwR = personFriendActivity;
        this.bJq = z;
        this.mPageType = i;
        this.cZL = onClickListener;
        this.bDG = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.SE = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cZJ) {
            return 1;
        }
        int i = 0;
        if (this.SE != null) {
            i = this.SE.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.SE == null || i >= this.SE.size()) {
            return null;
        }
        return this.SE.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.SE == null || i >= this.SE.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.SE != null) {
            if (view == null) {
                a aVar2 = new a(this, null);
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.dwR.getPageContext().getPageActivity()).inflate(t.h.person_list_item_friend, (ViewGroup) null);
                    aVar2.bfG = (HeadImageView) inflate.findViewById(t.g.photo);
                    aVar2.bfG.setIsRound(false);
                    aVar2.bfG.setAutoChangeStyle(true);
                    aVar2.cZR = (LinearLayout) inflate.findViewById(t.g.info);
                    aVar2.cao = (TextView) inflate.findViewById(t.g.name);
                    aVar2.cZS = (TextView) inflate.findViewById(t.g.at_list_nodata);
                    aVar2.bct = (TextView) inflate.findViewById(t.g.intro);
                    aVar2.cZP = (ImageView) inflate.findViewById(t.g.chat);
                    aVar2.cpp = (ImageView) inflate.findViewById(t.g.diver_buttom_px);
                    aVar2.cZP.setOnClickListener(this.cZL);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.dwR.getPageContext().getPageActivity()).inflate(t.h.new_pb_list_more, (ViewGroup) null);
                    aVar2.cao = (TextView) inflate2.findViewById(t.g.pb_more_text);
                    inflate2.setOnClickListener(this.bDG);
                    aVar2.bDI = (ProgressBar) inflate2.findViewById(t.g.progress);
                    this.dwS.add(aVar2.bDI);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.cZJ) {
                    aVar.cZR.setVisibility(8);
                    aVar.cZP.setVisibility(8);
                    aVar.cZS.setVisibility(8);
                    aVar.cpp.setVisibility(8);
                } else {
                    if (!this.bJq && this.mPageType == 0) {
                        aVar.cZP.setVisibility(8);
                    } else {
                        aVar.cZP.setVisibility(0);
                    }
                    aVar.cZR.setVisibility(0);
                    aVar.cZR.setTag(Integer.valueOf(i));
                    aVar.cpp.setVisibility(0);
                    aVar.cZS.setVisibility(8);
                    String portrait = this.SE.get(i).getPortrait();
                    aVar.bfG.setImageDrawable(null);
                    aVar.bfG.c(portrait, 12, false);
                    aVar.cao.setText(this.SE.get(i).getName_show());
                    aVar.bct.setText(this.SE.get(i).getIntro());
                    aVar.cZP.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.cao.setText(this.dwR.getPageContext().getString(t.j.loading));
                aVar.bDI.setVisibility(0);
            }
            u(view);
        }
        return view;
    }

    private void u(View view) {
        this.dwR.getLayoutMode().ae(TbadkCoreApplication.m11getInst().getSkinType() == 1);
        this.dwR.getLayoutMode().x(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.cZJ) {
            return 0;
        }
        return (this.SE == null || i >= this.SE.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.cZJ) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes.dex */
    private class a {
        ProgressBar bDI;
        TextView bct;
        HeadImageView bfG;
        ImageView cZP;
        LinearLayout cZR;
        TextView cZS;
        TextView cao;
        ImageView cpp;

        private a() {
        }

        /* synthetic */ a(bg bgVar, a aVar) {
            this();
        }
    }
}
