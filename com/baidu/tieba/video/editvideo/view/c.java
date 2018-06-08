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
    private a gXT;
    private HorizontalListView haK;
    private com.baidu.tieba.video.editvideo.a.b haL;
    private com.baidu.tieba.video.editvideo.b.a haM;
    private Resources mResources;
    private View mRootView;

    public c(e eVar, a aVar) {
        super(eVar);
        this.gXT = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.i.edit_filter_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.haM = aVar;
    }

    private void initView() {
        this.haK = (HorizontalListView) this.mRootView.findViewById(d.g.edit_filter_horizontal_list);
        this.haL = new com.baidu.tieba.video.editvideo.a.b();
        dI(com.baidu.tieba.video.editvideo.b.a.cn(this.mRootView.getContext()));
        this.haK.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) c.this.haL.getItem(i);
                if (c.this.haM != null) {
                    c.this.haM.a(aVar);
                }
                if (c.this.gXT != null && c.this.gXT.bCk() != null) {
                    c.this.gXT.bCk().setFilter(aVar);
                }
            }
        });
    }

    public void dI(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.haL.setData(list);
        this.haK.setAdapter((ListAdapter) this.haL);
    }

    public void bB(View view) {
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void mZ(boolean z) {
    }

    public void onPause() {
    }

    public void onResume() {
    }
}
