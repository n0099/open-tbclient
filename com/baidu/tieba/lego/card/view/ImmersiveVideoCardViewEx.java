package com.baidu.tieba.lego.card.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.ImmersiveVideoCardEx;
/* loaded from: classes8.dex */
public class ImmersiveVideoCardViewEx extends BaseCardView<ImmersiveVideoCardEx> implements com.baidu.tieba.play.d, com.baidu.tieba.play.e {
    private o lgg;
    private a lgh;
    private ViewGroup mRootView;

    public ImmersiveVideoCardViewEx(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View dce() {
        this.mRootView = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.card_item_video_thread, (ViewGroup) null);
        this.lgg = new o(this.eWx, this.mRootView.findViewById(R.id.layout_video_container));
        this.lgh = new a(this.eWx, this.mRootView);
        this.lgg.d(this.lgh);
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
            this.lgg.fK(immersiveVideoCardEx.getShowExtra(), LogConfig.KEY_FEED);
            this.lgg.a(immersiveVideoCardEx.getVideoInfo(), immersiveVideoCardEx.getPage());
            boolean z = immersiveVideoCardEx.getVideoInfo().lej;
            this.lgg.tL(z);
            this.lgg.tJ(z);
            this.lgh.tJ(z);
            setTag(this);
            dcp();
        }
    }

    @Override // com.baidu.tieba.play.d
    public void dcn() {
        if (this.lgh != null) {
            this.lgh.dcn();
        }
    }

    @Override // com.baidu.tieba.play.d
    public void cqc() {
        if (this.lgh != null) {
            this.lgh.cqc();
        }
    }

    @Override // com.baidu.tieba.play.d
    public void dco() {
        if (this.lgh != null) {
            this.lgh.dco();
        }
    }

    public void dcp() {
        if (this.lgh != null) {
            this.lgh.dcp();
        }
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        return this.lgg != null && this.lgg.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        return this.lgg != null && this.lgg.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.lgg != null) {
            this.lgg.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.lgg != null) {
            this.lgg.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.lgg != null) {
            return this.lgg.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.lgg != null) {
            return this.lgg.getPlayUrl();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.lgg != null) {
            return this.lgg.getCurrentPosition();
        }
        return 0;
    }
}
