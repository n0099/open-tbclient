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
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class c extends BaseAdapter {
    private boolean fTQ;
    private boolean ifb;
    private String ifc;
    private boolean igB;
    private View.OnClickListener igC;
    private PersonBarActivity igz;
    private b mData;
    private ArrayList<ForumData> mForumList = null;
    private boolean cUU = false;
    private View.OnClickListener igA = null;
    private boolean hqP = false;

    public c(PersonBarActivity personBarActivity, b bVar, boolean z, boolean z2) {
        this.mData = null;
        this.fTQ = true;
        this.ifb = false;
        this.igB = true;
        this.igz = personBarActivity;
        this.mData = bVar;
        this.fTQ = z;
        this.ifb = z2;
        this.igB = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void gg(boolean z) {
        this.cUU = z;
        notifyDataSetChanged();
    }

    public boolean aBv() {
        return this.cUU;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hqP) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void bMy() {
        this.hqP = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.hqP = true;
        }
    }

    public boolean bZd() {
        return this.hqP;
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
                view3 = LayoutInflater.from(this.igz.getPageContext().getContext()).inflate(R.layout.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.hed = (BarImageView) view3.findViewById(R.id.forum_avatar);
                    aVar.hed.setGifIconSupport(false);
                    aVar.mName = (TextView) view3.findViewById(R.id.name);
                    aVar.igD = new StringBuffer(10);
                    aVar.igE = (TextView) view3.findViewById(R.id.degree);
                    aVar.igF = (TextView) view3.findViewById(R.id.degree_text);
                    aVar.igJ = (TextView) view3.findViewById(R.id.experience);
                    aVar.igH = (TextView) view3.findViewById(R.id.experience_title);
                    aVar.igK = (Button) view3.findViewById(R.id.item_delete);
                    aVar.igG = (ImageView) view3.findViewById(R.id.degree_text_ta);
                    aVar.igI = (TextView) view3.findViewById(R.id.intro_ta);
                    aVar.igL = (ImageView) view3.findViewById(R.id.item_talk);
                    aVar.gHY = (ImageView) view3.findViewById(R.id.diver_buttom_px);
                    aVar.gHY.setVisibility(0);
                    aVar.igM = (ImageView) view3.findViewById(R.id.item_selected);
                    view3.setTag(aVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    BdLog.e(exc.getMessage());
                    bX(view2);
                    return view2;
                }
            } else {
                aVar = (a) view.getTag();
                view3 = view;
            }
            if (this.hqP) {
                aVar.igE.setVisibility(8);
                aVar.igK.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.hed.setVisibility(8);
                aVar.igF.setVisibility(8);
                aVar.igJ.setVisibility(8);
                aVar.igH.setVisibility(8);
                aVar.igG.setVisibility(8);
                aVar.igI.setVisibility(8);
                aVar.igL.setVisibility(8);
                aVar.gHY.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.hed.setVisibility(0);
                if (this.fTQ) {
                    aVar.igE.setVisibility(8);
                    aVar.igF.setVisibility(8);
                    aVar.igJ.setVisibility(0);
                    aVar.igH.setVisibility(0);
                    aVar.igG.setVisibility(0);
                    aVar.igI.setVisibility(8);
                    aVar.gHY.setVisibility(0);
                } else {
                    aVar.igE.setVisibility(8);
                    aVar.igF.setVisibility(8);
                    aVar.igJ.setVisibility(8);
                    aVar.igH.setVisibility(8);
                    aVar.igG.setVisibility(0);
                    aVar.igI.setVisibility(0);
                    aVar.gHY.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.hed.setTag(image_url);
                aVar.hed.setImageDrawable(null);
                aVar.hed.startLoad(image_url, 10, false);
                aVar.igD.delete(0, aVar.igD.length());
                aVar.igD.append(forumData.getName());
                aVar.igD.append(this.igz.getPageContext().getString(R.string.forum));
                aVar.mName.setText(aVar.igD);
                if (this.fTQ) {
                    al.c(aVar.igG, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.igJ.setText(String.format(this.igz.getPageContext().getString(R.string.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.igK.setOnClickListener(this.igA);
                    aVar.igK.setTag(Integer.valueOf(i));
                    if (i < this.mData.bYS()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(R.drawable.icon_v), (Drawable) null);
                        if (!this.ifb && this.igB) {
                            aVar.igL.setVisibility(0);
                            aVar.igL.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.igL.setVisibility(8);
                    }
                    aVar.igL.setOnClickListener(this.igC);
                    aVar.igM.setVisibility(8);
                    if (this.ifb && this.igz.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.ifc)) {
                        aVar.igM.setVisibility(0);
                    }
                } else {
                    if ((this.igz.bCY() == 0 && i < this.mData.bYS()) || (this.igz.bCY() == 1 && i < this.mData.bYT())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(R.drawable.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.igz.bCY() == 1) {
                        aVar.igG.setVisibility(8);
                    }
                    aVar.igL.setVisibility(8);
                    al.c(aVar.igG, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.igI.setText(forumData.getSlogan());
                }
                if (this.cUU) {
                    aVar.igK.setVisibility(0);
                    aVar.igL.setVisibility(8);
                } else {
                    aVar.igK.setVisibility(8);
                    if (i < this.mData.bYS() && this.fTQ && !this.ifb && this.igB) {
                        aVar.igL.setVisibility(0);
                    } else {
                        aVar.igL.setVisibility(8);
                    }
                }
            }
            view2 = view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
        bX(view2);
        return view2;
    }

    private void bX(View view) {
        this.igz.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.igz.getLayoutMode().onModeChanged(view);
    }

    public void F(View.OnClickListener onClickListener) {
        this.igA = onClickListener;
    }

    public void R(View.OnClickListener onClickListener) {
        this.igC = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.hqP) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void BT(String str) {
        this.ifc = str;
    }

    /* loaded from: classes6.dex */
    private class a {
        ImageView gHY;
        BarImageView hed;
        StringBuffer igD;
        TextView igE;
        TextView igF;
        ImageView igG;
        TextView igH;
        TextView igI;
        TextView igJ;
        Button igK;
        ImageView igL;
        ImageView igM;
        TextView mName;

        private a() {
        }
    }
}
