package com.baidu.tieba.pb.main;

import android.app.AlertDialog;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.channelrtc.medialivesender.LiveSenderControl;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.BaobaoSdkDelegate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements com.baidu.tbadk.editortool.w {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void a(int i, Object obj) {
        WriteImagesInfo writeImagesInfo;
        WriteData writeData;
        WriteImagesInfo writeImagesInfo2;
        WriteData writeData2;
        BaobaoSdkDelegate baobaoSdkDelegate;
        bl blVar;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        WriteImagesInfo writeImagesInfo5;
        WriteImagesInfo writeImagesInfo6;
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        AlertDialog alertDialog3;
        WriteImagesInfo writeImagesInfo7;
        WriteImagesInfo writeImagesInfo8;
        WriteImagesInfo writeImagesInfo9;
        WriteImagesInfo writeImagesInfo10;
        WriteImagesInfo writeImagesInfo11;
        String str;
        String str2;
        bs bsVar;
        bs bsVar2;
        String str3;
        bs bsVar3;
        bs bsVar4;
        String str4;
        boolean b;
        bs bsVar5;
        bl blVar2;
        boolean b2;
        bs bsVar6;
        boolean b3;
        bs bsVar7;
        boolean b4;
        if (i == 0) {
            bsVar7 = this.a.E;
            if (bsVar7.ah()) {
                this.a.showToast(com.baidu.tieba.x.over_limit_tip);
                return;
            }
            b4 = this.a.b((int) LiveSenderControl.LiveSenderSampleRate.SAMPLINGRATE_11_025);
            if (b4) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.d(this.a, 12004, true)));
            }
        } else if (i == 26) {
            bsVar6 = this.a.E;
            if (bsVar6.ai()) {
                this.a.showToast(com.baidu.tieba.x.over_limit_tip);
                return;
            }
            b3 = this.a.b(11026);
            if (b3) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.d(this.a, 12005, true)));
            }
        } else if (i == 10) {
            blVar2 = this.a.y;
            if (blVar2.r() == null) {
                return;
            }
            b2 = this.a.b(11001);
            if (!b2) {
                return;
            }
            this.a.b((String) null);
        } else if (i != 27) {
            if (i == 4) {
                str2 = this.a.q;
                if (str2 != null) {
                    str3 = this.a.q;
                    if (str3.length() > 0) {
                        bsVar3 = this.a.E;
                        bsVar3.c(false);
                        bsVar4 = this.a.E;
                        bsVar4.d(false);
                        PbActivity pbActivity = this.a;
                        str4 = this.a.q;
                        pbActivity.showToast(str4);
                        return;
                    }
                }
                bsVar = this.a.E;
                bsVar.c(true);
                bsVar2 = this.a.E;
                bsVar2.d(true);
            } else if (i == 22) {
                writeImagesInfo10 = this.a.m;
                int size = writeImagesInfo10.size();
                writeImagesInfo11 = this.a.m;
                if (size < writeImagesInfo11.getMaxImagesAllowed()) {
                    this.a.p = String.valueOf(System.currentTimeMillis());
                    PbActivity pbActivity2 = this.a;
                    str = this.a.p;
                    com.baidu.tbadk.core.util.ax.a(pbActivity2, str);
                    return;
                }
                this.a.showToast(String.format(this.a.getString(com.baidu.tieba.x.editor_mutiiamge_max), 10));
            } else if (i == 23) {
                writeImagesInfo7 = this.a.m;
                if (writeImagesInfo7 != null) {
                    writeImagesInfo8 = this.a.m;
                    if (!TextUtils.isEmpty(writeImagesInfo8.toJsonString())) {
                        PbActivity pbActivity3 = this.a;
                        writeImagesInfo9 = this.a.m;
                        com.baidu.tbadk.core.atomData.b bVar = new com.baidu.tbadk.core.atomData.b(pbActivity3, writeImagesInfo9.toJsonString());
                        bVar.setRequestCode(12002);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, bVar));
                    }
                }
            } else if (i != 13) {
                if (i != 7) {
                    if (i == 42) {
                        int intValue = ((Integer) obj).intValue();
                        writeImagesInfo3 = this.a.m;
                        if (writeImagesInfo3 != null) {
                            writeImagesInfo4 = this.a.m;
                            if (writeImagesInfo4.getChosedFiles() != null) {
                                writeImagesInfo5 = this.a.m;
                                int size2 = writeImagesInfo5.getChosedFiles().size();
                                if (size2 >= 1 && intValue >= 0 && intValue < size2) {
                                    MessageManager messageManager = MessageManager.getInstance();
                                    PbActivity pbActivity4 = this.a;
                                    writeImagesInfo6 = this.a.m;
                                    messageManager.sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.ch(pbActivity4, 12012, writeImagesInfo6, intValue)));
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    } else if (i == 48) {
                        com.baidu.tieba.e.a.c();
                        if (!com.baidu.tieba.e.a.a()) {
                            blVar = this.a.y;
                            if (blVar.m() == 0) {
                                this.a.showToast(com.baidu.tieba.x.baobao_over_limit);
                                return;
                            }
                        }
                        com.baidu.tbadk.pluginArch.c a = com.baidu.tbadk.pluginArch.d.a().a("baobao");
                        if (a != null && (baobaoSdkDelegate = (BaobaoSdkDelegate) a.a(BaobaoSdkDelegate.class)) != null) {
                            baobaoSdkDelegate.startMatchImage(this.a, this.a.getResources().getString(com.baidu.tieba.x.send_reply), 12013);
                            return;
                        }
                        return;
                    } else if (i == 51) {
                        writeImagesInfo = this.a.n;
                        if (writeImagesInfo != null) {
                            writeImagesInfo2 = this.a.n;
                            if (writeImagesInfo2.size() > 0) {
                                writeData2 = this.a.o;
                                writeData2.setIsBaobao(true);
                                return;
                            }
                        }
                        writeData = this.a.o;
                        writeData.setIsBaobao(false);
                        return;
                    } else {
                        return;
                    }
                }
                alertDialog = this.a.ai;
                if (alertDialog == null) {
                    this.a.m();
                }
                alertDialog2 = this.a.ai;
                if (alertDialog2 == null) {
                    return;
                }
                alertDialog3 = this.a.ai;
                com.baidu.adp.lib.e.e.a(alertDialog3, this.a);
            }
        } else {
            b = this.a.b(11027);
            if (b) {
                bsVar5 = this.a.E;
                this.a.b(bsVar5.P());
            }
        }
    }
}
