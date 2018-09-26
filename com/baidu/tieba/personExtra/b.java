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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private boolean dXb;
    private boolean gcW;
    private String gcX;
    private PersonBarActivity geG;
    private boolean geI;
    private View.OnClickListener geJ;
    private com.baidu.tieba.personExtra.a mData;
    private ArrayList<ForumData> mForumList = null;
    private boolean bsw = false;
    private View.OnClickListener geH = null;
    private boolean fpT = false;

    public b(PersonBarActivity personBarActivity, com.baidu.tieba.personExtra.a aVar, boolean z, boolean z2) {
        this.mData = null;
        this.dXb = true;
        this.gcW = false;
        this.geI = true;
        this.geG = personBarActivity;
        this.mData = aVar;
        this.dXb = z;
        this.gcW = z2;
        this.geI = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void cP(boolean z) {
        this.bsw = z;
        notifyDataSetChanged();
    }

    public boolean SJ() {
        return this.bsw;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fpT) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void aYy() {
        this.fpT = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.fpT = true;
        }
    }

    public boolean bkU() {
        return this.fpT;
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
                view3 = LayoutInflater.from(this.geG.getPageContext().getContext()).inflate(e.h.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.fdn = (BarImageView) view3.findViewById(e.g.forum_avatar);
                    aVar.fdn.setGifIconSupport(false);
                    aVar.mName = (TextView) view3.findViewById(e.g.name);
                    aVar.geK = new StringBuffer(10);
                    aVar.geL = (TextView) view3.findViewById(e.g.degree);
                    aVar.geM = (TextView) view3.findViewById(e.g.degree_text);
                    aVar.geQ = (TextView) view3.findViewById(e.g.experience);
                    aVar.geO = (TextView) view3.findViewById(e.g.experience_title);
                    aVar.geR = (Button) view3.findViewById(e.g.item_delete);
                    aVar.geN = (ImageView) view3.findViewById(e.g.degree_text_ta);
                    aVar.geP = (TextView) view3.findViewById(e.g.intro_ta);
                    aVar.geS = (ImageView) view3.findViewById(e.g.item_talk);
                    aVar.eHv = (ImageView) view3.findViewById(e.g.diver_buttom_px);
                    aVar.eHv.setVisibility(0);
                    aVar.geT = (ImageView) view3.findViewById(e.g.item_selected);
                    view3.setTag(aVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    BdLog.e(exc.getMessage());
                    aW(view2);
                    return view2;
                }
            } else {
                aVar = (a) view.getTag();
                view3 = view;
            }
            if (this.fpT) {
                aVar.geL.setVisibility(8);
                aVar.geR.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.fdn.setVisibility(8);
                aVar.geM.setVisibility(8);
                aVar.geQ.setVisibility(8);
                aVar.geO.setVisibility(8);
                aVar.geN.setVisibility(8);
                aVar.geP.setVisibility(8);
                aVar.geS.setVisibility(8);
                aVar.eHv.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.fdn.setVisibility(0);
                if (this.dXb) {
                    aVar.geL.setVisibility(8);
                    aVar.geM.setVisibility(8);
                    aVar.geQ.setVisibility(0);
                    aVar.geO.setVisibility(0);
                    aVar.geN.setVisibility(0);
                    aVar.geP.setVisibility(8);
                    aVar.eHv.setVisibility(0);
                } else {
                    aVar.geL.setVisibility(8);
                    aVar.geM.setVisibility(8);
                    aVar.geQ.setVisibility(8);
                    aVar.geO.setVisibility(8);
                    aVar.geN.setVisibility(0);
                    aVar.geP.setVisibility(0);
                    aVar.eHv.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.fdn.setTag(image_url);
                aVar.fdn.setImageDrawable(null);
                aVar.fdn.startLoad(image_url, 10, false);
                aVar.geK.delete(0, aVar.geK.length());
                aVar.geK.append(forumData.getName());
                aVar.geK.append(this.geG.getPageContext().getString(e.j.forum));
                aVar.mName.setText(aVar.geK);
                if (this.dXb) {
                    al.c(aVar.geN, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.geQ.setText(String.format(this.geG.getPageContext().getString(e.j.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.geR.setOnClickListener(this.geH);
                    aVar.geR.setTag(Integer.valueOf(i));
                    if (i < this.mData.bkJ()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_v), (Drawable) null);
                        if (!this.gcW && this.geI) {
                            aVar.geS.setVisibility(0);
                            aVar.geS.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.geS.setVisibility(8);
                    }
                    aVar.geS.setOnClickListener(this.geJ);
                    aVar.geT.setVisibility(8);
                    if (this.gcW && this.geG.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.gcX)) {
                        aVar.geT.setVisibility(0);
                    }
                } else {
                    if ((this.geG.aOX() == 0 && i < this.mData.bkJ()) || (this.geG.aOX() == 1 && i < this.mData.bkK())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.geG.aOX() == 1) {
                        aVar.geN.setVisibility(8);
                    }
                    aVar.geS.setVisibility(8);
                    al.c(aVar.geN, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.geP.setText(forumData.getSlogan());
                }
                if (this.bsw) {
                    aVar.geR.setVisibility(0);
                    aVar.geS.setVisibility(8);
                } else {
                    aVar.geR.setVisibility(8);
                    if (i < this.mData.bkJ() && this.dXb && !this.gcW && this.geI) {
                        aVar.geS.setVisibility(0);
                    } else {
                        aVar.geS.setVisibility(8);
                    }
                }
            }
            view2 = view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
        aW(view2);
        return view2;
    }

    private void aW(View view) {
        this.geG.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.geG.getLayoutMode().onModeChanged(view);
    }

    public void A(View.OnClickListener onClickListener) {
        this.geH = onClickListener;
    }

    public void N(View.OnClickListener onClickListener) {
        this.geJ = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.fpT) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void sB(String str) {
        this.gcX = str;
    }

    /* loaded from: classes3.dex */
    private class a {
        ImageView eHv;
        BarImageView fdn;
        StringBuffer geK;
        TextView geL;
        TextView geM;
        ImageView geN;
        TextView geO;
        TextView geP;
        TextView geQ;
        Button geR;
        ImageView geS;
        ImageView geT;
        TextView mName;

        private a() {
        }
    }
}
