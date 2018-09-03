package com.baidu.tieba.video.editvideo.view;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.f;
import java.util.List;
/* loaded from: classes2.dex */
public class c extends com.baidu.adp.base.c {
    private a hdm;
    private HorizontalListView hgf;
    private com.baidu.tieba.video.editvideo.a.b hgg;
    private com.baidu.tieba.video.editvideo.b.a hgh;
    private Resources mResources;
    private View mRootView;

    public c(e eVar, a aVar) {
        super(eVar);
        this.hdm = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(f.h.edit_filter_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.hgh = aVar;
    }

    private void initView() {
        this.hgf = (HorizontalListView) this.mRootView.findViewById(f.g.edit_filter_horizontal_list);
        this.hgg = new com.baidu.tieba.video.editvideo.a.b();
        dH(com.baidu.tieba.video.editvideo.b.a.cl(this.mRootView.getContext()));
        this.hgf.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) c.this.hgg.getItem(i);
                if (c.this.hgh != null) {
                    c.this.hgh.a(aVar);
                }
                if (c.this.hdm != null && c.this.hdm.bBx() != null) {
                    c.this.hdm.bBx().setFilter(aVar);
                }
            }
        });
    }

    public void dH(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.hgg.setData(list);
        this.hgf.setAdapter((ListAdapter) this.hgg);
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
