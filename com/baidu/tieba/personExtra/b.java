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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private boolean dyy;
    private boolean fFZ;
    private String fGa;
    private PersonBarActivity fHE;
    private boolean fHG;
    private View.OnClickListener fHH;
    private com.baidu.tieba.personExtra.a mData;
    private ArrayList<ForumData> mForumList = null;
    private boolean bcp = false;
    private View.OnClickListener fHF = null;
    private boolean eTg = false;

    public b(PersonBarActivity personBarActivity, com.baidu.tieba.personExtra.a aVar, boolean z, boolean z2) {
        this.mData = null;
        this.dyy = true;
        this.fFZ = false;
        this.fHG = true;
        this.fHE = personBarActivity;
        this.mData = aVar;
        this.dyy = z;
        this.fFZ = z2;
        this.fHG = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void co(boolean z) {
        this.bcp = z;
        notifyDataSetChanged();
    }

    public boolean MN() {
        return this.bcp;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eTg) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void aSq() {
        this.eTg = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.eTg = true;
        }
    }

    public boolean bex() {
        return this.eTg;
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
    public View getView(int i, View view2, ViewGroup viewGroup) {
        Exception exc;
        View view3;
        a aVar;
        View view4;
        ForumData forumData;
        try {
            if (view2 == null) {
                view4 = LayoutInflater.from(this.fHE.getPageContext().getContext()).inflate(d.i.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.eCR = (BarImageView) view4.findViewById(d.g.forum_avatar);
                    aVar.eCR.setGifIconSupport(false);
                    aVar.mName = (TextView) view4.findViewById(d.g.name);
                    aVar.fHI = new StringBuffer(10);
                    aVar.fHJ = (TextView) view4.findViewById(d.g.degree);
                    aVar.fHK = (TextView) view4.findViewById(d.g.degree_text);
                    aVar.fHO = (TextView) view4.findViewById(d.g.experience);
                    aVar.fHM = (TextView) view4.findViewById(d.g.experience_title);
                    aVar.fHP = (Button) view4.findViewById(d.g.item_delete);
                    aVar.fHL = (ImageView) view4.findViewById(d.g.degree_text_ta);
                    aVar.fHN = (TextView) view4.findViewById(d.g.intro_ta);
                    aVar.fHQ = (ImageView) view4.findViewById(d.g.item_talk);
                    aVar.ehi = (ImageView) view4.findViewById(d.g.diver_buttom_px);
                    aVar.ehi.setVisibility(0);
                    aVar.fHR = (ImageView) view4.findViewById(d.g.item_selected);
                    view4.setTag(aVar);
                } catch (Exception e) {
                    view3 = view4;
                    exc = e;
                    BdLog.e(exc.getMessage());
                    aA(view3);
                    return view3;
                }
            } else {
                aVar = (a) view2.getTag();
                view4 = view2;
            }
            if (this.eTg) {
                aVar.fHJ.setVisibility(8);
                aVar.fHP.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.eCR.setVisibility(8);
                aVar.fHK.setVisibility(8);
                aVar.fHO.setVisibility(8);
                aVar.fHM.setVisibility(8);
                aVar.fHL.setVisibility(8);
                aVar.fHN.setVisibility(8);
                aVar.fHQ.setVisibility(8);
                aVar.ehi.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.eCR.setVisibility(0);
                if (this.dyy) {
                    aVar.fHJ.setVisibility(8);
                    aVar.fHK.setVisibility(8);
                    aVar.fHO.setVisibility(0);
                    aVar.fHM.setVisibility(0);
                    aVar.fHL.setVisibility(0);
                    aVar.fHN.setVisibility(8);
                    aVar.ehi.setVisibility(0);
                } else {
                    aVar.fHJ.setVisibility(8);
                    aVar.fHK.setVisibility(8);
                    aVar.fHO.setVisibility(8);
                    aVar.fHM.setVisibility(8);
                    aVar.fHL.setVisibility(0);
                    aVar.fHN.setVisibility(0);
                    aVar.ehi.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.eCR.setTag(image_url);
                aVar.eCR.setImageDrawable(null);
                aVar.eCR.startLoad(image_url, 10, false);
                aVar.fHI.delete(0, aVar.fHI.length());
                aVar.fHI.append(forumData.getName());
                aVar.fHI.append(this.fHE.getPageContext().getString(d.k.forum));
                aVar.mName.setText(aVar.fHI);
                if (this.dyy) {
                    ak.c(aVar.fHL, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.fHO.setText(String.format(this.fHE.getPageContext().getString(d.k.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.fHP.setOnClickListener(this.fHF);
                    aVar.fHP.setTag(Integer.valueOf(i));
                    if (i < this.mData.bem()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ak.getDrawable(d.f.icon_v), (Drawable) null);
                        if (!this.fFZ && this.fHG) {
                            aVar.fHQ.setVisibility(0);
                            aVar.fHQ.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.fHQ.setVisibility(8);
                    }
                    aVar.fHQ.setOnClickListener(this.fHH);
                    aVar.fHR.setVisibility(8);
                    if (this.fFZ && this.fHE.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.fGa)) {
                        aVar.fHR.setVisibility(0);
                    }
                } else {
                    if ((this.fHE.aGj() == 0 && i < this.mData.bem()) || (this.fHE.aGj() == 1 && i < this.mData.ben())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ak.getDrawable(d.f.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.fHE.aGj() == 1) {
                        aVar.fHL.setVisibility(8);
                    }
                    aVar.fHQ.setVisibility(8);
                    ak.c(aVar.fHL, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.fHN.setText(forumData.getSlogan());
                }
                if (this.bcp) {
                    aVar.fHP.setVisibility(0);
                    aVar.fHQ.setVisibility(8);
                } else {
                    aVar.fHP.setVisibility(8);
                    if (i < this.mData.bem() && this.dyy && !this.fFZ && this.fHG) {
                        aVar.fHQ.setVisibility(0);
                    } else {
                        aVar.fHQ.setVisibility(8);
                    }
                }
            }
            view3 = view4;
        } catch (Exception e2) {
            exc = e2;
            view3 = view2;
        }
        aA(view3);
        return view3;
    }

    private void aA(View view2) {
        this.fHE.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.fHE.getLayoutMode().u(view2);
    }

    public void z(View.OnClickListener onClickListener) {
        this.fHF = onClickListener;
    }

    public void M(View.OnClickListener onClickListener) {
        this.fHH = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.eTg) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void ri(String str) {
        this.fGa = str;
    }

    /* loaded from: classes3.dex */
    private class a {
        BarImageView eCR;
        ImageView ehi;
        StringBuffer fHI;
        TextView fHJ;
        TextView fHK;
        ImageView fHL;
        TextView fHM;
        TextView fHN;
        TextView fHO;
        Button fHP;
        ImageView fHQ;
        ImageView fHR;
        TextView mName;

        private a() {
        }
    }
}
