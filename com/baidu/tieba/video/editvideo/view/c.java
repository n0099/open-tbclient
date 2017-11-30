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
    private Resources fXC;
    private a gOv;
    private HorizontalListView gRm;
    private com.baidu.tieba.video.editvideo.a.b gRn;
    private com.baidu.tieba.video.editvideo.b.a gRo;
    private View mRootView;

    public c(e eVar, a aVar) {
        super(eVar);
        this.gOv = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.h.edit_filter_layout, (ViewGroup) null);
        this.fXC = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.gRo = aVar;
    }

    private void initView() {
        this.gRm = (HorizontalListView) this.mRootView.findViewById(d.g.edit_filter_horizontal_list);
        this.gRn = new com.baidu.tieba.video.editvideo.a.b();
        dP(com.baidu.tieba.video.editvideo.b.a.ch(this.mRootView.getContext()));
        this.gRm.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) c.this.gRn.getItem(i);
                if (c.this.gRo != null) {
                    c.this.gRo.a(aVar);
                }
                if (c.this.gOv != null && c.this.gOv.bBL() != null) {
                    c.this.gOv.bBL().setFilter(aVar);
                }
            }
        });
    }

    public void dP(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.gRn.setData(list);
        this.gRm.setAdapter((ListAdapter) this.gRn);
    }

    public void bI(View view) {
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void nD(boolean z) {
    }

    public void onPause() {
    }

    public void onResume() {
    }
}
