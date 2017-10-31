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
    private GridLayout gPA;
    private a gPB;
    private ForumWriteData gPG;
    private String gPH;
    private boolean gPI;
    private boolean gPJ;
    private Animation gPK;
    private Animation gPL;
    private Animation gPM;
    private Animation gPN;
    private View gPi;
    private View gPj;
    private LinearLayout gPk;
    private TbImageView gPl;
    private TextView gPm;
    private LinearLayout gPn;
    private TbImageView gPo;
    private TextView gPp;
    private LinearLayout gPq;
    private TbImageView gPr;
    private TextView gPs;
    private LinearLayout gPt;
    private TbImageView gPu;
    private TextView gPv;
    private LinearLayout gPw;
    private TbImageView gPx;
    private TextView gPy;
    private ImageView gPz;
    private ViewGroup mRootView;
    private boolean gPC = false;
    private int gPD = 0;
    private boolean gPE = true;
    private boolean gPF = true;
    private ArrayList<View> eHT = new ArrayList<>();

    static /* synthetic */ int s(c cVar) {
        int i = cVar.gPD;
        cVar.gPD = i + 1;
        return i;
    }

    static /* synthetic */ int u(c cVar) {
        int i = cVar.gPD;
        cVar.gPD = i - 1;
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
        this.gPG = forumWriteData;
    }

    public void tJ(String str) {
        this.gPH = str;
    }

    private void initView() {
        if (this.abI != null && this.abI.getPageActivity() != null && this.mRootView != null) {
            this.gPj = LayoutInflater.from(this.abI.getPageActivity()).inflate(d.h.bottom_write_thread, (ViewGroup) null);
            this.gPn = (LinearLayout) this.gPj.findViewById(d.g.home_write_article);
            this.gPo = (TbImageView) this.gPj.findViewById(d.g.home_write_article_icon);
            this.gPp = (TextView) this.gPj.findViewById(d.g.home_write_article_title);
            this.gPk = (LinearLayout) this.gPj.findViewById(d.g.home_write_photo);
            this.gPl = (TbImageView) this.gPj.findViewById(d.g.home_write_photo_icon);
            this.gPm = (TextView) this.gPj.findViewById(d.g.home_write_photo_title);
            this.gPq = (LinearLayout) this.gPj.findViewById(d.g.home_write_video);
            this.gPr = (TbImageView) this.gPj.findViewById(d.g.home_write_video_icon);
            this.gPs = (TextView) this.gPj.findViewById(d.g.home_write_video_title);
            this.gPt = (LinearLayout) this.gPj.findViewById(d.g.home_write_live);
            this.gPu = (TbImageView) this.gPj.findViewById(d.g.home_write_live_icon);
            this.gPv = (TextView) this.gPj.findViewById(d.g.home_write_live_title);
            this.gPw = (LinearLayout) this.gPj.findViewById(d.g.home_write_url);
            this.gPx = (TbImageView) this.gPj.findViewById(d.g.home_write_url_icon);
            this.gPy = (TextView) this.gPj.findViewById(d.g.home_write_url_title);
            this.gPz = (ImageView) this.gPj.findViewById(d.g.write_close_view);
            this.gPi = this.gPj.findViewById(d.g.view_background);
            this.gPA = (GridLayout) this.gPj.findViewById(d.g.type_container);
            this.gPA.setMeasureAllChild(true);
            this.gPA.setVerNum(2);
            this.eHT.add(this.gPn);
            this.eHT.add(this.gPk);
            this.gPI = XiaoyingUtil.showXiaoyingTool();
            this.gPI = true;
            a(this.gPA, this.gPI);
            if (!this.gPI) {
                this.gPq.setVisibility(8);
                this.gPt.setPadding(0, l.f(this.abI.getPageActivity(), d.e.ds60), 0, 0);
            } else {
                this.eHT.add(this.gPq);
                this.gPt.setPadding(0, 0, 0, l.f(this.abI.getPageActivity(), d.e.ds120));
            }
            this.eHT.add(this.gPt);
            this.gPJ = af.fS();
            if (this.gPJ) {
                this.eHT.add(this.gPw);
            } else {
                this.gPw.setVisibility(8);
            }
            b(this.gPA, this.gPJ);
            this.gPj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.bO(c.this.gPA);
                }
            });
            this.gPu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.bCk();
                    MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                    String str = "0";
                    String str2 = null;
                    com.baidu.adp.lib.d.a.fc().D(false);
                    if (c.this.gPG != null) {
                        str = c.this.gPG.forumId;
                        str2 = c.this.gPG.forumName;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaMasterLiveRoomActivityConfig(TbadkCoreApplication.getInst().getApplicationContext(), str2, str, TbadkCoreApplication.getCurrentAccount(), false)));
                }
            });
            this.gPl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    int i;
                    c.this.bCk();
                    String str2 = "0";
                    String str3 = null;
                    PostPrefixData postPrefixData = null;
                    AntiData antiData = null;
                    if (c.this.gPG != null) {
                        str2 = c.this.gPG.forumId;
                        str3 = c.this.gPG.forumName;
                        postPrefixData = c.this.gPG.prefixData;
                        antiData = c.this.gPG.antiData;
                        int i2 = c.this.gPG.forumLevel;
                        str = c.this.gPG.avatar;
                        i = i2;
                    } else {
                        str = null;
                        i = -1;
                    }
                    TiebaStatic.log(new ak("c12373").ac("obj_locate", c.this.gPH).ac(ImageViewerConfig.FORUM_ID, str2));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.abI.getPageActivity(), 0, str2, str3, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", c.this.aiB);
                    writeActivityConfig.setCallFrom(c.this.gPH);
                    writeActivityConfig.setForumLevel(i);
                    writeActivityConfig.setForumAvatar(str);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            });
            this.gPo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    int i;
                    c.this.bCk();
                    String str2 = "0";
                    String str3 = null;
                    PostPrefixData postPrefixData = null;
                    AntiData antiData = null;
                    if (c.this.gPG != null) {
                        str2 = c.this.gPG.forumId;
                        str3 = c.this.gPG.forumName;
                        postPrefixData = c.this.gPG.prefixData;
                        antiData = c.this.gPG.antiData;
                        int i2 = c.this.gPG.forumLevel;
                        str = c.this.gPG.avatar;
                        i = i2;
                    } else {
                        str = null;
                        i = -1;
                    }
                    TiebaStatic.log(new ak("c12372").ac("obj_locate", c.this.gPH).ac(ImageViewerConfig.FORUM_ID, str2));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.abI.getPageActivity(), 9, str2, str3, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", c.this.aiB);
                    writeActivityConfig.setCallFrom(c.this.gPH);
                    writeActivityConfig.setForumLevel(i);
                    writeActivityConfig.setForumAvatar(str);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            });
            if (this.gPJ) {
                this.gPx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.bCk();
                        String str = "0";
                        String str2 = null;
                        if (c.this.gPG != null) {
                            str = c.this.gPG.forumId;
                            str2 = c.this.gPG.forumName;
                        }
                        WriteUrlActivityConfig writeUrlActivityConfig = new WriteUrlActivityConfig(c.this.abI.getPageActivity(), str, str2, c.this.gPH);
                        writeUrlActivityConfig.getIntent().putExtra("from", c.this.aiB);
                        writeUrlActivityConfig.setRequestCode(13003);
                        writeUrlActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeUrlActivityConfig));
                        TiebaStatic.log(new ak("c12162").ac("obj_locate", c.this.gPH));
                    }
                });
            }
            if (this.gPI) {
                this.gPr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.bCk();
                        String str = "0";
                        String str2 = null;
                        if (c.this.gPH.equals("1")) {
                            TiebaStatic.log(new ak("c12292").ac("obj_locate", "2"));
                        } else {
                            TiebaStatic.log(new ak("c12292").ac("obj_locate", "1"));
                        }
                        if (c.this.gPG != null) {
                            str = c.this.gPG.forumId;
                            str2 = c.this.gPG.forumName;
                        }
                        f.b(c.this.abI, str, str2);
                    }
                });
            }
            onChangeSkinType();
            this.gPK = AnimationUtils.loadAnimation(this.abI.getPageActivity(), d.a.write_thread_black_anim);
            this.gPK.setFillAfter(true);
            this.gPL = AnimationUtils.loadAnimation(this.abI.getPageActivity(), d.a.write_thread_black_hide_anim);
            this.gPL.setFillAfter(true);
            this.gPM = AnimationUtils.loadAnimation(this.abI.getPageActivity(), d.a.write_tab_bg_anim);
            this.gPM.setFillAfter(true);
            this.gPN = AnimationUtils.loadAnimation(this.abI.getPageActivity(), d.a.home_write_bgout);
            this.gPN.setFillAfter(true);
        }
    }

    private void a(GridLayout gridLayout, boolean z) {
        if (!z) {
            this.gPq.setVisibility(8);
            if (gridLayout.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) gridLayout.getLayoutParams()).bottomMargin = l.f(this.abI.getPageActivity(), d.e.ds60);
            }
        }
    }

    private void b(GridLayout gridLayout, boolean z) {
        if (!z) {
            this.gPw.setVisibility(8);
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
            c.this.gPn.setVisibility(4);
            c.this.gPk.setVisibility(4);
            if (c.this.gPI) {
                c.this.gPq.setVisibility(4);
            } else {
                c.this.gPq.setVisibility(8);
            }
            if (c.this.gPJ) {
                c.this.gPw.setVisibility(4);
            } else {
                c.this.gPw.setVisibility(8);
            }
            c.this.gPt.setVisibility(4);
            c.this.gPz.setVisibility(4);
            c.this.gPi.setVisibility(4);
            if (this.mView != null) {
                this.mView.setVisibility(8);
            }
            if (c.this.gPj.getParent() == c.this.mRootView) {
                c.this.mRootView.removeView(c.this.gPj);
            }
            c.this.gPC = false;
        }
    }

    public void nk(boolean z) {
        if (!this.gPC && this.gPE && this.gPF && this.mRootView != null) {
            this.gPz.clearAnimation();
            this.gPC = true;
            if (this.gPj.getParent() == null) {
                com.baidu.tbadk.k.d.Q(this.mRootView).a(this.mRootView, this.gPj, z);
            }
            this.gPA.setVisibility(0);
            this.gPi.setVisibility(0);
            this.gPi.clearAnimation();
            this.gPi.startAnimation(this.gPM);
            this.gPz.setVisibility(0);
            this.gPz.startAnimation(this.gPK);
            bCi();
            TiebaStatic.log(new ak("c12052").ac("obj_locate", this.gPH));
        }
    }

    private void bCi() {
        clearAnimation();
        final int size = this.eHT.size();
        this.gPE = false;
        this.gPD = 0;
        for (int i = 0; i < size; i++) {
            final View view = this.eHT.get(i);
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
                            if (c.this.gPD == size) {
                                c.this.gPE = true;
                                c.this.gPD = 0;
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

    public void bCj() {
        bO(this.gPA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bO(View view) {
        if (this.gPE && this.gPF) {
            if (this.gPB != null) {
                com.baidu.adp.lib.g.e.fP().removeCallbacks(this.gPB);
            }
            this.gPi.clearAnimation();
            this.gPi.startAnimation(this.gPN);
            this.gPz.clearAnimation();
            this.gPz.startAnimation(this.gPL);
            bCl();
            this.gPB = new a(view);
            com.baidu.adp.lib.g.e.fP().postDelayed(this.gPB, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCk() {
        this.gPE = true;
        this.gPF = true;
        if (this.gPB != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.gPB);
        }
        if (this.gPB == null) {
            this.gPB = new a(this.gPA);
        }
        com.baidu.adp.lib.g.e.fP().postDelayed(this.gPB, 500L);
    }

    private void bCl() {
        clearAnimation();
        int size = this.eHT.size();
        this.gPD = size;
        this.gPF = false;
        int i = size - 1;
        for (int i2 = 0; i2 < size; i2++) {
            final View view = this.eHT.get(i);
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
                            if (c.this.gPD == 1) {
                                c.this.gPF = true;
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
        this.gPn.clearAnimation();
        this.gPk.clearAnimation();
        this.gPq.clearAnimation();
        this.gPt.clearAnimation();
        this.gPw.clearAnimation();
    }

    public void onChangeSkinType() {
        aj.k(this.gPi, d.C0080d.cp_bg_line_d_alpha98);
        aj.c(this.gPl, d.f.icon_posts_photo_n);
        aj.c(this.gPo, d.f.icon_posts_article_n);
        aj.c(this.gPr, d.f.icon_posts_video_n);
        aj.c(this.gPu, d.f.icon_posts_live_n);
        aj.c(this.gPz, d.f.icon_tabbar_add_s);
        aj.c(this.gPx, d.f.icon_posts_url_n);
        aj.i(this.gPm, d.C0080d.cp_cont_f);
        aj.i(this.gPp, d.C0080d.cp_cont_f);
        aj.i(this.gPs, d.C0080d.cp_cont_f);
        aj.i(this.gPv, d.C0080d.cp_cont_f);
        aj.i(this.gPy, d.C0080d.cp_cont_f);
    }

    public void onDestroy() {
        if (this.gPj != null && this.gPj.getParent() == this.mRootView) {
            this.mRootView.removeView(this.gPj);
        }
        if (this.gPB != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.gPB);
            this.gPB = null;
        }
        this.eHT.clear();
    }

    public boolean isShowing() {
        return this.gPC;
    }
}
