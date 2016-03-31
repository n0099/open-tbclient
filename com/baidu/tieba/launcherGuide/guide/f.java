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
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class f extends BaseAdapter {
    private List<InterestFrsData.Card> aLU;
    private View.OnClickListener afZ;
    private Context mContext;

    public f(Context context) {
        this.mContext = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.afZ = onClickListener;
    }

    public void setData(List<InterestFrsData.Card> list) {
        this.aLU = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aLU != null) {
            return this.aLU.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aLU == null || i < 0 || i >= this.aLU.size()) {
            return null;
        }
        return this.aLU.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(t.h.new_user_img_item, viewGroup, false);
            aVar = new a(this, null);
            aVar.cDy = (TbImageView) view.findViewById(t.g.pic);
            aVar.cDz = (ImageView) view.findViewById(t.g.select_icon);
            aVar.cDA = (RelativeLayout) view.findViewById(t.g.lay_select);
            aVar.aqs = (TextView) view.findViewById(t.g.tv_fname);
            aVar.cDx = (FrameLayout) view.findViewById(t.g.pic_layout);
            aVar.cDx.setOnClickListener(this.afZ);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.cDy.setTag(null);
        aVar.cDA.setTag(null);
        aVar.aqs.setText("");
        aVar.cDx.setTag(null);
        Object item = getItem(i);
        if (item != null && (item instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) item;
            a(aVar.cDz, card.getIs_like() == 1);
            aVar.cDA.setTag(card);
            aVar.cDx.setTag(card);
            aVar.cDy.setTag(card.getIcon_url());
            aVar.cDy.c(card.getIcon_url(), 21, false);
            aVar.aqs.setText(card.getFname());
        }
        return view;
    }

    public void a(ImageView imageView, boolean z) {
        if (!z) {
            imageView.setBackgroundDrawable(this.mContext.getResources().getDrawable(t.f.icon_startpage2_add_pic_n));
        } else {
            imageView.setBackgroundDrawable(this.mContext.getResources().getDrawable(t.f.icon_startpage2_add_ba_s));
        }
    }

    /* loaded from: classes.dex */
    private class a {
        TextView aqs;
        RelativeLayout cDA;
        FrameLayout cDx;
        TbImageView cDy;
        ImageView cDz;

        private a() {
        }

        /* synthetic */ a(f fVar, a aVar) {
            this();
        }
    }
}
