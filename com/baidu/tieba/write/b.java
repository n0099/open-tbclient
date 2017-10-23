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
    private ViewGroup aaE;
    private TbPageContext abm;
    private String aie;
    private TextView gFA;
    private ImageView gFB;
    private GridLayout gFC;
    private a gFD;
    private ForumWriteData gFI;
    private String gFJ;
    private boolean gFK;
    private boolean gFL;
    private Animation gFM;
    private Animation gFN;
    private Animation gFO;
    private Animation gFP;
    private View gFk;
    private View gFl;
    private LinearLayout gFm;
    private TbImageView gFn;
    private TextView gFo;
    private LinearLayout gFp;
    private TbImageView gFq;
    private TextView gFr;
    private LinearLayout gFs;
    private TbImageView gFt;
    private TextView gFu;
    private LinearLayout gFv;
    private TbImageView gFw;
    private TextView gFx;
    private LinearLayout gFy;
    private TbImageView gFz;
    private boolean gFE = false;
    private int gFF = 0;
    private boolean gFG = true;
    private boolean gFH = true;
    private ArrayList<View> ezQ = new ArrayList<>();

    static /* synthetic */ int s(b bVar) {
        int i = bVar.gFF;
        bVar.gFF = i + 1;
        return i;
    }

    static /* synthetic */ int u(b bVar) {
        int i = bVar.gFF;
        bVar.gFF = i - 1;
        return i;
    }

    public b(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this.aie = AlbumActivityConfig.FROM_WRITE;
        this.abm = tbPageContext;
        this.aaE = viewGroup;
        this.aie = str;
        initView();
    }

    public void a(ForumWriteData forumWriteData) {
        this.gFI = forumWriteData;
    }

    public void sW(String str) {
        this.gFJ = str;
    }

    private void initView() {
        if (this.abm != null && this.abm.getPageActivity() != null && this.aaE != null) {
            this.gFl = LayoutInflater.from(this.abm.getPageActivity()).inflate(d.j.bottom_write_thread, (ViewGroup) null);
            this.gFp = (LinearLayout) this.gFl.findViewById(d.h.home_write_article);
            this.gFq = (TbImageView) this.gFl.findViewById(d.h.home_write_article_icon);
            this.gFr = (TextView) this.gFl.findViewById(d.h.home_write_article_title);
            this.gFm = (LinearLayout) this.gFl.findViewById(d.h.home_write_photo);
            this.gFn = (TbImageView) this.gFl.findViewById(d.h.home_write_photo_icon);
            this.gFo = (TextView) this.gFl.findViewById(d.h.home_write_photo_title);
            this.gFs = (LinearLayout) this.gFl.findViewById(d.h.home_write_video);
            this.gFt = (TbImageView) this.gFl.findViewById(d.h.home_write_video_icon);
            this.gFu = (TextView) this.gFl.findViewById(d.h.home_write_video_title);
            this.gFv = (LinearLayout) this.gFl.findViewById(d.h.home_write_live);
            this.gFw = (TbImageView) this.gFl.findViewById(d.h.home_write_live_icon);
            this.gFx = (TextView) this.gFl.findViewById(d.h.home_write_live_title);
            this.gFy = (LinearLayout) this.gFl.findViewById(d.h.home_write_url);
            this.gFz = (TbImageView) this.gFl.findViewById(d.h.home_write_url_icon);
            this.gFA = (TextView) this.gFl.findViewById(d.h.home_write_url_title);
            this.gFB = (ImageView) this.gFl.findViewById(d.h.write_close_view);
            this.gFk = this.gFl.findViewById(d.h.view_background);
            this.gFC = (GridLayout) this.gFl.findViewById(d.h.type_container);
            this.gFC.setMeasureAllChild(true);
            this.gFC.setVerNum(2);
            this.ezQ.add(this.gFp);
            this.ezQ.add(this.gFm);
            this.gFK = XiaoyingUtil.showXiaoyingTool();
            this.gFK = true;
            a(this.gFC, this.gFK);
            if (!this.gFK) {
                this.gFs.setVisibility(8);
                this.gFv.setPadding(0, l.f(this.abm.getPageActivity(), d.f.ds60), 0, 0);
            } else {
                this.ezQ.add(this.gFs);
                this.gFv.setPadding(0, 0, 0, l.f(this.abm.getPageActivity(), d.f.ds120));
            }
            this.ezQ.add(this.gFv);
            this.gFL = af.fS();
            if (this.gFL) {
                this.ezQ.add(this.gFy);
            } else {
                this.gFy.setVisibility(8);
            }
            b(this.gFC, this.gFL);
            this.gFl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bM(b.this.gFC);
                }
            });
            this.gFw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.byM();
                    MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                    String str = "0";
                    String str2 = null;
                    com.baidu.adp.lib.d.a.fc().D(false);
                    if (b.this.gFI != null) {
                        str = b.this.gFI.forumId;
                        str2 = b.this.gFI.forumName;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, new AlaLiveRoomActivityConfig(TbadkCoreApplication.getInst().getApplicationContext(), str2, str, TbadkCoreApplication.getCurrentAccount(), true, false)));
                }
            });
            this.gFn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    int i;
                    b.this.byM();
                    String str2 = "0";
                    String str3 = null;
                    PostPrefixData postPrefixData = null;
                    AntiData antiData = null;
                    if (b.this.gFI != null) {
                        str2 = b.this.gFI.forumId;
                        str3 = b.this.gFI.forumName;
                        postPrefixData = b.this.gFI.prefixData;
                        antiData = b.this.gFI.antiData;
                        int i2 = b.this.gFI.forumLevel;
                        str = b.this.gFI.avatar;
                        i = i2;
                    } else {
                        str = null;
                        i = -1;
                    }
                    TiebaStatic.log(new ak("c12373").ac("obj_locate", b.this.gFJ).ac("fid", str2));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(b.this.abm.getPageActivity(), 0, str2, str3, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", b.this.aie);
                    writeActivityConfig.setCallFrom(b.this.gFJ);
                    writeActivityConfig.setForumLevel(i);
                    writeActivityConfig.setForumAvatar(str);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            });
            this.gFq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    int i;
                    b.this.byM();
                    String str2 = "0";
                    String str3 = null;
                    PostPrefixData postPrefixData = null;
                    AntiData antiData = null;
                    if (b.this.gFI != null) {
                        str2 = b.this.gFI.forumId;
                        str3 = b.this.gFI.forumName;
                        postPrefixData = b.this.gFI.prefixData;
                        antiData = b.this.gFI.antiData;
                        int i2 = b.this.gFI.forumLevel;
                        str = b.this.gFI.avatar;
                        i = i2;
                    } else {
                        str = null;
                        i = -1;
                    }
                    TiebaStatic.log(new ak("c12372").ac("obj_locate", b.this.gFJ).ac("fid", str2));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(b.this.abm.getPageActivity(), 9, str2, str3, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", b.this.aie);
                    writeActivityConfig.setCallFrom(b.this.gFJ);
                    writeActivityConfig.setForumLevel(i);
                    writeActivityConfig.setForumAvatar(str);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            });
            if (this.gFL) {
                this.gFz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        b.this.byM();
                        String str = "0";
                        String str2 = null;
                        if (b.this.gFI != null) {
                            str = b.this.gFI.forumId;
                            str2 = b.this.gFI.forumName;
                        }
                        WriteUrlActivityConfig writeUrlActivityConfig = new WriteUrlActivityConfig(b.this.abm.getPageActivity(), str, str2, b.this.gFJ);
                        writeUrlActivityConfig.getIntent().putExtra("from", b.this.aie);
                        writeUrlActivityConfig.setRequestCode(13003);
                        writeUrlActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeUrlActivityConfig));
                        TiebaStatic.log(new ak("c12162").ac("obj_locate", b.this.gFJ));
                    }
                });
            }
            if (this.gFK) {
                this.gFt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        b.this.byM();
                        String str = "0";
                        String str2 = null;
                        if (b.this.gFJ.equals("1")) {
                            TiebaStatic.log(new ak("c12292").ac("obj_locate", "2"));
                        } else {
                            TiebaStatic.log(new ak("c12292").ac("obj_locate", "1"));
                        }
                        if (b.this.gFI != null) {
                            str = b.this.gFI.forumId;
                            str2 = b.this.gFI.forumName;
                        }
                        e.b(b.this.abm, str, str2);
                    }
                });
            }
            onChangeSkinType();
            this.gFM = AnimationUtils.loadAnimation(this.abm.getPageActivity(), d.a.write_thread_black_anim);
            this.gFM.setFillAfter(true);
            this.gFN = AnimationUtils.loadAnimation(this.abm.getPageActivity(), d.a.write_thread_black_hide_anim);
            this.gFN.setFillAfter(true);
            this.gFO = AnimationUtils.loadAnimation(this.abm.getPageActivity(), d.a.write_tab_bg_anim);
            this.gFO.setFillAfter(true);
            this.gFP = AnimationUtils.loadAnimation(this.abm.getPageActivity(), d.a.home_write_bgout);
            this.gFP.setFillAfter(true);
        }
    }

    private void a(GridLayout gridLayout, boolean z) {
        if (!z) {
            this.gFs.setVisibility(8);
            if (gridLayout.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) gridLayout.getLayoutParams()).bottomMargin = l.f(this.abm.getPageActivity(), d.f.ds60);
            }
        }
    }

    private void b(GridLayout gridLayout, boolean z) {
        if (!z) {
            this.gFy.setVisibility(8);
            if (gridLayout.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) gridLayout.getLayoutParams()).bottomMargin = l.f(this.abm.getPageActivity(), d.f.ds60);
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
            b.this.gFp.setVisibility(4);
            b.this.gFm.setVisibility(4);
            if (b.this.gFK) {
                b.this.gFs.setVisibility(4);
            } else {
                b.this.gFs.setVisibility(8);
            }
            if (b.this.gFL) {
                b.this.gFy.setVisibility(4);
            } else {
                b.this.gFy.setVisibility(8);
            }
            b.this.gFv.setVisibility(4);
            b.this.gFB.setVisibility(4);
            b.this.gFk.setVisibility(4);
            if (this.mView != null) {
                this.mView.setVisibility(8);
            }
            if (b.this.gFl.getParent() == b.this.aaE) {
                b.this.aaE.removeView(b.this.gFl);
            }
            b.this.gFE = false;
        }
    }

    public void nm(boolean z) {
        if (!this.gFE && this.gFG && this.gFH && this.aaE != null) {
            this.gFB.clearAnimation();
            this.gFE = true;
            if (this.gFl.getParent() == null) {
                com.baidu.tbadk.j.d.Q(this.aaE).a(this.aaE, this.gFl, z);
            }
            this.gFC.setVisibility(0);
            this.gFk.setVisibility(0);
            this.gFk.clearAnimation();
            this.gFk.startAnimation(this.gFO);
            this.gFB.setVisibility(0);
            this.gFB.startAnimation(this.gFM);
            byK();
            TiebaStatic.log(new ak("c12052").ac("obj_locate", this.gFJ));
        }
    }

    private void byK() {
        clearAnimation();
        final int size = this.ezQ.size();
        this.gFG = false;
        this.gFF = 0;
        for (int i = 0; i < size; i++) {
            final View view = this.ezQ.get(i);
            com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.b.7
                @Override // java.lang.Runnable
                public void run() {
                    view.setVisibility(0);
                    Animation loadAnimation = AnimationUtils.loadAnimation(b.this.abm.getPageActivity(), d.a.write_tab_icon_show_anim);
                    loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.b.7.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            b.s(b.this);
                            if (b.this.gFF == size) {
                                b.this.gFG = true;
                                b.this.gFF = 0;
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

    public void byL() {
        bM(this.gFC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bM(View view) {
        if (this.gFG && this.gFH) {
            if (this.gFD != null) {
                com.baidu.adp.lib.g.e.fP().removeCallbacks(this.gFD);
            }
            this.gFk.clearAnimation();
            this.gFk.startAnimation(this.gFP);
            this.gFB.clearAnimation();
            this.gFB.startAnimation(this.gFN);
            byN();
            this.gFD = new a(view);
            com.baidu.adp.lib.g.e.fP().postDelayed(this.gFD, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byM() {
        this.gFG = true;
        this.gFH = true;
        if (this.gFD != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.gFD);
        }
        if (this.gFD == null) {
            this.gFD = new a(this.gFC);
        }
        com.baidu.adp.lib.g.e.fP().postDelayed(this.gFD, 500L);
    }

    private void byN() {
        clearAnimation();
        int size = this.ezQ.size();
        this.gFF = size;
        this.gFH = false;
        int i = size - 1;
        for (int i2 = 0; i2 < size; i2++) {
            final View view = this.ezQ.get(i);
            i--;
            com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.b.8
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(b.this.abm.getPageActivity(), d.a.write_tab_icon_hide_anim);
                    loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.b.8.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            view.setVisibility(4);
                            if (b.this.gFF == 1) {
                                b.this.gFH = true;
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
        this.gFp.clearAnimation();
        this.gFm.clearAnimation();
        this.gFs.clearAnimation();
        this.gFv.clearAnimation();
        this.gFy.clearAnimation();
    }

    public void onChangeSkinType() {
        aj.k(this.gFk, d.e.cp_bg_line_d_alpha98);
        aj.c(this.gFn, d.g.icon_posts_photo_n);
        aj.c(this.gFq, d.g.icon_posts_article_n);
        aj.c(this.gFt, d.g.icon_posts_video_n);
        aj.c(this.gFw, d.g.icon_posts_live_n);
        aj.c(this.gFB, d.g.icon_tabbar_add_s);
        aj.c(this.gFz, d.g.icon_posts_url_n);
        aj.i(this.gFo, d.e.cp_cont_f);
        aj.i(this.gFr, d.e.cp_cont_f);
        aj.i(this.gFu, d.e.cp_cont_f);
        aj.i(this.gFx, d.e.cp_cont_f);
        aj.i(this.gFA, d.e.cp_cont_f);
    }

    public void onDestroy() {
        if (this.gFl != null && this.gFl.getParent() == this.aaE) {
            this.aaE.removeView(this.gFl);
        }
        if (this.gFD != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.gFD);
            this.gFD = null;
        }
        this.ezQ.clear();
    }

    public boolean isShowing() {
        return this.gFE;
    }
}
