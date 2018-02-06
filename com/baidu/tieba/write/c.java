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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaMasterLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.GridLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ForumWriteData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c {
    private TbPageContext aRR;
    private View hDE;
    private View hDF;
    private LinearLayout hDG;
    private TbImageView hDH;
    private TextView hDI;
    private LinearLayout hDJ;
    private TbImageView hDK;
    private TextView hDL;
    private LinearLayout hDM;
    private TbImageView hDN;
    private TextView hDO;
    private LinearLayout hDP;
    private TbImageView hDQ;
    private TextView hDR;
    private ImageView hDS;
    private GridLayout hDT;
    private a hDU;
    private Animation hDZ;
    private Animation hEa;
    private Animation hEb;
    private Animation hEc;
    private ForumWriteData hwS;
    private String mFrom;
    private ViewGroup mRootView;
    private String writeCallFrom;
    private boolean hDV = false;
    private int hDW = 0;
    private boolean hDX = true;
    private boolean hDY = true;
    private ArrayList<View> fIR = new ArrayList<>();
    private String hEd = "0";

    static /* synthetic */ int q(c cVar) {
        int i = cVar.hDW;
        cVar.hDW = i + 1;
        return i;
    }

    static /* synthetic */ int s(c cVar) {
        int i = cVar.hDW;
        cVar.hDW = i - 1;
        return i;
    }

    public c(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this.mFrom = AlbumActivityConfig.FROM_WRITE;
        this.aRR = tbPageContext;
        this.mRootView = viewGroup;
        this.mFrom = str;
        initView();
    }

    public void a(ForumWriteData forumWriteData) {
        this.hwS = forumWriteData;
    }

    public void uo(String str) {
        if ("3".equals(str)) {
            this.writeCallFrom = "1";
        } else {
            this.writeCallFrom = str;
        }
        this.hEd = str;
    }

    private void initView() {
        if (this.aRR != null && this.aRR.getPageActivity() != null && this.mRootView != null) {
            this.hDF = LayoutInflater.from(this.aRR.getPageActivity()).inflate(d.h.bottom_write_thread, (ViewGroup) null);
            this.hDJ = (LinearLayout) this.hDF.findViewById(d.g.home_write_article);
            this.hDK = (TbImageView) this.hDF.findViewById(d.g.home_write_article_icon);
            this.hDL = (TextView) this.hDF.findViewById(d.g.home_write_article_title);
            this.hDG = (LinearLayout) this.hDF.findViewById(d.g.home_write_photo);
            this.hDH = (TbImageView) this.hDF.findViewById(d.g.home_write_photo_icon);
            this.hDI = (TextView) this.hDF.findViewById(d.g.home_write_photo_title);
            this.hDM = (LinearLayout) this.hDF.findViewById(d.g.home_write_album);
            this.hDN = (TbImageView) this.hDF.findViewById(d.g.home_write_album_icon);
            this.hDO = (TextView) this.hDF.findViewById(d.g.home_write_album_title);
            this.hDP = (LinearLayout) this.hDF.findViewById(d.g.home_write_live);
            this.hDQ = (TbImageView) this.hDF.findViewById(d.g.home_write_live_icon);
            this.hDR = (TextView) this.hDF.findViewById(d.g.home_write_live_title);
            this.hDS = (ImageView) this.hDF.findViewById(d.g.write_close_view);
            this.hDE = this.hDF.findViewById(d.g.view_background);
            this.hDT = (GridLayout) this.hDF.findViewById(d.g.type_container);
            this.hDT.setMeasureAllChild(true);
            this.hDT.setVerNum(1);
            bFH();
            this.fIR.add(this.hDJ);
            this.fIR.add(this.hDG);
            this.fIR.add(this.hDM);
            this.fIR.add(this.hDP);
            this.hDF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.cV(c.this.hDT);
                }
            });
            this.hDK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i;
                    String str;
                    int i2;
                    c.this.bFK();
                    String str2 = "0";
                    String str3 = null;
                    PostPrefixData postPrefixData = null;
                    AntiData antiData = null;
                    if (c.this.hwS != null) {
                        str2 = c.this.hwS.forumId;
                        str3 = c.this.hwS.forumName;
                        postPrefixData = c.this.hwS.prefixData;
                        antiData = c.this.hwS.antiData;
                        int i3 = c.this.hwS.forumLevel;
                        String str4 = c.this.hwS.avatar;
                        i = c.this.hwS.privateThread;
                        str = str4;
                        i2 = i3;
                    } else {
                        i = 0;
                        str = null;
                        i2 = -1;
                    }
                    TiebaStatic.log(new ak("c12611").ab("obj_locate", c.this.hEd).s("obj_type", 1));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.aRR.getPageActivity(), 9, str2, str3, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", c.this.mFrom);
                    writeActivityConfig.setCallFrom(c.this.writeCallFrom);
                    writeActivityConfig.setForumLevel(i2);
                    writeActivityConfig.setForumAvatar(str);
                    writeActivityConfig.setPrivateThread(i);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                }
            });
            this.hDH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.bFK();
                    TiebaStatic.log(new ak("c12611").ab("obj_locate", c.this.hEd).s("obj_type", 2));
                    if (c.this.hwS == null) {
                        c.this.hwS = new ForumWriteData("0", null, null, null);
                    }
                    c.this.hwS.mFrom = c.this.mFrom;
                    c.this.hwS.writeCallFrom = c.this.writeCallFrom;
                    f.a(c.this.aRR, "", c.this.hwS);
                }
            });
            this.hDN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i;
                    String str;
                    int i2;
                    c.this.bFK();
                    String str2 = "0";
                    String str3 = null;
                    PostPrefixData postPrefixData = null;
                    AntiData antiData = null;
                    if (c.this.hwS != null) {
                        str2 = c.this.hwS.forumId;
                        str3 = c.this.hwS.forumName;
                        postPrefixData = c.this.hwS.prefixData;
                        antiData = c.this.hwS.antiData;
                        int i3 = c.this.hwS.forumLevel;
                        String str4 = c.this.hwS.avatar;
                        i = c.this.hwS.privateThread;
                        str = str4;
                        i2 = i3;
                    } else {
                        i = 0;
                        str = null;
                        i2 = -1;
                    }
                    TiebaStatic.log(new ak("c12611").ab("obj_locate", c.this.hEd).s("obj_type", 3));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.aRR.getPageActivity(), 0, str2, str3, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", c.this.mFrom);
                    writeActivityConfig.setCallFrom(c.this.writeCallFrom);
                    writeActivityConfig.setForumLevel(i2);
                    writeActivityConfig.setForumAvatar(str);
                    writeActivityConfig.setAlbumThread(1);
                    writeActivityConfig.setPrivateThread(i);
                    if (!c.F(c.this.aRR.getPageActivity())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                    }
                }
            });
            this.hDQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    String str2 = null;
                    c.this.bFK();
                    MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                    String str3 = "0";
                    TiebaStatic.log(new ak("c12611").ab("obj_locate", c.this.hEd).s("obj_type", 4));
                    com.baidu.adp.lib.d.a.mG().an(false);
                    if (c.this.hwS != null) {
                        str3 = c.this.hwS.forumId;
                        str = c.this.hwS.forumName;
                        str2 = c.this.hwS.specialForumType;
                    } else {
                        str = null;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(TbadkCoreApplication.getInst().getApplicationContext(), str, str3, TbadkCoreApplication.getCurrentAccount(), str2)));
                }
            });
            onChangeSkinType();
            this.hDZ = AnimationUtils.loadAnimation(this.aRR.getPageActivity(), d.a.write_thread_black_anim);
            this.hDZ.setFillAfter(true);
            this.hEa = AnimationUtils.loadAnimation(this.aRR.getPageActivity(), d.a.write_thread_black_hide_anim);
            this.hEa.setFillAfter(true);
            this.hEb = AnimationUtils.loadAnimation(this.aRR.getPageActivity(), d.a.write_tab_bg_anim);
            this.hEb.setFillAfter(true);
            this.hEc = AnimationUtils.loadAnimation(this.aRR.getPageActivity(), d.a.home_write_bgout);
            this.hEc.setFillAfter(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean F(Activity activity) {
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.DI();
        aVar.c(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return aVar.v(activity);
    }

    private void bFH() {
        int ao = (int) (0.15555556f * l.ao(this.aRR.getPageActivity()));
        a(this.hDK, ao);
        a(this.hDH, ao);
        a(this.hDN, ao);
        a(this.hDQ, ao);
        int aq = l.aq(this.aRR.getPageActivity());
        ViewGroup.LayoutParams layoutParams = this.hDT.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = aq / 5;
            this.hDT.setLayoutParams(layoutParams);
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

        public a(View view) {
            this.mView = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.clearAnimation();
            c.this.hDJ.setVisibility(4);
            c.this.hDG.setVisibility(4);
            c.this.hDM.setVisibility(4);
            c.this.hDP.setVisibility(4);
            c.this.hDS.setVisibility(4);
            c.this.hDE.setVisibility(4);
            if (this.mView != null) {
                this.mView.setVisibility(8);
            }
            if (c.this.hDF.getParent() == c.this.mRootView) {
                c.this.mRootView.removeView(c.this.hDF);
            }
            c.this.hDV = false;
        }
    }

    public void nC(boolean z) {
        if (!this.hDV && this.hDX && this.hDY && this.mRootView != null) {
            this.hDS.clearAnimation();
            this.hDV = true;
            if (this.hDF.getParent() == null) {
                com.baidu.tbadk.j.d.bl(this.mRootView).a(this.mRootView, this.hDF, z);
            }
            this.hDT.setVisibility(0);
            this.hDE.setVisibility(0);
            this.hDE.clearAnimation();
            this.hDE.startAnimation(this.hEb);
            this.hDS.setVisibility(0);
            this.hDS.startAnimation(this.hDZ);
            bFI();
            TiebaStatic.log(new ak("c12052").ab("obj_locate", this.hEd));
        }
    }

    private void bFI() {
        clearAnimation();
        final int size = this.fIR.size();
        this.hDX = false;
        this.hDW = 0;
        for (int i = 0; i < size; i++) {
            final View view = this.fIR.get(i);
            com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.c.6
                @Override // java.lang.Runnable
                public void run() {
                    view.setVisibility(0);
                    Animation loadAnimation = AnimationUtils.loadAnimation(c.this.aRR.getPageActivity(), d.a.write_tab_icon_show_anim);
                    loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.c.6.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            c.q(c.this);
                            if (c.this.hDW == size) {
                                c.this.hDX = true;
                                c.this.hDW = 0;
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }
                    });
                    view.startAnimation(loadAnimation);
                }
            }, i * 50);
        }
    }

    public void bFJ() {
        cV(this.hDT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cV(View view) {
        if (this.hDX && this.hDY) {
            if (this.hDU != null) {
                com.baidu.adp.lib.g.e.ns().removeCallbacks(this.hDU);
            }
            this.hDE.clearAnimation();
            this.hDE.startAnimation(this.hEc);
            this.hDS.clearAnimation();
            this.hDS.startAnimation(this.hEa);
            bFL();
            this.hDU = new a(view);
            com.baidu.adp.lib.g.e.ns().postDelayed(this.hDU, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFK() {
        this.hDX = true;
        this.hDY = true;
        if (this.hDU != null) {
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.hDU);
        }
        if (this.hDU == null) {
            this.hDU = new a(this.hDT);
        }
        com.baidu.adp.lib.g.e.ns().postDelayed(this.hDU, 500L);
    }

    private void bFL() {
        clearAnimation();
        int size = this.fIR.size();
        this.hDW = size;
        this.hDY = false;
        int i = size - 1;
        for (int i2 = 0; i2 < size; i2++) {
            final View view = this.fIR.get(i);
            i--;
            com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.c.7
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(c.this.aRR.getPageActivity(), d.a.write_tab_icon_hide_anim);
                    loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.c.7.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            view.setVisibility(4);
                            if (c.this.hDW == 1) {
                                c.this.hDY = true;
                            } else {
                                c.s(c.this);
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }
                    });
                    view.startAnimation(loadAnimation);
                }
            }, i2 * 50);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAnimation() {
        this.hDJ.clearAnimation();
        this.hDG.clearAnimation();
        this.hDP.clearAnimation();
        this.hDM.clearAnimation();
    }

    public void onChangeSkinType() {
        aj.t(this.hDE, d.C0140d.cp_bg_line_d_alpha98);
        aj.c(this.hDH, d.f.icon_post_type_photograph_n);
        aj.c(this.hDK, d.f.icon_post_type_text_n);
        aj.c(this.hDN, d.f.icon_post_type_image_n);
        aj.c(this.hDQ, d.f.icon_post_type_live_n);
        aj.c(this.hDS, d.f.icon_tabbar_add_s);
        aj.r(this.hDI, d.C0140d.cp_cont_b);
        aj.r(this.hDL, d.C0140d.cp_cont_b);
        aj.r(this.hDO, d.C0140d.cp_cont_b);
        aj.r(this.hDR, d.C0140d.cp_cont_b);
    }

    public void onDestroy() {
        if (this.hDF != null && this.hDF.getParent() == this.mRootView) {
            this.mRootView.removeView(this.hDF);
        }
        if (this.hDU != null) {
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.hDU);
            this.hDU = null;
        }
        this.fIR.clear();
    }

    public boolean isShowing() {
        return this.hDV;
    }
}
