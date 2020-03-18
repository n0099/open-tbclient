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
    private TextView ahY;
    private EditorScrollView drX;
    private TbRichTextView hSA;
    private final PushDialogActivity jDL;
    private i jDP;
    private Drawable jDR;
    private View jDS;
    private TbImageView jDT;
    private TextView jDU;
    private ImageView jDV;
    private TextView jDW;
    private PushDialogVideoView jDX;
    private ClickableHeaderImageView jDY;
    private TextView jDZ;
    private CommonUserLikeButton jEa;
    private View jEb;
    private TextView jEc;
    private com.baidu.tbadk.widget.richText.a jEd;
    private boolean jEe = false;
    private View mRootView;
    private long tid;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.jDL = pushDialogActivity;
        this.jDL.setContentView(i);
        this.mRootView = findViewById(R.id.root_view);
        this.jDS = findViewById(R.id.dialog_wrapper_view);
        this.drX = (EditorScrollView) findViewById(R.id.push_dialog_content_layout);
        this.drX.setOverScrollMode(2);
        this.drX.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.jEe) {
                    TiebaStatic.log(new an("c13199").X("obj_locate", 1).cx("tid", c.this.jDL.getTid()));
                    c.this.jEe = true;
                }
            }
        });
        if (this.jDS.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jDS.getLayoutParams();
            int equipmentHeight = l.getEquipmentHeight(this.jDL);
            layoutParams.height = equipmentHeight / 2;
            layoutParams.topMargin = (int) (equipmentHeight * 0.22f);
            this.jDS.postInvalidate();
        }
        if (l.isFlymeOsAbove35()) {
            this.jDR = com.baidu.tieba.v.b.cPw();
            if (this.jDR != null && this.jDL.getWindow() != null) {
                this.jDL.getWindow().setBackgroundDrawable(this.jDR);
            }
        }
        this.jEb = findViewById(R.id.push_dialog_bottom_layout);
        this.jEb.setOnClickListener(this);
        this.jEc = (TextView) findViewById(R.id.comment_num);
        this.jDT = (TbImageView) findViewById(R.id.push_dialog_title_img);
        this.jDT.setDefaultBgResource(R.drawable.tb_launcher_icon);
        this.jDT.setAutoChangeStyle(false);
        this.jDU = (TextView) findViewById(R.id.push_dialog_title_text);
        this.jDW = (TextView) findViewById(R.id.push_dialog_content_title);
        this.jDY = (ClickableHeaderImageView) findViewById(R.id.push_dialog_user_head);
        this.jDY.setBorderSurroundContent(true);
        this.jDY.setIsRound(true);
        this.jDY.setEnabled(false);
        this.jDY.setAutoChangeStyle(false);
        this.jDY.setBorderWidth(l.getDimens(this.jDL, R.dimen.tbds1));
        this.jDY.setBorderColor(ContextCompat.getColor(this.jDL, R.color.black_alpha15));
        this.jEd = new com.baidu.tbadk.widget.richText.a();
        this.hSA = (TbRichTextView) findViewById(R.id.push_dialog_content);
        this.hSA.setTextColor(ContextCompat.getColor(this.jDL, R.color.cp_cont_j));
        this.jEd.np(l.getDimens(this.jDL, R.dimen.tbds38));
        this.jEd.setTextSize(l.getDimens(this.jDL, R.dimen.tbds42));
        this.jEd.nt(l.getDimens(this.jDL, R.dimen.tbds23));
        this.jEd.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.jEd.aT(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.hSA.setLayoutStrategy(this.jEd);
        this.jDX = (PushDialogVideoView) findViewById(R.id.push_dialog_video);
        this.jDX.setPageContext(this.jDL.getPageContext());
        this.ahY = (TextView) findViewById(R.id.push_dialog_user_name);
        this.jDZ = (TextView) findViewById(R.id.push_dialog_user_god_info);
        this.jEa = (CommonUserLikeButton) findViewById(R.id.push_dialog_user_like_btn);
        this.jEa.setAfterOnClickListener(this);
        this.jDV = (ImageView) findViewById(R.id.dialog_close_btn);
        this.jDV.setOnClickListener(this);
    }

    public void onResume() {
        if (this.jDX != null) {
            this.jDX.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.jDL.findViewById(i);
    }

    public void cBK() {
        if (this.jDX != null) {
            this.jDX.setNetworkChange();
            if (j.isMobileNet() && this.jDX.le() && this.jDP != null && this.jDP.getFileSize() > 0 && this.jDP.getDuration() > 0) {
                float fileSize = this.jDP.getFileSize() * (1.0f - ((this.jDX.getCurrentPosition() * 1.0f) / (this.jDP.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.jDL.getPageContext().getPageActivity(), String.format(this.jDL.getPageContext().getString(R.string.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int dimens;
        int dimens2;
        if (aVar != null) {
            this.jDT.startLoad(aVar.cBM(), 17, false);
            this.jDU.setText(aVar.cBL());
            if (aVar.cBO() != null) {
                this.jDY.setData(aVar.cBO());
                this.ahY.setText(aVar.cBO().getName_show());
                if (aVar.cBO().getGodUserData() != null && (!StringUtils.isNull(aVar.cBO().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.cBO().getGodUserData().getIntro()))) {
                    this.jDZ.setText(aVar.cBO().getGodUserData().getForumName() + "吧 " + aVar.cBO().getGodIntro());
                    this.jDZ.setVisibility(0);
                } else {
                    this.jDZ.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.cBO().getUserId())) {
                    this.jEa.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.jDL.getPageContext(), this.jEa).a(aVar.cBO());
                    this.jEa.onChangeSkinType(0);
                    this.jEa.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b cBN = aVar.cBN();
                if (cBN == null) {
                    this.jDL.cBA().cPs();
                    this.jDL.finish();
                    return;
                }
                boolean z = cBN.cBP() == null || v.isEmpty(cBN.cBP().aTX());
                if (StringUtils.isNull(cBN.getTitle()) && z) {
                    this.jDL.cBA().cPs();
                    this.jDL.finish();
                    return;
                }
                if (cBN.cBP() != null) {
                    Iterator<TbRichTextData> it = cBN.cBP().aTX().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.jDP = next.aUh();
                        }
                        if (this.jDP != null) {
                            break;
                        }
                    }
                }
                this.tid = cBN.getTid();
                if (this.jDP == null) {
                    this.jDX.setVisibility(8);
                    this.hSA.setVisibility(0);
                    boolean z2 = j.is4GNet() || j.isWifiNet();
                    this.jEd.hl(z2);
                    if (z2) {
                        dimens = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(this.jDL, R.dimen.tbds22) * 2)) - (l.getDimens(this.jDL, R.dimen.tbds44) * 2);
                        dimens2 = (int) (dimens * 1.618f);
                    } else {
                        dimens = l.getDimens(this.jDL, R.dimen.tbds360);
                        dimens2 = l.getDimens(this.jDL, R.dimen.tbds202);
                    }
                    this.jEd.hm(z2);
                    this.jEd.nk(dimens);
                    this.jEd.nl(dimens2);
                    this.hSA.setText(cBN.cBP());
                } else {
                    this.hSA.setVisibility(8);
                    this.jDX.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jDX.getLayoutParams();
                    layoutParams.width = l.getEquipmentWidth(this.jDL) - l.getDimens(this.jDL, R.dimen.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.jDX.setLayoutParams(layoutParams);
                    this.jDX.setTbRichTextVideoInfo(this.jDP);
                    this.jDX.stopPlay();
                    this.jDX.setIsNeedRecoveryVideoPlayer(true);
                    this.jDX.setThumbnail(this.jDP.getThumbUrl());
                    this.jDX.setVideoUrl(this.jDP.getVideoUrl(), String.valueOf(this.tid));
                    this.jDX.bQh();
                    n nVar = new n(this.jDL.getActivity());
                    nVar.Hb("2");
                    y yVar = new y();
                    yVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    yVar.Pk = String.valueOf(this.tid);
                    yVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    nVar.setVideoStatsData(yVar);
                    this.jDX.setQuickVideoViewBusiness(nVar);
                }
                if (StringUtils.isNull(cBN.getTitle())) {
                    this.jDW.setVisibility(8);
                } else {
                    this.jDW.setText(cBN.getTitle());
                    this.jDW.setVisibility(0);
                }
                this.jEc.setText(String.format(Locale.CHINA, this.jDL.getString(R.string.bottom_comment), Integer.valueOf(cBN.getPostNum())));
                if (!this.jDL.cBA().cPv()) {
                    this.jDL.cBA().cPt();
                    return;
                }
                return;
            }
            this.jDL.cBA().cPs();
            this.jDL.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jDV) {
            TiebaStatic.log(new an("c13198").cx("tid", this.jDL.getTid()));
            e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.jDL != null && c.this.jDL.cBA() != null) {
                        c.this.jDL.cBA().cPs();
                    }
                }
            }, 100L);
            this.jDL.finish();
        } else if (view == this.jEb) {
            TiebaStatic.log(new an("c13199").X("obj_locate", 4).cx("tid", this.jDL.getTid()));
            if (this.tid == 0) {
                this.jDL.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.jDL).createNormalCfg(this.tid + "", null, null)));
            this.jDL.cBA().cPt();
            this.jDL.finish();
        } else if (view == this.jEa) {
            TiebaStatic.log(new an("c13199").X("obj_locate", 3).cx("tid", this.jDL.getTid()));
        }
    }

    public void onPause() {
        if (this.jDX != null) {
            this.jDX.onPause();
        }
    }

    public void onDestroy() {
        if (this.jDX != null) {
            this.jDX.onDestroy();
        }
    }
}
