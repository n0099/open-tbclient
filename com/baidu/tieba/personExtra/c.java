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
    private boolean fEF;
    private boolean kmR;
    private String kmS;
    private PersonBarActivity kof;
    private boolean koh;
    private View.OnClickListener koi;
    private b mData;
    private ArrayList<ForumData> mForumList = null;
    private boolean eNc = false;
    private View.OnClickListener kog = null;
    private boolean fED = false;

    public c(PersonBarActivity personBarActivity, b bVar, boolean z, boolean z2) {
        this.mData = null;
        this.fEF = true;
        this.kmR = false;
        this.koh = true;
        this.kof = personBarActivity;
        this.mData = bVar;
        this.fEF = z;
        this.kmR = z2;
        this.koh = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void iY(boolean z) {
        this.eNc = z;
        notifyDataSetChanged();
    }

    public boolean bmh() {
        return this.eNc;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fED) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void bvW() {
        this.fED = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.fED = true;
        }
    }

    public boolean cOb() {
        return this.fED;
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
                view3 = LayoutInflater.from(this.kof.getPageContext().getContext()).inflate(R.layout.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.jfE = (BarImageView) view3.findViewById(R.id.forum_avatar);
                    aVar.jfE.setGifIconSupport(false);
                    aVar.jfE.setRadius(l.getDimens(this.kof, R.dimen.tbds10));
                    aVar.jfE.setConrers(15);
                    aVar.jfE.setPlaceHolder(2);
                    aVar.mName = (TextView) view3.findViewById(R.id.name);
                    aVar.koj = new StringBuffer(10);
                    aVar.kok = (TextView) view3.findViewById(R.id.degree);
                    aVar.kol = (TextView) view3.findViewById(R.id.degree_text);
                    aVar.kop = (TextView) view3.findViewById(R.id.experience);
                    aVar.kon = (TextView) view3.findViewById(R.id.experience_title);
                    aVar.koq = (Button) view3.findViewById(R.id.item_delete);
                    aVar.kom = (ImageView) view3.findViewById(R.id.degree_text_ta);
                    aVar.koo = (TextView) view3.findViewById(R.id.intro_ta);
                    aVar.kor = (ImageView) view3.findViewById(R.id.item_talk);
                    aVar.iId = (ImageView) view3.findViewById(R.id.diver_buttom_px);
                    aVar.iId.setVisibility(0);
                    aVar.kos = (ImageView) view3.findViewById(R.id.item_selected);
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
            if (this.fED) {
                aVar.kok.setVisibility(8);
                aVar.koq.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.jfE.setVisibility(8);
                aVar.kol.setVisibility(8);
                aVar.kop.setVisibility(8);
                aVar.kon.setVisibility(8);
                aVar.kom.setVisibility(8);
                aVar.koo.setVisibility(8);
                aVar.kor.setVisibility(8);
                aVar.iId.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.jfE.setVisibility(0);
                if (this.fEF) {
                    aVar.kok.setVisibility(8);
                    aVar.kol.setVisibility(8);
                    aVar.kop.setVisibility(0);
                    aVar.kon.setVisibility(0);
                    aVar.kom.setVisibility(0);
                    aVar.koo.setVisibility(8);
                    aVar.iId.setVisibility(0);
                } else {
                    aVar.kok.setVisibility(8);
                    aVar.kol.setVisibility(8);
                    aVar.kop.setVisibility(8);
                    aVar.kon.setVisibility(8);
                    aVar.kom.setVisibility(0);
                    aVar.koo.setVisibility(0);
                    aVar.iId.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.jfE.setTag(image_url);
                aVar.jfE.setImageDrawable(null);
                aVar.jfE.startLoad(image_url, 10, false);
                aVar.koj.delete(0, aVar.koj.length());
                aVar.koj.append(forumData.getName());
                aVar.koj.append(this.kof.getPageContext().getString(R.string.forum));
                aVar.mName.setText(aVar.koj);
                if (this.fEF) {
                    am.setImageResource(aVar.kom, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.kop.setText(String.format(this.kof.getPageContext().getString(R.string.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.koq.setOnClickListener(this.kog);
                    aVar.koq.setTag(Integer.valueOf(i));
                    if (i < this.mData.cNQ()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_v), (Drawable) null);
                        if (!this.kmR && this.koh) {
                            aVar.kor.setVisibility(0);
                            aVar.kor.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.kor.setVisibility(8);
                    }
                    aVar.kor.setOnClickListener(this.koi);
                    aVar.kos.setVisibility(8);
                    if (this.kmR && this.kof.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.kmS)) {
                        aVar.kos.setVisibility(0);
                    }
                } else {
                    if ((this.kof.coI() == 0 && i < this.mData.cNQ()) || (this.kof.coI() == 1 && i < this.mData.cNR())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.kof.coI() == 1) {
                        aVar.kom.setVisibility(8);
                    }
                    aVar.kor.setVisibility(8);
                    am.setImageResource(aVar.kom, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.koo.setText(forumData.getSlogan());
                }
                if (this.eNc) {
                    aVar.koq.setVisibility(0);
                    aVar.kor.setVisibility(8);
                } else {
                    aVar.koq.setVisibility(8);
                    if (i < this.mData.cNQ() && this.fEF && !this.kmR && this.koh) {
                        aVar.kor.setVisibility(0);
                    } else {
                        aVar.kor.setVisibility(8);
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
        this.kof.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.kof.getLayoutMode().onModeChanged(view);
    }

    public void K(View.OnClickListener onClickListener) {
        this.kog = onClickListener;
    }

    public void V(View.OnClickListener onClickListener) {
        this.koi = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fED) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void Ki(String str) {
        this.kmS = str;
    }

    /* loaded from: classes11.dex */
    private class a {
        ImageView iId;
        BarImageView jfE;
        StringBuffer koj;
        TextView kok;
        TextView kol;
        ImageView kom;
        TextView kon;
        TextView koo;
        TextView kop;
        Button koq;
        ImageView kor;
        ImageView kos;
        TextView mName;

        private a() {
        }
    }
}
