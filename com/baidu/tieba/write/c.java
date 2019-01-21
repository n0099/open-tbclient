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
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
    private ForumWriteData hMB;
    private View hUW;
    private View hUX;
    private LinearLayout hUY;
    private TbImageView hUZ;
    private View hVA;
    private TextView hVa;
    private LinearLayout hVb;
    private TbImageView hVc;
    private TextView hVd;
    private LinearLayout hVe;
    private TbImageView hVf;
    private TextView hVg;
    private LinearLayout hVh;
    private TbImageView hVi;
    private TextView hVj;
    private ImageView hVk;
    private GridLayout hVl;
    private a hVm;
    private Animation hVt;
    private Animation hVu;
    private Animation hVv;
    private Animation hVw;
    private com.baidu.tbadk.core.bigday.a hVy;
    private TbImageView hVz;
    private TbPageContext mContext;
    private String mFrom;
    private ViewGroup mRootView;
    private String writeCallFrom;
    private boolean hVn = false;
    private int hVo = 0;
    private boolean hVp = true;
    private boolean hVq = true;
    private ArrayList<View> hVr = new ArrayList<>();
    private String hVs = "";
    private String hVx = "0";

    static /* synthetic */ int v(c cVar) {
        int i = cVar.hVo;
        cVar.hVo = i + 1;
        return i;
    }

    static /* synthetic */ int x(c cVar) {
        int i = cVar.hVo;
        cVar.hVo = i - 1;
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

    public void xL(String str) {
        if (str == null) {
            str = "";
        }
        this.hVs = str;
    }

    public void a(ForumWriteData forumWriteData) {
        this.hMB = forumWriteData;
    }

    public void xM(String str) {
        if ("3".equals(str)) {
            this.writeCallFrom = "1";
        } else {
            this.writeCallFrom = str;
        }
        this.hVx = str;
    }

    private void initView() {
        if (this.mContext != null && this.mContext.getPageActivity() != null && this.mRootView != null) {
            this.hUX = LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.bottom_write_thread, (ViewGroup) null);
            this.hVb = (LinearLayout) this.hUX.findViewById(e.g.home_write_article);
            this.hVc = (TbImageView) this.hUX.findViewById(e.g.home_write_article_icon);
            this.hVd = (TextView) this.hUX.findViewById(e.g.home_write_article_title);
            this.hUY = (LinearLayout) this.hUX.findViewById(e.g.home_write_photo);
            this.hUZ = (TbImageView) this.hUX.findViewById(e.g.home_write_photo_icon);
            this.hVa = (TextView) this.hUX.findViewById(e.g.home_write_photo_title);
            this.hVe = (LinearLayout) this.hUX.findViewById(e.g.home_write_album);
            this.hVf = (TbImageView) this.hUX.findViewById(e.g.home_write_album_icon);
            this.hVg = (TextView) this.hUX.findViewById(e.g.home_write_album_title);
            this.hVh = (LinearLayout) this.hUX.findViewById(e.g.home_write_live);
            this.hVi = (TbImageView) this.hUX.findViewById(e.g.home_write_live_icon);
            this.hVj = (TextView) this.hUX.findViewById(e.g.home_write_live_title);
            this.hVk = (ImageView) this.hUX.findViewById(e.g.write_close_view);
            this.hUW = this.hUX.findViewById(e.g.view_background);
            this.hVl = (GridLayout) this.hUX.findViewById(e.g.type_container);
            this.hVl.setMeasureAllChild(true);
            this.hVl.setVerNum(1);
            bOy();
            this.hVr.add(this.hVb);
            this.hVr.add(this.hUY);
            this.hVr.add(this.hVe);
            this.hVr.add(this.hVh);
            this.hUX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.bgColor != 0) {
                        UtilHelper.setNavigationBarBackground(c.this.mContext.getPageActivity(), c.this.bgColor);
                    }
                    c.this.ca(c.this.hVl);
                }
            });
            this.hVc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.xN(c.this.hVs);
                }
            });
            this.hUZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.bOB();
                    TiebaStatic.log(new am("c12611").aB("obj_locate", c.this.hVx).y("obj_type", 2));
                    if (c.this.hMB == null) {
                        c.this.hMB = new ForumWriteData("0", null, null, null);
                    }
                    c.this.hMB.mFrom = c.this.mFrom;
                    c.this.hMB.writeCallFrom = c.this.writeCallFrom;
                    e.a(c.this.mContext, "", c.this.hMB);
                }
            });
            this.hVf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    String str2;
                    int i;
                    String str3;
                    int i2;
                    String str4;
                    String str5;
                    c.this.bOB();
                    PostPrefixData postPrefixData = null;
                    AntiData antiData = null;
                    if (c.this.hMB != null) {
                        String str6 = c.this.hMB.forumId;
                        String str7 = c.this.hMB.forumName;
                        postPrefixData = c.this.hMB.prefixData;
                        antiData = c.this.hMB.antiData;
                        int i3 = c.this.hMB.forumLevel;
                        String str8 = c.this.hMB.avatar;
                        int i4 = c.this.hMB.privateThread;
                        String str9 = c.this.hMB.firstDir;
                        str = c.this.hMB.secondDir;
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
                    TiebaStatic.log(new am("c12611").aB("obj_locate", c.this.hVx).y("obj_type", 3));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.mContext.getPageActivity(), 0, str5, str4, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", c.this.mFrom);
                    writeActivityConfig.setCallFrom(c.this.writeCallFrom);
                    writeActivityConfig.setForumLevel(i2);
                    writeActivityConfig.setForumAvatar(str3);
                    writeActivityConfig.setAlbumThread(1);
                    writeActivityConfig.setPrivateThread(i);
                    writeActivityConfig.setForumDir(str2, str);
                    if (!StringUtils.isNull(c.this.hVs)) {
                        writeActivityConfig.setTitle(c.this.hVs, true);
                    }
                    if (!c.a(c.this.mContext.getPageActivity(), writeActivityConfig)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                    }
                }
            });
            this.hVi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    String str2 = null;
                    c.this.bOB();
                    if (Build.VERSION.SDK_INT < 21) {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(c.this.mContext.getPageActivity());
                        aVar.setAutoNight(false);
                        aVar.da(e.j.prompt);
                        aVar.eK(c.this.mContext.getResources().getString(e.j.disallow_open_live_by_android_v5_0));
                        aVar.bn(true);
                        aVar.bm(true);
                        aVar.a(e.j.know, new a.b() { // from class: com.baidu.tieba.write.c.7.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                            }
                        });
                        aVar.b(c.this.mContext).BS();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                    String str3 = "0";
                    com.baidu.adp.lib.d.a.iW().af(false);
                    if (c.this.hMB != null) {
                        str3 = c.this.hMB.forumId;
                        str = c.this.hMB.forumName;
                        str2 = c.this.hMB.specialForumType;
                    } else {
                        str = null;
                    }
                    TiebaStatic.log(new am("c12611").aB("obj_locate", c.this.hVx).y("obj_type", 4));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(TbadkCoreApplication.getInst().getApplicationContext(), str, str3, TbadkCoreApplication.getCurrentAccount(), str2)));
                }
            });
            onChangeSkinType();
            this.hVt = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.write_thread_black_anim);
            this.hVt.setFillAfter(true);
            this.hVu = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.write_thread_black_hide_anim);
            this.hVu.setFillAfter(true);
            this.hVv = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.write_tab_bg_anim);
            this.hVv.setFillAfter(true);
            this.hVw = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.home_write_bgout);
            this.hVw.setFillAfter(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(Activity activity, final WriteActivityConfig writeActivityConfig) {
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.EG();
        aVar.c(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
        aVar.a(new a.InterfaceC0160a() { // from class: com.baidu.tieba.write.c.8
            @Override // com.baidu.tbadk.core.util.b.a.InterfaceC0160a
            public void EH() {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, WriteActivityConfig.this));
            }
        });
        return aVar.B(activity);
    }

    private void bOy() {
        int aO = (int) (0.15555556f * l.aO(this.mContext.getPageActivity()));
        b(this.hVc, aO);
        b(this.hUZ, aO);
        b(this.hVf, aO);
        b(this.hVi, aO);
        int aQ = l.aQ(this.mContext.getPageActivity());
        ViewGroup.LayoutParams layoutParams = this.hVl.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = aQ / 5;
            this.hVl.setLayoutParams(layoutParams);
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

    public void xm(int i) {
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
            c.this.hVb.setVisibility(4);
            c.this.hUY.setVisibility(4);
            c.this.hVe.setVisibility(4);
            c.this.hVh.setVisibility(4);
            c.this.hVk.setVisibility(4);
            c.this.hUW.setVisibility(4);
            if (this.mView != null) {
                this.mView.setVisibility(8);
            }
            if (c.this.hUX.getParent() == c.this.mRootView) {
                c.this.mRootView.removeView(c.this.hUX);
            }
            c.this.hVn = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921390, false));
        }
    }

    private void bOz() {
        if (this.mFrom == "main_tab" && com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") != 0 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_write", 0L)) {
            this.hVy = com.baidu.tbadk.core.bigday.b.yf().cA(3);
            if (this.hVy != null && this.hVy.ye()) {
                if (this.hVz == null) {
                    this.hVz = (TbImageView) this.hUX.findViewById(e.g.write_tab_bigday_img);
                    this.hVz.startLoad(this.hVy.imgUrl, 41, false);
                    this.hVz.setVisibility(0);
                    this.hVz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.9
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (c.this.hVy != null && !StringUtils.isNULL(c.this.hVy.aoX)) {
                                ay.Es().c(c.this.mContext, new String[]{c.this.hVy.aoX});
                                TiebaStatic.log(new am("c13114").i(VideoPlayActivityConfig.OBJ_ID, c.this.hVy.aoZ).aB("obj_to", c.this.hVy.aoX));
                                c.this.bOB();
                            }
                        }
                    });
                    this.hVz.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.write.c.10
                        @Override // com.baidu.tbadk.widget.TbImageView.b
                        public void a(TbImageView tbImageView, Canvas canvas) {
                            if (c.this.hVz.getBdImage() == null && c.this.hVy != null && !ao.isEmpty(c.this.hVy.imgUrl)) {
                                c.this.hVz.startLoad(c.this.hVy.imgUrl, 41, false);
                            }
                        }

                        @Override // com.baidu.tbadk.widget.TbImageView.b
                        public void b(TbImageView tbImageView, Canvas canvas) {
                        }
                    });
                    ViewGroup.LayoutParams layoutParams = this.hVz.getLayoutParams();
                    if (layoutParams instanceof RelativeLayout.LayoutParams) {
                        int aO = (int) (l.aO(this.mContext.getContext()) * 0.546d);
                        layoutParams.width = aO;
                        layoutParams.height = aO;
                        ((RelativeLayout.LayoutParams) layoutParams).topMargin = l.aQ(this.mContext.getContext()) / 5;
                        this.hVz.setLayoutParams(layoutParams);
                    }
                }
                if (this.hVA == null) {
                    this.hVA = this.hUX.findViewById(e.g.write_tab_bigday_close);
                    this.hVA.setVisibility(0);
                    this.hVA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.11
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            c.this.hVA.clearAnimation();
                            c.this.hVz.clearAnimation();
                            c.this.hVA.setVisibility(8);
                            c.this.hVz.setVisibility(8);
                            Calendar calendar = Calendar.getInstance();
                            calendar.set(11, 23);
                            calendar.set(12, 59);
                            calendar.set(13, 59);
                            calendar.set(14, 0);
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_bigday_next_showtime_write", calendar.getTimeInMillis());
                        }
                    });
                }
                this.hVz.startAnimation(this.hVv);
                this.hVA.startAnimation(this.hVv);
                TiebaStatic.log(new am("c13113").i(VideoPlayActivityConfig.OBJ_ID, this.hVy.aoZ).aB("obj_to", this.hVy.aoX));
            }
        }
    }

    public void ow(boolean z) {
        if (!this.hVn && this.hVp && this.hVq && this.mRootView != null) {
            bOz();
            this.hVk.clearAnimation();
            this.hVn = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921390, true));
            if (this.hUX.getParent() == null) {
                com.baidu.tbadk.k.d.ad(this.mRootView).a(this.mRootView, this.hUX, z);
            }
            this.hVl.setVisibility(0);
            this.hUW.setVisibility(0);
            this.hUW.clearAnimation();
            this.hUW.startAnimation(this.hVv);
            this.hVk.setVisibility(0);
            this.hVk.startAnimation(this.hVt);
            bOA();
            TiebaStatic.log(new am("c12052").aB("obj_locate", this.hVx));
            if (j.kX()) {
                String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_baidu_sim_card_writting_tip", "");
                if (!ao.isEmpty(string)) {
                    BdToast.a(this.mContext.getContext(), string).Ca();
                    com.baidu.tbadk.core.sharedPref.b.getInstance().remove("key_baidu_sim_card_writting_tip");
                }
            }
        }
    }

    private void bOA() {
        clearAnimation();
        final int size = this.hVr.size();
        this.hVp = false;
        this.hVo = 0;
        for (int i = 0; i < size; i++) {
            final View view = this.hVr.get(i);
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
                            if (c.this.hVo == size) {
                                c.this.hVp = true;
                                c.this.hVo = 0;
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

    public void aDC() {
        ca(this.hVl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ca(View view) {
        if (this.hVp && this.hVq) {
            if (this.hVm != null) {
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.hVm);
            }
            this.hUW.clearAnimation();
            this.hUW.startAnimation(this.hVw);
            if (this.hVA != null && this.hVz != null && this.hVA.getVisibility() == 0 && this.hVz.getVisibility() == 0) {
                this.hVA.clearAnimation();
                this.hVz.clearAnimation();
                this.hVz.startAnimation(this.hVw);
                this.hVA.startAnimation(this.hVw);
            }
            this.hVk.clearAnimation();
            this.hVk.startAnimation(this.hVu);
            bOC();
            this.hVm = new a(view);
            com.baidu.adp.lib.g.e.jG().postDelayed(this.hVm, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOB() {
        this.hVp = true;
        this.hVq = true;
        if (this.hVm != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.hVm);
        }
        if (this.hVm == null) {
            this.hVm = new a(this.hVl);
        }
        com.baidu.adp.lib.g.e.jG().postDelayed(this.hVm, 500L);
    }

    private void bOC() {
        clearAnimation();
        int size = this.hVr.size();
        this.hVo = size;
        this.hVq = false;
        int i = size - 1;
        for (int i2 = 0; i2 < size; i2++) {
            final View view = this.hVr.get(i);
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
                            if (c.this.hVo == 1) {
                                c.this.hVq = true;
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
        this.hVb.clearAnimation();
        this.hUY.clearAnimation();
        this.hVh.clearAnimation();
        this.hVe.clearAnimation();
    }

    public void onChangeSkinType() {
        al.j(this.hUW, e.d.cp_bg_line_d_alpha98);
        al.c(this.hUZ, e.f.icon_post_type_photograph_n);
        al.c(this.hVc, e.f.icon_post_type_text_n);
        al.c(this.hVf, e.f.icon_post_type_image_n);
        al.c(this.hVi, e.f.icon_post_type_live_n);
        al.c(this.hVk, e.f.icon_tabbar_add_s);
        al.h(this.hVa, e.d.cp_cont_b);
        al.h(this.hVd, e.d.cp_cont_b);
        al.h(this.hVg, e.d.cp_cont_b);
        al.h(this.hVj, e.d.cp_cont_b);
    }

    public void onDestroy() {
        if (this.hUX != null && this.hUX.getParent() == this.mRootView) {
            this.mRootView.removeView(this.hUX);
        }
        if (this.hVm != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.hVm);
            this.hVm = null;
        }
        this.hVr.clear();
    }

    public boolean isShowing() {
        return this.hVn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xN(String str) {
        String str2;
        String str3;
        int i;
        String str4;
        int i2;
        String str5;
        String str6;
        bOB();
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.hMB == null) {
            str2 = "";
            str3 = "";
            i = 0;
            str4 = null;
            i2 = -1;
            str5 = null;
            str6 = "0";
        } else {
            String str7 = this.hMB.forumId;
            String str8 = this.hMB.forumName;
            postPrefixData = this.hMB.prefixData;
            antiData = this.hMB.antiData;
            int i3 = this.hMB.forumLevel;
            String str9 = this.hMB.avatar;
            int i4 = this.hMB.privateThread;
            String str10 = this.hMB.firstDir;
            str2 = this.hMB.secondDir;
            str3 = str10;
            i = i4;
            str4 = str9;
            i2 = i3;
            str5 = str8;
            str6 = str7;
        }
        TiebaStatic.log(new am("c12611").aB("obj_locate", this.hVx).y("obj_type", 1));
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
