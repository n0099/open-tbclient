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
    private boolean gZr;
    private b mData;
    private boolean mlT;
    private String mlU;
    private PersonBarActivity mnj;
    private boolean mnl;
    private View.OnClickListener mnm;
    private ArrayList<ForumData> mForumList = null;
    private boolean fYT = false;
    private View.OnClickListener mnk = null;
    private boolean gZp = false;

    public c(PersonBarActivity personBarActivity, b bVar, boolean z, boolean z2) {
        this.mData = null;
        this.gZr = true;
        this.mlT = false;
        this.mnl = true;
        this.mnj = personBarActivity;
        this.mData = bVar;
        this.gZr = z;
        this.mlT = z2;
        this.mnl = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void lF(boolean z) {
        this.fYT = z;
        notifyDataSetChanged();
    }

    public boolean bMb() {
        return this.fYT;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gZp) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void bYC() {
        this.gZp = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.gZp = true;
        }
    }

    public boolean dzn() {
        return this.gZp;
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
                view3 = LayoutInflater.from(this.mnj.getPageContext().getContext()).inflate(R.layout.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.kZs = (BarImageView) view3.findViewById(R.id.forum_avatar);
                    aVar.kZs.setGifIconSupport(false);
                    aVar.kZs.setRadius(l.getDimens(this.mnj, R.dimen.tbds10));
                    aVar.kZs.setConrers(15);
                    aVar.kZs.setPlaceHolder(2);
                    aVar.mName = (TextView) view3.findViewById(R.id.name);
                    aVar.mnn = new StringBuffer(10);
                    aVar.mno = (TextView) view3.findViewById(R.id.degree);
                    aVar.mnp = (TextView) view3.findViewById(R.id.degree_text);
                    aVar.mnt = (TextView) view3.findViewById(R.id.experience);
                    aVar.mnr = (TextView) view3.findViewById(R.id.experience_title);
                    aVar.mnu = (Button) view3.findViewById(R.id.item_delete);
                    aVar.mnq = (ImageView) view3.findViewById(R.id.degree_text_ta);
                    aVar.mns = (TextView) view3.findViewById(R.id.intro_ta);
                    aVar.mnv = (ImageView) view3.findViewById(R.id.item_talk);
                    aVar.kBw = (ImageView) view3.findViewById(R.id.diver_buttom_px);
                    aVar.kBw.setVisibility(0);
                    aVar.mnw = (ImageView) view3.findViewById(R.id.item_selected);
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
            if (this.gZp) {
                aVar.mno.setVisibility(8);
                aVar.mnu.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.kZs.setVisibility(8);
                aVar.mnp.setVisibility(8);
                aVar.mnt.setVisibility(8);
                aVar.mnr.setVisibility(8);
                aVar.mnq.setVisibility(8);
                aVar.mns.setVisibility(8);
                aVar.mnv.setVisibility(8);
                aVar.kBw.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.kZs.setVisibility(0);
                if (this.gZr) {
                    aVar.mno.setVisibility(8);
                    aVar.mnp.setVisibility(8);
                    aVar.mnt.setVisibility(0);
                    aVar.mnr.setVisibility(0);
                    aVar.mnq.setVisibility(0);
                    aVar.mns.setVisibility(8);
                    aVar.kBw.setVisibility(0);
                } else {
                    aVar.mno.setVisibility(8);
                    aVar.mnp.setVisibility(8);
                    aVar.mnt.setVisibility(8);
                    aVar.mnr.setVisibility(8);
                    aVar.mnq.setVisibility(0);
                    aVar.mns.setVisibility(0);
                    aVar.kBw.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.kZs.setTag(image_url);
                aVar.kZs.setImageDrawable(null);
                aVar.kZs.startLoad(image_url, 10, false);
                aVar.mnn.delete(0, aVar.mnn.length());
                aVar.mnn.append(forumData.getName());
                aVar.mnn.append(this.mnj.getPageContext().getString(R.string.forum));
                aVar.mName.setText(aVar.mnn);
                if (this.gZr) {
                    ap.setImageResource(aVar.mnq, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.mnt.setText(String.format(this.mnj.getPageContext().getString(R.string.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.mnu.setOnClickListener(this.mnk);
                    aVar.mnu.setTag(Integer.valueOf(i));
                    if (i < this.mData.dzc()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_v), (Drawable) null);
                        if (!this.mlT && this.mnl) {
                            aVar.mnv.setVisibility(0);
                            aVar.mnv.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.mnv.setVisibility(8);
                    }
                    aVar.mnv.setOnClickListener(this.mnm);
                    aVar.mnw.setVisibility(8);
                    if (this.mlT && this.mnj.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.mlU)) {
                        aVar.mnw.setVisibility(0);
                    }
                } else {
                    if ((this.mnj.cZq() == 0 && i < this.mData.dzc()) || (this.mnj.cZq() == 1 && i < this.mData.dzd())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.mnj.cZq() == 1) {
                        aVar.mnq.setVisibility(8);
                    }
                    aVar.mnv.setVisibility(8);
                    ap.setImageResource(aVar.mnq, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.mns.setText(forumData.getSlogan());
                }
                if (this.fYT) {
                    aVar.mnu.setVisibility(0);
                    aVar.mnv.setVisibility(8);
                } else {
                    aVar.mnu.setVisibility(8);
                    if (i < this.mData.dzc() && this.gZr && !this.mlT && this.mnl) {
                        aVar.mnv.setVisibility(0);
                    } else {
                        aVar.mnv.setVisibility(8);
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
        this.mnj.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.mnj.getLayoutMode().onModeChanged(view);
    }

    public void M(View.OnClickListener onClickListener) {
        this.mnk = onClickListener;
    }

    public void Y(View.OnClickListener onClickListener) {
        this.mnm = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.gZp) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void Rb(String str) {
        this.mlU = str;
    }

    /* loaded from: classes24.dex */
    private class a {
        ImageView kBw;
        BarImageView kZs;
        TextView mName;
        StringBuffer mnn;
        TextView mno;
        TextView mnp;
        ImageView mnq;
        TextView mnr;
        TextView mns;
        TextView mnt;
        Button mnu;
        ImageView mnv;
        ImageView mnw;

        private a() {
        }
    }
}
