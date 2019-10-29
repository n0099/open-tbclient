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
    private TbPageContext cfl;
    private FRSRefreshButton fvq;
    private ForumWriteData jFm;
    private a jNr;
    private boolean jNs;
    private f jNt;
    private String jNu;
    private String jNv;
    private Animation jNw;
    private com.baidu.tbadk.core.bigday.a jNx;
    private View.OnClickListener jNy;
    private f.a jNz;
    private String mFrom;
    private ViewGroup mParentView;
    private int mSkinType;
    private String writeCallFrom;
    private com.baidu.tbadk.p.a.a zg;

    public e(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this(tbPageContext, viewGroup, str, 1);
    }

    public e(TbPageContext tbPageContext, ViewGroup viewGroup, String str, int i) {
        this.jNs = false;
        this.mSkinType = 3;
        this.jNu = "";
        this.mFrom = "write";
        this.jNv = "0";
        this.jNy = new View.OnClickListener() { // from class: com.baidu.tieba.write.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.bgColor != 0) {
                    UtilHelper.setNavigationBarBackground(e.this.cfl.getPageActivity(), e.this.bgColor);
                }
                e.this.rM(true);
            }
        };
        this.jNz = new f.a() { // from class: com.baidu.tieba.write.e.5
            @Override // com.baidu.tieba.write.f.a
            public void Bx(int i2) {
                if (i2 == 1) {
                    e.this.jNs = true;
                    if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (e.this.jNt instanceof c)) {
                        if (e.this.zg == null) {
                            e.this.zg = new com.baidu.tbadk.p.a.a("anim_switch_sendthread_maintab");
                        }
                        e.this.zg.awU();
                    }
                } else if (i2 == 2) {
                    if (e.this.zg != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (e.this.jNt instanceof c)) {
                        e.this.zg.awV();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 0));
                } else if (i2 == 4) {
                    e.this.jNs = false;
                    if (e.this.jNr.mRootView.getParent() == e.this.mParentView && e.this.mParentView != null && e.this.jNr.mRootView != null && e.this.mParentView.indexOfChild(e.this.jNr.mRootView) > 0) {
                        e.this.mParentView.removeView(e.this.jNr.mRootView);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 1));
                }
            }
        };
        this.cfl = tbPageContext;
        this.mParentView = viewGroup;
        this.mFrom = str;
        this.jNr = new a(tbPageContext.getPageActivity());
        initView();
        this.jNt = g.a(i, tbPageContext.getPageActivity(), this.jNr);
        this.jNt.a(this.jNz);
    }

    public void Fw(String str) {
        if (str == null) {
            str = "";
        }
        this.jNu = str;
    }

    public void a(ForumWriteData forumWriteData) {
        this.jFm = forumWriteData;
    }

    public void Fx(String str) {
        if ("3".equals(str)) {
            this.writeCallFrom = "1";
        } else {
            this.writeCallFrom = str;
        }
        this.jNv = str;
    }

    private void initView() {
        this.jNr.cxT();
        this.jNr.jNK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.Fy(e.this.jNu);
            }
        });
        this.jNr.jNH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.cxQ();
            }
        });
        this.jNr.jNN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.cxP();
            }
        });
        this.jNr.jNQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.cxO();
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.jNw = AnimationUtils.loadAnimation(this.cfl.getPageActivity(), R.anim.write_tab_bg_anim);
        this.jNw.setFillAfter(true);
    }

    public boolean isShowing() {
        return this.jNs;
    }

    public void Bv(int i) {
        this.bgColor = i;
    }

    public void a(boolean z, View view, View view2) {
        if (this.mParentView != null) {
            cxR();
            if (this.jNr.mRootView.getParent() == null) {
                com.baidu.tbadk.m.e.bg(this.mParentView).attachView(this.mParentView, this.jNr.mRootView, z);
            }
            this.jNt.c(view, view2);
            this.jNt.show();
            TiebaStatic.log(new an("c12052").bS("obj_locate", this.jNv));
            if (j.isMobileNet()) {
                String string = com.baidu.tbadk.core.sharedPref.b.alR().getString(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP, "");
                if (!aq.isEmpty(string)) {
                    BdToast.b(this.cfl.getContext(), string).akT();
                    com.baidu.tbadk.core.sharedPref.b.alR().remove(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP);
                }
            }
        }
    }

    public void Bw(int i) {
        this.jNr.jNS.setIconFade(i);
    }

    public void rM(boolean z) {
        this.jNt.cd(z);
        if (!z) {
            this.jNr.jNS.avB();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            this.jNr.jNS.onChangeSkinType(i);
            am.a(this.jNr.jNW, R.raw.bottom_bar_bg);
            am.setBackgroundResource(this.jNr.jNF, R.drawable.write_tab_background);
            this.jNr.jNH.setImageDrawable(SvgManager.amN().h(R.drawable.icon_post_photograph_n_svg, 1, true));
            this.jNr.jNK.setImageDrawable(SvgManager.amN().h(R.drawable.icon_post_text_n_svg, 1, true));
            this.jNr.jNN.setImageDrawable(SvgManager.amN().h(R.drawable.icon_post_image_n_svg, 1, true));
            this.jNr.jNQ.setImageDrawable(SvgManager.amN().h(R.drawable.icon_post_live_n_svg, 1, true));
            am.setViewTextColor(this.jNr.jNI, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jNr.jNL, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jNr.jNO, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jNr.jNR, (int) R.color.cp_cont_b);
        }
    }

    public void onDestroy() {
        if (this.jNr.mRootView != null && this.jNr.mRootView.getParent() == this.mParentView) {
            this.mParentView.removeView(this.jNr.mRootView);
        }
        this.jNt.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxO() {
        rM(false);
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cfl.getPageActivity());
            aVar.setAutoNight(false);
            aVar.hT(R.string.prompt);
            aVar.nn(this.cfl.getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.a(R.string.know, new a.b() { // from class: com.baidu.tieba.write.e.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.cfl).akO();
            return;
        }
        a(this.cfl, this.jNv, this.jFm);
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
    public void cxP() {
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
        if (this.jFm == null) {
            str = "";
            str2 = "";
            i = 0;
            str3 = null;
            i2 = -1;
            str4 = null;
            str5 = "0";
        } else {
            String str6 = this.jFm.forumId;
            String str7 = this.jFm.forumName;
            postPrefixData = this.jFm.prefixData;
            antiData = this.jFm.antiData;
            int i3 = this.jFm.forumLevel;
            String str8 = this.jFm.avatar;
            int i4 = this.jFm.privateThread;
            String str9 = this.jFm.firstDir;
            str = this.jFm.secondDir;
            str2 = str9;
            i = i4;
            str3 = str8;
            i2 = i3;
            str4 = str7;
            str5 = str6;
        }
        TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).bS("obj_locate", this.jNv).O("obj_type", 3));
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.cfl.getPageActivity(), 0, str5, str4, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom(this.writeCallFrom);
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str3);
        writeActivityConfig.setAlbumThread(1);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setProfessionZone(this.jFm != null ? this.jFm.defaultZone : -1);
        writeActivityConfig.setForumDir(str2, str);
        if (!StringUtils.isNull(this.jNu)) {
            writeActivityConfig.setTitle(this.jNu, true);
        }
        if (!a(this.cfl.getPageActivity(), writeActivityConfig)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxQ() {
        rM(false);
        TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).bS("obj_locate", this.jNv).O("obj_type", 2));
        if (this.jFm == null) {
            this.jFm = new ForumWriteData("0", null, null, null);
        }
        this.jFm.mFrom = this.mFrom;
        this.jFm.writeCallFrom = this.writeCallFrom;
        i.b(this.cfl, "", this.jFm);
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
        if (this.jFm == null) {
            str2 = "";
            str3 = "";
            i = 0;
            str4 = null;
            i2 = -1;
            str5 = null;
            str6 = "0";
        } else {
            String str7 = this.jFm.forumId;
            String str8 = this.jFm.forumName;
            postPrefixData = this.jFm.prefixData;
            antiData = this.jFm.antiData;
            int i3 = this.jFm.forumLevel;
            String str9 = this.jFm.avatar;
            int i4 = this.jFm.privateThread;
            String str10 = this.jFm.firstDir;
            str2 = this.jFm.secondDir;
            str3 = str10;
            i = i4;
            str4 = str9;
            i2 = i3;
            str5 = str8;
            str6 = str7;
        }
        TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).bS("obj_locate", this.jNv).O("obj_type", 1));
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.cfl.getPageActivity(), 9, str6, str5, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom(this.writeCallFrom);
        if (!StringUtils.isNull(str)) {
            writeActivityConfig.setTitle(str, true);
        }
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str4);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setForumDir(str3, str2);
        writeActivityConfig.setProfessionZone(this.jFm != null ? this.jFm.defaultZone : -1);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
    }

    private void cxR() {
        if (this.mFrom == "main_tab" && com.baidu.adp.lib.b.d.ft().af("android_bigday_switch") != 0 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.alR().getLong("key_bigday_next_showtime_write", 0L)) {
            this.jNx = com.baidu.tbadk.core.bigday.b.agy().hr(3);
            if (this.jNx != null && this.jNx.agx()) {
                this.jNr.jNU.startLoad(this.jNx.imgUrl, 41, false);
                this.jNr.jNU.setVisibility(0);
                this.jNr.jNU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.jNx != null && !StringUtils.isNULL(e.this.jNx.bWc)) {
                            ba.amQ().b(e.this.cfl, new String[]{e.this.jNx.bWc});
                            TiebaStatic.log(new an("c13114").p("obj_id", e.this.jNx.bWe).bS(TiebaInitialize.Params.OBJ_TO, e.this.jNx.bWc));
                            e.this.rM(false);
                        }
                    }
                });
                this.jNr.jNU.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.write.e.2
                    @Override // com.baidu.tbadk.widget.TbImageView.b
                    public void a(TbImageView tbImageView, Canvas canvas) {
                        if (e.this.jNr.jNU.getBdImage() == null && e.this.jNx != null && !aq.isEmpty(e.this.jNx.imgUrl)) {
                            e.this.jNr.jNU.startLoad(e.this.jNx.imgUrl, 41, false);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.b
                    public void b(TbImageView tbImageView, Canvas canvas) {
                    }
                });
                ViewGroup.LayoutParams layoutParams = this.jNr.jNU.getLayoutParams();
                if (layoutParams instanceof RelativeLayout.LayoutParams) {
                    int equipmentWidth = (int) (l.getEquipmentWidth(this.cfl.getContext()) * 0.546d);
                    layoutParams.width = equipmentWidth;
                    layoutParams.height = equipmentWidth;
                    ((RelativeLayout.LayoutParams) layoutParams).topMargin = l.getEquipmentHeight(this.cfl.getContext()) / 5;
                    this.jNr.jNU.setLayoutParams(layoutParams);
                }
                this.jNr.jNV.setVisibility(0);
                this.jNr.jNV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.jNr.jNV.clearAnimation();
                        e.this.jNr.jNU.clearAnimation();
                        e.this.jNr.jNV.setVisibility(8);
                        e.this.jNr.jNU.setVisibility(8);
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(11, 23);
                        calendar.set(12, 59);
                        calendar.set(13, 59);
                        calendar.set(14, 0);
                        com.baidu.tbadk.core.sharedPref.b.alR().putLong("key_bigday_next_showtime_write", calendar.getTimeInMillis());
                    }
                });
                this.jNr.jNU.startAnimation(this.jNw);
                this.jNr.jNV.startAnimation(this.jNw);
                TiebaStatic.log(new an("c13113").p("obj_id", this.jNx.bWe).bS(TiebaInitialize.Params.OBJ_TO, this.jNx.bWc));
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
        this.fvq = fRSRefreshButton;
    }

    public void cxS() {
        if (this.jNr != null) {
            this.jNr.cxV();
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public View jNE;
        public View jNF;
        public LinearLayout jNG;
        public ImageView jNH;
        public TextView jNI;
        public LinearLayout jNJ;
        public ImageView jNK;
        public TextView jNL;
        public LinearLayout jNM;
        public ImageView jNN;
        public TextView jNO;
        public LinearLayout jNP;
        public ImageView jNQ;
        public TextView jNR;
        public OvalActionButton jNS;
        public GridLayout jNT;
        public TbImageView jNU;
        public View jNV;
        public TBLottieAnimationView jNW;
        public View mRootView;

        public a(Context context) {
            if (context != null) {
                this.mRootView = LayoutInflater.from(e.this.cfl.getPageActivity()).inflate(R.layout.bottom_write_thread, (ViewGroup) null);
                this.jNJ = (LinearLayout) this.mRootView.findViewById(R.id.home_write_article);
                this.jNK = (ImageView) this.mRootView.findViewById(R.id.home_write_article_icon);
                this.jNL = (TextView) this.mRootView.findViewById(R.id.home_write_article_title);
                this.jNG = (LinearLayout) this.mRootView.findViewById(R.id.home_write_photo);
                this.jNH = (ImageView) this.mRootView.findViewById(R.id.home_write_photo_icon);
                this.jNI = (TextView) this.mRootView.findViewById(R.id.home_write_photo_title);
                this.jNM = (LinearLayout) this.mRootView.findViewById(R.id.home_write_album);
                this.jNN = (ImageView) this.mRootView.findViewById(R.id.home_write_album_icon);
                this.jNO = (TextView) this.mRootView.findViewById(R.id.home_write_album_title);
                this.jNP = (LinearLayout) this.mRootView.findViewById(R.id.home_write_live);
                this.jNQ = (ImageView) this.mRootView.findViewById(R.id.home_write_live_icon);
                this.jNR = (TextView) this.mRootView.findViewById(R.id.home_write_live_title);
                this.jNS = (OvalActionButton) this.mRootView.findViewById(R.id.write_close_view);
                this.jNF = this.mRootView.findViewById(R.id.view_background_white);
                this.jNE = this.mRootView.findViewById(R.id.view_background_translate);
                this.jNT = (GridLayout) this.mRootView.findViewById(R.id.type_container);
                this.jNT.setMeasureAllChild(true);
                this.jNT.setVerNum(1);
                this.jNU = (TbImageView) this.mRootView.findViewById(R.id.write_tab_bigday_img);
                this.jNV = this.mRootView.findViewById(R.id.write_tab_bigday_close);
                this.jNW = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
                this.jNW.setSpeed(1.2f);
                cxV();
            }
        }

        public void cxT() {
            this.jNE.setOnClickListener(e.this.jNy);
        }

        public void cxU() {
            this.jNE.setOnClickListener(null);
            this.jNE.setClickable(false);
        }

        public void cxV() {
            int equipmentWidth = l.getEquipmentWidth(e.this.cfl.getPageActivity());
            int i = (int) (0.15555556f * equipmentWidth);
            a(this.jNK, i);
            a(this.jNH, i);
            a(this.jNN, i);
            a(this.jNQ, i);
            float dimens = (equipmentWidth * 1.0f) / l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
            ViewGroup.LayoutParams layoutParams = this.jNT.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds418) * dimens);
                this.jNT.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.jNF.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                int dimens2 = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds912) * dimens);
                ((RelativeLayout.LayoutParams) layoutParams2).height = dimens2 <= 0 ? 912 : dimens2;
                this.jNF.setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = this.jNW.getLayoutParams();
            if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams3).height = (int) ((dimens * l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds800)) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds135) * dimens) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()));
                this.jNW.setLayoutParams(layoutParams3);
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
