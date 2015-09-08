package com.baidu.tieba.person;

import android.text.TextUtils;
import android.view.LayoutInflater;
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
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class br extends BaseAdapter {
    private ArrayList<UserData> Xn;
    private View.OnClickListener biB;
    boolean bmy;
    private View.OnClickListener ckE;
    private PersonListActivity ckZ;
    boolean cla;
    private View.OnClickListener clb;
    private View.OnClickListener clc;
    private int mSex;
    private boolean mHasMore = false;
    private boolean ckD = false;
    boolean bXM = false;

    public void acf() {
        this.bXM = false;
        if (this.Xn != null && this.Xn.size() == 0) {
            this.bXM = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void eQ(boolean z) {
        this.ckD = z;
    }

    public br(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4) {
        this.Xn = null;
        this.ckZ = null;
        this.cla = false;
        this.bmy = true;
        this.mSex = 0;
        this.ckE = null;
        this.biB = null;
        this.clb = null;
        this.clc = null;
        this.ckZ = personListActivity;
        this.cla = z;
        this.bmy = z2;
        this.mSex = i;
        this.ckE = onClickListener2;
        this.biB = onClickListener3;
        this.clb = onClickListener;
        this.clc = onClickListener4;
        this.Xn = new ArrayList<>();
    }

    public void S(ArrayList<UserData> arrayList) {
        this.Xn.addAll(arrayList);
    }

    public void resetData() {
        this.Xn.clear();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bXM) {
            return 1;
        }
        int i = 0;
        if (this.Xn != null) {
            i = this.Xn.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.Xn == null || i >= this.Xn.size()) {
            return null;
        }
        return this.Xn.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.Xn == null || i >= this.Xn.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.Xn != null) {
            if (view == null) {
                a aVar2 = new a(this, null);
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.ckZ.getPageContext().getPageActivity()).inflate(i.g.person_list_item, (ViewGroup) null);
                    aVar2.cld = (ViewGroup) inflate.findViewById(i.f.item_view);
                    aVar2.cld.setOnClickListener(this.clb);
                    aVar2.aUc = (HeadImageView) inflate.findViewById(i.f.photo);
                    aVar2.aUc.setIsRound(false);
                    aVar2.aUc.setAutoChangeStyle(true);
                    aVar2.ckG = (LinearLayout) inflate.findViewById(i.f.info);
                    aVar2.bpb = (TextView) inflate.findViewById(i.f.name);
                    aVar2.ckH = (TextView) inflate.findViewById(i.f.at_list_nodata);
                    aVar2.aRm = (TextView) inflate.findViewById(i.f.intro);
                    aVar2.ckF = (ImageView) inflate.findViewById(i.f.chat);
                    aVar2.cle = (TextView) inflate.findViewById(i.f.add);
                    aVar2.ckF.setOnClickListener(this.ckE);
                    aVar2.cle.setOnClickListener(this.clc);
                    aVar2.mProgress = null;
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.ckZ.getPageContext().getPageActivity()).inflate(i.g.new_pb_list_more, (ViewGroup) null);
                    aVar2.bpb = (TextView) inflate2.findViewById(i.f.pb_more_text);
                    inflate2.setOnClickListener(this.biB);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(i.f.progress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.bXM) {
                    aVar.ckG.setVisibility(8);
                    aVar.ckF.setVisibility(8);
                    aVar.cle.setVisibility(8);
                    aVar.ckH.setVisibility(0);
                    if (this.cla) {
                        if (this.bmy) {
                            aVar.ckH.setText(i.h.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.ckH.setText(i.h.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.ckH.setText(i.h.him_no_attention_other);
                        } else {
                            aVar.ckH.setText(i.h.no_attention_other);
                        }
                    } else if (this.bmy) {
                        aVar.ckH.setText(i.h.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.ckH.setText(i.h.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.ckH.setText(i.h.him_no_fan_other);
                    } else {
                        aVar.ckH.setText(i.h.no_fan_other);
                    }
                } else {
                    aVar.cld.setTag(Integer.valueOf(i));
                    aVar.ckF.setVisibility(0);
                    aVar.cle.setVisibility(0);
                    aVar.ckG.setVisibility(0);
                    aVar.ckH.setVisibility(8);
                    aVar.aUc.d(this.Xn.get(i).getPortrait(), 12, false);
                    aVar.bpb.setText(this.Xn.get(i).getName_show());
                    aVar.aRm.setText(this.Xn.get(i).getIntro());
                    aVar.ckF.setTag(Integer.valueOf(i));
                    aVar.cle.setTag(Integer.valueOf(i));
                    String userId = this.Xn.get(i).getUserId();
                    if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        aVar.ckF.setVisibility(8);
                        aVar.cle.setVisibility(8);
                    } else if (this.Xn.get(i).getIsFriend() == 1) {
                        aVar.ckF.setVisibility(0);
                        aVar.cle.setVisibility(8);
                    } else {
                        aVar.ckF.setVisibility(8);
                        aVar.cle.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else {
                aVar.bpb.setText(this.ckZ.getPageContext().getString(i.h.loading));
                aVar.mProgress.setVisibility(0);
            }
            applyNightMode(view);
        }
        return view;
    }

    private void applyNightMode(View view) {
        this.ckZ.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.ckZ.getLayoutMode().k(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.bXM) {
            return 0;
        }
        return (this.Xn == null || i >= this.Xn.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.bXM) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView aRm;
        HeadImageView aUc;
        TextView bpb;
        ImageView ckF;
        LinearLayout ckG;
        TextView ckH;
        ViewGroup cld;
        TextView cle;
        ProgressBar mProgress;

        private a() {
        }

        /* synthetic */ a(br brVar, a aVar) {
            this();
        }
    }
}
