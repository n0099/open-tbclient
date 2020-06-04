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
    private TbRichTextView iRY;
    private final PushDialogActivity kGL;
    private i kGP;
    private Drawable kGR;
    private View kGS;
    private TbImageView kGT;
    private TextView kGU;
    private ImageView kGV;
    private TextView kGW;
    private PushDialogVideoView kGX;
    private ClickableHeaderImageView kGY;
    private TextView kGZ;
    private CommonUserLikeButton kHa;
    private View kHb;
    private TextView kHc;
    private com.baidu.tbadk.widget.richText.a kHd;
    private boolean kHe = false;
    private View mRootView;
    private long tid;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.kGL = pushDialogActivity;
        this.kGL.setContentView(i);
        this.mRootView = findViewById(R.id.root_view);
        this.kGS = findViewById(R.id.dialog_wrapper_view);
        this.egr = (EditorScrollView) findViewById(R.id.push_dialog_content_layout);
        this.egr.setOverScrollMode(2);
        this.egr.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.kHe) {
                    TiebaStatic.log(new an("c13199").ag("obj_locate", 1).dh("tid", c.this.kGL.getTid()));
                    c.this.kHe = true;
                }
            }
        });
        if (this.kGS.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kGS.getLayoutParams();
            int equipmentHeight = l.getEquipmentHeight(this.kGL);
            layoutParams.height = equipmentHeight / 2;
            layoutParams.topMargin = (int) (equipmentHeight * 0.22f);
            this.kGS.postInvalidate();
        }
        if (l.isFlymeOsAbove35()) {
            this.kGR = com.baidu.tieba.v.b.dhT();
            if (this.kGR != null && this.kGL.getWindow() != null) {
                this.kGL.getWindow().setBackgroundDrawable(this.kGR);
            }
        }
        this.kHb = findViewById(R.id.push_dialog_bottom_layout);
        this.kHb.setOnClickListener(this);
        this.kHc = (TextView) findViewById(R.id.comment_num);
        this.kGT = (TbImageView) findViewById(R.id.push_dialog_title_img);
        this.kGT.setDefaultBgResource(R.drawable.tb_launcher_icon);
        this.kGT.setAutoChangeStyle(false);
        this.kGU = (TextView) findViewById(R.id.push_dialog_title_text);
        this.kGW = (TextView) findViewById(R.id.push_dialog_content_title);
        this.kGY = (ClickableHeaderImageView) findViewById(R.id.push_dialog_user_head);
        this.kGY.setBorderSurroundContent(true);
        this.kGY.setIsRound(true);
        this.kGY.setEnabled(false);
        this.kGY.setAutoChangeStyle(false);
        this.kGY.setBorderWidth(l.getDimens(this.kGL, R.dimen.tbds1));
        this.kGY.setBorderColor(ContextCompat.getColor(this.kGL, R.color.black_alpha15));
        this.kHd = new com.baidu.tbadk.widget.richText.a();
        this.iRY = (TbRichTextView) findViewById(R.id.push_dialog_content);
        this.iRY.setTextColor(ContextCompat.getColor(this.kGL, R.color.cp_cont_j));
        this.kHd.og(l.getDimens(this.kGL, R.dimen.tbds38));
        this.kHd.setTextSize(l.getDimens(this.kGL, R.dimen.tbds42));
        this.kHd.ok(l.getDimens(this.kGL, R.dimen.tbds23));
        this.kHd.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.kHd.bb(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.iRY.setLayoutStrategy(this.kHd);
        this.kGX = (PushDialogVideoView) findViewById(R.id.push_dialog_video);
        this.kGX.setPageContext(this.kGL.getPageContext());
        this.aFR = (TextView) findViewById(R.id.push_dialog_user_name);
        this.kGZ = (TextView) findViewById(R.id.push_dialog_user_god_info);
        this.kHa = (CommonUserLikeButton) findViewById(R.id.push_dialog_user_like_btn);
        this.kHa.setAfterOnClickListener(this);
        this.kGV = (ImageView) findViewById(R.id.dialog_close_btn);
        this.kGV.setOnClickListener(this);
    }

    public void onResume() {
        if (this.kGX != null) {
            this.kGX.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.kGL.findViewById(i);
    }

    public void cTx() {
        if (this.kGX != null) {
            this.kGX.setNetworkChange();
            if (j.isMobileNet() && this.kGX.pO() && this.kGP != null && this.kGP.getFileSize() > 0 && this.kGP.getDuration() > 0) {
                float fileSize = this.kGP.getFileSize() * (1.0f - ((this.kGX.getCurrentPosition() * 1.0f) / (this.kGP.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.kGL.getPageContext().getPageActivity(), String.format(this.kGL.getPageContext().getString(R.string.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int dimens;
        int dimens2;
        if (aVar != null) {
            this.kGT.startLoad(aVar.cTz(), 17, false);
            this.kGU.setText(aVar.cTy());
            if (aVar.cTB() != null) {
                this.kGY.setData(aVar.cTB());
                this.aFR.setText(aVar.cTB().getName_show());
                if (aVar.cTB().getGodUserData() != null && (!StringUtils.isNull(aVar.cTB().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.cTB().getGodUserData().getIntro()))) {
                    this.kGZ.setText(aVar.cTB().getGodUserData().getForumName() + "吧 " + aVar.cTB().getGodIntro());
                    this.kGZ.setVisibility(0);
                } else {
                    this.kGZ.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.cTB().getUserId())) {
                    this.kHa.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.kGL.getPageContext(), this.kHa).a(aVar.cTB());
                    this.kHa.onChangeSkinType(0);
                    this.kHa.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b cTA = aVar.cTA();
                if (cTA == null) {
                    this.kGL.cTn().dhP();
                    this.kGL.finish();
                    return;
                }
                boolean z = cTA.cTC() == null || v.isEmpty(cTA.cTC().bis());
                if (StringUtils.isNull(cTA.getTitle()) && z) {
                    this.kGL.cTn().dhP();
                    this.kGL.finish();
                    return;
                }
                if (cTA.cTC() != null) {
                    Iterator<TbRichTextData> it = cTA.cTC().bis().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.kGP = next.biC();
                        }
                        if (this.kGP != null) {
                            break;
                        }
                    }
                }
                this.tid = cTA.getTid();
                if (this.kGP == null) {
                    this.kGX.setVisibility(8);
                    this.iRY.setVisibility(0);
                    boolean z2 = j.is4GNet() || j.isWifiNet();
                    this.kHd.iG(z2);
                    if (z2) {
                        dimens = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(this.kGL, R.dimen.tbds22) * 2)) - (l.getDimens(this.kGL, R.dimen.tbds44) * 2);
                        dimens2 = (int) (dimens * 1.618f);
                    } else {
                        dimens = l.getDimens(this.kGL, R.dimen.tbds360);
                        dimens2 = l.getDimens(this.kGL, R.dimen.tbds202);
                    }
                    this.kHd.iH(z2);
                    this.kHd.ob(dimens);
                    this.kHd.oc(dimens2);
                    this.iRY.setText(cTA.cTC());
                } else {
                    this.iRY.setVisibility(8);
                    this.kGX.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kGX.getLayoutParams();
                    layoutParams.width = l.getEquipmentWidth(this.kGL) - l.getDimens(this.kGL, R.dimen.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.kGX.setLayoutParams(layoutParams);
                    this.kGX.setTbRichTextVideoInfo(this.kGP);
                    this.kGX.stopPlay();
                    this.kGX.setIsNeedRecoveryVideoPlayer(true);
                    this.kGX.setThumbnail(this.kGP.getThumbUrl());
                    this.kGX.setVideoUrl(this.kGP.getVideoUrl(), String.valueOf(this.tid));
                    this.kGX.cho();
                    n nVar = new n(this.kGL.getActivity());
                    nVar.Kz("2");
                    y yVar = new y();
                    yVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    yVar.ais = String.valueOf(this.tid);
                    yVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    nVar.setVideoStatsData(yVar);
                    this.kGX.setQuickVideoViewBusiness(nVar);
                }
                if (StringUtils.isNull(cTA.getTitle())) {
                    this.kGW.setVisibility(8);
                } else {
                    this.kGW.setText(cTA.getTitle());
                    this.kGW.setVisibility(0);
                }
                this.kHc.setText(String.format(Locale.CHINA, this.kGL.getString(R.string.bottom_comment), Integer.valueOf(cTA.getPostNum())));
                if (!this.kGL.cTn().dhS()) {
                    this.kGL.cTn().dhQ();
                    return;
                }
                return;
            }
            this.kGL.cTn().dhP();
            this.kGL.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kGV) {
            TiebaStatic.log(new an("c13198").dh("tid", this.kGL.getTid()));
            e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.kGL != null && c.this.kGL.cTn() != null) {
                        c.this.kGL.cTn().dhP();
                    }
                }
            }, 100L);
            this.kGL.finish();
        } else if (view == this.kHb) {
            TiebaStatic.log(new an("c13199").ag("obj_locate", 4).dh("tid", this.kGL.getTid()));
            if (this.tid == 0) {
                this.kGL.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.kGL).createNormalCfg(this.tid + "", null, null)));
            this.kGL.cTn().dhQ();
            this.kGL.finish();
        } else if (view == this.kHa) {
            TiebaStatic.log(new an("c13199").ag("obj_locate", 3).dh("tid", this.kGL.getTid()));
        }
    }

    public void onPause() {
        if (this.kGX != null) {
            this.kGX.onPause();
        }
    }

    public void onDestroy() {
        if (this.kGX != null) {
            this.kGX.onDestroy();
        }
    }
}
