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
    private a gMr;
    private HorizontalListView gPi;
    private com.baidu.tieba.video.editvideo.a.b gPj;
    private com.baidu.tieba.video.editvideo.b.a gPk;
    private Resources mResources;
    private View mRootView;

    public c(e eVar, a aVar) {
        super(eVar);
        this.gMr = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.i.edit_filter_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.gPk = aVar;
    }

    private void initView() {
        this.gPi = (HorizontalListView) this.mRootView.findViewById(d.g.edit_filter_horizontal_list);
        this.gPj = new com.baidu.tieba.video.editvideo.a.b();
        dD(com.baidu.tieba.video.editvideo.b.a.cc(this.mRootView.getContext()));
        this.gPi.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) c.this.gPj.getItem(i);
                if (c.this.gPk != null) {
                    c.this.gPk.a(aVar);
                }
                if (c.this.gMr != null && c.this.gMr.bxd() != null) {
                    c.this.gMr.bxd().setFilter(aVar);
                }
            }
        });
    }

    public void dD(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.gPj.setData(list);
        this.gPi.setAdapter((ListAdapter) this.gPj);
    }

    public void by(View view2) {
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void mT(boolean z) {
    }

    public void onPause() {
    }

    public void onResume() {
    }
}
