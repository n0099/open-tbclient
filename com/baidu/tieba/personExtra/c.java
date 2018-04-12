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
    private boolean dxu;
    private View.OnClickListener eSE;
    private View.OnClickListener eSe;
    private PersonFriendActivity fHF;
    private int mPageType;
    private ArrayList<UserData> adv = null;
    private boolean mHasMore = false;
    private boolean fHG = false;
    private boolean eSc = false;
    private ArrayList<ProgressBar> fHH = new ArrayList<>();

    public void beM() {
        if (this.fHH != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.fHH.size()) {
                    try {
                        this.fHH.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.fHH.clear();
                    return;
                }
            }
        }
    }

    public void aSq() {
        this.eSc = false;
        if (this.adv != null && this.adv.size() == 0) {
            this.eSc = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void lb(boolean z) {
        this.fHG = z;
    }

    public c(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.fHF = null;
        this.dxu = true;
        this.mPageType = 0;
        this.eSE = null;
        this.eSe = null;
        this.fHF = personFriendActivity;
        this.dxu = z;
        this.mPageType = i;
        this.eSE = onClickListener;
        this.eSe = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.adv = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eSc) {
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
                    View inflate = LayoutInflater.from(this.fHF.getPageContext().getPageActivity()).inflate(d.i.person_list_item_friend, (ViewGroup) null);
                    aVar2.cZE = (HeadImageView) inflate.findViewById(d.g.photo);
                    aVar2.cZE.setIsRound(false);
                    aVar2.cZE.setAutoChangeStyle(true);
                    aVar2.bse = (LinearLayout) inflate.findViewById(d.g.info);
                    aVar2.mName = (TextView) inflate.findViewById(d.g.name);
                    aVar2.eSj = (TextView) inflate.findViewById(d.g.at_list_nodata);
                    aVar2.bsd = (TextView) inflate.findViewById(d.g.intro);
                    aVar2.fHI = (ImageView) inflate.findViewById(d.g.chat);
                    aVar2.ege = (ImageView) inflate.findViewById(d.g.diver_buttom_px);
                    aVar2.fHI.setOnClickListener(this.eSE);
                    view3 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.fHF.getPageContext().getPageActivity()).inflate(d.i.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(d.g.pb_more_text);
                    inflate2.setOnClickListener(this.eSe);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(d.g.progress);
                    this.fHH.add(aVar2.mProgress);
                    view3 = inflate2;
                }
                view3.setTag(aVar2);
                aVar = aVar2;
                view2 = view3;
            } else {
                aVar = (a) view2.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.eSc) {
                    aVar.bse.setVisibility(8);
                    aVar.fHI.setVisibility(8);
                    aVar.eSj.setVisibility(8);
                    aVar.ege.setVisibility(8);
                } else {
                    if (!this.dxu && this.mPageType == 0) {
                        aVar.fHI.setVisibility(8);
                    } else {
                        aVar.fHI.setVisibility(0);
                    }
                    aVar.bse.setVisibility(0);
                    aVar.bse.setTag(Integer.valueOf(i));
                    aVar.ege.setVisibility(0);
                    aVar.eSj.setVisibility(8);
                    String portrait = this.adv.get(i).getPortrait();
                    aVar.cZE.setImageDrawable(null);
                    aVar.cZE.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.adv.get(i).getName_show());
                    aVar.bsd.setText(this.adv.get(i).getIntro());
                    aVar.fHI.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.fHF.getPageContext().getString(d.k.loading));
                aVar.mProgress.setVisibility(0);
            }
            aA(view2);
        }
        return view2;
    }

    private void aA(View view2) {
        this.fHF.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.fHF.getLayoutMode().u(view2);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.eSc) {
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
        if (this.eSc) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes3.dex */
    private class a {
        TextView bsd;
        LinearLayout bse;
        HeadImageView cZE;
        TextView eSj;
        ImageView ege;
        ImageView fHI;
        TextView mName;
        ProgressBar mProgress;

        private a() {
        }
    }
}
