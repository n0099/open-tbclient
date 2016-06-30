package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tbadk.core.util.bn;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements View.OnClickListener {
    final /* synthetic */ ao ehn;
    private final /* synthetic */ com.baidu.tieba.person.data.n eho;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ao aoVar, com.baidu.tieba.person.data.n nVar) {
        this.ehn = aoVar;
        this.eho = nVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        String str;
        BaseFragmentActivity baseFragmentActivity;
        BaseFragmentActivity baseFragmentActivity2;
        String str2;
        z = this.ehn.chd;
        if (z) {
            str2 = this.ehn.ehl;
            TiebaStatic.log(str2);
        } else {
            str = this.ehn.ehm;
            TiebaStatic.log(str);
        }
        baseFragmentActivity = this.ehn.bfw;
        if (bn.ab(baseFragmentActivity.getActivity())) {
            String str3 = this.eho.mLink;
            if (!StringUtils.isNull(str3)) {
                bi us = bi.us();
                baseFragmentActivity2 = this.ehn.bfw;
                us.c(baseFragmentActivity2.getPageContext(), new String[]{str3});
            }
        }
    }
}
