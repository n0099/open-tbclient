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
    private h jTo;
    private i jVy;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.jTo = new h(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cBM() {
                WriteMultiImgsActivity.this.jVy.cCO();
                WriteMultiImgsActivity.this.jVy.sr(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cBN() {
                WriteMultiImgsActivity.this.jVy.cCT();
                WriteMultiImgsActivity.this.jVy.sr(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean P(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.jVy.R(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cBO() {
                WriteMultiImgsActivity.this.jVy.cBO();
            }
        });
        setContentView(this.jTo.fef);
        this.jVy = new i(getPageContext(), this.jTo, bundle);
        if (this.jVy.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.jVy.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.jVy != null && this.jVy.jVI != null) {
            bundle.putInt("OutState_Current_Index", this.jVy.jVI.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.jVy.cCR());
            bundle.putSerializable("OutState_Write_Info_Data", this.jVy.bmB());
            this.jVy.jVI.sm(true);
            if (this.jVy.cCU() != null) {
                bundle.putString("OutState_Write_Img_Info", this.jVy.cCU().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cCO() {
        if (this.jVy != null) {
            this.jVy.cCO();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.jVy != null) {
            if (1 == this.jVy.cCR()) {
                ForumWriteData bmB = this.jVy.bmB();
                if (bmB != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, bmB.forumId, bmB.forumName, null, null, 0, bmB.antiData, 13003, false, false, null, false, false, null, null, bmB.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", bmB.mFrom);
                    writeActivityConfig.setCallFrom(bmB.writeCallFrom);
                    writeActivityConfig.setForumLevel(bmB.forumLevel);
                    writeActivityConfig.setForumAvatar(bmB.avatar);
                    writeActivityConfig.setPrivateThread(bmB.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                }
            } else if (2 == this.jVy.cCR()) {
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
        if (this.jTo != null) {
            this.jTo.Dq(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.jVy != null) {
            this.jVy.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.jTo != null) {
            this.jTo.onDestroy();
        }
        super.onDestroy();
    }
}
