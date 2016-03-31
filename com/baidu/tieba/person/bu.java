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
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bu extends BaseAdapter {
    private ArrayList<UserData> Xq;
    private View.OnClickListener bDC;
    boolean bJj;
    private PersonListActivity dtU;
    boolean dtV;
    private View.OnClickListener dtW;
    private View.OnClickListener dtX;
    private View.OnClickListener dtz;
    private int mSex;
    private boolean mHasMore = false;
    private boolean dtx = false;
    boolean cYk = false;

    public void aug() {
        this.cYk = false;
        if (this.Xq != null && this.Xq.size() == 0) {
            this.cYk = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void gF(boolean z) {
        this.dtx = z;
    }

    public bu(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4) {
        this.Xq = null;
        this.dtU = null;
        this.dtV = false;
        this.bJj = true;
        this.mSex = 0;
        this.dtz = null;
        this.bDC = null;
        this.dtW = null;
        this.dtX = null;
        this.dtU = personListActivity;
        this.dtV = z;
        this.bJj = z2;
        this.mSex = i;
        this.dtz = onClickListener2;
        this.bDC = onClickListener3;
        this.dtW = onClickListener;
        this.dtX = onClickListener4;
        this.Xq = new ArrayList<>();
    }

    public void aa(ArrayList<UserData> arrayList) {
        this.Xq.addAll(arrayList);
    }

    public void resetData() {
        this.Xq.clear();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cYk) {
            return 1;
        }
        int i = 0;
        if (this.Xq != null) {
            i = this.Xq.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.Xq == null || i >= this.Xq.size()) {
            return null;
        }
        return this.Xq.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.Xq == null || i >= this.Xq.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.Xq != null) {
            if (view == null) {
                a aVar2 = new a(this, null);
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.dtU.getPageContext().getPageActivity()).inflate(t.h.person_list_item, (ViewGroup) null);
                    aVar2.dtY = (ViewGroup) inflate.findViewById(t.g.item_view);
                    aVar2.dtY.setOnClickListener(this.dtW);
                    aVar2.bjG = (HeadImageView) inflate.findViewById(t.g.photo);
                    aVar2.bjG.setIsRound(false);
                    aVar2.bjG.setAutoChangeStyle(true);
                    aVar2.dtB = (LinearLayout) inflate.findViewById(t.g.info);
                    aVar2.bZJ = (TextView) inflate.findViewById(t.g.name);
                    aVar2.dtC = (TextView) inflate.findViewById(t.g.at_list_nodata);
                    aVar2.bgE = (TextView) inflate.findViewById(t.g.intro);
                    aVar2.dtA = (ImageView) inflate.findViewById(t.g.chat);
                    aVar2.dtZ = (TextView) inflate.findViewById(t.g.add);
                    aVar2.dtA.setOnClickListener(this.dtz);
                    aVar2.dtZ.setOnClickListener(this.dtX);
                    aVar2.aQj = null;
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.dtU.getPageContext().getPageActivity()).inflate(t.h.new_pb_list_more, (ViewGroup) null);
                    aVar2.bZJ = (TextView) inflate2.findViewById(t.g.pb_more_text);
                    inflate2.setOnClickListener(this.bDC);
                    aVar2.aQj = (ProgressBar) inflate2.findViewById(t.g.progress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.cYk) {
                    aVar.dtB.setVisibility(8);
                    aVar.dtA.setVisibility(8);
                    aVar.dtZ.setVisibility(8);
                    aVar.dtC.setVisibility(0);
                    if (this.dtV) {
                        if (this.bJj) {
                            aVar.dtC.setText(t.j.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.dtC.setText(t.j.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.dtC.setText(t.j.him_no_attention_other);
                        } else {
                            aVar.dtC.setText(t.j.no_attention_other);
                        }
                    } else if (this.bJj) {
                        aVar.dtC.setText(t.j.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.dtC.setText(t.j.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.dtC.setText(t.j.him_no_fan_other);
                    } else {
                        aVar.dtC.setText(t.j.no_fan_other);
                    }
                } else {
                    aVar.dtY.setTag(Integer.valueOf(i));
                    aVar.dtA.setVisibility(0);
                    aVar.dtZ.setVisibility(0);
                    aVar.dtB.setVisibility(0);
                    aVar.dtC.setVisibility(8);
                    aVar.bjG.c(this.Xq.get(i).getPortrait(), 12, false);
                    aVar.bZJ.setText(this.Xq.get(i).getName_show());
                    aVar.bgE.setText(this.Xq.get(i).getIntro());
                    aVar.dtA.setTag(Integer.valueOf(i));
                    aVar.dtZ.setTag(Integer.valueOf(i));
                    String userId = this.Xq.get(i).getUserId();
                    if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        aVar.dtA.setVisibility(8);
                        aVar.dtZ.setVisibility(8);
                    } else if (this.Xq.get(i).getIsFriend() == 1) {
                        aVar.dtA.setVisibility(0);
                        aVar.dtZ.setVisibility(8);
                    } else {
                        aVar.dtA.setVisibility(8);
                        aVar.dtZ.setVisibility(0);
                    }
                }
                aVar.aQj = null;
            } else {
                aVar.bZJ.setText(this.dtU.getPageContext().getString(t.j.loading));
                aVar.aQj.setVisibility(0);
            }
            u(view);
        }
        return view;
    }

    private void u(View view) {
        this.dtU.getLayoutMode().ab(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.dtU.getLayoutMode().x(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.cYk) {
            return 0;
        }
        return (this.Xq == null || i >= this.Xq.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.cYk) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes.dex */
    private class a {
        ProgressBar aQj;
        TextView bZJ;
        TextView bgE;
        HeadImageView bjG;
        ImageView dtA;
        LinearLayout dtB;
        TextView dtC;
        ViewGroup dtY;
        TextView dtZ;

        private a() {
        }

        /* synthetic */ a(bu buVar, a aVar) {
            this();
        }
    }
}
