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
    private boolean eLE;
    private boolean jiS;
    private String jiT;
    private PersonBarActivity jkg;
    private boolean jki;
    private View.OnClickListener jkj;
    private b mData;
    private ArrayList<ForumData> mForumList = null;
    private boolean dXW = false;
    private View.OnClickListener jkh = null;
    private boolean eLC = false;

    public c(PersonBarActivity personBarActivity, b bVar, boolean z, boolean z2) {
        this.mData = null;
        this.eLE = true;
        this.jiS = false;
        this.jki = true;
        this.jkg = personBarActivity;
        this.mData = bVar;
        this.eLE = z;
        this.jiS = z2;
        this.jki = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void hC(boolean z) {
        this.dXW = z;
        notifyDataSetChanged();
    }

    public boolean aXL() {
        return this.dXW;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eLC) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void bgH() {
        this.eLC = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.eLC = true;
        }
    }

    public boolean cvX() {
        return this.eLC;
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
                view3 = LayoutInflater.from(this.jkg.getPageContext().getContext()).inflate(R.layout.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.ieI = (BarImageView) view3.findViewById(R.id.forum_avatar);
                    aVar.ieI.setGifIconSupport(false);
                    aVar.ieI.setRadius(l.getDimens(this.jkg, R.dimen.tbds10));
                    aVar.ieI.setConrers(15);
                    aVar.ieI.setPlaceHolder(2);
                    aVar.mName = (TextView) view3.findViewById(R.id.name);
                    aVar.jkk = new StringBuffer(10);
                    aVar.jkl = (TextView) view3.findViewById(R.id.degree);
                    aVar.jkm = (TextView) view3.findViewById(R.id.degree_text);
                    aVar.jkq = (TextView) view3.findViewById(R.id.experience);
                    aVar.jko = (TextView) view3.findViewById(R.id.experience_title);
                    aVar.jkr = (Button) view3.findViewById(R.id.item_delete);
                    aVar.jkn = (ImageView) view3.findViewById(R.id.degree_text_ta);
                    aVar.jkp = (TextView) view3.findViewById(R.id.intro_ta);
                    aVar.jks = (ImageView) view3.findViewById(R.id.item_talk);
                    aVar.hHN = (ImageView) view3.findViewById(R.id.diver_buttom_px);
                    aVar.hHN.setVisibility(0);
                    aVar.jkt = (ImageView) view3.findViewById(R.id.item_selected);
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
            if (this.eLC) {
                aVar.jkl.setVisibility(8);
                aVar.jkr.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.ieI.setVisibility(8);
                aVar.jkm.setVisibility(8);
                aVar.jkq.setVisibility(8);
                aVar.jko.setVisibility(8);
                aVar.jkn.setVisibility(8);
                aVar.jkp.setVisibility(8);
                aVar.jks.setVisibility(8);
                aVar.hHN.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.ieI.setVisibility(0);
                if (this.eLE) {
                    aVar.jkl.setVisibility(8);
                    aVar.jkm.setVisibility(8);
                    aVar.jkq.setVisibility(0);
                    aVar.jko.setVisibility(0);
                    aVar.jkn.setVisibility(0);
                    aVar.jkp.setVisibility(8);
                    aVar.hHN.setVisibility(0);
                } else {
                    aVar.jkl.setVisibility(8);
                    aVar.jkm.setVisibility(8);
                    aVar.jkq.setVisibility(8);
                    aVar.jko.setVisibility(8);
                    aVar.jkn.setVisibility(0);
                    aVar.jkp.setVisibility(0);
                    aVar.hHN.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.ieI.setTag(image_url);
                aVar.ieI.setImageDrawable(null);
                aVar.ieI.startLoad(image_url, 10, false);
                aVar.jkk.delete(0, aVar.jkk.length());
                aVar.jkk.append(forumData.getName());
                aVar.jkk.append(this.jkg.getPageContext().getString(R.string.forum));
                aVar.mName.setText(aVar.jkk);
                if (this.eLE) {
                    am.setImageResource(aVar.jkn, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.jkq.setText(String.format(this.jkg.getPageContext().getString(R.string.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.jkr.setOnClickListener(this.jkh);
                    aVar.jkr.setTag(Integer.valueOf(i));
                    if (i < this.mData.cvM()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_v), (Drawable) null);
                        if (!this.jiS && this.jki) {
                            aVar.jks.setVisibility(0);
                            aVar.jks.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.jks.setVisibility(8);
                    }
                    aVar.jks.setOnClickListener(this.jkj);
                    aVar.jkt.setVisibility(8);
                    if (this.jiS && this.jkg.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.jiT)) {
                        aVar.jkt.setVisibility(0);
                    }
                } else {
                    if ((this.jkg.bXq() == 0 && i < this.mData.cvM()) || (this.jkg.bXq() == 1 && i < this.mData.cvN())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.jkg.bXq() == 1) {
                        aVar.jkn.setVisibility(8);
                    }
                    aVar.jks.setVisibility(8);
                    am.setImageResource(aVar.jkn, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.jkp.setText(forumData.getSlogan());
                }
                if (this.dXW) {
                    aVar.jkr.setVisibility(0);
                    aVar.jks.setVisibility(8);
                } else {
                    aVar.jkr.setVisibility(8);
                    if (i < this.mData.cvM() && this.eLE && !this.jiS && this.jki) {
                        aVar.jks.setVisibility(0);
                    } else {
                        aVar.jks.setVisibility(8);
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
        this.jkg.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.jkg.getLayoutMode().onModeChanged(view);
    }

    public void J(View.OnClickListener onClickListener) {
        this.jkh = onClickListener;
    }

    public void U(View.OnClickListener onClickListener) {
        this.jkj = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.eLC) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void GL(String str) {
        this.jiT = str;
    }

    /* loaded from: classes11.dex */
    private class a {
        ImageView hHN;
        BarImageView ieI;
        StringBuffer jkk;
        TextView jkl;
        TextView jkm;
        ImageView jkn;
        TextView jko;
        TextView jkp;
        TextView jkq;
        Button jkr;
        ImageView jks;
        ImageView jkt;
        TextView mName;

        private a() {
        }
    }
}
