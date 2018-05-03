package com.baidu.tieba.write;

import android.app.Activity;
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
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaMasterLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.GridLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ForumWriteData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c {
    private TbPageContext adf;
    private ForumWriteData gSi;
    private TbImageView haA;
    private TextView haB;
    private ImageView haC;
    private GridLayout haD;
    private a haE;
    private Animation haL;
    private Animation haM;
    private Animation haN;
    private Animation haO;
    private View hao;
    private View hap;
    private LinearLayout haq;
    private TbImageView har;
    private TextView has;
    private LinearLayout hat;
    private TbImageView hau;
    private TextView hav;
    private LinearLayout haw;
    private TbImageView hax;
    private TextView hay;
    private LinearLayout haz;
    private String mFrom;
    private ViewGroup mRootView;
    private String writeCallFrom;
    private boolean haF = false;
    private int haG = 0;
    private boolean haH = true;
    private boolean haI = true;
    private ArrayList<View> haJ = new ArrayList<>();
    private String haK = "";
    private String haP = "0";

    static /* synthetic */ int r(c cVar) {
        int i = cVar.haG;
        cVar.haG = i + 1;
        return i;
    }

    static /* synthetic */ int t(c cVar) {
        int i = cVar.haG;
        cVar.haG = i - 1;
        return i;
    }

    public c(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this.mFrom = AlbumActivityConfig.FROM_WRITE;
        this.adf = tbPageContext;
        this.mRootView = viewGroup;
        this.mFrom = str;
        initView();
    }

    public void uC(String str) {
        if (str == null) {
            str = "";
        }
        this.haK = str;
    }

    public void a(ForumWriteData forumWriteData) {
        this.gSi = forumWriteData;
    }

    public void uD(String str) {
        if ("3".equals(str)) {
            this.writeCallFrom = "1";
        } else {
            this.writeCallFrom = str;
        }
        this.haP = str;
    }

    private void initView() {
        if (this.adf != null && this.adf.getPageActivity() != null && this.mRootView != null) {
            this.hap = LayoutInflater.from(this.adf.getPageActivity()).inflate(d.i.bottom_write_thread, (ViewGroup) null);
            this.hat = (LinearLayout) this.hap.findViewById(d.g.home_write_article);
            this.hau = (TbImageView) this.hap.findViewById(d.g.home_write_article_icon);
            this.hav = (TextView) this.hap.findViewById(d.g.home_write_article_title);
            this.haq = (LinearLayout) this.hap.findViewById(d.g.home_write_photo);
            this.har = (TbImageView) this.hap.findViewById(d.g.home_write_photo_icon);
            this.has = (TextView) this.hap.findViewById(d.g.home_write_photo_title);
            this.haw = (LinearLayout) this.hap.findViewById(d.g.home_write_album);
            this.hax = (TbImageView) this.hap.findViewById(d.g.home_write_album_icon);
            this.hay = (TextView) this.hap.findViewById(d.g.home_write_album_title);
            this.haz = (LinearLayout) this.hap.findViewById(d.g.home_write_live);
            this.haA = (TbImageView) this.hap.findViewById(d.g.home_write_live_icon);
            this.haB = (TextView) this.hap.findViewById(d.g.home_write_live_title);
            this.haC = (ImageView) this.hap.findViewById(d.g.write_close_view);
            this.hao = this.hap.findViewById(d.g.view_background);
            this.haD = (GridLayout) this.hap.findViewById(d.g.type_container);
            this.haD.setMeasureAllChild(true);
            this.haD.setVerNum(1);
            bAZ();
            this.haJ.add(this.hat);
            this.haJ.add(this.haq);
            this.haJ.add(this.haw);
            this.haJ.add(this.haz);
            this.hap.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    c.this.bB(c.this.haD);
                }
            });
            this.hau.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    c.this.uE(c.this.haK);
                }
            });
            this.har.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    c.this.bBc();
                    TiebaStatic.log(new al("c12611").ac("obj_locate", c.this.haP).r("obj_type", 2));
                    if (c.this.gSi == null) {
                        c.this.gSi = new ForumWriteData("0", null, null, null);
                    }
                    c.this.gSi.mFrom = c.this.mFrom;
                    c.this.gSi.writeCallFrom = c.this.writeCallFrom;
                    e.a(c.this.adf, "", c.this.gSi);
                }
            });
            this.hax.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    String str;
                    String str2;
                    int i;
                    String str3;
                    int i2;
                    String str4;
                    String str5;
                    c.this.bBc();
                    PostPrefixData postPrefixData = null;
                    AntiData antiData = null;
                    if (c.this.gSi != null) {
                        String str6 = c.this.gSi.forumId;
                        String str7 = c.this.gSi.forumName;
                        postPrefixData = c.this.gSi.prefixData;
                        antiData = c.this.gSi.antiData;
                        int i3 = c.this.gSi.forumLevel;
                        String str8 = c.this.gSi.avatar;
                        int i4 = c.this.gSi.privateThread;
                        String str9 = c.this.gSi.firstDir;
                        str = c.this.gSi.secondDir;
                        str2 = str9;
                        i = i4;
                        str3 = str8;
                        i2 = i3;
                        str4 = str7;
                        str5 = str6;
                    } else {
                        str = "";
                        str2 = "";
                        i = 0;
                        str3 = null;
                        i2 = -1;
                        str4 = null;
                        str5 = "0";
                    }
                    TiebaStatic.log(new al("c12611").ac("obj_locate", c.this.haP).r("obj_type", 3));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.adf.getPageActivity(), 0, str5, str4, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", c.this.mFrom);
                    writeActivityConfig.setCallFrom(c.this.writeCallFrom);
                    writeActivityConfig.setForumLevel(i2);
                    writeActivityConfig.setForumAvatar(str3);
                    writeActivityConfig.setAlbumThread(1);
                    writeActivityConfig.setPrivateThread(i);
                    writeActivityConfig.setForumDir(str2, str);
                    if (!StringUtils.isNull(c.this.haK)) {
                        writeActivityConfig.setTitle(c.this.haK, true);
                    }
                    if (!c.H(c.this.adf.getPageActivity())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                    }
                }
            });
            this.haA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    String str;
                    String str2 = null;
                    c.this.bBc();
                    MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                    String str3 = "0";
                    com.baidu.adp.lib.d.a.eK().G(false);
                    if (c.this.gSi != null) {
                        str3 = c.this.gSi.forumId;
                        str = c.this.gSi.forumName;
                        str2 = c.this.gSi.specialForumType;
                    } else {
                        str = null;
                    }
                    TiebaStatic.log(new al("c12611").ac("obj_locate", c.this.haP).r("obj_type", 4));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(TbadkCoreApplication.getInst().getApplicationContext(), str, str3, TbadkCoreApplication.getCurrentAccount(), str2)));
                }
            });
            onChangeSkinType();
            this.haL = AnimationUtils.loadAnimation(this.adf.getPageActivity(), d.a.write_thread_black_anim);
            this.haL.setFillAfter(true);
            this.haM = AnimationUtils.loadAnimation(this.adf.getPageActivity(), d.a.write_thread_black_hide_anim);
            this.haM.setFillAfter(true);
            this.haN = AnimationUtils.loadAnimation(this.adf.getPageActivity(), d.a.write_tab_bg_anim);
            this.haN.setFillAfter(true);
            this.haO = AnimationUtils.loadAnimation(this.adf.getPageActivity(), d.a.home_write_bgout);
            this.haO.setFillAfter(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean H(Activity activity) {
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.wu();
        aVar.c(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return aVar.v(activity);
    }

    private void bAZ() {
        int af = (int) (0.15555556f * l.af(this.adf.getPageActivity()));
        a(this.hau, af);
        a(this.har, af);
        a(this.hax, af);
        a(this.haA, af);
        int ah = l.ah(this.adf.getPageActivity());
        ViewGroup.LayoutParams layoutParams = this.haD.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = ah / 5;
            this.haD.setLayoutParams(layoutParams);
        }
    }

    private void a(TbImageView tbImageView, int i) {
        if (tbImageView != null && i > 0) {
            ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i;
            tbImageView.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private View mView;

        public a(View view2) {
            this.mView = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.clearAnimation();
            c.this.hat.setVisibility(4);
            c.this.haq.setVisibility(4);
            c.this.haw.setVisibility(4);
            c.this.haz.setVisibility(4);
            c.this.haC.setVisibility(4);
            c.this.hao.setVisibility(4);
            if (this.mView != null) {
                this.mView.setVisibility(8);
            }
            if (c.this.hap.getParent() == c.this.mRootView) {
                c.this.mRootView.removeView(c.this.hap);
            }
            c.this.haF = false;
        }
    }

    public void nk(boolean z) {
        if (!this.haF && this.haH && this.haI && this.mRootView != null) {
            this.haC.clearAnimation();
            this.haF = true;
            if (this.hap.getParent() == null) {
                com.baidu.tbadk.j.d.Q(this.mRootView).a(this.mRootView, this.hap, z);
            }
            this.haD.setVisibility(0);
            this.hao.setVisibility(0);
            this.hao.clearAnimation();
            this.hao.startAnimation(this.haN);
            this.haC.setVisibility(0);
            this.haC.startAnimation(this.haL);
            bBa();
            TiebaStatic.log(new al("c12052").ac("obj_locate", this.haP));
            if (j.gR()) {
                String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_baidu_sim_card_writting_tip", "");
                if (!an.isEmpty(string)) {
                    BdToast.a(this.adf.getContext(), string).tL();
                    com.baidu.tbadk.core.sharedPref.b.getInstance().remove("key_baidu_sim_card_writting_tip");
                }
            }
        }
    }

    private void bBa() {
        clearAnimation();
        final int size = this.haJ.size();
        this.haH = false;
        this.haG = 0;
        for (int i = 0; i < size; i++) {
            final View view2 = this.haJ.get(i);
            com.baidu.adp.lib.g.e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.c.6
                @Override // java.lang.Runnable
                public void run() {
                    view2.setVisibility(0);
                    Animation loadAnimation = AnimationUtils.loadAnimation(c.this.adf.getPageActivity(), d.a.write_tab_icon_show_anim);
                    loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.c.6.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            c.r(c.this);
                            if (c.this.haG == size) {
                                c.this.haH = true;
                                c.this.haG = 0;
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }
                    });
                    view2.startAnimation(loadAnimation);
                }
            }, i * 50);
        }
    }

    public void bBb() {
        bB(this.haD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bB(View view2) {
        if (this.haH && this.haI) {
            if (this.haE != null) {
                com.baidu.adp.lib.g.e.fw().removeCallbacks(this.haE);
            }
            this.hao.clearAnimation();
            this.hao.startAnimation(this.haO);
            this.haC.clearAnimation();
            this.haC.startAnimation(this.haM);
            bBd();
            this.haE = new a(view2);
            com.baidu.adp.lib.g.e.fw().postDelayed(this.haE, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBc() {
        this.haH = true;
        this.haI = true;
        if (this.haE != null) {
            com.baidu.adp.lib.g.e.fw().removeCallbacks(this.haE);
        }
        if (this.haE == null) {
            this.haE = new a(this.haD);
        }
        com.baidu.adp.lib.g.e.fw().postDelayed(this.haE, 500L);
    }

    private void bBd() {
        clearAnimation();
        int size = this.haJ.size();
        this.haG = size;
        this.haI = false;
        int i = size - 1;
        for (int i2 = 0; i2 < size; i2++) {
            final View view2 = this.haJ.get(i);
            i--;
            com.baidu.adp.lib.g.e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.c.7
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(c.this.adf.getPageActivity(), d.a.write_tab_icon_hide_anim);
                    loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.c.7.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            view2.setVisibility(4);
                            if (c.this.haG == 1) {
                                c.this.haI = true;
                            } else {
                                c.t(c.this);
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }
                    });
                    view2.startAnimation(loadAnimation);
                }
            }, i2 * 50);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAnimation() {
        this.hat.clearAnimation();
        this.haq.clearAnimation();
        this.haz.clearAnimation();
        this.haw.clearAnimation();
    }

    public void onChangeSkinType() {
        ak.j(this.hao, d.C0126d.cp_bg_line_d_alpha98);
        ak.c(this.har, d.f.icon_post_type_photograph_n);
        ak.c(this.hau, d.f.icon_post_type_text_n);
        ak.c(this.hax, d.f.icon_post_type_image_n);
        ak.c(this.haA, d.f.icon_post_type_live_n);
        ak.c(this.haC, d.f.icon_tabbar_add_s);
        ak.h(this.has, d.C0126d.cp_cont_b);
        ak.h(this.hav, d.C0126d.cp_cont_b);
        ak.h(this.hay, d.C0126d.cp_cont_b);
        ak.h(this.haB, d.C0126d.cp_cont_b);
    }

    public void onDestroy() {
        if (this.hap != null && this.hap.getParent() == this.mRootView) {
            this.mRootView.removeView(this.hap);
        }
        if (this.haE != null) {
            com.baidu.adp.lib.g.e.fw().removeCallbacks(this.haE);
            this.haE = null;
        }
        this.haJ.clear();
    }

    public boolean isShowing() {
        return this.haF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uE(String str) {
        String str2;
        String str3;
        int i;
        String str4;
        int i2;
        String str5;
        String str6;
        bBc();
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.gSi == null) {
            str2 = "";
            str3 = "";
            i = 0;
            str4 = null;
            i2 = -1;
            str5 = null;
            str6 = "0";
        } else {
            String str7 = this.gSi.forumId;
            String str8 = this.gSi.forumName;
            postPrefixData = this.gSi.prefixData;
            antiData = this.gSi.antiData;
            int i3 = this.gSi.forumLevel;
            String str9 = this.gSi.avatar;
            int i4 = this.gSi.privateThread;
            String str10 = this.gSi.firstDir;
            str2 = this.gSi.secondDir;
            str3 = str10;
            i = i4;
            str4 = str9;
            i2 = i3;
            str5 = str8;
            str6 = str7;
        }
        TiebaStatic.log(new al("c12611").ac("obj_locate", this.haP).r("obj_type", 1));
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.adf.getPageActivity(), 9, str6, str5, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom(this.writeCallFrom);
        if (!StringUtils.isNull(str)) {
            writeActivityConfig.setTitle(str, true);
        }
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str4);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setForumDir(str3, str2);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
    }
}
