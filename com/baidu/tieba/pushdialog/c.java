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
    private EditorScrollView ccT;
    private TbRichTextView gzL;
    private boolean idA = false;
    private final PushDialogActivity ide;
    private f idi;
    private Drawable idk;
    private View idm;
    private TbImageView idn;
    private TextView ido;
    private ImageView idp;
    private TextView idq;
    private PushDialogVideoView idr;
    private ClickableHeaderImageView idu;
    private TextView idv;
    private CommonUserLikeButton idw;
    private View idx;
    private TextView idy;
    private com.baidu.tbadk.widget.richText.a idz;
    private View mRootView;
    private long tid;
    private TextView tvUserName;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.pushdialog.PushDialogActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public c(PushDialogActivity pushDialogActivity, int i) {
        this.ide = pushDialogActivity;
        this.ide.setContentView(i);
        this.mRootView = findViewById(d.g.root_view);
        this.idm = findViewById(d.g.dialog_wrapper_view);
        this.ccT = (EditorScrollView) findViewById(d.g.push_dialog_content_layout);
        this.ccT.setOverScrollMode(2);
        this.ccT.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pushdialog.c.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (!c.this.idA) {
                    TiebaStatic.log(new am("c13199").T("obj_locate", 1).bJ("tid", c.this.ide.getTid()));
                    c.this.idA = true;
                }
            }
        });
        if (this.idm.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.idm.getLayoutParams();
            int aQ = l.aQ(this.ide);
            layoutParams.height = aQ / 2;
            layoutParams.topMargin = (int) (aQ * 0.22f);
            this.idm.postInvalidate();
        }
        if (l.lr()) {
            this.idk = com.baidu.tieba.t.b.ciH();
            if (this.idk != null && this.ide.getWindow() != null) {
                this.ide.getWindow().setBackgroundDrawable(this.idk);
            }
        }
        this.idx = findViewById(d.g.push_dialog_bottom_layout);
        this.idx.setOnClickListener(this);
        this.idy = (TextView) findViewById(d.g.comment_num);
        this.idn = (TbImageView) findViewById(d.g.push_dialog_title_img);
        this.idn.setDefaultBgResource(d.f.icon);
        this.idn.setAutoChangeStyle(false);
        this.ido = (TextView) findViewById(d.g.push_dialog_title_text);
        this.idq = (TextView) findViewById(d.g.push_dialog_content_title);
        this.idu = (ClickableHeaderImageView) findViewById(d.g.push_dialog_user_head);
        this.idu.setBorderSurroundContent(true);
        this.idu.setIsRound(true);
        this.idu.setEnabled(false);
        this.idu.setAutoChangeStyle(false);
        this.idu.setBorderWidth(l.h(this.ide, d.e.tbds1));
        this.idu.setBorderColor(ContextCompat.getColor(this.ide, d.C0277d.black_alpha15));
        this.idz = new com.baidu.tbadk.widget.richText.a();
        this.gzL = (TbRichTextView) findViewById(d.g.push_dialog_content);
        this.gzL.setTextColor(ContextCompat.getColor(this.ide, d.C0277d.cp_cont_j));
        this.idz.kD(l.h(this.ide, d.e.tbds38));
        this.idz.setTextSize(l.h(this.ide, d.e.tbds42));
        this.idz.kH(l.h(this.ide, d.e.tbds23));
        this.idz.setLineSpacing(l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds7), 1.0f);
        this.idz.ar(l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds48), l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds48));
        this.gzL.setLayoutStrategy(this.idz);
        this.idr = (PushDialogVideoView) findViewById(d.g.push_dialog_video);
        this.idr.setPageContext(this.ide.getPageContext());
        this.tvUserName = (TextView) findViewById(d.g.push_dialog_user_name);
        this.idv = (TextView) findViewById(d.g.push_dialog_user_god_info);
        this.idw = (CommonUserLikeButton) findViewById(d.g.push_dialog_user_like_btn);
        this.idw.setAfterOnClickListener(this);
        this.idp = (ImageView) findViewById(d.g.dialog_close_btn);
        this.idp.setOnClickListener(this);
    }

    public void onResume() {
        if (this.idr != null) {
            this.idr.onResume();
        }
    }

    private View findViewById(@IdRes int i) {
        return this.ide.findViewById(i);
    }

    public void bVE() {
        if (this.idr != null) {
            this.idr.setNetworkChange();
            if (j.la() && this.idr.ql() && this.idi != null && this.idi.getFileSize() > 0 && this.idi.getDuration() > 0) {
                float fileSize = this.idi.getFileSize() * (1.0f - ((this.idr.getCurrentPosition() * 1.0f) / (this.idi.getDuration() * 1000)));
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                if ((fileSize * 1.0f) / 1048576.0f >= 0.1d) {
                    l.showToast(this.ide.getPageContext().getPageActivity(), String.format(this.ide.getPageContext().getString(d.j.push_dialog_video_net_change_tip), decimalFormat.format((fileSize * 1.0f) / 1048576.0f)));
                }
            }
        }
    }

    public void a(com.baidu.tieba.pushdialog.data.a aVar) {
        int h;
        int h2;
        if (aVar != null) {
            this.idn.startLoad(aVar.bVG(), 17, false);
            this.ido.setText(aVar.bVF());
            if (aVar.bVI() != null) {
                this.idu.setData(aVar.bVI());
                this.tvUserName.setText(aVar.bVI().getName_show());
                if (aVar.bVI().getGodUserData() != null && (!StringUtils.isNull(aVar.bVI().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.bVI().getGodUserData().getIntro()))) {
                    this.idv.setText(aVar.bVI().getGodUserData().getForumName() + "吧 " + aVar.bVI().getGodIntro());
                    this.idv.setVisibility(0);
                } else {
                    this.idv.setVisibility(8);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.bVI().getUserId())) {
                    this.idw.setVisibility(8);
                } else {
                    new com.baidu.tbadk.core.view.userLike.c(this.ide.getPageContext(), this.idw).a(aVar.bVI());
                    this.idw.onChangeSkinType(0);
                    this.idw.setVisibility(0);
                }
                com.baidu.tieba.pushdialog.data.b bVH = aVar.bVH();
                if (bVH == null) {
                    this.ide.bVv().ciE();
                    this.ide.finish();
                    return;
                }
                boolean z = bVH.bVJ() == null || v.T(bVH.bVJ().ast());
                if (StringUtils.isNull(bVH.getTitle()) && z) {
                    this.ide.bVv().ciE();
                    this.ide.finish();
                    return;
                }
                if (bVH.bVJ() != null) {
                    Iterator<TbRichTextData> it = bVH.bVJ().ast().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            this.idi = next.asE();
                        }
                        if (this.idi != null) {
                            break;
                        }
                    }
                }
                this.tid = bVH.getTid();
                if (this.idi == null) {
                    this.idr.setVisibility(8);
                    this.gzL.setVisibility(0);
                    boolean z2 = j.lb() || j.kZ();
                    this.idz.fs(z2);
                    if (z2) {
                        h = (l.aO(TbadkCoreApplication.getInst()) - (l.h(this.ide, d.e.tbds22) * 2)) - (l.h(this.ide, d.e.tbds44) * 2);
                        h2 = (int) (h * 1.618f);
                    } else {
                        h = l.h(this.ide, d.e.tbds360);
                        h2 = l.h(this.ide, d.e.tbds202);
                    }
                    this.idz.ft(z2);
                    this.idz.ky(h);
                    this.idz.kz(h2);
                    this.gzL.setText(bVH.bVJ());
                } else {
                    this.gzL.setVisibility(8);
                    this.idr.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.idr.getLayoutParams();
                    layoutParams.width = l.aO(this.ide) - l.h(this.ide, d.e.tbds132);
                    layoutParams.height = (int) (layoutParams.width * 0.5625f);
                    this.idr.setLayoutParams(layoutParams);
                    this.idr.setTbRichTextVideoInfo(this.idi);
                    this.idr.stopPlay();
                    this.idr.setIsNeedRecoveryVideoPlayer(true);
                    this.idr.setThumbnail(this.idi.getThumbUrl());
                    this.idr.setVideoUrl(this.idi.getVideoUrl(), String.valueOf(this.tid));
                    this.idr.bnN();
                    n nVar = new n(this.ide.getActivity());
                    nVar.AQ("2");
                    z zVar = new z();
                    zVar.mLocate = Constants.VIA_REPORT_TYPE_WPA_STATE;
                    zVar.ctw = String.valueOf(this.tid);
                    zVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    nVar.setVideoStatsData(zVar);
                    this.idr.setQuickVideoViewBusiness(nVar);
                }
                if (StringUtils.isNull(bVH.getTitle())) {
                    this.idq.setVisibility(8);
                } else {
                    this.idq.setText(bVH.getTitle());
                    this.idq.setVisibility(0);
                }
                this.idy.setText(String.format(Locale.CHINA, this.ide.getString(d.j.bottom_comment), Integer.valueOf(bVH.getPostNum())));
                if (!this.ide.bVv().isScreenOn()) {
                    this.ide.bVv().ciF();
                    return;
                }
                return;
            }
            this.ide.bVv().ciE();
            this.ide.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.idp) {
            TiebaStatic.log(new am("c13198").bJ("tid", this.ide.getTid()));
            e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.pushdialog.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.ide != null && c.this.ide.bVv() != null) {
                        c.this.ide.bVv().ciE();
                    }
                }
            }, 100L);
            this.ide.finish();
        } else if (view == this.idx) {
            TiebaStatic.log(new am("c13199").T("obj_locate", 4).bJ("tid", this.ide.getTid()));
            if (this.tid == 0) {
                this.ide.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.ide).createNormalCfg(this.tid + "", null, null)));
            this.ide.bVv().ciF();
            this.ide.finish();
        } else if (view == this.idw) {
            TiebaStatic.log(new am("c13199").T("obj_locate", 3).bJ("tid", this.ide.getTid()));
        }
    }

    public void onPause() {
        if (this.idr != null) {
            this.idr.onPause();
        }
    }

    public void onDestroy() {
        if (this.idr != null) {
            this.idr.onDestroy();
        }
    }
}
