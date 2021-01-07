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
    private boolean hli;
    private View.OnClickListener lsI;
    private View.OnClickListener lsb;
    private int mPageType;
    private PersonFriendActivity mtY;
    private ArrayList<UserData> eYq = null;
    private boolean mHasMore = false;
    private boolean mtZ = false;
    private boolean hlg = false;
    private ArrayList<ProgressBar> mua = new ArrayList<>();

    public void dzG() {
        if (this.mua != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mua.size()) {
                    try {
                        this.mua.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.mua.clear();
                    return;
                }
            }
        }
    }

    public void cbj() {
        this.hlg = false;
        if (this.eYq != null && this.eYq.size() == 0) {
            this.hlg = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void wz(boolean z) {
        this.mtZ = z;
    }

    public d(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.mtY = null;
        this.hli = true;
        this.mPageType = 0;
        this.lsI = null;
        this.lsb = null;
        this.mtY = personFriendActivity;
        this.hli = z;
        this.mPageType = i;
        this.lsI = onClickListener;
        this.lsb = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.eYq = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hlg) {
            return 1;
        }
        int i = 0;
        if (this.eYq != null) {
            i = this.eYq.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eYq == null || i >= this.eYq.size()) {
            return null;
        }
        return this.eYq.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.eYq == null || i >= this.eYq.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.eYq != null) {
            if (view == null) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.mtY.getPageContext().getPageActivity()).inflate(R.layout.person_list_item_friend, (ViewGroup) null);
                    aVar2.kwz = (HeadImageView) inflate.findViewById(R.id.photo);
                    aVar2.kwz.setIsRound(false);
                    aVar2.kwz.setAutoChangeStyle(true);
                    aVar2.hmk = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.hlk = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.gRm = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.mub = (ImageView) inflate.findViewById(R.id.chat);
                    aVar2.kGQ = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    aVar2.mub.setOnClickListener(this.lsI);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.mtY.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(R.id.pb_more_text);
                    inflate2.setOnClickListener(this.lsb);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(R.id.progress);
                    this.mua.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.hlg) {
                    aVar.hmk.setVisibility(8);
                    aVar.mub.setVisibility(8);
                    aVar.hlk.setVisibility(8);
                    aVar.kGQ.setVisibility(8);
                } else {
                    if (!this.hli && this.mPageType == 0) {
                        aVar.mub.setVisibility(8);
                    } else {
                        aVar.mub.setVisibility(0);
                    }
                    aVar.hmk.setVisibility(0);
                    aVar.hmk.setTag(Integer.valueOf(i));
                    aVar.kGQ.setVisibility(0);
                    aVar.hlk.setVisibility(8);
                    String portrait = this.eYq.get(i).getPortrait();
                    aVar.kwz.setImageDrawable(null);
                    aVar.kwz.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.eYq.get(i).getName_show());
                    aVar.gRm.setText(this.eYq.get(i).getIntro());
                    aVar.mub.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.mtY.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            df(view);
        }
        return view;
    }

    private void df(View view) {
        this.mtY.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.mtY.getLayoutMode().onModeChanged(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.hlg) {
            return 0;
        }
        return (this.eYq == null || i >= this.eYq.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.hlg) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes8.dex */
    private class a {
        TextView gRm;
        TextView hlk;
        LinearLayout hmk;
        ImageView kGQ;
        HeadImageView kwz;
        TextView mName;
        ProgressBar mProgress;
        ImageView mub;

        private a() {
        }
    }
}
