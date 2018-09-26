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
import com.baidu.tieba.play.y;
import com.tencent.connect.common.Constants;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Locale;
/* loaded from: classes3.dex */
public class c implements View.OnClickListener {
    private TbRichTextView eQE;
    private EditorScrollView fHD;
    private com.baidu.tbadk.widget.richText.a gsA;
    private boolean gsB = false;
    private final PushDialogActivity gsi;
    private f gsm;
    private Drawable gso;
    private View gsp;
    private TbImageView gsq;
    private TextView gsr;
    private ImageView gss;
    private TextView gst;
    private PushDialogVideoView gsu;
    private ClickableHeaderImageView gsv;
    private TextView gsw;
    private CommonUserLikeButton gsx;
    private View gsy;
    private TextView gsz;
    private View mRootView;
    private long tid;
    private TextView tvUserName;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.gsi = pushDialogActivity;
        this.gsi.setContentView(i);
        this.mRootView = findViewById(e.g.root_view);
        this.gsp = findViewById(e.g.dialog_wrapper_view);
        this.fHD = (EditorScrollView) findViewById(e.g.push_dialog_content_layout);
        this.fHD.setOverScrollMode(2);
        this.fHD.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.gsB) {
                    TiebaStatic.log(new am("c13199").w("obj_locate", 1).al("tid", c.this.gsi.getTid()));
                    c.this.gsB = true;
                }
            }
        });
        if (this.gsp.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gsp.getLayoutParams();
            int aQ = l.aQ(this.gsi);
            layoutParams.height = aQ / 2;
            layoutParams.topMargin = (int) (aQ * 0.22f);
            this.gsp.postInvalidate();
        }
        if (l.le()) {
            this.gso = com.baidu.tieba.t.a.bCT();
            if (this.gso != null && this.gsi.getWindow() != null) {
                this.gsi.getWindow().setBackgroundDrawable(this.gso);
            }
        }
        this.gsy = findViewById(e.g.push_dialog_bottom_layout);
        this.gsy.setOnClickListener(this);
        this.gsz = (TextView) findViewById(e.g.comment_num);
        this.gsq = (TbImageView) findViewById(e.g.push_dialog_title_img);
        this.gsq.setDefaultBgResource(e.f.icon);
        this.gsq.setAutoChangeStyle(false);
        this.gsr = (TextView) findViewById(e.g.push_dialog_title_text);
        this.gst = (TextView) findViewById(e.g.push_dialog_content_title);
        this.gsv = (ClickableHeaderImageView) findViewById(e.g.push_dialog_user_head);
        this.gsv.setBorderSurroundContent(true);
        this.gsv.setIsRound(true);
        this.gsv.setEnabled(false);
        this.gsv.setAutoChangeStyle(false);
        this.gsv.setBorderWidth(l.h(this.gsi, e.C0141e.tbds1));
        this.gsv.setBorderColor(ContextCompat.getColor(this.gsi, e.d.black_alpha15));
        this.gsA = new com.baidu.tbadk.widget.richText.a();
        this.eQE = (TbRichTextView) findViewById(e.g.push_dialog_content);
        this.eQE.setTextColor(ContextCompat.getColor(this.gsi, e.d.cp_cont_j));
        this.gsA.ge(l.h(this.gsi, e.C0141e.tbds38));
        this.gsA.setTextSize(l.h(this.gsi, e.C0141e.tbds42));
        this.gsA.gi(l.h(this.gsi, e.C0141e.tbds23));
        this.gsA.setLineSpacing(l.h(TbadkCoreApplication.getInst().getContext(), e.C0141e.tbds7), 1.0f);
        this.gsA.R(l.h(TbadkCoreApplication.getInst().getContext(), e.C0141e.tbds48), l.h(TbadkCoreApplication.getInst().getContext(), e.C0141e.tbds48));
        this.eQE.setLayoutStrategy(this.gsA);
        this.gsu = (PushDialogVideoView) findViewById(e.g.push_dialog_video);
        this.gsu.setPageContext(this.gsi.getPageContext());
        this.tvUserName = (TextView) findViewById(e.g.push_dialog_user_name);
        this.gsw = (TextView) findViewById(e.g.push_dialog_user_god_info);
        this.gsx = (CommonUserLikeButton) findViewById(e.g.push_dialog_user_like_btn);
        this.gsx.setAfterOnClickListener(this);
        this.gss = (ImageView) findViewById(e.g.dialog_close_btn);
        this.gss.setOnClickListener(this);
    }

    public void onResume() {
        if (this.gsu != null) {
            this.gsu.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.gsi.findViewById(i);
    }

    public void boV() {
        if (this.gsu != null) {
            this.gsu.setNetworkChange();
            if (j.kM() && this.gsu.bmu() && this.gsm != null && this.gsm.getFileSize() > 0 && this.gsm.getDuration() > 0) {
                float fileSize = this.gsm.getFileSize() * (1.0f - ((this.gsu.getCurrentPosition() * 1.0f) / (this.gsm.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.gsi.getPageContext().getPageActivity(), String.format(this.gsi.getPageContext().getString(e.j.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int h;
        int h2;
        if (aVar != null) {
            this.gsq.startLoad(aVar.boX(), 17, false);
            this.gsr.setText(aVar.boW());
            if (aVar.boZ() != null) {
                this.gsv.setData(aVar.boZ());
                this.tvUserName.setText(aVar.boZ().getName_show());
                if (aVar.boZ().getGodUserData() != null && (!StringUtils.isNull(aVar.boZ().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.boZ().getGodUserData().getIntro()))) {
                    this.gsw.setText(aVar.boZ().getGodUserData().getForumName() + "吧 " + aVar.boZ().getGodIntro());
                    this.gsw.setVisibility(0);
                } else {
                    this.gsw.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.boZ().getUserId())) {
                    this.gsx.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.gsi.getPageContext(), this.gsx).a(aVar.boZ());
                    this.gsx.onChangeSkinType(0);
                    this.gsx.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b boY = aVar.boY();
                if (boY == null) {
                    this.gsi.boM().bCQ();
                    this.gsi.finish();
                    return;
                }
                boolean z = boY.bpa() == null || v.z(boY.bpa().OP());
                if (StringUtils.isNull(boY.getTitle()) && z) {
                    this.gsi.boM().bCQ();
                    this.gsi.finish();
                    return;
                }
                if (boY.bpa() != null) {
                    Iterator<TbRichTextData> it = boY.bpa().OP().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.gsm = next.OZ();
                        }
                        if (this.gsm != null) {
                            break;
                        }
                    }
                }
                this.tid = boY.getTid();
                if (this.gsm == null) {
                    this.gsu.setVisibility(8);
                    this.eQE.setVisibility(0);
                    boolean z2 = j.kN() || j.kL();
                    this.gsA.cy(z2);
                    if (z2) {
                        h = (l.aO(TbadkCoreApplication.getInst()) - (l.h(this.gsi, e.C0141e.tbds22) * 2)) - (l.h(this.gsi, e.C0141e.tbds44) * 2);
                        h2 = (int) (h * 1.618f);
                    } else {
                        h = l.h(this.gsi, e.C0141e.tbds360);
                        h2 = l.h(this.gsi, e.C0141e.tbds202);
                    }
                    this.gsA.cz(z2);
                    this.gsA.ga(h);
                    this.gsA.gb(h2);
                    this.eQE.setText(boY.bpa());
                } else {
                    this.eQE.setVisibility(8);
                    this.gsu.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gsu.getLayoutParams();
                    layoutParams.width = l.aO(this.gsi) - l.h(this.gsi, e.C0141e.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.gsu.setLayoutParams(layoutParams);
                    this.gsu.setTbRichTextVideoInfo(this.gsm);
                    this.gsu.stopPlay();
                    this.gsu.setIsNeedRecoveryVideoPlayer(true);
                    this.gsu.setThumbnail(this.gsm.getThumbUrl());
                    this.gsu.setVideoUrl(this.gsm.getVideoUrl(), String.valueOf(this.tid));
                    this.gsu.aHp();
                    n nVar = new n(this.gsi.getActivity());
                    nVar.sN("2");
                    y yVar = new y();
                    yVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    yVar.aZG = String.valueOf(this.tid);
                    yVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    nVar.setVideoStatsData(yVar);
                    this.gsu.setQuickVideoViewBusiness(nVar);
                }
                if (StringUtils.isNull(boY.getTitle())) {
                    this.gst.setVisibility(8);
                } else {
                    this.gst.setText(boY.getTitle());
                    this.gst.setVisibility(0);
                }
                this.gsz.setText(String.format(Locale.CHINA, this.gsi.getString(e.j.bottom_comment), Integer.valueOf(boY.getPostNum())));
                if (!this.gsi.boM().isScreenOn()) {
                    this.gsi.boM().bCR();
                    return;
                }
                return;
            }
            this.gsi.boM().bCQ();
            this.gsi.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gss) {
            TiebaStatic.log(new am("c13198").al("tid", this.gsi.getTid()));
            com.baidu.adp.lib.g.e.jt().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.gsi != null && c.this.gsi.boM() != null) {
                        c.this.gsi.boM().bCQ();
                    }
                }
            }, 100L);
            this.gsi.finish();
        } else if (view == this.gsy) {
            TiebaStatic.log(new am("c13199").w("obj_locate", 4).al("tid", this.gsi.getTid()));
            if (this.tid == 0) {
                this.gsi.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.gsi).createNormalCfg(this.tid + "", null, null)));
            this.gsi.boM().bCR();
            this.gsi.finish();
        } else if (view == this.gsx) {
            TiebaStatic.log(new am("c13199").w("obj_locate", 3).al("tid", this.gsi.getTid()));
        }
    }

    public void onPause() {
        if (this.gsu != null) {
            this.gsu.onPause();
        }
    }

    public void onDestroy() {
        if (this.gsu != null) {
            this.gsu.onDestroy();
        }
    }
}
