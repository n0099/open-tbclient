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
    private EditorScrollView drK;
    private TbRichTextView hRa;
    private TextView jCA;
    private CommonUserLikeButton jCB;
    private View jCC;
    private TextView jCD;
    private com.baidu.tbadk.widget.richText.a jCE;
    private boolean jCF = false;
    private final PushDialogActivity jCm;
    private i jCq;
    private Drawable jCs;
    private View jCt;
    private TbImageView jCu;
    private TextView jCv;
    private ImageView jCw;
    private TextView jCx;
    private PushDialogVideoView jCy;
    private ClickableHeaderImageView jCz;
    private View mRootView;
    private long tid;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.jCm = pushDialogActivity;
        this.jCm.setContentView(i);
        this.mRootView = findViewById(R.id.root_view);
        this.jCt = findViewById(R.id.dialog_wrapper_view);
        this.drK = (EditorScrollView) findViewById(R.id.push_dialog_content_layout);
        this.drK.setOverScrollMode(2);
        this.drK.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.jCF) {
                    TiebaStatic.log(new an("c13199").X("obj_locate", 1).cy("tid", c.this.jCm.getTid()));
                    c.this.jCF = true;
                }
            }
        });
        if (this.jCt.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jCt.getLayoutParams();
            int equipmentHeight = l.getEquipmentHeight(this.jCm);
            layoutParams.height = equipmentHeight / 2;
            layoutParams.topMargin = (int) (equipmentHeight * 0.22f);
            this.jCt.postInvalidate();
        }
        if (l.isFlymeOsAbove35()) {
            this.jCs = com.baidu.tieba.v.b.cPc();
            if (this.jCs != null && this.jCm.getWindow() != null) {
                this.jCm.getWindow().setBackgroundDrawable(this.jCs);
            }
        }
        this.jCC = findViewById(R.id.push_dialog_bottom_layout);
        this.jCC.setOnClickListener(this);
        this.jCD = (TextView) findViewById(R.id.comment_num);
        this.jCu = (TbImageView) findViewById(R.id.push_dialog_title_img);
        this.jCu.setDefaultBgResource(R.drawable.tb_launcher_icon);
        this.jCu.setAutoChangeStyle(false);
        this.jCv = (TextView) findViewById(R.id.push_dialog_title_text);
        this.jCx = (TextView) findViewById(R.id.push_dialog_content_title);
        this.jCz = (ClickableHeaderImageView) findViewById(R.id.push_dialog_user_head);
        this.jCz.setBorderSurroundContent(true);
        this.jCz.setIsRound(true);
        this.jCz.setEnabled(false);
        this.jCz.setAutoChangeStyle(false);
        this.jCz.setBorderWidth(l.getDimens(this.jCm, R.dimen.tbds1));
        this.jCz.setBorderColor(ContextCompat.getColor(this.jCm, R.color.black_alpha15));
        this.jCE = new com.baidu.tbadk.widget.richText.a();
        this.hRa = (TbRichTextView) findViewById(R.id.push_dialog_content);
        this.hRa.setTextColor(ContextCompat.getColor(this.jCm, R.color.cp_cont_j));
        this.jCE.nn(l.getDimens(this.jCm, R.dimen.tbds38));
        this.jCE.setTextSize(l.getDimens(this.jCm, R.dimen.tbds42));
        this.jCE.nr(l.getDimens(this.jCm, R.dimen.tbds23));
        this.jCE.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.jCE.aS(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.hRa.setLayoutStrategy(this.jCE);
        this.jCy = (PushDialogVideoView) findViewById(R.id.push_dialog_video);
        this.jCy.setPageContext(this.jCm.getPageContext());
        this.ahO = (TextView) findViewById(R.id.push_dialog_user_name);
        this.jCA = (TextView) findViewById(R.id.push_dialog_user_god_info);
        this.jCB = (CommonUserLikeButton) findViewById(R.id.push_dialog_user_like_btn);
        this.jCB.setAfterOnClickListener(this);
        this.jCw = (ImageView) findViewById(R.id.dialog_close_btn);
        this.jCw.setOnClickListener(this);
    }

    public void onResume() {
        if (this.jCy != null) {
            this.jCy.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.jCm.findViewById(i);
    }

    public void cBq() {
        if (this.jCy != null) {
            this.jCy.setNetworkChange();
            if (j.isMobileNet() && this.jCy.le() && this.jCq != null && this.jCq.getFileSize() > 0 && this.jCq.getDuration() > 0) {
                float fileSize = this.jCq.getFileSize() * (1.0f - ((this.jCy.getCurrentPosition() * 1.0f) / (this.jCq.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.jCm.getPageContext().getPageActivity(), String.format(this.jCm.getPageContext().getString(R.string.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int dimens;
        int dimens2;
        if (aVar != null) {
            this.jCu.startLoad(aVar.cBs(), 17, false);
            this.jCv.setText(aVar.cBr());
            if (aVar.cBu() != null) {
                this.jCz.setData(aVar.cBu());
                this.ahO.setText(aVar.cBu().getName_show());
                if (aVar.cBu().getGodUserData() != null && (!StringUtils.isNull(aVar.cBu().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.cBu().getGodUserData().getIntro()))) {
                    this.jCA.setText(aVar.cBu().getGodUserData().getForumName() + "吧 " + aVar.cBu().getGodIntro());
                    this.jCA.setVisibility(0);
                } else {
                    this.jCA.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.cBu().getUserId())) {
                    this.jCB.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.jCm.getPageContext(), this.jCB).a(aVar.cBu());
                    this.jCB.onChangeSkinType(0);
                    this.jCB.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b cBt = aVar.cBt();
                if (cBt == null) {
                    this.jCm.cBg().cOY();
                    this.jCm.finish();
                    return;
                }
                boolean z = cBt.cBv() == null || v.isEmpty(cBt.cBv().aTT());
                if (StringUtils.isNull(cBt.getTitle()) && z) {
                    this.jCm.cBg().cOY();
                    this.jCm.finish();
                    return;
                }
                if (cBt.cBv() != null) {
                    Iterator<TbRichTextData> it = cBt.cBv().aTT().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.jCq = next.aUd();
                        }
                        if (this.jCq != null) {
                            break;
                        }
                    }
                }
                this.tid = cBt.getTid();
                if (this.jCq == null) {
                    this.jCy.setVisibility(8);
                    this.hRa.setVisibility(0);
                    boolean z2 = j.is4GNet() || j.isWifiNet();
                    this.jCE.hk(z2);
                    if (z2) {
                        dimens = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(this.jCm, R.dimen.tbds22) * 2)) - (l.getDimens(this.jCm, R.dimen.tbds44) * 2);
                        dimens2 = (int) (dimens * 1.618f);
                    } else {
                        dimens = l.getDimens(this.jCm, R.dimen.tbds360);
                        dimens2 = l.getDimens(this.jCm, R.dimen.tbds202);
                    }
                    this.jCE.hl(z2);
                    this.jCE.ni(dimens);
                    this.jCE.nj(dimens2);
                    this.hRa.setText(cBt.cBv());
                } else {
                    this.hRa.setVisibility(8);
                    this.jCy.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jCy.getLayoutParams();
                    layoutParams.width = l.getEquipmentWidth(this.jCm) - l.getDimens(this.jCm, R.dimen.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.jCy.setLayoutParams(layoutParams);
                    this.jCy.setTbRichTextVideoInfo(this.jCq);
                    this.jCy.stopPlay();
                    this.jCy.setIsNeedRecoveryVideoPlayer(true);
                    this.jCy.setThumbnail(this.jCq.getThumbUrl());
                    this.jCy.setVideoUrl(this.jCq.getVideoUrl(), String.valueOf(this.tid));
                    this.jCy.bPP();
                    n nVar = new n(this.jCm.getActivity());
                    nVar.Hc("2");
                    y yVar = new y();
                    yVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    yVar.Pj = String.valueOf(this.tid);
                    yVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    nVar.setVideoStatsData(yVar);
                    this.jCy.setQuickVideoViewBusiness(nVar);
                }
                if (StringUtils.isNull(cBt.getTitle())) {
                    this.jCx.setVisibility(8);
                } else {
                    this.jCx.setText(cBt.getTitle());
                    this.jCx.setVisibility(0);
                }
                this.jCD.setText(String.format(Locale.CHINA, this.jCm.getString(R.string.bottom_comment), Integer.valueOf(cBt.getPostNum())));
                if (!this.jCm.cBg().cPb()) {
                    this.jCm.cBg().cOZ();
                    return;
                }
                return;
            }
            this.jCm.cBg().cOY();
            this.jCm.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jCw) {
            TiebaStatic.log(new an("c13198").cy("tid", this.jCm.getTid()));
            e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.jCm != null && c.this.jCm.cBg() != null) {
                        c.this.jCm.cBg().cOY();
                    }
                }
            }, 100L);
            this.jCm.finish();
        } else if (view == this.jCC) {
            TiebaStatic.log(new an("c13199").X("obj_locate", 4).cy("tid", this.jCm.getTid()));
            if (this.tid == 0) {
                this.jCm.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.jCm).createNormalCfg(this.tid + "", null, null)));
            this.jCm.cBg().cOZ();
            this.jCm.finish();
        } else if (view == this.jCB) {
            TiebaStatic.log(new an("c13199").X("obj_locate", 3).cy("tid", this.jCm.getTid()));
        }
    }

    public void onPause() {
        if (this.jCy != null) {
            this.jCy.onPause();
        }
    }

    public void onDestroy() {
        if (this.jCy != null) {
            this.jCy.onDestroy();
        }
    }
}
