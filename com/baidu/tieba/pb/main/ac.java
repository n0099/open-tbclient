package com.baidu.tieba.pb.main;

import android.app.AlertDialog;
import android.text.TextUtils;
import com.baidu.tbadk.img.WriteImagesInfo;
/* loaded from: classes.dex */
final class ac implements com.baidu.tbadk.editortool.x {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.tbadk.editortool.x
    public final void a(int i, Object obj) {
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        WriteImagesInfo writeImagesInfo5;
        WriteImagesInfo writeImagesInfo6;
        WriteImagesInfo writeImagesInfo7;
        WriteImagesInfo writeImagesInfo8;
        WriteImagesInfo writeImagesInfo9;
        String str;
        String str2;
        bm bmVar;
        bm bmVar2;
        String str3;
        bm bmVar3;
        bm bmVar4;
        String str4;
        boolean a;
        bm bmVar5;
        bf bfVar;
        boolean a2;
        boolean a3;
        boolean a4;
        if (i != 0) {
            if (i != 26) {
                if (i == 10) {
                    bfVar = this.a.x;
                    if (bfVar.p() == null) {
                        return;
                    }
                    a2 = this.a.a(11001);
                    if (!a2) {
                        return;
                    }
                    this.a.d((String) null);
                    return;
                } else if (i != 27) {
                    if (i == 4) {
                        str2 = this.a.p;
                        if (str2 != null) {
                            str3 = this.a.p;
                            if (str3.length() > 0) {
                                bmVar3 = this.a.D;
                                bmVar3.c(false);
                                bmVar4 = this.a.D;
                                bmVar4.d(false);
                                PbActivity pbActivity = this.a;
                                str4 = this.a.p;
                                pbActivity.showToast(str4);
                                return;
                            }
                        }
                        bmVar = this.a.D;
                        bmVar.c(true);
                        bmVar2 = this.a.D;
                        bmVar2.d(true);
                        return;
                    } else if (i == 22) {
                        writeImagesInfo8 = this.a.n;
                        int size = writeImagesInfo8.size();
                        writeImagesInfo9 = this.a.n;
                        if (size < writeImagesInfo9.getMaxImagesAllowed()) {
                            this.a.o = String.valueOf(System.currentTimeMillis());
                            PbActivity pbActivity2 = this.a;
                            str = this.a.o;
                            com.baidu.tbadk.core.util.az.a(pbActivity2, str);
                            return;
                        }
                        this.a.showToast(String.format(this.a.getString(com.baidu.tieba.a.k.editor_mutiiamge_max), 10));
                        return;
                    } else if (i == 23) {
                        writeImagesInfo5 = this.a.n;
                        if (writeImagesInfo5 != null) {
                            writeImagesInfo6 = this.a.n;
                            if (!TextUtils.isEmpty(writeImagesInfo6.toJsonString())) {
                                PbActivity pbActivity3 = this.a;
                                writeImagesInfo7 = this.a.n;
                                com.baidu.tbadk.core.b.a aVar = new com.baidu.tbadk.core.b.a(pbActivity3, writeImagesInfo7.toJsonString());
                                aVar.a(12002);
                                com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, aVar));
                                return;
                            }
                            return;
                        }
                        return;
                    } else if (i != 13) {
                        if (i != 7) {
                            if (i == 42) {
                                int intValue = ((Integer) obj).intValue();
                                writeImagesInfo = this.a.n;
                                if (writeImagesInfo != null) {
                                    writeImagesInfo2 = this.a.n;
                                    if (writeImagesInfo2.getChosedFiles() != null) {
                                        writeImagesInfo3 = this.a.n;
                                        int size2 = writeImagesInfo3.getChosedFiles().size();
                                        if (size2 > 0 && intValue >= 0 && intValue < size2) {
                                            com.baidu.adp.framework.c a5 = com.baidu.adp.framework.c.a();
                                            PbActivity pbActivity4 = this.a;
                                            writeImagesInfo4 = this.a.n;
                                            a5.a(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.ax(pbActivity4, 12012, writeImagesInfo4, intValue)));
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        alertDialog = this.a.ah;
                        if (alertDialog == null) {
                            return;
                        }
                        alertDialog2 = this.a.ah;
                        alertDialog2.show();
                        return;
                    } else {
                        return;
                    }
                } else {
                    a = this.a.a(11027);
                    if (a) {
                        bmVar5 = this.a.D;
                        this.a.d(bmVar5.O());
                        return;
                    }
                    return;
                }
            }
            a3 = this.a.a(11026);
            if (a3) {
                com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.c(this.a, 12005, true)));
                return;
            }
            return;
        }
        a4 = this.a.a(11025);
        if (a4) {
            com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.c(this.a, 12004, true)));
        }
    }
}
