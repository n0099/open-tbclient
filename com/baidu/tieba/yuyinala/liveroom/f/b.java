package com.baidu.tieba.yuyinala.liveroom.f;

import android.view.View;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.yuyinala.liveroom.views.d;
/* loaded from: classes4.dex */
public class b {
    private TbPageContext mPageContext;
    private View mRootView;
    private com.baidu.tieba.yuyinala.liveroom.views.b nVq;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        init();
    }

    private void init() {
        this.nVq = new com.baidu.tieba.yuyinala.liveroom.views.b(this.mPageContext);
        this.mRootView = this.nVq.getView();
    }

    public View getView() {
        return this.mRootView;
    }

    public boolean cbh() {
        return this.nVq.cbh();
    }

    public boolean cbi() {
        return this.nVq.cbi();
    }

    public String getLiveTitle() {
        return this.nVq.getLiveTitle();
    }

    public boolean cbj() {
        return this.nVq.cbj();
    }

    public boolean cbk() {
        return this.nVq.cbk();
    }

    public String cbm() {
        return this.nVq.cbm();
    }

    public void a(d.b bVar) {
        this.nVq.a(bVar);
    }

    public void a(d.a aVar) {
        this.nVq.a(aVar);
    }

    public void HX(String str) {
        this.nVq.HX(str);
    }

    public void cbp() {
        if (this.nVq != null) {
            this.nVq.cbp();
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.nVq != null) {
            this.nVq.onKeyboardVisibilityChanged(z);
        }
    }
}
