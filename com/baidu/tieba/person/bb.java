package com.baidu.tieba.person;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.view.HeadImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bb extends BaseAdapter {
    private View.OnClickListener aJW;
    private PersonFriendActivity bCO;
    private View.OnClickListener bCQ;
    private int bnr;
    private boolean bpa;
    private ArrayList<UserData> aeE = null;
    private boolean mHasMore = false;
    private boolean bCP = false;
    private boolean bBq = false;
    private ArrayList<ProgressBar> bun = new ArrayList<>();

    public void SB() {
        if (this.bun != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.bun.size()) {
                    try {
                        this.bun.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.bun.clear();
                    return;
                }
            }
        }
    }

    public void ZI() {
        this.bBq = false;
        if (this.aeE != null && this.aeE.size() == 0) {
            this.bBq = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void eu(boolean z) {
        this.bCP = z;
    }

    public bb(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.bCO = null;
        this.bpa = true;
        this.bnr = 0;
        this.bCQ = null;
        this.aJW = null;
        this.bCO = personFriendActivity;
        this.bpa = z;
        this.bnr = i;
        this.bCQ = onClickListener;
        this.aJW = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.aeE = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bBq) {
            return 1;
        }
        int i = 0;
        if (this.aeE != null) {
            i = this.aeE.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aeE == null || i >= this.aeE.size()) {
            return null;
        }
        return this.aeE.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.aeE == null || i >= this.aeE.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        bc bcVar;
        View view2;
        if (this.aeE != null) {
            if (view == null) {
                bc bcVar2 = new bc(this, null);
                if (getItemViewType(i) == 0) {
                    View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.bCO, com.baidu.tieba.w.person_list_item_friend, null);
                    bcVar2.azt = (HeadImageView) inflate.findViewById(com.baidu.tieba.v.photo);
                    bcVar2.azt.setIsRound(false);
                    bcVar2.azt.setAutoChangeStyle(true);
                    bcVar2.bCS = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.info);
                    bcVar2.awi = (TextView) inflate.findViewById(com.baidu.tieba.v.name);
                    bcVar2.bCT = (TextView) inflate.findViewById(com.baidu.tieba.v.at_list_nodata);
                    bcVar2.auM = (TextView) inflate.findViewById(com.baidu.tieba.v.intro);
                    bcVar2.bCR = (ImageView) inflate.findViewById(com.baidu.tieba.v.chat);
                    bcVar2.bgc = (ImageView) inflate.findViewById(com.baidu.tieba.v.diver_buttom_px);
                    bcVar2.bCR.setOnClickListener(this.bCQ);
                    view2 = inflate;
                } else {
                    View inflate2 = com.baidu.adp.lib.g.b.ek().inflate(this.bCO, com.baidu.tieba.w.new_pb_list_more, null);
                    bcVar2.awi = (TextView) inflate2.findViewById(com.baidu.tieba.v.pb_more_text);
                    inflate2.setOnClickListener(this.aJW);
                    bcVar2.mProgress = (ProgressBar) inflate2.findViewById(com.baidu.tieba.v.progress);
                    this.bun.add(bcVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(bcVar2);
                bcVar = bcVar2;
                view = view2;
            } else {
                bcVar = (bc) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.bBq) {
                    bcVar.bCS.setVisibility(8);
                    bcVar.bCR.setVisibility(8);
                    bcVar.bCT.setVisibility(8);
                    bcVar.bgc.setVisibility(8);
                } else {
                    if (!this.bpa && this.bnr == 0) {
                        bcVar.bCR.setVisibility(8);
                    } else {
                        bcVar.bCR.setVisibility(0);
                    }
                    bcVar.bCS.setVisibility(0);
                    bcVar.bCS.setTag(Integer.valueOf(i));
                    bcVar.bgc.setVisibility(0);
                    bcVar.bCT.setVisibility(8);
                    String portrait = this.aeE.get(i).getPortrait();
                    bcVar.azt.setImageDrawable(null);
                    bcVar.azt.c(portrait, 12, false);
                    bcVar.awi.setText(this.aeE.get(i).getName_show());
                    bcVar.auM.setText(this.aeE.get(i).getIntro());
                    bcVar.bCR.setTag(Integer.valueOf(i));
                }
            } else {
                bcVar.awi.setText(this.bCO.getString(com.baidu.tieba.y.loading));
                bcVar.mProgress.setVisibility(0);
            }
            F(view);
        }
        return view;
    }

    private void F(View view) {
        this.bCO.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
        this.bCO.getLayoutMode().h(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.bBq) {
            return 0;
        }
        return (this.aeE == null || i >= this.aeE.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.bBq) {
            return false;
        }
        return super.isEnabled(i);
    }
}
