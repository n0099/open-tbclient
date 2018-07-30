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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.GridLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ForumWriteData;
import java.util.ArrayList;
import java.util.Calendar;
/* loaded from: classes.dex */
public class c {
    private int bgColor;
    private ForumWriteData hki;
    private View hsA;
    private View hsB;
    private LinearLayout hsC;
    private TbImageView hsD;
    private TextView hsE;
    private LinearLayout hsF;
    private TbImageView hsG;
    private TextView hsH;
    private LinearLayout hsI;
    private TbImageView hsJ;
    private TextView hsK;
    private LinearLayout hsL;
    private TbImageView hsM;
    private TextView hsN;
    private ImageView hsO;
    private GridLayout hsP;
    private a hsQ;
    private Animation hsX;
    private Animation hsY;
    private Animation hsZ;
    private Animation hta;
    private com.baidu.tbadk.core.bigday.a htc;
    private TbImageView htd;
    private View hte;
    private TbPageContext mContext;
    private String mFrom;
    private ViewGroup mRootView;
    private String writeCallFrom;
    private boolean hsR = false;
    private int hsS = 0;
    private boolean hsT = true;
    private boolean hsU = true;
    private ArrayList<View> hsV = new ArrayList<>();
    private String hsW = "";
    private String htb = "0";

    static /* synthetic */ int v(c cVar) {
        int i = cVar.hsS;
        cVar.hsS = i + 1;
        return i;
    }

    static /* synthetic */ int x(c cVar) {
        int i = cVar.hsS;
        cVar.hsS = i - 1;
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

    public void vw(String str) {
        if (str == null) {
            str = "";
        }
        this.hsW = str;
    }

    public void a(ForumWriteData forumWriteData) {
        this.hki = forumWriteData;
    }

    public void vx(String str) {
        if ("3".equals(str)) {
            this.writeCallFrom = "1";
        } else {
            this.writeCallFrom = str;
        }
        this.htb = str;
    }

    private void initView() {
        if (this.mContext != null && this.mContext.getPageActivity() != null && this.mRootView != null) {
            this.hsB = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.bottom_write_thread, (ViewGroup) null);
            this.hsF = (LinearLayout) this.hsB.findViewById(d.g.home_write_article);
            this.hsG = (TbImageView) this.hsB.findViewById(d.g.home_write_article_icon);
            this.hsH = (TextView) this.hsB.findViewById(d.g.home_write_article_title);
            this.hsC = (LinearLayout) this.hsB.findViewById(d.g.home_write_photo);
            this.hsD = (TbImageView) this.hsB.findViewById(d.g.home_write_photo_icon);
            this.hsE = (TextView) this.hsB.findViewById(d.g.home_write_photo_title);
            this.hsI = (LinearLayout) this.hsB.findViewById(d.g.home_write_album);
            this.hsJ = (TbImageView) this.hsB.findViewById(d.g.home_write_album_icon);
            this.hsK = (TextView) this.hsB.findViewById(d.g.home_write_album_title);
            this.hsL = (LinearLayout) this.hsB.findViewById(d.g.home_write_live);
            this.hsM = (TbImageView) this.hsB.findViewById(d.g.home_write_live_icon);
            this.hsN = (TextView) this.hsB.findViewById(d.g.home_write_live_title);
            this.hsO = (ImageView) this.hsB.findViewById(d.g.write_close_view);
            this.hsA = this.hsB.findViewById(d.g.view_background);
            this.hsP = (GridLayout) this.hsB.findViewById(d.g.type_container);
            this.hsP.setMeasureAllChild(true);
            this.hsP.setVerNum(1);
            bFo();
            this.hsV.add(this.hsF);
            this.hsV.add(this.hsC);
            this.hsV.add(this.hsI);
            this.hsV.add(this.hsL);
            this.hsB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.bgColor != 0) {
                        UtilHelper.setNavigationBarBackground(c.this.mContext.getPageActivity(), c.this.bgColor);
                    }
                    c.this.bI(c.this.hsP);
                }
            });
            this.hsG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.vy(c.this.hsW);
                }
            });
            this.hsD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.bFs();
                    TiebaStatic.log(new an("c12611").af("obj_locate", c.this.htb).r("obj_type", 2));
                    if (c.this.hki == null) {
                        c.this.hki = new ForumWriteData("0", null, null, null);
                    }
                    c.this.hki.mFrom = c.this.mFrom;
                    c.this.hki.writeCallFrom = c.this.writeCallFrom;
                    e.a(c.this.mContext, "", c.this.hki);
                }
            });
            this.hsJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    String str2;
                    int i;
                    String str3;
                    int i2;
                    String str4;
                    String str5;
                    c.this.bFs();
                    PostPrefixData postPrefixData = null;
                    AntiData antiData = null;
                    if (c.this.hki != null) {
                        String str6 = c.this.hki.forumId;
                        String str7 = c.this.hki.forumName;
                        postPrefixData = c.this.hki.prefixData;
                        antiData = c.this.hki.antiData;
                        int i3 = c.this.hki.forumLevel;
                        String str8 = c.this.hki.avatar;
                        int i4 = c.this.hki.privateThread;
                        String str9 = c.this.hki.firstDir;
                        str = c.this.hki.secondDir;
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
                    TiebaStatic.log(new an("c12611").af("obj_locate", c.this.htb).r("obj_type", 3));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.mContext.getPageActivity(), 0, str5, str4, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", c.this.mFrom);
                    writeActivityConfig.setCallFrom(c.this.writeCallFrom);
                    writeActivityConfig.setForumLevel(i2);
                    writeActivityConfig.setForumAvatar(str3);
                    writeActivityConfig.setAlbumThread(1);
                    writeActivityConfig.setPrivateThread(i);
                    writeActivityConfig.setForumDir(str2, str);
                    if (!StringUtils.isNull(c.this.hsW)) {
                        writeActivityConfig.setTitle(c.this.hsW, true);
                    }
                    if (!c.J(c.this.mContext.getPageActivity())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                    }
                }
            });
            this.hsM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    String str2 = null;
                    c.this.bFs();
                    MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                    String str3 = "0";
                    com.baidu.adp.lib.d.a.hB().H(false);
                    if (c.this.hki != null) {
                        str3 = c.this.hki.forumId;
                        str = c.this.hki.forumName;
                        str2 = c.this.hki.specialForumType;
                    } else {
                        str = null;
                    }
                    TiebaStatic.log(new an("c12611").af("obj_locate", c.this.htb).r("obj_type", 4));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(TbadkCoreApplication.getInst().getApplicationContext(), str, str3, TbadkCoreApplication.getCurrentAccount(), str2)));
                }
            });
            onChangeSkinType();
            this.hsX = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.write_thread_black_anim);
            this.hsX.setFillAfter(true);
            this.hsY = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.write_thread_black_hide_anim);
            this.hsY.setFillAfter(true);
            this.hsZ = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.write_tab_bg_anim);
            this.hsZ.setFillAfter(true);
            this.hta = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.home_write_bgout);
            this.hta.setFillAfter(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean J(Activity activity) {
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.zY();
        aVar.c(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return aVar.u(activity);
    }

    private void bFo() {
        int ah = (int) (0.15555556f * l.ah(this.mContext.getPageActivity()));
        a(this.hsG, ah);
        a(this.hsD, ah);
        a(this.hsJ, ah);
        a(this.hsM, ah);
        int aj = l.aj(this.mContext.getPageActivity());
        ViewGroup.LayoutParams layoutParams = this.hsP.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = aj / 5;
            this.hsP.setLayoutParams(layoutParams);
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
            c.this.hsF.setVisibility(4);
            c.this.hsC.setVisibility(4);
            c.this.hsI.setVisibility(4);
            c.this.hsL.setVisibility(4);
            c.this.hsO.setVisibility(4);
            c.this.hsA.setVisibility(4);
            if (this.mView != null) {
                this.mView.setVisibility(8);
            }
            if (c.this.hsB.getParent() == c.this.mRootView) {
                c.this.mRootView.removeView(c.this.hsB);
            }
            c.this.hsR = false;
        }
    }

    private void bFp() {
        if (this.mFrom == "main_tab" && com.baidu.adp.lib.b.d.hv().ax("android_bigday_switch") != 0 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_write", 0L)) {
            this.htc = com.baidu.tbadk.core.bigday.b.tv().bD(3);
            if (this.htc != null && this.htc.tu()) {
                if (this.htd == null) {
                    this.htd = (TbImageView) this.hsB.findViewById(d.g.write_tab_bigday_img);
                    this.htd.startLoad(this.htc.imgUrl, 41, false);
                    this.htd.setVisibility(0);
                    this.htd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.7
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (c.this.htc != null && !StringUtils.isNULL(c.this.htc.acG)) {
                                ay.zK().c(c.this.mContext, new String[]{c.this.htc.acG});
                                TiebaStatic.log(new an("c13114").f(VideoPlayActivityConfig.OBJ_ID, c.this.htc.acI).af("obj_to", c.this.htc.acG));
                                c.this.bFs();
                            }
                        }
                    });
                    this.htd.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.write.c.8
                        @Override // com.baidu.tbadk.widget.TbImageView.b
                        public void a(TbImageView tbImageView, Canvas canvas) {
                            if (c.this.htd.getBdImage() == null && c.this.htc != null && !ap.isEmpty(c.this.htc.imgUrl)) {
                                c.this.htd.startLoad(c.this.htc.imgUrl, 41, false);
                            }
                        }

                        @Override // com.baidu.tbadk.widget.TbImageView.b
                        public void b(TbImageView tbImageView, Canvas canvas) {
                        }
                    });
                    ViewGroup.LayoutParams layoutParams = this.htd.getLayoutParams();
                    if (layoutParams instanceof RelativeLayout.LayoutParams) {
                        int ah = (int) (l.ah(this.mContext.getContext()) * 0.546d);
                        layoutParams.width = ah;
                        layoutParams.height = ah;
                        ((RelativeLayout.LayoutParams) layoutParams).topMargin = l.aj(this.mContext.getContext()) / 5;
                        this.htd.setLayoutParams(layoutParams);
                    }
                }
                if (this.hte == null) {
                    this.hte = this.hsB.findViewById(d.g.write_tab_bigday_close);
                    this.hte.setVisibility(0);
                    this.hte.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.9
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            c.this.hte.clearAnimation();
                            c.this.htd.clearAnimation();
                            c.this.hte.setVisibility(8);
                            c.this.htd.setVisibility(8);
                            Calendar calendar = Calendar.getInstance();
                            calendar.set(11, 23);
                            calendar.set(12, 59);
                            calendar.set(13, 59);
                            calendar.set(14, 0);
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_bigday_next_showtime_write", calendar.getTimeInMillis());
                        }
                    });
                }
                this.htd.startAnimation(this.hsZ);
                this.hte.startAnimation(this.hsZ);
                TiebaStatic.log(new an("c13113").f(VideoPlayActivityConfig.OBJ_ID, this.htc.acI).af("obj_to", this.htc.acG));
            }
        }
    }

    public void np(boolean z) {
        if (!this.hsR && this.hsT && this.hsU && this.mRootView != null) {
            bFp();
            this.hsO.clearAnimation();
            this.hsR = true;
            if (this.hsB.getParent() == null) {
                com.baidu.tbadk.k.d.R(this.mRootView).a(this.mRootView, this.hsB, z);
            }
            this.hsP.setVisibility(0);
            this.hsA.setVisibility(0);
            this.hsA.clearAnimation();
            this.hsA.startAnimation(this.hsZ);
            this.hsO.setVisibility(0);
            this.hsO.startAnimation(this.hsX);
            bFq();
            TiebaStatic.log(new an("c12052").af("obj_locate", this.htb));
            if (j.jG()) {
                String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_baidu_sim_card_writting_tip", "");
                if (!ap.isEmpty(string)) {
                    BdToast.a(this.mContext.getContext(), string).xn();
                    com.baidu.tbadk.core.sharedPref.b.getInstance().remove("key_baidu_sim_card_writting_tip");
                }
            }
        }
    }

    private void bFq() {
        clearAnimation();
        final int size = this.hsV.size();
        this.hsT = false;
        this.hsS = 0;
        for (int i = 0; i < size; i++) {
            final View view = this.hsV.get(i);
            com.baidu.adp.lib.g.e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.c.10
                @Override // java.lang.Runnable
                public void run() {
                    view.setVisibility(0);
                    Animation loadAnimation = AnimationUtils.loadAnimation(c.this.mContext.getPageActivity(), d.a.write_tab_icon_show_anim);
                    loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.c.10.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            c.v(c.this);
                            if (c.this.hsS == size) {
                                c.this.hsT = true;
                                c.this.hsS = 0;
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

    public void bFr() {
        bI(this.hsP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bI(View view) {
        if (this.hsT && this.hsU) {
            if (this.hsQ != null) {
                com.baidu.adp.lib.g.e.in().removeCallbacks(this.hsQ);
            }
            this.hsA.clearAnimation();
            this.hsA.startAnimation(this.hta);
            if (this.hte != null && this.htd != null && this.hte.getVisibility() == 0 && this.htd.getVisibility() == 0) {
                this.hte.clearAnimation();
                this.htd.clearAnimation();
                this.htd.startAnimation(this.hta);
                this.hte.startAnimation(this.hta);
            }
            this.hsO.clearAnimation();
            this.hsO.startAnimation(this.hsY);
            bFt();
            this.hsQ = new a(view);
            com.baidu.adp.lib.g.e.in().postDelayed(this.hsQ, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFs() {
        this.hsT = true;
        this.hsU = true;
        if (this.hsQ != null) {
            com.baidu.adp.lib.g.e.in().removeCallbacks(this.hsQ);
        }
        if (this.hsQ == null) {
            this.hsQ = new a(this.hsP);
        }
        com.baidu.adp.lib.g.e.in().postDelayed(this.hsQ, 500L);
    }

    private void bFt() {
        clearAnimation();
        int size = this.hsV.size();
        this.hsS = size;
        this.hsU = false;
        int i = size - 1;
        for (int i2 = 0; i2 < size; i2++) {
            final View view = this.hsV.get(i);
            i--;
            com.baidu.adp.lib.g.e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.c.2
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(c.this.mContext.getPageActivity(), d.a.write_tab_icon_hide_anim);
                    loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.c.2.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            view.setVisibility(4);
                            if (c.this.hsS == 1) {
                                c.this.hsU = true;
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
        this.hsF.clearAnimation();
        this.hsC.clearAnimation();
        this.hsL.clearAnimation();
        this.hsI.clearAnimation();
    }

    public void onChangeSkinType() {
        am.j(this.hsA, d.C0140d.cp_bg_line_d_alpha98);
        am.c(this.hsD, d.f.icon_post_type_photograph_n);
        am.c(this.hsG, d.f.icon_post_type_text_n);
        am.c(this.hsJ, d.f.icon_post_type_image_n);
        am.c(this.hsM, d.f.icon_post_type_live_n);
        am.c(this.hsO, d.f.icon_tabbar_add_s);
        am.h(this.hsE, d.C0140d.cp_cont_b);
        am.h(this.hsH, d.C0140d.cp_cont_b);
        am.h(this.hsK, d.C0140d.cp_cont_b);
        am.h(this.hsN, d.C0140d.cp_cont_b);
    }

    public void onDestroy() {
        if (this.hsB != null && this.hsB.getParent() == this.mRootView) {
            this.mRootView.removeView(this.hsB);
        }
        if (this.hsQ != null) {
            com.baidu.adp.lib.g.e.in().removeCallbacks(this.hsQ);
            this.hsQ = null;
        }
        this.hsV.clear();
    }

    public boolean isShowing() {
        return this.hsR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vy(String str) {
        String str2;
        String str3;
        int i;
        String str4;
        int i2;
        String str5;
        String str6;
        bFs();
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.hki == null) {
            str2 = "";
            str3 = "";
            i = 0;
            str4 = null;
            i2 = -1;
            str5 = null;
            str6 = "0";
        } else {
            String str7 = this.hki.forumId;
            String str8 = this.hki.forumName;
            postPrefixData = this.hki.prefixData;
            antiData = this.hki.antiData;
            int i3 = this.hki.forumLevel;
            String str9 = this.hki.avatar;
            int i4 = this.hki.privateThread;
            String str10 = this.hki.firstDir;
            str2 = this.hki.secondDir;
            str3 = str10;
            i = i4;
            str4 = str9;
            i2 = i3;
            str5 = str8;
            str6 = str7;
        }
        TiebaStatic.log(new an("c12611").af("obj_locate", this.htb).r("obj_type", 1));
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
