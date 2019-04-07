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
    private boolean hMG;
    private String hMH;
    private PersonBarActivity hOd;
    private boolean hOf;
    private View.OnClickListener hOg;
    private com.baidu.tieba.personExtra.a mData;
    private ArrayList<ForumData> mForumList = null;
    private boolean cMI = false;
    private View.OnClickListener hOe = null;
    private boolean gZx = false;

    public b(PersonBarActivity personBarActivity, com.baidu.tieba.personExtra.a aVar, boolean z, boolean z2) {
        this.mData = null;
        this.fCT = true;
        this.hMG = false;
        this.hOf = true;
        this.hOd = personBarActivity;
        this.mData = aVar;
        this.fCT = z;
        this.hMG = z2;
        this.hOf = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void fJ(boolean z) {
        this.cMI = z;
        notifyDataSetChanged();
    }

    public boolean awp() {
        return this.cMI;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gZx) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void bEN() {
        this.gZx = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.gZx = true;
        }
    }

    public boolean bRg() {
        return this.gZx;
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
                view3 = LayoutInflater.from(this.hOd.getPageContext().getContext()).inflate(d.h.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.gMJ = (BarImageView) view3.findViewById(d.g.forum_avatar);
                    aVar.gMJ.setGifIconSupport(false);
                    aVar.mName = (TextView) view3.findViewById(d.g.name);
                    aVar.hOh = new StringBuffer(10);
                    aVar.hOi = (TextView) view3.findViewById(d.g.degree);
                    aVar.hOj = (TextView) view3.findViewById(d.g.degree_text);
                    aVar.hOn = (TextView) view3.findViewById(d.g.experience);
                    aVar.hOl = (TextView) view3.findViewById(d.g.experience_title);
                    aVar.hOo = (Button) view3.findViewById(d.g.item_delete);
                    aVar.hOk = (ImageView) view3.findViewById(d.g.degree_text_ta);
                    aVar.hOm = (TextView) view3.findViewById(d.g.intro_ta);
                    aVar.hOp = (ImageView) view3.findViewById(d.g.item_talk);
                    aVar.gqK = (ImageView) view3.findViewById(d.g.diver_buttom_px);
                    aVar.gqK.setVisibility(0);
                    aVar.hOq = (ImageView) view3.findViewById(d.g.item_selected);
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
            if (this.gZx) {
                aVar.hOi.setVisibility(8);
                aVar.hOo.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.gMJ.setVisibility(8);
                aVar.hOj.setVisibility(8);
                aVar.hOn.setVisibility(8);
                aVar.hOl.setVisibility(8);
                aVar.hOk.setVisibility(8);
                aVar.hOm.setVisibility(8);
                aVar.hOp.setVisibility(8);
                aVar.gqK.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.gMJ.setVisibility(0);
                if (this.fCT) {
                    aVar.hOi.setVisibility(8);
                    aVar.hOj.setVisibility(8);
                    aVar.hOn.setVisibility(0);
                    aVar.hOl.setVisibility(0);
                    aVar.hOk.setVisibility(0);
                    aVar.hOm.setVisibility(8);
                    aVar.gqK.setVisibility(0);
                } else {
                    aVar.hOi.setVisibility(8);
                    aVar.hOj.setVisibility(8);
                    aVar.hOn.setVisibility(8);
                    aVar.hOl.setVisibility(8);
                    aVar.hOk.setVisibility(0);
                    aVar.hOm.setVisibility(0);
                    aVar.gqK.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.gMJ.setTag(image_url);
                aVar.gMJ.setImageDrawable(null);
                aVar.gMJ.startLoad(image_url, 10, false);
                aVar.hOh.delete(0, aVar.hOh.length());
                aVar.hOh.append(forumData.getName());
                aVar.hOh.append(this.hOd.getPageContext().getString(d.j.forum));
                aVar.mName.setText(aVar.hOh);
                if (this.fCT) {
                    al.c(aVar.hOk, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.hOn.setText(String.format(this.hOd.getPageContext().getString(d.j.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.hOo.setOnClickListener(this.hOe);
                    aVar.hOo.setTag(Integer.valueOf(i));
                    if (i < this.mData.bQV()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_v), (Drawable) null);
                        if (!this.hMG && this.hOf) {
                            aVar.hOp.setVisibility(0);
                            aVar.hOp.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.hOp.setVisibility(8);
                    }
                    aVar.hOp.setOnClickListener(this.hOg);
                    aVar.hOq.setVisibility(8);
                    if (this.hMG && this.hOd.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.hMH)) {
                        aVar.hOq.setVisibility(0);
                    }
                } else {
                    if ((this.hOd.bvp() == 0 && i < this.mData.bQV()) || (this.hOd.bvp() == 1 && i < this.mData.bQW())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.hOd.bvp() == 1) {
                        aVar.hOk.setVisibility(8);
                    }
                    aVar.hOp.setVisibility(8);
                    al.c(aVar.hOk, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.hOm.setText(forumData.getSlogan());
                }
                if (this.cMI) {
                    aVar.hOo.setVisibility(0);
                    aVar.hOp.setVisibility(8);
                } else {
                    aVar.hOo.setVisibility(8);
                    if (i < this.mData.bQV() && this.fCT && !this.hMG && this.hOf) {
                        aVar.hOp.setVisibility(0);
                    } else {
                        aVar.hOp.setVisibility(8);
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
        this.hOd.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.hOd.getLayoutMode().onModeChanged(view);
    }

    public void D(View.OnClickListener onClickListener) {
        this.hOe = onClickListener;
    }

    public void P(View.OnClickListener onClickListener) {
        this.hOg = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.gZx) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void AD(String str) {
        this.hMH = str;
    }

    /* loaded from: classes6.dex */
    private class a {
        BarImageView gMJ;
        ImageView gqK;
        StringBuffer hOh;
        TextView hOi;
        TextView hOj;
        ImageView hOk;
        TextView hOl;
        TextView hOm;
        TextView hOn;
        Button hOo;
        ImageView hOp;
        ImageView hOq;
        TextView mName;

        private a() {
        }
    }
}
