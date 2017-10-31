package com.baidu.tieba.monitor.a;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.baidu.tieba.monitor.VideoMonitorStatic;
import com.baidu.tieba.monitor.a.c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends c.a {
    private final int exD;
    private final int exE;
    private List<com.baidu.tieba.play.c.c> exp;
    private final int what;

    public b(int i, int i2, int i3, List<com.baidu.tieba.play.c.c> list) {
        super(300);
        this.exD = i;
        this.what = i2;
        this.exE = i3;
        if (list != null) {
            this.exp = new ArrayList(list);
        }
    }

    @Override // com.baidu.tieba.monitor.a.c.a, com.baidu.tieba.monitor.a.c
    public JSONObject aNk() {
        JSONObject aNk = super.aNk();
        StringBuilder sb = new StringBuilder();
        if (this.exD == -200) {
            sb.append(TbadkCoreApplication.getInst().getString(d.j.player_ijk));
        } else if (this.exD == -100) {
            sb.append(TbadkCoreApplication.getInst().getString(d.j.player_system));
        } else {
            sb.append(TbadkCoreApplication.getInst().getString(d.j.player_unknown));
        }
        sb.append(" -- -- -- ");
        if (this.exp != null) {
            int size = this.exp.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.play.c.c cVar = this.exp.get(i);
                sb.append(TbadkCoreApplication.getInst().getString(d.j.sub_error)).append(" -- -- -- ");
                sb.append("what").append(": ").append(cVar.what).append(": ").append(VideoMonitorStatic.pc(cVar.what)).append(" -- -- -- ");
                sb.append("extra").append(": ").append(cVar.exE).append(": ").append(VideoMonitorStatic.pc(cVar.exE)).append(" -- -- -- ");
            }
        }
        sb.append(TbadkCoreApplication.getInst().getString(d.j.final_error)).append(" -- -- -- ");
        sb.append("what").append(": ").append(this.what).append(": ").append(VideoMonitorStatic.pc(this.what)).append(" -- -- -- ");
        sb.append("extra").append(": ").append(this.exE).append(": ").append(VideoMonitorStatic.pc(this.exE));
        try {
            aNk.put("ext", new JSONObject().put(PushConstants.EXTRA_ERROR_CODE, sb.toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aNk;
    }
}
