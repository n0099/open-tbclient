package com.baidu.tieba.yuyinala.liveroom.f;

import android.view.View;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.yuyinala.liveroom.views.d;
/* loaded from: classes10.dex */
public class b {
    private TbPageContext mPageContext;
    private View mRootView;
    private com.baidu.tieba.yuyinala.liveroom.views.b okj;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        init();
    }

    private void init() {
        this.okj = new com.baidu.tieba.yuyinala.liveroom.views.b(this.mPageContext);
        this.mRootView = this.okj.getView();
    }

    public View getView() {
        return this.mRootView;
    }

    public boolean cdv() {
        return this.okj.cdv();
    }

    public boolean cdw() {
        return this.okj.cdw();
    }

    public String getLiveTitle() {
        return this.okj.getLiveTitle();
    }

    public boolean cdx() {
        return this.okj.cdx();
    }

    public boolean cdy() {
        return this.okj.cdy();
    }

    public String cdA() {
        return this.okj.cdA();
    }

    public void a(d.b bVar) {
        this.okj.a(bVar);
    }

    public void a(d.a aVar) {
        this.okj.a(aVar);
    }

    public void Hd(String str) {
        this.okj.Hd(str);
    }

    public void cdD() {
        if (this.okj != null) {
            this.okj.cdD();
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.okj != null) {
            this.okj.onKeyboardVisibilityChanged(z);
        }
    }
}
