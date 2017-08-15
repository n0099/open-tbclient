package com.baidu.tieba.write;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.p.ad;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.GridLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ForumWriteData;
/* loaded from: classes.dex */
public class b {
    private ViewGroup abM;
    private TbPageContext acr;
    private View gAY;
    private TbImageView gAZ;
    private TextView gBa;
    private TbImageView gBb;
    private TextView gBc;
    private TbImageView gBd;
    private TextView gBe;
    private TbImageView gBf;
    private TextView gBg;
    private TbImageView gBh;
    private TextView gBi;
    private TbImageView gBj;
    private GridLayout gBk;
    private a gBl;
    private ForumWriteData gBn;
    private String gBo;
    private PopupWindow gBq;
    private boolean gBr;
    private boolean gBm = false;
    private boolean gBp = false;
    private View.OnClickListener gos = new View.OnClickListener() { // from class: com.baidu.tieba.write.b.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.byk();
        }
    };
    private Runnable gor = new Runnable() { // from class: com.baidu.tieba.write.b.9
        @Override // java.lang.Runnable
        public void run() {
            b.this.bvb();
        }
    };
    private Runnable goq = new Runnable() { // from class: com.baidu.tieba.write.b.10
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.gBi != null && b.this.gAY != null) {
                g.showPopupWindowAsDropDown(b.this.gBq, b.this.gBi);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_write_url_tips", true);
                b.this.gBp = true;
                b.this.gAY.postDelayed(b.this.gor, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    };

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.acr = tbPageContext;
        this.abM = viewGroup;
        initView();
    }

    public void a(ForumWriteData forumWriteData) {
        this.gBn = forumWriteData;
    }

    public void sR(String str) {
        this.gBo = str;
    }

    private void initView() {
        if (this.acr != null && this.acr.getPageActivity() != null && this.abM != null) {
            this.gAY = LayoutInflater.from(this.acr.getPageActivity()).inflate(d.j.bottom_write_thread, (ViewGroup) null);
            this.gBb = (TbImageView) this.gAY.findViewById(d.h.home_write_article_icon);
            this.gBc = (TextView) this.gAY.findViewById(d.h.home_write_article_title);
            this.gAZ = (TbImageView) this.gAY.findViewById(d.h.home_write_photo_icon);
            this.gBa = (TextView) this.gAY.findViewById(d.h.home_write_photo_title);
            this.gBd = (TbImageView) this.gAY.findViewById(d.h.home_write_video_icon);
            this.gBe = (TextView) this.gAY.findViewById(d.h.home_write_video_title);
            this.gBf = (TbImageView) this.gAY.findViewById(d.h.home_write_live_icon);
            this.gBg = (TextView) this.gAY.findViewById(d.h.home_write_live_title);
            this.gBh = (TbImageView) this.gAY.findViewById(d.h.home_write_url_icon);
            this.gBi = (TextView) this.gAY.findViewById(d.h.home_write_url_title);
            this.gBj = (TbImageView) this.gAY.findViewById(d.h.write_switch);
            this.gBk = (GridLayout) this.gAY.findViewById(d.h.type_container);
            this.gBk.setMeasureAllChild(true);
            this.gBk.setVerNum(2);
            this.gBr = XiaoyingUtil.showXiaoyingTool();
            a(this.gBk, this.gBr);
            boolean ge = ad.ge();
            b(this.gBk, ge);
            this.gAY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.d(b.this.gBk, b.this.gBj);
                }
            });
            this.gAY.findViewById(d.h.home_write_live).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.d(b.this.gBk, b.this.gBj);
                    MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                    String str = "0";
                    String str2 = null;
                    if (b.this.gBn != null) {
                        str = b.this.gBn.forumId;
                        str2 = b.this.gBn.forumName;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, new AlaLiveRoomActivityConfig(TbadkCoreApplication.getInst().getApplicationContext(), str2, str, TbadkCoreApplication.getCurrentAccount(), true, false)));
                }
            });
            this.gAY.findViewById(d.h.home_write_photo).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    int i;
                    b.this.d(b.this.gBk, b.this.gBj);
                    String str2 = "0";
                    String str3 = null;
                    PostPrefixData postPrefixData = null;
                    AntiData antiData = null;
                    if (b.this.gBn != null) {
                        str2 = b.this.gBn.forumId;
                        str3 = b.this.gBn.forumName;
                        postPrefixData = b.this.gBn.prefixData;
                        antiData = b.this.gBn.antiData;
                        int i2 = b.this.gBn.forumLevel;
                        str = b.this.gBn.avatar;
                        i = i2;
                    } else {
                        str = null;
                        i = -1;
                    }
                    TiebaStatic.log(new aj("c12373").aa("obj_locate", b.this.gBo).aa("fid", str2));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(b.this.acr.getPageActivity(), 0, str2, str3, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.setCallFrom(b.this.gBo);
                    writeActivityConfig.setForumLevel(i);
                    writeActivityConfig.setForumAvatar(str);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            });
            this.gAY.findViewById(d.h.home_write_article).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    int i;
                    b.this.d(b.this.gBk, b.this.gBj);
                    String str2 = "0";
                    String str3 = null;
                    PostPrefixData postPrefixData = null;
                    AntiData antiData = null;
                    if (b.this.gBn != null) {
                        str2 = b.this.gBn.forumId;
                        str3 = b.this.gBn.forumName;
                        postPrefixData = b.this.gBn.prefixData;
                        antiData = b.this.gBn.antiData;
                        int i2 = b.this.gBn.forumLevel;
                        str = b.this.gBn.avatar;
                        i = i2;
                    } else {
                        str = null;
                        i = -1;
                    }
                    TiebaStatic.log(new aj("c12372").aa("obj_locate", b.this.gBo).aa("fid", str2));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(b.this.acr.getPageActivity(), 9, str2, str3, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.setCallFrom(b.this.gBo);
                    writeActivityConfig.setForumLevel(i);
                    writeActivityConfig.setForumAvatar(str);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            });
            if (ge) {
                this.gAY.findViewById(d.h.home_write_url).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        b.this.d(b.this.gBk, b.this.gBj);
                        String str = "0";
                        String str2 = null;
                        if (b.this.gBn != null) {
                            str = b.this.gBn.forumId;
                            str2 = b.this.gBn.forumName;
                        }
                        WriteUrlActivityConfig writeUrlActivityConfig = new WriteUrlActivityConfig(b.this.acr.getPageActivity(), str, str2, b.this.gBo);
                        writeUrlActivityConfig.setRequestCode(13003);
                        writeUrlActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeUrlActivityConfig));
                        TiebaStatic.log(new aj("c12162").aa("obj_locate", b.this.gBo));
                    }
                });
            }
            if (this.gBr) {
                this.gAY.findViewById(d.h.home_write_video).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        b.this.d(b.this.gBk, b.this.gBj);
                        String str = "0";
                        String str2 = null;
                        if (b.this.gBn != null) {
                            str = b.this.gBn.forumId;
                            str2 = b.this.gBn.forumName;
                        }
                        e.c(b.this.acr, str, str2);
                    }
                });
            }
            onChangeSkinType();
            if (ge) {
                byj();
            }
        }
    }

    public void byj() {
        if (!this.gBp && this.gAY != null) {
            this.gBp = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_write_url_tips", false);
            if (!this.gBp) {
                View inflate = LayoutInflater.from(this.acr.getContext()).inflate(d.j.tips_blue_right_up, (ViewGroup) null);
                View findViewById = inflate.findViewById(d.h.arrow_up);
                TextView textView = (TextView) inflate.findViewById(d.h.tips);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                if (this.gBr) {
                    layoutParams.rightMargin = k.g(this.acr.getContext(), d.f.ds120);
                } else {
                    layoutParams.gravity = 3;
                    layoutParams.leftMargin = k.g(this.acr.getContext(), d.f.ds10);
                }
                textView.setText(d.l.write_url_tips);
                textView.setOnClickListener(this.gos);
                this.gBq = new PopupWindow(inflate, -2, -2);
                this.gAY.removeCallbacks(this.goq);
                this.gAY.postDelayed(this.goq, 400L);
            }
        }
    }

    public void byk() {
        if (this.gAY != null) {
            this.gAY.removeCallbacks(this.goq);
            this.gAY.removeCallbacks(this.gor);
        }
        bvb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvb() {
        g.a(this.gBq);
    }

    private void a(GridLayout gridLayout, boolean z) {
        if (!z) {
            gridLayout.findViewById(d.h.home_write_video).setVisibility(8);
            if (gridLayout.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) gridLayout.getLayoutParams()).bottomMargin = k.g(this.acr.getPageActivity(), d.f.ds60);
            }
        }
    }

    private void b(GridLayout gridLayout, boolean z) {
        if (!z) {
            gridLayout.findViewById(d.h.home_write_url).setVisibility(8);
            if (gridLayout.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) gridLayout.getLayoutParams()).bottomMargin = k.g(this.acr.getPageActivity(), d.f.ds60);
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
            if (this.mView != null) {
                this.mView.setVisibility(8);
            }
            if (b.this.gAY.getParent() == b.this.abM) {
                b.this.abM.removeView(b.this.gAY);
            }
            b.this.gBm = false;
        }
    }

    public void nb(boolean z) {
        if (!this.gBm && this.abM != null) {
            this.gBm = true;
            if (this.gAY.getParent() == null) {
                com.baidu.tbadk.k.d.K(this.abM).a(this.abM, this.gAY, z);
            }
            com.baidu.adp.lib.g.e.ga().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.b.2
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(b.this.acr.getPageActivity(), d.a.home_write_bgin);
                    loadAnimation.setFillAfter(true);
                    b.this.gBk.setVisibility(0);
                    b.this.gBk.startAnimation(loadAnimation);
                    b.this.gBj.setVisibility(0);
                    b.this.gBj.startAnimation(AnimationUtils.loadAnimation(b.this.acr.getPageActivity(), d.a.write_thread_anim));
                }
            }, 100L);
            TiebaStatic.log(new aj("c12052").aa("obj_locate", this.gBo));
        }
    }

    public void byl() {
        d(this.gBk, this.gBj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(View view, View view2) {
        byk();
        if (this.gBl != null) {
            com.baidu.adp.lib.g.e.ga().removeCallbacks(this.gBl);
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.acr.getPageActivity(), d.a.home_write_bgout);
        loadAnimation.setFillAfter(true);
        view.startAnimation(loadAnimation);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.acr.getPageActivity(), d.a.home_write_out);
        loadAnimation2.setFillAfter(true);
        view2.startAnimation(loadAnimation2);
        this.gBl = new a(view);
        com.baidu.adp.lib.g.e.ga().postDelayed(this.gBl, 300L);
    }

    public void onChangeSkinType() {
        ai.k(this.gAY, d.e.cp_bg_line_d);
        ai.c(this.gAZ, d.g.icon_posts_photo_n);
        ai.c(this.gBb, d.g.icon_posts_article_n);
        ai.c(this.gBd, d.g.icon_posts_video_n);
        ai.c(this.gBf, d.g.icon_posts_live_n);
        ai.c(this.gBj, d.g.home_write_s);
        ai.c(this.gBh, d.g.icon_posts_url_n);
        ai.i(this.gBa, d.e.cp_cont_f);
        ai.i(this.gBc, d.e.cp_cont_f);
        ai.i(this.gBe, d.e.cp_cont_f);
        ai.i(this.gBg, d.e.cp_cont_f);
        ai.i(this.gBi, d.e.cp_cont_f);
    }

    public void onDestroy() {
        byk();
        if (this.gAY != null && this.gAY.getParent() == this.abM) {
            this.abM.removeView(this.gAY);
        }
        if (this.gBl != null) {
            com.baidu.adp.lib.g.e.ga().removeCallbacks(this.gBl);
            this.gBl = null;
        }
    }

    public boolean isShowing() {
        return this.gBm;
    }
}
