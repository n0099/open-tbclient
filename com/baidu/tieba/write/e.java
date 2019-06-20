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
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.write.f;
import java.util.Calendar;
/* loaded from: classes.dex */
public class e {
    private com.baidu.tbadk.p.a.a NV;
    private int bgColor;
    private FRSRefreshButton foS;
    private a jEH;
    private boolean jEI;
    private f jEJ;
    private String jEK;
    private String jEL;
    private Animation jEM;
    private com.baidu.tbadk.core.bigday.a jEN;
    private View.OnClickListener jEO;
    private f.a jEP;
    private ForumWriteData jvK;
    private TbPageContext mContext;
    private String mFrom;
    private ViewGroup mParentView;
    private int mSkinType;
    private String writeCallFrom;

    public e(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this(tbPageContext, viewGroup, str, 1);
    }

    public e(TbPageContext tbPageContext, ViewGroup viewGroup, String str, int i) {
        this.jEI = false;
        this.mSkinType = 3;
        this.jEK = "";
        this.mFrom = AlbumActivityConfig.FROM_WRITE;
        this.jEL = "0";
        this.jEO = new View.OnClickListener() { // from class: com.baidu.tieba.write.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.bgColor != 0) {
                    UtilHelper.setNavigationBarBackground(e.this.mContext.getPageActivity(), e.this.bgColor);
                }
                e.this.rM(true);
            }
        };
        this.jEP = new f.a() { // from class: com.baidu.tieba.write.e.4
            @Override // com.baidu.tieba.write.f.a
            public void Cg(int i2) {
                if (i2 == 1) {
                    e.this.jEI = true;
                    if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (e.this.jEJ instanceof c)) {
                        if (e.this.NV == null) {
                            e.this.NV = new com.baidu.tbadk.p.a.a("anim_switch_sendthread_maintab");
                        }
                        e.this.NV.aus();
                    }
                } else if (i2 == 2) {
                    if (e.this.NV != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (e.this.jEJ instanceof c)) {
                        e.this.NV.aut();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 0));
                } else if (i2 == 4) {
                    e.this.jEI = false;
                    if (e.this.jEH.mRootView.getParent() == e.this.mParentView && e.this.mParentView != null && e.this.jEH.mRootView != null && e.this.mParentView.indexOfChild(e.this.jEH.mRootView) > 0) {
                        e.this.mParentView.removeView(e.this.jEH.mRootView);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 1));
                }
            }
        };
        this.mContext = tbPageContext;
        this.mParentView = viewGroup;
        this.mFrom = str;
        this.jEH = new a(tbPageContext.getPageActivity());
        initView();
        this.jEJ = g.a(i, tbPageContext.getPageActivity(), this.jEH);
        this.jEJ.a(this.jEP);
    }

    public void FH(String str) {
        if (str == null) {
            str = "";
        }
        this.jEK = str;
    }

    public void a(ForumWriteData forumWriteData) {
        this.jvK = forumWriteData;
    }

    public void FI(String str) {
        if ("3".equals(str)) {
            this.writeCallFrom = "1";
        } else {
            this.writeCallFrom = str;
        }
        this.jEL = str;
    }

    private void initView() {
        this.jEH.cwy();
        this.jEH.jEY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.FJ(e.this.jEK);
            }
        });
        this.jEH.jEV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.cwv();
            }
        });
        this.jEH.jFb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.cwu();
            }
        });
        this.jEH.jFe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.cwt();
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.jEM = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), R.anim.write_tab_bg_anim);
        this.jEM.setFillAfter(true);
    }

    public boolean isShowing() {
        return this.jEI;
    }

    public void Ce(int i) {
        this.bgColor = i;
    }

    public void a(boolean z, View view, View view2) {
        if (this.mParentView != null) {
            cww();
            if (this.jEH.mRootView.getParent() == null) {
                com.baidu.tbadk.m.e.be(this.mParentView).a(this.mParentView, this.jEH.mRootView, z);
            }
            this.jEJ.b(view, view2);
            this.jEJ.show();
            TiebaStatic.log(new am("c12052").bT("obj_locate", this.jEL));
            if (j.jU()) {
                String string = com.baidu.tbadk.core.sharedPref.b.agM().getString("key_baidu_sim_card_writting_tip", "");
                if (!ap.isEmpty(string)) {
                    BdToast.b(this.mContext.getContext(), string).afO();
                    com.baidu.tbadk.core.sharedPref.b.agM().remove("key_baidu_sim_card_writting_tip");
                }
            }
        }
    }

    public void Cf(int i) {
        this.jEH.jFg.setIconFade(i);
    }

    public void rM(boolean z) {
        this.jEJ.bJ(z);
        if (!z) {
            this.jEH.jFg.asM();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            this.jEH.jFg.onChangeSkinType(i);
            al.a(this.jEH.jFk, (int) R.raw.bottom_bar_bg);
            al.k(this.jEH.jET, R.drawable.write_tab_background);
            al.c(this.jEH.jEV, (int) R.drawable.icon_post_type_photograph_n);
            al.c(this.jEH.jEY, (int) R.drawable.icon_post_type_text_n);
            al.c(this.jEH.jFb, (int) R.drawable.icon_post_type_image_n);
            al.c(this.jEH.jFe, (int) R.drawable.icon_post_type_live_n);
            al.j(this.jEH.jEW, R.color.cp_cont_b);
            al.j(this.jEH.jEZ, R.color.cp_cont_b);
            al.j(this.jEH.jFc, R.color.cp_cont_b);
            al.j(this.jEH.jFf, R.color.cp_cont_b);
        }
    }

    public void onDestroy() {
        if (this.jEH.mRootView != null && this.jEH.mRootView.getParent() == this.mParentView) {
            this.mParentView.removeView(this.jEH.mRootView);
        }
        this.jEJ.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwt() {
        String str;
        String str2 = null;
        rM(false);
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            aVar.setAutoNight(false);
            aVar.hn(R.string.prompt);
            aVar.mD(this.mContext.getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.dT(true);
            aVar.dS(true);
            aVar.a(R.string.know, new a.b() { // from class: com.baidu.tieba.write.e.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.mContext).afG();
            return;
        }
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
        String str3 = "0";
        com.baidu.adp.lib.d.a.hO().X(false);
        if (this.jvK != null) {
            str3 = this.jvK.forumId;
            str = this.jvK.forumName;
            str2 = this.jvK.specialForumType;
        } else {
            str = null;
        }
        TiebaStatic.log(new am("c12611").bT("obj_locate", this.jEL).P("obj_type", 4));
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(TbadkCoreApplication.getInst().getApplicationContext(), str, str3, TbadkCoreApplication.getCurrentAccount(), str2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwu() {
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
        if (this.jvK == null) {
            str = "";
            str2 = "";
            i = 0;
            str3 = null;
            i2 = -1;
            str4 = null;
            str5 = "0";
        } else {
            String str6 = this.jvK.forumId;
            String str7 = this.jvK.forumName;
            postPrefixData = this.jvK.prefixData;
            antiData = this.jvK.antiData;
            int i3 = this.jvK.forumLevel;
            String str8 = this.jvK.avatar;
            int i4 = this.jvK.privateThread;
            String str9 = this.jvK.firstDir;
            str = this.jvK.secondDir;
            str2 = str9;
            i = i4;
            str3 = str8;
            i2 = i3;
            str4 = str7;
            str5 = str6;
        }
        TiebaStatic.log(new am("c12611").bT("obj_locate", this.jEL).P("obj_type", 3));
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mContext.getPageActivity(), 0, str5, str4, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom(this.writeCallFrom);
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str3);
        writeActivityConfig.setAlbumThread(1);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setProfessionZone(this.jvK != null ? this.jvK.defaultZone : -1);
        writeActivityConfig.setForumDir(str2, str);
        if (!StringUtils.isNull(this.jEK)) {
            writeActivityConfig.setTitle(this.jEK, true);
        }
        if (!a(this.mContext.getPageActivity(), writeActivityConfig)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwv() {
        rM(false);
        TiebaStatic.log(new am("c12611").bT("obj_locate", this.jEL).P("obj_type", 2));
        if (this.jvK == null) {
            this.jvK = new ForumWriteData("0", null, null, null);
        }
        this.jvK.mFrom = this.mFrom;
        this.jvK.writeCallFrom = this.writeCallFrom;
        i.a(this.mContext, "", this.jvK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FJ(String str) {
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
        if (this.jvK == null) {
            str2 = "";
            str3 = "";
            i = 0;
            str4 = null;
            i2 = -1;
            str5 = null;
            str6 = "0";
        } else {
            String str7 = this.jvK.forumId;
            String str8 = this.jvK.forumName;
            postPrefixData = this.jvK.prefixData;
            antiData = this.jvK.antiData;
            int i3 = this.jvK.forumLevel;
            String str9 = this.jvK.avatar;
            int i4 = this.jvK.privateThread;
            String str10 = this.jvK.firstDir;
            str2 = this.jvK.secondDir;
            str3 = str10;
            i = i4;
            str4 = str9;
            i2 = i3;
            str5 = str8;
            str6 = str7;
        }
        TiebaStatic.log(new am("c12611").bT("obj_locate", this.jEL).P("obj_type", 1));
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
        writeActivityConfig.setProfessionZone(this.jvK != null ? this.jvK.defaultZone : -1);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
    }

    private void cww() {
        if (this.mFrom == "main_tab" && com.baidu.adp.lib.b.d.hI().ay("android_bigday_switch") != 0 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.agM().getLong("key_bigday_next_showtime_write", 0L)) {
            this.jEN = com.baidu.tbadk.core.bigday.b.abp().gN(3);
            if (this.jEN != null && this.jEN.abo()) {
                this.jEH.jFi.startLoad(this.jEN.imgUrl, 41, false);
                this.jEH.jFi.setVisibility(0);
                this.jEH.jFi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.jEN != null && !StringUtils.isNULL(e.this.jEN.bCQ)) {
                            ba.aiz().c(e.this.mContext, new String[]{e.this.jEN.bCQ});
                            TiebaStatic.log(new am("c13114").l(VideoPlayActivityConfig.OBJ_ID, e.this.jEN.bCS).bT("obj_to", e.this.jEN.bCQ));
                            e.this.rM(false);
                        }
                    }
                });
                this.jEH.jFi.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.write.e.11
                    @Override // com.baidu.tbadk.widget.TbImageView.b
                    public void a(TbImageView tbImageView, Canvas canvas) {
                        if (e.this.jEH.jFi.getBdImage() == null && e.this.jEN != null && !ap.isEmpty(e.this.jEN.imgUrl)) {
                            e.this.jEH.jFi.startLoad(e.this.jEN.imgUrl, 41, false);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.b
                    public void b(TbImageView tbImageView, Canvas canvas) {
                    }
                });
                ViewGroup.LayoutParams layoutParams = this.jEH.jFi.getLayoutParams();
                if (layoutParams instanceof RelativeLayout.LayoutParams) {
                    int af = (int) (l.af(this.mContext.getContext()) * 0.546d);
                    layoutParams.width = af;
                    layoutParams.height = af;
                    ((RelativeLayout.LayoutParams) layoutParams).topMargin = l.ah(this.mContext.getContext()) / 5;
                    this.jEH.jFi.setLayoutParams(layoutParams);
                }
                this.jEH.jFj.setVisibility(0);
                this.jEH.jFj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.jEH.jFj.clearAnimation();
                        e.this.jEH.jFi.clearAnimation();
                        e.this.jEH.jFj.setVisibility(8);
                        e.this.jEH.jFi.setVisibility(8);
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(11, 23);
                        calendar.set(12, 59);
                        calendar.set(13, 59);
                        calendar.set(14, 0);
                        com.baidu.tbadk.core.sharedPref.b.agM().putLong("key_bigday_next_showtime_write", calendar.getTimeInMillis());
                    }
                });
                this.jEH.jFi.startAnimation(this.jEM);
                this.jEH.jFj.startAnimation(this.jEM);
                TiebaStatic.log(new am("c13113").l(VideoPlayActivityConfig.OBJ_ID, this.jEN.bCS).bT("obj_to", this.jEN.bCQ));
            }
        }
    }

    private static boolean a(Activity activity, final WriteActivityConfig writeActivityConfig) {
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.aiM();
        aVar.e(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
        aVar.a(new a.InterfaceC0241a() { // from class: com.baidu.tieba.write.e.3
            @Override // com.baidu.tbadk.core.util.b.a.InterfaceC0241a
            public void aiN() {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, WriteActivityConfig.this));
            }
        });
        return aVar.aa(activity);
    }

    public void b(FRSRefreshButton fRSRefreshButton) {
        this.foS = fRSRefreshButton;
    }

    public void cwx() {
        if (this.jEH != null) {
            this.jEH.cwA();
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public View jES;
        public View jET;
        public LinearLayout jEU;
        public TbImageView jEV;
        public TextView jEW;
        public LinearLayout jEX;
        public TbImageView jEY;
        public TextView jEZ;
        public LinearLayout jFa;
        public TbImageView jFb;
        public TextView jFc;
        public LinearLayout jFd;
        public TbImageView jFe;
        public TextView jFf;
        public OvalActionButton jFg;
        public GridLayout jFh;
        public TbImageView jFi;
        public View jFj;
        public TBLottieAnimationView jFk;
        public View mRootView;

        public a(Context context) {
            if (context != null) {
                this.mRootView = LayoutInflater.from(e.this.mContext.getPageActivity()).inflate(R.layout.bottom_write_thread, (ViewGroup) null);
                this.jEX = (LinearLayout) this.mRootView.findViewById(R.id.home_write_article);
                this.jEY = (TbImageView) this.mRootView.findViewById(R.id.home_write_article_icon);
                this.jEZ = (TextView) this.mRootView.findViewById(R.id.home_write_article_title);
                this.jEU = (LinearLayout) this.mRootView.findViewById(R.id.home_write_photo);
                this.jEV = (TbImageView) this.mRootView.findViewById(R.id.home_write_photo_icon);
                this.jEW = (TextView) this.mRootView.findViewById(R.id.home_write_photo_title);
                this.jFa = (LinearLayout) this.mRootView.findViewById(R.id.home_write_album);
                this.jFb = (TbImageView) this.mRootView.findViewById(R.id.home_write_album_icon);
                this.jFc = (TextView) this.mRootView.findViewById(R.id.home_write_album_title);
                this.jFd = (LinearLayout) this.mRootView.findViewById(R.id.home_write_live);
                this.jFe = (TbImageView) this.mRootView.findViewById(R.id.home_write_live_icon);
                this.jFf = (TextView) this.mRootView.findViewById(R.id.home_write_live_title);
                this.jFg = (OvalActionButton) this.mRootView.findViewById(R.id.write_close_view);
                this.jET = this.mRootView.findViewById(R.id.view_background_white);
                this.jES = this.mRootView.findViewById(R.id.view_background_translate);
                this.jFh = (GridLayout) this.mRootView.findViewById(R.id.type_container);
                this.jFh.setMeasureAllChild(true);
                this.jFh.setVerNum(1);
                this.jFi = (TbImageView) this.mRootView.findViewById(R.id.write_tab_bigday_img);
                this.jFj = this.mRootView.findViewById(R.id.write_tab_bigday_close);
                this.jFk = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
                this.jFk.setSpeed(1.2f);
                cwA();
            }
        }

        public void cwy() {
            this.jES.setOnClickListener(e.this.jEO);
        }

        public void cwz() {
            this.jES.setOnClickListener(null);
            this.jES.setClickable(false);
        }

        public void cwA() {
            int af = l.af(e.this.mContext.getPageActivity());
            int i = (int) (0.15555556f * af);
            c(this.jEY, i);
            c(this.jEV, i);
            c(this.jFb, i);
            c(this.jFe, i);
            float g = (af * 1.0f) / l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
            ViewGroup.LayoutParams layoutParams = this.jFh.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = (int) (l.g(TbadkCoreApplication.getInst(), R.dimen.tbds418) * g);
                this.jFh.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.jET.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                int g2 = (int) (l.g(TbadkCoreApplication.getInst(), R.dimen.tbds912) * g);
                ((RelativeLayout.LayoutParams) layoutParams2).height = g2 <= 0 ? 912 : g2;
                this.jET.setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = this.jFk.getLayoutParams();
            if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams3).height = (int) ((g * l.g(TbadkCoreApplication.getInst(), R.dimen.tbds800)) - ((l.g(TbadkCoreApplication.getInst(), R.dimen.tbds135) * g) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()));
                this.jFk.setLayoutParams(layoutParams3);
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
