package com.baidu.tieba.video.editvideo.view;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes10.dex */
public class d extends com.baidu.adp.base.c {
    private a lVY;
    private HorizontalListView lYO;
    private com.baidu.tieba.video.editvideo.a.b lYP;
    private com.baidu.tieba.video.editvideo.b.a lYQ;
    private Resources mResources;
    private View mRootView;

    public d(com.baidu.adp.base.e eVar, a aVar) {
        super(eVar);
        this.lVY = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_filter_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.lYQ = aVar;
    }

    private void initView() {
        this.lYO = (HorizontalListView) this.mRootView.findViewById(R.id.edit_filter_horizontal_list);
        this.lYP = new com.baidu.tieba.video.editvideo.a.b();
        setFilters(com.baidu.tieba.video.editvideo.b.a.ft(this.mRootView.getContext()));
        this.lYO.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) d.this.lYP.getItem(i);
                if (d.this.lYQ != null) {
                    d.this.lYQ.b(aVar);
                }
                if (d.this.lVY != null && d.this.lVY.dnq() != null) {
                    d.this.lVY.dnq().setFilter(aVar);
                }
            }
        });
    }

    public void setFilters(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.lYP.setData(list);
        this.lYO.setAdapter((ListAdapter) this.lYP);
    }

    public com.baidu.tieba.video.editvideo.data.a Oj(String str) {
        for (com.baidu.tieba.video.editvideo.data.a aVar : this.lYP.getData()) {
            if (aVar != null && ar.equals(aVar.value, str)) {
                return aVar;
            }
        }
        return null;
    }

    public void d(com.baidu.tieba.video.editvideo.data.a aVar) {
        this.lYP.a(aVar);
    }

    public void dg(View view) {
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void vj(boolean z) {
    }

    public void onPause() {
    }

    public void onResume() {
    }
}
