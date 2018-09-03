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
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.frs.ForumWriteData;
/* loaded from: classes3.dex */
public class WriteMultiImgsActivity extends BaseActivity {
    private i hAC;
    private h hyt;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.hyt = new h(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bHm() {
                WriteMultiImgsActivity.this.hAC.bIo();
                WriteMultiImgsActivity.this.hAC.nE(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bHn() {
                WriteMultiImgsActivity.this.hAC.bIt();
                WriteMultiImgsActivity.this.hAC.nE(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean F(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.hAC.H(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bHo() {
                WriteMultiImgsActivity.this.hAC.bHo();
            }
        });
        setContentView(this.hyt.cWm);
        this.hAC = new i(getPageContext(), this.hyt, bundle);
        if (this.hAC.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.hAC.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.hAC != null && this.hAC.hAM != null) {
            bundle.putInt("OutState_Current_Index", this.hAC.hAM.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.hAC.bIr());
            bundle.putSerializable("OutState_Write_Info_Data", this.hAC.auF());
            this.hAC.hAM.nz(true);
            if (this.hAC.bIu() != null) {
                bundle.putString("OutState_Write_Img_Info", this.hAC.bIu().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bIo() {
        if (this.hAC != null) {
            this.hAC.bIo();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.hAC != null) {
            if (1 == this.hAC.bIr()) {
                ForumWriteData auF = this.hAC.auF();
                if (auF != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, auF.forumId, auF.forumName, null, null, 0, auF.antiData, 13003, false, false, null, false, false, null, null, auF.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", auF.mFrom);
                    writeActivityConfig.setCallFrom(auF.writeCallFrom);
                    writeActivityConfig.setForumLevel(auF.forumLevel);
                    writeActivityConfig.setForumAvatar(auF.avatar);
                    writeActivityConfig.setPrivateThread(auF.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                }
            } else if (2 == this.hAC.bIr()) {
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
                if (!w.z(writeImagesInfo.getChosedFiles()) && writeImagesInfo.getChosedFiles().get(0) != null) {
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
        if (this.hyt != null) {
            this.hyt.vK(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.hAC != null) {
            this.hAC.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.hyt != null) {
            this.hyt.onDestroy();
        }
        super.onDestroy();
    }
}
