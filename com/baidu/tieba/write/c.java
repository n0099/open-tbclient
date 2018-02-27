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
    private TbPageContext aRG;
    private TbImageView hDA;
    private TextView hDB;
    private LinearLayout hDC;
    private TbImageView hDD;
    private TextView hDE;
    private ImageView hDF;
    private GridLayout hDG;
    private a hDH;
    private Animation hDM;
    private Animation hDN;
    private Animation hDO;
    private Animation hDP;
    private View hDr;
    private View hDs;
    private LinearLayout hDt;
    private TbImageView hDu;
    private TextView hDv;
    private LinearLayout hDw;
    private TbImageView hDx;
    private TextView hDy;
    private LinearLayout hDz;
    private ForumWriteData hwF;
    private String mFrom;
    private ViewGroup mRootView;
    private String writeCallFrom;
    private boolean hDI = false;
    private int hDJ = 0;
    private boolean hDK = true;
    private boolean hDL = true;
    private ArrayList<View> fIG = new ArrayList<>();
    private String hDQ = "0";

    static /* synthetic */ int q(c cVar) {
        int i = cVar.hDJ;
        cVar.hDJ = i + 1;
        return i;
    }

    static /* synthetic */ int s(c cVar) {
        int i = cVar.hDJ;
        cVar.hDJ = i - 1;
        return i;
    }

    public c(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this.mFrom = AlbumActivityConfig.FROM_WRITE;
        this.aRG = tbPageContext;
        this.mRootView = viewGroup;
        this.mFrom = str;
        initView();
    }

    public void a(ForumWriteData forumWriteData) {
        this.hwF = forumWriteData;
    }

    public void uo(String str) {
        if ("3".equals(str)) {
            this.writeCallFrom = "1";
        } else {
            this.writeCallFrom = str;
        }
        this.hDQ = str;
    }

    private void initView() {
        if (this.aRG != null && this.aRG.getPageActivity() != null && this.mRootView != null) {
            this.hDs = LayoutInflater.from(this.aRG.getPageActivity()).inflate(d.h.bottom_write_thread, (ViewGroup) null);
            this.hDw = (LinearLayout) this.hDs.findViewById(d.g.home_write_article);
            this.hDx = (TbImageView) this.hDs.findViewById(d.g.home_write_article_icon);
            this.hDy = (TextView) this.hDs.findViewById(d.g.home_write_article_title);
            this.hDt = (LinearLayout) this.hDs.findViewById(d.g.home_write_photo);
            this.hDu = (TbImageView) this.hDs.findViewById(d.g.home_write_photo_icon);
            this.hDv = (TextView) this.hDs.findViewById(d.g.home_write_photo_title);
            this.hDz = (LinearLayout) this.hDs.findViewById(d.g.home_write_album);
            this.hDA = (TbImageView) this.hDs.findViewById(d.g.home_write_album_icon);
            this.hDB = (TextView) this.hDs.findViewById(d.g.home_write_album_title);
            this.hDC = (LinearLayout) this.hDs.findViewById(d.g.home_write_live);
            this.hDD = (TbImageView) this.hDs.findViewById(d.g.home_write_live_icon);
            this.hDE = (TextView) this.hDs.findViewById(d.g.home_write_live_title);
            this.hDF = (ImageView) this.hDs.findViewById(d.g.write_close_view);
            this.hDr = this.hDs.findViewById(d.g.view_background);
            this.hDG = (GridLayout) this.hDs.findViewById(d.g.type_container);
            this.hDG.setMeasureAllChild(true);
            this.hDG.setVerNum(1);
            bFG();
            this.fIG.add(this.hDw);
            this.fIG.add(this.hDt);
            this.fIG.add(this.hDz);
            this.fIG.add(this.hDC);
            this.hDs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.cV(c.this.hDG);
                }
            });
            this.hDx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i;
                    String str;
                    int i2;
                    c.this.bFJ();
                    String str2 = "0";
                    String str3 = null;
                    PostPrefixData postPrefixData = null;
                    AntiData antiData = null;
                    if (c.this.hwF != null) {
                        str2 = c.this.hwF.forumId;
                        str3 = c.this.hwF.forumName;
                        postPrefixData = c.this.hwF.prefixData;
                        antiData = c.this.hwF.antiData;
                        int i3 = c.this.hwF.forumLevel;
                        String str4 = c.this.hwF.avatar;
                        i = c.this.hwF.privateThread;
                        str = str4;
                        i2 = i3;
                    } else {
                        i = 0;
                        str = null;
                        i2 = -1;
                    }
                    TiebaStatic.log(new ak("c12611").ab("obj_locate", c.this.hDQ).s("obj_type", 1));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.aRG.getPageActivity(), 9, str2, str3, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", c.this.mFrom);
                    writeActivityConfig.setCallFrom(c.this.writeCallFrom);
                    writeActivityConfig.setForumLevel(i2);
                    writeActivityConfig.setForumAvatar(str);
                    writeActivityConfig.setPrivateThread(i);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                }
            });
            this.hDu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.bFJ();
                    TiebaStatic.log(new ak("c12611").ab("obj_locate", c.this.hDQ).s("obj_type", 2));
                    if (c.this.hwF == null) {
                        c.this.hwF = new ForumWriteData("0", null, null, null);
                    }
                    c.this.hwF.mFrom = c.this.mFrom;
                    c.this.hwF.writeCallFrom = c.this.writeCallFrom;
                    f.a(c.this.aRG, "", c.this.hwF);
                }
            });
            this.hDA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i;
                    String str;
                    int i2;
                    c.this.bFJ();
                    String str2 = "0";
                    String str3 = null;
                    PostPrefixData postPrefixData = null;
                    AntiData antiData = null;
                    if (c.this.hwF != null) {
                        str2 = c.this.hwF.forumId;
                        str3 = c.this.hwF.forumName;
                        postPrefixData = c.this.hwF.prefixData;
                        antiData = c.this.hwF.antiData;
                        int i3 = c.this.hwF.forumLevel;
                        String str4 = c.this.hwF.avatar;
                        i = c.this.hwF.privateThread;
                        str = str4;
                        i2 = i3;
                    } else {
                        i = 0;
                        str = null;
                        i2 = -1;
                    }
                    TiebaStatic.log(new ak("c12611").ab("obj_locate", c.this.hDQ).s("obj_type", 3));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.aRG.getPageActivity(), 0, str2, str3, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", c.this.mFrom);
                    writeActivityConfig.setCallFrom(c.this.writeCallFrom);
                    writeActivityConfig.setForumLevel(i2);
                    writeActivityConfig.setForumAvatar(str);
                    writeActivityConfig.setAlbumThread(1);
                    writeActivityConfig.setPrivateThread(i);
                    if (!c.F(c.this.aRG.getPageActivity())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                    }
                }
            });
            this.hDD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    String str2 = null;
                    c.this.bFJ();
                    MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                    String str3 = "0";
                    TiebaStatic.log(new ak("c12611").ab("obj_locate", c.this.hDQ).s("obj_type", 4));
                    com.baidu.adp.lib.d.a.mG().an(false);
                    if (c.this.hwF != null) {
                        str3 = c.this.hwF.forumId;
                        str = c.this.hwF.forumName;
                        str2 = c.this.hwF.specialForumType;
                    } else {
                        str = null;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(TbadkCoreApplication.getInst().getApplicationContext(), str, str3, TbadkCoreApplication.getCurrentAccount(), str2)));
                }
            });
            onChangeSkinType();
            this.hDM = AnimationUtils.loadAnimation(this.aRG.getPageActivity(), d.a.write_thread_black_anim);
            this.hDM.setFillAfter(true);
            this.hDN = AnimationUtils.loadAnimation(this.aRG.getPageActivity(), d.a.write_thread_black_hide_anim);
            this.hDN.setFillAfter(true);
            this.hDO = AnimationUtils.loadAnimation(this.aRG.getPageActivity(), d.a.write_tab_bg_anim);
            this.hDO.setFillAfter(true);
            this.hDP = AnimationUtils.loadAnimation(this.aRG.getPageActivity(), d.a.home_write_bgout);
            this.hDP.setFillAfter(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean F(Activity activity) {
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.DH();
        aVar.c(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return aVar.v(activity);
    }

    private void bFG() {
        int ao = (int) (0.15555556f * l.ao(this.aRG.getPageActivity()));
        a(this.hDx, ao);
        a(this.hDu, ao);
        a(this.hDA, ao);
        a(this.hDD, ao);
        int aq = l.aq(this.aRG.getPageActivity());
        ViewGroup.LayoutParams layoutParams = this.hDG.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = aq / 5;
            this.hDG.setLayoutParams(layoutParams);
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
            c.this.hDw.setVisibility(4);
            c.this.hDt.setVisibility(4);
            c.this.hDz.setVisibility(4);
            c.this.hDC.setVisibility(4);
            c.this.hDF.setVisibility(4);
            c.this.hDr.setVisibility(4);
            if (this.mView != null) {
                this.mView.setVisibility(8);
            }
            if (c.this.hDs.getParent() == c.this.mRootView) {
                c.this.mRootView.removeView(c.this.hDs);
            }
            c.this.hDI = false;
        }
    }

    public void nC(boolean z) {
        if (!this.hDI && this.hDK && this.hDL && this.mRootView != null) {
            this.hDF.clearAnimation();
            this.hDI = true;
            if (this.hDs.getParent() == null) {
                com.baidu.tbadk.j.d.bl(this.mRootView).a(this.mRootView, this.hDs, z);
            }
            this.hDG.setVisibility(0);
            this.hDr.setVisibility(0);
            this.hDr.clearAnimation();
            this.hDr.startAnimation(this.hDO);
            this.hDF.setVisibility(0);
            this.hDF.startAnimation(this.hDM);
            bFH();
            TiebaStatic.log(new ak("c12052").ab("obj_locate", this.hDQ));
        }
    }

    private void bFH() {
        clearAnimation();
        final int size = this.fIG.size();
        this.hDK = false;
        this.hDJ = 0;
        for (int i = 0; i < size; i++) {
            final View view = this.fIG.get(i);
            com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.c.6
                @Override // java.lang.Runnable
                public void run() {
                    view.setVisibility(0);
                    Animation loadAnimation = AnimationUtils.loadAnimation(c.this.aRG.getPageActivity(), d.a.write_tab_icon_show_anim);
                    loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.c.6.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            c.q(c.this);
                            if (c.this.hDJ == size) {
                                c.this.hDK = true;
                                c.this.hDJ = 0;
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

    public void bFI() {
        cV(this.hDG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cV(View view) {
        if (this.hDK && this.hDL) {
            if (this.hDH != null) {
                com.baidu.adp.lib.g.e.ns().removeCallbacks(this.hDH);
            }
            this.hDr.clearAnimation();
            this.hDr.startAnimation(this.hDP);
            this.hDF.clearAnimation();
            this.hDF.startAnimation(this.hDN);
            bFK();
            this.hDH = new a(view);
            com.baidu.adp.lib.g.e.ns().postDelayed(this.hDH, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFJ() {
        this.hDK = true;
        this.hDL = true;
        if (this.hDH != null) {
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.hDH);
        }
        if (this.hDH == null) {
            this.hDH = new a(this.hDG);
        }
        com.baidu.adp.lib.g.e.ns().postDelayed(this.hDH, 500L);
    }

    private void bFK() {
        clearAnimation();
        int size = this.fIG.size();
        this.hDJ = size;
        this.hDL = false;
        int i = size - 1;
        for (int i2 = 0; i2 < size; i2++) {
            final View view = this.fIG.get(i);
            i--;
            com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.c.7
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(c.this.aRG.getPageActivity(), d.a.write_tab_icon_hide_anim);
                    loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.c.7.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            view.setVisibility(4);
                            if (c.this.hDJ == 1) {
                                c.this.hDL = true;
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
        this.hDw.clearAnimation();
        this.hDt.clearAnimation();
        this.hDC.clearAnimation();
        this.hDz.clearAnimation();
    }

    public void onChangeSkinType() {
        aj.t(this.hDr, d.C0141d.cp_bg_line_d_alpha98);
        aj.c(this.hDu, d.f.icon_post_type_photograph_n);
        aj.c(this.hDx, d.f.icon_post_type_text_n);
        aj.c(this.hDA, d.f.icon_post_type_image_n);
        aj.c(this.hDD, d.f.icon_post_type_live_n);
        aj.c(this.hDF, d.f.icon_tabbar_add_s);
        aj.r(this.hDv, d.C0141d.cp_cont_b);
        aj.r(this.hDy, d.C0141d.cp_cont_b);
        aj.r(this.hDB, d.C0141d.cp_cont_b);
        aj.r(this.hDE, d.C0141d.cp_cont_b);
    }

    public void onDestroy() {
        if (this.hDs != null && this.hDs.getParent() == this.mRootView) {
            this.mRootView.removeView(this.hDs);
        }
        if (this.hDH != null) {
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.hDH);
            this.hDH = null;
        }
        this.fIG.clear();
    }

    public boolean isShowing() {
        return this.hDI;
    }
}
