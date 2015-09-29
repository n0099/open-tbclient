package com.baidu.tieba.launcherGuide.guide;

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
import com.baidu.tieba.i;
import com.baidu.tieba.launcherGuide.data.InterestFrsData;
import java.util.List;
/* loaded from: classes.dex */
public class f extends BaseAdapter {
    private View.OnClickListener adX;
    private Context mContext;
    private List<InterestFrsData.Card> mData;

    public f(Context context) {
        this.mContext = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.adX = onClickListener;
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
            view = LayoutInflater.from(this.mContext).inflate(i.g.new_user_img_item, viewGroup, false);
            aVar = new a(this, null);
            aVar.bRv = (TbImageView) view.findViewById(i.f.pic);
            aVar.bRw = (ImageView) view.findViewById(i.f.select_icon);
            aVar.bRx = (RelativeLayout) view.findViewById(i.f.lay_select);
            aVar.alP = (TextView) view.findViewById(i.f.tv_fname);
            aVar.bRu = (FrameLayout) view.findViewById(i.f.pic_layout);
            aVar.bRu.setOnClickListener(this.adX);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.bRv.setTag(null);
        aVar.bRx.setTag(null);
        aVar.alP.setText("");
        aVar.bRu.setTag(null);
        Object item = getItem(i);
        if (item != null && (item instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) item;
            a(aVar.bRw, card.getIs_like() == 1);
            aVar.bRx.setTag(card);
            aVar.bRu.setTag(card);
            aVar.bRv.setTag(card.getIcon_url());
            aVar.bRv.d(card.getIcon_url(), 21, false);
            aVar.alP.setText(card.getFname());
        }
        return view;
    }

    public void a(ImageView imageView, boolean z) {
        if (!z) {
            imageView.setBackgroundDrawable(this.mContext.getResources().getDrawable(i.e.icon_startpage2_add_pic_n));
        } else {
            imageView.setBackgroundDrawable(this.mContext.getResources().getDrawable(i.e.icon_startpage2_add_ba_s));
        }
    }

    /* loaded from: classes.dex */
    private class a {
        TextView alP;
        FrameLayout bRu;
        TbImageView bRv;
        ImageView bRw;
        RelativeLayout bRx;

        private a() {
        }

        /* synthetic */ a(f fVar, a aVar) {
            this();
        }
    }
}
