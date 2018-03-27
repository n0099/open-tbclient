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
    private boolean ecO;
    private String gkA;
    private boolean gkz;
    private PersonBarActivity gme;
    private boolean gmg;
    private View.OnClickListener gmh;
    private c mData;
    private ArrayList<ForumData> mForumList = null;
    private boolean bSk = false;
    private View.OnClickListener gmf = null;
    private boolean fxs = false;

    public e(PersonBarActivity personBarActivity, c cVar, boolean z, boolean z2) {
        this.mData = null;
        this.ecO = true;
        this.gkz = false;
        this.gmg = true;
        this.gme = personBarActivity;
        this.mData = cVar;
        this.ecO = z;
        this.gkz = z2;
        this.gmg = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void cX(boolean z) {
        this.bSk = z;
        notifyDataSetChanged();
    }

    public boolean Uo() {
        return this.bSk;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fxs) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void aXv() {
        this.fxs = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.fxs = true;
        }
    }

    public boolean bjv() {
        return this.fxs;
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
                view3 = LayoutInflater.from(this.gme.getPageContext().getContext()).inflate(d.h.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.fhh = (BarImageView) view3.findViewById(d.g.forum_avatar);
                    aVar.fhh.setGifIconSupport(false);
                    aVar.mName = (TextView) view3.findViewById(d.g.name);
                    aVar.gmi = new StringBuffer(10);
                    aVar.gmj = (TextView) view3.findViewById(d.g.degree);
                    aVar.gmk = (TextView) view3.findViewById(d.g.degree_text);
                    aVar.gmo = (TextView) view3.findViewById(d.g.experience);
                    aVar.gmm = (TextView) view3.findViewById(d.g.experience_title);
                    aVar.gmp = (Button) view3.findViewById(d.g.item_delete);
                    aVar.gml = (ImageView) view3.findViewById(d.g.degree_text_ta);
                    aVar.gmn = (TextView) view3.findViewById(d.g.intro_ta);
                    aVar.gmq = (ImageView) view3.findViewById(d.g.item_talk);
                    aVar.eLy = (ImageView) view3.findViewById(d.g.diver_buttom_px);
                    aVar.eLy.setVisibility(0);
                    aVar.gmr = (ImageView) view3.findViewById(d.g.item_selected);
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
            if (this.fxs) {
                aVar.gmj.setVisibility(8);
                aVar.gmp.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.fhh.setVisibility(8);
                aVar.gmk.setVisibility(8);
                aVar.gmo.setVisibility(8);
                aVar.gmm.setVisibility(8);
                aVar.gml.setVisibility(8);
                aVar.gmn.setVisibility(8);
                aVar.gmq.setVisibility(8);
                aVar.eLy.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.fhh.setVisibility(0);
                if (this.ecO) {
                    aVar.gmj.setVisibility(8);
                    aVar.gmk.setVisibility(8);
                    aVar.gmo.setVisibility(0);
                    aVar.gmm.setVisibility(0);
                    aVar.gml.setVisibility(0);
                    aVar.gmn.setVisibility(8);
                    aVar.eLy.setVisibility(0);
                } else {
                    aVar.gmj.setVisibility(8);
                    aVar.gmk.setVisibility(8);
                    aVar.gmo.setVisibility(8);
                    aVar.gmm.setVisibility(8);
                    aVar.gml.setVisibility(0);
                    aVar.gmn.setVisibility(0);
                    aVar.eLy.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.fhh.setTag(image_url);
                aVar.fhh.setImageDrawable(null);
                aVar.fhh.startLoad(image_url, 10, false);
                aVar.gmi.delete(0, aVar.gmi.length());
                aVar.gmi.append(forumData.getName());
                aVar.gmi.append(this.gme.getPageContext().getString(d.j.forum));
                aVar.mName.setText(aVar.gmi);
                if (this.ecO) {
                    aj.c(aVar.gml, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.gmo.setText(String.format(this.gme.getPageContext().getString(d.j.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.gmp.setOnClickListener(this.gmf);
                    aVar.gmp.setTag(Integer.valueOf(i));
                    if (i < this.mData.bjk()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_v), (Drawable) null);
                        if (!this.gkz && this.gmg) {
                            aVar.gmq.setVisibility(0);
                            aVar.gmq.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.gmq.setVisibility(8);
                    }
                    aVar.gmq.setOnClickListener(this.gmh);
                    aVar.gmr.setVisibility(8);
                    if (this.gkz && this.gme.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.gkA)) {
                        aVar.gmr.setVisibility(0);
                    }
                } else {
                    if ((this.gme.aLo() == 0 && i < this.mData.bjk()) || (this.gme.aLo() == 1 && i < this.mData.bjl())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.gme.aLo() == 1) {
                        aVar.gml.setVisibility(8);
                    }
                    aVar.gmq.setVisibility(8);
                    aj.c(aVar.gml, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.gmn.setText(forumData.getSlogan());
                }
                if (this.bSk) {
                    aVar.gmp.setVisibility(0);
                    aVar.gmq.setVisibility(8);
                } else {
                    aVar.gmp.setVisibility(8);
                    if (i < this.mData.bjk() && this.ecO && !this.gkz && this.gmg) {
                        aVar.gmq.setVisibility(0);
                    } else {
                        aVar.gmq.setVisibility(8);
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
        this.gme.getLayoutMode().aQ(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gme.getLayoutMode().aM(view);
    }

    public void y(View.OnClickListener onClickListener) {
        this.gmf = onClickListener;
    }

    public void L(View.OnClickListener onClickListener) {
        this.gmh = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fxs) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void qZ(String str) {
        this.gkA = str;
    }

    /* loaded from: classes3.dex */
    private class a {
        ImageView eLy;
        BarImageView fhh;
        StringBuffer gmi;
        TextView gmj;
        TextView gmk;
        ImageView gml;
        TextView gmm;
        TextView gmn;
        TextView gmo;
        Button gmp;
        ImageView gmq;
        ImageView gmr;
        TextView mName;

        private a() {
        }
    }
}
