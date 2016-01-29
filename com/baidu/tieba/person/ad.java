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
    private boolean bDM;
    private boolean cWu;
    private String cWv;
    private PersonBarActivity cXS;
    private boolean cXV;
    private View.OnClickListener cXW;
    private r mData;
    private ArrayList<ForumData> cXT = null;
    private boolean aIX = false;
    private View.OnClickListener cXU = null;
    private boolean cES = false;

    public ad(PersonBarActivity personBarActivity, r rVar, boolean z, boolean z2) {
        this.mData = null;
        this.bDM = true;
        this.cWu = false;
        this.cXV = true;
        this.cXS = personBarActivity;
        this.mData = rVar;
        this.bDM = z;
        this.cWu = z2;
        this.cXV = TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
    }

    public void Y(ArrayList<ForumData> arrayList) {
        this.cXT = arrayList;
    }

    public void setEditState(boolean z) {
        this.aIX = z;
        notifyDataSetChanged();
    }

    public boolean Il() {
        return this.aIX;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cES) {
            return 1;
        }
        if (this.cXT != null) {
            return this.cXT.size();
        }
        return 0;
    }

    public void ann() {
        this.cES = false;
        if (this.cXT == null || this.cXT.size() == 0) {
            this.cES = true;
        }
    }

    public boolean atC() {
        return this.cES;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cXT == null || i < 0 || i >= this.cXT.size()) {
            return null;
        }
        return this.cXT.get(i);
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
                view3 = LayoutInflater.from(this.cXS.getPageContext().getContext()).inflate(t.h.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a(this, null);
                    aVar.cuz = (BarImageView) view3.findViewById(t.g.forum_avatar);
                    aVar.cuz.setGifIconSupport(false);
                    aVar.bPr = (TextView) view3.findViewById(t.g.name);
                    aVar.cXX = new StringBuffer(10);
                    aVar.cXY = (TextView) view3.findViewById(t.g.degree);
                    aVar.cXZ = (TextView) view3.findViewById(t.g.degree_text);
                    aVar.cYd = (TextView) view3.findViewById(t.g.experience);
                    aVar.cYb = (TextView) view3.findViewById(t.g.experience_title);
                    aVar.cYe = (Button) view3.findViewById(t.g.item_delete);
                    aVar.cYa = (ImageView) view3.findViewById(t.g.degree_text_ta);
                    aVar.cYc = (TextView) view3.findViewById(t.g.intro_ta);
                    aVar.cYf = (ImageView) view3.findViewById(t.g.item_talk);
                    aVar.cdN = (ImageView) view3.findViewById(t.g.diver_buttom_px);
                    aVar.cdN.setVisibility(0);
                    aVar.cYg = (ImageView) view3.findViewById(t.g.item_selected);
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
            if (this.cES) {
                aVar.cXY.setVisibility(8);
                aVar.cYe.setVisibility(8);
                aVar.bPr.setVisibility(8);
                aVar.cuz.setVisibility(8);
                aVar.cXZ.setVisibility(8);
                aVar.cYd.setVisibility(8);
                aVar.cYb.setVisibility(8);
                aVar.cYa.setVisibility(8);
                aVar.cYc.setVisibility(8);
                aVar.cYf.setVisibility(8);
                aVar.cdN.setVisibility(8);
            } else {
                aVar.bPr.setVisibility(0);
                aVar.cuz.setVisibility(0);
                if (this.bDM) {
                    aVar.cXY.setVisibility(8);
                    aVar.cXZ.setVisibility(8);
                    aVar.cYd.setVisibility(0);
                    aVar.cYb.setVisibility(0);
                    aVar.cYa.setVisibility(0);
                    aVar.cYc.setVisibility(8);
                    aVar.cdN.setVisibility(0);
                } else {
                    aVar.cXY.setVisibility(8);
                    aVar.cXZ.setVisibility(8);
                    aVar.cYd.setVisibility(8);
                    aVar.cYb.setVisibility(8);
                    aVar.cYa.setVisibility(0);
                    aVar.cYc.setVisibility(0);
                    aVar.cdN.setVisibility(0);
                }
            }
            if (this.cXT == null || i < 0 || i >= this.cXT.size() || (forumData = this.cXT.get(i)) == null) {
                view2 = view3;
            } else {
                String image_url = forumData.getImage_url();
                aVar.cuz.setTag(image_url);
                aVar.cuz.setImageDrawable(null);
                aVar.cuz.d(image_url, 10, false);
                aVar.cXX.delete(0, aVar.cXX.length());
                aVar.cXX.append(forumData.getName());
                aVar.cXX.append(this.cXS.getPageContext().getString(t.j.bar));
                aVar.bPr.setText(aVar.cXX);
                if (this.bDM) {
                    com.baidu.tbadk.core.util.ar.c(aVar.cYa, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.cYd.setText(String.format(this.cXS.getPageContext().getString(t.j.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.cYe.setOnClickListener(this.cXU);
                    aVar.cYe.setTag(Integer.valueOf(i));
                    if (i < this.mData.atr()) {
                        aVar.bPr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.ar.getDrawable(t.f.icon_v), (Drawable) null);
                        if (!this.cWu && this.cXV) {
                            aVar.cYf.setVisibility(0);
                            aVar.cYf.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.bPr.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.cYf.setVisibility(8);
                    }
                    aVar.cYf.setOnClickListener(this.cXW);
                    aVar.cYg.setVisibility(8);
                    if (this.cWu && this.cXS.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.cWv)) {
                        aVar.cYg.setVisibility(0);
                    }
                } else {
                    if ((this.cXS.ael() == 0 && i < this.mData.atr()) || (this.cXS.ael() == 1 && i < this.mData.ats())) {
                        aVar.bPr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.ar.getDrawable(t.f.icon_v), (Drawable) null);
                    } else {
                        aVar.bPr.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.cXS.ael() == 1) {
                        aVar.cYa.setVisibility(8);
                    }
                    aVar.cYf.setVisibility(8);
                    com.baidu.tbadk.core.util.ar.c(aVar.cYa, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.cYc.setText(forumData.getSlogan());
                }
                if (this.aIX) {
                    aVar.cYe.setVisibility(0);
                    aVar.cYf.setVisibility(8);
                    view2 = view3;
                } else {
                    aVar.cYe.setVisibility(8);
                    if (i < this.mData.atr() && this.bDM && !this.cWu && this.cXV) {
                        aVar.cYf.setVisibility(0);
                        view2 = view3;
                    } else {
                        aVar.cYf.setVisibility(8);
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
        this.cXS.getLayoutMode().ac(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.cXS.getLayoutMode().x(view);
    }

    public void D(View.OnClickListener onClickListener) {
        this.cXU = onClickListener;
    }

    public void K(View.OnClickListener onClickListener) {
        this.cXW = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.cES) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void kX(String str) {
        this.cWv = str;
    }

    /* loaded from: classes.dex */
    private class a {
        TextView bPr;
        StringBuffer cXX;
        TextView cXY;
        TextView cXZ;
        ImageView cYa;
        TextView cYb;
        TextView cYc;
        TextView cYd;
        Button cYe;
        ImageView cYf;
        ImageView cYg;
        ImageView cdN;
        BarImageView cuz;

        private a() {
        }

        /* synthetic */ a(ad adVar, a aVar) {
            this();
        }
    }
}
