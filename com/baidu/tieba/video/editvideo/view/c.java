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
    private a iVY;
    private HorizontalListView iYM;
    private com.baidu.tieba.video.editvideo.a.b iYN;
    private com.baidu.tieba.video.editvideo.b.a iYO;
    private Resources mResources;
    private View mRootView;

    public c(e eVar, a aVar) {
        super(eVar);
        this.iVY = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.h.edit_filter_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.iYO = aVar;
    }

    private void initView() {
        this.iYM = (HorizontalListView) this.mRootView.findViewById(d.g.edit_filter_horizontal_list);
        this.iYN = new com.baidu.tieba.video.editvideo.a.b();
        ed(com.baidu.tieba.video.editvideo.b.a.ey(this.mRootView.getContext()));
        this.iYM.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) c.this.iYN.getItem(i);
                if (c.this.iYO != null) {
                    c.this.iYO.a(aVar);
                }
                if (c.this.iVY != null && c.this.iVY.cka() != null) {
                    c.this.iVY.cka().setFilter(aVar);
                }
            }
        });
    }

    public void ed(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.iYN.setData(list);
        this.iYM.setAdapter((ListAdapter) this.iYN);
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
