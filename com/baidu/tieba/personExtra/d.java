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
    private boolean fqL;
    private PersonFriendActivity jXM;
    private View.OnClickListener jdS;
    private View.OnClickListener jdm;
    private int mPageType;
    private ArrayList<UserData> dvu = null;
    private boolean mHasMore = false;
    private boolean jXN = false;
    private boolean fqJ = false;
    private ArrayList<ProgressBar> jXO = new ArrayList<>();

    public void cHD() {
        if (this.jXO != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.jXO.size()) {
                    try {
                        this.jXO.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.jXO.clear();
                    return;
                }
            }
        }
    }

    public void bqe() {
        this.fqJ = false;
        if (this.dvu != null && this.dvu.size() == 0) {
            this.fqJ = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void sy(boolean z) {
        this.jXN = z;
    }

    public d(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.jXM = null;
        this.fqL = true;
        this.mPageType = 0;
        this.jdS = null;
        this.jdm = null;
        this.jXM = personFriendActivity;
        this.fqL = z;
        this.mPageType = i;
        this.jdS = onClickListener;
        this.jdm = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.dvu = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fqJ) {
            return 1;
        }
        int i = 0;
        if (this.dvu != null) {
            i = this.dvu.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dvu == null || i >= this.dvu.size()) {
            return null;
        }
        return this.dvu.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.dvu == null || i >= this.dvu.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.dvu != null) {
            if (view == null) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.jXM.getPageContext().getPageActivity()).inflate(R.layout.person_list_item_friend, (ViewGroup) null);
                    aVar2.hby = (HeadImageView) inflate.findViewById(R.id.photo);
                    aVar2.hby.setIsRound(false);
                    aVar2.hby.setAutoChangeStyle(true);
                    aVar2.frR = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.fqN = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.fci = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.jXP = (ImageView) inflate.findViewById(R.id.chat);
                    aVar2.itx = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    aVar2.jXP.setOnClickListener(this.jdS);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.jXM.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(R.id.pb_more_text);
                    inflate2.setOnClickListener(this.jdm);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(R.id.progress);
                    this.jXO.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.fqJ) {
                    aVar.frR.setVisibility(8);
                    aVar.jXP.setVisibility(8);
                    aVar.fqN.setVisibility(8);
                    aVar.itx.setVisibility(8);
                } else {
                    if (!this.fqL && this.mPageType == 0) {
                        aVar.jXP.setVisibility(8);
                    } else {
                        aVar.jXP.setVisibility(0);
                    }
                    aVar.frR.setVisibility(0);
                    aVar.frR.setTag(Integer.valueOf(i));
                    aVar.itx.setVisibility(0);
                    aVar.fqN.setVisibility(8);
                    String portrait = this.dvu.get(i).getPortrait();
                    aVar.hby.setImageDrawable(null);
                    aVar.hby.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.dvu.get(i).getName_show());
                    aVar.fci.setText(this.dvu.get(i).getIntro());
                    aVar.jXP.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.jXM.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            cf(view);
        }
        return view;
    }

    private void cf(View view) {
        this.jXM.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.jXM.getLayoutMode().onModeChanged(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fqJ) {
            return 0;
        }
        return (this.dvu == null || i >= this.dvu.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fqJ) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes11.dex */
    private class a {
        TextView fci;
        TextView fqN;
        LinearLayout frR;
        HeadImageView hby;
        ImageView itx;
        ImageView jXP;
        TextView mName;
        ProgressBar mProgress;

        private a() {
        }
    }
}
