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
    private boolean fTR;
    private boolean ife;
    private String iff;
    private PersonBarActivity igC;
    private boolean igE;
    private View.OnClickListener igF;
    private b mData;
    private ArrayList<ForumData> mForumList = null;
    private boolean cUV = false;
    private View.OnClickListener igD = null;
    private boolean hqS = false;

    public c(PersonBarActivity personBarActivity, b bVar, boolean z, boolean z2) {
        this.mData = null;
        this.fTR = true;
        this.ife = false;
        this.igE = true;
        this.igC = personBarActivity;
        this.mData = bVar;
        this.fTR = z;
        this.ife = z2;
        this.igE = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void gg(boolean z) {
        this.cUV = z;
        notifyDataSetChanged();
    }

    public boolean aBy() {
        return this.cUV;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hqS) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void bMB() {
        this.hqS = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.hqS = true;
        }
    }

    public boolean bZg() {
        return this.hqS;
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
                view3 = LayoutInflater.from(this.igC.getPageContext().getContext()).inflate(R.layout.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.heg = (BarImageView) view3.findViewById(R.id.forum_avatar);
                    aVar.heg.setGifIconSupport(false);
                    aVar.mName = (TextView) view3.findViewById(R.id.name);
                    aVar.igG = new StringBuffer(10);
                    aVar.igH = (TextView) view3.findViewById(R.id.degree);
                    aVar.igI = (TextView) view3.findViewById(R.id.degree_text);
                    aVar.igM = (TextView) view3.findViewById(R.id.experience);
                    aVar.igK = (TextView) view3.findViewById(R.id.experience_title);
                    aVar.igN = (Button) view3.findViewById(R.id.item_delete);
                    aVar.igJ = (ImageView) view3.findViewById(R.id.degree_text_ta);
                    aVar.igL = (TextView) view3.findViewById(R.id.intro_ta);
                    aVar.igO = (ImageView) view3.findViewById(R.id.item_talk);
                    aVar.gHZ = (ImageView) view3.findViewById(R.id.diver_buttom_px);
                    aVar.gHZ.setVisibility(0);
                    aVar.igP = (ImageView) view3.findViewById(R.id.item_selected);
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
            if (this.hqS) {
                aVar.igH.setVisibility(8);
                aVar.igN.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.heg.setVisibility(8);
                aVar.igI.setVisibility(8);
                aVar.igM.setVisibility(8);
                aVar.igK.setVisibility(8);
                aVar.igJ.setVisibility(8);
                aVar.igL.setVisibility(8);
                aVar.igO.setVisibility(8);
                aVar.gHZ.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.heg.setVisibility(0);
                if (this.fTR) {
                    aVar.igH.setVisibility(8);
                    aVar.igI.setVisibility(8);
                    aVar.igM.setVisibility(0);
                    aVar.igK.setVisibility(0);
                    aVar.igJ.setVisibility(0);
                    aVar.igL.setVisibility(8);
                    aVar.gHZ.setVisibility(0);
                } else {
                    aVar.igH.setVisibility(8);
                    aVar.igI.setVisibility(8);
                    aVar.igM.setVisibility(8);
                    aVar.igK.setVisibility(8);
                    aVar.igJ.setVisibility(0);
                    aVar.igL.setVisibility(0);
                    aVar.gHZ.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.heg.setTag(image_url);
                aVar.heg.setImageDrawable(null);
                aVar.heg.startLoad(image_url, 10, false);
                aVar.igG.delete(0, aVar.igG.length());
                aVar.igG.append(forumData.getName());
                aVar.igG.append(this.igC.getPageContext().getString(R.string.forum));
                aVar.mName.setText(aVar.igG);
                if (this.fTR) {
                    al.c(aVar.igJ, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.igM.setText(String.format(this.igC.getPageContext().getString(R.string.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.igN.setOnClickListener(this.igD);
                    aVar.igN.setTag(Integer.valueOf(i));
                    if (i < this.mData.bYV()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(R.drawable.icon_v), (Drawable) null);
                        if (!this.ife && this.igE) {
                            aVar.igO.setVisibility(0);
                            aVar.igO.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.igO.setVisibility(8);
                    }
                    aVar.igO.setOnClickListener(this.igF);
                    aVar.igP.setVisibility(8);
                    if (this.ife && this.igC.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.iff)) {
                        aVar.igP.setVisibility(0);
                    }
                } else {
                    if ((this.igC.bDb() == 0 && i < this.mData.bYV()) || (this.igC.bDb() == 1 && i < this.mData.bYW())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(R.drawable.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.igC.bDb() == 1) {
                        aVar.igJ.setVisibility(8);
                    }
                    aVar.igO.setVisibility(8);
                    al.c(aVar.igJ, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.igL.setText(forumData.getSlogan());
                }
                if (this.cUV) {
                    aVar.igN.setVisibility(0);
                    aVar.igO.setVisibility(8);
                } else {
                    aVar.igN.setVisibility(8);
                    if (i < this.mData.bYV() && this.fTR && !this.ife && this.igE) {
                        aVar.igO.setVisibility(0);
                    } else {
                        aVar.igO.setVisibility(8);
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
        this.igC.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.igC.getLayoutMode().onModeChanged(view);
    }

    public void F(View.OnClickListener onClickListener) {
        this.igD = onClickListener;
    }

    public void R(View.OnClickListener onClickListener) {
        this.igF = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.hqS) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void BT(String str) {
        this.iff = str;
    }

    /* loaded from: classes6.dex */
    private class a {
        ImageView gHZ;
        BarImageView heg;
        StringBuffer igG;
        TextView igH;
        TextView igI;
        ImageView igJ;
        TextView igK;
        TextView igL;
        TextView igM;
        Button igN;
        ImageView igO;
        ImageView igP;
        TextView mName;

        private a() {
        }
    }
}
