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
    private boolean fYQ;
    private boolean ilv;
    private String ilw;
    private PersonBarActivity imU;
    private boolean imW;
    private View.OnClickListener imX;
    private b mData;
    private ArrayList<ForumData> mForumList = null;
    private boolean cWs = false;
    private View.OnClickListener imV = null;
    private boolean hxf = false;

    public c(PersonBarActivity personBarActivity, b bVar, boolean z, boolean z2) {
        this.mData = null;
        this.fYQ = true;
        this.ilv = false;
        this.imW = true;
        this.imU = personBarActivity;
        this.mData = bVar;
        this.fYQ = z;
        this.ilv = z2;
        this.imW = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void gk(boolean z) {
        this.cWs = z;
        notifyDataSetChanged();
    }

    public boolean aCN() {
        return this.cWs;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hxf) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void bPk() {
        this.hxf = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.hxf = true;
        }
    }

    public boolean cbW() {
        return this.hxf;
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
                view3 = LayoutInflater.from(this.imU.getPageContext().getContext()).inflate(R.layout.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.hku = (BarImageView) view3.findViewById(R.id.forum_avatar);
                    aVar.hku.setGifIconSupport(false);
                    aVar.mName = (TextView) view3.findViewById(R.id.name);
                    aVar.imY = new StringBuffer(10);
                    aVar.imZ = (TextView) view3.findViewById(R.id.degree);
                    aVar.ina = (TextView) view3.findViewById(R.id.degree_text);
                    aVar.ine = (TextView) view3.findViewById(R.id.experience);
                    aVar.inc = (TextView) view3.findViewById(R.id.experience_title);
                    aVar.inf = (Button) view3.findViewById(R.id.item_delete);
                    aVar.inb = (ImageView) view3.findViewById(R.id.degree_text_ta);
                    aVar.ind = (TextView) view3.findViewById(R.id.intro_ta);
                    aVar.ing = (ImageView) view3.findViewById(R.id.item_talk);
                    aVar.gOl = (ImageView) view3.findViewById(R.id.diver_buttom_px);
                    aVar.gOl.setVisibility(0);
                    aVar.inh = (ImageView) view3.findViewById(R.id.item_selected);
                    view3.setTag(aVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    BdLog.e(exc.getMessage());
                    bZ(view2);
                    return view2;
                }
            } else {
                aVar = (a) view.getTag();
                view3 = view;
            }
            if (this.hxf) {
                aVar.imZ.setVisibility(8);
                aVar.inf.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.hku.setVisibility(8);
                aVar.ina.setVisibility(8);
                aVar.ine.setVisibility(8);
                aVar.inc.setVisibility(8);
                aVar.inb.setVisibility(8);
                aVar.ind.setVisibility(8);
                aVar.ing.setVisibility(8);
                aVar.gOl.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.hku.setVisibility(0);
                if (this.fYQ) {
                    aVar.imZ.setVisibility(8);
                    aVar.ina.setVisibility(8);
                    aVar.ine.setVisibility(0);
                    aVar.inc.setVisibility(0);
                    aVar.inb.setVisibility(0);
                    aVar.ind.setVisibility(8);
                    aVar.gOl.setVisibility(0);
                } else {
                    aVar.imZ.setVisibility(8);
                    aVar.ina.setVisibility(8);
                    aVar.ine.setVisibility(8);
                    aVar.inc.setVisibility(8);
                    aVar.inb.setVisibility(0);
                    aVar.ind.setVisibility(0);
                    aVar.gOl.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.hku.setTag(image_url);
                aVar.hku.setImageDrawable(null);
                aVar.hku.startLoad(image_url, 10, false);
                aVar.imY.delete(0, aVar.imY.length());
                aVar.imY.append(forumData.getName());
                aVar.imY.append(this.imU.getPageContext().getString(R.string.forum));
                aVar.mName.setText(aVar.imY);
                if (this.fYQ) {
                    am.c(aVar.inb, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.ine.setText(String.format(this.imU.getPageContext().getString(R.string.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.inf.setOnClickListener(this.imV);
                    aVar.inf.setTag(Integer.valueOf(i));
                    if (i < this.mData.cbL()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_v), (Drawable) null);
                        if (!this.ilv && this.imW) {
                            aVar.ing.setVisibility(0);
                            aVar.ing.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.ing.setVisibility(8);
                    }
                    aVar.ing.setOnClickListener(this.imX);
                    aVar.inh.setVisibility(8);
                    if (this.ilv && this.imU.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.ilw)) {
                        aVar.inh.setVisibility(0);
                    }
                } else {
                    if ((this.imU.bFJ() == 0 && i < this.mData.cbL()) || (this.imU.bFJ() == 1 && i < this.mData.cbM())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.imU.bFJ() == 1) {
                        aVar.inb.setVisibility(8);
                    }
                    aVar.ing.setVisibility(8);
                    am.c(aVar.inb, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.ind.setText(forumData.getSlogan());
                }
                if (this.cWs) {
                    aVar.inf.setVisibility(0);
                    aVar.ing.setVisibility(8);
                } else {
                    aVar.inf.setVisibility(8);
                    if (i < this.mData.cbL() && this.fYQ && !this.ilv && this.imW) {
                        aVar.ing.setVisibility(0);
                    } else {
                        aVar.ing.setVisibility(8);
                    }
                }
            }
            view2 = view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
        bZ(view2);
        return view2;
    }

    private void bZ(View view) {
        this.imU.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.imU.getLayoutMode().onModeChanged(view);
    }

    public void H(View.OnClickListener onClickListener) {
        this.imV = onClickListener;
    }

    public void T(View.OnClickListener onClickListener) {
        this.imX = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.hxf) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void CI(String str) {
        this.ilw = str;
    }

    /* loaded from: classes6.dex */
    private class a {
        ImageView gOl;
        BarImageView hku;
        StringBuffer imY;
        TextView imZ;
        TextView ina;
        ImageView inb;
        TextView inc;
        TextView ind;
        TextView ine;
        Button inf;
        ImageView ing;
        ImageView inh;
        TextView mName;

        private a() {
        }
    }
}
