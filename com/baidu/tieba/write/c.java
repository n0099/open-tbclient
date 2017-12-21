package com.baidu.tieba.write;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaMasterLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.GridLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ForumWriteData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c {
    private TbPageContext aca;
    private ForumWriteData gYE;
    private a heA;
    private Animation heF;
    private Animation heG;
    private Animation heH;
    private Animation heI;
    private View hek;
    private View hel;
    private LinearLayout hem;
    private TbImageView hen;
    private TextView heo;
    private LinearLayout hep;
    private TbImageView heq;
    private TextView her;
    private LinearLayout hes;
    private TbImageView het;
    private TextView heu;
    private LinearLayout hev;
    private TbImageView hew;
    private TextView hex;
    private ImageView hey;
    private GridLayout hez;
    private String mFrom;
    private ViewGroup mRootView;
    private String writeCallFrom;
    private boolean heB = false;
    private int heC = 0;
    private boolean heD = true;
    private boolean heE = true;
    private ArrayList<View> eQY = new ArrayList<>();
    private String heJ = "0";

    static /* synthetic */ int q(c cVar) {
        int i = cVar.heC;
        cVar.heC = i + 1;
        return i;
    }

    static /* synthetic */ int s(c cVar) {
        int i = cVar.heC;
        cVar.heC = i - 1;
        return i;
    }

    public c(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this.mFrom = AlbumActivityConfig.FROM_WRITE;
        this.aca = tbPageContext;
        this.mRootView = viewGroup;
        this.mFrom = str;
        initView();
    }

    public void a(ForumWriteData forumWriteData) {
        this.gYE = forumWriteData;
    }

    public void uC(String str) {
        if ("3".equals(str)) {
            this.writeCallFrom = "1";
        } else {
            this.writeCallFrom = str;
        }
        this.heJ = str;
    }

    private void initView() {
        if (this.aca != null && this.aca.getPageActivity() != null && this.mRootView != null) {
            this.hel = LayoutInflater.from(this.aca.getPageActivity()).inflate(d.h.bottom_write_thread, (ViewGroup) null);
            this.hep = (LinearLayout) this.hel.findViewById(d.g.home_write_article);
            this.heq = (TbImageView) this.hel.findViewById(d.g.home_write_article_icon);
            this.her = (TextView) this.hel.findViewById(d.g.home_write_article_title);
            this.hem = (LinearLayout) this.hel.findViewById(d.g.home_write_photo);
            this.hen = (TbImageView) this.hel.findViewById(d.g.home_write_photo_icon);
            this.heo = (TextView) this.hel.findViewById(d.g.home_write_photo_title);
            this.hes = (LinearLayout) this.hel.findViewById(d.g.home_write_album);
            this.het = (TbImageView) this.hel.findViewById(d.g.home_write_album_icon);
            this.heu = (TextView) this.hel.findViewById(d.g.home_write_album_title);
            this.hev = (LinearLayout) this.hel.findViewById(d.g.home_write_live);
            this.hew = (TbImageView) this.hel.findViewById(d.g.home_write_live_icon);
            this.hex = (TextView) this.hel.findViewById(d.g.home_write_live_title);
            this.hey = (ImageView) this.hel.findViewById(d.g.write_close_view);
            this.hek = this.hel.findViewById(d.g.view_background);
            this.hez = (GridLayout) this.hel.findViewById(d.g.type_container);
            this.hez.setMeasureAllChild(true);
            this.hez.setVerNum(1);
            bFJ();
            this.eQY.add(this.hep);
            this.eQY.add(this.hem);
            this.eQY.add(this.hes);
            this.eQY.add(this.hev);
            this.hel.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.bP(c.this.hez);
                }
            });
            this.heq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i;
                    String str;
                    int i2;
                    c.this.bFM();
                    String str2 = "0";
                    String str3 = null;
                    PostPrefixData postPrefixData = null;
                    AntiData antiData = null;
                    if (c.this.gYE != null) {
                        str2 = c.this.gYE.forumId;
                        str3 = c.this.gYE.forumName;
                        postPrefixData = c.this.gYE.prefixData;
                        antiData = c.this.gYE.antiData;
                        int i3 = c.this.gYE.forumLevel;
                        String str4 = c.this.gYE.avatar;
                        i = c.this.gYE.privateThread;
                        str = str4;
                        i2 = i3;
                    } else {
                        i = 0;
                        str = null;
                        i2 = -1;
                    }
                    TiebaStatic.log(new ak("c12611").ac("obj_locate", c.this.heJ).r("obj_type", 1));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.aca.getPageActivity(), 9, str2, str3, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", c.this.mFrom);
                    writeActivityConfig.setCallFrom(c.this.writeCallFrom);
                    writeActivityConfig.setForumLevel(i2);
                    writeActivityConfig.setForumAvatar(str);
                    writeActivityConfig.setPrivateThread(i);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            });
            this.hen.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.bFM();
                    TiebaStatic.log(new ak("c12611").ac("obj_locate", c.this.heJ).r("obj_type", 2));
                    if (c.this.gYE == null) {
                        c.this.gYE = new ForumWriteData("0", null, null, null);
                    }
                    c.this.gYE.mFrom = c.this.mFrom;
                    c.this.gYE.writeCallFrom = c.this.writeCallFrom;
                    f.a(c.this.aca, "", c.this.gYE);
                }
            });
            this.het.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i;
                    String str;
                    int i2;
                    c.this.bFM();
                    String str2 = "0";
                    String str3 = null;
                    PostPrefixData postPrefixData = null;
                    AntiData antiData = null;
                    if (c.this.gYE != null) {
                        str2 = c.this.gYE.forumId;
                        str3 = c.this.gYE.forumName;
                        postPrefixData = c.this.gYE.prefixData;
                        antiData = c.this.gYE.antiData;
                        int i3 = c.this.gYE.forumLevel;
                        String str4 = c.this.gYE.avatar;
                        i = c.this.gYE.privateThread;
                        str = str4;
                        i2 = i3;
                    } else {
                        i = 0;
                        str = null;
                        i2 = -1;
                    }
                    TiebaStatic.log(new ak("c12611").ac("obj_locate", c.this.heJ).r("obj_type", 3));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.aca.getPageActivity(), 0, str2, str3, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", c.this.mFrom);
                    writeActivityConfig.setCallFrom(c.this.writeCallFrom);
                    writeActivityConfig.setForumLevel(i2);
                    writeActivityConfig.setForumAvatar(str);
                    writeActivityConfig.setAlbumThread(1);
                    writeActivityConfig.setPrivateThread(i);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            });
            this.hew.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.bFM();
                    MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                    String str = "0";
                    String str2 = null;
                    TiebaStatic.log(new ak("c12611").ac("obj_locate", c.this.heJ).r("obj_type", 4));
                    com.baidu.adp.lib.d.a.fc().D(false);
                    if (c.this.gYE != null) {
                        str = c.this.gYE.forumId;
                        str2 = c.this.gYE.forumName;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaMasterLiveRoomActivityConfig(TbadkCoreApplication.getInst().getApplicationContext(), str2, str, TbadkCoreApplication.getCurrentAccount(), false)));
                }
            });
            onChangeSkinType();
            this.heF = AnimationUtils.loadAnimation(this.aca.getPageActivity(), d.a.write_thread_black_anim);
            this.heF.setFillAfter(true);
            this.heG = AnimationUtils.loadAnimation(this.aca.getPageActivity(), d.a.write_thread_black_hide_anim);
            this.heG.setFillAfter(true);
            this.heH = AnimationUtils.loadAnimation(this.aca.getPageActivity(), d.a.write_tab_bg_anim);
            this.heH.setFillAfter(true);
            this.heI = AnimationUtils.loadAnimation(this.aca.getPageActivity(), d.a.home_write_bgout);
            this.heI.setFillAfter(true);
        }
    }

    private void bFJ() {
        int ac = (int) (0.15555556f * l.ac(this.aca.getPageActivity()));
        a(this.heq, ac);
        a(this.hen, ac);
        a(this.het, ac);
        a(this.hew, ac);
        int ae = l.ae(this.aca.getPageActivity());
        ViewGroup.LayoutParams layoutParams = this.hez.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = ae / 5;
            this.hez.setLayoutParams(layoutParams);
        }
    }

    private void a(TbImageView tbImageView, int i) {
        if (tbImageView != null && i > 0) {
            ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i;
            tbImageView.setLayoutParams(layoutParams);
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
            c.this.hep.setVisibility(4);
            c.this.hem.setVisibility(4);
            c.this.hes.setVisibility(4);
            c.this.hev.setVisibility(4);
            c.this.hey.setVisibility(4);
            c.this.hek.setVisibility(4);
            if (this.mView != null) {
                this.mView.setVisibility(8);
            }
            if (c.this.hel.getParent() == c.this.mRootView) {
                c.this.mRootView.removeView(c.this.hel);
            }
            c.this.heB = false;
        }
    }

    public void nV(boolean z) {
        if (!this.heB && this.heD && this.heE && this.mRootView != null) {
            this.hey.clearAnimation();
            this.heB = true;
            if (this.hel.getParent() == null) {
                com.baidu.tbadk.j.d.R(this.mRootView).a(this.mRootView, this.hel, z);
            }
            this.hez.setVisibility(0);
            this.hek.setVisibility(0);
            this.hek.clearAnimation();
            this.hek.startAnimation(this.heH);
            this.hey.setVisibility(0);
            this.hey.startAnimation(this.heF);
            bFK();
            TiebaStatic.log(new ak("c12052").ac("obj_locate", this.heJ));
        }
    }

    private void bFK() {
        clearAnimation();
        final int size = this.eQY.size();
        this.heD = false;
        this.heC = 0;
        for (int i = 0; i < size; i++) {
            final View view = this.eQY.get(i);
            com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.c.6
                @Override // java.lang.Runnable
                public void run() {
                    view.setVisibility(0);
                    Animation loadAnimation = AnimationUtils.loadAnimation(c.this.aca.getPageActivity(), d.a.write_tab_icon_show_anim);
                    loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.c.6.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            c.q(c.this);
                            if (c.this.heC == size) {
                                c.this.heD = true;
                                c.this.heC = 0;
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

    public void bFL() {
        bP(this.hez);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bP(View view) {
        if (this.heD && this.heE) {
            if (this.heA != null) {
                com.baidu.adp.lib.g.e.fP().removeCallbacks(this.heA);
            }
            this.hek.clearAnimation();
            this.hek.startAnimation(this.heI);
            this.hey.clearAnimation();
            this.hey.startAnimation(this.heG);
            bFN();
            this.heA = new a(view);
            com.baidu.adp.lib.g.e.fP().postDelayed(this.heA, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFM() {
        this.heD = true;
        this.heE = true;
        if (this.heA != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.heA);
        }
        if (this.heA == null) {
            this.heA = new a(this.hez);
        }
        com.baidu.adp.lib.g.e.fP().postDelayed(this.heA, 500L);
    }

    private void bFN() {
        clearAnimation();
        int size = this.eQY.size();
        this.heC = size;
        this.heE = false;
        int i = size - 1;
        for (int i2 = 0; i2 < size; i2++) {
            final View view = this.eQY.get(i);
            i--;
            com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.c.7
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(c.this.aca.getPageActivity(), d.a.write_tab_icon_hide_anim);
                    loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.c.7.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            view.setVisibility(4);
                            if (c.this.heC == 1) {
                                c.this.heE = true;
                            } else {
                                c.s(c.this);
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
        this.hep.clearAnimation();
        this.hem.clearAnimation();
        this.hev.clearAnimation();
        this.hes.clearAnimation();
    }

    public void onChangeSkinType() {
        aj.k(this.hek, d.C0095d.cp_bg_line_d_alpha98);
        aj.c(this.hen, d.f.icon_post_type_photograph_n);
        aj.c(this.heq, d.f.icon_post_type_text_n);
        aj.c(this.het, d.f.icon_post_type_image_n);
        aj.c(this.hew, d.f.icon_post_type_live_n);
        aj.c(this.hey, d.f.icon_tabbar_add_s);
        aj.i(this.heo, d.C0095d.cp_cont_b);
        aj.i(this.her, d.C0095d.cp_cont_b);
        aj.i(this.heu, d.C0095d.cp_cont_b);
        aj.i(this.hex, d.C0095d.cp_cont_b);
    }

    public void onDestroy() {
        if (this.hel != null && this.hel.getParent() == this.mRootView) {
            this.mRootView.removeView(this.hel);
        }
        if (this.heA != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.heA);
            this.heA = null;
        }
        this.eQY.clear();
    }

    public boolean isShowing() {
        return this.heB;
    }
}
