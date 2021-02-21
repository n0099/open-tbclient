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
/* loaded from: classes8.dex */
public class c implements View.OnClickListener {
    private TextView aYx;
    private com.baidu.tbadk.widget.richText.a eIB;
    private EditorScrollView fwr;
    private View jmv;
    private TbRichTextView jvg;
    private final PushDialogActivity mNL;
    private i mNP;
    private Drawable mNR;
    private View mNS;
    private TbImageView mNT;
    private TextView mNU;
    private ImageView mNV;
    private TextView mNW;
    private PushDialogVideoView mNX;
    private ClickableHeaderImageView mNY;
    private TextView mNZ;
    private CommonUserLikeButton mOa;
    private TextView mOb;
    private boolean mOc = false;
    private View mRootView;
    private long tid;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.mNL = pushDialogActivity;
        this.mNL.setContentView(i);
        this.mRootView = findViewById(R.id.root_view);
        this.mNS = findViewById(R.id.dialog_wrapper_view);
        this.fwr = (EditorScrollView) findViewById(R.id.push_dialog_content_layout);
        this.fwr.setOverScrollMode(2);
        this.fwr.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.mOc) {
                    TiebaStatic.log(new ar("c13199").ap("obj_locate", 1).dR("tid", c.this.mNL.getTid()));
                    c.this.mOc = true;
                }
            }
        });
        if (this.mNS.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mNS.getLayoutParams();
            int equipmentHeight = l.getEquipmentHeight(this.mNL);
            layoutParams.height = equipmentHeight / 2;
            layoutParams.topMargin = (int) (equipmentHeight * 0.22f);
            this.mNS.postInvalidate();
        }
        if (l.isFlymeOsAbove35()) {
            this.mNR = com.baidu.tieba.v.b.dRV();
            if (this.mNR != null && this.mNL.getWindow() != null) {
                this.mNL.getWindow().setBackgroundDrawable(this.mNR);
            }
        }
        this.jmv = findViewById(R.id.push_dialog_bottom_layout);
        this.jmv.setOnClickListener(this);
        this.mOb = (TextView) findViewById(R.id.comment_num);
        this.mNT = (TbImageView) findViewById(R.id.push_dialog_title_img);
        this.mNT.setDefaultBgResource(R.drawable.tb_launcher_icon);
        this.mNT.setAutoChangeStyle(false);
        this.mNU = (TextView) findViewById(R.id.push_dialog_title_text);
        this.mNW = (TextView) findViewById(R.id.push_dialog_content_title);
        this.mNY = (ClickableHeaderImageView) findViewById(R.id.push_dialog_user_head);
        this.mNY.setBorderSurroundContent(true);
        this.mNY.setIsRound(true);
        this.mNY.setEnabled(false);
        this.mNY.setAutoChangeStyle(false);
        this.mNY.setBorderWidth(l.getDimens(this.mNL, R.dimen.tbds1));
        this.mNY.setBorderColor(ContextCompat.getColor(this.mNL, R.color.black_alpha15));
        this.eIB = new com.baidu.tbadk.widget.richText.a();
        this.jvg = (TbRichTextView) findViewById(R.id.push_dialog_content);
        this.jvg.setTextColor(ContextCompat.getColor(this.mNL, R.color.CAM_X0107));
        this.eIB.sd(l.getDimens(this.mNL, R.dimen.tbds38));
        this.eIB.setTextSize(l.getDimens(this.mNL, R.dimen.tbds42));
        this.eIB.sh(l.getDimens(this.mNL, R.dimen.tbds23));
        this.eIB.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.eIB.bo(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.jvg.setLayoutStrategy(this.eIB);
        this.mNX = (PushDialogVideoView) findViewById(R.id.push_dialog_video);
        this.mNX.setPageContext(this.mNL.getPageContext());
        this.aYx = (TextView) findViewById(R.id.push_dialog_user_name);
        this.mNZ = (TextView) findViewById(R.id.push_dialog_user_god_info);
        this.mOa = (CommonUserLikeButton) findViewById(R.id.push_dialog_user_like_btn);
        this.mOa.setAfterOnClickListener(this);
        this.mNV = (ImageView) findViewById(R.id.dialog_close_btn);
        this.mNV.setOnClickListener(this);
    }

    public void onResume() {
        if (this.mNX != null) {
            this.mNX.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.mNL.findViewById(i);
    }

    public void dCk() {
        if (this.mNX != null) {
            this.mNX.setNetworkChange();
            if (j.isMobileNet() && this.mNX.rl() && this.mNP != null && this.mNP.getFileSize() > 0 && this.mNP.getDuration() > 0) {
                float fileSize = this.mNP.getFileSize() * (1.0f - ((this.mNX.getCurrentPosition() * 1.0f) / (this.mNP.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.mNL.getPageContext().getPageActivity(), String.format(this.mNL.getPageContext().getString(R.string.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int dimens;
        int dimens2;
        if (aVar != null) {
            this.mNT.startLoad(aVar.dCm(), 17, false);
            this.mNU.setText(aVar.dCl());
            if (aVar.dCo() != null) {
                this.mNY.setData(aVar.dCo());
                this.aYx.setText(aVar.dCo().getName_show());
                if (aVar.dCo().getGodUserData() != null && (!StringUtils.isNull(aVar.dCo().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.dCo().getGodUserData().getIntro()))) {
                    this.mNZ.setText(aVar.dCo().getGodUserData().getForumName() + "吧 " + aVar.dCo().getGodIntro());
                    this.mNZ.setVisibility(0);
                } else {
                    this.mNZ.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.dCo().getUserId())) {
                    this.mOa.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.mNL.getPageContext(), this.mOa).a(aVar.dCo());
                    this.mOa.onChangeSkinType(0);
                    this.mOa.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b dCn = aVar.dCn();
                if (dCn == null) {
                    this.mNL.dCa().dRR();
                    this.mNL.finish();
                    return;
                }
                boolean z = dCn.dCp() == null || y.isEmpty(dCn.dCp().bHz());
                if (StringUtils.isNull(dCn.getTitle()) && z) {
                    this.mNL.dCa().dRR();
                    this.mNL.finish();
                    return;
                }
                if (dCn.dCp() != null) {
                    Iterator<TbRichTextData> it = dCn.dCp().bHz().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.mNP = next.bHJ();
                        }
                        if (this.mNP != null) {
                            break;
                        }
                    }
                }
                this.tid = dCn.getTid();
                if (this.mNP == null) {
                    this.mNX.setVisibility(8);
                    this.jvg.setVisibility(0);
                    boolean z2 = j.is4GNet() || j.isWifiNet();
                    this.eIB.lJ(z2);
                    if (z2) {
                        dimens = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(this.mNL, R.dimen.tbds22) * 2)) - (l.getDimens(this.mNL, R.dimen.tbds44) * 2);
                        dimens2 = (int) (dimens * 1.618f);
                    } else {
                        dimens = l.getDimens(this.mNL, R.dimen.tbds360);
                        dimens2 = l.getDimens(this.mNL, R.dimen.tbds202);
                    }
                    this.eIB.lK(z2);
                    this.eIB.rY(dimens);
                    this.eIB.rZ(dimens2);
                    this.jvg.setText(dCn.dCp());
                } else {
                    this.jvg.setVisibility(8);
                    this.mNX.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mNX.getLayoutParams();
                    layoutParams.width = l.getEquipmentWidth(this.mNL) - l.getDimens(this.mNL, R.dimen.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.mNX.setLayoutParams(layoutParams);
                    this.mNX.setTbRichTextVideoInfo(this.mNP);
                    this.mNX.stopPlay();
                    this.mNX.setThumbnail(this.mNP.getThumbUrl());
                    this.mNX.setVideoUrl(this.mNP.getVideoUrl(), String.valueOf(this.tid));
                    this.mNX.cSK();
                    o oVar = new o();
                    oVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    oVar.amC = String.valueOf(this.tid);
                    oVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    this.mNX.setVideoViewBusiness(oVar);
                }
                if (StringUtils.isNull(dCn.getTitle())) {
                    this.mNW.setVisibility(8);
                } else {
                    this.mNW.setText(dCn.getTitle());
                    this.mNW.setVisibility(0);
                }
                this.mOb.setText(String.format(Locale.CHINA, this.mNL.getString(R.string.bottom_comment), Integer.valueOf(dCn.getPostNum())));
                if (!this.mNL.dCa().dRU()) {
                    this.mNL.dCa().dRS();
                    return;
                }
                return;
            }
            this.mNL.dCa().dRR();
            this.mNL.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mNV) {
            TiebaStatic.log(new ar("c13198").dR("tid", this.mNL.getTid()));
            e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.mNL != null && c.this.mNL.dCa() != null) {
                        c.this.mNL.dCa().dRR();
                    }
                }
            }, 100L);
            this.mNL.finish();
        } else if (view == this.jmv) {
            TiebaStatic.log(new ar("c13199").ap("obj_locate", 4).dR("tid", this.mNL.getTid()));
            if (this.tid == 0) {
                this.mNL.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mNL).createNormalCfg(this.tid + "", null, null)));
            this.mNL.dCa().dRS();
            this.mNL.finish();
        } else if (view == this.mOa) {
            TiebaStatic.log(new ar("c13199").ap("obj_locate", 3).dR("tid", this.mNL.getTid()));
        }
    }

    public void onPause() {
        if (this.mNX != null) {
            this.mNX.onPause();
        }
    }

    public void onDestroy() {
        if (this.mNX != null) {
            this.mNX.onDestroy();
        }
    }
}
