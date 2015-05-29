package com.baidu.tieba.tbadkCore.util;
/* loaded from: classes.dex */
class h implements com.baidu.tbadk.core.dialog.d {
    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.sharedPref.b.sl().putBoolean("anti_vcode_no_longer_tip", true);
        aVar.dismiss();
    }
}
