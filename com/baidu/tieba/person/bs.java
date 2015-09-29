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
public class bs extends BaseAdapter {
    private ArrayList<UserData> Xf;
    private View.OnClickListener biP;
    boolean bmZ;
    private PersonListActivity cqD;
    boolean cqE;
    private View.OnClickListener cqF;
    private View.OnClickListener cqG;
    private View.OnClickListener cqi;
    private int mSex;
    private boolean mHasMore = false;
    private boolean cqh = false;
    boolean cby = false;

    public void adx() {
        this.cby = false;
        if (this.Xf != null && this.Xf.size() == 0) {
            this.cby = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void eW(boolean z) {
        this.cqh = z;
    }

    public bs(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4) {
        this.Xf = null;
        this.cqD = null;
        this.cqE = false;
        this.bmZ = true;
        this.mSex = 0;
        this.cqi = null;
        this.biP = null;
        this.cqF = null;
        this.cqG = null;
        this.cqD = personListActivity;
        this.cqE = z;
        this.bmZ = z2;
        this.mSex = i;
        this.cqi = onClickListener2;
        this.biP = onClickListener3;
        this.cqF = onClickListener;
        this.cqG = onClickListener4;
        this.Xf = new ArrayList<>();
    }

    public void T(ArrayList<UserData> arrayList) {
        this.Xf.addAll(arrayList);
    }

    public void resetData() {
        this.Xf.clear();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cby) {
            return 1;
        }
        int i = 0;
        if (this.Xf != null) {
            i = this.Xf.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.Xf == null || i >= this.Xf.size()) {
            return null;
        }
        return this.Xf.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.Xf == null || i >= this.Xf.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.Xf != null) {
            if (view == null) {
                a aVar2 = new a(this, null);
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.cqD.getPageContext().getPageActivity()).inflate(i.g.person_list_item, (ViewGroup) null);
                    aVar2.cqH = (ViewGroup) inflate.findViewById(i.f.item_view);
                    aVar2.cqH.setOnClickListener(this.cqF);
                    aVar2.aSY = (HeadImageView) inflate.findViewById(i.f.photo);
                    aVar2.aSY.setIsRound(false);
                    aVar2.aSY.setAutoChangeStyle(true);
                    aVar2.cqk = (LinearLayout) inflate.findViewById(i.f.info);
                    aVar2.bsb = (TextView) inflate.findViewById(i.f.name);
                    aVar2.cql = (TextView) inflate.findViewById(i.f.at_list_nodata);
                    aVar2.aQi = (TextView) inflate.findViewById(i.f.intro);
                    aVar2.cqj = (ImageView) inflate.findViewById(i.f.chat);
                    aVar2.cqI = (TextView) inflate.findViewById(i.f.add);
                    aVar2.cqj.setOnClickListener(this.cqi);
                    aVar2.cqI.setOnClickListener(this.cqG);
                    aVar2.mProgress = null;
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.cqD.getPageContext().getPageActivity()).inflate(i.g.new_pb_list_more, (ViewGroup) null);
                    aVar2.bsb = (TextView) inflate2.findViewById(i.f.pb_more_text);
                    inflate2.setOnClickListener(this.biP);
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
                if (this.cby) {
                    aVar.cqk.setVisibility(8);
                    aVar.cqj.setVisibility(8);
                    aVar.cqI.setVisibility(8);
                    aVar.cql.setVisibility(0);
                    if (this.cqE) {
                        if (this.bmZ) {
                            aVar.cql.setText(i.h.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.cql.setText(i.h.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.cql.setText(i.h.him_no_attention_other);
                        } else {
                            aVar.cql.setText(i.h.no_attention_other);
                        }
                    } else if (this.bmZ) {
                        aVar.cql.setText(i.h.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.cql.setText(i.h.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.cql.setText(i.h.him_no_fan_other);
                    } else {
                        aVar.cql.setText(i.h.no_fan_other);
                    }
                } else {
                    aVar.cqH.setTag(Integer.valueOf(i));
                    aVar.cqj.setVisibility(0);
                    aVar.cqI.setVisibility(0);
                    aVar.cqk.setVisibility(0);
                    aVar.cql.setVisibility(8);
                    aVar.aSY.d(this.Xf.get(i).getPortrait(), 12, false);
                    aVar.bsb.setText(this.Xf.get(i).getName_show());
                    aVar.aQi.setText(this.Xf.get(i).getIntro());
                    aVar.cqj.setTag(Integer.valueOf(i));
                    aVar.cqI.setTag(Integer.valueOf(i));
                    String userId = this.Xf.get(i).getUserId();
                    if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        aVar.cqj.setVisibility(8);
                        aVar.cqI.setVisibility(8);
                    } else if (this.Xf.get(i).getIsFriend() == 1) {
                        aVar.cqj.setVisibility(0);
                        aVar.cqI.setVisibility(8);
                    } else {
                        aVar.cqj.setVisibility(8);
                        aVar.cqI.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else {
                aVar.bsb.setText(this.cqD.getPageContext().getString(i.h.loading));
                aVar.mProgress.setVisibility(0);
            }
            applyNightMode(view);
        }
        return view;
    }

    private void applyNightMode(View view) {
        this.cqD.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.cqD.getLayoutMode().k(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.cby) {
            return 0;
        }
        return (this.Xf == null || i >= this.Xf.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.cby) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView aQi;
        HeadImageView aSY;
        TextView bsb;
        ViewGroup cqH;
        TextView cqI;
        ImageView cqj;
        LinearLayout cqk;
        TextView cql;
        ProgressBar mProgress;

        private a() {
        }

        /* synthetic */ a(bs bsVar, a aVar) {
            this();
        }
    }
}
