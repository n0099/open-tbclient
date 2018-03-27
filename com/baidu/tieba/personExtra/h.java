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
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class h extends BaseAdapter {
    private boolean ecO;
    private View.OnClickListener fxT;
    private View.OnClickListener fxu;
    private PersonFriendActivity gni;
    private int mPageType;
    private ArrayList<UserData> aRZ = null;
    private boolean mHasMore = false;
    private boolean gnj = false;
    private boolean fxs = false;
    private ArrayList<ProgressBar> gnk = new ArrayList<>();

    public void bjK() {
        if (this.gnk != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.gnk.size()) {
                    try {
                        this.gnk.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.gnk.clear();
                    return;
                }
            }
        }
    }

    public void aXv() {
        this.fxs = false;
        if (this.aRZ != null && this.aRZ.size() == 0) {
            this.fxs = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void lC(boolean z) {
        this.gnj = z;
    }

    public h(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.gni = null;
        this.ecO = true;
        this.mPageType = 0;
        this.fxT = null;
        this.fxu = null;
        this.gni = personFriendActivity;
        this.ecO = z;
        this.mPageType = i;
        this.fxT = onClickListener;
        this.fxu = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.aRZ = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fxs) {
            return 1;
        }
        int i = 0;
        if (this.aRZ != null) {
            i = this.aRZ.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aRZ == null || i >= this.aRZ.size()) {
            return null;
        }
        return this.aRZ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.aRZ == null || i >= this.aRZ.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.aRZ != null) {
            if (view == null) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.gni.getPageContext().getPageActivity()).inflate(d.h.person_list_item_friend, (ViewGroup) null);
                    aVar2.dGH = (HeadImageView) inflate.findViewById(d.g.photo);
                    aVar2.dGH.setIsRound(false);
                    aVar2.dGH.setAutoChangeStyle(true);
                    aVar2.cia = (LinearLayout) inflate.findViewById(d.g.info);
                    aVar2.mName = (TextView) inflate.findViewById(d.g.name);
                    aVar2.fxz = (TextView) inflate.findViewById(d.g.at_list_nodata);
                    aVar2.chZ = (TextView) inflate.findViewById(d.g.intro);
                    aVar2.gnl = (ImageView) inflate.findViewById(d.g.chat);
                    aVar2.eLy = (ImageView) inflate.findViewById(d.g.diver_buttom_px);
                    aVar2.gnl.setOnClickListener(this.fxT);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.gni.getPageContext().getPageActivity()).inflate(d.h.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(d.g.pb_more_text);
                    inflate2.setOnClickListener(this.fxu);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(d.g.progress);
                    this.gnk.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.fxs) {
                    aVar.cia.setVisibility(8);
                    aVar.gnl.setVisibility(8);
                    aVar.fxz.setVisibility(8);
                    aVar.eLy.setVisibility(8);
                } else {
                    if (!this.ecO && this.mPageType == 0) {
                        aVar.gnl.setVisibility(8);
                    } else {
                        aVar.gnl.setVisibility(0);
                    }
                    aVar.cia.setVisibility(0);
                    aVar.cia.setTag(Integer.valueOf(i));
                    aVar.eLy.setVisibility(0);
                    aVar.fxz.setVisibility(8);
                    String portrait = this.aRZ.get(i).getPortrait();
                    aVar.dGH.setImageDrawable(null);
                    aVar.dGH.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.aRZ.get(i).getName_show());
                    aVar.chZ.setText(this.aRZ.get(i).getIntro());
                    aVar.gnl.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.gni.getPageContext().getString(d.j.loading));
                aVar.mProgress.setVisibility(0);
            }
            bU(view);
        }
        return view;
    }

    private void bU(View view) {
        this.gni.getLayoutMode().aQ(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gni.getLayoutMode().aM(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fxs) {
            return 0;
        }
        return (this.aRZ == null || i >= this.aRZ.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fxs) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes3.dex */
    private class a {
        TextView chZ;
        LinearLayout cia;
        HeadImageView dGH;
        ImageView eLy;
        TextView fxz;
        ImageView gnl;
        TextView mName;
        ProgressBar mProgress;

        private a() {
        }
    }
}
