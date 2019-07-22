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
    private boolean fYQ;
    private View.OnClickListener hxK;
    private View.OnClickListener hxh;
    private PersonFriendActivity iod;
    private int mPageType;
    private ArrayList<UserData> aIn = null;
    private boolean mHasMore = false;
    private boolean ioe = false;
    private boolean hxf = false;
    private ArrayList<ProgressBar> iof = new ArrayList<>();

    public void ccu() {
        if (this.iof != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.iof.size()) {
                    try {
                        this.iof.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.iof.clear();
                    return;
                }
            }
        }
    }

    public void bPk() {
        this.hxf = false;
        if (this.aIn != null && this.aIn.size() == 0) {
            this.hxf = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void pJ(boolean z) {
        this.ioe = z;
    }

    public d(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.iod = null;
        this.fYQ = true;
        this.mPageType = 0;
        this.hxK = null;
        this.hxh = null;
        this.iod = personFriendActivity;
        this.fYQ = z;
        this.mPageType = i;
        this.hxK = onClickListener;
        this.hxh = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.aIn = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hxf) {
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
                    View inflate = LayoutInflater.from(this.iod.getPageContext().getPageActivity()).inflate(R.layout.person_list_item_friend, (ViewGroup) null);
                    aVar2.eef = (HeadImageView) inflate.findViewById(R.id.photo);
                    aVar2.eef.setIsRound(false);
                    aVar2.eef.setAutoChangeStyle(true);
                    aVar2.dzu = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.hxm = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.dzt = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.iog = (ImageView) inflate.findViewById(R.id.chat);
                    aVar2.gOl = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    aVar2.iog.setOnClickListener(this.hxK);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.iod.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(R.id.pb_more_text);
                    inflate2.setOnClickListener(this.hxh);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(R.id.progress);
                    this.iof.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.hxf) {
                    aVar.dzu.setVisibility(8);
                    aVar.iog.setVisibility(8);
                    aVar.hxm.setVisibility(8);
                    aVar.gOl.setVisibility(8);
                } else {
                    if (!this.fYQ && this.mPageType == 0) {
                        aVar.iog.setVisibility(8);
                    } else {
                        aVar.iog.setVisibility(0);
                    }
                    aVar.dzu.setVisibility(0);
                    aVar.dzu.setTag(Integer.valueOf(i));
                    aVar.gOl.setVisibility(0);
                    aVar.hxm.setVisibility(8);
                    String portrait = this.aIn.get(i).getPortrait();
                    aVar.eef.setImageDrawable(null);
                    aVar.eef.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.aIn.get(i).getName_show());
                    aVar.dzt.setText(this.aIn.get(i).getIntro());
                    aVar.iog.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.iod.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            bZ(view);
        }
        return view;
    }

    private void bZ(View view) {
        this.iod.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.iod.getLayoutMode().onModeChanged(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.hxf) {
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
        if (this.hxf) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes6.dex */
    private class a {
        TextView dzt;
        LinearLayout dzu;
        HeadImageView eef;
        ImageView gOl;
        TextView hxm;
        ImageView iog;
        TextView mName;
        ProgressBar mProgress;

        private a() {
        }
    }
}
