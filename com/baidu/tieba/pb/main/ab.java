package com.baidu.tieba.pb.main;

import android.app.AlertDialog;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.channelrtc.medialivesender.LiveSenderControl;
import com.baidu.tbadk.img.WriteImagesInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements com.baidu.tbadk.editortool.x {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.tbadk.editortool.x
    public void a(int i, Object obj) {
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
        bj bjVar;
        bj bjVar2;
        String str3;
        bj bjVar3;
        bj bjVar4;
        String str4;
        boolean b;
        bj bjVar5;
        bc bcVar;
        boolean b2;
        boolean b3;
        boolean b4;
        if (i != 0) {
            if (i != 26) {
                if (i == 10) {
                    bcVar = this.a.y;
                    if (bcVar.p() == null) {
                        return;
                    }
                    b2 = this.a.b(11001);
                    if (!b2) {
                        return;
                    }
                    this.a.a((String) null);
                    return;
                } else if (i != 27) {
                    if (i == 4) {
                        str2 = this.a.p;
                        if (str2 != null) {
                            str3 = this.a.p;
                            if (str3.length() > 0) {
                                bjVar3 = this.a.E;
                                bjVar3.c(false);
                                bjVar4 = this.a.E;
                                bjVar4.d(false);
                                PbActivity pbActivity = this.a;
                                str4 = this.a.p;
                                pbActivity.showToast(str4);
                                return;
                            }
                        }
                        bjVar = this.a.E;
                        bjVar.c(true);
                        bjVar2 = this.a.E;
                        bjVar2.d(true);
                        return;
                    } else if (i == 22) {
                        writeImagesInfo8 = this.a.n;
                        int size = writeImagesInfo8.size();
                        writeImagesInfo9 = this.a.n;
                        if (size < writeImagesInfo9.getMaxImagesAllowed()) {
                            this.a.o = String.valueOf(System.currentTimeMillis());
                            PbActivity pbActivity2 = this.a;
                            str = this.a.o;
                            com.baidu.tbadk.core.util.bb.a(pbActivity2, str);
                            return;
                        }
                        this.a.showToast(String.format(this.a.getString(com.baidu.tieba.u.editor_mutiiamge_max), 10));
                        return;
                    } else if (i == 23) {
                        writeImagesInfo5 = this.a.n;
                        if (writeImagesInfo5 != null) {
                            writeImagesInfo6 = this.a.n;
                            if (!TextUtils.isEmpty(writeImagesInfo6.toJsonString())) {
                                PbActivity pbActivity3 = this.a;
                                writeImagesInfo7 = this.a.n;
                                com.baidu.tbadk.core.atomData.a aVar = new com.baidu.tbadk.core.atomData.a(pbActivity3, writeImagesInfo7.toJsonString());
                                aVar.setRequestCode(12002);
                                MessageManager.getInstance().sendMessage(new CustomMessage(2003001, aVar));
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
                                        if (size2 >= 1 && intValue >= 0 && intValue < size2) {
                                            MessageManager messageManager = MessageManager.getInstance();
                                            PbActivity pbActivity4 = this.a;
                                            writeImagesInfo4 = this.a.n;
                                            messageManager.sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.bj(pbActivity4, 12012, writeImagesInfo4, intValue)));
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
                        alertDialog = this.a.ai;
                        if (alertDialog == null) {
                            return;
                        }
                        alertDialog2 = this.a.ai;
                        alertDialog2.show();
                        return;
                    } else {
                        return;
                    }
                } else {
                    b = this.a.b(11027);
                    if (b) {
                        bjVar5 = this.a.E;
                        this.a.a(bjVar5.O());
                        return;
                    }
                    return;
                }
            }
            b3 = this.a.b(11026);
            if (b3) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.c(this.a, 12005, true)));
                return;
            }
            return;
        }
        b4 = this.a.b((int) LiveSenderControl.LiveSenderSampleRate.SAMPLINGRATE_11_025);
        if (b4) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.c(this.a, 12004, true)));
        }
    }
}
