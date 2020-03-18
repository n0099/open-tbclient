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
    private boolean eMo;
    private View.OnClickListener itJ;
    private View.OnClickListener itd;
    private PersonFriendActivity jnu;
    private int mPageType;
    private ArrayList<UserData> cWf = null;
    private boolean mHasMore = false;
    private boolean jnv = false;
    private boolean eMm = false;
    private ArrayList<ProgressBar> jnw = new ArrayList<>();

    public void cwU() {
        if (this.jnw != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.jnw.size()) {
                    try {
                        this.jnw.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.jnw.clear();
                    return;
                }
            }
        }
    }

    public void bgP() {
        this.eMm = false;
        if (this.cWf != null && this.cWf.size() == 0) {
            this.eMm = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void ru(boolean z) {
        this.jnv = z;
    }

    public d(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.jnu = null;
        this.eMo = true;
        this.mPageType = 0;
        this.itJ = null;
        this.itd = null;
        this.jnu = personFriendActivity;
        this.eMo = z;
        this.mPageType = i;
        this.itJ = onClickListener;
        this.itd = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.cWf = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eMm) {
            return 1;
        }
        int i = 0;
        if (this.cWf != null) {
            i = this.cWf.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cWf == null || i >= this.cWf.size()) {
            return null;
        }
        return this.cWf.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.cWf == null || i >= this.cWf.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.cWf != null) {
            if (view == null) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.jnu.getPageContext().getPageActivity()).inflate(R.layout.person_list_item_friend, (ViewGroup) null);
                    aVar2.gsg = (HeadImageView) inflate.findViewById(R.id.photo);
                    aVar2.gsg.setIsRound(false);
                    aVar2.gsg.setAutoChangeStyle(true);
                    aVar2.eNs = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.eMq = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.exW = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.jnx = (ImageView) inflate.findViewById(R.id.chat);
                    aVar2.hJB = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    aVar2.jnx.setOnClickListener(this.itJ);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.jnu.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(R.id.pb_more_text);
                    inflate2.setOnClickListener(this.itd);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(R.id.progress);
                    this.jnw.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.eMm) {
                    aVar.eNs.setVisibility(8);
                    aVar.jnx.setVisibility(8);
                    aVar.eMq.setVisibility(8);
                    aVar.hJB.setVisibility(8);
                } else {
                    if (!this.eMo && this.mPageType == 0) {
                        aVar.jnx.setVisibility(8);
                    } else {
                        aVar.jnx.setVisibility(0);
                    }
                    aVar.eNs.setVisibility(0);
                    aVar.eNs.setTag(Integer.valueOf(i));
                    aVar.hJB.setVisibility(0);
                    aVar.eMq.setVisibility(8);
                    String portrait = this.cWf.get(i).getPortrait();
                    aVar.gsg.setImageDrawable(null);
                    aVar.gsg.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.cWf.get(i).getName_show());
                    aVar.exW.setText(this.cWf.get(i).getIntro());
                    aVar.jnx.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.jnu.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            bX(view);
        }
        return view;
    }

    private void bX(View view) {
        this.jnu.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.jnu.getLayoutMode().onModeChanged(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.eMm) {
            return 0;
        }
        return (this.cWf == null || i >= this.cWf.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.eMm) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes11.dex */
    private class a {
        TextView eMq;
        LinearLayout eNs;
        TextView exW;
        HeadImageView gsg;
        ImageView hJB;
        ImageView jnx;
        TextView mName;
        ProgressBar mProgress;

        private a() {
        }
    }
}
