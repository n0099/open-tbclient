package com.baidu.tieba.write;

import android.app.AlertDialog;
import android.app.Dialog;
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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.kirin.KirinConfig;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.service.NetworkChangeReceiver;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.BaobaoSdkDelegate;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
import com.baidu.tieba.util.AntiHelper;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class WriteActivity extends BaseActivity implements PopupWindow.OnDismissListener, com.baidu.tbadk.core.voice.aa, com.baidu.tieba.util.n, bz {
    private com.baidu.tbadk.editortool.aa B;
    private String E;
    private com.baidu.tieba.model.aq F;
    private VoiceManager G;
    private AdditionData H;
    private RelativeLayout I;
    private TextView J;
    private TextView K;
    private TextView L;
    private PostPrefixData M;
    private TextView N;
    private by O;
    private ImageView P;
    private int Q;
    private RelativeLayout S;
    private TextView T;
    private View U;
    private LiveBroadcastCard V;
    private com.baidu.tieba.view.e ab;
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
    private o j = null;
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
    private WriteImagesInfo D = new WriteImagesInfo();
    private int R = 0;
    private final com.baidu.tieba.model.ar W = new ac(this);
    private final Runnable X = new ao(this);
    private final View.OnClickListener Y = new ay(this);
    private boolean Z = true;
    private final View.OnFocusChangeListener aa = new az(this);
    private com.baidu.tieba.bubble.t ac = new ba(this);

    static {
        TbadkApplication.m252getInst().RegisterIntent(com.baidu.tbadk.core.atomData.bv.class, WriteActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int n() {
        int selectionEnd = this.h.getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) this.h.getText().getSpans(0, this.h.getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = this.h.getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = this.h.getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (!this.Z) {
            this.z.a();
        } else {
            this.z.b();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        d().onResume(this);
        this.A.F();
        if (this.ab != null && this.a != null && this.a.getLiveCardData() != null) {
            new Handler().postDelayed(new bb(this, new Date(this.a.getLiveCardData().getStartTime() * 1000)), 100L);
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        d().onStart(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.A.D();
        d().onStop(this);
        getWindow().setSoftInputMode(18);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        BdLog.addLogPackage(WriteActivity.class.getPackage().getName());
        super.onCreate(bundle);
        this.c = (InputMethodManager) getSystemService("input_method");
        this.B = new com.baidu.tbadk.editortool.aa(this);
        a(bundle);
        q();
        u();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        if (this.F != null) {
            this.F.cancelLoadData();
        }
        if (this.j != null) {
            this.j.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        a();
        x();
        super.onDestroy();
        d().onDestory(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.a != null && this.a.getType() == 2 && this.u) {
            finish();
        } else if (this.a == null) {
            finish();
        } else {
            this.a.setTitle(this.e.getText().toString());
            this.a.setContent(this.h.getText().toString());
            int type = this.a.getType();
            if (this.a.getHaveDraft() && com.baidu.adp.lib.util.i.b(this.a.getTitle()) && com.baidu.adp.lib.util.i.b(this.a.getContent()) && !this.a.isHasImages()) {
                if (type == 0) {
                    if (this.a.getLiveCardData() == null) {
                        com.baidu.tieba.util.m.a(this.a.getForumId(), (WriteData) null);
                    } else {
                        com.baidu.tieba.util.m.a(this.a.getLiveCardData().getGroupId(), (WriteData) null);
                    }
                } else if (type == 1) {
                    com.baidu.tieba.util.m.b(this.a.getThreadId(), (WriteData) null);
                }
            } else if (type == 0) {
                if (this.a.getLiveCardData() == null) {
                    com.baidu.tieba.util.m.a(this.a.getForumId(), this.a);
                } else {
                    com.baidu.tieba.util.m.a(this.a.getLiveCardData().getGroupId(), this.a);
                }
            } else if (type == 1) {
                com.baidu.tieba.util.m.b(this.a.getThreadId(), this.a);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.O != null && this.O.isShowing()) {
                this.O.dismiss();
                return true;
            } else if (this.A.o()) {
                this.z.c();
                this.A.p();
                return true;
            } else {
                a();
                p();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        int color;
        int color2;
        super.onChangeSkinType(i);
        getLayoutMode().a(i == 1);
        getLayoutMode().a((View) this.w);
        this.n.c(i);
        com.baidu.tbadk.core.util.bk.g(this.p, i);
        o();
        if (i == 1) {
            this.f.setBackgroundColor(getResources().getColor(com.baidu.tieba.s.write_line1_1));
            this.e.setBackgroundColor(getResources().getColor(com.baidu.tieba.s.write_title_bg_1));
            if (TextUtils.isEmpty(this.l)) {
                this.h.setBackgroundColor(getResources().getColor(com.baidu.tieba.s.write_content_bg_1));
            }
            color = getResources().getColor(com.baidu.tieba.s.cp_cont_b_1);
            color2 = getResources().getColor(com.baidu.tieba.s.cp_cont_e_1);
        } else {
            this.f.setBackgroundColor(getResources().getColor(com.baidu.tieba.s.write_line1));
            this.e.setBackgroundColor(getResources().getColor(com.baidu.tieba.s.write_title_bg));
            if (TextUtils.isEmpty(this.l)) {
                this.h.setBackgroundColor(getResources().getColor(com.baidu.tieba.s.write_content_bg));
            }
            color = getResources().getColor(com.baidu.tieba.s.cp_cont_b);
            color2 = getResources().getColor(com.baidu.tieba.s.cp_cont_e);
        }
        this.z.a(i);
        this.e.setTextColor(color);
        this.h.setTextColor(color);
        a(this.e, color2);
        a(this.h, color2);
        z();
        this.A.a(i);
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

    private void q() {
        setContentView(com.baidu.tieba.w.write_activity);
        this.n = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.o = this.n.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.q = this.n.a("");
        this.p = this.n.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(com.baidu.tieba.y.send));
        this.p.setOnFocusChangeListener(this.aa);
        this.d = (LinearLayout) findViewById(com.baidu.tieba.v.write_container);
        this.k = (FeedBackTopListView) findViewById(com.baidu.tieba.v.feedback_top_list);
        this.w = (RelativeLayout) findViewById(com.baidu.tieba.v.parent);
        this.f = findViewById(com.baidu.tieba.v.interval_view);
        f();
        this.t.postDelayed(this.X, 200L);
        g();
        if (this.b) {
            this.d.setFocusable(true);
            this.d.setFocusableInTouchMode(true);
            getWindow().setSoftInputMode(18);
        }
        this.g = (LinearLayout) findViewById(com.baidu.tieba.v.post_content_container);
        this.g.setDrawingCacheEnabled(false);
        this.g.setOnClickListener(new bc(this));
        this.o.setOnFocusChangeListener(this.aa);
        this.o.setOnClickListener(new bd(this));
        k();
        h();
        c();
        if (!TbadkApplication.m252getInst().isBaobaoShouldOpen() || this.H != null) {
            this.z.m();
        }
        if (this.a.getType() == 0) {
            if (this.b) {
                this.z.m();
                this.q.setText(com.baidu.tieba.y.feedback);
            } else {
                this.q.setText(com.baidu.tieba.y.post_new_thread);
            }
            this.e.setVisibility(0);
            this.h.setFilters(new InputFilter[]{new InputFilter.LengthFilter(KirinConfig.READ_TIME_OUT)});
        } else {
            this.q.setText(com.baidu.tieba.y.send_reply);
            this.h.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
            this.e.setVisibility(8);
        }
        e();
        w();
        a(y());
        o();
        s();
        t();
        r();
        z();
        if (this.a.getLiveCardData() == null) {
            ShowSoftKeyPad(this.c, this.e);
        }
    }

    private void r() {
        this.S = (RelativeLayout) findViewById(com.baidu.tieba.v.live_time_rel);
        this.T = (TextView) findViewById(com.baidu.tieba.v.live_tiem_show);
        this.U = findViewById(com.baidu.tieba.v.interval_view2);
        this.V = (LiveBroadcastCard) findViewById(com.baidu.tieba.v.live_anchor_card);
        this.S.setOnClickListener(new be(this));
        this.S.setOnTouchListener(new ad(this));
        if (this.a.getLiveCardData() != null) {
            this.S.setVisibility(0);
            this.U.setVisibility(0);
            this.V.setVisibility(0);
            this.V.setClickable(false);
            this.T.setText(com.baidu.tbadk.core.util.bm.b(this.a.getLiveCardData().getStartTime() * 1000));
            this.V.setData(this.a.getLiveCardData());
            return;
        }
        this.S.setVisibility(8);
        this.U.setVisibility(8);
        this.V.setVisibility(8);
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
        if ((dialog instanceof com.baidu.tieba.view.e) && this.a.getLiveCardData() != null) {
            Date date = new Date(this.a.getLiveCardData().getStartTime() * 1000);
            ((com.baidu.tieba.view.e) dialog).updateTime(date.getHours(), date.getMinutes());
        }
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.ab = new com.baidu.tieba.view.e(this, new ae(this), new Date().getHours(), new Date().getMinutes(), false);
        this.ab.setTitle(com.baidu.tieba.y.no_disturb_start_time);
        this.ab.setButton(-1, getString(com.baidu.tieba.y.alert_yes_button), this.ab);
        this.ab.setButton(-2, getString(com.baidu.tieba.y.alert_no_button), this.ab);
        return this.ab;
    }

    private void s() {
        this.I = (RelativeLayout) findViewById(com.baidu.tieba.v.addition_container);
        this.J = (TextView) findViewById(com.baidu.tieba.v.addition_create_time);
        this.K = (TextView) findViewById(com.baidu.tieba.v.addition_last_time);
        this.L = (TextView) findViewById(com.baidu.tieba.v.addition_last_content);
        if (this.H != null) {
            this.I.setVisibility(0);
            this.J.setText(String.valueOf(getString(com.baidu.tieba.y.write_addition_create)) + com.baidu.tbadk.core.util.bm.a(this.H.getCreateTime() * 1000));
            if (this.H.getAlreadyCount() == 0) {
                this.K.setVisibility(8);
            } else {
                this.K.setText(String.valueOf(getString(com.baidu.tieba.y.write_addition_last)) + com.baidu.tbadk.core.util.bm.a(this.H.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.H.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.L.setText(lastAdditionContent);
            } else {
                this.L.setVisibility(8);
            }
            this.h.setHint(String.format(getString(com.baidu.tieba.y.write_addition_hint), Integer.valueOf(this.H.getAlreadyCount()), Integer.valueOf(this.H.getTotalCount())));
            this.q.setText(com.baidu.tieba.y.write_addition_title);
            return;
        }
        this.I.setVisibility(8);
    }

    private void t() {
        int i;
        int i2;
        this.N = (TextView) findViewById(com.baidu.tieba.v.post_prefix);
        if (this.M != null && this.M.getPrefixs().size() > 0) {
            this.N.setVisibility(0);
            ArrayList<String> prefixs = this.M.getPrefixs();
            int size = prefixs.size();
            this.N.setText(prefixs.get(0));
            this.Q = 0;
            this.P = (ImageView) findViewById(com.baidu.tieba.v.prefix_icon);
            if (size > 1) {
                this.P.setVisibility(0);
                this.N.setOnClickListener(new af(this));
            }
            this.O = new by(this);
            this.O.a((bz) this);
            this.O.a(com.baidu.adp.lib.util.j.a((Context) this, 225.0f));
            this.O.setOutsideTouchable(true);
            this.O.setFocusable(true);
            this.O.setOnDismissListener(this);
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                int i3 = com.baidu.tieba.u.write_prefix_item_selector_1;
                int color = getResources().getColor(com.baidu.tieba.s.write_text_1);
                this.O.setBackgroundDrawable(getResources().getDrawable(com.baidu.tieba.s.cp_bg_line_b_1));
                this.N.setBackgroundResource(com.baidu.tieba.u.write_prefix_item_selector_1);
                this.P.setImageResource(com.baidu.tieba.u.icon_title_down_1);
                i = i3;
                i2 = color;
            } else {
                int i4 = com.baidu.tieba.u.write_prefix_item_selector;
                int color2 = getResources().getColor(com.baidu.tieba.s.write_text);
                this.O.setBackgroundDrawable(getResources().getDrawable(com.baidu.tieba.s.cp_bg_line_b));
                this.N.setBackgroundResource(com.baidu.tieba.u.write_prefix_item_selector);
                this.P.setImageResource(com.baidu.tieba.u.icon_title_down);
                i = i4;
                i2 = color2;
            }
            this.N.setTextColor(i2);
            for (int i5 = 0; i5 < size; i5++) {
                TextView textView = new TextView(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.j.a((Context) this, 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i5));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(i2);
                textView.setBackgroundResource(i);
                textView.setPadding(com.baidu.adp.lib.util.j.a(this, getResources().getDimension(com.baidu.tieba.t.ds6)), 0, com.baidu.adp.lib.util.j.a(this, getResources().getDimension(com.baidu.tieba.t.ds22)), 0);
                this.O.a(textView);
                if (i5 != size - 1) {
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.j.a((Context) this, 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(com.baidu.adp.lib.util.j.a(this, getResources().getDimension(com.baidu.tieba.t.ds6)), 0, com.baidu.adp.lib.util.j.a(this, getResources().getDimension(com.baidu.tieba.t.ds22)), 0);
                }
            }
            this.O.b(0);
            return;
        }
        this.N.setVisibility(8);
    }

    private void u() {
        if (this.b && this.a != null) {
            this.k.setVisibility(0);
            this.j = new o();
            this.j.a(this.a.getForumName());
            this.j.setLoadDataCallBack(new ag(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        if (this.i == null) {
            String[] strArr = {getString(com.baidu.tieba.y.take_photo), getString(com.baidu.tieba.y.album)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(com.baidu.tieba.y.operation));
            builder.setItems(strArr, new ah(this));
            this.i = builder.create();
            this.i.setCanceledOnTouchOutside(true);
        }
    }

    protected void c() {
        this.p.setOnClickListener(new ai(this));
    }

    protected void e() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(com.baidu.tieba.y.is_save_draft)).setCancelable(false).setPositiveButton(getString(com.baidu.tieba.y.save), new aj(this)).setNeutralButton(getString(com.baidu.tieba.y.not_save), new al(this));
        this.s = builder.create();
    }

    protected void f() {
        this.e = (EditText) findViewById(com.baidu.tieba.v.post_title);
        this.e.setOnClickListener(this.Y);
        this.e.setOnFocusChangeListener(this.aa);
        if (this.a.getType() == 0) {
            if (this.a.getTitle() != null) {
                this.e.setText(this.a.getTitle());
            } else if (this.b) {
                this.e.setText(getResources().getString(com.baidu.tieba.y.android_feedback));
                this.e.setSelection(getResources().getString(com.baidu.tieba.y.android_feedback).length());
            }
        } else if (this.a.getType() != 1) {
            this.a.getType();
        }
        this.e.addTextChangedListener(new am(this));
    }

    protected void g() {
        this.h = (EditText) findViewById(com.baidu.tieba.v.post_content);
        this.h.setDrawingCacheEnabled(false);
        this.h.setOnClickListener(this.Y);
        if (this.a.getContent() != null && this.a.getContent().length() > 0) {
            this.h.setText(TbFaceManager.a().a(this, this.a.getContent()));
        } else if (this.a.getType() == 2) {
            if (this.u) {
                if (this.v != null && this.v.length() > 0) {
                    this.h.setText(getString(com.baidu.tieba.y.reply_sub_floor, new Object[]{this.v}));
                    this.h.setSelection(this.h.getText().length());
                }
            } else if (this.a.getFloorNum() > 0) {
                String format = String.format(getString(com.baidu.tieba.y.reply_x_floor), Integer.valueOf(this.a.getFloorNum()));
                this.h.setText(format);
                this.h.setSelection(format.length());
            }
        } else if (this.a.getType() == 0 && this.b) {
            StringBuffer stringBuffer = new StringBuffer(30);
            stringBuffer.append(getResources().getString(com.baidu.tieba.y.tieba_client));
            stringBuffer.append(TbConfig.getVersion());
            stringBuffer.append(", ");
            stringBuffer.append(Build.VERSION.RELEASE);
            stringBuffer.append(", ");
            stringBuffer.append(Build.MODEL);
            stringBuffer.append(", ");
            UtilHelper.NetworkStateInfo netStatusInfo = UtilHelper.getNetStatusInfo(this);
            if (netStatusInfo == UtilHelper.NetworkStateInfo.WIFI) {
                stringBuffer.append(NetworkChangeReceiver.WIFI_STRING);
            } else if (netStatusInfo == UtilHelper.NetworkStateInfo.ThreeG) {
                stringBuffer.append("3G");
            } else if (netStatusInfo == UtilHelper.NetworkStateInfo.TwoG) {
                stringBuffer.append("2G");
            } else {
                stringBuffer.append("UNKNOWN");
            }
            stringBuffer.append(":");
            this.h.setText(stringBuffer);
        }
        this.h.setOnFocusChangeListener(this.aa);
        this.h.setOnTouchListener(new an(this));
        this.h.addTextChangedListener(new ap(this));
        a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        this.h.setPadding(0, 0, 0, 0);
        this.h.setBackgroundDrawable(null);
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            this.h.setBackgroundColor(getResources().getColor(com.baidu.tieba.s.write_content_bg_1));
        } else {
            this.h.setBackgroundColor(getResources().getColor(com.baidu.tieba.s.write_content_bg));
        }
        if (!TextUtils.isEmpty(this.l) && this.H == null) {
            this.B.d();
            this.B.f(this.l, new aq(this, z));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean v() {
        int i = KirinConfig.READ_TIME_OUT;
        if (this.H != null) {
            i = 1000;
        }
        return this.h.getText() != null && this.h.getText().length() >= i;
    }

    protected void h() {
        this.A = (EditorToolComponetContainer) findViewById(com.baidu.tieba.v.tool_group);
        this.A.setFrom(1);
        this.A.setOnActionListener(new ar(this));
    }

    protected void i() {
        this.z.c();
        if (this.A.o()) {
            this.A.p();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j() {
        this.A.c(this.h);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i) {
        if (this.A.o()) {
            b(i);
            return;
        }
        this.A.b(this.e);
        this.A.b(this.h);
        new Handler().postDelayed(new as(this, i), 200L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i) {
        if (i == 2) {
            this.z.f();
            this.A.s();
        } else if (i == 5) {
            this.z.g();
            this.A.t();
        } else if (i == 8) {
            this.A.u();
            this.z.h();
        } else if (i == 50) {
            this.A.w();
            this.z.l();
        } else if (i == 44) {
            this.A.v();
            this.z.i();
        }
    }

    protected void k() {
        this.z = (WriteEditorToolButtonContainer) findViewById(com.baidu.tieba.v.write_eidtor_tool_buttons);
        this.z.b();
        this.z.b(this.H == null);
        this.z.setAtFocusable(false);
        this.z.setOnActionListener(new at(this));
        this.z.t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        if (this.A.y()) {
            a(i);
        } else if (!com.baidu.tieba.d.a.a() && this.R == 0) {
            showToast(com.baidu.tieba.y.baobao_over_limit);
        } else {
            String charSequence = this.q.getText().toString();
            BaobaoSdkDelegate baobaoSdkDelegate = (BaobaoSdkDelegate) com.baidu.tbadk.tbplugin.m.a().b(BaobaoSdkDelegate.class);
            if (baobaoSdkDelegate != null) {
                baobaoSdkDelegate.startMatchImage(this, charSequence, 12013);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.coreExtra.data.d dVar) {
        if (((ImageSpan[]) this.h.getText().getSpans(0, this.h.getText().length(), ImageSpan.class)).length >= 10) {
            if (this.x == null) {
                this.x = Toast.makeText(this, com.baidu.tieba.y.too_many_face, 0);
            }
            this.x.show();
            return;
        }
        String a = dVar.a();
        EmotionGroupType b = dVar.b();
        if (a != null) {
            int selectionStart = this.h.getSelectionStart();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(a);
            com.baidu.adp.widget.a.a a2 = this.B.a(a, false, (com.baidu.tbadk.imageManager.d) new au(this, spannableStringBuilder, selectionStart, b));
            if (a2 != null) {
                a(spannableStringBuilder, selectionStart, a2, b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        Bitmap h = aVar.h();
        com.baidu.tieba.view.x xVar = new com.baidu.tieba.view.x(h);
        xVar.setBounds(0, 0, h.getWidth() + 1, h.getHeight());
        xVar.setGravity(3);
        spannableStringBuilder.setSpan(new ImageSpan(xVar, 0), 0, spannableStringBuilder.length(), 33);
        this.h.getText().insert(i, spannableStringBuilder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l() {
        this.h.onKeyDown(67, this.m);
    }

    private void a(Boolean bool) {
        String str = null;
        if (this.a != null) {
            str = this.a.getForumName();
        }
        if (com.baidu.tieba.d.b.a(str, bool)) {
            this.z.a(true);
        } else {
            this.z.a(false);
        }
    }

    private void w() {
        d().onCreate(this);
    }

    private void x() {
        try {
            if (this.s != null && this.s.isShowing()) {
                this.s.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        super.showLoadingDialog(str, onCancelListener);
        this.mWaitingDialog.setCanceledOnTouchOutside(false);
    }

    private Boolean y() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("enable_audio")) {
                bool = Boolean.valueOf(intent.getBooleanExtra("enable_audio", true));
            }
            if (intent.hasExtra("disable_audio_message")) {
                this.y = intent.getStringExtra("disable_audio_message");
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        String str = null;
        if (this.a.getType() == 0) {
            String trim = this.e.getText().toString().trim();
            if (this.M != null && this.M.getPrefixs().size() > 0) {
                if (this.Q == this.M.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.a.setIsNoTitle(true);
                    } else {
                        this.a.setIsNoTitle(false);
                        str = TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK;
                    }
                } else {
                    this.a.setIsNoTitle(false);
                    str = TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK;
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.a.setIsNoTitle(true);
            } else {
                this.a.setIsNoTitle(false);
                str = TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK;
            }
        }
        String trim2 = this.h.getText().toString().trim();
        if (this.A.x()) {
            str = TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK;
        } else if (!TextUtils.isEmpty(trim2)) {
            str = TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK;
        } else if (this.A.z()) {
            str = TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK;
        } else if (this.A.y()) {
            str = TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK;
        }
        if (str == null || str.length() <= 0) {
            this.p.setEnabled(false);
        } else {
            this.p.setEnabled(true);
        }
    }

    private void a(Bundle bundle) {
        this.F = new com.baidu.tieba.model.aq();
        this.F.a(this.W);
        this.r = new av(this);
        this.a = new WriteData();
        if (bundle != null) {
            this.a.setType(bundle.getInt("type", 0));
            this.a.setForumId(bundle.getString(com.baidu.tbadk.core.frameworkData.a.FORUM_ID));
            this.a.setForumName(bundle.getString(com.baidu.tbadk.core.frameworkData.a.FORUM_NAME));
            this.a.setThreadId(bundle.getString(com.baidu.tbadk.core.frameworkData.a.THREAD_ID));
            this.a.setFloor(bundle.getString("floor_id"));
            this.a.setFloorNum(bundle.getInt("floor_num", 0));
            this.b = bundle.getBoolean("feed_back", false);
            this.u = bundle.getBoolean("reply_sub_pb", false);
            this.v = bundle.getString("sub_user_name");
            this.C = (WriteImagesInfo) bundle.getSerializable("write_images");
            this.D = (WriteImagesInfo) bundle.getSerializable("baobao_images");
            this.E = bundle.getString("photo_name");
            this.H = (AdditionData) bundle.getSerializable("addition_data");
            this.a.setIsAddition(this.H != null);
            this.M = (PostPrefixData) bundle.getSerializable("prefix_data");
            this.R = bundle.getInt("mem_type", 0);
            if (bundle.getBoolean("is_live_post")) {
                LiveCardData liveCardData = new LiveCardData();
                liveCardData.setStartTime(bundle.getLong("live_date"));
                liveCardData.setAuthorName(bundle.getString("live_group_author"));
                liveCardData.setPortrait(bundle.getString("live_group_head"));
                liveCardData.setIntro(bundle.getString("live_group_intro"));
                liveCardData.setListeners(bundle.getInt("live_group_member_count", 0));
                liveCardData.setName(bundle.getString("live_group_name"));
                liveCardData.setLikers(bundle.getInt("live_group_zan_count", 0));
                liveCardData.setGroupId(bundle.getInt("live_group_id", 0));
                liveCardData.setModifyTime(bundle.getBoolean("live_time_is_modify"));
                liveCardData.setPublisherPortrait(bundle.getString("live_group_author_head"));
                this.a.setLiveCardData(liveCardData);
            }
        } else {
            Intent intent = getIntent();
            this.a.setType(intent.getIntExtra("type", 0));
            this.a.setForumId(intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.FORUM_ID));
            this.a.setForumName(intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.FORUM_NAME));
            this.a.setThreadId(intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.THREAD_ID));
            this.a.setFloor(intent.getStringExtra("floor_id"));
            this.a.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.b = intent.getBooleanExtra("feed_back", false);
            this.u = intent.getBooleanExtra("reply_sub_pb", false);
            this.v = intent.getStringExtra("sub_user_name");
            this.H = (AdditionData) intent.getSerializableExtra("addition_data");
            this.a.setIsAddition(this.H != null);
            this.M = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.R = intent.getIntExtra("mem_type", 0);
            if (intent.getBooleanExtra("is_live_post", false)) {
                LiveCardData liveCardData2 = new LiveCardData();
                liveCardData2.setStartTime(new Date().getTime() / 1000);
                liveCardData2.setAuthorName(intent.getStringExtra("live_group_author"));
                liveCardData2.setPortrait(intent.getStringExtra("live_group_head"));
                liveCardData2.setIntro(intent.getStringExtra("live_group_intro"));
                liveCardData2.setListeners(intent.getIntExtra("live_group_member_count", 0));
                liveCardData2.setName(intent.getStringExtra("live_group_name"));
                liveCardData2.setLikers(intent.getIntExtra("live_group_zan_count", 0));
                liveCardData2.setGroupId(intent.getIntExtra("live_group_id", 0));
                liveCardData2.setPublisherPortrait(intent.getStringExtra("live_group_author_head"));
                this.a.setLiveCardData(liveCardData2);
            }
        }
        this.D.setMaxImagesAllowed(1);
        this.C.setMaxImagesAllowed(10);
        this.a.setWriteImagesInfo(this.C);
        this.a.setBaobaoImagesInfo(this.D);
        if (this.a.getType() == 0) {
            if (this.a.getLiveCardData() == null) {
                com.baidu.tieba.util.m.b(this.a.getForumId(), this);
            } else {
                com.baidu.tieba.util.m.a(this.a.getLiveCardData().getGroupId(), this);
            }
        } else if (this.a.getType() == 1) {
            com.baidu.tieba.util.m.a(this.a.getThreadId(), this);
        }
        if (this.M != null && this.M.getPrefixs().size() > 0) {
            this.M.getPrefixs().add(getString(com.baidu.tieba.y.write_no_prefix));
        }
        this.l = TbadkApplication.m252getInst().getDefaultBubble();
    }

    @Override // com.baidu.tieba.util.n
    public void a(WriteData writeData) {
        if (writeData != null) {
            this.a.setHaveDraft(true);
            if (com.baidu.adp.lib.util.i.b(this.e.getText().toString()) || (this.b && !com.baidu.adp.lib.util.i.b(writeData.getTitle()))) {
                this.a.setTitle(writeData.getTitle());
                this.e.setText(this.a.getTitle());
            }
            if (writeData.getLiveCardData() != null) {
                Date date = new Date(writeData.getLiveCardData().getStartTime() * 1000);
                Date date2 = new Date();
                date.setYear(date2.getYear());
                date.setMonth(date2.getMonth());
                date.setDate(date2.getDate());
                this.a.getLiveCardData().setStartTime(date.getTime() / 1000);
                this.T.setText(com.baidu.tbadk.core.util.bm.b(this.a.getLiveCardData().getStartTime() * 1000));
            }
            if ((com.baidu.adp.lib.util.i.b(this.h.getText().toString()) || this.b) && !com.baidu.adp.lib.util.i.b(writeData.getContent())) {
                this.a.setContent(writeData.getContent());
                this.h.setText(TbFaceManager.a().a(this, this.a.getContent(), new aw(this)));
            }
            if (writeData.getWriteImagesInfo() != null && this.C.size() == 0) {
                this.C = writeData.getWriteImagesInfo();
                this.a.setWriteImagesInfo(this.C);
                this.A.a(this.C, true);
                B();
            }
            if (TbadkApplication.m252getInst().isBaobaoShouldOpen()) {
                if (writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                    this.D.copyFrom(writeData.getBaobaoImagesInfo());
                    this.a.setIsBaobao(writeData.getIsBaobao());
                    this.a.setBaobaoContent(writeData.getBaobaoContent());
                    this.a.setBaobaoImagesInfo(this.D);
                }
                if (this.a.getIsBaobao()) {
                    this.A.setBaobaoUris(this.D);
                    C();
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.a.getType());
        bundle.putString(com.baidu.tbadk.core.frameworkData.a.FORUM_ID, this.a.getForumId());
        bundle.putString(com.baidu.tbadk.core.frameworkData.a.FORUM_NAME, this.a.getForumName());
        bundle.putString(com.baidu.tbadk.core.frameworkData.a.THREAD_ID, this.a.getThreadId());
        bundle.putString("floor_id", this.a.getFloor());
        bundle.putInt("floor_num", this.a.getFloorNum());
        bundle.putBoolean("reply_sub_pb", this.u);
        if (this.b) {
            bundle.putBoolean("feed_back", true);
        }
        bundle.putSerializable("write_images", this.C);
        bundle.putSerializable("baobao_images", this.D);
        bundle.putString("photo_name", this.E);
        bundle.putSerializable("addition_data", this.H);
        bundle.putSerializable("prefix_data", this.M);
        bundle.putInt("mem_type", this.R);
        if (this.a.getLiveCardData() != null) {
            bundle.putBoolean("is_live_post", true);
            bundle.putInt("live_group_id", this.a.getLiveCardData().getGroupId());
            bundle.putString("live_group_head", this.a.getLiveCardData().getPortrait());
            bundle.putString("live_group_intro", this.a.getLiveCardData().getIntro());
            bundle.putString("live_group_name", this.a.getLiveCardData().getName());
            bundle.putInt("live_group_member_count", this.a.getLiveCardData().getListeners());
            bundle.putInt("live_group_zan_count", this.a.getLiveCardData().getLikers());
            bundle.putLong("live_date", this.a.getLiveCardData().getStartTime());
            bundle.putBoolean("live_time_is_modify", this.a.getLiveCardData().isModifyTime());
            bundle.putString("live_group_author_head", this.a.getLiveCardData().getPublisherPortrait());
        }
        super.onSaveInstanceState(bundle);
        d().onSaveInstanceState(this);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String editable = this.h.getEditableText().toString();
        if (editable != null) {
            this.h.setText(TbFaceManager.a().a(this, editable));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m() {
        a();
        if (this.a.getLiveCardData() != null) {
            if (!this.a.getLiveCardData().isModifyTime()) {
                this.a.getLiveCardData().setStartTime(new Date().getTime() / 1000);
                this.T.setText(com.baidu.tbadk.core.util.bm.b(this.a.getLiveCardData().getStartTime() * 1000));
            }
            long time = new Date().getTime() / TbConfig.USE_TIME_INTERVAL;
            Date date = new Date(this.a.getLiveCardData().getStartTime() * 1000);
            Date date2 = new Date();
            date.setYear(date2.getYear());
            date.setMonth(date2.getMonth());
            date.setDate(date2.getDate());
            this.a.getLiveCardData().setStartTime(date.getTime() / 1000);
            if (time > this.a.getLiveCardData().getStartTime() / 60) {
                showToast(com.baidu.tieba.y.live_start_time_error);
                return;
            }
        }
        if (this.M != null && this.M.getPrefixs().size() > 0 && this.Q != this.M.getPrefixs().size() - 1) {
            this.a.setTitle(String.valueOf(this.N.getText().toString()) + this.e.getText().toString());
        } else {
            this.a.setTitle(this.e.getText().toString());
        }
        this.a.setContent(this.h.getText().toString());
        this.a.setWriteImagesInfo(this.C);
        this.a.setBaobaoImagesInfo(this.D);
        this.F.a(this.C.size() > 0);
        this.F.a(this.a);
        VoiceData.VoiceModel audioData = this.A.getAudioData();
        this.A.C();
        this.a.setVcode(null);
        if (audioData != null) {
            if (audioData.getId() != null) {
                this.F.a().setVoice(audioData.getId());
                this.F.a().setVoiceDuringTime(audioData.duration);
            } else {
                this.F.a().setVoice(null);
                this.F.a().setVoiceDuringTime(-1);
            }
        } else {
            this.F.a().setVoice(null);
            this.F.a().setVoiceDuringTime(-1);
        }
        if (!this.F.c()) {
            showToast(com.baidu.tieba.y.write_img_limit);
        } else if (this.F.b()) {
            showLoadingDialog(getString(com.baidu.tieba.y.sending), this.r);
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
                a(intent);
                z();
                this.A.setVisibility(0);
            } else if (i == 12001) {
                b(intent);
                int size2 = this.C.size() - 1;
                if (size2 > -1 && this.C != null && this.C.getChosedFiles() != null && (size = this.C.getChosedFiles().size()) >= 1 && size2 >= 0 && size2 < size) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.bx(this, 12012, this.C, size2)));
                }
            } else if (i == 12012) {
                c(intent);
                z();
            } else if (i == 12013) {
                d(intent);
                z();
            } else if (i == 23004) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12001:
                    A();
                    return;
                case 12002:
                    if (!this.A.x()) {
                        this.z.j();
                        i();
                    }
                    if (intent != null && intent.hasExtra("last_album_id")) {
                        this.C.setLastAlbumId(intent.getStringExtra("last_album_id"));
                        return;
                    }
                    return;
                case 12009:
                    cb.a(this);
                    return;
                case 12010:
                    this.E = String.valueOf(System.currentTimeMillis());
                    com.baidu.tbadk.core.util.bj.a(this, this.E);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.c, this.e);
        HidenSoftKeyPad(this.c, this.h);
        super.onPause();
        d().onPause(this);
    }

    private void a(Intent intent) {
        a(intent, true);
    }

    private void b(Intent intent) {
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.E;
        if (!TextUtils.isEmpty(str)) {
            try {
                int b = com.baidu.tbadk.core.util.h.b(str);
                if (b != 0) {
                    Bitmap a = com.baidu.tbadk.core.util.h.a(str, com.baidu.adp.lib.util.j.a(this, com.baidu.adp.lib.util.j.b(this)), com.baidu.adp.lib.util.j.a(this, com.baidu.adp.lib.util.j.c(this)));
                    Bitmap e = com.baidu.tbadk.core.util.h.e(a, b);
                    if (a != e) {
                        a.recycle();
                    }
                    com.baidu.tbadk.core.util.z.a(TbConfig.LOCAL_CAMERA_DIR, this.E, e, 100);
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
        B();
    }

    private void c(Intent intent) {
        a(intent, false);
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
            B();
        }
    }

    private void d(Intent intent) {
        if (this.a != null) {
            String stringExtra = intent.getStringExtra(BaobaoSdkDelegate.KEY_BITMAPPATH);
            String stringExtra2 = intent.getStringExtra(BaobaoSdkDelegate.KEY_CONTENT);
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(stringExtra);
            this.D.clear();
            this.D.addChooseFile(imageFileInfo);
            this.a.setIsBaobao(true);
            this.a.setBaobaoContent(stringExtra2);
            this.A.setBaobaoUris(this.D);
            C();
        }
    }

    private void A() {
        new ax(this).execute(new Void[0]);
    }

    private void B() {
        LinkedList<ImageFileInfo> chosedFiles = this.C.getChosedFiles();
        if (chosedFiles != null && chosedFiles.size() > 0) {
            this.z.h();
            this.z.a(new StringBuilder(String.valueOf(chosedFiles.size())).toString());
            this.A.u();
            return;
        }
        this.z.n();
        this.z.j();
        i();
    }

    private void C() {
        LinkedList<ImageFileInfo> chosedFiles = this.D.getChosedFiles();
        if (chosedFiles != null && chosedFiles.size() > 0) {
            this.z.l();
            this.z.b(TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
            this.A.w();
            this.a.setIsBaobao(true);
            return;
        }
        this.z.s();
        this.a.setIsBaobao(false);
        this.z.k();
        i();
    }

    @Override // com.baidu.tbadk.core.voice.aa
    public synchronized VoiceManager d() {
        if (this.G == null) {
            this.G = VoiceManager.instance();
        }
        return this.G;
    }

    @Override // com.baidu.tbadk.core.voice.aa
    public com.baidu.tbadk.core.voice.y a(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        this.G = d();
        this.G.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, String str) {
        if (AntiHelper.a(antiData) || AntiHelper.b(antiData) || AntiHelper.c(antiData) || AntiHelper.d(antiData)) {
            antiData.setBlock_forum_name(this.a.getForumName());
            AntiHelper.a(this, antiData, AntiHelper.OperationType.REPLY, AntiHelper.PageType.WRITE);
            return;
        }
        showToast(str);
    }

    @Override // com.baidu.tieba.write.bz
    public void c(int i) {
        this.Q = i;
        this.O.b(i);
        this.N.setText(this.M.getPrefixs().get(i));
        z();
        this.O.dismiss();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.N.setSelected(false);
    }
}
