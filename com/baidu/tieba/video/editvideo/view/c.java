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
    private a kwm;
    private HorizontalListView kyR;
    private com.baidu.tieba.video.editvideo.a.b kyS;
    private com.baidu.tieba.video.editvideo.b.a kyT;
    private Resources mResources;
    private View mRootView;

    public c(e eVar, a aVar) {
        super(eVar);
        this.kwm = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_filter_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.kyT = aVar;
    }

    private void initView() {
        this.kyR = (HorizontalListView) this.mRootView.findViewById(R.id.edit_filter_horizontal_list);
        this.kyS = new com.baidu.tieba.video.editvideo.a.b();
        setFilters(com.baidu.tieba.video.editvideo.b.a.fz(this.mRootView.getContext()));
        this.kyR.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) c.this.kyS.getItem(i);
                if (c.this.kyT != null) {
                    c.this.kyT.a(aVar);
                }
                if (c.this.kwm != null && c.this.kwm.cQm() != null) {
                    c.this.kwm.cQm().setFilter(aVar);
                }
            }
        });
    }

    public void setFilters(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.kyS.setData(list);
        this.kyR.setAdapter((ListAdapter) this.kyS);
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
