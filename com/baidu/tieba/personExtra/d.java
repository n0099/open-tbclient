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
/* loaded from: classes23.dex */
public class d extends BaseAdapter {
    private boolean gQe;
    private View.OnClickListener kZS;
    private View.OnClickListener kZl;
    private int mPageType;
    private PersonFriendActivity maF;
    private ArrayList<UserData> eHj = null;
    private boolean mHasMore = false;
    private boolean maG = false;
    private boolean gQc = false;
    private ArrayList<ProgressBar> maH = new ArrayList<>();

    public void dux() {
        if (this.maH != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.maH.size()) {
                    try {
                        this.maH.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.maH.clear();
                    return;
                }
            }
        }
    }

    public void bUT() {
        this.gQc = false;
        if (this.eHj != null && this.eHj.size() == 0) {
            this.gQc = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void vU(boolean z) {
        this.maG = z;
    }

    public d(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.maF = null;
        this.gQe = true;
        this.mPageType = 0;
        this.kZS = null;
        this.kZl = null;
        this.maF = personFriendActivity;
        this.gQe = z;
        this.mPageType = i;
        this.kZS = onClickListener;
        this.kZl = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.eHj = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gQc) {
            return 1;
        }
        int i = 0;
        if (this.eHj != null) {
            i = this.eHj.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eHj == null || i >= this.eHj.size()) {
            return null;
        }
        return this.eHj.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.eHj == null || i >= this.eHj.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.eHj != null) {
            if (view == null) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.maF.getPageContext().getPageActivity()).inflate(R.layout.person_list_item_friend, (ViewGroup) null);
                    aVar2.iLH = (HeadImageView) inflate.findViewById(R.id.photo);
                    aVar2.iLH.setIsRound(false);
                    aVar2.iLH.setAutoChangeStyle(true);
                    aVar2.gRh = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.gQg = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.gwO = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.maI = (ImageView) inflate.findViewById(R.id.chat);
                    aVar2.koa = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    aVar2.maI.setOnClickListener(this.kZS);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.maF.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(R.id.pb_more_text);
                    inflate2.setOnClickListener(this.kZl);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(R.id.progress);
                    this.maH.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.gQc) {
                    aVar.gRh.setVisibility(8);
                    aVar.maI.setVisibility(8);
                    aVar.gQg.setVisibility(8);
                    aVar.koa.setVisibility(8);
                } else {
                    if (!this.gQe && this.mPageType == 0) {
                        aVar.maI.setVisibility(8);
                    } else {
                        aVar.maI.setVisibility(0);
                    }
                    aVar.gRh.setVisibility(0);
                    aVar.gRh.setTag(Integer.valueOf(i));
                    aVar.koa.setVisibility(0);
                    aVar.gQg.setVisibility(8);
                    String portrait = this.eHj.get(i).getPortrait();
                    aVar.iLH.setImageDrawable(null);
                    aVar.iLH.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.eHj.get(i).getName_show());
                    aVar.gwO.setText(this.eHj.get(i).getIntro());
                    aVar.maI.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.maF.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            cO(view);
        }
        return view;
    }

    private void cO(View view) {
        this.maF.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.maF.getLayoutMode().onModeChanged(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.gQc) {
            return 0;
        }
        return (this.eHj == null || i >= this.eHj.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.gQc) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes23.dex */
    private class a {
        TextView gQg;
        LinearLayout gRh;
        TextView gwO;
        HeadImageView iLH;
        ImageView koa;
        TextView mName;
        ProgressBar mProgress;
        ImageView maI;

        private a() {
        }
    }
}
