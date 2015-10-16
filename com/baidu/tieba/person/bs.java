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
    private ArrayList<UserData> Xh;
    private View.OnClickListener bja;
    boolean bnk;
    private PersonListActivity cqO;
    boolean cqP;
    private View.OnClickListener cqQ;
    private View.OnClickListener cqR;
    private View.OnClickListener cqt;
    private int mSex;
    private boolean mHasMore = false;
    private boolean cqs = false;
    boolean cbJ = false;

    public void adx() {
        this.cbJ = false;
        if (this.Xh != null && this.Xh.size() == 0) {
            this.cbJ = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void eW(boolean z) {
        this.cqs = z;
    }

    public bs(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4) {
        this.Xh = null;
        this.cqO = null;
        this.cqP = false;
        this.bnk = true;
        this.mSex = 0;
        this.cqt = null;
        this.bja = null;
        this.cqQ = null;
        this.cqR = null;
        this.cqO = personListActivity;
        this.cqP = z;
        this.bnk = z2;
        this.mSex = i;
        this.cqt = onClickListener2;
        this.bja = onClickListener3;
        this.cqQ = onClickListener;
        this.cqR = onClickListener4;
        this.Xh = new ArrayList<>();
    }

    public void T(ArrayList<UserData> arrayList) {
        this.Xh.addAll(arrayList);
    }

    public void resetData() {
        this.Xh.clear();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cbJ) {
            return 1;
        }
        int i = 0;
        if (this.Xh != null) {
            i = this.Xh.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.Xh == null || i >= this.Xh.size()) {
            return null;
        }
        return this.Xh.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.Xh == null || i >= this.Xh.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.Xh != null) {
            if (view == null) {
                a aVar2 = new a(this, null);
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.cqO.getPageContext().getPageActivity()).inflate(i.g.person_list_item, (ViewGroup) null);
                    aVar2.cqS = (ViewGroup) inflate.findViewById(i.f.item_view);
                    aVar2.cqS.setOnClickListener(this.cqQ);
                    aVar2.aTj = (HeadImageView) inflate.findViewById(i.f.photo);
                    aVar2.aTj.setIsRound(false);
                    aVar2.aTj.setAutoChangeStyle(true);
                    aVar2.cqv = (LinearLayout) inflate.findViewById(i.f.info);
                    aVar2.bsm = (TextView) inflate.findViewById(i.f.name);
                    aVar2.cqw = (TextView) inflate.findViewById(i.f.at_list_nodata);
                    aVar2.aQt = (TextView) inflate.findViewById(i.f.intro);
                    aVar2.cqu = (ImageView) inflate.findViewById(i.f.chat);
                    aVar2.cqT = (TextView) inflate.findViewById(i.f.add);
                    aVar2.cqu.setOnClickListener(this.cqt);
                    aVar2.cqT.setOnClickListener(this.cqR);
                    aVar2.mProgress = null;
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.cqO.getPageContext().getPageActivity()).inflate(i.g.new_pb_list_more, (ViewGroup) null);
                    aVar2.bsm = (TextView) inflate2.findViewById(i.f.pb_more_text);
                    inflate2.setOnClickListener(this.bja);
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
                if (this.cbJ) {
                    aVar.cqv.setVisibility(8);
                    aVar.cqu.setVisibility(8);
                    aVar.cqT.setVisibility(8);
                    aVar.cqw.setVisibility(0);
                    if (this.cqP) {
                        if (this.bnk) {
                            aVar.cqw.setText(i.h.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.cqw.setText(i.h.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.cqw.setText(i.h.him_no_attention_other);
                        } else {
                            aVar.cqw.setText(i.h.no_attention_other);
                        }
                    } else if (this.bnk) {
                        aVar.cqw.setText(i.h.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.cqw.setText(i.h.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.cqw.setText(i.h.him_no_fan_other);
                    } else {
                        aVar.cqw.setText(i.h.no_fan_other);
                    }
                } else {
                    aVar.cqS.setTag(Integer.valueOf(i));
                    aVar.cqu.setVisibility(0);
                    aVar.cqT.setVisibility(0);
                    aVar.cqv.setVisibility(0);
                    aVar.cqw.setVisibility(8);
                    aVar.aTj.d(this.Xh.get(i).getPortrait(), 12, false);
                    aVar.bsm.setText(this.Xh.get(i).getName_show());
                    aVar.aQt.setText(this.Xh.get(i).getIntro());
                    aVar.cqu.setTag(Integer.valueOf(i));
                    aVar.cqT.setTag(Integer.valueOf(i));
                    String userId = this.Xh.get(i).getUserId();
                    if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        aVar.cqu.setVisibility(8);
                        aVar.cqT.setVisibility(8);
                    } else if (this.Xh.get(i).getIsFriend() == 1) {
                        aVar.cqu.setVisibility(0);
                        aVar.cqT.setVisibility(8);
                    } else {
                        aVar.cqu.setVisibility(8);
                        aVar.cqT.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else {
                aVar.bsm.setText(this.cqO.getPageContext().getString(i.h.loading));
                aVar.mProgress.setVisibility(0);
            }
            applyNightMode(view);
        }
        return view;
    }

    private void applyNightMode(View view) {
        this.cqO.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.cqO.getLayoutMode().k(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.cbJ) {
            return 0;
        }
        return (this.Xh == null || i >= this.Xh.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.cbJ) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView aQt;
        HeadImageView aTj;
        TextView bsm;
        ViewGroup cqS;
        TextView cqT;
        ImageView cqu;
        LinearLayout cqv;
        TextView cqw;
        ProgressBar mProgress;

        private a() {
        }

        /* synthetic */ a(bs bsVar, a aVar) {
            this();
        }
    }
}
