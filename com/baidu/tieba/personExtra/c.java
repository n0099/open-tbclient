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
/* loaded from: classes7.dex */
public class c extends BaseAdapter {
    private boolean hgB;
    private b mData;
    private boolean mmy;
    private String mmz;
    private PersonBarActivity mnP;
    private boolean mnR;
    private View.OnClickListener mnS;
    private ArrayList<ForumData> mForumList = null;
    private boolean gdT = false;
    private View.OnClickListener mnQ = null;
    private boolean hgz = false;

    public c(PersonBarActivity personBarActivity, b bVar, boolean z, boolean z2) {
        this.mData = null;
        this.hgB = true;
        this.mmy = false;
        this.mnR = true;
        this.mnP = personBarActivity;
        this.mData = bVar;
        this.hgB = z;
        this.mmy = z2;
        this.mnR = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void lY(boolean z) {
        this.gdT = z;
        notifyDataSetChanged();
    }

    public boolean bKD() {
        return this.gdT;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hgz) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void bXr() {
        this.hgz = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.hgz = true;
        }
    }

    public boolean dvm() {
        return this.hgz;
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
                view = LayoutInflater.from(this.mnP.getPageContext().getContext()).inflate(R.layout.edit_bar_item, (ViewGroup) null);
                aVar = new a();
                aVar.lar = (BarImageView) view.findViewById(R.id.forum_avatar);
                aVar.lar.setGifIconSupport(false);
                aVar.lar.setRadius(l.getDimens(this.mnP, R.dimen.tbds10));
                aVar.lar.setConrers(15);
                aVar.lar.setPlaceHolder(2);
                aVar.mName = (TextView) view.findViewById(R.id.name);
                aVar.mnT = new StringBuffer(10);
                aVar.mnU = (TextView) view.findViewById(R.id.degree);
                aVar.mnV = (TextView) view.findViewById(R.id.degree_text);
                aVar.mnZ = (TextView) view.findViewById(R.id.experience);
                aVar.mnX = (TextView) view.findViewById(R.id.experience_title);
                aVar.moa = (Button) view.findViewById(R.id.item_delete);
                aVar.mnW = (ImageView) view.findViewById(R.id.degree_text_ta);
                aVar.mnY = (TextView) view.findViewById(R.id.intro_ta);
                aVar.mob = (ImageView) view.findViewById(R.id.item_talk);
                aVar.kCl = (ImageView) view.findViewById(R.id.diver_buttom_px);
                aVar.kCl.setVisibility(0);
                aVar.moc = (ImageView) view.findViewById(R.id.item_selected);
                view.setTag(aVar);
                view3 = view;
            } else {
                aVar = (a) view.getTag();
                view3 = view;
            }
            try {
                if (this.hgz) {
                    aVar.mnU.setVisibility(8);
                    aVar.moa.setVisibility(8);
                    aVar.mName.setVisibility(8);
                    aVar.lar.setVisibility(8);
                    aVar.mnV.setVisibility(8);
                    aVar.mnZ.setVisibility(8);
                    aVar.mnX.setVisibility(8);
                    aVar.mnW.setVisibility(8);
                    aVar.mnY.setVisibility(8);
                    aVar.mob.setVisibility(8);
                    aVar.kCl.setVisibility(8);
                } else {
                    aVar.mName.setVisibility(0);
                    aVar.lar.setVisibility(0);
                    if (this.hgB) {
                        aVar.mnU.setVisibility(8);
                        aVar.mnV.setVisibility(8);
                        aVar.mnZ.setVisibility(0);
                        aVar.mnX.setVisibility(0);
                        aVar.mnW.setVisibility(0);
                        aVar.mnY.setVisibility(8);
                        aVar.kCl.setVisibility(0);
                    } else {
                        aVar.mnU.setVisibility(8);
                        aVar.mnV.setVisibility(8);
                        aVar.mnZ.setVisibility(8);
                        aVar.mnX.setVisibility(8);
                        aVar.mnW.setVisibility(0);
                        aVar.mnY.setVisibility(0);
                        aVar.kCl.setVisibility(0);
                    }
                }
                if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                    String image_url = forumData.getImage_url();
                    aVar.lar.setTag(image_url);
                    aVar.lar.setImageDrawable(null);
                    aVar.lar.startLoad(image_url, 10, false);
                    aVar.mnT.delete(0, aVar.mnT.length());
                    aVar.mnT.append(forumData.getName());
                    aVar.mnT.append(this.mnP.getPageContext().getString(R.string.forum));
                    aVar.mName.setText(aVar.mnT);
                    if (this.hgB) {
                        ao.setImageResource(aVar.mnW, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                        aVar.mnZ.setText(String.format(this.mnP.getPageContext().getString(R.string.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                        aVar.moa.setOnClickListener(this.mnQ);
                        aVar.moa.setTag(Integer.valueOf(i));
                        if (i < this.mData.dvb()) {
                            aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(R.drawable.icon_v), (Drawable) null);
                            if (!this.mmy && this.mnR) {
                                aVar.mob.setVisibility(0);
                                aVar.mob.setTag(Integer.valueOf(i));
                            }
                        } else {
                            aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                            aVar.mob.setVisibility(8);
                        }
                        aVar.mob.setOnClickListener(this.mnS);
                        aVar.moc.setVisibility(8);
                        if (this.mmy && this.mnP.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.mmz)) {
                            aVar.moc.setVisibility(0);
                        }
                    } else {
                        if ((this.mnP.cVm() == 0 && i < this.mData.dvb()) || (this.mnP.cVm() == 1 && i < this.mData.dvc())) {
                            aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(R.drawable.icon_v), (Drawable) null);
                        } else {
                            aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        }
                        if (this.mnP.cVm() == 1) {
                            aVar.mnW.setVisibility(8);
                        }
                        aVar.mob.setVisibility(8);
                        ao.setImageResource(aVar.mnW, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                        aVar.mnY.setText(forumData.getSlogan());
                    }
                    if (this.gdT) {
                        aVar.moa.setVisibility(0);
                        aVar.mob.setVisibility(8);
                    } else {
                        aVar.moa.setVisibility(8);
                        if (i < this.mData.dvb() && this.hgB && !this.mmy && this.mnR) {
                            aVar.mob.setVisibility(0);
                        } else {
                            aVar.mob.setVisibility(8);
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
        this.mnP.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.mnP.getLayoutMode().onModeChanged(view);
    }

    public void O(View.OnClickListener onClickListener) {
        this.mnQ = onClickListener;
    }

    public void aa(View.OnClickListener onClickListener) {
        this.mnS = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.hgz) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void Pz(String str) {
        this.mmz = str;
    }

    /* loaded from: classes7.dex */
    private class a {
        ImageView kCl;
        BarImageView lar;
        TextView mName;
        StringBuffer mnT;
        TextView mnU;
        TextView mnV;
        ImageView mnW;
        TextView mnX;
        TextView mnY;
        TextView mnZ;
        Button moa;
        ImageView mob;
        ImageView moc;

        private a() {
        }
    }
}
