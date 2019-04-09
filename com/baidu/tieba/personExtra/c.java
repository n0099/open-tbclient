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
/* loaded from: classes6.dex */
public class c extends BaseAdapter {
    private boolean fCT;
    private View.OnClickListener gZA;
    private PersonFriendActivity hPm;
    private View.OnClickListener had;
    private int mPageType;
    private ArrayList<UserData> aFM = null;
    private boolean mHasMore = false;
    private boolean hPn = false;
    private boolean gZy = false;
    private ArrayList<ProgressBar> hPo = new ArrayList<>();

    public void bRv() {
        if (this.hPo != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.hPo.size()) {
                    try {
                        this.hPo.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.hPo.clear();
                    return;
                }
            }
        }
    }

    public void bEN() {
        this.gZy = false;
        if (this.aFM != null && this.aFM.size() == 0) {
            this.gZy = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void oF(boolean z) {
        this.hPn = z;
    }

    public c(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.hPm = null;
        this.fCT = true;
        this.mPageType = 0;
        this.had = null;
        this.gZA = null;
        this.hPm = personFriendActivity;
        this.fCT = z;
        this.mPageType = i;
        this.had = onClickListener;
        this.gZA = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.aFM = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gZy) {
            return 1;
        }
        int i = 0;
        if (this.aFM != null) {
            i = this.aFM.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aFM == null || i >= this.aFM.size()) {
            return null;
        }
        return this.aFM.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.aFM == null || i >= this.aFM.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.aFM != null) {
            if (view == null) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.hPm.getPageContext().getPageActivity()).inflate(d.h.person_list_item_friend, (ViewGroup) null);
                    aVar2.fbF = (HeadImageView) inflate.findViewById(d.g.photo);
                    aVar2.fbF.setIsRound(false);
                    aVar2.fbF.setAutoChangeStyle(true);
                    aVar2.dlO = (LinearLayout) inflate.findViewById(d.g.info);
                    aVar2.mName = (TextView) inflate.findViewById(d.g.name);
                    aVar2.gZF = (TextView) inflate.findViewById(d.g.at_list_nodata);
                    aVar2.dlN = (TextView) inflate.findViewById(d.g.intro);
                    aVar2.hPp = (ImageView) inflate.findViewById(d.g.chat);
                    aVar2.gqL = (ImageView) inflate.findViewById(d.g.diver_buttom_px);
                    aVar2.hPp.setOnClickListener(this.had);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.hPm.getPageContext().getPageActivity()).inflate(d.h.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(d.g.pb_more_text);
                    inflate2.setOnClickListener(this.gZA);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(d.g.progress);
                    this.hPo.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.gZy) {
                    aVar.dlO.setVisibility(8);
                    aVar.hPp.setVisibility(8);
                    aVar.gZF.setVisibility(8);
                    aVar.gqL.setVisibility(8);
                } else {
                    if (!this.fCT && this.mPageType == 0) {
                        aVar.hPp.setVisibility(8);
                    } else {
                        aVar.hPp.setVisibility(0);
                    }
                    aVar.dlO.setVisibility(0);
                    aVar.dlO.setTag(Integer.valueOf(i));
                    aVar.gqL.setVisibility(0);
                    aVar.gZF.setVisibility(8);
                    String portrait = this.aFM.get(i).getPortrait();
                    aVar.fbF.setImageDrawable(null);
                    aVar.fbF.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.aFM.get(i).getName_show());
                    aVar.dlN.setText(this.aFM.get(i).getIntro());
                    aVar.hPp.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.hPm.getPageContext().getString(d.j.loading));
                aVar.mProgress.setVisibility(0);
            }
            bP(view);
        }
        return view;
    }

    private void bP(View view) {
        this.hPm.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.hPm.getLayoutMode().onModeChanged(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.gZy) {
            return 0;
        }
        return (this.aFM == null || i >= this.aFM.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.gZy) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes6.dex */
    private class a {
        TextView dlN;
        LinearLayout dlO;
        HeadImageView fbF;
        TextView gZF;
        ImageView gqL;
        ImageView hPp;
        TextView mName;
        ProgressBar mProgress;

        private a() {
        }
    }
}
