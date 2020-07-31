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
    private boolean kQU;
    private String kQV;
    private PersonBarActivity kSk;
    private boolean kSm;
    private View.OnClickListener kSn;
    private b mData;
    private ArrayList<ForumData> mForumList = null;
    private boolean fca = false;
    private View.OnClickListener kSl = null;
    private boolean fVq = false;

    public c(PersonBarActivity personBarActivity, b bVar, boolean z, boolean z2) {
        this.mData = null;
        this.fVs = true;
        this.kQU = false;
        this.kSm = true;
        this.kSk = personBarActivity;
        this.mData = bVar;
        this.fVs = z;
        this.kQU = z2;
        this.kSm = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
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
                view3 = LayoutInflater.from(this.kSk.getPageContext().getContext()).inflate(R.layout.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.jGe = (BarImageView) view3.findViewById(R.id.forum_avatar);
                    aVar.jGe.setGifIconSupport(false);
                    aVar.jGe.setRadius(l.getDimens(this.kSk, R.dimen.tbds10));
                    aVar.jGe.setConrers(15);
                    aVar.jGe.setPlaceHolder(2);
                    aVar.mName = (TextView) view3.findViewById(R.id.name);
                    aVar.kSo = new StringBuffer(10);
                    aVar.kSp = (TextView) view3.findViewById(R.id.degree);
                    aVar.kSq = (TextView) view3.findViewById(R.id.degree_text);
                    aVar.kSu = (TextView) view3.findViewById(R.id.experience);
                    aVar.kSs = (TextView) view3.findViewById(R.id.experience_title);
                    aVar.kSv = (Button) view3.findViewById(R.id.item_delete);
                    aVar.kSr = (ImageView) view3.findViewById(R.id.degree_text_ta);
                    aVar.kSt = (TextView) view3.findViewById(R.id.intro_ta);
                    aVar.kSw = (ImageView) view3.findViewById(R.id.item_talk);
                    aVar.jin = (ImageView) view3.findViewById(R.id.diver_buttom_px);
                    aVar.jin.setVisibility(0);
                    aVar.kSx = (ImageView) view3.findViewById(R.id.item_selected);
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
                aVar.kSp.setVisibility(8);
                aVar.kSv.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.jGe.setVisibility(8);
                aVar.kSq.setVisibility(8);
                aVar.kSu.setVisibility(8);
                aVar.kSs.setVisibility(8);
                aVar.kSr.setVisibility(8);
                aVar.kSt.setVisibility(8);
                aVar.kSw.setVisibility(8);
                aVar.jin.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.jGe.setVisibility(0);
                if (this.fVs) {
                    aVar.kSp.setVisibility(8);
                    aVar.kSq.setVisibility(8);
                    aVar.kSu.setVisibility(0);
                    aVar.kSs.setVisibility(0);
                    aVar.kSr.setVisibility(0);
                    aVar.kSt.setVisibility(8);
                    aVar.jin.setVisibility(0);
                } else {
                    aVar.kSp.setVisibility(8);
                    aVar.kSq.setVisibility(8);
                    aVar.kSu.setVisibility(8);
                    aVar.kSs.setVisibility(8);
                    aVar.kSr.setVisibility(0);
                    aVar.kSt.setVisibility(0);
                    aVar.jin.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.jGe.setTag(image_url);
                aVar.jGe.setImageDrawable(null);
                aVar.jGe.startLoad(image_url, 10, false);
                aVar.kSo.delete(0, aVar.kSo.length());
                aVar.kSo.append(forumData.getName());
                aVar.kSo.append(this.kSk.getPageContext().getString(R.string.forum));
                aVar.mName.setText(aVar.kSo);
                if (this.fVs) {
                    ao.setImageResource(aVar.kSr, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.kSu.setText(String.format(this.kSk.getPageContext().getString(R.string.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.kSv.setOnClickListener(this.kSl);
                    aVar.kSv.setTag(Integer.valueOf(i));
                    if (i < this.mData.cWo()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(R.drawable.icon_v), (Drawable) null);
                        if (!this.kQU && this.kSm) {
                            aVar.kSw.setVisibility(0);
                            aVar.kSw.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.kSw.setVisibility(8);
                    }
                    aVar.kSw.setOnClickListener(this.kSn);
                    aVar.kSx.setVisibility(8);
                    if (this.kQU && this.kSk.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.kQV)) {
                        aVar.kSx.setVisibility(0);
                    }
                } else {
                    if ((this.kSk.cwJ() == 0 && i < this.mData.cWo()) || (this.kSk.cwJ() == 1 && i < this.mData.cWp())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(R.drawable.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.kSk.cwJ() == 1) {
                        aVar.kSr.setVisibility(8);
                    }
                    aVar.kSw.setVisibility(8);
                    ao.setImageResource(aVar.kSr, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.kSt.setText(forumData.getSlogan());
                }
                if (this.fca) {
                    aVar.kSv.setVisibility(0);
                    aVar.kSw.setVisibility(8);
                } else {
                    aVar.kSv.setVisibility(8);
                    if (i < this.mData.cWo() && this.fVs && !this.kQU && this.kSm) {
                        aVar.kSw.setVisibility(0);
                    } else {
                        aVar.kSw.setVisibility(8);
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
        this.kSk.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.kSk.getLayoutMode().onModeChanged(view);
    }

    public void L(View.OnClickListener onClickListener) {
        this.kSl = onClickListener;
    }

    public void X(View.OnClickListener onClickListener) {
        this.kSn = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fVq) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void Ly(String str) {
        this.kQV = str;
    }

    /* loaded from: classes18.dex */
    private class a {
        BarImageView jGe;
        ImageView jin;
        StringBuffer kSo;
        TextView kSp;
        TextView kSq;
        ImageView kSr;
        TextView kSs;
        TextView kSt;
        TextView kSu;
        Button kSv;
        ImageView kSw;
        ImageView kSx;
        TextView mName;

        private a() {
        }
    }
}
