package com.baidu.tieba.write;

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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
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
    private TbPageContext aQp;
    private View hBN;
    private View hBO;
    private LinearLayout hBP;
    private TbImageView hBQ;
    private TextView hBR;
    private LinearLayout hBS;
    private TbImageView hBT;
    private TextView hBU;
    private LinearLayout hBV;
    private TbImageView hBW;
    private TextView hBX;
    private LinearLayout hBY;
    private TbImageView hBZ;
    private TextView hCa;
    private ImageView hCb;
    private GridLayout hCc;
    private a hCd;
    private Animation hCi;
    private Animation hCj;
    private Animation hCk;
    private Animation hCl;
    private ForumWriteData hvk;
    private String mFrom;
    private ViewGroup mRootView;
    private String writeCallFrom;
    private boolean hCe = false;
    private int hCf = 0;
    private boolean hCg = true;
    private boolean hCh = true;
    private ArrayList<View> fEZ = new ArrayList<>();
    private String hCm = "0";

    static /* synthetic */ int q(c cVar) {
        int i = cVar.hCf;
        cVar.hCf = i + 1;
        return i;
    }

    static /* synthetic */ int s(c cVar) {
        int i = cVar.hCf;
        cVar.hCf = i - 1;
        return i;
    }

    public c(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this.mFrom = AlbumActivityConfig.FROM_WRITE;
        this.aQp = tbPageContext;
        this.mRootView = viewGroup;
        this.mFrom = str;
        initView();
    }

    public void a(ForumWriteData forumWriteData) {
        this.hvk = forumWriteData;
    }

    public void ua(String str) {
        if ("3".equals(str)) {
            this.writeCallFrom = "1";
        } else {
            this.writeCallFrom = str;
        }
        this.hCm = str;
    }

    private void initView() {
        if (this.aQp != null && this.aQp.getPageActivity() != null && this.mRootView != null) {
            this.hBO = LayoutInflater.from(this.aQp.getPageActivity()).inflate(d.h.bottom_write_thread, (ViewGroup) null);
            this.hBS = (LinearLayout) this.hBO.findViewById(d.g.home_write_article);
            this.hBT = (TbImageView) this.hBO.findViewById(d.g.home_write_article_icon);
            this.hBU = (TextView) this.hBO.findViewById(d.g.home_write_article_title);
            this.hBP = (LinearLayout) this.hBO.findViewById(d.g.home_write_photo);
            this.hBQ = (TbImageView) this.hBO.findViewById(d.g.home_write_photo_icon);
            this.hBR = (TextView) this.hBO.findViewById(d.g.home_write_photo_title);
            this.hBV = (LinearLayout) this.hBO.findViewById(d.g.home_write_album);
            this.hBW = (TbImageView) this.hBO.findViewById(d.g.home_write_album_icon);
            this.hBX = (TextView) this.hBO.findViewById(d.g.home_write_album_title);
            this.hBY = (LinearLayout) this.hBO.findViewById(d.g.home_write_live);
            this.hBZ = (TbImageView) this.hBO.findViewById(d.g.home_write_live_icon);
            this.hCa = (TextView) this.hBO.findViewById(d.g.home_write_live_title);
            this.hCb = (ImageView) this.hBO.findViewById(d.g.write_close_view);
            this.hBN = this.hBO.findViewById(d.g.view_background);
            this.hCc = (GridLayout) this.hBO.findViewById(d.g.type_container);
            this.hCc.setMeasureAllChild(true);
            this.hCc.setVerNum(1);
            bER();
            this.fEZ.add(this.hBS);
            this.fEZ.add(this.hBP);
            this.fEZ.add(this.hBV);
            this.fEZ.add(this.hBY);
            this.hBO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.cW(c.this.hCc);
                }
            });
            this.hBT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i;
                    String str;
                    int i2;
                    c.this.bEU();
                    String str2 = "0";
                    String str3 = null;
                    PostPrefixData postPrefixData = null;
                    AntiData antiData = null;
                    if (c.this.hvk != null) {
                        str2 = c.this.hvk.forumId;
                        str3 = c.this.hvk.forumName;
                        postPrefixData = c.this.hvk.prefixData;
                        antiData = c.this.hvk.antiData;
                        int i3 = c.this.hvk.forumLevel;
                        String str4 = c.this.hvk.avatar;
                        i = c.this.hvk.privateThread;
                        str = str4;
                        i2 = i3;
                    } else {
                        i = 0;
                        str = null;
                        i2 = -1;
                    }
                    TiebaStatic.log(new ak("c12611").ab("obj_locate", c.this.hCm).s("obj_type", 1));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.aQp.getPageActivity(), 9, str2, str3, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", c.this.mFrom);
                    writeActivityConfig.setCallFrom(c.this.writeCallFrom);
                    writeActivityConfig.setForumLevel(i2);
                    writeActivityConfig.setForumAvatar(str);
                    writeActivityConfig.setPrivateThread(i);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            });
            this.hBQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.bEU();
                    TiebaStatic.log(new ak("c12611").ab("obj_locate", c.this.hCm).s("obj_type", 2));
                    if (c.this.hvk == null) {
                        c.this.hvk = new ForumWriteData("0", null, null, null);
                    }
                    c.this.hvk.mFrom = c.this.mFrom;
                    c.this.hvk.writeCallFrom = c.this.writeCallFrom;
                    f.a(c.this.aQp, "", c.this.hvk);
                }
            });
            this.hBW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i;
                    String str;
                    int i2;
                    c.this.bEU();
                    String str2 = "0";
                    String str3 = null;
                    PostPrefixData postPrefixData = null;
                    AntiData antiData = null;
                    if (c.this.hvk != null) {
                        str2 = c.this.hvk.forumId;
                        str3 = c.this.hvk.forumName;
                        postPrefixData = c.this.hvk.prefixData;
                        antiData = c.this.hvk.antiData;
                        int i3 = c.this.hvk.forumLevel;
                        String str4 = c.this.hvk.avatar;
                        i = c.this.hvk.privateThread;
                        str = str4;
                        i2 = i3;
                    } else {
                        i = 0;
                        str = null;
                        i2 = -1;
                    }
                    TiebaStatic.log(new ak("c12611").ab("obj_locate", c.this.hCm).s("obj_type", 3));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.aQp.getPageActivity(), 0, str2, str3, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", c.this.mFrom);
                    writeActivityConfig.setCallFrom(c.this.writeCallFrom);
                    writeActivityConfig.setForumLevel(i2);
                    writeActivityConfig.setForumAvatar(str);
                    writeActivityConfig.setAlbumThread(1);
                    writeActivityConfig.setPrivateThread(i);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            });
            this.hBZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.bEU();
                    MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                    String str = "0";
                    String str2 = null;
                    TiebaStatic.log(new ak("c12611").ab("obj_locate", c.this.hCm).s("obj_type", 4));
                    com.baidu.adp.lib.d.a.mF().aj(false);
                    if (c.this.hvk != null) {
                        str = c.this.hvk.forumId;
                        str2 = c.this.hvk.forumName;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaMasterLiveRoomActivityConfig(TbadkCoreApplication.getInst().getApplicationContext(), str2, str, TbadkCoreApplication.getCurrentAccount(), false)));
                }
            });
            onChangeSkinType();
            this.hCi = AnimationUtils.loadAnimation(this.aQp.getPageActivity(), d.a.write_thread_black_anim);
            this.hCi.setFillAfter(true);
            this.hCj = AnimationUtils.loadAnimation(this.aQp.getPageActivity(), d.a.write_thread_black_hide_anim);
            this.hCj.setFillAfter(true);
            this.hCk = AnimationUtils.loadAnimation(this.aQp.getPageActivity(), d.a.write_tab_bg_anim);
            this.hCk.setFillAfter(true);
            this.hCl = AnimationUtils.loadAnimation(this.aQp.getPageActivity(), d.a.home_write_bgout);
            this.hCl.setFillAfter(true);
        }
    }

    private void bER() {
        int ao = (int) (0.15555556f * l.ao(this.aQp.getPageActivity()));
        a(this.hBT, ao);
        a(this.hBQ, ao);
        a(this.hBW, ao);
        a(this.hBZ, ao);
        int aq = l.aq(this.aQp.getPageActivity());
        ViewGroup.LayoutParams layoutParams = this.hCc.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = aq / 5;
            this.hCc.setLayoutParams(layoutParams);
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
            c.this.hBS.setVisibility(4);
            c.this.hBP.setVisibility(4);
            c.this.hBV.setVisibility(4);
            c.this.hBY.setVisibility(4);
            c.this.hCb.setVisibility(4);
            c.this.hBN.setVisibility(4);
            if (this.mView != null) {
                this.mView.setVisibility(8);
            }
            if (c.this.hBO.getParent() == c.this.mRootView) {
                c.this.mRootView.removeView(c.this.hBO);
            }
            c.this.hCe = false;
        }
    }

    public void ns(boolean z) {
        if (!this.hCe && this.hCg && this.hCh && this.mRootView != null) {
            this.hCb.clearAnimation();
            this.hCe = true;
            if (this.hBO.getParent() == null) {
                com.baidu.tbadk.j.d.bl(this.mRootView).a(this.mRootView, this.hBO, z);
            }
            this.hCc.setVisibility(0);
            this.hBN.setVisibility(0);
            this.hBN.clearAnimation();
            this.hBN.startAnimation(this.hCk);
            this.hCb.setVisibility(0);
            this.hCb.startAnimation(this.hCi);
            bES();
            TiebaStatic.log(new ak("c12052").ab("obj_locate", this.hCm));
        }
    }

    private void bES() {
        clearAnimation();
        final int size = this.fEZ.size();
        this.hCg = false;
        this.hCf = 0;
        for (int i = 0; i < size; i++) {
            final View view = this.fEZ.get(i);
            com.baidu.adp.lib.g.e.nr().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.c.6
                @Override // java.lang.Runnable
                public void run() {
                    view.setVisibility(0);
                    Animation loadAnimation = AnimationUtils.loadAnimation(c.this.aQp.getPageActivity(), d.a.write_tab_icon_show_anim);
                    loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.c.6.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            c.q(c.this);
                            if (c.this.hCf == size) {
                                c.this.hCg = true;
                                c.this.hCf = 0;
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

    public void bET() {
        cW(this.hCc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cW(View view) {
        if (this.hCg && this.hCh) {
            if (this.hCd != null) {
                com.baidu.adp.lib.g.e.nr().removeCallbacks(this.hCd);
            }
            this.hBN.clearAnimation();
            this.hBN.startAnimation(this.hCl);
            this.hCb.clearAnimation();
            this.hCb.startAnimation(this.hCj);
            bEV();
            this.hCd = new a(view);
            com.baidu.adp.lib.g.e.nr().postDelayed(this.hCd, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEU() {
        this.hCg = true;
        this.hCh = true;
        if (this.hCd != null) {
            com.baidu.adp.lib.g.e.nr().removeCallbacks(this.hCd);
        }
        if (this.hCd == null) {
            this.hCd = new a(this.hCc);
        }
        com.baidu.adp.lib.g.e.nr().postDelayed(this.hCd, 500L);
    }

    private void bEV() {
        clearAnimation();
        int size = this.fEZ.size();
        this.hCf = size;
        this.hCh = false;
        int i = size - 1;
        for (int i2 = 0; i2 < size; i2++) {
            final View view = this.fEZ.get(i);
            i--;
            com.baidu.adp.lib.g.e.nr().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.c.7
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(c.this.aQp.getPageActivity(), d.a.write_tab_icon_hide_anim);
                    loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.c.7.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            view.setVisibility(4);
                            if (c.this.hCf == 1) {
                                c.this.hCh = true;
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
        this.hBS.clearAnimation();
        this.hBP.clearAnimation();
        this.hBY.clearAnimation();
        this.hBV.clearAnimation();
    }

    public void onChangeSkinType() {
        aj.t(this.hBN, d.C0107d.cp_bg_line_d_alpha98);
        aj.c(this.hBQ, d.f.icon_post_type_photograph_n);
        aj.c(this.hBT, d.f.icon_post_type_text_n);
        aj.c(this.hBW, d.f.icon_post_type_image_n);
        aj.c(this.hBZ, d.f.icon_post_type_live_n);
        aj.c(this.hCb, d.f.icon_tabbar_add_s);
        aj.r(this.hBR, d.C0107d.cp_cont_b);
        aj.r(this.hBU, d.C0107d.cp_cont_b);
        aj.r(this.hBX, d.C0107d.cp_cont_b);
        aj.r(this.hCa, d.C0107d.cp_cont_b);
    }

    public void onDestroy() {
        if (this.hBO != null && this.hBO.getParent() == this.mRootView) {
            this.mRootView.removeView(this.hBO);
        }
        if (this.hCd != null) {
            com.baidu.adp.lib.g.e.nr().removeCallbacks(this.hCd);
            this.hCd = null;
        }
        this.fEZ.clear();
    }

    public boolean isShowing() {
        return this.hCe;
    }
}
