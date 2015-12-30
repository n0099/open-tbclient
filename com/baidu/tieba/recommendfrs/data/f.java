package com.baidu.tieba.recommendfrs.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import java.util.ArrayList;
import java.util.List;
import tbclient.ExcFrsPage.ExcellentThreadInfo;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class f {
    private final TagInfo dpf;
    private DataRes dpg;
    private int dpj;
    private boolean hasMore;
    private int pn;
    private List<Object> ayw = new ArrayList();
    private boolean dph = false;
    private boolean dpk = false;
    private boolean dpl = false;

    public f(TagInfo tagInfo) {
        this.dpf = tagInfo;
    }

    public int getPn() {
        return this.pn;
    }

    public void c(DataRes dataRes) {
        this.dpg = dataRes;
    }

    public void mo(int i) {
        this.dpj = i;
    }

    public int ayk() {
        return this.dpj;
    }

    public boolean ayl() {
        return this.dpk;
    }

    public boolean aym() {
        return this.dpl;
    }

    public TagInfo ayn() {
        return this.dpf;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public void a(boolean z, h hVar, boolean z2) {
        if (z) {
            this.dpl = true;
        } else {
            this.dpk = true;
        }
        if (hVar != null) {
            this.pn = hVar.getPn();
            this.hasMore = hVar.getHasMore();
            List<Object> a = a(z2, hVar);
            if (z2) {
                this.ayw.addAll(a);
            } else {
                this.ayw = a;
            }
        }
    }

    private List<Object> a(boolean z, h hVar) {
        ArrayList arrayList = new ArrayList();
        if (hVar == null || hVar.getThreadList() == null) {
            return arrayList;
        }
        if (hVar.getThreadList() != null) {
            for (ExcellentThreadInfo excellentThreadInfo : hVar.getThreadList()) {
                if (excellentThreadInfo != null && (!z || !a(excellentThreadInfo))) {
                    j jVar = new j();
                    jVar.b(excellentThreadInfo);
                    jVar.setShowImage(hVar.ayq());
                    if (jVar.ayx() != 33) {
                        arrayList.add(jVar);
                    } else if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        arrayList.add(jVar);
                    }
                }
            }
        }
        return arrayList;
    }

    private boolean a(ExcellentThreadInfo excellentThreadInfo) {
        int size;
        if (excellentThreadInfo != null && (size = this.ayw.size()) > 0) {
            for (int i = 0; i < size; i++) {
                Object obj = this.ayw.get(i);
                if ((obj instanceof ExcellentThreadInfo) && excellentThreadInfo.excid == ((ExcellentThreadInfo) obj).excid) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<Object> ayo() {
        return this.ayw;
    }

    public void gP(boolean z) {
        this.dph = z;
    }
}
