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
import com.baidu.live.data.dc;
import com.baidu.live.data.x;
import com.baidu.live.pendantview.PendantChildView;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.sdk.a;
import com.baidu.live.utils.k;
/* loaded from: classes10.dex */
public class a implements com.baidu.live.ab.a {
    private x aBr;
    private RedPacketCharmInfo gLr;
    private CountDownTimer gLs;
    private boolean gLt;
    private CustomMessageListener gLu;
    private PendantParentView glA;
    private PendantChildView glB;
    private Context mContext;
    private RedPacketCharmView ofe;
    private Long ofg = 0L;

    public a(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.ab.a
    public void s(ViewGroup viewGroup) {
        reset(true);
        if (viewGroup instanceof PendantParentView) {
            this.glA = (PendantParentView) viewGroup;
            bNr();
        }
        bSW();
    }

    @Override // com.baidu.live.ab.a
    public boolean p(x xVar) {
        if (xVar == null || xVar.mLiveInfo == null) {
            if (this.glB != null) {
                this.glB.setVisibility(8);
            }
            return false;
        }
        this.aBr = xVar;
        return a(xVar.mLiveInfo.redpacketCharmInfo);
    }

    @Override // com.baidu.live.ab.a
    public void setCanVisible(boolean z) {
        this.gLt = z;
        if (this.glB != null) {
            this.glB.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.live.ab.a
    public void co(int i) {
        LinearLayout.LayoutParams layoutParams;
        int dimensionPixelOffset;
        if (this.glB != null && (this.glB.getLayoutParams() instanceof LinearLayout.LayoutParams) && (layoutParams = (LinearLayout.LayoutParams) this.glB.getLayoutParams()) != null) {
            if (i == 2) {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds10);
            } else {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds20);
            }
            layoutParams.topMargin = dimensionPixelOffset;
            this.glB.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.ab.a
    public void Ei() {
        reset(true);
    }

    @Override // com.baidu.live.ab.a
    public void release() {
        Ei();
    }

    private void bSW() {
        if (this.gLu == null) {
            this.gLu = new CustomMessageListener(2913221) { // from class: com.baidu.tieba.yuyinala.charm.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof RedPacketCharmInfo)) {
                        a.this.a((RedPacketCharmInfo) customResponsedMessage.getData());
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.gLu);
        }
    }

    private void bSX() {
        if (this.gLu != null) {
            MessageManager.getInstance().unRegisterListener(this.gLu);
            this.gLu = null;
        }
    }

    private void bNr() {
        this.glB = new PendantChildView(this.mContext) { // from class: com.baidu.tieba.yuyinala.charm.a.2
            @Override // com.baidu.live.pendantview.PendantChildView
            public PendantParentView.Position getVerticalPosition() {
                return PendantParentView.Position.RIGHT;
            }

            @Override // com.baidu.live.pendantview.PendantChildView
            public PendantParentView.Position getVerticalPkPosition() {
                return PendantParentView.Position.RIGHT;
            }

            @Override // com.baidu.live.pendantview.PendantChildView
            public PendantParentView.Position getVerticalBBChattingPosition() {
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
                return this.btq == PendantParentView.Model.VERTICAL ? 95 : 10;
            }
        };
        this.glB.setBackgroundColor(0);
        if (this.glA != null) {
            this.glA.a(this.glB, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RedPacketCharmInfo redPacketCharmInfo) {
        int i;
        if (!b(redPacketCharmInfo)) {
            reset(false);
            if (this.glB != null) {
                this.glB.setVisibility(8);
                return false;
            }
            return false;
        }
        if (this.glB == null) {
            bNr();
        }
        if (this.ofe == null || (this.glB != null && this.glB.indexOfChild(this.ofe) < 0)) {
            this.ofe = new RedPacketCharmView(this.mContext);
            this.glB.addView(this.ofe, new FrameLayout.LayoutParams(-2, -2));
            this.ofe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bSY();
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
        tZ(i);
        this.ofe.setAvatar(redPacketCharmInfo.senderAvatar);
        switch (redPacketCharmInfo.status) {
            case 2:
                if (j > 60) {
                    this.ofe.ub(1);
                } else if (j > 10) {
                    this.ofe.ub(2);
                } else {
                    this.ofe.ub(3);
                }
                if (c(redPacketCharmInfo)) {
                    this.ofe.setCountDownTimer(String.valueOf(j), k.bs(1000 * j));
                    fb(j * 1000);
                    break;
                }
                break;
            case 3:
                bSZ();
                fc(0L);
                this.ofe.ub(4);
                break;
            default:
                this.ofe.ub(1);
                break;
        }
        this.gLr = redPacketCharmInfo;
        this.glB.setVisibility(this.gLt ? 0 : 8);
        return true;
    }

    private boolean b(RedPacketCharmInfo redPacketCharmInfo) {
        return (redPacketCharmInfo == null || TextUtils.isEmpty(redPacketCharmInfo.id) || (redPacketCharmInfo.status != 2 && redPacketCharmInfo.status != 3) || redPacketCharmInfo.count <= 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSY() {
        if (this.aBr != null && this.gLr != null) {
            dc dcVar = new dc();
            dcVar.aNP = this.gLr.id;
            dcVar.liveId = String.valueOf(this.aBr.mLiveInfo.live_id);
            dcVar.aQG = String.valueOf(this.aBr.mLiveInfo.user_uk);
            dcVar.roomId = String.valueOf(this.aBr.mLiveInfo.room_id);
            dcVar.time = this.ofg.longValue();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913134, dcVar));
        }
    }

    private boolean c(RedPacketCharmInfo redPacketCharmInfo) {
        return this.gLr == null || TextUtils.isEmpty(this.gLr.id) || !this.gLr.id.equals(redPacketCharmInfo.id) || this.gLr.status != redPacketCharmInfo.status || this.gLr.startTime <= 0 || this.gLr.startTime != redPacketCharmInfo.startTime;
    }

    private void fb(long j) {
        bSZ();
        this.gLs = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.yuyinala.charm.a.4
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                if (a.this.ofe != null) {
                    long round = Math.round(j2 / 1000.0d);
                    a.this.ofg = Long.valueOf(round);
                    a.this.ofe.setCountDownTimer(String.valueOf(round), k.bs(1000 * round));
                    if (round > 10 && round <= 60) {
                        a.this.ofe.ub(2);
                    } else if (round <= 10) {
                        a.this.ofe.ub(3);
                    }
                    a.this.fc(round);
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                int i;
                if (a.this.ofe != null) {
                    a.this.ofe.ub(4);
                    if (a.this.gLr != null) {
                        a aVar = a.this;
                        if (a.this.gLr.count > 1) {
                            i = a.this.gLr.count - 1;
                        } else {
                            i = 0;
                        }
                        aVar.tZ(i);
                    }
                    a.this.fc(0L);
                }
            }
        };
        this.gLs.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tZ(int i) {
        if (this.ofe != null) {
            String str = "";
            if (i > 99) {
                str = "99+";
            } else if (i >= 1) {
                str = String.valueOf(i);
            }
            this.ofe.setBadge(TextUtils.isEmpty(str) ? false : true, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fc(long j) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913133, Long.valueOf(j)));
    }

    private void bSZ() {
        if (this.gLs != null) {
            this.gLs.cancel();
            this.ofg = 0L;
        }
    }

    private void reset(boolean z) {
        if (z) {
            bSX();
        }
        this.gLt = true;
        this.gLr = null;
        bSZ();
        mr(z);
    }

    private void mr(boolean z) {
        if (this.ofe != null) {
            this.ofe.release();
            if (this.ofe.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.ofe.getParent()).removeView(this.ofe);
            }
        }
        if (z && this.glB != null && (this.glB.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.glB.getParent()).removeView(this.glB);
        }
    }
}
