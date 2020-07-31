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
/* loaded from: classes18.dex */
public class d extends BaseAdapter {
    private boolean fVs;
    private View.OnClickListener jTQ;
    private View.OnClickListener jTk;
    private PersonFriendActivity kTK;
    private int mPageType;
    private ArrayList<UserData> dWx = null;
    private boolean mHasMore = false;
    private boolean kTL = false;
    private boolean fVq = false;
    private ArrayList<ProgressBar> kTM = new ArrayList<>();

    public void cXa() {
        if (this.kTM != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.kTM.size()) {
                    try {
                        this.kTM.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.kTM.clear();
                    return;
                }
            }
        }
    }

    public void bCi() {
        this.fVq = false;
        if (this.dWx != null && this.dWx.size() == 0) {
            this.fVq = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void tQ(boolean z) {
        this.kTL = z;
    }

    public d(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.kTK = null;
        this.fVs = true;
        this.mPageType = 0;
        this.jTQ = null;
        this.jTk = null;
        this.kTK = personFriendActivity;
        this.fVs = z;
        this.mPageType = i;
        this.jTQ = onClickListener;
        this.jTk = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.dWx = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fVq) {
            return 1;
        }
        int i = 0;
        if (this.dWx != null) {
            i = this.dWx.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dWx == null || i >= this.dWx.size()) {
            return null;
        }
        return this.dWx.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.dWx == null || i >= this.dWx.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.dWx != null) {
            if (view == null) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.kTK.getPageContext().getPageActivity()).inflate(R.layout.person_list_item_friend, (ViewGroup) null);
                    aVar2.hJe = (HeadImageView) inflate.findViewById(R.id.photo);
                    aVar2.hJe.setIsRound(false);
                    aVar2.hJe.setAutoChangeStyle(true);
                    aVar2.fWw = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.fVu = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.fGr = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.kTN = (ImageView) inflate.findViewById(R.id.chat);
                    aVar2.jin = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    aVar2.kTN.setOnClickListener(this.jTQ);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.kTK.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(R.id.pb_more_text);
                    inflate2.setOnClickListener(this.jTk);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(R.id.progress);
                    this.kTM.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.fVq) {
                    aVar.fWw.setVisibility(8);
                    aVar.kTN.setVisibility(8);
                    aVar.fVu.setVisibility(8);
                    aVar.jin.setVisibility(8);
                } else {
                    if (!this.fVs && this.mPageType == 0) {
                        aVar.kTN.setVisibility(8);
                    } else {
                        aVar.kTN.setVisibility(0);
                    }
                    aVar.fWw.setVisibility(0);
                    aVar.fWw.setTag(Integer.valueOf(i));
                    aVar.jin.setVisibility(0);
                    aVar.fVu.setVisibility(8);
                    String portrait = this.dWx.get(i).getPortrait();
                    aVar.hJe.setImageDrawable(null);
                    aVar.hJe.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.dWx.get(i).getName_show());
                    aVar.fGr.setText(this.dWx.get(i).getIntro());
                    aVar.kTN.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.kTK.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            cm(view);
        }
        return view;
    }

    private void cm(View view) {
        this.kTK.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.kTK.getLayoutMode().onModeChanged(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fVq) {
            return 0;
        }
        return (this.dWx == null || i >= this.dWx.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fVq) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes18.dex */
    private class a {
        TextView fGr;
        TextView fVu;
        LinearLayout fWw;
        HeadImageView hJe;
        ImageView jin;
        ImageView kTN;
        TextView mName;
        ProgressBar mProgress;

        private a() {
        }
    }
}
