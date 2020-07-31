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
    private a mdr;
    private HorizontalListView mgi;
    private com.baidu.tieba.video.editvideo.a.b mgj;
    private com.baidu.tieba.video.editvideo.b.a mgk;

    public d(com.baidu.adp.base.e eVar, a aVar) {
        super(eVar);
        this.mdr = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_filter_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.mgk = aVar;
    }

    private void initView() {
        this.mgi = (HorizontalListView) this.mRootView.findViewById(R.id.edit_filter_horizontal_list);
        this.mgj = new com.baidu.tieba.video.editvideo.a.b();
        setFilters(com.baidu.tieba.video.editvideo.b.a.fw(this.mRootView.getContext()));
        this.mgi.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) d.this.mgj.getItem(i);
                if (d.this.mgk != null) {
                    d.this.mgk.b(aVar);
                }
                if (d.this.mdr != null && d.this.mdr.dqE() != null) {
                    d.this.mdr.dqE().setFilter(aVar);
                }
            }
        });
    }

    public void setFilters(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.mgj.setData(list);
        this.mgi.setAdapter((ListAdapter) this.mgj);
    }

    public com.baidu.tieba.video.editvideo.data.a OS(String str) {
        for (com.baidu.tieba.video.editvideo.data.a aVar : this.mgj.getData()) {
            if (aVar != null && as.equals(aVar.value, str)) {
                return aVar;
            }
        }
        return null;
    }

    public void d(com.baidu.tieba.video.editvideo.data.a aVar) {
        this.mgj.a(aVar);
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
