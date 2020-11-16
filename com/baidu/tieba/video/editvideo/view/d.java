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
/* loaded from: classes22.dex */
public class d extends com.baidu.adp.base.c {
    private Resources mResources;
    private View mRootView;
    private a noA;
    private HorizontalListView nrn;
    private com.baidu.tieba.video.editvideo.a.b nro;
    private com.baidu.tieba.video.editvideo.b.a nrp;

    public d(com.baidu.adp.base.e eVar, a aVar) {
        super(eVar);
        this.noA = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_filter_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.nrp = aVar;
    }

    private void initView() {
        this.nrn = (HorizontalListView) this.mRootView.findViewById(R.id.edit_filter_horizontal_list);
        this.nro = new com.baidu.tieba.video.editvideo.a.b();
        setFilters(com.baidu.tieba.video.editvideo.b.a.fW(this.mRootView.getContext()));
        this.nrn.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) d.this.nro.getItem(i);
                if (d.this.nrp != null) {
                    d.this.nrp.b(aVar);
                }
                if (d.this.noA != null && d.this.noA.dPy() != null) {
                    d.this.noA.dPy().setFilter(aVar);
                }
            }
        });
    }

    public void setFilters(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.nro.setData(list);
        this.nrn.setAdapter((ListAdapter) this.nro);
    }

    public com.baidu.tieba.video.editvideo.data.a TF(String str) {
        for (com.baidu.tieba.video.editvideo.data.a aVar : this.nro.getData()) {
            if (aVar != null && au.equals(aVar.value, str)) {
                return aVar;
            }
        }
        return null;
    }

    public void d(com.baidu.tieba.video.editvideo.data.a aVar) {
        this.nro.a(aVar);
    }

    public void dT(View view) {
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void yb(boolean z) {
    }

    public void onPause() {
    }

    public void onResume() {
    }
}
