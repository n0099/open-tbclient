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
    private EditorScrollView ckY;
    private TbRichTextView gRb;
    private final PushDialogActivity ivN;
    private f ivR;
    private Drawable ivT;
    private View ivU;
    private TbImageView ivV;
    private TextView ivW;
    private ImageView ivX;
    private TextView ivY;
    private PushDialogVideoView ivZ;
    private ClickableHeaderImageView iwa;
    private TextView iwb;
    private CommonUserLikeButton iwc;
    private View iwd;
    private TextView iwe;
    private com.baidu.tbadk.widget.richText.a iwf;
    private boolean iwg = false;
    private View mRootView;
    private long tid;
    private TextView tvUserName;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.ivN = pushDialogActivity;
        this.ivN.setContentView(i);
        this.mRootView = findViewById(R.id.root_view);
        this.ivU = findViewById(R.id.dialog_wrapper_view);
        this.ckY = (EditorScrollView) findViewById(R.id.push_dialog_content_layout);
        this.ckY.setOverScrollMode(2);
        this.ckY.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.iwg) {
                    TiebaStatic.log(new am("c13199").P("obj_locate", 1).bT("tid", c.this.ivN.getTid()));
                    c.this.iwg = true;
                }
            }
        });
        if (this.ivU.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ivU.getLayoutParams();
            int ah = l.ah(this.ivN);
            layoutParams.height = ah / 2;
            layoutParams.topMargin = (int) (ah * 0.22f);
            this.ivU.postInvalidate();
        }
        if (l.kl()) {
            this.ivT = com.baidu.tieba.t.b.cqM();
            if (this.ivT != null && this.ivN.getWindow() != null) {
                this.ivN.getWindow().setBackgroundDrawable(this.ivT);
            }
        }
        this.iwd = findViewById(R.id.push_dialog_bottom_layout);
        this.iwd.setOnClickListener(this);
        this.iwe = (TextView) findViewById(R.id.comment_num);
        this.ivV = (TbImageView) findViewById(R.id.push_dialog_title_img);
        this.ivV.setDefaultBgResource(R.drawable.icon);
        this.ivV.setAutoChangeStyle(false);
        this.ivW = (TextView) findViewById(R.id.push_dialog_title_text);
        this.ivY = (TextView) findViewById(R.id.push_dialog_content_title);
        this.iwa = (ClickableHeaderImageView) findViewById(R.id.push_dialog_user_head);
        this.iwa.setBorderSurroundContent(true);
        this.iwa.setIsRound(true);
        this.iwa.setEnabled(false);
        this.iwa.setAutoChangeStyle(false);
        this.iwa.setBorderWidth(l.g(this.ivN, R.dimen.tbds1));
        this.iwa.setBorderColor(ContextCompat.getColor(this.ivN, R.color.black_alpha15));
        this.iwf = new com.baidu.tbadk.widget.richText.a();
        this.gRb = (TbRichTextView) findViewById(R.id.push_dialog_content);
        this.gRb.setTextColor(ContextCompat.getColor(this.ivN, R.color.cp_cont_j));
        this.iwf.ls(l.g(this.ivN, R.dimen.tbds38));
        this.iwf.setTextSize(l.g(this.ivN, R.dimen.tbds42));
        this.iwf.lw(l.g(this.ivN, R.dimen.tbds23));
        this.iwf.setLineSpacing(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.iwf.ar(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.gRb.setLayoutStrategy(this.iwf);
        this.ivZ = (PushDialogVideoView) findViewById(R.id.push_dialog_video);
        this.ivZ.setPageContext(this.ivN.getPageContext());
        this.tvUserName = (TextView) findViewById(R.id.push_dialog_user_name);
        this.iwb = (TextView) findViewById(R.id.push_dialog_user_god_info);
        this.iwc = (CommonUserLikeButton) findViewById(R.id.push_dialog_user_like_btn);
        this.iwc.setAfterOnClickListener(this);
        this.ivX = (ImageView) findViewById(R.id.dialog_close_btn);
        this.ivX.setOnClickListener(this);
    }

    public void onResume() {
        if (this.ivZ != null) {
            this.ivZ.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.ivN.findViewById(i);
    }

    public void cdI() {
        if (this.ivZ != null) {
            this.ivZ.setNetworkChange();
            if (j.jU() && this.ivZ.pg() && this.ivR != null && this.ivR.getFileSize() > 0 && this.ivR.getDuration() > 0) {
                float fileSize = this.ivR.getFileSize() * (1.0f - ((this.ivZ.getCurrentPosition() * 1.0f) / (this.ivR.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.ivN.getPageContext().getPageActivity(), String.format(this.ivN.getPageContext().getString(R.string.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int g;
        int g2;
        if (aVar != null) {
            this.ivV.startLoad(aVar.cdK(), 17, false);
            this.ivW.setText(aVar.cdJ());
            if (aVar.cdM() != null) {
                this.iwa.setData(aVar.cdM());
                this.tvUserName.setText(aVar.cdM().getName_show());
                if (aVar.cdM().getGodUserData() != null && (!StringUtils.isNull(aVar.cdM().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.cdM().getGodUserData().getIntro()))) {
                    this.iwb.setText(aVar.cdM().getGodUserData().getForumName() + "吧 " + aVar.cdM().getGodIntro());
                    this.iwb.setVisibility(0);
                } else {
                    this.iwb.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.cdM().getUserId())) {
                    this.iwc.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.ivN.getPageContext(), this.iwc).a(aVar.cdM());
                    this.iwc.onChangeSkinType(0);
                    this.iwc.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b cdL = aVar.cdL();
                if (cdL == null) {
                    this.ivN.cdz().cqJ();
                    this.ivN.finish();
                    return;
                }
                boolean z = cdL.cdN() == null || v.aa(cdL.cdN().axz());
                if (StringUtils.isNull(cdL.getTitle()) && z) {
                    this.ivN.cdz().cqJ();
                    this.ivN.finish();
                    return;
                }
                if (cdL.cdN() != null) {
                    Iterator<TbRichTextData> it = cdL.cdN().axz().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.ivR = next.axK();
                        }
                        if (this.ivR != null) {
                            break;
                        }
                    }
                }
                this.tid = cdL.getTid();
                if (this.ivR == null) {
                    this.ivZ.setVisibility(8);
                    this.gRb.setVisibility(0);
                    boolean z2 = j.jV() || j.jT();
                    this.iwf.fP(z2);
                    if (z2) {
                        g = (l.af(TbadkCoreApplication.getInst()) - (l.g(this.ivN, R.dimen.tbds22) * 2)) - (l.g(this.ivN, R.dimen.tbds44) * 2);
                        g2 = (int) (g * 1.618f);
                    } else {
                        g = l.g(this.ivN, R.dimen.tbds360);
                        g2 = l.g(this.ivN, R.dimen.tbds202);
                    }
                    this.iwf.fQ(z2);
                    this.iwf.ln(g);
                    this.iwf.lo(g2);
                    this.gRb.setText(cdL.cdN());
                } else {
                    this.gRb.setVisibility(8);
                    this.ivZ.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ivZ.getLayoutParams();
                    layoutParams.width = l.af(this.ivN) - l.g(this.ivN, R.dimen.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.ivZ.setLayoutParams(layoutParams);
                    this.ivZ.setTbRichTextVideoInfo(this.ivR);
                    this.ivZ.stopPlay();
                    this.ivZ.setIsNeedRecoveryVideoPlayer(true);
                    this.ivZ.setThumbnail(this.ivR.getThumbUrl());
                    this.ivZ.setVideoUrl(this.ivR.getVideoUrl(), String.valueOf(this.tid));
                    this.ivZ.bvt();
                    n nVar = new n(this.ivN.getActivity());
                    nVar.Ci("2");
                    z zVar = new z();
                    zVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    zVar.bVL = String.valueOf(this.tid);
                    zVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    nVar.setVideoStatsData(zVar);
                    this.ivZ.setQuickVideoViewBusiness(nVar);
                }
                if (StringUtils.isNull(cdL.getTitle())) {
                    this.ivY.setVisibility(8);
                } else {
                    this.ivY.setText(cdL.getTitle());
                    this.ivY.setVisibility(0);
                }
                this.iwe.setText(String.format(Locale.CHINA, this.ivN.getString(R.string.bottom_comment), Integer.valueOf(cdL.getPostNum())));
                if (!this.ivN.cdz().isScreenOn()) {
                    this.ivN.cdz().cqK();
                    return;
                }
                return;
            }
            this.ivN.cdz().cqJ();
            this.ivN.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ivX) {
            TiebaStatic.log(new am("c13198").bT("tid", this.ivN.getTid()));
            e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.ivN != null && c.this.ivN.cdz() != null) {
                        c.this.ivN.cdz().cqJ();
                    }
                }
            }, 100L);
            this.ivN.finish();
        } else if (view == this.iwd) {
            TiebaStatic.log(new am("c13199").P("obj_locate", 4).bT("tid", this.ivN.getTid()));
            if (this.tid == 0) {
                this.ivN.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.ivN).createNormalCfg(this.tid + "", null, null)));
            this.ivN.cdz().cqK();
            this.ivN.finish();
        } else if (view == this.iwc) {
            TiebaStatic.log(new am("c13199").P("obj_locate", 3).bT("tid", this.ivN.getTid()));
        }
    }

    public void onPause() {
        if (this.ivZ != null) {
            this.ivZ.onPause();
        }
    }

    public void onDestroy() {
        if (this.ivZ != null) {
            this.ivZ.onDestroy();
        }
    }
}
