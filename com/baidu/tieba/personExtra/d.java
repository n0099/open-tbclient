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
/* loaded from: classes6.dex */
public class d extends BaseAdapter {
    private boolean fTR;
    private View.OnClickListener hqU;
    private View.OnClickListener hrx;
    private PersonFriendActivity ihK;
    private int mPageType;
    private ArrayList<UserData> aHF = null;
    private boolean mHasMore = false;
    private boolean ihL = false;
    private boolean hqS = false;
    private ArrayList<ProgressBar> ihM = new ArrayList<>();

    public void bZE() {
        if (this.ihM != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.ihM.size()) {
                    try {
                        this.ihM.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.ihM.clear();
                    return;
                }
            }
        }
    }

    public void bMB() {
        this.hqS = false;
        if (this.aHF != null && this.aHF.size() == 0) {
            this.hqS = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void pu(boolean z) {
        this.ihL = z;
    }

    public d(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.ihK = null;
        this.fTR = true;
        this.mPageType = 0;
        this.hrx = null;
        this.hqU = null;
        this.ihK = personFriendActivity;
        this.fTR = z;
        this.mPageType = i;
        this.hrx = onClickListener;
        this.hqU = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.aHF = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hqS) {
            return 1;
        }
        int i = 0;
        if (this.aHF != null) {
            i = this.aHF.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aHF == null || i >= this.aHF.size()) {
            return null;
        }
        return this.aHF.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.aHF == null || i >= this.aHF.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.aHF != null) {
            if (view == null) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.ihK.getPageContext().getPageActivity()).inflate(R.layout.person_list_item_friend, (ViewGroup) null);
                    aVar2.frV = (HeadImageView) inflate.findViewById(R.id.photo);
                    aVar2.frV.setIsRound(false);
                    aVar2.frV.setAutoChangeStyle(true);
                    aVar2.dww = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.hqZ = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.dwv = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.ihN = (ImageView) inflate.findViewById(R.id.chat);
                    aVar2.gHZ = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    aVar2.ihN.setOnClickListener(this.hrx);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.ihK.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(R.id.pb_more_text);
                    inflate2.setOnClickListener(this.hqU);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(R.id.progress);
                    this.ihM.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.hqS) {
                    aVar.dww.setVisibility(8);
                    aVar.ihN.setVisibility(8);
                    aVar.hqZ.setVisibility(8);
                    aVar.gHZ.setVisibility(8);
                } else {
                    if (!this.fTR && this.mPageType == 0) {
                        aVar.ihN.setVisibility(8);
                    } else {
                        aVar.ihN.setVisibility(0);
                    }
                    aVar.dww.setVisibility(0);
                    aVar.dww.setTag(Integer.valueOf(i));
                    aVar.gHZ.setVisibility(0);
                    aVar.hqZ.setVisibility(8);
                    String portrait = this.aHF.get(i).getPortrait();
                    aVar.frV.setImageDrawable(null);
                    aVar.frV.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.aHF.get(i).getName_show());
                    aVar.dwv.setText(this.aHF.get(i).getIntro());
                    aVar.ihN.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.ihK.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            bX(view);
        }
        return view;
    }

    private void bX(View view) {
        this.ihK.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.ihK.getLayoutMode().onModeChanged(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.hqS) {
            return 0;
        }
        return (this.aHF == null || i >= this.aHF.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.hqS) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes6.dex */
    private class a {
        TextView dwv;
        LinearLayout dww;
        HeadImageView frV;
        ImageView gHZ;
        TextView hqZ;
        ImageView ihN;
        TextView mName;
        ProgressBar mProgress;

        private a() {
        }
    }
}
