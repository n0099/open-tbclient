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
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.j;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import com.baidu.tieba.play.o;
import com.tencent.connect.common.Constants;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Locale;
/* loaded from: classes21.dex */
public class c implements View.OnClickListener {
    private TextView aWW;
    private com.baidu.tbadk.widget.richText.a ewk;
    private EditorScrollView fiv;
    private View iNn;
    private TbRichTextView kwP;
    private View mRootView;
    private final PushDialogActivity mpg;
    private j mpk;
    private Drawable mpm;
    private View mpn;
    private TbImageView mpo;
    private TextView mpp;
    private ImageView mpq;
    private TextView mpr;
    private PushDialogVideoView mps;
    private ClickableHeaderImageView mpt;
    private TextView mpu;
    private CommonUserLikeButton mpv;
    private TextView mpw;
    private boolean mpx = false;
    private long tid;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.mpg = pushDialogActivity;
        this.mpg.setContentView(i);
        this.mRootView = findViewById(R.id.root_view);
        this.mpn = findViewById(R.id.dialog_wrapper_view);
        this.fiv = (EditorScrollView) findViewById(R.id.push_dialog_content_layout);
        this.fiv.setOverScrollMode(2);
        this.fiv.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.mpx) {
                    TiebaStatic.log(new aq("c13199").al("obj_locate", 1).dR("tid", c.this.mpg.getTid()));
                    c.this.mpx = true;
                }
            }
        });
        if (this.mpn.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mpn.getLayoutParams();
            int equipmentHeight = l.getEquipmentHeight(this.mpg);
            layoutParams.height = equipmentHeight / 2;
            layoutParams.topMargin = (int) (equipmentHeight * 0.22f);
            this.mpn.postInvalidate();
        }
        if (l.isFlymeOsAbove35()) {
            this.mpm = com.baidu.tieba.v.b.dOk();
            if (this.mpm != null && this.mpg.getWindow() != null) {
                this.mpg.getWindow().setBackgroundDrawable(this.mpm);
            }
        }
        this.iNn = findViewById(R.id.push_dialog_bottom_layout);
        this.iNn.setOnClickListener(this);
        this.mpw = (TextView) findViewById(R.id.comment_num);
        this.mpo = (TbImageView) findViewById(R.id.push_dialog_title_img);
        this.mpo.setDefaultBgResource(R.drawable.tb_launcher_icon);
        this.mpo.setAutoChangeStyle(false);
        this.mpp = (TextView) findViewById(R.id.push_dialog_title_text);
        this.mpr = (TextView) findViewById(R.id.push_dialog_content_title);
        this.mpt = (ClickableHeaderImageView) findViewById(R.id.push_dialog_user_head);
        this.mpt.setBorderSurroundContent(true);
        this.mpt.setIsRound(true);
        this.mpt.setEnabled(false);
        this.mpt.setAutoChangeStyle(false);
        this.mpt.setBorderWidth(l.getDimens(this.mpg, R.dimen.tbds1));
        this.mpt.setBorderColor(ContextCompat.getColor(this.mpg, R.color.black_alpha15));
        this.ewk = new com.baidu.tbadk.widget.richText.a();
        this.kwP = (TbRichTextView) findViewById(R.id.push_dialog_content);
        this.kwP.setTextColor(ContextCompat.getColor(this.mpg, R.color.cp_cont_j));
        this.ewk.ss(l.getDimens(this.mpg, R.dimen.tbds38));
        this.ewk.setTextSize(l.getDimens(this.mpg, R.dimen.tbds42));
        this.ewk.sw(l.getDimens(this.mpg, R.dimen.tbds23));
        this.ewk.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.ewk.br(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.kwP.setLayoutStrategy(this.ewk);
        this.mps = (PushDialogVideoView) findViewById(R.id.push_dialog_video);
        this.mps.setPageContext(this.mpg.getPageContext());
        this.aWW = (TextView) findViewById(R.id.push_dialog_user_name);
        this.mpu = (TextView) findViewById(R.id.push_dialog_user_god_info);
        this.mpv = (CommonUserLikeButton) findViewById(R.id.push_dialog_user_like_btn);
        this.mpv.setAfterOnClickListener(this);
        this.mpq = (ImageView) findViewById(R.id.dialog_close_btn);
        this.mpq.setOnClickListener(this);
    }

    public void onResume() {
        if (this.mps != null) {
            this.mps.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.mpg.findViewById(i);
    }

    public void dzd() {
        if (this.mps != null) {
            this.mps.setNetworkChange();
            if (com.baidu.adp.lib.util.j.isMobileNet() && this.mps.rK() && this.mpk != null && this.mpk.getFileSize() > 0 && this.mpk.getDuration() > 0) {
                float fileSize = this.mpk.getFileSize() * (1.0f - ((this.mps.getCurrentPosition() * 1.0f) / (this.mpk.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.mpg.getPageContext().getPageActivity(), String.format(this.mpg.getPageContext().getString(R.string.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int dimens;
        int dimens2;
        if (aVar != null) {
            this.mpo.startLoad(aVar.dzf(), 17, false);
            this.mpp.setText(aVar.dze());
            if (aVar.dzh() != null) {
                this.mpt.setData(aVar.dzh());
                this.aWW.setText(aVar.dzh().getName_show());
                if (aVar.dzh().getGodUserData() != null && (!StringUtils.isNull(aVar.dzh().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.dzh().getGodUserData().getIntro()))) {
                    this.mpu.setText(aVar.dzh().getGodUserData().getForumName() + "吧 " + aVar.dzh().getGodIntro());
                    this.mpu.setVisibility(0);
                } else {
                    this.mpu.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.dzh().getUserId())) {
                    this.mpv.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.mpg.getPageContext(), this.mpv).a(aVar.dzh());
                    this.mpv.onChangeSkinType(0);
                    this.mpv.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b dzg = aVar.dzg();
                if (dzg == null) {
                    this.mpg.dyT().dOg();
                    this.mpg.finish();
                    return;
                }
                boolean z = dzg.dzi() == null || y.isEmpty(dzg.dzi().bFI());
                if (StringUtils.isNull(dzg.getTitle()) && z) {
                    this.mpg.dyT().dOg();
                    this.mpg.finish();
                    return;
                }
                if (dzg.dzi() != null) {
                    Iterator<TbRichTextData> it = dzg.dzi().bFI().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.mpk = next.bFS();
                        }
                        if (this.mpk != null) {
                            break;
                        }
                    }
                }
                this.tid = dzg.getTid();
                if (this.mpk == null) {
                    this.mps.setVisibility(8);
                    this.kwP.setVisibility(0);
                    boolean z2 = com.baidu.adp.lib.util.j.is4GNet() || com.baidu.adp.lib.util.j.isWifiNet();
                    this.ewk.kS(z2);
                    if (z2) {
                        dimens = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(this.mpg, R.dimen.tbds22) * 2)) - (l.getDimens(this.mpg, R.dimen.tbds44) * 2);
                        dimens2 = (int) (dimens * 1.618f);
                    } else {
                        dimens = l.getDimens(this.mpg, R.dimen.tbds360);
                        dimens2 = l.getDimens(this.mpg, R.dimen.tbds202);
                    }
                    this.ewk.kT(z2);
                    this.ewk.sn(dimens);
                    this.ewk.so(dimens2);
                    this.kwP.setText(dzg.dzi());
                } else {
                    this.kwP.setVisibility(8);
                    this.mps.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mps.getLayoutParams();
                    layoutParams.width = l.getEquipmentWidth(this.mpg) - l.getDimens(this.mpg, R.dimen.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.mps.setLayoutParams(layoutParams);
                    this.mps.setTbRichTextVideoInfo(this.mpk);
                    this.mps.stopPlay();
                    this.mps.setThumbnail(this.mpk.getThumbUrl());
                    this.mps.setVideoUrl(this.mpk.getVideoUrl(), String.valueOf(this.tid));
                    this.mps.cMt();
                    o oVar = new o();
                    oVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    oVar.alT = String.valueOf(this.tid);
                    oVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    this.mps.setVideoViewBusiness(oVar);
                }
                if (StringUtils.isNull(dzg.getTitle())) {
                    this.mpr.setVisibility(8);
                } else {
                    this.mpr.setText(dzg.getTitle());
                    this.mpr.setVisibility(0);
                }
                this.mpw.setText(String.format(Locale.CHINA, this.mpg.getString(R.string.bottom_comment), Integer.valueOf(dzg.getPostNum())));
                if (!this.mpg.dyT().dOj()) {
                    this.mpg.dyT().dOh();
                    return;
                }
                return;
            }
            this.mpg.dyT().dOg();
            this.mpg.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mpq) {
            TiebaStatic.log(new aq("c13198").dR("tid", this.mpg.getTid()));
            e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.mpg != null && c.this.mpg.dyT() != null) {
                        c.this.mpg.dyT().dOg();
                    }
                }
            }, 100L);
            this.mpg.finish();
        } else if (view == this.iNn) {
            TiebaStatic.log(new aq("c13199").al("obj_locate", 4).dR("tid", this.mpg.getTid()));
            if (this.tid == 0) {
                this.mpg.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mpg).createNormalCfg(this.tid + "", null, null)));
            this.mpg.dyT().dOh();
            this.mpg.finish();
        } else if (view == this.mpv) {
            TiebaStatic.log(new aq("c13199").al("obj_locate", 3).dR("tid", this.mpg.getTid()));
        }
    }

    public void onPause() {
        if (this.mps != null) {
            this.mps.onPause();
        }
    }

    public void onDestroy() {
        if (this.mps != null) {
            this.mps.onDestroy();
        }
    }
}
