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
/* loaded from: classes8.dex */
public class c extends com.baidu.adp.base.c {
    private a kvp;
    private HorizontalListView kxW;
    private com.baidu.tieba.video.editvideo.a.b kxX;
    private com.baidu.tieba.video.editvideo.b.a kxY;
    private Resources mResources;
    private View mRootView;

    public c(e eVar, a aVar) {
        super(eVar);
        this.kvp = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_filter_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.kxY = aVar;
    }

    private void initView() {
        this.kxW = (HorizontalListView) this.mRootView.findViewById(R.id.edit_filter_horizontal_list);
        this.kxX = new com.baidu.tieba.video.editvideo.a.b();
        eu(com.baidu.tieba.video.editvideo.b.a.fz(this.mRootView.getContext()));
        this.kxW.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) c.this.kxX.getItem(i);
                if (c.this.kxY != null) {
                    c.this.kxY.a(aVar);
                }
                if (c.this.kvp != null && c.this.kvp.cOT() != null) {
                    c.this.kvp.cOT().setFilter(aVar);
                }
            }
        });
    }

    public void eu(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.kxX.setData(list);
        this.kxW.setAdapter((ListAdapter) this.kxX);
    }

    public void cU(View view) {
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void tk(boolean z) {
    }

    public void onPause() {
    }

    public void onResume() {
    }
}
