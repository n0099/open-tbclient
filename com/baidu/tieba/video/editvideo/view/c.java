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
/* loaded from: classes2.dex */
public class c extends com.baidu.adp.base.c {
    private a hle;
    private HorizontalListView hnV;
    private com.baidu.tieba.video.editvideo.a.b hnW;
    private com.baidu.tieba.video.editvideo.b.a hnX;
    private Resources mResources;
    private View mRootView;

    public c(e eVar, a aVar) {
        super(eVar);
        this.hle = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(e.h.edit_filter_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.hnX = aVar;
    }

    private void initView() {
        this.hnV = (HorizontalListView) this.mRootView.findViewById(e.g.edit_filter_horizontal_list);
        this.hnW = new com.baidu.tieba.video.editvideo.a.b();
        dI(com.baidu.tieba.video.editvideo.b.a.cS(this.mRootView.getContext()));
        this.hnV.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) c.this.hnW.getItem(i);
                if (c.this.hnX != null) {
                    c.this.hnX.a(aVar);
                }
                if (c.this.hle != null && c.this.hle.bEm() != null) {
                    c.this.hle.bEm().setFilter(aVar);
                }
            }
        });
    }

    public void dI(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.hnW.setData(list);
        this.hnV.setAdapter((ListAdapter) this.hnW);
    }

    public void bS(View view) {
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
