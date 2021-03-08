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
/* loaded from: classes7.dex */
public class d extends com.baidu.adp.base.d {
    private Resources mResources;
    private View mRootView;
    private a nOu;
    private HorizontalListView nRf;
    private com.baidu.tieba.video.editvideo.a.b nRg;
    private com.baidu.tieba.video.editvideo.b.a nRh;

    public d(f fVar, a aVar) {
        super(fVar);
        this.nOu = aVar;
        this.mRootView = LayoutInflater.from(fVar.getPageActivity()).inflate(R.layout.edit_filter_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.nRh = aVar;
    }

    private void initView() {
        this.nRf = (HorizontalListView) this.mRootView.findViewById(R.id.edit_filter_horizontal_list);
        this.nRg = new com.baidu.tieba.video.editvideo.a.b();
        setFilters(com.baidu.tieba.video.editvideo.b.a.gZ(this.mRootView.getContext()));
        this.nRf.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) d.this.nRg.getItem(i);
                if (d.this.nRh != null) {
                    d.this.nRh.b(aVar);
                }
                if (d.this.nOu != null && d.this.nOu.dTu() != null) {
                    d.this.nOu.dTu().setFilter(aVar);
                }
            }
        });
    }

    public void setFilters(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.nRg.setData(list);
        this.nRf.setAdapter((ListAdapter) this.nRg);
    }

    public com.baidu.tieba.video.editvideo.data.a UJ(String str) {
        for (com.baidu.tieba.video.editvideo.data.a aVar : this.nRg.getData()) {
            if (aVar != null && au.equals(aVar.value, str)) {
                return aVar;
            }
        }
        return null;
    }

    public void d(com.baidu.tieba.video.editvideo.data.a aVar) {
        this.nRg.a(aVar);
    }

    public void em(View view) {
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void yX(boolean z) {
    }

    public void onPause() {
    }

    public void onResume() {
    }
}
