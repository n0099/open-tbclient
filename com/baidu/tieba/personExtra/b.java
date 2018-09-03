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
import com.baidu.tieba.f;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private boolean dPJ;
    private boolean fVH;
    private String fVI;
    private PersonBarActivity fXq;
    private boolean fXs;
    private View.OnClickListener fXt;
    private com.baidu.tieba.personExtra.a mData;
    private ArrayList<ForumData> mForumList = null;
    private boolean bmI = false;
    private View.OnClickListener fXr = null;
    private boolean fiw = false;

    public b(PersonBarActivity personBarActivity, com.baidu.tieba.personExtra.a aVar, boolean z, boolean z2) {
        this.mData = null;
        this.dPJ = true;
        this.fVH = false;
        this.fXs = true;
        this.fXq = personBarActivity;
        this.mData = aVar;
        this.dPJ = z;
        this.fVH = z2;
        this.fXs = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void cy(boolean z) {
        this.bmI = z;
        notifyDataSetChanged();
    }

    public boolean QV() {
        return this.bmI;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fiw) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void aWl() {
        this.fiw = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.fiw = true;
        }
    }

    public boolean bit() {
        return this.fiw;
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
                view3 = LayoutInflater.from(this.fXq.getPageContext().getContext()).inflate(f.h.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.eVS = (BarImageView) view3.findViewById(f.g.forum_avatar);
                    aVar.eVS.setGifIconSupport(false);
                    aVar.mName = (TextView) view3.findViewById(f.g.name);
                    aVar.fXu = new StringBuffer(10);
                    aVar.fXv = (TextView) view3.findViewById(f.g.degree);
                    aVar.fXw = (TextView) view3.findViewById(f.g.degree_text);
                    aVar.fXA = (TextView) view3.findViewById(f.g.experience);
                    aVar.fXy = (TextView) view3.findViewById(f.g.experience_title);
                    aVar.fXB = (Button) view3.findViewById(f.g.item_delete);
                    aVar.fXx = (ImageView) view3.findViewById(f.g.degree_text_ta);
                    aVar.fXz = (TextView) view3.findViewById(f.g.intro_ta);
                    aVar.fXC = (ImageView) view3.findViewById(f.g.item_talk);
                    aVar.eAe = (ImageView) view3.findViewById(f.g.diver_buttom_px);
                    aVar.eAe.setVisibility(0);
                    aVar.fXD = (ImageView) view3.findViewById(f.g.item_selected);
                    view3.setTag(aVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    BdLog.e(exc.getMessage());
                    aI(view2);
                    return view2;
                }
            } else {
                aVar = (a) view.getTag();
                view3 = view;
            }
            if (this.fiw) {
                aVar.fXv.setVisibility(8);
                aVar.fXB.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.eVS.setVisibility(8);
                aVar.fXw.setVisibility(8);
                aVar.fXA.setVisibility(8);
                aVar.fXy.setVisibility(8);
                aVar.fXx.setVisibility(8);
                aVar.fXz.setVisibility(8);
                aVar.fXC.setVisibility(8);
                aVar.eAe.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.eVS.setVisibility(0);
                if (this.dPJ) {
                    aVar.fXv.setVisibility(8);
                    aVar.fXw.setVisibility(8);
                    aVar.fXA.setVisibility(0);
                    aVar.fXy.setVisibility(0);
                    aVar.fXx.setVisibility(0);
                    aVar.fXz.setVisibility(8);
                    aVar.eAe.setVisibility(0);
                } else {
                    aVar.fXv.setVisibility(8);
                    aVar.fXw.setVisibility(8);
                    aVar.fXA.setVisibility(8);
                    aVar.fXy.setVisibility(8);
                    aVar.fXx.setVisibility(0);
                    aVar.fXz.setVisibility(0);
                    aVar.eAe.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.eVS.setTag(image_url);
                aVar.eVS.setImageDrawable(null);
                aVar.eVS.startLoad(image_url, 10, false);
                aVar.fXu.delete(0, aVar.fXu.length());
                aVar.fXu.append(forumData.getName());
                aVar.fXu.append(this.fXq.getPageContext().getString(f.j.forum));
                aVar.mName.setText(aVar.fXu);
                if (this.dPJ) {
                    am.c(aVar.fXx, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.fXA.setText(String.format(this.fXq.getPageContext().getString(f.j.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.fXB.setOnClickListener(this.fXr);
                    aVar.fXB.setTag(Integer.valueOf(i));
                    if (i < this.mData.bii()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(f.C0146f.icon_v), (Drawable) null);
                        if (!this.fVH && this.fXs) {
                            aVar.fXC.setVisibility(0);
                            aVar.fXC.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.fXC.setVisibility(8);
                    }
                    aVar.fXC.setOnClickListener(this.fXt);
                    aVar.fXD.setVisibility(8);
                    if (this.fVH && this.fXq.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.fVI)) {
                        aVar.fXD.setVisibility(0);
                    }
                } else {
                    if ((this.fXq.aMI() == 0 && i < this.mData.bii()) || (this.fXq.aMI() == 1 && i < this.mData.bij())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(f.C0146f.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.fXq.aMI() == 1) {
                        aVar.fXx.setVisibility(8);
                    }
                    aVar.fXC.setVisibility(8);
                    am.c(aVar.fXx, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.fXz.setText(forumData.getSlogan());
                }
                if (this.bmI) {
                    aVar.fXB.setVisibility(0);
                    aVar.fXC.setVisibility(8);
                } else {
                    aVar.fXB.setVisibility(8);
                    if (i < this.mData.bii() && this.dPJ && !this.fVH && this.fXs) {
                        aVar.fXC.setVisibility(0);
                    } else {
                        aVar.fXC.setVisibility(8);
                    }
                }
            }
            view2 = view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
        aI(view2);
        return view2;
    }

    private void aI(View view) {
        this.fXq.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.fXq.getLayoutMode().onModeChanged(view);
    }

    public void A(View.OnClickListener onClickListener) {
        this.fXr = onClickListener;
    }

    public void O(View.OnClickListener onClickListener) {
        this.fXt = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fiw) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void rU(String str) {
        this.fVI = str;
    }

    /* loaded from: classes3.dex */
    private class a {
        ImageView eAe;
        BarImageView eVS;
        TextView fXA;
        Button fXB;
        ImageView fXC;
        ImageView fXD;
        StringBuffer fXu;
        TextView fXv;
        TextView fXw;
        ImageView fXx;
        TextView fXy;
        TextView fXz;
        TextView mName;

        private a() {
        }
    }
}
