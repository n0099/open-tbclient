package com.baidu.tieba.yuyinala.liveroom.f;

import android.view.View;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.yuyinala.liveroom.views.d;
/* loaded from: classes4.dex */
public class b {
    private TbPageContext mPageContext;
    private View mRootView;
    private com.baidu.tieba.yuyinala.liveroom.views.b olT;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        init();
    }

    private void init() {
        this.olT = new com.baidu.tieba.yuyinala.liveroom.views.b(this.mPageContext);
        this.mRootView = this.olT.getView();
    }

    public View getView() {
        return this.mRootView;
    }

    public boolean cew() {
        return this.olT.cew();
    }

    public boolean cex() {
        return this.olT.cex();
    }

    public String getLiveTitle() {
        return this.olT.getLiveTitle();
    }

    public boolean cey() {
        return this.olT.cey();
    }

    public boolean cez() {
        return this.olT.cez();
    }

    public String ceB() {
        return this.olT.ceB();
    }

    public void a(d.b bVar) {
        this.olT.a(bVar);
    }

    public void a(d.a aVar) {
        this.olT.a(aVar);
    }

    public void In(String str) {
        this.olT.In(str);
    }

    public void ceE() {
        if (this.olT != null) {
            this.olT.ceE();
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.olT != null) {
            this.olT.onKeyboardVisibilityChanged(z);
        }
    }
}
