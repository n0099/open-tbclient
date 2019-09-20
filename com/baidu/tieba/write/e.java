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
    private com.baidu.tbadk.p.a.a Ol;
    private int bgColor;
    private FRSRefreshButton fwd;
    private ForumWriteData jFw;
    private a jPl;
    private boolean jPm;
    private f jPn;
    private String jPo;
    private String jPp;
    private Animation jPq;
    private com.baidu.tbadk.core.bigday.a jPr;
    private View.OnClickListener jPs;
    private f.a jPt;
    private TbPageContext mContext;
    private String mFrom;
    private ViewGroup mParentView;
    private int mSkinType;
    private String writeCallFrom;

    public e(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this(tbPageContext, viewGroup, str, 1);
    }

    public e(TbPageContext tbPageContext, ViewGroup viewGroup, String str, int i) {
        this.jPm = false;
        this.mSkinType = 3;
        this.jPo = "";
        this.mFrom = AlbumActivityConfig.FROM_WRITE;
        this.jPp = "0";
        this.jPs = new View.OnClickListener() { // from class: com.baidu.tieba.write.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.bgColor != 0) {
                    UtilHelper.setNavigationBarBackground(e.this.mContext.getPageActivity(), e.this.bgColor);
                }
                e.this.sf(true);
            }
        };
        this.jPt = new f.a() { // from class: com.baidu.tieba.write.e.5
            @Override // com.baidu.tieba.write.f.a
            public void CT(int i2) {
                if (i2 == 1) {
                    e.this.jPm = true;
                    if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (e.this.jPn instanceof c)) {
                        if (e.this.Ol == null) {
                            e.this.Ol = new com.baidu.tbadk.p.a.a("anim_switch_sendthread_maintab");
                        }
                        e.this.Ol.avP();
                    }
                } else if (i2 == 2) {
                    if (e.this.Ol != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (e.this.jPn instanceof c)) {
                        e.this.Ol.avQ();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 0));
                } else if (i2 == 4) {
                    e.this.jPm = false;
                    if (e.this.jPl.mRootView.getParent() == e.this.mParentView && e.this.mParentView != null && e.this.jPl.mRootView != null && e.this.mParentView.indexOfChild(e.this.jPl.mRootView) > 0) {
                        e.this.mParentView.removeView(e.this.jPl.mRootView);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 1));
                }
            }
        };
        this.mContext = tbPageContext;
        this.mParentView = viewGroup;
        this.mFrom = str;
        this.jPl = new a(tbPageContext.getPageActivity());
        initView();
        this.jPn = g.a(i, tbPageContext.getPageActivity(), this.jPl);
        this.jPn.a(this.jPt);
    }

    public void Hc(String str) {
        if (str == null) {
            str = "";
        }
        this.jPo = str;
    }

    public void a(ForumWriteData forumWriteData) {
        this.jFw = forumWriteData;
    }

    public void Hd(String str) {
        if ("3".equals(str)) {
            this.writeCallFrom = "1";
        } else {
            this.writeCallFrom = str;
        }
        this.jPp = str;
    }

    private void initView() {
        this.jPl.cAI();
        this.jPl.jPE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.He(e.this.jPo);
            }
        });
        this.jPl.jPB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.cAF();
            }
        });
        this.jPl.jPH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.cAE();
            }
        });
        this.jPl.jPK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.cAD();
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.jPq = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), R.anim.write_tab_bg_anim);
        this.jPq.setFillAfter(true);
    }

    public boolean isShowing() {
        return this.jPm;
    }

    public void CR(int i) {
        this.bgColor = i;
    }

    public void a(boolean z, View view, View view2) {
        if (this.mParentView != null) {
            cAG();
            if (this.jPl.mRootView.getParent() == null) {
                com.baidu.tbadk.m.e.bg(this.mParentView).a(this.mParentView, this.jPl.mRootView, z);
            }
            this.jPn.b(view, view2);
            this.jPn.show();
            TiebaStatic.log(new an("c12052").bT("obj_locate", this.jPp));
            if (j.ke()) {
                String string = com.baidu.tbadk.core.sharedPref.b.ahU().getString("key_baidu_sim_card_writting_tip", "");
                if (!aq.isEmpty(string)) {
                    BdToast.b(this.mContext.getContext(), string).agW();
                    com.baidu.tbadk.core.sharedPref.b.ahU().remove("key_baidu_sim_card_writting_tip");
                }
            }
        }
    }

    public void CS(int i) {
        this.jPl.jPM.setIconFade(i);
    }

    public void sf(boolean z) {
        this.jPn.bM(z);
        if (!z) {
            this.jPl.jPM.aui();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            this.jPl.jPM.onChangeSkinType(i);
            am.a(this.jPl.jPQ, (int) R.raw.bottom_bar_bg);
            am.k(this.jPl.jPz, R.drawable.write_tab_background);
            this.jPl.jPB.setImageDrawable(SvgManager.ajv().g(R.drawable.icon_post_photograph_n_svg, 1, true));
            this.jPl.jPE.setImageDrawable(SvgManager.ajv().g(R.drawable.icon_post_text_n_svg, 1, true));
            this.jPl.jPH.setImageDrawable(SvgManager.ajv().g(R.drawable.icon_post_image_n_svg, 1, true));
            this.jPl.jPK.setImageDrawable(SvgManager.ajv().g(R.drawable.icon_post_live_n_svg, 1, true));
            am.j(this.jPl.jPC, R.color.cp_cont_b);
            am.j(this.jPl.jPF, R.color.cp_cont_b);
            am.j(this.jPl.jPI, R.color.cp_cont_b);
            am.j(this.jPl.jPL, R.color.cp_cont_b);
        }
    }

    public void onDestroy() {
        if (this.jPl.mRootView != null && this.jPl.mRootView.getParent() == this.mParentView) {
            this.mParentView.removeView(this.jPl.mRootView);
        }
        this.jPn.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAD() {
        sf(false);
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            aVar.setAutoNight(false);
            aVar.hu(R.string.prompt);
            aVar.mQ(this.mContext.getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.dX(true);
            aVar.dW(true);
            aVar.a(R.string.know, new a.b() { // from class: com.baidu.tieba.write.e.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.mContext).agO();
            return;
        }
        a(this.mContext, this.jPp, this.jFw);
    }

    public void a(TbPageContext tbPageContext, final String str, final ForumWriteData forumWriteData) {
        if (tbPageContext != null) {
            com.baidu.tbadk.core.util.c.a aVar = new com.baidu.tbadk.core.util.c.a();
            aVar.ake();
            aVar.e(tbPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            aVar.e(tbPageContext.getPageActivity(), "android.permission.CAMERA");
            aVar.e(tbPageContext.getPageActivity(), "android.permission.RECORD_AUDIO");
            aVar.a(new a.InterfaceC0252a() { // from class: com.baidu.tieba.write.e.11
                @Override // com.baidu.tbadk.core.util.c.a.InterfaceC0252a
                public void akf() {
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
    public void cAE() {
        String str;
        String str2;
        int i;
        String str3;
        int i2;
        String str4;
        String str5;
        sf(false);
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.jFw == null) {
            str = "";
            str2 = "";
            i = 0;
            str3 = null;
            i2 = -1;
            str4 = null;
            str5 = "0";
        } else {
            String str6 = this.jFw.forumId;
            String str7 = this.jFw.forumName;
            postPrefixData = this.jFw.prefixData;
            antiData = this.jFw.antiData;
            int i3 = this.jFw.forumLevel;
            String str8 = this.jFw.avatar;
            int i4 = this.jFw.privateThread;
            String str9 = this.jFw.firstDir;
            str = this.jFw.secondDir;
            str2 = str9;
            i = i4;
            str3 = str8;
            i2 = i3;
            str4 = str7;
            str5 = str6;
        }
        TiebaStatic.log(new an("c12611").bT("obj_locate", this.jPp).P("obj_type", 3));
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mContext.getPageActivity(), 0, str5, str4, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom(this.writeCallFrom);
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str3);
        writeActivityConfig.setAlbumThread(1);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setProfessionZone(this.jFw != null ? this.jFw.defaultZone : -1);
        writeActivityConfig.setForumDir(str2, str);
        if (!StringUtils.isNull(this.jPo)) {
            writeActivityConfig.setTitle(this.jPo, true);
        }
        if (!a(this.mContext.getPageActivity(), writeActivityConfig)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAF() {
        sf(false);
        TiebaStatic.log(new an("c12611").bT("obj_locate", this.jPp).P("obj_type", 2));
        if (this.jFw == null) {
            this.jFw = new ForumWriteData("0", null, null, null);
        }
        this.jFw.mFrom = this.mFrom;
        this.jFw.writeCallFrom = this.writeCallFrom;
        i.b(this.mContext, "", this.jFw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void He(String str) {
        String str2;
        String str3;
        int i;
        String str4;
        int i2;
        String str5;
        String str6;
        sf(false);
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.jFw == null) {
            str2 = "";
            str3 = "";
            i = 0;
            str4 = null;
            i2 = -1;
            str5 = null;
            str6 = "0";
        } else {
            String str7 = this.jFw.forumId;
            String str8 = this.jFw.forumName;
            postPrefixData = this.jFw.prefixData;
            antiData = this.jFw.antiData;
            int i3 = this.jFw.forumLevel;
            String str9 = this.jFw.avatar;
            int i4 = this.jFw.privateThread;
            String str10 = this.jFw.firstDir;
            str2 = this.jFw.secondDir;
            str3 = str10;
            i = i4;
            str4 = str9;
            i2 = i3;
            str5 = str8;
            str6 = str7;
        }
        TiebaStatic.log(new an("c12611").bT("obj_locate", this.jPp).P("obj_type", 1));
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
        writeActivityConfig.setProfessionZone(this.jFw != null ? this.jFw.defaultZone : -1);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
    }

    private void cAG() {
        if (this.mFrom == "main_tab" && com.baidu.adp.lib.b.d.hS().az("android_bigday_switch") != 0 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.ahU().getLong("key_bigday_next_showtime_write", 0L)) {
            this.jPr = com.baidu.tbadk.core.bigday.b.acs().gS(3);
            if (this.jPr != null && this.jPr.acr()) {
                this.jPl.jPO.startLoad(this.jPr.imgUrl, 41, false);
                this.jPl.jPO.setVisibility(0);
                this.jPl.jPO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.jPr != null && !StringUtils.isNULL(e.this.jPr.bEl)) {
                            ba.ajK().c(e.this.mContext, new String[]{e.this.jPr.bEl});
                            TiebaStatic.log(new an("c13114").n(VideoPlayActivityConfig.OBJ_ID, e.this.jPr.bEn).bT("obj_to", e.this.jPr.bEl));
                            e.this.sf(false);
                        }
                    }
                });
                this.jPl.jPO.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.write.e.2
                    @Override // com.baidu.tbadk.widget.TbImageView.b
                    public void a(TbImageView tbImageView, Canvas canvas) {
                        if (e.this.jPl.jPO.getBdImage() == null && e.this.jPr != null && !aq.isEmpty(e.this.jPr.imgUrl)) {
                            e.this.jPl.jPO.startLoad(e.this.jPr.imgUrl, 41, false);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.b
                    public void b(TbImageView tbImageView, Canvas canvas) {
                    }
                });
                ViewGroup.LayoutParams layoutParams = this.jPl.jPO.getLayoutParams();
                if (layoutParams instanceof RelativeLayout.LayoutParams) {
                    int af = (int) (l.af(this.mContext.getContext()) * 0.546d);
                    layoutParams.width = af;
                    layoutParams.height = af;
                    ((RelativeLayout.LayoutParams) layoutParams).topMargin = l.ah(this.mContext.getContext()) / 5;
                    this.jPl.jPO.setLayoutParams(layoutParams);
                }
                this.jPl.jPP.setVisibility(0);
                this.jPl.jPP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.jPl.jPP.clearAnimation();
                        e.this.jPl.jPO.clearAnimation();
                        e.this.jPl.jPP.setVisibility(8);
                        e.this.jPl.jPO.setVisibility(8);
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(11, 23);
                        calendar.set(12, 59);
                        calendar.set(13, 59);
                        calendar.set(14, 0);
                        com.baidu.tbadk.core.sharedPref.b.ahU().putLong("key_bigday_next_showtime_write", calendar.getTimeInMillis());
                    }
                });
                this.jPl.jPO.startAnimation(this.jPq);
                this.jPl.jPP.startAnimation(this.jPq);
                TiebaStatic.log(new an("c13113").n(VideoPlayActivityConfig.OBJ_ID, this.jPr.bEn).bT("obj_to", this.jPr.bEl));
            }
        }
    }

    private static boolean a(Activity activity, final WriteActivityConfig writeActivityConfig) {
        com.baidu.tbadk.core.util.c.a aVar = new com.baidu.tbadk.core.util.c.a();
        aVar.ake();
        aVar.e(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
        aVar.a(new a.InterfaceC0252a() { // from class: com.baidu.tieba.write.e.4
            @Override // com.baidu.tbadk.core.util.c.a.InterfaceC0252a
            public void akf() {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, WriteActivityConfig.this));
            }
        });
        return aVar.ad(activity);
    }

    public void b(FRSRefreshButton fRSRefreshButton) {
        this.fwd = fRSRefreshButton;
    }

    public void cAH() {
        if (this.jPl != null) {
            this.jPl.cAK();
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public LinearLayout jPA;
        public ImageView jPB;
        public TextView jPC;
        public LinearLayout jPD;
        public ImageView jPE;
        public TextView jPF;
        public LinearLayout jPG;
        public ImageView jPH;
        public TextView jPI;
        public LinearLayout jPJ;
        public ImageView jPK;
        public TextView jPL;
        public OvalActionButton jPM;
        public GridLayout jPN;
        public TbImageView jPO;
        public View jPP;
        public TBLottieAnimationView jPQ;
        public View jPy;
        public View jPz;
        public View mRootView;

        public a(Context context) {
            if (context != null) {
                this.mRootView = LayoutInflater.from(e.this.mContext.getPageActivity()).inflate(R.layout.bottom_write_thread, (ViewGroup) null);
                this.jPD = (LinearLayout) this.mRootView.findViewById(R.id.home_write_article);
                this.jPE = (ImageView) this.mRootView.findViewById(R.id.home_write_article_icon);
                this.jPF = (TextView) this.mRootView.findViewById(R.id.home_write_article_title);
                this.jPA = (LinearLayout) this.mRootView.findViewById(R.id.home_write_photo);
                this.jPB = (ImageView) this.mRootView.findViewById(R.id.home_write_photo_icon);
                this.jPC = (TextView) this.mRootView.findViewById(R.id.home_write_photo_title);
                this.jPG = (LinearLayout) this.mRootView.findViewById(R.id.home_write_album);
                this.jPH = (ImageView) this.mRootView.findViewById(R.id.home_write_album_icon);
                this.jPI = (TextView) this.mRootView.findViewById(R.id.home_write_album_title);
                this.jPJ = (LinearLayout) this.mRootView.findViewById(R.id.home_write_live);
                this.jPK = (ImageView) this.mRootView.findViewById(R.id.home_write_live_icon);
                this.jPL = (TextView) this.mRootView.findViewById(R.id.home_write_live_title);
                this.jPM = (OvalActionButton) this.mRootView.findViewById(R.id.write_close_view);
                this.jPz = this.mRootView.findViewById(R.id.view_background_white);
                this.jPy = this.mRootView.findViewById(R.id.view_background_translate);
                this.jPN = (GridLayout) this.mRootView.findViewById(R.id.type_container);
                this.jPN.setMeasureAllChild(true);
                this.jPN.setVerNum(1);
                this.jPO = (TbImageView) this.mRootView.findViewById(R.id.write_tab_bigday_img);
                this.jPP = this.mRootView.findViewById(R.id.write_tab_bigday_close);
                this.jPQ = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
                this.jPQ.setSpeed(1.2f);
                cAK();
            }
        }

        public void cAI() {
            this.jPy.setOnClickListener(e.this.jPs);
        }

        public void cAJ() {
            this.jPy.setOnClickListener(null);
            this.jPy.setClickable(false);
        }

        public void cAK() {
            int af = l.af(e.this.mContext.getPageActivity());
            int i = (int) (0.15555556f * af);
            d(this.jPE, i);
            d(this.jPB, i);
            d(this.jPH, i);
            d(this.jPK, i);
            float g = (af * 1.0f) / l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
            ViewGroup.LayoutParams layoutParams = this.jPN.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = (int) (l.g(TbadkCoreApplication.getInst(), R.dimen.tbds418) * g);
                this.jPN.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.jPz.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                int g2 = (int) (l.g(TbadkCoreApplication.getInst(), R.dimen.tbds912) * g);
                ((RelativeLayout.LayoutParams) layoutParams2).height = g2 <= 0 ? 912 : g2;
                this.jPz.setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = this.jPQ.getLayoutParams();
            if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams3).height = (int) ((g * l.g(TbadkCoreApplication.getInst(), R.dimen.tbds800)) - ((l.g(TbadkCoreApplication.getInst(), R.dimen.tbds135) * g) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()));
                this.jPQ.setLayoutParams(layoutParams3);
            }
        }

        private void d(ImageView imageView, int i) {
            if (imageView != null && i > 0) {
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                layoutParams.width = i;
                layoutParams.height = i;
                imageView.setLayoutParams(layoutParams);
            }
        }
    }
}
