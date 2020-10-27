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
import com.baidu.live.data.cs;
import com.baidu.live.data.w;
import com.baidu.live.pendantview.PendantChildView;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.sdk.a;
import com.baidu.live.utils.k;
/* loaded from: classes4.dex */
public class a implements com.baidu.live.v.a {
    private w aEc;
    private PendantParentView gqd;
    private PendantChildView gqe;
    private RedPacketCharmInfo gqg;
    private CountDownTimer gqh;
    private boolean gqi;
    private CustomMessageListener gqj;
    private Context mContext;
    private RedPacketCharmView nLF;

    public a(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.v.a
    public void s(ViewGroup viewGroup) {
        reset(true);
        if (viewGroup instanceof PendantParentView) {
            this.gqd = (PendantParentView) viewGroup;
            bOG();
        }
        bOE();
    }

    @Override // com.baidu.live.v.a
    public boolean p(w wVar) {
        if (wVar == null || wVar.mLiveInfo == null) {
            if (this.gqe != null) {
                this.gqe.setVisibility(8);
            }
            return false;
        }
        this.aEc = wVar;
        return a(wVar.mLiveInfo.redpacketCharmInfo);
    }

    @Override // com.baidu.live.v.a
    public void setCanVisible(boolean z) {
        this.gqi = z;
        if (this.gqe != null) {
            this.gqe.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.live.v.a
    public void dI(int i) {
        LinearLayout.LayoutParams layoutParams;
        int dimensionPixelOffset;
        if (this.gqe != null && (this.gqe.getLayoutParams() instanceof LinearLayout.LayoutParams) && (layoutParams = (LinearLayout.LayoutParams) this.gqe.getLayoutParams()) != null) {
            if (i == 2) {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds10);
            } else {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
            }
            layoutParams.topMargin = dimensionPixelOffset;
            this.gqe.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.v.a
    public void GS() {
        reset(true);
    }

    @Override // com.baidu.live.v.a
    public void release() {
        GS();
    }

    private void bOE() {
        if (this.gqj == null) {
            this.gqj = new CustomMessageListener(2913221) { // from class: com.baidu.tieba.yuyinala.charm.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof RedPacketCharmInfo)) {
                        a.this.a((RedPacketCharmInfo) customResponsedMessage.getData());
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.gqj);
        }
    }

    private void bOF() {
        if (this.gqj != null) {
            MessageManager.getInstance().unRegisterListener(this.gqj);
            this.gqj = null;
        }
    }

    private void bOG() {
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
            public PendantParentView.Position getHorizontalPosition() {
                return PendantParentView.Position.RIGHT;
            }

            @Override // com.baidu.live.pendantview.PendantChildView
            public PendantParentView.Position getHorizontalFullPosition() {
                return PendantParentView.Position.RIGHT;
            }

            @Override // com.baidu.live.pendantview.PendantChildView
            public int getPriority() {
                return this.boA == PendantParentView.Model.VERTICAL ? 95 : 10;
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
            bOG();
        }
        if (this.nLF == null || (this.gqe != null && this.gqe.indexOfChild(this.nLF) < 0)) {
            this.nLF = new RedPacketCharmView(this.mContext);
            this.gqe.addView(this.nLF, new FrameLayout.LayoutParams(-2, -2));
            this.nLF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bOH();
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
        uf(i);
        this.nLF.setAvatar(redPacketCharmInfo.senderAvatar);
        switch (redPacketCharmInfo.status) {
            case 2:
                if (j > 60) {
                    this.nLF.uh(1);
                } else if (j > 10) {
                    this.nLF.uh(2);
                } else {
                    this.nLF.uh(3);
                }
                if (c(redPacketCharmInfo)) {
                    this.nLF.setCountDownTimer(String.valueOf(j), k.ay(1000 * j));
                    ec(j * 1000);
                    break;
                }
                break;
            case 3:
                bOI();
                ed(0L);
                this.nLF.uh(4);
                break;
            default:
                this.nLF.uh(1);
                break;
        }
        this.gqg = redPacketCharmInfo;
        this.gqe.setVisibility(this.gqi ? 0 : 8);
        return true;
    }

    private boolean b(RedPacketCharmInfo redPacketCharmInfo) {
        return (redPacketCharmInfo == null || TextUtils.isEmpty(redPacketCharmInfo.id) || (redPacketCharmInfo.status != 2 && redPacketCharmInfo.status != 3) || redPacketCharmInfo.count <= 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOH() {
        if (this.aEc != null && this.gqg != null) {
            cs csVar = new cs();
            csVar.aPz = this.gqg.id;
            csVar.liveId = String.valueOf(this.aEc.mLiveInfo.live_id);
            csVar.aRx = String.valueOf(this.aEc.mLiveInfo.user_uk);
            csVar.roomId = String.valueOf(this.aEc.mLiveInfo.room_id);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913134, csVar));
        }
    }

    private boolean c(RedPacketCharmInfo redPacketCharmInfo) {
        return this.gqg == null || TextUtils.isEmpty(this.gqg.id) || !this.gqg.id.equals(redPacketCharmInfo.id) || this.gqg.status != redPacketCharmInfo.status || this.gqg.startTime <= 0 || this.gqg.startTime != redPacketCharmInfo.startTime;
    }

    private void ec(long j) {
        bOI();
        this.gqh = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.yuyinala.charm.a.4
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                if (a.this.nLF != null) {
                    long round = Math.round(j2 / 1000.0d);
                    a.this.nLF.setCountDownTimer(String.valueOf(round), k.ay(1000 * round));
                    if (round > 10 && round <= 60) {
                        a.this.nLF.uh(2);
                    } else if (round <= 10) {
                        a.this.nLF.uh(3);
                    }
                    a.this.ed(round);
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                int i;
                if (a.this.nLF != null) {
                    a.this.nLF.uh(4);
                    if (a.this.gqg != null) {
                        a aVar = a.this;
                        if (a.this.gqg.count > 1) {
                            i = a.this.gqg.count - 1;
                        } else {
                            i = 0;
                        }
                        aVar.uf(i);
                    }
                    a.this.ed(0L);
                }
            }
        };
        this.gqh.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uf(int i) {
        if (this.nLF != null) {
            String str = "";
            if (i > 99) {
                str = "99+";
            } else if (i >= 1) {
                str = String.valueOf(i);
            }
            this.nLF.setBadge(TextUtils.isEmpty(str) ? false : true, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ed(long j) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913133, Long.valueOf(j)));
    }

    private void bOI() {
        if (this.gqh != null) {
            this.gqh.cancel();
        }
    }

    private void reset(boolean z) {
        if (z) {
            bOF();
        }
        this.gqi = true;
        this.gqg = null;
        bOI();
        lt(z);
    }

    private void lt(boolean z) {
        if (this.nLF != null) {
            this.nLF.release();
            if (this.nLF.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.nLF.getParent()).removeView(this.nLF);
            }
        }
        if (z && this.gqe != null && (this.gqe.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gqe.getParent()).removeView(this.gqe);
        }
    }
}
