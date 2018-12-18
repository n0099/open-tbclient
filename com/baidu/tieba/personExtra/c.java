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
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c extends BaseAdapter {
    private boolean eni;
    private View.OnClickListener fFO;
    private View.OnClickListener fGr;
    private PersonFriendActivity gvE;
    private int mPageType;
    private ArrayList<UserData> mData = null;
    private boolean mHasMore = false;
    private boolean gvF = false;
    private boolean fFM = false;
    private ArrayList<ProgressBar> gvG = new ArrayList<>();

    public void bpH() {
        if (this.gvG != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.gvG.size()) {
                    try {
                        this.gvG.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.gvG.clear();
                    return;
                }
            }
        }
    }

    public void bcZ() {
        this.fFM = false;
        if (this.mData != null && this.mData.size() == 0) {
            this.fFM = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void mf(boolean z) {
        this.gvF = z;
    }

    public c(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.gvE = null;
        this.eni = true;
        this.mPageType = 0;
        this.fGr = null;
        this.fFO = null;
        this.gvE = personFriendActivity;
        this.eni = z;
        this.mPageType = i;
        this.fGr = onClickListener;
        this.fFO = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.mData = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fFM) {
            return 1;
        }
        int i = 0;
        if (this.mData != null) {
            i = this.mData.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mData == null || i >= this.mData.size()) {
            return null;
        }
        return this.mData.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.mData == null || i >= this.mData.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.mData != null) {
            if (view == null) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.gvE.getPageContext().getPageActivity()).inflate(e.h.person_list_item_friend, (ViewGroup) null);
                    aVar2.dKK = (HeadImageView) inflate.findViewById(e.g.photo);
                    aVar2.dKK.setIsRound(false);
                    aVar2.dKK.setAutoChangeStyle(true);
                    aVar2.bVY = (LinearLayout) inflate.findViewById(e.g.info);
                    aVar2.mName = (TextView) inflate.findViewById(e.g.name);
                    aVar2.fFT = (TextView) inflate.findViewById(e.g.at_list_nodata);
                    aVar2.bVX = (TextView) inflate.findViewById(e.g.intro);
                    aVar2.gvH = (ImageView) inflate.findViewById(e.g.chat);
                    aVar2.eXm = (ImageView) inflate.findViewById(e.g.diver_buttom_px);
                    aVar2.gvH.setOnClickListener(this.fGr);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.gvE.getPageContext().getPageActivity()).inflate(e.h.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(e.g.pb_more_text);
                    inflate2.setOnClickListener(this.fFO);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(e.g.progress);
                    this.gvG.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.fFM) {
                    aVar.bVY.setVisibility(8);
                    aVar.gvH.setVisibility(8);
                    aVar.fFT.setVisibility(8);
                    aVar.eXm.setVisibility(8);
                } else {
                    if (!this.eni && this.mPageType == 0) {
                        aVar.gvH.setVisibility(8);
                    } else {
                        aVar.gvH.setVisibility(0);
                    }
                    aVar.bVY.setVisibility(0);
                    aVar.bVY.setTag(Integer.valueOf(i));
                    aVar.eXm.setVisibility(0);
                    aVar.fFT.setVisibility(8);
                    String portrait = this.mData.get(i).getPortrait();
                    aVar.dKK.setImageDrawable(null);
                    aVar.dKK.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.mData.get(i).getName_show());
                    aVar.bVX.setText(this.mData.get(i).getIntro());
                    aVar.gvH.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.gvE.getPageContext().getString(e.j.loading));
                aVar.mProgress.setVisibility(0);
            }
            aY(view);
        }
        return view;
    }

    private void aY(View view) {
        this.gvE.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gvE.getLayoutMode().onModeChanged(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fFM) {
            return 0;
        }
        return (this.mData == null || i >= this.mData.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fFM) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes3.dex */
    private class a {
        TextView bVX;
        LinearLayout bVY;
        HeadImageView dKK;
        ImageView eXm;
        TextView fFT;
        ImageView gvH;
        TextView mName;
        ProgressBar mProgress;

        private a() {
        }
    }
}
