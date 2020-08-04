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
    private TbRichTextView jrQ;
    private final PushDialogActivity lhZ;
    private j lid;
    private Drawable lif;
    private View lig;
    private TbImageView lih;
    private TextView lii;
    private ImageView lij;
    private TextView lik;
    private PushDialogVideoView lil;
    private ClickableHeaderImageView lim;
    private TextView lin;
    private CommonUserLikeButton lio;
    private View lip;
    private TextView liq;
    private boolean lir = false;
    private View mRootView;
    private long tid;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.lhZ = pushDialogActivity;
        this.lhZ.setContentView(i);
        this.mRootView = findViewById(R.id.root_view);
        this.lig = findViewById(R.id.dialog_wrapper_view);
        this.evq = (EditorScrollView) findViewById(R.id.push_dialog_content_layout);
        this.evq.setOverScrollMode(2);
        this.evq.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.lir) {
                    TiebaStatic.log(new ap("c13199").ah("obj_locate", 1).dn("tid", c.this.lhZ.getTid()));
                    c.this.lir = true;
                }
            }
        });
        if (this.lig.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lig.getLayoutParams();
            int equipmentHeight = l.getEquipmentHeight(this.lhZ);
            layoutParams.height = equipmentHeight / 2;
            layoutParams.topMargin = (int) (equipmentHeight * 0.22f);
            this.lig.postInvalidate();
        }
        if (l.isFlymeOsAbove35()) {
            this.lif = com.baidu.tieba.v.b.dpq();
            if (this.lif != null && this.lhZ.getWindow() != null) {
                this.lhZ.getWindow().setBackgroundDrawable(this.lif);
            }
        }
        this.lip = findViewById(R.id.push_dialog_bottom_layout);
        this.lip.setOnClickListener(this);
        this.liq = (TextView) findViewById(R.id.comment_num);
        this.lih = (TbImageView) findViewById(R.id.push_dialog_title_img);
        this.lih.setDefaultBgResource(R.drawable.tb_launcher_icon);
        this.lih.setAutoChangeStyle(false);
        this.lii = (TextView) findViewById(R.id.push_dialog_title_text);
        this.lik = (TextView) findViewById(R.id.push_dialog_content_title);
        this.lim = (ClickableHeaderImageView) findViewById(R.id.push_dialog_user_head);
        this.lim.setBorderSurroundContent(true);
        this.lim.setIsRound(true);
        this.lim.setEnabled(false);
        this.lim.setAutoChangeStyle(false);
        this.lim.setBorderWidth(l.getDimens(this.lhZ, R.dimen.tbds1));
        this.lim.setBorderColor(ContextCompat.getColor(this.lhZ, R.color.black_alpha15));
        this.dKv = new com.baidu.tbadk.widget.richText.a();
        this.jrQ = (TbRichTextView) findViewById(R.id.push_dialog_content);
        this.jrQ.setTextColor(ContextCompat.getColor(this.lhZ, R.color.cp_cont_j));
        this.dKv.oW(l.getDimens(this.lhZ, R.dimen.tbds38));
        this.dKv.setTextSize(l.getDimens(this.lhZ, R.dimen.tbds42));
        this.dKv.pa(l.getDimens(this.lhZ, R.dimen.tbds23));
        this.dKv.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.dKv.bi(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.jrQ.setLayoutStrategy(this.dKv);
        this.lil = (PushDialogVideoView) findViewById(R.id.push_dialog_video);
        this.lil.setPageContext(this.lhZ.getPageContext());
        this.aJJ = (TextView) findViewById(R.id.push_dialog_user_name);
        this.lin = (TextView) findViewById(R.id.push_dialog_user_god_info);
        this.lio = (CommonUserLikeButton) findViewById(R.id.push_dialog_user_like_btn);
        this.lio.setAfterOnClickListener(this);
        this.lij = (ImageView) findViewById(R.id.dialog_close_btn);
        this.lij.setOnClickListener(this);
    }

    public void onResume() {
        if (this.lil != null) {
            this.lil.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.lhZ.findViewById(i);
    }

    public void daV() {
        if (this.lil != null) {
            this.lil.setNetworkChange();
            if (com.baidu.adp.lib.util.j.isMobileNet() && this.lil.qg() && this.lid != null && this.lid.getFileSize() > 0 && this.lid.getDuration() > 0) {
                float fileSize = this.lid.getFileSize() * (1.0f - ((this.lil.getCurrentPosition() * 1.0f) / (this.lid.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.lhZ.getPageContext().getPageActivity(), String.format(this.lhZ.getPageContext().getString(R.string.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int dimens;
        int dimens2;
        if (aVar != null) {
            this.lih.startLoad(aVar.daX(), 17, false);
            this.lii.setText(aVar.daW());
            if (aVar.daZ() != null) {
                this.lim.setData(aVar.daZ());
                this.aJJ.setText(aVar.daZ().getName_show());
                if (aVar.daZ().getGodUserData() != null && (!StringUtils.isNull(aVar.daZ().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.daZ().getGodUserData().getIntro()))) {
                    this.lin.setText(aVar.daZ().getGodUserData().getForumName() + "吧 " + aVar.daZ().getGodIntro());
                    this.lin.setVisibility(0);
                } else {
                    this.lin.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.daZ().getUserId())) {
                    this.lio.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.lhZ.getPageContext(), this.lio).a(aVar.daZ());
                    this.lio.onChangeSkinType(0);
                    this.lio.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b daY = aVar.daY();
                if (daY == null) {
                    this.lhZ.daL().dpm();
                    this.lhZ.finish();
                    return;
                }
                boolean z = daY.dba() == null || x.isEmpty(daY.dba().boJ());
                if (StringUtils.isNull(daY.getTitle()) && z) {
                    this.lhZ.daL().dpm();
                    this.lhZ.finish();
                    return;
                }
                if (daY.dba() != null) {
                    Iterator<TbRichTextData> it = daY.dba().boJ().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.lid = next.boT();
                        }
                        if (this.lid != null) {
                            break;
                        }
                    }
                }
                this.tid = daY.getTid();
                if (this.lid == null) {
                    this.lil.setVisibility(8);
                    this.jrQ.setVisibility(0);
                    boolean z2 = com.baidu.adp.lib.util.j.is4GNet() || com.baidu.adp.lib.util.j.isWifiNet();
                    this.dKv.jx(z2);
                    if (z2) {
                        dimens = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(this.lhZ, R.dimen.tbds22) * 2)) - (l.getDimens(this.lhZ, R.dimen.tbds44) * 2);
                        dimens2 = (int) (dimens * 1.618f);
                    } else {
                        dimens = l.getDimens(this.lhZ, R.dimen.tbds360);
                        dimens2 = l.getDimens(this.lhZ, R.dimen.tbds202);
                    }
                    this.dKv.jy(z2);
                    this.dKv.oR(dimens);
                    this.dKv.oS(dimens2);
                    this.jrQ.setText(daY.dba());
                } else {
                    this.jrQ.setVisibility(8);
                    this.lil.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lil.getLayoutParams();
                    layoutParams.width = l.getEquipmentWidth(this.lhZ) - l.getDimens(this.lhZ, R.dimen.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.lil.setLayoutParams(layoutParams);
                    this.lil.setTbRichTextVideoInfo(this.lid);
                    this.lil.stopPlay();
                    this.lil.setThumbnail(this.lid.getThumbUrl());
                    this.lil.setVideoUrl(this.lid.getVideoUrl(), String.valueOf(this.tid));
                    this.lil.coB();
                    o oVar = new o();
                    oVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    oVar.ajJ = String.valueOf(this.tid);
                    oVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    this.lil.setVideoViewBusiness(oVar);
                }
                if (StringUtils.isNull(daY.getTitle())) {
                    this.lik.setVisibility(8);
                } else {
                    this.lik.setText(daY.getTitle());
                    this.lik.setVisibility(0);
                }
                this.liq.setText(String.format(Locale.CHINA, this.lhZ.getString(R.string.bottom_comment), Integer.valueOf(daY.getPostNum())));
                if (!this.lhZ.daL().dpp()) {
                    this.lhZ.daL().dpn();
                    return;
                }
                return;
            }
            this.lhZ.daL().dpm();
            this.lhZ.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.lij) {
            TiebaStatic.log(new ap("c13198").dn("tid", this.lhZ.getTid()));
            e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.lhZ != null && c.this.lhZ.daL() != null) {
                        c.this.lhZ.daL().dpm();
                    }
                }
            }, 100L);
            this.lhZ.finish();
        } else if (view == this.lip) {
            TiebaStatic.log(new ap("c13199").ah("obj_locate", 4).dn("tid", this.lhZ.getTid()));
            if (this.tid == 0) {
                this.lhZ.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.lhZ).createNormalCfg(this.tid + "", null, null)));
            this.lhZ.daL().dpn();
            this.lhZ.finish();
        } else if (view == this.lio) {
            TiebaStatic.log(new ap("c13199").ah("obj_locate", 3).dn("tid", this.lhZ.getTid()));
        }
    }

    public void onPause() {
        if (this.lil != null) {
            this.lil.onPause();
        }
    }

    public void onDestroy() {
        if (this.lil != null) {
            this.lil.onDestroy();
        }
    }
}
