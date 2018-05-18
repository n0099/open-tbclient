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
    private View.OnClickListener ani;
    private Context mContext;
    private List<InterestFrsData.Card> mData;

    public c(Context context) {
        this.mContext = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.ani = onClickListener;
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
    public View getView(int i, View view2, ViewGroup viewGroup) {
        a aVar;
        if (view2 == null) {
            view2 = LayoutInflater.from(this.mContext).inflate(d.i.new_user_img_item, viewGroup, false);
            aVar = new a();
            aVar.cMb = (TbImageView) view2.findViewById(d.g.pic);
            aVar.cMc = (ImageView) view2.findViewById(d.g.select_icon);
            aVar.gCZ = (RelativeLayout) view2.findViewById(d.g.lay_select);
            aVar.azb = (TextView) view2.findViewById(d.g.tv_fname);
            aVar.gCY = (FrameLayout) view2.findViewById(d.g.pic_layout);
            aVar.gCY.setOnClickListener(this.ani);
            view2.setTag(aVar);
        } else {
            aVar = (a) view2.getTag();
        }
        aVar.cMb.setTag(null);
        aVar.gCZ.setTag(null);
        aVar.azb.setText("");
        aVar.gCY.setTag(null);
        Object item = getItem(i);
        if (item != null && (item instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) item;
            b(aVar.cMc, card.getIs_like() == 1);
            aVar.gCZ.setTag(card);
            aVar.gCY.setTag(card);
            aVar.cMb.setTag(card.getIcon_url());
            aVar.cMb.startLoad(card.getIcon_url(), 21, false);
            aVar.azb.setText(card.getFname());
        }
        return view2;
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
        TextView azb;
        TbImageView cMb;
        ImageView cMc;
        FrameLayout gCY;
        RelativeLayout gCZ;

        private a() {
        }
    }
}
