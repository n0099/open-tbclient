package com.baidu.ufosdk.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.e0;
import com.baidu.ufosdk.p1;
import com.baidu.ufosdk.t1;
import com.baidu.ufosdk.u1;
import com.baidu.ufosdk.v1;
import com.baidu.ufosdk.x0;
import com.baidu.ufosdk.y0;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
@SuppressLint({"HandlerLeak", "InlinedApi"})
/* loaded from: classes9.dex */
public class FeedbackListActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout a;
    public LinearLayout b;
    public LinearLayout c;
    public TextView d;
    public List<Map<String, Object>> e;
    public int f;
    public Button g;
    public ImageView h;
    public TextView i;
    public ListView j;
    public j k;
    public View l;
    public View m;
    public ExecutorService n;
    public PopupWindow o;
    public WindowManager p;
    public View q;
    public WindowManager.LayoutParams r;
    public boolean s;
    public boolean t;
    public e0 u;
    public Handler v;
    public BroadcastReceiver w;

    /* loaded from: classes9.dex */
    public class b extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FeedbackListActivity a;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Context applicationContext = this.a.a.getApplicationContext();
                    String str = this.a.a.u.a;
                    com.baidu.ufosdk.b.f(applicationContext);
                }
            }
        }

        public b(FeedbackListActivity feedbackListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedbackListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = feedbackListActivity;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                if (intent.getAction().equals("com.baidu.ufosdk.gethistorylist")) {
                    this.a.m.setVisibility(8);
                    this.a.v.obtainMessage(0, (ArrayList) intent.getSerializableExtra("msgList")).sendToTarget();
                    FeedbackListActivity feedbackListActivity = this.a;
                    if (feedbackListActivity != null) {
                        v1.b.a.a(new y0(feedbackListActivity));
                    } else {
                        throw null;
                    }
                }
                if (intent.getAction().equals("com.baidu.ufosdk.getnewhistoryflag")) {
                    this.a.n.execute(new a(this));
                }
                if (intent.getAction().equals("com.baidu.ufosdk.deletemsg_dialogdismiss")) {
                    this.a.l.setVisibility(8);
                    this.a.m.setVisibility(8);
                }
                if (intent.getAction().equals("com.baidu.ufosdk.reload")) {
                    this.a.v.obtainMessage(1, null).sendToTarget();
                }
                if (intent.getAction().equals("com.baidu.ufosdk.fail")) {
                    this.a.i.setText(t1.a("18"));
                    this.a.i.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FeedbackListActivity a;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Context applicationContext = this.a.a.getApplicationContext();
                    String str = this.a.a.u.a;
                    com.baidu.ufosdk.b.f(applicationContext);
                }
            }
        }

        public d(FeedbackListActivity feedbackListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedbackListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = feedbackListActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && !com.baidu.ufosdk.b.n()) {
                try {
                    this.a.b.setVisibility(8);
                    this.a.l.setVisibility(0);
                    if (this.a.u.a.length() == 0) {
                        this.a.u.a(false);
                    } else {
                        this.a.n = Executors.newSingleThreadExecutor();
                        this.a.n.execute(new a(this));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FeedbackListActivity a;

        public a(FeedbackListActivity feedbackListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedbackListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = feedbackListActivity;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                if (message.what == 0) {
                    this.a.c.setVisibility(0);
                    this.a.e = (List) message.obj;
                    int i = 0;
                    while (true) {
                        if (i >= this.a.e.size()) {
                            break;
                        } else if (!this.a.e.get(i).get("newmsg").equals("0")) {
                            this.a.v.obtainMessage(2, Integer.valueOf(i)).sendToTarget();
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (this.a.e.size() == 0) {
                        this.a.i.setVisibility(0);
                    } else {
                        this.a.i.setVisibility(8);
                    }
                    this.a.k.notifyDataSetChanged();
                }
                if (message.what == 1) {
                    this.a.c.setVisibility(8);
                    this.a.l.setVisibility(8);
                    this.a.i.setText(t1.a("18"));
                    this.a.i.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FeedbackListActivity a;

        public c(FeedbackListActivity feedbackListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedbackListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = feedbackListActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.setResult(0);
                this.a.finish();
                u1.a(com.baidu.ufosdk.b.i(this.a).edit().putBoolean("his_dty", true));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements AbsListView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.widget.AbsListView.RecyclerListener
        public void onMovedToScrapHeap(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            }
        }

        public e(FeedbackListActivity feedbackListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedbackListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FeedbackListActivity a;

        public f(FeedbackListActivity feedbackListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedbackListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = feedbackListActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.e.get(i).put("newmsg", "0");
                this.a.k.notifyDataSetChanged();
                Intent intent = new Intent();
                intent.setClass(this.a, FeedbackInputActivity.class);
                intent.putExtra("msgid", (String) this.a.e.get(i).get("id"));
                intent.putExtra("appid", (String) this.a.e.get(i).get("appid"));
                intent.putExtra("isToolEva", 1);
                if (!com.baidu.ufosdk.b.n()) {
                    this.a.startActivity(intent);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g implements AdapterView.OnItemLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FeedbackListActivity a;

        public g(FeedbackListActivity feedbackListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedbackListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = feedbackListActivity;
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view2, int i, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)})) == null) {
                String str = (String) this.a.e.get(i).get("id");
                String str2 = (String) this.a.e.get(i).get("appid");
                FeedbackListActivity feedbackListActivity = this.a;
                Context applicationContext = feedbackListActivity.getApplicationContext();
                String a = t1.a("3");
                if (feedbackListActivity != null) {
                    RelativeLayout relativeLayout = new RelativeLayout(applicationContext);
                    RelativeLayout relativeLayout2 = new RelativeLayout(applicationContext);
                    relativeLayout2.setBackgroundDrawable(null);
                    relativeLayout.setBackgroundResource(R.drawable.obfuscated_res_0x7f081545);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(p1.a(applicationContext, 19.0f), p1.a(applicationContext, 23.0f));
                    relativeLayout2.setLayoutParams(layoutParams);
                    ImageView imageView = new ImageView(applicationContext);
                    imageView.setId(2031681771);
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    imageView.setAdjustViewBounds(true);
                    imageView.setImageBitmap(p1.b(applicationContext, "ufo_delete_btn_icon.png"));
                    layoutParams.addRule(14);
                    relativeLayout2.addView(imageView, layoutParams);
                    TextView textView = new TextView(applicationContext);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams2.setMargins(0, p1.a(applicationContext, 5.0f), 0, 0);
                    textView.setTextColor(-1);
                    textView.setText(a);
                    textView.setTextSize(11.0f);
                    layoutParams2.addRule(14);
                    layoutParams2.addRule(3, imageView.getId());
                    relativeLayout2.addView(textView, layoutParams2);
                    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams3.setMargins(0, 0, 0, 0);
                    relativeLayout2.setPadding(0, 0, 0, 0);
                    layoutParams3.addRule(13);
                    relativeLayout.addView(relativeLayout2, layoutParams3);
                    relativeLayout.setOnClickListener(new x0(feedbackListActivity, applicationContext, str, str2));
                    this.a.o = new PopupWindow(relativeLayout, p1.a(this.a.getApplicationContext(), 79.0f), p1.a(this.a.getApplicationContext(), 68.0f));
                    this.a.o.setFocusable(false);
                    this.a.o.setOutsideTouchable(true);
                    this.a.o.setBackgroundDrawable(new BitmapDrawable());
                    relativeLayout.getLocationOnScreen(new int[2]);
                    FeedbackListActivity feedbackListActivity2 = this.a;
                    feedbackListActivity2.o.showAtLocation(feedbackListActivity2.a, 17, 0, 0);
                    return true;
                }
                throw null;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ FeedbackListActivity b;

        public h(FeedbackListActivity feedbackListActivity, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedbackListActivity, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = feedbackListActivity;
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Context context = this.a;
                String str = this.b.u.a;
                com.baidu.ufosdk.b.f(context);
            }
        }
    }

    /* loaded from: classes9.dex */
    public final class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public TextView b;
        public TextView c;
        public TextView d;

        public i(FeedbackListActivity feedbackListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedbackListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class j extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;
        public final /* synthetic */ FeedbackListActivity b;

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                return null;
            }
            return invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                return 0L;
            }
            return invokeI.longValue;
        }

        public j(FeedbackListActivity feedbackListActivity, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedbackListActivity, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = feedbackListActivity;
            this.a = context;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.b.e.size();
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view2, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            i iVar;
            RelativeLayout relativeLayout;
            i iVar2;
            i iVar3;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i, view2, viewGroup)) == null) {
                if (view2 == null) {
                    iVar = new i(this.b);
                    RelativeLayout relativeLayout2 = new RelativeLayout(this.a);
                    relativeLayout2.setBackgroundDrawable(null);
                    AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, p1.a(this.b.getApplicationContext(), 80.0f));
                    new RelativeLayout.LayoutParams(-2, -2);
                    relativeLayout2.setLayoutParams(layoutParams);
                    TextView textView = new TextView(this.a);
                    textView.setId(2031681544);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(p1.a(this.b.getApplicationContext(), 6.0f), p1.a(this.b.getApplicationContext(), 6.0f));
                    layoutParams2.setMargins(p1.a(this.b.getApplicationContext(), 8.0f), p1.a(this.b.getApplicationContext(), 15.0f), 0, 0);
                    layoutParams2.addRule(10);
                    layoutParams2.addRule(9);
                    relativeLayout2.addView(textView, layoutParams2);
                    TextView textView2 = new TextView(this.a);
                    textView2.setId(2031681546);
                    textView2.setTextColor(-13421773);
                    textView2.setLineSpacing(4.0f, 1.0f);
                    textView2.setMaxLines(2);
                    textView2.setEllipsize(TextUtils.TruncateAt.END);
                    textView2.setTextSize(14.0f);
                    textView2.setPadding(0, 0, 0, 0);
                    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams3.setMargins(p1.a(this.b.getApplicationContext(), 24.0f), p1.a(this.b.getApplicationContext(), 8.0f), p1.a(this.b.getApplicationContext(), 60.0f), 0);
                    layoutParams3.addRule(10);
                    layoutParams3.addRule(9);
                    relativeLayout2.addView(textView2, layoutParams3);
                    TextView textView3 = new TextView(this.a);
                    textView3.setTextSize(10.0f);
                    textView3.setTextColor(-6710887);
                    RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams4.setMargins(0, p1.a(this.b.getApplicationContext(), 9.0f), p1.a(this.b.getApplicationContext(), 9.0f), 0);
                    layoutParams4.addRule(10);
                    layoutParams4.addRule(11);
                    relativeLayout2.addView(textView3, layoutParams4);
                    TextView textView4 = new TextView(this.a);
                    textView4.setId(2031681547);
                    textView4.setTextSize(12.0f);
                    textView4.setLines(1);
                    textView4.setGravity(16);
                    textView4.setEllipsize(TextUtils.TruncateAt.END);
                    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
                    textView4.setTextColor(-6710887);
                    textView4.setPadding(0, 0, 0, 0);
                    layoutParams5.addRule(9);
                    layoutParams5.addRule(3, textView2.getId());
                    layoutParams5.setMargins(p1.a(this.b.getApplicationContext(), 24.0f), p1.a(this.b.getApplicationContext(), 1.0f), p1.a(this.b.getApplicationContext(), 60.0f), p1.a(this.b.getApplicationContext(), 8.0f));
                    relativeLayout2.addView(textView4, layoutParams5);
                    relativeLayout2.setBackgroundDrawable(p1.a(this.b.getApplicationContext(), -1, "ufo_list_press.png"));
                    iVar.a = textView2;
                    iVar.b = textView;
                    iVar.c = textView3;
                    iVar.d = textView4;
                    relativeLayout2.setTag(iVar);
                    relativeLayout = relativeLayout2;
                } else {
                    iVar = (i) view2.getTag();
                    relativeLayout = view2;
                }
                iVar.a.setText((String) this.b.e.get(i).get("content"));
                TextView textView5 = iVar.c;
                StringBuilder sb = new StringBuilder();
                sb.append("");
                String str = (String) this.b.e.get(i).get("time");
                StringBuffer stringBuffer = new StringBuffer();
                try {
                    String format = new SimpleDateFormat("HH:mm").format(Long.valueOf(Long.parseLong(str)));
                    long currentTimeMillis = System.currentTimeMillis() - Long.parseLong(str);
                    long ceil = (long) Math.ceil(((float) (currentTimeMillis / 60)) / 1000.0f);
                    iVar2 = iVar;
                    try {
                        long ceil2 = (long) Math.ceil(((float) ((currentTimeMillis / 60) / 60)) / 1000.0f);
                        long ceil3 = (long) Math.ceil(((float) (((currentTimeMillis / 24) / 60) / 60)) / 1000.0f);
                        long j = ceil3 - 1;
                        if (j > 0) {
                            int i3 = (ceil3 > 30L ? 1 : (ceil3 == 30L ? 0 : -1));
                            if (i3 < 0) {
                                stringBuffer.append(j + t1.a("2"));
                            } else {
                                if (i3 < 0 && ceil3 >= 300) {
                                    if (i2 >= 0) {
                                        stringBuffer.append("N" + t1.a("2"));
                                    }
                                }
                                stringBuffer.append((ceil3 / 30) + t1.a("15"));
                            }
                        } else if (ceil2 > 1) {
                            int i4 = (ceil2 > 5L ? 1 : (ceil2 == 5L ? 0 : -1));
                            if (i4 < 0) {
                                stringBuffer.append((ceil2 - 1) + t1.a("9"));
                            } else if (i4 >= 0) {
                                stringBuffer.append(format);
                            }
                        } else if (ceil >= 0) {
                            if (ceil > 3) {
                                stringBuffer.append(ceil + t1.a("14"));
                            } else {
                                stringBuffer.append(t1.a("11"));
                            }
                        }
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    iVar2 = iVar;
                }
                sb.append(stringBuffer.toString());
                textView5.setText(sb.toString());
                if (this.b.e.get(i).get("replied").equals("1")) {
                    iVar3 = iVar2;
                    iVar3.d.setText("[已回复] " + this.b.e.get(i).get("lastmsg"));
                } else {
                    iVar3 = iVar2;
                    if (this.b.e.get(i).get("replied").equals("0")) {
                        iVar3.d.setText("[待回复] " + this.b.e.get(i).get("lastmsg"));
                    } else if (this.b.e.get(i).get("replied").equals("2")) {
                        iVar3.d.setText("[邀请评价] " + this.b.e.get(i).get("lastmsg"));
                    } else if (this.b.e.get(i).get("replied").equals("3")) {
                        iVar3.d.setText("[已评价] " + this.b.e.get(i).get("lastmsg"));
                    }
                }
                if (!this.b.e.get(i).get("newmsg").equals("0")) {
                    TextView textView6 = iVar3.b;
                    int a = p1.a(this.b.getApplicationContext(), 20.0f);
                    Bitmap createBitmap = Bitmap.createBitmap(a, a, Bitmap.Config.ARGB_4444);
                    Canvas canvas = new Canvas(createBitmap);
                    canvas.drawColor(-1);
                    Paint paint = new Paint();
                    paint.setColor(-1551537);
                    float f = a / 2;
                    canvas.drawCircle(f, f, f, paint);
                    textView6.setBackgroundDrawable(new BitmapDrawable(createBitmap));
                } else {
                    iVar3.b.setBackgroundDrawable(null);
                }
                return relativeLayout;
            }
            return (View) invokeILL.objValue;
        }
    }

    public FeedbackListActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = -1;
        this.p = null;
        this.q = null;
        this.t = false;
        this.v = new a(this);
        this.w = new b(this);
    }

    @Override // android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onStart();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.ufosdk.gethistorylist");
            intentFilter.addAction("com.baidu.ufosdk.getnewhistoryflag");
            intentFilter.addAction("com.baidu.ufosdk.deletemsg_dialogdismiss");
            intentFilter.addAction("com.baidu.ufosdk.reload");
            intentFilter.addAction("com.baidu.ufosdk.fail");
            registerReceiver(this.w, intentFilter);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, keyEvent)) == null) {
            if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1) {
                setResult(0);
                finish();
            }
            return super.dispatchKeyEvent(keyEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onBackPressed();
            u1.a(com.baidu.ufosdk.b.i(this).edit().putBoolean("his_dty", true));
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onPause();
            try {
                this.m.setVisibility(8);
                unregisterReceiver(this.w);
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.app.Activity
    public void onRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onRestart();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onStop();
        }
    }

    @Override // android.app.Activity
    @SuppressLint({"NewApi"})
    public void onCreate(Bundle bundle) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            requestWindowFeature(1);
            if (Build.VERSION.SDK_INT >= 21) {
                Window window = getWindow();
                window.addFlags(Integer.MIN_VALUE);
                window.getDecorView().setSystemUiVisibility(1280);
                if (Build.VERSION.SDK_INT >= 23) {
                    window.getDecorView().setSystemUiVisibility(8192);
                }
                window.getDecorView().setBackgroundColor(-1);
                window.setStatusBarColor(0);
            }
            if (com.baidu.ufosdk.b.m() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.t = z;
            this.u = e0.a(this);
            if (this.t) {
                if (this.s) {
                    return;
                }
                this.r = new WindowManager.LayoutParams(2, 24, -2);
                this.p = getWindowManager();
                View view2 = new View(this);
                this.q = view2;
                view2.setBackgroundColor(-16777216);
                this.q.setAlpha(0.5f);
                this.p.addView(this.q, this.r);
                this.s = true;
            }
            getIntent().getBooleanExtra("backPress", false);
            this.n = Executors.newSingleThreadExecutor();
            this.f = p1.a(getApplicationContext(), 10.0f);
            this.e = new ArrayList();
            RelativeLayout relativeLayout = new RelativeLayout(this);
            this.a = relativeLayout;
            relativeLayout.setId(2031681540);
            this.a.setBackgroundColor(-1);
            RelativeLayout relativeLayout2 = new RelativeLayout(this);
            relativeLayout2.setId(2031681541);
            relativeLayout2.setBackgroundColor(-1);
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setId(2031681539);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(16);
            LinearLayout linearLayout2 = new LinearLayout(this);
            linearLayout2.setGravity(16);
            linearLayout2.setOrientation(0);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(p1.a(getApplicationContext(), 19.0f), p1.a(getApplicationContext(), 19.0f));
            layoutParams.setMargins(p1.a(getApplicationContext(), 10.0f), 0, p1.a(getApplicationContext(), 10.0f), 0);
            ImageView imageView = new ImageView(this);
            this.h = imageView;
            imageView.setId(2031681537);
            this.h.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.h.setBackgroundDrawable(new BitmapDrawable(p1.b(getApplicationContext(), "ufo_back_icon_browser.png")));
            linearLayout2.addView(this.h, layoutParams);
            if (com.baidu.ufosdk.b.e() == 0) {
                layoutParams = new LinearLayout.LayoutParams(p1.a(getApplicationContext(), 35.0f), -1);
                layoutParams.setMargins(p1.a(getApplicationContext(), 10.0f), 0, 0, 0);
                linearLayout.addView(linearLayout2, layoutParams);
            }
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, p1.a(getApplicationContext(), 42.0f));
            layoutParams2.addRule(12);
            this.a.addView(linearLayout, layoutParams2);
            View view3 = new View(this);
            view3.setId(2031681550);
            view3.setBackgroundColor(-1644826);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, p1.a(getApplicationContext(), 0.5f));
            layoutParams3.addRule(2, linearLayout.getId());
            this.a.addView(view3, layoutParams3);
            LinearLayout linearLayout3 = new LinearLayout(this);
            linearLayout3.setId(2031681542);
            LinearLayout linearLayout4 = new LinearLayout(this);
            this.c = linearLayout4;
            linearLayout4.setId(2031681543);
            TextView textView = new TextView(this);
            textView.setId(2031681538);
            textView.setText(t1.a("17"));
            textView.setTextSize(16.0f);
            textView.setTypeface(Typeface.defaultFromStyle(1));
            textView.setGravity(17);
            textView.setTextColor(-16777216);
            textView.setBackgroundDrawable(null);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams4.addRule(13);
            relativeLayout2.addView(textView, layoutParams4);
            if (com.baidu.ufosdk.b.e() == 1) {
                RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -1);
                layoutParams5.addRule(9);
                layoutParams5.addRule(15);
                layoutParams.setMargins(p1.a(getApplicationContext(), 10.0f), 0, 0, 0);
                relativeLayout2.addView(linearLayout2, layoutParams5);
                view3.setVisibility(8);
                linearLayout.setVisibility(8);
            }
            new LinearLayout.LayoutParams(-2, -2).setMargins(0, 0, this.f, 0);
            linearLayout3.setOrientation(1);
            linearLayout3.setBackgroundColor(-1);
            View view4 = new View(this);
            view4.setId(2031681549);
            view4.setBackgroundColor(-1644826);
            RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, 1);
            layoutParams6.addRule(3, relativeLayout2.getId());
            this.a.addView(view4, layoutParams6);
            ListView listView = new ListView(this);
            this.j = listView;
            listView.setId(2031681548);
            this.j.setSelector(new ColorDrawable(0));
            this.j.setCacheColorHint(-1);
            this.j.setDivider(new ColorDrawable(-3355444));
            this.j.setDividerHeight(1);
            this.j.addFooterView(new ViewStub(this));
            this.c.addView(this.j, new LinearLayout.LayoutParams(-1, -2));
            RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams7.addRule(3, view4.getId());
            layoutParams7.addRule(2, view3.getId());
            this.a.addView(this.c, layoutParams7);
            TextView textView2 = new TextView(this);
            this.i = textView2;
            textView2.setText(t1.a(PayUVEventType.PAY_WALLET_BANNER_SHOW));
            this.i.setTextColor(-10066330);
            this.i.setTextSize(18.0f);
            this.i.setPadding(p1.a(getApplicationContext(), 20.0f), p1.a(getApplicationContext(), 0.0f), p1.a(getApplicationContext(), 20.0f), p1.a(getApplicationContext(), 0.0f));
            RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams8.addRule(13);
            this.a.addView(this.i, layoutParams8);
            this.i.setVisibility(8);
            LinearLayout linearLayout5 = new LinearLayout(this);
            this.b = linearLayout5;
            linearLayout5.setOrientation(1);
            new LinearLayout.LayoutParams(-2, -2);
            ImageView imageView2 = new ImageView(this);
            LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(p1.a(getApplicationContext(), 115.0f), p1.a(getApplicationContext(), 85.0f));
            try {
                imageView2.setBackgroundDrawable(new BitmapDrawable(p1.b(getApplicationContext(), "ufo_no_netwrok.png")));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.b.addView(imageView2, layoutParams9);
            TextView textView3 = new TextView(this);
            this.d = textView3;
            textView3.setTextColor(-16777216);
            this.d.setPadding(p1.a(getApplicationContext(), 10.0f), p1.a(getApplicationContext(), 18.0f), p1.a(getApplicationContext(), 10.0f), p1.a(getApplicationContext(), 11.0f));
            this.d.setTextSize(18.0f);
            LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-2, -2);
            p1.a(getApplicationContext(), this.d);
            this.b.addView(this.d, layoutParams10);
            Button button = new Button(this);
            this.g = button;
            button.setText(t1.a("22"));
            this.g.setTextSize(16.0f);
            this.g.setTextColor(-12814593);
            this.g.setBackgroundResource(R.drawable.obfuscated_res_0x7f0810c6);
            LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(p1.a(getApplicationContext(), 122.0f), p1.a(getApplicationContext(), 40.0f));
            layoutParams11.setMargins(0, p1.a(getApplicationContext(), 15.0f), 0, 0);
            this.b.addView(this.g, layoutParams11);
            RelativeLayout.LayoutParams layoutParams12 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams12.addRule(13);
            this.a.addView(this.b, layoutParams12);
            this.b.setGravity(17);
            this.b.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams13 = new RelativeLayout.LayoutParams(-1, p1.a(getApplicationContext(), 38.0f));
            layoutParams13.addRule(10);
            this.a.addView(relativeLayout2, layoutParams13);
            setContentView(this.a, new ViewGroup.LayoutParams(-1, -1));
            this.l = p1.c(this, t1.a("13"));
            RelativeLayout.LayoutParams layoutParams14 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams14.addRule(13);
            this.a.addView(this.l, layoutParams14);
            this.m = p1.c(this, t1.a("4"));
            RelativeLayout.LayoutParams layoutParams15 = new RelativeLayout.LayoutParams(p1.a(getApplicationContext(), 114.0f), p1.a(getApplicationContext(), 39.0f));
            layoutParams15.addRule(13);
            this.m.setVisibility(8);
            this.a.addView(this.m, layoutParams15);
            this.h.setOnClickListener(new c(this));
            this.g.setOnClickListener(new d(this));
            j jVar = new j(this, this);
            this.k = jVar;
            this.j.setAdapter((ListAdapter) jVar);
            this.j.setFocusable(false);
            this.j.setCacheColorHint(-1);
            this.j.setDividerHeight(1);
            this.j.setRecyclerListener(new e(this));
            this.j.setOnItemClickListener(new f(this));
            this.j.setOnItemLongClickListener(new g(this));
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onResume();
            this.i.setText(t1.a(PayUVEventType.PAY_WALLET_BANNER_SHOW));
            ((TextView) findViewById(2031681538)).setText(t1.a("17"));
            this.g.setText(t1.a("22"));
            p1.a((RelativeLayout) this.l, t1.a("13"));
            p1.a((RelativeLayout) this.m, t1.a("4"));
            int i2 = 0;
            while (true) {
                if (i2 >= this.e.size()) {
                    break;
                } else if (!this.e.get(i2).get("newmsg").equals("0")) {
                    this.v.obtainMessage(2, Integer.valueOf(i2)).sendToTarget();
                    break;
                } else {
                    i2++;
                }
            }
            if (this.u.a.length() == 0) {
                this.u.a(false);
                return;
            }
            this.n.execute(new h(this, getApplicationContext()));
        }
    }
}
