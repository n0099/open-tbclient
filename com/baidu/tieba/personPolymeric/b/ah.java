package com.baidu.tieba.personPolymeric.b;

import android.content.Context;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements PersonPostModel.b {
    final /* synthetic */ ab eCS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ab abVar) {
        this.eCS = abVar;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
    public void a(PersonPostModel personPostModel, boolean z) {
        com.baidu.tieba.personPolymeric.d.ab abVar;
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        com.baidu.tieba.personPolymeric.d.ab abVar2;
        com.baidu.tieba.personPolymeric.d.ab abVar3;
        TbPageContext tbPageContext3;
        abVar = this.eCS.eCL;
        abVar.acw();
        if (personPostModel != null) {
            tbPageContext3 = this.eCS.aat;
            com.baidu.adp.lib.util.k.showToast(tbPageContext3.getContext(), personPostModel.getErrorString());
        } else {
            tbPageContext = this.eCS.aat;
            Context context = tbPageContext.getContext();
            tbPageContext2 = this.eCS.aat;
            com.baidu.adp.lib.util.k.showToast(context, tbPageContext2.getString(w.l.data_load_error));
        }
        if (z) {
            abVar2 = this.eCS.eCL;
            abVar2.an(null);
            abVar3 = this.eCS.eCL;
            abVar3.UA();
        }
    }
}
