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
    private boolean fEQ;
    private View.OnClickListener jtv;
    private View.OnClickListener jub;
    private PersonFriendActivity kqL;
    private int mPageType;
    private ArrayList<UserData> dJp = null;
    private boolean mHasMore = false;
    private boolean kqM = false;
    private boolean fEO = false;
    private ArrayList<ProgressBar> kqN = new ArrayList<>();

    public void cOS() {
        if (this.kqN != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.kqN.size()) {
                    try {
                        this.kqN.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.kqN.clear();
                    return;
                }
            }
        }
    }

    public void bvY() {
        this.fEO = false;
        if (this.dJp != null && this.dJp.size() == 0) {
            this.fEO = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void sW(boolean z) {
        this.kqM = z;
    }

    public d(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.kqL = null;
        this.fEQ = true;
        this.mPageType = 0;
        this.jub = null;
        this.jtv = null;
        this.kqL = personFriendActivity;
        this.fEQ = z;
        this.mPageType = i;
        this.jub = onClickListener;
        this.jtv = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.dJp = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fEO) {
            return 1;
        }
        int i = 0;
        if (this.dJp != null) {
            i = this.dJp.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dJp == null || i >= this.dJp.size()) {
            return null;
        }
        return this.dJp.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.dJp == null || i >= this.dJp.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.dJp != null) {
            if (view == null) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.kqL.getPageContext().getPageActivity()).inflate(R.layout.person_list_item_friend, (ViewGroup) null);
                    aVar2.hqx = (HeadImageView) inflate.findViewById(R.id.photo);
                    aVar2.hqx.setIsRound(false);
                    aVar2.hqx.setAutoChangeStyle(true);
                    aVar2.fFU = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.fES = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.fpW = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.kqO = (ImageView) inflate.findViewById(R.id.chat);
                    aVar2.iIQ = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    aVar2.kqO.setOnClickListener(this.jub);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.kqL.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(R.id.pb_more_text);
                    inflate2.setOnClickListener(this.jtv);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(R.id.progress);
                    this.kqN.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.fEO) {
                    aVar.fFU.setVisibility(8);
                    aVar.kqO.setVisibility(8);
                    aVar.fES.setVisibility(8);
                    aVar.iIQ.setVisibility(8);
                } else {
                    if (!this.fEQ && this.mPageType == 0) {
                        aVar.kqO.setVisibility(8);
                    } else {
                        aVar.kqO.setVisibility(0);
                    }
                    aVar.fFU.setVisibility(0);
                    aVar.fFU.setTag(Integer.valueOf(i));
                    aVar.iIQ.setVisibility(0);
                    aVar.fES.setVisibility(8);
                    String portrait = this.dJp.get(i).getPortrait();
                    aVar.hqx.setImageDrawable(null);
                    aVar.hqx.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.dJp.get(i).getName_show());
                    aVar.fpW.setText(this.dJp.get(i).getIntro());
                    aVar.kqO.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.kqL.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            cf(view);
        }
        return view;
    }

    private void cf(View view) {
        this.kqL.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.kqL.getLayoutMode().onModeChanged(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fEO) {
            return 0;
        }
        return (this.dJp == null || i >= this.dJp.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fEO) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes11.dex */
    private class a {
        TextView fES;
        LinearLayout fFU;
        TextView fpW;
        HeadImageView hqx;
        ImageView iIQ;
        ImageView kqO;
        TextView mName;
        ProgressBar mProgress;

        private a() {
        }
    }
}
