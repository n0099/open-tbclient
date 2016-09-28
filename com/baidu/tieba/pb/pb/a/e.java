package com.baidu.tieba.pb.pb.a;

import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.cs;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.ad;
import com.baidu.tieba.play.e;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class e extends cs<com.baidu.tieba.tbadkCore.data.q, v> {
    private final CustomMessageListener FQ;
    private e.b aLs;
    private QuickVideoView.b aMS;
    private Runnable aMT;
    private String aNM;
    private CustomMessageListener aSx;
    private int aZP;
    private boolean cOb;
    private CustomMessageListener cOg;
    private CustomMessageListener cOh;
    private CustomMessageListener cOi;
    private CustomMessageListener cOj;
    private int cbC;
    private com.baidu.tieba.pb.data.h emS;
    private v emT;
    private com.baidu.tieba.pb.a.d emU;
    private boolean emV;
    private boolean emW;
    private CustomMessageListener emX;
    private Handler mHandler;
    private View mView;

    public e(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.emS = null;
        this.cOb = false;
        this.cbC = 0;
        this.emU = null;
        this.aZP = 0;
        this.aNM = null;
        this.emV = true;
        this.emW = false;
        this.aMS = new f(this);
        this.mHandler = new n(this, Looper.getMainLooper());
        this.cOg = new o(this, CmdConfigCustom.PB_PAUSE_VIDEO);
        this.emX = new p(this, CmdConfigCustom.PB_RESTART_VIDEO);
        this.cOh = new q(this, CmdConfigCustom.PB_REFRESH_VIDEO);
        this.cOi = new r(this, CmdConfigCustom.PB_ON_SCROLL);
        this.cOj = new s(this, CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        this.aSx = new t(this, CmdConfigCustom.CMD_GRAFFITI_VOTE_SUCCESS);
        this.FQ = new u(this, 2000994);
        this.aLs = new g(this);
        this.aMT = new h(this);
        if (pbActivity != null) {
            pbActivity.registerListener(this.cOg);
            pbActivity.registerListener(this.emX);
            pbActivity.registerListener(this.cOh);
            pbActivity.registerListener(this.cOi);
            pbActivity.registerListener(this.cOj);
            pbActivity.registerListener(this.FQ);
            pbActivity.registerListener(this.aSx);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bf */
    public v a(ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = LayoutInflater.from(this.mContext).inflate(r.h.pb_list_item_video, (ViewGroup) null);
            this.emT = new v(this.mView);
            View findViewById = this.mView.findViewById(r.g.pb_layout_video_view);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            int K = com.baidu.adp.lib.util.k.K(this.mContext);
            if (layoutParams != null) {
                layoutParams.height = K;
                findViewById.setLayoutParams(layoutParams);
            }
        } else {
            aoz();
        }
        return this.emT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoz() {
        if (this.emT != null && this.emT.cRg != null) {
            e(false, 0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cs, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.q qVar, v vVar) {
        super.a(i, view, viewGroup, (ViewGroup) qVar, (com.baidu.tieba.tbadkCore.data.q) vVar);
        if (qVar != null && vVar != null) {
            qVar.sL();
            vVar.aLZ.a(b(qVar));
            com.baidu.tbadk.widget.richText.o Ii = qVar.Ii();
            if (vVar.aLZ.bav() != null) {
                vVar.aLZ.bav().d(Ii);
            }
            if (!this.cOb) {
                this.cOb = true;
                vVar.cRg.setDefaultErrorResource(0);
                vVar.cRg.setTag(Integer.valueOf(i));
                vVar.cRg.setDefaultResource(0);
                if (!com.baidu.tbadk.core.l.oH().oN()) {
                    vVar.cRg.setNoImageBottomTextColor(r.d.cp_cont_c);
                    vVar.cRg.setNoImageBottomTextPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds32));
                    vVar.cRg.setNoImageBottomTextSize(TbadkCoreApplication.m9getInst().getResources().getDimension(r.e.fontsize28));
                    vVar.cRg.setSupportNoImage(true);
                    vVar.cRg.setNoImageBottomText(TbadkCoreApplication.m9getInst().getString(r.j.click_to_play));
                } else {
                    vVar.cRg.setDefaultBgResource(r.f.pic_bg_video_frs);
                    if (!vVar.aMF.isPlaying()) {
                        a(qVar, vVar);
                    }
                }
                if (this.emS != null && this.emS.aMs() != null && this.emS.aMs().sb() == 1) {
                    vVar.cbn.setVisibility(8);
                    ViewGroup.LayoutParams layoutParams = vVar.cbo.getLayoutParams();
                    if (layoutParams instanceof LinearLayout.LayoutParams) {
                        ((LinearLayout.LayoutParams) layoutParams).topMargin = (int) this.eow.getPageContext().getResources().getDimension(r.e.ds34);
                        vVar.cbo.setLayoutParams(layoutParams);
                    }
                } else {
                    vVar.cbn.setTextSize(TbConfig.getContentSize());
                    vVar.cbn.setText(qVar.getTitle());
                    vVar.cbn.setVisibility(0);
                    vVar.cbn.setOnTouchListener(this.emU);
                }
                vVar.aMF.setOnPreparedListener(new i(this, vVar, Ii, qVar));
                vVar.aMF.setOnCompletionListener(new j(this));
                vVar.aMF.setOnSurfaceDestroyedListener(this.aMS);
                vVar.aMF.setOnErrorListener(this.aLs);
                vVar.mRootView.setOnClickListener(new k(this, vVar));
                aMY();
            }
            com.baidu.tbadk.data.g bjR = qVar.bjR();
            if (bjR != null && !TextUtils.isEmpty(bjR.getName()) && !TextUtils.isEmpty(bjR.getName().trim())) {
                String name = bjR.getName();
                String lat = bjR.getLat();
                String lng = bjR.getLng();
                vVar.enh.setVisibility(0);
                com.baidu.adp.lib.util.k.a(this.mContext, vVar.enh, 0, 10, 0, 10);
                vVar.caN.setText(bjR.getName());
                av.c(vVar.caN, r.d.cp_link_tip_c, 1);
                vVar.eni.setImageDrawable(av.getDrawable(r.f.icon_pb_pin));
                vVar.enh.setOnClickListener(new l(this, lat, lng, name));
            } else {
                vVar.eni.setVisibility(8);
                vVar.caN.setVisibility(8);
            }
            PraiseData rF = this.emS.aMs().rF();
            if (rF != null && rF.getUser() != null && rF.getUser().size() > 0) {
                vVar.enj.setIsFromPb(true);
                vVar.enj.setIsFromPbVideo(true);
                if (!vVar.enk.isShown()) {
                    vVar.enk.setVisibility(0);
                    vVar.enj.dl(this.mSkinType);
                }
                vVar.enj.a(rF, qVar.getId(), rF.getPostId(), true);
            } else {
                vVar.enk.setVisibility(8);
            }
            com.baidu.tieba.graffiti.d.ak(vVar.enj);
            com.baidu.tieba.graffiti.d.ak(vVar.enk);
            a(vVar, Ii);
            a(vVar);
            if (vVar.mSkinType != this.mSkinType) {
                av.l(view, r.d.cp_bg_line_d);
                av.c(vVar.cbn, r.d.cp_cont_b, 1);
                av.c(vVar.cbo, r.d.cp_cont_c, 1);
                av.c(vVar.cRk, r.f.icon_play_video);
                av.k(vVar.enl, r.f.icon_hand_normal_card_recommend);
                av.j((View) vVar.enm, r.d.cp_cont_d);
                av.l(vVar.mRootView, r.d.cp_bg_line_k);
                av.l(vVar.eng, r.d.cp_bg_line_k);
            }
            vVar.mSkinType = this.mSkinType;
        }
        return this.mView;
    }

    private ad b(com.baidu.tieba.tbadkCore.data.q qVar) {
        ad adVar = null;
        if (qVar != null) {
            adVar = new ad();
            adVar.mLocate = "6";
            if (this.emS != null) {
                adVar.aPH = this.emS.getThreadId();
                adVar.aPG = this.emS.getForumId();
            }
        }
        return adVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jt() {
        if (this.emS != null && this.emS.aMs() != null && this.emS.aMs().sd() != null) {
            com.baidu.tieba.play.j.a(this.emS.aMs().sd().video_md5, this.emS.getThreadId(), this.emS.getForumId(), "pb", this.emS.Lm(), "", "1");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.widget.richText.o oVar) {
        if (oVar != null) {
            this.cbC++;
            oVar.fz(this.cbC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(v vVar, com.baidu.tbadk.widget.richText.o oVar) {
        if (vVar != null && vVar.cbo != null && oVar != null) {
            if (oVar.IL() < this.cbC) {
                oVar.fz(this.cbC);
            } else {
                this.cbC = oVar.IL();
            }
            vVar.cbo.setText(String.format(this.eow.getPageContext().getResources().getString(r.j.video_play_count), az.w(this.cbC)));
        }
    }

    private void a(v vVar) {
        if (vVar != null) {
            UserData userData = null;
            if (this.emS != null && this.emS.aMp() != null) {
                userData = (UserData) com.baidu.tbadk.core.util.y.c(this.emS.aMp().qg(), 0);
            }
            hU(a(vVar, userData) && this.emV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hU(boolean z) {
        if (this.emT != null) {
            if (z) {
                this.emT.enm.setVisibility(0);
                this.emT.enl.setVisibility(0);
                return;
            }
            this.emT.enm.setVisibility(8);
            this.emT.enl.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(v vVar, UserData userData) {
        if (vVar == null || userData == null || StringUtils.isNull(userData.getUserName())) {
            return false;
        }
        String string = this.mContext.getResources().getString(r.j.video_zan_tip);
        String d = az.d(userData.getName_show(), 4, "...");
        SpannableString spannableString = new SpannableString(String.format(string, d));
        spannableString.setSpan(new ForegroundColorSpan(av.getColor(r.d.cp_link_tip_c)), 0, d.length(), 17);
        vVar.enm.setText(spannableString);
        return true;
    }

    public void b(com.baidu.tieba.pb.data.h hVar) {
        this.emS = hVar;
    }

    public void hV(boolean z) {
        this.emV = z;
    }

    private void a(com.baidu.tieba.tbadkCore.data.q qVar, v vVar) {
        com.baidu.tbadk.widget.richText.o Ii = qVar.Ii();
        if (Ii != null) {
            vVar.cRg.c(Ii.qd(), 17, false);
            vVar.cRg.setNoImageBottomText(null);
            this.aNM = Ii.getVideoUrl();
            if (StringUtils.isNull(Ii.qd())) {
                pa(Ii.getVideoUrl());
            } else {
                vVar.cRg.setEvent(new m(this, Ii));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pa(String str) {
        if (this.eow != null && this.eow.aNl() != null && this.eow.aNl().getPbData() != null && this.eow.aNl().getPbData().getPage() != null && this.emT != null && this.emT.aMF != null) {
            if (this.aZP != 1 || !this.emT.aMF.isPlaying()) {
                if (aNc()) {
                    if (this.aZP != 2) {
                        this.emT.aMF.setVideoPath(str);
                        e(false, 3);
                    } else {
                        e(false, 1);
                    }
                    this.emT.aMF.start();
                } else {
                    e(true, 0);
                }
                this.eow.ib(true);
            }
        }
    }

    private void aMY() {
        if (this.emS != null) {
            String str = com.baidu.adp.lib.util.i.gn() ? "1" : "0";
            ax axVar = new ax("c10643");
            axVar.ab("fid", this.emS.getForumId());
            axVar.ab("tid", this.emS.getThreadId());
            axVar.ab("obj_type", str);
            TiebaStatic.log(axVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoC() {
        if (this.emT != null && this.emT.aMF != null && this.emT.cRk != null) {
            if (this.emT.aMF.isPlaying()) {
                this.emT.aMF.pause();
                e(false, 2);
            } else if (this.aZP == 3) {
                this.emT.aMF.stopPlayback();
                e(false, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMZ() {
        if (this.emT != null && this.emT.aMF != null && this.emT.cRk != null) {
            if (aNc() && !this.emT.aMF.isPlaying()) {
                if (this.aZP == 2) {
                    this.emT.aMF.start();
                    e(false, 1);
                    return;
                }
                boolean pb = pb(this.aNM);
                if (this.aNM != null && pb && this.aZP != 2 && !this.emW) {
                    this.emT.aMF.setVideoPath(this.aNM);
                    this.emW = true;
                    e(false, 3);
                    this.emT.aMF.start();
                    return;
                }
                Jt();
                this.emT.aMF.setVideoPath(this.aNM);
                e(false, 3);
                this.emT.aMF.start();
            } else if (!aNc()) {
                e(false, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNa() {
        if (this.emT != null && this.emT.aMF != null && this.emT.cRk != null) {
            if (aNc() && !this.emT.aMF.isPlaying()) {
                boolean pb = pb(this.aNM);
                if (this.aNM != null && pb && this.aZP != 2 && !this.emW) {
                    this.emT.aMF.setVideoPath(this.aNM);
                    this.emW = true;
                    e(false, 3);
                    this.emT.aMF.start();
                    return;
                }
                Jt();
                e(false, 1);
                this.emT.aMF.start();
            } else if (!aNc()) {
                e(false, 0);
            }
        }
    }

    public void a(com.baidu.tieba.pb.a.d dVar) {
        this.emU = dVar;
    }

    public void aNb() {
        if (this.emT != null) {
            this.emT.cbn.setTextSize(TbConfig.getContentSize());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, int i) {
        if (this.emT != null && this.emT.cRg != null && this.emT.cRk != null && this.emT.enn != null && this.emT.cbr != null && this.emT.eno != null && this.emT.aMP != null && this.emT.aZL != null && this.emT.eng != null) {
            if (z || this.aZP != i) {
                this.aZP = i;
                this.emT.cRk.setVisibility(8);
                this.emT.enn.setVisibility(8);
                this.emT.enn.bqM();
                this.emT.aZL.setVisibility(8);
                this.emT.cbr.setVisibility(8);
                this.emT.cbr.setIndeterminate(false);
                this.emT.eno.setVisibility(8);
                this.emT.aMP.setVisibility(8);
                this.emT.cRg.setVisibility(8);
                com.baidu.adp.lib.h.h.eG().removeCallbacks(this.aMT);
                if (i == 0) {
                    this.emT.cRg.setVisibility(0);
                    this.emT.cRk.setVisibility(0);
                } else if (i == 1) {
                    this.emT.enn.setVisibility(0);
                    this.emT.enn.bqM();
                    this.emT.enn.start();
                } else if (i == 3) {
                    this.emT.aZL.setVisibility(0);
                    this.emT.cbr.setVisibility(0);
                    this.emT.cRg.setVisibility(0);
                    this.emT.aZL.setVisibility(0);
                    this.emT.cbr.setVisibility(0);
                    this.emT.cbr.setIndeterminate(true);
                } else if (i == 2) {
                    this.emT.cRk.setVisibility(0);
                } else if (i == 4) {
                    this.emT.cRg.setVisibility(0);
                    this.emT.eno.setVisibility(0);
                    this.emT.aMP.setVisibility(0);
                    com.baidu.adp.lib.h.h.eG().postDelayed(this.aMT, 2000L);
                }
            }
        }
    }

    private boolean pb(String str) {
        if (az.isEmpty(str)) {
            return false;
        }
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VIDEO_CACHE_GET_LOCAL, str), String.class);
        return (runTask == null || az.isEmpty((String) runTask.getData())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aNc() {
        return com.baidu.tbadk.util.x.q(3, this.aNM) && com.baidu.tbadk.core.l.oH().oN();
    }
}
