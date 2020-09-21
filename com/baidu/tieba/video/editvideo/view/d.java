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
/* loaded from: classes22.dex */
public class d extends com.baidu.adp.base.c {
    private a mFi;
    private HorizontalListView mHY;
    private com.baidu.tieba.video.editvideo.a.b mHZ;
    private com.baidu.tieba.video.editvideo.b.a mIa;
    private Resources mResources;
    private View mRootView;

    public d(com.baidu.adp.base.e eVar, a aVar) {
        super(eVar);
        this.mFi = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_filter_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.mIa = aVar;
    }

    private void initView() {
        this.mHY = (HorizontalListView) this.mRootView.findViewById(R.id.edit_filter_horizontal_list);
        this.mHZ = new com.baidu.tieba.video.editvideo.a.b();
        setFilters(com.baidu.tieba.video.editvideo.b.a.fP(this.mRootView.getContext()));
        this.mHY.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) d.this.mHZ.getItem(i);
                if (d.this.mIa != null) {
                    d.this.mIa.b(aVar);
                }
                if (d.this.mFi != null && d.this.mFi.dGd() != null) {
                    d.this.mFi.dGd().setFilter(aVar);
                }
            }
        });
    }

    public void setFilters(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.mHZ.setData(list);
        this.mHY.setAdapter((ListAdapter) this.mHZ);
    }

    public com.baidu.tieba.video.editvideo.data.a Sq(String str) {
        for (com.baidu.tieba.video.editvideo.data.a aVar : this.mHZ.getData()) {
            if (aVar != null && at.equals(aVar.value, str)) {
                return aVar;
            }
        }
        return null;
    }

    public void d(com.baidu.tieba.video.editvideo.data.a aVar) {
        this.mHZ.a(aVar);
    }

    public void dz(View view) {
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void wN(boolean z) {
    }

    public void onPause() {
    }

    public void onResume() {
    }
}
