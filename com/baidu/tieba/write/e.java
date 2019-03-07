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
    private ForumWriteData jcL;
    private boolean jlA;
    private f jlB;
    private String jlC;
    private String jlD;
    private Animation jlE;
    private com.baidu.tbadk.core.bigday.a jlF;
    private View.OnClickListener jlG;
    private f.a jlH;
    private a jlz;
    private TbPageContext mContext;
    private String mFrom;
    private ViewGroup mParentView;
    private int mSkinType;
    private String writeCallFrom;

    public e(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this(tbPageContext, viewGroup, str, 1);
    }

    public e(TbPageContext tbPageContext, ViewGroup viewGroup, String str, int i) {
        this.jlA = false;
        this.mSkinType = 3;
        this.jlC = "";
        this.mFrom = AlbumActivityConfig.FROM_WRITE;
        this.jlD = "0";
        this.jlG = new View.OnClickListener() { // from class: com.baidu.tieba.write.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.bgColor != 0) {
                    UtilHelper.setNavigationBarBackground(e.this.mContext.getPageActivity(), e.this.bgColor);
                }
                e.this.qW(true);
            }
        };
        this.jlH = new f.a() { // from class: com.baidu.tieba.write.e.4
            @Override // com.baidu.tieba.write.f.a
            public void Ba(int i2) {
                if (i2 == 1) {
                    e.this.jlA = true;
                    if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (e.this.jlB instanceof c)) {
                        if (e.this.Qn == null) {
                            e.this.Qn = new com.baidu.tbadk.o.a.a("anim_switch_sendthread_maintab");
                        }
                        e.this.Qn.apt();
                    }
                } else if (i2 == 2) {
                    if (e.this.Qn != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (e.this.jlB instanceof c)) {
                        e.this.Qn.apu();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 0));
                } else if (i2 == 4) {
                    e.this.jlA = false;
                    if (e.this.jlz.mRootView.getParent() == e.this.mParentView && e.this.mParentView != null && e.this.jlz.mRootView != null && e.this.mParentView.indexOfChild(e.this.jlz.mRootView) > 0) {
                        e.this.mParentView.removeView(e.this.jlz.mRootView);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 1));
                }
            }
        };
        this.mContext = tbPageContext;
        this.mParentView = viewGroup;
        this.mFrom = str;
        this.jlz = new a(tbPageContext.getPageActivity());
        initView();
        this.jlB = g.a(i, tbPageContext.getPageActivity(), this.jlz);
        this.jlB.a(this.jlH);
    }

    public void Ej(String str) {
        if (str == null) {
            str = "";
        }
        this.jlC = str;
    }

    public void a(ForumWriteData forumWriteData) {
        this.jcL = forumWriteData;
    }

    public void Ek(String str) {
        if ("3".equals(str)) {
            this.writeCallFrom = "1";
        } else {
            this.writeCallFrom = str;
        }
        this.jlD = str;
    }

    private void initView() {
        this.jlz.cof();
        this.jlz.jlQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.El(e.this.jlC);
            }
        });
        this.jlz.jlN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.cod();
            }
        });
        this.jlz.jlT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.coc();
            }
        });
        this.jlz.jlW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.cob();
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.jlE = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.write_tab_bg_anim);
        this.jlE.setFillAfter(true);
    }

    public boolean isShowing() {
        return this.jlA;
    }

    public void AY(int i) {
        this.bgColor = i;
    }

    public void a(boolean z, View view, View view2) {
        if (this.mParentView != null) {
            coe();
            if (this.jlz.mRootView.getParent() == null) {
                com.baidu.tbadk.m.e.aY(this.mParentView).a(this.mParentView, this.jlz.mRootView, z);
            }
            this.jlB.b(view, view2);
            this.jlB.show();
            TiebaStatic.log(new am("c12052").bJ("obj_locate", this.jlD));
            if (j.la()) {
                String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_baidu_sim_card_writting_tip", "");
                if (!ap.isEmpty(string)) {
                    BdToast.b(this.mContext.getContext(), string).abh();
                    com.baidu.tbadk.core.sharedPref.b.getInstance().remove("key_baidu_sim_card_writting_tip");
                }
            }
        }
    }

    public void AZ(int i) {
        this.jlz.jlY.setIconFade(i);
    }

    public void qW(boolean z) {
        this.jlB.bA(z);
        if (!z) {
            this.jlz.jlY.anN();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            this.jlz.jlY.onChangeSkinType(i);
            al.a(this.jlz.jmc, d.i.bottom_bar_bg);
            al.k(this.jlz.jlL, d.f.write_tab_background);
            al.c(this.jlz.jlN, d.f.icon_post_type_photograph_n);
            al.c(this.jlz.jlQ, d.f.icon_post_type_text_n);
            al.c(this.jlz.jlT, d.f.icon_post_type_image_n);
            al.c(this.jlz.jlW, d.f.icon_post_type_live_n);
            al.j(this.jlz.jlO, d.C0236d.cp_cont_b);
            al.j(this.jlz.jlR, d.C0236d.cp_cont_b);
            al.j(this.jlz.jlU, d.C0236d.cp_cont_b);
            al.j(this.jlz.jlX, d.C0236d.cp_cont_b);
        }
    }

    public void onDestroy() {
        if (this.jlz.mRootView != null && this.jlz.mRootView.getParent() == this.mParentView) {
            this.mParentView.removeView(this.jlz.mRootView);
        }
        this.jlB.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cob() {
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
            if (this.jcL != null) {
                str3 = this.jcL.forumId;
                str = this.jcL.forumName;
                str2 = this.jcL.specialForumType;
            } else {
                str = null;
            }
            TiebaStatic.log(new am("c12611").bJ("obj_locate", this.jlD).T("obj_type", 4));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(TbadkCoreApplication.getInst().getApplicationContext(), str, str3, TbadkCoreApplication.getCurrentAccount(), str2)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coc() {
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
        if (this.jcL == null) {
            str = "";
            str2 = "";
            i = 0;
            str3 = null;
            i2 = -1;
            str4 = null;
            str5 = "0";
        } else {
            String str6 = this.jcL.forumId;
            String str7 = this.jcL.forumName;
            postPrefixData = this.jcL.prefixData;
            antiData = this.jcL.antiData;
            int i3 = this.jcL.forumLevel;
            String str8 = this.jcL.avatar;
            int i4 = this.jcL.privateThread;
            String str9 = this.jcL.firstDir;
            str = this.jcL.secondDir;
            str2 = str9;
            i = i4;
            str3 = str8;
            i2 = i3;
            str4 = str7;
            str5 = str6;
        }
        TiebaStatic.log(new am("c12611").bJ("obj_locate", this.jlD).T("obj_type", 3));
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mContext.getPageActivity(), 0, str5, str4, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom(this.writeCallFrom);
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str3);
        writeActivityConfig.setAlbumThread(1);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setProfessionZone(this.jcL != null ? this.jcL.defaultZone : -1);
        writeActivityConfig.setForumDir(str2, str);
        if (!StringUtils.isNull(this.jlC)) {
            writeActivityConfig.setTitle(this.jlC, true);
        }
        if (!a(this.mContext.getPageActivity(), writeActivityConfig)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cod() {
        qW(false);
        TiebaStatic.log(new am("c12611").bJ("obj_locate", this.jlD).T("obj_type", 2));
        if (this.jcL == null) {
            this.jcL = new ForumWriteData("0", null, null, null);
        }
        this.jcL.mFrom = this.mFrom;
        this.jcL.writeCallFrom = this.writeCallFrom;
        i.a(this.mContext, "", this.jcL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void El(String str) {
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
        if (this.jcL == null) {
            str2 = "";
            str3 = "";
            i = 0;
            str4 = null;
            i2 = -1;
            str5 = null;
            str6 = "0";
        } else {
            String str7 = this.jcL.forumId;
            String str8 = this.jcL.forumName;
            postPrefixData = this.jcL.prefixData;
            antiData = this.jcL.antiData;
            int i3 = this.jcL.forumLevel;
            String str9 = this.jcL.avatar;
            int i4 = this.jcL.privateThread;
            String str10 = this.jcL.firstDir;
            str2 = this.jcL.secondDir;
            str3 = str10;
            i = i4;
            str4 = str9;
            i2 = i3;
            str5 = str8;
            str6 = str7;
        }
        TiebaStatic.log(new am("c12611").bJ("obj_locate", this.jlD).T("obj_type", 1));
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
        writeActivityConfig.setProfessionZone(this.jcL != null ? this.jcL.defaultZone : -1);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
    }

    private void coe() {
        if (this.mFrom == "main_tab" && com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") != 0 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_write", 0L)) {
            this.jlF = com.baidu.tbadk.core.bigday.b.WM().gc(3);
            if (this.jlF != null && this.jlF.WL()) {
                this.jlz.jma.startLoad(this.jlF.imgUrl, 41, false);
                this.jlz.jma.setVisibility(0);
                this.jlz.jma.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.jlF != null && !StringUtils.isNULL(e.this.jlF.bvG)) {
                            ba.adD().c(e.this.mContext, new String[]{e.this.jlF.bvG});
                            TiebaStatic.log(new am("c13114").k(VideoPlayActivityConfig.OBJ_ID, e.this.jlF.bvI).bJ("obj_to", e.this.jlF.bvG));
                            e.this.qW(false);
                        }
                    }
                });
                this.jlz.jma.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.write.e.11
                    @Override // com.baidu.tbadk.widget.TbImageView.b
                    public void a(TbImageView tbImageView, Canvas canvas) {
                        if (e.this.jlz.jma.getBdImage() == null && e.this.jlF != null && !ap.isEmpty(e.this.jlF.imgUrl)) {
                            e.this.jlz.jma.startLoad(e.this.jlF.imgUrl, 41, false);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.b
                    public void b(TbImageView tbImageView, Canvas canvas) {
                    }
                });
                ViewGroup.LayoutParams layoutParams = this.jlz.jma.getLayoutParams();
                if (layoutParams instanceof RelativeLayout.LayoutParams) {
                    int aO = (int) (l.aO(this.mContext.getContext()) * 0.546d);
                    layoutParams.width = aO;
                    layoutParams.height = aO;
                    ((RelativeLayout.LayoutParams) layoutParams).topMargin = l.aQ(this.mContext.getContext()) / 5;
                    this.jlz.jma.setLayoutParams(layoutParams);
                }
                this.jlz.jmb.setVisibility(0);
                this.jlz.jmb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.jlz.jmb.clearAnimation();
                        e.this.jlz.jma.clearAnimation();
                        e.this.jlz.jmb.setVisibility(8);
                        e.this.jlz.jma.setVisibility(8);
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(11, 23);
                        calendar.set(12, 59);
                        calendar.set(13, 59);
                        calendar.set(14, 0);
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_bigday_next_showtime_write", calendar.getTimeInMillis());
                    }
                });
                this.jlz.jma.startAnimation(this.jlE);
                this.jlz.jmb.startAnimation(this.jlE);
                TiebaStatic.log(new am("c13113").k(VideoPlayActivityConfig.OBJ_ID, this.jlF.bvI).bJ("obj_to", this.jlF.bvG));
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
        public View jlK;
        public View jlL;
        public LinearLayout jlM;
        public TbImageView jlN;
        public TextView jlO;
        public LinearLayout jlP;
        public TbImageView jlQ;
        public TextView jlR;
        public LinearLayout jlS;
        public TbImageView jlT;
        public TextView jlU;
        public LinearLayout jlV;
        public TbImageView jlW;
        public TextView jlX;
        public OvalActionButton jlY;
        public GridLayout jlZ;
        public TbImageView jma;
        public View jmb;
        public TBLottieAnimationView jmc;
        public View mRootView;

        public a(Context context) {
            if (context != null) {
                this.mRootView = LayoutInflater.from(e.this.mContext.getPageActivity()).inflate(d.h.bottom_write_thread, (ViewGroup) null);
                this.jlP = (LinearLayout) this.mRootView.findViewById(d.g.home_write_article);
                this.jlQ = (TbImageView) this.mRootView.findViewById(d.g.home_write_article_icon);
                this.jlR = (TextView) this.mRootView.findViewById(d.g.home_write_article_title);
                this.jlM = (LinearLayout) this.mRootView.findViewById(d.g.home_write_photo);
                this.jlN = (TbImageView) this.mRootView.findViewById(d.g.home_write_photo_icon);
                this.jlO = (TextView) this.mRootView.findViewById(d.g.home_write_photo_title);
                this.jlS = (LinearLayout) this.mRootView.findViewById(d.g.home_write_album);
                this.jlT = (TbImageView) this.mRootView.findViewById(d.g.home_write_album_icon);
                this.jlU = (TextView) this.mRootView.findViewById(d.g.home_write_album_title);
                this.jlV = (LinearLayout) this.mRootView.findViewById(d.g.home_write_live);
                this.jlW = (TbImageView) this.mRootView.findViewById(d.g.home_write_live_icon);
                this.jlX = (TextView) this.mRootView.findViewById(d.g.home_write_live_title);
                this.jlY = (OvalActionButton) this.mRootView.findViewById(d.g.write_close_view);
                this.jlL = this.mRootView.findViewById(d.g.view_background_white);
                this.jlK = this.mRootView.findViewById(d.g.view_background_translate);
                this.jlZ = (GridLayout) this.mRootView.findViewById(d.g.type_container);
                this.jlZ.setMeasureAllChild(true);
                this.jlZ.setVerNum(1);
                this.jma = (TbImageView) this.mRootView.findViewById(d.g.write_tab_bigday_img);
                this.jmb = this.mRootView.findViewById(d.g.write_tab_bigday_close);
                this.jmc = (TBLottieAnimationView) this.mRootView.findViewById(d.g.bottom_bar_background);
                this.jmc.setSpeed(1.2f);
                coh();
            }
        }

        public void cof() {
            this.jlK.setOnClickListener(e.this.jlG);
        }

        public void cog() {
            this.jlK.setOnClickListener(null);
            this.jlK.setClickable(false);
        }

        private void coh() {
            int aO = l.aO(e.this.mContext.getPageActivity());
            int i = (int) (0.15555556f * aO);
            c(this.jlQ, i);
            c(this.jlN, i);
            c(this.jlT, i);
            c(this.jlW, i);
            float h = (aO * 1.0f) / l.h(TbadkCoreApplication.getInst(), d.e.tbds1080);
            ViewGroup.LayoutParams layoutParams = this.jlZ.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = (int) (l.h(TbadkCoreApplication.getInst(), d.e.tbds418) * h);
                this.jlZ.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.jlL.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                int h2 = (int) (l.h(TbadkCoreApplication.getInst(), d.e.tbds912) * h);
                ((RelativeLayout.LayoutParams) layoutParams2).height = h2 <= 0 ? 912 : h2;
                this.jlL.setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = this.jmc.getLayoutParams();
            if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams3).height = (int) ((h * l.h(TbadkCoreApplication.getInst(), d.e.tbds800)) - ((l.h(TbadkCoreApplication.getInst(), d.e.tbds135) * h) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()));
                this.jmc.setLayoutParams(layoutParams3);
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
