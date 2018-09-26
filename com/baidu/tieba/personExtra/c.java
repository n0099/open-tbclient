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
    private boolean dXb;
    private View.OnClickListener fpV;
    private View.OnClickListener fqy;
    private PersonFriendActivity gfN;
    private int mPageType;
    private ArrayList<UserData> anX = null;
    private boolean mHasMore = false;
    private boolean gfO = false;
    private boolean fpT = false;
    private ArrayList<ProgressBar> gfP = new ArrayList<>();

    public void blj() {
        if (this.gfP != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.gfP.size()) {
                    try {
                        this.gfP.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.gfP.clear();
                    return;
                }
            }
        }
    }

    public void aYy() {
        this.fpT = false;
        if (this.anX != null && this.anX.size() == 0) {
            this.fpT = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void lA(boolean z) {
        this.gfO = z;
    }

    public c(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.gfN = null;
        this.dXb = true;
        this.mPageType = 0;
        this.fqy = null;
        this.fpV = null;
        this.gfN = personFriendActivity;
        this.dXb = z;
        this.mPageType = i;
        this.fqy = onClickListener;
        this.fpV = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.anX = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fpT) {
            return 1;
        }
        int i = 0;
        if (this.anX != null) {
            i = this.anX.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.anX == null || i >= this.anX.size()) {
            return null;
        }
        return this.anX.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.anX == null || i >= this.anX.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.anX != null) {
            if (view == null) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.gfN.getPageContext().getPageActivity()).inflate(e.h.person_list_item_friend, (ViewGroup) null);
                    aVar2.duU = (HeadImageView) inflate.findViewById(e.g.photo);
                    aVar2.duU.setIsRound(false);
                    aVar2.duU.setAutoChangeStyle(true);
                    aVar2.bIS = (LinearLayout) inflate.findViewById(e.g.info);
                    aVar2.mName = (TextView) inflate.findViewById(e.g.name);
                    aVar2.fqa = (TextView) inflate.findViewById(e.g.at_list_nodata);
                    aVar2.bIR = (TextView) inflate.findViewById(e.g.intro);
                    aVar2.gfQ = (ImageView) inflate.findViewById(e.g.chat);
                    aVar2.eHv = (ImageView) inflate.findViewById(e.g.diver_buttom_px);
                    aVar2.gfQ.setOnClickListener(this.fqy);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.gfN.getPageContext().getPageActivity()).inflate(e.h.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(e.g.pb_more_text);
                    inflate2.setOnClickListener(this.fpV);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(e.g.progress);
                    this.gfP.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.fpT) {
                    aVar.bIS.setVisibility(8);
                    aVar.gfQ.setVisibility(8);
                    aVar.fqa.setVisibility(8);
                    aVar.eHv.setVisibility(8);
                } else {
                    if (!this.dXb && this.mPageType == 0) {
                        aVar.gfQ.setVisibility(8);
                    } else {
                        aVar.gfQ.setVisibility(0);
                    }
                    aVar.bIS.setVisibility(0);
                    aVar.bIS.setTag(Integer.valueOf(i));
                    aVar.eHv.setVisibility(0);
                    aVar.fqa.setVisibility(8);
                    String portrait = this.anX.get(i).getPortrait();
                    aVar.duU.setImageDrawable(null);
                    aVar.duU.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.anX.get(i).getName_show());
                    aVar.bIR.setText(this.anX.get(i).getIntro());
                    aVar.gfQ.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.gfN.getPageContext().getString(e.j.loading));
                aVar.mProgress.setVisibility(0);
            }
            aW(view);
        }
        return view;
    }

    private void aW(View view) {
        this.gfN.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gfN.getLayoutMode().onModeChanged(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fpT) {
            return 0;
        }
        return (this.anX == null || i >= this.anX.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fpT) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes3.dex */
    private class a {
        TextView bIR;
        LinearLayout bIS;
        HeadImageView duU;
        ImageView eHv;
        TextView fqa;
        ImageView gfQ;
        TextView mName;
        ProgressBar mProgress;

        private a() {
        }
    }
}
