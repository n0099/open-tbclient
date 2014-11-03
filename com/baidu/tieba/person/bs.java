package com.baidu.tieba.person;

import android.text.TextUtils;
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
public class bs extends BaseAdapter {
    private View.OnClickListener aJW;
    private ArrayList<UserData> aeE;
    private View.OnClickListener bCQ;
    private PersonListActivity bDi;
    boolean bDj;
    private View.OnClickListener bDk;
    private View.OnClickListener bDl;
    boolean bpa;
    private int mSex;
    private boolean mHasMore = false;
    private boolean bCP = false;
    boolean bBq = false;
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
                        BdLog.e(String.valueOf(getClass().getName()) + "releaseProgressBar" + e.getMessage());
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

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void eu(boolean z) {
        this.bCP = z;
    }

    public bs(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4) {
        this.aeE = null;
        this.bDi = null;
        this.bDj = false;
        this.bpa = true;
        this.mSex = 0;
        this.bCQ = null;
        this.aJW = null;
        this.bDk = null;
        this.bDl = null;
        this.bDi = personListActivity;
        this.bDj = z;
        this.bpa = z2;
        this.mSex = i;
        this.bCQ = onClickListener2;
        this.aJW = onClickListener3;
        this.bDk = onClickListener;
        this.bDl = onClickListener4;
        this.aeE = new ArrayList<>();
    }

    public void H(ArrayList<UserData> arrayList) {
        this.aeE.addAll(arrayList);
    }

    public void resetData() {
        this.aeE.clear();
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
        bt btVar;
        View view2;
        if (this.aeE != null) {
            if (view == null) {
                bt btVar2 = new bt(this, null);
                if (getItemViewType(i) == 0) {
                    View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.bDi, com.baidu.tieba.w.person_list_item, null);
                    btVar2.bDm = (ViewGroup) inflate.findViewById(com.baidu.tieba.v.item_view);
                    btVar2.bDm.setOnClickListener(this.bDk);
                    btVar2.azt = (HeadImageView) inflate.findViewById(com.baidu.tieba.v.photo);
                    btVar2.azt.setIsRound(false);
                    btVar2.azt.setAutoChangeStyle(true);
                    btVar2.bCS = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.info);
                    btVar2.awi = (TextView) inflate.findViewById(com.baidu.tieba.v.name);
                    btVar2.bCT = (TextView) inflate.findViewById(com.baidu.tieba.v.at_list_nodata);
                    btVar2.auM = (TextView) inflate.findViewById(com.baidu.tieba.v.intro);
                    btVar2.bCR = (ImageView) inflate.findViewById(com.baidu.tieba.v.chat);
                    btVar2.bDn = (TextView) inflate.findViewById(com.baidu.tieba.v.add);
                    btVar2.bCR.setOnClickListener(this.bCQ);
                    btVar2.bDn.setOnClickListener(this.bDl);
                    view2 = inflate;
                } else {
                    View inflate2 = com.baidu.adp.lib.g.b.ek().inflate(this.bDi, com.baidu.tieba.w.new_pb_list_more, null);
                    btVar2.awi = (TextView) inflate2.findViewById(com.baidu.tieba.v.pb_more_text);
                    inflate2.setOnClickListener(this.aJW);
                    btVar2.mProgress = (ProgressBar) inflate2.findViewById(com.baidu.tieba.v.progress);
                    this.bun.add(btVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(btVar2);
                btVar = btVar2;
                view = view2;
            } else {
                btVar = (bt) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.bBq) {
                    btVar.bCS.setVisibility(8);
                    btVar.bCR.setVisibility(8);
                    btVar.bDn.setVisibility(8);
                    btVar.bCT.setVisibility(0);
                    if (this.bDj) {
                        if (this.bpa) {
                            btVar.bCT.setText(com.baidu.tieba.y.not_have_attention);
                        } else if (this.mSex == 2) {
                            btVar.bCT.setText(com.baidu.tieba.y.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            btVar.bCT.setText(com.baidu.tieba.y.him_no_attention_other);
                        } else {
                            btVar.bCT.setText(com.baidu.tieba.y.no_attention_other);
                        }
                    } else if (this.bpa) {
                        btVar.bCT.setText(com.baidu.tieba.y.not_have_fans);
                    } else if (this.mSex == 2) {
                        btVar.bCT.setText(com.baidu.tieba.y.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        btVar.bCT.setText(com.baidu.tieba.y.him_no_fan_other);
                    } else {
                        btVar.bCT.setText(com.baidu.tieba.y.no_fan_other);
                    }
                } else {
                    btVar.bDm.setTag(Integer.valueOf(i));
                    btVar.bCR.setVisibility(0);
                    btVar.bDn.setVisibility(0);
                    btVar.bCS.setVisibility(0);
                    btVar.bCT.setVisibility(8);
                    btVar.azt.c(this.aeE.get(i).getPortrait(), 12, false);
                    btVar.awi.setText(this.aeE.get(i).getName_show());
                    btVar.auM.setText(this.aeE.get(i).getIntro());
                    btVar.bCR.setTag(Integer.valueOf(i));
                    btVar.bDn.setTag(Integer.valueOf(i));
                    String userId = this.aeE.get(i).getUserId();
                    if (!TextUtils.isEmpty(userId) && userId.equals(TbadkApplication.getCurrentAccount())) {
                        btVar.bCR.setVisibility(8);
                        btVar.bDn.setVisibility(8);
                    } else if (this.aeE.get(i).getIsFriend() == 1) {
                        btVar.bCR.setVisibility(0);
                        btVar.bDn.setVisibility(8);
                    } else {
                        btVar.bCR.setVisibility(8);
                        btVar.bDn.setVisibility(0);
                    }
                }
            } else {
                btVar.awi.setText(this.bDi.getString(com.baidu.tieba.y.loading));
                btVar.mProgress.setVisibility(0);
            }
            F(view);
        }
        return view;
    }

    private void F(View view) {
        this.bDi.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
        this.bDi.getLayoutMode().h(view);
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
