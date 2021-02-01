package com.baidu.tieba.lego.model;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.cache.l;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.af;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.lego.model.LegoPageModel;
import com.squareup.wire.Wire;
import java.io.IOException;
import tbclient.Lego.DataRes;
/* loaded from: classes9.dex */
public class c implements a {
    private LegoPageModel lfZ;
    private b lga;
    private LegoPageModel.a lgb = new LegoPageModel.a() { // from class: com.baidu.tieba.lego.model.c.1
        @Override // com.baidu.tieba.lego.model.LegoPageModel.a
        public void a(long j, String str, DataRes dataRes, boolean z, int i) {
            if (c.this.lga != null) {
                c.this.lga.a(true, dataRes, !z, j, str, i);
            }
        }

        @Override // com.baidu.tieba.lego.model.LegoPageModel.a
        public void b(long j, String str, DataRes dataRes, boolean z) {
            if (c.this.lga != null) {
                c.this.lga.a(j, str, dataRes, z);
            }
        }

        @Override // com.baidu.tieba.lego.model.LegoPageModel.a
        public void b(long j, String str, int i, String str2) {
            if (c.this.lga != null) {
                c.this.lga.a(j, str, str2, i);
            }
        }
    };

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.lfZ = new LegoPageModel(tbPageContext, bdUniqueId);
        this.lfZ.a(this.lgb);
    }

    @Override // com.baidu.tieba.lego.model.a
    public void a(int i, long j, String str, int i2, String str2) {
        if (this.lfZ != null) {
            this.lfZ.b(i, j, str, i2, str2);
        }
    }

    @Override // com.baidu.tieba.lego.model.a
    public void w(final long j, final String str) {
        final l<byte[]> Ar = com.baidu.tbadk.core.c.a.bqr().Ar("tb.lego_update");
        af.a(new ae<DataRes>() { // from class: com.baidu.tieba.lego.model.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ae
            /* renamed from: dbf */
            public DataRes doInBackground() {
                byte[] bArr = (byte[]) Ar.get(j + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + (TextUtils.isEmpty(str) ? "" : str));
                if (bArr == null || bArr.length == 0) {
                    return null;
                }
                try {
                    return (DataRes) new Wire(new Class[0]).parseFrom(bArr, DataRes.class);
                } catch (IOException e) {
                    return null;
                }
            }
        }, new m<DataRes>() { // from class: com.baidu.tieba.lego.model.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: c */
            public void onReturnDataInUI(DataRes dataRes) {
                c.this.a(j, str, dataRes);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, String str, DataRes dataRes) {
        if (j >= 0) {
            if (this.lga != null) {
                this.lga.a(false, dataRes, false, j, str, 1);
            }
            this.lfZ.b(2, j, str, 1, "");
        }
    }

    @Override // com.baidu.tieba.lego.model.a
    public void a(b bVar) {
        this.lga = bVar;
    }
}
