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
    private TbRichTextView fkb;
    private final PushDialogActivity gLV;
    private f gLZ;
    private Drawable gMb;
    private View gMc;
    private TbImageView gMd;
    private TextView gMe;
    private ImageView gMf;
    private TextView gMg;
    private PushDialogVideoView gMh;
    private ClickableHeaderImageView gMi;
    private TextView gMj;
    private CommonUserLikeButton gMk;
    private View gMl;
    private TextView gMm;
    private com.baidu.tbadk.widget.richText.a gMn;
    private boolean gMo = false;
    private EditorScrollView gbj;
    private View mRootView;
    private long tid;
    private TextView tvUserName;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.gLV = pushDialogActivity;
        this.gLV.setContentView(i);
        this.mRootView = findViewById(e.g.root_view);
        this.gMc = findViewById(e.g.dialog_wrapper_view);
        this.gbj = (EditorScrollView) findViewById(e.g.push_dialog_content_layout);
        this.gbj.setOverScrollMode(2);
        this.gbj.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.gMo) {
                    TiebaStatic.log(new am("c13199").y("obj_locate", 1).aB("tid", c.this.gLV.getTid()));
                    c.this.gMo = true;
                }
            }
        });
        if (this.gMc.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gMc.getLayoutParams();
            int aQ = l.aQ(this.gLV);
            layoutParams.height = aQ / 2;
            layoutParams.topMargin = (int) (aQ * 0.22f);
            this.gMc.postInvalidate();
        }
        if (l.ln()) {
            this.gMb = com.baidu.tieba.u.a.bJj();
            if (this.gMb != null && this.gLV.getWindow() != null) {
                this.gLV.getWindow().setBackgroundDrawable(this.gMb);
            }
        }
        this.gMl = findViewById(e.g.push_dialog_bottom_layout);
        this.gMl.setOnClickListener(this);
        this.gMm = (TextView) findViewById(e.g.comment_num);
        this.gMd = (TbImageView) findViewById(e.g.push_dialog_title_img);
        this.gMd.setDefaultBgResource(e.f.icon);
        this.gMd.setAutoChangeStyle(false);
        this.gMe = (TextView) findViewById(e.g.push_dialog_title_text);
        this.gMg = (TextView) findViewById(e.g.push_dialog_content_title);
        this.gMi = (ClickableHeaderImageView) findViewById(e.g.push_dialog_user_head);
        this.gMi.setBorderSurroundContent(true);
        this.gMi.setIsRound(true);
        this.gMi.setEnabled(false);
        this.gMi.setAutoChangeStyle(false);
        this.gMi.setBorderWidth(l.h(this.gLV, e.C0210e.tbds1));
        this.gMi.setBorderColor(ContextCompat.getColor(this.gLV, e.d.black_alpha15));
        this.gMn = new com.baidu.tbadk.widget.richText.a();
        this.fkb = (TbRichTextView) findViewById(e.g.push_dialog_content);
        this.fkb.setTextColor(ContextCompat.getColor(this.gLV, e.d.cp_cont_j));
        this.gMn.gP(l.h(this.gLV, e.C0210e.tbds38));
        this.gMn.setTextSize(l.h(this.gLV, e.C0210e.tbds42));
        this.gMn.gT(l.h(this.gLV, e.C0210e.tbds23));
        this.gMn.setLineSpacing(l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds7), 1.0f);
        this.gMn.T(l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds48), l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds48));
        this.fkb.setLayoutStrategy(this.gMn);
        this.gMh = (PushDialogVideoView) findViewById(e.g.push_dialog_video);
        this.gMh.setPageContext(this.gLV.getPageContext());
        this.tvUserName = (TextView) findViewById(e.g.push_dialog_user_name);
        this.gMj = (TextView) findViewById(e.g.push_dialog_user_god_info);
        this.gMk = (CommonUserLikeButton) findViewById(e.g.push_dialog_user_like_btn);
        this.gMk.setAfterOnClickListener(this);
        this.gMf = (ImageView) findViewById(e.g.dialog_close_btn);
        this.gMf.setOnClickListener(this);
    }

    public void onResume() {
        if (this.gMh != null) {
            this.gMh.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.gLV.findViewById(i);
    }

    public void buT() {
        if (this.gMh != null) {
            this.gMh.setNetworkChange();
            if (j.kX() && this.gMh.bsq() && this.gLZ != null && this.gLZ.getFileSize() > 0 && this.gLZ.getDuration() > 0) {
                float fileSize = this.gLZ.getFileSize() * (1.0f - ((this.gMh.getCurrentPosition() * 1.0f) / (this.gLZ.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.gLV.getPageContext().getPageActivity(), String.format(this.gLV.getPageContext().getString(e.j.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int h;
        int h2;
        if (aVar != null) {
            this.gMd.startLoad(aVar.buV(), 17, false);
            this.gMe.setText(aVar.buU());
            if (aVar.buX() != null) {
                this.gMi.setData(aVar.buX());
                this.tvUserName.setText(aVar.buX().getName_show());
                if (aVar.buX().getGodUserData() != null && (!StringUtils.isNull(aVar.buX().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.buX().getGodUserData().getIntro()))) {
                    this.gMj.setText(aVar.buX().getGodUserData().getForumName() + "吧 " + aVar.buX().getGodIntro());
                    this.gMj.setVisibility(0);
                } else {
                    this.gMj.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.buX().getUserId())) {
                    this.gMk.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.gLV.getPageContext(), this.gMk).a(aVar.buX());
                    this.gMk.onChangeSkinType(0);
                    this.gMk.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b buW = aVar.buW();
                if (buW == null) {
                    this.gLV.buK().bJg();
                    this.gLV.finish();
                    return;
                }
                boolean z = buW.buY() == null || v.I(buW.buY().Sx());
                if (StringUtils.isNull(buW.getTitle()) && z) {
                    this.gLV.buK().bJg();
                    this.gLV.finish();
                    return;
                }
                if (buW.buY() != null) {
                    Iterator<TbRichTextData> it = buW.buY().Sx().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.gLZ = next.SH();
                        }
                        if (this.gLZ != null) {
                            break;
                        }
                    }
                }
                this.tid = buW.getTid();
                if (this.gLZ == null) {
                    this.gMh.setVisibility(8);
                    this.fkb.setVisibility(0);
                    boolean z2 = j.kY() || j.kW();
                    this.gMn.dc(z2);
                    if (z2) {
                        h = (l.aO(TbadkCoreApplication.getInst()) - (l.h(this.gLV, e.C0210e.tbds22) * 2)) - (l.h(this.gLV, e.C0210e.tbds44) * 2);
                        h2 = (int) (h * 1.618f);
                    } else {
                        h = l.h(this.gLV, e.C0210e.tbds360);
                        h2 = l.h(this.gLV, e.C0210e.tbds202);
                    }
                    this.gMn.dd(z2);
                    this.gMn.gL(h);
                    this.gMn.gM(h2);
                    this.fkb.setText(buW.buY());
                } else {
                    this.fkb.setVisibility(8);
                    this.gMh.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gMh.getLayoutParams();
                    layoutParams.width = l.aO(this.gLV) - l.h(this.gLV, e.C0210e.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.gMh.setLayoutParams(layoutParams);
                    this.gMh.setTbRichTextVideoInfo(this.gLZ);
                    this.gMh.stopPlay();
                    this.gMh.setIsNeedRecoveryVideoPlayer(true);
                    this.gMh.setThumbnail(this.gLZ.getThumbUrl());
                    this.gMh.setVideoUrl(this.gLZ.getVideoUrl(), String.valueOf(this.tid));
                    this.gMh.aNk();
                    n nVar = new n(this.gLV.getActivity());
                    nVar.un("2");
                    z zVar = new z();
                    zVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    zVar.bjm = String.valueOf(this.tid);
                    zVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    nVar.setVideoStatsData(zVar);
                    this.gMh.setQuickVideoViewBusiness(nVar);
                }
                if (StringUtils.isNull(buW.getTitle())) {
                    this.gMg.setVisibility(8);
                } else {
                    this.gMg.setText(buW.getTitle());
                    this.gMg.setVisibility(0);
                }
                this.gMm.setText(String.format(Locale.CHINA, this.gLV.getString(e.j.bottom_comment), Integer.valueOf(buW.getPostNum())));
                if (!this.gLV.buK().isScreenOn()) {
                    this.gLV.buK().bJh();
                    return;
                }
                return;
            }
            this.gLV.buK().bJg();
            this.gLV.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gMf) {
            TiebaStatic.log(new am("c13198").aB("tid", this.gLV.getTid()));
            com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.gLV != null && c.this.gLV.buK() != null) {
                        c.this.gLV.buK().bJg();
                    }
                }
            }, 100L);
            this.gLV.finish();
        } else if (view == this.gMl) {
            TiebaStatic.log(new am("c13199").y("obj_locate", 4).aB("tid", this.gLV.getTid()));
            if (this.tid == 0) {
                this.gLV.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.gLV).createNormalCfg(this.tid + "", null, null)));
            this.gLV.buK().bJh();
            this.gLV.finish();
        } else if (view == this.gMk) {
            TiebaStatic.log(new am("c13199").y("obj_locate", 3).aB("tid", this.gLV.getTid()));
        }
    }

    public void onPause() {
        if (this.gMh != null) {
            this.gMh.onPause();
        }
    }

    public void onDestroy() {
        if (this.gMh != null) {
            this.gMh.onDestroy();
        }
    }
}
