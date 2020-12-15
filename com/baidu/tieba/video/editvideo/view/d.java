package com.baidu.tieba.video.editvideo.view;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes23.dex */
public class d extends com.baidu.adp.base.c {
    private Resources mResources;
    private View mRootView;
    private a nCD;
    private HorizontalListView nFq;
    private com.baidu.tieba.video.editvideo.a.b nFr;
    private com.baidu.tieba.video.editvideo.b.a nFs;

    public d(com.baidu.adp.base.e eVar, a aVar) {
        super(eVar);
        this.nCD = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_filter_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.nFs = aVar;
    }

    private void initView() {
        this.nFq = (HorizontalListView) this.mRootView.findViewById(R.id.edit_filter_horizontal_list);
        this.nFr = new com.baidu.tieba.video.editvideo.a.b();
        setFilters(com.baidu.tieba.video.editvideo.b.a.gH(this.mRootView.getContext()));
        this.nFq.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) d.this.nFr.getItem(i);
                if (d.this.nFs != null) {
                    d.this.nFs.b(aVar);
                }
                if (d.this.nCD != null && d.this.nCD.dUT() != null) {
                    d.this.nCD.dUT().setFilter(aVar);
                }
            }
        });
    }

    public void setFilters(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.nFr.setData(list);
        this.nFq.setAdapter((ListAdapter) this.nFr);
    }

    public com.baidu.tieba.video.editvideo.data.a UU(String str) {
        for (com.baidu.tieba.video.editvideo.data.a aVar : this.nFr.getData()) {
            if (aVar != null && au.equals(aVar.value, str)) {
                return aVar;
            }
        }
        return null;
    }

    public void d(com.baidu.tieba.video.editvideo.data.a aVar) {
        this.nFr.a(aVar);
    }

    public void ee(View view) {
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void yG(boolean z) {
    }

    public void onPause() {
    }

    public void onResume() {
    }
}
