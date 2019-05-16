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
    private a joV;
    private HorizontalListView jrH;
    private com.baidu.tieba.video.editvideo.a.b jrI;
    private com.baidu.tieba.video.editvideo.b.a jrJ;
    private Resources mResources;
    private View mRootView;

    public c(e eVar, a aVar) {
        super(eVar);
        this.joV = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_filter_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.jrJ = aVar;
    }

    private void initView() {
        this.jrH = (HorizontalListView) this.mRootView.findViewById(R.id.edit_filter_horizontal_list);
        this.jrI = new com.baidu.tieba.video.editvideo.a.b();
        en(com.baidu.tieba.video.editvideo.b.a.eo(this.mRootView.getContext()));
        this.jrH.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) c.this.jrI.getItem(i);
                if (c.this.jrJ != null) {
                    c.this.jrJ.a(aVar);
                }
                if (c.this.joV != null && c.this.joV.csd() != null) {
                    c.this.joV.csd().setFilter(aVar);
                }
            }
        });
    }

    public void en(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.jrI.setData(list);
        this.jrH.setAdapter((ListAdapter) this.jrI);
    }

    public void cS(View view) {
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void rq(boolean z) {
    }

    public void onPause() {
    }

    public void onResume() {
    }
}
