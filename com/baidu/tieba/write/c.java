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
    private ForumWriteData hLt;
    private View hTO;
    private View hTP;
    private LinearLayout hTQ;
    private TbImageView hTR;
    private TextView hTS;
    private LinearLayout hTT;
    private TbImageView hTU;
    private TextView hTV;
    private LinearLayout hTW;
    private TbImageView hTX;
    private TextView hTY;
    private LinearLayout hTZ;
    private TbImageView hUa;
    private TextView hUb;
    private ImageView hUc;
    private GridLayout hUd;
    private a hUe;
    private Animation hUl;
    private Animation hUm;
    private Animation hUn;
    private Animation hUo;
    private com.baidu.tbadk.core.bigday.a hUq;
    private TbImageView hUr;
    private View hUs;
    private TbPageContext mContext;
    private String mFrom;
    private ViewGroup mRootView;
    private String writeCallFrom;
    private boolean hUf = false;
    private int hUg = 0;
    private boolean hUh = true;
    private boolean hUi = true;
    private ArrayList<View> hUj = new ArrayList<>();
    private String hUk = "";
    private String hUp = "0";

    static /* synthetic */ int v(c cVar) {
        int i = cVar.hUg;
        cVar.hUg = i + 1;
        return i;
    }

    static /* synthetic */ int x(c cVar) {
        int i = cVar.hUg;
        cVar.hUg = i - 1;
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

    public void xv(String str) {
        if (str == null) {
            str = "";
        }
        this.hUk = str;
    }

    public void a(ForumWriteData forumWriteData) {
        this.hLt = forumWriteData;
    }

    public void xw(String str) {
        if ("3".equals(str)) {
            this.writeCallFrom = "1";
        } else {
            this.writeCallFrom = str;
        }
        this.hUp = str;
    }

    private void initView() {
        if (this.mContext != null && this.mContext.getPageActivity() != null && this.mRootView != null) {
            this.hTP = LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.bottom_write_thread, (ViewGroup) null);
            this.hTT = (LinearLayout) this.hTP.findViewById(e.g.home_write_article);
            this.hTU = (TbImageView) this.hTP.findViewById(e.g.home_write_article_icon);
            this.hTV = (TextView) this.hTP.findViewById(e.g.home_write_article_title);
            this.hTQ = (LinearLayout) this.hTP.findViewById(e.g.home_write_photo);
            this.hTR = (TbImageView) this.hTP.findViewById(e.g.home_write_photo_icon);
            this.hTS = (TextView) this.hTP.findViewById(e.g.home_write_photo_title);
            this.hTW = (LinearLayout) this.hTP.findViewById(e.g.home_write_album);
            this.hTX = (TbImageView) this.hTP.findViewById(e.g.home_write_album_icon);
            this.hTY = (TextView) this.hTP.findViewById(e.g.home_write_album_title);
            this.hTZ = (LinearLayout) this.hTP.findViewById(e.g.home_write_live);
            this.hUa = (TbImageView) this.hTP.findViewById(e.g.home_write_live_icon);
            this.hUb = (TextView) this.hTP.findViewById(e.g.home_write_live_title);
            this.hUc = (ImageView) this.hTP.findViewById(e.g.write_close_view);
            this.hTO = this.hTP.findViewById(e.g.view_background);
            this.hUd = (GridLayout) this.hTP.findViewById(e.g.type_container);
            this.hUd.setMeasureAllChild(true);
            this.hUd.setVerNum(1);
            bNQ();
            this.hUj.add(this.hTT);
            this.hUj.add(this.hTQ);
            this.hUj.add(this.hTW);
            this.hUj.add(this.hTZ);
            this.hTP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.bgColor != 0) {
                        UtilHelper.setNavigationBarBackground(c.this.mContext.getPageActivity(), c.this.bgColor);
                    }
                    c.this.ca(c.this.hUd);
                }
            });
            this.hTU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.xx(c.this.hUk);
                }
            });
            this.hTR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.bNT();
                    TiebaStatic.log(new am("c12611").aA("obj_locate", c.this.hUp).x("obj_type", 2));
                    if (c.this.hLt == null) {
                        c.this.hLt = new ForumWriteData("0", null, null, null);
                    }
                    c.this.hLt.mFrom = c.this.mFrom;
                    c.this.hLt.writeCallFrom = c.this.writeCallFrom;
                    e.a(c.this.mContext, "", c.this.hLt);
                }
            });
            this.hTX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    String str2;
                    int i;
                    String str3;
                    int i2;
                    String str4;
                    String str5;
                    c.this.bNT();
                    PostPrefixData postPrefixData = null;
                    AntiData antiData = null;
                    if (c.this.hLt != null) {
                        String str6 = c.this.hLt.forumId;
                        String str7 = c.this.hLt.forumName;
                        postPrefixData = c.this.hLt.prefixData;
                        antiData = c.this.hLt.antiData;
                        int i3 = c.this.hLt.forumLevel;
                        String str8 = c.this.hLt.avatar;
                        int i4 = c.this.hLt.privateThread;
                        String str9 = c.this.hLt.firstDir;
                        str = c.this.hLt.secondDir;
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
                    TiebaStatic.log(new am("c12611").aA("obj_locate", c.this.hUp).x("obj_type", 3));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.mContext.getPageActivity(), 0, str5, str4, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", c.this.mFrom);
                    writeActivityConfig.setCallFrom(c.this.writeCallFrom);
                    writeActivityConfig.setForumLevel(i2);
                    writeActivityConfig.setForumAvatar(str3);
                    writeActivityConfig.setAlbumThread(1);
                    writeActivityConfig.setPrivateThread(i);
                    writeActivityConfig.setForumDir(str2, str);
                    if (!StringUtils.isNull(c.this.hUk)) {
                        writeActivityConfig.setTitle(c.this.hUk, true);
                    }
                    if (!c.a(c.this.mContext.getPageActivity(), writeActivityConfig)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                    }
                }
            });
            this.hUa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    String str2 = null;
                    c.this.bNT();
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
                    if (c.this.hLt != null) {
                        str3 = c.this.hLt.forumId;
                        str = c.this.hLt.forumName;
                        str2 = c.this.hLt.specialForumType;
                    } else {
                        str = null;
                    }
                    TiebaStatic.log(new am("c12611").aA("obj_locate", c.this.hUp).x("obj_type", 4));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(TbadkCoreApplication.getInst().getApplicationContext(), str, str3, TbadkCoreApplication.getCurrentAccount(), str2)));
                }
            });
            onChangeSkinType();
            this.hUl = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.write_thread_black_anim);
            this.hUl.setFillAfter(true);
            this.hUm = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.write_thread_black_hide_anim);
            this.hUm.setFillAfter(true);
            this.hUn = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.write_tab_bg_anim);
            this.hUn.setFillAfter(true);
            this.hUo = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.home_write_bgout);
            this.hUo.setFillAfter(true);
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

    private void bNQ() {
        int aO = (int) (0.15555556f * l.aO(this.mContext.getPageActivity()));
        b(this.hTU, aO);
        b(this.hTR, aO);
        b(this.hTX, aO);
        b(this.hUa, aO);
        int aQ = l.aQ(this.mContext.getPageActivity());
        ViewGroup.LayoutParams layoutParams = this.hUd.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = aQ / 5;
            this.hUd.setLayoutParams(layoutParams);
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

    public void xk(int i) {
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
            c.this.hTT.setVisibility(4);
            c.this.hTQ.setVisibility(4);
            c.this.hTW.setVisibility(4);
            c.this.hTZ.setVisibility(4);
            c.this.hUc.setVisibility(4);
            c.this.hTO.setVisibility(4);
            if (this.mView != null) {
                this.mView.setVisibility(8);
            }
            if (c.this.hTP.getParent() == c.this.mRootView) {
                c.this.mRootView.removeView(c.this.hTP);
            }
            c.this.hUf = false;
        }
    }

    private void bNR() {
        if (this.mFrom == "main_tab" && com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") != 0 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_write", 0L)) {
            this.hUq = com.baidu.tbadk.core.bigday.b.xS().cA(3);
            if (this.hUq != null && this.hUq.xR()) {
                if (this.hUr == null) {
                    this.hUr = (TbImageView) this.hTP.findViewById(e.g.write_tab_bigday_img);
                    this.hUr.startLoad(this.hUq.imgUrl, 41, false);
                    this.hUr.setVisibility(0);
                    this.hUr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.9
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (c.this.hUq != null && !StringUtils.isNULL(c.this.hUq.aou)) {
                                ay.Ef().c(c.this.mContext, new String[]{c.this.hUq.aou});
                                TiebaStatic.log(new am("c13114").i(VideoPlayActivityConfig.OBJ_ID, c.this.hUq.aow).aA("obj_to", c.this.hUq.aou));
                                c.this.bNT();
                            }
                        }
                    });
                    this.hUr.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.write.c.10
                        @Override // com.baidu.tbadk.widget.TbImageView.b
                        public void a(TbImageView tbImageView, Canvas canvas) {
                            if (c.this.hUr.getBdImage() == null && c.this.hUq != null && !ao.isEmpty(c.this.hUq.imgUrl)) {
                                c.this.hUr.startLoad(c.this.hUq.imgUrl, 41, false);
                            }
                        }

                        @Override // com.baidu.tbadk.widget.TbImageView.b
                        public void b(TbImageView tbImageView, Canvas canvas) {
                        }
                    });
                    ViewGroup.LayoutParams layoutParams = this.hUr.getLayoutParams();
                    if (layoutParams instanceof RelativeLayout.LayoutParams) {
                        int aO = (int) (l.aO(this.mContext.getContext()) * 0.546d);
                        layoutParams.width = aO;
                        layoutParams.height = aO;
                        ((RelativeLayout.LayoutParams) layoutParams).topMargin = l.aQ(this.mContext.getContext()) / 5;
                        this.hUr.setLayoutParams(layoutParams);
                    }
                }
                if (this.hUs == null) {
                    this.hUs = this.hTP.findViewById(e.g.write_tab_bigday_close);
                    this.hUs.setVisibility(0);
                    this.hUs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.11
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            c.this.hUs.clearAnimation();
                            c.this.hUr.clearAnimation();
                            c.this.hUs.setVisibility(8);
                            c.this.hUr.setVisibility(8);
                            Calendar calendar = Calendar.getInstance();
                            calendar.set(11, 23);
                            calendar.set(12, 59);
                            calendar.set(13, 59);
                            calendar.set(14, 0);
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_bigday_next_showtime_write", calendar.getTimeInMillis());
                        }
                    });
                }
                this.hUr.startAnimation(this.hUn);
                this.hUs.startAnimation(this.hUn);
                TiebaStatic.log(new am("c13113").i(VideoPlayActivityConfig.OBJ_ID, this.hUq.aow).aA("obj_to", this.hUq.aou));
            }
        }
    }

    public void ov(boolean z) {
        if (!this.hUf && this.hUh && this.hUi && this.mRootView != null) {
            bNR();
            this.hUc.clearAnimation();
            this.hUf = true;
            if (this.hTP.getParent() == null) {
                com.baidu.tbadk.k.d.ad(this.mRootView).a(this.mRootView, this.hTP, z);
            }
            this.hUd.setVisibility(0);
            this.hTO.setVisibility(0);
            this.hTO.clearAnimation();
            this.hTO.startAnimation(this.hUn);
            this.hUc.setVisibility(0);
            this.hUc.startAnimation(this.hUl);
            bNS();
            TiebaStatic.log(new am("c12052").aA("obj_locate", this.hUp));
            if (j.kX()) {
                String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_baidu_sim_card_writting_tip", "");
                if (!ao.isEmpty(string)) {
                    BdToast.a(this.mContext.getContext(), string).BN();
                    com.baidu.tbadk.core.sharedPref.b.getInstance().remove("key_baidu_sim_card_writting_tip");
                }
            }
        }
    }

    private void bNS() {
        clearAnimation();
        final int size = this.hUj.size();
        this.hUh = false;
        this.hUg = 0;
        for (int i = 0; i < size; i++) {
            final View view = this.hUj.get(i);
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
                            if (c.this.hUg == size) {
                                c.this.hUh = true;
                                c.this.hUg = 0;
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

    public void aDf() {
        ca(this.hUd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ca(View view) {
        if (this.hUh && this.hUi) {
            if (this.hUe != null) {
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.hUe);
            }
            this.hTO.clearAnimation();
            this.hTO.startAnimation(this.hUo);
            if (this.hUs != null && this.hUr != null && this.hUs.getVisibility() == 0 && this.hUr.getVisibility() == 0) {
                this.hUs.clearAnimation();
                this.hUr.clearAnimation();
                this.hUr.startAnimation(this.hUo);
                this.hUs.startAnimation(this.hUo);
            }
            this.hUc.clearAnimation();
            this.hUc.startAnimation(this.hUm);
            bNU();
            this.hUe = new a(view);
            com.baidu.adp.lib.g.e.jG().postDelayed(this.hUe, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNT() {
        this.hUh = true;
        this.hUi = true;
        if (this.hUe != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.hUe);
        }
        if (this.hUe == null) {
            this.hUe = new a(this.hUd);
        }
        com.baidu.adp.lib.g.e.jG().postDelayed(this.hUe, 500L);
    }

    private void bNU() {
        clearAnimation();
        int size = this.hUj.size();
        this.hUg = size;
        this.hUi = false;
        int i = size - 1;
        for (int i2 = 0; i2 < size; i2++) {
            final View view = this.hUj.get(i);
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
                            if (c.this.hUg == 1) {
                                c.this.hUi = true;
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
        this.hTT.clearAnimation();
        this.hTQ.clearAnimation();
        this.hTZ.clearAnimation();
        this.hTW.clearAnimation();
    }

    public void onChangeSkinType() {
        al.j(this.hTO, e.d.cp_bg_line_d_alpha98);
        al.c(this.hTR, e.f.icon_post_type_photograph_n);
        al.c(this.hTU, e.f.icon_post_type_text_n);
        al.c(this.hTX, e.f.icon_post_type_image_n);
        al.c(this.hUa, e.f.icon_post_type_live_n);
        al.c(this.hUc, e.f.icon_tabbar_add_s);
        al.h(this.hTS, e.d.cp_cont_b);
        al.h(this.hTV, e.d.cp_cont_b);
        al.h(this.hTY, e.d.cp_cont_b);
        al.h(this.hUb, e.d.cp_cont_b);
    }

    public void onDestroy() {
        if (this.hTP != null && this.hTP.getParent() == this.mRootView) {
            this.mRootView.removeView(this.hTP);
        }
        if (this.hUe != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.hUe);
            this.hUe = null;
        }
        this.hUj.clear();
    }

    public boolean isShowing() {
        return this.hUf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xx(String str) {
        String str2;
        String str3;
        int i;
        String str4;
        int i2;
        String str5;
        String str6;
        bNT();
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.hLt == null) {
            str2 = "";
            str3 = "";
            i = 0;
            str4 = null;
            i2 = -1;
            str5 = null;
            str6 = "0";
        } else {
            String str7 = this.hLt.forumId;
            String str8 = this.hLt.forumName;
            postPrefixData = this.hLt.prefixData;
            antiData = this.hLt.antiData;
            int i3 = this.hLt.forumLevel;
            String str9 = this.hLt.avatar;
            int i4 = this.hLt.privateThread;
            String str10 = this.hLt.firstDir;
            str2 = this.hLt.secondDir;
            str3 = str10;
            i = i4;
            str4 = str9;
            i2 = i3;
            str5 = str8;
            str6 = str7;
        }
        TiebaStatic.log(new am("c12611").aA("obj_locate", this.hUp).x("obj_type", 1));
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
