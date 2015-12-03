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
import com.baidu.tieba.launcherGuide.data.InterestFrsData;
import com.baidu.tieba.n;
import java.util.List;
/* loaded from: classes.dex */
public class f extends BaseAdapter {
    private View.OnClickListener afa;
    private Context mContext;
    private List<InterestFrsData.Card> mData;

    public f(Context context) {
        this.mContext = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.afa = onClickListener;
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
            view = LayoutInflater.from(this.mContext).inflate(n.g.new_user_img_item, viewGroup, false);
            aVar = new a(this, null);
            aVar.cio = (TbImageView) view.findViewById(n.f.pic);
            aVar.cip = (ImageView) view.findViewById(n.f.select_icon);
            aVar.ciq = (RelativeLayout) view.findViewById(n.f.lay_select);
            aVar.anI = (TextView) view.findViewById(n.f.tv_fname);
            aVar.cin = (FrameLayout) view.findViewById(n.f.pic_layout);
            aVar.cin.setOnClickListener(this.afa);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.cio.setTag(null);
        aVar.ciq.setTag(null);
        aVar.anI.setText("");
        aVar.cin.setTag(null);
        Object item = getItem(i);
        if (item != null && (item instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) item;
            a(aVar.cip, card.getIs_like() == 1);
            aVar.ciq.setTag(card);
            aVar.cin.setTag(card);
            aVar.cio.setTag(card.getIcon_url());
            aVar.cio.d(card.getIcon_url(), 21, false);
            aVar.anI.setText(card.getFname());
        }
        return view;
    }

    public void a(ImageView imageView, boolean z) {
        if (!z) {
            imageView.setBackgroundDrawable(this.mContext.getResources().getDrawable(n.e.icon_startpage2_add_pic_n));
        } else {
            imageView.setBackgroundDrawable(this.mContext.getResources().getDrawable(n.e.icon_startpage2_add_ba_s));
        }
    }

    /* loaded from: classes.dex */
    private class a {
        TextView anI;
        FrameLayout cin;
        TbImageView cio;
        ImageView cip;
        RelativeLayout ciq;

        private a() {
        }

        /* synthetic */ a(f fVar, a aVar) {
            this();
        }
    }
}
