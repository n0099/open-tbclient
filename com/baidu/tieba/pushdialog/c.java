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
    private EditorScrollView cno;
    private TbRichTextView gZZ;
    private final PushDialogActivity iFB;
    private f iFF;
    private Drawable iFH;
    private View iFI;
    private TbImageView iFJ;
    private TextView iFK;
    private ImageView iFL;
    private TextView iFM;
    private PushDialogVideoView iFN;
    private ClickableHeaderImageView iFO;
    private TextView iFP;
    private CommonUserLikeButton iFQ;
    private View iFR;
    private TextView iFS;
    private com.baidu.tbadk.widget.richText.a iFT;
    private boolean iFU = false;
    private View mRootView;
    private long tid;
    private TextView tvUserName;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.iFB = pushDialogActivity;
        this.iFB.setContentView(i);
        this.mRootView = findViewById(R.id.root_view);
        this.iFI = findViewById(R.id.dialog_wrapper_view);
        this.cno = (EditorScrollView) findViewById(R.id.push_dialog_content_layout);
        this.cno.setOverScrollMode(2);
        this.cno.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.iFU) {
                    TiebaStatic.log(new an("c13199").P("obj_locate", 1).bT("tid", c.this.iFB.getTid()));
                    c.this.iFU = true;
                }
            }
        });
        if (this.iFI.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iFI.getLayoutParams();
            int ah = l.ah(this.iFB);
            layoutParams.height = ah / 2;
            layoutParams.topMargin = (int) (ah * 0.22f);
            this.iFI.postInvalidate();
        }
        if (l.kw()) {
            this.iFH = com.baidu.tieba.t.b.cuI();
            if (this.iFH != null && this.iFB.getWindow() != null) {
                this.iFB.getWindow().setBackgroundDrawable(this.iFH);
            }
        }
        this.iFR = findViewById(R.id.push_dialog_bottom_layout);
        this.iFR.setOnClickListener(this);
        this.iFS = (TextView) findViewById(R.id.comment_num);
        this.iFJ = (TbImageView) findViewById(R.id.push_dialog_title_img);
        this.iFJ.setDefaultBgResource(R.drawable.icon);
        this.iFJ.setAutoChangeStyle(false);
        this.iFK = (TextView) findViewById(R.id.push_dialog_title_text);
        this.iFM = (TextView) findViewById(R.id.push_dialog_content_title);
        this.iFO = (ClickableHeaderImageView) findViewById(R.id.push_dialog_user_head);
        this.iFO.setBorderSurroundContent(true);
        this.iFO.setIsRound(true);
        this.iFO.setEnabled(false);
        this.iFO.setAutoChangeStyle(false);
        this.iFO.setBorderWidth(l.g(this.iFB, R.dimen.tbds1));
        this.iFO.setBorderColor(ContextCompat.getColor(this.iFB, R.color.black_alpha15));
        this.iFT = new com.baidu.tbadk.widget.richText.a();
        this.gZZ = (TbRichTextView) findViewById(R.id.push_dialog_content);
        this.gZZ.setTextColor(ContextCompat.getColor(this.iFB, R.color.cp_cont_j));
        this.iFT.lD(l.g(this.iFB, R.dimen.tbds38));
        this.iFT.setTextSize(l.g(this.iFB, R.dimen.tbds42));
        this.iFT.lH(l.g(this.iFB, R.dimen.tbds23));
        this.iFT.setLineSpacing(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.iFT.av(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.gZZ.setLayoutStrategy(this.iFT);
        this.iFN = (PushDialogVideoView) findViewById(R.id.push_dialog_video);
        this.iFN.setPageContext(this.iFB.getPageContext());
        this.tvUserName = (TextView) findViewById(R.id.push_dialog_user_name);
        this.iFP = (TextView) findViewById(R.id.push_dialog_user_god_info);
        this.iFQ = (CommonUserLikeButton) findViewById(R.id.push_dialog_user_like_btn);
        this.iFQ.setAfterOnClickListener(this);
        this.iFL = (ImageView) findViewById(R.id.dialog_close_btn);
        this.iFL.setOnClickListener(this);
    }

    public void onResume() {
        if (this.iFN != null) {
            this.iFN.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.iFB.findViewById(i);
    }

    public void chG() {
        if (this.iFN != null) {
            this.iFN.setNetworkChange();
            if (j.ke() && this.iFN.pC() && this.iFF != null && this.iFF.getFileSize() > 0 && this.iFF.getDuration() > 0) {
                float fileSize = this.iFF.getFileSize() * (1.0f - ((this.iFN.getCurrentPosition() * 1.0f) / (this.iFF.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.iFB.getPageContext().getPageActivity(), String.format(this.iFB.getPageContext().getString(R.string.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int g;
        int g2;
        if (aVar != null) {
            this.iFJ.startLoad(aVar.chI(), 17, false);
            this.iFK.setText(aVar.chH());
            if (aVar.chK() != null) {
                this.iFO.setData(aVar.chK());
                this.tvUserName.setText(aVar.chK().getName_show());
                if (aVar.chK().getGodUserData() != null && (!StringUtils.isNull(aVar.chK().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.chK().getGodUserData().getIntro()))) {
                    this.iFP.setText(aVar.chK().getGodUserData().getForumName() + "吧 " + aVar.chK().getGodIntro());
                    this.iFP.setVisibility(0);
                } else {
                    this.iFP.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.chK().getUserId())) {
                    this.iFQ.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.iFB.getPageContext(), this.iFQ).a(aVar.chK());
                    this.iFQ.onChangeSkinType(0);
                    this.iFQ.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b chJ = aVar.chJ();
                if (chJ == null) {
                    this.iFB.chx().cuE();
                    this.iFB.finish();
                    return;
                }
                boolean z = chJ.chL() == null || v.aa(chJ.chL().ayZ());
                if (StringUtils.isNull(chJ.getTitle()) && z) {
                    this.iFB.chx().cuE();
                    this.iFB.finish();
                    return;
                }
                if (chJ.chL() != null) {
                    Iterator<TbRichTextData> it = chJ.chL().ayZ().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.iFF = next.azk();
                        }
                        if (this.iFF != null) {
                            break;
                        }
                    }
                }
                this.tid = chJ.getTid();
                if (this.iFF == null) {
                    this.iFN.setVisibility(8);
                    this.gZZ.setVisibility(0);
                    boolean z2 = j.kf() || j.kd();
                    this.iFT.fW(z2);
                    if (z2) {
                        g = (l.af(TbadkCoreApplication.getInst()) - (l.g(this.iFB, R.dimen.tbds22) * 2)) - (l.g(this.iFB, R.dimen.tbds44) * 2);
                        g2 = (int) (g * 1.618f);
                    } else {
                        g = l.g(this.iFB, R.dimen.tbds360);
                        g2 = l.g(this.iFB, R.dimen.tbds202);
                    }
                    this.iFT.fX(z2);
                    this.iFT.ly(g);
                    this.iFT.lz(g2);
                    this.gZZ.setText(chJ.chL());
                } else {
                    this.gZZ.setVisibility(8);
                    this.iFN.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iFN.getLayoutParams();
                    layoutParams.width = l.af(this.iFB) - l.g(this.iFB, R.dimen.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.iFN.setLayoutParams(layoutParams);
                    this.iFN.setTbRichTextVideoInfo(this.iFF);
                    this.iFN.stopPlay();
                    this.iFN.setIsNeedRecoveryVideoPlayer(true);
                    this.iFN.setThumbnail(this.iFF.getThumbUrl());
                    this.iFN.setVideoUrl(this.iFF.getVideoUrl(), String.valueOf(this.tid));
                    this.iFN.bzb();
                    n nVar = new n(this.iFB.getActivity());
                    nVar.Dx("2");
                    z zVar = new z();
                    zVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    zVar.bXN = String.valueOf(this.tid);
                    zVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    nVar.setVideoStatsData(zVar);
                    this.iFN.setQuickVideoViewBusiness(nVar);
                }
                if (StringUtils.isNull(chJ.getTitle())) {
                    this.iFM.setVisibility(8);
                } else {
                    this.iFM.setText(chJ.getTitle());
                    this.iFM.setVisibility(0);
                }
                this.iFS.setText(String.format(Locale.CHINA, this.iFB.getString(R.string.bottom_comment), Integer.valueOf(chJ.getPostNum())));
                if (!this.iFB.chx().cuH()) {
                    this.iFB.chx().cuF();
                    return;
                }
                return;
            }
            this.iFB.chx().cuE();
            this.iFB.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iFL) {
            TiebaStatic.log(new an("c13198").bT("tid", this.iFB.getTid()));
            e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.iFB != null && c.this.iFB.chx() != null) {
                        c.this.iFB.chx().cuE();
                    }
                }
            }, 100L);
            this.iFB.finish();
        } else if (view == this.iFR) {
            TiebaStatic.log(new an("c13199").P("obj_locate", 4).bT("tid", this.iFB.getTid()));
            if (this.tid == 0) {
                this.iFB.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.iFB).createNormalCfg(this.tid + "", null, null)));
            this.iFB.chx().cuF();
            this.iFB.finish();
        } else if (view == this.iFQ) {
            TiebaStatic.log(new an("c13199").P("obj_locate", 3).bT("tid", this.iFB.getTid()));
        }
    }

    public void onPause() {
        if (this.iFN != null) {
            this.iFN.onPause();
        }
    }

    public void onDestroy() {
        if (this.iFN != null) {
            this.iFN.onDestroy();
        }
    }
}
