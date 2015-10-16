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
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ac extends BaseAdapter {
    private boolean bnk;
    private boolean cnT;
    private String cnU;
    private PersonBarActivity cpr;
    private boolean cpu;
    private View.OnClickListener cpv;
    private q mData;
    private ArrayList<ForumData> cps = null;
    private boolean aEC = false;
    private View.OnClickListener cpt = null;
    private boolean cbJ = false;

    public ac(PersonBarActivity personBarActivity, q qVar, boolean z, boolean z2) {
        this.mData = null;
        this.bnk = true;
        this.cnT = false;
        this.cpu = true;
        this.cpr = personBarActivity;
        this.mData = qVar;
        this.bnk = z;
        this.cnT = z2;
        this.cpu = TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
    }

    public void S(ArrayList<ForumData> arrayList) {
        this.cps = arrayList;
    }

    public void setEditState(boolean z) {
        this.aEC = z;
        notifyDataSetChanged();
    }

    public boolean FV() {
        return this.aEC;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cbJ) {
            return 1;
        }
        if (this.cps != null) {
            return this.cps.size();
        }
        return 0;
    }

    public void adx() {
        this.cbJ = false;
        if (this.cps == null || this.cps.size() == 0) {
            this.cbJ = true;
        }
    }

    public boolean aiu() {
        return this.cbJ;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cps == null || i < 0 || i >= this.cps.size()) {
            return null;
        }
        return this.cps.get(i);
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
                view3 = LayoutInflater.from(this.cpr.getPageContext().getContext()).inflate(i.g.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a(this, null);
                    aVar.bTd = (BarImageView) view3.findViewById(i.f.forum_avatar);
                    aVar.bTd.setGifIconSupport(false);
                    aVar.bsm = (TextView) view3.findViewById(i.f.name);
                    aVar.cpw = new StringBuffer(10);
                    aVar.cpx = (TextView) view3.findViewById(i.f.degree);
                    aVar.cpy = (TextView) view3.findViewById(i.f.degree_text);
                    aVar.cpC = (TextView) view3.findViewById(i.f.experience);
                    aVar.cpA = (TextView) view3.findViewById(i.f.experience_title);
                    aVar.cpD = (Button) view3.findViewById(i.f.item_delete);
                    aVar.cpz = (ImageView) view3.findViewById(i.f.degree_text_ta);
                    aVar.cpB = (TextView) view3.findViewById(i.f.intro_ta);
                    aVar.cpE = (ImageView) view3.findViewById(i.f.item_talk);
                    aVar.bGe = (ImageView) view3.findViewById(i.f.diver_buttom_px);
                    aVar.bGe.setVisibility(0);
                    aVar.cpF = (ImageView) view3.findViewById(i.f.item_selected);
                    view3.setTag(aVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    BdLog.e(exc.getMessage());
                    applyNightMode(view2);
                    return view2;
                }
            } else {
                aVar = (a) view.getTag();
                view3 = view;
            }
            if (this.cbJ) {
                aVar.cpx.setVisibility(8);
                aVar.cpD.setVisibility(8);
                aVar.bsm.setVisibility(8);
                aVar.bTd.setVisibility(8);
                aVar.cpy.setVisibility(8);
                aVar.cpC.setVisibility(8);
                aVar.cpA.setVisibility(8);
                aVar.cpz.setVisibility(8);
                aVar.cpB.setVisibility(8);
                aVar.cpE.setVisibility(8);
                aVar.bGe.setVisibility(8);
            } else {
                aVar.bsm.setVisibility(0);
                aVar.bTd.setVisibility(0);
                if (this.bnk) {
                    aVar.cpx.setVisibility(8);
                    aVar.cpy.setVisibility(8);
                    aVar.cpC.setVisibility(0);
                    aVar.cpA.setVisibility(0);
                    aVar.cpz.setVisibility(0);
                    aVar.cpB.setVisibility(8);
                    aVar.bGe.setVisibility(0);
                } else {
                    aVar.cpx.setVisibility(8);
                    aVar.cpy.setVisibility(8);
                    aVar.cpC.setVisibility(8);
                    aVar.cpA.setVisibility(8);
                    aVar.cpz.setVisibility(0);
                    aVar.cpB.setVisibility(0);
                    aVar.bGe.setVisibility(0);
                }
            }
            if (this.cps == null || i < 0 || i >= this.cps.size() || (forumData = this.cps.get(i)) == null) {
                view2 = view3;
            } else {
                String image_url = forumData.getImage_url();
                aVar.bTd.setTag(image_url);
                aVar.bTd.setImageDrawable(null);
                aVar.bTd.d(image_url, 10, false);
                aVar.cpw.delete(0, aVar.cpw.length());
                aVar.cpw.append(forumData.getName());
                aVar.cpw.append(this.cpr.getPageContext().getString(i.h.bar));
                aVar.bsm.setText(aVar.cpw);
                if (this.bnk) {
                    com.baidu.tbadk.core.util.an.c(aVar.cpz, com.baidu.tbadk.core.util.c.ci(forumData.getUser_level()));
                    aVar.cpC.setText(String.format(this.cpr.getPageContext().getString(i.h.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.cpD.setOnClickListener(this.cpt);
                    aVar.cpD.setTag(Integer.valueOf(i));
                    if (i < this.mData.aik()) {
                        aVar.bsm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.an.getDrawable(i.e.icon_v), (Drawable) null);
                        if (!this.cnT && this.cpu) {
                            aVar.cpE.setVisibility(0);
                            aVar.cpE.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.bsm.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.cpE.setVisibility(8);
                    }
                    aVar.cpE.setOnClickListener(this.cpv);
                    aVar.cpF.setVisibility(8);
                    if (this.cnT && this.cpr.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.cnU)) {
                        aVar.cpF.setVisibility(0);
                    }
                } else {
                    if ((this.cpr.WI() == 0 && i < this.mData.aik()) || (this.cpr.WI() == 1 && i < this.mData.ail())) {
                        aVar.bsm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.an.getDrawable(i.e.icon_v), (Drawable) null);
                    } else {
                        aVar.bsm.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.cpr.WI() == 1) {
                        aVar.cpz.setVisibility(8);
                    }
                    aVar.cpE.setVisibility(8);
                    com.baidu.tbadk.core.util.an.c(aVar.cpz, com.baidu.tbadk.core.util.c.ci(forumData.getUser_level()));
                    aVar.cpB.setText(forumData.getSlogan());
                }
                if (this.aEC) {
                    aVar.cpD.setVisibility(0);
                    aVar.cpE.setVisibility(8);
                    view2 = view3;
                } else {
                    aVar.cpD.setVisibility(8);
                    if (i < this.mData.aik() && this.bnk && !this.cnT && this.cpu) {
                        aVar.cpE.setVisibility(0);
                        view2 = view3;
                    } else {
                        aVar.cpE.setVisibility(8);
                        view2 = view3;
                    }
                }
            }
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
        applyNightMode(view2);
        return view2;
    }

    private void applyNightMode(View view) {
        this.cpr.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.cpr.getLayoutMode().k(view);
    }

    public void x(View.OnClickListener onClickListener) {
        this.cpt = onClickListener;
    }

    public void E(View.OnClickListener onClickListener) {
        this.cpv = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.cbJ) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void jZ(String str) {
        this.cnU = str;
    }

    /* loaded from: classes.dex */
    private class a {
        ImageView bGe;
        BarImageView bTd;
        TextView bsm;
        TextView cpA;
        TextView cpB;
        TextView cpC;
        Button cpD;
        ImageView cpE;
        ImageView cpF;
        StringBuffer cpw;
        TextView cpx;
        TextView cpy;
        ImageView cpz;

        private a() {
        }

        /* synthetic */ a(ac acVar, a aVar) {
            this();
        }
    }
}
