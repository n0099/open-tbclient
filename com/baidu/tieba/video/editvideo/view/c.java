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
    private a iVX;
    private HorizontalListView iYL;
    private com.baidu.tieba.video.editvideo.a.b iYM;
    private com.baidu.tieba.video.editvideo.b.a iYN;
    private Resources mResources;
    private View mRootView;

    public c(e eVar, a aVar) {
        super(eVar);
        this.iVX = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.h.edit_filter_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.iYN = aVar;
    }

    private void initView() {
        this.iYL = (HorizontalListView) this.mRootView.findViewById(d.g.edit_filter_horizontal_list);
        this.iYM = new com.baidu.tieba.video.editvideo.a.b();
        ed(com.baidu.tieba.video.editvideo.b.a.ey(this.mRootView.getContext()));
        this.iYL.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) c.this.iYM.getItem(i);
                if (c.this.iYN != null) {
                    c.this.iYN.a(aVar);
                }
                if (c.this.iVX != null && c.this.iVX.cka() != null) {
                    c.this.iVX.cka().setFilter(aVar);
                }
            }
        });
    }

    public void ed(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.iYM.setData(list);
        this.iYL.setAdapter((ListAdapter) this.iYM);
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
