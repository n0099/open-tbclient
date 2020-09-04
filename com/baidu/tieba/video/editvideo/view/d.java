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
/* loaded from: classes17.dex */
public class d extends com.baidu.adp.base.c {
    private Resources mResources;
    private View mRootView;
    private a mvw;
    private HorizontalListView mym;
    private com.baidu.tieba.video.editvideo.a.b myn;
    private com.baidu.tieba.video.editvideo.b.a myo;

    public d(com.baidu.adp.base.e eVar, a aVar) {
        super(eVar);
        this.mvw = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_filter_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.myo = aVar;
    }

    private void initView() {
        this.mym = (HorizontalListView) this.mRootView.findViewById(R.id.edit_filter_horizontal_list);
        this.myn = new com.baidu.tieba.video.editvideo.a.b();
        setFilters(com.baidu.tieba.video.editvideo.b.a.fJ(this.mRootView.getContext()));
        this.mym.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) d.this.myn.getItem(i);
                if (d.this.myo != null) {
                    d.this.myo.b(aVar);
                }
                if (d.this.mvw != null && d.this.mvw.dCj() != null) {
                    d.this.mvw.dCj().setFilter(aVar);
                }
            }
        });
    }

    public void setFilters(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.myn.setData(list);
        this.mym.setAdapter((ListAdapter) this.myn);
    }

    public com.baidu.tieba.video.editvideo.data.a RQ(String str) {
        for (com.baidu.tieba.video.editvideo.data.a aVar : this.myn.getData()) {
            if (aVar != null && at.equals(aVar.value, str)) {
                return aVar;
            }
        }
        return null;
    }

    public void d(com.baidu.tieba.video.editvideo.data.a aVar) {
        this.myn.a(aVar);
    }

    public void dq(View view) {
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void wE(boolean z) {
    }

    public void onPause() {
    }

    public void onResume() {
    }
}
