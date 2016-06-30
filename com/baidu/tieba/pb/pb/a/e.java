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
import com.baidu.tieba.pb.pb.main.cr;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class e extends cr<com.baidu.tieba.tbadkCore.data.s, y> {
    private final CustomMessageListener Dd;
    private String aJM;
    private CustomMessageListener aLc;
    private int aTq;
    private Runnable aTu;
    private CustomMessageListener adR;
    private MediaPlayer.OnErrorListener adh;
    private TextureVideoView.b adn;
    private long bBB;
    private boolean bBC;
    private int bOG;
    private boolean cyQ;
    private CustomMessageListener cyV;
    private CustomMessageListener cyW;
    private CustomMessageListener cyX;
    private CustomMessageListener cyY;
    private com.baidu.tieba.pb.data.h dMC;
    private y dMD;
    private com.baidu.tieba.pb.a.d dME;
    private int dMF;
    private boolean dMG;
    private boolean dMH;
    private View.OnTouchListener dMI;
    private Runnable dMJ;
    private CustomMessageListener dMK;
    private Handler mHandler;
    private View mView;

    public e(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.dMC = null;
        this.cyQ = false;
        this.bBB = 0L;
        this.bBC = true;
        this.bOG = 0;
        this.dME = null;
        this.aTq = 0;
        this.aJM = null;
        this.dMF = 0;
        this.dMG = true;
        this.dMH = false;
        this.adn = new f(this);
        this.mHandler = new q(this, Looper.getMainLooper());
        this.dMI = new r(this);
        this.dMJ = new s(this);
        this.adR = new t(this, CmdConfigCustom.PB_ACTION_PRAISE);
        this.cyV = new u(this, CmdConfigCustom.PB_PAUSE_VIDEO);
        this.dMK = new v(this, CmdConfigCustom.PB_RESTART_VIDEO);
        this.cyW = new w(this, CmdConfigCustom.PB_REFRESH_VIDEO);
        this.cyX = new x(this, CmdConfigCustom.PB_ON_SCROLL);
        this.cyY = new g(this, CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        this.aLc = new h(this, CmdConfigCustom.CMD_GRAFFITI_VOTE_SUCCESS);
        this.Dd = new i(this, 2000994);
        this.adh = new j(this);
        this.aTu = new k(this);
        if (pbActivity != null) {
            pbActivity.registerListener(this.adR);
            pbActivity.registerListener(this.cyV);
            pbActivity.registerListener(this.dMK);
            pbActivity.registerListener(this.cyW);
            pbActivity.registerListener(this.cyX);
            pbActivity.registerListener(this.cyY);
            pbActivity.registerListener(this.Dd);
            pbActivity.registerListener(this.aLc);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public y a(ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = LayoutInflater.from(this.mContext).inflate(u.h.pb_list_item_video, (ViewGroup) null);
            this.dMD = new y(this.mView);
            View findViewById = this.mView.findViewById(u.g.pb_layout_video_view);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            int A = com.baidu.adp.lib.util.k.A(this.mContext);
            if (layoutParams != null) {
                layoutParams.height = A;
                findViewById.setLayoutParams(layoutParams);
            }
        } else {
            aiN();
        }
        return this.dMD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiN() {
        if (this.dMD != null && this.dMD.cBT != null) {
            d(false, 0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cr, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.s sVar, y yVar) {
        super.a(i, view, viewGroup, (ViewGroup) sVar, (com.baidu.tieba.tbadkCore.data.s) yVar);
        if (sVar != null && yVar != null) {
            com.baidu.tbadk.widget.richText.o GO = sVar.GO();
            if (!this.cyQ) {
                this.cyQ = true;
                yVar.cBT.setDefaultErrorResource(0);
                yVar.cBT.setTag(Integer.valueOf(i));
                yVar.cBT.setDefaultResource(0);
                if (!com.baidu.tbadk.core.l.nW().oc()) {
                    yVar.cBT.setNoImageBottomTextColor(u.d.cp_cont_c);
                    yVar.cBT.setNoImageBottomTextPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds32));
                    yVar.cBT.setNoImageBottomTextSize(TbadkCoreApplication.m9getInst().getResources().getDimension(u.e.fontsize28));
                    yVar.cBT.setSupportNoImage(true);
                    yVar.cBT.setNoImageBottomText(TbadkCoreApplication.m9getInst().getString(u.j.click_to_play));
                } else {
                    yVar.cBT.setDefaultBgResource(u.f.pic_bg_video_frs);
                    if (!yVar.aJJ.isPlaying()) {
                        a(sVar, yVar);
                    }
                }
                if (this.dMC != null && this.dMC.aDO() != null && this.dMC.aDO().qU() == 1) {
                    yVar.bOr.setVisibility(8);
                    ViewGroup.LayoutParams layoutParams = yVar.bOs.getLayoutParams();
                    if (layoutParams instanceof LinearLayout.LayoutParams) {
                        ((LinearLayout.LayoutParams) layoutParams).topMargin = (int) this.dOg.getPageContext().getResources().getDimension(u.e.ds34);
                        yVar.bOs.setLayoutParams(layoutParams);
                    }
                } else {
                    yVar.bOr.setTextSize(TbConfig.getContentSize());
                    yVar.bOr.setText(sVar.getTitle());
                    yVar.bOr.setVisibility(0);
                    yVar.bOr.setOnTouchListener(this.dME);
                }
                yVar.aJJ.setOnPreparedListener(new l(this, yVar, GO, sVar));
                yVar.aJJ.setOnCompletionListener(new m(this));
                yVar.aJJ.setOnSurfaceDestroyedListener(this.adn);
                yVar.aJJ.setOnErrorListener(this.adh);
                yVar.mRootView.setOnClickListener(new n(this, yVar));
                aEr();
            }
            com.baidu.tbadk.data.g bcp = sVar.bcp();
            if (bcp != null && !TextUtils.isEmpty(bcp.getName()) && !TextUtils.isEmpty(bcp.getName().trim())) {
                String name = bcp.getName();
                String lat = bcp.getLat();
                String lng = bcp.getLng();
                yVar.dMT.setVisibility(0);
                com.baidu.adp.lib.util.k.a(this.mContext, yVar.dMT, 0, 10, 0, 10);
                yVar.bNS.setText(bcp.getName());
                av.c(yVar.bNS, u.d.cp_link_tip_c, 1);
                yVar.dMU.setImageDrawable(av.getDrawable(u.f.icon_pb_pin));
                yVar.dMT.setOnClickListener(new o(this, lat, lng, name));
            } else {
                yVar.dMU.setVisibility(8);
                yVar.bNS.setVisibility(8);
            }
            PraiseData praise = this.dMC.aDO().getPraise();
            if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                yVar.bBX.setIsFromPb(true);
                yVar.bBX.setIsFromPbVideo(true);
                if (!yVar.dMV.isShown()) {
                    yVar.dMV.setVisibility(0);
                    yVar.bBX.cX(this.mSkinType);
                }
                yVar.bBX.a(praise, sVar.getId(), praise.getPostId(), true);
            } else {
                yVar.dMV.setVisibility(8);
            }
            com.baidu.tieba.graffiti.d.an(yVar.bBX);
            com.baidu.tieba.graffiti.d.an(yVar.dMV);
            a(yVar, GO);
            a(yVar);
            if (yVar.mSkinType != this.mSkinType) {
                av.l(view, u.d.cp_bg_line_d);
                av.c(yVar.bOr, u.d.cp_cont_b, 1);
                av.c(yVar.bOs, u.d.cp_cont_c, 1);
                av.c(yVar.cBX, u.f.icon_play_video);
                av.k(yVar.dMW, u.f.icon_hand_normal_card_recommend);
                av.j((View) yVar.dMX, u.d.cp_cont_d);
                av.l(yVar.mRootView, u.d.cp_bg_line_k);
                av.l(yVar.dMS, u.d.cp_bg_line_k);
            }
            yVar.mSkinType = this.mSkinType;
        }
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEq() {
        if (this.dMC != null && this.dMC.aDO() != null && this.dMC.aDO().qW() != null) {
            com.baidu.tieba.play.e.k(this.dMC.aDO().qW().video_md5, this.dMC.getThreadId(), this.dMC.getForumId(), "pb");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.widget.richText.o oVar) {
        if (oVar != null) {
            this.bOG++;
            oVar.fl(this.bOG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(y yVar, com.baidu.tbadk.widget.richText.o oVar) {
        if (yVar != null && yVar.bOs != null && oVar != null) {
            if (oVar.Hp() < this.bOG) {
                oVar.fl(this.bOG);
            } else {
                this.bOG = oVar.Hp();
            }
            yVar.bOs.setText(String.format(this.dOg.getPageContext().getResources().getString(u.j.video_play_count), ba.B(this.bOG)));
        }
    }

    private void a(y yVar) {
        if (yVar != null) {
            UserData userData = null;
            if (this.dMC != null && this.dMC.aDL() != null) {
                userData = (UserData) com.baidu.tbadk.core.util.y.c(this.dMC.aDL().pj(), 0);
            }
            hk(a(yVar, userData));
            hk(this.dMG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hk(boolean z) {
        if (this.dMD != null) {
            if (z) {
                this.dMD.dMX.setVisibility(0);
                this.dMD.dMW.setVisibility(0);
                return;
            }
            this.dMD.dMX.setVisibility(8);
            this.dMD.dMW.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(y yVar, UserData userData) {
        if (yVar == null || userData == null || StringUtils.isNull(userData.getUserName())) {
            return false;
        }
        String string = this.mContext.getResources().getString(u.j.video_zan_tip);
        String d = ba.d(userData.getName_show(), 4, "...");
        SpannableString spannableString = new SpannableString(String.format(string, d));
        spannableString.setSpan(new ForegroundColorSpan(av.getColor(u.d.cp_link_tip_c)), 0, d.length(), 17);
        yVar.dMX.setText(spannableString);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(this.dOg.getPageContext().getPageActivity(), u.a.praise_animation_scale2));
            com.baidu.adp.lib.h.h.dM().postDelayed(this.dMJ, 200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(this.dOg.getPageContext().getPageActivity(), u.a.praise_animation_scale3));
            com.baidu.adp.lib.h.h.dM().postDelayed(this.dMJ, 600L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ac(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this.dOg.getPageContext().getPageActivity(), u.a.praise_animation_scale1));
    }

    public void b(com.baidu.tieba.pb.data.h hVar) {
        this.dMC = hVar;
    }

    public void hl(boolean z) {
        this.dMG = z;
    }

    private void a(com.baidu.tieba.tbadkCore.data.s sVar, y yVar) {
        com.baidu.tbadk.widget.richText.o GO = sVar.GO();
        if (GO != null) {
            yVar.cBT.c(GO.pg(), 17, false);
            yVar.cBT.setNoImageBottomText("");
            this.aJM = GO.getVideoUrl();
            this.dMF = GO.getDuration();
            if (StringUtils.isNull(GO.pg())) {
                ax(GO.getVideoUrl(), GO.getDuration());
            } else {
                yVar.cBT.setEvent(new p(this, GO));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ax(String str, int i) {
        if (this.dOg != null && this.dOg.aEE() != null && this.dOg.aEE().getPbData() != null && this.dOg.aEE().getPbData().getPage() != null && this.dMD != null && this.dMD.aJJ != null) {
            if (this.aTq != 1 || !this.dMD.aJJ.isPlaying()) {
                if (aEv()) {
                    if (this.aTq != 2) {
                        this.dMD.aJJ.u(str, i);
                        d(false, 3);
                    } else {
                        d(false, 1);
                    }
                    this.dMD.aJJ.start();
                } else {
                    d(true, 0);
                }
                this.dOg.hr(true);
            }
        }
    }

    private void aEr() {
        if (this.dMC != null) {
            String str = com.baidu.adp.lib.util.i.fs() ? "1" : "0";
            ay ayVar = new ay("c10643");
            ayVar.ab("fid", this.dMC.getForumId());
            ayVar.ab("tid", this.dMC.getThreadId());
            ayVar.ab("obj_type", str);
            TiebaStatic.log(ayVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiQ() {
        if (this.dMD != null && this.dMD.aJJ != null && this.dMD.cBX != null) {
            if (this.dMD.aJJ.isPlaying()) {
                this.dMD.aJJ.pause();
                d(false, 2);
            } else if (this.aTq == 3) {
                this.dMD.aJJ.stopPlayback();
                d(false, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEs() {
        if (this.dMD != null && this.dMD.aJJ != null && this.dMD.cBX != null) {
            if (aEv() && !this.dMD.aJJ.isPlaying()) {
                if (this.aTq == 2) {
                    this.dMD.aJJ.start();
                    d(false, 1);
                    return;
                }
                boolean nr = nr(this.aJM);
                if (this.aJM != null && nr && this.aTq != 2 && !this.dMH) {
                    this.dMD.aJJ.u(this.aJM, this.dMF);
                    this.dMH = true;
                    d(false, 3);
                    this.dMD.aJJ.start();
                    return;
                }
                aEq();
                d(false, 3);
                this.dMD.aJJ.start();
            } else if (!aEv()) {
                d(false, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEt() {
        if (this.dMD != null && this.dMD.aJJ != null && this.dMD.cBX != null) {
            if (aEv() && !this.dMD.aJJ.isPlaying()) {
                boolean nr = nr(this.aJM);
                if (this.aJM != null && nr && this.aTq != 2 && !this.dMH) {
                    this.dMD.aJJ.u(this.aJM, this.dMF);
                    this.dMH = true;
                    d(false, 3);
                    this.dMD.aJJ.start();
                    return;
                }
                aEq();
                d(false, 1);
                this.dMD.aJJ.start();
            } else if (!aEv()) {
                d(false, 0);
            }
        }
    }

    public void a(com.baidu.tieba.pb.a.d dVar) {
        this.dME = dVar;
    }

    public void aEu() {
        if (this.dMD != null) {
            this.dMD.bOr.setTextSize(TbConfig.getContentSize());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z, int i) {
        if (this.dMD != null && this.dMD.cBT != null && this.dMD.cBX != null && this.dMD.dMY != null && this.dMD.bOv != null && this.dMD.dNa != null && this.dMD.dMZ != null && this.dMD.aTm != null && this.dMD.dMS != null) {
            if (z || this.aTq != i) {
                this.aTq = i;
                this.dMD.cBX.setVisibility(8);
                this.dMD.dMY.setVisibility(8);
                this.dMD.dMY.bjm();
                this.dMD.aTm.setVisibility(8);
                this.dMD.bOv.setVisibility(8);
                this.dMD.bOv.setIndeterminate(false);
                this.dMD.dNa.setVisibility(8);
                this.dMD.dMZ.setVisibility(8);
                this.dMD.cBT.setVisibility(8);
                com.baidu.adp.lib.h.h.dM().removeCallbacks(this.aTu);
                if (i == 0) {
                    this.dMD.cBT.setVisibility(0);
                    this.dMD.cBX.setVisibility(0);
                } else if (i == 1) {
                    this.dMD.dMY.setVisibility(0);
                    this.dMD.dMY.bjm();
                    this.dMD.dMY.start();
                } else if (i == 3) {
                    this.dMD.aTm.setVisibility(0);
                    this.dMD.bOv.setVisibility(0);
                    this.dMD.cBT.setVisibility(0);
                    this.dMD.aTm.setVisibility(0);
                    this.dMD.bOv.setVisibility(0);
                    this.dMD.bOv.setIndeterminate(true);
                } else if (i == 2) {
                    this.dMD.cBX.setVisibility(0);
                } else if (i == 4) {
                    this.dMD.cBT.setVisibility(0);
                    this.dMD.dNa.setVisibility(0);
                    this.dMD.dMZ.setVisibility(0);
                    com.baidu.adp.lib.h.h.dM().postDelayed(this.aTu, 2000L);
                }
            }
        }
    }

    private boolean nr(String str) {
        if (ba.isEmpty(str)) {
            return false;
        }
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VIDEO_CACHE_GET_LOCAL, str), String.class);
        return (runTask == null || ba.isEmpty((String) runTask.getData())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aEv() {
        return com.baidu.tbadk.util.w.eX(3) && com.baidu.tbadk.core.l.nW().oc();
    }
}
