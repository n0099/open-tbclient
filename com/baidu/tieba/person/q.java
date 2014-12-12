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
    private boolean bEP;
    private PersonBarActivity bFs;
    private View.OnClickListener bFv;
    private boolean bxv;
    private f mData;
    private ArrayList<ForumData> bFt = null;
    private boolean alV = false;
    private View.OnClickListener bFu = null;
    private boolean bwQ = false;

    public q(PersonBarActivity personBarActivity, f fVar, boolean z, boolean z2) {
        this.mData = null;
        this.bxv = true;
        this.bEP = false;
        this.bFs = personBarActivity;
        this.mData = fVar;
        this.bxv = z;
        this.bEP = z2;
    }

    public void J(ArrayList<ForumData> arrayList) {
        this.bFt = arrayList;
    }

    public void setEditState(boolean z) {
        this.alV = z;
        notifyDataSetChanged();
    }

    public boolean Ay() {
        return this.alV;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bwQ) {
            return 1;
        }
        if (this.bFt != null) {
            return this.bFt.size();
        }
        return 0;
    }

    public void Wc() {
        this.bwQ = false;
        if (this.bFt == null || this.bFt.size() == 0) {
            this.bwQ = true;
        }
    }

    public boolean aai() {
        return this.bwQ;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bFt == null || i < 0 || i >= this.bFt.size()) {
            return null;
        }
        return this.bFt.get(i);
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
                view3 = com.baidu.adp.lib.g.b.ek().inflate(this.bFs.getPageContext().getContext(), com.baidu.tieba.x.edit_bar_item, null);
                try {
                    r rVar2 = new r(this, null);
                    rVar2.azm = (BarImageView) view3.findViewById(com.baidu.tieba.w.forum_avatar);
                    rVar2.azm.setGifIconSupport(false);
                    rVar2.azp = (TextView) view3.findViewById(com.baidu.tieba.w.name);
                    rVar2.bFw = new StringBuffer(10);
                    rVar2.bFx = (TextView) view3.findViewById(com.baidu.tieba.w.degree);
                    rVar2.bFy = (TextView) view3.findViewById(com.baidu.tieba.w.degree_text);
                    rVar2.bFC = (TextView) view3.findViewById(com.baidu.tieba.w.experience);
                    rVar2.bFA = (TextView) view3.findViewById(com.baidu.tieba.w.experience_title);
                    rVar2.bFD = (Button) view3.findViewById(com.baidu.tieba.w.item_delete);
                    rVar2.bFz = (TextView) view3.findViewById(com.baidu.tieba.w.degree_text_ta);
                    rVar2.bFB = (TextView) view3.findViewById(com.baidu.tieba.w.intro_ta);
                    rVar2.bFE = (ImageView) view3.findViewById(com.baidu.tieba.w.item_talk);
                    rVar2.bjq = (ImageView) view3.findViewById(com.baidu.tieba.w.diver_buttom_px);
                    rVar2.bjq.setVisibility(0);
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
            if (this.bwQ) {
                rVar.bFx.setVisibility(8);
                rVar.bFD.setVisibility(8);
                rVar.azp.setVisibility(8);
                rVar.azm.setVisibility(8);
                rVar.bFy.setVisibility(8);
                rVar.bFC.setVisibility(8);
                rVar.bFA.setVisibility(8);
                rVar.bFz.setVisibility(8);
                rVar.bFB.setVisibility(8);
                rVar.bFE.setVisibility(8);
                rVar.bjq.setVisibility(8);
            } else {
                rVar.azp.setVisibility(0);
                rVar.azm.setVisibility(0);
                if (this.bxv) {
                    rVar.bFx.setVisibility(8);
                    rVar.bFy.setVisibility(8);
                    rVar.bFC.setVisibility(0);
                    rVar.bFA.setVisibility(0);
                    rVar.bFz.setVisibility(0);
                    rVar.bFB.setVisibility(8);
                    rVar.bjq.setVisibility(0);
                } else {
                    rVar.bFx.setVisibility(8);
                    rVar.bFy.setVisibility(8);
                    rVar.bFC.setVisibility(8);
                    rVar.bFA.setVisibility(8);
                    rVar.bFz.setVisibility(0);
                    rVar.bFB.setVisibility(0);
                    rVar.bjq.setVisibility(0);
                }
            }
            if (this.bFt == null || i < 0 || i >= this.bFt.size() || (forumData = this.bFt.get(i)) == null) {
                view2 = view3;
            } else {
                String image_url = forumData.getImage_url();
                rVar.azm.setTag(image_url);
                rVar.azm.setImageDrawable(null);
                rVar.azm.a(image_url, 10, com.baidu.adp.lib.util.l.d(this.bFs.getPageContext().getPageActivity(), com.baidu.tieba.u.forum_my_like_head_size), com.baidu.adp.lib.util.l.d(this.bFs.getPageContext().getPageActivity(), com.baidu.tieba.u.forum_my_like_head_size), false);
                rVar.bFw.delete(0, rVar.bFw.length());
                rVar.bFw.append(forumData.getName());
                rVar.bFw.append(this.bFs.getPageContext().getString(com.baidu.tieba.z.bar));
                rVar.azp.setText(rVar.bFw);
                if (this.bxv) {
                    com.baidu.tbadk.core.util.ax.i((View) rVar.bFz, com.baidu.tbadk.core.util.d.bK(forumData.getUser_level()));
                    rVar.bFz.setText(String.valueOf(forumData.getUser_level()));
                    rVar.bFC.setText(String.format(this.bFs.getPageContext().getString(com.baidu.tieba.z.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    rVar.bFD.setOnClickListener(this.bFu);
                    rVar.bFD.setTag(Integer.valueOf(i));
                    if (i < this.mData.ZY()) {
                        rVar.azp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.ax.getDrawable(com.baidu.tieba.v.icon_v), (Drawable) null);
                        if (!this.bEP) {
                            rVar.bFE.setVisibility(0);
                            rVar.bFE.setTag(Integer.valueOf(i));
                        }
                    } else {
                        rVar.azp.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        rVar.bFE.setVisibility(8);
                    }
                    rVar.bFE.setOnClickListener(this.bFv);
                } else {
                    if ((this.bFs.Rt() == 0 && i < this.mData.ZY()) || (this.bFs.Rt() == 1 && i < this.mData.ZZ())) {
                        rVar.azp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.ax.getDrawable(com.baidu.tieba.v.icon_v), (Drawable) null);
                    } else {
                        rVar.azp.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.bFs.Rt() == 1) {
                        rVar.bFz.setVisibility(8);
                    }
                    rVar.bFE.setVisibility(8);
                    com.baidu.tbadk.core.util.ax.i((View) rVar.bFz, com.baidu.tbadk.core.util.d.bK(forumData.getUser_level()));
                    rVar.bFz.setText(String.valueOf(forumData.getUser_level()));
                    rVar.bFB.setText(forumData.getSlogan());
                }
                if (this.alV) {
                    rVar.bFD.setVisibility(0);
                    rVar.bFE.setVisibility(8);
                    view2 = view3;
                } else {
                    rVar.bFD.setVisibility(8);
                    if (i < this.mData.ZY() && this.bxv && !this.bEP) {
                        rVar.bFE.setVisibility(0);
                        view2 = view3;
                    } else {
                        rVar.bFE.setVisibility(8);
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
        this.bFs.getLayoutMode().ab(TbadkCoreApplication.m255getInst().getSkinType() == 1);
        this.bFs.getLayoutMode().h(view);
    }

    public void x(View.OnClickListener onClickListener) {
        this.bFu = onClickListener;
    }

    public void C(View.OnClickListener onClickListener) {
        this.bFv = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.bwQ) {
            return false;
        }
        return super.isEnabled(i);
    }
}
