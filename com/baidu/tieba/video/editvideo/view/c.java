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
    private a jpa;
    private HorizontalListView jrL;
    private com.baidu.tieba.video.editvideo.a.b jrM;
    private com.baidu.tieba.video.editvideo.b.a jrN;
    private Resources mResources;
    private View mRootView;

    public c(e eVar, a aVar) {
        super(eVar);
        this.jpa = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_filter_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.jrN = aVar;
    }

    private void initView() {
        this.jrL = (HorizontalListView) this.mRootView.findViewById(R.id.edit_filter_horizontal_list);
        this.jrM = new com.baidu.tieba.video.editvideo.a.b();
        en(com.baidu.tieba.video.editvideo.b.a.eo(this.mRootView.getContext()));
        this.jrL.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) c.this.jrM.getItem(i);
                if (c.this.jrN != null) {
                    c.this.jrN.a(aVar);
                }
                if (c.this.jpa != null && c.this.jpa.cse() != null) {
                    c.this.jpa.cse().setFilter(aVar);
                }
            }
        });
    }

    public void en(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.jrM.setData(list);
        this.jrL.setAdapter((ListAdapter) this.jrM);
    }

    public void cS(View view) {
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
