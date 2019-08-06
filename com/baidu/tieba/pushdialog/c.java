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
    private EditorScrollView cmt;
    private TbRichTextView gYf;
    private TextView iDA;
    private com.baidu.tbadk.widget.richText.a iDB;
    private boolean iDC = false;
    private final PushDialogActivity iDj;
    private f iDn;
    private Drawable iDp;
    private View iDq;
    private TbImageView iDr;
    private TextView iDs;
    private ImageView iDt;
    private TextView iDu;
    private PushDialogVideoView iDv;
    private ClickableHeaderImageView iDw;
    private TextView iDx;
    private CommonUserLikeButton iDy;
    private View iDz;
    private View mRootView;
    private long tid;
    private TextView tvUserName;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.iDj = pushDialogActivity;
        this.iDj.setContentView(i);
        this.mRootView = findViewById(R.id.root_view);
        this.iDq = findViewById(R.id.dialog_wrapper_view);
        this.cmt = (EditorScrollView) findViewById(R.id.push_dialog_content_layout);
        this.cmt.setOverScrollMode(2);
        this.cmt.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.iDC) {
                    TiebaStatic.log(new an("c13199").P("obj_locate", 1).bT("tid", c.this.iDj.getTid()));
                    c.this.iDC = true;
                }
            }
        });
        if (this.iDq.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iDq.getLayoutParams();
            int ah = l.ah(this.iDj);
            layoutParams.height = ah / 2;
            layoutParams.topMargin = (int) (ah * 0.22f);
            this.iDq.postInvalidate();
        }
        if (l.kw()) {
            this.iDp = com.baidu.tieba.t.b.ctU();
            if (this.iDp != null && this.iDj.getWindow() != null) {
                this.iDj.getWindow().setBackgroundDrawable(this.iDp);
            }
        }
        this.iDz = findViewById(R.id.push_dialog_bottom_layout);
        this.iDz.setOnClickListener(this);
        this.iDA = (TextView) findViewById(R.id.comment_num);
        this.iDr = (TbImageView) findViewById(R.id.push_dialog_title_img);
        this.iDr.setDefaultBgResource(R.drawable.icon);
        this.iDr.setAutoChangeStyle(false);
        this.iDs = (TextView) findViewById(R.id.push_dialog_title_text);
        this.iDu = (TextView) findViewById(R.id.push_dialog_content_title);
        this.iDw = (ClickableHeaderImageView) findViewById(R.id.push_dialog_user_head);
        this.iDw.setBorderSurroundContent(true);
        this.iDw.setIsRound(true);
        this.iDw.setEnabled(false);
        this.iDw.setAutoChangeStyle(false);
        this.iDw.setBorderWidth(l.g(this.iDj, R.dimen.tbds1));
        this.iDw.setBorderColor(ContextCompat.getColor(this.iDj, R.color.black_alpha15));
        this.iDB = new com.baidu.tbadk.widget.richText.a();
        this.gYf = (TbRichTextView) findViewById(R.id.push_dialog_content);
        this.gYf.setTextColor(ContextCompat.getColor(this.iDj, R.color.cp_cont_j));
        this.iDB.lz(l.g(this.iDj, R.dimen.tbds38));
        this.iDB.setTextSize(l.g(this.iDj, R.dimen.tbds42));
        this.iDB.lD(l.g(this.iDj, R.dimen.tbds23));
        this.iDB.setLineSpacing(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.iDB.av(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.gYf.setLayoutStrategy(this.iDB);
        this.iDv = (PushDialogVideoView) findViewById(R.id.push_dialog_video);
        this.iDv.setPageContext(this.iDj.getPageContext());
        this.tvUserName = (TextView) findViewById(R.id.push_dialog_user_name);
        this.iDx = (TextView) findViewById(R.id.push_dialog_user_god_info);
        this.iDy = (CommonUserLikeButton) findViewById(R.id.push_dialog_user_like_btn);
        this.iDy.setAfterOnClickListener(this);
        this.iDt = (ImageView) findViewById(R.id.dialog_close_btn);
        this.iDt.setOnClickListener(this);
    }

    public void onResume() {
        if (this.iDv != null) {
            this.iDv.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.iDj.findViewById(i);
    }

    public void cgS() {
        if (this.iDv != null) {
            this.iDv.setNetworkChange();
            if (j.ke() && this.iDv.pB() && this.iDn != null && this.iDn.getFileSize() > 0 && this.iDn.getDuration() > 0) {
                float fileSize = this.iDn.getFileSize() * (1.0f - ((this.iDv.getCurrentPosition() * 1.0f) / (this.iDn.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.iDj.getPageContext().getPageActivity(), String.format(this.iDj.getPageContext().getString(R.string.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int g;
        int g2;
        if (aVar != null) {
            this.iDr.startLoad(aVar.cgU(), 17, false);
            this.iDs.setText(aVar.cgT());
            if (aVar.cgW() != null) {
                this.iDw.setData(aVar.cgW());
                this.tvUserName.setText(aVar.cgW().getName_show());
                if (aVar.cgW().getGodUserData() != null && (!StringUtils.isNull(aVar.cgW().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.cgW().getGodUserData().getIntro()))) {
                    this.iDx.setText(aVar.cgW().getGodUserData().getForumName() + "吧 " + aVar.cgW().getGodIntro());
                    this.iDx.setVisibility(0);
                } else {
                    this.iDx.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.cgW().getUserId())) {
                    this.iDy.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.iDj.getPageContext(), this.iDy).a(aVar.cgW());
                    this.iDy.onChangeSkinType(0);
                    this.iDy.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b cgV = aVar.cgV();
                if (cgV == null) {
                    this.iDj.cgJ().ctQ();
                    this.iDj.finish();
                    return;
                }
                boolean z = cgV.cgX() == null || v.aa(cgV.cgX().ayN());
                if (StringUtils.isNull(cgV.getTitle()) && z) {
                    this.iDj.cgJ().ctQ();
                    this.iDj.finish();
                    return;
                }
                if (cgV.cgX() != null) {
                    Iterator<TbRichTextData> it = cgV.cgX().ayN().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.iDn = next.ayY();
                        }
                        if (this.iDn != null) {
                            break;
                        }
                    }
                }
                this.tid = cgV.getTid();
                if (this.iDn == null) {
                    this.iDv.setVisibility(8);
                    this.gYf.setVisibility(0);
                    boolean z2 = j.kf() || j.kd();
                    this.iDB.fT(z2);
                    if (z2) {
                        g = (l.af(TbadkCoreApplication.getInst()) - (l.g(this.iDj, R.dimen.tbds22) * 2)) - (l.g(this.iDj, R.dimen.tbds44) * 2);
                        g2 = (int) (g * 1.618f);
                    } else {
                        g = l.g(this.iDj, R.dimen.tbds360);
                        g2 = l.g(this.iDj, R.dimen.tbds202);
                    }
                    this.iDB.fU(z2);
                    this.iDB.lu(g);
                    this.iDB.lv(g2);
                    this.gYf.setText(cgV.cgX());
                } else {
                    this.gYf.setVisibility(8);
                    this.iDv.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iDv.getLayoutParams();
                    layoutParams.width = l.af(this.iDj) - l.g(this.iDj, R.dimen.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.iDv.setLayoutParams(layoutParams);
                    this.iDv.setTbRichTextVideoInfo(this.iDn);
                    this.iDv.stopPlay();
                    this.iDv.setIsNeedRecoveryVideoPlayer(true);
                    this.iDv.setThumbnail(this.iDn.getThumbUrl());
                    this.iDv.setVideoUrl(this.iDn.getVideoUrl(), String.valueOf(this.tid));
                    this.iDv.byn();
                    n nVar = new n(this.iDj.getActivity());
                    nVar.CY("2");
                    z zVar = new z();
                    zVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    zVar.bWU = String.valueOf(this.tid);
                    zVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    nVar.setVideoStatsData(zVar);
                    this.iDv.setQuickVideoViewBusiness(nVar);
                }
                if (StringUtils.isNull(cgV.getTitle())) {
                    this.iDu.setVisibility(8);
                } else {
                    this.iDu.setText(cgV.getTitle());
                    this.iDu.setVisibility(0);
                }
                this.iDA.setText(String.format(Locale.CHINA, this.iDj.getString(R.string.bottom_comment), Integer.valueOf(cgV.getPostNum())));
                if (!this.iDj.cgJ().ctT()) {
                    this.iDj.cgJ().ctR();
                    return;
                }
                return;
            }
            this.iDj.cgJ().ctQ();
            this.iDj.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iDt) {
            TiebaStatic.log(new an("c13198").bT("tid", this.iDj.getTid()));
            e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.iDj != null && c.this.iDj.cgJ() != null) {
                        c.this.iDj.cgJ().ctQ();
                    }
                }
            }, 100L);
            this.iDj.finish();
        } else if (view == this.iDz) {
            TiebaStatic.log(new an("c13199").P("obj_locate", 4).bT("tid", this.iDj.getTid()));
            if (this.tid == 0) {
                this.iDj.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.iDj).createNormalCfg(this.tid + "", null, null)));
            this.iDj.cgJ().ctR();
            this.iDj.finish();
        } else if (view == this.iDy) {
            TiebaStatic.log(new an("c13199").P("obj_locate", 3).bT("tid", this.iDj.getTid()));
        }
    }

    public void onPause() {
        if (this.iDv != null) {
            this.iDv.onPause();
        }
    }

    public void onDestroy() {
        if (this.iDv != null) {
            this.iDv.onDestroy();
        }
    }
}
