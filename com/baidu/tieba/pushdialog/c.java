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
    private TextView Xm;
    private EditorScrollView czv;
    private TbRichTextView gXk;
    private final PushDialogActivity iDg;
    private f iDk;
    private Drawable iDm;
    private View iDn;
    private TbImageView iDo;
    private TextView iDp;
    private ImageView iDq;
    private TextView iDr;
    private PushDialogVideoView iDs;
    private ClickableHeaderImageView iDt;
    private TextView iDu;
    private CommonUserLikeButton iDv;
    private View iDw;
    private TextView iDx;
    private com.baidu.tbadk.widget.richText.a iDy;
    private boolean iDz = false;
    private View mRootView;
    private long tid;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.iDg = pushDialogActivity;
        this.iDg.setContentView(i);
        this.mRootView = findViewById(R.id.root_view);
        this.iDn = findViewById(R.id.dialog_wrapper_view);
        this.czv = (EditorScrollView) findViewById(R.id.push_dialog_content_layout);
        this.czv.setOverScrollMode(2);
        this.czv.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.iDz) {
                    TiebaStatic.log(new an("c13199").O("obj_locate", 1).bS("tid", c.this.iDg.getTid()));
                    c.this.iDz = true;
                }
            }
        });
        if (this.iDn.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iDn.getLayoutParams();
            int equipmentHeight = l.getEquipmentHeight(this.iDg);
            layoutParams.height = equipmentHeight / 2;
            layoutParams.topMargin = (int) (equipmentHeight * 0.22f);
            this.iDn.postInvalidate();
        }
        if (l.isFlymeOsAbove35()) {
            this.iDm = com.baidu.tieba.t.b.csv();
            if (this.iDm != null && this.iDg.getWindow() != null) {
                this.iDg.getWindow().setBackgroundDrawable(this.iDm);
            }
        }
        this.iDw = findViewById(R.id.push_dialog_bottom_layout);
        this.iDw.setOnClickListener(this);
        this.iDx = (TextView) findViewById(R.id.comment_num);
        this.iDo = (TbImageView) findViewById(R.id.push_dialog_title_img);
        this.iDo.setDefaultBgResource(R.drawable.icon);
        this.iDo.setAutoChangeStyle(false);
        this.iDp = (TextView) findViewById(R.id.push_dialog_title_text);
        this.iDr = (TextView) findViewById(R.id.push_dialog_content_title);
        this.iDt = (ClickableHeaderImageView) findViewById(R.id.push_dialog_user_head);
        this.iDt.setBorderSurroundContent(true);
        this.iDt.setIsRound(true);
        this.iDt.setEnabled(false);
        this.iDt.setAutoChangeStyle(false);
        this.iDt.setBorderWidth(l.getDimens(this.iDg, R.dimen.tbds1));
        this.iDt.setBorderColor(ContextCompat.getColor(this.iDg, R.color.black_alpha15));
        this.iDy = new com.baidu.tbadk.widget.richText.a();
        this.gXk = (TbRichTextView) findViewById(R.id.push_dialog_content);
        this.gXk.setTextColor(ContextCompat.getColor(this.iDg, R.color.cp_cont_j));
        this.iDy.kH(l.getDimens(this.iDg, R.dimen.tbds38));
        this.iDy.setTextSize(l.getDimens(this.iDg, R.dimen.tbds42));
        this.iDy.kL(l.getDimens(this.iDg, R.dimen.tbds23));
        this.iDy.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.iDy.au(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.gXk.setLayoutStrategy(this.iDy);
        this.iDs = (PushDialogVideoView) findViewById(R.id.push_dialog_video);
        this.iDs.setPageContext(this.iDg.getPageContext());
        this.Xm = (TextView) findViewById(R.id.push_dialog_user_name);
        this.iDu = (TextView) findViewById(R.id.push_dialog_user_god_info);
        this.iDv = (CommonUserLikeButton) findViewById(R.id.push_dialog_user_like_btn);
        this.iDv.setAfterOnClickListener(this);
        this.iDq = (ImageView) findViewById(R.id.dialog_close_btn);
        this.iDq.setOnClickListener(this);
    }

    public void onResume() {
        if (this.iDs != null) {
            this.iDs.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.iDg.findViewById(i);
    }

    public void ceD() {
        if (this.iDs != null) {
            this.iDs.setNetworkChange();
            if (j.isMobileNet() && this.iDs.kx() && this.iDk != null && this.iDk.getFileSize() > 0 && this.iDk.getDuration() > 0) {
                float fileSize = this.iDk.getFileSize() * (1.0f - ((this.iDs.getCurrentPosition() * 1.0f) / (this.iDk.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.iDg.getPageContext().getPageActivity(), String.format(this.iDg.getPageContext().getString(R.string.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int dimens;
        int dimens2;
        if (aVar != null) {
            this.iDo.startLoad(aVar.ceF(), 17, false);
            this.iDp.setText(aVar.ceE());
            if (aVar.ceH() != null) {
                this.iDt.setData(aVar.ceH());
                this.Xm.setText(aVar.ceH().getName_show());
                if (aVar.ceH().getGodUserData() != null && (!StringUtils.isNull(aVar.ceH().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.ceH().getGodUserData().getIntro()))) {
                    this.iDu.setText(aVar.ceH().getGodUserData().getForumName() + "吧 " + aVar.ceH().getGodIntro());
                    this.iDu.setVisibility(0);
                } else {
                    this.iDu.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.ceH().getUserId())) {
                    this.iDv.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.iDg.getPageContext(), this.iDv).a(aVar.ceH());
                    this.iDv.onChangeSkinType(0);
                    this.iDv.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b ceG = aVar.ceG();
                if (ceG == null) {
                    this.iDg.ceu().csr();
                    this.iDg.finish();
                    return;
                }
                boolean z = ceG.ceI() == null || v.isEmpty(ceG.ceI().azf());
                if (StringUtils.isNull(ceG.getTitle()) && z) {
                    this.iDg.ceu().csr();
                    this.iDg.finish();
                    return;
                }
                if (ceG.ceI() != null) {
                    Iterator<TbRichTextData> it = ceG.ceI().azf().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.iDk = next.azr();
                        }
                        if (this.iDk != null) {
                            break;
                        }
                    }
                }
                this.tid = ceG.getTid();
                if (this.iDk == null) {
                    this.iDs.setVisibility(8);
                    this.gXk.setVisibility(0);
                    boolean z2 = j.is4GNet() || j.isWifiNet();
                    this.iDy.fL(z2);
                    if (z2) {
                        dimens = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(this.iDg, R.dimen.tbds22) * 2)) - (l.getDimens(this.iDg, R.dimen.tbds44) * 2);
                        dimens2 = (int) (dimens * 1.618f);
                    } else {
                        dimens = l.getDimens(this.iDg, R.dimen.tbds360);
                        dimens2 = l.getDimens(this.iDg, R.dimen.tbds202);
                    }
                    this.iDy.fM(z2);
                    this.iDy.kC(dimens);
                    this.iDy.kD(dimens2);
                    this.gXk.setText(ceG.ceI());
                } else {
                    this.gXk.setVisibility(8);
                    this.iDs.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iDs.getLayoutParams();
                    layoutParams.width = l.getEquipmentWidth(this.iDg) - l.getDimens(this.iDg, R.dimen.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.iDs.setLayoutParams(layoutParams);
                    this.iDs.setTbRichTextVideoInfo(this.iDk);
                    this.iDs.stopPlay();
                    this.iDs.setIsNeedRecoveryVideoPlayer(true);
                    this.iDs.setThumbnail(this.iDk.getThumbUrl());
                    this.iDs.setVideoUrl(this.iDk.getVideoUrl(), String.valueOf(this.tid));
                    this.iDs.bvK();
                    n nVar = new n(this.iDg.getActivity());
                    nVar.BQ("2");
                    z zVar = new z();
                    zVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    zVar.cma = String.valueOf(this.tid);
                    zVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    nVar.setVideoStatsData(zVar);
                    this.iDs.setQuickVideoViewBusiness(nVar);
                }
                if (StringUtils.isNull(ceG.getTitle())) {
                    this.iDr.setVisibility(8);
                } else {
                    this.iDr.setText(ceG.getTitle());
                    this.iDr.setVisibility(0);
                }
                this.iDx.setText(String.format(Locale.CHINA, this.iDg.getString(R.string.bottom_comment), Integer.valueOf(ceG.getPostNum())));
                if (!this.iDg.ceu().csu()) {
                    this.iDg.ceu().css();
                    return;
                }
                return;
            }
            this.iDg.ceu().csr();
            this.iDg.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iDq) {
            TiebaStatic.log(new an("c13198").bS("tid", this.iDg.getTid()));
            e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.iDg != null && c.this.iDg.ceu() != null) {
                        c.this.iDg.ceu().csr();
                    }
                }
            }, 100L);
            this.iDg.finish();
        } else if (view == this.iDw) {
            TiebaStatic.log(new an("c13199").O("obj_locate", 4).bS("tid", this.iDg.getTid()));
            if (this.tid == 0) {
                this.iDg.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.iDg).createNormalCfg(this.tid + "", null, null)));
            this.iDg.ceu().css();
            this.iDg.finish();
        } else if (view == this.iDv) {
            TiebaStatic.log(new an("c13199").O("obj_locate", 3).bS("tid", this.iDg.getTid()));
        }
    }

    public void onPause() {
        if (this.iDs != null) {
            this.iDs.onPause();
        }
    }

    public void onDestroy() {
        if (this.iDs != null) {
            this.iDs.onDestroy();
        }
    }
}
