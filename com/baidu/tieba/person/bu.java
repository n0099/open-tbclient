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
    private ArrayList<UserData> YX;
    boolean bDM;
    private View.OnClickListener byd;
    private View.OnClickListener cYW;
    private PersonListActivity cZr;
    boolean cZs;
    private View.OnClickListener cZt;
    private View.OnClickListener cZu;
    private int mSex;
    private boolean mHasMore = false;
    private boolean cYV = false;
    boolean cES = false;

    public void ann() {
        this.cES = false;
        if (this.YX != null && this.YX.size() == 0) {
            this.cES = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void fS(boolean z) {
        this.cYV = z;
    }

    public bu(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4) {
        this.YX = null;
        this.cZr = null;
        this.cZs = false;
        this.bDM = true;
        this.mSex = 0;
        this.cYW = null;
        this.byd = null;
        this.cZt = null;
        this.cZu = null;
        this.cZr = personListActivity;
        this.cZs = z;
        this.bDM = z2;
        this.mSex = i;
        this.cYW = onClickListener2;
        this.byd = onClickListener3;
        this.cZt = onClickListener;
        this.cZu = onClickListener4;
        this.YX = new ArrayList<>();
    }

    public void Z(ArrayList<UserData> arrayList) {
        this.YX.addAll(arrayList);
    }

    public void resetData() {
        this.YX.clear();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cES) {
            return 1;
        }
        int i = 0;
        if (this.YX != null) {
            i = this.YX.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.YX == null || i >= this.YX.size()) {
            return null;
        }
        return this.YX.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.YX == null || i >= this.YX.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.YX != null) {
            if (view == null) {
                a aVar2 = new a(this, null);
                if (getItemViewType(i) == 0) {
                    View inflate = LayoutInflater.from(this.cZr.getPageContext().getPageActivity()).inflate(t.h.person_list_item, (ViewGroup) null);
                    aVar2.cZv = (ViewGroup) inflate.findViewById(t.g.item_view);
                    aVar2.cZv.setOnClickListener(this.cZt);
                    aVar2.beU = (HeadImageView) inflate.findViewById(t.g.photo);
                    aVar2.beU.setIsRound(false);
                    aVar2.beU.setAutoChangeStyle(true);
                    aVar2.cYY = (LinearLayout) inflate.findViewById(t.g.info);
                    aVar2.bPr = (TextView) inflate.findViewById(t.g.name);
                    aVar2.cYZ = (TextView) inflate.findViewById(t.g.at_list_nodata);
                    aVar2.bbT = (TextView) inflate.findViewById(t.g.intro);
                    aVar2.cYX = (ImageView) inflate.findViewById(t.g.chat);
                    aVar2.cZw = (TextView) inflate.findViewById(t.g.add);
                    aVar2.cYX.setOnClickListener(this.cYW);
                    aVar2.cZw.setOnClickListener(this.cZu);
                    aVar2.aNo = null;
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.cZr.getPageContext().getPageActivity()).inflate(t.h.new_pb_list_more, (ViewGroup) null);
                    aVar2.bPr = (TextView) inflate2.findViewById(t.g.pb_more_text);
                    inflate2.setOnClickListener(this.byd);
                    aVar2.aNo = (ProgressBar) inflate2.findViewById(t.g.progress);
                    view2 = inflate2;
                }
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.cES) {
                    aVar.cYY.setVisibility(8);
                    aVar.cYX.setVisibility(8);
                    aVar.cZw.setVisibility(8);
                    aVar.cYZ.setVisibility(0);
                    if (this.cZs) {
                        if (this.bDM) {
                            aVar.cYZ.setText(t.j.not_have_attention);
                        } else if (this.mSex == 2) {
                            aVar.cYZ.setText(t.j.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            aVar.cYZ.setText(t.j.him_no_attention_other);
                        } else {
                            aVar.cYZ.setText(t.j.no_attention_other);
                        }
                    } else if (this.bDM) {
                        aVar.cYZ.setText(t.j.not_have_fans);
                    } else if (this.mSex == 2) {
                        aVar.cYZ.setText(t.j.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        aVar.cYZ.setText(t.j.him_no_fan_other);
                    } else {
                        aVar.cYZ.setText(t.j.no_fan_other);
                    }
                } else {
                    aVar.cZv.setTag(Integer.valueOf(i));
                    aVar.cYX.setVisibility(0);
                    aVar.cZw.setVisibility(0);
                    aVar.cYY.setVisibility(0);
                    aVar.cYZ.setVisibility(8);
                    aVar.beU.d(this.YX.get(i).getPortrait(), 12, false);
                    aVar.bPr.setText(this.YX.get(i).getName_show());
                    aVar.bbT.setText(this.YX.get(i).getIntro());
                    aVar.cYX.setTag(Integer.valueOf(i));
                    aVar.cZw.setTag(Integer.valueOf(i));
                    String userId = this.YX.get(i).getUserId();
                    if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        aVar.cYX.setVisibility(8);
                        aVar.cZw.setVisibility(8);
                    } else if (this.YX.get(i).getIsFriend() == 1) {
                        aVar.cYX.setVisibility(0);
                        aVar.cZw.setVisibility(8);
                    } else {
                        aVar.cYX.setVisibility(8);
                        aVar.cZw.setVisibility(0);
                    }
                }
                aVar.aNo = null;
            } else {
                aVar.bPr.setText(this.cZr.getPageContext().getString(t.j.loading));
                aVar.aNo.setVisibility(0);
            }
            u(view);
        }
        return view;
    }

    private void u(View view) {
        this.cZr.getLayoutMode().ac(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.cZr.getLayoutMode().x(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.cES) {
            return 0;
        }
        return (this.YX == null || i >= this.YX.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.cES) {
            return false;
        }
        return super.isEnabled(i);
    }

    /* loaded from: classes.dex */
    private class a {
        ProgressBar aNo;
        TextView bPr;
        TextView bbT;
        HeadImageView beU;
        ImageView cYX;
        LinearLayout cYY;
        TextView cYZ;
        ViewGroup cZv;
        TextView cZw;

        private a() {
        }

        /* synthetic */ a(bu buVar, a aVar) {
            this();
        }
    }
}
