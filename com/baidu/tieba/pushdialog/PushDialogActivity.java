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
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
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
    private com.baidu.adp.lib.d.b<ImageView> emM;
    private com.baidu.adp.lib.d.b<GifView> emN;
    private com.baidu.adp.lib.d.b<TextView> epE;
    private com.baidu.adp.lib.d.b<View> epF;
    private com.baidu.adp.lib.d.b<LinearLayout> epG;
    private com.baidu.adp.lib.d.b<RelativeLayout> epH;
    private com.baidu.tieba.v.b hzW;
    private c knv;
    private a knw;
    private com.baidu.tieba.ueg.b knx;
    private HomeWatcherReceiver knz;
    private boolean kny = false;
    private String knA = "push_dialog";
    private CustomMessageListener MO = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable() && PushDialogActivity.this.knv != null) {
                PushDialogActivity.this.knv.cMh();
            }
        }
    };
    private CustomMessageListener gZD = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.pushdialog.PushDialogActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PushDialogActivity.this.getPageContext().getUniqueId()) && !updateAttentionMessage.getData().isSucc) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(PushDialogActivity.this);
                    aVar.ui(PushDialogActivity.this.getString(R.string.push_dialog_attention_failed));
                    aVar.b(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pushdialog.PushDialogActivity.2.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            if (aVar2 != null && aVar2.isShowing()) {
                                aVar2.dismiss();
                            }
                        }
                    });
                    aVar.b(PushDialogActivity.this.getPageContext()).aMS();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.knA += "_1";
        TiebaStatic.eventStat(this, "push_dialog", this.knA);
        super.onCreate(bundle);
        this.hzW = com.baidu.tieba.screenlocknotify.a.cOV().kAk;
        if (this.knx == null) {
            this.knx = new com.baidu.tieba.ueg.b();
        }
        this.knx.ur(true);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        Window window = getWindow();
        if (getIntent().getBooleanExtra("need_show_lock", true)) {
            window.addFlags(524288);
        }
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        this.knv = new c(this, R.layout.activtiy_push_dialog);
        this.knw = new a(this);
        this.knw.loadData();
        registerListener(this.MO);
        this.knz = new HomeWatcherReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        registerReceiver(this.knz, intentFilter);
        registerListener(this.gZD);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.knA += "_2";
        TiebaStatic.eventStat(this, "push_dialog", this.knA);
        super.onResume();
        this.knv.onResume();
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
        this.knA += "_3";
        TiebaStatic.eventStat(this, "push_dialog", this.knA);
        this.kny = true;
        if (!z || aVar == null) {
            finish();
        } else if (this.knv != null) {
            this.knv.a(aVar);
            TiebaStatic.log(new an("c13197").cI("tid", getTid()));
            TiebaStatic.log(new an("c13196").af("obj_type", 2).af("obj_source", this.knw.getTaskId() != 0 ? 2 : 1).cI("tid", getTid()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.knA += "_4";
        TiebaStatic.eventStat(this, "push_dialog", this.knA);
        super.onPause();
        this.knv.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.knA += "_5";
        TiebaStatic.eventStat(this, "push_dialog", this.knA);
        if (!this.kny) {
            PushDialogActivityConfig pushDialogActivityConfig = new PushDialogActivityConfig(this, this.knw.getTaskId(), this.knw.getTid());
            pushDialogActivityConfig.getIntent().putExtra("need_show_lock", false);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, pushDialogActivityConfig));
        }
        super.onDestroy();
        this.knv.onDestroy();
        if (this.knz != null) {
            unregisterReceiver(this.knz);
        }
        if (this.knx != null) {
            this.knx.ur(false);
        }
    }

    public com.baidu.tieba.v.b cLX() {
        return this.hzW;
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
    public int bcM() {
        return R.id.push_dialog_content;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> bcN() {
        if (this.emM == null) {
            this.emM = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pushdialog.PushDialogActivity.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bcZ */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PushDialogActivity.this);
                    boolean isShowImages = i.aIc().isShowImages();
                    foreDrawableImageView.setDefaultBg(am.getDrawable(R.color.common_color_10220));
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
                /* renamed from: a */
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
                /* renamed from: b */
                public ImageView activateObject(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (i.aIc().isShowImages()) {
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
                /* renamed from: c */
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
        return this.emM;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> bcO() {
        if (this.epE == null) {
            this.epE = TbRichTextView.u(this, 8);
        }
        return this.epE;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> bcP() {
        if (this.emN == null) {
            this.emN = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pushdialog.PushDialogActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bJv */
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
                    gifView.aYi();
                    gifView.setBackgroundDrawable(null);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.emN;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> bcQ() {
        if (this.epF == null) {
            this.epF = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pushdialog.PushDialogActivity.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cyl */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(PushDialogActivity.this, PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cE */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cF */
                public View activateObject(View view) {
                    ((PlayVoiceBntNew) view).cXx();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cG */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.epF;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> bcR() {
        if (this.epG == null) {
            this.epG = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pushdialog.PushDialogActivity.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cyn */
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
                /* renamed from: c */
                public void destroyObject(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: d */
                public LinearLayout activateObject(LinearLayout linearLayout) {
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: e */
                public LinearLayout passivateObject(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                    return linearLayout;
                }
            }, 15, 0);
        }
        return this.epG;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> bcS() {
        this.epH = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pushdialog.PushDialogActivity.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cym */
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
        return this.epH;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void ak(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void e(Context context, String str, boolean z) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void al(Context context, String str) {
        finish();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void am(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void an(Context context, String str) {
        finish();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void t(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
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
        if (this.knw == null) {
            return null;
        }
        return this.knw.getTid();
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
