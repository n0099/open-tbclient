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
    private boolean fTT;
    private boolean iff;
    private String ifg;
    private PersonBarActivity igD;
    private boolean igF;
    private View.OnClickListener igG;
    private b mData;
    private ArrayList<ForumData> mForumList = null;
    private boolean cUW = false;
    private View.OnClickListener igE = null;
    private boolean hqT = false;

    public c(PersonBarActivity personBarActivity, b bVar, boolean z, boolean z2) {
        this.mData = null;
        this.fTT = true;
        this.iff = false;
        this.igF = true;
        this.igD = personBarActivity;
        this.mData = bVar;
        this.fTT = z;
        this.iff = z2;
        this.igF = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void gg(boolean z) {
        this.cUW = z;
        notifyDataSetChanged();
    }

    public boolean aBy() {
        return this.cUW;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hqT) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void bMC() {
        this.hqT = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.hqT = true;
        }
    }

    public boolean bZh() {
        return this.hqT;
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
                view3 = LayoutInflater.from(this.igD.getPageContext().getContext()).inflate(R.layout.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.heh = (BarImageView) view3.findViewById(R.id.forum_avatar);
                    aVar.heh.setGifIconSupport(false);
                    aVar.mName = (TextView) view3.findViewById(R.id.name);
                    aVar.igH = new StringBuffer(10);
                    aVar.igI = (TextView) view3.findViewById(R.id.degree);
                    aVar.igJ = (TextView) view3.findViewById(R.id.degree_text);
                    aVar.igN = (TextView) view3.findViewById(R.id.experience);
                    aVar.igL = (TextView) view3.findViewById(R.id.experience_title);
                    aVar.igO = (Button) view3.findViewById(R.id.item_delete);
                    aVar.igK = (ImageView) view3.findViewById(R.id.degree_text_ta);
                    aVar.igM = (TextView) view3.findViewById(R.id.intro_ta);
                    aVar.igP = (ImageView) view3.findViewById(R.id.item_talk);
                    aVar.gIb = (ImageView) view3.findViewById(R.id.diver_buttom_px);
                    aVar.gIb.setVisibility(0);
                    aVar.igQ = (ImageView) view3.findViewById(R.id.item_selected);
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
            if (this.hqT) {
                aVar.igI.setVisibility(8);
                aVar.igO.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.heh.setVisibility(8);
                aVar.igJ.setVisibility(8);
                aVar.igN.setVisibility(8);
                aVar.igL.setVisibility(8);
                aVar.igK.setVisibility(8);
                aVar.igM.setVisibility(8);
                aVar.igP.setVisibility(8);
                aVar.gIb.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.heh.setVisibility(0);
                if (this.fTT) {
                    aVar.igI.setVisibility(8);
                    aVar.igJ.setVisibility(8);
                    aVar.igN.setVisibility(0);
                    aVar.igL.setVisibility(0);
                    aVar.igK.setVisibility(0);
                    aVar.igM.setVisibility(8);
                    aVar.gIb.setVisibility(0);
                } else {
                    aVar.igI.setVisibility(8);
                    aVar.igJ.setVisibility(8);
                    aVar.igN.setVisibility(8);
                    aVar.igL.setVisibility(8);
                    aVar.igK.setVisibility(0);
                    aVar.igM.setVisibility(0);
                    aVar.gIb.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.heh.setTag(image_url);
                aVar.heh.setImageDrawable(null);
                aVar.heh.startLoad(image_url, 10, false);
                aVar.igH.delete(0, aVar.igH.length());
                aVar.igH.append(forumData.getName());
                aVar.igH.append(this.igD.getPageContext().getString(R.string.forum));
                aVar.mName.setText(aVar.igH);
                if (this.fTT) {
                    al.c(aVar.igK, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.igN.setText(String.format(this.igD.getPageContext().getString(R.string.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.igO.setOnClickListener(this.igE);
                    aVar.igO.setTag(Integer.valueOf(i));
                    if (i < this.mData.bYW()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(R.drawable.icon_v), (Drawable) null);
                        if (!this.iff && this.igF) {
                            aVar.igP.setVisibility(0);
                            aVar.igP.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.igP.setVisibility(8);
                    }
                    aVar.igP.setOnClickListener(this.igG);
                    aVar.igQ.setVisibility(8);
                    if (this.iff && this.igD.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.ifg)) {
                        aVar.igQ.setVisibility(0);
                    }
                } else {
                    if ((this.igD.bDc() == 0 && i < this.mData.bYW()) || (this.igD.bDc() == 1 && i < this.mData.bYX())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(R.drawable.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.igD.bDc() == 1) {
                        aVar.igK.setVisibility(8);
                    }
                    aVar.igP.setVisibility(8);
                    al.c(aVar.igK, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.igM.setText(forumData.getSlogan());
                }
                if (this.cUW) {
                    aVar.igO.setVisibility(0);
                    aVar.igP.setVisibility(8);
                } else {
                    aVar.igO.setVisibility(8);
                    if (i < this.mData.bYW() && this.fTT && !this.iff && this.igF) {
                        aVar.igP.setVisibility(0);
                    } else {
                        aVar.igP.setVisibility(8);
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
        this.igD.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.igD.getLayoutMode().onModeChanged(view);
    }

    public void F(View.OnClickListener onClickListener) {
        this.igE = onClickListener;
    }

    public void R(View.OnClickListener onClickListener) {
        this.igG = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.hqT) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void BV(String str) {
        this.ifg = str;
    }

    /* loaded from: classes6.dex */
    private class a {
        ImageView gIb;
        BarImageView heh;
        StringBuffer igH;
        TextView igI;
        TextView igJ;
        ImageView igK;
        TextView igL;
        TextView igM;
        TextView igN;
        Button igO;
        ImageView igP;
        ImageView igQ;
        TextView mName;

        private a() {
        }
    }
}
