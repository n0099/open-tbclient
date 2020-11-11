package com.baidu.tieba.video.editvideo.view;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes23.dex */
public class d extends com.baidu.adp.base.c {
    private Resources mResources;
    private View mRootView;
    private a nnr;
    private HorizontalListView nqg;
    private com.baidu.tieba.video.editvideo.a.b nqh;
    private com.baidu.tieba.video.editvideo.b.a nqi;

    public d(com.baidu.adp.base.e eVar, a aVar) {
        super(eVar);
        this.nnr = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_filter_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.nqi = aVar;
    }

    private void initView() {
        this.nqg = (HorizontalListView) this.mRootView.findViewById(R.id.edit_filter_horizontal_list);
        this.nqh = new com.baidu.tieba.video.editvideo.a.b();
        setFilters(com.baidu.tieba.video.editvideo.b.a.fX(this.mRootView.getContext()));
        this.nqg.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) d.this.nqh.getItem(i);
                if (d.this.nqi != null) {
                    d.this.nqi.b(aVar);
                }
                if (d.this.nnr != null && d.this.nnr.dPz() != null) {
                    d.this.nnr.dPz().setFilter(aVar);
                }
            }
        });
    }

    public void setFilters(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.nqh.setData(list);
        this.nqg.setAdapter((ListAdapter) this.nqh);
    }

    public com.baidu.tieba.video.editvideo.data.a TU(String str) {
        for (com.baidu.tieba.video.editvideo.data.a aVar : this.nqh.getData()) {
            if (aVar != null && at.equals(aVar.value, str)) {
                return aVar;
            }
        }
        return null;
    }

    public void d(com.baidu.tieba.video.editvideo.data.a aVar) {
        this.nqh.a(aVar);
    }

    public void dM(View view) {
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void xU(boolean z) {
    }

    public void onPause() {
    }

    public void onResume() {
    }
}
