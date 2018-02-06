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
    private boolean ecK;
    private View.OnClickListener fxP;
    private View.OnClickListener fxq;
    private PersonFriendActivity gnd;
    private int mPageType;
    private ArrayList<UserData> aSi = null;
    private boolean mHasMore = false;
    private boolean gne = false;
    private boolean fxo = false;
    private ArrayList<ProgressBar> gnf = new ArrayList<>();

    public void bjK() {
        if (this.gnf != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.gnf.size()) {
                    try {
                        this.gnf.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.gnf.clear();
                    return;
                }
            }
        }
    }

    public void aXv() {
        this.fxo = false;
        if (this.aSi != null && this.aSi.size() == 0) {
            this.fxo = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void lx(boolean z) {
        this.gne = z;
    }

    public h(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.gnd = null;
        this.ecK = true;
        this.mPageType = 0;
        this.fxP = null;
        this.fxq = null;
        this.gnd = personFriendActivity;
        this.ecK = z;
        this.mPageType = i;
        this.fxP = onClickListener;
        this.fxq = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.aSi = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fxo) {
            return 1;
        }
        int i = 0;
        if (this.aSi != null) {
            i = this.aSi.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aSi == null || i >= this.aSi.size()) {
            return null;
        }
        return this.aSi.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.aSi == null || i >= this.aSi.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.aSi != null) {
            if (view == null) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.gnd.getPageContext().getPageActivity()).inflate(d.h.person_list_item_friend, (ViewGroup) null);
                    aVar2.dGO = (HeadImageView) inflate.findViewById(d.g.photo);
                    aVar2.dGO.setIsRound(false);
                    aVar2.dGO.setAutoChangeStyle(true);
                    aVar2.cik = (LinearLayout) inflate.findViewById(d.g.info);
                    aVar2.mName = (TextView) inflate.findViewById(d.g.name);
                    aVar2.fxv = (TextView) inflate.findViewById(d.g.at_list_nodata);
                    aVar2.cij = (TextView) inflate.findViewById(d.g.intro);
                    aVar2.gng = (ImageView) inflate.findViewById(d.g.chat);
                    aVar2.eLu = (ImageView) inflate.findViewById(d.g.diver_buttom_px);
                    aVar2.gng.setOnClickListener(this.fxP);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.gnd.getPageContext().getPageActivity()).inflate(d.h.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(d.g.pb_more_text);
                    inflate2.setOnClickListener(this.fxq);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(d.g.progress);
                    this.gnf.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.fxo) {
                    aVar.cik.setVisibility(8);
                    aVar.gng.setVisibility(8);
                    aVar.fxv.setVisibility(8);
                    aVar.eLu.setVisibility(8);
                } else {
                    if (!this.ecK && this.mPageType == 0) {
                        aVar.gng.setVisibility(8);
                    } else {
                        aVar.gng.setVisibility(0);
                    }
                    aVar.cik.setVisibility(0);
                    aVar.cik.setTag(Integer.valueOf(i));
                    aVar.eLu.setVisibility(0);
                    aVar.fxv.setVisibility(8);
                    String portrait = this.aSi.get(i).getPortrait();
                    aVar.dGO.setImageDrawable(null);
                    aVar.dGO.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.aSi.get(i).getName_show());
                    aVar.cij.setText(this.aSi.get(i).getIntro());
                    aVar.gng.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.gnd.getPageContext().getString(d.j.loading));
                aVar.mProgress.setVisibility(0);
            }
            bU(view);
        }
        return view;
    }

    private void bU(View view) {
        this.gnd.getLayoutMode().aQ(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gnd.getLayoutMode().aM(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fxo) {
            return 0;
        }
        return (this.aSi == null || i >= this.aSi.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fxo) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes3.dex */
    private class a {
        TextView cij;
        LinearLayout cik;
        HeadImageView dGO;
        ImageView eLu;
        TextView fxv;
        ImageView gng;
        TextView mName;
        ProgressBar mProgress;

        private a() {
        }
    }
}
