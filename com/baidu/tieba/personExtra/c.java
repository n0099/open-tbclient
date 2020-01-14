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
/* loaded from: classes9.dex */
public class c extends BaseAdapter {
    private boolean eHK;
    private boolean jhY;
    private String jhZ;
    private PersonBarActivity jjn;
    private boolean jjp;
    private View.OnClickListener jjq;
    private b mData;
    private ArrayList<ForumData> mForumList = null;
    private boolean dTR = false;
    private View.OnClickListener jjo = null;
    private boolean eHI = false;

    public c(PersonBarActivity personBarActivity, b bVar, boolean z, boolean z2) {
        this.mData = null;
        this.eHK = true;
        this.jhY = false;
        this.jjp = true;
        this.jjn = personBarActivity;
        this.mData = bVar;
        this.eHK = z;
        this.jhY = z2;
        this.jjp = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void hv(boolean z) {
        this.dTR = z;
        notifyDataSetChanged();
    }

    public boolean aVw() {
        return this.dTR;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eHI) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void bex() {
        this.eHI = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.eHI = true;
        }
    }

    public boolean cuE() {
        return this.eHI;
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
                view3 = LayoutInflater.from(this.jjn.getPageContext().getContext()).inflate(R.layout.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.icH = (BarImageView) view3.findViewById(R.id.forum_avatar);
                    aVar.icH.setGifIconSupport(false);
                    aVar.icH.setRadius(l.getDimens(this.jjn, R.dimen.tbds10));
                    aVar.icH.setConrers(15);
                    aVar.icH.setPlaceHolder(2);
                    aVar.mName = (TextView) view3.findViewById(R.id.name);
                    aVar.jjr = new StringBuffer(10);
                    aVar.jjs = (TextView) view3.findViewById(R.id.degree);
                    aVar.jjt = (TextView) view3.findViewById(R.id.degree_text);
                    aVar.jjx = (TextView) view3.findViewById(R.id.experience);
                    aVar.jjv = (TextView) view3.findViewById(R.id.experience_title);
                    aVar.jjy = (Button) view3.findViewById(R.id.item_delete);
                    aVar.jju = (ImageView) view3.findViewById(R.id.degree_text_ta);
                    aVar.jjw = (TextView) view3.findViewById(R.id.intro_ta);
                    aVar.jjz = (ImageView) view3.findViewById(R.id.item_talk);
                    aVar.hFO = (ImageView) view3.findViewById(R.id.diver_buttom_px);
                    aVar.hFO.setVisibility(0);
                    aVar.jjA = (ImageView) view3.findViewById(R.id.item_selected);
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
            if (this.eHI) {
                aVar.jjs.setVisibility(8);
                aVar.jjy.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.icH.setVisibility(8);
                aVar.jjt.setVisibility(8);
                aVar.jjx.setVisibility(8);
                aVar.jjv.setVisibility(8);
                aVar.jju.setVisibility(8);
                aVar.jjw.setVisibility(8);
                aVar.jjz.setVisibility(8);
                aVar.hFO.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.icH.setVisibility(0);
                if (this.eHK) {
                    aVar.jjs.setVisibility(8);
                    aVar.jjt.setVisibility(8);
                    aVar.jjx.setVisibility(0);
                    aVar.jjv.setVisibility(0);
                    aVar.jju.setVisibility(0);
                    aVar.jjw.setVisibility(8);
                    aVar.hFO.setVisibility(0);
                } else {
                    aVar.jjs.setVisibility(8);
                    aVar.jjt.setVisibility(8);
                    aVar.jjx.setVisibility(8);
                    aVar.jjv.setVisibility(8);
                    aVar.jju.setVisibility(0);
                    aVar.jjw.setVisibility(0);
                    aVar.hFO.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.icH.setTag(image_url);
                aVar.icH.setImageDrawable(null);
                aVar.icH.startLoad(image_url, 10, false);
                aVar.jjr.delete(0, aVar.jjr.length());
                aVar.jjr.append(forumData.getName());
                aVar.jjr.append(this.jjn.getPageContext().getString(R.string.forum));
                aVar.mName.setText(aVar.jjr);
                if (this.eHK) {
                    am.setImageResource(aVar.jju, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.jjx.setText(String.format(this.jjn.getPageContext().getString(R.string.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.jjy.setOnClickListener(this.jjo);
                    aVar.jjy.setTag(Integer.valueOf(i));
                    if (i < this.mData.cut()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_v), (Drawable) null);
                        if (!this.jhY && this.jjp) {
                            aVar.jjz.setVisibility(0);
                            aVar.jjz.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.jjz.setVisibility(8);
                    }
                    aVar.jjz.setOnClickListener(this.jjq);
                    aVar.jjA.setVisibility(8);
                    if (this.jhY && this.jjn.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.jhZ)) {
                        aVar.jjA.setVisibility(0);
                    }
                } else {
                    if ((this.jjn.bVP() == 0 && i < this.mData.cut()) || (this.jjn.bVP() == 1 && i < this.mData.cuu())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.jjn.bVP() == 1) {
                        aVar.jju.setVisibility(8);
                    }
                    aVar.jjz.setVisibility(8);
                    am.setImageResource(aVar.jju, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.jjw.setText(forumData.getSlogan());
                }
                if (this.dTR) {
                    aVar.jjy.setVisibility(0);
                    aVar.jjz.setVisibility(8);
                } else {
                    aVar.jjy.setVisibility(8);
                    if (i < this.mData.cut() && this.eHK && !this.jhY && this.jjp) {
                        aVar.jjz.setVisibility(0);
                    } else {
                        aVar.jjz.setVisibility(8);
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
        this.jjn.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.jjn.getLayoutMode().onModeChanged(view);
    }

    public void I(View.OnClickListener onClickListener) {
        this.jjo = onClickListener;
    }

    public void U(View.OnClickListener onClickListener) {
        this.jjq = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.eHI) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void Gx(String str) {
        this.jhZ = str;
    }

    /* loaded from: classes9.dex */
    private class a {
        ImageView hFO;
        BarImageView icH;
        ImageView jjA;
        StringBuffer jjr;
        TextView jjs;
        TextView jjt;
        ImageView jju;
        TextView jjv;
        TextView jjw;
        TextView jjx;
        Button jjy;
        ImageView jjz;
        TextView mName;

        private a() {
        }
    }
}
