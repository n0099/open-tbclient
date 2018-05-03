package com.baidu.tieba.video.editvideo.view;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes2.dex */
public class c extends com.baidu.adp.base.c {
    private a gLo;
    private HorizontalListView gOf;
    private com.baidu.tieba.video.editvideo.a.b gOg;
    private com.baidu.tieba.video.editvideo.b.a gOh;
    private Resources mResources;
    private View mRootView;

    public c(e eVar, a aVar) {
        super(eVar);
        this.gLo = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.i.edit_filter_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.gOh = aVar;
    }

    private void initView() {
        this.gOf = (HorizontalListView) this.mRootView.findViewById(d.g.edit_filter_horizontal_list);
        this.gOg = new com.baidu.tieba.video.editvideo.a.b();
        dA(com.baidu.tieba.video.editvideo.b.a.cc(this.mRootView.getContext()));
        this.gOf.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) c.this.gOg.getItem(i);
                if (c.this.gOh != null) {
                    c.this.gOh.a(aVar);
                }
                if (c.this.gLo != null && c.this.gLo.bxf() != null) {
                    c.this.gLo.bxf().setFilter(aVar);
                }
            }
        });
    }

    public void dA(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.gOg.setData(list);
        this.gOf.setAdapter((ListAdapter) this.gOg);
    }

    public void by(View view2) {
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void mS(boolean z) {
    }

    public void onPause() {
    }

    public void onResume() {
    }
}
