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
    private ForumWriteData hMA;
    private View hUV;
    private View hUW;
    private LinearLayout hUX;
    private TbImageView hUY;
    private TextView hUZ;
    private LinearLayout hVa;
    private TbImageView hVb;
    private TextView hVc;
    private LinearLayout hVd;
    private TbImageView hVe;
    private TextView hVf;
    private LinearLayout hVg;
    private TbImageView hVh;
    private TextView hVi;
    private ImageView hVj;
    private GridLayout hVk;
    private a hVl;
    private Animation hVs;
    private Animation hVt;
    private Animation hVu;
    private Animation hVv;
    private com.baidu.tbadk.core.bigday.a hVx;
    private TbImageView hVy;
    private View hVz;
    private TbPageContext mContext;
    private String mFrom;
    private ViewGroup mRootView;
    private String writeCallFrom;
    private boolean hVm = false;
    private int hVn = 0;
    private boolean hVo = true;
    private boolean hVp = true;
    private ArrayList<View> hVq = new ArrayList<>();
    private String hVr = "";
    private String hVw = "0";

    static /* synthetic */ int v(c cVar) {
        int i = cVar.hVn;
        cVar.hVn = i + 1;
        return i;
    }

    static /* synthetic */ int x(c cVar) {
        int i = cVar.hVn;
        cVar.hVn = i - 1;
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
        this.hVr = str;
    }

    public void a(ForumWriteData forumWriteData) {
        this.hMA = forumWriteData;
    }

    public void xM(String str) {
        if ("3".equals(str)) {
            this.writeCallFrom = "1";
        } else {
            this.writeCallFrom = str;
        }
        this.hVw = str;
    }

    private void initView() {
        if (this.mContext != null && this.mContext.getPageActivity() != null && this.mRootView != null) {
            this.hUW = LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.bottom_write_thread, (ViewGroup) null);
            this.hVa = (LinearLayout) this.hUW.findViewById(e.g.home_write_article);
            this.hVb = (TbImageView) this.hUW.findViewById(e.g.home_write_article_icon);
            this.hVc = (TextView) this.hUW.findViewById(e.g.home_write_article_title);
            this.hUX = (LinearLayout) this.hUW.findViewById(e.g.home_write_photo);
            this.hUY = (TbImageView) this.hUW.findViewById(e.g.home_write_photo_icon);
            this.hUZ = (TextView) this.hUW.findViewById(e.g.home_write_photo_title);
            this.hVd = (LinearLayout) this.hUW.findViewById(e.g.home_write_album);
            this.hVe = (TbImageView) this.hUW.findViewById(e.g.home_write_album_icon);
            this.hVf = (TextView) this.hUW.findViewById(e.g.home_write_album_title);
            this.hVg = (LinearLayout) this.hUW.findViewById(e.g.home_write_live);
            this.hVh = (TbImageView) this.hUW.findViewById(e.g.home_write_live_icon);
            this.hVi = (TextView) this.hUW.findViewById(e.g.home_write_live_title);
            this.hVj = (ImageView) this.hUW.findViewById(e.g.write_close_view);
            this.hUV = this.hUW.findViewById(e.g.view_background);
            this.hVk = (GridLayout) this.hUW.findViewById(e.g.type_container);
            this.hVk.setMeasureAllChild(true);
            this.hVk.setVerNum(1);
            bOy();
            this.hVq.add(this.hVa);
            this.hVq.add(this.hUX);
            this.hVq.add(this.hVd);
            this.hVq.add(this.hVg);
            this.hUW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.bgColor != 0) {
                        UtilHelper.setNavigationBarBackground(c.this.mContext.getPageActivity(), c.this.bgColor);
                    }
                    c.this.ca(c.this.hVk);
                }
            });
            this.hVb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.xN(c.this.hVr);
                }
            });
            this.hUY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.bOB();
                    TiebaStatic.log(new am("c12611").aB("obj_locate", c.this.hVw).y("obj_type", 2));
                    if (c.this.hMA == null) {
                        c.this.hMA = new ForumWriteData("0", null, null, null);
                    }
                    c.this.hMA.mFrom = c.this.mFrom;
                    c.this.hMA.writeCallFrom = c.this.writeCallFrom;
                    e.a(c.this.mContext, "", c.this.hMA);
                }
            });
            this.hVe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.6
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
                    if (c.this.hMA != null) {
                        String str6 = c.this.hMA.forumId;
                        String str7 = c.this.hMA.forumName;
                        postPrefixData = c.this.hMA.prefixData;
                        antiData = c.this.hMA.antiData;
                        int i3 = c.this.hMA.forumLevel;
                        String str8 = c.this.hMA.avatar;
                        int i4 = c.this.hMA.privateThread;
                        String str9 = c.this.hMA.firstDir;
                        str = c.this.hMA.secondDir;
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
                    TiebaStatic.log(new am("c12611").aB("obj_locate", c.this.hVw).y("obj_type", 3));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.mContext.getPageActivity(), 0, str5, str4, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", c.this.mFrom);
                    writeActivityConfig.setCallFrom(c.this.writeCallFrom);
                    writeActivityConfig.setForumLevel(i2);
                    writeActivityConfig.setForumAvatar(str3);
                    writeActivityConfig.setAlbumThread(1);
                    writeActivityConfig.setPrivateThread(i);
                    writeActivityConfig.setForumDir(str2, str);
                    if (!StringUtils.isNull(c.this.hVr)) {
                        writeActivityConfig.setTitle(c.this.hVr, true);
                    }
                    if (!c.a(c.this.mContext.getPageActivity(), writeActivityConfig)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                    }
                }
            });
            this.hVh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.7
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
                    if (c.this.hMA != null) {
                        str3 = c.this.hMA.forumId;
                        str = c.this.hMA.forumName;
                        str2 = c.this.hMA.specialForumType;
                    } else {
                        str = null;
                    }
                    TiebaStatic.log(new am("c12611").aB("obj_locate", c.this.hVw).y("obj_type", 4));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(TbadkCoreApplication.getInst().getApplicationContext(), str, str3, TbadkCoreApplication.getCurrentAccount(), str2)));
                }
            });
            onChangeSkinType();
            this.hVs = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.write_thread_black_anim);
            this.hVs.setFillAfter(true);
            this.hVt = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.write_thread_black_hide_anim);
            this.hVt.setFillAfter(true);
            this.hVu = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.write_tab_bg_anim);
            this.hVu.setFillAfter(true);
            this.hVv = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.home_write_bgout);
            this.hVv.setFillAfter(true);
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
        b(this.hVb, aO);
        b(this.hUY, aO);
        b(this.hVe, aO);
        b(this.hVh, aO);
        int aQ = l.aQ(this.mContext.getPageActivity());
        ViewGroup.LayoutParams layoutParams = this.hVk.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = aQ / 5;
            this.hVk.setLayoutParams(layoutParams);
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
            c.this.hVa.setVisibility(4);
            c.this.hUX.setVisibility(4);
            c.this.hVd.setVisibility(4);
            c.this.hVg.setVisibility(4);
            c.this.hVj.setVisibility(4);
            c.this.hUV.setVisibility(4);
            if (this.mView != null) {
                this.mView.setVisibility(8);
            }
            if (c.this.hUW.getParent() == c.this.mRootView) {
                c.this.mRootView.removeView(c.this.hUW);
            }
            c.this.hVm = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921390, false));
        }
    }

    private void bOz() {
        if (this.mFrom == "main_tab" && com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") != 0 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_write", 0L)) {
            this.hVx = com.baidu.tbadk.core.bigday.b.yf().cA(3);
            if (this.hVx != null && this.hVx.ye()) {
                if (this.hVy == null) {
                    this.hVy = (TbImageView) this.hUW.findViewById(e.g.write_tab_bigday_img);
                    this.hVy.startLoad(this.hVx.imgUrl, 41, false);
                    this.hVy.setVisibility(0);
                    this.hVy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.9
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (c.this.hVx != null && !StringUtils.isNULL(c.this.hVx.aoW)) {
                                ay.Es().c(c.this.mContext, new String[]{c.this.hVx.aoW});
                                TiebaStatic.log(new am("c13114").i(VideoPlayActivityConfig.OBJ_ID, c.this.hVx.aoY).aB("obj_to", c.this.hVx.aoW));
                                c.this.bOB();
                            }
                        }
                    });
                    this.hVy.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.write.c.10
                        @Override // com.baidu.tbadk.widget.TbImageView.b
                        public void a(TbImageView tbImageView, Canvas canvas) {
                            if (c.this.hVy.getBdImage() == null && c.this.hVx != null && !ao.isEmpty(c.this.hVx.imgUrl)) {
                                c.this.hVy.startLoad(c.this.hVx.imgUrl, 41, false);
                            }
                        }

                        @Override // com.baidu.tbadk.widget.TbImageView.b
                        public void b(TbImageView tbImageView, Canvas canvas) {
                        }
                    });
                    ViewGroup.LayoutParams layoutParams = this.hVy.getLayoutParams();
                    if (layoutParams instanceof RelativeLayout.LayoutParams) {
                        int aO = (int) (l.aO(this.mContext.getContext()) * 0.546d);
                        layoutParams.width = aO;
                        layoutParams.height = aO;
                        ((RelativeLayout.LayoutParams) layoutParams).topMargin = l.aQ(this.mContext.getContext()) / 5;
                        this.hVy.setLayoutParams(layoutParams);
                    }
                }
                if (this.hVz == null) {
                    this.hVz = this.hUW.findViewById(e.g.write_tab_bigday_close);
                    this.hVz.setVisibility(0);
                    this.hVz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.11
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            c.this.hVz.clearAnimation();
                            c.this.hVy.clearAnimation();
                            c.this.hVz.setVisibility(8);
                            c.this.hVy.setVisibility(8);
                            Calendar calendar = Calendar.getInstance();
                            calendar.set(11, 23);
                            calendar.set(12, 59);
                            calendar.set(13, 59);
                            calendar.set(14, 0);
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_bigday_next_showtime_write", calendar.getTimeInMillis());
                        }
                    });
                }
                this.hVy.startAnimation(this.hVu);
                this.hVz.startAnimation(this.hVu);
                TiebaStatic.log(new am("c13113").i(VideoPlayActivityConfig.OBJ_ID, this.hVx.aoY).aB("obj_to", this.hVx.aoW));
            }
        }
    }

    public void ow(boolean z) {
        if (!this.hVm && this.hVo && this.hVp && this.mRootView != null) {
            bOz();
            this.hVj.clearAnimation();
            this.hVm = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921390, true));
            if (this.hUW.getParent() == null) {
                com.baidu.tbadk.k.d.ad(this.mRootView).a(this.mRootView, this.hUW, z);
            }
            this.hVk.setVisibility(0);
            this.hUV.setVisibility(0);
            this.hUV.clearAnimation();
            this.hUV.startAnimation(this.hVu);
            this.hVj.setVisibility(0);
            this.hVj.startAnimation(this.hVs);
            bOA();
            TiebaStatic.log(new am("c12052").aB("obj_locate", this.hVw));
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
        final int size = this.hVq.size();
        this.hVo = false;
        this.hVn = 0;
        for (int i = 0; i < size; i++) {
            final View view = this.hVq.get(i);
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
                            if (c.this.hVn == size) {
                                c.this.hVo = true;
                                c.this.hVn = 0;
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
        ca(this.hVk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ca(View view) {
        if (this.hVo && this.hVp) {
            if (this.hVl != null) {
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.hVl);
            }
            this.hUV.clearAnimation();
            this.hUV.startAnimation(this.hVv);
            if (this.hVz != null && this.hVy != null && this.hVz.getVisibility() == 0 && this.hVy.getVisibility() == 0) {
                this.hVz.clearAnimation();
                this.hVy.clearAnimation();
                this.hVy.startAnimation(this.hVv);
                this.hVz.startAnimation(this.hVv);
            }
            this.hVj.clearAnimation();
            this.hVj.startAnimation(this.hVt);
            bOC();
            this.hVl = new a(view);
            com.baidu.adp.lib.g.e.jG().postDelayed(this.hVl, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOB() {
        this.hVo = true;
        this.hVp = true;
        if (this.hVl != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.hVl);
        }
        if (this.hVl == null) {
            this.hVl = new a(this.hVk);
        }
        com.baidu.adp.lib.g.e.jG().postDelayed(this.hVl, 500L);
    }

    private void bOC() {
        clearAnimation();
        int size = this.hVq.size();
        this.hVn = size;
        this.hVp = false;
        int i = size - 1;
        for (int i2 = 0; i2 < size; i2++) {
            final View view = this.hVq.get(i);
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
                            if (c.this.hVn == 1) {
                                c.this.hVp = true;
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
        this.hVa.clearAnimation();
        this.hUX.clearAnimation();
        this.hVg.clearAnimation();
        this.hVd.clearAnimation();
    }

    public void onChangeSkinType() {
        al.j(this.hUV, e.d.cp_bg_line_d_alpha98);
        al.c(this.hUY, e.f.icon_post_type_photograph_n);
        al.c(this.hVb, e.f.icon_post_type_text_n);
        al.c(this.hVe, e.f.icon_post_type_image_n);
        al.c(this.hVh, e.f.icon_post_type_live_n);
        al.c(this.hVj, e.f.icon_tabbar_add_s);
        al.h(this.hUZ, e.d.cp_cont_b);
        al.h(this.hVc, e.d.cp_cont_b);
        al.h(this.hVf, e.d.cp_cont_b);
        al.h(this.hVi, e.d.cp_cont_b);
    }

    public void onDestroy() {
        if (this.hUW != null && this.hUW.getParent() == this.mRootView) {
            this.mRootView.removeView(this.hUW);
        }
        if (this.hVl != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.hVl);
            this.hVl = null;
        }
        this.hVq.clear();
    }

    public boolean isShowing() {
        return this.hVm;
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
        if (this.hMA == null) {
            str2 = "";
            str3 = "";
            i = 0;
            str4 = null;
            i2 = -1;
            str5 = null;
            str6 = "0";
        } else {
            String str7 = this.hMA.forumId;
            String str8 = this.hMA.forumName;
            postPrefixData = this.hMA.prefixData;
            antiData = this.hMA.antiData;
            int i3 = this.hMA.forumLevel;
            String str9 = this.hMA.avatar;
            int i4 = this.hMA.privateThread;
            String str10 = this.hMA.firstDir;
            str2 = this.hMA.secondDir;
            str3 = str10;
            i = i4;
            str4 = str9;
            i2 = i3;
            str5 = str8;
            str6 = str7;
        }
        TiebaStatic.log(new am("c12611").aB("obj_locate", this.hVw).y("obj_type", 1));
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
