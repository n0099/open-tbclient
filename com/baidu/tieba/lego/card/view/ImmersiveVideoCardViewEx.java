package com.baidu.tieba.lego.card.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.ImmersiveVideoCardEx;
/* loaded from: classes9.dex */
public class ImmersiveVideoCardViewEx extends BaseCardView<ImmersiveVideoCardEx> implements com.baidu.tieba.play.d, com.baidu.tieba.play.e {
    private o led;
    private a lee;
    private ViewGroup mRootView;

    public ImmersiveVideoCardViewEx(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View dbV() {
        this.mRootView = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.card_item_video_thread, (ViewGroup) null);
        this.led = new o(this.eUY, this.mRootView.findViewById(R.id.layout_video_container));
        this.lee = new a(this.eUY, this.mRootView);
        this.led.d(this.lee);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(ImmersiveVideoCardEx immersiveVideoCardEx, int i) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(ImmersiveVideoCardEx immersiveVideoCardEx) {
        if (immersiveVideoCardEx.getVideoInfo() != null) {
            this.led.fK(immersiveVideoCardEx.getShowExtra(), LogConfig.KEY_FEED);
            this.led.a(immersiveVideoCardEx.getVideoInfo(), immersiveVideoCardEx.getPage());
            boolean z = immersiveVideoCardEx.getVideoInfo().lcg;
            this.led.tL(z);
            this.led.tJ(z);
            this.lee.tJ(z);
            setTag(this);
            dcg();
        }
    }

    @Override // com.baidu.tieba.play.d
    public void dce() {
        if (this.lee != null) {
            this.lee.dce();
        }
    }

    @Override // com.baidu.tieba.play.d
    public void cpW() {
        if (this.lee != null) {
            this.lee.cpW();
        }
    }

    @Override // com.baidu.tieba.play.d
    public void dcf() {
        if (this.lee != null) {
            this.lee.dcf();
        }
    }

    public void dcg() {
        if (this.lee != null) {
            this.lee.dcg();
        }
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        return this.led != null && this.led.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        return this.led != null && this.led.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.led != null) {
            this.led.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.led != null) {
            this.led.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.led != null) {
            return this.led.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.led != null) {
            return this.led.getPlayUrl();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.led != null) {
            return this.led.getCurrentPosition();
        }
        return 0;
    }
}
