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
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.PushDialogActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.h;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
/* loaded from: classes8.dex */
public class PushDialogActivity extends BaseActivity<PushDialogActivity> implements h {
    private com.baidu.adp.lib.d.b<ImageView> fWD;
    private com.baidu.adp.lib.d.b<GifView> fWE;
    private com.baidu.adp.lib.d.b<TextView> fZS;
    private com.baidu.adp.lib.d.b<View> fZT;
    private com.baidu.adp.lib.d.b<LinearLayout> fZU;
    private com.baidu.adp.lib.d.b<RelativeLayout> fZV;
    private com.baidu.tieba.v.b jMq;
    private c mIO;
    private a mIQ;
    private com.baidu.tieba.ueg.b mIR;
    private HomeWatcherReceiver mIT;
    private boolean mIS = false;
    private String mIU = "push_dialog";
    private CustomMessageListener PQ = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable() && PushDialogActivity.this.mIO != null) {
                PushDialogActivity.this.mIO.dDK();
            }
        }
    };
    private CustomMessageListener jgE = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.pushdialog.PushDialogActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PushDialogActivity.this.getPageContext().getUniqueId()) && !updateAttentionMessage.getData().isSucc) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(PushDialogActivity.this);
                    aVar.Bp(PushDialogActivity.this.getString(R.string.push_dialog_attention_failed));
                    aVar.b(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pushdialog.PushDialogActivity.2.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            if (aVar2 != null && aVar2.isShowing()) {
                                aVar2.dismiss();
                            }
                        }
                    });
                    aVar.b(PushDialogActivity.this.getPageContext()).btX();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.mIU += "_1";
        TiebaStatic.eventStat(this, "push_dialog", this.mIU);
        super.onCreate(bundle);
        this.jMq = com.baidu.tieba.screenlocknotify.a.dGP().mXm;
        if (this.mIR == null) {
            this.mIR = new com.baidu.tieba.ueg.b();
        }
        this.mIR.yE(true);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        Window window = getWindow();
        if (getIntent().getBooleanExtra("need_show_lock", true)) {
            window.addFlags(524288);
        }
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        this.mIO = new c(this, R.layout.activtiy_push_dialog);
        this.mIQ = new a(this);
        this.mIQ.loadData();
        registerListener(this.PQ);
        this.mIT = new HomeWatcherReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        registerReceiver(this.mIT, intentFilter);
        registerListener(this.jgE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.mIU += "_2";
        TiebaStatic.eventStat(this, "push_dialog", this.mIU);
        super.onResume();
        this.mIO.onResume();
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
        this.mIU += "_3";
        TiebaStatic.eventStat(this, "push_dialog", this.mIU);
        this.mIS = true;
        if (!z || aVar == null) {
            finish();
        } else if (this.mIO != null) {
            this.mIO.a(aVar);
            TiebaStatic.log(new aq("c13197").dX("tid", getTid()));
            TiebaStatic.log(new aq("c13196").an("obj_type", 2).an("obj_source", this.mIQ.getTaskId() != 0 ? 2 : 1).dX("tid", getTid()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.mIU += "_4";
        TiebaStatic.eventStat(this, "push_dialog", this.mIU);
        super.onPause();
        this.mIO.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.mIU += "_5";
        TiebaStatic.eventStat(this, "push_dialog", this.mIU);
        if (!this.mIS) {
            PushDialogActivityConfig pushDialogActivityConfig = new PushDialogActivityConfig(this, this.mIQ.getTaskId(), this.mIQ.getTid());
            pushDialogActivityConfig.getIntent().putExtra("need_show_lock", false);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, pushDialogActivityConfig));
        }
        super.onDestroy();
        this.mIO.onDestroy();
        if (this.mIT != null) {
            unregisterReceiver(this.mIT);
        }
        if (this.mIR != null) {
            this.mIR.yE(false);
        }
    }

    public com.baidu.tieba.v.b dDA() {
        return this.jMq;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a059";
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int bLE() {
        return R.id.push_dialog_content;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> bLF() {
        if (this.fWD == null) {
            this.fWD = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pushdialog.PushDialogActivity.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bLR */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PushDialogActivity.this);
                    boolean isShowImages = k.bou().isShowImages();
                    foreDrawableImageView.setDefaultBg(ao.getDrawable(R.color.common_color_10220));
                    if (isShowImages) {
                        foreDrawableImageView.setAdjustViewBounds(false);
                        foreDrawableImageView.setInterceptOnClick(false);
                    } else {
                        foreDrawableImageView.setDefaultResource(R.drawable.icon_click);
                        foreDrawableImageView.setAdjustViewBounds(true);
                        foreDrawableImageView.setInterceptOnClick(true);
                    }
                    return foreDrawableImageView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: c */
                public void destroyObject(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: d */
                public ImageView activateObject(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (k.bou().isShowImages()) {
                            tbImageView.setAdjustViewBounds(false);
                            tbImageView.setInterceptOnClick(false);
                        } else {
                            tbImageView.setDefaultResource(R.drawable.icon_click);
                            tbImageView.setAdjustViewBounds(true);
                            tbImageView.setInterceptOnClick(true);
                        }
                    }
                    return imageView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: e */
                public ImageView passivateObject(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                        foreDrawableImageView.reset();
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.fWD;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> bLG() {
        if (this.fZS == null) {
            this.fZS = TbRichTextView.K(this, 8);
        }
        return this.fZS;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> bLH() {
        if (this.fWE == null) {
            this.fWE = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pushdialog.PushDialogActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: czE */
                public GifView makeObject() {
                    return new GifView(PushDialogActivity.this);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: g */
                public void destroyObject(GifView gifView) {
                    gifView.onDestroy();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: h */
                public GifView activateObject(GifView gifView) {
                    return gifView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: i */
                public GifView passivateObject(GifView gifView) {
                    gifView.release();
                    gifView.setImageDrawable(null);
                    gifView.bGn();
                    gifView.setBackgroundDrawable(null);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.fWE;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> bLI() {
        if (this.fZT == null) {
            this.fZT = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pushdialog.PushDialogActivity.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dpG */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(PushDialogActivity.this, PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dJ */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dK */
                public View activateObject(View view) {
                    ((PlayVoiceBntNew) view).cfq();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dL */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.fZT;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> bLJ() {
        if (this.fZU == null) {
            this.fZU = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pushdialog.PushDialogActivity.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dpI */
                public LinearLayout makeObject() {
                    LinearLayout linearLayout = new LinearLayout(PushDialogActivity.this);
                    linearLayout.setId(R.id.pb_text_voice_layout);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    linearLayout.setLayoutParams(layoutParams);
                    linearLayout.setGravity(16);
                    linearLayout.setBaselineAligned(true);
                    linearLayout.setOrientation(1);
                    linearLayout.setLayoutParams(layoutParams);
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: d */
                public void destroyObject(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: e */
                public LinearLayout activateObject(LinearLayout linearLayout) {
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: f */
                public LinearLayout passivateObject(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                    return linearLayout;
                }
            }, 15, 0);
        }
        return this.fZU;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> bLK() {
        this.fZV = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pushdialog.PushDialogActivity.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: dpH */
            public RelativeLayout makeObject() {
                return new RelativeLayout(PushDialogActivity.this);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
            public void destroyObject(RelativeLayout relativeLayout) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: d */
            public RelativeLayout activateObject(RelativeLayout relativeLayout) {
                return relativeLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: e */
            public RelativeLayout passivateObject(RelativeLayout relativeLayout) {
                return relativeLayout;
            }
        }, 10, 0);
        return this.fZV;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aF(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void g(Context context, String str, boolean z) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aG(Context context, String str) {
        finish();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aH(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aI(Context context, String str) {
        finish();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void u(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aJ(Context context, String str) {
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
        if (this.mIQ == null) {
            return null;
        }
        return this.mIQ.getTid();
    }

    /* loaded from: classes8.dex */
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
