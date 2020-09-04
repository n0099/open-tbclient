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
/* loaded from: classes18.dex */
public class c extends BaseAdapter {
    private boolean ghv;
    private boolean lgT;
    private String lgU;
    private PersonBarActivity lij;
    private boolean lil;
    private View.OnClickListener lim;
    private b mData;
    private ArrayList<ForumData> mForumList = null;
    private boolean fny = false;
    private View.OnClickListener lik = null;
    private boolean ght = false;

    public c(PersonBarActivity personBarActivity, b bVar, boolean z, boolean z2) {
        this.mData = null;
        this.ghv = true;
        this.lgT = false;
        this.lil = true;
        this.lij = personBarActivity;
        this.mData = bVar;
        this.ghv = z;
        this.lgT = z2;
        this.lil = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void ko(boolean z) {
        this.fny = z;
        notifyDataSetChanged();
    }

    public boolean bAJ() {
        return this.fny;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ght) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void bLD() {
        this.ght = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.ght = true;
        }
    }

    public boolean dhx() {
        return this.ght;
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
                view3 = LayoutInflater.from(this.lij.getPageContext().getContext()).inflate(R.layout.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.jVD = (BarImageView) view3.findViewById(R.id.forum_avatar);
                    aVar.jVD.setGifIconSupport(false);
                    aVar.jVD.setRadius(l.getDimens(this.lij, R.dimen.tbds10));
                    aVar.jVD.setConrers(15);
                    aVar.jVD.setPlaceHolder(2);
                    aVar.mName = (TextView) view3.findViewById(R.id.name);
                    aVar.lin = new StringBuffer(10);
                    aVar.lio = (TextView) view3.findViewById(R.id.degree);
                    aVar.lip = (TextView) view3.findViewById(R.id.degree_text);
                    aVar.lit = (TextView) view3.findViewById(R.id.experience);
                    aVar.lir = (TextView) view3.findViewById(R.id.experience_title);
                    aVar.liu = (Button) view3.findViewById(R.id.item_delete);
                    aVar.liq = (ImageView) view3.findViewById(R.id.degree_text_ta);
                    aVar.lis = (TextView) view3.findViewById(R.id.intro_ta);
                    aVar.liv = (ImageView) view3.findViewById(R.id.item_talk);
                    aVar.jxu = (ImageView) view3.findViewById(R.id.diver_buttom_px);
                    aVar.jxu.setVisibility(0);
                    aVar.liw = (ImageView) view3.findViewById(R.id.item_selected);
                    view3.setTag(aVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    BdLog.e(exc.getMessage());
                    co(view2);
                    return view2;
                }
            } else {
                aVar = (a) view.getTag();
                view3 = view;
            }
            if (this.ght) {
                aVar.lio.setVisibility(8);
                aVar.liu.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.jVD.setVisibility(8);
                aVar.lip.setVisibility(8);
                aVar.lit.setVisibility(8);
                aVar.lir.setVisibility(8);
                aVar.liq.setVisibility(8);
                aVar.lis.setVisibility(8);
                aVar.liv.setVisibility(8);
                aVar.jxu.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.jVD.setVisibility(0);
                if (this.ghv) {
                    aVar.lio.setVisibility(8);
                    aVar.lip.setVisibility(8);
                    aVar.lit.setVisibility(0);
                    aVar.lir.setVisibility(0);
                    aVar.liq.setVisibility(0);
                    aVar.lis.setVisibility(8);
                    aVar.jxu.setVisibility(0);
                } else {
                    aVar.lio.setVisibility(8);
                    aVar.lip.setVisibility(8);
                    aVar.lit.setVisibility(8);
                    aVar.lir.setVisibility(8);
                    aVar.liq.setVisibility(0);
                    aVar.lis.setVisibility(0);
                    aVar.jxu.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.jVD.setTag(image_url);
                aVar.jVD.setImageDrawable(null);
                aVar.jVD.startLoad(image_url, 10, false);
                aVar.lin.delete(0, aVar.lin.length());
                aVar.lin.append(forumData.getName());
                aVar.lin.append(this.lij.getPageContext().getString(R.string.forum));
                aVar.mName.setText(aVar.lin);
                if (this.ghv) {
                    ap.setImageResource(aVar.liq, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.lit.setText(String.format(this.lij.getPageContext().getString(R.string.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.liu.setOnClickListener(this.lik);
                    aVar.liu.setTag(Integer.valueOf(i));
                    if (i < this.mData.dhm()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_v), (Drawable) null);
                        if (!this.lgT && this.lil) {
                            aVar.liv.setVisibility(0);
                            aVar.liv.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.liv.setVisibility(8);
                    }
                    aVar.liv.setOnClickListener(this.lim);
                    aVar.liw.setVisibility(8);
                    if (this.lgT && this.lij.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.lgU)) {
                        aVar.liw.setVisibility(0);
                    }
                } else {
                    if ((this.lij.cHB() == 0 && i < this.mData.dhm()) || (this.lij.cHB() == 1 && i < this.mData.dhn())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.lij.cHB() == 1) {
                        aVar.liq.setVisibility(8);
                    }
                    aVar.liv.setVisibility(8);
                    ap.setImageResource(aVar.liq, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.lis.setText(forumData.getSlogan());
                }
                if (this.fny) {
                    aVar.liu.setVisibility(0);
                    aVar.liv.setVisibility(8);
                } else {
                    aVar.liu.setVisibility(8);
                    if (i < this.mData.dhm() && this.ghv && !this.lgT && this.lil) {
                        aVar.liv.setVisibility(0);
                    } else {
                        aVar.liv.setVisibility(8);
                    }
                }
            }
            view2 = view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
        co(view2);
        return view2;
    }

    private void co(View view) {
        this.lij.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.lij.getLayoutMode().onModeChanged(view);
    }

    public void M(View.OnClickListener onClickListener) {
        this.lik = onClickListener;
    }

    public void Y(View.OnClickListener onClickListener) {
        this.lim = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.ght) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void Os(String str) {
        this.lgU = str;
    }

    /* loaded from: classes18.dex */
    private class a {
        BarImageView jVD;
        ImageView jxu;
        StringBuffer lin;
        TextView lio;
        TextView lip;
        ImageView liq;
        TextView lir;
        TextView lis;
        TextView lit;
        Button liu;
        ImageView liv;
        ImageView liw;
        TextView mName;

        private a() {
        }
    }
}
