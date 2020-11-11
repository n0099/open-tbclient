package com.baidu.tieba.recommendlist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.adp.widget.listview.IAdapterData;
import com.baidu.live.adp.widget.listview.TypeAdapter;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tieba.horizonallist.widget.HTypeListView;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends AbsDelegateAdapter<com.baidu.tieba.recommendlist.data.b, a> {
    private w bqS;

    public b(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: cN */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(a.g.ala_follow_type_item_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.recommendlist.data.b bVar, a aVar) {
        List<IAdapterData> list = bVar.mBY;
        if (a(aVar.mBI, list)) {
            aVar.mBJ = new com.baidu.tieba.recommendlist.adapter.a(this.mContext, com.baidu.tieba.recommendlist.data.a.mBV);
            aVar.mBI.addAdapter(aVar.mBJ);
        }
        if (list.size() > 3) {
            aVar.mBJ.Ip(102);
            aVar.mBI.setDividerWidth(this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds16));
        } else {
            aVar.mBJ.Ip(101);
            aVar.mBI.setDividerWidth(this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds30));
        }
        aVar.mBJ.setAlaLiveShowData(this.bqS);
        aVar.mBI.setData(bVar.mBY);
        return view;
    }

    private boolean a(HTypeListView hTypeListView, List<IAdapterData> list) {
        return (hTypeListView.getCount() > 3 && list.size() <= 3) || (hTypeListView.getCount() <= 3 && list.size() > 3);
    }

    public void setAlaLiveShowData(w wVar) {
        this.bqS = wVar;
    }

    /* loaded from: classes4.dex */
    public static class a extends TypeAdapter.ViewHolder {
        private HTypeListView mBI;
        private com.baidu.tieba.recommendlist.adapter.a mBJ;

        private a(View view) {
            super(view);
            this.mBI = (HTypeListView) view.findViewById(a.f.followListView);
            this.mBJ = new com.baidu.tieba.recommendlist.adapter.a(view.getContext(), com.baidu.tieba.recommendlist.data.a.mBV);
            this.mBI.addAdapter(this.mBJ);
        }
    }
}
