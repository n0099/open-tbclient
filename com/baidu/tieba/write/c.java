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
    private TbPageContext aRI;
    private View hDP;
    private View hDQ;
    private LinearLayout hDR;
    private TbImageView hDS;
    private TextView hDT;
    private LinearLayout hDU;
    private TbImageView hDV;
    private TextView hDW;
    private LinearLayout hDX;
    private TbImageView hDY;
    private TextView hDZ;
    private LinearLayout hEa;
    private TbImageView hEb;
    private TextView hEc;
    private ImageView hEd;
    private GridLayout hEe;
    private a hEf;
    private Animation hEk;
    private Animation hEl;
    private Animation hEm;
    private Animation hEn;
    private ForumWriteData hxd;
    private String mFrom;
    private ViewGroup mRootView;
    private String writeCallFrom;
    private boolean hEg = false;
    private int hEh = 0;
    private boolean hEi = true;
    private boolean hEj = true;
    private ArrayList<View> fIW = new ArrayList<>();
    private String hEo = "0";

    static /* synthetic */ int q(c cVar) {
        int i = cVar.hEh;
        cVar.hEh = i + 1;
        return i;
    }

    static /* synthetic */ int s(c cVar) {
        int i = cVar.hEh;
        cVar.hEh = i - 1;
        return i;
    }

    public c(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this.mFrom = AlbumActivityConfig.FROM_WRITE;
        this.aRI = tbPageContext;
        this.mRootView = viewGroup;
        this.mFrom = str;
        initView();
    }

    public void a(ForumWriteData forumWriteData) {
        this.hxd = forumWriteData;
    }

    public void uo(String str) {
        if ("3".equals(str)) {
            this.writeCallFrom = "1";
        } else {
            this.writeCallFrom = str;
        }
        this.hEo = str;
    }

    private void initView() {
        if (this.aRI != null && this.aRI.getPageActivity() != null && this.mRootView != null) {
            this.hDQ = LayoutInflater.from(this.aRI.getPageActivity()).inflate(d.h.bottom_write_thread, (ViewGroup) null);
            this.hDU = (LinearLayout) this.hDQ.findViewById(d.g.home_write_article);
            this.hDV = (TbImageView) this.hDQ.findViewById(d.g.home_write_article_icon);
            this.hDW = (TextView) this.hDQ.findViewById(d.g.home_write_article_title);
            this.hDR = (LinearLayout) this.hDQ.findViewById(d.g.home_write_photo);
            this.hDS = (TbImageView) this.hDQ.findViewById(d.g.home_write_photo_icon);
            this.hDT = (TextView) this.hDQ.findViewById(d.g.home_write_photo_title);
            this.hDX = (LinearLayout) this.hDQ.findViewById(d.g.home_write_album);
            this.hDY = (TbImageView) this.hDQ.findViewById(d.g.home_write_album_icon);
            this.hDZ = (TextView) this.hDQ.findViewById(d.g.home_write_album_title);
            this.hEa = (LinearLayout) this.hDQ.findViewById(d.g.home_write_live);
            this.hEb = (TbImageView) this.hDQ.findViewById(d.g.home_write_live_icon);
            this.hEc = (TextView) this.hDQ.findViewById(d.g.home_write_live_title);
            this.hEd = (ImageView) this.hDQ.findViewById(d.g.write_close_view);
            this.hDP = this.hDQ.findViewById(d.g.view_background);
            this.hEe = (GridLayout) this.hDQ.findViewById(d.g.type_container);
            this.hEe.setMeasureAllChild(true);
            this.hEe.setVerNum(1);
            bFL();
            this.fIW.add(this.hDU);
            this.fIW.add(this.hDR);
            this.fIW.add(this.hDX);
            this.fIW.add(this.hEa);
            this.hDQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.cV(c.this.hEe);
                }
            });
            this.hDV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i;
                    String str;
                    int i2;
                    c.this.bFO();
                    String str2 = "0";
                    String str3 = null;
                    PostPrefixData postPrefixData = null;
                    AntiData antiData = null;
                    if (c.this.hxd != null) {
                        str2 = c.this.hxd.forumId;
                        str3 = c.this.hxd.forumName;
                        postPrefixData = c.this.hxd.prefixData;
                        antiData = c.this.hxd.antiData;
                        int i3 = c.this.hxd.forumLevel;
                        String str4 = c.this.hxd.avatar;
                        i = c.this.hxd.privateThread;
                        str = str4;
                        i2 = i3;
                    } else {
                        i = 0;
                        str = null;
                        i2 = -1;
                    }
                    TiebaStatic.log(new ak("c12611").ab("obj_locate", c.this.hEo).s("obj_type", 1));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.aRI.getPageActivity(), 9, str2, str3, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", c.this.mFrom);
                    writeActivityConfig.setCallFrom(c.this.writeCallFrom);
                    writeActivityConfig.setForumLevel(i2);
                    writeActivityConfig.setForumAvatar(str);
                    writeActivityConfig.setPrivateThread(i);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                }
            });
            this.hDS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.bFO();
                    TiebaStatic.log(new ak("c12611").ab("obj_locate", c.this.hEo).s("obj_type", 2));
                    if (c.this.hxd == null) {
                        c.this.hxd = new ForumWriteData("0", null, null, null);
                    }
                    c.this.hxd.mFrom = c.this.mFrom;
                    c.this.hxd.writeCallFrom = c.this.writeCallFrom;
                    f.a(c.this.aRI, "", c.this.hxd);
                }
            });
            this.hDY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i;
                    String str;
                    int i2;
                    c.this.bFO();
                    String str2 = "0";
                    String str3 = null;
                    PostPrefixData postPrefixData = null;
                    AntiData antiData = null;
                    if (c.this.hxd != null) {
                        str2 = c.this.hxd.forumId;
                        str3 = c.this.hxd.forumName;
                        postPrefixData = c.this.hxd.prefixData;
                        antiData = c.this.hxd.antiData;
                        int i3 = c.this.hxd.forumLevel;
                        String str4 = c.this.hxd.avatar;
                        i = c.this.hxd.privateThread;
                        str = str4;
                        i2 = i3;
                    } else {
                        i = 0;
                        str = null;
                        i2 = -1;
                    }
                    TiebaStatic.log(new ak("c12611").ab("obj_locate", c.this.hEo).s("obj_type", 3));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.aRI.getPageActivity(), 0, str2, str3, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", c.this.mFrom);
                    writeActivityConfig.setCallFrom(c.this.writeCallFrom);
                    writeActivityConfig.setForumLevel(i2);
                    writeActivityConfig.setForumAvatar(str);
                    writeActivityConfig.setAlbumThread(1);
                    writeActivityConfig.setPrivateThread(i);
                    if (!c.F(c.this.aRI.getPageActivity())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                    }
                }
            });
            this.hEb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    String str2 = null;
                    c.this.bFO();
                    MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                    String str3 = "0";
                    TiebaStatic.log(new ak("c12611").ab("obj_locate", c.this.hEo).s("obj_type", 4));
                    com.baidu.adp.lib.d.a.mG().an(false);
                    if (c.this.hxd != null) {
                        str3 = c.this.hxd.forumId;
                        str = c.this.hxd.forumName;
                        str2 = c.this.hxd.specialForumType;
                    } else {
                        str = null;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(TbadkCoreApplication.getInst().getApplicationContext(), str, str3, TbadkCoreApplication.getCurrentAccount(), str2)));
                }
            });
            onChangeSkinType();
            this.hEk = AnimationUtils.loadAnimation(this.aRI.getPageActivity(), d.a.write_thread_black_anim);
            this.hEk.setFillAfter(true);
            this.hEl = AnimationUtils.loadAnimation(this.aRI.getPageActivity(), d.a.write_thread_black_hide_anim);
            this.hEl.setFillAfter(true);
            this.hEm = AnimationUtils.loadAnimation(this.aRI.getPageActivity(), d.a.write_tab_bg_anim);
            this.hEm.setFillAfter(true);
            this.hEn = AnimationUtils.loadAnimation(this.aRI.getPageActivity(), d.a.home_write_bgout);
            this.hEn.setFillAfter(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean F(Activity activity) {
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.DI();
        aVar.c(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return aVar.v(activity);
    }

    private void bFL() {
        int ao = (int) (0.15555556f * l.ao(this.aRI.getPageActivity()));
        a(this.hDV, ao);
        a(this.hDS, ao);
        a(this.hDY, ao);
        a(this.hEb, ao);
        int aq = l.aq(this.aRI.getPageActivity());
        ViewGroup.LayoutParams layoutParams = this.hEe.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = aq / 5;
            this.hEe.setLayoutParams(layoutParams);
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
            c.this.hDU.setVisibility(4);
            c.this.hDR.setVisibility(4);
            c.this.hDX.setVisibility(4);
            c.this.hEa.setVisibility(4);
            c.this.hEd.setVisibility(4);
            c.this.hDP.setVisibility(4);
            if (this.mView != null) {
                this.mView.setVisibility(8);
            }
            if (c.this.hDQ.getParent() == c.this.mRootView) {
                c.this.mRootView.removeView(c.this.hDQ);
            }
            c.this.hEg = false;
        }
    }

    public void nH(boolean z) {
        if (!this.hEg && this.hEi && this.hEj && this.mRootView != null) {
            this.hEd.clearAnimation();
            this.hEg = true;
            if (this.hDQ.getParent() == null) {
                com.baidu.tbadk.j.d.bl(this.mRootView).a(this.mRootView, this.hDQ, z);
            }
            this.hEe.setVisibility(0);
            this.hDP.setVisibility(0);
            this.hDP.clearAnimation();
            this.hDP.startAnimation(this.hEm);
            this.hEd.setVisibility(0);
            this.hEd.startAnimation(this.hEk);
            bFM();
            TiebaStatic.log(new ak("c12052").ab("obj_locate", this.hEo));
        }
    }

    private void bFM() {
        clearAnimation();
        final int size = this.fIW.size();
        this.hEi = false;
        this.hEh = 0;
        for (int i = 0; i < size; i++) {
            final View view = this.fIW.get(i);
            com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.c.6
                @Override // java.lang.Runnable
                public void run() {
                    view.setVisibility(0);
                    Animation loadAnimation = AnimationUtils.loadAnimation(c.this.aRI.getPageActivity(), d.a.write_tab_icon_show_anim);
                    loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.c.6.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            c.q(c.this);
                            if (c.this.hEh == size) {
                                c.this.hEi = true;
                                c.this.hEh = 0;
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

    public void bFN() {
        cV(this.hEe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cV(View view) {
        if (this.hEi && this.hEj) {
            if (this.hEf != null) {
                com.baidu.adp.lib.g.e.ns().removeCallbacks(this.hEf);
            }
            this.hDP.clearAnimation();
            this.hDP.startAnimation(this.hEn);
            this.hEd.clearAnimation();
            this.hEd.startAnimation(this.hEl);
            bFP();
            this.hEf = new a(view);
            com.baidu.adp.lib.g.e.ns().postDelayed(this.hEf, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFO() {
        this.hEi = true;
        this.hEj = true;
        if (this.hEf != null) {
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.hEf);
        }
        if (this.hEf == null) {
            this.hEf = new a(this.hEe);
        }
        com.baidu.adp.lib.g.e.ns().postDelayed(this.hEf, 500L);
    }

    private void bFP() {
        clearAnimation();
        int size = this.fIW.size();
        this.hEh = size;
        this.hEj = false;
        int i = size - 1;
        for (int i2 = 0; i2 < size; i2++) {
            final View view = this.fIW.get(i);
            i--;
            com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.c.7
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(c.this.aRI.getPageActivity(), d.a.write_tab_icon_hide_anim);
                    loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.c.7.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            view.setVisibility(4);
                            if (c.this.hEh == 1) {
                                c.this.hEj = true;
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
        this.hDU.clearAnimation();
        this.hDR.clearAnimation();
        this.hEa.clearAnimation();
        this.hDX.clearAnimation();
    }

    public void onChangeSkinType() {
        aj.t(this.hDP, d.C0141d.cp_bg_line_d_alpha98);
        aj.c(this.hDS, d.f.icon_post_type_photograph_n);
        aj.c(this.hDV, d.f.icon_post_type_text_n);
        aj.c(this.hDY, d.f.icon_post_type_image_n);
        aj.c(this.hEb, d.f.icon_post_type_live_n);
        aj.c(this.hEd, d.f.icon_tabbar_add_s);
        aj.r(this.hDT, d.C0141d.cp_cont_b);
        aj.r(this.hDW, d.C0141d.cp_cont_b);
        aj.r(this.hDZ, d.C0141d.cp_cont_b);
        aj.r(this.hEc, d.C0141d.cp_cont_b);
    }

    public void onDestroy() {
        if (this.hDQ != null && this.hDQ.getParent() == this.mRootView) {
            this.mRootView.removeView(this.hDQ);
        }
        if (this.hEf != null) {
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.hEf);
            this.hEf = null;
        }
        this.fIW.clear();
    }

    public boolean isShowing() {
        return this.hEg;
    }
}
