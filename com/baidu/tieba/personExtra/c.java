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
/* loaded from: classes8.dex */
public class c extends BaseAdapter {
    private boolean hkR;
    private b mData;
    private String mvA;
    private boolean mvz;
    private PersonBarActivity mwQ;
    private boolean mwS;
    private View.OnClickListener mwT;
    private ArrayList<ForumData> mForumList = null;
    private boolean ggi = false;
    private View.OnClickListener mwR = null;
    private boolean hkP = false;

    public c(PersonBarActivity personBarActivity, b bVar, boolean z, boolean z2) {
        this.mData = null;
        this.hkR = true;
        this.mvz = false;
        this.mwS = true;
        this.mwQ = personBarActivity;
        this.mData = bVar;
        this.hkR = z;
        this.mvz = z2;
        this.mwS = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void mc(boolean z) {
        this.ggi = z;
        notifyDataSetChanged();
    }

    public boolean bKX() {
        return this.ggi;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hkP) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void bYr() {
        this.hkP = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.hkP = true;
        }
    }

    public boolean dxv() {
        return this.hkP;
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
        Exception e;
        View view2;
        a aVar;
        View view3;
        ForumData forumData;
        try {
            if (view == null) {
                view = LayoutInflater.from(this.mwQ.getPageContext().getContext()).inflate(R.layout.edit_bar_item, (ViewGroup) null);
                aVar = new a();
                aVar.liv = (BarImageView) view.findViewById(R.id.forum_avatar);
                aVar.liv.setGifIconSupport(false);
                aVar.liv.setRadius(l.getDimens(this.mwQ, R.dimen.tbds10));
                aVar.liv.setConrers(15);
                aVar.liv.setPlaceHolder(2);
                aVar.mName = (TextView) view.findViewById(R.id.name);
                aVar.mwU = new StringBuffer(10);
                aVar.mwV = (TextView) view.findViewById(R.id.degree);
                aVar.mwW = (TextView) view.findViewById(R.id.degree_text);
                aVar.mxa = (TextView) view.findViewById(R.id.experience);
                aVar.mwY = (TextView) view.findViewById(R.id.experience_title);
                aVar.mxb = (Button) view.findViewById(R.id.item_delete);
                aVar.mwX = (ImageView) view.findViewById(R.id.degree_text_ta);
                aVar.mwZ = (TextView) view.findViewById(R.id.intro_ta);
                aVar.mxc = (ImageView) view.findViewById(R.id.item_talk);
                aVar.kKq = (ImageView) view.findViewById(R.id.diver_buttom_px);
                aVar.kKq.setVisibility(0);
                aVar.mxd = (ImageView) view.findViewById(R.id.item_selected);
                view.setTag(aVar);
                view3 = view;
            } else {
                aVar = (a) view.getTag();
                view3 = view;
            }
            try {
                if (this.hkP) {
                    aVar.mwV.setVisibility(8);
                    aVar.mxb.setVisibility(8);
                    aVar.mName.setVisibility(8);
                    aVar.liv.setVisibility(8);
                    aVar.mwW.setVisibility(8);
                    aVar.mxa.setVisibility(8);
                    aVar.mwY.setVisibility(8);
                    aVar.mwX.setVisibility(8);
                    aVar.mwZ.setVisibility(8);
                    aVar.mxc.setVisibility(8);
                    aVar.kKq.setVisibility(8);
                } else {
                    aVar.mName.setVisibility(0);
                    aVar.liv.setVisibility(0);
                    if (this.hkR) {
                        aVar.mwV.setVisibility(8);
                        aVar.mwW.setVisibility(8);
                        aVar.mxa.setVisibility(0);
                        aVar.mwY.setVisibility(0);
                        aVar.mwX.setVisibility(0);
                        aVar.mwZ.setVisibility(8);
                        aVar.kKq.setVisibility(0);
                    } else {
                        aVar.mwV.setVisibility(8);
                        aVar.mwW.setVisibility(8);
                        aVar.mxa.setVisibility(8);
                        aVar.mwY.setVisibility(8);
                        aVar.mwX.setVisibility(0);
                        aVar.mwZ.setVisibility(0);
                        aVar.kKq.setVisibility(0);
                    }
                }
                if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                    String image_url = forumData.getImage_url();
                    aVar.liv.setTag(image_url);
                    aVar.liv.setImageDrawable(null);
                    aVar.liv.startLoad(image_url, 10, false);
                    aVar.mwU.delete(0, aVar.mwU.length());
                    aVar.mwU.append(forumData.getName());
                    aVar.mwU.append(this.mwQ.getPageContext().getString(R.string.forum));
                    aVar.mName.setText(aVar.mwU);
                    if (this.hkR) {
                        ap.setImageResource(aVar.mwX, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                        aVar.mxa.setText(String.format(this.mwQ.getPageContext().getString(R.string.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                        aVar.mxb.setOnClickListener(this.mwR);
                        aVar.mxb.setTag(Integer.valueOf(i));
                        if (i < this.mData.dxk()) {
                            aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_v), (Drawable) null);
                            if (!this.mvz && this.mwS) {
                                aVar.mxc.setVisibility(0);
                                aVar.mxc.setTag(Integer.valueOf(i));
                            }
                        } else {
                            aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                            aVar.mxc.setVisibility(8);
                        }
                        aVar.mxc.setOnClickListener(this.mwT);
                        aVar.mxd.setVisibility(8);
                        if (this.mvz && this.mwQ.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.mvA)) {
                            aVar.mxd.setVisibility(0);
                        }
                    } else {
                        if ((this.mwQ.cXk() == 0 && i < this.mData.dxk()) || (this.mwQ.cXk() == 1 && i < this.mData.dxl())) {
                            aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_v), (Drawable) null);
                        } else {
                            aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        }
                        if (this.mwQ.cXk() == 1) {
                            aVar.mwX.setVisibility(8);
                        }
                        aVar.mxc.setVisibility(8);
                        ap.setImageResource(aVar.mwX, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                        aVar.mwZ.setText(forumData.getSlogan());
                    }
                    if (this.ggi) {
                        aVar.mxb.setVisibility(0);
                        aVar.mxc.setVisibility(8);
                    } else {
                        aVar.mxb.setVisibility(8);
                        if (i < this.mData.dxk() && this.hkR && !this.mvz && this.mwS) {
                            aVar.mxc.setVisibility(0);
                        } else {
                            aVar.mxc.setVisibility(8);
                        }
                    }
                }
                view2 = view3;
            } catch (Exception e2) {
                e = e2;
                view2 = view3;
                BdLog.e(e.getMessage());
                dd(view2);
                return view2;
            }
        } catch (Exception e3) {
            e = e3;
            view2 = view;
        }
        dd(view2);
        return view2;
    }

    private void dd(View view) {
        this.mwQ.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.mwQ.getLayoutMode().onModeChanged(view);
    }

    public void O(View.OnClickListener onClickListener) {
        this.mwR = onClickListener;
    }

    public void aa(View.OnClickListener onClickListener) {
        this.mwT = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.hkP) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void Qq(String str) {
        this.mvA = str;
    }

    /* loaded from: classes8.dex */
    private class a {
        ImageView kKq;
        BarImageView liv;
        TextView mName;
        StringBuffer mwU;
        TextView mwV;
        TextView mwW;
        ImageView mwX;
        TextView mwY;
        TextView mwZ;
        TextView mxa;
        Button mxb;
        ImageView mxc;
        ImageView mxd;

        private a() {
        }
    }
}
