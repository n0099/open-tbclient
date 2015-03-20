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
    private boolean aVk;
    private boolean bOx;
    private PersonBarActivity bPG;
    private boolean bPJ;
    private View.OnClickListener bPK;
    private u mData;
    private ArrayList<ForumData> bPH = null;
    private boolean auB = false;
    private View.OnClickListener bPI = null;
    private boolean bDU = false;

    public af(PersonBarActivity personBarActivity, u uVar, boolean z, boolean z2) {
        this.mData = null;
        this.aVk = true;
        this.bOx = false;
        this.bPJ = true;
        this.bPG = personBarActivity;
        this.mData = uVar;
        this.aVk = z;
        this.bOx = z2;
        this.bPJ = TbadkCoreApplication.m411getInst().appResponseToCmd(2002006);
    }

    public void O(ArrayList<ForumData> arrayList) {
        this.bPH = arrayList;
    }

    public void setEditState(boolean z) {
        this.auB = z;
        notifyDataSetChanged();
    }

    public boolean Ei() {
        return this.auB;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bDU) {
            return 1;
        }
        if (this.bPH != null) {
            return this.bPH.size();
        }
        return 0;
    }

    public void XU() {
        this.bDU = false;
        if (this.bPH == null || this.bPH.size() == 0) {
            this.bDU = true;
        }
    }

    public boolean acY() {
        return this.bDU;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bPH == null || i < 0 || i >= this.bPH.size()) {
            return null;
        }
        return this.bPH.get(i);
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
                view3 = com.baidu.adp.lib.g.b.hH().inflate(this.bPG.getPageContext().getContext(), com.baidu.tieba.w.edit_bar_item, null);
                try {
                    agVar = new ag(this, null);
                    agVar.bxR = (BarImageView) view3.findViewById(com.baidu.tieba.v.forum_avatar);
                    agVar.bxR.setGifIconSupport(false);
                    agVar.aXK = (TextView) view3.findViewById(com.baidu.tieba.v.name);
                    agVar.bPL = new StringBuffer(10);
                    agVar.bPM = (TextView) view3.findViewById(com.baidu.tieba.v.degree);
                    agVar.bPN = (TextView) view3.findViewById(com.baidu.tieba.v.degree_text);
                    agVar.bPR = (TextView) view3.findViewById(com.baidu.tieba.v.experience);
                    agVar.bPP = (TextView) view3.findViewById(com.baidu.tieba.v.experience_title);
                    agVar.bPS = (Button) view3.findViewById(com.baidu.tieba.v.item_delete);
                    agVar.bPO = (ImageView) view3.findViewById(com.baidu.tieba.v.degree_text_ta);
                    agVar.bPQ = (TextView) view3.findViewById(com.baidu.tieba.v.intro_ta);
                    agVar.bPT = (ImageView) view3.findViewById(com.baidu.tieba.v.item_talk);
                    agVar.blB = (ImageView) view3.findViewById(com.baidu.tieba.v.diver_buttom_px);
                    agVar.blB.setVisibility(0);
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
            if (this.bDU) {
                agVar.bPM.setVisibility(8);
                agVar.bPS.setVisibility(8);
                agVar.aXK.setVisibility(8);
                agVar.bxR.setVisibility(8);
                agVar.bPN.setVisibility(8);
                agVar.bPR.setVisibility(8);
                agVar.bPP.setVisibility(8);
                agVar.bPO.setVisibility(8);
                agVar.bPQ.setVisibility(8);
                agVar.bPT.setVisibility(8);
                agVar.blB.setVisibility(8);
            } else {
                agVar.aXK.setVisibility(0);
                agVar.bxR.setVisibility(0);
                if (this.aVk) {
                    agVar.bPM.setVisibility(8);
                    agVar.bPN.setVisibility(8);
                    agVar.bPR.setVisibility(0);
                    agVar.bPP.setVisibility(0);
                    agVar.bPO.setVisibility(0);
                    agVar.bPQ.setVisibility(8);
                    agVar.blB.setVisibility(0);
                } else {
                    agVar.bPM.setVisibility(8);
                    agVar.bPN.setVisibility(8);
                    agVar.bPR.setVisibility(8);
                    agVar.bPP.setVisibility(8);
                    agVar.bPO.setVisibility(0);
                    agVar.bPQ.setVisibility(0);
                    agVar.blB.setVisibility(0);
                }
            }
            if (this.bPH == null || i < 0 || i >= this.bPH.size() || (forumData = this.bPH.get(i)) == null) {
                view2 = view3;
            } else {
                String image_url = forumData.getImage_url();
                agVar.bxR.setTag(image_url);
                agVar.bxR.setImageDrawable(null);
                agVar.bxR.c(image_url, 10, false);
                agVar.bPL.delete(0, agVar.bPL.length());
                agVar.bPL.append(forumData.getName());
                agVar.bPL.append(this.bPG.getPageContext().getString(com.baidu.tieba.y.bar));
                agVar.aXK.setText(agVar.bPL);
                if (this.aVk) {
                    com.baidu.tbadk.core.util.ba.c(agVar.bPO, com.baidu.tbadk.core.util.c.bR(forumData.getUser_level()));
                    agVar.bPR.setText(String.format(this.bPG.getPageContext().getString(com.baidu.tieba.y.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    agVar.bPS.setOnClickListener(this.bPI);
                    agVar.bPS.setTag(Integer.valueOf(i));
                    if (i < this.mData.acO()) {
                        agVar.aXK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.ba.getDrawable(com.baidu.tieba.u.icon_v), (Drawable) null);
                        if (!this.bOx && this.bPJ) {
                            agVar.bPT.setVisibility(0);
                            agVar.bPT.setTag(Integer.valueOf(i));
                        }
                    } else {
                        agVar.aXK.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        agVar.bPT.setVisibility(8);
                    }
                    agVar.bPT.setOnClickListener(this.bPK);
                } else {
                    if ((this.bPG.SP() == 0 && i < this.mData.acO()) || (this.bPG.SP() == 1 && i < this.mData.acP())) {
                        agVar.aXK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.ba.getDrawable(com.baidu.tieba.u.icon_v), (Drawable) null);
                    } else {
                        agVar.aXK.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.bPG.SP() == 1) {
                        agVar.bPO.setVisibility(8);
                    }
                    agVar.bPT.setVisibility(8);
                    com.baidu.tbadk.core.util.ba.c(agVar.bPO, com.baidu.tbadk.core.util.c.bR(forumData.getUser_level()));
                    agVar.bPQ.setText(forumData.getSlogan());
                }
                if (this.auB) {
                    agVar.bPS.setVisibility(0);
                    agVar.bPT.setVisibility(8);
                    view2 = view3;
                } else {
                    agVar.bPS.setVisibility(8);
                    if (i < this.mData.acO() && this.aVk && !this.bOx && this.bPJ) {
                        agVar.bPT.setVisibility(0);
                        view2 = view3;
                    } else {
                        agVar.bPT.setVisibility(8);
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
        this.bPG.getLayoutMode().X(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.bPG.getLayoutMode().h(view);
    }

    public void r(View.OnClickListener onClickListener) {
        this.bPI = onClickListener;
    }

    public void y(View.OnClickListener onClickListener) {
        this.bPK = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.bDU) {
            return false;
        }
        return super.isEnabled(i);
    }
}
