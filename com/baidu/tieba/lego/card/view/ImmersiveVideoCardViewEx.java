package com.baidu.tieba.lego.card.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.d;
import com.baidu.tieba.lego.card.model.ImmersiveVideoCardEx;
/* loaded from: classes2.dex */
public class ImmersiveVideoCardViewEx extends BaseCardView<ImmersiveVideoCardEx> implements com.baidu.tieba.play.e, com.baidu.tieba.play.f {
    private m gJf;
    private a gJg;
    private ViewGroup mRootView;

    public ImmersiveVideoCardViewEx(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bAe() {
        this.mRootView = (ViewGroup) LayoutInflater.from(getContext()).inflate(d.h.card_item_video_thread, (ViewGroup) null);
        this.gJf = new m(this.mContext, this.mRootView.findViewById(d.g.layout_video_container));
        this.gJg = new a(this.mContext, this.mRootView);
        this.gJf.d(this.gJg);
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
            this.gJf.dn(immersiveVideoCardEx.getShowExtra(), "feed");
            this.gJf.a(immersiveVideoCardEx.getVideoInfo(), immersiveVideoCardEx.getPage());
            boolean z = immersiveVideoCardEx.getVideoInfo().gHh;
            this.gJf.lb(z);
            this.gJf.ma(z);
            this.gJg.ma(z);
            setTag(this);
            bAr();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void bAo() {
        if (this.gJg != null) {
            this.gJg.bAo();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void bAp() {
        if (this.gJg != null) {
            this.gJg.bAp();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void bAq() {
        if (this.gJg != null) {
            this.gJg.bAq();
        }
    }

    public void bAr() {
        if (this.gJg != null) {
            this.gJg.bAr();
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.gJf != null && this.gJf.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        return this.gJf != null && this.gJf.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.gJf != null) {
            this.gJf.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.gJf != null) {
            this.gJf.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.gJf != null) {
            return this.gJf.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.gJf != null) {
            return this.gJf.getPlayUrl();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.gJf != null) {
            return this.gJf.getCurrentPosition();
        }
        return 0;
    }
}
