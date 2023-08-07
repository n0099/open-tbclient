package com.baidu.ufosdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.hybrid.base.FeedbackTitleBar;
import com.baidu.ufosdk.hybrid.base.WebLoaderActivity;
import java.util.List;
/* loaded from: classes9.dex */
public class e implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ j a;

    public e(FeedbackTitleBar feedbackTitleBar, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {feedbackTitleBar, jVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = jVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002b, code lost:
        if (r0.size() > 0) goto L15;
     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            WebLoaderActivity webLoaderActivity = (WebLoaderActivity) this.a;
            PackageManager packageManager = null;
            if (webLoaderActivity != null) {
                Intent a = b.a((Context) webLoaderActivity, 3);
                boolean z = true;
                a.putExtra("extra.has_anim", true);
                try {
                    packageManager = webLoaderActivity.getPackageManager();
                } catch (Throwable unused) {
                }
                if (packageManager != null) {
                    try {
                        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(a, 65536);
                        if (queryIntentActivities != null) {
                        }
                    } catch (Exception unused2) {
                    }
                }
                z = false;
                if (z) {
                    webLoaderActivity.startActivity(a);
                    webLoaderActivity.overridePendingTransition(com.baidu.tieba.R.anim.obfuscated_res_0x7f01017f, com.baidu.tieba.R.anim.obfuscated_res_0x7f010181);
                    return;
                }
                return;
            }
            throw null;
        }
    }
}
