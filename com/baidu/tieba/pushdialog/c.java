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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
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
/* loaded from: classes15.dex */
public class c implements View.OnClickListener {
    private TextView aJJ;
    private com.baidu.tbadk.widget.richText.a dKv;
    private EditorScrollView evq;
    private TbRichTextView jrO;
    private final PushDialogActivity lhX;
    private j lib;
    private Drawable lid;
    private View lie;
    private TbImageView lif;
    private TextView lig;
    private ImageView lih;
    private TextView lii;
    private PushDialogVideoView lij;
    private ClickableHeaderImageView lik;
    private TextView lil;
    private CommonUserLikeButton lim;
    private View lin;
    private TextView lio;
    private boolean lip = false;
    private View mRootView;
    private long tid;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.lhX = pushDialogActivity;
        this.lhX.setContentView(i);
        this.mRootView = findViewById(R.id.root_view);
        this.lie = findViewById(R.id.dialog_wrapper_view);
        this.evq = (EditorScrollView) findViewById(R.id.push_dialog_content_layout);
        this.evq.setOverScrollMode(2);
        this.evq.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.lip) {
                    TiebaStatic.log(new ap("c13199").ah("obj_locate", 1).dn("tid", c.this.lhX.getTid()));
                    c.this.lip = true;
                }
            }
        });
        if (this.lie.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lie.getLayoutParams();
            int equipmentHeight = l.getEquipmentHeight(this.lhX);
            layoutParams.height = equipmentHeight / 2;
            layoutParams.topMargin = (int) (equipmentHeight * 0.22f);
            this.lie.postInvalidate();
        }
        if (l.isFlymeOsAbove35()) {
            this.lid = com.baidu.tieba.v.b.dpp();
            if (this.lid != null && this.lhX.getWindow() != null) {
                this.lhX.getWindow().setBackgroundDrawable(this.lid);
            }
        }
        this.lin = findViewById(R.id.push_dialog_bottom_layout);
        this.lin.setOnClickListener(this);
        this.lio = (TextView) findViewById(R.id.comment_num);
        this.lif = (TbImageView) findViewById(R.id.push_dialog_title_img);
        this.lif.setDefaultBgResource(R.drawable.tb_launcher_icon);
        this.lif.setAutoChangeStyle(false);
        this.lig = (TextView) findViewById(R.id.push_dialog_title_text);
        this.lii = (TextView) findViewById(R.id.push_dialog_content_title);
        this.lik = (ClickableHeaderImageView) findViewById(R.id.push_dialog_user_head);
        this.lik.setBorderSurroundContent(true);
        this.lik.setIsRound(true);
        this.lik.setEnabled(false);
        this.lik.setAutoChangeStyle(false);
        this.lik.setBorderWidth(l.getDimens(this.lhX, R.dimen.tbds1));
        this.lik.setBorderColor(ContextCompat.getColor(this.lhX, R.color.black_alpha15));
        this.dKv = new com.baidu.tbadk.widget.richText.a();
        this.jrO = (TbRichTextView) findViewById(R.id.push_dialog_content);
        this.jrO.setTextColor(ContextCompat.getColor(this.lhX, R.color.cp_cont_j));
        this.dKv.oW(l.getDimens(this.lhX, R.dimen.tbds38));
        this.dKv.setTextSize(l.getDimens(this.lhX, R.dimen.tbds42));
        this.dKv.pa(l.getDimens(this.lhX, R.dimen.tbds23));
        this.dKv.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.dKv.bi(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.jrO.setLayoutStrategy(this.dKv);
        this.lij = (PushDialogVideoView) findViewById(R.id.push_dialog_video);
        this.lij.setPageContext(this.lhX.getPageContext());
        this.aJJ = (TextView) findViewById(R.id.push_dialog_user_name);
        this.lil = (TextView) findViewById(R.id.push_dialog_user_god_info);
        this.lim = (CommonUserLikeButton) findViewById(R.id.push_dialog_user_like_btn);
        this.lim.setAfterOnClickListener(this);
        this.lih = (ImageView) findViewById(R.id.dialog_close_btn);
        this.lih.setOnClickListener(this);
    }

    public void onResume() {
        if (this.lij != null) {
            this.lij.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.lhX.findViewById(i);
    }

    public void daV() {
        if (this.lij != null) {
            this.lij.setNetworkChange();
            if (com.baidu.adp.lib.util.j.isMobileNet() && this.lij.qg() && this.lib != null && this.lib.getFileSize() > 0 && this.lib.getDuration() > 0) {
                float fileSize = this.lib.getFileSize() * (1.0f - ((this.lij.getCurrentPosition() * 1.0f) / (this.lib.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.lhX.getPageContext().getPageActivity(), String.format(this.lhX.getPageContext().getString(R.string.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int dimens;
        int dimens2;
        if (aVar != null) {
            this.lif.startLoad(aVar.daX(), 17, false);
            this.lig.setText(aVar.daW());
            if (aVar.daZ() != null) {
                this.lik.setData(aVar.daZ());
                this.aJJ.setText(aVar.daZ().getName_show());
                if (aVar.daZ().getGodUserData() != null && (!StringUtils.isNull(aVar.daZ().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.daZ().getGodUserData().getIntro()))) {
                    this.lil.setText(aVar.daZ().getGodUserData().getForumName() + "吧 " + aVar.daZ().getGodIntro());
                    this.lil.setVisibility(0);
                } else {
                    this.lil.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.daZ().getUserId())) {
                    this.lim.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.lhX.getPageContext(), this.lim).a(aVar.daZ());
                    this.lim.onChangeSkinType(0);
                    this.lim.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b daY = aVar.daY();
                if (daY == null) {
                    this.lhX.daL().dpl();
                    this.lhX.finish();
                    return;
                }
                boolean z = daY.dba() == null || x.isEmpty(daY.dba().boJ());
                if (StringUtils.isNull(daY.getTitle()) && z) {
                    this.lhX.daL().dpl();
                    this.lhX.finish();
                    return;
                }
                if (daY.dba() != null) {
                    Iterator<TbRichTextData> it = daY.dba().boJ().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.lib = next.boT();
                        }
                        if (this.lib != null) {
                            break;
                        }
                    }
                }
                this.tid = daY.getTid();
                if (this.lib == null) {
                    this.lij.setVisibility(8);
                    this.jrO.setVisibility(0);
                    boolean z2 = com.baidu.adp.lib.util.j.is4GNet() || com.baidu.adp.lib.util.j.isWifiNet();
                    this.dKv.jx(z2);
                    if (z2) {
                        dimens = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(this.lhX, R.dimen.tbds22) * 2)) - (l.getDimens(this.lhX, R.dimen.tbds44) * 2);
                        dimens2 = (int) (dimens * 1.618f);
                    } else {
                        dimens = l.getDimens(this.lhX, R.dimen.tbds360);
                        dimens2 = l.getDimens(this.lhX, R.dimen.tbds202);
                    }
                    this.dKv.jy(z2);
                    this.dKv.oR(dimens);
                    this.dKv.oS(dimens2);
                    this.jrO.setText(daY.dba());
                } else {
                    this.jrO.setVisibility(8);
                    this.lij.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lij.getLayoutParams();
                    layoutParams.width = l.getEquipmentWidth(this.lhX) - l.getDimens(this.lhX, R.dimen.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.lij.setLayoutParams(layoutParams);
                    this.lij.setTbRichTextVideoInfo(this.lib);
                    this.lij.stopPlay();
                    this.lij.setThumbnail(this.lib.getThumbUrl());
                    this.lij.setVideoUrl(this.lib.getVideoUrl(), String.valueOf(this.tid));
                    this.lij.coB();
                    o oVar = new o();
                    oVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    oVar.ajJ = String.valueOf(this.tid);
                    oVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    this.lij.setVideoViewBusiness(oVar);
                }
                if (StringUtils.isNull(daY.getTitle())) {
                    this.lii.setVisibility(8);
                } else {
                    this.lii.setText(daY.getTitle());
                    this.lii.setVisibility(0);
                }
                this.lio.setText(String.format(Locale.CHINA, this.lhX.getString(R.string.bottom_comment), Integer.valueOf(daY.getPostNum())));
                if (!this.lhX.daL().dpo()) {
                    this.lhX.daL().dpm();
                    return;
                }
                return;
            }
            this.lhX.daL().dpl();
            this.lhX.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.lih) {
            TiebaStatic.log(new ap("c13198").dn("tid", this.lhX.getTid()));
            e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.lhX != null && c.this.lhX.daL() != null) {
                        c.this.lhX.daL().dpl();
                    }
                }
            }, 100L);
            this.lhX.finish();
        } else if (view == this.lin) {
            TiebaStatic.log(new ap("c13199").ah("obj_locate", 4).dn("tid", this.lhX.getTid()));
            if (this.tid == 0) {
                this.lhX.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.lhX).createNormalCfg(this.tid + "", null, null)));
            this.lhX.daL().dpm();
            this.lhX.finish();
        } else if (view == this.lim) {
            TiebaStatic.log(new ap("c13199").ah("obj_locate", 3).dn("tid", this.lhX.getTid()));
        }
    }

    public void onPause() {
        if (this.lij != null) {
            this.lij.onPause();
        }
    }

    public void onDestroy() {
        if (this.lij != null) {
            this.lij.onDestroy();
        }
    }
}
