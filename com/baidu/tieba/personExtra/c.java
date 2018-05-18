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
    private boolean dyy;
    private View.OnClickListener eTI;
    private View.OnClickListener eTi;
    private PersonFriendActivity fII;
    private int mPageType;
    private ArrayList<UserData> adv = null;
    private boolean mHasMore = false;
    private boolean fIJ = false;
    private boolean eTg = false;
    private ArrayList<ProgressBar> fIK = new ArrayList<>();

    public void beM() {
        if (this.fIK != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.fIK.size()) {
                    try {
                        this.fIK.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.fIK.clear();
                    return;
                }
            }
        }
    }

    public void aSq() {
        this.eTg = false;
        if (this.adv != null && this.adv.size() == 0) {
            this.eTg = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void lc(boolean z) {
        this.fIJ = z;
    }

    public c(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.fII = null;
        this.dyy = true;
        this.mPageType = 0;
        this.eTI = null;
        this.eTi = null;
        this.fII = personFriendActivity;
        this.dyy = z;
        this.mPageType = i;
        this.eTI = onClickListener;
        this.eTi = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.adv = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eTg) {
            return 1;
        }
        int i = 0;
        if (this.adv != null) {
            i = this.adv.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.adv == null || i >= this.adv.size()) {
            return null;
        }
        return this.adv.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.adv == null || i >= this.adv.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        a aVar;
        View view3;
        if (this.adv != null) {
            if (view2 == null) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.fII.getPageContext().getPageActivity()).inflate(d.i.person_list_item_friend, (ViewGroup) null);
                    aVar2.daK = (HeadImageView) inflate.findViewById(d.g.photo);
                    aVar2.daK.setIsRound(false);
                    aVar2.daK.setAutoChangeStyle(true);
                    aVar2.bst = (LinearLayout) inflate.findViewById(d.g.info);
                    aVar2.mName = (TextView) inflate.findViewById(d.g.name);
                    aVar2.eTn = (TextView) inflate.findViewById(d.g.at_list_nodata);
                    aVar2.bss = (TextView) inflate.findViewById(d.g.intro);
                    aVar2.fIL = (ImageView) inflate.findViewById(d.g.chat);
                    aVar2.ehi = (ImageView) inflate.findViewById(d.g.diver_buttom_px);
                    aVar2.fIL.setOnClickListener(this.eTI);
                    view3 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.fII.getPageContext().getPageActivity()).inflate(d.i.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(d.g.pb_more_text);
                    inflate2.setOnClickListener(this.eTi);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(d.g.progress);
                    this.fIK.add(aVar2.mProgress);
                    view3 = inflate2;
                }
                view3.setTag(aVar2);
                aVar = aVar2;
                view2 = view3;
            } else {
                aVar = (a) view2.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.eTg) {
                    aVar.bst.setVisibility(8);
                    aVar.fIL.setVisibility(8);
                    aVar.eTn.setVisibility(8);
                    aVar.ehi.setVisibility(8);
                } else {
                    if (!this.dyy && this.mPageType == 0) {
                        aVar.fIL.setVisibility(8);
                    } else {
                        aVar.fIL.setVisibility(0);
                    }
                    aVar.bst.setVisibility(0);
                    aVar.bst.setTag(Integer.valueOf(i));
                    aVar.ehi.setVisibility(0);
                    aVar.eTn.setVisibility(8);
                    String portrait = this.adv.get(i).getPortrait();
                    aVar.daK.setImageDrawable(null);
                    aVar.daK.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.adv.get(i).getName_show());
                    aVar.bss.setText(this.adv.get(i).getIntro());
                    aVar.fIL.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.fII.getPageContext().getString(d.k.loading));
                aVar.mProgress.setVisibility(0);
            }
            aA(view2);
        }
        return view2;
    }

    private void aA(View view2) {
        this.fII.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.fII.getLayoutMode().u(view2);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.eTg) {
            return 0;
        }
        return (this.adv == null || i >= this.adv.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.eTg) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes3.dex */
    private class a {
        TextView bss;
        LinearLayout bst;
        HeadImageView daK;
        TextView eTn;
        ImageView ehi;
        ImageView fIL;
        TextView mName;
        ProgressBar mProgress;

        private a() {
        }
    }
}
