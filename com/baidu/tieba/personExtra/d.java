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
    private boolean eLS;
    private View.OnClickListener irD;
    private View.OnClickListener isj;
    private PersonFriendActivity jlU;
    private int mPageType;
    private ArrayList<UserData> cVS = null;
    private boolean mHasMore = false;
    private boolean jlV = false;
    private boolean eLQ = false;
    private ArrayList<ProgressBar> jlW = new ArrayList<>();

    public void cwB() {
        if (this.jlW != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.jlW.size()) {
                    try {
                        this.jlW.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.jlW.clear();
                    return;
                }
            }
        }
    }

    public void bgK() {
        this.eLQ = false;
        if (this.cVS != null && this.cVS.size() == 0) {
            this.eLQ = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void ro(boolean z) {
        this.jlV = z;
    }

    public d(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.jlU = null;
        this.eLS = true;
        this.mPageType = 0;
        this.isj = null;
        this.irD = null;
        this.jlU = personFriendActivity;
        this.eLS = z;
        this.mPageType = i;
        this.isj = onClickListener;
        this.irD = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.cVS = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eLQ) {
            return 1;
        }
        int i = 0;
        if (this.cVS != null) {
            i = this.cVS.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cVS == null || i >= this.cVS.size()) {
            return null;
        }
        return this.cVS.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.cVS == null || i >= this.cVS.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.cVS != null) {
            if (view == null) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.jlU.getPageContext().getPageActivity()).inflate(R.layout.person_list_item_friend, (ViewGroup) null);
                    aVar2.grw = (HeadImageView) inflate.findViewById(R.id.photo);
                    aVar2.grw.setIsRound(false);
                    aVar2.grw.setAutoChangeStyle(true);
                    aVar2.eMW = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.eLU = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.exA = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.jlX = (ImageView) inflate.findViewById(R.id.chat);
                    aVar2.hIb = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    aVar2.jlX.setOnClickListener(this.isj);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.jlU.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(R.id.pb_more_text);
                    inflate2.setOnClickListener(this.irD);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(R.id.progress);
                    this.jlW.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.eLQ) {
                    aVar.eMW.setVisibility(8);
                    aVar.jlX.setVisibility(8);
                    aVar.eLU.setVisibility(8);
                    aVar.hIb.setVisibility(8);
                } else {
                    if (!this.eLS && this.mPageType == 0) {
                        aVar.jlX.setVisibility(8);
                    } else {
                        aVar.jlX.setVisibility(0);
                    }
                    aVar.eMW.setVisibility(0);
                    aVar.eMW.setTag(Integer.valueOf(i));
                    aVar.hIb.setVisibility(0);
                    aVar.eLU.setVisibility(8);
                    String portrait = this.cVS.get(i).getPortrait();
                    aVar.grw.setImageDrawable(null);
                    aVar.grw.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.cVS.get(i).getName_show());
                    aVar.exA.setText(this.cVS.get(i).getIntro());
                    aVar.jlX.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.jlU.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            bX(view);
        }
        return view;
    }

    private void bX(View view) {
        this.jlU.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.jlU.getLayoutMode().onModeChanged(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.eLQ) {
            return 0;
        }
        return (this.cVS == null || i >= this.cVS.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.eLQ) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes11.dex */
    private class a {
        TextView eLU;
        LinearLayout eMW;
        TextView exA;
        HeadImageView grw;
        ImageView hIb;
        ImageView jlX;
        TextView mName;
        ProgressBar mProgress;

        private a() {
        }
    }
}
