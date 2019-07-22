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
    private EditorScrollView cmm;
    private TbRichTextView gXn;
    private final PushDialogActivity iCf;
    private f iCj;
    private Drawable iCl;
    private View iCm;
    private TbImageView iCn;
    private TextView iCo;
    private ImageView iCp;
    private TextView iCq;
    private PushDialogVideoView iCr;
    private ClickableHeaderImageView iCs;
    private TextView iCt;
    private CommonUserLikeButton iCu;
    private View iCv;
    private TextView iCw;
    private com.baidu.tbadk.widget.richText.a iCx;
    private boolean iCy = false;
    private View mRootView;
    private long tid;
    private TextView tvUserName;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.iCf = pushDialogActivity;
        this.iCf.setContentView(i);
        this.mRootView = findViewById(R.id.root_view);
        this.iCm = findViewById(R.id.dialog_wrapper_view);
        this.cmm = (EditorScrollView) findViewById(R.id.push_dialog_content_layout);
        this.cmm.setOverScrollMode(2);
        this.cmm.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.iCy) {
                    TiebaStatic.log(new an("c13199").P("obj_locate", 1).bT("tid", c.this.iCf.getTid()));
                    c.this.iCy = true;
                }
            }
        });
        if (this.iCm.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iCm.getLayoutParams();
            int ah = l.ah(this.iCf);
            layoutParams.height = ah / 2;
            layoutParams.topMargin = (int) (ah * 0.22f);
            this.iCm.postInvalidate();
        }
        if (l.kw()) {
            this.iCl = com.baidu.tieba.t.b.cty();
            if (this.iCl != null && this.iCf.getWindow() != null) {
                this.iCf.getWindow().setBackgroundDrawable(this.iCl);
            }
        }
        this.iCv = findViewById(R.id.push_dialog_bottom_layout);
        this.iCv.setOnClickListener(this);
        this.iCw = (TextView) findViewById(R.id.comment_num);
        this.iCn = (TbImageView) findViewById(R.id.push_dialog_title_img);
        this.iCn.setDefaultBgResource(R.drawable.icon);
        this.iCn.setAutoChangeStyle(false);
        this.iCo = (TextView) findViewById(R.id.push_dialog_title_text);
        this.iCq = (TextView) findViewById(R.id.push_dialog_content_title);
        this.iCs = (ClickableHeaderImageView) findViewById(R.id.push_dialog_user_head);
        this.iCs.setBorderSurroundContent(true);
        this.iCs.setIsRound(true);
        this.iCs.setEnabled(false);
        this.iCs.setAutoChangeStyle(false);
        this.iCs.setBorderWidth(l.g(this.iCf, R.dimen.tbds1));
        this.iCs.setBorderColor(ContextCompat.getColor(this.iCf, R.color.black_alpha15));
        this.iCx = new com.baidu.tbadk.widget.richText.a();
        this.gXn = (TbRichTextView) findViewById(R.id.push_dialog_content);
        this.gXn.setTextColor(ContextCompat.getColor(this.iCf, R.color.cp_cont_j));
        this.iCx.ly(l.g(this.iCf, R.dimen.tbds38));
        this.iCx.setTextSize(l.g(this.iCf, R.dimen.tbds42));
        this.iCx.lC(l.g(this.iCf, R.dimen.tbds23));
        this.iCx.setLineSpacing(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.iCx.av(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.gXn.setLayoutStrategy(this.iCx);
        this.iCr = (PushDialogVideoView) findViewById(R.id.push_dialog_video);
        this.iCr.setPageContext(this.iCf.getPageContext());
        this.tvUserName = (TextView) findViewById(R.id.push_dialog_user_name);
        this.iCt = (TextView) findViewById(R.id.push_dialog_user_god_info);
        this.iCu = (CommonUserLikeButton) findViewById(R.id.push_dialog_user_like_btn);
        this.iCu.setAfterOnClickListener(this);
        this.iCp = (ImageView) findViewById(R.id.dialog_close_btn);
        this.iCp.setOnClickListener(this);
    }

    public void onResume() {
        if (this.iCr != null) {
            this.iCr.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.iCf.findViewById(i);
    }

    public void cgA() {
        if (this.iCr != null) {
            this.iCr.setNetworkChange();
            if (j.ke() && this.iCr.pB() && this.iCj != null && this.iCj.getFileSize() > 0 && this.iCj.getDuration() > 0) {
                float fileSize = this.iCj.getFileSize() * (1.0f - ((this.iCr.getCurrentPosition() * 1.0f) / (this.iCj.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.iCf.getPageContext().getPageActivity(), String.format(this.iCf.getPageContext().getString(R.string.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int g;
        int g2;
        if (aVar != null) {
            this.iCn.startLoad(aVar.cgC(), 17, false);
            this.iCo.setText(aVar.cgB());
            if (aVar.cgE() != null) {
                this.iCs.setData(aVar.cgE());
                this.tvUserName.setText(aVar.cgE().getName_show());
                if (aVar.cgE().getGodUserData() != null && (!StringUtils.isNull(aVar.cgE().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.cgE().getGodUserData().getIntro()))) {
                    this.iCt.setText(aVar.cgE().getGodUserData().getForumName() + "吧 " + aVar.cgE().getGodIntro());
                    this.iCt.setVisibility(0);
                } else {
                    this.iCt.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.cgE().getUserId())) {
                    this.iCu.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.iCf.getPageContext(), this.iCu).a(aVar.cgE());
                    this.iCu.onChangeSkinType(0);
                    this.iCu.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b cgD = aVar.cgD();
                if (cgD == null) {
                    this.iCf.cgr().ctu();
                    this.iCf.finish();
                    return;
                }
                boolean z = cgD.cgF() == null || v.aa(cgD.cgF().ayL());
                if (StringUtils.isNull(cgD.getTitle()) && z) {
                    this.iCf.cgr().ctu();
                    this.iCf.finish();
                    return;
                }
                if (cgD.cgF() != null) {
                    Iterator<TbRichTextData> it = cgD.cgF().ayL().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.iCj = next.ayW();
                        }
                        if (this.iCj != null) {
                            break;
                        }
                    }
                }
                this.tid = cgD.getTid();
                if (this.iCj == null) {
                    this.iCr.setVisibility(8);
                    this.gXn.setVisibility(0);
                    boolean z2 = j.kf() || j.kd();
                    this.iCx.fT(z2);
                    if (z2) {
                        g = (l.af(TbadkCoreApplication.getInst()) - (l.g(this.iCf, R.dimen.tbds22) * 2)) - (l.g(this.iCf, R.dimen.tbds44) * 2);
                        g2 = (int) (g * 1.618f);
                    } else {
                        g = l.g(this.iCf, R.dimen.tbds360);
                        g2 = l.g(this.iCf, R.dimen.tbds202);
                    }
                    this.iCx.fU(z2);
                    this.iCx.lt(g);
                    this.iCx.lu(g2);
                    this.gXn.setText(cgD.cgF());
                } else {
                    this.gXn.setVisibility(8);
                    this.iCr.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iCr.getLayoutParams();
                    layoutParams.width = l.af(this.iCf) - l.g(this.iCf, R.dimen.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.iCr.setLayoutParams(layoutParams);
                    this.iCr.setTbRichTextVideoInfo(this.iCj);
                    this.iCr.stopPlay();
                    this.iCr.setIsNeedRecoveryVideoPlayer(true);
                    this.iCr.setThumbnail(this.iCj.getThumbUrl());
                    this.iCr.setVideoUrl(this.iCj.getVideoUrl(), String.valueOf(this.tid));
                    this.iCr.bxZ();
                    n nVar = new n(this.iCf.getActivity());
                    nVar.CX("2");
                    z zVar = new z();
                    zVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    zVar.bWO = String.valueOf(this.tid);
                    zVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    nVar.setVideoStatsData(zVar);
                    this.iCr.setQuickVideoViewBusiness(nVar);
                }
                if (StringUtils.isNull(cgD.getTitle())) {
                    this.iCq.setVisibility(8);
                } else {
                    this.iCq.setText(cgD.getTitle());
                    this.iCq.setVisibility(0);
                }
                this.iCw.setText(String.format(Locale.CHINA, this.iCf.getString(R.string.bottom_comment), Integer.valueOf(cgD.getPostNum())));
                if (!this.iCf.cgr().ctx()) {
                    this.iCf.cgr().ctv();
                    return;
                }
                return;
            }
            this.iCf.cgr().ctu();
            this.iCf.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iCp) {
            TiebaStatic.log(new an("c13198").bT("tid", this.iCf.getTid()));
            e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.iCf != null && c.this.iCf.cgr() != null) {
                        c.this.iCf.cgr().ctu();
                    }
                }
            }, 100L);
            this.iCf.finish();
        } else if (view == this.iCv) {
            TiebaStatic.log(new an("c13199").P("obj_locate", 4).bT("tid", this.iCf.getTid()));
            if (this.tid == 0) {
                this.iCf.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.iCf).createNormalCfg(this.tid + "", null, null)));
            this.iCf.cgr().ctv();
            this.iCf.finish();
        } else if (view == this.iCu) {
            TiebaStatic.log(new an("c13199").P("obj_locate", 3).bT("tid", this.iCf.getTid()));
        }
    }

    public void onPause() {
        if (this.iCr != null) {
            this.iCr.onPause();
        }
    }

    public void onDestroy() {
        if (this.iCr != null) {
            this.iCr.onDestroy();
        }
    }
}
