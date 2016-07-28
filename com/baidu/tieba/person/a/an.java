package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tbadk.core.util.bn;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements View.OnClickListener {
    final /* synthetic */ am erm;
    private final /* synthetic */ com.baidu.tieba.person.data.m ern;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(am amVar, com.baidu.tieba.person.data.m mVar) {
        this.erm = amVar;
        this.ern = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        String str;
        BaseFragmentActivity baseFragmentActivity;
        BaseFragmentActivity baseFragmentActivity2;
        String str2;
        z = this.erm.cjo;
        if (z) {
            str2 = this.erm.erk;
            TiebaStatic.log(str2);
        } else {
            str = this.erm.erl;
            TiebaStatic.log(str);
        }
        baseFragmentActivity = this.erm.bgI;
        if (bn.ab(baseFragmentActivity.getActivity())) {
            String str3 = this.ern.mLink;
            if (!StringUtils.isNull(str3)) {
                bi us = bi.us();
                baseFragmentActivity2 = this.erm.bgI;
                us.c(baseFragmentActivity2.getPageContext(), new String[]{str3});
            }
        }
    }
}
