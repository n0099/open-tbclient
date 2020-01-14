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
/* loaded from: classes9.dex */
public class d extends BaseAdapter {
    private boolean eHK;
    private View.OnClickListener ipu;
    private View.OnClickListener iqa;
    private PersonFriendActivity jkN;
    private int mPageType;
    private ArrayList<UserData> cRO = null;
    private boolean mHasMore = false;
    private boolean jkO = false;
    private boolean eHI = false;
    private ArrayList<ProgressBar> jkP = new ArrayList<>();

    public void cvf() {
        if (this.jkP != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.jkP.size()) {
                    try {
                        this.jkP.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.jkP.clear();
                    return;
                }
            }
        }
    }

    public void bex() {
        this.eHI = false;
        if (this.cRO != null && this.cRO.size() == 0) {
            this.eHI = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void rk(boolean z) {
        this.jkO = z;
    }

    public d(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.jkN = null;
        this.eHK = true;
        this.mPageType = 0;
        this.iqa = null;
        this.ipu = null;
        this.jkN = personFriendActivity;
        this.eHK = z;
        this.mPageType = i;
        this.iqa = onClickListener;
        this.ipu = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.cRO = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eHI) {
            return 1;
        }
        int i = 0;
        if (this.cRO != null) {
            i = this.cRO.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cRO == null || i >= this.cRO.size()) {
            return null;
        }
        return this.cRO.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.cRO == null || i >= this.cRO.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.cRO != null) {
            if (view == null) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.jkN.getPageContext().getPageActivity()).inflate(R.layout.person_list_item_friend, (ViewGroup) null);
                    aVar2.gpg = (HeadImageView) inflate.findViewById(R.id.photo);
                    aVar2.gpg.setIsRound(false);
                    aVar2.gpg.setAutoChangeStyle(true);
                    aVar2.eIO = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.eHM = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.etb = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.jkQ = (ImageView) inflate.findViewById(R.id.chat);
                    aVar2.hFO = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    aVar2.jkQ.setOnClickListener(this.iqa);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.jkN.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(R.id.pb_more_text);
                    inflate2.setOnClickListener(this.ipu);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(R.id.progress);
                    this.jkP.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.eHI) {
                    aVar.eIO.setVisibility(8);
                    aVar.jkQ.setVisibility(8);
                    aVar.eHM.setVisibility(8);
                    aVar.hFO.setVisibility(8);
                } else {
                    if (!this.eHK && this.mPageType == 0) {
                        aVar.jkQ.setVisibility(8);
                    } else {
                        aVar.jkQ.setVisibility(0);
                    }
                    aVar.eIO.setVisibility(0);
                    aVar.eIO.setTag(Integer.valueOf(i));
                    aVar.hFO.setVisibility(0);
                    aVar.eHM.setVisibility(8);
                    String portrait = this.cRO.get(i).getPortrait();
                    aVar.gpg.setImageDrawable(null);
                    aVar.gpg.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.cRO.get(i).getName_show());
                    aVar.etb.setText(this.cRO.get(i).getIntro());
                    aVar.jkQ.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.jkN.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            bX(view);
        }
        return view;
    }

    private void bX(View view) {
        this.jkN.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.jkN.getLayoutMode().onModeChanged(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.eHI) {
            return 0;
        }
        return (this.cRO == null || i >= this.cRO.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.eHI) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes9.dex */
    private class a {
        TextView eHM;
        LinearLayout eIO;
        TextView etb;
        HeadImageView gpg;
        ImageView hFO;
        ImageView jkQ;
        TextView mName;
        ProgressBar mProgress;

        private a() {
        }
    }
}
