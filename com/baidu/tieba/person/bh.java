package com.baidu.tieba.person;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.view.HeadImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bh extends BaseAdapter {
    private View.OnClickListener aSe;
    boolean aVz;
    private ArrayList<UserData> auK;
    private PersonListActivity bQQ;
    boolean bQR;
    private View.OnClickListener bQS;
    private View.OnClickListener bQT;
    private View.OnClickListener bQy;
    private int mSex;
    private boolean mHasMore = false;
    private boolean bQw = false;
    boolean bEh = false;

    public void Yg() {
        this.bEh = false;
        if (this.auK != null && this.auK.size() == 0) {
            this.bEh = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void ed(boolean z) {
        this.bQw = z;
    }

    public bh(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4) {
        this.auK = null;
        this.bQQ = null;
        this.bQR = false;
        this.aVz = true;
        this.mSex = 0;
        this.bQy = null;
        this.aSe = null;
        this.bQS = null;
        this.bQT = null;
        this.bQQ = personListActivity;
        this.bQR = z;
        this.aVz = z2;
        this.mSex = i;
        this.bQy = onClickListener2;
        this.aSe = onClickListener3;
        this.bQS = onClickListener;
        this.bQT = onClickListener4;
        this.auK = new ArrayList<>();
    }

    public void R(ArrayList<UserData> arrayList) {
        this.auK.addAll(arrayList);
    }

    public void resetData() {
        this.auK.clear();
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
        bi biVar;
        View view2;
        if (this.auK != null) {
            if (view == null) {
                bi biVar2 = new bi(this, null);
                if (getItemViewType(i) == 0) {
                    View inflate = com.baidu.adp.lib.g.b.hH().inflate(this.bQQ.getPageContext().getPageActivity(), com.baidu.tieba.w.person_list_item, null);
                    biVar2.bQU = (ViewGroup) inflate.findViewById(com.baidu.tieba.v.item_view);
                    biVar2.bQU.setOnClickListener(this.bQS);
                    biVar2.aIq = (HeadImageView) inflate.findViewById(com.baidu.tieba.v.photo);
                    biVar2.aIq.setIsRound(false);
                    biVar2.aIq.setAutoChangeStyle(true);
                    biVar2.bQA = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.info);
                    biVar2.aYa = (TextView) inflate.findViewById(com.baidu.tieba.v.name);
                    biVar2.bQB = (TextView) inflate.findViewById(com.baidu.tieba.v.at_list_nodata);
                    biVar2.aHo = (TextView) inflate.findViewById(com.baidu.tieba.v.intro);
                    biVar2.bQz = (ImageView) inflate.findViewById(com.baidu.tieba.v.chat);
                    biVar2.bQV = (TextView) inflate.findViewById(com.baidu.tieba.v.add);
                    biVar2.bQz.setOnClickListener(this.bQy);
                    biVar2.bQV.setOnClickListener(this.bQT);
                    biVar2.mProgress = null;
                    view2 = inflate;
                } else {
                    View inflate2 = com.baidu.adp.lib.g.b.hH().inflate(this.bQQ.getPageContext().getPageActivity(), com.baidu.tieba.w.new_pb_list_more, null);
                    biVar2.aYa = (TextView) inflate2.findViewById(com.baidu.tieba.v.pb_more_text);
                    inflate2.setOnClickListener(this.aSe);
                    biVar2.mProgress = (ProgressBar) inflate2.findViewById(com.baidu.tieba.v.progress);
                    view2 = inflate2;
                }
                view2.setTag(biVar2);
                biVar = biVar2;
                view = view2;
            } else {
                biVar = (bi) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.bEh) {
                    biVar.bQA.setVisibility(8);
                    biVar.bQz.setVisibility(8);
                    biVar.bQV.setVisibility(8);
                    biVar.bQB.setVisibility(0);
                    if (this.bQR) {
                        if (this.aVz) {
                            biVar.bQB.setText(com.baidu.tieba.y.not_have_attention);
                        } else if (this.mSex == 2) {
                            biVar.bQB.setText(com.baidu.tieba.y.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            biVar.bQB.setText(com.baidu.tieba.y.him_no_attention_other);
                        } else {
                            biVar.bQB.setText(com.baidu.tieba.y.no_attention_other);
                        }
                    } else if (this.aVz) {
                        biVar.bQB.setText(com.baidu.tieba.y.not_have_fans);
                    } else if (this.mSex == 2) {
                        biVar.bQB.setText(com.baidu.tieba.y.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        biVar.bQB.setText(com.baidu.tieba.y.him_no_fan_other);
                    } else {
                        biVar.bQB.setText(com.baidu.tieba.y.no_fan_other);
                    }
                } else {
                    biVar.bQU.setTag(Integer.valueOf(i));
                    biVar.bQz.setVisibility(0);
                    biVar.bQV.setVisibility(0);
                    biVar.bQA.setVisibility(0);
                    biVar.bQB.setVisibility(8);
                    biVar.aIq.c(this.auK.get(i).getPortrait(), 12, false);
                    biVar.aYa.setText(this.auK.get(i).getName_show());
                    biVar.aHo.setText(this.auK.get(i).getIntro());
                    biVar.bQz.setTag(Integer.valueOf(i));
                    biVar.bQV.setTag(Integer.valueOf(i));
                    String userId = this.auK.get(i).getUserId();
                    if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        biVar.bQz.setVisibility(8);
                        biVar.bQV.setVisibility(8);
                    } else if (this.auK.get(i).getIsFriend() == 1) {
                        biVar.bQz.setVisibility(0);
                        biVar.bQV.setVisibility(8);
                    } else {
                        biVar.bQz.setVisibility(8);
                        biVar.bQV.setVisibility(0);
                    }
                }
                biVar.mProgress = null;
            } else {
                biVar.aYa.setText(this.bQQ.getPageContext().getString(com.baidu.tieba.y.loading));
                biVar.mProgress.setVisibility(0);
            }
            applyNightMode(view);
        }
        return view;
    }

    private void applyNightMode(View view) {
        this.bQQ.getLayoutMode().X(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.bQQ.getLayoutMode().h(view);
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
