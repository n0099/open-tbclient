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
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class b extends BaseAdapter {
    private boolean fDf;
    private boolean hMU;
    private String hMV;
    private PersonBarActivity hOr;
    private boolean hOt;
    private View.OnClickListener hOu;
    private com.baidu.tieba.personExtra.a mData;
    private ArrayList<ForumData> mForumList = null;
    private boolean cMG = false;
    private View.OnClickListener hOs = null;
    private boolean gZK = false;

    public b(PersonBarActivity personBarActivity, com.baidu.tieba.personExtra.a aVar, boolean z, boolean z2) {
        this.mData = null;
        this.fDf = true;
        this.hMU = false;
        this.hOt = true;
        this.hOr = personBarActivity;
        this.mData = aVar;
        this.fDf = z;
        this.hMU = z2;
        this.hOt = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void fJ(boolean z) {
        this.cMG = z;
        notifyDataSetChanged();
    }

    public boolean aws() {
        return this.cMG;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gZK) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void bEQ() {
        this.gZK = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.gZK = true;
        }
    }

    public boolean bRk() {
        return this.gZK;
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
                view3 = LayoutInflater.from(this.hOr.getPageContext().getContext()).inflate(d.h.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.gMW = (BarImageView) view3.findViewById(d.g.forum_avatar);
                    aVar.gMW.setGifIconSupport(false);
                    aVar.mName = (TextView) view3.findViewById(d.g.name);
                    aVar.hOv = new StringBuffer(10);
                    aVar.hOw = (TextView) view3.findViewById(d.g.degree);
                    aVar.hOx = (TextView) view3.findViewById(d.g.degree_text);
                    aVar.hOB = (TextView) view3.findViewById(d.g.experience);
                    aVar.hOz = (TextView) view3.findViewById(d.g.experience_title);
                    aVar.hOC = (Button) view3.findViewById(d.g.item_delete);
                    aVar.hOy = (ImageView) view3.findViewById(d.g.degree_text_ta);
                    aVar.hOA = (TextView) view3.findViewById(d.g.intro_ta);
                    aVar.hOD = (ImageView) view3.findViewById(d.g.item_talk);
                    aVar.gqX = (ImageView) view3.findViewById(d.g.diver_buttom_px);
                    aVar.gqX.setVisibility(0);
                    aVar.hOE = (ImageView) view3.findViewById(d.g.item_selected);
                    view3.setTag(aVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    BdLog.e(exc.getMessage());
                    bP(view2);
                    return view2;
                }
            } else {
                aVar = (a) view.getTag();
                view3 = view;
            }
            if (this.gZK) {
                aVar.hOw.setVisibility(8);
                aVar.hOC.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.gMW.setVisibility(8);
                aVar.hOx.setVisibility(8);
                aVar.hOB.setVisibility(8);
                aVar.hOz.setVisibility(8);
                aVar.hOy.setVisibility(8);
                aVar.hOA.setVisibility(8);
                aVar.hOD.setVisibility(8);
                aVar.gqX.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.gMW.setVisibility(0);
                if (this.fDf) {
                    aVar.hOw.setVisibility(8);
                    aVar.hOx.setVisibility(8);
                    aVar.hOB.setVisibility(0);
                    aVar.hOz.setVisibility(0);
                    aVar.hOy.setVisibility(0);
                    aVar.hOA.setVisibility(8);
                    aVar.gqX.setVisibility(0);
                } else {
                    aVar.hOw.setVisibility(8);
                    aVar.hOx.setVisibility(8);
                    aVar.hOB.setVisibility(8);
                    aVar.hOz.setVisibility(8);
                    aVar.hOy.setVisibility(0);
                    aVar.hOA.setVisibility(0);
                    aVar.gqX.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.gMW.setTag(image_url);
                aVar.gMW.setImageDrawable(null);
                aVar.gMW.startLoad(image_url, 10, false);
                aVar.hOv.delete(0, aVar.hOv.length());
                aVar.hOv.append(forumData.getName());
                aVar.hOv.append(this.hOr.getPageContext().getString(d.j.forum));
                aVar.mName.setText(aVar.hOv);
                if (this.fDf) {
                    al.c(aVar.hOy, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.hOB.setText(String.format(this.hOr.getPageContext().getString(d.j.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.hOC.setOnClickListener(this.hOs);
                    aVar.hOC.setTag(Integer.valueOf(i));
                    if (i < this.mData.bQZ()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_v), (Drawable) null);
                        if (!this.hMU && this.hOt) {
                            aVar.hOD.setVisibility(0);
                            aVar.hOD.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.hOD.setVisibility(8);
                    }
                    aVar.hOD.setOnClickListener(this.hOu);
                    aVar.hOE.setVisibility(8);
                    if (this.hMU && this.hOr.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.hMV)) {
                        aVar.hOE.setVisibility(0);
                    }
                } else {
                    if ((this.hOr.bvs() == 0 && i < this.mData.bQZ()) || (this.hOr.bvs() == 1 && i < this.mData.bRa())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.hOr.bvs() == 1) {
                        aVar.hOy.setVisibility(8);
                    }
                    aVar.hOD.setVisibility(8);
                    al.c(aVar.hOy, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.hOA.setText(forumData.getSlogan());
                }
                if (this.cMG) {
                    aVar.hOC.setVisibility(0);
                    aVar.hOD.setVisibility(8);
                } else {
                    aVar.hOC.setVisibility(8);
                    if (i < this.mData.bQZ() && this.fDf && !this.hMU && this.hOt) {
                        aVar.hOD.setVisibility(0);
                    } else {
                        aVar.hOD.setVisibility(8);
                    }
                }
            }
            view2 = view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
        bP(view2);
        return view2;
    }

    private void bP(View view) {
        this.hOr.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.hOr.getLayoutMode().onModeChanged(view);
    }

    public void D(View.OnClickListener onClickListener) {
        this.hOs = onClickListener;
    }

    public void P(View.OnClickListener onClickListener) {
        this.hOu = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.gZK) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void AE(String str) {
        this.hMV = str;
    }

    /* loaded from: classes6.dex */
    private class a {
        BarImageView gMW;
        ImageView gqX;
        TextView hOA;
        TextView hOB;
        Button hOC;
        ImageView hOD;
        ImageView hOE;
        StringBuffer hOv;
        TextView hOw;
        TextView hOx;
        ImageView hOy;
        TextView hOz;
        TextView mName;

        private a() {
        }
    }
}
