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
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bt extends BaseAdapter {
    private ArrayList<UserData> YA;
    boolean bAA;
    private View.OnClickListener buY;
    private PersonListActivity cPU;
    boolean cPV;
    private View.OnClickListener cPW;
    private View.OnClickListener cPX;
    private View.OnClickListener cPz;
    private int mSex;
    private boolean mHasMore = false;
    private boolean cPy = false;
    boolean cyl = false;

    public void ajp() {
        this.cyl = false;
        if (this.YA != null && this.YA.size() == 0) {
            this.cyl = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void fD(boolean z) {
        this.cPy = z;
    }

    public bt(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4) {
        this.YA = null;
        this.cPU = null;
        this.cPV = false;
        this.bAA = true;
        this.mSex = 0;
        this.cPz = null;
        this.buY = null;
        this.cPW = null;
        this.cPX = null;
        this.cPU = personListActivity;
        this.cPV = z;
        this.bAA = z2;
        this.mSex = i;
        this.cPz = onClickListener2;
        this.buY = onClickListener3;
        this.cPW = onClickListener;
        this.cPX = onClickListener4;
        this.YA = new ArrayList<>();
    }

    public void Y(ArrayList<UserData> arrayList) {
        this.YA.addAll(arrayList);
    }

    public void resetData() {
        this.YA.clear();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cyl) {
            return 1;
        }
        int i = 0;
        if (this.YA != null) {
            i = this.YA.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.YA == null || i >= this.YA.size()) {
            return null;
        }
        return this.YA.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.YA == null || i >= this.YA.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.YA != null) {
            if (view == null) {
                a aVar2 = new a(this, null);
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.cPU.getPageContext().getPageActivity()).inflate(n.h.person_list_item, (ViewGroup) null);
                    aVar2.cPY = (ViewGroup) inflate.findViewById(n.g.item_view);
                    aVar2.cPY.setOnClickListener(this.cPW);
                    aVar2.bcC = (HeadImageView) inflate.findViewById(n.g.photo);
                    aVar2.bcC.setIsRound(false);
                    aVar2.bcC.setAutoChangeStyle(true);
                    aVar2.cPB = (LinearLayout) inflate.findViewById(n.g.info);
                    aVar2.bLD = (TextView) inflate.findViewById(n.g.name);
                    aVar2.cPC = (TextView) inflate.findViewById(n.g.at_list_nodata);
                    aVar2.aZE = (TextView) inflate.findViewById(n.g.intro);
                    aVar2.cPA = (ImageView) inflate.findViewById(n.g.chat);
                    aVar2.cPZ = (TextView) inflate.findViewById(n.g.add);
                    aVar2.cPA.setOnClickListener(this.cPz);
                    aVar2.cPZ.setOnClickListener(this.cPX);
                    aVar2.mProgress = null;
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.cPU.getPageContext().getPageActivity()).inflate(n.h.new_pb_list_more, (ViewGroup) null);
                    aVar2.bLD = (TextView) inflate2.findViewById(n.g.pb_more_text);
                    inflate2.setOnClickListener(this.buY);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(n.g.progress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.cyl) {
                    aVar.cPB.setVisibility(8);
                    aVar.cPA.setVisibility(8);
                    aVar.cPZ.setVisibility(8);
                    aVar.cPC.setVisibility(0);
                    if (this.cPV) {
                        if (this.bAA) {
                            aVar.cPC.setText(n.j.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.cPC.setText(n.j.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.cPC.setText(n.j.him_no_attention_other);
                        } else {
                            aVar.cPC.setText(n.j.no_attention_other);
                        }
                    } else if (this.bAA) {
                        aVar.cPC.setText(n.j.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.cPC.setText(n.j.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.cPC.setText(n.j.him_no_fan_other);
                    } else {
                        aVar.cPC.setText(n.j.no_fan_other);
                    }
                } else {
                    aVar.cPY.setTag(Integer.valueOf(i));
                    aVar.cPA.setVisibility(0);
                    aVar.cPZ.setVisibility(0);
                    aVar.cPB.setVisibility(0);
                    aVar.cPC.setVisibility(8);
                    aVar.bcC.d(this.YA.get(i).getPortrait(), 12, false);
                    aVar.bLD.setText(this.YA.get(i).getName_show());
                    aVar.aZE.setText(this.YA.get(i).getIntro());
                    aVar.cPA.setTag(Integer.valueOf(i));
                    aVar.cPZ.setTag(Integer.valueOf(i));
                    String userId = this.YA.get(i).getUserId();
                    if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        aVar.cPA.setVisibility(8);
                        aVar.cPZ.setVisibility(8);
                    } else if (this.YA.get(i).getIsFriend() == 1) {
                        aVar.cPA.setVisibility(0);
                        aVar.cPZ.setVisibility(8);
                    } else {
                        aVar.cPA.setVisibility(8);
                        aVar.cPZ.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else {
                aVar.bLD.setText(this.cPU.getPageContext().getString(n.j.loading));
                aVar.mProgress.setVisibility(0);
            }
            applyNightMode(view);
        }
        return view;
    }

    private void applyNightMode(View view) {
        this.cPU.getLayoutMode().ac(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.cPU.getLayoutMode().k(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.cyl) {
            return 0;
        }
        return (this.YA == null || i >= this.YA.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.cyl) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView aZE;
        TextView bLD;
        HeadImageView bcC;
        ImageView cPA;
        LinearLayout cPB;
        TextView cPC;
        ViewGroup cPY;
        TextView cPZ;
        ProgressBar mProgress;

        private a() {
        }

        /* synthetic */ a(bt btVar, a aVar) {
            this();
        }
    }
}
