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
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c extends BaseAdapter {
    private boolean dNa;
    private PersonFriendActivity fYg;
    private View.OnClickListener fiW;
    private View.OnClickListener fis;
    private int mPageType;
    private ArrayList<UserData> alT = null;
    private boolean mHasMore = false;
    private boolean fYh = false;
    private boolean fiq = false;
    private ArrayList<ProgressBar> fYi = new ArrayList<>();

    public void bks() {
        if (this.fYi != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.fYi.size()) {
                    try {
                        this.fYi.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.fYi.clear();
                    return;
                }
            }
        }
    }

    public void aXU() {
        this.fiq = false;
        if (this.alT != null && this.alT.size() == 0) {
            this.fiq = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void ls(boolean z) {
        this.fYh = z;
    }

    public c(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.fYg = null;
        this.dNa = true;
        this.mPageType = 0;
        this.fiW = null;
        this.fis = null;
        this.fYg = personFriendActivity;
        this.dNa = z;
        this.mPageType = i;
        this.fiW = onClickListener;
        this.fis = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.alT = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fiq) {
            return 1;
        }
        int i = 0;
        if (this.alT != null) {
            i = this.alT.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.alT == null || i >= this.alT.size()) {
            return null;
        }
        return this.alT.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.alT == null || i >= this.alT.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.alT != null) {
            if (view == null) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.fYg.getPageContext().getPageActivity()).inflate(d.i.person_list_item_friend, (ViewGroup) null);
                    aVar2.dmh = (HeadImageView) inflate.findViewById(d.g.photo);
                    aVar2.dmh.setIsRound(false);
                    aVar2.dmh.setAutoChangeStyle(true);
                    aVar2.bCv = (LinearLayout) inflate.findViewById(d.g.info);
                    aVar2.mName = (TextView) inflate.findViewById(d.g.name);
                    aVar2.fiy = (TextView) inflate.findViewById(d.g.at_list_nodata);
                    aVar2.bCu = (TextView) inflate.findViewById(d.g.intro);
                    aVar2.fYj = (ImageView) inflate.findViewById(d.g.chat);
                    aVar2.ewp = (ImageView) inflate.findViewById(d.g.diver_buttom_px);
                    aVar2.fYj.setOnClickListener(this.fiW);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.fYg.getPageContext().getPageActivity()).inflate(d.i.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(d.g.pb_more_text);
                    inflate2.setOnClickListener(this.fis);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(d.g.progress);
                    this.fYi.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.fiq) {
                    aVar.bCv.setVisibility(8);
                    aVar.fYj.setVisibility(8);
                    aVar.fiy.setVisibility(8);
                    aVar.ewp.setVisibility(8);
                } else {
                    if (!this.dNa && this.mPageType == 0) {
                        aVar.fYj.setVisibility(8);
                    } else {
                        aVar.fYj.setVisibility(0);
                    }
                    aVar.bCv.setVisibility(0);
                    aVar.bCv.setTag(Integer.valueOf(i));
                    aVar.ewp.setVisibility(0);
                    aVar.fiy.setVisibility(8);
                    String portrait = this.alT.get(i).getPortrait();
                    aVar.dmh.setImageDrawable(null);
                    aVar.dmh.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.alT.get(i).getName_show());
                    aVar.bCu.setText(this.alT.get(i).getIntro());
                    aVar.fYj.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.fYg.getPageContext().getString(d.k.loading));
                aVar.mProgress.setVisibility(0);
            }
            aF(view);
        }
        return view;
    }

    private void aF(View view) {
        this.fYg.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.fYg.getLayoutMode().onModeChanged(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fiq) {
            return 0;
        }
        return (this.alT == null || i >= this.alT.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fiq) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes3.dex */
    private class a {
        TextView bCu;
        LinearLayout bCv;
        HeadImageView dmh;
        ImageView ewp;
        ImageView fYj;
        TextView fiy;
        TextView mName;
        ProgressBar mProgress;

        private a() {
        }
    }
}
