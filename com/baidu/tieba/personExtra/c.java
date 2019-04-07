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
    private View.OnClickListener gZz;
    private PersonFriendActivity hPl;
    private View.OnClickListener hac;
    private int mPageType;
    private ArrayList<UserData> aFL = null;
    private boolean mHasMore = false;
    private boolean hPm = false;
    private boolean gZx = false;
    private ArrayList<ProgressBar> hPn = new ArrayList<>();

    public void bRv() {
        if (this.hPn != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.hPn.size()) {
                    try {
                        this.hPn.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.hPn.clear();
                    return;
                }
            }
        }
    }

    public void bEN() {
        this.gZx = false;
        if (this.aFL != null && this.aFL.size() == 0) {
            this.gZx = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void oF(boolean z) {
        this.hPm = z;
    }

    public c(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.hPl = null;
        this.fCT = true;
        this.mPageType = 0;
        this.hac = null;
        this.gZz = null;
        this.hPl = personFriendActivity;
        this.fCT = z;
        this.mPageType = i;
        this.hac = onClickListener;
        this.gZz = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.aFL = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gZx) {
            return 1;
        }
        int i = 0;
        if (this.aFL != null) {
            i = this.aFL.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aFL == null || i >= this.aFL.size()) {
            return null;
        }
        return this.aFL.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.aFL == null || i >= this.aFL.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.aFL != null) {
            if (view == null) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.hPl.getPageContext().getPageActivity()).inflate(d.h.person_list_item_friend, (ViewGroup) null);
                    aVar2.fbF = (HeadImageView) inflate.findViewById(d.g.photo);
                    aVar2.fbF.setIsRound(false);
                    aVar2.fbF.setAutoChangeStyle(true);
                    aVar2.dlN = (LinearLayout) inflate.findViewById(d.g.info);
                    aVar2.mName = (TextView) inflate.findViewById(d.g.name);
                    aVar2.gZE = (TextView) inflate.findViewById(d.g.at_list_nodata);
                    aVar2.dlM = (TextView) inflate.findViewById(d.g.intro);
                    aVar2.hPo = (ImageView) inflate.findViewById(d.g.chat);
                    aVar2.gqK = (ImageView) inflate.findViewById(d.g.diver_buttom_px);
                    aVar2.hPo.setOnClickListener(this.hac);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.hPl.getPageContext().getPageActivity()).inflate(d.h.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(d.g.pb_more_text);
                    inflate2.setOnClickListener(this.gZz);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(d.g.progress);
                    this.hPn.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.gZx) {
                    aVar.dlN.setVisibility(8);
                    aVar.hPo.setVisibility(8);
                    aVar.gZE.setVisibility(8);
                    aVar.gqK.setVisibility(8);
                } else {
                    if (!this.fCT && this.mPageType == 0) {
                        aVar.hPo.setVisibility(8);
                    } else {
                        aVar.hPo.setVisibility(0);
                    }
                    aVar.dlN.setVisibility(0);
                    aVar.dlN.setTag(Integer.valueOf(i));
                    aVar.gqK.setVisibility(0);
                    aVar.gZE.setVisibility(8);
                    String portrait = this.aFL.get(i).getPortrait();
                    aVar.fbF.setImageDrawable(null);
                    aVar.fbF.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.aFL.get(i).getName_show());
                    aVar.dlM.setText(this.aFL.get(i).getIntro());
                    aVar.hPo.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.hPl.getPageContext().getString(d.j.loading));
                aVar.mProgress.setVisibility(0);
            }
            bP(view);
        }
        return view;
    }

    private void bP(View view) {
        this.hPl.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.hPl.getLayoutMode().onModeChanged(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.gZx) {
            return 0;
        }
        return (this.aFL == null || i >= this.aFL.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.gZx) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes6.dex */
    private class a {
        TextView dlM;
        LinearLayout dlN;
        HeadImageView fbF;
        TextView gZE;
        ImageView gqK;
        ImageView hPo;
        TextView mName;
        ProgressBar mProgress;

        private a() {
        }
    }
}
