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
    private boolean fqL;
    private boolean jUY;
    private String jUZ;
    private PersonBarActivity jWm;
    private boolean jWo;
    private View.OnClickListener jWp;
    private b mData;
    private ArrayList<ForumData> mForumList = null;
    private boolean eyC = false;
    private View.OnClickListener jWn = null;
    private boolean fqJ = false;

    public c(PersonBarActivity personBarActivity, b bVar, boolean z, boolean z2) {
        this.mData = null;
        this.fqL = true;
        this.jUY = false;
        this.jWo = true;
        this.jWm = personBarActivity;
        this.mData = bVar;
        this.fqL = z;
        this.jUY = z2;
        this.jWo = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void iB(boolean z) {
        this.eyC = z;
        notifyDataSetChanged();
    }

    public boolean bfV() {
        return this.eyC;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fqJ) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void bqe() {
        this.fqJ = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.fqJ = true;
        }
    }

    public boolean cHc() {
        return this.fqJ;
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
                view3 = LayoutInflater.from(this.jWm.getPageContext().getContext()).inflate(R.layout.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.iQD = (BarImageView) view3.findViewById(R.id.forum_avatar);
                    aVar.iQD.setGifIconSupport(false);
                    aVar.iQD.setRadius(l.getDimens(this.jWm, R.dimen.tbds10));
                    aVar.iQD.setConrers(15);
                    aVar.iQD.setPlaceHolder(2);
                    aVar.mName = (TextView) view3.findViewById(R.id.name);
                    aVar.jWq = new StringBuffer(10);
                    aVar.jWr = (TextView) view3.findViewById(R.id.degree);
                    aVar.jWs = (TextView) view3.findViewById(R.id.degree_text);
                    aVar.jWw = (TextView) view3.findViewById(R.id.experience);
                    aVar.jWu = (TextView) view3.findViewById(R.id.experience_title);
                    aVar.jWx = (Button) view3.findViewById(R.id.item_delete);
                    aVar.jWt = (ImageView) view3.findViewById(R.id.degree_text_ta);
                    aVar.jWv = (TextView) view3.findViewById(R.id.intro_ta);
                    aVar.jWy = (ImageView) view3.findViewById(R.id.item_talk);
                    aVar.itx = (ImageView) view3.findViewById(R.id.diver_buttom_px);
                    aVar.itx.setVisibility(0);
                    aVar.jWz = (ImageView) view3.findViewById(R.id.item_selected);
                    view3.setTag(aVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    BdLog.e(exc.getMessage());
                    cf(view2);
                    return view2;
                }
            } else {
                aVar = (a) view.getTag();
                view3 = view;
            }
            if (this.fqJ) {
                aVar.jWr.setVisibility(8);
                aVar.jWx.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.iQD.setVisibility(8);
                aVar.jWs.setVisibility(8);
                aVar.jWw.setVisibility(8);
                aVar.jWu.setVisibility(8);
                aVar.jWt.setVisibility(8);
                aVar.jWv.setVisibility(8);
                aVar.jWy.setVisibility(8);
                aVar.itx.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.iQD.setVisibility(0);
                if (this.fqL) {
                    aVar.jWr.setVisibility(8);
                    aVar.jWs.setVisibility(8);
                    aVar.jWw.setVisibility(0);
                    aVar.jWu.setVisibility(0);
                    aVar.jWt.setVisibility(0);
                    aVar.jWv.setVisibility(8);
                    aVar.itx.setVisibility(0);
                } else {
                    aVar.jWr.setVisibility(8);
                    aVar.jWs.setVisibility(8);
                    aVar.jWw.setVisibility(8);
                    aVar.jWu.setVisibility(8);
                    aVar.jWt.setVisibility(0);
                    aVar.jWv.setVisibility(0);
                    aVar.itx.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.iQD.setTag(image_url);
                aVar.iQD.setImageDrawable(null);
                aVar.iQD.startLoad(image_url, 10, false);
                aVar.jWq.delete(0, aVar.jWq.length());
                aVar.jWq.append(forumData.getName());
                aVar.jWq.append(this.jWm.getPageContext().getString(R.string.forum));
                aVar.mName.setText(aVar.jWq);
                if (this.fqL) {
                    am.setImageResource(aVar.jWt, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.jWw.setText(String.format(this.jWm.getPageContext().getString(R.string.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.jWx.setOnClickListener(this.jWn);
                    aVar.jWx.setTag(Integer.valueOf(i));
                    if (i < this.mData.cGR()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_v), (Drawable) null);
                        if (!this.jUY && this.jWo) {
                            aVar.jWy.setVisibility(0);
                            aVar.jWy.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.jWy.setVisibility(8);
                    }
                    aVar.jWy.setOnClickListener(this.jWp);
                    aVar.jWz.setVisibility(8);
                    if (this.jUY && this.jWm.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.jUZ)) {
                        aVar.jWz.setVisibility(0);
                    }
                } else {
                    if ((this.jWm.cil() == 0 && i < this.mData.cGR()) || (this.jWm.cil() == 1 && i < this.mData.cGS())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.jWm.cil() == 1) {
                        aVar.jWt.setVisibility(8);
                    }
                    aVar.jWy.setVisibility(8);
                    am.setImageResource(aVar.jWt, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.jWv.setText(forumData.getSlogan());
                }
                if (this.eyC) {
                    aVar.jWx.setVisibility(0);
                    aVar.jWy.setVisibility(8);
                } else {
                    aVar.jWx.setVisibility(8);
                    if (i < this.mData.cGR() && this.fqL && !this.jUY && this.jWo) {
                        aVar.jWy.setVisibility(0);
                    } else {
                        aVar.jWy.setVisibility(8);
                    }
                }
            }
            view2 = view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
        cf(view2);
        return view2;
    }

    private void cf(View view) {
        this.jWm.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.jWm.getLayoutMode().onModeChanged(view);
    }

    public void K(View.OnClickListener onClickListener) {
        this.jWn = onClickListener;
    }

    public void V(View.OnClickListener onClickListener) {
        this.jWp = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fqJ) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void Iw(String str) {
        this.jUZ = str;
    }

    /* loaded from: classes11.dex */
    private class a {
        BarImageView iQD;
        ImageView itx;
        StringBuffer jWq;
        TextView jWr;
        TextView jWs;
        ImageView jWt;
        TextView jWu;
        TextView jWv;
        TextView jWw;
        Button jWx;
        ImageView jWy;
        ImageView jWz;
        TextView mName;

        private a() {
        }
    }
}
