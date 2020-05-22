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
    private boolean fEF;
    private View.OnClickListener jsV;
    private View.OnClickListener jsp;
    private PersonFriendActivity kpF;
    private int mPageType;
    private ArrayList<UserData> dJp = null;
    private boolean mHasMore = false;
    private boolean kpG = false;
    private boolean fED = false;
    private ArrayList<ProgressBar> kpH = new ArrayList<>();

    public void cOC() {
        if (this.kpH != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.kpH.size()) {
                    try {
                        this.kpH.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.kpH.clear();
                    return;
                }
            }
        }
    }

    public void bvW() {
        this.fED = false;
        if (this.dJp != null && this.dJp.size() == 0) {
            this.fED = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void sW(boolean z) {
        this.kpG = z;
    }

    public d(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.kpF = null;
        this.fEF = true;
        this.mPageType = 0;
        this.jsV = null;
        this.jsp = null;
        this.kpF = personFriendActivity;
        this.fEF = z;
        this.mPageType = i;
        this.jsV = onClickListener;
        this.jsp = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.dJp = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fED) {
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
                    View inflate = LayoutInflater.from(this.kpF.getPageContext().getPageActivity()).inflate(R.layout.person_list_item_friend, (ViewGroup) null);
                    aVar2.hqm = (HeadImageView) inflate.findViewById(R.id.photo);
                    aVar2.hqm.setIsRound(false);
                    aVar2.hqm.setAutoChangeStyle(true);
                    aVar2.fFJ = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.fEH = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.fpL = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.kpI = (ImageView) inflate.findViewById(R.id.chat);
                    aVar2.iId = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    aVar2.kpI.setOnClickListener(this.jsV);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.kpF.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(R.id.pb_more_text);
                    inflate2.setOnClickListener(this.jsp);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(R.id.progress);
                    this.kpH.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.fED) {
                    aVar.fFJ.setVisibility(8);
                    aVar.kpI.setVisibility(8);
                    aVar.fEH.setVisibility(8);
                    aVar.iId.setVisibility(8);
                } else {
                    if (!this.fEF && this.mPageType == 0) {
                        aVar.kpI.setVisibility(8);
                    } else {
                        aVar.kpI.setVisibility(0);
                    }
                    aVar.fFJ.setVisibility(0);
                    aVar.fFJ.setTag(Integer.valueOf(i));
                    aVar.iId.setVisibility(0);
                    aVar.fEH.setVisibility(8);
                    String portrait = this.dJp.get(i).getPortrait();
                    aVar.hqm.setImageDrawable(null);
                    aVar.hqm.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.dJp.get(i).getName_show());
                    aVar.fpL.setText(this.dJp.get(i).getIntro());
                    aVar.kpI.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.kpF.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            cf(view);
        }
        return view;
    }

    private void cf(View view) {
        this.kpF.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.kpF.getLayoutMode().onModeChanged(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fED) {
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
        if (this.fED) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes11.dex */
    private class a {
        TextView fEH;
        LinearLayout fFJ;
        TextView fpL;
        HeadImageView hqm;
        ImageView iId;
        ImageView kpI;
        TextView mName;
        ProgressBar mProgress;

        private a() {
        }
    }
}
