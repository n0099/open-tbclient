package com.baidu.tieba.write;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteUrlActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.p.ae;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.GridLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ForumWriteData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b {
    private ViewGroup aaQ;
    private TbPageContext aby;
    private LinearLayout gAA;
    private TbImageView gAB;
    private TextView gAC;
    private LinearLayout gAD;
    private TbImageView gAE;
    private TextView gAF;
    private LinearLayout gAG;
    private TbImageView gAH;
    private TextView gAI;
    private ImageView gAJ;
    private GridLayout gAK;
    private a gAL;
    private ForumWriteData gAQ;
    private String gAR;
    private boolean gAS;
    private boolean gAT;
    private Animation gAU;
    private Animation gAV;
    private Animation gAW;
    private Animation gAX;
    private View gAs;
    private View gAt;
    private LinearLayout gAu;
    private TbImageView gAv;
    private TextView gAw;
    private LinearLayout gAx;
    private TbImageView gAy;
    private TextView gAz;
    private boolean gAM = false;
    private int gAN = 0;
    private boolean gAO = true;
    private boolean gAP = true;
    private ArrayList<View> eGH = new ArrayList<>();

    static /* synthetic */ int r(b bVar) {
        int i = bVar.gAN;
        bVar.gAN = i + 1;
        return i;
    }

    static /* synthetic */ int t(b bVar) {
        int i = bVar.gAN;
        bVar.gAN = i - 1;
        return i;
    }

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.aby = tbPageContext;
        this.aaQ = viewGroup;
        initView();
    }

    public void a(ForumWriteData forumWriteData) {
        this.gAQ = forumWriteData;
    }

    public void sT(String str) {
        this.gAR = str;
    }

    private void initView() {
        if (this.aby != null && this.aby.getPageActivity() != null && this.aaQ != null) {
            this.gAt = LayoutInflater.from(this.aby.getPageActivity()).inflate(d.j.bottom_write_thread, (ViewGroup) null);
            this.gAx = (LinearLayout) this.gAt.findViewById(d.h.home_write_article);
            this.gAy = (TbImageView) this.gAt.findViewById(d.h.home_write_article_icon);
            this.gAz = (TextView) this.gAt.findViewById(d.h.home_write_article_title);
            this.gAu = (LinearLayout) this.gAt.findViewById(d.h.home_write_photo);
            this.gAv = (TbImageView) this.gAt.findViewById(d.h.home_write_photo_icon);
            this.gAw = (TextView) this.gAt.findViewById(d.h.home_write_photo_title);
            this.gAA = (LinearLayout) this.gAt.findViewById(d.h.home_write_video);
            this.gAB = (TbImageView) this.gAt.findViewById(d.h.home_write_video_icon);
            this.gAC = (TextView) this.gAt.findViewById(d.h.home_write_video_title);
            this.gAD = (LinearLayout) this.gAt.findViewById(d.h.home_write_live);
            this.gAE = (TbImageView) this.gAt.findViewById(d.h.home_write_live_icon);
            this.gAF = (TextView) this.gAt.findViewById(d.h.home_write_live_title);
            this.gAG = (LinearLayout) this.gAt.findViewById(d.h.home_write_url);
            this.gAH = (TbImageView) this.gAt.findViewById(d.h.home_write_url_icon);
            this.gAI = (TextView) this.gAt.findViewById(d.h.home_write_url_title);
            this.gAJ = (ImageView) this.gAt.findViewById(d.h.write_close_view);
            this.gAs = this.gAt.findViewById(d.h.view_background);
            this.gAK = (GridLayout) this.gAt.findViewById(d.h.type_container);
            this.gAK.setMeasureAllChild(true);
            this.gAK.setVerNum(2);
            this.eGH.add(this.gAx);
            this.eGH.add(this.gAu);
            this.gAS = XiaoyingUtil.showXiaoyingTool();
            a(this.gAK, this.gAS);
            if (!this.gAS) {
                this.gAA.setVisibility(8);
                this.gAD.setPadding(0, k.f(this.aby.getPageActivity(), d.f.ds60), 0, 0);
            } else {
                this.eGH.add(this.gAA);
                this.gAD.setPadding(0, 0, 0, k.f(this.aby.getPageActivity(), d.f.ds120));
            }
            this.eGH.add(this.gAD);
            this.gAT = ae.fT();
            if (this.gAT) {
                this.eGH.add(this.gAG);
            } else {
                this.gAG.setVisibility(8);
            }
            b(this.gAK, this.gAT);
            this.gAt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bK(b.this.gAK);
                }
            });
            this.gAE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bxE();
                    MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                    String str = "0";
                    String str2 = null;
                    com.baidu.adp.lib.d.a.fd().D(false);
                    if (b.this.gAQ != null) {
                        str = b.this.gAQ.forumId;
                        str2 = b.this.gAQ.forumName;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, new AlaLiveRoomActivityConfig(TbadkCoreApplication.getInst().getApplicationContext(), str2, str, TbadkCoreApplication.getCurrentAccount(), true, false)));
                }
            });
            this.gAv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    int i;
                    b.this.bxE();
                    String str2 = "0";
                    String str3 = null;
                    PostPrefixData postPrefixData = null;
                    AntiData antiData = null;
                    if (b.this.gAQ != null) {
                        str2 = b.this.gAQ.forumId;
                        str3 = b.this.gAQ.forumName;
                        postPrefixData = b.this.gAQ.prefixData;
                        antiData = b.this.gAQ.antiData;
                        int i2 = b.this.gAQ.forumLevel;
                        str = b.this.gAQ.avatar;
                        i = i2;
                    } else {
                        str = null;
                        i = -1;
                    }
                    TiebaStatic.log(new ak("c12373").ad("obj_locate", b.this.gAR).ad("fid", str2));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(b.this.aby.getPageActivity(), 0, str2, str3, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.setCallFrom(b.this.gAR);
                    writeActivityConfig.setForumLevel(i);
                    writeActivityConfig.setForumAvatar(str);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            });
            this.gAy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    int i;
                    b.this.bxE();
                    String str2 = "0";
                    String str3 = null;
                    PostPrefixData postPrefixData = null;
                    AntiData antiData = null;
                    if (b.this.gAQ != null) {
                        str2 = b.this.gAQ.forumId;
                        str3 = b.this.gAQ.forumName;
                        postPrefixData = b.this.gAQ.prefixData;
                        antiData = b.this.gAQ.antiData;
                        int i2 = b.this.gAQ.forumLevel;
                        str = b.this.gAQ.avatar;
                        i = i2;
                    } else {
                        str = null;
                        i = -1;
                    }
                    TiebaStatic.log(new ak("c12372").ad("obj_locate", b.this.gAR).ad("fid", str2));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(b.this.aby.getPageActivity(), 9, str2, str3, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.setCallFrom(b.this.gAR);
                    writeActivityConfig.setForumLevel(i);
                    writeActivityConfig.setForumAvatar(str);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            });
            if (this.gAT) {
                this.gAH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        b.this.bxE();
                        String str = "0";
                        String str2 = null;
                        if (b.this.gAQ != null) {
                            str = b.this.gAQ.forumId;
                            str2 = b.this.gAQ.forumName;
                        }
                        WriteUrlActivityConfig writeUrlActivityConfig = new WriteUrlActivityConfig(b.this.aby.getPageActivity(), str, str2, b.this.gAR);
                        writeUrlActivityConfig.setRequestCode(13003);
                        writeUrlActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeUrlActivityConfig));
                        TiebaStatic.log(new ak("c12162").ad("obj_locate", b.this.gAR));
                    }
                });
            }
            if (this.gAS) {
                this.gAB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        b.this.bxE();
                        String str = "0";
                        String str2 = null;
                        if (b.this.gAQ != null) {
                            str = b.this.gAQ.forumId;
                            str2 = b.this.gAQ.forumName;
                        }
                        e.c(b.this.aby, str, str2);
                    }
                });
            }
            onChangeSkinType();
            this.gAU = AnimationUtils.loadAnimation(this.aby.getPageActivity(), d.a.write_thread_black_anim);
            this.gAU.setFillAfter(true);
            this.gAV = AnimationUtils.loadAnimation(this.aby.getPageActivity(), d.a.write_thread_black_hide_anim);
            this.gAV.setFillAfter(true);
            this.gAW = AnimationUtils.loadAnimation(this.aby.getPageActivity(), d.a.write_tab_bg_anim);
            this.gAW.setFillAfter(true);
            this.gAX = AnimationUtils.loadAnimation(this.aby.getPageActivity(), d.a.home_write_bgout);
            this.gAX.setFillAfter(true);
        }
    }

    private void a(GridLayout gridLayout, boolean z) {
        if (!z) {
            this.gAA.setVisibility(8);
            if (gridLayout.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) gridLayout.getLayoutParams()).bottomMargin = k.f(this.aby.getPageActivity(), d.f.ds60);
            }
        }
    }

    private void b(GridLayout gridLayout, boolean z) {
        if (!z) {
            this.gAG.setVisibility(8);
            if (gridLayout.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) gridLayout.getLayoutParams()).bottomMargin = k.f(this.aby.getPageActivity(), d.f.ds60);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private View mView;

        public a(View view) {
            this.mView = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.clearAnimation();
            b.this.gAx.setVisibility(4);
            b.this.gAu.setVisibility(4);
            if (b.this.gAS) {
                b.this.gAA.setVisibility(4);
            } else {
                b.this.gAA.setVisibility(8);
            }
            if (b.this.gAT) {
                b.this.gAG.setVisibility(4);
            } else {
                b.this.gAG.setVisibility(8);
            }
            b.this.gAD.setVisibility(4);
            b.this.gAJ.setVisibility(4);
            b.this.gAs.setVisibility(4);
            if (this.mView != null) {
                this.mView.setVisibility(8);
            }
            if (b.this.gAt.getParent() == b.this.aaQ) {
                b.this.aaQ.removeView(b.this.gAt);
            }
            b.this.gAM = false;
        }
    }

    public void ni(boolean z) {
        if (!this.gAM && this.gAO && this.gAP && this.aaQ != null) {
            this.gAJ.clearAnimation();
            this.gAM = true;
            if (this.gAt.getParent() == null) {
                com.baidu.tbadk.k.d.P(this.aaQ).a(this.aaQ, this.gAt, z);
            }
            this.gAK.setVisibility(0);
            this.gAs.setVisibility(0);
            this.gAs.clearAnimation();
            this.gAs.startAnimation(this.gAW);
            this.gAJ.setVisibility(0);
            this.gAJ.startAnimation(this.gAU);
            bxC();
            TiebaStatic.log(new ak("c12052").ad("obj_locate", this.gAR));
        }
    }

    private void bxC() {
        clearAnimation();
        final int size = this.eGH.size();
        this.gAO = false;
        this.gAN = 0;
        for (int i = 0; i < size; i++) {
            final View view = this.eGH.get(i);
            com.baidu.adp.lib.g.e.fQ().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.b.7
                @Override // java.lang.Runnable
                public void run() {
                    view.setVisibility(0);
                    Animation loadAnimation = AnimationUtils.loadAnimation(b.this.aby.getPageActivity(), d.a.write_tab_icon_show_anim);
                    loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.b.7.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            b.r(b.this);
                            if (b.this.gAN == size) {
                                b.this.gAO = true;
                                b.this.gAN = 0;
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }
                    });
                    view.startAnimation(loadAnimation);
                }
            }, i * 50);
        }
    }

    public void bxD() {
        bK(this.gAK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bK(View view) {
        if (this.gAO && this.gAP) {
            if (this.gAL != null) {
                com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.gAL);
            }
            this.gAs.clearAnimation();
            this.gAs.startAnimation(this.gAX);
            this.gAJ.clearAnimation();
            this.gAJ.startAnimation(this.gAV);
            bxF();
            this.gAL = new a(view);
            com.baidu.adp.lib.g.e.fQ().postDelayed(this.gAL, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxE() {
        this.gAO = true;
        this.gAP = true;
        if (this.gAL != null) {
            com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.gAL);
        }
        if (this.gAL == null) {
            this.gAL = new a(this.gAK);
        }
        com.baidu.adp.lib.g.e.fQ().postDelayed(this.gAL, 500L);
    }

    private void bxF() {
        clearAnimation();
        int size = this.eGH.size();
        this.gAN = size;
        this.gAP = false;
        int i = size - 1;
        for (int i2 = 0; i2 < size; i2++) {
            final View view = this.eGH.get(i);
            i--;
            com.baidu.adp.lib.g.e.fQ().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.b.8
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(b.this.aby.getPageActivity(), d.a.write_tab_icon_hide_anim);
                    loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.b.8.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            view.setVisibility(4);
                            if (b.this.gAN == 1) {
                                b.this.gAP = true;
                            } else {
                                b.t(b.this);
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }
                    });
                    view.startAnimation(loadAnimation);
                }
            }, i2 * 50);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAnimation() {
        this.gAx.clearAnimation();
        this.gAu.clearAnimation();
        this.gAA.clearAnimation();
        this.gAD.clearAnimation();
        this.gAG.clearAnimation();
    }

    public void onChangeSkinType() {
        aj.k(this.gAs, d.e.cp_bg_line_d_alpha98);
        aj.c(this.gAv, d.g.icon_posts_photo_n);
        aj.c(this.gAy, d.g.icon_posts_article_n);
        aj.c(this.gAB, d.g.icon_posts_video_n);
        aj.c(this.gAE, d.g.icon_posts_live_n);
        aj.c(this.gAJ, d.g.icon_tabbar_add_s);
        aj.c(this.gAH, d.g.icon_posts_url_n);
        aj.i(this.gAw, d.e.cp_cont_f);
        aj.i(this.gAz, d.e.cp_cont_f);
        aj.i(this.gAC, d.e.cp_cont_f);
        aj.i(this.gAF, d.e.cp_cont_f);
        aj.i(this.gAI, d.e.cp_cont_f);
    }

    public void onDestroy() {
        if (this.gAt != null && this.gAt.getParent() == this.aaQ) {
            this.aaQ.removeView(this.gAt);
        }
        if (this.gAL != null) {
            com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.gAL);
            this.gAL = null;
        }
        this.eGH.clear();
    }

    public boolean isShowing() {
        return this.gAM;
    }
}
