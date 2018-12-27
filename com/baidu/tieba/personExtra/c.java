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
    private boolean epZ;
    private View.OnClickListener fIG;
    private View.OnClickListener fJj;
    private PersonFriendActivity gyv;
    private int mPageType;
    private ArrayList<UserData> mData = null;
    private boolean mHasMore = false;
    private boolean gyw = false;
    private boolean fIE = false;
    private ArrayList<ProgressBar> gyx = new ArrayList<>();

    public void bqt() {
        if (this.gyx != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.gyx.size()) {
                    try {
                        this.gyx.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.gyx.clear();
                    return;
                }
            }
        }
    }

    public void bdN() {
        this.fIE = false;
        if (this.mData != null && this.mData.size() == 0) {
            this.fIE = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void mi(boolean z) {
        this.gyw = z;
    }

    public c(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.gyv = null;
        this.epZ = true;
        this.mPageType = 0;
        this.fJj = null;
        this.fIG = null;
        this.gyv = personFriendActivity;
        this.epZ = z;
        this.mPageType = i;
        this.fJj = onClickListener;
        this.fIG = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.mData = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fIE) {
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
                    View inflate = LayoutInflater.from(this.gyv.getPageContext().getPageActivity()).inflate(e.h.person_list_item_friend, (ViewGroup) null);
                    aVar2.dNy = (HeadImageView) inflate.findViewById(e.g.photo);
                    aVar2.dNy.setIsRound(false);
                    aVar2.dNy.setAutoChangeStyle(true);
                    aVar2.bWb = (LinearLayout) inflate.findViewById(e.g.info);
                    aVar2.mName = (TextView) inflate.findViewById(e.g.name);
                    aVar2.fIL = (TextView) inflate.findViewById(e.g.at_list_nodata);
                    aVar2.bWa = (TextView) inflate.findViewById(e.g.intro);
                    aVar2.gyy = (ImageView) inflate.findViewById(e.g.chat);
                    aVar2.fad = (ImageView) inflate.findViewById(e.g.diver_buttom_px);
                    aVar2.gyy.setOnClickListener(this.fJj);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.gyv.getPageContext().getPageActivity()).inflate(e.h.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(e.g.pb_more_text);
                    inflate2.setOnClickListener(this.fIG);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(e.g.progress);
                    this.gyx.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.fIE) {
                    aVar.bWb.setVisibility(8);
                    aVar.gyy.setVisibility(8);
                    aVar.fIL.setVisibility(8);
                    aVar.fad.setVisibility(8);
                } else {
                    if (!this.epZ && this.mPageType == 0) {
                        aVar.gyy.setVisibility(8);
                    } else {
                        aVar.gyy.setVisibility(0);
                    }
                    aVar.bWb.setVisibility(0);
                    aVar.bWb.setTag(Integer.valueOf(i));
                    aVar.fad.setVisibility(0);
                    aVar.fIL.setVisibility(8);
                    String portrait = this.mData.get(i).getPortrait();
                    aVar.dNy.setImageDrawable(null);
                    aVar.dNy.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.mData.get(i).getName_show());
                    aVar.bWa.setText(this.mData.get(i).getIntro());
                    aVar.gyy.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.gyv.getPageContext().getString(e.j.loading));
                aVar.mProgress.setVisibility(0);
            }
            bb(view);
        }
        return view;
    }

    private void bb(View view) {
        this.gyv.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gyv.getLayoutMode().onModeChanged(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fIE) {
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
        if (this.fIE) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes3.dex */
    private class a {
        TextView bWa;
        LinearLayout bWb;
        HeadImageView dNy;
        TextView fIL;
        ImageView fad;
        ImageView gyy;
        TextView mName;
        ProgressBar mProgress;

        private a() {
        }
    }
}
