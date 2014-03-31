package com.baidu.tieba.person;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.act.EditHeadActivity;
import com.baidu.tieba.data.PersonChangeData;
/* loaded from: classes.dex */
public class PersonChangeActivity extends com.baidu.tbadk.a {
    private Boolean b = false;
    private AlertDialog c = null;
    private int d = -1;
    private NavigationBar e = null;
    private TextView f = null;
    private LinearLayout g = null;
    private ScrollView h = null;
    private TextView i = null;
    private LinearLayout j = null;
    private TextView k = null;
    private LinearLayout l = null;
    private TextView m = null;
    private EditText n = null;
    private LinearLayout o = null;
    private TextView p = null;
    private TextView q = null;
    private TextView r = null;
    private InputMethodManager s = null;
    private boolean t = false;
    private com.baidu.tieba.model.au u = null;
    protected HeadImageView a = null;
    private com.baidu.adp.widget.ImageView.b v = null;
    private bf w = null;
    private bg x = null;
    private ProgressBar y = null;
    private DialogInterface.OnCancelListener z = null;
    private com.baidu.tbadk.editortool.aa A = null;
    private Dialog B = null;
    private Dialog C = null;
    private boolean D = false;
    private int E = 0;
    private final int F = 50;
    private View.OnClickListener G = new ao(this);

    public static void a(Activity activity, int i, PersonChangeData personChangeData, Boolean bool) {
        Intent intent = new Intent(activity, PersonChangeActivity.class);
        intent.putExtra("data", personChangeData);
        intent.putExtra("isFromPersonInfo", bool);
        activity.startActivityForResult(intent, PersonInfoActivity.REQUSET_CHANGE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.a.i.person_change_activity);
        this.s = (InputMethodManager) getSystemService("input_method");
        this.z = new ay(this);
        PersonChangeData personChangeData = bundle != null ? (PersonChangeData) bundle.getSerializable("data") : (PersonChangeData) getIntent().getSerializableExtra("data");
        if (personChangeData == null) {
            personChangeData = new PersonChangeData();
        }
        this.u = new com.baidu.tieba.model.au(personChangeData);
        this.A = new com.baidu.tbadk.editortool.aa(this);
        this.d = TbadkApplication.j().l();
        String[] strArr = {getString(com.baidu.tieba.a.k.take_photo), getString(com.baidu.tieba.a.k.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(com.baidu.tieba.a.k.operation));
        builder.setItems(strArr, new az(this));
        if (this.c == null) {
            this.c = builder.create();
        }
        this.a = (HeadImageView) findViewById(com.baidu.tieba.a.h.photo);
        this.a.setIsRound(true);
        this.a.setAutoChangeStyle(true);
        this.a.setDrawBorder(false);
        this.a.setOnClickListener(new ba(this));
        com.baidu.tbadk.editortool.aa aaVar = this.A;
        this.v = com.baidu.tbadk.imageManager.e.a().b(this.u.a().getPortrait());
        this.a.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.a.setDefaultResource(0);
        this.a.setNightDefaultResource(0);
        this.a.setImageBitmap(com.baidu.tbadk.core.util.g.a(com.baidu.tieba.a.g.person_photo));
        if (this.v != null) {
            this.v.a(this.a);
        } else {
            this.A.a(this.u.a().getPortrait(), new bb(this));
        }
        this.g = (LinearLayout) findViewById(com.baidu.tieba.a.h.parent);
        this.h = (ScrollView) findViewById(com.baidu.tieba.a.h.person_change_scroll);
        this.j = (LinearLayout) findViewById(com.baidu.tieba.a.h.person_sex);
        this.k = (TextView) findViewById(com.baidu.tieba.a.h.sex_show);
        this.e = (NavigationBar) findViewById(com.baidu.tieba.a.h.view_navigation_bar);
        this.e.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.G);
        this.e.a(getResources().getString(com.baidu.tieba.a.k.my_info));
        this.f = this.e.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(com.baidu.tieba.a.k.save));
        this.f.setOnClickListener(new bc(this));
        this.j.setOnClickListener(new bd(this));
        this.l = (LinearLayout) findViewById(com.baidu.tieba.a.h.intro_click);
        this.l.setOnClickListener(new be(this));
        this.l.setOnTouchListener(new ap(this));
        this.i = (TextView) findViewById(com.baidu.tieba.a.h.nick_name_show);
        this.i.setText(this.u.a().getName());
        this.m = (TextView) findViewById(com.baidu.tieba.a.h.intro);
        if (this.u.a().getIntro() == null || this.u.a().getIntro().length() <= 0) {
            this.m.setText(getString(com.baidu.tieba.a.k.add_intro));
        } else {
            this.m.setText(this.u.a().getIntro());
        }
        this.n = (EditText) findViewById(com.baidu.tieba.a.h.edit);
        this.n.setText(this.u.a().getIntro());
        this.n.setOnFocusChangeListener(new aq(this));
        this.n.setOnTouchListener(new ar(this));
        this.n.setOnClickListener(new as(this));
        this.n.addTextChangedListener(new at(this));
        if (this.u.a().getSex() == 1) {
            this.E = 1;
            this.k.setText(com.baidu.tieba.a.k.man);
        } else if (this.u.a().getSex() == 2) {
            this.E = 2;
            this.k.setText(com.baidu.tieba.a.k.woman);
        } else {
            this.k.setText(com.baidu.tieba.a.k.change_sex);
        }
        this.o = (LinearLayout) findViewById(com.baidu.tieba.a.h.intro_text_tip);
        this.p = (TextView) findViewById(com.baidu.tieba.a.h.intro_text_tip_num);
        this.q = (TextView) findViewById(com.baidu.tieba.a.h.intro_text_tip_divider);
        this.r = (TextView) findViewById(com.baidu.tieba.a.h.intro_text_tip_limit);
        b();
        this.y = (ProgressBar) findViewById(com.baidu.tieba.a.h.image_progress);
        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
        builder2.setMessage(getString(com.baidu.tieba.a.k.confirm_giveup));
        builder2.setPositiveButton(getString(com.baidu.tieba.a.k.alert_yes_button), new au(this));
        builder2.setNeutralButton(getString(com.baidu.tieba.a.k.cancel), new av(this));
        this.B = builder2.create();
        if (bundle != null) {
            this.b = Boolean.valueOf(bundle.getBoolean("isFromPersonInfo"));
        } else {
            this.b = Boolean.valueOf(getIntent().getBooleanExtra("isFromPersonInfo", false));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        if (this.w != null) {
            this.w.cancel();
        }
        if (this.x != null) {
            this.x.cancel();
        }
        if (this.y != null) {
            this.y.setVisibility(8);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.t = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.t) {
            a();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.n.getVisibility() == 0) {
            this.o.setVisibility(8);
            this.n.setVisibility(8);
            String replaceAll = this.n.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.m.setText(replaceAll);
            } else {
                this.m.setText(getString(com.baidu.tieba.a.k.add_intro));
            }
            if (this.u.a().getIntro() == null || !this.u.a().getIntro().equals(replaceAll)) {
                this.D = true;
            }
            this.u.a().setIntro(replaceAll);
            this.m.setVisibility(0);
            HidenSoftKeyPad(this.s, this.n);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void o(PersonChangeActivity personChangeActivity) {
        if (personChangeActivity.n.getVisibility() != 0) {
            personChangeActivity.m.setVisibility(8);
            personChangeActivity.n.setText(personChangeActivity.u.a().getIntro());
            personChangeActivity.n.setVisibility(0);
            personChangeActivity.n.setSelection(personChangeActivity.n.getText().length());
            personChangeActivity.n.requestFocus();
            personChangeActivity.ShowSoftKeyPad(personChangeActivity.s, personChangeActivity.n);
            personChangeActivity.a(300);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        this.h.postDelayed(new ax(this), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        BitmapDrawable bitmapDrawable;
        if (TbadkApplication.j().l() == 1) {
            if (this.E == 1) {
                bitmapDrawable = (BitmapDrawable) getResources().getDrawable(com.baidu.tieba.a.g.icon_pop_boy_1);
            } else {
                if (this.E == 2) {
                    bitmapDrawable = (BitmapDrawable) getResources().getDrawable(com.baidu.tieba.a.g.icon_pop_girl_1);
                }
                bitmapDrawable = null;
            }
        } else if (this.E == 1) {
            bitmapDrawable = (BitmapDrawable) getResources().getDrawable(com.baidu.tieba.a.g.icon_pop_boy);
        } else {
            if (this.E == 2) {
                bitmapDrawable = (BitmapDrawable) getResources().getDrawable(com.baidu.tieba.a.g.icon_pop_girl);
            }
            bitmapDrawable = null;
        }
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            this.k.setCompoundDrawables(null, null, bitmapDrawable, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().a(i == 1);
        getLayoutMode().a(this.g);
        this.e.b(i);
        this.a.c();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.u.a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void t(PersonChangeActivity personChangeActivity) {
        int color;
        int color2;
        if (personChangeActivity.n.getText().toString().replaceAll("\\s*", "").length() >= 50) {
            color = personChangeActivity.getResources().getColor(com.baidu.tieba.a.e.person_change_up_limit_text);
            color2 = personChangeActivity.getResources().getColor(com.baidu.tieba.a.e.person_change_up_limit_text_1);
        } else {
            color = personChangeActivity.getResources().getColor(com.baidu.tieba.a.e.person_change_not_up_limit_text);
            color2 = personChangeActivity.getResources().getColor(com.baidu.tieba.a.e.person_change_not_up_limit_text_1);
        }
        if (personChangeActivity.d == 1) {
            personChangeActivity.p.setTextColor(color2);
            personChangeActivity.q.setTextColor(color2);
            personChangeActivity.r.setTextColor(color2);
            return;
        }
        personChangeActivity.p.setTextColor(color);
        personChangeActivity.q.setTextColor(color);
        personChangeActivity.r.setTextColor(color);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void m(PersonChangeActivity personChangeActivity) {
        if (personChangeActivity.u == null || personChangeActivity.u.a() == null) {
            return;
        }
        personChangeActivity.a();
        personChangeActivity.u.a().setIntro(personChangeActivity.n.getText().toString().replaceAll("\\s*", ""));
        personChangeActivity.u.a().setSex(personChangeActivity.E);
        if (personChangeActivity.x == null) {
            personChangeActivity.x = new bg(personChangeActivity, personChangeActivity.u);
            personChangeActivity.x.setPriority(3);
            personChangeActivity.x.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void n(PersonChangeActivity personChangeActivity) {
        if (personChangeActivity.C == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(personChangeActivity);
            String string = personChangeActivity.getString(com.baidu.tieba.a.k.man);
            String string2 = personChangeActivity.getString(com.baidu.tieba.a.k.woman);
            builder.setTitle(com.baidu.tieba.a.k.choose_sex);
            builder.setItems(new String[]{string, string2}, new aw(personChangeActivity, string, string2));
            personChangeActivity.C = builder.create();
            personChangeActivity.C.setCanceledOnTouchOutside(true);
        }
        personChangeActivity.C.show();
    }

    @Override // com.baidu.tbadk.a, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a();
            this.G.onClick(null);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 12001:
                    EditHeadActivity.a(this, 12001, 12010, null, TbadkApplication.N());
                    return;
                case 12002:
                    if (intent != null) {
                        EditHeadActivity.a(this, 12002, 12009, intent.getData(), TbadkApplication.N());
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    this.u.a().setPhotoChanged(true);
                    if (this.w != null) {
                        this.w.cancel();
                    }
                    this.v = null;
                    this.w = new bf(this, (byte) 0);
                    this.w.execute(new Object[0]);
                    r.a(true);
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12009:
                    com.baidu.tbadk.core.util.az.b(this);
                    return;
                case 12010:
                    com.baidu.tbadk.core.util.az.a(this);
                    return;
                default:
                    return;
            }
        }
    }
}
