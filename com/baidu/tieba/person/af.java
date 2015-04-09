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
public class af extends BaseAdapter {
    private boolean aVz;
    private boolean bON;
    private PersonBarActivity bPW;
    private boolean bPZ;
    private View.OnClickListener bQa;
    private u mData;
    private ArrayList<ForumData> bPX = null;
    private boolean auJ = false;
    private View.OnClickListener bPY = null;
    private boolean bEh = false;

    public af(PersonBarActivity personBarActivity, u uVar, boolean z, boolean z2) {
        this.mData = null;
        this.aVz = true;
        this.bON = false;
        this.bPZ = true;
        this.bPW = personBarActivity;
        this.mData = uVar;
        this.aVz = z;
        this.bON = z2;
        this.bPZ = TbadkCoreApplication.m411getInst().appResponseToCmd(2002006);
    }

    public void Q(ArrayList<ForumData> arrayList) {
        this.bPX = arrayList;
    }

    public void setEditState(boolean z) {
        this.auJ = z;
        notifyDataSetChanged();
    }

    public boolean Eo() {
        return this.auJ;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bEh) {
            return 1;
        }
        if (this.bPX != null) {
            return this.bPX.size();
        }
        return 0;
    }

    public void Yg() {
        this.bEh = false;
        if (this.bPX == null || this.bPX.size() == 0) {
            this.bEh = true;
        }
    }

    public boolean adn() {
        return this.bEh;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bPX == null || i < 0 || i >= this.bPX.size()) {
            return null;
        }
        return this.bPX.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        ag agVar;
        View view3;
        ForumData forumData;
        try {
            if (view == null) {
                view3 = com.baidu.adp.lib.g.b.hH().inflate(this.bPW.getPageContext().getContext(), com.baidu.tieba.w.edit_bar_item, null);
                try {
                    agVar = new ag(this, null);
                    agVar.byh = (BarImageView) view3.findViewById(com.baidu.tieba.v.forum_avatar);
                    agVar.byh.setGifIconSupport(false);
                    agVar.aYa = (TextView) view3.findViewById(com.baidu.tieba.v.name);
                    agVar.bQb = new StringBuffer(10);
                    agVar.bQc = (TextView) view3.findViewById(com.baidu.tieba.v.degree);
                    agVar.bQd = (TextView) view3.findViewById(com.baidu.tieba.v.degree_text);
                    agVar.bQh = (TextView) view3.findViewById(com.baidu.tieba.v.experience);
                    agVar.bQf = (TextView) view3.findViewById(com.baidu.tieba.v.experience_title);
                    agVar.bQi = (Button) view3.findViewById(com.baidu.tieba.v.item_delete);
                    agVar.bQe = (ImageView) view3.findViewById(com.baidu.tieba.v.degree_text_ta);
                    agVar.bQg = (TextView) view3.findViewById(com.baidu.tieba.v.intro_ta);
                    agVar.bQj = (ImageView) view3.findViewById(com.baidu.tieba.v.item_talk);
                    agVar.blR = (ImageView) view3.findViewById(com.baidu.tieba.v.diver_buttom_px);
                    agVar.blR.setVisibility(0);
                    view3.setTag(agVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    BdLog.e(exc.getMessage());
                    applyNightMode(view2);
                    return view2;
                }
            } else {
                agVar = (ag) view.getTag();
                view3 = view;
            }
            if (this.bEh) {
                agVar.bQc.setVisibility(8);
                agVar.bQi.setVisibility(8);
                agVar.aYa.setVisibility(8);
                agVar.byh.setVisibility(8);
                agVar.bQd.setVisibility(8);
                agVar.bQh.setVisibility(8);
                agVar.bQf.setVisibility(8);
                agVar.bQe.setVisibility(8);
                agVar.bQg.setVisibility(8);
                agVar.bQj.setVisibility(8);
                agVar.blR.setVisibility(8);
            } else {
                agVar.aYa.setVisibility(0);
                agVar.byh.setVisibility(0);
                if (this.aVz) {
                    agVar.bQc.setVisibility(8);
                    agVar.bQd.setVisibility(8);
                    agVar.bQh.setVisibility(0);
                    agVar.bQf.setVisibility(0);
                    agVar.bQe.setVisibility(0);
                    agVar.bQg.setVisibility(8);
                    agVar.blR.setVisibility(0);
                } else {
                    agVar.bQc.setVisibility(8);
                    agVar.bQd.setVisibility(8);
                    agVar.bQh.setVisibility(8);
                    agVar.bQf.setVisibility(8);
                    agVar.bQe.setVisibility(0);
                    agVar.bQg.setVisibility(0);
                    agVar.blR.setVisibility(0);
                }
            }
            if (this.bPX == null || i < 0 || i >= this.bPX.size() || (forumData = this.bPX.get(i)) == null) {
                view2 = view3;
            } else {
                String image_url = forumData.getImage_url();
                agVar.byh.setTag(image_url);
                agVar.byh.setImageDrawable(null);
                agVar.byh.c(image_url, 10, false);
                agVar.bQb.delete(0, agVar.bQb.length());
                agVar.bQb.append(forumData.getName());
                agVar.bQb.append(this.bPW.getPageContext().getString(com.baidu.tieba.y.bar));
                agVar.aYa.setText(agVar.bQb);
                if (this.aVz) {
                    com.baidu.tbadk.core.util.ba.c(agVar.bQe, com.baidu.tbadk.core.util.c.bR(forumData.getUser_level()));
                    agVar.bQh.setText(String.format(this.bPW.getPageContext().getString(com.baidu.tieba.y.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    agVar.bQi.setOnClickListener(this.bPY);
                    agVar.bQi.setTag(Integer.valueOf(i));
                    if (i < this.mData.add()) {
                        agVar.aYa.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.ba.getDrawable(com.baidu.tieba.u.icon_v), (Drawable) null);
                        if (!this.bON && this.bPZ) {
                            agVar.bQj.setVisibility(0);
                            agVar.bQj.setTag(Integer.valueOf(i));
                        }
                    } else {
                        agVar.aYa.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        agVar.bQj.setVisibility(8);
                    }
                    agVar.bQj.setOnClickListener(this.bQa);
                } else {
                    if ((this.bPW.Tc() == 0 && i < this.mData.add()) || (this.bPW.Tc() == 1 && i < this.mData.ade())) {
                        agVar.aYa.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.ba.getDrawable(com.baidu.tieba.u.icon_v), (Drawable) null);
                    } else {
                        agVar.aYa.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.bPW.Tc() == 1) {
                        agVar.bQe.setVisibility(8);
                    }
                    agVar.bQj.setVisibility(8);
                    com.baidu.tbadk.core.util.ba.c(agVar.bQe, com.baidu.tbadk.core.util.c.bR(forumData.getUser_level()));
                    agVar.bQg.setText(forumData.getSlogan());
                }
                if (this.auJ) {
                    agVar.bQi.setVisibility(0);
                    agVar.bQj.setVisibility(8);
                    view2 = view3;
                } else {
                    agVar.bQi.setVisibility(8);
                    if (i < this.mData.add() && this.aVz && !this.bON && this.bPZ) {
                        agVar.bQj.setVisibility(0);
                        view2 = view3;
                    } else {
                        agVar.bQj.setVisibility(8);
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
        this.bPW.getLayoutMode().X(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.bPW.getLayoutMode().h(view);
    }

    public void s(View.OnClickListener onClickListener) {
        this.bPY = onClickListener;
    }

    public void z(View.OnClickListener onClickListener) {
        this.bQa = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.bEh) {
            return false;
        }
        return super.isEnabled(i);
    }
}
