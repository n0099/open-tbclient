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
import com.baidu.tieba.R;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import java.util.List;
/* loaded from: classes9.dex */
public class c extends BaseAdapter {
    private View.OnClickListener dgy;
    private Context mContext;
    private List<InterestFrsData.Card> mData;

    public c(Context context) {
        this.mContext = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.dgy = onClickListener;
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
            view = LayoutInflater.from(this.mContext).inflate(R.layout.new_user_img_item, viewGroup, false);
            aVar = new a();
            aVar.gcc = (TbImageView) view.findViewById(R.id.pic);
            aVar.aDc = (ImageView) view.findViewById(R.id.select_icon);
            aVar.aDd = (RelativeLayout) view.findViewById(R.id.lay_select);
            aVar.textView = (TextView) view.findViewById(R.id.tv_fname);
            aVar.kpp = (FrameLayout) view.findViewById(R.id.pic_layout);
            aVar.kpp.setOnClickListener(this.dgy);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.gcc.setTag(null);
        aVar.aDd.setTag(null);
        aVar.textView.setText("");
        aVar.kpp.setTag(null);
        Object item = getItem(i);
        if (item != null && (item instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) item;
            d(aVar.aDc, card.getIs_like() == 1);
            aVar.aDd.setTag(card);
            aVar.kpp.setTag(card);
            aVar.gcc.setTag(card.getIcon_url());
            aVar.gcc.startLoad(card.getIcon_url(), 21, false);
            aVar.textView.setText(card.getFname());
        }
        return view;
    }

    public void d(ImageView imageView, boolean z) {
        if (!z) {
            imageView.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.icon_startpage2_add_pic_n));
        } else {
            imageView.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.icon_startpage2_add_ba_s));
        }
    }

    /* loaded from: classes9.dex */
    private class a {
        ImageView aDc;
        RelativeLayout aDd;
        TbImageView gcc;
        FrameLayout kpp;
        TextView textView;

        private a() {
        }
    }
}
