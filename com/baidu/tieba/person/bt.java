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
    private ArrayList<UserData> XX;
    private View.OnClickListener brh;
    boolean bwJ;
    private PersonListActivity cLE;
    boolean cLF;
    private View.OnClickListener cLG;
    private View.OnClickListener cLH;
    private View.OnClickListener cLj;
    private int mSex;
    private boolean mHasMore = false;
    private boolean cLi = false;
    boolean cuk = false;

    public void aic() {
        this.cuk = false;
        if (this.XX != null && this.XX.size() == 0) {
            this.cuk = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void fE(boolean z) {
        this.cLi = z;
    }

    public bt(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4) {
        this.XX = null;
        this.cLE = null;
        this.cLF = false;
        this.bwJ = true;
        this.mSex = 0;
        this.cLj = null;
        this.brh = null;
        this.cLG = null;
        this.cLH = null;
        this.cLE = personListActivity;
        this.cLF = z;
        this.bwJ = z2;
        this.mSex = i;
        this.cLj = onClickListener2;
        this.brh = onClickListener3;
        this.cLG = onClickListener;
        this.cLH = onClickListener4;
        this.XX = new ArrayList<>();
    }

    public void Z(ArrayList<UserData> arrayList) {
        this.XX.addAll(arrayList);
    }

    public void resetData() {
        this.XX.clear();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cuk) {
            return 1;
        }
        int i = 0;
        if (this.XX != null) {
            i = this.XX.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.XX == null || i >= this.XX.size()) {
            return null;
        }
        return this.XX.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.XX == null || i >= this.XX.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.XX != null) {
            if (view == null) {
                a aVar2 = new a(this, null);
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.cLE.getPageContext().getPageActivity()).inflate(n.g.person_list_item, (ViewGroup) null);
                    aVar2.cLI = (ViewGroup) inflate.findViewById(n.f.item_view);
                    aVar2.cLI.setOnClickListener(this.cLG);
                    aVar2.aYF = (HeadImageView) inflate.findViewById(n.f.photo);
                    aVar2.aYF.setIsRound(false);
                    aVar2.aYF.setAutoChangeStyle(true);
                    aVar2.cLl = (LinearLayout) inflate.findViewById(n.f.info);
                    aVar2.bHW = (TextView) inflate.findViewById(n.f.name);
                    aVar2.cLm = (TextView) inflate.findViewById(n.f.at_list_nodata);
                    aVar2.aVE = (TextView) inflate.findViewById(n.f.intro);
                    aVar2.cLk = (ImageView) inflate.findViewById(n.f.chat);
                    aVar2.cLJ = (TextView) inflate.findViewById(n.f.add);
                    aVar2.cLk.setOnClickListener(this.cLj);
                    aVar2.cLJ.setOnClickListener(this.cLH);
                    aVar2.mProgress = null;
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.cLE.getPageContext().getPageActivity()).inflate(n.g.new_pb_list_more, (ViewGroup) null);
                    aVar2.bHW = (TextView) inflate2.findViewById(n.f.pb_more_text);
                    inflate2.setOnClickListener(this.brh);
                    aVar2.mProgress = (ProgressBar) inflate2.findViewById(n.f.progress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.cuk) {
                    aVar.cLl.setVisibility(8);
                    aVar.cLk.setVisibility(8);
                    aVar.cLJ.setVisibility(8);
                    aVar.cLm.setVisibility(0);
                    if (this.cLF) {
                        if (this.bwJ) {
                            aVar.cLm.setText(n.i.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.cLm.setText(n.i.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.cLm.setText(n.i.him_no_attention_other);
                        } else {
                            aVar.cLm.setText(n.i.no_attention_other);
                        }
                    } else if (this.bwJ) {
                        aVar.cLm.setText(n.i.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.cLm.setText(n.i.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.cLm.setText(n.i.him_no_fan_other);
                    } else {
                        aVar.cLm.setText(n.i.no_fan_other);
                    }
                } else {
                    aVar.cLI.setTag(Integer.valueOf(i));
                    aVar.cLk.setVisibility(0);
                    aVar.cLJ.setVisibility(0);
                    aVar.cLl.setVisibility(0);
                    aVar.cLm.setVisibility(8);
                    aVar.aYF.d(this.XX.get(i).getPortrait(), 12, false);
                    aVar.bHW.setText(this.XX.get(i).getName_show());
                    aVar.aVE.setText(this.XX.get(i).getIntro());
                    aVar.cLk.setTag(Integer.valueOf(i));
                    aVar.cLJ.setTag(Integer.valueOf(i));
                    String userId = this.XX.get(i).getUserId();
                    if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        aVar.cLk.setVisibility(8);
                        aVar.cLJ.setVisibility(8);
                    } else if (this.XX.get(i).getIsFriend() == 1) {
                        aVar.cLk.setVisibility(0);
                        aVar.cLJ.setVisibility(8);
                    } else {
                        aVar.cLk.setVisibility(8);
                        aVar.cLJ.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else {
                aVar.bHW.setText(this.cLE.getPageContext().getString(n.i.loading));
                aVar.mProgress.setVisibility(0);
            }
            applyNightMode(view);
        }
        return view;
    }

    private void applyNightMode(View view) {
        this.cLE.getLayoutMode().af(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.cLE.getLayoutMode().k(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.cuk) {
            return 0;
        }
        return (this.XX == null || i >= this.XX.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.cuk) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView aVE;
        HeadImageView aYF;
        TextView bHW;
        ViewGroup cLI;
        TextView cLJ;
        ImageView cLk;
        LinearLayout cLl;
        TextView cLm;
        ProgressBar mProgress;

        private a() {
        }

        /* synthetic */ a(bt btVar, a aVar) {
            this();
        }
    }
}
