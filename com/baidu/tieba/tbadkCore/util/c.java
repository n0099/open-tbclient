package com.baidu.tieba.tbadkCore.util;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class c implements a.b {
    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.sharedPref.b.uO().putBoolean("anti_vcode_no_longer_tip", true);
        aVar.dismiss();
    }
}
