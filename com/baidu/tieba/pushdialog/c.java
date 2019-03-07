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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.z;
import com.tencent.connect.common.Constants;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Locale;
/* loaded from: classes3.dex */
public class c implements View.OnClickListener {
    private EditorScrollView ccR;
    private TbRichTextView gzY;
    private final PushDialogActivity idA;
    private f idE;
    private Drawable idG;
    private View idH;
    private TbImageView idI;
    private TextView idJ;
    private ImageView idK;
    private TextView idL;
    private PushDialogVideoView idM;
    private ClickableHeaderImageView idN;
    private TextView idO;
    private CommonUserLikeButton idP;
    private View idQ;
    private TextView idR;
    private com.baidu.tbadk.widget.richText.a idS;
    private boolean idT = false;
    private View mRootView;
    private long tid;
    private TextView tvUserName;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.idA = pushDialogActivity;
        this.idA.setContentView(i);
        this.mRootView = findViewById(d.g.root_view);
        this.idH = findViewById(d.g.dialog_wrapper_view);
        this.ccR = (EditorScrollView) findViewById(d.g.push_dialog_content_layout);
        this.ccR.setOverScrollMode(2);
        this.ccR.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.idT) {
                    TiebaStatic.log(new am("c13199").T("obj_locate", 1).bJ("tid", c.this.idA.getTid()));
                    c.this.idT = true;
                }
            }
        });
        if (this.idH.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.idH.getLayoutParams();
            int aQ = l.aQ(this.idA);
            layoutParams.height = aQ / 2;
            layoutParams.topMargin = (int) (aQ * 0.22f);
            this.idH.postInvalidate();
        }
        if (l.lr()) {
            this.idG = com.baidu.tieba.t.b.ciw();
            if (this.idG != null && this.idA.getWindow() != null) {
                this.idA.getWindow().setBackgroundDrawable(this.idG);
            }
        }
        this.idQ = findViewById(d.g.push_dialog_bottom_layout);
        this.idQ.setOnClickListener(this);
        this.idR = (TextView) findViewById(d.g.comment_num);
        this.idI = (TbImageView) findViewById(d.g.push_dialog_title_img);
        this.idI.setDefaultBgResource(d.f.icon);
        this.idI.setAutoChangeStyle(false);
        this.idJ = (TextView) findViewById(d.g.push_dialog_title_text);
        this.idL = (TextView) findViewById(d.g.push_dialog_content_title);
        this.idN = (ClickableHeaderImageView) findViewById(d.g.push_dialog_user_head);
        this.idN.setBorderSurroundContent(true);
        this.idN.setIsRound(true);
        this.idN.setEnabled(false);
        this.idN.setAutoChangeStyle(false);
        this.idN.setBorderWidth(l.h(this.idA, d.e.tbds1));
        this.idN.setBorderColor(ContextCompat.getColor(this.idA, d.C0236d.black_alpha15));
        this.idS = new com.baidu.tbadk.widget.richText.a();
        this.gzY = (TbRichTextView) findViewById(d.g.push_dialog_content);
        this.gzY.setTextColor(ContextCompat.getColor(this.idA, d.C0236d.cp_cont_j));
        this.idS.kE(l.h(this.idA, d.e.tbds38));
        this.idS.setTextSize(l.h(this.idA, d.e.tbds42));
        this.idS.kI(l.h(this.idA, d.e.tbds23));
        this.idS.setLineSpacing(l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds7), 1.0f);
        this.idS.ar(l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds48), l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds48));
        this.gzY.setLayoutStrategy(this.idS);
        this.idM = (PushDialogVideoView) findViewById(d.g.push_dialog_video);
        this.idM.setPageContext(this.idA.getPageContext());
        this.tvUserName = (TextView) findViewById(d.g.push_dialog_user_name);
        this.idO = (TextView) findViewById(d.g.push_dialog_user_god_info);
        this.idP = (CommonUserLikeButton) findViewById(d.g.push_dialog_user_like_btn);
        this.idP.setAfterOnClickListener(this);
        this.idK = (ImageView) findViewById(d.g.dialog_close_btn);
        this.idK.setOnClickListener(this);
    }

    public void onResume() {
        if (this.idM != null) {
            this.idM.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.idA.findViewById(i);
    }

    public void bVF() {
        if (this.idM != null) {
            this.idM.setNetworkChange();
            if (j.la() && this.idM.ql() && this.idE != null && this.idE.getFileSize() > 0 && this.idE.getDuration() > 0) {
                float fileSize = this.idE.getFileSize() * (1.0f - ((this.idM.getCurrentPosition() * 1.0f) / (this.idE.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.idA.getPageContext().getPageActivity(), String.format(this.idA.getPageContext().getString(d.j.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int h;
        int h2;
        if (aVar != null) {
            this.idI.startLoad(aVar.bVH(), 17, false);
            this.idJ.setText(aVar.bVG());
            if (aVar.bVJ() != null) {
                this.idN.setData(aVar.bVJ());
                this.tvUserName.setText(aVar.bVJ().getName_show());
                if (aVar.bVJ().getGodUserData() != null && (!StringUtils.isNull(aVar.bVJ().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.bVJ().getGodUserData().getIntro()))) {
                    this.idO.setText(aVar.bVJ().getGodUserData().getForumName() + "吧 " + aVar.bVJ().getGodIntro());
                    this.idO.setVisibility(0);
                } else {
                    this.idO.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.bVJ().getUserId())) {
                    this.idP.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.idA.getPageContext(), this.idP).a(aVar.bVJ());
                    this.idP.onChangeSkinType(0);
                    this.idP.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b bVI = aVar.bVI();
                if (bVI == null) {
                    this.idA.bVw().cit();
                    this.idA.finish();
                    return;
                }
                boolean z = bVI.bVK() == null || v.T(bVI.bVK().asw());
                if (StringUtils.isNull(bVI.getTitle()) && z) {
                    this.idA.bVw().cit();
                    this.idA.finish();
                    return;
                }
                if (bVI.bVK() != null) {
                    Iterator<TbRichTextData> it = bVI.bVK().asw().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.idE = next.asH();
                        }
                        if (this.idE != null) {
                            break;
                        }
                    }
                }
                this.tid = bVI.getTid();
                if (this.idE == null) {
                    this.idM.setVisibility(8);
                    this.gzY.setVisibility(0);
                    boolean z2 = j.lb() || j.kZ();
                    this.idS.fs(z2);
                    if (z2) {
                        h = (l.aO(TbadkCoreApplication.getInst()) - (l.h(this.idA, d.e.tbds22) * 2)) - (l.h(this.idA, d.e.tbds44) * 2);
                        h2 = (int) (h * 1.618f);
                    } else {
                        h = l.h(this.idA, d.e.tbds360);
                        h2 = l.h(this.idA, d.e.tbds202);
                    }
                    this.idS.ft(z2);
                    this.idS.kz(h);
                    this.idS.kA(h2);
                    this.gzY.setText(bVI.bVK());
                } else {
                    this.gzY.setVisibility(8);
                    this.idM.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.idM.getLayoutParams();
                    layoutParams.width = l.aO(this.idA) - l.h(this.idA, d.e.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.idM.setLayoutParams(layoutParams);
                    this.idM.setTbRichTextVideoInfo(this.idE);
                    this.idM.stopPlay();
                    this.idM.setIsNeedRecoveryVideoPlayer(true);
                    this.idM.setThumbnail(this.idE.getThumbUrl());
                    this.idM.setVideoUrl(this.idE.getVideoUrl(), String.valueOf(this.tid));
                    this.idM.bnQ();
                    n nVar = new n(this.idA.getActivity());
                    nVar.AS("2");
                    z zVar = new z();
                    zVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    zVar.ctx = String.valueOf(this.tid);
                    zVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    nVar.setVideoStatsData(zVar);
                    this.idM.setQuickVideoViewBusiness(nVar);
                }
                if (StringUtils.isNull(bVI.getTitle())) {
                    this.idL.setVisibility(8);
                } else {
                    this.idL.setText(bVI.getTitle());
                    this.idL.setVisibility(0);
                }
                this.idR.setText(String.format(Locale.CHINA, this.idA.getString(d.j.bottom_comment), Integer.valueOf(bVI.getPostNum())));
                if (!this.idA.bVw().isScreenOn()) {
                    this.idA.bVw().ciu();
                    return;
                }
                return;
            }
            this.idA.bVw().cit();
            this.idA.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.idK) {
            TiebaStatic.log(new am("c13198").bJ("tid", this.idA.getTid()));
            e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.idA != null && c.this.idA.bVw() != null) {
                        c.this.idA.bVw().cit();
                    }
                }
            }, 100L);
            this.idA.finish();
        } else if (view == this.idQ) {
            TiebaStatic.log(new am("c13199").T("obj_locate", 4).bJ("tid", this.idA.getTid()));
            if (this.tid == 0) {
                this.idA.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.idA).createNormalCfg(this.tid + "", null, null)));
            this.idA.bVw().ciu();
            this.idA.finish();
        } else if (view == this.idP) {
            TiebaStatic.log(new am("c13199").T("obj_locate", 3).bJ("tid", this.idA.getTid()));
        }
    }

    public void onPause() {
        if (this.idM != null) {
            this.idM.onPause();
        }
    }

    public void onDestroy() {
        if (this.idM != null) {
            this.idM.onDestroy();
        }
    }
}
