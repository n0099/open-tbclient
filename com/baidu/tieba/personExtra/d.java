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
    private boolean dRK;
    private View.OnClickListener hyI;
    private View.OnClickListener hzk;
    private PersonFriendActivity ipG;
    private int mPageType;
    private ArrayList<UserData> bbZ = null;
    private boolean mHasMore = false;
    private boolean ipH = false;
    private boolean dRI = false;
    private ArrayList<ProgressBar> ipI = new ArrayList<>();

    public void caB() {
        if (this.ipI != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.ipI.size()) {
                    try {
                        this.ipI.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.ipI.clear();
                    return;
                }
            }
        }
    }

    public void aMz() {
        this.dRI = false;
        if (this.bbZ != null && this.bbZ.size() == 0) {
            this.dRI = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void pv(boolean z) {
        this.ipH = z;
    }

    public d(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.ipG = null;
        this.dRK = true;
        this.mPageType = 0;
        this.hzk = null;
        this.hyI = null;
        this.ipG = personFriendActivity;
        this.dRK = z;
        this.mPageType = i;
        this.hzk = onClickListener;
        this.hyI = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.bbZ = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dRI) {
            return 1;
        }
        int i = 0;
        if (this.bbZ != null) {
            i = this.bbZ.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bbZ == null || i >= this.bbZ.size()) {
            return null;
        }
        return this.bbZ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.bbZ == null || i >= this.bbZ.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.bbZ != null) {
            if (view == null) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.ipG.getPageContext().getPageActivity()).inflate(R.layout.person_list_item_friend, (ViewGroup) null);
                    aVar2.fyr = (HeadImageView) inflate.findViewById(R.id.photo);
                    aVar2.fyr.setIsRound(false);
                    aVar2.fyr.setAutoChangeStyle(true);
                    aVar2.dSO = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.dRM = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.dGE = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.ipJ = (ImageView) inflate.findViewById(R.id.chat);
                    aVar2.gOY = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    aVar2.ipJ.setOnClickListener(this.hzk);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.ipG.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(R.id.pb_more_text);
                    inflate2.setOnClickListener(this.hyI);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(R.id.progress);
                    this.ipI.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.dRI) {
                    aVar.dSO.setVisibility(8);
                    aVar.ipJ.setVisibility(8);
                    aVar.dRM.setVisibility(8);
                    aVar.gOY.setVisibility(8);
                } else {
                    if (!this.dRK && this.mPageType == 0) {
                        aVar.ipJ.setVisibility(8);
                    } else {
                        aVar.ipJ.setVisibility(0);
                    }
                    aVar.dSO.setVisibility(0);
                    aVar.dSO.setTag(Integer.valueOf(i));
                    aVar.gOY.setVisibility(0);
                    aVar.dRM.setVisibility(8);
                    String portrait = this.bbZ.get(i).getPortrait();
                    aVar.fyr.setImageDrawable(null);
                    aVar.fyr.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.bbZ.get(i).getName_show());
                    aVar.dGE.setText(this.bbZ.get(i).getIntro());
                    aVar.ipJ.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.ipG.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            bX(view);
        }
        return view;
    }

    private void bX(View view) {
        this.ipG.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.ipG.getLayoutMode().onModeChanged(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.dRI) {
            return 0;
        }
        return (this.bbZ == null || i >= this.bbZ.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.dRI) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes6.dex */
    private class a {
        TextView dGE;
        TextView dRM;
        LinearLayout dSO;
        HeadImageView fyr;
        ImageView gOY;
        ImageView ipJ;
        TextView mName;
        ProgressBar mProgress;

        private a() {
        }
    }
}
