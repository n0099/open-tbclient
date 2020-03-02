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
    private boolean eLF;
    private View.OnClickListener irX;
    private View.OnClickListener irr;
    private PersonFriendActivity jlI;
    private int mPageType;
    private ArrayList<UserData> cVR = null;
    private boolean mHasMore = false;
    private boolean jlJ = false;
    private boolean eLD = false;
    private ArrayList<ProgressBar> jlK = new ArrayList<>();

    public void cwA() {
        if (this.jlK != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.jlK.size()) {
                    try {
                        this.jlK.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.jlK.clear();
                    return;
                }
            }
        }
    }

    public void bgJ() {
        this.eLD = false;
        if (this.cVR != null && this.cVR.size() == 0) {
            this.eLD = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void ro(boolean z) {
        this.jlJ = z;
    }

    public d(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.jlI = null;
        this.eLF = true;
        this.mPageType = 0;
        this.irX = null;
        this.irr = null;
        this.jlI = personFriendActivity;
        this.eLF = z;
        this.mPageType = i;
        this.irX = onClickListener;
        this.irr = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.cVR = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eLD) {
            return 1;
        }
        int i = 0;
        if (this.cVR != null) {
            i = this.cVR.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cVR == null || i >= this.cVR.size()) {
            return null;
        }
        return this.cVR.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.cVR == null || i >= this.cVR.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.cVR != null) {
            if (view == null) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.jlI.getPageContext().getPageActivity()).inflate(R.layout.person_list_item_friend, (ViewGroup) null);
                    aVar2.grj = (HeadImageView) inflate.findViewById(R.id.photo);
                    aVar2.grj.setIsRound(false);
                    aVar2.grj.setAutoChangeStyle(true);
                    aVar2.eMJ = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.eLH = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.exm = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.jlL = (ImageView) inflate.findViewById(R.id.chat);
                    aVar2.hHP = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    aVar2.jlL.setOnClickListener(this.irX);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.jlI.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(R.id.pb_more_text);
                    inflate2.setOnClickListener(this.irr);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(R.id.progress);
                    this.jlK.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.eLD) {
                    aVar.eMJ.setVisibility(8);
                    aVar.jlL.setVisibility(8);
                    aVar.eLH.setVisibility(8);
                    aVar.hHP.setVisibility(8);
                } else {
                    if (!this.eLF && this.mPageType == 0) {
                        aVar.jlL.setVisibility(8);
                    } else {
                        aVar.jlL.setVisibility(0);
                    }
                    aVar.eMJ.setVisibility(0);
                    aVar.eMJ.setTag(Integer.valueOf(i));
                    aVar.hHP.setVisibility(0);
                    aVar.eLH.setVisibility(8);
                    String portrait = this.cVR.get(i).getPortrait();
                    aVar.grj.setImageDrawable(null);
                    aVar.grj.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.cVR.get(i).getName_show());
                    aVar.exm.setText(this.cVR.get(i).getIntro());
                    aVar.jlL.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.jlI.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            bX(view);
        }
        return view;
    }

    private void bX(View view) {
        this.jlI.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.jlI.getLayoutMode().onModeChanged(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.eLD) {
            return 0;
        }
        return (this.cVR == null || i >= this.cVR.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.eLD) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes11.dex */
    private class a {
        TextView eLH;
        LinearLayout eMJ;
        TextView exm;
        HeadImageView grj;
        ImageView hHP;
        ImageView jlL;
        TextView mName;
        ProgressBar mProgress;

        private a() {
        }
    }
}
