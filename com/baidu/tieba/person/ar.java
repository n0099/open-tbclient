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
    private View.OnClickListener aRO;
    private boolean aVk;
    private int bPB;
    private PersonFriendActivity bQf;
    private View.OnClickListener bQi;
    private ArrayList<UserData> auC = null;
    private boolean mHasMore = false;
    private boolean bQg = false;
    private boolean bDU = false;
    private ArrayList<ProgressBar> bQh = new ArrayList<>();

    public void WK() {
        if (this.bQh != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.bQh.size()) {
                    try {
                        this.bQh.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.bQh.clear();
                    return;
                }
            }
        }
    }

    public void XU() {
        this.bDU = false;
        if (this.auC != null && this.auC.size() == 0) {
            this.bDU = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void ef(boolean z) {
        this.bQg = z;
    }

    public ar(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.bQf = null;
        this.aVk = true;
        this.bPB = 0;
        this.bQi = null;
        this.aRO = null;
        this.bQf = personFriendActivity;
        this.aVk = z;
        this.bPB = i;
        this.bQi = onClickListener;
        this.aRO = onClickListener2;
    }

    public void p(ArrayList<UserData> arrayList) {
        this.auC = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bDU) {
            return 1;
        }
        int i = 0;
        if (this.auC != null) {
            i = this.auC.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.auC == null || i >= this.auC.size()) {
            return null;
        }
        return this.auC.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.auC == null || i >= this.auC.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        as asVar;
        View view2;
        if (this.auC != null) {
            if (view == null) {
                as asVar2 = new as(this, null);
                if (getItemViewType(i) == 0) {
                    View inflate = com.baidu.adp.lib.g.b.hH().inflate(this.bQf.getPageContext().getPageActivity(), com.baidu.tieba.w.person_list_item_friend, null);
                    asVar2.aIi = (HeadImageView) inflate.findViewById(com.baidu.tieba.v.photo);
                    asVar2.aIi.setIsRound(false);
                    asVar2.aIi.setAutoChangeStyle(true);
                    asVar2.bQk = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.info);
                    asVar2.aXK = (TextView) inflate.findViewById(com.baidu.tieba.v.name);
                    asVar2.bQl = (TextView) inflate.findViewById(com.baidu.tieba.v.at_list_nodata);
                    asVar2.aHg = (TextView) inflate.findViewById(com.baidu.tieba.v.intro);
                    asVar2.bQj = (ImageView) inflate.findViewById(com.baidu.tieba.v.chat);
                    asVar2.blB = (ImageView) inflate.findViewById(com.baidu.tieba.v.diver_buttom_px);
                    asVar2.bQj.setOnClickListener(this.bQi);
                    view2 = inflate;
                } else {
                    View inflate2 = com.baidu.adp.lib.g.b.hH().inflate(this.bQf.getPageContext().getPageActivity(), com.baidu.tieba.w.new_pb_list_more, null);
                    asVar2.aXK = (TextView) inflate2.findViewById(com.baidu.tieba.v.pb_more_text);
                    inflate2.setOnClickListener(this.aRO);
                    asVar2.mProgress = (ProgressBar) inflate2.findViewById(com.baidu.tieba.v.progress);
                    this.bQh.add(asVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(asVar2);
                asVar = asVar2;
                view = view2;
            } else {
                asVar = (as) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.bDU) {
                    asVar.bQk.setVisibility(8);
                    asVar.bQj.setVisibility(8);
                    asVar.bQl.setVisibility(8);
                    asVar.blB.setVisibility(8);
                } else {
                    if (!this.aVk && this.bPB == 0) {
                        asVar.bQj.setVisibility(8);
                    } else {
                        asVar.bQj.setVisibility(0);
                    }
                    asVar.bQk.setVisibility(0);
                    asVar.bQk.setTag(Integer.valueOf(i));
                    asVar.blB.setVisibility(0);
                    asVar.bQl.setVisibility(8);
                    String portrait = this.auC.get(i).getPortrait();
                    asVar.aIi.setImageDrawable(null);
                    asVar.aIi.c(portrait, 12, false);
                    asVar.aXK.setText(this.auC.get(i).getName_show());
                    asVar.aHg.setText(this.auC.get(i).getIntro());
                    asVar.bQj.setTag(Integer.valueOf(i));
                }
            } else {
                asVar.aXK.setText(this.bQf.getPageContext().getString(com.baidu.tieba.y.loading));
                asVar.mProgress.setVisibility(0);
            }
            applyNightMode(view);
        }
        return view;
    }

    private void applyNightMode(View view) {
        this.bQf.getLayoutMode().X(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.bQf.getLayoutMode().h(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.bDU) {
            return 0;
        }
        return (this.auC == null || i >= this.auC.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.bDU) {
            return false;
        }
        return super.isEnabled(i);
    }
}
