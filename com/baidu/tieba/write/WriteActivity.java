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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
import com.baidu.tieba.util.AntiHelper;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class WriteActivity extends com.baidu.tbadk.a implements PopupWindow.OnDismissListener, com.baidu.tbadk.core.voice.z, com.baidu.tieba.util.n, bt {
    private com.baidu.tbadk.editortool.ab B;
    private String D;
    private com.baidu.tieba.model.ar E;
    private VoiceManager F;
    private AdditionData G;
    private RelativeLayout H;
    private TextView I;
    private TextView J;
    private TextView K;
    private PostPrefixData L;
    private TextView M;
    private bs N;
    private ImageView O;
    private int P;
    private Toast x;
    private WriteData a = null;
    private boolean b = false;
    private InputMethodManager c = null;
    private LinearLayout d = null;
    private EditText e = null;
    private View f = null;
    private LinearLayout g = null;
    private EditText h = null;
    private AlertDialog i = null;
    private s j = null;
    private FeedBackTopListView k = null;
    private String l = null;
    private final KeyEvent m = new KeyEvent(0, 67);
    private NavigationBar n = null;
    private View o = null;
    private TextView p = null;
    private TextView q = null;
    private DialogInterface.OnCancelListener r = null;
    private AlertDialog s = null;
    private final Handler t = new Handler();
    private boolean u = false;
    private String v = null;
    private RelativeLayout w = null;
    private String y = null;
    private WriteEditorToolButtonContainer z = null;
    private EditorToolComponetContainer A = null;
    private WriteImagesInfo C = new WriteImagesInfo();
    private final com.baidu.tieba.model.as Q = new ag(this);
    private final Runnable R = new as(this);
    private final View.OnClickListener S = new ax(this);
    private boolean T = true;
    private final View.OnFocusChangeListener U = new ay(this);

    static {
        TbadkApplication.j().a(com.baidu.tbadk.core.b.av.class, WriteActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int f(WriteActivity writeActivity) {
        int selectionEnd = writeActivity.h.getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) writeActivity.h.getText().getSpans(0, writeActivity.h.getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = writeActivity.h.getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = writeActivity.h.getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (!this.T) {
            this.z.a();
        } else {
            this.z.b();
        }
    }

    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onResume() {
        super.onResume();
        d().b(this);
        this.A.p();
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        d();
        VoiceManager.g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onStop() {
        super.onStop();
        this.A.n();
        d().j();
        getWindow().setSoftInputMode(18);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        Boolean bool;
        super.onCreate(bundle);
        this.c = (InputMethodManager) getSystemService("input_method");
        this.B = new com.baidu.tbadk.editortool.ab(this);
        this.E = new com.baidu.tieba.model.ar();
        this.E.a(this.Q);
        this.r = new au(this);
        this.a = new WriteData();
        if (bundle != null) {
            this.a.setType(bundle.getInt("type", 0));
            this.a.setForumId(bundle.getString("forum_id"));
            this.a.setForumName(bundle.getString("forum_name"));
            this.a.setThreadId(bundle.getString("thread_id"));
            this.a.setFloor(bundle.getString("floor_id"));
            this.a.setFloorNum(bundle.getInt("floor_num", 0));
            this.b = bundle.getBoolean("feed_back", false);
            this.u = bundle.getBoolean("reply_sub_pb", false);
            this.v = bundle.getString("sub_user_name");
            this.C = (WriteImagesInfo) bundle.getSerializable("write_images");
            this.D = bundle.getString("photo_name");
            this.G = (AdditionData) bundle.getSerializable("addition_data");
            this.a.setIsAddition(this.G != null);
            this.L = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            Intent intent = getIntent();
            this.a.setType(intent.getIntExtra("type", 0));
            this.a.setForumId(intent.getStringExtra("forum_id"));
            this.a.setForumName(intent.getStringExtra("forum_name"));
            this.a.setThreadId(intent.getStringExtra("thread_id"));
            this.a.setFloor(intent.getStringExtra("floor_id"));
            this.a.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.b = intent.getBooleanExtra("feed_back", false);
            this.u = intent.getBooleanExtra("reply_sub_pb", false);
            this.v = intent.getStringExtra("sub_user_name");
            this.G = (AdditionData) intent.getSerializableExtra("addition_data");
            this.a.setIsAddition(this.G != null);
            this.L = (PostPrefixData) intent.getSerializableExtra("prefix_data");
        }
        this.C.setMaxImagesAllowed(10);
        this.a.setWriteImagesInfo(this.C);
        if (this.a.getType() == 0) {
            com.baidu.tieba.util.m.b(this.a.getForumId(), this);
        } else if (this.a.getType() == 1) {
            com.baidu.tieba.util.m.a(this.a.getThreadId(), this);
        }
        if (this.L != null && this.L.getPrefixs().size() > 0) {
            this.L.getPrefixs().add(getString(com.baidu.tieba.a.k.write_no_prefix));
        }
        this.l = TbadkApplication.j().aC();
        setContentView(com.baidu.tieba.a.i.write_activity);
        this.n = (NavigationBar) findViewById(com.baidu.tieba.a.h.view_navigation_bar);
        this.o = this.n.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.q = this.n.a("");
        this.p = this.n.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(com.baidu.tieba.a.k.send));
        this.p.setOnFocusChangeListener(this.U);
        this.d = (LinearLayout) findViewById(com.baidu.tieba.a.h.write_container);
        this.k = (FeedBackTopListView) findViewById(com.baidu.tieba.a.h.feedback_top_list);
        this.w = (RelativeLayout) findViewById(com.baidu.tieba.a.h.parent);
        this.f = findViewById(com.baidu.tieba.a.h.interval_view);
        this.e = (EditText) findViewById(com.baidu.tieba.a.h.post_title);
        this.e.setOnClickListener(this.S);
        this.e.setOnFocusChangeListener(this.U);
        if (this.a.getType() == 0) {
            if (this.a.getTitle() != null) {
                this.e.setText(this.a.getTitle());
            } else if (this.b) {
                this.e.setText(getResources().getString(com.baidu.tieba.a.k.android_feedback));
                this.e.setSelection(getResources().getString(com.baidu.tieba.a.k.android_feedback).length());
            }
        } else if (this.a.getType() != 1) {
            this.a.getType();
        }
        this.e.addTextChangedListener(new al(this));
        this.t.postDelayed(this.R, 200L);
        this.h = (EditText) findViewById(com.baidu.tieba.a.h.post_content);
        this.h.setDrawingCacheEnabled(false);
        this.h.setOnClickListener(this.S);
        if (this.a.getContent() != null && this.a.getContent().length() > 0) {
            this.h.setText(TbFaceManager.a().e(this.a.getContent()));
        } else if (this.a.getType() == 2) {
            if (this.u) {
                if (this.v != null && this.v.length() > 0) {
                    this.h.setText(getString(com.baidu.tieba.a.k.reply_sub_floor, new Object[]{this.v}));
                    this.h.setSelection(this.h.getText().length());
                }
            } else if (this.a.getFloorNum() > 0) {
                String format = String.format(getString(com.baidu.tieba.a.k.reply_x_floor), Integer.valueOf(this.a.getFloorNum()));
                this.h.setText(format);
                this.h.setSelection(format.length());
            }
        } else if (this.a.getType() == 0 && this.b) {
            StringBuffer stringBuffer = new StringBuffer(30);
            stringBuffer.append(getResources().getString(com.baidu.tieba.a.k.tieba_client));
            stringBuffer.append(com.baidu.tbadk.core.data.n.c());
            stringBuffer.append(", ");
            stringBuffer.append(Build.VERSION.RELEASE);
            stringBuffer.append(", ");
            stringBuffer.append(Build.MODEL);
            stringBuffer.append(", ");
            UtilHelper.NetworkStateInfo d = UtilHelper.d(this);
            if (d == UtilHelper.NetworkStateInfo.WIFI) {
                stringBuffer.append("WIFI");
            } else if (d == UtilHelper.NetworkStateInfo.ThreeG) {
                stringBuffer.append("3G");
            } else if (d == UtilHelper.NetworkStateInfo.TwoG) {
                stringBuffer.append("2G");
            } else {
                stringBuffer.append("UNKNOWN");
            }
            stringBuffer.append(":");
            this.h.setText(stringBuffer);
        }
        this.h.setOnFocusChangeListener(this.U);
        this.h.setOnTouchListener(new am(this));
        this.h.addTextChangedListener(new an(this));
        h();
        if (this.b) {
            this.d.setFocusable(true);
            this.d.setFocusableInTouchMode(true);
            getWindow().setSoftInputMode(18);
        }
        this.g = (LinearLayout) findViewById(com.baidu.tieba.a.h.post_content_container);
        this.g.setDrawingCacheEnabled(false);
        this.g.setOnClickListener(new az(this));
        this.o.setOnFocusChangeListener(this.U);
        this.o.setOnClickListener(new ba(this));
        this.z = (WriteEditorToolButtonContainer) findViewById(com.baidu.tieba.a.h.write_eidtor_tool_buttons);
        this.z.b();
        this.z.b(this.G == null);
        this.z.setAtFocusable(false);
        this.z.setOnActionListener(new ar(this));
        this.z.l();
        this.A = (EditorToolComponetContainer) findViewById(com.baidu.tieba.a.h.tool_group);
        this.A.setFrom(1);
        this.A.setOnActionListener(new ap(this));
        this.p.setOnClickListener(new ah(this));
        if (this.a.getType() == 0) {
            if (this.b) {
                this.q.setText(com.baidu.tieba.a.k.feedback);
            } else {
                this.q.setText(com.baidu.tieba.a.k.post_new_thread);
            }
            this.e.setVisibility(0);
            this.h.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
        } else {
            this.q.setText(com.baidu.tieba.a.k.send_reply);
            this.h.setFilters(new InputFilter[]{new InputFilter.LengthFilter(LocationClientOption.MIN_SCAN_SPAN)});
            this.e.setVisibility(8);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(com.baidu.tieba.a.k.is_save_draft)).setCancelable(false).setPositiveButton(getString(com.baidu.tieba.a.k.save), new ai(this)).setNeutralButton(getString(com.baidu.tieba.a.k.not_save), new ak(this));
        this.s = builder.create();
        d().a((Activity) this);
        String[] strArr = {getString(com.baidu.tieba.a.k.take_photo), getString(com.baidu.tieba.a.k.album)};
        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
        builder2.setTitle(getString(com.baidu.tieba.a.k.operation));
        builder2.setItems(strArr, new bd(this));
        if (this.i == null) {
            this.i = builder2.create();
            this.i.setCanceledOnTouchOutside(true);
        }
        Intent intent2 = getIntent();
        if (intent2 != null) {
            bool = intent2.hasExtra("enable_audio") ? Boolean.valueOf(intent2.getBooleanExtra("enable_audio", true)) : null;
            if (intent2.hasExtra("disable_audio_message")) {
                this.y = intent2.getStringExtra("disable_audio_message");
            }
        } else {
            bool = null;
        }
        if (com.baidu.tieba.d.a.a(this.a != null ? this.a.getForumName() : null, bool)) {
            this.z.a(true);
        } else {
            this.z.a(false);
        }
        e();
        this.H = (RelativeLayout) findViewById(com.baidu.tieba.a.h.addition_container);
        this.I = (TextView) findViewById(com.baidu.tieba.a.h.addition_create_time);
        this.J = (TextView) findViewById(com.baidu.tieba.a.h.addition_last_time);
        this.K = (TextView) findViewById(com.baidu.tieba.a.h.addition_last_content);
        if (this.G != null) {
            this.H.setVisibility(0);
            this.I.setText(String.valueOf(getString(com.baidu.tieba.a.k.write_addition_create)) + com.baidu.tbadk.core.util.bc.a(this.G.getCreateTime() * 1000));
            if (this.G.getAlreadyCount() == 0) {
                this.J.setVisibility(8);
            } else {
                this.J.setText(String.valueOf(getString(com.baidu.tieba.a.k.write_addition_last)) + com.baidu.tbadk.core.util.bc.a(this.G.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.G.getLastAdditionContent();
            if (TextUtils.isEmpty(lastAdditionContent)) {
                this.K.setVisibility(8);
            } else {
                this.K.setText(lastAdditionContent);
            }
            this.h.setHint(String.format(getString(com.baidu.tieba.a.k.write_addition_hint), Integer.valueOf(this.G.getAlreadyCount()), Integer.valueOf(this.G.getTotalCount())));
            this.q.setText(com.baidu.tieba.a.k.write_addition_title);
        } else {
            this.H.setVisibility(8);
        }
        g();
        j();
        if (!this.b || this.a == null) {
            return;
        }
        this.k.setVisibility(0);
        showProgressBar();
        this.j = new s();
        this.j.a(this.a.getForumName());
        this.j.setLoadDataCallBack(new bc(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.a();
        if (this.E != null) {
            this.E.cancelLoadData();
        }
        try {
            if (this.s != null && this.s.isShowing()) {
                this.s.dismiss();
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "closeDialog", e.getMessage());
        }
        super.onDestroy();
        if (this.j != null) {
            this.j.cancelLoadData();
        }
        d().d(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.a != null && this.a.getType() == 2 && this.u) {
            finish();
        } else if (this.a == null) {
            finish();
        } else {
            this.a.setTitle(this.e.getText().toString());
            this.a.setContent(this.h.getText().toString());
            int type = this.a.getType();
            if (this.a.getHaveDraft() && com.baidu.adp.lib.util.h.b(this.a.getTitle()) && com.baidu.adp.lib.util.h.b(this.a.getContent()) && !this.a.isHasImages()) {
                if (type == 0) {
                    com.baidu.tieba.util.m.a(this.a.getForumId(), (WriteData) null);
                } else if (type == 1) {
                    com.baidu.tieba.util.m.b(this.a.getThreadId(), (WriteData) null);
                }
            } else if (type == 0) {
                com.baidu.tieba.util.m.a(this.a.getForumId(), this.a);
            } else if (type == 1) {
                com.baidu.tieba.util.m.b(this.a.getThreadId(), this.a);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.a, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.N != null && this.N.isShowing()) {
                this.N.dismiss();
                return true;
            } else if (this.A.a()) {
                this.z.c();
                this.A.b();
                return true;
            } else {
                f();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        int color;
        int color2;
        super.onChangeSkinType(i);
        getLayoutMode().a(i == 1);
        getLayoutMode().a(this.w);
        this.n.b(i);
        com.baidu.tbadk.core.util.ba.g(this.p, i);
        e();
        if (i == 1) {
            this.f.setBackgroundColor(getResources().getColor(com.baidu.tieba.a.e.write_line1_1));
            this.e.setBackgroundColor(getResources().getColor(com.baidu.tieba.a.e.write_title_bg_1));
            if (TextUtils.isEmpty(this.l)) {
                this.h.setBackgroundColor(getResources().getColor(com.baidu.tieba.a.e.write_content_bg_1));
            }
            color = getResources().getColor(com.baidu.tieba.a.e.cp_cont_b_1);
            color2 = getResources().getColor(com.baidu.tieba.a.e.cp_cont_e_1);
        } else {
            this.f.setBackgroundColor(getResources().getColor(com.baidu.tieba.a.e.write_line1));
            this.e.setBackgroundColor(getResources().getColor(com.baidu.tieba.a.e.write_title_bg));
            if (TextUtils.isEmpty(this.l)) {
                this.h.setBackgroundColor(getResources().getColor(com.baidu.tieba.a.e.write_content_bg));
            }
            color = getResources().getColor(com.baidu.tieba.a.e.cp_cont_b);
            color2 = getResources().getColor(com.baidu.tieba.a.e.cp_cont_e);
        }
        this.z.a(i);
        this.e.setTextColor(color);
        this.h.setTextColor(color);
        a(this.e, color2);
        a(this.h, color2);
        j();
        this.A.a(i);
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

    private void g() {
        int i;
        int i2;
        this.M = (TextView) findViewById(com.baidu.tieba.a.h.post_prefix);
        if (this.L != null && this.L.getPrefixs().size() > 0) {
            this.M.setVisibility(0);
            ArrayList<String> prefixs = this.L.getPrefixs();
            int size = prefixs.size();
            this.M.setText(prefixs.get(0));
            this.P = 0;
            this.O = (ImageView) findViewById(com.baidu.tieba.a.h.prefix_icon);
            if (size > 1) {
                this.O.setVisibility(0);
                this.M.setOnClickListener(new bb(this));
            }
            this.N = new bs(this);
            this.N.a(this);
            this.N.a(com.baidu.adp.lib.util.i.a((Context) this, 225.0f));
            this.N.setOutsideTouchable(true);
            this.N.setFocusable(true);
            this.N.setOnDismissListener(this);
            if (TbadkApplication.j().l() == 1) {
                int i3 = com.baidu.tieba.a.g.write_prefix_item_selector_1;
                int color = getResources().getColor(com.baidu.tieba.a.e.write_text_1);
                this.N.setBackgroundDrawable(getResources().getDrawable(com.baidu.tieba.a.e.cp_bg_line_b_1));
                this.M.setBackgroundResource(com.baidu.tieba.a.g.write_prefix_item_selector_1);
                this.O.setImageResource(com.baidu.tieba.a.g.icon_title_down_1);
                i = i3;
                i2 = color;
            } else {
                int i4 = com.baidu.tieba.a.g.write_prefix_item_selector;
                int color2 = getResources().getColor(com.baidu.tieba.a.e.write_text);
                this.N.setBackgroundDrawable(getResources().getDrawable(com.baidu.tieba.a.e.cp_bg_line_b));
                this.M.setBackgroundResource(com.baidu.tieba.a.g.write_prefix_item_selector);
                this.O.setImageResource(com.baidu.tieba.a.g.icon_title_down);
                i = i4;
                i2 = color2;
            }
            this.M.setTextColor(i2);
            for (int i5 = 0; i5 < size; i5++) {
                TextView textView = new TextView(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.i.a((Context) this, 45.0f));
                if (i5 != size - 1) {
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.i.a((Context) this, 1.0f);
                }
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i5));
                textView.setGravity(17);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(i2);
                textView.setBackgroundResource(i);
                this.N.a(textView);
            }
            this.N.b(0);
            return;
        }
        this.M.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.h.setPadding(0, 0, 0, 0);
        if (TbadkApplication.j().l() == 1) {
            this.h.setBackgroundColor(getResources().getColor(com.baidu.tieba.a.e.write_content_bg_1));
        } else {
            this.h.setBackgroundColor(getResources().getColor(com.baidu.tieba.a.e.write_content_bg));
        }
        if (!TextUtils.isEmpty(this.l) && this.G == null) {
            this.B.c();
            this.B.g(this.l, new ao(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean t(WriteActivity writeActivity) {
        return writeActivity.h.getText() != null && writeActivity.h.getText().length() >= (writeActivity.G != null ? LocationClientOption.MIN_SCAN_SPAN : 5000);
    }

    private void i() {
        this.z.c();
        if (this.A.a()) {
            this.A.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a() {
        this.A.c(this.h);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(int i) {
        if (this.A.a()) {
            b(i);
            return;
        }
        this.A.b(this.e);
        this.A.b(this.h);
        new Handler().postDelayed(new aq(this, i), 200L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(int i) {
        if (i == 2) {
            this.A.e();
        } else if (i == 5) {
            this.A.f();
        } else if (i == 8) {
            this.A.g();
        } else if (i == 44) {
            this.A.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(com.baidu.tbadk.coreExtra.data.d dVar) {
        if (((ImageSpan[]) this.h.getText().getSpans(0, this.h.getText().length(), ImageSpan.class)).length >= 10) {
            if (this.x == null) {
                this.x = Toast.makeText(this, com.baidu.tieba.a.k.too_many_face, 0);
            }
            this.x.show();
            return;
        }
        String a = dVar.a();
        EmotionGroupType b = dVar.b();
        if (a != null) {
            int selectionStart = this.h.getSelectionStart();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(a);
            com.baidu.adp.widget.ImageView.b b2 = this.B.b(a, false, new at(this, spannableStringBuilder, selectionStart, b));
            if (b2 != null) {
                a(spannableStringBuilder, selectionStart, b2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.b bVar) {
        Bitmap h = bVar.h();
        com.baidu.tieba.view.u uVar = new com.baidu.tieba.view.u(h);
        uVar.setBounds(0, 0, h.getWidth() + 1, h.getHeight());
        uVar.setGravity(3);
        spannableStringBuilder.setSpan(new ImageSpan(uVar, 0), 0, spannableStringBuilder.length(), 33);
        this.h.getText().insert(i, spannableStringBuilder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b() {
        this.h.onKeyDown(67, this.m);
    }

    @Override // com.baidu.tbadk.a
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        super.showLoadingDialog(str, onCancelListener);
        this.mWaitingDialog.setCanceledOnTouchOutside(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        String str = null;
        if (this.a.getType() == 0) {
            String trim = this.e.getText().toString().trim();
            if (this.L != null && this.L.getPrefixs().size() > 0) {
                if (this.P == this.L.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.a.setIsNoTitle(true);
                    } else {
                        this.a.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.a.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.a.setIsNoTitle(true);
            } else {
                this.a.setIsNoTitle(false);
                str = "1";
            }
        }
        String trim2 = this.h.getText().toString().trim();
        if (this.A.i()) {
            str = "1";
        } else if (!TextUtils.isEmpty(trim2)) {
            str = "1";
        } else if (this.A.j()) {
            str = "1";
        }
        if (str == null || str.length() <= 0) {
            this.p.setEnabled(false);
        } else {
            this.p.setEnabled(true);
        }
    }

    @Override // com.baidu.tieba.util.n
    public final void a(WriteData writeData) {
        if (writeData != null) {
            this.a.setHaveDraft(true);
            if (com.baidu.adp.lib.util.h.b(this.e.getText().toString()) || (this.b && !com.baidu.adp.lib.util.h.b(writeData.getTitle()))) {
                this.a.setTitle(writeData.getTitle());
                this.e.setText(this.a.getTitle());
            }
            if ((com.baidu.adp.lib.util.h.b(this.h.getText().toString()) || this.b) && !com.baidu.adp.lib.util.h.b(writeData.getContent())) {
                this.a.setContent(writeData.getContent());
                this.h.setText(TbFaceManager.a().a(this.a.getContent(), new av(this)));
            }
            if (writeData.getWriteImagesInfo() != null && this.C.size() == 0) {
                this.C = writeData.getWriteImagesInfo();
                this.a.setWriteImagesInfo(this.C);
            }
            this.A.a(this.C, true);
            k();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.a.getType());
        bundle.putString("forum_id", this.a.getForumId());
        bundle.putString("forum_name", this.a.getForumName());
        bundle.putString("thread_id", this.a.getThreadId());
        bundle.putString("floor_id", this.a.getFloor());
        bundle.putInt("floor_num", this.a.getFloorNum());
        bundle.putBoolean("reply_sub_pb", this.u);
        if (this.b) {
            bundle.putBoolean("feed_back", true);
        }
        bundle.putSerializable("write_images", this.C);
        bundle.putString("photo_name", this.D);
        bundle.putSerializable("addition_data", this.G);
        bundle.putSerializable("prefix_data", this.L);
        super.onSaveInstanceState(bundle);
        d();
        VoiceManager.i();
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String editable = this.h.getEditableText().toString();
        if (editable != null) {
            this.h.setText(TbFaceManager.a().e(editable));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c() {
        if (this.E != null) {
            this.E.cancelLoadData();
        }
        showLoadingDialog(getString(com.baidu.tieba.a.k.sending), this.r);
        if (this.L != null && this.L.getPrefixs().size() > 0 && this.P != this.L.getPrefixs().size() - 1) {
            this.a.setTitle(String.valueOf(this.M.getText().toString()) + this.e.getText().toString());
        } else {
            this.a.setTitle(this.e.getText().toString());
        }
        this.a.setContent(this.h.getText().toString());
        this.a.setWriteImagesInfo(this.C);
        this.E.a(this.C.size() > 0);
        this.E.a(this.a);
        VoiceData.VoiceModel audioData = this.A.getAudioData();
        this.A.m();
        this.a.setVcode(null);
        if (audioData != null) {
            if (audioData.getId() != null) {
                this.E.a().setVoice(audioData.getId());
                this.E.a().setVoiceDuringTime(audioData.duration);
            } else {
                this.E.a().setVoice(null);
                this.E.a().setVoiceDuringTime(-1);
            }
        } else {
            this.E.a().setVoice(null);
            this.E.a().setVoiceDuringTime(-1);
        }
        if (!this.E.b()) {
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        int size;
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 12004) {
                ArrayList<String> a = com.baidu.tieba.util.i.a(intent);
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
                            this.h.getText().insert(this.h.getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                if (this.a.getType() == 0) {
                    com.baidu.tieba.util.m.a(this.a.getForumId(), (WriteData) null);
                } else if (this.a.getType() == 1) {
                    com.baidu.tieba.util.m.b(this.a.getThreadId(), (WriteData) null);
                }
                setResult(-1);
                finish();
            } else if (i == 12002) {
                a(intent, true);
                j();
            } else if (i == 12001) {
                String str = Environment.getExternalStorageDirectory() + "/" + com.baidu.tbadk.core.data.n.f() + "/cameras/" + this.D;
                if (!TextUtils.isEmpty(str)) {
                    try {
                        int b = com.baidu.tbadk.core.util.g.b(str);
                        if (b != 0) {
                            Bitmap a2 = com.baidu.tbadk.core.util.g.a(str, com.baidu.adp.lib.util.i.a(this, com.baidu.adp.lib.util.i.b(this)), com.baidu.adp.lib.util.i.a(this, com.baidu.adp.lib.util.i.c(this)));
                            Bitmap e = com.baidu.tbadk.core.util.g.e(a2, b);
                            if (a2 != e) {
                                a2.recycle();
                            }
                            com.baidu.tbadk.core.util.w.a("cameras", this.D, e, 100);
                            e.recycle();
                        }
                    } catch (Exception e2) {
                    }
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    imageFileInfo.setFilePath(str);
                    imageFileInfo.setTempFile(true);
                    this.C.addChooseFile(imageFileInfo);
                    this.C.updateQuality();
                    this.A.a(this.C, true);
                }
                k();
                int size2 = this.C.size() - 1;
                if (size2 >= 0 && this.C != null && this.C.getChosedFiles() != null && (size = this.C.getChosedFiles().size()) > 0 && size2 >= 0 && size2 < size) {
                    com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.ax(this, 12012, this.C, size2)));
                }
            } else if (i == 12012) {
                a(intent, false);
                j();
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12001:
                    new aw(this).execute(new Void[0]);
                    return;
                case 12002:
                    if (!this.A.i()) {
                        this.z.f();
                        i();
                    }
                    if (intent != null && intent.hasExtra("last_album_id")) {
                        this.C.setLastAlbumId(intent.getStringExtra("last_album_id"));
                        return;
                    }
                    return;
                case 12003:
                case 12004:
                case 12005:
                case 12007:
                case 12008:
                default:
                    return;
                case 12006:
                    setResult(0);
                    finish();
                    return;
                case 12009:
                    try {
                        com.baidu.tbadk.motu_gallery.d.a(this, 12002);
                        return;
                    } catch (Exception e3) {
                        com.baidu.adp.lib.util.f.b("WriteUtil", "getAlbumImage", "error = " + e3.getMessage());
                        return;
                    }
                case 12010:
                    this.D = String.valueOf(System.currentTimeMillis());
                    com.baidu.tbadk.core.util.az.a(this, this.D);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.c, this.e);
        HidenSoftKeyPad(this.c, this.h);
        super.onPause();
        d().c(this);
    }

    private void a(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.C.parseJson(stringExtra);
                this.C.updateQuality();
                if (this.C.getChosedFiles() != null) {
                    this.A.a(this.C, z);
                }
            }
            k();
        }
    }

    private void k() {
        LinkedList<ImageFileInfo> chosedFiles = this.C.getChosedFiles();
        if (chosedFiles != null && chosedFiles.size() > 0) {
            this.z.e();
            this.z.a(new StringBuilder(String.valueOf(chosedFiles.size())).toString());
            this.A.g();
            return;
        }
        this.z.g();
        this.z.f();
        i();
    }

    @Override // com.baidu.tbadk.core.voice.z
    public final synchronized VoiceManager d() {
        if (this.F == null) {
            this.F = VoiceManager.b();
        }
        return this.F;
    }

    @Override // com.baidu.tbadk.core.voice.z
    public final com.baidu.tbadk.core.voice.x a(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(WriteActivity writeActivity) {
        writeActivity.F = writeActivity.d();
        writeActivity.F.f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(WriteActivity writeActivity, AntiData antiData, String str) {
        if (!AntiHelper.a(antiData) && !AntiHelper.b(antiData) && !AntiHelper.c(antiData) && !AntiHelper.d(antiData)) {
            writeActivity.showToast(str);
            return;
        }
        antiData.setBlock_forum_name(writeActivity.a.getForumName());
        AntiHelper.a(writeActivity, antiData, AntiHelper.OperationType.REPLY, AntiHelper.PageType.WRITE);
    }

    @Override // com.baidu.tieba.write.bt
    public final void c(int i) {
        this.P = i;
        this.N.b(i);
        this.M.setText(this.L.getPrefixs().get(i));
        j();
        this.N.dismiss();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.M.setSelected(false);
    }
}
