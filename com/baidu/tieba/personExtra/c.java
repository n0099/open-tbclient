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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class c extends BaseAdapter {
    private boolean gbx;
    private boolean ioA;
    private String ioB;
    private PersonBarActivity ipY;
    private boolean iqa;
    private View.OnClickListener iqb;
    private b mData;
    private ArrayList<ForumData> mForumList = null;
    private boolean cXs = false;
    private View.OnClickListener ipZ = null;
    private boolean hzT = false;

    public c(PersonBarActivity personBarActivity, b bVar, boolean z, boolean z2) {
        this.mData = null;
        this.gbx = true;
        this.ioA = false;
        this.iqa = true;
        this.ipY = personBarActivity;
        this.mData = bVar;
        this.gbx = z;
        this.ioA = z2;
        this.iqa = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void gn(boolean z) {
        this.cXs = z;
        notifyDataSetChanged();
    }

    public boolean aDd() {
        return this.cXs;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hzT) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void bQm() {
        this.hzT = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.hzT = true;
        }
    }

    public boolean cdc() {
        return this.hzT;
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
                view3 = LayoutInflater.from(this.ipY.getPageContext().getContext()).inflate(R.layout.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.hng = (BarImageView) view3.findViewById(R.id.forum_avatar);
                    aVar.hng.setGifIconSupport(false);
                    aVar.mName = (TextView) view3.findViewById(R.id.name);
                    aVar.iqc = new StringBuffer(10);
                    aVar.iqd = (TextView) view3.findViewById(R.id.degree);
                    aVar.iqe = (TextView) view3.findViewById(R.id.degree_text);
                    aVar.iqi = (TextView) view3.findViewById(R.id.experience);
                    aVar.iqg = (TextView) view3.findViewById(R.id.experience_title);
                    aVar.iqj = (Button) view3.findViewById(R.id.item_delete);
                    aVar.iqf = (ImageView) view3.findViewById(R.id.degree_text_ta);
                    aVar.iqh = (TextView) view3.findViewById(R.id.intro_ta);
                    aVar.iqk = (ImageView) view3.findViewById(R.id.item_talk);
                    aVar.gQX = (ImageView) view3.findViewById(R.id.diver_buttom_px);
                    aVar.gQX.setVisibility(0);
                    aVar.iql = (ImageView) view3.findViewById(R.id.item_selected);
                    view3.setTag(aVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    BdLog.e(exc.getMessage());
                    ca(view2);
                    return view2;
                }
            } else {
                aVar = (a) view.getTag();
                view3 = view;
            }
            if (this.hzT) {
                aVar.iqd.setVisibility(8);
                aVar.iqj.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.hng.setVisibility(8);
                aVar.iqe.setVisibility(8);
                aVar.iqi.setVisibility(8);
                aVar.iqg.setVisibility(8);
                aVar.iqf.setVisibility(8);
                aVar.iqh.setVisibility(8);
                aVar.iqk.setVisibility(8);
                aVar.gQX.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.hng.setVisibility(0);
                if (this.gbx) {
                    aVar.iqd.setVisibility(8);
                    aVar.iqe.setVisibility(8);
                    aVar.iqi.setVisibility(0);
                    aVar.iqg.setVisibility(0);
                    aVar.iqf.setVisibility(0);
                    aVar.iqh.setVisibility(8);
                    aVar.gQX.setVisibility(0);
                } else {
                    aVar.iqd.setVisibility(8);
                    aVar.iqe.setVisibility(8);
                    aVar.iqi.setVisibility(8);
                    aVar.iqg.setVisibility(8);
                    aVar.iqf.setVisibility(0);
                    aVar.iqh.setVisibility(0);
                    aVar.gQX.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.hng.setTag(image_url);
                aVar.hng.setImageDrawable(null);
                aVar.hng.startLoad(image_url, 10, false);
                aVar.iqc.delete(0, aVar.iqc.length());
                aVar.iqc.append(forumData.getName());
                aVar.iqc.append(this.ipY.getPageContext().getString(R.string.forum));
                aVar.mName.setText(aVar.iqc);
                if (this.gbx) {
                    am.c(aVar.iqf, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.iqi.setText(String.format(this.ipY.getPageContext().getString(R.string.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.iqj.setOnClickListener(this.ipZ);
                    aVar.iqj.setTag(Integer.valueOf(i));
                    if (i < this.mData.ccR()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_v), (Drawable) null);
                        if (!this.ioA && this.iqa) {
                            aVar.iqk.setVisibility(0);
                            aVar.iqk.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.iqk.setVisibility(8);
                    }
                    aVar.iqk.setOnClickListener(this.iqb);
                    aVar.iql.setVisibility(8);
                    if (this.ioA && this.ipY.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.ioB)) {
                        aVar.iql.setVisibility(0);
                    }
                } else {
                    if ((this.ipY.bGL() == 0 && i < this.mData.ccR()) || (this.ipY.bGL() == 1 && i < this.mData.ccS())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.ipY.bGL() == 1) {
                        aVar.iqf.setVisibility(8);
                    }
                    aVar.iqk.setVisibility(8);
                    am.c(aVar.iqf, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.iqh.setText(forumData.getSlogan());
                }
                if (this.cXs) {
                    aVar.iqj.setVisibility(0);
                    aVar.iqk.setVisibility(8);
                } else {
                    aVar.iqj.setVisibility(8);
                    if (i < this.mData.ccR() && this.gbx && !this.ioA && this.iqa) {
                        aVar.iqk.setVisibility(0);
                    } else {
                        aVar.iqk.setVisibility(8);
                    }
                }
            }
            view2 = view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
        ca(view2);
        return view2;
    }

    private void ca(View view) {
        this.ipY.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.ipY.getLayoutMode().onModeChanged(view);
    }

    public void H(View.OnClickListener onClickListener) {
        this.ipZ = onClickListener;
    }

    public void T(View.OnClickListener onClickListener) {
        this.iqb = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.hzT) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void Di(String str) {
        this.ioB = str;
    }

    /* loaded from: classes6.dex */
    private class a {
        ImageView gQX;
        BarImageView hng;
        StringBuffer iqc;
        TextView iqd;
        TextView iqe;
        ImageView iqf;
        TextView iqg;
        TextView iqh;
        TextView iqi;
        Button iqj;
        ImageView iqk;
        ImageView iql;
        TextView mName;

        private a() {
        }
    }
}
