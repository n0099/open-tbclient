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
    private boolean eGA;
    private View.OnClickListener ilO;
    private View.OnClickListener imv;
    private PersonFriendActivity jhg;
    private int mPageType;
    private ArrayList<UserData> cRE = null;
    private boolean mHasMore = false;
    private boolean jhh = false;
    private boolean eGy = false;
    private ArrayList<ProgressBar> jhi = new ArrayList<>();

    public void ctW() {
        if (this.jhi != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.jhi.size()) {
                    try {
                        this.jhi.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.jhi.clear();
                    return;
                }
            }
        }
    }

    public void bec() {
        this.eGy = false;
        if (this.cRE != null && this.cRE.size() == 0) {
            this.eGy = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void qX(boolean z) {
        this.jhh = z;
    }

    public d(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.jhg = null;
        this.eGA = true;
        this.mPageType = 0;
        this.imv = null;
        this.ilO = null;
        this.jhg = personFriendActivity;
        this.eGA = z;
        this.mPageType = i;
        this.imv = onClickListener;
        this.ilO = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.cRE = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eGy) {
            return 1;
        }
        int i = 0;
        if (this.cRE != null) {
            i = this.cRE.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cRE == null || i >= this.cRE.size()) {
            return null;
        }
        return this.cRE.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.cRE == null || i >= this.cRE.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.cRE != null) {
            if (view == null) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.jhg.getPageContext().getPageActivity()).inflate(R.layout.person_list_item_friend, (ViewGroup) null);
                    aVar2.glX = (HeadImageView) inflate.findViewById(R.id.photo);
                    aVar2.glX.setIsRound(false);
                    aVar2.glX.setAutoChangeStyle(true);
                    aVar2.eHE = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.eGC = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.erQ = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.jhj = (ImageView) inflate.findViewById(R.id.chat);
                    aVar2.hCl = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    aVar2.jhj.setOnClickListener(this.imv);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.jhg.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(R.id.pb_more_text);
                    inflate2.setOnClickListener(this.ilO);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(R.id.progress);
                    this.jhi.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.eGy) {
                    aVar.eHE.setVisibility(8);
                    aVar.jhj.setVisibility(8);
                    aVar.eGC.setVisibility(8);
                    aVar.hCl.setVisibility(8);
                } else {
                    if (!this.eGA && this.mPageType == 0) {
                        aVar.jhj.setVisibility(8);
                    } else {
                        aVar.jhj.setVisibility(0);
                    }
                    aVar.eHE.setVisibility(0);
                    aVar.eHE.setTag(Integer.valueOf(i));
                    aVar.hCl.setVisibility(0);
                    aVar.eGC.setVisibility(8);
                    String portrait = this.cRE.get(i).getPortrait();
                    aVar.glX.setImageDrawable(null);
                    aVar.glX.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.cRE.get(i).getName_show());
                    aVar.erQ.setText(this.cRE.get(i).getIntro());
                    aVar.jhj.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.jhg.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            bS(view);
        }
        return view;
    }

    private void bS(View view) {
        this.jhg.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.jhg.getLayoutMode().onModeChanged(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.eGy) {
            return 0;
        }
        return (this.cRE == null || i >= this.cRE.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.eGy) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes8.dex */
    private class a {
        TextView eGC;
        LinearLayout eHE;
        TextView erQ;
        HeadImageView glX;
        ImageView hCl;
        ImageView jhj;
        TextView mName;
        ProgressBar mProgress;

        private a() {
        }
    }
}
