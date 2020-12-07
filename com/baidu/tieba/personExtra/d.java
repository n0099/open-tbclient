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
    private boolean gZr;
    private View.OnClickListener lmH;
    private View.OnClickListener lnp;
    private int mPageType;
    private PersonFriendActivity moL;
    private ArrayList<UserData> eOt = null;
    private boolean mHasMore = false;
    private boolean moM = false;
    private boolean gZp = false;
    private ArrayList<ProgressBar> moN = new ArrayList<>();

    public void dzP() {
        if (this.moN != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.moN.size()) {
                    try {
                        this.moN.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.moN.clear();
                    return;
                }
            }
        }
    }

    public void bYC() {
        this.gZp = false;
        if (this.eOt != null && this.eOt.size() == 0) {
            this.gZp = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void wy(boolean z) {
        this.moM = z;
    }

    public d(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.moL = null;
        this.gZr = true;
        this.mPageType = 0;
        this.lnp = null;
        this.lmH = null;
        this.moL = personFriendActivity;
        this.gZr = z;
        this.mPageType = i;
        this.lnp = onClickListener;
        this.lmH = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.eOt = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gZp) {
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
                    View inflate = LayoutInflater.from(this.moL.getPageContext().getPageActivity()).inflate(R.layout.person_list_item_friend, (ViewGroup) null);
                    aVar2.kjR = (HeadImageView) inflate.findViewById(R.id.photo);
                    aVar2.kjR.setIsRound(false);
                    aVar2.kjR.setAutoChangeStyle(true);
                    aVar2.hau = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.gZt = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.gFz = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.moO = (ImageView) inflate.findViewById(R.id.chat);
                    aVar2.kBw = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    aVar2.moO.setOnClickListener(this.lnp);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.moL.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(R.id.pb_more_text);
                    inflate2.setOnClickListener(this.lmH);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(R.id.progress);
                    this.moN.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.gZp) {
                    aVar.hau.setVisibility(8);
                    aVar.moO.setVisibility(8);
                    aVar.gZt.setVisibility(8);
                    aVar.kBw.setVisibility(8);
                } else {
                    if (!this.gZr && this.mPageType == 0) {
                        aVar.moO.setVisibility(8);
                    } else {
                        aVar.moO.setVisibility(0);
                    }
                    aVar.hau.setVisibility(0);
                    aVar.hau.setTag(Integer.valueOf(i));
                    aVar.kBw.setVisibility(0);
                    aVar.gZt.setVisibility(8);
                    String portrait = this.eOt.get(i).getPortrait();
                    aVar.kjR.setImageDrawable(null);
                    aVar.kjR.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.eOt.get(i).getName_show());
                    aVar.gFz.setText(this.eOt.get(i).getIntro());
                    aVar.moO.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.moL.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            cV(view);
        }
        return view;
    }

    private void cV(View view) {
        this.moL.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.moL.getLayoutMode().onModeChanged(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.gZp) {
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
        if (this.gZp) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes24.dex */
    private class a {
        TextView gFz;
        TextView gZt;
        LinearLayout hau;
        ImageView kBw;
        HeadImageView kjR;
        TextView mName;
        ProgressBar mProgress;
        ImageView moO;

        private a() {
        }
    }
}
