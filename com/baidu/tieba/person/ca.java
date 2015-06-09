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
    private View.OnClickListener aUg;
    boolean aYg;
    private View.OnClickListener bTe;
    private PersonListActivity bTw;
    boolean bTx;
    private View.OnClickListener bTy;
    private View.OnClickListener bTz;
    private int mSex;
    private boolean mHasMore = false;
    private boolean bTc = false;
    boolean bHd = false;

    public void ZH() {
        this.bHd = false;
        if (this.Sk != null && this.Sk.size() == 0) {
            this.bHd = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void ep(boolean z) {
        this.bTc = z;
    }

    public ca(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4) {
        this.Sk = null;
        this.bTw = null;
        this.bTx = false;
        this.aYg = true;
        this.mSex = 0;
        this.bTe = null;
        this.aUg = null;
        this.bTy = null;
        this.bTz = null;
        this.bTw = personListActivity;
        this.bTx = z;
        this.aYg = z2;
        this.mSex = i;
        this.bTe = onClickListener2;
        this.aUg = onClickListener3;
        this.bTy = onClickListener;
        this.bTz = onClickListener4;
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
        if (this.bHd) {
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
                    View inflate = com.baidu.adp.lib.g.b.hr().inflate(this.bTw.getPageContext().getPageActivity(), com.baidu.tieba.r.person_list_item, null);
                    cbVar2.bTA = (ViewGroup) inflate.findViewById(com.baidu.tieba.q.item_view);
                    cbVar2.bTA.setOnClickListener(this.bTy);
                    cbVar2.aKz = (HeadImageView) inflate.findViewById(com.baidu.tieba.q.photo);
                    cbVar2.aKz.setIsRound(false);
                    cbVar2.aKz.setAutoChangeStyle(true);
                    cbVar2.bTg = (LinearLayout) inflate.findViewById(com.baidu.tieba.q.info);
                    cbVar2.baI = (TextView) inflate.findViewById(com.baidu.tieba.q.name);
                    cbVar2.bTh = (TextView) inflate.findViewById(com.baidu.tieba.q.at_list_nodata);
                    cbVar2.aJx = (TextView) inflate.findViewById(com.baidu.tieba.q.intro);
                    cbVar2.bTf = (ImageView) inflate.findViewById(com.baidu.tieba.q.chat);
                    cbVar2.bTB = (TextView) inflate.findViewById(com.baidu.tieba.q.add);
                    cbVar2.bTf.setOnClickListener(this.bTe);
                    cbVar2.bTB.setOnClickListener(this.bTz);
                    cbVar2.mProgress = null;
                    view2 = inflate;
                } else {
                    View inflate2 = com.baidu.adp.lib.g.b.hr().inflate(this.bTw.getPageContext().getPageActivity(), com.baidu.tieba.r.new_pb_list_more, null);
                    cbVar2.baI = (TextView) inflate2.findViewById(com.baidu.tieba.q.pb_more_text);
                    inflate2.setOnClickListener(this.aUg);
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
                if (this.bHd) {
                    cbVar.bTg.setVisibility(8);
                    cbVar.bTf.setVisibility(8);
                    cbVar.bTB.setVisibility(8);
                    cbVar.bTh.setVisibility(0);
                    if (this.bTx) {
                        if (this.aYg) {
                            cbVar.bTh.setText(com.baidu.tieba.t.not_have_attention);
                        } else if (this.mSex == 2) {
                            cbVar.bTh.setText(com.baidu.tieba.t.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            cbVar.bTh.setText(com.baidu.tieba.t.him_no_attention_other);
                        } else {
                            cbVar.bTh.setText(com.baidu.tieba.t.no_attention_other);
                        }
                    } else if (this.aYg) {
                        cbVar.bTh.setText(com.baidu.tieba.t.not_have_fans);
                    } else if (this.mSex == 2) {
                        cbVar.bTh.setText(com.baidu.tieba.t.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        cbVar.bTh.setText(com.baidu.tieba.t.him_no_fan_other);
                    } else {
                        cbVar.bTh.setText(com.baidu.tieba.t.no_fan_other);
                    }
                } else {
                    cbVar.bTA.setTag(Integer.valueOf(i));
                    cbVar.bTf.setVisibility(0);
                    cbVar.bTB.setVisibility(0);
                    cbVar.bTg.setVisibility(0);
                    cbVar.bTh.setVisibility(8);
                    cbVar.aKz.c(this.Sk.get(i).getPortrait(), 12, false);
                    cbVar.baI.setText(this.Sk.get(i).getName_show());
                    cbVar.aJx.setText(this.Sk.get(i).getIntro());
                    cbVar.bTf.setTag(Integer.valueOf(i));
                    cbVar.bTB.setTag(Integer.valueOf(i));
                    String userId = this.Sk.get(i).getUserId();
                    if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        cbVar.bTf.setVisibility(8);
                        cbVar.bTB.setVisibility(8);
                    } else if (this.Sk.get(i).getIsFriend() == 1) {
                        cbVar.bTf.setVisibility(0);
                        cbVar.bTB.setVisibility(8);
                    } else {
                        cbVar.bTf.setVisibility(8);
                        cbVar.bTB.setVisibility(0);
                    }
                }
                cbVar.mProgress = null;
            } else {
                cbVar.baI.setText(this.bTw.getPageContext().getString(com.baidu.tieba.t.loading));
                cbVar.mProgress.setVisibility(0);
            }
            applyNightMode(view);
        }
        return view;
    }

    private void applyNightMode(View view) {
        this.bTw.getLayoutMode().ab(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.bTw.getLayoutMode().j(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.bHd) {
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
        if (this.bHd) {
            return false;
        }
        return super.isEnabled(i);
    }
}
