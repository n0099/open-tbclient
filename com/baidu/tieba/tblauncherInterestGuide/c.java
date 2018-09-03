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
import com.baidu.tieba.f;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends BaseAdapter {
    private View.OnClickListener avD;
    private Context mContext;
    private List<InterestFrsData.Card> mData;

    public c(Context context) {
        this.mContext = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.avD = onClickListener;
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
            view = LayoutInflater.from(this.mContext).inflate(f.h.new_user_img_item, viewGroup, false);
            aVar = new a();
            aVar.cVS = (TbImageView) view.findViewById(f.g.pic);
            aVar.cVT = (ImageView) view.findViewById(f.g.select_icon);
            aVar.gUc = (RelativeLayout) view.findViewById(f.g.lay_select);
            aVar.aIr = (TextView) view.findViewById(f.g.tv_fname);
            aVar.gUb = (FrameLayout) view.findViewById(f.g.pic_layout);
            aVar.gUb.setOnClickListener(this.avD);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.cVS.setTag(null);
        aVar.gUc.setTag(null);
        aVar.aIr.setText("");
        aVar.gUb.setTag(null);
        Object item = getItem(i);
        if (item != null && (item instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) item;
            b(aVar.cVT, card.getIs_like() == 1);
            aVar.gUc.setTag(card);
            aVar.gUb.setTag(card);
            aVar.cVS.setTag(card.getIcon_url());
            aVar.cVS.startLoad(card.getIcon_url(), 21, false);
            aVar.aIr.setText(card.getFname());
        }
        return view;
    }

    public void b(ImageView imageView, boolean z) {
        if (!z) {
            imageView.setBackgroundDrawable(this.mContext.getResources().getDrawable(f.C0146f.icon_startpage2_add_pic_n));
        } else {
            imageView.setBackgroundDrawable(this.mContext.getResources().getDrawable(f.C0146f.icon_startpage2_add_ba_s));
        }
    }

    /* loaded from: classes3.dex */
    private class a {
        TextView aIr;
        TbImageView cVS;
        ImageView cVT;
        FrameLayout gUb;
        RelativeLayout gUc;

        private a() {
        }
    }
}
