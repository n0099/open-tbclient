package com.baidu.tieba.write;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.data.emotions.WritableEmotionGroup;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
import com.baidu.tieba.img.ImageFileInfo;
import com.baidu.tieba.img.WriteImagesInfo;
import com.baidu.tieba.service.TiebaPrepareImageService;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.voice.VoiceManager;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class WriteActivity extends com.baidu.tieba.f implements com.baidu.tieba.voice.af, ag {
    private com.baidu.tieba.util.i C;
    private String E;
    private VoiceManager J;
    private Toast y;
    private WriteData b = null;
    private boolean c = false;
    private boolean d = false;
    private InputMethodManager e = null;
    private LinearLayout f = null;
    private EditText g = null;
    private FrameLayout h = null;
    private LinearLayout i = null;
    private EditText j = null;
    private AlertDialog k = null;
    private s l = null;
    private FeedBackTopListView m = null;
    final KeyEvent a = new KeyEvent(0, 67);
    private NavigationBar n = null;
    private ImageView o = null;
    private TextView p = null;
    private TextView q = null;
    private bk r = null;
    private DialogInterface.OnCancelListener s = null;
    private AlertDialog t = null;
    private final Handler u = new Handler();
    private boolean v = false;
    private String w = null;
    private RelativeLayout x = null;
    private String z = null;
    private WriteEditorToolButtonContainer A = null;
    private EditorToolComponetContainer B = null;
    private WriteImagesInfo D = new WriteImagesInfo();
    private final Runnable F = new ap(this);
    private final View.OnClickListener G = new ba(this);
    private boolean H = true;
    private final View.OnFocusChangeListener I = new bc(this);

    @Override // com.baidu.tieba.f
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        super.showLoadingDialog(str, onCancelListener);
        this.mWaitingDialog.setCanceledOnTouchOutside(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (!this.H) {
            this.A.a();
        } else {
            this.A.b();
        }
    }

    @Override // com.baidu.tieba.f, android.app.Activity
    public void onResume() {
        super.onResume();
        h().c(this);
        this.B.w();
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        h().b((Activity) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onStop() {
        super.onStop();
        this.B.u();
        h().f(this);
        getWindow().setSoftInputMode(18);
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
            BdUtilHelper.a((Context) activity, antiData.getForbid_info());
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
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.e = (InputMethodManager) getSystemService("input_method");
        this.C = new com.baidu.tieba.util.i(this);
        a(bundle);
        o();
        p();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.a();
        if (this.r != null) {
            this.r.cancel();
            this.r = null;
        }
        r();
        super.onDestroy();
        if (this.l != null) {
            this.l.cancelLoadData();
        }
        h().g(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (this.b != null && this.b.getType() == 2 && this.v) {
            finish();
        } else if (this.b == null) {
            finish();
        } else {
            this.b.setTitle(this.g.getText().toString());
            this.b.setContent(this.j.getText().toString());
            if (this.b.getHaveDraft() && com.baidu.adp.lib.util.h.b(this.b.getTitle()) && com.baidu.adp.lib.util.h.b(this.b.getContent()) && !this.b.isHasImages()) {
                af.a(this.b.getForumId(), (WriteData) null);
            } else {
                af.a(this.b.getForumId(), this.b);
            }
            finish();
        }
    }

    @Override // com.baidu.tieba.f, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.B.j()) {
                this.A.c();
                this.B.k();
                return false;
            }
            n();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        int color;
        int color2;
        super.onChangeSkinType(i);
        getLayoutMode().a(i == 1);
        getLayoutMode().a((View) this.x);
        this.n.c(i);
        com.baidu.tieba.util.bq.h(this.p, i);
        m();
        if (i == 1) {
            this.h.setBackgroundColor(getResources().getColor(R.color.write_line1_1));
            this.g.setBackgroundColor(getResources().getColor(R.color.write_title_bg_1));
            this.j.setBackgroundColor(getResources().getColor(R.color.write_content_bg_1));
            color = getResources().getColor(R.color.write_text_1);
            color2 = getResources().getColor(R.color.write_hint_text_1);
        } else {
            this.h.setBackgroundColor(getResources().getColor(R.color.write_line1));
            this.g.setBackgroundColor(getResources().getColor(R.color.write_title_bg));
            this.j.setBackgroundColor(getResources().getColor(R.color.write_content_bg));
            color = getResources().getColor(R.color.write_text);
            color2 = getResources().getColor(R.color.write_hint_text);
        }
        this.A.a(i);
        this.g.setTextColor(color);
        this.j.setTextColor(color);
        a(this.g, color2);
        a(this.j, color2);
        t();
        this.B.a(i);
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

    private void o() {
        setContentView(R.layout.write_activity);
        this.n = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.q = this.n.a("");
        this.o = this.n.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.p = this.n.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(R.string.send));
        this.p.setOnFocusChangeListener(this.I);
        this.f = (LinearLayout) findViewById(R.id.write_container);
        this.m = (FeedBackTopListView) findViewById(R.id.feedback_top_list);
        this.x = (RelativeLayout) findViewById(R.id.parent);
        this.h = (FrameLayout) findViewById(R.id.interval_view);
        d();
        this.u.postDelayed(this.F, 200L);
        e();
        if (this.c) {
            this.f.setFocusable(true);
            this.f.setFocusableInTouchMode(true);
            getWindow().setSoftInputMode(18);
        }
        this.i = (LinearLayout) findViewById(R.id.post_content_container);
        this.i.setDrawingCacheEnabled(false);
        this.i.setOnClickListener(new bd(this));
        this.o.setOnFocusChangeListener(this.I);
        this.o.setOnClickListener(new be(this));
        j();
        f();
        b();
        if (this.b.getType() == 0) {
            if (this.c) {
                this.q.setText(R.string.feedback);
            } else {
                this.q.setText(R.string.post_new_thread);
            }
            this.g.setVisibility(0);
        } else {
            this.q.setText(R.string.send_reply);
            this.j.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
            this.g.setVisibility(8);
        }
        c();
        t();
        q();
        a();
        a(s());
        m();
    }

    private void p() {
        if (this.c && this.b != null) {
            this.m.setVisibility(0);
            showProgressBar();
            this.l = new s();
            this.l.a(this.b.getForumName());
            this.l.setLoadDataCallBack(new bf(this));
        }
    }

    protected void a() {
        String[] strArr = {getString(R.string.take_photo), getString(R.string.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.operation));
        builder.setItems(strArr, new bg(this));
        if (this.k == null) {
            this.k = builder.create();
            this.k.setCanceledOnTouchOutside(true);
        }
    }

    protected void b() {
        this.p.setOnClickListener(new bh(this));
    }

    protected void c() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.is_save_draft)).setCancelable(false).setPositiveButton(getString(R.string.save), new bi(this)).setNeutralButton(getString(R.string.not_save), new aq(this));
        this.t = builder.create();
    }

    protected void d() {
        this.g = (EditText) findViewById(R.id.post_title);
        this.g.setOnClickListener(this.G);
        this.g.setOnFocusChangeListener(this.I);
        if (this.b.getType() == 0) {
            if (this.b.getTitle() != null) {
                this.g.setText(this.b.getTitle());
            } else if (this.c) {
                this.g.setText(getResources().getString(R.string.android_feedback));
                this.g.setSelection(getResources().getString(R.string.android_feedback).length());
            }
        } else if (this.b.getType() != 1) {
            this.b.getType();
        }
        this.g.addTextChangedListener(new ar(this));
    }

    protected void e() {
        this.j = (EditText) findViewById(R.id.post_content);
        this.j.setDrawingCacheEnabled(false);
        this.j.setOnClickListener(this.G);
        if (this.b.getContent() != null && this.b.getContent().length() > 0) {
            this.j.setText(TbFaceManager.a().a(this, this.b.getContent()));
        } else if (this.b.getType() == 2) {
            if (this.v) {
                if (this.w != null && this.w.length() > 0) {
                    this.j.setText(getString(R.string.reply_sub_floor, new Object[]{this.w}));
                    this.j.setSelection(this.j.getText().length());
                }
            } else if (this.b.getFloorNum() > 0) {
                String format = String.format(getString(R.string.reply_x_floor), Integer.valueOf(this.b.getFloorNum()));
                this.j.setText(format);
                this.j.setSelection(format.length());
            }
        } else if (this.b.getType() == 0 && this.c) {
            StringBuffer stringBuffer = new StringBuffer(30);
            stringBuffer.append(getResources().getString(R.string.tieba_client));
            stringBuffer.append(com.baidu.tieba.data.i.u());
            stringBuffer.append(", ");
            stringBuffer.append(Build.VERSION.RELEASE);
            stringBuffer.append(", ");
            stringBuffer.append(Build.MODEL);
            stringBuffer.append(", ");
            UtilHelper.NetworkStateInfo h = UtilHelper.h(this);
            if (h == UtilHelper.NetworkStateInfo.WIFI) {
                stringBuffer.append("WIFI");
            } else if (h == UtilHelper.NetworkStateInfo.ThreeG) {
                stringBuffer.append("3G");
            } else if (h == UtilHelper.NetworkStateInfo.TwoG) {
                stringBuffer.append("2G");
            } else {
                stringBuffer.append("UNKNOWN");
            }
            stringBuffer.append(":");
            this.j.setText(stringBuffer);
        }
        this.j.setOnFocusChangeListener(this.I);
        this.j.setOnTouchListener(new as(this));
        this.j.addTextChangedListener(new at(this));
    }

    protected void f() {
        this.B = (EditorToolComponetContainer) findViewById(R.id.tool_group);
        this.B.setFrom(1);
        this.B.setOnActionListener(new au(this));
    }

    protected void g() {
        this.A.c();
        if (this.B.j()) {
            this.B.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i() {
        this.B.c(this.j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i) {
        if (this.B.j()) {
            b(i);
            return;
        }
        this.B.b(this.g);
        this.B.b(this.j);
        new Handler().postDelayed(new av(this, i), 200L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i) {
        if (i == 2) {
            this.B.n();
        } else if (i == 5) {
            this.B.o();
        } else if (i == 8) {
            this.B.p();
        }
    }

    protected void j() {
        this.A = (WriteEditorToolButtonContainer) findViewById(R.id.write_eidtor_tool_buttons);
        this.A.b();
        this.A.setAtFocusable(false);
        this.A.setOnActionListener(new aw(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.editortool.w wVar) {
        if (((ImageSpan[]) this.j.getText().getSpans(0, this.j.getText().length(), ImageSpan.class)).length >= 10) {
            if (this.y == null) {
                this.y = Toast.makeText(this, (int) R.string.too_many_face, 0);
            }
            this.y.show();
            return;
        }
        String a = wVar.a();
        WritableEmotionGroup.EmotionGroupType b = wVar.b();
        if (a != null) {
            int selectionStart = this.j.getSelectionStart();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(a);
            com.baidu.adp.widget.ImageView.b a2 = this.C.a(a, false, (com.baidu.tbadk.imageManager.d) new ax(this, spannableStringBuilder, selectionStart, b));
            if (a2 != null) {
                a(spannableStringBuilder, selectionStart, a2, b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.b bVar, WritableEmotionGroup.EmotionGroupType emotionGroupType) {
        Bitmap h = bVar.h();
        com.baidu.tieba.view.bu buVar = new com.baidu.tieba.view.bu(h);
        buVar.setBounds(0, 0, h.getWidth() + 1, h.getHeight());
        buVar.setGravity(3);
        spannableStringBuilder.setSpan(new ImageSpan(buVar, 0), 0, spannableStringBuilder.length(), 33);
        this.j.getText().insert(i, spannableStringBuilder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k() {
        this.j.onKeyDown(67, this.a);
    }

    private void a(Boolean bool) {
        String str = null;
        if (this.b != null) {
            str = this.b.getForumName();
        }
        if (com.baidu.tieba.i.a.a(str, bool)) {
            this.A.a(true);
        } else {
            this.A.a(false);
        }
    }

    private void q() {
        h().a((Activity) this);
    }

    private void r() {
        try {
            if (this.t != null && this.t.isShowing()) {
                this.t.dismiss();
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "closeDialog", e.getMessage());
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
                this.z = intent.getStringExtra("disable_audio_message");
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        String trim;
        if (this.b.getType() == 0) {
            trim = this.g.getText().toString().trim();
        } else {
            if (this.B.q()) {
                trim = SocialConstants.TRUE;
            } else {
                trim = this.j.getText().toString().trim();
            }
            if (this.B.r()) {
                trim = SocialConstants.TRUE;
            }
        }
        if (trim == null || trim.length() <= 0) {
            this.p.setEnabled(false);
        } else {
            this.p.setEnabled(true);
        }
    }

    private void a(Bundle bundle) {
        this.s = new ay(this);
        this.b = new WriteData();
        if (bundle != null) {
            this.b.setType(bundle.getInt("type", 0));
            this.b.setForumId(bundle.getString("forum_id"));
            this.b.setForumName(bundle.getString("forum_name"));
            this.b.setThreadId(bundle.getString("thread_id"));
            this.b.setFloor(bundle.getString("floor_id"));
            this.b.setFloorNum(bundle.getInt("floor_num", 0));
            this.c = bundle.getBoolean("feed_back", false);
            this.v = bundle.getBoolean("reply_sub_pb", false);
            this.w = bundle.getString("sub_user_name");
            this.D = (WriteImagesInfo) bundle.getSerializable("write_images");
            this.E = bundle.getString("photo_name");
        } else {
            Intent intent = getIntent();
            this.b.setType(intent.getIntExtra("type", 0));
            this.b.setForumId(intent.getStringExtra("forum_id"));
            this.b.setForumName(intent.getStringExtra("forum_name"));
            this.b.setThreadId(intent.getStringExtra("thread_id"));
            this.b.setFloor(intent.getStringExtra("floor_id"));
            this.b.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.c = intent.getBooleanExtra("feed_back", false);
            this.v = intent.getBooleanExtra("reply_sub_pb", false);
            this.w = intent.getStringExtra("sub_user_name");
        }
        this.D.setMaxImagesAllowed(10);
        this.b.setWriteImagesInfo(this.D);
        af.b(this.b.getForumId(), this);
    }

    @Override // com.baidu.tieba.write.ag
    public void a(WriteData writeData) {
        if (writeData != null) {
            this.b.setHaveDraft(true);
            if (com.baidu.adp.lib.util.h.b(this.g.getText().toString()) || (this.c && !com.baidu.adp.lib.util.h.b(writeData.getTitle()))) {
                this.b.setTitle(writeData.getTitle());
                this.g.setText(this.b.getTitle());
            }
            if ((com.baidu.adp.lib.util.h.b(this.j.getText().toString()) || this.c) && !com.baidu.adp.lib.util.h.b(writeData.getContent())) {
                this.b.setContent(writeData.getContent());
                this.j.setText(TbFaceManager.a().a(this, this.b.getContent(), new az(this)));
            }
            if (writeData.getWriteImagesInfo() != null) {
                this.D = writeData.getWriteImagesInfo();
                this.b.setWriteImagesInfo(this.D);
                this.B.a(this.D, true);
                v();
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
        bundle.putBoolean("reply_sub_pb", this.v);
        if (this.c) {
            bundle.putBoolean("feed_back", true);
        }
        bundle.putSerializable("write_images", this.D);
        bundle.putString("photo_name", this.E);
        super.onSaveInstanceState(bundle);
        h().e(this);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String editable = this.j.getEditableText().toString();
        if (editable != null) {
            this.j.setText(TbFaceManager.a().a(this, editable));
        }
    }

    public void l() {
        this.b.setTitle(this.g.getText().toString());
        this.b.setContent(this.j.getText().toString());
        showLoadingDialog(getString(R.string.sending), this.s);
        if (this.r != null) {
            this.r.cancel();
        }
        this.b.setVcode(null);
        this.r = new bk(this, this.b);
        this.r.setPriority(3);
        this.r.execute(0);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 12004) {
                ArrayList<String> a = AtListActivity.a(intent);
                if (a != null && a.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 < a.size()) {
                            sb.append("@");
                            sb.append(a.get(i4));
                            sb.append(" ");
                            i3 = i4 + 1;
                        } else {
                            this.j.getText().insert(this.j.getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                af.a(this.b.getForumId(), (WriteData) null);
                setResult(-1);
                finish();
            } else if (i == 12002) {
                a(intent);
                t();
            } else if (i == 12001) {
                b(intent);
                int size = this.D.size() - 1;
                if (size > -1) {
                    WriteMultiImgsActivity.a(this, 12012, this.D, size);
                }
            } else if (i == 12012) {
                c(intent);
                t();
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12001:
                    u();
                    return;
                case 12002:
                    if (!this.B.q()) {
                        this.A.g();
                        g();
                    }
                    if (intent != null && intent.hasExtra("last_album_id")) {
                        this.D.setLastAlbumId(intent.getStringExtra("last_album_id"));
                        return;
                    }
                    return;
                case 12009:
                    bz.c(this);
                    return;
                case 12010:
                    this.E = String.valueOf(System.currentTimeMillis());
                    bz.a(this, this.E);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.e, this.g);
        HidenSoftKeyPad(this.e, this.j);
        super.onPause();
        h().d(this);
    }

    private void a(Intent intent) {
        a(intent, true);
    }

    private void b(Intent intent) {
        String str = Environment.getExternalStorageDirectory() + "/" + com.baidu.tieba.data.i.k() + "/cameras/" + this.E;
        if (!TextUtils.isEmpty(str)) {
            try {
                int b = com.baidu.tieba.util.n.b(str);
                if (b != 0) {
                    Bitmap a = com.baidu.tieba.util.n.a(str, BdUtilHelper.a(this, BdUtilHelper.b(this)), BdUtilHelper.a(this, BdUtilHelper.c(this)));
                    Bitmap e = com.baidu.tieba.util.n.e(a, b);
                    if (a != e) {
                        a.recycle();
                    }
                    com.baidu.tieba.util.af.a("cameras", this.E, e, 100);
                    e.recycle();
                }
            } catch (Exception e2) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.D.addChooseFile(imageFileInfo);
            this.D.updateQuality();
            this.B.a(this.D, true);
        }
        v();
    }

    private void c(Intent intent) {
        a(intent, false);
    }

    private void a(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.D.parseJson(stringExtra);
                this.D.updateQuality();
                if (this.D.getChosedFiles() != null) {
                    this.B.a(this.D, z);
                }
            }
            v();
        }
    }

    private void u() {
        new bb(this).execute(new Void[0]);
    }

    private void v() {
        LinkedList<ImageFileInfo> chosedFiles = this.D.getChosedFiles();
        if (chosedFiles != null && chosedFiles.size() > 0) {
            this.A.f();
            this.A.a(new StringBuilder(String.valueOf(chosedFiles.size())).toString());
            this.B.p();
            return;
        }
        this.A.h();
        this.A.g();
        g();
    }

    @Override // com.baidu.tieba.voice.af
    public synchronized VoiceManager h() {
        if (this.J == null) {
            this.J = VoiceManager.c();
        }
        return this.J;
    }

    @Override // com.baidu.tieba.voice.af
    public com.baidu.tieba.voice.ad a(VoiceManager.VoiceModel voiceModel) {
        return null;
    }
}
