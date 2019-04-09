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
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class b extends BaseAdapter {
    private boolean fCT;
    private boolean hMH;
    private String hMI;
    private PersonBarActivity hOe;
    private boolean hOg;
    private View.OnClickListener hOh;
    private com.baidu.tieba.personExtra.a mData;
    private ArrayList<ForumData> mForumList = null;
    private boolean cMJ = false;
    private View.OnClickListener hOf = null;
    private boolean gZy = false;

    public b(PersonBarActivity personBarActivity, com.baidu.tieba.personExtra.a aVar, boolean z, boolean z2) {
        this.mData = null;
        this.fCT = true;
        this.hMH = false;
        this.hOg = true;
        this.hOe = personBarActivity;
        this.mData = aVar;
        this.fCT = z;
        this.hMH = z2;
        this.hOg = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void fJ(boolean z) {
        this.cMJ = z;
        notifyDataSetChanged();
    }

    public boolean awp() {
        return this.cMJ;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gZy) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void bEN() {
        this.gZy = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.gZy = true;
        }
    }

    public boolean bRg() {
        return this.gZy;
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
                view3 = LayoutInflater.from(this.hOe.getPageContext().getContext()).inflate(d.h.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.gMK = (BarImageView) view3.findViewById(d.g.forum_avatar);
                    aVar.gMK.setGifIconSupport(false);
                    aVar.mName = (TextView) view3.findViewById(d.g.name);
                    aVar.hOi = new StringBuffer(10);
                    aVar.hOj = (TextView) view3.findViewById(d.g.degree);
                    aVar.hOk = (TextView) view3.findViewById(d.g.degree_text);
                    aVar.hOo = (TextView) view3.findViewById(d.g.experience);
                    aVar.hOm = (TextView) view3.findViewById(d.g.experience_title);
                    aVar.hOp = (Button) view3.findViewById(d.g.item_delete);
                    aVar.hOl = (ImageView) view3.findViewById(d.g.degree_text_ta);
                    aVar.hOn = (TextView) view3.findViewById(d.g.intro_ta);
                    aVar.hOq = (ImageView) view3.findViewById(d.g.item_talk);
                    aVar.gqL = (ImageView) view3.findViewById(d.g.diver_buttom_px);
                    aVar.gqL.setVisibility(0);
                    aVar.hOr = (ImageView) view3.findViewById(d.g.item_selected);
                    view3.setTag(aVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    BdLog.e(exc.getMessage());
                    bP(view2);
                    return view2;
                }
            } else {
                aVar = (a) view.getTag();
                view3 = view;
            }
            if (this.gZy) {
                aVar.hOj.setVisibility(8);
                aVar.hOp.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.gMK.setVisibility(8);
                aVar.hOk.setVisibility(8);
                aVar.hOo.setVisibility(8);
                aVar.hOm.setVisibility(8);
                aVar.hOl.setVisibility(8);
                aVar.hOn.setVisibility(8);
                aVar.hOq.setVisibility(8);
                aVar.gqL.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.gMK.setVisibility(0);
                if (this.fCT) {
                    aVar.hOj.setVisibility(8);
                    aVar.hOk.setVisibility(8);
                    aVar.hOo.setVisibility(0);
                    aVar.hOm.setVisibility(0);
                    aVar.hOl.setVisibility(0);
                    aVar.hOn.setVisibility(8);
                    aVar.gqL.setVisibility(0);
                } else {
                    aVar.hOj.setVisibility(8);
                    aVar.hOk.setVisibility(8);
                    aVar.hOo.setVisibility(8);
                    aVar.hOm.setVisibility(8);
                    aVar.hOl.setVisibility(0);
                    aVar.hOn.setVisibility(0);
                    aVar.gqL.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.gMK.setTag(image_url);
                aVar.gMK.setImageDrawable(null);
                aVar.gMK.startLoad(image_url, 10, false);
                aVar.hOi.delete(0, aVar.hOi.length());
                aVar.hOi.append(forumData.getName());
                aVar.hOi.append(this.hOe.getPageContext().getString(d.j.forum));
                aVar.mName.setText(aVar.hOi);
                if (this.fCT) {
                    al.c(aVar.hOl, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.hOo.setText(String.format(this.hOe.getPageContext().getString(d.j.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.hOp.setOnClickListener(this.hOf);
                    aVar.hOp.setTag(Integer.valueOf(i));
                    if (i < this.mData.bQV()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_v), (Drawable) null);
                        if (!this.hMH && this.hOg) {
                            aVar.hOq.setVisibility(0);
                            aVar.hOq.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.hOq.setVisibility(8);
                    }
                    aVar.hOq.setOnClickListener(this.hOh);
                    aVar.hOr.setVisibility(8);
                    if (this.hMH && this.hOe.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.hMI)) {
                        aVar.hOr.setVisibility(0);
                    }
                } else {
                    if ((this.hOe.bvp() == 0 && i < this.mData.bQV()) || (this.hOe.bvp() == 1 && i < this.mData.bQW())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.hOe.bvp() == 1) {
                        aVar.hOl.setVisibility(8);
                    }
                    aVar.hOq.setVisibility(8);
                    al.c(aVar.hOl, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.hOn.setText(forumData.getSlogan());
                }
                if (this.cMJ) {
                    aVar.hOp.setVisibility(0);
                    aVar.hOq.setVisibility(8);
                } else {
                    aVar.hOp.setVisibility(8);
                    if (i < this.mData.bQV() && this.fCT && !this.hMH && this.hOg) {
                        aVar.hOq.setVisibility(0);
                    } else {
                        aVar.hOq.setVisibility(8);
                    }
                }
            }
            view2 = view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
        bP(view2);
        return view2;
    }

    private void bP(View view) {
        this.hOe.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.hOe.getLayoutMode().onModeChanged(view);
    }

    public void D(View.OnClickListener onClickListener) {
        this.hOf = onClickListener;
    }

    public void P(View.OnClickListener onClickListener) {
        this.hOh = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.gZy) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void AD(String str) {
        this.hMI = str;
    }

    /* loaded from: classes6.dex */
    private class a {
        BarImageView gMK;
        ImageView gqL;
        StringBuffer hOi;
        TextView hOj;
        TextView hOk;
        ImageView hOl;
        TextView hOm;
        TextView hOn;
        TextView hOo;
        Button hOp;
        ImageView hOq;
        ImageView hOr;
        TextView mName;

        private a() {
        }
    }
}
