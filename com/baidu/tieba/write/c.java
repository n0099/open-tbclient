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
    private TextView hAA;
    private LinearLayout hAB;
    private TbImageView hAC;
    private TextView hAD;
    private LinearLayout hAE;
    private TbImageView hAF;
    private TextView hAG;
    private LinearLayout hAH;
    private TbImageView hAI;
    private TextView hAJ;
    private ImageView hAK;
    private GridLayout hAL;
    private a hAM;
    private Animation hAT;
    private Animation hAU;
    private Animation hAV;
    private Animation hAW;
    private com.baidu.tbadk.core.bigday.a hAY;
    private TbImageView hAZ;
    private View hAw;
    private View hAx;
    private LinearLayout hAy;
    private TbImageView hAz;
    private View hBa;
    private ForumWriteData hrY;
    private TbPageContext mContext;
    private String mFrom;
    private ViewGroup mRootView;
    private String writeCallFrom;
    private boolean hAN = false;
    private int hAO = 0;
    private boolean hAP = true;
    private boolean hAQ = true;
    private ArrayList<View> hAR = new ArrayList<>();
    private String hAS = "";
    private String hAX = "0";

    static /* synthetic */ int v(c cVar) {
        int i = cVar.hAO;
        cVar.hAO = i + 1;
        return i;
    }

    static /* synthetic */ int x(c cVar) {
        int i = cVar.hAO;
        cVar.hAO = i - 1;
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

    public void wj(String str) {
        if (str == null) {
            str = "";
        }
        this.hAS = str;
    }

    public void a(ForumWriteData forumWriteData) {
        this.hrY = forumWriteData;
    }

    public void wk(String str) {
        if ("3".equals(str)) {
            this.writeCallFrom = "1";
        } else {
            this.writeCallFrom = str;
        }
        this.hAX = str;
    }

    private void initView() {
        if (this.mContext != null && this.mContext.getPageActivity() != null && this.mRootView != null) {
            this.hAx = LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.bottom_write_thread, (ViewGroup) null);
            this.hAB = (LinearLayout) this.hAx.findViewById(e.g.home_write_article);
            this.hAC = (TbImageView) this.hAx.findViewById(e.g.home_write_article_icon);
            this.hAD = (TextView) this.hAx.findViewById(e.g.home_write_article_title);
            this.hAy = (LinearLayout) this.hAx.findViewById(e.g.home_write_photo);
            this.hAz = (TbImageView) this.hAx.findViewById(e.g.home_write_photo_icon);
            this.hAA = (TextView) this.hAx.findViewById(e.g.home_write_photo_title);
            this.hAE = (LinearLayout) this.hAx.findViewById(e.g.home_write_album);
            this.hAF = (TbImageView) this.hAx.findViewById(e.g.home_write_album_icon);
            this.hAG = (TextView) this.hAx.findViewById(e.g.home_write_album_title);
            this.hAH = (LinearLayout) this.hAx.findViewById(e.g.home_write_live);
            this.hAI = (TbImageView) this.hAx.findViewById(e.g.home_write_live_icon);
            this.hAJ = (TextView) this.hAx.findViewById(e.g.home_write_live_title);
            this.hAK = (ImageView) this.hAx.findViewById(e.g.write_close_view);
            this.hAw = this.hAx.findViewById(e.g.view_background);
            this.hAL = (GridLayout) this.hAx.findViewById(e.g.type_container);
            this.hAL.setMeasureAllChild(true);
            this.hAL.setVerNum(1);
            bIj();
            this.hAR.add(this.hAB);
            this.hAR.add(this.hAy);
            this.hAR.add(this.hAE);
            this.hAR.add(this.hAH);
            this.hAx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.bgColor != 0) {
                        UtilHelper.setNavigationBarBackground(c.this.mContext.getPageActivity(), c.this.bgColor);
                    }
                    c.this.bV(c.this.hAL);
                }
            });
            this.hAC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.wl(c.this.hAS);
                }
            });
            this.hAz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.bIm();
                    TiebaStatic.log(new am("c12611").al("obj_locate", c.this.hAX).w("obj_type", 2));
                    if (c.this.hrY == null) {
                        c.this.hrY = new ForumWriteData("0", null, null, null);
                    }
                    c.this.hrY.mFrom = c.this.mFrom;
                    c.this.hrY.writeCallFrom = c.this.writeCallFrom;
                    e.a(c.this.mContext, "", c.this.hrY);
                }
            });
            this.hAF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    String str2;
                    int i;
                    String str3;
                    int i2;
                    String str4;
                    String str5;
                    c.this.bIm();
                    PostPrefixData postPrefixData = null;
                    AntiData antiData = null;
                    if (c.this.hrY != null) {
                        String str6 = c.this.hrY.forumId;
                        String str7 = c.this.hrY.forumName;
                        postPrefixData = c.this.hrY.prefixData;
                        antiData = c.this.hrY.antiData;
                        int i3 = c.this.hrY.forumLevel;
                        String str8 = c.this.hrY.avatar;
                        int i4 = c.this.hrY.privateThread;
                        String str9 = c.this.hrY.firstDir;
                        str = c.this.hrY.secondDir;
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
                    TiebaStatic.log(new am("c12611").al("obj_locate", c.this.hAX).w("obj_type", 3));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.mContext.getPageActivity(), 0, str5, str4, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", c.this.mFrom);
                    writeActivityConfig.setCallFrom(c.this.writeCallFrom);
                    writeActivityConfig.setForumLevel(i2);
                    writeActivityConfig.setForumAvatar(str3);
                    writeActivityConfig.setAlbumThread(1);
                    writeActivityConfig.setPrivateThread(i);
                    writeActivityConfig.setForumDir(str2, str);
                    if (!StringUtils.isNull(c.this.hAS)) {
                        writeActivityConfig.setTitle(c.this.hAS, true);
                    }
                    if (!c.a(c.this.mContext.getPageActivity(), writeActivityConfig)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                    }
                }
            });
            this.hAI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    String str2 = null;
                    c.this.bIm();
                    MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                    String str3 = "0";
                    com.baidu.adp.lib.d.a.iH().R(false);
                    if (c.this.hrY != null) {
                        str3 = c.this.hrY.forumId;
                        str = c.this.hrY.forumName;
                        str2 = c.this.hrY.specialForumType;
                    } else {
                        str = null;
                    }
                    TiebaStatic.log(new am("c12611").al("obj_locate", c.this.hAX).w("obj_type", 4));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(TbadkCoreApplication.getInst().getApplicationContext(), str, str3, TbadkCoreApplication.getCurrentAccount(), str2)));
                }
            });
            onChangeSkinType();
            this.hAT = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.write_thread_black_anim);
            this.hAT.setFillAfter(true);
            this.hAU = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.write_thread_black_hide_anim);
            this.hAU.setFillAfter(true);
            this.hAV = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.write_tab_bg_anim);
            this.hAV.setFillAfter(true);
            this.hAW = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.home_write_bgout);
            this.hAW.setFillAfter(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(Activity activity, final WriteActivityConfig writeActivityConfig) {
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.Bb();
        aVar.c(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
        aVar.a(new a.InterfaceC0102a() { // from class: com.baidu.tieba.write.c.8
            @Override // com.baidu.tbadk.core.util.b.a.InterfaceC0102a
            public void Bc() {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, WriteActivityConfig.this));
            }
        });
        return aVar.x(activity);
    }

    private void bIj() {
        int aO = (int) (0.15555556f * l.aO(this.mContext.getPageActivity()));
        a(this.hAC, aO);
        a(this.hAz, aO);
        a(this.hAF, aO);
        a(this.hAI, aO);
        int aQ = l.aQ(this.mContext.getPageActivity());
        ViewGroup.LayoutParams layoutParams = this.hAL.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = aQ / 5;
            this.hAL.setLayoutParams(layoutParams);
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

    public void vK(int i) {
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
            c.this.hAB.setVisibility(4);
            c.this.hAy.setVisibility(4);
            c.this.hAE.setVisibility(4);
            c.this.hAH.setVisibility(4);
            c.this.hAK.setVisibility(4);
            c.this.hAw.setVisibility(4);
            if (this.mView != null) {
                this.mView.setVisibility(8);
            }
            if (c.this.hAx.getParent() == c.this.mRootView) {
                c.this.mRootView.removeView(c.this.hAx);
            }
            c.this.hAN = false;
        }
    }

    private void bIk() {
        if (this.mFrom == "main_tab" && com.baidu.adp.lib.b.d.iB().aO("android_bigday_switch") != 0 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_write", 0L)) {
            this.hAY = com.baidu.tbadk.core.bigday.b.ux().bM(3);
            if (this.hAY != null && this.hAY.uw()) {
                if (this.hAZ == null) {
                    this.hAZ = (TbImageView) this.hAx.findViewById(e.g.write_tab_bigday_img);
                    this.hAZ.startLoad(this.hAY.imgUrl, 41, false);
                    this.hAZ.setVisibility(0);
                    this.hAZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.9
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (c.this.hAY != null && !StringUtils.isNULL(c.this.hAY.afi)) {
                                ay.AN().c(c.this.mContext, new String[]{c.this.hAY.afi});
                                TiebaStatic.log(new am("c13114").g(VideoPlayActivityConfig.OBJ_ID, c.this.hAY.afk).al("obj_to", c.this.hAY.afi));
                                c.this.bIm();
                            }
                        }
                    });
                    this.hAZ.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.write.c.10
                        @Override // com.baidu.tbadk.widget.TbImageView.b
                        public void a(TbImageView tbImageView, Canvas canvas) {
                            if (c.this.hAZ.getBdImage() == null && c.this.hAY != null && !ao.isEmpty(c.this.hAY.imgUrl)) {
                                c.this.hAZ.startLoad(c.this.hAY.imgUrl, 41, false);
                            }
                        }

                        @Override // com.baidu.tbadk.widget.TbImageView.b
                        public void b(TbImageView tbImageView, Canvas canvas) {
                        }
                    });
                    ViewGroup.LayoutParams layoutParams = this.hAZ.getLayoutParams();
                    if (layoutParams instanceof RelativeLayout.LayoutParams) {
                        int aO = (int) (l.aO(this.mContext.getContext()) * 0.546d);
                        layoutParams.width = aO;
                        layoutParams.height = aO;
                        ((RelativeLayout.LayoutParams) layoutParams).topMargin = l.aQ(this.mContext.getContext()) / 5;
                        this.hAZ.setLayoutParams(layoutParams);
                    }
                }
                if (this.hBa == null) {
                    this.hBa = this.hAx.findViewById(e.g.write_tab_bigday_close);
                    this.hBa.setVisibility(0);
                    this.hBa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.11
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            c.this.hBa.clearAnimation();
                            c.this.hAZ.clearAnimation();
                            c.this.hBa.setVisibility(8);
                            c.this.hAZ.setVisibility(8);
                            Calendar calendar = Calendar.getInstance();
                            calendar.set(11, 23);
                            calendar.set(12, 59);
                            calendar.set(13, 59);
                            calendar.set(14, 0);
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_bigday_next_showtime_write", calendar.getTimeInMillis());
                        }
                    });
                }
                this.hAZ.startAnimation(this.hAV);
                this.hBa.startAnimation(this.hAV);
                TiebaStatic.log(new am("c13113").g(VideoPlayActivityConfig.OBJ_ID, this.hAY.afk).al("obj_to", this.hAY.afi));
            }
        }
    }

    public void nM(boolean z) {
        if (!this.hAN && this.hAP && this.hAQ && this.mRootView != null) {
            bIk();
            this.hAK.clearAnimation();
            this.hAN = true;
            if (this.hAx.getParent() == null) {
                com.baidu.tbadk.k.d.ae(this.mRootView).a(this.mRootView, this.hAx, z);
            }
            this.hAL.setVisibility(0);
            this.hAw.setVisibility(0);
            this.hAw.clearAnimation();
            this.hAw.startAnimation(this.hAV);
            this.hAK.setVisibility(0);
            this.hAK.startAnimation(this.hAT);
            bIl();
            TiebaStatic.log(new am("c12052").al("obj_locate", this.hAX));
            if (j.kM()) {
                String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_baidu_sim_card_writting_tip", "");
                if (!ao.isEmpty(string)) {
                    BdToast.a(this.mContext.getContext(), string).yt();
                    com.baidu.tbadk.core.sharedPref.b.getInstance().remove("key_baidu_sim_card_writting_tip");
                }
            }
        }
    }

    private void bIl() {
        clearAnimation();
        final int size = this.hAR.size();
        this.hAP = false;
        this.hAO = 0;
        for (int i = 0; i < size; i++) {
            final View view = this.hAR.get(i);
            com.baidu.adp.lib.g.e.jt().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.c.2
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
                            if (c.this.hAO == size) {
                                c.this.hAP = true;
                                c.this.hAO = 0;
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

    public void axN() {
        bV(this.hAL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bV(View view) {
        if (this.hAP && this.hAQ) {
            if (this.hAM != null) {
                com.baidu.adp.lib.g.e.jt().removeCallbacks(this.hAM);
            }
            this.hAw.clearAnimation();
            this.hAw.startAnimation(this.hAW);
            if (this.hBa != null && this.hAZ != null && this.hBa.getVisibility() == 0 && this.hAZ.getVisibility() == 0) {
                this.hBa.clearAnimation();
                this.hAZ.clearAnimation();
                this.hAZ.startAnimation(this.hAW);
                this.hBa.startAnimation(this.hAW);
            }
            this.hAK.clearAnimation();
            this.hAK.startAnimation(this.hAU);
            bIn();
            this.hAM = new a(view);
            com.baidu.adp.lib.g.e.jt().postDelayed(this.hAM, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIm() {
        this.hAP = true;
        this.hAQ = true;
        if (this.hAM != null) {
            com.baidu.adp.lib.g.e.jt().removeCallbacks(this.hAM);
        }
        if (this.hAM == null) {
            this.hAM = new a(this.hAL);
        }
        com.baidu.adp.lib.g.e.jt().postDelayed(this.hAM, 500L);
    }

    private void bIn() {
        clearAnimation();
        int size = this.hAR.size();
        this.hAO = size;
        this.hAQ = false;
        int i = size - 1;
        for (int i2 = 0; i2 < size; i2++) {
            final View view = this.hAR.get(i);
            i--;
            com.baidu.adp.lib.g.e.jt().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.c.3
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
                            if (c.this.hAO == 1) {
                                c.this.hAQ = true;
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
        this.hAB.clearAnimation();
        this.hAy.clearAnimation();
        this.hAH.clearAnimation();
        this.hAE.clearAnimation();
    }

    public void onChangeSkinType() {
        al.j(this.hAw, e.d.cp_bg_line_d_alpha98);
        al.c(this.hAz, e.f.icon_post_type_photograph_n);
        al.c(this.hAC, e.f.icon_post_type_text_n);
        al.c(this.hAF, e.f.icon_post_type_image_n);
        al.c(this.hAI, e.f.icon_post_type_live_n);
        al.c(this.hAK, e.f.icon_tabbar_add_s);
        al.h(this.hAA, e.d.cp_cont_b);
        al.h(this.hAD, e.d.cp_cont_b);
        al.h(this.hAG, e.d.cp_cont_b);
        al.h(this.hAJ, e.d.cp_cont_b);
    }

    public void onDestroy() {
        if (this.hAx != null && this.hAx.getParent() == this.mRootView) {
            this.mRootView.removeView(this.hAx);
        }
        if (this.hAM != null) {
            com.baidu.adp.lib.g.e.jt().removeCallbacks(this.hAM);
            this.hAM = null;
        }
        this.hAR.clear();
    }

    public boolean isShowing() {
        return this.hAN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wl(String str) {
        String str2;
        String str3;
        int i;
        String str4;
        int i2;
        String str5;
        String str6;
        bIm();
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.hrY == null) {
            str2 = "";
            str3 = "";
            i = 0;
            str4 = null;
            i2 = -1;
            str5 = null;
            str6 = "0";
        } else {
            String str7 = this.hrY.forumId;
            String str8 = this.hrY.forumName;
            postPrefixData = this.hrY.prefixData;
            antiData = this.hrY.antiData;
            int i3 = this.hrY.forumLevel;
            String str9 = this.hrY.avatar;
            int i4 = this.hrY.privateThread;
            String str10 = this.hrY.firstDir;
            str2 = this.hrY.secondDir;
            str3 = str10;
            i = i4;
            str4 = str9;
            i2 = i3;
            str5 = str8;
            str6 = str7;
        }
        TiebaStatic.log(new am("c12611").al("obj_locate", this.hAX).w("obj_type", 1));
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
