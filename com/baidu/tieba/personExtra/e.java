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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class e extends BaseAdapter {
    private boolean ecK;
    private boolean gku;
    private String gkv;
    private PersonBarActivity glZ;
    private boolean gmb;
    private View.OnClickListener gmc;
    private c mData;
    private ArrayList<ForumData> mForumList = null;
    private boolean bSu = false;
    private View.OnClickListener gma = null;
    private boolean fxo = false;

    public e(PersonBarActivity personBarActivity, c cVar, boolean z, boolean z2) {
        this.mData = null;
        this.ecK = true;
        this.gku = false;
        this.gmb = true;
        this.glZ = personBarActivity;
        this.mData = cVar;
        this.ecK = z;
        this.gku = z2;
        this.gmb = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void cX(boolean z) {
        this.bSu = z;
        notifyDataSetChanged();
    }

    public boolean Uo() {
        return this.bSu;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fxo) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void aXv() {
        this.fxo = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.fxo = true;
        }
    }

    public boolean bjv() {
        return this.fxo;
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
                view3 = LayoutInflater.from(this.glZ.getPageContext().getContext()).inflate(d.h.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.fhf = (BarImageView) view3.findViewById(d.g.forum_avatar);
                    aVar.fhf.setGifIconSupport(false);
                    aVar.mName = (TextView) view3.findViewById(d.g.name);
                    aVar.gmd = new StringBuffer(10);
                    aVar.gme = (TextView) view3.findViewById(d.g.degree);
                    aVar.gmf = (TextView) view3.findViewById(d.g.degree_text);
                    aVar.gmj = (TextView) view3.findViewById(d.g.experience);
                    aVar.gmh = (TextView) view3.findViewById(d.g.experience_title);
                    aVar.gmk = (Button) view3.findViewById(d.g.item_delete);
                    aVar.gmg = (ImageView) view3.findViewById(d.g.degree_text_ta);
                    aVar.gmi = (TextView) view3.findViewById(d.g.intro_ta);
                    aVar.gml = (ImageView) view3.findViewById(d.g.item_talk);
                    aVar.eLu = (ImageView) view3.findViewById(d.g.diver_buttom_px);
                    aVar.eLu.setVisibility(0);
                    aVar.gmm = (ImageView) view3.findViewById(d.g.item_selected);
                    view3.setTag(aVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    BdLog.e(exc.getMessage());
                    bU(view2);
                    return view2;
                }
            } else {
                aVar = (a) view.getTag();
                view3 = view;
            }
            if (this.fxo) {
                aVar.gme.setVisibility(8);
                aVar.gmk.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.fhf.setVisibility(8);
                aVar.gmf.setVisibility(8);
                aVar.gmj.setVisibility(8);
                aVar.gmh.setVisibility(8);
                aVar.gmg.setVisibility(8);
                aVar.gmi.setVisibility(8);
                aVar.gml.setVisibility(8);
                aVar.eLu.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.fhf.setVisibility(0);
                if (this.ecK) {
                    aVar.gme.setVisibility(8);
                    aVar.gmf.setVisibility(8);
                    aVar.gmj.setVisibility(0);
                    aVar.gmh.setVisibility(0);
                    aVar.gmg.setVisibility(0);
                    aVar.gmi.setVisibility(8);
                    aVar.eLu.setVisibility(0);
                } else {
                    aVar.gme.setVisibility(8);
                    aVar.gmf.setVisibility(8);
                    aVar.gmj.setVisibility(8);
                    aVar.gmh.setVisibility(8);
                    aVar.gmg.setVisibility(0);
                    aVar.gmi.setVisibility(0);
                    aVar.eLu.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.fhf.setTag(image_url);
                aVar.fhf.setImageDrawable(null);
                aVar.fhf.startLoad(image_url, 10, false);
                aVar.gmd.delete(0, aVar.gmd.length());
                aVar.gmd.append(forumData.getName());
                aVar.gmd.append(this.glZ.getPageContext().getString(d.j.forum));
                aVar.mName.setText(aVar.gmd);
                if (this.ecK) {
                    aj.c(aVar.gmg, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.gmj.setText(String.format(this.glZ.getPageContext().getString(d.j.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.gmk.setOnClickListener(this.gma);
                    aVar.gmk.setTag(Integer.valueOf(i));
                    if (i < this.mData.bjk()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_v), (Drawable) null);
                        if (!this.gku && this.gmb) {
                            aVar.gml.setVisibility(0);
                            aVar.gml.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.gml.setVisibility(8);
                    }
                    aVar.gml.setOnClickListener(this.gmc);
                    aVar.gmm.setVisibility(8);
                    if (this.gku && this.glZ.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.gkv)) {
                        aVar.gmm.setVisibility(0);
                    }
                } else {
                    if ((this.glZ.aLo() == 0 && i < this.mData.bjk()) || (this.glZ.aLo() == 1 && i < this.mData.bjl())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.glZ.aLo() == 1) {
                        aVar.gmg.setVisibility(8);
                    }
                    aVar.gml.setVisibility(8);
                    aj.c(aVar.gmg, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.gmi.setText(forumData.getSlogan());
                }
                if (this.bSu) {
                    aVar.gmk.setVisibility(0);
                    aVar.gml.setVisibility(8);
                } else {
                    aVar.gmk.setVisibility(8);
                    if (i < this.mData.bjk() && this.ecK && !this.gku && this.gmb) {
                        aVar.gml.setVisibility(0);
                    } else {
                        aVar.gml.setVisibility(8);
                    }
                }
            }
            view2 = view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
        bU(view2);
        return view2;
    }

    private void bU(View view) {
        this.glZ.getLayoutMode().aQ(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.glZ.getLayoutMode().aM(view);
    }

    public void y(View.OnClickListener onClickListener) {
        this.gma = onClickListener;
    }

    public void L(View.OnClickListener onClickListener) {
        this.gmc = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fxo) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void qZ(String str) {
        this.gkv = str;
    }

    /* loaded from: classes3.dex */
    private class a {
        ImageView eLu;
        BarImageView fhf;
        StringBuffer gmd;
        TextView gme;
        TextView gmf;
        ImageView gmg;
        TextView gmh;
        TextView gmi;
        TextView gmj;
        Button gmk;
        ImageView gml;
        ImageView gmm;
        TextView mName;

        private a() {
        }
    }
}
