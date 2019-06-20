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
    private boolean fTT;
    private View.OnClickListener hqV;
    private View.OnClickListener hry;
    private PersonFriendActivity ihL;
    private int mPageType;
    private ArrayList<UserData> aHF = null;
    private boolean mHasMore = false;
    private boolean ihM = false;
    private boolean hqT = false;
    private ArrayList<ProgressBar> ihN = new ArrayList<>();

    public void bZF() {
        if (this.ihN != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.ihN.size()) {
                    try {
                        this.ihN.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.ihN.clear();
                    return;
                }
            }
        }
    }

    public void bMC() {
        this.hqT = false;
        if (this.aHF != null && this.aHF.size() == 0) {
            this.hqT = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void pv(boolean z) {
        this.ihM = z;
    }

    public d(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.ihL = null;
        this.fTT = true;
        this.mPageType = 0;
        this.hry = null;
        this.hqV = null;
        this.ihL = personFriendActivity;
        this.fTT = z;
        this.mPageType = i;
        this.hry = onClickListener;
        this.hqV = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.aHF = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hqT) {
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
                    View inflate = LayoutInflater.from(this.ihL.getPageContext().getPageActivity()).inflate(R.layout.person_list_item_friend, (ViewGroup) null);
                    aVar2.frV = (HeadImageView) inflate.findViewById(R.id.photo);
                    aVar2.frV.setIsRound(false);
                    aVar2.frV.setAutoChangeStyle(true);
                    aVar2.dww = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.hra = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.dwv = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.ihO = (ImageView) inflate.findViewById(R.id.chat);
                    aVar2.gIb = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    aVar2.ihO.setOnClickListener(this.hry);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.ihL.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(R.id.pb_more_text);
                    inflate2.setOnClickListener(this.hqV);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(R.id.progress);
                    this.ihN.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.hqT) {
                    aVar.dww.setVisibility(8);
                    aVar.ihO.setVisibility(8);
                    aVar.hra.setVisibility(8);
                    aVar.gIb.setVisibility(8);
                } else {
                    if (!this.fTT && this.mPageType == 0) {
                        aVar.ihO.setVisibility(8);
                    } else {
                        aVar.ihO.setVisibility(0);
                    }
                    aVar.dww.setVisibility(0);
                    aVar.dww.setTag(Integer.valueOf(i));
                    aVar.gIb.setVisibility(0);
                    aVar.hra.setVisibility(8);
                    String portrait = this.aHF.get(i).getPortrait();
                    aVar.frV.setImageDrawable(null);
                    aVar.frV.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.aHF.get(i).getName_show());
                    aVar.dwv.setText(this.aHF.get(i).getIntro());
                    aVar.ihO.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.ihL.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            bX(view);
        }
        return view;
    }

    private void bX(View view) {
        this.ihL.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.ihL.getLayoutMode().onModeChanged(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.hqT) {
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
        if (this.hqT) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes6.dex */
    private class a {
        TextView dwv;
        LinearLayout dww;
        HeadImageView frV;
        ImageView gIb;
        TextView hra;
        ImageView ihO;
        TextView mName;
        ProgressBar mProgress;

        private a() {
        }
    }
}
