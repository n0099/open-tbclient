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
    private boolean eqG;
    private boolean gwK;
    private String gwL;
    private PersonBarActivity gyt;
    private boolean gyv;
    private View.OnClickListener gyw;
    private com.baidu.tieba.personExtra.a mData;
    private ArrayList<ForumData> mForumList = null;
    private boolean bBC = false;
    private View.OnClickListener gyu = null;
    private boolean fJz = false;

    public b(PersonBarActivity personBarActivity, com.baidu.tieba.personExtra.a aVar, boolean z, boolean z2) {
        this.mData = null;
        this.eqG = true;
        this.gwK = false;
        this.gyv = true;
        this.gyt = personBarActivity;
        this.mData = aVar;
        this.eqG = z;
        this.gwK = z2;
        this.gyv = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void dt(boolean z) {
        this.bBC = z;
        notifyDataSetChanged();
    }

    public boolean Ws() {
        return this.bBC;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fJz) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void ben() {
        this.fJz = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.fJz = true;
        }
    }

    public boolean bqN() {
        return this.fJz;
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
                view3 = LayoutInflater.from(this.gyt.getPageContext().getContext()).inflate(e.h.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.fwT = (BarImageView) view3.findViewById(e.g.forum_avatar);
                    aVar.fwT.setGifIconSupport(false);
                    aVar.mName = (TextView) view3.findViewById(e.g.name);
                    aVar.gyx = new StringBuffer(10);
                    aVar.gyy = (TextView) view3.findViewById(e.g.degree);
                    aVar.gyz = (TextView) view3.findViewById(e.g.degree_text);
                    aVar.gyD = (TextView) view3.findViewById(e.g.experience);
                    aVar.gyB = (TextView) view3.findViewById(e.g.experience_title);
                    aVar.gyE = (Button) view3.findViewById(e.g.item_delete);
                    aVar.gyA = (ImageView) view3.findViewById(e.g.degree_text_ta);
                    aVar.gyC = (TextView) view3.findViewById(e.g.intro_ta);
                    aVar.gyF = (ImageView) view3.findViewById(e.g.item_talk);
                    aVar.faR = (ImageView) view3.findViewById(e.g.diver_buttom_px);
                    aVar.faR.setVisibility(0);
                    aVar.gyG = (ImageView) view3.findViewById(e.g.item_selected);
                    view3.setTag(aVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    BdLog.e(exc.getMessage());
                    bb(view2);
                    return view2;
                }
            } else {
                aVar = (a) view.getTag();
                view3 = view;
            }
            if (this.fJz) {
                aVar.gyy.setVisibility(8);
                aVar.gyE.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.fwT.setVisibility(8);
                aVar.gyz.setVisibility(8);
                aVar.gyD.setVisibility(8);
                aVar.gyB.setVisibility(8);
                aVar.gyA.setVisibility(8);
                aVar.gyC.setVisibility(8);
                aVar.gyF.setVisibility(8);
                aVar.faR.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.fwT.setVisibility(0);
                if (this.eqG) {
                    aVar.gyy.setVisibility(8);
                    aVar.gyz.setVisibility(8);
                    aVar.gyD.setVisibility(0);
                    aVar.gyB.setVisibility(0);
                    aVar.gyA.setVisibility(0);
                    aVar.gyC.setVisibility(8);
                    aVar.faR.setVisibility(0);
                } else {
                    aVar.gyy.setVisibility(8);
                    aVar.gyz.setVisibility(8);
                    aVar.gyD.setVisibility(8);
                    aVar.gyB.setVisibility(8);
                    aVar.gyA.setVisibility(0);
                    aVar.gyC.setVisibility(0);
                    aVar.faR.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.fwT.setTag(image_url);
                aVar.fwT.setImageDrawable(null);
                aVar.fwT.startLoad(image_url, 10, false);
                aVar.gyx.delete(0, aVar.gyx.length());
                aVar.gyx.append(forumData.getName());
                aVar.gyx.append(this.gyt.getPageContext().getString(e.j.forum));
                aVar.mName.setText(aVar.gyx);
                if (this.eqG) {
                    al.c(aVar.gyA, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.gyD.setText(String.format(this.gyt.getPageContext().getString(e.j.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.gyE.setOnClickListener(this.gyu);
                    aVar.gyE.setTag(Integer.valueOf(i));
                    if (i < this.mData.bqC()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_v), (Drawable) null);
                        if (!this.gwK && this.gyv) {
                            aVar.gyF.setVisibility(0);
                            aVar.gyF.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.gyF.setVisibility(8);
                    }
                    aVar.gyF.setOnClickListener(this.gyw);
                    aVar.gyG.setVisibility(8);
                    if (this.gwK && this.gyt.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.gwL)) {
                        aVar.gyG.setVisibility(0);
                    }
                } else {
                    if ((this.gyt.aUN() == 0 && i < this.mData.bqC()) || (this.gyt.aUN() == 1 && i < this.mData.bqD())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.gyt.aUN() == 1) {
                        aVar.gyA.setVisibility(8);
                    }
                    aVar.gyF.setVisibility(8);
                    al.c(aVar.gyA, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.gyC.setText(forumData.getSlogan());
                }
                if (this.bBC) {
                    aVar.gyE.setVisibility(0);
                    aVar.gyF.setVisibility(8);
                } else {
                    aVar.gyE.setVisibility(8);
                    if (i < this.mData.bqC() && this.eqG && !this.gwK && this.gyv) {
                        aVar.gyF.setVisibility(0);
                    } else {
                        aVar.gyF.setVisibility(8);
                    }
                }
            }
            view2 = view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
        bb(view2);
        return view2;
    }

    private void bb(View view) {
        this.gyt.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gyt.getLayoutMode().onModeChanged(view);
    }

    public void C(View.OnClickListener onClickListener) {
        this.gyu = onClickListener;
    }

    public void P(View.OnClickListener onClickListener) {
        this.gyw = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fJz) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void tZ(String str) {
        this.gwL = str;
    }

    /* loaded from: classes3.dex */
    private class a {
        ImageView faR;
        BarImageView fwT;
        ImageView gyA;
        TextView gyB;
        TextView gyC;
        TextView gyD;
        Button gyE;
        ImageView gyF;
        ImageView gyG;
        StringBuffer gyx;
        TextView gyy;
        TextView gyz;
        TextView mName;

        private a() {
        }
    }
}
