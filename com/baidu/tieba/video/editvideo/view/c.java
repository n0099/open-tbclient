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
    private HorizontalListView hBe;
    private com.baidu.tieba.video.editvideo.a.b hBf;
    private com.baidu.tieba.video.editvideo.b.a hBg;
    private a hyk;
    private Resources mResources;
    private View mRootView;

    public c(e eVar, a aVar) {
        super(eVar);
        this.hyk = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.h.edit_filter_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.hBg = aVar;
    }

    private void initView() {
        this.hBe = (HorizontalListView) this.mRootView.findViewById(d.g.edit_filter_horizontal_list);
        this.hBf = new com.baidu.tieba.video.editvideo.a.b();
        dU(com.baidu.tieba.video.editvideo.b.a.cr(this.mRootView.getContext()));
        this.hBe.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) c.this.hBf.getItem(i);
                if (c.this.hBg != null) {
                    c.this.hBg.a(aVar);
                }
                if (c.this.hyk != null && c.this.hyk.bHO() != null) {
                    c.this.hyk.bHO().setFilter(aVar);
                }
            }
        });
    }

    public void dU(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.hBf.setData(list);
        this.hBe.setAdapter((ListAdapter) this.hBf);
    }

    public void cX(View view) {
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void nZ(boolean z) {
    }

    public void onPause() {
    }

    public void onResume() {
    }
}
