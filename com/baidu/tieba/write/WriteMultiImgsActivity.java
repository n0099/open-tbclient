package com.baidu.tieba.write;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.WriteImagesInfo;
/* loaded from: classes.dex */
public class WriteMultiImgsActivity extends com.baidu.tbadk.a implements CompoundButton.OnCheckedChangeListener, w {
    private WriteImagesInfo a = null;
    private View b = null;
    private ViewPager c = null;
    private v d = null;
    private LinearLayout e = null;
    private RadioButton f = null;
    private RadioButton g = null;
    private LinearLayout h = null;
    private View i = null;
    private NavigationBar j = null;
    private TextView k = null;
    private TextView l = null;
    private String m = "";
    private String n = "";
    private String o = "";
    private String p = "(1/1)";
    private boolean q = true;
    private int r = 0;

    static {
        TbadkApplication.j().a(com.baidu.tbadk.core.b.ax.class, WriteMultiImgsActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2;
        int i3 = 1;
        super.onCreate(bundle);
        int b = com.baidu.adp.lib.a.f.a().b("motu_sdk");
        if (Build.VERSION.SDK_INT < 7 || b == 1) {
            this.q = false;
        } else {
            this.q = true;
        }
        setContentView(com.baidu.tieba.a.i.write_multi_imgs_activity);
        this.m = getResources().getString(com.baidu.tieba.a.k.beautify);
        this.n = getResources().getString(com.baidu.tieba.a.k.rotate);
        this.o = this.m;
        this.b = findViewById(com.baidu.tieba.a.h.write_multi_imgs_rootlayout);
        this.c = (ViewPager) findViewById(com.baidu.tieba.a.h.write_multi_imgs_viewpager);
        this.e = (LinearLayout) findViewById(com.baidu.tieba.a.h.write_multi_imgs_beautify);
        this.f = (RadioButton) findViewById(com.baidu.tieba.a.h.beautify_btn);
        this.g = (RadioButton) findViewById(com.baidu.tieba.a.h.rotate_btn);
        this.f.setOnCheckedChangeListener(this);
        this.g.setOnCheckedChangeListener(this);
        this.h = (LinearLayout) findViewById(com.baidu.tieba.a.h.filters_layout);
        this.i = findViewById(com.baidu.tieba.a.h.rotate);
        Button button = (Button) findViewById(com.baidu.tieba.a.h.rotate_left);
        Button button2 = (Button) findViewById(com.baidu.tieba.a.h.rotate_right);
        Button button3 = (Button) findViewById(com.baidu.tieba.a.h.rotate_left_right);
        Button button4 = (Button) findViewById(com.baidu.tieba.a.h.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        bp bpVar = new bp(this);
        button.setOnClickListener(bpVar);
        button2.setOnClickListener(bpVar);
        button3.setOnClickListener(bpVar);
        button4.setOnClickListener(bpVar);
        this.j = (NavigationBar) findViewById(com.baidu.tieba.a.h.write_multi_imgs_navibar);
        this.j.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new bq(this));
        this.l = this.j.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(com.baidu.tieba.a.k.done), new br(this));
        this.k = this.j.a(getString(com.baidu.tieba.a.k.beautify));
        this.f.setChecked(true);
        if (!this.q) {
            this.g.setChecked(true);
            this.g.setPadding(0, this.g.getPaddingTop(), this.g.getPaddingRight(), this.g.getPaddingBottom());
            this.h.setVisibility(8);
            this.f.setVisibility(8);
        }
        String str = null;
        if (bundle != null) {
            str = bundle.getString("OutState_Write_Img_Info");
            i = bundle.getInt("OutState_Current_Index");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                str = intent.getStringExtra("WriteImgsInfoJsonStr");
                i = intent.getIntExtra("CurrentImgIndex", 0);
            } else {
                i = 0;
            }
        }
        if (str != null && i != -1) {
            this.a = new WriteImagesInfo();
            this.a.parseJson(str);
            this.d = new v(this, this.c, this.a.getChosedFiles(), i, this);
            this.c.setAdapter(this.d);
            this.c.setCurrentItem(i, true);
            if (i == 0) {
                this.d.onPageSelected(0);
            }
            this.e.setVisibility(0);
        }
        if (this.q) {
            if (this.a != null) {
                i3 = this.a.size();
                i2 = this.a.size();
            } else {
                i2 = 1;
            }
            TbadkApplication.j().a(i3, i2, "motu_pic");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("OutState_Current_Index", this.d.a());
        this.d.b();
        bundle.putString("OutState_Write_Img_Info", this.a.toJsonString());
        super.onSaveInstanceState(bundle);
    }

    @Override // com.baidu.tieba.write.w
    public final void a() {
        if (this.j.getVisibility() == 0) {
            this.j.setVisibility(8);
            this.e.setVisibility(8);
            return;
        }
        this.j.setVisibility(0);
        this.e.setVisibility(0);
    }

    @Override // com.baidu.tieba.write.w
    public final void a(com.baidu.tbadk.coreExtra.view.j jVar, int i) {
        this.h.removeAllViews();
        this.h.addView(jVar);
        this.p = "（" + (i + 1) + "/" + this.a.size() + "）";
        this.k.setText(String.valueOf(this.o) + this.p);
    }

    @Override // com.baidu.tieba.write.w
    public final void c() {
        this.r--;
    }

    @Override // com.baidu.tieba.write.w
    public final void b() {
        this.r++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(WriteMultiImgsActivity writeMultiImgsActivity) {
        writeMultiImgsActivity.d.b();
        Intent intent = new Intent();
        intent.putExtra("album_result", writeMultiImgsActivity.a.toJsonString());
        writeMultiImgsActivity.setResult(-1, intent);
        writeMultiImgsActivity.finish();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        setResult(0);
        finish();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            if (compoundButton == this.f) {
                this.h.setVisibility(0);
                this.i.setVisibility(8);
                this.o = this.m;
                this.k.setText(String.valueOf(this.o) + this.p);
                return;
            }
            this.h.setVisibility(8);
            this.i.setVisibility(0);
            this.o = this.n;
            this.k.setText(String.valueOf(this.o) + this.p);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        getLayoutMode().a(i == 1);
        getLayoutMode().a(this.b);
        this.j.b(i);
        if (i == 1) {
            if (this.l.isEnabled()) {
                com.baidu.tbadk.core.util.ba.e((View) this.l, com.baidu.tieba.a.g.navi_done_text_bg_1);
                this.l.setTextColor(getResources().getColorStateList(com.baidu.tieba.a.e.navi_done_text_1));
                return;
            }
            com.baidu.tbadk.core.util.ba.e((View) this.l, com.baidu.tieba.a.g.btn_titlebar_finish_d_1);
            this.l.setTextColor(getResources().getColor(com.baidu.tieba.a.e.navi_done_text_d_1));
        } else if (this.l.isEnabled()) {
            com.baidu.tbadk.core.util.ba.e((View) this.l, com.baidu.tieba.a.g.navi_done_text_bg);
            this.l.setTextColor(getResources().getColorStateList(com.baidu.tieba.a.e.navi_done_text));
        } else {
            com.baidu.tbadk.core.util.ba.e((View) this.l, com.baidu.tieba.a.g.btn_titlebar_finish_d);
            this.l.setTextColor(getResources().getColor(com.baidu.tieba.a.e.navi_done_text_d));
        }
    }
}
