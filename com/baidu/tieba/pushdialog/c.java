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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
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
    private TextView XE;
    private EditorScrollView cAm;
    private TbRichTextView gYb;
    private final PushDialogActivity iDX;
    private f iEb;
    private Drawable iEd;
    private View iEe;
    private TbImageView iEf;
    private TextView iEg;
    private ImageView iEh;
    private TextView iEi;
    private PushDialogVideoView iEj;
    private ClickableHeaderImageView iEk;
    private TextView iEl;
    private CommonUserLikeButton iEm;
    private View iEn;
    private TextView iEo;
    private com.baidu.tbadk.widget.richText.a iEp;
    private boolean iEq = false;
    private View mRootView;
    private long tid;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.iDX = pushDialogActivity;
        this.iDX.setContentView(i);
        this.mRootView = findViewById(R.id.root_view);
        this.iEe = findViewById(R.id.dialog_wrapper_view);
        this.cAm = (EditorScrollView) findViewById(R.id.push_dialog_content_layout);
        this.cAm.setOverScrollMode(2);
        this.cAm.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.iEq) {
                    TiebaStatic.log(new an("c13199").O("obj_locate", 1).bS("tid", c.this.iDX.getTid()));
                    c.this.iEq = true;
                }
            }
        });
        if (this.iEe.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iEe.getLayoutParams();
            int equipmentHeight = l.getEquipmentHeight(this.iDX);
            layoutParams.height = equipmentHeight / 2;
            layoutParams.topMargin = (int) (equipmentHeight * 0.22f);
            this.iEe.postInvalidate();
        }
        if (l.isFlymeOsAbove35()) {
            this.iEd = com.baidu.tieba.t.b.csx();
            if (this.iEd != null && this.iDX.getWindow() != null) {
                this.iDX.getWindow().setBackgroundDrawable(this.iEd);
            }
        }
        this.iEn = findViewById(R.id.push_dialog_bottom_layout);
        this.iEn.setOnClickListener(this);
        this.iEo = (TextView) findViewById(R.id.comment_num);
        this.iEf = (TbImageView) findViewById(R.id.push_dialog_title_img);
        this.iEf.setDefaultBgResource(R.drawable.icon);
        this.iEf.setAutoChangeStyle(false);
        this.iEg = (TextView) findViewById(R.id.push_dialog_title_text);
        this.iEi = (TextView) findViewById(R.id.push_dialog_content_title);
        this.iEk = (ClickableHeaderImageView) findViewById(R.id.push_dialog_user_head);
        this.iEk.setBorderSurroundContent(true);
        this.iEk.setIsRound(true);
        this.iEk.setEnabled(false);
        this.iEk.setAutoChangeStyle(false);
        this.iEk.setBorderWidth(l.getDimens(this.iDX, R.dimen.tbds1));
        this.iEk.setBorderColor(ContextCompat.getColor(this.iDX, R.color.black_alpha15));
        this.iEp = new com.baidu.tbadk.widget.richText.a();
        this.gYb = (TbRichTextView) findViewById(R.id.push_dialog_content);
        this.gYb.setTextColor(ContextCompat.getColor(this.iDX, R.color.cp_cont_j));
        this.iEp.kI(l.getDimens(this.iDX, R.dimen.tbds38));
        this.iEp.setTextSize(l.getDimens(this.iDX, R.dimen.tbds42));
        this.iEp.kM(l.getDimens(this.iDX, R.dimen.tbds23));
        this.iEp.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.iEp.aw(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.gYb.setLayoutStrategy(this.iEp);
        this.iEj = (PushDialogVideoView) findViewById(R.id.push_dialog_video);
        this.iEj.setPageContext(this.iDX.getPageContext());
        this.XE = (TextView) findViewById(R.id.push_dialog_user_name);
        this.iEl = (TextView) findViewById(R.id.push_dialog_user_god_info);
        this.iEm = (CommonUserLikeButton) findViewById(R.id.push_dialog_user_like_btn);
        this.iEm.setAfterOnClickListener(this);
        this.iEh = (ImageView) findViewById(R.id.dialog_close_btn);
        this.iEh.setOnClickListener(this);
    }

    public void onResume() {
        if (this.iEj != null) {
            this.iEj.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.iDX.findViewById(i);
    }

    public void ceF() {
        if (this.iEj != null) {
            this.iEj.setNetworkChange();
            if (j.isMobileNet() && this.iEj.kx() && this.iEb != null && this.iEb.getFileSize() > 0 && this.iEb.getDuration() > 0) {
                float fileSize = this.iEb.getFileSize() * (1.0f - ((this.iEj.getCurrentPosition() * 1.0f) / (this.iEb.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.iDX.getPageContext().getPageActivity(), String.format(this.iDX.getPageContext().getString(R.string.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int dimens;
        int dimens2;
        if (aVar != null) {
            this.iEf.startLoad(aVar.ceH(), 17, false);
            this.iEg.setText(aVar.ceG());
            if (aVar.ceJ() != null) {
                this.iEk.setData(aVar.ceJ());
                this.XE.setText(aVar.ceJ().getName_show());
                if (aVar.ceJ().getGodUserData() != null && (!StringUtils.isNull(aVar.ceJ().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.ceJ().getGodUserData().getIntro()))) {
                    this.iEl.setText(aVar.ceJ().getGodUserData().getForumName() + "吧 " + aVar.ceJ().getGodIntro());
                    this.iEl.setVisibility(0);
                } else {
                    this.iEl.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.ceJ().getUserId())) {
                    this.iEm.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.iDX.getPageContext(), this.iEm).a(aVar.ceJ());
                    this.iEm.onChangeSkinType(0);
                    this.iEm.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b ceI = aVar.ceI();
                if (ceI == null) {
                    this.iDX.cew().cst();
                    this.iDX.finish();
                    return;
                }
                boolean z = ceI.ceK() == null || v.isEmpty(ceI.ceK().azh());
                if (StringUtils.isNull(ceI.getTitle()) && z) {
                    this.iDX.cew().cst();
                    this.iDX.finish();
                    return;
                }
                if (ceI.ceK() != null) {
                    Iterator<TbRichTextData> it = ceI.ceK().azh().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.iEb = next.azt();
                        }
                        if (this.iEb != null) {
                            break;
                        }
                    }
                }
                this.tid = ceI.getTid();
                if (this.iEb == null) {
                    this.iEj.setVisibility(8);
                    this.gYb.setVisibility(0);
                    boolean z2 = j.is4GNet() || j.isWifiNet();
                    this.iEp.fL(z2);
                    if (z2) {
                        dimens = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(this.iDX, R.dimen.tbds22) * 2)) - (l.getDimens(this.iDX, R.dimen.tbds44) * 2);
                        dimens2 = (int) (dimens * 1.618f);
                    } else {
                        dimens = l.getDimens(this.iDX, R.dimen.tbds360);
                        dimens2 = l.getDimens(this.iDX, R.dimen.tbds202);
                    }
                    this.iEp.fM(z2);
                    this.iEp.kD(dimens);
                    this.iEp.kE(dimens2);
                    this.gYb.setText(ceI.ceK());
                } else {
                    this.gYb.setVisibility(8);
                    this.iEj.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iEj.getLayoutParams();
                    layoutParams.width = l.getEquipmentWidth(this.iDX) - l.getDimens(this.iDX, R.dimen.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.iEj.setLayoutParams(layoutParams);
                    this.iEj.setTbRichTextVideoInfo(this.iEb);
                    this.iEj.stopPlay();
                    this.iEj.setIsNeedRecoveryVideoPlayer(true);
                    this.iEj.setThumbnail(this.iEb.getThumbUrl());
                    this.iEj.setVideoUrl(this.iEb.getVideoUrl(), String.valueOf(this.tid));
                    this.iEj.bvM();
                    n nVar = new n(this.iDX.getActivity());
                    nVar.BQ("2");
                    z zVar = new z();
                    zVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    zVar.cmS = String.valueOf(this.tid);
                    zVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    nVar.setVideoStatsData(zVar);
                    this.iEj.setQuickVideoViewBusiness(nVar);
                }
                if (StringUtils.isNull(ceI.getTitle())) {
                    this.iEi.setVisibility(8);
                } else {
                    this.iEi.setText(ceI.getTitle());
                    this.iEi.setVisibility(0);
                }
                this.iEo.setText(String.format(Locale.CHINA, this.iDX.getString(R.string.bottom_comment), Integer.valueOf(ceI.getPostNum())));
                if (!this.iDX.cew().csw()) {
                    this.iDX.cew().csu();
                    return;
                }
                return;
            }
            this.iDX.cew().cst();
            this.iDX.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iEh) {
            TiebaStatic.log(new an("c13198").bS("tid", this.iDX.getTid()));
            e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.iDX != null && c.this.iDX.cew() != null) {
                        c.this.iDX.cew().cst();
                    }
                }
            }, 100L);
            this.iDX.finish();
        } else if (view == this.iEn) {
            TiebaStatic.log(new an("c13199").O("obj_locate", 4).bS("tid", this.iDX.getTid()));
            if (this.tid == 0) {
                this.iDX.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.iDX).createNormalCfg(this.tid + "", null, null)));
            this.iDX.cew().csu();
            this.iDX.finish();
        } else if (view == this.iEm) {
            TiebaStatic.log(new an("c13199").O("obj_locate", 3).bS("tid", this.iDX.getTid()));
        }
    }

    public void onPause() {
        if (this.iEj != null) {
            this.iEj.onPause();
        }
    }

    public void onDestroy() {
        if (this.iEj != null) {
            this.iEj.onDestroy();
        }
    }
}
