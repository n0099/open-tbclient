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
    private TbRichTextView eZE;
    private EditorScrollView fQE;
    private View gBA;
    private TextView gBB;
    private com.baidu.tbadk.widget.richText.a gBC;
    private boolean gBD = false;
    private final PushDialogActivity gBk;
    private f gBo;
    private Drawable gBq;
    private View gBr;
    private TbImageView gBs;
    private TextView gBt;
    private ImageView gBu;
    private TextView gBv;
    private PushDialogVideoView gBw;
    private ClickableHeaderImageView gBx;
    private TextView gBy;
    private CommonUserLikeButton gBz;
    private View mRootView;
    private long tid;
    private TextView tvUserName;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.gBk = pushDialogActivity;
        this.gBk.setContentView(i);
        this.mRootView = findViewById(e.g.root_view);
        this.gBr = findViewById(e.g.dialog_wrapper_view);
        this.fQE = (EditorScrollView) findViewById(e.g.push_dialog_content_layout);
        this.fQE.setOverScrollMode(2);
        this.fQE.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.gBD) {
                    TiebaStatic.log(new am("c13199").x("obj_locate", 1).ax("tid", c.this.gBk.getTid()));
                    c.this.gBD = true;
                }
            }
        });
        if (this.gBr.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gBr.getLayoutParams();
            int aQ = l.aQ(this.gBk);
            layoutParams.height = aQ / 2;
            layoutParams.topMargin = (int) (aQ * 0.22f);
            this.gBr.postInvalidate();
        }
        if (l.lo()) {
            this.gBq = com.baidu.tieba.t.a.bFG();
            if (this.gBq != null && this.gBk.getWindow() != null) {
                this.gBk.getWindow().setBackgroundDrawable(this.gBq);
            }
        }
        this.gBA = findViewById(e.g.push_dialog_bottom_layout);
        this.gBA.setOnClickListener(this);
        this.gBB = (TextView) findViewById(e.g.comment_num);
        this.gBs = (TbImageView) findViewById(e.g.push_dialog_title_img);
        this.gBs.setDefaultBgResource(e.f.icon);
        this.gBs.setAutoChangeStyle(false);
        this.gBt = (TextView) findViewById(e.g.push_dialog_title_text);
        this.gBv = (TextView) findViewById(e.g.push_dialog_content_title);
        this.gBx = (ClickableHeaderImageView) findViewById(e.g.push_dialog_user_head);
        this.gBx.setBorderSurroundContent(true);
        this.gBx.setIsRound(true);
        this.gBx.setEnabled(false);
        this.gBx.setAutoChangeStyle(false);
        this.gBx.setBorderWidth(l.h(this.gBk, e.C0200e.tbds1));
        this.gBx.setBorderColor(ContextCompat.getColor(this.gBk, e.d.black_alpha15));
        this.gBC = new com.baidu.tbadk.widget.richText.a();
        this.eZE = (TbRichTextView) findViewById(e.g.push_dialog_content);
        this.eZE.setTextColor(ContextCompat.getColor(this.gBk, e.d.cp_cont_j));
        this.gBC.gA(l.h(this.gBk, e.C0200e.tbds38));
        this.gBC.setTextSize(l.h(this.gBk, e.C0200e.tbds42));
        this.gBC.gE(l.h(this.gBk, e.C0200e.tbds23));
        this.gBC.setLineSpacing(l.h(TbadkCoreApplication.getInst().getContext(), e.C0200e.tbds7), 1.0f);
        this.gBC.S(l.h(TbadkCoreApplication.getInst().getContext(), e.C0200e.tbds48), l.h(TbadkCoreApplication.getInst().getContext(), e.C0200e.tbds48));
        this.eZE.setLayoutStrategy(this.gBC);
        this.gBw = (PushDialogVideoView) findViewById(e.g.push_dialog_video);
        this.gBw.setPageContext(this.gBk.getPageContext());
        this.tvUserName = (TextView) findViewById(e.g.push_dialog_user_name);
        this.gBy = (TextView) findViewById(e.g.push_dialog_user_god_info);
        this.gBz = (CommonUserLikeButton) findViewById(e.g.push_dialog_user_like_btn);
        this.gBz.setAfterOnClickListener(this);
        this.gBu = (ImageView) findViewById(e.g.dialog_close_btn);
        this.gBu.setOnClickListener(this);
    }

    public void onResume() {
        if (this.gBw != null) {
            this.gBw.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.gBk.findViewById(i);
    }

    public void brG() {
        if (this.gBw != null) {
            this.gBw.setNetworkChange();
            if (j.kX() && this.gBw.bpd() && this.gBo != null && this.gBo.getFileSize() > 0 && this.gBo.getDuration() > 0) {
                float fileSize = this.gBo.getFileSize() * (1.0f - ((this.gBw.getCurrentPosition() * 1.0f) / (this.gBo.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.gBk.getPageContext().getPageActivity(), String.format(this.gBk.getPageContext().getString(e.j.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int h;
        int h2;
        if (aVar != null) {
            this.gBs.startLoad(aVar.brI(), 17, false);
            this.gBt.setText(aVar.brH());
            if (aVar.brK() != null) {
                this.gBx.setData(aVar.brK());
                this.tvUserName.setText(aVar.brK().getName_show());
                if (aVar.brK().getGodUserData() != null && (!StringUtils.isNull(aVar.brK().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.brK().getGodUserData().getIntro()))) {
                    this.gBy.setText(aVar.brK().getGodUserData().getForumName() + "吧 " + aVar.brK().getGodIntro());
                    this.gBy.setVisibility(0);
                } else {
                    this.gBy.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.brK().getUserId())) {
                    this.gBz.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.gBk.getPageContext(), this.gBz).a(aVar.brK());
                    this.gBz.onChangeSkinType(0);
                    this.gBz.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b brJ = aVar.brJ();
                if (brJ == null) {
                    this.gBk.brx().bFD();
                    this.gBk.finish();
                    return;
                }
                boolean z = brJ.brL() == null || v.I(brJ.brL().QT());
                if (StringUtils.isNull(brJ.getTitle()) && z) {
                    this.gBk.brx().bFD();
                    this.gBk.finish();
                    return;
                }
                if (brJ.brL() != null) {
                    Iterator<TbRichTextData> it = brJ.brL().QT().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.gBo = next.Rd();
                        }
                        if (this.gBo != null) {
                            break;
                        }
                    }
                }
                this.tid = brJ.getTid();
                if (this.gBo == null) {
                    this.gBw.setVisibility(8);
                    this.eZE.setVisibility(0);
                    boolean z2 = j.kY() || j.kW();
                    this.gBC.cY(z2);
                    if (z2) {
                        h = (l.aO(TbadkCoreApplication.getInst()) - (l.h(this.gBk, e.C0200e.tbds22) * 2)) - (l.h(this.gBk, e.C0200e.tbds44) * 2);
                        h2 = (int) (h * 1.618f);
                    } else {
                        h = l.h(this.gBk, e.C0200e.tbds360);
                        h2 = l.h(this.gBk, e.C0200e.tbds202);
                    }
                    this.gBC.cZ(z2);
                    this.gBC.gw(h);
                    this.gBC.gx(h2);
                    this.eZE.setText(brJ.brL());
                } else {
                    this.eZE.setVisibility(8);
                    this.gBw.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gBw.getLayoutParams();
                    layoutParams.width = l.aO(this.gBk) - l.h(this.gBk, e.C0200e.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.gBw.setLayoutParams(layoutParams);
                    this.gBw.setTbRichTextVideoInfo(this.gBo);
                    this.gBw.stopPlay();
                    this.gBw.setIsNeedRecoveryVideoPlayer(true);
                    this.gBw.setThumbnail(this.gBo.getThumbUrl());
                    this.gBw.setVideoUrl(this.gBo.getVideoUrl(), String.valueOf(this.tid));
                    this.gBw.aKf();
                    n nVar = new n(this.gBk.getActivity());
                    nVar.ts("2");
                    z zVar = new z();
                    zVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    zVar.beV = String.valueOf(this.tid);
                    zVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    nVar.setVideoStatsData(zVar);
                    this.gBw.setQuickVideoViewBusiness(nVar);
                }
                if (StringUtils.isNull(brJ.getTitle())) {
                    this.gBv.setVisibility(8);
                } else {
                    this.gBv.setText(brJ.getTitle());
                    this.gBv.setVisibility(0);
                }
                this.gBB.setText(String.format(Locale.CHINA, this.gBk.getString(e.j.bottom_comment), Integer.valueOf(brJ.getPostNum())));
                if (!this.gBk.brx().isScreenOn()) {
                    this.gBk.brx().bFE();
                    return;
                }
                return;
            }
            this.gBk.brx().bFD();
            this.gBk.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gBu) {
            TiebaStatic.log(new am("c13198").ax("tid", this.gBk.getTid()));
            com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.gBk != null && c.this.gBk.brx() != null) {
                        c.this.gBk.brx().bFD();
                    }
                }
            }, 100L);
            this.gBk.finish();
        } else if (view == this.gBA) {
            TiebaStatic.log(new am("c13199").x("obj_locate", 4).ax("tid", this.gBk.getTid()));
            if (this.tid == 0) {
                this.gBk.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.gBk).createNormalCfg(this.tid + "", null, null)));
            this.gBk.brx().bFE();
            this.gBk.finish();
        } else if (view == this.gBz) {
            TiebaStatic.log(new am("c13199").x("obj_locate", 3).ax("tid", this.gBk.getTid()));
        }
    }

    public void onPause() {
        if (this.gBw != null) {
            this.gBw.onPause();
        }
    }

    public void onDestroy() {
        if (this.gBw != null) {
            this.gBw.onDestroy();
        }
    }
}
