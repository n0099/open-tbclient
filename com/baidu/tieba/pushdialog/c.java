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
/* loaded from: classes21.dex */
public class c implements View.OnClickListener {
    private TextView aUj;
    private EditorScrollView eUg;
    private com.baidu.tbadk.widget.richText.a ehT;
    private View iuU;
    private TbRichTextView keu;
    private final PushDialogActivity lWI;
    private j lWM;
    private Drawable lWO;
    private View lWP;
    private TbImageView lWQ;
    private TextView lWR;
    private ImageView lWS;
    private TextView lWT;
    private PushDialogVideoView lWU;
    private ClickableHeaderImageView lWV;
    private TextView lWW;
    private CommonUserLikeButton lWX;
    private TextView lWY;
    private boolean lWZ = false;
    private View mRootView;
    private long tid;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.lWI = pushDialogActivity;
        this.lWI.setContentView(i);
        this.mRootView = findViewById(R.id.root_view);
        this.lWP = findViewById(R.id.dialog_wrapper_view);
        this.eUg = (EditorScrollView) findViewById(R.id.push_dialog_content_layout);
        this.eUg.setOverScrollMode(2);
        this.eUg.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.lWZ) {
                    TiebaStatic.log(new aq("c13199").aj("obj_locate", 1).dK("tid", c.this.lWI.getTid()));
                    c.this.lWZ = true;
                }
            }
        });
        if (this.lWP.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lWP.getLayoutParams();
            int equipmentHeight = l.getEquipmentHeight(this.lWI);
            layoutParams.height = equipmentHeight / 2;
            layoutParams.topMargin = (int) (equipmentHeight * 0.22f);
            this.lWP.postInvalidate();
        }
        if (l.isFlymeOsAbove35()) {
            this.lWO = com.baidu.tieba.v.b.dIA();
            if (this.lWO != null && this.lWI.getWindow() != null) {
                this.lWI.getWindow().setBackgroundDrawable(this.lWO);
            }
        }
        this.iuU = findViewById(R.id.push_dialog_bottom_layout);
        this.iuU.setOnClickListener(this);
        this.lWY = (TextView) findViewById(R.id.comment_num);
        this.lWQ = (TbImageView) findViewById(R.id.push_dialog_title_img);
        this.lWQ.setDefaultBgResource(R.drawable.tb_launcher_icon);
        this.lWQ.setAutoChangeStyle(false);
        this.lWR = (TextView) findViewById(R.id.push_dialog_title_text);
        this.lWT = (TextView) findViewById(R.id.push_dialog_content_title);
        this.lWV = (ClickableHeaderImageView) findViewById(R.id.push_dialog_user_head);
        this.lWV.setBorderSurroundContent(true);
        this.lWV.setIsRound(true);
        this.lWV.setEnabled(false);
        this.lWV.setAutoChangeStyle(false);
        this.lWV.setBorderWidth(l.getDimens(this.lWI, R.dimen.tbds1));
        this.lWV.setBorderColor(ContextCompat.getColor(this.lWI, R.color.black_alpha15));
        this.ehT = new com.baidu.tbadk.widget.richText.a();
        this.keu = (TbRichTextView) findViewById(R.id.push_dialog_content);
        this.keu.setTextColor(ContextCompat.getColor(this.lWI, R.color.cp_cont_j));
        this.ehT.rX(l.getDimens(this.lWI, R.dimen.tbds38));
        this.ehT.setTextSize(l.getDimens(this.lWI, R.dimen.tbds42));
        this.ehT.sb(l.getDimens(this.lWI, R.dimen.tbds23));
        this.ehT.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.ehT.bq(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.keu.setLayoutStrategy(this.ehT);
        this.lWU = (PushDialogVideoView) findViewById(R.id.push_dialog_video);
        this.lWU.setPageContext(this.lWI.getPageContext());
        this.aUj = (TextView) findViewById(R.id.push_dialog_user_name);
        this.lWW = (TextView) findViewById(R.id.push_dialog_user_god_info);
        this.lWX = (CommonUserLikeButton) findViewById(R.id.push_dialog_user_like_btn);
        this.lWX.setAfterOnClickListener(this);
        this.lWS = (ImageView) findViewById(R.id.dialog_close_btn);
        this.lWS.setOnClickListener(this);
    }

    public void onResume() {
        if (this.lWU != null) {
            this.lWU.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.lWI.findViewById(i);
    }

    public void dtu() {
        if (this.lWU != null) {
            this.lWU.setNetworkChange();
            if (com.baidu.adp.lib.util.j.isMobileNet() && this.lWU.rK() && this.lWM != null && this.lWM.getFileSize() > 0 && this.lWM.getDuration() > 0) {
                float fileSize = this.lWM.getFileSize() * (1.0f - ((this.lWU.getCurrentPosition() * 1.0f) / (this.lWM.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.lWI.getPageContext().getPageActivity(), String.format(this.lWI.getPageContext().getString(R.string.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int dimens;
        int dimens2;
        if (aVar != null) {
            this.lWQ.startLoad(aVar.dtw(), 17, false);
            this.lWR.setText(aVar.dtv());
            if (aVar.dty() != null) {
                this.lWV.setData(aVar.dty());
                this.aUj.setText(aVar.dty().getName_show());
                if (aVar.dty().getGodUserData() != null && (!StringUtils.isNull(aVar.dty().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.dty().getGodUserData().getIntro()))) {
                    this.lWW.setText(aVar.dty().getGodUserData().getForumName() + "吧 " + aVar.dty().getGodIntro());
                    this.lWW.setVisibility(0);
                } else {
                    this.lWW.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.dty().getUserId())) {
                    this.lWX.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.lWI.getPageContext(), this.lWX).a(aVar.dty());
                    this.lWX.onChangeSkinType(0);
                    this.lWX.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b dtx = aVar.dtx();
                if (dtx == null) {
                    this.lWI.dtk().dIw();
                    this.lWI.finish();
                    return;
                }
                boolean z = dtx.dtz() == null || y.isEmpty(dtx.dtz().bBq());
                if (StringUtils.isNull(dtx.getTitle()) && z) {
                    this.lWI.dtk().dIw();
                    this.lWI.finish();
                    return;
                }
                if (dtx.dtz() != null) {
                    Iterator<TbRichTextData> it = dtx.dtz().bBq().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.lWM = next.bBA();
                        }
                        if (this.lWM != null) {
                            break;
                        }
                    }
                }
                this.tid = dtx.getTid();
                if (this.lWM == null) {
                    this.lWU.setVisibility(8);
                    this.keu.setVisibility(0);
                    boolean z2 = com.baidu.adp.lib.util.j.is4GNet() || com.baidu.adp.lib.util.j.isWifiNet();
                    this.ehT.kw(z2);
                    if (z2) {
                        dimens = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(this.lWI, R.dimen.tbds22) * 2)) - (l.getDimens(this.lWI, R.dimen.tbds44) * 2);
                        dimens2 = (int) (dimens * 1.618f);
                    } else {
                        dimens = l.getDimens(this.lWI, R.dimen.tbds360);
                        dimens2 = l.getDimens(this.lWI, R.dimen.tbds202);
                    }
                    this.ehT.kx(z2);
                    this.ehT.rS(dimens);
                    this.ehT.rT(dimens2);
                    this.keu.setText(dtx.dtz());
                } else {
                    this.keu.setVisibility(8);
                    this.lWU.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lWU.getLayoutParams();
                    layoutParams.width = l.getEquipmentWidth(this.lWI) - l.getDimens(this.lWI, R.dimen.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.lWU.setLayoutParams(layoutParams);
                    this.lWU.setTbRichTextVideoInfo(this.lWM);
                    this.lWU.stopPlay();
                    this.lWU.setThumbnail(this.lWM.getThumbUrl());
                    this.lWU.setVideoUrl(this.lWM.getVideoUrl(), String.valueOf(this.tid));
                    this.lWU.cGL();
                    o oVar = new o();
                    oVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    oVar.alS = String.valueOf(this.tid);
                    oVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    this.lWU.setVideoViewBusiness(oVar);
                }
                if (StringUtils.isNull(dtx.getTitle())) {
                    this.lWT.setVisibility(8);
                } else {
                    this.lWT.setText(dtx.getTitle());
                    this.lWT.setVisibility(0);
                }
                this.lWY.setText(String.format(Locale.CHINA, this.lWI.getString(R.string.bottom_comment), Integer.valueOf(dtx.getPostNum())));
                if (!this.lWI.dtk().dIz()) {
                    this.lWI.dtk().dIx();
                    return;
                }
                return;
            }
            this.lWI.dtk().dIw();
            this.lWI.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.lWS) {
            TiebaStatic.log(new aq("c13198").dK("tid", this.lWI.getTid()));
            e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.lWI != null && c.this.lWI.dtk() != null) {
                        c.this.lWI.dtk().dIw();
                    }
                }
            }, 100L);
            this.lWI.finish();
        } else if (view == this.iuU) {
            TiebaStatic.log(new aq("c13199").aj("obj_locate", 4).dK("tid", this.lWI.getTid()));
            if (this.tid == 0) {
                this.lWI.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.lWI).createNormalCfg(this.tid + "", null, null)));
            this.lWI.dtk().dIx();
            this.lWI.finish();
        } else if (view == this.lWX) {
            TiebaStatic.log(new aq("c13199").aj("obj_locate", 3).dK("tid", this.lWI.getTid()));
        }
    }

    public void onPause() {
        if (this.lWU != null) {
            this.lWU.onPause();
        }
    }

    public void onDestroy() {
        if (this.lWU != null) {
            this.lWU.onDestroy();
        }
    }
}
