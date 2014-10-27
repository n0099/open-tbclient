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
    private View.OnClickListener aJJ;
    private PersonFriendActivity bCA;
    private View.OnClickListener bCC;
    private int bnd;
    private boolean boM;
    private ArrayList<UserData> aew = null;
    private boolean mHasMore = false;
    private boolean bCB = false;
    private boolean bBc = false;
    private ArrayList<ProgressBar> btZ = new ArrayList<>();

    public void Sy() {
        if (this.btZ != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.btZ.size()) {
                    try {
                        this.btZ.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.btZ.clear();
                    return;
                }
            }
        }
    }

    public void ZG() {
        this.bBc = false;
        if (this.aew != null && this.aew.size() == 0) {
            this.bBc = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void eu(boolean z) {
        this.bCB = z;
    }

    public bb(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.bCA = null;
        this.boM = true;
        this.bnd = 0;
        this.bCC = null;
        this.aJJ = null;
        this.bCA = personFriendActivity;
        this.boM = z;
        this.bnd = i;
        this.bCC = onClickListener;
        this.aJJ = onClickListener2;
    }

    public void setData(ArrayList<UserData> arrayList) {
        this.aew = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bBc) {
            return 1;
        }
        int i = 0;
        if (this.aew != null) {
            i = this.aew.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aew == null || i >= this.aew.size()) {
            return null;
        }
        return this.aew.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.aew == null || i >= this.aew.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        bc bcVar;
        View view2;
        if (this.aew != null) {
            if (view == null) {
                bc bcVar2 = new bc(this, null);
                if (getItemViewType(i) == 0) {
                    View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.bCA, com.baidu.tieba.w.person_list_item_friend, null);
                    bcVar2.azk = (HeadImageView) inflate.findViewById(com.baidu.tieba.v.photo);
                    bcVar2.azk.setIsRound(false);
                    bcVar2.azk.setAutoChangeStyle(true);
                    bcVar2.bCE = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.info);
                    bcVar2.avZ = (TextView) inflate.findViewById(com.baidu.tieba.v.name);
                    bcVar2.bCF = (TextView) inflate.findViewById(com.baidu.tieba.v.at_list_nodata);
                    bcVar2.auD = (TextView) inflate.findViewById(com.baidu.tieba.v.intro);
                    bcVar2.bCD = (ImageView) inflate.findViewById(com.baidu.tieba.v.chat);
                    bcVar2.bfO = (ImageView) inflate.findViewById(com.baidu.tieba.v.diver_buttom_px);
                    bcVar2.bCD.setOnClickListener(this.bCC);
                    view2 = inflate;
                } else {
                    View inflate2 = com.baidu.adp.lib.g.b.ek().inflate(this.bCA, com.baidu.tieba.w.new_pb_list_more, null);
                    bcVar2.avZ = (TextView) inflate2.findViewById(com.baidu.tieba.v.pb_more_text);
                    inflate2.setOnClickListener(this.aJJ);
                    bcVar2.mProgress = (ProgressBar) inflate2.findViewById(com.baidu.tieba.v.progress);
                    this.btZ.add(bcVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(bcVar2);
                bcVar = bcVar2;
                view = view2;
            } else {
                bcVar = (bc) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.bBc) {
                    bcVar.bCE.setVisibility(8);
                    bcVar.bCD.setVisibility(8);
                    bcVar.bCF.setVisibility(8);
                    bcVar.bfO.setVisibility(8);
                } else {
                    if (!this.boM && this.bnd == 0) {
                        bcVar.bCD.setVisibility(8);
                    } else {
                        bcVar.bCD.setVisibility(0);
                    }
                    bcVar.bCE.setVisibility(0);
                    bcVar.bCE.setTag(Integer.valueOf(i));
                    bcVar.bfO.setVisibility(0);
                    bcVar.bCF.setVisibility(8);
                    String portrait = this.aew.get(i).getPortrait();
                    bcVar.azk.setImageDrawable(null);
                    bcVar.azk.c(portrait, 12, false);
                    bcVar.avZ.setText(this.aew.get(i).getName_show());
                    bcVar.auD.setText(this.aew.get(i).getIntro());
                    bcVar.bCD.setTag(Integer.valueOf(i));
                }
            } else {
                bcVar.avZ.setText(this.bCA.getString(com.baidu.tieba.y.loading));
                bcVar.mProgress.setVisibility(0);
            }
            F(view);
        }
        return view;
    }

    private void F(View view) {
        this.bCA.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
        this.bCA.getLayoutMode().h(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.bBc) {
            return 0;
        }
        return (this.aew == null || i >= this.aew.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.bBc) {
            return false;
        }
        return super.isEnabled(i);
    }
}
