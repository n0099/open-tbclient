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
    private boolean eeU;
    private boolean gky;
    private String gkz;
    private PersonBarActivity gmh;
    private boolean gmj;
    private View.OnClickListener gmk;
    private com.baidu.tieba.personExtra.a mData;
    private ArrayList<ForumData> mForumList = null;
    private boolean bwD = false;
    private View.OnClickListener gmi = null;
    private boolean fxy = false;

    public b(PersonBarActivity personBarActivity, com.baidu.tieba.personExtra.a aVar, boolean z, boolean z2) {
        this.mData = null;
        this.eeU = true;
        this.gky = false;
        this.gmj = true;
        this.gmh = personBarActivity;
        this.mData = aVar;
        this.eeU = z;
        this.gky = z2;
        this.gmj = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
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
        if (this.fxy) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void bbK() {
        this.fxy = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.fxy = true;
        }
    }

    public boolean bof() {
        return this.fxy;
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
                view3 = LayoutInflater.from(this.gmh.getPageContext().getContext()).inflate(e.h.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.fkW = (BarImageView) view3.findViewById(e.g.forum_avatar);
                    aVar.fkW.setGifIconSupport(false);
                    aVar.mName = (TextView) view3.findViewById(e.g.name);
                    aVar.gml = new StringBuffer(10);
                    aVar.gmm = (TextView) view3.findViewById(e.g.degree);
                    aVar.gmn = (TextView) view3.findViewById(e.g.degree_text);
                    aVar.gmr = (TextView) view3.findViewById(e.g.experience);
                    aVar.gmp = (TextView) view3.findViewById(e.g.experience_title);
                    aVar.gms = (Button) view3.findViewById(e.g.item_delete);
                    aVar.gmo = (ImageView) view3.findViewById(e.g.degree_text_ta);
                    aVar.gmq = (TextView) view3.findViewById(e.g.intro_ta);
                    aVar.gmt = (ImageView) view3.findViewById(e.g.item_talk);
                    aVar.ePe = (ImageView) view3.findViewById(e.g.diver_buttom_px);
                    aVar.ePe.setVisibility(0);
                    aVar.gmu = (ImageView) view3.findViewById(e.g.item_selected);
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
            if (this.fxy) {
                aVar.gmm.setVisibility(8);
                aVar.gms.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.fkW.setVisibility(8);
                aVar.gmn.setVisibility(8);
                aVar.gmr.setVisibility(8);
                aVar.gmp.setVisibility(8);
                aVar.gmo.setVisibility(8);
                aVar.gmq.setVisibility(8);
                aVar.gmt.setVisibility(8);
                aVar.ePe.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.fkW.setVisibility(0);
                if (this.eeU) {
                    aVar.gmm.setVisibility(8);
                    aVar.gmn.setVisibility(8);
                    aVar.gmr.setVisibility(0);
                    aVar.gmp.setVisibility(0);
                    aVar.gmo.setVisibility(0);
                    aVar.gmq.setVisibility(8);
                    aVar.ePe.setVisibility(0);
                } else {
                    aVar.gmm.setVisibility(8);
                    aVar.gmn.setVisibility(8);
                    aVar.gmr.setVisibility(8);
                    aVar.gmp.setVisibility(8);
                    aVar.gmo.setVisibility(0);
                    aVar.gmq.setVisibility(0);
                    aVar.ePe.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.fkW.setTag(image_url);
                aVar.fkW.setImageDrawable(null);
                aVar.fkW.startLoad(image_url, 10, false);
                aVar.gml.delete(0, aVar.gml.length());
                aVar.gml.append(forumData.getName());
                aVar.gml.append(this.gmh.getPageContext().getString(e.j.forum));
                aVar.mName.setText(aVar.gml);
                if (this.eeU) {
                    al.c(aVar.gmo, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.gmr.setText(String.format(this.gmh.getPageContext().getString(e.j.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.gms.setOnClickListener(this.gmi);
                    aVar.gms.setTag(Integer.valueOf(i));
                    if (i < this.mData.bnU()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_v), (Drawable) null);
                        if (!this.gky && this.gmj) {
                            aVar.gmt.setVisibility(0);
                            aVar.gmt.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.gmt.setVisibility(8);
                    }
                    aVar.gmt.setOnClickListener(this.gmk);
                    aVar.gmu.setVisibility(8);
                    if (this.gky && this.gmh.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.gkz)) {
                        aVar.gmu.setVisibility(0);
                    }
                } else {
                    if ((this.gmh.aSl() == 0 && i < this.mData.bnU()) || (this.gmh.aSl() == 1 && i < this.mData.bnV())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.gmh.aSl() == 1) {
                        aVar.gmo.setVisibility(8);
                    }
                    aVar.gmt.setVisibility(8);
                    al.c(aVar.gmo, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.gmq.setText(forumData.getSlogan());
                }
                if (this.bwD) {
                    aVar.gms.setVisibility(0);
                    aVar.gmt.setVisibility(8);
                } else {
                    aVar.gms.setVisibility(8);
                    if (i < this.mData.bnU() && this.eeU && !this.gky && this.gmj) {
                        aVar.gmt.setVisibility(0);
                    } else {
                        aVar.gmt.setVisibility(8);
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
        this.gmh.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gmh.getLayoutMode().onModeChanged(view);
    }

    public void A(View.OnClickListener onClickListener) {
        this.gmi = onClickListener;
    }

    public void N(View.OnClickListener onClickListener) {
        this.gmk = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fxy) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void tb(String str) {
        this.gkz = str;
    }

    /* loaded from: classes3.dex */
    private class a {
        ImageView ePe;
        BarImageView fkW;
        StringBuffer gml;
        TextView gmm;
        TextView gmn;
        ImageView gmo;
        TextView gmp;
        TextView gmq;
        TextView gmr;
        Button gms;
        ImageView gmt;
        ImageView gmu;
        TextView mName;

        private a() {
        }
    }
}
