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
    private TextView aAy;
    private EditorScrollView dRY;
    private TbRichTextView iCx;
    private final PushDialogActivity knI;
    private i knM;
    private Drawable knO;
    private View knP;
    private TbImageView knQ;
    private TextView knR;
    private ImageView knS;
    private TextView knT;
    private PushDialogVideoView knU;
    private ClickableHeaderImageView knV;
    private TextView knW;
    private CommonUserLikeButton knX;
    private View knY;
    private TextView knZ;
    private com.baidu.tbadk.widget.richText.a koa;
    private boolean kob = false;
    private View mRootView;
    private long tid;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.knI = pushDialogActivity;
        this.knI.setContentView(i);
        this.mRootView = findViewById(R.id.root_view);
        this.knP = findViewById(R.id.dialog_wrapper_view);
        this.dRY = (EditorScrollView) findViewById(R.id.push_dialog_content_layout);
        this.dRY.setOverScrollMode(2);
        this.dRY.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.kob) {
                    TiebaStatic.log(new an("c13199").af("obj_locate", 1).cI("tid", c.this.knI.getTid()));
                    c.this.kob = true;
                }
            }
        });
        if (this.knP.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.knP.getLayoutParams();
            int equipmentHeight = l.getEquipmentHeight(this.knI);
            layoutParams.height = equipmentHeight / 2;
            layoutParams.topMargin = (int) (equipmentHeight * 0.22f);
            this.knP.postInvalidate();
        }
        if (l.isFlymeOsAbove35()) {
            this.knO = com.baidu.tieba.v.b.dap();
            if (this.knO != null && this.knI.getWindow() != null) {
                this.knI.getWindow().setBackgroundDrawable(this.knO);
            }
        }
        this.knY = findViewById(R.id.push_dialog_bottom_layout);
        this.knY.setOnClickListener(this);
        this.knZ = (TextView) findViewById(R.id.comment_num);
        this.knQ = (TbImageView) findViewById(R.id.push_dialog_title_img);
        this.knQ.setDefaultBgResource(R.drawable.tb_launcher_icon);
        this.knQ.setAutoChangeStyle(false);
        this.knR = (TextView) findViewById(R.id.push_dialog_title_text);
        this.knT = (TextView) findViewById(R.id.push_dialog_content_title);
        this.knV = (ClickableHeaderImageView) findViewById(R.id.push_dialog_user_head);
        this.knV.setBorderSurroundContent(true);
        this.knV.setIsRound(true);
        this.knV.setEnabled(false);
        this.knV.setAutoChangeStyle(false);
        this.knV.setBorderWidth(l.getDimens(this.knI, R.dimen.tbds1));
        this.knV.setBorderColor(ContextCompat.getColor(this.knI, R.color.black_alpha15));
        this.koa = new com.baidu.tbadk.widget.richText.a();
        this.iCx = (TbRichTextView) findViewById(R.id.push_dialog_content);
        this.iCx.setTextColor(ContextCompat.getColor(this.knI, R.color.cp_cont_j));
        this.koa.nB(l.getDimens(this.knI, R.dimen.tbds38));
        this.koa.setTextSize(l.getDimens(this.knI, R.dimen.tbds42));
        this.koa.nF(l.getDimens(this.knI, R.dimen.tbds23));
        this.koa.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.koa.aX(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.iCx.setLayoutStrategy(this.koa);
        this.knU = (PushDialogVideoView) findViewById(R.id.push_dialog_video);
        this.knU.setPageContext(this.knI.getPageContext());
        this.aAy = (TextView) findViewById(R.id.push_dialog_user_name);
        this.knW = (TextView) findViewById(R.id.push_dialog_user_god_info);
        this.knX = (CommonUserLikeButton) findViewById(R.id.push_dialog_user_like_btn);
        this.knX.setAfterOnClickListener(this);
        this.knS = (ImageView) findViewById(R.id.dialog_close_btn);
        this.knS.setOnClickListener(this);
    }

    public void onResume() {
        if (this.knU != null) {
            this.knU.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.knI.findViewById(i);
    }

    public void cMg() {
        if (this.knU != null) {
            this.knU.setNetworkChange();
            if (j.isMobileNet() && this.knU.pI() && this.knM != null && this.knM.getFileSize() > 0 && this.knM.getDuration() > 0) {
                float fileSize = this.knM.getFileSize() * (1.0f - ((this.knU.getCurrentPosition() * 1.0f) / (this.knM.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.knI.getPageContext().getPageActivity(), String.format(this.knI.getPageContext().getString(R.string.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int dimens;
        int dimens2;
        if (aVar != null) {
            this.knQ.startLoad(aVar.cMi(), 17, false);
            this.knR.setText(aVar.cMh());
            if (aVar.cMk() != null) {
                this.knV.setData(aVar.cMk());
                this.aAy.setText(aVar.cMk().getName_show());
                if (aVar.cMk().getGodUserData() != null && (!StringUtils.isNull(aVar.cMk().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.cMk().getGodUserData().getIntro()))) {
                    this.knW.setText(aVar.cMk().getGodUserData().getForumName() + "吧 " + aVar.cMk().getGodIntro());
                    this.knW.setVisibility(0);
                } else {
                    this.knW.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.cMk().getUserId())) {
                    this.knX.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.knI.getPageContext(), this.knX).a(aVar.cMk());
                    this.knX.onChangeSkinType(0);
                    this.knX.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b cMj = aVar.cMj();
                if (cMj == null) {
                    this.knI.cLW().dal();
                    this.knI.finish();
                    return;
                }
                boolean z = cMj.cMl() == null || v.isEmpty(cMj.cMl().bcf());
                if (StringUtils.isNull(cMj.getTitle()) && z) {
                    this.knI.cLW().dal();
                    this.knI.finish();
                    return;
                }
                if (cMj.cMl() != null) {
                    Iterator<TbRichTextData> it = cMj.cMl().bcf().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.knM = next.bcp();
                        }
                        if (this.knM != null) {
                            break;
                        }
                    }
                }
                this.tid = cMj.getTid();
                if (this.knM == null) {
                    this.knU.setVisibility(8);
                    this.iCx.setVisibility(0);
                    boolean z2 = j.is4GNet() || j.isWifiNet();
                    this.koa.ij(z2);
                    if (z2) {
                        dimens = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(this.knI, R.dimen.tbds22) * 2)) - (l.getDimens(this.knI, R.dimen.tbds44) * 2);
                        dimens2 = (int) (dimens * 1.618f);
                    } else {
                        dimens = l.getDimens(this.knI, R.dimen.tbds360);
                        dimens2 = l.getDimens(this.knI, R.dimen.tbds202);
                    }
                    this.koa.ik(z2);
                    this.koa.nw(dimens);
                    this.koa.nx(dimens2);
                    this.iCx.setText(cMj.cMl());
                } else {
                    this.iCx.setVisibility(8);
                    this.knU.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.knU.getLayoutParams();
                    layoutParams.width = l.getEquipmentWidth(this.knI) - l.getDimens(this.knI, R.dimen.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.knU.setLayoutParams(layoutParams);
                    this.knU.setTbRichTextVideoInfo(this.knM);
                    this.knU.stopPlay();
                    this.knU.setIsNeedRecoveryVideoPlayer(true);
                    this.knU.setThumbnail(this.knM.getThumbUrl());
                    this.knU.setVideoUrl(this.knM.getVideoUrl(), String.valueOf(this.tid));
                    this.knU.caF();
                    n nVar = new n(this.knI.getActivity());
                    nVar.IM("2");
                    y yVar = new y();
                    yVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    yVar.ahO = String.valueOf(this.tid);
                    yVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    nVar.setVideoStatsData(yVar);
                    this.knU.setQuickVideoViewBusiness(nVar);
                }
                if (StringUtils.isNull(cMj.getTitle())) {
                    this.knT.setVisibility(8);
                } else {
                    this.knT.setText(cMj.getTitle());
                    this.knT.setVisibility(0);
                }
                this.knZ.setText(String.format(Locale.CHINA, this.knI.getString(R.string.bottom_comment), Integer.valueOf(cMj.getPostNum())));
                if (!this.knI.cLW().dao()) {
                    this.knI.cLW().dam();
                    return;
                }
                return;
            }
            this.knI.cLW().dal();
            this.knI.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.knS) {
            TiebaStatic.log(new an("c13198").cI("tid", this.knI.getTid()));
            e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.knI != null && c.this.knI.cLW() != null) {
                        c.this.knI.cLW().dal();
                    }
                }
            }, 100L);
            this.knI.finish();
        } else if (view == this.knY) {
            TiebaStatic.log(new an("c13199").af("obj_locate", 4).cI("tid", this.knI.getTid()));
            if (this.tid == 0) {
                this.knI.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.knI).createNormalCfg(this.tid + "", null, null)));
            this.knI.cLW().dam();
            this.knI.finish();
        } else if (view == this.knX) {
            TiebaStatic.log(new an("c13199").af("obj_locate", 3).cI("tid", this.knI.getTid()));
        }
    }

    public void onPause() {
        if (this.knU != null) {
            this.knU.onPause();
        }
    }

    public void onDestroy() {
        if (this.knU != null) {
            this.knU.onDestroy();
        }
    }
}
