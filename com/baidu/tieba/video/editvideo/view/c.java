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
    private a liu;
    private HorizontalListView llf;
    private com.baidu.tieba.video.editvideo.a.b llg;
    private com.baidu.tieba.video.editvideo.b.a llh;
    private Resources mResources;
    private View mRootView;

    public c(e eVar, a aVar) {
        super(eVar);
        this.liu = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_filter_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.llh = aVar;
    }

    private void initView() {
        this.llf = (HorizontalListView) this.mRootView.findViewById(R.id.edit_filter_horizontal_list);
        this.llg = new com.baidu.tieba.video.editvideo.a.b();
        setFilters(com.baidu.tieba.video.editvideo.b.a.fq(this.mRootView.getContext()));
        this.llf.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) c.this.llg.getItem(i);
                if (c.this.llh != null) {
                    c.this.llh.a(aVar);
                }
                if (c.this.liu != null && c.this.liu.dbG() != null) {
                    c.this.liu.dbG().setFilter(aVar);
                }
            }
        });
    }

    public void setFilters(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.llg.setData(list);
        this.llf.setAdapter((ListAdapter) this.llg);
    }

    public void de(View view) {
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void uv(boolean z) {
    }

    public void onPause() {
    }

    public void onResume() {
    }
}
