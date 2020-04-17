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
    private boolean fqG;
    private boolean jUU;
    private String jUV;
    private PersonBarActivity jWi;
    private boolean jWk;
    private View.OnClickListener jWl;
    private b mData;
    private ArrayList<ForumData> mForumList = null;
    private boolean eyx = false;
    private View.OnClickListener jWj = null;
    private boolean fqE = false;

    public c(PersonBarActivity personBarActivity, b bVar, boolean z, boolean z2) {
        this.mData = null;
        this.fqG = true;
        this.jUU = false;
        this.jWk = true;
        this.jWi = personBarActivity;
        this.mData = bVar;
        this.fqG = z;
        this.jUU = z2;
        this.jWk = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void iB(boolean z) {
        this.eyx = z;
        notifyDataSetChanged();
    }

    public boolean bfX() {
        return this.eyx;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fqE) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void bqg() {
        this.fqE = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.fqE = true;
        }
    }

    public boolean cHe() {
        return this.fqE;
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
                view3 = LayoutInflater.from(this.jWi.getPageContext().getContext()).inflate(R.layout.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.iQz = (BarImageView) view3.findViewById(R.id.forum_avatar);
                    aVar.iQz.setGifIconSupport(false);
                    aVar.iQz.setRadius(l.getDimens(this.jWi, R.dimen.tbds10));
                    aVar.iQz.setConrers(15);
                    aVar.iQz.setPlaceHolder(2);
                    aVar.mName = (TextView) view3.findViewById(R.id.name);
                    aVar.jWm = new StringBuffer(10);
                    aVar.jWn = (TextView) view3.findViewById(R.id.degree);
                    aVar.jWo = (TextView) view3.findViewById(R.id.degree_text);
                    aVar.jWs = (TextView) view3.findViewById(R.id.experience);
                    aVar.jWq = (TextView) view3.findViewById(R.id.experience_title);
                    aVar.jWt = (Button) view3.findViewById(R.id.item_delete);
                    aVar.jWp = (ImageView) view3.findViewById(R.id.degree_text_ta);
                    aVar.jWr = (TextView) view3.findViewById(R.id.intro_ta);
                    aVar.jWu = (ImageView) view3.findViewById(R.id.item_talk);
                    aVar.itr = (ImageView) view3.findViewById(R.id.diver_buttom_px);
                    aVar.itr.setVisibility(0);
                    aVar.jWv = (ImageView) view3.findViewById(R.id.item_selected);
                    view3.setTag(aVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    BdLog.e(exc.getMessage());
                    cf(view2);
                    return view2;
                }
            } else {
                aVar = (a) view.getTag();
                view3 = view;
            }
            if (this.fqE) {
                aVar.jWn.setVisibility(8);
                aVar.jWt.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.iQz.setVisibility(8);
                aVar.jWo.setVisibility(8);
                aVar.jWs.setVisibility(8);
                aVar.jWq.setVisibility(8);
                aVar.jWp.setVisibility(8);
                aVar.jWr.setVisibility(8);
                aVar.jWu.setVisibility(8);
                aVar.itr.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.iQz.setVisibility(0);
                if (this.fqG) {
                    aVar.jWn.setVisibility(8);
                    aVar.jWo.setVisibility(8);
                    aVar.jWs.setVisibility(0);
                    aVar.jWq.setVisibility(0);
                    aVar.jWp.setVisibility(0);
                    aVar.jWr.setVisibility(8);
                    aVar.itr.setVisibility(0);
                } else {
                    aVar.jWn.setVisibility(8);
                    aVar.jWo.setVisibility(8);
                    aVar.jWs.setVisibility(8);
                    aVar.jWq.setVisibility(8);
                    aVar.jWp.setVisibility(0);
                    aVar.jWr.setVisibility(0);
                    aVar.itr.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.iQz.setTag(image_url);
                aVar.iQz.setImageDrawable(null);
                aVar.iQz.startLoad(image_url, 10, false);
                aVar.jWm.delete(0, aVar.jWm.length());
                aVar.jWm.append(forumData.getName());
                aVar.jWm.append(this.jWi.getPageContext().getString(R.string.forum));
                aVar.mName.setText(aVar.jWm);
                if (this.fqG) {
                    am.setImageResource(aVar.jWp, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.jWs.setText(String.format(this.jWi.getPageContext().getString(R.string.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.jWt.setOnClickListener(this.jWj);
                    aVar.jWt.setTag(Integer.valueOf(i));
                    if (i < this.mData.cGT()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_v), (Drawable) null);
                        if (!this.jUU && this.jWk) {
                            aVar.jWu.setVisibility(0);
                            aVar.jWu.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.jWu.setVisibility(8);
                    }
                    aVar.jWu.setOnClickListener(this.jWl);
                    aVar.jWv.setVisibility(8);
                    if (this.jUU && this.jWi.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.jUV)) {
                        aVar.jWv.setVisibility(0);
                    }
                } else {
                    if ((this.jWi.cim() == 0 && i < this.mData.cGT()) || (this.jWi.cim() == 1 && i < this.mData.cGU())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.jWi.cim() == 1) {
                        aVar.jWp.setVisibility(8);
                    }
                    aVar.jWu.setVisibility(8);
                    am.setImageResource(aVar.jWp, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.jWr.setText(forumData.getSlogan());
                }
                if (this.eyx) {
                    aVar.jWt.setVisibility(0);
                    aVar.jWu.setVisibility(8);
                } else {
                    aVar.jWt.setVisibility(8);
                    if (i < this.mData.cGT() && this.fqG && !this.jUU && this.jWk) {
                        aVar.jWu.setVisibility(0);
                    } else {
                        aVar.jWu.setVisibility(8);
                    }
                }
            }
            view2 = view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
        cf(view2);
        return view2;
    }

    private void cf(View view) {
        this.jWi.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.jWi.getLayoutMode().onModeChanged(view);
    }

    public void K(View.OnClickListener onClickListener) {
        this.jWj = onClickListener;
    }

    public void V(View.OnClickListener onClickListener) {
        this.jWl = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fqE) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void It(String str) {
        this.jUV = str;
    }

    /* loaded from: classes11.dex */
    private class a {
        BarImageView iQz;
        ImageView itr;
        StringBuffer jWm;
        TextView jWn;
        TextView jWo;
        ImageView jWp;
        TextView jWq;
        TextView jWr;
        TextView jWs;
        Button jWt;
        ImageView jWu;
        ImageView jWv;
        TextView mName;

        private a() {
        }
    }
}
