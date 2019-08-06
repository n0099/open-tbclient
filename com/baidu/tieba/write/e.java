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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.b.a;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.widget.FRSRefreshButton;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.GridLayout;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.write.f;
import java.util.Calendar;
/* loaded from: classes.dex */
public class e {
    private com.baidu.tbadk.p.a.a Om;
    private int bgColor;
    private FRSRefreshButton fuq;
    private ForumWriteData jDa;
    private a jMQ;
    private boolean jMR;
    private f jMS;
    private String jMT;
    private String jMU;
    private Animation jMV;
    private com.baidu.tbadk.core.bigday.a jMW;
    private View.OnClickListener jMX;
    private f.a jMY;
    private TbPageContext mContext;
    private String mFrom;
    private ViewGroup mParentView;
    private int mSkinType;
    private String writeCallFrom;

    public e(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this(tbPageContext, viewGroup, str, 1);
    }

    public e(TbPageContext tbPageContext, ViewGroup viewGroup, String str, int i) {
        this.jMR = false;
        this.mSkinType = 3;
        this.jMT = "";
        this.mFrom = AlbumActivityConfig.FROM_WRITE;
        this.jMU = "0";
        this.jMX = new View.OnClickListener() { // from class: com.baidu.tieba.write.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.bgColor != 0) {
                    UtilHelper.setNavigationBarBackground(e.this.mContext.getPageActivity(), e.this.bgColor);
                }
                e.this.sc(true);
            }
        };
        this.jMY = new f.a() { // from class: com.baidu.tieba.write.e.5
            @Override // com.baidu.tieba.write.f.a
            public void CP(int i2) {
                if (i2 == 1) {
                    e.this.jMR = true;
                    if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (e.this.jMS instanceof c)) {
                        if (e.this.Om == null) {
                            e.this.Om = new com.baidu.tbadk.p.a.a("anim_switch_sendthread_maintab");
                        }
                        e.this.Om.avD();
                    }
                } else if (i2 == 2) {
                    if (e.this.Om != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (e.this.jMS instanceof c)) {
                        e.this.Om.avE();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 0));
                } else if (i2 == 4) {
                    e.this.jMR = false;
                    if (e.this.jMQ.mRootView.getParent() == e.this.mParentView && e.this.mParentView != null && e.this.jMQ.mRootView != null && e.this.mParentView.indexOfChild(e.this.jMQ.mRootView) > 0) {
                        e.this.mParentView.removeView(e.this.jMQ.mRootView);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 1));
                }
            }
        };
        this.mContext = tbPageContext;
        this.mParentView = viewGroup;
        this.mFrom = str;
        this.jMQ = new a(tbPageContext.getPageActivity());
        initView();
        this.jMS = g.a(i, tbPageContext.getPageActivity(), this.jMQ);
        this.jMS.a(this.jMY);
    }

    public void GC(String str) {
        if (str == null) {
            str = "";
        }
        this.jMT = str;
    }

    public void a(ForumWriteData forumWriteData) {
        this.jDa = forumWriteData;
    }

    public void GD(String str) {
        if ("3".equals(str)) {
            this.writeCallFrom = "1";
        } else {
            this.writeCallFrom = str;
        }
        this.jMU = str;
    }

    private void initView() {
        this.jMQ.czU();
        this.jMQ.jNj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.GE(e.this.jMT);
            }
        });
        this.jMQ.jNg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.czR();
            }
        });
        this.jMQ.jNm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.czQ();
            }
        });
        this.jMQ.jNp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.czP();
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.jMV = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), R.anim.write_tab_bg_anim);
        this.jMV.setFillAfter(true);
    }

    public boolean isShowing() {
        return this.jMR;
    }

    public void CN(int i) {
        this.bgColor = i;
    }

    public void a(boolean z, View view, View view2) {
        if (this.mParentView != null) {
            czS();
            if (this.jMQ.mRootView.getParent() == null) {
                com.baidu.tbadk.m.e.bg(this.mParentView).a(this.mParentView, this.jMQ.mRootView, z);
            }
            this.jMS.b(view, view2);
            this.jMS.show();
            TiebaStatic.log(new an("c12052").bT("obj_locate", this.jMU));
            if (j.ke()) {
                String string = com.baidu.tbadk.core.sharedPref.b.ahQ().getString("key_baidu_sim_card_writting_tip", "");
                if (!aq.isEmpty(string)) {
                    BdToast.b(this.mContext.getContext(), string).agS();
                    com.baidu.tbadk.core.sharedPref.b.ahQ().remove("key_baidu_sim_card_writting_tip");
                }
            }
        }
    }

    public void CO(int i) {
        this.jMQ.jNr.setIconFade(i);
    }

    public void sc(boolean z) {
        this.jMS.bM(z);
        if (!z) {
            this.jMQ.jNr.atW();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            this.jMQ.jNr.onChangeSkinType(i);
            am.a(this.jMQ.jNv, (int) R.raw.bottom_bar_bg);
            am.k(this.jMQ.jNe, R.drawable.write_tab_background);
            am.c(this.jMQ.jNg, (int) R.drawable.icon_post_type_photograph_n);
            am.c(this.jMQ.jNj, (int) R.drawable.icon_post_type_text_n);
            am.c(this.jMQ.jNm, (int) R.drawable.icon_post_type_image_n);
            am.c(this.jMQ.jNp, (int) R.drawable.icon_post_type_live_n);
            am.j(this.jMQ.jNh, R.color.cp_cont_b);
            am.j(this.jMQ.jNk, R.color.cp_cont_b);
            am.j(this.jMQ.jNn, R.color.cp_cont_b);
            am.j(this.jMQ.jNq, R.color.cp_cont_b);
        }
    }

    public void onDestroy() {
        if (this.jMQ.mRootView != null && this.jMQ.mRootView.getParent() == this.mParentView) {
            this.mParentView.removeView(this.jMQ.mRootView);
        }
        this.jMS.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czP() {
        sc(false);
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            aVar.setAutoNight(false);
            aVar.ht(R.string.prompt);
            aVar.mO(this.mContext.getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.dX(true);
            aVar.dW(true);
            aVar.a(R.string.know, new a.b() { // from class: com.baidu.tieba.write.e.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.mContext).agK();
            return;
        }
        a(this.mContext, this.jMU, this.jDa);
    }

    public void a(TbPageContext tbPageContext, final String str, final ForumWriteData forumWriteData) {
        if (tbPageContext != null) {
            com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
            aVar.ajS();
            aVar.e(tbPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            aVar.e(tbPageContext.getPageActivity(), "android.permission.CAMERA");
            aVar.e(tbPageContext.getPageActivity(), "android.permission.RECORD_AUDIO");
            aVar.a(new a.InterfaceC0243a() { // from class: com.baidu.tieba.write.e.11
                @Override // com.baidu.tbadk.core.util.b.a.InterfaceC0243a
                public void ajT() {
                    String str2;
                    String str3 = null;
                    MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                    String str4 = "0";
                    com.baidu.adp.lib.d.a.hY().X(false);
                    if (forumWriteData != null) {
                        str4 = forumWriteData.forumId;
                        str2 = forumWriteData.forumName;
                        str3 = forumWriteData.specialForumType;
                    } else {
                        str2 = null;
                    }
                    TiebaStatic.log(new an("c12611").bT("obj_locate", str).P("obj_type", 4));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(TbadkCoreApplication.getInst().getApplicationContext(), str2, str4, TbadkCoreApplication.getCurrentAccount(), str3)));
                }
            });
            aVar.ad(tbPageContext.getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czQ() {
        String str;
        String str2;
        int i;
        String str3;
        int i2;
        String str4;
        String str5;
        sc(false);
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.jDa == null) {
            str = "";
            str2 = "";
            i = 0;
            str3 = null;
            i2 = -1;
            str4 = null;
            str5 = "0";
        } else {
            String str6 = this.jDa.forumId;
            String str7 = this.jDa.forumName;
            postPrefixData = this.jDa.prefixData;
            antiData = this.jDa.antiData;
            int i3 = this.jDa.forumLevel;
            String str8 = this.jDa.avatar;
            int i4 = this.jDa.privateThread;
            String str9 = this.jDa.firstDir;
            str = this.jDa.secondDir;
            str2 = str9;
            i = i4;
            str3 = str8;
            i2 = i3;
            str4 = str7;
            str5 = str6;
        }
        TiebaStatic.log(new an("c12611").bT("obj_locate", this.jMU).P("obj_type", 3));
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mContext.getPageActivity(), 0, str5, str4, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom(this.writeCallFrom);
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str3);
        writeActivityConfig.setAlbumThread(1);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setProfessionZone(this.jDa != null ? this.jDa.defaultZone : -1);
        writeActivityConfig.setForumDir(str2, str);
        if (!StringUtils.isNull(this.jMT)) {
            writeActivityConfig.setTitle(this.jMT, true);
        }
        if (!a(this.mContext.getPageActivity(), writeActivityConfig)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czR() {
        sc(false);
        TiebaStatic.log(new an("c12611").bT("obj_locate", this.jMU).P("obj_type", 2));
        if (this.jDa == null) {
            this.jDa = new ForumWriteData("0", null, null, null);
        }
        this.jDa.mFrom = this.mFrom;
        this.jDa.writeCallFrom = this.writeCallFrom;
        i.b(this.mContext, "", this.jDa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GE(String str) {
        String str2;
        String str3;
        int i;
        String str4;
        int i2;
        String str5;
        String str6;
        sc(false);
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.jDa == null) {
            str2 = "";
            str3 = "";
            i = 0;
            str4 = null;
            i2 = -1;
            str5 = null;
            str6 = "0";
        } else {
            String str7 = this.jDa.forumId;
            String str8 = this.jDa.forumName;
            postPrefixData = this.jDa.prefixData;
            antiData = this.jDa.antiData;
            int i3 = this.jDa.forumLevel;
            String str9 = this.jDa.avatar;
            int i4 = this.jDa.privateThread;
            String str10 = this.jDa.firstDir;
            str2 = this.jDa.secondDir;
            str3 = str10;
            i = i4;
            str4 = str9;
            i2 = i3;
            str5 = str8;
            str6 = str7;
        }
        TiebaStatic.log(new an("c12611").bT("obj_locate", this.jMU).P("obj_type", 1));
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
        writeActivityConfig.setProfessionZone(this.jDa != null ? this.jDa.defaultZone : -1);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
    }

    private void czS() {
        if (this.mFrom == "main_tab" && com.baidu.adp.lib.b.d.hS().az("android_bigday_switch") != 0 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.ahQ().getLong("key_bigday_next_showtime_write", 0L)) {
            this.jMW = com.baidu.tbadk.core.bigday.b.aco().gR(3);
            if (this.jMW != null && this.jMW.acn()) {
                this.jMQ.jNt.startLoad(this.jMW.imgUrl, 41, false);
                this.jMQ.jNt.setVisibility(0);
                this.jMQ.jNt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.jMW != null && !StringUtils.isNULL(e.this.jMW.bDN)) {
                            bb.ajE().c(e.this.mContext, new String[]{e.this.jMW.bDN});
                            TiebaStatic.log(new an("c13114").l(VideoPlayActivityConfig.OBJ_ID, e.this.jMW.bDP).bT("obj_to", e.this.jMW.bDN));
                            e.this.sc(false);
                        }
                    }
                });
                this.jMQ.jNt.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.write.e.2
                    @Override // com.baidu.tbadk.widget.TbImageView.b
                    public void a(TbImageView tbImageView, Canvas canvas) {
                        if (e.this.jMQ.jNt.getBdImage() == null && e.this.jMW != null && !aq.isEmpty(e.this.jMW.imgUrl)) {
                            e.this.jMQ.jNt.startLoad(e.this.jMW.imgUrl, 41, false);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.b
                    public void b(TbImageView tbImageView, Canvas canvas) {
                    }
                });
                ViewGroup.LayoutParams layoutParams = this.jMQ.jNt.getLayoutParams();
                if (layoutParams instanceof RelativeLayout.LayoutParams) {
                    int af = (int) (l.af(this.mContext.getContext()) * 0.546d);
                    layoutParams.width = af;
                    layoutParams.height = af;
                    ((RelativeLayout.LayoutParams) layoutParams).topMargin = l.ah(this.mContext.getContext()) / 5;
                    this.jMQ.jNt.setLayoutParams(layoutParams);
                }
                this.jMQ.jNu.setVisibility(0);
                this.jMQ.jNu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.jMQ.jNu.clearAnimation();
                        e.this.jMQ.jNt.clearAnimation();
                        e.this.jMQ.jNu.setVisibility(8);
                        e.this.jMQ.jNt.setVisibility(8);
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(11, 23);
                        calendar.set(12, 59);
                        calendar.set(13, 59);
                        calendar.set(14, 0);
                        com.baidu.tbadk.core.sharedPref.b.ahQ().putLong("key_bigday_next_showtime_write", calendar.getTimeInMillis());
                    }
                });
                this.jMQ.jNt.startAnimation(this.jMV);
                this.jMQ.jNu.startAnimation(this.jMV);
                TiebaStatic.log(new an("c13113").l(VideoPlayActivityConfig.OBJ_ID, this.jMW.bDP).bT("obj_to", this.jMW.bDN));
            }
        }
    }

    private static boolean a(Activity activity, final WriteActivityConfig writeActivityConfig) {
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.ajS();
        aVar.e(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
        aVar.a(new a.InterfaceC0243a() { // from class: com.baidu.tieba.write.e.4
            @Override // com.baidu.tbadk.core.util.b.a.InterfaceC0243a
            public void ajT() {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, WriteActivityConfig.this));
            }
        });
        return aVar.ad(activity);
    }

    public void b(FRSRefreshButton fRSRefreshButton) {
        this.fuq = fRSRefreshButton;
    }

    public void czT() {
        if (this.jMQ != null) {
            this.jMQ.czW();
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public View jNd;
        public View jNe;
        public LinearLayout jNf;
        public TbImageView jNg;
        public TextView jNh;
        public LinearLayout jNi;
        public TbImageView jNj;
        public TextView jNk;
        public LinearLayout jNl;
        public TbImageView jNm;
        public TextView jNn;
        public LinearLayout jNo;
        public TbImageView jNp;
        public TextView jNq;
        public OvalActionButton jNr;
        public GridLayout jNs;
        public TbImageView jNt;
        public View jNu;
        public TBLottieAnimationView jNv;
        public View mRootView;

        public a(Context context) {
            if (context != null) {
                this.mRootView = LayoutInflater.from(e.this.mContext.getPageActivity()).inflate(R.layout.bottom_write_thread, (ViewGroup) null);
                this.jNi = (LinearLayout) this.mRootView.findViewById(R.id.home_write_article);
                this.jNj = (TbImageView) this.mRootView.findViewById(R.id.home_write_article_icon);
                this.jNk = (TextView) this.mRootView.findViewById(R.id.home_write_article_title);
                this.jNf = (LinearLayout) this.mRootView.findViewById(R.id.home_write_photo);
                this.jNg = (TbImageView) this.mRootView.findViewById(R.id.home_write_photo_icon);
                this.jNh = (TextView) this.mRootView.findViewById(R.id.home_write_photo_title);
                this.jNl = (LinearLayout) this.mRootView.findViewById(R.id.home_write_album);
                this.jNm = (TbImageView) this.mRootView.findViewById(R.id.home_write_album_icon);
                this.jNn = (TextView) this.mRootView.findViewById(R.id.home_write_album_title);
                this.jNo = (LinearLayout) this.mRootView.findViewById(R.id.home_write_live);
                this.jNp = (TbImageView) this.mRootView.findViewById(R.id.home_write_live_icon);
                this.jNq = (TextView) this.mRootView.findViewById(R.id.home_write_live_title);
                this.jNr = (OvalActionButton) this.mRootView.findViewById(R.id.write_close_view);
                this.jNe = this.mRootView.findViewById(R.id.view_background_white);
                this.jNd = this.mRootView.findViewById(R.id.view_background_translate);
                this.jNs = (GridLayout) this.mRootView.findViewById(R.id.type_container);
                this.jNs.setMeasureAllChild(true);
                this.jNs.setVerNum(1);
                this.jNt = (TbImageView) this.mRootView.findViewById(R.id.write_tab_bigday_img);
                this.jNu = this.mRootView.findViewById(R.id.write_tab_bigday_close);
                this.jNv = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
                this.jNv.setSpeed(1.2f);
                czW();
            }
        }

        public void czU() {
            this.jNd.setOnClickListener(e.this.jMX);
        }

        public void czV() {
            this.jNd.setOnClickListener(null);
            this.jNd.setClickable(false);
        }

        public void czW() {
            int af = l.af(e.this.mContext.getPageActivity());
            int i = (int) (0.15555556f * af);
            c(this.jNj, i);
            c(this.jNg, i);
            c(this.jNm, i);
            c(this.jNp, i);
            float g = (af * 1.0f) / l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
            ViewGroup.LayoutParams layoutParams = this.jNs.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = (int) (l.g(TbadkCoreApplication.getInst(), R.dimen.tbds418) * g);
                this.jNs.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.jNe.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                int g2 = (int) (l.g(TbadkCoreApplication.getInst(), R.dimen.tbds912) * g);
                ((RelativeLayout.LayoutParams) layoutParams2).height = g2 <= 0 ? 912 : g2;
                this.jNe.setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = this.jNv.getLayoutParams();
            if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams3).height = (int) ((g * l.g(TbadkCoreApplication.getInst(), R.dimen.tbds800)) - ((l.g(TbadkCoreApplication.getInst(), R.dimen.tbds135) * g) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()));
                this.jNv.setLayoutParams(layoutParams3);
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
