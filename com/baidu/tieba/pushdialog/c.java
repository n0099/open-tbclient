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
    private TbRichTextView fkc;
    private final PushDialogActivity gLW;
    private f gMa;
    private Drawable gMc;
    private View gMd;
    private TbImageView gMe;
    private TextView gMf;
    private ImageView gMg;
    private TextView gMh;
    private PushDialogVideoView gMi;
    private ClickableHeaderImageView gMj;
    private TextView gMk;
    private CommonUserLikeButton gMl;
    private View gMm;
    private TextView gMn;
    private com.baidu.tbadk.widget.richText.a gMo;
    private boolean gMp = false;
    private EditorScrollView gbk;
    private View mRootView;
    private long tid;
    private TextView tvUserName;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.gLW = pushDialogActivity;
        this.gLW.setContentView(i);
        this.mRootView = findViewById(e.g.root_view);
        this.gMd = findViewById(e.g.dialog_wrapper_view);
        this.gbk = (EditorScrollView) findViewById(e.g.push_dialog_content_layout);
        this.gbk.setOverScrollMode(2);
        this.gbk.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.gMp) {
                    TiebaStatic.log(new am("c13199").y("obj_locate", 1).aB("tid", c.this.gLW.getTid()));
                    c.this.gMp = true;
                }
            }
        });
        if (this.gMd.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gMd.getLayoutParams();
            int aQ = l.aQ(this.gLW);
            layoutParams.height = aQ / 2;
            layoutParams.topMargin = (int) (aQ * 0.22f);
            this.gMd.postInvalidate();
        }
        if (l.ln()) {
            this.gMc = com.baidu.tieba.u.a.bJj();
            if (this.gMc != null && this.gLW.getWindow() != null) {
                this.gLW.getWindow().setBackgroundDrawable(this.gMc);
            }
        }
        this.gMm = findViewById(e.g.push_dialog_bottom_layout);
        this.gMm.setOnClickListener(this);
        this.gMn = (TextView) findViewById(e.g.comment_num);
        this.gMe = (TbImageView) findViewById(e.g.push_dialog_title_img);
        this.gMe.setDefaultBgResource(e.f.icon);
        this.gMe.setAutoChangeStyle(false);
        this.gMf = (TextView) findViewById(e.g.push_dialog_title_text);
        this.gMh = (TextView) findViewById(e.g.push_dialog_content_title);
        this.gMj = (ClickableHeaderImageView) findViewById(e.g.push_dialog_user_head);
        this.gMj.setBorderSurroundContent(true);
        this.gMj.setIsRound(true);
        this.gMj.setEnabled(false);
        this.gMj.setAutoChangeStyle(false);
        this.gMj.setBorderWidth(l.h(this.gLW, e.C0210e.tbds1));
        this.gMj.setBorderColor(ContextCompat.getColor(this.gLW, e.d.black_alpha15));
        this.gMo = new com.baidu.tbadk.widget.richText.a();
        this.fkc = (TbRichTextView) findViewById(e.g.push_dialog_content);
        this.fkc.setTextColor(ContextCompat.getColor(this.gLW, e.d.cp_cont_j));
        this.gMo.gP(l.h(this.gLW, e.C0210e.tbds38));
        this.gMo.setTextSize(l.h(this.gLW, e.C0210e.tbds42));
        this.gMo.gT(l.h(this.gLW, e.C0210e.tbds23));
        this.gMo.setLineSpacing(l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds7), 1.0f);
        this.gMo.T(l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds48), l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds48));
        this.fkc.setLayoutStrategy(this.gMo);
        this.gMi = (PushDialogVideoView) findViewById(e.g.push_dialog_video);
        this.gMi.setPageContext(this.gLW.getPageContext());
        this.tvUserName = (TextView) findViewById(e.g.push_dialog_user_name);
        this.gMk = (TextView) findViewById(e.g.push_dialog_user_god_info);
        this.gMl = (CommonUserLikeButton) findViewById(e.g.push_dialog_user_like_btn);
        this.gMl.setAfterOnClickListener(this);
        this.gMg = (ImageView) findViewById(e.g.dialog_close_btn);
        this.gMg.setOnClickListener(this);
    }

    public void onResume() {
        if (this.gMi != null) {
            this.gMi.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.gLW.findViewById(i);
    }

    public void buT() {
        if (this.gMi != null) {
            this.gMi.setNetworkChange();
            if (j.kX() && this.gMi.bsq() && this.gMa != null && this.gMa.getFileSize() > 0 && this.gMa.getDuration() > 0) {
                float fileSize = this.gMa.getFileSize() * (1.0f - ((this.gMi.getCurrentPosition() * 1.0f) / (this.gMa.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.gLW.getPageContext().getPageActivity(), String.format(this.gLW.getPageContext().getString(e.j.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int h;
        int h2;
        if (aVar != null) {
            this.gMe.startLoad(aVar.buV(), 17, false);
            this.gMf.setText(aVar.buU());
            if (aVar.buX() != null) {
                this.gMj.setData(aVar.buX());
                this.tvUserName.setText(aVar.buX().getName_show());
                if (aVar.buX().getGodUserData() != null && (!StringUtils.isNull(aVar.buX().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.buX().getGodUserData().getIntro()))) {
                    this.gMk.setText(aVar.buX().getGodUserData().getForumName() + "吧 " + aVar.buX().getGodIntro());
                    this.gMk.setVisibility(0);
                } else {
                    this.gMk.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.buX().getUserId())) {
                    this.gMl.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.gLW.getPageContext(), this.gMl).a(aVar.buX());
                    this.gMl.onChangeSkinType(0);
                    this.gMl.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b buW = aVar.buW();
                if (buW == null) {
                    this.gLW.buK().bJg();
                    this.gLW.finish();
                    return;
                }
                boolean z = buW.buY() == null || v.I(buW.buY().Sx());
                if (StringUtils.isNull(buW.getTitle()) && z) {
                    this.gLW.buK().bJg();
                    this.gLW.finish();
                    return;
                }
                if (buW.buY() != null) {
                    Iterator<TbRichTextData> it = buW.buY().Sx().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.gMa = next.SH();
                        }
                        if (this.gMa != null) {
                            break;
                        }
                    }
                }
                this.tid = buW.getTid();
                if (this.gMa == null) {
                    this.gMi.setVisibility(8);
                    this.fkc.setVisibility(0);
                    boolean z2 = j.kY() || j.kW();
                    this.gMo.dc(z2);
                    if (z2) {
                        h = (l.aO(TbadkCoreApplication.getInst()) - (l.h(this.gLW, e.C0210e.tbds22) * 2)) - (l.h(this.gLW, e.C0210e.tbds44) * 2);
                        h2 = (int) (h * 1.618f);
                    } else {
                        h = l.h(this.gLW, e.C0210e.tbds360);
                        h2 = l.h(this.gLW, e.C0210e.tbds202);
                    }
                    this.gMo.dd(z2);
                    this.gMo.gL(h);
                    this.gMo.gM(h2);
                    this.fkc.setText(buW.buY());
                } else {
                    this.fkc.setVisibility(8);
                    this.gMi.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gMi.getLayoutParams();
                    layoutParams.width = l.aO(this.gLW) - l.h(this.gLW, e.C0210e.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.gMi.setLayoutParams(layoutParams);
                    this.gMi.setTbRichTextVideoInfo(this.gMa);
                    this.gMi.stopPlay();
                    this.gMi.setIsNeedRecoveryVideoPlayer(true);
                    this.gMi.setThumbnail(this.gMa.getThumbUrl());
                    this.gMi.setVideoUrl(this.gMa.getVideoUrl(), String.valueOf(this.tid));
                    this.gMi.aNk();
                    n nVar = new n(this.gLW.getActivity());
                    nVar.un("2");
                    z zVar = new z();
                    zVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    zVar.bjn = String.valueOf(this.tid);
                    zVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    nVar.setVideoStatsData(zVar);
                    this.gMi.setQuickVideoViewBusiness(nVar);
                }
                if (StringUtils.isNull(buW.getTitle())) {
                    this.gMh.setVisibility(8);
                } else {
                    this.gMh.setText(buW.getTitle());
                    this.gMh.setVisibility(0);
                }
                this.gMn.setText(String.format(Locale.CHINA, this.gLW.getString(e.j.bottom_comment), Integer.valueOf(buW.getPostNum())));
                if (!this.gLW.buK().isScreenOn()) {
                    this.gLW.buK().bJh();
                    return;
                }
                return;
            }
            this.gLW.buK().bJg();
            this.gLW.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gMg) {
            TiebaStatic.log(new am("c13198").aB("tid", this.gLW.getTid()));
            com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.gLW != null && c.this.gLW.buK() != null) {
                        c.this.gLW.buK().bJg();
                    }
                }
            }, 100L);
            this.gLW.finish();
        } else if (view == this.gMm) {
            TiebaStatic.log(new am("c13199").y("obj_locate", 4).aB("tid", this.gLW.getTid()));
            if (this.tid == 0) {
                this.gLW.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.gLW).createNormalCfg(this.tid + "", null, null)));
            this.gLW.buK().bJh();
            this.gLW.finish();
        } else if (view == this.gMl) {
            TiebaStatic.log(new am("c13199").y("obj_locate", 3).aB("tid", this.gLW.getTid()));
        }
    }

    public void onPause() {
        if (this.gMi != null) {
            this.gMi.onPause();
        }
    }

    public void onDestroy() {
        if (this.gMi != null) {
            this.gMi.onDestroy();
        }
    }
}
