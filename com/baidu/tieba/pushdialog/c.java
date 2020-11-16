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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.i;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import com.baidu.tieba.play.o;
import com.tencent.connect.common.Constants;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Locale;
/* loaded from: classes20.dex */
public class c implements View.OnClickListener {
    private TextView aVl;
    private com.baidu.tbadk.widget.richText.a euB;
    private EditorScrollView fhB;
    private View iOa;
    private TbRichTextView kxz;
    private View mRootView;
    private final PushDialogActivity mpA;
    private i mpE;
    private Drawable mpG;
    private View mpH;
    private TbImageView mpI;
    private TextView mpJ;
    private ImageView mpK;
    private TextView mpL;
    private PushDialogVideoView mpM;
    private ClickableHeaderImageView mpN;
    private TextView mpO;
    private CommonUserLikeButton mpP;
    private TextView mpQ;
    private boolean mpR = false;
    private long tid;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.mpA = pushDialogActivity;
        this.mpA.setContentView(i);
        this.mRootView = findViewById(R.id.root_view);
        this.mpH = findViewById(R.id.dialog_wrapper_view);
        this.fhB = (EditorScrollView) findViewById(R.id.push_dialog_content_layout);
        this.fhB.setOverScrollMode(2);
        this.fhB.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.mpR) {
                    TiebaStatic.log(new ar("c13199").ak("obj_locate", 1).dR("tid", c.this.mpA.getTid()));
                    c.this.mpR = true;
                }
            }
        });
        if (this.mpH.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mpH.getLayoutParams();
            int equipmentHeight = l.getEquipmentHeight(this.mpA);
            layoutParams.height = equipmentHeight / 2;
            layoutParams.topMargin = (int) (equipmentHeight * 0.22f);
            this.mpH.postInvalidate();
        }
        if (l.isFlymeOsAbove35()) {
            this.mpG = com.baidu.tieba.w.b.dOj();
            if (this.mpG != null && this.mpA.getWindow() != null) {
                this.mpA.getWindow().setBackgroundDrawable(this.mpG);
            }
        }
        this.iOa = findViewById(R.id.push_dialog_bottom_layout);
        this.iOa.setOnClickListener(this);
        this.mpQ = (TextView) findViewById(R.id.comment_num);
        this.mpI = (TbImageView) findViewById(R.id.push_dialog_title_img);
        this.mpI.setDefaultBgResource(R.drawable.tb_launcher_icon);
        this.mpI.setAutoChangeStyle(false);
        this.mpJ = (TextView) findViewById(R.id.push_dialog_title_text);
        this.mpL = (TextView) findViewById(R.id.push_dialog_content_title);
        this.mpN = (ClickableHeaderImageView) findViewById(R.id.push_dialog_user_head);
        this.mpN.setBorderSurroundContent(true);
        this.mpN.setIsRound(true);
        this.mpN.setEnabled(false);
        this.mpN.setAutoChangeStyle(false);
        this.mpN.setBorderWidth(l.getDimens(this.mpA, R.dimen.tbds1));
        this.mpN.setBorderColor(ContextCompat.getColor(this.mpA, R.color.black_alpha15));
        this.euB = new com.baidu.tbadk.widget.richText.a();
        this.kxz = (TbRichTextView) findViewById(R.id.push_dialog_content);
        this.kxz.setTextColor(ContextCompat.getColor(this.mpA, R.color.CAM_X0107));
        this.euB.sQ(l.getDimens(this.mpA, R.dimen.tbds38));
        this.euB.setTextSize(l.getDimens(this.mpA, R.dimen.tbds42));
        this.euB.sU(l.getDimens(this.mpA, R.dimen.tbds23));
        this.euB.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.euB.br(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.kxz.setLayoutStrategy(this.euB);
        this.mpM = (PushDialogVideoView) findViewById(R.id.push_dialog_video);
        this.mpM.setPageContext(this.mpA.getPageContext());
        this.aVl = (TextView) findViewById(R.id.push_dialog_user_name);
        this.mpO = (TextView) findViewById(R.id.push_dialog_user_god_info);
        this.mpP = (CommonUserLikeButton) findViewById(R.id.push_dialog_user_like_btn);
        this.mpP.setAfterOnClickListener(this);
        this.mpK = (ImageView) findViewById(R.id.dialog_close_btn);
        this.mpK.setOnClickListener(this);
    }

    public void onResume() {
        if (this.mpM != null) {
            this.mpM.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.mpA.findViewById(i);
    }

    public void dyD() {
        if (this.mpM != null) {
            this.mpM.setNetworkChange();
            if (j.isMobileNet() && this.mpM.rK() && this.mpE != null && this.mpE.getFileSize() > 0 && this.mpE.getDuration() > 0) {
                float fileSize = this.mpE.getFileSize() * (1.0f - ((this.mpM.getCurrentPosition() * 1.0f) / (this.mpE.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.mpA.getPageContext().getPageActivity(), String.format(this.mpA.getPageContext().getString(R.string.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int dimens;
        int dimens2;
        if (aVar != null) {
            this.mpI.startLoad(aVar.dyF(), 17, false);
            this.mpJ.setText(aVar.dyE());
            if (aVar.dyH() != null) {
                this.mpN.setData(aVar.dyH());
                this.aVl.setText(aVar.dyH().getName_show());
                if (aVar.dyH().getGodUserData() != null && (!StringUtils.isNull(aVar.dyH().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.dyH().getGodUserData().getIntro()))) {
                    this.mpO.setText(aVar.dyH().getGodUserData().getForumName() + "吧 " + aVar.dyH().getGodIntro());
                    this.mpO.setVisibility(0);
                } else {
                    this.mpO.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.dyH().getUserId())) {
                    this.mpP.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.mpA.getPageContext(), this.mpP).a(aVar.dyH());
                    this.mpP.onChangeSkinType(0);
                    this.mpP.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b dyG = aVar.dyG();
                if (dyG == null) {
                    this.mpA.dyt().dOf();
                    this.mpA.finish();
                    return;
                }
                boolean z = dyG.dyI() == null || y.isEmpty(dyG.dyI().bFb());
                if (StringUtils.isNull(dyG.getTitle()) && z) {
                    this.mpA.dyt().dOf();
                    this.mpA.finish();
                    return;
                }
                if (dyG.dyI() != null) {
                    Iterator<TbRichTextData> it = dyG.dyI().bFb().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.mpE = next.bFl();
                        }
                        if (this.mpE != null) {
                            break;
                        }
                    }
                }
                this.tid = dyG.getTid();
                if (this.mpE == null) {
                    this.mpM.setVisibility(8);
                    this.kxz.setVisibility(0);
                    boolean z2 = j.is4GNet() || j.isWifiNet();
                    this.euB.kT(z2);
                    if (z2) {
                        dimens = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(this.mpA, R.dimen.tbds22) * 2)) - (l.getDimens(this.mpA, R.dimen.tbds44) * 2);
                        dimens2 = (int) (dimens * 1.618f);
                    } else {
                        dimens = l.getDimens(this.mpA, R.dimen.tbds360);
                        dimens2 = l.getDimens(this.mpA, R.dimen.tbds202);
                    }
                    this.euB.kU(z2);
                    this.euB.sL(dimens);
                    this.euB.sM(dimens2);
                    this.kxz.setText(dyG.dyI());
                } else {
                    this.kxz.setVisibility(8);
                    this.mpM.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mpM.getLayoutParams();
                    layoutParams.width = l.getEquipmentWidth(this.mpA) - l.getDimens(this.mpA, R.dimen.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.mpM.setLayoutParams(layoutParams);
                    this.mpM.setTbRichTextVideoInfo(this.mpE);
                    this.mpM.stopPlay();
                    this.mpM.setThumbnail(this.mpE.getThumbUrl());
                    this.mpM.setVideoUrl(this.mpE.getVideoUrl(), String.valueOf(this.tid));
                    this.mpM.cMa();
                    o oVar = new o();
                    oVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    oVar.alZ = String.valueOf(this.tid);
                    oVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    this.mpM.setVideoViewBusiness(oVar);
                }
                if (StringUtils.isNull(dyG.getTitle())) {
                    this.mpL.setVisibility(8);
                } else {
                    this.mpL.setText(dyG.getTitle());
                    this.mpL.setVisibility(0);
                }
                this.mpQ.setText(String.format(Locale.CHINA, this.mpA.getString(R.string.bottom_comment), Integer.valueOf(dyG.getPostNum())));
                if (!this.mpA.dyt().dOi()) {
                    this.mpA.dyt().dOg();
                    return;
                }
                return;
            }
            this.mpA.dyt().dOf();
            this.mpA.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mpK) {
            TiebaStatic.log(new ar("c13198").dR("tid", this.mpA.getTid()));
            e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.mpA != null && c.this.mpA.dyt() != null) {
                        c.this.mpA.dyt().dOf();
                    }
                }
            }, 100L);
            this.mpA.finish();
        } else if (view == this.iOa) {
            TiebaStatic.log(new ar("c13199").ak("obj_locate", 4).dR("tid", this.mpA.getTid()));
            if (this.tid == 0) {
                this.mpA.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mpA).createNormalCfg(this.tid + "", null, null)));
            this.mpA.dyt().dOg();
            this.mpA.finish();
        } else if (view == this.mpP) {
            TiebaStatic.log(new ar("c13199").ak("obj_locate", 3).dR("tid", this.mpA.getTid()));
        }
    }

    public void onPause() {
        if (this.mpM != null) {
            this.mpM.onPause();
        }
    }

    public void onDestroy() {
        if (this.mpM != null) {
            this.mpM.onDestroy();
        }
    }
}
