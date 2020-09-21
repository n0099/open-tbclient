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
    private boolean gkE;
    private boolean lpO;
    private String lpP;
    private PersonBarActivity lre;
    private boolean lrg;
    private View.OnClickListener lrh;
    private b mData;
    private ArrayList<ForumData> mForumList = null;
    private boolean fqD = false;
    private View.OnClickListener lrf = null;
    private boolean gkC = false;

    public c(PersonBarActivity personBarActivity, b bVar, boolean z, boolean z2) {
        this.mData = null;
        this.gkE = true;
        this.lpO = false;
        this.lrg = true;
        this.lre = personBarActivity;
        this.mData = bVar;
        this.gkE = z;
        this.lpO = z2;
        this.lrg = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void kp(boolean z) {
        this.fqD = z;
        notifyDataSetChanged();
    }

    public boolean bBV() {
        return this.fqD;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gkC) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void bMN() {
        this.gkC = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.gkC = true;
        }
    }

    public boolean dlc() {
        return this.gkC;
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
                view3 = LayoutInflater.from(this.lre.getPageContext().getContext()).inflate(R.layout.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.kef = (BarImageView) view3.findViewById(R.id.forum_avatar);
                    aVar.kef.setGifIconSupport(false);
                    aVar.kef.setRadius(l.getDimens(this.lre, R.dimen.tbds10));
                    aVar.kef.setConrers(15);
                    aVar.kef.setPlaceHolder(2);
                    aVar.mName = (TextView) view3.findViewById(R.id.name);
                    aVar.lri = new StringBuffer(10);
                    aVar.lrj = (TextView) view3.findViewById(R.id.degree);
                    aVar.lrk = (TextView) view3.findViewById(R.id.degree_text);
                    aVar.lro = (TextView) view3.findViewById(R.id.experience);
                    aVar.lrm = (TextView) view3.findViewById(R.id.experience_title);
                    aVar.lrp = (Button) view3.findViewById(R.id.item_delete);
                    aVar.lrl = (ImageView) view3.findViewById(R.id.degree_text_ta);
                    aVar.lrn = (TextView) view3.findViewById(R.id.intro_ta);
                    aVar.lrq = (ImageView) view3.findViewById(R.id.item_talk);
                    aVar.jFW = (ImageView) view3.findViewById(R.id.diver_buttom_px);
                    aVar.jFW.setVisibility(0);
                    aVar.lrr = (ImageView) view3.findViewById(R.id.item_selected);
                    view3.setTag(aVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    BdLog.e(exc.getMessage());
                    cx(view2);
                    return view2;
                }
            } else {
                aVar = (a) view.getTag();
                view3 = view;
            }
            if (this.gkC) {
                aVar.lrj.setVisibility(8);
                aVar.lrp.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.kef.setVisibility(8);
                aVar.lrk.setVisibility(8);
                aVar.lro.setVisibility(8);
                aVar.lrm.setVisibility(8);
                aVar.lrl.setVisibility(8);
                aVar.lrn.setVisibility(8);
                aVar.lrq.setVisibility(8);
                aVar.jFW.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.kef.setVisibility(0);
                if (this.gkE) {
                    aVar.lrj.setVisibility(8);
                    aVar.lrk.setVisibility(8);
                    aVar.lro.setVisibility(0);
                    aVar.lrm.setVisibility(0);
                    aVar.lrl.setVisibility(0);
                    aVar.lrn.setVisibility(8);
                    aVar.jFW.setVisibility(0);
                } else {
                    aVar.lrj.setVisibility(8);
                    aVar.lrk.setVisibility(8);
                    aVar.lro.setVisibility(8);
                    aVar.lrm.setVisibility(8);
                    aVar.lrl.setVisibility(0);
                    aVar.lrn.setVisibility(0);
                    aVar.jFW.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.kef.setTag(image_url);
                aVar.kef.setImageDrawable(null);
                aVar.kef.startLoad(image_url, 10, false);
                aVar.lri.delete(0, aVar.lri.length());
                aVar.lri.append(forumData.getName());
                aVar.lri.append(this.lre.getPageContext().getString(R.string.forum));
                aVar.mName.setText(aVar.lri);
                if (this.gkE) {
                    ap.setImageResource(aVar.lrl, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.lro.setText(String.format(this.lre.getPageContext().getString(R.string.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.lrp.setOnClickListener(this.lrf);
                    aVar.lrp.setTag(Integer.valueOf(i));
                    if (i < this.mData.dkR()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_v), (Drawable) null);
                        if (!this.lpO && this.lrg) {
                            aVar.lrq.setVisibility(0);
                            aVar.lrq.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.lrq.setVisibility(8);
                    }
                    aVar.lrq.setOnClickListener(this.lrh);
                    aVar.lrr.setVisibility(8);
                    if (this.lpO && this.lre.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.lpP)) {
                        aVar.lrr.setVisibility(0);
                    }
                } else {
                    if ((this.lre.cLh() == 0 && i < this.mData.dkR()) || (this.lre.cLh() == 1 && i < this.mData.dkS())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.lre.cLh() == 1) {
                        aVar.lrl.setVisibility(8);
                    }
                    aVar.lrq.setVisibility(8);
                    ap.setImageResource(aVar.lrl, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.lrn.setText(forumData.getSlogan());
                }
                if (this.fqD) {
                    aVar.lrp.setVisibility(0);
                    aVar.lrq.setVisibility(8);
                } else {
                    aVar.lrp.setVisibility(8);
                    if (i < this.mData.dkR() && this.gkE && !this.lpO && this.lrg) {
                        aVar.lrq.setVisibility(0);
                    } else {
                        aVar.lrq.setVisibility(8);
                    }
                }
            }
            view2 = view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
        cx(view2);
        return view2;
    }

    private void cx(View view) {
        this.lre.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.lre.getLayoutMode().onModeChanged(view);
    }

    public void M(View.OnClickListener onClickListener) {
        this.lrf = onClickListener;
    }

    public void Y(View.OnClickListener onClickListener) {
        this.lrh = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.gkC) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void OT(String str) {
        this.lpP = str;
    }

    /* loaded from: classes23.dex */
    private class a {
        ImageView jFW;
        BarImageView kef;
        StringBuffer lri;
        TextView lrj;
        TextView lrk;
        ImageView lrl;
        TextView lrm;
        TextView lrn;
        TextView lro;
        Button lrp;
        ImageView lrq;
        ImageView lrr;
        TextView mName;

        private a() {
        }
    }
}
