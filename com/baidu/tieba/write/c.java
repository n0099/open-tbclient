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
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ForumWriteData;
import java.util.ArrayList;
import java.util.Calendar;
/* loaded from: classes.dex */
public class c {
    private int bgColor;
    private ForumWriteData hiU;
    private TextView hrA;
    private LinearLayout hrB;
    private TbImageView hrC;
    private TextView hrD;
    private LinearLayout hrE;
    private TbImageView hrF;
    private TextView hrG;
    private ImageView hrH;
    private GridLayout hrI;
    private a hrJ;
    private Animation hrQ;
    private Animation hrR;
    private Animation hrS;
    private Animation hrT;
    private com.baidu.tbadk.core.bigday.a hrV;
    private TbImageView hrW;
    private View hrX;
    private View hrt;
    private View hru;
    private LinearLayout hrv;
    private TbImageView hrw;
    private TextView hrx;
    private LinearLayout hry;
    private TbImageView hrz;
    private TbPageContext mContext;
    private String mFrom;
    private ViewGroup mRootView;
    private String writeCallFrom;
    private boolean hrK = false;
    private int hrL = 0;
    private boolean hrM = true;
    private boolean hrN = true;
    private ArrayList<View> hrO = new ArrayList<>();
    private String hrP = "";
    private String hrU = "0";

    static /* synthetic */ int v(c cVar) {
        int i = cVar.hrL;
        cVar.hrL = i + 1;
        return i;
    }

    static /* synthetic */ int x(c cVar) {
        int i = cVar.hrL;
        cVar.hrL = i - 1;
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

    public void vv(String str) {
        if (str == null) {
            str = "";
        }
        this.hrP = str;
    }

    public void a(ForumWriteData forumWriteData) {
        this.hiU = forumWriteData;
    }

    public void vw(String str) {
        if ("3".equals(str)) {
            this.writeCallFrom = "1";
        } else {
            this.writeCallFrom = str;
        }
        this.hrU = str;
    }

    private void initView() {
        if (this.mContext != null && this.mContext.getPageActivity() != null && this.mRootView != null) {
            this.hru = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.i.bottom_write_thread, (ViewGroup) null);
            this.hry = (LinearLayout) this.hru.findViewById(d.g.home_write_article);
            this.hrz = (TbImageView) this.hru.findViewById(d.g.home_write_article_icon);
            this.hrA = (TextView) this.hru.findViewById(d.g.home_write_article_title);
            this.hrv = (LinearLayout) this.hru.findViewById(d.g.home_write_photo);
            this.hrw = (TbImageView) this.hru.findViewById(d.g.home_write_photo_icon);
            this.hrx = (TextView) this.hru.findViewById(d.g.home_write_photo_title);
            this.hrB = (LinearLayout) this.hru.findViewById(d.g.home_write_album);
            this.hrC = (TbImageView) this.hru.findViewById(d.g.home_write_album_icon);
            this.hrD = (TextView) this.hru.findViewById(d.g.home_write_album_title);
            this.hrE = (LinearLayout) this.hru.findViewById(d.g.home_write_live);
            this.hrF = (TbImageView) this.hru.findViewById(d.g.home_write_live_icon);
            this.hrG = (TextView) this.hru.findViewById(d.g.home_write_live_title);
            this.hrH = (ImageView) this.hru.findViewById(d.g.write_close_view);
            this.hrt = this.hru.findViewById(d.g.view_background);
            this.hrI = (GridLayout) this.hru.findViewById(d.g.type_container);
            this.hrI.setMeasureAllChild(true);
            this.hrI.setVerNum(1);
            bGD();
            this.hrO.add(this.hry);
            this.hrO.add(this.hrv);
            this.hrO.add(this.hrB);
            this.hrO.add(this.hrE);
            this.hru.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.bgColor != 0) {
                        UtilHelper.setNavigationBarBackground(c.this.mContext.getPageActivity(), c.this.bgColor);
                    }
                    c.this.bF(c.this.hrI);
                }
            });
            this.hrz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.vx(c.this.hrP);
                }
            });
            this.hrw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.bGH();
                    TiebaStatic.log(new an("c12611").ah("obj_locate", c.this.hrU).r("obj_type", 2));
                    if (c.this.hiU == null) {
                        c.this.hiU = new ForumWriteData("0", null, null, null);
                    }
                    c.this.hiU.mFrom = c.this.mFrom;
                    c.this.hiU.writeCallFrom = c.this.writeCallFrom;
                    e.a(c.this.mContext, "", c.this.hiU);
                }
            });
            this.hrC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    String str2;
                    int i;
                    String str3;
                    int i2;
                    String str4;
                    String str5;
                    c.this.bGH();
                    PostPrefixData postPrefixData = null;
                    AntiData antiData = null;
                    if (c.this.hiU != null) {
                        String str6 = c.this.hiU.forumId;
                        String str7 = c.this.hiU.forumName;
                        postPrefixData = c.this.hiU.prefixData;
                        antiData = c.this.hiU.antiData;
                        int i3 = c.this.hiU.forumLevel;
                        String str8 = c.this.hiU.avatar;
                        int i4 = c.this.hiU.privateThread;
                        String str9 = c.this.hiU.firstDir;
                        str = c.this.hiU.secondDir;
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
                    TiebaStatic.log(new an("c12611").ah("obj_locate", c.this.hrU).r("obj_type", 3));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.mContext.getPageActivity(), 0, str5, str4, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", c.this.mFrom);
                    writeActivityConfig.setCallFrom(c.this.writeCallFrom);
                    writeActivityConfig.setForumLevel(i2);
                    writeActivityConfig.setForumAvatar(str3);
                    writeActivityConfig.setAlbumThread(1);
                    writeActivityConfig.setPrivateThread(i);
                    writeActivityConfig.setForumDir(str2, str);
                    if (!StringUtils.isNull(c.this.hrP)) {
                        writeActivityConfig.setTitle(c.this.hrP, true);
                    }
                    if (!c.I(c.this.mContext.getPageActivity())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                    }
                }
            });
            this.hrF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    String str2 = null;
                    c.this.bGH();
                    MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                    String str3 = "0";
                    com.baidu.adp.lib.d.a.hB().I(false);
                    if (c.this.hiU != null) {
                        str3 = c.this.hiU.forumId;
                        str = c.this.hiU.forumName;
                        str2 = c.this.hiU.specialForumType;
                    } else {
                        str = null;
                    }
                    TiebaStatic.log(new an("c12611").ah("obj_locate", c.this.hrU).r("obj_type", 4));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(TbadkCoreApplication.getInst().getApplicationContext(), str, str3, TbadkCoreApplication.getCurrentAccount(), str2)));
                }
            });
            onChangeSkinType();
            this.hrQ = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.write_thread_black_anim);
            this.hrQ.setFillAfter(true);
            this.hrR = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.write_thread_black_hide_anim);
            this.hrR.setFillAfter(true);
            this.hrS = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.write_tab_bg_anim);
            this.hrS.setFillAfter(true);
            this.hrT = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.home_write_bgout);
            this.hrT.setFillAfter(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean I(Activity activity) {
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.Aj();
        aVar.c(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return aVar.u(activity);
    }

    private void bGD() {
        int ah = (int) (0.15555556f * l.ah(this.mContext.getPageActivity()));
        a(this.hrz, ah);
        a(this.hrw, ah);
        a(this.hrC, ah);
        a(this.hrF, ah);
        int aj = l.aj(this.mContext.getPageActivity());
        ViewGroup.LayoutParams layoutParams = this.hrI.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = aj / 5;
            this.hrI.setLayoutParams(layoutParams);
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

    public void vl(int i) {
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
            c.this.hry.setVisibility(4);
            c.this.hrv.setVisibility(4);
            c.this.hrB.setVisibility(4);
            c.this.hrE.setVisibility(4);
            c.this.hrH.setVisibility(4);
            c.this.hrt.setVisibility(4);
            if (this.mView != null) {
                this.mView.setVisibility(8);
            }
            if (c.this.hru.getParent() == c.this.mRootView) {
                c.this.mRootView.removeView(c.this.hru);
            }
            c.this.hrK = false;
        }
    }

    private void bGE() {
        if (this.mFrom == "main_tab" && com.baidu.adp.lib.b.d.hv().aw("android_bigday_switch") != 0 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_write", 0L)) {
            this.hrV = com.baidu.tbadk.core.bigday.b.tJ().bB(3);
            if (this.hrV != null && this.hrV.tI()) {
                if (this.hrW == null) {
                    this.hrW = (TbImageView) this.hru.findViewById(d.g.write_tab_bigday_img);
                    this.hrW.startLoad(this.hrV.imgUrl, 41, false);
                    this.hrW.setVisibility(0);
                    this.hrW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.7
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (c.this.hrV != null && !StringUtils.isNULL(c.this.hrV.adc)) {
                                az.zV().c(c.this.mContext, new String[]{c.this.hrV.adc});
                                TiebaStatic.log(new an("c13114").f(VideoPlayActivityConfig.OBJ_ID, c.this.hrV.adf).ah("obj_to", c.this.hrV.adc));
                                c.this.bGH();
                            }
                        }
                    });
                    this.hrW.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.write.c.8
                        @Override // com.baidu.tbadk.widget.TbImageView.b
                        public void a(TbImageView tbImageView, Canvas canvas) {
                            if (c.this.hrW.getBdImage() == null && c.this.hrV != null && !ap.isEmpty(c.this.hrV.imgUrl)) {
                                c.this.hrW.startLoad(c.this.hrV.imgUrl, 41, false);
                            }
                        }

                        @Override // com.baidu.tbadk.widget.TbImageView.b
                        public void b(TbImageView tbImageView, Canvas canvas) {
                        }
                    });
                    ViewGroup.LayoutParams layoutParams = this.hrW.getLayoutParams();
                    if (layoutParams instanceof RelativeLayout.LayoutParams) {
                        int ah = (int) (l.ah(this.mContext.getContext()) * 0.546d);
                        layoutParams.width = ah;
                        layoutParams.height = ah;
                        ((RelativeLayout.LayoutParams) layoutParams).topMargin = l.aj(this.mContext.getContext()) / 5;
                        this.hrW.setLayoutParams(layoutParams);
                    }
                }
                if (this.hrX == null) {
                    this.hrX = this.hru.findViewById(d.g.write_tab_bigday_close);
                    this.hrX.setVisibility(0);
                    this.hrX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.9
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            c.this.hrX.clearAnimation();
                            c.this.hrW.clearAnimation();
                            c.this.hrX.setVisibility(8);
                            c.this.hrW.setVisibility(8);
                            Calendar calendar = Calendar.getInstance();
                            calendar.set(11, 23);
                            calendar.set(12, 59);
                            calendar.set(13, 59);
                            calendar.set(14, 0);
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_bigday_next_showtime_write", calendar.getTimeInMillis());
                        }
                    });
                }
                this.hrW.startAnimation(this.hrS);
                this.hrX.startAnimation(this.hrS);
                TiebaStatic.log(new an("c13113").f(VideoPlayActivityConfig.OBJ_ID, this.hrV.adf).ah("obj_to", this.hrV.adc));
            }
        }
    }

    public void nB(boolean z) {
        if (!this.hrK && this.hrM && this.hrN && this.mRootView != null) {
            bGE();
            this.hrH.clearAnimation();
            this.hrK = true;
            if (this.hru.getParent() == null) {
                com.baidu.tbadk.j.d.R(this.mRootView).a(this.mRootView, this.hru, z);
            }
            this.hrI.setVisibility(0);
            this.hrt.setVisibility(0);
            this.hrt.clearAnimation();
            this.hrt.startAnimation(this.hrS);
            this.hrH.setVisibility(0);
            this.hrH.startAnimation(this.hrQ);
            bGF();
            TiebaStatic.log(new an("c12052").ah("obj_locate", this.hrU));
            if (j.jF()) {
                String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_baidu_sim_card_writting_tip", "");
                if (!ap.isEmpty(string)) {
                    BdToast.a(this.mContext.getContext(), string).xv();
                    com.baidu.tbadk.core.sharedPref.b.getInstance().remove("key_baidu_sim_card_writting_tip");
                }
            }
        }
    }

    private void bGF() {
        clearAnimation();
        final int size = this.hrO.size();
        this.hrM = false;
        this.hrL = 0;
        for (int i = 0; i < size; i++) {
            final View view = this.hrO.get(i);
            com.baidu.adp.lib.g.e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.c.10
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
                            if (c.this.hrL == size) {
                                c.this.hrM = true;
                                c.this.hrL = 0;
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

    public void bGG() {
        bF(this.hrI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bF(View view) {
        if (this.hrM && this.hrN) {
            if (this.hrJ != null) {
                com.baidu.adp.lib.g.e.im().removeCallbacks(this.hrJ);
            }
            this.hrt.clearAnimation();
            this.hrt.startAnimation(this.hrT);
            if (this.hrX != null && this.hrW != null && this.hrX.getVisibility() == 0 && this.hrW.getVisibility() == 0) {
                this.hrX.clearAnimation();
                this.hrW.clearAnimation();
                this.hrW.startAnimation(this.hrT);
                this.hrX.startAnimation(this.hrT);
            }
            this.hrH.clearAnimation();
            this.hrH.startAnimation(this.hrR);
            bGI();
            this.hrJ = new a(view);
            com.baidu.adp.lib.g.e.im().postDelayed(this.hrJ, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGH() {
        this.hrM = true;
        this.hrN = true;
        if (this.hrJ != null) {
            com.baidu.adp.lib.g.e.im().removeCallbacks(this.hrJ);
        }
        if (this.hrJ == null) {
            this.hrJ = new a(this.hrI);
        }
        com.baidu.adp.lib.g.e.im().postDelayed(this.hrJ, 500L);
    }

    private void bGI() {
        clearAnimation();
        int size = this.hrO.size();
        this.hrL = size;
        this.hrN = false;
        int i = size - 1;
        for (int i2 = 0; i2 < size; i2++) {
            final View view = this.hrO.get(i);
            i--;
            com.baidu.adp.lib.g.e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.c.2
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
                            if (c.this.hrL == 1) {
                                c.this.hrN = true;
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
        this.hry.clearAnimation();
        this.hrv.clearAnimation();
        this.hrE.clearAnimation();
        this.hrB.clearAnimation();
    }

    public void onChangeSkinType() {
        am.j(this.hrt, d.C0142d.cp_bg_line_d_alpha98);
        am.c(this.hrw, d.f.icon_post_type_photograph_n);
        am.c(this.hrz, d.f.icon_post_type_text_n);
        am.c(this.hrC, d.f.icon_post_type_image_n);
        am.c(this.hrF, d.f.icon_post_type_live_n);
        am.c(this.hrH, d.f.icon_tabbar_add_s);
        am.h(this.hrx, d.C0142d.cp_cont_b);
        am.h(this.hrA, d.C0142d.cp_cont_b);
        am.h(this.hrD, d.C0142d.cp_cont_b);
        am.h(this.hrG, d.C0142d.cp_cont_b);
    }

    public void onDestroy() {
        if (this.hru != null && this.hru.getParent() == this.mRootView) {
            this.mRootView.removeView(this.hru);
        }
        if (this.hrJ != null) {
            com.baidu.adp.lib.g.e.im().removeCallbacks(this.hrJ);
            this.hrJ = null;
        }
        this.hrO.clear();
    }

    public boolean isShowing() {
        return this.hrK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vx(String str) {
        String str2;
        String str3;
        int i;
        String str4;
        int i2;
        String str5;
        String str6;
        bGH();
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.hiU == null) {
            str2 = "";
            str3 = "";
            i = 0;
            str4 = null;
            i2 = -1;
            str5 = null;
            str6 = "0";
        } else {
            String str7 = this.hiU.forumId;
            String str8 = this.hiU.forumName;
            postPrefixData = this.hiU.prefixData;
            antiData = this.hiU.antiData;
            int i3 = this.hiU.forumLevel;
            String str9 = this.hiU.avatar;
            int i4 = this.hiU.privateThread;
            String str10 = this.hiU.firstDir;
            str2 = this.hiU.secondDir;
            str3 = str10;
            i = i4;
            str4 = str9;
            i2 = i3;
            str5 = str8;
            str6 = str7;
        }
        TiebaStatic.log(new an("c12611").ah("obj_locate", this.hrU).r("obj_type", 1));
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
