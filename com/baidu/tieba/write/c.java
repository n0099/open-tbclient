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
    private TbPageContext aQq;
    private ForumWriteData hFH;
    private Animation hMB;
    private Animation hMC;
    private Animation hMD;
    private Animation hME;
    private View hMg;
    private View hMh;
    private LinearLayout hMi;
    private TbImageView hMj;
    private TextView hMk;
    private LinearLayout hMl;
    private TbImageView hMm;
    private TextView hMn;
    private LinearLayout hMo;
    private TbImageView hMp;
    private TextView hMq;
    private LinearLayout hMr;
    private TbImageView hMs;
    private TextView hMt;
    private ImageView hMu;
    private GridLayout hMv;
    private a hMw;
    private String mFrom;
    private ViewGroup mRootView;
    private String writeCallFrom;
    private boolean hMx = false;
    private int hMy = 0;
    private boolean hMz = true;
    private boolean hMA = true;
    private ArrayList<View> fDz = new ArrayList<>();
    private String hMF = "0";

    static /* synthetic */ int q(c cVar) {
        int i = cVar.hMy;
        cVar.hMy = i + 1;
        return i;
    }

    static /* synthetic */ int s(c cVar) {
        int i = cVar.hMy;
        cVar.hMy = i - 1;
        return i;
    }

    public c(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this.mFrom = AlbumActivityConfig.FROM_WRITE;
        this.aQq = tbPageContext;
        this.mRootView = viewGroup;
        this.mFrom = str;
        initView();
    }

    public void a(ForumWriteData forumWriteData) {
        this.hFH = forumWriteData;
    }

    public void uF(String str) {
        if ("3".equals(str)) {
            this.writeCallFrom = "1";
        } else {
            this.writeCallFrom = str;
        }
        this.hMF = str;
    }

    private void initView() {
        if (this.aQq != null && this.aQq.getPageActivity() != null && this.mRootView != null) {
            this.hMh = LayoutInflater.from(this.aQq.getPageActivity()).inflate(d.h.bottom_write_thread, (ViewGroup) null);
            this.hMl = (LinearLayout) this.hMh.findViewById(d.g.home_write_article);
            this.hMm = (TbImageView) this.hMh.findViewById(d.g.home_write_article_icon);
            this.hMn = (TextView) this.hMh.findViewById(d.g.home_write_article_title);
            this.hMi = (LinearLayout) this.hMh.findViewById(d.g.home_write_photo);
            this.hMj = (TbImageView) this.hMh.findViewById(d.g.home_write_photo_icon);
            this.hMk = (TextView) this.hMh.findViewById(d.g.home_write_photo_title);
            this.hMo = (LinearLayout) this.hMh.findViewById(d.g.home_write_album);
            this.hMp = (TbImageView) this.hMh.findViewById(d.g.home_write_album_icon);
            this.hMq = (TextView) this.hMh.findViewById(d.g.home_write_album_title);
            this.hMr = (LinearLayout) this.hMh.findViewById(d.g.home_write_live);
            this.hMs = (TbImageView) this.hMh.findViewById(d.g.home_write_live_icon);
            this.hMt = (TextView) this.hMh.findViewById(d.g.home_write_live_title);
            this.hMu = (ImageView) this.hMh.findViewById(d.g.write_close_view);
            this.hMg = this.hMh.findViewById(d.g.view_background);
            this.hMv = (GridLayout) this.hMh.findViewById(d.g.type_container);
            this.hMv.setMeasureAllChild(true);
            this.hMv.setVerNum(1);
            bLr();
            this.fDz.add(this.hMl);
            this.fDz.add(this.hMi);
            this.fDz.add(this.hMo);
            this.fDz.add(this.hMr);
            this.hMh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.da(c.this.hMv);
                }
            });
            this.hMm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i;
                    String str;
                    int i2;
                    c.this.bLu();
                    String str2 = "0";
                    String str3 = null;
                    PostPrefixData postPrefixData = null;
                    AntiData antiData = null;
                    if (c.this.hFH != null) {
                        str2 = c.this.hFH.forumId;
                        str3 = c.this.hFH.forumName;
                        postPrefixData = c.this.hFH.prefixData;
                        antiData = c.this.hFH.antiData;
                        int i3 = c.this.hFH.forumLevel;
                        String str4 = c.this.hFH.avatar;
                        i = c.this.hFH.privateThread;
                        str = str4;
                        i2 = i3;
                    } else {
                        i = 0;
                        str = null;
                        i2 = -1;
                    }
                    TiebaStatic.log(new ak("c12611").ab("obj_locate", c.this.hMF).s("obj_type", 1));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.aQq.getPageActivity(), 9, str2, str3, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", c.this.mFrom);
                    writeActivityConfig.setCallFrom(c.this.writeCallFrom);
                    writeActivityConfig.setForumLevel(i2);
                    writeActivityConfig.setForumAvatar(str);
                    writeActivityConfig.setPrivateThread(i);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            });
            this.hMj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.bLu();
                    TiebaStatic.log(new ak("c12611").ab("obj_locate", c.this.hMF).s("obj_type", 2));
                    if (c.this.hFH == null) {
                        c.this.hFH = new ForumWriteData("0", null, null, null);
                    }
                    c.this.hFH.mFrom = c.this.mFrom;
                    c.this.hFH.writeCallFrom = c.this.writeCallFrom;
                    f.a(c.this.aQq, "", c.this.hFH);
                }
            });
            this.hMp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i;
                    String str;
                    int i2;
                    c.this.bLu();
                    String str2 = "0";
                    String str3 = null;
                    PostPrefixData postPrefixData = null;
                    AntiData antiData = null;
                    if (c.this.hFH != null) {
                        str2 = c.this.hFH.forumId;
                        str3 = c.this.hFH.forumName;
                        postPrefixData = c.this.hFH.prefixData;
                        antiData = c.this.hFH.antiData;
                        int i3 = c.this.hFH.forumLevel;
                        String str4 = c.this.hFH.avatar;
                        i = c.this.hFH.privateThread;
                        str = str4;
                        i2 = i3;
                    } else {
                        i = 0;
                        str = null;
                        i2 = -1;
                    }
                    TiebaStatic.log(new ak("c12611").ab("obj_locate", c.this.hMF).s("obj_type", 3));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.aQq.getPageActivity(), 0, str2, str3, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", c.this.mFrom);
                    writeActivityConfig.setCallFrom(c.this.writeCallFrom);
                    writeActivityConfig.setForumLevel(i2);
                    writeActivityConfig.setForumAvatar(str);
                    writeActivityConfig.setAlbumThread(1);
                    writeActivityConfig.setPrivateThread(i);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            });
            this.hMs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.bLu();
                    MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                    String str = "0";
                    String str2 = null;
                    TiebaStatic.log(new ak("c12611").ab("obj_locate", c.this.hMF).s("obj_type", 4));
                    com.baidu.adp.lib.d.a.mF().aj(false);
                    if (c.this.hFH != null) {
                        str = c.this.hFH.forumId;
                        str2 = c.this.hFH.forumName;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaMasterLiveRoomActivityConfig(TbadkCoreApplication.getInst().getApplicationContext(), str2, str, TbadkCoreApplication.getCurrentAccount(), false)));
                }
            });
            onChangeSkinType();
            this.hMB = AnimationUtils.loadAnimation(this.aQq.getPageActivity(), d.a.write_thread_black_anim);
            this.hMB.setFillAfter(true);
            this.hMC = AnimationUtils.loadAnimation(this.aQq.getPageActivity(), d.a.write_thread_black_hide_anim);
            this.hMC.setFillAfter(true);
            this.hMD = AnimationUtils.loadAnimation(this.aQq.getPageActivity(), d.a.write_tab_bg_anim);
            this.hMD.setFillAfter(true);
            this.hME = AnimationUtils.loadAnimation(this.aQq.getPageActivity(), d.a.home_write_bgout);
            this.hME.setFillAfter(true);
        }
    }

    private void bLr() {
        int ao = (int) (0.15555556f * l.ao(this.aQq.getPageActivity()));
        a(this.hMm, ao);
        a(this.hMj, ao);
        a(this.hMp, ao);
        a(this.hMs, ao);
        int aq = l.aq(this.aQq.getPageActivity());
        ViewGroup.LayoutParams layoutParams = this.hMv.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = aq / 5;
            this.hMv.setLayoutParams(layoutParams);
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
            c.this.hMl.setVisibility(4);
            c.this.hMi.setVisibility(4);
            c.this.hMo.setVisibility(4);
            c.this.hMr.setVisibility(4);
            c.this.hMu.setVisibility(4);
            c.this.hMg.setVisibility(4);
            if (this.mView != null) {
                this.mView.setVisibility(8);
            }
            if (c.this.hMh.getParent() == c.this.mRootView) {
                c.this.mRootView.removeView(c.this.hMh);
            }
            c.this.hMx = false;
        }
    }

    public void op(boolean z) {
        if (!this.hMx && this.hMz && this.hMA && this.mRootView != null) {
            this.hMu.clearAnimation();
            this.hMx = true;
            if (this.hMh.getParent() == null) {
                com.baidu.tbadk.j.d.bj(this.mRootView).a(this.mRootView, this.hMh, z);
            }
            this.hMv.setVisibility(0);
            this.hMg.setVisibility(0);
            this.hMg.clearAnimation();
            this.hMg.startAnimation(this.hMD);
            this.hMu.setVisibility(0);
            this.hMu.startAnimation(this.hMB);
            bLs();
            TiebaStatic.log(new ak("c12052").ab("obj_locate", this.hMF));
        }
    }

    private void bLs() {
        clearAnimation();
        final int size = this.fDz.size();
        this.hMz = false;
        this.hMy = 0;
        for (int i = 0; i < size; i++) {
            final View view = this.fDz.get(i);
            com.baidu.adp.lib.g.e.nr().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.c.6
                @Override // java.lang.Runnable
                public void run() {
                    view.setVisibility(0);
                    Animation loadAnimation = AnimationUtils.loadAnimation(c.this.aQq.getPageActivity(), d.a.write_tab_icon_show_anim);
                    loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.c.6.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            c.q(c.this);
                            if (c.this.hMy == size) {
                                c.this.hMz = true;
                                c.this.hMy = 0;
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

    public void bLt() {
        da(this.hMv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void da(View view) {
        if (this.hMz && this.hMA) {
            if (this.hMw != null) {
                com.baidu.adp.lib.g.e.nr().removeCallbacks(this.hMw);
            }
            this.hMg.clearAnimation();
            this.hMg.startAnimation(this.hME);
            this.hMu.clearAnimation();
            this.hMu.startAnimation(this.hMC);
            bLv();
            this.hMw = new a(view);
            com.baidu.adp.lib.g.e.nr().postDelayed(this.hMw, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLu() {
        this.hMz = true;
        this.hMA = true;
        if (this.hMw != null) {
            com.baidu.adp.lib.g.e.nr().removeCallbacks(this.hMw);
        }
        if (this.hMw == null) {
            this.hMw = new a(this.hMv);
        }
        com.baidu.adp.lib.g.e.nr().postDelayed(this.hMw, 500L);
    }

    private void bLv() {
        clearAnimation();
        int size = this.fDz.size();
        this.hMy = size;
        this.hMA = false;
        int i = size - 1;
        for (int i2 = 0; i2 < size; i2++) {
            final View view = this.fDz.get(i);
            i--;
            com.baidu.adp.lib.g.e.nr().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.c.7
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(c.this.aQq.getPageActivity(), d.a.write_tab_icon_hide_anim);
                    loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.c.7.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            view.setVisibility(4);
                            if (c.this.hMy == 1) {
                                c.this.hMA = true;
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
        this.hMl.clearAnimation();
        this.hMi.clearAnimation();
        this.hMr.clearAnimation();
        this.hMo.clearAnimation();
    }

    public void onChangeSkinType() {
        aj.t(this.hMg, d.C0108d.cp_bg_line_d_alpha98);
        aj.c(this.hMj, d.f.icon_post_type_photograph_n);
        aj.c(this.hMm, d.f.icon_post_type_text_n);
        aj.c(this.hMp, d.f.icon_post_type_image_n);
        aj.c(this.hMs, d.f.icon_post_type_live_n);
        aj.c(this.hMu, d.f.icon_tabbar_add_s);
        aj.r(this.hMk, d.C0108d.cp_cont_b);
        aj.r(this.hMn, d.C0108d.cp_cont_b);
        aj.r(this.hMq, d.C0108d.cp_cont_b);
        aj.r(this.hMt, d.C0108d.cp_cont_b);
    }

    public void onDestroy() {
        if (this.hMh != null && this.hMh.getParent() == this.mRootView) {
            this.mRootView.removeView(this.hMh);
        }
        if (this.hMw != null) {
            com.baidu.adp.lib.g.e.nr().removeCallbacks(this.hMw);
            this.hMw = null;
        }
        this.fDz.clear();
    }

    public boolean isShowing() {
        return this.hMx;
    }
}
