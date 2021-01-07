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
    private final PushDialogActivity mJb;
    private i mJf;
    private Drawable mJh;
    private View mJi;
    private TbImageView mJj;
    private TextView mJk;
    private ImageView mJl;
    private TextView mJm;
    private PushDialogVideoView mJn;
    private ClickableHeaderImageView mJo;
    private TextView mJp;
    private CommonUserLikeButton mJq;
    private TextView mJr;
    private boolean mJs = false;
    private View mRootView;
    private long tid;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.mJb = pushDialogActivity;
        this.mJb.setContentView(i);
        this.mRootView = findViewById(R.id.root_view);
        this.mJi = findViewById(R.id.dialog_wrapper_view);
        this.fyJ = (EditorScrollView) findViewById(R.id.push_dialog_content_layout);
        this.fyJ.setOverScrollMode(2);
        this.fyJ.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.mJs) {
                    TiebaStatic.log(new aq("c13199").an("obj_locate", 1).dX("tid", c.this.mJb.getTid()));
                    c.this.mJs = true;
                }
            }
        });
        if (this.mJi.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mJi.getLayoutParams();
            int equipmentHeight = l.getEquipmentHeight(this.mJb);
            layoutParams.height = equipmentHeight / 2;
            layoutParams.topMargin = (int) (equipmentHeight * 0.22f);
            this.mJi.postInvalidate();
        }
        if (l.isFlymeOsAbove35()) {
            this.mJh = com.baidu.tieba.v.b.dTu();
            if (this.mJh != null && this.mJb.getWindow() != null) {
                this.mJb.getWindow().setBackgroundDrawable(this.mJh);
            }
        }
        this.jlg = findViewById(R.id.push_dialog_bottom_layout);
        this.jlg.setOnClickListener(this);
        this.mJr = (TextView) findViewById(R.id.comment_num);
        this.mJj = (TbImageView) findViewById(R.id.push_dialog_title_img);
        this.mJj.setDefaultBgResource(R.drawable.tb_launcher_icon);
        this.mJj.setAutoChangeStyle(false);
        this.mJk = (TextView) findViewById(R.id.push_dialog_title_text);
        this.mJm = (TextView) findViewById(R.id.push_dialog_content_title);
        this.mJo = (ClickableHeaderImageView) findViewById(R.id.push_dialog_user_head);
        this.mJo.setBorderSurroundContent(true);
        this.mJo.setIsRound(true);
        this.mJo.setEnabled(false);
        this.mJo.setAutoChangeStyle(false);
        this.mJo.setBorderWidth(l.getDimens(this.mJb, R.dimen.tbds1));
        this.mJo.setBorderColor(ContextCompat.getColor(this.mJb, R.color.black_alpha15));
        this.eLg = new com.baidu.tbadk.widget.richText.a();
        this.jtS = (TbRichTextView) findViewById(R.id.push_dialog_content);
        this.jtS.setTextColor(ContextCompat.getColor(this.mJb, R.color.CAM_X0107));
        this.eLg.tE(l.getDimens(this.mJb, R.dimen.tbds38));
        this.eLg.setTextSize(l.getDimens(this.mJb, R.dimen.tbds42));
        this.eLg.tI(l.getDimens(this.mJb, R.dimen.tbds23));
        this.eLg.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.eLg.br(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.jtS.setLayoutStrategy(this.eLg);
        this.mJn = (PushDialogVideoView) findViewById(R.id.push_dialog_video);
        this.mJn.setPageContext(this.mJb.getPageContext());
        this.bac = (TextView) findViewById(R.id.push_dialog_user_name);
        this.mJp = (TextView) findViewById(R.id.push_dialog_user_god_info);
        this.mJq = (CommonUserLikeButton) findViewById(R.id.push_dialog_user_like_btn);
        this.mJq.setAfterOnClickListener(this);
        this.mJl = (ImageView) findViewById(R.id.dialog_close_btn);
        this.mJl.setOnClickListener(this);
    }

    public void onResume() {
        if (this.mJn != null) {
            this.mJn.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.mJb.findViewById(i);
    }

    public void dDL() {
        if (this.mJn != null) {
            this.mJn.setNetworkChange();
            if (j.isMobileNet() && this.mJn.rn() && this.mJf != null && this.mJf.getFileSize() > 0 && this.mJf.getDuration() > 0) {
                float fileSize = this.mJf.getFileSize() * (1.0f - ((this.mJn.getCurrentPosition() * 1.0f) / (this.mJf.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.mJb.getPageContext().getPageActivity(), String.format(this.mJb.getPageContext().getString(R.string.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int dimens;
        int dimens2;
        if (aVar != null) {
            this.mJj.startLoad(aVar.dDN(), 17, false);
            this.mJk.setText(aVar.dDM());
            if (aVar.dDP() != null) {
                this.mJo.setData(aVar.dDP());
                this.bac.setText(aVar.dDP().getName_show());
                if (aVar.dDP().getGodUserData() != null && (!StringUtils.isNull(aVar.dDP().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.dDP().getGodUserData().getIntro()))) {
                    this.mJp.setText(aVar.dDP().getGodUserData().getForumName() + "吧 " + aVar.dDP().getGodIntro());
                    this.mJp.setVisibility(0);
                } else {
                    this.mJp.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.dDP().getUserId())) {
                    this.mJq.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.mJb.getPageContext(), this.mJq).a(aVar.dDP());
                    this.mJq.onChangeSkinType(0);
                    this.mJq.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b dDO = aVar.dDO();
                if (dDO == null) {
                    this.mJb.dDB().dTq();
                    this.mJb.finish();
                    return;
                }
                boolean z = dDO.dDQ() == null || x.isEmpty(dDO.dDQ().bKX());
                if (StringUtils.isNull(dDO.getTitle()) && z) {
                    this.mJb.dDB().dTq();
                    this.mJb.finish();
                    return;
                }
                if (dDO.dDQ() != null) {
                    Iterator<TbRichTextData> it = dDO.dDQ().bKX().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.mJf = next.bLh();
                        }
                        if (this.mJf != null) {
                            break;
                        }
                    }
                }
                this.tid = dDO.getTid();
                if (this.mJf == null) {
                    this.mJn.setVisibility(8);
                    this.jtS.setVisibility(0);
                    boolean z2 = j.is4GNet() || j.isWifiNet();
                    this.eLg.lJ(z2);
                    if (z2) {
                        dimens = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(this.mJb, R.dimen.tbds22) * 2)) - (l.getDimens(this.mJb, R.dimen.tbds44) * 2);
                        dimens2 = (int) (dimens * 1.618f);
                    } else {
                        dimens = l.getDimens(this.mJb, R.dimen.tbds360);
                        dimens2 = l.getDimens(this.mJb, R.dimen.tbds202);
                    }
                    this.eLg.lK(z2);
                    this.eLg.tz(dimens);
                    this.eLg.tA(dimens2);
                    this.jtS.setText(dDO.dDQ());
                } else {
                    this.jtS.setVisibility(8);
                    this.mJn.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mJn.getLayoutParams();
                    layoutParams.width = l.getEquipmentWidth(this.mJb) - l.getDimens(this.mJb, R.dimen.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.mJn.setLayoutParams(layoutParams);
                    this.mJn.setTbRichTextVideoInfo(this.mJf);
                    this.mJn.stopPlay();
                    this.mJn.setThumbnail(this.mJf.getThumbUrl());
                    this.mJn.setVideoUrl(this.mJf.getVideoUrl(), String.valueOf(this.tid));
                    this.mJn.cUw();
                    o oVar = new o();
                    oVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    oVar.anD = String.valueOf(this.tid);
                    oVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    this.mJn.setVideoViewBusiness(oVar);
                }
                if (StringUtils.isNull(dDO.getTitle())) {
                    this.mJm.setVisibility(8);
                } else {
                    this.mJm.setText(dDO.getTitle());
                    this.mJm.setVisibility(0);
                }
                this.mJr.setText(String.format(Locale.CHINA, this.mJb.getString(R.string.bottom_comment), Integer.valueOf(dDO.getPostNum())));
                if (!this.mJb.dDB().dTt()) {
                    this.mJb.dDB().dTr();
                    return;
                }
                return;
            }
            this.mJb.dDB().dTq();
            this.mJb.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mJl) {
            TiebaStatic.log(new aq("c13198").dX("tid", this.mJb.getTid()));
            e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.mJb != null && c.this.mJb.dDB() != null) {
                        c.this.mJb.dDB().dTq();
                    }
                }
            }, 100L);
            this.mJb.finish();
        } else if (view == this.jlg) {
            TiebaStatic.log(new aq("c13199").an("obj_locate", 4).dX("tid", this.mJb.getTid()));
            if (this.tid == 0) {
                this.mJb.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mJb).createNormalCfg(this.tid + "", null, null)));
            this.mJb.dDB().dTr();
            this.mJb.finish();
        } else if (view == this.mJq) {
            TiebaStatic.log(new aq("c13199").an("obj_locate", 3).dX("tid", this.mJb.getTid()));
        }
    }

    public void onPause() {
        if (this.mJn != null) {
            this.mJn.onPause();
        }
    }

    public void onDestroy() {
        if (this.mJn != null) {
            this.mJn.onDestroy();
        }
    }
}
