package com.baidu.tieba.kn.shake;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.data.SendAloneVoteData;
import com.baidu.tieba.data.SendPKVoteData;
import com.baidu.tieba.model.bs;
import com.baidu.tieba.model.bu;
import com.baidu.tieba.model.bw;
import com.baidu.tieba.switchs.SwitchKey;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.al;
import com.baidu.tieba.util.av;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class VoteResultActivity extends com.baidu.tieba.j {

    /* renamed from: a  reason: collision with root package name */
    private q f1311a;
    private bs b;
    private boolean c;
    private boolean d;
    private bu e = new m(this);
    private bw f = new n(this);

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
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
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
        this.f1311a.b.setBackgroundResource(R.drawable.bg_share);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onStop() {
        super.onStop();
        this.f1311a.b.setBackgroundResource(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.b.cancelLoadData();
    }

    private void b() {
        this.f1311a = new q(this);
        this.f1311a.e();
        int a2 = this.b.a(this.b.f());
        this.f1311a.i().setText(new StringBuilder(String.valueOf(this.b.f())).toString());
        this.f1311a.j().setText(this.b.e());
        this.f1311a.k().setText(new StringBuilder(String.valueOf(a2)).toString());
        this.f1311a.h().setDefaultId(R.drawable.vote_share_default);
    }

    private void c() {
        SendAloneVoteData a2;
        int a3 = this.b.a(this.b.f());
        this.f1311a.i().setText(new StringBuilder(String.valueOf(this.b.f())).toString());
        this.f1311a.j().setText(this.b.e());
        this.f1311a.k().setText(new StringBuilder(String.valueOf(a3)).toString());
        this.f1311a.d();
        this.f1311a.f();
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
        this.b = new bs();
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
            TbImageView h = this.f1311a.h();
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
            case R.id.back /* 2131099729 */:
                g();
                return;
            case R.id.share_weixin /* 2131100364 */:
                if (e()) {
                    b(view.getId());
                    e(3);
                    return;
                }
                return;
            case R.id.share_qqfriend /* 2131100365 */:
                if (e()) {
                    b(view.getId());
                    e(4);
                    return;
                }
                return;
            case R.id.share_qqzone /* 2131100366 */:
                b(view.getId());
                e(2);
                return;
            case R.id.share_sina /* 2131100367 */:
                b(view.getId());
                e(1);
                return;
            default:
                return;
        }
    }

    private boolean e() {
        if (com.baidu.adp.lib.a.d.a().b(SwitchKey.MM) == 1) {
            UtilHelper.a((Context) this, (int) R.string.share_weixin_turn_off);
            return false;
        }
        return true;
    }

    private void b(int i) {
        switch (i) {
            case R.id.share_weixin /* 2131100364 */:
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
            case R.id.share_qqfriend /* 2131100365 */:
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
            case R.id.share_qqzone /* 2131100366 */:
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
            case R.id.share_sina /* 2131100367 */:
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
    @Override // com.baidu.tieba.j
    public void g() {
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
                    str = al.a(this.b.c(), new StringBuilder(String.valueOf(this.b.f())).toString(), a2.getShareId());
                    str2 = a2.getShareText();
                    break;
                case 2:
                    if (!this.c) {
                        c(R.string.share_no_data);
                        return;
                    }
                    SendPKVoteData b = this.b.b();
                    str = al.a(this.b.c(), new StringBuilder(String.valueOf(this.b.f())).toString(), b.getShareId());
                    str2 = b.getShareText();
                    break;
            }
            if (al.a(this).a(i)) {
                this.f1311a.b();
                this.f1311a.g();
                al.a(this).a(this, str, new p(this, i, str2));
            }
        } catch (Exception e) {
            av.b(getClass().getName(), "shareClick", e.toString());
        }
    }
}
