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
    private com.baidu.tbadk.o.a.a Qo;
    private int bgColor;
    private FRSRefreshButton eYG;
    private ForumWriteData jcL;
    private f jlA;
    private String jlB;
    private String jlC;
    private Animation jlD;
    private com.baidu.tbadk.core.bigday.a jlE;
    private View.OnClickListener jlF;
    private f.a jlG;
    private a jly;
    private boolean jlz;
    private TbPageContext mContext;
    private String mFrom;
    private ViewGroup mParentView;
    private int mSkinType;
    private String writeCallFrom;

    public e(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this(tbPageContext, viewGroup, str, 1);
    }

    public e(TbPageContext tbPageContext, ViewGroup viewGroup, String str, int i) {
        this.jlz = false;
        this.mSkinType = 3;
        this.jlB = "";
        this.mFrom = AlbumActivityConfig.FROM_WRITE;
        this.jlC = "0";
        this.jlF = new View.OnClickListener() { // from class: com.baidu.tieba.write.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.bgColor != 0) {
                    UtilHelper.setNavigationBarBackground(e.this.mContext.getPageActivity(), e.this.bgColor);
                }
                e.this.qW(true);
            }
        };
        this.jlG = new f.a() { // from class: com.baidu.tieba.write.e.4
            @Override // com.baidu.tieba.write.f.a
            public void AX(int i2) {
                if (i2 == 1) {
                    e.this.jlz = true;
                    if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (e.this.jlA instanceof c)) {
                        if (e.this.Qo == null) {
                            e.this.Qo = new com.baidu.tbadk.o.a.a("anim_switch_sendthread_maintab");
                        }
                        e.this.Qo.app();
                    }
                } else if (i2 == 2) {
                    if (e.this.Qo != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (e.this.jlA instanceof c)) {
                        e.this.Qo.apq();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 0));
                } else if (i2 == 4) {
                    e.this.jlz = false;
                    if (e.this.jly.mRootView.getParent() == e.this.mParentView && e.this.mParentView != null && e.this.jly.mRootView != null && e.this.mParentView.indexOfChild(e.this.jly.mRootView) > 0) {
                        e.this.mParentView.removeView(e.this.jly.mRootView);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 1));
                }
            }
        };
        this.mContext = tbPageContext;
        this.mParentView = viewGroup;
        this.mFrom = str;
        this.jly = new a(tbPageContext.getPageActivity());
        initView();
        this.jlA = g.a(i, tbPageContext.getPageActivity(), this.jly);
        this.jlA.a(this.jlG);
    }

    public void Ej(String str) {
        if (str == null) {
            str = "";
        }
        this.jlB = str;
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
        this.jlC = str;
    }

    private void initView() {
        this.jly.coq();
        this.jly.jlP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.El(e.this.jlB);
            }
        });
        this.jly.jlM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.coo();
            }
        });
        this.jly.jlS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.con();
            }
        });
        this.jly.jlV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.com();
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.jlD = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.write_tab_bg_anim);
        this.jlD.setFillAfter(true);
    }

    public boolean isShowing() {
        return this.jlz;
    }

    public void AV(int i) {
        this.bgColor = i;
    }

    public void a(boolean z, View view, View view2) {
        if (this.mParentView != null) {
            cop();
            if (this.jly.mRootView.getParent() == null) {
                com.baidu.tbadk.m.e.aY(this.mParentView).a(this.mParentView, this.jly.mRootView, z);
            }
            this.jlA.b(view, view2);
            this.jlA.show();
            TiebaStatic.log(new am("c12052").bJ("obj_locate", this.jlC));
            if (j.la()) {
                String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_baidu_sim_card_writting_tip", "");
                if (!ap.isEmpty(string)) {
                    BdToast.b(this.mContext.getContext(), string).abe();
                    com.baidu.tbadk.core.sharedPref.b.getInstance().remove("key_baidu_sim_card_writting_tip");
                }
            }
        }
    }

    public void AW(int i) {
        this.jly.jlX.setIconFade(i);
    }

    public void qW(boolean z) {
        this.jlA.bA(z);
        if (!z) {
            this.jly.jlX.anJ();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            this.jly.jlX.onChangeSkinType(i);
            al.a(this.jly.jmb, d.i.bottom_bar_bg);
            al.k(this.jly.jlK, d.f.write_tab_background);
            al.c(this.jly.jlM, d.f.icon_post_type_photograph_n);
            al.c(this.jly.jlP, d.f.icon_post_type_text_n);
            al.c(this.jly.jlS, d.f.icon_post_type_image_n);
            al.c(this.jly.jlV, d.f.icon_post_type_live_n);
            al.j(this.jly.jlN, d.C0277d.cp_cont_b);
            al.j(this.jly.jlQ, d.C0277d.cp_cont_b);
            al.j(this.jly.jlT, d.C0277d.cp_cont_b);
            al.j(this.jly.jlW, d.C0277d.cp_cont_b);
        }
    }

    public void onDestroy() {
        if (this.jly.mRootView != null && this.jly.mRootView.getParent() == this.mParentView) {
            this.mParentView.removeView(this.jly.mRootView);
        }
        this.jlA.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void com() {
        String str;
        String str2 = null;
        qW(false);
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            aVar.setAutoNight(false);
            aVar.gB(d.j.prompt);
            aVar.lz(this.mContext.getResources().getString(d.j.disallow_open_live_by_android_v5_0));
            aVar.dx(true);
            aVar.dw(true);
            aVar.a(d.j.know, new a.b() { // from class: com.baidu.tieba.write.e.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.mContext).aaW();
            return;
        }
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
        TiebaStatic.log(new am("c12611").bJ("obj_locate", this.jlC).T("obj_type", 4));
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(TbadkCoreApplication.getInst().getApplicationContext(), str, str3, TbadkCoreApplication.getCurrentAccount(), str2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void con() {
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
        TiebaStatic.log(new am("c12611").bJ("obj_locate", this.jlC).T("obj_type", 3));
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mContext.getPageActivity(), 0, str5, str4, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom(this.writeCallFrom);
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str3);
        writeActivityConfig.setAlbumThread(1);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setProfessionZone(this.jcL != null ? this.jcL.defaultZone : -1);
        writeActivityConfig.setForumDir(str2, str);
        if (!StringUtils.isNull(this.jlB)) {
            writeActivityConfig.setTitle(this.jlB, true);
        }
        if (!a(this.mContext.getPageActivity(), writeActivityConfig)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coo() {
        qW(false);
        TiebaStatic.log(new am("c12611").bJ("obj_locate", this.jlC).T("obj_type", 2));
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
        TiebaStatic.log(new am("c12611").bJ("obj_locate", this.jlC).T("obj_type", 1));
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

    private void cop() {
        if (this.mFrom == "main_tab" && com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") != 0 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_write", 0L)) {
            this.jlE = com.baidu.tbadk.core.bigday.b.WJ().gb(3);
            if (this.jlE != null && this.jlE.WI()) {
                this.jly.jlZ.startLoad(this.jlE.imgUrl, 41, false);
                this.jly.jlZ.setVisibility(0);
                this.jly.jlZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.jlE != null && !StringUtils.isNULL(e.this.jlE.bvL)) {
                            ba.adA().c(e.this.mContext, new String[]{e.this.jlE.bvL});
                            TiebaStatic.log(new am("c13114").k(VideoPlayActivityConfig.OBJ_ID, e.this.jlE.bvN).bJ("obj_to", e.this.jlE.bvL));
                            e.this.qW(false);
                        }
                    }
                });
                this.jly.jlZ.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.write.e.11
                    @Override // com.baidu.tbadk.widget.TbImageView.b
                    public void a(TbImageView tbImageView, Canvas canvas) {
                        if (e.this.jly.jlZ.getBdImage() == null && e.this.jlE != null && !ap.isEmpty(e.this.jlE.imgUrl)) {
                            e.this.jly.jlZ.startLoad(e.this.jlE.imgUrl, 41, false);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.b
                    public void b(TbImageView tbImageView, Canvas canvas) {
                    }
                });
                ViewGroup.LayoutParams layoutParams = this.jly.jlZ.getLayoutParams();
                if (layoutParams instanceof RelativeLayout.LayoutParams) {
                    int aO = (int) (l.aO(this.mContext.getContext()) * 0.546d);
                    layoutParams.width = aO;
                    layoutParams.height = aO;
                    ((RelativeLayout.LayoutParams) layoutParams).topMargin = l.aQ(this.mContext.getContext()) / 5;
                    this.jly.jlZ.setLayoutParams(layoutParams);
                }
                this.jly.jma.setVisibility(0);
                this.jly.jma.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.e.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.jly.jma.clearAnimation();
                        e.this.jly.jlZ.clearAnimation();
                        e.this.jly.jma.setVisibility(8);
                        e.this.jly.jlZ.setVisibility(8);
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(11, 23);
                        calendar.set(12, 59);
                        calendar.set(13, 59);
                        calendar.set(14, 0);
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_bigday_next_showtime_write", calendar.getTimeInMillis());
                    }
                });
                this.jly.jlZ.startAnimation(this.jlD);
                this.jly.jma.startAnimation(this.jlD);
                TiebaStatic.log(new am("c13113").k(VideoPlayActivityConfig.OBJ_ID, this.jlE.bvN).bJ("obj_to", this.jlE.bvL));
            }
        }
    }

    private static boolean a(Activity activity, final WriteActivityConfig writeActivityConfig) {
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.adN();
        aVar.e(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
        aVar.a(new a.InterfaceC0227a() { // from class: com.baidu.tieba.write.e.3
            @Override // com.baidu.tbadk.core.util.b.a.InterfaceC0227a
            public void adO() {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, WriteActivityConfig.this));
            }
        });
        return aVar.Y(activity);
    }

    public void b(FRSRefreshButton fRSRefreshButton) {
        this.eYG = fRSRefreshButton;
    }

    /* loaded from: classes.dex */
    public class a {
        public View jlJ;
        public View jlK;
        public LinearLayout jlL;
        public TbImageView jlM;
        public TextView jlN;
        public LinearLayout jlO;
        public TbImageView jlP;
        public TextView jlQ;
        public LinearLayout jlR;
        public TbImageView jlS;
        public TextView jlT;
        public LinearLayout jlU;
        public TbImageView jlV;
        public TextView jlW;
        public OvalActionButton jlX;
        public GridLayout jlY;
        public TbImageView jlZ;
        public View jma;
        public TBLottieAnimationView jmb;
        public View mRootView;

        public a(Context context) {
            if (context != null) {
                this.mRootView = LayoutInflater.from(e.this.mContext.getPageActivity()).inflate(d.h.bottom_write_thread, (ViewGroup) null);
                this.jlO = (LinearLayout) this.mRootView.findViewById(d.g.home_write_article);
                this.jlP = (TbImageView) this.mRootView.findViewById(d.g.home_write_article_icon);
                this.jlQ = (TextView) this.mRootView.findViewById(d.g.home_write_article_title);
                this.jlL = (LinearLayout) this.mRootView.findViewById(d.g.home_write_photo);
                this.jlM = (TbImageView) this.mRootView.findViewById(d.g.home_write_photo_icon);
                this.jlN = (TextView) this.mRootView.findViewById(d.g.home_write_photo_title);
                this.jlR = (LinearLayout) this.mRootView.findViewById(d.g.home_write_album);
                this.jlS = (TbImageView) this.mRootView.findViewById(d.g.home_write_album_icon);
                this.jlT = (TextView) this.mRootView.findViewById(d.g.home_write_album_title);
                this.jlU = (LinearLayout) this.mRootView.findViewById(d.g.home_write_live);
                this.jlV = (TbImageView) this.mRootView.findViewById(d.g.home_write_live_icon);
                this.jlW = (TextView) this.mRootView.findViewById(d.g.home_write_live_title);
                this.jlX = (OvalActionButton) this.mRootView.findViewById(d.g.write_close_view);
                this.jlK = this.mRootView.findViewById(d.g.view_background_white);
                this.jlJ = this.mRootView.findViewById(d.g.view_background_translate);
                this.jlY = (GridLayout) this.mRootView.findViewById(d.g.type_container);
                this.jlY.setMeasureAllChild(true);
                this.jlY.setVerNum(1);
                this.jlZ = (TbImageView) this.mRootView.findViewById(d.g.write_tab_bigday_img);
                this.jma = this.mRootView.findViewById(d.g.write_tab_bigday_close);
                this.jmb = (TBLottieAnimationView) this.mRootView.findViewById(d.g.bottom_bar_background);
                this.jmb.setSpeed(1.2f);
                cos();
            }
        }

        public void coq() {
            this.jlJ.setOnClickListener(e.this.jlF);
        }

        public void cor() {
            this.jlJ.setOnClickListener(null);
            this.jlJ.setClickable(false);
        }

        private void cos() {
            int aO = l.aO(e.this.mContext.getPageActivity());
            int i = (int) (0.15555556f * aO);
            c(this.jlP, i);
            c(this.jlM, i);
            c(this.jlS, i);
            c(this.jlV, i);
            float h = (aO * 1.0f) / l.h(TbadkCoreApplication.getInst(), d.e.tbds1080);
            ViewGroup.LayoutParams layoutParams = this.jlY.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = (int) (l.h(TbadkCoreApplication.getInst(), d.e.tbds418) * h);
                this.jlY.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.jlK.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                int h2 = (int) (l.h(TbadkCoreApplication.getInst(), d.e.tbds912) * h);
                ((RelativeLayout.LayoutParams) layoutParams2).height = h2 <= 0 ? 912 : h2;
                this.jlK.setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = this.jmb.getLayoutParams();
            if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams3).height = (int) ((h * l.h(TbadkCoreApplication.getInst(), d.e.tbds800)) - ((l.h(TbadkCoreApplication.getInst(), d.e.tbds135) * h) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()));
                this.jmb.setLayoutParams(layoutParams3);
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
