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
/* loaded from: classes4.dex */
public class c extends BaseAdapter {
    private View.OnClickListener bQN;
    private Context mContext;
    private List<InterestFrsData.Card> mData;

    public c(Context context) {
        this.mContext = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.bQN = onClickListener;
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
            aVar.eIa = (TbImageView) view.findViewById(d.g.pic);
            aVar.eIb = (ImageView) view.findViewById(d.g.select_icon);
            aVar.iMV = (RelativeLayout) view.findViewById(d.g.lay_select);
            aVar.ahO = (TextView) view.findViewById(d.g.tv_fname);
            aVar.iMU = (FrameLayout) view.findViewById(d.g.pic_layout);
            aVar.iMU.setOnClickListener(this.bQN);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.eIa.setTag(null);
        aVar.iMV.setTag(null);
        aVar.ahO.setText("");
        aVar.iMU.setTag(null);
        Object item = getItem(i);
        if (item != null && (item instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) item;
            b(aVar.eIb, card.getIs_like() == 1);
            aVar.iMV.setTag(card);
            aVar.iMU.setTag(card);
            aVar.eIa.setTag(card.getIcon_url());
            aVar.eIa.startLoad(card.getIcon_url(), 21, false);
            aVar.ahO.setText(card.getFname());
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

    /* loaded from: classes4.dex */
    private class a {
        TextView ahO;
        TbImageView eIa;
        ImageView eIb;
        FrameLayout iMU;
        RelativeLayout iMV;

        private a() {
        }
    }
}
