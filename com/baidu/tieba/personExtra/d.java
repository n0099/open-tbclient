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
/* loaded from: classes8.dex */
public class d extends BaseAdapter {
    private boolean hkR;
    private View.OnClickListener lvy;
    private View.OnClickListener lwf;
    private int mPageType;
    private PersonFriendActivity myt;
    private ArrayList<UserData> eVV = null;
    private boolean mHasMore = false;
    private boolean myu = false;
    private boolean hkP = false;
    private ArrayList<ProgressBar> myv = new ArrayList<>();

    public void dxX() {
        if (this.myv != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.myv.size()) {
                    try {
                        this.myv.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.myv.clear();
                    return;
                }
            }
        }
    }

    public void bYr() {
        this.hkP = false;
        if (this.eVV != null && this.eVV.size() == 0) {
            this.hkP = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void wM(boolean z) {
        this.myu = z;
    }

    public d(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.myt = null;
        this.hkR = true;
        this.mPageType = 0;
        this.lwf = null;
        this.lvy = null;
        this.myt = personFriendActivity;
        this.hkR = z;
        this.mPageType = i;
        this.lwf = onClickListener;
        this.lvy = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.eVV = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hkP) {
            return 1;
        }
        int i = 0;
        if (this.eVV != null) {
            i = this.eVV.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eVV == null || i >= this.eVV.size()) {
            return null;
        }
        return this.eVV.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.eVV == null || i >= this.eVV.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.eVV != null) {
            if (view == null) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.myt.getPageContext().getPageActivity()).inflate(R.layout.person_list_item_friend, (ViewGroup) null);
                    aVar2.kAb = (HeadImageView) inflate.findViewById(R.id.photo);
                    aVar2.kAb.setIsRound(false);
                    aVar2.kAb.setAutoChangeStyle(true);
                    aVar2.hlT = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.hkT = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.gPm = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.myw = (ImageView) inflate.findViewById(R.id.chat);
                    aVar2.kKq = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    aVar2.myw.setOnClickListener(this.lwf);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.myt.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(R.id.pb_more_text);
                    inflate2.setOnClickListener(this.lvy);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(R.id.progress);
                    this.myv.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.hkP) {
                    aVar.hlT.setVisibility(8);
                    aVar.myw.setVisibility(8);
                    aVar.hkT.setVisibility(8);
                    aVar.kKq.setVisibility(8);
                } else {
                    if (!this.hkR && this.mPageType == 0) {
                        aVar.myw.setVisibility(8);
                    } else {
                        aVar.myw.setVisibility(0);
                    }
                    aVar.hlT.setVisibility(0);
                    aVar.hlT.setTag(Integer.valueOf(i));
                    aVar.kKq.setVisibility(0);
                    aVar.hkT.setVisibility(8);
                    String portrait = this.eVV.get(i).getPortrait();
                    aVar.kAb.setImageDrawable(null);
                    aVar.kAb.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.eVV.get(i).getName_show());
                    aVar.gPm.setText(this.eVV.get(i).getIntro());
                    aVar.myw.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.myt.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            dd(view);
        }
        return view;
    }

    private void dd(View view) {
        this.myt.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.myt.getLayoutMode().onModeChanged(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.hkP) {
            return 0;
        }
        return (this.eVV == null || i >= this.eVV.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.hkP) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes8.dex */
    private class a {
        TextView gPm;
        TextView hkT;
        LinearLayout hlT;
        HeadImageView kAb;
        ImageView kKq;
        TextView mName;
        ProgressBar mProgress;
        ImageView myw;

        private a() {
        }
    }
}
