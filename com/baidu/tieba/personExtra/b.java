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
    private boolean dxr;
    private boolean fET;
    private String fEU;
    private boolean fGA;
    private View.OnClickListener fGB;
    private PersonBarActivity fGy;
    private com.baidu.tieba.personExtra.a mData;
    private ArrayList<ForumData> mForumList = null;
    private boolean bco = false;
    private View.OnClickListener fGz = null;
    private boolean eRZ = false;

    public b(PersonBarActivity personBarActivity, com.baidu.tieba.personExtra.a aVar, boolean z, boolean z2) {
        this.mData = null;
        this.dxr = true;
        this.fET = false;
        this.fGA = true;
        this.fGy = personBarActivity;
        this.mData = aVar;
        this.dxr = z;
        this.fET = z2;
        this.fGA = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void co(boolean z) {
        this.bco = z;
        notifyDataSetChanged();
    }

    public boolean MP() {
        return this.bco;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eRZ) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void aSq() {
        this.eRZ = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.eRZ = true;
        }
    }

    public boolean bex() {
        return this.eRZ;
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
                view4 = LayoutInflater.from(this.fGy.getPageContext().getContext()).inflate(d.i.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.eBJ = (BarImageView) view4.findViewById(d.g.forum_avatar);
                    aVar.eBJ.setGifIconSupport(false);
                    aVar.mName = (TextView) view4.findViewById(d.g.name);
                    aVar.fGC = new StringBuffer(10);
                    aVar.fGD = (TextView) view4.findViewById(d.g.degree);
                    aVar.fGE = (TextView) view4.findViewById(d.g.degree_text);
                    aVar.fGI = (TextView) view4.findViewById(d.g.experience);
                    aVar.fGG = (TextView) view4.findViewById(d.g.experience_title);
                    aVar.fGJ = (Button) view4.findViewById(d.g.item_delete);
                    aVar.fGF = (ImageView) view4.findViewById(d.g.degree_text_ta);
                    aVar.fGH = (TextView) view4.findViewById(d.g.intro_ta);
                    aVar.fGK = (ImageView) view4.findViewById(d.g.item_talk);
                    aVar.egb = (ImageView) view4.findViewById(d.g.diver_buttom_px);
                    aVar.egb.setVisibility(0);
                    aVar.fGL = (ImageView) view4.findViewById(d.g.item_selected);
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
            if (this.eRZ) {
                aVar.fGD.setVisibility(8);
                aVar.fGJ.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.eBJ.setVisibility(8);
                aVar.fGE.setVisibility(8);
                aVar.fGI.setVisibility(8);
                aVar.fGG.setVisibility(8);
                aVar.fGF.setVisibility(8);
                aVar.fGH.setVisibility(8);
                aVar.fGK.setVisibility(8);
                aVar.egb.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.eBJ.setVisibility(0);
                if (this.dxr) {
                    aVar.fGD.setVisibility(8);
                    aVar.fGE.setVisibility(8);
                    aVar.fGI.setVisibility(0);
                    aVar.fGG.setVisibility(0);
                    aVar.fGF.setVisibility(0);
                    aVar.fGH.setVisibility(8);
                    aVar.egb.setVisibility(0);
                } else {
                    aVar.fGD.setVisibility(8);
                    aVar.fGE.setVisibility(8);
                    aVar.fGI.setVisibility(8);
                    aVar.fGG.setVisibility(8);
                    aVar.fGF.setVisibility(0);
                    aVar.fGH.setVisibility(0);
                    aVar.egb.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.eBJ.setTag(image_url);
                aVar.eBJ.setImageDrawable(null);
                aVar.eBJ.startLoad(image_url, 10, false);
                aVar.fGC.delete(0, aVar.fGC.length());
                aVar.fGC.append(forumData.getName());
                aVar.fGC.append(this.fGy.getPageContext().getString(d.k.forum));
                aVar.mName.setText(aVar.fGC);
                if (this.dxr) {
                    ak.c(aVar.fGF, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.fGI.setText(String.format(this.fGy.getPageContext().getString(d.k.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.fGJ.setOnClickListener(this.fGz);
                    aVar.fGJ.setTag(Integer.valueOf(i));
                    if (i < this.mData.bem()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ak.getDrawable(d.f.icon_v), (Drawable) null);
                        if (!this.fET && this.fGA) {
                            aVar.fGK.setVisibility(0);
                            aVar.fGK.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.fGK.setVisibility(8);
                    }
                    aVar.fGK.setOnClickListener(this.fGB);
                    aVar.fGL.setVisibility(8);
                    if (this.fET && this.fGy.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.fEU)) {
                        aVar.fGL.setVisibility(0);
                    }
                } else {
                    if ((this.fGy.aGl() == 0 && i < this.mData.bem()) || (this.fGy.aGl() == 1 && i < this.mData.ben())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ak.getDrawable(d.f.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.fGy.aGl() == 1) {
                        aVar.fGF.setVisibility(8);
                    }
                    aVar.fGK.setVisibility(8);
                    ak.c(aVar.fGF, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.fGH.setText(forumData.getSlogan());
                }
                if (this.bco) {
                    aVar.fGJ.setVisibility(0);
                    aVar.fGK.setVisibility(8);
                } else {
                    aVar.fGJ.setVisibility(8);
                    if (i < this.mData.bem() && this.dxr && !this.fET && this.fGA) {
                        aVar.fGK.setVisibility(0);
                    } else {
                        aVar.fGK.setVisibility(8);
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
        this.fGy.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.fGy.getLayoutMode().u(view2);
    }

    public void z(View.OnClickListener onClickListener) {
        this.fGz = onClickListener;
    }

    public void M(View.OnClickListener onClickListener) {
        this.fGB = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.eRZ) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void rf(String str) {
        this.fEU = str;
    }

    /* loaded from: classes3.dex */
    private class a {
        BarImageView eBJ;
        ImageView egb;
        StringBuffer fGC;
        TextView fGD;
        TextView fGE;
        ImageView fGF;
        TextView fGG;
        TextView fGH;
        TextView fGI;
        Button fGJ;
        ImageView fGK;
        ImageView fGL;
        TextView mName;

        private a() {
        }
    }
}
