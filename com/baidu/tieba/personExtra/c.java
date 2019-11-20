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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class c extends BaseAdapter {
    private boolean dQT;
    private boolean imt;
    private String imu;
    private PersonBarActivity inG;
    private boolean inI;
    private View.OnClickListener inJ;
    private b mData;
    private ArrayList<ForumData> mForumList = null;
    private boolean dfW = false;
    private View.OnClickListener inH = null;
    private boolean dQR = false;

    public c(PersonBarActivity personBarActivity, b bVar, boolean z, boolean z2) {
        this.mData = null;
        this.dQT = true;
        this.imt = false;
        this.inI = true;
        this.inG = personBarActivity;
        this.mData = bVar;
        this.dQT = z;
        this.imt = z2;
        this.inI = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void gc(boolean z) {
        this.dfW = z;
        notifyDataSetChanged();
    }

    public boolean aDk() {
        return this.dfW;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dQR) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void aMx() {
        this.dQR = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.dQR = true;
        }
    }

    public boolean cab() {
        return this.dQR;
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
                view3 = LayoutInflater.from(this.inG.getPageContext().getContext()).inflate(R.layout.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.hlc = (BarImageView) view3.findViewById(R.id.forum_avatar);
                    aVar.hlc.setGifIconSupport(false);
                    aVar.mName = (TextView) view3.findViewById(R.id.name);
                    aVar.inK = new StringBuffer(10);
                    aVar.inL = (TextView) view3.findViewById(R.id.degree);
                    aVar.inM = (TextView) view3.findViewById(R.id.degree_text);
                    aVar.inQ = (TextView) view3.findViewById(R.id.experience);
                    aVar.inO = (TextView) view3.findViewById(R.id.experience_title);
                    aVar.inR = (Button) view3.findViewById(R.id.item_delete);
                    aVar.inN = (ImageView) view3.findViewById(R.id.degree_text_ta);
                    aVar.inP = (TextView) view3.findViewById(R.id.intro_ta);
                    aVar.inS = (ImageView) view3.findViewById(R.id.item_talk);
                    aVar.gOh = (ImageView) view3.findViewById(R.id.diver_buttom_px);
                    aVar.gOh.setVisibility(0);
                    aVar.inT = (ImageView) view3.findViewById(R.id.item_selected);
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
            if (this.dQR) {
                aVar.inL.setVisibility(8);
                aVar.inR.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.hlc.setVisibility(8);
                aVar.inM.setVisibility(8);
                aVar.inQ.setVisibility(8);
                aVar.inO.setVisibility(8);
                aVar.inN.setVisibility(8);
                aVar.inP.setVisibility(8);
                aVar.inS.setVisibility(8);
                aVar.gOh.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.hlc.setVisibility(0);
                if (this.dQT) {
                    aVar.inL.setVisibility(8);
                    aVar.inM.setVisibility(8);
                    aVar.inQ.setVisibility(0);
                    aVar.inO.setVisibility(0);
                    aVar.inN.setVisibility(0);
                    aVar.inP.setVisibility(8);
                    aVar.gOh.setVisibility(0);
                } else {
                    aVar.inL.setVisibility(8);
                    aVar.inM.setVisibility(8);
                    aVar.inQ.setVisibility(8);
                    aVar.inO.setVisibility(8);
                    aVar.inN.setVisibility(0);
                    aVar.inP.setVisibility(0);
                    aVar.gOh.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.hlc.setTag(image_url);
                aVar.hlc.setImageDrawable(null);
                aVar.hlc.startLoad(image_url, 10, false);
                aVar.inK.delete(0, aVar.inK.length());
                aVar.inK.append(forumData.getName());
                aVar.inK.append(this.inG.getPageContext().getString(R.string.forum));
                aVar.mName.setText(aVar.inK);
                if (this.dQT) {
                    am.setImageResource(aVar.inN, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.inQ.setText(String.format(this.inG.getPageContext().getString(R.string.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.inR.setOnClickListener(this.inH);
                    aVar.inR.setTag(Integer.valueOf(i));
                    if (i < this.mData.bZQ()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_v), (Drawable) null);
                        if (!this.imt && this.inI) {
                            aVar.inS.setVisibility(0);
                            aVar.inS.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.inS.setVisibility(8);
                    }
                    aVar.inS.setOnClickListener(this.inJ);
                    aVar.inT.setVisibility(8);
                    if (this.imt && this.inG.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.imu)) {
                        aVar.inT.setVisibility(0);
                    }
                } else {
                    if ((this.inG.bDu() == 0 && i < this.mData.bZQ()) || (this.inG.bDu() == 1 && i < this.mData.bZR())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.inG.bDu() == 1) {
                        aVar.inN.setVisibility(8);
                    }
                    aVar.inS.setVisibility(8);
                    am.setImageResource(aVar.inN, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.inP.setText(forumData.getSlogan());
                }
                if (this.dfW) {
                    aVar.inR.setVisibility(0);
                    aVar.inS.setVisibility(8);
                } else {
                    aVar.inR.setVisibility(8);
                    if (i < this.mData.bZQ() && this.dQT && !this.imt && this.inI) {
                        aVar.inS.setVisibility(0);
                    } else {
                        aVar.inS.setVisibility(8);
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
        this.inG.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.inG.getLayoutMode().onModeChanged(view);
    }

    public void I(View.OnClickListener onClickListener) {
        this.inH = onClickListener;
    }

    public void U(View.OnClickListener onClickListener) {
        this.inJ = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.dQR) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void BB(String str) {
        this.imu = str;
    }

    /* loaded from: classes6.dex */
    private class a {
        ImageView gOh;
        BarImageView hlc;
        StringBuffer inK;
        TextView inL;
        TextView inM;
        ImageView inN;
        TextView inO;
        TextView inP;
        TextView inQ;
        Button inR;
        ImageView inS;
        ImageView inT;
        TextView mName;

        private a() {
        }
    }
}
