package com.baidu.tieba.recommendlist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.adp.widget.listview.TypeAdapter;
import com.baidu.live.sdk.a;
import com.baidu.tieba.recommendlist.data.g;
/* loaded from: classes10.dex */
public class e extends AbsDelegateAdapter<g, a> {
    public e(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: db */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(a.g.ala_recommend_live_type_item_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, g gVar, a aVar) {
        String string;
        switch (gVar.type) {
            case 0:
                string = this.mContext.getString(a.h.recommend_live_attention_no_count);
                break;
            default:
                string = gVar.title;
                break;
        }
        aVar.mRi.setText(string);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds16);
        if (i != 0) {
            aVar.mRi.setPadding(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds48), 0, dimensionPixelSize);
        } else {
            aVar.mRi.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
        }
        return view;
    }

    /* loaded from: classes10.dex */
    public static class a extends TypeAdapter.ViewHolder {
        private TextView mRi;

        private a(View view) {
            super(view);
            this.mRi = (TextView) view.findViewById(a.f.ala_recommend_live_type);
        }
    }
}
