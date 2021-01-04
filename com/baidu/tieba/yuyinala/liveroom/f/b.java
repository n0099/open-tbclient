package com.baidu.tieba.yuyinala.liveroom.f;

import android.view.View;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.yuyinala.liveroom.views.d;
/* loaded from: classes11.dex */
public class b {
    private TbPageContext mPageContext;
    private View mRootView;
    private com.baidu.tieba.yuyinala.liveroom.views.b ooP;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        init();
    }

    private void init() {
        this.ooP = new com.baidu.tieba.yuyinala.liveroom.views.b(this.mPageContext);
        this.mRootView = this.ooP.getView();
    }

    public View getView() {
        return this.mRootView;
    }

    public boolean chm() {
        return this.ooP.chm();
    }

    public boolean chn() {
        return this.ooP.chn();
    }

    public String getLiveTitle() {
        return this.ooP.getLiveTitle();
    }

    public boolean cho() {
        return this.ooP.cho();
    }

    public boolean chp() {
        return this.ooP.chp();
    }

    public String chr() {
        return this.ooP.chr();
    }

    public void a(d.b bVar) {
        this.ooP.a(bVar);
    }

    public void a(d.a aVar) {
        this.ooP.a(aVar);
    }

    public void Ip(String str) {
        this.ooP.Ip(str);
    }

    public void chu() {
        if (this.ooP != null) {
            this.ooP.chu();
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.ooP != null) {
            this.ooP.onKeyboardVisibilityChanged(z);
        }
    }
}
