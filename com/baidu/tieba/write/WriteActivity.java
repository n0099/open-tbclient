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
import com.baidu.tieba.motu_gallery.JigsawAlbumActivity;
import com.baidu.tieba.service.TiebaPrepareImageService;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.voice.VoiceManager;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class WriteActivity extends com.baidu.tieba.f implements com.baidu.tieba.voice.af, af {
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
    private bj r = null;
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
    private final Runnable F = new ao(this);
    private final View.OnClickListener G = new az(this);
    private boolean H = true;
    private final View.OnFocusChangeListener I = new bb(this);

    @Override // com.baidu.tieba.f
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        super.showLoadingDialog(str, onCancelListener);
        this.mWaitingDialog.setCanceledOnTouchOutside(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int d(WriteActivity writeActivity) {
        int selectionEnd = writeActivity.j.getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) writeActivity.j.getText().getSpans(0, writeActivity.j.getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = writeActivity.j.getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = writeActivity.j.getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (!this.H) {
            this.A.a();
        } else {
            this.A.b();
        }
    }

    @Override // com.baidu.tieba.f, android.app.Activity
    public void onResume() {
        super.onResume();
        c_().b(this);
        this.B.n();
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        c_();
        VoiceManager.g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onStop() {
        super.onStop();
        this.B.l();
        c_().j();
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
        a(activity, 1, str, str2, str3, null, 0, null, 13002, false, false, null, false, true, str4);
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
        intent.putExtra("is_ad", false);
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
        Boolean bool;
        super.onCreate(bundle);
        this.e = (InputMethodManager) getSystemService("input_method");
        this.C = new com.baidu.tieba.util.i(this);
        this.s = new ax(this);
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
        ae.b(this.b.getForumId(), this);
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
        this.g.addTextChangedListener(new aq(this));
        this.u.postDelayed(this.F, 200L);
        this.j = (EditText) findViewById(R.id.post_content);
        this.j.setDrawingCacheEnabled(false);
        this.j.setOnClickListener(this.G);
        if (this.b.getContent() != null && this.b.getContent().length() > 0) {
            this.j.setText(TbFaceManager.a().e(this.b.getContent()));
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
        this.j.setOnTouchListener(new ar(this));
        this.j.addTextChangedListener(new as(this));
        if (this.c) {
            this.f.setFocusable(true);
            this.f.setFocusableInTouchMode(true);
            getWindow().setSoftInputMode(18);
        }
        this.i = (LinearLayout) findViewById(R.id.post_content_container);
        this.i.setDrawingCacheEnabled(false);
        this.i.setOnClickListener(new bc(this));
        this.o.setOnFocusChangeListener(this.I);
        this.o.setOnClickListener(new bd(this));
        this.A = (WriteEditorToolButtonContainer) findViewById(R.id.write_eidtor_tool_buttons);
        this.A.b();
        this.A.setAtFocusable(false);
        this.A.setOnActionListener(new av(this));
        this.B = (EditorToolComponetContainer) findViewById(R.id.tool_group);
        this.B.setFrom(1);
        this.B.setOnActionListener(new at(this));
        this.p.setOnClickListener(new bg(this));
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
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.is_save_draft)).setCancelable(false).setPositiveButton(getString(R.string.save), new bh(this)).setNeutralButton(getString(R.string.not_save), new ap(this));
        this.t = builder.create();
        h();
        c_().a((Activity) this);
        String[] strArr = {getString(R.string.take_photo), getString(R.string.album)};
        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
        builder2.setTitle(getString(R.string.operation));
        builder2.setItems(strArr, new bf(this));
        if (this.k == null) {
            this.k = builder2.create();
            this.k.setCanceledOnTouchOutside(true);
        }
        Intent intent2 = getIntent();
        if (intent2 != null) {
            bool = intent2.hasExtra("enable_audio") ? Boolean.valueOf(intent2.getBooleanExtra("enable_audio", true)) : null;
            if (intent2.hasExtra("disable_audio_message")) {
                this.z = intent2.getStringExtra("disable_audio_message");
            }
        } else {
            bool = null;
        }
        if (com.baidu.tieba.i.a.a(this.b != null ? this.b.getForumName() : null, bool)) {
            this.A.a(true);
        } else {
            this.A.a(false);
        }
        d();
        if (!this.c || this.b == null) {
            return;
        }
        this.m.setVisibility(0);
        showProgressBar();
        this.l = new s();
        this.l.a(this.b.getForumName());
        this.l.setLoadDataCallBack(new be(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.a();
        if (this.r != null) {
            this.r.cancel();
            this.r = null;
        }
        try {
            if (this.t != null && this.t.isShowing()) {
                this.t.dismiss();
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "closeDialog", e.getMessage());
        }
        super.onDestroy();
        if (this.l != null) {
            this.l.cancelLoadData();
        }
        c_().d(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.b != null && this.b.getType() == 2 && this.v) {
            finish();
        } else if (this.b == null) {
            finish();
        } else {
            this.b.setTitle(this.g.getText().toString());
            this.b.setContent(this.j.getText().toString());
            if (this.b.getHaveDraft() && com.baidu.adp.lib.util.g.b(this.b.getTitle()) && com.baidu.adp.lib.util.g.b(this.b.getContent()) && !this.b.isHasImages()) {
                ae.a(this.b.getForumId(), (WriteData) null);
            } else {
                ae.a(this.b.getForumId(), this.b);
            }
            finish();
        }
    }

    @Override // com.baidu.tieba.f, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.B.a()) {
                this.A.c();
                this.B.b();
                return false;
            }
            f();
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
        getLayoutMode().a(this.x);
        this.n.b(i);
        com.baidu.tieba.util.bq.h(this.p, i);
        d();
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
        h();
        this.B.a(i);
    }

    private static void a(EditText editText, int i) {
        Editable text = editText.getText();
        int selectionStart = editText.getSelectionStart();
        int selectionEnd = editText.getSelectionEnd();
        editText.setText((CharSequence) null);
        editText.setHintTextColor(i);
        editText.setText(text);
        editText.setSelection(selectionStart, selectionEnd);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean q(WriteActivity writeActivity) {
        return writeActivity.j.getText() != null && writeActivity.j.getText().length() >= 5000;
    }

    private void g() {
        this.A.c();
        if (this.B.a()) {
            this.B.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a() {
        this.B.c(this.j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(int i) {
        if (this.B.a()) {
            b(i);
            return;
        }
        this.B.b(this.g);
        this.B.b(this.j);
        new Handler().postDelayed(new au(this, i), 200L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(int i) {
        if (i == 2) {
            this.B.e();
        } else if (i == 5) {
            this.B.f();
        } else if (i == 8) {
            this.B.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(com.baidu.tieba.editortool.x xVar) {
        if (((ImageSpan[]) this.j.getText().getSpans(0, this.j.getText().length(), ImageSpan.class)).length >= 10) {
            if (this.y == null) {
                this.y = Toast.makeText(this, (int) R.string.too_many_face, 0);
            }
            this.y.show();
            return;
        }
        String a = xVar.a();
        WritableEmotionGroup.EmotionGroupType b = xVar.b();
        if (a != null) {
            int selectionStart = this.j.getSelectionStart();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(a);
            com.baidu.adp.widget.ImageView.b a2 = this.C.a(a, false, (com.baidu.tbadk.imageManager.d) new aw(this, spannableStringBuilder, selectionStart, b));
            if (a2 != null) {
                a(spannableStringBuilder, selectionStart, a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.b bVar) {
        Bitmap h = bVar.h();
        com.baidu.tieba.view.bu buVar = new com.baidu.tieba.view.bu(h);
        buVar.setBounds(0, 0, h.getWidth() + 1, h.getHeight());
        buVar.setGravity(3);
        spannableStringBuilder.setSpan(new ImageSpan(buVar, 0), 0, spannableStringBuilder.length(), 33);
        this.j.getText().insert(i, spannableStringBuilder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b() {
        this.j.onKeyDown(67, this.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        String trim;
        if (this.b.getType() == 0) {
            trim = this.g.getText().toString().trim();
        } else {
            if (this.B.h()) {
                trim = SocialConstants.TRUE;
            } else {
                trim = this.j.getText().toString().trim();
            }
            if (this.B.i()) {
                trim = SocialConstants.TRUE;
            }
        }
        if (trim == null || trim.length() <= 0) {
            this.p.setEnabled(false);
        } else {
            this.p.setEnabled(true);
        }
    }

    @Override // com.baidu.tieba.write.af
    public final void a(WriteData writeData) {
        if (writeData != null) {
            this.b.setHaveDraft(true);
            if (com.baidu.adp.lib.util.g.b(this.g.getText().toString()) || (this.c && !com.baidu.adp.lib.util.g.b(writeData.getTitle()))) {
                this.b.setTitle(writeData.getTitle());
                this.g.setText(this.b.getTitle());
            }
            if ((com.baidu.adp.lib.util.g.b(this.j.getText().toString()) || this.c) && !com.baidu.adp.lib.util.g.b(writeData.getContent())) {
                this.b.setContent(writeData.getContent());
                this.j.setText(TbFaceManager.a().a(this.b.getContent(), new ay(this)));
            }
            if (writeData.getWriteImagesInfo() != null) {
                this.D = writeData.getWriteImagesInfo();
                this.b.setWriteImagesInfo(this.D);
                this.B.a(this.D, true);
                i();
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
        c_();
        VoiceManager.i();
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String editable = this.j.getEditableText().toString();
        if (editable != null) {
            this.j.setText(TbFaceManager.a().e(editable));
        }
    }

    public final void c() {
        this.b.setTitle(this.g.getText().toString());
        this.b.setContent(this.j.getText().toString());
        showLoadingDialog(getString(R.string.sending), this.s);
        if (this.r != null) {
            this.r.cancel();
        }
        this.b.setVcode(null);
        this.r = new bj(this, this.b);
        this.r.setPriority(3);
        this.r.execute(0);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 12004) {
                ArrayList<String> a = AtListActivity.a(intent);
                if (a != null && a.size() > 0) {
                    StringBuilder sb = new StringBuilder();
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
                ae.a(this.b.getForumId(), (WriteData) null);
                setResult(-1);
                finish();
            } else if (i == 12002) {
                a(intent, true);
                h();
            } else if (i == 12001) {
                String str = Environment.getExternalStorageDirectory() + "/" + com.baidu.tieba.data.i.k() + "/cameras/" + this.E;
                if (!TextUtils.isEmpty(str)) {
                    try {
                        int b = com.baidu.tieba.util.n.b(str);
                        if (b != 0) {
                            Bitmap a2 = com.baidu.tieba.util.n.a(str, BdUtilHelper.a(this, BdUtilHelper.b(this)), BdUtilHelper.a(this, BdUtilHelper.c(this)));
                            Bitmap e = com.baidu.tieba.util.n.e(a2, b);
                            if (a2 != e) {
                                a2.recycle();
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
                i();
                int size = this.D.size() - 1;
                if (size >= 0) {
                    WriteMultiImgsActivity.a(this, 12012, this.D, size);
                }
            } else if (i == 12012) {
                a(intent, false);
                h();
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12001:
                    new ba(this).execute(new Void[0]);
                    return;
                case 12002:
                    if (!this.B.h()) {
                        this.A.f();
                        g();
                    }
                    if (intent != null && intent.hasExtra("last_album_id")) {
                        this.D.setLastAlbumId(intent.getStringExtra("last_album_id"));
                        return;
                    }
                    return;
                case 12009:
                    try {
                        JigsawAlbumActivity.a(this, 12002);
                        return;
                    } catch (Exception e3) {
                        com.baidu.adp.lib.util.e.b("WriteUtil", "getAlbumImage", "error = " + e3.getMessage());
                        return;
                    }
                case 12010:
                    this.E = String.valueOf(System.currentTimeMillis());
                    by.a(this, this.E);
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
        c_().c(this);
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
            i();
        }
    }

    private void i() {
        LinkedList<ImageFileInfo> chosedFiles = this.D.getChosedFiles();
        if (chosedFiles != null && chosedFiles.size() > 0) {
            this.A.e();
            this.A.a(new StringBuilder(String.valueOf(chosedFiles.size())).toString());
            this.B.g();
            return;
        }
        this.A.g();
        this.A.f();
        g();
    }

    @Override // com.baidu.tieba.voice.af
    public final synchronized VoiceManager c_() {
        if (this.J == null) {
            this.J = VoiceManager.b();
        }
        return this.J;
    }

    @Override // com.baidu.tieba.voice.af
    public final com.baidu.tieba.voice.ad a(VoiceManager.VoiceModel voiceModel) {
        return null;
    }
}
