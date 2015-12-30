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
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ad extends BaseAdapter {
    private boolean bAA;
    private boolean cNa;
    private String cNb;
    private boolean cOA;
    private View.OnClickListener cOB;
    private PersonBarActivity cOx;
    private r mData;
    private ArrayList<ForumData> cOy = null;
    private boolean aHV = false;
    private View.OnClickListener cOz = null;
    private boolean cyl = false;

    public ad(PersonBarActivity personBarActivity, r rVar, boolean z, boolean z2) {
        this.mData = null;
        this.bAA = true;
        this.cNa = false;
        this.cOA = true;
        this.cOx = personBarActivity;
        this.mData = rVar;
        this.bAA = z;
        this.cNa = z2;
        this.cOA = TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
    }

    public void X(ArrayList<ForumData> arrayList) {
        this.cOy = arrayList;
    }

    public void setEditState(boolean z) {
        this.aHV = z;
        notifyDataSetChanged();
    }

    public boolean GK() {
        return this.aHV;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cyl) {
            return 1;
        }
        if (this.cOy != null) {
            return this.cOy.size();
        }
        return 0;
    }

    public void ajp() {
        this.cyl = false;
        if (this.cOy == null || this.cOy.size() == 0) {
            this.cyl = true;
        }
    }

    public boolean aoK() {
        return this.cyl;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cOy == null || i < 0 || i >= this.cOy.size()) {
            return null;
        }
        return this.cOy.get(i);
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
                view3 = LayoutInflater.from(this.cOx.getPageContext().getContext()).inflate(n.h.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a(this, null);
                    aVar.cnQ = (BarImageView) view3.findViewById(n.g.forum_avatar);
                    aVar.cnQ.setGifIconSupport(false);
                    aVar.bLD = (TextView) view3.findViewById(n.g.name);
                    aVar.cOC = new StringBuffer(10);
                    aVar.cOD = (TextView) view3.findViewById(n.g.degree);
                    aVar.cOE = (TextView) view3.findViewById(n.g.degree_text);
                    aVar.cOI = (TextView) view3.findViewById(n.g.experience);
                    aVar.cOG = (TextView) view3.findViewById(n.g.experience_title);
                    aVar.cOJ = (Button) view3.findViewById(n.g.item_delete);
                    aVar.cOF = (ImageView) view3.findViewById(n.g.degree_text_ta);
                    aVar.cOH = (TextView) view3.findViewById(n.g.intro_ta);
                    aVar.cOK = (ImageView) view3.findViewById(n.g.item_talk);
                    aVar.bZs = (ImageView) view3.findViewById(n.g.diver_buttom_px);
                    aVar.bZs.setVisibility(0);
                    aVar.cOL = (ImageView) view3.findViewById(n.g.item_selected);
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
            if (this.cyl) {
                aVar.cOD.setVisibility(8);
                aVar.cOJ.setVisibility(8);
                aVar.bLD.setVisibility(8);
                aVar.cnQ.setVisibility(8);
                aVar.cOE.setVisibility(8);
                aVar.cOI.setVisibility(8);
                aVar.cOG.setVisibility(8);
                aVar.cOF.setVisibility(8);
                aVar.cOH.setVisibility(8);
                aVar.cOK.setVisibility(8);
                aVar.bZs.setVisibility(8);
            } else {
                aVar.bLD.setVisibility(0);
                aVar.cnQ.setVisibility(0);
                if (this.bAA) {
                    aVar.cOD.setVisibility(8);
                    aVar.cOE.setVisibility(8);
                    aVar.cOI.setVisibility(0);
                    aVar.cOG.setVisibility(0);
                    aVar.cOF.setVisibility(0);
                    aVar.cOH.setVisibility(8);
                    aVar.bZs.setVisibility(0);
                } else {
                    aVar.cOD.setVisibility(8);
                    aVar.cOE.setVisibility(8);
                    aVar.cOI.setVisibility(8);
                    aVar.cOG.setVisibility(8);
                    aVar.cOF.setVisibility(0);
                    aVar.cOH.setVisibility(0);
                    aVar.bZs.setVisibility(0);
                }
            }
            if (this.cOy == null || i < 0 || i >= this.cOy.size() || (forumData = this.cOy.get(i)) == null) {
                view2 = view3;
            } else {
                String image_url = forumData.getImage_url();
                aVar.cnQ.setTag(image_url);
                aVar.cnQ.setImageDrawable(null);
                aVar.cnQ.d(image_url, 10, false);
                aVar.cOC.delete(0, aVar.cOC.length());
                aVar.cOC.append(forumData.getName());
                aVar.cOC.append(this.cOx.getPageContext().getString(n.j.bar));
                aVar.bLD.setText(aVar.cOC);
                if (this.bAA) {
                    com.baidu.tbadk.core.util.as.c(aVar.cOF, com.baidu.tbadk.core.util.c.cj(forumData.getUser_level()));
                    aVar.cOI.setText(String.format(this.cOx.getPageContext().getString(n.j.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.cOJ.setOnClickListener(this.cOz);
                    aVar.cOJ.setTag(Integer.valueOf(i));
                    if (i < this.mData.aoA()) {
                        aVar.bLD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.as.getDrawable(n.f.icon_v), (Drawable) null);
                        if (!this.cNa && this.cOA) {
                            aVar.cOK.setVisibility(0);
                            aVar.cOK.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.bLD.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.cOK.setVisibility(8);
                    }
                    aVar.cOK.setOnClickListener(this.cOB);
                    aVar.cOL.setVisibility(8);
                    if (this.cNa && this.cOx.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.cNb)) {
                        aVar.cOL.setVisibility(0);
                    }
                } else {
                    if ((this.cOx.abl() == 0 && i < this.mData.aoA()) || (this.cOx.abl() == 1 && i < this.mData.aoB())) {
                        aVar.bLD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.as.getDrawable(n.f.icon_v), (Drawable) null);
                    } else {
                        aVar.bLD.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.cOx.abl() == 1) {
                        aVar.cOF.setVisibility(8);
                    }
                    aVar.cOK.setVisibility(8);
                    com.baidu.tbadk.core.util.as.c(aVar.cOF, com.baidu.tbadk.core.util.c.cj(forumData.getUser_level()));
                    aVar.cOH.setText(forumData.getSlogan());
                }
                if (this.aHV) {
                    aVar.cOJ.setVisibility(0);
                    aVar.cOK.setVisibility(8);
                    view2 = view3;
                } else {
                    aVar.cOJ.setVisibility(8);
                    if (i < this.mData.aoA() && this.bAA && !this.cNa && this.cOA) {
                        aVar.cOK.setVisibility(0);
                        view2 = view3;
                    } else {
                        aVar.cOK.setVisibility(8);
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
        this.cOx.getLayoutMode().ac(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.cOx.getLayoutMode().k(view);
    }

    public void x(View.OnClickListener onClickListener) {
        this.cOz = onClickListener;
    }

    public void E(View.OnClickListener onClickListener) {
        this.cOB = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.cyl) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void kQ(String str) {
        this.cNb = str;
    }

    /* loaded from: classes.dex */
    private class a {
        TextView bLD;
        ImageView bZs;
        StringBuffer cOC;
        TextView cOD;
        TextView cOE;
        ImageView cOF;
        TextView cOG;
        TextView cOH;
        TextView cOI;
        Button cOJ;
        ImageView cOK;
        ImageView cOL;
        BarImageView cnQ;

        private a() {
        }

        /* synthetic */ a(ad adVar, a aVar) {
            this();
        }
    }
}
