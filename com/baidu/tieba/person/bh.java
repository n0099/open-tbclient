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
    private View.OnClickListener aRO;
    boolean aVk;
    private ArrayList<UserData> auC;
    private PersonListActivity bQA;
    boolean bQB;
    private View.OnClickListener bQC;
    private View.OnClickListener bQD;
    private View.OnClickListener bQi;
    private int mSex;
    private boolean mHasMore = false;
    private boolean bQg = false;
    boolean bDU = false;

    public void XU() {
        this.bDU = false;
        if (this.auC != null && this.auC.size() == 0) {
            this.bDU = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void ef(boolean z) {
        this.bQg = z;
    }

    public bh(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4) {
        this.auC = null;
        this.bQA = null;
        this.bQB = false;
        this.aVk = true;
        this.mSex = 0;
        this.bQi = null;
        this.aRO = null;
        this.bQC = null;
        this.bQD = null;
        this.bQA = personListActivity;
        this.bQB = z;
        this.aVk = z2;
        this.mSex = i;
        this.bQi = onClickListener2;
        this.aRO = onClickListener3;
        this.bQC = onClickListener;
        this.bQD = onClickListener4;
        this.auC = new ArrayList<>();
    }

    public void P(ArrayList<UserData> arrayList) {
        this.auC.addAll(arrayList);
    }

    public void resetData() {
        this.auC.clear();
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
        bi biVar;
        View view2;
        if (this.auC != null) {
            if (view == null) {
                bi biVar2 = new bi(this, null);
                if (getItemViewType(i) == 0) {
                    View inflate = com.baidu.adp.lib.g.b.hH().inflate(this.bQA.getPageContext().getPageActivity(), com.baidu.tieba.w.person_list_item, null);
                    biVar2.bQE = (ViewGroup) inflate.findViewById(com.baidu.tieba.v.item_view);
                    biVar2.bQE.setOnClickListener(this.bQC);
                    biVar2.aIi = (HeadImageView) inflate.findViewById(com.baidu.tieba.v.photo);
                    biVar2.aIi.setIsRound(false);
                    biVar2.aIi.setAutoChangeStyle(true);
                    biVar2.bQk = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.info);
                    biVar2.aXK = (TextView) inflate.findViewById(com.baidu.tieba.v.name);
                    biVar2.bQl = (TextView) inflate.findViewById(com.baidu.tieba.v.at_list_nodata);
                    biVar2.aHg = (TextView) inflate.findViewById(com.baidu.tieba.v.intro);
                    biVar2.bQj = (ImageView) inflate.findViewById(com.baidu.tieba.v.chat);
                    biVar2.bQF = (TextView) inflate.findViewById(com.baidu.tieba.v.add);
                    biVar2.bQj.setOnClickListener(this.bQi);
                    biVar2.bQF.setOnClickListener(this.bQD);
                    biVar2.mProgress = null;
                    view2 = inflate;
                } else {
                    View inflate2 = com.baidu.adp.lib.g.b.hH().inflate(this.bQA.getPageContext().getPageActivity(), com.baidu.tieba.w.new_pb_list_more, null);
                    biVar2.aXK = (TextView) inflate2.findViewById(com.baidu.tieba.v.pb_more_text);
                    inflate2.setOnClickListener(this.aRO);
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
                if (this.bDU) {
                    biVar.bQk.setVisibility(8);
                    biVar.bQj.setVisibility(8);
                    biVar.bQF.setVisibility(8);
                    biVar.bQl.setVisibility(0);
                    if (this.bQB) {
                        if (this.aVk) {
                            biVar.bQl.setText(com.baidu.tieba.y.not_have_attention);
                        } else if (this.mSex == 2) {
                            biVar.bQl.setText(com.baidu.tieba.y.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            biVar.bQl.setText(com.baidu.tieba.y.him_no_attention_other);
                        } else {
                            biVar.bQl.setText(com.baidu.tieba.y.no_attention_other);
                        }
                    } else if (this.aVk) {
                        biVar.bQl.setText(com.baidu.tieba.y.not_have_fans);
                    } else if (this.mSex == 2) {
                        biVar.bQl.setText(com.baidu.tieba.y.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        biVar.bQl.setText(com.baidu.tieba.y.him_no_fan_other);
                    } else {
                        biVar.bQl.setText(com.baidu.tieba.y.no_fan_other);
                    }
                } else {
                    biVar.bQE.setTag(Integer.valueOf(i));
                    biVar.bQj.setVisibility(0);
                    biVar.bQF.setVisibility(0);
                    biVar.bQk.setVisibility(0);
                    biVar.bQl.setVisibility(8);
                    biVar.aIi.c(this.auC.get(i).getPortrait(), 12, false);
                    biVar.aXK.setText(this.auC.get(i).getName_show());
                    biVar.aHg.setText(this.auC.get(i).getIntro());
                    biVar.bQj.setTag(Integer.valueOf(i));
                    biVar.bQF.setTag(Integer.valueOf(i));
                    String userId = this.auC.get(i).getUserId();
                    if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        biVar.bQj.setVisibility(8);
                        biVar.bQF.setVisibility(8);
                    } else if (this.auC.get(i).getIsFriend() == 1) {
                        biVar.bQj.setVisibility(0);
                        biVar.bQF.setVisibility(8);
                    } else {
                        biVar.bQj.setVisibility(8);
                        biVar.bQF.setVisibility(0);
                    }
                }
                biVar.mProgress = null;
            } else {
                biVar.aXK.setText(this.bQA.getPageContext().getString(com.baidu.tieba.y.loading));
                biVar.mProgress.setVisibility(0);
            }
            applyNightMode(view);
        }
        return view;
    }

    private void applyNightMode(View view) {
        this.bQA.getLayoutMode().X(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.bQA.getLayoutMode().h(view);
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
