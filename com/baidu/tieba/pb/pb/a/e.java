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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class e extends cs<com.baidu.tieba.tbadkCore.data.s, y> {
    private final CustomMessageListener DE;
    private String aKF;
    private CustomMessageListener aLV;
    private int aUm;
    private Runnable aUq;
    private MediaPlayer.OnErrorListener adR;
    private TextureVideoView.b adX;
    private CustomMessageListener aeF;
    private int bQs;
    private boolean cBF;
    private CustomMessageListener cBK;
    private CustomMessageListener cBL;
    private CustomMessageListener cBM;
    private CustomMessageListener cBN;
    private com.baidu.tieba.pb.data.h dYM;
    private y dYN;
    private long dYO;
    private boolean dYP;
    private com.baidu.tieba.pb.a.d dYQ;
    private int dYR;
    private boolean dYS;
    private boolean dYT;
    private View.OnTouchListener dYU;
    private Runnable dYV;
    private CustomMessageListener dYW;
    private Handler mHandler;
    private View mView;

    public e(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.dYM = null;
        this.cBF = false;
        this.dYO = 0L;
        this.dYP = true;
        this.bQs = 0;
        this.dYQ = null;
        this.aUm = 0;
        this.aKF = null;
        this.dYR = 0;
        this.dYS = true;
        this.dYT = false;
        this.adX = new f(this);
        this.mHandler = new q(this, Looper.getMainLooper());
        this.dYU = new r(this);
        this.dYV = new s(this);
        this.aeF = new t(this, CmdConfigCustom.PB_ACTION_PRAISE);
        this.cBK = new u(this, CmdConfigCustom.PB_PAUSE_VIDEO);
        this.dYW = new v(this, CmdConfigCustom.PB_RESTART_VIDEO);
        this.cBL = new w(this, CmdConfigCustom.PB_REFRESH_VIDEO);
        this.cBM = new x(this, CmdConfigCustom.PB_ON_SCROLL);
        this.cBN = new g(this, CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        this.aLV = new h(this, CmdConfigCustom.CMD_GRAFFITI_VOTE_SUCCESS);
        this.DE = new i(this, 2000994);
        this.adR = new j(this);
        this.aUq = new k(this);
        if (pbActivity != null) {
            pbActivity.registerListener(this.aeF);
            pbActivity.registerListener(this.cBK);
            pbActivity.registerListener(this.dYW);
            pbActivity.registerListener(this.cBL);
            pbActivity.registerListener(this.cBM);
            pbActivity.registerListener(this.cBN);
            pbActivity.registerListener(this.DE);
            pbActivity.registerListener(this.aLV);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bl */
    public y a(ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = LayoutInflater.from(this.mContext).inflate(u.h.pb_list_item_video, (ViewGroup) null);
            this.dYN = new y(this.mView);
            View findViewById = this.mView.findViewById(u.g.pb_layout_video_view);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            int A = com.baidu.adp.lib.util.k.A(this.mContext);
            if (layoutParams != null) {
                layoutParams.height = A;
                findViewById.setLayoutParams(layoutParams);
            }
        } else {
            ajx();
        }
        return this.dYN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajx() {
        if (this.dYN != null && this.dYN.cEI != null) {
            e(false, 0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cs, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.s sVar, y yVar) {
        super.a(i, view, viewGroup, (ViewGroup) sVar, (com.baidu.tieba.tbadkCore.data.s) yVar);
        if (sVar != null && yVar != null) {
            yVar.aKC.setVideoStatsData(b(sVar));
            com.baidu.tbadk.widget.richText.o GM = sVar.GM();
            if (!this.cBF) {
                this.cBF = true;
                yVar.cEI.setDefaultErrorResource(0);
                yVar.cEI.setTag(Integer.valueOf(i));
                yVar.cEI.setDefaultResource(0);
                if (!com.baidu.tbadk.core.l.nL().nR()) {
                    yVar.cEI.setNoImageBottomTextColor(u.d.cp_cont_c);
                    yVar.cEI.setNoImageBottomTextPadding(TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds32));
                    yVar.cEI.setNoImageBottomTextSize(TbadkCoreApplication.m10getInst().getResources().getDimension(u.e.fontsize28));
                    yVar.cEI.setSupportNoImage(true);
                    yVar.cEI.setNoImageBottomText(TbadkCoreApplication.m10getInst().getString(u.j.click_to_play));
                } else {
                    yVar.cEI.setDefaultBgResource(u.f.pic_bg_video_frs);
                    if (!yVar.aKC.isPlaying()) {
                        a(sVar, yVar);
                    }
                }
                if (this.dYM != null && this.dYM.aGY() != null && this.dYM.aGY().qK() == 1) {
                    yVar.bQd.setVisibility(8);
                    ViewGroup.LayoutParams layoutParams = yVar.bQe.getLayoutParams();
                    if (layoutParams instanceof LinearLayout.LayoutParams) {
                        ((LinearLayout.LayoutParams) layoutParams).topMargin = (int) this.eat.getPageContext().getResources().getDimension(u.e.ds34);
                        yVar.bQe.setLayoutParams(layoutParams);
                    }
                } else {
                    yVar.bQd.setTextSize(TbConfig.getContentSize());
                    yVar.bQd.setText(sVar.getTitle());
                    yVar.bQd.setVisibility(0);
                    yVar.bQd.setOnTouchListener(this.dYQ);
                }
                yVar.aKC.setOnPreparedListener(new l(this, yVar, GM, sVar));
                yVar.aKC.setOnCompletionListener(new m(this));
                yVar.aKC.setOnSurfaceDestroyedListener(this.adX);
                yVar.aKC.setOnErrorListener(this.adR);
                yVar.mRootView.setOnClickListener(new n(this, yVar));
                aHB();
            }
            com.baidu.tbadk.data.g bfE = sVar.bfE();
            if (bfE != null && !TextUtils.isEmpty(bfE.getName()) && !TextUtils.isEmpty(bfE.getName().trim())) {
                String name = bfE.getName();
                String lat = bfE.getLat();
                String lng = bfE.getLng();
                yVar.dZf.setVisibility(0);
                com.baidu.adp.lib.util.k.a(this.mContext, yVar.dZf, 0, 10, 0, 10);
                yVar.bPD.setText(bfE.getName());
                av.c(yVar.bPD, u.d.cp_link_tip_c, 1);
                yVar.dZg.setImageDrawable(av.getDrawable(u.f.icon_pb_pin));
                yVar.dZf.setOnClickListener(new o(this, lat, lng, name));
            } else {
                yVar.dZg.setVisibility(8);
                yVar.bPD.setVisibility(8);
            }
            PraiseData qp = this.dYM.aGY().qp();
            if (qp != null && qp.getUser() != null && qp.getUser().size() > 0) {
                yVar.dZh.setIsFromPb(true);
                yVar.dZh.setIsFromPbVideo(true);
                if (!yVar.dZi.isShown()) {
                    yVar.dZi.setVisibility(0);
                    yVar.dZh.cX(this.mSkinType);
                }
                yVar.dZh.a(qp, sVar.getId(), qp.getPostId(), true);
            } else {
                yVar.dZi.setVisibility(8);
            }
            com.baidu.tieba.graffiti.d.al(yVar.dZh);
            com.baidu.tieba.graffiti.d.al(yVar.dZi);
            a(yVar, GM);
            a(yVar);
            if (yVar.mSkinType != this.mSkinType) {
                av.l(view, u.d.cp_bg_line_d);
                av.c(yVar.bQd, u.d.cp_cont_b, 1);
                av.c(yVar.bQe, u.d.cp_cont_c, 1);
                av.c(yVar.cEM, u.f.icon_play_video);
                av.k(yVar.dZj, u.f.icon_hand_normal_card_recommend);
                av.j((View) yVar.dZk, u.d.cp_cont_d);
                av.l(yVar.mRootView, u.d.cp_bg_line_k);
                av.l(yVar.dZe, u.d.cp_bg_line_k);
            }
            yVar.mSkinType = this.mSkinType;
        }
        return this.mView;
    }

    private TextureVideoView.c b(com.baidu.tieba.tbadkCore.data.s sVar) {
        TextureVideoView.c cVar = null;
        if (sVar != null) {
            cVar = new TextureVideoView.c();
            cVar.mLocate = "6";
            if (this.dYM != null) {
                cVar.aep = this.dYM.getThreadId();
                cVar.aeq = this.dYM.getForumId();
            }
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHA() {
        if (this.dYM != null && this.dYM.aGY() != null && this.dYM.aGY().qM() != null) {
            com.baidu.tieba.play.e.k(this.dYM.aGY().qM().video_md5, this.dYM.getThreadId(), this.dYM.getForumId(), "pb");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.widget.richText.o oVar) {
        if (oVar != null) {
            this.bQs++;
            oVar.fk(this.bQs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(y yVar, com.baidu.tbadk.widget.richText.o oVar) {
        if (yVar != null && yVar.bQe != null && oVar != null) {
            if (oVar.Hn() < this.bQs) {
                oVar.fk(this.bQs);
            } else {
                this.bQs = oVar.Hn();
            }
            yVar.bQe.setText(String.format(this.eat.getPageContext().getResources().getString(u.j.video_play_count), ba.w(this.bQs)));
        }
    }

    private void a(y yVar) {
        if (yVar != null) {
            UserData userData = null;
            if (this.dYM != null && this.dYM.aGV() != null) {
                userData = (UserData) com.baidu.tbadk.core.util.y.c(this.dYM.aGV().oS(), 0);
            }
            hv(a(yVar, userData) && this.dYS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hv(boolean z) {
        if (this.dYN != null) {
            if (z) {
                this.dYN.dZk.setVisibility(0);
                this.dYN.dZj.setVisibility(0);
                return;
            }
            this.dYN.dZk.setVisibility(8);
            this.dYN.dZj.setVisibility(8);
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
        yVar.dZk.setText(spannableString);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(this.eat.getPageContext().getPageActivity(), u.a.praise_animation_scale2));
            com.baidu.adp.lib.h.h.dL().postDelayed(this.dYV, 200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(this.eat.getPageContext().getPageActivity(), u.a.praise_animation_scale3));
            com.baidu.adp.lib.h.h.dL().postDelayed(this.dYV, 600L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aU(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this.eat.getPageContext().getPageActivity(), u.a.praise_animation_scale1));
    }

    public void b(com.baidu.tieba.pb.data.h hVar) {
        this.dYM = hVar;
    }

    public void hw(boolean z) {
        this.dYS = z;
    }

    private void a(com.baidu.tieba.tbadkCore.data.s sVar, y yVar) {
        com.baidu.tbadk.widget.richText.o GM = sVar.GM();
        if (GM != null) {
            yVar.cEI.c(GM.oP(), 17, false);
            yVar.cEI.setNoImageBottomText("");
            this.aKF = GM.getVideoUrl();
            this.dYR = GM.getDuration();
            if (StringUtils.isNull(GM.oP())) {
                ay(GM.getVideoUrl(), GM.getDuration());
            } else {
                yVar.cEI.setEvent(new p(this, GM));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ay(String str, int i) {
        if (this.eat != null && this.eat.aHO() != null && this.eat.aHO().getPbData() != null && this.eat.aHO().getPbData().getPage() != null && this.dYN != null && this.dYN.aKC != null) {
            if (this.aUm != 1 || !this.dYN.aKC.isPlaying()) {
                if (aHF()) {
                    if (this.aUm != 2) {
                        this.dYN.aKC.u(str, i);
                        e(false, 3);
                    } else {
                        e(false, 1);
                    }
                    this.dYN.aKC.start();
                } else {
                    e(true, 0);
                }
                this.eat.hC(true);
            }
        }
    }

    private void aHB() {
        if (this.dYM != null) {
            String str = com.baidu.adp.lib.util.i.fr() ? "1" : "0";
            ay ayVar = new ay("c10643");
            ayVar.ab("fid", this.dYM.getForumId());
            ayVar.ab("tid", this.dYM.getThreadId());
            ayVar.ab("obj_type", str);
            TiebaStatic.log(ayVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajA() {
        if (this.dYN != null && this.dYN.aKC != null && this.dYN.cEM != null) {
            if (this.dYN.aKC.isPlaying()) {
                this.dYN.aKC.pause();
                e(false, 2);
            } else if (this.aUm == 3) {
                this.dYN.aKC.vr();
                e(false, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHC() {
        if (this.dYN != null && this.dYN.aKC != null && this.dYN.cEM != null) {
            if (aHF() && !this.dYN.aKC.isPlaying()) {
                if (this.aUm == 2) {
                    this.dYN.aKC.start();
                    e(false, 1);
                    return;
                }
                boolean oc = oc(this.aKF);
                if (this.aKF != null && oc && this.aUm != 2 && !this.dYT) {
                    this.dYN.aKC.u(this.aKF, this.dYR);
                    this.dYT = true;
                    e(false, 3);
                    this.dYN.aKC.start();
                    return;
                }
                aHA();
                e(false, 3);
                this.dYN.aKC.start();
            } else if (!aHF()) {
                e(false, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHD() {
        if (this.dYN != null && this.dYN.aKC != null && this.dYN.cEM != null) {
            if (aHF() && !this.dYN.aKC.isPlaying()) {
                boolean oc = oc(this.aKF);
                if (this.aKF != null && oc && this.aUm != 2 && !this.dYT) {
                    this.dYN.aKC.u(this.aKF, this.dYR);
                    this.dYT = true;
                    e(false, 3);
                    this.dYN.aKC.start();
                    return;
                }
                aHA();
                e(false, 1);
                this.dYN.aKC.start();
            } else if (!aHF()) {
                e(false, 0);
            }
        }
    }

    public void a(com.baidu.tieba.pb.a.d dVar) {
        this.dYQ = dVar;
    }

    public void aHE() {
        if (this.dYN != null) {
            this.dYN.bQd.setTextSize(TbConfig.getContentSize());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, int i) {
        if (this.dYN != null && this.dYN.cEI != null && this.dYN.cEM != null && this.dYN.dZl != null && this.dYN.bQh != null && this.dYN.dZn != null && this.dYN.dZm != null && this.dYN.aUi != null && this.dYN.dZe != null) {
            if (z || this.aUm != i) {
                this.aUm = i;
                this.dYN.cEM.setVisibility(8);
                this.dYN.dZl.setVisibility(8);
                this.dYN.dZl.bmz();
                this.dYN.aUi.setVisibility(8);
                this.dYN.bQh.setVisibility(8);
                this.dYN.bQh.setIndeterminate(false);
                this.dYN.dZn.setVisibility(8);
                this.dYN.dZm.setVisibility(8);
                this.dYN.cEI.setVisibility(8);
                com.baidu.adp.lib.h.h.dL().removeCallbacks(this.aUq);
                if (i == 0) {
                    this.dYN.cEI.setVisibility(0);
                    this.dYN.cEM.setVisibility(0);
                } else if (i == 1) {
                    this.dYN.dZl.setVisibility(0);
                    this.dYN.dZl.bmz();
                    this.dYN.dZl.start();
                } else if (i == 3) {
                    this.dYN.aUi.setVisibility(0);
                    this.dYN.bQh.setVisibility(0);
                    this.dYN.cEI.setVisibility(0);
                    this.dYN.aUi.setVisibility(0);
                    this.dYN.bQh.setVisibility(0);
                    this.dYN.bQh.setIndeterminate(true);
                } else if (i == 2) {
                    this.dYN.cEM.setVisibility(0);
                } else if (i == 4) {
                    this.dYN.cEI.setVisibility(0);
                    this.dYN.dZn.setVisibility(0);
                    this.dYN.dZm.setVisibility(0);
                    com.baidu.adp.lib.h.h.dL().postDelayed(this.aUq, 2000L);
                }
            }
        }
    }

    private boolean oc(String str) {
        if (ba.isEmpty(str)) {
            return false;
        }
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VIDEO_CACHE_GET_LOCAL, str), String.class);
        return (runTask == null || ba.isEmpty((String) runTask.getData())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aHF() {
        return com.baidu.tbadk.util.x.eX(3) && com.baidu.tbadk.core.l.nL().nR();
    }
}
