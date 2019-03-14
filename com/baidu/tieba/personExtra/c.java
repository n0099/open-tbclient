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
    private boolean fDf;
    private View.OnClickListener gZM;
    private PersonFriendActivity hPz;
    private View.OnClickListener hap;
    private int mPageType;
    private ArrayList<UserData> aFI = null;
    private boolean mHasMore = false;
    private boolean hPA = false;
    private boolean gZK = false;
    private ArrayList<ProgressBar> hPB = new ArrayList<>();

    public void bRz() {
        if (this.hPB != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.hPB.size()) {
                    try {
                        this.hPB.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.hPB.clear();
                    return;
                }
            }
        }
    }

    public void bEQ() {
        this.gZK = false;
        if (this.aFI != null && this.aFI.size() == 0) {
            this.gZK = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void oF(boolean z) {
        this.hPA = z;
    }

    public c(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.hPz = null;
        this.fDf = true;
        this.mPageType = 0;
        this.hap = null;
        this.gZM = null;
        this.hPz = personFriendActivity;
        this.fDf = z;
        this.mPageType = i;
        this.hap = onClickListener;
        this.gZM = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.aFI = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gZK) {
            return 1;
        }
        int i = 0;
        if (this.aFI != null) {
            i = this.aFI.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aFI == null || i >= this.aFI.size()) {
            return null;
        }
        return this.aFI.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.aFI == null || i >= this.aFI.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.aFI != null) {
            if (view == null) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.hPz.getPageContext().getPageActivity()).inflate(d.h.person_list_item_friend, (ViewGroup) null);
                    aVar2.fbS = (HeadImageView) inflate.findViewById(d.g.photo);
                    aVar2.fbS.setIsRound(false);
                    aVar2.fbS.setAutoChangeStyle(true);
                    aVar2.dlK = (LinearLayout) inflate.findViewById(d.g.info);
                    aVar2.mName = (TextView) inflate.findViewById(d.g.name);
                    aVar2.gZR = (TextView) inflate.findViewById(d.g.at_list_nodata);
                    aVar2.dlJ = (TextView) inflate.findViewById(d.g.intro);
                    aVar2.hPC = (ImageView) inflate.findViewById(d.g.chat);
                    aVar2.gqX = (ImageView) inflate.findViewById(d.g.diver_buttom_px);
                    aVar2.hPC.setOnClickListener(this.hap);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.hPz.getPageContext().getPageActivity()).inflate(d.h.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(d.g.pb_more_text);
                    inflate2.setOnClickListener(this.gZM);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(d.g.progress);
                    this.hPB.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.gZK) {
                    aVar.dlK.setVisibility(8);
                    aVar.hPC.setVisibility(8);
                    aVar.gZR.setVisibility(8);
                    aVar.gqX.setVisibility(8);
                } else {
                    if (!this.fDf && this.mPageType == 0) {
                        aVar.hPC.setVisibility(8);
                    } else {
                        aVar.hPC.setVisibility(0);
                    }
                    aVar.dlK.setVisibility(0);
                    aVar.dlK.setTag(Integer.valueOf(i));
                    aVar.gqX.setVisibility(0);
                    aVar.gZR.setVisibility(8);
                    String portrait = this.aFI.get(i).getPortrait();
                    aVar.fbS.setImageDrawable(null);
                    aVar.fbS.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.aFI.get(i).getName_show());
                    aVar.dlJ.setText(this.aFI.get(i).getIntro());
                    aVar.hPC.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.hPz.getPageContext().getString(d.j.loading));
                aVar.mProgress.setVisibility(0);
            }
            bP(view);
        }
        return view;
    }

    private void bP(View view) {
        this.hPz.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.hPz.getLayoutMode().onModeChanged(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.gZK) {
            return 0;
        }
        return (this.aFI == null || i >= this.aFI.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.gZK) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes6.dex */
    private class a {
        TextView dlJ;
        LinearLayout dlK;
        HeadImageView fbS;
        TextView gZR;
        ImageView gqX;
        ImageView hPC;
        TextView mName;
        ProgressBar mProgress;

        private a() {
        }
    }
}
