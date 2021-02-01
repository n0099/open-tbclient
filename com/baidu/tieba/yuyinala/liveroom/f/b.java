package com.baidu.tieba.yuyinala.liveroom.f;

import android.view.View;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.yuyinala.liveroom.views.d;
/* loaded from: classes11.dex */
public class b {
    private TbPageContext mPageContext;
    private View mRootView;
    private com.baidu.tieba.yuyinala.liveroom.views.b oub;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        init();
    }

    private void init() {
        this.oub = new com.baidu.tieba.yuyinala.liveroom.views.b(this.mPageContext);
        this.mRootView = this.oub.getView();
    }

    public View getView() {
        return this.mRootView;
    }

    public boolean ceq() {
        return this.oub.ceq();
    }

    public boolean cer() {
        return this.oub.cer();
    }

    public String getLiveTitle() {
        return this.oub.getLiveTitle();
    }

    public boolean ces() {
        return this.oub.ces();
    }

    public boolean cet() {
        return this.oub.cet();
    }

    public String cev() {
        return this.oub.cev();
    }

    public void a(d.b bVar) {
        this.oub.a(bVar);
    }

    public void a(d.a aVar) {
        this.oub.a(aVar);
    }

    public void HH(String str) {
        this.oub.HH(str);
    }

    public void cey() {
        if (this.oub != null) {
            this.oub.cey();
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.oub != null) {
            this.oub.onKeyboardVisibilityChanged(z);
        }
    }
}
