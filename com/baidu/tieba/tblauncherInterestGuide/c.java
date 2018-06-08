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
    private View.OnClickListener avq;
    private Context mContext;
    private List<InterestFrsData.Card> mData;

    public c(Context context) {
        this.mContext = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.avq = onClickListener;
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
            view = LayoutInflater.from(this.mContext).inflate(d.i.new_user_img_item, viewGroup, false);
            aVar = new a();
            aVar.cVh = (TbImageView) view.findViewById(d.g.pic);
            aVar.cVi = (ImageView) view.findViewById(d.g.select_icon);
            aVar.gOB = (RelativeLayout) view.findViewById(d.g.lay_select);
            aVar.aHw = (TextView) view.findViewById(d.g.tv_fname);
            aVar.gOA = (FrameLayout) view.findViewById(d.g.pic_layout);
            aVar.gOA.setOnClickListener(this.avq);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.cVh.setTag(null);
        aVar.gOB.setTag(null);
        aVar.aHw.setText("");
        aVar.gOA.setTag(null);
        Object item = getItem(i);
        if (item != null && (item instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) item;
            b(aVar.cVi, card.getIs_like() == 1);
            aVar.gOB.setTag(card);
            aVar.gOA.setTag(card);
            aVar.cVh.setTag(card.getIcon_url());
            aVar.cVh.startLoad(card.getIcon_url(), 21, false);
            aVar.aHw.setText(card.getFname());
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
        TextView aHw;
        TbImageView cVh;
        ImageView cVi;
        FrameLayout gOA;
        RelativeLayout gOB;

        private a() {
        }
    }
}
