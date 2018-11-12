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
    private boolean egp;
    private boolean glY;
    private String glZ;
    private PersonBarActivity gnH;
    private boolean gnJ;
    private View.OnClickListener gnK;
    private com.baidu.tieba.personExtra.a mData;
    private ArrayList<ForumData> mForumList = null;
    private boolean bxo = false;
    private View.OnClickListener gnI = null;
    private boolean fyW = false;

    public b(PersonBarActivity personBarActivity, com.baidu.tieba.personExtra.a aVar, boolean z, boolean z2) {
        this.mData = null;
        this.egp = true;
        this.glY = false;
        this.gnJ = true;
        this.gnH = personBarActivity;
        this.mData = aVar;
        this.egp = z;
        this.glY = z2;
        this.gnJ = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void dp(boolean z) {
        this.bxo = z;
        notifyDataSetChanged();
    }

    public boolean UO() {
        return this.bxo;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fyW) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void bbj() {
        this.fyW = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.fyW = true;
        }
    }

    public boolean bnA() {
        return this.fyW;
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
                view3 = LayoutInflater.from(this.gnH.getPageContext().getContext()).inflate(e.h.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.fmo = (BarImageView) view3.findViewById(e.g.forum_avatar);
                    aVar.fmo.setGifIconSupport(false);
                    aVar.mName = (TextView) view3.findViewById(e.g.name);
                    aVar.gnL = new StringBuffer(10);
                    aVar.gnM = (TextView) view3.findViewById(e.g.degree);
                    aVar.gnN = (TextView) view3.findViewById(e.g.degree_text);
                    aVar.gnR = (TextView) view3.findViewById(e.g.experience);
                    aVar.gnP = (TextView) view3.findViewById(e.g.experience_title);
                    aVar.gnS = (Button) view3.findViewById(e.g.item_delete);
                    aVar.gnO = (ImageView) view3.findViewById(e.g.degree_text_ta);
                    aVar.gnQ = (TextView) view3.findViewById(e.g.intro_ta);
                    aVar.gnT = (ImageView) view3.findViewById(e.g.item_talk);
                    aVar.eQx = (ImageView) view3.findViewById(e.g.diver_buttom_px);
                    aVar.eQx.setVisibility(0);
                    aVar.gnU = (ImageView) view3.findViewById(e.g.item_selected);
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
            if (this.fyW) {
                aVar.gnM.setVisibility(8);
                aVar.gnS.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.fmo.setVisibility(8);
                aVar.gnN.setVisibility(8);
                aVar.gnR.setVisibility(8);
                aVar.gnP.setVisibility(8);
                aVar.gnO.setVisibility(8);
                aVar.gnQ.setVisibility(8);
                aVar.gnT.setVisibility(8);
                aVar.eQx.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.fmo.setVisibility(0);
                if (this.egp) {
                    aVar.gnM.setVisibility(8);
                    aVar.gnN.setVisibility(8);
                    aVar.gnR.setVisibility(0);
                    aVar.gnP.setVisibility(0);
                    aVar.gnO.setVisibility(0);
                    aVar.gnQ.setVisibility(8);
                    aVar.eQx.setVisibility(0);
                } else {
                    aVar.gnM.setVisibility(8);
                    aVar.gnN.setVisibility(8);
                    aVar.gnR.setVisibility(8);
                    aVar.gnP.setVisibility(8);
                    aVar.gnO.setVisibility(0);
                    aVar.gnQ.setVisibility(0);
                    aVar.eQx.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.fmo.setTag(image_url);
                aVar.fmo.setImageDrawable(null);
                aVar.fmo.startLoad(image_url, 10, false);
                aVar.gnL.delete(0, aVar.gnL.length());
                aVar.gnL.append(forumData.getName());
                aVar.gnL.append(this.gnH.getPageContext().getString(e.j.forum));
                aVar.mName.setText(aVar.gnL);
                if (this.egp) {
                    al.c(aVar.gnO, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.gnR.setText(String.format(this.gnH.getPageContext().getString(e.j.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.gnS.setOnClickListener(this.gnI);
                    aVar.gnS.setTag(Integer.valueOf(i));
                    if (i < this.mData.bnp()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_v), (Drawable) null);
                        if (!this.glY && this.gnJ) {
                            aVar.gnT.setVisibility(0);
                            aVar.gnT.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.gnT.setVisibility(8);
                    }
                    aVar.gnT.setOnClickListener(this.gnK);
                    aVar.gnU.setVisibility(8);
                    if (this.glY && this.gnH.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.glZ)) {
                        aVar.gnU.setVisibility(0);
                    }
                } else {
                    if ((this.gnH.aRI() == 0 && i < this.mData.bnp()) || (this.gnH.aRI() == 1 && i < this.mData.bnq())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.gnH.aRI() == 1) {
                        aVar.gnO.setVisibility(8);
                    }
                    aVar.gnT.setVisibility(8);
                    al.c(aVar.gnO, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.gnQ.setText(forumData.getSlogan());
                }
                if (this.bxo) {
                    aVar.gnS.setVisibility(0);
                    aVar.gnT.setVisibility(8);
                } else {
                    aVar.gnS.setVisibility(8);
                    if (i < this.mData.bnp() && this.egp && !this.glY && this.gnJ) {
                        aVar.gnT.setVisibility(0);
                    } else {
                        aVar.gnT.setVisibility(8);
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
        this.gnH.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gnH.getLayoutMode().onModeChanged(view);
    }

    public void C(View.OnClickListener onClickListener) {
        this.gnI = onClickListener;
    }

    public void P(View.OnClickListener onClickListener) {
        this.gnK = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fyW) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void te(String str) {
        this.glZ = str;
    }

    /* loaded from: classes3.dex */
    private class a {
        ImageView eQx;
        BarImageView fmo;
        StringBuffer gnL;
        TextView gnM;
        TextView gnN;
        ImageView gnO;
        TextView gnP;
        TextView gnQ;
        TextView gnR;
        Button gnS;
        ImageView gnT;
        ImageView gnU;
        TextView mName;

        private a() {
        }
    }
}
