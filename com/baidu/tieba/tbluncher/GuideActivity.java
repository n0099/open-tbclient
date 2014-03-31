package com.baidu.tieba.tbluncher;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.mobstat.StatService;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.b.aa;
import com.baidu.tbadk.core.view.BaseViewPager;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class GuideActivity extends com.baidu.tbadk.a {
    private ArrayList<View> g;
    private h h;
    private BaseViewPager i;
    private List<Bitmap> k;
    private g d = null;
    private String e = null;
    private final int[] f = {com.baidu.b.a.e.image_bootpage01, com.baidu.b.a.e.image_bootpage02};
    private Button j = null;
    private boolean l = true;
    private final com.baidu.tbadk.core.view.a m = new b(this);
    public View.OnClickListener a = new c(this);
    public View.OnClickListener b = new d(this);
    public View.OnClickListener c = new e(this);
    private final ViewPager.OnPageChangeListener n = new f(this);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2015000, new a());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        com.baidu.adp.framework.c.a().a(customMessageTask);
    }

    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.b.a.g.guide_activity);
        this.h = new h(this, (byte) 0);
        this.i = (BaseViewPager) findViewById(com.baidu.b.a.f.guide_pager);
        this.i.setAdapter(this.h);
        this.i.setOnScrollOutListener(this.m);
        this.i.setOnPageChangeListener(this.n);
        this.k = new ArrayList();
        this.g = new ArrayList<>();
        for (int i = 0; i < this.f.length; i++) {
            Bitmap b = com.baidu.tbadk.core.util.g.b(this, this.f[i]);
            ImageView imageView = new ImageView(this);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setBackgroundColor(-1);
            imageView.setOnClickListener(this.c);
            imageView.setImageBitmap(b);
            this.k.add(b);
            this.g.add(i, imageView);
        }
        View inflate = LayoutInflater.from(this).inflate(com.baidu.b.a.g.guide_view_last, (ViewGroup) null);
        this.j = (Button) inflate.findViewById(com.baidu.b.a.f.last_page_btn);
        this.j.setOnClickListener(this.a);
        this.g.add(inflate);
        if (bundle != null) {
            this.e = bundle.getString("from_page");
        } else {
            this.e = getIntent().getStringExtra("from_page");
        }
        com.baidu.tbadk.core.g.a(this, "new_user_guide_pv");
        if (TbadkApplication.j().x()) {
            try {
                StatService.setAppChannel(com.baidu.tbadk.core.data.n.j());
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "onCreate", e.getMessage());
            }
        }
        if (this.e != null && this.e.equals("from_logo_page")) {
            this.d = new g(this, (byte) 0);
            this.d.setSelfExecute(true);
            this.d.execute(new String[0]);
            return;
        }
        this.d = null;
    }

    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f.length) {
                break;
            }
            View view = this.g.get(i2);
            if (view != null) {
                view.setBackgroundDrawable(null);
                if (view instanceof ImageView) {
                    ((ImageView) view).setImageBitmap(null);
                }
            }
            Bitmap bitmap = this.k.get(i2);
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            i = i2 + 1;
        }
        if (this.d != null) {
            this.d.cancel(true);
            this.d = null;
        }
    }

    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TbadkApplication.j().x()) {
            try {
                StatService.onResume(this);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "onResume", e.getMessage());
            }
        }
    }

    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onPause() {
        super.onPause();
        if (TbadkApplication.j().x()) {
            try {
                StatService.onPause(this);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "onPause", e.getMessage());
            }
        }
    }

    @Override // com.baidu.tbadk.a, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (!this.e.equals("from_about_page")) {
                    a();
                }
                closeActivity();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    public void a() {
        if (this.l) {
            boolean T = TbadkApplication.j().T();
            if (!T) {
                sendMessage(new com.baidu.adp.framework.message.a(2015001, new aa(this).a(1, false)));
            } else {
                com.baidu.adp.framework.c.a().a(new CustomResponsedMessage(2007006, null));
                sendMessage(new com.baidu.adp.framework.message.a(2015001, new aa(this).a(2, false)));
                if (T) {
                    TbadkApplication.j();
                    TbadkApplication.U();
                }
            }
            finish();
            this.l = false;
        }
    }

    public static /* synthetic */ void g(GuideActivity guideActivity) {
        Intent intent = new Intent();
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setAction("android.intent.action.MAIN");
        intent.setFlags(270532608);
        intent.setComponent(new ComponentName(guideActivity.getPackageName(), String.valueOf(guideActivity.getPackageName()) + ".LogoActivity"));
        Intent intent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent2.putExtra("duplicate", false);
        intent2.putExtra("android.intent.extra.shortcut.NAME", guideActivity.getString(com.baidu.b.a.h.app_name));
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(guideActivity, com.baidu.b.a.e.icon));
        guideActivity.sendBroadcast(intent2);
    }

    public boolean b() {
        String str;
        try {
            ContentResolver contentResolver = getContentResolver();
            if (Build.VERSION.SDK_INT < 8) {
                str = "content://com.android.launcher.settings/favorites?notify=true";
            } else {
                str = "content://com.android.launcher2.settings/favorites?notify=true";
            }
            Cursor query = contentResolver.query(Uri.parse(str), new String[]{"title", "iconResource"}, "title=?", new String[]{getString(com.baidu.b.a.h.app_name)}, null);
            if (query != null) {
                if (query.getCount() > 0) {
                    return true;
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.a(getClass().getName(), "checkShortCut", e.toString());
        }
        return false;
    }
}
