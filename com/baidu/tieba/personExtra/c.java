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
    private boolean jhT;
    private String jhU;
    private PersonBarActivity jji;
    private boolean jjk;
    private View.OnClickListener jjl;
    private b mData;
    private ArrayList<ForumData> mForumList = null;
    private boolean dTR = false;
    private View.OnClickListener jjj = null;
    private boolean eHI = false;

    public c(PersonBarActivity personBarActivity, b bVar, boolean z, boolean z2) {
        this.mData = null;
        this.eHK = true;
        this.jhT = false;
        this.jjk = true;
        this.jji = personBarActivity;
        this.mData = bVar;
        this.eHK = z;
        this.jhT = z2;
        this.jjk = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
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

    public boolean cuC() {
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
                view3 = LayoutInflater.from(this.jji.getPageContext().getContext()).inflate(R.layout.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.icH = (BarImageView) view3.findViewById(R.id.forum_avatar);
                    aVar.icH.setGifIconSupport(false);
                    aVar.icH.setRadius(l.getDimens(this.jji, R.dimen.tbds10));
                    aVar.icH.setConrers(15);
                    aVar.icH.setPlaceHolder(2);
                    aVar.mName = (TextView) view3.findViewById(R.id.name);
                    aVar.jjm = new StringBuffer(10);
                    aVar.jjn = (TextView) view3.findViewById(R.id.degree);
                    aVar.jjo = (TextView) view3.findViewById(R.id.degree_text);
                    aVar.jjs = (TextView) view3.findViewById(R.id.experience);
                    aVar.jjq = (TextView) view3.findViewById(R.id.experience_title);
                    aVar.jjt = (Button) view3.findViewById(R.id.item_delete);
                    aVar.jjp = (ImageView) view3.findViewById(R.id.degree_text_ta);
                    aVar.jjr = (TextView) view3.findViewById(R.id.intro_ta);
                    aVar.jju = (ImageView) view3.findViewById(R.id.item_talk);
                    aVar.hFO = (ImageView) view3.findViewById(R.id.diver_buttom_px);
                    aVar.hFO.setVisibility(0);
                    aVar.jjv = (ImageView) view3.findViewById(R.id.item_selected);
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
                aVar.jjn.setVisibility(8);
                aVar.jjt.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.icH.setVisibility(8);
                aVar.jjo.setVisibility(8);
                aVar.jjs.setVisibility(8);
                aVar.jjq.setVisibility(8);
                aVar.jjp.setVisibility(8);
                aVar.jjr.setVisibility(8);
                aVar.jju.setVisibility(8);
                aVar.hFO.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.icH.setVisibility(0);
                if (this.eHK) {
                    aVar.jjn.setVisibility(8);
                    aVar.jjo.setVisibility(8);
                    aVar.jjs.setVisibility(0);
                    aVar.jjq.setVisibility(0);
                    aVar.jjp.setVisibility(0);
                    aVar.jjr.setVisibility(8);
                    aVar.hFO.setVisibility(0);
                } else {
                    aVar.jjn.setVisibility(8);
                    aVar.jjo.setVisibility(8);
                    aVar.jjs.setVisibility(8);
                    aVar.jjq.setVisibility(8);
                    aVar.jjp.setVisibility(0);
                    aVar.jjr.setVisibility(0);
                    aVar.hFO.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.icH.setTag(image_url);
                aVar.icH.setImageDrawable(null);
                aVar.icH.startLoad(image_url, 10, false);
                aVar.jjm.delete(0, aVar.jjm.length());
                aVar.jjm.append(forumData.getName());
                aVar.jjm.append(this.jji.getPageContext().getString(R.string.forum));
                aVar.mName.setText(aVar.jjm);
                if (this.eHK) {
                    am.setImageResource(aVar.jjp, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.jjs.setText(String.format(this.jji.getPageContext().getString(R.string.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.jjt.setOnClickListener(this.jjj);
                    aVar.jjt.setTag(Integer.valueOf(i));
                    if (i < this.mData.cur()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_v), (Drawable) null);
                        if (!this.jhT && this.jjk) {
                            aVar.jju.setVisibility(0);
                            aVar.jju.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.jju.setVisibility(8);
                    }
                    aVar.jju.setOnClickListener(this.jjl);
                    aVar.jjv.setVisibility(8);
                    if (this.jhT && this.jji.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.jhU)) {
                        aVar.jjv.setVisibility(0);
                    }
                } else {
                    if ((this.jji.bVP() == 0 && i < this.mData.cur()) || (this.jji.bVP() == 1 && i < this.mData.cus())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.jji.bVP() == 1) {
                        aVar.jjp.setVisibility(8);
                    }
                    aVar.jju.setVisibility(8);
                    am.setImageResource(aVar.jjp, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.jjr.setText(forumData.getSlogan());
                }
                if (this.dTR) {
                    aVar.jjt.setVisibility(0);
                    aVar.jju.setVisibility(8);
                } else {
                    aVar.jjt.setVisibility(8);
                    if (i < this.mData.cur() && this.eHK && !this.jhT && this.jjk) {
                        aVar.jju.setVisibility(0);
                    } else {
                        aVar.jju.setVisibility(8);
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
        this.jji.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.jji.getLayoutMode().onModeChanged(view);
    }

    public void I(View.OnClickListener onClickListener) {
        this.jjj = onClickListener;
    }

    public void U(View.OnClickListener onClickListener) {
        this.jjl = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.eHI) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void Gx(String str) {
        this.jhU = str;
    }

    /* loaded from: classes9.dex */
    private class a {
        ImageView hFO;
        BarImageView icH;
        StringBuffer jjm;
        TextView jjn;
        TextView jjo;
        ImageView jjp;
        TextView jjq;
        TextView jjr;
        TextView jjs;
        Button jjt;
        ImageView jju;
        ImageView jjv;
        TextView mName;

        private a() {
        }
    }
}
