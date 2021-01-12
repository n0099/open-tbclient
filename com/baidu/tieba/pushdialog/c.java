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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
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
    private TextView aVp;
    private com.baidu.tbadk.widget.richText.a eGv;
    private EditorScrollView fub;
    private View jgz;
    private TbRichTextView jpm;
    private TextView mEA;
    private ImageView mEB;
    private TextView mEC;
    private PushDialogVideoView mED;
    private ClickableHeaderImageView mEE;
    private TextView mEF;
    private CommonUserLikeButton mEG;
    private TextView mEH;
    private boolean mEI = false;
    private final PushDialogActivity mEr;
    private i mEv;
    private Drawable mEx;
    private View mEy;
    private TbImageView mEz;
    private View mRootView;
    private long tid;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.mEr = pushDialogActivity;
        this.mEr.setContentView(i);
        this.mRootView = findViewById(R.id.root_view);
        this.mEy = findViewById(R.id.dialog_wrapper_view);
        this.fub = (EditorScrollView) findViewById(R.id.push_dialog_content_layout);
        this.fub.setOverScrollMode(2);
        this.fub.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.mEI) {
                    TiebaStatic.log(new aq("c13199").an("obj_locate", 1).dW("tid", c.this.mEr.getTid()));
                    c.this.mEI = true;
                }
            }
        });
        if (this.mEy.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mEy.getLayoutParams();
            int equipmentHeight = l.getEquipmentHeight(this.mEr);
            layoutParams.height = equipmentHeight / 2;
            layoutParams.topMargin = (int) (equipmentHeight * 0.22f);
            this.mEy.postInvalidate();
        }
        if (l.isFlymeOsAbove35()) {
            this.mEx = com.baidu.tieba.v.b.dPC();
            if (this.mEx != null && this.mEr.getWindow() != null) {
                this.mEr.getWindow().setBackgroundDrawable(this.mEx);
            }
        }
        this.jgz = findViewById(R.id.push_dialog_bottom_layout);
        this.jgz.setOnClickListener(this);
        this.mEH = (TextView) findViewById(R.id.comment_num);
        this.mEz = (TbImageView) findViewById(R.id.push_dialog_title_img);
        this.mEz.setDefaultBgResource(R.drawable.tb_launcher_icon);
        this.mEz.setAutoChangeStyle(false);
        this.mEA = (TextView) findViewById(R.id.push_dialog_title_text);
        this.mEC = (TextView) findViewById(R.id.push_dialog_content_title);
        this.mEE = (ClickableHeaderImageView) findViewById(R.id.push_dialog_user_head);
        this.mEE.setBorderSurroundContent(true);
        this.mEE.setIsRound(true);
        this.mEE.setEnabled(false);
        this.mEE.setAutoChangeStyle(false);
        this.mEE.setBorderWidth(l.getDimens(this.mEr, R.dimen.tbds1));
        this.mEE.setBorderColor(ContextCompat.getColor(this.mEr, R.color.black_alpha15));
        this.eGv = new com.baidu.tbadk.widget.richText.a();
        this.jpm = (TbRichTextView) findViewById(R.id.push_dialog_content);
        this.jpm.setTextColor(ContextCompat.getColor(this.mEr, R.color.CAM_X0107));
        this.eGv.rY(l.getDimens(this.mEr, R.dimen.tbds38));
        this.eGv.setTextSize(l.getDimens(this.mEr, R.dimen.tbds42));
        this.eGv.sc(l.getDimens(this.mEr, R.dimen.tbds23));
        this.eGv.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.eGv.br(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.jpm.setLayoutStrategy(this.eGv);
        this.mED = (PushDialogVideoView) findViewById(R.id.push_dialog_video);
        this.mED.setPageContext(this.mEr.getPageContext());
        this.aVp = (TextView) findViewById(R.id.push_dialog_user_name);
        this.mEF = (TextView) findViewById(R.id.push_dialog_user_god_info);
        this.mEG = (CommonUserLikeButton) findViewById(R.id.push_dialog_user_like_btn);
        this.mEG.setAfterOnClickListener(this);
        this.mEB = (ImageView) findViewById(R.id.dialog_close_btn);
        this.mEB.setOnClickListener(this);
    }

    public void onResume() {
        if (this.mED != null) {
            this.mED.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.mEr.findViewById(i);
    }

    public void dzT() {
        if (this.mED != null) {
            this.mED.setNetworkChange();
            if (j.isMobileNet() && this.mED.rn() && this.mEv != null && this.mEv.getFileSize() > 0 && this.mEv.getDuration() > 0) {
                float fileSize = this.mEv.getFileSize() * (1.0f - ((this.mED.getCurrentPosition() * 1.0f) / (this.mEv.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.mEr.getPageContext().getPageActivity(), String.format(this.mEr.getPageContext().getString(R.string.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int dimens;
        int dimens2;
        if (aVar != null) {
            this.mEz.startLoad(aVar.dzV(), 17, false);
            this.mEA.setText(aVar.dzU());
            if (aVar.dzX() != null) {
                this.mEE.setData(aVar.dzX());
                this.aVp.setText(aVar.dzX().getName_show());
                if (aVar.dzX().getGodUserData() != null && (!StringUtils.isNull(aVar.dzX().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.dzX().getGodUserData().getIntro()))) {
                    this.mEF.setText(aVar.dzX().getGodUserData().getForumName() + "吧 " + aVar.dzX().getGodIntro());
                    this.mEF.setVisibility(0);
                } else {
                    this.mEF.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.dzX().getUserId())) {
                    this.mEG.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.mEr.getPageContext(), this.mEG).a(aVar.dzX());
                    this.mEG.onChangeSkinType(0);
                    this.mEG.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b dzW = aVar.dzW();
                if (dzW == null) {
                    this.mEr.dzJ().dPy();
                    this.mEr.finish();
                    return;
                }
                boolean z = dzW.dzY() == null || x.isEmpty(dzW.dzY().bHf());
                if (StringUtils.isNull(dzW.getTitle()) && z) {
                    this.mEr.dzJ().dPy();
                    this.mEr.finish();
                    return;
                }
                if (dzW.dzY() != null) {
                    Iterator<TbRichTextData> it = dzW.dzY().bHf().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.mEv = next.bHp();
                        }
                        if (this.mEv != null) {
                            break;
                        }
                    }
                }
                this.tid = dzW.getTid();
                if (this.mEv == null) {
                    this.mED.setVisibility(8);
                    this.jpm.setVisibility(0);
                    boolean z2 = j.is4GNet() || j.isWifiNet();
                    this.eGv.lF(z2);
                    if (z2) {
                        dimens = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(this.mEr, R.dimen.tbds22) * 2)) - (l.getDimens(this.mEr, R.dimen.tbds44) * 2);
                        dimens2 = (int) (dimens * 1.618f);
                    } else {
                        dimens = l.getDimens(this.mEr, R.dimen.tbds360);
                        dimens2 = l.getDimens(this.mEr, R.dimen.tbds202);
                    }
                    this.eGv.lG(z2);
                    this.eGv.rT(dimens);
                    this.eGv.rU(dimens2);
                    this.jpm.setText(dzW.dzY());
                } else {
                    this.jpm.setVisibility(8);
                    this.mED.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mED.getLayoutParams();
                    layoutParams.width = l.getEquipmentWidth(this.mEr) - l.getDimens(this.mEr, R.dimen.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.mED.setLayoutParams(layoutParams);
                    this.mED.setTbRichTextVideoInfo(this.mEv);
                    this.mED.stopPlay();
                    this.mED.setThumbnail(this.mEv.getThumbUrl());
                    this.mED.setVideoUrl(this.mEv.getVideoUrl(), String.valueOf(this.tid));
                    this.mED.cQE();
                    o oVar = new o();
                    oVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    oVar.amM = String.valueOf(this.tid);
                    oVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    this.mED.setVideoViewBusiness(oVar);
                }
                if (StringUtils.isNull(dzW.getTitle())) {
                    this.mEC.setVisibility(8);
                } else {
                    this.mEC.setText(dzW.getTitle());
                    this.mEC.setVisibility(0);
                }
                this.mEH.setText(String.format(Locale.CHINA, this.mEr.getString(R.string.bottom_comment), Integer.valueOf(dzW.getPostNum())));
                if (!this.mEr.dzJ().dPB()) {
                    this.mEr.dzJ().dPz();
                    return;
                }
                return;
            }
            this.mEr.dzJ().dPy();
            this.mEr.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mEB) {
            TiebaStatic.log(new aq("c13198").dW("tid", this.mEr.getTid()));
            e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.mEr != null && c.this.mEr.dzJ() != null) {
                        c.this.mEr.dzJ().dPy();
                    }
                }
            }, 100L);
            this.mEr.finish();
        } else if (view == this.jgz) {
            TiebaStatic.log(new aq("c13199").an("obj_locate", 4).dW("tid", this.mEr.getTid()));
            if (this.tid == 0) {
                this.mEr.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mEr).createNormalCfg(this.tid + "", null, null)));
            this.mEr.dzJ().dPz();
            this.mEr.finish();
        } else if (view == this.mEG) {
            TiebaStatic.log(new aq("c13199").an("obj_locate", 3).dW("tid", this.mEr.getTid()));
        }
    }

    public void onPause() {
        if (this.mED != null) {
            this.mED.onPause();
        }
    }

    public void onDestroy() {
        if (this.mED != null) {
            this.mED.onDestroy();
        }
    }
}
