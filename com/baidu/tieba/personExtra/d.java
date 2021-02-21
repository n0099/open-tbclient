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
/* loaded from: classes8.dex */
public class d extends BaseAdapter {
    private boolean hlf;
    private View.OnClickListener lvM;
    private View.OnClickListener lwt;
    private int mPageType;
    private PersonFriendActivity myI;
    private ArrayList<UserData> eVV = null;
    private boolean mHasMore = false;
    private boolean myJ = false;
    private boolean hld = false;
    private ArrayList<ProgressBar> myK = new ArrayList<>();

    public void dye() {
        if (this.myK != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.myK.size()) {
                    try {
                        this.myK.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.myK.clear();
                    return;
                }
            }
        }
    }

    public void bYy() {
        this.hld = false;
        if (this.eVV != null && this.eVV.size() == 0) {
            this.hld = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void wM(boolean z) {
        this.myJ = z;
    }

    public d(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.myI = null;
        this.hlf = true;
        this.mPageType = 0;
        this.lwt = null;
        this.lvM = null;
        this.myI = personFriendActivity;
        this.hlf = z;
        this.mPageType = i;
        this.lwt = onClickListener;
        this.lvM = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.eVV = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hld) {
            return 1;
        }
        int i = 0;
        if (this.eVV != null) {
            i = this.eVV.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eVV == null || i >= this.eVV.size()) {
            return null;
        }
        return this.eVV.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.eVV == null || i >= this.eVV.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.eVV != null) {
            if (view == null) {
                a aVar2 = new a();
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.myI.getPageContext().getPageActivity()).inflate(R.layout.person_list_item_friend, (ViewGroup) null);
                    aVar2.kAp = (HeadImageView) inflate.findViewById(R.id.photo);
                    aVar2.kAp.setIsRound(false);
                    aVar2.kAp.setAutoChangeStyle(true);
                    aVar2.hmh = (LinearLayout) inflate.findViewById(R.id.info);
                    aVar2.mName = (TextView) inflate.findViewById(R.id.name);
                    aVar2.hlh = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    aVar2.gPA = (TextView) inflate.findViewById(R.id.intro);
                    aVar2.myL = (ImageView) inflate.findViewById(R.id.chat);
                    aVar2.kKE = (ImageView) inflate.findViewById(R.id.diver_buttom_px);
                    aVar2.myL.setOnClickListener(this.lwt);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.myI.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    aVar2.mName = (TextView) inflate2.findViewById(R.id.pb_more_text);
                    inflate2.setOnClickListener(this.lvM);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(R.id.progress);
                    this.myK.add(aVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.hld) {
                    aVar.hmh.setVisibility(8);
                    aVar.myL.setVisibility(8);
                    aVar.hlh.setVisibility(8);
                    aVar.kKE.setVisibility(8);
                } else {
                    if (!this.hlf && this.mPageType == 0) {
                        aVar.myL.setVisibility(8);
                    } else {
                        aVar.myL.setVisibility(0);
                    }
                    aVar.hmh.setVisibility(0);
                    aVar.hmh.setTag(Integer.valueOf(i));
                    aVar.kKE.setVisibility(0);
                    aVar.hlh.setVisibility(8);
                    String portrait = this.eVV.get(i).getPortrait();
                    aVar.kAp.setImageDrawable(null);
                    aVar.kAp.startLoad(portrait, 12, false);
                    aVar.mName.setText(this.eVV.get(i).getName_show());
                    aVar.gPA.setText(this.eVV.get(i).getIntro());
                    aVar.myL.setTag(Integer.valueOf(i));
                }
            } else {
                aVar.mName.setText(this.myI.getPageContext().getString(R.string.loading));
                aVar.mProgress.setVisibility(0);
            }
            dd(view);
        }
        return view;
    }

    private void dd(View view) {
        this.myI.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.myI.getLayoutMode().onModeChanged(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.hld) {
            return 0;
        }
        return (this.eVV == null || i >= this.eVV.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.hld) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes8.dex */
    private class a {
        TextView gPA;
        TextView hlh;
        LinearLayout hmh;
        HeadImageView kAp;
        ImageView kKE;
        TextView mName;
        ProgressBar mProgress;
        ImageView myL;

        private a() {
        }
    }
}
