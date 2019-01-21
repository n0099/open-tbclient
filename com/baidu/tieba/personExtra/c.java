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
    private boolean eqG;
    private View.OnClickListener fJB;
    private View.OnClickListener fKe;
    private PersonFriendActivity gzA;
    private int mPageType;
    private ArrayList<UserData> mData = null;
    private boolean mHasMore = false;
    private boolean gzB = false;
    private boolean fJz = false;
    private ArrayList<ProgressBar> gzC = new ArrayList<>();

    public void brc() {
        if (this.gzC != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.gzC.size()) {
                    try {
                        this.gzC.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.gzC.clear();
                    return;
                }
            }
        }
    }

    public void ben() {
        this.fJz = false;
        if (this.mData != null && this.mData.size() == 0) {
            this.fJz = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void mi(boolean z) {
        this.gzB = z;
    }

    public c(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.gzA = null;
        this.eqG = true;
        this.mPageType = 0;
        this.fKe = null;
        this.fJB = null;
        this.gzA = personFriendActivity;
        this.eqG = z;
        this.mPageType = i;
        this.fKe = onClickListener;
        this.fJB = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.mData = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fJz) {
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
                    View inflate = LayoutInflater.from(this.gzA.getPageContext().getPageActivity()).inflate(e.h.person_list_item_friend, (ViewGroup) null);
                    aVar2.dOi = (HeadImageView) inflate.findViewById(e.g.photo);
                    aVar2.dOi.setIsRound(false);
                    aVar2.dOi.setAutoChangeStyle(true);
                    aVar2.bWN = (LinearLayout) inflate.findViewById(e.g.info);
                    aVar2.mName = (TextView) inflate.findViewById(e.g.name);
                    aVar2.fJG = (TextView) inflate.findViewById(e.g.at_list_nodata);
                    aVar2.bWM = (TextView) inflate.findViewById(e.g.intro);
                    aVar2.gzD = (ImageView) inflate.findViewById(e.g.chat);
                    aVar2.faR = (ImageView) inflate.findViewById(e.g.diver_buttom_px);
                    aVar2.gzD.setOnClickListener(this.fKe);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.gzA.getPageContext().getPageActivity()).inflate(e.h.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(e.g.pb_more_text);
                    inflate2.setOnClickListener(this.fJB);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(e.g.progress);
                    this.gzC.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.fJz) {
                    aVar.bWN.setVisibility(8);
                    aVar.gzD.setVisibility(8);
                    aVar.fJG.setVisibility(8);
                    aVar.faR.setVisibility(8);
                } else {
                    if (!this.eqG && this.mPageType == 0) {
                        aVar.gzD.setVisibility(8);
                    } else {
                        aVar.gzD.setVisibility(0);
                    }
                    aVar.bWN.setVisibility(0);
                    aVar.bWN.setTag(Integer.valueOf(i));
                    aVar.faR.setVisibility(0);
                    aVar.fJG.setVisibility(8);
                    String portrait = this.mData.get(i).getPortrait();
                    aVar.dOi.setImageDrawable(null);
                    aVar.dOi.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.mData.get(i).getName_show());
                    aVar.bWM.setText(this.mData.get(i).getIntro());
                    aVar.gzD.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.gzA.getPageContext().getString(e.j.loading));
                aVar.mProgress.setVisibility(0);
            }
            bb(view);
        }
        return view;
    }

    private void bb(View view) {
        this.gzA.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gzA.getLayoutMode().onModeChanged(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fJz) {
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
        if (this.fJz) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes3.dex */
    private class a {
        TextView bWM;
        LinearLayout bWN;
        HeadImageView dOi;
        TextView fJG;
        ImageView faR;
        ImageView gzD;
        TextView mName;
        ProgressBar mProgress;

        private a() {
        }
    }
}
