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
    private boolean dxu;
    private boolean fEW;
    private String fEX;
    private PersonBarActivity fGB;
    private boolean fGD;
    private View.OnClickListener fGE;
    private com.baidu.tieba.personExtra.a mData;
    private ArrayList<ForumData> mForumList = null;
    private boolean bco = false;
    private View.OnClickListener fGC = null;
    private boolean eSc = false;

    public b(PersonBarActivity personBarActivity, com.baidu.tieba.personExtra.a aVar, boolean z, boolean z2) {
        this.mData = null;
        this.dxu = true;
        this.fEW = false;
        this.fGD = true;
        this.fGB = personBarActivity;
        this.mData = aVar;
        this.dxu = z;
        this.fEW = z2;
        this.fGD = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
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
        if (this.eSc) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void aSq() {
        this.eSc = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.eSc = true;
        }
    }

    public boolean bex() {
        return this.eSc;
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
                view4 = LayoutInflater.from(this.fGB.getPageContext().getContext()).inflate(d.i.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.eBM = (BarImageView) view4.findViewById(d.g.forum_avatar);
                    aVar.eBM.setGifIconSupport(false);
                    aVar.mName = (TextView) view4.findViewById(d.g.name);
                    aVar.fGF = new StringBuffer(10);
                    aVar.fGG = (TextView) view4.findViewById(d.g.degree);
                    aVar.fGH = (TextView) view4.findViewById(d.g.degree_text);
                    aVar.fGL = (TextView) view4.findViewById(d.g.experience);
                    aVar.fGJ = (TextView) view4.findViewById(d.g.experience_title);
                    aVar.fGM = (Button) view4.findViewById(d.g.item_delete);
                    aVar.fGI = (ImageView) view4.findViewById(d.g.degree_text_ta);
                    aVar.fGK = (TextView) view4.findViewById(d.g.intro_ta);
                    aVar.fGN = (ImageView) view4.findViewById(d.g.item_talk);
                    aVar.ege = (ImageView) view4.findViewById(d.g.diver_buttom_px);
                    aVar.ege.setVisibility(0);
                    aVar.fGO = (ImageView) view4.findViewById(d.g.item_selected);
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
            if (this.eSc) {
                aVar.fGG.setVisibility(8);
                aVar.fGM.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.eBM.setVisibility(8);
                aVar.fGH.setVisibility(8);
                aVar.fGL.setVisibility(8);
                aVar.fGJ.setVisibility(8);
                aVar.fGI.setVisibility(8);
                aVar.fGK.setVisibility(8);
                aVar.fGN.setVisibility(8);
                aVar.ege.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.eBM.setVisibility(0);
                if (this.dxu) {
                    aVar.fGG.setVisibility(8);
                    aVar.fGH.setVisibility(8);
                    aVar.fGL.setVisibility(0);
                    aVar.fGJ.setVisibility(0);
                    aVar.fGI.setVisibility(0);
                    aVar.fGK.setVisibility(8);
                    aVar.ege.setVisibility(0);
                } else {
                    aVar.fGG.setVisibility(8);
                    aVar.fGH.setVisibility(8);
                    aVar.fGL.setVisibility(8);
                    aVar.fGJ.setVisibility(8);
                    aVar.fGI.setVisibility(0);
                    aVar.fGK.setVisibility(0);
                    aVar.ege.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.eBM.setTag(image_url);
                aVar.eBM.setImageDrawable(null);
                aVar.eBM.startLoad(image_url, 10, false);
                aVar.fGF.delete(0, aVar.fGF.length());
                aVar.fGF.append(forumData.getName());
                aVar.fGF.append(this.fGB.getPageContext().getString(d.k.forum));
                aVar.mName.setText(aVar.fGF);
                if (this.dxu) {
                    ak.c(aVar.fGI, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.fGL.setText(String.format(this.fGB.getPageContext().getString(d.k.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.fGM.setOnClickListener(this.fGC);
                    aVar.fGM.setTag(Integer.valueOf(i));
                    if (i < this.mData.bem()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ak.getDrawable(d.f.icon_v), (Drawable) null);
                        if (!this.fEW && this.fGD) {
                            aVar.fGN.setVisibility(0);
                            aVar.fGN.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.fGN.setVisibility(8);
                    }
                    aVar.fGN.setOnClickListener(this.fGE);
                    aVar.fGO.setVisibility(8);
                    if (this.fEW && this.fGB.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.fEX)) {
                        aVar.fGO.setVisibility(0);
                    }
                } else {
                    if ((this.fGB.aGl() == 0 && i < this.mData.bem()) || (this.fGB.aGl() == 1 && i < this.mData.ben())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ak.getDrawable(d.f.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.fGB.aGl() == 1) {
                        aVar.fGI.setVisibility(8);
                    }
                    aVar.fGN.setVisibility(8);
                    ak.c(aVar.fGI, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.fGK.setText(forumData.getSlogan());
                }
                if (this.bco) {
                    aVar.fGM.setVisibility(0);
                    aVar.fGN.setVisibility(8);
                } else {
                    aVar.fGM.setVisibility(8);
                    if (i < this.mData.bem() && this.dxu && !this.fEW && this.fGD) {
                        aVar.fGN.setVisibility(0);
                    } else {
                        aVar.fGN.setVisibility(8);
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
        this.fGB.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.fGB.getLayoutMode().u(view2);
    }

    public void z(View.OnClickListener onClickListener) {
        this.fGC = onClickListener;
    }

    public void M(View.OnClickListener onClickListener) {
        this.fGE = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.eSc) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void rf(String str) {
        this.fEX = str;
    }

    /* loaded from: classes3.dex */
    private class a {
        BarImageView eBM;
        ImageView ege;
        StringBuffer fGF;
        TextView fGG;
        TextView fGH;
        ImageView fGI;
        TextView fGJ;
        TextView fGK;
        TextView fGL;
        Button fGM;
        ImageView fGN;
        ImageView fGO;
        TextView mName;

        private a() {
        }
    }
}
