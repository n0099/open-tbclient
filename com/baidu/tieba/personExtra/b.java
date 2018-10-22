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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private boolean eeV;
    private String gkA;
    private boolean gkz;
    private PersonBarActivity gmi;
    private boolean gmk;
    private View.OnClickListener gml;
    private com.baidu.tieba.personExtra.a mData;
    private ArrayList<ForumData> mForumList = null;
    private boolean bwD = false;
    private View.OnClickListener gmj = null;
    private boolean fxz = false;

    public b(PersonBarActivity personBarActivity, com.baidu.tieba.personExtra.a aVar, boolean z, boolean z2) {
        this.mData = null;
        this.eeV = true;
        this.gkz = false;
        this.gmk = true;
        this.gmi = personBarActivity;
        this.mData = aVar;
        this.eeV = z;
        this.gkz = z2;
        this.gmk = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void cY(boolean z) {
        this.bwD = z;
        notifyDataSetChanged();
    }

    public boolean UF() {
        return this.bwD;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fxz) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void bbK() {
        this.fxz = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.fxz = true;
        }
    }

    public boolean bof() {
        return this.fxz;
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
                view3 = LayoutInflater.from(this.gmi.getPageContext().getContext()).inflate(e.h.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.fkX = (BarImageView) view3.findViewById(e.g.forum_avatar);
                    aVar.fkX.setGifIconSupport(false);
                    aVar.mName = (TextView) view3.findViewById(e.g.name);
                    aVar.gmm = new StringBuffer(10);
                    aVar.gmn = (TextView) view3.findViewById(e.g.degree);
                    aVar.gmo = (TextView) view3.findViewById(e.g.degree_text);
                    aVar.gms = (TextView) view3.findViewById(e.g.experience);
                    aVar.gmq = (TextView) view3.findViewById(e.g.experience_title);
                    aVar.gmt = (Button) view3.findViewById(e.g.item_delete);
                    aVar.gmp = (ImageView) view3.findViewById(e.g.degree_text_ta);
                    aVar.gmr = (TextView) view3.findViewById(e.g.intro_ta);
                    aVar.gmu = (ImageView) view3.findViewById(e.g.item_talk);
                    aVar.ePf = (ImageView) view3.findViewById(e.g.diver_buttom_px);
                    aVar.ePf.setVisibility(0);
                    aVar.gmv = (ImageView) view3.findViewById(e.g.item_selected);
                    view3.setTag(aVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    BdLog.e(exc.getMessage());
                    aW(view2);
                    return view2;
                }
            } else {
                aVar = (a) view.getTag();
                view3 = view;
            }
            if (this.fxz) {
                aVar.gmn.setVisibility(8);
                aVar.gmt.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.fkX.setVisibility(8);
                aVar.gmo.setVisibility(8);
                aVar.gms.setVisibility(8);
                aVar.gmq.setVisibility(8);
                aVar.gmp.setVisibility(8);
                aVar.gmr.setVisibility(8);
                aVar.gmu.setVisibility(8);
                aVar.ePf.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.fkX.setVisibility(0);
                if (this.eeV) {
                    aVar.gmn.setVisibility(8);
                    aVar.gmo.setVisibility(8);
                    aVar.gms.setVisibility(0);
                    aVar.gmq.setVisibility(0);
                    aVar.gmp.setVisibility(0);
                    aVar.gmr.setVisibility(8);
                    aVar.ePf.setVisibility(0);
                } else {
                    aVar.gmn.setVisibility(8);
                    aVar.gmo.setVisibility(8);
                    aVar.gms.setVisibility(8);
                    aVar.gmq.setVisibility(8);
                    aVar.gmp.setVisibility(0);
                    aVar.gmr.setVisibility(0);
                    aVar.ePf.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.fkX.setTag(image_url);
                aVar.fkX.setImageDrawable(null);
                aVar.fkX.startLoad(image_url, 10, false);
                aVar.gmm.delete(0, aVar.gmm.length());
                aVar.gmm.append(forumData.getName());
                aVar.gmm.append(this.gmi.getPageContext().getString(e.j.forum));
                aVar.mName.setText(aVar.gmm);
                if (this.eeV) {
                    al.c(aVar.gmp, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.gms.setText(String.format(this.gmi.getPageContext().getString(e.j.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.gmt.setOnClickListener(this.gmj);
                    aVar.gmt.setTag(Integer.valueOf(i));
                    if (i < this.mData.bnU()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_v), (Drawable) null);
                        if (!this.gkz && this.gmk) {
                            aVar.gmu.setVisibility(0);
                            aVar.gmu.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.gmu.setVisibility(8);
                    }
                    aVar.gmu.setOnClickListener(this.gml);
                    aVar.gmv.setVisibility(8);
                    if (this.gkz && this.gmi.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.gkA)) {
                        aVar.gmv.setVisibility(0);
                    }
                } else {
                    if ((this.gmi.aSl() == 0 && i < this.mData.bnU()) || (this.gmi.aSl() == 1 && i < this.mData.bnV())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.gmi.aSl() == 1) {
                        aVar.gmp.setVisibility(8);
                    }
                    aVar.gmu.setVisibility(8);
                    al.c(aVar.gmp, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.gmr.setText(forumData.getSlogan());
                }
                if (this.bwD) {
                    aVar.gmt.setVisibility(0);
                    aVar.gmu.setVisibility(8);
                } else {
                    aVar.gmt.setVisibility(8);
                    if (i < this.mData.bnU() && this.eeV && !this.gkz && this.gmk) {
                        aVar.gmu.setVisibility(0);
                    } else {
                        aVar.gmu.setVisibility(8);
                    }
                }
            }
            view2 = view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
        aW(view2);
        return view2;
    }

    private void aW(View view) {
        this.gmi.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gmi.getLayoutMode().onModeChanged(view);
    }

    public void A(View.OnClickListener onClickListener) {
        this.gmj = onClickListener;
    }

    public void N(View.OnClickListener onClickListener) {
        this.gml = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fxz) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void tb(String str) {
        this.gkA = str;
    }

    /* loaded from: classes3.dex */
    private class a {
        ImageView ePf;
        BarImageView fkX;
        StringBuffer gmm;
        TextView gmn;
        TextView gmo;
        ImageView gmp;
        TextView gmq;
        TextView gmr;
        TextView gms;
        Button gmt;
        ImageView gmu;
        ImageView gmv;
        TextView mName;

        private a() {
        }
    }
}
