package com.baidu.tieba.pushdialog;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.core.content.ContextCompat;
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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.i;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import com.baidu.tieba.play.o;
import com.tencent.connect.common.Constants;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Locale;
/* loaded from: classes8.dex */
public class c implements View.OnClickListener {
    private TextView aYx;
    private com.baidu.tbadk.widget.richText.a eIB;
    private EditorScrollView fwr;
    private View jmg;
    private TbRichTextView juS;
    private i mNA;
    private Drawable mNC;
    private View mND;
    private TbImageView mNE;
    private TextView mNF;
    private ImageView mNG;
    private TextView mNH;
    private PushDialogVideoView mNI;
    private ClickableHeaderImageView mNJ;
    private TextView mNK;
    private CommonUserLikeButton mNL;
    private TextView mNM;
    private boolean mNN = false;
    private final PushDialogActivity mNw;
    private View mRootView;
    private long tid;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.mNw = pushDialogActivity;
        this.mNw.setContentView(i);
        this.mRootView = findViewById(R.id.root_view);
        this.mND = findViewById(R.id.dialog_wrapper_view);
        this.fwr = (EditorScrollView) findViewById(R.id.push_dialog_content_layout);
        this.fwr.setOverScrollMode(2);
        this.fwr.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.mNN) {
                    TiebaStatic.log(new ar("c13199").ap("obj_locate", 1).dR("tid", c.this.mNw.getTid()));
                    c.this.mNN = true;
                }
            }
        });
        if (this.mND.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mND.getLayoutParams();
            int equipmentHeight = l.getEquipmentHeight(this.mNw);
            layoutParams.height = equipmentHeight / 2;
            layoutParams.topMargin = (int) (equipmentHeight * 0.22f);
            this.mND.postInvalidate();
        }
        if (l.isFlymeOsAbove35()) {
            this.mNC = com.baidu.tieba.v.b.dRN();
            if (this.mNC != null && this.mNw.getWindow() != null) {
                this.mNw.getWindow().setBackgroundDrawable(this.mNC);
            }
        }
        this.jmg = findViewById(R.id.push_dialog_bottom_layout);
        this.jmg.setOnClickListener(this);
        this.mNM = (TextView) findViewById(R.id.comment_num);
        this.mNE = (TbImageView) findViewById(R.id.push_dialog_title_img);
        this.mNE.setDefaultBgResource(R.drawable.tb_launcher_icon);
        this.mNE.setAutoChangeStyle(false);
        this.mNF = (TextView) findViewById(R.id.push_dialog_title_text);
        this.mNH = (TextView) findViewById(R.id.push_dialog_content_title);
        this.mNJ = (ClickableHeaderImageView) findViewById(R.id.push_dialog_user_head);
        this.mNJ.setBorderSurroundContent(true);
        this.mNJ.setIsRound(true);
        this.mNJ.setEnabled(false);
        this.mNJ.setAutoChangeStyle(false);
        this.mNJ.setBorderWidth(l.getDimens(this.mNw, R.dimen.tbds1));
        this.mNJ.setBorderColor(ContextCompat.getColor(this.mNw, R.color.black_alpha15));
        this.eIB = new com.baidu.tbadk.widget.richText.a();
        this.juS = (TbRichTextView) findViewById(R.id.push_dialog_content);
        this.juS.setTextColor(ContextCompat.getColor(this.mNw, R.color.CAM_X0107));
        this.eIB.sd(l.getDimens(this.mNw, R.dimen.tbds38));
        this.eIB.setTextSize(l.getDimens(this.mNw, R.dimen.tbds42));
        this.eIB.sh(l.getDimens(this.mNw, R.dimen.tbds23));
        this.eIB.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.eIB.bo(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.juS.setLayoutStrategy(this.eIB);
        this.mNI = (PushDialogVideoView) findViewById(R.id.push_dialog_video);
        this.mNI.setPageContext(this.mNw.getPageContext());
        this.aYx = (TextView) findViewById(R.id.push_dialog_user_name);
        this.mNK = (TextView) findViewById(R.id.push_dialog_user_god_info);
        this.mNL = (CommonUserLikeButton) findViewById(R.id.push_dialog_user_like_btn);
        this.mNL.setAfterOnClickListener(this);
        this.mNG = (ImageView) findViewById(R.id.dialog_close_btn);
        this.mNG.setOnClickListener(this);
    }

    public void onResume() {
        if (this.mNI != null) {
            this.mNI.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.mNw.findViewById(i);
    }

    public void dCd() {
        if (this.mNI != null) {
            this.mNI.setNetworkChange();
            if (j.isMobileNet() && this.mNI.rl() && this.mNA != null && this.mNA.getFileSize() > 0 && this.mNA.getDuration() > 0) {
                float fileSize = this.mNA.getFileSize() * (1.0f - ((this.mNI.getCurrentPosition() * 1.0f) / (this.mNA.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.mNw.getPageContext().getPageActivity(), String.format(this.mNw.getPageContext().getString(R.string.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int dimens;
        int dimens2;
        if (aVar != null) {
            this.mNE.startLoad(aVar.dCf(), 17, false);
            this.mNF.setText(aVar.dCe());
            if (aVar.dCh() != null) {
                this.mNJ.setData(aVar.dCh());
                this.aYx.setText(aVar.dCh().getName_show());
                if (aVar.dCh().getGodUserData() != null && (!StringUtils.isNull(aVar.dCh().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.dCh().getGodUserData().getIntro()))) {
                    this.mNK.setText(aVar.dCh().getGodUserData().getForumName() + "吧 " + aVar.dCh().getGodIntro());
                    this.mNK.setVisibility(0);
                } else {
                    this.mNK.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.dCh().getUserId())) {
                    this.mNL.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.mNw.getPageContext(), this.mNL).a(aVar.dCh());
                    this.mNL.onChangeSkinType(0);
                    this.mNL.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b dCg = aVar.dCg();
                if (dCg == null) {
                    this.mNw.dBT().dRJ();
                    this.mNw.finish();
                    return;
                }
                boolean z = dCg.dCi() == null || y.isEmpty(dCg.dCi().bHz());
                if (StringUtils.isNull(dCg.getTitle()) && z) {
                    this.mNw.dBT().dRJ();
                    this.mNw.finish();
                    return;
                }
                if (dCg.dCi() != null) {
                    Iterator<TbRichTextData> it = dCg.dCi().bHz().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.mNA = next.bHJ();
                        }
                        if (this.mNA != null) {
                            break;
                        }
                    }
                }
                this.tid = dCg.getTid();
                if (this.mNA == null) {
                    this.mNI.setVisibility(8);
                    this.juS.setVisibility(0);
                    boolean z2 = j.is4GNet() || j.isWifiNet();
                    this.eIB.lJ(z2);
                    if (z2) {
                        dimens = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(this.mNw, R.dimen.tbds22) * 2)) - (l.getDimens(this.mNw, R.dimen.tbds44) * 2);
                        dimens2 = (int) (dimens * 1.618f);
                    } else {
                        dimens = l.getDimens(this.mNw, R.dimen.tbds360);
                        dimens2 = l.getDimens(this.mNw, R.dimen.tbds202);
                    }
                    this.eIB.lK(z2);
                    this.eIB.rY(dimens);
                    this.eIB.rZ(dimens2);
                    this.juS.setText(dCg.dCi());
                } else {
                    this.juS.setVisibility(8);
                    this.mNI.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mNI.getLayoutParams();
                    layoutParams.width = l.getEquipmentWidth(this.mNw) - l.getDimens(this.mNw, R.dimen.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.mNI.setLayoutParams(layoutParams);
                    this.mNI.setTbRichTextVideoInfo(this.mNA);
                    this.mNI.stopPlay();
                    this.mNI.setThumbnail(this.mNA.getThumbUrl());
                    this.mNI.setVideoUrl(this.mNA.getVideoUrl(), String.valueOf(this.tid));
                    this.mNI.cSD();
                    o oVar = new o();
                    oVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    oVar.amC = String.valueOf(this.tid);
                    oVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    this.mNI.setVideoViewBusiness(oVar);
                }
                if (StringUtils.isNull(dCg.getTitle())) {
                    this.mNH.setVisibility(8);
                } else {
                    this.mNH.setText(dCg.getTitle());
                    this.mNH.setVisibility(0);
                }
                this.mNM.setText(String.format(Locale.CHINA, this.mNw.getString(R.string.bottom_comment), Integer.valueOf(dCg.getPostNum())));
                if (!this.mNw.dBT().dRM()) {
                    this.mNw.dBT().dRK();
                    return;
                }
                return;
            }
            this.mNw.dBT().dRJ();
            this.mNw.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mNG) {
            TiebaStatic.log(new ar("c13198").dR("tid", this.mNw.getTid()));
            e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.mNw != null && c.this.mNw.dBT() != null) {
                        c.this.mNw.dBT().dRJ();
                    }
                }
            }, 100L);
            this.mNw.finish();
        } else if (view == this.jmg) {
            TiebaStatic.log(new ar("c13199").ap("obj_locate", 4).dR("tid", this.mNw.getTid()));
            if (this.tid == 0) {
                this.mNw.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mNw).createNormalCfg(this.tid + "", null, null)));
            this.mNw.dBT().dRK();
            this.mNw.finish();
        } else if (view == this.mNL) {
            TiebaStatic.log(new ar("c13199").ap("obj_locate", 3).dR("tid", this.mNw.getTid()));
        }
    }

    public void onPause() {
        if (this.mNI != null) {
            this.mNI.onPause();
        }
    }

    public void onDestroy() {
        if (this.mNI != null) {
            this.mNI.onDestroy();
        }
    }
}
