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
    private a hBp;
    private HorizontalListView hEg;
    private com.baidu.tieba.video.editvideo.a.b hEh;
    private com.baidu.tieba.video.editvideo.b.a hEi;
    private Resources mResources;
    private View mRootView;

    public c(e eVar, a aVar) {
        super(eVar);
        this.hBp = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(e.h.edit_filter_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.hEi = aVar;
    }

    private void initView() {
        this.hEg = (HorizontalListView) this.mRootView.findViewById(e.g.edit_filter_horizontal_list);
        this.hEh = new com.baidu.tieba.video.editvideo.a.b();
        dY(com.baidu.tieba.video.editvideo.b.a.dd(this.mRootView.getContext()));
        this.hEg.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) c.this.hEh.getItem(i);
                if (c.this.hEi != null) {
                    c.this.hEi.a(aVar);
                }
                if (c.this.hBp != null && c.this.hBp.bJe() != null) {
                    c.this.hBp.bJe().setFilter(aVar);
                }
            }
        });
    }

    public void dY(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.hEh.setData(list);
        this.hEg.setAdapter((ListAdapter) this.hEh);
    }

    public void bU(View view) {
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void nX(boolean z) {
    }

    public void onPause() {
    }

    public void onResume() {
    }
}
