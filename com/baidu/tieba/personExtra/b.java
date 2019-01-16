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
    private boolean eqF;
    private boolean gwJ;
    private String gwK;
    private PersonBarActivity gys;
    private boolean gyu;
    private View.OnClickListener gyv;
    private com.baidu.tieba.personExtra.a mData;
    private ArrayList<ForumData> mForumList = null;
    private boolean bBB = false;
    private View.OnClickListener gyt = null;
    private boolean fJy = false;

    public b(PersonBarActivity personBarActivity, com.baidu.tieba.personExtra.a aVar, boolean z, boolean z2) {
        this.mData = null;
        this.eqF = true;
        this.gwJ = false;
        this.gyu = true;
        this.gys = personBarActivity;
        this.mData = aVar;
        this.eqF = z;
        this.gwJ = z2;
        this.gyu = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void dt(boolean z) {
        this.bBB = z;
        notifyDataSetChanged();
    }

    public boolean Ws() {
        return this.bBB;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fJy) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void ben() {
        this.fJy = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.fJy = true;
        }
    }

    public boolean bqN() {
        return this.fJy;
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
                view3 = LayoutInflater.from(this.gys.getPageContext().getContext()).inflate(e.h.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.fwS = (BarImageView) view3.findViewById(e.g.forum_avatar);
                    aVar.fwS.setGifIconSupport(false);
                    aVar.mName = (TextView) view3.findViewById(e.g.name);
                    aVar.gyw = new StringBuffer(10);
                    aVar.gyx = (TextView) view3.findViewById(e.g.degree);
                    aVar.gyy = (TextView) view3.findViewById(e.g.degree_text);
                    aVar.gyC = (TextView) view3.findViewById(e.g.experience);
                    aVar.gyA = (TextView) view3.findViewById(e.g.experience_title);
                    aVar.gyD = (Button) view3.findViewById(e.g.item_delete);
                    aVar.gyz = (ImageView) view3.findViewById(e.g.degree_text_ta);
                    aVar.gyB = (TextView) view3.findViewById(e.g.intro_ta);
                    aVar.gyE = (ImageView) view3.findViewById(e.g.item_talk);
                    aVar.faQ = (ImageView) view3.findViewById(e.g.diver_buttom_px);
                    aVar.faQ.setVisibility(0);
                    aVar.gyF = (ImageView) view3.findViewById(e.g.item_selected);
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
            if (this.fJy) {
                aVar.gyx.setVisibility(8);
                aVar.gyD.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.fwS.setVisibility(8);
                aVar.gyy.setVisibility(8);
                aVar.gyC.setVisibility(8);
                aVar.gyA.setVisibility(8);
                aVar.gyz.setVisibility(8);
                aVar.gyB.setVisibility(8);
                aVar.gyE.setVisibility(8);
                aVar.faQ.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.fwS.setVisibility(0);
                if (this.eqF) {
                    aVar.gyx.setVisibility(8);
                    aVar.gyy.setVisibility(8);
                    aVar.gyC.setVisibility(0);
                    aVar.gyA.setVisibility(0);
                    aVar.gyz.setVisibility(0);
                    aVar.gyB.setVisibility(8);
                    aVar.faQ.setVisibility(0);
                } else {
                    aVar.gyx.setVisibility(8);
                    aVar.gyy.setVisibility(8);
                    aVar.gyC.setVisibility(8);
                    aVar.gyA.setVisibility(8);
                    aVar.gyz.setVisibility(0);
                    aVar.gyB.setVisibility(0);
                    aVar.faQ.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.fwS.setTag(image_url);
                aVar.fwS.setImageDrawable(null);
                aVar.fwS.startLoad(image_url, 10, false);
                aVar.gyw.delete(0, aVar.gyw.length());
                aVar.gyw.append(forumData.getName());
                aVar.gyw.append(this.gys.getPageContext().getString(e.j.forum));
                aVar.mName.setText(aVar.gyw);
                if (this.eqF) {
                    al.c(aVar.gyz, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.gyC.setText(String.format(this.gys.getPageContext().getString(e.j.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.gyD.setOnClickListener(this.gyt);
                    aVar.gyD.setTag(Integer.valueOf(i));
                    if (i < this.mData.bqC()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_v), (Drawable) null);
                        if (!this.gwJ && this.gyu) {
                            aVar.gyE.setVisibility(0);
                            aVar.gyE.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.gyE.setVisibility(8);
                    }
                    aVar.gyE.setOnClickListener(this.gyv);
                    aVar.gyF.setVisibility(8);
                    if (this.gwJ && this.gys.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.gwK)) {
                        aVar.gyF.setVisibility(0);
                    }
                } else {
                    if ((this.gys.aUN() == 0 && i < this.mData.bqC()) || (this.gys.aUN() == 1 && i < this.mData.bqD())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.gys.aUN() == 1) {
                        aVar.gyz.setVisibility(8);
                    }
                    aVar.gyE.setVisibility(8);
                    al.c(aVar.gyz, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.gyB.setText(forumData.getSlogan());
                }
                if (this.bBB) {
                    aVar.gyD.setVisibility(0);
                    aVar.gyE.setVisibility(8);
                } else {
                    aVar.gyD.setVisibility(8);
                    if (i < this.mData.bqC() && this.eqF && !this.gwJ && this.gyu) {
                        aVar.gyE.setVisibility(0);
                    } else {
                        aVar.gyE.setVisibility(8);
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
        this.gys.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gys.getLayoutMode().onModeChanged(view);
    }

    public void C(View.OnClickListener onClickListener) {
        this.gyt = onClickListener;
    }

    public void P(View.OnClickListener onClickListener) {
        this.gyv = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fJy) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void tZ(String str) {
        this.gwK = str;
    }

    /* loaded from: classes3.dex */
    private class a {
        ImageView faQ;
        BarImageView fwS;
        TextView gyA;
        TextView gyB;
        TextView gyC;
        Button gyD;
        ImageView gyE;
        ImageView gyF;
        StringBuffer gyw;
        TextView gyx;
        TextView gyy;
        ImageView gyz;
        TextView mName;

        private a() {
        }
    }
}
