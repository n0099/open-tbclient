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
    private i hAA;
    private h hyr;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.hyr = new h(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bHi() {
                WriteMultiImgsActivity.this.hAA.bIk();
                WriteMultiImgsActivity.this.hAA.nE(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bHj() {
                WriteMultiImgsActivity.this.hAA.bIp();
                WriteMultiImgsActivity.this.hAA.nE(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean F(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.hAA.H(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bHk() {
                WriteMultiImgsActivity.this.hAA.bHk();
            }
        });
        setContentView(this.hyr.cWq);
        this.hAA = new i(getPageContext(), this.hyr, bundle);
        if (this.hAA.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.hAA.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.hAA != null && this.hAA.hAK != null) {
            bundle.putInt("OutState_Current_Index", this.hAA.hAK.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.hAA.bIn());
            bundle.putSerializable("OutState_Write_Info_Data", this.hAA.auG());
            this.hAA.hAK.nz(true);
            if (this.hAA.bIq() != null) {
                bundle.putString("OutState_Write_Img_Info", this.hAA.bIq().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bIk() {
        if (this.hAA != null) {
            this.hAA.bIk();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.hAA != null) {
            if (1 == this.hAA.bIn()) {
                ForumWriteData auG = this.hAA.auG();
                if (auG != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, auG.forumId, auG.forumName, null, null, 0, auG.antiData, 13003, false, false, null, false, false, null, null, auG.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", auG.mFrom);
                    writeActivityConfig.setCallFrom(auG.writeCallFrom);
                    writeActivityConfig.setForumLevel(auG.forumLevel);
                    writeActivityConfig.setForumAvatar(auG.avatar);
                    writeActivityConfig.setPrivateThread(auG.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                }
            } else if (2 == this.hAA.bIn()) {
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
        if (this.hyr != null) {
            this.hyr.vK(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.hAA != null) {
            this.hAA.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.hyr != null) {
            this.hyr.onDestroy();
        }
        super.onDestroy();
    }
}
