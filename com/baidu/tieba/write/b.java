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
    private TbPageContext aaS;
    private ViewGroup aan;
    private View gxV;
    private TbImageView gxW;
    private TextView gxX;
    private TbImageView gxY;
    private TextView gxZ;
    private TbImageView gya;
    private TextView gyb;
    private TbImageView gyc;
    private TextView gyd;
    private TbImageView gye;
    private TextView gyf;
    private TbImageView gyg;
    private GridLayout gyh;
    private a gyi;
    private ForumWriteData gyk;
    private String gyl;
    private PopupWindow gyn;
    private boolean gyo;
    private boolean gyj = false;
    private boolean gym = false;
    private View.OnClickListener glo = new View.OnClickListener() { // from class: com.baidu.tieba.write.b.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.bxv();
        }
    };
    private Runnable gln = new Runnable() { // from class: com.baidu.tieba.write.b.9
        @Override // java.lang.Runnable
        public void run() {
            b.this.bum();
        }
    };
    private Runnable glm = new Runnable() { // from class: com.baidu.tieba.write.b.10
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.gyf != null && b.this.gxV != null) {
                g.showPopupWindowAsDropDown(b.this.gyn, b.this.gyf);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_write_url_tips", true);
                b.this.gym = true;
                b.this.gxV.postDelayed(b.this.gln, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    };

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.aaS = tbPageContext;
        this.aan = viewGroup;
        initView();
    }

    public void a(ForumWriteData forumWriteData) {
        this.gyk = forumWriteData;
    }

    public void sK(String str) {
        this.gyl = str;
    }

    private void initView() {
        if (this.aaS != null && this.aaS.getPageActivity() != null && this.aan != null) {
            this.gxV = LayoutInflater.from(this.aaS.getPageActivity()).inflate(d.j.bottom_write_thread, (ViewGroup) null);
            this.gxY = (TbImageView) this.gxV.findViewById(d.h.home_write_article_icon);
            this.gxZ = (TextView) this.gxV.findViewById(d.h.home_write_article_title);
            this.gxW = (TbImageView) this.gxV.findViewById(d.h.home_write_photo_icon);
            this.gxX = (TextView) this.gxV.findViewById(d.h.home_write_photo_title);
            this.gya = (TbImageView) this.gxV.findViewById(d.h.home_write_video_icon);
            this.gyb = (TextView) this.gxV.findViewById(d.h.home_write_video_title);
            this.gyc = (TbImageView) this.gxV.findViewById(d.h.home_write_live_icon);
            this.gyd = (TextView) this.gxV.findViewById(d.h.home_write_live_title);
            this.gye = (TbImageView) this.gxV.findViewById(d.h.home_write_url_icon);
            this.gyf = (TextView) this.gxV.findViewById(d.h.home_write_url_title);
            this.gyg = (TbImageView) this.gxV.findViewById(d.h.write_switch);
            this.gyh = (GridLayout) this.gxV.findViewById(d.h.type_container);
            this.gyh.setMeasureAllChild(true);
            this.gyh.setVerNum(2);
            this.gyo = XiaoyingUtil.showXiaoyingTool();
            a(this.gyh, this.gyo);
            boolean fS = ad.fS();
            b(this.gyh, fS);
            this.gxV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.d(b.this.gyh, b.this.gyg);
                }
            });
            this.gxV.findViewById(d.h.home_write_live).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.d(b.this.gyh, b.this.gyg);
                    MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                    String str = "0";
                    String str2 = null;
                    if (b.this.gyk != null) {
                        str = b.this.gyk.forumId;
                        str2 = b.this.gyk.forumName;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, new AlaLiveRoomActivityConfig(TbadkCoreApplication.getInst().getApplicationContext(), str2, str, TbadkCoreApplication.getCurrentAccount(), true, false)));
                }
            });
            this.gxV.findViewById(d.h.home_write_photo).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    int i;
                    b.this.d(b.this.gyh, b.this.gyg);
                    String str2 = "0";
                    String str3 = null;
                    PostPrefixData postPrefixData = null;
                    AntiData antiData = null;
                    if (b.this.gyk != null) {
                        str2 = b.this.gyk.forumId;
                        str3 = b.this.gyk.forumName;
                        postPrefixData = b.this.gyk.prefixData;
                        antiData = b.this.gyk.antiData;
                        int i2 = b.this.gyk.forumLevel;
                        str = b.this.gyk.avatar;
                        i = i2;
                    } else {
                        str = null;
                        i = -1;
                    }
                    TiebaStatic.log(new aj("c12373").aa("obj_locate", b.this.gyl).aa("fid", str2));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(b.this.aaS.getPageActivity(), 0, str2, str3, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.setCallFrom(b.this.gyl);
                    writeActivityConfig.setForumLevel(i);
                    writeActivityConfig.setForumAvatar(str);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            });
            this.gxV.findViewById(d.h.home_write_article).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    int i;
                    b.this.d(b.this.gyh, b.this.gyg);
                    String str2 = "0";
                    String str3 = null;
                    PostPrefixData postPrefixData = null;
                    AntiData antiData = null;
                    if (b.this.gyk != null) {
                        str2 = b.this.gyk.forumId;
                        str3 = b.this.gyk.forumName;
                        postPrefixData = b.this.gyk.prefixData;
                        antiData = b.this.gyk.antiData;
                        int i2 = b.this.gyk.forumLevel;
                        str = b.this.gyk.avatar;
                        i = i2;
                    } else {
                        str = null;
                        i = -1;
                    }
                    TiebaStatic.log(new aj("c12372").aa("obj_locate", b.this.gyl).aa("fid", str2));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(b.this.aaS.getPageActivity(), 9, str2, str3, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.setCallFrom(b.this.gyl);
                    writeActivityConfig.setForumLevel(i);
                    writeActivityConfig.setForumAvatar(str);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            });
            if (fS) {
                this.gxV.findViewById(d.h.home_write_url).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        b.this.d(b.this.gyh, b.this.gyg);
                        String str = "0";
                        String str2 = null;
                        if (b.this.gyk != null) {
                            str = b.this.gyk.forumId;
                            str2 = b.this.gyk.forumName;
                        }
                        WriteUrlActivityConfig writeUrlActivityConfig = new WriteUrlActivityConfig(b.this.aaS.getPageActivity(), str, str2, b.this.gyl);
                        writeUrlActivityConfig.setRequestCode(13003);
                        writeUrlActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeUrlActivityConfig));
                        TiebaStatic.log(new aj("c12162").aa("obj_locate", b.this.gyl));
                    }
                });
            }
            if (this.gyo) {
                this.gxV.findViewById(d.h.home_write_video).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        b.this.d(b.this.gyh, b.this.gyg);
                        String str = "0";
                        String str2 = null;
                        if (b.this.gyk != null) {
                            str = b.this.gyk.forumId;
                            str2 = b.this.gyk.forumName;
                        }
                        e.c(b.this.aaS, str, str2);
                    }
                });
            }
            onChangeSkinType();
            if (fS) {
                bxu();
            }
        }
    }

    public void bxu() {
        if (!this.gym && this.gxV != null) {
            this.gym = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_write_url_tips", false);
            if (!this.gym) {
                View inflate = LayoutInflater.from(this.aaS.getContext()).inflate(d.j.tips_blue_right_up, (ViewGroup) null);
                View findViewById = inflate.findViewById(d.h.arrow_up);
                TextView textView = (TextView) inflate.findViewById(d.h.tips);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                if (this.gyo) {
                    layoutParams.rightMargin = k.g(this.aaS.getContext(), d.f.ds120);
                } else {
                    layoutParams.gravity = 3;
                    layoutParams.leftMargin = k.g(this.aaS.getContext(), d.f.ds10);
                }
                textView.setText(d.l.write_url_tips);
                textView.setOnClickListener(this.glo);
                this.gyn = new PopupWindow(inflate, -2, -2);
                this.gxV.removeCallbacks(this.glm);
                this.gxV.postDelayed(this.glm, 400L);
            }
        }
    }

    public void bxv() {
        if (this.gxV != null) {
            this.gxV.removeCallbacks(this.glm);
            this.gxV.removeCallbacks(this.gln);
        }
        bum();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bum() {
        g.a(this.gyn);
    }

    private void a(GridLayout gridLayout, boolean z) {
        if (!z) {
            gridLayout.findViewById(d.h.home_write_video).setVisibility(8);
            if (gridLayout.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) gridLayout.getLayoutParams()).bottomMargin = k.g(this.aaS.getPageActivity(), d.f.ds60);
            }
        }
    }

    private void b(GridLayout gridLayout, boolean z) {
        if (!z) {
            gridLayout.findViewById(d.h.home_write_url).setVisibility(8);
            if (gridLayout.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) gridLayout.getLayoutParams()).bottomMargin = k.g(this.aaS.getPageActivity(), d.f.ds60);
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
            if (b.this.gxV.getParent() == b.this.aan) {
                b.this.aan.removeView(b.this.gxV);
            }
            b.this.gyj = false;
        }
    }

    public void mY(boolean z) {
        if (!this.gyj && this.aan != null) {
            this.gyj = true;
            if (this.gxV.getParent() == null) {
                com.baidu.tbadk.k.d.K(this.aan).a(this.aan, this.gxV, z);
            }
            com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.b.2
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(b.this.aaS.getPageActivity(), d.a.home_write_bgin);
                    loadAnimation.setFillAfter(true);
                    b.this.gyh.setVisibility(0);
                    b.this.gyh.startAnimation(loadAnimation);
                    b.this.gyg.setVisibility(0);
                    b.this.gyg.startAnimation(AnimationUtils.loadAnimation(b.this.aaS.getPageActivity(), d.a.write_thread_anim));
                }
            }, 100L);
            TiebaStatic.log(new aj("c12052").aa("obj_locate", this.gyl));
        }
    }

    public void bxw() {
        d(this.gyh, this.gyg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(View view, View view2) {
        bxv();
        if (this.gyi != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.gyi);
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.aaS.getPageActivity(), d.a.home_write_bgout);
        loadAnimation.setFillAfter(true);
        view.startAnimation(loadAnimation);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.aaS.getPageActivity(), d.a.home_write_out);
        loadAnimation2.setFillAfter(true);
        view2.startAnimation(loadAnimation2);
        this.gyi = new a(view);
        com.baidu.adp.lib.g.e.fP().postDelayed(this.gyi, 300L);
    }

    public void onChangeSkinType() {
        ai.k(this.gxV, d.e.cp_bg_line_d);
        ai.c(this.gxW, d.g.icon_posts_photo_n);
        ai.c(this.gxY, d.g.icon_posts_article_n);
        ai.c(this.gya, d.g.icon_posts_video_n);
        ai.c(this.gyc, d.g.icon_posts_live_n);
        ai.c(this.gyg, d.g.home_write_s);
        ai.c(this.gye, d.g.icon_posts_url_n);
        ai.i(this.gxX, d.e.cp_cont_f);
        ai.i(this.gxZ, d.e.cp_cont_f);
        ai.i(this.gyb, d.e.cp_cont_f);
        ai.i(this.gyd, d.e.cp_cont_f);
        ai.i(this.gyf, d.e.cp_cont_f);
    }

    public void onDestroy() {
        bxv();
        if (this.gxV != null && this.gxV.getParent() == this.aan) {
            this.aan.removeView(this.gxV);
        }
        if (this.gyi != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.gyi);
            this.gyi = null;
        }
    }

    public boolean isShowing() {
        return this.gyj;
    }
}
