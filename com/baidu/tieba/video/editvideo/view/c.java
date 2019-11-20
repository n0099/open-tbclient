package com.baidu.tieba.video.editvideo.view;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes5.dex */
public class c extends com.baidu.adp.base.c {
    private HorizontalListView jAx;
    private com.baidu.tieba.video.editvideo.a.b jAy;
    private com.baidu.tieba.video.editvideo.b.a jAz;
    private a jxL;
    private Resources mResources;
    private View mRootView;

    public c(e eVar, a aVar) {
        super(eVar);
        this.jxL = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_filter_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.jAz = aVar;
    }

    private void initView() {
        this.jAx = (HorizontalListView) this.mRootView.findViewById(R.id.edit_filter_horizontal_list);
        this.jAy = new com.baidu.tieba.video.editvideo.a.b();
        eC(com.baidu.tieba.video.editvideo.b.a.eg(this.mRootView.getContext()));
        this.jAx.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) c.this.jAy.getItem(i);
                if (c.this.jAz != null) {
                    c.this.jAz.a(aVar);
                }
                if (c.this.jxL != null && c.this.jxL.ctN() != null) {
                    c.this.jxL.ctN().setFilter(aVar);
                }
            }
        });
    }

    public void eC(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.jAy.setData(list);
        this.jAx.setAdapter((ListAdapter) this.jAy);
    }

    public void cT(View view) {
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void rr(boolean z) {
    }

    public void onPause() {
    }

    public void onResume() {
    }
}
