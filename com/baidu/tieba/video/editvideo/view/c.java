package com.baidu.tieba.video.editvideo.view;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes2.dex */
public class c extends com.baidu.adp.base.c {
    private a hpH;
    private HorizontalListView hsC;
    private com.baidu.tieba.video.editvideo.a.b hsD;
    private com.baidu.tieba.video.editvideo.b.a hsE;
    private Resources mResources;
    private View mRootView;

    public c(e eVar, a aVar) {
        super(eVar);
        this.hpH = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.h.edit_filter_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.hsE = aVar;
    }

    private void initView() {
        this.hsC = (HorizontalListView) this.mRootView.findViewById(d.g.edit_filter_horizontal_list);
        this.hsD = new com.baidu.tieba.video.editvideo.a.b();
        dJ(com.baidu.tieba.video.editvideo.b.a.cn(this.mRootView.getContext()));
        this.hsC.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) c.this.hsD.getItem(i);
                if (c.this.hsE != null) {
                    c.this.hsE.a(aVar);
                }
                if (c.this.hpH != null && c.this.hpH.bCa() != null) {
                    c.this.hpH.bCa().setFilter(aVar);
                }
            }
        });
    }

    public void dJ(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.hsD.setData(list);
        this.hsC.setAdapter((ListAdapter) this.hsD);
    }

    public void cS(View view) {
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void nq(boolean z) {
    }

    public void onPause() {
    }

    public void onResume() {
    }
}
