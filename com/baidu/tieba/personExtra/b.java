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
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private boolean dNa;
    private boolean fVu;
    private String fVv;
    private PersonBarActivity fWZ;
    private boolean fXb;
    private View.OnClickListener fXc;
    private com.baidu.tieba.personExtra.a mData;
    private ArrayList<ForumData> mForumList = null;
    private boolean blY = false;
    private View.OnClickListener fXa = null;
    private boolean fiq = false;

    public b(PersonBarActivity personBarActivity, com.baidu.tieba.personExtra.a aVar, boolean z, boolean z2) {
        this.mData = null;
        this.dNa = true;
        this.fVu = false;
        this.fXb = true;
        this.fWZ = personBarActivity;
        this.mData = aVar;
        this.dNa = z;
        this.fVu = z2;
        this.fXb = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void cx(boolean z) {
        this.blY = z;
        notifyDataSetChanged();
    }

    public boolean QJ() {
        return this.blY;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fiq) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void aXU() {
        this.fiq = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.fiq = true;
        }
    }

    public boolean bkd() {
        return this.fiq;
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
                view3 = LayoutInflater.from(this.fWZ.getPageContext().getContext()).inflate(d.i.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.eSc = (BarImageView) view3.findViewById(d.g.forum_avatar);
                    aVar.eSc.setGifIconSupport(false);
                    aVar.mName = (TextView) view3.findViewById(d.g.name);
                    aVar.fXd = new StringBuffer(10);
                    aVar.fXe = (TextView) view3.findViewById(d.g.degree);
                    aVar.fXf = (TextView) view3.findViewById(d.g.degree_text);
                    aVar.fXj = (TextView) view3.findViewById(d.g.experience);
                    aVar.fXh = (TextView) view3.findViewById(d.g.experience_title);
                    aVar.fXk = (Button) view3.findViewById(d.g.item_delete);
                    aVar.fXg = (ImageView) view3.findViewById(d.g.degree_text_ta);
                    aVar.fXi = (TextView) view3.findViewById(d.g.intro_ta);
                    aVar.fXl = (ImageView) view3.findViewById(d.g.item_talk);
                    aVar.ewp = (ImageView) view3.findViewById(d.g.diver_buttom_px);
                    aVar.ewp.setVisibility(0);
                    aVar.fXm = (ImageView) view3.findViewById(d.g.item_selected);
                    view3.setTag(aVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    BdLog.e(exc.getMessage());
                    aF(view2);
                    return view2;
                }
            } else {
                aVar = (a) view.getTag();
                view3 = view;
            }
            if (this.fiq) {
                aVar.fXe.setVisibility(8);
                aVar.fXk.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.eSc.setVisibility(8);
                aVar.fXf.setVisibility(8);
                aVar.fXj.setVisibility(8);
                aVar.fXh.setVisibility(8);
                aVar.fXg.setVisibility(8);
                aVar.fXi.setVisibility(8);
                aVar.fXl.setVisibility(8);
                aVar.ewp.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.eSc.setVisibility(0);
                if (this.dNa) {
                    aVar.fXe.setVisibility(8);
                    aVar.fXf.setVisibility(8);
                    aVar.fXj.setVisibility(0);
                    aVar.fXh.setVisibility(0);
                    aVar.fXg.setVisibility(0);
                    aVar.fXi.setVisibility(8);
                    aVar.ewp.setVisibility(0);
                } else {
                    aVar.fXe.setVisibility(8);
                    aVar.fXf.setVisibility(8);
                    aVar.fXj.setVisibility(8);
                    aVar.fXh.setVisibility(8);
                    aVar.fXg.setVisibility(0);
                    aVar.fXi.setVisibility(0);
                    aVar.ewp.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.eSc.setTag(image_url);
                aVar.eSc.setImageDrawable(null);
                aVar.eSc.startLoad(image_url, 10, false);
                aVar.fXd.delete(0, aVar.fXd.length());
                aVar.fXd.append(forumData.getName());
                aVar.fXd.append(this.fWZ.getPageContext().getString(d.k.forum));
                aVar.mName.setText(aVar.fXd);
                if (this.dNa) {
                    am.c(aVar.fXg, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.fXj.setText(String.format(this.fWZ.getPageContext().getString(d.k.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.fXk.setOnClickListener(this.fXa);
                    aVar.fXk.setTag(Integer.valueOf(i));
                    if (i < this.mData.bjS()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(d.f.icon_v), (Drawable) null);
                        if (!this.fVu && this.fXb) {
                            aVar.fXl.setVisibility(0);
                            aVar.fXl.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.fXl.setVisibility(8);
                    }
                    aVar.fXl.setOnClickListener(this.fXc);
                    aVar.fXm.setVisibility(8);
                    if (this.fVu && this.fWZ.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.fVv)) {
                        aVar.fXm.setVisibility(0);
                    }
                } else {
                    if ((this.fWZ.aLK() == 0 && i < this.mData.bjS()) || (this.fWZ.aLK() == 1 && i < this.mData.bjT())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(d.f.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.fWZ.aLK() == 1) {
                        aVar.fXg.setVisibility(8);
                    }
                    aVar.fXl.setVisibility(8);
                    am.c(aVar.fXg, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.fXi.setText(forumData.getSlogan());
                }
                if (this.blY) {
                    aVar.fXk.setVisibility(0);
                    aVar.fXl.setVisibility(8);
                } else {
                    aVar.fXk.setVisibility(8);
                    if (i < this.mData.bjS() && this.dNa && !this.fVu && this.fXb) {
                        aVar.fXl.setVisibility(0);
                    } else {
                        aVar.fXl.setVisibility(8);
                    }
                }
            }
            view2 = view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
        aF(view2);
        return view2;
    }

    private void aF(View view) {
        this.fWZ.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.fWZ.getLayoutMode().onModeChanged(view);
    }

    public void C(View.OnClickListener onClickListener) {
        this.fXa = onClickListener;
    }

    public void Q(View.OnClickListener onClickListener) {
        this.fXc = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fiq) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void rX(String str) {
        this.fVv = str;
    }

    /* loaded from: classes3.dex */
    private class a {
        BarImageView eSc;
        ImageView ewp;
        StringBuffer fXd;
        TextView fXe;
        TextView fXf;
        ImageView fXg;
        TextView fXh;
        TextView fXi;
        TextView fXj;
        Button fXk;
        ImageView fXl;
        ImageView fXm;
        TextView mName;

        private a() {
        }
    }
}
