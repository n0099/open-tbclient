package com.baidu.tieba.video.editvideo.view;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.base.f;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes8.dex */
public class d extends com.baidu.adp.base.d {
    private Resources mResources;
    private View mRootView;
    private a nMp;
    private HorizontalListView nPa;
    private com.baidu.tieba.video.editvideo.a.b nPb;
    private com.baidu.tieba.video.editvideo.b.a nPc;

    public d(f fVar, a aVar) {
        super(fVar);
        this.nMp = aVar;
        this.mRootView = LayoutInflater.from(fVar.getPageActivity()).inflate(R.layout.edit_filter_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.nPc = aVar;
    }

    private void initView() {
        this.nPa = (HorizontalListView) this.mRootView.findViewById(R.id.edit_filter_horizontal_list);
        this.nPb = new com.baidu.tieba.video.editvideo.a.b();
        setFilters(com.baidu.tieba.video.editvideo.b.a.ha(this.mRootView.getContext()));
        this.nPa.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) d.this.nPb.getItem(i);
                if (d.this.nPc != null) {
                    d.this.nPc.b(aVar);
                }
                if (d.this.nMp != null && d.this.nMp.dTm() != null) {
                    d.this.nMp.dTm().setFilter(aVar);
                }
            }
        });
    }

    public void setFilters(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.nPb.setData(list);
        this.nPa.setAdapter((ListAdapter) this.nPb);
    }

    public com.baidu.tieba.video.editvideo.data.a UC(String str) {
        for (com.baidu.tieba.video.editvideo.data.a aVar : this.nPb.getData()) {
            if (aVar != null && au.equals(aVar.value, str)) {
                return aVar;
            }
        }
        return null;
    }

    public void d(com.baidu.tieba.video.editvideo.data.a aVar) {
        this.nPb.a(aVar);
    }

    public void em(View view) {
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void yY(boolean z) {
    }

    public void onPause() {
    }

    public void onResume() {
    }
}
