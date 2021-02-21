package com.baidu.tieba.yuyinala.liveroom.f;

import android.view.View;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.yuyinala.liveroom.views.d;
/* loaded from: classes11.dex */
public class b {
    private TbPageContext mPageContext;
    private View mRootView;
    private com.baidu.tieba.yuyinala.liveroom.views.b ouC;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        init();
    }

    private void init() {
        this.ouC = new com.baidu.tieba.yuyinala.liveroom.views.b(this.mPageContext);
        this.mRootView = this.ouC.getView();
    }

    public View getView() {
        return this.mRootView;
    }

    public boolean cex() {
        return this.ouC.cex();
    }

    public boolean cey() {
        return this.ouC.cey();
    }

    public String getLiveTitle() {
        return this.ouC.getLiveTitle();
    }

    public boolean cez() {
        return this.ouC.cez();
    }

    public boolean ceA() {
        return this.ouC.ceA();
    }

    public String ceC() {
        return this.ouC.ceC();
    }

    public void a(d.b bVar) {
        this.ouC.a(bVar);
    }

    public void a(d.a aVar) {
        this.ouC.a(aVar);
    }

    public void HI(String str) {
        this.ouC.HI(str);
    }

    public void ceF() {
        if (this.ouC != null) {
            this.ouC.ceF();
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.ouC != null) {
            this.ouC.onKeyboardVisibilityChanged(z);
        }
    }
}
