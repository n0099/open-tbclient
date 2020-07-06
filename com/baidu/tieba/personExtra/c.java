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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class c extends BaseAdapter {
    private boolean fPZ;
    private boolean kHT;
    private String kHU;
    private PersonBarActivity kJj;
    private boolean kJl;
    private View.OnClickListener kJm;
    private b mData;
    private ArrayList<ForumData> mForumList = null;
    private boolean eXz = false;
    private View.OnClickListener kJk = null;
    private boolean fPX = false;

    public c(PersonBarActivity personBarActivity, b bVar, boolean z, boolean z2) {
        this.mData = null;
        this.fPZ = true;
        this.kHT = false;
        this.kJl = true;
        this.kJj = personBarActivity;
        this.mData = bVar;
        this.fPZ = z;
        this.kHT = z2;
        this.kJl = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void jk(boolean z) {
        this.eXz = z;
        notifyDataSetChanged();
    }

    public boolean boJ() {
        return this.eXz;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fPX) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void byU() {
        this.fPX = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.fPX = true;
        }
    }

    public boolean cSJ() {
        return this.fPX;
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
                view3 = LayoutInflater.from(this.kJj.getPageContext().getContext()).inflate(R.layout.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.jxA = (BarImageView) view3.findViewById(R.id.forum_avatar);
                    aVar.jxA.setGifIconSupport(false);
                    aVar.jxA.setRadius(l.getDimens(this.kJj, R.dimen.tbds10));
                    aVar.jxA.setConrers(15);
                    aVar.jxA.setPlaceHolder(2);
                    aVar.mName = (TextView) view3.findViewById(R.id.name);
                    aVar.kJn = new StringBuffer(10);
                    aVar.kJo = (TextView) view3.findViewById(R.id.degree);
                    aVar.kJp = (TextView) view3.findViewById(R.id.degree_text);
                    aVar.kJt = (TextView) view3.findViewById(R.id.experience);
                    aVar.kJr = (TextView) view3.findViewById(R.id.experience_title);
                    aVar.kJu = (Button) view3.findViewById(R.id.item_delete);
                    aVar.kJq = (ImageView) view3.findViewById(R.id.degree_text_ta);
                    aVar.kJs = (TextView) view3.findViewById(R.id.intro_ta);
                    aVar.kJv = (ImageView) view3.findViewById(R.id.item_talk);
                    aVar.iZT = (ImageView) view3.findViewById(R.id.diver_buttom_px);
                    aVar.iZT.setVisibility(0);
                    aVar.kJw = (ImageView) view3.findViewById(R.id.item_selected);
                    view3.setTag(aVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    BdLog.e(exc.getMessage());
                    cg(view2);
                    return view2;
                }
            } else {
                aVar = (a) view.getTag();
                view3 = view;
            }
            if (this.fPX) {
                aVar.kJo.setVisibility(8);
                aVar.kJu.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.jxA.setVisibility(8);
                aVar.kJp.setVisibility(8);
                aVar.kJt.setVisibility(8);
                aVar.kJr.setVisibility(8);
                aVar.kJq.setVisibility(8);
                aVar.kJs.setVisibility(8);
                aVar.kJv.setVisibility(8);
                aVar.iZT.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.jxA.setVisibility(0);
                if (this.fPZ) {
                    aVar.kJo.setVisibility(8);
                    aVar.kJp.setVisibility(8);
                    aVar.kJt.setVisibility(0);
                    aVar.kJr.setVisibility(0);
                    aVar.kJq.setVisibility(0);
                    aVar.kJs.setVisibility(8);
                    aVar.iZT.setVisibility(0);
                } else {
                    aVar.kJo.setVisibility(8);
                    aVar.kJp.setVisibility(8);
                    aVar.kJt.setVisibility(8);
                    aVar.kJr.setVisibility(8);
                    aVar.kJq.setVisibility(0);
                    aVar.kJs.setVisibility(0);
                    aVar.iZT.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.jxA.setTag(image_url);
                aVar.jxA.setImageDrawable(null);
                aVar.jxA.startLoad(image_url, 10, false);
                aVar.kJn.delete(0, aVar.kJn.length());
                aVar.kJn.append(forumData.getName());
                aVar.kJn.append(this.kJj.getPageContext().getString(R.string.forum));
                aVar.mName.setText(aVar.kJn);
                if (this.fPZ) {
                    an.setImageResource(aVar.kJq, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.kJt.setText(String.format(this.kJj.getPageContext().getString(R.string.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.kJu.setOnClickListener(this.kJk);
                    aVar.kJu.setTag(Integer.valueOf(i));
                    if (i < this.mData.cSy()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, an.getDrawable(R.drawable.icon_v), (Drawable) null);
                        if (!this.kHT && this.kJl) {
                            aVar.kJv.setVisibility(0);
                            aVar.kJv.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.kJv.setVisibility(8);
                    }
                    aVar.kJv.setOnClickListener(this.kJm);
                    aVar.kJw.setVisibility(8);
                    if (this.kHT && this.kJj.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.kHU)) {
                        aVar.kJw.setVisibility(0);
                    }
                } else {
                    if ((this.kJj.csH() == 0 && i < this.mData.cSy()) || (this.kJj.csH() == 1 && i < this.mData.cSz())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, an.getDrawable(R.drawable.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.kJj.csH() == 1) {
                        aVar.kJq.setVisibility(8);
                    }
                    aVar.kJv.setVisibility(8);
                    an.setImageResource(aVar.kJq, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.kJs.setText(forumData.getSlogan());
                }
                if (this.eXz) {
                    aVar.kJu.setVisibility(0);
                    aVar.kJv.setVisibility(8);
                } else {
                    aVar.kJu.setVisibility(8);
                    if (i < this.mData.cSy() && this.fPZ && !this.kHT && this.kJl) {
                        aVar.kJv.setVisibility(0);
                    } else {
                        aVar.kJv.setVisibility(8);
                    }
                }
            }
            view2 = view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
        cg(view2);
        return view2;
    }

    private void cg(View view) {
        this.kJj.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.kJj.getLayoutMode().onModeChanged(view);
    }

    public void L(View.OnClickListener onClickListener) {
        this.kJk = onClickListener;
    }

    public void W(View.OnClickListener onClickListener) {
        this.kJm = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fPX) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void KK(String str) {
        this.kHU = str;
    }

    /* loaded from: classes11.dex */
    private class a {
        ImageView iZT;
        BarImageView jxA;
        StringBuffer kJn;
        TextView kJo;
        TextView kJp;
        ImageView kJq;
        TextView kJr;
        TextView kJs;
        TextView kJt;
        Button kJu;
        ImageView kJv;
        ImageView kJw;
        TextView mName;

        private a() {
        }
    }
}
