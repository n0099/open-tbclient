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
import com.baidu.live.data.cw;
import com.baidu.live.data.w;
import com.baidu.live.pendantview.PendantChildView;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.sdk.a;
import com.baidu.live.utils.k;
/* loaded from: classes4.dex */
public class a implements com.baidu.live.w.a {
    private w aDh;
    private RedPacketCharmInfo gvB;
    private CountDownTimer gvC;
    private boolean gvD;
    private CustomMessageListener gvE;
    private PendantParentView gvy;
    private PendantChildView gvz;
    private Context mContext;
    private RedPacketCharmView nTc;

    public a(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.w.a
    public void p(ViewGroup viewGroup) {
        reset(true);
        if (viewGroup instanceof PendantParentView) {
            this.gvy = (PendantParentView) viewGroup;
            bQz();
        }
        bQx();
    }

    @Override // com.baidu.live.w.a
    public boolean o(w wVar) {
        if (wVar == null || wVar.mLiveInfo == null) {
            if (this.gvz != null) {
                this.gvz.setVisibility(8);
            }
            return false;
        }
        this.aDh = wVar;
        return a(wVar.mLiveInfo.redpacketCharmInfo);
    }

    @Override // com.baidu.live.w.a
    public void setCanVisible(boolean z) {
        this.gvD = z;
        if (this.gvz != null) {
            this.gvz.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.live.w.a
    public void dE(int i) {
        LinearLayout.LayoutParams layoutParams;
        int dimensionPixelOffset;
        if (this.gvz != null && (this.gvz.getLayoutParams() instanceof LinearLayout.LayoutParams) && (layoutParams = (LinearLayout.LayoutParams) this.gvz.getLayoutParams()) != null) {
            if (i == 2) {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds10);
            } else {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds20);
            }
            layoutParams.topMargin = dimensionPixelOffset;
            this.gvz.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.w.a
    public void GK() {
        reset(true);
    }

    @Override // com.baidu.live.w.a
    public void release() {
        GK();
    }

    private void bQx() {
        if (this.gvE == null) {
            this.gvE = new CustomMessageListener(2913221) { // from class: com.baidu.tieba.yuyinala.charm.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof RedPacketCharmInfo)) {
                        a.this.a((RedPacketCharmInfo) customResponsedMessage.getData());
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.gvE);
        }
    }

    private void bQy() {
        if (this.gvE != null) {
            MessageManager.getInstance().unRegisterListener(this.gvE);
            this.gvE = null;
        }
    }

    private void bQz() {
        this.gvz = new PendantChildView(this.mContext) { // from class: com.baidu.tieba.yuyinala.charm.a.2
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
                return this.boi == PendantParentView.Model.VERTICAL ? 95 : 10;
            }
        };
        this.gvz.setBackgroundColor(0);
        if (this.gvy != null) {
            this.gvy.a(this.gvz, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RedPacketCharmInfo redPacketCharmInfo) {
        int i;
        if (!b(redPacketCharmInfo)) {
            reset(false);
            if (this.gvz != null) {
                this.gvz.setVisibility(8);
                return false;
            }
            return false;
        }
        if (this.gvz == null) {
            bQz();
        }
        if (this.nTc == null || (this.gvz != null && this.gvz.indexOfChild(this.nTc) < 0)) {
            this.nTc = new RedPacketCharmView(this.mContext);
            this.gvz.addView(this.nTc, new FrameLayout.LayoutParams(-2, -2));
            this.nTc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bQA();
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
        uN(i);
        this.nTc.setAvatar(redPacketCharmInfo.senderAvatar);
        switch (redPacketCharmInfo.status) {
            case 2:
                if (j > 60) {
                    this.nTc.uP(1);
                } else if (j > 10) {
                    this.nTc.uP(2);
                } else {
                    this.nTc.uP(3);
                }
                if (c(redPacketCharmInfo)) {
                    this.nTc.setCountDownTimer(String.valueOf(j), k.aU(1000 * j));
                    ey(j * 1000);
                    break;
                }
                break;
            case 3:
                bQB();
                ez(0L);
                this.nTc.uP(4);
                break;
            default:
                this.nTc.uP(1);
                break;
        }
        this.gvB = redPacketCharmInfo;
        this.gvz.setVisibility(this.gvD ? 0 : 8);
        return true;
    }

    private boolean b(RedPacketCharmInfo redPacketCharmInfo) {
        return (redPacketCharmInfo == null || TextUtils.isEmpty(redPacketCharmInfo.id) || (redPacketCharmInfo.status != 2 && redPacketCharmInfo.status != 3) || redPacketCharmInfo.count <= 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQA() {
        if (this.aDh != null && this.gvB != null) {
            cw cwVar = new cw();
            cwVar.aOL = this.gvB.id;
            cwVar.liveId = String.valueOf(this.aDh.mLiveInfo.live_id);
            cwVar.aRd = String.valueOf(this.aDh.mLiveInfo.user_uk);
            cwVar.roomId = String.valueOf(this.aDh.mLiveInfo.room_id);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913134, cwVar));
        }
    }

    private boolean c(RedPacketCharmInfo redPacketCharmInfo) {
        return this.gvB == null || TextUtils.isEmpty(this.gvB.id) || !this.gvB.id.equals(redPacketCharmInfo.id) || this.gvB.status != redPacketCharmInfo.status || this.gvB.startTime <= 0 || this.gvB.startTime != redPacketCharmInfo.startTime;
    }

    private void ey(long j) {
        bQB();
        this.gvC = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.yuyinala.charm.a.4
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                if (a.this.nTc != null) {
                    long round = Math.round(j2 / 1000.0d);
                    a.this.nTc.setCountDownTimer(String.valueOf(round), k.aU(1000 * round));
                    if (round > 10 && round <= 60) {
                        a.this.nTc.uP(2);
                    } else if (round <= 10) {
                        a.this.nTc.uP(3);
                    }
                    a.this.ez(round);
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                int i;
                if (a.this.nTc != null) {
                    a.this.nTc.uP(4);
                    if (a.this.gvB != null) {
                        a aVar = a.this;
                        if (a.this.gvB.count > 1) {
                            i = a.this.gvB.count - 1;
                        } else {
                            i = 0;
                        }
                        aVar.uN(i);
                    }
                    a.this.ez(0L);
                }
            }
        };
        this.gvC.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uN(int i) {
        if (this.nTc != null) {
            String str = "";
            if (i > 99) {
                str = "99+";
            } else if (i >= 1) {
                str = String.valueOf(i);
            }
            this.nTc.setBadge(TextUtils.isEmpty(str) ? false : true, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ez(long j) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913133, Long.valueOf(j)));
    }

    private void bQB() {
        if (this.gvC != null) {
            this.gvC.cancel();
        }
    }

    private void reset(boolean z) {
        if (z) {
            bQy();
        }
        this.gvD = true;
        this.gvB = null;
        bQB();
        lD(z);
    }

    private void lD(boolean z) {
        if (this.nTc != null) {
            this.nTc.release();
            if (this.nTc.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.nTc.getParent()).removeView(this.nTc);
            }
        }
        if (z && this.gvz != null && (this.gvz.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gvz.getParent()).removeView(this.gvz);
        }
    }
}
