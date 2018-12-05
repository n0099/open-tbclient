package com.baidu.tieba.personExtra;

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
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private boolean eni;
    private boolean gsO;
    private String gsP;
    private View.OnClickListener guA;
    private PersonBarActivity gux;
    private boolean guz;
    private com.baidu.tieba.personExtra.a mData;
    private ArrayList<ForumData> mForumList = null;
    private boolean bAL = false;
    private View.OnClickListener guy = null;
    private boolean fFM = false;

    public b(PersonBarActivity personBarActivity, com.baidu.tieba.personExtra.a aVar, boolean z, boolean z2) {
        this.mData = null;
        this.eni = true;
        this.gsO = false;
        this.guz = true;
        this.gux = personBarActivity;
        this.mData = aVar;
        this.eni = z;
        this.gsO = z2;
        this.guz = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void dq(boolean z) {
        this.bAL = z;
        notifyDataSetChanged();
    }

    public boolean VU() {
        return this.bAL;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fFM) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void bda() {
        this.fFM = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.fFM = true;
        }
    }

    public boolean bpt() {
        return this.fFM;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mForumList == null || i < 0 || i >= this.mForumList.size()) {
            return null;
        }
        return this.mForumList.get(i);
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
                view3 = LayoutInflater.from(this.gux.getPageContext().getContext()).inflate(e.h.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.ftg = (BarImageView) view3.findViewById(e.g.forum_avatar);
                    aVar.ftg.setGifIconSupport(false);
                    aVar.mName = (TextView) view3.findViewById(e.g.name);
                    aVar.guB = new StringBuffer(10);
                    aVar.guC = (TextView) view3.findViewById(e.g.degree);
                    aVar.guD = (TextView) view3.findViewById(e.g.degree_text);
                    aVar.guH = (TextView) view3.findViewById(e.g.experience);
                    aVar.guF = (TextView) view3.findViewById(e.g.experience_title);
                    aVar.guI = (Button) view3.findViewById(e.g.item_delete);
                    aVar.guE = (ImageView) view3.findViewById(e.g.degree_text_ta);
                    aVar.guG = (TextView) view3.findViewById(e.g.intro_ta);
                    aVar.guJ = (ImageView) view3.findViewById(e.g.item_talk);
                    aVar.eXm = (ImageView) view3.findViewById(e.g.diver_buttom_px);
                    aVar.eXm.setVisibility(0);
                    aVar.guK = (ImageView) view3.findViewById(e.g.item_selected);
                    view3.setTag(aVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    BdLog.e(exc.getMessage());
                    aY(view2);
                    return view2;
                }
            } else {
                aVar = (a) view.getTag();
                view3 = view;
            }
            if (this.fFM) {
                aVar.guC.setVisibility(8);
                aVar.guI.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.ftg.setVisibility(8);
                aVar.guD.setVisibility(8);
                aVar.guH.setVisibility(8);
                aVar.guF.setVisibility(8);
                aVar.guE.setVisibility(8);
                aVar.guG.setVisibility(8);
                aVar.guJ.setVisibility(8);
                aVar.eXm.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.ftg.setVisibility(0);
                if (this.eni) {
                    aVar.guC.setVisibility(8);
                    aVar.guD.setVisibility(8);
                    aVar.guH.setVisibility(0);
                    aVar.guF.setVisibility(0);
                    aVar.guE.setVisibility(0);
                    aVar.guG.setVisibility(8);
                    aVar.eXm.setVisibility(0);
                } else {
                    aVar.guC.setVisibility(8);
                    aVar.guD.setVisibility(8);
                    aVar.guH.setVisibility(8);
                    aVar.guF.setVisibility(8);
                    aVar.guE.setVisibility(0);
                    aVar.guG.setVisibility(0);
                    aVar.eXm.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.ftg.setTag(image_url);
                aVar.ftg.setImageDrawable(null);
                aVar.ftg.startLoad(image_url, 10, false);
                aVar.guB.delete(0, aVar.guB.length());
                aVar.guB.append(forumData.getName());
                aVar.guB.append(this.gux.getPageContext().getString(e.j.forum));
                aVar.mName.setText(aVar.guB);
                if (this.eni) {
                    al.c(aVar.guE, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.guH.setText(String.format(this.gux.getPageContext().getString(e.j.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.guI.setOnClickListener(this.guy);
                    aVar.guI.setTag(Integer.valueOf(i));
                    if (i < this.mData.bpi()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_v), (Drawable) null);
                        if (!this.gsO && this.guz) {
                            aVar.guJ.setVisibility(0);
                            aVar.guJ.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.guJ.setVisibility(8);
                    }
                    aVar.guJ.setOnClickListener(this.guA);
                    aVar.guK.setVisibility(8);
                    if (this.gsO && this.gux.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.gsP)) {
                        aVar.guK.setVisibility(0);
                    }
                } else {
                    if ((this.gux.aTA() == 0 && i < this.mData.bpi()) || (this.gux.aTA() == 1 && i < this.mData.bpj())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.gux.aTA() == 1) {
                        aVar.guE.setVisibility(8);
                    }
                    aVar.guJ.setVisibility(8);
                    al.c(aVar.guE, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.guG.setText(forumData.getSlogan());
                }
                if (this.bAL) {
                    aVar.guI.setVisibility(0);
                    aVar.guJ.setVisibility(8);
                } else {
                    aVar.guI.setVisibility(8);
                    if (i < this.mData.bpi() && this.eni && !this.gsO && this.guz) {
                        aVar.guJ.setVisibility(0);
                    } else {
                        aVar.guJ.setVisibility(8);
                    }
                }
            }
            view2 = view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
        aY(view2);
        return view2;
    }

    private void aY(View view) {
        this.gux.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gux.getLayoutMode().onModeChanged(view);
    }

    public void C(View.OnClickListener onClickListener) {
        this.guy = onClickListener;
    }

    public void P(View.OnClickListener onClickListener) {
        this.guA = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fFM) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void tG(String str) {
        this.gsP = str;
    }

    /* loaded from: classes3.dex */
    private class a {
        ImageView eXm;
        BarImageView ftg;
        StringBuffer guB;
        TextView guC;
        TextView guD;
        ImageView guE;
        TextView guF;
        TextView guG;
        TextView guH;
        Button guI;
        ImageView guJ;
        ImageView guK;
        TextView mName;

        private a() {
        }
    }
}
