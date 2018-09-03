package com.baidu.tieba.write;

import android.app.Activity;
import android.graphics.Canvas;
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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaMasterLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.GridLayout;
import com.baidu.tieba.f;
import com.baidu.tieba.frs.ForumWriteData;
import java.util.ArrayList;
import java.util.Calendar;
/* loaded from: classes.dex */
public class c {
    private int bgColor;
    private ForumWriteData hkj;
    private View hsC;
    private View hsD;
    private LinearLayout hsE;
    private TbImageView hsF;
    private TextView hsG;
    private LinearLayout hsH;
    private TbImageView hsI;
    private TextView hsJ;
    private LinearLayout hsK;
    private TbImageView hsL;
    private TextView hsM;
    private LinearLayout hsN;
    private TbImageView hsO;
    private TextView hsP;
    private ImageView hsQ;
    private GridLayout hsR;
    private a hsS;
    private Animation hsZ;
    private Animation hta;
    private Animation htb;
    private Animation htc;
    private com.baidu.tbadk.core.bigday.a hte;
    private TbImageView htf;
    private View htg;
    private TbPageContext mContext;
    private String mFrom;
    private ViewGroup mRootView;
    private String writeCallFrom;
    private boolean hsT = false;
    private int hsU = 0;
    private boolean hsV = true;
    private boolean hsW = true;
    private ArrayList<View> hsX = new ArrayList<>();
    private String hsY = "";
    private String htd = "0";

    static /* synthetic */ int v(c cVar) {
        int i = cVar.hsU;
        cVar.hsU = i + 1;
        return i;
    }

    static /* synthetic */ int x(c cVar) {
        int i = cVar.hsU;
        cVar.hsU = i - 1;
        return i;
    }

    public c(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this.mFrom = AlbumActivityConfig.FROM_WRITE;
        this.mContext = tbPageContext;
        this.mRootView = viewGroup;
        this.mFrom = str;
        initView();
        onChangeSkinType();
    }

    public void vA(String str) {
        if (str == null) {
            str = "";
        }
        this.hsY = str;
    }

    public void a(ForumWriteData forumWriteData) {
        this.hkj = forumWriteData;
    }

    public void vB(String str) {
        if ("3".equals(str)) {
            this.writeCallFrom = "1";
        } else {
            this.writeCallFrom = str;
        }
        this.htd = str;
    }

    private void initView() {
        if (this.mContext != null && this.mContext.getPageActivity() != null && this.mRootView != null) {
            this.hsD = LayoutInflater.from(this.mContext.getPageActivity()).inflate(f.h.bottom_write_thread, (ViewGroup) null);
            this.hsH = (LinearLayout) this.hsD.findViewById(f.g.home_write_article);
            this.hsI = (TbImageView) this.hsD.findViewById(f.g.home_write_article_icon);
            this.hsJ = (TextView) this.hsD.findViewById(f.g.home_write_article_title);
            this.hsE = (LinearLayout) this.hsD.findViewById(f.g.home_write_photo);
            this.hsF = (TbImageView) this.hsD.findViewById(f.g.home_write_photo_icon);
            this.hsG = (TextView) this.hsD.findViewById(f.g.home_write_photo_title);
            this.hsK = (LinearLayout) this.hsD.findViewById(f.g.home_write_album);
            this.hsL = (TbImageView) this.hsD.findViewById(f.g.home_write_album_icon);
            this.hsM = (TextView) this.hsD.findViewById(f.g.home_write_album_title);
            this.hsN = (LinearLayout) this.hsD.findViewById(f.g.home_write_live);
            this.hsO = (TbImageView) this.hsD.findViewById(f.g.home_write_live_icon);
            this.hsP = (TextView) this.hsD.findViewById(f.g.home_write_live_title);
            this.hsQ = (ImageView) this.hsD.findViewById(f.g.write_close_view);
            this.hsC = this.hsD.findViewById(f.g.view_background);
            this.hsR = (GridLayout) this.hsD.findViewById(f.g.type_container);
            this.hsR.setMeasureAllChild(true);
            this.hsR.setVerNum(1);
            bFs();
            this.hsX.add(this.hsH);
            this.hsX.add(this.hsE);
            this.hsX.add(this.hsK);
            this.hsX.add(this.hsN);
            this.hsD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.bgColor != 0) {
                        UtilHelper.setNavigationBarBackground(c.this.mContext.getPageActivity(), c.this.bgColor);
                    }
                    c.this.bI(c.this.hsR);
                }
            });
            this.hsI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.vC(c.this.hsY);
                }
            });
            this.hsF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.bFw();
                    TiebaStatic.log(new an("c12611").ae("obj_locate", c.this.htd).r("obj_type", 2));
                    if (c.this.hkj == null) {
                        c.this.hkj = new ForumWriteData("0", null, null, null);
                    }
                    c.this.hkj.mFrom = c.this.mFrom;
                    c.this.hkj.writeCallFrom = c.this.writeCallFrom;
                    e.a(c.this.mContext, "", c.this.hkj);
                }
            });
            this.hsL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    String str2;
                    int i;
                    String str3;
                    int i2;
                    String str4;
                    String str5;
                    c.this.bFw();
                    PostPrefixData postPrefixData = null;
                    AntiData antiData = null;
                    if (c.this.hkj != null) {
                        String str6 = c.this.hkj.forumId;
                        String str7 = c.this.hkj.forumName;
                        postPrefixData = c.this.hkj.prefixData;
                        antiData = c.this.hkj.antiData;
                        int i3 = c.this.hkj.forumLevel;
                        String str8 = c.this.hkj.avatar;
                        int i4 = c.this.hkj.privateThread;
                        String str9 = c.this.hkj.firstDir;
                        str = c.this.hkj.secondDir;
                        str2 = str9;
                        i = i4;
                        str3 = str8;
                        i2 = i3;
                        str4 = str7;
                        str5 = str6;
                    } else {
                        str = "";
                        str2 = "";
                        i = 0;
                        str3 = null;
                        i2 = -1;
                        str4 = null;
                        str5 = "0";
                    }
                    TiebaStatic.log(new an("c12611").ae("obj_locate", c.this.htd).r("obj_type", 3));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.mContext.getPageActivity(), 0, str5, str4, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", c.this.mFrom);
                    writeActivityConfig.setCallFrom(c.this.writeCallFrom);
                    writeActivityConfig.setForumLevel(i2);
                    writeActivityConfig.setForumAvatar(str3);
                    writeActivityConfig.setAlbumThread(1);
                    writeActivityConfig.setPrivateThread(i);
                    writeActivityConfig.setForumDir(str2, str);
                    if (!StringUtils.isNull(c.this.hsY)) {
                        writeActivityConfig.setTitle(c.this.hsY, true);
                    }
                    if (!c.J(c.this.mContext.getPageActivity())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                    }
                }
            });
            this.hsO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    String str2 = null;
                    c.this.bFw();
                    MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                    String str3 = "0";
                    com.baidu.adp.lib.d.a.hB().H(false);
                    if (c.this.hkj != null) {
                        str3 = c.this.hkj.forumId;
                        str = c.this.hkj.forumName;
                        str2 = c.this.hkj.specialForumType;
                    } else {
                        str = null;
                    }
                    TiebaStatic.log(new an("c12611").ae("obj_locate", c.this.htd).r("obj_type", 4));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(TbadkCoreApplication.getInst().getApplicationContext(), str, str3, TbadkCoreApplication.getCurrentAccount(), str2)));
                }
            });
            onChangeSkinType();
            this.hsZ = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), f.a.write_thread_black_anim);
            this.hsZ.setFillAfter(true);
            this.hta = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), f.a.write_thread_black_hide_anim);
            this.hta.setFillAfter(true);
            this.htb = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), f.a.write_tab_bg_anim);
            this.htb.setFillAfter(true);
            this.htc = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), f.a.home_write_bgout);
            this.htc.setFillAfter(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean J(Activity activity) {
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.zW();
        aVar.c(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return aVar.u(activity);
    }

    private void bFs() {
        int ah = (int) (0.15555556f * l.ah(this.mContext.getPageActivity()));
        a(this.hsI, ah);
        a(this.hsF, ah);
        a(this.hsL, ah);
        a(this.hsO, ah);
        int aj = l.aj(this.mContext.getPageActivity());
        ViewGroup.LayoutParams layoutParams = this.hsR.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = aj / 5;
            this.hsR.setLayoutParams(layoutParams);
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

    public void vk(int i) {
        this.bgColor = i;
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
            c.this.hsH.setVisibility(4);
            c.this.hsE.setVisibility(4);
            c.this.hsK.setVisibility(4);
            c.this.hsN.setVisibility(4);
            c.this.hsQ.setVisibility(4);
            c.this.hsC.setVisibility(4);
            if (this.mView != null) {
                this.mView.setVisibility(8);
            }
            if (c.this.hsD.getParent() == c.this.mRootView) {
                c.this.mRootView.removeView(c.this.hsD);
            }
            c.this.hsT = false;
        }
    }

    private void bFt() {
        if (this.mFrom == "main_tab" && com.baidu.adp.lib.b.d.hv().ax("android_bigday_switch") != 0 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_write", 0L)) {
            this.hte = com.baidu.tbadk.core.bigday.b.tu().bD(3);
            if (this.hte != null && this.hte.tt()) {
                if (this.htf == null) {
                    this.htf = (TbImageView) this.hsD.findViewById(f.g.write_tab_bigday_img);
                    this.htf.startLoad(this.hte.imgUrl, 41, false);
                    this.htf.setVisibility(0);
                    this.htf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.7
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (c.this.hte != null && !StringUtils.isNULL(c.this.hte.acH)) {
                                az.zI().c(c.this.mContext, new String[]{c.this.hte.acH});
                                TiebaStatic.log(new an("c13114").f(VideoPlayActivityConfig.OBJ_ID, c.this.hte.acJ).ae("obj_to", c.this.hte.acH));
                                c.this.bFw();
                            }
                        }
                    });
                    this.htf.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.write.c.8
                        @Override // com.baidu.tbadk.widget.TbImageView.b
                        public void a(TbImageView tbImageView, Canvas canvas) {
                            if (c.this.htf.getBdImage() == null && c.this.hte != null && !ap.isEmpty(c.this.hte.imgUrl)) {
                                c.this.htf.startLoad(c.this.hte.imgUrl, 41, false);
                            }
                        }

                        @Override // com.baidu.tbadk.widget.TbImageView.b
                        public void b(TbImageView tbImageView, Canvas canvas) {
                        }
                    });
                    ViewGroup.LayoutParams layoutParams = this.htf.getLayoutParams();
                    if (layoutParams instanceof RelativeLayout.LayoutParams) {
                        int ah = (int) (l.ah(this.mContext.getContext()) * 0.546d);
                        layoutParams.width = ah;
                        layoutParams.height = ah;
                        ((RelativeLayout.LayoutParams) layoutParams).topMargin = l.aj(this.mContext.getContext()) / 5;
                        this.htf.setLayoutParams(layoutParams);
                    }
                }
                if (this.htg == null) {
                    this.htg = this.hsD.findViewById(f.g.write_tab_bigday_close);
                    this.htg.setVisibility(0);
                    this.htg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.9
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            c.this.htg.clearAnimation();
                            c.this.htf.clearAnimation();
                            c.this.htg.setVisibility(8);
                            c.this.htf.setVisibility(8);
                            Calendar calendar = Calendar.getInstance();
                            calendar.set(11, 23);
                            calendar.set(12, 59);
                            calendar.set(13, 59);
                            calendar.set(14, 0);
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_bigday_next_showtime_write", calendar.getTimeInMillis());
                        }
                    });
                }
                this.htf.startAnimation(this.htb);
                this.htg.startAnimation(this.htb);
                TiebaStatic.log(new an("c13113").f(VideoPlayActivityConfig.OBJ_ID, this.hte.acJ).ae("obj_to", this.hte.acH));
            }
        }
    }

    public void np(boolean z) {
        if (!this.hsT && this.hsV && this.hsW && this.mRootView != null) {
            bFt();
            this.hsQ.clearAnimation();
            this.hsT = true;
            if (this.hsD.getParent() == null) {
                com.baidu.tbadk.k.d.R(this.mRootView).a(this.mRootView, this.hsD, z);
            }
            this.hsR.setVisibility(0);
            this.hsC.setVisibility(0);
            this.hsC.clearAnimation();
            this.hsC.startAnimation(this.htb);
            this.hsQ.setVisibility(0);
            this.hsQ.startAnimation(this.hsZ);
            bFu();
            TiebaStatic.log(new an("c12052").ae("obj_locate", this.htd));
            if (j.jG()) {
                String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_baidu_sim_card_writting_tip", "");
                if (!ap.isEmpty(string)) {
                    BdToast.a(this.mContext.getContext(), string).xm();
                    com.baidu.tbadk.core.sharedPref.b.getInstance().remove("key_baidu_sim_card_writting_tip");
                }
            }
        }
    }

    private void bFu() {
        clearAnimation();
        final int size = this.hsX.size();
        this.hsV = false;
        this.hsU = 0;
        for (int i = 0; i < size; i++) {
            final View view = this.hsX.get(i);
            com.baidu.adp.lib.g.e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.c.10
                @Override // java.lang.Runnable
                public void run() {
                    view.setVisibility(0);
                    Animation loadAnimation = AnimationUtils.loadAnimation(c.this.mContext.getPageActivity(), f.a.write_tab_icon_show_anim);
                    loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.c.10.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            c.v(c.this);
                            if (c.this.hsU == size) {
                                c.this.hsV = true;
                                c.this.hsU = 0;
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

    public void bFv() {
        bI(this.hsR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bI(View view) {
        if (this.hsV && this.hsW) {
            if (this.hsS != null) {
                com.baidu.adp.lib.g.e.in().removeCallbacks(this.hsS);
            }
            this.hsC.clearAnimation();
            this.hsC.startAnimation(this.htc);
            if (this.htg != null && this.htf != null && this.htg.getVisibility() == 0 && this.htf.getVisibility() == 0) {
                this.htg.clearAnimation();
                this.htf.clearAnimation();
                this.htf.startAnimation(this.htc);
                this.htg.startAnimation(this.htc);
            }
            this.hsQ.clearAnimation();
            this.hsQ.startAnimation(this.hta);
            bFx();
            this.hsS = new a(view);
            com.baidu.adp.lib.g.e.in().postDelayed(this.hsS, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFw() {
        this.hsV = true;
        this.hsW = true;
        if (this.hsS != null) {
            com.baidu.adp.lib.g.e.in().removeCallbacks(this.hsS);
        }
        if (this.hsS == null) {
            this.hsS = new a(this.hsR);
        }
        com.baidu.adp.lib.g.e.in().postDelayed(this.hsS, 500L);
    }

    private void bFx() {
        clearAnimation();
        int size = this.hsX.size();
        this.hsU = size;
        this.hsW = false;
        int i = size - 1;
        for (int i2 = 0; i2 < size; i2++) {
            final View view = this.hsX.get(i);
            i--;
            com.baidu.adp.lib.g.e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.c.2
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(c.this.mContext.getPageActivity(), f.a.write_tab_icon_hide_anim);
                    loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.c.2.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            view.setVisibility(4);
                            if (c.this.hsU == 1) {
                                c.this.hsW = true;
                            } else {
                                c.x(c.this);
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
        this.hsH.clearAnimation();
        this.hsE.clearAnimation();
        this.hsN.clearAnimation();
        this.hsK.clearAnimation();
    }

    public void onChangeSkinType() {
        am.j(this.hsC, f.d.cp_bg_line_d_alpha98);
        am.c(this.hsF, f.C0146f.icon_post_type_photograph_n);
        am.c(this.hsI, f.C0146f.icon_post_type_text_n);
        am.c(this.hsL, f.C0146f.icon_post_type_image_n);
        am.c(this.hsO, f.C0146f.icon_post_type_live_n);
        am.c(this.hsQ, f.C0146f.icon_tabbar_add_s);
        am.h(this.hsG, f.d.cp_cont_b);
        am.h(this.hsJ, f.d.cp_cont_b);
        am.h(this.hsM, f.d.cp_cont_b);
        am.h(this.hsP, f.d.cp_cont_b);
    }

    public void onDestroy() {
        if (this.hsD != null && this.hsD.getParent() == this.mRootView) {
            this.mRootView.removeView(this.hsD);
        }
        if (this.hsS != null) {
            com.baidu.adp.lib.g.e.in().removeCallbacks(this.hsS);
            this.hsS = null;
        }
        this.hsX.clear();
    }

    public boolean isShowing() {
        return this.hsT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vC(String str) {
        String str2;
        String str3;
        int i;
        String str4;
        int i2;
        String str5;
        String str6;
        bFw();
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.hkj == null) {
            str2 = "";
            str3 = "";
            i = 0;
            str4 = null;
            i2 = -1;
            str5 = null;
            str6 = "0";
        } else {
            String str7 = this.hkj.forumId;
            String str8 = this.hkj.forumName;
            postPrefixData = this.hkj.prefixData;
            antiData = this.hkj.antiData;
            int i3 = this.hkj.forumLevel;
            String str9 = this.hkj.avatar;
            int i4 = this.hkj.privateThread;
            String str10 = this.hkj.firstDir;
            str2 = this.hkj.secondDir;
            str3 = str10;
            i = i4;
            str4 = str9;
            i2 = i3;
            str5 = str8;
            str6 = str7;
        }
        TiebaStatic.log(new an("c12611").ae("obj_locate", this.htd).r("obj_type", 1));
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mContext.getPageActivity(), 9, str6, str5, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom(this.writeCallFrom);
        if (!StringUtils.isNull(str)) {
            writeActivityConfig.setTitle(str, true);
        }
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str4);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setForumDir(str3, str2);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
    }
}
