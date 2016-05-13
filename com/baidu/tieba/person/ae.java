package com.baidu.tieba.person;

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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ae extends BaseAdapter {
    private boolean bJq;
    private boolean dur;
    private String dus;
    private PersonBarActivity dvQ;
    private boolean dvT;
    private View.OnClickListener dvU;
    private r mData;
    private ArrayList<ForumData> dvR = null;
    private boolean aId = false;
    private View.OnClickListener dvS = null;
    private boolean cZJ = false;

    public ae(PersonBarActivity personBarActivity, r rVar, boolean z, boolean z2) {
        this.mData = null;
        this.bJq = true;
        this.dur = false;
        this.dvT = true;
        this.dvQ = personBarActivity;
        this.mData = rVar;
        this.bJq = z;
        this.dur = z2;
        this.dvT = TbadkCoreApplication.m11getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
    }

    public void ab(ArrayList<ForumData> arrayList) {
        this.dvR = arrayList;
    }

    public void setEditState(boolean z) {
        this.aId = z;
        notifyDataSetChanged();
    }

    public boolean Ia() {
        return this.aId;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cZJ) {
            return 1;
        }
        if (this.dvR != null) {
            return this.dvR.size();
        }
        return 0;
    }

    public void atS() {
        this.cZJ = false;
        if (this.dvR == null || this.dvR.size() == 0) {
            this.cZJ = true;
        }
    }

    public boolean aBH() {
        return this.cZJ;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dvR == null || i < 0 || i >= this.dvR.size()) {
            return null;
        }
        return this.dvR.get(i);
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
                view3 = LayoutInflater.from(this.dvQ.getPageContext().getContext()).inflate(t.h.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a(this, null);
                    aVar.cEQ = (BarImageView) view3.findViewById(t.g.forum_avatar);
                    aVar.cEQ.setGifIconSupport(false);
                    aVar.cao = (TextView) view3.findViewById(t.g.name);
                    aVar.dvV = new StringBuffer(10);
                    aVar.dvW = (TextView) view3.findViewById(t.g.degree);
                    aVar.dvX = (TextView) view3.findViewById(t.g.degree_text);
                    aVar.dwb = (TextView) view3.findViewById(t.g.experience);
                    aVar.dvZ = (TextView) view3.findViewById(t.g.experience_title);
                    aVar.dwc = (Button) view3.findViewById(t.g.item_delete);
                    aVar.dvY = (ImageView) view3.findViewById(t.g.degree_text_ta);
                    aVar.dwa = (TextView) view3.findViewById(t.g.intro_ta);
                    aVar.dwd = (ImageView) view3.findViewById(t.g.item_talk);
                    aVar.cpp = (ImageView) view3.findViewById(t.g.diver_buttom_px);
                    aVar.cpp.setVisibility(0);
                    aVar.dwe = (ImageView) view3.findViewById(t.g.item_selected);
                    view3.setTag(aVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    BdLog.e(exc.getMessage());
                    u(view2);
                    return view2;
                }
            } else {
                aVar = (a) view.getTag();
                view3 = view;
            }
            if (this.cZJ) {
                aVar.dvW.setVisibility(8);
                aVar.dwc.setVisibility(8);
                aVar.cao.setVisibility(8);
                aVar.cEQ.setVisibility(8);
                aVar.dvX.setVisibility(8);
                aVar.dwb.setVisibility(8);
                aVar.dvZ.setVisibility(8);
                aVar.dvY.setVisibility(8);
                aVar.dwa.setVisibility(8);
                aVar.dwd.setVisibility(8);
                aVar.cpp.setVisibility(8);
            } else {
                aVar.cao.setVisibility(0);
                aVar.cEQ.setVisibility(0);
                if (this.bJq) {
                    aVar.dvW.setVisibility(8);
                    aVar.dvX.setVisibility(8);
                    aVar.dwb.setVisibility(0);
                    aVar.dvZ.setVisibility(0);
                    aVar.dvY.setVisibility(0);
                    aVar.dwa.setVisibility(8);
                    aVar.cpp.setVisibility(0);
                } else {
                    aVar.dvW.setVisibility(8);
                    aVar.dvX.setVisibility(8);
                    aVar.dwb.setVisibility(8);
                    aVar.dvZ.setVisibility(8);
                    aVar.dvY.setVisibility(0);
                    aVar.dwa.setVisibility(0);
                    aVar.cpp.setVisibility(0);
                }
            }
            if (this.dvR == null || i < 0 || i >= this.dvR.size() || (forumData = this.dvR.get(i)) == null) {
                view2 = view3;
            } else {
                String image_url = forumData.getImage_url();
                aVar.cEQ.setTag(image_url);
                aVar.cEQ.setImageDrawable(null);
                aVar.cEQ.c(image_url, 10, false);
                aVar.dvV.delete(0, aVar.dvV.length());
                aVar.dvV.append(forumData.getName());
                aVar.dvV.append(this.dvQ.getPageContext().getString(t.j.bar));
                aVar.cao.setText(aVar.dvV);
                if (this.bJq) {
                    com.baidu.tbadk.core.util.at.c(aVar.dvY, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.dwb.setText(String.format(this.dvQ.getPageContext().getString(t.j.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.dwc.setOnClickListener(this.dvS);
                    aVar.dwc.setTag(Integer.valueOf(i));
                    if (i < this.mData.aBx()) {
                        aVar.cao.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_v), (Drawable) null);
                        if (!this.dur && this.dvT) {
                            aVar.dwd.setVisibility(0);
                            aVar.dwd.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.cao.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.dwd.setVisibility(8);
                    }
                    aVar.dwd.setOnClickListener(this.dvU);
                    aVar.dwe.setVisibility(8);
                    if (this.dur && this.dvQ.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.dus)) {
                        aVar.dwe.setVisibility(0);
                    }
                } else {
                    if ((this.dvQ.ahN() == 0 && i < this.mData.aBx()) || (this.dvQ.ahN() == 1 && i < this.mData.aBy())) {
                        aVar.cao.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_v), (Drawable) null);
                    } else {
                        aVar.cao.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.dvQ.ahN() == 1) {
                        aVar.dvY.setVisibility(8);
                    }
                    aVar.dwd.setVisibility(8);
                    com.baidu.tbadk.core.util.at.c(aVar.dvY, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.dwa.setText(forumData.getSlogan());
                }
                if (this.aId) {
                    aVar.dwc.setVisibility(0);
                    aVar.dwd.setVisibility(8);
                    view2 = view3;
                } else {
                    aVar.dwc.setVisibility(8);
                    if (i < this.mData.aBx() && this.bJq && !this.dur && this.dvT) {
                        aVar.dwd.setVisibility(0);
                        view2 = view3;
                    } else {
                        aVar.dwd.setVisibility(8);
                        view2 = view3;
                    }
                }
            }
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
        u(view2);
        return view2;
    }

    private void u(View view) {
        this.dvQ.getLayoutMode().ae(TbadkCoreApplication.m11getInst().getSkinType() == 1);
        this.dvQ.getLayoutMode().x(view);
    }

    public void D(View.OnClickListener onClickListener) {
        this.dvS = onClickListener;
    }

    public void K(View.OnClickListener onClickListener) {
        this.dvU = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.cZJ) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void mq(String str) {
        this.dus = str;
    }

    /* loaded from: classes.dex */
    private class a {
        BarImageView cEQ;
        TextView cao;
        ImageView cpp;
        StringBuffer dvV;
        TextView dvW;
        TextView dvX;
        ImageView dvY;
        TextView dvZ;
        TextView dwa;
        TextView dwb;
        Button dwc;
        ImageView dwd;
        ImageView dwe;

        private a() {
        }

        /* synthetic */ a(ae aeVar, a aVar) {
            this();
        }
    }
}
