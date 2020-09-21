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
/* loaded from: classes20.dex */
public class c implements View.OnClickListener {
    private TextView aQY;
    private com.baidu.tbadk.widget.richText.a dVR;
    private EditorScrollView eHZ;
    private View ifX;
    private TbRichTextView jPw;
    private Drawable lHA;
    private View lHB;
    private TbImageView lHC;
    private TextView lHD;
    private ImageView lHE;
    private TextView lHF;
    private PushDialogVideoView lHG;
    private ClickableHeaderImageView lHH;
    private TextView lHI;
    private CommonUserLikeButton lHJ;
    private TextView lHK;
    private boolean lHL = false;
    private final PushDialogActivity lHu;
    private j lHy;
    private View mRootView;
    private long tid;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.lHu = pushDialogActivity;
        this.lHu.setContentView(i);
        this.mRootView = findViewById(R.id.root_view);
        this.lHB = findViewById(R.id.dialog_wrapper_view);
        this.eHZ = (EditorScrollView) findViewById(R.id.push_dialog_content_layout);
        this.eHZ.setOverScrollMode(2);
        this.eHZ.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.lHL) {
                    TiebaStatic.log(new aq("c13199").ai("obj_locate", 1).dF("tid", c.this.lHu.getTid()));
                    c.this.lHL = true;
                }
            }
        });
        if (this.lHB.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lHB.getLayoutParams();
            int equipmentHeight = l.getEquipmentHeight(this.lHu);
            layoutParams.height = equipmentHeight / 2;
            layoutParams.topMargin = (int) (equipmentHeight * 0.22f);
            this.lHB.postInvalidate();
        }
        if (l.isFlymeOsAbove35()) {
            this.lHA = com.baidu.tieba.v.b.dEO();
            if (this.lHA != null && this.lHu.getWindow() != null) {
                this.lHu.getWindow().setBackgroundDrawable(this.lHA);
            }
        }
        this.ifX = findViewById(R.id.push_dialog_bottom_layout);
        this.ifX.setOnClickListener(this);
        this.lHK = (TextView) findViewById(R.id.comment_num);
        this.lHC = (TbImageView) findViewById(R.id.push_dialog_title_img);
        this.lHC.setDefaultBgResource(R.drawable.tb_launcher_icon);
        this.lHC.setAutoChangeStyle(false);
        this.lHD = (TextView) findViewById(R.id.push_dialog_title_text);
        this.lHF = (TextView) findViewById(R.id.push_dialog_content_title);
        this.lHH = (ClickableHeaderImageView) findViewById(R.id.push_dialog_user_head);
        this.lHH.setBorderSurroundContent(true);
        this.lHH.setIsRound(true);
        this.lHH.setEnabled(false);
        this.lHH.setAutoChangeStyle(false);
        this.lHH.setBorderWidth(l.getDimens(this.lHu, R.dimen.tbds1));
        this.lHH.setBorderColor(ContextCompat.getColor(this.lHu, R.color.black_alpha15));
        this.dVR = new com.baidu.tbadk.widget.richText.a();
        this.jPw = (TbRichTextView) findViewById(R.id.push_dialog_content);
        this.jPw.setTextColor(ContextCompat.getColor(this.lHu, R.color.cp_cont_j));
        this.dVR.rz(l.getDimens(this.lHu, R.dimen.tbds38));
        this.dVR.setTextSize(l.getDimens(this.lHu, R.dimen.tbds42));
        this.dVR.rD(l.getDimens(this.lHu, R.dimen.tbds23));
        this.dVR.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.dVR.br(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.jPw.setLayoutStrategy(this.dVR);
        this.lHG = (PushDialogVideoView) findViewById(R.id.push_dialog_video);
        this.lHG.setPageContext(this.lHu.getPageContext());
        this.aQY = (TextView) findViewById(R.id.push_dialog_user_name);
        this.lHI = (TextView) findViewById(R.id.push_dialog_user_god_info);
        this.lHJ = (CommonUserLikeButton) findViewById(R.id.push_dialog_user_like_btn);
        this.lHJ.setAfterOnClickListener(this);
        this.lHE = (ImageView) findViewById(R.id.dialog_close_btn);
        this.lHE.setOnClickListener(this);
    }

    public void onResume() {
        if (this.lHG != null) {
            this.lHG.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.lHu.findViewById(i);
    }

    public void dpJ() {
        if (this.lHG != null) {
            this.lHG.setNetworkChange();
            if (com.baidu.adp.lib.util.j.isMobileNet() && this.lHG.rK() && this.lHy != null && this.lHy.getFileSize() > 0 && this.lHy.getDuration() > 0) {
                float fileSize = this.lHy.getFileSize() * (1.0f - ((this.lHG.getCurrentPosition() * 1.0f) / (this.lHy.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.lHu.getPageContext().getPageActivity(), String.format(this.lHu.getPageContext().getString(R.string.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int dimens;
        int dimens2;
        if (aVar != null) {
            this.lHC.startLoad(aVar.dpL(), 17, false);
            this.lHD.setText(aVar.dpK());
            if (aVar.dpN() != null) {
                this.lHH.setData(aVar.dpN());
                this.aQY.setText(aVar.dpN().getName_show());
                if (aVar.dpN().getGodUserData() != null && (!StringUtils.isNull(aVar.dpN().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.dpN().getGodUserData().getIntro()))) {
                    this.lHI.setText(aVar.dpN().getGodUserData().getForumName() + "吧 " + aVar.dpN().getGodIntro());
                    this.lHI.setVisibility(0);
                } else {
                    this.lHI.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.dpN().getUserId())) {
                    this.lHJ.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.lHu.getPageContext(), this.lHJ).a(aVar.dpN());
                    this.lHJ.onChangeSkinType(0);
                    this.lHJ.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b dpM = aVar.dpM();
                if (dpM == null) {
                    this.lHu.dpz().dEK();
                    this.lHu.finish();
                    return;
                }
                boolean z = dpM.dpO() == null || y.isEmpty(dpM.dpO().byG());
                if (StringUtils.isNull(dpM.getTitle()) && z) {
                    this.lHu.dpz().dEK();
                    this.lHu.finish();
                    return;
                }
                if (dpM.dpO() != null) {
                    Iterator<TbRichTextData> it = dpM.dpO().byG().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.lHy = next.byQ();
                        }
                        if (this.lHy != null) {
                            break;
                        }
                    }
                }
                this.tid = dpM.getTid();
                if (this.lHy == null) {
                    this.lHG.setVisibility(8);
                    this.jPw.setVisibility(0);
                    boolean z2 = com.baidu.adp.lib.util.j.is4GNet() || com.baidu.adp.lib.util.j.isWifiNet();
                    this.dVR.jY(z2);
                    if (z2) {
                        dimens = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(this.lHu, R.dimen.tbds22) * 2)) - (l.getDimens(this.lHu, R.dimen.tbds44) * 2);
                        dimens2 = (int) (dimens * 1.618f);
                    } else {
                        dimens = l.getDimens(this.lHu, R.dimen.tbds360);
                        dimens2 = l.getDimens(this.lHu, R.dimen.tbds202);
                    }
                    this.dVR.jZ(z2);
                    this.dVR.ru(dimens);
                    this.dVR.rv(dimens2);
                    this.jPw.setText(dpM.dpO());
                } else {
                    this.jPw.setVisibility(8);
                    this.lHG.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lHG.getLayoutParams();
                    layoutParams.width = l.getEquipmentWidth(this.lHu) - l.getDimens(this.lHu, R.dimen.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.lHG.setLayoutParams(layoutParams);
                    this.lHG.setTbRichTextVideoInfo(this.lHy);
                    this.lHG.stopPlay();
                    this.lHG.setThumbnail(this.lHy.getThumbUrl());
                    this.lHG.setVideoUrl(this.lHy.getVideoUrl(), String.valueOf(this.tid));
                    this.lHG.cDc();
                    o oVar = new o();
                    oVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    oVar.alA = String.valueOf(this.tid);
                    oVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    this.lHG.setVideoViewBusiness(oVar);
                }
                if (StringUtils.isNull(dpM.getTitle())) {
                    this.lHF.setVisibility(8);
                } else {
                    this.lHF.setText(dpM.getTitle());
                    this.lHF.setVisibility(0);
                }
                this.lHK.setText(String.format(Locale.CHINA, this.lHu.getString(R.string.bottom_comment), Integer.valueOf(dpM.getPostNum())));
                if (!this.lHu.dpz().dEN()) {
                    this.lHu.dpz().dEL();
                    return;
                }
                return;
            }
            this.lHu.dpz().dEK();
            this.lHu.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.lHE) {
            TiebaStatic.log(new aq("c13198").dF("tid", this.lHu.getTid()));
            e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.lHu != null && c.this.lHu.dpz() != null) {
                        c.this.lHu.dpz().dEK();
                    }
                }
            }, 100L);
            this.lHu.finish();
        } else if (view == this.ifX) {
            TiebaStatic.log(new aq("c13199").ai("obj_locate", 4).dF("tid", this.lHu.getTid()));
            if (this.tid == 0) {
                this.lHu.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.lHu).createNormalCfg(this.tid + "", null, null)));
            this.lHu.dpz().dEL();
            this.lHu.finish();
        } else if (view == this.lHJ) {
            TiebaStatic.log(new aq("c13199").ai("obj_locate", 3).dF("tid", this.lHu.getTid()));
        }
    }

    public void onPause() {
        if (this.lHG != null) {
            this.lHG.onPause();
        }
    }

    public void onDestroy() {
        if (this.lHG != null) {
            this.lHG.onDestroy();
        }
    }
}
