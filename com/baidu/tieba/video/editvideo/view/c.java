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
    private a hdl;
    private HorizontalListView hge;
    private com.baidu.tieba.video.editvideo.a.b hgf;
    private com.baidu.tieba.video.editvideo.b.a hgg;
    private Resources mResources;
    private View mRootView;

    public c(e eVar, a aVar) {
        super(eVar);
        this.hdl = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.h.edit_filter_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.hgg = aVar;
    }

    private void initView() {
        this.hge = (HorizontalListView) this.mRootView.findViewById(d.g.edit_filter_horizontal_list);
        this.hgf = new com.baidu.tieba.video.editvideo.a.b();
        dH(com.baidu.tieba.video.editvideo.b.a.cm(this.mRootView.getContext()));
        this.hge.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) c.this.hgf.getItem(i);
                if (c.this.hgg != null) {
                    c.this.hgg.a(aVar);
                }
                if (c.this.hdl != null && c.this.hdl.bBv() != null) {
                    c.this.hdl.bBv().setFilter(aVar);
                }
            }
        });
    }

    public void dH(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.hgf.setData(list);
        this.hge.setAdapter((ListAdapter) this.hgf);
    }

    public void bF(View view) {
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
