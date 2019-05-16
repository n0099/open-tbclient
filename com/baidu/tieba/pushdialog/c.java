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
    private TbRichTextView gQY;
    private final PushDialogActivity ivK;
    private f ivO;
    private Drawable ivQ;
    private View ivR;
    private TbImageView ivS;
    private TextView ivT;
    private ImageView ivU;
    private TextView ivV;
    private PushDialogVideoView ivW;
    private ClickableHeaderImageView ivX;
    private TextView ivY;
    private CommonUserLikeButton ivZ;
    private View iwa;
    private TextView iwb;
    private com.baidu.tbadk.widget.richText.a iwc;
    private boolean iwd = false;
    private View mRootView;
    private long tid;
    private TextView tvUserName;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.ivK = pushDialogActivity;
        this.ivK.setContentView(i);
        this.mRootView = findViewById(R.id.root_view);
        this.ivR = findViewById(R.id.dialog_wrapper_view);
        this.ckY = (EditorScrollView) findViewById(R.id.push_dialog_content_layout);
        this.ckY.setOverScrollMode(2);
        this.ckY.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.iwd) {
                    TiebaStatic.log(new am("c13199").P("obj_locate", 1).bT("tid", c.this.ivK.getTid()));
                    c.this.iwd = true;
                }
            }
        });
        if (this.ivR.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ivR.getLayoutParams();
            int ah = l.ah(this.ivK);
            layoutParams.height = ah / 2;
            layoutParams.topMargin = (int) (ah * 0.22f);
            this.ivR.postInvalidate();
        }
        if (l.kl()) {
            this.ivQ = com.baidu.tieba.t.b.cqK();
            if (this.ivQ != null && this.ivK.getWindow() != null) {
                this.ivK.getWindow().setBackgroundDrawable(this.ivQ);
            }
        }
        this.iwa = findViewById(R.id.push_dialog_bottom_layout);
        this.iwa.setOnClickListener(this);
        this.iwb = (TextView) findViewById(R.id.comment_num);
        this.ivS = (TbImageView) findViewById(R.id.push_dialog_title_img);
        this.ivS.setDefaultBgResource(R.drawable.icon);
        this.ivS.setAutoChangeStyle(false);
        this.ivT = (TextView) findViewById(R.id.push_dialog_title_text);
        this.ivV = (TextView) findViewById(R.id.push_dialog_content_title);
        this.ivX = (ClickableHeaderImageView) findViewById(R.id.push_dialog_user_head);
        this.ivX.setBorderSurroundContent(true);
        this.ivX.setIsRound(true);
        this.ivX.setEnabled(false);
        this.ivX.setAutoChangeStyle(false);
        this.ivX.setBorderWidth(l.g(this.ivK, R.dimen.tbds1));
        this.ivX.setBorderColor(ContextCompat.getColor(this.ivK, R.color.black_alpha15));
        this.iwc = new com.baidu.tbadk.widget.richText.a();
        this.gQY = (TbRichTextView) findViewById(R.id.push_dialog_content);
        this.gQY.setTextColor(ContextCompat.getColor(this.ivK, R.color.cp_cont_j));
        this.iwc.ls(l.g(this.ivK, R.dimen.tbds38));
        this.iwc.setTextSize(l.g(this.ivK, R.dimen.tbds42));
        this.iwc.lw(l.g(this.ivK, R.dimen.tbds23));
        this.iwc.setLineSpacing(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.iwc.ar(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.gQY.setLayoutStrategy(this.iwc);
        this.ivW = (PushDialogVideoView) findViewById(R.id.push_dialog_video);
        this.ivW.setPageContext(this.ivK.getPageContext());
        this.tvUserName = (TextView) findViewById(R.id.push_dialog_user_name);
        this.ivY = (TextView) findViewById(R.id.push_dialog_user_god_info);
        this.ivZ = (CommonUserLikeButton) findViewById(R.id.push_dialog_user_like_btn);
        this.ivZ.setAfterOnClickListener(this);
        this.ivU = (ImageView) findViewById(R.id.dialog_close_btn);
        this.ivU.setOnClickListener(this);
    }

    public void onResume() {
        if (this.ivW != null) {
            this.ivW.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.ivK.findViewById(i);
    }

    public void cdF() {
        if (this.ivW != null) {
            this.ivW.setNetworkChange();
            if (j.jU() && this.ivW.pg() && this.ivO != null && this.ivO.getFileSize() > 0 && this.ivO.getDuration() > 0) {
                float fileSize = this.ivO.getFileSize() * (1.0f - ((this.ivW.getCurrentPosition() * 1.0f) / (this.ivO.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.ivK.getPageContext().getPageActivity(), String.format(this.ivK.getPageContext().getString(R.string.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int g;
        int g2;
        if (aVar != null) {
            this.ivS.startLoad(aVar.cdH(), 17, false);
            this.ivT.setText(aVar.cdG());
            if (aVar.cdJ() != null) {
                this.ivX.setData(aVar.cdJ());
                this.tvUserName.setText(aVar.cdJ().getName_show());
                if (aVar.cdJ().getGodUserData() != null && (!StringUtils.isNull(aVar.cdJ().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.cdJ().getGodUserData().getIntro()))) {
                    this.ivY.setText(aVar.cdJ().getGodUserData().getForumName() + "吧 " + aVar.cdJ().getGodIntro());
                    this.ivY.setVisibility(0);
                } else {
                    this.ivY.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.cdJ().getUserId())) {
                    this.ivZ.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.ivK.getPageContext(), this.ivZ).a(aVar.cdJ());
                    this.ivZ.onChangeSkinType(0);
                    this.ivZ.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b cdI = aVar.cdI();
                if (cdI == null) {
                    this.ivK.cdw().cqH();
                    this.ivK.finish();
                    return;
                }
                boolean z = cdI.cdK() == null || v.aa(cdI.cdK().axy());
                if (StringUtils.isNull(cdI.getTitle()) && z) {
                    this.ivK.cdw().cqH();
                    this.ivK.finish();
                    return;
                }
                if (cdI.cdK() != null) {
                    Iterator<TbRichTextData> it = cdI.cdK().axy().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.ivO = next.axJ();
                        }
                        if (this.ivO != null) {
                            break;
                        }
                    }
                }
                this.tid = cdI.getTid();
                if (this.ivO == null) {
                    this.ivW.setVisibility(8);
                    this.gQY.setVisibility(0);
                    boolean z2 = j.jV() || j.jT();
                    this.iwc.fP(z2);
                    if (z2) {
                        g = (l.af(TbadkCoreApplication.getInst()) - (l.g(this.ivK, R.dimen.tbds22) * 2)) - (l.g(this.ivK, R.dimen.tbds44) * 2);
                        g2 = (int) (g * 1.618f);
                    } else {
                        g = l.g(this.ivK, R.dimen.tbds360);
                        g2 = l.g(this.ivK, R.dimen.tbds202);
                    }
                    this.iwc.fQ(z2);
                    this.iwc.ln(g);
                    this.iwc.lo(g2);
                    this.gQY.setText(cdI.cdK());
                } else {
                    this.gQY.setVisibility(8);
                    this.ivW.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ivW.getLayoutParams();
                    layoutParams.width = l.af(this.ivK) - l.g(this.ivK, R.dimen.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.ivW.setLayoutParams(layoutParams);
                    this.ivW.setTbRichTextVideoInfo(this.ivO);
                    this.ivW.stopPlay();
                    this.ivW.setIsNeedRecoveryVideoPlayer(true);
                    this.ivW.setThumbnail(this.ivO.getThumbUrl());
                    this.ivW.setVideoUrl(this.ivO.getVideoUrl(), String.valueOf(this.tid));
                    this.ivW.bvq();
                    n nVar = new n(this.ivK.getActivity());
                    nVar.Ci("2");
                    z zVar = new z();
                    zVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    zVar.bVL = String.valueOf(this.tid);
                    zVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    nVar.setVideoStatsData(zVar);
                    this.ivW.setQuickVideoViewBusiness(nVar);
                }
                if (StringUtils.isNull(cdI.getTitle())) {
                    this.ivV.setVisibility(8);
                } else {
                    this.ivV.setText(cdI.getTitle());
                    this.ivV.setVisibility(0);
                }
                this.iwb.setText(String.format(Locale.CHINA, this.ivK.getString(R.string.bottom_comment), Integer.valueOf(cdI.getPostNum())));
                if (!this.ivK.cdw().isScreenOn()) {
                    this.ivK.cdw().cqI();
                    return;
                }
                return;
            }
            this.ivK.cdw().cqH();
            this.ivK.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ivU) {
            TiebaStatic.log(new am("c13198").bT("tid", this.ivK.getTid()));
            e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.ivK != null && c.this.ivK.cdw() != null) {
                        c.this.ivK.cdw().cqH();
                    }
                }
            }, 100L);
            this.ivK.finish();
        } else if (view == this.iwa) {
            TiebaStatic.log(new am("c13199").P("obj_locate", 4).bT("tid", this.ivK.getTid()));
            if (this.tid == 0) {
                this.ivK.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.ivK).createNormalCfg(this.tid + "", null, null)));
            this.ivK.cdw().cqI();
            this.ivK.finish();
        } else if (view == this.ivZ) {
            TiebaStatic.log(new am("c13199").P("obj_locate", 3).bT("tid", this.ivK.getTid()));
        }
    }

    public void onPause() {
        if (this.ivW != null) {
            this.ivW.onPause();
        }
    }

    public void onDestroy() {
        if (this.ivW != null) {
            this.ivW.onDestroy();
        }
    }
}
