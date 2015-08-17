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
    private boolean bmc;
    private boolean chs;
    private String cht;
    private PersonBarActivity ciJ;
    private boolean ciM;
    private View.OnClickListener ciN;
    private q mData;
    private ArrayList<ForumData> ciK = null;
    private boolean aDE = false;
    private View.OnClickListener ciL = null;
    private boolean bWV = false;

    public ac(PersonBarActivity personBarActivity, q qVar, boolean z, boolean z2) {
        this.mData = null;
        this.bmc = true;
        this.chs = false;
        this.ciM = true;
        this.ciJ = personBarActivity;
        this.mData = qVar;
        this.bmc = z;
        this.chs = z2;
        this.ciM = TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
    }

    public void R(ArrayList<ForumData> arrayList) {
        this.ciK = arrayList;
    }

    public void setEditState(boolean z) {
        this.aDE = z;
        notifyDataSetChanged();
    }

    public boolean FR() {
        return this.aDE;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bWV) {
            return 1;
        }
        if (this.ciK != null) {
            return this.ciK.size();
        }
        return 0;
    }

    public void abX() {
        this.bWV = false;
        if (this.ciK == null || this.ciK.size() == 0) {
            this.bWV = true;
        }
    }

    public boolean agf() {
        return this.bWV;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.ciK == null || i < 0 || i >= this.ciK.size()) {
            return null;
        }
        return this.ciK.get(i);
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
                view3 = LayoutInflater.from(this.ciJ.getPageContext().getContext()).inflate(i.g.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a(this, null);
                    aVar.bOK = (BarImageView) view3.findViewById(i.f.forum_avatar);
                    aVar.bOK.setGifIconSupport(false);
                    aVar.boD = (TextView) view3.findViewById(i.f.name);
                    aVar.ciO = new StringBuffer(10);
                    aVar.ciP = (TextView) view3.findViewById(i.f.degree);
                    aVar.ciQ = (TextView) view3.findViewById(i.f.degree_text);
                    aVar.ciU = (TextView) view3.findViewById(i.f.experience);
                    aVar.ciS = (TextView) view3.findViewById(i.f.experience_title);
                    aVar.ciV = (Button) view3.findViewById(i.f.item_delete);
                    aVar.ciR = (ImageView) view3.findViewById(i.f.degree_text_ta);
                    aVar.ciT = (TextView) view3.findViewById(i.f.intro_ta);
                    aVar.ciW = (ImageView) view3.findViewById(i.f.item_talk);
                    aVar.bCj = (ImageView) view3.findViewById(i.f.diver_buttom_px);
                    aVar.bCj.setVisibility(0);
                    aVar.ciX = (ImageView) view3.findViewById(i.f.item_selected);
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
            if (this.bWV) {
                aVar.ciP.setVisibility(8);
                aVar.ciV.setVisibility(8);
                aVar.boD.setVisibility(8);
                aVar.bOK.setVisibility(8);
                aVar.ciQ.setVisibility(8);
                aVar.ciU.setVisibility(8);
                aVar.ciS.setVisibility(8);
                aVar.ciR.setVisibility(8);
                aVar.ciT.setVisibility(8);
                aVar.ciW.setVisibility(8);
                aVar.bCj.setVisibility(8);
            } else {
                aVar.boD.setVisibility(0);
                aVar.bOK.setVisibility(0);
                if (this.bmc) {
                    aVar.ciP.setVisibility(8);
                    aVar.ciQ.setVisibility(8);
                    aVar.ciU.setVisibility(0);
                    aVar.ciS.setVisibility(0);
                    aVar.ciR.setVisibility(0);
                    aVar.ciT.setVisibility(8);
                    aVar.bCj.setVisibility(0);
                } else {
                    aVar.ciP.setVisibility(8);
                    aVar.ciQ.setVisibility(8);
                    aVar.ciU.setVisibility(8);
                    aVar.ciS.setVisibility(8);
                    aVar.ciR.setVisibility(0);
                    aVar.ciT.setVisibility(0);
                    aVar.bCj.setVisibility(0);
                }
            }
            if (this.ciK == null || i < 0 || i >= this.ciK.size() || (forumData = this.ciK.get(i)) == null) {
                view2 = view3;
            } else {
                String image_url = forumData.getImage_url();
                aVar.bOK.setTag(image_url);
                aVar.bOK.setImageDrawable(null);
                aVar.bOK.d(image_url, 10, false);
                aVar.ciO.delete(0, aVar.ciO.length());
                aVar.ciO.append(forumData.getName());
                aVar.ciO.append(this.ciJ.getPageContext().getString(i.C0057i.bar));
                aVar.boD.setText(aVar.ciO);
                if (this.bmc) {
                    com.baidu.tbadk.core.util.al.c(aVar.ciR, com.baidu.tbadk.core.util.c.cc(forumData.getUser_level()));
                    aVar.ciU.setText(String.format(this.ciJ.getPageContext().getString(i.C0057i.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.ciV.setOnClickListener(this.ciL);
                    aVar.ciV.setTag(Integer.valueOf(i));
                    if (i < this.mData.afV()) {
                        aVar.boD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(i.e.icon_v), (Drawable) null);
                        if (!this.chs && this.ciM) {
                            aVar.ciW.setVisibility(0);
                            aVar.ciW.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.boD.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.ciW.setVisibility(8);
                    }
                    aVar.ciW.setOnClickListener(this.ciN);
                    aVar.ciX.setVisibility(8);
                    if (this.chs && this.ciJ.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.cht)) {
                        aVar.ciX.setVisibility(0);
                    }
                } else {
                    if ((this.ciJ.VX() == 0 && i < this.mData.afV()) || (this.ciJ.VX() == 1 && i < this.mData.afW())) {
                        aVar.boD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(i.e.icon_v), (Drawable) null);
                    } else {
                        aVar.boD.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.ciJ.VX() == 1) {
                        aVar.ciR.setVisibility(8);
                    }
                    aVar.ciW.setVisibility(8);
                    com.baidu.tbadk.core.util.al.c(aVar.ciR, com.baidu.tbadk.core.util.c.cc(forumData.getUser_level()));
                    aVar.ciT.setText(forumData.getSlogan());
                }
                if (this.aDE) {
                    aVar.ciV.setVisibility(0);
                    aVar.ciW.setVisibility(8);
                    view2 = view3;
                } else {
                    aVar.ciV.setVisibility(8);
                    if (i < this.mData.afV() && this.bmc && !this.chs && this.ciM) {
                        aVar.ciW.setVisibility(0);
                        view2 = view3;
                    } else {
                        aVar.ciW.setVisibility(8);
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
        this.ciJ.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.ciJ.getLayoutMode().k(view);
    }

    public void x(View.OnClickListener onClickListener) {
        this.ciL = onClickListener;
    }

    public void E(View.OnClickListener onClickListener) {
        this.ciN = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.bWV) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void jw(String str) {
        this.cht = str;
    }

    /* loaded from: classes.dex */
    private class a {
        ImageView bCj;
        BarImageView bOK;
        TextView boD;
        StringBuffer ciO;
        TextView ciP;
        TextView ciQ;
        ImageView ciR;
        TextView ciS;
        TextView ciT;
        TextView ciU;
        Button ciV;
        ImageView ciW;
        ImageView ciX;

        private a() {
        }

        /* synthetic */ a(ac acVar, a aVar) {
            this();
        }
    }
}
