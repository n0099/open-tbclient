package com.baidu.tieba.person;

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
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bf extends BaseAdapter {
    private boolean bDM;
    private View.OnClickListener byd;
    private PersonFriendActivity cYU;
    private View.OnClickListener cYW;
    private int mPageType;
    private ArrayList<UserData> YX = null;
    private boolean mHasMore = false;
    private boolean cYV = false;
    private boolean cES = false;
    private ArrayList<ProgressBar> cGb = new ArrayList<>();

    public void anm() {
        if (this.cGb != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.cGb.size()) {
                    try {
                        this.cGb.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.cGb.clear();
                    return;
                }
            }
        }
    }

    public void ann() {
        this.cES = false;
        if (this.YX != null && this.YX.size() == 0) {
            this.cES = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void fS(boolean z) {
        this.cYV = z;
    }

    public bf(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.cYU = null;
        this.bDM = true;
        this.mPageType = 0;
        this.cYW = null;
        this.byd = null;
        this.cYU = personFriendActivity;
        this.bDM = z;
        this.mPageType = i;
        this.cYW = onClickListener;
        this.byd = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.YX = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cES) {
            return 1;
        }
        int i = 0;
        if (this.YX != null) {
            i = this.YX.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.YX == null || i >= this.YX.size()) {
            return null;
        }
        return this.YX.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.YX == null || i >= this.YX.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.YX != null) {
            if (view == null) {
                a aVar2 = new a(this, null);
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.cYU.getPageContext().getPageActivity()).inflate(t.h.person_list_item_friend, (ViewGroup) null);
                    aVar2.beU = (HeadImageView) inflate.findViewById(t.g.photo);
                    aVar2.beU.setIsRound(false);
                    aVar2.beU.setAutoChangeStyle(true);
                    aVar2.cYY = (LinearLayout) inflate.findViewById(t.g.info);
                    aVar2.bPr = (TextView) inflate.findViewById(t.g.name);
                    aVar2.cYZ = (TextView) inflate.findViewById(t.g.at_list_nodata);
                    aVar2.bbT = (TextView) inflate.findViewById(t.g.intro);
                    aVar2.cYX = (ImageView) inflate.findViewById(t.g.chat);
                    aVar2.cdN = (ImageView) inflate.findViewById(t.g.diver_buttom_px);
                    aVar2.cYX.setOnClickListener(this.cYW);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.cYU.getPageContext().getPageActivity()).inflate(t.h.new_pb_list_more, (ViewGroup) null);
                    aVar2.bPr = (TextView) inflate2.findViewById(t.g.pb_more_text);
                    inflate2.setOnClickListener(this.byd);
                    aVar2.aNo = (ProgressBar) inflate2.findViewById(t.g.progress);
                    this.cGb.add(aVar2.aNo);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.cES) {
                    aVar.cYY.setVisibility(8);
                    aVar.cYX.setVisibility(8);
                    aVar.cYZ.setVisibility(8);
                    aVar.cdN.setVisibility(8);
                } else {
                    if (!this.bDM && this.mPageType == 0) {
                        aVar.cYX.setVisibility(8);
                    } else {
                        aVar.cYX.setVisibility(0);
                    }
                    aVar.cYY.setVisibility(0);
                    aVar.cYY.setTag(Integer.valueOf(i));
                    aVar.cdN.setVisibility(0);
                    aVar.cYZ.setVisibility(8);
                    String portrait = this.YX.get(i).getPortrait();
                    aVar.beU.setImageDrawable(null);
                    aVar.beU.d(portrait, 12, false);
                    aVar.bPr.setText(this.YX.get(i).getName_show());
                    aVar.bbT.setText(this.YX.get(i).getIntro());
                    aVar.cYX.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.bPr.setText(this.cYU.getPageContext().getString(t.j.loading));
                aVar.aNo.setVisibility(0);
            }
            u(view);
        }
        return view;
    }

    private void u(View view) {
        this.cYU.getLayoutMode().ac(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.cYU.getLayoutMode().x(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.cES) {
            return 0;
        }
        return (this.YX == null || i >= this.YX.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.cES) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes.dex */
    private class a {
        ProgressBar aNo;
        TextView bPr;
        TextView bbT;
        HeadImageView beU;
        ImageView cYX;
        LinearLayout cYY;
        TextView cYZ;
        ImageView cdN;

        private a() {
        }

        /* synthetic */ a(bf bfVar, a aVar) {
            this();
        }
    }
}
