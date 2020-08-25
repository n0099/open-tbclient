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
/* loaded from: classes18.dex */
public class d extends BaseAdapter {
    private boolean ghr;
    private View.OnClickListener kiI;
    private View.OnClickListener kjo;
    private PersonFriendActivity ljC;
    private int mPageType;
    private ArrayList<UserData> efX = null;
    private boolean mHasMore = false;
    private boolean ljD = false;
    private boolean ghp = false;
    private ArrayList<ProgressBar> ljE = new ArrayList<>();

    public void dhY() {
        if (this.ljE != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.ljE.size()) {
                    try {
                        this.ljE.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.ljE.clear();
                    return;
                }
            }
        }
    }

    public void bLC() {
        this.ghp = false;
        if (this.efX != null && this.efX.size() == 0) {
            this.ghp = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void uA(boolean z) {
        this.ljD = z;
    }

    public d(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.ljC = null;
        this.ghr = true;
        this.mPageType = 0;
        this.kjo = null;
        this.kiI = null;
        this.ljC = personFriendActivity;
        this.ghr = z;
        this.mPageType = i;
        this.kjo = onClickListener;
        this.kiI = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.efX = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ghp) {
            return 1;
        }
        int i = 0;
        if (this.efX != null) {
            i = this.efX.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.efX == null || i >= this.efX.size()) {
            return null;
        }
        return this.efX.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.efX == null || i >= this.efX.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.efX != null) {
            if (view == null) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.ljC.getPageContext().getPageActivity()).inflate(R.layout.person_list_item_friend, (ViewGroup) null);
                    aVar2.hWu = (HeadImageView) inflate.findViewById(R.id.photo);
                    aVar2.hWu.setIsRound(false);
                    aVar2.hWu.setAutoChangeStyle(true);
                    aVar2.giw = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.ght = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.fRI = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.ljF = (ImageView) inflate.findViewById(R.id.chat);
                    aVar2.jxo = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    aVar2.ljF.setOnClickListener(this.kjo);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.ljC.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(R.id.pb_more_text);
                    inflate2.setOnClickListener(this.kiI);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(R.id.progress);
                    this.ljE.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.ghp) {
                    aVar.giw.setVisibility(8);
                    aVar.ljF.setVisibility(8);
                    aVar.ght.setVisibility(8);
                    aVar.jxo.setVisibility(8);
                } else {
                    if (!this.ghr && this.mPageType == 0) {
                        aVar.ljF.setVisibility(8);
                    } else {
                        aVar.ljF.setVisibility(0);
                    }
                    aVar.giw.setVisibility(0);
                    aVar.giw.setTag(Integer.valueOf(i));
                    aVar.jxo.setVisibility(0);
                    aVar.ght.setVisibility(8);
                    String portrait = this.efX.get(i).getPortrait();
                    aVar.hWu.setImageDrawable(null);
                    aVar.hWu.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.efX.get(i).getName_show());
                    aVar.fRI.setText(this.efX.get(i).getIntro());
                    aVar.ljF.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.ljC.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            co(view);
        }
        return view;
    }

    private void co(View view) {
        this.ljC.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.ljC.getLayoutMode().onModeChanged(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.ghp) {
            return 0;
        }
        return (this.efX == null || i >= this.efX.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.ghp) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes18.dex */
    private class a {
        TextView fRI;
        TextView ght;
        LinearLayout giw;
        HeadImageView hWu;
        ImageView jxo;
        ImageView ljF;
        TextView mName;
        ProgressBar mProgress;

        private a() {
        }
    }
}
