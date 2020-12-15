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
    private View iYT;
    private TbRichTextView jhs;
    private final PushDialogActivity mDJ;
    private i mDN;
    private Drawable mDP;
    private View mDQ;
    private TbImageView mDR;
    private TextView mDS;
    private ImageView mDT;
    private TextView mDU;
    private PushDialogVideoView mDV;
    private ClickableHeaderImageView mDW;
    private TextView mDX;
    private CommonUserLikeButton mDY;
    private TextView mDZ;
    private boolean mEa = false;
    private View mRootView;
    private long tid;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.mDJ = pushDialogActivity;
        this.mDJ.setContentView(i);
        this.mRootView = findViewById(R.id.root_view);
        this.mDQ = findViewById(R.id.dialog_wrapper_view);
        this.fpb = (EditorScrollView) findViewById(R.id.push_dialog_content_layout);
        this.fpb.setOverScrollMode(2);
        this.fpb.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.mEa) {
                    TiebaStatic.log(new ar("c13199").al("obj_locate", 1).dY("tid", c.this.mDJ.getTid()));
                    c.this.mEa = true;
                }
            }
        });
        if (this.mDQ.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mDQ.getLayoutParams();
            int equipmentHeight = l.getEquipmentHeight(this.mDJ);
            layoutParams.height = equipmentHeight / 2;
            layoutParams.topMargin = (int) (equipmentHeight * 0.22f);
            this.mDQ.postInvalidate();
        }
        if (l.isFlymeOsAbove35()) {
            this.mDP = com.baidu.tieba.w.b.dTC();
            if (this.mDP != null && this.mDJ.getWindow() != null) {
                this.mDJ.getWindow().setBackgroundDrawable(this.mDP);
            }
        }
        this.iYT = findViewById(R.id.push_dialog_bottom_layout);
        this.iYT.setOnClickListener(this);
        this.mDZ = (TextView) findViewById(R.id.comment_num);
        this.mDR = (TbImageView) findViewById(R.id.push_dialog_title_img);
        this.mDR.setDefaultBgResource(R.drawable.tb_launcher_icon);
        this.mDR.setAutoChangeStyle(false);
        this.mDS = (TextView) findViewById(R.id.push_dialog_title_text);
        this.mDU = (TextView) findViewById(R.id.push_dialog_content_title);
        this.mDW = (ClickableHeaderImageView) findViewById(R.id.push_dialog_user_head);
        this.mDW.setBorderSurroundContent(true);
        this.mDW.setIsRound(true);
        this.mDW.setEnabled(false);
        this.mDW.setAutoChangeStyle(false);
        this.mDW.setBorderWidth(l.getDimens(this.mDJ, R.dimen.tbds1));
        this.mDW.setBorderColor(ContextCompat.getColor(this.mDJ, R.color.black_alpha15));
        this.eBD = new com.baidu.tbadk.widget.richText.a();
        this.jhs = (TbRichTextView) findViewById(R.id.push_dialog_content);
        this.jhs.setTextColor(ContextCompat.getColor(this.mDJ, R.color.CAM_X0107));
        this.eBD.tt(l.getDimens(this.mDJ, R.dimen.tbds38));
        this.eBD.setTextSize(l.getDimens(this.mDJ, R.dimen.tbds42));
        this.eBD.tx(l.getDimens(this.mDJ, R.dimen.tbds23));
        this.eBD.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.eBD.bt(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.jhs.setLayoutStrategy(this.eBD);
        this.mDV = (PushDialogVideoView) findViewById(R.id.push_dialog_video);
        this.mDV.setPageContext(this.mDJ.getPageContext());
        this.aYw = (TextView) findViewById(R.id.push_dialog_user_name);
        this.mDX = (TextView) findViewById(R.id.push_dialog_user_god_info);
        this.mDY = (CommonUserLikeButton) findViewById(R.id.push_dialog_user_like_btn);
        this.mDY.setAfterOnClickListener(this);
        this.mDT = (ImageView) findViewById(R.id.dialog_close_btn);
        this.mDT.setOnClickListener(this);
    }

    public void onResume() {
        if (this.mDV != null) {
            this.mDV.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.mDJ.findViewById(i);
    }

    public void dDV() {
        if (this.mDV != null) {
            this.mDV.setNetworkChange();
            if (j.isMobileNet() && this.mDV.rM() && this.mDN != null && this.mDN.getFileSize() > 0 && this.mDN.getDuration() > 0) {
                float fileSize = this.mDN.getFileSize() * (1.0f - ((this.mDV.getCurrentPosition() * 1.0f) / (this.mDN.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.mDJ.getPageContext().getPageActivity(), String.format(this.mDJ.getPageContext().getString(R.string.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int dimens;
        int dimens2;
        if (aVar != null) {
            this.mDR.startLoad(aVar.dDX(), 17, false);
            this.mDS.setText(aVar.dDW());
            if (aVar.dDZ() != null) {
                this.mDW.setData(aVar.dDZ());
                this.aYw.setText(aVar.dDZ().getName_show());
                if (aVar.dDZ().getGodUserData() != null && (!StringUtils.isNull(aVar.dDZ().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.dDZ().getGodUserData().getIntro()))) {
                    this.mDX.setText(aVar.dDZ().getGodUserData().getForumName() + "吧 " + aVar.dDZ().getGodIntro());
                    this.mDX.setVisibility(0);
                } else {
                    this.mDX.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.dDZ().getUserId())) {
                    this.mDY.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.mDJ.getPageContext(), this.mDY).a(aVar.dDZ());
                    this.mDY.onChangeSkinType(0);
                    this.mDY.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b dDY = aVar.dDY();
                if (dDY == null) {
                    this.mDJ.dDL().dTy();
                    this.mDJ.finish();
                    return;
                }
                boolean z = dDY.dEa() == null || y.isEmpty(dDY.dEa().bIC());
                if (StringUtils.isNull(dDY.getTitle()) && z) {
                    this.mDJ.dDL().dTy();
                    this.mDJ.finish();
                    return;
                }
                if (dDY.dEa() != null) {
                    Iterator<TbRichTextData> it = dDY.dEa().bIC().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.mDN = next.bIM();
                        }
                        if (this.mDN != null) {
                            break;
                        }
                    }
                }
                this.tid = dDY.getTid();
                if (this.mDN == null) {
                    this.mDV.setVisibility(8);
                    this.jhs.setVisibility(0);
                    boolean z2 = j.is4GNet() || j.isWifiNet();
                    this.eBD.ln(z2);
                    if (z2) {
                        dimens = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(this.mDJ, R.dimen.tbds22) * 2)) - (l.getDimens(this.mDJ, R.dimen.tbds44) * 2);
                        dimens2 = (int) (dimens * 1.618f);
                    } else {
                        dimens = l.getDimens(this.mDJ, R.dimen.tbds360);
                        dimens2 = l.getDimens(this.mDJ, R.dimen.tbds202);
                    }
                    this.eBD.lo(z2);
                    this.eBD.to(dimens);
                    this.eBD.tp(dimens2);
                    this.jhs.setText(dDY.dEa());
                } else {
                    this.jhs.setVisibility(8);
                    this.mDV.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mDV.getLayoutParams();
                    layoutParams.width = l.getEquipmentWidth(this.mDJ) - l.getDimens(this.mDJ, R.dimen.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.mDV.setLayoutParams(layoutParams);
                    this.mDV.setTbRichTextVideoInfo(this.mDN);
                    this.mDV.stopPlay();
                    this.mDV.setThumbnail(this.mDN.getThumbUrl());
                    this.mDV.setVideoUrl(this.mDN.getVideoUrl(), String.valueOf(this.tid));
                    this.mDV.cRp();
                    o oVar = new o();
                    oVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    oVar.amY = String.valueOf(this.tid);
                    oVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    this.mDV.setVideoViewBusiness(oVar);
                }
                if (StringUtils.isNull(dDY.getTitle())) {
                    this.mDU.setVisibility(8);
                } else {
                    this.mDU.setText(dDY.getTitle());
                    this.mDU.setVisibility(0);
                }
                this.mDZ.setText(String.format(Locale.CHINA, this.mDJ.getString(R.string.bottom_comment), Integer.valueOf(dDY.getPostNum())));
                if (!this.mDJ.dDL().dTB()) {
                    this.mDJ.dDL().dTz();
                    return;
                }
                return;
            }
            this.mDJ.dDL().dTy();
            this.mDJ.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mDT) {
            TiebaStatic.log(new ar("c13198").dY("tid", this.mDJ.getTid()));
            e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.mDJ != null && c.this.mDJ.dDL() != null) {
                        c.this.mDJ.dDL().dTy();
                    }
                }
            }, 100L);
            this.mDJ.finish();
        } else if (view == this.iYT) {
            TiebaStatic.log(new ar("c13199").al("obj_locate", 4).dY("tid", this.mDJ.getTid()));
            if (this.tid == 0) {
                this.mDJ.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mDJ).createNormalCfg(this.tid + "", null, null)));
            this.mDJ.dDL().dTz();
            this.mDJ.finish();
        } else if (view == this.mDY) {
            TiebaStatic.log(new ar("c13199").al("obj_locate", 3).dY("tid", this.mDJ.getTid()));
        }
    }

    public void onPause() {
        if (this.mDV != null) {
            this.mDV.onPause();
        }
    }

    public void onDestroy() {
        if (this.mDV != null) {
            this.mDV.onDestroy();
        }
    }
}
