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
    private boolean fPZ;
    private View.OnClickListener jKM;
    private View.OnClickListener jLs;
    private PersonFriendActivity kKJ;
    private int mPageType;
    private ArrayList<UserData> dQf = null;
    private boolean mHasMore = false;
    private boolean kKK = false;
    private boolean fPX = false;
    private ArrayList<ProgressBar> kKL = new ArrayList<>();

    public void cTk() {
        if (this.kKL != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.kKL.size()) {
                    try {
                        this.kKL.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.kKL.clear();
                    return;
                }
            }
        }
    }

    public void byU() {
        this.fPX = false;
        if (this.dQf != null && this.dQf.size() == 0) {
            this.fPX = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void tk(boolean z) {
        this.kKK = z;
    }

    public d(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.kKJ = null;
        this.fPZ = true;
        this.mPageType = 0;
        this.jLs = null;
        this.jKM = null;
        this.kKJ = personFriendActivity;
        this.fPZ = z;
        this.mPageType = i;
        this.jLs = onClickListener;
        this.jKM = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.dQf = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fPX) {
            return 1;
        }
        int i = 0;
        if (this.dQf != null) {
            i = this.dQf.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dQf == null || i >= this.dQf.size()) {
            return null;
        }
        return this.dQf.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.dQf == null || i >= this.dQf.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.dQf != null) {
            if (view == null) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.kKJ.getPageContext().getPageActivity()).inflate(R.layout.person_list_item_friend, (ViewGroup) null);
                    aVar2.hDg = (HeadImageView) inflate.findViewById(R.id.photo);
                    aVar2.hDg.setIsRound(false);
                    aVar2.hDg.setAutoChangeStyle(true);
                    aVar2.fRd = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.fQb = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.fBh = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.kKM = (ImageView) inflate.findViewById(R.id.chat);
                    aVar2.iZT = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    aVar2.kKM.setOnClickListener(this.jLs);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.kKJ.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(R.id.pb_more_text);
                    inflate2.setOnClickListener(this.jKM);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(R.id.progress);
                    this.kKL.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.fPX) {
                    aVar.fRd.setVisibility(8);
                    aVar.kKM.setVisibility(8);
                    aVar.fQb.setVisibility(8);
                    aVar.iZT.setVisibility(8);
                } else {
                    if (!this.fPZ && this.mPageType == 0) {
                        aVar.kKM.setVisibility(8);
                    } else {
                        aVar.kKM.setVisibility(0);
                    }
                    aVar.fRd.setVisibility(0);
                    aVar.fRd.setTag(Integer.valueOf(i));
                    aVar.iZT.setVisibility(0);
                    aVar.fQb.setVisibility(8);
                    String portrait = this.dQf.get(i).getPortrait();
                    aVar.hDg.setImageDrawable(null);
                    aVar.hDg.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.dQf.get(i).getName_show());
                    aVar.fBh.setText(this.dQf.get(i).getIntro());
                    aVar.kKM.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.kKJ.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            cg(view);
        }
        return view;
    }

    private void cg(View view) {
        this.kKJ.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.kKJ.getLayoutMode().onModeChanged(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fPX) {
            return 0;
        }
        return (this.dQf == null || i >= this.dQf.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fPX) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes11.dex */
    private class a {
        TextView fBh;
        TextView fQb;
        LinearLayout fRd;
        HeadImageView hDg;
        ImageView iZT;
        ImageView kKM;
        TextView mName;
        ProgressBar mProgress;

        private a() {
        }
    }
}
