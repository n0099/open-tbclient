package com.baidu.tieba.personExtra;

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
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c extends BaseAdapter {
    private boolean dPN;
    private PersonFriendActivity fYx;
    private View.OnClickListener fiF;
    private View.OnClickListener fji;
    private int mPageType;
    private ArrayList<UserData> alt = null;
    private boolean mHasMore = false;
    private boolean fYy = false;
    private boolean fiD = false;
    private ArrayList<ProgressBar> fYz = new ArrayList<>();

    public void biL() {
        if (this.fYz != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.fYz.size()) {
                    try {
                        this.fYz.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.fYz.clear();
                    return;
                }
            }
        }
    }

    public void aWp() {
        this.fiD = false;
        if (this.alt != null && this.alt.size() == 0) {
            this.fiD = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void le(boolean z) {
        this.fYy = z;
    }

    public c(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.fYx = null;
        this.dPN = true;
        this.mPageType = 0;
        this.fji = null;
        this.fiF = null;
        this.fYx = personFriendActivity;
        this.dPN = z;
        this.mPageType = i;
        this.fji = onClickListener;
        this.fiF = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.alt = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fiD) {
            return 1;
        }
        int i = 0;
        if (this.alt != null) {
            i = this.alt.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.alt == null || i >= this.alt.size()) {
            return null;
        }
        return this.alt.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.alt == null || i >= this.alt.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.alt != null) {
            if (view == null) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.fYx.getPageContext().getPageActivity()).inflate(d.h.person_list_item_friend, (ViewGroup) null);
                    aVar2.doZ = (HeadImageView) inflate.findViewById(d.g.photo);
                    aVar2.doZ.setIsRound(false);
                    aVar2.doZ.setAutoChangeStyle(true);
                    aVar2.bDc = (LinearLayout) inflate.findViewById(d.g.info);
                    aVar2.mName = (TextView) inflate.findViewById(d.g.name);
                    aVar2.fiK = (TextView) inflate.findViewById(d.g.at_list_nodata);
                    aVar2.bDb = (TextView) inflate.findViewById(d.g.intro);
                    aVar2.fYA = (ImageView) inflate.findViewById(d.g.chat);
                    aVar2.eAi = (ImageView) inflate.findViewById(d.g.diver_buttom_px);
                    aVar2.fYA.setOnClickListener(this.fji);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.fYx.getPageContext().getPageActivity()).inflate(d.h.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(d.g.pb_more_text);
                    inflate2.setOnClickListener(this.fiF);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(d.g.progress);
                    this.fYz.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.fiD) {
                    aVar.bDc.setVisibility(8);
                    aVar.fYA.setVisibility(8);
                    aVar.fiK.setVisibility(8);
                    aVar.eAi.setVisibility(8);
                } else {
                    if (!this.dPN && this.mPageType == 0) {
                        aVar.fYA.setVisibility(8);
                    } else {
                        aVar.fYA.setVisibility(0);
                    }
                    aVar.bDc.setVisibility(0);
                    aVar.bDc.setTag(Integer.valueOf(i));
                    aVar.eAi.setVisibility(0);
                    aVar.fiK.setVisibility(8);
                    String portrait = this.alt.get(i).getPortrait();
                    aVar.doZ.setImageDrawable(null);
                    aVar.doZ.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.alt.get(i).getName_show());
                    aVar.bDb.setText(this.alt.get(i).getIntro());
                    aVar.fYA.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.fYx.getPageContext().getString(d.j.loading));
                aVar.mProgress.setVisibility(0);
            }
            aI(view);
        }
        return view;
    }

    private void aI(View view) {
        this.fYx.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.fYx.getLayoutMode().onModeChanged(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fiD) {
            return 0;
        }
        return (this.alt == null || i >= this.alt.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fiD) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes3.dex */
    private class a {
        TextView bDb;
        LinearLayout bDc;
        HeadImageView doZ;
        ImageView eAi;
        ImageView fYA;
        TextView fiK;
        TextView mName;
        ProgressBar mProgress;

        private a() {
        }
    }
}
