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
/* loaded from: classes11.dex */
public class a implements com.baidu.live.ab.a {
    private x aGe;
    private RedPacketCharmInfo gPX;
    private CountDownTimer gPY;
    private boolean gPZ;
    private CustomMessageListener gQa;
    private PendantParentView gqh;
    private PendantChildView gqi;
    private Context mContext;
    private RedPacketCharmView ojK;
    private Long ojL = 0L;

    public a(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.ab.a
    public void s(ViewGroup viewGroup) {
        reset(true);
        if (viewGroup instanceof PendantParentView) {
            this.gqh = (PendantParentView) viewGroup;
            bRi();
        }
        bWN();
    }

    @Override // com.baidu.live.ab.a
    public boolean p(x xVar) {
        if (xVar == null || xVar.mLiveInfo == null) {
            if (this.gqi != null) {
                this.gqi.setVisibility(8);
            }
            return false;
        }
        this.aGe = xVar;
        return a(xVar.mLiveInfo.redpacketCharmInfo);
    }

    @Override // com.baidu.live.ab.a
    public void setCanVisible(boolean z) {
        this.gPZ = z;
        if (this.gqi != null) {
            this.gqi.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.live.ab.a
    public void dU(int i) {
        LinearLayout.LayoutParams layoutParams;
        int dimensionPixelOffset;
        if (this.gqi != null && (this.gqi.getLayoutParams() instanceof LinearLayout.LayoutParams) && (layoutParams = (LinearLayout.LayoutParams) this.gqi.getLayoutParams()) != null) {
            if (i == 2) {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds10);
            } else {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds20);
            }
            layoutParams.topMargin = dimensionPixelOffset;
            this.gqi.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.ab.a
    public void Id() {
        reset(true);
    }

    @Override // com.baidu.live.ab.a
    public void release() {
        Id();
    }

    private void bWN() {
        if (this.gQa == null) {
            this.gQa = new CustomMessageListener(2913221) { // from class: com.baidu.tieba.yuyinala.charm.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof RedPacketCharmInfo)) {
                        a.this.a((RedPacketCharmInfo) customResponsedMessage.getData());
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.gQa);
        }
    }

    private void bWO() {
        if (this.gQa != null) {
            MessageManager.getInstance().unRegisterListener(this.gQa);
            this.gQa = null;
        }
    }

    private void bRi() {
        this.gqi = new PendantChildView(this.mContext) { // from class: com.baidu.tieba.yuyinala.charm.a.2
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
                return this.byd == PendantParentView.Model.VERTICAL ? 95 : 10;
            }
        };
        this.gqi.setBackgroundColor(0);
        if (this.gqh != null) {
            this.gqh.a(this.gqi, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RedPacketCharmInfo redPacketCharmInfo) {
        int i;
        if (!b(redPacketCharmInfo)) {
            reset(false);
            if (this.gqi != null) {
                this.gqi.setVisibility(8);
                return false;
            }
            return false;
        }
        if (this.gqi == null) {
            bRi();
        }
        if (this.ojK == null || (this.gqi != null && this.gqi.indexOfChild(this.ojK) < 0)) {
            this.ojK = new RedPacketCharmView(this.mContext);
            this.gqi.addView(this.ojK, new FrameLayout.LayoutParams(-2, -2));
            this.ojK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bWP();
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
        vF(i);
        this.ojK.setAvatar(redPacketCharmInfo.senderAvatar);
        switch (redPacketCharmInfo.status) {
            case 2:
                if (j > 60) {
                    this.ojK.vH(1);
                } else if (j > 10) {
                    this.ojK.vH(2);
                } else {
                    this.ojK.vH(3);
                }
                if (c(redPacketCharmInfo)) {
                    this.ojK.setCountDownTimer(String.valueOf(j), k.bs(1000 * j));
                    fb(j * 1000);
                    break;
                }
                break;
            case 3:
                bWQ();
                fc(0L);
                this.ojK.vH(4);
                break;
            default:
                this.ojK.vH(1);
                break;
        }
        this.gPX = redPacketCharmInfo;
        this.gqi.setVisibility(this.gPZ ? 0 : 8);
        return true;
    }

    private boolean b(RedPacketCharmInfo redPacketCharmInfo) {
        return (redPacketCharmInfo == null || TextUtils.isEmpty(redPacketCharmInfo.id) || (redPacketCharmInfo.status != 2 && redPacketCharmInfo.status != 3) || redPacketCharmInfo.count <= 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWP() {
        if (this.aGe != null && this.gPX != null) {
            dc dcVar = new dc();
            dcVar.aSC = this.gPX.id;
            dcVar.liveId = String.valueOf(this.aGe.mLiveInfo.live_id);
            dcVar.aVt = String.valueOf(this.aGe.mLiveInfo.user_uk);
            dcVar.roomId = String.valueOf(this.aGe.mLiveInfo.room_id);
            dcVar.time = this.ojL.longValue();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913134, dcVar));
        }
    }

    private boolean c(RedPacketCharmInfo redPacketCharmInfo) {
        return this.gPX == null || TextUtils.isEmpty(this.gPX.id) || !this.gPX.id.equals(redPacketCharmInfo.id) || this.gPX.status != redPacketCharmInfo.status || this.gPX.startTime <= 0 || this.gPX.startTime != redPacketCharmInfo.startTime;
    }

    private void fb(long j) {
        bWQ();
        this.gPY = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.yuyinala.charm.a.4
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                if (a.this.ojK != null) {
                    long round = Math.round(j2 / 1000.0d);
                    a.this.ojL = Long.valueOf(round);
                    a.this.ojK.setCountDownTimer(String.valueOf(round), k.bs(1000 * round));
                    if (round > 10 && round <= 60) {
                        a.this.ojK.vH(2);
                    } else if (round <= 10) {
                        a.this.ojK.vH(3);
                    }
                    a.this.fc(round);
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                int i;
                if (a.this.ojK != null) {
                    a.this.ojK.vH(4);
                    if (a.this.gPX != null) {
                        a aVar = a.this;
                        if (a.this.gPX.count > 1) {
                            i = a.this.gPX.count - 1;
                        } else {
                            i = 0;
                        }
                        aVar.vF(i);
                    }
                    a.this.fc(0L);
                }
            }
        };
        this.gPY.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vF(int i) {
        if (this.ojK != null) {
            String str = "";
            if (i > 99) {
                str = "99+";
            } else if (i >= 1) {
                str = String.valueOf(i);
            }
            this.ojK.setBadge(TextUtils.isEmpty(str) ? false : true, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fc(long j) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913133, Long.valueOf(j)));
    }

    private void bWQ() {
        if (this.gPY != null) {
            this.gPY.cancel();
            this.ojL = 0L;
        }
    }

    private void reset(boolean z) {
        if (z) {
            bWO();
        }
        this.gPZ = true;
        this.gPX = null;
        bWQ();
        mv(z);
    }

    private void mv(boolean z) {
        if (this.ojK != null) {
            this.ojK.release();
            if (this.ojK.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.ojK.getParent()).removeView(this.ojK);
            }
        }
        if (z && this.gqi != null && (this.gqi.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gqi.getParent()).removeView(this.gqi);
        }
    }
}
