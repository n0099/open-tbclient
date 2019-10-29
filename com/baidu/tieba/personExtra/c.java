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
    private boolean dRK;
    private boolean ink;
    private String inl;
    private View.OnClickListener ioA;
    private PersonBarActivity iox;
    private boolean ioz;
    private b mData;
    private ArrayList<ForumData> mForumList = null;
    private boolean dgN = false;
    private View.OnClickListener ioy = null;
    private boolean dRI = false;

    public c(PersonBarActivity personBarActivity, b bVar, boolean z, boolean z2) {
        this.mData = null;
        this.dRK = true;
        this.ink = false;
        this.ioz = true;
        this.iox = personBarActivity;
        this.mData = bVar;
        this.dRK = z;
        this.ink = z2;
        this.ioz = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
    }

    public void setForumList(ArrayList<ForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void gc(boolean z) {
        this.dgN = z;
        notifyDataSetChanged();
    }

    public boolean aDm() {
        return this.dgN;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dRI) {
            return 1;
        }
        if (this.mForumList != null) {
            return this.mForumList.size();
        }
        return 0;
    }

    public void aMz() {
        this.dRI = false;
        if (this.mForumList == null || this.mForumList.size() == 0) {
            this.dRI = true;
        }
    }

    public boolean cad() {
        return this.dRI;
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
                view3 = LayoutInflater.from(this.iox.getPageContext().getContext()).inflate(R.layout.edit_bar_item, (ViewGroup) null);
                try {
                    aVar = new a();
                    aVar.hlT = (BarImageView) view3.findViewById(R.id.forum_avatar);
                    aVar.hlT.setGifIconSupport(false);
                    aVar.mName = (TextView) view3.findViewById(R.id.name);
                    aVar.ioB = new StringBuffer(10);
                    aVar.ioC = (TextView) view3.findViewById(R.id.degree);
                    aVar.ioD = (TextView) view3.findViewById(R.id.degree_text);
                    aVar.ioH = (TextView) view3.findViewById(R.id.experience);
                    aVar.ioF = (TextView) view3.findViewById(R.id.experience_title);
                    aVar.ioI = (Button) view3.findViewById(R.id.item_delete);
                    aVar.ioE = (ImageView) view3.findViewById(R.id.degree_text_ta);
                    aVar.ioG = (TextView) view3.findViewById(R.id.intro_ta);
                    aVar.ioJ = (ImageView) view3.findViewById(R.id.item_talk);
                    aVar.gOY = (ImageView) view3.findViewById(R.id.diver_buttom_px);
                    aVar.gOY.setVisibility(0);
                    aVar.ioK = (ImageView) view3.findViewById(R.id.item_selected);
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
            if (this.dRI) {
                aVar.ioC.setVisibility(8);
                aVar.ioI.setVisibility(8);
                aVar.mName.setVisibility(8);
                aVar.hlT.setVisibility(8);
                aVar.ioD.setVisibility(8);
                aVar.ioH.setVisibility(8);
                aVar.ioF.setVisibility(8);
                aVar.ioE.setVisibility(8);
                aVar.ioG.setVisibility(8);
                aVar.ioJ.setVisibility(8);
                aVar.gOY.setVisibility(8);
            } else {
                aVar.mName.setVisibility(0);
                aVar.hlT.setVisibility(0);
                if (this.dRK) {
                    aVar.ioC.setVisibility(8);
                    aVar.ioD.setVisibility(8);
                    aVar.ioH.setVisibility(0);
                    aVar.ioF.setVisibility(0);
                    aVar.ioE.setVisibility(0);
                    aVar.ioG.setVisibility(8);
                    aVar.gOY.setVisibility(0);
                } else {
                    aVar.ioC.setVisibility(8);
                    aVar.ioD.setVisibility(8);
                    aVar.ioH.setVisibility(8);
                    aVar.ioF.setVisibility(8);
                    aVar.ioE.setVisibility(0);
                    aVar.ioG.setVisibility(0);
                    aVar.gOY.setVisibility(0);
                }
            }
            if (this.mForumList != null && i >= 0 && i < this.mForumList.size() && (forumData = this.mForumList.get(i)) != null) {
                String image_url = forumData.getImage_url();
                aVar.hlT.setTag(image_url);
                aVar.hlT.setImageDrawable(null);
                aVar.hlT.startLoad(image_url, 10, false);
                aVar.ioB.delete(0, aVar.ioB.length());
                aVar.ioB.append(forumData.getName());
                aVar.ioB.append(this.iox.getPageContext().getString(R.string.forum));
                aVar.mName.setText(aVar.ioB);
                if (this.dRK) {
                    am.setImageResource(aVar.ioE, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.ioH.setText(String.format(this.iox.getPageContext().getString(R.string.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aVar.ioI.setOnClickListener(this.ioy);
                    aVar.ioI.setTag(Integer.valueOf(i));
                    if (i < this.mData.bZS()) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_v), (Drawable) null);
                        if (!this.ink && this.ioz) {
                            aVar.ioJ.setVisibility(0);
                            aVar.ioJ.setTag(Integer.valueOf(i));
                        }
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aVar.ioJ.setVisibility(8);
                    }
                    aVar.ioJ.setOnClickListener(this.ioA);
                    aVar.ioK.setVisibility(8);
                    if (this.ink && this.iox.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.inl)) {
                        aVar.ioK.setVisibility(0);
                    }
                } else {
                    if ((this.iox.bDw() == 0 && i < this.mData.bZS()) || (this.iox.bDw() == 1 && i < this.mData.bZT())) {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_v), (Drawable) null);
                    } else {
                        aVar.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.iox.bDw() == 1) {
                        aVar.ioE.setVisibility(8);
                    }
                    aVar.ioJ.setVisibility(8);
                    am.setImageResource(aVar.ioE, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    aVar.ioG.setText(forumData.getSlogan());
                }
                if (this.dgN) {
                    aVar.ioI.setVisibility(0);
                    aVar.ioJ.setVisibility(8);
                } else {
                    aVar.ioI.setVisibility(8);
                    if (i < this.mData.bZS() && this.dRK && !this.ink && this.ioz) {
                        aVar.ioJ.setVisibility(0);
                    } else {
                        aVar.ioJ.setVisibility(8);
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
        this.iox.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.iox.getLayoutMode().onModeChanged(view);
    }

    public void I(View.OnClickListener onClickListener) {
        this.ioy = onClickListener;
    }

    public void U(View.OnClickListener onClickListener) {
        this.ioA = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.dRI) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void BB(String str) {
        this.inl = str;
    }

    /* loaded from: classes6.dex */
    private class a {
        ImageView gOY;
        BarImageView hlT;
        StringBuffer ioB;
        TextView ioC;
        TextView ioD;
        ImageView ioE;
        TextView ioF;
        TextView ioG;
        TextView ioH;
        Button ioI;
        ImageView ioJ;
        ImageView ioK;
        TextView mName;

        private a() {
        }
    }
}
