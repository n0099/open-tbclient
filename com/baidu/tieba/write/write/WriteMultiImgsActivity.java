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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.frs.ForumWriteData;
/* loaded from: classes3.dex */
public class WriteMultiImgsActivity extends BaseActivity {
    private h jLj;
    private i jNt;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.jLj = new h(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cyt() {
                WriteMultiImgsActivity.this.jNt.czv();
                WriteMultiImgsActivity.this.jNt.sb(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cyu() {
                WriteMultiImgsActivity.this.jNt.czA();
                WriteMultiImgsActivity.this.jNt.sb(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean P(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.jNt.R(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cyv() {
                WriteMultiImgsActivity.this.jNt.cyv();
            }
        });
        setContentView(this.jLj.eYE);
        this.jNt = new i(getPageContext(), this.jLj, bundle);
        if (this.jNt.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.jNt.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.jNt != null && this.jNt.jND != null) {
            bundle.putInt("OutState_Current_Index", this.jNt.jND.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.jNt.czy());
            bundle.putSerializable("OutState_Write_Info_Data", this.jNt.bkp());
            this.jNt.jND.rW(true);
            if (this.jNt.czB() != null) {
                bundle.putString("OutState_Write_Img_Info", this.jNt.czB().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void czv() {
        if (this.jNt != null) {
            this.jNt.czv();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.jNt != null) {
            if (1 == this.jNt.czy()) {
                ForumWriteData bkp = this.jNt.bkp();
                if (bkp != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, bkp.forumId, bkp.forumName, null, null, 0, bkp.antiData, 13003, false, false, null, false, false, null, null, bkp.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", bkp.mFrom);
                    writeActivityConfig.setCallFrom(bkp.writeCallFrom);
                    writeActivityConfig.setForumLevel(bkp.forumLevel);
                    writeActivityConfig.setForumAvatar(bkp.avatar);
                    writeActivityConfig.setPrivateThread(bkp.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                }
            } else if (2 == this.jNt.czy()) {
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
                if (!v.aa(writeImagesInfo.getChosedFiles()) && writeImagesInfo.getChosedFiles().get(0) != null) {
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
        if (this.jLj != null) {
            this.jLj.CH(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.jNt != null) {
            this.jNt.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.jLj != null) {
            this.jLj.onDestroy();
        }
        super.onDestroy();
    }
}
