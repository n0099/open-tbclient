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
    private boolean eLS;
    private boolean jjg;
    private String jjh;
    private PersonBarActivity jku;
    private boolean jkw;
    private View.OnClickListener jkx;
    private b mData;
    private ArrayList<ForumData> mForumList = null;
    private boolean dYk = false;
    private View.OnClickListener jkv = null;
    private boolean eLQ = false;

    public c(PersonBarActivity personBarActivity, b bVar, boolean z, boolean z2) {
        this.mData = null;
        this.eLS = true;
        this.jjg = false;
        this.jkw = true;
        this.jku = personBarActivity;
        this.mData = bVar;
        this.eLS = z;
        this.jjg = z2;
        this.jkw = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void hC(boolean z) {
        this.dYk = z;
        notifyDataSetChanged();
    }

    public boolean aXO() {
        return this.dYk;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eLQ) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void bgK() {
        this.eLQ = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.eLQ = true;
        }
    }

    public boolean cwa() {
        return this.eLQ;
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
                view3 = LayoutInflater.from(this.jku.getPageContext().getContext()).inflate(R.layout.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.ieW = (BarImageView) view3.findViewById(R.id.forum_avatar);
                    aVar.ieW.setGifIconSupport(false);
                    aVar.ieW.setRadius(l.getDimens(this.jku, R.dimen.tbds10));
                    aVar.ieW.setConrers(15);
                    aVar.ieW.setPlaceHolder(2);
                    aVar.mName = (TextView) view3.findViewById(R.id.name);
                    aVar.jky = new StringBuffer(10);
                    aVar.jkz = (TextView) view3.findViewById(R.id.degree);
                    aVar.jkA = (TextView) view3.findViewById(R.id.degree_text);
                    aVar.jkE = (TextView) view3.findViewById(R.id.experience);
                    aVar.jkC = (TextView) view3.findViewById(R.id.experience_title);
                    aVar.jkF = (Button) view3.findViewById(R.id.item_delete);
                    aVar.jkB = (ImageView) view3.findViewById(R.id.degree_text_ta);
                    aVar.jkD = (TextView) view3.findViewById(R.id.intro_ta);
                    aVar.jkG = (ImageView) view3.findViewById(R.id.item_talk);
                    aVar.hIb = (ImageView) view3.findViewById(R.id.diver_buttom_px);
                    aVar.hIb.setVisibility(0);
                    aVar.jkH = (ImageView) view3.findViewById(R.id.item_selected);
                    view3.setTag(aVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    BdLog.e(exc.getMessage());
                    bX(view2);
                    return view2;
                }
            } else {
                aVar = (a) view.getTag();
                view3 = view;
            }
            if (this.eLQ) {
                aVar.jkz.setVisibility(8);
                aVar.jkF.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.ieW.setVisibility(8);
                aVar.jkA.setVisibility(8);
                aVar.jkE.setVisibility(8);
                aVar.jkC.setVisibility(8);
                aVar.jkB.setVisibility(8);
                aVar.jkD.setVisibility(8);
                aVar.jkG.setVisibility(8);
                aVar.hIb.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.ieW.setVisibility(0);
                if (this.eLS) {
                    aVar.jkz.setVisibility(8);
                    aVar.jkA.setVisibility(8);
                    aVar.jkE.setVisibility(0);
                    aVar.jkC.setVisibility(0);
                    aVar.jkB.setVisibility(0);
                    aVar.jkD.setVisibility(8);
                    aVar.hIb.setVisibility(0);
                } else {
                    aVar.jkz.setVisibility(8);
                    aVar.jkA.setVisibility(8);
                    aVar.jkE.setVisibility(8);
                    aVar.jkC.setVisibility(8);
                    aVar.jkB.setVisibility(0);
                    aVar.jkD.setVisibility(0);
                    aVar.hIb.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.ieW.setTag(image_url);
                aVar.ieW.setImageDrawable(null);
                aVar.ieW.startLoad(image_url, 10, false);
                aVar.jky.delete(0, aVar.jky.length());
                aVar.jky.append(forumData.getName());
                aVar.jky.append(this.jku.getPageContext().getString(R.string.forum));
                aVar.mName.setText(aVar.jky);
                if (this.eLS) {
                    am.setImageResource(aVar.jkB, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.jkE.setText(String.format(this.jku.getPageContext().getString(R.string.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.jkF.setOnClickListener(this.jkv);
                    aVar.jkF.setTag(Integer.valueOf(i));
                    if (i < this.mData.cvP()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_v), (Drawable) null);
                        if (!this.jjg && this.jkw) {
                            aVar.jkG.setVisibility(0);
                            aVar.jkG.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.jkG.setVisibility(8);
                    }
                    aVar.jkG.setOnClickListener(this.jkx);
                    aVar.jkH.setVisibility(8);
                    if (this.jjg && this.jku.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.jjh)) {
                        aVar.jkH.setVisibility(0);
                    }
                } else {
                    if ((this.jku.bXt() == 0 && i < this.mData.cvP()) || (this.jku.bXt() == 1 && i < this.mData.cvQ())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.jku.bXt() == 1) {
                        aVar.jkB.setVisibility(8);
                    }
                    aVar.jkG.setVisibility(8);
                    am.setImageResource(aVar.jkB, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.jkD.setText(forumData.getSlogan());
                }
                if (this.dYk) {
                    aVar.jkF.setVisibility(0);
                    aVar.jkG.setVisibility(8);
                } else {
                    aVar.jkF.setVisibility(8);
                    if (i < this.mData.cvP() && this.eLS && !this.jjg && this.jkw) {
                        aVar.jkG.setVisibility(0);
                    } else {
                        aVar.jkG.setVisibility(8);
                    }
                }
            }
            view2 = view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
        bX(view2);
        return view2;
    }

    private void bX(View view) {
        this.jku.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.jku.getLayoutMode().onModeChanged(view);
    }

    public void J(View.OnClickListener onClickListener) {
        this.jkv = onClickListener;
    }

    public void U(View.OnClickListener onClickListener) {
        this.jkx = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.eLQ) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void GM(String str) {
        this.jjh = str;
    }

    /* loaded from: classes11.dex */
    private class a {
        ImageView hIb;
        BarImageView ieW;
        TextView jkA;
        ImageView jkB;
        TextView jkC;
        TextView jkD;
        TextView jkE;
        Button jkF;
        ImageView jkG;
        ImageView jkH;
        StringBuffer jky;
        TextView jkz;
        TextView mName;

        private a() {
        }
    }
}
