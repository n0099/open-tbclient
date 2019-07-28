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
    private FRSRefreshButton ftR;
    private ForumWriteData jBT;
    private a jLJ;
    private boolean jLK;
    private f jLL;
    private String jLM;
    private String jLN;
    private Animation jLO;
    private com.baidu.tbadk.core.bigday.a jLP;
    private View.OnClickListener jLQ;
    private f.a jLR;
    private TbPageContext mContext;
    private String mFrom;
    private ViewGroup mParentView;
    private int mSkinType;
    private String writeCallFrom;

    public e(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this(tbPageContext, viewGroup, str, 1);
    }

    public e(TbPageContext tbPageContext, ViewGroup viewGroup, String str, int i) {
        this.jLK = false;
        this.mSkinType = 3;
        this.jLM = "";
        this.mFrom = AlbumActivityConfig.FROM_WRITE;
        this.jLN = "0";
        this.jLQ = new View.OnClickListener() { // from class: com.baidu.tieba.write.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.bgColor != 0) {
                    UtilHelper.setNavigationBarBackground(e.this.mContext.getPageActivity(), e.this.bgColor);
                }
                e.this.sb(true);
            }
        };
        this.jLR = new f.a() { // from class: com.baidu.tieba.write.e.5
            @Override // com.baidu.tieba.write.f.a
            public void CN(int i2) {
                if (i2 == 1) {
                    e.this.jLK = true;
                    if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (e.this.jLL instanceof c)) {
                        if (e.this.Om == null) {
                            e.this.Om = new com.baidu.tbadk.p.a.a("anim_switch_sendthread_maintab");
                        }
                        e.this.Om.avB();
                    }
                } else if (i2 == 2) {
                    if (e.this.Om != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (e.this.jLL instanceof c)) {
                        e.this.Om.avC();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 0));
                } else if (i2 == 4) {
                    e.this.jLK = false;
                    if (e.this.jLJ.mRootView.getParent() == e.this.mParentView && e.this.mParentView != null && e.this.jLJ.mRootView != null && e.this.mParentView.indexOfChild(e.this.jLJ.mRootView) > 0) {
                        e.this.mParentView.removeView(e.this.jLJ.mRootView);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 1));
                }
            }
        };
        this.mContext = tbPageContext;
        this.mParentView = viewGroup;
        this.mFrom = str;
        this.jLJ = new a(tbPageContext.getPageActivity());
        initView();
        this.jLL = g.a(i, tbPageContext.getPageActivity(), this.jLJ);
        this.jLL.a(this.jLR);
    }

    public void GB(String str) {
        if (str == null) {
            str = "";
        }
        this.jLM = str;
    }

    public void a(ForumWriteData forumWriteData) {
        this.jBT = forumWriteData;
    }

    public void GC(String str) {
        if ("3".equals(str)) {
            this.writeCallFrom = "1";
        } else {
            this.writeCallFrom = str;
        }
        this.jLN = str;
    }

    private void initView() {
        this.jLJ.czz();
        this.jLJ.jMc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.GD(e.this.jLM);
            }
        });
        this.jLJ.jLZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.czw();
            }
        });
        this.jLJ.jMf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.czv();
            }
        });
        this.jLJ.jMi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.czu();
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.jLO = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), R.anim.write_tab_bg_anim);
        this.jLO.setFillAfter(true);
    }

    public boolean isShowing() {
        return this.jLK;
    }

    public void CL(int i) {
        this.bgColor = i;
    }

    public void a(boolean z, View view, View view2) {
        if (this.mParentView != null) {
            czx();
            if (this.jLJ.mRootView.getParent() == null) {
                com.baidu.tbadk.m.e.bg(this.mParentView).a(this.mParentView, this.jLJ.mRootView, z);
            }
            this.jLL.b(view, view2);
            this.jLL.show();
            TiebaStatic.log(new an("c12052").bT("obj_locate", this.jLN));
            if (j.ke()) {
                String string = com.baidu.tbadk.core.sharedPref.b.ahO().getString("key_baidu_sim_card_writting_tip", "");
                if (!aq.isEmpty(string)) {
                    BdToast.b(this.mContext.getContext(), string).agQ();
                    com.baidu.tbadk.core.sharedPref.b.ahO().remove("key_baidu_sim_card_writting_tip");
                }
            }
        }
    }

    public void CM(int i) {
        this.jLJ.jMk.setIconFade(i);
    }

    public void sb(boolean z) {
        this.jLL.bM(z);
        if (!z) {
            this.jLJ.jMk.atU();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            this.jLJ.jMk.onChangeSkinType(i);
            am.a(this.jLJ.jMo, (int) R.raw.bottom_bar_bg);
            am.k(this.jLJ.jLX, R.drawable.write_tab_background);
            am.c(this.jLJ.jLZ, (int) R.drawable.icon_post_type_photograph_n);
            am.c(this.jLJ.jMc, (int) R.drawable.icon_post_type_text_n);
            am.c(this.jLJ.jMf, (int) R.drawable.icon_post_type_image_n);
            am.c(this.jLJ.jMi, (int) R.drawable.icon_post_type_live_n);
            am.j(this.jLJ.jMa, R.color.cp_cont_b);
            am.j(this.jLJ.jMd, R.color.cp_cont_b);
            am.j(this.jLJ.jMg, R.color.cp_cont_b);
            am.j(this.jLJ.jMj, R.color.cp_cont_b);
        }
    }

    public void onDestroy() {
        if (this.jLJ.mRootView != null && this.jLJ.mRootView.getParent() == this.mParentView) {
            this.mParentView.removeView(this.jLJ.mRootView);
        }
        this.jLL.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czu() {
        sb(false);
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
            aVar.b(this.mContext).agI();
            return;
        }
        a(this.mContext, this.jLN, this.jBT);
    }

    public void a(TbPageContext tbPageContext, final String str, final ForumWriteData forumWriteData) {
        if (tbPageContext != null) {
            com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
            aVar.ajQ();
            aVar.e(tbPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            aVar.e(tbPageContext.getPageActivity(), "android.permission.CAMERA");
            aVar.e(tbPageContext.getPageActivity(), "android.permission.RECORD_AUDIO");
            aVar.a(new a.InterfaceC0243a() { // from class: com.baidu.tieba.write.e.11
                @Override // com.baidu.tbadk.core.util.b.a.InterfaceC0243a
                public void ajR() {
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
    public void czv() {
        String str;
        String str2;
        int i;
        String str3;
        int i2;
        String str4;
        String str5;
        sb(false);
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.jBT == null) {
            str = "";
            str2 = "";
            i = 0;
            str3 = null;
            i2 = -1;
            str4 = null;
            str5 = "0";
        } else {
            String str6 = this.jBT.forumId;
            String str7 = this.jBT.forumName;
            postPrefixData = this.jBT.prefixData;
            antiData = this.jBT.antiData;
            int i3 = this.jBT.forumLevel;
            String str8 = this.jBT.avatar;
            int i4 = this.jBT.privateThread;
            String str9 = this.jBT.firstDir;
            str = this.jBT.secondDir;
            str2 = str9;
            i = i4;
            str3 = str8;
            i2 = i3;
            str4 = str7;
            str5 = str6;
        }
        TiebaStatic.log(new an("c12611").bT("obj_locate", this.jLN).P("obj_type", 3));
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mContext.getPageActivity(), 0, str5, str4, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom(this.writeCallFrom);
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str3);
        writeActivityConfig.setAlbumThread(1);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setProfessionZone(this.jBT != null ? this.jBT.defaultZone : -1);
        writeActivityConfig.setForumDir(str2, str);
        if (!StringUtils.isNull(this.jLM)) {
            writeActivityConfig.setTitle(this.jLM, true);
        }
        if (!a(this.mContext.getPageActivity(), writeActivityConfig)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czw() {
        sb(false);
        TiebaStatic.log(new an("c12611").bT("obj_locate", this.jLN).P("obj_type", 2));
        if (this.jBT == null) {
            this.jBT = new ForumWriteData("0", null, null, null);
        }
        this.jBT.mFrom = this.mFrom;
        this.jBT.writeCallFrom = this.writeCallFrom;
        i.b(this.mContext, "", this.jBT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GD(String str) {
        String str2;
        String str3;
        int i;
        String str4;
        int i2;
        String str5;
        String str6;
        sb(false);
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.jBT == null) {
            str2 = "";
            str3 = "";
            i = 0;
            str4 = null;
            i2 = -1;
            str5 = null;
            str6 = "0";
        } else {
            String str7 = this.jBT.forumId;
            String str8 = this.jBT.forumName;
            postPrefixData = this.jBT.prefixData;
            antiData = this.jBT.antiData;
            int i3 = this.jBT.forumLevel;
            String str9 = this.jBT.avatar;
            int i4 = this.jBT.privateThread;
            String str10 = this.jBT.firstDir;
            str2 = this.jBT.secondDir;
            str3 = str10;
            i = i4;
            str4 = str9;
            i2 = i3;
            str5 = str8;
            str6 = str7;
        }
        TiebaStatic.log(new an("c12611").bT("obj_locate", this.jLN).P("obj_type", 1));
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
        writeActivityConfig.setProfessionZone(this.jBT != null ? this.jBT.defaultZone : -1);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
    }

    private void czx() {
        if (this.mFrom == "main_tab" && com.baidu.adp.lib.b.d.hS().az("android_bigday_switch") != 0 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.ahO().getLong("key_bigday_next_showtime_write", 0L)) {
            this.jLP = com.baidu.tbadk.core.bigday.b.aco().gR(3);
            if (this.jLP != null && this.jLP.acn()) {
                this.jLJ.jMm.startLoad(this.jLP.imgUrl, 41, false);
                this.jLJ.jMm.setVisibility(0);
                this.jLJ.jMm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.jLP != null && !StringUtils.isNULL(e.this.jLP.bDN)) {
                            bb.ajC().c(e.this.mContext, new String[]{e.this.jLP.bDN});
                            TiebaStatic.log(new an("c13114").l(VideoPlayActivityConfig.OBJ_ID, e.this.jLP.bDP).bT("obj_to", e.this.jLP.bDN));
                            e.this.sb(false);
                        }
                    }
                });
                this.jLJ.jMm.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.write.e.2
                    @Override // com.baidu.tbadk.widget.TbImageView.b
                    public void a(TbImageView tbImageView, Canvas canvas) {
                        if (e.this.jLJ.jMm.getBdImage() == null && e.this.jLP != null && !aq.isEmpty(e.this.jLP.imgUrl)) {
                            e.this.jLJ.jMm.startLoad(e.this.jLP.imgUrl, 41, false);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.b
                    public void b(TbImageView tbImageView, Canvas canvas) {
                    }
                });
                ViewGroup.LayoutParams layoutParams = this.jLJ.jMm.getLayoutParams();
                if (layoutParams instanceof RelativeLayout.LayoutParams) {
                    int af = (int) (l.af(this.mContext.getContext()) * 0.546d);
                    layoutParams.width = af;
                    layoutParams.height = af;
                    ((RelativeLayout.LayoutParams) layoutParams).topMargin = l.ah(this.mContext.getContext()) / 5;
                    this.jLJ.jMm.setLayoutParams(layoutParams);
                }
                this.jLJ.jMn.setVisibility(0);
                this.jLJ.jMn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.jLJ.jMn.clearAnimation();
                        e.this.jLJ.jMm.clearAnimation();
                        e.this.jLJ.jMn.setVisibility(8);
                        e.this.jLJ.jMm.setVisibility(8);
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(11, 23);
                        calendar.set(12, 59);
                        calendar.set(13, 59);
                        calendar.set(14, 0);
                        com.baidu.tbadk.core.sharedPref.b.ahO().putLong("key_bigday_next_showtime_write", calendar.getTimeInMillis());
                    }
                });
                this.jLJ.jMm.startAnimation(this.jLO);
                this.jLJ.jMn.startAnimation(this.jLO);
                TiebaStatic.log(new an("c13113").l(VideoPlayActivityConfig.OBJ_ID, this.jLP.bDP).bT("obj_to", this.jLP.bDN));
            }
        }
    }

    private static boolean a(Activity activity, final WriteActivityConfig writeActivityConfig) {
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.ajQ();
        aVar.e(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
        aVar.a(new a.InterfaceC0243a() { // from class: com.baidu.tieba.write.e.4
            @Override // com.baidu.tbadk.core.util.b.a.InterfaceC0243a
            public void ajR() {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, WriteActivityConfig.this));
            }
        });
        return aVar.ad(activity);
    }

    public void b(FRSRefreshButton fRSRefreshButton) {
        this.ftR = fRSRefreshButton;
    }

    public void czy() {
        if (this.jLJ != null) {
            this.jLJ.czB();
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public View jLW;
        public View jLX;
        public LinearLayout jLY;
        public TbImageView jLZ;
        public TextView jMa;
        public LinearLayout jMb;
        public TbImageView jMc;
        public TextView jMd;
        public LinearLayout jMe;
        public TbImageView jMf;
        public TextView jMg;
        public LinearLayout jMh;
        public TbImageView jMi;
        public TextView jMj;
        public OvalActionButton jMk;
        public GridLayout jMl;
        public TbImageView jMm;
        public View jMn;
        public TBLottieAnimationView jMo;
        public View mRootView;

        public a(Context context) {
            if (context != null) {
                this.mRootView = LayoutInflater.from(e.this.mContext.getPageActivity()).inflate(R.layout.bottom_write_thread, (ViewGroup) null);
                this.jMb = (LinearLayout) this.mRootView.findViewById(R.id.home_write_article);
                this.jMc = (TbImageView) this.mRootView.findViewById(R.id.home_write_article_icon);
                this.jMd = (TextView) this.mRootView.findViewById(R.id.home_write_article_title);
                this.jLY = (LinearLayout) this.mRootView.findViewById(R.id.home_write_photo);
                this.jLZ = (TbImageView) this.mRootView.findViewById(R.id.home_write_photo_icon);
                this.jMa = (TextView) this.mRootView.findViewById(R.id.home_write_photo_title);
                this.jMe = (LinearLayout) this.mRootView.findViewById(R.id.home_write_album);
                this.jMf = (TbImageView) this.mRootView.findViewById(R.id.home_write_album_icon);
                this.jMg = (TextView) this.mRootView.findViewById(R.id.home_write_album_title);
                this.jMh = (LinearLayout) this.mRootView.findViewById(R.id.home_write_live);
                this.jMi = (TbImageView) this.mRootView.findViewById(R.id.home_write_live_icon);
                this.jMj = (TextView) this.mRootView.findViewById(R.id.home_write_live_title);
                this.jMk = (OvalActionButton) this.mRootView.findViewById(R.id.write_close_view);
                this.jLX = this.mRootView.findViewById(R.id.view_background_white);
                this.jLW = this.mRootView.findViewById(R.id.view_background_translate);
                this.jMl = (GridLayout) this.mRootView.findViewById(R.id.type_container);
                this.jMl.setMeasureAllChild(true);
                this.jMl.setVerNum(1);
                this.jMm = (TbImageView) this.mRootView.findViewById(R.id.write_tab_bigday_img);
                this.jMn = this.mRootView.findViewById(R.id.write_tab_bigday_close);
                this.jMo = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
                this.jMo.setSpeed(1.2f);
                czB();
            }
        }

        public void czz() {
            this.jLW.setOnClickListener(e.this.jLQ);
        }

        public void czA() {
            this.jLW.setOnClickListener(null);
            this.jLW.setClickable(false);
        }

        public void czB() {
            int af = l.af(e.this.mContext.getPageActivity());
            int i = (int) (0.15555556f * af);
            c(this.jMc, i);
            c(this.jLZ, i);
            c(this.jMf, i);
            c(this.jMi, i);
            float g = (af * 1.0f) / l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
            ViewGroup.LayoutParams layoutParams = this.jMl.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = (int) (l.g(TbadkCoreApplication.getInst(), R.dimen.tbds418) * g);
                this.jMl.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.jLX.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                int g2 = (int) (l.g(TbadkCoreApplication.getInst(), R.dimen.tbds912) * g);
                ((RelativeLayout.LayoutParams) layoutParams2).height = g2 <= 0 ? 912 : g2;
                this.jLX.setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = this.jMo.getLayoutParams();
            if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams3).height = (int) ((g * l.g(TbadkCoreApplication.getInst(), R.dimen.tbds800)) - ((l.g(TbadkCoreApplication.getInst(), R.dimen.tbds135) * g) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()));
                this.jMo.setLayoutParams(layoutParams3);
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
