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
/* loaded from: classes24.dex */
public class c extends BaseAdapter {
    private boolean gZt;
    private b mData;
    private boolean mlV;
    private String mlW;
    private PersonBarActivity mnl;
    private boolean mnn;
    private View.OnClickListener mno;
    private ArrayList<ForumData> mForumList = null;
    private boolean fYV = false;
    private View.OnClickListener mnm = null;
    private boolean gZr = false;

    public c(PersonBarActivity personBarActivity, b bVar, boolean z, boolean z2) {
        this.mData = null;
        this.gZt = true;
        this.mlV = false;
        this.mnn = true;
        this.mnl = personBarActivity;
        this.mData = bVar;
        this.gZt = z;
        this.mlV = z2;
        this.mnn = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void lF(boolean z) {
        this.fYV = z;
        notifyDataSetChanged();
    }

    public boolean bMc() {
        return this.fYV;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gZr) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void bYD() {
        this.gZr = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.gZr = true;
        }
    }

    public boolean dzo() {
        return this.gZr;
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
                view3 = LayoutInflater.from(this.mnl.getPageContext().getContext()).inflate(R.layout.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.kZu = (BarImageView) view3.findViewById(R.id.forum_avatar);
                    aVar.kZu.setGifIconSupport(false);
                    aVar.kZu.setRadius(l.getDimens(this.mnl, R.dimen.tbds10));
                    aVar.kZu.setConrers(15);
                    aVar.kZu.setPlaceHolder(2);
                    aVar.mName = (TextView) view3.findViewById(R.id.name);
                    aVar.mnp = new StringBuffer(10);
                    aVar.mnq = (TextView) view3.findViewById(R.id.degree);
                    aVar.mnr = (TextView) view3.findViewById(R.id.degree_text);
                    aVar.mnv = (TextView) view3.findViewById(R.id.experience);
                    aVar.mnt = (TextView) view3.findViewById(R.id.experience_title);
                    aVar.mnw = (Button) view3.findViewById(R.id.item_delete);
                    aVar.mns = (ImageView) view3.findViewById(R.id.degree_text_ta);
                    aVar.mnu = (TextView) view3.findViewById(R.id.intro_ta);
                    aVar.mnx = (ImageView) view3.findViewById(R.id.item_talk);
                    aVar.kBy = (ImageView) view3.findViewById(R.id.diver_buttom_px);
                    aVar.kBy.setVisibility(0);
                    aVar.mny = (ImageView) view3.findViewById(R.id.item_selected);
                    view3.setTag(aVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    BdLog.e(exc.getMessage());
                    cV(view2);
                    return view2;
                }
            } else {
                aVar = (a) view.getTag();
                view3 = view;
            }
            if (this.gZr) {
                aVar.mnq.setVisibility(8);
                aVar.mnw.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.kZu.setVisibility(8);
                aVar.mnr.setVisibility(8);
                aVar.mnv.setVisibility(8);
                aVar.mnt.setVisibility(8);
                aVar.mns.setVisibility(8);
                aVar.mnu.setVisibility(8);
                aVar.mnx.setVisibility(8);
                aVar.kBy.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.kZu.setVisibility(0);
                if (this.gZt) {
                    aVar.mnq.setVisibility(8);
                    aVar.mnr.setVisibility(8);
                    aVar.mnv.setVisibility(0);
                    aVar.mnt.setVisibility(0);
                    aVar.mns.setVisibility(0);
                    aVar.mnu.setVisibility(8);
                    aVar.kBy.setVisibility(0);
                } else {
                    aVar.mnq.setVisibility(8);
                    aVar.mnr.setVisibility(8);
                    aVar.mnv.setVisibility(8);
                    aVar.mnt.setVisibility(8);
                    aVar.mns.setVisibility(0);
                    aVar.mnu.setVisibility(0);
                    aVar.kBy.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.kZu.setTag(image_url);
                aVar.kZu.setImageDrawable(null);
                aVar.kZu.startLoad(image_url, 10, false);
                aVar.mnp.delete(0, aVar.mnp.length());
                aVar.mnp.append(forumData.getName());
                aVar.mnp.append(this.mnl.getPageContext().getString(R.string.forum));
                aVar.mName.setText(aVar.mnp);
                if (this.gZt) {
                    ap.setImageResource(aVar.mns, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.mnv.setText(String.format(this.mnl.getPageContext().getString(R.string.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.mnw.setOnClickListener(this.mnm);
                    aVar.mnw.setTag(Integer.valueOf(i));
                    if (i < this.mData.dzd()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_v), (Drawable) null);
                        if (!this.mlV && this.mnn) {
                            aVar.mnx.setVisibility(0);
                            aVar.mnx.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.mnx.setVisibility(8);
                    }
                    aVar.mnx.setOnClickListener(this.mno);
                    aVar.mny.setVisibility(8);
                    if (this.mlV && this.mnl.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.mlW)) {
                        aVar.mny.setVisibility(0);
                    }
                } else {
                    if ((this.mnl.cZr() == 0 && i < this.mData.dzd()) || (this.mnl.cZr() == 1 && i < this.mData.dze())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.mnl.cZr() == 1) {
                        aVar.mns.setVisibility(8);
                    }
                    aVar.mnx.setVisibility(8);
                    ap.setImageResource(aVar.mns, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.mnu.setText(forumData.getSlogan());
                }
                if (this.fYV) {
                    aVar.mnw.setVisibility(0);
                    aVar.mnx.setVisibility(8);
                } else {
                    aVar.mnw.setVisibility(8);
                    if (i < this.mData.dzd() && this.gZt && !this.mlV && this.mnn) {
                        aVar.mnx.setVisibility(0);
                    } else {
                        aVar.mnx.setVisibility(8);
                    }
                }
            }
            view2 = view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
        cV(view2);
        return view2;
    }

    private void cV(View view) {
        this.mnl.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.mnl.getLayoutMode().onModeChanged(view);
    }

    public void M(View.OnClickListener onClickListener) {
        this.mnm = onClickListener;
    }

    public void Y(View.OnClickListener onClickListener) {
        this.mno = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.gZr) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void Rb(String str) {
        this.mlW = str;
    }

    /* loaded from: classes24.dex */
    private class a {
        ImageView kBy;
        BarImageView kZu;
        TextView mName;
        StringBuffer mnp;
        TextView mnq;
        TextView mnr;
        ImageView mns;
        TextView mnt;
        TextView mnu;
        TextView mnv;
        Button mnw;
        ImageView mnx;
        ImageView mny;

        private a() {
        }
    }
}
