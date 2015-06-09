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
public class bk extends BaseAdapter {
    private View.OnClickListener aUg;
    private boolean aYg;
    private int bRW;
    private PersonFriendActivity bTb;
    private View.OnClickListener bTe;
    private ArrayList<UserData> Sk = null;
    private boolean mHasMore = false;
    private boolean bTc = false;
    private boolean bHd = false;
    private ArrayList<ProgressBar> bTd = new ArrayList<>();

    public void ZG() {
        if (this.bTd != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.bTd.size()) {
                    try {
                        this.bTd.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.bTd.clear();
                    return;
                }
            }
        }
    }

    public void ZH() {
        this.bHd = false;
        if (this.Sk != null && this.Sk.size() == 0) {
            this.bHd = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void ep(boolean z) {
        this.bTc = z;
    }

    public bk(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.bTb = null;
        this.aYg = true;
        this.bRW = 0;
        this.bTe = null;
        this.aUg = null;
        this.bTb = personFriendActivity;
        this.aYg = z;
        this.bRW = i;
        this.bTe = onClickListener;
        this.aUg = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.Sk = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bHd) {
            return 1;
        }
        int i = 0;
        if (this.Sk != null) {
            i = this.Sk.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.Sk == null || i >= this.Sk.size()) {
            return null;
        }
        return this.Sk.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.Sk == null || i >= this.Sk.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        bl blVar;
        View view2;
        if (this.Sk != null) {
            if (view == null) {
                bl blVar2 = new bl(this, null);
                if (getItemViewType(i) == 0) {
                    View inflate = com.baidu.adp.lib.g.b.hr().inflate(this.bTb.getPageContext().getPageActivity(), com.baidu.tieba.r.person_list_item_friend, null);
                    blVar2.aKz = (HeadImageView) inflate.findViewById(com.baidu.tieba.q.photo);
                    blVar2.aKz.setIsRound(false);
                    blVar2.aKz.setAutoChangeStyle(true);
                    blVar2.bTg = (LinearLayout) inflate.findViewById(com.baidu.tieba.q.info);
                    blVar2.baI = (TextView) inflate.findViewById(com.baidu.tieba.q.name);
                    blVar2.bTh = (TextView) inflate.findViewById(com.baidu.tieba.q.at_list_nodata);
                    blVar2.aJx = (TextView) inflate.findViewById(com.baidu.tieba.q.intro);
                    blVar2.bTf = (ImageView) inflate.findViewById(com.baidu.tieba.q.chat);
                    blVar2.bow = (ImageView) inflate.findViewById(com.baidu.tieba.q.diver_buttom_px);
                    blVar2.bTf.setOnClickListener(this.bTe);
                    view2 = inflate;
                } else {
                    View inflate2 = com.baidu.adp.lib.g.b.hr().inflate(this.bTb.getPageContext().getPageActivity(), com.baidu.tieba.r.new_pb_list_more, null);
                    blVar2.baI = (TextView) inflate2.findViewById(com.baidu.tieba.q.pb_more_text);
                    inflate2.setOnClickListener(this.aUg);
                    blVar2.mProgress = (ProgressBar) inflate2.findViewById(com.baidu.tieba.q.progress);
                    this.bTd.add(blVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(blVar2);
                blVar = blVar2;
                view = view2;
            } else {
                blVar = (bl) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.bHd) {
                    blVar.bTg.setVisibility(8);
                    blVar.bTf.setVisibility(8);
                    blVar.bTh.setVisibility(8);
                    blVar.bow.setVisibility(8);
                } else {
                    if (!this.aYg && this.bRW == 0) {
                        blVar.bTf.setVisibility(8);
                    } else {
                        blVar.bTf.setVisibility(0);
                    }
                    blVar.bTg.setVisibility(0);
                    blVar.bTg.setTag(Integer.valueOf(i));
                    blVar.bow.setVisibility(0);
                    blVar.bTh.setVisibility(8);
                    String portrait = this.Sk.get(i).getPortrait();
                    blVar.aKz.setImageDrawable(null);
                    blVar.aKz.c(portrait, 12, false);
                    blVar.baI.setText(this.Sk.get(i).getName_show());
                    blVar.aJx.setText(this.Sk.get(i).getIntro());
                    blVar.bTf.setTag(Integer.valueOf(i));
                }
            } else {
                blVar.baI.setText(this.bTb.getPageContext().getString(com.baidu.tieba.t.loading));
                blVar.mProgress.setVisibility(0);
            }
            applyNightMode(view);
        }
        return view;
    }

    private void applyNightMode(View view) {
        this.bTb.getLayoutMode().ab(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.bTb.getLayoutMode().j(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.bHd) {
            return 0;
        }
        return (this.Sk == null || i >= this.Sk.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.bHd) {
            return false;
        }
        return super.isEnabled(i);
    }
}
