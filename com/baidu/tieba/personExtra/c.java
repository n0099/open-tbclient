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
    private boolean gKL;
    private boolean lRx;
    private String lRy;
    private PersonBarActivity lSN;
    private boolean lSP;
    private View.OnClickListener lSQ;
    private b mData;
    private ArrayList<ForumData> mForumList = null;
    private boolean fLl = false;
    private View.OnClickListener lSO = null;
    private boolean gKJ = false;

    public c(PersonBarActivity personBarActivity, b bVar, boolean z, boolean z2) {
        this.mData = null;
        this.gKL = true;
        this.lRx = false;
        this.lSP = true;
        this.lSN = personBarActivity;
        this.mData = bVar;
        this.gKL = z;
        this.lRx = z2;
        this.lSP = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void la(boolean z) {
        this.fLl = z;
        notifyDataSetChanged();
    }

    public boolean bGA() {
        return this.fLl;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gKJ) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void bTb() {
        this.gKJ = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.gKJ = true;
        }
    }

    public boolean drT() {
        return this.gKJ;
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
                view3 = LayoutInflater.from(this.lSN.getPageContext().getContext()).inflate(R.layout.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.kFQ = (BarImageView) view3.findViewById(R.id.forum_avatar);
                    aVar.kFQ.setGifIconSupport(false);
                    aVar.kFQ.setRadius(l.getDimens(this.lSN, R.dimen.tbds10));
                    aVar.kFQ.setConrers(15);
                    aVar.kFQ.setPlaceHolder(2);
                    aVar.mName = (TextView) view3.findViewById(R.id.name);
                    aVar.lSR = new StringBuffer(10);
                    aVar.lSS = (TextView) view3.findViewById(R.id.degree);
                    aVar.lST = (TextView) view3.findViewById(R.id.degree_text);
                    aVar.lSX = (TextView) view3.findViewById(R.id.experience);
                    aVar.lSV = (TextView) view3.findViewById(R.id.experience_title);
                    aVar.lSY = (Button) view3.findViewById(R.id.item_delete);
                    aVar.lSU = (ImageView) view3.findViewById(R.id.degree_text_ta);
                    aVar.lSW = (TextView) view3.findViewById(R.id.intro_ta);
                    aVar.lSZ = (ImageView) view3.findViewById(R.id.item_talk);
                    aVar.kht = (ImageView) view3.findViewById(R.id.diver_buttom_px);
                    aVar.kht.setVisibility(0);
                    aVar.lTa = (ImageView) view3.findViewById(R.id.item_selected);
                    view3.setTag(aVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    BdLog.e(exc.getMessage());
                    cF(view2);
                    return view2;
                }
            } else {
                aVar = (a) view.getTag();
                view3 = view;
            }
            if (this.gKJ) {
                aVar.lSS.setVisibility(8);
                aVar.lSY.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.kFQ.setVisibility(8);
                aVar.lST.setVisibility(8);
                aVar.lSX.setVisibility(8);
                aVar.lSV.setVisibility(8);
                aVar.lSU.setVisibility(8);
                aVar.lSW.setVisibility(8);
                aVar.lSZ.setVisibility(8);
                aVar.kht.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.kFQ.setVisibility(0);
                if (this.gKL) {
                    aVar.lSS.setVisibility(8);
                    aVar.lST.setVisibility(8);
                    aVar.lSX.setVisibility(0);
                    aVar.lSV.setVisibility(0);
                    aVar.lSU.setVisibility(0);
                    aVar.lSW.setVisibility(8);
                    aVar.kht.setVisibility(0);
                } else {
                    aVar.lSS.setVisibility(8);
                    aVar.lST.setVisibility(8);
                    aVar.lSX.setVisibility(8);
                    aVar.lSV.setVisibility(8);
                    aVar.lSU.setVisibility(0);
                    aVar.lSW.setVisibility(0);
                    aVar.kht.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.kFQ.setTag(image_url);
                aVar.kFQ.setImageDrawable(null);
                aVar.kFQ.startLoad(image_url, 10, false);
                aVar.lSR.delete(0, aVar.lSR.length());
                aVar.lSR.append(forumData.getName());
                aVar.lSR.append(this.lSN.getPageContext().getString(R.string.forum));
                aVar.mName.setText(aVar.lSR);
                if (this.gKL) {
                    ap.setImageResource(aVar.lSU, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.lSX.setText(String.format(this.lSN.getPageContext().getString(R.string.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.lSY.setOnClickListener(this.lSO);
                    aVar.lSY.setTag(Integer.valueOf(i));
                    if (i < this.mData.drI()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_v), (Drawable) null);
                        if (!this.lRx && this.lSP) {
                            aVar.lSZ.setVisibility(0);
                            aVar.lSZ.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.lSZ.setVisibility(8);
                    }
                    aVar.lSZ.setOnClickListener(this.lSQ);
                    aVar.lTa.setVisibility(8);
                    if (this.lRx && this.lSN.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.lRy)) {
                        aVar.lTa.setVisibility(0);
                    }
                } else {
                    if ((this.lSN.cRX() == 0 && i < this.mData.drI()) || (this.lSN.cRX() == 1 && i < this.mData.drJ())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.lSN.cRX() == 1) {
                        aVar.lSU.setVisibility(8);
                    }
                    aVar.lSZ.setVisibility(8);
                    ap.setImageResource(aVar.lSU, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.lSW.setText(forumData.getSlogan());
                }
                if (this.fLl) {
                    aVar.lSY.setVisibility(0);
                    aVar.lSZ.setVisibility(8);
                } else {
                    aVar.lSY.setVisibility(8);
                    if (i < this.mData.drI() && this.gKL && !this.lRx && this.lSP) {
                        aVar.lSZ.setVisibility(0);
                    } else {
                        aVar.lSZ.setVisibility(8);
                    }
                }
            }
            view2 = view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
        cF(view2);
        return view2;
    }

    private void cF(View view) {
        this.lSN.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.lSN.getLayoutMode().onModeChanged(view);
    }

    public void M(View.OnClickListener onClickListener) {
        this.lSO = onClickListener;
    }

    public void Y(View.OnClickListener onClickListener) {
        this.lSQ = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.gKJ) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void Qg(String str) {
        this.lRy = str;
    }

    /* loaded from: classes24.dex */
    private class a {
        BarImageView kFQ;
        ImageView kht;
        StringBuffer lSR;
        TextView lSS;
        TextView lST;
        ImageView lSU;
        TextView lSV;
        TextView lSW;
        TextView lSX;
        Button lSY;
        ImageView lSZ;
        ImageView lTa;
        TextView mName;

        private a() {
        }
    }
}
