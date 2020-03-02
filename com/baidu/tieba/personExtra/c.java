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
    private boolean eLF;
    private boolean jiU;
    private String jiV;
    private PersonBarActivity jki;
    private boolean jkk;
    private View.OnClickListener jkl;
    private b mData;
    private ArrayList<ForumData> mForumList = null;
    private boolean dXX = false;
    private View.OnClickListener jkj = null;
    private boolean eLD = false;

    public c(PersonBarActivity personBarActivity, b bVar, boolean z, boolean z2) {
        this.mData = null;
        this.eLF = true;
        this.jiU = false;
        this.jkk = true;
        this.jki = personBarActivity;
        this.mData = bVar;
        this.eLF = z;
        this.jiU = z2;
        this.jkk = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void hC(boolean z) {
        this.dXX = z;
        notifyDataSetChanged();
    }

    public boolean aXN() {
        return this.dXX;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eLD) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void bgJ() {
        this.eLD = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.eLD = true;
        }
    }

    public boolean cvZ() {
        return this.eLD;
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
                view3 = LayoutInflater.from(this.jki.getPageContext().getContext()).inflate(R.layout.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.ieK = (BarImageView) view3.findViewById(R.id.forum_avatar);
                    aVar.ieK.setGifIconSupport(false);
                    aVar.ieK.setRadius(l.getDimens(this.jki, R.dimen.tbds10));
                    aVar.ieK.setConrers(15);
                    aVar.ieK.setPlaceHolder(2);
                    aVar.mName = (TextView) view3.findViewById(R.id.name);
                    aVar.jkm = new StringBuffer(10);
                    aVar.jkn = (TextView) view3.findViewById(R.id.degree);
                    aVar.jko = (TextView) view3.findViewById(R.id.degree_text);
                    aVar.jks = (TextView) view3.findViewById(R.id.experience);
                    aVar.jkq = (TextView) view3.findViewById(R.id.experience_title);
                    aVar.jkt = (Button) view3.findViewById(R.id.item_delete);
                    aVar.jkp = (ImageView) view3.findViewById(R.id.degree_text_ta);
                    aVar.jkr = (TextView) view3.findViewById(R.id.intro_ta);
                    aVar.jku = (ImageView) view3.findViewById(R.id.item_talk);
                    aVar.hHP = (ImageView) view3.findViewById(R.id.diver_buttom_px);
                    aVar.hHP.setVisibility(0);
                    aVar.jkv = (ImageView) view3.findViewById(R.id.item_selected);
                    view3.setTag(aVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    BdLog.e(exc.getMessage());
                    bX(view2);
                    return view2;
                }
            } else {
                aVar = (a) view.getTag();
                view3 = view;
            }
            if (this.eLD) {
                aVar.jkn.setVisibility(8);
                aVar.jkt.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.ieK.setVisibility(8);
                aVar.jko.setVisibility(8);
                aVar.jks.setVisibility(8);
                aVar.jkq.setVisibility(8);
                aVar.jkp.setVisibility(8);
                aVar.jkr.setVisibility(8);
                aVar.jku.setVisibility(8);
                aVar.hHP.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.ieK.setVisibility(0);
                if (this.eLF) {
                    aVar.jkn.setVisibility(8);
                    aVar.jko.setVisibility(8);
                    aVar.jks.setVisibility(0);
                    aVar.jkq.setVisibility(0);
                    aVar.jkp.setVisibility(0);
                    aVar.jkr.setVisibility(8);
                    aVar.hHP.setVisibility(0);
                } else {
                    aVar.jkn.setVisibility(8);
                    aVar.jko.setVisibility(8);
                    aVar.jks.setVisibility(8);
                    aVar.jkq.setVisibility(8);
                    aVar.jkp.setVisibility(0);
                    aVar.jkr.setVisibility(0);
                    aVar.hHP.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.ieK.setTag(image_url);
                aVar.ieK.setImageDrawable(null);
                aVar.ieK.startLoad(image_url, 10, false);
                aVar.jkm.delete(0, aVar.jkm.length());
                aVar.jkm.append(forumData.getName());
                aVar.jkm.append(this.jki.getPageContext().getString(R.string.forum));
                aVar.mName.setText(aVar.jkm);
                if (this.eLF) {
                    am.setImageResource(aVar.jkp, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.jks.setText(String.format(this.jki.getPageContext().getString(R.string.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.jkt.setOnClickListener(this.jkj);
                    aVar.jkt.setTag(Integer.valueOf(i));
                    if (i < this.mData.cvO()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_v), (Drawable) null);
                        if (!this.jiU && this.jkk) {
                            aVar.jku.setVisibility(0);
                            aVar.jku.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.jku.setVisibility(8);
                    }
                    aVar.jku.setOnClickListener(this.jkl);
                    aVar.jkv.setVisibility(8);
                    if (this.jiU && this.jki.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.jiV)) {
                        aVar.jkv.setVisibility(0);
                    }
                } else {
                    if ((this.jki.bXs() == 0 && i < this.mData.cvO()) || (this.jki.bXs() == 1 && i < this.mData.cvP())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.jki.bXs() == 1) {
                        aVar.jkp.setVisibility(8);
                    }
                    aVar.jku.setVisibility(8);
                    am.setImageResource(aVar.jkp, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.jkr.setText(forumData.getSlogan());
                }
                if (this.dXX) {
                    aVar.jkt.setVisibility(0);
                    aVar.jku.setVisibility(8);
                } else {
                    aVar.jkt.setVisibility(8);
                    if (i < this.mData.cvO() && this.eLF && !this.jiU && this.jkk) {
                        aVar.jku.setVisibility(0);
                    } else {
                        aVar.jku.setVisibility(8);
                    }
                }
            }
            view2 = view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
        bX(view2);
        return view2;
    }

    private void bX(View view) {
        this.jki.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.jki.getLayoutMode().onModeChanged(view);
    }

    public void J(View.OnClickListener onClickListener) {
        this.jkj = onClickListener;
    }

    public void U(View.OnClickListener onClickListener) {
        this.jkl = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.eLD) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void GL(String str) {
        this.jiV = str;
    }

    /* loaded from: classes11.dex */
    private class a {
        ImageView hHP;
        BarImageView ieK;
        StringBuffer jkm;
        TextView jkn;
        TextView jko;
        ImageView jkp;
        TextView jkq;
        TextView jkr;
        TextView jks;
        Button jkt;
        ImageView jku;
        ImageView jkv;
        TextView mName;

        private a() {
        }
    }
}
