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
public class br extends BaseAdapter {
    private View.OnClickListener aJJ;
    private ArrayList<UserData> aew;
    private View.OnClickListener bCC;
    private PersonListActivity bCU;
    boolean bCV;
    private View.OnClickListener bCW;
    private View.OnClickListener bCX;
    boolean boM;
    private int mSex;
    private boolean mHasMore = false;
    private boolean bCB = false;
    boolean bBc = false;
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
                        BdLog.e(String.valueOf(getClass().getName()) + "releaseProgressBar" + e.getMessage());
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

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void eu(boolean z) {
        this.bCB = z;
    }

    public br(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4) {
        this.aew = null;
        this.bCU = null;
        this.bCV = false;
        this.boM = true;
        this.mSex = 0;
        this.bCC = null;
        this.aJJ = null;
        this.bCW = null;
        this.bCX = null;
        this.bCU = personListActivity;
        this.bCV = z;
        this.boM = z2;
        this.mSex = i;
        this.bCC = onClickListener2;
        this.aJJ = onClickListener3;
        this.bCW = onClickListener;
        this.bCX = onClickListener4;
        this.aew = new ArrayList<>();
    }

    public void G(ArrayList<UserData> arrayList) {
        this.aew.addAll(arrayList);
    }

    public void resetData() {
        this.aew.clear();
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
        bs bsVar;
        View view2;
        if (this.aew != null) {
            if (view == null) {
                bs bsVar2 = new bs(this, null);
                if (getItemViewType(i) == 0) {
                    View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.bCU, com.baidu.tieba.w.person_list_item, null);
                    bsVar2.bCY = (ViewGroup) inflate.findViewById(com.baidu.tieba.v.item_view);
                    bsVar2.bCY.setOnClickListener(this.bCW);
                    bsVar2.azk = (HeadImageView) inflate.findViewById(com.baidu.tieba.v.photo);
                    bsVar2.azk.setIsRound(false);
                    bsVar2.azk.setAutoChangeStyle(true);
                    bsVar2.bCE = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.info);
                    bsVar2.avZ = (TextView) inflate.findViewById(com.baidu.tieba.v.name);
                    bsVar2.bCF = (TextView) inflate.findViewById(com.baidu.tieba.v.at_list_nodata);
                    bsVar2.auD = (TextView) inflate.findViewById(com.baidu.tieba.v.intro);
                    bsVar2.bCD = (ImageView) inflate.findViewById(com.baidu.tieba.v.chat);
                    bsVar2.bCZ = (TextView) inflate.findViewById(com.baidu.tieba.v.add);
                    bsVar2.bCD.setOnClickListener(this.bCC);
                    bsVar2.bCZ.setOnClickListener(this.bCX);
                    view2 = inflate;
                } else {
                    View inflate2 = com.baidu.adp.lib.g.b.ek().inflate(this.bCU, com.baidu.tieba.w.new_pb_list_more, null);
                    bsVar2.avZ = (TextView) inflate2.findViewById(com.baidu.tieba.v.pb_more_text);
                    inflate2.setOnClickListener(this.aJJ);
                    bsVar2.mProgress = (ProgressBar) inflate2.findViewById(com.baidu.tieba.v.progress);
                    this.btZ.add(bsVar2.mProgress);
                    view2 = inflate2;
                }
                view2.setTag(bsVar2);
                bsVar = bsVar2;
                view = view2;
            } else {
                bsVar = (bs) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.bBc) {
                    bsVar.bCE.setVisibility(8);
                    bsVar.bCD.setVisibility(8);
                    bsVar.bCZ.setVisibility(8);
                    bsVar.bCF.setVisibility(0);
                    if (this.bCV) {
                        if (this.boM) {
                            bsVar.bCF.setText(com.baidu.tieba.y.not_have_attention);
                        } else if (this.mSex == 2) {
                            bsVar.bCF.setText(com.baidu.tieba.y.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            bsVar.bCF.setText(com.baidu.tieba.y.him_no_attention_other);
                        } else {
                            bsVar.bCF.setText(com.baidu.tieba.y.no_attention_other);
                        }
                    } else if (this.boM) {
                        bsVar.bCF.setText(com.baidu.tieba.y.not_have_fans);
                    } else if (this.mSex == 2) {
                        bsVar.bCF.setText(com.baidu.tieba.y.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        bsVar.bCF.setText(com.baidu.tieba.y.him_no_fan_other);
                    } else {
                        bsVar.bCF.setText(com.baidu.tieba.y.no_fan_other);
                    }
                } else {
                    bsVar.bCY.setTag(Integer.valueOf(i));
                    bsVar.bCD.setVisibility(0);
                    bsVar.bCZ.setVisibility(0);
                    bsVar.bCE.setVisibility(0);
                    bsVar.bCF.setVisibility(8);
                    bsVar.azk.c(this.aew.get(i).getPortrait(), 12, false);
                    bsVar.avZ.setText(this.aew.get(i).getName_show());
                    bsVar.auD.setText(this.aew.get(i).getIntro());
                    bsVar.bCD.setTag(Integer.valueOf(i));
                    bsVar.bCZ.setTag(Integer.valueOf(i));
                    String userId = this.aew.get(i).getUserId();
                    if (!TextUtils.isEmpty(userId) && userId.equals(TbadkApplication.getCurrentAccount())) {
                        bsVar.bCD.setVisibility(8);
                        bsVar.bCZ.setVisibility(8);
                    } else if (this.aew.get(i).getIsFriend() == 1) {
                        bsVar.bCD.setVisibility(0);
                        bsVar.bCZ.setVisibility(8);
                    } else {
                        bsVar.bCD.setVisibility(8);
                        bsVar.bCZ.setVisibility(0);
                    }
                }
            } else {
                bsVar.avZ.setText(this.bCU.getString(com.baidu.tieba.y.loading));
                bsVar.mProgress.setVisibility(0);
            }
            F(view);
        }
        return view;
    }

    private void F(View view) {
        this.bCU.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
        this.bCU.getLayoutMode().h(view);
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
