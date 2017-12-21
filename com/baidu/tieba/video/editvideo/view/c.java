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
    private a gRi;
    private HorizontalListView gUa;
    private com.baidu.tieba.video.editvideo.a.b gUb;
    private com.baidu.tieba.video.editvideo.b.a gUc;
    private Resources gan;
    private View mRootView;

    public c(e eVar, a aVar) {
        super(eVar);
        this.gRi = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.h.edit_filter_layout, (ViewGroup) null);
        this.gan = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.gUc = aVar;
    }

    private void initView() {
        this.gUa = (HorizontalListView) this.mRootView.findViewById(d.g.edit_filter_horizontal_list);
        this.gUb = new com.baidu.tieba.video.editvideo.a.b();
        dO(com.baidu.tieba.video.editvideo.b.a.cg(this.mRootView.getContext()));
        this.gUa.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) c.this.gUb.getItem(i);
                if (c.this.gUc != null) {
                    c.this.gUc.a(aVar);
                }
                if (c.this.gRi != null && c.this.gRi.bCr() != null) {
                    c.this.gRi.bCr().setFilter(aVar);
                }
            }
        });
    }

    public void dO(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.gUb.setData(list);
        this.gUa.setAdapter((ListAdapter) this.gUb);
    }

    public void bM(View view) {
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void nF(boolean z) {
    }

    public void onPause() {
    }

    public void onResume() {
    }
}
