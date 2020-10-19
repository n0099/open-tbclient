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
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes24.dex */
public class d extends BaseAdapter {
    private boolean gyX;
    private View.OnClickListener kGA;
    private View.OnClickListener kHg;
    private PersonFriendActivity lHS;
    private int mPageType;
    private ArrayList<UserData> euy = null;
    private boolean mHasMore = false;
    private boolean lHT = false;
    private boolean gyV = false;
    private ArrayList<ProgressBar> lHU = new ArrayList<>();

    public void dpo() {
        if (this.lHU != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.lHU.size()) {
                    try {
                        this.lHU.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.lHU.clear();
                    return;
                }
            }
        }
    }

    public void bQe() {
        this.gyV = false;
        if (this.euy != null && this.euy.size() == 0) {
            this.gyV = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void vr(boolean z) {
        this.lHT = z;
    }

    public d(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.lHS = null;
        this.gyX = true;
        this.mPageType = 0;
        this.kHg = null;
        this.kGA = null;
        this.lHS = personFriendActivity;
        this.gyX = z;
        this.mPageType = i;
        this.kHg = onClickListener;
        this.kGA = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.euy = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gyV) {
            return 1;
        }
        int i = 0;
        if (this.euy != null) {
            i = this.euy.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.euy == null || i >= this.euy.size()) {
            return null;
        }
        return this.euy.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.euy == null || i >= this.euy.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.euy != null) {
            if (view == null) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.lHS.getPageContext().getPageActivity()).inflate(R.layout.person_list_item_friend, (ViewGroup) null);
                    aVar2.isB = (HeadImageView) inflate.findViewById(R.id.photo);
                    aVar2.isB.setIsRound(false);
                    aVar2.isB.setAutoChangeStyle(true);
                    aVar2.gAa = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.gyZ = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.ghq = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.lHV = (ImageView) inflate.findViewById(R.id.chat);
                    aVar2.jUT = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    aVar2.lHV.setOnClickListener(this.kHg);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.lHS.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(R.id.pb_more_text);
                    inflate2.setOnClickListener(this.kGA);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(R.id.progress);
                    this.lHU.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.gyV) {
                    aVar.gAa.setVisibility(8);
                    aVar.lHV.setVisibility(8);
                    aVar.gyZ.setVisibility(8);
                    aVar.jUT.setVisibility(8);
                } else {
                    if (!this.gyX && this.mPageType == 0) {
                        aVar.lHV.setVisibility(8);
                    } else {
                        aVar.lHV.setVisibility(0);
                    }
                    aVar.gAa.setVisibility(0);
                    aVar.gAa.setTag(Integer.valueOf(i));
                    aVar.jUT.setVisibility(0);
                    aVar.gyZ.setVisibility(8);
                    String portrait = this.euy.get(i).getPortrait();
                    aVar.isB.setImageDrawable(null);
                    aVar.isB.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.euy.get(i).getName_show());
                    aVar.ghq.setText(this.euy.get(i).getIntro());
                    aVar.lHV.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.lHS.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            cB(view);
        }
        return view;
    }

    private void cB(View view) {
        this.lHS.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.lHS.getLayoutMode().onModeChanged(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.gyV) {
            return 0;
        }
        return (this.euy == null || i >= this.euy.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.gyV) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes24.dex */
    private class a {
        LinearLayout gAa;
        TextView ghq;
        TextView gyZ;
        HeadImageView isB;
        ImageView jUT;
        ImageView lHV;
        TextView mName;
        ProgressBar mProgress;

        private a() {
        }
    }
}
