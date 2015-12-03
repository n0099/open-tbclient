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
    private boolean bwJ;
    private boolean cIK;
    private String cIL;
    private PersonBarActivity cKh;
    private boolean cKk;
    private View.OnClickListener cKl;
    private r mData;
    private ArrayList<ForumData> cKi = null;
    private boolean aGu = false;
    private View.OnClickListener cKj = null;
    private boolean cuk = false;

    public ad(PersonBarActivity personBarActivity, r rVar, boolean z, boolean z2) {
        this.mData = null;
        this.bwJ = true;
        this.cIK = false;
        this.cKk = true;
        this.cKh = personBarActivity;
        this.mData = rVar;
        this.bwJ = z;
        this.cIK = z2;
        this.cKk = TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
    }

    public void Y(ArrayList<ForumData> arrayList) {
        this.cKi = arrayList;
    }

    public void setEditState(boolean z) {
        this.aGu = z;
        notifyDataSetChanged();
    }

    public boolean GV() {
        return this.aGu;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cuk) {
            return 1;
        }
        if (this.cKi != null) {
            return this.cKi.size();
        }
        return 0;
    }

    public void aic() {
        this.cuk = false;
        if (this.cKi == null || this.cKi.size() == 0) {
            this.cuk = true;
        }
    }

    public boolean anz() {
        return this.cuk;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cKi == null || i < 0 || i >= this.cKi.size()) {
            return null;
        }
        return this.cKi.get(i);
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
                view3 = LayoutInflater.from(this.cKh.getPageContext().getContext()).inflate(n.g.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a(this, null);
                    aVar.cjM = (BarImageView) view3.findViewById(n.f.forum_avatar);
                    aVar.cjM.setGifIconSupport(false);
                    aVar.bHW = (TextView) view3.findViewById(n.f.name);
                    aVar.cKm = new StringBuffer(10);
                    aVar.cKn = (TextView) view3.findViewById(n.f.degree);
                    aVar.cKo = (TextView) view3.findViewById(n.f.degree_text);
                    aVar.cKs = (TextView) view3.findViewById(n.f.experience);
                    aVar.cKq = (TextView) view3.findViewById(n.f.experience_title);
                    aVar.cKt = (Button) view3.findViewById(n.f.item_delete);
                    aVar.cKp = (ImageView) view3.findViewById(n.f.degree_text_ta);
                    aVar.cKr = (TextView) view3.findViewById(n.f.intro_ta);
                    aVar.cKu = (ImageView) view3.findViewById(n.f.item_talk);
                    aVar.bVG = (ImageView) view3.findViewById(n.f.diver_buttom_px);
                    aVar.bVG.setVisibility(0);
                    aVar.cKv = (ImageView) view3.findViewById(n.f.item_selected);
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
            if (this.cuk) {
                aVar.cKn.setVisibility(8);
                aVar.cKt.setVisibility(8);
                aVar.bHW.setVisibility(8);
                aVar.cjM.setVisibility(8);
                aVar.cKo.setVisibility(8);
                aVar.cKs.setVisibility(8);
                aVar.cKq.setVisibility(8);
                aVar.cKp.setVisibility(8);
                aVar.cKr.setVisibility(8);
                aVar.cKu.setVisibility(8);
                aVar.bVG.setVisibility(8);
            } else {
                aVar.bHW.setVisibility(0);
                aVar.cjM.setVisibility(0);
                if (this.bwJ) {
                    aVar.cKn.setVisibility(8);
                    aVar.cKo.setVisibility(8);
                    aVar.cKs.setVisibility(0);
                    aVar.cKq.setVisibility(0);
                    aVar.cKp.setVisibility(0);
                    aVar.cKr.setVisibility(8);
                    aVar.bVG.setVisibility(0);
                } else {
                    aVar.cKn.setVisibility(8);
                    aVar.cKo.setVisibility(8);
                    aVar.cKs.setVisibility(8);
                    aVar.cKq.setVisibility(8);
                    aVar.cKp.setVisibility(0);
                    aVar.cKr.setVisibility(0);
                    aVar.bVG.setVisibility(0);
                }
            }
            if (this.cKi == null || i < 0 || i >= this.cKi.size() || (forumData = this.cKi.get(i)) == null) {
                view2 = view3;
            } else {
                String image_url = forumData.getImage_url();
                aVar.cjM.setTag(image_url);
                aVar.cjM.setImageDrawable(null);
                aVar.cjM.d(image_url, 10, false);
                aVar.cKm.delete(0, aVar.cKm.length());
                aVar.cKm.append(forumData.getName());
                aVar.cKm.append(this.cKh.getPageContext().getString(n.i.bar));
                aVar.bHW.setText(aVar.cKm);
                if (this.bwJ) {
                    com.baidu.tbadk.core.util.as.c(aVar.cKp, com.baidu.tbadk.core.util.c.cq(forumData.getUser_level()));
                    aVar.cKs.setText(String.format(this.cKh.getPageContext().getString(n.i.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.cKt.setOnClickListener(this.cKj);
                    aVar.cKt.setTag(Integer.valueOf(i));
                    if (i < this.mData.anp()) {
                        aVar.bHW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.as.getDrawable(n.e.icon_v), (Drawable) null);
                        if (!this.cIK && this.cKk) {
                            aVar.cKu.setVisibility(0);
                            aVar.cKu.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.bHW.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.cKu.setVisibility(8);
                    }
                    aVar.cKu.setOnClickListener(this.cKl);
                    aVar.cKv.setVisibility(8);
                    if (this.cIK && this.cKh.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.cIL)) {
                        aVar.cKv.setVisibility(0);
                    }
                } else {
                    if ((this.cKh.aaf() == 0 && i < this.mData.anp()) || (this.cKh.aaf() == 1 && i < this.mData.anq())) {
                        aVar.bHW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.as.getDrawable(n.e.icon_v), (Drawable) null);
                    } else {
                        aVar.bHW.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.cKh.aaf() == 1) {
                        aVar.cKp.setVisibility(8);
                    }
                    aVar.cKu.setVisibility(8);
                    com.baidu.tbadk.core.util.as.c(aVar.cKp, com.baidu.tbadk.core.util.c.cq(forumData.getUser_level()));
                    aVar.cKr.setText(forumData.getSlogan());
                }
                if (this.aGu) {
                    aVar.cKt.setVisibility(0);
                    aVar.cKu.setVisibility(8);
                    view2 = view3;
                } else {
                    aVar.cKt.setVisibility(8);
                    if (i < this.mData.anp() && this.bwJ && !this.cIK && this.cKk) {
                        aVar.cKu.setVisibility(0);
                        view2 = view3;
                    } else {
                        aVar.cKu.setVisibility(8);
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
        this.cKh.getLayoutMode().af(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.cKh.getLayoutMode().k(view);
    }

    public void x(View.OnClickListener onClickListener) {
        this.cKj = onClickListener;
    }

    public void E(View.OnClickListener onClickListener) {
        this.cKl = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.cuk) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void kT(String str) {
        this.cIL = str;
    }

    /* loaded from: classes.dex */
    private class a {
        TextView bHW;
        ImageView bVG;
        StringBuffer cKm;
        TextView cKn;
        TextView cKo;
        ImageView cKp;
        TextView cKq;
        TextView cKr;
        TextView cKs;
        Button cKt;
        ImageView cKu;
        ImageView cKv;
        BarImageView cjM;

        private a() {
        }

        /* synthetic */ a(ad adVar, a aVar) {
            this();
        }
    }
}
