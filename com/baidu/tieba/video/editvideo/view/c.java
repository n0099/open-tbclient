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
    private a liy;
    private HorizontalListView llj;
    private com.baidu.tieba.video.editvideo.a.b llk;
    private com.baidu.tieba.video.editvideo.b.a lll;
    private Resources mResources;
    private View mRootView;

    public c(e eVar, a aVar) {
        super(eVar);
        this.liy = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_filter_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.lll = aVar;
    }

    private void initView() {
        this.llj = (HorizontalListView) this.mRootView.findViewById(R.id.edit_filter_horizontal_list);
        this.llk = new com.baidu.tieba.video.editvideo.a.b();
        setFilters(com.baidu.tieba.video.editvideo.b.a.fe(this.mRootView.getContext()));
        this.llj.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) c.this.llk.getItem(i);
                if (c.this.lll != null) {
                    c.this.lll.a(aVar);
                }
                if (c.this.liy != null && c.this.liy.dbD() != null) {
                    c.this.liy.dbD().setFilter(aVar);
                }
            }
        });
    }

    public void setFilters(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.llk.setData(list);
        this.llj.setAdapter((ListAdapter) this.llk);
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
