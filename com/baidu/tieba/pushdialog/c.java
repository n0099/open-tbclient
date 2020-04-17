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
    private TextView aAs;
    private EditorScrollView dRT;
    private TbRichTextView iCr;
    private final PushDialogActivity knE;
    private i knI;
    private Drawable knK;
    private View knL;
    private TbImageView knM;
    private TextView knN;
    private ImageView knO;
    private TextView knP;
    private PushDialogVideoView knQ;
    private ClickableHeaderImageView knR;
    private TextView knS;
    private CommonUserLikeButton knT;
    private View knU;
    private TextView knV;
    private com.baidu.tbadk.widget.richText.a knW;
    private boolean knX = false;
    private View mRootView;
    private long tid;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.knE = pushDialogActivity;
        this.knE.setContentView(i);
        this.mRootView = findViewById(R.id.root_view);
        this.knL = findViewById(R.id.dialog_wrapper_view);
        this.dRT = (EditorScrollView) findViewById(R.id.push_dialog_content_layout);
        this.dRT.setOverScrollMode(2);
        this.dRT.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.knX) {
                    TiebaStatic.log(new an("c13199").af("obj_locate", 1).cI("tid", c.this.knE.getTid()));
                    c.this.knX = true;
                }
            }
        });
        if (this.knL.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.knL.getLayoutParams();
            int equipmentHeight = l.getEquipmentHeight(this.knE);
            layoutParams.height = equipmentHeight / 2;
            layoutParams.topMargin = (int) (equipmentHeight * 0.22f);
            this.knL.postInvalidate();
        }
        if (l.isFlymeOsAbove35()) {
            this.knK = com.baidu.tieba.v.b.das();
            if (this.knK != null && this.knE.getWindow() != null) {
                this.knE.getWindow().setBackgroundDrawable(this.knK);
            }
        }
        this.knU = findViewById(R.id.push_dialog_bottom_layout);
        this.knU.setOnClickListener(this);
        this.knV = (TextView) findViewById(R.id.comment_num);
        this.knM = (TbImageView) findViewById(R.id.push_dialog_title_img);
        this.knM.setDefaultBgResource(R.drawable.tb_launcher_icon);
        this.knM.setAutoChangeStyle(false);
        this.knN = (TextView) findViewById(R.id.push_dialog_title_text);
        this.knP = (TextView) findViewById(R.id.push_dialog_content_title);
        this.knR = (ClickableHeaderImageView) findViewById(R.id.push_dialog_user_head);
        this.knR.setBorderSurroundContent(true);
        this.knR.setIsRound(true);
        this.knR.setEnabled(false);
        this.knR.setAutoChangeStyle(false);
        this.knR.setBorderWidth(l.getDimens(this.knE, R.dimen.tbds1));
        this.knR.setBorderColor(ContextCompat.getColor(this.knE, R.color.black_alpha15));
        this.knW = new com.baidu.tbadk.widget.richText.a();
        this.iCr = (TbRichTextView) findViewById(R.id.push_dialog_content);
        this.iCr.setTextColor(ContextCompat.getColor(this.knE, R.color.cp_cont_j));
        this.knW.nB(l.getDimens(this.knE, R.dimen.tbds38));
        this.knW.setTextSize(l.getDimens(this.knE, R.dimen.tbds42));
        this.knW.nF(l.getDimens(this.knE, R.dimen.tbds23));
        this.knW.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.knW.aX(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.iCr.setLayoutStrategy(this.knW);
        this.knQ = (PushDialogVideoView) findViewById(R.id.push_dialog_video);
        this.knQ.setPageContext(this.knE.getPageContext());
        this.aAs = (TextView) findViewById(R.id.push_dialog_user_name);
        this.knS = (TextView) findViewById(R.id.push_dialog_user_god_info);
        this.knT = (CommonUserLikeButton) findViewById(R.id.push_dialog_user_like_btn);
        this.knT.setAfterOnClickListener(this);
        this.knO = (ImageView) findViewById(R.id.dialog_close_btn);
        this.knO.setOnClickListener(this);
    }

    public void onResume() {
        if (this.knQ != null) {
            this.knQ.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.knE.findViewById(i);
    }

    public void cMj() {
        if (this.knQ != null) {
            this.knQ.setNetworkChange();
            if (j.isMobileNet() && this.knQ.pI() && this.knI != null && this.knI.getFileSize() > 0 && this.knI.getDuration() > 0) {
                float fileSize = this.knI.getFileSize() * (1.0f - ((this.knQ.getCurrentPosition() * 1.0f) / (this.knI.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.knE.getPageContext().getPageActivity(), String.format(this.knE.getPageContext().getString(R.string.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int dimens;
        int dimens2;
        if (aVar != null) {
            this.knM.startLoad(aVar.cMl(), 17, false);
            this.knN.setText(aVar.cMk());
            if (aVar.cMn() != null) {
                this.knR.setData(aVar.cMn());
                this.aAs.setText(aVar.cMn().getName_show());
                if (aVar.cMn().getGodUserData() != null && (!StringUtils.isNull(aVar.cMn().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.cMn().getGodUserData().getIntro()))) {
                    this.knS.setText(aVar.cMn().getGodUserData().getForumName() + "吧 " + aVar.cMn().getGodIntro());
                    this.knS.setVisibility(0);
                } else {
                    this.knS.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.cMn().getUserId())) {
                    this.knT.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.knE.getPageContext(), this.knT).a(aVar.cMn());
                    this.knT.onChangeSkinType(0);
                    this.knT.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b cMm = aVar.cMm();
                if (cMm == null) {
                    this.knE.cLZ().dao();
                    this.knE.finish();
                    return;
                }
                boolean z = cMm.cMo() == null || v.isEmpty(cMm.cMo().bch());
                if (StringUtils.isNull(cMm.getTitle()) && z) {
                    this.knE.cLZ().dao();
                    this.knE.finish();
                    return;
                }
                if (cMm.cMo() != null) {
                    Iterator<TbRichTextData> it = cMm.cMo().bch().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.knI = next.bcr();
                        }
                        if (this.knI != null) {
                            break;
                        }
                    }
                }
                this.tid = cMm.getTid();
                if (this.knI == null) {
                    this.knQ.setVisibility(8);
                    this.iCr.setVisibility(0);
                    boolean z2 = j.is4GNet() || j.isWifiNet();
                    this.knW.ij(z2);
                    if (z2) {
                        dimens = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(this.knE, R.dimen.tbds22) * 2)) - (l.getDimens(this.knE, R.dimen.tbds44) * 2);
                        dimens2 = (int) (dimens * 1.618f);
                    } else {
                        dimens = l.getDimens(this.knE, R.dimen.tbds360);
                        dimens2 = l.getDimens(this.knE, R.dimen.tbds202);
                    }
                    this.knW.ik(z2);
                    this.knW.nw(dimens);
                    this.knW.nx(dimens2);
                    this.iCr.setText(cMm.cMo());
                } else {
                    this.iCr.setVisibility(8);
                    this.knQ.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.knQ.getLayoutParams();
                    layoutParams.width = l.getEquipmentWidth(this.knE) - l.getDimens(this.knE, R.dimen.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.knQ.setLayoutParams(layoutParams);
                    this.knQ.setTbRichTextVideoInfo(this.knI);
                    this.knQ.stopPlay();
                    this.knQ.setIsNeedRecoveryVideoPlayer(true);
                    this.knQ.setThumbnail(this.knI.getThumbUrl());
                    this.knQ.setVideoUrl(this.knI.getVideoUrl(), String.valueOf(this.tid));
                    this.knQ.caH();
                    n nVar = new n(this.knE.getActivity());
                    nVar.IJ("2");
                    y yVar = new y();
                    yVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    yVar.ahL = String.valueOf(this.tid);
                    yVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    nVar.setVideoStatsData(yVar);
                    this.knQ.setQuickVideoViewBusiness(nVar);
                }
                if (StringUtils.isNull(cMm.getTitle())) {
                    this.knP.setVisibility(8);
                } else {
                    this.knP.setText(cMm.getTitle());
                    this.knP.setVisibility(0);
                }
                this.knV.setText(String.format(Locale.CHINA, this.knE.getString(R.string.bottom_comment), Integer.valueOf(cMm.getPostNum())));
                if (!this.knE.cLZ().dar()) {
                    this.knE.cLZ().dap();
                    return;
                }
                return;
            }
            this.knE.cLZ().dao();
            this.knE.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.knO) {
            TiebaStatic.log(new an("c13198").cI("tid", this.knE.getTid()));
            e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.knE != null && c.this.knE.cLZ() != null) {
                        c.this.knE.cLZ().dao();
                    }
                }
            }, 100L);
            this.knE.finish();
        } else if (view == this.knU) {
            TiebaStatic.log(new an("c13199").af("obj_locate", 4).cI("tid", this.knE.getTid()));
            if (this.tid == 0) {
                this.knE.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.knE).createNormalCfg(this.tid + "", null, null)));
            this.knE.cLZ().dap();
            this.knE.finish();
        } else if (view == this.knT) {
            TiebaStatic.log(new an("c13199").af("obj_locate", 3).cI("tid", this.knE.getTid()));
        }
    }

    public void onPause() {
        if (this.knQ != null) {
            this.knQ.onPause();
        }
    }

    public void onDestroy() {
        if (this.knQ != null) {
            this.knQ.onDestroy();
        }
    }
}
