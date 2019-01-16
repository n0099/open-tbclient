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
import com.baidu.tieba.e;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends BaseAdapter {
    private View.OnClickListener aIr;
    private Context mContext;
    private List<InterestFrsData.Card> mData;

    public c(Context context) {
        this.mContext = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aIr = onClickListener;
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
            view = LayoutInflater.from(this.mContext).inflate(e.h.new_user_img_item, viewGroup, false);
            aVar = new a();
            aVar.duZ = (TbImageView) view.findViewById(e.g.pic);
            aVar.dva = (ImageView) view.findViewById(e.g.select_icon);
            aVar.hww = (RelativeLayout) view.findViewById(e.g.lay_select);
            aVar.ajh = (TextView) view.findViewById(e.g.tv_fname);
            aVar.hwv = (FrameLayout) view.findViewById(e.g.pic_layout);
            aVar.hwv.setOnClickListener(this.aIr);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.duZ.setTag(null);
        aVar.hww.setTag(null);
        aVar.ajh.setText("");
        aVar.hwv.setTag(null);
        Object item = getItem(i);
        if (item != null && (item instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) item;
            b(aVar.dva, card.getIs_like() == 1);
            aVar.hww.setTag(card);
            aVar.hwv.setTag(card);
            aVar.duZ.setTag(card.getIcon_url());
            aVar.duZ.startLoad(card.getIcon_url(), 21, false);
            aVar.ajh.setText(card.getFname());
        }
        return view;
    }

    public void b(ImageView imageView, boolean z) {
        if (!z) {
            imageView.setBackgroundDrawable(this.mContext.getResources().getDrawable(e.f.icon_startpage2_add_pic_n));
        } else {
            imageView.setBackgroundDrawable(this.mContext.getResources().getDrawable(e.f.icon_startpage2_add_ba_s));
        }
    }

    /* loaded from: classes3.dex */
    private class a {
        TextView ajh;
        TbImageView duZ;
        ImageView dva;
        FrameLayout hwv;
        RelativeLayout hww;

        private a() {
        }
    }
}
