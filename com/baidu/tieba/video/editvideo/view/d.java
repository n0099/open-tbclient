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
    private a nCB;
    private HorizontalListView nFo;
    private com.baidu.tieba.video.editvideo.a.b nFp;
    private com.baidu.tieba.video.editvideo.b.a nFq;

    public d(com.baidu.adp.base.e eVar, a aVar) {
        super(eVar);
        this.nCB = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_filter_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.nFq = aVar;
    }

    private void initView() {
        this.nFo = (HorizontalListView) this.mRootView.findViewById(R.id.edit_filter_horizontal_list);
        this.nFp = new com.baidu.tieba.video.editvideo.a.b();
        setFilters(com.baidu.tieba.video.editvideo.b.a.gH(this.mRootView.getContext()));
        this.nFo.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) d.this.nFp.getItem(i);
                if (d.this.nFq != null) {
                    d.this.nFq.b(aVar);
                }
                if (d.this.nCB != null && d.this.nCB.dUS() != null) {
                    d.this.nCB.dUS().setFilter(aVar);
                }
            }
        });
    }

    public void setFilters(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.nFp.setData(list);
        this.nFo.setAdapter((ListAdapter) this.nFp);
    }

    public com.baidu.tieba.video.editvideo.data.a UU(String str) {
        for (com.baidu.tieba.video.editvideo.data.a aVar : this.nFp.getData()) {
            if (aVar != null && au.equals(aVar.value, str)) {
                return aVar;
            }
        }
        return null;
    }

    public void d(com.baidu.tieba.video.editvideo.data.a aVar) {
        this.nFp.a(aVar);
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
