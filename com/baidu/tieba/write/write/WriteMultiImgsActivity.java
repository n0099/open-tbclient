package com.baidu.tieba.write.write;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.frs.ForumWriteData;
/* loaded from: classes2.dex */
public class WriteMultiImgsActivity extends BaseActivity {
    private g hIs;
    private boolean hKt = true;
    private h hKu;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2 = 1;
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.hKt = false;
        this.hIs = new g(getPageContext(), this.hKt, new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bHm() {
                WriteMultiImgsActivity.this.hKu.bIl();
                WriteMultiImgsActivity.this.hKu.nL(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bHn() {
                WriteMultiImgsActivity.this.hKu.bIm();
                WriteMultiImgsActivity.this.hKu.nL(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean A(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.hKu.C(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bHo() {
                WriteMultiImgsActivity.this.hKu.bHo();
            }
        });
        setContentView(this.hIs.dpv);
        this.hKu = new h(getPageContext(), this.hIs, bundle);
        if (this.hKt) {
            if (this.hKu.bIr() != null) {
                i = this.hKu.bIr().size();
                i2 = this.hKu.bIr().size();
            } else {
                i = 1;
            }
            TbadkCoreApplication.getInst().sendImagePv(i, i2, "motu_pic");
        }
        if (this.hIs != null) {
            this.hIs.xP(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.hKu != null && this.hKu.hKG != null) {
            bundle.putInt("OutState_Current_Index", this.hKu.hKG.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.hKu.bIp());
            bundle.putSerializable("OutState_Write_Info_Data", this.hKu.auu());
            this.hKu.hKG.nD(true);
            if (this.hKu.bIr() != null) {
                bundle.putString("OutState_Write_Img_Info", this.hKu.bIr().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bIl() {
        if (this.hKu != null) {
            this.hKu.bIl();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bIm() {
        if (this.hKu != null) {
            this.hKu.bIm();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.hKu != null) {
            if (1 == this.hKu.bIp()) {
                ForumWriteData auu = this.hKu.auu();
                if (auu != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, auu.forumId, auu.forumName, null, null, 0, auu.antiData, 13003, false, false, null, false, false, null, null, auu.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", auu.mFrom);
                    writeActivityConfig.setCallFrom(auu.writeCallFrom);
                    writeActivityConfig.setForumLevel(auu.forumLevel);
                    writeActivityConfig.setForumAvatar(auu.avatar);
                    writeActivityConfig.setPrivateThread(auu.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            } else if (2 == this.hKu.bIp()) {
                Intent intent = new Intent(this, WriteActivity.class);
                intent.putExtra("KEY_WRITE_IMAGES_INFO_STRING", writeImagesInfo.toJsonString());
                intent.setFlags(536870912);
                intent.setFlags(67108864);
                startActivity(intent);
                finish();
                return;
            }
        }
        if (z) {
            if (writeImagesInfo != null) {
                Intent intent2 = new Intent();
                intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, writeImagesInfo.toJsonString());
                if (!v.E(writeImagesInfo.getChosedFiles()) && writeImagesInfo.getChosedFiles().get(0) != null) {
                    intent2.putExtra("file_name", writeImagesInfo.getChosedFiles().get(0).extra);
                }
                setResult(-1, intent2);
            } else {
                return;
            }
        } else {
            setResult(0);
        }
        finish();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        setResult(0);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hIs != null) {
            this.hIs.xP(i);
        }
    }
}
