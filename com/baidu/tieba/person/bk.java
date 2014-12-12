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
public class bk extends BaseAdapter {
    private View.OnClickListener aKG;
    private PersonListActivity bGH;
    boolean bGI;
    private View.OnClickListener bGJ;
    private View.OnClickListener bGK;
    private View.OnClickListener bGq;
    boolean bxv;
    private ArrayList<UserData> mData;
    private int mSex;
    private boolean mHasMore = false;
    private boolean bGo = false;
    boolean bwQ = false;

    public void Wc() {
        this.bwQ = false;
        if (this.mData != null && this.mData.size() == 0) {
            this.bwQ = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void ec(boolean z) {
        this.bGo = z;
    }

    public bk(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4) {
        this.mData = null;
        this.bGH = null;
        this.bGI = false;
        this.bxv = true;
        this.mSex = 0;
        this.bGq = null;
        this.aKG = null;
        this.bGJ = null;
        this.bGK = null;
        this.bGH = personListActivity;
        this.bGI = z;
        this.bxv = z2;
        this.mSex = i;
        this.bGq = onClickListener2;
        this.aKG = onClickListener3;
        this.bGJ = onClickListener;
        this.bGK = onClickListener4;
        this.mData = new ArrayList<>();
    }

    public void K(ArrayList<UserData> arrayList) {
        this.mData.addAll(arrayList);
    }

    public void resetData() {
        this.mData.clear();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bwQ) {
            return 1;
        }
        int i = 0;
        if (this.mData != null) {
            i = this.mData.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mData == null || i >= this.mData.size()) {
            return null;
        }
        return this.mData.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.mData == null || i >= this.mData.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        bl blVar;
        View view2;
        if (this.mData != null) {
            if (view == null) {
                bl blVar2 = new bl(this, null);
                if (getItemViewType(i) == 0) {
                    View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.bGH.getPageContext().getPageActivity(), com.baidu.tieba.x.person_list_item, null);
                    blVar2.bGL = (ViewGroup) inflate.findViewById(com.baidu.tieba.w.item_view);
                    blVar2.bGL.setOnClickListener(this.bGJ);
                    blVar2.aBo = (HeadImageView) inflate.findViewById(com.baidu.tieba.w.photo);
                    blVar2.aBo.setIsRound(false);
                    blVar2.aBo.setAutoChangeStyle(true);
                    blVar2.mInfo = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.info);
                    blVar2.azp = (TextView) inflate.findViewById(com.baidu.tieba.w.name);
                    blVar2.bGs = (TextView) inflate.findViewById(com.baidu.tieba.w.at_list_nodata);
                    blVar2.axW = (TextView) inflate.findViewById(com.baidu.tieba.w.intro);
                    blVar2.bGr = (ImageView) inflate.findViewById(com.baidu.tieba.w.chat);
                    blVar2.bGM = (TextView) inflate.findViewById(com.baidu.tieba.w.add);
                    blVar2.bGr.setOnClickListener(this.bGq);
                    blVar2.bGM.setOnClickListener(this.bGK);
                    blVar2.mProgress = null;
                    view2 = inflate;
                } else {
                    View inflate2 = com.baidu.adp.lib.g.b.ek().inflate(this.bGH.getPageContext().getPageActivity(), com.baidu.tieba.x.new_pb_list_more, null);
                    blVar2.azp = (TextView) inflate2.findViewById(com.baidu.tieba.w.pb_more_text);
                    inflate2.setOnClickListener(this.aKG);
                    blVar2.mProgress = (ProgressBar) inflate2.findViewById(com.baidu.tieba.w.progress);
                    view2 = inflate2;
                }
                view2.setTag(blVar2);
                blVar = blVar2;
                view = view2;
            } else {
                blVar = (bl) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.bwQ) {
                    blVar.mInfo.setVisibility(8);
                    blVar.bGr.setVisibility(8);
                    blVar.bGM.setVisibility(8);
                    blVar.bGs.setVisibility(0);
                    if (this.bGI) {
                        if (this.bxv) {
                            blVar.bGs.setText(com.baidu.tieba.z.not_have_attention);
                        } else if (this.mSex == 2) {
                            blVar.bGs.setText(com.baidu.tieba.z.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            blVar.bGs.setText(com.baidu.tieba.z.him_no_attention_other);
                        } else {
                            blVar.bGs.setText(com.baidu.tieba.z.no_attention_other);
                        }
                    } else if (this.bxv) {
                        blVar.bGs.setText(com.baidu.tieba.z.not_have_fans);
                    } else if (this.mSex == 2) {
                        blVar.bGs.setText(com.baidu.tieba.z.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        blVar.bGs.setText(com.baidu.tieba.z.him_no_fan_other);
                    } else {
                        blVar.bGs.setText(com.baidu.tieba.z.no_fan_other);
                    }
                } else {
                    blVar.bGL.setTag(Integer.valueOf(i));
                    blVar.bGr.setVisibility(0);
                    blVar.bGM.setVisibility(0);
                    blVar.mInfo.setVisibility(0);
                    blVar.bGs.setVisibility(8);
                    blVar.aBo.d(this.mData.get(i).getPortrait(), 12, false);
                    blVar.azp.setText(this.mData.get(i).getName_show());
                    blVar.axW.setText(this.mData.get(i).getIntro());
                    blVar.bGr.setTag(Integer.valueOf(i));
                    blVar.bGM.setTag(Integer.valueOf(i));
                    String userId = this.mData.get(i).getUserId();
                    if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        blVar.bGr.setVisibility(8);
                        blVar.bGM.setVisibility(8);
                    } else if (this.mData.get(i).getIsFriend() == 1) {
                        blVar.bGr.setVisibility(0);
                        blVar.bGM.setVisibility(8);
                    } else {
                        blVar.bGr.setVisibility(8);
                        blVar.bGM.setVisibility(0);
                    }
                }
                blVar.mProgress = null;
            } else {
                blVar.azp.setText(this.bGH.getPageContext().getString(com.baidu.tieba.z.loading));
                blVar.mProgress.setVisibility(0);
            }
            applyNightMode(view);
        }
        return view;
    }

    private void applyNightMode(View view) {
        this.bGH.getLayoutMode().ab(TbadkCoreApplication.m255getInst().getSkinType() == 1);
        this.bGH.getLayoutMode().h(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.bwQ) {
            return 0;
        }
        return (this.mData == null || i >= this.mData.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.bwQ) {
            return false;
        }
        return super.isEnabled(i);
    }
}
