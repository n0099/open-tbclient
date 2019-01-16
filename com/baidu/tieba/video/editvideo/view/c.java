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
    private a hFH;
    private com.baidu.tieba.video.editvideo.b.a hIA;
    private HorizontalListView hIy;
    private com.baidu.tieba.video.editvideo.a.b hIz;
    private Resources mResources;
    private View mRootView;

    public c(e eVar, a aVar) {
        super(eVar);
        this.hFH = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(e.h.edit_filter_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.hIA = aVar;
    }

    private void initView() {
        this.hIy = (HorizontalListView) this.mRootView.findViewById(e.g.edit_filter_horizontal_list);
        this.hIz = new com.baidu.tieba.video.editvideo.a.b();
        ea(com.baidu.tieba.video.editvideo.b.a.dd(this.mRootView.getContext()));
        this.hIy.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) c.this.hIz.getItem(i);
                if (c.this.hIA != null) {
                    c.this.hIA.a(aVar);
                }
                if (c.this.hFH != null && c.this.hFH.bKC() != null) {
                    c.this.hFH.bKC().setFilter(aVar);
                }
            }
        });
    }

    public void ea(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.hIz.setData(list);
        this.hIy.setAdapter((ListAdapter) this.hIz);
    }

    public void bX(View view) {
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void ob(boolean z) {
    }

    public void onPause() {
    }

    public void onResume() {
    }
}
