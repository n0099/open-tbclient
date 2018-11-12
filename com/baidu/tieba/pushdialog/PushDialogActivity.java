package com.baidu.tieba.pushdialog;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PushDialogActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.e;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
/* loaded from: classes3.dex */
public class PushDialogActivity extends BaseActivity<PushDialogActivity> implements e {
    private com.baidu.adp.lib.e.b<ImageView> bog;
    private com.baidu.adp.lib.e.b<TextView> boh;
    private com.baidu.adp.lib.e.b<View> boi;
    private com.baidu.adp.lib.e.b<LinearLayout> boj;
    private com.baidu.adp.lib.e.b<RelativeLayout> bok;
    private com.baidu.adp.lib.e.b<GifView> bol;
    private com.baidu.tieba.t.a dYD;
    private c gAX;
    private a gAY;
    private com.baidu.tieba.ueg.b gAZ;
    private HomeWatcherReceiver gBb;
    private boolean gBa = false;
    private String gBc = "push_dialog";
    private CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pushdialog.PushDialogActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.kV() && PushDialogActivity.this.gAX != null) {
                PushDialogActivity.this.gAX.brG();
            }
        }
    };
    private CustomMessageListener bRt = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.pushdialog.PushDialogActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PushDialogActivity.this.getPageContext().getUniqueId()) && !updateAttentionMessage.getData().Jr) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(PushDialogActivity.this);
                    aVar.ej(PushDialogActivity.this.getString(e.j.push_dialog_attention_failed));
                    aVar.b(e.j.confirm, new a.b() { // from class: com.baidu.tieba.pushdialog.PushDialogActivity.2.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            if (aVar2 != null && aVar2.isShowing()) {
                                aVar2.dismiss();
                            }
                        }
                    });
                    aVar.b(PushDialogActivity.this.getPageContext()).AB();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.gBc += "_1";
        TiebaStatic.eventStat(this, "push_dialog", this.gBc);
        super.onCreate(bundle);
        this.dYD = com.baidu.tieba.screenlocknotify.a.buc().gNc;
        if (this.gAZ == null) {
            this.gAZ = new com.baidu.tieba.ueg.b();
        }
        this.gAZ.nR(true);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        Window window = getWindow();
        if (getIntent().getBooleanExtra("need_show_lock", true)) {
            window.addFlags(524288);
        }
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        this.gAX = new c(this, e.h.activtiy_push_dialog);
        this.gAY = new a(this);
        this.gAY.loadData();
        registerListener(this.mNetworkChangedListener);
        this.gBb = new HomeWatcherReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        registerReceiver(this.gBb, intentFilter);
        registerListener(this.bRt);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.gBc += "_2";
        TiebaStatic.eventStat(this, "push_dialog", this.gBc);
        super.onResume();
        this.gAX.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    public void a(boolean z, com.baidu.tieba.pushdialog.data.a aVar) {
        this.gBc += "_3";
        TiebaStatic.eventStat(this, "push_dialog", this.gBc);
        this.gBa = true;
        if (!z || aVar == null) {
            finish();
        } else if (this.gAX != null) {
            this.gAX.a(aVar);
            TiebaStatic.log(new am("c13197").ax("tid", getTid()));
            TiebaStatic.log(new am("c13196").x("obj_type", 2).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.gAY.getTaskId() != 0 ? 2 : 1).ax("tid", getTid()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.gBc += "_4";
        TiebaStatic.eventStat(this, "push_dialog", this.gBc);
        super.onPause();
        this.gAX.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.gBc += "_5";
        TiebaStatic.eventStat(this, "push_dialog", this.gBc);
        if (!this.gBa) {
            PushDialogActivityConfig pushDialogActivityConfig = new PushDialogActivityConfig(this, this.gAY.getTaskId(), this.gAY.getTid());
            pushDialogActivityConfig.getIntent().putExtra("need_show_lock", false);
            sendMessage(new CustomMessage(2002001, pushDialogActivityConfig));
        }
        super.onDestroy();
        this.gAX.onDestroy();
        if (this.gBb != null) {
            unregisterReceiver(this.gBb);
        }
        if (this.gAZ != null) {
            this.gAZ.nR(false);
        }
    }

    public com.baidu.tieba.t.a brx() {
        return this.dYD;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a059";
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int RA() {
        return e.g.push_dialog_content;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> RB() {
        if (this.bog == null) {
            this.bog = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pushdialog.PushDialogActivity.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: akN */
                public ImageView jz() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PushDialogActivity.this);
                    boolean wE = i.wA().wE();
                    foreDrawableImageView.setDefaultBg(al.getDrawable(e.d.common_color_10220));
                    if (wE) {
                        foreDrawableImageView.setAdjustViewBounds(false);
                        foreDrawableImageView.setInterceptOnClick(false);
                    } else {
                        foreDrawableImageView.setDefaultResource(e.f.icon_click);
                        foreDrawableImageView.setAdjustViewBounds(true);
                        foreDrawableImageView.setInterceptOnClick(true);
                    }
                    return foreDrawableImageView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: c */
                public void u(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(e.d.common_color_10220);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: b */
                public ImageView v(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (i.wA().wE()) {
                            tbImageView.setAdjustViewBounds(false);
                            tbImageView.setInterceptOnClick(false);
                        } else {
                            tbImageView.setDefaultResource(e.f.icon_click);
                            tbImageView.setAdjustViewBounds(true);
                            tbImageView.setInterceptOnClick(true);
                        }
                    }
                    return imageView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: d */
                public ImageView w(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(e.d.common_color_10220);
                        foreDrawableImageView.reset();
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.bog;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> RC() {
        if (this.boh == null) {
            this.boh = TbRichTextView.n(this, 8);
        }
        return this.boh;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> RD() {
        if (this.bol == null) {
            this.bol = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pushdialog.PushDialogActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bgC */
                public GifView jz() {
                    return new GifView(PushDialogActivity.this);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: g */
                public void u(GifView gifView) {
                    gifView.onDestroy();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: h */
                public GifView v(GifView gifView) {
                    return gifView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: i */
                public GifView w(GifView gifView) {
                    gifView.release();
                    gifView.setImageDrawable(null);
                    gifView.Mn();
                    gifView.setBackgroundDrawable(null);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.bol;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> RE() {
        if (this.boi == null) {
            this.boi = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pushdialog.PushDialogActivity.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bgD */
                public View jz() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(PushDialogActivity.this, PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(e.C0200e.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bx */
                public void u(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: by */
                public View v(View view) {
                    ((PlayVoiceBntNew) view).bCH();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bz */
                public View w(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.boi;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> RF() {
        if (this.boj == null) {
            this.boj = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pushdialog.PushDialogActivity.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bgF */
                public LinearLayout jz() {
                    LinearLayout linearLayout = new LinearLayout(PushDialogActivity.this);
                    linearLayout.setId(e.g.pb_text_voice_layout);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    linearLayout.setLayoutParams(layoutParams);
                    linearLayout.setGravity(16);
                    linearLayout.setBaselineAligned(true);
                    linearLayout.setOrientation(1);
                    linearLayout.setLayoutParams(layoutParams);
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: d */
                public void u(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: e */
                public LinearLayout v(LinearLayout linearLayout) {
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: f */
                public LinearLayout w(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                    return linearLayout;
                }
            }, 15, 0);
        }
        return this.boj;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> RG() {
        this.bok = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pushdialog.PushDialogActivity.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bgE */
            public RelativeLayout jz() {
                return new RelativeLayout(PushDialogActivity.this);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void u(RelativeLayout relativeLayout) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public RelativeLayout v(RelativeLayout relativeLayout) {
                return relativeLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public RelativeLayout w(RelativeLayout relativeLayout) {
                return relativeLayout;
            }
        }, 10, 0);
        return this.bok;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ak(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void e(Context context, String str, boolean z) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void al(Context context, String str) {
        finish();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void am(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void an(Context context, String str) {
        finish();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void i(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ao(Context context, String str) {
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 3) {
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public String getTid() {
        if (this.gAY == null) {
            return null;
        }
        return this.gAY.getTid();
    }

    /* loaded from: classes3.dex */
    public class HomeWatcherReceiver extends BroadcastReceiver {
        private static final String SYSTEM_DIALOG_REASON_ASSIST = "assist";
        private static final String SYSTEM_DIALOG_REASON_HOME_KEY = "homekey";
        private static final String SYSTEM_DIALOG_REASON_KEY = "reason";
        private static final String SYSTEM_DIALOG_REASON_LOCK = "lock";
        private static final String SYSTEM_DIALOG_REASON_RECENT_APPS = "recentapps";

        public HomeWatcherReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && !SYSTEM_DIALOG_REASON_LOCK.equals(intent.getStringExtra("reason"))) {
                PushDialogActivity.this.finish();
            }
        }
    }
}
