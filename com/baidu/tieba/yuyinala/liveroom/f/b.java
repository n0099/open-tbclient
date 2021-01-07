package com.baidu.tieba.yuyinala.liveroom.f;

import android.view.View;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.yuyinala.liveroom.views.d;
/* loaded from: classes11.dex */
public class b {
    private TbPageContext mPageContext;
    private View mRootView;
    private com.baidu.tieba.yuyinala.liveroom.views.b ooO;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        init();
    }

    private void init() {
        this.ooO = new com.baidu.tieba.yuyinala.liveroom.views.b(this.mPageContext);
        this.mRootView = this.ooO.getView();
    }

    public View getView() {
        return this.mRootView;
    }

    public boolean chn() {
        return this.ooO.chn();
    }

    public boolean cho() {
        return this.ooO.cho();
    }

    public String getLiveTitle() {
        return this.ooO.getLiveTitle();
    }

    public boolean chp() {
        return this.ooO.chp();
    }

    public boolean chq() {
        return this.ooO.chq();
    }

    public String chs() {
        return this.ooO.chs();
    }

    public void a(d.b bVar) {
        this.ooO.a(bVar);
    }

    public void a(d.a aVar) {
        this.ooO.a(aVar);
    }

    public void Io(String str) {
        this.ooO.Io(str);
    }

    public void chv() {
        if (this.ooO != null) {
            this.ooO.chv();
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.ooO != null) {
            this.ooO.onKeyboardVisibilityChanged(z);
        }
    }
}
