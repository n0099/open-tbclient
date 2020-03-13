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
/* loaded from: classes10.dex */
public class c extends com.baidu.adp.base.c {
    private a kwA;
    private HorizontalListView kzf;
    private com.baidu.tieba.video.editvideo.a.b kzg;
    private com.baidu.tieba.video.editvideo.b.a kzh;
    private Resources mResources;
    private View mRootView;

    public c(e eVar, a aVar) {
        super(eVar);
        this.kwA = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_filter_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.kzh = aVar;
    }

    private void initView() {
        this.kzf = (HorizontalListView) this.mRootView.findViewById(R.id.edit_filter_horizontal_list);
        this.kzg = new com.baidu.tieba.video.editvideo.a.b();
        setFilters(com.baidu.tieba.video.editvideo.b.a.fz(this.mRootView.getContext()));
        this.kzf.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) c.this.kzg.getItem(i);
                if (c.this.kzh != null) {
                    c.this.kzh.a(aVar);
                }
                if (c.this.kwA != null && c.this.kwA.cQp() != null) {
                    c.this.kwA.cQp().setFilter(aVar);
                }
            }
        });
    }

    public void setFilters(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.kzg.setData(list);
        this.kzf.setAdapter((ListAdapter) this.kzg);
    }

    public void cW(View view) {
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void to(boolean z) {
    }

    public void onPause() {
    }

    public void onResume() {
    }
}
