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
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes24.dex */
public class c extends BaseAdapter {
    private boolean gyX;
    private boolean lFb;
    private String lFc;
    private PersonBarActivity lGr;
    private boolean lGt;
    private View.OnClickListener lGu;
    private b mData;
    private ArrayList<ForumData> mForumList = null;
    private boolean fCQ = false;
    private View.OnClickListener lGs = null;
    private boolean gyV = false;

    public c(PersonBarActivity personBarActivity, b bVar, boolean z, boolean z2) {
        this.mData = null;
        this.gyX = true;
        this.lFb = false;
        this.lGt = true;
        this.lGr = personBarActivity;
        this.mData = bVar;
        this.gyX = z;
        this.lFb = z2;
        this.lGt = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void kN(boolean z) {
        this.fCQ = z;
        notifyDataSetChanged();
    }

    public boolean bEH() {
        return this.fCQ;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gyV) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void bQe() {
        this.gyV = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.gyV = true;
        }
    }

    public boolean doM() {
        return this.gyV;
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
                view3 = LayoutInflater.from(this.lGr.getPageContext().getContext()).inflate(R.layout.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.ktt = (BarImageView) view3.findViewById(R.id.forum_avatar);
                    aVar.ktt.setGifIconSupport(false);
                    aVar.ktt.setRadius(l.getDimens(this.lGr, R.dimen.tbds10));
                    aVar.ktt.setConrers(15);
                    aVar.ktt.setPlaceHolder(2);
                    aVar.mName = (TextView) view3.findViewById(R.id.name);
                    aVar.lGv = new StringBuffer(10);
                    aVar.lGw = (TextView) view3.findViewById(R.id.degree);
                    aVar.lGx = (TextView) view3.findViewById(R.id.degree_text);
                    aVar.lGB = (TextView) view3.findViewById(R.id.experience);
                    aVar.lGz = (TextView) view3.findViewById(R.id.experience_title);
                    aVar.lGC = (Button) view3.findViewById(R.id.item_delete);
                    aVar.lGy = (ImageView) view3.findViewById(R.id.degree_text_ta);
                    aVar.lGA = (TextView) view3.findViewById(R.id.intro_ta);
                    aVar.lGD = (ImageView) view3.findViewById(R.id.item_talk);
                    aVar.jUT = (ImageView) view3.findViewById(R.id.diver_buttom_px);
                    aVar.jUT.setVisibility(0);
                    aVar.lGE = (ImageView) view3.findViewById(R.id.item_selected);
                    view3.setTag(aVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    BdLog.e(exc.getMessage());
                    cB(view2);
                    return view2;
                }
            } else {
                aVar = (a) view.getTag();
                view3 = view;
            }
            if (this.gyV) {
                aVar.lGw.setVisibility(8);
                aVar.lGC.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.ktt.setVisibility(8);
                aVar.lGx.setVisibility(8);
                aVar.lGB.setVisibility(8);
                aVar.lGz.setVisibility(8);
                aVar.lGy.setVisibility(8);
                aVar.lGA.setVisibility(8);
                aVar.lGD.setVisibility(8);
                aVar.jUT.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.ktt.setVisibility(0);
                if (this.gyX) {
                    aVar.lGw.setVisibility(8);
                    aVar.lGx.setVisibility(8);
                    aVar.lGB.setVisibility(0);
                    aVar.lGz.setVisibility(0);
                    aVar.lGy.setVisibility(0);
                    aVar.lGA.setVisibility(8);
                    aVar.jUT.setVisibility(0);
                } else {
                    aVar.lGw.setVisibility(8);
                    aVar.lGx.setVisibility(8);
                    aVar.lGB.setVisibility(8);
                    aVar.lGz.setVisibility(8);
                    aVar.lGy.setVisibility(0);
                    aVar.lGA.setVisibility(0);
                    aVar.jUT.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.ktt.setTag(image_url);
                aVar.ktt.setImageDrawable(null);
                aVar.ktt.startLoad(image_url, 10, false);
                aVar.lGv.delete(0, aVar.lGv.length());
                aVar.lGv.append(forumData.getName());
                aVar.lGv.append(this.lGr.getPageContext().getString(R.string.forum));
                aVar.mName.setText(aVar.lGv);
                if (this.gyX) {
                    ap.setImageResource(aVar.lGy, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.lGB.setText(String.format(this.lGr.getPageContext().getString(R.string.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.lGC.setOnClickListener(this.lGs);
                    aVar.lGC.setTag(Integer.valueOf(i));
                    if (i < this.mData.doB()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_v), (Drawable) null);
                        if (!this.lFb && this.lGt) {
                            aVar.lGD.setVisibility(0);
                            aVar.lGD.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.lGD.setVisibility(8);
                    }
                    aVar.lGD.setOnClickListener(this.lGu);
                    aVar.lGE.setVisibility(8);
                    if (this.lFb && this.lGr.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.lFc)) {
                        aVar.lGE.setVisibility(0);
                    }
                } else {
                    if ((this.lGr.cOQ() == 0 && i < this.mData.doB()) || (this.lGr.cOQ() == 1 && i < this.mData.doC())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.lGr.cOQ() == 1) {
                        aVar.lGy.setVisibility(8);
                    }
                    aVar.lGD.setVisibility(8);
                    ap.setImageResource(aVar.lGy, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.lGA.setText(forumData.getSlogan());
                }
                if (this.fCQ) {
                    aVar.lGC.setVisibility(0);
                    aVar.lGD.setVisibility(8);
                } else {
                    aVar.lGC.setVisibility(8);
                    if (i < this.mData.doB() && this.gyX && !this.lFb && this.lGt) {
                        aVar.lGD.setVisibility(0);
                    } else {
                        aVar.lGD.setVisibility(8);
                    }
                }
            }
            view2 = view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
        cB(view2);
        return view2;
    }

    private void cB(View view) {
        this.lGr.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.lGr.getLayoutMode().onModeChanged(view);
    }

    public void M(View.OnClickListener onClickListener) {
        this.lGs = onClickListener;
    }

    public void Y(View.OnClickListener onClickListener) {
        this.lGu = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.gyV) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void PI(String str) {
        this.lFc = str;
    }

    /* loaded from: classes24.dex */
    private class a {
        ImageView jUT;
        BarImageView ktt;
        TextView lGA;
        TextView lGB;
        Button lGC;
        ImageView lGD;
        ImageView lGE;
        StringBuffer lGv;
        TextView lGw;
        TextView lGx;
        ImageView lGy;
        TextView lGz;
        TextView mName;

        private a() {
        }
    }
}
