package com.baidu.tieba.pb;

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
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.editortool.EmotionTabHost;
import com.baidu.tieba.view.BaseViewPager;
import com.baidu.tieba.view.ImagePbPagerAdapter;
import com.baidu.tieba.view.KeyboardLayout;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.write.WriteActivity;
import com.baidu.tieba.write.WriteImageActivity;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class ImagePbActivity extends com.baidu.tieba.j implements com.baidu.tieba.editortool.t, com.baidu.tieba.view.e {
    private NavigationBar g;
    private EditText l;
    private Button m;
    private Button n;
    private EmotionTabHost o;
    private static final Pattern a = Pattern.compile("#\\([^#\\)\\(]+\\)$");
    private static boolean P = true;
    private ab b = null;
    private ImageView c = null;
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
    private ae u = null;
    private AntiData v = null;
    private int w = 0;
    private af x = null;
    private BaseViewPager y = null;
    private ImagePbPagerAdapter z = null;
    private ad A = null;
    private boolean B = false;
    private String C = null;
    private String D = null;
    private String E = null;
    private int F = 0;
    private com.baidu.tieba.data.ac G = null;
    private com.baidu.tieba.data.ac H = null;
    private AlertDialog I = null;
    private int J = 0;
    private MyOnPageChangeListener K = null;
    private String L = null;
    private long M = 0;
    private HashMap<String, Boolean> N = null;
    private boolean O = false;
    private Handler Q = null;
    private Runnable R = new k(this);
    private ac S = new p(this);
    private com.baidu.tieba.view.aw T = new s(this);

    @Override // com.baidu.tieba.j
    public boolean getGpuSwitch() {
        return TiebaApplication.g().u();
    }

    public static void a(Context context, String str, String str2, String str3) {
        Intent intent = new Intent(context, ImagePbActivity.class);
        if (str != null && str.length() > 0) {
            intent.putExtra("id", str);
            intent.putExtra("forum", str2);
            intent.putExtra("title", str3);
        }
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.image_pb_activity);
        this.Q = new Handler();
        this.G = new com.baidu.tieba.data.ac(this);
        c();
        a(bundle);
        a();
    }

    private void a() {
        this.A = new ad(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.tieba.broadcast.imagepb.pagechanged");
        registerReceiver(this.A, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onPause() {
        super.onPause();
        this.Q.removeCallbacks(this.R);
        com.baidu.tieba.util.i d = this.z.d();
        if (d != null) {
            d.d();
        }
        this.B = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        this.Q.removeCallbacks(this.R);
        this.Q.post(this.R);
        this.B = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        a(this.J, this.J);
        j();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.j == null) {
            this.j = new AlertDialog.Builder(this).create();
            this.j.setCanceledOnTouchOutside(true);
            this.k = getLayoutInflater().inflate(R.layout.pb_title_dialog, (ViewGroup) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.g.c(i);
        com.baidu.tieba.util.bl.e(this.h, i);
        com.baidu.tieba.util.bl.e(this.i, i);
        com.baidu.tieba.util.bl.a(this.c, i);
        com.baidu.tieba.util.bl.a(this.y, i);
        int childCount = this.y.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.y.getChildAt(i2);
            if (childAt.getId() == R.id.image_next) {
                TextView textView = (TextView) childAt.findViewById(R.id.next);
                TextView textView2 = (TextView) childAt.findViewById(R.id.thread_name);
                ImageView imageView = (ImageView) childAt.findViewById(R.id.image);
                if (textView != null && textView2 != null && imageView != null) {
                    if (i == 1) {
                        textView.setTextColor(com.baidu.tieba.util.bl.c(1));
                        textView2.setTextColor(com.baidu.tieba.util.bl.a(1));
                        imageView.setBackgroundResource(R.drawable.image_pb_next_default_1);
                    } else {
                        textView.setTextColor(-9539986);
                        textView2.setTextColor(-6250336);
                        imageView.setBackgroundResource(R.drawable.image_pb_next_default);
                    }
                }
            } else {
                View findViewById = childAt.findViewById(R.id.image_pb_listview);
                if (findViewById != null && (findViewById instanceof ListView)) {
                    ListView listView = (ListView) findViewById;
                    com.baidu.tieba.util.bl.a(listView, i);
                    if (childAt.getTag() != null && (childAt.getTag() instanceof ag)) {
                        com.baidu.tieba.util.bl.a(listView, i);
                        ((ag) childAt.getTag()).notifyDataSetChanged();
                    }
                }
            }
        }
        if (i == 1) {
            a(this.e, R.drawable.pb_bottom_btn_reply_1);
            a(this.f, R.drawable.image_pb_bottom_save_1);
            this.e.setTextColor(getResources().getColorStateList(R.color.text_blue_selector_color_1));
            this.f.setTextColor(getResources().getColorStateList(R.color.text_blue_selector_color_1));
            com.baidu.tieba.util.bl.e(this.q, (int) R.drawable.sub_pb_reply_bg_1);
        } else {
            a(this.e, R.drawable.pb_bottom_btn_reply);
            a(this.f, R.drawable.image_pb_bottom_save);
            this.e.setTextColor(getResources().getColorStateList(R.color.text_blue_selector_color));
            this.f.setTextColor(getResources().getColorStateList(R.color.text_blue_selector_color));
            com.baidu.tieba.util.bl.e(this.q, (int) R.drawable.sub_pb_reply_bg);
        }
        this.o.b(i);
    }

    private void a(Button button, int i) {
        button.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(i), (Drawable) null, (Drawable) null);
    }

    private void c() {
        this.g = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.g.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new t(this));
        View a2 = this.g.a(R.layout.nb_item_pb_image_titleview, (View.OnClickListener) null);
        this.h = (TextView) a2.findViewById(R.id.title_text);
        this.i = (TextView) a2.findViewById(R.id.title_page);
        this.d = this.g.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, NavigationBar.ControlType.CAMERA_BUTTON, new u(this));
        this.d.setVisibility(8);
        this.e = (Button) findViewById(R.id.reply);
        this.e.setOnClickListener(new v(this));
        this.f = (Button) findViewById(R.id.save);
        this.f.setOnClickListener(new w(this));
        this.h.setOnClickListener(new x(this));
        this.y = (BaseViewPager) findViewById(R.id.content_view);
        this.y.setOnFlipOutListener(this);
        String[] strArr = {getString(R.string.take_photo), getString(R.string.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.operation));
        builder.setItems(strArr, new y(this));
        this.q = (LinearLayout) findViewById(R.id.layout_reply);
        this.l = (EditText) findViewById(R.id.reply_content);
        this.n = (Button) findViewById(R.id.button_face);
        this.m = (Button) findViewById(R.id.reply_button);
        this.m.setEnabled(false);
        i();
        this.o = (EmotionTabHost) findViewById(R.id.face_view);
        this.o.setOnDataSelected(this);
        this.o.setShowBigEmotion(false);
        this.s = (KeyboardLayout) findViewById(R.id.image_pb_layout);
        this.s.setOnkbdStateListener(this.T);
        this.m.setOnClickListener(new z(this));
        this.n.setOnClickListener(new m(this, new Handler(), new aa(this)));
        this.r = (LinearLayout) findViewById(R.id.image_pb_bottom);
        this.l.setOnTouchListener(new n(this));
        this.p = (ProgressBar) findViewById(R.id.image_pb_progress);
        this.t = new o(this);
        if (this.I == null) {
            this.I = builder.create();
            this.I.setCanceledOnTouchOutside(true);
        }
        b(false);
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
            com.baidu.adp.lib.h.g.b(this, this.l);
            this.n.setBackgroundResource(R.drawable.sub_pb_face);
            this.r.setVisibility(8);
            return;
        }
        this.q.setVisibility(8);
        this.o.setVisibility(8);
        com.baidu.adp.lib.h.g.a(this, this.l);
        this.r.setVisibility(0);
    }

    private void a(Bundle bundle) {
        this.F = 0;
        if (bundle != null) {
            this.D = bundle.getString("id");
            this.C = bundle.getString("forum");
            this.E = bundle.getString("title");
            this.F = bundle.getInt("current_page");
        } else {
            this.D = getIntent().getStringExtra("id");
            this.C = getIntent().getStringExtra("forum");
            this.E = getIntent().getStringExtra("title");
        }
        this.G.a(this.D);
        this.G.b(this.E);
        this.h.setText(this.E);
        this.z = new ImagePbPagerAdapter(this);
        this.z.a(this.S);
        this.z.a(this.D);
        this.y.setAdapter(this.z);
        this.K = new MyOnPageChangeListener();
        this.y.setOnPageChangeListener(this.K);
        this.y.setCurrentItem(this.F);
        if (this.C != null && this.C.length() > 0 && this.D != null && this.D.length() > 0) {
            a((String) null, 0, 9, true);
        }
        this.N = new HashMap<>();
        a(this.J, this.J);
    }

    private void c(boolean z) {
        this.Q.removeCallbacks(this.R);
        com.baidu.tieba.util.i d = this.z.d();
        if (d != null) {
            d.d();
        }
        if (!z) {
            String str = this.E;
            if (this.E != null) {
                if (this.E.length() > 6) {
                    str = this.E.substring(0, 6) + getString(R.string.three_point);
                }
                showToast(getString(R.string.image_pb_imagethread).replace("?", str));
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
            a((String) null, 0, 9, true);
        } else {
            b(0);
        }
        if (this.j != null && this.j.isShowing()) {
            this.j.dismiss();
        }
        a(this.J, this.J);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        ArrayList<BasicNameValuePair> arrayList = new ArrayList<>(0);
        arrayList.add(new BasicNameValuePair("fname", this.C));
        arrayList.add(new BasicNameValuePair("tid", this.D));
        if (this.G != null) {
            arrayList.add(new BasicNameValuePair("fid", this.G.j()));
        }
        if (this.z.d() != null) {
            this.z.d().a(arrayList);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("id", this.D);
        bundle.putString("forum", this.C);
        bundle.putInt("current_page", this.F);
        bundle.putString("title", this.E);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11005:
                    c(this.w);
                    return;
                case 11016:
                    this.I.show();
                    return;
                case 12001:
                    if (this.G != null && this.G.i() != null && this.C != null) {
                        WriteImageActivity.a(this, 12001, 12010, null, this.G.j(), this.C, null);
                        return;
                    }
                    return;
                case 12002:
                    if (this.G != null && this.G.i() != null && this.C != null) {
                        if (intent != null && intent.getData() != null) {
                            WriteImageActivity.a(this, 12002, 12009, intent.getData(), String.valueOf(this.G.j()), this.C, null);
                            return;
                        } else {
                            com.baidu.tieba.write.bb.b(this);
                            return;
                        }
                    }
                    return;
                case 12006:
                    if (intent.getSerializableExtra("model") != null) {
                        h();
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    if (this.G != null) {
                        if (intent == null || intent.getStringExtra("filename") == null) {
                            WriteActivity.a(this, this.G.j(), this.C, this.D, (AntiData) null, (String) null);
                            return;
                        } else {
                            WriteActivity.a(this, this.G.j(), this.C, this.D, (AntiData) null, intent.getStringExtra("filename"));
                            return;
                        }
                    }
                    return;
                case 14001:
                    if (intent != null && intent.getIntExtra("index", -1) >= 0) {
                        com.baidu.tieba.util.bo.a(getClass().getName(), "onActivityResult", "" + intent.getIntExtra("index", 0));
                        this.y.a(intent.getIntExtra("index", 0), false);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.x != null) {
            this.x.cancel();
        }
        this.x = new af(this, null);
        this.x.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        String A = TiebaApplication.A();
        if (A == null || A.length() <= 0) {
            if (this.G != null && this.G.e() != null) {
                this.G.e().setIfpost(1);
            }
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11016);
        } else if (this.G != null) {
            this.I.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, int i2, boolean z) {
        com.baidu.tieba.util.bo.a(getClass().getName(), str, "" + i2);
        if (!this.G.a() && this.b == null) {
            String str2 = com.baidu.tieba.data.h.a + "c/f/pb/picpage";
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
            int b = com.baidu.adp.lib.h.g.b(this);
            int c = com.baidu.adp.lib.h.g.c(this);
            float f = getResources().getDisplayMetrics().density;
            int i3 = com.baidu.tieba.util.bn.a().d().equals("80") ? 2 : 1;
            arrayList.add(new BasicNameValuePair("scr_w", String.valueOf(b)));
            arrayList.add(new BasicNameValuePair("scr_h", String.valueOf(c)));
            arrayList.add(new BasicNameValuePair("scr_dip", String.valueOf(f)));
            arrayList.add(new BasicNameValuePair("q_type", String.valueOf(i3)));
            a(true);
            com.baidu.tieba.util.bo.a(getClass().getName(), "startImagePbAsyncTask", str);
            this.b = new ab(this, str2.toString(), arrayList, z);
            this.b.setPriority(3);
            this.b.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        Intent intent = new Intent("com.baidu.tieba.broadcast.imagepb.pageadded");
        LinkedList<com.baidu.tieba.data.ab> h = this.G.h();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < h.size(); i2++) {
            com.baidu.tieba.data.ab abVar = h.get(i2);
            if (!P || abVar.j() == null) {
                StringBuilder sb = new StringBuilder(100);
                if (abVar.g() * abVar.f() > com.baidu.tieba.data.h.i() * com.baidu.tieba.data.h.i()) {
                    double sqrt = Math.sqrt((com.baidu.tieba.data.h.i() * com.baidu.tieba.data.h.i()) / (abVar.g() * abVar.f()));
                    sb.append("width=");
                    sb.append(String.valueOf((int) (abVar.f() * sqrt)));
                    sb.append("&height=");
                    sb.append(String.valueOf((int) (sqrt * abVar.g())));
                } else {
                    sb.append("width=");
                    sb.append(String.valueOf(abVar.f()));
                    sb.append("&height=");
                    sb.append(String.valueOf(abVar.g()));
                }
                sb.append("&src=");
                sb.append(com.baidu.tieba.util.bm.d(abVar.b()));
                arrayList.add(sb.toString());
            } else {
                arrayList.add(abVar.j());
            }
        }
        if (arrayList != null && arrayList.size() > 0) {
            intent.putStringArrayListExtra(SocialConstants.PARAM_URL, arrayList);
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

    /* loaded from: classes.dex */
    public class MyOnPageChangeListener implements android.support.v4.view.bq {
        public MyOnPageChangeListener() {
        }

        @Override // android.support.v4.view.bq
        public void onPageScrollStateChanged(int i) {
        }

        @Override // android.support.v4.view.bq
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.bq
        public void onPageSelected(int i) {
            ImagePbActivity.this.a(ImagePbActivity.this.J, i);
            ImagePbActivity.this.J = i;
            ImagePbActivity.this.d.setVisibility(4);
            ImagePbActivity.this.d.setClickable(false);
            ImagePbActivity.this.i.setText((CharSequence) null);
            if (ImagePbActivity.this.G != null && ImagePbActivity.this.G.k() > 0) {
                if (i == ImagePbActivity.this.G.k()) {
                    ImagePbActivity.this.i.setVisibility(8);
                    ImagePbActivity.this.h.setText(ImagePbActivity.this.getString(R.string.image_recommend));
                    ImagePbActivity.this.r.setVisibility(8);
                    com.baidu.tieba.util.bl.a(ImagePbActivity.this.y, TiebaApplication.g().an());
                    return;
                }
                ImagePbActivity.this.y.setBackgroundResource(0);
                ImagePbActivity.this.h.setText(ImagePbActivity.this.E);
                ImagePbActivity.this.i.setVisibility(0);
                ImagePbActivity.this.r.setVisibility(0);
                ImagePbActivity.this.i.setText(String.valueOf(i + 1) + "/" + String.valueOf(ImagePbActivity.this.G.k()));
                LinkedList<com.baidu.tieba.data.ab> h = ImagePbActivity.this.G.h();
                if (h != null && ImagePbActivity.this.J < h.size() && h.get(ImagePbActivity.this.J) != null) {
                    ImagePbActivity.this.L = h.get(ImagePbActivity.this.J).d();
                    if (h.get(ImagePbActivity.this.J).i().equals(TiebaApplication.A())) {
                        ImagePbActivity.this.d.setVisibility(0);
                        ImagePbActivity.this.d.setClickable(true);
                    }
                }
            }
            ImagePbActivity.this.M = System.nanoTime();
            ImagePbActivity.this.Q.removeCallbacks(ImagePbActivity.this.R);
            ImagePbActivity.this.Q.postDelayed(ImagePbActivity.this.R, 300L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
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
    public void c(int i) {
        String A = TiebaApplication.A();
        if (A == null || A.length() <= 0) {
            if (this.v != null) {
                this.v.setIfpost(1);
            }
            LoginActivity.a((Activity) this, getString(R.string.login_to_post), true, 11005);
        } else if (this.v != null && this.v.getIfpost() == 0) {
            com.baidu.adp.lib.h.g.a((Context) this, this.v.getForbid_info());
        } else {
            String obj = this.l.getText().toString();
            if (obj != null && obj.length() > 0 && this.G != null) {
                if (g()) {
                    obj = obj.substring(0, 140);
                }
                showLoadingDialog(getString(R.string.sending), this.t);
                WriteData writeData = new WriteData();
                writeData.setForumId(this.G.j());
                writeData.setForumName(this.G.i());
                writeData.setContent(obj);
                writeData.setVcode(null);
                writeData.setFloor(this.L);
                writeData.setThreadId(this.D);
                writeData.setFloorNum(0);
                writeData.setType(2);
                this.u = new ae(this, writeData);
                this.u.setPriority(3);
                this.u.execute(new Integer[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        showToast(TiebaApplication.g().getString(R.string.send_success));
        this.l.setText((CharSequence) null);
        if (this.o.getVisibility() == 0) {
            this.o.setVisibility(8);
        }
        com.baidu.adp.lib.h.g.a(this, this.l);
        this.q.setVisibility(8);
        this.r.setVisibility(0);
        this.n.setBackgroundResource(R.drawable.sub_pb_face);
        this.z.e();
    }

    @Override // com.baidu.tieba.j
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        if (str != null) {
            this.mWaitingDialog = ProgressDialog.show(this, "", str, true, true, onCancelListener);
        } else {
            this.mWaitingDialog = ProgressDialog.show(this, "", getResources().getString(R.string.Waiting), true, true, onCancelListener);
        }
    }

    @Override // com.baidu.tieba.j
    public void closeLoadingDialog() {
        if (this.mWaitingDialog != null) {
            try {
                if (this.mWaitingDialog.isShowing()) {
                    this.mWaitingDialog.dismiss();
                }
            } catch (Exception e) {
                com.baidu.tieba.util.bo.b(getClass().getName(), "closeLoadingDialog", e.getMessage());
            }
            this.mWaitingDialog = null;
        }
    }

    private void i() {
        this.l.addTextChangedListener(new q(this));
        this.l.setFilters(new InputFilter[]{new r(this)});
    }

    @Override // com.baidu.tieba.view.e
    public void a(int i) {
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
                    this.y.a(0, false);
                    this.i.setText((CharSequence) null);
                    this.H = this.G;
                    this.G = new com.baidu.tieba.data.ac();
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
                    this.y.a(this.J, false);
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
                    com.baidu.tieba.util.bo.e("ImagePbActivity", "imageChange", e.getMessage());
                }
            }
            this.M = System.nanoTime();
            if (this.G.h() != null && i2 < this.G.h().size()) {
                try {
                    if (this.N.get(this.G.h().get(i2).b()) == null) {
                        this.N.put(this.G.h().get(i2).b(), false);
                    }
                } catch (IndexOutOfBoundsException e2) {
                    com.baidu.tieba.util.bo.e("ImagePbActivity", "imageChange", e2.getMessage());
                }
            }
        }
        if (this.N.size() >= 100) {
            j();
        }
    }

    private void j() {
        if (this.N != null) {
            synchronized (this.N) {
                if (this.N.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.N.entrySet()) {
                        i = entry.getValue().booleanValue() ? i + 1 : i;
                    }
                    TiebaApplication.g().a(i, this.N.size(), "photo");
                    this.N.clear();
                }
            }
        }
    }

    @Override // com.baidu.tieba.editortool.t
    public void a(int i, Object obj) {
        if (i == 20) {
            if (obj != null && (obj instanceof com.baidu.tieba.editortool.q)) {
                com.baidu.tieba.editortool.q qVar = (com.baidu.tieba.editortool.q) obj;
                if (qVar.a() != null) {
                    if (com.baidu.tieba.util.bm.g(this.l.getText().toString()) >= 10) {
                        showToast(getResources().getString(R.string.too_many_face));
                        return;
                    }
                    this.l.getText().insert(this.l.getSelectionStart(), qVar.a());
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

    @Override // com.baidu.tieba.j, android.app.Activity, android.view.KeyEvent.Callback
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
