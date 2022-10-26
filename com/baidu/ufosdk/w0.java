package com.baidu.ufosdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.pose.PoseAR;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.ui.FeedbackInputActivity;
import java.util.List;
/* loaded from: classes6.dex */
public class w0 extends ClickableSpan {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ URLSpan a;
    public final /* synthetic */ FeedbackInputActivity.s b;

    public w0(FeedbackInputActivity.s sVar, URLSpan uRLSpan) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sVar, uRLSpan};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = sVar;
        this.a = uRLSpan;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            String url = this.a.getURL();
            if (TextUtils.isEmpty(url)) {
                return;
            }
            if (url.startsWith("http")) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setPackage(c.a());
                intent.setData(Uri.parse(url));
                PackageManager packageManager = null;
                try {
                    packageManager = this.b.a.getPackageManager();
                } catch (Throwable unused) {
                }
                List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
                if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    this.b.a.startActivity(intent);
                    return;
                }
                return;
            }
            Context context = this.b.a;
            Bundle bundle = new Bundle();
            bundle.putInt(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY, 103);
            bundle.putString("bd_scheme", url);
            b.a(context, bundle);
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
            textPaint.setColor(Color.parseColor("#ff4B9EFA"));
            textPaint.setUnderlineText(false);
        }
    }
}
