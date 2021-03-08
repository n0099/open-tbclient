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
import com.baidu.live.data.ab;
import com.baidu.live.data.di;
import com.baidu.live.pendantview.PendantChildView;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.sdk.a;
import com.baidu.live.utils.k;
/* loaded from: classes10.dex */
public class a implements com.baidu.live.aa.a {
    private ab aED;
    private RedPacketCharmInfo gPU;
    private CountDownTimer gPV;
    private boolean gPW;
    private CustomMessageListener gPX;
    private PendantParentView gqd;
    private PendantChildView gqe;
    private Context mContext;
    private RedPacketCharmView orE;
    private Long orF = 0L;

    public a(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.aa.a
    public void q(ViewGroup viewGroup) {
        reset(true);
        if (viewGroup instanceof PendantParentView) {
            this.gqd = (PendantParentView) viewGroup;
            bOf();
        }
        bTM();
    }

    @Override // com.baidu.live.aa.a
    public boolean p(ab abVar) {
        if (abVar == null || abVar.mLiveInfo == null) {
            if (this.gqe != null) {
                this.gqe.setVisibility(8);
            }
            return false;
        }
        this.aED = abVar;
        return a(abVar.mLiveInfo.redpacketCharmInfo);
    }

    @Override // com.baidu.live.aa.a
    public void setCanVisible(boolean z) {
        this.gPW = z;
        if (this.gqe != null) {
            this.gqe.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.live.aa.a
    public void cs(int i) {
        LinearLayout.LayoutParams layoutParams;
        int dimensionPixelOffset;
        if (this.gqe != null && (this.gqe.getLayoutParams() instanceof LinearLayout.LayoutParams) && (layoutParams = (LinearLayout.LayoutParams) this.gqe.getLayoutParams()) != null) {
            if (i == 2) {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds10);
            } else {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds20);
            }
            layoutParams.topMargin = dimensionPixelOffset;
            this.gqe.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.aa.a
    public void FB() {
        reset(true);
    }

    @Override // com.baidu.live.aa.a
    public void release() {
        FB();
    }

    private void bTM() {
        if (this.gPX == null) {
            this.gPX = new CustomMessageListener(2913221) { // from class: com.baidu.tieba.yuyinala.charm.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof RedPacketCharmInfo)) {
                        a.this.a((RedPacketCharmInfo) customResponsedMessage.getData());
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.gPX);
        }
    }

    private void bTN() {
        if (this.gPX != null) {
            MessageManager.getInstance().unRegisterListener(this.gPX);
            this.gPX = null;
        }
    }

    private void bOf() {
        this.gqe = new PendantChildView(this.mContext) { // from class: com.baidu.tieba.yuyinala.charm.a.2
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
                return this.byt == PendantParentView.Model.VERTICAL ? 97 : 10;
            }
        };
        this.gqe.setBackgroundColor(0);
        if (this.gqd != null) {
            this.gqd.a(this.gqe, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RedPacketCharmInfo redPacketCharmInfo) {
        int i;
        if (!b(redPacketCharmInfo)) {
            reset(false);
            if (this.gqe != null) {
                this.gqe.setVisibility(8);
                return false;
            }
            return false;
        }
        if (this.gqe == null) {
            bOf();
        }
        if (this.orE == null || (this.gqe != null && this.gqe.indexOfChild(this.orE) < 0)) {
            this.orE = new RedPacketCharmView(this.mContext);
            this.gqe.addView(this.orE, new FrameLayout.LayoutParams(-2, -2));
            this.orE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bTO();
                }
            });
            this.gqd.Pf();
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
        uh(i);
        this.orE.setAvatar(redPacketCharmInfo.senderAvatar);
        switch (redPacketCharmInfo.status) {
            case 2:
                if (j > 60) {
                    this.orE.uj(1);
                } else if (j > 10) {
                    this.orE.uj(2);
                } else {
                    this.orE.uj(3);
                }
                if (c(redPacketCharmInfo)) {
                    this.orE.setCountDownTimer(String.valueOf(j), k.bw(1000 * j));
                    fh(j * 1000);
                    break;
                }
                break;
            case 3:
                bTP();
                fi(0L);
                this.orE.uj(4);
                break;
            default:
                this.orE.uj(1);
                break;
        }
        this.gPU = redPacketCharmInfo;
        this.gqe.setVisibility(this.gPW ? 0 : 8);
        return true;
    }

    private boolean b(RedPacketCharmInfo redPacketCharmInfo) {
        return (redPacketCharmInfo == null || TextUtils.isEmpty(redPacketCharmInfo.id) || (redPacketCharmInfo.status != 2 && redPacketCharmInfo.status != 3) || redPacketCharmInfo.count <= 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTO() {
        if (this.aED != null && this.gPU != null) {
            di diVar = new di();
            diVar.aSq = this.gPU.id;
            diVar.liveId = String.valueOf(this.aED.mLiveInfo.live_id);
            diVar.aVj = String.valueOf(this.aED.mLiveInfo.user_uk);
            diVar.roomId = String.valueOf(this.aED.mLiveInfo.room_id);
            diVar.time = this.orF.longValue();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913134, diVar));
        }
    }

    private boolean c(RedPacketCharmInfo redPacketCharmInfo) {
        return this.gPU == null || TextUtils.isEmpty(this.gPU.id) || !this.gPU.id.equals(redPacketCharmInfo.id) || this.gPU.status != redPacketCharmInfo.status || this.gPU.startTime <= 0 || this.gPU.startTime != redPacketCharmInfo.startTime;
    }

    private void fh(long j) {
        bTP();
        this.gPV = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.yuyinala.charm.a.4
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                if (a.this.orE != null) {
                    long round = Math.round(j2 / 1000.0d);
                    a.this.orF = Long.valueOf(round);
                    a.this.orE.setCountDownTimer(String.valueOf(round), k.bw(1000 * round));
                    if (round > 10 && round <= 60) {
                        a.this.orE.uj(2);
                    } else if (round <= 10) {
                        a.this.orE.uj(3);
                    }
                    a.this.fi(round);
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                int i;
                if (a.this.orE != null) {
                    a.this.orE.uj(4);
                    if (a.this.gPU != null) {
                        a aVar = a.this;
                        if (a.this.gPU.count > 1) {
                            i = a.this.gPU.count - 1;
                        } else {
                            i = 0;
                        }
                        aVar.uh(i);
                    }
                    a.this.fi(0L);
                }
            }
        };
        this.gPV.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uh(int i) {
        if (this.orE != null) {
            String str = "";
            if (i > 99) {
                str = "99+";
            } else if (i >= 1) {
                str = String.valueOf(i);
            }
            this.orE.setBadge(TextUtils.isEmpty(str) ? false : true, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fi(long j) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913133, Long.valueOf(j)));
    }

    private void bTP() {
        if (this.gPV != null) {
            this.gPV.cancel();
            this.orF = 0L;
        }
    }

    private void reset(boolean z) {
        if (z) {
            bTN();
        }
        this.gPW = true;
        this.gPU = null;
        bTP();
        mv(z);
    }

    private void mv(boolean z) {
        if (this.orE != null) {
            this.orE.release();
            if (this.orE.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.orE.getParent()).removeView(this.orE);
                if (this.gqd != null) {
                    this.gqd.Pf();
                }
            }
        }
        if (z && this.gqe != null && (this.gqe.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gqe.getParent()).removeView(this.gqe);
        }
    }
}
