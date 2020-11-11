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
    private w aES;
    private PendantParentView gvR;
    private PendantChildView gvS;
    private RedPacketCharmInfo gvU;
    private CountDownTimer gvV;
    private boolean gvW;
    private CustomMessageListener gvX;
    private Context mContext;
    private RedPacketCharmView nRz;

    public a(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.w.a
    public void t(ViewGroup viewGroup) {
        reset(true);
        if (viewGroup instanceof PendantParentView) {
            this.gvR = (PendantParentView) viewGroup;
            bRg();
        }
        bRe();
    }

    @Override // com.baidu.live.w.a
    public boolean o(w wVar) {
        if (wVar == null || wVar.mLiveInfo == null) {
            if (this.gvS != null) {
                this.gvS.setVisibility(8);
            }
            return false;
        }
        this.aES = wVar;
        return a(wVar.mLiveInfo.redpacketCharmInfo);
    }

    @Override // com.baidu.live.w.a
    public void setCanVisible(boolean z) {
        this.gvW = z;
        if (this.gvS != null) {
            this.gvS.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.live.w.a
    public void dI(int i) {
        LinearLayout.LayoutParams layoutParams;
        int dimensionPixelOffset;
        if (this.gvS != null && (this.gvS.getLayoutParams() instanceof LinearLayout.LayoutParams) && (layoutParams = (LinearLayout.LayoutParams) this.gvS.getLayoutParams()) != null) {
            if (i == 2) {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds10);
            } else {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds20);
            }
            layoutParams.topMargin = dimensionPixelOffset;
            this.gvS.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.w.a
    public void Ht() {
        reset(true);
    }

    @Override // com.baidu.live.w.a
    public void release() {
        Ht();
    }

    private void bRe() {
        if (this.gvX == null) {
            this.gvX = new CustomMessageListener(2913221) { // from class: com.baidu.tieba.yuyinala.charm.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof RedPacketCharmInfo)) {
                        a.this.a((RedPacketCharmInfo) customResponsedMessage.getData());
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.gvX);
        }
    }

    private void bRf() {
        if (this.gvX != null) {
            MessageManager.getInstance().unRegisterListener(this.gvX);
            this.gvX = null;
        }
    }

    private void bRg() {
        this.gvS = new PendantChildView(this.mContext) { // from class: com.baidu.tieba.yuyinala.charm.a.2
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
                return this.bpT == PendantParentView.Model.VERTICAL ? 95 : 10;
            }
        };
        this.gvS.setBackgroundColor(0);
        if (this.gvR != null) {
            this.gvR.a(this.gvS, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RedPacketCharmInfo redPacketCharmInfo) {
        int i;
        if (!b(redPacketCharmInfo)) {
            reset(false);
            if (this.gvS != null) {
                this.gvS.setVisibility(8);
                return false;
            }
            return false;
        }
        if (this.gvS == null) {
            bRg();
        }
        if (this.nRz == null || (this.gvS != null && this.gvS.indexOfChild(this.nRz) < 0)) {
            this.nRz = new RedPacketCharmView(this.mContext);
            this.gvS.addView(this.nRz, new FrameLayout.LayoutParams(-2, -2));
            this.nRz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bRh();
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
        up(i);
        this.nRz.setAvatar(redPacketCharmInfo.senderAvatar);
        switch (redPacketCharmInfo.status) {
            case 2:
                if (j > 60) {
                    this.nRz.ur(1);
                } else if (j > 10) {
                    this.nRz.ur(2);
                } else {
                    this.nRz.ur(3);
                }
                if (c(redPacketCharmInfo)) {
                    this.nRz.setCountDownTimer(String.valueOf(j), k.aU(1000 * j));
                    ey(j * 1000);
                    break;
                }
                break;
            case 3:
                bRi();
                ez(0L);
                this.nRz.ur(4);
                break;
            default:
                this.nRz.ur(1);
                break;
        }
        this.gvU = redPacketCharmInfo;
        this.gvS.setVisibility(this.gvW ? 0 : 8);
        return true;
    }

    private boolean b(RedPacketCharmInfo redPacketCharmInfo) {
        return (redPacketCharmInfo == null || TextUtils.isEmpty(redPacketCharmInfo.id) || (redPacketCharmInfo.status != 2 && redPacketCharmInfo.status != 3) || redPacketCharmInfo.count <= 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRh() {
        if (this.aES != null && this.gvU != null) {
            cw cwVar = new cw();
            cwVar.aQw = this.gvU.id;
            cwVar.liveId = String.valueOf(this.aES.mLiveInfo.live_id);
            cwVar.aSO = String.valueOf(this.aES.mLiveInfo.user_uk);
            cwVar.roomId = String.valueOf(this.aES.mLiveInfo.room_id);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913134, cwVar));
        }
    }

    private boolean c(RedPacketCharmInfo redPacketCharmInfo) {
        return this.gvU == null || TextUtils.isEmpty(this.gvU.id) || !this.gvU.id.equals(redPacketCharmInfo.id) || this.gvU.status != redPacketCharmInfo.status || this.gvU.startTime <= 0 || this.gvU.startTime != redPacketCharmInfo.startTime;
    }

    private void ey(long j) {
        bRi();
        this.gvV = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.yuyinala.charm.a.4
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                if (a.this.nRz != null) {
                    long round = Math.round(j2 / 1000.0d);
                    a.this.nRz.setCountDownTimer(String.valueOf(round), k.aU(1000 * round));
                    if (round > 10 && round <= 60) {
                        a.this.nRz.ur(2);
                    } else if (round <= 10) {
                        a.this.nRz.ur(3);
                    }
                    a.this.ez(round);
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                int i;
                if (a.this.nRz != null) {
                    a.this.nRz.ur(4);
                    if (a.this.gvU != null) {
                        a aVar = a.this;
                        if (a.this.gvU.count > 1) {
                            i = a.this.gvU.count - 1;
                        } else {
                            i = 0;
                        }
                        aVar.up(i);
                    }
                    a.this.ez(0L);
                }
            }
        };
        this.gvV.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void up(int i) {
        if (this.nRz != null) {
            String str = "";
            if (i > 99) {
                str = "99+";
            } else if (i >= 1) {
                str = String.valueOf(i);
            }
            this.nRz.setBadge(TextUtils.isEmpty(str) ? false : true, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ez(long j) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913133, Long.valueOf(j)));
    }

    private void bRi() {
        if (this.gvV != null) {
            this.gvV.cancel();
        }
    }

    private void reset(boolean z) {
        if (z) {
            bRf();
        }
        this.gvW = true;
        this.gvU = null;
        bRi();
        lC(z);
    }

    private void lC(boolean z) {
        if (this.nRz != null) {
            this.nRz.release();
            if (this.nRz.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.nRz.getParent()).removeView(this.nRz);
            }
        }
        if (z && this.gvS != null && (this.gvS.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gvS.getParent()).removeView(this.gvS);
        }
    }
}
