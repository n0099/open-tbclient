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
    private boolean gbx;
    private View.OnClickListener hAy;
    private View.OnClickListener hzV;
    private PersonFriendActivity irg;
    private int mPageType;
    private ArrayList<UserData> aIL = null;
    private boolean mHasMore = false;
    private boolean irh = false;
    private boolean hzT = false;
    private ArrayList<ProgressBar> iri = new ArrayList<>();

    public void cdA() {
        if (this.iri != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.iri.size()) {
                    try {
                        this.iri.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.iri.clear();
                    return;
                }
            }
        }
    }

    public void bQm() {
        this.hzT = false;
        if (this.aIL != null && this.aIL.size() == 0) {
            this.hzT = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void pN(boolean z) {
        this.irh = z;
    }

    public d(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.irg = null;
        this.gbx = true;
        this.mPageType = 0;
        this.hAy = null;
        this.hzV = null;
        this.irg = personFriendActivity;
        this.gbx = z;
        this.mPageType = i;
        this.hAy = onClickListener;
        this.hzV = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.aIL = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hzT) {
            return 1;
        }
        int i = 0;
        if (this.aIL != null) {
            i = this.aIL.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aIL == null || i >= this.aIL.size()) {
            return null;
        }
        return this.aIL.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.aIL == null || i >= this.aIL.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.aIL != null) {
            if (view == null) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.irg.getPageContext().getPageActivity()).inflate(R.layout.person_list_item_friend, (ViewGroup) null);
                    aVar2.efW = (HeadImageView) inflate.findViewById(R.id.photo);
                    aVar2.efW.setIsRound(false);
                    aVar2.efW.setAutoChangeStyle(true);
                    aVar2.dBm = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.hAa = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.dBl = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.irj = (ImageView) inflate.findViewById(R.id.chat);
                    aVar2.gQX = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    aVar2.irj.setOnClickListener(this.hAy);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.irg.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(R.id.pb_more_text);
                    inflate2.setOnClickListener(this.hzV);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(R.id.progress);
                    this.iri.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.hzT) {
                    aVar.dBm.setVisibility(8);
                    aVar.irj.setVisibility(8);
                    aVar.hAa.setVisibility(8);
                    aVar.gQX.setVisibility(8);
                } else {
                    if (!this.gbx && this.mPageType == 0) {
                        aVar.irj.setVisibility(8);
                    } else {
                        aVar.irj.setVisibility(0);
                    }
                    aVar.dBm.setVisibility(0);
                    aVar.dBm.setTag(Integer.valueOf(i));
                    aVar.gQX.setVisibility(0);
                    aVar.hAa.setVisibility(8);
                    String portrait = this.aIL.get(i).getPortrait();
                    aVar.efW.setImageDrawable(null);
                    aVar.efW.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.aIL.get(i).getName_show());
                    aVar.dBl.setText(this.aIL.get(i).getIntro());
                    aVar.irj.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.irg.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            ca(view);
        }
        return view;
    }

    private void ca(View view) {
        this.irg.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.irg.getLayoutMode().onModeChanged(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.hzT) {
            return 0;
        }
        return (this.aIL == null || i >= this.aIL.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.hzT) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes6.dex */
    private class a {
        TextView dBl;
        LinearLayout dBm;
        HeadImageView efW;
        ImageView gQX;
        TextView hAa;
        ImageView irj;
        TextView mName;
        ProgressBar mProgress;

        private a() {
        }
    }
}
