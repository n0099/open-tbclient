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
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.y;
import com.tencent.connect.common.Constants;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Locale;
/* loaded from: classes3.dex */
public class c implements View.OnClickListener {
    private TbRichTextView eJt;
    private EditorScrollView fAb;
    private final PushDialogActivity gkP;
    private f gkR;
    private Drawable gkT;
    private View gkU;
    private TbImageView gkV;
    private TextView gkW;
    private ImageView gkX;
    private TextView gkY;
    private PushDialogVideoView gkZ;
    private ClickableHeaderImageView gla;
    private TextView glb;
    private CommonUserLikeButton glc;
    private View gld;
    private TextView gle;
    private com.baidu.tbadk.widget.richText.a glf;
    private boolean glg = false;
    private View mRootView;
    private long tid;
    private TextView tvUserName;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.gkP = pushDialogActivity;
        this.gkP.setContentView(i);
        this.mRootView = findViewById(d.g.root_view);
        this.gkU = findViewById(d.g.dialog_wrapper_view);
        this.fAb = (EditorScrollView) findViewById(d.g.push_dialog_content_layout);
        this.fAb.setOverScrollMode(2);
        this.fAb.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.glg) {
                    TiebaStatic.log(new an("c13199").r("obj_locate", 1).af("tid", c.this.gkP.getTid()));
                    c.this.glg = true;
                }
            }
        });
        if (this.gkU.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gkU.getLayoutParams();
            int aj = l.aj(this.gkP);
            layoutParams.height = aj / 2;
            layoutParams.topMargin = (int) (aj * 0.22f);
            this.gkU.postInvalidate();
        }
        if (l.jY()) {
            this.gkT = com.baidu.tieba.t.a.bAc();
            if (this.gkT != null && this.gkP.getWindow() != null) {
                this.gkP.getWindow().setBackgroundDrawable(this.gkT);
            }
        }
        this.gld = findViewById(d.g.push_dialog_bottom_layout);
        this.gld.setOnClickListener(this);
        this.gle = (TextView) findViewById(d.g.comment_num);
        this.gkV = (TbImageView) findViewById(d.g.push_dialog_title_img);
        this.gkV.setDefaultBgResource(d.f.icon);
        this.gkV.setAutoChangeStyle(false);
        this.gkW = (TextView) findViewById(d.g.push_dialog_title_text);
        this.gkY = (TextView) findViewById(d.g.push_dialog_content_title);
        this.gla = (ClickableHeaderImageView) findViewById(d.g.push_dialog_user_head);
        this.gla.setBorderSurroundContent(true);
        this.gla.setIsRound(true);
        this.gla.setEnabled(false);
        this.gla.setAutoChangeStyle(false);
        this.gla.setBorderWidth(l.f(this.gkP, d.e.tbds1));
        this.gla.setBorderColor(ContextCompat.getColor(this.gkP, d.C0140d.black_alpha15));
        this.glf = new com.baidu.tbadk.widget.richText.a();
        this.eJt = (TbRichTextView) findViewById(d.g.push_dialog_content);
        this.eJt.setTextColor(ContextCompat.getColor(this.gkP, d.C0140d.cp_cont_j));
        this.glf.fT(l.f(this.gkP, d.e.tbds38));
        this.glf.setTextSize(l.f(this.gkP, d.e.tbds42));
        this.glf.fX(l.f(this.gkP, d.e.tbds23));
        this.glf.setLineSpacing(l.f(TbadkCoreApplication.getInst().getContext(), d.e.tbds7), 1.0f);
        this.glf.P(l.f(TbadkCoreApplication.getInst().getContext(), d.e.tbds48), l.f(TbadkCoreApplication.getInst().getContext(), d.e.tbds48));
        this.eJt.setLayoutStrategy(this.glf);
        this.gkZ = (PushDialogVideoView) findViewById(d.g.push_dialog_video);
        this.gkZ.setPageContext(this.gkP.getPageContext());
        this.tvUserName = (TextView) findViewById(d.g.push_dialog_user_name);
        this.glb = (TextView) findViewById(d.g.push_dialog_user_god_info);
        this.glc = (CommonUserLikeButton) findViewById(d.g.push_dialog_user_like_btn);
        this.glc.setAfterOnClickListener(this);
        this.gkX = (ImageView) findViewById(d.g.dialog_close_btn);
        this.gkX.setOnClickListener(this);
    }

    public void onResume() {
        if (this.gkZ != null) {
            this.gkZ.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.gkP.findViewById(i);
    }

    public void bmo() {
        if (this.gkZ != null) {
            this.gkZ.setNetworkChange();
            if (j.jG() && this.gkZ.bjU() && this.gkR != null && this.gkR.getFileSize() > 0 && this.gkR.getDuration() > 0) {
                float fileSize = this.gkR.getFileSize() * (1.0f - ((this.gkZ.getCurrentPosition() * 1.0f) / (this.gkR.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.gkP.getPageContext().getPageActivity(), String.format(this.gkP.getPageContext().getString(d.j.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int f;
        int f2;
        if (aVar != null) {
            this.gkV.startLoad(aVar.bmq(), 17, false);
            this.gkW.setText(aVar.bmp());
            if (aVar.bms() != null) {
                this.gla.setData(aVar.bms());
                this.tvUserName.setText(aVar.bms().getName_show());
                if (aVar.bms().getGodUserData() != null && (!StringUtils.isNull(aVar.bms().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.bms().getGodUserData().getIntro()))) {
                    this.glb.setText(aVar.bms().getGodUserData().getForumName() + "吧 " + aVar.bms().getGodIntro());
                    this.glb.setVisibility(0);
                } else {
                    this.glb.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.bms().getUserId())) {
                    this.glc.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.gkP.getPageContext(), this.glc).a(aVar.bms());
                    this.glc.onChangeSkinType(0);
                    this.glc.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b bmr = aVar.bmr();
                if (bmr == null) {
                    this.gkP.bmj().bzZ();
                    this.gkP.finish();
                    return;
                }
                boolean z = bmr.bmt() == null || w.z(bmr.bmt().Nx());
                if (StringUtils.isNull(bmr.getTitle()) && z) {
                    this.gkP.bmj().bzZ();
                    this.gkP.finish();
                    return;
                }
                if (bmr.bmt() != null) {
                    Iterator<TbRichTextData> it = bmr.bmt().Nx().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.gkR = next.NH();
                        }
                        if (this.gkR != null) {
                            break;
                        }
                    }
                }
                this.tid = bmr.getTid();
                if (this.gkR == null) {
                    this.gkZ.setVisibility(8);
                    this.eJt.setVisibility(0);
                    boolean z2 = j.jH() || j.jF();
                    this.glf.cl(z2);
                    if (z2) {
                        f = (l.ah(TbadkCoreApplication.getInst()) - (l.f(this.gkP, d.e.tbds22) * 2)) - (l.f(this.gkP, d.e.tbds44) * 2);
                        f2 = (int) (f * 1.618f);
                    } else {
                        f = l.f(this.gkP, d.e.tbds360);
                        f2 = l.f(this.gkP, d.e.tbds202);
                    }
                    this.glf.cm(z2);
                    this.glf.fP(f);
                    this.glf.fQ(f2);
                    this.eJt.setText(bmr.bmt());
                } else {
                    this.eJt.setVisibility(8);
                    this.gkZ.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gkZ.getLayoutParams();
                    layoutParams.width = l.ah(this.gkP) - l.f(this.gkP, d.e.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.gkZ.setLayoutParams(layoutParams);
                    this.gkZ.setTbRichTextVideoInfo(this.gkR);
                    this.gkZ.stopPlay();
                    this.gkZ.setIsNeedRecoveryVideoPlayer(true);
                    this.gkZ.setThumbnail(this.gkR.getThumbUrl());
                    this.gkZ.setVideoUrl(this.gkR.getVideoUrl(), String.valueOf(this.tid));
                    this.gkZ.aFd();
                    n nVar = new n(this.gkP.getActivity());
                    nVar.sc("2");
                    y yVar = new y();
                    yVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    yVar.aWq = String.valueOf(this.tid);
                    yVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    nVar.setVideoStatsData(yVar);
                    this.gkZ.setQuickVideoViewBusiness(nVar);
                }
                if (StringUtils.isNull(bmr.getTitle())) {
                    this.gkY.setVisibility(8);
                } else {
                    this.gkY.setText(bmr.getTitle());
                    this.gkY.setVisibility(0);
                }
                this.gle.setText(String.format(Locale.CHINA, this.gkP.getString(d.j.bottom_comment), Integer.valueOf(bmr.getPostNum())));
                if (!this.gkP.bmj().isScreenOn()) {
                    this.gkP.bmj().bAa();
                    return;
                }
                return;
            }
            this.gkP.bmj().bzZ();
            this.gkP.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gkX) {
            TiebaStatic.log(new an("c13198").af("tid", this.gkP.getTid()));
            e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.gkP != null && c.this.gkP.bmj() != null) {
                        c.this.gkP.bmj().bzZ();
                    }
                }
            }, 30L);
            this.gkP.finish();
        } else if (view == this.gld) {
            TiebaStatic.log(new an("c13199").r("obj_locate", 4).af("tid", this.gkP.getTid()));
            if (this.tid == 0) {
                this.gkP.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.gkP).createNormalCfg(this.tid + "", null, null)));
            this.gkP.bmj().bAa();
            this.gkP.finish();
        } else if (view == this.glc) {
            TiebaStatic.log(new an("c13199").r("obj_locate", 3).af("tid", this.gkP.getTid()));
        }
    }

    public void onPause() {
        if (this.gkZ != null) {
            this.gkZ.onPause();
        }
    }

    public void onDestroy() {
        if (this.gkZ != null) {
            this.gkZ.onDestroy();
        }
    }
}
