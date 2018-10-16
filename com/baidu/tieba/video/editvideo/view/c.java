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
    private a hst;
    private HorizontalListView hvk;
    private com.baidu.tieba.video.editvideo.a.b hvl;
    private com.baidu.tieba.video.editvideo.b.a hvm;
    private Resources mResources;
    private View mRootView;

    public c(e eVar, a aVar) {
        super(eVar);
        this.hst = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(e.h.edit_filter_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.hvm = aVar;
    }

    private void initView() {
        this.hvk = (HorizontalListView) this.mRootView.findViewById(e.g.edit_filter_horizontal_list);
        this.hvl = new com.baidu.tieba.video.editvideo.a.b();
        dW(com.baidu.tieba.video.editvideo.b.a.de(this.mRootView.getContext()));
        this.hvk.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) c.this.hvl.getItem(i);
                if (c.this.hvm != null) {
                    c.this.hvm.a(aVar);
                }
                if (c.this.hst != null && c.this.hst.bHA() != null) {
                    c.this.hst.bHA().setFilter(aVar);
                }
            }
        });
    }

    public void dW(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.hvl.setData(list);
        this.hvk.setAdapter((ListAdapter) this.hvl);
    }

    public void bS(View view) {
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void nH(boolean z) {
    }

    public void onPause() {
    }

    public void onResume() {
    }
}
