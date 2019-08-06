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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class c extends BaseAdapter {
    private boolean fZG;
    private boolean imA;
    private String imB;
    private PersonBarActivity inZ;
    private boolean iob;
    private View.OnClickListener ioc;
    private b mData;
    private ArrayList<ForumData> mForumList = null;
    private boolean cWz = false;
    private View.OnClickListener ioa = null;
    private boolean hxX = false;

    public c(PersonBarActivity personBarActivity, b bVar, boolean z, boolean z2) {
        this.mData = null;
        this.fZG = true;
        this.imA = false;
        this.iob = true;
        this.inZ = personBarActivity;
        this.mData = bVar;
        this.fZG = z;
        this.imA = z2;
        this.iob = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void gk(boolean z) {
        this.cWz = z;
        notifyDataSetChanged();
    }

    public boolean aCP() {
        return this.cWz;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hxX) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void bPy() {
        this.hxX = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.hxX = true;
        }
    }

    public boolean cco() {
        return this.hxX;
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
                view3 = LayoutInflater.from(this.inZ.getPageContext().getContext()).inflate(R.layout.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.hlm = (BarImageView) view3.findViewById(R.id.forum_avatar);
                    aVar.hlm.setGifIconSupport(false);
                    aVar.mName = (TextView) view3.findViewById(R.id.name);
                    aVar.iod = new StringBuffer(10);
                    aVar.ioe = (TextView) view3.findViewById(R.id.degree);
                    aVar.iof = (TextView) view3.findViewById(R.id.degree_text);
                    aVar.ioj = (TextView) view3.findViewById(R.id.experience);
                    aVar.ioh = (TextView) view3.findViewById(R.id.experience_title);
                    aVar.iok = (Button) view3.findViewById(R.id.item_delete);
                    aVar.iog = (ImageView) view3.findViewById(R.id.degree_text_ta);
                    aVar.ioi = (TextView) view3.findViewById(R.id.intro_ta);
                    aVar.iol = (ImageView) view3.findViewById(R.id.item_talk);
                    aVar.gPd = (ImageView) view3.findViewById(R.id.diver_buttom_px);
                    aVar.gPd.setVisibility(0);
                    aVar.iom = (ImageView) view3.findViewById(R.id.item_selected);
                    view3.setTag(aVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    BdLog.e(exc.getMessage());
                    ca(view2);
                    return view2;
                }
            } else {
                aVar = (a) view.getTag();
                view3 = view;
            }
            if (this.hxX) {
                aVar.ioe.setVisibility(8);
                aVar.iok.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.hlm.setVisibility(8);
                aVar.iof.setVisibility(8);
                aVar.ioj.setVisibility(8);
                aVar.ioh.setVisibility(8);
                aVar.iog.setVisibility(8);
                aVar.ioi.setVisibility(8);
                aVar.iol.setVisibility(8);
                aVar.gPd.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.hlm.setVisibility(0);
                if (this.fZG) {
                    aVar.ioe.setVisibility(8);
                    aVar.iof.setVisibility(8);
                    aVar.ioj.setVisibility(0);
                    aVar.ioh.setVisibility(0);
                    aVar.iog.setVisibility(0);
                    aVar.ioi.setVisibility(8);
                    aVar.gPd.setVisibility(0);
                } else {
                    aVar.ioe.setVisibility(8);
                    aVar.iof.setVisibility(8);
                    aVar.ioj.setVisibility(8);
                    aVar.ioh.setVisibility(8);
                    aVar.iog.setVisibility(0);
                    aVar.ioi.setVisibility(0);
                    aVar.gPd.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.hlm.setTag(image_url);
                aVar.hlm.setImageDrawable(null);
                aVar.hlm.startLoad(image_url, 10, false);
                aVar.iod.delete(0, aVar.iod.length());
                aVar.iod.append(forumData.getName());
                aVar.iod.append(this.inZ.getPageContext().getString(R.string.forum));
                aVar.mName.setText(aVar.iod);
                if (this.fZG) {
                    am.c(aVar.iog, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.ioj.setText(String.format(this.inZ.getPageContext().getString(R.string.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.iok.setOnClickListener(this.ioa);
                    aVar.iok.setTag(Integer.valueOf(i));
                    if (i < this.mData.ccd()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_v), (Drawable) null);
                        if (!this.imA && this.iob) {
                            aVar.iol.setVisibility(0);
                            aVar.iol.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.iol.setVisibility(8);
                    }
                    aVar.iol.setOnClickListener(this.ioc);
                    aVar.iom.setVisibility(8);
                    if (this.imA && this.inZ.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.imB)) {
                        aVar.iom.setVisibility(0);
                    }
                } else {
                    if ((this.inZ.bFX() == 0 && i < this.mData.ccd()) || (this.inZ.bFX() == 1 && i < this.mData.cce())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.inZ.bFX() == 1) {
                        aVar.iog.setVisibility(8);
                    }
                    aVar.iol.setVisibility(8);
                    am.c(aVar.iog, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.ioi.setText(forumData.getSlogan());
                }
                if (this.cWz) {
                    aVar.iok.setVisibility(0);
                    aVar.iol.setVisibility(8);
                } else {
                    aVar.iok.setVisibility(8);
                    if (i < this.mData.ccd() && this.fZG && !this.imA && this.iob) {
                        aVar.iol.setVisibility(0);
                    } else {
                        aVar.iol.setVisibility(8);
                    }
                }
            }
            view2 = view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
        ca(view2);
        return view2;
    }

    private void ca(View view) {
        this.inZ.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.inZ.getLayoutMode().onModeChanged(view);
    }

    public void H(View.OnClickListener onClickListener) {
        this.ioa = onClickListener;
    }

    public void T(View.OnClickListener onClickListener) {
        this.ioc = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.hxX) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void CJ(String str) {
        this.imB = str;
    }

    /* loaded from: classes6.dex */
    private class a {
        ImageView gPd;
        BarImageView hlm;
        StringBuffer iod;
        TextView ioe;
        TextView iof;
        ImageView iog;
        TextView ioh;
        TextView ioi;
        TextView ioj;
        Button iok;
        ImageView iol;
        ImageView iom;
        TextView mName;

        private a() {
        }
    }
}
