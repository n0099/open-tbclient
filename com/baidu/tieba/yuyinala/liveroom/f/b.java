package com.baidu.tieba.yuyinala.liveroom.f;

import android.view.View;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.yuyinala.liveroom.views.d;
/* loaded from: classes4.dex */
public class b {
    private TbPageContext mPageContext;
    private View mRootView;
    private com.baidu.tieba.yuyinala.liveroom.views.b nPi;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        init();
    }

    private void init() {
        this.nPi = new com.baidu.tieba.yuyinala.liveroom.views.b(this.mPageContext);
        this.mRootView = this.nPi.getView();
    }

    public View getView() {
        return this.mRootView;
    }

    public boolean bYF() {
        return this.nPi.bYF();
    }

    public boolean bYG() {
        return this.nPi.bYG();
    }

    public String getLiveTitle() {
        return this.nPi.getLiveTitle();
    }

    public boolean bYH() {
        return this.nPi.bYH();
    }

    public boolean bYI() {
        return this.nPi.bYI();
    }

    public String bYK() {
        return this.nPi.bYK();
    }

    public void a(d.b bVar) {
        this.nPi.a(bVar);
    }

    public void a(d.a aVar) {
        this.nPi.a(aVar);
    }

    public void HF(String str) {
        this.nPi.HF(str);
    }

    public void bYN() {
        if (this.nPi != null) {
            this.nPi.bYN();
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.nPi != null) {
            this.nPi.onKeyboardVisibilityChanged(z);
        }
    }
}
