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
    private boolean ghr;
    private boolean lgM;
    private String lgN;
    private PersonBarActivity lic;
    private boolean lie;
    private View.OnClickListener lif;
    private b mData;
    private ArrayList<ForumData> mForumList = null;
    private boolean fnu = false;
    private View.OnClickListener lid = null;
    private boolean ghp = false;

    public c(PersonBarActivity personBarActivity, b bVar, boolean z, boolean z2) {
        this.mData = null;
        this.ghr = true;
        this.lgM = false;
        this.lie = true;
        this.lic = personBarActivity;
        this.mData = bVar;
        this.ghr = z;
        this.lgM = z2;
        this.lie = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void km(boolean z) {
        this.fnu = z;
        notifyDataSetChanged();
    }

    public boolean bAI() {
        return this.fnu;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ghp) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void bLC() {
        this.ghp = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.ghp = true;
        }
    }

    public boolean dhw() {
        return this.ghp;
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
                view3 = LayoutInflater.from(this.lic.getPageContext().getContext()).inflate(R.layout.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.jVx = (BarImageView) view3.findViewById(R.id.forum_avatar);
                    aVar.jVx.setGifIconSupport(false);
                    aVar.jVx.setRadius(l.getDimens(this.lic, R.dimen.tbds10));
                    aVar.jVx.setConrers(15);
                    aVar.jVx.setPlaceHolder(2);
                    aVar.mName = (TextView) view3.findViewById(R.id.name);
                    aVar.lig = new StringBuffer(10);
                    aVar.lih = (TextView) view3.findViewById(R.id.degree);
                    aVar.lii = (TextView) view3.findViewById(R.id.degree_text);
                    aVar.lim = (TextView) view3.findViewById(R.id.experience);
                    aVar.lik = (TextView) view3.findViewById(R.id.experience_title);
                    aVar.lin = (Button) view3.findViewById(R.id.item_delete);
                    aVar.lij = (ImageView) view3.findViewById(R.id.degree_text_ta);
                    aVar.lil = (TextView) view3.findViewById(R.id.intro_ta);
                    aVar.lio = (ImageView) view3.findViewById(R.id.item_talk);
                    aVar.jxo = (ImageView) view3.findViewById(R.id.diver_buttom_px);
                    aVar.jxo.setVisibility(0);
                    aVar.lip = (ImageView) view3.findViewById(R.id.item_selected);
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
            if (this.ghp) {
                aVar.lih.setVisibility(8);
                aVar.lin.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.jVx.setVisibility(8);
                aVar.lii.setVisibility(8);
                aVar.lim.setVisibility(8);
                aVar.lik.setVisibility(8);
                aVar.lij.setVisibility(8);
                aVar.lil.setVisibility(8);
                aVar.lio.setVisibility(8);
                aVar.jxo.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.jVx.setVisibility(0);
                if (this.ghr) {
                    aVar.lih.setVisibility(8);
                    aVar.lii.setVisibility(8);
                    aVar.lim.setVisibility(0);
                    aVar.lik.setVisibility(0);
                    aVar.lij.setVisibility(0);
                    aVar.lil.setVisibility(8);
                    aVar.jxo.setVisibility(0);
                } else {
                    aVar.lih.setVisibility(8);
                    aVar.lii.setVisibility(8);
                    aVar.lim.setVisibility(8);
                    aVar.lik.setVisibility(8);
                    aVar.lij.setVisibility(0);
                    aVar.lil.setVisibility(0);
                    aVar.jxo.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.jVx.setTag(image_url);
                aVar.jVx.setImageDrawable(null);
                aVar.jVx.startLoad(image_url, 10, false);
                aVar.lig.delete(0, aVar.lig.length());
                aVar.lig.append(forumData.getName());
                aVar.lig.append(this.lic.getPageContext().getString(R.string.forum));
                aVar.mName.setText(aVar.lig);
                if (this.ghr) {
                    ap.setImageResource(aVar.lij, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.lim.setText(String.format(this.lic.getPageContext().getString(R.string.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.lin.setOnClickListener(this.lid);
                    aVar.lin.setTag(Integer.valueOf(i));
                    if (i < this.mData.dhl()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_v), (Drawable) null);
                        if (!this.lgM && this.lie) {
                            aVar.lio.setVisibility(0);
                            aVar.lio.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.lio.setVisibility(8);
                    }
                    aVar.lio.setOnClickListener(this.lif);
                    aVar.lip.setVisibility(8);
                    if (this.lgM && this.lic.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.lgN)) {
                        aVar.lip.setVisibility(0);
                    }
                } else {
                    if ((this.lic.cHA() == 0 && i < this.mData.dhl()) || (this.lic.cHA() == 1 && i < this.mData.dhm())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.lic.cHA() == 1) {
                        aVar.lij.setVisibility(8);
                    }
                    aVar.lio.setVisibility(8);
                    ap.setImageResource(aVar.lij, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.lil.setText(forumData.getSlogan());
                }
                if (this.fnu) {
                    aVar.lin.setVisibility(0);
                    aVar.lio.setVisibility(8);
                } else {
                    aVar.lin.setVisibility(8);
                    if (i < this.mData.dhl() && this.ghr && !this.lgM && this.lie) {
                        aVar.lio.setVisibility(0);
                    } else {
                        aVar.lio.setVisibility(8);
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
        this.lic.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.lic.getLayoutMode().onModeChanged(view);
    }

    public void M(View.OnClickListener onClickListener) {
        this.lid = onClickListener;
    }

    public void Y(View.OnClickListener onClickListener) {
        this.lif = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.ghp) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void Or(String str) {
        this.lgN = str;
    }

    /* loaded from: classes18.dex */
    private class a {
        BarImageView jVx;
        ImageView jxo;
        StringBuffer lig;
        TextView lih;
        TextView lii;
        ImageView lij;
        TextView lik;
        TextView lil;
        TextView lim;
        Button lin;
        ImageView lio;
        ImageView lip;
        TextView mName;

        private a() {
        }
    }
}
