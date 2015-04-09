package com.baidu.tieba.launcherGuide.guide;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.launcherGuide.data.InterestFrsData;
import java.util.List;
/* loaded from: classes.dex */
public class g extends BaseAdapter {
    private View.OnClickListener YC;
    private Context mContext;
    private List<InterestFrsData.Card> mData;

    public g(Context context) {
        this.mContext = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.YC = onClickListener;
    }

    public void setData(List<InterestFrsData.Card> list) {
        this.mData = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mData != null) {
            return this.mData.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mData == null || i < 0 || i >= this.mData.size()) {
            return null;
        }
        return this.mData.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        h hVar;
        if (view == null) {
            view = com.baidu.adp.lib.g.b.hH().a(this.mContext, com.baidu.tieba.w.new_user_img_item, viewGroup, false);
            hVar = new h(this, null);
            hVar.bwN = (TbImageView) view.findViewById(com.baidu.tieba.v.pic);
            hVar.bwO = (ImageView) view.findViewById(com.baidu.tieba.v.select_icon);
            hVar.bwP = (RelativeLayout) view.findViewById(com.baidu.tieba.v.lay_select);
            hVar.afF = (TextView) view.findViewById(com.baidu.tieba.v.tv_fname);
            hVar.bwM = (FrameLayout) view.findViewById(com.baidu.tieba.v.pic_layout);
            hVar.bwM.setOnClickListener(this.YC);
            view.setTag(hVar);
        } else {
            hVar = (h) view.getTag();
        }
        hVar.bwN.setTag(null);
        hVar.bwP.setTag(null);
        hVar.afF.setText("");
        hVar.bwM.setTag(null);
        Object item = getItem(i);
        if (item != null && (item instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) item;
            a(hVar.bwO, card.getIs_like() == 1);
            hVar.bwP.setTag(card);
            hVar.bwM.setTag(card);
            hVar.bwN.setTag(card.getIcon_url());
            hVar.bwN.c(card.getIcon_url(), 21, false);
            hVar.afF.setText(card.getFname());
        }
        return view;
    }

    public void a(ImageView imageView, boolean z) {
        if (!z) {
            imageView.setBackgroundDrawable(this.mContext.getResources().getDrawable(com.baidu.tieba.u.icon_startpage2_add_pic_n));
        } else {
            imageView.setBackgroundDrawable(this.mContext.getResources().getDrawable(com.baidu.tieba.u.icon_startpage2_add_ba_s));
        }
    }
}
