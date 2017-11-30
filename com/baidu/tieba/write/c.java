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
    private TbPageContext acd;
    private ForumWriteData gVN;
    private LinearLayout hbA;
    private TbImageView hbB;
    private TextView hbC;
    private ImageView hbD;
    private GridLayout hbE;
    private a hbF;
    private Animation hbK;
    private Animation hbL;
    private Animation hbM;
    private Animation hbN;
    private View hbp;
    private View hbq;
    private LinearLayout hbr;
    private TbImageView hbs;
    private TextView hbt;
    private LinearLayout hbu;
    private TbImageView hbv;
    private TextView hbw;
    private LinearLayout hbx;
    private TbImageView hby;
    private TextView hbz;
    private String mFrom;
    private ViewGroup mRootView;
    private String writeCallFrom;
    private boolean hbG = false;
    private int hbH = 0;
    private boolean hbI = true;
    private boolean hbJ = true;
    private ArrayList<View> ePQ = new ArrayList<>();
    private String hbO = "0";

    static /* synthetic */ int q(c cVar) {
        int i = cVar.hbH;
        cVar.hbH = i + 1;
        return i;
    }

    static /* synthetic */ int s(c cVar) {
        int i = cVar.hbH;
        cVar.hbH = i - 1;
        return i;
    }

    public c(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this.mFrom = AlbumActivityConfig.FROM_WRITE;
        this.acd = tbPageContext;
        this.mRootView = viewGroup;
        this.mFrom = str;
        initView();
    }

    public void a(ForumWriteData forumWriteData) {
        this.gVN = forumWriteData;
    }

    public void ux(String str) {
        if ("3".equals(str)) {
            this.writeCallFrom = "1";
        } else {
            this.writeCallFrom = str;
        }
        this.hbO = str;
    }

    private void initView() {
        if (this.acd != null && this.acd.getPageActivity() != null && this.mRootView != null) {
            this.hbq = LayoutInflater.from(this.acd.getPageActivity()).inflate(d.h.bottom_write_thread, (ViewGroup) null);
            this.hbu = (LinearLayout) this.hbq.findViewById(d.g.home_write_article);
            this.hbv = (TbImageView) this.hbq.findViewById(d.g.home_write_article_icon);
            this.hbw = (TextView) this.hbq.findViewById(d.g.home_write_article_title);
            this.hbr = (LinearLayout) this.hbq.findViewById(d.g.home_write_photo);
            this.hbs = (TbImageView) this.hbq.findViewById(d.g.home_write_photo_icon);
            this.hbt = (TextView) this.hbq.findViewById(d.g.home_write_photo_title);
            this.hbx = (LinearLayout) this.hbq.findViewById(d.g.home_write_album);
            this.hby = (TbImageView) this.hbq.findViewById(d.g.home_write_album_icon);
            this.hbz = (TextView) this.hbq.findViewById(d.g.home_write_album_title);
            this.hbA = (LinearLayout) this.hbq.findViewById(d.g.home_write_live);
            this.hbB = (TbImageView) this.hbq.findViewById(d.g.home_write_live_icon);
            this.hbC = (TextView) this.hbq.findViewById(d.g.home_write_live_title);
            this.hbD = (ImageView) this.hbq.findViewById(d.g.write_close_view);
            this.hbp = this.hbq.findViewById(d.g.view_background);
            this.hbE = (GridLayout) this.hbq.findViewById(d.g.type_container);
            this.hbE.setMeasureAllChild(true);
            this.hbE.setVerNum(1);
            bEX();
            this.ePQ.add(this.hbu);
            this.ePQ.add(this.hbr);
            this.ePQ.add(this.hbx);
            this.ePQ.add(this.hbA);
            this.hbq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.bL(c.this.hbE);
                }
            });
            this.hbv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    int i;
                    c.this.bFa();
                    String str2 = "0";
                    String str3 = null;
                    PostPrefixData postPrefixData = null;
                    AntiData antiData = null;
                    if (c.this.gVN != null) {
                        str2 = c.this.gVN.forumId;
                        str3 = c.this.gVN.forumName;
                        postPrefixData = c.this.gVN.prefixData;
                        antiData = c.this.gVN.antiData;
                        int i2 = c.this.gVN.forumLevel;
                        str = c.this.gVN.avatar;
                        i = i2;
                    } else {
                        str = null;
                        i = -1;
                    }
                    TiebaStatic.log(new ak("c12611").ac("obj_locate", c.this.hbO).r("obj_type", 1));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.acd.getPageActivity(), 9, str2, str3, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", c.this.mFrom);
                    writeActivityConfig.setCallFrom(c.this.writeCallFrom);
                    writeActivityConfig.setForumLevel(i);
                    writeActivityConfig.setForumAvatar(str);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            });
            this.hbs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.bFa();
                    TiebaStatic.log(new ak("c12611").ac("obj_locate", c.this.hbO).r("obj_type", 2));
                    if (c.this.gVN == null) {
                        c.this.gVN = new ForumWriteData("0", null, null, null);
                    }
                    c.this.gVN.mFrom = c.this.mFrom;
                    c.this.gVN.writeCallFrom = c.this.writeCallFrom;
                    f.a(c.this.acd, "", c.this.gVN);
                }
            });
            this.hby.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    int i;
                    c.this.bFa();
                    String str2 = "0";
                    String str3 = null;
                    PostPrefixData postPrefixData = null;
                    AntiData antiData = null;
                    if (c.this.gVN != null) {
                        str2 = c.this.gVN.forumId;
                        str3 = c.this.gVN.forumName;
                        postPrefixData = c.this.gVN.prefixData;
                        antiData = c.this.gVN.antiData;
                        int i2 = c.this.gVN.forumLevel;
                        str = c.this.gVN.avatar;
                        i = i2;
                    } else {
                        str = null;
                        i = -1;
                    }
                    TiebaStatic.log(new ak("c12611").ac("obj_locate", c.this.hbO).r("obj_type", 3));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.acd.getPageActivity(), 0, str2, str3, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", c.this.mFrom);
                    writeActivityConfig.setCallFrom(c.this.writeCallFrom);
                    writeActivityConfig.setForumLevel(i);
                    writeActivityConfig.setForumAvatar(str);
                    writeActivityConfig.setAlbumThread(1);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            });
            this.hbB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.bFa();
                    MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                    String str = "0";
                    String str2 = null;
                    TiebaStatic.log(new ak("c12611").ac("obj_locate", c.this.hbO).r("obj_type", 4));
                    com.baidu.adp.lib.d.a.fc().D(false);
                    if (c.this.gVN != null) {
                        str = c.this.gVN.forumId;
                        str2 = c.this.gVN.forumName;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaMasterLiveRoomActivityConfig(TbadkCoreApplication.getInst().getApplicationContext(), str2, str, TbadkCoreApplication.getCurrentAccount(), false)));
                }
            });
            onChangeSkinType();
            this.hbK = AnimationUtils.loadAnimation(this.acd.getPageActivity(), d.a.write_thread_black_anim);
            this.hbK.setFillAfter(true);
            this.hbL = AnimationUtils.loadAnimation(this.acd.getPageActivity(), d.a.write_thread_black_hide_anim);
            this.hbL.setFillAfter(true);
            this.hbM = AnimationUtils.loadAnimation(this.acd.getPageActivity(), d.a.write_tab_bg_anim);
            this.hbM.setFillAfter(true);
            this.hbN = AnimationUtils.loadAnimation(this.acd.getPageActivity(), d.a.home_write_bgout);
            this.hbN.setFillAfter(true);
        }
    }

    private void bEX() {
        int ac = (int) (0.15555556f * l.ac(this.acd.getPageActivity()));
        a(this.hbv, ac);
        a(this.hbs, ac);
        a(this.hby, ac);
        a(this.hbB, ac);
        int ae = l.ae(this.acd.getPageActivity());
        ViewGroup.LayoutParams layoutParams = this.hbE.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = ae / 5;
            this.hbE.setLayoutParams(layoutParams);
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
            c.this.hbu.setVisibility(4);
            c.this.hbr.setVisibility(4);
            c.this.hbx.setVisibility(4);
            c.this.hbA.setVisibility(4);
            c.this.hbD.setVisibility(4);
            c.this.hbp.setVisibility(4);
            if (this.mView != null) {
                this.mView.setVisibility(8);
            }
            if (c.this.hbq.getParent() == c.this.mRootView) {
                c.this.mRootView.removeView(c.this.hbq);
            }
            c.this.hbG = false;
        }
    }

    public void nU(boolean z) {
        if (!this.hbG && this.hbI && this.hbJ && this.mRootView != null) {
            this.hbD.clearAnimation();
            this.hbG = true;
            if (this.hbq.getParent() == null) {
                com.baidu.tbadk.j.d.Q(this.mRootView).a(this.mRootView, this.hbq, z);
            }
            this.hbE.setVisibility(0);
            this.hbp.setVisibility(0);
            this.hbp.clearAnimation();
            this.hbp.startAnimation(this.hbM);
            this.hbD.setVisibility(0);
            this.hbD.startAnimation(this.hbK);
            bEY();
            TiebaStatic.log(new ak("c12052").ac("obj_locate", this.writeCallFrom));
        }
    }

    private void bEY() {
        clearAnimation();
        final int size = this.ePQ.size();
        this.hbI = false;
        this.hbH = 0;
        for (int i = 0; i < size; i++) {
            final View view = this.ePQ.get(i);
            com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.c.6
                @Override // java.lang.Runnable
                public void run() {
                    view.setVisibility(0);
                    Animation loadAnimation = AnimationUtils.loadAnimation(c.this.acd.getPageActivity(), d.a.write_tab_icon_show_anim);
                    loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.c.6.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            c.q(c.this);
                            if (c.this.hbH == size) {
                                c.this.hbI = true;
                                c.this.hbH = 0;
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

    public void bEZ() {
        bL(this.hbE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bL(View view) {
        if (this.hbI && this.hbJ) {
            if (this.hbF != null) {
                com.baidu.adp.lib.g.e.fP().removeCallbacks(this.hbF);
            }
            this.hbp.clearAnimation();
            this.hbp.startAnimation(this.hbN);
            this.hbD.clearAnimation();
            this.hbD.startAnimation(this.hbL);
            bFb();
            this.hbF = new a(view);
            com.baidu.adp.lib.g.e.fP().postDelayed(this.hbF, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFa() {
        this.hbI = true;
        this.hbJ = true;
        if (this.hbF != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.hbF);
        }
        if (this.hbF == null) {
            this.hbF = new a(this.hbE);
        }
        com.baidu.adp.lib.g.e.fP().postDelayed(this.hbF, 500L);
    }

    private void bFb() {
        clearAnimation();
        int size = this.ePQ.size();
        this.hbH = size;
        this.hbJ = false;
        int i = size - 1;
        for (int i2 = 0; i2 < size; i2++) {
            final View view = this.ePQ.get(i);
            i--;
            com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.c.7
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(c.this.acd.getPageActivity(), d.a.write_tab_icon_hide_anim);
                    loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.c.7.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            view.setVisibility(4);
                            if (c.this.hbH == 1) {
                                c.this.hbJ = true;
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
        this.hbu.clearAnimation();
        this.hbr.clearAnimation();
        this.hbA.clearAnimation();
        this.hbx.clearAnimation();
    }

    public void onChangeSkinType() {
        aj.k(this.hbp, d.C0082d.cp_bg_line_d_alpha98);
        aj.c(this.hbs, d.f.icon_post_type_photograph_n);
        aj.c(this.hbv, d.f.icon_post_type_text_n);
        aj.c(this.hby, d.f.icon_post_type_image_n);
        aj.c(this.hbB, d.f.icon_post_type_live_n);
        aj.c(this.hbD, d.f.icon_tabbar_add_s);
        aj.i(this.hbt, d.C0082d.cp_cont_b);
        aj.i(this.hbw, d.C0082d.cp_cont_b);
        aj.i(this.hbz, d.C0082d.cp_cont_b);
        aj.i(this.hbC, d.C0082d.cp_cont_b);
    }

    public void onDestroy() {
        if (this.hbq != null && this.hbq.getParent() == this.mRootView) {
            this.mRootView.removeView(this.hbq);
        }
        if (this.hbF != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.hbF);
            this.hbF = null;
        }
        this.ePQ.clear();
    }

    public boolean isShowing() {
        return this.hbG;
    }
}
