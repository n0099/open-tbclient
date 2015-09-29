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
    private boolean bmZ;
    private boolean cnI;
    private String cnJ;
    private PersonBarActivity cpg;
    private boolean cpj;
    private View.OnClickListener cpk;
    private q mData;
    private ArrayList<ForumData> cph = null;
    private boolean aEr = false;
    private View.OnClickListener cpi = null;
    private boolean cby = false;

    public ac(PersonBarActivity personBarActivity, q qVar, boolean z, boolean z2) {
        this.mData = null;
        this.bmZ = true;
        this.cnI = false;
        this.cpj = true;
        this.cpg = personBarActivity;
        this.mData = qVar;
        this.bmZ = z;
        this.cnI = z2;
        this.cpj = TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
    }

    public void S(ArrayList<ForumData> arrayList) {
        this.cph = arrayList;
    }

    public void setEditState(boolean z) {
        this.aEr = z;
        notifyDataSetChanged();
    }

    public boolean FV() {
        return this.aEr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cby) {
            return 1;
        }
        if (this.cph != null) {
            return this.cph.size();
        }
        return 0;
    }

    public void adx() {
        this.cby = false;
        if (this.cph == null || this.cph.size() == 0) {
            this.cby = true;
        }
    }

    public boolean aiu() {
        return this.cby;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cph == null || i < 0 || i >= this.cph.size()) {
            return null;
        }
        return this.cph.get(i);
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
                view3 = LayoutInflater.from(this.cpg.getPageContext().getContext()).inflate(i.g.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a(this, null);
                    aVar.bSS = (BarImageView) view3.findViewById(i.f.forum_avatar);
                    aVar.bSS.setGifIconSupport(false);
                    aVar.bsb = (TextView) view3.findViewById(i.f.name);
                    aVar.cpl = new StringBuffer(10);
                    aVar.cpm = (TextView) view3.findViewById(i.f.degree);
                    aVar.cpn = (TextView) view3.findViewById(i.f.degree_text);
                    aVar.cpr = (TextView) view3.findViewById(i.f.experience);
                    aVar.cpp = (TextView) view3.findViewById(i.f.experience_title);
                    aVar.cps = (Button) view3.findViewById(i.f.item_delete);
                    aVar.cpo = (ImageView) view3.findViewById(i.f.degree_text_ta);
                    aVar.cpq = (TextView) view3.findViewById(i.f.intro_ta);
                    aVar.cpt = (ImageView) view3.findViewById(i.f.item_talk);
                    aVar.bFT = (ImageView) view3.findViewById(i.f.diver_buttom_px);
                    aVar.bFT.setVisibility(0);
                    aVar.cpu = (ImageView) view3.findViewById(i.f.item_selected);
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
            if (this.cby) {
                aVar.cpm.setVisibility(8);
                aVar.cps.setVisibility(8);
                aVar.bsb.setVisibility(8);
                aVar.bSS.setVisibility(8);
                aVar.cpn.setVisibility(8);
                aVar.cpr.setVisibility(8);
                aVar.cpp.setVisibility(8);
                aVar.cpo.setVisibility(8);
                aVar.cpq.setVisibility(8);
                aVar.cpt.setVisibility(8);
                aVar.bFT.setVisibility(8);
            } else {
                aVar.bsb.setVisibility(0);
                aVar.bSS.setVisibility(0);
                if (this.bmZ) {
                    aVar.cpm.setVisibility(8);
                    aVar.cpn.setVisibility(8);
                    aVar.cpr.setVisibility(0);
                    aVar.cpp.setVisibility(0);
                    aVar.cpo.setVisibility(0);
                    aVar.cpq.setVisibility(8);
                    aVar.bFT.setVisibility(0);
                } else {
                    aVar.cpm.setVisibility(8);
                    aVar.cpn.setVisibility(8);
                    aVar.cpr.setVisibility(8);
                    aVar.cpp.setVisibility(8);
                    aVar.cpo.setVisibility(0);
                    aVar.cpq.setVisibility(0);
                    aVar.bFT.setVisibility(0);
                }
            }
            if (this.cph == null || i < 0 || i >= this.cph.size() || (forumData = this.cph.get(i)) == null) {
                view2 = view3;
            } else {
                String image_url = forumData.getImage_url();
                aVar.bSS.setTag(image_url);
                aVar.bSS.setImageDrawable(null);
                aVar.bSS.d(image_url, 10, false);
                aVar.cpl.delete(0, aVar.cpl.length());
                aVar.cpl.append(forumData.getName());
                aVar.cpl.append(this.cpg.getPageContext().getString(i.h.bar));
                aVar.bsb.setText(aVar.cpl);
                if (this.bmZ) {
                    com.baidu.tbadk.core.util.am.c(aVar.cpo, com.baidu.tbadk.core.util.c.ci(forumData.getUser_level()));
                    aVar.cpr.setText(String.format(this.cpg.getPageContext().getString(i.h.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.cps.setOnClickListener(this.cpi);
                    aVar.cps.setTag(Integer.valueOf(i));
                    if (i < this.mData.aik()) {
                        aVar.bsb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(i.e.icon_v), (Drawable) null);
                        if (!this.cnI && this.cpj) {
                            aVar.cpt.setVisibility(0);
                            aVar.cpt.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.bsb.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.cpt.setVisibility(8);
                    }
                    aVar.cpt.setOnClickListener(this.cpk);
                    aVar.cpu.setVisibility(8);
                    if (this.cnI && this.cpg.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.cnJ)) {
                        aVar.cpu.setVisibility(0);
                    }
                } else {
                    if ((this.cpg.WI() == 0 && i < this.mData.aik()) || (this.cpg.WI() == 1 && i < this.mData.ail())) {
                        aVar.bsb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(i.e.icon_v), (Drawable) null);
                    } else {
                        aVar.bsb.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.cpg.WI() == 1) {
                        aVar.cpo.setVisibility(8);
                    }
                    aVar.cpt.setVisibility(8);
                    com.baidu.tbadk.core.util.am.c(aVar.cpo, com.baidu.tbadk.core.util.c.ci(forumData.getUser_level()));
                    aVar.cpq.setText(forumData.getSlogan());
                }
                if (this.aEr) {
                    aVar.cps.setVisibility(0);
                    aVar.cpt.setVisibility(8);
                    view2 = view3;
                } else {
                    aVar.cps.setVisibility(8);
                    if (i < this.mData.aik() && this.bmZ && !this.cnI && this.cpj) {
                        aVar.cpt.setVisibility(0);
                        view2 = view3;
                    } else {
                        aVar.cpt.setVisibility(8);
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
        this.cpg.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.cpg.getLayoutMode().k(view);
    }

    public void x(View.OnClickListener onClickListener) {
        this.cpi = onClickListener;
    }

    public void E(View.OnClickListener onClickListener) {
        this.cpk = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.cby) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void jZ(String str) {
        this.cnJ = str;
    }

    /* loaded from: classes.dex */
    private class a {
        ImageView bFT;
        BarImageView bSS;
        TextView bsb;
        StringBuffer cpl;
        TextView cpm;
        TextView cpn;
        ImageView cpo;
        TextView cpp;
        TextView cpq;
        TextView cpr;
        Button cps;
        ImageView cpt;
        ImageView cpu;

        private a() {
        }

        /* synthetic */ a(ac acVar, a aVar) {
            this();
        }
    }
}
