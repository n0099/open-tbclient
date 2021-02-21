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
    private boolean hlf;
    private b mData;
    private boolean mvO;
    private String mvP;
    private PersonBarActivity mxf;
    private boolean mxh;
    private View.OnClickListener mxi;
    private ArrayList<ForumData> mForumList = null;
    private boolean ggn = false;
    private View.OnClickListener mxg = null;
    private boolean hld = false;

    public c(PersonBarActivity personBarActivity, b bVar, boolean z, boolean z2) {
        this.mData = null;
        this.hlf = true;
        this.mvO = false;
        this.mxh = true;
        this.mxf = personBarActivity;
        this.mData = bVar;
        this.hlf = z;
        this.mvO = z2;
        this.mxh = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void mc(boolean z) {
        this.ggn = z;
        notifyDataSetChanged();
    }

    public boolean bLc() {
        return this.ggn;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hld) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void bYy() {
        this.hld = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.hld = true;
        }
    }

    public boolean dxC() {
        return this.hld;
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
                view = LayoutInflater.from(this.mxf.getPageContext().getContext()).inflate(R.layout.edit_bar_item, (ViewGroup) null);
                aVar = new a();
                aVar.liJ = (BarImageView) view.findViewById(R.id.forum_avatar);
                aVar.liJ.setGifIconSupport(false);
                aVar.liJ.setRadius(l.getDimens(this.mxf, R.dimen.tbds10));
                aVar.liJ.setConrers(15);
                aVar.liJ.setPlaceHolder(2);
                aVar.mName = (TextView) view.findViewById(R.id.name);
                aVar.mxj = new StringBuffer(10);
                aVar.mxk = (TextView) view.findViewById(R.id.degree);
                aVar.mxl = (TextView) view.findViewById(R.id.degree_text);
                aVar.mxp = (TextView) view.findViewById(R.id.experience);
                aVar.mxn = (TextView) view.findViewById(R.id.experience_title);
                aVar.mxq = (Button) view.findViewById(R.id.item_delete);
                aVar.mxm = (ImageView) view.findViewById(R.id.degree_text_ta);
                aVar.mxo = (TextView) view.findViewById(R.id.intro_ta);
                aVar.mxr = (ImageView) view.findViewById(R.id.item_talk);
                aVar.kKE = (ImageView) view.findViewById(R.id.diver_buttom_px);
                aVar.kKE.setVisibility(0);
                aVar.mxs = (ImageView) view.findViewById(R.id.item_selected);
                view.setTag(aVar);
                view3 = view;
            } else {
                aVar = (a) view.getTag();
                view3 = view;
            }
            try {
                if (this.hld) {
                    aVar.mxk.setVisibility(8);
                    aVar.mxq.setVisibility(8);
                    aVar.mName.setVisibility(8);
                    aVar.liJ.setVisibility(8);
                    aVar.mxl.setVisibility(8);
                    aVar.mxp.setVisibility(8);
                    aVar.mxn.setVisibility(8);
                    aVar.mxm.setVisibility(8);
                    aVar.mxo.setVisibility(8);
                    aVar.mxr.setVisibility(8);
                    aVar.kKE.setVisibility(8);
                } else {
                    aVar.mName.setVisibility(0);
                    aVar.liJ.setVisibility(0);
                    if (this.hlf) {
                        aVar.mxk.setVisibility(8);
                        aVar.mxl.setVisibility(8);
                        aVar.mxp.setVisibility(0);
                        aVar.mxn.setVisibility(0);
                        aVar.mxm.setVisibility(0);
                        aVar.mxo.setVisibility(8);
                        aVar.kKE.setVisibility(0);
                    } else {
                        aVar.mxk.setVisibility(8);
                        aVar.mxl.setVisibility(8);
                        aVar.mxp.setVisibility(8);
                        aVar.mxn.setVisibility(8);
                        aVar.mxm.setVisibility(0);
                        aVar.mxo.setVisibility(0);
                        aVar.kKE.setVisibility(0);
                    }
                }
                if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                    String image_url = forumData.getImage_url();
                    aVar.liJ.setTag(image_url);
                    aVar.liJ.setImageDrawable(null);
                    aVar.liJ.startLoad(image_url, 10, false);
                    aVar.mxj.delete(0, aVar.mxj.length());
                    aVar.mxj.append(forumData.getName());
                    aVar.mxj.append(this.mxf.getPageContext().getString(R.string.forum));
                    aVar.mName.setText(aVar.mxj);
                    if (this.hlf) {
                        ap.setImageResource(aVar.mxm, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                        aVar.mxp.setText(String.format(this.mxf.getPageContext().getString(R.string.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                        aVar.mxq.setOnClickListener(this.mxg);
                        aVar.mxq.setTag(Integer.valueOf(i));
                        if (i < this.mData.dxr()) {
                            aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_v), (Drawable) null);
                            if (!this.mvO && this.mxh) {
                                aVar.mxr.setVisibility(0);
                                aVar.mxr.setTag(Integer.valueOf(i));
                            }
                        } else {
                            aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                            aVar.mxr.setVisibility(8);
                        }
                        aVar.mxr.setOnClickListener(this.mxi);
                        aVar.mxs.setVisibility(8);
                        if (this.mvO && this.mxf.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.mvP)) {
                            aVar.mxs.setVisibility(0);
                        }
                    } else {
                        if ((this.mxf.cXr() == 0 && i < this.mData.dxr()) || (this.mxf.cXr() == 1 && i < this.mData.dxs())) {
                            aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_v), (Drawable) null);
                        } else {
                            aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        }
                        if (this.mxf.cXr() == 1) {
                            aVar.mxm.setVisibility(8);
                        }
                        aVar.mxr.setVisibility(8);
                        ap.setImageResource(aVar.mxm, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                        aVar.mxo.setText(forumData.getSlogan());
                    }
                    if (this.ggn) {
                        aVar.mxq.setVisibility(0);
                        aVar.mxr.setVisibility(8);
                    } else {
                        aVar.mxq.setVisibility(8);
                        if (i < this.mData.dxr() && this.hlf && !this.mvO && this.mxh) {
                            aVar.mxr.setVisibility(0);
                        } else {
                            aVar.mxr.setVisibility(8);
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
        this.mxf.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.mxf.getLayoutMode().onModeChanged(view);
    }

    public void O(View.OnClickListener onClickListener) {
        this.mxg = onClickListener;
    }

    public void aa(View.OnClickListener onClickListener) {
        this.mxi = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.hld) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void Qr(String str) {
        this.mvP = str;
    }

    /* loaded from: classes8.dex */
    private class a {
        ImageView kKE;
        BarImageView liJ;
        TextView mName;
        StringBuffer mxj;
        TextView mxk;
        TextView mxl;
        ImageView mxm;
        TextView mxn;
        TextView mxo;
        TextView mxp;
        Button mxq;
        ImageView mxr;
        ImageView mxs;

        private a() {
        }
    }
}
