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
/* loaded from: classes11.dex */
public class c extends BaseAdapter {
    private boolean eMo;
    private boolean jkF;
    private String jkG;
    private PersonBarActivity jlT;
    private boolean jlV;
    private View.OnClickListener jlW;
    private b mData;
    private ArrayList<ForumData> mForumList = null;
    private boolean dYA = false;
    private View.OnClickListener jlU = null;
    private boolean eMm = false;

    public c(PersonBarActivity personBarActivity, b bVar, boolean z, boolean z2) {
        this.mData = null;
        this.eMo = true;
        this.jkF = false;
        this.jlV = true;
        this.jlT = personBarActivity;
        this.mData = bVar;
        this.eMo = z;
        this.jkF = z2;
        this.jlV = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void hD(boolean z) {
        this.dYA = z;
        notifyDataSetChanged();
    }

    public boolean aXS() {
        return this.dYA;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eMm) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void bgP() {
        this.eMm = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.eMm = true;
        }
    }

    public boolean cwt() {
        return this.eMm;
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
                view3 = LayoutInflater.from(this.jlT.getPageContext().getContext()).inflate(R.layout.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.igw = (BarImageView) view3.findViewById(R.id.forum_avatar);
                    aVar.igw.setGifIconSupport(false);
                    aVar.igw.setRadius(l.getDimens(this.jlT, R.dimen.tbds10));
                    aVar.igw.setConrers(15);
                    aVar.igw.setPlaceHolder(2);
                    aVar.mName = (TextView) view3.findViewById(R.id.name);
                    aVar.jlX = new StringBuffer(10);
                    aVar.jlY = (TextView) view3.findViewById(R.id.degree);
                    aVar.jlZ = (TextView) view3.findViewById(R.id.degree_text);
                    aVar.jmd = (TextView) view3.findViewById(R.id.experience);
                    aVar.jmb = (TextView) view3.findViewById(R.id.experience_title);
                    aVar.jme = (Button) view3.findViewById(R.id.item_delete);
                    aVar.jma = (ImageView) view3.findViewById(R.id.degree_text_ta);
                    aVar.jmc = (TextView) view3.findViewById(R.id.intro_ta);
                    aVar.jmf = (ImageView) view3.findViewById(R.id.item_talk);
                    aVar.hJB = (ImageView) view3.findViewById(R.id.diver_buttom_px);
                    aVar.hJB.setVisibility(0);
                    aVar.jmg = (ImageView) view3.findViewById(R.id.item_selected);
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
            if (this.eMm) {
                aVar.jlY.setVisibility(8);
                aVar.jme.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.igw.setVisibility(8);
                aVar.jlZ.setVisibility(8);
                aVar.jmd.setVisibility(8);
                aVar.jmb.setVisibility(8);
                aVar.jma.setVisibility(8);
                aVar.jmc.setVisibility(8);
                aVar.jmf.setVisibility(8);
                aVar.hJB.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.igw.setVisibility(0);
                if (this.eMo) {
                    aVar.jlY.setVisibility(8);
                    aVar.jlZ.setVisibility(8);
                    aVar.jmd.setVisibility(0);
                    aVar.jmb.setVisibility(0);
                    aVar.jma.setVisibility(0);
                    aVar.jmc.setVisibility(8);
                    aVar.hJB.setVisibility(0);
                } else {
                    aVar.jlY.setVisibility(8);
                    aVar.jlZ.setVisibility(8);
                    aVar.jmd.setVisibility(8);
                    aVar.jmb.setVisibility(8);
                    aVar.jma.setVisibility(0);
                    aVar.jmc.setVisibility(0);
                    aVar.hJB.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.igw.setTag(image_url);
                aVar.igw.setImageDrawable(null);
                aVar.igw.startLoad(image_url, 10, false);
                aVar.jlX.delete(0, aVar.jlX.length());
                aVar.jlX.append(forumData.getName());
                aVar.jlX.append(this.jlT.getPageContext().getString(R.string.forum));
                aVar.mName.setText(aVar.jlX);
                if (this.eMo) {
                    am.setImageResource(aVar.jma, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.jmd.setText(String.format(this.jlT.getPageContext().getString(R.string.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.jme.setOnClickListener(this.jlU);
                    aVar.jme.setTag(Integer.valueOf(i));
                    if (i < this.mData.cwi()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_v), (Drawable) null);
                        if (!this.jkF && this.jlV) {
                            aVar.jmf.setVisibility(0);
                            aVar.jmf.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.jmf.setVisibility(8);
                    }
                    aVar.jmf.setOnClickListener(this.jlW);
                    aVar.jmg.setVisibility(8);
                    if (this.jkF && this.jlT.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.jkG)) {
                        aVar.jmg.setVisibility(0);
                    }
                } else {
                    if ((this.jlT.bXL() == 0 && i < this.mData.cwi()) || (this.jlT.bXL() == 1 && i < this.mData.cwj())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.jlT.bXL() == 1) {
                        aVar.jma.setVisibility(8);
                    }
                    aVar.jmf.setVisibility(8);
                    am.setImageResource(aVar.jma, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.jmc.setText(forumData.getSlogan());
                }
                if (this.dYA) {
                    aVar.jme.setVisibility(0);
                    aVar.jmf.setVisibility(8);
                } else {
                    aVar.jme.setVisibility(8);
                    if (i < this.mData.cwi() && this.eMo && !this.jkF && this.jlV) {
                        aVar.jmf.setVisibility(0);
                    } else {
                        aVar.jmf.setVisibility(8);
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
        this.jlT.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.jlT.getLayoutMode().onModeChanged(view);
    }

    public void J(View.OnClickListener onClickListener) {
        this.jlU = onClickListener;
    }

    public void U(View.OnClickListener onClickListener) {
        this.jlW = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.eMm) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void GM(String str) {
        this.jkG = str;
    }

    /* loaded from: classes11.dex */
    private class a {
        ImageView hJB;
        BarImageView igw;
        StringBuffer jlX;
        TextView jlY;
        TextView jlZ;
        ImageView jma;
        TextView jmb;
        TextView jmc;
        TextView jmd;
        Button jme;
        ImageView jmf;
        ImageView jmg;
        TextView mName;

        private a() {
        }
    }
}
