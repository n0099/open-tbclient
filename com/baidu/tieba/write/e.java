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
    private com.baidu.tbadk.p.a.a NW;
    private int bgColor;
    private FRSRefreshButton foS;
    private a jEE;
    private boolean jEF;
    private f jEG;
    private String jEH;
    private String jEI;
    private Animation jEJ;
    private com.baidu.tbadk.core.bigday.a jEK;
    private View.OnClickListener jEL;
    private f.a jEM;
    private ForumWriteData jvH;
    private TbPageContext mContext;
    private String mFrom;
    private ViewGroup mParentView;
    private int mSkinType;
    private String writeCallFrom;

    public e(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this(tbPageContext, viewGroup, str, 1);
    }

    public e(TbPageContext tbPageContext, ViewGroup viewGroup, String str, int i) {
        this.jEF = false;
        this.mSkinType = 3;
        this.jEH = "";
        this.mFrom = AlbumActivityConfig.FROM_WRITE;
        this.jEI = "0";
        this.jEL = new View.OnClickListener() { // from class: com.baidu.tieba.write.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.bgColor != 0) {
                    UtilHelper.setNavigationBarBackground(e.this.mContext.getPageActivity(), e.this.bgColor);
                }
                e.this.rL(true);
            }
        };
        this.jEM = new f.a() { // from class: com.baidu.tieba.write.e.4
            @Override // com.baidu.tieba.write.f.a
            public void Cg(int i2) {
                if (i2 == 1) {
                    e.this.jEF = true;
                    if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (e.this.jEG instanceof c)) {
                        if (e.this.NW == null) {
                            e.this.NW = new com.baidu.tbadk.p.a.a("anim_switch_sendthread_maintab");
                        }
                        e.this.NW.aus();
                    }
                } else if (i2 == 2) {
                    if (e.this.NW != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (e.this.jEG instanceof c)) {
                        e.this.NW.aut();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 0));
                } else if (i2 == 4) {
                    e.this.jEF = false;
                    if (e.this.jEE.mRootView.getParent() == e.this.mParentView && e.this.mParentView != null && e.this.jEE.mRootView != null && e.this.mParentView.indexOfChild(e.this.jEE.mRootView) > 0) {
                        e.this.mParentView.removeView(e.this.jEE.mRootView);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 1));
                }
            }
        };
        this.mContext = tbPageContext;
        this.mParentView = viewGroup;
        this.mFrom = str;
        this.jEE = new a(tbPageContext.getPageActivity());
        initView();
        this.jEG = g.a(i, tbPageContext.getPageActivity(), this.jEE);
        this.jEG.a(this.jEM);
    }

    public void FF(String str) {
        if (str == null) {
            str = "";
        }
        this.jEH = str;
    }

    public void a(ForumWriteData forumWriteData) {
        this.jvH = forumWriteData;
    }

    public void FG(String str) {
        if ("3".equals(str)) {
            this.writeCallFrom = "1";
        } else {
            this.writeCallFrom = str;
        }
        this.jEI = str;
    }

    private void initView() {
        this.jEE.cwz();
        this.jEE.jEV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.FH(e.this.jEH);
            }
        });
        this.jEE.jES.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.cww();
            }
        });
        this.jEE.jEY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.cwv();
            }
        });
        this.jEE.jFb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.cwu();
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.jEJ = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), R.anim.write_tab_bg_anim);
        this.jEJ.setFillAfter(true);
    }

    public boolean isShowing() {
        return this.jEF;
    }

    public void Ce(int i) {
        this.bgColor = i;
    }

    public void a(boolean z, View view, View view2) {
        if (this.mParentView != null) {
            cwx();
            if (this.jEE.mRootView.getParent() == null) {
                com.baidu.tbadk.m.e.be(this.mParentView).a(this.mParentView, this.jEE.mRootView, z);
            }
            this.jEG.b(view, view2);
            this.jEG.show();
            TiebaStatic.log(new am("c12052").bT("obj_locate", this.jEI));
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
        this.jEE.jFd.setIconFade(i);
    }

    public void rL(boolean z) {
        this.jEG.bJ(z);
        if (!z) {
            this.jEE.jFd.asM();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            this.jEE.jFd.onChangeSkinType(i);
            al.a(this.jEE.jFh, (int) R.raw.bottom_bar_bg);
            al.k(this.jEE.jEQ, R.drawable.write_tab_background);
            al.c(this.jEE.jES, (int) R.drawable.icon_post_type_photograph_n);
            al.c(this.jEE.jEV, (int) R.drawable.icon_post_type_text_n);
            al.c(this.jEE.jEY, (int) R.drawable.icon_post_type_image_n);
            al.c(this.jEE.jFb, (int) R.drawable.icon_post_type_live_n);
            al.j(this.jEE.jET, R.color.cp_cont_b);
            al.j(this.jEE.jEW, R.color.cp_cont_b);
            al.j(this.jEE.jEZ, R.color.cp_cont_b);
            al.j(this.jEE.jFc, R.color.cp_cont_b);
        }
    }

    public void onDestroy() {
        if (this.jEE.mRootView != null && this.jEE.mRootView.getParent() == this.mParentView) {
            this.mParentView.removeView(this.jEE.mRootView);
        }
        this.jEG.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwu() {
        String str;
        String str2 = null;
        rL(false);
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            aVar.setAutoNight(false);
            aVar.hn(R.string.prompt);
            aVar.mE(this.mContext.getResources().getString(R.string.disallow_open_live_by_android_v5_0));
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
        if (this.jvH != null) {
            str3 = this.jvH.forumId;
            str = this.jvH.forumName;
            str2 = this.jvH.specialForumType;
        } else {
            str = null;
        }
        TiebaStatic.log(new am("c12611").bT("obj_locate", this.jEI).P("obj_type", 4));
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(TbadkCoreApplication.getInst().getApplicationContext(), str, str3, TbadkCoreApplication.getCurrentAccount(), str2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwv() {
        String str;
        String str2;
        int i;
        String str3;
        int i2;
        String str4;
        String str5;
        rL(false);
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.jvH == null) {
            str = "";
            str2 = "";
            i = 0;
            str3 = null;
            i2 = -1;
            str4 = null;
            str5 = "0";
        } else {
            String str6 = this.jvH.forumId;
            String str7 = this.jvH.forumName;
            postPrefixData = this.jvH.prefixData;
            antiData = this.jvH.antiData;
            int i3 = this.jvH.forumLevel;
            String str8 = this.jvH.avatar;
            int i4 = this.jvH.privateThread;
            String str9 = this.jvH.firstDir;
            str = this.jvH.secondDir;
            str2 = str9;
            i = i4;
            str3 = str8;
            i2 = i3;
            str4 = str7;
            str5 = str6;
        }
        TiebaStatic.log(new am("c12611").bT("obj_locate", this.jEI).P("obj_type", 3));
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mContext.getPageActivity(), 0, str5, str4, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom(this.writeCallFrom);
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str3);
        writeActivityConfig.setAlbumThread(1);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setProfessionZone(this.jvH != null ? this.jvH.defaultZone : -1);
        writeActivityConfig.setForumDir(str2, str);
        if (!StringUtils.isNull(this.jEH)) {
            writeActivityConfig.setTitle(this.jEH, true);
        }
        if (!a(this.mContext.getPageActivity(), writeActivityConfig)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cww() {
        rL(false);
        TiebaStatic.log(new am("c12611").bT("obj_locate", this.jEI).P("obj_type", 2));
        if (this.jvH == null) {
            this.jvH = new ForumWriteData("0", null, null, null);
        }
        this.jvH.mFrom = this.mFrom;
        this.jvH.writeCallFrom = this.writeCallFrom;
        i.a(this.mContext, "", this.jvH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FH(String str) {
        String str2;
        String str3;
        int i;
        String str4;
        int i2;
        String str5;
        String str6;
        rL(false);
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.jvH == null) {
            str2 = "";
            str3 = "";
            i = 0;
            str4 = null;
            i2 = -1;
            str5 = null;
            str6 = "0";
        } else {
            String str7 = this.jvH.forumId;
            String str8 = this.jvH.forumName;
            postPrefixData = this.jvH.prefixData;
            antiData = this.jvH.antiData;
            int i3 = this.jvH.forumLevel;
            String str9 = this.jvH.avatar;
            int i4 = this.jvH.privateThread;
            String str10 = this.jvH.firstDir;
            str2 = this.jvH.secondDir;
            str3 = str10;
            i = i4;
            str4 = str9;
            i2 = i3;
            str5 = str8;
            str6 = str7;
        }
        TiebaStatic.log(new am("c12611").bT("obj_locate", this.jEI).P("obj_type", 1));
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
        writeActivityConfig.setProfessionZone(this.jvH != null ? this.jvH.defaultZone : -1);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
    }

    private void cwx() {
        if (this.mFrom == "main_tab" && com.baidu.adp.lib.b.d.hI().ay("android_bigday_switch") != 0 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.agM().getLong("key_bigday_next_showtime_write", 0L)) {
            this.jEK = com.baidu.tbadk.core.bigday.b.abp().gN(3);
            if (this.jEK != null && this.jEK.abo()) {
                this.jEE.jFf.startLoad(this.jEK.imgUrl, 41, false);
                this.jEE.jFf.setVisibility(0);
                this.jEE.jFf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.jEK != null && !StringUtils.isNULL(e.this.jEK.bCP)) {
                            ba.aiz().c(e.this.mContext, new String[]{e.this.jEK.bCP});
                            TiebaStatic.log(new am("c13114").l(VideoPlayActivityConfig.OBJ_ID, e.this.jEK.bCR).bT("obj_to", e.this.jEK.bCP));
                            e.this.rL(false);
                        }
                    }
                });
                this.jEE.jFf.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.write.e.11
                    @Override // com.baidu.tbadk.widget.TbImageView.b
                    public void a(TbImageView tbImageView, Canvas canvas) {
                        if (e.this.jEE.jFf.getBdImage() == null && e.this.jEK != null && !ap.isEmpty(e.this.jEK.imgUrl)) {
                            e.this.jEE.jFf.startLoad(e.this.jEK.imgUrl, 41, false);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.b
                    public void b(TbImageView tbImageView, Canvas canvas) {
                    }
                });
                ViewGroup.LayoutParams layoutParams = this.jEE.jFf.getLayoutParams();
                if (layoutParams instanceof RelativeLayout.LayoutParams) {
                    int af = (int) (l.af(this.mContext.getContext()) * 0.546d);
                    layoutParams.width = af;
                    layoutParams.height = af;
                    ((RelativeLayout.LayoutParams) layoutParams).topMargin = l.ah(this.mContext.getContext()) / 5;
                    this.jEE.jFf.setLayoutParams(layoutParams);
                }
                this.jEE.jFg.setVisibility(0);
                this.jEE.jFg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.jEE.jFg.clearAnimation();
                        e.this.jEE.jFf.clearAnimation();
                        e.this.jEE.jFg.setVisibility(8);
                        e.this.jEE.jFf.setVisibility(8);
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(11, 23);
                        calendar.set(12, 59);
                        calendar.set(13, 59);
                        calendar.set(14, 0);
                        com.baidu.tbadk.core.sharedPref.b.agM().putLong("key_bigday_next_showtime_write", calendar.getTimeInMillis());
                    }
                });
                this.jEE.jFf.startAnimation(this.jEJ);
                this.jEE.jFg.startAnimation(this.jEJ);
                TiebaStatic.log(new am("c13113").l(VideoPlayActivityConfig.OBJ_ID, this.jEK.bCR).bT("obj_to", this.jEK.bCP));
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

    public void cwy() {
        if (this.jEE != null) {
            this.jEE.cwB();
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public View jEP;
        public View jEQ;
        public LinearLayout jER;
        public TbImageView jES;
        public TextView jET;
        public LinearLayout jEU;
        public TbImageView jEV;
        public TextView jEW;
        public LinearLayout jEX;
        public TbImageView jEY;
        public TextView jEZ;
        public LinearLayout jFa;
        public TbImageView jFb;
        public TextView jFc;
        public OvalActionButton jFd;
        public GridLayout jFe;
        public TbImageView jFf;
        public View jFg;
        public TBLottieAnimationView jFh;
        public View mRootView;

        public a(Context context) {
            if (context != null) {
                this.mRootView = LayoutInflater.from(e.this.mContext.getPageActivity()).inflate(R.layout.bottom_write_thread, (ViewGroup) null);
                this.jEU = (LinearLayout) this.mRootView.findViewById(R.id.home_write_article);
                this.jEV = (TbImageView) this.mRootView.findViewById(R.id.home_write_article_icon);
                this.jEW = (TextView) this.mRootView.findViewById(R.id.home_write_article_title);
                this.jER = (LinearLayout) this.mRootView.findViewById(R.id.home_write_photo);
                this.jES = (TbImageView) this.mRootView.findViewById(R.id.home_write_photo_icon);
                this.jET = (TextView) this.mRootView.findViewById(R.id.home_write_photo_title);
                this.jEX = (LinearLayout) this.mRootView.findViewById(R.id.home_write_album);
                this.jEY = (TbImageView) this.mRootView.findViewById(R.id.home_write_album_icon);
                this.jEZ = (TextView) this.mRootView.findViewById(R.id.home_write_album_title);
                this.jFa = (LinearLayout) this.mRootView.findViewById(R.id.home_write_live);
                this.jFb = (TbImageView) this.mRootView.findViewById(R.id.home_write_live_icon);
                this.jFc = (TextView) this.mRootView.findViewById(R.id.home_write_live_title);
                this.jFd = (OvalActionButton) this.mRootView.findViewById(R.id.write_close_view);
                this.jEQ = this.mRootView.findViewById(R.id.view_background_white);
                this.jEP = this.mRootView.findViewById(R.id.view_background_translate);
                this.jFe = (GridLayout) this.mRootView.findViewById(R.id.type_container);
                this.jFe.setMeasureAllChild(true);
                this.jFe.setVerNum(1);
                this.jFf = (TbImageView) this.mRootView.findViewById(R.id.write_tab_bigday_img);
                this.jFg = this.mRootView.findViewById(R.id.write_tab_bigday_close);
                this.jFh = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
                this.jFh.setSpeed(1.2f);
                cwB();
            }
        }

        public void cwz() {
            this.jEP.setOnClickListener(e.this.jEL);
        }

        public void cwA() {
            this.jEP.setOnClickListener(null);
            this.jEP.setClickable(false);
        }

        public void cwB() {
            int af = l.af(e.this.mContext.getPageActivity());
            int i = (int) (0.15555556f * af);
            c(this.jEV, i);
            c(this.jES, i);
            c(this.jEY, i);
            c(this.jFb, i);
            float g = (af * 1.0f) / l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
            ViewGroup.LayoutParams layoutParams = this.jFe.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = (int) (l.g(TbadkCoreApplication.getInst(), R.dimen.tbds418) * g);
                this.jFe.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.jEQ.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                int g2 = (int) (l.g(TbadkCoreApplication.getInst(), R.dimen.tbds912) * g);
                ((RelativeLayout.LayoutParams) layoutParams2).height = g2 <= 0 ? 912 : g2;
                this.jEQ.setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = this.jFh.getLayoutParams();
            if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams3).height = (int) ((g * l.g(TbadkCoreApplication.getInst(), R.dimen.tbds800)) - ((l.g(TbadkCoreApplication.getInst(), R.dimen.tbds135) * g) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()));
                this.jFh.setLayoutParams(layoutParams3);
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
