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
public class ar extends BaseAdapter {
    private View.OnClickListener aSe;
    private boolean aVz;
    private int bPR;
    private PersonFriendActivity bQv;
    private View.OnClickListener bQy;
    private ArrayList<UserData> auK = null;
    private boolean mHasMore = false;
    private boolean bQw = false;
    private boolean bEh = false;
    private ArrayList<ProgressBar> bQx = new ArrayList<>();

    public void WU() {
        if (this.bQx != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.bQx.size()) {
                    try {
                        this.bQx.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.bQx.clear();
                    return;
                }
            }
        }
    }

    public void Yg() {
        this.bEh = false;
        if (this.auK != null && this.auK.size() == 0) {
            this.bEh = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void ed(boolean z) {
        this.bQw = z;
    }

    public ar(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.bQv = null;
        this.aVz = true;
        this.bPR = 0;
        this.bQy = null;
        this.aSe = null;
        this.bQv = personFriendActivity;
        this.aVz = z;
        this.bPR = i;
        this.bQy = onClickListener;
        this.aSe = onClickListener2;
    }

    public void p(ArrayList<UserData> arrayList) {
        this.auK = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bEh) {
            return 1;
        }
        int i = 0;
        if (this.auK != null) {
            i = this.auK.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.auK == null || i >= this.auK.size()) {
            return null;
        }
        return this.auK.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.auK == null || i >= this.auK.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        as asVar;
        View view2;
        if (this.auK != null) {
            if (view == null) {
                as asVar2 = new as(this, null);
                if (getItemViewType(i) == 0) {
                    View inflate = com.baidu.adp.lib.g.b.hH().inflate(this.bQv.getPageContext().getPageActivity(), com.baidu.tieba.w.person_list_item_friend, null);
                    asVar2.aIq = (HeadImageView) inflate.findViewById(com.baidu.tieba.v.photo);
                    asVar2.aIq.setIsRound(false);
                    asVar2.aIq.setAutoChangeStyle(true);
                    asVar2.bQA = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.info);
                    asVar2.aYa = (TextView) inflate.findViewById(com.baidu.tieba.v.name);
                    asVar2.bQB = (TextView) inflate.findViewById(com.baidu.tieba.v.at_list_nodata);
                    asVar2.aHo = (TextView) inflate.findViewById(com.baidu.tieba.v.intro);
                    asVar2.bQz = (ImageView) inflate.findViewById(com.baidu.tieba.v.chat);
                    asVar2.blR = (ImageView) inflate.findViewById(com.baidu.tieba.v.diver_buttom_px);
                    asVar2.bQz.setOnClickListener(this.bQy);
                    view2 = inflate;
                } else {
                    View inflate2 = com.baidu.adp.lib.g.b.hH().inflate(this.bQv.getPageContext().getPageActivity(), com.baidu.tieba.w.new_pb_list_more, null);
                    asVar2.aYa = (TextView) inflate2.findViewById(com.baidu.tieba.v.pb_more_text);
                    inflate2.setOnClickListener(this.aSe);
                    asVar2.mProgress = (ProgressBar) inflate2.findViewById(com.baidu.tieba.v.progress);
                    this.bQx.add(asVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(asVar2);
                asVar = asVar2;
                view = view2;
            } else {
                asVar = (as) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.bEh) {
                    asVar.bQA.setVisibility(8);
                    asVar.bQz.setVisibility(8);
                    asVar.bQB.setVisibility(8);
                    asVar.blR.setVisibility(8);
                } else {
                    if (!this.aVz && this.bPR == 0) {
                        asVar.bQz.setVisibility(8);
                    } else {
                        asVar.bQz.setVisibility(0);
                    }
                    asVar.bQA.setVisibility(0);
                    asVar.bQA.setTag(Integer.valueOf(i));
                    asVar.blR.setVisibility(0);
                    asVar.bQB.setVisibility(8);
                    String portrait = this.auK.get(i).getPortrait();
                    asVar.aIq.setImageDrawable(null);
                    asVar.aIq.c(portrait, 12, false);
                    asVar.aYa.setText(this.auK.get(i).getName_show());
                    asVar.aHo.setText(this.auK.get(i).getIntro());
                    asVar.bQz.setTag(Integer.valueOf(i));
                }
            } else {
                asVar.aYa.setText(this.bQv.getPageContext().getString(com.baidu.tieba.y.loading));
                asVar.mProgress.setVisibility(0);
            }
            applyNightMode(view);
        }
        return view;
    }

    private void applyNightMode(View view) {
        this.bQv.getLayoutMode().X(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.bQv.getLayoutMode().h(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.bEh) {
            return 0;
        }
        return (this.auK == null || i >= this.auK.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.bEh) {
            return false;
        }
        return super.isEnabled(i);
    }
}
