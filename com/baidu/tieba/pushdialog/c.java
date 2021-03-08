package com.baidu.tieba.pushdialog;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.core.content.ContextCompat;
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
/* loaded from: classes7.dex */
public class c implements View.OnClickListener {
    private TextView aZX;
    private com.baidu.tbadk.widget.richText.a eKc;
    private EditorScrollView fxQ;
    private View joe;
    private TbRichTextView jwP;
    private final PushDialogActivity mPP;
    private i mPT;
    private Drawable mPV;
    private View mPW;
    private TbImageView mPX;
    private TextView mPY;
    private ImageView mPZ;
    private TextView mQa;
    private PushDialogVideoView mQb;
    private ClickableHeaderImageView mQc;
    private TextView mQd;
    private CommonUserLikeButton mQe;
    private TextView mQf;
    private boolean mQg = false;
    private View mRootView;
    private long tid;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.mPP = pushDialogActivity;
        this.mPP.setContentView(i);
        this.mRootView = findViewById(R.id.root_view);
        this.mPW = findViewById(R.id.dialog_wrapper_view);
        this.fxQ = (EditorScrollView) findViewById(R.id.push_dialog_content_layout);
        this.fxQ.setOverScrollMode(2);
        this.fxQ.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.mQg) {
                    TiebaStatic.log(new ar("c13199").aq("obj_locate", 1).dR("tid", c.this.mPP.getTid()));
                    c.this.mQg = true;
                }
            }
        });
        if (this.mPW.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mPW.getLayoutParams();
            int equipmentHeight = l.getEquipmentHeight(this.mPP);
            layoutParams.height = equipmentHeight / 2;
            layoutParams.topMargin = (int) (equipmentHeight * 0.22f);
            this.mPW.postInvalidate();
        }
        if (l.isFlymeOsAbove35()) {
            this.mPV = com.baidu.tieba.v.b.dSd();
            if (this.mPV != null && this.mPP.getWindow() != null) {
                this.mPP.getWindow().setBackgroundDrawable(this.mPV);
            }
        }
        this.joe = findViewById(R.id.push_dialog_bottom_layout);
        this.joe.setOnClickListener(this);
        this.mQf = (TextView) findViewById(R.id.comment_num);
        this.mPX = (TbImageView) findViewById(R.id.push_dialog_title_img);
        this.mPX.setDefaultBgResource(R.drawable.tb_launcher_icon);
        this.mPX.setAutoChangeStyle(false);
        this.mPY = (TextView) findViewById(R.id.push_dialog_title_text);
        this.mQa = (TextView) findViewById(R.id.push_dialog_content_title);
        this.mQc = (ClickableHeaderImageView) findViewById(R.id.push_dialog_user_head);
        this.mQc.setBorderSurroundContent(true);
        this.mQc.setIsRound(true);
        this.mQc.setEnabled(false);
        this.mQc.setAutoChangeStyle(false);
        this.mQc.setBorderWidth(l.getDimens(this.mPP, R.dimen.tbds1));
        this.mQc.setBorderColor(ContextCompat.getColor(this.mPP, R.color.black_alpha15));
        this.eKc = new com.baidu.tbadk.widget.richText.a();
        this.jwP = (TbRichTextView) findViewById(R.id.push_dialog_content);
        this.jwP.setTextColor(ContextCompat.getColor(this.mPP, R.color.CAM_X0107));
        this.eKc.sf(l.getDimens(this.mPP, R.dimen.tbds38));
        this.eKc.setTextSize(l.getDimens(this.mPP, R.dimen.tbds42));
        this.eKc.sj(l.getDimens(this.mPP, R.dimen.tbds23));
        this.eKc.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.eKc.bo(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.jwP.setLayoutStrategy(this.eKc);
        this.mQb = (PushDialogVideoView) findViewById(R.id.push_dialog_video);
        this.mQb.setPageContext(this.mPP.getPageContext());
        this.aZX = (TextView) findViewById(R.id.push_dialog_user_name);
        this.mQd = (TextView) findViewById(R.id.push_dialog_user_god_info);
        this.mQe = (CommonUserLikeButton) findViewById(R.id.push_dialog_user_like_btn);
        this.mQe.setAfterOnClickListener(this);
        this.mPZ = (ImageView) findViewById(R.id.dialog_close_btn);
        this.mPZ.setOnClickListener(this);
    }

    public void onResume() {
        if (this.mQb != null) {
            this.mQb.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.mPP.findViewById(i);
    }

    public void dCs() {
        if (this.mQb != null) {
            this.mQb.setNetworkChange();
            if (j.isMobileNet() && this.mQb.rl() && this.mPT != null && this.mPT.getFileSize() > 0 && this.mPT.getDuration() > 0) {
                float fileSize = this.mPT.getFileSize() * (1.0f - ((this.mQb.getCurrentPosition() * 1.0f) / (this.mPT.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.mPP.getPageContext().getPageActivity(), String.format(this.mPP.getPageContext().getString(R.string.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int dimens;
        int dimens2;
        if (aVar != null) {
            this.mPX.startLoad(aVar.dCu(), 17, false);
            this.mPY.setText(aVar.dCt());
            if (aVar.dCw() != null) {
                this.mQc.setData(aVar.dCw());
                this.aZX.setText(aVar.dCw().getName_show());
                if (aVar.dCw().getGodUserData() != null && (!StringUtils.isNull(aVar.dCw().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.dCw().getGodUserData().getIntro()))) {
                    this.mQd.setText(aVar.dCw().getGodUserData().getForumName() + "吧 " + aVar.dCw().getGodIntro());
                    this.mQd.setVisibility(0);
                } else {
                    this.mQd.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.dCw().getUserId())) {
                    this.mQe.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.mPP.getPageContext(), this.mQe).a(aVar.dCw());
                    this.mQe.onChangeSkinType(0);
                    this.mQe.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b dCv = aVar.dCv();
                if (dCv == null) {
                    this.mPP.dCi().dRZ();
                    this.mPP.finish();
                    return;
                }
                boolean z = dCv.dCx() == null || y.isEmpty(dCv.dCx().bHD());
                if (StringUtils.isNull(dCv.getTitle()) && z) {
                    this.mPP.dCi().dRZ();
                    this.mPP.finish();
                    return;
                }
                if (dCv.dCx() != null) {
                    Iterator<TbRichTextData> it = dCv.dCx().bHD().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.mPT = next.bHN();
                        }
                        if (this.mPT != null) {
                            break;
                        }
                    }
                }
                this.tid = dCv.getTid();
                if (this.mPT == null) {
                    this.mQb.setVisibility(8);
                    this.jwP.setVisibility(0);
                    boolean z2 = j.is4GNet() || j.isWifiNet();
                    this.eKc.lJ(z2);
                    if (z2) {
                        dimens = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(this.mPP, R.dimen.tbds22) * 2)) - (l.getDimens(this.mPP, R.dimen.tbds44) * 2);
                        dimens2 = (int) (dimens * 1.618f);
                    } else {
                        dimens = l.getDimens(this.mPP, R.dimen.tbds360);
                        dimens2 = l.getDimens(this.mPP, R.dimen.tbds202);
                    }
                    this.eKc.lK(z2);
                    this.eKc.sa(dimens);
                    this.eKc.sb(dimens2);
                    this.jwP.setText(dCv.dCx());
                } else {
                    this.jwP.setVisibility(8);
                    this.mQb.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mQb.getLayoutParams();
                    layoutParams.width = l.getEquipmentWidth(this.mPP) - l.getDimens(this.mPP, R.dimen.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.mQb.setLayoutParams(layoutParams);
                    this.mQb.setTbRichTextVideoInfo(this.mPT);
                    this.mQb.stopPlay();
                    this.mQb.setThumbnail(this.mPT.getThumbUrl());
                    this.mQb.setVideoUrl(this.mPT.getVideoUrl(), String.valueOf(this.tid));
                    this.mQb.cSR();
                    o oVar = new o();
                    oVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    oVar.anU = String.valueOf(this.tid);
                    oVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    this.mQb.setVideoViewBusiness(oVar);
                }
                if (StringUtils.isNull(dCv.getTitle())) {
                    this.mQa.setVisibility(8);
                } else {
                    this.mQa.setText(dCv.getTitle());
                    this.mQa.setVisibility(0);
                }
                this.mQf.setText(String.format(Locale.CHINA, this.mPP.getString(R.string.bottom_comment), Integer.valueOf(dCv.getPostNum())));
                if (!this.mPP.dCi().dSc()) {
                    this.mPP.dCi().dSa();
                    return;
                }
                return;
            }
            this.mPP.dCi().dRZ();
            this.mPP.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mPZ) {
            TiebaStatic.log(new ar("c13198").dR("tid", this.mPP.getTid()));
            e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.mPP != null && c.this.mPP.dCi() != null) {
                        c.this.mPP.dCi().dRZ();
                    }
                }
            }, 100L);
            this.mPP.finish();
        } else if (view == this.joe) {
            TiebaStatic.log(new ar("c13199").aq("obj_locate", 4).dR("tid", this.mPP.getTid()));
            if (this.tid == 0) {
                this.mPP.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mPP).createNormalCfg(this.tid + "", null, null)));
            this.mPP.dCi().dSa();
            this.mPP.finish();
        } else if (view == this.mQe) {
            TiebaStatic.log(new ar("c13199").aq("obj_locate", 3).dR("tid", this.mPP.getTid()));
        }
    }

    public void onPause() {
        if (this.mQb != null) {
            this.mQb.onPause();
        }
    }

    public void onDestroy() {
        if (this.mQb != null) {
            this.mQb.onDestroy();
        }
    }
}
