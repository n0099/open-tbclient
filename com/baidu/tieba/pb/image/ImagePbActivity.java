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
import com.baidu.tbadk.core.atomData.ce;
import com.baidu.tbadk.core.atomData.cf;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortool.EmotionTabHost;
import com.baidu.tbadk.widget.KeyboardLayout;
import com.baidu.tieba.ai;
import com.baidu.tieba.editortool.PbEditor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class ImagePbActivity extends BaseActivity implements com.baidu.tbadk.core.view.a, com.baidu.tbadk.editortool.w {
    private NoNetworkView O;
    private int R;
    private int S;
    private NavigationBar f;
    private EditText k;
    private Button l;
    private Button m;
    private EmotionTabHost n;
    private static final Pattern a = Pattern.compile("#\\([^#\\)\\(]+\\)$");
    private static boolean N = true;
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
    private w v = null;
    private BaseViewPager w = null;
    private ac x = null;
    private u y = null;
    private boolean z = false;
    private String A = null;
    private String B = null;
    private String C = null;
    private int D = 0;
    private com.baidu.tieba.data.w E = null;
    private com.baidu.tieba.data.w F = null;
    private AlertDialog G = null;
    private int H = 0;
    private s I = null;
    private String J = null;
    private long K = 0;
    private HashMap<String, Boolean> L = null;
    private boolean M = false;
    private Handler P = null;
    private final Runnable Q = new a(this);
    private final t T = new j(this);
    private final com.baidu.tbadk.widget.i U = new k(this);

    static {
        a();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkApplication.m252getInst().isGpuOpen();
    }

    private static void a() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2004002, new l());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.v.image_pb_activity);
        this.P = new Handler();
        this.E = new com.baidu.tieba.data.w(this);
        d();
        a(bundle);
        b();
        int b = com.baidu.adp.lib.util.j.b(this);
        this.S = (com.baidu.adp.lib.util.j.c(this) * 3) / 5;
        if (TbConfig.getThreadImageMaxWidth() < b) {
            b = TbConfig.getThreadImageMaxWidth();
        }
        this.R = b - com.baidu.adp.lib.util.j.a((Context) this, 8.0f);
        this.S = TbConfig.getThreadImageMaxWidth() < this.S ? TbConfig.getThreadImageMaxWidth() : this.S;
    }

    private void b() {
        this.y = new u(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionPageChanged());
        registerReceiver(this.y, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.P.removeCallbacks(this.Q);
        this.z = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.P.removeCallbacks(this.Q);
        this.P.post(this.Q);
        this.z = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        a(this.H, this.H);
        j();
        if (this.v != null) {
            this.v.cancel();
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
        this.x.c();
        unregisterReceiver(this.y);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.i == null) {
            this.i = new AlertDialog.Builder(this).create();
            this.i.setCanceledOnTouchOutside(true);
            this.j = getLayoutInflater().inflate(com.baidu.tieba.v.pb_title_dialog, (ViewGroup) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.O != null) {
            this.O.a(i);
        }
        this.f.c(i);
        ay.d(this.g, i);
        ay.d(this.h, i);
        ay.a(this.c, i);
        ay.a(this.w, i);
        int childCount = this.w.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.w.getChildAt(i2);
            if (childAt.getId() == com.baidu.tieba.u.image_next) {
                TextView textView = (TextView) childAt.findViewById(com.baidu.tieba.u.next);
                TextView textView2 = (TextView) childAt.findViewById(com.baidu.tieba.u.thread_name);
                ImageView imageView = (ImageView) childAt.findViewById(com.baidu.tieba.u.image);
                if (textView != null && textView2 != null && imageView != null) {
                    if (i == 1) {
                        textView.setTextColor(ay.c(1));
                        textView2.setTextColor(ay.a(1));
                        imageView.setBackgroundResource(com.baidu.tieba.t.image_pb_next_default_1);
                    } else {
                        textView.setTextColor(-9539986);
                        textView2.setTextColor(-6250336);
                        imageView.setBackgroundResource(com.baidu.tieba.t.image_pb_next_default);
                    }
                }
            } else {
                View findViewById = childAt.findViewById(com.baidu.tieba.u.image_pb_listview);
                if (findViewById != null && (findViewById instanceof ListView)) {
                    ListView listView = (ListView) findViewById;
                    ay.a(listView, i);
                    if (childAt.getTag() != null && (childAt.getTag() instanceof x)) {
                        ay.a(listView, i);
                        ((x) childAt.getTag()).notifyDataSetChanged();
                    }
                }
            }
        }
        if (i == 1) {
            a(this.d, com.baidu.tieba.t.pb_bottom_btn_reply_1);
            a(this.e, com.baidu.tieba.t.image_pb_bottom_save_1);
            this.d.setTextColor(getResources().getColorStateList(com.baidu.tieba.r.text_blue_selector_color_1));
            this.e.setTextColor(getResources().getColorStateList(com.baidu.tieba.r.text_blue_selector_color_1));
            ay.e(this.p, com.baidu.tieba.t.sub_pb_reply_bg_1);
        } else {
            a(this.d, com.baidu.tieba.t.pb_bottom_btn_reply);
            a(this.e, com.baidu.tieba.t.image_pb_bottom_save);
            this.d.setTextColor(getResources().getColorStateList(com.baidu.tieba.r.text_blue_selector_color));
            this.e.setTextColor(getResources().getColorStateList(com.baidu.tieba.r.text_blue_selector_color));
            ay.e(this.p, com.baidu.tieba.t.sub_pb_reply_bg);
        }
        this.n.b(i);
    }

    private void a(Button button, int i) {
        Drawable drawable = getResources().getDrawable(i);
        if (button != null) {
            button.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, drawable, (Drawable) null, (Drawable) null);
        }
    }

    private void d() {
        this.f = (NavigationBar) findViewById(com.baidu.tieba.u.view_navigation_bar);
        this.f.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new m(this));
        View a2 = this.f.a(com.baidu.tieba.v.nb_item_pb_image_titleview, (View.OnClickListener) null);
        this.g = (TextView) a2.findViewById(com.baidu.tieba.u.title_text);
        this.h = (TextView) a2.findViewById(com.baidu.tieba.u.title_page);
        this.d = (Button) findViewById(com.baidu.tieba.u.reply);
        this.d.setOnClickListener(new n(this));
        this.e = (Button) findViewById(com.baidu.tieba.u.save);
        this.e.setOnClickListener(new o(this));
        this.g.setOnClickListener(new p(this));
        this.w = (BaseViewPager) findViewById(com.baidu.tieba.u.content_view);
        this.w.setOnFlipOutListener(this);
        String[] strArr = {getString(com.baidu.tieba.x.take_photo), getString(com.baidu.tieba.x.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(com.baidu.tieba.x.operation));
        builder.setItems(strArr, new q(this));
        this.p = (LinearLayout) findViewById(com.baidu.tieba.u.layout_reply);
        this.k = (EditText) findViewById(com.baidu.tieba.u.reply_content);
        this.m = (Button) findViewById(com.baidu.tieba.u.button_face);
        this.l = (Button) findViewById(com.baidu.tieba.u.reply_button);
        this.l.setEnabled(false);
        i();
        this.n = (EmotionTabHost) findViewById(com.baidu.tieba.u.face_view);
        this.n.setOnDataSelected(this);
        this.n.setShowBigEmotion(false);
        this.r = (KeyboardLayout) findViewById(com.baidu.tieba.u.image_pb_layout);
        this.r.setOnkbdStateListener(this.U);
        this.l.setOnClickListener(new c(this));
        this.m.setOnClickListener(new e(this, new Handler(), new d(this)));
        this.q = (LinearLayout) findViewById(com.baidu.tieba.u.image_pb_bottom);
        this.k.setOnTouchListener(new f(this));
        this.o = (ProgressBar) findViewById(com.baidu.tieba.u.image_pb_progress);
        this.s = new g(this);
        if (this.G == null) {
            this.G = builder.create();
            this.G.setCanceledOnTouchOutside(true);
        }
        this.O = (NoNetworkView) findViewById(com.baidu.tieba.u.view_no_network);
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
            com.baidu.adp.lib.util.j.b(this, this.k);
            this.m.setBackgroundResource(com.baidu.tieba.t.sub_pb_face);
            this.q.setVisibility(8);
            return;
        }
        this.p.setVisibility(8);
        this.n.setVisibility(8);
        com.baidu.adp.lib.util.j.a(this, this.k);
        this.q.setVisibility(0);
    }

    private void a(Bundle bundle) {
        this.D = 0;
        if (bundle != null) {
            this.B = bundle.getString(com.baidu.tbadk.core.frameworkData.a.THREAD_ID);
            this.A = bundle.getString("forum");
            this.C = bundle.getString("title");
            this.D = bundle.getInt("current_page");
        } else {
            this.B = getIntent().getStringExtra(com.baidu.tbadk.core.frameworkData.a.THREAD_ID);
            this.A = getIntent().getStringExtra("forum");
            this.C = getIntent().getStringExtra("title");
        }
        this.E.a(this.B);
        this.E.b(this.C);
        this.g.setText(this.C);
        this.x = new ac(this);
        this.x.a(this.T);
        this.x.a(this.B);
        this.w.setAdapter(this.x);
        this.I = new s(this);
        this.w.setOnPageChangeListener(this.I);
        this.w.setCurrentItem(this.D);
        if (this.A != null && this.A.length() > 0 && this.B != null && this.B.length() > 0) {
            a(null, 0, 9, true);
        }
        this.L = new HashMap<>();
        a(this.H, this.H);
    }

    private void c(boolean z) {
        this.P.removeCallbacks(this.Q);
        if (!z) {
            String str = this.C;
            if (this.C != null) {
                if (this.C.length() > 6) {
                    str = String.valueOf(this.C.substring(0, 6)) + getString(com.baidu.tieba.x.three_point);
                }
                showToast(getString(com.baidu.tieba.x.image_pb_imagethread).replace("?", str));
            }
        }
        this.E.a(this.B);
        this.E.b(this.C);
        this.g.setText(this.C);
        this.x.b();
        this.x.a(this.B);
        this.x.a(this.E);
        this.x.notifyDataSetChanged();
        this.x.a();
        if (z && this.A != null && this.A.length() > 0 && this.B != null && this.B.length() > 0) {
            a(null, 0, 9, true);
        } else {
            b(0);
        }
        if (this.i != null && this.i.isShowing()) {
            com.baidu.adp.lib.e.d.b(this.i, this);
        }
        a(this.H, this.H);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        ArrayList arrayList = new ArrayList(0);
        arrayList.add(new BasicNameValuePair("fname", this.A));
        arrayList.add(new BasicNameValuePair("tid", this.B));
        if (this.E != null) {
            arrayList.add(new BasicNameValuePair("fid", this.E.i()));
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(com.baidu.tbadk.core.frameworkData.a.THREAD_ID, this.B);
        bundle.putString("forum", this.A);
        bundle.putInt("current_page", this.D);
        bundle.putString("title", this.C);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11005:
                    c(0);
                    return;
                case 11016:
                    com.baidu.adp.lib.e.d.a(this.G, this);
                    return;
                case 12001:
                    if (this.E != null && this.E.h() != null && this.A != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new cf(this, 12001, 12010, null, this.E.i(), this.A, null)));
                        return;
                    }
                    return;
                case 12002:
                    if (this.E != null && this.E.h() != null && this.A != null) {
                        if (intent != null && intent.getData() != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new cf(this, 12002, 12009, intent.getData(), String.valueOf(this.E.i()), this.A, null)));
                            return;
                        }
                        return;
                    }
                    ax.b(this);
                    return;
                case 12006:
                    if (intent != null && intent.getSerializableExtra("model") != null) {
                        h();
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    if (this.E != null) {
                        if (intent == null || intent.getStringExtra("filename") == null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ce(this, 1, this.E.i(), this.A, this.B, null, 0, null, 13002, false, false, null, false, true, null, null, null, 0)));
                            return;
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ce(this, 1, this.E.i(), this.A, this.B, null, 0, null, 13002, false, false, null, false, true, intent.getStringExtra("filename"), null, null, 0)));
                        return;
                    }
                    return;
                case 14001:
                    if (intent != null && intent.getIntExtra("index", -1) >= 0) {
                        this.w.setCurrentItem(intent.getIntExtra("index", 0), false);
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
        if (this.v != null) {
            this.v.cancel();
        }
        this.v = new w(this, null);
        this.v.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, int i2, boolean z) {
        if (!this.E.a() && this.b == null) {
            String str2 = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/pb/picpage";
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("kw", this.A));
            arrayList.add(new BasicNameValuePair("tid", this.B));
            if (str != null) {
                arrayList.add(new BasicNameValuePair("pic_id", str));
            }
            arrayList.add(new BasicNameValuePair("prev", String.valueOf(i)));
            arrayList.add(new BasicNameValuePair("next", String.valueOf(i2)));
            if (this.M) {
                this.M = false;
                arrayList.add(new BasicNameValuePair(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, "commend_pic_page"));
            }
            int b = com.baidu.adp.lib.util.j.b(this);
            int c = com.baidu.adp.lib.util.j.c(this);
            float f = getResources().getDisplayMetrics().density;
            int i3 = bb.a().d().equals("80") ? 2 : 1;
            arrayList.add(new BasicNameValuePair("scr_w", String.valueOf(b)));
            arrayList.add(new BasicNameValuePair("scr_h", String.valueOf(c)));
            arrayList.add(new BasicNameValuePair("scr_dip", String.valueOf(f)));
            arrayList.add(new BasicNameValuePair("q_type", String.valueOf(i3)));
            a(true);
            this.b = new r(this, str2.toString(), arrayList, z);
            this.b.setPriority(3);
            this.b.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        Intent intent = new Intent(com.baidu.tieba.data.e.a());
        LinkedList<com.baidu.tieba.data.v> g = this.E.g();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < g.size(); i2++) {
            com.baidu.tieba.data.v vVar = g.get(i2);
            if (!N || vVar.j() == null) {
                StringBuilder sb = new StringBuilder(100);
                if (vVar.g() * vVar.f() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                    double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (vVar.g() * vVar.f()));
                    sb.append("width=");
                    sb.append(String.valueOf((int) (vVar.f() * sqrt)));
                    sb.append("&height=");
                    sb.append(String.valueOf((int) (sqrt * vVar.g())));
                } else {
                    sb.append("width=");
                    sb.append(String.valueOf(vVar.f()));
                    sb.append("&height=");
                    sb.append(String.valueOf(vVar.g()));
                }
                sb.append("&src=");
                sb.append(ba.d(vVar.b()));
                arrayList.add(sb.toString());
            } else {
                arrayList.add(vVar.j());
            }
        }
        if (arrayList != null && arrayList.size() > 0) {
            intent.putStringArrayListExtra("url", arrayList);
            intent.putExtra("count", this.E.j());
            if (this.E.b() && arrayList.size() == this.E.j()) {
                intent.putExtra("hasnext", true);
                intent.putExtra("nexttitle", this.E.f());
            }
            if (i == 0) {
                intent.putExtra("index", this.E.j() - 1);
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
            LoginActivity.a((Activity) this, getString(com.baidu.tieba.x.login_to_post), true, 11005);
        } else if (this.u != null && this.u.getIfpost() == 0) {
            com.baidu.adp.lib.util.j.a((Context) this, this.u.getForbid_info());
        } else {
            String editable = this.k.getText().toString();
            if (editable != null && editable.length() > 0 && this.E != null) {
                if (g()) {
                    editable = editable.substring(0, 140);
                }
                showLoadingDialog(getString(com.baidu.tieba.x.sending), this.s);
                WriteData writeData = new WriteData();
                writeData.setForumId(this.E.i());
                writeData.setForumName(this.E.h());
                writeData.setContent(editable);
                writeData.setVcode(null);
                writeData.setFloor(this.J);
                writeData.setThreadId(this.B);
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
        showToast(ai.c().d().getString(com.baidu.tieba.x.send_success));
        this.k.setText((CharSequence) null);
        if (this.n.getVisibility() == 0) {
            this.n.setVisibility(8);
        }
        com.baidu.adp.lib.util.j.a(this, this.k);
        this.p.setVisibility(8);
        this.q.setVisibility(0);
        this.m.setBackgroundResource(com.baidu.tieba.t.sub_pb_face);
        this.x.d();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        if (str != null) {
            this.mWaitingDialog = ProgressDialog.show(this, "", str, true, true, onCancelListener);
        } else {
            this.mWaitingDialog = ProgressDialog.show(this, "", getResources().getString(com.baidu.tieba.x.Waiting), true, true, onCancelListener);
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
                BdLog.e(e.getMessage());
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
                if (this.E.e() != null && this.E.f() != null) {
                    if (this.b != null) {
                        this.b.cancel();
                    }
                    this.B = this.E.e();
                    this.A = this.E.h();
                    this.C = this.E.f();
                    this.H = 0;
                    this.w.setCurrentItem(0, false);
                    this.h.setText((CharSequence) null);
                    this.F = this.E;
                    this.E = new com.baidu.tieba.data.w();
                    this.M = true;
                    c(true);
                    return;
                }
                return;
            case 1:
                if (this.F != null) {
                    if (this.b != null) {
                        this.b.cancel();
                    }
                    this.E = this.F;
                    this.F = null;
                    this.B = this.E.c();
                    this.A = this.E.h();
                    this.C = this.E.d();
                    this.H = this.E.j() - 1;
                    this.M = false;
                    c(false);
                    this.w.setCurrentItem(this.H, false);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        synchronized (this.L) {
            if (System.nanoTime() - this.K > 300000000 && this.E != null && this.E.g() != null && this.H < this.E.g().size()) {
                try {
                    this.L.put(this.E.g().get(i).b(), true);
                } catch (IndexOutOfBoundsException e) {
                    BdLog.d(e.getMessage());
                }
            }
            this.K = System.nanoTime();
            if (this.E.g() != null && i2 < this.E.g().size()) {
                try {
                    if (this.L.get(this.E.g().get(i2).b()) == null) {
                        this.L.put(this.E.g().get(i2).b(), false);
                    }
                } catch (IndexOutOfBoundsException e2) {
                    BdLog.d(e2.getMessage());
                }
            }
        }
        if (this.L.size() >= 100) {
            j();
        }
    }

    private void j() {
        if (this.L != null) {
            synchronized (this.L) {
                if (this.L.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.L.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkApplication.m252getInst().sendImagePv(i, this.L.size(), "photo");
                    this.L.clear();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.editortool.w
    public void a(int i, Object obj) {
        if (i == 20) {
            if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.data.d)) {
                com.baidu.tbadk.coreExtra.data.d dVar = (com.baidu.tbadk.coreExtra.data.d) obj;
                if (dVar.a() != null) {
                    if (PbEditor.a(this.k.getText().toString()) >= 10) {
                        showToast(getResources().getString(com.baidu.tieba.x.too_many_face));
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
