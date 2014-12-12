package com.baidu.tieba.person;

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
import java.util.ArrayList;
/* loaded from: classes.dex */
public class au extends BaseAdapter {
    private View.OnClickListener aKG;
    private int bFn;
    private PersonFriendActivity bGn;
    private View.OnClickListener bGq;
    private boolean bxv;
    private ArrayList<UserData> mData = null;
    private boolean mHasMore = false;
    private boolean bGo = false;
    private boolean bwQ = false;
    private ArrayList<ProgressBar> bGp = new ArrayList<>();

    public void TK() {
        if (this.bGp != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.bGp.size()) {
                    try {
                        this.bGp.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.bGp.clear();
                    return;
                }
            }
        }
    }

    public void Wc() {
        this.bwQ = false;
        if (this.mData != null && this.mData.size() == 0) {
            this.bwQ = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void ec(boolean z) {
        this.bGo = z;
    }

    public au(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.bGn = null;
        this.bxv = true;
        this.bFn = 0;
        this.bGq = null;
        this.aKG = null;
        this.bGn = personFriendActivity;
        this.bxv = z;
        this.bFn = i;
        this.bGq = onClickListener;
        this.aKG = onClickListener2;
    }

    public void r(ArrayList<UserData> arrayList) {
        this.mData = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bwQ) {
            return 1;
        }
        int i = 0;
        if (this.mData != null) {
            i = this.mData.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mData == null || i >= this.mData.size()) {
            return null;
        }
        return this.mData.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.mData == null || i >= this.mData.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        av avVar;
        View view2;
        if (this.mData != null) {
            if (view == null) {
                av avVar2 = new av(this, null);
                if (getItemViewType(i) == 0) {
                    View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.bGn.getPageContext().getPageActivity(), com.baidu.tieba.x.person_list_item_friend, null);
                    avVar2.aBo = (HeadImageView) inflate.findViewById(com.baidu.tieba.w.photo);
                    avVar2.aBo.setIsRound(false);
                    avVar2.aBo.setAutoChangeStyle(true);
                    avVar2.mInfo = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.info);
                    avVar2.azp = (TextView) inflate.findViewById(com.baidu.tieba.w.name);
                    avVar2.bGs = (TextView) inflate.findViewById(com.baidu.tieba.w.at_list_nodata);
                    avVar2.axW = (TextView) inflate.findViewById(com.baidu.tieba.w.intro);
                    avVar2.bGr = (ImageView) inflate.findViewById(com.baidu.tieba.w.chat);
                    avVar2.bjq = (ImageView) inflate.findViewById(com.baidu.tieba.w.diver_buttom_px);
                    avVar2.bGr.setOnClickListener(this.bGq);
                    view2 = inflate;
                } else {
                    View inflate2 = com.baidu.adp.lib.g.b.ek().inflate(this.bGn.getPageContext().getPageActivity(), com.baidu.tieba.x.new_pb_list_more, null);
                    avVar2.azp = (TextView) inflate2.findViewById(com.baidu.tieba.w.pb_more_text);
                    inflate2.setOnClickListener(this.aKG);
                    avVar2.mProgress = (ProgressBar) inflate2.findViewById(com.baidu.tieba.w.progress);
                    this.bGp.add(avVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(avVar2);
                avVar = avVar2;
                view = view2;
            } else {
                avVar = (av) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.bwQ) {
                    avVar.mInfo.setVisibility(8);
                    avVar.bGr.setVisibility(8);
                    avVar.bGs.setVisibility(8);
                    avVar.bjq.setVisibility(8);
                } else {
                    if (!this.bxv && this.bFn == 0) {
                        avVar.bGr.setVisibility(8);
                    } else {
                        avVar.bGr.setVisibility(0);
                    }
                    avVar.mInfo.setVisibility(0);
                    avVar.mInfo.setTag(Integer.valueOf(i));
                    avVar.bjq.setVisibility(0);
                    avVar.bGs.setVisibility(8);
                    String portrait = this.mData.get(i).getPortrait();
                    avVar.aBo.setImageDrawable(null);
                    avVar.aBo.d(portrait, 12, false);
                    avVar.azp.setText(this.mData.get(i).getName_show());
                    avVar.axW.setText(this.mData.get(i).getIntro());
                    avVar.bGr.setTag(Integer.valueOf(i));
                }
            } else {
                avVar.azp.setText(this.bGn.getPageContext().getString(com.baidu.tieba.z.loading));
                avVar.mProgress.setVisibility(0);
            }
            applyNightMode(view);
        }
        return view;
    }

    private void applyNightMode(View view) {
        this.bGn.getLayoutMode().ab(TbadkCoreApplication.m255getInst().getSkinType() == 1);
        this.bGn.getLayoutMode().h(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.bwQ) {
            return 0;
        }
        return (this.mData == null || i >= this.mData.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.bwQ) {
            return false;
        }
        return super.isEnabled(i);
    }
}
