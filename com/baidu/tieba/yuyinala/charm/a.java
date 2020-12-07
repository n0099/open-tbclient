package com.baidu.tieba.yuyinala.charm;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.RedPacketCharmInfo;
import com.baidu.live.data.cy;
import com.baidu.live.data.w;
import com.baidu.live.pendantview.PendantChildView;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.sdk.a;
import com.baidu.live.utils.k;
/* loaded from: classes4.dex */
public class a implements com.baidu.live.aa.a {
    private w aFN;
    private PendantParentView gEi;
    private PendantChildView gEj;
    private RedPacketCharmInfo gEl;
    private CountDownTimer gEm;
    private boolean gEn;
    private CustomMessageListener gEo;
    private Context mContext;
    private RedPacketCharmView oia;

    public a(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.aa.a
    public void p(ViewGroup viewGroup) {
        reset(true);
        if (viewGroup instanceof PendantParentView) {
            this.gEi = (PendantParentView) viewGroup;
            bUj();
        }
        bUh();
    }

    @Override // com.baidu.live.aa.a
    public boolean o(w wVar) {
        if (wVar == null || wVar.mLiveInfo == null) {
            if (this.gEj != null) {
                this.gEj.setVisibility(8);
            }
            return false;
        }
        this.aFN = wVar;
        return a(wVar.mLiveInfo.redpacketCharmInfo);
    }

    @Override // com.baidu.live.aa.a
    public void setCanVisible(boolean z) {
        this.gEn = z;
        if (this.gEj != null) {
            this.gEj.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.live.aa.a
    public void dX(int i) {
        LinearLayout.LayoutParams layoutParams;
        int dimensionPixelOffset;
        if (this.gEj != null && (this.gEj.getLayoutParams() instanceof LinearLayout.LayoutParams) && (layoutParams = (LinearLayout.LayoutParams) this.gEj.getLayoutParams()) != null) {
            if (i == 2) {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds10);
            } else {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds20);
            }
            layoutParams.topMargin = dimensionPixelOffset;
            this.gEj.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.aa.a
    public void IB() {
        reset(true);
    }

    @Override // com.baidu.live.aa.a
    public void release() {
        IB();
    }

    private void bUh() {
        if (this.gEo == null) {
            this.gEo = new CustomMessageListener(2913221) { // from class: com.baidu.tieba.yuyinala.charm.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof RedPacketCharmInfo)) {
                        a.this.a((RedPacketCharmInfo) customResponsedMessage.getData());
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.gEo);
        }
    }

    private void bUi() {
        if (this.gEo != null) {
            MessageManager.getInstance().unRegisterListener(this.gEo);
            this.gEo = null;
        }
    }

    private void bUj() {
        this.gEj = new PendantChildView(this.mContext) { // from class: com.baidu.tieba.yuyinala.charm.a.2
            @Override // com.baidu.live.pendantview.PendantChildView
            public PendantParentView.Position getVerticalPosition() {
                return PendantParentView.Position.RIGHT;
            }

            @Override // com.baidu.live.pendantview.PendantChildView
            public PendantParentView.Position getVerticalPkPosition() {
                return PendantParentView.Position.RIGHT;
            }

            @Override // com.baidu.live.pendantview.PendantChildView
            public PendantParentView.Position getHorizontalPosition() {
                return PendantParentView.Position.RIGHT;
            }

            @Override // com.baidu.live.pendantview.PendantChildView
            public PendantParentView.Position getHorizontalFullPosition() {
                return PendantParentView.Position.RIGHT;
            }

            @Override // com.baidu.live.pendantview.PendantChildView
            public int getPriority() {
                return this.btr == PendantParentView.Model.VERTICAL ? 95 : 10;
            }
        };
        this.gEj.setBackgroundColor(0);
        if (this.gEi != null) {
            this.gEi.a(this.gEj, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RedPacketCharmInfo redPacketCharmInfo) {
        int i;
        if (!b(redPacketCharmInfo)) {
            reset(false);
            if (this.gEj != null) {
                this.gEj.setVisibility(8);
                return false;
            }
            return false;
        }
        if (this.gEj == null) {
            bUj();
        }
        if (this.oia == null || (this.gEj != null && this.gEj.indexOfChild(this.oia) < 0)) {
            this.oia = new RedPacketCharmView(this.mContext);
            this.gEj.addView(this.oia, new FrameLayout.LayoutParams(-2, -2));
            this.oia.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bUk();
                }
            });
        }
        long j = redPacketCharmInfo.startTime - redPacketCharmInfo.serverTime;
        if (j <= 0) {
            redPacketCharmInfo.status = 3;
        }
        if (redPacketCharmInfo.count > 1) {
            i = redPacketCharmInfo.status == 3 ? redPacketCharmInfo.count - 1 : redPacketCharmInfo.count;
        } else {
            i = 0;
        }
        vu(i);
        this.oia.setAvatar(redPacketCharmInfo.senderAvatar);
        switch (redPacketCharmInfo.status) {
            case 2:
                if (j > 60) {
                    this.oia.vw(1);
                } else if (j > 10) {
                    this.oia.vw(2);
                } else {
                    this.oia.vw(3);
                }
                if (c(redPacketCharmInfo)) {
                    this.oia.setCountDownTimer(String.valueOf(j), k.bs(1000 * j));
                    fb(j * 1000);
                    break;
                }
                break;
            case 3:
                bUl();
                fc(0L);
                this.oia.vw(4);
                break;
            default:
                this.oia.vw(1);
                break;
        }
        this.gEl = redPacketCharmInfo;
        this.gEj.setVisibility(this.gEn ? 0 : 8);
        return true;
    }

    private boolean b(RedPacketCharmInfo redPacketCharmInfo) {
        return (redPacketCharmInfo == null || TextUtils.isEmpty(redPacketCharmInfo.id) || (redPacketCharmInfo.status != 2 && redPacketCharmInfo.status != 3) || redPacketCharmInfo.count <= 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUk() {
        if (this.aFN != null && this.gEl != null) {
            cy cyVar = new cy();
            cyVar.aRN = this.gEl.id;
            cyVar.liveId = String.valueOf(this.aFN.mLiveInfo.live_id);
            cyVar.aUf = String.valueOf(this.aFN.mLiveInfo.user_uk);
            cyVar.roomId = String.valueOf(this.aFN.mLiveInfo.room_id);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913134, cyVar));
        }
    }

    private boolean c(RedPacketCharmInfo redPacketCharmInfo) {
        return this.gEl == null || TextUtils.isEmpty(this.gEl.id) || !this.gEl.id.equals(redPacketCharmInfo.id) || this.gEl.status != redPacketCharmInfo.status || this.gEl.startTime <= 0 || this.gEl.startTime != redPacketCharmInfo.startTime;
    }

    private void fb(long j) {
        bUl();
        this.gEm = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.yuyinala.charm.a.4
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                if (a.this.oia != null) {
                    long round = Math.round(j2 / 1000.0d);
                    a.this.oia.setCountDownTimer(String.valueOf(round), k.bs(1000 * round));
                    if (round > 10 && round <= 60) {
                        a.this.oia.vw(2);
                    } else if (round <= 10) {
                        a.this.oia.vw(3);
                    }
                    a.this.fc(round);
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                int i;
                if (a.this.oia != null) {
                    a.this.oia.vw(4);
                    if (a.this.gEl != null) {
                        a aVar = a.this;
                        if (a.this.gEl.count > 1) {
                            i = a.this.gEl.count - 1;
                        } else {
                            i = 0;
                        }
                        aVar.vu(i);
                    }
                    a.this.fc(0L);
                }
            }
        };
        this.gEm.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vu(int i) {
        if (this.oia != null) {
            String str = "";
            if (i > 99) {
                str = "99+";
            } else if (i >= 1) {
                str = String.valueOf(i);
            }
            this.oia.setBadge(TextUtils.isEmpty(str) ? false : true, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fc(long j) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913133, Long.valueOf(j)));
    }

    private void bUl() {
        if (this.gEm != null) {
            this.gEm.cancel();
        }
    }

    private void reset(boolean z) {
        if (z) {
            bUi();
        }
        this.gEn = true;
        this.gEl = null;
        bUl();
        lY(z);
    }

    private void lY(boolean z) {
        if (this.oia != null) {
            this.oia.release();
            if (this.oia.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.oia.getParent()).removeView(this.oia);
            }
        }
        if (z && this.gEj != null && (this.gEj.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gEj.getParent()).removeView(this.gEj);
        }
    }
}
