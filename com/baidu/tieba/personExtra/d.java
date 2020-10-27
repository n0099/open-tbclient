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
    private boolean gKL;
    private View.OnClickListener kSX;
    private View.OnClickListener kTD;
    private PersonFriendActivity lUo;
    private int mPageType;
    private ArrayList<UserData> eCX = null;
    private boolean mHasMore = false;
    private boolean lUp = false;
    private boolean gKJ = false;
    private ArrayList<ProgressBar> lUq = new ArrayList<>();

    public void dsv() {
        if (this.lUq != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.lUq.size()) {
                    try {
                        this.lUq.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.lUq.clear();
                    return;
                }
            }
        }
    }

    public void bTb() {
        this.gKJ = false;
        if (this.eCX != null && this.eCX.size() == 0) {
            this.gKJ = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void vI(boolean z) {
        this.lUp = z;
    }

    public d(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.lUo = null;
        this.gKL = true;
        this.mPageType = 0;
        this.kTD = null;
        this.kSX = null;
        this.lUo = personFriendActivity;
        this.gKL = z;
        this.mPageType = i;
        this.kTD = onClickListener;
        this.kSX = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.eCX = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gKJ) {
            return 1;
        }
        int i = 0;
        if (this.eCX != null) {
            i = this.eCX.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eCX == null || i >= this.eCX.size()) {
            return null;
        }
        return this.eCX.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.eCX == null || i >= this.eCX.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.eCX != null) {
            if (view == null) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.lUo.getPageContext().getPageActivity()).inflate(R.layout.person_list_item_friend, (ViewGroup) null);
                    aVar2.iEX = (HeadImageView) inflate.findViewById(R.id.photo);
                    aVar2.iEX.setIsRound(false);
                    aVar2.iEX.setAutoChangeStyle(true);
                    aVar2.gLO = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.gKN = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.grt = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.lUr = (ImageView) inflate.findViewById(R.id.chat);
                    aVar2.kht = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    aVar2.lUr.setOnClickListener(this.kTD);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.lUo.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(R.id.pb_more_text);
                    inflate2.setOnClickListener(this.kSX);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(R.id.progress);
                    this.lUq.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.gKJ) {
                    aVar.gLO.setVisibility(8);
                    aVar.lUr.setVisibility(8);
                    aVar.gKN.setVisibility(8);
                    aVar.kht.setVisibility(8);
                } else {
                    if (!this.gKL && this.mPageType == 0) {
                        aVar.lUr.setVisibility(8);
                    } else {
                        aVar.lUr.setVisibility(0);
                    }
                    aVar.gLO.setVisibility(0);
                    aVar.gLO.setTag(Integer.valueOf(i));
                    aVar.kht.setVisibility(0);
                    aVar.gKN.setVisibility(8);
                    String portrait = this.eCX.get(i).getPortrait();
                    aVar.iEX.setImageDrawable(null);
                    aVar.iEX.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.eCX.get(i).getName_show());
                    aVar.grt.setText(this.eCX.get(i).getIntro());
                    aVar.lUr.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.lUo.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            cF(view);
        }
        return view;
    }

    private void cF(View view) {
        this.lUo.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.lUo.getLayoutMode().onModeChanged(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.gKJ) {
            return 0;
        }
        return (this.eCX == null || i >= this.eCX.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.gKJ) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes24.dex */
    private class a {
        TextView gKN;
        LinearLayout gLO;
        TextView grt;
        HeadImageView iEX;
        ImageView kht;
        ImageView lUr;
        TextView mName;
        ProgressBar mProgress;

        private a() {
        }
    }
}
