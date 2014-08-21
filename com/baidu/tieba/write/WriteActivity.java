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
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.cf;
import com.baidu.tbadk.core.atomData.ch;
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
public class WriteActivity extends BaseActivity implements PopupWindow.OnDismissListener, com.baidu.tbadk.core.voice.aa, com.baidu.tieba.util.n, ca {
    private String F;
    private com.baidu.tieba.model.ar G;
    private VoiceManager H;
    private AdditionData I;
    private RelativeLayout J;
    private TextView K;
    private TextView L;
    private TextView M;
    private PostPrefixData N;
    private TextView O;
    private bz P;
    private ImageView Q;
    private int R;
    private RelativeLayout T;
    private TextView U;
    private View V;
    private LiveBroadcastCard W;
    private com.baidu.tieba.view.c ac;
    private Toast z;
    private WriteData a = null;
    private boolean b = false;
    private boolean c = false;
    private InputMethodManager d = null;
    private LinearLayout e = null;
    private EditText f = null;
    private View g = null;
    private LinearLayout h = null;
    private EditText i = null;
    private AlertDialog j = null;
    private o k = null;
    private FeedBackTopListView l = null;
    private String m = null;
    private final KeyEvent n = new KeyEvent(0, 67);
    private NavigationBar o = null;
    private View p = null;
    private Button q = null;
    private TextView r = null;
    private TextView s = null;
    private DialogInterface.OnCancelListener t = null;
    private AlertDialog u = null;
    private final Handler v = new Handler();
    private boolean w = false;
    private String x = null;
    private RelativeLayout y = null;
    private String A = null;
    private WriteEditorToolButtonContainer B = null;
    private EditorToolComponetContainer C = null;
    private WriteImagesInfo D = new WriteImagesInfo();
    private WriteImagesInfo E = new WriteImagesInfo();
    private int S = 0;
    private final com.baidu.tieba.model.as X = new ac(this);
    private final Runnable Y = new ao(this);
    private final View.OnClickListener Z = new az(this);
    private boolean aa = true;
    private final View.OnFocusChangeListener ab = new ba(this);
    private com.baidu.tieba.bubble.t ad = new bb(this);

    static {
        TbadkApplication.m252getInst().RegisterIntent(cf.class, WriteActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int n() {
        int selectionEnd = this.i.getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) this.i.getText().getSpans(0, this.i.getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = this.i.getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = this.i.getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (!this.aa) {
            this.B.a();
        } else {
            this.B.b();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        d().onResume(this);
        this.C.F();
        if (this.ac != null && this.a != null && this.a.getLiveCardData() != null) {
            new Handler().postDelayed(new bc(this, new Date(this.a.getLiveCardData().getStartTime() * 1000)), 100L);
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
        this.C.D();
        d().onStop(this);
        getWindow().setSoftInputMode(18);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        BdLog.addLogPackage(WriteActivity.class.getPackage().getName());
        super.onCreate(bundle);
        this.d = (InputMethodManager) getSystemService("input_method");
        a(bundle);
        q();
        u();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        if (this.G != null) {
            this.G.cancelLoadData();
        }
        if (this.k != null) {
            this.k.cancelLoadData();
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
        if (this.a != null && this.a.getType() == 2 && this.w) {
            finish();
        } else if (this.a == null) {
            finish();
        } else {
            this.a.setTitle(this.f.getText().toString());
            this.a.setContent(this.i.getText().toString());
            int type = this.a.getType();
            if (this.a.getHaveDraft() && com.baidu.adp.lib.util.i.c(this.a.getTitle()) && com.baidu.adp.lib.util.i.c(this.a.getContent()) && !this.a.isHasImages()) {
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
            if (this.P != null && this.P.isShowing()) {
                com.baidu.adp.lib.e.e.a(this.P, this);
                return true;
            } else if (this.C.o()) {
                this.B.c();
                this.C.p();
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
        getLayoutMode().a((View) this.y);
        this.o.c(i);
        com.baidu.tbadk.core.util.ay.g(this.r, i);
        o();
        if (i == 1) {
            this.g.setBackgroundColor(getResources().getColor(com.baidu.tieba.r.write_line1_1));
            this.f.setBackgroundColor(getResources().getColor(com.baidu.tieba.r.write_title_bg_1));
            if (TextUtils.isEmpty(this.m)) {
                this.i.setBackgroundColor(getResources().getColor(com.baidu.tieba.r.write_content_bg_1));
            }
            color = getResources().getColor(com.baidu.tieba.r.cp_cont_b_1);
            color2 = getResources().getColor(com.baidu.tieba.r.cp_cont_e_1);
        } else {
            this.g.setBackgroundColor(getResources().getColor(com.baidu.tieba.r.write_line1));
            this.f.setBackgroundColor(getResources().getColor(com.baidu.tieba.r.write_title_bg));
            if (TextUtils.isEmpty(this.m)) {
                this.i.setBackgroundColor(getResources().getColor(com.baidu.tieba.r.write_content_bg));
            }
            color = getResources().getColor(com.baidu.tieba.r.cp_cont_b);
            color2 = getResources().getColor(com.baidu.tieba.r.cp_cont_e);
        }
        this.B.a(i);
        this.f.setTextColor(color);
        this.i.setTextColor(color);
        a(this.f, color2);
        a(this.i, color2);
        z();
        this.C.a(i);
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
        setContentView(com.baidu.tieba.v.write_activity);
        this.o = (NavigationBar) findViewById(com.baidu.tieba.u.view_navigation_bar);
        this.p = this.o.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.s = this.o.a("");
        this.q = (Button) findViewById(com.baidu.tieba.u.btn_image_problem);
        this.r = this.o.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(com.baidu.tieba.x.send));
        this.r.setOnFocusChangeListener(this.ab);
        this.e = (LinearLayout) findViewById(com.baidu.tieba.u.write_container);
        this.l = (FeedBackTopListView) findViewById(com.baidu.tieba.u.feedback_top_list);
        this.y = (RelativeLayout) findViewById(com.baidu.tieba.u.parent);
        this.g = findViewById(com.baidu.tieba.u.interval_view);
        f();
        this.v.postDelayed(this.Y, 200L);
        g();
        if (this.b || this.c) {
            this.e.setFocusable(true);
            this.e.setFocusableInTouchMode(true);
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.httpNet.a.a().f()) {
                findViewById(com.baidu.tieba.u.ll_image_problem).setVisibility(0);
            } else {
                findViewById(com.baidu.tieba.u.ll_image_problem).setVisibility(8);
            }
        }
        this.h = (LinearLayout) findViewById(com.baidu.tieba.u.post_content_container);
        this.h.setDrawingCacheEnabled(false);
        this.h.setOnClickListener(new bd(this));
        this.p.setOnFocusChangeListener(this.ab);
        this.p.setOnClickListener(new be(this));
        this.q.setOnClickListener(new bf(this));
        k();
        h();
        c();
        if (!TbadkApplication.m252getInst().isBaobaoShouldOpen() || this.I != null) {
            this.B.m();
        }
        if (this.a.getType() == 0) {
            if (this.b || this.c) {
                this.B.m();
                this.s.setText(com.baidu.tieba.x.feedback);
            } else {
                this.s.setText(com.baidu.tieba.x.post_new_thread);
            }
            this.f.setVisibility(0);
            this.i.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
        } else {
            this.s.setText(com.baidu.tieba.x.send_reply);
            this.i.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
            this.f.setVisibility(8);
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
            ShowSoftKeyPad(this.d, this.f);
        }
    }

    private void r() {
        this.T = (RelativeLayout) findViewById(com.baidu.tieba.u.live_time_rel);
        this.U = (TextView) findViewById(com.baidu.tieba.u.live_tiem_show);
        this.V = findViewById(com.baidu.tieba.u.interval_view2);
        this.W = (LiveBroadcastCard) findViewById(com.baidu.tieba.u.live_anchor_card);
        this.T.setOnClickListener(new ad(this));
        this.T.setOnTouchListener(new ae(this));
        if (this.a.getLiveCardData() != null) {
            this.T.setVisibility(0);
            this.V.setVisibility(0);
            this.W.setVisibility(0);
            this.W.setClickable(false);
            this.U.setText(com.baidu.tbadk.core.util.ba.b(this.a.getLiveCardData().getStartTime() * 1000));
            this.W.setData(this.a.getLiveCardData());
            return;
        }
        this.T.setVisibility(8);
        this.V.setVisibility(8);
        this.W.setVisibility(8);
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
        if ((dialog instanceof com.baidu.tieba.view.c) && this.a.getLiveCardData() != null) {
            Date date = new Date(this.a.getLiveCardData().getStartTime() * 1000);
            ((com.baidu.tieba.view.c) dialog).updateTime(date.getHours(), date.getMinutes());
        }
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.ac = new com.baidu.tieba.view.c(this, new af(this), new Date().getHours(), new Date().getMinutes(), false);
        this.ac.setTitle(com.baidu.tieba.x.no_disturb_start_time);
        this.ac.setButton(-1, getString(com.baidu.tieba.x.alert_yes_button), this.ac);
        this.ac.setButton(-2, getString(com.baidu.tieba.x.alert_no_button), this.ac);
        return this.ac;
    }

    private void s() {
        this.J = (RelativeLayout) findViewById(com.baidu.tieba.u.addition_container);
        this.K = (TextView) findViewById(com.baidu.tieba.u.addition_create_time);
        this.L = (TextView) findViewById(com.baidu.tieba.u.addition_last_time);
        this.M = (TextView) findViewById(com.baidu.tieba.u.addition_last_content);
        if (this.I != null) {
            this.J.setVisibility(0);
            this.K.setText(String.valueOf(getString(com.baidu.tieba.x.write_addition_create)) + com.baidu.tbadk.core.util.ba.a(this.I.getCreateTime() * 1000));
            if (this.I.getAlreadyCount() == 0) {
                this.L.setVisibility(8);
            } else {
                this.L.setText(String.valueOf(getString(com.baidu.tieba.x.write_addition_last)) + com.baidu.tbadk.core.util.ba.a(this.I.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.I.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.M.setText(lastAdditionContent);
            } else {
                this.M.setVisibility(8);
            }
            this.i.setHint(String.format(getString(com.baidu.tieba.x.write_addition_hint), Integer.valueOf(this.I.getAlreadyCount()), Integer.valueOf(this.I.getTotalCount())));
            this.s.setText(com.baidu.tieba.x.write_addition_title);
            return;
        }
        this.J.setVisibility(8);
    }

    private void t() {
        int i;
        int i2;
        this.O = (TextView) findViewById(com.baidu.tieba.u.post_prefix);
        if (this.N != null && this.N.getPrefixs().size() > 0) {
            this.O.setVisibility(0);
            ArrayList<String> prefixs = this.N.getPrefixs();
            int size = prefixs.size();
            this.O.setText(prefixs.get(0));
            this.R = 0;
            this.Q = (ImageView) findViewById(com.baidu.tieba.u.prefix_icon);
            if (size > 1) {
                this.Q.setVisibility(0);
                this.O.setOnClickListener(new ag(this));
            }
            this.P = new bz(this);
            this.P.a((ca) this);
            this.P.a(com.baidu.adp.lib.util.j.a((Context) this, 225.0f));
            this.P.setOutsideTouchable(true);
            this.P.setFocusable(true);
            this.P.setOnDismissListener(this);
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                int i3 = com.baidu.tieba.t.write_prefix_item_selector_1;
                int color = getResources().getColor(com.baidu.tieba.r.write_text_1);
                this.P.setBackgroundDrawable(getResources().getDrawable(com.baidu.tieba.r.cp_bg_line_b_1));
                this.O.setBackgroundResource(com.baidu.tieba.t.write_prefix_item_selector_1);
                this.Q.setImageResource(com.baidu.tieba.t.icon_title_down_1);
                i = i3;
                i2 = color;
            } else {
                int i4 = com.baidu.tieba.t.write_prefix_item_selector;
                int color2 = getResources().getColor(com.baidu.tieba.r.write_text);
                this.P.setBackgroundDrawable(getResources().getDrawable(com.baidu.tieba.r.cp_bg_line_b));
                this.O.setBackgroundResource(com.baidu.tieba.t.write_prefix_item_selector);
                this.Q.setImageResource(com.baidu.tieba.t.icon_title_down);
                i = i4;
                i2 = color2;
            }
            this.O.setTextColor(i2);
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
                textView.setPadding(com.baidu.adp.lib.util.j.a(this, getResources().getDimension(com.baidu.tieba.s.ds6)), 0, com.baidu.adp.lib.util.j.a(this, getResources().getDimension(com.baidu.tieba.s.ds22)), 0);
                this.P.a(textView);
                if (i5 != size - 1) {
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.j.a((Context) this, 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(com.baidu.adp.lib.util.j.a(this, getResources().getDimension(com.baidu.tieba.s.ds6)), 0, com.baidu.adp.lib.util.j.a(this, getResources().getDimension(com.baidu.tieba.s.ds22)), 0);
                }
            }
            this.P.b(0);
            return;
        }
        this.O.setVisibility(8);
    }

    private void u() {
        if (this.b && this.a != null) {
            this.l.setVisibility(0);
            this.k = new o();
            this.k.a(this.a.getForumName());
            this.k.setLoadDataCallBack(new ah(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        if (this.j == null) {
            String[] strArr = {getString(com.baidu.tieba.x.take_photo), getString(com.baidu.tieba.x.album)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(com.baidu.tieba.x.operation));
            builder.setItems(strArr, new ai(this));
            this.j = builder.create();
            this.j.setCanceledOnTouchOutside(true);
        }
    }

    protected void c() {
        this.r.setOnClickListener(new aj(this));
    }

    protected void e() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(com.baidu.tieba.x.is_save_draft)).setCancelable(false).setPositiveButton(getString(com.baidu.tieba.x.save), new ak(this)).setNeutralButton(getString(com.baidu.tieba.x.not_save), new am(this));
        this.u = builder.create();
    }

    protected void f() {
        this.f = (EditText) findViewById(com.baidu.tieba.u.post_title);
        this.f.setOnClickListener(this.Z);
        this.f.setOnFocusChangeListener(this.ab);
        if (this.a.getType() == 0) {
            if (this.a.getTitle() != null) {
                this.f.setText(this.a.getTitle());
                this.f.setSelection(this.a.getTitle().length());
            }
        } else if (this.a.getType() != 1) {
            this.a.getType();
        }
        this.f.addTextChangedListener(new an(this));
    }

    protected void g() {
        this.i = (EditText) findViewById(com.baidu.tieba.u.post_content);
        this.i.setDrawingCacheEnabled(false);
        this.i.setOnClickListener(this.Z);
        if (this.a.getContent() != null && this.a.getContent().length() > 0) {
            SpannableString a = TbFaceManager.a().a(this, this.a.getContent());
            this.i.setText(a);
            this.i.setSelection(a.length());
        } else if (this.a.getType() == 2) {
            if (this.w) {
                if (this.x != null && this.x.length() > 0) {
                    this.i.setText(getString(com.baidu.tieba.x.reply_sub_floor, new Object[]{this.x}));
                    this.i.setSelection(this.i.getText().length());
                }
            } else if (this.a.getFloorNum() > 0) {
                String format = String.format(getString(com.baidu.tieba.x.reply_x_floor), Integer.valueOf(this.a.getFloorNum()));
                this.i.setText(format);
                this.i.setSelection(format.length());
            }
        }
        this.i.setOnFocusChangeListener(this.ab);
        this.i.setOnTouchListener(new ap(this));
        this.i.addTextChangedListener(new aq(this));
        a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        this.i.setPadding(0, 0, 0, 0);
        this.i.setBackgroundDrawable(null);
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            this.i.setBackgroundColor(getResources().getColor(com.baidu.tieba.r.write_content_bg_1));
        } else {
            this.i.setBackgroundColor(getResources().getColor(com.baidu.tieba.r.write_content_bg));
        }
        if (!TextUtils.isEmpty(this.m) && this.I == null) {
            com.baidu.adp.lib.resourceLoader.d.a().a(this.m, 19, new ar(this, z), getUniqueId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean v() {
        int i = 5000;
        if (this.I != null) {
            i = 1000;
        }
        return this.i.getText() != null && this.i.getText().length() >= i;
    }

    protected void h() {
        this.C = (EditorToolComponetContainer) findViewById(com.baidu.tieba.u.tool_group);
        this.C.setFrom(1);
        this.C.setOnActionListener(new as(this));
    }

    protected void i() {
        this.B.c();
        if (this.C.o()) {
            this.C.p();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j() {
        this.C.c(this.i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i) {
        if (this.C.o()) {
            b(i);
            return;
        }
        this.C.b(this.f);
        this.C.b(this.i);
        new Handler().postDelayed(new at(this, i), 200L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i) {
        if (i == 2) {
            this.B.f();
            this.C.s();
        } else if (i == 5) {
            this.B.g();
            this.C.t();
        } else if (i == 8) {
            this.C.u();
            this.B.h();
        } else if (i == 50) {
            this.C.w();
            this.B.l();
        } else if (i == 44) {
            this.C.v();
            this.B.i();
        }
    }

    protected void k() {
        this.B = (WriteEditorToolButtonContainer) findViewById(com.baidu.tieba.u.write_eidtor_tool_buttons);
        this.B.b();
        this.B.b(this.I == null);
        this.B.setAtFocusable(false);
        this.B.setOnActionListener(new au(this));
        this.B.t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        BaobaoSdkDelegate baobaoSdkDelegate;
        if (this.C.y()) {
            a(i);
        } else if (!com.baidu.tieba.e.a.a() && this.S == 0) {
            showToast(com.baidu.tieba.x.baobao_over_limit);
        } else {
            String charSequence = this.s.getText().toString();
            com.baidu.tbadk.pluginArch.c a = com.baidu.tbadk.pluginArch.d.a().a("baobao");
            if (a != null && (baobaoSdkDelegate = (BaobaoSdkDelegate) a.a(BaobaoSdkDelegate.class)) != null) {
                baobaoSdkDelegate.startMatchImage(this, charSequence, 12013);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.coreExtra.data.d dVar) {
        if (((ImageSpan[]) this.i.getText().getSpans(0, this.i.getText().length(), ImageSpan.class)).length >= 10) {
            if (this.z == null) {
                this.z = Toast.makeText(this, com.baidu.tieba.x.too_many_face, 0);
            }
            this.z.show();
            return;
        }
        String a = dVar.a();
        EmotionGroupType b = dVar.b();
        if (a != null) {
            com.baidu.adp.lib.resourceLoader.d.a().a(a, 20, new av(this, new SpannableStringBuilder(a), this.i.getSelectionStart(), b), 0, 0, getUniqueId(), null, a, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        Bitmap h = aVar.h();
        com.baidu.tieba.view.v vVar = new com.baidu.tieba.view.v(h);
        vVar.setBounds(0, 0, h.getWidth() + 1, h.getHeight());
        vVar.setGravity(3);
        spannableStringBuilder.setSpan(new ImageSpan(vVar, 0), 0, spannableStringBuilder.length(), 33);
        this.i.getText().insert(i, spannableStringBuilder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l() {
        this.i.onKeyDown(67, this.n);
    }

    private void a(Boolean bool) {
        String str = null;
        if (this.a != null) {
            str = this.a.getForumName();
        }
        if (com.baidu.tieba.e.b.a(str, bool)) {
            this.B.a(true);
        } else {
            this.B.a(false);
        }
    }

    private void w() {
        d().onCreate(this);
    }

    private void x() {
        try {
            if (this.u != null && this.u.isShowing()) {
                com.baidu.adp.lib.e.e.b(this.u, this);
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
                this.A = intent.getStringExtra("disable_audio_message");
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        String str = null;
        if (this.a.getType() == 0) {
            String trim = this.f.getText().toString().trim();
            if (this.N != null && this.N.getPrefixs().size() > 0) {
                if (this.R == this.N.getPrefixs().size() - 1) {
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
        String trim2 = this.i.getText().toString().trim();
        if (this.C.x()) {
            str = TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK;
        } else if (!TextUtils.isEmpty(trim2)) {
            str = TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK;
        } else if (this.C.z()) {
            str = TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK;
        } else if (this.C.y()) {
            str = TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK;
        }
        if (str == null || str.length() <= 0) {
            this.r.setEnabled(false);
        } else {
            this.r.setEnabled(true);
        }
    }

    private void a(Bundle bundle) {
        this.G = new com.baidu.tieba.model.ar();
        this.G.a(this.X);
        this.t = new aw(this);
        this.a = new WriteData();
        if (bundle != null) {
            this.a.setType(bundle.getInt("type", 0));
            this.a.setForumId(bundle.getString(com.baidu.tbadk.core.frameworkData.a.FORUM_ID));
            this.a.setForumName(bundle.getString(com.baidu.tbadk.core.frameworkData.a.FORUM_NAME));
            this.a.setThreadId(bundle.getString(com.baidu.tbadk.core.frameworkData.a.THREAD_ID));
            this.a.setFloor(bundle.getString("floor_id"));
            this.a.setFloorNum(bundle.getInt("floor_num", 0));
            this.b = bundle.getBoolean("feed_back", false);
            this.w = bundle.getBoolean("reply_sub_pb", false);
            this.x = bundle.getString("sub_user_name");
            this.D = (WriteImagesInfo) bundle.getSerializable("write_images");
            this.E = (WriteImagesInfo) bundle.getSerializable("baobao_images");
            this.F = bundle.getString("photo_name");
            this.I = (AdditionData) bundle.getSerializable("addition_data");
            this.a.setIsAddition(this.I != null);
            this.N = (PostPrefixData) bundle.getSerializable("prefix_data");
            this.S = bundle.getInt("mem_type", 0);
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
            this.w = intent.getBooleanExtra("reply_sub_pb", false);
            this.x = intent.getStringExtra("sub_user_name");
            this.I = (AdditionData) intent.getSerializableExtra("addition_data");
            this.a.setIsAddition(this.I != null);
            this.N = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.S = intent.getIntExtra("mem_type", 0);
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
        this.E.setMaxImagesAllowed(1);
        this.D.setMaxImagesAllowed(10);
        this.a.setWriteImagesInfo(this.D);
        this.a.setBaobaoImagesInfo(this.E);
        if (this.a.getType() == 0) {
            if (this.a.getLiveCardData() == null) {
                com.baidu.tieba.util.m.b(this.a.getForumId(), this);
            } else {
                com.baidu.tieba.util.m.a(this.a.getLiveCardData().getGroupId(), this);
            }
        } else if (this.a.getType() == 1) {
            com.baidu.tieba.util.m.a(this.a.getThreadId(), this);
        }
        if (this.N != null && this.N.getPrefixs().size() > 0) {
            this.N.getPrefixs().add(getString(com.baidu.tieba.x.write_no_prefix));
        }
        this.m = TbadkApplication.m252getInst().getDefaultBubble();
        if (this.a != null && this.a.getForumName() != null && com.baidu.tieba.ai.c().P() != null && this.a.getForumName().equals(com.baidu.tieba.ai.c().P())) {
            this.c = true;
        }
    }

    @Override // com.baidu.tieba.util.n
    public void a(WriteData writeData) {
        if (writeData != null && this.a != null) {
            this.a.setHaveDraft(true);
            if (com.baidu.adp.lib.util.i.c(this.f.getText().toString()) || ((this.b || this.c) && !com.baidu.adp.lib.util.i.c(writeData.getTitle()))) {
                this.a.setTitle(writeData.getTitle());
                this.f.setText(this.a.getTitle());
                this.f.setSelection(this.a.getTitle().length());
            }
            if (writeData.getLiveCardData() != null) {
                Date date = new Date(writeData.getLiveCardData().getStartTime() * 1000);
                Date date2 = new Date();
                date.setYear(date2.getYear());
                date.setMonth(date2.getMonth());
                date.setDate(date2.getDate());
                this.a.getLiveCardData().setStartTime(date.getTime() / 1000);
                this.U.setText(com.baidu.tbadk.core.util.ba.b(this.a.getLiveCardData().getStartTime() * 1000));
            }
            if ((com.baidu.adp.lib.util.i.c(this.i.getText().toString()) || this.b || this.c) && !com.baidu.adp.lib.util.i.c(writeData.getContent())) {
                this.a.setContent(writeData.getContent());
                SpannableString a = TbFaceManager.a().a(this, this.a.getContent(), new ax(this));
                this.i.setText(a);
                this.i.setSelection(a.length());
            }
            if (writeData.getWriteImagesInfo() != null && this.D.size() == 0) {
                this.D = writeData.getWriteImagesInfo();
                this.a.setWriteImagesInfo(this.D);
                this.C.a(this.D, true);
                B();
            }
            if (TbadkApplication.m252getInst().isBaobaoShouldOpen()) {
                if (writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                    this.E.copyFrom(writeData.getBaobaoImagesInfo());
                    this.a.setIsBaobao(writeData.getIsBaobao());
                    this.a.setBaobaoContent(writeData.getBaobaoContent());
                    this.a.setBaobaoImagesInfo(this.E);
                }
                if (this.a.getIsBaobao()) {
                    this.C.setBaobaoUris(this.E);
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
        bundle.putBoolean("reply_sub_pb", this.w);
        if (this.b) {
            bundle.putBoolean("feed_back", true);
        }
        bundle.putSerializable("write_images", this.D);
        bundle.putSerializable("baobao_images", this.E);
        bundle.putString("photo_name", this.F);
        bundle.putSerializable("addition_data", this.I);
        bundle.putSerializable("prefix_data", this.N);
        bundle.putInt("mem_type", this.S);
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
        String editable = this.i.getEditableText().toString();
        if (editable != null) {
            this.i.setText(TbFaceManager.a().a(this, editable));
            this.i.setSelection(this.i.getText().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m() {
        a();
        if (this.a.getLiveCardData() != null) {
            if (!this.a.getLiveCardData().isModifyTime()) {
                this.a.getLiveCardData().setStartTime(new Date().getTime() / 1000);
                this.U.setText(com.baidu.tbadk.core.util.ba.b(this.a.getLiveCardData().getStartTime() * 1000));
            }
            long time = new Date().getTime() / TbConfig.USE_TIME_INTERVAL;
            Date date = new Date(this.a.getLiveCardData().getStartTime() * 1000);
            Date date2 = new Date();
            date.setYear(date2.getYear());
            date.setMonth(date2.getMonth());
            date.setDate(date2.getDate());
            this.a.getLiveCardData().setStartTime(date.getTime() / 1000);
            if (time > this.a.getLiveCardData().getStartTime() / 60) {
                showToast(com.baidu.tieba.x.live_start_time_error);
                return;
            }
        }
        if (this.N != null && this.N.getPrefixs().size() > 0 && this.R != this.N.getPrefixs().size() - 1) {
            this.a.setTitle(String.valueOf(this.O.getText().toString()) + this.f.getText().toString());
        } else {
            this.a.setTitle(this.f.getText().toString());
        }
        this.a.setContent(this.i.getText().toString());
        if (this.b || this.c) {
            this.a.setTitle(getResources().getString(com.baidu.tieba.x.android_feedback) + this.a.getTitle());
            StringBuilder sb = new StringBuilder();
            sb.append(getResources().getString(com.baidu.tieba.x.tieba_client));
            sb.append(TbConfig.getVersion());
            sb.append(", ");
            sb.append(Build.VERSION.RELEASE);
            sb.append(", ");
            sb.append(Build.MODEL);
            sb.append(", ");
            UtilHelper.NetworkStateInfo netStatusInfo = UtilHelper.getNetStatusInfo(this);
            if (netStatusInfo == UtilHelper.NetworkStateInfo.WIFI) {
                sb.append(NetworkChangeReceiver.WIFI_STRING);
            } else if (netStatusInfo == UtilHelper.NetworkStateInfo.ThreeG) {
                sb.append("3G");
            } else if (netStatusInfo == UtilHelper.NetworkStateInfo.TwoG) {
                sb.append("2G");
            } else {
                sb.append("UNKNOWN");
            }
            sb.append(":");
            sb.append(this.a.getContent());
            this.a.setContent(sb.toString());
        }
        this.a.setWriteImagesInfo(this.D);
        this.a.setBaobaoImagesInfo(this.E);
        this.G.a(this.D.size() > 0);
        this.G.a(this.a);
        VoiceData.VoiceModel audioData = this.C.getAudioData();
        this.C.C();
        this.a.setVcode(null);
        if (audioData != null) {
            if (audioData.getId() != null) {
                this.G.a().setVoice(audioData.getId());
                this.G.a().setVoiceDuringTime(audioData.duration);
            } else {
                this.G.a().setVoice(null);
                this.G.a().setVoiceDuringTime(-1);
            }
        } else {
            this.G.a().setVoice(null);
            this.G.a().setVoiceDuringTime(-1);
        }
        if (!this.G.c()) {
            showToast(com.baidu.tieba.x.write_img_limit);
        } else if (this.G.b()) {
            showLoadingDialog(getString(com.baidu.tieba.x.sending), this.t);
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
                            this.i.getText().insert(this.i.getSelectionStart(), sb.toString());
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
                this.C.setVisibility(0);
            } else if (i == 12001) {
                b(intent);
                int size2 = this.D.size() - 1;
                if (size2 > -1 && this.D != null && this.D.getChosedFiles() != null && (size = this.D.getChosedFiles().size()) >= 1 && size2 >= 0 && size2 < size) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ch(this, 12012, this.D, size2)));
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
                    if (!this.C.x()) {
                        this.B.j();
                        i();
                    }
                    if (intent != null && intent.hasExtra("last_album_id")) {
                        this.D.setLastAlbumId(intent.getStringExtra("last_album_id"));
                        return;
                    }
                    return;
                case 12009:
                    cc.a(this);
                    return;
                case 12010:
                    this.F = String.valueOf(System.currentTimeMillis());
                    com.baidu.tbadk.core.util.ax.a(this, this.F);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.d, this.f);
        HidenSoftKeyPad(this.d, this.i);
        super.onPause();
        d().onPause(this);
    }

    private void a(Intent intent) {
        a(intent, true);
    }

    private void b(Intent intent) {
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.F;
        if (!TextUtils.isEmpty(str)) {
            try {
                int b = com.baidu.tbadk.core.util.d.b(str);
                if (b != 0) {
                    Bitmap a = com.baidu.tbadk.core.util.d.a(str, com.baidu.adp.lib.util.j.a(this, com.baidu.adp.lib.util.j.b(this)), com.baidu.adp.lib.util.j.a(this, com.baidu.adp.lib.util.j.c(this)));
                    Bitmap e = com.baidu.tbadk.core.util.d.e(a, b);
                    if (a != e) {
                        a.recycle();
                    }
                    com.baidu.tbadk.core.util.s.a(TbConfig.LOCAL_CAMERA_DIR, this.F, e, 100);
                    e.recycle();
                }
            } catch (Exception e2) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.D.addChooseFile(imageFileInfo);
            this.D.updateQuality();
            this.C.a(this.D, true);
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
                this.D.parseJson(stringExtra);
                this.D.updateQuality();
                if (this.D.getChosedFiles() != null) {
                    this.C.a(this.D, z);
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
            this.E.clear();
            this.E.addChooseFile(imageFileInfo);
            this.a.setIsBaobao(true);
            this.a.setBaobaoContent(stringExtra2);
            this.C.setBaobaoUris(this.E);
            C();
        }
    }

    private void A() {
        new ay(this).execute(new Void[0]);
    }

    private void B() {
        LinkedList<ImageFileInfo> chosedFiles = this.D.getChosedFiles();
        if (chosedFiles != null && chosedFiles.size() > 0) {
            this.B.h();
            this.B.a(new StringBuilder(String.valueOf(chosedFiles.size())).toString());
            this.C.u();
            return;
        }
        this.B.n();
        this.B.j();
        i();
    }

    private void C() {
        LinkedList<ImageFileInfo> chosedFiles = this.E.getChosedFiles();
        if (chosedFiles != null && chosedFiles.size() > 0) {
            this.B.l();
            this.B.b(TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
            this.C.w();
            this.a.setIsBaobao(true);
            return;
        }
        this.B.s();
        this.a.setIsBaobao(false);
        this.B.k();
        i();
    }

    @Override // com.baidu.tbadk.core.voice.aa
    public synchronized VoiceManager d() {
        if (this.H == null) {
            this.H = VoiceManager.instance();
        }
        return this.H;
    }

    @Override // com.baidu.tbadk.core.voice.aa
    public com.baidu.tbadk.core.voice.y a(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void D() {
        this.H = d();
        this.H.stopPlay();
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

    @Override // com.baidu.tieba.write.ca
    public void c(int i) {
        this.R = i;
        this.P.b(i);
        this.O.setText(this.N.getPrefixs().get(i));
        z();
        com.baidu.adp.lib.e.e.a(this.P, this);
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.O.setSelected(false);
    }
}
