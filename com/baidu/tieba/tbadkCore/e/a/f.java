package com.baidu.tieba.tbadkCore.e.a;

import android.os.Build;
import android.webkit.WebView;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.h5power.DescriptionTableInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private ArrayList<a> npt = new ArrayList<>();

    public void a(a aVar) {
        this.npt.add(aVar);
    }

    public c a(e eVar, c cVar) {
        if (cVar == null) {
            cVar = new c();
        }
        if (ActionJsonData.TAG_NOTIFICATION.equals(eVar.getModule()) && "addObserver".equals(eVar.getAction())) {
            Iterator<a> it = this.npt.iterator();
            while (true) {
                if (it.hasNext()) {
                    cVar = it.next().addObserver(eVar.dLX(), cVar, true);
                    if (cVar.dLS()) {
                        break;
                    }
                } else if (!cVar.dLS()) {
                    cVar.Js(202);
                    cVar.Sl(TbadkCoreApplication.getInst().getString(R.string.can_find_notification_name));
                }
            }
        } else {
            String module = eVar.getModule();
            if (!at.isEmpty(module) && DescriptionTableInfo.getModuleSet() != null && !DescriptionTableInfo.getModuleSet().contains(module)) {
                cVar.Js(201);
            } else {
                Iterator<a> it2 = this.npt.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        cVar = it2.next().dispatch(eVar, cVar);
                        if (cVar.dLR()) {
                            break;
                        }
                    } else if (!cVar.dLR()) {
                        cVar.Js(202);
                    }
                }
            }
        }
        return cVar;
    }

    public void a(WebView webView, c cVar) {
        if (webView != null && cVar != null && cVar.dLU()) {
            callJsMethod(webView, cVar.ctj(), cVar.dLV());
        }
    }

    public void a(WebView webView, List<c> list) {
        if (webView != null && !x.isEmpty(list)) {
            for (c cVar : list) {
                if (cVar != null && cVar.dLU()) {
                    callJsMethod(webView, cVar.ctj(), cVar.dLV());
                }
            }
        }
    }

    private void callJsMethod(WebView webView, String str, String str2) {
        if (webView != null && !at.isEmpty(str) && !at.isEmpty(str2)) {
            if (Build.VERSION.SDK_INT >= 19) {
                webView.evaluateJavascript("javascript:" + str + "&&" + str + "('" + str2 + "')", null);
            } else {
                webView.loadUrl("javascript:" + str + "&&" + str + "('" + str2 + "')");
            }
        }
    }

    public List<c> f(String str, HashMap hashMap) {
        List<c> list = null;
        if (!at.isEmpty(str)) {
            Iterator<a> it = this.npt.iterator();
            while (it.hasNext()) {
                list = it.next().processNotification(str, hashMap);
                if (!x.isEmpty(list)) {
                    break;
                }
            }
        }
        return list;
    }
}
