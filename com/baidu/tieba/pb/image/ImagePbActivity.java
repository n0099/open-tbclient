package com.baidu.tieba.pb.image;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.text.style.ImageSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.b.av;
import com.baidu.tbadk.core.b.aw;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortool.EmotionTabHost;
import com.baidu.tieba.editortool.PbEditor;
import com.baidu.tieba.view.KeyboardLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class ImagePbActivity extends com.baidu.tbadk.a implements com.baidu.tbadk.core.view.a, com.baidu.tbadk.editortool.x {
    private NoNetworkView Q;
    private NavigationBar g;
    private EditText l;
    private Button m;
    private Button n;
    private EmotionTabHost o;
    private static final Pattern a = Pattern.compile("#\\([^#\\)\\(]+\\)$");
    private static boolean P = true;
    private s b = null;
    private final ImageView c = null;
    private ImageView d = null;
    private Button e = null;
    private Button f = null;
    private TextView h = null;
    private TextView i = null;
    private AlertDialog j = null;
    private View k = null;
    private ProgressBar p = null;
    private LinearLayout q = null;
    private LinearLayout r = null;
    private KeyboardLayout s = null;
    private DialogInterface.OnCancelListener t = null;
    private w u = null;
    private final AntiData v = null;
    private final int w = 0;
    private x x = null;
    private BaseViewPager y = null;
    private ad z = null;
    private v A = null;
    private boolean B = false;
    private String C = null;
    private String D = null;
    private String E = null;
    private int F = 0;
    private com.baidu.tieba.data.u G = null;
    private com.baidu.tieba.data.u H = null;
    private AlertDialog I = null;
    private int J = 0;
    private t K = null;
    private String L = null;
    private long M = 0;
    private HashMap<String, Boolean> N = null;
    private boolean O = false;
    private Handler R = null;
    private final Runnable S = new a(this);
    private final u T = new k(this);
    private final com.baidu.tieba.view.u U = new l(this);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2004002, new m());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        com.baidu.adp.framework.c.a().a(customMessageTask);
    }

    @Override // com.baidu.tbadk.a
    public boolean getGpuSwitch() {
        return TbadkApplication.j().ax();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.a.i.image_pb_activity);
        this.R = new Handler();
        this.G = new com.baidu.tieba.data.u(this);
        this.g = (NavigationBar) findViewById(com.baidu.tieba.a.h.view_navigation_bar);
        this.g.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new n(this));
        View a2 = this.g.a(com.baidu.tieba.a.i.nb_item_pb_image_titleview, (View.OnClickListener) null);
        this.h = (TextView) a2.findViewById(com.baidu.tieba.a.h.title_text);
        this.i = (TextView) a2.findViewById(com.baidu.tieba.a.h.title_page);
        this.d = (ImageView) this.g.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.a.i.widget_nb_item_pb_camera, new o(this));
        this.d.setVisibility(8);
        this.e = (Button) findViewById(com.baidu.tieba.a.h.reply);
        this.e.setOnClickListener(new p(this));
        this.f = (Button) findViewById(com.baidu.tieba.a.h.save);
        this.f.setOnClickListener(new q(this));
        this.h.setOnClickListener(new r(this));
        this.y = (BaseViewPager) findViewById(com.baidu.tieba.a.h.content_view);
        this.y.setOnFlipOutListener(this);
        String[] strArr = {getString(com.baidu.tieba.a.k.take_photo), getString(com.baidu.tieba.a.k.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(com.baidu.tieba.a.k.operation));
        builder.setItems(strArr, new c(this));
        this.q = (LinearLayout) findViewById(com.baidu.tieba.a.h.layout_reply);
        this.l = (EditText) findViewById(com.baidu.tieba.a.h.reply_content);
        this.n = (Button) findViewById(com.baidu.tieba.a.h.button_face);
        this.m = (Button) findViewById(com.baidu.tieba.a.h.reply_button);
        this.m.setEnabled(false);
        this.l.addTextChangedListener(new i(this));
        this.l.setFilters(new InputFilter[]{new j(this)});
        this.o = (EmotionTabHost) findViewById(com.baidu.tieba.a.h.face_view);
        this.o.setOnDataSelected(this);
        this.o.setShowBigEmotion(false);
        this.s = (KeyboardLayout) findViewById(com.baidu.tieba.a.h.image_pb_layout);
        this.s.setOnkbdStateListener(this.U);
        this.m.setOnClickListener(new d(this));
        this.n.setOnClickListener(new f(this, new Handler(), new e(this)));
        this.r = (LinearLayout) findViewById(com.baidu.tieba.a.h.image_pb_bottom);
        this.l.setOnTouchListener(new g(this));
        this.p = (ProgressBar) findViewById(com.baidu.tieba.a.h.image_pb_progress);
        this.t = new h(this);
        if (this.I == null) {
            this.I = builder.create();
            this.I.setCanceledOnTouchOutside(true);
        }
        this.Q = (NoNetworkView) findViewById(com.baidu.tieba.a.h.view_no_network);
        b(false);
        this.F = 0;
        if (bundle != null) {
            this.D = bundle.getString("thread_id");
            this.C = bundle.getString("forum");
            this.E = bundle.getString("title");
            this.F = bundle.getInt("current_page");
        } else {
            this.D = getIntent().getStringExtra("thread_id");
            this.C = getIntent().getStringExtra("forum");
            this.E = getIntent().getStringExtra("title");
        }
        this.G.a(this.D);
        this.G.b(this.E);
        this.h.setText(this.E);
        this.z = new ad(this);
        this.z.a(this.T);
        this.z.a(this.D);
        this.y.setAdapter(this.z);
        this.K = new t(this);
        this.y.setOnPageChangeListener(this.K);
        this.y.setCurrentItem(this.F);
        if (this.C != null && this.C.length() > 0 && this.D != null && this.D.length() > 0) {
            a(null, 0, 9, true);
        }
        this.N = new HashMap<>();
        a(this.J, this.J);
        this.A = new v(this, (byte) 0);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(com.baidu.tbadk.core.data.n.s());
        registerReceiver(this.A, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onPause() {
        super.onPause();
        this.R.removeCallbacks(this.S);
        com.baidu.tbadk.editortool.aa d = this.z.d();
        if (d != null) {
            d.c();
        }
        this.B = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onResume() {
        super.onResume();
        this.R.removeCallbacks(this.S);
        this.R.post(this.S);
        this.B = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        a(this.J, this.J);
        d();
        if (this.x != null) {
            this.x.cancel();
        }
        if (this.p != null) {
            this.p.setVisibility(8);
        }
        if (this.u != null) {
            this.u.cancel();
        }
        if (this.b != null) {
            this.b.cancel();
        }
        if (this.j != null && this.j.isShowing()) {
            this.j.dismiss();
        }
        this.z.c();
        unregisterReceiver(this.A);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void w(ImagePbActivity imagePbActivity) {
        if (imagePbActivity.j == null) {
            imagePbActivity.j = new AlertDialog.Builder(imagePbActivity).create();
            imagePbActivity.j.setCanceledOnTouchOutside(true);
            imagePbActivity.k = imagePbActivity.getLayoutInflater().inflate(com.baidu.tieba.a.i.pb_title_dialog, (ViewGroup) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.Q != null) {
            this.Q.a(i);
        }
        this.g.b(i);
        ba.d(this.h, i);
        ba.d(this.i, i);
        ba.a(this.c, i);
        ba.a(this.y, i);
        int childCount = this.y.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.y.getChildAt(i2);
            if (childAt.getId() == com.baidu.tieba.a.h.image_next) {
                TextView textView = (TextView) childAt.findViewById(com.baidu.tieba.a.h.next);
                TextView textView2 = (TextView) childAt.findViewById(com.baidu.tieba.a.h.thread_name);
                ImageView imageView = (ImageView) childAt.findViewById(com.baidu.tieba.a.h.image);
                if (textView != null && textView2 != null && imageView != null) {
                    if (i == 1) {
                        textView.setTextColor(ba.c(1));
                        textView2.setTextColor(ba.a(1));
                        imageView.setBackgroundResource(com.baidu.tieba.a.g.image_pb_next_default_1);
                    } else {
                        textView.setTextColor(-9539986);
                        textView2.setTextColor(-6250336);
                        imageView.setBackgroundResource(com.baidu.tieba.a.g.image_pb_next_default);
                    }
                }
            } else {
                View findViewById = childAt.findViewById(com.baidu.tieba.a.h.image_pb_listview);
                if (findViewById != null && (findViewById instanceof ListView)) {
                    ListView listView = (ListView) findViewById;
                    ba.a(listView, i);
                    if (childAt.getTag() != null && (childAt.getTag() instanceof y)) {
                        ba.a(listView, i);
                        ((y) childAt.getTag()).notifyDataSetChanged();
                    }
                }
            }
        }
        if (i == 1) {
            a(this.e, com.baidu.tieba.a.g.pb_bottom_btn_reply_1);
            a(this.f, com.baidu.tieba.a.g.image_pb_bottom_save_1);
            this.e.setTextColor(getResources().getColorStateList(com.baidu.tieba.a.e.text_blue_selector_color_1));
            this.f.setTextColor(getResources().getColorStateList(com.baidu.tieba.a.e.text_blue_selector_color_1));
            ba.e(this.q, com.baidu.tieba.a.g.sub_pb_reply_bg_1);
        } else {
            a(this.e, com.baidu.tieba.a.g.pb_bottom_btn_reply);
            a(this.f, com.baidu.tieba.a.g.image_pb_bottom_save);
            this.e.setTextColor(getResources().getColorStateList(com.baidu.tieba.a.e.text_blue_selector_color));
            this.f.setTextColor(getResources().getColorStateList(com.baidu.tieba.a.e.text_blue_selector_color));
            ba.e(this.q, com.baidu.tieba.a.g.sub_pb_reply_bg);
        }
        this.o.b(i);
    }

    private void a(Button button, int i) {
        button.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(i), (Drawable) null, (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (this.p != null) {
            if (z) {
                this.p.setVisibility(0);
            } else {
                this.p.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (z) {
            this.l.requestFocus();
            this.q.setVisibility(0);
            this.o.setVisibility(8);
            com.baidu.adp.lib.util.i.b(this, this.l);
            this.n.setBackgroundResource(com.baidu.tieba.a.g.sub_pb_face);
            this.r.setVisibility(8);
            return;
        }
        this.q.setVisibility(8);
        this.o.setVisibility(8);
        com.baidu.adp.lib.util.i.a(this, this.l);
        this.r.setVisibility(0);
    }

    private void c(boolean z) {
        this.R.removeCallbacks(this.S);
        com.baidu.tbadk.editortool.aa d = this.z.d();
        if (d != null) {
            d.c();
        }
        if (!z) {
            String str = this.E;
            if (this.E != null) {
                if (this.E.length() > 6) {
                    str = String.valueOf(this.E.substring(0, 6)) + getString(com.baidu.tieba.a.k.three_point);
                }
                showToast(getString(com.baidu.tieba.a.k.image_pb_imagethread).replace("?", str));
            }
        }
        this.G.a(this.D);
        this.G.b(this.E);
        this.h.setText(this.E);
        this.z.b();
        this.z.a(this.D);
        this.z.a(this.G);
        this.z.notifyDataSetChanged();
        this.z.a();
        if (z && this.C != null && this.C.length() > 0 && this.D != null && this.D.length() > 0) {
            a(null, 0, 9, true);
        } else {
            b(0);
        }
        if (this.j != null && this.j.isShowing()) {
            this.j.dismiss();
        }
        a(this.J, this.J);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void n(ImagePbActivity imagePbActivity) {
        ArrayList<BasicNameValuePair> arrayList = new ArrayList<>(0);
        arrayList.add(new BasicNameValuePair("fname", imagePbActivity.C));
        arrayList.add(new BasicNameValuePair("tid", imagePbActivity.D));
        if (imagePbActivity.G != null) {
            arrayList.add(new BasicNameValuePair("fid", imagePbActivity.G.j()));
        }
        if (imagePbActivity.z.d() != null) {
            imagePbActivity.z.d().h = arrayList;
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("thread_id", this.D);
        bundle.putString("forum", this.C);
        bundle.putInt("current_page", this.F);
        bundle.putString("title", this.E);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x003b: INVOKE  (r4v9 int A[REMOVE]) = (r22v0 android.content.Intent), ("index"), (0 int) type: VIRTUAL call: android.content.Intent.getIntExtra(java.lang.String, int):int)] */
    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11005:
                    b();
                    return;
                case 11016:
                    this.I.show();
                    return;
                case 12001:
                    if (this.G != null && this.G.i() != null && this.C != null) {
                        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new aw(this, 12001, 12010, null, this.G.j(), this.C, null)));
                        return;
                    }
                    return;
                case 12002:
                    if (this.G != null && this.G.i() != null && this.C != null) {
                        if (intent != null && intent.getData() != null) {
                            com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new aw(this, 12002, 12009, intent.getData(), String.valueOf(this.G.j()), this.C, null)));
                            return;
                        }
                        return;
                    }
                    az.b(this);
                    return;
                case 12006:
                    if (intent.getSerializableExtra("model") != null) {
                        c();
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    if (this.G != null) {
                        if (intent == null || intent.getStringExtra("filename") == null) {
                            com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new av(this, 1, this.G.j(), this.C, this.D, null, 0, null, 13002, false, false, null, false, true, null, null, null)));
                            return;
                        }
                        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new av(this, 1, this.G.j(), this.C, this.D, null, 0, null, 13002, false, false, null, false, true, intent.getStringExtra("filename"), null, null)));
                        return;
                    }
                    return;
                case 14001:
                    if (intent != null && intent.getIntExtra("index", -1) >= 0) {
                        com.baidu.adp.lib.util.f.a(getClass().getName(), "onActivityResult", new StringBuilder().append(intent.getIntExtra("index", 0)).toString());
                        this.y.setCurrentItem(intent.getIntExtra("index", 0), false);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void v(ImagePbActivity imagePbActivity) {
        if (imagePbActivity.x != null) {
            imagePbActivity.x.cancel();
        }
        imagePbActivity.x = new x(imagePbActivity, (byte) 0);
        imagePbActivity.x.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void u(ImagePbActivity imagePbActivity) {
        String E = TbadkApplication.E();
        if (E != null && E.length() > 0) {
            if (imagePbActivity.G != null) {
                imagePbActivity.I.show();
                return;
            }
            return;
        }
        if (imagePbActivity.G != null && imagePbActivity.G.e() != null) {
            imagePbActivity.G.e().setIfpost(1);
        }
        LoginActivity.a((Activity) imagePbActivity, imagePbActivity.getString(com.baidu.tieba.a.k.login_to_use), true, 11016);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r13v0 int)] */
    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, int i2, boolean z) {
        com.baidu.adp.lib.util.f.a(getClass().getName(), str, new StringBuilder().append(i2).toString());
        if (!this.G.a() && this.b == null) {
            String str2 = String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/f/pb/picpage";
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("kw", this.C));
            arrayList.add(new BasicNameValuePair("tid", this.D));
            if (str != null) {
                arrayList.add(new BasicNameValuePair("pic_id", str));
            }
            arrayList.add(new BasicNameValuePair("prev", String.valueOf(i)));
            arrayList.add(new BasicNameValuePair("next", String.valueOf(i2)));
            if (this.O) {
                this.O = false;
                arrayList.add(new BasicNameValuePair("st_type", "commend_pic_page"));
            }
            int b = com.baidu.adp.lib.util.i.b(this);
            int c = com.baidu.adp.lib.util.i.c(this);
            float f = getResources().getDisplayMetrics().density;
            int i3 = bd.a().d().equals("80") ? 2 : 1;
            arrayList.add(new BasicNameValuePair("scr_w", String.valueOf(b)));
            arrayList.add(new BasicNameValuePair("scr_h", String.valueOf(c)));
            arrayList.add(new BasicNameValuePair("scr_dip", String.valueOf(f)));
            arrayList.add(new BasicNameValuePair("q_type", String.valueOf(i3)));
            a(true);
            com.baidu.adp.lib.util.f.a(getClass().getName(), "startImagePbAsyncTask", str);
            this.b = new s(this, str2.toString(), arrayList, z);
            this.b.setPriority(3);
            this.b.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        Intent intent = new Intent(com.baidu.tieba.data.d.a());
        LinkedList<com.baidu.tieba.data.t> h = this.G.h();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < h.size(); i2++) {
            com.baidu.tieba.data.t tVar = h.get(i2);
            if (!P || tVar.j() == null) {
                StringBuilder sb = new StringBuilder(100);
                if (tVar.g() * tVar.f() > com.baidu.tbadk.core.data.n.u() * com.baidu.tbadk.core.data.n.u()) {
                    double sqrt = Math.sqrt((com.baidu.tbadk.core.data.n.u() * com.baidu.tbadk.core.data.n.u()) / (tVar.g() * tVar.f()));
                    sb.append("width=");
                    sb.append(String.valueOf((int) (tVar.f() * sqrt)));
                    sb.append("&height=");
                    sb.append(String.valueOf((int) (sqrt * tVar.g())));
                } else {
                    sb.append("width=");
                    sb.append(String.valueOf(tVar.f()));
                    sb.append("&height=");
                    sb.append(String.valueOf(tVar.g()));
                }
                sb.append("&src=");
                sb.append(bc.d(tVar.b()));
                arrayList.add(sb.toString());
            } else {
                arrayList.add(tVar.j());
            }
        }
        if (arrayList.size() > 0) {
            intent.putStringArrayListExtra("url", arrayList);
            intent.putExtra("count", this.G.k());
            if (this.G.b() && arrayList.size() == this.G.k()) {
                intent.putExtra("hasnext", true);
                intent.putExtra("nexttitle", this.G.g());
            }
            if (i == 0) {
                intent.putExtra("index", this.G.k() - 1);
            } else if (i == 1) {
                intent.putExtra("index", 0);
            } else {
                intent.putExtra("index", -1);
            }
            sendBroadcast(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a() {
        ImageSpan[] imageSpanArr = (ImageSpan[]) this.l.getText().getSpans(0, this.l.getText().length(), ImageSpan.class);
        int length = imageSpanArr.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (imageSpanArr[i2] != null && imageSpanArr[i2].getSource() != null) {
                i += imageSpanArr[i2].getSource().length();
            }
        }
        return (this.l.getText().toString().length() - i) + length > 140;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        String E = TbadkApplication.E();
        if (E == null || E.length() <= 0) {
            if (this.v != null) {
                this.v.setIfpost(1);
            }
            LoginActivity.a((Activity) this, getString(com.baidu.tieba.a.k.login_to_post), true, 11005);
        } else if (this.v != null && this.v.getIfpost() == 0) {
            com.baidu.adp.lib.util.i.a((Context) this, this.v.getForbid_info());
        } else {
            String editable = this.l.getText().toString();
            if (editable != null && editable.length() > 0 && this.G != null) {
                if (a()) {
                    editable = editable.substring(0, 140);
                }
                showLoadingDialog(getString(com.baidu.tieba.a.k.sending), this.t);
                WriteData writeData = new WriteData();
                writeData.setForumId(this.G.j());
                writeData.setForumName(this.G.i());
                writeData.setContent(editable);
                writeData.setVcode(null);
                writeData.setFloor(this.L);
                writeData.setThreadId(this.D);
                writeData.setFloorNum(0);
                writeData.setType(2);
                this.u = new w(this, writeData);
                this.u.setPriority(3);
                this.u.execute(new Integer[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        com.baidu.tieba.r.c();
        showToast(com.baidu.tieba.r.d().getString(com.baidu.tieba.a.k.send_success));
        this.l.setText((CharSequence) null);
        if (this.o.getVisibility() == 0) {
            this.o.setVisibility(8);
        }
        com.baidu.adp.lib.util.i.a(this, this.l);
        this.q.setVisibility(8);
        this.r.setVisibility(0);
        this.n.setBackgroundResource(com.baidu.tieba.a.g.sub_pb_face);
        this.z.e();
    }

    @Override // com.baidu.tbadk.a
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        if (str != null) {
            this.mWaitingDialog = ProgressDialog.show(this, "", str, true, true, onCancelListener);
        } else {
            this.mWaitingDialog = ProgressDialog.show(this, "", getResources().getString(com.baidu.tieba.a.k.Waiting), true, true, onCancelListener);
        }
    }

    @Override // com.baidu.tbadk.a
    public void closeLoadingDialog() {
        if (this.mWaitingDialog != null) {
            try {
                if (this.mWaitingDialog.isShowing()) {
                    this.mWaitingDialog.dismiss();
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "closeLoadingDialog", e.getMessage());
            }
            this.mWaitingDialog = null;
        }
    }

    @Override // com.baidu.tbadk.core.view.a
    public final void a(int i) {
        switch (i) {
            case 0:
                if (this.G.f() != null && this.G.g() != null) {
                    if (this.b != null) {
                        this.b.cancel();
                    }
                    this.D = this.G.f();
                    this.C = this.G.i();
                    this.E = this.G.g();
                    this.J = 0;
                    this.y.setCurrentItem(0, false);
                    this.i.setText((CharSequence) null);
                    this.H = this.G;
                    this.G = new com.baidu.tieba.data.u();
                    this.O = true;
                    c(true);
                    return;
                }
                return;
            case 1:
                if (this.H != null) {
                    if (this.b != null) {
                        this.b.cancel();
                    }
                    this.G = this.H;
                    this.H = null;
                    this.D = this.G.c();
                    this.C = this.G.i();
                    this.E = this.G.d();
                    this.J = this.G.k() - 1;
                    this.O = false;
                    c(false);
                    this.y.setCurrentItem(this.J, false);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        synchronized (this.N) {
            if (System.nanoTime() - this.M > 300000000 && this.G != null && this.G.h() != null && this.J < this.G.h().size()) {
                try {
                    this.N.put(this.G.h().get(i).b(), true);
                } catch (IndexOutOfBoundsException e) {
                    com.baidu.adp.lib.util.f.e("ImagePbActivity", "imageChange", e.getMessage());
                }
            }
            this.M = System.nanoTime();
            if (this.G.h() != null && i2 < this.G.h().size()) {
                try {
                    if (this.N.get(this.G.h().get(i2).b()) == null) {
                        this.N.put(this.G.h().get(i2).b(), false);
                    }
                } catch (IndexOutOfBoundsException e2) {
                    com.baidu.adp.lib.util.f.e("ImagePbActivity", "imageChange", e2.getMessage());
                }
            }
        }
        if (this.N.size() >= 100) {
            d();
        }
    }

    private void d() {
        if (this.N == null) {
            return;
        }
        synchronized (this.N) {
            if (this.N.size() > 0) {
                int i = 0;
                for (Map.Entry<String, Boolean> entry : this.N.entrySet()) {
                    if (entry.getValue().booleanValue()) {
                        i++;
                    }
                }
                TbadkApplication.j().a(i, this.N.size(), "photo");
                this.N.clear();
            }
        }
    }

    @Override // com.baidu.tbadk.editortool.x
    public final void a(int i, Object obj) {
        if (i == 20) {
            if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.data.d)) {
                com.baidu.tbadk.coreExtra.data.d dVar = (com.baidu.tbadk.coreExtra.data.d) obj;
                if (dVar.a() != null) {
                    if (PbEditor.a(this.l.getText().toString()) >= 10) {
                        showToast(getResources().getString(com.baidu.tieba.a.k.too_many_face));
                        return;
                    }
                    this.l.getText().insert(this.l.getSelectionStart(), dVar.a());
                }
            }
        } else if (i == 21 && this.l.getSelectionStart() > 0) {
            String substring = this.l.getText().toString().substring(0, this.l.getSelectionStart());
            Matcher matcher = a.matcher(substring);
            if (matcher.find()) {
                this.l.getText().delete(this.l.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.l.getSelectionStart());
                return;
            }
            this.l.getText().delete(this.l.getSelectionStart() - 1, this.l.getSelectionStart());
        }
    }

    @Override // com.baidu.tbadk.a, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.o.getVisibility() == 0) {
                    b(false);
                    return true;
                }
                closeActivity();
                break;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
