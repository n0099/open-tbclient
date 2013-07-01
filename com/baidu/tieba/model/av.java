package com.baidu.tieba.model;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.data.MapPostItem;
import com.baidu.tieba.data.MetaData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class av {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f1027a = new ArrayList();
    private com.baidu.tieba.data.ai b = new com.baidu.tieba.data.ai();
    private int c;

    public ArrayList a() {
        return this.f1027a;
    }

    public int b() {
        return this.c;
    }

    public com.baidu.tieba.data.ai c() {
        return this.b;
    }

    public void a(com.baidu.tieba.data.ai aiVar) {
        if (aiVar != null) {
            this.b = aiVar;
        }
    }

    public void a(ArrayList arrayList) {
        this.f1027a = arrayList;
    }

    public void a(int i) {
        this.c = i;
    }

    public void b(ArrayList arrayList) {
        if (arrayList != null && arrayList.size() > 0 && ((aw) arrayList.get(0)).a() == 3) {
            int size = this.f1027a.size();
            if (size > 0) {
                if (((aw) this.f1027a.get(size - 1)).b().equals(((aw) arrayList.get(0)).b())) {
                    arrayList.remove(0);
                }
                this.f1027a.addAll(arrayList);
                return;
            }
            this.f1027a = arrayList;
        }
    }

    public void a(String str, com.baidu.tieba.data.i iVar, String str2, MetaData metaData) {
        if (str != null && str.length() != 0 && iVar != null && iVar.a() == 0 && iVar.d() != null && this.f1027a != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f1027a.size()) {
                    if (!str.equals(((aw) this.f1027a.get(i2)).h())) {
                        i = i2 + 1;
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(iVar);
                        ((aw) this.f1027a.get(i2)).a(arrayList);
                        ((aw) this.f1027a.get(i2)).a(str2);
                        ((aw) this.f1027a.get(i2)).a(((aw) this.f1027a.get(i2)).d() + 1);
                        ((aw) this.f1027a.get(i2)).a(metaData);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.util.z.b("MyPostModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("thread_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int i = 0;
                aw awVar = null;
                while (i < optJSONArray.length()) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    aw awVar2 = new aw(this);
                    awVar2.b = optJSONObject.optString("distance");
                    awVar2.c = optJSONObject.optString("lng");
                    awVar2.d = optJSONObject.optString("lat");
                    awVar2.f1028a = optJSONObject.optInt("type", 0);
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray(PushConstants.EXTRA_CONTENT);
                    if (optJSONArray2 != null) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            com.baidu.tieba.data.i iVar = new com.baidu.tieba.data.i();
                            iVar.a(optJSONArray2.optJSONObject(i2));
                            awVar2.e.add(iVar);
                        }
                    }
                    awVar2.f = optJSONObject.optString("time");
                    awVar2.g = optJSONObject.optString("tid");
                    awVar2.h = optJSONObject.optString("fid");
                    awVar2.i = optJSONObject.optString("fname");
                    awVar2.k = optJSONObject.optString("link");
                    awVar2.j.parserJson(optJSONObject.optJSONObject("author"));
                    JSONArray optJSONArray3 = optJSONObject.optJSONArray("reply_content");
                    if (optJSONArray3 != null) {
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            com.baidu.tieba.data.i iVar2 = new com.baidu.tieba.data.i();
                            iVar2.a(optJSONArray3.optJSONObject(i3));
                            awVar2.l.add(iVar2);
                        }
                    }
                    awVar2.m = optJSONObject.optInt("reply_num");
                    awVar2.n = optJSONObject.optString("reply_time");
                    awVar2.o.parserJson(optJSONObject.optJSONObject("replyer"));
                    if (awVar != null && awVar2.b.equals(awVar.b)) {
                        this.f1027a.add(awVar2);
                    } else {
                        aw awVar3 = new aw(this);
                        awVar3.b = awVar2.b;
                        awVar3.f1028a = 3;
                        this.f1027a.add(awVar3);
                        this.f1027a.add(awVar2);
                    }
                    i++;
                    awVar = awVar2;
                }
                this.b.a(jSONObject.getJSONObject("page"));
                this.c = jSONObject.optInt("zoom_level");
                return;
            }
            this.b.e(0);
        } catch (Exception e) {
            com.baidu.tieba.util.z.b("MyPostModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public ArrayList d() {
        MapPostItem p;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f1027a.size()) {
                if (((aw) this.f1027a.get(i2)).a() == 0 && (p = ((aw) this.f1027a.get(i2)).p()) != null) {
                    arrayList.add(p);
                }
                i = i2 + 1;
            } else {
                return arrayList;
            }
        }
    }
}
