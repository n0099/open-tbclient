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
    private boolean bnO;
    private boolean cpp;
    private String cpq;
    private PersonBarActivity cqN;
    private boolean cqQ;
    private View.OnClickListener cqR;
    private q mData;
    private ArrayList<ForumData> cqO = null;
    private boolean aDw = false;
    private View.OnClickListener cqP = null;
    private boolean cck = false;

    public ac(PersonBarActivity personBarActivity, q qVar, boolean z, boolean z2) {
        this.mData = null;
        this.bnO = true;
        this.cpp = false;
        this.cqQ = true;
        this.cqN = personBarActivity;
        this.mData = qVar;
        this.bnO = z;
        this.cpp = z2;
        this.cqQ = TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
    }

    public void S(ArrayList<ForumData> arrayList) {
        this.cqO = arrayList;
    }

    public void setEditState(boolean z) {
        this.aDw = z;
        notifyDataSetChanged();
    }

    public boolean FO() {
        return this.aDw;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cck) {
            return 1;
        }
        if (this.cqO != null) {
            return this.cqO.size();
        }
        return 0;
    }

    public void adO() {
        this.cck = false;
        if (this.cqO == null || this.cqO.size() == 0) {
            this.cck = true;
        }
    }

    public boolean aiW() {
        return this.cck;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cqO == null || i < 0 || i >= this.cqO.size()) {
            return null;
        }
        return this.cqO.get(i);
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
                view3 = LayoutInflater.from(this.cqN.getPageContext().getContext()).inflate(i.g.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a(this, null);
                    aVar.bTy = (BarImageView) view3.findViewById(i.f.forum_avatar);
                    aVar.bTy.setGifIconSupport(false);
                    aVar.bsQ = (TextView) view3.findViewById(i.f.name);
                    aVar.cqS = new StringBuffer(10);
                    aVar.cqT = (TextView) view3.findViewById(i.f.degree);
                    aVar.cqU = (TextView) view3.findViewById(i.f.degree_text);
                    aVar.cqY = (TextView) view3.findViewById(i.f.experience);
                    aVar.cqW = (TextView) view3.findViewById(i.f.experience_title);
                    aVar.cqZ = (Button) view3.findViewById(i.f.item_delete);
                    aVar.cqV = (ImageView) view3.findViewById(i.f.degree_text_ta);
                    aVar.cqX = (TextView) view3.findViewById(i.f.intro_ta);
                    aVar.cra = (ImageView) view3.findViewById(i.f.item_talk);
                    aVar.bGz = (ImageView) view3.findViewById(i.f.diver_buttom_px);
                    aVar.bGz.setVisibility(0);
                    aVar.crb = (ImageView) view3.findViewById(i.f.item_selected);
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
            if (this.cck) {
                aVar.cqT.setVisibility(8);
                aVar.cqZ.setVisibility(8);
                aVar.bsQ.setVisibility(8);
                aVar.bTy.setVisibility(8);
                aVar.cqU.setVisibility(8);
                aVar.cqY.setVisibility(8);
                aVar.cqW.setVisibility(8);
                aVar.cqV.setVisibility(8);
                aVar.cqX.setVisibility(8);
                aVar.cra.setVisibility(8);
                aVar.bGz.setVisibility(8);
            } else {
                aVar.bsQ.setVisibility(0);
                aVar.bTy.setVisibility(0);
                if (this.bnO) {
                    aVar.cqT.setVisibility(8);
                    aVar.cqU.setVisibility(8);
                    aVar.cqY.setVisibility(0);
                    aVar.cqW.setVisibility(0);
                    aVar.cqV.setVisibility(0);
                    aVar.cqX.setVisibility(8);
                    aVar.bGz.setVisibility(0);
                } else {
                    aVar.cqT.setVisibility(8);
                    aVar.cqU.setVisibility(8);
                    aVar.cqY.setVisibility(8);
                    aVar.cqW.setVisibility(8);
                    aVar.cqV.setVisibility(0);
                    aVar.cqX.setVisibility(0);
                    aVar.bGz.setVisibility(0);
                }
            }
            if (this.cqO == null || i < 0 || i >= this.cqO.size() || (forumData = this.cqO.get(i)) == null) {
                view2 = view3;
            } else {
                String image_url = forumData.getImage_url();
                aVar.bTy.setTag(image_url);
                aVar.bTy.setImageDrawable(null);
                aVar.bTy.d(image_url, 10, false);
                aVar.cqS.delete(0, aVar.cqS.length());
                aVar.cqS.append(forumData.getName());
                aVar.cqS.append(this.cqN.getPageContext().getString(i.h.bar));
                aVar.bsQ.setText(aVar.cqS);
                if (this.bnO) {
                    com.baidu.tbadk.core.util.an.c(aVar.cqV, com.baidu.tbadk.core.util.c.ci(forumData.getUser_level()));
                    aVar.cqY.setText(String.format(this.cqN.getPageContext().getString(i.h.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.cqZ.setOnClickListener(this.cqP);
                    aVar.cqZ.setTag(Integer.valueOf(i));
                    if (i < this.mData.aiM()) {
                        aVar.bsQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.an.getDrawable(i.e.icon_v), (Drawable) null);
                        if (!this.cpp && this.cqQ) {
                            aVar.cra.setVisibility(0);
                            aVar.cra.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.bsQ.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.cra.setVisibility(8);
                    }
                    aVar.cra.setOnClickListener(this.cqR);
                    aVar.crb.setVisibility(8);
                    if (this.cpp && this.cqN.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.cpq)) {
                        aVar.crb.setVisibility(0);
                    }
                } else {
                    if ((this.cqN.WZ() == 0 && i < this.mData.aiM()) || (this.cqN.WZ() == 1 && i < this.mData.aiN())) {
                        aVar.bsQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.an.getDrawable(i.e.icon_v), (Drawable) null);
                    } else {
                        aVar.bsQ.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.cqN.WZ() == 1) {
                        aVar.cqV.setVisibility(8);
                    }
                    aVar.cra.setVisibility(8);
                    com.baidu.tbadk.core.util.an.c(aVar.cqV, com.baidu.tbadk.core.util.c.ci(forumData.getUser_level()));
                    aVar.cqX.setText(forumData.getSlogan());
                }
                if (this.aDw) {
                    aVar.cqZ.setVisibility(0);
                    aVar.cra.setVisibility(8);
                    view2 = view3;
                } else {
                    aVar.cqZ.setVisibility(8);
                    if (i < this.mData.aiM() && this.bnO && !this.cpp && this.cqQ) {
                        aVar.cra.setVisibility(0);
                        view2 = view3;
                    } else {
                        aVar.cra.setVisibility(8);
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
        this.cqN.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.cqN.getLayoutMode().k(view);
    }

    public void x(View.OnClickListener onClickListener) {
        this.cqP = onClickListener;
    }

    public void E(View.OnClickListener onClickListener) {
        this.cqR = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.cck) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void kc(String str) {
        this.cpq = str;
    }

    /* loaded from: classes.dex */
    private class a {
        ImageView bGz;
        BarImageView bTy;
        TextView bsQ;
        StringBuffer cqS;
        TextView cqT;
        TextView cqU;
        ImageView cqV;
        TextView cqW;
        TextView cqX;
        TextView cqY;
        Button cqZ;
        ImageView cra;
        ImageView crb;

        private a() {
        }

        /* synthetic */ a(ac acVar, a aVar) {
            this();
        }
    }
}
