package com.baidu.tieba.person;

import android.graphics.drawable.Drawable;
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
public class q extends BaseAdapter {
    private boolean bGz;
    private PersonBarActivity bHc;
    private View.OnClickListener bHf;
    private boolean bzd;
    private f mData;
    private ArrayList<ForumData> bHd = null;
    private boolean amL = false;
    private View.OnClickListener bHe = null;
    private boolean byy = false;

    public q(PersonBarActivity personBarActivity, f fVar, boolean z, boolean z2) {
        this.mData = null;
        this.bzd = true;
        this.bGz = false;
        this.bHc = personBarActivity;
        this.mData = fVar;
        this.bzd = z;
        this.bGz = z2;
    }

    public void K(ArrayList<ForumData> arrayList) {
        this.bHd = arrayList;
    }

    public void setEditState(boolean z) {
        this.amL = z;
        notifyDataSetChanged();
    }

    public boolean AT() {
        return this.amL;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.byy) {
            return 1;
        }
        if (this.bHd != null) {
            return this.bHd.size();
        }
        return 0;
    }

    public void WC() {
        this.byy = false;
        if (this.bHd == null || this.bHd.size() == 0) {
            this.byy = true;
        }
    }

    public boolean aaI() {
        return this.byy;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bHd == null || i < 0 || i >= this.bHd.size()) {
            return null;
        }
        return this.bHd.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        r rVar;
        View view3;
        ForumData forumData;
        try {
            if (view == null) {
                view3 = com.baidu.adp.lib.g.b.ei().inflate(this.bHc.getPageContext().getContext(), com.baidu.tieba.x.edit_bar_item, null);
                try {
                    r rVar2 = new r(this, null);
                    rVar2.aAk = (BarImageView) view3.findViewById(com.baidu.tieba.w.forum_avatar);
                    rVar2.aAk.setGifIconSupport(false);
                    rVar2.aAn = (TextView) view3.findViewById(com.baidu.tieba.w.name);
                    rVar2.bHg = new StringBuffer(10);
                    rVar2.bHh = (TextView) view3.findViewById(com.baidu.tieba.w.degree);
                    rVar2.bHi = (TextView) view3.findViewById(com.baidu.tieba.w.degree_text);
                    rVar2.bHm = (TextView) view3.findViewById(com.baidu.tieba.w.experience);
                    rVar2.bHk = (TextView) view3.findViewById(com.baidu.tieba.w.experience_title);
                    rVar2.bHn = (Button) view3.findViewById(com.baidu.tieba.w.item_delete);
                    rVar2.bHj = (TextView) view3.findViewById(com.baidu.tieba.w.degree_text_ta);
                    rVar2.bHl = (TextView) view3.findViewById(com.baidu.tieba.w.intro_ta);
                    rVar2.bHo = (ImageView) view3.findViewById(com.baidu.tieba.w.item_talk);
                    rVar2.bkM = (ImageView) view3.findViewById(com.baidu.tieba.w.diver_buttom_px);
                    rVar2.bkM.setVisibility(0);
                    view3.setTag(rVar2);
                    rVar = rVar2;
                } catch (Exception e) {
                    exc = e;
                    view2 = view3;
                    BdLog.e(exc.getMessage());
                    applyNightMode(view2);
                    return view2;
                }
            } else {
                rVar = (r) view.getTag();
                view3 = view;
            }
            if (this.byy) {
                rVar.bHh.setVisibility(8);
                rVar.bHn.setVisibility(8);
                rVar.aAn.setVisibility(8);
                rVar.aAk.setVisibility(8);
                rVar.bHi.setVisibility(8);
                rVar.bHm.setVisibility(8);
                rVar.bHk.setVisibility(8);
                rVar.bHj.setVisibility(8);
                rVar.bHl.setVisibility(8);
                rVar.bHo.setVisibility(8);
                rVar.bkM.setVisibility(8);
            } else {
                rVar.aAn.setVisibility(0);
                rVar.aAk.setVisibility(0);
                if (this.bzd) {
                    rVar.bHh.setVisibility(8);
                    rVar.bHi.setVisibility(8);
                    rVar.bHm.setVisibility(0);
                    rVar.bHk.setVisibility(0);
                    rVar.bHj.setVisibility(0);
                    rVar.bHl.setVisibility(8);
                    rVar.bkM.setVisibility(0);
                } else {
                    rVar.bHh.setVisibility(8);
                    rVar.bHi.setVisibility(8);
                    rVar.bHm.setVisibility(8);
                    rVar.bHk.setVisibility(8);
                    rVar.bHj.setVisibility(0);
                    rVar.bHl.setVisibility(0);
                    rVar.bkM.setVisibility(0);
                }
            }
            if (this.bHd == null || i < 0 || i >= this.bHd.size() || (forumData = this.bHd.get(i)) == null) {
                view2 = view3;
            } else {
                String image_url = forumData.getImage_url();
                rVar.aAk.setTag(image_url);
                rVar.aAk.setImageDrawable(null);
                rVar.aAk.a(image_url, 10, com.baidu.adp.lib.util.l.d(this.bHc.getPageContext().getPageActivity(), com.baidu.tieba.u.forum_my_like_head_size), com.baidu.adp.lib.util.l.d(this.bHc.getPageContext().getPageActivity(), com.baidu.tieba.u.forum_my_like_head_size), false);
                rVar.bHg.delete(0, rVar.bHg.length());
                rVar.bHg.append(forumData.getName());
                rVar.bHg.append(this.bHc.getPageContext().getString(com.baidu.tieba.z.bar));
                rVar.aAn.setText(rVar.bHg);
                if (this.bzd) {
                    com.baidu.tbadk.core.util.bc.i((View) rVar.bHj, com.baidu.tbadk.core.util.d.bP(forumData.getUser_level()));
                    rVar.bHj.setText(String.valueOf(forumData.getUser_level()));
                    rVar.bHm.setText(String.format(this.bHc.getPageContext().getString(com.baidu.tieba.z.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    rVar.bHn.setOnClickListener(this.bHe);
                    rVar.bHn.setTag(Integer.valueOf(i));
                    if (i < this.mData.aay()) {
                        rVar.aAn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.bc.getDrawable(com.baidu.tieba.v.icon_v), (Drawable) null);
                        if (!this.bGz) {
                            rVar.bHo.setVisibility(0);
                            rVar.bHo.setTag(Integer.valueOf(i));
                        }
                    } else {
                        rVar.aAn.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        rVar.bHo.setVisibility(8);
                    }
                    rVar.bHo.setOnClickListener(this.bHf);
                } else {
                    if ((this.bHc.RK() == 0 && i < this.mData.aay()) || (this.bHc.RK() == 1 && i < this.mData.aaz())) {
                        rVar.aAn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.bc.getDrawable(com.baidu.tieba.v.icon_v), (Drawable) null);
                    } else {
                        rVar.aAn.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.bHc.RK() == 1) {
                        rVar.bHj.setVisibility(8);
                    }
                    rVar.bHo.setVisibility(8);
                    com.baidu.tbadk.core.util.bc.i((View) rVar.bHj, com.baidu.tbadk.core.util.d.bP(forumData.getUser_level()));
                    rVar.bHj.setText(String.valueOf(forumData.getUser_level()));
                    rVar.bHl.setText(forumData.getSlogan());
                }
                if (this.amL) {
                    rVar.bHn.setVisibility(0);
                    rVar.bHo.setVisibility(8);
                    view2 = view3;
                } else {
                    rVar.bHn.setVisibility(8);
                    if (i < this.mData.aay() && this.bzd && !this.bGz) {
                        rVar.bHo.setVisibility(0);
                        view2 = view3;
                    } else {
                        rVar.bHo.setVisibility(8);
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
        this.bHc.getLayoutMode().ab(TbadkCoreApplication.m255getInst().getSkinType() == 1);
        this.bHc.getLayoutMode().h(view);
    }

    public void y(View.OnClickListener onClickListener) {
        this.bHe = onClickListener;
    }

    public void D(View.OnClickListener onClickListener) {
        this.bHf = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.byy) {
            return false;
        }
        return super.isEnabled(i);
    }
}
