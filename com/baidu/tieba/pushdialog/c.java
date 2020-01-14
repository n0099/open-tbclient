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
/* loaded from: classes6.dex */
public class c implements View.OnClickListener {
    private TextView afG;
    private EditorScrollView dnm;
    private TbRichTextView hOO;
    private boolean jBA = false;
    private final PushDialogActivity jBh;
    private i jBl;
    private Drawable jBn;
    private View jBo;
    private TbImageView jBp;
    private TextView jBq;
    private ImageView jBr;
    private TextView jBs;
    private PushDialogVideoView jBt;
    private ClickableHeaderImageView jBu;
    private TextView jBv;
    private CommonUserLikeButton jBw;
    private View jBx;
    private TextView jBy;
    private com.baidu.tbadk.widget.richText.a jBz;
    private View mRootView;
    private long tid;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.jBh = pushDialogActivity;
        this.jBh.setContentView(i);
        this.mRootView = findViewById(R.id.root_view);
        this.jBo = findViewById(R.id.dialog_wrapper_view);
        this.dnm = (EditorScrollView) findViewById(R.id.push_dialog_content_layout);
        this.dnm.setOverScrollMode(2);
        this.dnm.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.jBA) {
                    TiebaStatic.log(new an("c13199").Z("obj_locate", 1).cp("tid", c.this.jBh.getTid()));
                    c.this.jBA = true;
                }
            }
        });
        if (this.jBo.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jBo.getLayoutParams();
            int equipmentHeight = l.getEquipmentHeight(this.jBh);
            layoutParams.height = equipmentHeight / 2;
            layoutParams.topMargin = (int) (equipmentHeight * 0.22f);
            this.jBo.postInvalidate();
        }
        if (l.isFlymeOsAbove35()) {
            this.jBn = com.baidu.tieba.u.b.cNE();
            if (this.jBn != null && this.jBh.getWindow() != null) {
                this.jBh.getWindow().setBackgroundDrawable(this.jBn);
            }
        }
        this.jBx = findViewById(R.id.push_dialog_bottom_layout);
        this.jBx.setOnClickListener(this);
        this.jBy = (TextView) findViewById(R.id.comment_num);
        this.jBp = (TbImageView) findViewById(R.id.push_dialog_title_img);
        this.jBp.setDefaultBgResource(R.drawable.tb_launcher_icon);
        this.jBp.setAutoChangeStyle(false);
        this.jBq = (TextView) findViewById(R.id.push_dialog_title_text);
        this.jBs = (TextView) findViewById(R.id.push_dialog_content_title);
        this.jBu = (ClickableHeaderImageView) findViewById(R.id.push_dialog_user_head);
        this.jBu.setBorderSurroundContent(true);
        this.jBu.setIsRound(true);
        this.jBu.setEnabled(false);
        this.jBu.setAutoChangeStyle(false);
        this.jBu.setBorderWidth(l.getDimens(this.jBh, R.dimen.tbds1));
        this.jBu.setBorderColor(ContextCompat.getColor(this.jBh, R.color.black_alpha15));
        this.jBz = new com.baidu.tbadk.widget.richText.a();
        this.hOO = (TbRichTextView) findViewById(R.id.push_dialog_content);
        this.hOO.setTextColor(ContextCompat.getColor(this.jBh, R.color.cp_cont_j));
        this.jBz.mW(l.getDimens(this.jBh, R.dimen.tbds38));
        this.jBz.setTextSize(l.getDimens(this.jBh, R.dimen.tbds42));
        this.jBz.na(l.getDimens(this.jBh, R.dimen.tbds23));
        this.jBz.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.jBz.aS(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.hOO.setLayoutStrategy(this.jBz);
        this.jBt = (PushDialogVideoView) findViewById(R.id.push_dialog_video);
        this.jBt.setPageContext(this.jBh.getPageContext());
        this.afG = (TextView) findViewById(R.id.push_dialog_user_name);
        this.jBv = (TextView) findViewById(R.id.push_dialog_user_god_info);
        this.jBw = (CommonUserLikeButton) findViewById(R.id.push_dialog_user_like_btn);
        this.jBw.setAfterOnClickListener(this);
        this.jBr = (ImageView) findViewById(R.id.dialog_close_btn);
        this.jBr.setOnClickListener(this);
    }

    public void onResume() {
        if (this.jBt != null) {
            this.jBt.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.jBh.findViewById(i);
    }

    public void czS() {
        if (this.jBt != null) {
            this.jBt.setNetworkChange();
            if (j.isMobileNet() && this.jBt.kP() && this.jBl != null && this.jBl.getFileSize() > 0 && this.jBl.getDuration() > 0) {
                float fileSize = this.jBl.getFileSize() * (1.0f - ((this.jBt.getCurrentPosition() * 1.0f) / (this.jBl.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.jBh.getPageContext().getPageActivity(), String.format(this.jBh.getPageContext().getString(R.string.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int dimens;
        int dimens2;
        if (aVar != null) {
            this.jBp.startLoad(aVar.czU(), 17, false);
            this.jBq.setText(aVar.czT());
            if (aVar.czW() != null) {
                this.jBu.setData(aVar.czW());
                this.afG.setText(aVar.czW().getName_show());
                if (aVar.czW().getGodUserData() != null && (!StringUtils.isNull(aVar.czW().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.czW().getGodUserData().getIntro()))) {
                    this.jBv.setText(aVar.czW().getGodUserData().getForumName() + "吧 " + aVar.czW().getGodIntro());
                    this.jBv.setVisibility(0);
                } else {
                    this.jBv.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.czW().getUserId())) {
                    this.jBw.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.jBh.getPageContext(), this.jBw).a(aVar.czW());
                    this.jBw.onChangeSkinType(0);
                    this.jBw.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b czV = aVar.czV();
                if (czV == null) {
                    this.jBh.czI().cNA();
                    this.jBh.finish();
                    return;
                }
                boolean z = czV.czX() == null || v.isEmpty(czV.czX().aRz());
                if (StringUtils.isNull(czV.getTitle()) && z) {
                    this.jBh.czI().cNA();
                    this.jBh.finish();
                    return;
                }
                if (czV.czX() != null) {
                    Iterator<TbRichTextData> it = czV.czX().aRz().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.jBl = next.aRJ();
                        }
                        if (this.jBl != null) {
                            break;
                        }
                    }
                }
                this.tid = czV.getTid();
                if (this.jBl == null) {
                    this.jBt.setVisibility(8);
                    this.hOO.setVisibility(0);
                    boolean z2 = j.is4GNet() || j.isWifiNet();
                    this.jBz.hd(z2);
                    if (z2) {
                        dimens = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(this.jBh, R.dimen.tbds22) * 2)) - (l.getDimens(this.jBh, R.dimen.tbds44) * 2);
                        dimens2 = (int) (dimens * 1.618f);
                    } else {
                        dimens = l.getDimens(this.jBh, R.dimen.tbds360);
                        dimens2 = l.getDimens(this.jBh, R.dimen.tbds202);
                    }
                    this.jBz.he(z2);
                    this.jBz.mR(dimens);
                    this.jBz.mS(dimens2);
                    this.hOO.setText(czV.czX());
                } else {
                    this.hOO.setVisibility(8);
                    this.jBt.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jBt.getLayoutParams();
                    layoutParams.width = l.getEquipmentWidth(this.jBh) - l.getDimens(this.jBh, R.dimen.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.jBt.setLayoutParams(layoutParams);
                    this.jBt.setTbRichTextVideoInfo(this.jBl);
                    this.jBt.stopPlay();
                    this.jBt.setIsNeedRecoveryVideoPlayer(true);
                    this.jBt.setThumbnail(this.jBl.getThumbUrl());
                    this.jBt.setVideoUrl(this.jBl.getVideoUrl(), String.valueOf(this.tid));
                    this.jBt.bOk();
                    n nVar = new n(this.jBh.getActivity());
                    nVar.GN("2");
                    y yVar = new y();
                    yVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    yVar.OG = String.valueOf(this.tid);
                    yVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    nVar.setVideoStatsData(yVar);
                    this.jBt.setQuickVideoViewBusiness(nVar);
                }
                if (StringUtils.isNull(czV.getTitle())) {
                    this.jBs.setVisibility(8);
                } else {
                    this.jBs.setText(czV.getTitle());
                    this.jBs.setVisibility(0);
                }
                this.jBy.setText(String.format(Locale.CHINA, this.jBh.getString(R.string.bottom_comment), Integer.valueOf(czV.getPostNum())));
                if (!this.jBh.czI().cND()) {
                    this.jBh.czI().cNB();
                    return;
                }
                return;
            }
            this.jBh.czI().cNA();
            this.jBh.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jBr) {
            TiebaStatic.log(new an("c13198").cp("tid", this.jBh.getTid()));
            e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.jBh != null && c.this.jBh.czI() != null) {
                        c.this.jBh.czI().cNA();
                    }
                }
            }, 100L);
            this.jBh.finish();
        } else if (view == this.jBx) {
            TiebaStatic.log(new an("c13199").Z("obj_locate", 4).cp("tid", this.jBh.getTid()));
            if (this.tid == 0) {
                this.jBh.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.jBh).createNormalCfg(this.tid + "", null, null)));
            this.jBh.czI().cNB();
            this.jBh.finish();
        } else if (view == this.jBw) {
            TiebaStatic.log(new an("c13199").Z("obj_locate", 3).cp("tid", this.jBh.getTid()));
        }
    }

    public void onPause() {
        if (this.jBt != null) {
            this.jBt.onPause();
        }
    }

    public void onDestroy() {
        if (this.jBt != null) {
            this.jBt.onDestroy();
        }
    }
}
