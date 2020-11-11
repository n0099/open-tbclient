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
import com.baidu.tieba.recommendlist.data.e;
/* loaded from: classes4.dex */
public class d extends AbsDelegateAdapter<e, a> {
    public d(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: cP */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(a.g.ala_recommend_live_type_item_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, e eVar, a aVar) {
        String string;
        switch (eVar.type) {
            case 0:
                string = this.mContext.getString(a.h.recommend_live_attention_no_count);
                break;
            default:
                string = eVar.title;
                break;
        }
        aVar.mBT.setText(string);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds16);
        if (i != 0) {
            aVar.mBT.setPadding(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds48), 0, dimensionPixelSize);
        } else {
            aVar.mBT.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
        }
        return view;
    }

    /* loaded from: classes4.dex */
    public static class a extends TypeAdapter.ViewHolder {
        private TextView mBT;

        private a(View view) {
            super(view);
            this.mBT = (TextView) view.findViewById(a.f.ala_recommend_live_type);
        }
    }
}
