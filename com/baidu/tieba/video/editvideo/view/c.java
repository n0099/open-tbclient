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
    private a gLr;
    private HorizontalListView gOi;
    private com.baidu.tieba.video.editvideo.a.b gOj;
    private com.baidu.tieba.video.editvideo.b.a gOk;
    private Resources mResources;
    private View mRootView;

    public c(e eVar, a aVar) {
        super(eVar);
        this.gLr = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.i.edit_filter_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.gOk = aVar;
    }

    private void initView() {
        this.gOi = (HorizontalListView) this.mRootView.findViewById(d.g.edit_filter_horizontal_list);
        this.gOj = new com.baidu.tieba.video.editvideo.a.b();
        dA(com.baidu.tieba.video.editvideo.b.a.cc(this.mRootView.getContext()));
        this.gOi.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) c.this.gOj.getItem(i);
                if (c.this.gOk != null) {
                    c.this.gOk.a(aVar);
                }
                if (c.this.gLr != null && c.this.gLr.bxf() != null) {
                    c.this.gLr.bxf().setFilter(aVar);
                }
            }
        });
    }

    public void dA(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.gOj.setData(list);
        this.gOi.setAdapter((ListAdapter) this.gOj);
    }

    public void by(View view2) {
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void mS(boolean z) {
    }

    public void onPause() {
    }

    public void onResume() {
    }
}
