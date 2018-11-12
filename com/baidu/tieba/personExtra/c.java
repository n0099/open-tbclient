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
    private boolean egp;
    private View.OnClickListener fyY;
    private View.OnClickListener fzB;
    private PersonFriendActivity goO;
    private int mPageType;
    private ArrayList<UserData> mData = null;
    private boolean mHasMore = false;
    private boolean goP = false;
    private boolean fyW = false;
    private ArrayList<ProgressBar> goQ = new ArrayList<>();

    public void bnP() {
        if (this.goQ != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.goQ.size()) {
                    try {
                        this.goQ.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.goQ.clear();
                    return;
                }
            }
        }
    }

    public void bbj() {
        this.fyW = false;
        if (this.mData != null && this.mData.size() == 0) {
            this.fyW = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void mc(boolean z) {
        this.goP = z;
    }

    public c(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.goO = null;
        this.egp = true;
        this.mPageType = 0;
        this.fzB = null;
        this.fyY = null;
        this.goO = personFriendActivity;
        this.egp = z;
        this.mPageType = i;
        this.fzB = onClickListener;
        this.fyY = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.mData = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fyW) {
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
                    View inflate = LayoutInflater.from(this.goO.getPageContext().getPageActivity()).inflate(e.h.person_list_item_friend, (ViewGroup) null);
                    aVar2.dEl = (HeadImageView) inflate.findViewById(e.g.photo);
                    aVar2.dEl.setIsRound(false);
                    aVar2.dEl.setAutoChangeStyle(true);
                    aVar2.bSh = (LinearLayout) inflate.findViewById(e.g.info);
                    aVar2.mName = (TextView) inflate.findViewById(e.g.name);
                    aVar2.fzd = (TextView) inflate.findViewById(e.g.at_list_nodata);
                    aVar2.bSg = (TextView) inflate.findViewById(e.g.intro);
                    aVar2.goR = (ImageView) inflate.findViewById(e.g.chat);
                    aVar2.eQx = (ImageView) inflate.findViewById(e.g.diver_buttom_px);
                    aVar2.goR.setOnClickListener(this.fzB);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.goO.getPageContext().getPageActivity()).inflate(e.h.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(e.g.pb_more_text);
                    inflate2.setOnClickListener(this.fyY);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(e.g.progress);
                    this.goQ.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.fyW) {
                    aVar.bSh.setVisibility(8);
                    aVar.goR.setVisibility(8);
                    aVar.fzd.setVisibility(8);
                    aVar.eQx.setVisibility(8);
                } else {
                    if (!this.egp && this.mPageType == 0) {
                        aVar.goR.setVisibility(8);
                    } else {
                        aVar.goR.setVisibility(0);
                    }
                    aVar.bSh.setVisibility(0);
                    aVar.bSh.setTag(Integer.valueOf(i));
                    aVar.eQx.setVisibility(0);
                    aVar.fzd.setVisibility(8);
                    String portrait = this.mData.get(i).getPortrait();
                    aVar.dEl.setImageDrawable(null);
                    aVar.dEl.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.mData.get(i).getName_show());
                    aVar.bSg.setText(this.mData.get(i).getIntro());
                    aVar.goR.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.goO.getPageContext().getString(e.j.loading));
                aVar.mProgress.setVisibility(0);
            }
            aY(view);
        }
        return view;
    }

    private void aY(View view) {
        this.goO.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.goO.getLayoutMode().onModeChanged(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fyW) {
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
        if (this.fyW) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes3.dex */
    private class a {
        TextView bSg;
        LinearLayout bSh;
        HeadImageView dEl;
        ImageView eQx;
        TextView fzd;
        ImageView goR;
        TextView mName;
        ProgressBar mProgress;

        private a() {
        }
    }
}
