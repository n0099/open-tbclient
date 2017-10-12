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
    private LinearLayout gFB;
    private TbImageView gFC;
    private TextView gFD;
    private LinearLayout gFE;
    private TbImageView gFF;
    private TextView gFG;
    private LinearLayout gFH;
    private TbImageView gFI;
    private TextView gFJ;
    private LinearLayout gFK;
    private TbImageView gFL;
    private TextView gFM;
    private LinearLayout gFN;
    private TbImageView gFO;
    private TextView gFP;
    private ImageView gFQ;
    private GridLayout gFR;
    private a gFS;
    private ForumWriteData gFX;
    private String gFY;
    private boolean gFZ;
    private View gFz;
    private boolean gGa;
    private Animation gGb;
    private Animation gGc;
    private Animation gGd;
    private Animation gGe;
    private boolean gFT = false;
    private int gFU = 0;
    private boolean gFV = true;
    private boolean gFW = true;
    private ArrayList<View> eAe = new ArrayList<>();

    static /* synthetic */ int s(b bVar) {
        int i = bVar.gFU;
        bVar.gFU = i + 1;
        return i;
    }

    static /* synthetic */ int u(b bVar) {
        int i = bVar.gFU;
        bVar.gFU = i - 1;
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
        this.gFX = forumWriteData;
    }

    public void sX(String str) {
        this.gFY = str;
    }

    private void initView() {
        if (this.abz != null && this.abz.getPageActivity() != null && this.aaQ != null) {
            this.gFA = LayoutInflater.from(this.abz.getPageActivity()).inflate(d.j.bottom_write_thread, (ViewGroup) null);
            this.gFE = (LinearLayout) this.gFA.findViewById(d.h.home_write_article);
            this.gFF = (TbImageView) this.gFA.findViewById(d.h.home_write_article_icon);
            this.gFG = (TextView) this.gFA.findViewById(d.h.home_write_article_title);
            this.gFB = (LinearLayout) this.gFA.findViewById(d.h.home_write_photo);
            this.gFC = (TbImageView) this.gFA.findViewById(d.h.home_write_photo_icon);
            this.gFD = (TextView) this.gFA.findViewById(d.h.home_write_photo_title);
            this.gFH = (LinearLayout) this.gFA.findViewById(d.h.home_write_video);
            this.gFI = (TbImageView) this.gFA.findViewById(d.h.home_write_video_icon);
            this.gFJ = (TextView) this.gFA.findViewById(d.h.home_write_video_title);
            this.gFK = (LinearLayout) this.gFA.findViewById(d.h.home_write_live);
            this.gFL = (TbImageView) this.gFA.findViewById(d.h.home_write_live_icon);
            this.gFM = (TextView) this.gFA.findViewById(d.h.home_write_live_title);
            this.gFN = (LinearLayout) this.gFA.findViewById(d.h.home_write_url);
            this.gFO = (TbImageView) this.gFA.findViewById(d.h.home_write_url_icon);
            this.gFP = (TextView) this.gFA.findViewById(d.h.home_write_url_title);
            this.gFQ = (ImageView) this.gFA.findViewById(d.h.write_close_view);
            this.gFz = this.gFA.findViewById(d.h.view_background);
            this.gFR = (GridLayout) this.gFA.findViewById(d.h.type_container);
            this.gFR.setMeasureAllChild(true);
            this.gFR.setVerNum(2);
            this.eAe.add(this.gFE);
            this.eAe.add(this.gFB);
            this.gFZ = XiaoyingUtil.showXiaoyingTool();
            this.gFZ = true;
            a(this.gFR, this.gFZ);
            if (!this.gFZ) {
                this.gFH.setVisibility(8);
                this.gFK.setPadding(0, l.f(this.abz.getPageActivity(), d.f.ds60), 0, 0);
            } else {
                this.eAe.add(this.gFH);
                this.gFK.setPadding(0, 0, 0, l.f(this.abz.getPageActivity(), d.f.ds120));
            }
            this.eAe.add(this.gFK);
            this.gGa = af.fS();
            if (this.gGa) {
                this.eAe.add(this.gFN);
            } else {
                this.gFN.setVisibility(8);
            }
            b(this.gFR, this.gGa);
            this.gFA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bM(b.this.gFR);
                }
            });
            this.gFL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.byS();
                    MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                    String str = "0";
                    String str2 = null;
                    com.baidu.adp.lib.d.a.fc().D(false);
                    if (b.this.gFX != null) {
                        str = b.this.gFX.forumId;
                        str2 = b.this.gFX.forumName;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, new AlaLiveRoomActivityConfig(TbadkCoreApplication.getInst().getApplicationContext(), str2, str, TbadkCoreApplication.getCurrentAccount(), true, false)));
                }
            });
            this.gFC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    int i;
                    b.this.byS();
                    String str2 = "0";
                    String str3 = null;
                    PostPrefixData postPrefixData = null;
                    AntiData antiData = null;
                    if (b.this.gFX != null) {
                        str2 = b.this.gFX.forumId;
                        str3 = b.this.gFX.forumName;
                        postPrefixData = b.this.gFX.prefixData;
                        antiData = b.this.gFX.antiData;
                        int i2 = b.this.gFX.forumLevel;
                        str = b.this.gFX.avatar;
                        i = i2;
                    } else {
                        str = null;
                        i = -1;
                    }
                    TiebaStatic.log(new ak("c12373").ad("obj_locate", b.this.gFY).ad("fid", str2));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(b.this.abz.getPageActivity(), 0, str2, str3, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", b.this.aiq);
                    writeActivityConfig.setCallFrom(b.this.gFY);
                    writeActivityConfig.setForumLevel(i);
                    writeActivityConfig.setForumAvatar(str);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            });
            this.gFF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    int i;
                    b.this.byS();
                    String str2 = "0";
                    String str3 = null;
                    PostPrefixData postPrefixData = null;
                    AntiData antiData = null;
                    if (b.this.gFX != null) {
                        str2 = b.this.gFX.forumId;
                        str3 = b.this.gFX.forumName;
                        postPrefixData = b.this.gFX.prefixData;
                        antiData = b.this.gFX.antiData;
                        int i2 = b.this.gFX.forumLevel;
                        str = b.this.gFX.avatar;
                        i = i2;
                    } else {
                        str = null;
                        i = -1;
                    }
                    TiebaStatic.log(new ak("c12372").ad("obj_locate", b.this.gFY).ad("fid", str2));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(b.this.abz.getPageActivity(), 9, str2, str3, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", b.this.aiq);
                    writeActivityConfig.setCallFrom(b.this.gFY);
                    writeActivityConfig.setForumLevel(i);
                    writeActivityConfig.setForumAvatar(str);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            });
            if (this.gGa) {
                this.gFO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        b.this.byS();
                        String str = "0";
                        String str2 = null;
                        if (b.this.gFX != null) {
                            str = b.this.gFX.forumId;
                            str2 = b.this.gFX.forumName;
                        }
                        WriteUrlActivityConfig writeUrlActivityConfig = new WriteUrlActivityConfig(b.this.abz.getPageActivity(), str, str2, b.this.gFY);
                        writeUrlActivityConfig.getIntent().putExtra("from", b.this.aiq);
                        writeUrlActivityConfig.setRequestCode(13003);
                        writeUrlActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeUrlActivityConfig));
                        TiebaStatic.log(new ak("c12162").ad("obj_locate", b.this.gFY));
                    }
                });
            }
            if (this.gFZ) {
                this.gFI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        b.this.byS();
                        String str = "0";
                        String str2 = null;
                        if (b.this.gFY.equals("1")) {
                            TiebaStatic.log(new ak("c12292").ad("obj_locate", "2"));
                        } else {
                            TiebaStatic.log(new ak("c12292").ad("obj_locate", "1"));
                        }
                        if (b.this.gFX != null) {
                            str = b.this.gFX.forumId;
                            str2 = b.this.gFX.forumName;
                        }
                        e.b(b.this.abz, str, str2);
                    }
                });
            }
            onChangeSkinType();
            this.gGb = AnimationUtils.loadAnimation(this.abz.getPageActivity(), d.a.write_thread_black_anim);
            this.gGb.setFillAfter(true);
            this.gGc = AnimationUtils.loadAnimation(this.abz.getPageActivity(), d.a.write_thread_black_hide_anim);
            this.gGc.setFillAfter(true);
            this.gGd = AnimationUtils.loadAnimation(this.abz.getPageActivity(), d.a.write_tab_bg_anim);
            this.gGd.setFillAfter(true);
            this.gGe = AnimationUtils.loadAnimation(this.abz.getPageActivity(), d.a.home_write_bgout);
            this.gGe.setFillAfter(true);
        }
    }

    private void a(GridLayout gridLayout, boolean z) {
        if (!z) {
            this.gFH.setVisibility(8);
            if (gridLayout.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) gridLayout.getLayoutParams()).bottomMargin = l.f(this.abz.getPageActivity(), d.f.ds60);
            }
        }
    }

    private void b(GridLayout gridLayout, boolean z) {
        if (!z) {
            this.gFN.setVisibility(8);
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
            b.this.gFE.setVisibility(4);
            b.this.gFB.setVisibility(4);
            if (b.this.gFZ) {
                b.this.gFH.setVisibility(4);
            } else {
                b.this.gFH.setVisibility(8);
            }
            if (b.this.gGa) {
                b.this.gFN.setVisibility(4);
            } else {
                b.this.gFN.setVisibility(8);
            }
            b.this.gFK.setVisibility(4);
            b.this.gFQ.setVisibility(4);
            b.this.gFz.setVisibility(4);
            if (this.mView != null) {
                this.mView.setVisibility(8);
            }
            if (b.this.gFA.getParent() == b.this.aaQ) {
                b.this.aaQ.removeView(b.this.gFA);
            }
            b.this.gFT = false;
        }
    }

    public void nn(boolean z) {
        if (!this.gFT && this.gFV && this.gFW && this.aaQ != null) {
            this.gFQ.clearAnimation();
            this.gFT = true;
            if (this.gFA.getParent() == null) {
                com.baidu.tbadk.j.d.Q(this.aaQ).a(this.aaQ, this.gFA, z);
            }
            this.gFR.setVisibility(0);
            this.gFz.setVisibility(0);
            this.gFz.clearAnimation();
            this.gFz.startAnimation(this.gGd);
            this.gFQ.setVisibility(0);
            this.gFQ.startAnimation(this.gGb);
            byQ();
            TiebaStatic.log(new ak("c12052").ad("obj_locate", this.gFY));
        }
    }

    private void byQ() {
        clearAnimation();
        final int size = this.eAe.size();
        this.gFV = false;
        this.gFU = 0;
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
                            if (b.this.gFU == size) {
                                b.this.gFV = true;
                                b.this.gFU = 0;
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

    public void byR() {
        bM(this.gFR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bM(View view) {
        if (this.gFV && this.gFW) {
            if (this.gFS != null) {
                com.baidu.adp.lib.g.e.fP().removeCallbacks(this.gFS);
            }
            this.gFz.clearAnimation();
            this.gFz.startAnimation(this.gGe);
            this.gFQ.clearAnimation();
            this.gFQ.startAnimation(this.gGc);
            byT();
            this.gFS = new a(view);
            com.baidu.adp.lib.g.e.fP().postDelayed(this.gFS, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byS() {
        this.gFV = true;
        this.gFW = true;
        if (this.gFS != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.gFS);
        }
        if (this.gFS == null) {
            this.gFS = new a(this.gFR);
        }
        com.baidu.adp.lib.g.e.fP().postDelayed(this.gFS, 500L);
    }

    private void byT() {
        clearAnimation();
        int size = this.eAe.size();
        this.gFU = size;
        this.gFW = false;
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
                            if (b.this.gFU == 1) {
                                b.this.gFW = true;
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
        this.gFE.clearAnimation();
        this.gFB.clearAnimation();
        this.gFH.clearAnimation();
        this.gFK.clearAnimation();
        this.gFN.clearAnimation();
    }

    public void onChangeSkinType() {
        aj.k(this.gFz, d.e.cp_bg_line_d_alpha98);
        aj.c(this.gFC, d.g.icon_posts_photo_n);
        aj.c(this.gFF, d.g.icon_posts_article_n);
        aj.c(this.gFI, d.g.icon_posts_video_n);
        aj.c(this.gFL, d.g.icon_posts_live_n);
        aj.c(this.gFQ, d.g.icon_tabbar_add_s);
        aj.c(this.gFO, d.g.icon_posts_url_n);
        aj.i(this.gFD, d.e.cp_cont_f);
        aj.i(this.gFG, d.e.cp_cont_f);
        aj.i(this.gFJ, d.e.cp_cont_f);
        aj.i(this.gFM, d.e.cp_cont_f);
        aj.i(this.gFP, d.e.cp_cont_f);
    }

    public void onDestroy() {
        if (this.gFA != null && this.gFA.getParent() == this.aaQ) {
            this.aaQ.removeView(this.gFA);
        }
        if (this.gFS != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.gFS);
            this.gFS = null;
        }
        this.eAe.clear();
    }

    public boolean isShowing() {
        return this.gFT;
    }
}
