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
    private boolean epZ;
    private boolean gvF;
    private String gvG;
    private PersonBarActivity gxo;
    private boolean gxq;
    private View.OnClickListener gxr;
    private com.baidu.tieba.personExtra.a mData;
    private ArrayList<ForumData> mForumList = null;
    private boolean bAO = false;
    private View.OnClickListener gxp = null;
    private boolean fIE = false;

    public b(PersonBarActivity personBarActivity, com.baidu.tieba.personExtra.a aVar, boolean z, boolean z2) {
        this.mData = null;
        this.epZ = true;
        this.gvF = false;
        this.gxq = true;
        this.gxo = personBarActivity;
        this.mData = aVar;
        this.epZ = z;
        this.gvF = z2;
        this.gxq = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void dq(boolean z) {
        this.bAO = z;
        notifyDataSetChanged();
    }

    public boolean VW() {
        return this.bAO;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fIE) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void bdN() {
        this.fIE = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.fIE = true;
        }
    }

    public boolean bqe() {
        return this.fIE;
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
                view3 = LayoutInflater.from(this.gxo.getPageContext().getContext()).inflate(e.h.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.fvY = (BarImageView) view3.findViewById(e.g.forum_avatar);
                    aVar.fvY.setGifIconSupport(false);
                    aVar.mName = (TextView) view3.findViewById(e.g.name);
                    aVar.gxs = new StringBuffer(10);
                    aVar.gxt = (TextView) view3.findViewById(e.g.degree);
                    aVar.gxu = (TextView) view3.findViewById(e.g.degree_text);
                    aVar.gxy = (TextView) view3.findViewById(e.g.experience);
                    aVar.gxw = (TextView) view3.findViewById(e.g.experience_title);
                    aVar.gxz = (Button) view3.findViewById(e.g.item_delete);
                    aVar.gxv = (ImageView) view3.findViewById(e.g.degree_text_ta);
                    aVar.gxx = (TextView) view3.findViewById(e.g.intro_ta);
                    aVar.gxA = (ImageView) view3.findViewById(e.g.item_talk);
                    aVar.fad = (ImageView) view3.findViewById(e.g.diver_buttom_px);
                    aVar.fad.setVisibility(0);
                    aVar.gxB = (ImageView) view3.findViewById(e.g.item_selected);
                    view3.setTag(aVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    BdLog.e(exc.getMessage());
                    bb(view2);
                    return view2;
                }
            } else {
                aVar = (a) view.getTag();
                view3 = view;
            }
            if (this.fIE) {
                aVar.gxt.setVisibility(8);
                aVar.gxz.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.fvY.setVisibility(8);
                aVar.gxu.setVisibility(8);
                aVar.gxy.setVisibility(8);
                aVar.gxw.setVisibility(8);
                aVar.gxv.setVisibility(8);
                aVar.gxx.setVisibility(8);
                aVar.gxA.setVisibility(8);
                aVar.fad.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.fvY.setVisibility(0);
                if (this.epZ) {
                    aVar.gxt.setVisibility(8);
                    aVar.gxu.setVisibility(8);
                    aVar.gxy.setVisibility(0);
                    aVar.gxw.setVisibility(0);
                    aVar.gxv.setVisibility(0);
                    aVar.gxx.setVisibility(8);
                    aVar.fad.setVisibility(0);
                } else {
                    aVar.gxt.setVisibility(8);
                    aVar.gxu.setVisibility(8);
                    aVar.gxy.setVisibility(8);
                    aVar.gxw.setVisibility(8);
                    aVar.gxv.setVisibility(0);
                    aVar.gxx.setVisibility(0);
                    aVar.fad.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.fvY.setTag(image_url);
                aVar.fvY.setImageDrawable(null);
                aVar.fvY.startLoad(image_url, 10, false);
                aVar.gxs.delete(0, aVar.gxs.length());
                aVar.gxs.append(forumData.getName());
                aVar.gxs.append(this.gxo.getPageContext().getString(e.j.forum));
                aVar.mName.setText(aVar.gxs);
                if (this.epZ) {
                    al.c(aVar.gxv, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.gxy.setText(String.format(this.gxo.getPageContext().getString(e.j.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.gxz.setOnClickListener(this.gxp);
                    aVar.gxz.setTag(Integer.valueOf(i));
                    if (i < this.mData.bpT()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_v), (Drawable) null);
                        if (!this.gvF && this.gxq) {
                            aVar.gxA.setVisibility(0);
                            aVar.gxA.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.gxA.setVisibility(8);
                    }
                    aVar.gxA.setOnClickListener(this.gxr);
                    aVar.gxB.setVisibility(8);
                    if (this.gvF && this.gxo.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.gvG)) {
                        aVar.gxB.setVisibility(0);
                    }
                } else {
                    if ((this.gxo.aUn() == 0 && i < this.mData.bpT()) || (this.gxo.aUn() == 1 && i < this.mData.bpU())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.gxo.aUn() == 1) {
                        aVar.gxv.setVisibility(8);
                    }
                    aVar.gxA.setVisibility(8);
                    al.c(aVar.gxv, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.gxx.setText(forumData.getSlogan());
                }
                if (this.bAO) {
                    aVar.gxz.setVisibility(0);
                    aVar.gxA.setVisibility(8);
                } else {
                    aVar.gxz.setVisibility(8);
                    if (i < this.mData.bpT() && this.epZ && !this.gvF && this.gxq) {
                        aVar.gxA.setVisibility(0);
                    } else {
                        aVar.gxA.setVisibility(8);
                    }
                }
            }
            view2 = view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
        bb(view2);
        return view2;
    }

    private void bb(View view) {
        this.gxo.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gxo.getLayoutMode().onModeChanged(view);
    }

    public void C(View.OnClickListener onClickListener) {
        this.gxp = onClickListener;
    }

    public void P(View.OnClickListener onClickListener) {
        this.gxr = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fIE) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void tJ(String str) {
        this.gvG = str;
    }

    /* loaded from: classes3.dex */
    private class a {
        ImageView fad;
        BarImageView fvY;
        ImageView gxA;
        ImageView gxB;
        StringBuffer gxs;
        TextView gxt;
        TextView gxu;
        ImageView gxv;
        TextView gxw;
        TextView gxx;
        TextView gxy;
        Button gxz;
        TextView mName;

        private a() {
        }
    }
}
