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
    private TbRichTextView gzZ;
    private final PushDialogActivity idB;
    private f idF;
    private Drawable idH;
    private View idI;
    private TbImageView idJ;
    private TextView idK;
    private ImageView idL;
    private TextView idM;
    private PushDialogVideoView idN;
    private ClickableHeaderImageView idO;
    private TextView idP;
    private CommonUserLikeButton idQ;
    private View idR;
    private TextView idS;
    private com.baidu.tbadk.widget.richText.a idT;
    private boolean idU = false;
    private View mRootView;
    private long tid;
    private TextView tvUserName;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.idB = pushDialogActivity;
        this.idB.setContentView(i);
        this.mRootView = findViewById(d.g.root_view);
        this.idI = findViewById(d.g.dialog_wrapper_view);
        this.ccR = (EditorScrollView) findViewById(d.g.push_dialog_content_layout);
        this.ccR.setOverScrollMode(2);
        this.ccR.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.idU) {
                    TiebaStatic.log(new am("c13199").T("obj_locate", 1).bJ("tid", c.this.idB.getTid()));
                    c.this.idU = true;
                }
            }
        });
        if (this.idI.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.idI.getLayoutParams();
            int aQ = l.aQ(this.idB);
            layoutParams.height = aQ / 2;
            layoutParams.topMargin = (int) (aQ * 0.22f);
            this.idI.postInvalidate();
        }
        if (l.lr()) {
            this.idH = com.baidu.tieba.t.b.ciG();
            if (this.idH != null && this.idB.getWindow() != null) {
                this.idB.getWindow().setBackgroundDrawable(this.idH);
            }
        }
        this.idR = findViewById(d.g.push_dialog_bottom_layout);
        this.idR.setOnClickListener(this);
        this.idS = (TextView) findViewById(d.g.comment_num);
        this.idJ = (TbImageView) findViewById(d.g.push_dialog_title_img);
        this.idJ.setDefaultBgResource(d.f.icon);
        this.idJ.setAutoChangeStyle(false);
        this.idK = (TextView) findViewById(d.g.push_dialog_title_text);
        this.idM = (TextView) findViewById(d.g.push_dialog_content_title);
        this.idO = (ClickableHeaderImageView) findViewById(d.g.push_dialog_user_head);
        this.idO.setBorderSurroundContent(true);
        this.idO.setIsRound(true);
        this.idO.setEnabled(false);
        this.idO.setAutoChangeStyle(false);
        this.idO.setBorderWidth(l.h(this.idB, d.e.tbds1));
        this.idO.setBorderColor(ContextCompat.getColor(this.idB, d.C0236d.black_alpha15));
        this.idT = new com.baidu.tbadk.widget.richText.a();
        this.gzZ = (TbRichTextView) findViewById(d.g.push_dialog_content);
        this.gzZ.setTextColor(ContextCompat.getColor(this.idB, d.C0236d.cp_cont_j));
        this.idT.kE(l.h(this.idB, d.e.tbds38));
        this.idT.setTextSize(l.h(this.idB, d.e.tbds42));
        this.idT.kI(l.h(this.idB, d.e.tbds23));
        this.idT.setLineSpacing(l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds7), 1.0f);
        this.idT.ar(l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds48), l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds48));
        this.gzZ.setLayoutStrategy(this.idT);
        this.idN = (PushDialogVideoView) findViewById(d.g.push_dialog_video);
        this.idN.setPageContext(this.idB.getPageContext());
        this.tvUserName = (TextView) findViewById(d.g.push_dialog_user_name);
        this.idP = (TextView) findViewById(d.g.push_dialog_user_god_info);
        this.idQ = (CommonUserLikeButton) findViewById(d.g.push_dialog_user_like_btn);
        this.idQ.setAfterOnClickListener(this);
        this.idL = (ImageView) findViewById(d.g.dialog_close_btn);
        this.idL.setOnClickListener(this);
    }

    public void onResume() {
        if (this.idN != null) {
            this.idN.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.idB.findViewById(i);
    }

    public void bVG() {
        if (this.idN != null) {
            this.idN.setNetworkChange();
            if (j.la() && this.idN.ql() && this.idF != null && this.idF.getFileSize() > 0 && this.idF.getDuration() > 0) {
                float fileSize = this.idF.getFileSize() * (1.0f - ((this.idN.getCurrentPosition() * 1.0f) / (this.idF.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.idB.getPageContext().getPageActivity(), String.format(this.idB.getPageContext().getString(d.j.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int h;
        int h2;
        if (aVar != null) {
            this.idJ.startLoad(aVar.bVI(), 17, false);
            this.idK.setText(aVar.bVH());
            if (aVar.bVK() != null) {
                this.idO.setData(aVar.bVK());
                this.tvUserName.setText(aVar.bVK().getName_show());
                if (aVar.bVK().getGodUserData() != null && (!StringUtils.isNull(aVar.bVK().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.bVK().getGodUserData().getIntro()))) {
                    this.idP.setText(aVar.bVK().getGodUserData().getForumName() + "吧 " + aVar.bVK().getGodIntro());
                    this.idP.setVisibility(0);
                } else {
                    this.idP.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.bVK().getUserId())) {
                    this.idQ.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.idB.getPageContext(), this.idQ).a(aVar.bVK());
                    this.idQ.onChangeSkinType(0);
                    this.idQ.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b bVJ = aVar.bVJ();
                if (bVJ == null) {
                    this.idB.bVx().ciD();
                    this.idB.finish();
                    return;
                }
                boolean z = bVJ.bVL() == null || v.T(bVJ.bVL().asx());
                if (StringUtils.isNull(bVJ.getTitle()) && z) {
                    this.idB.bVx().ciD();
                    this.idB.finish();
                    return;
                }
                if (bVJ.bVL() != null) {
                    Iterator<TbRichTextData> it = bVJ.bVL().asx().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.idF = next.asI();
                        }
                        if (this.idF != null) {
                            break;
                        }
                    }
                }
                this.tid = bVJ.getTid();
                if (this.idF == null) {
                    this.idN.setVisibility(8);
                    this.gzZ.setVisibility(0);
                    boolean z2 = j.lb() || j.kZ();
                    this.idT.fs(z2);
                    if (z2) {
                        h = (l.aO(TbadkCoreApplication.getInst()) - (l.h(this.idB, d.e.tbds22) * 2)) - (l.h(this.idB, d.e.tbds44) * 2);
                        h2 = (int) (h * 1.618f);
                    } else {
                        h = l.h(this.idB, d.e.tbds360);
                        h2 = l.h(this.idB, d.e.tbds202);
                    }
                    this.idT.ft(z2);
                    this.idT.kz(h);
                    this.idT.kA(h2);
                    this.gzZ.setText(bVJ.bVL());
                } else {
                    this.gzZ.setVisibility(8);
                    this.idN.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.idN.getLayoutParams();
                    layoutParams.width = l.aO(this.idB) - l.h(this.idB, d.e.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.idN.setLayoutParams(layoutParams);
                    this.idN.setTbRichTextVideoInfo(this.idF);
                    this.idN.stopPlay();
                    this.idN.setIsNeedRecoveryVideoPlayer(true);
                    this.idN.setThumbnail(this.idF.getThumbUrl());
                    this.idN.setVideoUrl(this.idF.getVideoUrl(), String.valueOf(this.tid));
                    this.idN.bnR();
                    n nVar = new n(this.idB.getActivity());
                    nVar.AT("2");
                    z zVar = new z();
                    zVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    zVar.ctx = String.valueOf(this.tid);
                    zVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    nVar.setVideoStatsData(zVar);
                    this.idN.setQuickVideoViewBusiness(nVar);
                }
                if (StringUtils.isNull(bVJ.getTitle())) {
                    this.idM.setVisibility(8);
                } else {
                    this.idM.setText(bVJ.getTitle());
                    this.idM.setVisibility(0);
                }
                this.idS.setText(String.format(Locale.CHINA, this.idB.getString(d.j.bottom_comment), Integer.valueOf(bVJ.getPostNum())));
                if (!this.idB.bVx().isScreenOn()) {
                    this.idB.bVx().ciE();
                    return;
                }
                return;
            }
            this.idB.bVx().ciD();
            this.idB.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.idL) {
            TiebaStatic.log(new am("c13198").bJ("tid", this.idB.getTid()));
            e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.idB != null && c.this.idB.bVx() != null) {
                        c.this.idB.bVx().ciD();
                    }
                }
            }, 100L);
            this.idB.finish();
        } else if (view == this.idR) {
            TiebaStatic.log(new am("c13199").T("obj_locate", 4).bJ("tid", this.idB.getTid()));
            if (this.tid == 0) {
                this.idB.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.idB).createNormalCfg(this.tid + "", null, null)));
            this.idB.bVx().ciE();
            this.idB.finish();
        } else if (view == this.idQ) {
            TiebaStatic.log(new am("c13199").T("obj_locate", 3).bJ("tid", this.idB.getTid()));
        }
    }

    public void onPause() {
        if (this.idN != null) {
            this.idN.onPause();
        }
    }

    public void onDestroy() {
        if (this.idN != null) {
            this.idN.onDestroy();
        }
    }
}
