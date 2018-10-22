package com.baidu.tieba.j;

import android.os.Process;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.ng.ai.apps.trace.ErrDef;
import com.baidu.searchbox.ng.ai.apps.view.container.touch.AiAppsTouchHelper;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.VideoPlatformStatic;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.apache.http.HttpStatus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class j implements i {
    private String aAy;
    private String beh;
    private String fwe;
    private int fwf;
    private int fwg;
    private com.baidu.tieba.j.a.b fwj;
    private com.baidu.tieba.j.a.d fwk;
    private List<com.baidu.tieba.j.a.c> fwl;
    private long fwp;
    private long fwq;
    private long fwr;
    private boolean fws;
    private boolean fwv;
    private String fww;
    private List<b> fwx;
    private int fwy;
    private int mCurrentState;
    private int mError;
    private String mSource;
    private boolean fwt = true;
    private boolean fwu = false;
    private String fwd = UUID.randomUUID().toString();
    private Map<String, Long> fwi = new HashMap();
    private List<com.baidu.tieba.m.c> fwh = new ArrayList();
    private long fwm = 0;
    private long fwn = 0;
    private long fwo = 0;

    public j(String str, String str2, String str3) {
        this.mCurrentState = 0;
        this.mCurrentState = 0;
        this.beh = str;
        this.aAy = str2;
        this.fwe = str3;
    }

    @Override // com.baidu.tieba.j.i
    public void bbg() {
        this.fwm = System.currentTimeMillis();
        this.fwh.add(new com.baidu.tieba.m.a(3));
        this.mCurrentState = 0;
    }

    @Override // com.baidu.tieba.j.i
    public void rz(String str) {
        rE(str);
        this.fwh.add(new com.baidu.tieba.m.a(1));
        this.mCurrentState = 1;
    }

    private void rE(String str) {
        if (!StringUtils.isNull(str)) {
            this.fwg = VideoPlatformStatic.jm(str);
            if (this.fwg != 0) {
                this.fws = true;
            }
        }
    }

    @Override // com.baidu.tieba.j.i
    public void bbh() {
        this.fwh.add(new com.baidu.tieba.m.a(2));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void bbi() {
        if (this.mCurrentState != 2) {
            this.fwm = System.currentTimeMillis();
            this.fwh.add(new com.baidu.tieba.m.a(101));
            this.mCurrentState = 2;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void a(int i, String str, int i2, int i3, int i4, String str2, int i5) {
        this.fwm = System.currentTimeMillis();
        rE(str);
        this.fwh.add(new com.baidu.tieba.m.e(4, i, i2, i3, i4, str2, i5));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void qU(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.fwf = i;
            this.fwt = true;
            long currentTimeMillis = System.currentTimeMillis() - this.fwm;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = ErrDef.Feature.WEIGHT;
            }
            this.fwi.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.fwm = 0L;
            this.fwn = System.currentTimeMillis();
            this.fwh.add(new com.baidu.tieba.m.a(102));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void qV(int i) {
        if (this.mCurrentState == 5) {
            bbo();
        } else if (this.mCurrentState == 3) {
            this.fwf = i;
            this.fwh.add(new com.baidu.tieba.m.a(200));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void bbj() {
        if (this.fwn != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.fwo += currentTimeMillis - this.fwn;
            this.fwn = currentTimeMillis;
        }
        this.fwp++;
        this.fwr = System.currentTimeMillis();
        this.fwh.add(new com.baidu.tieba.m.a(201));
    }

    @Override // com.baidu.tieba.j.i
    public void bbk() {
        this.fwn = System.currentTimeMillis();
        if (this.fwr != 0) {
            this.fwq += System.currentTimeMillis() - this.fwr;
        }
        this.fwh.add(new com.baidu.tieba.m.a(202));
    }

    @Override // com.baidu.tieba.j.i
    public void bbl() {
        if (this.mCurrentState == 4 || this.mCurrentState == 3) {
            if (this.fwn != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.fwo += currentTimeMillis - this.fwn;
                this.fwn = currentTimeMillis;
            }
            this.fwh.add(new com.baidu.tieba.m.a(203));
            this.mCurrentState = 5;
        }
    }

    public void bbo() {
        if (this.mCurrentState == 5) {
            this.fwn = System.currentTimeMillis();
            this.fwh.add(new com.baidu.tieba.m.a(204));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void rA(String str) {
        if (this.mCurrentState != 8 && this.mCurrentState != 7 && this.mCurrentState != 6 && this.mCurrentState != -1) {
            this.mSource = VideoPlatformStatic.jn(str);
            bbq();
            this.fwh.add(new com.baidu.tieba.m.a(205));
            this.mCurrentState = 8;
            report();
        }
    }

    @Override // com.baidu.tieba.j.i
    public String rB(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.fwd;
        }
        this.mSource = VideoPlatformStatic.jn(str);
        bbq();
        this.fwi.put("stallDuration", Long.valueOf(this.fwq));
        this.fwh.add(new com.baidu.tieba.m.a(206));
        this.mCurrentState = 6;
        report();
        return this.fwd;
    }

    @Override // com.baidu.tieba.j.i
    public boolean rC(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1 || this.mCurrentState == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.jn(str);
        bbq();
        this.fwh.add(new com.baidu.tieba.m.a(HttpStatus.SC_MULTI_STATUS));
        this.mCurrentState = 7;
        report();
        return true;
    }

    @Override // com.baidu.tieba.j.i
    public void f(int i, int i2, String str) {
        if (i == -10000 || i == -24399 || i == -34399 || i == -300) {
            if (this.fwk == null && com.baidu.adp.lib.util.f.hB()) {
                this.fwk = new com.baidu.tieba.j.a.d(this.fwd);
                a(this.fwk);
            }
            if (this.fwk != null) {
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                this.fwk.a(new com.baidu.tieba.play.b.d(-200, i, i2, str));
            }
        } else if ("1".equals(com.baidu.tbadk.coreExtra.model.f.IA())) {
            if (this.fwj == null && com.baidu.adp.lib.util.f.hB()) {
                this.fwj = new com.baidu.tieba.j.a.b(this.fwd);
                a(this.fwj);
            }
            if (this.fwj != null) {
                if (this.fwj.size() == 0) {
                    this.fwy = i2;
                }
                this.fwj.a(new com.baidu.tieba.play.b.d(-200, i, i2, str));
            }
        }
    }

    private void a(com.baidu.tieba.j.a.c cVar) {
        if (this.fwl == null) {
            this.fwl = new ArrayList();
        }
        this.fwl.add(cVar);
    }

    @Override // com.baidu.tieba.j.i
    public String a(int i, int i2, int i3, String str, boolean z, long j, String str2) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.fwd;
        }
        this.fwf = i;
        this.fwt = false;
        this.fwu = z;
        this.mError = i3;
        this.mSource = VideoPlatformStatic.jn(str);
        bbq();
        if (!v.J(this.fwl)) {
            int size = this.fwl.size();
            for (int i4 = 0; i4 < size; i4++) {
                com.baidu.tieba.j.a.c cVar = this.fwl.get(i4);
                if (cVar != null) {
                    cVar.bbB();
                }
            }
        }
        this.fwh.add(new com.baidu.tieba.m.b(i, i2, i3, j, str2, bbp()));
        this.mCurrentState = -1;
        report();
        return this.fwd;
    }

    private com.baidu.tieba.j.a.e[] bbp() {
        if (this.fwl == null || this.fwl.size() == 0) {
            return null;
        }
        com.baidu.tieba.j.a.e[] eVarArr = new com.baidu.tieba.j.a.e[this.fwl.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.fwl.size()) {
                return eVarArr;
            }
            eVarArr[i2] = this.fwl.get(i2).bbz();
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void rD(String str) {
        this.fww = str;
    }

    private void bbq() {
        if (this.fwn != 0) {
            this.fwo += System.currentTimeMillis() - this.fwn;
        }
        this.fwi.put("playDuration", Long.valueOf(this.fwo));
        this.fwi.put("stallCount", Long.valueOf(this.fwp));
        this.fwi.put("stallDuration", Long.valueOf(this.fwq));
        if (!this.fwi.containsKey("loadingTime")) {
            this.fwi.put("loadingTime", 0L);
        }
        this.fwm = 0L;
        this.fwn = 0L;
        this.fwo = 0L;
        this.fwp = 0L;
        this.fwq = 0L;
        this.fwr = 0L;
    }

    @Override // com.baidu.tieba.j.i
    public void report() {
        if (!this.fwv) {
            int reportType = com.baidu.tbadk.coreExtra.model.f.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.f.Iv() || !this.fwt) && reportType != 3) {
                this.fwv = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.j.j.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.model.f.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", j.this.Ur());
                            jSONObject.put("kpiInfo", j.this.bbr());
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.fwt)) {
                                JSONObject bbs = j.this.bbs();
                                bbs.put("running", j.this.bbt());
                                jSONObject.put("debugInfo", bbs);
                            } else if (reportType2 == 2) {
                                jSONObject.put("debugInfo", j.this.bbs());
                            } else if (reportType2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.s.e.bFW().b(jSONObject, j.this.fwt ? false : true);
                        if (j.this.fwx != null) {
                            j.this.fwx.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject Ur() {
        JSONObject Ur = VideoPlatformStatic.Ur();
        if (this.fwx != null) {
            try {
                int size = this.fwx.size();
                for (int i = 0; i < size; i++) {
                    this.fwx.get(i).am(Ur);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return Ur;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bbr() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.fwi.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.fwi.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.fwi.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.fwi.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.fwi.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.fws ? 1 : 0);
            jSONObject.put("playSuccess", this.fwt ? 1 : 0);
            jSONObject.put("retryError", this.fwu ? 1 : 0);
            jSONObject.put(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR, this.mError);
            if (this.fwx != null) {
                int size = this.fwx.size();
                for (int i = 0; i < size; i++) {
                    this.fwx.get(i).an(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bbs() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uuid", this.fwd);
            if (!StringUtils.isNull(this.fwe)) {
                jSONObject.put("parentUuid", this.fwe);
            }
            jSONObject.put("tid", this.beh);
            jSONObject.put("videoUrl", this.aAy);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.gY(this.fwf));
            jSONObject.put("urlType", this.fwg);
            jSONObject.put("sub_error", this.fwy);
            jSONObject.put("current_pid", Process.myPid());
            if (!StringUtils.isNull(this.fww)) {
                jSONObject.put("error_stack", this.fww);
            }
            if (this.fwx != null) {
                int size = this.fwx.size();
                for (int i = 0; i < size; i++) {
                    this.fwx.get(i).ao(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray bbt() {
        JSONArray jSONArray = new JSONArray();
        if (this.fwh == null) {
            return jSONArray;
        }
        int size = this.fwh.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.fwh.get(i).bqV());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.j.i
    public void a(b bVar) {
        if (this.fwx == null) {
            this.fwx = new ArrayList();
        }
        this.fwx.add(bVar);
    }

    @Override // com.baidu.tieba.j.i
    public void jC(boolean z) {
        this.fwt = z;
    }

    @Override // com.baidu.tieba.j.i
    public String bbm() {
        return this.fwd;
    }

    @Override // com.baidu.tieba.j.i
    public String bbn() {
        return this.fwy + "";
    }
}
