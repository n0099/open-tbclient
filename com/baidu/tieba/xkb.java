package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceReference;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public interface xkb {
    public static final ServiceReference a = new ServiceReference("voyager", "upload");

    void a(String str, String str2, int i, wkb wkbVar);

    void b(List<String> list, String str, long j, JSONObject jSONObject);

    void c(String str, String str2, JSONObject jSONObject);

    boolean d(JSONObject jSONObject);

    void e(String str, String str2, wkb wkbVar);

    void f();

    void g(List<String> list, String str, long j, wkb wkbVar);

    void retry();
}
