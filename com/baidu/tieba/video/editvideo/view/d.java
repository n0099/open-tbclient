package com.baidu.tieba.video.editvideo.view;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.base.f;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes8.dex */
public class d extends com.baidu.adp.base.d {
    private Resources mResources;
    private View mRootView;
    private a nGK;
    private HorizontalListView nJv;
    private com.baidu.tieba.video.editvideo.a.b nJw;
    private com.baidu.tieba.video.editvideo.b.a nJx;

    public d(f fVar, a aVar) {
        super(fVar);
        this.nGK = aVar;
        this.mRootView = LayoutInflater.from(fVar.getPageActivity()).inflate(R.layout.edit_filter_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.nJx = aVar;
    }

    private void initView() {
        this.nJv = (HorizontalListView) this.mRootView.findViewById(R.id.edit_filter_horizontal_list);
        this.nJw = new com.baidu.tieba.video.editvideo.a.b();
        setFilters(com.baidu.tieba.video.editvideo.b.a.gZ(this.mRootView.getContext()));
        this.nJv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) d.this.nJw.getItem(i);
                if (d.this.nJx != null) {
                    d.this.nJx.b(aVar);
                }
                if (d.this.nGK != null && d.this.nGK.dUK() != null) {
                    d.this.nGK.dUK().setFilter(aVar);
                }
            }
        });
    }

    public void setFilters(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.nJw.setData(list);
        this.nJv.setAdapter((ListAdapter) this.nJw);
    }

    public com.baidu.tieba.video.editvideo.data.a UB(String str) {
        for (com.baidu.tieba.video.editvideo.data.a aVar : this.nJw.getData()) {
            if (aVar != null && at.equals(aVar.value, str)) {
                return aVar;
            }
        }
        return null;
    }

    public void d(com.baidu.tieba.video.editvideo.data.a aVar) {
        this.nJw.a(aVar);
    }

    public void eo(View view) {
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void yJ(boolean z) {
    }

    public void onPause() {
    }

    public void onResume() {
    }
}
