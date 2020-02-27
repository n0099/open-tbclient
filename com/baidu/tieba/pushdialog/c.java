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
    private EditorScrollView drw;
    private TbRichTextView hQM;
    private final PushDialogActivity jBY;
    private i jCc;
    private Drawable jCe;
    private View jCf;
    private TbImageView jCg;
    private TextView jCh;
    private ImageView jCi;
    private TextView jCj;
    private PushDialogVideoView jCk;
    private ClickableHeaderImageView jCl;
    private TextView jCm;
    private CommonUserLikeButton jCn;
    private View jCo;
    private TextView jCp;
    private com.baidu.tbadk.widget.richText.a jCq;
    private boolean jCr = false;
    private View mRootView;
    private long tid;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.jBY = pushDialogActivity;
        this.jBY.setContentView(i);
        this.mRootView = findViewById(R.id.root_view);
        this.jCf = findViewById(R.id.dialog_wrapper_view);
        this.drw = (EditorScrollView) findViewById(R.id.push_dialog_content_layout);
        this.drw.setOverScrollMode(2);
        this.drw.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.jCr) {
                    TiebaStatic.log(new an("c13199").X("obj_locate", 1).cy("tid", c.this.jBY.getTid()));
                    c.this.jCr = true;
                }
            }
        });
        if (this.jCf.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jCf.getLayoutParams();
            int equipmentHeight = l.getEquipmentHeight(this.jBY);
            layoutParams.height = equipmentHeight / 2;
            layoutParams.topMargin = (int) (equipmentHeight * 0.22f);
            this.jCf.postInvalidate();
        }
        if (l.isFlymeOsAbove35()) {
            this.jCe = com.baidu.tieba.v.b.cOZ();
            if (this.jCe != null && this.jBY.getWindow() != null) {
                this.jBY.getWindow().setBackgroundDrawable(this.jCe);
            }
        }
        this.jCo = findViewById(R.id.push_dialog_bottom_layout);
        this.jCo.setOnClickListener(this);
        this.jCp = (TextView) findViewById(R.id.comment_num);
        this.jCg = (TbImageView) findViewById(R.id.push_dialog_title_img);
        this.jCg.setDefaultBgResource(R.drawable.tb_launcher_icon);
        this.jCg.setAutoChangeStyle(false);
        this.jCh = (TextView) findViewById(R.id.push_dialog_title_text);
        this.jCj = (TextView) findViewById(R.id.push_dialog_content_title);
        this.jCl = (ClickableHeaderImageView) findViewById(R.id.push_dialog_user_head);
        this.jCl.setBorderSurroundContent(true);
        this.jCl.setIsRound(true);
        this.jCl.setEnabled(false);
        this.jCl.setAutoChangeStyle(false);
        this.jCl.setBorderWidth(l.getDimens(this.jBY, R.dimen.tbds1));
        this.jCl.setBorderColor(ContextCompat.getColor(this.jBY, R.color.black_alpha15));
        this.jCq = new com.baidu.tbadk.widget.richText.a();
        this.hQM = (TbRichTextView) findViewById(R.id.push_dialog_content);
        this.hQM.setTextColor(ContextCompat.getColor(this.jBY, R.color.cp_cont_j));
        this.jCq.nn(l.getDimens(this.jBY, R.dimen.tbds38));
        this.jCq.setTextSize(l.getDimens(this.jBY, R.dimen.tbds42));
        this.jCq.nr(l.getDimens(this.jBY, R.dimen.tbds23));
        this.jCq.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.jCq.aS(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.hQM.setLayoutStrategy(this.jCq);
        this.jCk = (PushDialogVideoView) findViewById(R.id.push_dialog_video);
        this.jCk.setPageContext(this.jBY.getPageContext());
        this.ahO = (TextView) findViewById(R.id.push_dialog_user_name);
        this.jCm = (TextView) findViewById(R.id.push_dialog_user_god_info);
        this.jCn = (CommonUserLikeButton) findViewById(R.id.push_dialog_user_like_btn);
        this.jCn.setAfterOnClickListener(this);
        this.jCi = (ImageView) findViewById(R.id.dialog_close_btn);
        this.jCi.setOnClickListener(this);
    }

    public void onResume() {
        if (this.jCk != null) {
            this.jCk.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.jBY.findViewById(i);
    }

    public void cBn() {
        if (this.jCk != null) {
            this.jCk.setNetworkChange();
            if (j.isMobileNet() && this.jCk.le() && this.jCc != null && this.jCc.getFileSize() > 0 && this.jCc.getDuration() > 0) {
                float fileSize = this.jCc.getFileSize() * (1.0f - ((this.jCk.getCurrentPosition() * 1.0f) / (this.jCc.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.jBY.getPageContext().getPageActivity(), String.format(this.jBY.getPageContext().getString(R.string.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int dimens;
        int dimens2;
        if (aVar != null) {
            this.jCg.startLoad(aVar.cBp(), 17, false);
            this.jCh.setText(aVar.cBo());
            if (aVar.cBr() != null) {
                this.jCl.setData(aVar.cBr());
                this.ahO.setText(aVar.cBr().getName_show());
                if (aVar.cBr().getGodUserData() != null && (!StringUtils.isNull(aVar.cBr().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.cBr().getGodUserData().getIntro()))) {
                    this.jCm.setText(aVar.cBr().getGodUserData().getForumName() + "吧 " + aVar.cBr().getGodIntro());
                    this.jCm.setVisibility(0);
                } else {
                    this.jCm.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.cBr().getUserId())) {
                    this.jCn.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.jBY.getPageContext(), this.jCn).a(aVar.cBr());
                    this.jCn.onChangeSkinType(0);
                    this.jCn.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b cBq = aVar.cBq();
                if (cBq == null) {
                    this.jBY.cBd().cOV();
                    this.jBY.finish();
                    return;
                }
                boolean z = cBq.cBs() == null || v.isEmpty(cBq.cBs().aTQ());
                if (StringUtils.isNull(cBq.getTitle()) && z) {
                    this.jBY.cBd().cOV();
                    this.jBY.finish();
                    return;
                }
                if (cBq.cBs() != null) {
                    Iterator<TbRichTextData> it = cBq.cBs().aTQ().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.jCc = next.aUa();
                        }
                        if (this.jCc != null) {
                            break;
                        }
                    }
                }
                this.tid = cBq.getTid();
                if (this.jCc == null) {
                    this.jCk.setVisibility(8);
                    this.hQM.setVisibility(0);
                    boolean z2 = j.is4GNet() || j.isWifiNet();
                    this.jCq.hk(z2);
                    if (z2) {
                        dimens = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(this.jBY, R.dimen.tbds22) * 2)) - (l.getDimens(this.jBY, R.dimen.tbds44) * 2);
                        dimens2 = (int) (dimens * 1.618f);
                    } else {
                        dimens = l.getDimens(this.jBY, R.dimen.tbds360);
                        dimens2 = l.getDimens(this.jBY, R.dimen.tbds202);
                    }
                    this.jCq.hl(z2);
                    this.jCq.ni(dimens);
                    this.jCq.nj(dimens2);
                    this.hQM.setText(cBq.cBs());
                } else {
                    this.hQM.setVisibility(8);
                    this.jCk.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jCk.getLayoutParams();
                    layoutParams.width = l.getEquipmentWidth(this.jBY) - l.getDimens(this.jBY, R.dimen.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.jCk.setLayoutParams(layoutParams);
                    this.jCk.setTbRichTextVideoInfo(this.jCc);
                    this.jCk.stopPlay();
                    this.jCk.setIsNeedRecoveryVideoPlayer(true);
                    this.jCk.setThumbnail(this.jCc.getThumbUrl());
                    this.jCk.setVideoUrl(this.jCc.getVideoUrl(), String.valueOf(this.tid));
                    this.jCk.bPM();
                    n nVar = new n(this.jBY.getActivity());
                    nVar.Hb("2");
                    y yVar = new y();
                    yVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    yVar.Pj = String.valueOf(this.tid);
                    yVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    nVar.setVideoStatsData(yVar);
                    this.jCk.setQuickVideoViewBusiness(nVar);
                }
                if (StringUtils.isNull(cBq.getTitle())) {
                    this.jCj.setVisibility(8);
                } else {
                    this.jCj.setText(cBq.getTitle());
                    this.jCj.setVisibility(0);
                }
                this.jCp.setText(String.format(Locale.CHINA, this.jBY.getString(R.string.bottom_comment), Integer.valueOf(cBq.getPostNum())));
                if (!this.jBY.cBd().cOY()) {
                    this.jBY.cBd().cOW();
                    return;
                }
                return;
            }
            this.jBY.cBd().cOV();
            this.jBY.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jCi) {
            TiebaStatic.log(new an("c13198").cy("tid", this.jBY.getTid()));
            e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.jBY != null && c.this.jBY.cBd() != null) {
                        c.this.jBY.cBd().cOV();
                    }
                }
            }, 100L);
            this.jBY.finish();
        } else if (view == this.jCo) {
            TiebaStatic.log(new an("c13199").X("obj_locate", 4).cy("tid", this.jBY.getTid()));
            if (this.tid == 0) {
                this.jBY.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.jBY).createNormalCfg(this.tid + "", null, null)));
            this.jBY.cBd().cOW();
            this.jBY.finish();
        } else if (view == this.jCn) {
            TiebaStatic.log(new an("c13199").X("obj_locate", 3).cy("tid", this.jBY.getTid()));
        }
    }

    public void onPause() {
        if (this.jCk != null) {
            this.jCk.onPause();
        }
    }

    public void onDestroy() {
        if (this.jCk != null) {
            this.jCk.onDestroy();
        }
    }
}
