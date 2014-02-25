package com.baidu.tieba.pb;

import android.app.AlertDialog;
import com.baidu.tieba.album.AlbumActivity;
import com.baidu.tieba.img.WriteImagesInfo;
import com.baidu.tieba.write.AtListActivity;
import com.baidu.tieba.write.WriteMultiImgsActivity;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements com.baidu.tieba.editortool.z {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.tieba.editortool.z
    public void a(int i, Object obj) {
        WriteImagesInfo writeImagesInfo;
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        String str;
        String str2;
        cu cuVar;
        cu cuVar2;
        String str3;
        cu cuVar3;
        cu cuVar4;
        String str4;
        boolean a;
        cu cuVar5;
        com.baidu.tieba.model.bb bbVar;
        boolean a2;
        boolean a3;
        cu cuVar6;
        boolean a4;
        cu cuVar7;
        if (i != 0) {
            if (i != 26) {
                if (i == 10) {
                    bbVar = this.a.w;
                    if (bbVar.m() == null) {
                        return;
                    }
                    a2 = this.a.a(11001);
                    if (!a2) {
                        return;
                    }
                    this.a.a((String) null);
                    return;
                } else if (i != 27) {
                    if (i == 4) {
                        str2 = this.a.o;
                        if (str2 != null) {
                            str3 = this.a.o;
                            if (str3.length() > 0) {
                                cuVar3 = this.a.C;
                                cuVar3.c(false);
                                cuVar4 = this.a.C;
                                cuVar4.d(false);
                                NewPbActivity newPbActivity = this.a;
                                str4 = this.a.o;
                                newPbActivity.showToast(str4);
                                return;
                            }
                        }
                        cuVar = this.a.C;
                        cuVar.c(true);
                        cuVar2 = this.a.C;
                        cuVar2.d(true);
                        return;
                    } else if (i == 22) {
                        writeImagesInfo3 = this.a.m;
                        int size = writeImagesInfo3.size();
                        writeImagesInfo4 = this.a.m;
                        if (size < writeImagesInfo4.getMaxImagesAllowed()) {
                            this.a.n = String.valueOf(System.currentTimeMillis());
                            NewPbActivity newPbActivity2 = this.a;
                            str = this.a.n;
                            com.baidu.tieba.write.bz.a(newPbActivity2, str);
                            return;
                        }
                        this.a.showToast(String.format(this.a.getString(R.string.editor_mutiiamge_max), 10));
                        return;
                    } else if (i == 23) {
                        NewPbActivity newPbActivity3 = this.a;
                        writeImagesInfo2 = this.a.m;
                        AlbumActivity.a(newPbActivity3, writeImagesInfo2, 12002);
                        return;
                    } else if (i != 13) {
                        if (i != 7) {
                            if (i == 42) {
                                int intValue = ((Integer) obj).intValue();
                                NewPbActivity newPbActivity4 = this.a;
                                writeImagesInfo = this.a.m;
                                WriteMultiImgsActivity.a(newPbActivity4, 12012, writeImagesInfo, intValue);
                                return;
                            }
                            return;
                        }
                        alertDialog = this.a.Z;
                        if (alertDialog == null) {
                            return;
                        }
                        alertDialog2 = this.a.Z;
                        alertDialog2.show();
                        return;
                    } else {
                        return;
                    }
                } else {
                    a = this.a.a(11027);
                    if (a) {
                        cuVar5 = this.a.C;
                        this.a.a(cuVar5.K());
                        return;
                    }
                    return;
                }
            }
            a3 = this.a.a(11026);
            if (a3) {
                NewPbActivity newPbActivity5 = this.a;
                cuVar6 = this.a.C;
                newPbActivity5.D = cuVar6.ad();
                AtListActivity.a(this.a, 12005, true);
                return;
            }
            return;
        }
        a4 = this.a.a(11025);
        if (a4) {
            NewPbActivity newPbActivity6 = this.a;
            cuVar7 = this.a.C;
            newPbActivity6.D = cuVar7.ad();
            AtListActivity.a(this.a, 12004, true);
        }
    }
}
