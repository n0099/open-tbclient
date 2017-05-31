package com.baidu.tieba.tbadkCore.util;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.b {
    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("anti_vcode_no_longer_tip", true);
        aVar.dismiss();
    }
}
