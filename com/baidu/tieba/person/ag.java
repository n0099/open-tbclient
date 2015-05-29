package com.baidu.tieba.person;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.view.BarImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ag extends BaseAdapter {
    private boolean aYf;
    private boolean bQO;
    private String bQP;
    private PersonBarActivity bSc;
    private boolean bSf;
    private View.OnClickListener bSg;
    private u mData;
    private ArrayList<ForumData> bSd = null;
    private boolean awm = false;
    private View.OnClickListener bSe = null;
    private boolean bHc = false;

    public ag(PersonBarActivity personBarActivity, u uVar, boolean z, boolean z2) {
        this.mData = null;
        this.aYf = true;
        this.bQO = false;
        this.bSf = true;
        this.bSc = personBarActivity;
        this.mData = uVar;
        this.aYf = z;
        this.bQO = z2;
        this.bSf = TbadkCoreApplication.m411getInst().appResponseToCmd(2002006);
    }

    public void L(ArrayList<ForumData> arrayList) {
        this.bSd = arrayList;
    }

    public void setEditState(boolean z) {
        this.awm = z;
        notifyDataSetChanged();
    }

    public boolean Fb() {
        return this.awm;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bHc) {
            return 1;
        }
        if (this.bSd != null) {
            return this.bSd.size();
        }
        return 0;
    }

    public void ZG() {
        this.bHc = false;
        if (this.bSd == null || this.bSd.size() == 0) {
            this.bHc = true;
        }
    }

    public boolean aen() {
        return this.bHc;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bSd == null || i < 0 || i >= this.bSd.size()) {
            return null;
        }
        return this.bSd.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        ah ahVar;
        View view3;
        ForumData forumData;
        try {
            if (view == null) {
                view3 = com.baidu.adp.lib.g.b.hr().inflate(this.bSc.getPageContext().getContext(), com.baidu.tieba.r.edit_bar_item, null);
                try {
                    ahVar = new ah(this, null);
                    ahVar.bAR = (BarImageView) view3.findViewById(com.baidu.tieba.q.forum_avatar);
                    ahVar.bAR.setGifIconSupport(false);
                    ahVar.baH = (TextView) view3.findViewById(com.baidu.tieba.q.name);
                    ahVar.bSh = new StringBuffer(10);
                    ahVar.bSi = (TextView) view3.findViewById(com.baidu.tieba.q.degree);
                    ahVar.bSj = (TextView) view3.findViewById(com.baidu.tieba.q.degree_text);
                    ahVar.bSn = (TextView) view3.findViewById(com.baidu.tieba.q.experience);
                    ahVar.bSl = (TextView) view3.findViewById(com.baidu.tieba.q.experience_title);
                    ahVar.bSo = (Button) view3.findViewById(com.baidu.tieba.q.item_delete);
                    ahVar.bSk = (ImageView) view3.findViewById(com.baidu.tieba.q.degree_text_ta);
                    ahVar.bSm = (TextView) view3.findViewById(com.baidu.tieba.q.intro_ta);
                    ahVar.bSp = (ImageView) view3.findViewById(com.baidu.tieba.q.item_talk);
                    ahVar.bov = (ImageView) view3.findViewById(com.baidu.tieba.q.diver_buttom_px);
                    ahVar.bov.setVisibility(0);
                    ahVar.bSq = (ImageView) view3.findViewById(com.baidu.tieba.q.item_selected);
                    view3.setTag(ahVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    BdLog.e(exc.getMessage());
                    applyNightMode(view2);
                    return view2;
                }
            } else {
                ahVar = (ah) view.getTag();
                view3 = view;
            }
            if (this.bHc) {
                ahVar.bSi.setVisibility(8);
                ahVar.bSo.setVisibility(8);
                ahVar.baH.setVisibility(8);
                ahVar.bAR.setVisibility(8);
                ahVar.bSj.setVisibility(8);
                ahVar.bSn.setVisibility(8);
                ahVar.bSl.setVisibility(8);
                ahVar.bSk.setVisibility(8);
                ahVar.bSm.setVisibility(8);
                ahVar.bSp.setVisibility(8);
                ahVar.bov.setVisibility(8);
            } else {
                ahVar.baH.setVisibility(0);
                ahVar.bAR.setVisibility(0);
                if (this.aYf) {
                    ahVar.bSi.setVisibility(8);
                    ahVar.bSj.setVisibility(8);
                    ahVar.bSn.setVisibility(0);
                    ahVar.bSl.setVisibility(0);
                    ahVar.bSk.setVisibility(0);
                    ahVar.bSm.setVisibility(8);
                    ahVar.bov.setVisibility(0);
                } else {
                    ahVar.bSi.setVisibility(8);
                    ahVar.bSj.setVisibility(8);
                    ahVar.bSn.setVisibility(8);
                    ahVar.bSl.setVisibility(8);
                    ahVar.bSk.setVisibility(0);
                    ahVar.bSm.setVisibility(0);
                    ahVar.bov.setVisibility(0);
                }
            }
            if (this.bSd == null || i < 0 || i >= this.bSd.size() || (forumData = this.bSd.get(i)) == null) {
                view2 = view3;
            } else {
                String image_url = forumData.getImage_url();
                ahVar.bAR.setTag(image_url);
                ahVar.bAR.setImageDrawable(null);
                ahVar.bAR.c(image_url, 10, false);
                ahVar.bSh.delete(0, ahVar.bSh.length());
                ahVar.bSh.append(forumData.getName());
                ahVar.bSh.append(this.bSc.getPageContext().getString(com.baidu.tieba.t.bar));
                ahVar.baH.setText(ahVar.bSh);
                if (this.aYf) {
                    com.baidu.tbadk.core.util.ay.c(ahVar.bSk, com.baidu.tbadk.core.util.c.bU(forumData.getUser_level()));
                    ahVar.bSn.setText(String.format(this.bSc.getPageContext().getString(com.baidu.tieba.t.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    ahVar.bSo.setOnClickListener(this.bSe);
                    ahVar.bSo.setTag(Integer.valueOf(i));
                    if (i < this.mData.aed()) {
                        ahVar.baH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.ay.getDrawable(com.baidu.tieba.p.icon_v), (Drawable) null);
                        if (!this.bQO && this.bSf) {
                            ahVar.bSp.setVisibility(0);
                            ahVar.bSp.setTag(Integer.valueOf(i));
                        }
                    } else {
                        ahVar.baH.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        ahVar.bSp.setVisibility(8);
                    }
                    ahVar.bSp.setOnClickListener(this.bSg);
                    ahVar.bSq.setVisibility(8);
                    if (this.bQO && this.bSc.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.bQP)) {
                        ahVar.bSq.setVisibility(0);
                    }
                } else {
                    if ((this.bSc.Up() == 0 && i < this.mData.aed()) || (this.bSc.Up() == 1 && i < this.mData.aee())) {
                        ahVar.baH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.ay.getDrawable(com.baidu.tieba.p.icon_v), (Drawable) null);
                    } else {
                        ahVar.baH.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.bSc.Up() == 1) {
                        ahVar.bSk.setVisibility(8);
                    }
                    ahVar.bSp.setVisibility(8);
                    com.baidu.tbadk.core.util.ay.c(ahVar.bSk, com.baidu.tbadk.core.util.c.bU(forumData.getUser_level()));
                    ahVar.bSm.setText(forumData.getSlogan());
                }
                if (this.awm) {
                    ahVar.bSo.setVisibility(0);
                    ahVar.bSp.setVisibility(8);
                    view2 = view3;
                } else {
                    ahVar.bSo.setVisibility(8);
                    if (i < this.mData.aed() && this.aYf && !this.bQO && this.bSf) {
                        ahVar.bSp.setVisibility(0);
                        view2 = view3;
                    } else {
                        ahVar.bSp.setVisibility(8);
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
        this.bSc.getLayoutMode().ab(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.bSc.getLayoutMode().j(view);
    }

    public void r(View.OnClickListener onClickListener) {
        this.bSe = onClickListener;
    }

    public void x(View.OnClickListener onClickListener) {
        this.bSg = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.bHc) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void iC(String str) {
        this.bQP = str;
    }
}
