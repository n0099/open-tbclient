package com.baidu.tieba.yuyinala.liveroom.f;

import android.view.View;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.yuyinala.liveroom.views.d;
/* loaded from: classes10.dex */
public class b {
    private TbPageContext mPageContext;
    private View mRootView;
    private com.baidu.tieba.yuyinala.liveroom.views.b oki;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        init();
    }

    private void init() {
        this.oki = new com.baidu.tieba.yuyinala.liveroom.views.b(this.mPageContext);
        this.mRootView = this.oki.getView();
    }

    public View getView() {
        return this.mRootView;
    }

    public boolean cdv() {
        return this.oki.cdv();
    }

    public boolean cdw() {
        return this.oki.cdw();
    }

    public String getLiveTitle() {
        return this.oki.getLiveTitle();
    }

    public boolean cdx() {
        return this.oki.cdx();
    }

    public boolean cdy() {
        return this.oki.cdy();
    }

    public String cdA() {
        return this.oki.cdA();
    }

    public void a(d.b bVar) {
        this.oki.a(bVar);
    }

    public void a(d.a aVar) {
        this.oki.a(aVar);
    }

    public void Hd(String str) {
        this.oki.Hd(str);
    }

    public void cdD() {
        if (this.oki != null) {
            this.oki.cdD();
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.oki != null) {
            this.oki.onKeyboardVisibilityChanged(z);
        }
    }
}
