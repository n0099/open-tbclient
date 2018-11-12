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
    private ForumWriteData hAW;
    private LinearLayout hJA;
    private TbImageView hJB;
    private TextView hJC;
    private LinearLayout hJD;
    private TbImageView hJE;
    private TextView hJF;
    private ImageView hJG;
    private GridLayout hJH;
    private a hJI;
    private Animation hJP;
    private Animation hJQ;
    private Animation hJR;
    private Animation hJS;
    private com.baidu.tbadk.core.bigday.a hJU;
    private TbImageView hJV;
    private View hJW;
    private View hJs;
    private View hJt;
    private LinearLayout hJu;
    private TbImageView hJv;
    private TextView hJw;
    private LinearLayout hJx;
    private TbImageView hJy;
    private TextView hJz;
    private TbPageContext mContext;
    private String mFrom;
    private ViewGroup mRootView;
    private String writeCallFrom;
    private boolean hJJ = false;
    private int hJK = 0;
    private boolean hJL = true;
    private boolean hJM = true;
    private ArrayList<View> hJN = new ArrayList<>();
    private String hJO = "";
    private String hJT = "0";

    static /* synthetic */ int v(c cVar) {
        int i = cVar.hJK;
        cVar.hJK = i + 1;
        return i;
    }

    static /* synthetic */ int x(c cVar) {
        int i = cVar.hJK;
        cVar.hJK = i - 1;
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

    public void wP(String str) {
        if (str == null) {
            str = "";
        }
        this.hJO = str;
    }

    public void a(ForumWriteData forumWriteData) {
        this.hAW = forumWriteData;
    }

    public void wQ(String str) {
        if ("3".equals(str)) {
            this.writeCallFrom = "1";
        } else {
            this.writeCallFrom = str;
        }
        this.hJT = str;
    }

    private void initView() {
        if (this.mContext != null && this.mContext.getPageActivity() != null && this.mRootView != null) {
            this.hJt = LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.bottom_write_thread, (ViewGroup) null);
            this.hJx = (LinearLayout) this.hJt.findViewById(e.g.home_write_article);
            this.hJy = (TbImageView) this.hJt.findViewById(e.g.home_write_article_icon);
            this.hJz = (TextView) this.hJt.findViewById(e.g.home_write_article_title);
            this.hJu = (LinearLayout) this.hJt.findViewById(e.g.home_write_photo);
            this.hJv = (TbImageView) this.hJt.findViewById(e.g.home_write_photo_icon);
            this.hJw = (TextView) this.hJt.findViewById(e.g.home_write_photo_title);
            this.hJA = (LinearLayout) this.hJt.findViewById(e.g.home_write_album);
            this.hJB = (TbImageView) this.hJt.findViewById(e.g.home_write_album_icon);
            this.hJC = (TextView) this.hJt.findViewById(e.g.home_write_album_title);
            this.hJD = (LinearLayout) this.hJt.findViewById(e.g.home_write_live);
            this.hJE = (TbImageView) this.hJt.findViewById(e.g.home_write_live_icon);
            this.hJF = (TextView) this.hJt.findViewById(e.g.home_write_live_title);
            this.hJG = (ImageView) this.hJt.findViewById(e.g.write_close_view);
            this.hJs = this.hJt.findViewById(e.g.view_background);
            this.hJH = (GridLayout) this.hJt.findViewById(e.g.type_container);
            this.hJH.setMeasureAllChild(true);
            this.hJH.setVerNum(1);
            bKU();
            this.hJN.add(this.hJx);
            this.hJN.add(this.hJu);
            this.hJN.add(this.hJA);
            this.hJN.add(this.hJD);
            this.hJt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.bgColor != 0) {
                        UtilHelper.setNavigationBarBackground(c.this.mContext.getPageActivity(), c.this.bgColor);
                    }
                    c.this.bX(c.this.hJH);
                }
            });
            this.hJy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.wR(c.this.hJO);
                }
            });
            this.hJv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.bKX();
                    TiebaStatic.log(new am("c12611").ax("obj_locate", c.this.hJT).x("obj_type", 2));
                    if (c.this.hAW == null) {
                        c.this.hAW = new ForumWriteData("0", null, null, null);
                    }
                    c.this.hAW.mFrom = c.this.mFrom;
                    c.this.hAW.writeCallFrom = c.this.writeCallFrom;
                    e.a(c.this.mContext, "", c.this.hAW);
                }
            });
            this.hJB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    String str2;
                    int i;
                    String str3;
                    int i2;
                    String str4;
                    String str5;
                    c.this.bKX();
                    PostPrefixData postPrefixData = null;
                    AntiData antiData = null;
                    if (c.this.hAW != null) {
                        String str6 = c.this.hAW.forumId;
                        String str7 = c.this.hAW.forumName;
                        postPrefixData = c.this.hAW.prefixData;
                        antiData = c.this.hAW.antiData;
                        int i3 = c.this.hAW.forumLevel;
                        String str8 = c.this.hAW.avatar;
                        int i4 = c.this.hAW.privateThread;
                        String str9 = c.this.hAW.firstDir;
                        str = c.this.hAW.secondDir;
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
                    TiebaStatic.log(new am("c12611").ax("obj_locate", c.this.hJT).x("obj_type", 3));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.mContext.getPageActivity(), 0, str5, str4, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", c.this.mFrom);
                    writeActivityConfig.setCallFrom(c.this.writeCallFrom);
                    writeActivityConfig.setForumLevel(i2);
                    writeActivityConfig.setForumAvatar(str3);
                    writeActivityConfig.setAlbumThread(1);
                    writeActivityConfig.setPrivateThread(i);
                    writeActivityConfig.setForumDir(str2, str);
                    if (!StringUtils.isNull(c.this.hJO)) {
                        writeActivityConfig.setTitle(c.this.hJO, true);
                    }
                    if (!c.a(c.this.mContext.getPageActivity(), writeActivityConfig)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                    }
                }
            });
            this.hJE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    String str2 = null;
                    c.this.bKX();
                    if (Build.VERSION.SDK_INT < 21) {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(c.this.mContext.getPageActivity());
                        aVar.setAutoNight(false);
                        aVar.cM(e.j.prompt);
                        aVar.ej(c.this.mContext.getResources().getString(e.j.disallow_open_live_by_android_v5_0));
                        aVar.bl(true);
                        aVar.bk(true);
                        aVar.a(e.j.know, new a.b() { // from class: com.baidu.tieba.write.c.7.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                            }
                        });
                        aVar.b(c.this.mContext).AB();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                    String str3 = "0";
                    com.baidu.adp.lib.d.a.iW().af(false);
                    if (c.this.hAW != null) {
                        str3 = c.this.hAW.forumId;
                        str = c.this.hAW.forumName;
                        str2 = c.this.hAW.specialForumType;
                    } else {
                        str = null;
                    }
                    TiebaStatic.log(new am("c12611").ax("obj_locate", c.this.hJT).x("obj_type", 4));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(TbadkCoreApplication.getInst().getApplicationContext(), str, str3, TbadkCoreApplication.getCurrentAccount(), str2)));
                }
            });
            onChangeSkinType();
            this.hJP = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.write_thread_black_anim);
            this.hJP.setFillAfter(true);
            this.hJQ = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.write_thread_black_hide_anim);
            this.hJQ.setFillAfter(true);
            this.hJR = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.write_tab_bg_anim);
            this.hJR.setFillAfter(true);
            this.hJS = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.home_write_bgout);
            this.hJS.setFillAfter(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(Activity activity, final WriteActivityConfig writeActivityConfig) {
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.Dp();
        aVar.c(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
        aVar.a(new a.InterfaceC0150a() { // from class: com.baidu.tieba.write.c.8
            @Override // com.baidu.tbadk.core.util.b.a.InterfaceC0150a
            public void Dq() {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, WriteActivityConfig.this));
            }
        });
        return aVar.A(activity);
    }

    private void bKU() {
        int aO = (int) (0.15555556f * l.aO(this.mContext.getPageActivity()));
        a(this.hJy, aO);
        a(this.hJv, aO);
        a(this.hJB, aO);
        a(this.hJE, aO);
        int aQ = l.aQ(this.mContext.getPageActivity());
        ViewGroup.LayoutParams layoutParams = this.hJH.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = aQ / 5;
            this.hJH.setLayoutParams(layoutParams);
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

    public void wA(int i) {
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
            c.this.hJx.setVisibility(4);
            c.this.hJu.setVisibility(4);
            c.this.hJA.setVisibility(4);
            c.this.hJD.setVisibility(4);
            c.this.hJG.setVisibility(4);
            c.this.hJs.setVisibility(4);
            if (this.mView != null) {
                this.mView.setVisibility(8);
            }
            if (c.this.hJt.getParent() == c.this.mRootView) {
                c.this.mRootView.removeView(c.this.hJt);
            }
            c.this.hJJ = false;
        }
    }

    private void bKV() {
        if (this.mFrom == "main_tab" && com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") != 0 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_write", 0L)) {
            this.hJU = com.baidu.tbadk.core.bigday.b.wO().cm(3);
            if (this.hJU != null && this.hJU.wN()) {
                if (this.hJV == null) {
                    this.hJV = (TbImageView) this.hJt.findViewById(e.g.write_tab_bigday_img);
                    this.hJV.startLoad(this.hJU.imgUrl, 41, false);
                    this.hJV.setVisibility(0);
                    this.hJV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.9
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (c.this.hJU != null && !StringUtils.isNULL(c.this.hJU.akS)) {
                                ay.Db().c(c.this.mContext, new String[]{c.this.hJU.akS});
                                TiebaStatic.log(new am("c13114").h(VideoPlayActivityConfig.OBJ_ID, c.this.hJU.akU).ax("obj_to", c.this.hJU.akS));
                                c.this.bKX();
                            }
                        }
                    });
                    this.hJV.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.write.c.10
                        @Override // com.baidu.tbadk.widget.TbImageView.b
                        public void a(TbImageView tbImageView, Canvas canvas) {
                            if (c.this.hJV.getBdImage() == null && c.this.hJU != null && !ao.isEmpty(c.this.hJU.imgUrl)) {
                                c.this.hJV.startLoad(c.this.hJU.imgUrl, 41, false);
                            }
                        }

                        @Override // com.baidu.tbadk.widget.TbImageView.b
                        public void b(TbImageView tbImageView, Canvas canvas) {
                        }
                    });
                    ViewGroup.LayoutParams layoutParams = this.hJV.getLayoutParams();
                    if (layoutParams instanceof RelativeLayout.LayoutParams) {
                        int aO = (int) (l.aO(this.mContext.getContext()) * 0.546d);
                        layoutParams.width = aO;
                        layoutParams.height = aO;
                        ((RelativeLayout.LayoutParams) layoutParams).topMargin = l.aQ(this.mContext.getContext()) / 5;
                        this.hJV.setLayoutParams(layoutParams);
                    }
                }
                if (this.hJW == null) {
                    this.hJW = this.hJt.findViewById(e.g.write_tab_bigday_close);
                    this.hJW.setVisibility(0);
                    this.hJW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.11
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            c.this.hJW.clearAnimation();
                            c.this.hJV.clearAnimation();
                            c.this.hJW.setVisibility(8);
                            c.this.hJV.setVisibility(8);
                            Calendar calendar = Calendar.getInstance();
                            calendar.set(11, 23);
                            calendar.set(12, 59);
                            calendar.set(13, 59);
                            calendar.set(14, 0);
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_bigday_next_showtime_write", calendar.getTimeInMillis());
                        }
                    });
                }
                this.hJV.startAnimation(this.hJR);
                this.hJW.startAnimation(this.hJR);
                TiebaStatic.log(new am("c13113").h(VideoPlayActivityConfig.OBJ_ID, this.hJU.akU).ax("obj_to", this.hJU.akS));
            }
        }
    }

    public void oq(boolean z) {
        if (!this.hJJ && this.hJL && this.hJM && this.mRootView != null) {
            bKV();
            this.hJG.clearAnimation();
            this.hJJ = true;
            if (this.hJt.getParent() == null) {
                com.baidu.tbadk.k.d.ad(this.mRootView).a(this.mRootView, this.hJt, z);
            }
            this.hJH.setVisibility(0);
            this.hJs.setVisibility(0);
            this.hJs.clearAnimation();
            this.hJs.startAnimation(this.hJR);
            this.hJG.setVisibility(0);
            this.hJG.startAnimation(this.hJP);
            bKW();
            TiebaStatic.log(new am("c12052").ax("obj_locate", this.hJT));
            if (j.kX()) {
                String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_baidu_sim_card_writting_tip", "");
                if (!ao.isEmpty(string)) {
                    BdToast.a(this.mContext.getContext(), string).AJ();
                    com.baidu.tbadk.core.sharedPref.b.getInstance().remove("key_baidu_sim_card_writting_tip");
                }
            }
        }
    }

    private void bKW() {
        clearAnimation();
        final int size = this.hJN.size();
        this.hJL = false;
        this.hJK = 0;
        for (int i = 0; i < size; i++) {
            final View view = this.hJN.get(i);
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
                            if (c.this.hJK == size) {
                                c.this.hJL = true;
                                c.this.hJK = 0;
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

    public void aAG() {
        bX(this.hJH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bX(View view) {
        if (this.hJL && this.hJM) {
            if (this.hJI != null) {
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.hJI);
            }
            this.hJs.clearAnimation();
            this.hJs.startAnimation(this.hJS);
            if (this.hJW != null && this.hJV != null && this.hJW.getVisibility() == 0 && this.hJV.getVisibility() == 0) {
                this.hJW.clearAnimation();
                this.hJV.clearAnimation();
                this.hJV.startAnimation(this.hJS);
                this.hJW.startAnimation(this.hJS);
            }
            this.hJG.clearAnimation();
            this.hJG.startAnimation(this.hJQ);
            bKY();
            this.hJI = new a(view);
            com.baidu.adp.lib.g.e.jG().postDelayed(this.hJI, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKX() {
        this.hJL = true;
        this.hJM = true;
        if (this.hJI != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.hJI);
        }
        if (this.hJI == null) {
            this.hJI = new a(this.hJH);
        }
        com.baidu.adp.lib.g.e.jG().postDelayed(this.hJI, 500L);
    }

    private void bKY() {
        clearAnimation();
        int size = this.hJN.size();
        this.hJK = size;
        this.hJM = false;
        int i = size - 1;
        for (int i2 = 0; i2 < size; i2++) {
            final View view = this.hJN.get(i);
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
                            if (c.this.hJK == 1) {
                                c.this.hJM = true;
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
        this.hJx.clearAnimation();
        this.hJu.clearAnimation();
        this.hJD.clearAnimation();
        this.hJA.clearAnimation();
    }

    public void onChangeSkinType() {
        al.j(this.hJs, e.d.cp_bg_line_d_alpha98);
        al.c(this.hJv, e.f.icon_post_type_photograph_n);
        al.c(this.hJy, e.f.icon_post_type_text_n);
        al.c(this.hJB, e.f.icon_post_type_image_n);
        al.c(this.hJE, e.f.icon_post_type_live_n);
        al.c(this.hJG, e.f.icon_tabbar_add_s);
        al.h(this.hJw, e.d.cp_cont_b);
        al.h(this.hJz, e.d.cp_cont_b);
        al.h(this.hJC, e.d.cp_cont_b);
        al.h(this.hJF, e.d.cp_cont_b);
    }

    public void onDestroy() {
        if (this.hJt != null && this.hJt.getParent() == this.mRootView) {
            this.mRootView.removeView(this.hJt);
        }
        if (this.hJI != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.hJI);
            this.hJI = null;
        }
        this.hJN.clear();
    }

    public boolean isShowing() {
        return this.hJJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wR(String str) {
        String str2;
        String str3;
        int i;
        String str4;
        int i2;
        String str5;
        String str6;
        bKX();
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.hAW == null) {
            str2 = "";
            str3 = "";
            i = 0;
            str4 = null;
            i2 = -1;
            str5 = null;
            str6 = "0";
        } else {
            String str7 = this.hAW.forumId;
            String str8 = this.hAW.forumName;
            postPrefixData = this.hAW.prefixData;
            antiData = this.hAW.antiData;
            int i3 = this.hAW.forumLevel;
            String str9 = this.hAW.avatar;
            int i4 = this.hAW.privateThread;
            String str10 = this.hAW.firstDir;
            str2 = this.hAW.secondDir;
            str3 = str10;
            i = i4;
            str4 = str9;
            i2 = i3;
            str5 = str8;
            str6 = str7;
        }
        TiebaStatic.log(new am("c12611").ax("obj_locate", this.hJT).x("obj_type", 1));
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
