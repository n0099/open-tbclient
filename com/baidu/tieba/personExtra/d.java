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
    private View.OnClickListener jTS;
    private View.OnClickListener jTm;
    private PersonFriendActivity kTM;
    private int mPageType;
    private ArrayList<UserData> dWx = null;
    private boolean mHasMore = false;
    private boolean kTN = false;
    private boolean fVq = false;
    private ArrayList<ProgressBar> kTO = new ArrayList<>();

    public void cXa() {
        if (this.kTO != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.kTO.size()) {
                    try {
                        this.kTO.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.kTO.clear();
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
        this.kTN = z;
    }

    public d(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.kTM = null;
        this.fVs = true;
        this.mPageType = 0;
        this.jTS = null;
        this.jTm = null;
        this.kTM = personFriendActivity;
        this.fVs = z;
        this.mPageType = i;
        this.jTS = onClickListener;
        this.jTm = onClickListener2;
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
                    View inflate = LayoutInflater.from(this.kTM.getPageContext().getPageActivity()).inflate(R.layout.person_list_item_friend, (ViewGroup) null);
                    aVar2.hJe = (HeadImageView) inflate.findViewById(R.id.photo);
                    aVar2.hJe.setIsRound(false);
                    aVar2.hJe.setAutoChangeStyle(true);
                    aVar2.fWw = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.fVu = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.fGr = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.kTP = (ImageView) inflate.findViewById(R.id.chat);
                    aVar2.jip = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    aVar2.kTP.setOnClickListener(this.jTS);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.kTM.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(R.id.pb_more_text);
                    inflate2.setOnClickListener(this.jTm);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(R.id.progress);
                    this.kTO.add(aVar2.mProgress);
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
                    aVar.kTP.setVisibility(8);
                    aVar.fVu.setVisibility(8);
                    aVar.jip.setVisibility(8);
                } else {
                    if (!this.fVs && this.mPageType == 0) {
                        aVar.kTP.setVisibility(8);
                    } else {
                        aVar.kTP.setVisibility(0);
                    }
                    aVar.fWw.setVisibility(0);
                    aVar.fWw.setTag(Integer.valueOf(i));
                    aVar.jip.setVisibility(0);
                    aVar.fVu.setVisibility(8);
                    String portrait = this.dWx.get(i).getPortrait();
                    aVar.hJe.setImageDrawable(null);
                    aVar.hJe.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.dWx.get(i).getName_show());
                    aVar.fGr.setText(this.dWx.get(i).getIntro());
                    aVar.kTP.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.kTM.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            cm(view);
        }
        return view;
    }

    private void cm(View view) {
        this.kTM.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.kTM.getLayoutMode().onModeChanged(view);
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
        ImageView jip;
        ImageView kTP;
        TextView mName;
        ProgressBar mProgress;

        private a() {
        }
    }
}
