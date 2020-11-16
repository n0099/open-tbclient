package com.baidu.tieba.tbadkCore.e.a;

import android.os.Build;
import android.webkit.WebView;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.h5power.DescriptionTableInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private ArrayList<a> nam = new ArrayList<>();

    public void a(a aVar) {
        this.nam.add(aVar);
    }

    public b a(d dVar, b bVar) {
        if (bVar == null) {
            bVar = new b();
        }
        if (ActionJsonData.TAG_NOTIFICATION.equals(dVar.getModule()) && "addObserver".equals(dVar.getAction())) {
            Iterator<a> it = this.nam.iterator();
            while (true) {
                if (it.hasNext()) {
                    bVar = it.next().addObserver(dVar.dKz(), bVar);
                    if (bVar.dKu()) {
                        break;
                    }
                } else if (!bVar.dKu()) {
                    bVar.Kn(202);
                    bVar.Sv(TbadkCoreApplication.getInst().getString(R.string.can_find_notification_name));
                }
            }
        } else {
            String module = dVar.getModule();
            if (!au.isEmpty(module) && DescriptionTableInfo.getModuleSet() != null && !DescriptionTableInfo.getModuleSet().contains(module)) {
                bVar.Kn(201);
            } else {
                Iterator<a> it2 = this.nam.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        bVar = it2.next().dispatch(dVar, bVar);
                        if (bVar.dKt()) {
                            break;
                        }
                    } else if (!bVar.dKt()) {
                        bVar.Kn(202);
                    }
                }
            }
        }
        return bVar;
    }

    public void a(WebView webView, b bVar) {
        if (webView != null && bVar != null && bVar.dKw()) {
            callJsMethod(webView, bVar.getMethodName(), bVar.dKx());
        }
    }

    public void a(WebView webView, List<b> list) {
        if (webView != null && !y.isEmpty(list)) {
            for (b bVar : list) {
                if (bVar != null && bVar.dKw()) {
                    callJsMethod(webView, bVar.getMethodName(), bVar.dKx());
                }
            }
        }
    }

    private void callJsMethod(WebView webView, String str, String str2) {
        if (webView != null && !au.isEmpty(str) && !au.isEmpty(str2)) {
            if (Build.VERSION.SDK_INT >= 19) {
                webView.evaluateJavascript("javascript:" + str + "&&" + str + "('" + str2 + "')", null);
            } else {
                webView.loadUrl("javascript:" + str + "&&" + str + "('" + str2 + "')");
            }
        }
    }

    public List<b> f(String str, HashMap hashMap) {
        List<b> list = null;
        if (!au.isEmpty(str)) {
            Iterator<a> it = this.nam.iterator();
            while (it.hasNext()) {
                list = it.next().processNotification(str, hashMap);
                if (!y.isEmpty(list)) {
                    break;
                }
            }
        }
        return list;
    }
}
