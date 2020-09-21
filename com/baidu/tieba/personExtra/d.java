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
/* loaded from: classes23.dex */
public class d extends BaseAdapter {
    private boolean gkE;
    private View.OnClickListener krU;
    private View.OnClickListener kro;
    private PersonFriendActivity lsF;
    private int mPageType;
    private ArrayList<UserData> eiq = null;
    private boolean mHasMore = false;
    private boolean lsG = false;
    private boolean gkC = false;
    private ArrayList<ProgressBar> lsH = new ArrayList<>();

    public void dlE() {
        if (this.lsH != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.lsH.size()) {
                    try {
                        this.lsH.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.lsH.clear();
                    return;
                }
            }
        }
    }

    public void bMN() {
        this.gkC = false;
        if (this.eiq != null && this.eiq.size() == 0) {
            this.gkC = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void uK(boolean z) {
        this.lsG = z;
    }

    public d(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.lsF = null;
        this.gkE = true;
        this.mPageType = 0;
        this.krU = null;
        this.kro = null;
        this.lsF = personFriendActivity;
        this.gkE = z;
        this.mPageType = i;
        this.krU = onClickListener;
        this.kro = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.eiq = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gkC) {
            return 1;
        }
        int i = 0;
        if (this.eiq != null) {
            i = this.eiq.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eiq == null || i >= this.eiq.size()) {
            return null;
        }
        return this.eiq.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.eiq == null || i >= this.eiq.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.eiq != null) {
            if (view == null) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.lsF.getPageContext().getPageActivity()).inflate(R.layout.person_list_item_friend, (ViewGroup) null);
                    aVar2.idE = (HeadImageView) inflate.findViewById(R.id.photo);
                    aVar2.idE.setIsRound(false);
                    aVar2.idE.setAutoChangeStyle(true);
                    aVar2.glH = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.gkG = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.fUX = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.lsI = (ImageView) inflate.findViewById(R.id.chat);
                    aVar2.jFW = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    aVar2.lsI.setOnClickListener(this.krU);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.lsF.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(R.id.pb_more_text);
                    inflate2.setOnClickListener(this.kro);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(R.id.progress);
                    this.lsH.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.gkC) {
                    aVar.glH.setVisibility(8);
                    aVar.lsI.setVisibility(8);
                    aVar.gkG.setVisibility(8);
                    aVar.jFW.setVisibility(8);
                } else {
                    if (!this.gkE && this.mPageType == 0) {
                        aVar.lsI.setVisibility(8);
                    } else {
                        aVar.lsI.setVisibility(0);
                    }
                    aVar.glH.setVisibility(0);
                    aVar.glH.setTag(Integer.valueOf(i));
                    aVar.jFW.setVisibility(0);
                    aVar.gkG.setVisibility(8);
                    String portrait = this.eiq.get(i).getPortrait();
                    aVar.idE.setImageDrawable(null);
                    aVar.idE.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.eiq.get(i).getName_show());
                    aVar.fUX.setText(this.eiq.get(i).getIntro());
                    aVar.lsI.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.lsF.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            cx(view);
        }
        return view;
    }

    private void cx(View view) {
        this.lsF.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.lsF.getLayoutMode().onModeChanged(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.gkC) {
            return 0;
        }
        return (this.eiq == null || i >= this.eiq.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.gkC) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes23.dex */
    private class a {
        TextView fUX;
        TextView gkG;
        LinearLayout glH;
        HeadImageView idE;
        ImageView jFW;
        ImageView lsI;
        TextView mName;
        ProgressBar mProgress;

        private a() {
        }
    }
}
