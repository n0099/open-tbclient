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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class c extends BaseAdapter {
    private boolean eGA;
    private boolean jer;
    private String jes;
    private PersonBarActivity jfF;
    private boolean jfH;
    private View.OnClickListener jfI;
    private b mData;
    private ArrayList<ForumData> mForumList = null;
    private boolean dTI = false;
    private View.OnClickListener jfG = null;
    private boolean eGy = false;

    public c(PersonBarActivity personBarActivity, b bVar, boolean z, boolean z2) {
        this.mData = null;
        this.eGA = true;
        this.jer = false;
        this.jfH = true;
        this.jfF = personBarActivity;
        this.mData = bVar;
        this.eGA = z;
        this.jer = z2;
        this.jfH = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void hq(boolean z) {
        this.dTI = z;
        notifyDataSetChanged();
    }

    public boolean aVd() {
        return this.dTI;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eGy) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void bec() {
        this.eGy = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.eGy = true;
        }
    }

    public boolean ctv() {
        return this.eGy;
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
                view3 = LayoutInflater.from(this.jfF.getPageContext().getContext()).inflate(R.layout.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.hZd = (BarImageView) view3.findViewById(R.id.forum_avatar);
                    aVar.hZd.setGifIconSupport(false);
                    aVar.hZd.setRadius(l.getDimens(this.jfF, R.dimen.tbds10));
                    aVar.hZd.setConrers(15);
                    aVar.hZd.setPlaceHolder(2);
                    aVar.mName = (TextView) view3.findViewById(R.id.name);
                    aVar.jfJ = new StringBuffer(10);
                    aVar.jfK = (TextView) view3.findViewById(R.id.degree);
                    aVar.jfL = (TextView) view3.findViewById(R.id.degree_text);
                    aVar.jfP = (TextView) view3.findViewById(R.id.experience);
                    aVar.jfN = (TextView) view3.findViewById(R.id.experience_title);
                    aVar.jfQ = (Button) view3.findViewById(R.id.item_delete);
                    aVar.jfM = (ImageView) view3.findViewById(R.id.degree_text_ta);
                    aVar.jfO = (TextView) view3.findViewById(R.id.intro_ta);
                    aVar.jfR = (ImageView) view3.findViewById(R.id.item_talk);
                    aVar.hCl = (ImageView) view3.findViewById(R.id.diver_buttom_px);
                    aVar.hCl.setVisibility(0);
                    aVar.jfS = (ImageView) view3.findViewById(R.id.item_selected);
                    view3.setTag(aVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    BdLog.e(exc.getMessage());
                    bS(view2);
                    return view2;
                }
            } else {
                aVar = (a) view.getTag();
                view3 = view;
            }
            if (this.eGy) {
                aVar.jfK.setVisibility(8);
                aVar.jfQ.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.hZd.setVisibility(8);
                aVar.jfL.setVisibility(8);
                aVar.jfP.setVisibility(8);
                aVar.jfN.setVisibility(8);
                aVar.jfM.setVisibility(8);
                aVar.jfO.setVisibility(8);
                aVar.jfR.setVisibility(8);
                aVar.hCl.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.hZd.setVisibility(0);
                if (this.eGA) {
                    aVar.jfK.setVisibility(8);
                    aVar.jfL.setVisibility(8);
                    aVar.jfP.setVisibility(0);
                    aVar.jfN.setVisibility(0);
                    aVar.jfM.setVisibility(0);
                    aVar.jfO.setVisibility(8);
                    aVar.hCl.setVisibility(0);
                } else {
                    aVar.jfK.setVisibility(8);
                    aVar.jfL.setVisibility(8);
                    aVar.jfP.setVisibility(8);
                    aVar.jfN.setVisibility(8);
                    aVar.jfM.setVisibility(0);
                    aVar.jfO.setVisibility(0);
                    aVar.hCl.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.hZd.setTag(image_url);
                aVar.hZd.setImageDrawable(null);
                aVar.hZd.startLoad(image_url, 10, false);
                aVar.jfJ.delete(0, aVar.jfJ.length());
                aVar.jfJ.append(forumData.getName());
                aVar.jfJ.append(this.jfF.getPageContext().getString(R.string.forum));
                aVar.mName.setText(aVar.jfJ);
                if (this.eGA) {
                    am.setImageResource(aVar.jfM, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.jfP.setText(String.format(this.jfF.getPageContext().getString(R.string.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.jfQ.setOnClickListener(this.jfG);
                    aVar.jfQ.setTag(Integer.valueOf(i));
                    if (i < this.mData.ctk()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_v), (Drawable) null);
                        if (!this.jer && this.jfH) {
                            aVar.jfR.setVisibility(0);
                            aVar.jfR.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.jfR.setVisibility(8);
                    }
                    aVar.jfR.setOnClickListener(this.jfI);
                    aVar.jfS.setVisibility(8);
                    if (this.jer && this.jfF.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.jes)) {
                        aVar.jfS.setVisibility(0);
                    }
                } else {
                    if ((this.jfF.bUG() == 0 && i < this.mData.ctk()) || (this.jfF.bUG() == 1 && i < this.mData.ctl())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.jfF.bUG() == 1) {
                        aVar.jfM.setVisibility(8);
                    }
                    aVar.jfR.setVisibility(8);
                    am.setImageResource(aVar.jfM, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.jfO.setText(forumData.getSlogan());
                }
                if (this.dTI) {
                    aVar.jfQ.setVisibility(0);
                    aVar.jfR.setVisibility(8);
                } else {
                    aVar.jfQ.setVisibility(8);
                    if (i < this.mData.ctk() && this.eGA && !this.jer && this.jfH) {
                        aVar.jfR.setVisibility(0);
                    } else {
                        aVar.jfR.setVisibility(8);
                    }
                }
            }
            view2 = view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
        bS(view2);
        return view2;
    }

    private void bS(View view) {
        this.jfF.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.jfF.getLayoutMode().onModeChanged(view);
    }

    public void J(View.OnClickListener onClickListener) {
        this.jfG = onClickListener;
    }

    public void V(View.OnClickListener onClickListener) {
        this.jfI = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.eGy) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void Gn(String str) {
        this.jes = str;
    }

    /* loaded from: classes8.dex */
    private class a {
        ImageView hCl;
        BarImageView hZd;
        StringBuffer jfJ;
        TextView jfK;
        TextView jfL;
        ImageView jfM;
        TextView jfN;
        TextView jfO;
        TextView jfP;
        Button jfQ;
        ImageView jfR;
        ImageView jfS;
        TextView mName;

        private a() {
        }
    }
}
