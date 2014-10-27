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
    private boolean bAN;
    private PersonBarActivity bBC;
    private View.OnClickListener bBF;
    private boolean boM;
    private n mData;
    private ArrayList<ForumData> bBD = null;
    private boolean aev = false;
    private View.OnClickListener bBE = null;
    private boolean bBc = false;

    public x(PersonBarActivity personBarActivity, n nVar, boolean z, boolean z2) {
        this.mData = null;
        this.boM = true;
        this.bAN = false;
        this.bBC = personBarActivity;
        this.mData = nVar;
        this.boM = z;
        this.bAN = z2;
    }

    public void E(ArrayList<ForumData> arrayList) {
        this.bBD = arrayList;
    }

    public void setEditState(boolean z) {
        this.aev = z;
        notifyDataSetChanged();
    }

    public boolean xd() {
        return this.aev;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bBc) {
            return 1;
        }
        if (this.bBD != null) {
            return this.bBD.size();
        }
        return 0;
    }

    public void ZG() {
        this.bBc = false;
        if (this.bBD == null || this.bBD.size() == 0) {
            this.bBc = true;
        }
    }

    public boolean ZP() {
        return this.bBc;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bBD == null || i < 0 || i >= this.bBD.size()) {
            return null;
        }
        return this.bBD.get(i);
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
                view3 = com.baidu.adp.lib.g.b.ek().inflate(this.bBC, com.baidu.tieba.w.edit_bar_item, null);
                try {
                    yVar = new y(this, null);
                    yVar.avW = (BarImageView) view3.findViewById(com.baidu.tieba.v.forum_avatar);
                    yVar.avW.setGifIconSupport(false);
                    yVar.avZ = (TextView) view3.findViewById(com.baidu.tieba.v.name);
                    yVar.bBG = new StringBuffer(10);
                    yVar.bBH = (TextView) view3.findViewById(com.baidu.tieba.v.degree);
                    yVar.bBI = (TextView) view3.findViewById(com.baidu.tieba.v.degree_text);
                    yVar.bBM = (TextView) view3.findViewById(com.baidu.tieba.v.experience);
                    yVar.bBK = (TextView) view3.findViewById(com.baidu.tieba.v.experience_title);
                    yVar.bBN = (Button) view3.findViewById(com.baidu.tieba.v.item_delete);
                    yVar.bBJ = (TextView) view3.findViewById(com.baidu.tieba.v.degree_text_ta);
                    yVar.bBL = (TextView) view3.findViewById(com.baidu.tieba.v.intro_ta);
                    yVar.bBO = (ImageView) view3.findViewById(com.baidu.tieba.v.item_talk);
                    yVar.bfO = (ImageView) view3.findViewById(com.baidu.tieba.v.diver_buttom_px);
                    yVar.bfO.setVisibility(0);
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
            if (this.bBc) {
                yVar.bBH.setVisibility(8);
                yVar.bBN.setVisibility(8);
                yVar.avZ.setVisibility(8);
                yVar.avW.setVisibility(8);
                yVar.bBI.setVisibility(8);
                yVar.bBM.setVisibility(8);
                yVar.bBK.setVisibility(8);
                yVar.bBJ.setVisibility(8);
                yVar.bBL.setVisibility(8);
                yVar.bBO.setVisibility(8);
                yVar.bfO.setVisibility(8);
            } else {
                yVar.avZ.setVisibility(0);
                yVar.avW.setVisibility(0);
                if (this.boM) {
                    yVar.bBH.setVisibility(8);
                    yVar.bBI.setVisibility(8);
                    yVar.bBM.setVisibility(0);
                    yVar.bBK.setVisibility(0);
                    yVar.bBJ.setVisibility(0);
                    yVar.bBL.setVisibility(8);
                    yVar.bfO.setVisibility(0);
                } else {
                    yVar.bBH.setVisibility(8);
                    yVar.bBI.setVisibility(8);
                    yVar.bBM.setVisibility(8);
                    yVar.bBK.setVisibility(8);
                    yVar.bBJ.setVisibility(0);
                    yVar.bBL.setVisibility(0);
                    yVar.bfO.setVisibility(0);
                }
            }
            if (this.bBD == null || i < 0 || i >= this.bBD.size() || (forumData = this.bBD.get(i)) == null) {
                view2 = view3;
            } else {
                String image_url = forumData.getImage_url();
                yVar.avW.setTag(image_url);
                yVar.avW.setImageDrawable(null);
                yVar.avW.c(image_url, 10, false);
                yVar.bBG.delete(0, yVar.bBG.length());
                yVar.bBG.append(forumData.getName());
                yVar.bBG.append(this.bBC.getString(com.baidu.tieba.y.bar));
                yVar.avZ.setText(yVar.bBG);
                if (this.boM) {
                    com.baidu.tbadk.core.util.aw.h((View) yVar.bBJ, com.baidu.tbadk.core.util.d.bn(forumData.getUser_level()));
                    yVar.bBJ.setText(String.valueOf(forumData.getUser_level()));
                    yVar.bBM.setText(String.format(this.bBC.getString(com.baidu.tieba.y.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    yVar.bBN.setOnClickListener(this.bBE);
                    yVar.bBN.setTag(Integer.valueOf(i));
                    if (i < this.mData.ZI()) {
                        yVar.avZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.icon_v), (Drawable) null);
                        if (!this.bAN) {
                            yVar.bBO.setVisibility(0);
                            yVar.bBO.setTag(Integer.valueOf(i));
                        }
                    } else {
                        yVar.avZ.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        yVar.bBO.setVisibility(8);
                    }
                    yVar.bBO.setOnClickListener(this.bBF);
                } else {
                    if ((this.bBC.QR() == 0 && i < this.mData.ZI()) || (this.bBC.QR() == 1 && i < this.mData.ZJ())) {
                        yVar.avZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.icon_v), (Drawable) null);
                    } else {
                        yVar.avZ.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.bBC.QR() == 1) {
                        yVar.bBJ.setVisibility(8);
                    }
                    yVar.bBO.setVisibility(8);
                    com.baidu.tbadk.core.util.aw.h((View) yVar.bBJ, com.baidu.tbadk.core.util.d.bn(forumData.getUser_level()));
                    yVar.bBJ.setText(String.valueOf(forumData.getUser_level()));
                    yVar.bBL.setText(forumData.getSlogan());
                }
                if (this.aev) {
                    yVar.bBN.setVisibility(0);
                    yVar.bBO.setVisibility(8);
                    view2 = view3;
                } else {
                    yVar.bBN.setVisibility(8);
                    if (i < this.mData.ZI() && this.boM && !this.bAN) {
                        yVar.bBO.setVisibility(0);
                        view2 = view3;
                    } else {
                        yVar.bBO.setVisibility(8);
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
        this.bBC.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
        this.bBC.getLayoutMode().h(view);
    }

    public void w(View.OnClickListener onClickListener) {
        this.bBE = onClickListener;
    }

    public void x(View.OnClickListener onClickListener) {
        this.bBF = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.bBc) {
            return false;
        }
        return super.isEnabled(i);
    }
}
