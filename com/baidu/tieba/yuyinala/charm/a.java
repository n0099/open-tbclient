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
/* loaded from: classes11.dex */
public class a implements com.baidu.live.aa.a {
    private ab aDd;
    private RedPacketCharmInfo gNX;
    private CountDownTimer gNY;
    private boolean gNZ;
    private CustomMessageListener gOa;
    private PendantParentView gog;
    private PendantChildView goh;
    private Context mContext;
    private RedPacketCharmView ooX;
    private Long ooY = 0L;

    public a(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.aa.a
    public void q(ViewGroup viewGroup) {
        reset(true);
        if (viewGroup instanceof PendantParentView) {
            this.gog = (PendantParentView) viewGroup;
            bNS();
        }
        bTz();
    }

    @Override // com.baidu.live.aa.a
    public boolean p(ab abVar) {
        if (abVar == null || abVar.mLiveInfo == null) {
            if (this.goh != null) {
                this.goh.setVisibility(8);
            }
            return false;
        }
        this.aDd = abVar;
        return a(abVar.mLiveInfo.redpacketCharmInfo);
    }

    @Override // com.baidu.live.aa.a
    public void setCanVisible(boolean z) {
        this.gNZ = z;
        if (this.goh != null) {
            this.goh.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.live.aa.a
    public void cr(int i) {
        LinearLayout.LayoutParams layoutParams;
        int dimensionPixelOffset;
        if (this.goh != null && (this.goh.getLayoutParams() instanceof LinearLayout.LayoutParams) && (layoutParams = (LinearLayout.LayoutParams) this.goh.getLayoutParams()) != null) {
            if (i == 2) {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds10);
            } else {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds20);
            }
            layoutParams.topMargin = dimensionPixelOffset;
            this.goh.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.aa.a
    public void Fy() {
        reset(true);
    }

    @Override // com.baidu.live.aa.a
    public void release() {
        Fy();
    }

    private void bTz() {
        if (this.gOa == null) {
            this.gOa = new CustomMessageListener(2913221) { // from class: com.baidu.tieba.yuyinala.charm.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof RedPacketCharmInfo)) {
                        a.this.a((RedPacketCharmInfo) customResponsedMessage.getData());
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.gOa);
        }
    }

    private void bTA() {
        if (this.gOa != null) {
            MessageManager.getInstance().unRegisterListener(this.gOa);
            this.gOa = null;
        }
    }

    private void bNS() {
        this.goh = new PendantChildView(this.mContext) { // from class: com.baidu.tieba.yuyinala.charm.a.2
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
                return this.bwT == PendantParentView.Model.VERTICAL ? 97 : 10;
            }
        };
        this.goh.setBackgroundColor(0);
        if (this.gog != null) {
            this.gog.a(this.goh, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RedPacketCharmInfo redPacketCharmInfo) {
        int i;
        if (!b(redPacketCharmInfo)) {
            reset(false);
            if (this.goh != null) {
                this.goh.setVisibility(8);
                return false;
            }
            return false;
        }
        if (this.goh == null) {
            bNS();
        }
        if (this.ooX == null || (this.goh != null && this.goh.indexOfChild(this.ooX) < 0)) {
            this.ooX = new RedPacketCharmView(this.mContext);
            this.goh.addView(this.ooX, new FrameLayout.LayoutParams(-2, -2));
            this.ooX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bTB();
                }
            });
            this.gog.Pc();
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
        this.ooX.setAvatar(redPacketCharmInfo.senderAvatar);
        switch (redPacketCharmInfo.status) {
            case 2:
                if (j > 60) {
                    this.ooX.uh(1);
                } else if (j > 10) {
                    this.ooX.uh(2);
                } else {
                    this.ooX.uh(3);
                }
                if (c(redPacketCharmInfo)) {
                    this.ooX.setCountDownTimer(String.valueOf(j), k.bw(1000 * j));
                    fh(j * 1000);
                    break;
                }
                break;
            case 3:
                bTC();
                fi(0L);
                this.ooX.uh(4);
                break;
            default:
                this.ooX.uh(1);
                break;
        }
        this.gNX = redPacketCharmInfo;
        this.goh.setVisibility(this.gNZ ? 0 : 8);
        return true;
    }

    private boolean b(RedPacketCharmInfo redPacketCharmInfo) {
        return (redPacketCharmInfo == null || TextUtils.isEmpty(redPacketCharmInfo.id) || (redPacketCharmInfo.status != 2 && redPacketCharmInfo.status != 3) || redPacketCharmInfo.count <= 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTB() {
        if (this.aDd != null && this.gNX != null) {
            di diVar = new di();
            diVar.aQQ = this.gNX.id;
            diVar.liveId = String.valueOf(this.aDd.mLiveInfo.live_id);
            diVar.aTJ = String.valueOf(this.aDd.mLiveInfo.user_uk);
            diVar.roomId = String.valueOf(this.aDd.mLiveInfo.room_id);
            diVar.time = this.ooY.longValue();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913134, diVar));
        }
    }

    private boolean c(RedPacketCharmInfo redPacketCharmInfo) {
        return this.gNX == null || TextUtils.isEmpty(this.gNX.id) || !this.gNX.id.equals(redPacketCharmInfo.id) || this.gNX.status != redPacketCharmInfo.status || this.gNX.startTime <= 0 || this.gNX.startTime != redPacketCharmInfo.startTime;
    }

    private void fh(long j) {
        bTC();
        this.gNY = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.yuyinala.charm.a.4
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                if (a.this.ooX != null) {
                    long round = Math.round(j2 / 1000.0d);
                    a.this.ooY = Long.valueOf(round);
                    a.this.ooX.setCountDownTimer(String.valueOf(round), k.bw(1000 * round));
                    if (round > 10 && round <= 60) {
                        a.this.ooX.uh(2);
                    } else if (round <= 10) {
                        a.this.ooX.uh(3);
                    }
                    a.this.fi(round);
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                int i;
                if (a.this.ooX != null) {
                    a.this.ooX.uh(4);
                    if (a.this.gNX != null) {
                        a aVar = a.this;
                        if (a.this.gNX.count > 1) {
                            i = a.this.gNX.count - 1;
                        } else {
                            i = 0;
                        }
                        aVar.uf(i);
                    }
                    a.this.fi(0L);
                }
            }
        };
        this.gNY.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uf(int i) {
        if (this.ooX != null) {
            String str = "";
            if (i > 99) {
                str = "99+";
            } else if (i >= 1) {
                str = String.valueOf(i);
            }
            this.ooX.setBadge(TextUtils.isEmpty(str) ? false : true, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fi(long j) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913133, Long.valueOf(j)));
    }

    private void bTC() {
        if (this.gNY != null) {
            this.gNY.cancel();
            this.ooY = 0L;
        }
    }

    private void reset(boolean z) {
        if (z) {
            bTA();
        }
        this.gNZ = true;
        this.gNX = null;
        bTC();
        mv(z);
    }

    private void mv(boolean z) {
        if (this.ooX != null) {
            this.ooX.release();
            if (this.ooX.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.ooX.getParent()).removeView(this.ooX);
                if (this.gog != null) {
                    this.gog.Pc();
                }
            }
        }
        if (z && this.goh != null && (this.goh.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.goh.getParent()).removeView(this.goh);
        }
    }
}
