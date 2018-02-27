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
    private boolean ecy;
    private View.OnClickListener fxD;
    private View.OnClickListener fxe;
    private PersonFriendActivity gmS;
    private int mPageType;
    private ArrayList<UserData> aRX = null;
    private boolean mHasMore = false;
    private boolean gmT = false;
    private boolean fxc = false;
    private ArrayList<ProgressBar> gmU = new ArrayList<>();

    public void bjJ() {
        if (this.gmU != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.gmU.size()) {
                    try {
                        this.gmU.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.gmU.clear();
                    return;
                }
            }
        }
    }

    public void aXu() {
        this.fxc = false;
        if (this.aRX != null && this.aRX.size() == 0) {
            this.fxc = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void lx(boolean z) {
        this.gmT = z;
    }

    public h(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.gmS = null;
        this.ecy = true;
        this.mPageType = 0;
        this.fxD = null;
        this.fxe = null;
        this.gmS = personFriendActivity;
        this.ecy = z;
        this.mPageType = i;
        this.fxD = onClickListener;
        this.fxe = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.aRX = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fxc) {
            return 1;
        }
        int i = 0;
        if (this.aRX != null) {
            i = this.aRX.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aRX == null || i >= this.aRX.size()) {
            return null;
        }
        return this.aRX.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.aRX == null || i >= this.aRX.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.aRX != null) {
            if (view == null) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.gmS.getPageContext().getPageActivity()).inflate(d.h.person_list_item_friend, (ViewGroup) null);
                    aVar2.dGC = (HeadImageView) inflate.findViewById(d.g.photo);
                    aVar2.dGC.setIsRound(false);
                    aVar2.dGC.setAutoChangeStyle(true);
                    aVar2.chX = (LinearLayout) inflate.findViewById(d.g.info);
                    aVar2.mName = (TextView) inflate.findViewById(d.g.name);
                    aVar2.fxj = (TextView) inflate.findViewById(d.g.at_list_nodata);
                    aVar2.chW = (TextView) inflate.findViewById(d.g.intro);
                    aVar2.gmV = (ImageView) inflate.findViewById(d.g.chat);
                    aVar2.eLi = (ImageView) inflate.findViewById(d.g.diver_buttom_px);
                    aVar2.gmV.setOnClickListener(this.fxD);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.gmS.getPageContext().getPageActivity()).inflate(d.h.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(d.g.pb_more_text);
                    inflate2.setOnClickListener(this.fxe);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(d.g.progress);
                    this.gmU.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.fxc) {
                    aVar.chX.setVisibility(8);
                    aVar.gmV.setVisibility(8);
                    aVar.fxj.setVisibility(8);
                    aVar.eLi.setVisibility(8);
                } else {
                    if (!this.ecy && this.mPageType == 0) {
                        aVar.gmV.setVisibility(8);
                    } else {
                        aVar.gmV.setVisibility(0);
                    }
                    aVar.chX.setVisibility(0);
                    aVar.chX.setTag(Integer.valueOf(i));
                    aVar.eLi.setVisibility(0);
                    aVar.fxj.setVisibility(8);
                    String portrait = this.aRX.get(i).getPortrait();
                    aVar.dGC.setImageDrawable(null);
                    aVar.dGC.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.aRX.get(i).getName_show());
                    aVar.chW.setText(this.aRX.get(i).getIntro());
                    aVar.gmV.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.gmS.getPageContext().getString(d.j.loading));
                aVar.mProgress.setVisibility(0);
            }
            bU(view);
        }
        return view;
    }

    private void bU(View view) {
        this.gmS.getLayoutMode().aQ(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gmS.getLayoutMode().aM(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fxc) {
            return 0;
        }
        return (this.aRX == null || i >= this.aRX.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fxc) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes3.dex */
    private class a {
        TextView chW;
        LinearLayout chX;
        HeadImageView dGC;
        ImageView eLi;
        TextView fxj;
        ImageView gmV;
        TextView mName;
        ProgressBar mProgress;

        private a() {
        }
    }
}
