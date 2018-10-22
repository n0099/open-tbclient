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
    private TbRichTextView eYm;
    private EditorScrollView fPf;
    private TextView gAa;
    private com.baidu.tbadk.widget.richText.a gAb;
    private boolean gAc = false;
    private final PushDialogActivity gzJ;
    private f gzN;
    private Drawable gzP;
    private View gzQ;
    private TbImageView gzR;
    private TextView gzS;
    private ImageView gzT;
    private TextView gzU;
    private PushDialogVideoView gzV;
    private ClickableHeaderImageView gzW;
    private TextView gzX;
    private CommonUserLikeButton gzY;
    private View gzZ;
    private View mRootView;
    private long tid;
    private TextView tvUserName;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.gzJ = pushDialogActivity;
        this.gzJ.setContentView(i);
        this.mRootView = findViewById(e.g.root_view);
        this.gzQ = findViewById(e.g.dialog_wrapper_view);
        this.fPf = (EditorScrollView) findViewById(e.g.push_dialog_content_layout);
        this.fPf.setOverScrollMode(2);
        this.fPf.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.gAc) {
                    TiebaStatic.log(new am("c13199").x("obj_locate", 1).ax("tid", c.this.gzJ.getTid()));
                    c.this.gAc = true;
                }
            }
        });
        if (this.gzQ.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gzQ.getLayoutParams();
            int aQ = l.aQ(this.gzJ);
            layoutParams.height = aQ / 2;
            layoutParams.topMargin = (int) (aQ * 0.22f);
            this.gzQ.postInvalidate();
        }
        if (l.lq()) {
            this.gzP = com.baidu.tieba.t.a.bGh();
            if (this.gzP != null && this.gzJ.getWindow() != null) {
                this.gzJ.getWindow().setBackgroundDrawable(this.gzP);
            }
        }
        this.gzZ = findViewById(e.g.push_dialog_bottom_layout);
        this.gzZ.setOnClickListener(this);
        this.gAa = (TextView) findViewById(e.g.comment_num);
        this.gzR = (TbImageView) findViewById(e.g.push_dialog_title_img);
        this.gzR.setDefaultBgResource(e.f.icon);
        this.gzR.setAutoChangeStyle(false);
        this.gzS = (TextView) findViewById(e.g.push_dialog_title_text);
        this.gzU = (TextView) findViewById(e.g.push_dialog_content_title);
        this.gzW = (ClickableHeaderImageView) findViewById(e.g.push_dialog_user_head);
        this.gzW.setBorderSurroundContent(true);
        this.gzW.setIsRound(true);
        this.gzW.setEnabled(false);
        this.gzW.setAutoChangeStyle(false);
        this.gzW.setBorderWidth(l.h(this.gzJ, e.C0175e.tbds1));
        this.gzW.setBorderColor(ContextCompat.getColor(this.gzJ, e.d.black_alpha15));
        this.gAb = new com.baidu.tbadk.widget.richText.a();
        this.eYm = (TbRichTextView) findViewById(e.g.push_dialog_content);
        this.eYm.setTextColor(ContextCompat.getColor(this.gzJ, e.d.cp_cont_j));
        this.gAb.gm(l.h(this.gzJ, e.C0175e.tbds38));
        this.gAb.setTextSize(l.h(this.gzJ, e.C0175e.tbds42));
        this.gAb.gq(l.h(this.gzJ, e.C0175e.tbds23));
        this.gAb.setLineSpacing(l.h(TbadkCoreApplication.getInst().getContext(), e.C0175e.tbds7), 1.0f);
        this.gAb.R(l.h(TbadkCoreApplication.getInst().getContext(), e.C0175e.tbds48), l.h(TbadkCoreApplication.getInst().getContext(), e.C0175e.tbds48));
        this.eYm.setLayoutStrategy(this.gAb);
        this.gzV = (PushDialogVideoView) findViewById(e.g.push_dialog_video);
        this.gzV.setPageContext(this.gzJ.getPageContext());
        this.tvUserName = (TextView) findViewById(e.g.push_dialog_user_name);
        this.gzX = (TextView) findViewById(e.g.push_dialog_user_god_info);
        this.gzY = (CommonUserLikeButton) findViewById(e.g.push_dialog_user_like_btn);
        this.gzY.setAfterOnClickListener(this);
        this.gzT = (ImageView) findViewById(e.g.dialog_close_btn);
        this.gzT.setOnClickListener(this);
    }

    public void onResume() {
        if (this.gzV != null) {
            this.gzV.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.gzJ.findViewById(i);
    }

    public void bsk() {
        if (this.gzV != null) {
            this.gzV.setNetworkChange();
            if (j.kZ() && this.gzV.bpH() && this.gzN != null && this.gzN.getFileSize() > 0 && this.gzN.getDuration() > 0) {
                float fileSize = this.gzN.getFileSize() * (1.0f - ((this.gzV.getCurrentPosition() * 1.0f) / (this.gzN.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.gzJ.getPageContext().getPageActivity(), String.format(this.gzJ.getPageContext().getString(e.j.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int h;
        int h2;
        if (aVar != null) {
            this.gzR.startLoad(aVar.bsm(), 17, false);
            this.gzS.setText(aVar.bsl());
            if (aVar.bso() != null) {
                this.gzW.setData(aVar.bso());
                this.tvUserName.setText(aVar.bso().getName_show());
                if (aVar.bso().getGodUserData() != null && (!StringUtils.isNull(aVar.bso().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.bso().getGodUserData().getIntro()))) {
                    this.gzX.setText(aVar.bso().getGodUserData().getForumName() + "吧 " + aVar.bso().getGodIntro());
                    this.gzX.setVisibility(0);
                } else {
                    this.gzX.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.bso().getUserId())) {
                    this.gzY.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.gzJ.getPageContext(), this.gzY).a(aVar.bso());
                    this.gzY.onChangeSkinType(0);
                    this.gzY.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b bsn = aVar.bsn();
                if (bsn == null) {
                    this.gzJ.bsb().bGe();
                    this.gzJ.finish();
                    return;
                }
                boolean z = bsn.bsp() == null || v.J(bsn.bsp().QK());
                if (StringUtils.isNull(bsn.getTitle()) && z) {
                    this.gzJ.bsb().bGe();
                    this.gzJ.finish();
                    return;
                }
                if (bsn.bsp() != null) {
                    Iterator<TbRichTextData> it = bsn.bsp().QK().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.gzN = next.QU();
                        }
                        if (this.gzN != null) {
                            break;
                        }
                    }
                }
                this.tid = bsn.getTid();
                if (this.gzN == null) {
                    this.gzV.setVisibility(8);
                    this.eYm.setVisibility(0);
                    boolean z2 = j.la() || j.kY();
                    this.gAb.cH(z2);
                    if (z2) {
                        h = (l.aO(TbadkCoreApplication.getInst()) - (l.h(this.gzJ, e.C0175e.tbds22) * 2)) - (l.h(this.gzJ, e.C0175e.tbds44) * 2);
                        h2 = (int) (h * 1.618f);
                    } else {
                        h = l.h(this.gzJ, e.C0175e.tbds360);
                        h2 = l.h(this.gzJ, e.C0175e.tbds202);
                    }
                    this.gAb.cI(z2);
                    this.gAb.gi(h);
                    this.gAb.gj(h2);
                    this.eYm.setText(bsn.bsp());
                } else {
                    this.eYm.setVisibility(8);
                    this.gzV.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gzV.getLayoutParams();
                    layoutParams.width = l.aO(this.gzJ) - l.h(this.gzJ, e.C0175e.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.gzV.setLayoutParams(layoutParams);
                    this.gzV.setTbRichTextVideoInfo(this.gzN);
                    this.gzV.stopPlay();
                    this.gzV.setIsNeedRecoveryVideoPlayer(true);
                    this.gzV.setThumbnail(this.gzN.getThumbUrl());
                    this.gzV.setVideoUrl(this.gzN.getVideoUrl(), String.valueOf(this.tid));
                    this.gzV.aKH();
                    n nVar = new n(this.gzJ.getActivity());
                    nVar.tn("2");
                    z zVar = new z();
                    zVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    zVar.beh = String.valueOf(this.tid);
                    zVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    nVar.setVideoStatsData(zVar);
                    this.gzV.setQuickVideoViewBusiness(nVar);
                }
                if (StringUtils.isNull(bsn.getTitle())) {
                    this.gzU.setVisibility(8);
                } else {
                    this.gzU.setText(bsn.getTitle());
                    this.gzU.setVisibility(0);
                }
                this.gAa.setText(String.format(Locale.CHINA, this.gzJ.getString(e.j.bottom_comment), Integer.valueOf(bsn.getPostNum())));
                if (!this.gzJ.bsb().isScreenOn()) {
                    this.gzJ.bsb().bGf();
                    return;
                }
                return;
            }
            this.gzJ.bsb().bGe();
            this.gzJ.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gzT) {
            TiebaStatic.log(new am("c13198").ax("tid", this.gzJ.getTid()));
            com.baidu.adp.lib.g.e.jI().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.gzJ != null && c.this.gzJ.bsb() != null) {
                        c.this.gzJ.bsb().bGe();
                    }
                }
            }, 100L);
            this.gzJ.finish();
        } else if (view == this.gzZ) {
            TiebaStatic.log(new am("c13199").x("obj_locate", 4).ax("tid", this.gzJ.getTid()));
            if (this.tid == 0) {
                this.gzJ.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.gzJ).createNormalCfg(this.tid + "", null, null)));
            this.gzJ.bsb().bGf();
            this.gzJ.finish();
        } else if (view == this.gzY) {
            TiebaStatic.log(new am("c13199").x("obj_locate", 3).ax("tid", this.gzJ.getTid()));
        }
    }

    public void onPause() {
        if (this.gzV != null) {
            this.gzV.onPause();
        }
    }

    public void onDestroy() {
        if (this.gzV != null) {
            this.gzV.onDestroy();
        }
    }
}
