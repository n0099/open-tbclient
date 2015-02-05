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
public class bj extends BaseAdapter {
    private View.OnClickListener aLM;
    private ArrayList<UserData> amM;
    private View.OnClickListener bIa;
    private PersonListActivity bIs;
    boolean bIt;
    private View.OnClickListener bIu;
    private View.OnClickListener bIv;
    boolean bzd;
    private int mSex;
    private boolean mHasMore = false;
    private boolean bHY = false;
    boolean byy = false;

    public void WC() {
        this.byy = false;
        if (this.amM != null && this.amM.size() == 0) {
            this.byy = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void ei(boolean z) {
        this.bHY = z;
    }

    public bj(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4) {
        this.amM = null;
        this.bIs = null;
        this.bIt = false;
        this.bzd = true;
        this.mSex = 0;
        this.bIa = null;
        this.aLM = null;
        this.bIu = null;
        this.bIv = null;
        this.bIs = personListActivity;
        this.bIt = z;
        this.bzd = z2;
        this.mSex = i;
        this.bIa = onClickListener2;
        this.aLM = onClickListener3;
        this.bIu = onClickListener;
        this.bIv = onClickListener4;
        this.amM = new ArrayList<>();
    }

    public void L(ArrayList<UserData> arrayList) {
        this.amM.addAll(arrayList);
    }

    public void resetData() {
        this.amM.clear();
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
        bk bkVar;
        View view2;
        if (this.amM != null) {
            if (view == null) {
                bk bkVar2 = new bk(this, null);
                if (getItemViewType(i) == 0) {
                    View inflate = com.baidu.adp.lib.g.b.ei().inflate(this.bIs.getPageContext().getPageActivity(), com.baidu.tieba.x.person_list_item, null);
                    bkVar2.bIw = (ViewGroup) inflate.findViewById(com.baidu.tieba.w.item_view);
                    bkVar2.bIw.setOnClickListener(this.bIu);
                    bkVar2.aCm = (HeadImageView) inflate.findViewById(com.baidu.tieba.w.photo);
                    bkVar2.aCm.setIsRound(false);
                    bkVar2.aCm.setAutoChangeStyle(true);
                    bkVar2.bIc = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.info);
                    bkVar2.aAn = (TextView) inflate.findViewById(com.baidu.tieba.w.name);
                    bkVar2.bId = (TextView) inflate.findViewById(com.baidu.tieba.w.at_list_nodata);
                    bkVar2.ayT = (TextView) inflate.findViewById(com.baidu.tieba.w.intro);
                    bkVar2.bIb = (ImageView) inflate.findViewById(com.baidu.tieba.w.chat);
                    bkVar2.bIx = (TextView) inflate.findViewById(com.baidu.tieba.w.add);
                    bkVar2.bIb.setOnClickListener(this.bIa);
                    bkVar2.bIx.setOnClickListener(this.bIv);
                    bkVar2.mProgress = null;
                    view2 = inflate;
                } else {
                    View inflate2 = com.baidu.adp.lib.g.b.ei().inflate(this.bIs.getPageContext().getPageActivity(), com.baidu.tieba.x.new_pb_list_more, null);
                    bkVar2.aAn = (TextView) inflate2.findViewById(com.baidu.tieba.w.pb_more_text);
                    inflate2.setOnClickListener(this.aLM);
                    bkVar2.mProgress = (ProgressBar) inflate2.findViewById(com.baidu.tieba.w.progress);
                    view2 = inflate2;
                }
                view2.setTag(bkVar2);
                bkVar = bkVar2;
                view = view2;
            } else {
                bkVar = (bk) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.byy) {
                    bkVar.bIc.setVisibility(8);
                    bkVar.bIb.setVisibility(8);
                    bkVar.bIx.setVisibility(8);
                    bkVar.bId.setVisibility(0);
                    if (this.bIt) {
                        if (this.bzd) {
                            bkVar.bId.setText(com.baidu.tieba.z.not_have_attention);
                        } else if (this.mSex == 2) {
                            bkVar.bId.setText(com.baidu.tieba.z.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            bkVar.bId.setText(com.baidu.tieba.z.him_no_attention_other);
                        } else {
                            bkVar.bId.setText(com.baidu.tieba.z.no_attention_other);
                        }
                    } else if (this.bzd) {
                        bkVar.bId.setText(com.baidu.tieba.z.not_have_fans);
                    } else if (this.mSex == 2) {
                        bkVar.bId.setText(com.baidu.tieba.z.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        bkVar.bId.setText(com.baidu.tieba.z.him_no_fan_other);
                    } else {
                        bkVar.bId.setText(com.baidu.tieba.z.no_fan_other);
                    }
                } else {
                    bkVar.bIw.setTag(Integer.valueOf(i));
                    bkVar.bIb.setVisibility(0);
                    bkVar.bIx.setVisibility(0);
                    bkVar.bIc.setVisibility(0);
                    bkVar.bId.setVisibility(8);
                    bkVar.aCm.d(this.amM.get(i).getPortrait(), 12, false);
                    bkVar.aAn.setText(this.amM.get(i).getName_show());
                    bkVar.ayT.setText(this.amM.get(i).getIntro());
                    bkVar.bIb.setTag(Integer.valueOf(i));
                    bkVar.bIx.setTag(Integer.valueOf(i));
                    String userId = this.amM.get(i).getUserId();
                    if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        bkVar.bIb.setVisibility(8);
                        bkVar.bIx.setVisibility(8);
                    } else if (this.amM.get(i).getIsFriend() == 1) {
                        bkVar.bIb.setVisibility(0);
                        bkVar.bIx.setVisibility(8);
                    } else {
                        bkVar.bIb.setVisibility(8);
                        bkVar.bIx.setVisibility(0);
                    }
                }
                bkVar.mProgress = null;
            } else {
                bkVar.aAn.setText(this.bIs.getPageContext().getString(com.baidu.tieba.z.loading));
                bkVar.mProgress.setVisibility(0);
            }
            applyNightMode(view);
        }
        return view;
    }

    private void applyNightMode(View view) {
        this.bIs.getLayoutMode().ab(TbadkCoreApplication.m255getInst().getSkinType() == 1);
        this.bIs.getLayoutMode().h(view);
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
