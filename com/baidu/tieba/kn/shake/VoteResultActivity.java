package com.baidu.tieba.kn.shake;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.data.SendAloneVoteData;
import com.baidu.tieba.data.SendPKVoteData;
import com.baidu.tieba.model.br;
import com.baidu.tieba.model.bt;
import com.baidu.tieba.model.bv;
import com.baidu.tieba.util.aa;
import com.baidu.tieba.util.aj;
import com.baidu.tieba.view.ImageViewDrawer;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class VoteResultActivity extends com.baidu.tieba.g {

    /* renamed from: a  reason: collision with root package name */
    private q f1246a;
    private br b;
    private boolean c;
    private boolean d;
    private bt e = new m(this);
    private bv f = new n(this);

    public static void a(Context context, String str, String str2, int i) {
        Intent intent = new Intent(context, VoteResultActivity.class);
        intent.putExtra("votetype", 1);
        intent.putExtra("playerId", str);
        intent.putExtra("shakeNumber", i);
        intent.putExtra("playerName", str2);
        context.startActivity(intent);
    }

    public static void a(Context context, String str, String str2, String str3, int i) {
        Intent intent = new Intent(context, VoteResultActivity.class);
        intent.putExtra("votetype", 2);
        intent.putExtra("pkId", str);
        intent.putExtra("playerName", str3);
        intent.putExtra("playerId", str2);
        intent.putExtra("shakeNumber", i);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(bundle);
        b();
        if (bundle == null) {
            d();
        } else {
            c();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.b.b(bundle);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.f1246a.b.setBackgroundResource(R.drawable.bg_share);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onStop() {
        super.onStop();
        this.f1246a.b.setBackgroundResource(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.b.cancelLoadData();
    }

    private void b() {
        this.f1246a = new q(this);
        this.f1246a.e();
        int a2 = this.b.a(this.b.f());
        this.f1246a.i().setText(new StringBuilder(String.valueOf(this.b.f())).toString());
        this.f1246a.j().setText(this.b.e());
        this.f1246a.k().setText(new StringBuilder(String.valueOf(a2)).toString());
        this.f1246a.h().setDefaultId(R.drawable.vote_share_default);
    }

    private void c() {
        SendAloneVoteData a2;
        int a3 = this.b.a(this.b.f());
        this.f1246a.i().setText(new StringBuilder(String.valueOf(this.b.f())).toString());
        this.f1246a.j().setText(this.b.e());
        this.f1246a.k().setText(new StringBuilder(String.valueOf(a3)).toString());
        this.f1246a.d();
        this.f1246a.f();
        int d = this.b.d();
        if (d == 2) {
            SendPKVoteData b = this.b.b();
            if (b != null) {
                this.c = true;
                c(b.getResultPic());
            }
        } else if (d == 1 && (a2 = this.b.a()) != null) {
            this.d = true;
            c(a2.getResultPic());
        }
    }

    private void a(Bundle bundle) {
        this.b = new br();
        this.b.a(this.e);
        this.b.a(this.f);
        if (bundle != null) {
            this.b.a(bundle);
        } else {
            this.b.a(getIntent());
        }
    }

    private void d() {
        this.b.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.util.a aVar = new com.baidu.tieba.util.a(this);
            ImageViewDrawer h = this.f1246a.h();
            aVar.a(h.getWidth(), h.getHeight());
            if (aVar.a(str, new o(this, str, h)) != null) {
                h.setTag(str);
                h.invalidate();
            }
        }
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back /* 2131099730 */:
                f();
                return;
            case R.id.share_weixin /* 2131100280 */:
                b(view.getId());
                e(3);
                return;
            case R.id.share_qqfriend /* 2131100281 */:
                b(view.getId());
                e(4);
                return;
            case R.id.share_qqzone /* 2131100282 */:
                b(view.getId());
                e(2);
                return;
            case R.id.share_sina /* 2131100283 */:
                b(view.getId());
                e(1);
                return;
            default:
                return;
        }
    }

    private void b(int i) {
        switch (i) {
            case R.id.share_weixin /* 2131100280 */:
                switch (this.b.d()) {
                    case 1:
                        StatService.onEvent(this, "kn_share_alone_weixi", "click");
                        return;
                    case 2:
                        StatService.onEvent(this, "kn_share_pks_weixin", "click");
                        return;
                    default:
                        return;
                }
            case R.id.share_qqfriend /* 2131100281 */:
                switch (this.b.d()) {
                    case 1:
                        StatService.onEvent(this, "kn_share_alone_qqfre", "click");
                        return;
                    case 2:
                        StatService.onEvent(this, "kn_share_pks_qqfre", "click");
                        return;
                    default:
                        return;
                }
            case R.id.share_qqzone /* 2131100282 */:
                switch (this.b.d()) {
                    case 1:
                        StatService.onEvent(this, "kn_share_alone_qzone", "click");
                        return;
                    case 2:
                        StatService.onEvent(this, "kn_share_pks_qzone", "click");
                        return;
                    default:
                        return;
                }
            case R.id.share_sina /* 2131100283 */:
                switch (this.b.d()) {
                    case 1:
                        StatService.onEvent(this, "kn_share_alone_weibo", "click");
                        return;
                    case 2:
                        StatService.onEvent(this, "kn_share_pks_weibo", "click");
                        return;
                    default:
                        return;
                }
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void f() {
        finish();
    }

    private void e(int i) {
        try {
            String str = "";
            String str2 = "";
            switch (this.b.d()) {
                case 1:
                    if (!this.d) {
                        c(R.string.share_no_data);
                        return;
                    }
                    SendAloneVoteData a2 = this.b.a();
                    str = aa.a(this.b.c(), new StringBuilder(String.valueOf(this.b.f())).toString(), a2.getShareId());
                    str2 = a2.getShareText();
                    break;
                case 2:
                    if (!this.c) {
                        c(R.string.share_no_data);
                        return;
                    }
                    SendPKVoteData b = this.b.b();
                    str = aa.a(this.b.c(), new StringBuilder(String.valueOf(this.b.f())).toString(), b.getShareId());
                    str2 = b.getShareText();
                    break;
            }
            if (aa.a(this).a(i)) {
                this.f1246a.b();
                this.f1246a.g();
                aa.a(this).a(this, str, new p(this, i, str2));
            }
        } catch (Exception e) {
            aj.b(getClass().getName(), "shareClick", e.toString());
        }
    }
}
