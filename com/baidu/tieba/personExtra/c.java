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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes23.dex */
public class c extends BaseAdapter {
    private boolean gQe;
    private boolean lXL;
    private String lXM;
    private PersonBarActivity lZb;
    private boolean lZd;
    private View.OnClickListener lZe;
    private b mData;
    private ArrayList<ForumData> mForumList = null;
    private boolean fQK = false;
    private View.OnClickListener lZc = null;
    private boolean gQc = false;

    public c(PersonBarActivity personBarActivity, b bVar, boolean z, boolean z2) {
        this.mData = null;
        this.gQe = true;
        this.lXL = false;
        this.lZd = true;
        this.lZb = personBarActivity;
        this.mData = bVar;
        this.gQe = z;
        this.lXL = z2;
        this.lZd = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void lk(boolean z) {
        this.fQK = z;
        notifyDataSetChanged();
    }

    public boolean bIt() {
        return this.fQK;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gQc) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void bUT() {
        this.gQc = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.gQc = true;
        }
    }

    public boolean dtV() {
        return this.gQc;
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
                view3 = LayoutInflater.from(this.lZb.getPageContext().getContext()).inflate(R.layout.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.kMb = (BarImageView) view3.findViewById(R.id.forum_avatar);
                    aVar.kMb.setGifIconSupport(false);
                    aVar.kMb.setRadius(l.getDimens(this.lZb, R.dimen.tbds10));
                    aVar.kMb.setConrers(15);
                    aVar.kMb.setPlaceHolder(2);
                    aVar.mName = (TextView) view3.findViewById(R.id.name);
                    aVar.lZf = new StringBuffer(10);
                    aVar.lZg = (TextView) view3.findViewById(R.id.degree);
                    aVar.lZh = (TextView) view3.findViewById(R.id.degree_text);
                    aVar.lZl = (TextView) view3.findViewById(R.id.experience);
                    aVar.lZj = (TextView) view3.findViewById(R.id.experience_title);
                    aVar.lZm = (Button) view3.findViewById(R.id.item_delete);
                    aVar.lZi = (ImageView) view3.findViewById(R.id.degree_text_ta);
                    aVar.lZk = (TextView) view3.findViewById(R.id.intro_ta);
                    aVar.lZn = (ImageView) view3.findViewById(R.id.item_talk);
                    aVar.koa = (ImageView) view3.findViewById(R.id.diver_buttom_px);
                    aVar.koa.setVisibility(0);
                    aVar.lZo = (ImageView) view3.findViewById(R.id.item_selected);
                    view3.setTag(aVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    BdLog.e(exc.getMessage());
                    cO(view2);
                    return view2;
                }
            } else {
                aVar = (a) view.getTag();
                view3 = view;
            }
            if (this.gQc) {
                aVar.lZg.setVisibility(8);
                aVar.lZm.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.kMb.setVisibility(8);
                aVar.lZh.setVisibility(8);
                aVar.lZl.setVisibility(8);
                aVar.lZj.setVisibility(8);
                aVar.lZi.setVisibility(8);
                aVar.lZk.setVisibility(8);
                aVar.lZn.setVisibility(8);
                aVar.koa.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.kMb.setVisibility(0);
                if (this.gQe) {
                    aVar.lZg.setVisibility(8);
                    aVar.lZh.setVisibility(8);
                    aVar.lZl.setVisibility(0);
                    aVar.lZj.setVisibility(0);
                    aVar.lZi.setVisibility(0);
                    aVar.lZk.setVisibility(8);
                    aVar.koa.setVisibility(0);
                } else {
                    aVar.lZg.setVisibility(8);
                    aVar.lZh.setVisibility(8);
                    aVar.lZl.setVisibility(8);
                    aVar.lZj.setVisibility(8);
                    aVar.lZi.setVisibility(0);
                    aVar.lZk.setVisibility(0);
                    aVar.koa.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.kMb.setTag(image_url);
                aVar.kMb.setImageDrawable(null);
                aVar.kMb.startLoad(image_url, 10, false);
                aVar.lZf.delete(0, aVar.lZf.length());
                aVar.lZf.append(forumData.getName());
                aVar.lZf.append(this.lZb.getPageContext().getString(R.string.forum));
                aVar.mName.setText(aVar.lZf);
                if (this.gQe) {
                    ap.setImageResource(aVar.lZi, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.lZl.setText(String.format(this.lZb.getPageContext().getString(R.string.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.lZm.setOnClickListener(this.lZc);
                    aVar.lZm.setTag(Integer.valueOf(i));
                    if (i < this.mData.dtK()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_v), (Drawable) null);
                        if (!this.lXL && this.lZd) {
                            aVar.lZn.setVisibility(0);
                            aVar.lZn.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.lZn.setVisibility(8);
                    }
                    aVar.lZn.setOnClickListener(this.lZe);
                    aVar.lZo.setVisibility(8);
                    if (this.lXL && this.lZb.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.lXM)) {
                        aVar.lZo.setVisibility(0);
                    }
                } else {
                    if ((this.lZb.cUe() == 0 && i < this.mData.dtK()) || (this.lZb.cUe() == 1 && i < this.mData.dtL())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.lZb.cUe() == 1) {
                        aVar.lZi.setVisibility(8);
                    }
                    aVar.lZn.setVisibility(8);
                    ap.setImageResource(aVar.lZi, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.lZk.setText(forumData.getSlogan());
                }
                if (this.fQK) {
                    aVar.lZm.setVisibility(0);
                    aVar.lZn.setVisibility(8);
                } else {
                    aVar.lZm.setVisibility(8);
                    if (i < this.mData.dtK() && this.gQe && !this.lXL && this.lZd) {
                        aVar.lZn.setVisibility(0);
                    } else {
                        aVar.lZn.setVisibility(8);
                    }
                }
            }
            view2 = view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
        cO(view2);
        return view2;
    }

    private void cO(View view) {
        this.lZb.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.lZb.getLayoutMode().onModeChanged(view);
    }

    public void M(View.OnClickListener onClickListener) {
        this.lZc = onClickListener;
    }

    public void Y(View.OnClickListener onClickListener) {
        this.lZe = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.gQc) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void PS(String str) {
        this.lXM = str;
    }

    /* loaded from: classes23.dex */
    private class a {
        BarImageView kMb;
        ImageView koa;
        StringBuffer lZf;
        TextView lZg;
        TextView lZh;
        ImageView lZi;
        TextView lZj;
        TextView lZk;
        TextView lZl;
        Button lZm;
        ImageView lZn;
        ImageView lZo;
        TextView mName;

        private a() {
        }
    }
}
