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
    private HorizontalListView jBw;
    private com.baidu.tieba.video.editvideo.a.b jBx;
    private com.baidu.tieba.video.editvideo.b.a jBy;
    private a jyK;
    private Resources mResources;
    private View mRootView;

    public c(e eVar, a aVar) {
        super(eVar);
        this.jyK = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_filter_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.jBy = aVar;
    }

    private void initView() {
        this.jBw = (HorizontalListView) this.mRootView.findViewById(R.id.edit_filter_horizontal_list);
        this.jBx = new com.baidu.tieba.video.editvideo.a.b();
        ep(com.baidu.tieba.video.editvideo.b.a.er(this.mRootView.getContext()));
        this.jBw.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) c.this.jBx.getItem(i);
                if (c.this.jBy != null) {
                    c.this.jBy.a(aVar);
                }
                if (c.this.jyK != null && c.this.jyK.cwb() != null) {
                    c.this.jyK.cwb().setFilter(aVar);
                }
            }
        });
    }

    public void ep(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.jBx.setData(list);
        this.jBw.setAdapter((ListAdapter) this.jBx);
    }

    public void cX(View view) {
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void rI(boolean z) {
    }

    public void onPause() {
    }

    public void onResume() {
    }
}
