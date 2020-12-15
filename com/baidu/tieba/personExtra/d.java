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
/* loaded from: classes24.dex */
public class d extends BaseAdapter {
    private boolean gZt;
    private View.OnClickListener lmJ;
    private View.OnClickListener lnr;
    private int mPageType;
    private PersonFriendActivity moN;
    private ArrayList<UserData> eOt = null;
    private boolean mHasMore = false;
    private boolean moO = false;
    private boolean gZr = false;
    private ArrayList<ProgressBar> moP = new ArrayList<>();

    public void dzQ() {
        if (this.moP != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.moP.size()) {
                    try {
                        this.moP.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.moP.clear();
                    return;
                }
            }
        }
    }

    public void bYD() {
        this.gZr = false;
        if (this.eOt != null && this.eOt.size() == 0) {
            this.gZr = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void wy(boolean z) {
        this.moO = z;
    }

    public d(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.moN = null;
        this.gZt = true;
        this.mPageType = 0;
        this.lnr = null;
        this.lmJ = null;
        this.moN = personFriendActivity;
        this.gZt = z;
        this.mPageType = i;
        this.lnr = onClickListener;
        this.lmJ = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.eOt = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gZr) {
            return 1;
        }
        int i = 0;
        if (this.eOt != null) {
            i = this.eOt.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eOt == null || i >= this.eOt.size()) {
            return null;
        }
        return this.eOt.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.eOt == null || i >= this.eOt.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.eOt != null) {
            if (view == null) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.moN.getPageContext().getPageActivity()).inflate(R.layout.person_list_item_friend, (ViewGroup) null);
                    aVar2.kjT = (HeadImageView) inflate.findViewById(R.id.photo);
                    aVar2.kjT.setIsRound(false);
                    aVar2.kjT.setAutoChangeStyle(true);
                    aVar2.haw = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.gZv = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.gFB = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.moQ = (ImageView) inflate.findViewById(R.id.chat);
                    aVar2.kBy = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    aVar2.moQ.setOnClickListener(this.lnr);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.moN.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(R.id.pb_more_text);
                    inflate2.setOnClickListener(this.lmJ);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(R.id.progress);
                    this.moP.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.gZr) {
                    aVar.haw.setVisibility(8);
                    aVar.moQ.setVisibility(8);
                    aVar.gZv.setVisibility(8);
                    aVar.kBy.setVisibility(8);
                } else {
                    if (!this.gZt && this.mPageType == 0) {
                        aVar.moQ.setVisibility(8);
                    } else {
                        aVar.moQ.setVisibility(0);
                    }
                    aVar.haw.setVisibility(0);
                    aVar.haw.setTag(Integer.valueOf(i));
                    aVar.kBy.setVisibility(0);
                    aVar.gZv.setVisibility(8);
                    String portrait = this.eOt.get(i).getPortrait();
                    aVar.kjT.setImageDrawable(null);
                    aVar.kjT.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.eOt.get(i).getName_show());
                    aVar.gFB.setText(this.eOt.get(i).getIntro());
                    aVar.moQ.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.moN.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            cV(view);
        }
        return view;
    }

    private void cV(View view) {
        this.moN.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.moN.getLayoutMode().onModeChanged(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.gZr) {
            return 0;
        }
        return (this.eOt == null || i >= this.eOt.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.gZr) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes24.dex */
    private class a {
        TextView gFB;
        TextView gZv;
        LinearLayout haw;
        ImageView kBy;
        HeadImageView kjT;
        TextView mName;
        ProgressBar mProgress;
        ImageView moQ;

        private a() {
        }
    }
}
