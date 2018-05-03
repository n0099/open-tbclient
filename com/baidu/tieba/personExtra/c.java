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
    private boolean dxr;
    private View.OnClickListener eSB;
    private View.OnClickListener eSb;
    private PersonFriendActivity fHC;
    private int mPageType;
    private ArrayList<UserData> adv = null;
    private boolean mHasMore = false;
    private boolean fHD = false;
    private boolean eRZ = false;
    private ArrayList<ProgressBar> fHE = new ArrayList<>();

    public void beM() {
        if (this.fHE != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.fHE.size()) {
                    try {
                        this.fHE.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.fHE.clear();
                    return;
                }
            }
        }
    }

    public void aSq() {
        this.eRZ = false;
        if (this.adv != null && this.adv.size() == 0) {
            this.eRZ = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void lb(boolean z) {
        this.fHD = z;
    }

    public c(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.fHC = null;
        this.dxr = true;
        this.mPageType = 0;
        this.eSB = null;
        this.eSb = null;
        this.fHC = personFriendActivity;
        this.dxr = z;
        this.mPageType = i;
        this.eSB = onClickListener;
        this.eSb = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.adv = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eRZ) {
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
                    View inflate = LayoutInflater.from(this.fHC.getPageContext().getPageActivity()).inflate(d.i.person_list_item_friend, (ViewGroup) null);
                    aVar2.cZB = (HeadImageView) inflate.findViewById(d.g.photo);
                    aVar2.cZB.setIsRound(false);
                    aVar2.cZB.setAutoChangeStyle(true);
                    aVar2.bse = (LinearLayout) inflate.findViewById(d.g.info);
                    aVar2.mName = (TextView) inflate.findViewById(d.g.name);
                    aVar2.eSg = (TextView) inflate.findViewById(d.g.at_list_nodata);
                    aVar2.bsd = (TextView) inflate.findViewById(d.g.intro);
                    aVar2.fHF = (ImageView) inflate.findViewById(d.g.chat);
                    aVar2.egb = (ImageView) inflate.findViewById(d.g.diver_buttom_px);
                    aVar2.fHF.setOnClickListener(this.eSB);
                    view3 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.fHC.getPageContext().getPageActivity()).inflate(d.i.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(d.g.pb_more_text);
                    inflate2.setOnClickListener(this.eSb);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(d.g.progress);
                    this.fHE.add(aVar2.mProgress);
                    view3 = inflate2;
                }
                view3.setTag(aVar2);
                aVar = aVar2;
                view2 = view3;
            } else {
                aVar = (a) view2.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.eRZ) {
                    aVar.bse.setVisibility(8);
                    aVar.fHF.setVisibility(8);
                    aVar.eSg.setVisibility(8);
                    aVar.egb.setVisibility(8);
                } else {
                    if (!this.dxr && this.mPageType == 0) {
                        aVar.fHF.setVisibility(8);
                    } else {
                        aVar.fHF.setVisibility(0);
                    }
                    aVar.bse.setVisibility(0);
                    aVar.bse.setTag(Integer.valueOf(i));
                    aVar.egb.setVisibility(0);
                    aVar.eSg.setVisibility(8);
                    String portrait = this.adv.get(i).getPortrait();
                    aVar.cZB.setImageDrawable(null);
                    aVar.cZB.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.adv.get(i).getName_show());
                    aVar.bsd.setText(this.adv.get(i).getIntro());
                    aVar.fHF.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.fHC.getPageContext().getString(d.k.loading));
                aVar.mProgress.setVisibility(0);
            }
            aA(view2);
        }
        return view2;
    }

    private void aA(View view2) {
        this.fHC.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.fHC.getLayoutMode().u(view2);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.eRZ) {
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
        if (this.eRZ) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes3.dex */
    private class a {
        TextView bsd;
        LinearLayout bse;
        HeadImageView cZB;
        TextView eSg;
        ImageView egb;
        ImageView fHF;
        TextView mName;
        ProgressBar mProgress;

        private a() {
        }
    }
}
