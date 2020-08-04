package com.baidu.tieba.video.editvideo.view;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes17.dex */
public class d extends com.baidu.adp.base.c {
    private Resources mResources;
    private View mRootView;
    private a mdt;
    private HorizontalListView mgk;
    private com.baidu.tieba.video.editvideo.a.b mgl;
    private com.baidu.tieba.video.editvideo.b.a mgm;

    public d(com.baidu.adp.base.e eVar, a aVar) {
        super(eVar);
        this.mdt = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_filter_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.mgm = aVar;
    }

    private void initView() {
        this.mgk = (HorizontalListView) this.mRootView.findViewById(R.id.edit_filter_horizontal_list);
        this.mgl = new com.baidu.tieba.video.editvideo.a.b();
        setFilters(com.baidu.tieba.video.editvideo.b.a.fw(this.mRootView.getContext()));
        this.mgk.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) d.this.mgl.getItem(i);
                if (d.this.mgm != null) {
                    d.this.mgm.b(aVar);
                }
                if (d.this.mdt != null && d.this.mdt.dqF() != null) {
                    d.this.mdt.dqF().setFilter(aVar);
                }
            }
        });
    }

    public void setFilters(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.mgl.setData(list);
        this.mgk.setAdapter((ListAdapter) this.mgl);
    }

    public com.baidu.tieba.video.editvideo.data.a OS(String str) {
        for (com.baidu.tieba.video.editvideo.data.a aVar : this.mgl.getData()) {
            if (aVar != null && as.equals(aVar.value, str)) {
                return aVar;
            }
        }
        return null;
    }

    public void d(com.baidu.tieba.video.editvideo.data.a aVar) {
        this.mgl.a(aVar);
    }

    public void dm(View view) {
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void vN(boolean z) {
    }

    public void onPause() {
    }

    public void onResume() {
    }
}
