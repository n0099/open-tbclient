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
    private w bpz;

    public b(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: cL */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(a.h.ala_follow_type_item_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.recommendlist.data.b bVar, a aVar) {
        List<IAdapterData> list = bVar.mwb;
        if (a(aVar.mvL, list)) {
            aVar.mvM = new com.baidu.tieba.recommendlist.adapter.a(this.mContext, com.baidu.tieba.recommendlist.data.a.mvY);
            aVar.mvL.addAdapter(aVar.mvM);
        }
        if (list.size() > 3) {
            aVar.mvM.Ic(102);
            aVar.mvL.setDividerWidth(this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds16));
        } else {
            aVar.mvM.Ic(101);
            aVar.mvL.setDividerWidth(this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds30));
        }
        aVar.mvM.setAlaLiveShowData(this.bpz);
        aVar.mvL.setData(bVar.mwb);
        return view;
    }

    private boolean a(HTypeListView hTypeListView, List<IAdapterData> list) {
        return (hTypeListView.getCount() > 3 && list.size() <= 3) || (hTypeListView.getCount() <= 3 && list.size() > 3);
    }

    public void setAlaLiveShowData(w wVar) {
        this.bpz = wVar;
    }

    /* loaded from: classes4.dex */
    public static class a extends TypeAdapter.ViewHolder {
        private HTypeListView mvL;
        private com.baidu.tieba.recommendlist.adapter.a mvM;

        private a(View view) {
            super(view);
            this.mvL = (HTypeListView) view.findViewById(a.g.followListView);
            this.mvM = new com.baidu.tieba.recommendlist.adapter.a(view.getContext(), com.baidu.tieba.recommendlist.data.a.mvY);
            this.mvL.addAdapter(this.mvM);
        }
    }
}
