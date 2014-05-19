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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.bh;
import com.baidu.tbadk.core.atomData.bi;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortool.EmotionTabHost;
import com.baidu.tbadk.widget.KeyboardLayout;
import com.baidu.tieba.editortool.PbEditor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class ImagePbActivity extends BaseActivity implements com.baidu.tbadk.core.view.a, com.baidu.tbadk.editortool.x {
    private NoNetworkView P;
    private NavigationBar f;
    private EditText k;
    private Button l;
    private Button m;
    private EmotionTabHost n;
    private static final Pattern a = Pattern.compile("#\\([^#\\)\\(]+\\)$");
    private static boolean O = true;
    private r b = null;
    private final ImageView c = null;
    private Button d = null;
    private Button e = null;
    private TextView g = null;
    private TextView h = null;
    private AlertDialog i = null;
    private View j = null;
    private ProgressBar o = null;
    private LinearLayout p = null;
    private LinearLayout q = null;
    private KeyboardLayout r = null;
    private DialogInterface.OnCancelListener s = null;
    private v t = null;
    private final AntiData u = null;
    private final int v = 0;
    private w w = null;
    private BaseViewPager x = null;
    private ac y = null;
    private u z = null;
    private boolean A = false;
    private String B = null;
    private String C = null;
    private String D = null;
    private int E = 0;
    private com.baidu.tieba.data.u F = null;
    private com.baidu.tieba.data.u G = null;
    private AlertDialog H = null;
    private int I = 0;
    private s J = null;
    private String K = null;
    private long L = 0;
    private HashMap<String, Boolean> M = null;
    private boolean N = false;
    private Handler Q = null;
    private final Runnable R = new a(this);
    private final t S = new j(this);
    private final com.baidu.tbadk.widget.j T = new k(this);

    static {
        a();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkApplication.m252getInst().isGpuOpen();
    }

    private static void a() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2006002, new l());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.s.image_pb_activity);
        this.Q = new Handler();
        this.F = new com.baidu.tieba.data.u(this);
        d();
        a(bundle);
        b();
    }

    private void b() {
        this.z = new u(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionPageChanged());
        registerReceiver(this.z, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.Q.removeCallbacks(this.R);
        com.baidu.tbadk.editortool.ab d = this.y.d();
        if (d != null) {
            d.d();
        }
        this.A = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.Q.removeCallbacks(this.R);
        this.Q.post(this.R);
        this.A = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        a(this.I, this.I);
        j();
        if (this.w != null) {
            this.w.cancel();
        }
        if (this.o != null) {
            this.o.setVisibility(8);
        }
        if (this.t != null) {
            this.t.cancel();
        }
        if (this.b != null) {
            this.b.cancel();
        }
        if (this.i != null && this.i.isShowing()) {
            this.i.dismiss();
        }
        this.y.c();
        unregisterReceiver(this.z);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.i == null) {
            this.i = new AlertDialog.Builder(this).create();
            this.i.setCanceledOnTouchOutside(true);
            this.j = getLayoutInflater().inflate(com.baidu.tieba.s.pb_title_dialog, (ViewGroup) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.P != null) {
            this.P.a(i);
        }
        this.f.c(i);
        bc.d(this.g, i);
        bc.d(this.h, i);
        bc.a(this.c, i);
        bc.a(this.x, i);
        int childCount = this.x.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.x.getChildAt(i2);
            if (childAt.getId() == com.baidu.tieba.r.image_next) {
                TextView textView = (TextView) childAt.findViewById(com.baidu.tieba.r.next);
                TextView textView2 = (TextView) childAt.findViewById(com.baidu.tieba.r.thread_name);
                ImageView imageView = (ImageView) childAt.findViewById(com.baidu.tieba.r.image);
                if (textView != null && textView2 != null && imageView != null) {
                    if (i == 1) {
                        textView.setTextColor(bc.c(1));
                        textView2.setTextColor(bc.a(1));
                        imageView.setBackgroundResource(com.baidu.tieba.q.image_pb_next_default_1);
                    } else {
                        textView.setTextColor(-9539986);
                        textView2.setTextColor(-6250336);
                        imageView.setBackgroundResource(com.baidu.tieba.q.image_pb_next_default);
                    }
                }
            } else {
                View findViewById = childAt.findViewById(com.baidu.tieba.r.image_pb_listview);
                if (findViewById != null && (findViewById instanceof ListView)) {
                    ListView listView = (ListView) findViewById;
                    bc.a(listView, i);
                    if (childAt.getTag() != null && (childAt.getTag() instanceof x)) {
                        bc.a(listView, i);
                        ((x) childAt.getTag()).notifyDataSetChanged();
                    }
                }
            }
        }
        if (i == 1) {
            a(this.d, com.baidu.tieba.q.pb_bottom_btn_reply_1);
            a(this.e, com.baidu.tieba.q.image_pb_bottom_save_1);
            this.d.setTextColor(getResources().getColorStateList(com.baidu.tieba.o.text_blue_selector_color_1));
            this.e.setTextColor(getResources().getColorStateList(com.baidu.tieba.o.text_blue_selector_color_1));
            bc.e(this.p, com.baidu.tieba.q.sub_pb_reply_bg_1);
        } else {
            a(this.d, com.baidu.tieba.q.pb_bottom_btn_reply);
            a(this.e, com.baidu.tieba.q.image_pb_bottom_save);
            this.d.setTextColor(getResources().getColorStateList(com.baidu.tieba.o.text_blue_selector_color));
            this.e.setTextColor(getResources().getColorStateList(com.baidu.tieba.o.text_blue_selector_color));
            bc.e(this.p, com.baidu.tieba.q.sub_pb_reply_bg);
        }
        this.n.b(i);
    }

    private void a(Button button, int i) {
        button.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(i), (Drawable) null, (Drawable) null);
    }

    private void d() {
        this.f = (NavigationBar) findViewById(com.baidu.tieba.r.view_navigation_bar);
        this.f.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new m(this));
        View a2 = this.f.a(com.baidu.tieba.s.nb_item_pb_image_titleview, (View.OnClickListener) null);
        this.g = (TextView) a2.findViewById(com.baidu.tieba.r.title_text);
        this.h = (TextView) a2.findViewById(com.baidu.tieba.r.title_page);
        this.d = (Button) findViewById(com.baidu.tieba.r.reply);
        this.d.setOnClickListener(new n(this));
        this.e = (Button) findViewById(com.baidu.tieba.r.save);
        this.e.setOnClickListener(new o(this));
        this.g.setOnClickListener(new p(this));
        this.x = (BaseViewPager) findViewById(com.baidu.tieba.r.content_view);
        this.x.setOnFlipOutListener(this);
        String[] strArr = {getString(com.baidu.tieba.u.take_photo), getString(com.baidu.tieba.u.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(com.baidu.tieba.u.operation));
        builder.setItems(strArr, new q(this));
        this.p = (LinearLayout) findViewById(com.baidu.tieba.r.layout_reply);
        this.k = (EditText) findViewById(com.baidu.tieba.r.reply_content);
        this.m = (Button) findViewById(com.baidu.tieba.r.button_face);
        this.l = (Button) findViewById(com.baidu.tieba.r.reply_button);
        this.l.setEnabled(false);
        i();
        this.n = (EmotionTabHost) findViewById(com.baidu.tieba.r.face_view);
        this.n.setOnDataSelected(this);
        this.n.setShowBigEmotion(false);
        this.r = (KeyboardLayout) findViewById(com.baidu.tieba.r.image_pb_layout);
        this.r.setOnkbdStateListener(this.T);
        this.l.setOnClickListener(new c(this));
        this.m.setOnClickListener(new e(this, new Handler(), new d(this)));
        this.q = (LinearLayout) findViewById(com.baidu.tieba.r.image_pb_bottom);
        this.k.setOnTouchListener(new f(this));
        this.o = (ProgressBar) findViewById(com.baidu.tieba.r.image_pb_progress);
        this.s = new g(this);
        if (this.H == null) {
            this.H = builder.create();
            this.H.setCanceledOnTouchOutside(true);
        }
        this.P = (NoNetworkView) findViewById(com.baidu.tieba.r.view_no_network);
        b(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (this.o != null) {
            if (z) {
                this.o.setVisibility(0);
            } else {
                this.o.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (z) {
            this.k.requestFocus();
            this.p.setVisibility(0);
            this.n.setVisibility(8);
            com.baidu.adp.lib.util.h.b(this, this.k);
            this.m.setBackgroundResource(com.baidu.tieba.q.sub_pb_face);
            this.q.setVisibility(8);
            return;
        }
        this.p.setVisibility(8);
        this.n.setVisibility(8);
        com.baidu.adp.lib.util.h.a(this, this.k);
        this.q.setVisibility(0);
    }

    private void a(Bundle bundle) {
        this.E = 0;
        if (bundle != null) {
            this.C = bundle.getString(com.baidu.tbadk.core.frameworkData.a.THREAD_ID);
            this.B = bundle.getString("forum");
            this.D = bundle.getString("title");
            this.E = bundle.getInt("current_page");
        } else {
            this.C = getIntent().getStringExtra(com.baidu.tbadk.core.frameworkData.a.THREAD_ID);
            this.B = getIntent().getStringExtra("forum");
            this.D = getIntent().getStringExtra("title");
        }
        this.F.a(this.C);
        this.F.b(this.D);
        this.g.setText(this.D);
        this.y = new ac(this);
        this.y.a(this.S);
        this.y.a(this.C);
        this.x.setAdapter(this.y);
        this.J = new s(this);
        this.x.setOnPageChangeListener(this.J);
        this.x.setCurrentItem(this.E);
        if (this.B != null && this.B.length() > 0 && this.C != null && this.C.length() > 0) {
            a(null, 0, 9, true);
        }
        this.M = new HashMap<>();
        a(this.I, this.I);
    }

    private void c(boolean z) {
        this.Q.removeCallbacks(this.R);
        com.baidu.tbadk.editortool.ab d = this.y.d();
        if (d != null) {
            d.d();
        }
        if (!z) {
            String str = this.D;
            if (this.D != null) {
                if (this.D.length() > 6) {
                    str = String.valueOf(this.D.substring(0, 6)) + getString(com.baidu.tieba.u.three_point);
                }
                showToast(getString(com.baidu.tieba.u.image_pb_imagethread).replace("?", str));
            }
        }
        this.F.a(this.C);
        this.F.b(this.D);
        this.g.setText(this.D);
        this.y.b();
        this.y.a(this.C);
        this.y.a(this.F);
        this.y.notifyDataSetChanged();
        this.y.a();
        if (z && this.B != null && this.B.length() > 0 && this.C != null && this.C.length() > 0) {
            a(null, 0, 9, true);
        } else {
            b(0);
        }
        if (this.i != null && this.i.isShowing()) {
            this.i.dismiss();
        }
        a(this.I, this.I);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        ArrayList<BasicNameValuePair> arrayList = new ArrayList<>(0);
        arrayList.add(new BasicNameValuePair("fname", this.B));
        arrayList.add(new BasicNameValuePair("tid", this.C));
        if (this.F != null) {
            arrayList.add(new BasicNameValuePair("fid", this.F.i()));
        }
        if (this.y.d() != null) {
            this.y.d().a(arrayList);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(com.baidu.tbadk.core.frameworkData.a.THREAD_ID, this.C);
        bundle.putString("forum", this.B);
        bundle.putInt("current_page", this.E);
        bundle.putString("title", this.D);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x003f: INVOKE  (r4v9 int A[REMOVE]) = (r22v0 android.content.Intent), ("index"), (0 int) type: VIRTUAL call: android.content.Intent.getIntExtra(java.lang.String, int):int)] */
    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11005:
                    c(0);
                    return;
                case 11016:
                    this.H.show();
                    return;
                case 12001:
                    if (this.F != null && this.F.h() != null && this.B != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new bi(this, 12001, 12010, null, this.F.i(), this.B, null)));
                        return;
                    }
                    return;
                case 12002:
                    if (this.F != null && this.F.h() != null && this.B != null) {
                        if (intent != null && intent.getData() != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new bi(this, 12002, 12009, intent.getData(), String.valueOf(this.F.i()), this.B, null)));
                            return;
                        }
                        return;
                    }
                    bb.b(this);
                    return;
                case 12006:
                    if (intent.getSerializableExtra("model") != null) {
                        h();
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    if (this.F != null) {
                        if (intent == null || intent.getStringExtra("filename") == null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new bh(this, 1, this.F.i(), this.B, this.C, null, 0, null, 13002, false, false, null, false, true, null, null, null)));
                            return;
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new bh(this, 1, this.F.i(), this.B, this.C, null, 0, null, 13002, false, false, null, false, true, intent.getStringExtra("filename"), null, null)));
                        return;
                    }
                    return;
                case 14001:
                    if (intent != null && intent.getIntExtra("index", -1) >= 0) {
                        BdLog.i(getClass().getName(), "onActivityResult", new StringBuilder().append(intent.getIntExtra("index", 0)).toString());
                        this.x.setCurrentItem(intent.getIntExtra("index", 0), false);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.w != null) {
            this.w.cancel();
        }
        this.w = new w(this, null);
        this.w.execute(new String[0]);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r13v0 int)] */
    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, int i2, boolean z) {
        BdLog.i(getClass().getName(), str, new StringBuilder().append(i2).toString());
        if (!this.F.a() && this.b == null) {
            String str2 = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/pb/picpage";
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("kw", this.B));
            arrayList.add(new BasicNameValuePair("tid", this.C));
            if (str != null) {
                arrayList.add(new BasicNameValuePair("pic_id", str));
            }
            arrayList.add(new BasicNameValuePair("prev", String.valueOf(i)));
            arrayList.add(new BasicNameValuePair("next", String.valueOf(i2)));
            if (this.N) {
                this.N = false;
                arrayList.add(new BasicNameValuePair(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, "commend_pic_page"));
            }
            int b = com.baidu.adp.lib.util.h.b(this);
            int c = com.baidu.adp.lib.util.h.c(this);
            float f = getResources().getDisplayMetrics().density;
            int i3 = bf.a().d().equals("80") ? 2 : 1;
            arrayList.add(new BasicNameValuePair("scr_w", String.valueOf(b)));
            arrayList.add(new BasicNameValuePair("scr_h", String.valueOf(c)));
            arrayList.add(new BasicNameValuePair("scr_dip", String.valueOf(f)));
            arrayList.add(new BasicNameValuePair("q_type", String.valueOf(i3)));
            a(true);
            BdLog.i(getClass().getName(), "startImagePbAsyncTask", str);
            this.b = new r(this, str2.toString(), arrayList, z);
            this.b.setPriority(3);
            this.b.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        Intent intent = new Intent(com.baidu.tieba.data.d.a());
        LinkedList<com.baidu.tieba.data.t> g = this.F.g();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < g.size(); i2++) {
            com.baidu.tieba.data.t tVar = g.get(i2);
            if (!O || tVar.j() == null) {
                StringBuilder sb = new StringBuilder(100);
                if (tVar.g() * tVar.f() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                    double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (tVar.g() * tVar.f()));
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
                sb.append(be.d(tVar.b()));
                arrayList.add(sb.toString());
            } else {
                arrayList.add(tVar.j());
            }
        }
        if (arrayList != null && arrayList.size() > 0) {
            intent.putStringArrayListExtra("url", arrayList);
            intent.putExtra("count", this.F.j());
            if (this.F.b() && arrayList.size() == this.F.j()) {
                intent.putExtra("hasnext", true);
                intent.putExtra("nexttitle", this.F.f());
            }
            if (i == 0) {
                intent.putExtra("index", this.F.j() - 1);
            } else if (i == 1) {
                intent.putExtra("index", 0);
            } else {
                intent.putExtra("index", -1);
            }
            sendBroadcast(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        ImageSpan[] imageSpanArr = (ImageSpan[]) this.k.getText().getSpans(0, this.k.getText().length(), ImageSpan.class);
        int length = imageSpanArr.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (imageSpanArr[i2] != null && imageSpanArr[i2].getSource() != null) {
                i += imageSpanArr[i2].getSource().length();
            }
        }
        return (this.k.getText().toString().length() - i) + length > 140;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            if (this.u != null) {
                this.u.setIfpost(1);
            }
            LoginActivity.a((Activity) this, getString(com.baidu.tieba.u.login_to_post), true, 11005);
        } else if (this.u != null && this.u.getIfpost() == 0) {
            com.baidu.adp.lib.util.h.a((Context) this, this.u.getForbid_info());
        } else {
            String editable = this.k.getText().toString();
            if (editable != null && editable.length() > 0 && this.F != null) {
                if (g()) {
                    editable = editable.substring(0, 140);
                }
                showLoadingDialog(getString(com.baidu.tieba.u.sending), this.s);
                WriteData writeData = new WriteData();
                writeData.setForumId(this.F.i());
                writeData.setForumName(this.F.h());
                writeData.setContent(editable);
                writeData.setVcode(null);
                writeData.setFloor(this.K);
                writeData.setThreadId(this.C);
                writeData.setFloorNum(0);
                writeData.setType(2);
                this.t = new v(this, writeData);
                this.t.setPriority(3);
                this.t.execute(new Integer[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        showToast(com.baidu.tieba.ad.c().d().getString(com.baidu.tieba.u.send_success));
        this.k.setText((CharSequence) null);
        if (this.n.getVisibility() == 0) {
            this.n.setVisibility(8);
        }
        com.baidu.adp.lib.util.h.a(this, this.k);
        this.p.setVisibility(8);
        this.q.setVisibility(0);
        this.m.setBackgroundResource(com.baidu.tieba.q.sub_pb_face);
        this.y.e();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        if (str != null) {
            this.mWaitingDialog = ProgressDialog.show(this, "", str, true, true, onCancelListener);
        } else {
            this.mWaitingDialog = ProgressDialog.show(this, "", getResources().getString(com.baidu.tieba.u.Waiting), true, true, onCancelListener);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.mWaitingDialog != null) {
            try {
                if (this.mWaitingDialog.isShowing()) {
                    this.mWaitingDialog.dismiss();
                }
            } catch (Exception e) {
                BdLog.e(getClass().getName(), "closeLoadingDialog", e.getMessage());
            }
            this.mWaitingDialog = null;
        }
    }

    private void i() {
        this.k.addTextChangedListener(new h(this));
        this.k.setFilters(new InputFilter[]{new i(this)});
    }

    @Override // com.baidu.tbadk.core.view.a
    public void a(int i) {
        switch (i) {
            case 0:
                if (this.F.e() != null && this.F.f() != null) {
                    if (this.b != null) {
                        this.b.cancel();
                    }
                    this.C = this.F.e();
                    this.B = this.F.h();
                    this.D = this.F.f();
                    this.I = 0;
                    this.x.setCurrentItem(0, false);
                    this.h.setText((CharSequence) null);
                    this.G = this.F;
                    this.F = new com.baidu.tieba.data.u();
                    this.N = true;
                    c(true);
                    return;
                }
                return;
            case 1:
                if (this.G != null) {
                    if (this.b != null) {
                        this.b.cancel();
                    }
                    this.F = this.G;
                    this.G = null;
                    this.C = this.F.c();
                    this.B = this.F.h();
                    this.D = this.F.d();
                    this.I = this.F.j() - 1;
                    this.N = false;
                    c(false);
                    this.x.setCurrentItem(this.I, false);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        synchronized (this.M) {
            if (System.nanoTime() - this.L > 300000000 && this.F != null && this.F.g() != null && this.I < this.F.g().size()) {
                try {
                    this.M.put(this.F.g().get(i).b(), true);
                } catch (IndexOutOfBoundsException e) {
                    BdLog.d("ImagePbActivity", "imageChange", e.getMessage());
                }
            }
            this.L = System.nanoTime();
            if (this.F.g() != null && i2 < this.F.g().size()) {
                try {
                    if (this.M.get(this.F.g().get(i2).b()) == null) {
                        this.M.put(this.F.g().get(i2).b(), false);
                    }
                } catch (IndexOutOfBoundsException e2) {
                    BdLog.d("ImagePbActivity", "imageChange", e2.getMessage());
                }
            }
        }
        if (this.M.size() >= 100) {
            j();
        }
    }

    private void j() {
        if (this.M != null) {
            synchronized (this.M) {
                if (this.M.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.M.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkApplication.m252getInst().sendImagePv(i, this.M.size(), "photo");
                    this.M.clear();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.editortool.x
    public void a(int i, Object obj) {
        if (i == 20) {
            if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.data.d)) {
                com.baidu.tbadk.coreExtra.data.d dVar = (com.baidu.tbadk.coreExtra.data.d) obj;
                if (dVar.a() != null) {
                    if (PbEditor.a(this.k.getText().toString()) >= 10) {
                        showToast(getResources().getString(com.baidu.tieba.u.too_many_face));
                        return;
                    }
                    this.k.getText().insert(this.k.getSelectionStart(), dVar.a());
                }
            }
        } else if (i == 21 && this.k.getSelectionStart() > 0) {
            String substring = this.k.getText().toString().substring(0, this.k.getSelectionStart());
            Matcher matcher = a.matcher(substring);
            if (matcher.find()) {
                this.k.getText().delete(this.k.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.k.getSelectionStart());
                return;
            }
            this.k.getText().delete(this.k.getSelectionStart() - 1, this.k.getSelectionStart());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.n.getVisibility() == 0) {
                    b(false);
                    return true;
                }
                closeActivity();
                break;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
