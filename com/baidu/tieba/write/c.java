package com.baidu.tieba.write;

import android.app.Activity;
import android.graphics.Canvas;
import android.os.Build;
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
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.b.a;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.GridLayout;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.ForumWriteData;
import java.util.ArrayList;
import java.util.Calendar;
/* loaded from: classes.dex */
public class c {
    private int bgColor;
    private ForumWriteData hIi;
    private View hQD;
    private View hQE;
    private LinearLayout hQF;
    private TbImageView hQG;
    private TextView hQH;
    private LinearLayout hQI;
    private TbImageView hQJ;
    private TextView hQK;
    private LinearLayout hQL;
    private TbImageView hQM;
    private TextView hQN;
    private LinearLayout hQO;
    private TbImageView hQP;
    private TextView hQQ;
    private ImageView hQR;
    private GridLayout hQS;
    private a hQT;
    private Animation hRa;
    private Animation hRb;
    private Animation hRc;
    private Animation hRd;
    private com.baidu.tbadk.core.bigday.a hRf;
    private TbImageView hRg;
    private View hRh;
    private TbPageContext mContext;
    private String mFrom;
    private ViewGroup mRootView;
    private String writeCallFrom;
    private boolean hQU = false;
    private int hQV = 0;
    private boolean hQW = true;
    private boolean hQX = true;
    private ArrayList<View> hQY = new ArrayList<>();
    private String hQZ = "";
    private String hRe = "0";

    static /* synthetic */ int v(c cVar) {
        int i = cVar.hQV;
        cVar.hQV = i + 1;
        return i;
    }

    static /* synthetic */ int x(c cVar) {
        int i = cVar.hQV;
        cVar.hQV = i - 1;
        return i;
    }

    public c(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this.mFrom = "write";
        this.mContext = tbPageContext;
        this.mRootView = viewGroup;
        this.mFrom = str;
        initView();
        onChangeSkinType();
    }

    public void xs(String str) {
        if (str == null) {
            str = "";
        }
        this.hQZ = str;
    }

    public void a(ForumWriteData forumWriteData) {
        this.hIi = forumWriteData;
    }

    public void xt(String str) {
        if ("3".equals(str)) {
            this.writeCallFrom = "1";
        } else {
            this.writeCallFrom = str;
        }
        this.hRe = str;
    }

    private void initView() {
        if (this.mContext != null && this.mContext.getPageActivity() != null && this.mRootView != null) {
            this.hQE = LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.bottom_write_thread, (ViewGroup) null);
            this.hQI = (LinearLayout) this.hQE.findViewById(e.g.home_write_article);
            this.hQJ = (TbImageView) this.hQE.findViewById(e.g.home_write_article_icon);
            this.hQK = (TextView) this.hQE.findViewById(e.g.home_write_article_title);
            this.hQF = (LinearLayout) this.hQE.findViewById(e.g.home_write_photo);
            this.hQG = (TbImageView) this.hQE.findViewById(e.g.home_write_photo_icon);
            this.hQH = (TextView) this.hQE.findViewById(e.g.home_write_photo_title);
            this.hQL = (LinearLayout) this.hQE.findViewById(e.g.home_write_album);
            this.hQM = (TbImageView) this.hQE.findViewById(e.g.home_write_album_icon);
            this.hQN = (TextView) this.hQE.findViewById(e.g.home_write_album_title);
            this.hQO = (LinearLayout) this.hQE.findViewById(e.g.home_write_live);
            this.hQP = (TbImageView) this.hQE.findViewById(e.g.home_write_live_icon);
            this.hQQ = (TextView) this.hQE.findViewById(e.g.home_write_live_title);
            this.hQR = (ImageView) this.hQE.findViewById(e.g.write_close_view);
            this.hQD = this.hQE.findViewById(e.g.view_background);
            this.hQS = (GridLayout) this.hQE.findViewById(e.g.type_container);
            this.hQS.setMeasureAllChild(true);
            this.hQS.setVerNum(1);
            bNa();
            this.hQY.add(this.hQI);
            this.hQY.add(this.hQF);
            this.hQY.add(this.hQL);
            this.hQY.add(this.hQO);
            this.hQE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.bgColor != 0) {
                        UtilHelper.setNavigationBarBackground(c.this.mContext.getPageActivity(), c.this.bgColor);
                    }
                    c.this.bX(c.this.hQS);
                }
            });
            this.hQJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.xu(c.this.hQZ);
                }
            });
            this.hQG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.bNd();
                    TiebaStatic.log(new am("c12611").aA("obj_locate", c.this.hRe).x("obj_type", 2));
                    if (c.this.hIi == null) {
                        c.this.hIi = new ForumWriteData("0", null, null, null);
                    }
                    c.this.hIi.mFrom = c.this.mFrom;
                    c.this.hIi.writeCallFrom = c.this.writeCallFrom;
                    e.a(c.this.mContext, "", c.this.hIi);
                }
            });
            this.hQM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    String str2;
                    int i;
                    String str3;
                    int i2;
                    String str4;
                    String str5;
                    c.this.bNd();
                    PostPrefixData postPrefixData = null;
                    AntiData antiData = null;
                    if (c.this.hIi != null) {
                        String str6 = c.this.hIi.forumId;
                        String str7 = c.this.hIi.forumName;
                        postPrefixData = c.this.hIi.prefixData;
                        antiData = c.this.hIi.antiData;
                        int i3 = c.this.hIi.forumLevel;
                        String str8 = c.this.hIi.avatar;
                        int i4 = c.this.hIi.privateThread;
                        String str9 = c.this.hIi.firstDir;
                        str = c.this.hIi.secondDir;
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
                    TiebaStatic.log(new am("c12611").aA("obj_locate", c.this.hRe).x("obj_type", 3));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.mContext.getPageActivity(), 0, str5, str4, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", c.this.mFrom);
                    writeActivityConfig.setCallFrom(c.this.writeCallFrom);
                    writeActivityConfig.setForumLevel(i2);
                    writeActivityConfig.setForumAvatar(str3);
                    writeActivityConfig.setAlbumThread(1);
                    writeActivityConfig.setPrivateThread(i);
                    writeActivityConfig.setForumDir(str2, str);
                    if (!StringUtils.isNull(c.this.hQZ)) {
                        writeActivityConfig.setTitle(c.this.hQZ, true);
                    }
                    if (!c.a(c.this.mContext.getPageActivity(), writeActivityConfig)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                    }
                }
            });
            this.hQP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    String str2 = null;
                    c.this.bNd();
                    if (Build.VERSION.SDK_INT < 21) {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(c.this.mContext.getPageActivity());
                        aVar.setAutoNight(false);
                        aVar.da(e.j.prompt);
                        aVar.eB(c.this.mContext.getResources().getString(e.j.disallow_open_live_by_android_v5_0));
                        aVar.bm(true);
                        aVar.bl(true);
                        aVar.a(e.j.know, new a.b() { // from class: com.baidu.tieba.write.c.7.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                            }
                        });
                        aVar.b(c.this.mContext).BF();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                    String str3 = "0";
                    com.baidu.adp.lib.d.a.iW().af(false);
                    if (c.this.hIi != null) {
                        str3 = c.this.hIi.forumId;
                        str = c.this.hIi.forumName;
                        str2 = c.this.hIi.specialForumType;
                    } else {
                        str = null;
                    }
                    TiebaStatic.log(new am("c12611").aA("obj_locate", c.this.hRe).x("obj_type", 4));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(TbadkCoreApplication.getInst().getApplicationContext(), str, str3, TbadkCoreApplication.getCurrentAccount(), str2)));
                }
            });
            onChangeSkinType();
            this.hRa = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.write_thread_black_anim);
            this.hRa.setFillAfter(true);
            this.hRb = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.write_thread_black_hide_anim);
            this.hRb.setFillAfter(true);
            this.hRc = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.write_tab_bg_anim);
            this.hRc.setFillAfter(true);
            this.hRd = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.home_write_bgout);
            this.hRd.setFillAfter(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(Activity activity, final WriteActivityConfig writeActivityConfig) {
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.Et();
        aVar.c(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
        aVar.a(new a.InterfaceC0160a() { // from class: com.baidu.tieba.write.c.8
            @Override // com.baidu.tbadk.core.util.b.a.InterfaceC0160a
            public void Eu() {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, WriteActivityConfig.this));
            }
        });
        return aVar.A(activity);
    }

    private void bNa() {
        int aO = (int) (0.15555556f * l.aO(this.mContext.getPageActivity()));
        b(this.hQJ, aO);
        b(this.hQG, aO);
        b(this.hQM, aO);
        b(this.hQP, aO);
        int aQ = l.aQ(this.mContext.getPageActivity());
        ViewGroup.LayoutParams layoutParams = this.hQS.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = aQ / 5;
            this.hQS.setLayoutParams(layoutParams);
        }
    }

    private void b(TbImageView tbImageView, int i) {
        if (tbImageView != null && i > 0) {
            ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i;
            tbImageView.setLayoutParams(layoutParams);
        }
    }

    public void wX(int i) {
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
            c.this.hQI.setVisibility(4);
            c.this.hQF.setVisibility(4);
            c.this.hQL.setVisibility(4);
            c.this.hQO.setVisibility(4);
            c.this.hQR.setVisibility(4);
            c.this.hQD.setVisibility(4);
            if (this.mView != null) {
                this.mView.setVisibility(8);
            }
            if (c.this.hQE.getParent() == c.this.mRootView) {
                c.this.mRootView.removeView(c.this.hQE);
            }
            c.this.hQU = false;
        }
    }

    private void bNb() {
        if (this.mFrom == "main_tab" && com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") != 0 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_write", 0L)) {
            this.hRf = com.baidu.tbadk.core.bigday.b.xS().cA(3);
            if (this.hRf != null && this.hRf.xR()) {
                if (this.hRg == null) {
                    this.hRg = (TbImageView) this.hQE.findViewById(e.g.write_tab_bigday_img);
                    this.hRg.startLoad(this.hRf.imgUrl, 41, false);
                    this.hRg.setVisibility(0);
                    this.hRg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.9
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (c.this.hRf != null && !StringUtils.isNULL(c.this.hRf.aou)) {
                                ay.Ef().c(c.this.mContext, new String[]{c.this.hRf.aou});
                                TiebaStatic.log(new am("c13114").i(VideoPlayActivityConfig.OBJ_ID, c.this.hRf.aow).aA("obj_to", c.this.hRf.aou));
                                c.this.bNd();
                            }
                        }
                    });
                    this.hRg.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.write.c.10
                        @Override // com.baidu.tbadk.widget.TbImageView.b
                        public void a(TbImageView tbImageView, Canvas canvas) {
                            if (c.this.hRg.getBdImage() == null && c.this.hRf != null && !ao.isEmpty(c.this.hRf.imgUrl)) {
                                c.this.hRg.startLoad(c.this.hRf.imgUrl, 41, false);
                            }
                        }

                        @Override // com.baidu.tbadk.widget.TbImageView.b
                        public void b(TbImageView tbImageView, Canvas canvas) {
                        }
                    });
                    ViewGroup.LayoutParams layoutParams = this.hRg.getLayoutParams();
                    if (layoutParams instanceof RelativeLayout.LayoutParams) {
                        int aO = (int) (l.aO(this.mContext.getContext()) * 0.546d);
                        layoutParams.width = aO;
                        layoutParams.height = aO;
                        ((RelativeLayout.LayoutParams) layoutParams).topMargin = l.aQ(this.mContext.getContext()) / 5;
                        this.hRg.setLayoutParams(layoutParams);
                    }
                }
                if (this.hRh == null) {
                    this.hRh = this.hQE.findViewById(e.g.write_tab_bigday_close);
                    this.hRh.setVisibility(0);
                    this.hRh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.11
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            c.this.hRh.clearAnimation();
                            c.this.hRg.clearAnimation();
                            c.this.hRh.setVisibility(8);
                            c.this.hRg.setVisibility(8);
                            Calendar calendar = Calendar.getInstance();
                            calendar.set(11, 23);
                            calendar.set(12, 59);
                            calendar.set(13, 59);
                            calendar.set(14, 0);
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_bigday_next_showtime_write", calendar.getTimeInMillis());
                        }
                    });
                }
                this.hRg.startAnimation(this.hRc);
                this.hRh.startAnimation(this.hRc);
                TiebaStatic.log(new am("c13113").i(VideoPlayActivityConfig.OBJ_ID, this.hRf.aow).aA("obj_to", this.hRf.aou));
            }
        }
    }

    public void os(boolean z) {
        if (!this.hQU && this.hQW && this.hQX && this.mRootView != null) {
            bNb();
            this.hQR.clearAnimation();
            this.hQU = true;
            if (this.hQE.getParent() == null) {
                com.baidu.tbadk.k.d.ad(this.mRootView).a(this.mRootView, this.hQE, z);
            }
            this.hQS.setVisibility(0);
            this.hQD.setVisibility(0);
            this.hQD.clearAnimation();
            this.hQD.startAnimation(this.hRc);
            this.hQR.setVisibility(0);
            this.hQR.startAnimation(this.hRa);
            bNc();
            TiebaStatic.log(new am("c12052").aA("obj_locate", this.hRe));
            if (j.kX()) {
                String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_baidu_sim_card_writting_tip", "");
                if (!ao.isEmpty(string)) {
                    BdToast.a(this.mContext.getContext(), string).BN();
                    com.baidu.tbadk.core.sharedPref.b.getInstance().remove("key_baidu_sim_card_writting_tip");
                }
            }
        }
    }

    private void bNc() {
        clearAnimation();
        final int size = this.hQY.size();
        this.hQW = false;
        this.hQV = 0;
        for (int i = 0; i < size; i++) {
            final View view = this.hQY.get(i);
            com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.c.2
                @Override // java.lang.Runnable
                public void run() {
                    view.setVisibility(0);
                    Animation loadAnimation = AnimationUtils.loadAnimation(c.this.mContext.getPageActivity(), e.a.write_tab_icon_show_anim);
                    loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.c.2.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            c.v(c.this);
                            if (c.this.hQV == size) {
                                c.this.hQW = true;
                                c.this.hQV = 0;
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

    public void aCq() {
        bX(this.hQS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bX(View view) {
        if (this.hQW && this.hQX) {
            if (this.hQT != null) {
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.hQT);
            }
            this.hQD.clearAnimation();
            this.hQD.startAnimation(this.hRd);
            if (this.hRh != null && this.hRg != null && this.hRh.getVisibility() == 0 && this.hRg.getVisibility() == 0) {
                this.hRh.clearAnimation();
                this.hRg.clearAnimation();
                this.hRg.startAnimation(this.hRd);
                this.hRh.startAnimation(this.hRd);
            }
            this.hQR.clearAnimation();
            this.hQR.startAnimation(this.hRb);
            bNe();
            this.hQT = new a(view);
            com.baidu.adp.lib.g.e.jG().postDelayed(this.hQT, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNd() {
        this.hQW = true;
        this.hQX = true;
        if (this.hQT != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.hQT);
        }
        if (this.hQT == null) {
            this.hQT = new a(this.hQS);
        }
        com.baidu.adp.lib.g.e.jG().postDelayed(this.hQT, 500L);
    }

    private void bNe() {
        clearAnimation();
        int size = this.hQY.size();
        this.hQV = size;
        this.hQX = false;
        int i = size - 1;
        for (int i2 = 0; i2 < size; i2++) {
            final View view = this.hQY.get(i);
            i--;
            com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.c.3
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(c.this.mContext.getPageActivity(), e.a.write_tab_icon_hide_anim);
                    loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.c.3.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            view.setVisibility(4);
                            if (c.this.hQV == 1) {
                                c.this.hQX = true;
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
        this.hQI.clearAnimation();
        this.hQF.clearAnimation();
        this.hQO.clearAnimation();
        this.hQL.clearAnimation();
    }

    public void onChangeSkinType() {
        al.j(this.hQD, e.d.cp_bg_line_d_alpha98);
        al.c(this.hQG, e.f.icon_post_type_photograph_n);
        al.c(this.hQJ, e.f.icon_post_type_text_n);
        al.c(this.hQM, e.f.icon_post_type_image_n);
        al.c(this.hQP, e.f.icon_post_type_live_n);
        al.c(this.hQR, e.f.icon_tabbar_add_s);
        al.h(this.hQH, e.d.cp_cont_b);
        al.h(this.hQK, e.d.cp_cont_b);
        al.h(this.hQN, e.d.cp_cont_b);
        al.h(this.hQQ, e.d.cp_cont_b);
    }

    public void onDestroy() {
        if (this.hQE != null && this.hQE.getParent() == this.mRootView) {
            this.mRootView.removeView(this.hQE);
        }
        if (this.hQT != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.hQT);
            this.hQT = null;
        }
        this.hQY.clear();
    }

    public boolean isShowing() {
        return this.hQU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xu(String str) {
        String str2;
        String str3;
        int i;
        String str4;
        int i2;
        String str5;
        String str6;
        bNd();
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.hIi == null) {
            str2 = "";
            str3 = "";
            i = 0;
            str4 = null;
            i2 = -1;
            str5 = null;
            str6 = "0";
        } else {
            String str7 = this.hIi.forumId;
            String str8 = this.hIi.forumName;
            postPrefixData = this.hIi.prefixData;
            antiData = this.hIi.antiData;
            int i3 = this.hIi.forumLevel;
            String str9 = this.hIi.avatar;
            int i4 = this.hIi.privateThread;
            String str10 = this.hIi.firstDir;
            str2 = this.hIi.secondDir;
            str3 = str10;
            i = i4;
            str4 = str9;
            i2 = i3;
            str5 = str8;
            str6 = str7;
        }
        TiebaStatic.log(new am("c12611").aA("obj_locate", this.hRe).x("obj_type", 1));
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
