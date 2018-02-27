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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class e extends BaseAdapter {
    private boolean ecy;
    private boolean gkj;
    private String gkk;
    private PersonBarActivity glO;
    private boolean glQ;
    private View.OnClickListener glR;
    private c mData;
    private ArrayList<ForumData> mForumList = null;
    private boolean bSh = false;
    private View.OnClickListener glP = null;
    private boolean fxc = false;

    public e(PersonBarActivity personBarActivity, c cVar, boolean z, boolean z2) {
        this.mData = null;
        this.ecy = true;
        this.gkj = false;
        this.glQ = true;
        this.glO = personBarActivity;
        this.mData = cVar;
        this.ecy = z;
        this.gkj = z2;
        this.glQ = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void cX(boolean z) {
        this.bSh = z;
        notifyDataSetChanged();
    }

    public boolean Un() {
        return this.bSh;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fxc) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void aXu() {
        this.fxc = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.fxc = true;
        }
    }

    public boolean bju() {
        return this.fxc;
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
                view3 = LayoutInflater.from(this.glO.getPageContext().getContext()).inflate(d.h.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.fgT = (BarImageView) view3.findViewById(d.g.forum_avatar);
                    aVar.fgT.setGifIconSupport(false);
                    aVar.mName = (TextView) view3.findViewById(d.g.name);
                    aVar.glS = new StringBuffer(10);
                    aVar.glT = (TextView) view3.findViewById(d.g.degree);
                    aVar.glU = (TextView) view3.findViewById(d.g.degree_text);
                    aVar.glY = (TextView) view3.findViewById(d.g.experience);
                    aVar.glW = (TextView) view3.findViewById(d.g.experience_title);
                    aVar.glZ = (Button) view3.findViewById(d.g.item_delete);
                    aVar.glV = (ImageView) view3.findViewById(d.g.degree_text_ta);
                    aVar.glX = (TextView) view3.findViewById(d.g.intro_ta);
                    aVar.gma = (ImageView) view3.findViewById(d.g.item_talk);
                    aVar.eLi = (ImageView) view3.findViewById(d.g.diver_buttom_px);
                    aVar.eLi.setVisibility(0);
                    aVar.gmb = (ImageView) view3.findViewById(d.g.item_selected);
                    view3.setTag(aVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    BdLog.e(exc.getMessage());
                    bU(view2);
                    return view2;
                }
            } else {
                aVar = (a) view.getTag();
                view3 = view;
            }
            if (this.fxc) {
                aVar.glT.setVisibility(8);
                aVar.glZ.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.fgT.setVisibility(8);
                aVar.glU.setVisibility(8);
                aVar.glY.setVisibility(8);
                aVar.glW.setVisibility(8);
                aVar.glV.setVisibility(8);
                aVar.glX.setVisibility(8);
                aVar.gma.setVisibility(8);
                aVar.eLi.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.fgT.setVisibility(0);
                if (this.ecy) {
                    aVar.glT.setVisibility(8);
                    aVar.glU.setVisibility(8);
                    aVar.glY.setVisibility(0);
                    aVar.glW.setVisibility(0);
                    aVar.glV.setVisibility(0);
                    aVar.glX.setVisibility(8);
                    aVar.eLi.setVisibility(0);
                } else {
                    aVar.glT.setVisibility(8);
                    aVar.glU.setVisibility(8);
                    aVar.glY.setVisibility(8);
                    aVar.glW.setVisibility(8);
                    aVar.glV.setVisibility(0);
                    aVar.glX.setVisibility(0);
                    aVar.eLi.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.fgT.setTag(image_url);
                aVar.fgT.setImageDrawable(null);
                aVar.fgT.startLoad(image_url, 10, false);
                aVar.glS.delete(0, aVar.glS.length());
                aVar.glS.append(forumData.getName());
                aVar.glS.append(this.glO.getPageContext().getString(d.j.forum));
                aVar.mName.setText(aVar.glS);
                if (this.ecy) {
                    aj.c(aVar.glV, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.glY.setText(String.format(this.glO.getPageContext().getString(d.j.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.glZ.setOnClickListener(this.glP);
                    aVar.glZ.setTag(Integer.valueOf(i));
                    if (i < this.mData.bjj()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_v), (Drawable) null);
                        if (!this.gkj && this.glQ) {
                            aVar.gma.setVisibility(0);
                            aVar.gma.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.gma.setVisibility(8);
                    }
                    aVar.gma.setOnClickListener(this.glR);
                    aVar.gmb.setVisibility(8);
                    if (this.gkj && this.glO.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.gkk)) {
                        aVar.gmb.setVisibility(0);
                    }
                } else {
                    if ((this.glO.aLn() == 0 && i < this.mData.bjj()) || (this.glO.aLn() == 1 && i < this.mData.bjk())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.glO.aLn() == 1) {
                        aVar.glV.setVisibility(8);
                    }
                    aVar.gma.setVisibility(8);
                    aj.c(aVar.glV, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.glX.setText(forumData.getSlogan());
                }
                if (this.bSh) {
                    aVar.glZ.setVisibility(0);
                    aVar.gma.setVisibility(8);
                } else {
                    aVar.glZ.setVisibility(8);
                    if (i < this.mData.bjj() && this.ecy && !this.gkj && this.glQ) {
                        aVar.gma.setVisibility(0);
                    } else {
                        aVar.gma.setVisibility(8);
                    }
                }
            }
            view2 = view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
        bU(view2);
        return view2;
    }

    private void bU(View view) {
        this.glO.getLayoutMode().aQ(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.glO.getLayoutMode().aM(view);
    }

    public void y(View.OnClickListener onClickListener) {
        this.glP = onClickListener;
    }

    public void L(View.OnClickListener onClickListener) {
        this.glR = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fxc) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void qZ(String str) {
        this.gkk = str;
    }

    /* loaded from: classes3.dex */
    private class a {
        ImageView eLi;
        BarImageView fgT;
        StringBuffer glS;
        TextView glT;
        TextView glU;
        ImageView glV;
        TextView glW;
        TextView glX;
        TextView glY;
        Button glZ;
        ImageView gma;
        ImageView gmb;
        TextView mName;

        private a() {
        }
    }
}
