package com.baidu.tieba.write;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.data.emotions.WritableEmotionGroup;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
import com.baidu.tieba.model.bc;
import com.baidu.tieba.service.TiebaPrepareImageService;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.bs;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.bn;
import com.baidu.tieba.voice.VoiceManager;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class WriteActivity extends com.baidu.tieba.j implements com.baidu.tieba.voice.af {
    private com.baidu.tieba.util.i C;
    private VoiceManager H;
    private Toast w;
    private WriteData b = null;
    private boolean c = false;
    private boolean d = false;
    private InputMethodManager e = null;
    private EditText f = null;
    private FrameLayout g = null;
    private EditText h = null;
    private AlertDialog i = null;
    private com.baidu.tieba.model.ba j = null;
    final KeyEvent a = new KeyEvent(0, 67);
    private NavigationBar k = null;
    private ImageView l = null;
    private TextView m = null;
    private TextView n = null;
    private am o = null;
    private DialogInterface.OnCancelListener p = null;
    private AlertDialog q = null;
    private Handler r = new Handler();
    private boolean s = false;
    private String t = null;
    private RelativeLayout u = null;
    private LinearLayout v = null;
    private String x = null;
    private WriteEditorToolButtonContainer y = null;
    private EditorToolComponetContainer z = null;
    private WriteImagePreview A = null;
    private LinearLayout B = null;
    private Runnable D = new t(this);
    private View.OnClickListener E = new ad(this);
    private boolean F = true;
    private View.OnFocusChangeListener G = new ae(this);
    private bc I = new ac(this);

    @Override // com.baidu.tieba.j
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        super.showLoadingDialog(str, onCancelListener);
        this.mWaitingDialog.setCanceledOnTouchOutside(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (!this.F) {
            this.y.a();
        } else {
            this.y.b();
        }
    }

    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        d_().c(this);
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        d_().b((Activity) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onStop() {
        super.onStop();
        this.z.t();
        d_().f(this);
    }

    public static void a(Activity activity, String str, String str2, AntiData antiData, boolean z, String str3) {
        a(activity, 0, str, str2, null, null, 0, antiData, 13003, false, false, null, false, z, str3);
    }

    public static void a(Activity activity, String str, String str2, AntiData antiData) {
        antiData.setIfVoice(false);
        a(activity, 0, str, str2, null, null, 0, antiData, 13003, true, false, null, false, false, null);
    }

    public static void a(Activity activity, String str, String str2, String str3, AntiData antiData, String str4) {
        a(activity, 1, str, str2, str3, null, 0, antiData, 13002, false, false, null, false, true, str4);
    }

    public static void a(Activity activity, String str, String str2, String str3, String str4, int i, String str5, AntiData antiData, boolean z) {
        if (str4 != null) {
            a(activity, 2, str, str2, str3, str4, i, antiData, 13001, false, z, str5, false, false, null);
        } else {
            a(activity, 1, str, str2, str3, null, i, antiData, 13002, false, z, str5, false, false, null);
        }
    }

    private static void a(Activity activity, int i, String str, String str2, String str3, String str4, int i2, AntiData antiData, int i3, boolean z, boolean z2, String str5, boolean z3, boolean z4, String str6) {
        if (antiData != null && antiData.getIfpost() == 0) {
            com.baidu.adp.lib.g.g.a((Context) activity, antiData.getForbid_info());
            return;
        }
        Intent intent = new Intent(activity, WriteActivity.class);
        intent.putExtra("type", i);
        intent.putExtra("forum_id", str);
        intent.putExtra("forum_name", str2);
        intent.putExtra("reply_sub_pb", z2);
        intent.putExtra("is_ad", z3);
        if (antiData != null) {
            intent.putExtra("enable_audio", antiData.isIfvoice());
            intent.putExtra("disable_audio_message", antiData.getVoice_message());
        }
        if (str6 != null) {
            intent.putExtra("file_name", str6);
        }
        intent.putExtra("refresh_pic", z4);
        if (z) {
            intent.putExtra("feed_back", true);
        }
        if (str3 != null) {
            intent.putExtra("thread_id", str3);
        }
        if (str4 != null) {
            intent.putExtra("floor_id", str4);
        }
        if (i2 > 0) {
            intent.putExtra("floor_num", i2);
        }
        if (str5 != null) {
            intent.putExtra("sub_user_name", str5);
        }
        activity.startActivityForResult(intent, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.e = (InputMethodManager) getSystemService("input_method");
        this.C = new com.baidu.tieba.util.i(this);
        a(bundle);
        p();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.a();
        if (this.o != null) {
            this.o.cancel();
            this.o = null;
        }
        r();
        this.A.c();
        TiebaApplication.h().aN();
        super.onDestroy();
        d_().g(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.b != null && this.b.getType() == 2 && this.s) {
            finish();
        } else if (this.q != null && (this.f.getText().toString().length() > 0 || this.h.getText().toString().length() > 0)) {
            if (this.d) {
                this.q.show();
                this.q.setCanceledOnTouchOutside(true);
                Button button = this.q.getButton(-3);
                if (button != null) {
                    ViewGroup.LayoutParams layoutParams = button.getLayoutParams();
                    layoutParams.width = -2;
                    button.setLayoutParams(layoutParams);
                }
                Button button2 = this.q.getButton(-2);
                if (button2 != null) {
                    ViewGroup.LayoutParams layoutParams2 = button2.getLayoutParams();
                    layoutParams2.width = -2;
                    button2.setLayoutParams(layoutParams2);
                }
                Button button3 = this.q.getButton(-1);
                if (button3 != null) {
                    ViewGroup.LayoutParams layoutParams3 = button3.getLayoutParams();
                    layoutParams3.width = -2;
                    button3.setLayoutParams(layoutParams3);
                    return;
                }
                return;
            }
            finish();
        } else {
            if (this.b.getHaveDraft()) {
                DatabaseService.a(this.b);
            }
            finish();
        }
    }

    @Override // com.baidu.tieba.j, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.z.j()) {
                this.y.c();
                this.z.k();
                return false;
            }
            o();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        int color;
        int color2;
        super.onChangeSkinType(i);
        getLayoutMode().a(i == 1);
        getLayoutMode().a((View) this.u);
        this.k.c(i);
        bs.h(this.m, i);
        n();
        if (i == 1) {
            this.f.setBackgroundColor(getResources().getColor(R.color.write_title_bg_1));
            this.g.setBackgroundColor(getResources().getColor(R.color.write_line1_1));
            this.h.setBackgroundColor(getResources().getColor(R.color.write_content_bg_1));
            color = getResources().getColor(R.color.write_text_1);
            color2 = getResources().getColor(R.color.write_hint_text_1);
        } else {
            this.g.setBackgroundColor(getResources().getColor(R.color.write_line1));
            this.f.setBackgroundColor(getResources().getColor(R.color.write_title_bg));
            this.h.setBackgroundColor(getResources().getColor(R.color.write_content_bg));
            color = getResources().getColor(R.color.write_text);
            color2 = getResources().getColor(R.color.write_hint_text);
        }
        this.y.a(i);
        this.f.setTextColor(color);
        this.h.setTextColor(color);
        a(this.f, color2);
        a(this.h, color2);
        t();
        this.z.a(i);
    }

    private void a(EditText editText, int i) {
        Editable text = editText.getText();
        int selectionStart = editText.getSelectionStart();
        int selectionEnd = editText.getSelectionEnd();
        editText.setText((CharSequence) null);
        editText.setHintTextColor(i);
        editText.setText(text);
        editText.setSelection(selectionStart, selectionEnd);
    }

    private void p() {
        setContentView(R.layout.write_activity);
        this.k = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.n = this.k.a("");
        this.l = this.k.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.m = this.k.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(R.string.send));
        this.m.setOnFocusChangeListener(this.G);
        this.v = (LinearLayout) findViewById(R.id.tool_view);
        this.u = (RelativeLayout) findViewById(R.id.parent);
        a();
        this.g = (FrameLayout) findViewById(R.id.interval_view);
        e();
        this.r.postDelayed(this.D, 200L);
        g();
        this.l.setOnFocusChangeListener(this.G);
        this.l.setOnClickListener(new af(this));
        k();
        h();
        c();
        if (this.b.getType() == 0) {
            if (this.c) {
                this.n.setText(R.string.feedback);
            } else {
                this.n.setText(R.string.post_new_thread);
            }
            this.f.setVisibility(0);
        } else {
            this.n.setText(R.string.send_reply);
            this.h.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
            this.f.setVisibility(8);
        }
        d();
        t();
        u();
        q();
        b();
        a(s());
        n();
    }

    protected void a() {
        this.A = (WriteImagePreview) findViewById(R.id.image_preview);
        this.A.setOnActionListener(new ag(this));
    }

    protected void b() {
        String[] strArr = {getString(R.string.take_photo), getString(R.string.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.operation));
        builder.setItems(strArr, new ah(this));
        if (this.i == null) {
            this.i = builder.create();
            this.i.setCanceledOnTouchOutside(true);
        }
    }

    protected void c() {
        this.m.setOnClickListener(new ai(this));
    }

    protected void d() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.is_save_draft)).setCancelable(false).setPositiveButton(getString(R.string.save), new ak(this)).setNeutralButton(getString(R.string.not_save), new aj(this));
        this.q = builder.create();
    }

    protected void e() {
        this.f = (EditText) findViewById(R.id.post_title);
        this.f.setOnClickListener(this.E);
        this.f.setOnFocusChangeListener(this.G);
        if (this.b.getType() == 0) {
            if (this.b.getTitle() != null) {
                this.f.setText(this.b.getTitle());
            } else if (this.c) {
                this.f.setText(getResources().getString(R.string.android_feedback));
                this.f.setSelection(getResources().getString(R.string.android_feedback).length());
            }
        } else if (this.b.getType() == 1 || this.b.getType() != 2) {
        }
        this.f.addTextChangedListener(new u(this));
    }

    protected void g() {
        this.h = (EditText) findViewById(R.id.post_content);
        this.h.setOnClickListener(this.E);
        if (this.b.getContent() != null && this.b.getContent().length() > 0) {
            this.h.setText(TbFaceManager.a().a(this, this.b.getContent()));
        } else if (this.b.getType() == 2) {
            if (this.s) {
                if (this.t != null && this.t.length() > 0) {
                    this.h.setText(getString(R.string.reply_sub_floor, new Object[]{this.t}));
                    this.h.setSelection(this.h.getText().length());
                }
            } else if (this.b.getFloorNum() > 0) {
                String format = String.format(getString(R.string.reply_x_floor), Integer.valueOf(this.b.getFloorNum()));
                this.h.setText(format);
                this.h.setSelection(format.length());
            }
        } else if (this.b.getType() == 0 && this.c) {
            StringBuffer stringBuffer = new StringBuffer(30);
            stringBuffer.append(getResources().getString(R.string.tieba_client));
            stringBuffer.append(com.baidu.tieba.data.h.j());
            stringBuffer.append(", ");
            stringBuffer.append(Build.VERSION.RELEASE);
            stringBuffer.append(", ");
            stringBuffer.append(Build.MODEL);
            stringBuffer.append(", ");
            UtilHelper.NetworkStateInfo g = UtilHelper.g(this);
            if (g == UtilHelper.NetworkStateInfo.WIFI) {
                stringBuffer.append("WIFI");
            } else if (g == UtilHelper.NetworkStateInfo.ThreeG) {
                stringBuffer.append("3G");
            } else if (g == UtilHelper.NetworkStateInfo.TwoG) {
                stringBuffer.append("2G");
            } else {
                stringBuffer.append("UNKNOWN");
            }
            stringBuffer.append(":");
            this.h.setText(stringBuffer);
        }
        this.h.setOnFocusChangeListener(this.G);
        this.h.setOnTouchListener(new v(this));
        this.h.addTextChangedListener(new w(this));
    }

    protected void h() {
        this.z = (EditorToolComponetContainer) findViewById(R.id.tool_group);
        this.z.setFrom(1);
        this.z.setOnActionListener(new x(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i() {
        this.y.c();
        if (this.z.j()) {
            this.z.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j() {
        this.z.c(this.h);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i) {
        if (this.z.j()) {
            b(i);
            return;
        }
        this.z.b(this.f);
        this.z.b(this.h);
        new Handler().postDelayed(new y(this, i), 200L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i) {
        if (i == 2) {
            this.z.m();
        } else if (i == 5) {
            this.z.n();
        } else if (i == 8) {
            this.z.o();
        }
    }

    protected void k() {
        this.y = (WriteEditorToolButtonContainer) findViewById(R.id.write_eidtor_tool_buttons);
        this.B = (LinearLayout) findViewById(R.id.mGallery);
        this.y.b();
        this.y.setAtFocusable(false);
        this.y.setOnActionListener(new z(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.editortool.q qVar) {
        if (((ImageSpan[]) this.h.getText().getSpans(0, this.h.getText().length(), ImageSpan.class)).length >= 10) {
            if (this.w == null) {
                this.w = Toast.makeText(this, (int) R.string.too_many_face, 0);
            }
            this.w.show();
            return;
        }
        String a = qVar.a();
        WritableEmotionGroup.EmotionGroupType b = qVar.b();
        if (a != null) {
            int selectionStart = this.h.getSelectionStart();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(a);
            com.baidu.adp.widget.ImageView.d a2 = this.C.a(a, false, (com.baidu.tbadk.imageManager.c) new aa(this, spannableStringBuilder, selectionStart, b));
            if (a2 != null) {
                a(spannableStringBuilder, selectionStart, a2, b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.d dVar, WritableEmotionGroup.EmotionGroupType emotionGroupType) {
        Bitmap h = dVar.h();
        bn bnVar = new bn(h);
        bnVar.setBounds(0, 0, h.getWidth() + 1, h.getHeight());
        bnVar.setGravity(3);
        spannableStringBuilder.setSpan(new ImageSpan(bnVar, 0), 0, spannableStringBuilder.length(), 33);
        this.h.getText().insert(i, spannableStringBuilder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l() {
        this.h.onKeyDown(67, this.a);
    }

    private void a(Boolean bool) {
        String str = null;
        if (this.b != null) {
            str = this.b.getForumName();
        }
        if (com.baidu.tieba.f.a.a(str, bool)) {
            this.y.a(true);
        } else {
            this.y.a(false);
        }
    }

    private void q() {
        d_().a((Activity) this);
    }

    private void r() {
        try {
            if (this.q != null && this.q.isShowing()) {
                this.q.dismiss();
            }
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b(getClass().getName(), "closeDialog", e.getMessage());
        }
    }

    private Boolean s() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("enable_audio")) {
                bool = Boolean.valueOf(intent.getBooleanExtra("enable_audio", true));
            }
            if (intent.hasExtra("disable_audio_message")) {
                this.x = intent.getStringExtra("disable_audio_message");
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        String trim;
        if (this.b.getType() == 0) {
            trim = this.f.getText().toString().trim();
        } else {
            if (this.A.f()) {
                trim = SocialConstants.TRUE;
            } else {
                trim = this.h.getText().toString().trim();
            }
            if (this.z.q()) {
                trim = SocialConstants.TRUE;
            }
        }
        if (this.A.b() || trim == null || trim.length() <= 0) {
            this.m.setEnabled(false);
            if (this.mSkinType == 1) {
            }
            return;
        }
        this.m.setEnabled(true);
        if (this.mSkinType == 1) {
        }
    }

    private void a(Bundle bundle) {
        int intExtra;
        this.p = new ab(this);
        this.b = new WriteData();
        if (bundle != null) {
            this.b.setType(bundle.getInt("type", 0));
            this.b.setForumId(bundle.getString("forum_id"));
            this.b.setForumName(bundle.getString("forum_name"));
            this.b.setThreadId(bundle.getString("thread_id"));
            this.b.setFloor(bundle.getString("floor_id"));
            intExtra = bundle.getInt("floor_num", 0);
            this.b.setFloorNum(intExtra);
            this.c = bundle.getBoolean("feed_back", false);
            this.s = bundle.getBoolean("reply_sub_pb", false);
            this.t = bundle.getString("sub_user_name");
        } else {
            Intent intent = getIntent();
            this.b.setType(intent.getIntExtra("type", 0));
            this.b.setForumId(intent.getStringExtra("forum_id"));
            this.b.setForumName(intent.getStringExtra("forum_name"));
            this.b.setThreadId(intent.getStringExtra("thread_id"));
            this.b.setFloor(intent.getStringExtra("floor_id"));
            intExtra = intent.getIntExtra("floor_num", 0);
            this.b.setFloorNum(intExtra);
            this.c = intent.getBooleanExtra("feed_back", false);
            this.s = intent.getBooleanExtra("reply_sub_pb", false);
            this.t = intent.getStringExtra("sub_user_name");
        }
        WriteData a = DatabaseService.a(this.b.getType(), this.b.getForumId(), this.b.getThreadId(), this.b.getFloor());
        if (a != null) {
            this.b = a;
            this.b.setFloorNum(intExtra);
            this.b.setHaveDraft(true);
        }
        this.j = new com.baidu.tieba.model.ba(this);
        this.j.a(this.I);
    }

    private void u() {
        if (getIntent().getBooleanExtra("refresh_pic", false)) {
            if (getIntent().getStringExtra("file_name") != null) {
                this.A.a(getIntent().getStringExtra("file_name"));
            } else {
                this.A.a("tieba_resized_image_display");
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.b.getType());
        bundle.putString("forum_id", this.b.getForumId());
        bundle.putString("forum_name", this.b.getForumName());
        bundle.putString("thread_id", this.b.getThreadId());
        bundle.putString("floor_id", this.b.getFloor());
        bundle.putInt("floor_num", this.b.getFloorNum());
        bundle.putBoolean("reply_sub_pb", this.s);
        if (this.c) {
            bundle.putBoolean("feed_back", true);
        }
        super.onSaveInstanceState(bundle);
        d_().e(this);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = this.h.getEditableText().toString();
        if (obj != null) {
            this.h.setText(TbFaceManager.a().a(this, obj));
        }
    }

    public void m() {
        this.b.setTitle(this.f.getText().toString());
        this.b.setContent(this.h.getText().toString());
        showLoadingDialog(getString(R.string.sending), this.p);
        if (this.o != null) {
            this.o.cancel();
        }
        this.b.setVcode(null);
        this.o = new am(this, this.b);
        this.o.setPriority(3);
        this.o.execute(0);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 12003) {
                if (intent.getBooleanExtra("delete", false)) {
                    this.A.e();
                    return;
                }
                if (intent.getBooleanExtra("change", false)) {
                    if (intent.getStringExtra("file_name") != null) {
                        this.A.a(intent.getStringExtra("file_name"));
                    } else {
                        this.A.a("tieba_resized_image");
                    }
                }
                t();
            } else if (i == 12010 || i == 12009) {
                if (intent.getStringExtra("file_name") != null) {
                    this.A.a(intent.getStringExtra("file_name"));
                } else {
                    this.A.a("tieba_resized_image");
                }
                t();
                if (!this.z.j()) {
                    ShowSoftKeyPadDelay(this.h, 300);
                }
            } else if (i == 12004) {
                String a = AtListActivity.a(intent);
                if (a != null) {
                    this.h.getText().insert(this.h.getSelectionStart(), "@" + a + " ");
                }
            } else if (i == 12006) {
                DatabaseService.a(this.b);
                setResult(-1);
                finish();
            } else {
                this.A.c();
                if (i == 12002) {
                    if (intent != null && intent.getData() != null) {
                        WriteImageActivity.a(this, 12002, 12009, intent.getData(), null, null, null);
                    } else {
                        bb.c(this);
                    }
                } else if (i == 12001) {
                    WriteImageActivity.a(this, 12001, 12010, null, null, null, null);
                }
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12001:
                case 12002:
                    this.i.show();
                    return;
                case 12009:
                    bb.b(this);
                    return;
                case 12010:
                    bb.a(this);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.e, this.f);
        HidenSoftKeyPad(this.e, this.h);
        super.onPause();
        d_().d(this);
    }

    @Override // com.baidu.tieba.voice.af
    public synchronized VoiceManager d_() {
        if (this.H == null) {
            this.H = VoiceManager.c();
        }
        return this.H;
    }

    @Override // com.baidu.tieba.voice.af
    public com.baidu.tieba.voice.ad a(VoiceManager.VoiceModel voiceModel) {
        return null;
    }
}
