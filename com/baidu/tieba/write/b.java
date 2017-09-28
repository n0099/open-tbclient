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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
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
import com.baidu.tbadk.o.af;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.GridLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ForumWriteData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b {
    private ViewGroup aaQ;
    private TbPageContext abz;
    private String aiq;
    private View gFA;
    private View gFB;
    private LinearLayout gFC;
    private TbImageView gFD;
    private TextView gFE;
    private LinearLayout gFF;
    private TbImageView gFG;
    private TextView gFH;
    private LinearLayout gFI;
    private TbImageView gFJ;
    private TextView gFK;
    private LinearLayout gFL;
    private TbImageView gFM;
    private TextView gFN;
    private LinearLayout gFO;
    private TbImageView gFP;
    private TextView gFQ;
    private ImageView gFR;
    private GridLayout gFS;
    private a gFT;
    private ForumWriteData gFY;
    private String gFZ;
    private boolean gGa;
    private boolean gGb;
    private Animation gGc;
    private Animation gGd;
    private Animation gGe;
    private Animation gGf;
    private boolean gFU = false;
    private int gFV = 0;
    private boolean gFW = true;
    private boolean gFX = true;
    private ArrayList<View> eAe = new ArrayList<>();

    static /* synthetic */ int s(b bVar) {
        int i = bVar.gFV;
        bVar.gFV = i + 1;
        return i;
    }

    static /* synthetic */ int u(b bVar) {
        int i = bVar.gFV;
        bVar.gFV = i - 1;
        return i;
    }

    public b(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this.aiq = AlbumActivityConfig.FROM_WRITE;
        this.abz = tbPageContext;
        this.aaQ = viewGroup;
        this.aiq = str;
        initView();
    }

    public void a(ForumWriteData forumWriteData) {
        this.gFY = forumWriteData;
    }

    public void sX(String str) {
        this.gFZ = str;
    }

    private void initView() {
        if (this.abz != null && this.abz.getPageActivity() != null && this.aaQ != null) {
            this.gFB = LayoutInflater.from(this.abz.getPageActivity()).inflate(d.j.bottom_write_thread, (ViewGroup) null);
            this.gFF = (LinearLayout) this.gFB.findViewById(d.h.home_write_article);
            this.gFG = (TbImageView) this.gFB.findViewById(d.h.home_write_article_icon);
            this.gFH = (TextView) this.gFB.findViewById(d.h.home_write_article_title);
            this.gFC = (LinearLayout) this.gFB.findViewById(d.h.home_write_photo);
            this.gFD = (TbImageView) this.gFB.findViewById(d.h.home_write_photo_icon);
            this.gFE = (TextView) this.gFB.findViewById(d.h.home_write_photo_title);
            this.gFI = (LinearLayout) this.gFB.findViewById(d.h.home_write_video);
            this.gFJ = (TbImageView) this.gFB.findViewById(d.h.home_write_video_icon);
            this.gFK = (TextView) this.gFB.findViewById(d.h.home_write_video_title);
            this.gFL = (LinearLayout) this.gFB.findViewById(d.h.home_write_live);
            this.gFM = (TbImageView) this.gFB.findViewById(d.h.home_write_live_icon);
            this.gFN = (TextView) this.gFB.findViewById(d.h.home_write_live_title);
            this.gFO = (LinearLayout) this.gFB.findViewById(d.h.home_write_url);
            this.gFP = (TbImageView) this.gFB.findViewById(d.h.home_write_url_icon);
            this.gFQ = (TextView) this.gFB.findViewById(d.h.home_write_url_title);
            this.gFR = (ImageView) this.gFB.findViewById(d.h.write_close_view);
            this.gFA = this.gFB.findViewById(d.h.view_background);
            this.gFS = (GridLayout) this.gFB.findViewById(d.h.type_container);
            this.gFS.setMeasureAllChild(true);
            this.gFS.setVerNum(2);
            this.eAe.add(this.gFF);
            this.eAe.add(this.gFC);
            this.gGa = XiaoyingUtil.showXiaoyingTool();
            this.gGa = true;
            a(this.gFS, this.gGa);
            if (!this.gGa) {
                this.gFI.setVisibility(8);
                this.gFL.setPadding(0, l.f(this.abz.getPageActivity(), d.f.ds60), 0, 0);
            } else {
                this.eAe.add(this.gFI);
                this.gFL.setPadding(0, 0, 0, l.f(this.abz.getPageActivity(), d.f.ds120));
            }
            this.eAe.add(this.gFL);
            this.gGb = af.fS();
            if (this.gGb) {
                this.eAe.add(this.gFO);
            } else {
                this.gFO.setVisibility(8);
            }
            b(this.gFS, this.gGb);
            this.gFB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bM(b.this.gFS);
                }
            });
            this.gFM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.byT();
                    MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                    String str = "0";
                    String str2 = null;
                    com.baidu.adp.lib.d.a.fc().D(false);
                    if (b.this.gFY != null) {
                        str = b.this.gFY.forumId;
                        str2 = b.this.gFY.forumName;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, new AlaLiveRoomActivityConfig(TbadkCoreApplication.getInst().getApplicationContext(), str2, str, TbadkCoreApplication.getCurrentAccount(), true, false)));
                }
            });
            this.gFD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    int i;
                    b.this.byT();
                    String str2 = "0";
                    String str3 = null;
                    PostPrefixData postPrefixData = null;
                    AntiData antiData = null;
                    if (b.this.gFY != null) {
                        str2 = b.this.gFY.forumId;
                        str3 = b.this.gFY.forumName;
                        postPrefixData = b.this.gFY.prefixData;
                        antiData = b.this.gFY.antiData;
                        int i2 = b.this.gFY.forumLevel;
                        str = b.this.gFY.avatar;
                        i = i2;
                    } else {
                        str = null;
                        i = -1;
                    }
                    TiebaStatic.log(new ak("c12373").ad("obj_locate", b.this.gFZ).ad("fid", str2));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(b.this.abz.getPageActivity(), 0, str2, str3, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", b.this.aiq);
                    writeActivityConfig.setCallFrom(b.this.gFZ);
                    writeActivityConfig.setForumLevel(i);
                    writeActivityConfig.setForumAvatar(str);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            });
            this.gFG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    int i;
                    b.this.byT();
                    String str2 = "0";
                    String str3 = null;
                    PostPrefixData postPrefixData = null;
                    AntiData antiData = null;
                    if (b.this.gFY != null) {
                        str2 = b.this.gFY.forumId;
                        str3 = b.this.gFY.forumName;
                        postPrefixData = b.this.gFY.prefixData;
                        antiData = b.this.gFY.antiData;
                        int i2 = b.this.gFY.forumLevel;
                        str = b.this.gFY.avatar;
                        i = i2;
                    } else {
                        str = null;
                        i = -1;
                    }
                    TiebaStatic.log(new ak("c12372").ad("obj_locate", b.this.gFZ).ad("fid", str2));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(b.this.abz.getPageActivity(), 9, str2, str3, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", b.this.aiq);
                    writeActivityConfig.setCallFrom(b.this.gFZ);
                    writeActivityConfig.setForumLevel(i);
                    writeActivityConfig.setForumAvatar(str);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            });
            if (this.gGb) {
                this.gFP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        b.this.byT();
                        String str = "0";
                        String str2 = null;
                        if (b.this.gFY != null) {
                            str = b.this.gFY.forumId;
                            str2 = b.this.gFY.forumName;
                        }
                        WriteUrlActivityConfig writeUrlActivityConfig = new WriteUrlActivityConfig(b.this.abz.getPageActivity(), str, str2, b.this.gFZ);
                        writeUrlActivityConfig.getIntent().putExtra("from", b.this.aiq);
                        writeUrlActivityConfig.setRequestCode(13003);
                        writeUrlActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeUrlActivityConfig));
                        TiebaStatic.log(new ak("c12162").ad("obj_locate", b.this.gFZ));
                    }
                });
            }
            if (this.gGa) {
                this.gFJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        b.this.byT();
                        String str = "0";
                        String str2 = null;
                        if (b.this.gFZ.equals("1")) {
                            TiebaStatic.log(new ak("c12292").ad("obj_locate", "2"));
                        } else {
                            TiebaStatic.log(new ak("c12292").ad("obj_locate", "1"));
                        }
                        if (b.this.gFY != null) {
                            str = b.this.gFY.forumId;
                            str2 = b.this.gFY.forumName;
                        }
                        e.b(b.this.abz, str, str2);
                    }
                });
            }
            onChangeSkinType();
            this.gGc = AnimationUtils.loadAnimation(this.abz.getPageActivity(), d.a.write_thread_black_anim);
            this.gGc.setFillAfter(true);
            this.gGd = AnimationUtils.loadAnimation(this.abz.getPageActivity(), d.a.write_thread_black_hide_anim);
            this.gGd.setFillAfter(true);
            this.gGe = AnimationUtils.loadAnimation(this.abz.getPageActivity(), d.a.write_tab_bg_anim);
            this.gGe.setFillAfter(true);
            this.gGf = AnimationUtils.loadAnimation(this.abz.getPageActivity(), d.a.home_write_bgout);
            this.gGf.setFillAfter(true);
        }
    }

    private void a(GridLayout gridLayout, boolean z) {
        if (!z) {
            this.gFI.setVisibility(8);
            if (gridLayout.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) gridLayout.getLayoutParams()).bottomMargin = l.f(this.abz.getPageActivity(), d.f.ds60);
            }
        }
    }

    private void b(GridLayout gridLayout, boolean z) {
        if (!z) {
            this.gFO.setVisibility(8);
            if (gridLayout.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) gridLayout.getLayoutParams()).bottomMargin = l.f(this.abz.getPageActivity(), d.f.ds60);
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
            b.this.gFF.setVisibility(4);
            b.this.gFC.setVisibility(4);
            if (b.this.gGa) {
                b.this.gFI.setVisibility(4);
            } else {
                b.this.gFI.setVisibility(8);
            }
            if (b.this.gGb) {
                b.this.gFO.setVisibility(4);
            } else {
                b.this.gFO.setVisibility(8);
            }
            b.this.gFL.setVisibility(4);
            b.this.gFR.setVisibility(4);
            b.this.gFA.setVisibility(4);
            if (this.mView != null) {
                this.mView.setVisibility(8);
            }
            if (b.this.gFB.getParent() == b.this.aaQ) {
                b.this.aaQ.removeView(b.this.gFB);
            }
            b.this.gFU = false;
        }
    }

    public void nn(boolean z) {
        if (!this.gFU && this.gFW && this.gFX && this.aaQ != null) {
            this.gFR.clearAnimation();
            this.gFU = true;
            if (this.gFB.getParent() == null) {
                com.baidu.tbadk.j.d.Q(this.aaQ).a(this.aaQ, this.gFB, z);
            }
            this.gFS.setVisibility(0);
            this.gFA.setVisibility(0);
            this.gFA.clearAnimation();
            this.gFA.startAnimation(this.gGe);
            this.gFR.setVisibility(0);
            this.gFR.startAnimation(this.gGc);
            byR();
            TiebaStatic.log(new ak("c12052").ad("obj_locate", this.gFZ));
        }
    }

    private void byR() {
        clearAnimation();
        final int size = this.eAe.size();
        this.gFW = false;
        this.gFV = 0;
        for (int i = 0; i < size; i++) {
            final View view = this.eAe.get(i);
            com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.b.7
                @Override // java.lang.Runnable
                public void run() {
                    view.setVisibility(0);
                    Animation loadAnimation = AnimationUtils.loadAnimation(b.this.abz.getPageActivity(), d.a.write_tab_icon_show_anim);
                    loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.b.7.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            b.s(b.this);
                            if (b.this.gFV == size) {
                                b.this.gFW = true;
                                b.this.gFV = 0;
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

    public void byS() {
        bM(this.gFS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bM(View view) {
        if (this.gFW && this.gFX) {
            if (this.gFT != null) {
                com.baidu.adp.lib.g.e.fP().removeCallbacks(this.gFT);
            }
            this.gFA.clearAnimation();
            this.gFA.startAnimation(this.gGf);
            this.gFR.clearAnimation();
            this.gFR.startAnimation(this.gGd);
            byU();
            this.gFT = new a(view);
            com.baidu.adp.lib.g.e.fP().postDelayed(this.gFT, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byT() {
        this.gFW = true;
        this.gFX = true;
        if (this.gFT != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.gFT);
        }
        if (this.gFT == null) {
            this.gFT = new a(this.gFS);
        }
        com.baidu.adp.lib.g.e.fP().postDelayed(this.gFT, 500L);
    }

    private void byU() {
        clearAnimation();
        int size = this.eAe.size();
        this.gFV = size;
        this.gFX = false;
        int i = size - 1;
        for (int i2 = 0; i2 < size; i2++) {
            final View view = this.eAe.get(i);
            i--;
            com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.b.8
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(b.this.abz.getPageActivity(), d.a.write_tab_icon_hide_anim);
                    loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.b.8.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            view.setVisibility(4);
                            if (b.this.gFV == 1) {
                                b.this.gFX = true;
                            } else {
                                b.u(b.this);
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
        this.gFF.clearAnimation();
        this.gFC.clearAnimation();
        this.gFI.clearAnimation();
        this.gFL.clearAnimation();
        this.gFO.clearAnimation();
    }

    public void onChangeSkinType() {
        aj.k(this.gFA, d.e.cp_bg_line_d_alpha98);
        aj.c(this.gFD, d.g.icon_posts_photo_n);
        aj.c(this.gFG, d.g.icon_posts_article_n);
        aj.c(this.gFJ, d.g.icon_posts_video_n);
        aj.c(this.gFM, d.g.icon_posts_live_n);
        aj.c(this.gFR, d.g.icon_tabbar_add_s);
        aj.c(this.gFP, d.g.icon_posts_url_n);
        aj.i(this.gFE, d.e.cp_cont_f);
        aj.i(this.gFH, d.e.cp_cont_f);
        aj.i(this.gFK, d.e.cp_cont_f);
        aj.i(this.gFN, d.e.cp_cont_f);
        aj.i(this.gFQ, d.e.cp_cont_f);
    }

    public void onDestroy() {
        if (this.gFB != null && this.gFB.getParent() == this.aaQ) {
            this.aaQ.removeView(this.gFB);
        }
        if (this.gFT != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.gFT);
            this.gFT = null;
        }
        this.eAe.clear();
    }

    public boolean isShowing() {
        return this.gFU;
    }
}
