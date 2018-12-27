package com.baidu.tieba.video.editvideo.view;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes5.dex */
public class c extends com.baidu.adp.base.c {
    private a hEA;
    private HorizontalListView hHr;
    private com.baidu.tieba.video.editvideo.a.b hHs;
    private com.baidu.tieba.video.editvideo.b.a hHt;
    private Resources mResources;
    private View mRootView;

    public c(e eVar, a aVar) {
        super(eVar);
        this.hEA = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(e.h.edit_filter_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.hHt = aVar;
    }

    private void initView() {
        this.hHr = (HorizontalListView) this.mRootView.findViewById(e.g.edit_filter_horizontal_list);
        this.hHs = new com.baidu.tieba.video.editvideo.a.b();
        dZ(com.baidu.tieba.video.editvideo.b.a.dd(this.mRootView.getContext()));
        this.hHr.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) c.this.hHs.getItem(i);
                if (c.this.hHt != null) {
                    c.this.hHt.a(aVar);
                }
                if (c.this.hEA != null && c.this.hEA.bJT() != null) {
                    c.this.hEA.bJT().setFilter(aVar);
                }
            }
        });
    }

    public void dZ(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.hHs.setData(list);
        this.hHr.setAdapter((ListAdapter) this.hHs);
    }

    public void bX(View view) {
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void oa(boolean z) {
    }

    public void onPause() {
    }

    public void onResume() {
    }
}
