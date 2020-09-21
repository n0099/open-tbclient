package com.baidu.tieba.play.operableVideoView;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.util.ai;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.cyberPlayer.TbVideoViewSet;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.h;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.o;
import com.baidu.tieba.view.SwitchImageView;
import java.lang.ref.WeakReference;
import tbclient.McnAdInfo;
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.play.operableVideoView.a {
    private String aig;
    protected BdUniqueId aih;
    protected String alA;
    protected long alB;
    protected TbImageView alq;
    private ImageView alr;
    private ImageView als;
    protected TextView alt;
    protected TextView alu;
    private TextView alv;
    protected boolean alz;
    protected TbCyberVideoView fHb;
    private com.baidu.mcn.c iDA;
    private j jYV;
    private View lDF;
    private TBLottieAnimationView lDG;
    private PercentSizeView lDH;
    protected SwitchImageView lDI;
    protected SwitchImageView lDJ;
    protected OperableVideoMediaControllerView lDK;
    protected OperableVideoNetworkStateTipView lDL;
    protected OperableVideoShareView lDM;
    protected ImageView lDN;
    protected View lDO;
    protected VideoGestureView lDP;
    private View lDQ;
    private OperableVideoErrorView lDR;
    protected ViewGroup lDS;
    protected boolean lDT;
    protected int lDU;
    protected o lDV;
    protected bw lDW;
    private float lDZ;
    private float lEa;
    private int lEb;
    private int lEd;
    private boolean lEe;
    private float lEh;
    private int lEi;
    private McnAdInfo lEj;
    private a lEk;
    protected Context mContext;
    protected long mFid;
    protected String mFrom;
    private GestureDetector mGestureDetector;
    private View mRootView;
    protected String mVideoUrl;
    protected int lDd = 3000;
    protected final int lDe = 1;
    protected final int lDf = 2;
    protected final int lDg = 4;
    protected final int lDh = 8;
    protected final int lDi = 16;
    protected final int lDj = 32;
    protected final int lDk = 64;
    protected final int lDl = 128;
    protected final int lDm = 256;
    protected final int lDn = 512;
    protected final int lDo = 1024;
    protected final int lDp = 2048;
    protected final int lDq = 4096;
    protected final int lDr = 8192;
    protected int lDs = 8211;
    protected int lDt = 0;
    protected int lDu = 4;
    protected int lDv = 232;
    protected int lDw = 8416;
    protected int lDx = 0;
    protected int lDy = 513;
    protected int lDz = 259;
    protected int lDA = 2048;
    protected int lDB = 0;
    protected int STATE_ERROR = 4099;
    protected int lDC = this.lDs;
    private int leB = 0;
    private int lDD = -1;
    private Runnable lDE = new Runnable() { // from class: com.baidu.tieba.play.operableVideoView.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.Fr(d.this.lDt);
        }
    };
    private WeakReference<Context> alw = null;
    protected boolean kHN = false;
    protected boolean lDX = true;
    private boolean lDY = false;
    private int[] lEc = new int[2];
    private int lEf = 0;
    private int lEg = 0;
    protected View.OnClickListener aiW = null;
    protected View.OnClickListener afr = null;
    private boolean afB = false;
    private long startPosition = -1;
    private f.b lEl = new f.b() { // from class: com.baidu.tieba.play.operableVideoView.d.4
        @Override // com.baidu.tieba.play.f.b
        public void ca(int i, int i2) {
            if (d.this.startPosition <= 0) {
                d.this.startPosition = i2;
            }
            if (d.this.dou() && !d.this.alz && !d.this.kHN && d.this.afB) {
                if (!com.baidu.mcn.b.TD().m29if(d.this.lEj.jump_url)) {
                    boolean z = ((long) i2) >= d.this.lEj.ad_start_time.longValue() * 1000 && ((long) i2) < d.this.lEj.ad_end_time.longValue() * 1000;
                    boolean z2 = d.this.startPosition >= (d.this.lEj.ad_start_time.longValue() * 1000) + 1000;
                    if (z) {
                        if (!d.this.iDA.isShowing()) {
                            com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                            aVar.bDr = d.this.lEj.card_title;
                            aVar.bDs = d.this.lEj.button_title;
                            aVar.bDt = d.this.lEj.jump_url;
                            aVar.bDq = d.this.lEj.pic_url;
                            aVar.fid = String.valueOf(d.this.mFid);
                            aVar.tid = d.this.alA;
                            aVar.bDu = d.this.cCq();
                            if (z2) {
                                d.this.iDA.b(aVar, (ViewGroup) d.this.mRootView);
                            } else {
                                d.this.iDA.a(aVar, (ViewGroup) d.this.mRootView);
                            }
                        }
                    } else if (d.this.iDA.isShowing()) {
                        d.this.iDA.dismiss();
                    }
                } else {
                    return;
                }
            }
            if (d.this.lEk != null) {
                d.this.lEk.cD(i, i2);
            }
        }
    };
    private SeekBar.OnSeekBarChangeListener fsv = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.operableVideoView.d.8
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            d.this.Fr(d.this.lDv);
            seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
            seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb_pressed));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (seekBar != null && seekBar.getProgress() < seekBar.getMax()) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb));
                if (!d.this.fHb.isPlaying()) {
                    d.this.fHb.a(d.this.lEm);
                }
                d.this.dok();
                if (d.this.lDX) {
                    TiebaStatic.log(new aq("c13355").dF("tid", d.this.alA).u("fid", d.this.mFid).ai("obj_type", d.this.alz ? 1 : 2).ai("obj_locate", d.this.kHN ? 1 : 2));
                }
            }
        }
    };
    private GestureDetector.SimpleOnGestureListener imc = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.play.operableVideoView.d.9
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (d.this.fHb.isPlaying()) {
                d.this.fHb.pause();
                if (d.this.lDC == d.this.lDv) {
                    d.this.Fr(d.this.lDw);
                } else {
                    d.this.Fr(d.this.lDx);
                }
                d.this.Fs(R.id.video_pause);
            } else if (d.this.lDC == d.this.lDw || d.this.lDC == (d.this.lDw | 1)) {
                d.this.Fr(d.this.lDv);
                d.this.dok();
                d.this.fHb.a(d.this.lEm);
                d.this.Fs(R.id.video_play);
            } else if (d.this.lDC == d.this.lDx || d.this.lDC == (d.this.lDx | 1)) {
                d.this.Fr(d.this.lDt);
                d.this.fHb.a(d.this.lEm);
                d.this.Fs(R.id.video_play);
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (d.this.fHb.isPlaying()) {
                if (d.this.lDC == d.this.lDt || d.this.lDC == d.this.lDu) {
                    d.this.Fr(d.this.lDv);
                    d.this.dok();
                    return true;
                } else if (d.this.lDC == d.this.lDv) {
                    d.this.Fr(d.this.lDt);
                    return true;
                } else {
                    return true;
                }
            } else if (d.this.lDC == d.this.lDw) {
                d.this.Fr(d.this.lDx);
                return true;
            } else if (d.this.lDC == (d.this.lDw | 1)) {
                d.this.Fr(d.this.lDx | 1);
                return true;
            } else if (d.this.lDC == d.this.lDx) {
                d.this.Fr(d.this.lDw);
                return true;
            } else if (d.this.lDC == (d.this.lDx | 1)) {
                d.this.Fr(d.this.lDw | 1);
                return true;
            } else {
                d.this.Fr(d.this.lDs);
                d.this.startPlay();
                d.this.dop();
                return true;
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            d.this.leB = 0;
            if (d.this.kHN) {
                d.this.k((Activity) d.this.mContext, true);
            }
            return super.onDown(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (!d.this.ab(motionEvent)) {
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            if ((d.this.mContext instanceof BaseFragmentActivity) && ((BaseFragmentActivity) d.this.mContext).isSwipeBackEnabled()) {
                ((BaseFragmentActivity) d.this.mContext).disableSwipeJustOnce();
            } else if ((d.this.mContext instanceof BaseActivity) && ((BaseActivity) d.this.mContext).isSwipeBackEnabled()) {
                ((BaseActivity) d.this.mContext).disableSwipeJustOnce();
            }
            if (d.this.alz && d.this.diO()) {
                int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                switch (d.this.leB) {
                    case 0:
                        if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                            if (d.this.fHb.isPlaying()) {
                                d.this.fHb.pause();
                                d.this.Fr(d.this.lDB);
                            }
                            d.this.leB = 4;
                            d.this.lDD = d.this.lDC;
                            d.this.lDC = d.this.lDA;
                            d.this.lEd = d.this.lDS.getMeasuredHeight();
                            d.this.lEh = d.this.lEa / d.this.lEd;
                            d.this.lEi = (int) (1.2f * d.this.mRootView.getWidth());
                            dd(rawX, rawY);
                            break;
                        }
                        break;
                    case 4:
                        dd(rawX, rawY);
                        break;
                }
            } else if (d.this.lDC == d.this.lDt || d.this.lDC == d.this.lDv || d.this.lDC == d.this.lDw || d.this.lDC == d.this.lDx || d.this.lDC == d.this.lDA || d.this.lDC == (d.this.lDw | 1) || d.this.lDC == (d.this.lDx | 1)) {
                switch (d.this.leB) {
                    case 0:
                        if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                            d.this.leB = 3;
                            d.this.lEb = d.this.fHb.getCurrentPosition();
                            aB(f);
                        } else if (motionEvent.getX() < d.this.lDS.getWidth() / 2) {
                            d.this.leB = 2;
                            d.this.lDP.t(d.this.mContext, f2 > 0.0f);
                        } else {
                            d.this.leB = 1;
                            d.this.lDP.s(d.this.mContext, f2 > 0.0f);
                        }
                        if (d.this.lDC != d.this.lDA) {
                            if ((d.this.lDC & 1) > 0) {
                                d.this.lDA |= 1;
                            } else {
                                d.this.lDA &= -2;
                            }
                            d.this.Fr(d.this.lDA);
                            break;
                        }
                        break;
                    case 1:
                        d.this.lDP.s(d.this.mContext, f2 > 0.0f);
                        if (f2 > 0.0f) {
                            d.this.diS();
                            break;
                        }
                        break;
                    case 2:
                        d.this.lDP.t(d.this.mContext, f2 > 0.0f);
                        break;
                    case 3:
                        aB(f);
                        break;
                }
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        private void dd(int i, int i2) {
            if (d.this.lEf != i2 || d.this.lEg != i) {
                d.this.lEe = d.this.lEf - i2 > 0 || ((float) i2) < d.this.lDZ / 6.0f;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.lDS.getLayoutParams();
                if (i2 != d.this.lEf) {
                    int i3 = d.this.lEd - i2;
                    int i4 = (int) (i3 * d.this.lEh);
                    if (i4 < d.this.lEi) {
                        i4 = d.this.lEi;
                        i3 = (int) (i4 / d.this.lEh);
                    }
                    if (i4 != d.this.lEi) {
                        layoutParams.height = i3;
                        layoutParams.width = i4;
                        d.this.lDS.setLayoutParams(layoutParams);
                    }
                    d.this.lEf = i2;
                    d.this.lDS.setTranslationY(d.this.lEf);
                }
                if (i != d.this.lEf) {
                    d.this.lEg = i;
                    d.this.lDS.setTranslationX(d.this.lEg + ((d.this.lEa - layoutParams.width) / 2.0f));
                }
                d.this.lDQ.setAlpha((layoutParams.width - d.this.lEi) / (d.this.lEa - d.this.lEi));
                if (d.this.lDM.getVisibility() == 0) {
                    float f = d.this.lDZ / 6.0f;
                    float f2 = (f - i2) / f;
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                    d.this.lDM.setAlpha(f2);
                }
            }
        }

        private void aB(float f) {
            boolean z;
            if (f > 0.0f) {
                d.this.lEb -= 1000;
                z = true;
            } else {
                d.this.lEb += 1000;
                z = false;
            }
            int duration = d.this.fHb.getDuration();
            if (d.this.lEb < 0) {
                d.this.lEb = 0;
            } else if (d.this.lEb > duration) {
                d.this.lEb = duration;
            }
            String str = at.stringForVideoTime(d.this.lEb) + " / " + at.stringForVideoTime(duration);
            if (d.this.lDP != null) {
                d.this.lDP.B(z, str);
            }
            d.this.lDK.setCurrentDuration(d.this.lEb, false);
        }
    };
    private View.OnTouchListener eYy = new View.OnTouchListener() { // from class: com.baidu.tieba.play.operableVideoView.d.10
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && d.this.lDC == d.this.lDA) {
                if (d.this.leB == 4) {
                    d.this.dos();
                    d.this.lEf = 0;
                    d.this.lEg = 0;
                } else {
                    d.this.lDC = -1;
                    if (d.this.leB != 3) {
                        if (d.this.lDD != -1) {
                            d.this.Fr(d.this.lDD);
                            d.this.lDD = -1;
                        } else if (d.this.fHb.isPlaying()) {
                            d.this.Fr(d.this.lDt);
                        } else {
                            d.this.Fr(d.this.lDw);
                        }
                    } else {
                        d.this.lDK.setCurrentDuration(d.this.lEb, true);
                        if (d.this.lEb <= d.this.fHb.getDuration()) {
                            if (!d.this.fHb.isPlaying()) {
                                d.this.fHb.a(d.this.lEm);
                            }
                            d.this.Fr(d.this.lDt);
                        }
                    }
                }
                if (d.this.lDX) {
                    String str = null;
                    if (d.this.leB != 1) {
                        if (d.this.leB != 2) {
                            if (d.this.leB == 3) {
                                str = "c13362";
                            }
                        } else {
                            str = "c13346";
                        }
                    } else {
                        str = "c13361";
                    }
                    if (!at.isEmpty(str)) {
                        TiebaStatic.log(new aq(str).dF("tid", d.this.alA).u("fid", d.this.mFid));
                    }
                }
                d.this.leB = 0;
                return true;
            }
            return d.this.mGestureDetector.onTouchEvent(motionEvent);
        }
    };
    private TbVideoViewSet.a lEm = new TbVideoViewSet.a() { // from class: com.baidu.tieba.play.operableVideoView.d.11
        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void doc() {
            d.this.fHb.dnY();
            d.this.doj();
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void dod() {
            d.this.Fr(d.this.lDs);
            d.this.bGs();
        }
    };
    private final CustomMessageListener dWI = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.play.operableVideoView.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                d.this.stopPlay();
            }
        }
    };
    private final CustomMessageListener lEn = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.play.operableVideoView.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (d.this.isPlaying()) {
                        ai.a(d.this.alw, true);
                    }
                    d.this.fHb.setVolume(1.0f, 1.0f);
                    d.this.lDI.setState(0);
                    TbSingleton.getInstance().setVideoCardMute(false);
                    return;
                }
                d.this.diM();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void cD(int i, int i2);
    }

    public d(Context context, View view) {
        if (context != null && view != null) {
            this.mContext = context;
            this.mRootView = view;
            this.lDZ = l.getEquipmentHeight(this.mContext);
            this.lEa = l.getEquipmentWidth(this.mContext);
            init();
        }
    }

    public int getLayoutR() {
        return R.layout.operable_video_container;
    }

    public void diQ() {
        int dimension;
        int i;
        int i2;
        this.lDL.at(this.alz, this.kHN);
        this.lDM.at(this.alz, this.kHN);
        if (this.mContext != null && this.mContext.getResources() != null) {
            if (this.alz) {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension;
                i2 = dimension;
            } else if (this.kHN) {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds78);
                i = dimension;
                i2 = dimension;
            } else {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension;
                i2 = dimension;
            }
            this.alt.setPadding(0, 0, i2, 0);
            this.lDJ.setPadding(this.lDJ.getPaddingLeft(), 0, i, 0);
            this.lDI.setPadding(dimension, 0, 0, 0);
        }
    }

    public void diP() {
        if (this.alz) {
            this.lDv = 104;
            this.lDw = 8290;
        } else {
            this.lDv = 232;
            this.lDw = 8418;
        }
        if (this.kHN) {
            this.lDs |= 1024;
            this.lDt |= 1024;
            this.lDu |= 1024;
            this.lDv |= 1024;
            this.lDw |= 1024;
            this.lDx |= 1024;
            this.lDy |= 1024;
            this.lDz |= 1024;
            this.lDC |= 1024;
            return;
        }
        this.lDs &= -1025;
        this.lDt &= -1025;
        this.lDu &= -1025;
        this.lDv &= -1025;
        this.lDw &= -1025;
        this.lDx &= -1025;
        this.lDy &= -1025;
        this.lDz &= -1025;
        this.lDC &= -1025;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        if (this.mContext != null) {
            this.lDS = (ViewGroup) LayoutInflater.from(this.mContext).inflate(getLayoutR(), (ViewGroup) null);
            if (this.mRootView instanceof ViewGroup) {
                ((ViewGroup) this.mRootView).addView(this.lDS);
            }
            this.alw = new WeakReference<>(TbadkCoreApplication.getInst());
            this.alq = (TbImageView) this.lDS.findViewById(R.id.video_thumbnail);
            this.lDF = this.lDS.findViewById(R.id.black_mask);
            this.lDG = (TBLottieAnimationView) this.lDS.findViewById(R.id.video_loading);
            this.alr = (ImageView) this.lDS.findViewById(R.id.video_play);
            this.lDH = (PercentSizeView) this.lDS.findViewById(R.id.video_media_controller_mask);
            this.als = (ImageView) this.lDS.findViewById(R.id.video_pause);
            this.alt = (TextView) this.lDS.findViewById(R.id.video_play_count);
            this.alu = (TextView) this.lDS.findViewById(R.id.video_play_flag);
            this.alv = (TextView) this.lDS.findViewById(R.id.video_duration);
            this.lDI = (SwitchImageView) this.lDS.findViewById(R.id.video_mute);
            this.lDJ = (SwitchImageView) this.lDS.findViewById(R.id.video_full_screen);
            this.lDK = (OperableVideoMediaControllerView) this.lDS.findViewById(R.id.video_media_controller);
            this.lDL = (OperableVideoNetworkStateTipView) this.lDS.findViewById(R.id.video_network_state_tip);
            this.lDM = (OperableVideoShareView) this.lDS.findViewById(R.id.video_share_view);
            this.lDO = this.lDS.findViewById(R.id.video_back_btn_mask);
            this.lDN = (ImageView) this.lDS.findViewById(R.id.video_full_screen_back);
            this.lDP = (VideoGestureView) this.lDS.findViewById(R.id.video_gesture);
            this.lDR = (OperableVideoErrorView) this.lDS.findViewById(R.id.video_error_layout);
            this.lDM.setVideoContainer(this);
            this.lDG.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.lDG.setVisibility(8);
                    d.this.alr.setVisibility(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.lDG.setAnimation(R.raw.lotti_video_loading);
            SvgManager.bkl().a(this.alr, R.drawable.ic_icon_pure_video_play44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            this.alr.setOnClickListener(this);
            this.lDI.setSvgStateImage(new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_sound24_svg, R.color.cp_cont_a), new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_silent24_svg, R.color.cp_cont_a));
            this.lDI.setState(1);
            this.lDI.setOnClickListener(this);
            this.alq.bxw();
            this.alq.setDrawCorner(false);
            this.alq.setPlaceHolder(3);
            com.baidu.tbadk.a.b.a.h(this.lDF, R.color.cp_mask_b_alpha50);
            this.lDK.setOnSeekBarChangeListener(this.fsv);
            this.lDH.setHeightPercent(0.583f);
            this.lDH.setBackgroundResource(R.drawable.video_mask_bg);
            this.lDJ.setSvgStateImage(new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_fullscreen24_svg, R.color.cp_cont_a), new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_smallscreen24_svg, R.color.cp_cont_a));
            this.lDJ.setState(0);
            this.lDJ.setOnClickListener(this);
            SvgManager.bkl().a(this.als, R.drawable.ic_icon_pure_video_pause44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            this.als.setOnClickListener(this);
            this.lDN.setOnClickListener(this);
            this.fHb = new TbCyberVideoView(this.mContext);
            this.fHb.setTryUseViewInSet(true);
            doj();
            this.lDL.setPlayViewOnClickListener(this);
            this.lDS.setOnClickListener(null);
            this.lDS.setOnTouchListener(this.eYy);
            this.lDM.setOnTouchListener(this.eYy);
            this.lDR.setOutOnClickListener(this);
            this.mGestureDetector = new GestureDetector(this.mContext, this.imc);
            Fr(this.lDs);
            this.iDA = new com.baidu.mcn.c(this.mContext);
        }
    }

    public void doj() {
        if (this.fHb != null && this.fHb.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.lDS.addView(this.fHb.getView(), 0);
            this.fHb.getView().setLayoutParams(layoutParams);
            this.lDK.setPlayer(this.fHb);
            this.fHb.setContinuePlayEnable(true);
            this.fHb.setOnPreparedListener(this);
            this.fHb.setOnCompletionListener(this);
            this.fHb.setOnErrorListener(this);
            this.fHb.setOnSurfaceDestroyedListener(this);
            this.fHb.setOnInfoListener(this);
            this.fHb.setVideoStatData(this.lDV);
            this.fHb.setThreadDataForStatistic(this.lDW);
            this.fHb.getMediaProgressObserver().a(this.lEl);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setData(bw bwVar) {
        if (bwVar != null && bwVar.bfQ() != null) {
            this.startPosition = -1L;
            if (this.iDA != null) {
                this.iDA.reset();
            }
            if (!at.equals(this.mVideoUrl, bwVar.bfQ().video_url)) {
                stopPlay();
                this.alz = bwVar.bfQ().is_vertical.intValue() == 1;
                this.mVideoUrl = bwVar.bfQ().video_url;
                this.alA = bwVar.getTid();
                this.alB = bwVar.bfQ().video_length.intValue();
                this.lDU = bwVar.bfQ().video_duration.intValue();
                this.mFid = bwVar.getFid();
                this.lEj = bwVar.bfQ().mcn_ad_card;
                diP();
                diQ();
                Fr(this.lDs);
                int intValue = bwVar.bfQ().video_duration.intValue() * 1000;
                this.lDK.Gj(intValue);
                this.lDK.setPlayer(this.fHb);
                this.alv.setText(at.stringForVideoTime(intValue));
                this.alt.setText(String.format(this.mContext.getResources().getString(R.string.play_count_new), at.numFormatOverWan(bwVar.bfQ().play_count.intValue())));
                this.lDL.setVideoLength(bwVar.bfQ().video_length.intValue());
                this.lDL.setVideoDuration(bwVar.bfQ().video_duration.intValue());
                this.lDL.setTid(this.alA);
                this.lDW = bwVar;
                this.fHb.setThreadDataForStatistic(bwVar);
                this.alu.setVisibility(8);
                this.alq.setPlaceHolder(3);
                this.alq.startLoad(bwVar.bfQ().thumbnail_url, 10, false);
                this.lDM.setShareData(bwVar);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void b(o oVar) {
        if (this.fHb != null) {
            this.lDV = oVar;
            this.fHb.setVideoStatData(oVar);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aiW = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void ac(View.OnClickListener onClickListener) {
        this.afr = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void Gl(int i) {
        this.fHb.getRenderView().setDisplayMode(i);
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.aih = bdUniqueId;
    }

    public void dok() {
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.lDE);
        com.baidu.adp.lib.f.e.mX().postDelayed(this.lDE, this.lDd);
    }

    public void dol() {
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.lDE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGs() {
        this.lDG.setAlpha(1.0f);
        this.lDG.setVisibility(0);
        this.alr.setVisibility(8);
        if (this.lDG != null) {
            this.lDG.loop(true);
            this.lDG.setMinAndMaxFrame(14, 80);
            this.lDG.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void diN() {
        if (this.lDC == this.lDu) {
            Fr(this.lDt);
        }
    }

    private void dom() {
        Fr(this.lDu);
        this.lDK.showProgress();
        if (this.lDG != null) {
            this.lDG.clearAnimation();
            this.lDG.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.diN();
                    if (!d.this.lDT) {
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.lDG.setVisibility(8);
                    d.this.alr.setVisibility(8);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public boolean don() {
        return this.lDL != null && this.lDL.diX();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setStageType(String str) {
        this.aig = str;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (!StringUtils.isNull(this.mVideoUrl)) {
            MessageManager.getInstance().registerListener(this.dWI);
            MessageManager.getInstance().registerListener(this.lEn);
            if (don()) {
                Fr(this.lDz);
                return;
            }
            this.lDT = true;
            if (!this.fHb.isPlaying()) {
                TbCyberVideoView Pi = TbVideoViewSet.dob().Pi(this.mVideoUrl);
                if (Pi == null) {
                    this.fHb.dnY();
                    if (!StringUtils.isNull(this.fHb.getOriginUrl())) {
                        this.fHb = new TbCyberVideoView(this.mContext);
                        this.fHb.setTryUseViewInSet(true);
                    }
                    doj();
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.fHb.setVideoDuration(this.lDU);
                        this.fHb.setVideoPath(this.mVideoUrl, this.alA);
                        this.fHb.setStageType(this.aig);
                        bGs();
                        if (this.lDX) {
                            diV();
                        }
                    }
                } else {
                    if (this.fHb == Pi) {
                        if (this.fHb.getParent() == null || this.fHb.getParent() != Pi.getParent()) {
                            this.fHb.dnY();
                            doj();
                        }
                    } else {
                        this.fHb.dnY();
                        Pi.dnY();
                        this.fHb = Pi;
                        this.fHb.setTryUseViewInSet(true);
                        doj();
                    }
                    this.fHb.dnZ();
                    onPrepared();
                    dot();
                    if (this.lDX) {
                        diV();
                    }
                }
                if (this.lDX) {
                    TiebaStatic.log(new aq("c13357").dF("tid", this.alA).u("fid", this.mFid).ai("obj_type", this.alz ? 1 : 2).ai("obj_source", TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).ai("obj_locate", 1));
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        this.lDT = false;
        if (this.lDG != null) {
            this.lDG.cancelAnimation();
        }
        this.fHb.stop();
        this.fHb.dnY();
        this.lDK.aIX();
        Fr(this.lDs);
        MessageManager.getInstance().unRegisterListener(this.dWI);
        MessageManager.getInstance().unRegisterListener(this.lEn);
    }

    private void doo() {
        this.lDT = false;
        if (this.lDG != null) {
            this.lDG.cancelAnimation();
        }
        this.fHb.stop();
        this.lDK.aIX();
        Fr(this.lDs);
        MessageManager.getInstance().unRegisterListener(this.dWI);
        MessageManager.getInstance().unRegisterListener(this.lEn);
    }

    public void diV() {
        if (this.lDV != null) {
            o dnO = this.lDV.dnO();
            dnO.mLocate = this.mFrom;
            h.a(dnO.lCk, "", "1", dnO, this.fHb.getPcdnState());
        }
    }

    public void Fr(int i) {
        dol();
        if (this.lDC == this.lDA) {
            this.lDD = i;
            return;
        }
        this.lDC = i;
        this.alq.setVisibility((i & 1) > 0 ? 0 : 8);
        this.lDF.setVisibility((i & 2) > 0 ? 0 : 8);
        boolean z = (i & 4) > 0;
        this.lDG.clearAnimation();
        this.lDG.setVisibility(z ? 0 : 8);
        if (!z) {
            this.lDG.cancelAnimation();
        } else {
            this.lDG.setAlpha(1.0f);
        }
        this.alr.setVisibility((i & 8192) > 0 ? 0 : 8);
        this.als.setVisibility((i & 8) > 0 ? 0 : 8);
        this.alt.setVisibility((i & 16) > 0 ? 0 : 8);
        this.alv.setVisibility((i & 16) > 0 ? 0 : 8);
        this.lDI.setVisibility((i & 32) > 0 ? 0 : 8);
        this.lDJ.setVisibility((i & 64) > 0 ? 0 : 8);
        this.lDK.setVisibility((i & 128) > 0 ? 0 : 8);
        this.lDH.setVisibility((i & 128) > 0 ? 0 : 8);
        if (this.lDK.getVisibility() == 0) {
            this.lDK.showProgress();
        }
        this.lDL.setVisibility((i & 256) > 0 ? 0 : 8);
        this.lDM.setVisibility((i & 512) > 0 ? 0 : 8);
        if (this.lDM.getVisibility() == 0) {
            this.lDM.setAlpha(1.0f);
        }
        this.lDN.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.lDO.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.lDP.setVisibility((i & 2048) > 0 ? 0 : 8);
        this.lDR.setVisibility((i & 4096) <= 0 ? 8 : 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            Fs(id);
            if (id == R.id.video_mute) {
                doq();
            } else if (id == R.id.video_full_screen || id == R.id.video_full_screen_back) {
                dos();
            } else if (id == R.id.video_replay) {
                Fr(this.lDs);
                startPlay();
                if (this.lDX) {
                    TiebaStatic.log(new aq("c13345").dF("tid", this.alA).u("fid", this.mFid).ai("obj_type", this.alz ? 1 : 2).ai("obj_locate", this.kHN ? 1 : 2));
                }
                dop();
            } else if (id == R.id.video_play) {
                if (this.lDC == this.lDs) {
                    startPlay();
                } else {
                    Fr(this.lDv);
                    dok();
                    this.fHb.a(this.lEm);
                }
                if (this.lDX) {
                    TiebaStatic.log(new aq("c13344").dF("tid", this.alA).u("fid", this.mFid).ai("obj_type", this.alz ? 1 : 2).ai("obj_source", this.kHN ? 1 : 2).ai("obj_locate", 1));
                }
                dop();
            } else if (id == R.id.video_pause) {
                Fr(this.lDw);
                dol();
                this.fHb.pause();
                if (this.lDX) {
                    TiebaStatic.log(new aq("c13344").dF("tid", this.alA).u("fid", this.mFid).ai("obj_type", this.alz ? 1 : 2).ai("obj_source", this.kHN ? 1 : 2).ai("obj_locate", 2));
                }
            } else if (id == R.id.play) {
                Fr(this.lDs);
                startPlay();
            } else if (id == R.id.retry) {
                Fr(this.lDs);
                startPlay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dop() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.mVideoUrl);
        CustomMessage customMessage = new CustomMessage(2921387);
        customMessage.setTag(this.aih);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    protected void diM() {
        if (TbSingleton.getInstance().isVideoCardMute()) {
            this.fHb.setVolume(0.0f, 0.0f);
            this.lDI.setState(1);
            return;
        }
        this.fHb.setVolume(1.0f, 1.0f);
        this.lDI.setState(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doq() {
        boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
        if (isVideoCardMute) {
            this.fHb.setVolume(1.0f, 1.0f);
            ai.a(this.alw, true);
            this.lDI.setState(0);
        } else {
            this.fHb.setVolume(0.0f, 0.0f);
            this.lDI.setState(1);
            ai.a(this.alw, false);
        }
        TbSingleton.getInstance().setVideoCardMute(isVideoCardMute ? false : true);
    }

    public void vm(boolean z) {
        if (this.jYV == null) {
            this.jYV = new j((Activity) this.mContext);
        }
        if (z) {
            this.jYV.start();
            this.jYV.cu(true);
            return;
        }
        this.jYV.stop();
        this.jYV.cu(false);
    }

    public void dor() {
        uv(true);
    }

    public void uv(boolean z) {
        if (this.mRootView != null && this.lDS != null && this.fHb != null) {
            if (this.mContext != null) {
                l.hideSoftKeyPad(this.mContext, this.mRootView);
            }
            if (this.jYV == null) {
                this.jYV = new j((Activity) this.mContext);
            }
            if (this.kHN) {
                if (this.lDQ.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.lDQ.getParent()).removeView(this.lDQ);
                }
                if ((this.lDS.getParent() instanceof ViewGroup) && (this.mRootView instanceof ViewGroup)) {
                    this.kHN = false;
                    this.lDY = true;
                    ((ViewGroup) this.lDS.getParent()).removeView(this.lDS);
                    ((ViewGroup) this.mRootView).addView(this.lDS);
                    this.lDY = false;
                    k((Activity) this.mContext, this.kHN);
                }
                if (!this.alz && z) {
                    this.jYV.OK();
                }
            } else {
                if (this.mContext != null) {
                    if (!this.alz && z) {
                        this.jYV.OK();
                    }
                    if (this.mContext instanceof Activity) {
                        this.lDS.getLocationOnScreen(this.lEc);
                        View findViewById = ((Activity) this.mContext).findViewById(16908290);
                        if (findViewById instanceof ViewGroup) {
                            View childAt = ((ViewGroup) findViewById).getChildAt(0);
                            if (childAt instanceof ViewGroup) {
                                this.lDY = true;
                                ((ViewGroup) this.mRootView).removeAllViews();
                                if (this.lDQ == null) {
                                    this.lDQ = new View(this.mContext);
                                    this.lDQ.setClickable(true);
                                    this.lDQ.setBackgroundColor(ap.getColor(R.color.black_alpha100));
                                    this.lDQ.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (this.lDQ.getParent() instanceof ViewGroup) {
                                    ((ViewGroup) this.lDQ.getParent()).removeView(this.lDQ);
                                }
                                this.lDQ.setAlpha(1.0f);
                                ((ViewGroup) childAt).addView(this.lDQ);
                                ((ViewGroup) childAt).addView(this.lDS);
                                this.lDY = false;
                                this.kHN = true;
                                k((Activity) this.mContext, this.kHN);
                                if (this.iDA != null && this.iDA.isShowing()) {
                                    this.iDA.dismiss();
                                }
                            }
                        }
                    }
                }
                if (this.lDX) {
                    TiebaStatic.log(new aq("c13360").dF("tid", this.alA).u("fid", this.mFid).ai("obj_type", this.alz ? 1 : 2));
                }
            }
            diP();
            diQ();
            if (this.fHb.isPlaying()) {
                Fr(this.lDt);
            } else {
                Fr(this.lDC);
            }
            this.lDJ.dJr();
            vn(this.kHN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dos() {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        ObjectAnimator ofFloat4;
        ObjectAnimator ofFloat5;
        ObjectAnimator ofFloat6;
        ObjectAnimator ofFloat7;
        if (!this.alz) {
            dor();
        } else if (this.lDC == this.lDA) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.7
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.lDS.setScaleX(1.0f);
                    d.this.lDS.setScaleY(1.0f);
                    d.this.lDS.setTranslationX(0.0f);
                    d.this.lDS.setTranslationY(0.0f);
                    d.this.lDM.setScaleX(1.0f);
                    d.this.lDM.setScaleY(1.0f);
                    d.this.lDS.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    if (!d.this.lEe) {
                        d.this.dor();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            ObjectAnimator objectAnimator = null;
            if (!this.lEe) {
                float width = this.mRootView.getWidth() / this.lDS.getWidth();
                float height = this.mRootView.getHeight() / this.lDS.getHeight();
                this.lDS.setPivotX(0.0f);
                this.lDS.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.lDS, "ScaleX", 1.0f, width);
                ofFloat2 = ObjectAnimator.ofFloat(this.lDS, "ScaleY", 1.0f, height);
                ofFloat3 = ObjectAnimator.ofFloat(this.lDM, "ScaleX", 1.0f, 1.0f / width);
                ofFloat4 = ObjectAnimator.ofFloat(this.lDM, "ScaleY", 1.0f, 1.0f / height);
                ofFloat5 = ObjectAnimator.ofFloat(this.lDS, "TranslationX", this.lDS.getTranslationX(), this.lEc[0]);
                ofFloat6 = ObjectAnimator.ofFloat(this.lDS, "TranslationY", this.lDS.getTranslationY(), this.lEc[1]);
                objectAnimator = ObjectAnimator.ofFloat(this.lDQ, "alpha", this.lDQ.getAlpha(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.lDM, "alpha", this.lDM.getAlpha(), 0.0f);
            } else {
                float width2 = this.lEa / this.lDS.getWidth();
                float height2 = this.lEd / this.lDS.getHeight();
                this.lDS.setPivotX(0.0f);
                this.lDS.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.lDS, "ScaleX", 1.0f, width2);
                ofFloat2 = ObjectAnimator.ofFloat(this.lDS, "ScaleY", 1.0f, height2);
                ofFloat3 = ObjectAnimator.ofFloat(this.lDM, "ScaleX", 1.0f, 1.0f / width2);
                ofFloat4 = ObjectAnimator.ofFloat(this.lDM, "ScaleY", 1.0f, 1.0f / height2);
                ofFloat5 = ObjectAnimator.ofFloat(this.lDS, "TranslationX", this.lDS.getTranslationX(), 0.0f);
                ofFloat6 = ObjectAnimator.ofFloat(this.lDS, "TranslationY", this.lDS.getTranslationY(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.lDM, "alpha", this.lDM.getAlpha(), 1.0f);
            }
            if (objectAnimator != null) {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(objectAnimator).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            } else {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            }
            animatorSet.start();
            if (this.lDD != -1) {
                this.lDC = this.lDD;
                this.lDD = -1;
                if (this.lDC == this.lDB || this.lDC == this.lDv || this.lDC == this.lDt) {
                    this.fHb.a(this.lEm);
                    Fr(this.lDt);
                }
            }
        } else {
            dor();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(Activity activity, boolean z) {
        if (activity != null && activity.getWindow() != null) {
            if (this.alz && (TbSingleton.getInstance().isNotchScreen(activity) || TbSingleton.getInstance().isCutoutScreen(activity))) {
                if (this.lDS != null) {
                    if (z) {
                        this.lDS.setPadding(0, l.getStatusBarHeight((Activity) this.mContext), 0, 0);
                    } else {
                        this.lDS.setPadding(0, 0, 0, 0);
                    }
                }
            } else if (z) {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.flags |= 1024;
                activity.getWindow().setAttributes(attributes);
                cQr();
            } else {
                WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
                attributes2.flags &= -1025;
                activity.getWindow().setAttributes(attributes2);
                this.lDS.setSystemUiVisibility(0);
            }
        }
    }

    private void dot() {
        Fr(this.lDu);
        this.lDK.showProgress();
        dom();
    }

    protected void vn(boolean z) {
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        diM();
        if (this.lDT) {
            if (this.kHN && (this.mContext instanceof Activity)) {
                k((Activity) this.mContext, true);
            }
            this.fHb.a(this.lEm);
        }
    }

    public void onCompletion() {
        Fr(this.lDy);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        Fr(this.STATE_ERROR);
        return false;
    }

    @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
    public void onSurfaceDestroyed() {
        if (!this.lDY) {
            if (this.lDC == this.lDw || (this.lDC == this.lDx && !this.fHb.isPlaying())) {
                doo();
                Fr(this.lDw);
            } else if (this.lDC == this.lDy) {
                doo();
                Fr(this.lDy);
            } else {
                doo();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        if (i == 3 || i == 904) {
            dot();
            return false;
        }
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public View dnv() {
        return this.lDS;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        return this.lDT || this.fHb.isPlaying();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public int getCurrentPosition() {
        return this.fHb.getCurrentPosition();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void bLM() {
    }

    protected void Fs(int i) {
    }

    protected boolean ab(MotionEvent motionEvent) {
        return this.kHN;
    }

    protected boolean diO() {
        return this.alz && this.kHN;
    }

    private void cQr() {
        if (Build.VERSION.SDK_INT < 16) {
            this.lDS.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.lDS.setSystemUiVisibility(4);
        } else {
            this.lDS.setSystemUiVisibility(5894);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean diS() {
        if (TbSingleton.getInstance().isVideoCardMute() && this.fHb.isPlaying() && !ai.bwY()) {
            this.fHb.setVolume(1.0f, 1.0f);
            this.lDI.setState(0);
            TbSingleton.getInstance().setVideoCardMute(false);
        }
        return false;
    }

    public boolean diT() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean pX(boolean z) {
        if (z) {
            this.lDG.cancelAnimation();
            if (this.lDC == this.lDt || this.lDC == this.lDu || this.lDC == this.lDv || this.lDC == this.lDs) {
                stopPlay();
            }
            this.lDC |= 1;
            Fr(this.lDC);
        } else if (this.lDC == this.lDs) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isFullScreen() {
        return this.kHN;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean doh() {
        if (this.kHN) {
            dos();
            return true;
        }
        return false;
    }

    public String getVideoUrl() {
        return this.mVideoUrl;
    }

    protected int cCq() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dou() {
        return this.lEj != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void vo(boolean z) {
        this.afB = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar) {
        this.lEk = aVar;
    }
}
