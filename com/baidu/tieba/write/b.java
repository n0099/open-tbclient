package com.baidu.tieba.write;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteUrlActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.p.ae;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.GridLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ForumWriteData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b {
    private ViewGroup aaQ;
    private TbPageContext aby;
    private Animation gAa;
    private Animation gAb;
    private Animation gAc;
    private Animation gAd;
    private LinearLayout gzA;
    private TbImageView gzB;
    private TextView gzC;
    private LinearLayout gzD;
    private TbImageView gzE;
    private TextView gzF;
    private LinearLayout gzG;
    private TbImageView gzH;
    private TextView gzI;
    private LinearLayout gzJ;
    private TbImageView gzK;
    private TextView gzL;
    private LinearLayout gzM;
    private TbImageView gzN;
    private TextView gzO;
    private ImageView gzP;
    private GridLayout gzQ;
    private a gzR;
    private ForumWriteData gzW;
    private String gzX;
    private boolean gzY;
    private boolean gzZ;
    private View gzy;
    private View gzz;
    private boolean gzS = false;
    private int gzT = 0;
    private boolean gzU = true;
    private boolean gzV = true;
    private ArrayList<View> eFN = new ArrayList<>();

    static /* synthetic */ int r(b bVar) {
        int i = bVar.gzT;
        bVar.gzT = i + 1;
        return i;
    }

    static /* synthetic */ int t(b bVar) {
        int i = bVar.gzT;
        bVar.gzT = i - 1;
        return i;
    }

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.aby = tbPageContext;
        this.aaQ = viewGroup;
        initView();
    }

    public void a(ForumWriteData forumWriteData) {
        this.gzW = forumWriteData;
    }

    public void sR(String str) {
        this.gzX = str;
    }

    private void initView() {
        if (this.aby != null && this.aby.getPageActivity() != null && this.aaQ != null) {
            this.gzz = LayoutInflater.from(this.aby.getPageActivity()).inflate(d.j.bottom_write_thread, (ViewGroup) null);
            this.gzD = (LinearLayout) this.gzz.findViewById(d.h.home_write_article);
            this.gzE = (TbImageView) this.gzz.findViewById(d.h.home_write_article_icon);
            this.gzF = (TextView) this.gzz.findViewById(d.h.home_write_article_title);
            this.gzA = (LinearLayout) this.gzz.findViewById(d.h.home_write_photo);
            this.gzB = (TbImageView) this.gzz.findViewById(d.h.home_write_photo_icon);
            this.gzC = (TextView) this.gzz.findViewById(d.h.home_write_photo_title);
            this.gzG = (LinearLayout) this.gzz.findViewById(d.h.home_write_video);
            this.gzH = (TbImageView) this.gzz.findViewById(d.h.home_write_video_icon);
            this.gzI = (TextView) this.gzz.findViewById(d.h.home_write_video_title);
            this.gzJ = (LinearLayout) this.gzz.findViewById(d.h.home_write_live);
            this.gzK = (TbImageView) this.gzz.findViewById(d.h.home_write_live_icon);
            this.gzL = (TextView) this.gzz.findViewById(d.h.home_write_live_title);
            this.gzM = (LinearLayout) this.gzz.findViewById(d.h.home_write_url);
            this.gzN = (TbImageView) this.gzz.findViewById(d.h.home_write_url_icon);
            this.gzO = (TextView) this.gzz.findViewById(d.h.home_write_url_title);
            this.gzP = (ImageView) this.gzz.findViewById(d.h.write_close_view);
            this.gzy = this.gzz.findViewById(d.h.view_background);
            this.gzQ = (GridLayout) this.gzz.findViewById(d.h.type_container);
            this.gzQ.setMeasureAllChild(true);
            this.gzQ.setVerNum(2);
            this.eFN.add(this.gzD);
            this.eFN.add(this.gzA);
            this.gzY = XiaoyingUtil.showXiaoyingTool();
            a(this.gzQ, this.gzY);
            if (!this.gzY) {
                this.gzG.setVisibility(8);
                this.gzJ.setPadding(0, k.g(this.aby.getPageActivity(), d.f.ds60), 0, 0);
            } else {
                this.eFN.add(this.gzG);
                this.gzJ.setPadding(0, 0, 0, k.g(this.aby.getPageActivity(), d.f.ds120));
            }
            this.eFN.add(this.gzJ);
            this.gzZ = ae.fT();
            if (this.gzZ) {
                this.eFN.add(this.gzM);
            } else {
                this.gzM.setVisibility(8);
            }
            b(this.gzQ, this.gzZ);
            this.gzz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bK(b.this.gzQ);
                }
            });
            this.gzK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bxt();
                    MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                    String str = "0";
                    String str2 = null;
                    com.baidu.adp.lib.d.a.fd().D(false);
                    if (b.this.gzW != null) {
                        str = b.this.gzW.forumId;
                        str2 = b.this.gzW.forumName;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, new AlaLiveRoomActivityConfig(TbadkCoreApplication.getInst().getApplicationContext(), str2, str, TbadkCoreApplication.getCurrentAccount(), true, false)));
                }
            });
            this.gzB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    int i;
                    b.this.bxt();
                    String str2 = "0";
                    String str3 = null;
                    PostPrefixData postPrefixData = null;
                    AntiData antiData = null;
                    if (b.this.gzW != null) {
                        str2 = b.this.gzW.forumId;
                        str3 = b.this.gzW.forumName;
                        postPrefixData = b.this.gzW.prefixData;
                        antiData = b.this.gzW.antiData;
                        int i2 = b.this.gzW.forumLevel;
                        str = b.this.gzW.avatar;
                        i = i2;
                    } else {
                        str = null;
                        i = -1;
                    }
                    TiebaStatic.log(new ak("c12373").ad("obj_locate", b.this.gzX).ad("fid", str2));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(b.this.aby.getPageActivity(), 0, str2, str3, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.setCallFrom(b.this.gzX);
                    writeActivityConfig.setForumLevel(i);
                    writeActivityConfig.setForumAvatar(str);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            });
            this.gzE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    int i;
                    b.this.bxt();
                    String str2 = "0";
                    String str3 = null;
                    PostPrefixData postPrefixData = null;
                    AntiData antiData = null;
                    if (b.this.gzW != null) {
                        str2 = b.this.gzW.forumId;
                        str3 = b.this.gzW.forumName;
                        postPrefixData = b.this.gzW.prefixData;
                        antiData = b.this.gzW.antiData;
                        int i2 = b.this.gzW.forumLevel;
                        str = b.this.gzW.avatar;
                        i = i2;
                    } else {
                        str = null;
                        i = -1;
                    }
                    TiebaStatic.log(new ak("c12372").ad("obj_locate", b.this.gzX).ad("fid", str2));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(b.this.aby.getPageActivity(), 9, str2, str3, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.setCallFrom(b.this.gzX);
                    writeActivityConfig.setForumLevel(i);
                    writeActivityConfig.setForumAvatar(str);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            });
            if (this.gzZ) {
                this.gzN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        b.this.bxt();
                        String str = "0";
                        String str2 = null;
                        if (b.this.gzW != null) {
                            str = b.this.gzW.forumId;
                            str2 = b.this.gzW.forumName;
                        }
                        WriteUrlActivityConfig writeUrlActivityConfig = new WriteUrlActivityConfig(b.this.aby.getPageActivity(), str, str2, b.this.gzX);
                        writeUrlActivityConfig.setRequestCode(13003);
                        writeUrlActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeUrlActivityConfig));
                        TiebaStatic.log(new ak("c12162").ad("obj_locate", b.this.gzX));
                    }
                });
            }
            if (this.gzY) {
                this.gzH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        b.this.bxt();
                        String str = "0";
                        String str2 = null;
                        if (b.this.gzW != null) {
                            str = b.this.gzW.forumId;
                            str2 = b.this.gzW.forumName;
                        }
                        e.c(b.this.aby, str, str2);
                    }
                });
            }
            onChangeSkinType();
            this.gAa = AnimationUtils.loadAnimation(this.aby.getPageActivity(), d.a.write_thread_black_anim);
            this.gAa.setFillAfter(true);
            this.gAb = AnimationUtils.loadAnimation(this.aby.getPageActivity(), d.a.write_thread_black_hide_anim);
            this.gAb.setFillAfter(true);
            this.gAc = AnimationUtils.loadAnimation(this.aby.getPageActivity(), d.a.write_tab_bg_anim);
            this.gAc.setFillAfter(true);
            this.gAd = AnimationUtils.loadAnimation(this.aby.getPageActivity(), d.a.home_write_bgout);
            this.gAd.setFillAfter(true);
        }
    }

    private void a(GridLayout gridLayout, boolean z) {
        if (!z) {
            this.gzG.setVisibility(8);
            if (gridLayout.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) gridLayout.getLayoutParams()).bottomMargin = k.g(this.aby.getPageActivity(), d.f.ds60);
            }
        }
    }

    private void b(GridLayout gridLayout, boolean z) {
        if (!z) {
            this.gzM.setVisibility(8);
            if (gridLayout.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) gridLayout.getLayoutParams()).bottomMargin = k.g(this.aby.getPageActivity(), d.f.ds60);
            }
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
            b.this.clearAnimation();
            b.this.gzD.setVisibility(4);
            b.this.gzA.setVisibility(4);
            if (b.this.gzY) {
                b.this.gzG.setVisibility(4);
            } else {
                b.this.gzG.setVisibility(8);
            }
            if (b.this.gzZ) {
                b.this.gzM.setVisibility(4);
            } else {
                b.this.gzM.setVisibility(8);
            }
            b.this.gzJ.setVisibility(4);
            b.this.gzP.setVisibility(4);
            b.this.gzy.setVisibility(4);
            if (this.mView != null) {
                this.mView.setVisibility(8);
            }
            if (b.this.gzz.getParent() == b.this.aaQ) {
                b.this.aaQ.removeView(b.this.gzz);
            }
            b.this.gzS = false;
        }
    }

    public void nh(boolean z) {
        if (!this.gzS && this.gzU && this.gzV && this.aaQ != null) {
            this.gzP.clearAnimation();
            this.gzS = true;
            if (this.gzz.getParent() == null) {
                com.baidu.tbadk.k.d.P(this.aaQ).a(this.aaQ, this.gzz, z);
            }
            this.gzQ.setVisibility(0);
            this.gzy.setVisibility(0);
            this.gzy.clearAnimation();
            this.gzy.startAnimation(this.gAc);
            this.gzP.setVisibility(0);
            this.gzP.startAnimation(this.gAa);
            bxr();
            TiebaStatic.log(new ak("c12052").ad("obj_locate", this.gzX));
        }
    }

    private void bxr() {
        clearAnimation();
        final int size = this.eFN.size();
        this.gzU = false;
        this.gzT = 0;
        for (int i = 0; i < size; i++) {
            final View view = this.eFN.get(i);
            com.baidu.adp.lib.g.e.fQ().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.b.7
                @Override // java.lang.Runnable
                public void run() {
                    view.setVisibility(0);
                    Animation loadAnimation = AnimationUtils.loadAnimation(b.this.aby.getPageActivity(), d.a.write_tab_icon_show_anim);
                    loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.b.7.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            b.r(b.this);
                            if (b.this.gzT == size) {
                                b.this.gzU = true;
                                b.this.gzT = 0;
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

    public void bxs() {
        bK(this.gzQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bK(View view) {
        if (this.gzU && this.gzV) {
            if (this.gzR != null) {
                com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.gzR);
            }
            this.gzy.clearAnimation();
            this.gzy.startAnimation(this.gAd);
            this.gzP.clearAnimation();
            this.gzP.startAnimation(this.gAb);
            bxu();
            this.gzR = new a(view);
            com.baidu.adp.lib.g.e.fQ().postDelayed(this.gzR, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxt() {
        this.gzU = true;
        this.gzV = true;
        if (this.gzR != null) {
            com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.gzR);
        }
        if (this.gzR == null) {
            this.gzR = new a(this.gzQ);
        }
        com.baidu.adp.lib.g.e.fQ().postDelayed(this.gzR, 500L);
    }

    private void bxu() {
        clearAnimation();
        int size = this.eFN.size();
        this.gzT = size;
        this.gzV = false;
        int i = size - 1;
        for (int i2 = 0; i2 < size; i2++) {
            final View view = this.eFN.get(i);
            i--;
            com.baidu.adp.lib.g.e.fQ().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.b.8
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(b.this.aby.getPageActivity(), d.a.write_tab_icon_hide_anim);
                    loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.b.8.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            view.setVisibility(4);
                            if (b.this.gzT == 1) {
                                b.this.gzV = true;
                            } else {
                                b.t(b.this);
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
        this.gzD.clearAnimation();
        this.gzA.clearAnimation();
        this.gzG.clearAnimation();
        this.gzJ.clearAnimation();
        this.gzM.clearAnimation();
    }

    public void onChangeSkinType() {
        aj.k(this.gzy, d.e.cp_bg_line_d_alpha98);
        aj.c(this.gzB, d.g.icon_posts_photo_n);
        aj.c(this.gzE, d.g.icon_posts_article_n);
        aj.c(this.gzH, d.g.icon_posts_video_n);
        aj.c(this.gzK, d.g.icon_posts_live_n);
        aj.c(this.gzP, d.g.icon_tabbar_add_s);
        aj.c(this.gzN, d.g.icon_posts_url_n);
        aj.i(this.gzC, d.e.cp_cont_f);
        aj.i(this.gzF, d.e.cp_cont_f);
        aj.i(this.gzI, d.e.cp_cont_f);
        aj.i(this.gzL, d.e.cp_cont_f);
        aj.i(this.gzO, d.e.cp_cont_f);
    }

    public void onDestroy() {
        if (this.gzz != null && this.gzz.getParent() == this.aaQ) {
            this.aaQ.removeView(this.gzz);
        }
        if (this.gzR != null) {
            com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.gzR);
            this.gzR = null;
        }
        this.eFN.clear();
    }

    public boolean isShowing() {
        return this.gzS;
    }
}
