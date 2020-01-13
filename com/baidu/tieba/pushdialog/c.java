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
/* loaded from: classes6.dex */
public class c implements View.OnClickListener {
    private TextView afG;
    private EditorScrollView dnm;
    private TbRichTextView hOO;
    private final PushDialogActivity jBc;
    private i jBg;
    private Drawable jBi;
    private View jBj;
    private TbImageView jBk;
    private TextView jBl;
    private ImageView jBm;
    private TextView jBn;
    private PushDialogVideoView jBo;
    private ClickableHeaderImageView jBp;
    private TextView jBq;
    private CommonUserLikeButton jBr;
    private View jBs;
    private TextView jBt;
    private com.baidu.tbadk.widget.richText.a jBu;
    private boolean jBv = false;
    private View mRootView;
    private long tid;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.jBc = pushDialogActivity;
        this.jBc.setContentView(i);
        this.mRootView = findViewById(R.id.root_view);
        this.jBj = findViewById(R.id.dialog_wrapper_view);
        this.dnm = (EditorScrollView) findViewById(R.id.push_dialog_content_layout);
        this.dnm.setOverScrollMode(2);
        this.dnm.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.jBv) {
                    TiebaStatic.log(new an("c13199").Z("obj_locate", 1).cp("tid", c.this.jBc.getTid()));
                    c.this.jBv = true;
                }
            }
        });
        if (this.jBj.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jBj.getLayoutParams();
            int equipmentHeight = l.getEquipmentHeight(this.jBc);
            layoutParams.height = equipmentHeight / 2;
            layoutParams.topMargin = (int) (equipmentHeight * 0.22f);
            this.jBj.postInvalidate();
        }
        if (l.isFlymeOsAbove35()) {
            this.jBi = com.baidu.tieba.u.b.cNC();
            if (this.jBi != null && this.jBc.getWindow() != null) {
                this.jBc.getWindow().setBackgroundDrawable(this.jBi);
            }
        }
        this.jBs = findViewById(R.id.push_dialog_bottom_layout);
        this.jBs.setOnClickListener(this);
        this.jBt = (TextView) findViewById(R.id.comment_num);
        this.jBk = (TbImageView) findViewById(R.id.push_dialog_title_img);
        this.jBk.setDefaultBgResource(R.drawable.tb_launcher_icon);
        this.jBk.setAutoChangeStyle(false);
        this.jBl = (TextView) findViewById(R.id.push_dialog_title_text);
        this.jBn = (TextView) findViewById(R.id.push_dialog_content_title);
        this.jBp = (ClickableHeaderImageView) findViewById(R.id.push_dialog_user_head);
        this.jBp.setBorderSurroundContent(true);
        this.jBp.setIsRound(true);
        this.jBp.setEnabled(false);
        this.jBp.setAutoChangeStyle(false);
        this.jBp.setBorderWidth(l.getDimens(this.jBc, R.dimen.tbds1));
        this.jBp.setBorderColor(ContextCompat.getColor(this.jBc, R.color.black_alpha15));
        this.jBu = new com.baidu.tbadk.widget.richText.a();
        this.hOO = (TbRichTextView) findViewById(R.id.push_dialog_content);
        this.hOO.setTextColor(ContextCompat.getColor(this.jBc, R.color.cp_cont_j));
        this.jBu.mW(l.getDimens(this.jBc, R.dimen.tbds38));
        this.jBu.setTextSize(l.getDimens(this.jBc, R.dimen.tbds42));
        this.jBu.na(l.getDimens(this.jBc, R.dimen.tbds23));
        this.jBu.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.jBu.aS(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.hOO.setLayoutStrategy(this.jBu);
        this.jBo = (PushDialogVideoView) findViewById(R.id.push_dialog_video);
        this.jBo.setPageContext(this.jBc.getPageContext());
        this.afG = (TextView) findViewById(R.id.push_dialog_user_name);
        this.jBq = (TextView) findViewById(R.id.push_dialog_user_god_info);
        this.jBr = (CommonUserLikeButton) findViewById(R.id.push_dialog_user_like_btn);
        this.jBr.setAfterOnClickListener(this);
        this.jBm = (ImageView) findViewById(R.id.dialog_close_btn);
        this.jBm.setOnClickListener(this);
    }

    public void onResume() {
        if (this.jBo != null) {
            this.jBo.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.jBc.findViewById(i);
    }

    public void czQ() {
        if (this.jBo != null) {
            this.jBo.setNetworkChange();
            if (j.isMobileNet() && this.jBo.kP() && this.jBg != null && this.jBg.getFileSize() > 0 && this.jBg.getDuration() > 0) {
                float fileSize = this.jBg.getFileSize() * (1.0f - ((this.jBo.getCurrentPosition() * 1.0f) / (this.jBg.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.jBc.getPageContext().getPageActivity(), String.format(this.jBc.getPageContext().getString(R.string.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int dimens;
        int dimens2;
        if (aVar != null) {
            this.jBk.startLoad(aVar.czS(), 17, false);
            this.jBl.setText(aVar.czR());
            if (aVar.czU() != null) {
                this.jBp.setData(aVar.czU());
                this.afG.setText(aVar.czU().getName_show());
                if (aVar.czU().getGodUserData() != null && (!StringUtils.isNull(aVar.czU().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.czU().getGodUserData().getIntro()))) {
                    this.jBq.setText(aVar.czU().getGodUserData().getForumName() + "吧 " + aVar.czU().getGodIntro());
                    this.jBq.setVisibility(0);
                } else {
                    this.jBq.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.czU().getUserId())) {
                    this.jBr.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.jBc.getPageContext(), this.jBr).a(aVar.czU());
                    this.jBr.onChangeSkinType(0);
                    this.jBr.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b czT = aVar.czT();
                if (czT == null) {
                    this.jBc.czG().cNy();
                    this.jBc.finish();
                    return;
                }
                boolean z = czT.czV() == null || v.isEmpty(czT.czV().aRz());
                if (StringUtils.isNull(czT.getTitle()) && z) {
                    this.jBc.czG().cNy();
                    this.jBc.finish();
                    return;
                }
                if (czT.czV() != null) {
                    Iterator<TbRichTextData> it = czT.czV().aRz().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.jBg = next.aRJ();
                        }
                        if (this.jBg != null) {
                            break;
                        }
                    }
                }
                this.tid = czT.getTid();
                if (this.jBg == null) {
                    this.jBo.setVisibility(8);
                    this.hOO.setVisibility(0);
                    boolean z2 = j.is4GNet() || j.isWifiNet();
                    this.jBu.hd(z2);
                    if (z2) {
                        dimens = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(this.jBc, R.dimen.tbds22) * 2)) - (l.getDimens(this.jBc, R.dimen.tbds44) * 2);
                        dimens2 = (int) (dimens * 1.618f);
                    } else {
                        dimens = l.getDimens(this.jBc, R.dimen.tbds360);
                        dimens2 = l.getDimens(this.jBc, R.dimen.tbds202);
                    }
                    this.jBu.he(z2);
                    this.jBu.mR(dimens);
                    this.jBu.mS(dimens2);
                    this.hOO.setText(czT.czV());
                } else {
                    this.hOO.setVisibility(8);
                    this.jBo.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jBo.getLayoutParams();
                    layoutParams.width = l.getEquipmentWidth(this.jBc) - l.getDimens(this.jBc, R.dimen.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.jBo.setLayoutParams(layoutParams);
                    this.jBo.setTbRichTextVideoInfo(this.jBg);
                    this.jBo.stopPlay();
                    this.jBo.setIsNeedRecoveryVideoPlayer(true);
                    this.jBo.setThumbnail(this.jBg.getThumbUrl());
                    this.jBo.setVideoUrl(this.jBg.getVideoUrl(), String.valueOf(this.tid));
                    this.jBo.bOk();
                    n nVar = new n(this.jBc.getActivity());
                    nVar.GN("2");
                    y yVar = new y();
                    yVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    yVar.OG = String.valueOf(this.tid);
                    yVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    nVar.setVideoStatsData(yVar);
                    this.jBo.setQuickVideoViewBusiness(nVar);
                }
                if (StringUtils.isNull(czT.getTitle())) {
                    this.jBn.setVisibility(8);
                } else {
                    this.jBn.setText(czT.getTitle());
                    this.jBn.setVisibility(0);
                }
                this.jBt.setText(String.format(Locale.CHINA, this.jBc.getString(R.string.bottom_comment), Integer.valueOf(czT.getPostNum())));
                if (!this.jBc.czG().cNB()) {
                    this.jBc.czG().cNz();
                    return;
                }
                return;
            }
            this.jBc.czG().cNy();
            this.jBc.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jBm) {
            TiebaStatic.log(new an("c13198").cp("tid", this.jBc.getTid()));
            e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.jBc != null && c.this.jBc.czG() != null) {
                        c.this.jBc.czG().cNy();
                    }
                }
            }, 100L);
            this.jBc.finish();
        } else if (view == this.jBs) {
            TiebaStatic.log(new an("c13199").Z("obj_locate", 4).cp("tid", this.jBc.getTid()));
            if (this.tid == 0) {
                this.jBc.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.jBc).createNormalCfg(this.tid + "", null, null)));
            this.jBc.czG().cNz();
            this.jBc.finish();
        } else if (view == this.jBr) {
            TiebaStatic.log(new an("c13199").Z("obj_locate", 3).cp("tid", this.jBc.getTid()));
        }
    }

    public void onPause() {
        if (this.jBo != null) {
            this.jBo.onPause();
        }
    }

    public void onDestroy() {
        if (this.jBo != null) {
            this.jBo.onDestroy();
        }
    }
}
