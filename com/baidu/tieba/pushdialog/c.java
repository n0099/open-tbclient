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
import com.baidu.tieba.e;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.z;
import com.tencent.connect.common.Constants;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Locale;
/* loaded from: classes3.dex */
public class c implements View.OnClickListener {
    private TbRichTextView fjm;
    private final PushDialogActivity gKR;
    private f gKV;
    private Drawable gKX;
    private View gKY;
    private TbImageView gKZ;
    private TextView gLa;
    private ImageView gLb;
    private TextView gLc;
    private PushDialogVideoView gLd;
    private ClickableHeaderImageView gLe;
    private TextView gLf;
    private CommonUserLikeButton gLg;
    private View gLh;
    private TextView gLi;
    private com.baidu.tbadk.widget.richText.a gLj;
    private boolean gLk = false;
    private EditorScrollView gam;
    private View mRootView;
    private long tid;
    private TextView tvUserName;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.gKR = pushDialogActivity;
        this.gKR.setContentView(i);
        this.mRootView = findViewById(e.g.root_view);
        this.gKY = findViewById(e.g.dialog_wrapper_view);
        this.gam = (EditorScrollView) findViewById(e.g.push_dialog_content_layout);
        this.gam.setOverScrollMode(2);
        this.gam.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.gLk) {
                    TiebaStatic.log(new am("c13199").x("obj_locate", 1).aA("tid", c.this.gKR.getTid()));
                    c.this.gLk = true;
                }
            }
        });
        if (this.gKY.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gKY.getLayoutParams();
            int aQ = l.aQ(this.gKR);
            layoutParams.height = aQ / 2;
            layoutParams.topMargin = (int) (aQ * 0.22f);
            this.gKY.postInvalidate();
        }
        if (l.ln()) {
            this.gKX = com.baidu.tieba.u.a.bIA();
            if (this.gKX != null && this.gKR.getWindow() != null) {
                this.gKR.getWindow().setBackgroundDrawable(this.gKX);
            }
        }
        this.gLh = findViewById(e.g.push_dialog_bottom_layout);
        this.gLh.setOnClickListener(this);
        this.gLi = (TextView) findViewById(e.g.comment_num);
        this.gKZ = (TbImageView) findViewById(e.g.push_dialog_title_img);
        this.gKZ.setDefaultBgResource(e.f.icon);
        this.gKZ.setAutoChangeStyle(false);
        this.gLa = (TextView) findViewById(e.g.push_dialog_title_text);
        this.gLc = (TextView) findViewById(e.g.push_dialog_content_title);
        this.gLe = (ClickableHeaderImageView) findViewById(e.g.push_dialog_user_head);
        this.gLe.setBorderSurroundContent(true);
        this.gLe.setIsRound(true);
        this.gLe.setEnabled(false);
        this.gLe.setAutoChangeStyle(false);
        this.gLe.setBorderWidth(l.h(this.gKR, e.C0210e.tbds1));
        this.gLe.setBorderColor(ContextCompat.getColor(this.gKR, e.d.black_alpha15));
        this.gLj = new com.baidu.tbadk.widget.richText.a();
        this.fjm = (TbRichTextView) findViewById(e.g.push_dialog_content);
        this.fjm.setTextColor(ContextCompat.getColor(this.gKR, e.d.cp_cont_j));
        this.gLj.gP(l.h(this.gKR, e.C0210e.tbds38));
        this.gLj.setTextSize(l.h(this.gKR, e.C0210e.tbds42));
        this.gLj.gT(l.h(this.gKR, e.C0210e.tbds23));
        this.gLj.setLineSpacing(l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds7), 1.0f);
        this.gLj.T(l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds48), l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds48));
        this.fjm.setLayoutStrategy(this.gLj);
        this.gLd = (PushDialogVideoView) findViewById(e.g.push_dialog_video);
        this.gLd.setPageContext(this.gKR.getPageContext());
        this.tvUserName = (TextView) findViewById(e.g.push_dialog_user_name);
        this.gLf = (TextView) findViewById(e.g.push_dialog_user_god_info);
        this.gLg = (CommonUserLikeButton) findViewById(e.g.push_dialog_user_like_btn);
        this.gLg.setAfterOnClickListener(this);
        this.gLb = (ImageView) findViewById(e.g.dialog_close_btn);
        this.gLb.setOnClickListener(this);
    }

    public void onResume() {
        if (this.gLd != null) {
            this.gLd.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.gKR.findViewById(i);
    }

    public void buk() {
        if (this.gLd != null) {
            this.gLd.setNetworkChange();
            if (j.kX() && this.gLd.brH() && this.gKV != null && this.gKV.getFileSize() > 0 && this.gKV.getDuration() > 0) {
                float fileSize = this.gKV.getFileSize() * (1.0f - ((this.gLd.getCurrentPosition() * 1.0f) / (this.gKV.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.gKR.getPageContext().getPageActivity(), String.format(this.gKR.getPageContext().getString(e.j.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int h;
        int h2;
        if (aVar != null) {
            this.gKZ.startLoad(aVar.bum(), 17, false);
            this.gLa.setText(aVar.bul());
            if (aVar.buo() != null) {
                this.gLe.setData(aVar.buo());
                this.tvUserName.setText(aVar.buo().getName_show());
                if (aVar.buo().getGodUserData() != null && (!StringUtils.isNull(aVar.buo().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.buo().getGodUserData().getIntro()))) {
                    this.gLf.setText(aVar.buo().getGodUserData().getForumName() + "吧 " + aVar.buo().getGodIntro());
                    this.gLf.setVisibility(0);
                } else {
                    this.gLf.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.buo().getUserId())) {
                    this.gLg.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.gKR.getPageContext(), this.gLg).a(aVar.buo());
                    this.gLg.onChangeSkinType(0);
                    this.gLg.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b bun = aVar.bun();
                if (bun == null) {
                    this.gKR.bub().bIx();
                    this.gKR.finish();
                    return;
                }
                boolean z = bun.bup() == null || v.I(bun.bup().Sb());
                if (StringUtils.isNull(bun.getTitle()) && z) {
                    this.gKR.bub().bIx();
                    this.gKR.finish();
                    return;
                }
                if (bun.bup() != null) {
                    Iterator<TbRichTextData> it = bun.bup().Sb().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.gKV = next.Sl();
                        }
                        if (this.gKV != null) {
                            break;
                        }
                    }
                }
                this.tid = bun.getTid();
                if (this.gKV == null) {
                    this.gLd.setVisibility(8);
                    this.fjm.setVisibility(0);
                    boolean z2 = j.kY() || j.kW();
                    this.gLj.cZ(z2);
                    if (z2) {
                        h = (l.aO(TbadkCoreApplication.getInst()) - (l.h(this.gKR, e.C0210e.tbds22) * 2)) - (l.h(this.gKR, e.C0210e.tbds44) * 2);
                        h2 = (int) (h * 1.618f);
                    } else {
                        h = l.h(this.gKR, e.C0210e.tbds360);
                        h2 = l.h(this.gKR, e.C0210e.tbds202);
                    }
                    this.gLj.da(z2);
                    this.gLj.gL(h);
                    this.gLj.gM(h2);
                    this.fjm.setText(bun.bup());
                } else {
                    this.fjm.setVisibility(8);
                    this.gLd.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gLd.getLayoutParams();
                    layoutParams.width = l.aO(this.gKR) - l.h(this.gKR, e.C0210e.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.gLd.setLayoutParams(layoutParams);
                    this.gLd.setTbRichTextVideoInfo(this.gKV);
                    this.gLd.stopPlay();
                    this.gLd.setIsNeedRecoveryVideoPlayer(true);
                    this.gLd.setThumbnail(this.gKV.getThumbUrl());
                    this.gLd.setVideoUrl(this.gKV.getVideoUrl(), String.valueOf(this.tid));
                    this.gLd.aMK();
                    n nVar = new n(this.gKR.getActivity());
                    nVar.tX("2");
                    z zVar = new z();
                    zVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    zVar.biz = String.valueOf(this.tid);
                    zVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    nVar.setVideoStatsData(zVar);
                    this.gLd.setQuickVideoViewBusiness(nVar);
                }
                if (StringUtils.isNull(bun.getTitle())) {
                    this.gLc.setVisibility(8);
                } else {
                    this.gLc.setText(bun.getTitle());
                    this.gLc.setVisibility(0);
                }
                this.gLi.setText(String.format(Locale.CHINA, this.gKR.getString(e.j.bottom_comment), Integer.valueOf(bun.getPostNum())));
                if (!this.gKR.bub().isScreenOn()) {
                    this.gKR.bub().bIy();
                    return;
                }
                return;
            }
            this.gKR.bub().bIx();
            this.gKR.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gLb) {
            TiebaStatic.log(new am("c13198").aA("tid", this.gKR.getTid()));
            com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.gKR != null && c.this.gKR.bub() != null) {
                        c.this.gKR.bub().bIx();
                    }
                }
            }, 100L);
            this.gKR.finish();
        } else if (view == this.gLh) {
            TiebaStatic.log(new am("c13199").x("obj_locate", 4).aA("tid", this.gKR.getTid()));
            if (this.tid == 0) {
                this.gKR.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.gKR).createNormalCfg(this.tid + "", null, null)));
            this.gKR.bub().bIy();
            this.gKR.finish();
        } else if (view == this.gLg) {
            TiebaStatic.log(new am("c13199").x("obj_locate", 3).aA("tid", this.gKR.getTid()));
        }
    }

    public void onPause() {
        if (this.gLd != null) {
            this.gLd.onPause();
        }
    }

    public void onDestroy() {
        if (this.gLd != null) {
            this.gLd.onDestroy();
        }
    }
}
