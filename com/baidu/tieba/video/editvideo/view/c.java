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
    private a jwo;
    private HorizontalListView jza;
    private com.baidu.tieba.video.editvideo.a.b jzb;
    private com.baidu.tieba.video.editvideo.b.a jzc;
    private Resources mResources;
    private View mRootView;

    public c(e eVar, a aVar) {
        super(eVar);
        this.jwo = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_filter_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.jzc = aVar;
    }

    private void initView() {
        this.jza = (HorizontalListView) this.mRootView.findViewById(R.id.edit_filter_horizontal_list);
        this.jzb = new com.baidu.tieba.video.editvideo.a.b();
        ep(com.baidu.tieba.video.editvideo.b.a.eq(this.mRootView.getContext()));
        this.jza.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) c.this.jzb.getItem(i);
                if (c.this.jzc != null) {
                    c.this.jzc.a(aVar);
                }
                if (c.this.jwo != null && c.this.jwo.cvn() != null) {
                    c.this.jwo.cvn().setFilter(aVar);
                }
            }
        });
    }

    public void ep(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.jzb.setData(list);
        this.jza.setAdapter((ListAdapter) this.jzb);
    }

    public void cX(View view) {
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void rF(boolean z) {
    }

    public void onPause() {
    }

    public void onResume() {
    }
}
