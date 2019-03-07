package com.baidu.tieba.lego.model;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.lego.model.LegoPageModel;
import com.squareup.wire.Wire;
import java.io.IOException;
import tbclient.Lego.DataRes;
/* loaded from: classes2.dex */
public class c implements a {
    private LegoPageModel gLr;
    private b gLs;
    private LegoPageModel.a gLt = new LegoPageModel.a() { // from class: com.baidu.tieba.lego.model.c.1
        @Override // com.baidu.tieba.lego.model.LegoPageModel.a
        public void a(long j, String str, DataRes dataRes, boolean z, int i) {
            if (c.this.gLs != null) {
                c.this.gLs.a(true, dataRes, !z, j, str, i);
            }
        }

        @Override // com.baidu.tieba.lego.model.LegoPageModel.a
        public void b(long j, String str, DataRes dataRes, boolean z) {
            if (c.this.gLs != null) {
                c.this.gLs.a(j, str, dataRes, z);
            }
        }

        @Override // com.baidu.tieba.lego.model.LegoPageModel.a
        public void b(long j, String str, int i, String str2) {
            if (c.this.gLs != null) {
                c.this.gLs.a(j, str, str2, i);
            }
        }
    };

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.gLr = new LegoPageModel(tbPageContext, bdUniqueId);
        this.gLr.a(this.gLt);
    }

    @Override // com.baidu.tieba.lego.model.a
    public void a(int i, long j, String str, int i2, String str2) {
        if (this.gLr != null) {
            this.gLr.b(i, j, str, i2, str2);
        }
    }

    @Override // com.baidu.tieba.lego.model.a
    public void p(final long j, final String str) {
        final l<byte[]> lu = com.baidu.tbadk.core.c.a.aaW().lu("tb.lego_update");
        aa.a(new z<DataRes>() { // from class: com.baidu.tieba.lego.model.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.z
            /* renamed from: bzu */
            public DataRes doInBackground() {
                byte[] bArr = (byte[]) lu.get(j + "_" + (TextUtils.isEmpty(str) ? "" : str));
                if (bArr == null || bArr.length == 0) {
                    return null;
                }
                try {
                    return (DataRes) new Wire(new Class[0]).parseFrom(bArr, DataRes.class);
                } catch (IOException e) {
                    return null;
                }
            }
        }, new k<DataRes>() { // from class: com.baidu.tieba.lego.model.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.k
            /* renamed from: c */
            public void onReturnDataInUI(DataRes dataRes) {
                c.this.a(j, str, dataRes);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, String str, DataRes dataRes) {
        if (j >= 0) {
            if (this.gLs != null) {
                this.gLs.a(false, dataRes, false, j, str, 1);
            }
            this.gLr.b(2, j, str, 1, "");
        }
    }

    @Override // com.baidu.tieba.lego.model.a
    public void a(b bVar) {
        this.gLs = bVar;
    }
}
