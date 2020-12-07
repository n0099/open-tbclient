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
/* loaded from: classes21.dex */
public class c implements View.OnClickListener {
    private TextView aYw;
    private com.baidu.tbadk.widget.richText.a eBD;
    private EditorScrollView fpb;
    private View iYR;
    private TbRichTextView jhq;
    private final PushDialogActivity mDH;
    private i mDL;
    private Drawable mDN;
    private View mDO;
    private TbImageView mDP;
    private TextView mDQ;
    private ImageView mDR;
    private TextView mDS;
    private PushDialogVideoView mDT;
    private ClickableHeaderImageView mDU;
    private TextView mDV;
    private CommonUserLikeButton mDW;
    private TextView mDX;
    private boolean mDY = false;
    private View mRootView;
    private long tid;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.mDH = pushDialogActivity;
        this.mDH.setContentView(i);
        this.mRootView = findViewById(R.id.root_view);
        this.mDO = findViewById(R.id.dialog_wrapper_view);
        this.fpb = (EditorScrollView) findViewById(R.id.push_dialog_content_layout);
        this.fpb.setOverScrollMode(2);
        this.fpb.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.mDY) {
                    TiebaStatic.log(new ar("c13199").al("obj_locate", 1).dY("tid", c.this.mDH.getTid()));
                    c.this.mDY = true;
                }
            }
        });
        if (this.mDO.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mDO.getLayoutParams();
            int equipmentHeight = l.getEquipmentHeight(this.mDH);
            layoutParams.height = equipmentHeight / 2;
            layoutParams.topMargin = (int) (equipmentHeight * 0.22f);
            this.mDO.postInvalidate();
        }
        if (l.isFlymeOsAbove35()) {
            this.mDN = com.baidu.tieba.w.b.dTB();
            if (this.mDN != null && this.mDH.getWindow() != null) {
                this.mDH.getWindow().setBackgroundDrawable(this.mDN);
            }
        }
        this.iYR = findViewById(R.id.push_dialog_bottom_layout);
        this.iYR.setOnClickListener(this);
        this.mDX = (TextView) findViewById(R.id.comment_num);
        this.mDP = (TbImageView) findViewById(R.id.push_dialog_title_img);
        this.mDP.setDefaultBgResource(R.drawable.tb_launcher_icon);
        this.mDP.setAutoChangeStyle(false);
        this.mDQ = (TextView) findViewById(R.id.push_dialog_title_text);
        this.mDS = (TextView) findViewById(R.id.push_dialog_content_title);
        this.mDU = (ClickableHeaderImageView) findViewById(R.id.push_dialog_user_head);
        this.mDU.setBorderSurroundContent(true);
        this.mDU.setIsRound(true);
        this.mDU.setEnabled(false);
        this.mDU.setAutoChangeStyle(false);
        this.mDU.setBorderWidth(l.getDimens(this.mDH, R.dimen.tbds1));
        this.mDU.setBorderColor(ContextCompat.getColor(this.mDH, R.color.black_alpha15));
        this.eBD = new com.baidu.tbadk.widget.richText.a();
        this.jhq = (TbRichTextView) findViewById(R.id.push_dialog_content);
        this.jhq.setTextColor(ContextCompat.getColor(this.mDH, R.color.CAM_X0107));
        this.eBD.tt(l.getDimens(this.mDH, R.dimen.tbds38));
        this.eBD.setTextSize(l.getDimens(this.mDH, R.dimen.tbds42));
        this.eBD.tx(l.getDimens(this.mDH, R.dimen.tbds23));
        this.eBD.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.eBD.bt(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.jhq.setLayoutStrategy(this.eBD);
        this.mDT = (PushDialogVideoView) findViewById(R.id.push_dialog_video);
        this.mDT.setPageContext(this.mDH.getPageContext());
        this.aYw = (TextView) findViewById(R.id.push_dialog_user_name);
        this.mDV = (TextView) findViewById(R.id.push_dialog_user_god_info);
        this.mDW = (CommonUserLikeButton) findViewById(R.id.push_dialog_user_like_btn);
        this.mDW.setAfterOnClickListener(this);
        this.mDR = (ImageView) findViewById(R.id.dialog_close_btn);
        this.mDR.setOnClickListener(this);
    }

    public void onResume() {
        if (this.mDT != null) {
            this.mDT.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.mDH.findViewById(i);
    }

    public void dDU() {
        if (this.mDT != null) {
            this.mDT.setNetworkChange();
            if (j.isMobileNet() && this.mDT.rM() && this.mDL != null && this.mDL.getFileSize() > 0 && this.mDL.getDuration() > 0) {
                float fileSize = this.mDL.getFileSize() * (1.0f - ((this.mDT.getCurrentPosition() * 1.0f) / (this.mDL.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.mDH.getPageContext().getPageActivity(), String.format(this.mDH.getPageContext().getString(R.string.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int dimens;
        int dimens2;
        if (aVar != null) {
            this.mDP.startLoad(aVar.dDW(), 17, false);
            this.mDQ.setText(aVar.dDV());
            if (aVar.dDY() != null) {
                this.mDU.setData(aVar.dDY());
                this.aYw.setText(aVar.dDY().getName_show());
                if (aVar.dDY().getGodUserData() != null && (!StringUtils.isNull(aVar.dDY().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.dDY().getGodUserData().getIntro()))) {
                    this.mDV.setText(aVar.dDY().getGodUserData().getForumName() + "吧 " + aVar.dDY().getGodIntro());
                    this.mDV.setVisibility(0);
                } else {
                    this.mDV.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.dDY().getUserId())) {
                    this.mDW.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.mDH.getPageContext(), this.mDW).a(aVar.dDY());
                    this.mDW.onChangeSkinType(0);
                    this.mDW.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b dDX = aVar.dDX();
                if (dDX == null) {
                    this.mDH.dDK().dTx();
                    this.mDH.finish();
                    return;
                }
                boolean z = dDX.dDZ() == null || y.isEmpty(dDX.dDZ().bIC());
                if (StringUtils.isNull(dDX.getTitle()) && z) {
                    this.mDH.dDK().dTx();
                    this.mDH.finish();
                    return;
                }
                if (dDX.dDZ() != null) {
                    Iterator<TbRichTextData> it = dDX.dDZ().bIC().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.mDL = next.bIM();
                        }
                        if (this.mDL != null) {
                            break;
                        }
                    }
                }
                this.tid = dDX.getTid();
                if (this.mDL == null) {
                    this.mDT.setVisibility(8);
                    this.jhq.setVisibility(0);
                    boolean z2 = j.is4GNet() || j.isWifiNet();
                    this.eBD.ln(z2);
                    if (z2) {
                        dimens = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(this.mDH, R.dimen.tbds22) * 2)) - (l.getDimens(this.mDH, R.dimen.tbds44) * 2);
                        dimens2 = (int) (dimens * 1.618f);
                    } else {
                        dimens = l.getDimens(this.mDH, R.dimen.tbds360);
                        dimens2 = l.getDimens(this.mDH, R.dimen.tbds202);
                    }
                    this.eBD.lo(z2);
                    this.eBD.to(dimens);
                    this.eBD.tp(dimens2);
                    this.jhq.setText(dDX.dDZ());
                } else {
                    this.jhq.setVisibility(8);
                    this.mDT.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mDT.getLayoutParams();
                    layoutParams.width = l.getEquipmentWidth(this.mDH) - l.getDimens(this.mDH, R.dimen.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.mDT.setLayoutParams(layoutParams);
                    this.mDT.setTbRichTextVideoInfo(this.mDL);
                    this.mDT.stopPlay();
                    this.mDT.setThumbnail(this.mDL.getThumbUrl());
                    this.mDT.setVideoUrl(this.mDL.getVideoUrl(), String.valueOf(this.tid));
                    this.mDT.cRo();
                    o oVar = new o();
                    oVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    oVar.amY = String.valueOf(this.tid);
                    oVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    this.mDT.setVideoViewBusiness(oVar);
                }
                if (StringUtils.isNull(dDX.getTitle())) {
                    this.mDS.setVisibility(8);
                } else {
                    this.mDS.setText(dDX.getTitle());
                    this.mDS.setVisibility(0);
                }
                this.mDX.setText(String.format(Locale.CHINA, this.mDH.getString(R.string.bottom_comment), Integer.valueOf(dDX.getPostNum())));
                if (!this.mDH.dDK().dTA()) {
                    this.mDH.dDK().dTy();
                    return;
                }
                return;
            }
            this.mDH.dDK().dTx();
            this.mDH.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mDR) {
            TiebaStatic.log(new ar("c13198").dY("tid", this.mDH.getTid()));
            e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.mDH != null && c.this.mDH.dDK() != null) {
                        c.this.mDH.dDK().dTx();
                    }
                }
            }, 100L);
            this.mDH.finish();
        } else if (view == this.iYR) {
            TiebaStatic.log(new ar("c13199").al("obj_locate", 4).dY("tid", this.mDH.getTid()));
            if (this.tid == 0) {
                this.mDH.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mDH).createNormalCfg(this.tid + "", null, null)));
            this.mDH.dDK().dTy();
            this.mDH.finish();
        } else if (view == this.mDW) {
            TiebaStatic.log(new ar("c13199").al("obj_locate", 3).dY("tid", this.mDH.getTid()));
        }
    }

    public void onPause() {
        if (this.mDT != null) {
            this.mDT.onPause();
        }
    }

    public void onDestroy() {
        if (this.mDT != null) {
            this.mDT.onDestroy();
        }
    }
}
