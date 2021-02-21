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
    private RedPacketCharmInfo gOl;
    private CountDownTimer gOm;
    private boolean gOn;
    private CustomMessageListener gOo;
    private PendantParentView gou;
    private PendantChildView gov;
    private Context mContext;
    private RedPacketCharmView opy;
    private Long opz = 0L;

    public a(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.aa.a
    public void q(ViewGroup viewGroup) {
        reset(true);
        if (viewGroup instanceof PendantParentView) {
            this.gou = (PendantParentView) viewGroup;
            bNZ();
        }
        bTG();
    }

    @Override // com.baidu.live.aa.a
    public boolean p(ab abVar) {
        if (abVar == null || abVar.mLiveInfo == null) {
            if (this.gov != null) {
                this.gov.setVisibility(8);
            }
            return false;
        }
        this.aDd = abVar;
        return a(abVar.mLiveInfo.redpacketCharmInfo);
    }

    @Override // com.baidu.live.aa.a
    public void setCanVisible(boolean z) {
        this.gOn = z;
        if (this.gov != null) {
            this.gov.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.live.aa.a
    public void cr(int i) {
        LinearLayout.LayoutParams layoutParams;
        int dimensionPixelOffset;
        if (this.gov != null && (this.gov.getLayoutParams() instanceof LinearLayout.LayoutParams) && (layoutParams = (LinearLayout.LayoutParams) this.gov.getLayoutParams()) != null) {
            if (i == 2) {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds10);
            } else {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds20);
            }
            layoutParams.topMargin = dimensionPixelOffset;
            this.gov.setLayoutParams(layoutParams);
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

    private void bTG() {
        if (this.gOo == null) {
            this.gOo = new CustomMessageListener(2913221) { // from class: com.baidu.tieba.yuyinala.charm.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof RedPacketCharmInfo)) {
                        a.this.a((RedPacketCharmInfo) customResponsedMessage.getData());
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.gOo);
        }
    }

    private void bTH() {
        if (this.gOo != null) {
            MessageManager.getInstance().unRegisterListener(this.gOo);
            this.gOo = null;
        }
    }

    private void bNZ() {
        this.gov = new PendantChildView(this.mContext) { // from class: com.baidu.tieba.yuyinala.charm.a.2
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
        this.gov.setBackgroundColor(0);
        if (this.gou != null) {
            this.gou.a(this.gov, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RedPacketCharmInfo redPacketCharmInfo) {
        int i;
        if (!b(redPacketCharmInfo)) {
            reset(false);
            if (this.gov != null) {
                this.gov.setVisibility(8);
                return false;
            }
            return false;
        }
        if (this.gov == null) {
            bNZ();
        }
        if (this.opy == null || (this.gov != null && this.gov.indexOfChild(this.opy) < 0)) {
            this.opy = new RedPacketCharmView(this.mContext);
            this.gov.addView(this.opy, new FrameLayout.LayoutParams(-2, -2));
            this.opy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bTI();
                }
            });
            this.gou.Pc();
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
        this.opy.setAvatar(redPacketCharmInfo.senderAvatar);
        switch (redPacketCharmInfo.status) {
            case 2:
                if (j > 60) {
                    this.opy.uh(1);
                } else if (j > 10) {
                    this.opy.uh(2);
                } else {
                    this.opy.uh(3);
                }
                if (c(redPacketCharmInfo)) {
                    this.opy.setCountDownTimer(String.valueOf(j), k.bw(1000 * j));
                    fh(j * 1000);
                    break;
                }
                break;
            case 3:
                bTJ();
                fi(0L);
                this.opy.uh(4);
                break;
            default:
                this.opy.uh(1);
                break;
        }
        this.gOl = redPacketCharmInfo;
        this.gov.setVisibility(this.gOn ? 0 : 8);
        return true;
    }

    private boolean b(RedPacketCharmInfo redPacketCharmInfo) {
        return (redPacketCharmInfo == null || TextUtils.isEmpty(redPacketCharmInfo.id) || (redPacketCharmInfo.status != 2 && redPacketCharmInfo.status != 3) || redPacketCharmInfo.count <= 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTI() {
        if (this.aDd != null && this.gOl != null) {
            di diVar = new di();
            diVar.aQQ = this.gOl.id;
            diVar.liveId = String.valueOf(this.aDd.mLiveInfo.live_id);
            diVar.aTJ = String.valueOf(this.aDd.mLiveInfo.user_uk);
            diVar.roomId = String.valueOf(this.aDd.mLiveInfo.room_id);
            diVar.time = this.opz.longValue();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913134, diVar));
        }
    }

    private boolean c(RedPacketCharmInfo redPacketCharmInfo) {
        return this.gOl == null || TextUtils.isEmpty(this.gOl.id) || !this.gOl.id.equals(redPacketCharmInfo.id) || this.gOl.status != redPacketCharmInfo.status || this.gOl.startTime <= 0 || this.gOl.startTime != redPacketCharmInfo.startTime;
    }

    private void fh(long j) {
        bTJ();
        this.gOm = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.yuyinala.charm.a.4
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                if (a.this.opy != null) {
                    long round = Math.round(j2 / 1000.0d);
                    a.this.opz = Long.valueOf(round);
                    a.this.opy.setCountDownTimer(String.valueOf(round), k.bw(1000 * round));
                    if (round > 10 && round <= 60) {
                        a.this.opy.uh(2);
                    } else if (round <= 10) {
                        a.this.opy.uh(3);
                    }
                    a.this.fi(round);
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                int i;
                if (a.this.opy != null) {
                    a.this.opy.uh(4);
                    if (a.this.gOl != null) {
                        a aVar = a.this;
                        if (a.this.gOl.count > 1) {
                            i = a.this.gOl.count - 1;
                        } else {
                            i = 0;
                        }
                        aVar.uf(i);
                    }
                    a.this.fi(0L);
                }
            }
        };
        this.gOm.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uf(int i) {
        if (this.opy != null) {
            String str = "";
            if (i > 99) {
                str = "99+";
            } else if (i >= 1) {
                str = String.valueOf(i);
            }
            this.opy.setBadge(TextUtils.isEmpty(str) ? false : true, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fi(long j) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913133, Long.valueOf(j)));
    }

    private void bTJ() {
        if (this.gOm != null) {
            this.gOm.cancel();
            this.opz = 0L;
        }
    }

    private void reset(boolean z) {
        if (z) {
            bTH();
        }
        this.gOn = true;
        this.gOl = null;
        bTJ();
        mv(z);
    }

    private void mv(boolean z) {
        if (this.opy != null) {
            this.opy.release();
            if (this.opy.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.opy.getParent()).removeView(this.opy);
                if (this.gou != null) {
                    this.gou.Pc();
                }
            }
        }
        if (z && this.gov != null && (this.gov.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gov.getParent()).removeView(this.gov);
        }
    }
}
