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
    private boolean fZG;
    private View.OnClickListener hxZ;
    private View.OnClickListener hyC;
    private PersonFriendActivity iph;
    private int mPageType;
    private ArrayList<UserData> aIn = null;
    private boolean mHasMore = false;
    private boolean ipi = false;
    private boolean hxX = false;
    private ArrayList<ProgressBar> ipj = new ArrayList<>();

    public void ccM() {
        if (this.ipj != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.ipj.size()) {
                    try {
                        this.ipj.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.ipj.clear();
                    return;
                }
            }
        }
    }

    public void bPy() {
        this.hxX = false;
        if (this.aIn != null && this.aIn.size() == 0) {
            this.hxX = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void pK(boolean z) {
        this.ipi = z;
    }

    public d(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.iph = null;
        this.fZG = true;
        this.mPageType = 0;
        this.hyC = null;
        this.hxZ = null;
        this.iph = personFriendActivity;
        this.fZG = z;
        this.mPageType = i;
        this.hyC = onClickListener;
        this.hxZ = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.aIn = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hxX) {
            return 1;
        }
        int i = 0;
        if (this.aIn != null) {
            i = this.aIn.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aIn == null || i >= this.aIn.size()) {
            return null;
        }
        return this.aIn.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.aIn == null || i >= this.aIn.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.aIn != null) {
            if (view == null) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.iph.getPageContext().getPageActivity()).inflate(R.layout.person_list_item_friend, (ViewGroup) null);
                    aVar2.eem = (HeadImageView) inflate.findViewById(R.id.photo);
                    aVar2.eem.setIsRound(false);
                    aVar2.eem.setAutoChangeStyle(true);
                    aVar2.dzB = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.hye = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.dzA = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.ipk = (ImageView) inflate.findViewById(R.id.chat);
                    aVar2.gPd = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    aVar2.ipk.setOnClickListener(this.hyC);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.iph.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(R.id.pb_more_text);
                    inflate2.setOnClickListener(this.hxZ);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(R.id.progress);
                    this.ipj.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.hxX) {
                    aVar.dzB.setVisibility(8);
                    aVar.ipk.setVisibility(8);
                    aVar.hye.setVisibility(8);
                    aVar.gPd.setVisibility(8);
                } else {
                    if (!this.fZG && this.mPageType == 0) {
                        aVar.ipk.setVisibility(8);
                    } else {
                        aVar.ipk.setVisibility(0);
                    }
                    aVar.dzB.setVisibility(0);
                    aVar.dzB.setTag(Integer.valueOf(i));
                    aVar.gPd.setVisibility(0);
                    aVar.hye.setVisibility(8);
                    String portrait = this.aIn.get(i).getPortrait();
                    aVar.eem.setImageDrawable(null);
                    aVar.eem.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.aIn.get(i).getName_show());
                    aVar.dzA.setText(this.aIn.get(i).getIntro());
                    aVar.ipk.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.iph.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            ca(view);
        }
        return view;
    }

    private void ca(View view) {
        this.iph.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.iph.getLayoutMode().onModeChanged(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.hxX) {
            return 0;
        }
        return (this.aIn == null || i >= this.aIn.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.hxX) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes6.dex */
    private class a {
        TextView dzA;
        LinearLayout dzB;
        HeadImageView eem;
        ImageView gPd;
        TextView hye;
        ImageView ipk;
        TextView mName;
        ProgressBar mProgress;

        private a() {
        }
    }
}
