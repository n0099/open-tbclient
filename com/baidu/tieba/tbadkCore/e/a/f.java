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
public class f {
    private ArrayList<a> nBI = new ArrayList<>();

    public void a(a aVar) {
        this.nBI.add(aVar);
    }

    public c a(e eVar, c cVar) {
        if (cVar == null) {
            cVar = new c();
        }
        if (ActionJsonData.TAG_NOTIFICATION.equals(eVar.getModule()) && "addObserver".equals(eVar.getAction())) {
            Iterator<a> it = this.nBI.iterator();
            while (true) {
                if (it.hasNext()) {
                    cVar = it.next().addObserver(eVar.dOz(), cVar, true);
                    if (cVar.dOu()) {
                        break;
                    }
                } else if (!cVar.dOu()) {
                    cVar.JR(202);
                    cVar.TC(TbadkCoreApplication.getInst().getString(R.string.can_find_notification_name));
                }
            }
        } else {
            String module = eVar.getModule();
            if (!au.isEmpty(module) && DescriptionTableInfo.getModuleSet() != null && !DescriptionTableInfo.getModuleSet().contains(module)) {
                cVar.JR(201);
            } else {
                Iterator<a> it2 = this.nBI.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        cVar = it2.next().dispatch(eVar, cVar);
                        if (cVar.dOt()) {
                            break;
                        }
                    } else if (!cVar.dOt()) {
                        cVar.JR(202);
                    }
                }
            }
        }
        return cVar;
    }

    public void a(WebView webView, c cVar) {
        if (webView != null && cVar != null && cVar.dOw()) {
            callJsMethod(webView, cVar.cuI(), cVar.dOx());
        }
    }

    public void a(WebView webView, List<c> list) {
        if (webView != null && !y.isEmpty(list)) {
            for (c cVar : list) {
                if (cVar != null && cVar.dOw()) {
                    callJsMethod(webView, cVar.cuI(), cVar.dOx());
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

    public List<c> g(String str, HashMap hashMap) {
        List<c> list = null;
        if (!au.isEmpty(str)) {
            Iterator<a> it = this.nBI.iterator();
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
