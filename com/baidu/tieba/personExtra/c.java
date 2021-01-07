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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class c extends BaseAdapter {
    private boolean hli;
    private b mData;
    private boolean mrd;
    private String mre;
    private PersonBarActivity msv;
    private boolean msx;
    private View.OnClickListener msy;
    private ArrayList<ForumData> mForumList = null;
    private boolean giC = false;
    private View.OnClickListener msw = null;
    private boolean hlg = false;

    public c(PersonBarActivity personBarActivity, b bVar, boolean z, boolean z2) {
        this.mData = null;
        this.hli = true;
        this.mrd = false;
        this.msx = true;
        this.msv = personBarActivity;
        this.mData = bVar;
        this.hli = z;
        this.mrd = z2;
        this.msx = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void mc(boolean z) {
        this.giC = z;
        notifyDataSetChanged();
    }

    public boolean bOv() {
        return this.giC;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hlg) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void cbj() {
        this.hlg = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.hlg = true;
        }
    }

    public boolean dze() {
        return this.hlg;
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
                view = LayoutInflater.from(this.msv.getPageContext().getContext()).inflate(R.layout.edit_bar_item, (ViewGroup) null);
                aVar = new a();
                aVar.leZ = (BarImageView) view.findViewById(R.id.forum_avatar);
                aVar.leZ.setGifIconSupport(false);
                aVar.leZ.setRadius(l.getDimens(this.msv, R.dimen.tbds10));
                aVar.leZ.setConrers(15);
                aVar.leZ.setPlaceHolder(2);
                aVar.mName = (TextView) view.findViewById(R.id.name);
                aVar.msz = new StringBuffer(10);
                aVar.msA = (TextView) view.findViewById(R.id.degree);
                aVar.msB = (TextView) view.findViewById(R.id.degree_text);
                aVar.msF = (TextView) view.findViewById(R.id.experience);
                aVar.msD = (TextView) view.findViewById(R.id.experience_title);
                aVar.msG = (Button) view.findViewById(R.id.item_delete);
                aVar.msC = (ImageView) view.findViewById(R.id.degree_text_ta);
                aVar.msE = (TextView) view.findViewById(R.id.intro_ta);
                aVar.msH = (ImageView) view.findViewById(R.id.item_talk);
                aVar.kGQ = (ImageView) view.findViewById(R.id.diver_buttom_px);
                aVar.kGQ.setVisibility(0);
                aVar.msI = (ImageView) view.findViewById(R.id.item_selected);
                view.setTag(aVar);
                view3 = view;
            } else {
                aVar = (a) view.getTag();
                view3 = view;
            }
            try {
                if (this.hlg) {
                    aVar.msA.setVisibility(8);
                    aVar.msG.setVisibility(8);
                    aVar.mName.setVisibility(8);
                    aVar.leZ.setVisibility(8);
                    aVar.msB.setVisibility(8);
                    aVar.msF.setVisibility(8);
                    aVar.msD.setVisibility(8);
                    aVar.msC.setVisibility(8);
                    aVar.msE.setVisibility(8);
                    aVar.msH.setVisibility(8);
                    aVar.kGQ.setVisibility(8);
                } else {
                    aVar.mName.setVisibility(0);
                    aVar.leZ.setVisibility(0);
                    if (this.hli) {
                        aVar.msA.setVisibility(8);
                        aVar.msB.setVisibility(8);
                        aVar.msF.setVisibility(0);
                        aVar.msD.setVisibility(0);
                        aVar.msC.setVisibility(0);
                        aVar.msE.setVisibility(8);
                        aVar.kGQ.setVisibility(0);
                    } else {
                        aVar.msA.setVisibility(8);
                        aVar.msB.setVisibility(8);
                        aVar.msF.setVisibility(8);
                        aVar.msD.setVisibility(8);
                        aVar.msC.setVisibility(0);
                        aVar.msE.setVisibility(0);
                        aVar.kGQ.setVisibility(0);
                    }
                }
                if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                    String image_url = forumData.getImage_url();
                    aVar.leZ.setTag(image_url);
                    aVar.leZ.setImageDrawable(null);
                    aVar.leZ.startLoad(image_url, 10, false);
                    aVar.msz.delete(0, aVar.msz.length());
                    aVar.msz.append(forumData.getName());
                    aVar.msz.append(this.msv.getPageContext().getString(R.string.forum));
                    aVar.mName.setText(aVar.msz);
                    if (this.hli) {
                        ao.setImageResource(aVar.msC, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                        aVar.msF.setText(String.format(this.msv.getPageContext().getString(R.string.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                        aVar.msG.setOnClickListener(this.msw);
                        aVar.msG.setTag(Integer.valueOf(i));
                        if (i < this.mData.dyT()) {
                            aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(R.drawable.icon_v), (Drawable) null);
                            if (!this.mrd && this.msx) {
                                aVar.msH.setVisibility(0);
                                aVar.msH.setTag(Integer.valueOf(i));
                            }
                        } else {
                            aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                            aVar.msH.setVisibility(8);
                        }
                        aVar.msH.setOnClickListener(this.msy);
                        aVar.msI.setVisibility(8);
                        if (this.mrd && this.msv.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.mre)) {
                            aVar.msI.setVisibility(0);
                        }
                    } else {
                        if ((this.msv.cZe() == 0 && i < this.mData.dyT()) || (this.msv.cZe() == 1 && i < this.mData.dyU())) {
                            aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(R.drawable.icon_v), (Drawable) null);
                        } else {
                            aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        }
                        if (this.msv.cZe() == 1) {
                            aVar.msC.setVisibility(8);
                        }
                        aVar.msH.setVisibility(8);
                        ao.setImageResource(aVar.msC, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                        aVar.msE.setText(forumData.getSlogan());
                    }
                    if (this.giC) {
                        aVar.msG.setVisibility(0);
                        aVar.msH.setVisibility(8);
                    } else {
                        aVar.msG.setVisibility(8);
                        if (i < this.mData.dyT() && this.hli && !this.mrd && this.msx) {
                            aVar.msH.setVisibility(0);
                        } else {
                            aVar.msH.setVisibility(8);
                        }
                    }
                }
                view2 = view3;
            } catch (Exception e2) {
                e = e2;
                view2 = view3;
                BdLog.e(e.getMessage());
                df(view2);
                return view2;
            }
        } catch (Exception e3) {
            e = e3;
            view2 = view;
        }
        df(view2);
        return view2;
    }

    private void df(View view) {
        this.msv.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.msv.getLayoutMode().onModeChanged(view);
    }

    public void O(View.OnClickListener onClickListener) {
        this.msw = onClickListener;
    }

    public void aa(View.OnClickListener onClickListener) {
        this.msy = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.hlg) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void QG(String str) {
        this.mre = str;
    }

    /* loaded from: classes8.dex */
    private class a {
        ImageView kGQ;
        BarImageView leZ;
        TextView mName;
        TextView msA;
        TextView msB;
        ImageView msC;
        TextView msD;
        TextView msE;
        TextView msF;
        Button msG;
        ImageView msH;
        ImageView msI;
        StringBuffer msz;

        private a() {
        }
    }
}
