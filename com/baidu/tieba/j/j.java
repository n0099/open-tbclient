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
    private String fwd;
    private int fwe;
    private int fwf;
    private com.baidu.tieba.j.a.b fwi;
    private com.baidu.tieba.j.a.d fwj;
    private List<com.baidu.tieba.j.a.c> fwk;
    private long fwo;
    private long fwp;
    private long fwq;
    private boolean fwr;
    private boolean fwu;
    private String fwv;
    private List<b> fww;
    private int fwx;
    private int mCurrentState;
    private int mError;
    private String mSource;
    private boolean fws = true;
    private boolean fwt = false;
    private String fwc = UUID.randomUUID().toString();
    private Map<String, Long> fwh = new HashMap();
    private List<com.baidu.tieba.m.c> fwg = new ArrayList();
    private long fwl = 0;
    private long fwm = 0;
    private long fwn = 0;

    public j(String str, String str2, String str3) {
        this.mCurrentState = 0;
        this.mCurrentState = 0;
        this.beh = str;
        this.aAy = str2;
        this.fwd = str3;
    }

    @Override // com.baidu.tieba.j.i
    public void bbg() {
        this.fwl = System.currentTimeMillis();
        this.fwg.add(new com.baidu.tieba.m.a(3));
        this.mCurrentState = 0;
    }

    @Override // com.baidu.tieba.j.i
    public void rz(String str) {
        rE(str);
        this.fwg.add(new com.baidu.tieba.m.a(1));
        this.mCurrentState = 1;
    }

    private void rE(String str) {
        if (!StringUtils.isNull(str)) {
            this.fwf = VideoPlatformStatic.jm(str);
            if (this.fwf != 0) {
                this.fwr = true;
            }
        }
    }

    @Override // com.baidu.tieba.j.i
    public void bbh() {
        this.fwg.add(new com.baidu.tieba.m.a(2));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void bbi() {
        if (this.mCurrentState != 2) {
            this.fwl = System.currentTimeMillis();
            this.fwg.add(new com.baidu.tieba.m.a(101));
            this.mCurrentState = 2;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void a(int i, String str, int i2, int i3, int i4, String str2, int i5) {
        this.fwl = System.currentTimeMillis();
        rE(str);
        this.fwg.add(new com.baidu.tieba.m.e(4, i, i2, i3, i4, str2, i5));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void qU(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.fwe = i;
            this.fws = true;
            long currentTimeMillis = System.currentTimeMillis() - this.fwl;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = ErrDef.Feature.WEIGHT;
            }
            this.fwh.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.fwl = 0L;
            this.fwm = System.currentTimeMillis();
            this.fwg.add(new com.baidu.tieba.m.a(102));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void qV(int i) {
        if (this.mCurrentState == 5) {
            bbo();
        } else if (this.mCurrentState == 3) {
            this.fwe = i;
            this.fwg.add(new com.baidu.tieba.m.a(200));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void bbj() {
        if (this.fwm != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.fwn += currentTimeMillis - this.fwm;
            this.fwm = currentTimeMillis;
        }
        this.fwo++;
        this.fwq = System.currentTimeMillis();
        this.fwg.add(new com.baidu.tieba.m.a(201));
    }

    @Override // com.baidu.tieba.j.i
    public void bbk() {
        this.fwm = System.currentTimeMillis();
        if (this.fwq != 0) {
            this.fwp += System.currentTimeMillis() - this.fwq;
        }
        this.fwg.add(new com.baidu.tieba.m.a(202));
    }

    @Override // com.baidu.tieba.j.i
    public void bbl() {
        if (this.mCurrentState == 4 || this.mCurrentState == 3) {
            if (this.fwm != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.fwn += currentTimeMillis - this.fwm;
                this.fwm = currentTimeMillis;
            }
            this.fwg.add(new com.baidu.tieba.m.a(203));
            this.mCurrentState = 5;
        }
    }

    public void bbo() {
        if (this.mCurrentState == 5) {
            this.fwm = System.currentTimeMillis();
            this.fwg.add(new com.baidu.tieba.m.a(204));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void rA(String str) {
        if (this.mCurrentState != 8 && this.mCurrentState != 7 && this.mCurrentState != 6 && this.mCurrentState != -1) {
            this.mSource = VideoPlatformStatic.jn(str);
            bbq();
            this.fwg.add(new com.baidu.tieba.m.a(205));
            this.mCurrentState = 8;
            report();
        }
    }

    @Override // com.baidu.tieba.j.i
    public String rB(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.fwc;
        }
        this.mSource = VideoPlatformStatic.jn(str);
        bbq();
        this.fwh.put("stallDuration", Long.valueOf(this.fwp));
        this.fwg.add(new com.baidu.tieba.m.a(206));
        this.mCurrentState = 6;
        report();
        return this.fwc;
    }

    @Override // com.baidu.tieba.j.i
    public boolean rC(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1 || this.mCurrentState == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.jn(str);
        bbq();
        this.fwg.add(new com.baidu.tieba.m.a(HttpStatus.SC_MULTI_STATUS));
        this.mCurrentState = 7;
        report();
        return true;
    }

    @Override // com.baidu.tieba.j.i
    public void f(int i, int i2, String str) {
        if (i == -10000 || i == -24399 || i == -34399 || i == -300) {
            if (this.fwj == null && com.baidu.adp.lib.util.f.hB()) {
                this.fwj = new com.baidu.tieba.j.a.d(this.fwc);
                a(this.fwj);
            }
            if (this.fwj != null) {
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                this.fwj.a(new com.baidu.tieba.play.b.d(-200, i, i2, str));
            }
        } else if ("1".equals(com.baidu.tbadk.coreExtra.model.f.IA())) {
            if (this.fwi == null && com.baidu.adp.lib.util.f.hB()) {
                this.fwi = new com.baidu.tieba.j.a.b(this.fwc);
                a(this.fwi);
            }
            if (this.fwi != null) {
                if (this.fwi.size() == 0) {
                    this.fwx = i2;
                }
                this.fwi.a(new com.baidu.tieba.play.b.d(-200, i, i2, str));
            }
        }
    }

    private void a(com.baidu.tieba.j.a.c cVar) {
        if (this.fwk == null) {
            this.fwk = new ArrayList();
        }
        this.fwk.add(cVar);
    }

    @Override // com.baidu.tieba.j.i
    public String a(int i, int i2, int i3, String str, boolean z, long j, String str2) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.fwc;
        }
        this.fwe = i;
        this.fws = false;
        this.fwt = z;
        this.mError = i3;
        this.mSource = VideoPlatformStatic.jn(str);
        bbq();
        if (!v.J(this.fwk)) {
            int size = this.fwk.size();
            for (int i4 = 0; i4 < size; i4++) {
                com.baidu.tieba.j.a.c cVar = this.fwk.get(i4);
                if (cVar != null) {
                    cVar.bbB();
                }
            }
        }
        this.fwg.add(new com.baidu.tieba.m.b(i, i2, i3, j, str2, bbp()));
        this.mCurrentState = -1;
        report();
        return this.fwc;
    }

    private com.baidu.tieba.j.a.e[] bbp() {
        if (this.fwk == null || this.fwk.size() == 0) {
            return null;
        }
        com.baidu.tieba.j.a.e[] eVarArr = new com.baidu.tieba.j.a.e[this.fwk.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.fwk.size()) {
                return eVarArr;
            }
            eVarArr[i2] = this.fwk.get(i2).bbz();
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void rD(String str) {
        this.fwv = str;
    }

    private void bbq() {
        if (this.fwm != 0) {
            this.fwn += System.currentTimeMillis() - this.fwm;
        }
        this.fwh.put("playDuration", Long.valueOf(this.fwn));
        this.fwh.put("stallCount", Long.valueOf(this.fwo));
        this.fwh.put("stallDuration", Long.valueOf(this.fwp));
        if (!this.fwh.containsKey("loadingTime")) {
            this.fwh.put("loadingTime", 0L);
        }
        this.fwl = 0L;
        this.fwm = 0L;
        this.fwn = 0L;
        this.fwo = 0L;
        this.fwp = 0L;
        this.fwq = 0L;
    }

    @Override // com.baidu.tieba.j.i
    public void report() {
        if (!this.fwu) {
            int reportType = com.baidu.tbadk.coreExtra.model.f.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.f.Iv() || !this.fws) && reportType != 3) {
                this.fwu = true;
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
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.fws)) {
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
                        com.baidu.tieba.s.e.bFW().b(jSONObject, j.this.fws ? false : true);
                        if (j.this.fww != null) {
                            j.this.fww.clear();
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
        if (this.fww != null) {
            try {
                int size = this.fww.size();
                for (int i = 0; i < size; i++) {
                    this.fww.get(i).am(Ur);
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
            for (Map.Entry<String, Long> entry : this.fwh.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.fwh.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.fwh.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.fwh.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.fwh.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.fwr ? 1 : 0);
            jSONObject.put("playSuccess", this.fws ? 1 : 0);
            jSONObject.put("retryError", this.fwt ? 1 : 0);
            jSONObject.put(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR, this.mError);
            if (this.fww != null) {
                int size = this.fww.size();
                for (int i = 0; i < size; i++) {
                    this.fww.get(i).an(jSONObject);
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
            jSONObject.put("uuid", this.fwc);
            if (!StringUtils.isNull(this.fwd)) {
                jSONObject.put("parentUuid", this.fwd);
            }
            jSONObject.put("tid", this.beh);
            jSONObject.put("videoUrl", this.aAy);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.gY(this.fwe));
            jSONObject.put("urlType", this.fwf);
            jSONObject.put("sub_error", this.fwx);
            jSONObject.put("current_pid", Process.myPid());
            if (!StringUtils.isNull(this.fwv)) {
                jSONObject.put("error_stack", this.fwv);
            }
            if (this.fww != null) {
                int size = this.fww.size();
                for (int i = 0; i < size; i++) {
                    this.fww.get(i).ao(jSONObject);
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
        if (this.fwg == null) {
            return jSONArray;
        }
        int size = this.fwg.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.fwg.get(i).bqV());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.j.i
    public void a(b bVar) {
        if (this.fww == null) {
            this.fww = new ArrayList();
        }
        this.fww.add(bVar);
    }

    @Override // com.baidu.tieba.j.i
    public void jC(boolean z) {
        this.fws = z;
    }

    @Override // com.baidu.tieba.j.i
    public String bbm() {
        return this.fwc;
    }

    @Override // com.baidu.tieba.j.i
    public String bbn() {
        return this.fwx + "";
    }
}
