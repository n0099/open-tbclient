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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.j;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.y;
import com.tencent.connect.common.Constants;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Locale;
/* loaded from: classes8.dex */
public class c implements View.OnClickListener {
    private TextView aIn;
    private com.baidu.tbadk.widget.richText.a dEy;
    private EditorScrollView epb;
    private TbRichTextView jjk;
    private final PushDialogActivity laI;
    private j laM;
    private Drawable laO;
    private View laP;
    private TbImageView laQ;
    private TextView laR;
    private ImageView laS;
    private TextView laT;
    private PushDialogVideoView laU;
    private ClickableHeaderImageView laV;
    private TextView laW;
    private CommonUserLikeButton laX;
    private View laY;
    private TextView laZ;
    private boolean lba = false;
    private View mRootView;
    private long tid;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.laI = pushDialogActivity;
        this.laI.setContentView(i);
        this.mRootView = findViewById(R.id.root_view);
        this.laP = findViewById(R.id.dialog_wrapper_view);
        this.epb = (EditorScrollView) findViewById(R.id.push_dialog_content_layout);
        this.epb.setOverScrollMode(2);
        this.epb.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.lba) {
                    TiebaStatic.log(new ao("c13199").ag("obj_locate", 1).dk("tid", c.this.laI.getTid()));
                    c.this.lba = true;
                }
            }
        });
        if (this.laP.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.laP.getLayoutParams();
            int equipmentHeight = l.getEquipmentHeight(this.laI);
            layoutParams.height = equipmentHeight / 2;
            layoutParams.topMargin = (int) (equipmentHeight * 0.22f);
            this.laP.postInvalidate();
        }
        if (l.isFlymeOsAbove35()) {
            this.laO = com.baidu.tieba.v.b.dmf();
            if (this.laO != null && this.laI.getWindow() != null) {
                this.laI.getWindow().setBackgroundDrawable(this.laO);
            }
        }
        this.laY = findViewById(R.id.push_dialog_bottom_layout);
        this.laY.setOnClickListener(this);
        this.laZ = (TextView) findViewById(R.id.comment_num);
        this.laQ = (TbImageView) findViewById(R.id.push_dialog_title_img);
        this.laQ.setDefaultBgResource(R.drawable.tb_launcher_icon);
        this.laQ.setAutoChangeStyle(false);
        this.laR = (TextView) findViewById(R.id.push_dialog_title_text);
        this.laT = (TextView) findViewById(R.id.push_dialog_content_title);
        this.laV = (ClickableHeaderImageView) findViewById(R.id.push_dialog_user_head);
        this.laV.setBorderSurroundContent(true);
        this.laV.setIsRound(true);
        this.laV.setEnabled(false);
        this.laV.setAutoChangeStyle(false);
        this.laV.setBorderWidth(l.getDimens(this.laI, R.dimen.tbds1));
        this.laV.setBorderColor(ContextCompat.getColor(this.laI, R.color.black_alpha15));
        this.dEy = new com.baidu.tbadk.widget.richText.a();
        this.jjk = (TbRichTextView) findViewById(R.id.push_dialog_content);
        this.jjk.setTextColor(ContextCompat.getColor(this.laI, R.color.cp_cont_j));
        this.dEy.oD(l.getDimens(this.laI, R.dimen.tbds38));
        this.dEy.setTextSize(l.getDimens(this.laI, R.dimen.tbds42));
        this.dEy.oH(l.getDimens(this.laI, R.dimen.tbds23));
        this.dEy.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.dEy.bf(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.jjk.setLayoutStrategy(this.dEy);
        this.laU = (PushDialogVideoView) findViewById(R.id.push_dialog_video);
        this.laU.setPageContext(this.laI.getPageContext());
        this.aIn = (TextView) findViewById(R.id.push_dialog_user_name);
        this.laW = (TextView) findViewById(R.id.push_dialog_user_god_info);
        this.laX = (CommonUserLikeButton) findViewById(R.id.push_dialog_user_like_btn);
        this.laX.setAfterOnClickListener(this);
        this.laS = (ImageView) findViewById(R.id.dialog_close_btn);
        this.laS.setOnClickListener(this);
    }

    public void onResume() {
        if (this.laU != null) {
            this.laU.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.laI.findViewById(i);
    }

    public void cXO() {
        if (this.laU != null) {
            this.laU.setNetworkChange();
            if (com.baidu.adp.lib.util.j.isMobileNet() && this.laU.qf() && this.laM != null && this.laM.getFileSize() > 0 && this.laM.getDuration() > 0) {
                float fileSize = this.laM.getFileSize() * (1.0f - ((this.laU.getCurrentPosition() * 1.0f) / (this.laM.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.laI.getPageContext().getPageActivity(), String.format(this.laI.getPageContext().getString(R.string.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int dimens;
        int dimens2;
        if (aVar != null) {
            this.laQ.startLoad(aVar.cXQ(), 17, false);
            this.laR.setText(aVar.cXP());
            if (aVar.cXS() != null) {
                this.laV.setData(aVar.cXS());
                this.aIn.setText(aVar.cXS().getName_show());
                if (aVar.cXS().getGodUserData() != null && (!StringUtils.isNull(aVar.cXS().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.cXS().getGodUserData().getIntro()))) {
                    this.laW.setText(aVar.cXS().getGodUserData().getForumName() + "吧 " + aVar.cXS().getGodIntro());
                    this.laW.setVisibility(0);
                } else {
                    this.laW.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.cXS().getUserId())) {
                    this.laX.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.laI.getPageContext(), this.laX).a(aVar.cXS());
                    this.laX.onChangeSkinType(0);
                    this.laX.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b cXR = aVar.cXR();
                if (cXR == null) {
                    this.laI.cXE().dmb();
                    this.laI.finish();
                    return;
                }
                boolean z = cXR.cXT() == null || w.isEmpty(cXR.cXT().bkP());
                if (StringUtils.isNull(cXR.getTitle()) && z) {
                    this.laI.cXE().dmb();
                    this.laI.finish();
                    return;
                }
                if (cXR.cXT() != null) {
                    Iterator<TbRichTextData> it = cXR.cXT().bkP().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.laM = next.bkZ();
                        }
                        if (this.laM != null) {
                            break;
                        }
                    }
                }
                this.tid = cXR.getTid();
                if (this.laM == null) {
                    this.laU.setVisibility(8);
                    this.jjk.setVisibility(0);
                    boolean z2 = com.baidu.adp.lib.util.j.is4GNet() || com.baidu.adp.lib.util.j.isWifiNet();
                    this.dEy.iS(z2);
                    if (z2) {
                        dimens = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(this.laI, R.dimen.tbds22) * 2)) - (l.getDimens(this.laI, R.dimen.tbds44) * 2);
                        dimens2 = (int) (dimens * 1.618f);
                    } else {
                        dimens = l.getDimens(this.laI, R.dimen.tbds360);
                        dimens2 = l.getDimens(this.laI, R.dimen.tbds202);
                    }
                    this.dEy.iT(z2);
                    this.dEy.oy(dimens);
                    this.dEy.oz(dimens2);
                    this.jjk.setText(cXR.cXT());
                } else {
                    this.jjk.setVisibility(8);
                    this.laU.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.laU.getLayoutParams();
                    layoutParams.width = l.getEquipmentWidth(this.laI) - l.getDimens(this.laI, R.dimen.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.laU.setLayoutParams(layoutParams);
                    this.laU.setTbRichTextVideoInfo(this.laM);
                    this.laU.stopPlay();
                    this.laU.setIsNeedRecoveryVideoPlayer(true);
                    this.laU.setThumbnail(this.laM.getThumbUrl());
                    this.laU.setVideoUrl(this.laM.getVideoUrl(), String.valueOf(this.tid));
                    this.laU.clb();
                    n nVar = new n(this.laI.getActivity());
                    nVar.La("2");
                    y yVar = new y();
                    yVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    yVar.ajO = String.valueOf(this.tid);
                    yVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    nVar.setVideoStatsData(yVar);
                    this.laU.setQuickVideoViewBusiness(nVar);
                }
                if (StringUtils.isNull(cXR.getTitle())) {
                    this.laT.setVisibility(8);
                } else {
                    this.laT.setText(cXR.getTitle());
                    this.laT.setVisibility(0);
                }
                this.laZ.setText(String.format(Locale.CHINA, this.laI.getString(R.string.bottom_comment), Integer.valueOf(cXR.getPostNum())));
                if (!this.laI.cXE().dme()) {
                    this.laI.cXE().dmc();
                    return;
                }
                return;
            }
            this.laI.cXE().dmb();
            this.laI.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.laS) {
            TiebaStatic.log(new ao("c13198").dk("tid", this.laI.getTid()));
            e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.laI != null && c.this.laI.cXE() != null) {
                        c.this.laI.cXE().dmb();
                    }
                }
            }, 100L);
            this.laI.finish();
        } else if (view == this.laY) {
            TiebaStatic.log(new ao("c13199").ag("obj_locate", 4).dk("tid", this.laI.getTid()));
            if (this.tid == 0) {
                this.laI.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.laI).createNormalCfg(this.tid + "", null, null)));
            this.laI.cXE().dmc();
            this.laI.finish();
        } else if (view == this.laX) {
            TiebaStatic.log(new ao("c13199").ag("obj_locate", 3).dk("tid", this.laI.getTid()));
        }
    }

    public void onPause() {
        if (this.laU != null) {
            this.laU.onPause();
        }
    }

    public void onDestroy() {
        if (this.laU != null) {
            this.laU.onDestroy();
        }
    }
}
