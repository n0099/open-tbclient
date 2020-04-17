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
/* loaded from: classes11.dex */
public class d extends BaseAdapter {
    private boolean fqG;
    private PersonFriendActivity jXI;
    private View.OnClickListener jdO;
    private View.OnClickListener jdi;
    private int mPageType;
    private ArrayList<UserData> dvq = null;
    private boolean mHasMore = false;
    private boolean jXJ = false;
    private boolean fqE = false;
    private ArrayList<ProgressBar> jXK = new ArrayList<>();

    public void cHF() {
        if (this.jXK != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.jXK.size()) {
                    try {
                        this.jXK.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.jXK.clear();
                    return;
                }
            }
        }
    }

    public void bqg() {
        this.fqE = false;
        if (this.dvq != null && this.dvq.size() == 0) {
            this.fqE = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void sy(boolean z) {
        this.jXJ = z;
    }

    public d(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.jXI = null;
        this.fqG = true;
        this.mPageType = 0;
        this.jdO = null;
        this.jdi = null;
        this.jXI = personFriendActivity;
        this.fqG = z;
        this.mPageType = i;
        this.jdO = onClickListener;
        this.jdi = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.dvq = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fqE) {
            return 1;
        }
        int i = 0;
        if (this.dvq != null) {
            i = this.dvq.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dvq == null || i >= this.dvq.size()) {
            return null;
        }
        return this.dvq.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.dvq == null || i >= this.dvq.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.dvq != null) {
            if (view == null) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.jXI.getPageContext().getPageActivity()).inflate(R.layout.person_list_item_friend, (ViewGroup) null);
                    aVar2.hbs = (HeadImageView) inflate.findViewById(R.id.photo);
                    aVar2.hbs.setIsRound(false);
                    aVar2.hbs.setAutoChangeStyle(true);
                    aVar2.frM = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.fqI = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.fcd = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.jXL = (ImageView) inflate.findViewById(R.id.chat);
                    aVar2.itr = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    aVar2.jXL.setOnClickListener(this.jdO);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.jXI.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(R.id.pb_more_text);
                    inflate2.setOnClickListener(this.jdi);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(R.id.progress);
                    this.jXK.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.fqE) {
                    aVar.frM.setVisibility(8);
                    aVar.jXL.setVisibility(8);
                    aVar.fqI.setVisibility(8);
                    aVar.itr.setVisibility(8);
                } else {
                    if (!this.fqG && this.mPageType == 0) {
                        aVar.jXL.setVisibility(8);
                    } else {
                        aVar.jXL.setVisibility(0);
                    }
                    aVar.frM.setVisibility(0);
                    aVar.frM.setTag(Integer.valueOf(i));
                    aVar.itr.setVisibility(0);
                    aVar.fqI.setVisibility(8);
                    String portrait = this.dvq.get(i).getPortrait();
                    aVar.hbs.setImageDrawable(null);
                    aVar.hbs.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.dvq.get(i).getName_show());
                    aVar.fcd.setText(this.dvq.get(i).getIntro());
                    aVar.jXL.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.jXI.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            cf(view);
        }
        return view;
    }

    private void cf(View view) {
        this.jXI.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.jXI.getLayoutMode().onModeChanged(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fqE) {
            return 0;
        }
        return (this.dvq == null || i >= this.dvq.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fqE) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes11.dex */
    private class a {
        TextView fcd;
        TextView fqI;
        LinearLayout frM;
        HeadImageView hbs;
        ImageView itr;
        ImageView jXL;
        TextView mName;
        ProgressBar mProgress;

        private a() {
        }
    }
}
