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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tieba.f;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.y;
import com.tencent.connect.common.Constants;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Locale;
/* loaded from: classes3.dex */
public class c implements View.OnClickListener {
    private TbRichTextView eJo;
    private EditorScrollView fzU;
    private final PushDialogActivity gkQ;
    private f gkU;
    private Drawable gkW;
    private View gkX;
    private TbImageView gkY;
    private TextView gkZ;
    private ImageView gla;
    private TextView glb;
    private PushDialogVideoView glc;
    private ClickableHeaderImageView gld;
    private TextView gle;
    private CommonUserLikeButton glf;
    private View glg;
    private TextView glh;
    private com.baidu.tbadk.widget.richText.a gli;
    private boolean glj = false;
    private View mRootView;
    private long tid;
    private TextView tvUserName;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.gkQ = pushDialogActivity;
        this.gkQ.setContentView(i);
        this.mRootView = findViewById(f.g.root_view);
        this.gkX = findViewById(f.g.dialog_wrapper_view);
        this.fzU = (EditorScrollView) findViewById(f.g.push_dialog_content_layout);
        this.fzU.setOverScrollMode(2);
        this.fzU.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.glj) {
                    TiebaStatic.log(new an("c13199").r("obj_locate", 1).ae("tid", c.this.gkQ.getTid()));
                    c.this.glj = true;
                }
            }
        });
        if (this.gkX.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gkX.getLayoutParams();
            int aj = l.aj(this.gkQ);
            layoutParams.height = aj / 2;
            layoutParams.topMargin = (int) (aj * 0.22f);
            this.gkX.postInvalidate();
        }
        if (l.jY()) {
            this.gkW = com.baidu.tieba.t.a.bAe();
            if (this.gkW != null && this.gkQ.getWindow() != null) {
                this.gkQ.getWindow().setBackgroundDrawable(this.gkW);
            }
        }
        this.glg = findViewById(f.g.push_dialog_bottom_layout);
        this.glg.setOnClickListener(this);
        this.glh = (TextView) findViewById(f.g.comment_num);
        this.gkY = (TbImageView) findViewById(f.g.push_dialog_title_img);
        this.gkY.setDefaultBgResource(f.C0146f.icon);
        this.gkY.setAutoChangeStyle(false);
        this.gkZ = (TextView) findViewById(f.g.push_dialog_title_text);
        this.glb = (TextView) findViewById(f.g.push_dialog_content_title);
        this.gld = (ClickableHeaderImageView) findViewById(f.g.push_dialog_user_head);
        this.gld.setBorderSurroundContent(true);
        this.gld.setIsRound(true);
        this.gld.setEnabled(false);
        this.gld.setAutoChangeStyle(false);
        this.gld.setBorderWidth(l.f(this.gkQ, f.e.tbds1));
        this.gld.setBorderColor(ContextCompat.getColor(this.gkQ, f.d.black_alpha15));
        this.gli = new com.baidu.tbadk.widget.richText.a();
        this.eJo = (TbRichTextView) findViewById(f.g.push_dialog_content);
        this.eJo.setTextColor(ContextCompat.getColor(this.gkQ, f.d.cp_cont_j));
        this.gli.fS(l.f(this.gkQ, f.e.tbds38));
        this.gli.setTextSize(l.f(this.gkQ, f.e.tbds42));
        this.gli.fW(l.f(this.gkQ, f.e.tbds23));
        this.gli.setLineSpacing(l.f(TbadkCoreApplication.getInst().getContext(), f.e.tbds7), 1.0f);
        this.gli.P(l.f(TbadkCoreApplication.getInst().getContext(), f.e.tbds48), l.f(TbadkCoreApplication.getInst().getContext(), f.e.tbds48));
        this.eJo.setLayoutStrategy(this.gli);
        this.glc = (PushDialogVideoView) findViewById(f.g.push_dialog_video);
        this.glc.setPageContext(this.gkQ.getPageContext());
        this.tvUserName = (TextView) findViewById(f.g.push_dialog_user_name);
        this.gle = (TextView) findViewById(f.g.push_dialog_user_god_info);
        this.glf = (CommonUserLikeButton) findViewById(f.g.push_dialog_user_like_btn);
        this.glf.setAfterOnClickListener(this);
        this.gla = (ImageView) findViewById(f.g.dialog_close_btn);
        this.gla.setOnClickListener(this);
    }

    public void onResume() {
        if (this.glc != null) {
            this.glc.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.gkQ.findViewById(i);
    }

    public void bmo() {
        if (this.glc != null) {
            this.glc.setNetworkChange();
            if (j.jG() && this.glc.bjR() && this.gkU != null && this.gkU.getFileSize() > 0 && this.gkU.getDuration() > 0) {
                float fileSize = this.gkU.getFileSize() * (1.0f - ((this.glc.getCurrentPosition() * 1.0f) / (this.gkU.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.gkQ.getPageContext().getPageActivity(), String.format(this.gkQ.getPageContext().getString(f.j.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int f;
        int f2;
        if (aVar != null) {
            this.gkY.startLoad(aVar.bmq(), 17, false);
            this.gkZ.setText(aVar.bmp());
            if (aVar.bms() != null) {
                this.gld.setData(aVar.bms());
                this.tvUserName.setText(aVar.bms().getName_show());
                if (aVar.bms().getGodUserData() != null && (!StringUtils.isNull(aVar.bms().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.bms().getGodUserData().getIntro()))) {
                    this.gle.setText(aVar.bms().getGodUserData().getForumName() + "吧 " + aVar.bms().getGodIntro());
                    this.gle.setVisibility(0);
                } else {
                    this.gle.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.bms().getUserId())) {
                    this.glf.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.gkQ.getPageContext(), this.glf).a(aVar.bms());
                    this.glf.onChangeSkinType(0);
                    this.glf.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b bmr = aVar.bmr();
                if (bmr == null) {
                    this.gkQ.bmg().bAb();
                    this.gkQ.finish();
                    return;
                }
                boolean z = bmr.bmt() == null || w.z(bmr.bmt().Nw());
                if (StringUtils.isNull(bmr.getTitle()) && z) {
                    this.gkQ.bmg().bAb();
                    this.gkQ.finish();
                    return;
                }
                if (bmr.bmt() != null) {
                    Iterator<TbRichTextData> it = bmr.bmt().Nw().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.gkU = next.NG();
                        }
                        if (this.gkU != null) {
                            break;
                        }
                    }
                }
                this.tid = bmr.getTid();
                if (this.gkU == null) {
                    this.glc.setVisibility(8);
                    this.eJo.setVisibility(0);
                    boolean z2 = j.jH() || j.jF();
                    this.gli.cm(z2);
                    if (z2) {
                        f = (l.ah(TbadkCoreApplication.getInst()) - (l.f(this.gkQ, f.e.tbds22) * 2)) - (l.f(this.gkQ, f.e.tbds44) * 2);
                        f2 = (int) (f * 1.618f);
                    } else {
                        f = l.f(this.gkQ, f.e.tbds360);
                        f2 = l.f(this.gkQ, f.e.tbds202);
                    }
                    this.gli.cn(z2);
                    this.gli.fO(f);
                    this.gli.fP(f2);
                    this.eJo.setText(bmr.bmt());
                } else {
                    this.eJo.setVisibility(8);
                    this.glc.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.glc.getLayoutParams();
                    layoutParams.width = l.ah(this.gkQ) - l.f(this.gkQ, f.e.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.glc.setLayoutParams(layoutParams);
                    this.glc.setTbRichTextVideoInfo(this.gkU);
                    this.glc.stopPlay();
                    this.glc.setIsNeedRecoveryVideoPlayer(true);
                    this.glc.setThumbnail(this.gkU.getThumbUrl());
                    this.glc.setVideoUrl(this.gkU.getVideoUrl(), String.valueOf(this.tid));
                    this.glc.aFa();
                    n nVar = new n(this.gkQ.getActivity());
                    nVar.sf("2");
                    y yVar = new y();
                    yVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    yVar.aWq = String.valueOf(this.tid);
                    yVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    nVar.setVideoStatsData(yVar);
                    this.glc.setQuickVideoViewBusiness(nVar);
                }
                if (StringUtils.isNull(bmr.getTitle())) {
                    this.glb.setVisibility(8);
                } else {
                    this.glb.setText(bmr.getTitle());
                    this.glb.setVisibility(0);
                }
                this.glh.setText(String.format(Locale.CHINA, this.gkQ.getString(f.j.bottom_comment), Integer.valueOf(bmr.getPostNum())));
                if (!this.gkQ.bmg().isScreenOn()) {
                    this.gkQ.bmg().bAc();
                    return;
                }
                return;
            }
            this.gkQ.bmg().bAb();
            this.gkQ.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gla) {
            TiebaStatic.log(new an("c13198").ae("tid", this.gkQ.getTid()));
            e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.gkQ != null && c.this.gkQ.bmg() != null) {
                        c.this.gkQ.bmg().bAb();
                    }
                }
            }, 100L);
            this.gkQ.finish();
        } else if (view == this.glg) {
            TiebaStatic.log(new an("c13199").r("obj_locate", 4).ae("tid", this.gkQ.getTid()));
            if (this.tid == 0) {
                this.gkQ.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.gkQ).createNormalCfg(this.tid + "", null, null)));
            this.gkQ.bmg().bAc();
            this.gkQ.finish();
        } else if (view == this.glf) {
            TiebaStatic.log(new an("c13199").r("obj_locate", 3).ae("tid", this.gkQ.getTid()));
        }
    }

    public void onPause() {
        if (this.glc != null) {
            this.glc.onPause();
        }
    }

    public void onDestroy() {
        if (this.glc != null) {
            this.glc.onDestroy();
        }
    }
}
