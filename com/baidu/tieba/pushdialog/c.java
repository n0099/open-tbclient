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
    private TbRichTextView eYl;
    private EditorScrollView fPe;
    private com.baidu.tbadk.widget.richText.a gAa;
    private boolean gAb = false;
    private final PushDialogActivity gzI;
    private f gzM;
    private Drawable gzO;
    private View gzP;
    private TbImageView gzQ;
    private TextView gzR;
    private ImageView gzS;
    private TextView gzT;
    private PushDialogVideoView gzU;
    private ClickableHeaderImageView gzV;
    private TextView gzW;
    private CommonUserLikeButton gzX;
    private View gzY;
    private TextView gzZ;
    private View mRootView;
    private long tid;
    private TextView tvUserName;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.gzI = pushDialogActivity;
        this.gzI.setContentView(i);
        this.mRootView = findViewById(e.g.root_view);
        this.gzP = findViewById(e.g.dialog_wrapper_view);
        this.fPe = (EditorScrollView) findViewById(e.g.push_dialog_content_layout);
        this.fPe.setOverScrollMode(2);
        this.fPe.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.gAb) {
                    TiebaStatic.log(new am("c13199").x("obj_locate", 1).ax("tid", c.this.gzI.getTid()));
                    c.this.gAb = true;
                }
            }
        });
        if (this.gzP.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gzP.getLayoutParams();
            int aQ = l.aQ(this.gzI);
            layoutParams.height = aQ / 2;
            layoutParams.topMargin = (int) (aQ * 0.22f);
            this.gzP.postInvalidate();
        }
        if (l.lq()) {
            this.gzO = com.baidu.tieba.t.a.bGh();
            if (this.gzO != null && this.gzI.getWindow() != null) {
                this.gzI.getWindow().setBackgroundDrawable(this.gzO);
            }
        }
        this.gzY = findViewById(e.g.push_dialog_bottom_layout);
        this.gzY.setOnClickListener(this);
        this.gzZ = (TextView) findViewById(e.g.comment_num);
        this.gzQ = (TbImageView) findViewById(e.g.push_dialog_title_img);
        this.gzQ.setDefaultBgResource(e.f.icon);
        this.gzQ.setAutoChangeStyle(false);
        this.gzR = (TextView) findViewById(e.g.push_dialog_title_text);
        this.gzT = (TextView) findViewById(e.g.push_dialog_content_title);
        this.gzV = (ClickableHeaderImageView) findViewById(e.g.push_dialog_user_head);
        this.gzV.setBorderSurroundContent(true);
        this.gzV.setIsRound(true);
        this.gzV.setEnabled(false);
        this.gzV.setAutoChangeStyle(false);
        this.gzV.setBorderWidth(l.h(this.gzI, e.C0175e.tbds1));
        this.gzV.setBorderColor(ContextCompat.getColor(this.gzI, e.d.black_alpha15));
        this.gAa = new com.baidu.tbadk.widget.richText.a();
        this.eYl = (TbRichTextView) findViewById(e.g.push_dialog_content);
        this.eYl.setTextColor(ContextCompat.getColor(this.gzI, e.d.cp_cont_j));
        this.gAa.gm(l.h(this.gzI, e.C0175e.tbds38));
        this.gAa.setTextSize(l.h(this.gzI, e.C0175e.tbds42));
        this.gAa.gq(l.h(this.gzI, e.C0175e.tbds23));
        this.gAa.setLineSpacing(l.h(TbadkCoreApplication.getInst().getContext(), e.C0175e.tbds7), 1.0f);
        this.gAa.R(l.h(TbadkCoreApplication.getInst().getContext(), e.C0175e.tbds48), l.h(TbadkCoreApplication.getInst().getContext(), e.C0175e.tbds48));
        this.eYl.setLayoutStrategy(this.gAa);
        this.gzU = (PushDialogVideoView) findViewById(e.g.push_dialog_video);
        this.gzU.setPageContext(this.gzI.getPageContext());
        this.tvUserName = (TextView) findViewById(e.g.push_dialog_user_name);
        this.gzW = (TextView) findViewById(e.g.push_dialog_user_god_info);
        this.gzX = (CommonUserLikeButton) findViewById(e.g.push_dialog_user_like_btn);
        this.gzX.setAfterOnClickListener(this);
        this.gzS = (ImageView) findViewById(e.g.dialog_close_btn);
        this.gzS.setOnClickListener(this);
    }

    public void onResume() {
        if (this.gzU != null) {
            this.gzU.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.gzI.findViewById(i);
    }

    public void bsk() {
        if (this.gzU != null) {
            this.gzU.setNetworkChange();
            if (j.kZ() && this.gzU.bpH() && this.gzM != null && this.gzM.getFileSize() > 0 && this.gzM.getDuration() > 0) {
                float fileSize = this.gzM.getFileSize() * (1.0f - ((this.gzU.getCurrentPosition() * 1.0f) / (this.gzM.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.gzI.getPageContext().getPageActivity(), String.format(this.gzI.getPageContext().getString(e.j.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int h;
        int h2;
        if (aVar != null) {
            this.gzQ.startLoad(aVar.bsm(), 17, false);
            this.gzR.setText(aVar.bsl());
            if (aVar.bso() != null) {
                this.gzV.setData(aVar.bso());
                this.tvUserName.setText(aVar.bso().getName_show());
                if (aVar.bso().getGodUserData() != null && (!StringUtils.isNull(aVar.bso().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.bso().getGodUserData().getIntro()))) {
                    this.gzW.setText(aVar.bso().getGodUserData().getForumName() + "吧 " + aVar.bso().getGodIntro());
                    this.gzW.setVisibility(0);
                } else {
                    this.gzW.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.bso().getUserId())) {
                    this.gzX.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.gzI.getPageContext(), this.gzX).a(aVar.bso());
                    this.gzX.onChangeSkinType(0);
                    this.gzX.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b bsn = aVar.bsn();
                if (bsn == null) {
                    this.gzI.bsb().bGe();
                    this.gzI.finish();
                    return;
                }
                boolean z = bsn.bsp() == null || v.J(bsn.bsp().QK());
                if (StringUtils.isNull(bsn.getTitle()) && z) {
                    this.gzI.bsb().bGe();
                    this.gzI.finish();
                    return;
                }
                if (bsn.bsp() != null) {
                    Iterator<TbRichTextData> it = bsn.bsp().QK().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.gzM = next.QU();
                        }
                        if (this.gzM != null) {
                            break;
                        }
                    }
                }
                this.tid = bsn.getTid();
                if (this.gzM == null) {
                    this.gzU.setVisibility(8);
                    this.eYl.setVisibility(0);
                    boolean z2 = j.la() || j.kY();
                    this.gAa.cH(z2);
                    if (z2) {
                        h = (l.aO(TbadkCoreApplication.getInst()) - (l.h(this.gzI, e.C0175e.tbds22) * 2)) - (l.h(this.gzI, e.C0175e.tbds44) * 2);
                        h2 = (int) (h * 1.618f);
                    } else {
                        h = l.h(this.gzI, e.C0175e.tbds360);
                        h2 = l.h(this.gzI, e.C0175e.tbds202);
                    }
                    this.gAa.cI(z2);
                    this.gAa.gi(h);
                    this.gAa.gj(h2);
                    this.eYl.setText(bsn.bsp());
                } else {
                    this.eYl.setVisibility(8);
                    this.gzU.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gzU.getLayoutParams();
                    layoutParams.width = l.aO(this.gzI) - l.h(this.gzI, e.C0175e.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.gzU.setLayoutParams(layoutParams);
                    this.gzU.setTbRichTextVideoInfo(this.gzM);
                    this.gzU.stopPlay();
                    this.gzU.setIsNeedRecoveryVideoPlayer(true);
                    this.gzU.setThumbnail(this.gzM.getThumbUrl());
                    this.gzU.setVideoUrl(this.gzM.getVideoUrl(), String.valueOf(this.tid));
                    this.gzU.aKH();
                    n nVar = new n(this.gzI.getActivity());
                    nVar.tn("2");
                    z zVar = new z();
                    zVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    zVar.beh = String.valueOf(this.tid);
                    zVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    nVar.setVideoStatsData(zVar);
                    this.gzU.setQuickVideoViewBusiness(nVar);
                }
                if (StringUtils.isNull(bsn.getTitle())) {
                    this.gzT.setVisibility(8);
                } else {
                    this.gzT.setText(bsn.getTitle());
                    this.gzT.setVisibility(0);
                }
                this.gzZ.setText(String.format(Locale.CHINA, this.gzI.getString(e.j.bottom_comment), Integer.valueOf(bsn.getPostNum())));
                if (!this.gzI.bsb().isScreenOn()) {
                    this.gzI.bsb().bGf();
                    return;
                }
                return;
            }
            this.gzI.bsb().bGe();
            this.gzI.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gzS) {
            TiebaStatic.log(new am("c13198").ax("tid", this.gzI.getTid()));
            com.baidu.adp.lib.g.e.jI().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.gzI != null && c.this.gzI.bsb() != null) {
                        c.this.gzI.bsb().bGe();
                    }
                }
            }, 100L);
            this.gzI.finish();
        } else if (view == this.gzY) {
            TiebaStatic.log(new am("c13199").x("obj_locate", 4).ax("tid", this.gzI.getTid()));
            if (this.tid == 0) {
                this.gzI.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.gzI).createNormalCfg(this.tid + "", null, null)));
            this.gzI.bsb().bGf();
            this.gzI.finish();
        } else if (view == this.gzX) {
            TiebaStatic.log(new am("c13199").x("obj_locate", 3).ax("tid", this.gzI.getTid()));
        }
    }

    public void onPause() {
        if (this.gzU != null) {
            this.gzU.onPause();
        }
    }

    public void onDestroy() {
        if (this.gzU != null) {
            this.gzU.onDestroy();
        }
    }
}
