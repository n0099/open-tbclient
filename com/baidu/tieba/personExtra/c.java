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
    private boolean eeU;
    private View.OnClickListener fxA;
    private View.OnClickListener fyd;
    private PersonFriendActivity gno;
    private int mPageType;
    private ArrayList<UserData> mData = null;
    private boolean mHasMore = false;
    private boolean gnp = false;
    private boolean fxy = false;
    private ArrayList<ProgressBar> gnq = new ArrayList<>();

    public void bou() {
        if (this.gnq != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.gnq.size()) {
                    try {
                        this.gnq.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.gnq.clear();
                    return;
                }
            }
        }
    }

    public void bbK() {
        this.fxy = false;
        if (this.mData != null && this.mData.size() == 0) {
            this.fxy = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void lR(boolean z) {
        this.gnp = z;
    }

    public c(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.gno = null;
        this.eeU = true;
        this.mPageType = 0;
        this.fyd = null;
        this.fxA = null;
        this.gno = personFriendActivity;
        this.eeU = z;
        this.mPageType = i;
        this.fyd = onClickListener;
        this.fxA = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.mData = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fxy) {
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
                    View inflate = LayoutInflater.from(this.gno.getPageContext().getPageActivity()).inflate(e.h.person_list_item_friend, (ViewGroup) null);
                    aVar2.dCV = (HeadImageView) inflate.findViewById(e.g.photo);
                    aVar2.dCV.setIsRound(false);
                    aVar2.dCV.setAutoChangeStyle(true);
                    aVar2.bRv = (LinearLayout) inflate.findViewById(e.g.info);
                    aVar2.mName = (TextView) inflate.findViewById(e.g.name);
                    aVar2.fxF = (TextView) inflate.findViewById(e.g.at_list_nodata);
                    aVar2.bRu = (TextView) inflate.findViewById(e.g.intro);
                    aVar2.gnr = (ImageView) inflate.findViewById(e.g.chat);
                    aVar2.ePe = (ImageView) inflate.findViewById(e.g.diver_buttom_px);
                    aVar2.gnr.setOnClickListener(this.fyd);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.gno.getPageContext().getPageActivity()).inflate(e.h.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(e.g.pb_more_text);
                    inflate2.setOnClickListener(this.fxA);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(e.g.progress);
                    this.gnq.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.fxy) {
                    aVar.bRv.setVisibility(8);
                    aVar.gnr.setVisibility(8);
                    aVar.fxF.setVisibility(8);
                    aVar.ePe.setVisibility(8);
                } else {
                    if (!this.eeU && this.mPageType == 0) {
                        aVar.gnr.setVisibility(8);
                    } else {
                        aVar.gnr.setVisibility(0);
                    }
                    aVar.bRv.setVisibility(0);
                    aVar.bRv.setTag(Integer.valueOf(i));
                    aVar.ePe.setVisibility(0);
                    aVar.fxF.setVisibility(8);
                    String portrait = this.mData.get(i).getPortrait();
                    aVar.dCV.setImageDrawable(null);
                    aVar.dCV.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.mData.get(i).getName_show());
                    aVar.bRu.setText(this.mData.get(i).getIntro());
                    aVar.gnr.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.gno.getPageContext().getString(e.j.loading));
                aVar.mProgress.setVisibility(0);
            }
            aW(view);
        }
        return view;
    }

    private void aW(View view) {
        this.gno.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gno.getLayoutMode().onModeChanged(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fxy) {
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
        if (this.fxy) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes3.dex */
    private class a {
        TextView bRu;
        LinearLayout bRv;
        HeadImageView dCV;
        ImageView ePe;
        TextView fxF;
        ImageView gnr;
        TextView mName;
        ProgressBar mProgress;

        private a() {
        }
    }
}
