package com.baidu.tieba.yuyinala.liveroom.f;

import android.view.View;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.yuyinala.liveroom.views.d;
/* loaded from: classes4.dex */
public class b {
    private TbPageContext mPageContext;
    private View mRootView;
    private com.baidu.tieba.yuyinala.liveroom.views.b olR;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        init();
    }

    private void init() {
        this.olR = new com.baidu.tieba.yuyinala.liveroom.views.b(this.mPageContext);
        this.mRootView = this.olR.getView();
    }

    public View getView() {
        return this.mRootView;
    }

    public boolean cev() {
        return this.olR.cev();
    }

    public boolean cew() {
        return this.olR.cew();
    }

    public String getLiveTitle() {
        return this.olR.getLiveTitle();
    }

    public boolean cex() {
        return this.olR.cex();
    }

    public boolean cey() {
        return this.olR.cey();
    }

    public String ceA() {
        return this.olR.ceA();
    }

    public void a(d.b bVar) {
        this.olR.a(bVar);
    }

    public void a(d.a aVar) {
        this.olR.a(aVar);
    }

    public void In(String str) {
        this.olR.In(str);
    }

    public void ceD() {
        if (this.olR != null) {
            this.olR.ceD();
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.olR != null) {
            this.olR.onKeyboardVisibilityChanged(z);
        }
    }
}
