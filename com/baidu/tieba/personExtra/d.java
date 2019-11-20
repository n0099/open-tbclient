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
    private boolean dQT;
    private View.OnClickListener hxR;
    private View.OnClickListener hyt;
    private PersonFriendActivity ioP;
    private int mPageType;
    private ArrayList<UserData> bbH = null;
    private boolean mHasMore = false;
    private boolean ioQ = false;
    private boolean dQR = false;
    private ArrayList<ProgressBar> ioR = new ArrayList<>();

    public void caz() {
        if (this.ioR != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.ioR.size()) {
                    try {
                        this.ioR.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.ioR.clear();
                    return;
                }
            }
        }
    }

    public void aMx() {
        this.dQR = false;
        if (this.bbH != null && this.bbH.size() == 0) {
            this.dQR = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void pv(boolean z) {
        this.ioQ = z;
    }

    public d(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.ioP = null;
        this.dQT = true;
        this.mPageType = 0;
        this.hyt = null;
        this.hxR = null;
        this.ioP = personFriendActivity;
        this.dQT = z;
        this.mPageType = i;
        this.hyt = onClickListener;
        this.hxR = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.bbH = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dQR) {
            return 1;
        }
        int i = 0;
        if (this.bbH != null) {
            i = this.bbH.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bbH == null || i >= this.bbH.size()) {
            return null;
        }
        return this.bbH.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.bbH == null || i >= this.bbH.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.bbH != null) {
            if (view == null) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.ioP.getPageContext().getPageActivity()).inflate(R.layout.person_list_item_friend, (ViewGroup) null);
                    aVar2.fxA = (HeadImageView) inflate.findViewById(R.id.photo);
                    aVar2.fxA.setIsRound(false);
                    aVar2.fxA.setAutoChangeStyle(true);
                    aVar2.dRX = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.dQV = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.dFN = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.ioS = (ImageView) inflate.findViewById(R.id.chat);
                    aVar2.gOh = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    aVar2.ioS.setOnClickListener(this.hyt);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.ioP.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(R.id.pb_more_text);
                    inflate2.setOnClickListener(this.hxR);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(R.id.progress);
                    this.ioR.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.dQR) {
                    aVar.dRX.setVisibility(8);
                    aVar.ioS.setVisibility(8);
                    aVar.dQV.setVisibility(8);
                    aVar.gOh.setVisibility(8);
                } else {
                    if (!this.dQT && this.mPageType == 0) {
                        aVar.ioS.setVisibility(8);
                    } else {
                        aVar.ioS.setVisibility(0);
                    }
                    aVar.dRX.setVisibility(0);
                    aVar.dRX.setTag(Integer.valueOf(i));
                    aVar.gOh.setVisibility(0);
                    aVar.dQV.setVisibility(8);
                    String portrait = this.bbH.get(i).getPortrait();
                    aVar.fxA.setImageDrawable(null);
                    aVar.fxA.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.bbH.get(i).getName_show());
                    aVar.dFN.setText(this.bbH.get(i).getIntro());
                    aVar.ioS.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.ioP.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            bX(view);
        }
        return view;
    }

    private void bX(View view) {
        this.ioP.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.ioP.getLayoutMode().onModeChanged(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.dQR) {
            return 0;
        }
        return (this.bbH == null || i >= this.bbH.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.dQR) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes6.dex */
    private class a {
        TextView dFN;
        TextView dQV;
        LinearLayout dRX;
        HeadImageView fxA;
        ImageView gOh;
        ImageView ioS;
        TextView mName;
        ProgressBar mProgress;

        private a() {
        }
    }
}
