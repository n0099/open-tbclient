package com.baidu.tieba.personPolymeric.b;

import android.content.Context;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements PersonPostModel.b {
    final /* synthetic */ aj eLE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(aj ajVar) {
        this.eLE = ajVar;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
    public void a(PersonPostModel personPostModel, boolean z) {
        com.baidu.tieba.personPolymeric.d.ac acVar;
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        com.baidu.tieba.personPolymeric.d.ac acVar2;
        i iVar;
        TbPageContext tbPageContext3;
        acVar = this.eLE.eLA;
        acVar.Tx();
        if (personPostModel != null) {
            tbPageContext3 = this.eLE.aas;
            com.baidu.adp.lib.util.k.showToast(tbPageContext3.getContext(), personPostModel.getErrorString());
        } else {
            tbPageContext = this.eLE.aas;
            Context context = tbPageContext.getContext();
            tbPageContext2 = this.eLE.aas;
            com.baidu.adp.lib.util.k.showToast(context, tbPageContext2.getString(w.l.data_load_error));
        }
        if (z) {
            acVar2 = this.eLE.eLA;
            acVar2.an(null);
            iVar = this.eLE.bwJ;
            iVar.VD();
        }
    }
}
