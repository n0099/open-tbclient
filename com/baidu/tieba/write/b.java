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
    private ViewGroup abK;
    private TbPageContext acp;
    private View gzg;
    private TbImageView gzh;
    private TextView gzi;
    private TbImageView gzj;
    private TextView gzk;
    private TbImageView gzl;
    private TextView gzm;
    private TbImageView gzn;
    private TextView gzo;
    private TbImageView gzp;
    private TextView gzq;
    private TbImageView gzr;
    private GridLayout gzs;
    private a gzt;
    private ForumWriteData gzv;
    private String gzw;
    private PopupWindow gzy;
    private boolean gzz;
    private boolean gzu = false;
    private boolean gzx = false;
    private View.OnClickListener gmz = new View.OnClickListener() { // from class: com.baidu.tieba.write.b.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.bxC();
        }
    };
    private Runnable gmy = new Runnable() { // from class: com.baidu.tieba.write.b.9
        @Override // java.lang.Runnable
        public void run() {
            b.this.but();
        }
    };
    private Runnable gmx = new Runnable() { // from class: com.baidu.tieba.write.b.10
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.gzq != null && b.this.gzg != null) {
                g.showPopupWindowAsDropDown(b.this.gzy, b.this.gzq);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_write_url_tips", true);
                b.this.gzx = true;
                b.this.gzg.postDelayed(b.this.gmy, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    };

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.acp = tbPageContext;
        this.abK = viewGroup;
        initView();
    }

    public void a(ForumWriteData forumWriteData) {
        this.gzv = forumWriteData;
    }

    public void sP(String str) {
        this.gzw = str;
    }

    private void initView() {
        if (this.acp != null && this.acp.getPageActivity() != null && this.abK != null) {
            this.gzg = LayoutInflater.from(this.acp.getPageActivity()).inflate(d.j.bottom_write_thread, (ViewGroup) null);
            this.gzj = (TbImageView) this.gzg.findViewById(d.h.home_write_article_icon);
            this.gzk = (TextView) this.gzg.findViewById(d.h.home_write_article_title);
            this.gzh = (TbImageView) this.gzg.findViewById(d.h.home_write_photo_icon);
            this.gzi = (TextView) this.gzg.findViewById(d.h.home_write_photo_title);
            this.gzl = (TbImageView) this.gzg.findViewById(d.h.home_write_video_icon);
            this.gzm = (TextView) this.gzg.findViewById(d.h.home_write_video_title);
            this.gzn = (TbImageView) this.gzg.findViewById(d.h.home_write_live_icon);
            this.gzo = (TextView) this.gzg.findViewById(d.h.home_write_live_title);
            this.gzp = (TbImageView) this.gzg.findViewById(d.h.home_write_url_icon);
            this.gzq = (TextView) this.gzg.findViewById(d.h.home_write_url_title);
            this.gzr = (TbImageView) this.gzg.findViewById(d.h.write_switch);
            this.gzs = (GridLayout) this.gzg.findViewById(d.h.type_container);
            this.gzs.setMeasureAllChild(true);
            this.gzs.setVerNum(2);
            this.gzz = XiaoyingUtil.showXiaoyingTool();
            a(this.gzs, this.gzz);
            boolean ge = ad.ge();
            b(this.gzs, ge);
            this.gzg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.d(b.this.gzs, b.this.gzr);
                }
            });
            this.gzg.findViewById(d.h.home_write_live).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.d(b.this.gzs, b.this.gzr);
                    MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                    String str = "0";
                    String str2 = null;
                    if (b.this.gzv != null) {
                        str = b.this.gzv.forumId;
                        str2 = b.this.gzv.forumName;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, new AlaLiveRoomActivityConfig(TbadkCoreApplication.getInst().getApplicationContext(), str2, str, TbadkCoreApplication.getCurrentAccount(), true, false)));
                }
            });
            this.gzg.findViewById(d.h.home_write_photo).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    int i;
                    b.this.d(b.this.gzs, b.this.gzr);
                    String str2 = "0";
                    String str3 = null;
                    PostPrefixData postPrefixData = null;
                    AntiData antiData = null;
                    if (b.this.gzv != null) {
                        str2 = b.this.gzv.forumId;
                        str3 = b.this.gzv.forumName;
                        postPrefixData = b.this.gzv.prefixData;
                        antiData = b.this.gzv.antiData;
                        int i2 = b.this.gzv.forumLevel;
                        str = b.this.gzv.avatar;
                        i = i2;
                    } else {
                        str = null;
                        i = -1;
                    }
                    TiebaStatic.log(new aj("c12373").aa("obj_locate", b.this.gzw).aa("fid", str2));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(b.this.acp.getPageActivity(), 0, str2, str3, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.setCallFrom(b.this.gzw);
                    writeActivityConfig.setForumLevel(i);
                    writeActivityConfig.setForumAvatar(str);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            });
            this.gzg.findViewById(d.h.home_write_article).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    int i;
                    b.this.d(b.this.gzs, b.this.gzr);
                    String str2 = "0";
                    String str3 = null;
                    PostPrefixData postPrefixData = null;
                    AntiData antiData = null;
                    if (b.this.gzv != null) {
                        str2 = b.this.gzv.forumId;
                        str3 = b.this.gzv.forumName;
                        postPrefixData = b.this.gzv.prefixData;
                        antiData = b.this.gzv.antiData;
                        int i2 = b.this.gzv.forumLevel;
                        str = b.this.gzv.avatar;
                        i = i2;
                    } else {
                        str = null;
                        i = -1;
                    }
                    TiebaStatic.log(new aj("c12372").aa("obj_locate", b.this.gzw).aa("fid", str2));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(b.this.acp.getPageActivity(), 9, str2, str3, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.setCallFrom(b.this.gzw);
                    writeActivityConfig.setForumLevel(i);
                    writeActivityConfig.setForumAvatar(str);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            });
            if (ge) {
                this.gzg.findViewById(d.h.home_write_url).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        b.this.d(b.this.gzs, b.this.gzr);
                        String str = "0";
                        String str2 = null;
                        if (b.this.gzv != null) {
                            str = b.this.gzv.forumId;
                            str2 = b.this.gzv.forumName;
                        }
                        WriteUrlActivityConfig writeUrlActivityConfig = new WriteUrlActivityConfig(b.this.acp.getPageActivity(), str, str2, b.this.gzw);
                        writeUrlActivityConfig.setRequestCode(13003);
                        writeUrlActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeUrlActivityConfig));
                        TiebaStatic.log(new aj("c12162").aa("obj_locate", b.this.gzw));
                    }
                });
            }
            if (this.gzz) {
                this.gzg.findViewById(d.h.home_write_video).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        b.this.d(b.this.gzs, b.this.gzr);
                        String str = "0";
                        String str2 = null;
                        if (b.this.gzv != null) {
                            str = b.this.gzv.forumId;
                            str2 = b.this.gzv.forumName;
                        }
                        e.c(b.this.acp, str, str2);
                    }
                });
            }
            onChangeSkinType();
            if (ge) {
                bxB();
            }
        }
    }

    public void bxB() {
        if (!this.gzx && this.gzg != null) {
            this.gzx = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_write_url_tips", false);
            if (!this.gzx) {
                View inflate = LayoutInflater.from(this.acp.getContext()).inflate(d.j.tips_blue_right_up, (ViewGroup) null);
                View findViewById = inflate.findViewById(d.h.arrow_up);
                TextView textView = (TextView) inflate.findViewById(d.h.tips);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                if (this.gzz) {
                    layoutParams.rightMargin = k.g(this.acp.getContext(), d.f.ds120);
                } else {
                    layoutParams.gravity = 3;
                    layoutParams.leftMargin = k.g(this.acp.getContext(), d.f.ds10);
                }
                textView.setText(d.l.write_url_tips);
                textView.setOnClickListener(this.gmz);
                this.gzy = new PopupWindow(inflate, -2, -2);
                this.gzg.removeCallbacks(this.gmx);
                this.gzg.postDelayed(this.gmx, 400L);
            }
        }
    }

    public void bxC() {
        if (this.gzg != null) {
            this.gzg.removeCallbacks(this.gmx);
            this.gzg.removeCallbacks(this.gmy);
        }
        but();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void but() {
        g.a(this.gzy);
    }

    private void a(GridLayout gridLayout, boolean z) {
        if (!z) {
            gridLayout.findViewById(d.h.home_write_video).setVisibility(8);
            if (gridLayout.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) gridLayout.getLayoutParams()).bottomMargin = k.g(this.acp.getPageActivity(), d.f.ds60);
            }
        }
    }

    private void b(GridLayout gridLayout, boolean z) {
        if (!z) {
            gridLayout.findViewById(d.h.home_write_url).setVisibility(8);
            if (gridLayout.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) gridLayout.getLayoutParams()).bottomMargin = k.g(this.acp.getPageActivity(), d.f.ds60);
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
            if (b.this.gzg.getParent() == b.this.abK) {
                b.this.abK.removeView(b.this.gzg);
            }
            b.this.gzu = false;
        }
    }

    public void mY(boolean z) {
        if (!this.gzu && this.abK != null) {
            this.gzu = true;
            if (this.gzg.getParent() == null) {
                com.baidu.tbadk.k.d.K(this.abK).a(this.abK, this.gzg, z);
            }
            com.baidu.adp.lib.g.e.ga().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.b.2
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(b.this.acp.getPageActivity(), d.a.home_write_bgin);
                    loadAnimation.setFillAfter(true);
                    b.this.gzs.setVisibility(0);
                    b.this.gzs.startAnimation(loadAnimation);
                    b.this.gzr.setVisibility(0);
                    b.this.gzr.startAnimation(AnimationUtils.loadAnimation(b.this.acp.getPageActivity(), d.a.write_thread_anim));
                }
            }, 100L);
            TiebaStatic.log(new aj("c12052").aa("obj_locate", this.gzw));
        }
    }

    public void bxD() {
        d(this.gzs, this.gzr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(View view, View view2) {
        bxC();
        if (this.gzt != null) {
            com.baidu.adp.lib.g.e.ga().removeCallbacks(this.gzt);
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.acp.getPageActivity(), d.a.home_write_bgout);
        loadAnimation.setFillAfter(true);
        view.startAnimation(loadAnimation);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.acp.getPageActivity(), d.a.home_write_out);
        loadAnimation2.setFillAfter(true);
        view2.startAnimation(loadAnimation2);
        this.gzt = new a(view);
        com.baidu.adp.lib.g.e.ga().postDelayed(this.gzt, 300L);
    }

    public void onChangeSkinType() {
        ai.k(this.gzg, d.e.cp_bg_line_d);
        ai.c(this.gzh, d.g.icon_posts_photo_n);
        ai.c(this.gzj, d.g.icon_posts_article_n);
        ai.c(this.gzl, d.g.icon_posts_video_n);
        ai.c(this.gzn, d.g.icon_posts_live_n);
        ai.c(this.gzr, d.g.home_write_s);
        ai.c(this.gzp, d.g.icon_posts_url_n);
        ai.i(this.gzi, d.e.cp_cont_f);
        ai.i(this.gzk, d.e.cp_cont_f);
        ai.i(this.gzm, d.e.cp_cont_f);
        ai.i(this.gzo, d.e.cp_cont_f);
        ai.i(this.gzq, d.e.cp_cont_f);
    }

    public void onDestroy() {
        bxC();
        if (this.gzg != null && this.gzg.getParent() == this.abK) {
            this.abK.removeView(this.gzg);
        }
        if (this.gzt != null) {
            com.baidu.adp.lib.g.e.ga().removeCallbacks(this.gzt);
            this.gzt = null;
        }
    }

    public boolean isShowing() {
        return this.gzu;
    }
}
