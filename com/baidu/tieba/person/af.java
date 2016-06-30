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
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class af extends BaseAdapter {
    private boolean chd;
    private boolean ecI;
    private String ecJ;
    private PersonBarActivity eei;
    private boolean eel;
    private View.OnClickListener eem;
    private s mData;
    private ArrayList<ForumData> eej = null;
    private boolean aLA = false;
    private View.OnClickListener eek = null;
    private boolean dGr = false;

    public af(PersonBarActivity personBarActivity, s sVar, boolean z, boolean z2) {
        this.mData = null;
        this.chd = true;
        this.ecI = false;
        this.eel = true;
        this.eei = personBarActivity;
        this.mData = sVar;
        this.chd = z;
        this.ecI = z2;
        this.eel = TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
    }

    public void am(ArrayList<ForumData> arrayList) {
        this.eej = arrayList;
    }

    public void setEditState(boolean z) {
        this.aLA = z;
        notifyDataSetChanged();
    }

    public boolean IZ() {
        return this.aLA;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dGr) {
            return 1;
        }
        if (this.eej != null) {
            return this.eej.size();
        }
        return 0;
    }

    public void aBX() {
        this.dGr = false;
        if (this.eej == null || this.eej.size() == 0) {
            this.dGr = true;
        }
    }

    public boolean aKz() {
        return this.dGr;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eej == null || i < 0 || i >= this.eej.size()) {
            return null;
        }
        return this.eej.get(i);
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
                view3 = LayoutInflater.from(this.eei.getPageContext().getContext()).inflate(u.h.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a(this, null);
                    aVar.bdw = (BarImageView) view3.findViewById(u.g.forum_avatar);
                    aVar.bdw.setGifIconSupport(false);
                    aVar.cFy = (TextView) view3.findViewById(u.g.name);
                    aVar.een = new StringBuffer(10);
                    aVar.eeo = (TextView) view3.findViewById(u.g.degree);
                    aVar.eep = (TextView) view3.findViewById(u.g.degree_text);
                    aVar.eet = (TextView) view3.findViewById(u.g.experience);
                    aVar.eer = (TextView) view3.findViewById(u.g.experience_title);
                    aVar.eeu = (Button) view3.findViewById(u.g.item_delete);
                    aVar.eeq = (ImageView) view3.findViewById(u.g.degree_text_ta);
                    aVar.ees = (TextView) view3.findViewById(u.g.intro_ta);
                    aVar.eev = (ImageView) view3.findViewById(u.g.item_talk);
                    aVar.cUF = (ImageView) view3.findViewById(u.g.diver_buttom_px);
                    aVar.cUF.setVisibility(0);
                    aVar.eew = (ImageView) view3.findViewById(u.g.item_selected);
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
            if (this.dGr) {
                aVar.eeo.setVisibility(8);
                aVar.eeu.setVisibility(8);
                aVar.cFy.setVisibility(8);
                aVar.bdw.setVisibility(8);
                aVar.eep.setVisibility(8);
                aVar.eet.setVisibility(8);
                aVar.eer.setVisibility(8);
                aVar.eeq.setVisibility(8);
                aVar.ees.setVisibility(8);
                aVar.eev.setVisibility(8);
                aVar.cUF.setVisibility(8);
            } else {
                aVar.cFy.setVisibility(0);
                aVar.bdw.setVisibility(0);
                if (this.chd) {
                    aVar.eeo.setVisibility(8);
                    aVar.eep.setVisibility(8);
                    aVar.eet.setVisibility(0);
                    aVar.eer.setVisibility(0);
                    aVar.eeq.setVisibility(0);
                    aVar.ees.setVisibility(8);
                    aVar.cUF.setVisibility(0);
                } else {
                    aVar.eeo.setVisibility(8);
                    aVar.eep.setVisibility(8);
                    aVar.eet.setVisibility(8);
                    aVar.eer.setVisibility(8);
                    aVar.eeq.setVisibility(0);
                    aVar.ees.setVisibility(0);
                    aVar.cUF.setVisibility(0);
                }
            }
            if (this.eej == null || i < 0 || i >= this.eej.size() || (forumData = this.eej.get(i)) == null) {
                view2 = view3;
            } else {
                String image_url = forumData.getImage_url();
                aVar.bdw.setTag(image_url);
                aVar.bdw.setImageDrawable(null);
                aVar.bdw.c(image_url, 10, false);
                aVar.een.delete(0, aVar.een.length());
                aVar.een.append(forumData.getName());
                aVar.een.append(this.eei.getPageContext().getString(u.j.bar));
                aVar.cFy.setText(aVar.een);
                if (this.chd) {
                    com.baidu.tbadk.core.util.av.c(aVar.eeq, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.eet.setText(String.format(this.eei.getPageContext().getString(u.j.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.eeu.setOnClickListener(this.eek);
                    aVar.eeu.setTag(Integer.valueOf(i));
                    if (i < this.mData.aKp()) {
                        aVar.cFy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.av.getDrawable(u.f.icon_v), (Drawable) null);
                        if (!this.ecI && this.eel) {
                            aVar.eev.setVisibility(0);
                            aVar.eev.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.cFy.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.eev.setVisibility(8);
                    }
                    aVar.eev.setOnClickListener(this.eem);
                    aVar.eew.setVisibility(8);
                    if (this.ecI && this.eei.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.ecJ)) {
                        aVar.eew.setVisibility(0);
                    }
                } else {
                    if ((this.eei.aqa() == 0 && i < this.mData.aKp()) || (this.eei.aqa() == 1 && i < this.mData.aKq())) {
                        aVar.cFy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.av.getDrawable(u.f.icon_v), (Drawable) null);
                    } else {
                        aVar.cFy.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.eei.aqa() == 1) {
                        aVar.eeq.setVisibility(8);
                    }
                    aVar.eev.setVisibility(8);
                    com.baidu.tbadk.core.util.av.c(aVar.eeq, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.ees.setText(forumData.getSlogan());
                }
                if (this.aLA) {
                    aVar.eeu.setVisibility(0);
                    aVar.eev.setVisibility(8);
                    view2 = view3;
                } else {
                    aVar.eeu.setVisibility(8);
                    if (i < this.mData.aKp() && this.chd && !this.ecI && this.eel) {
                        aVar.eev.setVisibility(0);
                        view2 = view3;
                    } else {
                        aVar.eev.setVisibility(8);
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
        this.eei.getLayoutMode().ad(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.eei.getLayoutMode().w(view);
    }

    public void D(View.OnClickListener onClickListener) {
        this.eek = onClickListener;
    }

    public void K(View.OnClickListener onClickListener) {
        this.eem = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.dGr) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void nV(String str) {
        this.ecJ = str;
    }

    /* loaded from: classes.dex */
    private class a {
        BarImageView bdw;
        TextView cFy;
        ImageView cUF;
        StringBuffer een;
        TextView eeo;
        TextView eep;
        ImageView eeq;
        TextView eer;
        TextView ees;
        TextView eet;
        Button eeu;
        ImageView eev;
        ImageView eew;

        private a() {
        }

        /* synthetic */ a(af afVar, a aVar) {
            this();
        }
    }
}
