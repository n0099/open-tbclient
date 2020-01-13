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
    private a kvk;
    private HorizontalListView kxR;
    private com.baidu.tieba.video.editvideo.a.b kxS;
    private com.baidu.tieba.video.editvideo.b.a kxT;
    private Resources mResources;
    private View mRootView;

    public c(e eVar, a aVar) {
        super(eVar);
        this.kvk = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_filter_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.kxT = aVar;
    }

    private void initView() {
        this.kxR = (HorizontalListView) this.mRootView.findViewById(R.id.edit_filter_horizontal_list);
        this.kxS = new com.baidu.tieba.video.editvideo.a.b();
        eu(com.baidu.tieba.video.editvideo.b.a.fz(this.mRootView.getContext()));
        this.kxR.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) c.this.kxS.getItem(i);
                if (c.this.kxT != null) {
                    c.this.kxT.a(aVar);
                }
                if (c.this.kvk != null && c.this.kvk.cOR() != null) {
                    c.this.kvk.cOR().setFilter(aVar);
                }
            }
        });
    }

    public void eu(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.kxS.setData(list);
        this.kxR.setAdapter((ListAdapter) this.kxS);
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
