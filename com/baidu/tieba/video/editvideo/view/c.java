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
    private a lCs;
    private HorizontalListView lFc;
    private com.baidu.tieba.video.editvideo.a.b lFd;
    private com.baidu.tieba.video.editvideo.b.a lFe;
    private Resources mResources;
    private View mRootView;

    public c(e eVar, a aVar) {
        super(eVar);
        this.lCs = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_filter_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.lFe = aVar;
    }

    private void initView() {
        this.lFc = (HorizontalListView) this.mRootView.findViewById(R.id.edit_filter_horizontal_list);
        this.lFd = new com.baidu.tieba.video.editvideo.a.b();
        setFilters(com.baidu.tieba.video.editvideo.b.a.ft(this.mRootView.getContext()));
        this.lFc.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) c.this.lFd.getItem(i);
                if (c.this.lFe != null) {
                    c.this.lFe.a(aVar);
                }
                if (c.this.lCs != null && c.this.lCs.djh() != null) {
                    c.this.lCs.djh().setFilter(aVar);
                }
            }
        });
    }

    public void setFilters(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.lFd.setData(list);
        this.lFc.setAdapter((ListAdapter) this.lFd);
    }

    public void df(View view) {
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void uT(boolean z) {
    }

    public void onPause() {
    }

    public void onResume() {
    }
}
