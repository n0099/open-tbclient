package com.baidu.tieba.person;

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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ad extends BaseAdapter {
    private boolean bJj;
    private boolean dqW;
    private String dqX;
    private PersonBarActivity dsu;
    private boolean dsx;
    private View.OnClickListener dsy;
    private r mData;
    private ArrayList<ForumData> dsv = null;
    private boolean aLT = false;
    private View.OnClickListener dsw = null;
    private boolean cYk = false;

    public ad(PersonBarActivity personBarActivity, r rVar, boolean z, boolean z2) {
        this.mData = null;
        this.bJj = true;
        this.dqW = false;
        this.dsx = true;
        this.dsu = personBarActivity;
        this.mData = rVar;
        this.bJj = z;
        this.dqW = z2;
        this.dsx = TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
    }

    public void Z(ArrayList<ForumData> arrayList) {
        this.dsv = arrayList;
    }

    public void setEditState(boolean z) {
        this.aLT = z;
        notifyDataSetChanged();
    }

    public boolean JH() {
        return this.aLT;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cYk) {
            return 1;
        }
        if (this.dsv != null) {
            return this.dsv.size();
        }
        return 0;
    }

    public void aug() {
        this.cYk = false;
        if (this.dsv == null || this.dsv.size() == 0) {
            this.cYk = true;
        }
    }

    public boolean aBi() {
        return this.cYk;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dsv == null || i < 0 || i >= this.dsv.size()) {
            return null;
        }
        return this.dsv.get(i);
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
                view3 = LayoutInflater.from(this.dsu.getPageContext().getContext()).inflate(t.h.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a(this, null);
                    aVar.cEY = (BarImageView) view3.findViewById(t.g.forum_avatar);
                    aVar.cEY.setGifIconSupport(false);
                    aVar.bZJ = (TextView) view3.findViewById(t.g.name);
                    aVar.dsz = new StringBuffer(10);
                    aVar.dsA = (TextView) view3.findViewById(t.g.degree);
                    aVar.dsB = (TextView) view3.findViewById(t.g.degree_text);
                    aVar.dsF = (TextView) view3.findViewById(t.g.experience);
                    aVar.dsD = (TextView) view3.findViewById(t.g.experience_title);
                    aVar.dsG = (Button) view3.findViewById(t.g.item_delete);
                    aVar.dsC = (ImageView) view3.findViewById(t.g.degree_text_ta);
                    aVar.dsE = (TextView) view3.findViewById(t.g.intro_ta);
                    aVar.dsH = (ImageView) view3.findViewById(t.g.item_talk);
                    aVar.cos = (ImageView) view3.findViewById(t.g.diver_buttom_px);
                    aVar.cos.setVisibility(0);
                    aVar.dsI = (ImageView) view3.findViewById(t.g.item_selected);
                    view3.setTag(aVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    BdLog.e(exc.getMessage());
                    u(view2);
                    return view2;
                }
            } else {
                aVar = (a) view.getTag();
                view3 = view;
            }
            if (this.cYk) {
                aVar.dsA.setVisibility(8);
                aVar.dsG.setVisibility(8);
                aVar.bZJ.setVisibility(8);
                aVar.cEY.setVisibility(8);
                aVar.dsB.setVisibility(8);
                aVar.dsF.setVisibility(8);
                aVar.dsD.setVisibility(8);
                aVar.dsC.setVisibility(8);
                aVar.dsE.setVisibility(8);
                aVar.dsH.setVisibility(8);
                aVar.cos.setVisibility(8);
            } else {
                aVar.bZJ.setVisibility(0);
                aVar.cEY.setVisibility(0);
                if (this.bJj) {
                    aVar.dsA.setVisibility(8);
                    aVar.dsB.setVisibility(8);
                    aVar.dsF.setVisibility(0);
                    aVar.dsD.setVisibility(0);
                    aVar.dsC.setVisibility(0);
                    aVar.dsE.setVisibility(8);
                    aVar.cos.setVisibility(0);
                } else {
                    aVar.dsA.setVisibility(8);
                    aVar.dsB.setVisibility(8);
                    aVar.dsF.setVisibility(8);
                    aVar.dsD.setVisibility(8);
                    aVar.dsC.setVisibility(0);
                    aVar.dsE.setVisibility(0);
                    aVar.cos.setVisibility(0);
                }
            }
            if (this.dsv == null || i < 0 || i >= this.dsv.size() || (forumData = this.dsv.get(i)) == null) {
                view2 = view3;
            } else {
                String image_url = forumData.getImage_url();
                aVar.cEY.setTag(image_url);
                aVar.cEY.setImageDrawable(null);
                aVar.cEY.c(image_url, 10, false);
                aVar.dsz.delete(0, aVar.dsz.length());
                aVar.dsz.append(forumData.getName());
                aVar.dsz.append(this.dsu.getPageContext().getString(t.j.bar));
                aVar.bZJ.setText(aVar.dsz);
                if (this.bJj) {
                    com.baidu.tbadk.core.util.at.c(aVar.dsC, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.dsF.setText(String.format(this.dsu.getPageContext().getString(t.j.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.dsG.setOnClickListener(this.dsw);
                    aVar.dsG.setTag(Integer.valueOf(i));
                    if (i < this.mData.aAX()) {
                        aVar.bZJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_v), (Drawable) null);
                        if (!this.dqW && this.dsx) {
                            aVar.dsH.setVisibility(0);
                            aVar.dsH.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.bZJ.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.dsH.setVisibility(8);
                    }
                    aVar.dsH.setOnClickListener(this.dsy);
                    aVar.dsI.setVisibility(8);
                    if (this.dqW && this.dsu.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.dqX)) {
                        aVar.dsI.setVisibility(0);
                    }
                } else {
                    if ((this.dsu.ahE() == 0 && i < this.mData.aAX()) || (this.dsu.ahE() == 1 && i < this.mData.aAY())) {
                        aVar.bZJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_v), (Drawable) null);
                    } else {
                        aVar.bZJ.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.dsu.ahE() == 1) {
                        aVar.dsC.setVisibility(8);
                    }
                    aVar.dsH.setVisibility(8);
                    com.baidu.tbadk.core.util.at.c(aVar.dsC, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.dsE.setText(forumData.getSlogan());
                }
                if (this.aLT) {
                    aVar.dsG.setVisibility(0);
                    aVar.dsH.setVisibility(8);
                    view2 = view3;
                } else {
                    aVar.dsG.setVisibility(8);
                    if (i < this.mData.aAX() && this.bJj && !this.dqW && this.dsx) {
                        aVar.dsH.setVisibility(0);
                        view2 = view3;
                    } else {
                        aVar.dsH.setVisibility(8);
                        view2 = view3;
                    }
                }
            }
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
        u(view2);
        return view2;
    }

    private void u(View view) {
        this.dsu.getLayoutMode().ab(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.dsu.getLayoutMode().x(view);
    }

    public void H(View.OnClickListener onClickListener) {
        this.dsw = onClickListener;
    }

    public void O(View.OnClickListener onClickListener) {
        this.dsy = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.cYk) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void mm(String str) {
        this.dqX = str;
    }

    /* loaded from: classes.dex */
    private class a {
        TextView bZJ;
        BarImageView cEY;
        ImageView cos;
        TextView dsA;
        TextView dsB;
        ImageView dsC;
        TextView dsD;
        TextView dsE;
        TextView dsF;
        Button dsG;
        ImageView dsH;
        ImageView dsI;
        StringBuffer dsz;

        private a() {
        }

        /* synthetic */ a(ad adVar, a aVar) {
            this();
        }
    }
}
