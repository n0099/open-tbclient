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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
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
    private TextView bac;
    private com.baidu.tbadk.widget.richText.a eLg;
    private EditorScrollView fyJ;
    private View jlg;
    private TbRichTextView jtS;
    private final PushDialogActivity mJc;
    private i mJg;
    private Drawable mJi;
    private View mJj;
    private TbImageView mJk;
    private TextView mJl;
    private ImageView mJm;
    private TextView mJn;
    private PushDialogVideoView mJo;
    private ClickableHeaderImageView mJp;
    private TextView mJq;
    private CommonUserLikeButton mJr;
    private TextView mJs;
    private boolean mJt = false;
    private View mRootView;
    private long tid;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.mJc = pushDialogActivity;
        this.mJc.setContentView(i);
        this.mRootView = findViewById(R.id.root_view);
        this.mJj = findViewById(R.id.dialog_wrapper_view);
        this.fyJ = (EditorScrollView) findViewById(R.id.push_dialog_content_layout);
        this.fyJ.setOverScrollMode(2);
        this.fyJ.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.mJt) {
                    TiebaStatic.log(new aq("c13199").an("obj_locate", 1).dX("tid", c.this.mJc.getTid()));
                    c.this.mJt = true;
                }
            }
        });
        if (this.mJj.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mJj.getLayoutParams();
            int equipmentHeight = l.getEquipmentHeight(this.mJc);
            layoutParams.height = equipmentHeight / 2;
            layoutParams.topMargin = (int) (equipmentHeight * 0.22f);
            this.mJj.postInvalidate();
        }
        if (l.isFlymeOsAbove35()) {
            this.mJi = com.baidu.tieba.v.b.dTt();
            if (this.mJi != null && this.mJc.getWindow() != null) {
                this.mJc.getWindow().setBackgroundDrawable(this.mJi);
            }
        }
        this.jlg = findViewById(R.id.push_dialog_bottom_layout);
        this.jlg.setOnClickListener(this);
        this.mJs = (TextView) findViewById(R.id.comment_num);
        this.mJk = (TbImageView) findViewById(R.id.push_dialog_title_img);
        this.mJk.setDefaultBgResource(R.drawable.tb_launcher_icon);
        this.mJk.setAutoChangeStyle(false);
        this.mJl = (TextView) findViewById(R.id.push_dialog_title_text);
        this.mJn = (TextView) findViewById(R.id.push_dialog_content_title);
        this.mJp = (ClickableHeaderImageView) findViewById(R.id.push_dialog_user_head);
        this.mJp.setBorderSurroundContent(true);
        this.mJp.setIsRound(true);
        this.mJp.setEnabled(false);
        this.mJp.setAutoChangeStyle(false);
        this.mJp.setBorderWidth(l.getDimens(this.mJc, R.dimen.tbds1));
        this.mJp.setBorderColor(ContextCompat.getColor(this.mJc, R.color.black_alpha15));
        this.eLg = new com.baidu.tbadk.widget.richText.a();
        this.jtS = (TbRichTextView) findViewById(R.id.push_dialog_content);
        this.jtS.setTextColor(ContextCompat.getColor(this.mJc, R.color.CAM_X0107));
        this.eLg.tE(l.getDimens(this.mJc, R.dimen.tbds38));
        this.eLg.setTextSize(l.getDimens(this.mJc, R.dimen.tbds42));
        this.eLg.tI(l.getDimens(this.mJc, R.dimen.tbds23));
        this.eLg.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.eLg.br(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.jtS.setLayoutStrategy(this.eLg);
        this.mJo = (PushDialogVideoView) findViewById(R.id.push_dialog_video);
        this.mJo.setPageContext(this.mJc.getPageContext());
        this.bac = (TextView) findViewById(R.id.push_dialog_user_name);
        this.mJq = (TextView) findViewById(R.id.push_dialog_user_god_info);
        this.mJr = (CommonUserLikeButton) findViewById(R.id.push_dialog_user_like_btn);
        this.mJr.setAfterOnClickListener(this);
        this.mJm = (ImageView) findViewById(R.id.dialog_close_btn);
        this.mJm.setOnClickListener(this);
    }

    public void onResume() {
        if (this.mJo != null) {
            this.mJo.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.mJc.findViewById(i);
    }

    public void dDK() {
        if (this.mJo != null) {
            this.mJo.setNetworkChange();
            if (j.isMobileNet() && this.mJo.rn() && this.mJg != null && this.mJg.getFileSize() > 0 && this.mJg.getDuration() > 0) {
                float fileSize = this.mJg.getFileSize() * (1.0f - ((this.mJo.getCurrentPosition() * 1.0f) / (this.mJg.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.mJc.getPageContext().getPageActivity(), String.format(this.mJc.getPageContext().getString(R.string.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int dimens;
        int dimens2;
        if (aVar != null) {
            this.mJk.startLoad(aVar.dDM(), 17, false);
            this.mJl.setText(aVar.dDL());
            if (aVar.dDO() != null) {
                this.mJp.setData(aVar.dDO());
                this.bac.setText(aVar.dDO().getName_show());
                if (aVar.dDO().getGodUserData() != null && (!StringUtils.isNull(aVar.dDO().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.dDO().getGodUserData().getIntro()))) {
                    this.mJq.setText(aVar.dDO().getGodUserData().getForumName() + "吧 " + aVar.dDO().getGodIntro());
                    this.mJq.setVisibility(0);
                } else {
                    this.mJq.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.dDO().getUserId())) {
                    this.mJr.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.mJc.getPageContext(), this.mJr).a(aVar.dDO());
                    this.mJr.onChangeSkinType(0);
                    this.mJr.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b dDN = aVar.dDN();
                if (dDN == null) {
                    this.mJc.dDA().dTp();
                    this.mJc.finish();
                    return;
                }
                boolean z = dDN.dDP() == null || x.isEmpty(dDN.dDP().bKW());
                if (StringUtils.isNull(dDN.getTitle()) && z) {
                    this.mJc.dDA().dTp();
                    this.mJc.finish();
                    return;
                }
                if (dDN.dDP() != null) {
                    Iterator<TbRichTextData> it = dDN.dDP().bKW().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.mJg = next.bLg();
                        }
                        if (this.mJg != null) {
                            break;
                        }
                    }
                }
                this.tid = dDN.getTid();
                if (this.mJg == null) {
                    this.mJo.setVisibility(8);
                    this.jtS.setVisibility(0);
                    boolean z2 = j.is4GNet() || j.isWifiNet();
                    this.eLg.lJ(z2);
                    if (z2) {
                        dimens = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(this.mJc, R.dimen.tbds22) * 2)) - (l.getDimens(this.mJc, R.dimen.tbds44) * 2);
                        dimens2 = (int) (dimens * 1.618f);
                    } else {
                        dimens = l.getDimens(this.mJc, R.dimen.tbds360);
                        dimens2 = l.getDimens(this.mJc, R.dimen.tbds202);
                    }
                    this.eLg.lK(z2);
                    this.eLg.tz(dimens);
                    this.eLg.tA(dimens2);
                    this.jtS.setText(dDN.dDP());
                } else {
                    this.jtS.setVisibility(8);
                    this.mJo.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mJo.getLayoutParams();
                    layoutParams.width = l.getEquipmentWidth(this.mJc) - l.getDimens(this.mJc, R.dimen.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.mJo.setLayoutParams(layoutParams);
                    this.mJo.setTbRichTextVideoInfo(this.mJg);
                    this.mJo.stopPlay();
                    this.mJo.setThumbnail(this.mJg.getThumbUrl());
                    this.mJo.setVideoUrl(this.mJg.getVideoUrl(), String.valueOf(this.tid));
                    this.mJo.cUv();
                    o oVar = new o();
                    oVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    oVar.anD = String.valueOf(this.tid);
                    oVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    this.mJo.setVideoViewBusiness(oVar);
                }
                if (StringUtils.isNull(dDN.getTitle())) {
                    this.mJn.setVisibility(8);
                } else {
                    this.mJn.setText(dDN.getTitle());
                    this.mJn.setVisibility(0);
                }
                this.mJs.setText(String.format(Locale.CHINA, this.mJc.getString(R.string.bottom_comment), Integer.valueOf(dDN.getPostNum())));
                if (!this.mJc.dDA().dTs()) {
                    this.mJc.dDA().dTq();
                    return;
                }
                return;
            }
            this.mJc.dDA().dTp();
            this.mJc.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mJm) {
            TiebaStatic.log(new aq("c13198").dX("tid", this.mJc.getTid()));
            e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.mJc != null && c.this.mJc.dDA() != null) {
                        c.this.mJc.dDA().dTp();
                    }
                }
            }, 100L);
            this.mJc.finish();
        } else if (view == this.jlg) {
            TiebaStatic.log(new aq("c13199").an("obj_locate", 4).dX("tid", this.mJc.getTid()));
            if (this.tid == 0) {
                this.mJc.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mJc).createNormalCfg(this.tid + "", null, null)));
            this.mJc.dDA().dTq();
            this.mJc.finish();
        } else if (view == this.mJr) {
            TiebaStatic.log(new aq("c13199").an("obj_locate", 3).dX("tid", this.mJc.getTid()));
        }
    }

    public void onPause() {
        if (this.mJo != null) {
            this.mJo.onPause();
        }
    }

    public void onDestroy() {
        if (this.mJo != null) {
            this.mJo.onDestroy();
        }
    }
}
