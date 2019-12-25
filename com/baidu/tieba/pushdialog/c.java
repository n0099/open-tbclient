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
/* loaded from: classes5.dex */
public class c implements View.OnClickListener {
    private TextView aeX;
    private EditorScrollView dnb;
    private TbRichTextView hLl;
    private final PushDialogActivity jxA;
    private i jxE;
    private Drawable jxG;
    private View jxH;
    private TbImageView jxI;
    private TextView jxJ;
    private ImageView jxK;
    private TextView jxL;
    private PushDialogVideoView jxM;
    private ClickableHeaderImageView jxN;
    private TextView jxO;
    private CommonUserLikeButton jxP;
    private View jxQ;
    private TextView jxR;
    private com.baidu.tbadk.widget.richText.a jxS;
    private boolean jxT = false;
    private View mRootView;
    private long tid;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.jxA = pushDialogActivity;
        this.jxA.setContentView(i);
        this.mRootView = findViewById(R.id.root_view);
        this.jxH = findViewById(R.id.dialog_wrapper_view);
        this.dnb = (EditorScrollView) findViewById(R.id.push_dialog_content_layout);
        this.dnb.setOverScrollMode(2);
        this.dnb.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.jxT) {
                    TiebaStatic.log(new an("c13199").Z("obj_locate", 1).cp("tid", c.this.jxA.getTid()));
                    c.this.jxT = true;
                }
            }
        });
        if (this.jxH.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jxH.getLayoutParams();
            int equipmentHeight = l.getEquipmentHeight(this.jxA);
            layoutParams.height = equipmentHeight / 2;
            layoutParams.topMargin = (int) (equipmentHeight * 0.22f);
            this.jxH.postInvalidate();
        }
        if (l.isFlymeOsAbove35()) {
            this.jxG = com.baidu.tieba.u.b.cMx();
            if (this.jxG != null && this.jxA.getWindow() != null) {
                this.jxA.getWindow().setBackgroundDrawable(this.jxG);
            }
        }
        this.jxQ = findViewById(R.id.push_dialog_bottom_layout);
        this.jxQ.setOnClickListener(this);
        this.jxR = (TextView) findViewById(R.id.comment_num);
        this.jxI = (TbImageView) findViewById(R.id.push_dialog_title_img);
        this.jxI.setDefaultBgResource(R.drawable.tb_launcher_icon);
        this.jxI.setAutoChangeStyle(false);
        this.jxJ = (TextView) findViewById(R.id.push_dialog_title_text);
        this.jxL = (TextView) findViewById(R.id.push_dialog_content_title);
        this.jxN = (ClickableHeaderImageView) findViewById(R.id.push_dialog_user_head);
        this.jxN.setBorderSurroundContent(true);
        this.jxN.setIsRound(true);
        this.jxN.setEnabled(false);
        this.jxN.setAutoChangeStyle(false);
        this.jxN.setBorderWidth(l.getDimens(this.jxA, R.dimen.tbds1));
        this.jxN.setBorderColor(ContextCompat.getColor(this.jxA, R.color.black_alpha15));
        this.jxS = new com.baidu.tbadk.widget.richText.a();
        this.hLl = (TbRichTextView) findViewById(R.id.push_dialog_content);
        this.hLl.setTextColor(ContextCompat.getColor(this.jxA, R.color.cp_cont_j));
        this.jxS.mW(l.getDimens(this.jxA, R.dimen.tbds38));
        this.jxS.setTextSize(l.getDimens(this.jxA, R.dimen.tbds42));
        this.jxS.na(l.getDimens(this.jxA, R.dimen.tbds23));
        this.jxS.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.jxS.aO(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.hLl.setLayoutStrategy(this.jxS);
        this.jxM = (PushDialogVideoView) findViewById(R.id.push_dialog_video);
        this.jxM.setPageContext(this.jxA.getPageContext());
        this.aeX = (TextView) findViewById(R.id.push_dialog_user_name);
        this.jxO = (TextView) findViewById(R.id.push_dialog_user_god_info);
        this.jxP = (CommonUserLikeButton) findViewById(R.id.push_dialog_user_like_btn);
        this.jxP.setAfterOnClickListener(this);
        this.jxK = (ImageView) findViewById(R.id.dialog_close_btn);
        this.jxK.setOnClickListener(this);
    }

    public void onResume() {
        if (this.jxM != null) {
            this.jxM.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.jxA.findViewById(i);
    }

    public void cyJ() {
        if (this.jxM != null) {
            this.jxM.setNetworkChange();
            if (j.isMobileNet() && this.jxM.kO() && this.jxE != null && this.jxE.getFileSize() > 0 && this.jxE.getDuration() > 0) {
                float fileSize = this.jxE.getFileSize() * (1.0f - ((this.jxM.getCurrentPosition() * 1.0f) / (this.jxE.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.jxA.getPageContext().getPageActivity(), String.format(this.jxA.getPageContext().getString(R.string.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int dimens;
        int dimens2;
        if (aVar != null) {
            this.jxI.startLoad(aVar.cyL(), 17, false);
            this.jxJ.setText(aVar.cyK());
            if (aVar.cyN() != null) {
                this.jxN.setData(aVar.cyN());
                this.aeX.setText(aVar.cyN().getName_show());
                if (aVar.cyN().getGodUserData() != null && (!StringUtils.isNull(aVar.cyN().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.cyN().getGodUserData().getIntro()))) {
                    this.jxO.setText(aVar.cyN().getGodUserData().getForumName() + "吧 " + aVar.cyN().getGodIntro());
                    this.jxO.setVisibility(0);
                } else {
                    this.jxO.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.cyN().getUserId())) {
                    this.jxP.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.jxA.getPageContext(), this.jxP).a(aVar.cyN());
                    this.jxP.onChangeSkinType(0);
                    this.jxP.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b cyM = aVar.cyM();
                if (cyM == null) {
                    this.jxA.cyz().cMt();
                    this.jxA.finish();
                    return;
                }
                boolean z = cyM.cyO() == null || v.isEmpty(cyM.cyO().aRf());
                if (StringUtils.isNull(cyM.getTitle()) && z) {
                    this.jxA.cyz().cMt();
                    this.jxA.finish();
                    return;
                }
                if (cyM.cyO() != null) {
                    Iterator<TbRichTextData> it = cyM.cyO().aRf().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.jxE = next.aRp();
                        }
                        if (this.jxE != null) {
                            break;
                        }
                    }
                }
                this.tid = cyM.getTid();
                if (this.jxE == null) {
                    this.jxM.setVisibility(8);
                    this.hLl.setVisibility(0);
                    boolean z2 = j.is4GNet() || j.isWifiNet();
                    this.jxS.gY(z2);
                    if (z2) {
                        dimens = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(this.jxA, R.dimen.tbds22) * 2)) - (l.getDimens(this.jxA, R.dimen.tbds44) * 2);
                        dimens2 = (int) (dimens * 1.618f);
                    } else {
                        dimens = l.getDimens(this.jxA, R.dimen.tbds360);
                        dimens2 = l.getDimens(this.jxA, R.dimen.tbds202);
                    }
                    this.jxS.gZ(z2);
                    this.jxS.mR(dimens);
                    this.jxS.mS(dimens2);
                    this.hLl.setText(cyM.cyO());
                } else {
                    this.hLl.setVisibility(8);
                    this.jxM.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jxM.getLayoutParams();
                    layoutParams.width = l.getEquipmentWidth(this.jxA) - l.getDimens(this.jxA, R.dimen.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.jxM.setLayoutParams(layoutParams);
                    this.jxM.setTbRichTextVideoInfo(this.jxE);
                    this.jxM.stopPlay();
                    this.jxM.setIsNeedRecoveryVideoPlayer(true);
                    this.jxM.setThumbnail(this.jxE.getThumbUrl());
                    this.jxM.setVideoUrl(this.jxE.getVideoUrl(), String.valueOf(this.tid));
                    this.jxM.bNb();
                    n nVar = new n(this.jxA.getActivity());
                    nVar.GD("2");
                    y yVar = new y();
                    yVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    yVar.OC = String.valueOf(this.tid);
                    yVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    nVar.setVideoStatsData(yVar);
                    this.jxM.setQuickVideoViewBusiness(nVar);
                }
                if (StringUtils.isNull(cyM.getTitle())) {
                    this.jxL.setVisibility(8);
                } else {
                    this.jxL.setText(cyM.getTitle());
                    this.jxL.setVisibility(0);
                }
                this.jxR.setText(String.format(Locale.CHINA, this.jxA.getString(R.string.bottom_comment), Integer.valueOf(cyM.getPostNum())));
                if (!this.jxA.cyz().cMw()) {
                    this.jxA.cyz().cMu();
                    return;
                }
                return;
            }
            this.jxA.cyz().cMt();
            this.jxA.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jxK) {
            TiebaStatic.log(new an("c13198").cp("tid", this.jxA.getTid()));
            e.gy().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.jxA != null && c.this.jxA.cyz() != null) {
                        c.this.jxA.cyz().cMt();
                    }
                }
            }, 100L);
            this.jxA.finish();
        } else if (view == this.jxQ) {
            TiebaStatic.log(new an("c13199").Z("obj_locate", 4).cp("tid", this.jxA.getTid()));
            if (this.tid == 0) {
                this.jxA.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.jxA).createNormalCfg(this.tid + "", null, null)));
            this.jxA.cyz().cMu();
            this.jxA.finish();
        } else if (view == this.jxP) {
            TiebaStatic.log(new an("c13199").Z("obj_locate", 3).cp("tid", this.jxA.getTid()));
        }
    }

    public void onPause() {
        if (this.jxM != null) {
            this.jxM.onPause();
        }
    }

    public void onDestroy() {
        if (this.jxM != null) {
            this.jxM.onDestroy();
        }
    }
}
