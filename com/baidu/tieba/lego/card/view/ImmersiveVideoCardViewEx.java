package com.baidu.tieba.lego.card.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.d;
import com.baidu.tieba.lego.card.model.ImmersiveVideoCardEx;
/* loaded from: classes2.dex */
public class ImmersiveVideoCardViewEx extends BaseCardView<ImmersiveVideoCardEx> implements com.baidu.tieba.play.e, com.baidu.tieba.play.f {
    private m gJe;
    private a gJf;
    private ViewGroup mRootView;

    public ImmersiveVideoCardViewEx(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bAd() {
        this.mRootView = (ViewGroup) LayoutInflater.from(getContext()).inflate(d.h.card_item_video_thread, (ViewGroup) null);
        this.gJe = new m(this.mContext, this.mRootView.findViewById(d.g.layout_video_container));
        this.gJf = new a(this.mContext, this.mRootView);
        this.gJe.d(this.gJf);
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
    public void e(ImmersiveVideoCardEx immersiveVideoCardEx) {
        if (immersiveVideoCardEx.getVideoInfo() != null) {
            this.gJe.dn(immersiveVideoCardEx.getShowExtra(), "feed");
            this.gJe.a(immersiveVideoCardEx.getVideoInfo(), immersiveVideoCardEx.getPage());
            boolean z = immersiveVideoCardEx.getVideoInfo().gHg;
            this.gJe.lb(z);
            this.gJe.ma(z);
            this.gJf.ma(z);
            setTag(this);
            bAq();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void bAn() {
        if (this.gJf != null) {
            this.gJf.bAn();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void bAo() {
        if (this.gJf != null) {
            this.gJf.bAo();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void bAp() {
        if (this.gJf != null) {
            this.gJf.bAp();
        }
    }

    public void bAq() {
        if (this.gJf != null) {
            this.gJf.bAq();
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.gJe != null && this.gJe.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        return this.gJe != null && this.gJe.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.gJe != null) {
            this.gJe.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.gJe != null) {
            this.gJe.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.gJe != null) {
            return this.gJe.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.gJe != null) {
            return this.gJe.getPlayUrl();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.gJe != null) {
            return this.gJe.getCurrentPosition();
        }
        return 0;
    }
}
