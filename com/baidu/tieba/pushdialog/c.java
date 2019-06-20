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
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.z;
import com.tencent.connect.common.Constants;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Locale;
/* loaded from: classes3.dex */
public class c implements View.OnClickListener {
    private EditorScrollView ckZ;
    private TbRichTextView gRd;
    private final PushDialogActivity ivO;
    private f ivS;
    private Drawable ivU;
    private View ivV;
    private TbImageView ivW;
    private TextView ivX;
    private ImageView ivY;
    private TextView ivZ;
    private PushDialogVideoView iwa;
    private ClickableHeaderImageView iwb;
    private TextView iwc;
    private CommonUserLikeButton iwd;
    private View iwe;
    private TextView iwf;
    private com.baidu.tbadk.widget.richText.a iwg;
    private boolean iwh = false;
    private View mRootView;
    private long tid;
    private TextView tvUserName;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.ivO = pushDialogActivity;
        this.ivO.setContentView(i);
        this.mRootView = findViewById(R.id.root_view);
        this.ivV = findViewById(R.id.dialog_wrapper_view);
        this.ckZ = (EditorScrollView) findViewById(R.id.push_dialog_content_layout);
        this.ckZ.setOverScrollMode(2);
        this.ckZ.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.iwh) {
                    TiebaStatic.log(new am("c13199").P("obj_locate", 1).bT("tid", c.this.ivO.getTid()));
                    c.this.iwh = true;
                }
            }
        });
        if (this.ivV.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ivV.getLayoutParams();
            int ah = l.ah(this.ivO);
            layoutParams.height = ah / 2;
            layoutParams.topMargin = (int) (ah * 0.22f);
            this.ivV.postInvalidate();
        }
        if (l.kl()) {
            this.ivU = com.baidu.tieba.t.b.cqN();
            if (this.ivU != null && this.ivO.getWindow() != null) {
                this.ivO.getWindow().setBackgroundDrawable(this.ivU);
            }
        }
        this.iwe = findViewById(R.id.push_dialog_bottom_layout);
        this.iwe.setOnClickListener(this);
        this.iwf = (TextView) findViewById(R.id.comment_num);
        this.ivW = (TbImageView) findViewById(R.id.push_dialog_title_img);
        this.ivW.setDefaultBgResource(R.drawable.icon);
        this.ivW.setAutoChangeStyle(false);
        this.ivX = (TextView) findViewById(R.id.push_dialog_title_text);
        this.ivZ = (TextView) findViewById(R.id.push_dialog_content_title);
        this.iwb = (ClickableHeaderImageView) findViewById(R.id.push_dialog_user_head);
        this.iwb.setBorderSurroundContent(true);
        this.iwb.setIsRound(true);
        this.iwb.setEnabled(false);
        this.iwb.setAutoChangeStyle(false);
        this.iwb.setBorderWidth(l.g(this.ivO, R.dimen.tbds1));
        this.iwb.setBorderColor(ContextCompat.getColor(this.ivO, R.color.black_alpha15));
        this.iwg = new com.baidu.tbadk.widget.richText.a();
        this.gRd = (TbRichTextView) findViewById(R.id.push_dialog_content);
        this.gRd.setTextColor(ContextCompat.getColor(this.ivO, R.color.cp_cont_j));
        this.iwg.ls(l.g(this.ivO, R.dimen.tbds38));
        this.iwg.setTextSize(l.g(this.ivO, R.dimen.tbds42));
        this.iwg.lw(l.g(this.ivO, R.dimen.tbds23));
        this.iwg.setLineSpacing(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.iwg.ar(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.gRd.setLayoutStrategy(this.iwg);
        this.iwa = (PushDialogVideoView) findViewById(R.id.push_dialog_video);
        this.iwa.setPageContext(this.ivO.getPageContext());
        this.tvUserName = (TextView) findViewById(R.id.push_dialog_user_name);
        this.iwc = (TextView) findViewById(R.id.push_dialog_user_god_info);
        this.iwd = (CommonUserLikeButton) findViewById(R.id.push_dialog_user_like_btn);
        this.iwd.setAfterOnClickListener(this);
        this.ivY = (ImageView) findViewById(R.id.dialog_close_btn);
        this.ivY.setOnClickListener(this);
    }

    public void onResume() {
        if (this.iwa != null) {
            this.iwa.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.ivO.findViewById(i);
    }

    public void cdJ() {
        if (this.iwa != null) {
            this.iwa.setNetworkChange();
            if (j.jU() && this.iwa.pg() && this.ivS != null && this.ivS.getFileSize() > 0 && this.ivS.getDuration() > 0) {
                float fileSize = this.ivS.getFileSize() * (1.0f - ((this.iwa.getCurrentPosition() * 1.0f) / (this.ivS.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.ivO.getPageContext().getPageActivity(), String.format(this.ivO.getPageContext().getString(R.string.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int g;
        int g2;
        if (aVar != null) {
            this.ivW.startLoad(aVar.cdL(), 17, false);
            this.ivX.setText(aVar.cdK());
            if (aVar.cdN() != null) {
                this.iwb.setData(aVar.cdN());
                this.tvUserName.setText(aVar.cdN().getName_show());
                if (aVar.cdN().getGodUserData() != null && (!StringUtils.isNull(aVar.cdN().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.cdN().getGodUserData().getIntro()))) {
                    this.iwc.setText(aVar.cdN().getGodUserData().getForumName() + "吧 " + aVar.cdN().getGodIntro());
                    this.iwc.setVisibility(0);
                } else {
                    this.iwc.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.cdN().getUserId())) {
                    this.iwd.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.ivO.getPageContext(), this.iwd).a(aVar.cdN());
                    this.iwd.onChangeSkinType(0);
                    this.iwd.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b cdM = aVar.cdM();
                if (cdM == null) {
                    this.ivO.cdA().cqK();
                    this.ivO.finish();
                    return;
                }
                boolean z = cdM.cdO() == null || v.aa(cdM.cdO().axz());
                if (StringUtils.isNull(cdM.getTitle()) && z) {
                    this.ivO.cdA().cqK();
                    this.ivO.finish();
                    return;
                }
                if (cdM.cdO() != null) {
                    Iterator<TbRichTextData> it = cdM.cdO().axz().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.ivS = next.axK();
                        }
                        if (this.ivS != null) {
                            break;
                        }
                    }
                }
                this.tid = cdM.getTid();
                if (this.ivS == null) {
                    this.iwa.setVisibility(8);
                    this.gRd.setVisibility(0);
                    boolean z2 = j.jV() || j.jT();
                    this.iwg.fP(z2);
                    if (z2) {
                        g = (l.af(TbadkCoreApplication.getInst()) - (l.g(this.ivO, R.dimen.tbds22) * 2)) - (l.g(this.ivO, R.dimen.tbds44) * 2);
                        g2 = (int) (g * 1.618f);
                    } else {
                        g = l.g(this.ivO, R.dimen.tbds360);
                        g2 = l.g(this.ivO, R.dimen.tbds202);
                    }
                    this.iwg.fQ(z2);
                    this.iwg.ln(g);
                    this.iwg.lo(g2);
                    this.gRd.setText(cdM.cdO());
                } else {
                    this.gRd.setVisibility(8);
                    this.iwa.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iwa.getLayoutParams();
                    layoutParams.width = l.af(this.ivO) - l.g(this.ivO, R.dimen.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.iwa.setLayoutParams(layoutParams);
                    this.iwa.setTbRichTextVideoInfo(this.ivS);
                    this.iwa.stopPlay();
                    this.iwa.setIsNeedRecoveryVideoPlayer(true);
                    this.iwa.setThumbnail(this.ivS.getThumbUrl());
                    this.iwa.setVideoUrl(this.ivS.getVideoUrl(), String.valueOf(this.tid));
                    this.iwa.bvu();
                    n nVar = new n(this.ivO.getActivity());
                    nVar.Ck("2");
                    z zVar = new z();
                    zVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    zVar.bVM = String.valueOf(this.tid);
                    zVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    nVar.setVideoStatsData(zVar);
                    this.iwa.setQuickVideoViewBusiness(nVar);
                }
                if (StringUtils.isNull(cdM.getTitle())) {
                    this.ivZ.setVisibility(8);
                } else {
                    this.ivZ.setText(cdM.getTitle());
                    this.ivZ.setVisibility(0);
                }
                this.iwf.setText(String.format(Locale.CHINA, this.ivO.getString(R.string.bottom_comment), Integer.valueOf(cdM.getPostNum())));
                if (!this.ivO.cdA().isScreenOn()) {
                    this.ivO.cdA().cqL();
                    return;
                }
                return;
            }
            this.ivO.cdA().cqK();
            this.ivO.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ivY) {
            TiebaStatic.log(new am("c13198").bT("tid", this.ivO.getTid()));
            e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.ivO != null && c.this.ivO.cdA() != null) {
                        c.this.ivO.cdA().cqK();
                    }
                }
            }, 100L);
            this.ivO.finish();
        } else if (view == this.iwe) {
            TiebaStatic.log(new am("c13199").P("obj_locate", 4).bT("tid", this.ivO.getTid()));
            if (this.tid == 0) {
                this.ivO.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.ivO).createNormalCfg(this.tid + "", null, null)));
            this.ivO.cdA().cqL();
            this.ivO.finish();
        } else if (view == this.iwd) {
            TiebaStatic.log(new am("c13199").P("obj_locate", 3).bT("tid", this.ivO.getTid()));
        }
    }

    public void onPause() {
        if (this.iwa != null) {
            this.iwa.onPause();
        }
    }

    public void onDestroy() {
        if (this.iwa != null) {
            this.iwa.onDestroy();
        }
    }
}
