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
    private boolean bGA;
    private PersonBarActivity bHd;
    private View.OnClickListener bHg;
    private boolean bze;
    private f mData;
    private ArrayList<ForumData> bHe = null;
    private boolean amO = false;
    private View.OnClickListener bHf = null;
    private boolean byz = false;

    public q(PersonBarActivity personBarActivity, f fVar, boolean z, boolean z2) {
        this.mData = null;
        this.bze = true;
        this.bGA = false;
        this.bHd = personBarActivity;
        this.mData = fVar;
        this.bze = z;
        this.bGA = z2;
    }

    public void K(ArrayList<ForumData> arrayList) {
        this.bHe = arrayList;
    }

    public void setEditState(boolean z) {
        this.amO = z;
        notifyDataSetChanged();
    }

    public boolean AZ() {
        return this.amO;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.byz) {
            return 1;
        }
        if (this.bHe != null) {
            return this.bHe.size();
        }
        return 0;
    }

    public void WH() {
        this.byz = false;
        if (this.bHe == null || this.bHe.size() == 0) {
            this.byz = true;
        }
    }

    public boolean aaN() {
        return this.byz;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bHe == null || i < 0 || i >= this.bHe.size()) {
            return null;
        }
        return this.bHe.get(i);
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
                view3 = com.baidu.adp.lib.g.b.ei().inflate(this.bHd.getPageContext().getContext(), com.baidu.tieba.x.edit_bar_item, null);
                try {
                    r rVar2 = new r(this, null);
                    rVar2.aAn = (BarImageView) view3.findViewById(com.baidu.tieba.w.forum_avatar);
                    rVar2.aAn.setGifIconSupport(false);
                    rVar2.aAq = (TextView) view3.findViewById(com.baidu.tieba.w.name);
                    rVar2.bHh = new StringBuffer(10);
                    rVar2.bHi = (TextView) view3.findViewById(com.baidu.tieba.w.degree);
                    rVar2.bHj = (TextView) view3.findViewById(com.baidu.tieba.w.degree_text);
                    rVar2.bHn = (TextView) view3.findViewById(com.baidu.tieba.w.experience);
                    rVar2.bHl = (TextView) view3.findViewById(com.baidu.tieba.w.experience_title);
                    rVar2.bHo = (Button) view3.findViewById(com.baidu.tieba.w.item_delete);
                    rVar2.bHk = (TextView) view3.findViewById(com.baidu.tieba.w.degree_text_ta);
                    rVar2.bHm = (TextView) view3.findViewById(com.baidu.tieba.w.intro_ta);
                    rVar2.bHp = (ImageView) view3.findViewById(com.baidu.tieba.w.item_talk);
                    rVar2.bkN = (ImageView) view3.findViewById(com.baidu.tieba.w.diver_buttom_px);
                    rVar2.bkN.setVisibility(0);
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
            if (this.byz) {
                rVar.bHi.setVisibility(8);
                rVar.bHo.setVisibility(8);
                rVar.aAq.setVisibility(8);
                rVar.aAn.setVisibility(8);
                rVar.bHj.setVisibility(8);
                rVar.bHn.setVisibility(8);
                rVar.bHl.setVisibility(8);
                rVar.bHk.setVisibility(8);
                rVar.bHm.setVisibility(8);
                rVar.bHp.setVisibility(8);
                rVar.bkN.setVisibility(8);
            } else {
                rVar.aAq.setVisibility(0);
                rVar.aAn.setVisibility(0);
                if (this.bze) {
                    rVar.bHi.setVisibility(8);
                    rVar.bHj.setVisibility(8);
                    rVar.bHn.setVisibility(0);
                    rVar.bHl.setVisibility(0);
                    rVar.bHk.setVisibility(0);
                    rVar.bHm.setVisibility(8);
                    rVar.bkN.setVisibility(0);
                } else {
                    rVar.bHi.setVisibility(8);
                    rVar.bHj.setVisibility(8);
                    rVar.bHn.setVisibility(8);
                    rVar.bHl.setVisibility(8);
                    rVar.bHk.setVisibility(0);
                    rVar.bHm.setVisibility(0);
                    rVar.bkN.setVisibility(0);
                }
            }
            if (this.bHe == null || i < 0 || i >= this.bHe.size() || (forumData = this.bHe.get(i)) == null) {
                view2 = view3;
            } else {
                String image_url = forumData.getImage_url();
                rVar.aAn.setTag(image_url);
                rVar.aAn.setImageDrawable(null);
                rVar.aAn.a(image_url, 10, com.baidu.adp.lib.util.l.d(this.bHd.getPageContext().getPageActivity(), com.baidu.tieba.u.forum_my_like_head_size), com.baidu.adp.lib.util.l.d(this.bHd.getPageContext().getPageActivity(), com.baidu.tieba.u.forum_my_like_head_size), false);
                rVar.bHh.delete(0, rVar.bHh.length());
                rVar.bHh.append(forumData.getName());
                rVar.bHh.append(this.bHd.getPageContext().getString(com.baidu.tieba.z.bar));
                rVar.aAq.setText(rVar.bHh);
                if (this.bze) {
                    com.baidu.tbadk.core.util.bc.i((View) rVar.bHk, com.baidu.tbadk.core.util.d.bP(forumData.getUser_level()));
                    rVar.bHk.setText(String.valueOf(forumData.getUser_level()));
                    rVar.bHn.setText(String.format(this.bHd.getPageContext().getString(com.baidu.tieba.z.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    rVar.bHo.setOnClickListener(this.bHf);
                    rVar.bHo.setTag(Integer.valueOf(i));
                    if (i < this.mData.aaD()) {
                        rVar.aAq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.bc.getDrawable(com.baidu.tieba.v.icon_v), (Drawable) null);
                        if (!this.bGA) {
                            rVar.bHp.setVisibility(0);
                            rVar.bHp.setTag(Integer.valueOf(i));
                        }
                    } else {
                        rVar.aAq.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        rVar.bHp.setVisibility(8);
                    }
                    rVar.bHp.setOnClickListener(this.bHg);
                } else {
                    if ((this.bHd.RP() == 0 && i < this.mData.aaD()) || (this.bHd.RP() == 1 && i < this.mData.aaE())) {
                        rVar.aAq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.bc.getDrawable(com.baidu.tieba.v.icon_v), (Drawable) null);
                    } else {
                        rVar.aAq.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.bHd.RP() == 1) {
                        rVar.bHk.setVisibility(8);
                    }
                    rVar.bHp.setVisibility(8);
                    com.baidu.tbadk.core.util.bc.i((View) rVar.bHk, com.baidu.tbadk.core.util.d.bP(forumData.getUser_level()));
                    rVar.bHk.setText(String.valueOf(forumData.getUser_level()));
                    rVar.bHm.setText(forumData.getSlogan());
                }
                if (this.amO) {
                    rVar.bHo.setVisibility(0);
                    rVar.bHp.setVisibility(8);
                    view2 = view3;
                } else {
                    rVar.bHo.setVisibility(8);
                    if (i < this.mData.aaD() && this.bze && !this.bGA) {
                        rVar.bHp.setVisibility(0);
                        view2 = view3;
                    } else {
                        rVar.bHp.setVisibility(8);
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
        this.bHd.getLayoutMode().ab(TbadkCoreApplication.m255getInst().getSkinType() == 1);
        this.bHd.getLayoutMode().h(view);
    }

    public void y(View.OnClickListener onClickListener) {
        this.bHf = onClickListener;
    }

    public void D(View.OnClickListener onClickListener) {
        this.bHg = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.byz) {
            return false;
        }
        return super.isEnabled(i);
    }
}
