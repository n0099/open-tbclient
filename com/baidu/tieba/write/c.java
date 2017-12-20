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
    private TbPageContext abX;
    private ForumWriteData gYz;
    private Animation heA;
    private Animation heB;
    private Animation heC;
    private Animation heD;
    private View hef;
    private View heg;
    private LinearLayout heh;
    private TbImageView hei;
    private TextView hej;
    private LinearLayout hek;
    private TbImageView hel;
    private TextView hem;
    private LinearLayout hen;
    private TbImageView heo;
    private TextView hep;
    private LinearLayout heq;
    private TbImageView her;
    private TextView hes;
    private ImageView het;
    private GridLayout heu;
    private a hev;
    private String mFrom;
    private ViewGroup mRootView;
    private String writeCallFrom;
    private boolean hew = false;
    private int hex = 0;
    private boolean hey = true;
    private boolean hez = true;
    private ArrayList<View> eQT = new ArrayList<>();
    private String heE = "0";

    static /* synthetic */ int q(c cVar) {
        int i = cVar.hex;
        cVar.hex = i + 1;
        return i;
    }

    static /* synthetic */ int s(c cVar) {
        int i = cVar.hex;
        cVar.hex = i - 1;
        return i;
    }

    public c(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this.mFrom = AlbumActivityConfig.FROM_WRITE;
        this.abX = tbPageContext;
        this.mRootView = viewGroup;
        this.mFrom = str;
        initView();
    }

    public void a(ForumWriteData forumWriteData) {
        this.gYz = forumWriteData;
    }

    public void uC(String str) {
        if ("3".equals(str)) {
            this.writeCallFrom = "1";
        } else {
            this.writeCallFrom = str;
        }
        this.heE = str;
    }

    private void initView() {
        if (this.abX != null && this.abX.getPageActivity() != null && this.mRootView != null) {
            this.heg = LayoutInflater.from(this.abX.getPageActivity()).inflate(d.h.bottom_write_thread, (ViewGroup) null);
            this.hek = (LinearLayout) this.heg.findViewById(d.g.home_write_article);
            this.hel = (TbImageView) this.heg.findViewById(d.g.home_write_article_icon);
            this.hem = (TextView) this.heg.findViewById(d.g.home_write_article_title);
            this.heh = (LinearLayout) this.heg.findViewById(d.g.home_write_photo);
            this.hei = (TbImageView) this.heg.findViewById(d.g.home_write_photo_icon);
            this.hej = (TextView) this.heg.findViewById(d.g.home_write_photo_title);
            this.hen = (LinearLayout) this.heg.findViewById(d.g.home_write_album);
            this.heo = (TbImageView) this.heg.findViewById(d.g.home_write_album_icon);
            this.hep = (TextView) this.heg.findViewById(d.g.home_write_album_title);
            this.heq = (LinearLayout) this.heg.findViewById(d.g.home_write_live);
            this.her = (TbImageView) this.heg.findViewById(d.g.home_write_live_icon);
            this.hes = (TextView) this.heg.findViewById(d.g.home_write_live_title);
            this.het = (ImageView) this.heg.findViewById(d.g.write_close_view);
            this.hef = this.heg.findViewById(d.g.view_background);
            this.heu = (GridLayout) this.heg.findViewById(d.g.type_container);
            this.heu.setMeasureAllChild(true);
            this.heu.setVerNum(1);
            bFI();
            this.eQT.add(this.hek);
            this.eQT.add(this.heh);
            this.eQT.add(this.hen);
            this.eQT.add(this.heq);
            this.heg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.bP(c.this.heu);
                }
            });
            this.hel.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i;
                    String str;
                    int i2;
                    c.this.bFL();
                    String str2 = "0";
                    String str3 = null;
                    PostPrefixData postPrefixData = null;
                    AntiData antiData = null;
                    if (c.this.gYz != null) {
                        str2 = c.this.gYz.forumId;
                        str3 = c.this.gYz.forumName;
                        postPrefixData = c.this.gYz.prefixData;
                        antiData = c.this.gYz.antiData;
                        int i3 = c.this.gYz.forumLevel;
                        String str4 = c.this.gYz.avatar;
                        i = c.this.gYz.privateThread;
                        str = str4;
                        i2 = i3;
                    } else {
                        i = 0;
                        str = null;
                        i2 = -1;
                    }
                    TiebaStatic.log(new ak("c12611").ac("obj_locate", c.this.heE).r("obj_type", 1));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.abX.getPageActivity(), 9, str2, str3, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", c.this.mFrom);
                    writeActivityConfig.setCallFrom(c.this.writeCallFrom);
                    writeActivityConfig.setForumLevel(i2);
                    writeActivityConfig.setForumAvatar(str);
                    writeActivityConfig.setPrivateThread(i);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            });
            this.hei.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.bFL();
                    TiebaStatic.log(new ak("c12611").ac("obj_locate", c.this.heE).r("obj_type", 2));
                    if (c.this.gYz == null) {
                        c.this.gYz = new ForumWriteData("0", null, null, null);
                    }
                    c.this.gYz.mFrom = c.this.mFrom;
                    c.this.gYz.writeCallFrom = c.this.writeCallFrom;
                    f.a(c.this.abX, "", c.this.gYz);
                }
            });
            this.heo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i;
                    String str;
                    int i2;
                    c.this.bFL();
                    String str2 = "0";
                    String str3 = null;
                    PostPrefixData postPrefixData = null;
                    AntiData antiData = null;
                    if (c.this.gYz != null) {
                        str2 = c.this.gYz.forumId;
                        str3 = c.this.gYz.forumName;
                        postPrefixData = c.this.gYz.prefixData;
                        antiData = c.this.gYz.antiData;
                        int i3 = c.this.gYz.forumLevel;
                        String str4 = c.this.gYz.avatar;
                        i = c.this.gYz.privateThread;
                        str = str4;
                        i2 = i3;
                    } else {
                        i = 0;
                        str = null;
                        i2 = -1;
                    }
                    TiebaStatic.log(new ak("c12611").ac("obj_locate", c.this.heE).r("obj_type", 3));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.abX.getPageActivity(), 0, str2, str3, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", c.this.mFrom);
                    writeActivityConfig.setCallFrom(c.this.writeCallFrom);
                    writeActivityConfig.setForumLevel(i2);
                    writeActivityConfig.setForumAvatar(str);
                    writeActivityConfig.setAlbumThread(1);
                    writeActivityConfig.setPrivateThread(i);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            });
            this.her.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.bFL();
                    MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                    String str = "0";
                    String str2 = null;
                    TiebaStatic.log(new ak("c12611").ac("obj_locate", c.this.heE).r("obj_type", 4));
                    com.baidu.adp.lib.d.a.fc().D(false);
                    if (c.this.gYz != null) {
                        str = c.this.gYz.forumId;
                        str2 = c.this.gYz.forumName;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaMasterLiveRoomActivityConfig(TbadkCoreApplication.getInst().getApplicationContext(), str2, str, TbadkCoreApplication.getCurrentAccount(), false)));
                }
            });
            onChangeSkinType();
            this.heA = AnimationUtils.loadAnimation(this.abX.getPageActivity(), d.a.write_thread_black_anim);
            this.heA.setFillAfter(true);
            this.heB = AnimationUtils.loadAnimation(this.abX.getPageActivity(), d.a.write_thread_black_hide_anim);
            this.heB.setFillAfter(true);
            this.heC = AnimationUtils.loadAnimation(this.abX.getPageActivity(), d.a.write_tab_bg_anim);
            this.heC.setFillAfter(true);
            this.heD = AnimationUtils.loadAnimation(this.abX.getPageActivity(), d.a.home_write_bgout);
            this.heD.setFillAfter(true);
        }
    }

    private void bFI() {
        int ac = (int) (0.15555556f * l.ac(this.abX.getPageActivity()));
        a(this.hel, ac);
        a(this.hei, ac);
        a(this.heo, ac);
        a(this.her, ac);
        int ae = l.ae(this.abX.getPageActivity());
        ViewGroup.LayoutParams layoutParams = this.heu.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = ae / 5;
            this.heu.setLayoutParams(layoutParams);
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
            c.this.hek.setVisibility(4);
            c.this.heh.setVisibility(4);
            c.this.hen.setVisibility(4);
            c.this.heq.setVisibility(4);
            c.this.het.setVisibility(4);
            c.this.hef.setVisibility(4);
            if (this.mView != null) {
                this.mView.setVisibility(8);
            }
            if (c.this.heg.getParent() == c.this.mRootView) {
                c.this.mRootView.removeView(c.this.heg);
            }
            c.this.hew = false;
        }
    }

    public void nV(boolean z) {
        if (!this.hew && this.hey && this.hez && this.mRootView != null) {
            this.het.clearAnimation();
            this.hew = true;
            if (this.heg.getParent() == null) {
                com.baidu.tbadk.j.d.R(this.mRootView).a(this.mRootView, this.heg, z);
            }
            this.heu.setVisibility(0);
            this.hef.setVisibility(0);
            this.hef.clearAnimation();
            this.hef.startAnimation(this.heC);
            this.het.setVisibility(0);
            this.het.startAnimation(this.heA);
            bFJ();
            TiebaStatic.log(new ak("c12052").ac("obj_locate", this.heE));
        }
    }

    private void bFJ() {
        clearAnimation();
        final int size = this.eQT.size();
        this.hey = false;
        this.hex = 0;
        for (int i = 0; i < size; i++) {
            final View view = this.eQT.get(i);
            com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.c.6
                @Override // java.lang.Runnable
                public void run() {
                    view.setVisibility(0);
                    Animation loadAnimation = AnimationUtils.loadAnimation(c.this.abX.getPageActivity(), d.a.write_tab_icon_show_anim);
                    loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.c.6.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            c.q(c.this);
                            if (c.this.hex == size) {
                                c.this.hey = true;
                                c.this.hex = 0;
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

    public void bFK() {
        bP(this.heu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bP(View view) {
        if (this.hey && this.hez) {
            if (this.hev != null) {
                com.baidu.adp.lib.g.e.fP().removeCallbacks(this.hev);
            }
            this.hef.clearAnimation();
            this.hef.startAnimation(this.heD);
            this.het.clearAnimation();
            this.het.startAnimation(this.heB);
            bFM();
            this.hev = new a(view);
            com.baidu.adp.lib.g.e.fP().postDelayed(this.hev, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFL() {
        this.hey = true;
        this.hez = true;
        if (this.hev != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.hev);
        }
        if (this.hev == null) {
            this.hev = new a(this.heu);
        }
        com.baidu.adp.lib.g.e.fP().postDelayed(this.hev, 500L);
    }

    private void bFM() {
        clearAnimation();
        int size = this.eQT.size();
        this.hex = size;
        this.hez = false;
        int i = size - 1;
        for (int i2 = 0; i2 < size; i2++) {
            final View view = this.eQT.get(i);
            i--;
            com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.c.7
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(c.this.abX.getPageActivity(), d.a.write_tab_icon_hide_anim);
                    loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.c.7.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            view.setVisibility(4);
                            if (c.this.hex == 1) {
                                c.this.hez = true;
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
        this.hek.clearAnimation();
        this.heh.clearAnimation();
        this.heq.clearAnimation();
        this.hen.clearAnimation();
    }

    public void onChangeSkinType() {
        aj.k(this.hef, d.C0096d.cp_bg_line_d_alpha98);
        aj.c(this.hei, d.f.icon_post_type_photograph_n);
        aj.c(this.hel, d.f.icon_post_type_text_n);
        aj.c(this.heo, d.f.icon_post_type_image_n);
        aj.c(this.her, d.f.icon_post_type_live_n);
        aj.c(this.het, d.f.icon_tabbar_add_s);
        aj.i(this.hej, d.C0096d.cp_cont_b);
        aj.i(this.hem, d.C0096d.cp_cont_b);
        aj.i(this.hep, d.C0096d.cp_cont_b);
        aj.i(this.hes, d.C0096d.cp_cont_b);
    }

    public void onDestroy() {
        if (this.heg != null && this.heg.getParent() == this.mRootView) {
            this.mRootView.removeView(this.heg);
        }
        if (this.hev != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.hev);
            this.hev = null;
        }
        this.eQT.clear();
    }

    public boolean isShowing() {
        return this.hew;
    }
}
