package com.baidu.tieba.lego.model;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.cache.l;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
import com.baidu.tieba.lego.model.LegoPageModel;
import com.squareup.wire.Wire;
import java.io.IOException;
import tbclient.Lego.DataRes;
/* loaded from: classes8.dex */
public class c implements a {
    private LegoPageModel kXV;
    private b kXW;
    private LegoPageModel.a kXX = new LegoPageModel.a() { // from class: com.baidu.tieba.lego.model.c.1
        @Override // com.baidu.tieba.lego.model.LegoPageModel.a
        public void a(long j, String str, DataRes dataRes, boolean z, int i) {
            if (c.this.kXW != null) {
                c.this.kXW.a(true, dataRes, !z, j, str, i);
            }
        }

        @Override // com.baidu.tieba.lego.model.LegoPageModel.a
        public void b(long j, String str, DataRes dataRes, boolean z) {
            if (c.this.kXW != null) {
                c.this.kXW.a(j, str, dataRes, z);
            }
        }

        @Override // com.baidu.tieba.lego.model.LegoPageModel.a
        public void b(long j, String str, int i, String str2) {
            if (c.this.kXW != null) {
                c.this.kXW.a(j, str, str2, i);
            }
        }
    };

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.kXV = new LegoPageModel(tbPageContext, bdUniqueId);
        this.kXV.a(this.kXX);
    }

    @Override // com.baidu.tieba.lego.model.a
    public void a(int i, long j, String str, int i2, String str2) {
        if (this.kXV != null) {
            this.kXV.b(i, j, str, i2, str2);
        }
    }

    @Override // com.baidu.tieba.lego.model.a
    public void v(final long j, final String str) {
        final l<byte[]> Aa = com.baidu.tbadk.core.c.a.bpZ().Aa("tb.lego_update");
        ac.a(new ab<DataRes>() { // from class: com.baidu.tieba.lego.model.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: cZh */
            public DataRes doInBackground() {
                byte[] bArr = (byte[]) Aa.get(j + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + (TextUtils.isEmpty(str) ? "" : str));
                if (bArr == null || bArr.length == 0) {
                    return null;
                }
                try {
                    return (DataRes) new Wire(new Class[0]).parseFrom(bArr, DataRes.class);
                } catch (IOException e) {
                    return null;
                }
            }
        }, new com.baidu.tbadk.util.l<DataRes>() { // from class: com.baidu.tieba.lego.model.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: c */
            public void onReturnDataInUI(DataRes dataRes) {
                c.this.a(j, str, dataRes);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, String str, DataRes dataRes) {
        if (j >= 0) {
            if (this.kXW != null) {
                this.kXW.a(false, dataRes, false, j, str, 1);
            }
            this.kXV.b(2, j, str, 1, "");
        }
    }

    @Override // com.baidu.tieba.lego.model.a
    public void a(b bVar) {
        this.kXW = bVar;
    }
}
