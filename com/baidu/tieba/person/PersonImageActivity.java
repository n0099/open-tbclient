package com.baidu.tieba.person;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ProgressBar;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.MultiImageView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PersonImageActivity extends com.baidu.tieba.f {
    private ProgressBar a = null;
    private cl b = null;
    private MultiImageView c = null;
    private View.OnClickListener d = null;
    private View.OnLongClickListener e = null;
    private DialogInterface.OnClickListener f = null;
    private com.baidu.tieba.view.a g = null;
    private String h;
    private Context i;

    public static void a(Context context, String str) {
        if (context != null) {
            Intent intent = new Intent(context, PersonImageActivity.class);
            intent.putExtra("curImgUrl", str);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TiebaApplication.g().a((com.baidu.tieba.f) this);
        setContentView(R.layout.person_image_activity);
        a(bundle);
        a();
        ArrayList<String> arrayList = new ArrayList<>();
        this.i = this;
        arrayList.add(this.h);
        this.c.setIsFromCDN(true);
        this.c.setAllowLocalUrl(true);
        this.c.setUrlData(arrayList);
        this.c.a(0, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.c.setBackgroundColor(com.baidu.tieba.util.bq.d(i));
        } else {
            this.c.setBackgroundColor(-16777216);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onPause() {
        super.onPause();
        this.c.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onResume() {
        super.onResume();
        this.c.a();
    }

    @Override // com.baidu.tieba.f, com.baidu.adp.a.a
    public void releaseResouce() {
        this.c.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        TiebaApplication.g().b((com.baidu.tieba.f) this);
        this.c.c();
        if (this.b != null) {
            this.b.cancel();
            this.b = null;
        }
        if (this.a != null) {
            this.a.setVisibility(8);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.f, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void a() {
        this.d = new ch(this);
        this.e = new ci(this);
        this.f = new cj(this);
        this.g = new ck(this);
        this.a = (ProgressBar) findViewById(R.id.progress);
        this.c = (MultiImageView) findViewById(R.id.viewpager);
        this.c.setPageMargin(BdUtilHelper.a((Context) this, 8.0f));
        this.c.a(2, com.baidu.tieba.data.i.t() * com.baidu.tieba.data.i.t());
        this.c.setItemOnclickListener(this.d);
        this.c.setItemOnLongClickListener(this.e);
        this.c.a(0, false);
        this.c.setOnScrollOutListener(this.g);
        this.c.setHasNext(false);
        this.c.setNextTitle("mNextTitle");
        this.c.setHeadImage(true);
    }

    private void a(Bundle bundle) {
        if (bundle != null) {
            com.baidu.adp.lib.util.f.e(" have savedInstanceState");
            this.h = bundle.getString("curImgUrl");
            return;
        }
        com.baidu.adp.lib.util.f.e(" not have savedInstanceState");
        Intent intent = getIntent();
        if (intent != null) {
            this.h = intent.getStringExtra("curImgUrl");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("curImgUrl", this.h);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.c.a(0, true);
    }
}
