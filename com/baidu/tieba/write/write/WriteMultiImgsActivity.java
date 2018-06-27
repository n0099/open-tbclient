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
    private h hxk;
    private i hzs;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.hxk = new h(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bIw() {
                WriteMultiImgsActivity.this.hzs.bJx();
                WriteMultiImgsActivity.this.hzs.nQ(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bIx() {
                WriteMultiImgsActivity.this.hzs.bJC();
                WriteMultiImgsActivity.this.hzs.nQ(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean G(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.hzs.I(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bIy() {
                WriteMultiImgsActivity.this.hzs.bIy();
            }
        });
        setContentView(this.hxk.cTD);
        this.hzs = new i(getPageContext(), this.hxk, bundle);
        if (this.hzs.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.hzs.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.hzs != null && this.hzs.hzC != null) {
            bundle.putInt("OutState_Current_Index", this.hzs.hzC.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.hzs.bJA());
            bundle.putSerializable("OutState_Write_Info_Data", this.hzs.auc());
            this.hzs.hzC.nL(true);
            if (this.hzs.bJD() != null) {
                bundle.putString("OutState_Write_Img_Info", this.hzs.bJD().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bJx() {
        if (this.hzs != null) {
            this.hzs.bJx();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.hzs != null) {
            if (1 == this.hzs.bJA()) {
                ForumWriteData auc = this.hzs.auc();
                if (auc != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, auc.forumId, auc.forumName, null, null, 0, auc.antiData, 13003, false, false, null, false, false, null, null, auc.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", auc.mFrom);
                    writeActivityConfig.setCallFrom(auc.writeCallFrom);
                    writeActivityConfig.setForumLevel(auc.forumLevel);
                    writeActivityConfig.setForumAvatar(auc.avatar);
                    writeActivityConfig.setPrivateThread(auc.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                }
            } else if (2 == this.hzs.bJA()) {
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
                if (!w.A(writeImagesInfo.getChosedFiles()) && writeImagesInfo.getChosedFiles().get(0) != null) {
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
        if (this.hxk != null) {
            this.hxk.vL(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.hzs != null) {
            this.hzs.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.hxk != null) {
            this.hxk.onDestroy();
        }
        super.onDestroy();
    }
}
