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
    private a hpj;
    private HorizontalListView hsd;
    private com.baidu.tieba.video.editvideo.a.b hse;
    private com.baidu.tieba.video.editvideo.b.a hsf;
    private Resources mResources;
    private View mRootView;

    public c(e eVar, a aVar) {
        super(eVar);
        this.hpj = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.h.edit_filter_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.hsf = aVar;
    }

    private void initView() {
        this.hsd = (HorizontalListView) this.mRootView.findViewById(d.g.edit_filter_horizontal_list);
        this.hse = new com.baidu.tieba.video.editvideo.a.b();
        dJ(com.baidu.tieba.video.editvideo.b.a.cn(this.mRootView.getContext()));
        this.hsd.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) c.this.hse.getItem(i);
                if (c.this.hsf != null) {
                    c.this.hsf.a(aVar);
                }
                if (c.this.hpj != null && c.this.hpj.bBV() != null) {
                    c.this.hpj.bBV().setFilter(aVar);
                }
            }
        });
    }

    public void dJ(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.hse.setData(list);
        this.hsd.setAdapter((ListAdapter) this.hse);
    }

    public void cS(View view) {
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void nl(boolean z) {
    }

    public void onPause() {
    }

    public void onResume() {
    }
}
