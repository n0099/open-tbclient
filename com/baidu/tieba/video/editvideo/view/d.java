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
    private a mUV;
    private HorizontalListView mXJ;
    private com.baidu.tieba.video.editvideo.a.b mXK;
    private com.baidu.tieba.video.editvideo.b.a mXL;

    public d(com.baidu.adp.base.e eVar, a aVar) {
        super(eVar);
        this.mUV = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_filter_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.mXL = aVar;
    }

    private void initView() {
        this.mXJ = (HorizontalListView) this.mRootView.findViewById(R.id.edit_filter_horizontal_list);
        this.mXK = new com.baidu.tieba.video.editvideo.a.b();
        setFilters(com.baidu.tieba.video.editvideo.b.a.fW(this.mRootView.getContext()));
        this.mXJ.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) d.this.mXK.getItem(i);
                if (d.this.mXL != null) {
                    d.this.mXL.b(aVar);
                }
                if (d.this.mUV != null && d.this.mUV.dJP() != null) {
                    d.this.mUV.dJP().setFilter(aVar);
                }
            }
        });
    }

    public void setFilters(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.mXK.setData(list);
        this.mXJ.setAdapter((ListAdapter) this.mXK);
    }

    public com.baidu.tieba.video.editvideo.data.a Te(String str) {
        for (com.baidu.tieba.video.editvideo.data.a aVar : this.mXK.getData()) {
            if (aVar != null && at.equals(aVar.value, str)) {
                return aVar;
            }
        }
        return null;
    }

    public void d(com.baidu.tieba.video.editvideo.data.a aVar) {
        this.mXK.a(aVar);
    }

    public void dD(View view) {
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void xu(boolean z) {
    }

    public void onPause() {
    }

    public void onResume() {
    }
}
