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
    private EditorScrollView fXu;
    private TbRichTextView fgt;
    private final PushDialogActivity gIa;
    private f gIe;
    private Drawable gIg;
    private View gIh;
    private TbImageView gIi;
    private TextView gIj;
    private ImageView gIk;
    private TextView gIl;
    private PushDialogVideoView gIm;
    private ClickableHeaderImageView gIn;
    private TextView gIo;
    private CommonUserLikeButton gIp;
    private View gIq;
    private TextView gIr;
    private com.baidu.tbadk.widget.richText.a gIs;
    private boolean gIt = false;
    private View mRootView;
    private long tid;
    private TextView tvUserName;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.gIa = pushDialogActivity;
        this.gIa.setContentView(i);
        this.mRootView = findViewById(e.g.root_view);
        this.gIh = findViewById(e.g.dialog_wrapper_view);
        this.fXu = (EditorScrollView) findViewById(e.g.push_dialog_content_layout);
        this.fXu.setOverScrollMode(2);
        this.fXu.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.gIt) {
                    TiebaStatic.log(new am("c13199").x("obj_locate", 1).aA("tid", c.this.gIa.getTid()));
                    c.this.gIt = true;
                }
            }
        });
        if (this.gIh.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gIh.getLayoutParams();
            int aQ = l.aQ(this.gIa);
            layoutParams.height = aQ / 2;
            layoutParams.topMargin = (int) (aQ * 0.22f);
            this.gIh.postInvalidate();
        }
        if (l.ln()) {
            this.gIg = com.baidu.tieba.t.a.bHK();
            if (this.gIg != null && this.gIa.getWindow() != null) {
                this.gIa.getWindow().setBackgroundDrawable(this.gIg);
            }
        }
        this.gIq = findViewById(e.g.push_dialog_bottom_layout);
        this.gIq.setOnClickListener(this);
        this.gIr = (TextView) findViewById(e.g.comment_num);
        this.gIi = (TbImageView) findViewById(e.g.push_dialog_title_img);
        this.gIi.setDefaultBgResource(e.f.icon);
        this.gIi.setAutoChangeStyle(false);
        this.gIj = (TextView) findViewById(e.g.push_dialog_title_text);
        this.gIl = (TextView) findViewById(e.g.push_dialog_content_title);
        this.gIn = (ClickableHeaderImageView) findViewById(e.g.push_dialog_user_head);
        this.gIn.setBorderSurroundContent(true);
        this.gIn.setIsRound(true);
        this.gIn.setEnabled(false);
        this.gIn.setAutoChangeStyle(false);
        this.gIn.setBorderWidth(l.h(this.gIa, e.C0210e.tbds1));
        this.gIn.setBorderColor(ContextCompat.getColor(this.gIa, e.d.black_alpha15));
        this.gIs = new com.baidu.tbadk.widget.richText.a();
        this.fgt = (TbRichTextView) findViewById(e.g.push_dialog_content);
        this.fgt.setTextColor(ContextCompat.getColor(this.gIa, e.d.cp_cont_j));
        this.gIs.gO(l.h(this.gIa, e.C0210e.tbds38));
        this.gIs.setTextSize(l.h(this.gIa, e.C0210e.tbds42));
        this.gIs.gS(l.h(this.gIa, e.C0210e.tbds23));
        this.gIs.setLineSpacing(l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds7), 1.0f);
        this.gIs.T(l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds48), l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds48));
        this.fgt.setLayoutStrategy(this.gIs);
        this.gIm = (PushDialogVideoView) findViewById(e.g.push_dialog_video);
        this.gIm.setPageContext(this.gIa.getPageContext());
        this.tvUserName = (TextView) findViewById(e.g.push_dialog_user_name);
        this.gIo = (TextView) findViewById(e.g.push_dialog_user_god_info);
        this.gIp = (CommonUserLikeButton) findViewById(e.g.push_dialog_user_like_btn);
        this.gIp.setAfterOnClickListener(this);
        this.gIk = (ImageView) findViewById(e.g.dialog_close_btn);
        this.gIk.setOnClickListener(this);
    }

    public void onResume() {
        if (this.gIm != null) {
            this.gIm.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.gIa.findViewById(i);
    }

    public void bty() {
        if (this.gIm != null) {
            this.gIm.setNetworkChange();
            if (j.kX() && this.gIm.bqV() && this.gIe != null && this.gIe.getFileSize() > 0 && this.gIe.getDuration() > 0) {
                float fileSize = this.gIe.getFileSize() * (1.0f - ((this.gIm.getCurrentPosition() * 1.0f) / (this.gIe.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.gIa.getPageContext().getPageActivity(), String.format(this.gIa.getPageContext().getString(e.j.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int h;
        int h2;
        if (aVar != null) {
            this.gIi.startLoad(aVar.btA(), 17, false);
            this.gIj.setText(aVar.btz());
            if (aVar.btC() != null) {
                this.gIn.setData(aVar.btC());
                this.tvUserName.setText(aVar.btC().getName_show());
                if (aVar.btC().getGodUserData() != null && (!StringUtils.isNull(aVar.btC().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.btC().getGodUserData().getIntro()))) {
                    this.gIo.setText(aVar.btC().getGodUserData().getForumName() + "吧 " + aVar.btC().getGodIntro());
                    this.gIo.setVisibility(0);
                } else {
                    this.gIo.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.btC().getUserId())) {
                    this.gIp.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.gIa.getPageContext(), this.gIp).a(aVar.btC());
                    this.gIp.onChangeSkinType(0);
                    this.gIp.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b btB = aVar.btB();
                if (btB == null) {
                    this.gIa.btp().bHH();
                    this.gIa.finish();
                    return;
                }
                boolean z = btB.btD() == null || v.I(btB.btD().RZ());
                if (StringUtils.isNull(btB.getTitle()) && z) {
                    this.gIa.btp().bHH();
                    this.gIa.finish();
                    return;
                }
                if (btB.btD() != null) {
                    Iterator<TbRichTextData> it = btB.btD().RZ().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.gIe = next.Sj();
                        }
                        if (this.gIe != null) {
                            break;
                        }
                    }
                }
                this.tid = btB.getTid();
                if (this.gIe == null) {
                    this.gIm.setVisibility(8);
                    this.fgt.setVisibility(0);
                    boolean z2 = j.kY() || j.kW();
                    this.gIs.cZ(z2);
                    if (z2) {
                        h = (l.aO(TbadkCoreApplication.getInst()) - (l.h(this.gIa, e.C0210e.tbds22) * 2)) - (l.h(this.gIa, e.C0210e.tbds44) * 2);
                        h2 = (int) (h * 1.618f);
                    } else {
                        h = l.h(this.gIa, e.C0210e.tbds360);
                        h2 = l.h(this.gIa, e.C0210e.tbds202);
                    }
                    this.gIs.da(z2);
                    this.gIs.gK(h);
                    this.gIs.gL(h2);
                    this.fgt.setText(btB.btD());
                } else {
                    this.fgt.setVisibility(8);
                    this.gIm.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gIm.getLayoutParams();
                    layoutParams.width = l.aO(this.gIa) - l.h(this.gIa, e.C0210e.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.gIm.setLayoutParams(layoutParams);
                    this.gIm.setTbRichTextVideoInfo(this.gIe);
                    this.gIm.stopPlay();
                    this.gIm.setIsNeedRecoveryVideoPlayer(true);
                    this.gIm.setThumbnail(this.gIe.getThumbUrl());
                    this.gIm.setVideoUrl(this.gIe.getVideoUrl(), String.valueOf(this.tid));
                    this.gIm.aLW();
                    n nVar = new n(this.gIa.getActivity());
                    nVar.tU("2");
                    z zVar = new z();
                    zVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    zVar.biw = String.valueOf(this.tid);
                    zVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    nVar.setVideoStatsData(zVar);
                    this.gIm.setQuickVideoViewBusiness(nVar);
                }
                if (StringUtils.isNull(btB.getTitle())) {
                    this.gIl.setVisibility(8);
                } else {
                    this.gIl.setText(btB.getTitle());
                    this.gIl.setVisibility(0);
                }
                this.gIr.setText(String.format(Locale.CHINA, this.gIa.getString(e.j.bottom_comment), Integer.valueOf(btB.getPostNum())));
                if (!this.gIa.btp().isScreenOn()) {
                    this.gIa.btp().bHI();
                    return;
                }
                return;
            }
            this.gIa.btp().bHH();
            this.gIa.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gIk) {
            TiebaStatic.log(new am("c13198").aA("tid", this.gIa.getTid()));
            com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.gIa != null && c.this.gIa.btp() != null) {
                        c.this.gIa.btp().bHH();
                    }
                }
            }, 100L);
            this.gIa.finish();
        } else if (view == this.gIq) {
            TiebaStatic.log(new am("c13199").x("obj_locate", 4).aA("tid", this.gIa.getTid()));
            if (this.tid == 0) {
                this.gIa.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.gIa).createNormalCfg(this.tid + "", null, null)));
            this.gIa.btp().bHI();
            this.gIa.finish();
        } else if (view == this.gIp) {
            TiebaStatic.log(new am("c13199").x("obj_locate", 3).aA("tid", this.gIa.getTid()));
        }
    }

    public void onPause() {
        if (this.gIm != null) {
            this.gIm.onPause();
        }
    }

    public void onDestroy() {
        if (this.gIm != null) {
            this.gIm.onDestroy();
        }
    }
}
