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
/* loaded from: classes7.dex */
public class d extends BaseAdapter {
    private boolean hmO;
    private View.OnClickListener lxO;
    private View.OnClickListener lyw;
    private PersonFriendActivity mAK;
    private int mPageType;
    private ArrayList<UserData> eXu = null;
    private boolean mHasMore = false;
    private boolean mAL = false;
    private boolean hmM = false;
    private ArrayList<ProgressBar> mAM = new ArrayList<>();

    public void dyn() {
        if (this.mAM != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mAM.size()) {
                    try {
                        this.mAM.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.mAM.clear();
                    return;
                }
            }
        }
    }

    public void bYE() {
        this.hmM = false;
        if (this.eXu != null && this.eXu.size() == 0) {
            this.hmM = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void wM(boolean z) {
        this.mAL = z;
    }

    public d(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.mAK = null;
        this.hmO = true;
        this.mPageType = 0;
        this.lyw = null;
        this.lxO = null;
        this.mAK = personFriendActivity;
        this.hmO = z;
        this.mPageType = i;
        this.lyw = onClickListener;
        this.lxO = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.eXu = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hmM) {
            return 1;
        }
        int i = 0;
        if (this.eXu != null) {
            i = this.eXu.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eXu == null || i >= this.eXu.size()) {
            return null;
        }
        return this.eXu.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.eXu == null || i >= this.eXu.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.eXu != null) {
            if (view == null) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.mAK.getPageContext().getPageActivity()).inflate(R.layout.person_list_item_friend, (ViewGroup) null);
                    aVar2.kCr = (HeadImageView) inflate.findViewById(R.id.photo);
                    aVar2.kCr.setIsRound(false);
                    aVar2.kCr.setAutoChangeStyle(true);
                    aVar2.hnQ = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.hmQ = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.gRj = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.mAN = (ImageView) inflate.findViewById(R.id.chat);
                    aVar2.kMG = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    aVar2.mAN.setOnClickListener(this.lyw);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.mAK.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(R.id.pb_more_text);
                    inflate2.setOnClickListener(this.lxO);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(R.id.progress);
                    this.mAM.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.hmM) {
                    aVar.hnQ.setVisibility(8);
                    aVar.mAN.setVisibility(8);
                    aVar.hmQ.setVisibility(8);
                    aVar.kMG.setVisibility(8);
                } else {
                    if (!this.hmO && this.mPageType == 0) {
                        aVar.mAN.setVisibility(8);
                    } else {
                        aVar.mAN.setVisibility(0);
                    }
                    aVar.hnQ.setVisibility(0);
                    aVar.hnQ.setTag(Integer.valueOf(i));
                    aVar.kMG.setVisibility(0);
                    aVar.hmQ.setVisibility(8);
                    String portrait = this.eXu.get(i).getPortrait();
                    aVar.kCr.setImageDrawable(null);
                    aVar.kCr.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.eXu.get(i).getName_show());
                    aVar.gRj.setText(this.eXu.get(i).getIntro());
                    aVar.mAN.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.mAK.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            dd(view);
        }
        return view;
    }

    private void dd(View view) {
        this.mAK.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.mAK.getLayoutMode().onModeChanged(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.hmM) {
            return 0;
        }
        return (this.eXu == null || i >= this.eXu.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.hmM) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes7.dex */
    private class a {
        TextView gRj;
        TextView hmQ;
        LinearLayout hnQ;
        HeadImageView kCr;
        ImageView kMG;
        ImageView mAN;
        TextView mName;
        ProgressBar mProgress;

        private a() {
        }
    }
}
