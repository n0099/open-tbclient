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
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.i;
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
    private TextView aFR;
    private EditorScrollView egr;
    private TbRichTextView iRl;
    private final PushDialogActivity kFD;
    private i kFH;
    private Drawable kFJ;
    private View kFK;
    private TbImageView kFL;
    private TextView kFM;
    private ImageView kFN;
    private TextView kFO;
    private PushDialogVideoView kFP;
    private ClickableHeaderImageView kFQ;
    private TextView kFR;
    private CommonUserLikeButton kFS;
    private View kFT;
    private TextView kFU;
    private com.baidu.tbadk.widget.richText.a kFV;
    private boolean kFW = false;
    private View mRootView;
    private long tid;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.kFD = pushDialogActivity;
        this.kFD.setContentView(i);
        this.mRootView = findViewById(R.id.root_view);
        this.kFK = findViewById(R.id.dialog_wrapper_view);
        this.egr = (EditorScrollView) findViewById(R.id.push_dialog_content_layout);
        this.egr.setOverScrollMode(2);
        this.egr.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.kFW) {
                    TiebaStatic.log(new an("c13199").ag("obj_locate", 1).dh("tid", c.this.kFD.getTid()));
                    c.this.kFW = true;
                }
            }
        });
        if (this.kFK.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kFK.getLayoutParams();
            int equipmentHeight = l.getEquipmentHeight(this.kFD);
            layoutParams.height = equipmentHeight / 2;
            layoutParams.topMargin = (int) (equipmentHeight * 0.22f);
            this.kFK.postInvalidate();
        }
        if (l.isFlymeOsAbove35()) {
            this.kFJ = com.baidu.tieba.v.b.dhE();
            if (this.kFJ != null && this.kFD.getWindow() != null) {
                this.kFD.getWindow().setBackgroundDrawable(this.kFJ);
            }
        }
        this.kFT = findViewById(R.id.push_dialog_bottom_layout);
        this.kFT.setOnClickListener(this);
        this.kFU = (TextView) findViewById(R.id.comment_num);
        this.kFL = (TbImageView) findViewById(R.id.push_dialog_title_img);
        this.kFL.setDefaultBgResource(R.drawable.tb_launcher_icon);
        this.kFL.setAutoChangeStyle(false);
        this.kFM = (TextView) findViewById(R.id.push_dialog_title_text);
        this.kFO = (TextView) findViewById(R.id.push_dialog_content_title);
        this.kFQ = (ClickableHeaderImageView) findViewById(R.id.push_dialog_user_head);
        this.kFQ.setBorderSurroundContent(true);
        this.kFQ.setIsRound(true);
        this.kFQ.setEnabled(false);
        this.kFQ.setAutoChangeStyle(false);
        this.kFQ.setBorderWidth(l.getDimens(this.kFD, R.dimen.tbds1));
        this.kFQ.setBorderColor(ContextCompat.getColor(this.kFD, R.color.black_alpha15));
        this.kFV = new com.baidu.tbadk.widget.richText.a();
        this.iRl = (TbRichTextView) findViewById(R.id.push_dialog_content);
        this.iRl.setTextColor(ContextCompat.getColor(this.kFD, R.color.cp_cont_j));
        this.kFV.oe(l.getDimens(this.kFD, R.dimen.tbds38));
        this.kFV.setTextSize(l.getDimens(this.kFD, R.dimen.tbds42));
        this.kFV.oi(l.getDimens(this.kFD, R.dimen.tbds23));
        this.kFV.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.kFV.bb(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.iRl.setLayoutStrategy(this.kFV);
        this.kFP = (PushDialogVideoView) findViewById(R.id.push_dialog_video);
        this.kFP.setPageContext(this.kFD.getPageContext());
        this.aFR = (TextView) findViewById(R.id.push_dialog_user_name);
        this.kFR = (TextView) findViewById(R.id.push_dialog_user_god_info);
        this.kFS = (CommonUserLikeButton) findViewById(R.id.push_dialog_user_like_btn);
        this.kFS.setAfterOnClickListener(this);
        this.kFN = (ImageView) findViewById(R.id.dialog_close_btn);
        this.kFN.setOnClickListener(this);
    }

    public void onResume() {
        if (this.kFP != null) {
            this.kFP.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.kFD.findViewById(i);
    }

    public void cTh() {
        if (this.kFP != null) {
            this.kFP.setNetworkChange();
            if (j.isMobileNet() && this.kFP.pO() && this.kFH != null && this.kFH.getFileSize() > 0 && this.kFH.getDuration() > 0) {
                float fileSize = this.kFH.getFileSize() * (1.0f - ((this.kFP.getCurrentPosition() * 1.0f) / (this.kFH.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.kFD.getPageContext().getPageActivity(), String.format(this.kFD.getPageContext().getString(R.string.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int dimens;
        int dimens2;
        if (aVar != null) {
            this.kFL.startLoad(aVar.cTj(), 17, false);
            this.kFM.setText(aVar.cTi());
            if (aVar.cTl() != null) {
                this.kFQ.setData(aVar.cTl());
                this.aFR.setText(aVar.cTl().getName_show());
                if (aVar.cTl().getGodUserData() != null && (!StringUtils.isNull(aVar.cTl().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.cTl().getGodUserData().getIntro()))) {
                    this.kFR.setText(aVar.cTl().getGodUserData().getForumName() + "吧 " + aVar.cTl().getGodIntro());
                    this.kFR.setVisibility(0);
                } else {
                    this.kFR.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.cTl().getUserId())) {
                    this.kFS.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.kFD.getPageContext(), this.kFS).a(aVar.cTl());
                    this.kFS.onChangeSkinType(0);
                    this.kFS.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b cTk = aVar.cTk();
                if (cTk == null) {
                    this.kFD.cSX().dhA();
                    this.kFD.finish();
                    return;
                }
                boolean z = cTk.cTm() == null || v.isEmpty(cTk.cTm().biq());
                if (StringUtils.isNull(cTk.getTitle()) && z) {
                    this.kFD.cSX().dhA();
                    this.kFD.finish();
                    return;
                }
                if (cTk.cTm() != null) {
                    Iterator<TbRichTextData> it = cTk.cTm().biq().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.kFH = next.biA();
                        }
                        if (this.kFH != null) {
                            break;
                        }
                    }
                }
                this.tid = cTk.getTid();
                if (this.kFH == null) {
                    this.kFP.setVisibility(8);
                    this.iRl.setVisibility(0);
                    boolean z2 = j.is4GNet() || j.isWifiNet();
                    this.kFV.iG(z2);
                    if (z2) {
                        dimens = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(this.kFD, R.dimen.tbds22) * 2)) - (l.getDimens(this.kFD, R.dimen.tbds44) * 2);
                        dimens2 = (int) (dimens * 1.618f);
                    } else {
                        dimens = l.getDimens(this.kFD, R.dimen.tbds360);
                        dimens2 = l.getDimens(this.kFD, R.dimen.tbds202);
                    }
                    this.kFV.iH(z2);
                    this.kFV.nZ(dimens);
                    this.kFV.oa(dimens2);
                    this.iRl.setText(cTk.cTm());
                } else {
                    this.iRl.setVisibility(8);
                    this.kFP.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kFP.getLayoutParams();
                    layoutParams.width = l.getEquipmentWidth(this.kFD) - l.getDimens(this.kFD, R.dimen.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.kFP.setLayoutParams(layoutParams);
                    this.kFP.setTbRichTextVideoInfo(this.kFH);
                    this.kFP.stopPlay();
                    this.kFP.setIsNeedRecoveryVideoPlayer(true);
                    this.kFP.setThumbnail(this.kFH.getThumbUrl());
                    this.kFP.setVideoUrl(this.kFH.getVideoUrl(), String.valueOf(this.tid));
                    this.kFP.chf();
                    n nVar = new n(this.kFD.getActivity());
                    nVar.Ky("2");
                    y yVar = new y();
                    yVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    yVar.ais = String.valueOf(this.tid);
                    yVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    nVar.setVideoStatsData(yVar);
                    this.kFP.setQuickVideoViewBusiness(nVar);
                }
                if (StringUtils.isNull(cTk.getTitle())) {
                    this.kFO.setVisibility(8);
                } else {
                    this.kFO.setText(cTk.getTitle());
                    this.kFO.setVisibility(0);
                }
                this.kFU.setText(String.format(Locale.CHINA, this.kFD.getString(R.string.bottom_comment), Integer.valueOf(cTk.getPostNum())));
                if (!this.kFD.cSX().dhD()) {
                    this.kFD.cSX().dhB();
                    return;
                }
                return;
            }
            this.kFD.cSX().dhA();
            this.kFD.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kFN) {
            TiebaStatic.log(new an("c13198").dh("tid", this.kFD.getTid()));
            e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.kFD != null && c.this.kFD.cSX() != null) {
                        c.this.kFD.cSX().dhA();
                    }
                }
            }, 100L);
            this.kFD.finish();
        } else if (view == this.kFT) {
            TiebaStatic.log(new an("c13199").ag("obj_locate", 4).dh("tid", this.kFD.getTid()));
            if (this.tid == 0) {
                this.kFD.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.kFD).createNormalCfg(this.tid + "", null, null)));
            this.kFD.cSX().dhB();
            this.kFD.finish();
        } else if (view == this.kFS) {
            TiebaStatic.log(new an("c13199").ag("obj_locate", 3).dh("tid", this.kFD.getTid()));
        }
    }

    public void onPause() {
        if (this.kFP != null) {
            this.kFP.onPause();
        }
    }

    public void onDestroy() {
        if (this.kFP != null) {
            this.kFP.onDestroy();
        }
    }
}
