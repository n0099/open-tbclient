package com.baidu.tieba.yuyinala.liveroom.f;

import android.view.View;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.yuyinala.liveroom.views.d;
/* loaded from: classes4.dex */
public class b {
    private TbPageContext mPageContext;
    private View mRootView;
    private com.baidu.tieba.yuyinala.liveroom.views.b nWT;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        init();
    }

    private void init() {
        this.nWT = new com.baidu.tieba.yuyinala.liveroom.views.b(this.mPageContext);
        this.mRootView = this.nWT.getView();
    }

    public View getView() {
        return this.mRootView;
    }

    public boolean caA() {
        return this.nWT.caA();
    }

    public boolean caB() {
        return this.nWT.caB();
    }

    public String getLiveTitle() {
        return this.nWT.getLiveTitle();
    }

    public boolean caC() {
        return this.nWT.caC();
    }

    public boolean caD() {
        return this.nWT.caD();
    }

    public String caF() {
        return this.nWT.caF();
    }

    public void a(d.b bVar) {
        this.nWT.a(bVar);
    }

    public void a(d.a aVar) {
        this.nWT.a(aVar);
    }

    public void Hy(String str) {
        this.nWT.Hy(str);
    }

    public void caI() {
        if (this.nWT != null) {
            this.nWT.caI();
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.nWT != null) {
            this.nWT.onKeyboardVisibilityChanged(z);
        }
    }
}
