package com.baidu.tieba.personPolymeric.b;

import android.content.Context;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements PersonPostModel.b {
    final /* synthetic */ ak eVM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ak akVar) {
        this.eVM = akVar;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
    public void a(PersonPostModel personPostModel, boolean z) {
        com.baidu.tieba.personPolymeric.d.ac acVar;
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        com.baidu.tieba.personPolymeric.d.ac acVar2;
        i iVar;
        TbPageContext tbPageContext3;
        acVar = this.eVM.eVF;
        acVar.ahs();
        if (personPostModel != null) {
            tbPageContext3 = this.eVM.aat;
            com.baidu.adp.lib.util.k.showToast(tbPageContext3.getContext(), personPostModel.getErrorString());
        } else {
            tbPageContext = this.eVM.aat;
            Context context = tbPageContext.getContext();
            tbPageContext2 = this.eVM.aat;
            com.baidu.adp.lib.util.k.showToast(context, tbPageContext2.getString(w.l.data_load_error));
        }
        if (z) {
            acVar2 = this.eVM.eVF;
            acVar2.ao(null);
            iVar = this.eVM.eVJ;
            iVar.WU();
        }
    }
}
