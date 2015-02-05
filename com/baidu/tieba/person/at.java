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
public class at extends BaseAdapter {
    private View.OnClickListener aLM;
    private int bGX;
    private PersonFriendActivity bHX;
    private View.OnClickListener bIa;
    private boolean bzd;
    private ArrayList<UserData> amM = null;
    private boolean mHasMore = false;
    private boolean bHY = false;
    private boolean byy = false;
    private ArrayList<ProgressBar> bHZ = new ArrayList<>();

    public void Ub() {
        if (this.bHZ != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.bHZ.size()) {
                    try {
                        this.bHZ.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.bHZ.clear();
                    return;
                }
            }
        }
    }

    public void WC() {
        this.byy = false;
        if (this.amM != null && this.amM.size() == 0) {
            this.byy = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void ei(boolean z) {
        this.bHY = z;
    }

    public at(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.bHX = null;
        this.bzd = true;
        this.bGX = 0;
        this.bIa = null;
        this.aLM = null;
        this.bHX = personFriendActivity;
        this.bzd = z;
        this.bGX = i;
        this.bIa = onClickListener;
        this.aLM = onClickListener2;
    }

    public void s(ArrayList<UserData> arrayList) {
        this.amM = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.byy) {
            return 1;
        }
        int i = 0;
        if (this.amM != null) {
            i = this.amM.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.amM == null || i >= this.amM.size()) {
            return null;
        }
        return this.amM.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.amM == null || i >= this.amM.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        au auVar;
        View view2;
        if (this.amM != null) {
            if (view == null) {
                au auVar2 = new au(this, null);
                if (getItemViewType(i) == 0) {
                    View inflate = com.baidu.adp.lib.g.b.ei().inflate(this.bHX.getPageContext().getPageActivity(), com.baidu.tieba.x.person_list_item_friend, null);
                    auVar2.aCm = (HeadImageView) inflate.findViewById(com.baidu.tieba.w.photo);
                    auVar2.aCm.setIsRound(false);
                    auVar2.aCm.setAutoChangeStyle(true);
                    auVar2.bIc = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.info);
                    auVar2.aAn = (TextView) inflate.findViewById(com.baidu.tieba.w.name);
                    auVar2.bId = (TextView) inflate.findViewById(com.baidu.tieba.w.at_list_nodata);
                    auVar2.ayT = (TextView) inflate.findViewById(com.baidu.tieba.w.intro);
                    auVar2.bIb = (ImageView) inflate.findViewById(com.baidu.tieba.w.chat);
                    auVar2.bkM = (ImageView) inflate.findViewById(com.baidu.tieba.w.diver_buttom_px);
                    auVar2.bIb.setOnClickListener(this.bIa);
                    view2 = inflate;
                } else {
                    View inflate2 = com.baidu.adp.lib.g.b.ei().inflate(this.bHX.getPageContext().getPageActivity(), com.baidu.tieba.x.new_pb_list_more, null);
                    auVar2.aAn = (TextView) inflate2.findViewById(com.baidu.tieba.w.pb_more_text);
                    inflate2.setOnClickListener(this.aLM);
                    auVar2.mProgress = (ProgressBar) inflate2.findViewById(com.baidu.tieba.w.progress);
                    this.bHZ.add(auVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(auVar2);
                auVar = auVar2;
                view = view2;
            } else {
                auVar = (au) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.byy) {
                    auVar.bIc.setVisibility(8);
                    auVar.bIb.setVisibility(8);
                    auVar.bId.setVisibility(8);
                    auVar.bkM.setVisibility(8);
                } else {
                    if (!this.bzd && this.bGX == 0) {
                        auVar.bIb.setVisibility(8);
                    } else {
                        auVar.bIb.setVisibility(0);
                    }
                    auVar.bIc.setVisibility(0);
                    auVar.bIc.setTag(Integer.valueOf(i));
                    auVar.bkM.setVisibility(0);
                    auVar.bId.setVisibility(8);
                    String portrait = this.amM.get(i).getPortrait();
                    auVar.aCm.setImageDrawable(null);
                    auVar.aCm.d(portrait, 12, false);
                    auVar.aAn.setText(this.amM.get(i).getName_show());
                    auVar.ayT.setText(this.amM.get(i).getIntro());
                    auVar.bIb.setTag(Integer.valueOf(i));
                }
            } else {
                auVar.aAn.setText(this.bHX.getPageContext().getString(com.baidu.tieba.z.loading));
                auVar.mProgress.setVisibility(0);
            }
            applyNightMode(view);
        }
        return view;
    }

    private void applyNightMode(View view) {
        this.bHX.getLayoutMode().ab(TbadkCoreApplication.m255getInst().getSkinType() == 1);
        this.bHX.getLayoutMode().h(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.byy) {
            return 0;
        }
        return (this.amM == null || i >= this.amM.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.byy) {
            return false;
        }
        return super.isEnabled(i);
    }
}
