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
    private a hud;
    private HorizontalListView hwU;
    private com.baidu.tieba.video.editvideo.a.b hwV;
    private com.baidu.tieba.video.editvideo.b.a hwW;
    private Resources mResources;
    private View mRootView;

    public c(e eVar, a aVar) {
        super(eVar);
        this.hud = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(e.h.edit_filter_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.hwW = aVar;
    }

    private void initView() {
        this.hwU = (HorizontalListView) this.mRootView.findViewById(e.g.edit_filter_horizontal_list);
        this.hwV = new com.baidu.tieba.video.editvideo.a.b();
        dU(com.baidu.tieba.video.editvideo.b.a.cZ(this.mRootView.getContext()));
        this.hwU.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) c.this.hwV.getItem(i);
                if (c.this.hwW != null) {
                    c.this.hwW.a(aVar);
                }
                if (c.this.hud != null && c.this.hud.bGZ() != null) {
                    c.this.hud.bGZ().setFilter(aVar);
                }
            }
        });
    }

    public void dU(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.hwV.setData(list);
        this.hwU.setAdapter((ListAdapter) this.hwV);
    }

    public void bU(View view) {
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void nV(boolean z) {
    }

    public void onPause() {
    }

    public void onResume() {
    }
}
