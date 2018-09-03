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
import com.baidu.tieba.f;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c extends BaseAdapter {
    private boolean dPJ;
    private PersonFriendActivity fYx;
    private View.OnClickListener fiz;
    private View.OnClickListener fjc;
    private int mPageType;
    private ArrayList<UserData> als = null;
    private boolean mHasMore = false;
    private boolean fYy = false;
    private boolean fiw = false;
    private ArrayList<ProgressBar> fYz = new ArrayList<>();

    public void biI() {
        if (this.fYz != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.fYz.size()) {
                    try {
                        this.fYz.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.fYz.clear();
                    return;
                }
            }
        }
    }

    public void aWl() {
        this.fiw = false;
        if (this.als != null && this.als.size() == 0) {
            this.fiw = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void le(boolean z) {
        this.fYy = z;
    }

    public c(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.fYx = null;
        this.dPJ = true;
        this.mPageType = 0;
        this.fjc = null;
        this.fiz = null;
        this.fYx = personFriendActivity;
        this.dPJ = z;
        this.mPageType = i;
        this.fjc = onClickListener;
        this.fiz = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.als = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fiw) {
            return 1;
        }
        int i = 0;
        if (this.als != null) {
            i = this.als.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.als == null || i >= this.als.size()) {
            return null;
        }
        return this.als.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.als == null || i >= this.als.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.als != null) {
            if (view == null) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.fYx.getPageContext().getPageActivity()).inflate(f.h.person_list_item_friend, (ViewGroup) null);
                    aVar2.doX = (HeadImageView) inflate.findViewById(f.g.photo);
                    aVar2.doX.setIsRound(false);
                    aVar2.doX.setAutoChangeStyle(true);
                    aVar2.bDd = (LinearLayout) inflate.findViewById(f.g.info);
                    aVar2.mName = (TextView) inflate.findViewById(f.g.name);
                    aVar2.fiE = (TextView) inflate.findViewById(f.g.at_list_nodata);
                    aVar2.bDc = (TextView) inflate.findViewById(f.g.intro);
                    aVar2.fYA = (ImageView) inflate.findViewById(f.g.chat);
                    aVar2.eAe = (ImageView) inflate.findViewById(f.g.diver_buttom_px);
                    aVar2.fYA.setOnClickListener(this.fjc);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.fYx.getPageContext().getPageActivity()).inflate(f.h.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(f.g.pb_more_text);
                    inflate2.setOnClickListener(this.fiz);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(f.g.progress);
                    this.fYz.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.fiw) {
                    aVar.bDd.setVisibility(8);
                    aVar.fYA.setVisibility(8);
                    aVar.fiE.setVisibility(8);
                    aVar.eAe.setVisibility(8);
                } else {
                    if (!this.dPJ && this.mPageType == 0) {
                        aVar.fYA.setVisibility(8);
                    } else {
                        aVar.fYA.setVisibility(0);
                    }
                    aVar.bDd.setVisibility(0);
                    aVar.bDd.setTag(Integer.valueOf(i));
                    aVar.eAe.setVisibility(0);
                    aVar.fiE.setVisibility(8);
                    String portrait = this.als.get(i).getPortrait();
                    aVar.doX.setImageDrawable(null);
                    aVar.doX.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.als.get(i).getName_show());
                    aVar.bDc.setText(this.als.get(i).getIntro());
                    aVar.fYA.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.fYx.getPageContext().getString(f.j.loading));
                aVar.mProgress.setVisibility(0);
            }
            aI(view);
        }
        return view;
    }

    private void aI(View view) {
        this.fYx.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.fYx.getLayoutMode().onModeChanged(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fiw) {
            return 0;
        }
        return (this.als == null || i >= this.als.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fiw) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes3.dex */
    private class a {
        TextView bDc;
        LinearLayout bDd;
        HeadImageView doX;
        ImageView eAe;
        ImageView fYA;
        TextView fiE;
        TextView mName;
        ProgressBar mProgress;

        private a() {
        }
    }
}
