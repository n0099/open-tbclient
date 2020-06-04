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
    private boolean fEQ;
    private boolean knX;
    private String knY;
    private PersonBarActivity kpl;
    private boolean kpn;
    private View.OnClickListener kpo;
    private b mData;
    private ArrayList<ForumData> mForumList = null;
    private boolean eNn = false;
    private View.OnClickListener kpm = null;
    private boolean fEO = false;

    public c(PersonBarActivity personBarActivity, b bVar, boolean z, boolean z2) {
        this.mData = null;
        this.fEQ = true;
        this.knX = false;
        this.kpn = true;
        this.kpl = personBarActivity;
        this.mData = bVar;
        this.fEQ = z;
        this.knX = z2;
        this.kpn = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void iY(boolean z) {
        this.eNn = z;
        notifyDataSetChanged();
    }

    public boolean bmj() {
        return this.eNn;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fEO) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void bvY() {
        this.fEO = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.fEO = true;
        }
    }

    public boolean cOr() {
        return this.fEO;
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
                view3 = LayoutInflater.from(this.kpl.getPageContext().getContext()).inflate(R.layout.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.jgr = (BarImageView) view3.findViewById(R.id.forum_avatar);
                    aVar.jgr.setGifIconSupport(false);
                    aVar.jgr.setRadius(l.getDimens(this.kpl, R.dimen.tbds10));
                    aVar.jgr.setConrers(15);
                    aVar.jgr.setPlaceHolder(2);
                    aVar.mName = (TextView) view3.findViewById(R.id.name);
                    aVar.kpp = new StringBuffer(10);
                    aVar.kpq = (TextView) view3.findViewById(R.id.degree);
                    aVar.kpr = (TextView) view3.findViewById(R.id.degree_text);
                    aVar.kpv = (TextView) view3.findViewById(R.id.experience);
                    aVar.kpt = (TextView) view3.findViewById(R.id.experience_title);
                    aVar.kpw = (Button) view3.findViewById(R.id.item_delete);
                    aVar.kps = (ImageView) view3.findViewById(R.id.degree_text_ta);
                    aVar.kpu = (TextView) view3.findViewById(R.id.intro_ta);
                    aVar.kpx = (ImageView) view3.findViewById(R.id.item_talk);
                    aVar.iIQ = (ImageView) view3.findViewById(R.id.diver_buttom_px);
                    aVar.iIQ.setVisibility(0);
                    aVar.kpy = (ImageView) view3.findViewById(R.id.item_selected);
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
            if (this.fEO) {
                aVar.kpq.setVisibility(8);
                aVar.kpw.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.jgr.setVisibility(8);
                aVar.kpr.setVisibility(8);
                aVar.kpv.setVisibility(8);
                aVar.kpt.setVisibility(8);
                aVar.kps.setVisibility(8);
                aVar.kpu.setVisibility(8);
                aVar.kpx.setVisibility(8);
                aVar.iIQ.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.jgr.setVisibility(0);
                if (this.fEQ) {
                    aVar.kpq.setVisibility(8);
                    aVar.kpr.setVisibility(8);
                    aVar.kpv.setVisibility(0);
                    aVar.kpt.setVisibility(0);
                    aVar.kps.setVisibility(0);
                    aVar.kpu.setVisibility(8);
                    aVar.iIQ.setVisibility(0);
                } else {
                    aVar.kpq.setVisibility(8);
                    aVar.kpr.setVisibility(8);
                    aVar.kpv.setVisibility(8);
                    aVar.kpt.setVisibility(8);
                    aVar.kps.setVisibility(0);
                    aVar.kpu.setVisibility(0);
                    aVar.iIQ.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.jgr.setTag(image_url);
                aVar.jgr.setImageDrawable(null);
                aVar.jgr.startLoad(image_url, 10, false);
                aVar.kpp.delete(0, aVar.kpp.length());
                aVar.kpp.append(forumData.getName());
                aVar.kpp.append(this.kpl.getPageContext().getString(R.string.forum));
                aVar.mName.setText(aVar.kpp);
                if (this.fEQ) {
                    am.setImageResource(aVar.kps, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.kpv.setText(String.format(this.kpl.getPageContext().getString(R.string.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.kpw.setOnClickListener(this.kpm);
                    aVar.kpw.setTag(Integer.valueOf(i));
                    if (i < this.mData.cOg()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_v), (Drawable) null);
                        if (!this.knX && this.kpn) {
                            aVar.kpx.setVisibility(0);
                            aVar.kpx.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.kpx.setVisibility(8);
                    }
                    aVar.kpx.setOnClickListener(this.kpo);
                    aVar.kpy.setVisibility(8);
                    if (this.knX && this.kpl.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.knY)) {
                        aVar.kpy.setVisibility(0);
                    }
                } else {
                    if ((this.kpl.coR() == 0 && i < this.mData.cOg()) || (this.kpl.coR() == 1 && i < this.mData.cOh())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.kpl.coR() == 1) {
                        aVar.kps.setVisibility(8);
                    }
                    aVar.kpx.setVisibility(8);
                    am.setImageResource(aVar.kps, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.kpu.setText(forumData.getSlogan());
                }
                if (this.eNn) {
                    aVar.kpw.setVisibility(0);
                    aVar.kpx.setVisibility(8);
                } else {
                    aVar.kpw.setVisibility(8);
                    if (i < this.mData.cOg() && this.fEQ && !this.knX && this.kpn) {
                        aVar.kpx.setVisibility(0);
                    } else {
                        aVar.kpx.setVisibility(8);
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
        this.kpl.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.kpl.getLayoutMode().onModeChanged(view);
    }

    public void K(View.OnClickListener onClickListener) {
        this.kpm = onClickListener;
    }

    public void V(View.OnClickListener onClickListener) {
        this.kpo = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fEO) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void Kj(String str) {
        this.knY = str;
    }

    /* loaded from: classes11.dex */
    private class a {
        ImageView iIQ;
        BarImageView jgr;
        StringBuffer kpp;
        TextView kpq;
        TextView kpr;
        ImageView kps;
        TextView kpt;
        TextView kpu;
        TextView kpv;
        Button kpw;
        ImageView kpx;
        ImageView kpy;
        TextView mName;

        private a() {
        }
    }
}
