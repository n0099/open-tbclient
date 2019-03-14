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
    private Drawable idB;
    private View idC;
    private TbImageView idD;
    private TextView idE;
    private ImageView idF;
    private TextView idG;
    private PushDialogVideoView idH;
    private ClickableHeaderImageView idI;
    private TextView idJ;
    private CommonUserLikeButton idK;
    private View idL;
    private TextView idM;
    private com.baidu.tbadk.widget.richText.a idN;
    private boolean idO = false;
    private final PushDialogActivity idv;
    private f idz;
    private View mRootView;
    private long tid;
    private TextView tvUserName;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.idv = pushDialogActivity;
        this.idv.setContentView(i);
        this.mRootView = findViewById(d.g.root_view);
        this.idC = findViewById(d.g.dialog_wrapper_view);
        this.ccR = (EditorScrollView) findViewById(d.g.push_dialog_content_layout);
        this.ccR.setOverScrollMode(2);
        this.ccR.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.idO) {
                    TiebaStatic.log(new am("c13199").T("obj_locate", 1).bJ("tid", c.this.idv.getTid()));
                    c.this.idO = true;
                }
            }
        });
        if (this.idC.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.idC.getLayoutParams();
            int aQ = l.aQ(this.idv);
            layoutParams.height = aQ / 2;
            layoutParams.topMargin = (int) (aQ * 0.22f);
            this.idC.postInvalidate();
        }
        if (l.lr()) {
            this.idB = com.baidu.tieba.t.b.ciJ();
            if (this.idB != null && this.idv.getWindow() != null) {
                this.idv.getWindow().setBackgroundDrawable(this.idB);
            }
        }
        this.idL = findViewById(d.g.push_dialog_bottom_layout);
        this.idL.setOnClickListener(this);
        this.idM = (TextView) findViewById(d.g.comment_num);
        this.idD = (TbImageView) findViewById(d.g.push_dialog_title_img);
        this.idD.setDefaultBgResource(d.f.icon);
        this.idD.setAutoChangeStyle(false);
        this.idE = (TextView) findViewById(d.g.push_dialog_title_text);
        this.idG = (TextView) findViewById(d.g.push_dialog_content_title);
        this.idI = (ClickableHeaderImageView) findViewById(d.g.push_dialog_user_head);
        this.idI.setBorderSurroundContent(true);
        this.idI.setIsRound(true);
        this.idI.setEnabled(false);
        this.idI.setAutoChangeStyle(false);
        this.idI.setBorderWidth(l.h(this.idv, d.e.tbds1));
        this.idI.setBorderColor(ContextCompat.getColor(this.idv, d.C0277d.black_alpha15));
        this.idN = new com.baidu.tbadk.widget.richText.a();
        this.gzY = (TbRichTextView) findViewById(d.g.push_dialog_content);
        this.gzY.setTextColor(ContextCompat.getColor(this.idv, d.C0277d.cp_cont_j));
        this.idN.kE(l.h(this.idv, d.e.tbds38));
        this.idN.setTextSize(l.h(this.idv, d.e.tbds42));
        this.idN.kI(l.h(this.idv, d.e.tbds23));
        this.idN.setLineSpacing(l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds7), 1.0f);
        this.idN.ar(l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds48), l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds48));
        this.gzY.setLayoutStrategy(this.idN);
        this.idH = (PushDialogVideoView) findViewById(d.g.push_dialog_video);
        this.idH.setPageContext(this.idv.getPageContext());
        this.tvUserName = (TextView) findViewById(d.g.push_dialog_user_name);
        this.idJ = (TextView) findViewById(d.g.push_dialog_user_god_info);
        this.idK = (CommonUserLikeButton) findViewById(d.g.push_dialog_user_like_btn);
        this.idK.setAfterOnClickListener(this);
        this.idF = (ImageView) findViewById(d.g.dialog_close_btn);
        this.idF.setOnClickListener(this);
    }

    public void onResume() {
        if (this.idH != null) {
            this.idH.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.idv.findViewById(i);
    }

    public void bVI() {
        if (this.idH != null) {
            this.idH.setNetworkChange();
            if (j.la() && this.idH.ql() && this.idz != null && this.idz.getFileSize() > 0 && this.idz.getDuration() > 0) {
                float fileSize = this.idz.getFileSize() * (1.0f - ((this.idH.getCurrentPosition() * 1.0f) / (this.idz.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.idv.getPageContext().getPageActivity(), String.format(this.idv.getPageContext().getString(d.j.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int h;
        int h2;
        if (aVar != null) {
            this.idD.startLoad(aVar.bVK(), 17, false);
            this.idE.setText(aVar.bVJ());
            if (aVar.bVM() != null) {
                this.idI.setData(aVar.bVM());
                this.tvUserName.setText(aVar.bVM().getName_show());
                if (aVar.bVM().getGodUserData() != null && (!StringUtils.isNull(aVar.bVM().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.bVM().getGodUserData().getIntro()))) {
                    this.idJ.setText(aVar.bVM().getGodUserData().getForumName() + "吧 " + aVar.bVM().getGodIntro());
                    this.idJ.setVisibility(0);
                } else {
                    this.idJ.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.bVM().getUserId())) {
                    this.idK.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.idv.getPageContext(), this.idK).a(aVar.bVM());
                    this.idK.onChangeSkinType(0);
                    this.idK.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b bVL = aVar.bVL();
                if (bVL == null) {
                    this.idv.bVz().ciG();
                    this.idv.finish();
                    return;
                }
                boolean z = bVL.bVN() == null || v.T(bVL.bVN().asw());
                if (StringUtils.isNull(bVL.getTitle()) && z) {
                    this.idv.bVz().ciG();
                    this.idv.finish();
                    return;
                }
                if (bVL.bVN() != null) {
                    Iterator<TbRichTextData> it = bVL.bVN().asw().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.idz = next.asH();
                        }
                        if (this.idz != null) {
                            break;
                        }
                    }
                }
                this.tid = bVL.getTid();
                if (this.idz == null) {
                    this.idH.setVisibility(8);
                    this.gzY.setVisibility(0);
                    boolean z2 = j.lb() || j.kZ();
                    this.idN.fs(z2);
                    if (z2) {
                        h = (l.aO(TbadkCoreApplication.getInst()) - (l.h(this.idv, d.e.tbds22) * 2)) - (l.h(this.idv, d.e.tbds44) * 2);
                        h2 = (int) (h * 1.618f);
                    } else {
                        h = l.h(this.idv, d.e.tbds360);
                        h2 = l.h(this.idv, d.e.tbds202);
                    }
                    this.idN.ft(z2);
                    this.idN.kz(h);
                    this.idN.kA(h2);
                    this.gzY.setText(bVL.bVN());
                } else {
                    this.gzY.setVisibility(8);
                    this.idH.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.idH.getLayoutParams();
                    layoutParams.width = l.aO(this.idv) - l.h(this.idv, d.e.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.idH.setLayoutParams(layoutParams);
                    this.idH.setTbRichTextVideoInfo(this.idz);
                    this.idH.stopPlay();
                    this.idH.setIsNeedRecoveryVideoPlayer(true);
                    this.idH.setThumbnail(this.idz.getThumbUrl());
                    this.idH.setVideoUrl(this.idz.getVideoUrl(), String.valueOf(this.tid));
                    this.idH.bnQ();
                    n nVar = new n(this.idv.getActivity());
                    nVar.AR("2");
                    z zVar = new z();
                    zVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    zVar.ctu = String.valueOf(this.tid);
                    zVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    nVar.setVideoStatsData(zVar);
                    this.idH.setQuickVideoViewBusiness(nVar);
                }
                if (StringUtils.isNull(bVL.getTitle())) {
                    this.idG.setVisibility(8);
                } else {
                    this.idG.setText(bVL.getTitle());
                    this.idG.setVisibility(0);
                }
                this.idM.setText(String.format(Locale.CHINA, this.idv.getString(d.j.bottom_comment), Integer.valueOf(bVL.getPostNum())));
                if (!this.idv.bVz().isScreenOn()) {
                    this.idv.bVz().ciH();
                    return;
                }
                return;
            }
            this.idv.bVz().ciG();
            this.idv.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.idF) {
            TiebaStatic.log(new am("c13198").bJ("tid", this.idv.getTid()));
            e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.idv != null && c.this.idv.bVz() != null) {
                        c.this.idv.bVz().ciG();
                    }
                }
            }, 100L);
            this.idv.finish();
        } else if (view == this.idL) {
            TiebaStatic.log(new am("c13199").T("obj_locate", 4).bJ("tid", this.idv.getTid()));
            if (this.tid == 0) {
                this.idv.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.idv).createNormalCfg(this.tid + "", null, null)));
            this.idv.bVz().ciH();
            this.idv.finish();
        } else if (view == this.idK) {
            TiebaStatic.log(new am("c13199").T("obj_locate", 3).bJ("tid", this.idv.getTid()));
        }
    }

    public void onPause() {
        if (this.idH != null) {
            this.idH.onPause();
        }
    }

    public void onDestroy() {
        if (this.idH != null) {
            this.idH.onDestroy();
        }
    }
}
