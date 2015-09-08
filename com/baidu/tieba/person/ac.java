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
    private boolean bmy;
    private boolean cim;
    private String cin;
    private PersonBarActivity cjD;
    private boolean cjG;
    private View.OnClickListener cjH;
    private q mData;
    private ArrayList<ForumData> cjE = null;
    private boolean aFm = false;
    private View.OnClickListener cjF = null;
    private boolean bXM = false;

    public ac(PersonBarActivity personBarActivity, q qVar, boolean z, boolean z2) {
        this.mData = null;
        this.bmy = true;
        this.cim = false;
        this.cjG = true;
        this.cjD = personBarActivity;
        this.mData = qVar;
        this.bmy = z;
        this.cim = z2;
        this.cjG = TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
    }

    public void R(ArrayList<ForumData> arrayList) {
        this.cjE = arrayList;
    }

    public void setEditState(boolean z) {
        this.aFm = z;
        notifyDataSetChanged();
    }

    public boolean Gb() {
        return this.aFm;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bXM) {
            return 1;
        }
        if (this.cjE != null) {
            return this.cjE.size();
        }
        return 0;
    }

    public void acf() {
        this.bXM = false;
        if (this.cjE == null || this.cjE.size() == 0) {
            this.bXM = true;
        }
    }

    public boolean agv() {
        return this.bXM;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cjE == null || i < 0 || i >= this.cjE.size()) {
            return null;
        }
        return this.cjE.get(i);
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
                view3 = LayoutInflater.from(this.cjD.getPageContext().getContext()).inflate(i.g.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a(this, null);
                    aVar.bPq = (BarImageView) view3.findViewById(i.f.forum_avatar);
                    aVar.bPq.setGifIconSupport(false);
                    aVar.bpb = (TextView) view3.findViewById(i.f.name);
                    aVar.cjI = new StringBuffer(10);
                    aVar.cjJ = (TextView) view3.findViewById(i.f.degree);
                    aVar.cjK = (TextView) view3.findViewById(i.f.degree_text);
                    aVar.cjO = (TextView) view3.findViewById(i.f.experience);
                    aVar.cjM = (TextView) view3.findViewById(i.f.experience_title);
                    aVar.cjP = (Button) view3.findViewById(i.f.item_delete);
                    aVar.cjL = (ImageView) view3.findViewById(i.f.degree_text_ta);
                    aVar.cjN = (TextView) view3.findViewById(i.f.intro_ta);
                    aVar.cjQ = (ImageView) view3.findViewById(i.f.item_talk);
                    aVar.bCQ = (ImageView) view3.findViewById(i.f.diver_buttom_px);
                    aVar.bCQ.setVisibility(0);
                    aVar.cjR = (ImageView) view3.findViewById(i.f.item_selected);
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
            if (this.bXM) {
                aVar.cjJ.setVisibility(8);
                aVar.cjP.setVisibility(8);
                aVar.bpb.setVisibility(8);
                aVar.bPq.setVisibility(8);
                aVar.cjK.setVisibility(8);
                aVar.cjO.setVisibility(8);
                aVar.cjM.setVisibility(8);
                aVar.cjL.setVisibility(8);
                aVar.cjN.setVisibility(8);
                aVar.cjQ.setVisibility(8);
                aVar.bCQ.setVisibility(8);
            } else {
                aVar.bpb.setVisibility(0);
                aVar.bPq.setVisibility(0);
                if (this.bmy) {
                    aVar.cjJ.setVisibility(8);
                    aVar.cjK.setVisibility(8);
                    aVar.cjO.setVisibility(0);
                    aVar.cjM.setVisibility(0);
                    aVar.cjL.setVisibility(0);
                    aVar.cjN.setVisibility(8);
                    aVar.bCQ.setVisibility(0);
                } else {
                    aVar.cjJ.setVisibility(8);
                    aVar.cjK.setVisibility(8);
                    aVar.cjO.setVisibility(8);
                    aVar.cjM.setVisibility(8);
                    aVar.cjL.setVisibility(0);
                    aVar.cjN.setVisibility(0);
                    aVar.bCQ.setVisibility(0);
                }
            }
            if (this.cjE == null || i < 0 || i >= this.cjE.size() || (forumData = this.cjE.get(i)) == null) {
                view2 = view3;
            } else {
                String image_url = forumData.getImage_url();
                aVar.bPq.setTag(image_url);
                aVar.bPq.setImageDrawable(null);
                aVar.bPq.d(image_url, 10, false);
                aVar.cjI.delete(0, aVar.cjI.length());
                aVar.cjI.append(forumData.getName());
                aVar.cjI.append(this.cjD.getPageContext().getString(i.h.bar));
                aVar.bpb.setText(aVar.cjI);
                if (this.bmy) {
                    com.baidu.tbadk.core.util.al.c(aVar.cjL, com.baidu.tbadk.core.util.c.cg(forumData.getUser_level()));
                    aVar.cjO.setText(String.format(this.cjD.getPageContext().getString(i.h.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.cjP.setOnClickListener(this.cjF);
                    aVar.cjP.setTag(Integer.valueOf(i));
                    if (i < this.mData.agl()) {
                        aVar.bpb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(i.e.icon_v), (Drawable) null);
                        if (!this.cim && this.cjG) {
                            aVar.cjQ.setVisibility(0);
                            aVar.cjQ.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.bpb.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.cjQ.setVisibility(8);
                    }
                    aVar.cjQ.setOnClickListener(this.cjH);
                    aVar.cjR.setVisibility(8);
                    if (this.cim && this.cjD.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.cin)) {
                        aVar.cjR.setVisibility(0);
                    }
                } else {
                    if ((this.cjD.VZ() == 0 && i < this.mData.agl()) || (this.cjD.VZ() == 1 && i < this.mData.agm())) {
                        aVar.bpb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(i.e.icon_v), (Drawable) null);
                    } else {
                        aVar.bpb.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.cjD.VZ() == 1) {
                        aVar.cjL.setVisibility(8);
                    }
                    aVar.cjQ.setVisibility(8);
                    com.baidu.tbadk.core.util.al.c(aVar.cjL, com.baidu.tbadk.core.util.c.cg(forumData.getUser_level()));
                    aVar.cjN.setText(forumData.getSlogan());
                }
                if (this.aFm) {
                    aVar.cjP.setVisibility(0);
                    aVar.cjQ.setVisibility(8);
                    view2 = view3;
                } else {
                    aVar.cjP.setVisibility(8);
                    if (i < this.mData.agl() && this.bmy && !this.cim && this.cjG) {
                        aVar.cjQ.setVisibility(0);
                        view2 = view3;
                    } else {
                        aVar.cjQ.setVisibility(8);
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
        this.cjD.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.cjD.getLayoutMode().k(view);
    }

    public void w(View.OnClickListener onClickListener) {
        this.cjF = onClickListener;
    }

    public void D(View.OnClickListener onClickListener) {
        this.cjH = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.bXM) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void jE(String str) {
        this.cin = str;
    }

    /* loaded from: classes.dex */
    private class a {
        ImageView bCQ;
        BarImageView bPq;
        TextView bpb;
        StringBuffer cjI;
        TextView cjJ;
        TextView cjK;
        ImageView cjL;
        TextView cjM;
        TextView cjN;
        TextView cjO;
        Button cjP;
        ImageView cjQ;
        ImageView cjR;

        private a() {
        }

        /* synthetic */ a(ac acVar, a aVar) {
            this();
        }
    }
}
