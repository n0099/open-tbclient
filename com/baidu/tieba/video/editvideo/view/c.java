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
    private a hoh;
    private HorizontalListView hrb;
    private com.baidu.tieba.video.editvideo.a.b hrc;
    private com.baidu.tieba.video.editvideo.b.a hrd;
    private Resources mResources;
    private View mRootView;

    public c(e eVar, a aVar) {
        super(eVar);
        this.hoh = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.h.edit_filter_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.hrd = aVar;
    }

    private void initView() {
        this.hrb = (HorizontalListView) this.mRootView.findViewById(d.g.edit_filter_horizontal_list);
        this.hrc = new com.baidu.tieba.video.editvideo.a.b();
        dD(com.baidu.tieba.video.editvideo.b.a.ck(this.mRootView.getContext()));
        this.hrb.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) c.this.hrc.getItem(i);
                if (c.this.hrd != null) {
                    c.this.hrd.a(aVar);
                }
                if (c.this.hoh != null && c.this.hoh.bBn() != null) {
                    c.this.hoh.bBn().setFilter(aVar);
                }
            }
        });
    }

    public void dD(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.hrc.setData(list);
        this.hrb.setAdapter((ListAdapter) this.hrc);
    }

    public void cT(View view) {
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void nd(boolean z) {
    }

    public void onPause() {
    }

    public void onResume() {
    }
}
