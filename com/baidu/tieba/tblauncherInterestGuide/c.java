package com.baidu.tieba.tblauncherInterestGuide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends BaseAdapter {
    private View.OnClickListener bbM;
    private Context mContext;
    private List<InterestFrsData.Card> mData;

    public c(Context context) {
        this.mContext = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.bbM = onClickListener;
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
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(d.h.new_user_img_item, viewGroup, false);
            aVar = new a();
            aVar.dsd = (TbImageView) view.findViewById(d.g.pic);
            aVar.dse = (ImageView) view.findViewById(d.g.select_icon);
            aVar.hfW = (RelativeLayout) view.findViewById(d.g.lay_select);
            aVar.boy = (TextView) view.findViewById(d.g.tv_fname);
            aVar.hfV = (FrameLayout) view.findViewById(d.g.pic_layout);
            aVar.hfV.setOnClickListener(this.bbM);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.dsd.setTag(null);
        aVar.hfW.setTag(null);
        aVar.boy.setText("");
        aVar.hfV.setTag(null);
        Object item = getItem(i);
        if (item != null && (item instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) item;
            b(aVar.dse, card.getIs_like() == 1);
            aVar.hfW.setTag(card);
            aVar.hfV.setTag(card);
            aVar.dsd.setTag(card.getIcon_url());
            aVar.dsd.startLoad(card.getIcon_url(), 21, false);
            aVar.boy.setText(card.getFname());
        }
        return view;
    }

    public void b(ImageView imageView, boolean z) {
        if (!z) {
            imageView.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.icon_startpage2_add_pic_n));
        } else {
            imageView.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.icon_startpage2_add_ba_s));
        }
    }

    /* loaded from: classes3.dex */
    private class a {
        TextView boy;
        TbImageView dsd;
        ImageView dse;
        FrameLayout hfV;
        RelativeLayout hfW;

        private a() {
        }
    }
}
