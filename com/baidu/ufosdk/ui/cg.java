package com.baidu.ufosdk.ui;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.spswitch.utils.BDEmotionPanelManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public final class cg extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f23661a;

    /* renamed from: b  reason: collision with root package name */
    public Context f23662b;

    public cg(FeedbackInputActivity feedbackInputActivity, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {feedbackInputActivity, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23661a = feedbackInputActivity;
        this.f23662b = context;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f23661a.f23565h.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:3|(2:5|(1:438)(1:7))(3:439|(2:441|(2:450|(1:452))(1:443))|453)|8|(10:351|(7:353|354|355|356|357|358|359)(2:367|(7:369|370|371|372|373|374|375)(9:384|(7:386|387|388|389|390|391|392)(2:401|(9:403|404|405|406|407|408|409|(1:411)(1:413)|412)(2:420|(7:422|423|424|425|426|427|428)(2:435|349)))|15|16|17|18|(2:20|(1:22)(1:331))(1:332)|23|(8:25|(1:27)(7:57|(2:62|(1:66))(1:61)|29|30|31|(2:33|(2:35|(3:37|38|39)(3:40|41|39)))(2:44|(4:48|(1:50)(1:53)|51|52))|42)|28|29|30|31|(0)(0)|42)(3:67|(6:69|(1:71)(5:79|(2:84|(1:88))(1:83)|73|74|75)|72|73|74|75)(2:89|(15:91|(1:93)(12:240|(2:245|(1:249))(1:244)|(2:235|236)|96|(3:98|(2:182|(1:184))(3:102|(3:155|(6:157|(1:159)(1:168)|160|(1:162)(1:167)|163|(1:165))(2:169|(6:171|(1:173)(1:181)|174|(1:176)(1:180)|177|(1:179)))|166)(10:106|(2:109|107)|110|111|(2:114|112)|115|116|(5:118|(1:120)|121|(2:124|122)|125)|126|(8:128|(1:130)|131|132|133|(4:136|(2:138|139)(1:141)|140|134)|142|143)(2:150|(1:152)))|153)|154)|185|186|(1:188)(3:211|(1:213)(3:215|(1:217)(2:219|(1:221)(3:222|(3:224|(1:226)(1:229)|227)(2:230|(1:232))|228))|218)|214)|189|(2:197|(5:199|(1:201)(1:210)|202|(1:209)(1:207)|208))|193|(1:195)(1:196))|94|(0)|96|(0)|185|186|(0)(0)|189|(1:191)|197|(0)|193|(0)(0))(2:250|(8:252|(1:254)(5:283|(2:288|(1:292))(1:287)|(2:278|279)|257|(2:272|(2:274|(3:276|38|39)(3:277|41|39)))(2:263|(4:267|(1:269)(1:271)|270|52)))|255|(0)|257|(1:259)|272|(0))(2:293|(7:295|(1:297)(6:321|(2:326|(1:330))(1:325)|(2:316|317)|300|(1:302)(7:304|305|306|(1:308)|309|(1:311)(1:313)|312)|303)|298|(0)|300|(0)(0)|303))))|42)))|360|15|16|17|18|(0)(0)|23|(0)(0))(9:(1:13)(1:(1:339)(1:(1:341)(2:342|(1:344)(2:345|(1:347)(2:348|349)))))|14|15|16|17|18|(0)(0)|23|(0)(0))|350|15|16|17|18|(0)(0)|23|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(15:91|(1:93)(12:240|(2:245|(1:249))(1:244)|(2:235|236)|96|(3:98|(2:182|(1:184))(3:102|(3:155|(6:157|(1:159)(1:168)|160|(1:162)(1:167)|163|(1:165))(2:169|(6:171|(1:173)(1:181)|174|(1:176)(1:180)|177|(1:179)))|166)(10:106|(2:109|107)|110|111|(2:114|112)|115|116|(5:118|(1:120)|121|(2:124|122)|125)|126|(8:128|(1:130)|131|132|133|(4:136|(2:138|139)(1:141)|140|134)|142|143)(2:150|(1:152)))|153)|154)|185|186|(1:188)(3:211|(1:213)(3:215|(1:217)(2:219|(1:221)(3:222|(3:224|(1:226)(1:229)|227)(2:230|(1:232))|228))|218)|214)|189|(2:197|(5:199|(1:201)(1:210)|202|(1:209)(1:207)|208))|193|(1:195)(1:196))|94|(0)|96|(0)|185|186|(0)(0)|189|(1:191)|197|(0)|193|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(6:69|(1:71)(5:79|(2:84|(1:88))(1:83)|73|74|75)|72|73|74|75) */
    /* JADX WARN: Can't wrap try/catch for region: R(8:25|(1:27)(7:57|(2:62|(1:66))(1:61)|29|30|31|(2:33|(2:35|(3:37|38|39)(3:40|41|39)))(2:44|(4:48|(1:50)(1:53)|51|52))|42)|28|29|30|31|(0)(0)|42) */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0ff5, code lost:
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0ff6, code lost:
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x10af, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x10b0, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x1275, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x1276, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:308:0x1647, code lost:
        r0 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0ff9  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x100d  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x1019  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x10cd  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x1158  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x11d5  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x132a  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x164a  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x1663  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x17b0  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x187c  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x1892  */
    /* JADX WARN: Removed duplicated region for block: B:395:0x1a40  */
    /* JADX WARN: Removed duplicated region for block: B:423:0x1b57  */
    /* JADX WARN: Removed duplicated region for block: B:450:0x1b00 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:464:0x1931 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:470:0x1b67 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:476:0x1317 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        int i3;
        Object obj;
        Object obj2;
        da daVar;
        int i4;
        dc dcVar;
        dd ddVar;
        cz czVar;
        db dbVar;
        da daVar2;
        int i5;
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        RelativeLayout relativeLayout3;
        PackageManager packageManager;
        Bitmap bitmap;
        TextView textView;
        String a2;
        String str;
        TextView textView2;
        String a3;
        Handler handler;
        Bitmap a4;
        ImageView imageView;
        Bitmap bitmap2;
        ImageView imageView2;
        Context applicationContext;
        float f2;
        ImageView imageView3;
        TextView textView3;
        String a5;
        int i6;
        ImageView imageView4;
        BitmapDrawable bitmapDrawable;
        int i7;
        int i8;
        TextView textView4;
        Context applicationContext2;
        String str2;
        String str3;
        int i9;
        Drawable a6;
        TextView textView5;
        String str4;
        Handler handler2;
        TextView textView6;
        eq eqVar;
        ArrayList arrayList;
        FeedbackInputActivity feedbackInputActivity;
        ArrayList arrayList2;
        ArrayList arrayList3;
        eq eqVar2;
        ArrayList arrayList4;
        eq eqVar3;
        TextView textView7;
        String a7;
        Context applicationContext3;
        float f3;
        TextView textView8;
        String a8;
        Object obj3;
        ImageView imageView5;
        Context applicationContext4;
        float f4;
        Handler handler3;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeILL = interceptable.invokeILL(1048579, this, i2, view, viewGroup)) != null) {
            return (View) invokeILL.objValue;
        }
        if (((Integer) ((Map) this.f23661a.f23565h.get(i2)).get("from")).equals(0)) {
            i3 = (((String) ((Map) this.f23661a.f23565h.get(i2)).get("contenttype")).contentEquals("1") || ((String) ((Map) this.f23661a.f23565h.get(i2)).get("contenttype")).contentEquals("2")) ? 1 : 2;
        } else {
            if (((Integer) ((Map) this.f23661a.f23565h.get(i2)).get("from")).equals(1)) {
                if (((String) ((Map) this.f23661a.f23565h.get(i2)).get("contenttype")).contentEquals("1") || ((String) ((Map) this.f23661a.f23565h.get(i2)).get("contenttype")).contentEquals("2") || ((Map) this.f23661a.f23565h.get(i2)).get("content").toString().startsWith("http://bs.baidu.com") || ((Map) this.f23661a.f23565h.get(i2)).get("content").toString().startsWith("https://bs.baidu.com")) {
                    i3 = 4;
                } else if (((String) ((Map) this.f23661a.f23565h.get(i2)).get("contenttype")).contentEquals("-1")) {
                    i3 = 5;
                }
            }
            i3 = 3;
        }
        cz czVar2 = new cz();
        db dbVar2 = new db();
        da daVar3 = new da();
        dc dcVar2 = new dc();
        dd ddVar2 = new dd();
        if (view == null || ((Integer) view.getTag(R.style.AdNoTitleDialog)).intValue() != i3) {
            if (i3 == 1) {
                RelativeLayout relativeLayout4 = new RelativeLayout(this.f23662b);
                RelativeLayout relativeLayout5 = new RelativeLayout(this.f23662b);
                RelativeLayout relativeLayout6 = new RelativeLayout(this.f23662b);
                relativeLayout4.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                relativeLayout4.setBackgroundColor(com.baidu.ufosdk.b.z);
                relativeLayout5.setBackgroundColor(com.baidu.ufosdk.b.z);
                relativeLayout6.setBackgroundColor(com.baidu.ufosdk.b.z);
                relativeLayout6.setId(R.id.Backward);
                relativeLayout6.setClickable(false);
                TextView textView9 = new TextView(this.f23661a);
                try {
                    textView9.setBackgroundDrawable(com.baidu.ufosdk.f.o.a(this.f23661a.getApplicationContext(), "ufo_date_bg.9.png"));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                textView9.setTextColor(-1);
                textView9.setTextSize(com.baidu.ufosdk.b.Q);
                textView9.setGravity(17);
                textView9.setMovementMethod(LinkMovementMethod.getInstance());
                obj2 = "content";
                obj = "contenttype";
                textView9.setPadding(com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 10.0f), com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 2.0f) + 2, com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 10.0f), com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 2.0f));
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.setMargins(0, com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 10.0f), 0, 0);
                layoutParams.addRule(14);
                relativeLayout6.addView(textView9, layoutParams);
                ViewGroup.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                relativeLayout6.setPadding(0, com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 6.0f), 0, com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 8.0f));
                relativeLayout4.addView(relativeLayout6, layoutParams2);
                dcVar2.f23709a = textView9;
                dcVar2.f23712d = relativeLayout6;
                ImageView imageView6 = new ImageView(this.f23661a);
                imageView6.setId(R.id.BOTTOM_END);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 40.0f), com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 40.0f));
                layoutParams3.addRule(11);
                layoutParams3.setMargins(com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 6.0f), 0, com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 8.0f), 0);
                relativeLayout5.addView(imageView6, layoutParams3);
                dcVar2.f23710b = imageView6;
                RelativeLayout relativeLayout7 = new RelativeLayout(this.f23661a);
                try {
                    relativeLayout7.setBackgroundDrawable(com.baidu.ufosdk.f.o.a(this.f23661a.getApplicationContext(), "ufo_me_send_bg.9.png"));
                    relativeLayout7.setPadding(com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 1.0f), com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 1.0f), 11, com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 1.0f));
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                ImageView imageView7 = new ImageView(this.f23661a);
                imageView7.setOnClickListener(new ch(this));
                imageView7.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView7.setAdjustViewBounds(true);
                RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams4.setMargins(0, 0, 0, 0);
                relativeLayout7.addView(imageView7, layoutParams4);
                RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
                daVar = daVar3;
                layoutParams5.setMargins(com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 55.0f), 0, 0, 0);
                layoutParams5.addRule(0, imageView6.getId());
                relativeLayout5.addView(relativeLayout7, layoutParams5);
                dcVar2.f23711c = imageView7;
                relativeLayout5.setPadding(0, 0, 0, com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 20.0f));
                RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams6.addRule(3, relativeLayout6.getId());
                relativeLayout4.addView(relativeLayout5, layoutParams6);
                relativeLayout4.setOnClickListener(new cq(this));
                relativeLayout4.setTag(R.style.AiappsGameGuideDialogStyle, dcVar2);
                relativeLayout4.setTag(R.style.AdNoTitleDialog, Integer.valueOf(i3));
                i4 = i3;
                relativeLayout = relativeLayout4;
            } else {
                obj = "contenttype";
                obj2 = "content";
                daVar = daVar3;
                if (i3 != 2) {
                    if (i3 == 3) {
                        RelativeLayout relativeLayout8 = new RelativeLayout(this.f23662b);
                        RelativeLayout relativeLayout9 = new RelativeLayout(this.f23662b);
                        RelativeLayout relativeLayout10 = new RelativeLayout(this.f23662b);
                        ViewGroup.LayoutParams layoutParams7 = new AbsListView.LayoutParams(-1, -2);
                        relativeLayout8.setBackgroundColor(com.baidu.ufosdk.b.z);
                        relativeLayout9.setBackgroundColor(com.baidu.ufosdk.b.z);
                        relativeLayout10.setBackgroundColor(com.baidu.ufosdk.b.z);
                        relativeLayout8.setLayoutParams(layoutParams7);
                        relativeLayout10.setId(R.id.Backward);
                        relativeLayout10.setClickable(false);
                        TextView textView10 = new TextView(this.f23661a);
                        try {
                            textView10.setBackgroundDrawable(com.baidu.ufosdk.f.o.a(this.f23661a.getApplicationContext(), "ufo_date_bg.9.png"));
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                        textView10.setTextColor(-1);
                        textView10.setTextSize(com.baidu.ufosdk.b.Q);
                        textView10.setGravity(17);
                        textView10.setMovementMethod(LinkMovementMethod.getInstance());
                        textView10.setPadding(com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 10.0f), com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 2.0f) + 2, com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 10.0f), com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 2.0f));
                        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams8.setMargins(0, com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 10.0f), 0, 0);
                        layoutParams8.addRule(14);
                        relativeLayout10.addView(textView10, layoutParams8);
                        ViewGroup.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-1, -2);
                        relativeLayout10.setPadding(0, com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 6.0f), 0, com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 8.0f));
                        relativeLayout8.addView(relativeLayout10, layoutParams9);
                        dbVar2.f23700a = textView10;
                        dbVar2.f23703d = relativeLayout10;
                        ImageView imageView8 = new ImageView(this.f23661a);
                        imageView8.setId(R.id.BOTTOM_END);
                        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 40.0f), com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 40.0f));
                        layoutParams10.setMargins(com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 8.0f), 0, com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 4.0f), 0);
                        layoutParams10.addRule(9);
                        relativeLayout9.addView(imageView8, layoutParams10);
                        dbVar2.f23701b = imageView8;
                        LinearLayout linearLayout = new LinearLayout(this.f23662b);
                        linearLayout.setOrientation(1);
                        linearLayout.setId(2131755016);
                        try {
                            linearLayout.setBackgroundDrawable(com.baidu.ufosdk.f.o.a(this.f23661a.getApplicationContext(), "ufo_server_send_bg.9.png"));
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                        TextView textView11 = new TextView(this.f23661a);
                        textView11.setId(2131755015);
                        textView11.setPadding(com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 15.0f), com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 8.0f), com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 8.0f), com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 8.0f));
                        textView11.setGravity(16);
                        textView11.setLineSpacing(5.0f, 1.0f);
                        textView11.setTextColor(-13421773);
                        textView11.setTextSize(com.baidu.ufosdk.b.R);
                        textView11.setAutoLinkMask(1);
                        textView11.setMovementMethod(LinkMovementMethod.getInstance());
                        textView11.setOnLongClickListener(new ct(this));
                        dbVar2.f23702c = textView11;
                        linearLayout.addView(textView11, new LinearLayout.LayoutParams(-2, -2));
                        RelativeLayout relativeLayout11 = new RelativeLayout(this.f23662b);
                        relativeLayout11.setVisibility(8);
                        relativeLayout11.setBackgroundColor(-1);
                        LinearLayout linearLayout2 = new LinearLayout(this.f23662b);
                        linearLayout2.setBackgroundColor(-1);
                        linearLayout2.setOrientation(0);
                        TextView textView12 = new TextView(this.f23662b);
                        textView12.setText("满意");
                        textView12.setTextColor(-12814593);
                        textView12.setTextSize(15.0f);
                        textView12.setGravity(17);
                        BitmapDrawable bitmapDrawable2 = new BitmapDrawable(com.baidu.ufosdk.f.m.a(this.f23661a.getApplicationContext(), "ufo_solved.png"));
                        bitmapDrawable2.setBounds(com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 20.0f), 0, com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 40.0f), com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 20.0f));
                        textView12.setCompoundDrawables(bitmapDrawable2, null, null, null);
                        textView12.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(this.f23661a.getApplicationContext(), "ufo_bottom_button.9.png", "ufo_bottom_button_pressed.9.png"));
                        LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 35.0f));
                        layoutParams11.setMargins(0, 0, com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 5.0f), 0);
                        layoutParams11.weight = 1.0f;
                        linearLayout2.addView(textView12, layoutParams11);
                        TextView textView13 = new TextView(this.f23662b);
                        textView13.setText("不满意");
                        textView13.setTextColor(SupportMenu.CATEGORY_MASK);
                        textView13.setTextSize(15.0f);
                        textView13.setGravity(17);
                        BitmapDrawable bitmapDrawable3 = new BitmapDrawable(com.baidu.ufosdk.f.m.a(this.f23661a.getApplicationContext(), "ufo_not_solved.png"));
                        int i10 = i3;
                        bitmapDrawable3.setBounds(com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 13.0f), 0, com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 33.0f), com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 20.0f));
                        textView13.setCompoundDrawables(bitmapDrawable3, null, null, null);
                        textView13.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(this.f23661a.getApplicationContext(), "ufo_bottom_button.9.png", "ufo_bottom_button_pressed.9.png"));
                        LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 35.0f));
                        layoutParams12.setMargins(com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 5.0f), 0, 0, 0);
                        layoutParams12.weight = 1.0f;
                        linearLayout2.addView(textView13, layoutParams12);
                        relativeLayout11.addView(linearLayout2, new RelativeLayout.LayoutParams(-1, -1));
                        dbVar2.f23704e = relativeLayout11;
                        dbVar2.f23705f = textView12;
                        dbVar2.f23706g = textView13;
                        i iVar = new i(this.f23661a);
                        iVar.setVisibility(8);
                        dbVar2.f23707h = iVar;
                        ImageView imageView9 = new ImageView(this.f23661a);
                        imageView9.setId(R.id.SELECT);
                        imageView9.setVisibility(8);
                        dbVar2.f23708i = imageView9;
                        LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams13.setMargins(com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 16.0f), com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 3.0f), com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 16.0f), com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 13.0f));
                        linearLayout.addView(relativeLayout11, layoutParams13);
                        LinearLayout.LayoutParams layoutParams14 = new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 0.5f));
                        layoutParams14.setMargins(com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 16.0f), com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 3.0f), com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 16.0f), com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 3.0f));
                        linearLayout.addView(iVar, layoutParams14);
                        LinearLayout.LayoutParams layoutParams15 = new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 20.0f), com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 20.0f));
                        layoutParams15.setMargins(com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 16.0f), com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 3.0f), com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 16.0f), com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 13.0f));
                        linearLayout.addView(imageView9, layoutParams15);
                        RelativeLayout.LayoutParams layoutParams16 = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams16.setMargins(0, 0, com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 57.0f), 0);
                        layoutParams16.addRule(1, imageView8.getId());
                        relativeLayout9.addView(linearLayout, layoutParams16);
                        TextView textView14 = new TextView(this.f23662b);
                        textView14.setVisibility(8);
                        textView14.setText("填写不满意原因");
                        textView14.setTextSize(15.0f);
                        textView14.setTextColor(com.baidu.ufosdk.f.i.a(-12814593, -15644211, -12814593, -12814593));
                        Drawable a9 = com.baidu.ufosdk.f.i.a(this.f23662b, com.baidu.ufosdk.R.drawable.ufo_show_reason_normal);
                        a9.setBounds(com.baidu.ufosdk.f.i.a(this.f23662b, 1.0f), com.baidu.ufosdk.f.i.a(this.f23662b, 1.0f), com.baidu.ufosdk.f.i.a(this.f23662b, 14.0f), com.baidu.ufosdk.f.i.a(this.f23662b, 14.0f));
                        textView14.setCompoundDrawables(null, null, a9, null);
                        RelativeLayout.LayoutParams layoutParams17 = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams17.addRule(3, linearLayout.getId());
                        layoutParams17.addRule(1, imageView8.getId());
                        layoutParams17.setMargins(com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 3.0f), com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 8.0f), com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 16.0f), com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 13.0f));
                        relativeLayout9.addView(textView14, layoutParams17);
                        dbVar2.j = textView14;
                        relativeLayout9.setPadding(0, 0, 0, com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 10.0f));
                        RelativeLayout.LayoutParams layoutParams18 = new RelativeLayout.LayoutParams(-1, -2);
                        layoutParams18.addRule(3, relativeLayout10.getId());
                        relativeLayout8.addView(relativeLayout9, layoutParams18);
                        relativeLayout8.setOnClickListener(new cu(this));
                        relativeLayout8.setTag(R.style.AiappsGameGuideDialogStyle, dbVar2);
                        relativeLayout8.setTag(R.style.AdNoTitleDialog, Integer.valueOf(i10));
                        daVar3 = daVar;
                        dcVar2 = dcVar2;
                        ddVar2 = ddVar2;
                        czVar2 = czVar2;
                        i4 = i10;
                        relativeLayout3 = relativeLayout8;
                    } else {
                        i4 = i3;
                        dcVar = dcVar2;
                        ddVar = ddVar2;
                        if (i4 == 4) {
                            RelativeLayout relativeLayout12 = new RelativeLayout(this.f23662b);
                            RelativeLayout relativeLayout13 = new RelativeLayout(this.f23662b);
                            RelativeLayout relativeLayout14 = new RelativeLayout(this.f23662b);
                            ViewGroup.LayoutParams layoutParams19 = new AbsListView.LayoutParams(-1, -2);
                            relativeLayout12.setBackgroundColor(com.baidu.ufosdk.b.z);
                            relativeLayout13.setBackgroundColor(com.baidu.ufosdk.b.z);
                            relativeLayout14.setBackgroundColor(com.baidu.ufosdk.b.z);
                            relativeLayout12.setLayoutParams(layoutParams19);
                            relativeLayout14.setId(R.id.Backward);
                            relativeLayout14.setClickable(false);
                            TextView textView15 = new TextView(this.f23661a);
                            try {
                                textView15.setBackgroundDrawable(com.baidu.ufosdk.f.o.a(this.f23661a.getApplicationContext(), "ufo_date_bg.9.png"));
                            } catch (Exception e7) {
                                e7.printStackTrace();
                            }
                            textView15.setTextColor(-1);
                            textView15.setTextSize(com.baidu.ufosdk.b.Q);
                            textView15.setGravity(17);
                            textView15.setMovementMethod(LinkMovementMethod.getInstance());
                            textView15.setPadding(com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 10.0f), com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 2.0f) + 2, com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 10.0f), com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 2.0f));
                            RelativeLayout.LayoutParams layoutParams20 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams20.setMargins(0, com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 10.0f), 0, 0);
                            layoutParams20.addRule(14);
                            relativeLayout14.addView(textView15, layoutParams20);
                            ViewGroup.LayoutParams layoutParams21 = new RelativeLayout.LayoutParams(-1, -2);
                            relativeLayout14.setPadding(0, com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 6.0f), 0, com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 8.0f));
                            relativeLayout12.addView(relativeLayout14, layoutParams21);
                            czVar2.f23689a = textView15;
                            czVar2.f23692d = relativeLayout14;
                            ImageView imageView10 = new ImageView(this.f23661a);
                            imageView10.setId(R.id.BOTTOM_END);
                            RelativeLayout.LayoutParams layoutParams22 = new RelativeLayout.LayoutParams(com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 40.0f), com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 40.0f));
                            layoutParams22.setMargins(com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 8.0f), 0, com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 4.0f), 0);
                            layoutParams22.addRule(9);
                            relativeLayout13.addView(imageView10, layoutParams22);
                            czVar2.f23690b = imageView10;
                            RelativeLayout relativeLayout15 = new RelativeLayout(this.f23661a);
                            try {
                                relativeLayout15.setBackgroundDrawable(com.baidu.ufosdk.f.o.a(this.f23661a.getApplicationContext(), "ufo_server_send_bg.9.png"));
                                relativeLayout15.setPadding(11, com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 1.2f), com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 1.0f), com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 1.0f));
                            } catch (Exception e8) {
                                e8.printStackTrace();
                            }
                            ImageView imageView11 = new ImageView(this.f23661a);
                            imageView11.setOnClickListener(new cv(this));
                            imageView11.setScaleType(ImageView.ScaleType.FIT_XY);
                            if (com.baidu.ufosdk.f.i.a() < 23) {
                                imageView11.setAdjustViewBounds(true);
                                RelativeLayout.LayoutParams layoutParams23 = new RelativeLayout.LayoutParams(-2, -2);
                                layoutParams23.setMargins(0, 0, 0, 0);
                                relativeLayout15.addView(imageView11, layoutParams23);
                                i5 = 0;
                            } else {
                                RelativeLayout.LayoutParams layoutParams24 = new RelativeLayout.LayoutParams(com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 80.0f), com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 120.0f));
                                i5 = 0;
                                layoutParams24.setMargins(0, 0, 0, 0);
                                relativeLayout15.addView(imageView11, layoutParams24);
                            }
                            RelativeLayout.LayoutParams layoutParams25 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams25.setMargins(i5, i5, com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 57.0f), i5);
                            layoutParams25.addRule(1, imageView10.getId());
                            relativeLayout13.addView(relativeLayout15, layoutParams25);
                            czVar2.f23691c = imageView11;
                            relativeLayout13.setPadding(i5, i5, i5, com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 10.0f));
                            RelativeLayout.LayoutParams layoutParams26 = new RelativeLayout.LayoutParams(-1, -2);
                            layoutParams26.addRule(3, relativeLayout14.getId());
                            relativeLayout12.addView(relativeLayout13, layoutParams26);
                            relativeLayout12.setOnClickListener(new cw(this));
                            relativeLayout12.setTag(R.style.AiappsGameGuideDialogStyle, czVar2);
                            relativeLayout12.setTag(R.style.AdNoTitleDialog, Integer.valueOf(i4));
                            czVar2 = czVar2;
                            daVar3 = daVar;
                            dcVar2 = dcVar;
                            ddVar2 = ddVar;
                            relativeLayout3 = relativeLayout12;
                        } else if (i4 == 5) {
                            RelativeLayout relativeLayout16 = new RelativeLayout(this.f23662b);
                            RelativeLayout relativeLayout17 = new RelativeLayout(this.f23662b);
                            RelativeLayout relativeLayout18 = new RelativeLayout(this.f23662b);
                            ViewGroup.LayoutParams layoutParams27 = new AbsListView.LayoutParams(-1, -2);
                            relativeLayout16.setBackgroundColor(com.baidu.ufosdk.b.z);
                            relativeLayout17.setBackgroundColor(com.baidu.ufosdk.b.z);
                            relativeLayout18.setBackgroundColor(com.baidu.ufosdk.b.z);
                            relativeLayout16.setLayoutParams(layoutParams27);
                            relativeLayout18.setId(R.id.Backward);
                            relativeLayout18.setClickable(false);
                            TextView textView16 = new TextView(this.f23661a);
                            try {
                                textView16.setBackgroundDrawable(com.baidu.ufosdk.f.o.a(this.f23661a.getApplicationContext(), "ufo_date_bg.9.png"));
                            } catch (Exception e9) {
                                e9.printStackTrace();
                            }
                            textView16.setTextColor(-1);
                            textView16.setTextSize(com.baidu.ufosdk.b.Q);
                            textView16.setGravity(17);
                            textView16.setMovementMethod(LinkMovementMethod.getInstance());
                            textView16.setPadding(com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 10.0f), com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 2.0f) + 2, com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 10.0f), com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 2.0f));
                            RelativeLayout.LayoutParams layoutParams28 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams28.setMargins(0, com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 10.0f), 0, 0);
                            layoutParams28.addRule(14);
                            relativeLayout18.addView(textView16, layoutParams28);
                            ViewGroup.LayoutParams layoutParams29 = new RelativeLayout.LayoutParams(-1, -2);
                            relativeLayout18.setPadding(0, com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 6.0f), 0, com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 8.0f));
                            relativeLayout16.addView(relativeLayout18, layoutParams29);
                            daVar2 = daVar;
                            daVar2.f23693a = textView16;
                            daVar2.f23699g = relativeLayout18;
                            ImageView imageView12 = new ImageView(this.f23661a);
                            imageView12.setId(R.id.BOTTOM_END);
                            RelativeLayout.LayoutParams layoutParams30 = new RelativeLayout.LayoutParams(com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 40.0f), com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 40.0f));
                            layoutParams30.setMargins(com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 8.0f), 0, com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 4.0f), 0);
                            layoutParams30.addRule(9);
                            relativeLayout17.addView(imageView12, layoutParams30);
                            daVar2.f23694b = imageView12;
                            LinearLayout linearLayout3 = new LinearLayout(this.f23661a);
                            linearLayout3.setOrientation(1);
                            linearLayout3.setId(2131755014);
                            try {
                                linearLayout3.setBackgroundDrawable(com.baidu.ufosdk.f.o.a(this.f23661a.getApplicationContext(), "ufo_server_send_bg_type5.9.png"));
                            } catch (Exception e10) {
                                e10.printStackTrace();
                            }
                            linearLayout3.setPadding(10, 3, 2, 2);
                            TextView textView17 = new TextView(this.f23661a);
                            textView17.setGravity(16);
                            textView17.setLineSpacing(5.0f, 1.0f);
                            textView17.setSingleLine(false);
                            textView17.setTextColor(-13421773);
                            textView17.setBackgroundColor(BDEmotionPanelManager.COLOR_EMOTION_TYPE_LAYOUT);
                            textView17.setTextSize(com.baidu.ufosdk.b.R);
                            textView17.setPadding(com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 10.0f), com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 5.0f), 0, com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 5.0f));
                            linearLayout3.addView(textView17, new LinearLayout.LayoutParams(-1, -2));
                            daVar2.f23696d = textView17;
                            ListView listView = new ListView(this.f23661a);
                            listView.setBackgroundColor(com.baidu.ufosdk.b.D);
                            listView.setDivider(new ColorDrawable(com.baidu.ufosdk.b.I));
                            listView.setDividerHeight(0);
                            linearLayout3.addView(listView, new LinearLayout.LayoutParams(-1, -2));
                            daVar2.f23695c = listView;
                            View view2 = new View(this.f23661a);
                            view2.setBackgroundColor(BDEmotionPanelManager.COLOR_EMOTION_TYPE_LAYOUT);
                            view2.setVisibility(8);
                            linearLayout3.addView(view2, new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 1.0f)));
                            LinearLayout linearLayout4 = new LinearLayout(this.f23661a);
                            linearLayout4.setBackgroundColor(com.baidu.ufosdk.b.z);
                            TextView textView18 = new TextView(this.f23661a);
                            textView18.setGravity(16);
                            textView18.setBackgroundColor(com.baidu.ufosdk.b.z);
                            textView18.setLineSpacing(5.0f, 1.0f);
                            textView18.setTextColor(-13421773);
                            textView18.setTextSize(com.baidu.ufosdk.b.R - 3.0f);
                            textView18.setAutoLinkMask(1);
                            LinearLayout.LayoutParams layoutParams31 = new LinearLayout.LayoutParams(-1, -2);
                            czVar = czVar2;
                            dbVar = dbVar2;
                            layoutParams31.setMargins(com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 5.0f), com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 5.0f), com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 15.0f), com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 5.0f));
                            linearLayout4.addView(textView18, layoutParams31);
                            daVar2.f23697e = textView18;
                            RelativeLayout.LayoutParams layoutParams32 = new RelativeLayout.LayoutParams(-1, -2);
                            layoutParams32.setMargins(0, 0, com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 57.0f), 0);
                            layoutParams32.addRule(1, imageView12.getId());
                            relativeLayout17.addView(linearLayout3, layoutParams32);
                            daVar2.f23698f = linearLayout3;
                            RelativeLayout.LayoutParams layoutParams33 = new RelativeLayout.LayoutParams(-1, -2);
                            layoutParams33.addRule(1, imageView12.getId());
                            layoutParams33.addRule(3, linearLayout3.getId());
                            relativeLayout17.addView(linearLayout4, layoutParams33);
                            relativeLayout17.setPadding(0, 0, 0, com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 10.0f));
                            RelativeLayout.LayoutParams layoutParams34 = new RelativeLayout.LayoutParams(-1, -2);
                            layoutParams34.addRule(3, relativeLayout18.getId());
                            relativeLayout16.addView(relativeLayout17, layoutParams34);
                            relativeLayout16.setTag(R.style.AiappsGameGuideDialogStyle, daVar2);
                            relativeLayout16.setTag(R.style.AdNoTitleDialog, Integer.valueOf(i4));
                            relativeLayout2 = relativeLayout16;
                        } else {
                            czVar = czVar2;
                            dbVar = dbVar2;
                            daVar2 = daVar;
                            relativeLayout2 = view;
                        }
                    }
                    packageManager = this.f23662b.getApplicationContext().getPackageManager();
                    ApplicationInfo applicationInfo = packageManager.getApplicationInfo(this.f23662b.getPackageName(), 0);
                    if (packageManager != null) {
                        Drawable applicationIcon = packageManager.getApplicationIcon(applicationInfo);
                        bitmap = applicationIcon instanceof BitmapDrawable ? ((BitmapDrawable) applicationIcon).getBitmap() : FeedbackInputActivity.a(applicationIcon);
                    } else {
                        bitmap = null;
                    }
                    if (i4 == 1) {
                        dcVar2.f23712d.setVisibility(0);
                        if (i2 != 0) {
                            long parseLong = Long.parseLong((String) ((Map) this.f23661a.f23565h.get(i2 - 1)).get("time"));
                            long parseLong2 = Long.parseLong((String) ((Map) this.f23661a.f23565h.get(i2)).get("time"));
                            long j = parseLong - parseLong2;
                            if (j > 3600000 || parseLong2 - parseLong > 3600000) {
                                dcVar2.f23709a.setText(com.baidu.ufosdk.f.i.c(parseLong2));
                                if (j > 86400000 || parseLong2 - parseLong > 86400000) {
                                    textView8 = dcVar2.f23709a;
                                    a8 = com.baidu.ufosdk.f.i.a(parseLong2);
                                }
                            } else {
                                dcVar2.f23712d.setVisibility(8);
                            }
                            dcVar2.f23710b.setBackgroundDrawable(new BitmapDrawable(com.baidu.ufosdk.f.m.c(this.f23661a.getApplicationContext())));
                            obj3 = obj;
                            if (((String) ((Map) this.f23661a.f23565h.get(i2)).get(obj3)).contentEquals("1")) {
                                Object obj4 = obj2;
                                if (((String) ((Map) this.f23661a.f23565h.get(i2)).get(obj3)).contentEquals("2") && dcVar2.f23711c != null) {
                                    bitmap2 = (Bitmap) ((Map) this.f23661a.f23565h.get(i2)).get(obj4);
                                    if (bitmap2.getHeight() > bitmap2.getWidth()) {
                                        dcVar2.f23711c.setMaxWidth(com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 80.0f));
                                        imageView5 = dcVar2.f23711c;
                                        applicationContext4 = this.f23661a.getApplicationContext();
                                        f4 = 120.0f;
                                    } else {
                                        dcVar2.f23711c.setMaxWidth(com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 120.0f));
                                        imageView5 = dcVar2.f23711c;
                                        applicationContext4 = this.f23661a.getApplicationContext();
                                        f4 = 80.0f;
                                    }
                                    imageView5.setMaxHeight(com.baidu.ufosdk.f.i.a(applicationContext4, f4));
                                    imageView3 = dcVar2.f23711c;
                                    imageView3.setImageBitmap(bitmap2);
                                }
                            } else {
                                dcVar2.f23711c.setImageBitmap(com.baidu.ufosdk.f.m.a(this.f23662b, "ufo_pic_defult_icon.png"));
                                com.baidu.ufosdk.f.a a10 = com.baidu.ufosdk.f.a.a();
                                Context applicationContext5 = this.f23661a.getApplicationContext();
                                ImageView imageView13 = dcVar2.f23711c;
                                handler3 = this.f23661a.aK;
                                Bitmap a11 = a10.a(new com.baidu.ufosdk.f.n(applicationContext5, imageView13, handler3), (String) ((Map) this.f23661a.f23565h.get(i2)).get(obj2));
                                if (a11 != null) {
                                    dcVar2.f23711c.setImageBitmap(a11);
                                    if (a11.getHeight() > a11.getWidth()) {
                                        dcVar2.f23711c.setMaxWidth(com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 80.0f));
                                        imageView = dcVar2.f23711c;
                                        applicationContext3 = this.f23661a.getApplicationContext();
                                        f3 = 120.0f;
                                        imageView.setMaxHeight(com.baidu.ufosdk.f.i.a(applicationContext3, f3));
                                    } else {
                                        dcVar2.f23711c.setMaxWidth(com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 120.0f));
                                        imageView = dcVar2.f23711c;
                                        applicationContext3 = this.f23661a.getApplicationContext();
                                        f3 = 80.0f;
                                        imageView.setMaxHeight(com.baidu.ufosdk.f.i.a(applicationContext3, f3));
                                    }
                                }
                            }
                            return relativeLayout3;
                        }
                        textView8 = dcVar2.f23709a;
                        a8 = com.baidu.ufosdk.f.i.a(Long.parseLong((String) ((Map) this.f23661a.f23565h.get(i2)).get("time")));
                        textView8.setText(a8);
                        dcVar2.f23710b.setBackgroundDrawable(new BitmapDrawable(com.baidu.ufosdk.f.m.c(this.f23661a.getApplicationContext())));
                        obj3 = obj;
                        if (((String) ((Map) this.f23661a.f23565h.get(i2)).get(obj3)).contentEquals("1")) {
                        }
                        return relativeLayout3;
                    }
                    Object obj5 = obj2;
                    Object obj6 = obj;
                    if (i4 == 2) {
                        ddVar2.f23716d.setVisibility(0);
                        if (i2 == 0) {
                            textView7 = ddVar2.f23713a;
                            a7 = com.baidu.ufosdk.f.i.a(Long.parseLong((String) ((Map) this.f23661a.f23565h.get(i2)).get("time")));
                        } else {
                            long parseLong3 = Long.parseLong((String) ((Map) this.f23661a.f23565h.get(i2 - 1)).get("time"));
                            long parseLong4 = Long.parseLong((String) ((Map) this.f23661a.f23565h.get(i2)).get("time"));
                            long j2 = parseLong3 - parseLong4;
                            if (j2 > 3600000 || parseLong4 - parseLong3 > 3600000) {
                                ddVar2.f23713a.setText(com.baidu.ufosdk.f.i.c(parseLong4));
                                if (j2 > 86400000 || parseLong4 - parseLong3 > 86400000) {
                                    textView7 = ddVar2.f23713a;
                                    a7 = com.baidu.ufosdk.f.i.a(parseLong4);
                                }
                            } else {
                                ddVar2.f23716d.setVisibility(8);
                            }
                            ddVar2.f23714b.setBackgroundDrawable(new BitmapDrawable(com.baidu.ufosdk.f.m.c(this.f23661a.getApplicationContext())));
                            ddVar2.f23715c.setText((String) ((Map) this.f23661a.f23565h.get(i2)).get(obj5));
                        }
                        textView7.setText(a7);
                        ddVar2.f23714b.setBackgroundDrawable(new BitmapDrawable(com.baidu.ufosdk.f.m.c(this.f23661a.getApplicationContext())));
                        ddVar2.f23715c.setText((String) ((Map) this.f23661a.f23565h.get(i2)).get(obj5));
                    } else if (i4 == 3) {
                        dbVar2.f23703d.setVisibility(0);
                        if (i2 == 0) {
                            textView3 = dbVar2.f23700a;
                            a5 = com.baidu.ufosdk.f.i.a(Long.parseLong((String) ((Map) this.f23661a.f23565h.get(i2)).get("time")));
                        } else {
                            long parseLong5 = Long.parseLong((String) ((Map) this.f23661a.f23565h.get(i2 - 1)).get("time"));
                            long parseLong6 = Long.parseLong((String) ((Map) this.f23661a.f23565h.get(i2)).get("time"));
                            long j3 = parseLong5 - parseLong6;
                            if (j3 > 3600000 || parseLong6 - parseLong5 > 3600000) {
                                dbVar2.f23700a.setText(com.baidu.ufosdk.f.i.c(parseLong6));
                                if (j3 > 86400000 || parseLong6 - parseLong5 > 86400000) {
                                    textView3 = dbVar2.f23700a;
                                    a5 = com.baidu.ufosdk.f.i.a(parseLong6);
                                }
                            } else {
                                dbVar2.f23703d.setVisibility(8);
                            }
                            if (bitmap != null) {
                                try {
                                    dbVar2.f23701b.setBackgroundDrawable(new BitmapDrawable(bitmap));
                                } catch (Exception e11) {
                                    e11.printStackTrace();
                                }
                            }
                            if (dbVar2.f23702c != null) {
                                String str5 = (String) ((Map) this.f23661a.f23565h.get(i2)).get(obj5);
                                com.baidu.ufosdk.f.c.a(str5);
                                if (str5.startsWith("http://bs.baidu.com") || str5.startsWith("https://bs.baidu.com")) {
                                    com.baidu.ufosdk.f.a a12 = com.baidu.ufosdk.f.a.a();
                                    Context applicationContext6 = this.f23661a.getApplicationContext();
                                    TextView textView19 = dbVar2.f23702c;
                                    handler2 = this.f23661a.aK;
                                    Bitmap a13 = a12.a(new com.baidu.ufosdk.f.n(applicationContext6, textView19, handler2), str5);
                                    if (a13 != null) {
                                        ImageSpan imageSpan = new ImageSpan(this.f23661a.getApplicationContext(), a13);
                                        SpannableString spannableString = new SpannableString("icon");
                                        spannableString.setSpan(imageSpan, 0, 4, 33);
                                        textView6 = dbVar2.f23702c;
                                        str5 = spannableString.toString();
                                    }
                                } else {
                                    if (str5.contains("<a") && str5.contains("</a>")) {
                                        ArrayList arrayList5 = new ArrayList();
                                        ArrayList arrayList6 = new ArrayList();
                                        Matcher matcher = Pattern.compile("<a[^>]*>([^<]*)</a>").matcher(str5);
                                        while (matcher.find()) {
                                            com.baidu.ufosdk.f.c.a("提取内容：" + matcher.group(1));
                                            arrayList5.add(matcher.group(1));
                                        }
                                        Matcher matcher2 = Pattern.compile("[h|H][r|R][e|E][f|F] *= *'.*?'").matcher(str5);
                                        while (matcher2.find()) {
                                            com.baidu.ufosdk.f.c.a("提取链接：" + matcher2.group());
                                            arrayList6.add(matcher2.group());
                                        }
                                        if (arrayList6.size() != arrayList5.size()) {
                                            com.baidu.ufosdk.f.c.a("返回内容：" + str5);
                                            if (str5.contains("\\\"")) {
                                                com.baidu.ufosdk.f.c.a("包含\\\"");
                                                str5 = str5.replace("\\\"", "(=^o^=)Y");
                                            }
                                            Matcher matcher3 = Pattern.compile("[h|H][r|R][e|E][f|F] *= *\".*?\"").matcher(str5);
                                            while (matcher3.find()) {
                                                com.baidu.ufosdk.f.c.a("提取链接：" + matcher3.group());
                                                arrayList6.add(matcher3.group());
                                            }
                                        }
                                        if (arrayList5.size() == arrayList6.size()) {
                                            if (str5.endsWith("</a>")) {
                                                str5 = str5 + " ";
                                            }
                                            String str6 = str5;
                                            try {
                                                String[] split = str6.split("<a.*?</a>");
                                                dbVar2.f23702c.setText("");
                                                for (int i11 = 0; i11 < split.length; i11++) {
                                                    dbVar2.f23702c.append(new SpannableString(split[i11]));
                                                    if (i11 < split.length - 1) {
                                                        SpannableString spannableString2 = new SpannableString((CharSequence) arrayList5.get(i11));
                                                        eqVar3 = this.f23661a.aM;
                                                        spannableString2.setSpan(new ep((String) arrayList6.get(i11), eqVar3), 0, ((String) arrayList5.get(i11)).length(), 33);
                                                        dbVar2.f23702c.append(spannableString2);
                                                    }
                                                }
                                                dbVar2.f23702c.setMovementMethod(LinkMovementMethod.getInstance());
                                            } catch (Exception e12) {
                                                com.baidu.ufosdk.f.c.a("处理连接出错！", e12);
                                                if (str6.contains("(=^o^=)Y")) {
                                                    str6 = str6.replace("(=^o^=)Y", "\\\"");
                                                }
                                                dbVar2.f23702c.setText(str6);
                                            }
                                        } else if (str5.contains("(=^o^=)Y")) {
                                            str5 = str5.replace("(=^o^=)Y", "\\\"");
                                        }
                                    } else {
                                        if (str5.contains("人工反馈")) {
                                            com.baidu.ufosdk.f.c.a("lastIndexof : 人工反馈: " + str5.lastIndexOf("人工反馈"));
                                            FeedbackInputActivity feedbackInputActivity2 = this.f23661a;
                                            feedbackInputActivity2.u = !feedbackInputActivity2.H;
                                            SpannableString spannableString3 = new SpannableString(str5);
                                            eqVar2 = this.f23661a.aM;
                                            spannableString3.setSpan(new ep("人工反馈", eqVar2), str5.lastIndexOf("人工反馈"), str5.lastIndexOf("人工反馈") + 4, 33);
                                            if (this.f23661a.H) {
                                                dbVar2.f23702c.setText(str5);
                                            } else {
                                                dbVar2.f23702c.setText(spannableString3);
                                                dbVar2.f23702c.setMovementMethod(LinkMovementMethod.getInstance());
                                            }
                                            arrayList4 = this.f23661a.aw;
                                            if (arrayList4 == null) {
                                                feedbackInputActivity = this.f23661a;
                                                arrayList2 = new ArrayList();
                                            }
                                        } else if (str5.contains("我的反馈")) {
                                            com.baidu.ufosdk.f.c.a("indexof : 我的反馈: " + str5.lastIndexOf("我的反馈"));
                                            FeedbackInputActivity feedbackInputActivity3 = this.f23661a;
                                            feedbackInputActivity3.u = !feedbackInputActivity3.H;
                                            SpannableString spannableString4 = new SpannableString(str5);
                                            eqVar = this.f23661a.aM;
                                            spannableString4.setSpan(new ep("我的反馈", eqVar), str5.lastIndexOf("我的反馈"), str5.lastIndexOf("我的反馈") + 4, 33);
                                            if (this.f23661a.H) {
                                                dbVar2.f23702c.setText(str5);
                                            } else {
                                                dbVar2.f23702c.setText(spannableString4);
                                                dbVar2.f23702c.setMovementMethod(LinkMovementMethod.getInstance());
                                                dbVar2.f23702c.setHighlightColor(0);
                                            }
                                            arrayList = this.f23661a.aw;
                                            if (arrayList == null) {
                                                feedbackInputActivity = this.f23661a;
                                                arrayList2 = new ArrayList();
                                            }
                                        }
                                        feedbackInputActivity.aw = arrayList2;
                                        arrayList3 = this.f23661a.aw;
                                        arrayList3.add(dbVar2.f23702c);
                                    }
                                    textView6 = dbVar2.f23702c;
                                }
                                textView6.setText(str5);
                            }
                            i6 = ((Integer) ((Map) this.f23661a.f23565h.get(i2)).get("ask")).intValue();
                            if (i6 != 0) {
                                dbVar2.f23704e.setVisibility(8);
                                dbVar2.f23707h.setVisibility(8);
                                dbVar2.f23708i.setVisibility(8);
                                dbVar2.j.setVisibility(8);
                            } else {
                                if (i6 == 1) {
                                    dbVar2.f23707h.setVisibility(8);
                                    dbVar2.f23708i.setVisibility(8);
                                    dbVar2.j.setVisibility(8);
                                    dbVar2.f23704e.setVisibility(0);
                                    dbVar2.f23706g.setClickable(true);
                                    dbVar2.f23705f.setClickable(true);
                                    dbVar2.f23705f.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(this.f23661a.getApplicationContext(), "ufo_bottom_button.9.png", "ufo_bottom_button_pressed.9.png"));
                                    textView4 = dbVar2.f23706g;
                                    applicationContext2 = this.f23661a.getApplicationContext();
                                    str2 = "ufo_bottom_button.9.png";
                                    str3 = "ufo_bottom_button_pressed.9.png";
                                } else {
                                    if (i6 == 2) {
                                        com.baidu.ufosdk.f.c.a(">>>>>>>已解决 ask=2");
                                        dbVar2.f23704e.setVisibility(0);
                                        dbVar2.j.setVisibility(8);
                                        dbVar2.f23706g.setClickable(false);
                                        dbVar2.f23705f.setClickable(false);
                                        dbVar2.f23707h.setVisibility(8);
                                        dbVar2.f23708i.setVisibility(8);
                                        dbVar2.f23705f.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(this.f23661a.getApplicationContext(), "ufo_bottom_button_pressed.9.png", "ufo_bottom_button_pressed.9.png"));
                                        textView4 = dbVar2.f23706g;
                                    } else if (i6 == 3) {
                                        com.baidu.ufosdk.f.c.a(">>>>>>>未解决 ask=3");
                                        dbVar2.f23704e.setVisibility(0);
                                        dbVar2.j.setVisibility(8);
                                        dbVar2.f23705f.setClickable(false);
                                        dbVar2.f23706g.setClickable(false);
                                        dbVar2.f23707h.setVisibility(8);
                                        dbVar2.f23708i.setVisibility(8);
                                        dbVar2.f23706g.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(this.f23661a.getApplicationContext(), "ufo_bottom_button_pressed.9.png", "ufo_bottom_button_pressed.9.png"));
                                        textView4 = dbVar2.f23705f;
                                    } else {
                                        if (i6 == 9) {
                                            i7 = this.f23661a.aG;
                                            if (i7 != 0) {
                                                i8 = 0;
                                                dbVar2.j.setVisibility(0);
                                            } else {
                                                i8 = 0;
                                            }
                                            dbVar2.f23704e.setVisibility(8);
                                            dbVar2.f23707h.setVisibility(i8);
                                            dbVar2.f23708i.setVisibility(i8);
                                            imageView4 = dbVar2.f23708i;
                                            bitmapDrawable = new BitmapDrawable(com.baidu.ufosdk.f.m.a(this.f23661a.getApplicationContext(), "ufo_not_solved.png"));
                                        } else if (i6 == 11) {
                                            dbVar2.j.setVisibility(8);
                                            dbVar2.f23704e.setVisibility(8);
                                            dbVar2.f23707h.setVisibility(0);
                                            dbVar2.f23708i.setVisibility(0);
                                            imageView4 = dbVar2.f23708i;
                                            bitmapDrawable = new BitmapDrawable(com.baidu.ufosdk.f.m.a(this.f23661a.getApplicationContext(), "ufo_solved.png"));
                                        }
                                        imageView4.setBackgroundDrawable(bitmapDrawable);
                                    }
                                    applicationContext2 = this.f23661a.getApplicationContext();
                                    str2 = "ufo_bottom_button.9.png";
                                    str3 = "ufo_bottom_button.9.png";
                                }
                                textView4.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(applicationContext2, str2, str3));
                            }
                            if (i6 != 3 || i6 == 9) {
                                i9 = this.f23661a.aG;
                                if (i9 != 0) {
                                    dbVar2.j.setVisibility(0);
                                    if (((Map) this.f23661a.f23565h.get(i2)).containsKey("isClicked")) {
                                        dbVar2.j.setTextColor(com.baidu.ufosdk.f.i.a(2134669055, -15644211, 2134669055, 2134669055));
                                        a6 = com.baidu.ufosdk.f.i.a(this.f23662b, com.baidu.ufosdk.R.drawable.ufo_show_reason_pressed);
                                        a6.setAlpha(127);
                                    } else {
                                        dbVar2.j.setTextColor(com.baidu.ufosdk.f.i.a(-12814593, -15644211, -12814593, -12814593));
                                        a6 = com.baidu.ufosdk.f.i.a(this.f23662b, com.baidu.ufosdk.R.drawable.ufo_show_reason_normal);
                                    }
                                    a6.setBounds(com.baidu.ufosdk.f.i.a(this.f23662b, 1.0f), com.baidu.ufosdk.f.i.a(this.f23662b, 1.0f), com.baidu.ufosdk.f.i.a(this.f23662b, 14.0f), com.baidu.ufosdk.f.i.a(this.f23662b, 14.0f));
                                    dbVar2.j.setCompoundDrawables(null, null, a6, null);
                                    String str7 = (String) ((Map) this.f23661a.f23565h.get(i2)).get("discontent_reason");
                                    JSONArray jSONArray = (JSONArray) ((Map) this.f23661a.f23565h.get(i2)).get("discontent_labels");
                                    if (TextUtils.isEmpty(str7) && (jSONArray == null || jSONArray.length() == 0)) {
                                        textView5 = dbVar2.j;
                                        str4 = "填写不满意原因";
                                    } else {
                                        textView5 = dbVar2.j;
                                        str4 = "查看不满意原因";
                                    }
                                    textView5.setText(str4);
                                    dbVar2.j.setOnClickListener(new cx(this, str7, jSONArray, i2));
                                }
                            }
                            if (i6 != 1) {
                                dbVar2.f23705f.setOnClickListener(new ci(this, i2));
                                dbVar2.f23706g.setOnClickListener(new ck(this, i2));
                            } else {
                                dbVar2.f23705f.setClickable(false);
                                dbVar2.f23705f.setOnClickListener(null);
                                dbVar2.f23706g.setClickable(false);
                                dbVar2.f23706g.setOnClickListener(null);
                            }
                        }
                        textView3.setText(a5);
                        if (bitmap != null) {
                        }
                        if (dbVar2.f23702c != null) {
                        }
                        i6 = ((Integer) ((Map) this.f23661a.f23565h.get(i2)).get("ask")).intValue();
                        if (i6 != 0) {
                        }
                        if (i6 != 3) {
                        }
                        i9 = this.f23661a.aG;
                        if (i9 != 0) {
                        }
                        if (i6 != 1) {
                        }
                    } else if (i4 == 4) {
                        czVar2.f23692d.setVisibility(0);
                        if (i2 == 0) {
                            textView2 = czVar2.f23689a;
                            a3 = com.baidu.ufosdk.f.i.a(Long.parseLong((String) ((Map) this.f23661a.f23565h.get(i2)).get("time")));
                        } else {
                            long parseLong7 = Long.parseLong((String) ((Map) this.f23661a.f23565h.get(i2 - 1)).get("time"));
                            long parseLong8 = Long.parseLong((String) ((Map) this.f23661a.f23565h.get(i2)).get("time"));
                            long j4 = parseLong7 - parseLong8;
                            if (j4 > 3600000 || parseLong8 - parseLong7 > 3600000) {
                                czVar2.f23689a.setText(com.baidu.ufosdk.f.i.c(parseLong8));
                                if (j4 > 86400000 || parseLong8 - parseLong7 > 86400000) {
                                    textView2 = czVar2.f23689a;
                                    a3 = com.baidu.ufosdk.f.i.a(parseLong8);
                                }
                            } else {
                                czVar2.f23692d.setVisibility(8);
                            }
                            if (bitmap != null) {
                                try {
                                    czVar2.f23690b.setBackgroundDrawable(new BitmapDrawable(bitmap));
                                } catch (Exception e13) {
                                    e13.printStackTrace();
                                }
                            }
                            if (!((String) ((Map) this.f23661a.f23565h.get(i2)).get(obj6)).contentEquals("1") || ((Map) this.f23661a.f23565h.get(i2)).get(obj5).toString().startsWith("http://bs.baidu.com") || ((Map) this.f23661a.f23565h.get(i2)).get(obj5).toString().startsWith("https://bs.baidu.com")) {
                                czVar2.f23691c.setImageBitmap(com.baidu.ufosdk.f.m.a(this.f23662b, "ufo_pic_defult_icon.png"));
                                com.baidu.ufosdk.f.a a14 = com.baidu.ufosdk.f.a.a();
                                Context applicationContext7 = this.f23661a.getApplicationContext();
                                ImageView imageView14 = czVar2.f23691c;
                                handler = this.f23661a.aK;
                                a4 = a14.a(new com.baidu.ufosdk.f.n(applicationContext7, imageView14, handler), (String) ((Map) this.f23661a.f23565h.get(i2)).get(obj5));
                                if (a4 != null) {
                                    czVar2.f23691c.setImageBitmap(a4);
                                    if (a4.getHeight() > a4.getWidth()) {
                                        czVar2.f23691c.setMaxWidth(com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 80.0f));
                                        imageView = czVar2.f23691c;
                                        applicationContext3 = this.f23661a.getApplicationContext();
                                        f3 = 120.0f;
                                        imageView.setMaxHeight(com.baidu.ufosdk.f.i.a(applicationContext3, f3));
                                    } else {
                                        czVar2.f23691c.setMaxWidth(com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 120.0f));
                                        imageView = czVar2.f23691c;
                                        applicationContext3 = this.f23661a.getApplicationContext();
                                        f3 = 80.0f;
                                        imageView.setMaxHeight(com.baidu.ufosdk.f.i.a(applicationContext3, f3));
                                    }
                                }
                            } else if (((String) ((Map) this.f23661a.f23565h.get(i2)).get(obj6)).contentEquals("2") && czVar2.f23691c != null) {
                                bitmap2 = (Bitmap) ((Map) this.f23661a.f23565h.get(i2)).get(obj5);
                                if (bitmap2.getHeight() > bitmap2.getWidth()) {
                                    czVar2.f23691c.setMaxWidth(com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 80.0f));
                                    imageView2 = czVar2.f23691c;
                                    applicationContext = this.f23661a.getApplicationContext();
                                    f2 = 120.0f;
                                } else {
                                    czVar2.f23691c.setMaxWidth(com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 120.0f));
                                    imageView2 = czVar2.f23691c;
                                    applicationContext = this.f23661a.getApplicationContext();
                                    f2 = 80.0f;
                                }
                                imageView2.setMaxHeight(com.baidu.ufosdk.f.i.a(applicationContext, f2));
                                imageView3 = czVar2.f23691c;
                                imageView3.setImageBitmap(bitmap2);
                            }
                        }
                        textView2.setText(a3);
                        if (bitmap != null) {
                        }
                        if (((String) ((Map) this.f23661a.f23565h.get(i2)).get(obj6)).contentEquals("1")) {
                        }
                        czVar2.f23691c.setImageBitmap(com.baidu.ufosdk.f.m.a(this.f23662b, "ufo_pic_defult_icon.png"));
                        com.baidu.ufosdk.f.a a142 = com.baidu.ufosdk.f.a.a();
                        Context applicationContext72 = this.f23661a.getApplicationContext();
                        ImageView imageView142 = czVar2.f23691c;
                        handler = this.f23661a.aK;
                        a4 = a142.a(new com.baidu.ufosdk.f.n(applicationContext72, imageView142, handler), (String) ((Map) this.f23661a.f23565h.get(i2)).get(obj5));
                        if (a4 != null) {
                        }
                    } else if (i4 == 5) {
                        daVar3.f23699g.setVisibility(0);
                        if (i2 == 0) {
                            textView = daVar3.f23693a;
                            a2 = com.baidu.ufosdk.f.i.a(Long.parseLong((String) ((Map) this.f23661a.f23565h.get(i2)).get("time")));
                        } else {
                            long parseLong9 = Long.parseLong((String) ((Map) this.f23661a.f23565h.get(i2 - 1)).get("time"));
                            long parseLong10 = Long.parseLong((String) ((Map) this.f23661a.f23565h.get(i2)).get("time"));
                            long j5 = parseLong9 - parseLong10;
                            if (j5 > 3600000 || parseLong10 - parseLong9 > 3600000) {
                                daVar3.f23693a.setText(com.baidu.ufosdk.f.i.c(parseLong10));
                                if (j5 > 86400000 || parseLong10 - parseLong9 > 86400000) {
                                    textView = daVar3.f23693a;
                                    a2 = com.baidu.ufosdk.f.i.a(parseLong10);
                                }
                            } else {
                                daVar3.f23699g.setVisibility(8);
                            }
                            if (bitmap != null) {
                                try {
                                    daVar3.f23694b.setBackgroundDrawable(new BitmapDrawable(bitmap));
                                } catch (Exception e14) {
                                    e14.printStackTrace();
                                }
                            }
                            FeedbackInputActivity feedbackInputActivity4 = this.f23661a;
                            fd fdVar = new fd(feedbackInputActivity4, (JSONArray) ((Map) feedbackInputActivity4.f23565h.get(i2)).get(obj5), ((Integer) ((Map) this.f23661a.f23565h.get(i2)).get("subtype")).intValue(), this.f23661a.H);
                            if (((Integer) ((Map) this.f23661a.f23565h.get(i2)).get("subtype")).intValue() != 1) {
                                daVar3.f23696d.setText("请选择问题发生的场景");
                                daVar3.f23697e.setVisibility(8);
                            } else {
                                try {
                                    str = (String) ((Map) this.f23661a.f23565h.get(i2)).get("tip");
                                } catch (Exception unused) {
                                    str = "";
                                }
                                if (TextUtils.isEmpty(str)) {
                                    str = "您是不是要问以下问题？";
                                }
                                daVar3.f23696d.setText(str);
                                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("没有想要的，进入人工反馈");
                                spannableStringBuilder.setSpan(new ForegroundColorSpan(com.baidu.ufosdk.b.v), 8, 12, 33);
                                if (this.f23661a.H) {
                                    daVar3.f23697e.setText("没有想要的，进入人工反馈");
                                } else {
                                    daVar3.f23697e.setText(spannableStringBuilder);
                                }
                                daVar3.f23697e.setVisibility(0);
                                daVar3.f23697e.setOnClickListener(new cm(this));
                            }
                            daVar3.f23695c.setAdapter((ListAdapter) fdVar);
                            daVar3.f23695c.setOnItemClickListener(new co(this, i2));
                            FeedbackInputActivity.a(daVar3.f23695c);
                        }
                        textView.setText(a2);
                        if (bitmap != null) {
                        }
                        FeedbackInputActivity feedbackInputActivity42 = this.f23661a;
                        fd fdVar2 = new fd(feedbackInputActivity42, (JSONArray) ((Map) feedbackInputActivity42.f23565h.get(i2)).get(obj5), ((Integer) ((Map) this.f23661a.f23565h.get(i2)).get("subtype")).intValue(), this.f23661a.H);
                        if (((Integer) ((Map) this.f23661a.f23565h.get(i2)).get("subtype")).intValue() != 1) {
                        }
                        daVar3.f23695c.setAdapter((ListAdapter) fdVar2);
                        daVar3.f23695c.setOnItemClickListener(new co(this, i2));
                        FeedbackInputActivity.a(daVar3.f23695c);
                    }
                    return relativeLayout3;
                }
                RelativeLayout relativeLayout19 = new RelativeLayout(this.f23662b);
                RelativeLayout relativeLayout20 = new RelativeLayout(this.f23662b);
                RelativeLayout relativeLayout21 = new RelativeLayout(this.f23662b);
                ViewGroup.LayoutParams layoutParams35 = new AbsListView.LayoutParams(-1, -2);
                relativeLayout19.setBackgroundColor(com.baidu.ufosdk.b.z);
                relativeLayout20.setBackgroundColor(com.baidu.ufosdk.b.z);
                relativeLayout21.setBackgroundColor(com.baidu.ufosdk.b.z);
                relativeLayout19.setLayoutParams(layoutParams35);
                relativeLayout21.setId(R.id.Backward);
                relativeLayout21.setClickable(false);
                TextView textView20 = new TextView(this.f23661a);
                try {
                    textView20.setBackgroundDrawable(com.baidu.ufosdk.f.o.a(this.f23661a.getApplicationContext(), "ufo_date_bg.9.png"));
                } catch (Exception e15) {
                    e15.printStackTrace();
                }
                textView20.setTextColor(-1);
                textView20.setTextSize(com.baidu.ufosdk.b.Q);
                textView20.setGravity(17);
                textView20.setMovementMethod(LinkMovementMethod.getInstance());
                textView20.setPadding(com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 10.0f), com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 2.0f) + 2, com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 10.0f), com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 2.0f));
                RelativeLayout.LayoutParams layoutParams36 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams36.setMargins(0, com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 10.0f), 0, 0);
                layoutParams36.addRule(14);
                relativeLayout21.addView(textView20, layoutParams36);
                ViewGroup.LayoutParams layoutParams37 = new RelativeLayout.LayoutParams(-1, -2);
                relativeLayout21.setPadding(0, com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 6.0f), 0, com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 8.0f));
                relativeLayout19.addView(relativeLayout21, layoutParams37);
                ddVar2.f23713a = textView20;
                ddVar2.f23716d = relativeLayout21;
                ImageView imageView15 = new ImageView(this.f23661a);
                imageView15.setId(R.id.BOTTOM_END);
                RelativeLayout.LayoutParams layoutParams38 = new RelativeLayout.LayoutParams(com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 40.0f), com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 40.0f));
                layoutParams38.addRule(11);
                layoutParams38.setMargins(com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 6.0f), 0, com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 8.0f), 0);
                relativeLayout20.addView(imageView15, layoutParams38);
                ddVar2.f23714b = imageView15;
                TextView textView21 = new TextView(this.f23661a);
                textView21.setTextColor(-13421773);
                textView21.setTextSize(com.baidu.ufosdk.b.R);
                textView21.setLineSpacing(4.0f, 1.0f);
                try {
                    textView21.setBackgroundDrawable(com.baidu.ufosdk.f.o.a(this.f23661a.getApplicationContext(), "ufo_me_send_bg.9.png"));
                } catch (IOException e16) {
                    e16.printStackTrace();
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
                textView21.setGravity(16);
                textView21.setPadding(com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 10.0f), com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 8.0f), com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 14.0f), com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 8.0f));
                textView21.setLineSpacing(5.0f, 1.0f);
                textView21.setAutoLinkMask(1);
                textView21.setMovementMethod(LinkMovementMethod.getInstance());
                textView21.setOnLongClickListener(new cr(this));
                RelativeLayout.LayoutParams layoutParams39 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams39.setMargins(com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 55.0f), 0, 0, 0);
                layoutParams39.addRule(0, imageView15.getId());
                relativeLayout20.addView(textView21, layoutParams39);
                ddVar2.f23715c = textView21;
                relativeLayout20.setPadding(0, 0, 0, com.baidu.ufosdk.f.i.a(this.f23661a.getApplicationContext(), 10.0f));
                RelativeLayout.LayoutParams layoutParams40 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams40.addRule(3, relativeLayout21.getId());
                relativeLayout19.addView(relativeLayout20, layoutParams40);
                relativeLayout19.setOnClickListener(new cs(this));
                relativeLayout19.setTag(R.style.AiappsGameGuideDialogStyle, ddVar2);
                relativeLayout19.setTag(R.style.AdNoTitleDialog, Integer.valueOf(i3));
                i4 = i3;
                relativeLayout = relativeLayout19;
            }
            daVar3 = daVar;
            relativeLayout3 = relativeLayout;
            packageManager = this.f23662b.getApplicationContext().getPackageManager();
            ApplicationInfo applicationInfo2 = packageManager.getApplicationInfo(this.f23662b.getPackageName(), 0);
            if (packageManager != null) {
            }
            if (i4 == 1) {
            }
        } else {
            if (i3 == 1) {
                dcVar2 = (dc) view.getTag(R.style.AiappsGameGuideDialogStyle);
            } else if (i3 == 2) {
                ddVar2 = (dd) view.getTag(R.style.AiappsGameGuideDialogStyle);
            } else if (i3 == 3) {
                dbVar2 = (db) view.getTag(R.style.AiappsGameGuideDialogStyle);
            } else if (i3 == 4) {
                czVar2 = (cz) view.getTag(R.style.AiappsGameGuideDialogStyle);
            } else if (i3 == 5) {
                daVar3 = (da) view.getTag(R.style.AiappsGameGuideDialogStyle);
            } else {
                i4 = i3;
                obj = "contenttype";
                obj2 = "content";
                czVar = czVar2;
                dbVar = dbVar2;
                daVar2 = daVar3;
                dcVar = dcVar2;
                ddVar = ddVar2;
                relativeLayout2 = view;
            }
            relativeLayout3 = view;
            i4 = i3;
            obj = "contenttype";
            obj2 = "content";
            packageManager = this.f23662b.getApplicationContext().getPackageManager();
            ApplicationInfo applicationInfo22 = packageManager.getApplicationInfo(this.f23662b.getPackageName(), 0);
            if (packageManager != null) {
            }
            if (i4 == 1) {
            }
        }
        daVar3 = daVar2;
        dbVar2 = dbVar;
        dcVar2 = dcVar;
        ddVar2 = ddVar;
        czVar2 = czVar;
        relativeLayout3 = relativeLayout2;
        packageManager = this.f23662b.getApplicationContext().getPackageManager();
        ApplicationInfo applicationInfo222 = packageManager.getApplicationInfo(this.f23662b.getPackageName(), 0);
        if (packageManager != null) {
        }
        if (i4 == 1) {
        }
    }
}
