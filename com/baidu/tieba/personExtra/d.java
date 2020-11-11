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
/* loaded from: classes24.dex */
public class d extends BaseAdapter {
    private boolean gQx;
    private View.OnClickListener kYT;
    private View.OnClickListener kZz;
    private int mPageType;
    private PersonFriendActivity mal;
    private ArrayList<UserData> eIM = null;
    private boolean mHasMore = false;
    private boolean mam = false;
    private boolean gQv = false;
    private ArrayList<ProgressBar> man = new ArrayList<>();

    public void duX() {
        if (this.man != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.man.size()) {
                    try {
                        this.man.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.man.clear();
                    return;
                }
            }
        }
    }

    public void bVA() {
        this.gQv = false;
        if (this.eIM != null && this.eIM.size() == 0) {
            this.gQv = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void vR(boolean z) {
        this.mam = z;
    }

    public d(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.mal = null;
        this.gQx = true;
        this.mPageType = 0;
        this.kZz = null;
        this.kYT = null;
        this.mal = personFriendActivity;
        this.gQx = z;
        this.mPageType = i;
        this.kZz = onClickListener;
        this.kYT = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.eIM = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gQv) {
            return 1;
        }
        int i = 0;
        if (this.eIM != null) {
            i = this.eIM.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eIM == null || i >= this.eIM.size()) {
            return null;
        }
        return this.eIM.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.eIM == null || i >= this.eIM.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.eIM != null) {
            if (view == null) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.mal.getPageContext().getPageActivity()).inflate(R.layout.person_list_item_friend, (ViewGroup) null);
                    aVar2.iKU = (HeadImageView) inflate.findViewById(R.id.photo);
                    aVar2.iKU.setIsRound(false);
                    aVar2.iKU.setAutoChangeStyle(true);
                    aVar2.gRA = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.gQz = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.gxh = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.mao = (ImageView) inflate.findViewById(R.id.chat);
                    aVar2.knq = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    aVar2.mao.setOnClickListener(this.kZz);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.mal.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(R.id.pb_more_text);
                    inflate2.setOnClickListener(this.kYT);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(R.id.progress);
                    this.man.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.gQv) {
                    aVar.gRA.setVisibility(8);
                    aVar.mao.setVisibility(8);
                    aVar.gQz.setVisibility(8);
                    aVar.knq.setVisibility(8);
                } else {
                    if (!this.gQx && this.mPageType == 0) {
                        aVar.mao.setVisibility(8);
                    } else {
                        aVar.mao.setVisibility(0);
                    }
                    aVar.gRA.setVisibility(0);
                    aVar.gRA.setTag(Integer.valueOf(i));
                    aVar.knq.setVisibility(0);
                    aVar.gQz.setVisibility(8);
                    String portrait = this.eIM.get(i).getPortrait();
                    aVar.iKU.setImageDrawable(null);
                    aVar.iKU.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.eIM.get(i).getName_show());
                    aVar.gxh.setText(this.eIM.get(i).getIntro());
                    aVar.mao.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.mal.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            cK(view);
        }
        return view;
    }

    private void cK(View view) {
        this.mal.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.mal.getLayoutMode().onModeChanged(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.gQv) {
            return 0;
        }
        return (this.eIM == null || i >= this.eIM.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.gQv) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes24.dex */
    private class a {
        TextView gQz;
        LinearLayout gRA;
        TextView gxh;
        HeadImageView iKU;
        ImageView knq;
        TextView mName;
        ProgressBar mProgress;
        ImageView mao;

        private a() {
        }
    }
}
