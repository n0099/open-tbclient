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
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.PushDialogActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import d.a.c.e.p.j;
import d.a.i0.r.k;
import d.a.i0.r.s.a;
/* loaded from: classes4.dex */
public class PushDialogActivity extends BaseActivity<PushDialogActivity> implements Object {
    public d.a.j0.l3.b mCancelController;
    public d.a.c.e.k.b<GifView> mGifViewPool;
    public HomeWatcherReceiver mHomeWatcherReceiver;
    public d.a.c.e.k.b<ImageView> mImageViewPool;
    public d.a.c.e.k.b<RelativeLayout> mMemeViewPool;
    public d.a.j0.o2.a mModel;
    public d.a.c.e.k.b<TextView> mTextViewPool;
    public d.a.c.e.k.b<LinearLayout> mTextVoiceViewPool;
    public d.a.j0.o2.c mView;
    public d.a.c.e.k.b<View> mVoiceViewPool;
    public d.a.j0.p3.b screenLockUtils;
    public boolean hasNetBack = false;
    public String lifeSequence = "push_dialog";
    public CustomMessageListener mNetworkChangedListener = new a(2000994);
    public CustomMessageListener attentionListener = new b(2001115);

    /* loaded from: classes4.dex */
    public class HomeWatcherReceiver extends BroadcastReceiver {
        public static final String SYSTEM_DIALOG_REASON_ASSIST = "assist";
        public static final String SYSTEM_DIALOG_REASON_HOME_KEY = "homekey";
        public static final String SYSTEM_DIALOG_REASON_KEY = "reason";
        public static final String SYSTEM_DIALOG_REASON_LOCK = "lock";
        public static final String SYSTEM_DIALOG_REASON_RECENT_APPS = "recentapps";

        public HomeWatcherReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") || "lock".equals(intent.getStringExtra("reason"))) {
                return;
            }
            PushDialogActivity.this.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.z() && PushDialogActivity.this.mView != null) {
                PushDialogActivity.this.mView.e();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {

        /* loaded from: classes4.dex */
        public class a implements a.e {
            public a(b bVar) {
            }

            @Override // d.a.i0.r.s.a.e
            public void onClick(d.a.i0.r.s.a aVar) {
                if (aVar == null || !aVar.isShowing()) {
                    return;
                }
                aVar.dismiss();
            }
        }

        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() == null || updateAttentionMessage.getData().f13332c == null || (message = updateAttentionMessage.getmOrginalMessage()) == null || message.getTag() == null || !message.getTag().equals(PushDialogActivity.this.getPageContext().getUniqueId()) || updateAttentionMessage.getData().f13330a) {
                    return;
                }
                d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(PushDialogActivity.this);
                aVar.setMessage(PushDialogActivity.this.getString(R.string.push_dialog_attention_failed));
                aVar.setNegativeButton(R.string.confirm, new a(this));
                aVar.create(PushDialogActivity.this.getPageContext()).show();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.a.c.e.k.c<ImageView> {
        public c() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        public ImageView e(ImageView imageView) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                tbImageView.setTag(null);
                if (k.c().g()) {
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
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(ImageView imageView) {
            imageView.setBackgroundDrawable(null);
            imageView.setImageDrawable(null);
            imageView.setTag(null);
            imageView.setOnClickListener(null);
            if (imageView instanceof ForeDrawableImageView) {
                ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                foreDrawableImageView.Z();
                foreDrawableImageView.setForegroundDrawable(0);
                foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public ImageView d() {
            ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PushDialogActivity.this);
            boolean g2 = k.c().g();
            foreDrawableImageView.setDefaultBg(SkinManager.getDrawable(R.color.common_color_10220));
            if (g2) {
                foreDrawableImageView.setAdjustViewBounds(false);
                foreDrawableImageView.setInterceptOnClick(false);
            } else {
                foreDrawableImageView.setDefaultResource(R.drawable.icon_click);
                foreDrawableImageView.setAdjustViewBounds(true);
                foreDrawableImageView.setInterceptOnClick(true);
            }
            return foreDrawableImageView;
        }

        public ImageView h(ImageView imageView) {
            imageView.setBackgroundDrawable(null);
            imageView.setImageDrawable(null);
            imageView.setTag(null);
            imageView.setOnClickListener(null);
            if (imageView instanceof ForeDrawableImageView) {
                ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                foreDrawableImageView.Z();
                foreDrawableImageView.setForegroundDrawable(0);
                foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                foreDrawableImageView.Q();
            }
            return imageView;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements d.a.c.e.k.c<GifView> {
        public d() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ GifView c(GifView gifView) {
            GifView gifView2 = gifView;
            h(gifView2);
            return gifView2;
        }

        public GifView e(GifView gifView) {
            return gifView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(GifView gifView) {
            gifView.n0();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public GifView d() {
            return new GifView(PushDialogActivity.this);
        }

        public GifView h(GifView gifView) {
            gifView.r0();
            gifView.setImageDrawable(null);
            gifView.t0();
            gifView.setBackgroundDrawable(null);
            return gifView;
        }
    }

    /* loaded from: classes4.dex */
    public class e implements d.a.c.e.k.c<View> {
        public e() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ View a(View view) {
            View view2 = view;
            e(view2);
            return view2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ View c(View view) {
            View view2 = view;
            h(view2);
            return view2;
        }

        public View e(View view) {
            ((PlayVoiceBntNew) view).l();
            return view;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(View view) {
            ((PlayVoiceBntNew) view).k();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public View d() {
            PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(PushDialogActivity.this, PlayVoiceBntNew.PLAY_TYPE.NORMAL);
            playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
            return playVoiceBntNew;
        }

        public View h(View view) {
            ((PlayVoiceBntNew) view).k();
            return view;
        }
    }

    /* loaded from: classes4.dex */
    public class f implements d.a.c.e.k.c<LinearLayout> {
        public f() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ LinearLayout a(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            e(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ LinearLayout c(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            h(linearLayout2);
            return linearLayout2;
        }

        public LinearLayout e(LinearLayout linearLayout) {
            return linearLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(LinearLayout linearLayout) {
            linearLayout.removeAllViews();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public LinearLayout d() {
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

        public LinearLayout h(LinearLayout linearLayout) {
            linearLayout.removeAllViews();
            return linearLayout;
        }
    }

    /* loaded from: classes4.dex */
    public class g implements d.a.c.e.k.c<RelativeLayout> {
        public g() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ RelativeLayout a(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            e(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ RelativeLayout c(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            h(relativeLayout2);
            return relativeLayout2;
        }

        public RelativeLayout e(RelativeLayout relativeLayout) {
            return relativeLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(RelativeLayout relativeLayout) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public RelativeLayout d() {
            return new RelativeLayout(PushDialogActivity.this);
        }

        public RelativeLayout h(RelativeLayout relativeLayout) {
            return relativeLayout;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity, d.a.i0.k0.a
    public String getCurrentPageKey() {
        return "a059";
    }

    public d.a.c.e.k.b<GifView> getGifViewPool() {
        if (this.mGifViewPool == null) {
            this.mGifViewPool = new d.a.c.e.k.b<>(new d(), 20, 0);
        }
        return this.mGifViewPool;
    }

    public d.a.c.e.k.b<ImageView> getImageViewPool() {
        if (this.mImageViewPool == null) {
            this.mImageViewPool = new d.a.c.e.k.b<>(new c(), 8, 0);
        }
        return this.mImageViewPool;
    }

    public ListView getListView() {
        return null;
    }

    public d.a.c.e.k.b<RelativeLayout> getRelativeLayoutPool() {
        d.a.c.e.k.b<RelativeLayout> bVar = new d.a.c.e.k.b<>(new g(), 10, 0);
        this.mMemeViewPool = bVar;
        return bVar;
    }

    public int getRichTextViewId() {
        return R.id.push_dialog_content;
    }

    public d.a.j0.p3.b getScreenLockUtils() {
        return this.screenLockUtils;
    }

    public d.a.c.e.k.b<TextView> getTextViewPool() {
        if (this.mTextViewPool == null) {
            this.mTextViewPool = TbRichTextView.y(this, 8);
        }
        return this.mTextViewPool;
    }

    public d.a.c.e.k.b<LinearLayout> getTextVoiceViewPool() {
        if (this.mTextVoiceViewPool == null) {
            this.mTextVoiceViewPool = new d.a.c.e.k.b<>(new f(), 15, 0);
        }
        return this.mTextVoiceViewPool;
    }

    public String getTid() {
        d.a.j0.o2.a aVar = this.mModel;
        if (aVar == null) {
            return null;
        }
        return aVar.d();
    }

    public d.a.c.e.k.b<View> getVoiceViewPool() {
        if (this.mVoiceViewPool == null) {
            this.mVoiceViewPool = new d.a.c.e.k.b<>(new e(), 8, 0);
        }
        return this.mVoiceViewPool;
    }

    public void onAtClicked(Context context, String str) {
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String str = this.lifeSequence + SkinManager.nightSufix;
        this.lifeSequence = str;
        TiebaStatic.eventStat(this, "push_dialog", str);
        super.onCreate(bundle);
        this.screenLockUtils = d.a.j0.u2.a.j().f61429d;
        if (this.mCancelController == null) {
            this.mCancelController = new d.a.j0.l3.b();
        }
        this.mCancelController.g(true);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        Window window = getWindow();
        if (getIntent().getBooleanExtra("need_show_lock", true)) {
            window.addFlags(524288);
        }
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        this.mView = new d.a.j0.o2.c(this, R.layout.activtiy_push_dialog);
        d.a.j0.o2.a aVar = new d.a.j0.o2.a(this);
        this.mModel = aVar;
        aVar.e();
        registerListener(this.mNetworkChangedListener);
        this.mHomeWatcherReceiver = new HomeWatcherReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        registerReceiver(this.mHomeWatcherReceiver, intentFilter);
        registerListener(this.attentionListener);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        String str = this.lifeSequence + "_5";
        this.lifeSequence = str;
        TiebaStatic.eventStat(this, "push_dialog", str);
        if (!this.hasNetBack) {
            PushDialogActivityConfig pushDialogActivityConfig = new PushDialogActivityConfig(this, this.mModel.c(), this.mModel.d());
            pushDialogActivityConfig.getIntent().putExtra("need_show_lock", false);
            sendMessage(new CustomMessage(2002001, pushDialogActivityConfig));
        }
        super.onDestroy();
        this.mView.f();
        HomeWatcherReceiver homeWatcherReceiver = this.mHomeWatcherReceiver;
        if (homeWatcherReceiver != null) {
            unregisterReceiver(homeWatcherReceiver);
        }
        d.a.j0.l3.b bVar = this.mCancelController;
        if (bVar != null) {
            bVar.g(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 3) {
            finish();
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public void onLinkButtonClicked(Context context, String str) {
    }

    public void onLinkClicked(Context context, String str, boolean z) {
    }

    public void onNetCallback(boolean z, d.a.j0.o2.d.a aVar) {
        String str = this.lifeSequence + "_3";
        this.lifeSequence = str;
        TiebaStatic.eventStat(this, "push_dialog", str);
        this.hasNetBack = true;
        if (z && aVar != null) {
            d.a.j0.o2.c cVar = this.mView;
            if (cVar != null) {
                cVar.i(aVar);
                TiebaStatic.log(new StatisticItem("c13197").param("tid", getTid()));
                TiebaStatic.log(new StatisticItem("c13196").param("obj_type", 2).param("obj_source", this.mModel.c() != 0 ? 2 : 1).param("tid", getTid()));
                return;
            }
            return;
        }
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        String str = this.lifeSequence + "_4";
        this.lifeSequence = str;
        TiebaStatic.eventStat(this, "push_dialog", str);
        super.onPause();
        this.mView.g();
    }

    public void onPhoneClicked(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        String str = this.lifeSequence + SkinManager.darkSuffix;
        this.lifeSequence = str;
        TiebaStatic.eventStat(this, "push_dialog", str);
        super.onResume();
        this.mView.h();
    }

    public void onSongClicked(Context context, String str) {
    }

    public void onVideoClicked(Context context, String str) {
        finish();
    }

    public void onVideoP2PClicked(Context context, String str) {
        finish();
    }
}
