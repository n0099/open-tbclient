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
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.z;
import com.tencent.connect.common.Constants;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Locale;
/* loaded from: classes3.dex */
public class c implements View.OnClickListener {
    private EditorScrollView ccU;
    private TbRichTextView gzM;
    private com.baidu.tbadk.widget.richText.a idA;
    private boolean idB = false;
    private final PushDialogActivity idf;
    private f idj;
    private Drawable idm;
    private View idn;
    private TbImageView ido;
    private TextView idp;
    private ImageView idq;
    private TextView idr;
    private PushDialogVideoView idu;
    private ClickableHeaderImageView idv;
    private TextView idw;
    private CommonUserLikeButton idx;
    private View idy;
    private TextView idz;
    private View mRootView;
    private long tid;
    private TextView tvUserName;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.idf = pushDialogActivity;
        this.idf.setContentView(i);
        this.mRootView = findViewById(d.g.root_view);
        this.idn = findViewById(d.g.dialog_wrapper_view);
        this.ccU = (EditorScrollView) findViewById(d.g.push_dialog_content_layout);
        this.ccU.setOverScrollMode(2);
        this.ccU.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.idB) {
                    TiebaStatic.log(new am("c13199").T("obj_locate", 1).bJ("tid", c.this.idf.getTid()));
                    c.this.idB = true;
                }
            }
        });
        if (this.idn.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.idn.getLayoutParams();
            int aQ = l.aQ(this.idf);
            layoutParams.height = aQ / 2;
            layoutParams.topMargin = (int) (aQ * 0.22f);
            this.idn.postInvalidate();
        }
        if (l.lr()) {
            this.idm = com.baidu.tieba.t.b.ciH();
            if (this.idm != null && this.idf.getWindow() != null) {
                this.idf.getWindow().setBackgroundDrawable(this.idm);
            }
        }
        this.idy = findViewById(d.g.push_dialog_bottom_layout);
        this.idy.setOnClickListener(this);
        this.idz = (TextView) findViewById(d.g.comment_num);
        this.ido = (TbImageView) findViewById(d.g.push_dialog_title_img);
        this.ido.setDefaultBgResource(d.f.icon);
        this.ido.setAutoChangeStyle(false);
        this.idp = (TextView) findViewById(d.g.push_dialog_title_text);
        this.idr = (TextView) findViewById(d.g.push_dialog_content_title);
        this.idv = (ClickableHeaderImageView) findViewById(d.g.push_dialog_user_head);
        this.idv.setBorderSurroundContent(true);
        this.idv.setIsRound(true);
        this.idv.setEnabled(false);
        this.idv.setAutoChangeStyle(false);
        this.idv.setBorderWidth(l.h(this.idf, d.e.tbds1));
        this.idv.setBorderColor(ContextCompat.getColor(this.idf, d.C0277d.black_alpha15));
        this.idA = new com.baidu.tbadk.widget.richText.a();
        this.gzM = (TbRichTextView) findViewById(d.g.push_dialog_content);
        this.gzM.setTextColor(ContextCompat.getColor(this.idf, d.C0277d.cp_cont_j));
        this.idA.kD(l.h(this.idf, d.e.tbds38));
        this.idA.setTextSize(l.h(this.idf, d.e.tbds42));
        this.idA.kH(l.h(this.idf, d.e.tbds23));
        this.idA.setLineSpacing(l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds7), 1.0f);
        this.idA.ar(l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds48), l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds48));
        this.gzM.setLayoutStrategy(this.idA);
        this.idu = (PushDialogVideoView) findViewById(d.g.push_dialog_video);
        this.idu.setPageContext(this.idf.getPageContext());
        this.tvUserName = (TextView) findViewById(d.g.push_dialog_user_name);
        this.idw = (TextView) findViewById(d.g.push_dialog_user_god_info);
        this.idx = (CommonUserLikeButton) findViewById(d.g.push_dialog_user_like_btn);
        this.idx.setAfterOnClickListener(this);
        this.idq = (ImageView) findViewById(d.g.dialog_close_btn);
        this.idq.setOnClickListener(this);
    }

    public void onResume() {
        if (this.idu != null) {
            this.idu.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.idf.findViewById(i);
    }

    public void bVE() {
        if (this.idu != null) {
            this.idu.setNetworkChange();
            if (j.la() && this.idu.ql() && this.idj != null && this.idj.getFileSize() > 0 && this.idj.getDuration() > 0) {
                float fileSize = this.idj.getFileSize() * (1.0f - ((this.idu.getCurrentPosition() * 1.0f) / (this.idj.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.idf.getPageContext().getPageActivity(), String.format(this.idf.getPageContext().getString(d.j.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int h;
        int h2;
        if (aVar != null) {
            this.ido.startLoad(aVar.bVG(), 17, false);
            this.idp.setText(aVar.bVF());
            if (aVar.bVI() != null) {
                this.idv.setData(aVar.bVI());
                this.tvUserName.setText(aVar.bVI().getName_show());
                if (aVar.bVI().getGodUserData() != null && (!StringUtils.isNull(aVar.bVI().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.bVI().getGodUserData().getIntro()))) {
                    this.idw.setText(aVar.bVI().getGodUserData().getForumName() + "吧 " + aVar.bVI().getGodIntro());
                    this.idw.setVisibility(0);
                } else {
                    this.idw.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.bVI().getUserId())) {
                    this.idx.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.idf.getPageContext(), this.idx).a(aVar.bVI());
                    this.idx.onChangeSkinType(0);
                    this.idx.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b bVH = aVar.bVH();
                if (bVH == null) {
                    this.idf.bVv().ciE();
                    this.idf.finish();
                    return;
                }
                boolean z = bVH.bVJ() == null || v.T(bVH.bVJ().ast());
                if (StringUtils.isNull(bVH.getTitle()) && z) {
                    this.idf.bVv().ciE();
                    this.idf.finish();
                    return;
                }
                if (bVH.bVJ() != null) {
                    Iterator<TbRichTextData> it = bVH.bVJ().ast().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.idj = next.asE();
                        }
                        if (this.idj != null) {
                            break;
                        }
                    }
                }
                this.tid = bVH.getTid();
                if (this.idj == null) {
                    this.idu.setVisibility(8);
                    this.gzM.setVisibility(0);
                    boolean z2 = j.lb() || j.kZ();
                    this.idA.fs(z2);
                    if (z2) {
                        h = (l.aO(TbadkCoreApplication.getInst()) - (l.h(this.idf, d.e.tbds22) * 2)) - (l.h(this.idf, d.e.tbds44) * 2);
                        h2 = (int) (h * 1.618f);
                    } else {
                        h = l.h(this.idf, d.e.tbds360);
                        h2 = l.h(this.idf, d.e.tbds202);
                    }
                    this.idA.ft(z2);
                    this.idA.ky(h);
                    this.idA.kz(h2);
                    this.gzM.setText(bVH.bVJ());
                } else {
                    this.gzM.setVisibility(8);
                    this.idu.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.idu.getLayoutParams();
                    layoutParams.width = l.aO(this.idf) - l.h(this.idf, d.e.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.idu.setLayoutParams(layoutParams);
                    this.idu.setTbRichTextVideoInfo(this.idj);
                    this.idu.stopPlay();
                    this.idu.setIsNeedRecoveryVideoPlayer(true);
                    this.idu.setThumbnail(this.idj.getThumbUrl());
                    this.idu.setVideoUrl(this.idj.getVideoUrl(), String.valueOf(this.tid));
                    this.idu.bnN();
                    n nVar = new n(this.idf.getActivity());
                    nVar.AQ("2");
                    z zVar = new z();
                    zVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    zVar.ctx = String.valueOf(this.tid);
                    zVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    nVar.setVideoStatsData(zVar);
                    this.idu.setQuickVideoViewBusiness(nVar);
                }
                if (StringUtils.isNull(bVH.getTitle())) {
                    this.idr.setVisibility(8);
                } else {
                    this.idr.setText(bVH.getTitle());
                    this.idr.setVisibility(0);
                }
                this.idz.setText(String.format(Locale.CHINA, this.idf.getString(d.j.bottom_comment), Integer.valueOf(bVH.getPostNum())));
                if (!this.idf.bVv().isScreenOn()) {
                    this.idf.bVv().ciF();
                    return;
                }
                return;
            }
            this.idf.bVv().ciE();
            this.idf.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.idq) {
            TiebaStatic.log(new am("c13198").bJ("tid", this.idf.getTid()));
            e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.idf != null && c.this.idf.bVv() != null) {
                        c.this.idf.bVv().ciE();
                    }
                }
            }, 100L);
            this.idf.finish();
        } else if (view == this.idy) {
            TiebaStatic.log(new am("c13199").T("obj_locate", 4).bJ("tid", this.idf.getTid()));
            if (this.tid == 0) {
                this.idf.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.idf).createNormalCfg(this.tid + "", null, null)));
            this.idf.bVv().ciF();
            this.idf.finish();
        } else if (view == this.idx) {
            TiebaStatic.log(new am("c13199").T("obj_locate", 3).bJ("tid", this.idf.getTid()));
        }
    }

    public void onPause() {
        if (this.idu != null) {
            this.idu.onPause();
        }
    }

    public void onDestroy() {
        if (this.idu != null) {
            this.idu.onDestroy();
        }
    }
}
