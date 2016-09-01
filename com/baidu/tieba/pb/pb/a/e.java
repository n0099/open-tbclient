package com.baidu.tieba.pb.pb.a;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.TextureVideoView;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.cs;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class e extends cs<com.baidu.tieba.tbadkCore.data.q, y> {
    private final CustomMessageListener FQ;
    private String aMC;
    private CustomMessageListener aRp;
    private int aZu;
    private Runnable aZz;
    private MediaPlayer.OnErrorListener agI;
    private TextureVideoView.b agO;
    private CustomMessageListener ahA;
    private boolean cNk;
    private CustomMessageListener cNp;
    private CustomMessageListener cNq;
    private CustomMessageListener cNr;
    private CustomMessageListener cNs;
    private int cbA;
    private com.baidu.tieba.pb.data.h ekQ;
    private y ekR;
    private long ekS;
    private boolean ekT;
    private com.baidu.tieba.pb.a.d ekU;
    private int ekV;
    private boolean ekW;
    private boolean ekX;
    private View.OnTouchListener ekY;
    private Runnable ekZ;
    private CustomMessageListener ela;
    private Handler mHandler;
    private View mView;

    public e(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.ekQ = null;
        this.cNk = false;
        this.ekS = 0L;
        this.ekT = true;
        this.cbA = 0;
        this.ekU = null;
        this.aZu = 0;
        this.aMC = null;
        this.ekV = 0;
        this.ekW = true;
        this.ekX = false;
        this.agO = new f(this);
        this.mHandler = new q(this, Looper.getMainLooper());
        this.ekY = new r(this);
        this.ekZ = new s(this);
        this.ahA = new t(this, CmdConfigCustom.PB_ACTION_PRAISE);
        this.cNp = new u(this, CmdConfigCustom.PB_PAUSE_VIDEO);
        this.ela = new v(this, CmdConfigCustom.PB_RESTART_VIDEO);
        this.cNq = new w(this, CmdConfigCustom.PB_REFRESH_VIDEO);
        this.cNr = new x(this, CmdConfigCustom.PB_ON_SCROLL);
        this.cNs = new g(this, CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        this.aRp = new h(this, CmdConfigCustom.CMD_GRAFFITI_VOTE_SUCCESS);
        this.FQ = new i(this, 2000994);
        this.agI = new j(this);
        this.aZz = new k(this);
        if (pbActivity != null) {
            pbActivity.registerListener(this.ahA);
            pbActivity.registerListener(this.cNp);
            pbActivity.registerListener(this.ela);
            pbActivity.registerListener(this.cNq);
            pbActivity.registerListener(this.cNr);
            pbActivity.registerListener(this.cNs);
            pbActivity.registerListener(this.FQ);
            pbActivity.registerListener(this.aRp);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public y a(ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = LayoutInflater.from(this.mContext).inflate(t.h.pb_list_item_video, (ViewGroup) null);
            this.ekR = new y(this.mView);
            View findViewById = this.mView.findViewById(t.g.pb_layout_video_view);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            int K = com.baidu.adp.lib.util.k.K(this.mContext);
            if (layoutParams != null) {
                layoutParams.height = K;
                findViewById.setLayoutParams(layoutParams);
            }
        } else {
            aol();
        }
        return this.ekR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aol() {
        if (this.ekR != null && this.ekR.cQp != null) {
            d(false, 0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cs, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.q qVar, y yVar) {
        super.a(i, view, viewGroup, (ViewGroup) qVar, (com.baidu.tieba.tbadkCore.data.q) yVar);
        if (qVar != null && yVar != null) {
            yVar.aPh.setVideoStatsData(b(qVar));
            com.baidu.tbadk.widget.richText.o Ij = qVar.Ij();
            if (!this.cNk) {
                this.cNk = true;
                yVar.cQp.setDefaultErrorResource(0);
                yVar.cQp.setTag(Integer.valueOf(i));
                yVar.cQp.setDefaultResource(0);
                if (!com.baidu.tbadk.core.l.oG().oM()) {
                    yVar.cQp.setNoImageBottomTextColor(t.d.cp_cont_c);
                    yVar.cQp.setNoImageBottomTextPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds32));
                    yVar.cQp.setNoImageBottomTextSize(TbadkCoreApplication.m9getInst().getResources().getDimension(t.e.fontsize28));
                    yVar.cQp.setSupportNoImage(true);
                    yVar.cQp.setNoImageBottomText(TbadkCoreApplication.m9getInst().getString(t.j.click_to_play));
                } else {
                    yVar.cQp.setDefaultBgResource(t.f.pic_bg_video_frs);
                    if (!yVar.aPh.isPlaying()) {
                        a(qVar, yVar);
                    }
                }
                if (this.ekQ != null && this.ekQ.aLQ() != null && this.ekQ.aLQ().rP() == 1) {
                    yVar.cbl.setVisibility(8);
                    ViewGroup.LayoutParams layoutParams = yVar.cbm.getLayoutParams();
                    if (layoutParams instanceof LinearLayout.LayoutParams) {
                        ((LinearLayout.LayoutParams) layoutParams).topMargin = (int) this.emy.getPageContext().getResources().getDimension(t.e.ds34);
                        yVar.cbm.setLayoutParams(layoutParams);
                    }
                } else {
                    yVar.cbl.setTextSize(TbConfig.getContentSize());
                    yVar.cbl.setText(qVar.getTitle());
                    yVar.cbl.setVisibility(0);
                    yVar.cbl.setOnTouchListener(this.ekU);
                }
                yVar.aPh.setOnPreparedListener(new l(this, yVar, Ij, qVar));
                yVar.aPh.setOnCompletionListener(new m(this));
                yVar.aPh.setOnSurfaceDestroyedListener(this.agO);
                yVar.aPh.setOnErrorListener(this.agI);
                yVar.mRootView.setOnClickListener(new n(this, yVar));
                aMt();
            }
            com.baidu.tbadk.data.g bjf = qVar.bjf();
            if (bjf != null && !TextUtils.isEmpty(bjf.getName()) && !TextUtils.isEmpty(bjf.getName().trim())) {
                String name = bjf.getName();
                String lat = bjf.getLat();
                String lng = bjf.getLng();
                yVar.elj.setVisibility(0);
                com.baidu.adp.lib.util.k.a(this.mContext, yVar.elj, 0, 10, 0, 10);
                yVar.caL.setText(bjf.getName());
                av.c(yVar.caL, t.d.cp_link_tip_c, 1);
                yVar.elk.setImageDrawable(av.getDrawable(t.f.icon_pb_pin));
                yVar.elj.setOnClickListener(new o(this, lat, lng, name));
            } else {
                yVar.elk.setVisibility(8);
                yVar.caL.setVisibility(8);
            }
            PraiseData rt = this.ekQ.aLQ().rt();
            if (rt != null && rt.getUser() != null && rt.getUser().size() > 0) {
                yVar.ell.setIsFromPb(true);
                yVar.ell.setIsFromPbVideo(true);
                if (!yVar.elm.isShown()) {
                    yVar.elm.setVisibility(0);
                    yVar.ell.dl(this.mSkinType);
                }
                yVar.ell.a(rt, qVar.getId(), rt.getPostId(), true);
            } else {
                yVar.elm.setVisibility(8);
            }
            com.baidu.tieba.graffiti.d.al(yVar.ell);
            com.baidu.tieba.graffiti.d.al(yVar.elm);
            a(yVar, Ij);
            a(yVar);
            if (yVar.mSkinType != this.mSkinType) {
                av.l(view, t.d.cp_bg_line_d);
                av.c(yVar.cbl, t.d.cp_cont_b, 1);
                av.c(yVar.cbm, t.d.cp_cont_c, 1);
                av.c(yVar.cQt, t.f.icon_play_video);
                av.k(yVar.eln, t.f.icon_hand_normal_card_recommend);
                av.j((View) yVar.elo, t.d.cp_cont_d);
                av.l(yVar.mRootView, t.d.cp_bg_line_k);
                av.l(yVar.eli, t.d.cp_bg_line_k);
            }
            yVar.mSkinType = this.mSkinType;
        }
        return this.mView;
    }

    private TextureVideoView.c b(com.baidu.tieba.tbadkCore.data.q qVar) {
        TextureVideoView.c cVar = null;
        if (qVar != null) {
            cVar = new TextureVideoView.c();
            cVar.mLocate = "6";
            if (this.ekQ != null) {
                cVar.ahi = this.ekQ.getThreadId();
                cVar.ahj = this.ekQ.getForumId();
            }
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMs() {
        if (this.ekQ != null && this.ekQ.aLQ() != null && this.ekQ.aLQ().rR() != null) {
            com.baidu.tieba.play.h.d(this.ekQ.aLQ().rR().video_md5, this.ekQ.getThreadId(), this.ekQ.getForumId(), "pb", this.ekQ.KD());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.widget.richText.o oVar) {
        if (oVar != null) {
            this.cbA++;
            oVar.fA(this.cbA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(y yVar, com.baidu.tbadk.widget.richText.o oVar) {
        if (yVar != null && yVar.cbm != null && oVar != null) {
            if (oVar.IM() < this.cbA) {
                oVar.fA(this.cbA);
            } else {
                this.cbA = oVar.IM();
            }
            yVar.cbm.setText(String.format(this.emy.getPageContext().getResources().getString(t.j.video_play_count), ba.w(this.cbA)));
        }
    }

    private void a(y yVar) {
        if (yVar != null) {
            UserData userData = null;
            if (this.ekQ != null && this.ekQ.aLN() != null) {
                userData = (UserData) com.baidu.tbadk.core.util.y.c(this.ekQ.aLN().pV(), 0);
            }
            hR(a(yVar, userData) && this.ekW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hR(boolean z) {
        if (this.ekR != null) {
            if (z) {
                this.ekR.elo.setVisibility(0);
                this.ekR.eln.setVisibility(0);
                return;
            }
            this.ekR.elo.setVisibility(8);
            this.ekR.eln.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(y yVar, UserData userData) {
        if (yVar == null || userData == null || StringUtils.isNull(userData.getUserName())) {
            return false;
        }
        String string = this.mContext.getResources().getString(t.j.video_zan_tip);
        String d = ba.d(userData.getName_show(), 4, "...");
        SpannableString spannableString = new SpannableString(String.format(string, d));
        spannableString.setSpan(new ForegroundColorSpan(av.getColor(t.d.cp_link_tip_c)), 0, d.length(), 17);
        yVar.elo.setText(spannableString);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(this.emy.getPageContext().getPageActivity(), t.a.praise_animation_scale2));
            com.baidu.adp.lib.h.h.eG().postDelayed(this.ekZ, 200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(this.emy.getPageContext().getPageActivity(), t.a.praise_animation_scale3));
            com.baidu.adp.lib.h.h.eG().postDelayed(this.ekZ, 600L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aU(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this.emy.getPageContext().getPageActivity(), t.a.praise_animation_scale1));
    }

    public void b(com.baidu.tieba.pb.data.h hVar) {
        this.ekQ = hVar;
    }

    public void hS(boolean z) {
        this.ekW = z;
    }

    private void a(com.baidu.tieba.tbadkCore.data.q qVar, y yVar) {
        com.baidu.tbadk.widget.richText.o Ij = qVar.Ij();
        if (Ij != null) {
            yVar.cQp.c(Ij.pS(), 17, false);
            yVar.cQp.setNoImageBottomText("");
            this.aMC = Ij.getVideoUrl();
            this.ekV = Ij.getDuration();
            if (StringUtils.isNull(Ij.pS())) {
                ay(Ij.getVideoUrl(), Ij.getDuration());
            } else {
                yVar.cQp.setEvent(new p(this, Ij));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ay(String str, int i) {
        if (this.emy != null && this.emy.aMG() != null && this.emy.aMG().getPbData() != null && this.emy.aMG().getPbData().getPage() != null && this.ekR != null && this.ekR.aPh != null) {
            if (this.aZu != 1 || !this.ekR.aPh.isPlaying()) {
                if (aMx()) {
                    if (this.aZu != 2) {
                        this.ekR.aPh.u(str, i);
                        d(false, 3);
                    } else {
                        d(false, 1);
                    }
                    this.ekR.aPh.start();
                } else {
                    d(true, 0);
                }
                this.emy.hY(true);
            }
        }
    }

    private void aMt() {
        if (this.ekQ != null) {
            String str = com.baidu.adp.lib.util.i.gn() ? "1" : "0";
            ay ayVar = new ay("c10643");
            ayVar.ab("fid", this.ekQ.getForumId());
            ayVar.ab("tid", this.ekQ.getThreadId());
            ayVar.ab("obj_type", str);
            TiebaStatic.log(ayVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoo() {
        if (this.ekR != null && this.ekR.aPh != null && this.ekR.cQt != null) {
            if (this.ekR.aPh.isPlaying()) {
                this.ekR.aPh.pause();
                d(false, 2);
            } else if (this.aZu == 3) {
                this.ekR.aPh.wv();
                d(false, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMu() {
        if (this.ekR != null && this.ekR.aPh != null && this.ekR.cQt != null) {
            if (aMx() && !this.ekR.aPh.isPlaying()) {
                if (this.aZu == 2) {
                    this.ekR.aPh.start();
                    d(false, 1);
                    return;
                }
                boolean oM = oM(this.aMC);
                if (this.aMC != null && oM && this.aZu != 2 && !this.ekX) {
                    this.ekR.aPh.u(this.aMC, this.ekV);
                    this.ekX = true;
                    d(false, 3);
                    this.ekR.aPh.start();
                    return;
                }
                aMs();
                d(false, 3);
                this.ekR.aPh.start();
            } else if (!aMx()) {
                d(false, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMv() {
        if (this.ekR != null && this.ekR.aPh != null && this.ekR.cQt != null) {
            if (aMx() && !this.ekR.aPh.isPlaying()) {
                boolean oM = oM(this.aMC);
                if (this.aMC != null && oM && this.aZu != 2 && !this.ekX) {
                    this.ekR.aPh.u(this.aMC, this.ekV);
                    this.ekX = true;
                    d(false, 3);
                    this.ekR.aPh.start();
                    return;
                }
                aMs();
                d(false, 1);
                this.ekR.aPh.start();
            } else if (!aMx()) {
                d(false, 0);
            }
        }
    }

    public void a(com.baidu.tieba.pb.a.d dVar) {
        this.ekU = dVar;
    }

    public void aMw() {
        if (this.ekR != null) {
            this.ekR.cbl.setTextSize(TbConfig.getContentSize());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z, int i) {
        if (this.ekR != null && this.ekR.cQp != null && this.ekR.cQt != null && this.ekR.elp != null && this.ekR.cbp != null && this.ekR.elr != null && this.ekR.elq != null && this.ekR.aZq != null && this.ekR.eli != null) {
            if (z || this.aZu != i) {
                this.aZu = i;
                this.ekR.cQt.setVisibility(8);
                this.ekR.elp.setVisibility(8);
                this.ekR.elp.bqi();
                this.ekR.aZq.setVisibility(8);
                this.ekR.cbp.setVisibility(8);
                this.ekR.cbp.setIndeterminate(false);
                this.ekR.elr.setVisibility(8);
                this.ekR.elq.setVisibility(8);
                this.ekR.cQp.setVisibility(8);
                com.baidu.adp.lib.h.h.eG().removeCallbacks(this.aZz);
                if (i == 0) {
                    this.ekR.cQp.setVisibility(0);
                    this.ekR.cQt.setVisibility(0);
                } else if (i == 1) {
                    this.ekR.elp.setVisibility(0);
                    this.ekR.elp.bqi();
                    this.ekR.elp.start();
                } else if (i == 3) {
                    this.ekR.aZq.setVisibility(0);
                    this.ekR.cbp.setVisibility(0);
                    this.ekR.cQp.setVisibility(0);
                    this.ekR.aZq.setVisibility(0);
                    this.ekR.cbp.setVisibility(0);
                    this.ekR.cbp.setIndeterminate(true);
                } else if (i == 2) {
                    this.ekR.cQt.setVisibility(0);
                } else if (i == 4) {
                    this.ekR.cQp.setVisibility(0);
                    this.ekR.elr.setVisibility(0);
                    this.ekR.elq.setVisibility(0);
                    com.baidu.adp.lib.h.h.eG().postDelayed(this.aZz, 2000L);
                }
            }
        }
    }

    private boolean oM(String str) {
        if (ba.isEmpty(str)) {
            return false;
        }
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VIDEO_CACHE_GET_LOCAL, str), String.class);
        return (runTask == null || ba.isEmpty((String) runTask.getData())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aMx() {
        return com.baidu.tbadk.util.x.q(3, this.aMC) && com.baidu.tbadk.core.l.oG().oM();
    }
}
