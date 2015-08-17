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
    private ArrayList<UserData> Xe;
    private View.OnClickListener bif;
    boolean bmc;
    private View.OnClickListener cjJ;
    private PersonListActivity cke;
    boolean ckf;
    private View.OnClickListener ckg;
    private View.OnClickListener ckh;
    private int mSex;
    private boolean mHasMore = false;
    private boolean cjI = false;
    boolean bWV = false;

    public void abX() {
        this.bWV = false;
        if (this.Xe != null && this.Xe.size() == 0) {
            this.bWV = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void eH(boolean z) {
        this.cjI = z;
    }

    public br(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4) {
        this.Xe = null;
        this.cke = null;
        this.ckf = false;
        this.bmc = true;
        this.mSex = 0;
        this.cjJ = null;
        this.bif = null;
        this.ckg = null;
        this.ckh = null;
        this.cke = personListActivity;
        this.ckf = z;
        this.bmc = z2;
        this.mSex = i;
        this.cjJ = onClickListener2;
        this.bif = onClickListener3;
        this.ckg = onClickListener;
        this.ckh = onClickListener4;
        this.Xe = new ArrayList<>();
    }

    public void S(ArrayList<UserData> arrayList) {
        this.Xe.addAll(arrayList);
    }

    public void resetData() {
        this.Xe.clear();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bWV) {
            return 1;
        }
        int i = 0;
        if (this.Xe != null) {
            i = this.Xe.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.Xe == null || i >= this.Xe.size()) {
            return null;
        }
        return this.Xe.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.Xe == null || i >= this.Xe.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.Xe != null) {
            if (view == null) {
                a aVar2 = new a(this, null);
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.cke.getPageContext().getPageActivity()).inflate(i.g.person_list_item, (ViewGroup) null);
                    aVar2.cki = (ViewGroup) inflate.findViewById(i.f.item_view);
                    aVar2.cki.setOnClickListener(this.ckg);
                    aVar2.aTO = (HeadImageView) inflate.findViewById(i.f.photo);
                    aVar2.aTO.setIsRound(false);
                    aVar2.aTO.setAutoChangeStyle(true);
                    aVar2.cjL = (LinearLayout) inflate.findViewById(i.f.info);
                    aVar2.boD = (TextView) inflate.findViewById(i.f.name);
                    aVar2.cjM = (TextView) inflate.findViewById(i.f.at_list_nodata);
                    aVar2.aQY = (TextView) inflate.findViewById(i.f.intro);
                    aVar2.cjK = (ImageView) inflate.findViewById(i.f.chat);
                    aVar2.ckj = (TextView) inflate.findViewById(i.f.add);
                    aVar2.cjK.setOnClickListener(this.cjJ);
                    aVar2.ckj.setOnClickListener(this.ckh);
                    aVar2.mProgress = null;
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.cke.getPageContext().getPageActivity()).inflate(i.g.new_pb_list_more, (ViewGroup) null);
                    aVar2.boD = (TextView) inflate2.findViewById(i.f.pb_more_text);
                    inflate2.setOnClickListener(this.bif);
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
                if (this.bWV) {
                    aVar.cjL.setVisibility(8);
                    aVar.cjK.setVisibility(8);
                    aVar.ckj.setVisibility(8);
                    aVar.cjM.setVisibility(0);
                    if (this.ckf) {
                        if (this.bmc) {
                            aVar.cjM.setText(i.C0057i.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.cjM.setText(i.C0057i.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.cjM.setText(i.C0057i.him_no_attention_other);
                        } else {
                            aVar.cjM.setText(i.C0057i.no_attention_other);
                        }
                    } else if (this.bmc) {
                        aVar.cjM.setText(i.C0057i.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.cjM.setText(i.C0057i.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.cjM.setText(i.C0057i.him_no_fan_other);
                    } else {
                        aVar.cjM.setText(i.C0057i.no_fan_other);
                    }
                } else {
                    aVar.cki.setTag(Integer.valueOf(i));
                    aVar.cjK.setVisibility(0);
                    aVar.ckj.setVisibility(0);
                    aVar.cjL.setVisibility(0);
                    aVar.cjM.setVisibility(8);
                    aVar.aTO.d(this.Xe.get(i).getPortrait(), 12, false);
                    aVar.boD.setText(this.Xe.get(i).getName_show());
                    aVar.aQY.setText(this.Xe.get(i).getIntro());
                    aVar.cjK.setTag(Integer.valueOf(i));
                    aVar.ckj.setTag(Integer.valueOf(i));
                    String userId = this.Xe.get(i).getUserId();
                    if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        aVar.cjK.setVisibility(8);
                        aVar.ckj.setVisibility(8);
                    } else if (this.Xe.get(i).getIsFriend() == 1) {
                        aVar.cjK.setVisibility(0);
                        aVar.ckj.setVisibility(8);
                    } else {
                        aVar.cjK.setVisibility(8);
                        aVar.ckj.setVisibility(0);
                    }
                }
                aVar.mProgress = null;
            } else {
                aVar.boD.setText(this.cke.getPageContext().getString(i.C0057i.loading));
                aVar.mProgress.setVisibility(0);
            }
            applyNightMode(view);
        }
        return view;
    }

    private void applyNightMode(View view) {
        this.cke.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.cke.getLayoutMode().k(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.bWV) {
            return 0;
        }
        return (this.Xe == null || i >= this.Xe.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.bWV) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView aQY;
        HeadImageView aTO;
        TextView boD;
        ImageView cjK;
        LinearLayout cjL;
        TextView cjM;
        ViewGroup cki;
        TextView ckj;
        ProgressBar mProgress;

        private a() {
        }

        /* synthetic */ a(br brVar, a aVar) {
            this();
        }
    }
}
