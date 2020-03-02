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
    private a kwo;
    private HorizontalListView kyT;
    private com.baidu.tieba.video.editvideo.a.b kyU;
    private com.baidu.tieba.video.editvideo.b.a kyV;
    private Resources mResources;
    private View mRootView;

    public c(e eVar, a aVar) {
        super(eVar);
        this.kwo = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_filter_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.kyV = aVar;
    }

    private void initView() {
        this.kyT = (HorizontalListView) this.mRootView.findViewById(R.id.edit_filter_horizontal_list);
        this.kyU = new com.baidu.tieba.video.editvideo.a.b();
        setFilters(com.baidu.tieba.video.editvideo.b.a.fz(this.mRootView.getContext()));
        this.kyT.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) c.this.kyU.getItem(i);
                if (c.this.kyV != null) {
                    c.this.kyV.a(aVar);
                }
                if (c.this.kwo != null && c.this.kwo.cQo() != null) {
                    c.this.kwo.cQo().setFilter(aVar);
                }
            }
        });
    }

    public void setFilters(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.kyU.setData(list);
        this.kyT.setAdapter((ListAdapter) this.kyU);
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
