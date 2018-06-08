package com.baidu.tieba.personExtra;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private boolean dJI;
    private boolean fRs;
    private String fRt;
    private PersonBarActivity fSX;
    private boolean fSZ;
    private View.OnClickListener fTa;
    private com.baidu.tieba.personExtra.a mData;
    private ArrayList<ForumData> mForumList = null;
    private boolean bkz = false;
    private View.OnClickListener fSY = null;
    private boolean fey = false;

    public b(PersonBarActivity personBarActivity, com.baidu.tieba.personExtra.a aVar, boolean z, boolean z2) {
        this.mData = null;
        this.dJI = true;
        this.fRs = false;
        this.fSZ = true;
        this.fSX = personBarActivity;
        this.mData = aVar;
        this.dJI = z;
        this.fRs = z2;
        this.fSZ = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void ct(boolean z) {
        this.bkz = z;
        notifyDataSetChanged();
    }

    public boolean Qm() {
        return this.bkz;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fey) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void aXn() {
        this.fey = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.fey = true;
        }
    }

    public boolean bjx() {
        return this.fey;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mForumList == null || i < 0 || i >= this.mForumList.size()) {
            return null;
        }
        return this.mForumList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        a aVar;
        View view3;
        ForumData forumData;
        try {
            if (view == null) {
                view3 = LayoutInflater.from(this.fSX.getPageContext().getContext()).inflate(d.i.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.eOl = (BarImageView) view3.findViewById(d.g.forum_avatar);
                    aVar.eOl.setGifIconSupport(false);
                    aVar.mName = (TextView) view3.findViewById(d.g.name);
                    aVar.fTb = new StringBuffer(10);
                    aVar.fTc = (TextView) view3.findViewById(d.g.degree);
                    aVar.fTd = (TextView) view3.findViewById(d.g.degree_text);
                    aVar.fTh = (TextView) view3.findViewById(d.g.experience);
                    aVar.fTf = (TextView) view3.findViewById(d.g.experience_title);
                    aVar.fTi = (Button) view3.findViewById(d.g.item_delete);
                    aVar.fTe = (ImageView) view3.findViewById(d.g.degree_text_ta);
                    aVar.fTg = (TextView) view3.findViewById(d.g.intro_ta);
                    aVar.fTj = (ImageView) view3.findViewById(d.g.item_talk);
                    aVar.esy = (ImageView) view3.findViewById(d.g.diver_buttom_px);
                    aVar.esy.setVisibility(0);
                    aVar.fTk = (ImageView) view3.findViewById(d.g.item_selected);
                    view3.setTag(aVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    BdLog.e(exc.getMessage());
                    aD(view2);
                    return view2;
                }
            } else {
                aVar = (a) view.getTag();
                view3 = view;
            }
            if (this.fey) {
                aVar.fTc.setVisibility(8);
                aVar.fTi.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.eOl.setVisibility(8);
                aVar.fTd.setVisibility(8);
                aVar.fTh.setVisibility(8);
                aVar.fTf.setVisibility(8);
                aVar.fTe.setVisibility(8);
                aVar.fTg.setVisibility(8);
                aVar.fTj.setVisibility(8);
                aVar.esy.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.eOl.setVisibility(0);
                if (this.dJI) {
                    aVar.fTc.setVisibility(8);
                    aVar.fTd.setVisibility(8);
                    aVar.fTh.setVisibility(0);
                    aVar.fTf.setVisibility(0);
                    aVar.fTe.setVisibility(0);
                    aVar.fTg.setVisibility(8);
                    aVar.esy.setVisibility(0);
                } else {
                    aVar.fTc.setVisibility(8);
                    aVar.fTd.setVisibility(8);
                    aVar.fTh.setVisibility(8);
                    aVar.fTf.setVisibility(8);
                    aVar.fTe.setVisibility(0);
                    aVar.fTg.setVisibility(0);
                    aVar.esy.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.eOl.setTag(image_url);
                aVar.eOl.setImageDrawable(null);
                aVar.eOl.startLoad(image_url, 10, false);
                aVar.fTb.delete(0, aVar.fTb.length());
                aVar.fTb.append(forumData.getName());
                aVar.fTb.append(this.fSX.getPageContext().getString(d.k.forum));
                aVar.mName.setText(aVar.fTb);
                if (this.dJI) {
                    al.c(aVar.fTe, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.fTh.setText(String.format(this.fSX.getPageContext().getString(d.k.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.fTi.setOnClickListener(this.fSY);
                    aVar.fTi.setTag(Integer.valueOf(i));
                    if (i < this.mData.bjm()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_v), (Drawable) null);
                        if (!this.fRs && this.fSZ) {
                            aVar.fTj.setVisibility(0);
                            aVar.fTj.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.fTj.setVisibility(8);
                    }
                    aVar.fTj.setOnClickListener(this.fTa);
                    aVar.fTk.setVisibility(8);
                    if (this.fRs && this.fSX.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.fRt)) {
                        aVar.fTk.setVisibility(0);
                    }
                } else {
                    if ((this.fSX.aLe() == 0 && i < this.mData.bjm()) || (this.fSX.aLe() == 1 && i < this.mData.bjn())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.fSX.aLe() == 1) {
                        aVar.fTe.setVisibility(8);
                    }
                    aVar.fTj.setVisibility(8);
                    al.c(aVar.fTe, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.fTg.setText(forumData.getSlogan());
                }
                if (this.bkz) {
                    aVar.fTi.setVisibility(0);
                    aVar.fTj.setVisibility(8);
                } else {
                    aVar.fTi.setVisibility(8);
                    if (i < this.mData.bjm() && this.dJI && !this.fRs && this.fSZ) {
                        aVar.fTj.setVisibility(0);
                    } else {
                        aVar.fTj.setVisibility(8);
                    }
                }
            }
            view2 = view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
        aD(view2);
        return view2;
    }

    private void aD(View view) {
        this.fSX.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.fSX.getLayoutMode().onModeChanged(view);
    }

    public void z(View.OnClickListener onClickListener) {
        this.fSY = onClickListener;
    }

    public void M(View.OnClickListener onClickListener) {
        this.fTa = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fey) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void rY(String str) {
        this.fRt = str;
    }

    /* loaded from: classes3.dex */
    private class a {
        BarImageView eOl;
        ImageView esy;
        StringBuffer fTb;
        TextView fTc;
        TextView fTd;
        ImageView fTe;
        TextView fTf;
        TextView fTg;
        TextView fTh;
        Button fTi;
        ImageView fTj;
        ImageView fTk;
        TextView mName;

        private a() {
        }
    }
}
