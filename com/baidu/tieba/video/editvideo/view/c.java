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
    private HorizontalListView kAM;
    private com.baidu.tieba.video.editvideo.a.b kAN;
    private com.baidu.tieba.video.editvideo.b.a kAO;
    private a kyf;
    private Resources mResources;
    private View mRootView;

    public c(e eVar, a aVar) {
        super(eVar);
        this.kyf = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_filter_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.kAO = aVar;
    }

    private void initView() {
        this.kAM = (HorizontalListView) this.mRootView.findViewById(R.id.edit_filter_horizontal_list);
        this.kAN = new com.baidu.tieba.video.editvideo.a.b();
        setFilters(com.baidu.tieba.video.editvideo.b.a.fy(this.mRootView.getContext()));
        this.kAM.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) c.this.kAN.getItem(i);
                if (c.this.kAO != null) {
                    c.this.kAO.a(aVar);
                }
                if (c.this.kyf != null && c.this.kyf.cQJ() != null) {
                    c.this.kyf.cQJ().setFilter(aVar);
                }
            }
        });
    }

    public void setFilters(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.kAN.setData(list);
        this.kAM.setAdapter((ListAdapter) this.kAN);
    }

    public void cW(View view) {
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void tu(boolean z) {
    }

    public void onPause() {
    }

    public void onResume() {
    }
}
