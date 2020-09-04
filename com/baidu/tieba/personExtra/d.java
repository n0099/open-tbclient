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
/* loaded from: classes18.dex */
public class d extends BaseAdapter {
    private boolean ghv;
    private View.OnClickListener kiP;
    private View.OnClickListener kjv;
    private PersonFriendActivity ljJ;
    private int mPageType;
    private ArrayList<UserData> egb = null;
    private boolean mHasMore = false;
    private boolean ljK = false;
    private boolean ght = false;
    private ArrayList<ProgressBar> ljL = new ArrayList<>();

    public void dhZ() {
        if (this.ljL != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.ljL.size()) {
                    try {
                        this.ljL.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.ljL.clear();
                    return;
                }
            }
        }
    }

    public void bLD() {
        this.ght = false;
        if (this.egb != null && this.egb.size() == 0) {
            this.ght = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void uC(boolean z) {
        this.ljK = z;
    }

    public d(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.ljJ = null;
        this.ghv = true;
        this.mPageType = 0;
        this.kjv = null;
        this.kiP = null;
        this.ljJ = personFriendActivity;
        this.ghv = z;
        this.mPageType = i;
        this.kjv = onClickListener;
        this.kiP = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.egb = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ght) {
            return 1;
        }
        int i = 0;
        if (this.egb != null) {
            i = this.egb.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.egb == null || i >= this.egb.size()) {
            return null;
        }
        return this.egb.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.egb == null || i >= this.egb.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.egb != null) {
            if (view == null) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.ljJ.getPageContext().getPageActivity()).inflate(R.layout.person_list_item_friend, (ViewGroup) null);
                    aVar2.hWA = (HeadImageView) inflate.findViewById(R.id.photo);
                    aVar2.hWA.setIsRound(false);
                    aVar2.hWA.setAutoChangeStyle(true);
                    aVar2.giA = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.ghx = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.fRM = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.ljM = (ImageView) inflate.findViewById(R.id.chat);
                    aVar2.jxu = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    aVar2.ljM.setOnClickListener(this.kjv);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.ljJ.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(R.id.pb_more_text);
                    inflate2.setOnClickListener(this.kiP);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(R.id.progress);
                    this.ljL.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.ght) {
                    aVar.giA.setVisibility(8);
                    aVar.ljM.setVisibility(8);
                    aVar.ghx.setVisibility(8);
                    aVar.jxu.setVisibility(8);
                } else {
                    if (!this.ghv && this.mPageType == 0) {
                        aVar.ljM.setVisibility(8);
                    } else {
                        aVar.ljM.setVisibility(0);
                    }
                    aVar.giA.setVisibility(0);
                    aVar.giA.setTag(Integer.valueOf(i));
                    aVar.jxu.setVisibility(0);
                    aVar.ghx.setVisibility(8);
                    String portrait = this.egb.get(i).getPortrait();
                    aVar.hWA.setImageDrawable(null);
                    aVar.hWA.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.egb.get(i).getName_show());
                    aVar.fRM.setText(this.egb.get(i).getIntro());
                    aVar.ljM.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.ljJ.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            co(view);
        }
        return view;
    }

    private void co(View view) {
        this.ljJ.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.ljJ.getLayoutMode().onModeChanged(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.ght) {
            return 0;
        }
        return (this.egb == null || i >= this.egb.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.ght) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes18.dex */
    private class a {
        TextView fRM;
        TextView ghx;
        LinearLayout giA;
        HeadImageView hWA;
        ImageView jxu;
        ImageView ljM;
        TextView mName;
        ProgressBar mProgress;

        private a() {
        }
    }
}
