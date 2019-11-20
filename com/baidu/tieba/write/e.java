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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaMasterLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.c.a;
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
    private int bgColor;
    private TbPageContext ceu;
    private FRSRefreshButton fuz;
    private ForumWriteData jEv;
    private a jMA;
    private boolean jMB;
    private f jMC;
    private String jMD;
    private String jME;
    private Animation jMF;
    private com.baidu.tbadk.core.bigday.a jMG;
    private View.OnClickListener jMH;
    private f.a jMI;
    private String mFrom;
    private ViewGroup mParentView;
    private int mSkinType;
    private String writeCallFrom;
    private com.baidu.tbadk.p.a.a yG;

    public e(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this(tbPageContext, viewGroup, str, 1);
    }

    public e(TbPageContext tbPageContext, ViewGroup viewGroup, String str, int i) {
        this.jMB = false;
        this.mSkinType = 3;
        this.jMD = "";
        this.mFrom = "write";
        this.jME = "0";
        this.jMH = new View.OnClickListener() { // from class: com.baidu.tieba.write.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.bgColor != 0) {
                    UtilHelper.setNavigationBarBackground(e.this.ceu.getPageActivity(), e.this.bgColor);
                }
                e.this.rM(true);
            }
        };
        this.jMI = new f.a() { // from class: com.baidu.tieba.write.e.5
            @Override // com.baidu.tieba.write.f.a
            public void Bw(int i2) {
                if (i2 == 1) {
                    e.this.jMB = true;
                    if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (e.this.jMC instanceof c)) {
                        if (e.this.yG == null) {
                            e.this.yG = new com.baidu.tbadk.p.a.a("anim_switch_sendthread_maintab");
                        }
                        e.this.yG.awS();
                    }
                } else if (i2 == 2) {
                    if (e.this.yG != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (e.this.jMC instanceof c)) {
                        e.this.yG.awT();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 0));
                } else if (i2 == 4) {
                    e.this.jMB = false;
                    if (e.this.jMA.mRootView.getParent() == e.this.mParentView && e.this.mParentView != null && e.this.jMA.mRootView != null && e.this.mParentView.indexOfChild(e.this.jMA.mRootView) > 0) {
                        e.this.mParentView.removeView(e.this.jMA.mRootView);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 1));
                }
            }
        };
        this.ceu = tbPageContext;
        this.mParentView = viewGroup;
        this.mFrom = str;
        this.jMA = new a(tbPageContext.getPageActivity());
        initView();
        this.jMC = g.a(i, tbPageContext.getPageActivity(), this.jMA);
        this.jMC.a(this.jMI);
    }

    public void Fw(String str) {
        if (str == null) {
            str = "";
        }
        this.jMD = str;
    }

    public void a(ForumWriteData forumWriteData) {
        this.jEv = forumWriteData;
    }

    public void Fx(String str) {
        if ("3".equals(str)) {
            this.writeCallFrom = "1";
        } else {
            this.writeCallFrom = str;
        }
        this.jME = str;
    }

    private void initView() {
        this.jMA.cxR();
        this.jMA.jMT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.Fy(e.this.jMD);
            }
        });
        this.jMA.jMQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.cxO();
            }
        });
        this.jMA.jMW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.cxN();
            }
        });
        this.jMA.jMZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.cxM();
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.jMF = AnimationUtils.loadAnimation(this.ceu.getPageActivity(), R.anim.write_tab_bg_anim);
        this.jMF.setFillAfter(true);
    }

    public boolean isShowing() {
        return this.jMB;
    }

    public void Bu(int i) {
        this.bgColor = i;
    }

    public void a(boolean z, View view, View view2) {
        if (this.mParentView != null) {
            cxP();
            if (this.jMA.mRootView.getParent() == null) {
                com.baidu.tbadk.m.e.bg(this.mParentView).attachView(this.mParentView, this.jMA.mRootView, z);
            }
            this.jMC.c(view, view2);
            this.jMC.show();
            TiebaStatic.log(new an("c12052").bS("obj_locate", this.jME));
            if (j.isMobileNet()) {
                String string = com.baidu.tbadk.core.sharedPref.b.alP().getString(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP, "");
                if (!aq.isEmpty(string)) {
                    BdToast.b(this.ceu.getContext(), string).akR();
                    com.baidu.tbadk.core.sharedPref.b.alP().remove(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP);
                }
            }
        }
    }

    public void Bv(int i) {
        this.jMA.jNb.setIconFade(i);
    }

    public void rM(boolean z) {
        this.jMC.cd(z);
        if (!z) {
            this.jMA.jNb.avz();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            this.jMA.jNb.onChangeSkinType(i);
            am.a(this.jMA.jNf, R.raw.bottom_bar_bg);
            am.setBackgroundResource(this.jMA.jMO, R.drawable.write_tab_background);
            this.jMA.jMQ.setImageDrawable(SvgManager.amL().h(R.drawable.icon_post_photograph_n_svg, 1, true));
            this.jMA.jMT.setImageDrawable(SvgManager.amL().h(R.drawable.icon_post_text_n_svg, 1, true));
            this.jMA.jMW.setImageDrawable(SvgManager.amL().h(R.drawable.icon_post_image_n_svg, 1, true));
            this.jMA.jMZ.setImageDrawable(SvgManager.amL().h(R.drawable.icon_post_live_n_svg, 1, true));
            am.setViewTextColor(this.jMA.jMR, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jMA.jMU, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jMA.jMX, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jMA.jNa, (int) R.color.cp_cont_b);
        }
    }

    public void onDestroy() {
        if (this.jMA.mRootView != null && this.jMA.mRootView.getParent() == this.mParentView) {
            this.mParentView.removeView(this.jMA.mRootView);
        }
        this.jMC.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxM() {
        rM(false);
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ceu.getPageActivity());
            aVar.setAutoNight(false);
            aVar.hS(R.string.prompt);
            aVar.nn(this.ceu.getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.a(R.string.know, new a.b() { // from class: com.baidu.tieba.write.e.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.ceu).akM();
            return;
        }
        a(this.ceu, this.jME, this.jEv);
    }

    public void a(TbPageContext tbPageContext, final String str, final ForumWriteData forumWriteData) {
        if (tbPageContext != null) {
            com.baidu.tbadk.core.util.c.a aVar = new com.baidu.tbadk.core.util.c.a();
            aVar.clearRequestPermissionList();
            aVar.appendRequestPermission(tbPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            aVar.appendRequestPermission(tbPageContext.getPageActivity(), "android.permission.CAMERA");
            aVar.appendRequestPermission(tbPageContext.getPageActivity(), "android.permission.RECORD_AUDIO");
            aVar.a(new a.InterfaceC0284a() { // from class: com.baidu.tieba.write.e.11
                @Override // com.baidu.tbadk.core.util.c.a.InterfaceC0284a
                public void onPermissionsGranted() {
                    String str2;
                    String str3 = null;
                    MessageManager.getInstance().sendMessage(new HttpMessage(1003303));
                    String str4 = "0";
                    com.baidu.adp.lib.d.a.fw().getAddress(false);
                    if (forumWriteData != null) {
                        str4 = forumWriteData.forumId;
                        str2 = forumWriteData.forumName;
                        str3 = forumWriteData.specialForumType;
                    } else {
                        str2 = null;
                    }
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).bS("obj_locate", str).O("obj_type", 4));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaMasterLiveRoomActivityConfig(TbadkCoreApplication.getInst().getApplicationContext(), str2, str4, TbadkCoreApplication.getCurrentAccount(), str3)));
                }
            });
            aVar.startRequestPermission(tbPageContext.getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxN() {
        String str;
        String str2;
        int i;
        String str3;
        int i2;
        String str4;
        String str5;
        rM(false);
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.jEv == null) {
            str = "";
            str2 = "";
            i = 0;
            str3 = null;
            i2 = -1;
            str4 = null;
            str5 = "0";
        } else {
            String str6 = this.jEv.forumId;
            String str7 = this.jEv.forumName;
            postPrefixData = this.jEv.prefixData;
            antiData = this.jEv.antiData;
            int i3 = this.jEv.forumLevel;
            String str8 = this.jEv.avatar;
            int i4 = this.jEv.privateThread;
            String str9 = this.jEv.firstDir;
            str = this.jEv.secondDir;
            str2 = str9;
            i = i4;
            str3 = str8;
            i2 = i3;
            str4 = str7;
            str5 = str6;
        }
        TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).bS("obj_locate", this.jME).O("obj_type", 3));
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.ceu.getPageActivity(), 0, str5, str4, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom(this.writeCallFrom);
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str3);
        writeActivityConfig.setAlbumThread(1);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setProfessionZone(this.jEv != null ? this.jEv.defaultZone : -1);
        writeActivityConfig.setForumDir(str2, str);
        if (!StringUtils.isNull(this.jMD)) {
            writeActivityConfig.setTitle(this.jMD, true);
        }
        if (!a(this.ceu.getPageActivity(), writeActivityConfig)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxO() {
        rM(false);
        TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).bS("obj_locate", this.jME).O("obj_type", 2));
        if (this.jEv == null) {
            this.jEv = new ForumWriteData("0", null, null, null);
        }
        this.jEv.mFrom = this.mFrom;
        this.jEv.writeCallFrom = this.writeCallFrom;
        i.b(this.ceu, "", this.jEv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fy(String str) {
        String str2;
        String str3;
        int i;
        String str4;
        int i2;
        String str5;
        String str6;
        rM(false);
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.jEv == null) {
            str2 = "";
            str3 = "";
            i = 0;
            str4 = null;
            i2 = -1;
            str5 = null;
            str6 = "0";
        } else {
            String str7 = this.jEv.forumId;
            String str8 = this.jEv.forumName;
            postPrefixData = this.jEv.prefixData;
            antiData = this.jEv.antiData;
            int i3 = this.jEv.forumLevel;
            String str9 = this.jEv.avatar;
            int i4 = this.jEv.privateThread;
            String str10 = this.jEv.firstDir;
            str2 = this.jEv.secondDir;
            str3 = str10;
            i = i4;
            str4 = str9;
            i2 = i3;
            str5 = str8;
            str6 = str7;
        }
        TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).bS("obj_locate", this.jME).O("obj_type", 1));
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.ceu.getPageActivity(), 9, str6, str5, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom(this.writeCallFrom);
        if (!StringUtils.isNull(str)) {
            writeActivityConfig.setTitle(str, true);
        }
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str4);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setForumDir(str3, str2);
        writeActivityConfig.setProfessionZone(this.jEv != null ? this.jEv.defaultZone : -1);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
    }

    private void cxP() {
        if (this.mFrom == "main_tab" && com.baidu.adp.lib.b.d.ft().af("android_bigday_switch") != 0 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.alP().getLong("key_bigday_next_showtime_write", 0L)) {
            this.jMG = com.baidu.tbadk.core.bigday.b.agw().hq(3);
            if (this.jMG != null && this.jMG.agv()) {
                this.jMA.jNd.startLoad(this.jMG.imgUrl, 41, false);
                this.jMA.jNd.setVisibility(0);
                this.jMA.jNd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.jMG != null && !StringUtils.isNULL(e.this.jMG.bVl)) {
                            ba.amO().b(e.this.ceu, new String[]{e.this.jMG.bVl});
                            TiebaStatic.log(new an("c13114").p("obj_id", e.this.jMG.bVn).bS(TiebaInitialize.Params.OBJ_TO, e.this.jMG.bVl));
                            e.this.rM(false);
                        }
                    }
                });
                this.jMA.jNd.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.write.e.2
                    @Override // com.baidu.tbadk.widget.TbImageView.b
                    public void a(TbImageView tbImageView, Canvas canvas) {
                        if (e.this.jMA.jNd.getBdImage() == null && e.this.jMG != null && !aq.isEmpty(e.this.jMG.imgUrl)) {
                            e.this.jMA.jNd.startLoad(e.this.jMG.imgUrl, 41, false);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.b
                    public void b(TbImageView tbImageView, Canvas canvas) {
                    }
                });
                ViewGroup.LayoutParams layoutParams = this.jMA.jNd.getLayoutParams();
                if (layoutParams instanceof RelativeLayout.LayoutParams) {
                    int equipmentWidth = (int) (l.getEquipmentWidth(this.ceu.getContext()) * 0.546d);
                    layoutParams.width = equipmentWidth;
                    layoutParams.height = equipmentWidth;
                    ((RelativeLayout.LayoutParams) layoutParams).topMargin = l.getEquipmentHeight(this.ceu.getContext()) / 5;
                    this.jMA.jNd.setLayoutParams(layoutParams);
                }
                this.jMA.jNe.setVisibility(0);
                this.jMA.jNe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.jMA.jNe.clearAnimation();
                        e.this.jMA.jNd.clearAnimation();
                        e.this.jMA.jNe.setVisibility(8);
                        e.this.jMA.jNd.setVisibility(8);
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(11, 23);
                        calendar.set(12, 59);
                        calendar.set(13, 59);
                        calendar.set(14, 0);
                        com.baidu.tbadk.core.sharedPref.b.alP().putLong("key_bigday_next_showtime_write", calendar.getTimeInMillis());
                    }
                });
                this.jMA.jNd.startAnimation(this.jMF);
                this.jMA.jNe.startAnimation(this.jMF);
                TiebaStatic.log(new an("c13113").p("obj_id", this.jMG.bVn).bS(TiebaInitialize.Params.OBJ_TO, this.jMG.bVl));
            }
        }
    }

    private static boolean a(Activity activity, final WriteActivityConfig writeActivityConfig) {
        com.baidu.tbadk.core.util.c.a aVar = new com.baidu.tbadk.core.util.c.a();
        aVar.clearRequestPermissionList();
        aVar.appendRequestPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
        aVar.a(new a.InterfaceC0284a() { // from class: com.baidu.tieba.write.e.4
            @Override // com.baidu.tbadk.core.util.c.a.InterfaceC0284a
            public void onPermissionsGranted() {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, WriteActivityConfig.this));
            }
        });
        return aVar.startRequestPermission(activity);
    }

    public void b(FRSRefreshButton fRSRefreshButton) {
        this.fuz = fRSRefreshButton;
    }

    public void cxQ() {
        if (this.jMA != null) {
            this.jMA.cxT();
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public View jMN;
        public View jMO;
        public LinearLayout jMP;
        public ImageView jMQ;
        public TextView jMR;
        public LinearLayout jMS;
        public ImageView jMT;
        public TextView jMU;
        public LinearLayout jMV;
        public ImageView jMW;
        public TextView jMX;
        public LinearLayout jMY;
        public ImageView jMZ;
        public TextView jNa;
        public OvalActionButton jNb;
        public GridLayout jNc;
        public TbImageView jNd;
        public View jNe;
        public TBLottieAnimationView jNf;
        public View mRootView;

        public a(Context context) {
            if (context != null) {
                this.mRootView = LayoutInflater.from(e.this.ceu.getPageActivity()).inflate(R.layout.bottom_write_thread, (ViewGroup) null);
                this.jMS = (LinearLayout) this.mRootView.findViewById(R.id.home_write_article);
                this.jMT = (ImageView) this.mRootView.findViewById(R.id.home_write_article_icon);
                this.jMU = (TextView) this.mRootView.findViewById(R.id.home_write_article_title);
                this.jMP = (LinearLayout) this.mRootView.findViewById(R.id.home_write_photo);
                this.jMQ = (ImageView) this.mRootView.findViewById(R.id.home_write_photo_icon);
                this.jMR = (TextView) this.mRootView.findViewById(R.id.home_write_photo_title);
                this.jMV = (LinearLayout) this.mRootView.findViewById(R.id.home_write_album);
                this.jMW = (ImageView) this.mRootView.findViewById(R.id.home_write_album_icon);
                this.jMX = (TextView) this.mRootView.findViewById(R.id.home_write_album_title);
                this.jMY = (LinearLayout) this.mRootView.findViewById(R.id.home_write_live);
                this.jMZ = (ImageView) this.mRootView.findViewById(R.id.home_write_live_icon);
                this.jNa = (TextView) this.mRootView.findViewById(R.id.home_write_live_title);
                this.jNb = (OvalActionButton) this.mRootView.findViewById(R.id.write_close_view);
                this.jMO = this.mRootView.findViewById(R.id.view_background_white);
                this.jMN = this.mRootView.findViewById(R.id.view_background_translate);
                this.jNc = (GridLayout) this.mRootView.findViewById(R.id.type_container);
                this.jNc.setMeasureAllChild(true);
                this.jNc.setVerNum(1);
                this.jNd = (TbImageView) this.mRootView.findViewById(R.id.write_tab_bigday_img);
                this.jNe = this.mRootView.findViewById(R.id.write_tab_bigday_close);
                this.jNf = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
                this.jNf.setSpeed(1.2f);
                cxT();
            }
        }

        public void cxR() {
            this.jMN.setOnClickListener(e.this.jMH);
        }

        public void cxS() {
            this.jMN.setOnClickListener(null);
            this.jMN.setClickable(false);
        }

        public void cxT() {
            int equipmentWidth = l.getEquipmentWidth(e.this.ceu.getPageActivity());
            int i = (int) (0.15555556f * equipmentWidth);
            a(this.jMT, i);
            a(this.jMQ, i);
            a(this.jMW, i);
            a(this.jMZ, i);
            float dimens = (equipmentWidth * 1.0f) / l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
            ViewGroup.LayoutParams layoutParams = this.jNc.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds418) * dimens);
                this.jNc.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.jMO.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                int dimens2 = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds912) * dimens);
                ((RelativeLayout.LayoutParams) layoutParams2).height = dimens2 <= 0 ? 912 : dimens2;
                this.jMO.setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = this.jNf.getLayoutParams();
            if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams3).height = (int) ((dimens * l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds800)) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds135) * dimens) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()));
                this.jNf.setLayoutParams(layoutParams3);
            }
        }

        private void a(ImageView imageView, int i) {
            if (imageView != null && i > 0) {
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                layoutParams.width = i;
                layoutParams.height = i;
                imageView.setLayoutParams(layoutParams);
            }
        }
    }
}
