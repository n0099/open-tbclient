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
    private boolean aYg;
    private boolean bQP;
    private String bQQ;
    private PersonBarActivity bSd;
    private boolean bSg;
    private View.OnClickListener bSh;
    private u mData;
    private ArrayList<ForumData> bSe = null;
    private boolean awn = false;
    private View.OnClickListener bSf = null;
    private boolean bHd = false;

    public ag(PersonBarActivity personBarActivity, u uVar, boolean z, boolean z2) {
        this.mData = null;
        this.aYg = true;
        this.bQP = false;
        this.bSg = true;
        this.bSd = personBarActivity;
        this.mData = uVar;
        this.aYg = z;
        this.bQP = z2;
        this.bSg = TbadkCoreApplication.m411getInst().appResponseToCmd(2002006);
    }

    public void L(ArrayList<ForumData> arrayList) {
        this.bSe = arrayList;
    }

    public void setEditState(boolean z) {
        this.awn = z;
        notifyDataSetChanged();
    }

    public boolean Fc() {
        return this.awn;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bHd) {
            return 1;
        }
        if (this.bSe != null) {
            return this.bSe.size();
        }
        return 0;
    }

    public void ZH() {
        this.bHd = false;
        if (this.bSe == null || this.bSe.size() == 0) {
            this.bHd = true;
        }
    }

    public boolean aeo() {
        return this.bHd;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bSe == null || i < 0 || i >= this.bSe.size()) {
            return null;
        }
        return this.bSe.get(i);
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
                view3 = com.baidu.adp.lib.g.b.hr().inflate(this.bSd.getPageContext().getContext(), com.baidu.tieba.r.edit_bar_item, null);
                try {
                    ahVar = new ah(this, null);
                    ahVar.bAS = (BarImageView) view3.findViewById(com.baidu.tieba.q.forum_avatar);
                    ahVar.bAS.setGifIconSupport(false);
                    ahVar.baI = (TextView) view3.findViewById(com.baidu.tieba.q.name);
                    ahVar.bSi = new StringBuffer(10);
                    ahVar.bSj = (TextView) view3.findViewById(com.baidu.tieba.q.degree);
                    ahVar.bSk = (TextView) view3.findViewById(com.baidu.tieba.q.degree_text);
                    ahVar.bSo = (TextView) view3.findViewById(com.baidu.tieba.q.experience);
                    ahVar.bSm = (TextView) view3.findViewById(com.baidu.tieba.q.experience_title);
                    ahVar.bSp = (Button) view3.findViewById(com.baidu.tieba.q.item_delete);
                    ahVar.bSl = (ImageView) view3.findViewById(com.baidu.tieba.q.degree_text_ta);
                    ahVar.bSn = (TextView) view3.findViewById(com.baidu.tieba.q.intro_ta);
                    ahVar.bSq = (ImageView) view3.findViewById(com.baidu.tieba.q.item_talk);
                    ahVar.bow = (ImageView) view3.findViewById(com.baidu.tieba.q.diver_buttom_px);
                    ahVar.bow.setVisibility(0);
                    ahVar.bSr = (ImageView) view3.findViewById(com.baidu.tieba.q.item_selected);
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
            if (this.bHd) {
                ahVar.bSj.setVisibility(8);
                ahVar.bSp.setVisibility(8);
                ahVar.baI.setVisibility(8);
                ahVar.bAS.setVisibility(8);
                ahVar.bSk.setVisibility(8);
                ahVar.bSo.setVisibility(8);
                ahVar.bSm.setVisibility(8);
                ahVar.bSl.setVisibility(8);
                ahVar.bSn.setVisibility(8);
                ahVar.bSq.setVisibility(8);
                ahVar.bow.setVisibility(8);
            } else {
                ahVar.baI.setVisibility(0);
                ahVar.bAS.setVisibility(0);
                if (this.aYg) {
                    ahVar.bSj.setVisibility(8);
                    ahVar.bSk.setVisibility(8);
                    ahVar.bSo.setVisibility(0);
                    ahVar.bSm.setVisibility(0);
                    ahVar.bSl.setVisibility(0);
                    ahVar.bSn.setVisibility(8);
                    ahVar.bow.setVisibility(0);
                } else {
                    ahVar.bSj.setVisibility(8);
                    ahVar.bSk.setVisibility(8);
                    ahVar.bSo.setVisibility(8);
                    ahVar.bSm.setVisibility(8);
                    ahVar.bSl.setVisibility(0);
                    ahVar.bSn.setVisibility(0);
                    ahVar.bow.setVisibility(0);
                }
            }
            if (this.bSe == null || i < 0 || i >= this.bSe.size() || (forumData = this.bSe.get(i)) == null) {
                view2 = view3;
            } else {
                String image_url = forumData.getImage_url();
                ahVar.bAS.setTag(image_url);
                ahVar.bAS.setImageDrawable(null);
                ahVar.bAS.c(image_url, 10, false);
                ahVar.bSi.delete(0, ahVar.bSi.length());
                ahVar.bSi.append(forumData.getName());
                ahVar.bSi.append(this.bSd.getPageContext().getString(com.baidu.tieba.t.bar));
                ahVar.baI.setText(ahVar.bSi);
                if (this.aYg) {
                    com.baidu.tbadk.core.util.ay.c(ahVar.bSl, com.baidu.tbadk.core.util.c.bU(forumData.getUser_level()));
                    ahVar.bSo.setText(String.format(this.bSd.getPageContext().getString(com.baidu.tieba.t.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    ahVar.bSp.setOnClickListener(this.bSf);
                    ahVar.bSp.setTag(Integer.valueOf(i));
                    if (i < this.mData.aee()) {
                        ahVar.baI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.ay.getDrawable(com.baidu.tieba.p.icon_v), (Drawable) null);
                        if (!this.bQP && this.bSg) {
                            ahVar.bSq.setVisibility(0);
                            ahVar.bSq.setTag(Integer.valueOf(i));
                        }
                    } else {
                        ahVar.baI.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        ahVar.bSq.setVisibility(8);
                    }
                    ahVar.bSq.setOnClickListener(this.bSh);
                    ahVar.bSr.setVisibility(8);
                    if (this.bQP && this.bSd.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.bQQ)) {
                        ahVar.bSr.setVisibility(0);
                    }
                } else {
                    if ((this.bSd.Uq() == 0 && i < this.mData.aee()) || (this.bSd.Uq() == 1 && i < this.mData.aef())) {
                        ahVar.baI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.ay.getDrawable(com.baidu.tieba.p.icon_v), (Drawable) null);
                    } else {
                        ahVar.baI.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.bSd.Uq() == 1) {
                        ahVar.bSl.setVisibility(8);
                    }
                    ahVar.bSq.setVisibility(8);
                    com.baidu.tbadk.core.util.ay.c(ahVar.bSl, com.baidu.tbadk.core.util.c.bU(forumData.getUser_level()));
                    ahVar.bSn.setText(forumData.getSlogan());
                }
                if (this.awn) {
                    ahVar.bSp.setVisibility(0);
                    ahVar.bSq.setVisibility(8);
                    view2 = view3;
                } else {
                    ahVar.bSp.setVisibility(8);
                    if (i < this.mData.aee() && this.aYg && !this.bQP && this.bSg) {
                        ahVar.bSq.setVisibility(0);
                        view2 = view3;
                    } else {
                        ahVar.bSq.setVisibility(8);
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
        this.bSd.getLayoutMode().ab(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.bSd.getLayoutMode().j(view);
    }

    public void r(View.OnClickListener onClickListener) {
        this.bSf = onClickListener;
    }

    public void x(View.OnClickListener onClickListener) {
        this.bSh = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.bHd) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void iC(String str) {
        this.bQQ = str;
    }
}
