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
    private boolean hgB;
    private View.OnClickListener lnZ;
    private View.OnClickListener lns;
    private int mPageType;
    private PersonFriendActivity mpt;
    private ArrayList<UserData> eTF = null;
    private boolean mHasMore = false;
    private boolean mpu = false;
    private boolean hgz = false;
    private ArrayList<ProgressBar> mpv = new ArrayList<>();

    public void dvO() {
        if (this.mpv != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mpv.size()) {
                    try {
                        this.mpv.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.mpv.clear();
                    return;
                }
            }
        }
    }

    public void bXr() {
        this.hgz = false;
        if (this.eTF != null && this.eTF.size() == 0) {
            this.hgz = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void wv(boolean z) {
        this.mpu = z;
    }

    public d(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.mpt = null;
        this.hgB = true;
        this.mPageType = 0;
        this.lnZ = null;
        this.lns = null;
        this.mpt = personFriendActivity;
        this.hgB = z;
        this.mPageType = i;
        this.lnZ = onClickListener;
        this.lns = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.eTF = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hgz) {
            return 1;
        }
        int i = 0;
        if (this.eTF != null) {
            i = this.eTF.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eTF == null || i >= this.eTF.size()) {
            return null;
        }
        return this.eTF.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.eTF == null || i >= this.eTF.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.eTF != null) {
            if (view == null) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.mpt.getPageContext().getPageActivity()).inflate(R.layout.person_list_item_friend, (ViewGroup) null);
                    aVar2.krU = (HeadImageView) inflate.findViewById(R.id.photo);
                    aVar2.krU.setIsRound(false);
                    aVar2.krU.setAutoChangeStyle(true);
                    aVar2.hhD = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.hgD = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.gMG = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.mpw = (ImageView) inflate.findViewById(R.id.chat);
                    aVar2.kCl = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    aVar2.mpw.setOnClickListener(this.lnZ);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.mpt.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(R.id.pb_more_text);
                    inflate2.setOnClickListener(this.lns);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(R.id.progress);
                    this.mpv.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.hgz) {
                    aVar.hhD.setVisibility(8);
                    aVar.mpw.setVisibility(8);
                    aVar.hgD.setVisibility(8);
                    aVar.kCl.setVisibility(8);
                } else {
                    if (!this.hgB && this.mPageType == 0) {
                        aVar.mpw.setVisibility(8);
                    } else {
                        aVar.mpw.setVisibility(0);
                    }
                    aVar.hhD.setVisibility(0);
                    aVar.hhD.setTag(Integer.valueOf(i));
                    aVar.kCl.setVisibility(0);
                    aVar.hgD.setVisibility(8);
                    String portrait = this.eTF.get(i).getPortrait();
                    aVar.krU.setImageDrawable(null);
                    aVar.krU.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.eTF.get(i).getName_show());
                    aVar.gMG.setText(this.eTF.get(i).getIntro());
                    aVar.mpw.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.mpt.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            df(view);
        }
        return view;
    }

    private void df(View view) {
        this.mpt.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.mpt.getLayoutMode().onModeChanged(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.hgz) {
            return 0;
        }
        return (this.eTF == null || i >= this.eTF.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.hgz) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes7.dex */
    private class a {
        TextView gMG;
        TextView hgD;
        LinearLayout hhD;
        ImageView kCl;
        HeadImageView krU;
        TextView mName;
        ProgressBar mProgress;
        ImageView mpw;

        private a() {
        }
    }
}
