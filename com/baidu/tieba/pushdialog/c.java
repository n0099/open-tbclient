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
import com.baidu.adp.lib.f.e;
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
import com.baidu.tbadk.widget.richText.i;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.y;
import com.tencent.connect.common.Constants;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Locale;
/* loaded from: classes8.dex */
public class c implements View.OnClickListener {
    private TextView ahO;
    private EditorScrollView drx;
    private TbRichTextView hQO;
    private final PushDialogActivity jCa;
    private i jCe;
    private Drawable jCg;
    private View jCh;
    private TbImageView jCi;
    private TextView jCj;
    private ImageView jCk;
    private TextView jCl;
    private PushDialogVideoView jCm;
    private ClickableHeaderImageView jCn;
    private TextView jCo;
    private CommonUserLikeButton jCp;
    private View jCq;
    private TextView jCr;
    private com.baidu.tbadk.widget.richText.a jCs;
    private boolean jCt = false;
    private View mRootView;
    private long tid;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.jCa = pushDialogActivity;
        this.jCa.setContentView(i);
        this.mRootView = findViewById(R.id.root_view);
        this.jCh = findViewById(R.id.dialog_wrapper_view);
        this.drx = (EditorScrollView) findViewById(R.id.push_dialog_content_layout);
        this.drx.setOverScrollMode(2);
        this.drx.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.jCt) {
                    TiebaStatic.log(new an("c13199").X("obj_locate", 1).cy("tid", c.this.jCa.getTid()));
                    c.this.jCt = true;
                }
            }
        });
        if (this.jCh.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jCh.getLayoutParams();
            int equipmentHeight = l.getEquipmentHeight(this.jCa);
            layoutParams.height = equipmentHeight / 2;
            layoutParams.topMargin = (int) (equipmentHeight * 0.22f);
            this.jCh.postInvalidate();
        }
        if (l.isFlymeOsAbove35()) {
            this.jCg = com.baidu.tieba.v.b.cPb();
            if (this.jCg != null && this.jCa.getWindow() != null) {
                this.jCa.getWindow().setBackgroundDrawable(this.jCg);
            }
        }
        this.jCq = findViewById(R.id.push_dialog_bottom_layout);
        this.jCq.setOnClickListener(this);
        this.jCr = (TextView) findViewById(R.id.comment_num);
        this.jCi = (TbImageView) findViewById(R.id.push_dialog_title_img);
        this.jCi.setDefaultBgResource(R.drawable.tb_launcher_icon);
        this.jCi.setAutoChangeStyle(false);
        this.jCj = (TextView) findViewById(R.id.push_dialog_title_text);
        this.jCl = (TextView) findViewById(R.id.push_dialog_content_title);
        this.jCn = (ClickableHeaderImageView) findViewById(R.id.push_dialog_user_head);
        this.jCn.setBorderSurroundContent(true);
        this.jCn.setIsRound(true);
        this.jCn.setEnabled(false);
        this.jCn.setAutoChangeStyle(false);
        this.jCn.setBorderWidth(l.getDimens(this.jCa, R.dimen.tbds1));
        this.jCn.setBorderColor(ContextCompat.getColor(this.jCa, R.color.black_alpha15));
        this.jCs = new com.baidu.tbadk.widget.richText.a();
        this.hQO = (TbRichTextView) findViewById(R.id.push_dialog_content);
        this.hQO.setTextColor(ContextCompat.getColor(this.jCa, R.color.cp_cont_j));
        this.jCs.nn(l.getDimens(this.jCa, R.dimen.tbds38));
        this.jCs.setTextSize(l.getDimens(this.jCa, R.dimen.tbds42));
        this.jCs.nr(l.getDimens(this.jCa, R.dimen.tbds23));
        this.jCs.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.jCs.aS(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.hQO.setLayoutStrategy(this.jCs);
        this.jCm = (PushDialogVideoView) findViewById(R.id.push_dialog_video);
        this.jCm.setPageContext(this.jCa.getPageContext());
        this.ahO = (TextView) findViewById(R.id.push_dialog_user_name);
        this.jCo = (TextView) findViewById(R.id.push_dialog_user_god_info);
        this.jCp = (CommonUserLikeButton) findViewById(R.id.push_dialog_user_like_btn);
        this.jCp.setAfterOnClickListener(this);
        this.jCk = (ImageView) findViewById(R.id.dialog_close_btn);
        this.jCk.setOnClickListener(this);
    }

    public void onResume() {
        if (this.jCm != null) {
            this.jCm.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.jCa.findViewById(i);
    }

    public void cBp() {
        if (this.jCm != null) {
            this.jCm.setNetworkChange();
            if (j.isMobileNet() && this.jCm.le() && this.jCe != null && this.jCe.getFileSize() > 0 && this.jCe.getDuration() > 0) {
                float fileSize = this.jCe.getFileSize() * (1.0f - ((this.jCm.getCurrentPosition() * 1.0f) / (this.jCe.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.jCa.getPageContext().getPageActivity(), String.format(this.jCa.getPageContext().getString(R.string.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int dimens;
        int dimens2;
        if (aVar != null) {
            this.jCi.startLoad(aVar.cBr(), 17, false);
            this.jCj.setText(aVar.cBq());
            if (aVar.cBt() != null) {
                this.jCn.setData(aVar.cBt());
                this.ahO.setText(aVar.cBt().getName_show());
                if (aVar.cBt().getGodUserData() != null && (!StringUtils.isNull(aVar.cBt().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.cBt().getGodUserData().getIntro()))) {
                    this.jCo.setText(aVar.cBt().getGodUserData().getForumName() + "吧 " + aVar.cBt().getGodIntro());
                    this.jCo.setVisibility(0);
                } else {
                    this.jCo.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.cBt().getUserId())) {
                    this.jCp.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.jCa.getPageContext(), this.jCp).a(aVar.cBt());
                    this.jCp.onChangeSkinType(0);
                    this.jCp.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b cBs = aVar.cBs();
                if (cBs == null) {
                    this.jCa.cBf().cOX();
                    this.jCa.finish();
                    return;
                }
                boolean z = cBs.cBu() == null || v.isEmpty(cBs.cBu().aTS());
                if (StringUtils.isNull(cBs.getTitle()) && z) {
                    this.jCa.cBf().cOX();
                    this.jCa.finish();
                    return;
                }
                if (cBs.cBu() != null) {
                    Iterator<TbRichTextData> it = cBs.cBu().aTS().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.jCe = next.aUc();
                        }
                        if (this.jCe != null) {
                            break;
                        }
                    }
                }
                this.tid = cBs.getTid();
                if (this.jCe == null) {
                    this.jCm.setVisibility(8);
                    this.hQO.setVisibility(0);
                    boolean z2 = j.is4GNet() || j.isWifiNet();
                    this.jCs.hk(z2);
                    if (z2) {
                        dimens = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(this.jCa, R.dimen.tbds22) * 2)) - (l.getDimens(this.jCa, R.dimen.tbds44) * 2);
                        dimens2 = (int) (dimens * 1.618f);
                    } else {
                        dimens = l.getDimens(this.jCa, R.dimen.tbds360);
                        dimens2 = l.getDimens(this.jCa, R.dimen.tbds202);
                    }
                    this.jCs.hl(z2);
                    this.jCs.ni(dimens);
                    this.jCs.nj(dimens2);
                    this.hQO.setText(cBs.cBu());
                } else {
                    this.hQO.setVisibility(8);
                    this.jCm.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jCm.getLayoutParams();
                    layoutParams.width = l.getEquipmentWidth(this.jCa) - l.getDimens(this.jCa, R.dimen.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.jCm.setLayoutParams(layoutParams);
                    this.jCm.setTbRichTextVideoInfo(this.jCe);
                    this.jCm.stopPlay();
                    this.jCm.setIsNeedRecoveryVideoPlayer(true);
                    this.jCm.setThumbnail(this.jCe.getThumbUrl());
                    this.jCm.setVideoUrl(this.jCe.getVideoUrl(), String.valueOf(this.tid));
                    this.jCm.bPO();
                    n nVar = new n(this.jCa.getActivity());
                    nVar.Hb("2");
                    y yVar = new y();
                    yVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    yVar.Pj = String.valueOf(this.tid);
                    yVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    nVar.setVideoStatsData(yVar);
                    this.jCm.setQuickVideoViewBusiness(nVar);
                }
                if (StringUtils.isNull(cBs.getTitle())) {
                    this.jCl.setVisibility(8);
                } else {
                    this.jCl.setText(cBs.getTitle());
                    this.jCl.setVisibility(0);
                }
                this.jCr.setText(String.format(Locale.CHINA, this.jCa.getString(R.string.bottom_comment), Integer.valueOf(cBs.getPostNum())));
                if (!this.jCa.cBf().cPa()) {
                    this.jCa.cBf().cOY();
                    return;
                }
                return;
            }
            this.jCa.cBf().cOX();
            this.jCa.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jCk) {
            TiebaStatic.log(new an("c13198").cy("tid", this.jCa.getTid()));
            e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.jCa != null && c.this.jCa.cBf() != null) {
                        c.this.jCa.cBf().cOX();
                    }
                }
            }, 100L);
            this.jCa.finish();
        } else if (view == this.jCq) {
            TiebaStatic.log(new an("c13199").X("obj_locate", 4).cy("tid", this.jCa.getTid()));
            if (this.tid == 0) {
                this.jCa.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.jCa).createNormalCfg(this.tid + "", null, null)));
            this.jCa.cBf().cOY();
            this.jCa.finish();
        } else if (view == this.jCp) {
            TiebaStatic.log(new an("c13199").X("obj_locate", 3).cy("tid", this.jCa.getTid()));
        }
    }

    public void onPause() {
        if (this.jCm != null) {
            this.jCm.onPause();
        }
    }

    public void onDestroy() {
        if (this.jCm != null) {
            this.jCm.onDestroy();
        }
    }
}
