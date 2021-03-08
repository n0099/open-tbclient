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
/* loaded from: classes7.dex */
public class c extends BaseAdapter {
    private boolean hmO;
    private b mData;
    private boolean mxQ;
    private String mxR;
    private PersonBarActivity mzh;
    private boolean mzj;
    private View.OnClickListener mzk;
    private ArrayList<ForumData> mForumList = null;
    private boolean ghQ = false;
    private View.OnClickListener mzi = null;
    private boolean hmM = false;

    public c(PersonBarActivity personBarActivity, b bVar, boolean z, boolean z2) {
        this.mData = null;
        this.hmO = true;
        this.mxQ = false;
        this.mzj = true;
        this.mzh = personBarActivity;
        this.mData = bVar;
        this.hmO = z;
        this.mxQ = z2;
        this.mzj = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void mc(boolean z) {
        this.ghQ = z;
        notifyDataSetChanged();
    }

    public boolean bLg() {
        return this.ghQ;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hmM) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void bYE() {
        this.hmM = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.hmM = true;
        }
    }

    public boolean dxL() {
        return this.hmM;
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
                view = LayoutInflater.from(this.mzh.getPageContext().getContext()).inflate(R.layout.edit_bar_item, (ViewGroup) null);
                aVar = new a();
                aVar.lkL = (BarImageView) view.findViewById(R.id.forum_avatar);
                aVar.lkL.setGifIconSupport(false);
                aVar.lkL.setRadius(l.getDimens(this.mzh, R.dimen.tbds10));
                aVar.lkL.setConrers(15);
                aVar.lkL.setPlaceHolder(2);
                aVar.mName = (TextView) view.findViewById(R.id.name);
                aVar.mzl = new StringBuffer(10);
                aVar.mzm = (TextView) view.findViewById(R.id.degree);
                aVar.mzn = (TextView) view.findViewById(R.id.degree_text);
                aVar.mzr = (TextView) view.findViewById(R.id.experience);
                aVar.mzp = (TextView) view.findViewById(R.id.experience_title);
                aVar.mzs = (Button) view.findViewById(R.id.item_delete);
                aVar.mzo = (ImageView) view.findViewById(R.id.degree_text_ta);
                aVar.mzq = (TextView) view.findViewById(R.id.intro_ta);
                aVar.mzt = (ImageView) view.findViewById(R.id.item_talk);
                aVar.kMG = (ImageView) view.findViewById(R.id.diver_buttom_px);
                aVar.kMG.setVisibility(0);
                aVar.mzu = (ImageView) view.findViewById(R.id.item_selected);
                view.setTag(aVar);
                view3 = view;
            } else {
                aVar = (a) view.getTag();
                view3 = view;
            }
            try {
                if (this.hmM) {
                    aVar.mzm.setVisibility(8);
                    aVar.mzs.setVisibility(8);
                    aVar.mName.setVisibility(8);
                    aVar.lkL.setVisibility(8);
                    aVar.mzn.setVisibility(8);
                    aVar.mzr.setVisibility(8);
                    aVar.mzp.setVisibility(8);
                    aVar.mzo.setVisibility(8);
                    aVar.mzq.setVisibility(8);
                    aVar.mzt.setVisibility(8);
                    aVar.kMG.setVisibility(8);
                } else {
                    aVar.mName.setVisibility(0);
                    aVar.lkL.setVisibility(0);
                    if (this.hmO) {
                        aVar.mzm.setVisibility(8);
                        aVar.mzn.setVisibility(8);
                        aVar.mzr.setVisibility(0);
                        aVar.mzp.setVisibility(0);
                        aVar.mzo.setVisibility(0);
                        aVar.mzq.setVisibility(8);
                        aVar.kMG.setVisibility(0);
                    } else {
                        aVar.mzm.setVisibility(8);
                        aVar.mzn.setVisibility(8);
                        aVar.mzr.setVisibility(8);
                        aVar.mzp.setVisibility(8);
                        aVar.mzo.setVisibility(0);
                        aVar.mzq.setVisibility(0);
                        aVar.kMG.setVisibility(0);
                    }
                }
                if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                    String image_url = forumData.getImage_url();
                    aVar.lkL.setTag(image_url);
                    aVar.lkL.setImageDrawable(null);
                    aVar.lkL.startLoad(image_url, 10, false);
                    aVar.mzl.delete(0, aVar.mzl.length());
                    aVar.mzl.append(forumData.getName());
                    aVar.mzl.append(this.mzh.getPageContext().getString(R.string.forum));
                    aVar.mName.setText(aVar.mzl);
                    if (this.hmO) {
                        ap.setImageResource(aVar.mzo, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                        aVar.mzr.setText(String.format(this.mzh.getPageContext().getString(R.string.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                        aVar.mzs.setOnClickListener(this.mzi);
                        aVar.mzs.setTag(Integer.valueOf(i));
                        if (i < this.mData.dxA()) {
                            aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_v), (Drawable) null);
                            if (!this.mxQ && this.mzj) {
                                aVar.mzt.setVisibility(0);
                                aVar.mzt.setTag(Integer.valueOf(i));
                            }
                        } else {
                            aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                            aVar.mzt.setVisibility(8);
                        }
                        aVar.mzt.setOnClickListener(this.mzk);
                        aVar.mzu.setVisibility(8);
                        if (this.mxQ && this.mzh.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.mxR)) {
                            aVar.mzu.setVisibility(0);
                        }
                    } else {
                        if ((this.mzh.cXy() == 0 && i < this.mData.dxA()) || (this.mzh.cXy() == 1 && i < this.mData.dxB())) {
                            aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_v), (Drawable) null);
                        } else {
                            aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        }
                        if (this.mzh.cXy() == 1) {
                            aVar.mzo.setVisibility(8);
                        }
                        aVar.mzt.setVisibility(8);
                        ap.setImageResource(aVar.mzo, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                        aVar.mzq.setText(forumData.getSlogan());
                    }
                    if (this.ghQ) {
                        aVar.mzs.setVisibility(0);
                        aVar.mzt.setVisibility(8);
                    } else {
                        aVar.mzs.setVisibility(8);
                        if (i < this.mData.dxA() && this.hmO && !this.mxQ && this.mzj) {
                            aVar.mzt.setVisibility(0);
                        } else {
                            aVar.mzt.setVisibility(8);
                        }
                    }
                }
                view2 = view3;
            } catch (Exception e2) {
                e = e2;
                view2 = view3;
                BdLog.e(e.getMessage());
                dd(view2);
                return view2;
            }
        } catch (Exception e3) {
            e = e3;
            view2 = view;
        }
        dd(view2);
        return view2;
    }

    private void dd(View view) {
        this.mzh.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.mzh.getLayoutMode().onModeChanged(view);
    }

    public void P(View.OnClickListener onClickListener) {
        this.mzi = onClickListener;
    }

    public void ab(View.OnClickListener onClickListener) {
        this.mzk = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.hmM) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void Qx(String str) {
        this.mxR = str;
    }

    /* loaded from: classes7.dex */
    private class a {
        ImageView kMG;
        BarImageView lkL;
        TextView mName;
        StringBuffer mzl;
        TextView mzm;
        TextView mzn;
        ImageView mzo;
        TextView mzp;
        TextView mzq;
        TextView mzr;
        Button mzs;
        ImageView mzt;
        ImageView mzu;

        private a() {
        }
    }
}
