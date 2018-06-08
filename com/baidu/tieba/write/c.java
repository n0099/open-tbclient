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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaMasterLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.g;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.GridLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ForumWriteData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c {
    private int bgColor;
    private ForumWriteData heN;
    private TextView hnA;
    private ImageView hnB;
    private GridLayout hnC;
    private a hnD;
    private Animation hnK;
    private Animation hnL;
    private Animation hnM;
    private Animation hnN;
    private View hnn;
    private View hno;
    private LinearLayout hnp;
    private TbImageView hnq;
    private TextView hnr;
    private LinearLayout hns;
    private TbImageView hnt;
    private TextView hnu;
    private LinearLayout hnv;
    private TbImageView hnw;
    private TextView hnx;
    private LinearLayout hny;
    private TbImageView hnz;
    private TbPageContext mContext;
    private String mFrom;
    private ViewGroup mRootView;
    private String writeCallFrom;
    private boolean hnE = false;
    private int hnF = 0;
    private boolean hnG = true;
    private boolean hnH = true;
    private ArrayList<View> hnI = new ArrayList<>();
    private String hnJ = "";
    private String hnO = "0";

    static /* synthetic */ int s(c cVar) {
        int i = cVar.hnF;
        cVar.hnF = i + 1;
        return i;
    }

    static /* synthetic */ int u(c cVar) {
        int i = cVar.hnF;
        cVar.hnF = i - 1;
        return i;
    }

    public c(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this.mFrom = AlbumActivityConfig.FROM_WRITE;
        this.mContext = tbPageContext;
        this.mRootView = viewGroup;
        this.mFrom = str;
        initView();
        onChangeSkinType();
    }

    public void vz(String str) {
        if (str == null) {
            str = "";
        }
        this.hnJ = str;
    }

    public void a(ForumWriteData forumWriteData) {
        this.heN = forumWriteData;
    }

    public void vA(String str) {
        if ("3".equals(str)) {
            this.writeCallFrom = "1";
        } else {
            this.writeCallFrom = str;
        }
        this.hnO = str;
    }

    private void initView() {
        if (this.mContext != null && this.mContext.getPageActivity() != null && this.mRootView != null) {
            this.hno = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.i.bottom_write_thread, (ViewGroup) null);
            this.hns = (LinearLayout) this.hno.findViewById(d.g.home_write_article);
            this.hnt = (TbImageView) this.hno.findViewById(d.g.home_write_article_icon);
            this.hnu = (TextView) this.hno.findViewById(d.g.home_write_article_title);
            this.hnp = (LinearLayout) this.hno.findViewById(d.g.home_write_photo);
            this.hnq = (TbImageView) this.hno.findViewById(d.g.home_write_photo_icon);
            this.hnr = (TextView) this.hno.findViewById(d.g.home_write_photo_title);
            this.hnv = (LinearLayout) this.hno.findViewById(d.g.home_write_album);
            this.hnw = (TbImageView) this.hno.findViewById(d.g.home_write_album_icon);
            this.hnx = (TextView) this.hno.findViewById(d.g.home_write_album_title);
            this.hny = (LinearLayout) this.hno.findViewById(d.g.home_write_live);
            this.hnz = (TbImageView) this.hno.findViewById(d.g.home_write_live_icon);
            this.hnA = (TextView) this.hno.findViewById(d.g.home_write_live_title);
            this.hnB = (ImageView) this.hno.findViewById(d.g.write_close_view);
            this.hnn = this.hno.findViewById(d.g.view_background);
            this.hnC = (GridLayout) this.hno.findViewById(d.g.type_container);
            this.hnC.setMeasureAllChild(true);
            this.hnC.setVerNum(1);
            bGd();
            this.hnI.add(this.hns);
            this.hnI.add(this.hnp);
            this.hnI.add(this.hnv);
            this.hnI.add(this.hny);
            this.hno.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (g.ya() && c.this.bgColor != 0) {
                        c.this.mContext.getPageActivity().getWindow().setNavigationBarColor(c.this.bgColor);
                    }
                    c.this.bE(c.this.hnC);
                }
            });
            this.hnt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.vB(c.this.hnJ);
                }
            });
            this.hnq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.bGg();
                    TiebaStatic.log(new am("c12611").ah("obj_locate", c.this.hnO).r("obj_type", 2));
                    if (c.this.heN == null) {
                        c.this.heN = new ForumWriteData("0", null, null, null);
                    }
                    c.this.heN.mFrom = c.this.mFrom;
                    c.this.heN.writeCallFrom = c.this.writeCallFrom;
                    e.a(c.this.mContext, "", c.this.heN);
                }
            });
            this.hnw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    String str2;
                    int i;
                    String str3;
                    int i2;
                    String str4;
                    String str5;
                    c.this.bGg();
                    PostPrefixData postPrefixData = null;
                    AntiData antiData = null;
                    if (c.this.heN != null) {
                        String str6 = c.this.heN.forumId;
                        String str7 = c.this.heN.forumName;
                        postPrefixData = c.this.heN.prefixData;
                        antiData = c.this.heN.antiData;
                        int i3 = c.this.heN.forumLevel;
                        String str8 = c.this.heN.avatar;
                        int i4 = c.this.heN.privateThread;
                        String str9 = c.this.heN.firstDir;
                        str = c.this.heN.secondDir;
                        str2 = str9;
                        i = i4;
                        str3 = str8;
                        i2 = i3;
                        str4 = str7;
                        str5 = str6;
                    } else {
                        str = "";
                        str2 = "";
                        i = 0;
                        str3 = null;
                        i2 = -1;
                        str4 = null;
                        str5 = "0";
                    }
                    TiebaStatic.log(new am("c12611").ah("obj_locate", c.this.hnO).r("obj_type", 3));
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.mContext.getPageActivity(), 0, str5, str4, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", c.this.mFrom);
                    writeActivityConfig.setCallFrom(c.this.writeCallFrom);
                    writeActivityConfig.setForumLevel(i2);
                    writeActivityConfig.setForumAvatar(str3);
                    writeActivityConfig.setAlbumThread(1);
                    writeActivityConfig.setPrivateThread(i);
                    writeActivityConfig.setForumDir(str2, str);
                    if (!StringUtils.isNull(c.this.hnJ)) {
                        writeActivityConfig.setTitle(c.this.hnJ, true);
                    }
                    if (!c.I(c.this.mContext.getPageActivity())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                    }
                }
            });
            this.hnz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    String str2 = null;
                    c.this.bGg();
                    MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                    String str3 = "0";
                    com.baidu.adp.lib.d.a.hB().I(false);
                    if (c.this.heN != null) {
                        str3 = c.this.heN.forumId;
                        str = c.this.heN.forumName;
                        str2 = c.this.heN.specialForumType;
                    } else {
                        str = null;
                    }
                    TiebaStatic.log(new am("c12611").ah("obj_locate", c.this.hnO).r("obj_type", 4));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(TbadkCoreApplication.getInst().getApplicationContext(), str, str3, TbadkCoreApplication.getCurrentAccount(), str2)));
                }
            });
            onChangeSkinType();
            this.hnK = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.write_thread_black_anim);
            this.hnK.setFillAfter(true);
            this.hnL = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.write_thread_black_hide_anim);
            this.hnL.setFillAfter(true);
            this.hnM = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.write_tab_bg_anim);
            this.hnM.setFillAfter(true);
            this.hnN = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.home_write_bgout);
            this.hnN.setFillAfter(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean I(Activity activity) {
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.zU();
        aVar.c(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return aVar.u(activity);
    }

    private void bGd() {
        int ah = (int) (0.15555556f * l.ah(this.mContext.getPageActivity()));
        a(this.hnt, ah);
        a(this.hnq, ah);
        a(this.hnw, ah);
        a(this.hnz, ah);
        int aj = l.aj(this.mContext.getPageActivity());
        ViewGroup.LayoutParams layoutParams = this.hnC.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = aj / 5;
            this.hnC.setLayoutParams(layoutParams);
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

    public void vc(int i) {
        this.bgColor = i;
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
            c.this.hns.setVisibility(4);
            c.this.hnp.setVisibility(4);
            c.this.hnv.setVisibility(4);
            c.this.hny.setVisibility(4);
            c.this.hnB.setVisibility(4);
            c.this.hnn.setVisibility(4);
            if (this.mView != null) {
                this.mView.setVisibility(8);
            }
            if (c.this.hno.getParent() == c.this.mRootView) {
                c.this.mRootView.removeView(c.this.hno);
            }
            c.this.hnE = false;
        }
    }

    public void nt(boolean z) {
        if (!this.hnE && this.hnG && this.hnH && this.mRootView != null) {
            this.hnB.clearAnimation();
            this.hnE = true;
            if (this.hno.getParent() == null) {
                com.baidu.tbadk.j.d.Q(this.mRootView).a(this.mRootView, this.hno, z);
            }
            this.hnC.setVisibility(0);
            this.hnn.setVisibility(0);
            this.hnn.clearAnimation();
            this.hnn.startAnimation(this.hnM);
            this.hnB.setVisibility(0);
            this.hnB.startAnimation(this.hnK);
            bGe();
            TiebaStatic.log(new am("c12052").ah("obj_locate", this.hnO));
            if (j.jF()) {
                String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_baidu_sim_card_writting_tip", "");
                if (!ao.isEmpty(string)) {
                    BdToast.a(this.mContext.getContext(), string).xi();
                    com.baidu.tbadk.core.sharedPref.b.getInstance().remove("key_baidu_sim_card_writting_tip");
                }
            }
        }
    }

    private void bGe() {
        clearAnimation();
        final int size = this.hnI.size();
        this.hnG = false;
        this.hnF = 0;
        for (int i = 0; i < size; i++) {
            final View view = this.hnI.get(i);
            com.baidu.adp.lib.g.e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.c.6
                @Override // java.lang.Runnable
                public void run() {
                    view.setVisibility(0);
                    Animation loadAnimation = AnimationUtils.loadAnimation(c.this.mContext.getPageActivity(), d.a.write_tab_icon_show_anim);
                    loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.c.6.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            c.s(c.this);
                            if (c.this.hnF == size) {
                                c.this.hnG = true;
                                c.this.hnF = 0;
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

    public void bGf() {
        bE(this.hnC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bE(View view) {
        if (this.hnG && this.hnH) {
            if (this.hnD != null) {
                com.baidu.adp.lib.g.e.im().removeCallbacks(this.hnD);
            }
            this.hnn.clearAnimation();
            this.hnn.startAnimation(this.hnN);
            this.hnB.clearAnimation();
            this.hnB.startAnimation(this.hnL);
            bGh();
            this.hnD = new a(view);
            com.baidu.adp.lib.g.e.im().postDelayed(this.hnD, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGg() {
        this.hnG = true;
        this.hnH = true;
        if (this.hnD != null) {
            com.baidu.adp.lib.g.e.im().removeCallbacks(this.hnD);
        }
        if (this.hnD == null) {
            this.hnD = new a(this.hnC);
        }
        com.baidu.adp.lib.g.e.im().postDelayed(this.hnD, 500L);
    }

    private void bGh() {
        clearAnimation();
        int size = this.hnI.size();
        this.hnF = size;
        this.hnH = false;
        int i = size - 1;
        for (int i2 = 0; i2 < size; i2++) {
            final View view = this.hnI.get(i);
            i--;
            com.baidu.adp.lib.g.e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.c.7
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(c.this.mContext.getPageActivity(), d.a.write_tab_icon_hide_anim);
                    loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.c.7.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            view.setVisibility(4);
                            if (c.this.hnF == 1) {
                                c.this.hnH = true;
                            } else {
                                c.u(c.this);
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
        this.hns.clearAnimation();
        this.hnp.clearAnimation();
        this.hny.clearAnimation();
        this.hnv.clearAnimation();
    }

    public void onChangeSkinType() {
        al.j(this.hnn, d.C0141d.cp_bg_line_d_alpha98);
        al.c(this.hnq, d.f.icon_post_type_photograph_n);
        al.c(this.hnt, d.f.icon_post_type_text_n);
        al.c(this.hnw, d.f.icon_post_type_image_n);
        al.c(this.hnz, d.f.icon_post_type_live_n);
        al.c(this.hnB, d.f.icon_tabbar_add_s);
        al.h(this.hnr, d.C0141d.cp_cont_b);
        al.h(this.hnu, d.C0141d.cp_cont_b);
        al.h(this.hnx, d.C0141d.cp_cont_b);
        al.h(this.hnA, d.C0141d.cp_cont_b);
    }

    public void onDestroy() {
        if (this.hno != null && this.hno.getParent() == this.mRootView) {
            this.mRootView.removeView(this.hno);
        }
        if (this.hnD != null) {
            com.baidu.adp.lib.g.e.im().removeCallbacks(this.hnD);
            this.hnD = null;
        }
        this.hnI.clear();
    }

    public boolean isShowing() {
        return this.hnE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vB(String str) {
        String str2;
        String str3;
        int i;
        String str4;
        int i2;
        String str5;
        String str6;
        bGg();
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.heN == null) {
            str2 = "";
            str3 = "";
            i = 0;
            str4 = null;
            i2 = -1;
            str5 = null;
            str6 = "0";
        } else {
            String str7 = this.heN.forumId;
            String str8 = this.heN.forumName;
            postPrefixData = this.heN.prefixData;
            antiData = this.heN.antiData;
            int i3 = this.heN.forumLevel;
            String str9 = this.heN.avatar;
            int i4 = this.heN.privateThread;
            String str10 = this.heN.firstDir;
            str2 = this.heN.secondDir;
            str3 = str10;
            i = i4;
            str4 = str9;
            i2 = i3;
            str5 = str8;
            str6 = str7;
        }
        TiebaStatic.log(new am("c12611").ah("obj_locate", this.hnO).r("obj_type", 1));
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mContext.getPageActivity(), 9, str6, str5, null, null, 0, antiData, 13003, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom(this.writeCallFrom);
        if (!StringUtils.isNull(str)) {
            writeActivityConfig.setTitle(str, true);
        }
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str4);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setForumDir(str3, str2);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
    }
}
