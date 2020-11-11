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
    private boolean gQx;
    private boolean lXt;
    private String lXu;
    private PersonBarActivity lYJ;
    private boolean lYL;
    private View.OnClickListener lYM;
    private b mData;
    private ArrayList<ForumData> mForumList = null;
    private boolean fRb = false;
    private View.OnClickListener lYK = null;
    private boolean gQv = false;

    public c(PersonBarActivity personBarActivity, b bVar, boolean z, boolean z2) {
        this.mData = null;
        this.gQx = true;
        this.lXt = false;
        this.lYL = true;
        this.lYJ = personBarActivity;
        this.mData = bVar;
        this.gQx = z;
        this.lXt = z2;
        this.lYL = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void lj(boolean z) {
        this.fRb = z;
        notifyDataSetChanged();
    }

    public boolean bIZ() {
        return this.fRb;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gQv) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void bVA() {
        this.gQv = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.gQv = true;
        }
    }

    public boolean duv() {
        return this.gQv;
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
                view3 = LayoutInflater.from(this.lYJ.getPageContext().getContext()).inflate(R.layout.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.kLM = (BarImageView) view3.findViewById(R.id.forum_avatar);
                    aVar.kLM.setGifIconSupport(false);
                    aVar.kLM.setRadius(l.getDimens(this.lYJ, R.dimen.tbds10));
                    aVar.kLM.setConrers(15);
                    aVar.kLM.setPlaceHolder(2);
                    aVar.mName = (TextView) view3.findViewById(R.id.name);
                    aVar.lYN = new StringBuffer(10);
                    aVar.lYO = (TextView) view3.findViewById(R.id.degree);
                    aVar.lYP = (TextView) view3.findViewById(R.id.degree_text);
                    aVar.lYT = (TextView) view3.findViewById(R.id.experience);
                    aVar.lYR = (TextView) view3.findViewById(R.id.experience_title);
                    aVar.lYU = (Button) view3.findViewById(R.id.item_delete);
                    aVar.lYQ = (ImageView) view3.findViewById(R.id.degree_text_ta);
                    aVar.lYS = (TextView) view3.findViewById(R.id.intro_ta);
                    aVar.lYV = (ImageView) view3.findViewById(R.id.item_talk);
                    aVar.knq = (ImageView) view3.findViewById(R.id.diver_buttom_px);
                    aVar.knq.setVisibility(0);
                    aVar.lYW = (ImageView) view3.findViewById(R.id.item_selected);
                    view3.setTag(aVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    BdLog.e(exc.getMessage());
                    cK(view2);
                    return view2;
                }
            } else {
                aVar = (a) view.getTag();
                view3 = view;
            }
            if (this.gQv) {
                aVar.lYO.setVisibility(8);
                aVar.lYU.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.kLM.setVisibility(8);
                aVar.lYP.setVisibility(8);
                aVar.lYT.setVisibility(8);
                aVar.lYR.setVisibility(8);
                aVar.lYQ.setVisibility(8);
                aVar.lYS.setVisibility(8);
                aVar.lYV.setVisibility(8);
                aVar.knq.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.kLM.setVisibility(0);
                if (this.gQx) {
                    aVar.lYO.setVisibility(8);
                    aVar.lYP.setVisibility(8);
                    aVar.lYT.setVisibility(0);
                    aVar.lYR.setVisibility(0);
                    aVar.lYQ.setVisibility(0);
                    aVar.lYS.setVisibility(8);
                    aVar.knq.setVisibility(0);
                } else {
                    aVar.lYO.setVisibility(8);
                    aVar.lYP.setVisibility(8);
                    aVar.lYT.setVisibility(8);
                    aVar.lYR.setVisibility(8);
                    aVar.lYQ.setVisibility(0);
                    aVar.lYS.setVisibility(0);
                    aVar.knq.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.kLM.setTag(image_url);
                aVar.kLM.setImageDrawable(null);
                aVar.kLM.startLoad(image_url, 10, false);
                aVar.lYN.delete(0, aVar.lYN.length());
                aVar.lYN.append(forumData.getName());
                aVar.lYN.append(this.lYJ.getPageContext().getString(R.string.forum));
                aVar.mName.setText(aVar.lYN);
                if (this.gQx) {
                    ap.setImageResource(aVar.lYQ, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.lYT.setText(String.format(this.lYJ.getPageContext().getString(R.string.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.lYU.setOnClickListener(this.lYK);
                    aVar.lYU.setTag(Integer.valueOf(i));
                    if (i < this.mData.duk()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_v), (Drawable) null);
                        if (!this.lXt && this.lYL) {
                            aVar.lYV.setVisibility(0);
                            aVar.lYV.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.lYV.setVisibility(8);
                    }
                    aVar.lYV.setOnClickListener(this.lYM);
                    aVar.lYW.setVisibility(8);
                    if (this.lXt && this.lYJ.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.lXu)) {
                        aVar.lYW.setVisibility(0);
                    }
                } else {
                    if ((this.lYJ.cUy() == 0 && i < this.mData.duk()) || (this.lYJ.cUy() == 1 && i < this.mData.dul())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.lYJ.cUy() == 1) {
                        aVar.lYQ.setVisibility(8);
                    }
                    aVar.lYV.setVisibility(8);
                    ap.setImageResource(aVar.lYQ, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.lYS.setText(forumData.getSlogan());
                }
                if (this.fRb) {
                    aVar.lYU.setVisibility(0);
                    aVar.lYV.setVisibility(8);
                } else {
                    aVar.lYU.setVisibility(8);
                    if (i < this.mData.duk() && this.gQx && !this.lXt && this.lYL) {
                        aVar.lYV.setVisibility(0);
                    } else {
                        aVar.lYV.setVisibility(8);
                    }
                }
            }
            view2 = view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
        cK(view2);
        return view2;
    }

    private void cK(View view) {
        this.lYJ.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.lYJ.getLayoutMode().onModeChanged(view);
    }

    public void N(View.OnClickListener onClickListener) {
        this.lYK = onClickListener;
    }

    public void Z(View.OnClickListener onClickListener) {
        this.lYM = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.gQv) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void Qx(String str) {
        this.lXu = str;
    }

    /* loaded from: classes24.dex */
    private class a {
        BarImageView kLM;
        ImageView knq;
        StringBuffer lYN;
        TextView lYO;
        TextView lYP;
        ImageView lYQ;
        TextView lYR;
        TextView lYS;
        TextView lYT;
        Button lYU;
        ImageView lYV;
        ImageView lYW;
        TextView mName;

        private a() {
        }
    }
}
