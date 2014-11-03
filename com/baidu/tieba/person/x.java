package com.baidu.tieba.person;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.view.BarImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class x extends BaseAdapter {
    private PersonBarActivity bBQ;
    private View.OnClickListener bBT;
    private boolean bBb;
    private boolean bpa;
    private n mData;
    private ArrayList<ForumData> bBR = null;
    private boolean aeD = false;
    private View.OnClickListener bBS = null;
    private boolean bBq = false;

    public x(PersonBarActivity personBarActivity, n nVar, boolean z, boolean z2) {
        this.mData = null;
        this.bpa = true;
        this.bBb = false;
        this.bBQ = personBarActivity;
        this.mData = nVar;
        this.bpa = z;
        this.bBb = z2;
    }

    public void F(ArrayList<ForumData> arrayList) {
        this.bBR = arrayList;
    }

    public void setEditState(boolean z) {
        this.aeD = z;
        notifyDataSetChanged();
    }

    public boolean xf() {
        return this.aeD;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bBq) {
            return 1;
        }
        if (this.bBR != null) {
            return this.bBR.size();
        }
        return 0;
    }

    public void ZI() {
        this.bBq = false;
        if (this.bBR == null || this.bBR.size() == 0) {
            this.bBq = true;
        }
    }

    public boolean ZR() {
        return this.bBq;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bBR == null || i < 0 || i >= this.bBR.size()) {
            return null;
        }
        return this.bBR.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        y yVar;
        View view3;
        ForumData forumData;
        try {
            if (view == null) {
                view3 = com.baidu.adp.lib.g.b.ek().inflate(this.bBQ, com.baidu.tieba.w.edit_bar_item, null);
                try {
                    yVar = new y(this, null);
                    yVar.awf = (BarImageView) view3.findViewById(com.baidu.tieba.v.forum_avatar);
                    yVar.awf.setGifIconSupport(false);
                    yVar.awi = (TextView) view3.findViewById(com.baidu.tieba.v.name);
                    yVar.bBU = new StringBuffer(10);
                    yVar.bBV = (TextView) view3.findViewById(com.baidu.tieba.v.degree);
                    yVar.bBW = (TextView) view3.findViewById(com.baidu.tieba.v.degree_text);
                    yVar.bCa = (TextView) view3.findViewById(com.baidu.tieba.v.experience);
                    yVar.bBY = (TextView) view3.findViewById(com.baidu.tieba.v.experience_title);
                    yVar.bCb = (Button) view3.findViewById(com.baidu.tieba.v.item_delete);
                    yVar.bBX = (TextView) view3.findViewById(com.baidu.tieba.v.degree_text_ta);
                    yVar.bBZ = (TextView) view3.findViewById(com.baidu.tieba.v.intro_ta);
                    yVar.bCc = (ImageView) view3.findViewById(com.baidu.tieba.v.item_talk);
                    yVar.bgc = (ImageView) view3.findViewById(com.baidu.tieba.v.diver_buttom_px);
                    yVar.bgc.setVisibility(0);
                    view3.setTag(yVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    BdLog.e(exc.getMessage());
                    F(view2);
                    return view2;
                }
            } else {
                yVar = (y) view.getTag();
                view3 = view;
            }
            if (this.bBq) {
                yVar.bBV.setVisibility(8);
                yVar.bCb.setVisibility(8);
                yVar.awi.setVisibility(8);
                yVar.awf.setVisibility(8);
                yVar.bBW.setVisibility(8);
                yVar.bCa.setVisibility(8);
                yVar.bBY.setVisibility(8);
                yVar.bBX.setVisibility(8);
                yVar.bBZ.setVisibility(8);
                yVar.bCc.setVisibility(8);
                yVar.bgc.setVisibility(8);
            } else {
                yVar.awi.setVisibility(0);
                yVar.awf.setVisibility(0);
                if (this.bpa) {
                    yVar.bBV.setVisibility(8);
                    yVar.bBW.setVisibility(8);
                    yVar.bCa.setVisibility(0);
                    yVar.bBY.setVisibility(0);
                    yVar.bBX.setVisibility(0);
                    yVar.bBZ.setVisibility(8);
                    yVar.bgc.setVisibility(0);
                } else {
                    yVar.bBV.setVisibility(8);
                    yVar.bBW.setVisibility(8);
                    yVar.bCa.setVisibility(8);
                    yVar.bBY.setVisibility(8);
                    yVar.bBX.setVisibility(0);
                    yVar.bBZ.setVisibility(0);
                    yVar.bgc.setVisibility(0);
                }
            }
            if (this.bBR == null || i < 0 || i >= this.bBR.size() || (forumData = this.bBR.get(i)) == null) {
                view2 = view3;
            } else {
                String image_url = forumData.getImage_url();
                yVar.awf.setTag(image_url);
                yVar.awf.setImageDrawable(null);
                yVar.awf.c(image_url, 10, false);
                yVar.bBU.delete(0, yVar.bBU.length());
                yVar.bBU.append(forumData.getName());
                yVar.bBU.append(this.bBQ.getString(com.baidu.tieba.y.bar));
                yVar.awi.setText(yVar.bBU);
                if (this.bpa) {
                    com.baidu.tbadk.core.util.aw.h((View) yVar.bBX, com.baidu.tbadk.core.util.d.bn(forumData.getUser_level()));
                    yVar.bBX.setText(String.valueOf(forumData.getUser_level()));
                    yVar.bCa.setText(String.format(this.bBQ.getString(com.baidu.tieba.y.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    yVar.bCb.setOnClickListener(this.bBS);
                    yVar.bCb.setTag(Integer.valueOf(i));
                    if (i < this.mData.ZK()) {
                        yVar.awi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.icon_v), (Drawable) null);
                        if (!this.bBb) {
                            yVar.bCc.setVisibility(0);
                            yVar.bCc.setTag(Integer.valueOf(i));
                        }
                    } else {
                        yVar.awi.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        yVar.bCc.setVisibility(8);
                    }
                    yVar.bCc.setOnClickListener(this.bBT);
                } else {
                    if ((this.bBQ.QU() == 0 && i < this.mData.ZK()) || (this.bBQ.QU() == 1 && i < this.mData.ZL())) {
                        yVar.awi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.icon_v), (Drawable) null);
                    } else {
                        yVar.awi.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.bBQ.QU() == 1) {
                        yVar.bBX.setVisibility(8);
                    }
                    yVar.bCc.setVisibility(8);
                    com.baidu.tbadk.core.util.aw.h((View) yVar.bBX, com.baidu.tbadk.core.util.d.bn(forumData.getUser_level()));
                    yVar.bBX.setText(String.valueOf(forumData.getUser_level()));
                    yVar.bBZ.setText(forumData.getSlogan());
                }
                if (this.aeD) {
                    yVar.bCb.setVisibility(0);
                    yVar.bCc.setVisibility(8);
                    view2 = view3;
                } else {
                    yVar.bCb.setVisibility(8);
                    if (i < this.mData.ZK() && this.bpa && !this.bBb) {
                        yVar.bCc.setVisibility(0);
                        view2 = view3;
                    } else {
                        yVar.bCc.setVisibility(8);
                        view2 = view3;
                    }
                }
            }
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
        F(view2);
        return view2;
    }

    private void F(View view) {
        this.bBQ.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
        this.bBQ.getLayoutMode().h(view);
    }

    public void w(View.OnClickListener onClickListener) {
        this.bBS = onClickListener;
    }

    public void x(View.OnClickListener onClickListener) {
        this.bBT = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.bBq) {
            return false;
        }
        return super.isEnabled(i);
    }
}
