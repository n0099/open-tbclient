package com.baidu.tieba.write;

import android.app.Activity;
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
    private TbPageContext aQs;
    private Animation hCC;
    private Animation hCD;
    private Animation hCE;
    private Animation hCF;
    private View hCh;
    private View hCi;
    private LinearLayout hCj;
    private TbImageView hCk;
    private TextView hCl;
    private LinearLayout hCm;
    private TbImageView hCn;
    private TextView hCo;
    private LinearLayout hCp;
    private TbImageView hCq;
    private TextView hCr;
    private LinearLayout hCs;
    private TbImageView hCt;
    private TextView hCu;
    private ImageView hCv;
    private GridLayout hCw;
    private a hCx;
    private ForumWriteData hvE;
    private String mFrom;
    private ViewGroup mRootView;
    private String writeCallFrom;
    private boolean hCy = false;
    private int hCz = 0;
    private boolean hCA = true;
    private boolean hCB = true;
    private ArrayList<View> fFu = new ArrayList<>();
    private String hCG = "0";

    static /* synthetic */ int q(c cVar) {
        int i = cVar.hCz;
        cVar.hCz = i + 1;
        return i;
    }

    static /* synthetic */ int s(c cVar) {
        int i = cVar.hCz;
        cVar.hCz = i - 1;
        return i;
    }

    public c(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this.mFrom = AlbumActivityConfig.FROM_WRITE;
        this.aQs = tbPageContext;
        this.mRootView = viewGroup;
        this.mFrom = str;
        initView();
    }

    public void a(ForumWriteData forumWriteData) {
        this.hvE = forumWriteData;
    }

    public void uh(String str) {
        if ("3".equals(str)) {
            this.writeCallFrom = "1";
        } else {
            this.writeCallFrom = str;
        }
        this.hCG = str;
    }

    private void initView() {
        if (this.aQs != null && this.aQs.getPageActivity() != null && this.mRootView != null) {
            this.hCi = LayoutInflater.from(this.aQs.getPageActivity()).inflate(d.h.bottom_write_thread, (ViewGroup) null);
            this.hCm = (LinearLayout) this.hCi.findViewById(d.g.home_write_article);
            this.hCn = (TbImageView) this.hCi.findViewById(d.g.home_write_article_icon);
            this.hCo = (TextView) this.hCi.findViewById(d.g.home_write_article_title);
            this.hCj = (LinearLayout) this.hCi.findViewById(d.g.home_write_photo);
            this.hCk = (TbImageView) this.hCi.findViewById(d.g.home_write_photo_icon);
            this.hCl = (TextView) this.hCi.findViewById(d.g.home_write_photo_title);
            this.hCp = (LinearLayout) this.hCi.findViewById(d.g.home_write_album);
            this.hCq = (TbImageView) this.hCi.findViewById(d.g.home_write_album_icon);
            this.hCr = (TextView) this.hCi.findViewById(d.g.home_write_album_title);
            this.hCs = (LinearLayout) this.hCi.findViewById(d.g.home_write_live);
            this.hCt = (TbImageView) this.hCi.findViewById(d.g.home_write_live_icon);
            this.hCu = (TextView) this.hCi.findViewById(d.g.home_write_live_title);
            this.hCv = (ImageView) this.hCi.findViewById(d.g.write_close_view);
            this.hCh = this.hCi.findViewById(d.g.view_background);
            this.hCw = (GridLayout) this.hCi.findViewById(d.g.type_container);
            this.hCw.setMeasureAllChild(true);
            this.hCw.setVerNum(1);
            bET();
            this.fFu.add(this.hCm);
            this.fFu.add(this.hCj);
            this.fFu.add(this.hCp);
            this.fFu.add(this.hCs);
            this.hCi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.cW(c.this.hCw);
                }
            });
            this.hCn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i;
                    String str;
                    int i2;
                    c.this.bEW();
                    String str2 = "0";
                    String str3 = null;
                    PostPrefixData postPrefixData = null;
                    AntiData antiData = null;
                    if (c.this.hvE != null) {
                        str2 = c.this.hvE.forumId;
                        str3 = c.this.hvE.forumName;
                        postPrefixData = c.this.hvE.prefixData;
                        antiData = c.this.hvE.antiData;
                        int i3 = c.this.hvE.forumLevel;
                        String str4 = c.this.hvE.avatar;
                        i = c.this.hvE.privateThread;
                        str = str4;
                        i2 = i3;
                    } else {
                        i = 0;
                        str = null;
                        i2 = -1;
                    }
                    TiebaStatic.log(new ak("c12611").aa("obj_locate", c.this.hCG).s("obj_type", 1));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.aQs.getPageActivity(), 9, str2, str3, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", c.this.mFrom);
                    writeActivityConfig.setCallFrom(c.this.writeCallFrom);
                    writeActivityConfig.setForumLevel(i2);
                    writeActivityConfig.setForumAvatar(str);
                    writeActivityConfig.setPrivateThread(i);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            });
            this.hCk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.bEW();
                    TiebaStatic.log(new ak("c12611").aa("obj_locate", c.this.hCG).s("obj_type", 2));
                    if (c.this.hvE == null) {
                        c.this.hvE = new ForumWriteData("0", null, null, null);
                    }
                    c.this.hvE.mFrom = c.this.mFrom;
                    c.this.hvE.writeCallFrom = c.this.writeCallFrom;
                    f.a(c.this.aQs, "", c.this.hvE);
                }
            });
            this.hCq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i;
                    String str;
                    int i2;
                    c.this.bEW();
                    String str2 = "0";
                    String str3 = null;
                    PostPrefixData postPrefixData = null;
                    AntiData antiData = null;
                    if (c.this.hvE != null) {
                        str2 = c.this.hvE.forumId;
                        str3 = c.this.hvE.forumName;
                        postPrefixData = c.this.hvE.prefixData;
                        antiData = c.this.hvE.antiData;
                        int i3 = c.this.hvE.forumLevel;
                        String str4 = c.this.hvE.avatar;
                        i = c.this.hvE.privateThread;
                        str = str4;
                        i2 = i3;
                    } else {
                        i = 0;
                        str = null;
                        i2 = -1;
                    }
                    TiebaStatic.log(new ak("c12611").aa("obj_locate", c.this.hCG).s("obj_type", 3));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.aQs.getPageActivity(), 0, str2, str3, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", c.this.mFrom);
                    writeActivityConfig.setCallFrom(c.this.writeCallFrom);
                    writeActivityConfig.setForumLevel(i2);
                    writeActivityConfig.setForumAvatar(str);
                    writeActivityConfig.setAlbumThread(1);
                    writeActivityConfig.setPrivateThread(i);
                    if (!c.E(c.this.aQs.getPageActivity())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                    }
                }
            });
            this.hCt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.bEW();
                    MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                    String str = "0";
                    String str2 = null;
                    TiebaStatic.log(new ak("c12611").aa("obj_locate", c.this.hCG).s("obj_type", 4));
                    com.baidu.adp.lib.d.a.mG().ak(false);
                    if (c.this.hvE != null) {
                        str = c.this.hvE.forumId;
                        str2 = c.this.hvE.forumName;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaMasterLiveRoomActivityConfig(TbadkCoreApplication.getInst().getApplicationContext(), str2, str, TbadkCoreApplication.getCurrentAccount(), false)));
                }
            });
            onChangeSkinType();
            this.hCC = AnimationUtils.loadAnimation(this.aQs.getPageActivity(), d.a.write_thread_black_anim);
            this.hCC.setFillAfter(true);
            this.hCD = AnimationUtils.loadAnimation(this.aQs.getPageActivity(), d.a.write_thread_black_hide_anim);
            this.hCD.setFillAfter(true);
            this.hCE = AnimationUtils.loadAnimation(this.aQs.getPageActivity(), d.a.write_tab_bg_anim);
            this.hCE.setFillAfter(true);
            this.hCF = AnimationUtils.loadAnimation(this.aQs.getPageActivity(), d.a.home_write_bgout);
            this.hCF.setFillAfter(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean E(Activity activity) {
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.Do();
        aVar.c(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return aVar.u(activity);
    }

    private void bET() {
        int ao = (int) (0.15555556f * l.ao(this.aQs.getPageActivity()));
        a(this.hCn, ao);
        a(this.hCk, ao);
        a(this.hCq, ao);
        a(this.hCt, ao);
        int aq = l.aq(this.aQs.getPageActivity());
        ViewGroup.LayoutParams layoutParams = this.hCw.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = aq / 5;
            this.hCw.setLayoutParams(layoutParams);
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
            c.this.hCm.setVisibility(4);
            c.this.hCj.setVisibility(4);
            c.this.hCp.setVisibility(4);
            c.this.hCs.setVisibility(4);
            c.this.hCv.setVisibility(4);
            c.this.hCh.setVisibility(4);
            if (this.mView != null) {
                this.mView.setVisibility(8);
            }
            if (c.this.hCi.getParent() == c.this.mRootView) {
                c.this.mRootView.removeView(c.this.hCi);
            }
            c.this.hCy = false;
        }
    }

    public void nu(boolean z) {
        if (!this.hCy && this.hCA && this.hCB && this.mRootView != null) {
            this.hCv.clearAnimation();
            this.hCy = true;
            if (this.hCi.getParent() == null) {
                com.baidu.tbadk.j.d.bl(this.mRootView).a(this.mRootView, this.hCi, z);
            }
            this.hCw.setVisibility(0);
            this.hCh.setVisibility(0);
            this.hCh.clearAnimation();
            this.hCh.startAnimation(this.hCE);
            this.hCv.setVisibility(0);
            this.hCv.startAnimation(this.hCC);
            bEU();
            TiebaStatic.log(new ak("c12052").aa("obj_locate", this.hCG));
        }
    }

    private void bEU() {
        clearAnimation();
        final int size = this.fFu.size();
        this.hCA = false;
        this.hCz = 0;
        for (int i = 0; i < size; i++) {
            final View view = this.fFu.get(i);
            com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.c.6
                @Override // java.lang.Runnable
                public void run() {
                    view.setVisibility(0);
                    Animation loadAnimation = AnimationUtils.loadAnimation(c.this.aQs.getPageActivity(), d.a.write_tab_icon_show_anim);
                    loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.c.6.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            c.q(c.this);
                            if (c.this.hCz == size) {
                                c.this.hCA = true;
                                c.this.hCz = 0;
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

    public void bEV() {
        cW(this.hCw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cW(View view) {
        if (this.hCA && this.hCB) {
            if (this.hCx != null) {
                com.baidu.adp.lib.g.e.ns().removeCallbacks(this.hCx);
            }
            this.hCh.clearAnimation();
            this.hCh.startAnimation(this.hCF);
            this.hCv.clearAnimation();
            this.hCv.startAnimation(this.hCD);
            bEX();
            this.hCx = new a(view);
            com.baidu.adp.lib.g.e.ns().postDelayed(this.hCx, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEW() {
        this.hCA = true;
        this.hCB = true;
        if (this.hCx != null) {
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.hCx);
        }
        if (this.hCx == null) {
            this.hCx = new a(this.hCw);
        }
        com.baidu.adp.lib.g.e.ns().postDelayed(this.hCx, 500L);
    }

    private void bEX() {
        clearAnimation();
        int size = this.fFu.size();
        this.hCz = size;
        this.hCB = false;
        int i = size - 1;
        for (int i2 = 0; i2 < size; i2++) {
            final View view = this.fFu.get(i);
            i--;
            com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.c.7
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(c.this.aQs.getPageActivity(), d.a.write_tab_icon_hide_anim);
                    loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.c.7.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            view.setVisibility(4);
                            if (c.this.hCz == 1) {
                                c.this.hCB = true;
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
        this.hCm.clearAnimation();
        this.hCj.clearAnimation();
        this.hCs.clearAnimation();
        this.hCp.clearAnimation();
    }

    public void onChangeSkinType() {
        aj.t(this.hCh, d.C0108d.cp_bg_line_d_alpha98);
        aj.c(this.hCk, d.f.icon_post_type_photograph_n);
        aj.c(this.hCn, d.f.icon_post_type_text_n);
        aj.c(this.hCq, d.f.icon_post_type_image_n);
        aj.c(this.hCt, d.f.icon_post_type_live_n);
        aj.c(this.hCv, d.f.icon_tabbar_add_s);
        aj.r(this.hCl, d.C0108d.cp_cont_b);
        aj.r(this.hCo, d.C0108d.cp_cont_b);
        aj.r(this.hCr, d.C0108d.cp_cont_b);
        aj.r(this.hCu, d.C0108d.cp_cont_b);
    }

    public void onDestroy() {
        if (this.hCi != null && this.hCi.getParent() == this.mRootView) {
            this.mRootView.removeView(this.hCi);
        }
        if (this.hCx != null) {
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.hCx);
            this.hCx = null;
        }
        this.fFu.clear();
    }

    public boolean isShowing() {
        return this.hCy;
    }
}
