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
/* loaded from: classes7.dex */
public class c extends com.baidu.adp.base.c {
    private a krH;
    private HorizontalListView kuo;
    private com.baidu.tieba.video.editvideo.a.b kup;
    private com.baidu.tieba.video.editvideo.b.a kuq;
    private Resources mResources;
    private View mRootView;

    public c(e eVar, a aVar) {
        super(eVar);
        this.krH = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_filter_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        this.kuq = aVar;
    }

    private void initView() {
        this.kuo = (HorizontalListView) this.mRootView.findViewById(R.id.edit_filter_horizontal_list);
        this.kup = new com.baidu.tieba.video.editvideo.a.b();
        eu(com.baidu.tieba.video.editvideo.b.a.fy(this.mRootView.getContext()));
        this.kuo.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.video.editvideo.data.a aVar = (com.baidu.tieba.video.editvideo.data.a) c.this.kup.getItem(i);
                if (c.this.kuq != null) {
                    c.this.kuq.a(aVar);
                }
                if (c.this.krH != null && c.this.krH.cNO() != null) {
                    c.this.krH.cNO().setFilter(aVar);
                }
            }
        });
    }

    public void eu(List<com.baidu.tieba.video.editvideo.data.a> list) {
        this.kup.setData(list);
        this.kuo.setAdapter((ListAdapter) this.kup);
    }

    public void cO(View view) {
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void sY(boolean z) {
    }

    public void onPause() {
    }

    public void onResume() {
    }
}
