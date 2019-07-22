package com.baidu.tieba.video.editvideo.view;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes5.dex */
public class c extends com.baidu.adp.base.c {
    private a jvh;
    private HorizontalListView jxT;
    private com.baidu.tieba.video.editvideo.a.b jxU;
    private com.baidu.tieba.video.editvideo.b.a jxV;
    private Resources mResources;
    private View mRootView;

    public c(e eVar, a aVar) {
        super(eVar);
        this.jvh = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_filter_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.jxV = aVar;
    }

    private void initView() {
        this.jxT = (HorizontalListView) this.mRootView.findViewById(R.id.edit_filter_horizontal_list);
        this.jxU = new com.baidu.tieba.video.editvideo.a.b();
        eq(com.baidu.tieba.video.editvideo.b.a.ep(this.mRootView.getContext()));
        this.jxT.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) c.this.jxU.getItem(i);
                if (c.this.jxV != null) {
                    c.this.jxV.a(aVar);
                }
                if (c.this.jvh != null && c.this.jvh.cuR() != null) {
                    c.this.jvh.cuR().setFilter(aVar);
                }
            }
        });
    }

    public void eq(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.jxU.setData(list);
        this.jxT.setAdapter((ListAdapter) this.jxU);
    }

    public void cV(View view) {
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void rE(boolean z) {
    }

    public void onPause() {
    }

    public void onResume() {
    }
}
