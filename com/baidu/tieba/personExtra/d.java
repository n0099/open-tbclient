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
    private boolean fTQ;
    private View.OnClickListener hqR;
    private View.OnClickListener hru;
    private PersonFriendActivity ihH;
    private int mPageType;
    private ArrayList<UserData> aHF = null;
    private boolean mHasMore = false;
    private boolean ihI = false;
    private boolean hqP = false;
    private ArrayList<ProgressBar> ihJ = new ArrayList<>();

    public void bZB() {
        if (this.ihJ != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.ihJ.size()) {
                    try {
                        this.ihJ.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.ihJ.clear();
                    return;
                }
            }
        }
    }

    public void bMy() {
        this.hqP = false;
        if (this.aHF != null && this.aHF.size() == 0) {
            this.hqP = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void pu(boolean z) {
        this.ihI = z;
    }

    public d(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.ihH = null;
        this.fTQ = true;
        this.mPageType = 0;
        this.hru = null;
        this.hqR = null;
        this.ihH = personFriendActivity;
        this.fTQ = z;
        this.mPageType = i;
        this.hru = onClickListener;
        this.hqR = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.aHF = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hqP) {
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
                    View inflate = LayoutInflater.from(this.ihH.getPageContext().getPageActivity()).inflate(R.layout.person_list_item_friend, (ViewGroup) null);
                    aVar2.frU = (HeadImageView) inflate.findViewById(R.id.photo);
                    aVar2.frU.setIsRound(false);
                    aVar2.frU.setAutoChangeStyle(true);
                    aVar2.dwv = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.hqW = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.dwu = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.ihK = (ImageView) inflate.findViewById(R.id.chat);
                    aVar2.gHY = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    aVar2.ihK.setOnClickListener(this.hru);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.ihH.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(R.id.pb_more_text);
                    inflate2.setOnClickListener(this.hqR);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(R.id.progress);
                    this.ihJ.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.hqP) {
                    aVar.dwv.setVisibility(8);
                    aVar.ihK.setVisibility(8);
                    aVar.hqW.setVisibility(8);
                    aVar.gHY.setVisibility(8);
                } else {
                    if (!this.fTQ && this.mPageType == 0) {
                        aVar.ihK.setVisibility(8);
                    } else {
                        aVar.ihK.setVisibility(0);
                    }
                    aVar.dwv.setVisibility(0);
                    aVar.dwv.setTag(Integer.valueOf(i));
                    aVar.gHY.setVisibility(0);
                    aVar.hqW.setVisibility(8);
                    String portrait = this.aHF.get(i).getPortrait();
                    aVar.frU.setImageDrawable(null);
                    aVar.frU.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.aHF.get(i).getName_show());
                    aVar.dwu.setText(this.aHF.get(i).getIntro());
                    aVar.ihK.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.ihH.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            bX(view);
        }
        return view;
    }

    private void bX(View view) {
        this.ihH.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.ihH.getLayoutMode().onModeChanged(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.hqP) {
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
        if (this.hqP) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes6.dex */
    private class a {
        TextView dwu;
        LinearLayout dwv;
        HeadImageView frU;
        ImageView gHY;
        TextView hqW;
        ImageView ihK;
        TextView mName;
        ProgressBar mProgress;

        private a() {
        }
    }
}
