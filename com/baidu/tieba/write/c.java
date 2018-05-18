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
    private ForumWriteData gTm;
    private LinearLayout hbA;
    private TbImageView hbB;
    private TextView hbC;
    private LinearLayout hbD;
    private TbImageView hbE;
    private TextView hbF;
    private ImageView hbG;
    private GridLayout hbH;
    private a hbI;
    private Animation hbP;
    private Animation hbQ;
    private Animation hbR;
    private Animation hbS;
    private View hbs;
    private View hbt;
    private LinearLayout hbu;
    private TbImageView hbv;
    private TextView hbw;
    private LinearLayout hbx;
    private TbImageView hby;
    private TextView hbz;
    private TbPageContext mContext;
    private String mFrom;
    private ViewGroup mRootView;
    private String writeCallFrom;
    private boolean hbJ = false;
    private int hbK = 0;
    private boolean hbL = true;
    private boolean hbM = true;
    private ArrayList<View> hbN = new ArrayList<>();
    private String hbO = "";
    private String hbT = "0";

    static /* synthetic */ int r(c cVar) {
        int i = cVar.hbK;
        cVar.hbK = i + 1;
        return i;
    }

    static /* synthetic */ int t(c cVar) {
        int i = cVar.hbK;
        cVar.hbK = i - 1;
        return i;
    }

    public c(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this.mFrom = AlbumActivityConfig.FROM_WRITE;
        this.mContext = tbPageContext;
        this.mRootView = viewGroup;
        this.mFrom = str;
        initView();
    }

    public void uF(String str) {
        if (str == null) {
            str = "";
        }
        this.hbO = str;
    }

    public void a(ForumWriteData forumWriteData) {
        this.gTm = forumWriteData;
    }

    public void uG(String str) {
        if ("3".equals(str)) {
            this.writeCallFrom = "1";
        } else {
            this.writeCallFrom = str;
        }
        this.hbT = str;
    }

    private void initView() {
        if (this.mContext != null && this.mContext.getPageActivity() != null && this.mRootView != null) {
            this.hbt = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.i.bottom_write_thread, (ViewGroup) null);
            this.hbx = (LinearLayout) this.hbt.findViewById(d.g.home_write_article);
            this.hby = (TbImageView) this.hbt.findViewById(d.g.home_write_article_icon);
            this.hbz = (TextView) this.hbt.findViewById(d.g.home_write_article_title);
            this.hbu = (LinearLayout) this.hbt.findViewById(d.g.home_write_photo);
            this.hbv = (TbImageView) this.hbt.findViewById(d.g.home_write_photo_icon);
            this.hbw = (TextView) this.hbt.findViewById(d.g.home_write_photo_title);
            this.hbA = (LinearLayout) this.hbt.findViewById(d.g.home_write_album);
            this.hbB = (TbImageView) this.hbt.findViewById(d.g.home_write_album_icon);
            this.hbC = (TextView) this.hbt.findViewById(d.g.home_write_album_title);
            this.hbD = (LinearLayout) this.hbt.findViewById(d.g.home_write_live);
            this.hbE = (TbImageView) this.hbt.findViewById(d.g.home_write_live_icon);
            this.hbF = (TextView) this.hbt.findViewById(d.g.home_write_live_title);
            this.hbG = (ImageView) this.hbt.findViewById(d.g.write_close_view);
            this.hbs = this.hbt.findViewById(d.g.view_background);
            this.hbH = (GridLayout) this.hbt.findViewById(d.g.type_container);
            this.hbH.setMeasureAllChild(true);
            this.hbH.setVerNum(1);
            bAX();
            this.hbN.add(this.hbx);
            this.hbN.add(this.hbu);
            this.hbN.add(this.hbA);
            this.hbN.add(this.hbD);
            this.hbt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    c.this.bB(c.this.hbH);
                }
            });
            this.hby.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    c.this.uH(c.this.hbO);
                }
            });
            this.hbv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    c.this.bBa();
                    TiebaStatic.log(new al("c12611").ac("obj_locate", c.this.hbT).r("obj_type", 2));
                    if (c.this.gTm == null) {
                        c.this.gTm = new ForumWriteData("0", null, null, null);
                    }
                    c.this.gTm.mFrom = c.this.mFrom;
                    c.this.gTm.writeCallFrom = c.this.writeCallFrom;
                    e.a(c.this.mContext, "", c.this.gTm);
                }
            });
            this.hbB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    String str;
                    String str2;
                    int i;
                    String str3;
                    int i2;
                    String str4;
                    String str5;
                    c.this.bBa();
                    PostPrefixData postPrefixData = null;
                    AntiData antiData = null;
                    if (c.this.gTm != null) {
                        String str6 = c.this.gTm.forumId;
                        String str7 = c.this.gTm.forumName;
                        postPrefixData = c.this.gTm.prefixData;
                        antiData = c.this.gTm.antiData;
                        int i3 = c.this.gTm.forumLevel;
                        String str8 = c.this.gTm.avatar;
                        int i4 = c.this.gTm.privateThread;
                        String str9 = c.this.gTm.firstDir;
                        str = c.this.gTm.secondDir;
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
                    TiebaStatic.log(new al("c12611").ac("obj_locate", c.this.hbT).r("obj_type", 3));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.mContext.getPageActivity(), 0, str5, str4, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", c.this.mFrom);
                    writeActivityConfig.setCallFrom(c.this.writeCallFrom);
                    writeActivityConfig.setForumLevel(i2);
                    writeActivityConfig.setForumAvatar(str3);
                    writeActivityConfig.setAlbumThread(1);
                    writeActivityConfig.setPrivateThread(i);
                    writeActivityConfig.setForumDir(str2, str);
                    if (!StringUtils.isNull(c.this.hbO)) {
                        writeActivityConfig.setTitle(c.this.hbO, true);
                    }
                    if (!c.H(c.this.mContext.getPageActivity())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                    }
                }
            });
            this.hbE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    String str;
                    String str2 = null;
                    c.this.bBa();
                    MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                    String str3 = "0";
                    com.baidu.adp.lib.d.a.eK().G(false);
                    if (c.this.gTm != null) {
                        str3 = c.this.gTm.forumId;
                        str = c.this.gTm.forumName;
                        str2 = c.this.gTm.specialForumType;
                    } else {
                        str = null;
                    }
                    TiebaStatic.log(new al("c12611").ac("obj_locate", c.this.hbT).r("obj_type", 4));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(TbadkCoreApplication.getInst().getApplicationContext(), str, str3, TbadkCoreApplication.getCurrentAccount(), str2)));
                }
            });
            onChangeSkinType();
            this.hbP = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.write_thread_black_anim);
            this.hbP.setFillAfter(true);
            this.hbQ = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.write_thread_black_hide_anim);
            this.hbQ.setFillAfter(true);
            this.hbR = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.write_tab_bg_anim);
            this.hbR.setFillAfter(true);
            this.hbS = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.home_write_bgout);
            this.hbS.setFillAfter(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean H(Activity activity) {
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.wt();
        aVar.c(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return aVar.v(activity);
    }

    private void bAX() {
        int af = (int) (0.15555556f * l.af(this.mContext.getPageActivity()));
        a(this.hby, af);
        a(this.hbv, af);
        a(this.hbB, af);
        a(this.hbE, af);
        int ah = l.ah(this.mContext.getPageActivity());
        ViewGroup.LayoutParams layoutParams = this.hbH.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = ah / 5;
            this.hbH.setLayoutParams(layoutParams);
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
            c.this.hbx.setVisibility(4);
            c.this.hbu.setVisibility(4);
            c.this.hbA.setVisibility(4);
            c.this.hbD.setVisibility(4);
            c.this.hbG.setVisibility(4);
            c.this.hbs.setVisibility(4);
            if (this.mView != null) {
                this.mView.setVisibility(8);
            }
            if (c.this.hbt.getParent() == c.this.mRootView) {
                c.this.mRootView.removeView(c.this.hbt);
            }
            c.this.hbJ = false;
        }
    }

    public void nl(boolean z) {
        if (!this.hbJ && this.hbL && this.hbM && this.mRootView != null) {
            this.hbG.clearAnimation();
            this.hbJ = true;
            if (this.hbt.getParent() == null) {
                com.baidu.tbadk.j.d.Q(this.mRootView).a(this.mRootView, this.hbt, z);
            }
            this.hbH.setVisibility(0);
            this.hbs.setVisibility(0);
            this.hbs.clearAnimation();
            this.hbs.startAnimation(this.hbR);
            this.hbG.setVisibility(0);
            this.hbG.startAnimation(this.hbP);
            bAY();
            TiebaStatic.log(new al("c12052").ac("obj_locate", this.hbT));
            if (j.gR()) {
                String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_baidu_sim_card_writting_tip", "");
                if (!an.isEmpty(string)) {
                    BdToast.a(this.mContext.getContext(), string).tK();
                    com.baidu.tbadk.core.sharedPref.b.getInstance().remove("key_baidu_sim_card_writting_tip");
                }
            }
        }
    }

    private void bAY() {
        clearAnimation();
        final int size = this.hbN.size();
        this.hbL = false;
        this.hbK = 0;
        for (int i = 0; i < size; i++) {
            final View view2 = this.hbN.get(i);
            com.baidu.adp.lib.g.e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.c.6
                @Override // java.lang.Runnable
                public void run() {
                    view2.setVisibility(0);
                    Animation loadAnimation = AnimationUtils.loadAnimation(c.this.mContext.getPageActivity(), d.a.write_tab_icon_show_anim);
                    loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.c.6.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            c.r(c.this);
                            if (c.this.hbK == size) {
                                c.this.hbL = true;
                                c.this.hbK = 0;
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

    public void bAZ() {
        bB(this.hbH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bB(View view2) {
        if (this.hbL && this.hbM) {
            if (this.hbI != null) {
                com.baidu.adp.lib.g.e.fw().removeCallbacks(this.hbI);
            }
            this.hbs.clearAnimation();
            this.hbs.startAnimation(this.hbS);
            this.hbG.clearAnimation();
            this.hbG.startAnimation(this.hbQ);
            bBb();
            this.hbI = new a(view2);
            com.baidu.adp.lib.g.e.fw().postDelayed(this.hbI, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBa() {
        this.hbL = true;
        this.hbM = true;
        if (this.hbI != null) {
            com.baidu.adp.lib.g.e.fw().removeCallbacks(this.hbI);
        }
        if (this.hbI == null) {
            this.hbI = new a(this.hbH);
        }
        com.baidu.adp.lib.g.e.fw().postDelayed(this.hbI, 500L);
    }

    private void bBb() {
        clearAnimation();
        int size = this.hbN.size();
        this.hbK = size;
        this.hbM = false;
        int i = size - 1;
        for (int i2 = 0; i2 < size; i2++) {
            final View view2 = this.hbN.get(i);
            i--;
            com.baidu.adp.lib.g.e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.c.7
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(c.this.mContext.getPageActivity(), d.a.write_tab_icon_hide_anim);
                    loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.c.7.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            view2.setVisibility(4);
                            if (c.this.hbK == 1) {
                                c.this.hbM = true;
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
        this.hbx.clearAnimation();
        this.hbu.clearAnimation();
        this.hbD.clearAnimation();
        this.hbA.clearAnimation();
    }

    public void onChangeSkinType() {
        ak.j(this.hbs, d.C0126d.cp_bg_line_d_alpha98);
        ak.c(this.hbv, d.f.icon_post_type_photograph_n);
        ak.c(this.hby, d.f.icon_post_type_text_n);
        ak.c(this.hbB, d.f.icon_post_type_image_n);
        ak.c(this.hbE, d.f.icon_post_type_live_n);
        ak.c(this.hbG, d.f.icon_tabbar_add_s);
        ak.h(this.hbw, d.C0126d.cp_cont_b);
        ak.h(this.hbz, d.C0126d.cp_cont_b);
        ak.h(this.hbC, d.C0126d.cp_cont_b);
        ak.h(this.hbF, d.C0126d.cp_cont_b);
    }

    public void onDestroy() {
        if (this.hbt != null && this.hbt.getParent() == this.mRootView) {
            this.mRootView.removeView(this.hbt);
        }
        if (this.hbI != null) {
            com.baidu.adp.lib.g.e.fw().removeCallbacks(this.hbI);
            this.hbI = null;
        }
        this.hbN.clear();
    }

    public boolean isShowing() {
        return this.hbJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uH(String str) {
        String str2;
        String str3;
        int i;
        String str4;
        int i2;
        String str5;
        String str6;
        bBa();
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.gTm == null) {
            str2 = "";
            str3 = "";
            i = 0;
            str4 = null;
            i2 = -1;
            str5 = null;
            str6 = "0";
        } else {
            String str7 = this.gTm.forumId;
            String str8 = this.gTm.forumName;
            postPrefixData = this.gTm.prefixData;
            antiData = this.gTm.antiData;
            int i3 = this.gTm.forumLevel;
            String str9 = this.gTm.avatar;
            int i4 = this.gTm.privateThread;
            String str10 = this.gTm.firstDir;
            str2 = this.gTm.secondDir;
            str3 = str10;
            i = i4;
            str4 = str9;
            i2 = i3;
            str5 = str8;
            str6 = str7;
        }
        TiebaStatic.log(new al("c12611").ac("obj_locate", this.hbT).r("obj_type", 1));
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
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
    }
}
