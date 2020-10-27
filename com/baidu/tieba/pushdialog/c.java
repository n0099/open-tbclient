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
    private TextView aVE;
    private com.baidu.tbadk.widget.richText.a eqr;
    private EditorScrollView fcD;
    private View iHq;
    private TbRichTextView kqT;
    private View mRootView;
    private boolean mjA = false;
    private final PushDialogActivity mjj;
    private j mjn;
    private Drawable mjp;
    private View mjq;
    private TbImageView mjr;
    private TextView mjs;
    private ImageView mjt;
    private TextView mju;
    private PushDialogVideoView mjv;
    private ClickableHeaderImageView mjw;
    private TextView mjx;
    private CommonUserLikeButton mjy;
    private TextView mjz;
    private long tid;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.mjj = pushDialogActivity;
        this.mjj.setContentView(i);
        this.mRootView = findViewById(R.id.root_view);
        this.mjq = findViewById(R.id.dialog_wrapper_view);
        this.fcD = (EditorScrollView) findViewById(R.id.push_dialog_content_layout);
        this.fcD.setOverScrollMode(2);
        this.fcD.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.mjA) {
                    TiebaStatic.log(new aq("c13199").aj("obj_locate", 1).dR("tid", c.this.mjj.getTid()));
                    c.this.mjA = true;
                }
            }
        });
        if (this.mjq.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mjq.getLayoutParams();
            int equipmentHeight = l.getEquipmentHeight(this.mjj);
            layoutParams.height = equipmentHeight / 2;
            layoutParams.topMargin = (int) (equipmentHeight * 0.22f);
            this.mjq.postInvalidate();
        }
        if (l.isFlymeOsAbove35()) {
            this.mjp = com.baidu.tieba.v.b.dLI();
            if (this.mjp != null && this.mjj.getWindow() != null) {
                this.mjj.getWindow().setBackgroundDrawable(this.mjp);
            }
        }
        this.iHq = findViewById(R.id.push_dialog_bottom_layout);
        this.iHq.setOnClickListener(this);
        this.mjz = (TextView) findViewById(R.id.comment_num);
        this.mjr = (TbImageView) findViewById(R.id.push_dialog_title_img);
        this.mjr.setDefaultBgResource(R.drawable.tb_launcher_icon);
        this.mjr.setAutoChangeStyle(false);
        this.mjs = (TextView) findViewById(R.id.push_dialog_title_text);
        this.mju = (TextView) findViewById(R.id.push_dialog_content_title);
        this.mjw = (ClickableHeaderImageView) findViewById(R.id.push_dialog_user_head);
        this.mjw.setBorderSurroundContent(true);
        this.mjw.setIsRound(true);
        this.mjw.setEnabled(false);
        this.mjw.setAutoChangeStyle(false);
        this.mjw.setBorderWidth(l.getDimens(this.mjj, R.dimen.tbds1));
        this.mjw.setBorderColor(ContextCompat.getColor(this.mjj, R.color.black_alpha15));
        this.eqr = new com.baidu.tbadk.widget.richText.a();
        this.kqT = (TbRichTextView) findViewById(R.id.push_dialog_content);
        this.kqT.setTextColor(ContextCompat.getColor(this.mjj, R.color.cp_cont_j));
        this.eqr.si(l.getDimens(this.mjj, R.dimen.tbds38));
        this.eqr.setTextSize(l.getDimens(this.mjj, R.dimen.tbds42));
        this.eqr.sm(l.getDimens(this.mjj, R.dimen.tbds23));
        this.eqr.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.eqr.br(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.kqT.setLayoutStrategy(this.eqr);
        this.mjv = (PushDialogVideoView) findViewById(R.id.push_dialog_video);
        this.mjv.setPageContext(this.mjj.getPageContext());
        this.aVE = (TextView) findViewById(R.id.push_dialog_user_name);
        this.mjx = (TextView) findViewById(R.id.push_dialog_user_god_info);
        this.mjy = (CommonUserLikeButton) findViewById(R.id.push_dialog_user_like_btn);
        this.mjy.setAfterOnClickListener(this);
        this.mjt = (ImageView) findViewById(R.id.dialog_close_btn);
        this.mjt.setOnClickListener(this);
    }

    public void onResume() {
        if (this.mjv != null) {
            this.mjv.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.mjj.findViewById(i);
    }

    public void dwB() {
        if (this.mjv != null) {
            this.mjv.setNetworkChange();
            if (com.baidu.adp.lib.util.j.isMobileNet() && this.mjv.rK() && this.mjn != null && this.mjn.getFileSize() > 0 && this.mjn.getDuration() > 0) {
                float fileSize = this.mjn.getFileSize() * (1.0f - ((this.mjv.getCurrentPosition() * 1.0f) / (this.mjn.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.mjj.getPageContext().getPageActivity(), String.format(this.mjj.getPageContext().getString(R.string.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int dimens;
        int dimens2;
        if (aVar != null) {
            this.mjr.startLoad(aVar.dwD(), 17, false);
            this.mjs.setText(aVar.dwC());
            if (aVar.dwF() != null) {
                this.mjw.setData(aVar.dwF());
                this.aVE.setText(aVar.dwF().getName_show());
                if (aVar.dwF().getGodUserData() != null && (!StringUtils.isNull(aVar.dwF().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.dwF().getGodUserData().getIntro()))) {
                    this.mjx.setText(aVar.dwF().getGodUserData().getForumName() + "吧 " + aVar.dwF().getGodIntro());
                    this.mjx.setVisibility(0);
                } else {
                    this.mjx.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.dwF().getUserId())) {
                    this.mjy.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.mjj.getPageContext(), this.mjy).a(aVar.dwF());
                    this.mjy.onChangeSkinType(0);
                    this.mjy.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b dwE = aVar.dwE();
                if (dwE == null) {
                    this.mjj.dwr().dLE();
                    this.mjj.finish();
                    return;
                }
                boolean z = dwE.dwG() == null || y.isEmpty(dwE.dwG().bDj());
                if (StringUtils.isNull(dwE.getTitle()) && z) {
                    this.mjj.dwr().dLE();
                    this.mjj.finish();
                    return;
                }
                if (dwE.dwG() != null) {
                    Iterator<TbRichTextData> it = dwE.dwG().bDj().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.mjn = next.bDt();
                        }
                        if (this.mjn != null) {
                            break;
                        }
                    }
                }
                this.tid = dwE.getTid();
                if (this.mjn == null) {
                    this.mjv.setVisibility(8);
                    this.kqT.setVisibility(0);
                    boolean z2 = com.baidu.adp.lib.util.j.is4GNet() || com.baidu.adp.lib.util.j.isWifiNet();
                    this.eqr.kJ(z2);
                    if (z2) {
                        dimens = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(this.mjj, R.dimen.tbds22) * 2)) - (l.getDimens(this.mjj, R.dimen.tbds44) * 2);
                        dimens2 = (int) (dimens * 1.618f);
                    } else {
                        dimens = l.getDimens(this.mjj, R.dimen.tbds360);
                        dimens2 = l.getDimens(this.mjj, R.dimen.tbds202);
                    }
                    this.eqr.kK(z2);
                    this.eqr.sd(dimens);
                    this.eqr.se(dimens2);
                    this.kqT.setText(dwE.dwG());
                } else {
                    this.kqT.setVisibility(8);
                    this.mjv.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mjv.getLayoutParams();
                    layoutParams.width = l.getEquipmentWidth(this.mjj) - l.getDimens(this.mjj, R.dimen.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.mjv.setLayoutParams(layoutParams);
                    this.mjv.setTbRichTextVideoInfo(this.mjn);
                    this.mjv.stopPlay();
                    this.mjv.setThumbnail(this.mjn.getThumbUrl());
                    this.mjv.setVideoUrl(this.mjn.getVideoUrl(), String.valueOf(this.tid));
                    this.mjv.cJS();
                    o oVar = new o();
                    oVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    oVar.alT = String.valueOf(this.tid);
                    oVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    this.mjv.setVideoViewBusiness(oVar);
                }
                if (StringUtils.isNull(dwE.getTitle())) {
                    this.mju.setVisibility(8);
                } else {
                    this.mju.setText(dwE.getTitle());
                    this.mju.setVisibility(0);
                }
                this.mjz.setText(String.format(Locale.CHINA, this.mjj.getString(R.string.bottom_comment), Integer.valueOf(dwE.getPostNum())));
                if (!this.mjj.dwr().dLH()) {
                    this.mjj.dwr().dLF();
                    return;
                }
                return;
            }
            this.mjj.dwr().dLE();
            this.mjj.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mjt) {
            TiebaStatic.log(new aq("c13198").dR("tid", this.mjj.getTid()));
            e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.mjj != null && c.this.mjj.dwr() != null) {
                        c.this.mjj.dwr().dLE();
                    }
                }
            }, 100L);
            this.mjj.finish();
        } else if (view == this.iHq) {
            TiebaStatic.log(new aq("c13199").aj("obj_locate", 4).dR("tid", this.mjj.getTid()));
            if (this.tid == 0) {
                this.mjj.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mjj).createNormalCfg(this.tid + "", null, null)));
            this.mjj.dwr().dLF();
            this.mjj.finish();
        } else if (view == this.mjy) {
            TiebaStatic.log(new aq("c13199").aj("obj_locate", 3).dR("tid", this.mjj.getTid()));
        }
    }

    public void onPause() {
        if (this.mjv != null) {
            this.mjv.onPause();
        }
    }

    public void onDestroy() {
        if (this.mjv != null) {
            this.mjv.onDestroy();
        }
    }
}
