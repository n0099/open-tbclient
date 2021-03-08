package com.baidu.tieba.yuyinala.liveroom.f;

import android.view.View;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.yuyinala.liveroom.views.d;
/* loaded from: classes10.dex */
public class b {
    private TbPageContext mPageContext;
    private View mRootView;
    private com.baidu.tieba.yuyinala.liveroom.views.b owH;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        init();
    }

    private void init() {
        this.owH = new com.baidu.tieba.yuyinala.liveroom.views.b(this.mPageContext);
        this.mRootView = this.owH.getView();
    }

    public View getView() {
        return this.mRootView;
    }

    public boolean ceD() {
        return this.owH.ceD();
    }

    public boolean ceE() {
        return this.owH.ceE();
    }

    public String getLiveTitle() {
        return this.owH.getLiveTitle();
    }

    public boolean ceF() {
        return this.owH.ceF();
    }

    public boolean ceG() {
        return this.owH.ceG();
    }

    public String ceI() {
        return this.owH.ceI();
    }

    public void a(d.b bVar) {
        this.owH.a(bVar);
    }

    public void a(d.a aVar) {
        this.owH.a(aVar);
    }

    public void HR(String str) {
        this.owH.HR(str);
    }

    public void ceL() {
        if (this.owH != null) {
            this.owH.ceL();
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.owH != null) {
            this.owH.onKeyboardVisibilityChanged(z);
        }
    }
}
