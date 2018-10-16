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
    private View hHI;
    private View hHJ;
    private LinearLayout hHK;
    private TbImageView hHL;
    private TextView hHM;
    private LinearLayout hHN;
    private TbImageView hHO;
    private TextView hHP;
    private LinearLayout hHQ;
    private TbImageView hHR;
    private TextView hHS;
    private LinearLayout hHT;
    private TbImageView hHU;
    private TextView hHV;
    private ImageView hHW;
    private GridLayout hHX;
    private a hHY;
    private Animation hIf;
    private Animation hIg;
    private Animation hIh;
    private Animation hIi;
    private com.baidu.tbadk.core.bigday.a hIk;
    private TbImageView hIl;
    private View hIm;
    private ForumWriteData hzl;
    private TbPageContext mContext;
    private String mFrom;
    private ViewGroup mRootView;
    private String writeCallFrom;
    private boolean hHZ = false;
    private int hIa = 0;
    private boolean hIb = true;
    private boolean hIc = true;
    private ArrayList<View> hId = new ArrayList<>();
    private String hIe = "";
    private String hIj = "0";

    static /* synthetic */ int v(c cVar) {
        int i = cVar.hIa;
        cVar.hIa = i + 1;
        return i;
    }

    static /* synthetic */ int x(c cVar) {
        int i = cVar.hIa;
        cVar.hIa = i - 1;
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
        this.hIe = str;
    }

    public void a(ForumWriteData forumWriteData) {
        this.hzl = forumWriteData;
    }

    public void wL(String str) {
        if ("3".equals(str)) {
            this.writeCallFrom = "1";
        } else {
            this.writeCallFrom = str;
        }
        this.hIj = str;
    }

    private void initView() {
        if (this.mContext != null && this.mContext.getPageActivity() != null && this.mRootView != null) {
            this.hHJ = LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.bottom_write_thread, (ViewGroup) null);
            this.hHN = (LinearLayout) this.hHJ.findViewById(e.g.home_write_article);
            this.hHO = (TbImageView) this.hHJ.findViewById(e.g.home_write_article_icon);
            this.hHP = (TextView) this.hHJ.findViewById(e.g.home_write_article_title);
            this.hHK = (LinearLayout) this.hHJ.findViewById(e.g.home_write_photo);
            this.hHL = (TbImageView) this.hHJ.findViewById(e.g.home_write_photo_icon);
            this.hHM = (TextView) this.hHJ.findViewById(e.g.home_write_photo_title);
            this.hHQ = (LinearLayout) this.hHJ.findViewById(e.g.home_write_album);
            this.hHR = (TbImageView) this.hHJ.findViewById(e.g.home_write_album_icon);
            this.hHS = (TextView) this.hHJ.findViewById(e.g.home_write_album_title);
            this.hHT = (LinearLayout) this.hHJ.findViewById(e.g.home_write_live);
            this.hHU = (TbImageView) this.hHJ.findViewById(e.g.home_write_live_icon);
            this.hHV = (TextView) this.hHJ.findViewById(e.g.home_write_live_title);
            this.hHW = (ImageView) this.hHJ.findViewById(e.g.write_close_view);
            this.hHI = this.hHJ.findViewById(e.g.view_background);
            this.hHX = (GridLayout) this.hHJ.findViewById(e.g.type_container);
            this.hHX.setMeasureAllChild(true);
            this.hHX.setVerNum(1);
            bLv();
            this.hId.add(this.hHN);
            this.hId.add(this.hHK);
            this.hId.add(this.hHQ);
            this.hId.add(this.hHT);
            this.hHJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.bgColor != 0) {
                        UtilHelper.setNavigationBarBackground(c.this.mContext.getPageActivity(), c.this.bgColor);
                    }
                    c.this.bV(c.this.hHX);
                }
            });
            this.hHO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.wM(c.this.hIe);
                }
            });
            this.hHL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.bLy();
                    TiebaStatic.log(new am("c12611").ax("obj_locate", c.this.hIj).x("obj_type", 2));
                    if (c.this.hzl == null) {
                        c.this.hzl = new ForumWriteData("0", null, null, null);
                    }
                    c.this.hzl.mFrom = c.this.mFrom;
                    c.this.hzl.writeCallFrom = c.this.writeCallFrom;
                    e.a(c.this.mContext, "", c.this.hzl);
                }
            });
            this.hHR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.6
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
                    if (c.this.hzl != null) {
                        String str6 = c.this.hzl.forumId;
                        String str7 = c.this.hzl.forumName;
                        postPrefixData = c.this.hzl.prefixData;
                        antiData = c.this.hzl.antiData;
                        int i3 = c.this.hzl.forumLevel;
                        String str8 = c.this.hzl.avatar;
                        int i4 = c.this.hzl.privateThread;
                        String str9 = c.this.hzl.firstDir;
                        str = c.this.hzl.secondDir;
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
                    TiebaStatic.log(new am("c12611").ax("obj_locate", c.this.hIj).x("obj_type", 3));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.mContext.getPageActivity(), 0, str5, str4, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", c.this.mFrom);
                    writeActivityConfig.setCallFrom(c.this.writeCallFrom);
                    writeActivityConfig.setForumLevel(i2);
                    writeActivityConfig.setForumAvatar(str3);
                    writeActivityConfig.setAlbumThread(1);
                    writeActivityConfig.setPrivateThread(i);
                    writeActivityConfig.setForumDir(str2, str);
                    if (!StringUtils.isNull(c.this.hIe)) {
                        writeActivityConfig.setTitle(c.this.hIe, true);
                    }
                    if (!c.a(c.this.mContext.getPageActivity(), writeActivityConfig)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                    }
                }
            });
            this.hHU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    String str2 = null;
                    c.this.bLy();
                    MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                    String str3 = "0";
                    com.baidu.adp.lib.d.a.iX().R(false);
                    if (c.this.hzl != null) {
                        str3 = c.this.hzl.forumId;
                        str = c.this.hzl.forumName;
                        str2 = c.this.hzl.specialForumType;
                    } else {
                        str = null;
                    }
                    TiebaStatic.log(new am("c12611").ax("obj_locate", c.this.hIj).x("obj_type", 4));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(TbadkCoreApplication.getInst().getApplicationContext(), str, str3, TbadkCoreApplication.getCurrentAccount(), str2)));
                }
            });
            onChangeSkinType();
            this.hIf = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.write_thread_black_anim);
            this.hIf.setFillAfter(true);
            this.hIg = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.write_thread_black_hide_anim);
            this.hIg.setFillAfter(true);
            this.hIh = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.write_tab_bg_anim);
            this.hIh.setFillAfter(true);
            this.hIi = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.home_write_bgout);
            this.hIi.setFillAfter(true);
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
        a(this.hHO, aO);
        a(this.hHL, aO);
        a(this.hHR, aO);
        a(this.hHU, aO);
        int aQ = l.aQ(this.mContext.getPageActivity());
        ViewGroup.LayoutParams layoutParams = this.hHX.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = aQ / 5;
            this.hHX.setLayoutParams(layoutParams);
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
            c.this.hHN.setVisibility(4);
            c.this.hHK.setVisibility(4);
            c.this.hHQ.setVisibility(4);
            c.this.hHT.setVisibility(4);
            c.this.hHW.setVisibility(4);
            c.this.hHI.setVisibility(4);
            if (this.mView != null) {
                this.mView.setVisibility(8);
            }
            if (c.this.hHJ.getParent() == c.this.mRootView) {
                c.this.mRootView.removeView(c.this.hHJ);
            }
            c.this.hHZ = false;
        }
    }

    private void bLw() {
        if (this.mFrom == "main_tab" && com.baidu.adp.lib.b.d.iR().aO("android_bigday_switch") != 0 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_write", 0L)) {
            this.hIk = com.baidu.tbadk.core.bigday.b.wG().bX(3);
            if (this.hIk != null && this.hIk.wF()) {
                if (this.hIl == null) {
                    this.hIl = (TbImageView) this.hHJ.findViewById(e.g.write_tab_bigday_img);
                    this.hIl.startLoad(this.hIk.imgUrl, 41, false);
                    this.hIl.setVisibility(0);
                    this.hIl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.9
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (c.this.hIk != null && !StringUtils.isNULL(c.this.hIk.akf)) {
                                ay.CU().c(c.this.mContext, new String[]{c.this.hIk.akf});
                                TiebaStatic.log(new am("c13114").h(VideoPlayActivityConfig.OBJ_ID, c.this.hIk.akh).ax("obj_to", c.this.hIk.akf));
                                c.this.bLy();
                            }
                        }
                    });
                    this.hIl.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.write.c.10
                        @Override // com.baidu.tbadk.widget.TbImageView.b
                        public void a(TbImageView tbImageView, Canvas canvas) {
                            if (c.this.hIl.getBdImage() == null && c.this.hIk != null && !ao.isEmpty(c.this.hIk.imgUrl)) {
                                c.this.hIl.startLoad(c.this.hIk.imgUrl, 41, false);
                            }
                        }

                        @Override // com.baidu.tbadk.widget.TbImageView.b
                        public void b(TbImageView tbImageView, Canvas canvas) {
                        }
                    });
                    ViewGroup.LayoutParams layoutParams = this.hIl.getLayoutParams();
                    if (layoutParams instanceof RelativeLayout.LayoutParams) {
                        int aO = (int) (l.aO(this.mContext.getContext()) * 0.546d);
                        layoutParams.width = aO;
                        layoutParams.height = aO;
                        ((RelativeLayout.LayoutParams) layoutParams).topMargin = l.aQ(this.mContext.getContext()) / 5;
                        this.hIl.setLayoutParams(layoutParams);
                    }
                }
                if (this.hIm == null) {
                    this.hIm = this.hHJ.findViewById(e.g.write_tab_bigday_close);
                    this.hIm.setVisibility(0);
                    this.hIm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.11
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            c.this.hIm.clearAnimation();
                            c.this.hIl.clearAnimation();
                            c.this.hIm.setVisibility(8);
                            c.this.hIl.setVisibility(8);
                            Calendar calendar = Calendar.getInstance();
                            calendar.set(11, 23);
                            calendar.set(12, 59);
                            calendar.set(13, 59);
                            calendar.set(14, 0);
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_bigday_next_showtime_write", calendar.getTimeInMillis());
                        }
                    });
                }
                this.hIl.startAnimation(this.hIh);
                this.hIm.startAnimation(this.hIh);
                TiebaStatic.log(new am("c13113").h(VideoPlayActivityConfig.OBJ_ID, this.hIk.akh).ax("obj_to", this.hIk.akf));
            }
        }
    }

    public void oc(boolean z) {
        if (!this.hHZ && this.hIb && this.hIc && this.mRootView != null) {
            bLw();
            this.hHW.clearAnimation();
            this.hHZ = true;
            if (this.hHJ.getParent() == null) {
                com.baidu.tbadk.k.d.ae(this.mRootView).a(this.mRootView, this.hHJ, z);
            }
            this.hHX.setVisibility(0);
            this.hHI.setVisibility(0);
            this.hHI.clearAnimation();
            this.hHI.startAnimation(this.hIh);
            this.hHW.setVisibility(0);
            this.hHW.startAnimation(this.hIf);
            bLx();
            TiebaStatic.log(new am("c12052").ax("obj_locate", this.hIj));
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
        final int size = this.hId.size();
        this.hIb = false;
        this.hIa = 0;
        for (int i = 0; i < size; i++) {
            final View view = this.hId.get(i);
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
                            if (c.this.hIa == size) {
                                c.this.hIb = true;
                                c.this.hIa = 0;
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

    public void aBi() {
        bV(this.hHX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bV(View view) {
        if (this.hIb && this.hIc) {
            if (this.hHY != null) {
                com.baidu.adp.lib.g.e.jI().removeCallbacks(this.hHY);
            }
            this.hHI.clearAnimation();
            this.hHI.startAnimation(this.hIi);
            if (this.hIm != null && this.hIl != null && this.hIm.getVisibility() == 0 && this.hIl.getVisibility() == 0) {
                this.hIm.clearAnimation();
                this.hIl.clearAnimation();
                this.hIl.startAnimation(this.hIi);
                this.hIm.startAnimation(this.hIi);
            }
            this.hHW.clearAnimation();
            this.hHW.startAnimation(this.hIg);
            bLz();
            this.hHY = new a(view);
            com.baidu.adp.lib.g.e.jI().postDelayed(this.hHY, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLy() {
        this.hIb = true;
        this.hIc = true;
        if (this.hHY != null) {
            com.baidu.adp.lib.g.e.jI().removeCallbacks(this.hHY);
        }
        if (this.hHY == null) {
            this.hHY = new a(this.hHX);
        }
        com.baidu.adp.lib.g.e.jI().postDelayed(this.hHY, 500L);
    }

    private void bLz() {
        clearAnimation();
        int size = this.hId.size();
        this.hIa = size;
        this.hIc = false;
        int i = size - 1;
        for (int i2 = 0; i2 < size; i2++) {
            final View view = this.hId.get(i);
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
                            if (c.this.hIa == 1) {
                                c.this.hIc = true;
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
        this.hHN.clearAnimation();
        this.hHK.clearAnimation();
        this.hHT.clearAnimation();
        this.hHQ.clearAnimation();
    }

    public void onChangeSkinType() {
        al.j(this.hHI, e.d.cp_bg_line_d_alpha98);
        al.c(this.hHL, e.f.icon_post_type_photograph_n);
        al.c(this.hHO, e.f.icon_post_type_text_n);
        al.c(this.hHR, e.f.icon_post_type_image_n);
        al.c(this.hHU, e.f.icon_post_type_live_n);
        al.c(this.hHW, e.f.icon_tabbar_add_s);
        al.h(this.hHM, e.d.cp_cont_b);
        al.h(this.hHP, e.d.cp_cont_b);
        al.h(this.hHS, e.d.cp_cont_b);
        al.h(this.hHV, e.d.cp_cont_b);
    }

    public void onDestroy() {
        if (this.hHJ != null && this.hHJ.getParent() == this.mRootView) {
            this.mRootView.removeView(this.hHJ);
        }
        if (this.hHY != null) {
            com.baidu.adp.lib.g.e.jI().removeCallbacks(this.hHY);
            this.hHY = null;
        }
        this.hId.clear();
    }

    public boolean isShowing() {
        return this.hHZ;
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
        if (this.hzl == null) {
            str2 = "";
            str3 = "";
            i = 0;
            str4 = null;
            i2 = -1;
            str5 = null;
            str6 = "0";
        } else {
            String str7 = this.hzl.forumId;
            String str8 = this.hzl.forumName;
            postPrefixData = this.hzl.prefixData;
            antiData = this.hzl.antiData;
            int i3 = this.hzl.forumLevel;
            String str9 = this.hzl.avatar;
            int i4 = this.hzl.privateThread;
            String str10 = this.hzl.firstDir;
            str2 = this.hzl.secondDir;
            str3 = str10;
            i = i4;
            str4 = str9;
            i2 = i3;
            str5 = str8;
            str6 = str7;
        }
        TiebaStatic.log(new am("c12611").ax("obj_locate", this.hIj).x("obj_type", 1));
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
