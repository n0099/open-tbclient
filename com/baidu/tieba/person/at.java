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
    private View.OnClickListener aLP;
    private int bGY;
    private PersonFriendActivity bHY;
    private View.OnClickListener bIb;
    private boolean bze;
    private ArrayList<UserData> amP = null;
    private boolean mHasMore = false;
    private boolean bHZ = false;
    private boolean byz = false;
    private ArrayList<ProgressBar> bIa = new ArrayList<>();

    public void Ug() {
        if (this.bIa != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.bIa.size()) {
                    try {
                        this.bIa.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.bIa.clear();
                    return;
                }
            }
        }
    }

    public void WH() {
        this.byz = false;
        if (this.amP != null && this.amP.size() == 0) {
            this.byz = true;
        }
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void ei(boolean z) {
        this.bHZ = z;
    }

    public at(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.bHY = null;
        this.bze = true;
        this.bGY = 0;
        this.bIb = null;
        this.aLP = null;
        this.bHY = personFriendActivity;
        this.bze = z;
        this.bGY = i;
        this.bIb = onClickListener;
        this.aLP = onClickListener2;
    }

    public void s(ArrayList<UserData> arrayList) {
        this.amP = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.byz) {
            return 1;
        }
        int i = 0;
        if (this.amP != null) {
            i = this.amP.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.amP == null || i >= this.amP.size()) {
            return null;
        }
        return this.amP.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.amP == null || i >= this.amP.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        au auVar;
        View view2;
        if (this.amP != null) {
            if (view == null) {
                au auVar2 = new au(this, null);
                if (getItemViewType(i) == 0) {
                    View inflate = com.baidu.adp.lib.g.b.ei().inflate(this.bHY.getPageContext().getPageActivity(), com.baidu.tieba.x.person_list_item_friend, null);
                    auVar2.aCp = (HeadImageView) inflate.findViewById(com.baidu.tieba.w.photo);
                    auVar2.aCp.setIsRound(false);
                    auVar2.aCp.setAutoChangeStyle(true);
                    auVar2.bId = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.info);
                    auVar2.aAq = (TextView) inflate.findViewById(com.baidu.tieba.w.name);
                    auVar2.bIe = (TextView) inflate.findViewById(com.baidu.tieba.w.at_list_nodata);
                    auVar2.ayW = (TextView) inflate.findViewById(com.baidu.tieba.w.intro);
                    auVar2.bIc = (ImageView) inflate.findViewById(com.baidu.tieba.w.chat);
                    auVar2.bkN = (ImageView) inflate.findViewById(com.baidu.tieba.w.diver_buttom_px);
                    auVar2.bIc.setOnClickListener(this.bIb);
                    view2 = inflate;
                } else {
                    View inflate2 = com.baidu.adp.lib.g.b.ei().inflate(this.bHY.getPageContext().getPageActivity(), com.baidu.tieba.x.new_pb_list_more, null);
                    auVar2.aAq = (TextView) inflate2.findViewById(com.baidu.tieba.w.pb_more_text);
                    inflate2.setOnClickListener(this.aLP);
                    auVar2.mProgress = (ProgressBar) inflate2.findViewById(com.baidu.tieba.w.progress);
                    this.bIa.add(auVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(auVar2);
                auVar = auVar2;
                view = view2;
            } else {
                auVar = (au) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.byz) {
                    auVar.bId.setVisibility(8);
                    auVar.bIc.setVisibility(8);
                    auVar.bIe.setVisibility(8);
                    auVar.bkN.setVisibility(8);
                } else {
                    if (!this.bze && this.bGY == 0) {
                        auVar.bIc.setVisibility(8);
                    } else {
                        auVar.bIc.setVisibility(0);
                    }
                    auVar.bId.setVisibility(0);
                    auVar.bId.setTag(Integer.valueOf(i));
                    auVar.bkN.setVisibility(0);
                    auVar.bIe.setVisibility(8);
                    String portrait = this.amP.get(i).getPortrait();
                    auVar.aCp.setImageDrawable(null);
                    auVar.aCp.d(portrait, 12, false);
                    auVar.aAq.setText(this.amP.get(i).getName_show());
                    auVar.ayW.setText(this.amP.get(i).getIntro());
                    auVar.bIc.setTag(Integer.valueOf(i));
                }
            } else {
                auVar.aAq.setText(this.bHY.getPageContext().getString(com.baidu.tieba.z.loading));
                auVar.mProgress.setVisibility(0);
            }
            applyNightMode(view);
        }
        return view;
    }

    private void applyNightMode(View view) {
        this.bHY.getLayoutMode().ab(TbadkCoreApplication.m255getInst().getSkinType() == 1);
        this.bHY.getLayoutMode().h(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.byz) {
            return 0;
        }
        return (this.amP == null || i >= this.amP.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.byz) {
            return false;
        }
        return super.isEnabled(i);
    }
}
