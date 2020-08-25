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
    private TextView aOU;
    private com.baidu.tbadk.widget.richText.a dTD;
    private EditorScrollView eFO;
    private View hYN;
    private TbRichTextView jGO;
    private View lyA;
    private TbImageView lyB;
    private TextView lyC;
    private ImageView lyD;
    private TextView lyE;
    private PushDialogVideoView lyF;
    private ClickableHeaderImageView lyG;
    private TextView lyH;
    private CommonUserLikeButton lyI;
    private TextView lyJ;
    private boolean lyK = false;
    private final PushDialogActivity lyt;
    private j lyx;
    private Drawable lyz;
    private View mRootView;
    private long tid;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.lyt = pushDialogActivity;
        this.lyt.setContentView(i);
        this.mRootView = findViewById(R.id.root_view);
        this.lyA = findViewById(R.id.dialog_wrapper_view);
        this.eFO = (EditorScrollView) findViewById(R.id.push_dialog_content_layout);
        this.eFO.setOverScrollMode(2);
        this.eFO.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.lyK) {
                    TiebaStatic.log(new aq("c13199").ai("obj_locate", 1).dD("tid", c.this.lyt.getTid()));
                    c.this.lyK = true;
                }
            }
        });
        if (this.lyA.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lyA.getLayoutParams();
            int equipmentHeight = l.getEquipmentHeight(this.lyt);
            layoutParams.height = equipmentHeight / 2;
            layoutParams.topMargin = (int) (equipmentHeight * 0.22f);
            this.lyA.postInvalidate();
        }
        if (l.isFlymeOsAbove35()) {
            this.lyz = com.baidu.tieba.v.b.dAL();
            if (this.lyz != null && this.lyt.getWindow() != null) {
                this.lyt.getWindow().setBackgroundDrawable(this.lyz);
            }
        }
        this.hYN = findViewById(R.id.push_dialog_bottom_layout);
        this.hYN.setOnClickListener(this);
        this.lyJ = (TextView) findViewById(R.id.comment_num);
        this.lyB = (TbImageView) findViewById(R.id.push_dialog_title_img);
        this.lyB.setDefaultBgResource(R.drawable.tb_launcher_icon);
        this.lyB.setAutoChangeStyle(false);
        this.lyC = (TextView) findViewById(R.id.push_dialog_title_text);
        this.lyE = (TextView) findViewById(R.id.push_dialog_content_title);
        this.lyG = (ClickableHeaderImageView) findViewById(R.id.push_dialog_user_head);
        this.lyG.setBorderSurroundContent(true);
        this.lyG.setIsRound(true);
        this.lyG.setEnabled(false);
        this.lyG.setAutoChangeStyle(false);
        this.lyG.setBorderWidth(l.getDimens(this.lyt, R.dimen.tbds1));
        this.lyG.setBorderColor(ContextCompat.getColor(this.lyt, R.color.black_alpha15));
        this.dTD = new com.baidu.tbadk.widget.richText.a();
        this.jGO = (TbRichTextView) findViewById(R.id.push_dialog_content);
        this.jGO.setTextColor(ContextCompat.getColor(this.lyt, R.color.cp_cont_j));
        this.dTD.ri(l.getDimens(this.lyt, R.dimen.tbds38));
        this.dTD.setTextSize(l.getDimens(this.lyt, R.dimen.tbds42));
        this.dTD.rm(l.getDimens(this.lyt, R.dimen.tbds23));
        this.dTD.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.dTD.br(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.jGO.setLayoutStrategy(this.dTD);
        this.lyF = (PushDialogVideoView) findViewById(R.id.push_dialog_video);
        this.lyF.setPageContext(this.lyt.getPageContext());
        this.aOU = (TextView) findViewById(R.id.push_dialog_user_name);
        this.lyH = (TextView) findViewById(R.id.push_dialog_user_god_info);
        this.lyI = (CommonUserLikeButton) findViewById(R.id.push_dialog_user_like_btn);
        this.lyI.setAfterOnClickListener(this);
        this.lyD = (ImageView) findViewById(R.id.dialog_close_btn);
        this.lyD.setOnClickListener(this);
    }

    public void onResume() {
        if (this.lyF != null) {
            this.lyF.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.lyt.findViewById(i);
    }

    public void dlZ() {
        if (this.lyF != null) {
            this.lyF.setNetworkChange();
            if (com.baidu.adp.lib.util.j.isMobileNet() && this.lyF.rF() && this.lyx != null && this.lyx.getFileSize() > 0 && this.lyx.getDuration() > 0) {
                float fileSize = this.lyx.getFileSize() * (1.0f - ((this.lyF.getCurrentPosition() * 1.0f) / (this.lyx.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.lyt.getPageContext().getPageActivity(), String.format(this.lyt.getPageContext().getString(R.string.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int dimens;
        int dimens2;
        if (aVar != null) {
            this.lyB.startLoad(aVar.dmb(), 17, false);
            this.lyC.setText(aVar.dma());
            if (aVar.dmd() != null) {
                this.lyG.setData(aVar.dmd());
                this.aOU.setText(aVar.dmd().getName_show());
                if (aVar.dmd().getGodUserData() != null && (!StringUtils.isNull(aVar.dmd().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.dmd().getGodUserData().getIntro()))) {
                    this.lyH.setText(aVar.dmd().getGodUserData().getForumName() + "吧 " + aVar.dmd().getGodIntro());
                    this.lyH.setVisibility(0);
                } else {
                    this.lyH.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.dmd().getUserId())) {
                    this.lyI.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.lyt.getPageContext(), this.lyI).a(aVar.dmd());
                    this.lyI.onChangeSkinType(0);
                    this.lyI.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b dmc = aVar.dmc();
                if (dmc == null) {
                    this.lyt.dlP().dAH();
                    this.lyt.finish();
                    return;
                }
                boolean z = dmc.dme() == null || y.isEmpty(dmc.dme().bxw());
                if (StringUtils.isNull(dmc.getTitle()) && z) {
                    this.lyt.dlP().dAH();
                    this.lyt.finish();
                    return;
                }
                if (dmc.dme() != null) {
                    Iterator<TbRichTextData> it = dmc.dme().bxw().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.lyx = next.bxG();
                        }
                        if (this.lyx != null) {
                            break;
                        }
                    }
                }
                this.tid = dmc.getTid();
                if (this.lyx == null) {
                    this.lyF.setVisibility(8);
                    this.jGO.setVisibility(0);
                    boolean z2 = com.baidu.adp.lib.util.j.is4GNet() || com.baidu.adp.lib.util.j.isWifiNet();
                    this.dTD.jV(z2);
                    if (z2) {
                        dimens = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(this.lyt, R.dimen.tbds22) * 2)) - (l.getDimens(this.lyt, R.dimen.tbds44) * 2);
                        dimens2 = (int) (dimens * 1.618f);
                    } else {
                        dimens = l.getDimens(this.lyt, R.dimen.tbds360);
                        dimens2 = l.getDimens(this.lyt, R.dimen.tbds202);
                    }
                    this.dTD.jW(z2);
                    this.dTD.rd(dimens);
                    this.dTD.re(dimens2);
                    this.jGO.setText(dmc.dme());
                } else {
                    this.jGO.setVisibility(8);
                    this.lyF.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lyF.getLayoutParams();
                    layoutParams.width = l.getEquipmentWidth(this.lyt) - l.getDimens(this.lyt, R.dimen.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.lyF.setLayoutParams(layoutParams);
                    this.lyF.setTbRichTextVideoInfo(this.lyx);
                    this.lyF.stopPlay();
                    this.lyF.setThumbnail(this.lyx.getThumbUrl());
                    this.lyF.setVideoUrl(this.lyx.getVideoUrl(), String.valueOf(this.tid));
                    this.lyF.czu();
                    o oVar = new o();
                    oVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    oVar.akY = String.valueOf(this.tid);
                    oVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    this.lyF.setVideoViewBusiness(oVar);
                }
                if (StringUtils.isNull(dmc.getTitle())) {
                    this.lyE.setVisibility(8);
                } else {
                    this.lyE.setText(dmc.getTitle());
                    this.lyE.setVisibility(0);
                }
                this.lyJ.setText(String.format(Locale.CHINA, this.lyt.getString(R.string.bottom_comment), Integer.valueOf(dmc.getPostNum())));
                if (!this.lyt.dlP().dAK()) {
                    this.lyt.dlP().dAI();
                    return;
                }
                return;
            }
            this.lyt.dlP().dAH();
            this.lyt.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.lyD) {
            TiebaStatic.log(new aq("c13198").dD("tid", this.lyt.getTid()));
            e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.lyt != null && c.this.lyt.dlP() != null) {
                        c.this.lyt.dlP().dAH();
                    }
                }
            }, 100L);
            this.lyt.finish();
        } else if (view == this.hYN) {
            TiebaStatic.log(new aq("c13199").ai("obj_locate", 4).dD("tid", this.lyt.getTid()));
            if (this.tid == 0) {
                this.lyt.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.lyt).createNormalCfg(this.tid + "", null, null)));
            this.lyt.dlP().dAI();
            this.lyt.finish();
        } else if (view == this.lyI) {
            TiebaStatic.log(new aq("c13199").ai("obj_locate", 3).dD("tid", this.lyt.getTid()));
        }
    }

    public void onPause() {
        if (this.lyF != null) {
            this.lyF.onPause();
        }
    }

    public void onDestroy() {
        if (this.lyF != null) {
            this.lyF.onDestroy();
        }
    }
}
