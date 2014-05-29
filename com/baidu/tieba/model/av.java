package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tieba.data.PersonChangeData;
import com.baidu.tieba.person.PersonPostListData;
import com.baidu.tieba.person.by;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class av extends com.baidu.adp.base.b {
    private long c;
    private long d;
    private long e;
    private long f;
    private long g;
    private String h;
    private PersonPostListData l;
    private AntiData o;
    private com.baidu.tbadk.editortool.ab p;
    private com.baidu.tbadk.coreExtra.b.a r;
    private Context s;
    private by t;
    private int m = 1;
    private boolean n = false;
    private ax q = null;
    private final CustomMessageListener u = new aw(this, MessageTypes.CMD_UPDATE_ATTENTION);
    private boolean a = true;
    private String b = null;
    private UserData k = null;
    private boolean i = false;
    private boolean j = false;

    public PersonPostListData a() {
        return this.l;
    }

    public boolean b() {
        return this.n;
    }

    public void a(boolean z) {
        this.n = z;
    }

    public boolean c() {
        List<PersonPostListData.PostList> list;
        return (this.l == null || (list = this.l.post_list) == null || list.size() <= 0) ? false : true;
    }

    private int p() {
        List<PersonPostListData.PostList> list;
        if (this.l != null && (list = this.l.post_list) != null) {
            if (list.size() % 20 > 0) {
                return (list.size() / 20) + 2;
            }
            return (list.size() / 20) + 1;
        }
        return 1;
    }

    public av(Context context) {
        this.s = null;
        this.s = context;
        a(0L);
        d(0L);
        e(0L);
        b(0L);
        c(0L);
        this.p = new com.baidu.tbadk.editortool.ab(context);
    }

    public void d() {
        registerListener(this.u);
    }

    public void a(by byVar) {
        this.t = byVar;
    }

    public AntiData e() {
        return this.o;
    }

    public void a(AntiData antiData) {
        this.o = antiData;
    }

    public String f() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    public void b(boolean z) {
        this.a = z;
    }

    public boolean g() {
        return this.a;
    }

    public void a(UserData userData) {
        this.k = userData;
    }

    public UserData h() {
        return this.k;
    }

    public void a(PersonChangeData personChangeData) {
        h().setSex(personChangeData.getSex());
        h().setUserName(personChangeData.getName());
        h().setIntro(personChangeData.getIntro());
    }

    public void a(boolean z, boolean z2, int i) {
        if (this.q == null) {
            if (i == 1) {
                this.m = 1;
            } else {
                this.m = p();
            }
            this.q = new ax(this);
            this.q.setPriority(3);
            this.q.execute(Boolean.valueOf(z), Boolean.valueOf(z2));
        }
    }

    public void i() {
        if (h() != null && this.r != null) {
            this.r.a(h().getHave_attention() != 1, h().getPortrait(), h().getUserId());
        }
    }

    public void b(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(getClass().getName(), "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.k = new UserData();
                this.k.parserJson(jSONObject.optJSONObject("user"));
                this.o = new AntiData();
                this.o.parserJson(jSONObject.optJSONObject("anti_stat"));
            } catch (Exception e) {
                BdLog.e(getClass().getName(), "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public com.baidu.tbadk.editortool.ab j() {
        return this.p;
    }

    public void c(String str) {
        this.h = str;
    }

    public String k() {
        return this.h;
    }

    public void a(long j) {
        this.c = j;
    }

    public long l() {
        return this.c;
    }

    public void b(long j) {
        this.f = j;
    }

    public void c(long j) {
        this.g = j;
    }

    public void d(long j) {
        this.d = j;
    }

    public void e(long j) {
        this.e = j;
    }

    public void c(boolean z) {
        this.i = z;
    }

    public boolean m() {
        return this.i;
    }

    public void d(boolean z) {
        this.j = z;
    }

    public boolean n() {
        return this.j;
    }

    @Override // com.baidu.adp.base.b
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.b
    public boolean cancelLoadData() {
        return false;
    }

    public void o() {
        MessageManager.getInstance().unRegisterListener(this.u);
        if (this.q != null) {
            this.q.cancel();
        }
        if (this.p != null) {
            this.p.d();
        }
    }
}
