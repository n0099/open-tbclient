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
    private View hHJ;
    private View hHK;
    private LinearLayout hHL;
    private TbImageView hHM;
    private TextView hHN;
    private LinearLayout hHO;
    private TbImageView hHP;
    private TextView hHQ;
    private LinearLayout hHR;
    private TbImageView hHS;
    private TextView hHT;
    private LinearLayout hHU;
    private TbImageView hHV;
    private TextView hHW;
    private ImageView hHX;
    private GridLayout hHY;
    private a hHZ;
    private Animation hIg;
    private Animation hIh;
    private Animation hIi;
    private Animation hIj;
    private com.baidu.tbadk.core.bigday.a hIl;
    private TbImageView hIm;
    private View hIn;
    private ForumWriteData hzm;
    private TbPageContext mContext;
    private String mFrom;
    private ViewGroup mRootView;
    private String writeCallFrom;
    private boolean hIa = false;
    private int hIb = 0;
    private boolean hIc = true;
    private boolean hId = true;
    private ArrayList<View> hIe = new ArrayList<>();
    private String hIf = "";
    private String hIk = "0";

    static /* synthetic */ int v(c cVar) {
        int i = cVar.hIb;
        cVar.hIb = i + 1;
        return i;
    }

    static /* synthetic */ int x(c cVar) {
        int i = cVar.hIb;
        cVar.hIb = i - 1;
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

    public void wK(String str) {
        if (str == null) {
            str = "";
        }
        this.hIf = str;
    }

    public void a(ForumWriteData forumWriteData) {
        this.hzm = forumWriteData;
    }

    public void wL(String str) {
        if ("3".equals(str)) {
            this.writeCallFrom = "1";
        } else {
            this.writeCallFrom = str;
        }
        this.hIk = str;
    }

    private void initView() {
        if (this.mContext != null && this.mContext.getPageActivity() != null && this.mRootView != null) {
            this.hHK = LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.bottom_write_thread, (ViewGroup) null);
            this.hHO = (LinearLayout) this.hHK.findViewById(e.g.home_write_article);
            this.hHP = (TbImageView) this.hHK.findViewById(e.g.home_write_article_icon);
            this.hHQ = (TextView) this.hHK.findViewById(e.g.home_write_article_title);
            this.hHL = (LinearLayout) this.hHK.findViewById(e.g.home_write_photo);
            this.hHM = (TbImageView) this.hHK.findViewById(e.g.home_write_photo_icon);
            this.hHN = (TextView) this.hHK.findViewById(e.g.home_write_photo_title);
            this.hHR = (LinearLayout) this.hHK.findViewById(e.g.home_write_album);
            this.hHS = (TbImageView) this.hHK.findViewById(e.g.home_write_album_icon);
            this.hHT = (TextView) this.hHK.findViewById(e.g.home_write_album_title);
            this.hHU = (LinearLayout) this.hHK.findViewById(e.g.home_write_live);
            this.hHV = (TbImageView) this.hHK.findViewById(e.g.home_write_live_icon);
            this.hHW = (TextView) this.hHK.findViewById(e.g.home_write_live_title);
            this.hHX = (ImageView) this.hHK.findViewById(e.g.write_close_view);
            this.hHJ = this.hHK.findViewById(e.g.view_background);
            this.hHY = (GridLayout) this.hHK.findViewById(e.g.type_container);
            this.hHY.setMeasureAllChild(true);
            this.hHY.setVerNum(1);
            bLv();
            this.hIe.add(this.hHO);
            this.hIe.add(this.hHL);
            this.hIe.add(this.hHR);
            this.hIe.add(this.hHU);
            this.hHK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.bgColor != 0) {
                        UtilHelper.setNavigationBarBackground(c.this.mContext.getPageActivity(), c.this.bgColor);
                    }
                    c.this.bV(c.this.hHY);
                }
            });
            this.hHP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.wM(c.this.hIf);
                }
            });
            this.hHM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.bLy();
                    TiebaStatic.log(new am("c12611").ax("obj_locate", c.this.hIk).x("obj_type", 2));
                    if (c.this.hzm == null) {
                        c.this.hzm = new ForumWriteData("0", null, null, null);
                    }
                    c.this.hzm.mFrom = c.this.mFrom;
                    c.this.hzm.writeCallFrom = c.this.writeCallFrom;
                    e.a(c.this.mContext, "", c.this.hzm);
                }
            });
            this.hHS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    String str2;
                    int i;
                    String str3;
                    int i2;
                    String str4;
                    String str5;
                    c.this.bLy();
                    PostPrefixData postPrefixData = null;
                    AntiData antiData = null;
                    if (c.this.hzm != null) {
                        String str6 = c.this.hzm.forumId;
                        String str7 = c.this.hzm.forumName;
                        postPrefixData = c.this.hzm.prefixData;
                        antiData = c.this.hzm.antiData;
                        int i3 = c.this.hzm.forumLevel;
                        String str8 = c.this.hzm.avatar;
                        int i4 = c.this.hzm.privateThread;
                        String str9 = c.this.hzm.firstDir;
                        str = c.this.hzm.secondDir;
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
                    TiebaStatic.log(new am("c12611").ax("obj_locate", c.this.hIk).x("obj_type", 3));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.mContext.getPageActivity(), 0, str5, str4, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", c.this.mFrom);
                    writeActivityConfig.setCallFrom(c.this.writeCallFrom);
                    writeActivityConfig.setForumLevel(i2);
                    writeActivityConfig.setForumAvatar(str3);
                    writeActivityConfig.setAlbumThread(1);
                    writeActivityConfig.setPrivateThread(i);
                    writeActivityConfig.setForumDir(str2, str);
                    if (!StringUtils.isNull(c.this.hIf)) {
                        writeActivityConfig.setTitle(c.this.hIf, true);
                    }
                    if (!c.a(c.this.mContext.getPageActivity(), writeActivityConfig)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                    }
                }
            });
            this.hHV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    String str2 = null;
                    c.this.bLy();
                    MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                    String str3 = "0";
                    com.baidu.adp.lib.d.a.iX().R(false);
                    if (c.this.hzm != null) {
                        str3 = c.this.hzm.forumId;
                        str = c.this.hzm.forumName;
                        str2 = c.this.hzm.specialForumType;
                    } else {
                        str = null;
                    }
                    TiebaStatic.log(new am("c12611").ax("obj_locate", c.this.hIk).x("obj_type", 4));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(TbadkCoreApplication.getInst().getApplicationContext(), str, str3, TbadkCoreApplication.getCurrentAccount(), str2)));
                }
            });
            onChangeSkinType();
            this.hIg = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.write_thread_black_anim);
            this.hIg.setFillAfter(true);
            this.hIh = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.write_thread_black_hide_anim);
            this.hIh.setFillAfter(true);
            this.hIi = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.write_tab_bg_anim);
            this.hIi.setFillAfter(true);
            this.hIj = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.home_write_bgout);
            this.hIj.setFillAfter(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(Activity activity, final WriteActivityConfig writeActivityConfig) {
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.Di();
        aVar.c(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
        aVar.a(new a.InterfaceC0126a() { // from class: com.baidu.tieba.write.c.8
            @Override // com.baidu.tbadk.core.util.b.a.InterfaceC0126a
            public void Dj() {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, WriteActivityConfig.this));
            }
        });
        return aVar.z(activity);
    }

    private void bLv() {
        int aO = (int) (0.15555556f * l.aO(this.mContext.getPageActivity()));
        a(this.hHP, aO);
        a(this.hHM, aO);
        a(this.hHS, aO);
        a(this.hHV, aO);
        int aQ = l.aQ(this.mContext.getPageActivity());
        ViewGroup.LayoutParams layoutParams = this.hHY.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = aQ / 5;
            this.hHY.setLayoutParams(layoutParams);
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

    public void wh(int i) {
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
            c.this.hHO.setVisibility(4);
            c.this.hHL.setVisibility(4);
            c.this.hHR.setVisibility(4);
            c.this.hHU.setVisibility(4);
            c.this.hHX.setVisibility(4);
            c.this.hHJ.setVisibility(4);
            if (this.mView != null) {
                this.mView.setVisibility(8);
            }
            if (c.this.hHK.getParent() == c.this.mRootView) {
                c.this.mRootView.removeView(c.this.hHK);
            }
            c.this.hIa = false;
        }
    }

    private void bLw() {
        if (this.mFrom == "main_tab" && com.baidu.adp.lib.b.d.iR().aO("android_bigday_switch") != 0 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_write", 0L)) {
            this.hIl = com.baidu.tbadk.core.bigday.b.wG().bX(3);
            if (this.hIl != null && this.hIl.wF()) {
                if (this.hIm == null) {
                    this.hIm = (TbImageView) this.hHK.findViewById(e.g.write_tab_bigday_img);
                    this.hIm.startLoad(this.hIl.imgUrl, 41, false);
                    this.hIm.setVisibility(0);
                    this.hIm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.9
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (c.this.hIl != null && !StringUtils.isNULL(c.this.hIl.akf)) {
                                ay.CU().c(c.this.mContext, new String[]{c.this.hIl.akf});
                                TiebaStatic.log(new am("c13114").h(VideoPlayActivityConfig.OBJ_ID, c.this.hIl.akh).ax("obj_to", c.this.hIl.akf));
                                c.this.bLy();
                            }
                        }
                    });
                    this.hIm.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.write.c.10
                        @Override // com.baidu.tbadk.widget.TbImageView.b
                        public void a(TbImageView tbImageView, Canvas canvas) {
                            if (c.this.hIm.getBdImage() == null && c.this.hIl != null && !ao.isEmpty(c.this.hIl.imgUrl)) {
                                c.this.hIm.startLoad(c.this.hIl.imgUrl, 41, false);
                            }
                        }

                        @Override // com.baidu.tbadk.widget.TbImageView.b
                        public void b(TbImageView tbImageView, Canvas canvas) {
                        }
                    });
                    ViewGroup.LayoutParams layoutParams = this.hIm.getLayoutParams();
                    if (layoutParams instanceof RelativeLayout.LayoutParams) {
                        int aO = (int) (l.aO(this.mContext.getContext()) * 0.546d);
                        layoutParams.width = aO;
                        layoutParams.height = aO;
                        ((RelativeLayout.LayoutParams) layoutParams).topMargin = l.aQ(this.mContext.getContext()) / 5;
                        this.hIm.setLayoutParams(layoutParams);
                    }
                }
                if (this.hIn == null) {
                    this.hIn = this.hHK.findViewById(e.g.write_tab_bigday_close);
                    this.hIn.setVisibility(0);
                    this.hIn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.11
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            c.this.hIn.clearAnimation();
                            c.this.hIm.clearAnimation();
                            c.this.hIn.setVisibility(8);
                            c.this.hIm.setVisibility(8);
                            Calendar calendar = Calendar.getInstance();
                            calendar.set(11, 23);
                            calendar.set(12, 59);
                            calendar.set(13, 59);
                            calendar.set(14, 0);
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_bigday_next_showtime_write", calendar.getTimeInMillis());
                        }
                    });
                }
                this.hIm.startAnimation(this.hIi);
                this.hIn.startAnimation(this.hIi);
                TiebaStatic.log(new am("c13113").h(VideoPlayActivityConfig.OBJ_ID, this.hIl.akh).ax("obj_to", this.hIl.akf));
            }
        }
    }

    public void oc(boolean z) {
        if (!this.hIa && this.hIc && this.hId && this.mRootView != null) {
            bLw();
            this.hHX.clearAnimation();
            this.hIa = true;
            if (this.hHK.getParent() == null) {
                com.baidu.tbadk.k.d.ae(this.mRootView).a(this.mRootView, this.hHK, z);
            }
            this.hHY.setVisibility(0);
            this.hHJ.setVisibility(0);
            this.hHJ.clearAnimation();
            this.hHJ.startAnimation(this.hIi);
            this.hHX.setVisibility(0);
            this.hHX.startAnimation(this.hIg);
            bLx();
            TiebaStatic.log(new am("c12052").ax("obj_locate", this.hIk));
            if (j.kZ()) {
                String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_baidu_sim_card_writting_tip", "");
                if (!ao.isEmpty(string)) {
                    BdToast.a(this.mContext.getContext(), string).AC();
                    com.baidu.tbadk.core.sharedPref.b.getInstance().remove("key_baidu_sim_card_writting_tip");
                }
            }
        }
    }

    private void bLx() {
        clearAnimation();
        final int size = this.hIe.size();
        this.hIc = false;
        this.hIb = 0;
        for (int i = 0; i < size; i++) {
            final View view = this.hIe.get(i);
            com.baidu.adp.lib.g.e.jI().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.c.2
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
                            if (c.this.hIb == size) {
                                c.this.hIc = true;
                                c.this.hIb = 0;
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

    public void aBj() {
        bV(this.hHY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bV(View view) {
        if (this.hIc && this.hId) {
            if (this.hHZ != null) {
                com.baidu.adp.lib.g.e.jI().removeCallbacks(this.hHZ);
            }
            this.hHJ.clearAnimation();
            this.hHJ.startAnimation(this.hIj);
            if (this.hIn != null && this.hIm != null && this.hIn.getVisibility() == 0 && this.hIm.getVisibility() == 0) {
                this.hIn.clearAnimation();
                this.hIm.clearAnimation();
                this.hIm.startAnimation(this.hIj);
                this.hIn.startAnimation(this.hIj);
            }
            this.hHX.clearAnimation();
            this.hHX.startAnimation(this.hIh);
            bLz();
            this.hHZ = new a(view);
            com.baidu.adp.lib.g.e.jI().postDelayed(this.hHZ, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLy() {
        this.hIc = true;
        this.hId = true;
        if (this.hHZ != null) {
            com.baidu.adp.lib.g.e.jI().removeCallbacks(this.hHZ);
        }
        if (this.hHZ == null) {
            this.hHZ = new a(this.hHY);
        }
        com.baidu.adp.lib.g.e.jI().postDelayed(this.hHZ, 500L);
    }

    private void bLz() {
        clearAnimation();
        int size = this.hIe.size();
        this.hIb = size;
        this.hId = false;
        int i = size - 1;
        for (int i2 = 0; i2 < size; i2++) {
            final View view = this.hIe.get(i);
            i--;
            com.baidu.adp.lib.g.e.jI().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.c.3
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
                            if (c.this.hIb == 1) {
                                c.this.hId = true;
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
        this.hHO.clearAnimation();
        this.hHL.clearAnimation();
        this.hHU.clearAnimation();
        this.hHR.clearAnimation();
    }

    public void onChangeSkinType() {
        al.j(this.hHJ, e.d.cp_bg_line_d_alpha98);
        al.c(this.hHM, e.f.icon_post_type_photograph_n);
        al.c(this.hHP, e.f.icon_post_type_text_n);
        al.c(this.hHS, e.f.icon_post_type_image_n);
        al.c(this.hHV, e.f.icon_post_type_live_n);
        al.c(this.hHX, e.f.icon_tabbar_add_s);
        al.h(this.hHN, e.d.cp_cont_b);
        al.h(this.hHQ, e.d.cp_cont_b);
        al.h(this.hHT, e.d.cp_cont_b);
        al.h(this.hHW, e.d.cp_cont_b);
    }

    public void onDestroy() {
        if (this.hHK != null && this.hHK.getParent() == this.mRootView) {
            this.mRootView.removeView(this.hHK);
        }
        if (this.hHZ != null) {
            com.baidu.adp.lib.g.e.jI().removeCallbacks(this.hHZ);
            this.hHZ = null;
        }
        this.hIe.clear();
    }

    public boolean isShowing() {
        return this.hIa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wM(String str) {
        String str2;
        String str3;
        int i;
        String str4;
        int i2;
        String str5;
        String str6;
        bLy();
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.hzm == null) {
            str2 = "";
            str3 = "";
            i = 0;
            str4 = null;
            i2 = -1;
            str5 = null;
            str6 = "0";
        } else {
            String str7 = this.hzm.forumId;
            String str8 = this.hzm.forumName;
            postPrefixData = this.hzm.prefixData;
            antiData = this.hzm.antiData;
            int i3 = this.hzm.forumLevel;
            String str9 = this.hzm.avatar;
            int i4 = this.hzm.privateThread;
            String str10 = this.hzm.firstDir;
            str2 = this.hzm.secondDir;
            str3 = str10;
            i = i4;
            str4 = str9;
            i2 = i3;
            str5 = str8;
            str6 = str7;
        }
        TiebaStatic.log(new am("c12611").ax("obj_locate", this.hIk).x("obj_type", 1));
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
