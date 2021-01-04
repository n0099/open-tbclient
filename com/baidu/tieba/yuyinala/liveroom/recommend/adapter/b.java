package com.baidu.tieba.yuyinala.liveroom.recommend.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.adp.widget.listview.TypeAdapter;
import com.baidu.live.sdk.a;
import com.baidu.tieba.yuyinala.liveroom.recommend.data.c;
/* loaded from: classes11.dex */
public class b extends AbsDelegateAdapter<c, a> {
    public b(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: dg */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(a.g.ala_recommend_live_type_item_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, c cVar, a aVar) {
        String string;
        switch (cVar.type) {
            case 0:
                string = this.mContext.getString(a.h.recommend_live_attention, String.valueOf(cVar.count));
                break;
            default:
                string = this.mContext.getString(a.h.recommend_live_recommend);
                break;
        }
        aVar.mVU.setText(string);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds16);
        if (i == 0) {
            aVar.mVU.setPadding(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds20), 0, dimensionPixelSize);
        } else {
            aVar.mVU.setPadding(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds40), 0, dimensionPixelSize);
        }
        return view;
    }

    /* loaded from: classes11.dex */
    public static class a extends TypeAdapter.ViewHolder {
        private TextView mVU;

        private a(View view) {
            super(view);
            this.mVU = (TextView) view.findViewById(a.f.ala_recommend_live_type);
        }
    }
}
