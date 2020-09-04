package com.baidu.tieba.pushdialog;

import android.graphics.drawable.Drawable;
import android.support.annotation.IdRes;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.j;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import com.baidu.tieba.play.o;
import com.tencent.connect.common.Constants;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Locale;
/* loaded from: classes15.dex */
public class c implements View.OnClickListener {
    private TextView aOW;
    private com.baidu.tbadk.widget.richText.a dTH;
    private EditorScrollView eFS;
    private View hYT;
    private TbRichTextView jGU;
    private final PushDialogActivity lyE;
    private j lyI;
    private Drawable lyK;
    private View lyL;
    private TbImageView lyM;
    private TextView lyN;
    private ImageView lyO;
    private TextView lyP;
    private PushDialogVideoView lyQ;
    private ClickableHeaderImageView lyR;
    private TextView lyS;
    private CommonUserLikeButton lyT;
    private TextView lyU;
    private boolean lyV = false;
    private View mRootView;
    private long tid;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.lyE = pushDialogActivity;
        this.lyE.setContentView(i);
        this.mRootView = findViewById(R.id.root_view);
        this.lyL = findViewById(R.id.dialog_wrapper_view);
        this.eFS = (EditorScrollView) findViewById(R.id.push_dialog_content_layout);
        this.eFS.setOverScrollMode(2);
        this.eFS.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.lyV) {
                    TiebaStatic.log(new aq("c13199").ai("obj_locate", 1).dD("tid", c.this.lyE.getTid()));
                    c.this.lyV = true;
                }
            }
        });
        if (this.lyL.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lyL.getLayoutParams();
            int equipmentHeight = l.getEquipmentHeight(this.lyE);
            layoutParams.height = equipmentHeight / 2;
            layoutParams.topMargin = (int) (equipmentHeight * 0.22f);
            this.lyL.postInvalidate();
        }
        if (l.isFlymeOsAbove35()) {
            this.lyK = com.baidu.tieba.v.b.dAU();
            if (this.lyK != null && this.lyE.getWindow() != null) {
                this.lyE.getWindow().setBackgroundDrawable(this.lyK);
            }
        }
        this.hYT = findViewById(R.id.push_dialog_bottom_layout);
        this.hYT.setOnClickListener(this);
        this.lyU = (TextView) findViewById(R.id.comment_num);
        this.lyM = (TbImageView) findViewById(R.id.push_dialog_title_img);
        this.lyM.setDefaultBgResource(R.drawable.tb_launcher_icon);
        this.lyM.setAutoChangeStyle(false);
        this.lyN = (TextView) findViewById(R.id.push_dialog_title_text);
        this.lyP = (TextView) findViewById(R.id.push_dialog_content_title);
        this.lyR = (ClickableHeaderImageView) findViewById(R.id.push_dialog_user_head);
        this.lyR.setBorderSurroundContent(true);
        this.lyR.setIsRound(true);
        this.lyR.setEnabled(false);
        this.lyR.setAutoChangeStyle(false);
        this.lyR.setBorderWidth(l.getDimens(this.lyE, R.dimen.tbds1));
        this.lyR.setBorderColor(ContextCompat.getColor(this.lyE, R.color.black_alpha15));
        this.dTH = new com.baidu.tbadk.widget.richText.a();
        this.jGU = (TbRichTextView) findViewById(R.id.push_dialog_content);
        this.jGU.setTextColor(ContextCompat.getColor(this.lyE, R.color.cp_cont_j));
        this.dTH.ri(l.getDimens(this.lyE, R.dimen.tbds38));
        this.dTH.setTextSize(l.getDimens(this.lyE, R.dimen.tbds42));
        this.dTH.rm(l.getDimens(this.lyE, R.dimen.tbds23));
        this.dTH.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.dTH.br(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.jGU.setLayoutStrategy(this.dTH);
        this.lyQ = (PushDialogVideoView) findViewById(R.id.push_dialog_video);
        this.lyQ.setPageContext(this.lyE.getPageContext());
        this.aOW = (TextView) findViewById(R.id.push_dialog_user_name);
        this.lyS = (TextView) findViewById(R.id.push_dialog_user_god_info);
        this.lyT = (CommonUserLikeButton) findViewById(R.id.push_dialog_user_like_btn);
        this.lyT.setAfterOnClickListener(this);
        this.lyO = (ImageView) findViewById(R.id.dialog_close_btn);
        this.lyO.setOnClickListener(this);
    }

    public void onResume() {
        if (this.lyQ != null) {
            this.lyQ.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.lyE.findViewById(i);
    }

    public void dmc() {
        if (this.lyQ != null) {
            this.lyQ.setNetworkChange();
            if (com.baidu.adp.lib.util.j.isMobileNet() && this.lyQ.rF() && this.lyI != null && this.lyI.getFileSize() > 0 && this.lyI.getDuration() > 0) {
                float fileSize = this.lyI.getFileSize() * (1.0f - ((this.lyQ.getCurrentPosition() * 1.0f) / (this.lyI.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.lyE.getPageContext().getPageActivity(), String.format(this.lyE.getPageContext().getString(R.string.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int dimens;
        int dimens2;
        if (aVar != null) {
            this.lyM.startLoad(aVar.dme(), 17, false);
            this.lyN.setText(aVar.dmd());
            if (aVar.dmg() != null) {
                this.lyR.setData(aVar.dmg());
                this.aOW.setText(aVar.dmg().getName_show());
                if (aVar.dmg().getGodUserData() != null && (!StringUtils.isNull(aVar.dmg().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.dmg().getGodUserData().getIntro()))) {
                    this.lyS.setText(aVar.dmg().getGodUserData().getForumName() + "吧 " + aVar.dmg().getGodIntro());
                    this.lyS.setVisibility(0);
                } else {
                    this.lyS.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.dmg().getUserId())) {
                    this.lyT.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.lyE.getPageContext(), this.lyT).a(aVar.dmg());
                    this.lyT.onChangeSkinType(0);
                    this.lyT.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b dmf = aVar.dmf();
                if (dmf == null) {
                    this.lyE.dlS().dAQ();
                    this.lyE.finish();
                    return;
                }
                boolean z = dmf.dmh() == null || y.isEmpty(dmf.dmh().bxx());
                if (StringUtils.isNull(dmf.getTitle()) && z) {
                    this.lyE.dlS().dAQ();
                    this.lyE.finish();
                    return;
                }
                if (dmf.dmh() != null) {
                    Iterator<TbRichTextData> it = dmf.dmh().bxx().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.lyI = next.bxH();
                        }
                        if (this.lyI != null) {
                            break;
                        }
                    }
                }
                this.tid = dmf.getTid();
                if (this.lyI == null) {
                    this.lyQ.setVisibility(8);
                    this.jGU.setVisibility(0);
                    boolean z2 = com.baidu.adp.lib.util.j.is4GNet() || com.baidu.adp.lib.util.j.isWifiNet();
                    this.dTH.jX(z2);
                    if (z2) {
                        dimens = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(this.lyE, R.dimen.tbds22) * 2)) - (l.getDimens(this.lyE, R.dimen.tbds44) * 2);
                        dimens2 = (int) (dimens * 1.618f);
                    } else {
                        dimens = l.getDimens(this.lyE, R.dimen.tbds360);
                        dimens2 = l.getDimens(this.lyE, R.dimen.tbds202);
                    }
                    this.dTH.jY(z2);
                    this.dTH.rd(dimens);
                    this.dTH.re(dimens2);
                    this.jGU.setText(dmf.dmh());
                } else {
                    this.jGU.setVisibility(8);
                    this.lyQ.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lyQ.getLayoutParams();
                    layoutParams.width = l.getEquipmentWidth(this.lyE) - l.getDimens(this.lyE, R.dimen.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.lyQ.setLayoutParams(layoutParams);
                    this.lyQ.setTbRichTextVideoInfo(this.lyI);
                    this.lyQ.stopPlay();
                    this.lyQ.setThumbnail(this.lyI.getThumbUrl());
                    this.lyQ.setVideoUrl(this.lyI.getVideoUrl(), String.valueOf(this.tid));
                    this.lyQ.czv();
                    o oVar = new o();
                    oVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    oVar.ala = String.valueOf(this.tid);
                    oVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    this.lyQ.setVideoViewBusiness(oVar);
                }
                if (StringUtils.isNull(dmf.getTitle())) {
                    this.lyP.setVisibility(8);
                } else {
                    this.lyP.setText(dmf.getTitle());
                    this.lyP.setVisibility(0);
                }
                this.lyU.setText(String.format(Locale.CHINA, this.lyE.getString(R.string.bottom_comment), Integer.valueOf(dmf.getPostNum())));
                if (!this.lyE.dlS().dAT()) {
                    this.lyE.dlS().dAR();
                    return;
                }
                return;
            }
            this.lyE.dlS().dAQ();
            this.lyE.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.lyO) {
            TiebaStatic.log(new aq("c13198").dD("tid", this.lyE.getTid()));
            e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.lyE != null && c.this.lyE.dlS() != null) {
                        c.this.lyE.dlS().dAQ();
                    }
                }
            }, 100L);
            this.lyE.finish();
        } else if (view == this.hYT) {
            TiebaStatic.log(new aq("c13199").ai("obj_locate", 4).dD("tid", this.lyE.getTid()));
            if (this.tid == 0) {
                this.lyE.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.lyE).createNormalCfg(this.tid + "", null, null)));
            this.lyE.dlS().dAR();
            this.lyE.finish();
        } else if (view == this.lyT) {
            TiebaStatic.log(new aq("c13199").ai("obj_locate", 3).dD("tid", this.lyE.getTid()));
        }
    }

    public void onPause() {
        if (this.lyQ != null) {
            this.lyQ.onPause();
        }
    }

    public void onDestroy() {
        if (this.lyQ != null) {
            this.lyQ.onDestroy();
        }
    }
}
