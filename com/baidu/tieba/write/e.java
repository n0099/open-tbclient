package com.baidu.tieba.write;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaMasterLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.b.a;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.FRSRefreshButton;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.GridLayout;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.write.f;
import java.util.Calendar;
/* loaded from: classes.dex */
public class e {
    private com.baidu.tbadk.o.a.a Qn;
    private int bgColor;
    private FRSRefreshButton eYV;
    private ForumWriteData jdf;
    private a jlS;
    private boolean jlT;
    private f jlU;
    private String jlV;
    private String jlW;
    private Animation jlX;
    private com.baidu.tbadk.core.bigday.a jlY;
    private View.OnClickListener jlZ;
    private f.a jma;
    private TbPageContext mContext;
    private String mFrom;
    private ViewGroup mParentView;
    private int mSkinType;
    private String writeCallFrom;

    public e(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this(tbPageContext, viewGroup, str, 1);
    }

    public e(TbPageContext tbPageContext, ViewGroup viewGroup, String str, int i) {
        this.jlT = false;
        this.mSkinType = 3;
        this.jlV = "";
        this.mFrom = AlbumActivityConfig.FROM_WRITE;
        this.jlW = "0";
        this.jlZ = new View.OnClickListener() { // from class: com.baidu.tieba.write.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.bgColor != 0) {
                    UtilHelper.setNavigationBarBackground(e.this.mContext.getPageActivity(), e.this.bgColor);
                }
                e.this.qW(true);
            }
        };
        this.jma = new f.a() { // from class: com.baidu.tieba.write.e.4
            @Override // com.baidu.tieba.write.f.a
            public void Bb(int i2) {
                if (i2 == 1) {
                    e.this.jlT = true;
                    if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (e.this.jlU instanceof c)) {
                        if (e.this.Qn == null) {
                            e.this.Qn = new com.baidu.tbadk.o.a.a("anim_switch_sendthread_maintab");
                        }
                        e.this.Qn.apt();
                    }
                } else if (i2 == 2) {
                    if (e.this.Qn != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (e.this.jlU instanceof c)) {
                        e.this.Qn.apu();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 0));
                } else if (i2 == 4) {
                    e.this.jlT = false;
                    if (e.this.jlS.mRootView.getParent() == e.this.mParentView && e.this.mParentView != null && e.this.jlS.mRootView != null && e.this.mParentView.indexOfChild(e.this.jlS.mRootView) > 0) {
                        e.this.mParentView.removeView(e.this.jlS.mRootView);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 1));
                }
            }
        };
        this.mContext = tbPageContext;
        this.mParentView = viewGroup;
        this.mFrom = str;
        this.jlS = new a(tbPageContext.getPageActivity());
        initView();
        this.jlU = g.a(i, tbPageContext.getPageActivity(), this.jlS);
        this.jlU.a(this.jma);
    }

    public void Em(String str) {
        if (str == null) {
            str = "";
        }
        this.jlV = str;
    }

    public void a(ForumWriteData forumWriteData) {
        this.jdf = forumWriteData;
    }

    public void En(String str) {
        if ("3".equals(str)) {
            this.writeCallFrom = "1";
        } else {
            this.writeCallFrom = str;
        }
        this.jlW = str;
    }

    private void initView() {
        this.jlS.cop();
        this.jlS.jmj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.Eo(e.this.jlV);
            }
        });
        this.jlS.jmg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.con();
            }
        });
        this.jlS.jmm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.com();
            }
        });
        this.jlS.jmq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.col();
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.jlX = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.write_tab_bg_anim);
        this.jlX.setFillAfter(true);
    }

    public boolean isShowing() {
        return this.jlT;
    }

    public void AZ(int i) {
        this.bgColor = i;
    }

    public void a(boolean z, View view, View view2) {
        if (this.mParentView != null) {
            coo();
            if (this.jlS.mRootView.getParent() == null) {
                com.baidu.tbadk.m.e.aY(this.mParentView).a(this.mParentView, this.jlS.mRootView, z);
            }
            this.jlU.b(view, view2);
            this.jlU.show();
            TiebaStatic.log(new am("c12052").bJ("obj_locate", this.jlW));
            if (j.la()) {
                String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_baidu_sim_card_writting_tip", "");
                if (!ap.isEmpty(string)) {
                    BdToast.b(this.mContext.getContext(), string).abh();
                    com.baidu.tbadk.core.sharedPref.b.getInstance().remove("key_baidu_sim_card_writting_tip");
                }
            }
        }
    }

    public void Ba(int i) {
        this.jlS.jms.setIconFade(i);
    }

    public void qW(boolean z) {
        this.jlU.bA(z);
        if (!z) {
            this.jlS.jms.anN();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            this.jlS.jms.onChangeSkinType(i);
            al.a(this.jlS.jmw, d.i.bottom_bar_bg);
            al.k(this.jlS.jme, d.f.write_tab_background);
            al.c(this.jlS.jmg, d.f.icon_post_type_photograph_n);
            al.c(this.jlS.jmj, d.f.icon_post_type_text_n);
            al.c(this.jlS.jmm, d.f.icon_post_type_image_n);
            al.c(this.jlS.jmq, d.f.icon_post_type_live_n);
            al.j(this.jlS.jmh, d.C0236d.cp_cont_b);
            al.j(this.jlS.jmk, d.C0236d.cp_cont_b);
            al.j(this.jlS.jmn, d.C0236d.cp_cont_b);
            al.j(this.jlS.jmr, d.C0236d.cp_cont_b);
        }
    }

    public void onDestroy() {
        if (this.jlS.mRootView != null && this.jlS.mRootView.getParent() == this.mParentView) {
            this.mParentView.removeView(this.jlS.mRootView);
        }
        this.jlU.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void col() {
        String str;
        String str2 = null;
        qW(false);
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            aVar.setAutoNight(false);
            aVar.gC(d.j.prompt);
            aVar.ly(this.mContext.getResources().getString(d.j.disallow_open_live_by_android_v5_0));
            aVar.dx(true);
            aVar.dw(true);
            aVar.a(d.j.know, new a.b() { // from class: com.baidu.tieba.write.e.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.mContext).aaZ();
        } else if (com.baidu.tbadk.plugins.c.b(this.mContext, "com.baidu.tieba.pluginAla")) {
            MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
            String str3 = "0";
            com.baidu.adp.lib.d.a.iW().af(false);
            if (this.jdf != null) {
                str3 = this.jdf.forumId;
                str = this.jdf.forumName;
                str2 = this.jdf.specialForumType;
            } else {
                str = null;
            }
            TiebaStatic.log(new am("c12611").bJ("obj_locate", this.jlW).T("obj_type", 4));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(TbadkCoreApplication.getInst().getApplicationContext(), str, str3, TbadkCoreApplication.getCurrentAccount(), str2)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void com() {
        String str;
        String str2;
        int i;
        String str3;
        int i2;
        String str4;
        String str5;
        qW(false);
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.jdf == null) {
            str = "";
            str2 = "";
            i = 0;
            str3 = null;
            i2 = -1;
            str4 = null;
            str5 = "0";
        } else {
            String str6 = this.jdf.forumId;
            String str7 = this.jdf.forumName;
            postPrefixData = this.jdf.prefixData;
            antiData = this.jdf.antiData;
            int i3 = this.jdf.forumLevel;
            String str8 = this.jdf.avatar;
            int i4 = this.jdf.privateThread;
            String str9 = this.jdf.firstDir;
            str = this.jdf.secondDir;
            str2 = str9;
            i = i4;
            str3 = str8;
            i2 = i3;
            str4 = str7;
            str5 = str6;
        }
        TiebaStatic.log(new am("c12611").bJ("obj_locate", this.jlW).T("obj_type", 3));
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mContext.getPageActivity(), 0, str5, str4, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom(this.writeCallFrom);
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str3);
        writeActivityConfig.setAlbumThread(1);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setProfessionZone(this.jdf != null ? this.jdf.defaultZone : -1);
        writeActivityConfig.setForumDir(str2, str);
        if (!StringUtils.isNull(this.jlV)) {
            writeActivityConfig.setTitle(this.jlV, true);
        }
        if (!a(this.mContext.getPageActivity(), writeActivityConfig)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void con() {
        qW(false);
        TiebaStatic.log(new am("c12611").bJ("obj_locate", this.jlW).T("obj_type", 2));
        if (this.jdf == null) {
            this.jdf = new ForumWriteData("0", null, null, null);
        }
        this.jdf.mFrom = this.mFrom;
        this.jdf.writeCallFrom = this.writeCallFrom;
        i.a(this.mContext, "", this.jdf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eo(String str) {
        String str2;
        String str3;
        int i;
        String str4;
        int i2;
        String str5;
        String str6;
        qW(false);
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.jdf == null) {
            str2 = "";
            str3 = "";
            i = 0;
            str4 = null;
            i2 = -1;
            str5 = null;
            str6 = "0";
        } else {
            String str7 = this.jdf.forumId;
            String str8 = this.jdf.forumName;
            postPrefixData = this.jdf.prefixData;
            antiData = this.jdf.antiData;
            int i3 = this.jdf.forumLevel;
            String str9 = this.jdf.avatar;
            int i4 = this.jdf.privateThread;
            String str10 = this.jdf.firstDir;
            str2 = this.jdf.secondDir;
            str3 = str10;
            i = i4;
            str4 = str9;
            i2 = i3;
            str5 = str8;
            str6 = str7;
        }
        TiebaStatic.log(new am("c12611").bJ("obj_locate", this.jlW).T("obj_type", 1));
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
        writeActivityConfig.setProfessionZone(this.jdf != null ? this.jdf.defaultZone : -1);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
    }

    private void coo() {
        if (this.mFrom == "main_tab" && com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") != 0 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_write", 0L)) {
            this.jlY = com.baidu.tbadk.core.bigday.b.WM().gc(3);
            if (this.jlY != null && this.jlY.WL()) {
                this.jlS.jmu.startLoad(this.jlY.imgUrl, 41, false);
                this.jlS.jmu.setVisibility(0);
                this.jlS.jmu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.jlY != null && !StringUtils.isNULL(e.this.jlY.bvG)) {
                            ba.adD().c(e.this.mContext, new String[]{e.this.jlY.bvG});
                            TiebaStatic.log(new am("c13114").k(VideoPlayActivityConfig.OBJ_ID, e.this.jlY.bvI).bJ("obj_to", e.this.jlY.bvG));
                            e.this.qW(false);
                        }
                    }
                });
                this.jlS.jmu.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.write.e.11
                    @Override // com.baidu.tbadk.widget.TbImageView.b
                    public void a(TbImageView tbImageView, Canvas canvas) {
                        if (e.this.jlS.jmu.getBdImage() == null && e.this.jlY != null && !ap.isEmpty(e.this.jlY.imgUrl)) {
                            e.this.jlS.jmu.startLoad(e.this.jlY.imgUrl, 41, false);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.b
                    public void b(TbImageView tbImageView, Canvas canvas) {
                    }
                });
                ViewGroup.LayoutParams layoutParams = this.jlS.jmu.getLayoutParams();
                if (layoutParams instanceof RelativeLayout.LayoutParams) {
                    int aO = (int) (l.aO(this.mContext.getContext()) * 0.546d);
                    layoutParams.width = aO;
                    layoutParams.height = aO;
                    ((RelativeLayout.LayoutParams) layoutParams).topMargin = l.aQ(this.mContext.getContext()) / 5;
                    this.jlS.jmu.setLayoutParams(layoutParams);
                }
                this.jlS.jmv.setVisibility(0);
                this.jlS.jmv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.jlS.jmv.clearAnimation();
                        e.this.jlS.jmu.clearAnimation();
                        e.this.jlS.jmv.setVisibility(8);
                        e.this.jlS.jmu.setVisibility(8);
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(11, 23);
                        calendar.set(12, 59);
                        calendar.set(13, 59);
                        calendar.set(14, 0);
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_bigday_next_showtime_write", calendar.getTimeInMillis());
                    }
                });
                this.jlS.jmu.startAnimation(this.jlX);
                this.jlS.jmv.startAnimation(this.jlX);
                TiebaStatic.log(new am("c13113").k(VideoPlayActivityConfig.OBJ_ID, this.jlY.bvI).bJ("obj_to", this.jlY.bvG));
            }
        }
    }

    private static boolean a(Activity activity, final WriteActivityConfig writeActivityConfig) {
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.adQ();
        aVar.e(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
        aVar.a(new a.InterfaceC0193a() { // from class: com.baidu.tieba.write.e.3
            @Override // com.baidu.tbadk.core.util.b.a.InterfaceC0193a
            public void adR() {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, WriteActivityConfig.this));
            }
        });
        return aVar.Y(activity);
    }

    public void b(FRSRefreshButton fRSRefreshButton) {
        this.eYV = fRSRefreshButton;
    }

    /* loaded from: classes.dex */
    public class a {
        public View jmd;
        public View jme;
        public LinearLayout jmf;
        public TbImageView jmg;
        public TextView jmh;
        public LinearLayout jmi;
        public TbImageView jmj;
        public TextView jmk;
        public LinearLayout jml;
        public TbImageView jmm;
        public TextView jmn;
        public LinearLayout jmo;
        public TbImageView jmq;
        public TextView jmr;
        public OvalActionButton jms;
        public GridLayout jmt;
        public TbImageView jmu;
        public View jmv;
        public TBLottieAnimationView jmw;
        public View mRootView;

        public a(Context context) {
            if (context != null) {
                this.mRootView = LayoutInflater.from(e.this.mContext.getPageActivity()).inflate(d.h.bottom_write_thread, (ViewGroup) null);
                this.jmi = (LinearLayout) this.mRootView.findViewById(d.g.home_write_article);
                this.jmj = (TbImageView) this.mRootView.findViewById(d.g.home_write_article_icon);
                this.jmk = (TextView) this.mRootView.findViewById(d.g.home_write_article_title);
                this.jmf = (LinearLayout) this.mRootView.findViewById(d.g.home_write_photo);
                this.jmg = (TbImageView) this.mRootView.findViewById(d.g.home_write_photo_icon);
                this.jmh = (TextView) this.mRootView.findViewById(d.g.home_write_photo_title);
                this.jml = (LinearLayout) this.mRootView.findViewById(d.g.home_write_album);
                this.jmm = (TbImageView) this.mRootView.findViewById(d.g.home_write_album_icon);
                this.jmn = (TextView) this.mRootView.findViewById(d.g.home_write_album_title);
                this.jmo = (LinearLayout) this.mRootView.findViewById(d.g.home_write_live);
                this.jmq = (TbImageView) this.mRootView.findViewById(d.g.home_write_live_icon);
                this.jmr = (TextView) this.mRootView.findViewById(d.g.home_write_live_title);
                this.jms = (OvalActionButton) this.mRootView.findViewById(d.g.write_close_view);
                this.jme = this.mRootView.findViewById(d.g.view_background_white);
                this.jmd = this.mRootView.findViewById(d.g.view_background_translate);
                this.jmt = (GridLayout) this.mRootView.findViewById(d.g.type_container);
                this.jmt.setMeasureAllChild(true);
                this.jmt.setVerNum(1);
                this.jmu = (TbImageView) this.mRootView.findViewById(d.g.write_tab_bigday_img);
                this.jmv = this.mRootView.findViewById(d.g.write_tab_bigday_close);
                this.jmw = (TBLottieAnimationView) this.mRootView.findViewById(d.g.bottom_bar_background);
                this.jmw.setSpeed(1.2f);
                cor();
            }
        }

        public void cop() {
            this.jmd.setOnClickListener(e.this.jlZ);
        }

        public void coq() {
            this.jmd.setOnClickListener(null);
            this.jmd.setClickable(false);
        }

        private void cor() {
            int aO = l.aO(e.this.mContext.getPageActivity());
            int i = (int) (0.15555556f * aO);
            c(this.jmj, i);
            c(this.jmg, i);
            c(this.jmm, i);
            c(this.jmq, i);
            float h = (aO * 1.0f) / l.h(TbadkCoreApplication.getInst(), d.e.tbds1080);
            ViewGroup.LayoutParams layoutParams = this.jmt.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = (int) (l.h(TbadkCoreApplication.getInst(), d.e.tbds418) * h);
                this.jmt.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.jme.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                int h2 = (int) (l.h(TbadkCoreApplication.getInst(), d.e.tbds912) * h);
                ((RelativeLayout.LayoutParams) layoutParams2).height = h2 <= 0 ? 912 : h2;
                this.jme.setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = this.jmw.getLayoutParams();
            if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams3).height = (int) ((h * l.h(TbadkCoreApplication.getInst(), d.e.tbds800)) - ((l.h(TbadkCoreApplication.getInst(), d.e.tbds135) * h) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()));
                this.jmw.setLayoutParams(layoutParams3);
            }
        }

        private void c(TbImageView tbImageView, int i) {
            if (tbImageView != null && i > 0) {
                ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
                layoutParams.width = i;
                layoutParams.height = i;
                tbImageView.setLayoutParams(layoutParams);
            }
        }
    }
}
