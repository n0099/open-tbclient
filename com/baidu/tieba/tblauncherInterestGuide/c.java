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
    private View.OnClickListener bbO;
    private Context mContext;
    private List<InterestFrsData.Card> mData;

    public c(Context context) {
        this.mContext = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.bbO = onClickListener;
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
            aVar.dsg = (TbImageView) view.findViewById(d.g.pic);
            aVar.dsh = (ImageView) view.findViewById(d.g.select_icon);
            aVar.hgu = (RelativeLayout) view.findViewById(d.g.lay_select);
            aVar.boB = (TextView) view.findViewById(d.g.tv_fname);
            aVar.hgt = (FrameLayout) view.findViewById(d.g.pic_layout);
            aVar.hgt.setOnClickListener(this.bbO);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.dsg.setTag(null);
        aVar.hgu.setTag(null);
        aVar.boB.setText("");
        aVar.hgt.setTag(null);
        Object item = getItem(i);
        if (item != null && (item instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) item;
            b(aVar.dsh, card.getIs_like() == 1);
            aVar.hgu.setTag(card);
            aVar.hgt.setTag(card);
            aVar.dsg.setTag(card.getIcon_url());
            aVar.dsg.startLoad(card.getIcon_url(), 21, false);
            aVar.boB.setText(card.getFname());
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
        TextView boB;
        TbImageView dsg;
        ImageView dsh;
        FrameLayout hgt;
        RelativeLayout hgu;

        private a() {
        }
    }
}
