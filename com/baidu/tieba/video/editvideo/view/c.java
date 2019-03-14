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
/* loaded from: classes5.dex */
public class c extends com.baidu.adp.base.c {
    private a iWj;
    private HorizontalListView iYX;
    private com.baidu.tieba.video.editvideo.a.b iYY;
    private com.baidu.tieba.video.editvideo.b.a iYZ;
    private Resources mResources;
    private View mRootView;

    public c(e eVar, a aVar) {
        super(eVar);
        this.iWj = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.h.edit_filter_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.iYZ = aVar;
    }

    private void initView() {
        this.iYX = (HorizontalListView) this.mRootView.findViewById(d.g.edit_filter_horizontal_list);
        this.iYY = new com.baidu.tieba.video.editvideo.a.b();
        eg(com.baidu.tieba.video.editvideo.b.a.ey(this.mRootView.getContext()));
        this.iYX.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) c.this.iYY.getItem(i);
                if (c.this.iYZ != null) {
                    c.this.iYZ.a(aVar);
                }
                if (c.this.iWj != null && c.this.iWj.ckc() != null) {
                    c.this.iWj.ckc().setFilter(aVar);
                }
            }
        });
    }

    public void eg(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.iYY.setData(list);
        this.iYX.setAdapter((ListAdapter) this.iYY);
    }

    public void cK(View view) {
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void qB(boolean z) {
    }

    public void onPause() {
    }

    public void onResume() {
    }
}
