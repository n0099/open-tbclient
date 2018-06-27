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
    private a hbY;
    private HorizontalListView heP;
    private com.baidu.tieba.video.editvideo.a.b heQ;
    private com.baidu.tieba.video.editvideo.b.a heR;
    private Resources mResources;
    private View mRootView;

    public c(e eVar, a aVar) {
        super(eVar);
        this.hbY = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.i.edit_filter_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.heR = aVar;
    }

    private void initView() {
        this.heP = (HorizontalListView) this.mRootView.findViewById(d.g.edit_filter_horizontal_list);
        this.heQ = new com.baidu.tieba.video.editvideo.a.b();
        dL(com.baidu.tieba.video.editvideo.b.a.cl(this.mRootView.getContext()));
        this.heP.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) c.this.heQ.getItem(i);
                if (c.this.heR != null) {
                    c.this.heR.a(aVar);
                }
                if (c.this.hbY != null && c.this.hbY.bCK() != null) {
                    c.this.hbY.bCK().setFilter(aVar);
                }
            }
        });
    }

    public void dL(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.heQ.setData(list);
        this.heP.setAdapter((ListAdapter) this.heQ);
    }

    public void bC(View view) {
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void nh(boolean z) {
    }

    public void onPause() {
    }

    public void onResume() {
    }
}
