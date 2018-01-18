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
    private a hnN;
    private HorizontalListView hqH;
    private com.baidu.tieba.video.editvideo.a.b hqI;
    private com.baidu.tieba.video.editvideo.b.a hqJ;
    private Resources mResources;
    private View mRootView;

    public c(e eVar, a aVar) {
        super(eVar);
        this.hnN = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.h.edit_filter_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.hqJ = aVar;
    }

    private void initView() {
        this.hqH = (HorizontalListView) this.mRootView.findViewById(d.g.edit_filter_horizontal_list);
        this.hqI = new com.baidu.tieba.video.editvideo.a.b();
        dD(com.baidu.tieba.video.editvideo.b.a.cn(this.mRootView.getContext()));
        this.hqH.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) c.this.hqI.getItem(i);
                if (c.this.hqJ != null) {
                    c.this.hqJ.a(aVar);
                }
                if (c.this.hnN != null && c.this.hnN.bBl() != null) {
                    c.this.hnN.bBl().setFilter(aVar);
                }
            }
        });
    }

    public void dD(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.hqI.setData(list);
        this.hqH.setAdapter((ListAdapter) this.hqI);
    }

    public void cT(View view) {
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void nb(boolean z) {
    }

    public void onPause() {
    }

    public void onResume() {
    }
}
