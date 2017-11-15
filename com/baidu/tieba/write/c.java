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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaMasterLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
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
import com.baidu.tbadk.p.af;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.GridLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ForumWriteData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c {
    private TbPageContext abI;
    private String aiB;
    private TextView gQA;
    private LinearLayout gQB;
    private TbImageView gQC;
    private TextView gQD;
    private LinearLayout gQE;
    private TbImageView gQF;
    private TextView gQG;
    private ImageView gQH;
    private GridLayout gQI;
    private a gQJ;
    private ForumWriteData gQO;
    private String gQP;
    private boolean gQQ;
    private boolean gQR;
    private Animation gQS;
    private Animation gQT;
    private Animation gQU;
    private Animation gQV;
    private View gQq;
    private View gQr;
    private LinearLayout gQs;
    private TbImageView gQt;
    private TextView gQu;
    private LinearLayout gQv;
    private TbImageView gQw;
    private TextView gQx;
    private LinearLayout gQy;
    private TbImageView gQz;
    private ViewGroup mRootView;
    private boolean gQK = false;
    private int gQL = 0;
    private boolean gQM = true;
    private boolean gQN = true;
    private ArrayList<View> eIn = new ArrayList<>();

    static /* synthetic */ int s(c cVar) {
        int i = cVar.gQL;
        cVar.gQL = i + 1;
        return i;
    }

    static /* synthetic */ int u(c cVar) {
        int i = cVar.gQL;
        cVar.gQL = i - 1;
        return i;
    }

    public c(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this.aiB = AlbumActivityConfig.FROM_WRITE;
        this.abI = tbPageContext;
        this.mRootView = viewGroup;
        this.aiB = str;
        initView();
    }

    public void a(ForumWriteData forumWriteData) {
        this.gQO = forumWriteData;
    }

    public void tP(String str) {
        this.gQP = str;
    }

    private void initView() {
        if (this.abI != null && this.abI.getPageActivity() != null && this.mRootView != null) {
            this.gQr = LayoutInflater.from(this.abI.getPageActivity()).inflate(d.h.bottom_write_thread, (ViewGroup) null);
            this.gQv = (LinearLayout) this.gQr.findViewById(d.g.home_write_article);
            this.gQw = (TbImageView) this.gQr.findViewById(d.g.home_write_article_icon);
            this.gQx = (TextView) this.gQr.findViewById(d.g.home_write_article_title);
            this.gQs = (LinearLayout) this.gQr.findViewById(d.g.home_write_photo);
            this.gQt = (TbImageView) this.gQr.findViewById(d.g.home_write_photo_icon);
            this.gQu = (TextView) this.gQr.findViewById(d.g.home_write_photo_title);
            this.gQy = (LinearLayout) this.gQr.findViewById(d.g.home_write_video);
            this.gQz = (TbImageView) this.gQr.findViewById(d.g.home_write_video_icon);
            this.gQA = (TextView) this.gQr.findViewById(d.g.home_write_video_title);
            this.gQB = (LinearLayout) this.gQr.findViewById(d.g.home_write_live);
            this.gQC = (TbImageView) this.gQr.findViewById(d.g.home_write_live_icon);
            this.gQD = (TextView) this.gQr.findViewById(d.g.home_write_live_title);
            this.gQE = (LinearLayout) this.gQr.findViewById(d.g.home_write_url);
            this.gQF = (TbImageView) this.gQr.findViewById(d.g.home_write_url_icon);
            this.gQG = (TextView) this.gQr.findViewById(d.g.home_write_url_title);
            this.gQH = (ImageView) this.gQr.findViewById(d.g.write_close_view);
            this.gQq = this.gQr.findViewById(d.g.view_background);
            this.gQI = (GridLayout) this.gQr.findViewById(d.g.type_container);
            this.gQI.setMeasureAllChild(true);
            this.gQI.setVerNum(2);
            this.eIn.add(this.gQv);
            this.eIn.add(this.gQs);
            this.gQQ = XiaoyingUtil.showXiaoyingTool();
            this.gQQ = true;
            a(this.gQI, this.gQQ);
            if (!this.gQQ) {
                this.gQy.setVisibility(8);
                this.gQB.setPadding(0, l.f(this.abI.getPageActivity(), d.e.ds60), 0, 0);
            } else {
                this.eIn.add(this.gQy);
                this.gQB.setPadding(0, 0, 0, l.f(this.abI.getPageActivity(), d.e.ds120));
            }
            this.eIn.add(this.gQB);
            this.gQR = af.fS();
            if (this.gQR) {
                this.eIn.add(this.gQE);
            } else {
                this.gQE.setVisibility(8);
            }
            b(this.gQI, this.gQR);
            this.gQr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.bP(c.this.gQI);
                }
            });
            this.gQC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.bCw();
                    MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                    String str = "0";
                    String str2 = null;
                    com.baidu.adp.lib.d.a.fc().D(false);
                    if (c.this.gQO != null) {
                        str = c.this.gQO.forumId;
                        str2 = c.this.gQO.forumName;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaMasterLiveRoomActivityConfig(TbadkCoreApplication.getInst().getApplicationContext(), str2, str, TbadkCoreApplication.getCurrentAccount(), false)));
                }
            });
            this.gQt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    int i;
                    c.this.bCw();
                    String str2 = "0";
                    String str3 = null;
                    PostPrefixData postPrefixData = null;
                    AntiData antiData = null;
                    if (c.this.gQO != null) {
                        str2 = c.this.gQO.forumId;
                        str3 = c.this.gQO.forumName;
                        postPrefixData = c.this.gQO.prefixData;
                        antiData = c.this.gQO.antiData;
                        int i2 = c.this.gQO.forumLevel;
                        str = c.this.gQO.avatar;
                        i = i2;
                    } else {
                        str = null;
                        i = -1;
                    }
                    TiebaStatic.log(new ak("c12373").ac("obj_locate", c.this.gQP).ac(ImageViewerConfig.FORUM_ID, str2));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.abI.getPageActivity(), 0, str2, str3, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", c.this.aiB);
                    writeActivityConfig.setCallFrom(c.this.gQP);
                    writeActivityConfig.setForumLevel(i);
                    writeActivityConfig.setForumAvatar(str);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            });
            this.gQw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    int i;
                    c.this.bCw();
                    String str2 = "0";
                    String str3 = null;
                    PostPrefixData postPrefixData = null;
                    AntiData antiData = null;
                    if (c.this.gQO != null) {
                        str2 = c.this.gQO.forumId;
                        str3 = c.this.gQO.forumName;
                        postPrefixData = c.this.gQO.prefixData;
                        antiData = c.this.gQO.antiData;
                        int i2 = c.this.gQO.forumLevel;
                        str = c.this.gQO.avatar;
                        i = i2;
                    } else {
                        str = null;
                        i = -1;
                    }
                    TiebaStatic.log(new ak("c12372").ac("obj_locate", c.this.gQP).ac(ImageViewerConfig.FORUM_ID, str2));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.abI.getPageActivity(), 9, str2, str3, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", c.this.aiB);
                    writeActivityConfig.setCallFrom(c.this.gQP);
                    writeActivityConfig.setForumLevel(i);
                    writeActivityConfig.setForumAvatar(str);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            });
            if (this.gQR) {
                this.gQF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.bCw();
                        String str = "0";
                        String str2 = null;
                        if (c.this.gQO != null) {
                            str = c.this.gQO.forumId;
                            str2 = c.this.gQO.forumName;
                        }
                        WriteUrlActivityConfig writeUrlActivityConfig = new WriteUrlActivityConfig(c.this.abI.getPageActivity(), str, str2, c.this.gQP);
                        writeUrlActivityConfig.getIntent().putExtra("from", c.this.aiB);
                        writeUrlActivityConfig.setRequestCode(13003);
                        writeUrlActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeUrlActivityConfig));
                        TiebaStatic.log(new ak("c12162").ac("obj_locate", c.this.gQP));
                    }
                });
            }
            if (this.gQQ) {
                this.gQz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.bCw();
                        String str = "0";
                        String str2 = null;
                        if (c.this.gQP.equals("1")) {
                            TiebaStatic.log(new ak("c12292").ac("obj_locate", "2"));
                        } else {
                            TiebaStatic.log(new ak("c12292").ac("obj_locate", "1"));
                        }
                        if (c.this.gQO != null) {
                            str = c.this.gQO.forumId;
                            str2 = c.this.gQO.forumName;
                        }
                        f.b(c.this.abI, str, str2);
                    }
                });
            }
            onChangeSkinType();
            this.gQS = AnimationUtils.loadAnimation(this.abI.getPageActivity(), d.a.write_thread_black_anim);
            this.gQS.setFillAfter(true);
            this.gQT = AnimationUtils.loadAnimation(this.abI.getPageActivity(), d.a.write_thread_black_hide_anim);
            this.gQT.setFillAfter(true);
            this.gQU = AnimationUtils.loadAnimation(this.abI.getPageActivity(), d.a.write_tab_bg_anim);
            this.gQU.setFillAfter(true);
            this.gQV = AnimationUtils.loadAnimation(this.abI.getPageActivity(), d.a.home_write_bgout);
            this.gQV.setFillAfter(true);
        }
    }

    private void a(GridLayout gridLayout, boolean z) {
        if (!z) {
            this.gQy.setVisibility(8);
            if (gridLayout.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) gridLayout.getLayoutParams()).bottomMargin = l.f(this.abI.getPageActivity(), d.e.ds60);
            }
        }
    }

    private void b(GridLayout gridLayout, boolean z) {
        if (!z) {
            this.gQE.setVisibility(8);
            if (gridLayout.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) gridLayout.getLayoutParams()).bottomMargin = l.f(this.abI.getPageActivity(), d.e.ds60);
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
            c.this.clearAnimation();
            c.this.gQv.setVisibility(4);
            c.this.gQs.setVisibility(4);
            if (c.this.gQQ) {
                c.this.gQy.setVisibility(4);
            } else {
                c.this.gQy.setVisibility(8);
            }
            if (c.this.gQR) {
                c.this.gQE.setVisibility(4);
            } else {
                c.this.gQE.setVisibility(8);
            }
            c.this.gQB.setVisibility(4);
            c.this.gQH.setVisibility(4);
            c.this.gQq.setVisibility(4);
            if (this.mView != null) {
                this.mView.setVisibility(8);
            }
            if (c.this.gQr.getParent() == c.this.mRootView) {
                c.this.mRootView.removeView(c.this.gQr);
            }
            c.this.gQK = false;
        }
    }

    public void ns(boolean z) {
        if (!this.gQK && this.gQM && this.gQN && this.mRootView != null) {
            this.gQH.clearAnimation();
            this.gQK = true;
            if (this.gQr.getParent() == null) {
                com.baidu.tbadk.k.d.Q(this.mRootView).a(this.mRootView, this.gQr, z);
            }
            this.gQI.setVisibility(0);
            this.gQq.setVisibility(0);
            this.gQq.clearAnimation();
            this.gQq.startAnimation(this.gQU);
            this.gQH.setVisibility(0);
            this.gQH.startAnimation(this.gQS);
            bCu();
            TiebaStatic.log(new ak("c12052").ac("obj_locate", this.gQP));
        }
    }

    private void bCu() {
        clearAnimation();
        final int size = this.eIn.size();
        this.gQM = false;
        this.gQL = 0;
        for (int i = 0; i < size; i++) {
            final View view = this.eIn.get(i);
            com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.c.7
                @Override // java.lang.Runnable
                public void run() {
                    view.setVisibility(0);
                    Animation loadAnimation = AnimationUtils.loadAnimation(c.this.abI.getPageActivity(), d.a.write_tab_icon_show_anim);
                    loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.c.7.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            c.s(c.this);
                            if (c.this.gQL == size) {
                                c.this.gQM = true;
                                c.this.gQL = 0;
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

    public void bCv() {
        bP(this.gQI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bP(View view) {
        if (this.gQM && this.gQN) {
            if (this.gQJ != null) {
                com.baidu.adp.lib.g.e.fP().removeCallbacks(this.gQJ);
            }
            this.gQq.clearAnimation();
            this.gQq.startAnimation(this.gQV);
            this.gQH.clearAnimation();
            this.gQH.startAnimation(this.gQT);
            bCx();
            this.gQJ = new a(view);
            com.baidu.adp.lib.g.e.fP().postDelayed(this.gQJ, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCw() {
        this.gQM = true;
        this.gQN = true;
        if (this.gQJ != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.gQJ);
        }
        if (this.gQJ == null) {
            this.gQJ = new a(this.gQI);
        }
        com.baidu.adp.lib.g.e.fP().postDelayed(this.gQJ, 500L);
    }

    private void bCx() {
        clearAnimation();
        int size = this.eIn.size();
        this.gQL = size;
        this.gQN = false;
        int i = size - 1;
        for (int i2 = 0; i2 < size; i2++) {
            final View view = this.eIn.get(i);
            i--;
            com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.c.8
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(c.this.abI.getPageActivity(), d.a.write_tab_icon_hide_anim);
                    loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.c.8.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            view.setVisibility(4);
                            if (c.this.gQL == 1) {
                                c.this.gQN = true;
                            } else {
                                c.u(c.this);
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
        this.gQv.clearAnimation();
        this.gQs.clearAnimation();
        this.gQy.clearAnimation();
        this.gQB.clearAnimation();
        this.gQE.clearAnimation();
    }

    public void onChangeSkinType() {
        aj.k(this.gQq, d.C0080d.cp_bg_line_d_alpha98);
        aj.c(this.gQt, d.f.icon_posts_photo_n);
        aj.c(this.gQw, d.f.icon_posts_article_n);
        aj.c(this.gQz, d.f.icon_posts_video_n);
        aj.c(this.gQC, d.f.icon_posts_live_n);
        aj.c(this.gQH, d.f.icon_tabbar_add_s);
        aj.c(this.gQF, d.f.icon_posts_url_n);
        aj.i(this.gQu, d.C0080d.cp_cont_f);
        aj.i(this.gQx, d.C0080d.cp_cont_f);
        aj.i(this.gQA, d.C0080d.cp_cont_f);
        aj.i(this.gQD, d.C0080d.cp_cont_f);
        aj.i(this.gQG, d.C0080d.cp_cont_f);
    }

    public void onDestroy() {
        if (this.gQr != null && this.gQr.getParent() == this.mRootView) {
            this.mRootView.removeView(this.gQr);
        }
        if (this.gQJ != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.gQJ);
            this.gQJ = null;
        }
        this.eIn.clear();
    }

    public boolean isShowing() {
        return this.gQK;
    }
}
