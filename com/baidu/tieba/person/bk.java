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
    private View.OnClickListener aUf;
    private boolean aYf;
    private int bRV;
    private PersonFriendActivity bTa;
    private View.OnClickListener bTd;
    private ArrayList<UserData> Sk = null;
    private boolean mHasMore = false;
    private boolean bTb = false;
    private boolean bHc = false;
    private ArrayList<ProgressBar> bTc = new ArrayList<>();

    public void ZF() {
        if (this.bTc != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.bTc.size()) {
                    try {
                        this.bTc.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.bTc.clear();
                    return;
                }
            }
        }
    }

    public void ZG() {
        this.bHc = false;
        if (this.Sk != null && this.Sk.size() == 0) {
            this.bHc = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void ep(boolean z) {
        this.bTb = z;
    }

    public bk(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.bTa = null;
        this.aYf = true;
        this.bRV = 0;
        this.bTd = null;
        this.aUf = null;
        this.bTa = personFriendActivity;
        this.aYf = z;
        this.bRV = i;
        this.bTd = onClickListener;
        this.aUf = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.Sk = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bHc) {
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
                    View inflate = com.baidu.adp.lib.g.b.hr().inflate(this.bTa.getPageContext().getPageActivity(), com.baidu.tieba.r.person_list_item_friend, null);
                    blVar2.aKy = (HeadImageView) inflate.findViewById(com.baidu.tieba.q.photo);
                    blVar2.aKy.setIsRound(false);
                    blVar2.aKy.setAutoChangeStyle(true);
                    blVar2.bTf = (LinearLayout) inflate.findViewById(com.baidu.tieba.q.info);
                    blVar2.baH = (TextView) inflate.findViewById(com.baidu.tieba.q.name);
                    blVar2.bTg = (TextView) inflate.findViewById(com.baidu.tieba.q.at_list_nodata);
                    blVar2.aJw = (TextView) inflate.findViewById(com.baidu.tieba.q.intro);
                    blVar2.bTe = (ImageView) inflate.findViewById(com.baidu.tieba.q.chat);
                    blVar2.bov = (ImageView) inflate.findViewById(com.baidu.tieba.q.diver_buttom_px);
                    blVar2.bTe.setOnClickListener(this.bTd);
                    view2 = inflate;
                } else {
                    View inflate2 = com.baidu.adp.lib.g.b.hr().inflate(this.bTa.getPageContext().getPageActivity(), com.baidu.tieba.r.new_pb_list_more, null);
                    blVar2.baH = (TextView) inflate2.findViewById(com.baidu.tieba.q.pb_more_text);
                    inflate2.setOnClickListener(this.aUf);
                    blVar2.mProgress = (ProgressBar) inflate2.findViewById(com.baidu.tieba.q.progress);
                    this.bTc.add(blVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(blVar2);
                blVar = blVar2;
                view = view2;
            } else {
                blVar = (bl) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.bHc) {
                    blVar.bTf.setVisibility(8);
                    blVar.bTe.setVisibility(8);
                    blVar.bTg.setVisibility(8);
                    blVar.bov.setVisibility(8);
                } else {
                    if (!this.aYf && this.bRV == 0) {
                        blVar.bTe.setVisibility(8);
                    } else {
                        blVar.bTe.setVisibility(0);
                    }
                    blVar.bTf.setVisibility(0);
                    blVar.bTf.setTag(Integer.valueOf(i));
                    blVar.bov.setVisibility(0);
                    blVar.bTg.setVisibility(8);
                    String portrait = this.Sk.get(i).getPortrait();
                    blVar.aKy.setImageDrawable(null);
                    blVar.aKy.c(portrait, 12, false);
                    blVar.baH.setText(this.Sk.get(i).getName_show());
                    blVar.aJw.setText(this.Sk.get(i).getIntro());
                    blVar.bTe.setTag(Integer.valueOf(i));
                }
            } else {
                blVar.baH.setText(this.bTa.getPageContext().getString(com.baidu.tieba.t.loading));
                blVar.mProgress.setVisibility(0);
            }
            applyNightMode(view);
        }
        return view;
    }

    private void applyNightMode(View view) {
        this.bTa.getLayoutMode().ab(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.bTa.getLayoutMode().j(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.bHc) {
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
        if (this.bHc) {
            return false;
        }
        return super.isEnabled(i);
    }
}
