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
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.PersonChangeData;
import com.baidu.tieba.view.HeadImageView;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class PersonChangeActivity extends com.baidu.tieba.f {
    private Boolean b = false;
    private AlertDialog c = null;
    private int d = -1;
    private NavigationBar e = null;
    private ImageView f = null;
    private TextView g = null;
    private LinearLayout h = null;
    private ScrollView i = null;
    private TextView j = null;
    private LinearLayout k = null;
    private TextView l = null;
    private LinearLayout m = null;
    private LinearLayout n = null;
    private TextView o = null;
    private EditText p = null;
    private LinearLayout q = null;
    private TextView r = null;
    private TextView s = null;
    private TextView t = null;
    private InputMethodManager u = null;
    private boolean v = false;
    private com.baidu.tieba.model.bo w = null;
    protected HeadImageView a = null;
    private com.baidu.adp.widget.ImageView.b x = null;
    private cf y = null;
    private cg z = null;
    private ProgressBar A = null;
    private DialogInterface.OnCancelListener B = null;
    private com.baidu.tieba.util.i C = null;
    private Dialog D = null;
    private Dialog E = null;
    private boolean F = false;
    private int G = 0;
    private final int H = 50;
    private View.OnClickListener I = new bo(this);

    public static void a(Activity activity, int i, PersonChangeData personChangeData, Boolean bool) {
        Intent intent = new Intent(activity, PersonChangeActivity.class);
        intent.putExtra("data", personChangeData);
        intent.putExtra("isFromPersonInfo", bool);
        activity.startActivityForResult(intent, SocialAPIErrorCodes.ERROR_INVALID_CLIENT_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.person_change_activity);
        this.u = (InputMethodManager) getSystemService("input_method");
        this.B = new by(this);
        PersonChangeData personChangeData = bundle != null ? (PersonChangeData) bundle.getSerializable("data") : (PersonChangeData) getIntent().getSerializableExtra("data");
        if (personChangeData == null) {
            personChangeData = new PersonChangeData();
        }
        this.w = new com.baidu.tieba.model.bo(personChangeData);
        this.C = new com.baidu.tieba.util.i(this);
        this.d = TiebaApplication.g().ae();
        String[] strArr = {getString(R.string.take_photo), getString(R.string.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.operation));
        builder.setItems(strArr, new bz(this));
        if (this.c == null) {
            this.c = builder.create();
        }
        this.n = (LinearLayout) findViewById(R.id.photo_layout);
        this.a = (HeadImageView) findViewById(R.id.photo);
        this.a.setIsRound(true);
        this.a.setAutoChangeStyle(true);
        this.a.setDrawBorder(false);
        this.a.setOnClickListener(new ca(this));
        com.baidu.tieba.util.i iVar = this.C;
        this.x = com.baidu.tbadk.imageManager.e.a().b(this.w.a().getPortrait());
        this.a.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.a.setDefaultResource(0);
        this.a.setNightDefaultResource(0);
        this.a.setImageBitmap(com.baidu.tieba.util.n.a((int) R.drawable.person_photo));
        if (this.x != null) {
            this.x.a(this.a);
        } else {
            this.C.a(this.w.a().getPortrait(), new cb(this));
        }
        this.h = (LinearLayout) findViewById(R.id.parent);
        this.i = (ScrollView) findViewById(R.id.person_change_scroll);
        this.k = (LinearLayout) findViewById(R.id.person_sex);
        this.l = (TextView) findViewById(R.id.sex_show);
        this.e = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.e.a(getResources().getString(R.string.my_info));
        this.f = this.e.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.I);
        this.g = this.e.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(R.string.save));
        this.g.setOnClickListener(new cc(this));
        this.k.setOnClickListener(new cd(this));
        this.m = (LinearLayout) findViewById(R.id.intro_click);
        this.m.setOnClickListener(new ce(this));
        this.m.setOnTouchListener(new bp(this));
        this.j = (TextView) findViewById(R.id.nick_name_show);
        this.j.setText(this.w.a().getName());
        this.o = (TextView) findViewById(R.id.intro);
        if (this.w.a().getIntro() == null || this.w.a().getIntro().length() <= 0) {
            this.o.setText(getString(R.string.add_intro));
        } else {
            this.o.setText(this.w.a().getIntro());
        }
        this.p = (EditText) findViewById(R.id.edit);
        this.p.setText(this.w.a().getIntro());
        this.p.setOnFocusChangeListener(new bq(this));
        this.p.setOnTouchListener(new br(this));
        this.p.setOnClickListener(new bs(this));
        this.p.addTextChangedListener(new bt(this));
        if (this.w.a().getSex() == 1) {
            this.G = 1;
            this.l.setText(R.string.man);
        } else if (this.w.a().getSex() == 2) {
            this.G = 2;
            this.l.setText(R.string.woman);
        } else {
            this.l.setText(R.string.change_sex);
        }
        this.q = (LinearLayout) findViewById(R.id.intro_text_tip);
        this.r = (TextView) findViewById(R.id.intro_text_tip_num);
        this.s = (TextView) findViewById(R.id.intro_text_tip_divider);
        this.t = (TextView) findViewById(R.id.intro_text_tip_limit);
        b();
        this.A = (ProgressBar) findViewById(R.id.image_progress);
        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
        builder2.setMessage(getString(R.string.confirm_giveup));
        builder2.setPositiveButton(getString(R.string.alert_yes_button), new bu(this));
        builder2.setNeutralButton(getString(R.string.cancel), new bv(this));
        this.D = builder2.create();
        if (bundle != null) {
            this.b = Boolean.valueOf(bundle.getBoolean("isFromPersonInfo"));
        } else {
            this.b = Boolean.valueOf(getIntent().getBooleanExtra("isFromPersonInfo", false));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        if (this.y != null) {
            this.y.cancel();
        }
        if (this.z != null) {
            this.z.cancel();
        }
        if (this.A != null) {
            this.A.setVisibility(8);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.v = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.v) {
            a();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.p.getVisibility() == 0) {
            this.q.setVisibility(8);
            this.p.setVisibility(8);
            String replaceAll = this.p.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.o.setText(replaceAll);
            } else {
                this.o.setText(getString(R.string.add_intro));
            }
            if (this.w.a().getIntro() == null || !this.w.a().getIntro().equals(replaceAll)) {
                this.F = true;
            }
            this.w.a().setIntro(replaceAll);
            this.o.setVisibility(0);
            HidenSoftKeyPad(this.u, this.p);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void o(PersonChangeActivity personChangeActivity) {
        if (personChangeActivity.p.getVisibility() != 0) {
            personChangeActivity.o.setVisibility(8);
            personChangeActivity.p.setText(personChangeActivity.w.a().getIntro());
            personChangeActivity.p.setVisibility(0);
            personChangeActivity.p.setSelection(personChangeActivity.p.getText().length());
            personChangeActivity.p.requestFocus();
            personChangeActivity.ShowSoftKeyPad(personChangeActivity.u, personChangeActivity.p);
            personChangeActivity.a(300);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        this.i.postDelayed(new bx(this), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        BitmapDrawable bitmapDrawable;
        if (TiebaApplication.g().ae() == 1) {
            if (this.G == 1) {
                bitmapDrawable = (BitmapDrawable) getResources().getDrawable(R.drawable.icon_pop_boy_1);
            } else {
                if (this.G == 2) {
                    bitmapDrawable = (BitmapDrawable) getResources().getDrawable(R.drawable.icon_pop_girl_1);
                }
                bitmapDrawable = null;
            }
        } else if (this.G == 1) {
            bitmapDrawable = (BitmapDrawable) getResources().getDrawable(R.drawable.icon_pop_boy);
        } else {
            if (this.G == 2) {
                bitmapDrawable = (BitmapDrawable) getResources().getDrawable(R.drawable.icon_pop_girl);
            }
            bitmapDrawable = null;
        }
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            this.l.setCompoundDrawables(null, null, bitmapDrawable, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().a(i == 1);
        getLayoutMode().a(this.h);
        this.e.b(i);
        this.a.d();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.w.a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void t(PersonChangeActivity personChangeActivity) {
        int color;
        int color2;
        if (personChangeActivity.p.getText().toString().replaceAll("\\s*", "").length() >= 50) {
            color = personChangeActivity.getResources().getColor(R.color.person_change_up_limit_text);
            color2 = personChangeActivity.getResources().getColor(R.color.person_change_up_limit_text_1);
        } else {
            color = personChangeActivity.getResources().getColor(R.color.person_change_not_up_limit_text);
            color2 = personChangeActivity.getResources().getColor(R.color.person_change_not_up_limit_text_1);
        }
        if (personChangeActivity.d == 1) {
            personChangeActivity.r.setTextColor(color2);
            personChangeActivity.s.setTextColor(color2);
            personChangeActivity.t.setTextColor(color2);
            return;
        }
        personChangeActivity.r.setTextColor(color);
        personChangeActivity.s.setTextColor(color);
        personChangeActivity.t.setTextColor(color);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void m(PersonChangeActivity personChangeActivity) {
        if (personChangeActivity.w == null || personChangeActivity.w.a() == null) {
            return;
        }
        personChangeActivity.a();
        personChangeActivity.w.a().setIntro(personChangeActivity.p.getText().toString().replaceAll("\\s*", ""));
        personChangeActivity.w.a().setSex(personChangeActivity.G);
        if (personChangeActivity.z == null) {
            personChangeActivity.z = new cg(personChangeActivity, personChangeActivity.w);
            personChangeActivity.z.setPriority(3);
            personChangeActivity.z.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void n(PersonChangeActivity personChangeActivity) {
        if (personChangeActivity.E == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(personChangeActivity);
            String string = personChangeActivity.getString(R.string.man);
            String string2 = personChangeActivity.getString(R.string.woman);
            builder.setTitle(R.string.choose_sex);
            builder.setItems(new String[]{string, string2}, new bw(personChangeActivity, string, string2));
            personChangeActivity.E = builder.create();
            personChangeActivity.E.setCanceledOnTouchOutside(true);
        }
        personChangeActivity.E.show();
    }

    @Override // com.baidu.tieba.f, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a();
            this.I.onClick(null);
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
                    EditHeadActivity.a(this, 12001, 12010, null, TiebaApplication.y());
                    return;
                case 12002:
                    if (intent != null) {
                        EditHeadActivity.a(this, 12002, 12009, intent.getData(), TiebaApplication.y());
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    this.w.a().setPhotoChanged(true);
                    if (this.y != null) {
                        this.y.cancel();
                    }
                    this.x = null;
                    this.y = new cf(this, (byte) 0);
                    this.y.execute(new Object[0]);
                    ai.a(true);
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12009:
                    com.baidu.tieba.write.by.b(this);
                    return;
                case 12010:
                    com.baidu.tieba.write.by.a(this);
                    return;
                default:
                    return;
            }
        }
    }
}
