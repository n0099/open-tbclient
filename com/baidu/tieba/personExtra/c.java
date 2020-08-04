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
/* loaded from: classes18.dex */
public class c extends BaseAdapter {
    private boolean fVs;
    private boolean kQW;
    private String kQX;
    private PersonBarActivity kSm;
    private boolean kSo;
    private View.OnClickListener kSp;
    private b mData;
    private ArrayList<ForumData> mForumList = null;
    private boolean fca = false;
    private View.OnClickListener kSn = null;
    private boolean fVq = false;

    public c(PersonBarActivity personBarActivity, b bVar, boolean z, boolean z2) {
        this.mData = null;
        this.fVs = true;
        this.kQW = false;
        this.kSo = true;
        this.kSm = personBarActivity;
        this.mData = bVar;
        this.fVs = z;
        this.kQW = z2;
        this.kSo = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void jO(boolean z) {
        this.fca = z;
        notifyDataSetChanged();
    }

    public boolean brL() {
        return this.fca;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fVq) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void bCi() {
        this.fVq = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.fVq = true;
        }
    }

    public boolean cWz() {
        return this.fVq;
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
                view3 = LayoutInflater.from(this.kSm.getPageContext().getContext()).inflate(R.layout.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.jGg = (BarImageView) view3.findViewById(R.id.forum_avatar);
                    aVar.jGg.setGifIconSupport(false);
                    aVar.jGg.setRadius(l.getDimens(this.kSm, R.dimen.tbds10));
                    aVar.jGg.setConrers(15);
                    aVar.jGg.setPlaceHolder(2);
                    aVar.mName = (TextView) view3.findViewById(R.id.name);
                    aVar.kSq = new StringBuffer(10);
                    aVar.kSr = (TextView) view3.findViewById(R.id.degree);
                    aVar.kSs = (TextView) view3.findViewById(R.id.degree_text);
                    aVar.kSw = (TextView) view3.findViewById(R.id.experience);
                    aVar.kSu = (TextView) view3.findViewById(R.id.experience_title);
                    aVar.kSx = (Button) view3.findViewById(R.id.item_delete);
                    aVar.kSt = (ImageView) view3.findViewById(R.id.degree_text_ta);
                    aVar.kSv = (TextView) view3.findViewById(R.id.intro_ta);
                    aVar.kSy = (ImageView) view3.findViewById(R.id.item_talk);
                    aVar.jip = (ImageView) view3.findViewById(R.id.diver_buttom_px);
                    aVar.jip.setVisibility(0);
                    aVar.kSz = (ImageView) view3.findViewById(R.id.item_selected);
                    view3.setTag(aVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    BdLog.e(exc.getMessage());
                    cm(view2);
                    return view2;
                }
            } else {
                aVar = (a) view.getTag();
                view3 = view;
            }
            if (this.fVq) {
                aVar.kSr.setVisibility(8);
                aVar.kSx.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.jGg.setVisibility(8);
                aVar.kSs.setVisibility(8);
                aVar.kSw.setVisibility(8);
                aVar.kSu.setVisibility(8);
                aVar.kSt.setVisibility(8);
                aVar.kSv.setVisibility(8);
                aVar.kSy.setVisibility(8);
                aVar.jip.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.jGg.setVisibility(0);
                if (this.fVs) {
                    aVar.kSr.setVisibility(8);
                    aVar.kSs.setVisibility(8);
                    aVar.kSw.setVisibility(0);
                    aVar.kSu.setVisibility(0);
                    aVar.kSt.setVisibility(0);
                    aVar.kSv.setVisibility(8);
                    aVar.jip.setVisibility(0);
                } else {
                    aVar.kSr.setVisibility(8);
                    aVar.kSs.setVisibility(8);
                    aVar.kSw.setVisibility(8);
                    aVar.kSu.setVisibility(8);
                    aVar.kSt.setVisibility(0);
                    aVar.kSv.setVisibility(0);
                    aVar.jip.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.jGg.setTag(image_url);
                aVar.jGg.setImageDrawable(null);
                aVar.jGg.startLoad(image_url, 10, false);
                aVar.kSq.delete(0, aVar.kSq.length());
                aVar.kSq.append(forumData.getName());
                aVar.kSq.append(this.kSm.getPageContext().getString(R.string.forum));
                aVar.mName.setText(aVar.kSq);
                if (this.fVs) {
                    ao.setImageResource(aVar.kSt, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.kSw.setText(String.format(this.kSm.getPageContext().getString(R.string.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.kSx.setOnClickListener(this.kSn);
                    aVar.kSx.setTag(Integer.valueOf(i));
                    if (i < this.mData.cWo()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(R.drawable.icon_v), (Drawable) null);
                        if (!this.kQW && this.kSo) {
                            aVar.kSy.setVisibility(0);
                            aVar.kSy.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.kSy.setVisibility(8);
                    }
                    aVar.kSy.setOnClickListener(this.kSp);
                    aVar.kSz.setVisibility(8);
                    if (this.kQW && this.kSm.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.kQX)) {
                        aVar.kSz.setVisibility(0);
                    }
                } else {
                    if ((this.kSm.cwJ() == 0 && i < this.mData.cWo()) || (this.kSm.cwJ() == 1 && i < this.mData.cWp())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(R.drawable.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.kSm.cwJ() == 1) {
                        aVar.kSt.setVisibility(8);
                    }
                    aVar.kSy.setVisibility(8);
                    ao.setImageResource(aVar.kSt, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.kSv.setText(forumData.getSlogan());
                }
                if (this.fca) {
                    aVar.kSx.setVisibility(0);
                    aVar.kSy.setVisibility(8);
                } else {
                    aVar.kSx.setVisibility(8);
                    if (i < this.mData.cWo() && this.fVs && !this.kQW && this.kSo) {
                        aVar.kSy.setVisibility(0);
                    } else {
                        aVar.kSy.setVisibility(8);
                    }
                }
            }
            view2 = view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
        cm(view2);
        return view2;
    }

    private void cm(View view) {
        this.kSm.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.kSm.getLayoutMode().onModeChanged(view);
    }

    public void L(View.OnClickListener onClickListener) {
        this.kSn = onClickListener;
    }

    public void X(View.OnClickListener onClickListener) {
        this.kSp = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fVq) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void Ly(String str) {
        this.kQX = str;
    }

    /* loaded from: classes18.dex */
    private class a {
        BarImageView jGg;
        ImageView jip;
        StringBuffer kSq;
        TextView kSr;
        TextView kSs;
        ImageView kSt;
        TextView kSu;
        TextView kSv;
        TextView kSw;
        Button kSx;
        ImageView kSy;
        ImageView kSz;
        TextView mName;

        private a() {
        }
    }
}
