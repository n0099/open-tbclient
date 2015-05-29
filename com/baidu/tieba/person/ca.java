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
public class ca extends BaseAdapter {
    private ArrayList<UserData> Sk;
    private View.OnClickListener aUf;
    boolean aYf;
    private View.OnClickListener bTd;
    private PersonListActivity bTv;
    boolean bTw;
    private View.OnClickListener bTx;
    private View.OnClickListener bTy;
    private int mSex;
    private boolean mHasMore = false;
    private boolean bTb = false;
    boolean bHc = false;

    public void ZG() {
        this.bHc = false;
        if (this.Sk != null && this.Sk.size() == 0) {
            this.bHc = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void ep(boolean z) {
        this.bTb = z;
    }

    public ca(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4) {
        this.Sk = null;
        this.bTv = null;
        this.bTw = false;
        this.aYf = true;
        this.mSex = 0;
        this.bTd = null;
        this.aUf = null;
        this.bTx = null;
        this.bTy = null;
        this.bTv = personListActivity;
        this.bTw = z;
        this.aYf = z2;
        this.mSex = i;
        this.bTd = onClickListener2;
        this.aUf = onClickListener3;
        this.bTx = onClickListener;
        this.bTy = onClickListener4;
        this.Sk = new ArrayList<>();
    }

    public void M(ArrayList<UserData> arrayList) {
        this.Sk.addAll(arrayList);
    }

    public void resetData() {
        this.Sk.clear();
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
        cb cbVar;
        View view2;
        if (this.Sk != null) {
            if (view == null) {
                cb cbVar2 = new cb(this, null);
                if (getItemViewType(i) == 0) {
                    View inflate = com.baidu.adp.lib.g.b.hr().inflate(this.bTv.getPageContext().getPageActivity(), com.baidu.tieba.r.person_list_item, null);
                    cbVar2.bTz = (ViewGroup) inflate.findViewById(com.baidu.tieba.q.item_view);
                    cbVar2.bTz.setOnClickListener(this.bTx);
                    cbVar2.aKy = (HeadImageView) inflate.findViewById(com.baidu.tieba.q.photo);
                    cbVar2.aKy.setIsRound(false);
                    cbVar2.aKy.setAutoChangeStyle(true);
                    cbVar2.bTf = (LinearLayout) inflate.findViewById(com.baidu.tieba.q.info);
                    cbVar2.baH = (TextView) inflate.findViewById(com.baidu.tieba.q.name);
                    cbVar2.bTg = (TextView) inflate.findViewById(com.baidu.tieba.q.at_list_nodata);
                    cbVar2.aJw = (TextView) inflate.findViewById(com.baidu.tieba.q.intro);
                    cbVar2.bTe = (ImageView) inflate.findViewById(com.baidu.tieba.q.chat);
                    cbVar2.bTA = (TextView) inflate.findViewById(com.baidu.tieba.q.add);
                    cbVar2.bTe.setOnClickListener(this.bTd);
                    cbVar2.bTA.setOnClickListener(this.bTy);
                    cbVar2.mProgress = null;
                    view2 = inflate;
                } else {
                    View inflate2 = com.baidu.adp.lib.g.b.hr().inflate(this.bTv.getPageContext().getPageActivity(), com.baidu.tieba.r.new_pb_list_more, null);
                    cbVar2.baH = (TextView) inflate2.findViewById(com.baidu.tieba.q.pb_more_text);
                    inflate2.setOnClickListener(this.aUf);
                    cbVar2.mProgress = (ProgressBar) inflate2.findViewById(com.baidu.tieba.q.progress);
                    view2 = inflate2;
                }
                view2.setTag(cbVar2);
                cbVar = cbVar2;
                view = view2;
            } else {
                cbVar = (cb) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.bHc) {
                    cbVar.bTf.setVisibility(8);
                    cbVar.bTe.setVisibility(8);
                    cbVar.bTA.setVisibility(8);
                    cbVar.bTg.setVisibility(0);
                    if (this.bTw) {
                        if (this.aYf) {
                            cbVar.bTg.setText(com.baidu.tieba.t.not_have_attention);
                        } else if (this.mSex == 2) {
                            cbVar.bTg.setText(com.baidu.tieba.t.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            cbVar.bTg.setText(com.baidu.tieba.t.him_no_attention_other);
                        } else {
                            cbVar.bTg.setText(com.baidu.tieba.t.no_attention_other);
                        }
                    } else if (this.aYf) {
                        cbVar.bTg.setText(com.baidu.tieba.t.not_have_fans);
                    } else if (this.mSex == 2) {
                        cbVar.bTg.setText(com.baidu.tieba.t.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        cbVar.bTg.setText(com.baidu.tieba.t.him_no_fan_other);
                    } else {
                        cbVar.bTg.setText(com.baidu.tieba.t.no_fan_other);
                    }
                } else {
                    cbVar.bTz.setTag(Integer.valueOf(i));
                    cbVar.bTe.setVisibility(0);
                    cbVar.bTA.setVisibility(0);
                    cbVar.bTf.setVisibility(0);
                    cbVar.bTg.setVisibility(8);
                    cbVar.aKy.c(this.Sk.get(i).getPortrait(), 12, false);
                    cbVar.baH.setText(this.Sk.get(i).getName_show());
                    cbVar.aJw.setText(this.Sk.get(i).getIntro());
                    cbVar.bTe.setTag(Integer.valueOf(i));
                    cbVar.bTA.setTag(Integer.valueOf(i));
                    String userId = this.Sk.get(i).getUserId();
                    if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        cbVar.bTe.setVisibility(8);
                        cbVar.bTA.setVisibility(8);
                    } else if (this.Sk.get(i).getIsFriend() == 1) {
                        cbVar.bTe.setVisibility(0);
                        cbVar.bTA.setVisibility(8);
                    } else {
                        cbVar.bTe.setVisibility(8);
                        cbVar.bTA.setVisibility(0);
                    }
                }
                cbVar.mProgress = null;
            } else {
                cbVar.baH.setText(this.bTv.getPageContext().getString(com.baidu.tieba.t.loading));
                cbVar.mProgress.setVisibility(0);
            }
            applyNightMode(view);
        }
        return view;
    }

    private void applyNightMode(View view) {
        this.bTv.getLayoutMode().ab(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.bTv.getLayoutMode().j(view);
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
